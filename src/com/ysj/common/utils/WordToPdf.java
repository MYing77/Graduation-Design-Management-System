package com.ysj.common.utils;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.ComThread;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;

/**
 *  * 效果最好的一种方法，但是需要 window 环境，而且速度是最慢的需要安装 msofficeWord 以及 SaveAsPDFandXPS.exe
 * (  * word 的一个插件，用来把 word 转化为 pdf，可以不用安装，本次未安装测试通过 )  *  *  *  
 */
public class WordToPdf {

	private static final int wdFormatPDF = 17; // PDF 格式

	public void wordToPDF(String sfileName, String toFileName) {

		System.out.println("启动 Word...");

		long start = System.currentTimeMillis();
		ActiveXComponent app = null;
		Dispatch doc = null;
		try {
			app = new ActiveXComponent("Word.Application");
			app.setProperty("Visible", new Variant(false));
			Dispatch docs = app.getProperty("Documents").toDispatch();
			doc = Dispatch.call(docs, "Open", sfileName).toDispatch();
			System.out.println("打开文档..." + sfileName);
			System.out.println("转换文档到 PDF..." + toFileName);
			File tofile = new File(toFileName);
			if (tofile.exists()) {
				tofile.delete();
			}
			Dispatch.call(doc, "SaveAs", toFileName, // FileName
					wdFormatPDF);
			long end = System.currentTimeMillis();
			System.out.println("转换完成..用时：" + (end - start) + "ms.");

		} catch (Exception e) {
			System.out.println("========Error:文档转换失败：" + e.getMessage());
		} finally {
			Dispatch.call(doc, "Close", false);
			System.out.println("关闭文档");
			if (app != null)
				app.invoke("Quit", new Variant[] {});
		}
		// 如果没有这句话,winword.exe进程将不会关闭
		ComThread.Release();
	}

	public static void main(String[] args,HttpServletRequest request) {
		
	}
}
