/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : EsmPri0131ViewAdapterDL.java
*@FileTitle : EsmPri0131ViewAdapterDL
*Open Issues :
*Change history :
*@LastModifyDate : 2013.06.10
*@LastModifier : 이혜민
*@LastVersion : 1.0
* 2013.06.10 이혜민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.screport.screport.event;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hanjin.apps.alps.esm.pri.screport.screport.vo.RptSearchChargeSummaryReportBlInquiryRtnVO;
import com.hanjin.apps.alps.esm.pri.screport.screport.vo.RptSearchChargeSummaryReportBlInquiryVO;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.ViewAdapter;
import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;

/**
 * ESM_PRI_0131 에 대한 ViewAdapter<br>
 * - ESM_PRI_0131HTMLAction에서 작성<br>
 *
 * @author 이혜민
 * @see HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmPri0131ViewAdapterDL extends ViewAdapter {
	
    public EsmPri0131ViewAdapterDL(){
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
    	log.debug("########### EsmPri0131ViewAdapterDL ########### [START]");
    	GeneralEventResponse eventResponse = (GeneralEventResponse)request.getAttribute("EventResponse");
    	RptSearchChargeSummaryReportBlInquiryRtnVO listVo = (RptSearchChargeSummaryReportBlInquiryRtnVO)eventResponse.getRsVoList().get(0);
 		
 		StringBuilder strBuilder = new StringBuilder();
    	DBRowSet rowSet = null;							   	//DB ResultSet
    	@SuppressWarnings("unused")
		int rowCount	 = 0;								//DB ResultSet 리스트의 건수
    	RptSearchChargeSummaryReportBlInquiryVO blVo = null;
    	String savedName = "ESM_PRI_0131DL.csv";  
 		
    	rowSet = listVo.getRowSet();
        blVo = listVo.getRptSearchChargeSummaryReportBlInquiryVO();
		if(rowSet != null){
			 rowCount = rowSet.getRowCount();
		}
		
		try{			
    		if(rowSet != null){
				while(rowSet.next()){
					if(blVo.getFExcel().equals("N")){
						strBuilder.append("\n<tr><![CDATA[|");
						for(int k=1; k<=rowSet.getMetaData().getColumnCount(); k++){
							
							if(JSPUtil.getNull(rowSet.getString(k)).equals("")){
								strBuilder.append("|");
							} else {									
								strBuilder.append(JSPUtil.getNull(rowSet.getString(k)).trim().replaceAll("|", ""));											
								strBuilder.append("|");
							}
						}
						strBuilder.append("\n]]></tr>");
					}  else {													
						for(int k=1; k<=rowSet.getMetaData().getColumnCount(); k++){						
							if(JSPUtil.getNull(rowSet.getString(k)).equals("")){									
								strBuilder.append(JSPUtil.getNull(rowSet.getString(k)).trim().replaceAll(",", ""));
								strBuilder.append(",");
							} else {							
								strBuilder.append(JSPUtil.getNull(rowSet.getString(k)).trim().replaceAll(",", ""));
								strBuilder.append(",");
							}
						}
						strBuilder.append("\n");
					}						
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
 		
        log.debug("########### EsmPri0131ViewAdapterDL ########### [END]");
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
