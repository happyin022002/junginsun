/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PerformanceReportBCImpl.java
*@FileTitle : Disposal PFMC by Region
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.ees.mnr.reportmanage.performancereport.basic;

import java.sql.SQLException;
import java.util.List;

import com.clt.apps.opus.ees.mnr.reportmanage.performancereport.integration.PerformanceReportDBDAO;
import com.clt.apps.opus.ees.mnr.reportmanage.performancereport.vo.ACEPListGRPVO;
import com.clt.apps.opus.ees.mnr.reportmanage.performancereport.vo.ACEPListVO;
import com.clt.apps.opus.ees.mnr.reportmanage.performancereport.vo.DisposalPFMCByBuyerVO;
import com.clt.apps.opus.ees.mnr.reportmanage.performancereport.vo.DisposalPFMCByEqDetailVO;
import com.clt.apps.opus.ees.mnr.reportmanage.performancereport.vo.DisposalPFMCByMonthVO;
import com.clt.apps.opus.ees.mnr.reportmanage.performancereport.vo.DisposalPFMCByRCCVO;
import com.clt.apps.opus.ees.mnr.reportmanage.performancereport.vo.PMFCByAgreementTariffGRPVO;
import com.clt.apps.opus.ees.mnr.reportmanage.performancereport.vo.PMFCByAgreementTariffListVO;
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
import com.clt.framework.component.backend.support.BackEndJobException;
import com.clt.framework.component.backend.support.BackEndJobMetaDataSelector;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * COM-ReportManage Business Logic Command Interface<br>
 * - COM-ReportManage disposing business logic<br>
 *
 * @author 
 * @see 	Ees_mnr_0166EventResponse
 * @since 	J2EE 1.6
 */	
public class PerformanceReportBCImpl extends BasicCommandSupport implements PerformanceReportBC {

	// Database Access Object
	private transient PerformanceReportDBDAO dbDao = null;

	/**
	 * Constructor
	 */
	public PerformanceReportBCImpl() {
		dbDao = new PerformanceReportDBDAO();
	}	
	
	/**
	 * [EES_MNR_0166]Retrieving "Disposal PFMC By Equipment Detail" data<br>
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
	 * Retrieving "Tire Replacement Report" data<br>
	 *
	 * @param TireReplacementINVO	tireReplacementINVO
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
	 * Retrieving "Tire Replacement History Report" data<br>
	 *
	 * @param TireReplacementINVO	tireReplacementINVO
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
	 * Retrieving "Tire Purchase Report" data by Item<br>
	 *
	 * @param TirePurcharseByItemINVO	tirePurcharseByItemINVO
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
	 * Retrieving "Tire Purchase Report" data by supplier<br>
	 *
	 * @param TirePurcharseBySupplierINVO	tirePurcharseBySupplierINVO
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
	 * Retrieving "Total Loss Payment" data by loss Report<br>
	 *
	 * @param TotalLossPerformanceINVO	totalLossPerformanceINVO
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
	 * Retrieving PFMC by "Estimation Creation"<br>
	 *
	 * @param RepairPFMCByESTINVO	repairPFMCByESTINVO
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
	 * Retrieving PFMC by "Work Order"<br>
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
	 * Retrieving PFMC by "AGMT TRIFF"<br>
	 *
	 * @param RepairPFMCByRepairCodeINVO	repairPFMCByRepairCodeINVO
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
	 * Retrieving PFMC by "Type/Size"<br>
	 *
	 * @param RepairPFMCByTSINVO	repairPFMCByTSINVO
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
	 * Retrieving PFMC by "VNDR/Manufacturer"<br>
	 *
	 * @param RepairPFMCBySPINVO	repairPFMCBySPINVO
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
	 *  [EES_MNR_0230] Retrieving "ACEP Candidate Cntr List" data<br>
	 *
	 * @param ACEPListGRPVO	aCEPListGRPVO
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
	 *  [EES_MNR_0236] Retrieving "MNR PFMC by Agreement/Tariff List" data<br>
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
	 * EES_MNR_0237 : Retrieving "PFMC by Account/Cost Code List" data<br>
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
	 * [EES_MNR_0244]Retrieving sold performance of each regional(RCC/LCC/SCC)<br>
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
	 * [EES_MNR_0245]Retrieving sold performance of monthly<br>
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
	 * [EES_MNR_0246] Retrieving sold performance of Buyer<br>
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
}