/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : UserRoleApprovalBC.java
*@FileTitle : Role Approval
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.20
*@LastModifier : 
*@LastVersion : 1.0
* 2015.11.20 
* 1.0 Creation
=========================================================*/
package com.hanjin.syscommon.management.alps.role.basic;

import java.util.HashMap;
import java.util.List;

import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.management.alps.role.vo.AuthorityVO;
import com.hanjin.syscommon.management.alps.role.vo.ComUsrRoleConditionVO;
import com.hanjin.syscommon.management.alps.role.vo.MenuListVO;
import com.hanjin.syscommon.management.alps.role.vo.UserRoleAuthAproVO;
import com.hanjin.syscommon.management.alps.role.vo.UserRoleRqstEmlVO;

/**
 * UserRoleApprovalBC Business Logic Command Interface<br>
 * - UserRoleApprovalBC에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author
 * @see 
 * @since J2EE 1.6
 */
public interface UserRoleApprovalBC {

	/**
	 * 메뉴 리스트 조회<br>
	 * 
	 * @param MenuListVO menuListVO
	 * @return List<MenuListVO>
	 * @exception EventException
	 */
	public List<MenuListVO> selectMenuList(MenuListVO menuListVO) throws EventException;
	
	
	/**
	 * role 리스트를 조회<br>
	 * 
	 * @param String subSysCd
	 * @param SignOnUserAccount account
	 * @return List<ComUsrRoleConditionVO>
	 * @exception EventException
	 */
	public List<ComUsrRoleConditionVO> selectModuleRole(String subSysCd, SignOnUserAccount account) throws EventException;
	
	
	/**
	 * rqst user의 role 리스트를 조회<br>
	 * 
	 * @param String subSysCd
	 * @param String rqstUsrId
	 * @return List<ComUsrRoleConditionVO>
	 * @exception EventException
	 */
	public List<ComUsrRoleConditionVO> selectRqstRoleModuleList(String subSysCd, String rqstUsrId) throws EventException;
	

	/**
	 * user role을 신청<br>
	 * 
	 * @param UserRoleAuthAproVO[] userRoleAuthAproVOs
	 * @param SignOnUserAccount account
	 * @return List<String>
	 * @exception EventException
	 */
	public List<String> manageUserRoleRpst(UserRoleAuthAproVO[] userRoleAuthAproVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * user role 신청 조회<br>
	 * 
	 * @param SignOnUserAccount account
	 * @return List<UserRoleAuthAproVO>
	 * @exception EventException
	 */
	public List<UserRoleAuthAproVO> selectUserRoleAuthAproList(SignOnUserAccount account) throws EventException;
	
	/**
	 * super User Module 조회<br>
	 * 
	 * @param SignOnUserAccount account
	 * @return List<UserRoleAuthAproVO>
	 * @exception EventException
	 */
	public List<UserRoleAuthAproVO> selectSuperUserRoleModule(SignOnUserAccount account) throws EventException;
	
	/**
	 * user role 승인<br>
	 * 
	 * @param UserRoleAuthAproVO[] userRoleAuthAproVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void manageUserRoleAuthApro(UserRoleAuthAproVO[] userRoleAuthAproVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * [COM_SEC_0004]<br>
	 * ALPS Role Authority Approval Monitoring<br>
	 *
	 * @param HashMap<String, String> param
	 * @return List<AdjustmentVO>
	 * @exception EventException
	 */
	public List<AuthorityVO> searchRoleAuthorityApprovalMonitoring(HashMap<String, String> param) throws EventException;


	/**
	 * [COM_SEC_0003]<br>
	 * ALPS Role Validation Check<br>
	 * 
	 * @param String rqstRoleCd
	 * @param String rqstUsrId
	 * @return String
	 * @exception EventException
	 */
	public String selectRqstRoleCd(String rqstRoleCd, String rqstUsrId) throws EventException;
	
	/**
	 * [COM_SEC_0003]<br>
	 * ALPS Role Request List<br>
	 * 
	 * @param List<String> rqstList
	 * @return List<UserRoleAuthAproVO>
	 * @exception EventException
	 */
	public List<UserRoleAuthAproVO> selectRqstRoleList(List<String> rqstList) throws EventException;

	/**
	 * [COM_SEC_0003]<br>
	 * ALPS Role Request Send Email<br>
	 * 
	 * @param List<UserRoleAuthAproVO> userRoleAuthAproVOs
	 * @return List<UserRoleRqstEmlVO>
	 * @exception EventException
	 */
	public List<UserRoleRqstEmlVO> sendUserRoleRqstEml(List<UserRoleAuthAproVO> UserRoleAuthAproVOs) throws EventException;
}