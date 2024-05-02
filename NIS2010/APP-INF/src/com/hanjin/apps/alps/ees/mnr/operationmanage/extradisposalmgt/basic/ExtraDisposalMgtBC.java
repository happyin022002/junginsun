/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ExtraDisposalMgtBC.java
*@FileTitle : Scrapping/Donation Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.07
*@LastModifier : 김완규
*@LastVersion : 1.0
* 2009.09.07 김완규
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.operationmanage.extradisposalmgt.basic;

import com.hanjin.apps.alps.ees.mnr.operationmanage.extradisposalmgt.vo.ExtraDisposalMgtGRPVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
/**
 * alps-Generalmanage Business Logic Command Interface<br>
 * - alps-Generalmanage에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author WanGyu Kim
 * @see Ees_mnr_0093EventResponse 참조
 * @since J2EE 1.4
 */	
public interface ExtraDisposalMgtBC {
	
	/**
	 * [EES_MNR_0093]Scrapping/Donation Creation의 정보를 조회 합니다. <br>
	 *
	 * @param ExtraDisposalMgtGRPVO extraDisposalMgtGRPVO
	 * @return ExtraDisposalMgtGRPVO
	 * @exception EventException
	 */
	public ExtraDisposalMgtGRPVO searchExtraDisposalByEQBasic(ExtraDisposalMgtGRPVO extraDisposalMgtGRPVO) throws EventException;
	
	/**
	 * [EES_MNR_0093]Scrapping/Donation Creation의 정보를 체크 합니다. <br>
	 *
	 * @param ExtraDisposalMgtGRPVO extraDisposalMgtGRPVO
	 * @return ExtraDisposalMgtGRPVO
	 * @exception EventException
	 */
	public ExtraDisposalMgtGRPVO checkExtraDisposalByEQBasic(ExtraDisposalMgtGRPVO extraDisposalMgtGRPVO) throws EventException;

	/**
	 * [EES_MNR_0093]Scrapping/Donation Creation의 정보를 추가/수정/삭제 합니다. <br>
	 *
	 * @param ExtraDisposalMgtGRPVO extraDisposalMgtGRPVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageExtraDisposalByEQBasic(ExtraDisposalMgtGRPVO extraDisposalMgtGRPVO, SignOnUserAccount account) throws EventException;

	/**
	 * [EES_MNR_0094]Scrapping/Donation Inquiry의 정보를 조회 합니다. <br>
	 *
	 * @param ExtraDisposalMgtGRPVO extraDisposalMgtGRPVO
	 * @param SignOnUserAccount account
	 * @return ExtraDisposalMgtGRPVO
	 * @exception EventException
	 */
	public ExtraDisposalMgtGRPVO searchExtraDisposalListBasic(ExtraDisposalMgtGRPVO extraDisposalMgtGRPVO, SignOnUserAccount account) throws EventException;

}
