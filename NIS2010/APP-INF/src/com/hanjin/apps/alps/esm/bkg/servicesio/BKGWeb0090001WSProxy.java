/*========================================================
*Copyright(c) 2011 CyberLogitec
*ProcessChain    : ISD-1
*@FileName       : BKGWeb0090001WSProxy.java
*@FileTitle      : Homepage BKG Request 접수 내역을  ALPS 로 I/F
*@Author         : Kim dohyun
*Open Issues     :
*Change history  : 
*@LastModifyDate : 2014. 09. 01.
*@LastModifier   : 
*@LastVersion    : 1.6
* -------------------------------------------------------
* history
* 2014.09.01 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.servicesio;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import org.apache.log4j.Logger;
import weblogic.jws.WLHttpTransport;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.EBookingConductSC;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.event.EsmBkgWeb0090001Event;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.BkgWebServiceVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.irep.alpsws.WEB0090001Document;
import com.hanjin.irep.alpsws.WEB0090001Document.WEB0090001;
import com.hanjin.irep.alpsws.WEB0090001Document.WEB0090001.DataArea;
import com.hanjin.irep.alpsws.WEB0090001Document.WEB0090001.DataArea.AssignInfoCollection;
import com.hanjin.irep.alpsws.WEB0090001Document.WEB0090001.DataArea.AssignInfoCollection.AssignInfoRequest;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * BKGWeb0090001WSProxy.java
 * @author 
 * @see 
 * @since J2SE 1.6
 * 2014. 9. 1.
 */
@WebService(name="BKGWeb0090001WSProxyPortType", serviceName="BKGWeb0090001WSProxy",
targetNamespace="http://www.hanjin.com/integration/alps")

@SOAPBinding(style=SOAPBinding.Style.DOCUMENT,
 use=SOAPBinding.Use.LITERAL,
 parameterStyle=SOAPBinding.ParameterStyle.WRAPPED)

@WLHttpTransport(contextPath="/hanjin/webservices", serviceUri="/BKGWeb0090001WSProxy",
     portName="BKGWeb0090001WSProxyPort")
public class BKGWeb0090001WSProxy {
	
	protected transient Logger log = Logger.getLogger(this.getClass().getName());
	
	/**
	 * Homepage BKG Request 접수 내역을  ALPS 로 I/F<br>
	 * 
	 * @author 
	 * @category WEB009_0001
	 * 
	 * @param WEB0090001Document web0090001Document
	 * @return String
	 */
	@WebMethod()
	public void web0090001ReceiveWS(WEB0090001Document web0090001Document){
		
		BkgWebServiceVO vo = new BkgWebServiceVO();
		EBookingConductSC eBookingConductSC = new EBookingConductSC();
		
		try{
			// ========= Validation Parameters for WebServices ========= 
			if( web0090001Document == null || "".equals(web0090001Document) )
			{
				throw new EventException("Parameter is not valided !");
			}
			// ========= Validation Parameters for WebServices ========= 
			
			EsmBkgWeb0090001Event event = new EsmBkgWeb0090001Event();
			
			// EAI에서 제공된 XSD파일을 Reading
			WEB0090001 web0090001doc = web0090001Document.getWEB0090001();
			
			DataArea dataArea = web0090001doc.getDataArea();
			AssignInfoCollection assignInfoCollection = dataArea.getAssignInfoCollection();
			AssignInfoRequest[] assignInfoRequests = assignInfoCollection.getAssignInfoRequestArray();
			
			//예약번호
			String xterSndrId = "";
			//해당 BL에 대해 세관 신고형태 Type Code
			String xterRqstNo = "";
			//Manifest Reference No.
			String xterRqstSeq = "";
			
			for(AssignInfoRequest assignInfoRequest:assignInfoRequests){
				xterSndrId = assignInfoRequest.getXTERSNDRID();
				xterRqstNo = assignInfoRequest.getXTERRQSTNO();
				xterRqstSeq = assignInfoRequest.getXTERRQSTSEQ();
	        
				vo.setXterSndrId(xterSndrId);
				vo.setXterRqstNo(xterRqstNo);
				vo.setXterRqstSeq(xterRqstSeq);
		        event.setBkgWebServiceVO(vo);
				
	            SignOnUserAccount account = new SignOnUserAccount("HOMEPAGE"
	                    , "SM Line", "3", "4", "5", "6", "7", "8",
	                    "9", "10", "11", "12", "", "14",
	                    "15", "16", "17", "18", "19", "20", "21", "22");
				event.setAttribute("com.hanjin.component.signon.SIGN_ON_USER_ACCOUNT", account);
				event.setAttribute("account", account);

				//xterSndrId, xterRqstNo, xterRqstSeq가 존재하지 않는 경우 EAI처리 실패
				if ((xterSndrId == null || "".equals(xterSndrId))
						|| (xterRqstNo == null || "".equals(xterRqstNo))
						|| (xterRqstSeq == null || "".equals(xterRqstSeq))) {	
					throw new EventException("Invalid Request");
					
				} else {
					EventResponse eventResponse = eBookingConductSC.perform(event);
				}
			}
			
			log.info(":::::>>> web0090001Document : " + web0090001Document);
		
		}  catch (Exception ex){
			log.error(ex.getMessage(), ex);
		}
		
	}
	
//	public static void main(String[] args) throws Exception {
//		//WebService EAI Result
//		String result = "Failed";
//		BkgWebServiceVO vo = new BkgWebServiceVO();
//		EBookingConductSC eBookingConductSC = new EBookingConductSC();
//    	
//		try {
//	    	System.setProperty("java.naming.factory.initial","weblogic.jndi.WLInitialContextFactory");
//	    	System.setProperty("java.naming.factory.url.pkgs","weblogic.jndi.factories:weblogic.corba.j2ee.naming.url:weblogic.jndi.factories:weblogic.corba.j2ee.naming.url");
//	    	System.setProperty("java.naming.provider.url","t3://localhost:7001");
//	    	System.setProperty("java.naming.security.principal","weblogic");
//	    	System.setProperty("java.naming.security.credentials","weblogic");
//			
//			EsmBkgWeb0090001Event event = new EsmBkgWeb0090001Event();
//			String xterSndrId = "WEB";
//			String xterRqstNo = "SEL4D6363600";
//			String xterRqstSeq = "1";
//			
//			vo.setXterSndrId(xterSndrId);
//			vo.setXterRqstNo(xterRqstNo);
//			vo.setXterRqstSeq(xterRqstSeq);
//	        event.setBkgWebServiceVO(vo);
//				
//            SignOnUserAccount account = new SignOnUserAccount("HOMEPAGE"
//										                    , "SM Line", "3", "4", "5", "6", "7", "8",
//										                    "9", "10", "11", "12", "", "14",
//										                    "15", "16", "17", "18", "19", "20", "21", "22");
//            event.setAttribute("com.hanjin.component.signon.SIGN_ON_USER_ACCOUNT", account);
//            event.setAttribute("account", account);
//				
//			//xterSndrId, xterRqstNo, xterRqstSeq가 존재하지 않는 경우 EAI처리 실패
//			if ((xterSndrId == null || "".equals(xterSndrId))
//					|| (xterRqstNo == null || "".equals(xterRqstNo))
//					|| (xterRqstSeq == null || "".equals(xterRqstSeq))) {	
//				
//				throw new EventException("Invalid Request");
//				
//			} else {
//				
//				EventResponse eventResponse = eBookingConductSC.perform(event);
//				if (eventResponse != null) {
//					if(eventResponse.getUserMessage() != null && !"".equals(eventResponse.getUserMessage())){
//						result = "OK";
//					}
//				} else {
////						log.debug("eventResponse is null.");
//				}
//			}
//	    	
//		} catch (EventException ee) {
//			throw new EventException(new ErrorHandler(ee).getMessage(), ee);
//		} catch (Exception e) {
//			throw new EventException(new ErrorHandler(e).getMessage(), e);
//	 	}
//    }
	
}

