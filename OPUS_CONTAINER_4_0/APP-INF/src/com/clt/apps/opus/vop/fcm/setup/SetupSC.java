/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : SetupSC.java
*@FileTitle : Setup
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.19
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2011.11.04 유혁
* 1.0 Creation
* 
* History
* 2012.04.19 진마리아 CHM-201217192-01 Vessel Registration내 선박 추가 로직 변경 요청건
* 2014.06.24 R4J패치 사전 검토
=========================================================*/

package com.clt.apps.opus.vop.fcm.setup;

import java.util.List;

import com.clt.apps.opus.vop.fcm.fcmcommon.fcmcommon.basic.FCMCommonBC;
import com.clt.apps.opus.vop.fcm.fcmcommon.fcmcommon.basic.FCMCommonBCImpl;
import com.clt.apps.opus.vop.fcm.setup.setup.basic.SetupBC;
import com.clt.apps.opus.vop.fcm.setup.setup.basic.SetupBCImpl;
import com.clt.apps.opus.vop.fcm.setup.setup.event.VopFcm0081Event;
import com.clt.apps.opus.vop.fcm.setup.setup.vo.FcmVslCntrRgstVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS FCM Setup ServiceCommand - FCM Setup 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author Hyuk Ryu
 * @see 
 * @since J2EE 1.6
 */

public class SetupSC extends ServiceCommandSupport {

	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * SetupSC system 업무 시나리오 선행작업<br>
	 */
	public void doStart() {
		log.debug("SetupSC 시작");
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * SetupSC system 업무 시나리오 마감작업<br>
	 */
	public void doEnd() {
		log.debug("SetupSC 종료");
	}
	
	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * ALPS VesselReport system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	
	@Override
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;
		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getEventName().equalsIgnoreCase("VopFcm0081Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchFcmVslCntrRgstList(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchMdmVslCntrRgstList(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = multiFcmVslCntrRgst(e);
			}else if(e.getFormCommand().isCommand(FormCommand.REMOVE)) {
				eventResponse = removeFcmVslCntrRgst(e);
			}
		}
		return eventResponse;
	}
	
	/**
	 * VOP_FCM_0081 : Retrieve<br>
	 * Vessel Registration 정보를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchFcmVslCntrRgstList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopFcm0081Event event = (VopFcm0081Event)e;
		SetupBC command = new SetupBCImpl();
		
		try {
		
			List<FcmVslCntrRgstVO> fcmVslCntrRgstList = command.searchFcmVslCntrRgst(event.getFcmVslCntrRgstVO());					
			eventResponse.setRsVoList(fcmVslCntrRgstList);
			
		} catch(EventException eex){
			log.error("err " + eex.toString(), eex);
           throw new EventException(new ErrorHandler("COM12203", new String[] { "Vessel Registration" }).getMessage(), eex);			
       } catch (Exception ex) {
       	log.error("err " + ex.toString(), ex);
       	throw new EventException(ex.getMessage(), ex);
		}
       
		return eventResponse;
	}
	
	/**
	 * VOP_FCM_0081 : row add후 vsl code입력시<br>
	 * 해당 Vessel의 MDM 정보를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMdmVslCntrRgstList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopFcm0081Event event = (VopFcm0081Event)e;
		SetupBC command = new SetupBCImpl();
		String mdmExist = null;
		try {
			String vslCd = event.getVslCd();
			String isExist = command.searchVslCntrRgstExist(vslCd);
			FcmVslCntrRgstVO fcmVslCntrRgstVO = new FcmVslCntrRgstVO();
			if("N".equals(isExist)){
				fcmVslCntrRgstVO = command.searchMdmVslCntrRgstList(vslCd);
				if(fcmVslCntrRgstVO==null){
					mdmExist = "N";
				}else{
					if(!"HJS".equals(fcmVslCntrRgstVO.getCrrCd())){
						mdmExist = "C";
					}else{
						mdmExist = "Y";
					}
					StringBuilder data = new StringBuilder();
					data.append(fcmVslCntrRgstVO.getVslEngNm());
					data.append("");
					data.append(fcmVslCntrRgstVO.getDwtWgt());
					data.append("");
					data.append(fcmVslCntrRgstVO.getGrsRgstTongWgt());
					data.append("");
					data.append(fcmVslCntrRgstVO.getNetRgstTongWgt());
					data.append("");
					data.append(fcmVslCntrRgstVO.getLloydNo());
					data.append("");
					data.append(fcmVslCntrRgstVO.getCntrVslClssCapa());
					
					fcmVslCntrRgstVO = command.searchFmsVslCntr(vslCd);
					if(fcmVslCntrRgstVO!=null){
						data.append("");
						data.append(fcmVslCntrRgstVO.getOwnrNm());
						data.append("");
						data.append(fcmVslCntrRgstVO.getVslBldDt());
						data.append("");
						data.append(fcmVslCntrRgstVO.getVslDzndCapa());
						data.append("");
						data.append(fcmVslCntrRgstVO.getBse14tonVslCapa());
						data.append("");
						data.append(fcmVslCntrRgstVO.getFmDt());
						data.append("");
						data.append(fcmVslCntrRgstVO.getToDt());
					}
					
					eventResponse.setETCData("data", data.toString());
				}
			}
			eventResponse.setETCData("fcm_exist", isExist);
			eventResponse.setETCData("mdm_exist", mdmExist);
			
		} catch(EventException eex){
			log.error("err " + eex.toString(), eex);
			throw new EventException(new ErrorHandler("COM12203", new String[] { "Vessel Registration" }).getMessage(), eex);			
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		
		return eventResponse;
	}

	/**
	 * VOP_FCM_0081 : Save<br>
	 * Vessel Registration 정보를 변경한다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse multiFcmVslCntrRgst(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		VopFcm0081Event event = (VopFcm0081Event)e;
		//사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FcmVslCntrRgstVO[]  fcmVslCntrRgstVOs = event.getFcmVslCntrRgstVOs();

		try {
			SetupBC command = new SetupBCImpl();
	
		    begin();
			command.multiFcmVslCntrRgst(fcmVslCntrRgstVOs,account);
			commit();
			
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return eventResponse;
	}
	
	/**
	 * VOP_FCM_0081 : Delete<br>
	 * Vessel Registration 정보를 삭제한다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse removeFcmVslCntrRgst(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		VopFcm0081Event event = (VopFcm0081Event)e;
		//사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FcmVslCntrRgstVO[]  fcmVslCntrRgstVOs = event.getFcmVslCntrRgstVOs();

		try {
			SetupBC command = new SetupBCImpl();
	
		    begin();
			command.removeFcmVslCntrRgst(fcmVslCntrRgstVOs);
			commit();
			
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return eventResponse;
	}
	
	/**
	 * VOP_FCM_0082 : Window Open<br>
	 * MDM Vessel Class Capacity List를 조회한다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchVslClassCapaList(Event e) throws EventException {
		//사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			FCMCommonBC command = new FCMCommonBCImpl();
	
			String list = command.searchVslClassCapaList();
			eventResponse.setETCData("cntr_vsl_clss_capa", list);
			
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return eventResponse;
	}

}