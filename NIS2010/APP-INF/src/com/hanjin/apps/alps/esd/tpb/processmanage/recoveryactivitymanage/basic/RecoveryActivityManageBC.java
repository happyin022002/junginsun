/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RecoveryActivitiManageBC.java
*@FileTitle : RecoveryActivitiManage
*Open Issues :
*Change history :
*@LastModifyDate : 2009-09-14
*@LastModifier : Jong-Geon Byeon
*@LastVersion : 1.1
* 2008-09-16 Kim Jin-seung		1.0	 최초 생성
* 2009-09-14 Jong-Geon Byeon	1.1 ALPS Migration
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.processmanage.recoveryactivitymanage.basic;

import java.util.List;

import com.hanjin.apps.alps.esd.tpb.processmanage.recoveryactivitymanage.vo.SearchRecoveryActivityListVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-RecoveryActivityManage Business Logic Command Interface<br>
 * - ALPS-RecoveryActivityManage에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author GUN-HA HWANG
 * @see Esd_tpb_105EventResponse 참조
 * @since J2EE 1.6
 */

public interface RecoveryActivityManageBC {
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SearchRecoveryActivityListVO searchRecoveryActivityListVO
	 * @return List<SearchRecoveryActivityListVO>
	 * @exception EventException
	 */
	public List<SearchRecoveryActivityListVO> searchRecoveryActivity(SearchRecoveryActivityListVO searchRecoveryActivityListVO) throws EventException;
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SearchRecoveryActivityListVO[] searchRecoveryActivityListVOs
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void multiRecoveryActivity(SearchRecoveryActivityListVO[] searchRecoveryActivityListVOs,SignOnUserAccount account) throws EventException;
}