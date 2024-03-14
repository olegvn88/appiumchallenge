package com.olnester.context;

import com.olnester.pages.CarouselPage;
import com.olnester.pages.DoubleTapDemoPage;
import com.olnester.pages.DragDropPage;
import com.olnester.pages.LongPressPage;
import com.olnester.pages.NativeViewDemoPage;
import com.olnester.pages.PhotoViewPage;
import com.olnester.pages.SamplesListPage;
import com.olnester.pages.SliderPage;
import com.olnester.pages.SubmitPage;
import com.olnester.pages.VerticalSwipingPage;
import com.olnester.pages.WebViewPage;
import com.olnester.pages.WheelPickerPage;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TestContext {
    private SamplesListPage samplesListPage;
    private NativeViewDemoPage nativeViewDemoPage;
    private SliderPage sliderPage;
    private VerticalSwipingPage verticalSwipingPage;
    private DragDropPage dragDropPage;
    private DoubleTapDemoPage doubleTapDemoPage;
    private LongPressPage longPressPage;
    private PhotoViewPage photoViewPage;
    private WebViewPage webViewPage;
    private CarouselPage carouselPage;
    private WheelPickerPage wheelPickerPage;
    private SubmitPage submitPage;
}
