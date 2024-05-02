/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ESD_TRS_0092HTMLAction.java
*@FileTitle : Spot Bid Performance Report
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 
* 2016-02-03 juhyun
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.biddingmanage.spotbidperformancereport.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;


/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esd.trs.biddingmanage.spotbidperformancereport 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 BiddingManageSC로 실행요청<br>
 * - BiddingManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author 
 * @see EsdTrs0092Event , ESD_TRS_0092EventResponse 참조
 * @since J2EE 1.4
 */
public class ESD_TRS_0092HTMLAction extends HTMLActionSupport {

	/**
	 * ESD_TRS_0092HTMLAction 객체를 생성
	 */
	public ESD_TRS_0092HTMLAction() {
	}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ESD_TRS_0092Event로 파싱하여 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
		EsdTrs0092Event event = new EsdTrs0092Event();
		
		event.setOpener(JSPUtil.getParameter(request,"opener",""));						//popup 을 통해 열수도 있음,.(chreport)            
		event.setHidWrkOfc(JSPUtil.getParameter(request,"hid_wrkofc",""));				//popup 을 통해 열수도 있음,.(chreport)          
		event.setHidTroSts(JSPUtil.getParameter(request,"hid_trosts","")); 				//popup 을 통해 열수도 있음,.(chreport)          
		event.setHidTpsz(JSPUtil.getParameter(request,"hid_tpsz",""));		 			//popup 을 통해 열수도 있음,.(chreport)            
		event.setTrunkVvd(JSPUtil.getParameter(request,"trunk_vvd",""));				//trunk_vvd                                         
		event.setBkgNumber(JSPUtil.getParameter(request,"bkgnumber",""));				//bkgnumber                                         
		event.setBlNumber(JSPUtil.getParameter(request,"blnumber",""));					//blnumber                                          
		event.setSoNumber(JSPUtil.getParameter(request,"sonumber",""));					//S/O  INPUT BOX                                    
		event.setWoNumber(JSPUtil.getParameter(request,"wonumber",""));					//W/O No. INPUT BOX                                
		event.setCopNumber(JSPUtil.getParameter(request,"copnumber",""));				//COP INPUT BOX                                
		event.setInvoiceNumber(JSPUtil.getParameter(request,"invoicenumber",""));		//Invoice No.                                     
		event.setEqNumber(JSPUtil.getParameter(request,"eqnumber",""));					//EQ No.                                            
		event.setZipCode(JSPUtil.getParameter(request,"zip_code",""));					//Zip Code.                                            
		event.setHidRadioEq(JSPUtil.getParameter(request,"hid_radio_eq",""));			//EQ No.                                          
		event.setMtyRefNumber(JSPUtil.getParameter(request,"mtyrefnumber",""));			//MTY REF No.                                   	
		event.setHidGridFlg(JSPUtil.getParameter(request,"hid_grid_flg",""));			//MTY REF No.
		event.setHidUnplanned(JSPUtil.getParameter(request,"hid_unplanned",""));		//EQ No.
		event.setHidPeriod(JSPUtil.getParameter(request,"hid_period",""));     			//S/O Creation   W/O Issue    Invoice Confirm  
		event.setHidFromDate(JSPUtil.getParameter(request,"hid_from_date",""));			//hid_from_date                                  
		event.setHidToDate(JSPUtil.getParameter(request,"hid_to_date",""));				//hid_to_date
		event.setHidRadioOffice(JSPUtil.getParameter(request,"hid_radio_office",""));	//hid_radio_office
		event.setInputOffice(JSPUtil.getParameter(request,"input_office",""));			//input_office                                    
		event.setHidSoMode(JSPUtil.getParameter(request,"hid_somode",""));				//S/O combo                                       
		event.setHidWoMode(JSPUtil.getParameter(request,"hid_womode",""));				//WO combo                                        
		event.setHidInvoiceMode(JSPUtil.getParameter(request,"hid_invoicemode",""));	//invoice combo                                   
		event.setHidCargoMode(JSPUtil.getParameter(request,"hid_cargomode",""));		//cargo combo                                     
		event.setHidBoundMode(JSPUtil.getParameter(request,"hid_boundmode",""));		//bound combo                                     
		event.setHidRadioUser(JSPUtil.getParameter(request,"hid_radio_user",""));		//radio_user                                    
		event.setUserId(JSPUtil.getParameter(request,"user_id",""));					//user_id                                             
		event.setHidCostMode(JSPUtil.getParameter(request,"hid_costmode",""));			//cost mode                                        
		event.setHidTransMode(JSPUtil.getParameter(request,"hid_transmode",""));		//trans mode                                       
		event.setHidSoType(JSPUtil.getParameter(request,"hid_sotype",""));				//SO Type                                          
		event.setHidProvider(JSPUtil.getParameter(request,"hid_provider",""));			//Sevice provider                                        
		event.setHidProviderType(JSPUtil.getParameter(request,"hid_provider_type",""));	//provider type                                 
		event.setHidAmount(JSPUtil.getParameter(request,"hid_amount",""));				//amount combo                                    
		event.setHidRadioNumber(JSPUtil.getParameter(request,"hid_radio_number",""));	//S/C No.  RFA No. RADIO                        
		event.setScRfaCd(JSPUtil.getParameter(request,"sc_rfa_cd",""));					//S/C No.  RFA No. INPUT BOX                        
		event.setHidFromNode(JSPUtil.getParameter(request,"hid_from_node",""));			//from_node                                       
		event.setHidViaNode(JSPUtil.getParameter(request,"hid_via_node",""));			//via_node                                        
		event.setHidToNode(JSPUtil.getParameter(request,"hid_to_node",""));				//to_node                                           
		event.setHidDoorNode(JSPUtil.getParameter(request,"hid_door_node",""));			//door_node                                       
		event.setInvarTerm(JSPUtil.getParameter(request,"invar_term",""));				//door_node                                       
		event.setInvarOnlyCy(JSPUtil.getParameter(request,"invar_onlycy",""));			//door_node                                       
		event.setInvarTroSts(JSPUtil.getParameter(request,"invar_trosts",""));			//door_node                                       
		event.setHidUsRail(JSPUtil.getParameter(request,"hid_usrail",""));				//door_node                                       
		event.setHidUsDropNPull(JSPUtil.getParameter(request,"hid_usdropnpull",""));	//dmdt[CHM-201007768-01]
		event.setHidPrePull(JSPUtil.getParameter(request,"hid_prepull",""));	        //20121031[CHM-201221040]   	
		event.setCntFlg(JSPUtil.getParameter(request,"hid_cnt_flg",""));	        	//20121031[CHM-201221040]
		
		event.setSpotBidFlg(JSPUtil.getParameter(request,"spot_bid_flg",""));	        //20150820[CHM-201536162] Spot bid 시스템 개발 by SHIN DONG IL
		event.setSpotBidNo(JSPUtil.getParameter(request,"spot_bid_no",""));	        	//20150820[CHM-201536162] Spot bid 시스템 개발 by SHIN DONG IL
	
		event.setOfficeCd(JSPUtil.getParameter(request,"office_cd", ""));
		
		event.setRadioProfit(JSPUtil.getParameter(request,"radio_profit",""));			// Radio Profit
		event.setSelProfit(JSPUtil.getParameter(request,"sel_profit",""));				// Select Profit
		
		event.setSelSpotBidSts(JSPUtil.getParameter(request,"sel_spotbidsts",""));		// Select Spot Bid Status
		  
		request.setAttribute("Event", event);
		
		return  event;
	}

	/**
	 * HttpRequest의 attribute에 업무시나리오 수행결과 값 저장<br>
	 * ServiceCommand에서 View(JSP)로 실행결과를 전송하는 ResultSet을 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @param eventResponse EventResponse interface를 구현한 객체
	 */
	public void doEnd(HttpServletRequest request, EventResponse eventResponse) {
		request.setAttribute("EventResponse", eventResponse);
	}

	/**
	 * HttpRequest의 attribute에 HttpRequest 파싱 수행결과 값 저장<br>
	 * HttpRequest 파싱 수행결과 값 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @param event Event interface를 구현한 객체
	 */
	public void doEnd(HttpServletRequest request, Event event) {
		request.setAttribute("Event", event);
	}

}