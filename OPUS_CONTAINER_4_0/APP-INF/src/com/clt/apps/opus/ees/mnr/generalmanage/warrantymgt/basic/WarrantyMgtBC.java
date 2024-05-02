/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : WarrantyMgtBC.java
*@FileTitle :WarrantyMgtBC
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.ees.mnr.generalmanage.warrantymgt.basic;

import com.clt.apps.opus.ees.mnr.generalmanage.warrantymgt.vo.WarrantyAlertInfoGRPVO;
import com.clt.apps.opus.ees.mnr.generalmanage.warrantymgt.vo.WarrantyAlertListGRPVO;
import com.clt.framework.core.layer.event.EventException;
   
/**
 * COM-Generalmanage Business Logic Command Interface<br>
 *
 * @author 
 * @see Ees_mnr_0213EventResponse reference
 * @see Ees_mnr_0170EventResponse reference
 * @since J2EE 1.4
 */

public interface WarrantyMgtBC {  
	/**
	 * [EES_MNR_0213] retrieving Warranty Alert_Pop Up. <br>
	 *
	 * @param WarrantyAlertInfoGRPVO warrantyAlertInfoGRPVO
	 * @return WarrantyAlertInfoGRPVO
	 * @exception EventException
	 */
	public WarrantyAlertInfoGRPVO searchWarrantyAlertInfoBasic(WarrantyAlertInfoGRPVO warrantyAlertInfoGRPVO) throws EventException;
	
	/**
	 * [EES_MNR_0170] retrieving Reefer Unit Warranty Period. <br>
	 *
	 * @param WarrantyAlertListGRPVO warrantyAlertListGRPVO
	 * @return WarrantyAlertListGRPVO
	 * @exception EventException
	 */
	public WarrantyAlertListGRPVO searchWarrantyAlertListBasic(WarrantyAlertListGRPVO warrantyAlertListGRPVO) throws EventException;
	         
	
} 