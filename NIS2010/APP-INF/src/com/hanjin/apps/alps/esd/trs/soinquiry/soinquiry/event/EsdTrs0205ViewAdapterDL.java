
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsdTrs0028ViewAdapterDL.java
*@FileTitle : EsdTrs0028ViewAdapterDL
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.15
*@LastModifier : 박준용
*@LastVersion : 1.0
* 2009.12.15 박준용
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.soinquiry.soinquiry.event;

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
 * ESD_TRS_0128 에 대한 ViewAdapter<br>
 * - ESD_TRS_0128HTMLAction에서 작성<br>
 *
 * @author 박준용
 * @see HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsdTrs0205ViewAdapterDL extends ViewAdapter {
	
    public EsdTrs0205ViewAdapterDL(){
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
    	int rowCount	 = 0;								//DB ResultSet 리스트의 건수
    	String savedName = "ESD_TRS_0205DL.csv";  
 		
    	rowSet = (DBRowSet)eventResponse.getCustomData("rowset");
    	String[] title = (String[])eventResponse.getCustomData("title");
    	
		if(rowSet != null){
			 rowCount = rowSet.getRowCount();
		}
		
		PrintWriter pout = null;
 
		try{
			response.reset();
 		
 			response.setContentType("application/vnd.ms.excel; charset=UTF-8");
 			String strClient = request.getHeader("user-agent");
 			
 			if (strClient.indexOf("MSIE 5.5") != -1) {
 				response.setHeader("Content-Type","doesn/matter; charset=UTF-8");
 				response.setHeader("Content-Disposition", "filename=" + savedName + "; charset=UTF-8");
 			} else {
 				response.setHeader("Content-Type","application/octet-stream; charset=UTF-8");
 				response.setHeader("Content-Disposition","attachment;filename=" + savedName + ";");
 			} 
 			
 			pout = response.getWriter();
 			
 			//BOM UTF-8 Setting
// 			pout.write(0xEF);   
// 			pout.write(0xBB);
// 			pout.write(0xBF);  

    		if(rowSet != null){
    			for(int i =0; i < title.length; i ++){
					strBuilder.append(title[i]);
					strBuilder.append(",");    				
    			}
    			strBuilder.append("\n");
    			pout.print(strBuilder.toString());
				pout.flush();
				
    			int seq=0;
				while(rowSet.next()){
					strBuilder = new StringBuilder();
					if(seq==0){
						strBuilder.append("Seq.");
						strBuilder.append(",");
						seq++;
					}else{
						strBuilder.append(seq);
						strBuilder.append(",");	
						seq++;
					}

					for(int k=1; k<=rowSet.getMetaData().getColumnCount(); k++){
						strBuilder.append(JSPUtil.getNull(rowSet.getString(k)).trim().replaceAll(",", ""));
						strBuilder.append(",");
					}
					strBuilder.append("\n");
					pout.print(strBuilder.toString());
					pout.flush();
				}
			}
			pout.close();
			pout = null;
    				    
        } catch(Exception ex){
            log.error(ex.getMessage(), ex);
            throw new RuntimeException(ex.getMessage());
        } finally {
        	if(pout != null)	pout.close();
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
