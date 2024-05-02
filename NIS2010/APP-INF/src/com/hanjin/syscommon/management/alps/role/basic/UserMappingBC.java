/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : RoleBC.java
*@FileTitle : 사용자 매핑
*Open Issues :
*Change history :
*@LastModifyDate : 2006-09-13
*@LastModifier : SeongWook Kim
*@LastVersion : 1.0
* 2006-09-13 SeongWook Kim
* 1.0 최초 생성
=========================================================*/
package com.hanjin.syscommon.management.alps.role.basic;

import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.ComUsrRoleMtchVO;
import com.hanjin.syscommon.management.alps.role.vo.SearchMdmOrganizationVO;
import com.hanjin.syscommon.management.alps.role.vo.SearchUserMappingUsersVO;

/**
 * syscommon-syscommon Business Logic Command Interface<br>
 * - syscommon-syscommon에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author SeongWook Kim
 * @see 
 * @since J2EE 1.4
 */
public interface UserMappingBC  {

	/**
	 * 멀티 이벤트 처리<br>
	 * UI_COM_SYS_009 화면에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param ComUsrRoleMtchVO[] comUsrRoleMtchVOs
	 * @param SignOnUserAccount account
	 * @return EventResponse UI_COM_SYS_009EventResponse
	 * @exception EventException
	 */
	public EventResponse multiRoleUserMatch(ComUsrRoleMtchVO[] comUsrRoleMtchVOs, SignOnUserAccount account) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * role화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param SignOnUserAccount account
	 * @return SearchMdmOrganizationVO[]
	 * @exception EventException
	 */
	public SearchMdmOrganizationVO[] searchOfficeList(SignOnUserAccount account) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * role화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param SignOnUserAccount account
	 * @param String ofcCd
	 * @param String usrRoleCd
	 * @return SearchUserMappingUsersVO[]
	 * @exception EventException
	 */
	public SearchUserMappingUsersVO[] searchUserList(SignOnUserAccount account,String ofcCd,String usrRoleCd) throws EventException;

}