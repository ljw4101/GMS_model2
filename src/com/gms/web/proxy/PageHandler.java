package com.gms.web.proxy;

//한 페이지의 rownum 범위
public class PageHandler {
	public static int[] attr(PageProxy pxy){
		int[] result = new int[2];
		int startRow = 0, endRow = 0;
		
		if(pxy.getPageNumber() <= pxy.getTheNumberOfRows()/pxy.getPageSize()+1){
			if(pxy.getPageNumber() == 1){
				startRow = 1;
				endRow = pxy.getPageSize();
			}else{
				startRow = (pxy.getPageNumber() - 1)*pxy.getPageSize() + 1;
				endRow = pxy.getPageNumber() * pxy.getPageSize();
			}
		}
		
		result[0] = startRow;
		result[1] = endRow;
		
		System.out.println("*** PageHandler ***");
		System.out.println("startRow: "+result[0]+" / endRow: "+result[1]);
		
		return result;
	}
}
