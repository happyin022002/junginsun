/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DownloadExcelViewAdapter.java
*@FileTitle : DownloadExcelViewAdapter
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.15
*@LastModifier : 
*@LastVersion : 1.0
* 1.0 Creation
* 2012.10.04 변종건 [CHM-201220395] Add-on Tariff Management 개선 프로젝트
=========================================================*/
package com.hanjin.apps.alps.esd.aoc.common.aoccommon.event;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.ViewAdapter;
import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;

/**
 *
 * @author 
 * @see HTMLAction 참조
 * @since J2EE 1.6
 */
public class DownloadExcelViewAdapter extends ViewAdapter {
	
    public DownloadExcelViewAdapter(){
    	super();
    }
    
	/**
	 * View Adapter 생성시 자동으로 호출된다.<br>
	 *  <br>
	 * 
	 * @param HttpServletRequest request
	 * @param HttpServletResponse response
	 * @return String
	 * @exception EventException
	 */	      
    public String makeXML(HttpServletRequest request, HttpServletResponse response) {
    	GeneralEventResponse eventResponse = (GeneralEventResponse)request.getAttribute("EventResponse"); 
 		
 		StringBuilder strBuilder = new StringBuilder();
    	DBRowSet rowSet = null;							   	//DB ResultSet
    	String savedName = "sheet1.csv";  
 		
    	rowSet = (DBRowSet)eventResponse.getCustomData("rowset");
    	String[] title = (String[])eventResponse.getCustomData("title");
    	String[] title2 = (String[])eventResponse.getCustomData("title2");
    	savedName = (String)eventResponse.getCustomData("fileName");
		
		try{			
    		if(rowSet != null){
    			for(int i =0; i < title.length; i ++){
					strBuilder.append(title[i]);
					strBuilder.append(",");    				
    			}
    			strBuilder.append("\n");
    			for(int i =0; i < title2.length; i ++){
					strBuilder.append(title2[i]);
					strBuilder.append(",");    				
    			}
    			strBuilder.append("\n");
				while(rowSet.next()){
					for(int k=1; k<=rowSet.getMetaData().getColumnCount(); k++){
							strBuilder.append(JSPUtil.getNull(rowSet.getString(k)).trim().replaceAll(",", ""));
							strBuilder.append(",");
					}
					strBuilder.append("\n");
				}
			}  
     			
 			response.reset();
 			response.setContentType("application/vnd.ms.excel");
 			String strClient = request.getHeader("user-agent");
 
 			if (strClient.indexOf("MSIE 5.5") != -1) {
 				response.setHeader("Content-Type",
 						"doesn/matter; charset=euc-kr");
 				response.setHeader("Content-Disposition", "filename="
 						+ savedName + "; charset=euc-kr");
 			} else {
 				response.setHeader("Content-Type",
 						"application/octet-stream; charset=euc-kr");
 				response.setHeader("Content-Disposition",
 						"attachment;filename=" + savedName + ";");
 			} 			     		
     		
    		PrintWriter pout = response.getWriter();
			pout.print(strBuilder.toString());
			pout.flush();
			pout.close();
    				    
        }    	
    	catch(Exception ex){
            log.error(ex.getMessage(), ex);
            throw new RuntimeException(ex.getMessage());
        }    	
    	return "";
    }
    
    /*
 	 * (non-Javadoc)
 	 * 
 	 * @see
 	 * com.hanjin.framework.core.controller.ViewAdapter#makeDataTag(java.util
 	 * .List, java.lang.String)
 	 */
 	protected String makeDataTag(List<AbstractValueObject> arg0, String arg1) {
 		return null;
 	}
 
 	/*
 	 * (non-Javadoc)
 	 * 
 	 * @see
 	 * com.hanjin.framework.core.controller.ViewAdapter#makeDataTag(com.hanjin
 	 * .framework.component.rowset.DBRowSet, java.lang.String)
 	 */
 	protected String makeDataTag(DBRowSet arg0, String arg1) {
 		return null;
 	}
}
