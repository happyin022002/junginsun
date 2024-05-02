/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : TCharterIOInvoiceVMS0020001WSProxy.java
 *@FileTitle : VMS002-0001 Interface 연동 
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.07.09
 *@LastModifier : 최우석
 *@LastVersion : 1.0
 * 2009.07.09 최우석
 * 1.0 최초 생성
 =========================================================*/
package com.clt.apps.opus.esm.fms.servicesio;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import org.apache.log4j.Logger;

import weblogic.jws.WLHttpTransport;

import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.TimeCharterInOutAccountingSC;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.event.EsmFmsVMS0020001Event;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchVesselCodeInvoiceInterfaceVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.irep.vms.VMS0020001Document;
import com.clt.irep.vms.VMS0020001Document.VMS0020001;

/**
 * WS에서 받은 xml 메세지를 Event에 담아 Service Command에 넘겨준다.
 * 
 * @author Choi,Woo-Seok
 * @see TimeCharterInOutAccountingSC 참조
 * @since J2EE 1.4
 */

@WebService(name="TCharterIOInvoiceVMS0020001WSProxyPortType", serviceName="TCharterIOInvoiceVMS0020001WSProxy", targetNamespace="http://www.clt.com/integration/opus")
@SOAPBinding(style=SOAPBinding.Style.DOCUMENT,use=SOAPBinding.Use.LITERAL, parameterStyle=SOAPBinding.ParameterStyle.WRAPPED)
@WLHttpTransport(contextPath="/opuscntr/webservices", serviceUri="/TCharterIOInvoiceVMS0020001WSProxy", portName="TCharterIOInvoiceVMS0020001WSProxyPort")
public class TCharterIOInvoiceVMS0020001WSProxy {
	protected transient Logger log = Logger.getLogger(this.getClass().getName());

	/**
	 * WS Receive(VMS002-0001)<br>
	 * 
	 * @param strXml String
	 * @return String
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	@WebMethod()
	public String searchVesselCodeInvoiceInterface(String strXml) throws Exception {
		TimeCharterInOutAccountingSC timeCharterInOutAccountingSC = new TimeCharterInOutAccountingSC();
		
		Event event = null;
		List<SearchVesselCodeInvoiceInterfaceVO> searchVesselCodeInvoiceInterfaceVO = null;
		VMS0020001Document sendDoc = VMS0020001Document.Factory.newInstance();

		try {
			event = new EsmFmsVMS0020001Event();
			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.SEARCH);
			event.setFormCommand(f);

			// ========== Requset Xml ============= //
			VMS0020001Document recvDoc = VMS0020001Document.Factory.parse(strXml);
			((EsmFmsVMS0020001Event)event).setXmlObject(recvDoc);
			EventResponse eventResponse = timeCharterInOutAccountingSC.perform(event);
	        searchVesselCodeInvoiceInterfaceVO = (List)eventResponse.getRsVoList();

			// ========== Response Xml ============= //
			VMS0020001 vmsdoc = sendDoc.addNewVMS0020001();
			VMS0020001Document.VMS0020001.DataArea sendData = vmsdoc.addNewDataArea();
			VMS0020001Document.VMS0020001.DataArea.ResponseMessage responseMsg = sendData.addNewResponseMessage();
			VMS0020001Document.VMS0020001.DataArea.ResponseMessage.CDAMStlCollection cdamStlCol = responseMsg.addNewCDAMStlCollection();
			
			for(int i = 0; i < searchVesselCodeInvoiceInterfaceVO.size(); i++) {
				VMS0020001Document.VMS0020001.DataArea.ResponseMessage.CDAMStlCollection.CDAMStl cdamStl = cdamStlCol.addNewCDAMStl();
				
				cdamStl.setLIFID(searchVesselCodeInvoiceInterfaceVO.get(i).getLifid());
				cdamStl.setSEQ(searchVesselCodeInvoiceInterfaceVO.get(i).getSeq());
				cdamStl.setTOTALCOUNT(searchVesselCodeInvoiceInterfaceVO.get(i).getTotalCount());
				cdamStl.setROWCOUNT(searchVesselCodeInvoiceInterfaceVO.get(i).getRowCount());
				cdamStl.setHINVSTDD(searchVesselCodeInvoiceInterfaceVO.get(i).getHInvStdd());
				cdamStl.setHINVENDDD(searchVesselCodeInvoiceInterfaceVO.get(i).getHInvEnddd());
				cdamStl.setHACCTCD(searchVesselCodeInvoiceInterfaceVO.get(i).getHAcctCd());
				cdamStl.setHACCTNM(searchVesselCodeInvoiceInterfaceVO.get(i).getHAcctNm());
				cdamStl.setHCURRCD(searchVesselCodeInvoiceInterfaceVO.get(i).getHCurrCd());
				cdamStl.setHINVDAMT(searchVesselCodeInvoiceInterfaceVO.get(i).getHInvdAmt());
			}

		} catch (Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new Exception(new ErrorHandler(ex).getMessage(), ex);
		}

		return sendDoc.toString();
	}
}