/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CODCorrectionEAIDAO.java
*@FileTitle : COD Status Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.23
*@LastModifier : 최영희
*@LastVersion : 1.0
* 2009.07.23 최영희
* 1.0 Creation
* -----------------------------------------------------------
* History
* 2011.05.16 이일민 [CHM-201110392] [Booking-COD] 오토 메일시 VVD의 Carrier별로 발신 가능하도록 로직 수정 요청건
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingcorrection.codcorrection.integration;

import java.util.List;

import com.hanjin.apps.alps.esm.bkg.bookingcorrection.codcorrection.basic.CODCorrectionBCImpl;
import com.hanjin.apps.alps.esm.bkg.bookingcorrection.codcorrection.vo.CodCntrVO;
import com.hanjin.apps.alps.esm.bkg.bookingcorrection.codcorrection.vo.PrnrCodRcvrVO;
import com.hanjin.apps.alps.esm.bkg.bookingcorrection.codcorrection.vo.PrnrCodRqstVO;
import com.hanjin.framework.component.javamail.TemplateMail;
import com.hanjin.framework.core.layer.integration.EAIException;
import com.hanjin.framework.support.layer.integration.EAIDAOSupport;
/**
 *  alps CODCorrectionEAIDAO <br>
 *  EAIDAO 연동 처리 <br>
 * @author Choi Yeoung Hee
 * @see CODCorrectionBCImpl 참조
 * @since J2EE 1.4
 */
public class CODCorrectionEAIDAO extends EAIDAOSupport{
	/**
	 * ESM_BKG_0156 Mail 전송<br>
	 * 
	 * @param PrnrCodRqstVO prnrCodRqstVO
	 * @param PrnrCodRcvrVO prnrCodRcvrVO
	 * @param List<CodCntrVO> codCntrVOs
	 * @return String
	 * @throws EAIException
	 */
	public String sendXterCodRqst(PrnrCodRqstVO prnrCodRqstVO , PrnrCodRcvrVO prnrCodRcvrVO , List<CodCntrVO>  codCntrVOs)throws EAIException{
		try {		    
			TemplateMail template 		= new TemplateMail();
			StringBuffer sbContents 	= new StringBuffer(10000);
		    StringBuffer strTd 			= new StringBuffer();		    
		    StringBuffer spclCgoInfo 	= new StringBuffer();
		    
		    String headerCtnt = "";
		    String dgCgoInfo = "";
		    String rfCgoInfo = "";		    
		    
		    if("R".equals(prnrCodRqstVO.getCodStsCd())){
		    	headerCtnt = "Please kindly check this COD Application and offer Rehandling CNTR Q'ty each.";
		    }else if("M".equals(prnrCodRqstVO.getCodStsCd())){ // MANUAL REQUEST
		    	headerCtnt = "Please kindly check this COD Application and offer Rehandling CNTR Q'ty each.";
		    }else if("C".equals(prnrCodRqstVO.getCodStsCd())){
		    	headerCtnt = "Please be advised that below COD application has been withdrawn.";		    	
		    }else if("F".equals(prnrCodRqstVO.getCodStsCd())){
		    	headerCtnt = "Please be advised that below COD has been confirmed by Booking Office.";	    	
		    }else if("Y".equals(prnrCodRqstVO.getCodStsCd())){
		    	headerCtnt = "Please be advised that below COD has been Approved by Booking Office.";		    	
		    }
		    
		    for(int idx=0;idx<codCntrVOs.size();idx++){
		    	 strTd.append("<tr><td>").append(codCntrVOs.get(idx).getCntrNo()).append("</td>");
		    	 strTd.append("<td>").append(codCntrVOs.get(idx).getCntrTpszCd()).append("</td>");
		    	 strTd.append("<td>").append(codCntrVOs.get(idx).getCntrWgt()).append("</td>");
		    	 strTd.append("<td>").append(codCntrVOs.get(idx).getDcgoFlg()).append("</td>");
		    	 strTd.append("<td>").append(codCntrVOs.get(idx).getBbCgoFlg()).append("</td>");
		    	 strTd.append("<td>").append(codCntrVOs.get(idx).getAwkCgoFlg()).append("</td>");
		    	 strTd.append("<td>").append(codCntrVOs.get(idx).getRcFlg()).append("</td>");
		    	 strTd.append("<td>").append(codCntrVOs.get(idx).getSocFlg()).append("</td>");
		    	 strTd.append("<td>").append(codCntrVOs.get(idx).getCntrStwgNo()).append("</td></tr>");
		    	 if(codCntrVOs.get(idx).getDgEmlCtnt()!=null){
			    	 if(codCntrVOs.get(idx).getDgEmlCtnt().length()>0){
			    		 dgCgoInfo = dgCgoInfo + codCntrVOs.get(idx).getDgEmlCtnt() + "<br>"; 
			    	 }
		    	 }
		    	 if(codCntrVOs.get(idx).getRfEmlCtnt()!=null){
			    	 if(codCntrVOs.get(idx).getRfEmlCtnt().length()>0){
			    		 rfCgoInfo = rfCgoInfo + codCntrVOs.get(idx).getRfEmlCtnt(); 
			    	 }
		    	 }
		    }
		    if(dgCgoInfo.length()>0||rfCgoInfo.length()>0){
			    spclCgoInfo.append("&lt Special Cargo Infomation &gt<br>");
			    if(dgCgoInfo.length()>0) {
			    	spclCgoInfo.append("[ Dangerous Cargo ]<BR>"); 
			    	spclCgoInfo.append(dgCgoInfo);
			    }
			    if(rfCgoInfo.length()>0){	
			    	spclCgoInfo.append("[ Reefer Cargo ]<BR>");  
			    	spclCgoInfo.append("<table border=1>");
			    	spclCgoInfo.append("<TR><td width=120>Container No</TD>");
			    	spclCgoInfo.append("<td width=400>Commodity</TD>");
			    	spclCgoInfo.append("<td width=120>Temperature</TD>");
			    	spclCgoInfo.append("<TD width=120>Ventilation</TD><TR>");
			    	spclCgoInfo.append(rfCgoInfo);
			    	spclCgoInfo.append("</table><br>");
			    }		    
		    }

		    if("HJSALPSA".equals(prnrCodRcvrVO.getGlobalName())){
//			    template.setFrom("dyryu2006@cyberlogitec.com");
//			    template.setRecipient("mjjeong@hanjin.com;dyryu2006@cyberlogitec.com");
				template.setFrom(prnrCodRcvrVO.getFromEml()); 
				template.setRecipient(prnrCodRcvrVO.getToEml());
				template.setCcRcvrEml(prnrCodRcvrVO.getFromEml()+";"+prnrCodRcvrVO.getCcEml());
		    } else {
		    	//test일 경우 실제 수신인에게 보내지 않음 
			    template.setFrom("dyryu2006@cyberlogitec.com");
			    template.setRecipient("dyryu2006@cyberlogitec.com");
		    }
		    //template.setBccRcvrEml(prnrCodRcvrVO.getCcEml());
			template.setRdSubSysCd("BKG");
			template.setBatFlg("N");
			template.setSubject(prnrCodRqstVO.getHeader()); 

			sbContents.append("<html>\n");
			sbContents.append("<head>\n");
			sbContents.append("<meta http-equiv='Content-Type' content='text/html; charset=utf-8' />\n");
			sbContents.append("<title>COD Applicaton</title>\n");
			sbContents.append("<style type='text/css'>\n");
			sbContents.append("</style>\n");
			sbContents.append("</head>\n");
			
			sbContents.append("<body> \n");
			sbContents.append("<table width='573' border='0'> \n");
			sbContents.append("  <tr>\n");
			sbContents.append("   <td width='48'>Date :</td>\n");
			sbContents.append("    <td >" + prnrCodRqstVO.getRqstDt() + "</td>\n");
			sbContents.append("  </tr>\n");
			sbContents.append("  <tr>\n");
			sbContents.append("    <td>To : </td>\n");
			sbContents.append("    <td>" + prnrCodRqstVO.getCarrierCd() + "</td>\n");
			sbContents.append("  </tr>\n");
			sbContents.append("  <tr>\n");
			sbContents.append("    <td>From : </td>\n");
			sbContents.append("    <td>" + prnrCodRqstVO.getOperationTeam() + "</td>\n");
			sbContents.append("  </tr>\n");
			sbContents.append("</table>\n");
			
		    if(!"HJSALPSA".equals(prnrCodRcvrVO.getGlobalName())){
				sbContents.append("*TEST*<BR>");
				sbContents.append("원래 보낼 EMAIL TO :"   + prnrCodRcvrVO.getToEml()   +"<BR>");
				sbContents.append("원래 보낼 EMAIL FROM :" + prnrCodRcvrVO.getFromEml() +"<BR>");
				sbContents.append("원래 보낼 EMAIL CC :"   + prnrCodRcvrVO.getCcEml()   +"<BR>");	
				sbContents.append("*TEST*<BR>");	    	
		    }
		    
			sbContents.append("<br/><br/>\n");
			sbContents.append(headerCtnt + "\n");
			sbContents.append("<br/>\n");
//			sbContents.append("CNTR Type &amp; Size if acceptable.<br/><br/>\n");
			sbContents.append("<span class='subject'>1. Ref No</span> : <span class='content'>" + prnrCodRqstVO.getRefNo() + "</span><br/>\n");
			sbContents.append("<span class='subject'>2. Vessel</span> : <span class='content'>" + prnrCodRqstVO.getVslNm()+ "</span><br/>\n");
			 sbContents.append("<span class='subject'>3. Voyage number</span> : <span class='content'>" + prnrCodRqstVO.getVoyageNo() + "</span><br/>\n");
			
			sbContents.append("<span class='subject'>4. Container number &amp; TPSZ &amp; weight &amp; special cargo IND &amp; stowage position</span><br/>\n");
 
			sbContents.append("<table width='643' border='1' cellpadding='0' cellspacing='0' class='base'>\n");
			sbContents.append("  <tr>\n");
			sbContents.append("<td width='120' class='basetd'>Container Numner </td>\n");
			sbContents.append("    <td width='60' class='basetd'>TPSZ</td>\n");
			sbContents.append("    <td width='120' class='basetd'>Weight</td>\n");
			sbContents.append("    <td width='40'  class='basetd'>DG</td>\n");
			sbContents.append("    <td width='40' class='basetd'>BB</td>\n");
			sbContents.append("    <td width='40' class='basetd'>AK</td>\n");
			sbContents.append("    <td width='40' class='basetd'>RF</td>\n");
			sbContents.append("    <td width='40' class='basetd'>SOC</td>\n");
			sbContents.append("    <td width='120'>Stowage Position </td>\n");
			sbContents.append("  </tr>\n");
			sbContents.append(strTd.toString() + "\n");
			sbContents.append("</table>\n");
			sbContents.append(" <br/>\n");
			sbContents.append("<span class='subject'>5. Port of loading on VVD</span> : <span class='content'>" + prnrCodRqstVO.getOldPol().substring(0,5) + "(" + prnrCodRqstVO.getOldPolNm() + ")</span> <br/>\n");
			sbContents.append("<span class='subject'>6. Old Port of discharging on VVD</span> : <span class='content'>" + prnrCodRqstVO.getOldPod().substring(0,5) + "(" + prnrCodRqstVO.getOldPodNm() + ")</span><br/>\n");
			sbContents.append("<span class='subject'>7. New Port of discharging on VVD</span> : <span class='content'>" + prnrCodRqstVO.getNewPod().substring(0,5) + "(" + prnrCodRqstVO.getNewPodNm() + ")</span><br/>\n");
			sbContents.append("<br/>\n");
			sbContents.append(spclCgoInfo.toString()+"\n");
			sbContents.append("<br/>\n");
			sbContents.append(" Best Regards\n");
			sbContents.append("</body>\n");
			sbContents.append("</html>\n");

			template.setArg("reqcontents",sbContents.toString()); 
			template.setHtmlTemplate("ESM_BKG_COMM_01T.html"); 
			
			log.debug(sbContents.toString());
			return template.send();
			 
		} catch (Exception ex){
			log.error(ex.getMessage(),ex);
			throw new EAIException(ex.getMessage(), ex);
		}
		
	}
}
