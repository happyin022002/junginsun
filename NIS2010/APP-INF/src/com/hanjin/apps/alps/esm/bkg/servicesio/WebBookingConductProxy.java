/*========================================================
*Copyright(c) 2011 CyberLogitec
*ProcessChain    : ISD-1
*@FileName       : WebBookingConductProxy.java
*@FileTitle      : Homepage BKG Request 접수 내역을  ALPS 로 I/F
*@Author         : Kim dohyun 
*Open Issues     :
*Change history  : 
*@LastModifyDate : 2014. 10. 2.
*@LastModifier   : 
*@LastVersion    : 1.0
* -------------------------------------------------------
* history
* 2014.10.02 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.servicesio;

import org.apache.log4j.Logger;

import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.jf.transfer.TransferEAI;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.EBookingConductSC;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.event.EsmBkgWeb0090001Event;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.BkgWebServiceVO;
import com.hanjin.irep.alpsws.WEB0090001Document;
import com.hanjin.irep.alpsws.WEB0090001Document.WEB0090001;
import com.hanjin.irep.alpsws.WEB0090001Document.WEB0090001.DataArea;
import com.hanjin.irep.alpsws.WEB0090001Document.WEB0090001.DataArea.AssignInfoCollection;
import com.hanjin.irep.alpsws.WEB0090001Document.WEB0090001.DataArea.AssignInfoCollection.AssignInfoRequest;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * BKGWeb0090001WSProxy.java
 * 
 * @author Kim dohyun
 * @see
 * @since J2EE 1.6 May 25, 2009
 */
public class WebBookingConductProxy {

	protected transient Logger log = Logger.getLogger(this.getClass().getName());

	/**
	 * Homepage BKG Request 접수 내역을  ALPS 로 I/F<br>
	 * 
	 * @param eai
	 * @exception DAOException
	 */
	public void webBookingConduct(TransferEAI eai) throws Exception {
		
		try
		{
			BkgWebServiceVO vo = new BkgWebServiceVO();
			EBookingConductSC eBookingConductSC = new EBookingConductSC();
			EsmBkgWeb0090001Event event = new EsmBkgWeb0090001Event();
			
			// XML SCHEMA
			WEB0090001Document doc = WEB0090001Document.Factory.parse(eai.getMessage());
			WEB0090001 web0090001doc = doc.getWEB0090001();
			DataArea dataArea = web0090001doc.getDataArea();
			AssignInfoCollection assignInfoCollection = dataArea.getAssignInfoCollection();
			AssignInfoRequest[] assignInfoRequests = assignInfoCollection.getAssignInfoRequestArray();

			String xterSndrId = "";
			String xterRqstNo = "";
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
					eBookingConductSC.perform(event);
				}
			}
			
		} catch (EventException ee) {
			eai.rollback(ee);
			log.error("EventException ee : " + ee.toString(), ee);
			throw new DAOException(new ErrorHandler(ee).getMessage());
		} catch (Exception e){
			eai.rollback(e);
			log.error("Exception e : " + e.toString());
			throw new DAOException(new ErrorHandler(e).getMessage());
		} finally {
			eai.close();
		}
	}
}