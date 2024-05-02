/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FQAResultMgtBC.java
*@FileTitle : FQA Result Creation
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.ees.mnr.generalmanage.fqaresultmgt.basic;

import com.clt.apps.opus.ees.mnr.generalmanage.fqaresultmgt.vo.FQAResultMgtGRPVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * COM-Generalmanage Business Logic Command Interface<br>
 *
 * @author 
 * @see Ui_mnr_0029EventResponse reference
 * @since J2EE 1.4
 */

public interface FQAResultMgtBC {
	/**
	 * [EES_MNR_0223] retrieving FQA Result Detail Pop Up. <br>
	 *
	 * @param FQAResultMgtGRPVO fQAResultMgtGRPVO
	 * @return FQAResultMgtGRPVO
	 * @exception EventException
	 */
	public FQAResultMgtGRPVO searchFQAResultListBasic(FQAResultMgtGRPVO fQAResultMgtGRPVO) throws EventException;

	/**
	 * [EES_MNR_0029] adding/modification/deletion FQA Result Creation. <br>
	 *
	 * @param FQAResultMgtGRPVO fQAResultMgtGRPVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageFQAResultBasic(FQAResultMgtGRPVO fQAResultMgtGRPVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * [EES_MNR_0029] deleting FQA Result Creation. <br>
	 *
	 * @param FQAResultMgtGRPVO fQAResultMgtGRPVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void removeFQAResultBasic(FQAResultMgtGRPVO fQAResultMgtGRPVO,SignOnUserAccount account) throws EventException;

	/**
	 * [EES_MNR_0222] retrieving FQA Result Inquiry. <br>
	 *
	 * @param FQAResultMgtGRPVO fQAResultMgtGRPVO
	 * @return FQAResultMgtGRPVO
	 * @exception EventException
	 */
	public FQAResultMgtGRPVO searchFQAListBasic(FQAResultMgtGRPVO fQAResultMgtGRPVO) throws EventException;

}