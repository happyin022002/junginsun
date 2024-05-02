/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : UserMappingManagementSC.java
*@FileTitle : 사용자 매핑
*Open Issues :
*Change history :
*@LastModifyDate : 2006-09-13
*@LastModifier : SeongWook Kim
*@LastVersion : 1.0
* 2006-09-13 SeongWook Kim
* 1.0 최초 생성
=========================================================*/
package com.hanjin.syscommon.management.alps;

import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.ComUsrRoleMtchVO;
import com.hanjin.syscommon.management.AbstractSysCommonSC;
import com.hanjin.syscommon.management.alps.role.basic.UserMappingBC;
import com.hanjin.syscommon.management.alps.role.basic.UserMappingBCImpl;
import com.hanjin.syscommon.management.alps.role.event.ComSys009Event;
import com.hanjin.syscommon.management.alps.role.vo.SearchMdmOrganizationVO;
import com.hanjin.syscommon.management.alps.role.vo.SearchUserMappingUsersVO;

/**
 * syscommon-syscommon Business Logic ServiceCommand<br>
 * - syscommon-syscommon에 대한 비지니스 트랜잭션을 처리한다.<br>
 * 
 * @author SeongWook Kim
 * @see UI_COM_SYS_009EventResponse,RoleDBDAO 참조
 * @since J2EE 1.4
 */
public class UserMappingManagementSC extends AbstractSysCommonSC {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * syscommon 업무 시나리오 선행작업<br>
	 * Role업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		try {
			// 일단 comment --> 로그인 체크 부분
			account=getSignOnUserAccount();
		} catch (Exception e) {
			log.error("UserMappingManagementSC Error while preprocessing " + e.toString(), e);
		}
	}

	/**
	 * syscommon 업무 시나리오 마감작업<br>
	 * Role업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		// command.doEnd();
		log.debug("UserMappingManagementSC End");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * syscommon-syscommon 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		//관리자권한체크
		isAdministrator(this.account);
		
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = new GeneralEventResponse();

		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getEventName().equalsIgnoreCase("ComSys009Event")) {
			ComSys009Event event = (ComSys009Event)e;
			//Operator 소속조직,관리권한코드 설정
//			event.setLogin_user_ofc_cd(account.getOfc_cd());
//			event.setLogin_user_usr_auth_tp_cd(account.getUsr_auth_tp_cd());
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchOfficeList();
				
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchUserList(account,event.getOfcCd(), event.getRoleCd());
				
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = multiRoleUserMatch(e);
			} else {
				eventResponse = null;
			}
		}
		return eventResponse;
	}

	/**
	 * 조회 이벤트 처리<br>
	 * Role 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOfficeList() throws EventException {
		EventResponse eventResponse = new GeneralEventResponse();
		SearchMdmOrganizationVO[] searchMdmOrganizationVOVOs = null; 
		
		try {
			UserMappingBC command = new UserMappingBCImpl();
			searchMdmOrganizationVOVOs = command.searchOfficeList(account);
			eventResponse.setRsVoArray(searchMdmOrganizationVOVOs);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * 조회 이벤트 처리<br>
	 * Role 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchUserList(SignOnUserAccount account,String ofcCd,String usrRoleCd) throws EventException {
		EventResponse eventResponse = new GeneralEventResponse();
		SearchUserMappingUsersVO[] searchUserMappingUsersVOs = null;
		
		try {
			UserMappingBC command = new UserMappingBCImpl();
			searchUserMappingUsersVOs = command.searchUserList(account,ofcCd,usrRoleCd);
			eventResponse.setRsVoArray(searchUserMappingUsersVOs);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * 멀티 이벤트 처리<br>
	 * Role의 event에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse multiRoleUserMatch(Event e) throws EventException {
		EventResponse eventResponse = new GeneralEventResponse();
		ComSys009Event event = (ComSys009Event)e;

		try {
			begin();
			UserMappingBC command = new UserMappingBCImpl();
			ComUsrRoleMtchVO[] comUsrRoleMtchVOs = event.getComUsrRoleMtchVOS();
			if(comUsrRoleMtchVOs!=null){
				int cnt = comUsrRoleMtchVOs.length;
				String creUsrId = account.getUsr_id();
				String usrRoleCd = event.getRoleCd();
				for(int i=0;i<cnt;i++){
					ComUsrRoleMtchVO comUsrRoleMtchVO = comUsrRoleMtchVOs[i];
					comUsrRoleMtchVO.setCreUsrId(creUsrId);
					comUsrRoleMtchVO.setUsrRoleCd(usrRoleCd);
				}
				
				command.multiRoleUserMatch(comUsrRoleMtchVOs, account);
			}
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		
//		return this.searchUserList(e);
		return eventResponse;
	}

}