/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ComSec0003Event.java
*@FileTitle : 테스트
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.04
*@LastModifier : 
*@LastVersion : 1.0
* 2015.12.04 
* 1.0 Creation
=========================================================*/
package com.hanjin.syscommon.management.alps.role.event;

import java.util.Arrays;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.management.alps.role.vo.UserRoleAuthAproVO;


/**
 * COM_SEC_0003 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  COM_SEC_0003HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see COM_SEC_0003HTMLAction 참조
 * @since J2EE 1.6
 */

public class ComSec0003Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	UserRoleAuthAproVO userRoleAuthAproVO = null;
	
	/** Table Value Object Multi Data 처리 */
	UserRoleAuthAproVO[] userRoleAuthAproVos = null;
	
	String usrAuthModule;
	String ofcCd;

	public ComSec0003Event(){}
	
	public void setUserRoleAuthAproVO(UserRoleAuthAproVO userRoleAuthAproVO){
		this. userRoleAuthAproVO = userRoleAuthAproVO;
	}

	public void setUserRoleAuthAproVOs(UserRoleAuthAproVO[] userRoleAuthAproVOs){
		if (userRoleAuthAproVOs != null) {
			UserRoleAuthAproVO[] tmpVOs = Arrays.copyOf(userRoleAuthAproVOs, userRoleAuthAproVOs .length);
			this.userRoleAuthAproVos = tmpVOs;
		}
	}

	public UserRoleAuthAproVO getUserRoleAuthAproVO(){
		return userRoleAuthAproVO;
	}

	public UserRoleAuthAproVO[] getUserRoleAuthAproVOs(){
		UserRoleAuthAproVO[] tmpVOs = null;
		if (this.userRoleAuthAproVos != null) {
			tmpVOs = Arrays.copyOf(userRoleAuthAproVos, userRoleAuthAproVos.length);
		}
		return tmpVOs;
	}

	public String getOfcCd() {
		return ofcCd;
	}

	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}

	public String getUsrAuthModule() {
		return usrAuthModule;
	}

	public void setUsrAuthModule(String usrAuthModule) {
		this.usrAuthModule = usrAuthModule;
	}
}