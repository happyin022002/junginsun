/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UserManagementEvent.java
*@FileTitle : User Management
*Open Issues :
*Change history :
*@LastModifyDate : 2009.02.19
*@LastModifier : 김경범
*@LastVersion : 1.0
* 2009.02.19 김경범
* 1.0 Creation
=========================================================*/
package com.hanjin.syscommon.management.alps.user.event;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.ComUsrRoleVO;
import com.hanjin.syscommon.management.alps.officemanagement.vo.OfficListVO;
import com.hanjin.syscommon.management.alps.user.vo.ComUserVO;
import com.hanjin.syscommon.management.alps.user.vo.ComUsrPgmMtchVO;


/**
 * UserManagement 에 대한 PDTO(Data Transfer Object including Parameters)<br> 
 * -  UserManagementHTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KyungBum Kim
 * @see UserManagementHTMLAction 참조
 * @since J2EE 1.4
 */

public class UserManagementEvent extends EventSupport {

	private static final long serialVersionUID = 1L;
	private Map<String, Object> voMap = new HashMap<String, Object>();
	
	/** com_user Table  Value Object */
	private ComUserVO comuservo = null;
	
	/** com_users Multi Action을 위한 Collection */
	private ComUserVO[] comuservos = null;

	private ComUsrPgmMtchVO[] comUsrPgmMtchVOs = null;
	
	/** 관리자 화면 여부  */
	private String adminPage = null;

	private String flg = null;
	private String usrId = null;
	
	public void setComuservo(ComUserVO comuservo) {
		this.comuservo = comuservo;
	}

	public void setComuservos(ComUserVO[] comuservos) {
		if(comuservos != null) {
			ComUserVO[] tmpVOs= Arrays.copyOf(comuservos, comuservos.length);
			this. comuservos = tmpVOs;
		}
	}

	public UserManagementEvent(){}

	public ComUserVO getComUserVO(){
		return comuservo;
	}

	public ComUserVO[] getComUserVOS(){
		ComUserVO[] rtnVOs = null;
		if(this.comuservos!= null) {
			rtnVOs=Arrays.copyOf(comuservos, comuservos.length);	
		}
		return rtnVOs;
	}

	public void setVO(String key, Object vo){
		voMap.put(key, vo);
	}

	
	public Object getVO(String key){
		return voMap.get(key);
	}

	public void setComUsrPgmMtchVOs(ComUsrPgmMtchVO[] comUsrPgmMtchVOs) {
		if(comUsrPgmMtchVOs != null) {
			ComUsrPgmMtchVO[] tmpVOs= Arrays.copyOf(comUsrPgmMtchVOs, comUsrPgmMtchVOs.length);
			this. comUsrPgmMtchVOs = tmpVOs;
		}
	}

	public ComUsrPgmMtchVO[] getComUsrPgmMtchVOs() {
		ComUsrPgmMtchVO[] rtnVOs = null;
		if(this.comUsrPgmMtchVOs!= null) {
			rtnVOs=Arrays.copyOf(comUsrPgmMtchVOs, comUsrPgmMtchVOs.length);	
		}
		return rtnVOs;
	}

	/**
	 * @param adminPage the adminPage to set
	 */
	public void setAdminPage(String adminPage) {
		this.adminPage = adminPage;
	}

	/**
	 * @return the adminPage
	 */
	public String getAdminPage() {
		return adminPage;
	}

	public String getFlg() {
		return flg;
	}

	public void setFlg(String flg) {
		this.flg = flg;
	}

	public String getUsrId() {
		return usrId;
	}

	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
}