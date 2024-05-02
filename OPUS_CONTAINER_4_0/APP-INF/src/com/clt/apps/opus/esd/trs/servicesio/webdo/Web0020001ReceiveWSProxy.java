/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : Web0020001ReceiveWSProxy.java
 *@FileTitle : Web0020001ReceiveWSProxy
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.trs.servicesio.webdo;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import org.apache.log4j.Logger;

import weblogic.jws.WLHttpTransport;

import com.clt.apps.opus.esd.trs.servicesio.webdo.event.WebDoLinkEvent;
import com.clt.apps.opus.esd.trs.servicesio.webdo.vo.IfSchemaVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.html.FormCommand;

import com.clt.irep.opusws.WEB0020001Document;
import com.clt.irep.opusws.WEB0020001Document.WEB0020001;
import com.clt.irep.opusws.WEB0020001Document.WEB0020001.DataArea;
import com.clt.irep.opusws.WEB0020001Document.WEB0020001.DataArea.InfoCollection;
import com.clt.irep.opusws.WEB0020001Document.WEB0020001.DataArea.InfoCollection.Request;
import com.clt.irep.opusws.WEB0020001Document.WEB0020001.DataArea.InfoCollection.Response;

/**
 * EtsLink 에 대한 WebService Proxy<br>
 * 
 * @author Choi jonghyek
 * @see Web0020001ReceiveRSC 참조
 * @since J2EE 1.6
 */

@WebService(name = "Web0020001ReceiveWSProxyPortType", serviceName = "Web0020001ReceiveWSProxy", targetNamespace = "http://www.clt.com/integration")
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT, use = SOAPBinding.Use.LITERAL, parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
@WLHttpTransport(contextPath = "/opuscntr/webservices", serviceUri = "/Web0020001ReceiveWSProxy", portName = "Web0020001ReceiveWSProxyPort")
public class Web0020001ReceiveWSProxy {
	protected transient Logger log = Logger.getLogger(this.getClass().getName());

	/**
	 * 
	 * @param docIn
	 * @return String
	 */
	@WebMethod()
	public String web0020001ReceiveWS(WEB0020001Document docIn) {
		log.info("[TRS-SPP] Web0020001ReceiveWSProxy Start");

		Web0020001ReceiveRSC rsc = new Web0020001ReceiveRSC();
		IfSchemaVO vo = new IfSchemaVO();
		String returnFlag = "N";
		String result = "";

		try {
			if (docIn == null || "".equals(docIn)) {
				throw new EventException("Parameter is not valided !");
			}

			// ========= Command Add ===============
			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.MULTI01);
			// ========= Command Add ===============

			WebDoLinkEvent event = new WebDoLinkEvent();
			event.setFormCommand(f);

			// EAI에서 제공된 XSD파일을 Reading
			WEB0020001 web0020001doc = docIn.getWEB0020001();

			DataArea dataArea = web0020001doc.getDataArea();
			InfoCollection infoCollection = dataArea.getInfoCollection();
			Request[] web0020001Requests = infoCollection.getRequestArray();
			Response documentResponse = infoCollection.getResponse();

			String blNo = null;
			String ifSysKndCd = null;
			String fctryNm = null;
			String actCustN1stAddr = null;
			String actCustCtyNm = null;
			String actCustSteNm = null;
			String actCustZipCd = null;
			String cntcPsonNm = null;
			String cntcPsonPhnNo = null;
			String cntcPsonFaxNo = null;
			String usrEml = null;
			String usrPhnNo = null;
			String creOfcCd = null;
			String eqNo = null;
			String doRmk = null;
			String creUsrId = null;
			String updUsrId = null;

			for (Request request : web0020001Requests) {
				blNo = request.getBLNO();
				ifSysKndCd = request.getIFSYSKNDCD();
				fctryNm = request.getFCTRYNM();
				actCustN1stAddr = request.getACTCUSTN1STADDR();
				actCustCtyNm = request.getACTCUSTCTYNM();
				actCustSteNm = request.getACTCUSTSTENM();
				actCustZipCd = request.getACTCUSTZIPCD();
				cntcPsonNm = request.getCNTCPSONNM();
				cntcPsonPhnNo = request.getCNTCPSONPHNNO();
				cntcPsonFaxNo = request.getCNTCPSONFAXNO();
				usrEml = request.getUSREML();
				usrPhnNo = request.getUSRPHNNO();
				creOfcCd = request.getCREOFCCD();
				eqNo = request.getEQNO();
				doRmk = request.getDORMK();
				creUsrId = request.getCREUSRID();
				updUsrId = request.getUPDUSRID();

				vo.setBlNo(blNo);
				vo.setIfSysKndCd(ifSysKndCd);
				vo.setFctryNm(fctryNm);
				vo.setActCustN1stAddr(actCustN1stAddr);
				vo.setActCustCtyNm(actCustCtyNm);
				vo.setActCustSteNm(actCustSteNm);
				vo.setActCustZipCd(actCustZipCd);
				vo.setCntcPsonNm(cntcPsonNm);
				vo.setCntcPsonPhnNo(cntcPsonPhnNo);
				vo.setCntcPsonFaxNo(cntcPsonFaxNo);
				vo.setUsrEml(usrEml);
				vo.setUsrPhnNo(usrPhnNo);
				vo.setCreOfcCd(creOfcCd);
				vo.setEqNo(eqNo);
				vo.setDoRmk(doRmk);
				vo.setCreUsrId(creUsrId);
				vo.setUpdUsrId(updUsrId);

				event.setIfSchema(vo);
				// 예약번호, Bonded type 혹은 Manifest Reference No.가 존재하지 않는 경우 EAI처리 실패
				if ((blNo == null || "".equals(blNo)) || (eqNo == null || "".equals(eqNo))) {
					throw new EventException("Invalid Data");
				} else {
					EventResponse eventResponse = rsc.perform(event);
					result = eventResponse.getUserMessage();
					log.debug("@@@@@@WSProxy : result = " + result);
					if ("1".equals(result)) {
						returnFlag = "OK";
					}
				}

				log.debug("@@@@@@WSProxy : checking documentResponse");
				if (documentResponse != null) {
					log.debug("@@@@@@WSProxy : documentResponse is not null");
					documentResponse.setRESULT(returnFlag);
				}
			}
		} catch (EventException e) {
			log.error(e.getMessage(), e);
		} catch (Exception de) {
			log.error(de.getMessage(), de);
		}
		log.info("[TRS-SPP] Web0020001ReceiveWSProxy End");
		return returnFlag;
	}
}
