package cn.a7e7.aspect;


//切面类：可以存在多个同志Advice（即增强的方法）
public class MyAspect {
	public void chak_Permissions() {
		System.out.println("模拟检查权限。。。");
	}
	public void log() {
		System.out.println("模拟记录日志。。。");
	}

}
