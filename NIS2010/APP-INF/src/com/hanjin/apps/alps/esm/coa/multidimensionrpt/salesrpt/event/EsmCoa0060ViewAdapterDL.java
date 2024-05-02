/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmCoa0060ViewAdapterDL.java
*@FileTitle : EsmCoa0060ViewAdapterDL
*Open Issues :
*Change history :
*@LastModifyDate : 2014.01.13
*@LastModifier : 김수정
*@LastVersion : 1.0
* 2014.01.13 김수정
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.coa.multidimensionrpt.salesrpt.event;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hanjin.apps.alps.esm.coa.common.vo.SearchConditionVO;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.ViewAdapter;
import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;

/**
 * ESM_COA_0060 에 대한 Excel File Download ViewAdapter<br>
 * - ESM_COA_0060HTMLAction에서 작성<br>
 *
 * @author 김기식
 * @see HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmCoa0060ViewAdapterDL extends ViewAdapter {
	
    public EsmCoa0060ViewAdapterDL(){
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
    	log.debug("########### EsmCoa0060ViewAdapterDL ########### [START]");
    	GeneralEventResponse eventResponse = (GeneralEventResponse)request.getAttribute("EventResponse");
 		
 		StringBuilder strBuilder = new StringBuilder();
    	DBRowSet rowSet = null;							   	//DB ResultSet
    	int rowCount	 = 0;								//DB ResultSet 리스트의 건수
    	SearchConditionVO searchVo = null;
    	String savedName = "ESM_COA_0060DL.csv";  
 		
    	rowSet = (DBRowSet)eventResponse.getCustomData("rowset");
    	searchVo = (SearchConditionVO)eventResponse.getCustomData("columns");
    	String[] header = ((String)eventResponse.getCustomData("title")).split("[|]");
		if(rowSet != null){
			 rowCount = rowSet.getRowCount();
		}
		
		try{			
    		if(rowSet != null){
    			for(int i=0; i<header.length; i++){
    				
    				// OP_COST / CM_COST : Hidden 항목으로 Header 에서 제외
    				if(JSPUtil.getNull(header[i]).trim().replaceAll(",", "").equals("OP_COST") || JSPUtil.getNull(header[i]).trim().replaceAll(",", "").equals("CM_COST") ){
//	    				strBuilder.append(JSPUtil.getNull(header[i]).trim().replaceAll(",", ""));
//						strBuilder.append(",");
    					continue;
    				}
    				
    				if(searchVo.getFProVw().equals("R") && JSPUtil.getNull(header[i]).trim().replaceAll(",", "").equals("CM")){
    					header[i] = "BKG CM";
    				}
    				
    				if (searchVo.getFProLvl().equals("O") && searchVo.getFProVw().equals("R")) {
    					if(!JSPUtil.getNull(header[i]).trim().replaceAll(",", "").equals("CM2") && !JSPUtil.getNull(header[i]).trim().replaceAll(",", "").equals("CM2 COST") ){
    	    				strBuilder.append(JSPUtil.getNull(header[i]).trim().replaceAll(",", ""));
    						strBuilder.append(",");
        				}
    				}else if(searchVo.getFProLvl().equals("M")){
    					//OP COST , BKG_OP
    					if(!JSPUtil.getNull(header[i]).trim().replaceAll(",", "").equals("OP COST") && !JSPUtil.getNull(header[i]).trim().replaceAll(",", "").equals("BKG OP") ){
		    				strBuilder.append(JSPUtil.getNull(header[i]).trim().replaceAll(",", ""));
							strBuilder.append(",");
	    				}
    				}else{
    					if(!JSPUtil.getNull(header[i]).trim().replaceAll(",", "").equals("OP COST") && !JSPUtil.getNull(header[i]).trim().replaceAll(",", "").equals("BKG OP") &&
    					   !JSPUtil.getNull(header[i]).trim().replaceAll(",", "").equals("CM2") && !JSPUtil.getNull(header[i]).trim().replaceAll(",", "").equals("CM2 COST") &&
    						!JSPUtil.getNull(header[i]).trim().replaceAll(",", "").equals("OP CPB(TEU)") && !JSPUtil.getNull(header[i]).trim().replaceAll(",", "").equals("OPB(TEU)") &&
    						!JSPUtil.getNull(header[i]).trim().replaceAll(",", "").equals("OP CPB(BOX)") && !JSPUtil.getNull(header[i]).trim().replaceAll(",", "").equals("OPB(BOX)") ){
		    				strBuilder.append(JSPUtil.getNull(header[i]).trim().replaceAll(",", ""));
							strBuilder.append(",");
	    				}
    				}
    			}
    			strBuilder.append("\n");
    			
				while(rowSet.next()){		
					for(int k=1; k<=rowSet.getMetaData().getColumnCount(); k++){	
						// OP_COST / CM_COST : Hidden 항목으로 Header 에서 제외
						if(rowSet.getMetaData().getColumnLabel(k).equals("OP_COST") || rowSet.getMetaData().getColumnLabel(k).equals("CM_COST")){
//							if(JSPUtil.getNull(rowSet.getString(k)).equals("")){									
//								strBuilder.append(JSPUtil.getNull(rowSet.getString(k)).trim().replaceAll(",", ""));
//								strBuilder.append(",");
//							} else {							
//								strBuilder.append(JSPUtil.getNull(rowSet.getString(k)).trim().replaceAll(",", ""));
//								strBuilder.append(",");
//							}
							continue;
						}
						
						if (searchVo.getFProLvl().equals("O") && searchVo.getFProVw().equals("R")) {
	    					if(!rowSet.getMetaData().getColumnLabel(k).equals("CM2C") && !rowSet.getMetaData().getColumnLabel(k).equals("CM2") ){
	    						if(JSPUtil.getNull(rowSet.getString(k)).equals("")){									
									strBuilder.append(JSPUtil.getNull(rowSet.getString(k)).trim().replaceAll(",", ""));
									strBuilder.append(",");
								} else {							
									strBuilder.append(JSPUtil.getNull(rowSet.getString(k)).trim().replaceAll(",", ""));
									strBuilder.append(",");
								}
	        				}
	    				}else if(searchVo.getFProLvl().equals("M")){
	    					//OP COST , BKG_OP
	    					if(!rowSet.getMetaData().getColumnLabel(k).equals("OPC") && !rowSet.getMetaData().getColumnLabel(k).equals("OP") ){
	    						if(JSPUtil.getNull(rowSet.getString(k)).equals("")){									
									strBuilder.append(JSPUtil.getNull(rowSet.getString(k)).trim().replaceAll(",", ""));
									strBuilder.append(",");
								} else {							
									strBuilder.append(JSPUtil.getNull(rowSet.getString(k)).trim().replaceAll(",", ""));
									strBuilder.append(",");
								}
		    				}
	    				}else{
	    					if(!rowSet.getMetaData().getColumnLabel(k).equals("OPC") && !rowSet.getMetaData().getColumnLabel(k).equals("OP") &&
	    					   !rowSet.getMetaData().getColumnLabel(k).equals("CM2C") && !rowSet.getMetaData().getColumnLabel(k).equals("CM2") &&
	    						!rowSet.getMetaData().getColumnLabel(k).equals("OPCOST") && !rowSet.getMetaData().getColumnLabel(k).equals("OPB") ){
	    						
	    						if(JSPUtil.getNull(rowSet.getString(k)).equals("")){									
									strBuilder.append(JSPUtil.getNull(rowSet.getString(k)).trim().replaceAll(",", ""));
									strBuilder.append(",");
								} else {							
									strBuilder.append(JSPUtil.getNull(rowSet.getString(k)).trim().replaceAll(",", ""));
									strBuilder.append(",");
								}
		    				}
	    				}
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
 		
        log.debug("########### EsmCoa0060ViewAdapterDL ########### [END]");
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
