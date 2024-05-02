/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : LogisticsRevenueSC.java
*@FileTitle : LogisticsRevenue
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.11
*@LastModifier : KIM HYUN HWA
*@LastVersion : 1.0
* 2014.12.11 KIM HYUN JU
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.logisticsrevenue;

import java.util.List;

import com.hanjin.apps.alps.esd.tpb.logisticsrevenue.logisticsrevenue.basic.LogisticsRevenueBC;
import com.hanjin.apps.alps.esd.tpb.logisticsrevenue.logisticsrevenue.basic.LogisticsRevenueBCImpl;
import com.hanjin.apps.alps.esd.tpb.logisticsrevenue.logisticsrevenue.event.EsdTpb0139Event;
import com.hanjin.apps.alps.esd.tpb.logisticsrevenue.logisticsrevenue.event.EsdTpb0140Event;
import com.hanjin.apps.alps.esd.tpb.logisticsrevenue.logisticsrevenue.integration.LogisticsRevenueDBDAO;
import com.hanjin.apps.alps.esd.tpb.logisticsrevenue.logisticsrevenue.vo.TaxInfoVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;


/**
 * ALPS-CandidateManage Business Logic ServiceCommand - ALPS-CandidateManage 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author Sun, CHOI
 * @see LogisticsRevenueDBDAO
 * @since J2EE 1.6
 */

public class LogisticsRevenueSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * CandidateManage system 업무 시나리오 선행작업<br>
	 * 업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		log.debug("LogisticsRevenueSC 시작");
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * CandidateManage system 업무 시나리오 마감작업<br>
	 * 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("LogisticsRevenueSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * ALPS-CandidateManage system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;
		
		
		if (e.getEventName().equalsIgnoreCase("EsdTpb0139Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = checkTrdPartyVal(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
					eventResponse = checkInvVatXchRate(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = createSingleInvoice(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH11)) { //Cost Office
				eventResponse = searchTPBCostOfcList(e);
			} 
		} else if (e.getEventName().equalsIgnoreCase("EsdTpb0140Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = checkTrdPartyVal(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = createMultiInvoice(e);				
			}
		}

		return eventResponse;
	}
	
	/**
	 * ESD_TPB_0139 <br>
	 * 
	 * @param Event e
	 * @return EventResponse
//	 * @exception EventException
	 */
	private EventResponse checkInvVatXchRate(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
//		EsdTpb0139Event event = (EsdTpb0139Event)e;
		LogisticsRevenueBC command = new LogisticsRevenueBCImpl();
		try{
			String ofcCd = (String)e.getAttribute("ofcCd");
			String vat_xch_rt = command.checkInvVatXchRate(ofcCd);
			eventResponse.setETCData("vat_xch_rt", vat_xch_rt);

			List<TaxInfoVO> taxInfo = command.searchTaxInfo(ofcCd);
			// India 인 경우에만 대상 데이터 조회되도록 함. 향후 다른지역 적용시 Office별 Cnt_cd로 로직 추가필요함.			
			if (taxInfo.size() > 0) {
				eventResponse.setETCData("ida_tax_seq",taxInfo.get(0).getIdaTaxSeq());
				eventResponse.setETCData("expn_tax",taxInfo.get(0).getExpnTax());
				eventResponse.setETCData("edu_tax",taxInfo.get(0).getEduTax());
				eventResponse.setETCData("high_edu_tax",taxInfo.get(0).getHighEduTax());
				eventResponse.setETCData("locl_tax_rt",taxInfo.get(0).getLoclTaxRt());
				eventResponse.setETCData("n2nd_locl_tax_rt",taxInfo.get(0).getN2ndLoclTaxRt());

			}else{
				eventResponse.setETCData("ida_tax_seq","X");
				eventResponse.setETCData("expn_tax","0");
				eventResponse.setETCData("edu_tax","0");
				eventResponse.setETCData("high_edu_tax","0");
				eventResponse.setETCData("locl_tax_rt","0");
				eventResponse.setETCData("n2nd_locl_tax_rt","0");
			}

		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;		
	}

	/**
	 * ESD_TPB_0140 <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkTrdPartyVal(Event e) throws EventException {
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
//		if (e.getEventName().equalsIgnoreCase("EsdTpb0139Event")){
//			EsdTpb0139Event event = (EsdTpb0139Event)e;
//		}
//		if (e.getEventName().equalsIgnoreCase("EsdTpb0140Event")) {
//			EsdTpb0140Event event = (EsdTpb0140Event)e;
//		}
		LogisticsRevenueBC command = new LogisticsRevenueBCImpl();
		try{
			String trdPartyVal = (String)e.getAttribute("trdPartyVal");
			String s_trd_party_val = command.checkTrdPartyVal(trdPartyVal);
			eventResponse.setETCData("s_trd_party_val", s_trd_party_val);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;		
	}
	
	/**
	 *  ESD_TPB_0139 
	 * [비즈니스대상]을 [행위]합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createSingleInvoice(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTpb0139Event event = (EsdTpb0139Event)e;
		LogisticsRevenueBC command = new LogisticsRevenueBCImpl();
		try{
			String sResult[] =  command.createSingleInvoice(event.getLogisticsRevenueInvoiceVO());
			eventResponse.setETCData("s_n3pty_no", sResult[0]);
			eventResponse.setETCData("s_n3pty_inv_no", sResult[1]);
			eventResponse.setETCData("s_rtn_cd", sResult[2]);
			
			if( "10".equals(sResult[2]) ){
				throw new EventException(new ErrorHandler("TPB00079").getMessage());
			}
			
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}	

	
	/**
	 *  ESD_TPB_0140 
	 * [비즈니스대상]을 [행위]합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createMultiInvoice(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTpb0140Event event = (EsdTpb0140Event)e;
		LogisticsRevenueBC command = new LogisticsRevenueBCImpl();
		try{
			String sResult[] =  command.createMultiInvoice(event.getLogisticsRevenueInvoiceVO());
			eventResponse.setETCData("s_n3pty_no", sResult[0]);
			eventResponse.setETCData("s_n3pty_inv_no", sResult[1]);
			eventResponse.setETCData("s_rtn_cd", sResult[2]);
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * CodeManage의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTPBCostOfcList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {
			LogisticsRevenueBC command = new LogisticsRevenueBCImpl();
			List<String> list = command.searchTPBCostOfcList(account.getOfc_cd());
			String ofcInfo = "";
			StringBuffer ofcInfoBuff = new StringBuffer();
			
			if (list.size() > 0) {
				for (int i = 0; i < list.size(); i++) {
					ofcInfoBuff.append("|" + list.get(i));
				}
				ofcInfo = ofcInfoBuff.toString();
				eventResponse.setETCData("cost_ofc_cd", ofcInfo);
			} 
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

}