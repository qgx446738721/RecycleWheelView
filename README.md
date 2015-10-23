#RecycleWheelView
基于Recycle实现，内部内容可以自定义，但是请保证高度（滚动方向为垂直方向）或者宽度（滚动方向为水平方向）相同

##用法
**xml**
```xml
<org.voiddog.lib.recyclewheelview.RecycleWheelView
        android:id="@+id/rv_wheel"
        app:recycleWheelDirection="vertical"
        app:recycleWheelLinePadding="10dp"
        app:recycleWheelLineColor="@color/colorPrimary"
        app:recycleWheelLineThickness="1dp"
        android:layout_width="200dp"
        android:layout_height="200dp"/>
```
**java**
```java
TextWheelAdapter<String> mAdapter;
mAdapter.setTextPadding(dp2px(this, 15));
mAdapter.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25);

rv_wheel = (RecycleWheelView) findViewById(R.id.rv_wheel);
rv_wheel.setOnSelectListener(new RecycleWheelView.OnSelectItemListener() {
            @Override
            public void onSelectChanged(int position) {
                Toast.makeText(
                MainActivity.this
                , String.format("select at: %d", position)
                , Toast.LENGTH_SHORT
                ).show();
            }
        });

rv_wheel.setAdapter(mAdapter);
```

![预览](https://raw.githubusercontent.com/qgx446738721/RecycleWheelView/master/art/preview.png)
