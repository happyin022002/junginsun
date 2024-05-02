/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : SalesAdminCommonSC.java
*@FileTitle : Sales Activity Item
*Open Issues :
*Change history :
*@LastModifyDate : 2011.05.11
*@LastModifier : 김보배
*@LastVersion : 1.0
* 2011.05.11 김보배
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.sam.salesadmincommon;

import java.util.List;

import com.clt.apps.opus.esm.sam.salesadmincommon.salesadmincommon.basic.SalesAdminCommonBC;
import com.clt.apps.opus.esm.sam.salesadmincommon.salesadmincommon.basic.SalesAdminCommonBCImpl;
import com.clt.apps.opus.esm.sam.salesadmincommon.salesadmincommon.event.EsmSam0100Event;
import com.clt.apps.opus.esm.sam.salesadmincommon.salesadmincommon.event.EsmSamComEvent;
import com.clt.apps.opus.esm.sam.salesadmincommon.salesadmincommon.integration.SalesAdminCommonDBDAO;
import com.clt.apps.opus.esm.sam.salesadmincommon.salesadmincommon.vo.SearchActItemMstVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-SalesAdminCommon Business Logic ServiceCommand - ALPS-SalesAdminCommon 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author NAMKOONGJINHO
 * @see SalesAdminCommonDBDAO
 * @since J2EE 1.6
 */

public class SalesAdminCommonSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * SalesAdminCommon system 업무 시나리오 선행작업<br>
	 * 업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		log.debug("SalesAdminCommonSC 시작");
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * SalesAdminCommon system 업무 시나리오 마감작업<br>
	 * 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("SalesAdminCommonSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * ALPS-SalesAdminCommon system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;
		
		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getEventName().equalsIgnoreCase("EsmSam0100Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchActItemMstList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchActItemDtlList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageActTpList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmSamComEvent")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchComboList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = checkUserAuth(e);
			}
		} 
		
		return eventResponse;
	}
	
	/**
	 * 공통 : open<br>
	 * 콤보 리스트를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComboList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSamComEvent event = (EsmSamComEvent)e;
		SalesAdminCommonBC command = new SalesAdminCommonBCImpl();
		String[][] array = null;
		
		String scrNo = event.getScrNo();
		
		//if (scrNo.equals("0100")) {
			
		//}else if (scrNo.equals("0001")) {
			
		//}else if (scrNo.equals("0002")) {
		if (scrNo.equals("0002")) {
			array = new String[6][3];
			array[0][0] = "CD00629";
			array[0][2] = "Blank";
			array[1][0] = "CD00779";
			array[1][2] = "Blank";
			array[2][0] = "MajorTrade";
			array[2][2] = "Blank";
			array[3][0] = "CD00699";
			array[3][2] = "Blank";		
			array[4][0] = "CD00693";
			array[4][2] = "Blank";
			array[5][0] = "CD00711";
			array[5][2] = "Blank";
			
		//}else if (scrNo.equals("0004")) {
			
		}else if (scrNo.equals("0003")) {
			array = new String[4][3];
			array[0][0] = "CD00711";
			array[1][0] = "CD20077";
			array[1][2] = "Blank";
			array[2][0] = "CD20078";
			array[2][2] = "Blank";
			array[3][0] = "CD20079";
			array[3][2] = "Blank";
			
		}else if (scrNo.equals("0005")) {
			array = new String[1][3];
			array[0][0] = "CD01109";
			array[0][2] = "Blank";

		}else if (scrNo.equals("0006")) {
			array = new String[1][3];
			array[0][0] = "CD00693";
		//}else if (scrNo.equals("0009")) {

		}else if (scrNo.equals("0007")) {
			array = new String[5][3];
			array[0][0] = "CD20080"; 
			array[1][0] = "CD20081";
			array[2][0] = "SamActType";
			array[3][0] = "SamActSubType";
			array[4][0] = "CD20083";
			
		}else if (scrNo.equals("0008")) {
			array = new String[1][3];
			array[0][0] = "CD20082";
			
		//}else if (scrNo.equals("0009")) {
			
		}else if (scrNo.equals("0901")) {
			array = new String[2][3];
			array[0][0] = "CD20080"; 
			array[1][0] = "CD20081";	
		}
        
		if (array != null) {
	 		try{
				eventResponse = command.searchCommonCodeList(eventResponse, array);
			}catch(EventException ex){
				throw new EventException(new ErrorHandler(ex).getMessage(),ex);
			}catch(Exception ex){
				throw new EventException(new ErrorHandler(ex).getMessage(),ex);
			}	
		}
		return eventResponse;
	}

	/**
	 * 공통 : open<br>
	 * Login user의 권한을 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkUserAuth(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		//EsmSamComEvent event = (EsmSamComEvent)e;
		SalesAdminCommonBC command = new SalesAdminCommonBCImpl();

		try{
			String result = command.getUserAuth(account);
			eventResponse.setETCData("result", result);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}		
	
	
	/**
	 * ESM_SAM_0100 : [이벤트]<br>
	 * [Sheet1]을 [조회]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchActItemMstList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSam0100Event event = (EsmSam0100Event)e;
		SalesAdminCommonBC command = new SalesAdminCommonBCImpl();

		try{
			List<SearchActItemMstVO> list = command.searchActItemMstList(event.getSearchActItemMstVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * ESM_SAM_0100 : [이벤트]<br>
	 * [Sheet2]을 [조회]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchActItemDtlList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSam0100Event event = (EsmSam0100Event)e;
		SalesAdminCommonBC command = new SalesAdminCommonBCImpl();

		try{
			List<SearchActItemMstVO> list = command.searchActItemDtlList(event.getSearchActItemMstVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
		/**
	 * ESM_SAM_0100 : [이벤트]<br>
	 * [Sheet1], [Sheet2]를 [저장]합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageActTpList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
				GeneralEventResponse eventResponse = new GeneralEventResponse();
				EsmSam0100Event event = (EsmSam0100Event)e;
				SalesAdminCommonBC command = new SalesAdminCommonBCImpl();
				try{
					
					int iRtnCnt = 0; 
					begin();
					
					if(event.getSamActTpMstVOS()!=null && event.getSamActTpMstVOS().length>0){
						for(int i=0; i<event.getSamActTpMstVOS().length; i++){
					    	event.getSamActTpMstVOS()[i].setCreUsrId(event.getSignOnUserAccount().getUsr_id());
						}
						command.manageActItemMstList(event.getSamActTpMstVOS(), account);
					}
						
					if(event.getSamSlsActTpDtlVOS()!=null && event.getSamSlsActTpDtlVOS().length>0){
						for(int i=0; i<event.getSamSlsActTpDtlVOS().length; i++){
					    	event.getSamSlsActTpDtlVOS()[i].setCreUsrId(event.getSignOnUserAccount().getUsr_id());
						}
						command.manageActDtlList(event.getSamSlsActTpDtlVOS(), account);
					}
					
					commit();
					
					eventResponse.setETCData("creCnt", iRtnCnt+"");
					
				} catch(EventException ex) {
					rollback();
					throw new EventException(new ErrorHandler(ex).getMessage(),ex);
				} catch(Exception ex) {
					rollback();
					throw new EventException(new ErrorHandler(ex).getMessage(),ex);
				}
				
				return eventResponse;
	}
	

}