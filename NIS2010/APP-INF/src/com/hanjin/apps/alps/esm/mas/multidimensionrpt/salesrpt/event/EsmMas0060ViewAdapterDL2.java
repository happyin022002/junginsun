/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmMas0060ViewAdapterDL.java
*@FileTitle : EsmMas0060ViewAdapterDL
*Open Issues :
*Change history :
*@LastModifyDate : 2014.01.13
*@LastModifier : 김수정
*@LastVersion : 1.0
* 2014.01.13 김수정
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.multidimensionrpt.salesrpt.event;

import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hanjin.apps.alps.esm.mas.common.vo.SearchConditionVO;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.ViewAdapter;
import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;

/**
 * ESM_MAS_0060 에 대한 Excel File Download ViewAdapter<br>
 * - ESM_MAS_0060HTMLAction에서 작성<br>
 *
 * @author 김기식
 * @see HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmMas0060ViewAdapterDL2 extends ViewAdapter {
	
	public EsmMas0060ViewAdapterDL2(){
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
    	log.debug("########### EsmMas0060ViewAdapterDL2 ########### [START]");
    	GeneralEventResponse eventResponse = (GeneralEventResponse)request.getAttribute("EventResponse");
 		
 		StringBuilder strBuilder = new StringBuilder();
    	DBRowSet rowSet = null;							   	//DB ResultSet
    	String savedName = "ESM_MAS_0060DL.csv";  
 		
    	rowSet = (DBRowSet)eventResponse.getCustomData("rowset");
    	String str = (String)eventResponse.getCustomData("columns");
    	String[] header = str.split("[|]");
		
		try{			
    		if(rowSet != null){    			
    			if( header.length > 0 ){
    				strBuilder.append("");
    				strBuilder.append(",");
    			}
    			
    			//Week Display 선택 시 R.MONTH, S.MONTH, WEEK 컬럼 추가 (CHM-201641812)
    			for( int i=1 ; i<rowSet.getMetaData().getColumnCount(); i++){
    				if( (rowSet.getMetaData().getColumnName(i)).equals("COST_YRMON") ){
		    			strBuilder.append("R.MONTH");
		    			strBuilder.append(",");
    				}
    				if( (rowSet.getMetaData().getColumnName(i)).equals("SLS_YRMON") ){
		    			strBuilder.append("S.MONTH");
		    			strBuilder.append(",");
    				}
    				if( (rowSet.getMetaData().getColumnName(i)).equals("COST_WK") ){
		    			strBuilder.append("WEEK");
		    			strBuilder.append(",");
    				}
    			}
    			
    			for(int i=0; i<header.length; i++){
    				
    				// OP_COST / CM_COST : Hidden 항목으로 Header 에서 제외
    				if(JSPUtil.getNull(header[i]).trim().replaceAll(",", "").equals("OP_COST") || JSPUtil.getNull(header[i]).trim().replaceAll(",", "").equals("CM_COST") ){
//	    				strBuilder.append(JSPUtil.getNull(header[i]).trim().replaceAll(",", ""));
//						strBuilder.append(",");
    					continue;
    				}
    				
    				if(JSPUtil.getNull(header[i]).trim().replaceAll(",", "").equals("CM")){
    					header[i] = "BKG CM";
    				}
    				
    				if(!JSPUtil.getNull(header[i]).trim().replaceAll(",", "").equals("CM2") && !JSPUtil.getNull(header[i]).trim().replaceAll(",", "").equals("CM2 COST") ){
    					
    	    				strBuilder.append(JSPUtil.getNull(header[i]).trim().replaceAll(",", ""));
    						strBuilder.append(",");
        				
    				}else if(!JSPUtil.getNull(header[i]).trim().replaceAll(",", "").equals("OP COST") && !JSPUtil.getNull(header[i]).trim().replaceAll(",", "").equals("BKG OP") ){
	    				strBuilder.append(JSPUtil.getNull(header[i]).trim().replaceAll(",", ""));
						strBuilder.append(",");
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

    			Boolean tpszFlg = false;		//TPSZ_CODE가 존재하면 true
    			
    			//Bound Display 선택 시 BOUND 컬럼 추가 (CHM-201641812)
    			for( int i=1 ; i<rowSet.getMetaData().getColumnCount(); i++){
    				if( (rowSet.getMetaData().getColumnName(i)).equals("DIR_CD2") ){
		    			strBuilder.append("BOUND");
		    			strBuilder.append(",");
    				}
    				// Type/Size 가 BOX일때만 TP/SZ 보이기 [CHM-201641812] 2016.06.
    				if( (rowSet.getMetaData().getColumnName(i)).equals("TPSZ_CODE") ){
    	    			strBuilder.append("TP/SZ");
    	    			strBuilder.append(",");
    	    			tpszFlg = true;
		    			break;    					
    				}
    			}
    			
    			strBuilder.append("LOAD");
    			strBuilder.append(",");
    			strBuilder.append("REV");
    			strBuilder.append(",");
    			strBuilder.append("CM COST");
    			strBuilder.append(",");
    			strBuilder.append("CM");
    			strBuilder.append(",");

				// Type/Size 가 BOX/TEU일때 Header 변경 [CHM-201641812] 2016.06.
				if(tpszFlg){
	    			strBuilder.append("RPB(BOX)");
	    			strBuilder.append(",");
	    			strBuilder.append("CM CPB(BOX)");
	    			strBuilder.append(",");
	    			strBuilder.append("CMB(BOX)");
	    			strBuilder.append(",");
				} else {
	    			strBuilder.append("RPB(TEU)");
	    			strBuilder.append(",");
	    			strBuilder.append("CM CPB(TEU)");
	    			strBuilder.append(",");
	    			strBuilder.append("CMB(TEU)");
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
 			response.setHeader("StreamResponseUse", "TRUE");
 			
//    		PrintWriter pout = response.getWriter();
 			OutputStream pout = response.getOutputStream();
 			
 			pout.write(0xEF);   
			pout.write(0xBB);
			pout.write(0xBF);
			
			pout.write(strBuilder.toString().getBytes());
			pout.flush();
			pout.close();
    				    
        }    	
    	catch(Exception ex){
            log.error(ex.getMessage(), ex);
            throw new RuntimeException(ex.getMessage());
        }    	
 		
        log.debug("########### EsmMas0060ViewAdapterDLe ########### [END]");
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
