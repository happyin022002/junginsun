/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : StatusHistoryMgtBC.java
*@FileTitle : StatusHistory
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.22
*@LastModifier : 김완규
*@LastVersion : 1.0
* 2009.09.22 김완규
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.generalmanage.statushistorymgt.basic;

import com.hanjin.apps.alps.ees.mnr.generalmanage.statushistorymgt.vo.StatusHistoryGRPVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
/**
 * alps-Generalmanage Business Logic Command Interface<br>
 * - alps-Generalmanage에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author WanGyu Kim
 * @see EventResponse 참조
 * @since J2EE 1.4
 */	
public interface StatusHistoryMgtBC {
	
	/**
	 * [EES_MNR_0098]Total Loss Request의 정보를 조회 합니다. <br>
	 *
	 * @param StatusHistoryGRPVO statusHistoryGRPVO
	 * @return StatusHistoryGRPVO
	 * @exception EventException
	 */
	public StatusHistoryGRPVO searchStatusHistoryBasic(StatusHistoryGRPVO statusHistoryGRPVO) throws EventException;

	/**
	 * [EES_MNR_0098]Total Loss Request의 정보를 추가/수정/삭제 합니다. <br>
	 *
	 * @param StatusHistoryGRPVO statusHistoryGRPVO
	 * @param SignOnUserAccount account
	 * @return StatusHistoryGRPVO
	 * @exception EventException
	 */
	public StatusHistoryGRPVO manageStatusHistorysBasic(StatusHistoryGRPVO statusHistoryGRPVO,SignOnUserAccount account) throws EventException;

	/**
	 * [EES_MNR_0098]Total Loss Request의  Ref No 관련 History 정보를 모두 삭제 합니다. <br>
	 *
	 * @param StatusHistoryGRPVO statusHistoryGRPVO
	 * @param SignOnUserAccount account
	 * @return StatusHistoryGRPVO
	 * @exception EventException
	 */
	public StatusHistoryGRPVO removeStatusHistorysAllBasic(StatusHistoryGRPVO statusHistoryGRPVO,SignOnUserAccount account) throws EventException;

}
