/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PerformanceReportBCImpl.java
*@FileTitle : Disposal PFMC by Region
*Open Issues :
*Change history :
*@LastModifyDate : 2013.05.30
*@LastModifier : 조경완
*@LastVersion : 1.0
* 2009.09.28 민정호
* 1.0 Creation
* =======================================================
* 2010.11.30 남궁진호 [CHM-201007327-01] Disposal Performance를 장비별 Detail 내역 조회 추가
*            searchDisposalPFMCByEqDetailListBasic
* 2010.12.06 남궁진호 [CHM-201007441-01]Disposal Result Equipment list 팝업 신규개발     
* 2011.03.02 김영오 [CHM-201108369] M&R PFMC by Eq No  신규화면 개발에 따른 매소드 추가 
* 			 searchPFMCByEqNoListService, searchComBackEndJobEqNoListStatusService, loadFileBackEndJobEqNoListResultService
* 2013.05.30 조경완 [CHM-201324809-01] [MNR-자체개선] M&R > Guideline & PFMC > General Performance > PFMC by Estimate 수행시 ALPS OLTP Rule에 따라 Timeout SQL 발생 방지를 위한 BackEndJob 으로의 기능 전환
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.basic;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.integration.PerformanceReportDBDAO;
import com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.vo.ACEPListGRPVO;
import com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.vo.ACEPListVO;
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
import com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.vo.PMFCByAgreementTariffListVO;
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
import com.hanjin.framework.component.backend.core.BackEndJobManager;
import com.hanjin.framework.component.backend.support.BackEndJobException;
import com.hanjin.framework.component.backend.support.BackEndJobMetaDataSelector;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-ReportManage Business Logic Command Interface<br>
 * - ALPS-ReportManage에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Jung Ho Min
 * @see Ees_mnr_0166EventResponse
 * @since J2EE 1.6
 */
public class PerformanceReportBCImpl extends BasicCommandSupport implements PerformanceReportBC {

	// Database Access Object
	private transient PerformanceReportDBDAO dbDao = null;

	/**
	 * PerformanceReportBCImpl 객체 생성<br>
	 * PerformanceReportDBDAO를 생성한다.<br>
	 */
	public PerformanceReportBCImpl() {
		dbDao = new PerformanceReportDBDAO();
	}

	/**
	 * Region에 의한 Disposal PFMC를 조회합니다.<br>
	 *
	 * @param DisposalPFMCByRegionGRPVO disposalPFMCByRegionGRPVO
	 * @return List<DisposalPFMCByEQGRPVO>
	 * @exception EventException
	 */
	public List<DisposalPFMCByEQGRPVO> searchDisposalPFMCByRegionListBasic(DisposalPFMCByRegionGRPVO disposalPFMCByRegionGRPVO) throws EventException {
		try {
			if("BB".equals(disposalPFMCByRegionGRPVO.getReportType())){	// By Buyer
				return dbDao.searchDisposalPFMCByRegionByBuyerListData(disposalPFMCByRegionGRPVO);
			}else{	// By Office : BO
				return dbDao.searchDisposalPFMCByRegionListData(disposalPFMCByRegionGRPVO);
			}
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Disposal PFMC by Region] searchDisposalPFMCByRegionListBasic"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Disposal PFMC by Region] searchDisposalPFMCByRegionListBasic"}).getMessage(),ex);
		}
	}

	/**
	 * EQ에 의한 Disposal PFMC를 조회합니다.<br>
	 *
	 * @param DisposalPFMCByEQVO disposalPFMCByEQVO
	 * @return List<DisposalPFMCByEQListVO>
	 * @exception EventException
	 */
	public List<DisposalPFMCByEQListVO> searchDisposalPFMCByEQListBasic(DisposalPFMCByEQVO disposalPFMCByEQVO) throws EventException {
		try {
			return dbDao.searchDisposalPFMCByEQListData(disposalPFMCByEQVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Disposal PFMC by EQ] searchDisposalPFMCByEQListBasic"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Disposal PFMC by EQ] searchDisposalPFMCByEQListBasic"}).getMessage(),ex);
		}
	}

	/**
	 * Tire Replacement Report 를 조회합니다.<br>
	 *
	 * @param TireReplacementINVO tireReplacementINVO
	 * @param SignOnUserAccount account
	 * @return List<TireReplacementHistoryVO>
	 * @exception EventException
	 */
	public List<TireReplacementHistoryVO> searchTireReplacementListBasic(TireReplacementINVO tireReplacementINVO, SignOnUserAccount account) throws EventException {
		try {
			return dbDao.searchTireReplacementListData(tireReplacementINVO, account);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Tire Replacement Report] searchTireReplacementListBasic"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Tire Replacement Report] searchTireReplacementListBasic"}).getMessage(),ex);
		}
	}

	/**
	 * Tire Replacement History Report 를 조회합니다.<br>
	 *
	 * @param TireReplacementINVO tireReplacementINVO
	 * @param SignOnUserAccount account
	 * @return List<TireReplacementHistoryVO>
	 * @exception EventException
	 */
	public List<TireReplacementHistoryVO> searchTireReplacementHistoryListBasic(TireReplacementINVO tireReplacementINVO, SignOnUserAccount account) throws EventException {
		try {
			return dbDao.searchTireReplacementHistoryListData(tireReplacementINVO, account);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Tire Replacement History Report] searchTireReplacementHistoryListBasic"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Tire Replacement History Report] searchTireReplacementHistoryListBasic"}).getMessage(),ex);
		}
	}

	/**
	 * Item에 의한 Tire Purchase Report를 조회합니다.<br>
	 *
	 * @param TirePurcharseByItemINVO tirePurcharseByItemINVO
	 * @param SignOnUserAccount account
	 * @return List<TirePurcharseByItemVO>
	 * @exception EventException
	 */
	public List<TirePurcharseByItemVO> searchTirePurchaseByItemListBasic(TirePurcharseByItemINVO tirePurcharseByItemINVO, SignOnUserAccount account) throws EventException {
		try {
			return dbDao.searchTirePurchaseByItemListData(tirePurcharseByItemINVO, account);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Tire Purchase Report by Item] searchTirePurchaseByItemListBasic"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Tire Purchase Report by Item] searchTirePurchaseByItemListBasic"}).getMessage(),ex);
		}
	}

	/**
	 * Tire Purchase Report by Supplier를 조회합니다.<br>
	 *
	 * @param TirePurcharseBySupplierINVO tirePurcharseBySupplierINVO
	 * @param SignOnUserAccount account
	 * @return List<TirePurcharseBySupplierVO>
	 * @exception EventException
	 */
	public List<TirePurcharseBySupplierVO> searchTirePurchaseBySupplierListBasic(TirePurcharseBySupplierINVO tirePurcharseBySupplierINVO, SignOnUserAccount account) throws EventException {
		try {
			return dbDao.searchTirePurchaseBySupplierListData(tirePurcharseBySupplierINVO, account);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Tire Purchase Report by Supplier] searchTirePurchaseBySupplierListBasic"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Tire Purchase Report by Supplier] searchTirePurchaseBySupplierListBasic"}).getMessage(),ex);
		}
	}

	/**
	 * Total Loss Payment to Lessor Report를 조회합니다.<br>
	 *
	 * @param TotalLossPerformanceINVO totalLossPerformanceINVO
	 * @param SignOnUserAccount account
	 * @return List<TotalLossPerformanceVO>
	 * @exception EventException
	 */
	public List<TotalLossPerformanceVO> searchTotalLossPerformanceListBasic(TotalLossPerformanceINVO totalLossPerformanceINVO, SignOnUserAccount account) throws EventException {
		try {
			return dbDao.searchTotalLossPerformanceListData(totalLossPerformanceINVO,account);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Total Loss Performance] searchTotalLossPerformanceListBasic"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Total Loss Performance] searchTotalLossPerformanceListBasic"}).getMessage(),ex);
		}
	}

	/**
	 * HO에 의한 Expense Plan and PFMC를 조회 합니다.<br>
	 *
	 * @param RepairExpensePFMCINVO repairExpensePFMCINVO
	 * @param SignOnUserAccount account
	 * @return List<RepairExpensePFMCRPTVO>
	 * @exception EventException
	 */
	public List<RepairExpensePFMCRPTVO> searchRepairExpensePFMCListBasic(RepairExpensePFMCINVO repairExpensePFMCINVO, SignOnUserAccount account) throws EventException {
		try {
			return dbDao.searchRepairExpensePFMCListData(repairExpensePFMCINVO, account);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Expense Plan and PFMC by HO] searchRepairExpensePFMCListBasic"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Expense Plan and PFMC by HO] searchRepairExpensePFMCListBasic"}).getMessage(),ex);
		}
	}

	/**
	 * Estimation Creation에 의한 MNR PFMC를 조회합니다.<br>
	 *
	 * @param RepairPFMCByESTINVO repairPFMCByESTINVO
	 * @return List<RepairPFMCByESTVO>
	 * @exception EventException
	 */
	public List<RepairPFMCByESTVO> searchRepairPFMCByESTListBasic(RepairPFMCByESTINVO repairPFMCByESTINVO) throws EventException {
		try {
			// By Service Provider
			if("SP".equals(repairPFMCByESTINVO.getReportType())){
				return dbDao.searchRepairPFMCByESTListSPData(repairPFMCByESTINVO);
			}else{ // By Cedex Code
				return dbDao.searchRepairPFMCByESTListCCData(repairPFMCByESTINVO);
			}
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[MNR PFMC by Estimation Creation] searchRepairPFMCByESTListBasic"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[MNR PFMC by Estimation Creation] searchRepairPFMCByESTListBasic"}).getMessage(),ex);
		}
	}

	/**
	 * Work Order에 의한 MNR PFMC를 조회합니다.<br>
	 *
	 * @param RepairPFMCByWOINVO repairPFMCByWOINVO
	 * @return List<RepairPFMCByWOVO>
	 * @exception EventException
	 */
	public List<RepairPFMCByWOVO> searchRepairPFMCByWOListBasic(RepairPFMCByWOINVO repairPFMCByWOINVO) throws EventException {
		try {
		    return dbDao.searchRepairPFMCByWOListData(repairPFMCByWOINVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[MNR PFMC by Estimation Creation] searchRepairPFMCByESTListBasic"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[MNR PFMC by Estimation Creation] searchRepairPFMCByESTListBasic"}).getMessage(),ex);
		}
	}

	/**
	 * AGMT TRIFF에 의한MNR PFMC를 조회합니다.<br>
	 *
	 * @param RepairPFMCByRepairCodeINVO repairPFMCByRepairCodeINVO
	 * @return List<RepairPFMCByRepairCodeVO>
	 * @exception EventException
	 */
	public List<RepairPFMCByRepairCodeVO> searchRepairPFMCByRepairCodeListBasic(RepairPFMCByRepairCodeINVO repairPFMCByRepairCodeINVO) throws EventException {
		try {
			return dbDao.searchRepairPFMCByRepairCodeListData(repairPFMCByRepairCodeINVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[MNR PFMC by AGMT TRIFF] searchRepairPFMCByRepairCodeListBasic"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[MNR PFMC by AGMT TRIFF] searchRepairPFMCByRepairCodeListBasic"}).getMessage(),ex);
		}
	}
	
	/**
	 * PFMC by CEDEX Code에 의한 Damge FQ에 대한 장비 단껀 Detail을 조회합니다.<br>
	 *
	 * @param SearchFoodQualityDetailKeyINVO searchFoodQualityDetailKeyINVO
	 * @return List<SearchFoodQualityDetailKeyVO>
	 * @exception EventException
	 */
	public List<SearchFoodQualityDetailKeyVO> searchFoodQualityDetailKey(SearchFoodQualityDetailKeyINVO searchFoodQualityDetailKeyINVO) throws EventException {
		try {
			return dbDao.searchFoodQualityDetailKey(searchFoodQualityDetailKeyINVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[MNR PFMC by CEDEX Code] searchFoodQualityDetail"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[MNR PFMC by CEDEX Code] searchFoodQualityDetail"}).getMessage(),ex);
		}
		
	}
	
	/**
	 * PFMC by CEDEX Code에 의한 Damge FQ에 대한 장비 Detail목록을 조회합니다.<br>
	 *
	 * @param List<SearchFoodQualityDetailKeyINVO>  searchFoodQualityDetailKeyINVO
	 * @return List<SearchFoodQualityDetailKeyVO>
	 * @exception EventException
	 */
	public List<SearchFoodQualityDetailKeyVO> searchFoodQualityDetailMulti(List<SearchFoodQualityDetailKeyINVO> searchFoodQualityDetailKeyINVOs) throws EventException {
		try {
			List<SearchFoodQualityDetailKeyVO> searchFoodQualityDetailKeyVOs = new ArrayList<SearchFoodQualityDetailKeyVO>();
			int searchFQ_D_IN_size=0;
			searchFQ_D_IN_size=searchFoodQualityDetailKeyINVOs.size();
			if(searchFQ_D_IN_size>0){
				for(int i=0;i<searchFQ_D_IN_size;i++){
					searchFoodQualityDetailKeyVOs.addAll(dbDao.searchFoodQualityDetailKey(searchFoodQualityDetailKeyINVOs.get(i)));
				}
			}
			
			return searchFoodQualityDetailKeyVOs;
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[MNR PFMC by CEDEX Code] searchFoodQualityDetail"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[MNR PFMC by CEDEX Code] searchFoodQualityDetail"}).getMessage(),ex);
		}
		
	}
	

	/**
	 * Type/Size에 의한 MNR PFMC을 조회 합니다.<br>
	 *
	 * @param RepairPFMCByTSINVO repairPFMCByTSINVO
	 * @return List<RepairPFMCByTSVO>
	 * @exception EventException
	 */
	public List<RepairPFMCByTSVO> searchRepairPFMCByTSListBasic(RepairPFMCByTSINVO repairPFMCByTSINVO) throws EventException {
		try {
			// By Service Provider
			if("SP".equals(repairPFMCByTSINVO.getReportType())){
				return dbDao.searchRepairPFMCByTSListSPData(repairPFMCByTSINVO);
			}else{ // By Office
				return dbDao.searchRepairPFMCByTSListOFData(repairPFMCByTSINVO);
			}
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[MNR PFMC by Type/Size] searchRepairPFMCByTSListBasic"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[MNR PFMC by Type/Size] searchRepairPFMCByTSListBasic"}).getMessage(),ex);
		}
	}

	/**
	 * VNDR/Manufacturer에 의한 MNR PFMC을 조회 합니다.<br>
	 *
	 * @param RepairPFMCBySPINVO repairPFMCBySPINVO
	 * @return List<RepairPFMCBySPVO>
	 * @exception EventException
	 */
	public List<RepairPFMCBySPVO> searchRepairPFMCBySPListBasic(RepairPFMCBySPINVO repairPFMCBySPINVO) throws EventException {
		try {
			// By Manufacturer
			if("SP".equals(repairPFMCBySPINVO.getReportType())){
				return dbDao.searchRepairPFMCBySPListMFData(repairPFMCBySPINVO);
			}else{ // By Service Provider
				return dbDao.searchRepairPFMCBySPListSPData(repairPFMCBySPINVO);
			}
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[MNR PFMC by VNDR/Manufacturer] searchRepairPFMCBySPListBasic"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[MNR PFMC by VNDR/Manufacturer] searchRepairPFMCBySPListBasic"}).getMessage(),ex);
		}
	}

	/**
	 * [EES_MNR_0195] ACEP Candidate Cntr List를 조회 합니다. <br>
	 *
	 * @param ACEPListGRPVO aCEPListGRPVO
	 * @return ACEPListGRPVO aCEPListGRPVO
	 * @exception EventException
	 */
	public ACEPListGRPVO searchACEPListBasic(ACEPListGRPVO aCEPListGRPVO) throws EventException {
		List<ACEPListVO> listACEPListVO = null;
		try {
			listACEPListVO = dbDao.searchACEPListData(aCEPListGRPVO);
			aCEPListGRPVO.setListACEPListVO(listACEPListVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[ACEP Candidate Cntr List] searchACEPListBasic"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[ACEP Candidate Cntr List] searchACEPListBasic"}).getMessage(),ex);
		}
		return aCEPListGRPVO;
	}

	/**
	 * [EES_MNR_0236] MNR PFMC by Agreement/Tariff List를 조회 합니다. <br>
	 *
	 * @param PMFCByAgreementTariffGRPVO pMFCByAgreementTariffGRPVO
	 * @return PMFCByAgreementTariffGRPVO pMFCByAgreementTariffGRPVO
	 * @exception EventException
	 */
	public PMFCByAgreementTariffGRPVO searchPMFCByAgreementTariffBasic(PMFCByAgreementTariffGRPVO pMFCByAgreementTariffGRPVO) throws EventException {
		List<PMFCByAgreementTariffListVO> listPMFCByAgreementTariffListVOs = null;
		try {
			listPMFCByAgreementTariffListVOs = dbDao.searchPMFCByAgreementTariffData(pMFCByAgreementTariffGRPVO);

			pMFCByAgreementTariffGRPVO.setListPMFCByAgreementTariffListVOs(listPMFCByAgreementTariffListVOs);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[MNR PFMC by Agreement/Tariff List] searchPMFCByAgreementTariffBasic"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[ACEP Candidate Cntr List] searchPMFCByAgreementTariffBasic"}).getMessage(),ex);
		}
		return pMFCByAgreementTariffGRPVO;
	}

	/**
	 * EES_MNR_0237 : Retrieve<br>
	 * PFMC by Account/Cost Code List를 조회합니다.<br>
	 *
	 * @param RepairPFMCByACCTINVO	repairPFMCByACCTINVO
	 * @return List<RepairPFMCByACCTVO>
	 * @exception EventException
	 */
	public List<RepairPFMCByACCTVO> searchRepairPFMCByACCTListBasic(RepairPFMCByACCTINVO repairPFMCByACCTINVO) throws EventException {
		try {
			return dbDao.searchRepairPFMCByACCTListData(repairPFMCByACCTINVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[MNR PFMC by Account/Cost Code] searchRepairPFMCByACCTListBasic"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[MNR PFMC by Account/Cost Code] searchRepairPFMCByACCTListBasic"}).getMessage(),ex);
		}
	}

	/**
	 * [EES_MNR_0244] RCC/LCC/SCC 지역별 매각실적 현황목록을 조회합니다. <br>
	 *
	 * @param DisposalPFMCByRCCVO disposalPFMCByRCCVO
	 * @return List<DisposalPFMCByRCCVO>
	 * @exception EventException
	 */
	public List<DisposalPFMCByRCCVO> searchDisposalPFMCByRCCListBasic(DisposalPFMCByRCCVO disposalPFMCByRCCVO) throws EventException {
		List<DisposalPFMCByRCCVO> resultVOs = null;

		try {
			resultVOs = dbDao.searchDisposalPFMCByRCCListData(disposalPFMCByRCCVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Disposal Performance by RCC] searchDisposalPFMCByRCCListBasic"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Disposal Performance by RCC] searchDisposalPFMCByRCCListBasic"}).getMessage(),ex);
		}

		return resultVOs;
	}

	/**
	 * [EES_MNR_0245] 월별 매각실적 현황목록을 조회합니다. <br>
	 *
	 * @param DisposalPFMCByMonthVO disposalPFMCByMonthVO
	 * @return List<DisposalPFMCByMonthVO>
	 * @exception EventException
	 */
	public List<DisposalPFMCByMonthVO> searchDisposalPFMCByMonthListBasic(DisposalPFMCByMonthVO disposalPFMCByMonthVO) throws EventException {
		List<DisposalPFMCByMonthVO> resultVOs = null;

		try {
			resultVOs = dbDao.searchDisposalPFMCByMonthListData(disposalPFMCByMonthVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Disposal Performance by Month] searchDisposalPFMCByMonthListBasic"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Disposal Performance by Month] searchDisposalPFMCByMonthListBasic"}).getMessage(),ex);
		}

		return resultVOs;
	}

	/**
	 * EES_MNR_0115 : COMMAND01<br>
	 * Expense Plan and PFMC를 조회합니다. <br>
	 *
	 * @param  RepairExpensePFMCINVO repairExpensePFMCINVO
	 * @param  SignOnUserAccount account
	 * @return String
	 * @throws EventException
	 */
	public String searchBackEndExpensePFMCListBasic(RepairExpensePFMCINVO repairExpensePFMCINVO, SignOnUserAccount account) throws EventException {
		PerformanceReportBackEndJob backEndJob = new PerformanceReportBackEndJob();
		backEndJob.setJobType("searchBackEndExpensePFMCListBasic");
		backEndJob.setRepairExpensePFMCINVO(repairExpensePFMCINVO);
		backEndJob.setAccount(account);

		BackEndJobManager backEndJobManager = new BackEndJobManager();

		try {
			return backEndJobManager.execute(backEndJob, account.getUsr_id(), "searchBackEndExpensePFMCListBasic BackEndJob");
		} catch (Exception ex) {
			log.error("err " + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[M&R Expense Plan/PFMC Inquiry] searchBackEndExpensePFMCListBasic"}).getMessage(),ex);
		}
	}

	/**
	 * EES_MNR_0115 : COMMAND02<br>
	 * BackEndJob의 실행결과에 대한 상태값을 조회합니다.<br>
	 *
	 * @param String key
	 * @return String
	 * @exception EventException
	 */
	public String searchComBackEndJobStatusBasic(String key) throws EventException {
		DBRowSet rowSet;

		try {
			rowSet = new BackEndJobMetaDataSelector(key).getDbRowset();
			rowSet.next();
			Thread.sleep(1000);
			return (String) rowSet.getObject("jb_sts_flg");
		} catch (BackEndJobException e) {
			throw new EventException(e.getMessage());
		} catch (SQLException e) {
			throw new EventException(e.getMessage());
		} catch (InterruptedException e) {
			throw new EventException(e.getMessage());
		} catch(Exception e){
			throw new EventException(e.getMessage());
		}
	}

	/**
	 * [EES_MNR_0165] Office별 계획대비 매각실적 현황목록을 조회합니다. <br>
	 *
	 * @param DisposalPFMCByOfficeVO disposalPFMCByOfficeVO
	 * @return List<DisposalPFMCByMonthVO>
	 * @exception EventException
	 */
	public List<DisposalPFMCByOfficeVO> searchDisposalPFMCByOfficeListBasic(DisposalPFMCByOfficeVO disposalPFMCByOfficeVO) throws EventException {
		List<DisposalPFMCByOfficeVO> resultVOs = null;

		try {
			resultVOs = dbDao.searchDisposalPFMCByOfficeListData(disposalPFMCByOfficeVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Disposal Performance by Office] searchDisposalPFMCByOfficeListBasic"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Disposal Performance by Office] searchDisposalPFMCByOfficeListBasic"}).getMessage(),ex);
		}

		return resultVOs;
	}

	/**
	 * [EES_MNR_0246] Buyer별 매각실적 현황목록을 조회합니다. <br>
	 *
	 * @param DisposalPFMCByBuyerVO disposalPFMCByBuyerVO
	 * @return List<DisposalPFMCByBuyerVO>
	 * @exception EventException
	 */
	public List<DisposalPFMCByBuyerVO> searchDisposalPFMCByBuyerListBasic(DisposalPFMCByBuyerVO disposalPFMCByBuyerVO) throws EventException {
		List<DisposalPFMCByBuyerVO> resultVOs = null;

		try {
			resultVOs = dbDao.searchDisposalPFMCByBuyerListData(disposalPFMCByBuyerVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Disposal Performance by Office] searchDisposalPFMCByBuyerListBasic"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Disposal Performance by Office] searchDisposalPFMCByBuyerListBasic"}).getMessage(),ex);
		}

		return resultVOs;
	}

	/**
	 * [EES_MNR_0166] 장비별 매각실적 상세정보를 조회합니다. <br>
	 *
	 * @param DisposalPFMCByEqDetailVO disposalPFMCByEqDetailVO
	  * @return List<DisposalPFMCByEqDetailVO>
	 * @exception EventException
	 */
	public List<DisposalPFMCByEqDetailVO> searchDisposalPFMCByEqDetailListBasic(DisposalPFMCByEqDetailVO disposalPFMCByEqDetailVO) throws EventException {
		List<DisposalPFMCByEqDetailVO> resultVOs = null;

		try {
			resultVOs = dbDao.searchDisposalPFMCByEqDetailListData(disposalPFMCByEqDetailVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Disposal Performance by Equipment] searchDisposalPFMCByEqDetailListBasic"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Disposal Performance by Equipment] searchDisposalPFMCByEqDetailListBasic"}).getMessage(),ex);
		}

		return resultVOs;
	}

	/**
	 * [EES_MNR_0247] 장비별 매각실적 상세결과 정보를 조회합니다. <br>
	 *
	 * @param DisposalResultEquipmentVO disposalResultEquipmentVO
	  * @return List<DisposalResultEquipmentVO>
	 * @exception EventException
	 */
	public List<DisposalResultEquipmentVO> searchDisposalResultEquipmentListBasic(DisposalResultEquipmentVO disposalResultEquipmentVO) throws EventException {
		List<DisposalResultEquipmentVO> resultVOs = null;

		try {
			resultVOs = dbDao.searchDisposalResultEquipmentListData(disposalResultEquipmentVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Disposal Result Equipment Detail] searchDisposalResultEquipmentListBasic"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Disposal Result Equipment Detail] searchDisposalResultEquipmentListBasic"}).getMessage(),ex);
		}

		return resultVOs;
	}
	
	/**
	 * [EES_MNR_0248] M&R PFMC by Estimate에 의한 MNR PFMC EQ_NO를 조회합니다.<br>
	 *
	 * @param RepairPFMCByEqNoINVO repairPFMCByEqNoINVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */		
	public String searchPFMCByEqNoListBasic(RepairPFMCByEqNoINVO repairPFMCByEqNoINVO, SignOnUserAccount account) throws EventException {
		PerformanceReportEqNoBackEndJob backEndJob = new PerformanceReportEqNoBackEndJob();
		backEndJob.setJobType("searchPFMCByEqNoListBasic");
		backEndJob.setRepairPFMCByEqNoINVO(repairPFMCByEqNoINVO);
		BackEndJobManager backEndJobManager = new BackEndJobManager();

		try {
			return backEndJobManager.execute(backEndJob, account.getUsr_id(),"searchPFMCByEqNoListBasic BackEndJob");
		} catch (Exception ex) {
			log.error("err " + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[M&R PFMC EqNo] searchPFMCByEqNoListBasic"}).getMessage(),ex);
		}
	}
	
	/**
	 * EES_MNR_0248 : COMMAND02<br>
	 * BackEndJob의 실행결과에 대한 상태값을 조회합니다.<br>
	 *
	 * @param String key
	 * @return String
	 * @exception EventException
	 */
	public String searchComBackEndJobEqNoListStatusBasic(String key) throws EventException {
		DBRowSet rowSet;
		try {
			rowSet = new BackEndJobMetaDataSelector(key).getDbRowset();
			rowSet.next();
			Thread.sleep(1000);
			return (String) rowSet.getObject("jb_sts_flg");
		} catch (BackEndJobException e) {
			throw new EventException(e.getMessage());
		} catch (SQLException e) {
			throw new EventException(e.getMessage());
		} catch (InterruptedException e) {
			throw new EventException(e.getMessage());
		} catch(Exception e){
			throw new EventException(e.getMessage());
		}
	}
	
	/**
	 * Estimation Creation에 의한 MNR PFMC를 조회합니다.<br>
	 *
	 * @param RepairPFMCByESTINVO repairPFMCByESTINVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */	
	public String searchRepairPFMCByESTListBasic(RepairPFMCByESTINVO repairPFMCByESTINVO, SignOnUserAccount account) throws EventException {
		PerformanceReportPFMCbyEstimateBackEndJob backEndJob = new PerformanceReportPFMCbyEstimateBackEndJob();
		backEndJob.setJobType("searchRepairPFMCByESTListBasic");
		backEndJob.setRepairPFMCByESTINVO(repairPFMCByESTINVO);
		BackEndJobManager backEndJobManager = new BackEndJobManager();

		try {
			return backEndJobManager.execute(backEndJob, account.getUsr_id(),"searchRepairPFMCByESTListBasic BackEndJob");
		} catch (Exception ex) {
			log.error("err " + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[M&R PFMC Report] searchRepairPFMCByESTListBasic"}).getMessage(),ex);
		}
	}




}