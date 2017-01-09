package aplicacion.movil.alfabetizar;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.Display;
import android.view.View;
import android.widget.ImageView;



public class ImageViewPopUpHelper {
    private Activity context;
    private Drawable imageViewDrawable;
    private int finalImageWidth;
    private int finalImageHeight;
    private boolean requireResizingOfBitmap;
    private ImageView poppedImageView;
    private Dialog dialog;

    public ImageViewPopUpHelper() {
    }

    private void cacheResizedImage(ImageView imageView) {
        this.imageViewDrawable = imageView.getDrawable();
        imageViewDrawable = ImageViewPopUpHelper.this.scaleImage(imageViewDrawable,3.5f);
        int imageRealWidth = this.imageViewDrawable.getIntrinsicWidth();
        int imageRealHeight = this.imageViewDrawable.getIntrinsicHeight();
        Point screenDimensions = this.getScreenDimensions(this.context);
        int screenWidth = screenDimensions.x;

        for(int screenHeight = screenDimensions.y; imageRealWidth >= screenWidth || imageRealHeight >= screenHeight; this.requireResizingOfBitmap = true) {
            imageRealWidth = (int)((double)imageRealWidth * 0.9D);
            imageRealHeight = (int)((double)imageRealHeight * 0.9D);
        }

        this.finalImageWidth = imageRealWidth;
        this.finalImageHeight = imageRealHeight;
        if(this.requireResizingOfBitmap) {
            Bitmap bitmap = this.drawableToBitmap(this.imageViewDrawable);
            BitmapDrawable resizedBitmapDrawable = new BitmapDrawable(this.context.getResources(), Bitmap.createScaledBitmap(bitmap, this.finalImageWidth, this.finalImageHeight, false));
            this.poppedImageView.setBackgroundDrawable(resizedBitmapDrawable);
        } else {
            this.poppedImageView.setBackgroundDrawable(this.imageViewDrawable);
        }

    }

    public static void enablePopUpOnClick(Activity context, ImageView imageView) {
        (new ImageViewPopUpHelper()).internalEnablePopUpOnClick(context, imageView);
    }

    private void internalEnablePopUpOnClick(Activity context, ImageView imageView) {
        this.context = context;
        this.poppedImageView = new ImageView(context);
        this.dialog = new Dialog(context);
        this.dialog.requestWindowFeature(1);
        this.dialog.setContentView(this.poppedImageView);
        this.dialog.getWindow().setBackgroundDrawable((Drawable) null);
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        this.dialog.setCanceledOnTouchOutside(true);
        imageView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ImageView imageView = (ImageView)v;
                if(ImageViewPopUpHelper.this.imageViewDrawable != imageView.getDrawable()) {
                    ImageViewPopUpHelper.this.cacheResizedImage(imageView);
                }

                ImageViewPopUpHelper.this.dialog.show();
            }
        });
    }

    private Point getScreenDimensions(Activity context) {
        Display display = context.getWindowManager().getDefaultDisplay();
        Point size = new Point();
        int currentapiVersion = Build.VERSION.SDK_INT;
        if(currentapiVersion >= 17) {
            display.getRealSize(size);
        } else if(currentapiVersion >= 13) {
            display.getSize(size);
        } else {
            size.x = display.getWidth();
            size.y = display.getHeight();
        }

        return size;
    }

    private Bitmap drawableToBitmap(Drawable drawable) {
        if(drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable)drawable).getBitmap();
        } else {
            Bitmap bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
            return bitmap;
        }
    }

    public Drawable scaleImage (Drawable image, float scaleFactor) {

        if ((image == null) || !(image instanceof BitmapDrawable)) {
            return image;
        }

        Bitmap b = ((BitmapDrawable)image).getBitmap();

        int sizeX = Math.round(image.getIntrinsicWidth() * scaleFactor);
        int sizeY = Math.round(image.getIntrinsicHeight() * scaleFactor);

        Bitmap bitmapResized = Bitmap.createScaledBitmap(b, sizeX, sizeY, false);

        image = new BitmapDrawable(context.getResources(), bitmapResized);

        return image;
    }
}
