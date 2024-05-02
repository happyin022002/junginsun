/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : RestuffingMgtSC.java
 *@FileTitle : Restuffing Inquiry
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion :
=========================================================*/
package com.clt.apps.opus.ees.ctm.restuffingmgt;

import java.util.List;

import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.basic.ContainerMovementMgtBC;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.basic.ContainerMovementMgtBCImpl;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.CrossItemVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.CusCtmMovementVO;
import com.clt.apps.opus.ees.ctm.restuffingmgt.restuffingcontainerregistration.basic.RestuffingContainerRegistrationBC;
import com.clt.apps.opus.ees.ctm.restuffingmgt.restuffingcontainerregistration.basic.RestuffingContainerRegistrationBCImpl;
import com.clt.apps.opus.ees.ctm.restuffingmgt.restuffingcontainerregistration.event.EesCtm0422Event;
import com.clt.apps.opus.ees.ctm.restuffingmgt.restuffingcontainerregistration.event.EesCtm0423Event;
import com.clt.apps.opus.ees.ctm.restuffingmgt.restuffingcontainerregistration.event.EesCtm0445Event;
import com.clt.apps.opus.ees.ctm.restuffingmgt.restuffingcontainerregistration.integration.RestuffingContainerRegistrationDBDAO;
import com.clt.apps.opus.ees.ctm.restuffingmgt.restuffingcontainerregistration.vo.CTMRestuffingVO;
import com.clt.apps.opus.ees.ctm.restuffingmgt.restuffingcontainerregistration.vo.CtmMovementHistoryVO;
import com.clt.apps.opus.ees.ctm.restuffingmgt.restuffingcontainerregistration.vo.RetuffingListVO;
import com.clt.apps.opus.ees.ctm.restuffingmgt.restuffingcontainerregistration.vo.UpdMstCntrVO;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;


/**
 * OPUS-RestuffingMgt Business Logic ServiceCommand - handling business transaction forOPUS-RestuffingMgt 
 *
 * @author 
 * @see RestuffingContainerRegistrationDBDAO
 * @since J2EE 1.4
 */

public class RestuffingMgtSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * creating Object when calling business scenario for EES_CTM_0423
	 */
	public void doStart() {
		try {
			// checking login
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error("err " + e.toString(), e);
		}
	}

	/**
	 * closing RestuffingMgt system business scenario

	 */
	public void doEnd() {
		log.debug("RestuffingMgtSC end");
	}

	/**
	 * handling cases for OPUS-RestuffingMgt system event<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

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
	 * EES_CTM_0423 : SEARCH
	 * retrieving Restuffing container list
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
	 * retrieving CTM_MOVEMENT HISTORY 
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
			cntrNo = vo.getCntrNo();
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
	 * retrieving CTM_MOVEMENT HISTORY 
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
	 * registering container Restuffing information
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
				com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.basic.ContainerOnOffhireBC cmd = new
				com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.basic.ContainerOnOffhireBCImpl();
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