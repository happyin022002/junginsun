/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : StatementCommonBCImpl.java
 *@FileTitle : StatementCommonBCImpl
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2014.03.11
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2014.03.11
 * 1.0 Creation
=========================================================*/

package com.clt.apps.opus.stm.sco.statementcommon.statementcommon.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.bcm.fin.financemanagement.financecreation.vo.GlEstmRevVvdVO;
import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.integration.StatementCommonDBDAO;
import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.vo.APCostActivityInfoVO;
import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.vo.AccrualCodeInfoVO;
import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.vo.AccrualVerificationVO;
import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.vo.ApplicationComboVO;
import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.vo.CenterListVO;
import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.vo.CompanyListVO;
import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.vo.InterCompanyListVO;
import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.vo.LedgerCodeCombinationCondVO;
import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.vo.LedgerCodeCombinationListVO;
import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.vo.LookupDetailVO;
import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.vo.LookupHeaderVO;
import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.vo.LookupInfoVO;
import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.vo.OfcWrtfTpComboListVO;
import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.vo.OfficeComboListVO;
import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.vo.OfficeInfoVO;
import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.vo.PopAccountListVO;
import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.vo.RegionListVO;
import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.vo.RevenuePortEachLaneVO;
import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.vo.SakuraConversionComboVO;
import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.vo.SakuraInterfaceCondVO;
import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.vo.SakuraInterfaceListVO;
import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.vo.ScoBatHisVO;
import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.vo.ScoStmtCdConvVO;
import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.vo.SearchPeriodClosingInfoVO;
import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.vo.TesManualCancellationVO;
import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.vo.VVDListVO;
import com.clt.framework.component.backend.core.BackEndJobManager;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.util.ScheduleUtil;

/**
 * StatementCommonBCImpl Logic Command implementation<br>
 * 
 * @author
 * @see StatementCommonBC
 * @since J2EE 1.4
 */
public class StatementCommonBCImpl extends BasicCommandSupport implements
		StatementCommonBC {

	// Database Access Object
	private transient StatementCommonDBDAO dbDao = null;

	/**
	 * StatementCommonBCImpl object creation<br>
	 * StatementCommonDBDAO creation<br>
	 */
	public StatementCommonBCImpl() {
		dbDao = new StatementCommonDBDAO();
	}
	
	/** 
	 * ReceiveQueueMdmCountryBCImpl 생성자<br>
	 * DBDAO Object를 생성
	 * @param String dataSource
	 */
	public StatementCommonBCImpl(String dataSource) {
		dbDao = new StatementCommonDBDAO(dataSource);
	}

	/**
	 * [COMMON Period Closing]
	 * @author yhha
	 * @param String effYrMon
	 * @param String prdApplCd 
	 * @return List<SearchPeriodClosingInfoVO>
	 * @exception EventException
	 */
	public List<SearchPeriodClosingInfoVO> searchPeriodClosingList(
			String effYrMon, String prdApplCd) throws EventException {
		try {
			return dbDao.searchPeriodClosingList(effYrMon, prdApplCd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [COMMON Period Closing manage]
	 * @author yhha
	 * @param SearchPeriodClosingInfoVO[] SearchPeriodClosingInfoVO
	 * @param SignOnUserAccount account 
	 * @exception EventException
	 */	
	public void managePeriodClosingInfo(
			SearchPeriodClosingInfoVO[] searchPeriodClosingInfoVO,
			SignOnUserAccount account) throws EventException {
		try {
			for (int i = 0; i < searchPeriodClosingInfoVO.length; i++) {
				if (searchPeriodClosingInfoVO[i].getIbflag().equals("I")) {
					searchPeriodClosingInfoVO[i].setCreUsrId(account
							.getUsr_id());
					searchPeriodClosingInfoVO[i].setUpdUsrId(account
							.getUsr_id());
					dbDao.insertPeriodClosingInfo(searchPeriodClosingInfoVO[i]);
				} else if (searchPeriodClosingInfoVO[i].getIbflag().equals("U")) {
					searchPeriodClosingInfoVO[i].setUpdUsrId(account
							.getUsr_id());
					dbDao.modifyPeriodClosingInfo(searchPeriodClosingInfoVO[i]);
				} else if (searchPeriodClosingInfoVO[i].getIbflag().equals("D")) {
					dbDao.removePeriodClosingInfo(searchPeriodClosingInfoVO[i]);
				}

			}
		} catch (DAOException de) {
			log.error("DAO err " + de.toString(), de);
			throw new EventException(new ErrorHandler(de).getMessage(), de);
		} catch (Exception de) {
			log.error("EXC err " + de.toString(), de);
			throw new EventException(new ErrorHandler(de).getMessage(), de);
		}
	}

	/**
	 * [COMMON Lookup Code]
	 * [lookup code]- 목록을 조회<br>
	 *
	 * @param String lu_tp_cd
	 * @return List<LookupInfoVO>
	 * @exception EventException
	 */
	public List<LookupInfoVO> searchLookupList(String lu_tp_cd)
			throws EventException {
		try {
			return dbDao.searchLookupList(lu_tp_cd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [COMMON Lookup Code]
	 * [lookup code]- 목록을 조회<br>
	 *
	 * @param LookupInfoVO lookupInfoVO
	 * @return List<LookupInfoVO>
	 * @exception EventException
	 */
	public List<LookupInfoVO> searchLookupComboList(LookupInfoVO lookupInfoVO)
			throws EventException {
		try {
			return dbDao.searchLookupComboList(lookupInfoVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * [COMMON Lookup Code]
	 * [lookup code]- 목록을 조회<br>
	 *
	 * @param LookupInfoVO lookupInfoVO
	 * @return List<LookupInfoVO>
	 * @exception EventException
	 */
	public List<LookupInfoVO> searchLookupComboListWithChkStartEndDate(LookupInfoVO lookupInfoVO)
			throws EventException {
		try {
			return dbDao.searchLookupComboListWithChkStartEndDate(lookupInfoVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	
	/**
	 * [COMMON Lookup Code]
	 * [lookup code]- 목록을 조회<br>
	 *
	 * @param LookupInfoVO lookupInfoVO
	 * @return List<LookupInfoVO>
	 * @exception EventException
	 */
	public List<LookupInfoVO> searchEvidenceLookupComboList(LookupInfoVO lookupInfoVO)
			throws EventException {
		try {
			return dbDao.searchEvidenceLookupComboList(lookupInfoVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [COMMON Lookup Code]
	 * [lookup code]- Retrieve Lookup Header<br>
	 *
	 * @param String lu_tp_cd
	 * @param String lu_appl_cd
	 * @return List<LookupHeaderVO>
	 * @exception EventException
	 */
	public List<LookupHeaderVO> searchLookupHeader(String lu_tp_cd,
			String lu_appl_cd) throws EventException {
		try {
			return dbDao.searchLookupHeader(lu_tp_cd, lu_appl_cd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [COMMON Lookup Code]
	 * [lookup code]- Retrieve Lookup Detail<br>
	 *
	 * @param String h_lu_tp_cd
	 * @return List<LookupDetailVO>
	 * @exception EventException
	 */
	public List<LookupDetailVO> searchLookupDetail(String h_lu_tp_cd)
			throws EventException {
		try {
			return dbDao.searchLookupDetail(h_lu_tp_cd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [COMMON Lookup Code]
	 * [lookup code]- Save Lookup Header	  <br>
	 * 
	 * @param LookupHeaderVO[] lookupHeaderVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageLookupHeader(LookupHeaderVO[] lookupHeaderVO,
			SignOnUserAccount account) throws EventException {
		try {

			for (int i = 0; i < lookupHeaderVO.length; i++) {
				if (lookupHeaderVO[i].getIbflag().equals("I")) {
					lookupHeaderVO[i].setCreUsrId(account.getUsr_id());
					lookupHeaderVO[i].setUpdUsrId(account.getUsr_id());
					dbDao.insertLookupHeader(lookupHeaderVO[i]);
				} else if (lookupHeaderVO[i].getIbflag().equals("U")) {
					lookupHeaderVO[i].setUpdUsrId(account.getUsr_id());
					dbDao.modifyLookupHeader(lookupHeaderVO[i]);
				} else if (lookupHeaderVO[i].getIbflag().equals("D")) {
					dbDao.removeLookupDetailAll(lookupHeaderVO[i].getLuTpCd()); // 2014.04.01
																				// remove
																				// detail
																				// all
																				// related
																				// to
																				// Header
																				// Type
					dbDao.removeLookupHeader(lookupHeaderVO[i]);
				}
			}
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler(de).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler(de).getMessage(), de);
		}
	}

	/**
	 * [COMMON Lookup Code]
	 * [lookup code]- Save Lookup Detail	  <br>
	 * 
	 * @param LookupDetailVO[] lookupDetailVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageLookupDetail(LookupDetailVO[] lookupDetailVO,
			SignOnUserAccount account) throws EventException {
		try {

			for (int i = 0; i < lookupDetailVO.length; i++) {
				if (lookupDetailVO[i].getIbflag().equals("I")) {
					lookupDetailVO[i].setCreUsrId(account.getUsr_id());
					lookupDetailVO[i].setUpdUsrId(account.getUsr_id());
					dbDao.insertLookupDetail(lookupDetailVO[i]);
				} else if (lookupDetailVO[i].getIbflag().equals("U")) {
					lookupDetailVO[i].setUpdUsrId(account.getUsr_id());
					dbDao.modifyLookupDetail(lookupDetailVO[i]);
				} else if (lookupDetailVO[i].getIbflag().equals("D")) {
					dbDao.removeLookupDetail(lookupDetailVO[i]);
				}
			}
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler(de).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler(de).getMessage(), de);
		}
	}

	/**
	 * [COMMON Applicaition Combo]
	 * [Applicaition Combo]- Application 목록을 조회<br>
	 *
	 * @return List<ApplicationComboVO>
	 * @exception EventException
	 */
	public List<ApplicationComboVO> searchApplicationCombo()
			throws EventException {
		try {
			return dbDao.searchApplicationCombo();
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [COMMON Office Combo]
	 * [Office Combo]- Office 목록을 조회<br>
	 *
	 * @return List<OfficeComboListVO>
	 * @exception EventException
	 */
	public List<OfficeComboListVO> searchOfficeComboList()
			throws EventException {
		try {
			return dbDao.searchOfficeComboList();
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [COMMON STM Office Info]
	 * [STM Office Information]- Retrieve Office Information<br>
	 *
	 * @param String ofc_cd
	 * @return List<OfficeInfoVO>
	 * @exception EventException
	 */
	public List<OfficeInfoVO> searchOfficeInfo(String ofc_cd)
			throws EventException {
		try {
			return dbDao.searchOfficeInfo(ofc_cd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [COMMON Office Information]
	 * [STM Office Information]- Save manageOfficeInfo	  <br>
	 * by HJPARK
	 * @param OfficeInfoVO[] officeInfoVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageOfficeInfo(OfficeInfoVO[] officeInfoVO,
			SignOnUserAccount account) throws EventException {
		try {
			for (int i = 0; i < officeInfoVO.length; i++) {
				if (officeInfoVO[i].getIbflag().equals("I")) {
					officeInfoVO[i].setCreUsrId(account.getUsr_id());
					officeInfoVO[i].setUpdUsrId(account.getUsr_id());
					dbDao.insertOfficeInfo(officeInfoVO[i]);
				} else if (officeInfoVO[i].getIbflag().equals("U")) {
					officeInfoVO[i].setUpdUsrId(account.getUsr_id());
					dbDao.modifyOfficeInfo(officeInfoVO[i]);
				}
			}
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler(de).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler(de).getMessage(), de);
		}
	}

	/**
     * Company Popup<br>
     * 
     * @author MCJung 2014.04.03
     * @category STM_SCO_0051
     * @category searchPopCompanyList
     * @param String companyCode
     * @return List<CompanyListVO>
     * @throws EventException
     */ 
	public List<CompanyListVO> searchPopCompanyList(String companyCode)
			throws EventException {

		try {
			// List<PopSupplierListVO> returnList =
			// dbDao.searchPopSupplierList(vendorName);
			// returnList = dbDao.searchPopSupplierList(vendorName);
			// return returnList;
			return dbDao.searchPopCompanyList(companyCode);

		} catch (DAOException e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("COM10001",
					new String[] {}).getUserMessage());
		}
	}

	/**
     * Region Popup - Retrieve <br>	
     * 	
     * @author CYJ	
     * @category STM_SCO_0052	
     * @category searchPopRegionList	
     * @param String luCd
     * @return List<RegionListVO>	
     * @throws EventException	
     */
	public List<RegionListVO> searchPopRegionList(String luCd)
			throws EventException {
		try {
			List<RegionListVO> returnList = dbDao.searchPopRegionList(luCd);
			return returnList;
		} catch (DAOException e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("COM10001",
					new String[] {}).getUserMessage());
		}
	}

	/**
     * Retrieve Center Popup
     * Cenetr List Popup<br>
     * @author JKKIL
     * @param CenterListVO centerListVO   
     * @return List<CenterListVO>
     * @throws EventException
     */
	public List<CenterListVO> searchPopCenterListVO(CenterListVO centerListVO)
			throws EventException {
		try {
			return dbDao.searchPopCenterList(centerListVO);
		} catch (DAOException e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("COM10001",
					new String[] {}).getUserMessage());
		}
	}

	/**
     * Account Popup<br>
     * 
     * @author MCJung 2014.04.01
     * @category STM_SCO_0054
     * @category searchPopAccountList
     * @param String accountCode
     * @param String accountType
     * @param String unsettledFlag
     * @return List<PopAccountListVO>
     * @throws EventException
     */ 
	public List<PopAccountListVO> searchPopAccountList(String accountCode,
			String accountType, String unsettledFlag) throws EventException {

		try {
			return dbDao.searchPopAccountList(accountCode, accountType,
					unsettledFlag);

		} catch (DAOException e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("COM10001",
					new String[] {}).getUserMessage());
		}
	}

	 /**
     * Inter Company Popup
     * Inter Company List Popup<br>
     * @author JKKIL
     * @param InterCompanyListVO interCompanyListVO   
     * @return List<InterCompanyListVO>
     * @throws EventException
     */   
	public List<InterCompanyListVO> searchPopInterCompanyListVO(
			InterCompanyListVO interCompanyListVO) throws EventException {
		try {
			return dbDao.searchPopInterCompanyList(interCompanyListVO);
		} catch (DAOException e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("COM10001",
					new String[] {}).getUserMessage());
		}
	}

	/**
     * VVD Popup
     * VVD List 조회<br>
     * @param String vvd_cd   
     * @return List<VVDListVO>
     * @throws EventException
     */ 
	public List<VVDListVO> searchPopVVDList(String vvd_cd)
			throws EventException {
		try {
			List<VVDListVO> returnList = dbDao.searchPopVVDList(vvd_cd);

			return returnList;
		} catch (DAOException e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("COM10001",
					new String[] {}).getUserMessage());
		}
	}

	 /**
     * Account Popup<br>
     * 
     * @author Kyungsam Jo 2015.03.17
     * @category STM_SCO_0090
     * @category searchPopAccountCommonList
     * @param String accountCode
     * @param String accountType
     * @param String unsettledFlag
     * @param String lineType
     * @param String acctNm
     * @return List<PopAccountListVO>
     * @throws EventException
     */   
    public List<PopAccountListVO> searchPopAccountCommonList(String accountCode, String accountType, String unsettledFlag, String lineType, String acctNm) throws EventException {
    	try {
    		return dbDao.searchPopAccountCommonList(accountCode, accountType, unsettledFlag, lineType, acctNm); 
		} catch (DAOException e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getUserMessage());
		}
    }  
    
    /**
	 * [Ledger Code Combination]
	 * [Ledger Code Combination]- Search Ledger Code Combination	  <br>
	 * 
	 * @param LedgerCodeCombinationCondVO ledgerCodeCombinationCondVO
	 * @return List<LedgerCodeCombinationListVO>
	 * @exception EventException
	 */
	public List<LedgerCodeCombinationListVO> searchLedgerCodeCombination(
			LedgerCodeCombinationCondVO ledgerCodeCombinationCondVO)
			throws EventException {

		try {

			List<LedgerCodeCombinationListVO> list = dbDao
					.searchLedgerCodeCombination(ledgerCodeCombinationCondVO);

			return list;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [STM_SCO_0050]
	 * manageLedgerCodeCombination<br>
	 *
	 * @param LedgerCodeCombinationListVO[] ledgerCodeCombinationListVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageLedgerCodeCombination(
			LedgerCodeCombinationListVO[] ledgerCodeCombinationListVOs,
			SignOnUserAccount account) throws EventException {
		try {

			// SAP_INV_DTL
			if (ledgerCodeCombinationListVOs != null) {
				List<LedgerCodeCombinationListVO> insertVoListLine = new ArrayList<LedgerCodeCombinationListVO>();
				List<LedgerCodeCombinationListVO> updateVoListLine = new ArrayList<LedgerCodeCombinationListVO>();
				List<LedgerCodeCombinationListVO> deleteVoListLine = new ArrayList<LedgerCodeCombinationListVO>();

				for (int i = 0; i < ledgerCodeCombinationListVOs.length; i++) {
					ledgerCodeCombinationListVOs[i].setUsrId(account
							.getUsr_id());
					if (ledgerCodeCombinationListVOs[i].getIbflag().equals("I")) {

						if (!dbDao.searchLedgerCodeCombinationDupCheck(
								ledgerCodeCombinationListVOs[i]).equals("0")) {
							throw new EventException(
									new ErrorHandler("COM12226",
											new String[] { "Data" })
											.getMessage());
						}

						String nextKey = dbDao
								.searchLedgerCodeCombinationNextKey();
						ledgerCodeCombinationListVOs[i].setCdCmbSeq(nextKey);
						insertVoListLine.add(ledgerCodeCombinationListVOs[i]);
					} else if (ledgerCodeCombinationListVOs[i].getIbflag()
							.equals("U")) {
						updateVoListLine.add(ledgerCodeCombinationListVOs[i]);
					} else if (ledgerCodeCombinationListVOs[i].getIbflag()
							.equals("D")) {
						deleteVoListLine.add(ledgerCodeCombinationListVOs[i]);
					}
				}

				if (insertVoListLine.size() > 0) {
					dbDao.addLedgerCodeCombination(insertVoListLine);
				}
				if (updateVoListLine.size() > 0) {
					dbDao.modifyLedgerCodeCombination(updateVoListLine);
				}
				if (deleteVoListLine.size() > 0) {
					dbDao.removeLedgerCodeCombination(deleteVoListLine);
				}
			}

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}

	}

	/**
	 * [STM_SCO_0050]
	 * manageLedgerCodeCombinationBiz<br>
	 *
	 * @param LedgerCodeCombinationListVO ledgerCodeCombinationListVO
	 * @param String usrId
	 * @return String[]
	 * @exception EventException
	 */
	public String[] manageLedgerCodeCombinationBiz(
			LedgerCodeCombinationListVO ledgerCodeCombinationListVO,
			String usrId) throws EventException {

		String rtnValue[] = { "", "" };
		try {

			if (ledgerCodeCombinationListVO != null) {
				List<LedgerCodeCombinationListVO> insertVoListLine = new ArrayList<LedgerCodeCombinationListVO>();

				ledgerCodeCombinationListVO.setUsrId(usrId);
				ledgerCodeCombinationListVO.setEnblFlg("Y");

				// CHECK DUPLICATION
				if (!dbDao.searchLedgerCodeCombinationDupCheck(ledgerCodeCombinationListVO).equals("0")) {
					rtnValue[0] = new ErrorHandler("COM12226", new String[] { "CCID" }).getUserMessage(); // ($s) is duplicated.
				}

				String company = ledgerCodeCombinationListVO.getSgmCtnt1();
				String region = ledgerCodeCombinationListVO.getSgmCtnt2();
				String center = ledgerCodeCombinationListVO.getSgmCtnt3();
				String acct = ledgerCodeCombinationListVO.getSgmCtnt4();
				String interCom = ledgerCodeCombinationListVO.getSgmCtnt5();
				String vvd = ledgerCodeCombinationListVO.getSgmCtnt6();
				String nextKey = "";

				// CHECK COMPANY
				if (!company.equals(dbDao.searchCompanyCheck(company))) {
					rtnValue[0] = new ErrorHandler("COM12241", new String[] { "COMPANY" + "-" + company }).getUserMessage(); // ($s) is invalid.
				}
				// CHECK REGION
				if (!region.equals(dbDao.searchRegionCheck(region))) {
					rtnValue[0] = new ErrorHandler("COM12241", new String[] { "REGION" + "-" + region }).getUserMessage(); // ($s) is invalid.
				}
				// CHECK CENTER
				if (!center.equals(dbDao.searchCenterCheck(center))) {
					rtnValue[0] = new ErrorHandler("COM12241", new String[] { "CENTER" + "-" + center }).getUserMessage(); // ($s) is invalid.
				}
				// CHECK ACCOUNT
				if (!acct.equals(dbDao.searchAccountCheck(acct))) {
					rtnValue[0] = new ErrorHandler("COM12241", new String[] { "ACCOUNT" + "-" + acct }).getUserMessage(); // ($s) is invalid.
				}
				// CHECK INTERCOMPANY
				if (!interCom.equals(dbDao.searchInterCompanyCheck(interCom))) {
					rtnValue[0] = new ErrorHandler("COM12241", new String[] { "INTER COMPANY" + "-" + interCom }).getUserMessage(); // ($s) is invalid.
				}
				// CHECK VVD
				if (!vvd.equals(dbDao.searchVVDCheck(vvd))) {
					rtnValue[0] = new ErrorHandler("COM12241", new String[] { "VVD" + "-" + vvd }).getUserMessage(); // ($s) is invalid.
				}

				if (!rtnValue[0].equals("")) {
					return rtnValue;
				} else {
					nextKey = dbDao.searchLedgerCodeCombinationNextKey();
					ledgerCodeCombinationListVO.setCdCmbSeq(nextKey);
					insertVoListLine.add(ledgerCodeCombinationListVO);
				}

				if (insertVoListLine.size() > 0) {
					dbDao.addLedgerCodeCombination(insertVoListLine);
					rtnValue[0] = "OK";
					rtnValue[1] = nextKey;
				}
			}

		} catch (DAOException ex) {
			rtnValue[0] = new ErrorHandler(ex).getMessage();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			rtnValue[0] = new ErrorHandler(ex).getMessage();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}

		return rtnValue;

	}

	/**
	 * [Bank Office Combo]
	 * [Bank Office Combo]- Bank Office 목록을 조회<br>
	 *
	 * @param String mdm_ofc_cd
	 * @param String ofcEntrLvlCd
	 * @return List<OfficeComboListVO>
	 * @exception DAOException
	 */
	public List<OfficeComboListVO> searchBankOfficeComboList(String mdm_ofc_cd,
			String ofcEntrLvlCd) throws EventException {
		try {
			return dbDao.searchBankOfficeComboList(mdm_ofc_cd, ofcEntrLvlCd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [Office Write-off Type Combo]
	 * [Office Write-off Type Combo]- Search Office Write-off Type Combo List<br>
	 *
	 * @return List<OfcWrtfTpComboListVO>
	 * @exception EventException
	 */
	public List<OfcWrtfTpComboListVO> searchOfcWrtfTpComboList()
			throws EventException {
		try {
			return dbDao.searchOfcWrtfTpComboList();
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
     * [STM_SCO_0200]<br>
     * 
     * @author ORKIM
     * @category searchAPCostActivityInfoList
     * @param String src_mdl_cd
     * @param String act_cost_cd
     * @param String del_flg
     * @return List<APCostActivityInfoVO>
     * @throws EventException
     */
	public List<APCostActivityInfoVO> searchAPCostActivityInfoList(
			String src_mdl_cd, String act_cost_cd, String del_flg)
			throws EventException {
		try {
			return dbDao.searchAPCostActivityInfoList(src_mdl_cd, act_cost_cd,
					del_flg);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [STM_SCO_0200]
	 * 
	 * @author ORKIM
	 * @category manageAPCostActivityInfo
	 * @param APCostActivityInfoVO[] aPCostActivityInfoVOs
	 * @param SignOnUserAccount account
	 * @throws EventException;
	 */
	public void manageAPCostActivityInfo(
			APCostActivityInfoVO[] aPCostActivityInfoVOs,
			SignOnUserAccount account) throws EventException {
		try {

			if (aPCostActivityInfoVOs != null) {
				List<APCostActivityInfoVO> insertVoList = new ArrayList<APCostActivityInfoVO>();
				List<APCostActivityInfoVO> updateVoList = new ArrayList<APCostActivityInfoVO>();

				for (int i = 0; i < aPCostActivityInfoVOs.length; i++) {
					aPCostActivityInfoVOs[i].setUsrId(account.getUsr_id());
					if (aPCostActivityInfoVOs[i].getIbflag().equals("I")) {

						insertVoList.add(aPCostActivityInfoVOs[i]);
					} else if (aPCostActivityInfoVOs[i].getIbflag().equals("U")) {
						updateVoList.add(aPCostActivityInfoVOs[i]);
					}
				}

				if (insertVoList.size() > 0) {
					dbDao.addAPCostActivityInfo(insertVoList);
				}
				if (updateVoList.size() > 0) {
					dbDao.modifyAPCostActivityInfo(updateVoList);
				}

			}

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [SAKURA Code Conversion Combo]
	 *
	 * @return List<SakuraConversionComboVO>
	 * @exception EventException
	 */
	public List<SakuraConversionComboVO> searchSakuraConversionCombo()
			throws EventException {
		try {
			return dbDao.searchSakuraConversionCombo();
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [SAKURA Code Conversion Info]
     * @param String luTpCd
     * @param String enblFlg
	 * @return List<ScoStmtCdConvVO>
	 * @exception EventException
	 */
	public List<ScoStmtCdConvVO> searchSakuraConversionInfo(String luTpCd,
			String enblFlg) throws EventException {
		try {
			return dbDao.searchSakuraConversionInfo(luTpCd, enblFlg);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * SAKURA Code Conversion<br> 
	 * @author JBLEE
	 * @param ScoStmtCdConvVO[] scoStmtCdConvVOs
     * @param String usrId
	 * @exception EventException
	 */
	public void manageSakuraConversionInfo(ScoStmtCdConvVO[] scoStmtCdConvVOs,
			String usrId) throws EventException {
		try {
			if (scoStmtCdConvVOs != null) {
				List<ScoStmtCdConvVO> insertVoList = new ArrayList<ScoStmtCdConvVO>();
				List<ScoStmtCdConvVO> removeVoList = new ArrayList<ScoStmtCdConvVO>();

				for (int i = 0; i < scoStmtCdConvVOs.length; i++) {
					scoStmtCdConvVOs[i].setCreUsrId(usrId);
					scoStmtCdConvVOs[i].setUpdUsrId(usrId);
					if (scoStmtCdConvVOs[i].getIbflag().equals("U")) {
						insertVoList.add(scoStmtCdConvVOs[i]);
						removeVoList.add(scoStmtCdConvVOs[i]);
					}
				}
				// Delete -> Insert
				if (removeVoList.size() > 0) {
					dbDao.removeSakuraConversionInfo(removeVoList);
				}
				if (insertVoList.size() > 0) {
					dbDao.addSakuraConversionInfo(insertVoList);
				}

			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [COMMON Lookup Code]
	 * [lookup code]- 紐⑸줉??議고쉶<br>
	 *
	 * @param LookupInfoVO lookupInfoVO
	 * @return List<LookupInfoVO>
	 * @exception EventException
	 */
	public List<LookupInfoVO> searchAcctCtnt2LookupComboList(
			LookupInfoVO lookupInfoVO) throws EventException {
		try {
			return dbDao.searchAcctCtnt2LookupComboList(lookupInfoVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [COMMON Lookup Code]
	 * [lookup code]- AcctCtnt3<br>
	 *
	 * @param LookupInfoVO lookupInfoVO
	 * @return List<LookupInfoVO>
	 * @exception EventException
	 */
	public List<LookupInfoVO> searchAcctCtnt3LookupComboList(
			LookupInfoVO lookupInfoVO) throws EventException {
		try {
			return dbDao.searchAcctCtnt3LookupComboList(lookupInfoVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [COMMON Lookup Code]
	 * [lookup code]- AcctCtnt4<br>
	 *
	 * @param LookupInfoVO lookupInfoVO
	 * @return List<LookupInfoVO>
	 * @exception EventException
	 */
	public List<LookupInfoVO> searchAcctCtnt4LookupComboList(
			LookupInfoVO lookupInfoVO) throws EventException {
		try {
			return dbDao.searchAcctCtnt4LookupComboList(lookupInfoVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [Revenue Port Loading Port per each lane]
	 * [Revenue Port]- 목록을 조회<br>
	 *
	 * @param String slanCd
	 * @param String rLaneCd
	 * @return List<RevenuePortEachLaneVO>
	 * @exception EventException
	 */
	public List<RevenuePortEachLaneVO> searchRevenuePortEachLaneList(
			String slanCd, String rLaneCd) throws EventException {
		try {
			return dbDao.searchRevenuePortEachLaneList(slanCd, rLaneCd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [Revenue Port Loading Port per each lane]
	 * [Revenue Port]- 목록을 저장<br>
	 *
	 * @param RevenuePortEachLaneVO[] revenuePortEachLaneVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageRevenuePortEachLaneList(
			RevenuePortEachLaneVO[] revenuePortEachLaneVOs,
			SignOnUserAccount account) throws EventException {
		try {
			if (revenuePortEachLaneVOs != null) {
				List<RevenuePortEachLaneVO> insertVoList = new ArrayList<RevenuePortEachLaneVO>();
				List<RevenuePortEachLaneVO> updateVoList = new ArrayList<RevenuePortEachLaneVO>();
				List<RevenuePortEachLaneVO> deleteVoList = new ArrayList<RevenuePortEachLaneVO>();

				for (int i = 0; i < revenuePortEachLaneVOs.length; i++) {
					if (revenuePortEachLaneVOs[i].getIbflag().equals("U")) {
						if (revenuePortEachLaneVOs[i].getDeltFlg().equals("Y")) {
							deleteVoList.add(revenuePortEachLaneVOs[i]);
						} else {
							List<RevenuePortEachLaneVO> chkrevenuePortEachLaneVOs = dbDao
									.chkRevenuePortEachLaneInfo(revenuePortEachLaneVOs[i]);
							if (chkrevenuePortEachLaneVOs.size() > 0) {
								revenuePortEachLaneVOs[i].setUpdUsrId(account
										.getUsr_id());
								updateVoList.add(revenuePortEachLaneVOs[i]);
							} else {
								revenuePortEachLaneVOs[i].setCreUsrId(account
										.getUsr_id());
								revenuePortEachLaneVOs[i].setUpdUsrId(account
										.getUsr_id());
								insertVoList.add(revenuePortEachLaneVOs[i]);
							}
						}
					}
				}
				// Delete -> Insert
				if (updateVoList.size() > 0) {
					dbDao.modifyRevenuePortEachLaneList(updateVoList);
				}
				if (insertVoList.size() > 0) {
					dbDao.addRevenuePortEachLaneList(insertVoList);
				}
				if (deleteVoList.size() > 0) {
					dbDao.deleteRevenuePortEachLaneList(deleteVoList);
				}

			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [Revenue Port]
	 * [Revenue Port]- Port 정보 체크<br>
	 *
	 * @param String revPortCd
	 * @return String
	 * @exception EventException
	 */
	public String searchRevenuePort(String revPortCd) throws EventException {
		try {
			return dbDao.searchRevenuePort(revPortCd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [Revenue Port]
	 * [Revenue Port]- search Tes Menual Cancellation<br>
	 *
	 * @param String exeYrmon
	 * @param String cancelFlg
	 * @param String vvd
	 * @param String ydCd 
	 * @return List<TesManualCancellationVO>
	 * @exception EventException
	 */
	public List<TesManualCancellationVO> searchTesMenualCancellation(String exeYrmon, String cancelFlg, String vvd, String ydCd ) throws EventException {
		try {
			return dbDao.searchTesMenualCancellation(exeYrmon, cancelFlg, vvd, ydCd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [STM_SCO_0400]
	 * 
	 * @author ORKIM
	 * @category cancelTesMenualCancellation
	 * @param TesManualCancellationVO[] tesManualCancellationVOs
	 * @param SignOnUserAccount account
	 * @param String exeYrmon
	 * @throws EventException;
	 */
	public void cancelTesMenualCancellation( TesManualCancellationVO[] tesManualCancellationVOs,SignOnUserAccount account, String exeYrmon) throws EventException {
		try {

			if (tesManualCancellationVOs != null) {
				List<TesManualCancellationVO> updateVoList = new ArrayList<TesManualCancellationVO>();

				for (int i = 0; i < tesManualCancellationVOs.length; i++) {
					if (tesManualCancellationVOs[i].getIbflag().equals("U")) 
					{
						if (tesManualCancellationVOs[i].getVvd().length() == 9) {
							tesManualCancellationVOs[i].setVslCd(		tesManualCancellationVOs[i].getVvd().substring(0, 4)	);
							tesManualCancellationVOs[i].setSkdVoyNo(	tesManualCancellationVOs[i].getVvd().substring(4, 8)	);
							tesManualCancellationVOs[i].setSkdDirCd(	tesManualCancellationVOs[i].getVvd().substring(8, 9)	);
							tesManualCancellationVOs[i].setRevDirCd(	""	);
						} else {
							tesManualCancellationVOs[i].setVslCd(		tesManualCancellationVOs[i].getVvd().substring(0, 4)	);
							tesManualCancellationVOs[i].setSkdVoyNo(	tesManualCancellationVOs[i].getVvd().substring(4, 8)	);
							tesManualCancellationVOs[i].setSkdDirCd(	tesManualCancellationVOs[i].getVvd().substring(8, 9)	);
							tesManualCancellationVOs[i].setRevDirCd(	tesManualCancellationVOs[i].getVvd().substring(9, 10)	);
						}
						tesManualCancellationVOs[i].setUpdUsrId(	account.getUsr_id()										);
						tesManualCancellationVOs[i].setExeMonth(	exeYrmon.replaceAll("-", "")							);
						
						updateVoList.add(tesManualCancellationVOs[i]);
					}
				}

				if (updateVoList.size() > 0) {
					dbDao.modifyTesMenualCancellation(updateVoList);
				}

			}

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [COMMON Period Closing Info]
	 * [Search] 
	 * @return List<String>
	 * @exception EventException
	 */
	public List<String> searchZeroBalanceRunningList() throws EventException {
		try {
			return dbDao.searchZeroBalanceRunningList();
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	
	/**
	 * INV_AR_STUP_OFC 조회
	 *
	 * @param String OfcCd
	 * @return String
	 * @exception EventException
	 */
	public String searchInvArOfc(String OfcCd) throws EventException {
		try {
			return dbDao.searchInvArOfc(OfcCd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Create Miss Revenue VVD<br>
	 * 
	 * @param String missDt
	 * @param String missVvd
	 * @param String userId
	 * @param String missSlan
	 * @return GlEstmRevVvdVO
	 * @exception EventException
	 */	
	public GlEstmRevVvdVO manageMissVvd(String missDt, String missVvd, String userId, String missSlan) throws EventException {
		try {
			return dbDao.manageMissRevVVD(missDt, missVvd, userId, missSlan);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}  

	/**
	 * Create Migration Revenue VVD<br>
	 * 
	 * @param String migDt
	 * @param String migVvd
	 * @return GlEstmRevVvdVO
	 * @exception EventException
	 */	
	public GlEstmRevVvdVO manageMigVvd(String migDt, String migVvd) throws EventException {
		try {
			return dbDao.manageMigRevVVD(migDt, migVvd);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}  

	/**
	 * Create Migration Revenue VVD<br>
	 * 
	 * @param String etlJob
	 * @param String yrMon
	 * @return String
	 * @exception EventException
	 */	
	public String manageRemoteEtlJob(String etlJob, String yrMon) throws EventException {
		String rtnRslt = null;
		try {
			log.debug("etlJob : "+etlJob+"yrMon : "+yrMon);
			
            String hostcommand = "/bin/remsh 10.82.175.71 -l dsadm sh /ettdata/ACCL/sh/"+etlJob+" "+yrMon;
			log.debug("hostcommand : "+hostcommand);
            final Process pr = Runtime.getRuntime().exec(hostcommand);
            
            new Thread
            (
                new Runnable() {
                    public void run() {
                        BufferedReader br_in = null;
                        try {
                            br_in = new BufferedReader(new InputStreamReader(pr.getInputStream()));
                			log.debug("br_in -----------------------------> : "+br_in);
                			String buff_1 = null;
                			while((buff_1 = br_in.readLine()) != null) {
                            	log.debug("Process out -----------------------------> : "+buff_1);
                                try {
                                	log.debug("InputStream-1");
                                    Thread.sleep(100);
                                	log.debug("InputStream-2");
                                } catch(Exception e) {
                                	log.debug("err 1 : "+e.toString(), e);
                                }
                            }
                        	log.debug("InputStream-3");
                            br_in.close();
                        	log.debug("InputStream-4");
                        } catch(IOException ioe) {
                        	log.debug("Exception caught printing process output.");
                        	log.debug("err 1_1 : "+ioe.toString(), ioe);
                        } finally {
                            try {
                            	log.debug("InputStream-5");
                                br_in.close();
                            	log.debug("InputStream-6");
                            } catch(Exception ex) {
                            	log.debug("err 1_2 : "+ex.toString(), ex);
                            }
                        }
                    }
                }
            ).start();
            log.debug("InputStream-7");
            
            new Thread
            (
                new Runnable() {
                    public void run() {
                        BufferedReader br_err = null;
                        try {
                            br_err = new BufferedReader(new InputStreamReader(pr.getErrorStream()));
                			log.debug("br_err -----------------------------> : "+br_err);
                			String buff_2 = null;
                			while((buff_2 = br_err.readLine()) != null) {
                            	log.debug("Process err -----------------------------------> : "+buff_2);
                                try {
                                	log.debug("ErrorStream-1");
                                    Thread.sleep(100);
                                	log.debug("ErrorStream-2");
                                } catch(Exception e) {
                                	log.debug("err 2 : "+e.toString(), e);
                                }
                            }
                        	log.debug("ErrorStream-3");
                            br_err.close();
                        	log.debug("ErrorStream-4");
                        } catch (IOException ioe) {
                        	log.debug("Exception caught printing process error.");
                        	log.debug("err 2_1 : "+ioe.toString(), ioe);
                        } finally {
                            try {
                            	log.debug("ErrorStream-5");
                                br_err.close();
                            	log.debug("ErrorStream-6");
                            } catch(Exception ex) {
                            	log.debug("err 2_2 : "+ex.toString(), ex);
                            }
                        }
                    }
                }
            ).start();
            log.debug("ErrorStream-7");
			
            rtnRslt =  "S";
		} catch (Exception ex) {
			rtnRslt =  "E";
			log.debug("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BBBBB", new String[]{}).getMessage(), ex);
		}
		
		return rtnRslt;
	}  
	
	/**
	 * [Yard Name]
	 *
	 * @param String ydCd
	 * @return String
	 * @exception EventException
	 */
	public String searchYardName(String ydCd) throws EventException {
		try {
			return dbDao.searchYardName(ydCd);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
	 * Create Accrual Data<br>
	 * 
	 * @param String jobNm
	 * @param String yrMon
	 * @param String userId
	 * @return String
	 * @exception EventException
	 */	
	public String manageAccrualData(String jobNm, String yrMon, String userId) throws EventException {
		
		String batchStatus = "";
		try {
        	/*
        	log.debug("jobNm 	: ---------------------------------->" + jobNm	);
        	log.debug("yrMon 	: ---------------------------------->" + yrMon	);
        	log.debug("userId 	: ---------------------------------->" + userId	);
	    	*/
        	if(jobNm == null || "".equals(jobNm))
	    	{              
	        	throw new EventException(new ErrorHandler("COM12113",new String[]{"Accrual Job"}).getMessage());
	        } 
	    	if(yrMon == null || "".equals(yrMon))
	    	{              
	        	throw new EventException(new ErrorHandler("COM12113",new String[]{"Accrual Month"}).getMessage());
	        } 
	    	else 
	    	{
	        	String params = jobNm + "#" + yrMon + "#" + userId;
	        	ScheduleUtil su = new ScheduleUtil();
	        	//log.debug("STM_SCO_B1004 : ------------------------------>" + params);
	        	batchStatus = su.directExecuteJob("STM_SCO_B1004", params);
	        	//log.debug("batchStatus : ---------------------------------->" + batchStatus);
	        }
		} catch (DAOException e) {
			log.error("err "+e.toString(),e);
        	throw new EventException(new ErrorHandler("COM12113", new String[]{"Exe Month"}).getMessage(),e);
		} catch (Exception e){
			log.error("err "+e.toString(),e);
        	throw new EventException(new ErrorHandler("COM12113", new String[]{"Exe Month"}).getMessage(),e);
		}
		
		return batchStatus;
	}  
	
	/**
	 * [STM_SCO_9999] Refresh<br>
	 * 
	 * @category searchAcclJobStatus
	 * @param String jobNm
	 * @param String yrMon
	 * @return String
	 * @exception EventException
	 */	
	public String searchAcclJobStatus(String jobNm, String yrMon) throws EventException {
		try {
			return dbDao.searchAcclJobStatus(jobNm, yrMon);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * [STM_SCO_9999] DownLoad<br>
	 * 
	 * @category searchAcclJobStatus
	 * @param String jobNm
	 * @param String yrMon
	 * @return List<Object>
	 * @exception EventException
	 */	
	public List<Object> manageAcclDataDownLoad(String jobNm, String yrMon) throws EventException {
		try {
			return dbDao.manageAcclDataDownLoad(jobNm, yrMon);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Common searchLocalSysdate <br>
	 * 
	 * @category searchLocalSysdate
	 * @param String ofcCd
	 * @return String
	 * @exception EventException
	 */	
	public String searchLocalSysdate(String ofcCd) throws EventException {
		try {
			return dbDao.searchLocalSysdate(ofcCd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}		
	}
	
    /**
  	 * Search Sakura Interface info<br> 
  	 * 
  	 * @param SakuraInterfaceCondVO sakuraInterfaceCondVO
  	 * @return List<SakuraInterfaceListVO>
  	 * @exception EventException
  	 */
	public List<SakuraInterfaceListVO> searchSakuraInterfaceList(SakuraInterfaceCondVO sakuraInterfaceCondVO) throws EventException {		
		try {
			//return dbDao.searchSakuraInterfaceList(sakuraInterfaceCondVO);
			List<SakuraInterfaceListVO> returnList = dbDao.searchSakuraInterfaceList(sakuraInterfaceCondVO);
	   		
   		 	if(returnList != null && returnList.size() > 0) {
   		 		returnList.get(0).setMaxRows(Integer.parseInt(returnList.get(0).getTotalCnt()));
   		 	}
   		 
   		 return returnList;    		
			
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
	}	

	/**
	 * [Office Adjustment Type Combo]
	 * [Office Adjustment Type Combo]- Search Office Adjustment Type Combo List<br>
	 *
	 * @return List<OfcWrtfTpComboListVO>
	 * @exception EventException
	 */
	public List<OfcWrtfTpComboListVO> searchOfcAdjustTpComboList()
			throws EventException {
		try {
			return dbDao.searchOfcAdjustTpComboList();
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * search SCO_BAT_HIS_SEQ.NEXTVAL <br>
	 * 
	 * @return String
	 * @exception EventException
	 */	
	public String searchScoBatHisNextSeq() throws EventException {
		try {
			return dbDao.searchScoBatHisNextSeq();
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	
	/**
	 * create SCO_BAT_HIS <br>
	 * 
	 * @param ScoBatHisVO scoBatHisVO
	 * @exception EventException
	 */	
	public void addScoBatHis(ScoBatHisVO scoBatHisVO) throws EventException {
		try {
			dbDao.addScoBatHis(scoBatHisVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * search SCO_BAT_HIS <br>
	 * 
	 * @param String batSeq
	 * @return ScoBatHisVO
	 * @exception EventException
	 */	
	public ScoBatHisVO searchScoBatHis(String batSeq) throws EventException {
		try {
			return dbDao.searchScoBatHis(batSeq);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * update SCO_BAT_HIS <br>
	 * 
	 * @param ScoBatHisVO scoBatHisVO
	 * @return int
	 * @exception EventException
	 */	
	public int modifyScoBatHis(ScoBatHisVO scoBatHisVO) throws EventException {
		try {
			return dbDao.modifyScoBatHis(scoBatHisVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Monthly TES/TRS/COST Accrual Verification BackEndJob
	 * 2016.12.21 Add
	 * 
	 * @param accrualVerificationVO
	 * @param account
	 * @return
	 * @throws EventException
	 */
	public String searchMonthlyAccrualVerificationBackEndJob(AccrualVerificationVO accrualVerificationVO, SignOnUserAccount account) throws EventException {
		StatementCommonBackEndJob backEndJob = new StatementCommonBackEndJob();
		String key = "";
		try {
			String jobFlg = accrualVerificationVO.getJobFlg();
			String mdlTpCd = accrualVerificationVO.getMdlTpCd();
			log.debug("\n searchMonthlyAccrualVerificationBackEndJob START===================="+
		              "\n mdl_tp_cd ["+mdlTpCd+"]"+
					  "\n job_flg   ["+jobFlg+"]"+
					  "\n searchMonthlyAccrualVerificationBackEndJob E N D====================");
			//String mdlTpCd = accrualVerificationVO.getMdlTpCd();
			
			backEndJob.setJobFlg(jobFlg);//TRS, TES, COST
			backEndJob.setAccrualVerificationVO(accrualVerificationVO);
			key = (new BackEndJobManager()).execute(backEndJob, account.getUsr_id(), "searchMonthlyAccrualBackEndJob["+mdlTpCd+"/"+jobFlg+"]");
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return key;
	}
	
    /**
  	 * Monthly Accrual Code List : T- Trade/ A - Account, S - sakura Account
	 * 2016.12.21 Add
  	 * 
  	 * @param String codeTpCd
  	 * @param AccrualVerificationVO accrualVerificationVO
  	 * @return List<AccrualCodeInfoVO>
  	 * @exception EventException
  	 */
	public List<AccrualCodeInfoVO> searchMonthlyAccrualCodeList(String codeTpCd, AccrualVerificationVO accrualVerificationVO) throws EventException {		
		try {
			
			List<AccrualCodeInfoVO> list = null;
			
			if("T".equals(codeTpCd)){
				list = dbDao.searchMonthlyAccrualTradeList(accrualVerificationVO);
			}else if("A".equals(codeTpCd)){
				list = dbDao.searchMonthlyAccrualAccountList(accrualVerificationVO);
			}else if("S".equals(codeTpCd)){
				list = dbDao.searchMonthlyAccrualSakuraAccountList(accrualVerificationVO);
			}
			
   		 	return list;    		
			
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
	}
	
}
