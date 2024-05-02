/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RecoveryActivitiManageBC.java
*@FileTitle : RecoveryActivitiManage
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.tpb.processmanage.recoveryactivitymanage.basic;

import java.util.List;

import com.clt.apps.opus.esd.tpb.processmanage.recoveryactivitymanage.vo.SearchRecoveryActivityListVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * -RecoveryActivityManage Business Logic Command Interface<br>
 * - -RecoveryActivityManage business logic interface<br>
 *
 * @author 
 * @see Esd_tpb_105EventResponse reference
 * @since J2EE 1.6
 */

public interface RecoveryActivityManageBC {
	/**
	 * <br>
	 * 
	 * @param SearchRecoveryActivityListVO searchRecoveryActivityListVO
	 * @return List<SearchRecoveryActivityListVO>
	 * @exception EventException
	 */
	public List<SearchRecoveryActivityListVO> searchRecoveryActivity(SearchRecoveryActivityListVO searchRecoveryActivityListVO) throws EventException;
	/**
	 * <br>
	 * 
	 * @param SearchRecoveryActivityListVO[] searchRecoveryActivityListVOs
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void multiRecoveryActivity(SearchRecoveryActivityListVO[] searchRecoveryActivityListVOs,SignOnUserAccount account) throws EventException;
}