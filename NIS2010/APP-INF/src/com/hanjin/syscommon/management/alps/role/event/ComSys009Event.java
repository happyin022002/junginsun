/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : UI_COM_SYS_009Event.java
*@FileTitle : 사용자 매핑
*Open Issues :
*Change history :
*@LastModifyDate : 2006-09-13
*@LastModifier : SeongWook Kim
*@LastVersion : 1.0
* 2006-09-13 SeongWook Kim
* 1.0 최초 생성
=========================================================*/
package com.hanjin.syscommon.management.alps.role.event;

import java.util.Arrays;

import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.ComUsrRoleMtchVO;
import com.hanjin.syscommon.common.table.ComUsrRoleVO;
import com.hanjin.syscommon.management.alps.officemanagement.vo.OfficListVO;



/**
 * UI_COM_SYS_009 에 대한 PDTO(Data Transfer Object including Parameters)<br> 
 * - UI_COM_SYS_009HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author SeongWook Kim
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class ComSys009Event extends EventSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5255998355220046757L;

	/** com_role Table  Value Object */
	private ComUsrRoleMtchVO comUsrRoleMtch = null;

	/** com_roles Multi Action을 위한 Collection */
	private ComUsrRoleMtchVO[] comUsrRoleMtchs = null;

	/** role_cd 변수 (Form 객체) */
	private String roleCd = null;

	/** role_nm 변수 (Form 객체) */
	private String roleNm = null;

	/** ofc_cd 변수 (Form 정보) */
	private String ofcCd = null;

//	/** usr_auth_tp_cd 변수 (Session 정보) */
//	private String login_user_usr_auth_tp_cd = null;
//
//	/** ofcCd 변수 (Session 정보) */
//	private String login_user_ofc_cd = null;

	/**
	 * 
	 */
	public ComSys009Event(){}

	/**
	 * @param roleCd
	 * @param roleNm
	 * @param ofcCd
	 */
	public ComSys009Event(String roleCd, String roleNm, String ofcCd) {
		this.roleCd = roleCd;
		this.roleNm = roleNm;
		this.ofcCd = ofcCd;
	}

	/**
	 * @param comUsrRoleMtch
	 * @param roleCd
	 * @param roleNm
	 * @param ofcCd
	 */
	public ComSys009Event(ComUsrRoleMtchVO comUsrRoleMtch, String roleCd, String roleNm, String ofcCd) {
		this.comUsrRoleMtch = comUsrRoleMtch;
		this.roleCd = roleCd;
		this.roleNm = roleNm;
		this.ofcCd = ofcCd;
	}

	/**
	 * @param com_role
	 * @param com_roles
	 * @param roleCd
	 * @param roleNm
	 * @param ofcCd
	 */
//	public UI_COM_SYS_009Event(ComUsrRoleMtchVO comUsrRoleMtch, Collection comUsrRoleMtchs, String roleCd, String roleNm, String ofcCd) {
//		this.comUsrRoleMtch = comUsrRoleMtch;
//		this.comUsrRoleMtchs = comUsrRoleMtchs;
//		this.roleCd = roleCd;
//		this.roleNm = roleNm;
//		this.ofcCd = ofcCd;
//	}

	/**
	 * @return roleCd
	 */
	public String getRoleCd(){
		return roleCd;
	}

	/**
	 * @param roleCd
	 */
	public void setRoleCd(String roleCd) {
		this.roleCd = roleCd;
	}

	/**
	 * @return roleNm
	 */ 
	public String getRoleNm() {
		return roleNm;
	}

	/**
	 * @param roleNm
	 */
	public void setRoleNm(String roleNm) {
		this.roleNm = roleNm;
	}

	/**
	 * @return comUsrRoleMtch
	 */
	public ComUsrRoleMtchVO getComUsrRoleMtchVO() {
		return comUsrRoleMtch;
	}

	/**
	 * @param com_role
	 */
	public void setComUsrRoleMtchVO(ComUsrRoleMtchVO comUsrRoleMtch) {
		this.comUsrRoleMtch = comUsrRoleMtch;
	}

	/**
	 * @return comUsrRoleMtchs
	 */
	public ComUsrRoleMtchVO[] getComUsrRoleMtchVOS() {
		ComUsrRoleMtchVO[] rtnVOs = null;
		if(this.comUsrRoleMtchs!= null) {
			rtnVOs=Arrays.copyOf(comUsrRoleMtchs, comUsrRoleMtchs.length);	
		}
		return rtnVOs;
	}

	/**
	 * @param comUsrRoleMtchs
	 */
	public void setComUsrRoleMtchVOS(ComUsrRoleMtchVO[] comUsrRoleMtchs) {
		if(comUsrRoleMtchs != null) {
			ComUsrRoleMtchVO[] tmpVOs= Arrays.copyOf(comUsrRoleMtchs, comUsrRoleMtchs.length);
			this. comUsrRoleMtchs = tmpVOs;
		}
	}

	/**
	 * @return
	 */
//	public String getLogin_user_ofc_cd() {
//		return login_user_ofc_cd;
//	}
//
//	/**
//	 * @param login_user_ofc_cd
//	 */
//	public void setLogin_user_ofc_cd(String login_user_ofc_cd) {
//		this.login_user_ofc_cd = login_user_ofc_cd;
//	}
//
//	/**
//	 * @return
//	 */
//	public String getLogin_user_usr_auth_tp_cd() {
//		return login_user_usr_auth_tp_cd;
//	}
//
//	/**
//	 * @param login_user_usr_auth_tp_cd
//	 */
//	public void setLogin_user_usr_auth_tp_cd(String login_user_usr_auth_tp_cd) {
//		this.login_user_usr_auth_tp_cd = login_user_usr_auth_tp_cd;
//	}

	/**
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return ofcCd;
	}

	/**
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}

}
