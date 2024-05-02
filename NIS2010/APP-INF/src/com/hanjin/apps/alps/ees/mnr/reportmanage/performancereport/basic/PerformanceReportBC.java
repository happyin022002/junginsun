/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PerformanceReportBC.java
*@FileTitle : Disposal PFMC by Region
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.28
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2009.09.28 민정호
* 1.0 Creation
* =======================================================
* 2010.11.30 남궁진호 [CHM-201007327-01] Disposal Performance를 장비별 Detail 내역 조회 추가
*            searchDisposalPFMCByEqDetailListBasic
* 2010.12.06 남궁진호 [CHM-201007441-01]Disposal Result Equipment list 팝업 신규개발             
* 2011.03.02 김영오 [CHM-201108369] M&R PFMC by Eq No  신규화면 개발에 따른 매소드 추가 
* 			 searchPFMCByEqNoListBasic, searchComBackEndJobEqNoListStatusBasic
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.basic;

import java.util.List;

import com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.vo.ACEPListGRPVO;
import com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.vo.DisposalPFMCByBuyerVO;
import com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.vo.DisposalPFMCByEQGRPVO;
import com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.vo.DisposalPFMCByEQListVO;
import com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.vo.DisposalPFMCByEQVO;
import com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.vo.DisposalPFMCByEqDetailVO;
import com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.vo.DisposalPFMCByMonthVO;
import com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.vo.DisposalPFMCByOfficeVO;
import com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.vo.DisposalPFMCByRCCVO;
import com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.vo.DisposalPFMCByRegionGRPVO;
import com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.vo.DisposalResultEquipmentVO;
import com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.vo.PMFCByAgreementTariffGRPVO;
import com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.vo.RepairExpensePFMCINVO;
import com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.vo.RepairExpensePFMCRPTVO;
import com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.vo.RepairPFMCByACCTINVO;
import com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.vo.RepairPFMCByACCTVO;
import com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.vo.RepairPFMCByESTINVO;
import com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.vo.RepairPFMCByESTVO;
import com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.vo.RepairPFMCByEqNoINVO;
import com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.vo.RepairPFMCByRepairCodeINVO;
import com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.vo.RepairPFMCByRepairCodeVO;
import com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.vo.RepairPFMCBySPINVO;
import com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.vo.RepairPFMCBySPVO;
import com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.vo.RepairPFMCByTSINVO;
import com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.vo.RepairPFMCByTSVO;
import com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.vo.RepairPFMCByWOINVO;
import com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.vo.RepairPFMCByWOVO;
import com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.vo.SearchFoodQualityDetailKeyINVO;
import com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.vo.SearchFoodQualityDetailKeyVO;
import com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.vo.TirePurcharseByItemINVO;
import com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.vo.TirePurcharseByItemVO;
import com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.vo.TirePurcharseBySupplierINVO;
import com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.vo.TirePurcharseBySupplierVO;
import com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.vo.TireReplacementHistoryVO;
import com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.vo.TireReplacementINVO;
import com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.vo.TotalLossPerformanceINVO;
import com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.vo.TotalLossPerformanceVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.EqrCtrlDchgGlineValVO;

/**
 * ALPS-Reportmanage Business Logic Command Interface<br>
 * - ALPS-Reportmanage에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Jung Ho Min
 * @see Ees_mnr_0166EventResponse
 * @since J2EE 1.6
 */

public interface PerformanceReportBC {

	/**
	 * Region에 의한 Disposal PFMC를 조회합니다.<br>
	 *
	 * @param DisposalPFMCByRegionGRPVO	disposalPFMCByRegionGRPVO
	 * @return List<DisposalPFMCByEQGRPVO>
	 * @exception EventException
	 */
	public List<DisposalPFMCByEQGRPVO> searchDisposalPFMCByRegionListBasic(DisposalPFMCByRegionGRPVO disposalPFMCByRegionGRPVO) throws EventException;

	/**
	 * EQ에 의한 Disposal PFMC를 조회합니다.<br>
	 *
	 * @param DisposalPFMCByEQVO	disposalPFMCByEQVO
	 * @return List<DisposalPFMCByEQListVO>
	 * @exception EventException
	 */
	public List<DisposalPFMCByEQListVO> searchDisposalPFMCByEQListBasic(DisposalPFMCByEQVO disposalPFMCByEQVO) throws EventException;

	/**
	 * Tire Replacement Report 를 조회합니다.<br>
	 *
	 * @param TireReplacementINVO	tireReplacementINVO
	 * @param SignOnUserAccount account
	 * @return List<TireReplacementHistoryVO>
	 * @exception EventException
	 */
	public List<TireReplacementHistoryVO> searchTireReplacementListBasic(TireReplacementINVO tireReplacementINVO, SignOnUserAccount account) throws EventException;

	/**
	 * Tire Replacement History Report 를 조회합니다.<br>
	 *
	 * @param TireReplacementINVO	tireReplacementINVO
	 * @param SignOnUserAccount account
	 * @return List<TireReplacementHistoryVO>
	 * @exception EventException
	 */
	public List<TireReplacementHistoryVO> searchTireReplacementHistoryListBasic(TireReplacementINVO tireReplacementINVO, SignOnUserAccount account) throws EventException;

	/**
	 * Item에 의한 Tire Purchase Report를 조회합니다.<br>
	 *
	 * @param TirePurcharseByItemINVO	tirePurcharseByItemINVO
	 * @param SignOnUserAccount account
	 * @return List<TirePurcharseByItemVO>
	 * @exception EventException
	 */
	public List<TirePurcharseByItemVO> searchTirePurchaseByItemListBasic(TirePurcharseByItemINVO tirePurcharseByItemINVO, SignOnUserAccount account) throws EventException;

	/**
	 * Supplier에 의한 Tire Purchase Report 를 조회합니다.<br>
	 *
	 * @param TirePurcharseBySupplierINVO	tirePurcharseBySupplierINVO
	 * @param SignOnUserAccount account
	 * @return List<TirePurcharseBySupplierVO>
	 * @exception EventException
	 */
	public List<TirePurcharseBySupplierVO> searchTirePurchaseBySupplierListBasic(TirePurcharseBySupplierINVO tirePurcharseBySupplierINVO, SignOnUserAccount account) throws EventException;

	/**
	 * Lessor Report에 의한 Total Loss Payment 를 조회합니다.<br>
	 *
	 * @param TotalLossPerformanceINVO	totalLossPerformanceINVO
	 * @param SignOnUserAccount account
	 * @return List<TotalLossPerformanceVO>
	 * @exception EventException
	 */
	public List<TotalLossPerformanceVO> searchTotalLossPerformanceListBasic(TotalLossPerformanceINVO totalLossPerformanceINVO, SignOnUserAccount account) throws EventException;

	/**
	 * HO에 의한 Expense Plan and PFMC를 조회 합니다.<br>
	 *
	 * @param RepairExpensePFMCINVO	repairExpensePFMCINVO
	 * @param SignOnUserAccount account
	 * @return List<RepairExpensePFMCRPTVO>
	 * @exception EventException
	 */
	public List<RepairExpensePFMCRPTVO> searchRepairExpensePFMCListBasic(RepairExpensePFMCINVO repairExpensePFMCINVO, SignOnUserAccount account) throws EventException;

	/**
	 * Estimation Creation에 의한 MNR PFMC를 조회합니다.<br>
	 *
	 * @param RepairPFMCByESTINVO	repairPFMCByESTINVO
	 * @return List<RepairPFMCByESTVO>
	 * @exception EventException
	 */
	public List<RepairPFMCByESTVO> searchRepairPFMCByESTListBasic(RepairPFMCByESTINVO repairPFMCByESTINVO) throws EventException;

	/**
	 * Work Order에 의한 MNR PFMC를 조회합니다.<br>
	 *
	 * @param RepairPFMCByWOINVO repairPFMCByWOINVO
	 * @return List<RepairPFMCByWOVO>
	 * @exception EventException
	 */
	public List<RepairPFMCByWOVO> searchRepairPFMCByWOListBasic(RepairPFMCByWOINVO repairPFMCByWOINVO) throws EventException;


	/**
	 * AGMT TRIFF에 의한MNR PFMC를 조회합니다.<br>
	 *
	 * @param RepairPFMCByRepairCodeINVO	repairPFMCByRepairCodeINVO
	 * @return List<RepairPFMCByRepairCodeVO>
	 * @exception EventException
	 */
	public List<RepairPFMCByRepairCodeVO> searchRepairPFMCByRepairCodeListBasic(RepairPFMCByRepairCodeINVO repairPFMCByRepairCodeINVO) throws EventException;
	
	/**
	 * PFMC by CEDEX Code에 의한 Damge FQ에 대한 장비 단껀 Detail을 조회합니다.<br>
	 *
	 * @param SearchFoodQualityDetailKeyINVO searchFoodQualityDetailKeyINVO
	 * @return List<SearchFoodQualityDetailKeyVO>
	 * @exception EventException
	 */
	public List<SearchFoodQualityDetailKeyVO> searchFoodQualityDetailKey(SearchFoodQualityDetailKeyINVO searchFoodQualityDetailKeyINVO) throws EventException;
	/**
	 * PFMC by CEDEX Code에 의한 Damge FQ에 대한 장비 Detail목록을 조회합니다.<br>
	 *
	 * @param List<SearchFoodQualityDetailKeyINVO>  searchFoodQualityDetailKeyINVO
	 * @return List<SearchFoodQualityDetailKeyVO>
	 * @exception EventException
	 */
	public List<SearchFoodQualityDetailKeyVO> searchFoodQualityDetailMulti(List<SearchFoodQualityDetailKeyINVO>  searchFoodQualityDetailKeyINVO) throws EventException;

	/**
	 * Type/Size에 의한 MNR PFMC을 조회 합니다.<br>
	 *
	 * @param RepairPFMCByTSINVO	repairPFMCByTSINVO
	 * @return List<RepairPFMCByTSVO>
	 * @exception EventException
	 */
	public List<RepairPFMCByTSVO> searchRepairPFMCByTSListBasic(RepairPFMCByTSINVO repairPFMCByTSINVO) throws EventException;


	/**
	 *  VNDR/Manufacturer에 의한 MNR PFMC을 조회 합니다.<br>
	 *
	 * @param RepairPFMCBySPINVO	repairPFMCBySPINVO
	 * @return List<RepairPFMCBySPVO>
	 * @exception EventException
	 */
	public List<RepairPFMCBySPVO> searchRepairPFMCBySPListBasic(RepairPFMCBySPINVO repairPFMCBySPINVO) throws EventException;


	/**
	 *  [EES_MNR_0230] ACEP Candidate Cntr List을 조회 합니다.<br>
	 *
	 * @param ACEPListGRPVO	aCEPListGRPVO
	 * @return ACEPListGRPVO aCEPListGRPVO
	 * @exception EventException
	 */
	public ACEPListGRPVO searchACEPListBasic(ACEPListGRPVO aCEPListGRPVO) throws EventException;

	/**
	 *  [EES_MNR_0236] MNR PFMC by Agreement/Tariff List을 조회 합니다.<br>
	 *
	 * @param PMFCByAgreementTariffGRPVO pMFCByAgreementTariffGRPVO
	 * @return PMFCByAgreementTariffGRPVO pMFCByAgreementTariffGRPVO
	 * @exception EventException
	 */
	public PMFCByAgreementTariffGRPVO searchPMFCByAgreementTariffBasic(PMFCByAgreementTariffGRPVO pMFCByAgreementTariffGRPVO) throws EventException;

	/**
	 * EES_MNR_0237 : Retrieve<br>
	 * PFMC by Account/Cost Code List를 조회합니다.<br>
	 *
	 * @param RepairPFMCByACCTINVO	repairPFMCByACCTINVO
	 * @return List<RepairPFMCByACCTVO>
	 * @exception EventException
	 */
	public List<RepairPFMCByACCTVO> searchRepairPFMCByACCTListBasic(RepairPFMCByACCTINVO	repairPFMCByACCTINVO) throws EventException;

	/**
	 * [EES_MNR_0244] RCC/LCC/SCC 지역별 매각실적 현황목록을 조회합니다. <br>
	 *
	 * @param DisposalPFMCByRCCVO disposalPFMCByRCCVO
	 * @return List<DisposalPFMCByRCCVO>
	 * @exception EventException
	 */
	public List<DisposalPFMCByRCCVO> searchDisposalPFMCByRCCListBasic(DisposalPFMCByRCCVO disposalPFMCByRCCVO) throws EventException;

	/**
	 * [EES_MNR_0245] 월별 매각실적 현황목록을 조회합니다. <br>
	 *
	 * @param DisposalPFMCByMonthVO disposalPFMCByMonthVO
	 * @return List<DisposalPFMCByMonthVO>
	 * @exception EventException
	 */
	public List<DisposalPFMCByMonthVO> searchDisposalPFMCByMonthListBasic(DisposalPFMCByMonthVO disposalPFMCByMonthVO) throws EventException;

	/**
	 * EES_MNR_0115 : COMMAND01<br>
	 * Expense Plan and PFMC를 조회합니다. <br>
	 *
	 * @param  RepairExpensePFMCINVO repairExpensePFMCINVO
	 * @param  SignOnUserAccount account
	 * @return String
	 * @throws EventException
	 */
	public String searchBackEndExpensePFMCListBasic(RepairExpensePFMCINVO repairExpensePFMCINVO, SignOnUserAccount account) throws EventException;

	/**
	 * EES_MNR_0115 : COMMAND02<br>
	 * BackEndJob의 실행결과에 대한 상태값을 조회합니다.<br>
	 *
	 * @param String key
	 * @return String
	 * @exception EventException
	 */
	public String searchComBackEndJobStatusBasic(String key) throws EventException;

	/**
	 * [EES_MNR_0165] Office별 계획대비 매각실적 현황목록을 조회합니다. <br>
	 *
	 * @param DisposalPFMCByOfficeVO disposalPFMCByOfficeVO
	 * @return List<DisposalPFMCByMonthVO>
	 * @exception EventException
	 */
	public List<DisposalPFMCByOfficeVO> searchDisposalPFMCByOfficeListBasic(DisposalPFMCByOfficeVO disposalPFMCByOfficeVO) throws EventException;

	/**
	 * [EES_MNR_0246] Buyer별 매각실적 현황목록을 조회합니다. <br>
	 *
	 * @param DisposalPFMCByBuyerVO disposalPFMCByBuyerVO
	 * @return List<DisposalPFMCByBuyerVO>
	 * @exception EventException
	 */
	public List<DisposalPFMCByBuyerVO> searchDisposalPFMCByBuyerListBasic(DisposalPFMCByBuyerVO disposalPFMCByBuyerVO) throws EventException;

	/**
	 * [EES_MNR_0166] 장비별 매각실적 상세정보를 조회합니다. <br>
	 *
	 * @param DisposalPFMCByEqDetailVO disposalPFMCByEqDetailVO
	  * @return List<DisposalPFMCByEqDetailVO>
	 * @exception EventException
	 */
	public List<DisposalPFMCByEqDetailVO> searchDisposalPFMCByEqDetailListBasic(DisposalPFMCByEqDetailVO disposalPFMCByEqDetailVO) throws EventException;

	/**
	 * [EES_MNR_0247] 장비별 매각실적 상세결과 정보를 조회합니다. <br>
	 *
	 * @param DisposalResultEquipmentVO disposalResultEquipmentVO
	  * @return List<DisposalResultEquipmentVO>
	 * @exception EventException
	 */
	public List<DisposalResultEquipmentVO> searchDisposalResultEquipmentListBasic(DisposalResultEquipmentVO disposalResultEquipmentVO) throws EventException;
	
	/**
	 * [EES_MNR_0248] M&R PFMC by PFMC by EQ No에 의한 PFMC by EQ No를 조회합니다.<br>
	 *
	 * @param RepairPFMCByEqNoINVO	repairPFMCByEqNoINVO
	 * @param SignOnUserAccount account
	 * @return String 
	 * @exception EventException
	 */
	public String searchPFMCByEqNoListBasic(RepairPFMCByEqNoINVO repairPFMCByEqNoINVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * EES_MNR_0248 : COMMAND02<br>
	 * BackEndJob의 실행결과에 대한 상태값을 조회합니다.<br>
	 *
	 * @param String key
	 * @return String
	 * @exception EventException
	 */
	public String searchComBackEndJobEqNoListStatusBasic(String key) throws EventException;
	
	/**
	 * Estimation Creation에 의한 MNR PFMC를 조회합니다.<br>
	 *
	 * @param RepairPFMCByESTINVO repairPFMCByESTINVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */		
	public String searchRepairPFMCByESTListBasic(RepairPFMCByESTINVO repairPFMCByESTINVO, SignOnUserAccount account) throws EventException;

}