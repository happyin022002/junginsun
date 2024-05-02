/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EmptyReleaseRedeliveryOrderMgtBCImpl.java
 *@FileTitle : EmptyReleaseRedeliveryOrderMgtBCImpl
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier :
 *@LastVersion :
=========================================================*/
package com.clt.apps.opus.ees.ctm.emptyreleaseredeliveryordermgt.emptyreleaseredeliveryordermgt.basic;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.clt.apps.opus.ees.ctm.emptyreleaseredeliveryordermgt.emptyreleaseredeliveryordermgt.integration.EmptyReleaseRedeliveryOrderMgtDBDAO;
import com.clt.apps.opus.ees.ctm.emptyreleaseredeliveryordermgt.emptyreleaseredeliveryordermgt.integration.EmptyReleaseRedeliveryOrderMgtEAIDAO;
import com.clt.apps.opus.ees.ctm.emptyreleaseredeliveryordermgt.emptyreleaseredeliveryordermgt.vo.BkgDgCgoforEdiVO;
import com.clt.apps.opus.ees.ctm.emptyreleaseredeliveryordermgt.emptyreleaseredeliveryordermgt.vo.CimCStockVO;
import com.clt.apps.opus.ees.ctm.emptyreleaseredeliveryordermgt.emptyreleaseredeliveryordermgt.vo.CimTerritoryVO;
import com.clt.apps.opus.ees.ctm.emptyreleaseredeliveryordermgt.emptyreleaseredeliveryordermgt.vo.MdmCountryVO;
import com.clt.apps.opus.ees.ctm.emptyreleaseredeliveryordermgt.emptyreleaseredeliveryordermgt.vo.MdmOrganizationVO;
import com.clt.apps.opus.ees.ctm.emptyreleaseredeliveryordermgt.emptyreleaseredeliveryordermgt.vo.RDFaxMailEAIVO;
import com.clt.apps.opus.ees.ctm.emptyreleaseredeliveryordermgt.emptyreleaseredeliveryordermgt.vo.SearchFaxInfoVO;
import com.clt.apps.opus.ees.ctm.emptyreleaseredeliveryordermgt.emptyreleaseredeliveryordermgt.vo.SearchTerritoryForMultiComboVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.CrossItemVO;
import com.clt.bizcommon.edi.broker.ReferenceNumberGeneratorBroker;
import com.clt.framework.component.backend.core.BackEndJobManager;
import com.clt.framework.component.backend.support.BackEndJobException;
import com.clt.framework.component.backend.support.BackEndJobMetaDataSelector;
import com.clt.framework.component.backend.support.BackEndJobResult;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.core.layer.integration.EAIException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;



/**
 * OPUS-EmptyReleaseRedeliveryOrderMgt Business Logic Basic Command implementation<br>
 * handling business logic for OPUS-EmptyReleaseRedeliveryOrderMgt
 *
 * @author 
 * @see Ees_ctm_0428EventResponse, EmptyReleaseRedeliveryOrderMgtBC DAO class reference
 * @see Ees_ctm_0426EventResponse, EmptyReleaseRedeliveryOrderMgtBC DAO class reference
 * @see Ees_ctm_0451EventResponse, EmptyReleaseRedeliveryOrderMgtBC DAO class reference
 * @see Ees_ctm_0429EventResponse, EmptyReleaseRedeliveryOrderMgtBC DAO class reference
 * @since J2EE 1.6
 */
public class EmptyReleaseRedeliveryOrderMgtBCImpl extends BasicCommandSupport implements EmptyReleaseRedeliveryOrderMgtBC {

	// Database Access Object
	private transient EmptyReleaseRedeliveryOrderMgtDBDAO dbDao = null;
	private transient EmptyReleaseRedeliveryOrderMgtEAIDAO eaiDao = null;

	/**
	 * creating EmptyReleaseRedeliveryOrderMgtBCImpl Object
	 * creating EmptyReleaseRedeliveryOrderMgtDBDAO
	 */
	public EmptyReleaseRedeliveryOrderMgtBCImpl() {
		dbDao = new EmptyReleaseRedeliveryOrderMgtDBDAO();
		eaiDao = new EmptyReleaseRedeliveryOrderMgtEAIDAO();	
	}

	/**
	 * EES_CTM_0428 : retrieving Territory List
	 *
	 * @param CimTerritoryVO cimTerritoryVO
	 * @return List<CimTerritoryVO>
	 * @exception EventException
	 */
	public List<CimTerritoryVO> searchTerritoryList(CimTerritoryVO cimTerritoryVO) throws EventException {
		try {
			return dbDao.searchTerritoryList(cimTerritoryVO);
		} catch (DAOException ex) {
			log.error("\n\n[BCImpl - searchTerritoryList] DAOException :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch(Exception ex) {
			log.error("\n\n[BCImpl - searchTerritoryList] Exception :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}
	}

	/**
	 * EES_CTM_0428 : retrieving Country List
	 *
	 * @param MdmCountryVO mdmCountryVO
	 * @return List<MdmCountryVO>
	 * @exception EventException
	 */
	public List<MdmCountryVO> selectComboCountry(MdmCountryVO mdmCountryVO) throws EventException {
		try {
			return dbDao.selectComboCountry(mdmCountryVO);
		} catch (DAOException ex) {
			log.error("\n\n[BCImpl - selectComboCountry] DAOException :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch(Exception ex) {
			log.error("\n\n[BCImpl - selectComboCountry] Exception :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}
	}

	/**
	 * EES_CTM_0428 : retrieving Organization List
	 *
	 * @param MdmOrganizationVO mdmOrganizationVO
	 * @return List<MdmOrganizationVO>
	 * @exception EventException
	 */
	public List<MdmOrganizationVO> selectComboOrganization(MdmOrganizationVO mdmOrganizationVO) throws EventException {
		try {
			return dbDao.selectComboOrganization(mdmOrganizationVO);
		} catch (DAOException ex) {
			log.error("\n\n[BCImpl - selectComboOrganization] DAOException :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch(Exception ex) {
			log.error("\n\n[BCImpl - selectComboOrganization] Exception :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}
	}

	/**
	 * EES_CTM_0428 : handling multiple event for CimTerritory
	 *
	 * @param CimTerritoryVO[] cimTerritoryVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageTerritory(CimTerritoryVO[] cimTerritoryVOs, SignOnUserAccount account) throws EventException {
		List<CimTerritoryVO> insertVoList = new ArrayList<CimTerritoryVO>();
		List<CimTerritoryVO> updateVoList = new ArrayList<CimTerritoryVO>();
		List<CimTerritoryVO> deleteVoList = new ArrayList<CimTerritoryVO>();
		try {
			for (int i=0; i<cimTerritoryVOs.length; i++) {
				cimTerritoryVOs[i].setUsrId(account.getUsr_id());
				if ( cimTerritoryVOs[i].getIbflag().equals("I")){
					insertVoList.add(cimTerritoryVOs[i]);
				} else if ( cimTerritoryVOs[i].getIbflag().equals("U")){
					updateVoList.add(cimTerritoryVOs[i]);
				} else if ( cimTerritoryVOs[i].getIbflag().equals("D")){
					deleteVoList.add(cimTerritoryVOs[i]);
				}
			}

			if ( insertVoList.size() > 0 ) {
				dbDao.addManageTerritoryS(insertVoList);
			}
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyManageTerritoryS(updateVoList);
			}
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeManageTerritoryS(deleteVoList);
			}

		} catch (DAOException ex) {
			log.error("\n\n[BCImpl - manageSTKRecovery] DAOException :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch(Exception ex) {
			log.error("\n\n[BCImpl - manageSTKRecovery] Exception :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}
	}

	/**
	 * EES_CTM_0426 : retrieving TerritoryList according to user's office code for Multicombo
	 *
	 * @param String ofcCd
	 * @return List<SearchTerritoryForMultiComboVO>
	 * @exception EventException
	 */
    public List<SearchTerritoryForMultiComboVO> searchTerritoryForMultiCombo(String ofcCd) throws EventException {
		try {
			return dbDao.searchTerritoryForMultiCombo(ofcCd);
		} catch (DAOException ex) {
			log.error("\n\n[BCImpl - searchTerritoryForMultiCombo] DAOException :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch(Exception ex) {
			log.error("\n\n[BCImpl - searchTerritoryForMultiCombo] Exception :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}
	}

	/**
	 * EES_CTM_0426 : retrieving CimCStock IssueList
	 *
	 * @param CimCStockVO cimCStockVO
	 * @return List<CimCStockVO>
	 * @exception EventException
	 */
	public List<CimCStockVO> searchIssueList(CimCStockVO cimCStockVO) throws EventException {
		List<CimCStockVO> searchList = new ArrayList<CimCStockVO>();
		try {
			if (cimCStockVO.getIssued().equals("N")) {
				if (cimCStockVO.getType().equals("RLS")) {
					searchList = dbDao.searchNoIssueReleaseList(cimCStockVO);

				} else if (cimCStockVO.getType().equals("RDV")) {
					searchList = dbDao.searchNoIssueReDeliveryList(cimCStockVO);
				}

			} else if (cimCStockVO.getIssued().equals("Y")) {
				if (cimCStockVO.getType().equals("RLS")) {
					searchList = dbDao.searchIssuedReleaseList(cimCStockVO);

				} else if (cimCStockVO.getType().equals("RDV")) {
					searchList = dbDao.searchIssuedReDeliveryList(cimCStockVO);
				}
			}
		} catch (DAOException ex) {
			log.error("\n\n[BCImpl - searchIssueList] DAOException :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch(Exception ex) {
			log.error("\n\n[BCImpl - searchIssueList] Exception :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}
		return searchList;
	}

	/**
	 * EES_CTM_0426 : settling CimCStock IssuedOrder
	 *
	 * @param CimCStockVO[] cimCStockVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void settleIssuedOrder(CimCStockVO[] cimCStockVOs, SignOnUserAccount account) throws EventException {
		List<CimCStockVO> settleList = new ArrayList<CimCStockVO>();
		try {
			String userLoc = dbDao.getUserLocCd(account.getUsr_id());
			/* looping for length of cimCStockVOs */
			for (int i=0; i<cimCStockVOs.length; i++) {
				/* Release */
				if (cimCStockVOs[0].getType().equals("RLS")) {
					/* TypeCD(C, M, R, S) */
					if (cimCStockVOs[i].getTypeCd().equals("C")) {
						settleList = dbDao.searchSettleReleaseCHList(cimCStockVOs[i]);

					} else if (cimCStockVOs[i].getTypeCd().equals("M")) {
						settleList = dbDao.searchSettleReleaseMHList(cimCStockVOs[i]);

					} else if (cimCStockVOs[i].getTypeCd().equals("R")) {
						settleList = dbDao.searchSettleReleaseRPList(cimCStockVOs[i]);

					} else if (cimCStockVOs[i].getTypeCd().equals("S")) {
						settleList = dbDao.searchSettleReleaseSTList(cimCStockVOs[i]);
					}

					for (int k=0; k<settleList.size(); k++) {
 						settleList.get(k).setUserId(account.getUsr_id());
						settleList.get(k).setEmptyCy(cimCStockVOs[i].getEmptyCy());
						settleList.get(k).setBd(cimCStockVOs[i].getBd());
						settleList.get(k).setTypeCd(cimCStockVOs[i].getTypeCd());
						settleList.get(k).setUserId(account.getUsr_id());
						settleList.get(k).setUserLoc(userLoc);
					}
					if ( settleList.size() > 0 ) {
						dbDao.modifySettleIssuedOrders(settleList);
					}

				/* Re-Delivery */
				} else {
					cimCStockVOs[i].setUserId(account.getUsr_id());
					cimCStockVOs[i].setUserLoc(userLoc);
					settleList.add(cimCStockVOs[i]);
				}
			}

			/* Re-Delivery */
			if ( cimCStockVOs[0].getType().equals("RDV") && cimCStockVOs.length > 0 ) {
				dbDao.modifySettleIssuedOrders(settleList);
			}

		} catch (DAOException ex) {
			log.error("\n\n[BCImpl - settleIssuedOrder] DAOException :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch(Exception ex) {
			log.error("\n\n[BCImpl - settleIssuedOrder] Exception :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}
	}

	/**
	 * EES_CTM_0426 : retrieving fax information for RD
	 *
	 * @param CimCStockVO[] cimCStockVOs
	 * @return String
	 * @exception EventException
	 */
	public String searchRDContent(CimCStockVO[] cimCStockVOs) throws EventException {
		List<SearchFaxInfoVO> searchFaxInfoList = new ArrayList<SearchFaxInfoVO>();

		StringBuilder textForRD = new StringBuilder();
		String dl = "|&&|";
		String typeCd = "";
		String crrBkgNo = "";
		String crrBlNo = "";
		String crrWoNo = "";
		String crrShpr = "";
		String prtBkgNo = "";
		String prtBlNo = "";
		String prtWoNo = "";
		String prtShpr = "";
		int sumQty = 0;
		String crrCntrTpszDesc = "";
		String crrPdDate = "";
		String crrModeCd = "";
		String crrVndrLglEngNm = "";
		String crrSpclInst = "";
		String crrCntrNo = "";
		String tpVal = cimCStockVOs[0].getType();    // Type : RLS/RDV 

//	      ===================================================================
//	      Text file 
//	      ===================================================================
//			EINYCNA200309260001     --  main query(mandatory for sub page - doesn't matter same value)
//			expense gorup1st|&&|expnese code|&&|item no.|&&|1000|&&|   --  subpage1
//			expense gorup1st|&&|expnese code|&&|item no.|&&|2000|&&|
//			expense gorup1st|&&|expnese code|&&|item no.|&&|3000|&&|
//			expense gorup1st|&&|expnese code|&&|item no.|&&|4000|&&|
//			//EOR//
//																	   -- subpage2	no data
//			//EOR//
//																	   -- subpage3	no data
//			//EOR//
//			                                                           -- subpage4  no data
//			//EOR//
//	                                                                   -- subpage5  no data
//			//EOR//
//
//			EINYCNA200309260001     --  main query(mandatory for sub page - doesn't matter same value)
//	                                                                 -- subpage1 no data
//			//EOR//
//			RQST NO|&&|RQST_OFC|&&|30000|&&|                           -- subpage2
//			//EOR//
//			Expense gorupcd1|&&|Expense gorupcd2|&&|123456|&&|code name|&&|001|&&|item name|&&|tic|&&|calculation basis|&&|request option|&&|  -- subpage3
//			//EOR//
//			1000|&&|2000|&&|0.988|&&|KOR|&&|1000|&&|                   -- subpage4
//			//EOR//
//			01|&&|2000|&&|300|&&|400|&&|1000|&&|1000|&&|               -- subpage5
//			02|&&|2010|&&|300|&&|400|&&|1000|&&|1000|&&|
//			03|&&|2030|&&|300|&&|400|&&|1000|&&|1000|&&|
//			04|&&|2050|&&|300|&&|400|&&|1000|&&|1000|&&|
//			05|&&|2070|&&|300|&&|400|&&|1000|&&|1000|&&|
//			06|&&|2090|&&|300|&&|400|&&|1000|&&|1000|&&|
//			07|&&|2110|&&|300|&&|400|&&|1000|&&|1000|&&|
//			08|&&|2130|&&|300|&&|400|&&|1000|&&|1000|&&|
//			09|&&|2150|&&|300|&&|400|&&|1000|&&|1000|&&|
//			10|&&|2170|&&|300|&&|400|&&|1000|&&|1000|&&|
//			11|&&|2190|&&|300|&&|400|&&|1000|&&|1000|&&|
//			12|&&|2210|&&|300|&&|400|&&|1000|&&|1000|&&|
//			//EOR//
//	      ===================================================================

		try {
			/* looping for length of cimCStockVOs */
			for (int i=0; i<cimCStockVOs.length; i++) {
				cimCStockVOs[i].setUserId(cimCStockVOs[0].getUserId());
				// setting Merchant Haulage as Vender name in case TypeCd is M before check logic
				if ("M".equals(cimCStockVOs[i].getTypeCd())) {
					cimCStockVOs[i].setVndrLglEngNm("Merchant Haulage");
				}
				searchFaxInfoList.addAll(dbDao.searchFaxInfoDetailList(cimCStockVOs[i]));
			}
			if ((searchFaxInfoList == null || searchFaxInfoList.size() < 1) || (searchFaxInfoList.size() < cimCStockVOs.length)) {
				throw new EventException(new ErrorHandler("CTM10001", new String[]{"user info detail list"}).getMessage());
			}

			String userLoc = dbDao.getUserLocCd(cimCStockVOs[0].getUserId());
			if (userLoc == null || "".equals(userLoc)) {
				throw new EventException(new ErrorHandler("CTM10001", new String[]{"user loc code"}).getMessage());
			}
			String[] faxInfoHeader = dbDao.searchFaxInfoHeader(userLoc, cimCStockVOs[0].getUserOfc(), cimCStockVOs[0].getUserCnt());
			if (faxInfoHeader == null || faxInfoHeader.length < 1) {
				throw new EventException(new ErrorHandler("CTM10001", new String[]{"RD header data"}).getMessage());
			}

			//== Header Content (S) =======================================================
			textForRD.append(tpVal + dl);
			textForRD.append(faxInfoHeader[0] + dl);    // OFC_ENG_NM
			textForRD.append(faxInfoHeader[1] + dl);    // ADDRESS
			textForRD.append(faxInfoHeader[2] + dl);    // LOCAL_TIME

			textForRD.append(searchFaxInfoList.get(0).getYdNm() + dl);
			textForRD.append(searchFaxInfoList.get(0).getYdPicNm() + dl);
			textForRD.append(searchFaxInfoList.get(0).getPhnNo() + dl);
			textForRD.append(searchFaxInfoList.get(0).getUserInfo() + dl);
			textForRD.append(cimCStockVOs[0].getEmail() + dl);
			textForRD.append(cimCStockVOs[0].getFaxNo() + dl + "\n");
			//== Header Content (E) =======================================================

			/* looping for length of cimCStockVOs.*/
			for (int i=0; i<cimCStockVOs.length; i++) {
				typeCd = cimCStockVOs[i].getTypeCd();    // Type_CD : C/M/R/D/S
				crrBkgNo = cimCStockVOs[i].getBkgNo();
				crrBlNo = cimCStockVOs[i].getBlNo();
				crrWoNo = cimCStockVOs[i].getWoNo();
				crrShpr = cimCStockVOs[i].getShpr();
				if ("RLS".equals(tpVal)) {
					sumQty = Integer.parseInt(cimCStockVOs[i].getQty());
				} else {
					sumQty = 1;
				}
				crrCntrTpszDesc = searchFaxInfoList.get(i).getCntrTpszDesc();
				crrPdDate = cimCStockVOs[i].getPdDate();
				crrModeCd = cimCStockVOs[i].getModeCd();
				crrVndrLglEngNm = cimCStockVOs[i].getVndrLglEngNm();
				crrSpclInst = cimCStockVOs[i].getSpclInst();
				crrCntrNo = cimCStockVOs[i].getCntrNo();

				boolean dupBkgBlWo = false;
				if (i < 1) {
					prtBkgNo = crrBkgNo;
					prtBlNo = crrBlNo;
					prtWoNo = crrWoNo;
					prtShpr = crrShpr;

				} else {
					//  checking BkgNo, BlNo, WoNo, Shpr are same with previous line
					//  omitting duplicated item for RD
					if ("RLS".equals(tpVal)) {    // Release
						if (!"".equals(crrBkgNo)) {    // comparing bkg_no
							if (crrBkgNo.equals(cimCStockVOs[i-1].getBkgNo())) {
								dupBkgBlWo = true;
							} else {                   // comparing wo_no
								prtBkgNo = crrBkgNo;
							}
						} else {
							if (crrWoNo.equals(cimCStockVOs[i-1].getWoNo())) {
								dupBkgBlWo = true;
							} else {
								prtWoNo = crrWoNo;
							}
						}
					} else {                      // Rederivery
						if (!"".equals(crrBlNo)) {    // comparing bkg_no
							if (crrBlNo.equals(cimCStockVOs[i-1].getBlNo())) {
								dupBkgBlWo = true;
							} else {
								prtBlNo = crrBlNo;
							}
						} else {                      // comparing wo_no
							if (crrWoNo.equals(cimCStockVOs[i-1].getWoNo())) {
								dupBkgBlWo = true;
							} else {
								prtWoNo = crrWoNo;
							}
						}
					}

					if (!dupBkgBlWo && !crrShpr.equals(cimCStockVOs[i-1].getShpr())) {
						prtShpr = crrShpr;
					}
				}

				for (int k=i+1; k<cimCStockVOs.length; k++) {
					// checking BkgNo, BlNo, WoNo are same with next line
					boolean subDupBkgBlWo = false;
					if ("RLS".equals(tpVal)) {    // Release
						if (!"".equals(crrBkgNo)) {    // comparing bkg_no
							if (crrBkgNo.equals(cimCStockVOs[k].getBkgNo())) {
								subDupBkgBlWo = true;
							}
						} else {                       // comparing wo_no
							if (crrWoNo.equals(cimCStockVOs[k].getWoNo())) {
								subDupBkgBlWo = true;
							}
						}
					} else {                      // Rederivery
						if (!"".equals(crrBlNo)) {     // comparing bl_no
							if (crrBlNo.equals(cimCStockVOs[k].getBlNo())) {
								subDupBkgBlWo = true;
							}
						} else {                       // comparing wo_no
							if (crrWoNo.equals(cimCStockVOs[k].getWoNo())) {
								subDupBkgBlWo = true;
							}
						}
					}
					//  checking Type/Size, Qty, P/Up Date, Trans Mode, VndrLglEngNm, SpclInst are same with next line
					if (subDupBkgBlWo &&
						crrShpr.equals(cimCStockVOs[k].getShpr()) &&
						crrCntrTpszDesc.equals(searchFaxInfoList.get(k).getCntrTpszDesc()) &&
						crrPdDate.equals(cimCStockVOs[k].getPdDate()) &&
						crrModeCd.equals(cimCStockVOs[k].getModeCd()) &&
						crrVndrLglEngNm.equals(cimCStockVOs[k].getVndrLglEngNm()) &&
						crrSpclInst.equals(cimCStockVOs[k].getSpclInst()) ) {

						//  in case of duplicated line
						if ("RLS".equals(tpVal)) {
							sumQty = sumQty + Integer.parseInt(cimCStockVOs[k].getQty());
						} else {
							sumQty = sumQty + 1;
						}
						crrCntrNo = crrCntrNo + "          " + cimCStockVOs[k].getCntrNo();
						i = k;    

					} else {
						break;
					}
				}

				//== Body Content (S) =======================================================
				textForRD.append(typeCd + dl);
				textForRD.append(prtBkgNo + dl);
				textForRD.append(prtBlNo + dl);
				textForRD.append(prtWoNo + dl);
				textForRD.append(prtShpr + dl);
				textForRD.append(sumQty + dl);
				textForRD.append(crrCntrTpszDesc + dl);
				textForRD.append(crrPdDate + dl);
				textForRD.append(crrModeCd + dl);
				textForRD.append(crrVndrLglEngNm + dl);
				textForRD.append(crrSpclInst + dl);
				textForRD.append(crrCntrNo + dl + "\n");
				//== Body Content (E) =======================================================

    			prtBkgNo = "";
    			prtBlNo = "";
    			prtWoNo = "";
    			prtShpr = "";
			}

		} catch (EventException ex) {
			log.error("\n\n[BCImpl - searchFaxInfo] EventException :\n" + ex.getMessage(), ex);
			throw ex;
		} catch (DAOException ex) {
			log.error("\n\n[BCImpl - searchFaxInfo] DAOException :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch(Exception ex) {
			log.error("\n\n[BCImpl - searchFaxInfo] Exception :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}

		log.debug("\n======================================" +
				  "\n[textForRD]" +
				  "\n======================================" +
				  "\n" + textForRD.toString() +
				  "\n======================================\n");
		return textForRD.toString();
	}

	/**
	 * EES_CTM_0426 : retrieving related data to be saved after sending fax
	 *
	 * @param CimCStockVO cimCStockVO
	 * @return List<CimCStockVO>
	 * @exception EventException
	 */
	public List<CimCStockVO> searchForSendFaxEmail(CimCStockVO cimCStockVO) throws EventException {
		List<CimCStockVO> returnList = new ArrayList<CimCStockVO>();

		/*  {issue_flag} I:Issue , R:Reissue , C:cancel  */
		/*  {issue_type} F:Fax , E:EMail, P:Print, D:EDI  */
		try {
			/* Release */
			/* C */
			if (cimCStockVO.getTypeCd().equals("C")) {
				/* Issued */
				if (cimCStockVO.getIssueFlag().equals("I")) {
					log.info("\n\n=================================== dbDao.searchFaxEmailReleaseCIssued");
					returnList = dbDao.searchFaxEmailReleaseCIssued(cimCStockVO);

				/* Re-Issue : RESEND, CORRECTION, CANCEL */
				} else {
					log.info("\n\n=================================== dbDao.searchFaxEmailReleaseCReissued");
					returnList = dbDao.searchFaxEmailReleaseCReissued(cimCStockVO);
				}

			/* M */
			} else if (cimCStockVO.getTypeCd().equals("M")) {
				/* Issued */
				if (cimCStockVO.getIssueFlag().equals("I")) {
					log.info("\n\n=================================== dbDao.searchFaxEmailReleaseMIssued");
					returnList = dbDao.searchFaxEmailReleaseMIssued(cimCStockVO);

				/* Re-Issue : RESEND, CORRECTION, CANCEL */
				} else {
					log.info("\n\n=================================== dbDao.searchFaxEmailReleaseMReissued");
					returnList = dbDao.searchFaxEmailReleaseMReissued(cimCStockVO);
				}

			/* R, S */
			} else if (cimCStockVO.getTypeCd().equals("R") || cimCStockVO.getTypeCd().equals("S")) {
				/* Issued */
				if (cimCStockVO.getIssueFlag().equals("I")) {
					log.info("\n\n=================================== dbDao.searchFaxEmailReleaseRSIssued");
					returnList = dbDao.searchFaxEmailReleaseRSIssued(cimCStockVO);

				/* Re-Issue : RESEND, CORRECTION, CANCEL */
				} else {
					log.info("\n\n=================================== dbDao.searchFaxEmailReleaseRSReissued");
					returnList = dbDao.searchFaxEmailReleaseRSReissued(cimCStockVO);
				}

			/* D */
			} else if (cimCStockVO.getTypeCd().equals("D")) {
				/* Issued */
				if (cimCStockVO.getIssueFlag().equals("I")) {
					log.info("\n\n=================================== dbDao.searchFaxEmailReleaseDIssued");
					returnList = dbDao.searchFaxEmailReleaseDIssued(cimCStockVO);

				/* Re-Issue : RESEND, CORRECTION, CANCEL */
				} else {
					log.info("\n\n=================================== dbDao.searchFaxEmailReleaseDReissued");
					returnList = dbDao.searchFaxEmailReleaseDReissued(cimCStockVO);
				}
			}

		} catch (DAOException ex) {
			log.error("\n\n[BCImpl - searchForSendFaxEmail] DAOException :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch(Exception ex) {
			log.error("\n\n[BCImpl - searchFaxInfo] Exception :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}
		return returnList;
	}

	/**
	 * EES_CTM_0426 : handling multiple event about fax result(STOCK table)
	 *
	 * @param List<CimCStockVO> cimCStockVOs
	 * @exception EventException
	 */
	public void manageSTKsendFaxEmail(List<CimCStockVO> cimCStockVOs) throws EventException {
		List<CimCStockVO> insertSTKList = new ArrayList<CimCStockVO>();
		List<CimCStockVO> updateSTKList = new ArrayList<CimCStockVO>();
		List<CimCStockVO> deleteSTKList = new ArrayList<CimCStockVO>();

		/*  {issue_flag} I:Issue , R:Reissue , C:cancel  */
		/*  {issue_type} F:Fax , E:EMail, P:Print, D:EDI  */
		try {
			for (int i=0; i<cimCStockVOs.size(); i++) {
				cimCStockVOs.get(i).setSpclInst(cimCStockVOs.get(i).getSpclInst().replaceAll("'", "^#^"));

				/* ISSUE */
				if (cimCStockVOs.get(0).getIssueFlag().equals("I")) {
					insertSTKList.add(cimCStockVOs.get(i));

				/* REISSUE */
				} else {
					// in case of Cancel
					if (cimCStockVOs.get(0).getIssueFlag().equals("C")) {
						deleteSTKList.add(cimCStockVOs.get(i));

					// in case of Resend, Update
					} else {
						updateSTKList.add(cimCStockVOs.get(i));
					}
				}
			}
			if ( insertSTKList.size() > 0 ) {
				dbDao.addManageSTKSendFaxEmails(insertSTKList);
			}
			if ( deleteSTKList.size() > 0 ) {
				dbDao.removeManageSTKSendFaxEmails(deleteSTKList);
			}
			if ( updateSTKList.size() > 0 ) {
				dbDao.modifyManageSTKSendFaxEmails(updateSTKList);
			}

		} catch (DAOException ex) {
			log.error("\n\n[BCImpl - manageSTKsendFaxEmail] DAOException :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch(Exception ex) {
			log.error("\n\n[BCImpl - manageSTKsendFaxEmail] Exception :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}
	}

	/**
	 * EES_CTM_0426 : retrieving loc_cd for user ID 
	 *
	 * @param String userId
	 * @return String
	 * @exception EventException
	 */
	public String getUserLocCd(String userId) throws EventException {
		try {
			return dbDao.getUserLocCd(userId);
		} catch (DAOException ex) {
			log.error("\n\n[BCImpl - getUserLocCd] DAOException :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch(Exception ex) {
			log.error("\n\n[BCImpl - getUserLocCd] Exception :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}
	}

	/**
	 * EES_CTM_0426 : retrieving So_Ofc and NextVAL for Redelivery-M-Issued
	 *
	 * @param String userOfcCd
	 * @return String[]
	 * @exception EventException
	 */
	public String[] getSoOfcNextVal(String userOfcCd) throws EventException {
		try {
			return dbDao.getSoOfcNextVal(userOfcCd);
		} catch (DAOException ex) {
			log.error("\n\n[BCImpl - getSoOfcNextVal] DAOException :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch(Exception ex) {
			log.error("\n\n[BCImpl - getSoOfcNextVal] Exception :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}
	}

	/**
	 * EES_CTM_0426 : getting FAX No and  Email for Yard Code
	 *
	 * @param String yardCd
	 * @return String[]
	 * @throws EventException
	 */
	public String[] getYardFaxEmailInfo(String yardCd) throws EventException {
		try {
			String[] returnValues = dbDao.getYardFaxEmailInfo(yardCd);
			if (returnValues[0] == null || returnValues[0].trim().equals("")) {
				throw new EventException(new ErrorHandler("CTM10001", new String[]{"yard code"}).getMessage());
			}
			return returnValues;
		} catch (EventException ex) {
			log.error("\n\n[BCImpl - getYardFaxEmailInfo] EventException :\n" + ex.getMessage(), ex);
			throw ex;
		} catch (DAOException ex) {
			log.error("\n\n[BCImpl - getYardFaxEmailInfo] DAOException :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch(Exception ex) {
			log.error("\n\n[BCImpl - getYardFaxEmailInfo] Exception :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}
	}

	/**
	 * BackEndJob - returning BackEndJob status
	 *
	 * @param String key
	 * @return String
	 * @exception EventException
	 */
	public String comBackEndJob(String key) throws EventException {
		try {
			DBRowSet rowSet = new BackEndJobMetaDataSelector(key).getDbRowset();
			rowSet.next();
			Thread.sleep(1000);
			return (String) rowSet.getObject("jb_sts_flg");
		} catch (BackEndJobException e) {
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getUserMessage(),e);
		} catch (SQLException e) {
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getUserMessage(),e);
		} catch (InterruptedException e) {
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getUserMessage(),e);
		} catch(Exception e){
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getUserMessage(),e);
		}
	}

	/**
	 * EES_CTM_0429 : starting BackEndJob
	 *
	 * @param SignOnUserAccount account
	 * @param CimCStockVO cimCStockVO
	 * @return String
	 * @exception EventException, BackEndJobException
	 */
	public String doBackEndJobSettledOrderList(SignOnUserAccount account, CimCStockVO cimCStockVO) {
		EmptyReleaseRedeliveryOderMgtSettledOrderBackEndJob backEndResult = new EmptyReleaseRedeliveryOderMgtSettledOrderBackEndJob();
		BackEndJobManager backEndJobManager = new BackEndJobManager();
		backEndResult.setCimCStockVO(cimCStockVO, account);
		return backEndJobManager.execute(backEndResult, account.getUsr_id(),"EES_CTM_0429 Back End");
	}

	/**
	 * EES_CTM_0429 : retrieving CimCStock SettledOrderList
	 *
	 * @param String key
	 * @return List<CimCStockVO>
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public List<CimCStockVO> searchSettledOrderList(String key) throws EventException {
		try {
			return (List<CimCStockVO>)BackEndJobResult.loadFromFile(key);
		} catch (BackEndJobException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CTM10024",new String[]{""}).getMessage() ,ex);
	    } catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CTM10024",new String[]{""}).getMessage() ,ex);
		}
	}

	/**
	 * EES_CTM_0429 : handling multiple event for SettledOrderList (STOCK table)
	 *
	 * @param CimCStockVO[] cimCStockVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageSTKRecovery(CimCStockVO[] cimCStockVOs, SignOnUserAccount account) throws EventException {
		List<CimCStockVO> deleteList = new ArrayList<CimCStockVO>();
		try {
			for (int i=0; i<cimCStockVOs.length; i++) {
				cimCStockVOs[i].setUserId(account.getUsr_id());
				deleteList.add(cimCStockVOs[i]);
			}

			if ( deleteList.size() > 0 ) {
				dbDao.manageSTKRecoverys(deleteList);
			}

		} catch (DAOException ex) {
			log.error("\n\n[BCImpl - manageSTKRecovery] DAOException :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch(Exception ex) {
			log.error("\n\n[BCImpl - manageSTKRecovery] Exception :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}
	}

	/**
	 * EES_CTM_0426 : RD Fax/Mail Send (btn_confirm in EES_CTM_0451)
	 *
	 * @param String issueType
	 * @param RDFaxMailEAIVO rdFaxMailEAIVO
	 * @return String
	 * @exception EventException
	 */
	public String rdFaxMailSend(String issueType, RDFaxMailEAIVO rdFaxMailEAIVO) throws EventException {
		String returnValue = "";
		try {
			// retrieving Seq for saving RD Content
			String stkFaxSndNo = dbDao.getCimFaxMailSendSeq();
			// saving RD Content
			dbDao.addCimFaxSndInfo(stkFaxSndNo, rdFaxMailEAIVO.getRdContent(), issueType, rdFaxMailEAIVO.getSenderUsrId());
			// setting parameters to send from RD server to MRD
			rdFaxMailEAIVO.setTmplParam(rdFaxMailEAIVO.getTmplParam() + "  /rpost [stk_fax_snd_no=" + stkFaxSndNo + "]");

			eaiDao = new EmptyReleaseRedeliveryOrderMgtEAIDAO();

			if ("F".equals(issueType)) {    // sending RD Fax
				returnValue = eaiDao.rdFaxSend(rdFaxMailEAIVO);

			} else if ("E".equals(issueType)) {    // sending RD Mail
				String userDefaultEmail = dbDao.getUserDefaultEmail(rdFaxMailEAIVO.getSenderUsrId());
				rdFaxMailEAIVO.setSenderUsrDefaultEml(userDefaultEmail);
				returnValue = eaiDao.rdMailSend(rdFaxMailEAIVO);
			}

			// updating Fax/Mail key to saved RD content
			dbDao.modifyCimFaxSndInfo(stkFaxSndNo, returnValue);

		} catch (DAOException ex) {
			log.error("\n\n[BCImpl - rdFaxMailSend] DAOException :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch(Exception ex) {
			log.error("\n\n[BCImpl - rdFaxMailSend] Exception :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}
		return returnValue;
	}

	/**
	 * EES_CTM_0426 : retrieving RD Content
	 *
	 * @param String stkFaxSndNo
	 * @return String
	 * @exception EventException
	 */
	public String searchCimFaxSndInfo(String stkFaxSndNo) throws EventException {
		try {
			return dbDao.searchCimFaxSndInfo(stkFaxSndNo);
		} catch (DAOException ex) {
			log.error("\n\n[BCImpl - searchCimFaxSndInfo] DAOException :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch(Exception ex) {
			log.error("\n\n[BCImpl - searchCimFaxSndInfo] Exception :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}
	}

	/**
	 * CTM Common : updating STOCK in case server is EUR when registering CTM MOVEMENT
	 *
	 * @param CrossItemVO crossItemVO
	 */
	public void updateCimCntrStk(CrossItemVO crossItemVO) {
		try {
			dbDao.updateCimCntrStk(crossItemVO);
		} catch (DAOException ex) {
			/******************************************************
			 * no throwing in case of failure for handling next data *
			 ******************************************************/
			log.error("\n\n[BCImpl - updateCimCntrStk] DAOException :\n" + ex.getMessage(), ex);
		} catch (Exception ex) {
			/******************************************************
			 * no throwing in case of failure for handling next data *
			 ******************************************************/
			log.error("\n\n[BCImpl - updateCimCntrStk] Exception :\n" + ex.getMessage(), ex);
		}
	}
	
	/**
	 * EES_CTM_0426 : EDI Send (EES_CTM_0451의 btn_confirm)
	 *
	 * @param CimCStockVO[] cimCStockVOs
	 * @return String
	 * @exception EventException
	 */
	public String sendEdi(CimCStockVO[] cimCStockVOs) throws EventException {
		String returnValue = "";
		try {
			StringBuilder flatFile = new StringBuilder();
//			//RCV ID 조회
//			String rcvId = dbDao.searchEdiRcvId(cimCStockVOs[0].getEmptyCy());
//			//SND ID 조회
//			String sndId = dbDao.searchEdiSndId(rcvId);
//			//header 생성
//			// 2014.02.27 FRLEH의 특정 Yard는 Receive ID를 Hard Coding
//			// Empty Release-Redelivery Order  - Msg Type별  Receiver ID 각각 생성 - CHM-201429045
//			if(cimCStockVOs[0].getEmptyCy().equals("FRLEH01") || cimCStockVOs[0].getEmptyCy().equals("FRLEH02") || cimCStockVOs[0].getEmptyCy().equals("FRLEH03")
//					  || cimCStockVOs[0].getEmptyCy().equals("FRLEH20") || cimCStockVOs[0].getEmptyCy().equals("FRLEH31") || cimCStockVOs[0].getEmptyCy().equals("FRLEHM1")
//					  || cimCStockVOs[0].getEmptyCy().equals("FRLEHM2") || cimCStockVOs[0].getEmptyCy().equals("FRLEHY5") )
//			{
//					  if(cimCStockVOs[0].getType().equals("RLS") )
//					  {
//					    rcvId = "SOGET";
//					  }
//					  else if(cimCStockVOs[0].getType().equals("RDV") )
//					  {
//					    rcvId = "SOGET-COPARN";
//					  }
//			}
//			log.debug("rcvId : " + rcvId);
			
			//String header = dbDao.searchEdiHeader(rcvId, sndId);
			//StringBuilder header = buildEdiHeader(cimCStockVOs);
			//Status 생성
			String isssueFlag = new String();
			if("I".equals(cimCStockVOs[0].getIssueFlag())){
				isssueFlag = "N";
			}else if("R".equals(cimCStockVOs[0].getIssueFlag())){
				isssueFlag = "U";
			}else if("O".equals(cimCStockVOs[0].getIssueFlag())){
				isssueFlag = "U";
			}else if("C".equals(cimCStockVOs[0].getIssueFlag())){
				isssueFlag = "C";
			}
			
			for(int i = 0; i < cimCStockVOs.length; i++){
				// 2014.03.27 강 환   [CHM-201429550] RELRED FF 변경 (WO가 다르면 FF각각 생성)
//				if(i == 0 || (i < cimCStockVOs.length && !(cimCStockVOs[i-1].getBkgNo().equals(cimCStockVOs[i].getBkgNo())))){
				if(i == 0 || (i < cimCStockVOs.length && ( !(cimCStockVOs[i-1].getBkgNo().equals(cimCStockVOs[i].getBkgNo())) || 
						!(cimCStockVOs[i-1].getWoNo().equals(cimCStockVOs[i].getWoNo()))) 
						) ){
					
					//각종 desc 조회
					String[] desc = dbDao.searchEdiDesc(cimCStockVOs[i].getEmptyCy(), cimCStockVOs[i].getVvd(), cimCStockVOs[i].getPol(), cimCStockVOs[i].getPod());
					String[] bkgBooking = dbDao.searchBkgBookingforEdi(cimCStockVOs[i].getBkgNo());
					
					// FLAT FILE header 생성
					flatFile.append(buildEdiHeader(cimCStockVOs) + "\n");
					flatFile.append("STATUS:" + isssueFlag + "\n");
					flatFile.append("BOUND:" + cimCStockVOs[i].getBd() + "\n");
					//append columns 2014.10.29
					if ("RLS".equals(cimCStockVOs[i].getType())) { // release
						flatFile.append("MSG_ID:MTRELORD\n");
						flatFile.append("EQREL:" + cimCStockVOs[i].getEmptyCy() + "\n");
						flatFile.append("EQREL_LOC:" + desc[7] + "\n");
						flatFile.append("EQREL_NAME:" + desc[8] + "\n");
						flatFile.append("EQRES:\n");
						flatFile.append("EQRES_LOC:\n");
						flatFile.append("EQRES_NAME:\n");
					} else {                                       // redelivery
						flatFile.append("MSG_ID:MTRESORD\n");
						flatFile.append("EQREL:\n");
						flatFile.append("EQREL_LOC:\n");
						flatFile.append("EQREL_NAME:\n");
						flatFile.append("EQRES:" + cimCStockVOs[i].getEmptyCy() + "\n");
						flatFile.append("EQRES_LOC:" + desc[7] + "\n");
						flatFile.append("EQRES_NAME:" + desc[8] + "\n");

					}
					
					flatFile.append("MTY_CY:" + cimCStockVOs[i].getEmptyCy() + "\n");
					flatFile.append("MTY_CY_DESC:" + desc[0] + "\n");
					flatFile.append("BKG_NO:" + cimCStockVOs[i].getBkgNo() + "\n");
					flatFile.append("BL_NO:" + cimCStockVOs[i].getBlNo() + "\n");
					// 2014.03.06 강 환   [CHM-201429214] RELRED F/F 변경 (Line change 수정, W/O 추가)
					flatFile.append("WO_NO:" + cimCStockVOs[i].getWoNo() + "\n");
					flatFile.append("VSL_CALL:" + desc[1] + "\n");
					//append columns 2014.10.29
					flatFile.append("VSL_LOYD:" + desc[9] + "\n");
					
					flatFile.append("VSL_NAME:" + desc[2] + "\n");
					flatFile.append("VVD:" + cimCStockVOs[i].getVvd() + "\n");
					//append columns 2014.10.29
					if ("RLS".equals(cimCStockVOs[i].getType())) { // release
						flatFile.append("CONSORT_VOY:" + desc[10] + "\n");
					} else {                                       // redelivery
						flatFile.append("CONSORT_VOY:" + desc[11] + "\n");
					}
					
					flatFile.append("POL:" + cimCStockVOs[i].getPol() + "\n");
					flatFile.append("POL_DESC:" + desc[3] + "\n");
					flatFile.append("POD:" + cimCStockVOs[i].getPod() + "\n");
					flatFile.append("POD_DESC:" + desc[4] + "\n");
					flatFile.append("VVD_ETD:" + desc[5] + "\n");
					flatFile.append("VVD_ETA:" + desc[6] + "\n");
					flatFile.append("SHPR:" + cimCStockVOs[i].getShpr() + "\n");
					flatFile.append("CNEE:" + cimCStockVOs[i].getCnee() + "\n");
					flatFile.append("NTFY:" + cimCStockVOs[i].getNtfy() + "\n");
					flatFile.append("HAUL_TYPE:"+ cimCStockVOs[i].getTypeCd()  + "\n");
					// 2014.03.04 강 환   [CHM-201428983] RELRED Flat File Layout 에 SHIP_OPR 추가
					flatFile.append("SHIP_OPR:"+ cimCStockVOs[i].getShipOpr()  + "\n");
					flatFile.append("DR_IND:" + bkgBooking[0] + "\n");
					flatFile.append("RF_IND:" + bkgBooking[1] + "\n");
					flatFile.append("AK_IND:" + bkgBooking[2] + "\n");
				}
				//bkg_rf_cgo 테이블 정보 조회
				String[] bkgRfCgo = dbDao.searchBkgRfCgoforEdi(cimCStockVOs[i].getBkgNo(), cimCStockVOs[i].getCntrNo());
				
				//bkg_awk_cgo 테이블 정보 조회
				String[] bkgAwkCgo = dbDao.searchBkgAwkCgoforEdi(cimCStockVOs[i].getBkgNo(), cimCStockVOs[i].getCntrNo());
				
				//bkg_container 테이블 정보 조회
				String[] bkgContainer = dbDao.searchBkgContainerforEdi(cimCStockVOs[i].getBkgNo(), cimCStockVOs[i].getCntrNo());
				
				//bkg_dg_cgo 테이블 정보 조회
				List<BkgDgCgoforEdiVO> bkgDgCgoVOs = dbDao.searchBkgDgCgoforEdi(cimCStockVOs[i].getBkgNo(), cimCStockVOs[i].getCntrNo());
				
				//PD_DT 날짜 형식 변환(yyyy-mm-dd => yyyyMMdd)
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				Date pdDate = format.parse(cimCStockVOs[i].getPdDate());
				format = new SimpleDateFormat("yyyyMMdd");
				String pdDt = format.format(pdDate).toString();
				
				flatFile.append("{RELRED_INFO\n");
				flatFile.append("VENDOR:" + cimCStockVOs[i].getVndrLglEngNm() + "\n");
				flatFile.append("TRANS_MODE:" + cimCStockVOs[i].getModeCd() + "\n");
				flatFile.append("PD_DT:" +  pdDt + "\n");
				flatFile.append("SPCL_INST:" + cimCStockVOs[i].getSpclInst() + "\n");
				flatFile.append("CNTR_NO:" + cimCStockVOs[i].getCntrNo() + "\n");
				flatFile.append("CNTR_TYPE:" + cimCStockVOs[i].getTp() + "\n");
				//append columns 2014.10.29
				flatFile.append("CARGOTYPE:M\n");
				if(bkgDgCgoVOs.size() > 0){
					//append columns 2014.10.29
					flatFile.append("SEAL:" + bkgContainer[4] + "\n");
				}else{
					//append columns 2014.10.29
					flatFile.append("SEAL:" + "\n");
				}
				
				flatFile.append("CNTR_QTY:" + cimCStockVOs[i].getQty() + "\n");
				// 2014.12.02 fix indicator by cargo type
				if(bkgDgCgoVOs.size() > 0){
					flatFile.append("DIND:Y"  + "\n");
				}else{
					flatFile.append("DIND:N"  + "\n");
				}
				if(bkgRfCgo[10].equalsIgnoreCase("TRUE")){
					flatFile.append("RIND:Y" + "\n");
				}else {
					flatFile.append("RIND:N" + "\n");
				} 
				if(bkgAwkCgo[17].equalsIgnoreCase("TRUE")){
					flatFile.append("AIND:Y" + "\n");
				}else{
					flatFile.append("AIND:N" + "\n");
				}
				flatFile.append("TEMP_F:" + bkgRfCgo[0] + "\n");
				flatFile.append("TEMP_C:" + bkgRfCgo[1] + "\n");
				flatFile.append("RF_VOLTAGE:" + bkgRfCgo[2] + "\n");
				flatFile.append("VENT:" + bkgRfCgo[7] + "\n");
				flatFile.append("VENT_CMH:" + bkgRfCgo[9] + "\n");
				flatFile.append("VENT_PCT:" + bkgRfCgo[8] + "\n");
				flatFile.append("HUMID:" + bkgRfCgo[3] + "\n");
				flatFile.append("GENSET:" + bkgRfCgo[6] + "\n");
				flatFile.append("RF_REMARK:" + bkgRfCgo[4] + "\n");
				if(bkgDgCgoVOs.size() > 0){
					flatFile.append("RFDRY_IND:" + bkgContainer[3] + "\n");
				}else{
					flatFile.append("RFDRY_IND:" + "\n");
				}
				flatFile.append("RF_DRAIN:" + bkgRfCgo[5] + "\n");
				flatFile.append("OVF:" + bkgAwkCgo[0] + "\n");
				flatFile.append("OVR:" + bkgAwkCgo[1] + "\n");
				flatFile.append("OVH:" + bkgAwkCgo[2] + "\n");
				flatFile.append("OVLW:" + bkgAwkCgo[3] + "\n");
				flatFile.append("OVRW:" + bkgAwkCgo[4] + "\n");
				flatFile.append("OVWGT:" + bkgAwkCgo[9] + "\n");
				flatFile.append("VOID_SLOT:" + bkgAwkCgo[5] + "\n");
				flatFile.append("STWG_REQ:" + bkgAwkCgo[10] + "\n");
				flatFile.append("TTL_DIM_LEN:" + bkgAwkCgo[6] + "\n");
				flatFile.append("TTL_DIM_WDT:" + bkgAwkCgo[7] + "\n");
				flatFile.append("TTL_DIM_HGT:" + bkgAwkCgo[8] + "\n");

				//append columns 2014.10.29
				flatFile.append("GWGTUNIT:" + bkgAwkCgo[11].toUpperCase() + "\n"); // 2014.12.02 to upper case
				flatFile.append("GWGT:" + bkgAwkCgo[12] + "\n");
				flatFile.append("TWGTUNIT:" + bkgAwkCgo[13] + "\n");
				flatFile.append("TWGT:" + bkgAwkCgo[14] + "\n");
				flatFile.append("CMD:" + bkgAwkCgo[15] + "\n");
				flatFile.append("CMDD:" + bkgAwkCgo[16] + "\n");
				
				if(bkgDgCgoVOs.size() > 0){
					for(int j = 0; j < bkgDgCgoVOs.size(); j++){
						flatFile.append("{CNTR_DANGER\n");
						flatFile.append("UNBR:" + bkgDgCgoVOs.get(j).getImdgUnNo() + "\n");
						flatFile.append("CLAS:" + bkgDgCgoVOs.get(j).getImdgClssCd() + "\n");
						flatFile.append("DESC:" + bkgDgCgoVOs.get(j).getPrpShpNm() + "\n");
						//append columns 2014.10.29
						flatFile.append("TECH_NM:" + bkgDgCgoVOs.get(j).getHzdDesc() + "\n");
						
						flatFile.append("PHON:" + bkgDgCgoVOs.get(j).getEmerCntcPhnNoCtnt() + "\n");
						flatFile.append("FPNT:" + bkgDgCgoVOs.get(j).getFlshPntCdoTemp() + "\n");
						flatFile.append("FPUN:C" + "\n");
						flatFile.append("DG_REMARK:" + bkgDgCgoVOs.get(j).getDiffRmk() + "\n");
						flatFile.append("EMSNO:" + bkgDgCgoVOs.get(j).getEmsNo() + "\n");
						flatFile.append("PSACLS:" + bkgDgCgoVOs.get(j).getPsaNo() + "\n");
						flatFile.append("PKGGRP:" + bkgDgCgoVOs.get(j).getImdgPckGrpCd() + "\n");
						flatFile.append("MAR_POLL:" + bkgDgCgoVOs.get(j).getMrnPolutFlg() + "\n");
						flatFile.append("HAZ_CONT:" + bkgDgCgoVOs.get(j).getHzdDesc() + "\n");
						flatFile.append("IMO_LIMIT:" + bkgDgCgoVOs.get(j).getImdgLmtQtyFlg() + "\n");
						flatFile.append("}CNTR_DANGER\n");
					}
				}else{
					flatFile.append("{CNTR_DANGER\n");
					flatFile.append("UNBR:" + "\n");
					flatFile.append("CLAS:" + "\n");
					flatFile.append("DESC:" + "\n");
					//append columns 2014.10.29
					flatFile.append("TECH_NM:" + "\n");
					
					flatFile.append("PHON:" + "\n");
					flatFile.append("FPNT:" + "\n");
					flatFile.append("FPUN:C" + "\n");
					flatFile.append("DG_REMARK:" + "\n");
					flatFile.append("EMSNO:" + "\n");
					flatFile.append("PSACLS:" + "\n");
					flatFile.append("PKGGRP:" + "\n");
					flatFile.append("MAR_POLL:" + "\n");
					flatFile.append("HAZ_CONT:" + "\n");
					flatFile.append("IMO_LIMIT:"+ "\n");
					flatFile.append("}CNTR_DANGER\n");
				}
				flatFile.append("}RELRED_INFO\n");
		
				// 2014.03.27 강 환   [CHM-201429550] RELRED FF 변경 (WO가 다르면 FF각각 생성 후 각각 발송)
				if(i == (cimCStockVOs.length - 1) || (i < (cimCStockVOs.length - 1) && 
						( !(cimCStockVOs[i].getBkgNo().equals(cimCStockVOs[i+1].getBkgNo()) ) ) ||
						!(cimCStockVOs[i].getWoNo().equals(cimCStockVOs[i+1].getWoNo())))	)
//				if(i == 0 || (i < cimCStockVOs.length && ( !(cimCStockVOs[i-1].getBkgNo().equals(cimCStockVOs[i].getBkgNo())) || 
//						!(cimCStockVOs[i-1].getWoNo().equals(cimCStockVOs[i].getWoNo()))) ) 
				{
					log.debug(">>>>>>>>>>>>>>>>>>>>>>>>>"+flatFile);
					eaiDao.sendEdi(flatFile.toString());
					flatFile = new StringBuilder();
				}
			}
		} catch (EAIException ex) {
			log.error("\n\n[BCImpl - sendEdi] EAIException :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch(Exception ex) {
			log.error("\n\n[BCImpl - sendEdi] Exception :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}
		return returnValue;
	}	
	
	/**
	 * EES_CTM_0426 : send<br>
	 * EDI Yard Setup이 되어있는지 확인합니다.<br>
	 *
	 * @param String yardCd
	 * @return String
	 * @exception EventException
	 */
	public String checkEdiYardSetup(String yardCd) throws EventException {
		try {
			//RCV ID 조회
			String rcvId = dbDao.searchEdiRcvId(yardCd);
			//SND ID 조회
			String sndId = dbDao.searchEdiSndId(rcvId);
			if(!"".equals(rcvId) && !"".equals(sndId)){
				return "Y";
			}else {
				return "N";
			}
		} catch (DAOException ex) {
			log.error("\n\n[BCImpl - searchTerritoryList] DAOException :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch(Exception ex) {
			log.error("\n\n[BCImpl - searchTerritoryList] Exception :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}
	}

	
	/**
	 * EES_CTM_0426 : EDI Send (EES_CTM_0451의 btn_confirm)
	 * generate EDI header
	 * modify business logic from generating EDI header by SQL to generating EDI header using common module
	 *
	 * @param CimCStockVO[] cimCStockVOs
	 * @return String
	 * @exception EventException
	 */
	private StringBuilder buildEdiHeader(CimCStockVO[] cimCStockVOs) throws EventException {
		StringBuilder header =  new StringBuilder();
		try {
				//RCV ID 조회
				String rcvId = dbDao.searchEdiRcvId(cimCStockVOs[0].getEmptyCy());
				//SND ID 조회
				String sndId = dbDao.searchEdiSndId(rcvId);
				//header 생성
				// 2014.02.27 FRLEH의 특정 Yard는 Receive ID를 Hard Coding
				// Empty Release-Redelivery Order  - Msg Type별  Receiver ID 각각 생성 - CHM-201429045
				if(cimCStockVOs[0].getEmptyCy().equals("FRLEH01") || cimCStockVOs[0].getEmptyCy().equals("FRLEH02") || cimCStockVOs[0].getEmptyCy().equals("FRLEH03")
						  || cimCStockVOs[0].getEmptyCy().equals("FRLEH20") || cimCStockVOs[0].getEmptyCy().equals("FRLEH31") || cimCStockVOs[0].getEmptyCy().equals("FRLEHM1")
						  || cimCStockVOs[0].getEmptyCy().equals("FRLEHM2") || cimCStockVOs[0].getEmptyCy().equals("FRLEHY5") )
				{
						  if(cimCStockVOs[0].getType().equals("RLS") ) {
						    rcvId = "SOGET";
						  } else if(cimCStockVOs[0].getType().equals("RDV") ) {
						    rcvId = "SOGET-COPARN";
						  }
				}
				log.debug("rcvId : " + rcvId);
				
				//String header = dbDao.searchEdiHeader(rcvId, sndId);
		
		//		String referenceNumber = ReferenceNumberGeneratorBroker.getKey("CTM","CTM_EDI_SEQ");
		//		SELECT '$$$MSGSTART:'||
		//	           RPAD(NVL(TRIM(@[snd_id]),' '),20,' ')||
		//	           RPAD(NVL(TRIM(@[rcv_id]),' '),20,' ')||
		//	           RPAD(NVL(TRIM('RELRED'),' '),10,' ')||
		//	           'CTM'||TO_CHAR(SYSTIMESTAMP,'rrmmddHH24MISSFF3') STR_FLATFILE
		//          FROM DUAL
		
		//		SELECT '$$$MSGSTART:'||
		//		        RPAD(NVL(TRIM(@[sndr_id]),' '),20,' ')||
		//		        RPAD(NVL(TRIM(@[rcv_id]),' '),20,' ')||
		//		        RPAD(NVL(TRIM(@[msg_id]),' '),10,' ')||
		//		        RPAD(NVL(TRIM('BKG'),' '),3)||
		//		        TO_CHAR(SYSDATE,'rrmmdd')||
		//		        LTRIM(TO_CHAR(BKG_EDI_SEQ.nextval,'000009'),' ') STR_FLATFILE
		//		FROM DUAL
		
				header.append("$$$MSGSTART:");
				header.append(StringUtils.rightPad(StringUtils.trimToEmpty(sndId), 20, " "));
				header.append(StringUtils.rightPad(StringUtils.trimToEmpty(rcvId), 20, " "));
				if(cimCStockVOs[0].getTypeCd().equalsIgnoreCase("R")) {// C : C/H, M : M/H, R : MT REPO, S : S/T, D : DOMESTIC
					// 2015.01.14 
					//header.append(StringUtils.rightPad("MTREPO", 10, " "));
					  if(cimCStockVOs[0].getType().equals("RLS") ) {
						  header.append(StringUtils.rightPad("EPPREL", 10, " "));
					  } else if(cimCStockVOs[0].getType().equals("RDV") ) {
						  header.append(StringUtils.rightPad("EPPRES", 10, " "));
					  }
				} else {
					header.append(StringUtils.rightPad("RELRED", 10, " "));
				}
				header.append(ReferenceNumberGeneratorBroker.getKey("CTM","CTM_EUR_EDI_MSG_SEQ"));
		} catch(Exception ex) {
			log.error("\n\n[BCImpl - sendEdi] Exception :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}
		return header;
	}
	
}
