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
package com.clt.apps.opus.bcm.ccd.commoncode.report.event;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.clt.apps.opus.bcm.ccd.commoncode.report.vo.VendorReportVO;
import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.controller.ViewAdapter;
import com.clt.framework.core.layer.event.GeneralEventResponse;
/**
 * 기본 IBSheet XML 생성<br>
 * - IBSheet로 반환할 서버처리결과를 XML로 변환하는 클래스이다.<br>
 * 
 * @author Lee SeungYol
 * @see ViewAdapter 참조
 * @since J2EE 1.5
 */
public class BcmCcd0044ViewAdapter extends ViewAdapter {
    public BcmCcd0044ViewAdapter(){
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
 		List<VendorReportVO> list = null;
 		VendorReportVO vo = null;
    	String savedName = "BCM_CCD_0044DL.csv";  
 		
    	list = ((List<VendorReportVO>)eventResponse.getRsVoList());
		
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
    		
    		strBuilder.append("Vendor Code,Vendor Country,Vendor Name,Local Name(LCL),Short Name,Logistics,Procurement,Finance,Team,Subsidiary Company,Others,Location,Control Office,Tax Payer ID,Payment Term,Payment Term Type,Payment Method,Parent Vendor,Invoice Currency,Contact Person,CEO Name,Business Category,Business Type,SCAC(USA Only),Service Area,SVC Frequency,SVC Frequency Remark,DG CGO Handling,MTY R/R Order EDI Use,W/O Attach File,W/O EDI Use,Invoice EDI Use,TPB Customer Code,Address(ENG),Zip Code,Address(LCL),Address1(LCL),Address2(LCL),Address3(LCL),Country Code,State Code,City Name,Zip Code,Address Use Flag,Legacy Code,Delete Flag, Create User, Create Date/Time, Last Update User, Last Update Date/Time");
    		strBuilder.append("\n");
    		String rgx = "[,\\r\\n]";
    		for(int i = 0 ; i < list.size() ; i++){
    			vo = list.get(i); 

    			strBuilder.append(JSPUtil.getNull(vo.getVndrSeq()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getVndrCntCd()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getVndrLglEngNm()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getVndrLoclLangNm()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getVndrAbbrNm()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getLgsFlg()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getProcuFlg()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");

				strBuilder.append(JSPUtil.getNull(vo.getFincFlg()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getTeamFlg()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getInterCoFlg()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getOtrFlg()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getLocCd()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getOfcCd()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
//				strBuilder.append(JSPUtil.getNull(vo.getRgstNo()).trim().replaceAll(rgx, " "));
//				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getTaxId()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getGenPayTermCd()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getPayTermTpCd()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getPayMzdCd()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getPrntVndrSeq()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getInvCurrCd()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getCntcPsonNm()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getCeoNm()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");

				strBuilder.append(JSPUtil.getNull(vo.getBzctNm()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getBztpNm()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getUsaEdiCd()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getSvcScpCdNm()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getSvcPrdTpNm()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getSvcPrdRmk()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getDcgoHndlFlg()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getMtyRroEdiUseFlg()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getWoAtchFileFlg()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getWoEdiUseFlg()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getInvEdiUseFlg()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getRfndPsdoCustCd()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");

//				strBuilder.append(JSPUtil.getNull(vo.getVndrOfcCd()).trim().replaceAll(rgx, " "));
//				strBuilder.append(",");
//				strBuilder.append(JSPUtil.getNull(vo.getSubsCoCd()).trim().replaceAll(rgx, " "));
//				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getEngAddr()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getZipCd()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getLoclLangAddr()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getChkDeAddr1()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getChkDeAddr2()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getChkDeAddr3()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");

				strBuilder.append(JSPUtil.getNull(vo.getChkDeCntCd()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getChkDeSteCd()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getChkDeCtyNm()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getChkDeZipCd()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getLuDeltFlg()).trim().replaceAll(rgx, " "));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(vo.getModiVndrCd()).trim().replaceAll(rgx, " "));
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
