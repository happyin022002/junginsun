/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SpotBiddingIWSProxy.java
*@FileTitle : SpotBidding Web-Service
*Open Issues :
*Change history :
*@LastModifyDate : 2015-06-22
*@LastModifier : SHIN DONG IL
*@LastVersion : 1.0
* 2015-06-22 SHIN DONG IL
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.spotbiddingmange;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import org.apache.log4j.Logger;
import weblogic.jws.WLHttpTransport;

import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.controller.html.FormCommand;

import com.hanjin.apps.alps.esd.trs.servicesio.spotbiddingmange.event.SpotBiddingListRequest;
import com.hanjin.apps.alps.esd.trs.servicesio.spotbiddingmange.event.SpotBiddingListEventResponse;
import com.hanjin.apps.alps.esd.trs.servicesio.spotbiddingmange.event.SpotBiddingListResponse;
import com.hanjin.apps.alps.esd.trs.servicesio.spotbiddingmange.event.SpotBiddingListSendEvent;
import com.hanjin.apps.alps.esd.trs.servicesio.spotbiddingmange.event.SpotBiddingLowestAmtRequest;
import com.hanjin.apps.alps.esd.trs.servicesio.spotbiddingmange.event.SpotBiddingLowestAmtEvent;
import com.hanjin.apps.alps.esd.trs.servicesio.spotbiddingmange.event.SpotBiddingLowestAmtEventResponse;
import com.hanjin.apps.alps.esd.trs.servicesio.spotbiddingmange.event.SpotBiddingLowestAmtResponse;
import com.hanjin.apps.alps.esd.trs.servicesio.spotbiddingmange.event.SpotBiddingReceiveBiddingAmtRequest;
import com.hanjin.apps.alps.esd.trs.servicesio.spotbiddingmange.event.SpotBiddingReceiveBiddingAmtEvent;
import com.hanjin.apps.alps.esd.trs.servicesio.spotbiddingmange.event.SpotBiddingReceiveBiddingAmtEventResponse;
import com.hanjin.apps.alps.esd.trs.servicesio.spotbiddingmange.event.SpotBiddingSpUsrInfoEvent;
import com.hanjin.apps.alps.esd.trs.servicesio.spotbiddingmange.event.SpotBiddingSpUsrInfoEventResponse;
import com.hanjin.apps.alps.esd.trs.servicesio.spotbiddingmange.event.SpotBiddingSpUsrInfoRequest;
import com.hanjin.apps.alps.esd.trs.servicesio.spotbiddingmange.event.SpotBiddingSendReeferCargoInfoRequest;
import com.hanjin.apps.alps.esd.trs.servicesio.spotbiddingmange.event.SpotBiddingSendReeferCargoInfoEvent;
import com.hanjin.apps.alps.esd.trs.servicesio.spotbiddingmange.event.SpotBiddingSendReeferCargoInfoResponse;
import com.hanjin.apps.alps.esd.trs.servicesio.spotbiddingmange.event.SpotBiddingSendReeferCargoInfoEventResponse;
import com.hanjin.apps.alps.esd.trs.servicesio.spotbiddingmange.event.SpotBiddingSendAwkwardCargoInfoRequest;
import com.hanjin.apps.alps.esd.trs.servicesio.spotbiddingmange.event.SpotBiddingSendAwkwardCargoInfoEvent;
import com.hanjin.apps.alps.esd.trs.servicesio.spotbiddingmange.event.SpotBiddingSendAwkwardCargoInfoResponse;
import com.hanjin.apps.alps.esd.trs.servicesio.spotbiddingmange.event.SpotBiddingSendAwkwardCargoInfoEventResponse;
import com.hanjin.apps.alps.esd.trs.servicesio.spotbiddingmange.event.SpotBiddingSendDangerCargoInfoRequest;
import com.hanjin.apps.alps.esd.trs.servicesio.spotbiddingmange.event.SpotBiddingSendDangerCargoInfoEvent;
import com.hanjin.apps.alps.esd.trs.servicesio.spotbiddingmange.event.SpotBiddingSendDangerCargoInfoResponse;
import com.hanjin.apps.alps.esd.trs.servicesio.spotbiddingmange.event.SpotBiddingSendDangerCargoInfoEventResponse;

/**
 * SpotBidding WebService Proxy<br>
 *
 * @author SHIN DONG IL
 * @see SpotBidding 
 * @since J2EE 1.6 
 */
@WebService(name="SpotBiddingManageWSProxyPortType", serviceName="SpotBiddingManageWSProxy",
        targetNamespace="http://www.smlines.com/integration")
@SOAPBinding(style=SOAPBinding.Style.DOCUMENT,
         use=SOAPBinding.Use.LITERAL,
         parameterStyle=SOAPBinding.ParameterStyle.WRAPPED)
@WLHttpTransport(contextPath="/hanjin/webservices", serviceUri="/SpotBiddingManageWSProxy",
             portName="SpotBiddingManageWSProxyPort")
public class SpotBiddingManageWSProxy {
	/**
	 * Log
	 */ 
    protected transient Logger log = Logger.getLogger(this.getClass().getName());

   /**
    * SPP의 조회조건을 I/F 받아 조회결과를 SPP로 I/F해준다.
    *  
    * @param docIn SpotBiddingListRequest
    * @return docOut SpotBiddingListEventResponse
    */
    @WebMethod()
    public SpotBiddingListEventResponse sendSpotBiddingList(SpotBiddingListRequest docIn){
    	Event event = null;
    	SpotBiddingManageRSC rsc = new SpotBiddingManageRSC();
    	SpotBiddingListEventResponse docOut = new SpotBiddingListEventResponse();
    	
    	
		try {
			event = new SpotBiddingListSendEvent
					(docIn.getBid_vndr_seq()
					,docIn.getBid_fm_due_dt()
					,docIn.getBid_to_due_dt()
					,docIn.getBid_sts_cd()
					,docIn.getBid_no()
					,docIn.getBkg_no()
					,docIn.getWo_no()
					,docIn.getWin_flg()
					);
			
			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.SEARCH01);
			event.setFormCommand(f);
			
			/**
			 * EventResponse로 부터 전송 객체의 추출
			 */
			SpotBiddingListResponse response = (SpotBiddingListResponse)rsc.perform(event);
			
			docOut.setSpotBiddingListSend(response.getSpotBiddingListSend());
			docOut.setIf_flg("Y");
			docOut.setIf_err_msg("");

		} catch (EventException e) {
			log.error(e.getMessage(),e);
			docOut.setIf_flg("N");
			docOut.setIf_err_msg(e.getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			docOut.setIf_flg("N");
			docOut.setIf_err_msg(e.getMessage());
		}
		return docOut;
    }
    
   /**
    * SPP에서 최저가 조회시 Bid no별 최저가 결과를 SPP로 I/F해준다.
    * 
    * @param docIn SpotBiddingLowestAmtRequest
    * @return docOut SpotBiddingLowestAmtEventResponse
    */
    @WebMethod()
    public SpotBiddingLowestAmtEventResponse sendSpotBiddingLowestAmt(SpotBiddingLowestAmtRequest docIn){
    	Event event = null;
    	SpotBiddingManageRSC rsc = new SpotBiddingManageRSC();
    	SpotBiddingLowestAmtEventResponse docOut = new SpotBiddingLowestAmtEventResponse();
    	
		try {
			event = new SpotBiddingLowestAmtEvent(docIn.getSpotBiddingLowestAmt(),docIn.getVndr_seq());
			
			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.SEARCH01);
			event.setFormCommand(f);
			
			/**
			 * EventResponse로 부터 전송 객체의 추출
			 */
			SpotBiddingLowestAmtResponse response = (SpotBiddingLowestAmtResponse)rsc.perform(event);
			docOut.setSpotBiddingLowestAmt(response.getSpotBiddingLowestAmt());
			
			docOut.setIf_flg("Y");
			docOut.setIf_err_msg("");
		} catch (EventException e) {
			log.error(e.getMessage(),e);
			docOut.setIf_flg("N");
			docOut.setIf_err_msg(e.getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			docOut.setIf_flg("N");
			docOut.setIf_err_msg(e.getMessage());

		}
		return docOut;
    }
  /**
   * SPP에서 입찰 금액을 I/F받아 Bid No, Vendor별 입찰금액의 최종금액과 History
   * 
   * @param docIn SpotBiddingReceiveBiddingAmtRequest
   * @return docOut SpotBiddingReceiveBiddingAmtEventResponse
   */
    @WebMethod()
    public SpotBiddingReceiveBiddingAmtEventResponse spotBiddingReceiveBiddingAmt (SpotBiddingReceiveBiddingAmtRequest docIn){
      	Event event = null;
    	SpotBiddingManageRSC rsc = new SpotBiddingManageRSC();
    	SpotBiddingReceiveBiddingAmtEventResponse docOut = new SpotBiddingReceiveBiddingAmtEventResponse();
    	try {
    	    event = new SpotBiddingReceiveBiddingAmtEvent(docIn.getSpotBiddingReceiveBiddingAmt());
    	    
			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.SEARCH01);
			event.setFormCommand(f);
			
			rsc.perform(event);
			
			docOut.setIf_flg("Y");
			docOut.setIf_err_msg("");
		} catch (EventException e) {
			log.error(e.getMessage(),e);
			docOut.setIf_flg("N");
			docOut.setIf_err_msg(e.getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			docOut.setIf_flg("N");
			docOut.setIf_err_msg(e.getMessage());
	
		}
    	
    	return docOut;
    }
    
    /**
	 * SPP에서 User정보를 I/F받아 Vendor의 SPP Flag를 Update한다.
	 * 
     * @param docIn SpotBiddingSpUsrInfoRequest
     * @return docOut SpotBiddingSpUsrInfoEventResponse
     */
    @WebMethod()
    public SpotBiddingSpUsrInfoEventResponse spotBiddingSpUsrInfoManage (SpotBiddingSpUsrInfoRequest docIn){
      	Event event = null;
    	SpotBiddingManageRSC rsc = new SpotBiddingManageRSC();
    	SpotBiddingSpUsrInfoEventResponse docOut = new SpotBiddingSpUsrInfoEventResponse();
    	try {
    	    event = new SpotBiddingSpUsrInfoEvent(docIn.getSpotBiddingSpUsrInfo());
    	    
			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.SEARCH01);

			event.setFormCommand(f);
			rsc.perform(event);

			docOut.setIf_flg("Y");
			docOut.setIf_err_msg("");
		} catch (EventException e) {
			log.error(e.getMessage(),e);
			docOut.setIf_flg("N");
			docOut.setIf_err_msg(e.getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			docOut.setIf_flg("N");
			docOut.setIf_err_msg(e.getMessage());
		}
    	return docOut;
    }
    
    /**
	 * BKG Special Reefer Cargo  정보를 SPP로 전송
	 * 
     * @param docIn SpotBiddingSendReeferCargoRequest
     * @return docOut SpotBiddingSpUsrInfoEventResponse
     */
    @WebMethod()
    public SpotBiddingSendReeferCargoInfoEventResponse spotBiddingSendReeferCargoInfo (SpotBiddingSendReeferCargoInfoRequest docIn){
    	Event event = null;
    	SpotBiddingManageRSC rsc = new SpotBiddingManageRSC();
    	SpotBiddingSendReeferCargoInfoEventResponse docOut = new SpotBiddingSendReeferCargoInfoEventResponse();
    	try {
    	    event = new SpotBiddingSendReeferCargoInfoEvent(docIn.getBkg_no(),docIn.getEq_no());
    	    
			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.SEARCH01);
			event.setFormCommand(f);
			rsc.perform(event);
			
		   /**
		    * EventResponse로 부터 전송 객체의 추출
		    */
			SpotBiddingSendReeferCargoInfoResponse response = (SpotBiddingSendReeferCargoInfoResponse)rsc.perform(event);

			docOut.setSpotBiddingSendReeferCargoInfo(response.getSpotBiddingSendReeferCargoInfo());
			docOut.setIf_flg("Y");
			docOut.setIf_err_msg("");
		} catch (EventException e) {
			log.error(e.getMessage(),e);
			docOut.setIf_flg("N");
			docOut.setIf_err_msg(e.getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			docOut.setIf_flg("N");
			docOut.setIf_err_msg(e.getMessage());
		}
    	return docOut;
    }
    
    /**
	 * BKG Special Cargo Reefer 정보를 SPP로 전송
	 * 
     * @param docIn SpotBiddingSendAwkwardCargoInfoRequest
     * @return docOut SpotBiddingSendAwkwardCargoInfoEventResponse
     */
    @WebMethod()
    public SpotBiddingSendAwkwardCargoInfoEventResponse spotBiddingSendAwkwardCargoInfo (SpotBiddingSendAwkwardCargoInfoRequest docIn){
    	Event event = null;
    	SpotBiddingManageRSC rsc = new SpotBiddingManageRSC();
    	SpotBiddingSendAwkwardCargoInfoEventResponse docOut = new SpotBiddingSendAwkwardCargoInfoEventResponse();
    	try {
    	    event = new SpotBiddingSendAwkwardCargoInfoEvent(docIn.getBkg_no(),docIn.getEq_no());
    	    
			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.SEARCH01);
			event.setFormCommand(f);
		   /**
		    * EventResponse로 부터 전송 객체의 추출
		    */
			SpotBiddingSendAwkwardCargoInfoResponse response = (SpotBiddingSendAwkwardCargoInfoResponse)rsc.perform(event);
			
			docOut.setSpotBiddingSendAwkwardCargoInfo(response.getSpotBiddingSendAwkwardCargoInfo());
			docOut.setIf_flg("Y");
			docOut.setIf_err_msg("");
		} catch (EventException e) {
			log.error(e.getMessage(),e);
			docOut.setIf_flg("N");
			docOut.setIf_err_msg(e.getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			docOut.setIf_flg("N");
			docOut.setIf_err_msg(e.getMessage());
		}
    	return docOut;
    }
    
    /**
	 * BKG Special Cargo Danger 정보를 SPP로 전송
	 * 
     * @param docIn SpotBiddingSendDangerCargoInfoRequest
     * @return docOut SpotBiddingSendDangerCargoInfoEventResponse
     */
    @WebMethod()
    public SpotBiddingSendDangerCargoInfoEventResponse spotBiddingSendDangerCargoInfo (SpotBiddingSendDangerCargoInfoRequest docIn){
    	Event event = null;
    	SpotBiddingManageRSC rsc = new SpotBiddingManageRSC();
    	SpotBiddingSendDangerCargoInfoEventResponse docOut = new SpotBiddingSendDangerCargoInfoEventResponse();
    	try {
    	    event = new SpotBiddingSendDangerCargoInfoEvent(docIn.getBkg_no(),docIn.getEq_no());
    	    
			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.SEARCH01);
			event.setFormCommand(f);

		   /**
		    * EventResponse로 부터 전송 객체의 추출
		    */
			SpotBiddingSendDangerCargoInfoResponse response = (SpotBiddingSendDangerCargoInfoResponse)rsc.perform(event);
			
			docOut.setSpotBiddingSendDangerCargoInfo(response.getSpotBiddingSendDangerCargoInfo());
			docOut.setIf_flg("Y");
			docOut.setIf_err_msg("");
		} catch (EventException e) {
			log.error(e.getMessage(),e);
			docOut.setIf_flg("N");
			docOut.setIf_err_msg(e.getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			docOut.setIf_flg("N");
			docOut.setIf_err_msg(e.getMessage());
		}
    	return docOut;
    }
}