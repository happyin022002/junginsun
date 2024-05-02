/*========================================================
*Copyright(c) 2011 CyberLogitec
*ProcessChain    : ISD-1
*@FileName : BKGWeb0010001WSProxy.java
*@FileTitle : Homepage 에서 I/B 한국 세관 Bonded Type 정보 생성시 OPUS 로 I/F
*Open Issues :
*Change history :
*@LastModifyDate : 2015-05-22
*@LastModifier : 2002640
*@LastVersion : 1.0
* 2009-08-13
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esm.bkg.servicesio;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import org.apache.log4j.Logger;

import weblogic.jws.WLHttpTransport;

import com.clt.apps.opus.esm.bkg.customsdeclaration.CustomsDeclarationKoreaSC;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.event.EmsBkgWeb0010001Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.BkgWebServiceVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.irep.opusws.WEB0010001Document;
import com.clt.irep.opusws.WEB0010001Document.WEB0010001;
import com.clt.irep.opusws.WEB0010001Document.WEB0010001.DataArea;
import com.clt.irep.opusws.WEB0010001Document.WEB0010001.DataArea.AssignInfoCollection;
import com.clt.irep.opusws.WEB0010001Document.WEB0010001.DataArea.AssignInfoCollection.AssignInfoRequest;
import com.clt.irep.opusws.WEB0010001Document.WEB0010001.DataArea.AssignInfoCollection.AssignInfoResponse;

/**
 * BKGWeb0010001WSProxy.java
 * @author Su-Young, Lee
 * @see
 * @since J2SE 1.6
 * 2011. 9. 27.
 */
@WebService(name="BKGWeb0010001WSProxyPortType", serviceName="BKGWeb0010001WSProxy", targetNamespace="http://www.clt.com/integration/opus")
@SOAPBinding(style=SOAPBinding.Style.DOCUMENT, use=SOAPBinding.Use.LITERAL, parameterStyle=SOAPBinding.ParameterStyle.WRAPPED)
@WLHttpTransport(contextPath="/clt/webservices", serviceUri="/BKGWeb0010001WSProxy", portName="BKGWeb0010001WSProxyPort")
public class BKGWeb0010001WSProxy {

	protected transient Logger log = Logger.getLogger(this.getClass().getName());

	/**
	 * Homepage 에서 I/B 한국 세관 Bonded Type 정보 생성시 OPUS 로 I/F<br>
	 *
	 * @author Su-Young, Lee
	 * @category WEB001_0001
	 *
	 * @param WEB0010001Document web0010001Document
	 * @return String
	 */
	@WebMethod()
	public String web0010001ReceiveWS(WEB0010001Document web0010001Document) {

		//WebService EAI Result
		String result = "Failed";

		BkgWebServiceVO vo = new BkgWebServiceVO();
		CustomsDeclarationKoreaSC customsDeclarationKoreaSC = new CustomsDeclarationKoreaSC();

		try{
			// ========= Validation Parameters for WebServices =========
			if( web0010001Document == null || "".equals(web0010001Document) )
			{
				throw new EventException("Parameter is not valided !");
			}
			// ========= Validation Parameters for WebServices =========

			// ========= Command Add ===============
			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.MULTI01);
			// ========= Command Add ===============

			EmsBkgWeb0010001Event event = new EmsBkgWeb0010001Event();
	        event.setFormCommand(f);

			// EAI에서 제공된 XSD파일을 Reading
			WEB0010001 web0010001doc = web0010001Document.getWEB0010001();

			DataArea dataArea = web0010001doc.getDataArea();
			AssignInfoCollection assignInfoCollection = dataArea.getAssignInfoCollection();
			AssignInfoRequest[] assignInfoRequests = assignInfoCollection.getAssignInfoRequestArray();
			AssignInfoResponse documentResponse = assignInfoCollection.getAssignInfoResponse();

			//예약번호
			String bkgNo = "";
			//해당 BL에 대해 세관 신고형태 Type Code
			String bdTpCd = "";
			//Manifest Reference No.
			String mfRefNo = "";

			for(AssignInfoRequest assignInfoRequest:assignInfoRequests){
				bkgNo = assignInfoRequest.getBKGNO();
				bdTpCd = assignInfoRequest.getBDTPCD();
				mfRefNo = assignInfoRequest.getMFREFNO();

				vo.setBkgNo(bkgNo);
				vo.setBdTpCd(bdTpCd);
				vo.setMfRefNo(mfRefNo);
		        event.setBkgWebServiceVO(vo);

				//예약번호, Bonded type 혹은 Manifest Reference No.가 존재하지 않는 경우 EAI처리 실패
				if ((bkgNo == null || "".equals(bkgNo))
						|| (bdTpCd == null || "".equals(bdTpCd))
						|| (mfRefNo == null || "".equals(mfRefNo))) {

					throw new EventException("Invalid RQST DATE");

				} else {

					EventResponse eventResponse = customsDeclarationKoreaSC.perform(event);
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

			log.info(":::::>>> web0010001Document : " + web0010001Document);

		}  catch (Exception ex){
			log.error(ex.getMessage(), ex);
		}

		return result;
	}
}

