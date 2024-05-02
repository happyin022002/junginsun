/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : HangerInventoryMgtBC.java
*@FileTitle : Hanger Bar Inventory List
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.15
*@LastModifier : 함형석
*@LastVersion : 1.0
* 2009.07.15 함형석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.generalmanage.hangerinventorymgt.basic;

import com.hanjin.apps.alps.ees.mnr.generalmanage.hangerinventorymgt.vo.HangerInventoryListGRPVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
  
/**
 * alps-GeneralManage Business Logic Basic Command implementation<br>
 * - alps-GeneralManage에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author SEONG DUK KYUNG
 * @see UI_MNR_0110EventResponse,HangerInventoryMgtBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public interface HangerInventoryMgtBC {

	/**
	 * [EES_MNR_0110]Hanger Bar Inventory List의 정보를 조회 합니다. <br>
	 *
	 * @param HangerInventoryListGRPVO hangerInventoryListGRPVO
	 * @param SignOnUserAccount account
	 * @return HangerInventoryListGRPVO
	 * @exception EventException
	 */
	public HangerInventoryListGRPVO searchHangerInventoryListBasic(HangerInventoryListGRPVO hangerInventoryListGRPVO, SignOnUserAccount account) throws EventException;
		
	/**
	 * [EES_MNR_0110]Hanger Bar Inventory List의 정보를 추가/수정/삭제 합니다. <br>
	 *
	 * @param HangerInventoryListGRPVO hangerInventoryListGRPVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageHangerInventoryBasic(HangerInventoryListGRPVO hangerInventoryListGRPVO, SignOnUserAccount account) throws EventException;

	/**
	 * [EES_MNR_0113]Hanger Bar Inventory List의 정보를 조회 합니다. <br>
	 *
	 * @param HangerInventoryListGRPVO hangerInventoryListGRPVO
	 * @param SignOnUserAccount account
	 * @return HangerInventoryListGRPVO
	 * @exception EventException
	 */
	public HangerInventoryListGRPVO searchNewHangerInventoryListBasic(HangerInventoryListGRPVO hangerInventoryListGRPVO, SignOnUserAccount account) throws EventException;
		
	/**
	 * [EES_MNR_0113]Hanger Bar Inventory List의 정보를 추가/수정/삭제 합니다. <br>
	 *
	 * @param HangerInventoryListGRPVO hangerInventoryListGRPVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageNewHangerInventoryBasic(HangerInventoryListGRPVO hangerInventoryListGRPVO, SignOnUserAccount account) throws EventException;

	/**
	 * [EES_MNR_0224]Hanger Bar Inventory History Pop Up의 정보를 조회 합니다. <br>
	 *
	 * @param HangerInventoryListGRPVO hangerInventoryListGRPVO
	 * @param SignOnUserAccount account
	 * @return HangerInventoryListGRPVO
	 * @exception EventException
	 */
	public HangerInventoryListGRPVO searchHangerInventoryDetailListBasic(HangerInventoryListGRPVO hangerInventoryListGRPVO, SignOnUserAccount account) throws EventException;

	/**
	 * [EES_MNR_0058]Hanger Bar Inventory의 정보를 추가/수정 합니다. <br>
	 *
	 * @param HangerInventoryListGRPVO hangerInventoryListGRPVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */ 
	public void manageHangerInventoryEqStsBasic(HangerInventoryListGRPVO hangerInventoryListGRPVO, SignOnUserAccount account) throws EventException;
	
	
	/**
	 * [EES_MNR_0019] Hanger Rack & Bar Installation/Removal 의 정보를 추가/수정 합니다. <br>
	 * manageHangerRackBarManualInventoryBasic
	 * @param HangerInventoryListGRPVO hangerInventoryListGRPVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */				 				
	public void manageHangerRackBarManualInventoryBasic(HangerInventoryListGRPVO hangerInventoryListGRPVO, SignOnUserAccount account) throws EventException;
}               













