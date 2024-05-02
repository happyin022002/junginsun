/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PerformanceReportBC.java
*@FileTitle : Disposal PFMC by Region
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.ees.mnr.reportmanage.performancereport.basic;

import java.util.List;

import com.clt.apps.opus.ees.mnr.reportmanage.performancereport.vo.ACEPListGRPVO;
import com.clt.apps.opus.ees.mnr.reportmanage.performancereport.vo.DisposalPFMCByBuyerVO;
import com.clt.apps.opus.ees.mnr.reportmanage.performancereport.vo.DisposalPFMCByEqDetailVO;
import com.clt.apps.opus.ees.mnr.reportmanage.performancereport.vo.DisposalPFMCByMonthVO;
import com.clt.apps.opus.ees.mnr.reportmanage.performancereport.vo.DisposalPFMCByRCCVO;
import com.clt.apps.opus.ees.mnr.reportmanage.performancereport.vo.PMFCByAgreementTariffGRPVO;
import com.clt.apps.opus.ees.mnr.reportmanage.performancereport.vo.RepairPFMCByACCTINVO;
import com.clt.apps.opus.ees.mnr.reportmanage.performancereport.vo.RepairPFMCByACCTVO;
import com.clt.apps.opus.ees.mnr.reportmanage.performancereport.vo.RepairPFMCByESTINVO;
import com.clt.apps.opus.ees.mnr.reportmanage.performancereport.vo.RepairPFMCByESTVO;
import com.clt.apps.opus.ees.mnr.reportmanage.performancereport.vo.RepairPFMCByRepairCodeINVO;
import com.clt.apps.opus.ees.mnr.reportmanage.performancereport.vo.RepairPFMCByRepairCodeVO;
import com.clt.apps.opus.ees.mnr.reportmanage.performancereport.vo.RepairPFMCBySPINVO;
import com.clt.apps.opus.ees.mnr.reportmanage.performancereport.vo.RepairPFMCBySPVO;
import com.clt.apps.opus.ees.mnr.reportmanage.performancereport.vo.RepairPFMCByTSINVO;
import com.clt.apps.opus.ees.mnr.reportmanage.performancereport.vo.RepairPFMCByTSVO;
import com.clt.apps.opus.ees.mnr.reportmanage.performancereport.vo.RepairPFMCByWOINVO;
import com.clt.apps.opus.ees.mnr.reportmanage.performancereport.vo.RepairPFMCByWOVO;
import com.clt.apps.opus.ees.mnr.reportmanage.performancereport.vo.TirePurcharseByItemINVO;
import com.clt.apps.opus.ees.mnr.reportmanage.performancereport.vo.TirePurcharseByItemVO;
import com.clt.apps.opus.ees.mnr.reportmanage.performancereport.vo.TirePurcharseBySupplierINVO;
import com.clt.apps.opus.ees.mnr.reportmanage.performancereport.vo.TirePurcharseBySupplierVO;
import com.clt.apps.opus.ees.mnr.reportmanage.performancereport.vo.TireReplacementHistoryVO;
import com.clt.apps.opus.ees.mnr.reportmanage.performancereport.vo.TireReplacementINVO;
import com.clt.apps.opus.ees.mnr.reportmanage.performancereport.vo.TotalLossPerformanceINVO;
import com.clt.apps.opus.ees.mnr.reportmanage.performancereport.vo.TotalLossPerformanceVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * COM-Report manage Business Logic Command Interface<br>
 * - COM-Report manage interface of business logic<br>
 *
 * @author 
 * @see 	Ees_mnr_0166EventResponse
 * @since 	J2EE 1.6
 */

public interface PerformanceReportBC {
	
	/**
	 * [EES_MNR_0166]Retrieving "Disposal PFMC By Equipment Detail" data<br>
	 *
	 * @param DisposalPFMCByEqDetailVO disposalPFMCByEqDetailVO
	  * @return List<DisposalPFMCByEqDetailVO>
	 * @exception EventException
	 */	
	public List<DisposalPFMCByEqDetailVO> searchDisposalPFMCByEqDetailListBasic(DisposalPFMCByEqDetailVO disposalPFMCByEqDetailVO) throws EventException;
	
	/**
	 * Retrieving "Tire Replacement Report" data<br>
	 *
	 * @param TireReplacementINVO	tireReplacementINVO
	 * @param SignOnUserAccount account
	 * @return List<TireReplacementHistoryVO>
	 * @exception EventException
	 */
	public List<TireReplacementHistoryVO> searchTireReplacementListBasic(TireReplacementINVO tireReplacementINVO, SignOnUserAccount account) throws EventException;

	/**
	 * Retrieving "Tire Replacement History Report" data<br>
	 *
	 * @param TireReplacementINVO	tireReplacementINVO
	 * @param SignOnUserAccount account
	 * @return List<TireReplacementHistoryVO>
	 * @exception EventException
	 */
	public List<TireReplacementHistoryVO> searchTireReplacementHistoryListBasic(TireReplacementINVO tireReplacementINVO, SignOnUserAccount account) throws EventException;

	/**
	 * Retrieving "Tire Purchase Report" data by Item<br>
	 *
	 * @param TirePurcharseByItemINVO	tirePurcharseByItemINVO
	 * @param SignOnUserAccount account
	 * @return List<TirePurcharseByItemVO>
	 * @exception EventException
	 */
	public List<TirePurcharseByItemVO> searchTirePurchaseByItemListBasic(TirePurcharseByItemINVO tirePurcharseByItemINVO, SignOnUserAccount account) throws EventException;

	/**
	 * Retrieving "Tire Purchase Report" data by supplier<br>
	 *
	 * @param TirePurcharseBySupplierINVO	tirePurcharseBySupplierINVO
	 * @param SignOnUserAccount account
	 * @return List<TirePurcharseBySupplierVO>
	 * @exception EventException
	 */
	public List<TirePurcharseBySupplierVO> searchTirePurchaseBySupplierListBasic(TirePurcharseBySupplierINVO tirePurcharseBySupplierINVO, SignOnUserAccount account) throws EventException;

	/**
	 * Retrieving "Total Loss Payment" data by loss Report<br>
	 *
	 * @param TotalLossPerformanceINVO	totalLossPerformanceINVO
	 * @param SignOnUserAccount account
	 * @return List<TotalLossPerformanceVO>
	 * @exception EventException
	 */
	public List<TotalLossPerformanceVO> searchTotalLossPerformanceListBasic(TotalLossPerformanceINVO totalLossPerformanceINVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Retrieving PFMC by "Estimation Creation"<br>
	 *
	 * @param RepairPFMCByESTINVO	repairPFMCByESTINVO
	 * @return List<RepairPFMCByESTVO>
	 * @exception EventException
	 */
	public List<RepairPFMCByESTVO> searchRepairPFMCByESTListBasic(RepairPFMCByESTINVO repairPFMCByESTINVO) throws EventException;

	/**
	 * Retrieving PFMC by "Work Order"<br>
	 *
	 * @param RepairPFMCByWOINVO repairPFMCByWOINVO
	 * @return List<RepairPFMCByWOVO>
	 * @exception EventException
	 */
	public List<RepairPFMCByWOVO> searchRepairPFMCByWOListBasic(RepairPFMCByWOINVO repairPFMCByWOINVO) throws EventException;

	/**
	 * Retrieving PFMC by "AGMT TRIFF"<br>
	 *
	 * @param RepairPFMCByRepairCodeINVO	repairPFMCByRepairCodeINVO
	 * @return List<RepairPFMCByRepairCodeVO>
	 * @exception EventException
	 */
	public List<RepairPFMCByRepairCodeVO> searchRepairPFMCByRepairCodeListBasic(RepairPFMCByRepairCodeINVO repairPFMCByRepairCodeINVO) throws EventException;

	/**
	 * Retrieving PFMC by "Type/Size"<br>
	 *
	 * @param RepairPFMCByTSINVO	repairPFMCByTSINVO
	 * @return List<RepairPFMCByTSVO>
	 * @exception EventException
	 */
	public List<RepairPFMCByTSVO> searchRepairPFMCByTSListBasic(RepairPFMCByTSINVO repairPFMCByTSINVO) throws EventException;

	/**
	 * Retrieving PFMC by "VNDR/Manufacturer"<br>
	 *
	 * @param RepairPFMCBySPINVO	repairPFMCBySPINVO
	 * @return List<RepairPFMCBySPVO>
	 * @exception EventException
	 */
	public List<RepairPFMCBySPVO> searchRepairPFMCBySPListBasic(RepairPFMCBySPINVO repairPFMCBySPINVO) throws EventException;

	/**
	 *  [EES_MNR_0230] Retrieving "ACEP Candidate Cntr List" data<br>
	 *
	 * @param ACEPListGRPVO	aCEPListGRPVO
	 * @return ACEPListGRPVO aCEPListGRPVO
	 * @exception EventException
	 */
	public ACEPListGRPVO searchACEPListBasic(ACEPListGRPVO aCEPListGRPVO) throws EventException;

	/**
	 *  [EES_MNR_0236] Retrieving "MNR PFMC by Agreement/Tariff List" data<br>
	 *
	 * @param PMFCByAgreementTariffGRPVO pMFCByAgreementTariffGRPVO
	 * @return PMFCByAgreementTariffGRPVO pMFCByAgreementTariffGRPVO
	 * @exception EventException
	 */
	public PMFCByAgreementTariffGRPVO searchPMFCByAgreementTariffBasic(PMFCByAgreementTariffGRPVO pMFCByAgreementTariffGRPVO) throws EventException;

	/**
	 * EES_MNR_0237 : Retrieving "PFMC by Account/Cost Code List" data<br>
	 *
	 * @param RepairPFMCByACCTINVO	repairPFMCByACCTINVO
	 * @return List<RepairPFMCByACCTVO>
	 * @exception EventException
	 */
	public List<RepairPFMCByACCTVO> searchRepairPFMCByACCTListBasic(RepairPFMCByACCTINVO	repairPFMCByACCTINVO) throws EventException;

	/**
	 * [EES_MNR_0244]Retrieving sold performance of each regional(RCC/LCC/SCC)<br>
	 *
	 * @param DisposalPFMCByRCCVO disposalPFMCByRCCVO
	 * @return List<DisposalPFMCByRCCVO>
	 * @exception EventException
	 */
	public List<DisposalPFMCByRCCVO> searchDisposalPFMCByRCCListBasic(DisposalPFMCByRCCVO disposalPFMCByRCCVO) throws EventException;

	/**
	 * [EES_MNR_0245]Retrieving sold performance of monthly<br>
	 *
	 * @param DisposalPFMCByMonthVO disposalPFMCByMonthVO
	 * @return List<DisposalPFMCByMonthVO>
	 * @exception EventException
	 */
	public List<DisposalPFMCByMonthVO> searchDisposalPFMCByMonthListBasic(DisposalPFMCByMonthVO disposalPFMCByMonthVO) throws EventException;

	/**
	 * [EES_MNR_0246] Retrieving sold performance of Buyer<br>
	 *
	 * @param DisposalPFMCByBuyerVO disposalPFMCByBuyerVO
	 * @return List<DisposalPFMCByBuyerVO>
	 * @exception EventException
	 */
	public List<DisposalPFMCByBuyerVO> searchDisposalPFMCByBuyerListBasic(DisposalPFMCByBuyerVO disposalPFMCByBuyerVO) throws EventException;
}