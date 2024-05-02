/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ExtraDisposalMgtBC.java
*@FileTitle : Scrapping/Donation Creation
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.ees.mnr.operationmanage.extradisposalmgt.basic;

import com.clt.apps.opus.ees.mnr.operationmanage.extradisposalmgt.vo.ExtraDisposalMgtGRPVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
/**
 * COM-Generalmanage Business Logic Command Interface<br>
 *
 * @author 
 * @see Ees_mnr_0093EventResponse reference
 * @since J2EE 1.4
 */	
public interface ExtraDisposalMgtBC {
	
	/**
	 * [EES_MNR_0093] retrieving Scrapping/Donation Creation. <br>
	 *
	 * @param ExtraDisposalMgtGRPVO extraDisposalMgtGRPVO
	 * @return ExtraDisposalMgtGRPVO
	 * @exception EventException
	 */
	public ExtraDisposalMgtGRPVO searchExtraDisposalByEQBasic(ExtraDisposalMgtGRPVO extraDisposalMgtGRPVO) throws EventException;
	
	/**
	 * [EES_MNR_0093] checking Scrapping/Donation Creation. <br>
	 *
	 * @param ExtraDisposalMgtGRPVO extraDisposalMgtGRPVO
	 * @return ExtraDisposalMgtGRPVO
	 * @exception EventException
	 */
	public ExtraDisposalMgtGRPVO checkExtraDisposalByEQBasic(ExtraDisposalMgtGRPVO extraDisposalMgtGRPVO) throws EventException;

	/**
	 * [EES_MNR_0093] adding/modification/deletion Scrapping/Donation Creation. <br>
	 *
	 * @param ExtraDisposalMgtGRPVO extraDisposalMgtGRPVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageExtraDisposalByEQBasic(ExtraDisposalMgtGRPVO extraDisposalMgtGRPVO, SignOnUserAccount account) throws EventException;

	/**
	 * [EES_MNR_0094] retrieving Scrapping/Donation Inquiry. <br>
	 *
	 * @param ExtraDisposalMgtGRPVO extraDisposalMgtGRPVO
	 * @param SignOnUserAccount account
	 * @return ExtraDisposalMgtGRPVO
	 * @exception EventException
	 */
	public ExtraDisposalMgtGRPVO searchExtraDisposalListBasic(ExtraDisposalMgtGRPVO extraDisposalMgtGRPVO, SignOnUserAccount account) throws EventException;

}
