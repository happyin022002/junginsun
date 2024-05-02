/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : usermanageSC.java
*@FileTitle : SppUserManage
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.30
*@LastModifier : 안준상
*@LastVersion : 1.0
* 2009.07.30 안준상
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.exp.spp.usermanage.sppusermanage;

import java.util.List;

import com.clt.apps.opus.exp.spp.usermanage.sppusermanage.basic.SppUserManageBC;
import com.clt.apps.opus.exp.spp.usermanage.sppusermanage.basic.SppUserManageBCImpl;
import com.clt.apps.opus.exp.spp.usermanage.sppusermanage.event.SppusermanageEvent;
import com.clt.apps.opus.exp.spp.usermanage.sppusermanage.integration.SppUserManageDBDAO;
import com.clt.apps.opus.exp.spp.usermanage.sppusermanage.vo.MnrPartnerGRPVO;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.MdmVendorVO;
import com.clt.syscommon.common.table.MnrPartnerVO;
import com.clt.syscommon.common.table.MnrPrnrCntcPntVO;


/**
 * ALPS-usermanage Business Logic ServiceCommand - ALPS-usermanage 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author jsahn
 * @see SppUserManageDBDAO
 * @since J2EE 1.6
 */

public class SppUserManageSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * usermanage system 업무 시나리오 선행작업<br>
	 * 업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		log.debug("usermanageSC 시작");
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * usermanage system 업무 시나리오 마감작업<br>
	 * 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("usermanageSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * ALPS-usermanage system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getEventName().equalsIgnoreCase("SppusermanageEvent")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchSppUserBidInfo(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchMdmVendorInfo(e);	
			}else if(e.getFormCommand().isCommand(FormCommand.ADD)) {
				eventResponse = insertSppUserBidInfo(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MODIFY)) {
				eventResponse = modifySppUserBidInfo(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MODIFY01)) {
				eventResponse = modifySppUserPsoInfo(e);
			}	
		}
		return eventResponse;
	}
	/**
	 * SppUserManage : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSppUserBidInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		SppusermanageEvent event = (SppusermanageEvent)e;
		SppUserManageBC command = new SppUserManageBCImpl();
		
		List<MnrPartnerVO> 		list  = command.searchSppUserBidInfoBasic(event.getSpPtalId());
		List<MnrPrnrCntcPntVO>  list2 = command.searchSppUserBidInfosBasic(event.getSpPtalId());
		
		if(list !=null && list.size() > 0){
			eventResponse.setCustomData("vo1", (MnrPartnerVO)list.get(0));
			
			if(list2 !=null && list2.size() > 0)
				eventResponse.setCustomData("vo2", list2);
		}	
		return eventResponse;
	}
	
	/**
	 * SPP COMMON : Open<br>
	 * Vendor에 대한 데이타 모델목록을 조회합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMdmVendorInfo(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		List<MdmVendorVO> list = null;
		SppUserManageBC command = new SppUserManageBCImpl();
		
		SppusermanageEvent event = (SppusermanageEvent)e;
		list = command.searchMdmVendorInfoBasic(event.getVndrSeq());

		if ( list.size() == 1 ) {
			eventResponse.setETCData(list.get(0).getColumnValues());
		} 

		return eventResponse;
	}
	
	/**
	 * Bidding User 신규가입 
	 * @param e
	 * @return
	 * @exception EventException
	 */
	private EventResponse insertSppUserBidInfo(Event e) throws EventException {
		
		GeneralEventResponse eventResponse 	= new GeneralEventResponse();
		SppusermanageEvent event 			= (SppusermanageEvent)e;
		SppUserManageBC command 			= new SppUserManageBCImpl();
		MnrPartnerGRPVO mnrPartnerGRPVO 	= event.getMnrPartnerGRPVO();
		 
		try{
			begin();
			command.insertSppUserBidInfoBasic(mnrPartnerGRPVO, account);
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}
		return eventResponse;  
	}
	
	/**
	 * Bidding User 수정
	 * @param e
	 * @return
	 * @exception EventException
	 */
	private EventResponse modifySppUserBidInfo(Event e) throws EventException {
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		SppusermanageEvent event = (SppusermanageEvent)e;
		SppUserManageBC command = new SppUserManageBCImpl();
		
		MnrPartnerGRPVO mnrPartnerGRPVO 	= event.getMnrPartnerGRPVO();
		 
		try{
			begin();
			command.modifySppUserBidInfoBasic(mnrPartnerGRPVO, account);
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}
		return eventResponse;  
	}
	
	/**
	 * Pso BankInfo 수정 
	 * @param e
	 * @return
	 * @exception EventException
	 */
	private EventResponse modifySppUserPsoInfo(Event e) throws EventException {
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		SppusermanageEvent event = (SppusermanageEvent)e;
		SppUserManageBC command = new SppUserManageBCImpl();
		
		MdmVendorVO mdmVendorVO = event.getMdmVendorVO();
		 
		try{
			begin();
			command.modifySppUserPsoInfoBasic(mdmVendorVO, account);
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}
		return eventResponse;  
	}
	
	
	
}