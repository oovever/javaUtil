package util;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by OovEver on 2017/11/19.
 * 1.将图像转化为jpg格式
 * 2.修改图像的大小
 */
public class ImageUtil {
    /***
     *
     * @param f 图片名称
     * @return 转化为jpg后的图片
     */
    public static BufferedImage change2jpg(File f) {
        try {
            Image        i  = Toolkit.getDefaultToolkit().createImage(f.getAbsolutePath());
            PixelGrabber pg = new PixelGrabber(i, 0, 0, -1, -1, true);
            pg.grabPixels();
            int              width      = pg.getWidth(), height = pg.getHeight();
            final int[]      RGB_MASKS  = { 0xFF0000, 0xFF00, 0xFF };
            final ColorModel RGB_OPAQUE = new DirectColorModel(32, RGB_MASKS[0], RGB_MASKS[1], RGB_MASKS[2]);
            DataBuffer       buffer     = new DataBufferInt((int[]) pg.getPixels(), pg.getWidth() * pg.getHeight());
            WritableRaster   raster     = Raster.createPackedRaster(buffer, width, height, width, RGB_MASKS, null);
            BufferedImage    img        = new BufferedImage(RGB_OPAQUE, raster, false, null);
            return img;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        }
    }

    /***
     *  重置图片大小
     * @param srcFile 原图片
     * @param width 新的宽度
     * @param height 新的高度
     * @param destFile 转化后的图片
     */
    public static void resizeImage(File srcFile, int width, int height, File destFile) {
        try {
            if(!destFile.getParentFile().exists())
                destFile.getParentFile().mkdirs();
            Image i = ImageIO.read(srcFile);
            i = resizeImage(i, width, height);
            ImageIO.write((RenderedImage) i, "jpg", destFile);
        } catch (IOException e) {
            System.out.println("文件不存在");
            e.printStackTrace();
        }
    }

    public static Image resizeImage(Image srcImage, int width, int height) {
        try {

            BufferedImage buffImg = null;
            buffImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            buffImg.getGraphics().drawImage(srcImage.getScaledInstance(width, height, Image.SCALE_SMOOTH), 0, 0, null);

            return buffImg;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
