/*=========================================================
 *Copyright(c) 2009 CyberLogitec 
 *@FileName : RestuffingMgtSC.java
 *@FileTitle : Restuffing Inquiry
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.27
 *@LastModifier : 우경민
 *@LastVersion : 1.0
 * 2009.04.27 우경민
 * 1.0 Creation
 * --------------------------------------------------------
 * History
 * 2010.12.28 김상수 [CHM-201007850-01] [CTM] 업무 고도화 관련 소스 보완
 *                    Log 확인용 표준 출력 로그 제거
 *                    관련 대상 : 16개 file
 *                    변경 사항 : System.out.println => log.info 또는 제거
=========================================================*/
package com.hanjin.apps.alps.ees.ctm.restuffingmgt;

import java.util.List;

import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.basic.ContainerMovementMgtBC;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.basic.ContainerMovementMgtBCImpl;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.CrossItemVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.CusCtmMovementVO;
import com.hanjin.apps.alps.ees.ctm.restuffingmgt.restuffingcontainerregistration.basic.RestuffingContainerRegistrationBC;
import com.hanjin.apps.alps.ees.ctm.restuffingmgt.restuffingcontainerregistration.basic.RestuffingContainerRegistrationBCImpl;
import com.hanjin.apps.alps.ees.ctm.restuffingmgt.restuffingcontainerregistration.event.EesCtm0422Event;
import com.hanjin.apps.alps.ees.ctm.restuffingmgt.restuffingcontainerregistration.event.EesCtm0423Event;
import com.hanjin.apps.alps.ees.ctm.restuffingmgt.restuffingcontainerregistration.event.EesCtm0445Event;
import com.hanjin.apps.alps.ees.ctm.restuffingmgt.restuffingcontainerregistration.integration.RestuffingContainerRegistrationDBDAO;
import com.hanjin.apps.alps.ees.ctm.restuffingmgt.restuffingcontainerregistration.vo.CTMRestuffingVO;
import com.hanjin.apps.alps.ees.ctm.restuffingmgt.restuffingcontainerregistration.vo.CtmMovementHistoryVO;
import com.hanjin.apps.alps.ees.ctm.restuffingmgt.restuffingcontainerregistration.vo.RetuffingListVO;
import com.hanjin.apps.alps.ees.ctm.restuffingmgt.restuffingcontainerregistration.vo.UpdMstCntrVO;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;


/**
 * ALPS-RestuffingMgt Business Logic ServiceCommand - ALPS-RestuffingMgt 대한 비지니스 트랜잭션을 처리한다.
 *
 * @author KyungMin Woo
 * @see RestuffingContainerRegistrationDBDAO
 * @since J2EE 1.4
 */

public class RestuffingMgtSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * RestuffingMgt system 업무 시나리오 선행작업<br>
	 * EES_CTM_0423업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error("err " + e.toString(), e);
		}
	}

	/**
	 * RestuffingMgt system 업무 시나리오 마감작업<br>
	 * EES_CTM_0423 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("RestuffingMgtSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * ALPS-RestuffingMgt system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getEventName().equalsIgnoreCase("EesCtm0423Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchRestuffingList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesCtm0445Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchOBJMVMTList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesCtm0422Event")) {
			if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = createRestuffingContainer(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					eventResponse = searchOBJMVMT(e);
			}
		}
		return eventResponse;
	}

	/**
	 * EES_CTM_0423 : SEARCH<br>
	 * Restuffing 처리된 컨테이너 목록 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRestuffingList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EesCtm0423Event event = (EesCtm0423Event)e;
		RestuffingContainerRegistrationBC command = new RestuffingContainerRegistrationBCImpl();
		List<RetuffingListVO> list = command.searchRestuffingList(event.getiRetuffingListVO());
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList(list);
		return eventResponse;
	}

	/**
	 * EES_CTM_0422 : SEARCH<br>
	 * CTM_MOVEMENT HISTORY 를 조회합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOBJMVMT(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCtm0422Event event = (EesCtm0422Event)e;
		RestuffingContainerRegistrationBC command = new RestuffingContainerRegistrationBCImpl();
		String cntrNo = null;
		CtmMovementHistoryVO vo = event.getCtmMovementHistoryVO();
		try{
			List<CTMRestuffingVO> list = command.searchOBJMVMT(vo, "1");
			eventResponse.setRsVoList(list);
			cntrNo = vo.getCntrNo() + vo.getCheckDigit();
			String split = command.getBkgSplitRSQL(cntrNo);
			eventResponse.setETCData("Split", split);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_CTM_0445 : SEARCH<br>
	 * CTM_MOVEMENT HISTORY 를 조회합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOBJMVMTList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCtm0445Event event = (EesCtm0445Event)e;
		RestuffingContainerRegistrationBC command = new RestuffingContainerRegistrationBCImpl();

		try{
			List<CTMRestuffingVO> list = command.searchOBJMVMT(event.getCtmMovementHistoryVO(), "2");
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	/**
	 * EES_CTM_0422 : SAVE<br>
	 * 컨테이너 Restuffing 정보를 등록한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createRestuffingContainer(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCtm0422Event event = (EesCtm0422Event)e;
		RestuffingContainerRegistrationBC command = new RestuffingContainerRegistrationBCImpl();

		try{
			begin();
			UpdMstCntrVO uVo =
				command.createRestuffingContainer(event.getCtmRestuffingDetailVOS(), account);
			// Movement Update!
			ContainerMovementMgtBC cmdMvmt = new ContainerMovementMgtBCImpl();
			log.info("UPD SET :" + uVo.getupdCtm().getMvmtStsCd());
			cmdMvmt.updateUpdateMvmt(uVo.getupdCtm());
			cmdMvmt.updateAddMvmt(uVo.getCtmUpd());
			//command.updateMstCntr(uVo.getMstUpd());
			CrossItemVO item = new CrossItemVO();
			CusCtmMovementVO[] list = uVo.getMstUpd();
			for (int i = 0; i < list.length; i++) {
				if (list[i] == null) continue;
				if (list[i].getCntrNo() == null) continue;
				item.setCusCtmMovementVO(list[i]);
				item.setUpdateMaster(true);
				item.getCusCtmMovementVO().setCtmUiYn("Y");    // ctm_ui_yn (0430/0414화면에서의 실행인지 구분값 - MST모듈에서 사용)
				com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.basic.ContainerOnOffhireBC cmd = new
				com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.basic.ContainerOnOffhireBCImpl();
				cmd.updateCntrMasterByMvmtBasic(item);
			}
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

}