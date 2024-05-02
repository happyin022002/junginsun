/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ReeferSparePartMgtBC.java
 *@FileTitle : ReeferSparePartMgtBC
 *Open Issues :
 *Change history :
 *@LastModifyDate :
 *@LastModifier :
 *@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.ees.mnr.generalmanage.reefersparepartmgt.basic;

import com.clt.apps.opus.ees.mnr.generalmanage.reefersparepartmgt.vo.RFSparePartCodeMgtGRPVO;
import com.clt.apps.opus.ees.mnr.generalmanage.reefersparepartmgt.vo.RFSparePartInventoryMgtGRPVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
  
/**
 * COM-Generalmanage Business Logic Command Interface<br>
 * - COM-Generalmanage - interface of business logic<br>
 *
 * @authorr
 * @see Ees_mnr_0009EventResponse
 * @since J2EE 1.4
 */

public interface ReeferSparePartMgtBC { 
	/**
	 * [EES_MNR_0214]Retrieving "Vessel Reefer Spare Part Purchase W/O Creation" data<br>
	 *
	 * @param RFSparePartCodeMgtGRPVO rfSparePartCodeMgtGRPVO
	 * @return RFSparePartCodeMgtGRPVO
	 * @exception EventException
	 */
	public RFSparePartCodeMgtGRPVO searchRFsparePartCodeListBasic(RFSparePartCodeMgtGRPVO rfSparePartCodeMgtGRPVO) throws EventException;

	/**
	 * [EES_MNR_0137]Adding, modifying, deleting "Standard Reefer Spare Parts List of the vsl" data<br>
	 *
	 * @param RFSparePartCodeMgtGRPVO rfSparePartCodeMgtGRPVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageRFsparePartCodeBasic(RFSparePartCodeMgtGRPVO rfSparePartCodeMgtGRPVO,SignOnUserAccount account) throws EventException;
	
	/**
	 * [EES_MNR_0056]Retrieving "VSL Reefer Spare part Inventory" data<br>
	 *
	 * @param RFSparePartInventoryMgtGRPVO rfSparePartInventoryMgtGRPVO
	 * @return RFSparePartInventoryMgtGRPVO
	 * @exception EventException
	 */
	public RFSparePartInventoryMgtGRPVO searchRFSparePartInventoryListBasic(RFSparePartInventoryMgtGRPVO rfSparePartInventoryMgtGRPVO) throws EventException;

	/**
	 * [EES_MNR_0056]Adding, modifying, deleting "VSL Reefer Spare part Inventory" data<br>
	 *
	 * @param RFSparePartInventoryMgtGRPVO rfSparePartInventoryMgtGRPVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageRFSparePartInventoryBasic(RFSparePartInventoryMgtGRPVO rfSparePartInventoryMgtGRPVO,SignOnUserAccount account) throws EventException;
} 