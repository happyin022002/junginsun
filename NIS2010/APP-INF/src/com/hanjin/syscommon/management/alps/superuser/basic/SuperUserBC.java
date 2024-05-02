/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SuperUserBC.java
*@FileTitle : SuperUser Management
*Open Issues :
*Change history :
*@LastModifyDate : 2009.02.17
*@LastModifier : 김경범
*@LastVersion : 1.0
* 2009.02.17 김경범
* 1.0 Creation
=========================================================*/
package com.hanjin.syscommon.management.alps.superuser.basic;

import java.util.HashMap;
import java.util.List;

import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.ComUsrPgmMtchVO;
import com.hanjin.syscommon.management.alps.superuser.vo.SuperUserVO;


/**
 * NIS2010-SuperUsermanagement Business Logic Command Interface<br>
 * - NIS2010-SuperUsermanagement에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author KyungBum Kim
 * @see SuperUsermanagementEventResponse 참조
 * @since J2EE 1.4
 */

public interface SuperUserBC {

	/**
	 * 조회 이벤트 처리<br>
	 * 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @return String[]
	 * @exception EventException
	 */
	public String[] searchSubSystemList() throws EventException ;
	/**
	 * 조회 이벤트 처리<br>
	 * SuperUser화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param HashMap<String, String> param
	 * @return List<SuperUserVO>
	 * @exception EventException
	 */
	public List<SuperUserVO> searchSuperUserList(HashMap<String, String> param) throws EventException;
	/**
	 * 멀티 이벤트 처리<br>
	 * SuperUser 화면에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param SuperUserVO[] ComUsrPgmMtchVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void multiComSuperUserVO(SuperUserVO[] ComUsrPgmMtchVO, SignOnUserAccount account) throws EventException;
}