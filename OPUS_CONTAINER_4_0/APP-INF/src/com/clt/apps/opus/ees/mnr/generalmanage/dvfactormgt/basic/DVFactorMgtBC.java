/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DVFactorMgtBC.java
*@FileTitle : DV Factor
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.ees.mnr.generalmanage.dvfactormgt.basic;

import com.clt.apps.opus.ees.mnr.generalmanage.dvfactormgt.vo.DVFactorGRPVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
  
/**
 * COM-Generalmanage Business Logic Command Interface<br>
 *
 * @author 
 * @see Ees_mnr_0107EventResponse reference
 * @since J2EE 1.4
 */

public interface DVFactorMgtBC { 
	/**
	 * [EES_MNR_0107]retrieving DV Factor list. <br>
	 *
	 * @param DVFactorGRPVO dVFactorGRPVO
	 * @return DVFactorGRPVO
	 * @exception EventException
	 */
	public DVFactorGRPVO searchDVFactorListBasic(DVFactorGRPVO dVFactorGRPVO) throws EventException;
	/**
	 * [EES_MNR_0107] adding/modification/deletion DV Factor. <br>
	 *
	 * @param DVFactorGRPVO dVFactorGRPVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */      
	public void manageDVFactorBasic(DVFactorGRPVO dVFactorGRPVO,SignOnUserAccount account) throws EventException;
	
} 