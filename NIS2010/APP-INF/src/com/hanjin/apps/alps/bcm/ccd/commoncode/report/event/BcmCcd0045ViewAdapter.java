/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : BcmCcd0047ViewAdapter.java
*@FileTitle : BcmCcd0047ViewAdapter
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.16
*@LastModifier : 박광석
*@LastVersion : 1.0
* 2014.04.16 박광석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.bcm.ccd.commoncode.report.event;
 
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hanjin.apps.alps.bcm.ccd.commoncode.report.vo.LocationReportVO;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.ViewAdapter;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
/**
 * 기본 IBSheet XML 생성<br>
 * - IBSheet로 반환할 서버처리결과를 XML로 변환하는 클래스이다.<br>
 * 
 * @author Lee SeungYol
 * @see ViewAdapter 참조
 * @since J2EE 1.5
 */
public class BcmCcd0045ViewAdapter extends ViewAdapter {
    public BcmCcd0045ViewAdapter(){
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
    
    @SuppressWarnings("unchecked")
	public String makeXML(HttpServletRequest request, HttpServletResponse response) {
    	GeneralEventResponse eventResponse = (GeneralEventResponse)request.getAttribute("EventResponse"); 
 		
 		StringBuilder strBuilder = new StringBuilder();
 		List<LocationReportVO> list = null;
 		LocationReportVO vo = null;
    	String savedName = "BCM_CCD_0045DL.csv";  
 		
    	list = ((List<LocationReportVO>)eventResponse.getRsVoList());
		
		try{			
    		
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
    		
    		strBuilder.append("Location Code,English Name,Local Name,Character,Calling Port,Port,Type,Continent,Sub Continent,Country,Region,State,SCC,Rep. Zone,UN LOC Flag,UN LOC Code,Sales OFC,");
    		strBuilder.append("EQ OFC,Fin OFC,Rep Empty P/Up CY,EQ Return CY,Hub Loc,Zip Code,GMT Hours,US AMS Code,Customs Code,Commercial Zone,Latitude,Unit,Longitude,Unit,VIP Code,Delete Flag, Create User, Create Date/Time, Last Update User, Last Update Date/Time");
    		strBuilder.append("\n");
    		String rgx = "[,\\r\\n]";
    		for(int i = 0 ; i < list.size() ; i++){
    			vo = list.get(i); 

    			strBuilder.append(JSPUtil.getNull(vo.getLocCd()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getLocNm()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getLocLoclLangNm()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getLocChrCd()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getCallPortFlg()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getPortInlndFlg()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getLocTpCd()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				
				strBuilder.append(JSPUtil.getNull(vo.getContiCd()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				
				strBuilder.append(JSPUtil.getNull(vo.getScontiCd()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getCntCd()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getRgnCd()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getSteCd()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getSccCd()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getRepZnCd()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getUnLocIndCd()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getUnLocCd()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getSlsOfcCd()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getEqCtrlOfcCd()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getFincCtrlOfcCd()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getMtyPkupYdCd()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getEqRtnYdCd()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getHubLocCd()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
//				strBuilder.append(JSPUtil.getNull(vo.getLocGrdNo()).trim().replaceAll(rgx, " "));
//				strBuilder.append(",");

				strBuilder.append(JSPUtil.getNull(vo.getZipCd()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getGmtHrs()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getLocAmsPortCd()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getCstmsCd()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getCmlZnFlg()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getLocLat()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getLatUtCd()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getLocLon()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getLonUtCd()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getModiLocCd()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getDeltFlg()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getCreUsrId()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getCreDt()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getUpdUsrId()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getUpdDt()).trim().replaceAll(rgx, " "));
				strBuilder.append("\n");
			}
    		
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
