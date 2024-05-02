/*========================================================
*Copyright(c) 2011 CyberLogitec
*ProcessChain    : 
*@FileName       : BKGWeb0080001WSProxy.java
*@FileTitle      : 
*@Author         : 
*Open Issues     :
*Change history  :
*@LastModifyDate : 
*@LastModifier   : 
*@LastVersion    : 1.0
=========================================================*/
package com.clt.apps.opus.esm.bkg.servicesio;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import org.apache.log4j.Logger;

import weblogic.jws.WLHttpTransport;

import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.OutboundBLMgtSC;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.XptImpLicVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.BkgVgmInfoVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.event.EsmBkg036101Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.irep.opusws.WEB0080001Document;
import com.clt.irep.opusws.WEB0080001Document.WEB0080001;
import com.clt.irep.opusws.WEB0080001Document.WEB0080001.DataArea;
import com.clt.irep.opusws.WEB0080001Document.WEB0080001.DataArea.InfoCollection;
import com.clt.irep.opusws.WEB0080001Document.WEB0080001.DataArea.InfoCollection.Request;
import com.clt.irep.opusws.WEB0080001Document.WEB0080001.DataArea.InfoCollection.Response;


/**
 * BKGWeb0080001WSProxy.java
 * @author 
 * @see 
 * @since J2SE 1.6
 * 2011.10.12.
 */
@WebService(name="BKGWeb0080001WSProxyPortType", serviceName="BKGWeb0080001WSProxy",
targetNamespace="http://www.clt.com/integration/opus")

@SOAPBinding(style=SOAPBinding.Style.DOCUMENT,
 use=SOAPBinding.Use.LITERAL,
 parameterStyle=SOAPBinding.ParameterStyle.WRAPPED)

@WLHttpTransport(contextPath="/clt/webservices", serviceUri="/BKGWeb0080001WSProxy",
     portName="BKGWeb0080001WSProxyPort")
public class BKGWeb0080001WSProxy {
	
	protected transient Logger log = Logger.getLogger(this.getClass().getName());
	
	/**
	 * VGM <br>
	 * 
	 * @author 
	 * @category WEB008_0001
	 * 
	 * @param WEB0080001Document web0080001Document
	 * @return String
	 */
	@WebMethod()
	public String web0080001ReceiveWS(WEB0080001Document web0080001Document){
		
		//WebService EAI Result
		String result = "Failed";
		
		EsmBkg036101Event event = new EsmBkg036101Event();
		XptImpLicVO vo = new XptImpLicVO();
		XptImpLicVO[] vos = new XptImpLicVO[1]; //SC의 기존 메소드를 사용하기 위해 배열 형식으로 작성
		
		try{
			// ========= Validation Parameters for WebServices ========= 
			if( web0080001Document == null || "".equals(web0080001Document) )
			{
				throw new EventException("Parameter is not valided !");
			}
			// ========= Validation Parameters for WebServices ========= 
			
			// ========= Command Add ===============
			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.MULTI01);
			// ========= Command Add ===============

			
	        event.setFormCommand(f);
			
			// EAI에서 제공된 XSD파일을 Reading
			WEB0080001 web0080001doc = web0080001Document.getWEB0080001();
			
			DataArea dataArea = web0080001doc.getDataArea();
			
			InfoCollection vgmInfoCollection = dataArea.getInfoCollection();
			Request[] vgmInfoRequests = vgmInfoCollection.getRequestArray();
//			Response documentResponse = vgmInfoCollection.getResponse();
			
			
			String vgmWgt = ""; // VGM
			String bkgNo = "";//예약번호
			String vgmWgtUpdDt = "";
			String vgmWgtUpdUsrId = "";
			String cntrNo = "";
			String usrId = "";
			String vgmSeq = "";
			String actTpCd = "";
			String xterVgmRqstCd = "";
			String wgtUtCd = "";
			String esigCoNm = "";
			String vgmCutOffDt = "";
			String custEml = "";
			String custEmlFlg = "";
			String custEmlSndDt = "";
			String vgmCreGdt = "";
			String vgmCreLoclDt = "";
			String creUsr_id = "";
			String creDt = "";
			String updUsrId = "";
			String updDt = "";
			String payldWgt = "";
			String ifFlg = "";
			
			
			for(Request vgmInfoRequest:vgmInfoRequests){
				bkgNo = vgmInfoRequest.getBKGNO();
				vgmWgt = vgmInfoRequest.getVGMWGT();
//				vgmClzFlg = vgmInfoRequest.getv
				vgmWgtUpdDt = vgmInfoRequest.getVGMCRELOCLDT();
				vgmWgtUpdUsrId = vgmInfoRequest.getUPDUSRID();
				cntrNo = vgmInfoRequest.getCNTRNO();
				usrId  = vgmInfoRequest.getUSRID();
				vgmSeq = vgmInfoRequest.getVGMSEQ();
				actTpCd  = vgmInfoRequest.getACTTPCD();
				xterVgmRqstCd = vgmInfoRequest.getXTERVGMRQSTCD();
				wgtUtCd = vgmInfoRequest.getWGTUTCD();
				esigCoNm = vgmInfoRequest.getESIGCONM(); 
				vgmCutOffDt = vgmInfoRequest.getVGMCUTOFFDT();
				custEml = vgmInfoRequest.getCUSTEML();
				custEmlFlg = vgmInfoRequest.getCUSTEMLFLG();
				custEmlSndDt = vgmInfoRequest.getCUSTEMLSNDDT();
				vgmCreGdt = vgmInfoRequest.getVGMCREGDT();
				vgmCreLoclDt = vgmInfoRequest.getVGMCRELOCLDT();
				creUsr_id = vgmInfoRequest.getCREUSRID();
				creDt = vgmInfoRequest.getCREDT();
				updUsrId = vgmInfoRequest.getUPDUSRID();
				updDt = vgmInfoRequest.getUPDDT();
				payldWgt = vgmInfoRequest.getPAYLDWGT();
				ifFlg = vgmInfoRequest.getIFFLG();
				
//				porCd = aesInfoRequest.getPORCD();
//				ibflag = aesInfoRequest.getIBFLAG();
//				updUsrId = aesInfoRequest.getUPDUSRID();
				 
//log.debug("@@@@@@WSProxy : bkgNo = "+bkgNo+" / ioBndCd = "+ioBndCd+" / xptImpSeq = "+xptImpSeq);
//log.debug("@@@@@@WSProxy : porCd = "+porCd+" / ibflag = "+ibflag);
					
				vo.setBkgNo(bkgNo);
				vo.setCreUsrId("WEB");//웹에서 I/F 시 creUsrId를 WEB으로 입력.
				vo.setUpdUsrId(updUsrId);
//				vo.setUpdUsrId("WEB:"+updUsrId);//웹에서 I/F 된 정보라는 것을 알게 하기 위해  WEB:홈페이지아이디 로 저장.
log.debug("@@@@@@WSProxy : vo.getUpdUsrId() = "+vo.getUpdUsrId());				
				vos[0] = vo;//SC의 기존 메소드를 사용하기 위해 배열을 사용.

//				event.setXptImpLicVOs(vos);
//				event.setBkgNo(bkgNo);
//				event.setCntCd(cntCd);
//				event.setPkgTp("");
				
log.debug("@@@@@@WSProxy : setting params to event : bkgNo = "+event.getBkgNo()+" / cntCd = "+event.getCntCd());
				
				
				//bkgNo, ioBndCd, xptImpSeq 가 존재하지 않는 경우 EAI처리 실패
//				if ((bkgNo == null || "".equals(bkgNo))
//						|| (ioBndCd == null || "".equals(ioBndCd))
//						|| (xptImpSeq == null || "".equals(xptImpSeq))) {	
//					
//					throw new EventException("Invalid DATA. No bkgNo or ioBndCd or xptImpSeq.");
//					
//				} else {
//					EventResponse eventResponse = outboundBLMgtSC.perform(event);
//					if (eventResponse != null) {
//log.debug("@@@@@@WSProxy : eventResponse is not null");
//						if(eventResponse.getUserMessage() != null && !"".equals(eventResponse.getUserMessage())){
//log.debug("@@@@@@WSProxy : eventResponse.getUserMessage() = "+eventResponse.getUserMessage());
//							result = "OK";
//						}
//					} else {
//log.debug("@@@@@@WSProxy : eventResponse is null.");
//					}
//				}
//log.debug("@@@@@@WSProxy : checking documentResponse");
//				if (documentResponse != null) {
//log.debug("@@@@@@WSProxy : documentResponse is not null");
//					documentResponse.setRESULT(result);
//log.debug("@@@@@@WSProxy : result = [ "+result+" ]");					
//				}
			}
			
			log.info(":::::>>> web0080001Document : " + web0080001Document);
		
		}  catch (Exception ex){
			log.error(ex.getMessage(), ex);
		}
		
		return result;
	}
}

