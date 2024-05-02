/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : HangerInventoryMgtBC.java
*@FileTitle : Hanger Bar Inventory List
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.ees.mnr.generalmanage.hangerinventorymgt.basic;

import com.clt.apps.opus.ees.mnr.generalmanage.hangerinventorymgt.vo.HangerInventoryListGRPVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * COM-GeneralManage Business Logic Basic Command implementation<br>
 * - COM-GeneralManage interface of business logic<br>
 *
 * @author SEONG DUK KYUNG
 * @see UI_MNR_0110EventResponse,HangerInventoryMgtBC, DAO Class
 * @since J2EE 1.4
 */
public interface HangerInventoryMgtBC {

	/**
	 * [EES_MNR_0110]Retrieving "Hanger Bar Inventory List" data<br>
	 *
	 * @param HangerInventoryListGRPVO hangerInventoryListGRPVO
	 * @param SignOnUserAccount account
	 * @return HangerInventoryListGRPVO
	 * @exception EventException
	 */
	public HangerInventoryListGRPVO searchHangerInventoryListBasic(HangerInventoryListGRPVO hangerInventoryListGRPVO, SignOnUserAccount account) throws EventException;

	/**
	 * [EES_MNR_0110]Adding, modifying, deleting "Hanger Bar Inventory List" data<br>
	 *
	 * @param HangerInventoryListGRPVO hangerInventoryListGRPVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageHangerInventoryBasic(HangerInventoryListGRPVO hangerInventoryListGRPVO, SignOnUserAccount account) throws EventException;

	/**
	 * [EES_MNR_0224]Retrieving "Hanger Bar Inventory History Pop Up" data<br>
	 *
	 * @param HangerInventoryListGRPVO hangerInventoryListGRPVO
	 * @param SignOnUserAccount account
	 * @return HangerInventoryListGRPVO
	 * @exception EventException
	 */
	public HangerInventoryListGRPVO searchHangerInventoryDetailListBasic(HangerInventoryListGRPVO hangerInventoryListGRPVO, SignOnUserAccount account) throws EventException;

	/**
	 * [EES_MNR_0058]Adding, modifying, deleting "Hanger Bar Inventory" data<br>
	 *
	 * @param HangerInventoryListGRPVO hangerInventoryListGRPVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageHangerInventoryEqStsBasic(HangerInventoryListGRPVO hangerInventoryListGRPVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * [EES_MNR_0019]Adding, modifying, deleting "Hanger Rack & Bar Installation/Removal" data<br>
	 * manageHangerRackBarManualInventoryBasic
	 * @param HangerInventoryListGRPVO hangerInventoryListGRPVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */				 				
	public void manageHangerRackBarManualInventoryBasic(HangerInventoryListGRPVO hangerInventoryListGRPVO, SignOnUserAccount account) throws EventException;
}