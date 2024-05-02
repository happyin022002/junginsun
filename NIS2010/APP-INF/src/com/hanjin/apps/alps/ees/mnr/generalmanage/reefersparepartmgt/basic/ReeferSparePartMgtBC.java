/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CEDEXCodeMgtBC.java
*@FileTitle : EQ Component
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.27
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2009.04.27 박명신
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.generalmanage.reefersparepartmgt.basic;

import java.util.List;

import com.hanjin.apps.alps.ees.mnr.generalmanage.reefersparepartmgt.vo.MnrVslSprPrtInvtVO;
import com.hanjin.apps.alps.ees.mnr.generalmanage.reefersparepartmgt.vo.RFSparePartCodeMgtGRPVO;
import com.hanjin.apps.alps.ees.mnr.generalmanage.reefersparepartmgt.vo.RFSparePartInventoryMgtGRPVO;
import com.hanjin.apps.alps.ees.mnr.generalmanage.reefersparepartmgt.vo.RFVessleSparePartCodeVO;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
  
/**
 * alps-Generalmanage Business Logic Command Interface<br>
 * - alps-Generalmanage에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @authorr 권영법
 * @see Ees_mnr_0009EventResponse 참조
 * @since J2EE 1.4
 */

public interface ReeferSparePartMgtBC { 
	/**
	 * [EES_MNR_0214]Vessel Reefer Spare Part Purchase W/O Creation의 정보를 조회 합니다. <br>
	 *
	 * @param RFSparePartCodeMgtGRPVO rfSparePartCodeMgtGRPVO
	 * @return RFSparePartCodeMgtGRPVO
	 * @exception EventException
	 */
	public RFSparePartCodeMgtGRPVO searchRFsparePartCodeListBasic(RFSparePartCodeMgtGRPVO rfSparePartCodeMgtGRPVO) throws EventException;
	/**
	 * [EES_MNR_0137]Standard Reefer Spare Parts List of the vsl의 정보를 추가/수정/삭제 합니다. <br>
	 *
	 * @param RFSparePartCodeMgtGRPVO rfSparePartCodeMgtGRPVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageRFsparePartCodeBasic(RFSparePartCodeMgtGRPVO rfSparePartCodeMgtGRPVO,SignOnUserAccount account) throws EventException;
	
	/**
	 * [EES_MNR_0056]VSL Reefer Spare part Inventory의 정보를 조회 합니다. <br>
	 *
	 * @param RFSparePartInventoryMgtGRPVO rfSparePartInventoryMgtGRPVO
	 * @return RFSparePartInventoryMgtGRPVO
	 * @exception EventException
	 */
	public RFSparePartInventoryMgtGRPVO searchRFSparePartInventoryListBasic(RFSparePartInventoryMgtGRPVO rfSparePartInventoryMgtGRPVO) throws EventException;
	/**
	 * [EES_MNR_0056]VSL Reefer Spare part Inventory의 정보를 추가/수정/삭제 합니다. <br>
	 *
	 * @param RFSparePartInventoryMgtGRPVO rfSparePartInventoryMgtGRPVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageRFSparePartInventoryBasic(RFSparePartInventoryMgtGRPVO rfSparePartInventoryMgtGRPVO,SignOnUserAccount account) throws EventException;
	
	/**
	 * [EES_MNR_0266]VSL Reefer Spare part Vessel Inventory의 정보를 조회 합니다. <br>
	 *
	 * @param RFVessleSparePartCodeVO rfVessleSparePartCodeVO
	 * @exception EventException
	 * @return List<RFVessleSparePartCodeVO>
	 */
	public List<RFVessleSparePartCodeVO> searchVesselSparePartCodeList(RFVessleSparePartCodeVO rfVessleSparePartCodeVO) throws EventException;
	/**
	 * [EES_MNR_0266]VSL Reefer Spare part Vessel Inventory의 정보를 추가/수정/삭제 합니다. <br>
	 * @param RFVessleSparePartCodeVO[] rfVessleSparePartCodeVOs
	 * @param RFVessleSparePartCodeVO rfVessleSparePartCodeVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageVslSprPrtCd(RFVessleSparePartCodeVO[] rfVessleSparePartCodeVOs, RFVessleSparePartCodeVO rfVessleSparePartCodeVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * [EES_MNR_0067]VSL Reffer Spare part Vessel Inventory Header 목록 조회 <br>
	 * @param rfVessleSparePartCodeVO
	 * @param account
	 * @return
	 */
	public List<MnrVslSprPrtInvtVO> searchVesselSparePartInventoryHeaderList(
			MnrVslSprPrtInvtVO mnrVslSprPrtInvtVO,
			SignOnUserAccount account) throws EventException;
	/**
	 * [EES_MNR_0268]Spare Part VSL Inventory Inquiry의 정보를 조회 합니다. <br>
	 *
	 * @param MnrVslSprPrtInvtVO mnrVslSprPrtInvtVO
	 * @return List<MnrVslSprPrtInvtVO>
	 * @exception EventException
	 */
	public List<MnrVslSprPrtInvtVO> searchVesselSparePartInventoryList(MnrVslSprPrtInvtVO mnrVslSprPrtInvtVO) throws EventException;
	
	/**
	 * [EES_MNR_0067]VSL Reefer Spare part Vessel Inventory의 정보를 조회 합니다. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchVesselInventoryList(Event e) throws EventException;
	
	/**
	 * [EES_MNR_0067]VSL Reefer Spare part Vessel Inventory 의 정보를 추가 합니다. <br>
	 * @param MnrVslSprPrtInvtVO[] mnrVslSprPrtInvtVOs
	 * @param MnrVslSprPrtInvtVO mnrVslSprPrtInvtVO
	 * @param account
	 * @return String
	 */
	public String manageVslInventoryCreation(
			MnrVslSprPrtInvtVO[] mnrVslSprPrtInvtVOs, MnrVslSprPrtInvtVO mnrVslSprPrtInvtVO, SignOnUserAccount account) throws EventException;
	/**
	 * [EES_MNR_0067]VSL Reefer Spare part Vessel Inventory 의 정보를 삭제 합니다. <br>
	 * @param MnrVslSprPrtInvtVO[] mnrVslSprPrtInvtVOs
	 * @param account
	 */
	public void removeVslInventoryCreation(
			MnrVslSprPrtInvtVO[] mnrVslSprPrtInvtVOs, SignOnUserAccount account) throws EventException;
	
	
	
} 