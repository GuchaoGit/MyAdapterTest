# MyAdapterTest适配器使用示例

添加Pandora测试工具  
添加CardAdapter,实现可左右滑动的Card视图布局  
添加SwipeCardView,实现滑动切换的Card视图布局  
日历控件功能添加  
RecyclerView添加header和foot  
AIDL使用示例  

ViewPager2使用  
条件：
1. Androidx和Android support库不能共存，Viewpager2需在Androidx环境下使用
* 选择工程右键→Refactor→Migrate to Androidx 
2. 项目迁移后butterKnife出现变异报错  
* butterKnife需更新至最新版本  

使用  
1. ViewPager2可以像RecyclerView一样使用，并且可以配滑动方向了。我们只需要一个ViewPager2、一套ViewHolder，一个Adapter
2. 结合Fragment的使用  
3. 懒、预加载和状态恢复  



