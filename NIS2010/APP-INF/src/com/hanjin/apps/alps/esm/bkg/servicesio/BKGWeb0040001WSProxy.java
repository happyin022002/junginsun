/*========================================================
*Copyright(c) 2011 CyberLogitec
*ProcessChain    : ISD-1
*@FileName       : BKGWeb0040001WSProxy.java
*@FileTitle      : 한진해운 홈페이지에서 OBL 출력시 ALPS에 출력정보 업데이트
*@Author         : Jong-ho Kim
*Open Issues     :
*Change history  :
*@LastModifyDate : 2011. 10. 12.
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
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.event.EsmBkgWeb0040001Event;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.BkgWebService004VO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.irep.alpsws.WEB0040001Document;
import com.hanjin.irep.alpsws.WEB0040001Document.WEB0040001;
import com.hanjin.irep.alpsws.WEB0040001Document.WEB0040001.DataArea;
import com.hanjin.irep.alpsws.WEB0040001Document.WEB0040001.DataArea.PrintInfoCollection;
import com.hanjin.irep.alpsws.WEB0040001Document.WEB0040001.DataArea.PrintInfoCollection.PrintInfoRequest;
import com.hanjin.irep.alpsws.WEB0040001Document.WEB0040001.DataArea.PrintInfoCollection.PrintInfoResponse;

/**
 * BKGWeb0040001WSProxy.java
 * @author Jong-ho Kim
 * @see 
 * @since J2SE 1.6
 * 2011.10.12.
 */
@WebService(name="BKGWeb0040001WSProxyPortType", serviceName="BKGWeb0040001WSProxy",
targetNamespace="http://www.hanjin.com/integration/alps")

@SOAPBinding(style=SOAPBinding.Style.DOCUMENT,
 use=SOAPBinding.Use.LITERAL,
 parameterStyle=SOAPBinding.ParameterStyle.WRAPPED)

@WLHttpTransport(contextPath="/hanjin/webservices", serviceUri="/BKGWeb0040001WSProxy",
     portName="BKGWeb0040001WSProxyPort")
public class BKGWeb0040001WSProxy {
	
	protected transient Logger log = Logger.getLogger(this.getClass().getName());
	
	/**
	 * 한진해운 홈페이지에서 OBL 출력시 ALPS에 출력정보 업데이트<br>
	 * 
	 * @author Jong-ho Kim
	 * @category WEB004_0001
	 * 
	 * @param WEB0040001Document web0040001Document
	 * @return String
	 */
	@WebMethod()
	public String web0040001ReceiveWS(WEB0040001Document web0040001Document){
		
		//WebService EAI Result
		String result = "Failed";

		BkgWebService004VO vo = new BkgWebService004VO();
		OutboundBLMgtSC outboundBLMgtSC = new OutboundBLMgtSC();
		
		try{
			// ========= Validation Parameters for WebServices ========= 
			if( web0040001Document == null || "".equals(web0040001Document) )
			{
				throw new EventException("Parameter is not valided !");
			}
			// ========= Validation Parameters for WebServices ========= 
			
			// ========= Command Add ===============
			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.MULTI01);
			// ========= Command Add ===============
			
			EsmBkgWeb0040001Event event = new EsmBkgWeb0040001Event();
	        event.setFormCommand(f);
			
			// EAI에서 제공된 XSD파일을 Reading
			WEB0040001 web0040001doc = web0040001Document.getWEB0040001();
			
			DataArea dataArea = web0040001doc.getDataArea();
			PrintInfoCollection printInfoCollection = dataArea.getPrintInfoCollection();
			PrintInfoRequest[] printInfoRequests = printInfoCollection.getPrintInfoRequestArray();
			PrintInfoResponse documentResponse = printInfoCollection.getPrintInfoResponse();
			

			String bkgNo = "";//선적예약 요청 번호
			String infoSeq = "";//Internet으로 BL Print Auth관련 Seq
			String blNo = "";//B/L Number
			String mrgFileNm = "";//Internet으로 B/L을 File로 생성한 경우의 pdf 파일명 
			String docEcdProcFlg = "";//문서 암호화 작업이 성공적으로 끝났는지 여부 
			String mrgDt = "";//Internet으로 B/L을 File로 생성한 경우의 pdf 파일을 생성할 최종 일자. 
			String n1stPrnDt = "";//Original B/L을 최초로 출력한 일자
			String wblPrnDt = "";//WayBill 출력일자
			String wblPrnGdt = "";//WayBill 출력일자(GDT)
			String prnUsrId = "";//Internet 으로 B/L Print한 외부 User ID
			String prnCustTpCd = "";//B/L을 출력하는 고객유형(CD01562) . N : NIS . W : WEB
			String inetBlSndViaCd = "";//INTERNET로 B/L을 전송하는 방법 .E : E-Mail . W : Web
			String shprCntCd = "";//Shipper 국가
			String shprSeq = "";//Shipper 고객순번
			String cneeCntCd = "";//Consignee 국가
			String cneeSeq = "";//Consignee 고객순번
			String ntfyCntCd = "";//Notify 국가
			String ntfySeq = "";//Notify 고객순번
			String frtFwrdCntCd = "";//Forwarder 국가
			String frtFwrdSeq = "";//Forwarder 고객순번
			String vslCd = "";//Vessel Code
			String skdVoyNo = "";//Vessle Schedule 항차
			String skdDirCd = "";//Direction Code
			String bkgCustTpCd = "";//한진해운과 거래 관계가 있는 Shipper, Consignee, Notify 중 누구의 요청으로 B/L을 Print 했는지를 관리함.
			String loclVerCtnt = "";//LOCAL PC의 OS VERSION
			String wblPrnKnt = "";//WAYBILL을 출력한 횟수
			String updUsrId = "";//수정자 ID
			
			
			for(PrintInfoRequest printInfoRequest:printInfoRequests){
				bkgNo = printInfoRequest.getBKGNO();
				infoSeq = printInfoRequest.getINFOSEQ();
				blNo = printInfoRequest.getBLNO();
				mrgFileNm = printInfoRequest.getMRGFILENM();
				docEcdProcFlg = printInfoRequest.getDOCECDPROCFLG();
				mrgDt = printInfoRequest.getMRGDT();
				n1stPrnDt = printInfoRequest.getN1STPRNDT();
				wblPrnDt = printInfoRequest.getWBLPRNDT();
				wblPrnGdt = printInfoRequest.getWBLPRNGDT();
				prnUsrId = printInfoRequest.getPRNUSRID();
				prnCustTpCd = printInfoRequest.getPRNCUSTTPCD();
				inetBlSndViaCd = printInfoRequest.getINETBLSNDVIACD();
				shprCntCd = printInfoRequest.getSHPRCNTCD();
				shprSeq = printInfoRequest.getSHPRSEQ();
				cneeCntCd = printInfoRequest.getCNEECNTCD();
				cneeSeq = printInfoRequest.getCNEESEQ();
				ntfyCntCd = printInfoRequest.getNTFYCNTCD();
				ntfySeq = printInfoRequest.getNTFYSEQ();
				frtFwrdCntCd = printInfoRequest.getFRTFWRDCNTCD();
				frtFwrdSeq = printInfoRequest.getFRTFWRDSEQ();
				vslCd = printInfoRequest.getVSLCD();
				skdVoyNo = printInfoRequest.getSKDVOYNO();
				skdDirCd = printInfoRequest.getSKDDIRCD();
				bkgCustTpCd = printInfoRequest.getBKGCUSTTPCD();
				loclVerCtnt = printInfoRequest.getLOCLVERCTNT();
				wblPrnKnt = printInfoRequest.getWBLPRNKNT();
				updUsrId = printInfoRequest.getUPDUSRID();
				
				log.debug("@@@@@@WSProxy : info seq = "+infoSeq);				
				
				vo.setBkgNo(bkgNo);
				vo.setInfoSeq(infoSeq);
				vo.setBlNo(blNo);
				vo.setMrgFileNm(mrgFileNm);
				vo.setDocEcdProcFlg(docEcdProcFlg);
				vo.setMrgDt(mrgDt);
				vo.setN1stPrnDt(n1stPrnDt);
				vo.setWblPrnDt(wblPrnDt);
				vo.setWblPrnGdt(wblPrnGdt);
				vo.setPrnUsrId(prnUsrId);
				vo.setPrnCustTpCd(prnCustTpCd);
				vo.setInetBlSndViaCd(inetBlSndViaCd);
				vo.setShprCntCd(shprCntCd);
				vo.setShprSeq(shprSeq);
				vo.setCneeCntCd(cneeCntCd);
				vo.setCneeSeq(cneeSeq);
				vo.setNtfyCntCd(ntfyCntCd);
				vo.setNtfySeq(ntfySeq);
				vo.setFrtFwrdCntCd(frtFwrdCntCd);
				vo.setFrtFwrdSeq(frtFwrdSeq);
				vo.setVslCd(vslCd);
				vo.setSkdVoyNo(skdVoyNo);
				vo.setSkdDirCd(skdDirCd);
				vo.setBkgCustTpCd(bkgCustTpCd);
				vo.setLoclVerCtnt(loclVerCtnt);
				vo.setWblPrnKnt(wblPrnKnt);
				vo.setUpdUsrId(updUsrId);
				
		        event.setBkgWebService004VO(vo);
		        
				//bkgNo, infoSeq가 존재하지 않는 경우 EAI처리 실패
				if ((bkgNo == null || "".equals(bkgNo))
						|| (infoSeq == null || "".equals(infoSeq))) {	
					
					throw new EventException("Invalid DATA. No bkgNo or infoSeq.");
					
				} else {
					EventResponse eventResponse = outboundBLMgtSC.perform(event);
					log.info(eventResponse.getUserMessage());
					log.debug("RESULT OK");
					if (eventResponse != null) {
						if(eventResponse.getUserMessage() != null && !"".equals(eventResponse.getUserMessage())){
							result = "OK";
						}
					} else {
						log.debug("eventResponse is null..");
					}
				}
				log.debug("call setRESULT START");
				if (documentResponse != null) {
					documentResponse.setRESULT(result);
				}
				log.debug("call setRESULT END");
				log.debug("@@@@@@WSProxy : result = [ "+result+" ]");
			}
			log.info(":::::>>> web0040001Document : " + web0040001Document);
		
		}  catch (Exception ex){
			log.error(ex.getMessage(), ex);
		}
		
		return result;
	}
}
