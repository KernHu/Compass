package org.gztech.compass.view;

import android.content.Context;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

/**
 * @author ����:
 * @date 2016-4-12 ����4:51:15
 * @version 1.0
 * @parameter
 * @since
 * @return
 */
public class DialView extends View {

	private Paint mPaint;
	private Camera mCamera;
	private Matrix mMatrix;
	private Path mPath;
	private float mCenterX;
	private float mCenterY;
	private float mRadius;
	private int mBgColor;

	public DialView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	public DialView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub

		// �õ�����
		mPaint = new Paint();
		// �����
		mPaint.setAntiAlias(true);
		// ���û�����ɫ
		//Color.parseColor("227BAE");
		mPaint.setColor(Color.GREEN);

		//mPath = new Path();

		mCamera = new Camera();
		mMatrix = new Matrix();
	}

	public DialView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);

		mCenterX = getWidth() / 2;
		mCenterY = getHeight() / 2;
		// Բ�İ뾶ȡ���ڿ�͸�����С���Ǹ�ֵ
		mRadius = mCenterX > mCenterY ? mCenterY : mCenterX;

		// ���û�������ɫ
		canvas.drawColor(Color.TRANSPARENT);
		// ����Բ��
		canvas.drawCircle(mCenterX, mCenterY, mRadius, mPaint);

		// ��������ϵ
		canvas.save();
		// �����̶���
		mPaint.setColor(Color.YELLOW);
		for (int i = 0; i < 360; i++) {

			canvas.rotate(3, mCenterX, mCenterY);
			canvas.drawLine(mCenterX, 150, mCenterX, 170, mPaint);
		}
		// �ָ�����ϵ
		canvas.restore();
	}
}
