package company.zzw.john.progessbuttondemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.Button;

/**
 * 这是一个进度按钮   用来在按钮上显示进度
 * <p/>
 * Created by ZheWei on 2016/6/16.
 */
public class ProgressButton extends Button {

    private boolean mProgessEnable; //是否允许显示进度
    private long mMax = 100;  //最大的 进度值
    private long mProgress;  //当前的进度值
    private Drawable mProgressDrawable; //  ProgressButton的背景图片

    /**
     * 设置是允许进度的显示
     *
     * @param isProgessEnable
     */
    public void setIsProgessEnable(boolean isProgessEnable) {
        this.mProgessEnable = isProgessEnable;
    }


    /**
     * 设置最大进度值
     *
     * @param max
     */
    public void setMax(long max) {
        mMax = max;
    }


    /**
     * 设置当前的进度值 , 并且进行重复的刷新操作 -->即重绘(invalidate())
     *
     * @param progress
     */
    public void setProgress(long progress) {
        mProgress = progress;
        invalidate(); //设置 频繁的刷新UI
    }


    /**
     * 设置 该进度按钮的背景图片
     *
     * @param progressDrawable
     */
    public void setProgressDrawable(Drawable progressDrawable) {
        mProgressDrawable = progressDrawable;
    }


    public ProgressButton(Context context) {
        super(context);
    }


    public ProgressButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    //onmeasure  onlayout ondraw


    @Override
    protected void onDraw(Canvas canvas) {

        if (mProgessEnable == true) {
            Drawable drawable = new ColorDrawable(getResources().getColor(R.color.colorPrimary));
            int left = 0;
            int top = 0;
            int right = (int) (mProgress * 1.0f / mMax * getMeasuredWidth() + .5f);
            int bottom = getBottom();
            drawable.setBounds(left, top, right, bottom);
            drawable.draw(canvas);
        }

        //最后绘制xml中的文本
        super.onDraw(canvas);  //绘制文本,还能够绘制背景
    }
}
