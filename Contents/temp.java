package com.feng.android.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * 
 * Percent view to show percent
 * 
 * @author fengjun
 *
 */
public class PercentView extends View {
	
	private static final int DEFAULT_WIDTH = 200;
	private static final int DEFAULT_PERCENT = 25;
	private static final int MAX_PERCENT = 100;
	
	private int mWidth = DEFAULT_WIDTH;
	private int mPercentValue = DEFAULT_PERCENT;
	private int mCircleX;
	private int mCircleY;
	
	private float mRadius;

	private RectF mArcRectF;
	
	private Paint mCirclePaint;
	private Paint mArcPaint;
	private Paint mTextPaint;
	
	public PercentView(Context context) {
		super(context);
		init();
	}

	public PercentView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}

	public PercentView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init();
	}
	
	private void init() {
		mCirclePaint = new Paint();
		mCirclePaint.setColor(Color.GREEN);
		
		mArcPaint = new Paint();
		mArcPaint.setColor(Color.RED);
		
		mTextPaint = new Paint();
		mTextPaint.setColor(Color.YELLOW);
		
		mCircleX = mWidth / 2;
		mCircleY = mWidth / 2;
		mRadius = (float) (mWidth * 0.5 / 2);
		mArcRectF = new RectF((float)(mWidth * 0.1), (float)(mWidth * 0.1), (float)(mWidth * 0.9), (float)(mWidth * 0.9));
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		
		canvas.drawCircle(mCircleX, mCircleY, mRadius, mCirclePaint);
	}

}
