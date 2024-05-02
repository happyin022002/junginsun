/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : StatusHistoryMgtBC.java
*@FileTitle : StatusHistory
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.ees.mnr.generalmanage.statushistorymgt.basic;

import com.clt.apps.opus.ees.mnr.generalmanage.statushistorymgt.vo.StatusHistoryGRPVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.view.signon.SignOnUserAccount;
/**
 * COM-Generalmanage Business Logic Command Interface<br>
 *
 * @author 
 * @see EventResponse reference
 * @since J2EE 1.4
 */	
public interface StatusHistoryMgtBC {
	
	/**
	 * [EES_MNR_0098] retrieving Total Loss Request. <br>
	 *
	 * @param StatusHistoryGRPVO statusHistoryGRPVO
	 * @return StatusHistoryGRPVO
	 * @exception EventException
	 */
	public StatusHistoryGRPVO searchStatusHistoryBasic(StatusHistoryGRPVO statusHistoryGRPVO) throws EventException;

	/**
	 * [EES_MNR_0098] adding/modification/deletion Total Loss Request. <br>
	 *
	 * @param StatusHistoryGRPVO statusHistoryGRPVO
	 * @param SignOnUserAccount account
	 * @return StatusHistoryGRPVO
	 * @exception EventException
	 */
	public StatusHistoryGRPVO manageStatusHistorysBasic(StatusHistoryGRPVO statusHistoryGRPVO,SignOnUserAccount account) throws EventException;

	/**
	 * [EES_MNR_0098] deleting Ref No History of Total Loss Request. <br>
	 *
	 * @param StatusHistoryGRPVO statusHistoryGRPVO
	 * @param SignOnUserAccount account
	 * @return StatusHistoryGRPVO
	 * @exception EventException
	 */
	public StatusHistoryGRPVO removeStatusHistorysAllBasic(StatusHistoryGRPVO statusHistoryGRPVO,SignOnUserAccount account) throws EventException;

}
