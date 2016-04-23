package edu.l3m4rk.yandextask.controller.listener;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnItemTouchListener;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;

public final class RecyclerViewItemClickListener implements OnItemTouchListener {

    private final GestureDetector mGestureDetector;
    private final OnItemClickListener mListener;

    public interface OnItemClickListener {
        void onItemClick(@NonNull View view, int position);
    }

    private static class UpSimpleOnGestureListener extends SimpleOnGestureListener {
        private UpSimpleOnGestureListener() {
        }

        @Override
        public boolean onSingleTapUp(MotionEvent e) {
            return true;
        }
    }

    public RecyclerViewItemClickListener(@NonNull Context context, OnItemClickListener listener) {
        mGestureDetector = new GestureDetector(context, new UpSimpleOnGestureListener());
        mListener = listener;
    }

    @Override
    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
        View childView = rv.findChildViewUnder(e.getX(), e.getY());
        if (childView != null && mGestureDetector.onTouchEvent(e)) {
            mListener.onItemClick(childView, rv.getChildAdapterPosition(childView));
        }
        return false;
    }

    @Override
    public void onTouchEvent(RecyclerView rv, MotionEvent e) {
    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

    }
}
