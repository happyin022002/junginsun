/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : UI_COM_SYS_007Event.java
*@FileTitle : 역할관리
*Open Issues :
*Change history :
*@LastModifyDate : 2006-09-15
*@LastModifier : SeongWook Kim
*@LastVersion : 1.0
* 2006-09-15 SeongWook Kim
* 1.0 최초 생성
=========================================================*/
package com.hanjin.syscommon.management.alps.role.event;

import java.util.Arrays;
import java.util.Collection;

import com.hanjin.framework.support.layer.event.EventSupport;

import com.hanjin.syscommon.common.table.ComPgmRoleVO;
import com.hanjin.syscommon.common.table.ComUserVO;
import com.hanjin.syscommon.common.table.ComUsrRoleVO;
import com.hanjin.syscommon.management.alps.officemanagement.vo.OfcPgmLvlListVO;
import com.hanjin.syscommon.management.alps.officemanagement.vo.OfficListVO;
import com.hanjin.syscommon.management.alps.role.vo.ComUsrRoleConditionVO;


/**
 * UI_COM_SYS_007 에 대한 PDTO(Data Transfer Object including Parameters)<br> 
 * - UI_COM_SYS_007HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author SeongWook Kim
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class ComSys007Event extends EventSupport {

	/** com_pgm_roles Multi Action을 위한 Collection */
//	private Collection comPgmRoles = null;

	/** com_usr_role_mtchs Multi Action을 위한 Collection */
//	private Collection comUsrRoleMtchs = null;

	/** com_usr_role Table  Value Object */
//	private COM_USR_ROLE com_usr_role = null;

	/** com_usr_roles Multi Action을 위한 Collection */
	private ComUsrRoleVO[] comUsrRoles = null;

	private ComUsrRoleConditionVO comUsrRoleConditionVO = null;

	/**
	 * 
	 */
	public ComSys007Event(){}

	/**
	 * @param com_pgm_role
	 */
//	public UI_COM_SYS_007Event(COM_PGM_ROLE com_pgm_role) {
//		this.com_pgm_role = com_pgm_role;
//	}
//
//	/**
//	 * @param com_pgm_role
//	 * @param com_pgm_roles
//	 */
//	public UI_COM_SYS_007Event(COM_PGM_ROLE com_pgm_role, Collection com_pgm_roles) {
//		this.com_pgm_role = com_pgm_role;
//		this.com_pgm_roles = com_pgm_roles;
//	}
//
//	/**
//	 * @param com_pgm_role
//	 * @param com_pgm_roles
//	 * @param com_usr_role_mtch
//	 */
//	public UI_COM_SYS_007Event(COM_PGM_ROLE com_pgm_role, Collection com_pgm_roles, COM_USR_ROLE_MTCH com_usr_role_mtch) {
//		this.com_pgm_role = com_pgm_role;
//		this.com_pgm_roles = com_pgm_roles;
//		this.com_usr_role_mtch = com_usr_role_mtch;
//	}
//
//	/**
//	 * @param com_pgm_role
//	 * @param com_pgm_roles
//	 * @param com_usr_role_mtch
//	 * @param com_usr_role_mtchs
//	 */
//	public UI_COM_SYS_007Event(COM_PGM_ROLE com_pgm_role, Collection com_pgm_roles, COM_USR_ROLE_MTCH com_usr_role_mtch, Collection com_usr_role_mtchs) {
//		this.com_pgm_role = com_pgm_role;
//		this.com_pgm_roles = com_pgm_roles;
//		this.com_usr_role_mtch = com_usr_role_mtch;
//		this.com_usr_role_mtchs = com_usr_role_mtchs;
//	}
//
//	/**
//	 * @param com_pgm_role
//	 * @param com_pgm_roles
//	 * @param com_usr_role_mtch
//	 * @param com_usr_role_mtchs
//	 * @param com_usr_role
//	 */
//	public UI_COM_SYS_007Event(COM_PGM_ROLE com_pgm_role, Collection com_pgm_roles, COM_USR_ROLE_MTCH com_usr_role_mtch, Collection com_usr_role_mtchs, COM_USR_ROLE com_usr_role) {
//		this.com_pgm_role = com_pgm_role;
//		this.com_pgm_roles = com_pgm_roles;
//		this.com_usr_role_mtch = com_usr_role_mtch;
//		this.com_usr_role_mtchs = com_usr_role_mtchs;
//		this.com_usr_role = com_usr_role;
//	}
//
//	/**
//	 * @param com_pgm_role
//	 * @param com_pgm_roles
//	 * @param com_usr_role_mtch
//	 * @param com_usr_role_mtchs
//	 * @param com_usr_role
//	 * @param com_usr_roles
//	 */
//	public UI_COM_SYS_007Event(COM_PGM_ROLE com_pgm_role, Collection com_pgm_roles, COM_USR_ROLE_MTCH com_usr_role_mtch, Collection com_usr_role_mtchs, COM_USR_ROLE com_usr_role, Collection com_usr_roles) {
//		this.com_pgm_role = com_pgm_role;
//		this.com_pgm_roles = com_pgm_roles;
//		this.com_usr_role_mtch = com_usr_role_mtch;
//		this.com_usr_role_mtchs = com_usr_role_mtchs;
//		this.com_usr_role = com_usr_role;
//		this.com_usr_roles = com_usr_roles;
//	}
//
//	/**
//	 * @param com_pgm_role
//	 * @param com_pgm_roles
//	 * @param com_usr_role_mtch
//	 * @param com_usr_role_mtchs
//	 * @param com_usr_role
//	 * @param com_usr_roles
//	 * @param com_user
//	 */
//	public UI_COM_SYS_007Event(COM_PGM_ROLE com_pgm_role, Collection com_pgm_roles, COM_USR_ROLE_MTCH com_usr_role_mtch, Collection com_usr_role_mtchs, COM_USR_ROLE com_usr_role, Collection com_usr_roles, ComUserVO com_user) {
//		this.com_pgm_role = com_pgm_role;
//		this.com_pgm_roles = com_pgm_roles;
//		this.com_usr_role_mtch = com_usr_role_mtch;
//		this.com_usr_role_mtchs = com_usr_role_mtchs;
//		this.com_usr_role = com_usr_role;
//		this.com_usr_roles = com_usr_roles;
//		this.com_user = com_user;
//	}

	/**
	 * @param com_pgm_role
	 * @param com_pgm_roles
	 * @param com_usr_role_mtch
	 * @param com_usr_role_mtchs
	 * @param com_usr_role
	 * @param com_usr_roles
	 * @param com_user
	 * @param com_users
	 */
//
//	/**
//	 * @param com_pgm_role
//	 * @param com_pgm_roles
//	 * @param com_usr_role_mtch
//	 * @param com_usr_role_mtchs
//	 * @param com_usr_role
//	 * @param com_usr_roles
//	 * @param com_user
//	 * @param com_users
//	 * @param role_cd
//	 */
//	public UI_COM_SYS_007Event(COM_PGM_ROLE com_pgm_role, Collection com_pgm_roles, COM_USR_ROLE_MTCH com_usr_role_mtch, Collection com_usr_role_mtchs, COM_USR_ROLE com_usr_role, Collection com_usr_roles, ComUserVO com_user, Collection com_users) {
//		this.com_pgm_role = com_pgm_role;
//		this.com_pgm_roles = com_pgm_roles;
//		this.com_usr_role_mtch = com_usr_role_mtch;
//		this.com_usr_role_mtchs = com_usr_role_mtchs;
//		this.com_usr_role = com_usr_role;
//		this.com_usr_roles = com_usr_roles;
//		this.com_user = com_user;
//		this.com_users = com_users;
////		this.role_cd = role_cd;
//	}

	/**
	 * @param com_pgm_role
	 * @param com_pgm_roles
	 * @param com_usr_role_mtch
	 * @param com_usr_role_mtchs
	 * @param com_usr_role
	 * @param com_usr_roles
	 * @param com_user
	 * @param com_users
	 * @param role_cd
	 * @param role_nm
	 */

	/**
	 * @param com_pgm_role
	 * @param com_usr_role_mtch
	 * @param com_usr_role
	 * @param com_user
	 * @param role_cd
	 * @param role_nm
	 */
//	public UI_COM_SYS_007Event(COM_PGM_ROLE com_pgm_role, COM_USR_ROLE_MTCH com_usr_role_mtch, COM_USR_ROLE com_usr_role, ComUserVO com_user) {
//		this.com_pgm_role = com_pgm_role;
//		this.com_usr_role_mtch = com_usr_role_mtch;
//		this.com_usr_role = com_usr_role;
//		this.com_user = com_user;
////		this.role_cd = role_cd;
////		this.role_nm = role_nm;
//	}
//
//	/**
//	 * @param com_usr_role
//	 * @param role_cd
//	 * @param role_nm
//	 */
//	public UI_COM_SYS_007Event(COM_USR_ROLE com_usr_role, Collection comUsrRoles) {
//		this.com_usr_role = com_usr_role;
//		
////		this.role_cd = role_cd;
////		this.role_nm = role_nm;
//	}

	/**
	 * @return
	 */
//	public COM_PGM_ROLE getCOM_PGM_ROLE(){
//		return com_pgm_role;
//	}

	/**
	 * @return
	 */
//	public Collection getCOM_PGM_ROLES(){
//		return com_pgm_roles;
//	}

	/**
	 * @return
	 */
//	public COM_USR_ROLE_MTCH getCOM_USR_ROLE_MTCH(){
//		return com_usr_role_mtch;
//	}

	/**
	 * @return
	 */
//	public Collection getCOM_USR_ROLE_MTCHS(){
//		return com_usr_role_mtchs;
//	}
//
//	/**
//	 * @return
//	 */
//	public COM_USR_ROLE getCOM_USR_ROLE(){
//		return com_usr_role;
//	}
//
//	/**
//	 * @return
//	 */
//	public Collection getCOM_USR_ROLES(){
//		return com_usr_roles;
//	}
//
//	/**
//	 * @return
//	 */
//	public ComUserVO getComUser(){
//		return com_user;
//	}

	/**
	 * @return
	 */
//	public Collection getComUserS(){
//		return com_users;
//	}


	public void setComUsrRoleConditionVO(ComUsrRoleConditionVO comUsrRoleConditionVO) {
		this.comUsrRoleConditionVO = comUsrRoleConditionVO;
	}

	public ComUsrRoleConditionVO getComUsrRoleConditionVO() {
		return comUsrRoleConditionVO;
	}

	public void setComUsrRoles(ComUsrRoleVO[] comUsrRoles) {
		if(comUsrRoles != null) {
			ComUsrRoleVO[] tmpVOs= Arrays.copyOf(comUsrRoles, comUsrRoles.length);
			this. comUsrRoles = tmpVOs;
		}
	}

	public ComUsrRoleVO[] getComUsrRoles() {
		ComUsrRoleVO[] rtnVOs = null;
		if(this.comUsrRoles!= null) {
			rtnVOs=Arrays.copyOf(comUsrRoles, comUsrRoles.length);	
		}
		return rtnVOs;
	}

}
