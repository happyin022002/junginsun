/*========================================================
*Copyright(c) 2011 CyberLogitec
*ProcessChain    : ISD-1
*@FileName       : BKGWeb0050001WSProxy.java
*@FileTitle      : 한진해운 홈페이지에서 객장 B/L 발급 요청시 해당 정보를 ALPS로 I/F
*@Author         : Jong-ho Kim
*Open Issues     :
*Change history  :
*@LastModifyDate : 2011. 10. 19.
*@LastModifier   : Jong-ho Kim
*@LastVersion    : 1.0
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.servicesio;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import org.apache.log4j.Logger;

import weblogic.jws.WLHttpTransport;

import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.OutboundBLMgtSC;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.event.EsmBkgWeb0050001Event;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.BkgWebService005VO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.irep.alpsws.WEB0050001Document;
import com.hanjin.irep.alpsws.WEB0050001Document.WEB0050001;
import com.hanjin.irep.alpsws.WEB0050001Document.WEB0050001.DataArea;
import com.hanjin.irep.alpsws.WEB0050001Document.WEB0050001.DataArea.BlRqstInfoCollection;
import com.hanjin.irep.alpsws.WEB0050001Document.WEB0050001.DataArea.BlRqstInfoCollection.BlRqstInfoRequest;
import com.hanjin.irep.alpsws.WEB0050001Document.WEB0050001.DataArea.BlRqstInfoCollection.BlRqstInfoResponse;

/**
 * BKGWeb0050001WSProxy.java
 * @author Jong-ho Kim
 * @see 
 * @since J2SE 1.6
 * 2011.10.12.
 */
@WebService(name="BKGWeb0050001WSProxyPortType", serviceName="BKGWeb0050001WSProxy",
targetNamespace="http://www.hanjin.com/integration/alps")

@SOAPBinding(style=SOAPBinding.Style.DOCUMENT,
 use=SOAPBinding.Use.LITERAL,
 parameterStyle=SOAPBinding.ParameterStyle.WRAPPED)

@WLHttpTransport(contextPath="/hanjin/webservices", serviceUri="/BKGWeb0050001WSProxy",
     portName="BKGWeb0050001WSProxyPort")
public class BKGWeb0050001WSProxy {
	
	protected transient Logger log = Logger.getLogger(this.getClass().getName());
	
	/**
	 * 한진해운 홈페이지에서 객장 B/L 발급 요청시 해당 정보를 ALPS 로 I/F <br>
	 * 
	 * @author Jong-ho Kim
	 * @category WEB005_0001
	 * 
	 * @param WEB0050001Document web0050001Document
	 * @return String
	 */
	@WebMethod()
	public String web0050001ReceiveWS(WEB0050001Document web0050001Document){
		
		//WebService EAI Result
		String result = "Failed";
		
		BkgWebService005VO vo = new BkgWebService005VO();
		OutboundBLMgtSC outboundBLMgtSC = new OutboundBLMgtSC();
		
		try{
			// ========= Validation Parameters for WebServices ========= 
			if( web0050001Document == null || "".equals(web0050001Document) )
			{
				throw new EventException("Parameter is not valided !");
			}
			// ========= Validation Parameters for WebServices ========= 
			
			// ========= Command Add ===============
			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.MULTI01);
			// ========= Command Add ===============
			
			EsmBkgWeb0050001Event event = new EsmBkgWeb0050001Event();
	        event.setFormCommand(f);
			
			// EAI에서 제공된 XSD파일을 Reading
			WEB0050001 web0050001doc = web0050001Document.getWEB0050001();
			
			DataArea dataArea = web0050001doc.getDataArea();
			BlRqstInfoCollection blRqstInfoCollection = dataArea.getBlRqstInfoCollection();
			BlRqstInfoRequest[] blRqstInfoRequests = blRqstInfoCollection.getBlRqstInfoRequestArray();
			BlRqstInfoResponse documentResponse = blRqstInfoCollection.getBlRqstInfoResponse();
			
			
			String xterRqstNo = "";//B/L Number
			String xterRqstSeq = "";//Sequence
			String blIssRqstDt = "";//신청일시
			String rqstRctLocCd = "";//B/L 발급 객장
			String blNo = "";//B/L Number
			String vslCd = "";//선박코드
			String skdVoyNo = "";//항차순번
			String skdDirCd = "";//항차방향
			String vslNm = "";//선박명
			String rqstBlTpCd = "";//B/L Type
			String rqstCoNm = "";//신청업체명
			String rqstUsrEml = "";//신청업체 담당자 이메일
			String rqstAtndNm = "";//신청업체 담당자명
			String rqstPhnNo = "";//신청업체 담당자 전화번호
			String blRqstRmk = "";//요청사항
			String actShprNm = "";//실화주 상호명
			String actShprRgstNo = "";//실화주 사업자번호
			String taxInvRcvrCoNm = "";//세금계산서 공급받는자 상호명
			String taxInvRcvrRgstNo = "";//세금계산서 공급받는자 사업자번호
			String taxInvRcvrAtndNm = "";//세금계산서 공급받는자 담당자명
			String taxInvRcvrPhnNo = "";//세금계산서 공급받는자 전화번호
			String remitCoNm = "";//송금업체명
			String remitKndCd = "";//송금방법
			String crrBankCd = "";//선사계좌 입금은행명
			String crrBankAcctNo = "";//선사계좌 계좌번호
			String crrRemitAmt = "";//선사계좌 송금액
			String crrRemitDt = "";//송금일자
			String blIssUsrId = "";//발급자ID
			String blIssStsCd = "";//B/L발급상태코드
			String blIssRmk = "";//B/L 발급 거절사유
			String deltFlg = "";//삭제플래그
			String crrAcctCurrCd = "";//송금액 단위
			String blIssReqDt = "";//B/L 발급 희망일
			String crrUsaBankCd = "";//USA 선사계좌 입금은행명
			String crrUsaBankAcctNo = "";//USA 선사계좌 계좌번호
			String crrUsaRemitAmt = "";//USA 선사계좌 송금액
			String crrUsaRemitDt = "";//USA 송금일자
			String crrUsaAcctCurrCd = "";//USA 송금액 단위
			String creUsrId = "";//생성자
			String updUsrId = "";//수정자
			String blIssRqstCd = "";//request channel(Web, Mobile)
			String blRcvTpCd = "";//Original B/L을 수령하는 방법 
			String mnlBlObrdDt = "";//메뉴얼로 업데이트 된 bl onboard date
			String mnlBlIssDt = "";//메뉴얼로 업데이트 된 bl issue date
			String certiExistFlg = "";//Certificate 유무 여부
			String frtDpFlg = "";//freight term display 유무 여부
			
			
			for(BlRqstInfoRequest blRqstInfoRequest:blRqstInfoRequests){

				xterRqstNo = blRqstInfoRequest.getXTERRQSTNO();
				xterRqstSeq = blRqstInfoRequest.getXTERRQSTSEQ();
				blIssRqstDt = blRqstInfoRequest.getBLISSRQSTDT();
				rqstRctLocCd = blRqstInfoRequest.getRQSTRCTLOCCD();
				blNo = blRqstInfoRequest.getBLNO();
				vslCd = blRqstInfoRequest.getVSLCD();
				skdVoyNo = blRqstInfoRequest.getSKDVOYNO();
				skdDirCd = blRqstInfoRequest.getSKDDIRCD();
				vslNm = blRqstInfoRequest.getVSLNM();
				rqstBlTpCd = blRqstInfoRequest.getRQSTBLTPCD();
				rqstCoNm = blRqstInfoRequest.getRQSTCONM();
				rqstUsrEml = blRqstInfoRequest.getRQSTUSREML();
				rqstAtndNm = blRqstInfoRequest.getRQSTATNDNM();
				rqstPhnNo = blRqstInfoRequest.getRQSTPHNNO();
				blRqstRmk = blRqstInfoRequest.getBLRQSTRMK();
				actShprNm = blRqstInfoRequest.getACTSHPRNM();
				actShprRgstNo = blRqstInfoRequest.getACTSHPRRGSTNO();
				taxInvRcvrCoNm = blRqstInfoRequest.getTAXINVRCVRCONM();
				taxInvRcvrRgstNo = blRqstInfoRequest.getTAXINVRCVRRGSTNO();
				taxInvRcvrAtndNm = blRqstInfoRequest.getTAXINVRCVRATNDNM();
				taxInvRcvrPhnNo = blRqstInfoRequest.getTAXINVRCVRPHNNO();
				remitCoNm = blRqstInfoRequest.getREMITCONM();
				remitKndCd = blRqstInfoRequest.getREMITKNDCD();
				crrBankCd = blRqstInfoRequest.getCRRBANKCD();
				crrBankAcctNo = blRqstInfoRequest.getCRRBANKACCTNO();
				crrRemitAmt = blRqstInfoRequest.getCRRREMITAMT();
				crrRemitDt = blRqstInfoRequest.getCRRREMITDT();
				blIssUsrId = blRqstInfoRequest.getBLISSUSRID();
				blIssStsCd = blRqstInfoRequest.getBLISSSTSCD();
				blIssRmk = blRqstInfoRequest.getBLISSRMK();
				deltFlg = blRqstInfoRequest.getDELTFLG();
				crrAcctCurrCd = blRqstInfoRequest.getCRRACCTCURRCD();
				blIssReqDt = blRqstInfoRequest.getBLISSREQDT();
				crrUsaBankCd = blRqstInfoRequest.getCRRUSABANKCD();
				crrUsaBankAcctNo = blRqstInfoRequest.getCRRUSABANKACCTNO();
				crrUsaRemitAmt = blRqstInfoRequest.getCRRUSAREMITAMT();
				crrUsaRemitDt = blRqstInfoRequest.getCRRUSAREMITDT();
				crrUsaAcctCurrCd = blRqstInfoRequest.getCRRUSAACCTCURRCD();
				creUsrId = blRqstInfoRequest.getCREUSRID();
				updUsrId = blRqstInfoRequest.getUPDUSRID();
				blIssRqstCd = blRqstInfoRequest.getBLISSRQSTCD();
				blRcvTpCd = blRqstInfoRequest.getBLRCVTPCD();
				mnlBlObrdDt = blRqstInfoRequest.getMNLBLOBRDDT();
				mnlBlIssDt = blRqstInfoRequest.getMNLBLISSDT();
				certiExistFlg = blRqstInfoRequest.getCERTIEXISTFLG();
				frtDpFlg = blRqstInfoRequest.getFRTDPFLG();
				
				log.debug("@@@@@@WSProxy : blIssRqstCd = "+blIssRqstCd);
				log.debug("@@@@@@WSProxy : xter Rqst seq = "+xterRqstSeq);
					
				vo.setXterRqstNo(xterRqstNo);
				vo.setXterRqstSeq(xterRqstSeq);
				vo.setBlIssRqstDt(blIssRqstDt);
				vo.setRqstRctLocCd(rqstRctLocCd);
				vo.setBlNo(blNo);
				vo.setVslCd(vslCd);
				vo.setSkdVoyNo(skdVoyNo);
				vo.setSkdDirCd(skdDirCd);
				vo.setVslNm(vslNm);
				vo.setRqstBlTpCd(rqstBlTpCd);
				vo.setRqstCoNm(rqstCoNm);
				vo.setRqstUsrEml(rqstUsrEml);
				vo.setRqstAtndNm(rqstAtndNm);
				vo.setRqstPhnNo(rqstPhnNo);
				vo.setBlRqstRmk(blRqstRmk);
				vo.setActShprNm(actShprNm);
				vo.setActShprRgstNo(actShprRgstNo);
				vo.setTaxInvRcvrCoNm(taxInvRcvrCoNm);
				vo.setTaxInvRcvrRgstNo(taxInvRcvrRgstNo);
				vo.setTaxInvRcvrAtndNm(taxInvRcvrAtndNm);
				vo.setTaxInvRcvrPhnNo(taxInvRcvrPhnNo);
				vo.setRemitCoNm(remitCoNm);
				vo.setRemitKndCd(remitKndCd);
				vo.setCrrBankCd(crrBankCd);
				vo.setCrrBankAcctNo(crrBankAcctNo);
				vo.setCrrRemitAmt(crrRemitAmt);
				vo.setCrrRemitDt(crrRemitDt);
				vo.setBlIssUsrId(blIssUsrId);
				vo.setBlIssStsCd(blIssStsCd);
				vo.setBlIssRmk(blIssRmk);
				vo.setDeltFlg(deltFlg);
				vo.setCrrAcctCurrCd(crrAcctCurrCd);
				vo.setBlIssReqDt(blIssReqDt);
				vo.setCrrUsaBankCd(crrUsaBankCd);
				vo.setCrrUsaBankAcctNo(crrUsaBankAcctNo);
				vo.setCrrUsaRemitAmt(crrUsaRemitAmt);
				vo.setCrrUsaRemitDt(crrUsaRemitDt);
				vo.setCrrUsaAcctCurrCd(crrUsaAcctCurrCd);
				vo.setCreUsrId(creUsrId);
				vo.setUpdUsrId(updUsrId);
				vo.setBlIssRqstCd(blIssRqstCd);
				vo.setBlRcvTpCd(blRcvTpCd);
				vo.setMnlBlObrdDt(mnlBlObrdDt);
				vo.setMnlBlIssDt(mnlBlIssDt);
				vo.setCertiExistFlg(certiExistFlg);
				vo.setFrtDpFlg(frtDpFlg);
				
		        event.setBkgWebService005VO(vo);
				
				//blNo, xterRqstSeq, xterRqstNo 가 존재하지 않는 경우 EAI처리 실패
				if ((blNo == null || "".equals(blNo))
						|| (xterRqstSeq == null || "".equals(xterRqstSeq))
						|| (xterRqstNo == null || "".equals(xterRqstNo))) {	
					
					throw new EventException("Invalid DATA. No blNo or xterRqstSeq or xterRqstNo.");
					
				} else {
					EventResponse eventResponse = outboundBLMgtSC.perform(event);
					if (eventResponse != null) {
						if(eventResponse.getUserMessage() != null && !"".equals(eventResponse.getUserMessage())){
							result = "OK";
						}
					} else {
						log.debug("eventResponse is null.");
					}
				}
				if (documentResponse != null) {
					documentResponse.setRESULT(result);
				}
			}
			
			log.info(":::::>>> web0050001Document : " + web0050001Document);
		
		}  catch (Exception ex){
			log.error(ex.getMessage(), ex);
		}
		
		return result;
	}
}

