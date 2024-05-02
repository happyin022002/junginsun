/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SurchargeGroupLocationBC.java
*@FileTitle : Surcharge Location Group Creation
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.pri.surcharge.surchargegrouplocation.basic;

import com.clt.apps.opus.esm.pri.surcharge.surchargegrouplocation.vo.SurchargeGroupLocationVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * Surcharge Business Logic Command Interface<br>
 * - Handling a biz logic about Surcharge<br>
 *
 * @author 
 * @see Esm_pri_4004EventResponse 
 * @since J2EE 1.4
 */

public interface SurchargeGroupLocationBC {
	/**
	 * Retrieving surcharge group location<br>
	 * 
	 * @param SurchargeGroupLocationVO surchargeGroupLocation
	 * @return SurchargeGroupLocationVO
	 * @exception EventException
	 */
	public SurchargeGroupLocationVO searchGroupLocationList(SurchargeGroupLocationVO surchargeGroupLocation) throws EventException;
	
	/**
	 * Managing group location<br>
	 * 
	 * @param SurchargeGroupLocationVO surchargeGroupLocation
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageGroupLocation(SurchargeGroupLocationVO surchargeGroupLocation, SignOnUserAccount account) throws EventException;
}