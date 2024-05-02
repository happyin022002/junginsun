/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TariffMgtBC.java
*@FileTitle : MNR Tariff No Inquiry_Pop Up
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.ees.mnr.agreementmanage.tariffmgt.basic;

import java.util.List;

import com.clt.apps.opus.ees.mnr.agreementmanage.tariffmgt.vo.DisposalTariffEffDtGRPVO;
import com.clt.apps.opus.ees.mnr.agreementmanage.tariffmgt.vo.DisposalTariffGRPVO;
import com.clt.apps.opus.ees.mnr.agreementmanage.tariffmgt.vo.DisposalTariffQuarterGRPVO;
import com.clt.apps.opus.ees.mnr.agreementmanage.tariffmgt.vo.DisposalTariffQuarterVO;
import com.clt.apps.opus.ees.mnr.agreementmanage.tariffmgt.vo.DisposalTariffRegionVO;
import com.clt.apps.opus.ees.mnr.agreementmanage.tariffmgt.vo.RepairTariffMgtGRPVO;
import com.clt.apps.opus.ees.mnr.agreementmanage.tariffmgt.vo.TariffApprovalGRPVO;
import com.clt.apps.opus.ees.mnr.agreementmanage.tariffmgt.vo.TariffPopupGRPVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * COM-Agreement manage Business Logic Command Interface<br>
 * - COM-Agreement manage interface of business logic<br>
 *
 * @author 
 * @see 	Ees_mnr_0188EventResponse
 * @since 	J2EE 1.6
 */

public interface TariffMgtBC {

	/**
	 * [EES_MNR_0188]Retrieving "M&R Tariff No Inquiry_Pop Up" data<br>
	 *
	 * @param TariffPopupGRPVO tariffPopupGRPVO
	 * @param SignOnUserAccount account
	 * @return TariffPopupGRPVO
	 * @exception EventException
	 */
	public TariffPopupGRPVO searchRepairTariffPopUpListBasic(TariffPopupGRPVO tariffPopupGRPVO, SignOnUserAccount account) throws EventException;

	/**
	 * [EES_MNR_0015]Retrieving "M&R Tariff No Combo List" data<br>
	 *
	 * @param TariffPopupGRPVO tariffPopupGRPVO
	 * @return TariffPopupGRPVO
	 * @exception EventException
	 */
	public TariffPopupGRPVO searchRepairTariffComboListBasic(TariffPopupGRPVO tariffPopupGRPVO) throws EventException;
	
	/**
	 * [EES_MNR_0215]Retrieving "Tariff Detail Information_Pop_Up" data<br>
	 *
	 * @param RepairTariffMgtGRPVO repairTariffMgtGRPVO
	 * @param SignOnUserAccount account
	 * @return RepairTariffMgtGRPVO
	 * @exception EventException
	 */
	public RepairTariffMgtGRPVO searchRepairTariffBasic(RepairTariffMgtGRPVO repairTariffMgtGRPVO,SignOnUserAccount account) throws EventException;
	
	/**
	 * [EES_MNR_0014]Adding, modifying, deleting "M&R Standard Tariff Creation & Inquiry" data<br>
	 *
	 * @param RepairTariffMgtGRPVO repairTariffMgtGRPVO
	 * @param SignOnUserAccount account
	 * @return RepairTariffMgtGRPVO
	 * @exception EventException
	 */
	public RepairTariffMgtGRPVO manageRepairTariffBasic(RepairTariffMgtGRPVO repairTariffMgtGRPVO,SignOnUserAccount account) throws EventException;

	/**
	 * [EES_MNR_0154]Retrieving "Disposal Tariff by Region" data<br>
	 *
	 * @param DisposalTariffGRPVO disposalTariffGRPVO
	 * @param SignOnUserAccount account
	 * @return DisposalTariffGRPVO
	 * @exception EventException
	 */
	public DisposalTariffGRPVO searchDisposalTariffBasic(DisposalTariffGRPVO disposalTariffGRPVO,SignOnUserAccount account) throws EventException;

	/**
	 * [EES_MNR_0232]Retrieving "Disposal Tariff by Region" data<br>
	 *
	 * @param DisposalTariffGRPVO disposalTariffGRPVO
	 * @param SignOnUserAccount account
	 * @return DisposalTariffGRPVO
	 * @exception EventException
	 */
	public DisposalTariffGRPVO searchDisposalTariffInqueryListBasic(DisposalTariffGRPVO disposalTariffGRPVO, SignOnUserAccount account) throws EventException;

	/**
	 * [EES_MNR_0154]Retrieving "Disposal Tariff by Region" data<br>
	 *
	 * @param DisposalTariffEffDtGRPVO disposalTariffEffDtGRPVO
	 * @param SignOnUserAccount account
	 * @return DisposalTariffEffDtGRPVO
	 * @exception EventException
	 */
	public DisposalTariffEffDtGRPVO searchDisposalTariffEffDtListBasic(DisposalTariffEffDtGRPVO disposalTariffEffDtGRPVO,SignOnUserAccount account) throws EventException;

	/**
	 * [EES_MNR_0232]Retrieving "Disposal Tariff by Region" data<br>
	 *
	 * @param DisposalTariffEffDtGRPVO disposalTariffEffDtGRPVO
	 * @param SignOnUserAccount account
	 * @return DisposalTariffEffDtGRPVO
	 * @exception EventException
	 */
	public DisposalTariffEffDtGRPVO searchDisposalTariffInqueryEffDtListBasic(DisposalTariffEffDtGRPVO disposalTariffEffDtGRPVO, SignOnUserAccount account) throws EventException;

	/**
	 * [EES_MNR_0154]Adding, modifying, deleting "Disposal Tariff by Region" data<br>
	 *
	 * @param DisposalTariffGRPVO disposalTariffGRPVO
	 * @param SignOnUserAccount account
	 * @return DisposalTariffGRPVO
	 * @exception EventException
	 */
	public DisposalTariffGRPVO manageDisposalTariffBasic(DisposalTariffGRPVO disposalTariffGRPVO,SignOnUserAccount account) throws EventException;

	/**
	 * [EES_MNR_0011]Retrieving "M&R Local Tariff Creation & Verify" data<br>
	 *
	 * @param RepairTariffMgtGRPVO repairTariffMgtGRPVO
	 * @param SignOnUserAccount account
	 * @return RepairTariffMgtGRPVO
	 * @exception EventException
	 */
	public RepairTariffMgtGRPVO searchDefaultRepairTariffDetailBasic(RepairTariffMgtGRPVO repairTariffMgtGRPVO,SignOnUserAccount account) throws EventException;

	/**
	 * [EES_MNR_0171]Retrieving "M&R Tariff Inquiry" data<br>
	 *
	 * @param TariffApprovalGRPVO tariffApprovalGRPVO
	 * @param SignOnUserAccount account
	 * @return TariffApprovalGRPVO
	 * @exception EventException
	 */
	public TariffApprovalGRPVO searchRepairTariffApprovalListBasic(TariffApprovalGRPVO tariffApprovalGRPVO,SignOnUserAccount account) throws EventException;

	/**
	 * [EES_MNR_0136]Modifying "M&R Regional Tariff Approval" data<br>
	 *
	 * @param TariffApprovalGRPVO tariffApprovalGRPVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyRepairTariffStatusBasic(TariffApprovalGRPVO tariffApprovalGRPVO,SignOnUserAccount account) throws EventException;

	/**
	 * [EES_MNR_0154]Retrieving quarterly price information<br>
	 *
	 * @param DisposalTariffRegionVO disposalTariffRegionVO
	 * @return List<DisposalTariffRegionVO>
	 * @exception EventException
	 */
	public List<DisposalTariffRegionVO> searchDisposalTariffRegionListBasic(DisposalTariffRegionVO disposalTariffRegionVO) throws EventException;

	/**
	 * [EES_MNR_0154]Modifying quarterly price information<br>
	 *
	 * @param DisposalTariffRegionVO[] disposalTariffRegionVOs
	 * @param SignOnUserAccount userAccount
	 * @exception EventException
	 */
	public void manageDisposalTariffRegionListBasic(DisposalTariffRegionVO[] disposalTariffRegionVOs, SignOnUserAccount userAccount) throws EventException;

	/**
	 * [EES_MNR_0154]Modifying batch quarterly price information<br>
	 *
	 * @param  DisposalTariffRegionVO[] disposalTariffRegionVOs
	 * @param  SignOnUserAccount userAccount
	 * @return String
	 * @throws EventException
	 */
	public String backEndDisposalTariffRegionListBasic(DisposalTariffRegionVO[] disposalTariffRegionVOs, SignOnUserAccount userAccount) throws EventException;

	/**
	 * Retrieving BackEndJob result<br>
	 *
	 * @param String key
	 * @return String
	 * @exception EventException
	 */
	public String searchComBackEndJobStatusBasic(String key) throws EventException;

	/**
	 * [EES_MNR_0232]Retrieving quarterly and regional price information<br>
	 *
	 * @param DisposalTariffQuarterVO disposalTariffQuarterVO
	 * @return DisposalTariffQuarterGRPVO
	 * @exception EventException
	 */
	public DisposalTariffQuarterGRPVO searchDisposalTariffQuarterListBasic(DisposalTariffQuarterVO disposalTariffQuarterVO) throws EventException;
}