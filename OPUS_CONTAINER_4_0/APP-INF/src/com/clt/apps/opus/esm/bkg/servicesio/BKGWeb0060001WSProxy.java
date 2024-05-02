/*========================================================
*Copyright(c) 2011 CyberLogitec
*ProcessChain    : ISD-1
*@FileName       : BKGWeb0060001WSProxy.java
*@FileTitle      : AES No. Input 화면(UI_HOM_3058)에서 정보 생성시 OPUS 로 I/F
*@Author         : Jong-ho Kim
*Open Issues     :
*Change history  :
*@LastModifyDate : 2011. 11. 07.
*@LastModifier   : Jong-ho Kim
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
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.event.EsmBkg036101Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.irep.opusws.WEB0060001Document;
import com.clt.irep.opusws.WEB0060001Document.WEB0060001;
import com.clt.irep.opusws.WEB0060001Document.WEB0060001.DataArea;
import com.clt.irep.opusws.WEB0060001Document.WEB0060001.DataArea.AesInfoCollection;
import com.clt.irep.opusws.WEB0060001Document.WEB0060001.DataArea.AesInfoCollection.AesInfoRequest;
import com.clt.irep.opusws.WEB0060001Document.WEB0060001.DataArea.AesInfoCollection.AesInfoResponse;


/**
 * BKGWeb0060001WSProxy.java
 * @author Jong-ho Kim
 * @see 
 * @since J2SE 1.6
 * 2011.10.12.
 */
@WebService(name="BKGWeb0060001WSProxyPortType", serviceName="BKGWeb0060001WSProxy",
targetNamespace="http://www.clt.com/integration/opus")

@SOAPBinding(style=SOAPBinding.Style.DOCUMENT,
 use=SOAPBinding.Use.LITERAL,
 parameterStyle=SOAPBinding.ParameterStyle.WRAPPED)

@WLHttpTransport(contextPath="/clt/webservices", serviceUri="/BKGWeb0060001WSProxy",
     portName="BKGWeb0060001WSProxyPort")
public class BKGWeb0060001WSProxy {
	
	protected transient Logger log = Logger.getLogger(this.getClass().getName());
	
	/**
	 * AES No. Input 화면(UI_HOM_3058)에서 정보 생성시 OPUS 로 I/F <br>
	 * 
	 * @author Jong-ho Kim
	 * @category WEB006_0001
	 * 
	 * @param WEB0060001Document web0060001Document
	 * @return String
	 */
	@WebMethod()
	public String web0060001ReceiveWS(WEB0060001Document web0060001Document){
		
		//WebService EAI Result
		String result = "Failed";
		
		EsmBkg036101Event event = new EsmBkg036101Event();
		
		XptImpLicVO vo = new XptImpLicVO();
		XptImpLicVO[] vos = new XptImpLicVO[1]; //SC의 기존 메소드를 사용하기 위해 배열 형식으로 작성
		
		
		OutboundBLMgtSC outboundBLMgtSC = new OutboundBLMgtSC();
		
		try{
			// ========= Validation Parameters for WebServices ========= 
			if( web0060001Document == null || "".equals(web0060001Document) )
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
			WEB0060001 web0060001doc = web0060001Document.getWEB0060001();
			
			DataArea dataArea = web0060001doc.getDataArea();
			AesInfoCollection aesInfoCollection = dataArea.getAesInfoCollection();
			AesInfoRequest[] aesInfoRequests = aesInfoCollection.getAesInfoRequestArray();
			AesInfoResponse documentResponse = aesInfoCollection.getAesInfoResponse();
			
			
			String bkgNo = "";//예약번호
			String ioBndCd = "";//바운드구분
			String xptImpSeq = "";//수출입차수
			String cntCd = "";//국가코드
			String aesTpCd = "";//AES 구분코드
			String aesInlndTrnsPfxCtnt = "";//AES Inland 운송 Prefix
			String aesInlndTrnsNo = "";//AES Inland 운송번호
			String aesPtaPfxCtnt = "";//AES PTA Prefix
			String aesPtaNo1 = "";//AES PTA NO1
			String aesPtaNo2 = "";//AES PTA NO2
			String aesPtaDt = "";//AES PTA Date
			String aesPtuPfxCtnt = "";//AES PTU Prefix
			String aesPtuNo = "";//AES PTU NO
			String aesPtuDt = "";//AES PTU DT
			String aesDwnPfxCtnt = "";//AES DOWN Prefix
			String aesDwnNo = "";//AES DOWN NO
			String aesDwnDt = "";//AES DOWN Date
			String aesExptId = "";//AES Exception ID
			String aesExptCtnt = "";//AES Exception Manual Input
//			String pckQty = "";//Mexico Consignee Prefix
//			String divdFlg = "";//Mexico Consignee Tax ID
//			String divdPckQty = "";//Mexico Notify Prefix
//			String samPckQty = "";//Mexico Notify Tax ID
			
			String caedTpCd = "";//CAED 구분코드
			String caedPfxCtnt = "";//CAED Prefix
			String caedNo1 = "";//CAED NO1
			String caedNo2 = "";//CAED NO2
			String caedNo3 = "";//CAED NO3
			String g7EdiPfxCtnt = "";//G7 EDI Prefix
			String g7EdiNo1 = "";//G7 EDI NO1
			String g7EdiNo2 = "";//G7 EDI NO2
			String b13aXptPfxCtnt = "";//B13A Prefix
			String b13aXptDt = "";//B13A Date
			String b13aXptNo1 = "";//B13A NO1
			String b13aXptNo2 = "";//B13A NO2
			String mfSmryRptPfxCtnt = "";//Manifest Summary Prefix
			String mfSmryRptNo = "";//Manifest Summary NO
			String cgoCtrlPfxCtnt = "";//Cargo Control Prefix
			String cgoCtrlNo = "";//Cargo Control NO
			String ndrRefPfxCtnt = "";//NDR Reference Prefix
			String ndrRefId = "";//NDR Reference ID
			String ndrRefCtnt = "";//NDR Reference NO

			String porCd = "";
			String ibflag = "";
			String updUsrId = "";//한진해운 WEB 아이디
			
			for(AesInfoRequest aesInfoRequest:aesInfoRequests){
				bkgNo = aesInfoRequest.getBKGNO();
				ioBndCd = aesInfoRequest.getIOBNDCD();
				xptImpSeq = aesInfoRequest.getXPTIMPSEQ();
				cntCd = aesInfoRequest.getCNTCD();
				aesTpCd = aesInfoRequest.getAESTPCD();
				aesInlndTrnsPfxCtnt = aesInfoRequest.getAESINLNDTRNSPFXCTNT();
				aesInlndTrnsNo = aesInfoRequest.getAESINLNDTRNSNO();
				aesPtaPfxCtnt = aesInfoRequest.getAESPTAPFXCTNT();
				aesPtaNo1 = aesInfoRequest.getAESPTANO1();
				aesPtaNo2 = aesInfoRequest.getAESPTANO2();
				aesPtaDt = aesInfoRequest.getAESPTADT();
				aesPtuPfxCtnt = aesInfoRequest.getAESPTUPFXCTNT();
				aesPtuNo = aesInfoRequest.getAESPTUNO();
				aesPtuDt = aesInfoRequest.getAESPTUDT();
				aesDwnPfxCtnt = aesInfoRequest.getAESDWNPFXCTNT();
				aesDwnNo = aesInfoRequest.getAESDWNNO();
				aesDwnDt = aesInfoRequest.getAESDWNDT();
				aesExptId = aesInfoRequest.getAESEXPTID();
				aesExptCtnt = aesInfoRequest.getAESEXPTCTNT();
//				pckQty = aesInfoRequest.getPCKQTY();
//				divdFlg = aesInfoRequest.getDIVDFLG();
//				divdPckQty = aesInfoRequest.getDIVDPCKQTY();
//				samPckQty = aesInfoRequest.getSAMPCKQTY();
				
				caedTpCd = aesInfoRequest.getCAEDTPCD();
				caedPfxCtnt = aesInfoRequest.getCAEDPFXCTNT();
				caedNo1 = aesInfoRequest.getCAEDNO1();
				caedNo2 = aesInfoRequest.getCAEDNO2();
				caedNo3 = aesInfoRequest.getCAEDNO3();
				g7EdiPfxCtnt = aesInfoRequest.getG7EDIPFXCTNT();
				g7EdiNo1 = aesInfoRequest.getG7EDINO1();
				g7EdiNo2 = aesInfoRequest.getG7EDINO2();
				b13aXptPfxCtnt = aesInfoRequest.getB13AXPTPFXCTNT();
				b13aXptDt = aesInfoRequest.getB13AXPTDT();
				b13aXptNo1 = aesInfoRequest.getB13AXPTNO1();
				b13aXptNo2 = aesInfoRequest.getB13AXPTNO2();
				mfSmryRptPfxCtnt = aesInfoRequest.getMFSMRYRPTPFXCTNT();
				mfSmryRptNo = aesInfoRequest.getMFSMRYRPTNO();
				cgoCtrlPfxCtnt = aesInfoRequest.getCGOCTRLPFXCTNT();
				cgoCtrlNo = aesInfoRequest.getCGOCTRLNO();
				ndrRefPfxCtnt = aesInfoRequest.getNDRREFPFXCTNT();
				ndrRefId = aesInfoRequest.getNDRREFID();
				ndrRefCtnt = aesInfoRequest.getNDRREFCTNT();
				
				porCd = aesInfoRequest.getPORCD();
				ibflag = aesInfoRequest.getIBFLAG();
				updUsrId = aesInfoRequest.getUPDUSRID();
				 
log.debug("@@@@@@WSProxy : bkgNo = "+bkgNo+" / ioBndCd = "+ioBndCd+" / xptImpSeq = "+xptImpSeq);
log.debug("@@@@@@WSProxy : porCd = "+porCd+" / ibflag = "+ibflag);
					
				vo.setBkgNo(bkgNo);
				vo.setIoBndCd(ioBndCd);
				vo.setXptImpSeq(xptImpSeq);
				vo.setCntCd(cntCd);
				vo.setAesTpCd(aesTpCd);
				vo.setAesInlndTrnsPfxCtnt(aesInlndTrnsPfxCtnt);
				vo.setAesInlndTrnsNo(aesInlndTrnsNo);
				vo.setAesPtaPfxCtnt(aesPtaPfxCtnt);
				vo.setAesPtaNo1(aesPtaNo1);
				vo.setAesPtaNo2(aesPtaNo2);
				vo.setAesPtaDt(aesPtaDt);
				vo.setAesPtuPfxCtnt(aesPtuPfxCtnt);
				vo.setAesPtuNo(aesPtuNo);
				vo.setAesPtuDt(aesPtuDt);
				vo.setAesDwnPfxCtnt(aesDwnPfxCtnt);
				vo.setAesDwnNo(aesDwnNo);
				vo.setAesDwnDt(aesDwnDt);
				vo.setAesExptId(aesExptId);
				vo.setAesExptCtnt(aesExptCtnt);
//				vo.setPckQty(pckQty);
//				vo.setDivdFlg(divdFlg);
//				vo.setDivdPckQty(divdPckQty);
//				vo.setSamPckQty(samPckQty);
				
				vo.setCaedTpCd(caedTpCd);
				vo.setCaedPfxCtnt(caedPfxCtnt);
				vo.setCaedNo1(caedNo1);
				vo.setCaedNo2(caedNo2);
				vo.setCaedNo3(caedNo3);
				vo.setG7EdiPfxCtnt(g7EdiPfxCtnt);
				vo.setG7EdiNo1(g7EdiNo1);
				vo.setG7EdiNo2(g7EdiNo2);
				vo.setB13aXptPfxCtnt(b13aXptPfxCtnt);
				vo.setB13aXptDt(b13aXptDt);
				vo.setB13aXptNo1(b13aXptNo1);
				vo.setB13aXptNo2(b13aXptNo2);
				vo.setMfSmryRptPfxCtnt(mfSmryRptPfxCtnt);
				vo.setMfSmryRptNo(mfSmryRptNo);
				vo.setCgoCtrlPfxCtnt(cgoCtrlPfxCtnt);
				vo.setCgoCtrlNo(cgoCtrlNo);
				vo.setNdrRefPfxCtnt(ndrRefPfxCtnt);
				vo.setNdrRefId(ndrRefId);
				vo.setNdrRefCtnt(ndrRefCtnt);
				
				vo.setIbflag(ibflag);
				vo.setPorCd(porCd);
				vo.setCreUsrId("WEB");//웹에서 I/F 시 creUsrId를 WEB으로 입력.
				vo.setUpdUsrId(updUsrId);
//				vo.setUpdUsrId("WEB:"+updUsrId);//웹에서 I/F 된 정보라는 것을 알게 하기 위해  WEB:홈페이지아이디 로 저장.
log.debug("@@@@@@WSProxy : vo.getUpdUsrId() = "+vo.getUpdUsrId());				
				vos[0] = vo;//SC의 기존 메소드를 사용하기 위해 배열을 사용.

				event.setXptImpLicVOs(vos);
				event.setBkgNo(bkgNo);
				event.setCntCd(cntCd);
				event.setPkgTp("");
				
log.debug("@@@@@@WSProxy : setting params to event : bkgNo = "+event.getBkgNo()+" / cntCd = "+event.getCntCd());
				
				
				//bkgNo, ioBndCd, xptImpSeq 가 존재하지 않는 경우 EAI처리 실패
				if ((bkgNo == null || "".equals(bkgNo))
						|| (ioBndCd == null || "".equals(ioBndCd))
						|| (xptImpSeq == null || "".equals(xptImpSeq))) {	
					
					throw new EventException("Invalid DATA. No bkgNo or ioBndCd or xptImpSeq.");
					
				} else {
					EventResponse eventResponse = outboundBLMgtSC.perform(event);
					if (eventResponse != null) {
log.debug("@@@@@@WSProxy : eventResponse is not null");
						if(eventResponse.getUserMessage() != null && !"".equals(eventResponse.getUserMessage())){
log.debug("@@@@@@WSProxy : eventResponse.getUserMessage() = "+eventResponse.getUserMessage());
							result = "OK";
						}
					} else {
log.debug("@@@@@@WSProxy : eventResponse is null.");
					}
				}
log.debug("@@@@@@WSProxy : checking documentResponse");
				if (documentResponse != null) {
log.debug("@@@@@@WSProxy : documentResponse is not null");
					documentResponse.setRESULT(result);
log.debug("@@@@@@WSProxy : result = [ "+result+" ]");					
				}
			}
			
			log.info(":::::>>> web0060001Document : " + web0060001Document);
		
		}  catch (Exception ex){
			log.error(ex.getMessage(), ex);
		}
		
		return result;
	}
}

