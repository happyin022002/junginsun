/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : TCharterIOInvoiceVMS0010001WSProxy.java
 *@FileTitle : VMS001-0001 Interface 연동 
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.07.09
 *@LastModifier : 최우석
 *@LastVersion : 1.0
 * 2009.07.09 최우석
 * 1.0 최초 생성
 =========================================================*/
package com.hanjin.apps.alps.esm.fms.servicesio;

import java.util.Map;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import org.apache.log4j.Logger;

import weblogic.jws.WLHttpTransport;

import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.TimeCharterInOutAccountingSC;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.event.EsmFmsVMS0010001Event;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.irep.vms.VMS0010001Document;
import com.hanjin.irep.vms.VMS0010001Document.VMS0010001;

/**
 * WS에서 받은 xml 메세지를 Event에 담아 Service Command에 넘겨준다.
 * 
 * @author Choi,Woo-Seok
 * @see TimeCharterInOutAccountingSC 참조
 * @since J2EE 1.4
 */

@WebService(name="TCharterIOInvoiceVMS0010001WSProxyPortType", serviceName="TCharterIOInvoiceVMS0010001WSProxy", targetNamespace="http://www.hanjin.com/integration/alps")
@SOAPBinding(style=SOAPBinding.Style.DOCUMENT,use=SOAPBinding.Use.LITERAL, parameterStyle=SOAPBinding.ParameterStyle.WRAPPED)
@WLHttpTransport(contextPath="/hanjin/webservices", serviceUri="/TCharterIOInvoiceVMS0010001WSProxy", portName="TCharterIOInvoiceVMS0010001WSProxyPort")
public class TCharterIOInvoiceVMS0010001WSProxy {
	protected transient Logger log = Logger.getLogger(this.getClass().getName());

	/**
	 * WS Receive(VMS001-0001)<br>
	 * 
	 * @param strXml String
	 * @return String
	 * @exception EventException
	 */
	@WebMethod()
	public String searchVesselCodeHireInterface(String strXml) throws Exception {
		TimeCharterInOutAccountingSC timeCharterInOutAccountingSC = new TimeCharterInOutAccountingSC();
		
		Event event = null;
		Map<String,String> etcData = null;
		String hireAmt = "";
		
		VMS0010001Document sendDoc = VMS0010001Document.Factory.newInstance();

		try {
			event = new EsmFmsVMS0010001Event();
			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.SEARCH);
			event.setFormCommand(f);

			// ========== Requset Xml ============= //
			VMS0010001Document recvDoc = VMS0010001Document.Factory.parse(strXml);
			((EsmFmsVMS0010001Event)event).setXmlObject(recvDoc);
			EventResponse eventResponse = timeCharterInOutAccountingSC.perform(event);
			etcData = eventResponse.getETCData();
			hireAmt = etcData.get("hireAmt");
			
			// ========== Response Xml ============= //
			VMS0010001 vmsdoc = sendDoc.addNewVMS0010001();
			VMS0010001Document.VMS0010001.DataArea sendData = vmsdoc.addNewDataArea();
			VMS0010001Document.VMS0010001.DataArea.ResponseMessage responseMsg = sendData.addNewResponseMessage();
			responseMsg.setRESULT(hireAmt);

		} catch (Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new Exception(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return sendDoc.toString();
	}
}