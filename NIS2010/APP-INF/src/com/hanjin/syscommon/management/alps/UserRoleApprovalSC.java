/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : UserRoleApprovalSC.java
*@FileTitle : Role Approval
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.20
*@LastModifier : 
*@LastVersion : 1.0
* 2015.11.20 
* 1.0 Creation
=========================================================*/
package com.hanjin.syscommon.management.alps;

import java.util.Arrays;
import java.util.List;

import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.management.alps.role.basic.UserRoleApprovalBC;
import com.hanjin.syscommon.management.alps.role.basic.UserRoleApprovalBCImpl;
import com.hanjin.syscommon.management.alps.role.event.ComSec0002Event;
import com.hanjin.syscommon.management.alps.role.event.ComSec0003Event;
import com.hanjin.syscommon.management.alps.role.event.ComSec0004Event;
import com.hanjin.syscommon.management.alps.role.integration.UserRoleApprovalDBDAO;
import com.hanjin.syscommon.management.alps.role.vo.AuthorityVO;
import com.hanjin.syscommon.management.alps.role.vo.ComUsrRoleConditionVO;
import com.hanjin.syscommon.management.alps.role.vo.MenuListVO;
import com.hanjin.syscommon.management.alps.role.vo.UserRoleAuthAproVO;
import com.hanjin.syscommon.management.alps.role.vo.UserRoleRqstEmlVO;
import com.hanjin.syscommon.management.alps.superuser.basic.SuperUserBC;
import com.hanjin.syscommon.management.alps.superuser.basic.SuperUserBCImpl;


/**
 * ALPS-UserRoleApproval Business Logic ServiceCommand - ALPS-UserRoleApproval 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author 
 * @see UserRoleApprovalDBDAO
 * @since J2EE 1.6
 */

public class UserRoleApprovalSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * UserRoleApproval system 업무 시나리오 선행작업<br>
	 * 업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		log.debug("UserRoleApprovalSC 시작");
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * UserRoleApproval system 업무 시나리오 마감작업<br>
	 * 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("UserRoleApprovalSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * ALPS-UserRoleApproval system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getEventName().equalsIgnoreCase("ComSec0002Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = selectMenuList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = selectModuleRole(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)){
				eventResponse = manageUserRoleRpst(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)){
				eventResponse = selectRqstRoleModuleList(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("ComSec0003Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = selectUserRoleAuthAproList(e);	
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)){
				eventResponse = manageUserRoleAuthApro(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)){
				eventResponse = selectRqstRoleCd(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("ComSec0004Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchRoleAuthorityApprovalMonitoring(e);
			}else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)) {
				eventResponse = getSystemCode(e);
			}
		}
		return eventResponse;
	}
	/**
	 * 메뉴 조회<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse selectMenuList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ComSec0002Event event = (ComSec0002Event)e;
		UserRoleApprovalBC command = new UserRoleApprovalBCImpl();

		try{
			List<MenuListVO> list = command.selectMenuList(event.getMenuListVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			log.error(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * Role 조회<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse selectModuleRole(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ComSec0002Event event = (ComSec0002Event)e;
		UserRoleApprovalBC command = new UserRoleApprovalBCImpl();

		try{
			List<ComUsrRoleConditionVO> list = command.selectModuleRole(event.getSubSysCd(), account);
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			log.error(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * Role을 신청한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageUserRoleRpst(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ComSec0002Event event = (ComSec0002Event)e;
		UserRoleApprovalBC command = new UserRoleApprovalBCImpl();
		try{
			
			begin();
			
			//role을 신청한다.
			List<String> rqstList = command.manageUserRoleRpst(event.getUserRoleAuthAproVOs(), account);
			//eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());

			//role의 superUser에게 메일을 보낸다.
			StringBuffer rqst_ids = new StringBuffer();
			if(rqstList != null && rqstList.size() > 0){
				for(int i=0; i < rqstList.size(); i++){
					rqst_ids.append((String)rqstList.get(i));
					
					if(i+1 != rqstList.size()){
						rqst_ids.append("|");
					}
				}
			}
			
			log.debug(rqst_ids.toString());
			
			List<UserRoleAuthAproVO> rqstRolelist = command.selectRqstRoleList(rqstList);
			command.sendUserRoleRqstEml(rqstRolelist);

			commit();
		} catch(EventException ex) {
			rollback();
			log.error(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch(Exception ex) {
			rollback();
			log.error(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		return eventResponse;
	}
	
	/**
	 * COM_SEC_0003 : 조회<br>
	 * user role 신청을 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse selectUserRoleAuthAproList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		UserRoleApprovalBC command = new UserRoleApprovalBCImpl();

		try{
			List<UserRoleAuthAproVO> list = command.selectSuperUserRoleModule(account);
			
			StringBuffer superUserRole = new StringBuffer();
			for(int i=0; i < list.size(); i++){
				UserRoleAuthAproVO userRoleAuthAproVO = list.get(i);
				superUserRole.append(userRoleAuthAproVO.getRoleModule());
				
				if(i+1 != list.size()){
					superUserRole.append(", ");
				}
			}

			eventResponse.setETCData("superUsrRoleMod", superUserRole.toString());
			
			List<UserRoleAuthAproVO> list2 = command.selectUserRoleAuthAproList(account);
			eventResponse.setRsVoList(list2);
			
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}

	
	/**
	 * COM_SEC_0003 : 저장<br>
	 * user role에 대한 신청을 승인합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageUserRoleAuthApro(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ComSec0003Event event = (ComSec0003Event)e;
		UserRoleApprovalBC command = new UserRoleApprovalBCImpl();
		try{
			begin();
			command.manageUserRoleAuthApro(event.getUserRoleAuthAproVOs(), account);
			//eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			commit();
		} catch(EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		return eventResponse;
	}
	
	/**
	 * [COM_SEC_0003] 이미 저장된 role_cd 인지 validation check<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse selectRqstRoleCd(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ComSec0003Event event = (ComSec0003Event) e;
		UserRoleApprovalBC command = new UserRoleApprovalBCImpl();

		try {

			UserRoleAuthAproVO UserRoleAuthAproVO = (UserRoleAuthAproVO) event.getUserRoleAuthAproVO();
			String returnVal = command.selectRqstRoleCd(UserRoleAuthAproVO.getUsrRoleCd(),UserRoleAuthAproVO.getRqstUsrId());
			
			if(returnVal != null && !"".equals(returnVal)){
				returnVal = "existed";
			}else{
				returnVal = "none";
			}
			
			eventResponse.setETCData("rqstRoleStatus", returnVal);

		} catch (EventException ex) {
			log.error(ex.getMessage(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	/**
	 * [COM_SEC_0004] Retrieve<br>
	 * ALPS Role Authority Approval Monitoring<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRoleAuthorityApprovalMonitoring(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ComSec0004Event event = (ComSec0004Event)e;
		UserRoleApprovalBC command = new UserRoleApprovalBCImpl();

		try {
			List<AuthorityVO> list = command.searchRoleAuthorityApprovalMonitoring(event.getParam());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * AccessHistory : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse getSystemCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		SuperUserBC command = new SuperUserBCImpl();
		UserRoleApprovalBC command2 = new UserRoleApprovalBCImpl();

		try{
			String[] list = command.searchSubSystemList();
			List<UserRoleAuthAproVO> list2 = command2.selectSuperUserRoleModule(account);
			
			StringBuffer superUserRole = new StringBuffer();
			for(int i=0; i < list2.size(); i++){
				UserRoleAuthAproVO userRoleAuthAproVO = list2.get(i);
				superUserRole.append(userRoleAuthAproVO.getRoleModule());
				
				if(i+1 != list2.size()){
					superUserRole.append(", ");
				}
			}
			
			Arrays.sort(list);
			eventResponse.setETCData("sub_sys_cd", Arrays.toString(list));
			eventResponse.setETCData("sp_sub_sys_cd", superUserRole.toString());
			
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * Request User Role 조회<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse selectRqstRoleModuleList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ComSec0002Event event = (ComSec0002Event)e;
		UserRoleApprovalBC command = new UserRoleApprovalBCImpl();
		
		try{
			List<ComUsrRoleConditionVO> list = command.selectRqstRoleModuleList(event.getSubSysCd(), event.getRqstUsrId());
			eventResponse.setRsVoList(list);
			
		}catch(EventException ex){
			log.error(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
}