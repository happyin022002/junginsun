/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : JobCodeManagementSC.java
*@FileTitle : JobCodeManagementSC
*Open Issues :
*Change history :
*@LastModifyDate : 2013.04.17
*@LastModifier : 최덕우
*@LastVersion : 1.0
* 2013.04.17 최덕우
* 1.0 Creation
=========================================================*/
package com.hanjin.syscommon.management.alps;

import java.util.List;

import org.apache.log4j.Logger;

import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.management.alps.jobcodemanagement.basic.JobCodeManagementBC;
import com.hanjin.syscommon.management.alps.jobcodemanagement.basic.JobCodeManagementBCImpl;
import com.hanjin.syscommon.management.alps.jobcodemanagement.event.AdmSys0011Event;
import com.hanjin.syscommon.management.alps.jobcodemanagement.event.AdmSys0012Event;
import com.hanjin.syscommon.management.alps.jobcodemanagement.event.AdmSys0013Event;
import com.hanjin.syscommon.management.alps.jobcodemanagement.event.AdmSys0014Event;
import com.hanjin.syscommon.management.alps.jobcodemanagement.event.AdmSys0015Event;
import com.hanjin.syscommon.management.alps.jobcodemanagement.event.AdmSys0016Event;
import com.hanjin.syscommon.management.alps.jobcodemanagement.event.AdmSys0017Event;
import com.hanjin.syscommon.management.alps.jobcodemanagement.event.AdmSys0018Event;
import com.hanjin.syscommon.management.alps.jobcodemanagement.event.AdmSys0019Event;
import com.hanjin.syscommon.management.alps.jobcodemanagement.event.AdmSys0020Event;
import com.hanjin.syscommon.management.alps.jobcodemanagement.event.AdmSys0021Event;
import com.hanjin.syscommon.management.alps.jobcodemanagement.event.AdmSys0022Event;
import com.hanjin.syscommon.management.alps.jobcodemanagement.event.AdmSys0023Event;
import com.hanjin.syscommon.management.alps.jobcodemanagement.event.AdmSys0024Event;
import com.hanjin.syscommon.management.alps.jobcodemanagement.event.AdmSys0025Event;
import com.hanjin.syscommon.management.alps.jobcodemanagement.vo.AdjustmentVO;
import com.hanjin.syscommon.management.alps.jobcodemanagement.vo.ApproverVO;
import com.hanjin.syscommon.management.alps.jobcodemanagement.vo.JobCodeInquiryVO;
import com.hanjin.syscommon.management.alps.jobcodemanagement.vo.JobCodeManagementVO;
import com.hanjin.syscommon.management.alps.jobcodemanagement.vo.MenuListVO;
import com.hanjin.syscommon.management.alps.jobcodemanagement.vo.OfficeMappingVO;
import com.hanjin.syscommon.management.alps.jobcodemanagement.vo.RequestVO;
import com.hanjin.syscommon.management.alps.jobcodemanagement.vo.UserInquiryVO;


/**
 * ALPS-JobCodeManagement Business Logic ServiceCommand<br>
 * - ALPS-JobCodeManagement에 대한 비지니스 트랜잭션을 처리한다.
 *
 * @author DukWoo Choi
 * @see EventResponse, JobCodeManagementDBDAO
 * @since J2EE 1.6
 */

public class JobCodeManagementSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;
	private Logger log = Logger.getLogger("com.hanjin.syscommon.management.alps");

	/**
	 * JobCodeManagement system 업무 시나리오 선행작업<br>
	 * JobCodeManagement업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		try {
			// 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error("JobCodeManagementSC doStart error!");
		}
	}

	/**
	 * JobCodeManagement system 업무 시나리오 마감작업<br>
	 * JobCodeManagement 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("JobCodeManagementSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * ALPS-UserManagement system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		EventResponse eventResponse = null;

		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getEventName().equalsIgnoreCase("AdmSys0011Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchJobCodeManagement(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = getJobCodeCount(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageJobCodeManagement(e);
			}
		} else if(e.getEventName().equalsIgnoreCase("AdmSys0012Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchOfficeMapping(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageOfficeMapping(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("AdmSys0013Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchMenuList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchProgramList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageProgramList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("AdmSys0014Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchOfficeList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchUsrList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageUsrList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("AdmSys0015Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchAdjustmentRequest(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageAdjustmentRequest(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("AdmSys0016Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchJobCodeRequest(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageJobCodeRequest(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("AdmSys0017Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = getApproverOfcInfo(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("AdmSys0018Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchAdjustmentApproval(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("AdmSys0019Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchRequestDetail(e);    // AdmSys0022Event와 공통사용
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageApproval(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("AdmSys0022Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchRequestDetail(e);    // AdmSys0019Event와 공통사용
			}
		} else if (e.getEventName().equalsIgnoreCase("AdmSys0020Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchUserJobCodeInquiry(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = getApproUsrIdChk();
			}
		} else if (e.getEventName().equalsIgnoreCase("AdmSys0021Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchJobCodeManagementMonitoring(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("AdmSys0023Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchProgramCodeMappingList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("AdmSys0024Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchApproverManagement(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageApproverManagement(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("AdmSys0025Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = getApproverUsrId(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageApproverUsrId(e);
			}
		} 
		return eventResponse;
	}

	/**
	 * [ADM_SYS_0011] Retrieve<br>
	 * JOB CODE 요청 LIST 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchJobCodeManagement(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		AdmSys0011Event event = (AdmSys0011Event)e;
		JobCodeManagementBC command = new JobCodeManagementBCImpl();
		try {
			List<JobCodeManagementVO> list = command.searchJobCodeManagement(event.getJobCodeManagementVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [ADM_SYS_0011] Validation<br>
	 * JOB Code Count를 가져옴<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse getJobCodeCount(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		AdmSys0011Event event = (AdmSys0011Event)e;
		JobCodeManagementBC command = new JobCodeManagementBCImpl();

		try {
			eventResponse.setETCData("job_code_knt", command.getJobCodeCount(event.getJobCodeManagementVO().getUsrRoleCd()));
		} catch (EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [ADM_SYS_0011] Cancel<br>
	 * JOB CODE 요청 LIST를 일괄적으로 저장<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageJobCodeManagement(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		AdmSys0011Event event = (AdmSys0011Event)e;
		JobCodeManagementBC command = new JobCodeManagementBCImpl();

		try{
			begin();
			command.manageJobCodeManagement(event.getJobCodeManagementVOs(), account);
			commit();
		} catch(EventException ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [ADM_SYS_0012] Retrieve<br>
	 * Job Code에 Office Mapping을 위한 LIST 조회<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOfficeMapping(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		AdmSys0012Event event = (AdmSys0012Event)e;
		JobCodeManagementBC command = new JobCodeManagementBCImpl();

		try{
			List<OfficeMappingVO> list = command.searchOfficeMapping(event.getOfficeMappingVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [ADM_SYS_0012]<br>
	 * JOB Code Office Mapping 정보를 일괄적으로 저장<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageOfficeMapping(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		AdmSys0012Event event = (AdmSys0012Event)e;
		JobCodeManagementBC command = new JobCodeManagementBCImpl();

		try{
			begin();
			command.manageOfficeMapping(event.getOfficeMappingVOs(), account);
			commit();
		} catch(EventException ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [ADM_SYS_0013]조회 이벤트 처리<br>
	 * Menu List 조회 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMenuList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		AdmSys0013Event event = (AdmSys0013Event)e;
		JobCodeManagementBC command = new JobCodeManagementBCImpl();

		try{
			List<MenuListVO> list = command.searchMenuList(event.getMenuListVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [ADM_SYS_0013]조회 이벤트 처리<br>
	 * Program List 조회 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchProgramList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		AdmSys0013Event event = (AdmSys0013Event)e;
		JobCodeManagementBC command = new JobCodeManagementBCImpl();

		try{
			List<MenuListVO> list = command.searchProgramList(event.getMenuListVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [ADM_SYS_0013]<br>
	 * Program Assign 정보를 일괄적으로 저장<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageProgramList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		AdmSys0013Event event = (AdmSys0013Event)e;
		JobCodeManagementBC command = new JobCodeManagementBCImpl();

		try{
			begin();
			command.manageProgramList(event.getMenuListVOs(), account);
			commit();
		} catch(EventException ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [ADM_SYS_0014]조회 이벤트 처리<br>
	 * Office List 조회 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOfficeList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		AdmSys0014Event event = (AdmSys0014Event)e;
		JobCodeManagementBC command = new JobCodeManagementBCImpl();

		try{
			List<UserInquiryVO> list = command.searchOfficeList(event.getUserInquiryVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [ADM_SYS_0014]조회 이벤트 처리<br>
	 * User List 조회 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchUsrList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		AdmSys0014Event event = (AdmSys0014Event)e;
		JobCodeManagementBC command = new JobCodeManagementBCImpl();

		try{
			List<UserInquiryVO> list = command.searchUsrList(event.getUserInquiryVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [ADM_SYS_0014]<br>
	 * User Inquiry 정보를 일괄적으로 저장<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageUsrList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		AdmSys0014Event event = (AdmSys0014Event)e;
		JobCodeManagementBC command = new JobCodeManagementBCImpl();

		try{
			begin();
			command.manageUsrList(event.getUserInquiryVOs(), account);
			commit();
		} catch(EventException ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [ADM_SYS_0015] Retrieve<br>
	 * JOB Code Adjust Requst LIST와 COUNT를 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAdjustmentRequest(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		AdmSys0015Event event = (AdmSys0015Event)e;
		JobCodeManagementBC command = new JobCodeManagementBCImpl();

		try {
			List<AdjustmentVO> list = command.searchAdjustmentRequest(event.getAdjustmentVO(), account);
			eventResponse.setRsVoList(list);
			eventResponse.setETCData("rqst_knt", command.getRequestCount(account.getUsr_id()));
		} catch (EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [ADM_SYS_0015] Cancel<br>
	 * JOB Code Adjust Requst LIST를 일괄적으로 저장<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageAdjustmentRequest(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		AdmSys0015Event event = (AdmSys0015Event)e;
		JobCodeManagementBC command = new JobCodeManagementBCImpl();

		try{
			begin();
			command.manageAdjustmentRequest(event.getAdjustmentVOs(), account);
			commit();
		} catch(EventException ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [ADM_SYS_0016] Retrieve<br>
	 * Job 신청 LIST를 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchJobCodeRequest(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		AdmSys0016Event event = (AdmSys0016Event)e;
		JobCodeManagementBC command = new JobCodeManagementBCImpl();

		try {
			List<RequestVO> list1 = command.searchJobCodeRequest(event.getRequestVO());
			eventResponse.setRsVoList(list1);

			List<AdjustmentVO> list2 = command.getApprovalUserInfo(account.getUsr_id());
			if (list2.size() > 0) {
				eventResponse.setETCData("apro_usr_id", list2.get(0).getAproUsrId());
				eventResponse.setETCData("apro_usr_nm", list2.get(0).getAproUsrNm());
			}
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [ADM_SYS_0016]<br>
	 * Job 신청 LIST 정보를 일괄적으로 저장<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageJobCodeRequest(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		AdmSys0016Event event = (AdmSys0016Event)e;
		JobCodeManagementBC command = new JobCodeManagementBCImpl();

		try{
			begin();
			command.manageJobCodeRequest(event.getAdjustmentVO(), event.getRequestVOs(), account);
			commit();
		} catch(EventException ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [ADM_SYS_0017] Validation<br>
	 * Approver의 Office Code를 가져옴<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse getApproverOfcInfo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		AdmSys0017Event event = (AdmSys0017Event)e;
		JobCodeManagementBC command = new JobCodeManagementBCImpl();

		try {
			eventResponse.setETCData("apro_ofc_cd", command.getApproverOfcInfo(event.getAdjustmentVO().getAproUsrId()));
		} catch (EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [ADM_SYS_0018] Retrieve<br>
	 * Job Code 요청 목록을 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAdjustmentApproval(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		AdmSys0018Event event = (AdmSys0018Event)e;
		JobCodeManagementBC command = new JobCodeManagementBCImpl();

		try {
			List<AdjustmentVO> list = command.searchAdjustmentApproval(event.getAdjustmentVO(), account);
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [ADM_SYS_0019], [ADM_SYS_0022] Retrieve<br>
	 * Job 신청내역 상세 LIST를 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRequestDetail(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		RequestVO requestVO = null;
		if (e.getEventName().equalsIgnoreCase("AdmSys0019Event")){
			AdmSys0019Event event = (AdmSys0019Event)e;
			requestVO = event.getRequestVO();
		} else if(e.getEventName().equalsIgnoreCase("AdmSys0022Event")){
			AdmSys0022Event event = (AdmSys0022Event)e;
			requestVO = event.getRequestVO();
		}
		JobCodeManagementBC command = new JobCodeManagementBCImpl();

		try {
			List<RequestVO> list = command.searchRequestDetail(requestVO);
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [ADM_SYS_0019]<br>
	 * 신청된 Job에 대한 Approval/Reject 정보를 저장<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageApproval(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		AdmSys0019Event event = (AdmSys0019Event)e;
		JobCodeManagementBC command = new JobCodeManagementBCImpl();

		try{
			begin();
			command.manageApproval(event.getAdjustmentVO(), event.getRequestVOs(), account);
			commit();
		} catch(EventException ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [ADM_SYS_0020] Retrieve<br>
	 * 사용자가 Job Code 정보를 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchUserJobCodeInquiry(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		AdmSys0020Event event = (AdmSys0020Event)e;
		JobCodeManagementBC command = new JobCodeManagementBCImpl();

		try {
			List<JobCodeInquiryVO> list = command.searchJobCodeInquiry(event.getJobCodeInquiryVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * [ADM_SYS_0020]<br>
	 * Approver ID가 이미 존재하는지 확인(존재하면 ADMIN화면과 동일하게 보이기)<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse getApproUsrIdChk() throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		JobCodeManagementBC command = new JobCodeManagementBCImpl();

		try {
			List<ApproverVO> list = command.getApproverUsrId(account.getUsr_id());
			if(list.size() > 0){
				eventResponse.setETCData("apro_exist_id", list.get(0).getAproUsrId());
			}
		} catch (EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [ADM_SYS_0021] Retrieve<br>
	 * Job Code 신청/승인 현황을 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchJobCodeManagementMonitoring(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		AdmSys0021Event event = (AdmSys0021Event)e;
		JobCodeManagementBC command = new JobCodeManagementBCImpl();

		try {
			List<AdjustmentVO> list = command.searchJobCodeManagementMonitoring(event.getAdjustmentVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [ADM_SYS_0023]<br>
	 * Program Job Code Mapping 정보를 조회<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchProgramCodeMappingList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		AdmSys0023Event event = (AdmSys0023Event)e;
		JobCodeManagementBC command = new JobCodeManagementBCImpl();

		try{
			List<JobCodeManagementVO> list = command.searchProgramCodeMappingList(event.getJobCodeManagementVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * [ADM_SYS_0024]<br>
	 * Approver List를 조회하는 화면<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchApproverManagement(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		AdmSys0024Event event = (AdmSys0024Event)e;
		JobCodeManagementBC command = new JobCodeManagementBCImpl();

		try{
			List<ApproverVO> list = command.searchApproverManagement(event.getApproverVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * [ADM_SYS_0024] Cancel<br>
	 * Approver List를 일괄적으로 삭제<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageApproverManagement(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		AdmSys0024Event event = (AdmSys0024Event)e;
		JobCodeManagementBC command = new JobCodeManagementBCImpl();

		try{
			begin();
			command.manageApproverManagement(event.getApproverVOs(), account);
			commit();
		} catch(EventException ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
	
	/**
	 * [ADM_SYS_0025]<br>
	 * Approver ID가 이미 존재하는지 확인<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse getApproverUsrId(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		AdmSys0025Event event = (AdmSys0025Event)e;
		JobCodeManagementBC command = new JobCodeManagementBCImpl();

		try {
			List<ApproverVO> list = command.getApproverUsrId(event.getApproverVO().getAproUsrId());
			if(list.size() > 0){
				eventResponse.setETCData("usr_yn", "Y");
				eventResponse.setETCData("apro_exist_id", list.get(0).getAproUsrId());
				eventResponse.setETCData("usr_chk", list.get(0).getUsrChk());
			} else {
				eventResponse.setETCData("usr_yn", "N");
			}
		} catch (EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * [ADM_SYS_0025]<br>
	 * Approver User Id 저장<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageApproverUsrId(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		AdmSys0025Event event = (AdmSys0025Event)e;
		JobCodeManagementBC command = new JobCodeManagementBCImpl();

		try{
			begin();
			command.manageApproverUsrId(event.getApproverVOs(), account);
			commit();
		} catch(EventException ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

}
