/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EsdTrs0029ViewAdapter.java
*@FileTitle : EsdTrs0029ViewAdapter
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.18
*@LastModifier : 박광석
*@LastVersion : 1.0
* 2014.11.18 박광석
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.workordermanage.workordermanagement.event;

import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.clt.apps.opus.esd.trs.workordermanage.workordermanagement.vo.WorkOrderBFIManagementVO;
import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.controller.ViewAdapter;
import com.clt.framework.core.layer.event.GeneralEventResponse;

/**
 * 기본 IBSheet XML 생성<br>
 * - IBSheet로 반환할 서버처리결과를 XML로 변환하는 클래스이다.<br>
 * 
 * @author 
 * @see ViewAdapter 참조
 * @since J2EE 1.6
 */
public class EsdTrs0029ViewAdapter extends ViewAdapter {
    public EsdTrs0029ViewAdapter(){
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
 		List<WorkOrderBFIManagementVO> list = null;
 		WorkOrderBFIManagementVO vo = null;
    	String savedName = "ESD_TRS_0029DL.csv";  
 		
    	list = ((List<WorkOrderBFIManagementVO>)eventResponse.getRsVoList());
		
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
    		strBuilder.append("Office,Fm Date,To Date,S/P Name,Email,File Creation Date,Contact,W/O No,TP/SZ,From,Via,To,Door,Date,Currency,Charge Description,Charges,EQ No,Cargo,W/O Status");
    		strBuilder.append("\n");
    		String rgx = "[,\\r\\n]";
    		for(int i = 0 ; i < list.size() ; i++){
    			vo = list.get(i);

    			strBuilder.append(JSPUtil.getNull(vo.getCreOfcCd()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getFmDt()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getToDt()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getVndrLglEngNm()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getVndrEml()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getTodayDt()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getCntcPsonNm()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				if(JSPUtil.getNull(vo.getBzcAmtDesc()).trim().replaceAll(rgx, " ").equals("Total") || JSPUtil.getNull(vo.getBzcAmtDesc()).trim().replaceAll(rgx, " ").equals("Grand Total")){
					strBuilder.append("");
				}
				else{
					strBuilder.append(JSPUtil.getNull(vo.getTrspWoNo()).trim().replaceAll(rgx, " "));
				}
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getEqTpszCd()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getFmNodCd()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getViaNodCd()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getToNodCd()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getDorNodCd()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getDorNodPlnDt()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				if(JSPUtil.getNull(vo.getBzcAmtDesc()).trim().replaceAll(rgx, " ").equals("Total") || JSPUtil.getNull(vo.getBzcAmtDesc()).trim().replaceAll(rgx, " ").equals("Grand Total")){
					strBuilder.append("");
				}
				else{
					strBuilder.append(JSPUtil.getNull(vo.getCurrCd()).trim().replaceAll(rgx, " "));
				}

				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getBzcAmtDesc()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
			//	DecimalFormat df = new DecimalFormat("#.##");
			//    String formatted = df.format(2.456345); 
				strBuilder.append(String.format("%.2f",Float.parseFloat(JSPUtil.getNull(vo.getBzcAmt()).trim().replaceAll(rgx, " "))));
				strBuilder.append(",");

				strBuilder.append(JSPUtil.getNull(vo.getEqNo()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getCgoTpCd()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getTrsSubStsCd()).trim().replaceAll(rgx, " "));
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
