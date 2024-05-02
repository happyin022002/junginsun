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
package com.clt.apps.opus.esd.trs.workordermanage.emptyreleaseredeliveryordermgt.basic;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.CrossItemVO;
import com.clt.apps.opus.esd.trs.workordermanage.emptyreleaseredeliveryordermgt.integration.EmptyReleaseRedeliveryOrderMgtDBDAO;
import com.clt.apps.opus.esd.trs.workordermanage.emptyreleaseredeliveryordermgt.integration.EmptyReleaseRedeliveryOrderMgtEAIDAO;
import com.clt.apps.opus.esd.trs.workordermanage.emptyreleaseredeliveryordermgt.vo.CimCStockVO;
import com.clt.apps.opus.esd.trs.workordermanage.emptyreleaseredeliveryordermgt.vo.MdmCountryVO;
import com.clt.apps.opus.esd.trs.workordermanage.emptyreleaseredeliveryordermgt.vo.MdmOrganizationVO;
import com.clt.apps.opus.esd.trs.workordermanage.emptyreleaseredeliveryordermgt.vo.RDFaxMailEAIVO;
import com.clt.apps.opus.esd.trs.workordermanage.emptyreleaseredeliveryordermgt.vo.SearchFaxInfoVO;
import com.clt.apps.opus.esd.trs.workordermanage.emptyreleaseredeliveryordermgt.vo.SearchRelredMasterForEdiVO;
import com.clt.apps.opus.esd.trs.workordermanage.workorderpreview.basic.WorkOrderPreviewBC;
import com.clt.apps.opus.esd.trs.workordermanage.workorderpreview.basic.WorkOrderPreviewBCImpl;
import com.clt.apps.opus.esd.trs.workordermanage.workorderpreview.event.EsdTrs0024Event;
import com.clt.apps.opus.esd.trs.workordermanage.workorderpreview.vo.WorkOrderPreviewVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.SendFlatFileVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.basic.GeneralBookingSearchBC;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.basic.GeneralBookingSearchBCImpl;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.Vender301ParamVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.basic.TransferOrderIssueBC;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.basic.TransferOrderIssueBCImpl;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.EurTroMtyRelByCtmVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration.CargoReleaseOrderDBDAO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.FullCntrRlseOrderEdiSendVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.FullCntrRlseOrderEdiYdVO;
import com.clt.bizcommon.edi.broker.ReferenceNumberGeneratorBroker;
import com.clt.framework.component.backend.support.BackEndJobException;
import com.clt.framework.component.backend.support.BackEndJobMetaDataSelector;
import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.config.SubSystemConfigFactory;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.framework.utility.CheckUtilities;
import com.clt.syscommon.common.table.MdmYardVO;

/**
 * OPUS-EmptyReleaseRedeliveryOrderMgt Business Logic Basic Command implementation<br>
 * handling business logic for OPUS-EmptyReleaseRedeliveryOrderMgt
 * 
 * @author
 * @see ESD_TRS_0428EventResponse, EmptyReleaseRedeliveryOrderMgtBC DAO class reference
 * @see ESD_TRS_0451EventResponse, EmptyReleaseRedeliveryOrderMgtBC DAO class reference
 * @see ESD_TRS_0429EventResponse, EmptyReleaseRedeliveryOrderMgtBC DAO class reference
 * @since J2EE 1.6
 */
public class EmptyReleaseRedeliveryOrderMgtBCImpl extends BasicCommandSupport implements EmptyReleaseRedeliveryOrderMgtBC {

	private transient EmptyReleaseRedeliveryOrderMgtDBDAO dbDao = null;
	private transient EmptyReleaseRedeliveryOrderMgtEAIDAO eaiDao = null;
	private transient CargoReleaseOrderDBDAO fullDbDao = null;
	private static final String DEFAULT_USR_EML_ADR = "shipment.info@notifications.nykline.com";
	String NEW_LINE = "\n";

	/**
	 * creating EmptyReleaseRedeliveryOrderMgtBCImpl Object creating EmptyReleaseRedeliveryOrderMgtDBDAO
	 */
	public EmptyReleaseRedeliveryOrderMgtBCImpl() {
		dbDao = new EmptyReleaseRedeliveryOrderMgtDBDAO();
		eaiDao = new EmptyReleaseRedeliveryOrderMgtEAIDAO();
		fullDbDao = new CargoReleaseOrderDBDAO();
	}

	/**
	 * ESD_TRS_0428 : retrieving Country List
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
			throw new EventException(new ErrorHandler("COM12240", new String[] { "" }).getMessage(), ex);
		} catch (Exception ex) {
			log.error("\n\n[BCImpl - selectComboCountry] Exception :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] { "" }).getMessage(), ex);
		}
	}

	/**
	 * ESD_TRS_0428 : retrieving Organization List
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
			throw new EventException(new ErrorHandler("COM12240", new String[] { "" }).getMessage(), ex);
		} catch (Exception ex) {
			log.error("\n\n[BCImpl - selectComboOrganization] Exception :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] { "" }).getMessage(), ex);
		}
	}

	/**
	 * ESD_TRS_0429 : retrieving CimCStock IssueList
	 * 
	 * @param CimCStockVO cimCStockVO
	 * @return List<CimCStockVO>
	 * @exception EventException
	 */
	public List<AbstractValueObject> searchIssueList(CimCStockVO cimCStockVO) throws EventException {
		List<AbstractValueObject> searchList = new ArrayList<AbstractValueObject>();
		try {
			if (cimCStockVO.getType().equals("RLS")) {
				searchList = dbDao.searchIssuedReleaseList(cimCStockVO);
			} else if (cimCStockVO.getType().equals("RDV")) {
				searchList = dbDao.searchIssuedReDeliveryList(cimCStockVO);
			}
			return searchList;
		} catch (DAOException ex) {
			log.error("\n\n[BCImpl - searchIssueList] DAOException :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] { "" }).getMessage(), ex);
		} catch (Exception ex) {
			log.error("\n\n[BCImpl - searchIssueList] Exception :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] { "" }).getMessage(), ex);
		}

	}

	/**
	 * ESD_TRS_0429 : settling CimCStock IssuedOrder
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
			for (int i = 0; i < cimCStockVOs.length; i++) {
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

					for (int k = 0; k < settleList.size(); k++) {
						settleList.get(k).setUserId(account.getUsr_id());
						settleList.get(k).setEmptyCy(cimCStockVOs[i].getEmptyCy());
						settleList.get(k).setBd(cimCStockVOs[i].getBd());
						settleList.get(k).setTypeCd(cimCStockVOs[i].getTypeCd());
						settleList.get(k).setUserId(account.getUsr_id());
						settleList.get(k).setUserLoc(userLoc);
					}
					if (settleList.size() > 0) {
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
			if (cimCStockVOs[0].getType().equals("RDV") && cimCStockVOs.length > 0) {
				dbDao.modifySettleIssuedOrders(settleList);
			}

		} catch (DAOException ex) {
			log.error("\n\n[BCImpl - settleIssuedOrder] DAOException :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] { "" }).getMessage(), ex);
		} catch (Exception ex) {
			log.error("\n\n[BCImpl - settleIssuedOrder] Exception :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] { "" }).getMessage(), ex);
		}
	}

	/**
	 * ESD_TRS_0429 : retrieving fax information for RD
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
		String crrCntrTpszDesc = "";
		String crrPdDate = "";
		String crrModeCd = "";
		String crrVndrLglEngNm = "";
		String crrSpclInst = "";
		String crrCntrNo = "";
		String crrRefId = "";
		String crrCntrSltNo = "";
		String tpVal = "";
		String crrTrspCostDtlModCd = "";
		int sumQty = 0;
		
		try {
			tpVal = cimCStockVOs[0].getType(); // Type : RLS/RDV
			crrTrspCostDtlModCd = cimCStockVOs[0].getTrspCostDtlModCd(); // ER/DR/CY/LS/TS
			for (int i = 0; i < cimCStockVOs.length; i++) {
				cimCStockVOs[i].setUserId(cimCStockVOs[0].getUserId());
				if ("M".equals(cimCStockVOs[i].getTypeCd())) {
					cimCStockVOs[i].setVndrLglEngNm("Merchant Haulage");
				}
				searchFaxInfoList.addAll(dbDao.searchFaxInfoDetailList(cimCStockVOs[i]));
			}
			if (searchFaxInfoList.isEmpty() || (searchFaxInfoList.size() < cimCStockVOs.length)) {
				throw new EventException(new ErrorHandler("COM12199", new String[] { "user info detail list" }).getMessage());
			}
			String userLoc = dbDao.getUserLocCd(cimCStockVOs[0].getUserId());
			if (userLoc == null || "".equals(userLoc)) {
				throw new EventException(new ErrorHandler("COM12199", new String[] { "user loc code" }).getMessage());
			}
			String[] faxInfoHeader = dbDao.searchFaxInfoHeader(userLoc, cimCStockVOs[0].getUserOfc(), cimCStockVOs[0].getUserCnt());
			if (faxInfoHeader == null || faxInfoHeader.length < 1) {
				throw new EventException(new ErrorHandler("COM12199", new String[] { "RD header data" }).getMessage());
			}

			// == Header Content (S) =======================================================
			textForRD.append(tpVal + dl);
			textForRD.append(crrTrspCostDtlModCd + dl);
			textForRD.append(faxInfoHeader[0] + dl); // OFC_ENG_NM
			textForRD.append(faxInfoHeader[1] + dl); // ADDRESS
			textForRD.append(faxInfoHeader[2] + dl); // LOCAL_TIME

			textForRD.append(searchFaxInfoList.get(0).getYdNm() + dl);
			textForRD.append(searchFaxInfoList.get(0).getYdPicNm() + dl);
			textForRD.append(searchFaxInfoList.get(0).getPhnNo() + dl);
			textForRD.append(searchFaxInfoList.get(0).getUserInfo() + dl);
			textForRD.append(cimCStockVOs[0].getEmail() + dl);
			textForRD.append(cimCStockVOs[0].getFaxNo() + dl + "\n");
			// == Header Content (E) =======================================================

			// Sort to arrange CNTR by CNTR No & Type
			Arrays.sort(cimCStockVOs, new Comparator<CimCStockVO>() {
				public int compare(CimCStockVO arg0, CimCStockVO arg1) {
					int compareVaue1 = CheckUtilities.isNullOrNullStringReplacement(arg0.getCntrNo(), "").compareTo(CheckUtilities.isNullOrNullStringReplacement(arg1.getCntrNo(), ""));
					int compareVaue2 = CheckUtilities.isNullOrNullStringReplacement(arg0.getTp(), "").compareTo(CheckUtilities.isNullOrNullStringReplacement(arg1.getTp(), ""));
					return compareVaue1 > 0 ? compareVaue1 : (compareVaue1 == 0 ? compareVaue2 : -1);
				}
			});
			
			DBRowSet ds = null;
			/* looping for length of cimCStockVOs. */
			for (int i = 0; i < cimCStockVOs.length; i++) {
				typeCd = cimCStockVOs[i].getTypeCd(); // Type_CD : C/M/R/D/S
				crrBkgNo = cimCStockVOs[i].getBkgNo();
				crrBlNo = cimCStockVOs[i].getBlNo();
				crrWoNo = cimCStockVOs[i].getWoNo();
				crrShpr = cimCStockVOs[i].getShpr();
				if ("RLS".equals(tpVal)) {
					sumQty = Integer.parseInt(CheckUtilities.isNullOrNullStringReplacement(cimCStockVOs[i].getQty(), "1"));
				} else {
					sumQty = 1;
				}
				crrCntrTpszDesc = searchFaxInfoList.get(i).getCntrTpszDesc();
				crrPdDate = cimCStockVOs[i].getPdDate();
				crrModeCd = cimCStockVOs[i].getModeCd();
				crrVndrLglEngNm = cimCStockVOs[i].getVndrLglEngNm();
				crrSpclInst = cimCStockVOs[i].getSpclInst();
				crrCntrNo = CheckUtilities.isNullOrNullStringReplacement(cimCStockVOs[i].getCntrNo(), "");
				crrRefId = CheckUtilities.isNullOrNullStringReplacement(cimCStockVOs[i].getRefId(), "");
				crrCntrSltNo = CheckUtilities.isNullOrNullStringReplacement(cimCStockVOs[i].getCntrSltNo(), "");
				boolean dupBkgBlWo = false;
				if (i < 1) {
					prtBkgNo = crrBkgNo;
					prtBlNo = crrBlNo;
					prtWoNo = crrWoNo;
					prtShpr = crrShpr;

				} else {
					// checking BkgNo, BlNo, WoNo, Shpr are same with previous line
					// omitting duplicated item for RD
					if ("RLS".equals(tpVal)) { // Release
						if (!"".equals(crrBkgNo)) { // comparing bkg_no
							if (crrBkgNo.equals(cimCStockVOs[i - 1].getBkgNo())) {
								dupBkgBlWo = true;
							} else { // comparing wo_no
								prtBkgNo = crrBkgNo;
							}
						} else {
							if (crrWoNo.equals(cimCStockVOs[i - 1].getWoNo())) {
								dupBkgBlWo = true;
							} else {
								prtWoNo = crrWoNo;
							}
						}
					} else { // Rederivery
						if (!"".equals(crrBlNo)) { // comparing bkg_no
							if (crrBlNo.equals(cimCStockVOs[i - 1].getBlNo())) {
								dupBkgBlWo = true;
							} else {
								prtBlNo = crrBlNo;
							}
						} else { // comparing wo_no
							if (crrWoNo.equals(cimCStockVOs[i - 1].getWoNo())) {
								dupBkgBlWo = true;
							} else {
								prtWoNo = crrWoNo;
							}
						}
					}

					if (!dupBkgBlWo && !crrShpr.equals(cimCStockVOs[i - 1].getShpr())) {
						prtShpr = crrShpr;
					}
				}

				for (int k = i + 1; k < cimCStockVOs.length; k++) {
					// checking BkgNo, BlNo, WoNo are same with next line
					boolean subDupBkgBlWo = false;
					if ("RLS".equals(tpVal)) { // Release
						if (!"".equals(crrBkgNo)) { // comparing bkg_no
							if (crrBkgNo.equals(cimCStockVOs[k].getBkgNo())) {
								subDupBkgBlWo = true;
							}
						} else { // comparing wo_no
							if (crrWoNo.equals(cimCStockVOs[k].getWoNo())) {
								subDupBkgBlWo = true;
							}
						}
					} else { // Rederivery
						if (!"".equals(crrBlNo)) { // comparing bl_no
							if (crrBlNo.equals(cimCStockVOs[k].getBlNo())) {
								subDupBkgBlWo = true;
							}
						} else { // comparing wo_no
							if (crrWoNo.equals(cimCStockVOs[k].getWoNo())) {
								subDupBkgBlWo = true;
							}
						}
					}
					// checking Type/Size, Qty, P/Up Date, Trans Mode, VndrLglEngNm, SpclInst, Cntr No, Slot Ref No are same with next line
					if (subDupBkgBlWo && crrShpr.equals(cimCStockVOs[k].getShpr()) && crrCntrTpszDesc.equals(searchFaxInfoList.get(k).getCntrTpszDesc()) && crrPdDate.equals(cimCStockVOs[k].getPdDate()) && crrModeCd.equals(cimCStockVOs[k].getModeCd())
							&& crrVndrLglEngNm.equals(cimCStockVOs[k].getVndrLglEngNm()) && crrSpclInst.equals(cimCStockVOs[k].getSpclInst()) && crrCntrNo.equals(cimCStockVOs[k].getCntrNo()) && crrCntrSltNo.equals(cimCStockVOs[k].getCntrSltNo())) {
						// in case of duplicated line
						if ("RLS".equals(tpVal)) {
							sumQty = sumQty + Integer.parseInt(CheckUtilities.isNullOrNullStringReplacement(cimCStockVOs[k].getQty(), "1"));
						} else {
							sumQty = sumQty + 1;
						}
						i = k;
					} else {
						break;
					}
				}
				// == Body Content (S) =======================================================
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
				textForRD.append(crrCntrNo + dl);
				textForRD.append(crrRefId + dl);
				textForRD.append(crrCntrSltNo + dl);

				ds = dbDao.searchOLInfo(crrBkgNo, crrCntrNo);
				if (ds.next()) {
					textForRD.append(ds.getString("ovr_fwrd_len") + dl);
					textForRD.append(ds.getString("ovr_bkwd_len") + dl);
					textForRD.append(ds.getString("ovr_lf_len") + dl);
					textForRD.append(ds.getString("ovr_rt_len") + dl);
					textForRD.append(ds.getString("ovr_hgt") + dl + "\n");
				} else {
					textForRD.append("" + dl);
					textForRD.append("" + dl);
					textForRD.append("" + dl);
					textForRD.append("" + dl);
					textForRD.append("" + dl + "\n");
				}

				// == Body Content (E) =======================================================
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
			throw new EventException(new ErrorHandler("COM12240", new String[] { "" }).getMessage(), ex);
		} catch (Exception ex) {
			log.error("\n\n[BCImpl - searchFaxInfo] Exception :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] { "" }).getMessage(), ex);
		}

		log.debug("\n======================================" + "\n[textForRD]" + "\n======================================" + "\n" + textForRD.toString() + "\n======================================\n");
		return textForRD.toString();
	}

	/**
	 * ESD_TRS_0429 : retrieving related data to be saved after sending fax
	 * 
	 * @param CimCStockVO cimCStockVO
	 * @return List<CimCStockVO>
	 * @exception EventException
	 */
	public List<CimCStockVO> searchForSendFaxEmail(CimCStockVO cimCStockVO) throws EventException {
		List<CimCStockVO> returnList = new ArrayList<CimCStockVO>();
		/* {issue_type} F:Fax , E:EMail, P:Print */
		try {
			/* Release */
			/* C */
			if (cimCStockVO.getTypeCd().equals("C")) {
				log.info("\n\n=================================== dbDao.searchFaxEmailReleaseCReissued");
				returnList = dbDao.searchFaxEmailReleaseCReissued(cimCStockVO);
				/* M */
			} else if (cimCStockVO.getTypeCd().equals("M")) {
				log.info("\n\n=================================== dbDao.searchFaxEmailReleaseMReissued");
				returnList = dbDao.searchFaxEmailReleaseMReissued(cimCStockVO);
				/* R, S */
			} else if (cimCStockVO.getTypeCd().equals("R") || cimCStockVO.getTypeCd().equals("S")) {
				log.info("\n\n=================================== dbDao.searchFaxEmailReleaseRSReissued");
				returnList = dbDao.searchFaxEmailReleaseRSReissued(cimCStockVO);
			}
		} catch (DAOException ex) {
			log.error("\n\n[BCImpl - searchForSendFaxEmail] DAOException :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] { "" }).getMessage(), ex);
		} catch (Exception ex) {
			log.error("\n\n[BCImpl - searchFaxInfo] Exception :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] { "" }).getMessage(), ex);
		}
		return returnList;
	}

	/**
	 * ESD_TRS_0429 : retrieving loc_cd for user ID
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
			throw new EventException(new ErrorHandler("COM12240", new String[] { "" }).getMessage(), ex);
		} catch (Exception ex) {
			log.error("\n\n[BCImpl - getUserLocCd] Exception :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] { "" }).getMessage(), ex);
		}
	}

	/**
	 * ESD_TRS_0429 : retrieving So_Ofc and NextVAL for Redelivery-M-Issued
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
			throw new EventException(new ErrorHandler("COM12240", new String[] { "" }).getMessage(), ex);
		} catch (Exception ex) {
			log.error("\n\n[BCImpl - getSoOfcNextVal] Exception :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] { "" }).getMessage(), ex);
		}
	}

	/**
	 * ESD_TRS_0429 : getting FAX No and Email for Yard Code
	 * 
	 * @param String yardCd
	 * @return String[]
	 * @throws EventException
	 */
	public String[] getYardFaxEmailInfo(String yardCd) throws EventException {
		try {
			String[] returnValues = dbDao.getYardFaxEmailInfo(yardCd);
			if (returnValues[0] == null || returnValues[0].trim().equals("")) {
				throw new EventException(new ErrorHandler("COM12199", new String[] { "yard code" }).getMessage());
			}
			return returnValues;
		} catch (EventException ex) {
			log.error("\n\n[BCImpl - getYardFaxEmailInfo] EventException :\n" + ex.getMessage(), ex);
			throw ex;
		} catch (DAOException ex) {
			log.error("\n\n[BCImpl - getYardFaxEmailInfo] DAOException :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] { "" }).getMessage(), ex);
		} catch (Exception ex) {
			log.error("\n\n[BCImpl - getYardFaxEmailInfo] Exception :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] { "" }).getMessage(), ex);
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
			throw new EventException(new ErrorHandler("COM12240", new String[] { "" }).getUserMessage(), e);
		} catch (SQLException e) {
			throw new EventException(new ErrorHandler("COM12240", new String[] { "" }).getUserMessage(), e);
		} catch (InterruptedException e) {
			throw new EventException(new ErrorHandler("COM12240", new String[] { "" }).getUserMessage(), e);
		} catch (Exception e) {
			throw new EventException(new ErrorHandler("COM12240", new String[] { "" }).getUserMessage(), e);
		}
	}

	/**
	 * ESD_TRS_0429 : retrieving RD Content
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
			throw new EventException(new ErrorHandler("COM12240", new String[] { "" }).getMessage(), ex);
		} catch (Exception ex) {
			log.error("\n\n[BCImpl - searchCimFaxSndInfo] Exception :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] { "" }).getMessage(), ex);
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
	 * checkEdiYardSetup
	 * 
	 * @param cimCStockVO
	 * @return
	 */
	public String checkEdiYardSetup(SearchRelredMasterForEdiVO cimCStockVO) {
		String rsltValue = "N";
		String rcvId = "";
		String sndId = "";
		try {
			rcvId = dbDao.searchEdiRcvId(cimCStockVO); // RCV ID 조회
			if (!CheckUtilities.isInBlank(rcvId)) {
				sndId = dbDao.searchEdiSndId(rcvId, cimCStockVO); // SND ID 조회
			}
		} catch (Exception e) {
			log.error("\n\n[BCImpl - checkEdiYardSetup] Exception : " + e.getMessage());
		}
		if (!"".equals(rcvId) && !"".equals(sndId)) {
			rsltValue = "Y";
		}
		return rsltValue;
	}

	/**
	 * Header 생성.
	 * 
	 * @param cimCStockVO
	 * @return
	 * @throws EventException
	 */
	private String buildEdiHeader(SearchRelredMasterForEdiVO cimCStockVO) throws EventException {
		StringBuilder header = new StringBuilder("$$$MSGSTART:");
		String rcvId = "";
		String sndId = "";
		try {
			rcvId = dbDao.searchEdiRcvId(cimCStockVO);
			if (CheckUtilities.isInBlank(rcvId)) {
				return null;
			} else {
				sndId = dbDao.searchEdiSndId(rcvId, cimCStockVO);
			}
			header.append(StringUtils.rightPad(sndId, 20, " "));
			header.append(StringUtils.rightPad(rcvId, 20, " "));
			/*
			 * RELRED Header Creation Logic
			 * 1. MTY Repo case
			 *   1) Empty Release    : EPPREL
			 *   2) Empty Redelivery : EPPRES
			 * 2. Full Door case
			 *   1) Empty Release    : RELRED
			 *   2) Empty Redelivery : RELRED
			 * 3. Full CY case
			 *   1) Full Release     : RELREDCY
			 *   2) Full Restitution : RELRED
			 */
			if ("R".equals(cimCStockVO.getTypeCd())) { // Empty Release/Redelivery Order(MTY)
				if ("RLS".equals(cimCStockVO.getType())) {
					header.append(StringUtils.rightPad("EPPREL", 10, " "));
				} else {
					header.append(StringUtils.rightPad("EPPRES", 10, " "));
				}
			} else {
				if ("FULLRELORD".equals(cimCStockVO.getMsgId())) { // Full Release Order
					header.append(StringUtils.rightPad("RELREDCY", 10, " "));
				} else { // Empty Redelivery Order(FULL), Full Restitution Order
					header.append(StringUtils.rightPad("RELRED", 10, " "));
				}
			}
			header.append(ReferenceNumberGeneratorBroker.getKey("TRS", "TRS_RELRED_EDI_MSG_SEQ"));
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240", new String[] { "" }).getMessage(), ex);
		}
		return header.toString();
	}

	/**
	 * 
	 * @param event
	 * @param previewVO
	 * @param relRedVo
	 * @param account
	 * @return
	 * @throws EventException
	 */
	public String[] makeFlatFileReleaseReDelivery(EsdTrs0024Event event, WorkOrderPreviewVO previewVO, SearchRelredMasterForEdiVO relRedVo, SignOnUserAccount account) throws EventException {
		String[] s = new String[2];
		DBRowSet relredInfoRs = null;
		CimCStockVO cimCStockVO = new CimCStockVO();
		StringBuilder flatFile = new StringBuilder();

		try {
			String checkEdiYard = checkEdiYardSetup(relRedVo);
			MdmYardVO mdmYardVO = dbDao.searchMdmYardInfo(relRedVo.getEmptyCy());

			if ("Y".equals(checkEdiYard)) {
				if (!(("I".equals(relRedVo.getTrspBndCd()) && "MTRELORD".equals(relRedVo.getMsgId())) || ("O".equals(relRedVo.getTrspBndCd()) && "MTRESORD".equals(relRedVo.getMsgId())))) {
					flatFile.insert(0, buildEdiHeader(relRedVo) + NEW_LINE);
					flatFile = makeFlatFileMst(relRedVo, flatFile); // RELRED Master F/F 생성
				}
			}
			// 2015.10.12 CHAN WOO PARK
			// 301F EDI 로직 추가
			// DG Booking : Approval 전에는 발송 X.
			// Non-DG Booking : 무조건 발송.
			// Door RELRED인 경우만 301F 발송
			if ("O".equals(relRedVo.getTrspBndCd()) && "MTRESORD".equals(relRedVo.getMsgId()) && "Y".equals(dbDao.getDgCfmFlg(relRedVo.getBkgNo()))) {
				send301Fedi(relRedVo, account);
			}
			
			relredInfoRs = dbDao.searchRelredInfoForEdi(previewVO.getWoPrvGrpSeq(), previewVO.getWoIssNo());	
			if (relredInfoRs == null || relredInfoRs.getRowCount() == 0) {
				return s;
			}
			mappingCimCStokVo(relRedVo, cimCStockVO);

			ArrayList<CimCStockVO> emlArr = new ArrayList<CimCStockVO>();
			ArrayList<CimCStockVO> faxArr = new ArrayList<CimCStockVO>();
			while (relredInfoRs.next()) {
				cimCStockVO.setSoOfcCtyCd(relredInfoRs.getString("trsp_so_ofc_cty_cd"));
				cimCStockVO.setSoSeq(relredInfoRs.getString("trsp_so_seq"));
				cimCStockVO.setBd(relredInfoRs.getString("trsp_bnd_cd"));
				cimCStockVO.setWoIssStsCd(relredInfoRs.getString("wo_iss_sts_cd"));
				cimCStockVO.setTroSeq(relredInfoRs.getString("tro_seq"));
				cimCStockVO.setTp(relredInfoRs.getString("cntr_type"));
				cimCStockVO.setCntrNo(relredInfoRs.getString("cntr_no"));
				cimCStockVO.setEqNo(relredInfoRs.getString("cntr_no"));
				cimCStockVO.setUserId(account.getUsr_id());
				cimCStockVO.setUserOfc(account.getOfc_cd());
				cimCStockVO.setUserCnt(account.getCnt_cd());
				cimCStockVO.setFaxNo(mdmYardVO.getFaxNo());
				cimCStockVO.setEmail(mdmYardVO.getYdEml());
				cimCStockVO.setRefId(relredInfoRs.getString("ref_id"));
				cimCStockVO.setPdDate(relredInfoRs.getString("pd_dt"));
				cimCStockVO.setCntrSltNo(relredInfoRs.getString("cntr_slt_no"));
				cimCStockVO.setSpclInst(relredInfoRs.getString("so_spcl_inst"));
				cimCStockVO.setTrspCostDtlModCd(relRedVo.getTrspCostDtlModCd());
				cimCStockVO.setStkIssCd("");

				if (!("C".equals(relRedVo.getTypeCd()) && ("I".equals(relRedVo.getTrspBndCd()) && "MTRELORD".equals(relRedVo.getMsgId())) 
						|| ("O".equals(relRedVo.getTrspBndCd()) && "MTRESORD".equals(relRedVo.getMsgId())))) {
					if ("Y".equals(checkEdiYard)) {
						flatFile = makeFlatFileInfo(relredInfoRs, flatFile); // RELRED Info F/F 생성
						cimCStockVO.setStkIssCd("D"); // EDI
					} else if (cimCStockVO.getEmail() != null && cimCStockVO.getEmail().length() > 0) {
						if (CheckUtilities.isInBlank(cimCStockVO.getStkIssCd())) {
							cimCStockVO.setStkIssCd("E");
							// sendRelRedEmlFax(event, cimCStockVO, mdmYardVO, 'E');
							emlArr.add((CimCStockVO) cimCStockVO.clone());
						}
					} else if (cimCStockVO.getFaxNo() != null && cimCStockVO.getFaxNo().length() > 0) {
						if (CheckUtilities.isInBlank(cimCStockVO.getStkIssCd())) {
							cimCStockVO.setStkIssCd("F");
							// sendRelRedEmlFax(event, cimCStockVO, mdmYardVO, 'F');
							faxArr.add((CimCStockVO) cimCStockVO.clone());
						}
					}
					if ("Y".equals(checkEdiYard)) {
						manageCimCntrStk(cimCStockVO); // CIM_CNTR_STK [I/U/D]
					}
				}
				// 2015.08.17 CHAN WOO PARK
				// Full Container Release Order EDI 로직 추가
				if ("F".equals(relredInfoRs.getString("cargotype")) && "MTRELORD".equals(relRedVo.getMsgId()) && "I".equals(relredInfoRs.getString("trsp_bnd_cd"))) {
					sendCoreorEdi(relRedVo, relredInfoRs);
				}
			}

			// 2016.04.22 PCW
			// W/O Issue 시에만 RELRED Auto-trigger 수행
			if (!emlArr.isEmpty() && "N".equals(relRedVo.getStatus())) {
				CimCStockVO[] cimCStockVOs = new CimCStockVO[emlArr.size()];
				for (int j = 0; j < emlArr.size(); j++) {
					cimCStockVOs[j] = emlArr.get(j);
				}
				String sendEmlFaxNo = sendRelRedEmlFax(event, cimCStockVOs, mdmYardVO, 'E');
				for (int j = 0; j < cimCStockVOs.length; j++) {
					cimCStockVOs[j].setEmlSndNo(sendEmlFaxNo);
					dbDao.updateFaxEmlSndNo(cimCStockVOs[j]);
				}
			}
			// 2016.04.22 PCW
			// W/O Issue 시에만 RELRED Auto-trigger 수행
			if (!faxArr.isEmpty() && "N".equals(relRedVo.getStatus())) {
				CimCStockVO[] cimCStockVOs = new CimCStockVO[faxArr.size()];
				for (int j = 0; j < faxArr.size(); j++) {
					cimCStockVOs[j] = faxArr.get(j);
				}
				String sendEmlFaxNo = sendRelRedEmlFax(event, cimCStockVOs, mdmYardVO, 'F');
				for (int j = 0; j < cimCStockVOs.length; j++) {
					cimCStockVOs[j].setFaxSndNo(sendEmlFaxNo);
					dbDao.updateFaxEmlSndNo(cimCStockVOs[j]);
				}
			}

			// 2015.10.12 CHAN WOO PARK
			// OutBound MTRESORD, InBound MTRELORD는 발송 안하도록 수정
			// 2016.03.31 CHAN WOO PARK
			// RELRED인 경우만 차단하도록 수정. EPPREL/EPPRES는 전부 발송.
			if (!"R".equals(relRedVo.getTypeCd()) && ("I".equals(relRedVo.getTrspBndCd()) && "MTRELORD".equals(relRedVo.getMsgId())) || ("O".equals(relRedVo.getTrspBndCd()) && "MTRESORD".equals(relRedVo.getMsgId()))) {
				return s;
			}
			relredInfoRs = null;
			log.debug("ReleaseReDelivery : " + flatFile.toString());
			s[0] = flatFile.toString();
			return s;
		} catch (Exception ex) {
			log.error("\n\n[BCImpl - sendEdi] Exception :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] { "" }).getMessage(), ex);
		}
	}

	/**
	 * 
	 * @param event
	 * @param cimCStockVO
	 * @param mdmYardVO
	 * @param SendType
	 * @return
	 */
	private String sendRelRedEmlFax(EsdTrs0024Event event, CimCStockVO[] cimCStockVO, MdmYardVO mdmYardVO, char SendType) {
		RDFaxMailEAIVO rdFaxMailEAIVO = new RDFaxMailEAIVO();
		String sndNo = "";
		try {
			String mailTitle = null;
			String xFileNm = null;
			if ("R".equals(cimCStockVO[0].getTypeCd())) { // Empty Release/Redelivery Order(MTY)
				if ("RLS".equals(cimCStockVO[0].getType())) { // Release
					mailTitle = "EMPTY RELEASE ORDER";
					xFileNm = "EMPTYRELEASEORDER";
				} else { // Redelivery
					mailTitle = "EMPTY REDELIVERY ORDER";
					xFileNm = "MTYDELIVERYORDER";
				}
			} else {
				if ("RLS".equals(cimCStockVO[0].getType())) { // Release
					if ("DR".equals(cimCStockVO[0].getTrspCostDtlModCd())) { // Empty Release Order(FULL)
						mailTitle = "EMPTY RELEASE ORDER";
						xFileNm = "EMPTYRELEASEORDER";
					} else { // Full Release Order
						mailTitle = "FULL RELEASE ORDER";
						xFileNm = "FULLRELEASEORDER";
					}
				} else { // Redelivery
					if ("DR".equals(cimCStockVO[0].getTrspCostDtlModCd())) { // Empty Redelivery Order(FULL)
						mailTitle = "EMPTY REDELIVERY ORDER";
						xFileNm = "MTYDELIVERYORDER";
					} else { // Full Restitution Order
						mailTitle = "FULL RESTITUTION ORDER";
						xFileNm = "FULLRESTITUTIONORDER";
					}
				}
			}
			if (!CheckUtilities.isInBlank(cimCStockVO[0].getBkgNo())) { // BKG No 가 없을 경우 MTY Reference No 를 사용
				rdFaxMailEAIVO.setTitle(mailTitle + " for Shipment reference " + cimCStockVO[0].getBkgNo());
			} else {
				rdFaxMailEAIVO.setTitle(mailTitle + " for Shipment reference " + cimCStockVO[0].getRefId());
			}
			rdFaxMailEAIVO.setSubSysCd("TRS");
			rdFaxMailEAIVO.setTmplMrd("ESD_TRS_0451.mrd");
			rdFaxMailEAIVO.setRdContent(searchRDContent(cimCStockVO));
			rdFaxMailEAIVO.setReceiverEml(cimCStockVO[0].getEmail());
			rdFaxMailEAIVO.setReceiverFax(cimCStockVO[0].getFaxNo());
			rdFaxMailEAIVO.setReceiverNm(mdmYardVO.getYdNm());
			rdFaxMailEAIVO.setSenderUsrId(cimCStockVO[0].getUserId());
			rdFaxMailEAIVO.setSenderUsrCnt(cimCStockVO[0].getUserCnt());
			rdFaxMailEAIVO.setSenderUsrOfc(cimCStockVO[0].getUserOfc());
			rdFaxMailEAIVO.setSenderUsrNm(cimCStockVO[0].getUserId());
			rdFaxMailEAIVO.setXfileNm(xFileNm);
			rdFaxMailEAIVO.setTmplParam("/rp [] /rfn [" + event.getRdserverIp() + "/ESD_TRS_0451_RD.do]");
			if (SendType == 'E') {
				sndNo = rdFaxMailSend("E", rdFaxMailEAIVO);
				cimCStockVO[0].setEmlSndNo(sndNo);
			} else if (SendType == 'F') {
				sndNo = rdFaxMailSend("F", rdFaxMailEAIVO);
				cimCStockVO[0].setFaxSndNo(sndNo);
			}
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return sndNo;
	}

	/**
	 * 
	 * @param SearchRelredMasterForEdiVO relRedVo
	 * @param CimCStockVO cimCStockVO
	 */
	private void mappingCimCStokVo(SearchRelredMasterForEdiVO relRedVo, CimCStockVO cimCStockVO) {
		Class<?> origin = relRedVo.getClass();
		Class<?> dest = cimCStockVO.getClass();
		Field[] field = dest.getDeclaredFields();
		Object fieldValueObject = null;
		String name = null;
		for (Field f : field) {
			name = f.getName();
			if (!f.isAccessible()) {
				f.setAccessible(true);
			}
			Field originField = null;
			try {
				originField = origin.getDeclaredField(name);
			} catch (NoSuchFieldException ne) {
				continue;
			}
			try {
				if (originField != null && !Modifier.isStatic(originField.getModifiers()) && !Modifier.isFinal(originField.getModifiers())) {
					if (!originField.isAccessible()) {
						originField.setAccessible(true);
						fieldValueObject = originField.get(relRedVo);
					} else {
						fieldValueObject = originField.get(relRedVo);
					}
					f.set(cimCStockVO, fieldValueObject);
				}
			} catch (Exception e) {
				continue;
			}
		}
	}

	/**
	 * 
	 * @param String issueType
	 * @param RDFaxMailEAIVO rdFaxMailEAIVO
	 * @return String
	 * @exception EventException
	 */
	public String rdFaxMailSend(String issueType, RDFaxMailEAIVO rdFaxMailEAIVO) throws EventException {
		String returnValue = null;
		try {
			if ("F".equals(issueType)) {
				String stkFaxSndNo = dbDao.getCimFaxMailSendSeq();
				dbDao.addCimFaxSndInfo(stkFaxSndNo, rdFaxMailEAIVO.getRdContent(), issueType, rdFaxMailEAIVO.getSenderUsrId());
				rdFaxMailEAIVO.setTmplParam(rdFaxMailEAIVO.getTmplParam() + "  /rpost [stk_fax_snd_no=" + stkFaxSndNo + "]");
				returnValue = eaiDao.rdFaxSend(rdFaxMailEAIVO);
				dbDao.modifyCimFaxSndInfo(stkFaxSndNo, returnValue);
			} else if ("E".equals(issueType)) {
				String emlSndNo = dbDao.getCimFaxMailSendSeq();
				dbDao.addCimFaxSndInfo(emlSndNo, rdFaxMailEAIVO.getRdContent(), issueType, rdFaxMailEAIVO.getSenderUsrId());
				rdFaxMailEAIVO.setTmplParam(rdFaxMailEAIVO.getTmplParam() + "  /rpost [stk_fax_snd_no=" + emlSndNo + "]");
				String userDefaultEmail = DEFAULT_USR_EML_ADR;
				rdFaxMailEAIVO.setSenderUsrDefaultEml(userDefaultEmail);
				rdFaxMailEAIVO.setSenderUsrNm(userDefaultEmail);
				returnValue = eaiDao.rdMailSend(rdFaxMailEAIVO);
				dbDao.modifyCimFaxSndInfo(emlSndNo, returnValue);
			}
		} catch (DAOException ex) {
			log.error("\n\n[BCImpl - rdFaxMailSend] DAOException :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] { "" }).getMessage(), ex);
		} catch (Exception ex) {
			log.error("\n\n[BCImpl - rdFaxMailSend] Exception :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] { "" }).getMessage(), ex);
		}
		return returnValue;
	}

	/**
	 * 
	 * @param List<CimCStockVO> cimCStockVOs
	 * @exception EventException
	 */
	public void sendReleaseRedeliveryFaxEmail(List<CimCStockVO> cimCStockVOs) throws EventException {
		List<CimCStockVO> updateSTKList = new ArrayList<CimCStockVO>();
		List<CimCStockVO> deleteSTKList = new ArrayList<CimCStockVO>();

		try {
			String issueFlag = null;
			for (int i = 0; i < cimCStockVOs.size(); i++) {
				cimCStockVOs.get(i).setSpclInst(cimCStockVOs.get(i).getSpclInst().replaceAll("'", "^#^"));
				if (i == 0) {
					issueFlag = cimCStockVOs.get(i).getIssueFlag();
				}
				if ("I".equals(issueFlag) || "R".equals(issueFlag)) {
					updateSTKList.add(cimCStockVOs.get(i));
				} else if ("C".equals(issueFlag)) {
					deleteSTKList.add(cimCStockVOs.get(i));
				}
			}

			if (updateSTKList.size() > 0) {
				dbDao.modifySendReleaseRedeliveryFaxEmail(updateSTKList);
			}
			if (deleteSTKList.size() > 0) {
				dbDao.removeSendReleaseRedeliveryFaxEmail(deleteSTKList);
			}
		} catch (Exception ex) {
			log.error("\n\n[BCImpl - sendReleaseRedeliveryFaxEmail] Exception :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] { "" }).getMessage(), ex);
		}
	}

	/**
	 * 
	 * @param cimCStockVO
	 * @throws EventException
	 */
	private void manageCimCntrStk(CimCStockVO cimCStockVO) throws EventException {
		try {
			cimCStockVO.setSpclInst(cimCStockVO.getSpclInst().replaceAll("'", "^#^"));
			String woIssStsCd = cimCStockVO.getWoIssStsCd();
			if ("N".equals(woIssStsCd)) {
				dbDao.removeCimCntrStk(cimCStockVO);
			} else {
				dbDao.mergeCimCntrStk(cimCStockVO);
			}
		} catch (Exception ex) {
			log.error("\n\n[BCImpl - manageSTKsendFaxEmail] Exception :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] { "" }).getMessage(), ex);
		}
	}

	/**
	 * 
	 * @param woVO
	 * @param type
	 * @return
	 * @throws EventException
	 */
	public List<AbstractValueObject> searchRelRedMasterData(WorkOrderPreviewVO woVO, String type) throws EventException {
		try {
			return dbDao.searchRelredMasterForEdi(woVO, type);
		} catch (DAOException e) {
			throw new EventException(new ErrorHandler("COM12240", new String[] { "" }).getMessage(), e);
		}
	}

	/**
	 * 
	 * @param soVO
	 * @param type
	 * @return
	 * @throws EventException
	 */
	public List<AbstractValueObject> searchRelRedMasterData(CimCStockVO soVO, String type) throws EventException {
		try {
			return dbDao.searchRelredMasterForEdi(soVO, type);
		} catch (DAOException e) {
			throw new EventException(new ErrorHandler("COM12240", new String[] { "" }).getMessage(), e);
		}
	}

	/**
	 * ESD_TRS_0429 : EDI resend
	 * 
	 * @param relRedVo
	 * @param cimCStockVOs
	 * @return
	 * @throws EventException
	 */
	public String resendEdi(SearchRelredMasterForEdiVO relRedVo, CimCStockVO[] cimCStockVOs) throws EventException {
		String s = "";
		WorkOrderPreviewBC prvCommand = new WorkOrderPreviewBCImpl();
		DBRowSet relredInfoRs = null;
		StringBuilder flatFile = new StringBuilder();
		try {
			String checkEdiYard = checkEdiYardSetup(relRedVo);
			if ("N".equals(checkEdiYard)) {
				return s;
			} 
//			else if ("T".equals(checkEdiYard) && "O".equals(relRedVo.getTrspBndCd()) && "MTRELORD".equals(relRedVo.getMsgId())) { // 특정 Vendor인 경우 O/B MTRELORD(RELRED) 발송 x
//				return s;
//			}

			// RELRED F/F Header 생성
			String header = buildEdiHeader(relRedVo);
			flatFile.insert(0, header + NEW_LINE);

			// RELRED Master F/F 생성
			flatFile = makeFlatFileMst(relRedVo, flatFile);

			// RELRED Info 존재유무 조회
			relredInfoRs = dbDao.searchRelredInfoForEdi(cimCStockVOs);
			if (relredInfoRs == null || relredInfoRs.getRowCount() == 0) {
				return s;
			}

			// RELRED Info F/F 생성
			while (relredInfoRs.next()) {
				flatFile = makeFlatFileInfo(relredInfoRs, flatFile);
			}

			// RELRED EDI 발송
			log.debug("ReleaseReDelivery(Resend) : " + flatFile.toString());
			prvCommand.sendFlatMessage(flatFile.toString());
		} catch (Exception ex) {
			log.error("\n\n[BCImpl - sendEdi] Exception :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] { "" }).getMessage(), ex);
		}
		return s;
	}

	/**
	 * 301F Calling 메소드 OutBound, MTRESORD(Empty Restitution Order) : 301F 발송
	 * 
	 * @param relRedVo
	 * @param account
	 * @throws Exception
	 */
	public void send301Fedi(SearchRelredMasterForEdiVO relRedVo, SignOnUserAccount account) throws Exception {
		GeneralBookingSearchBC bkgCommand = new GeneralBookingSearchBCImpl();
		Vender301ParamVO vender301ParamVO = new Vender301ParamVO();

		// VO parameter 설정을 위한 변수 선언
		BkgBlNoVO bkgBlNoVO = new BkgBlNoVO();
		bkgBlNoVO.setBkgNo(relRedVo.getBkgNo()); // Booking Number

		// BKG 메소드 호출을 위한 VO Parameter 설정
		vender301ParamVO.setBkgBlNoVO(bkgBlNoVO); // BKG_NO : 필수
		vender301ParamVO.setAutoManualFlg("N"); // autoManualFlag : 필수

		// EDI Kind 설정
		DBRowSet bkg301EdiKind = dbDao.search301EdiKind(relRedVo.getBkgNo());
		while (bkg301EdiKind.next()) {
			vender301ParamVO.setEdiKind(bkg301EdiKind.getString("EDI_KIND"));
			// BKG쪽 Terminal EDI 발송용 BackEnd 메소드 호출
			bkgCommand.createTmlBkgReceiptEdiBackEnd(vender301ParamVO, account);
		}
	}

	/**
	 * COREOR Calling 메소드 InBound, MTRELORD(Empty Release Order)인 경우 COREOR 추가로 발송
	 * 
	 * @param relRedVo
	 * @param relredInfoRs
	 * @throws Exception
	 */
	public void sendCoreorEdi(SearchRelredMasterForEdiVO relRedVo, DBRowSet relredInfoRs) throws Exception {
		try {
			FullCntrRlseOrderEdiYdVO fullCntrRlseOrderEdiYdVo = null;
			FullCntrRlseOrderEdiSendVO fullCntrRlseOrderEdiSend = null;
			SendFlatFileVO sendFlatFileVO = null;
			BookingUtil bookingUtil = null;

			// 해당 Yard로 COREOR 발송 가능한지 확인
			fullCntrRlseOrderEdiYdVo = fullDbDao.searchEdiFullCntrRlseOrderYardCd(relRedVo.getEqrel());
			if (fullCntrRlseOrderEdiYdVo == null) {
				// Invalid EDI Yard Code
				log.debug("COREOR : No Yard Available");
				return;
			}

			fullCntrRlseOrderEdiSend = new FullCntrRlseOrderEdiSendVO();
			// 기본정보 세팅 : Booking No, Pickup Yard, VVD, Customer Name
			fullCntrRlseOrderEdiSend.setBkgNo(relredInfoRs.getString("bkg_no"));
			fullCntrRlseOrderEdiSend.setYdCd(relRedVo.getEqrel());
			fullCntrRlseOrderEdiSend.setVvd(relredInfoRs.getString("vvd"));
			fullCntrRlseOrderEdiSend.setCustNm(relredInfoRs.getString("cust_nm"));
			// 세부정보 세팅 : Container No, Pickup Date
			fullCntrRlseOrderEdiSend.setCntrNo(relredInfoRs.getString("cntr_no"));
			fullCntrRlseOrderEdiSend.setCgoPkupDt(relredInfoRs.getString("pd_dt").replace("-", ""));

			// EDI Reference Number 채번
			String referenceNumber = ReferenceNumberGeneratorBroker.getKey("BKG", "BKG_EDI_SEQ");

			// COREOR Header정보 생성
			String fullCgoHeader = fullDbDao.searchDoEdiHeader(fullCntrRlseOrderEdiYdVo.getSendId(), fullCntrRlseOrderEdiYdVo.getReceiverId(), referenceNumber, "COREOR");

			// CxlFlg 설정
			String brac = fullDbDao.searchEdiFullCntrRlseOrdBrac(fullCntrRlseOrderEdiSend);
			fullCntrRlseOrderEdiSend.setCxlFlg(brac);

			// COREOR 정보 생성
			String blInfo = fullDbDao.searchEdiFullCntrRlseOrderBlInfo(fullCntrRlseOrderEdiSend);
			String cntrInfo = fullDbDao.searchEdiFullCntrRlseOrderCntrInfo(fullCntrRlseOrderEdiSend);
			String eurInfo = fullDbDao.searchEdiFullCntRlseOrderEurDtlInfo(fullCntrRlseOrderEdiSend);
			String cntrSealNo = fullDbDao.searchEdiFullCntRlseOrderEurCntrSealNo(fullCntrRlseOrderEdiSend);
			String dgInfo = fullDbDao.searchEdiFullCntrRlseOrderDgInfo(relredInfoRs.getString("bkg_no"), relredInfoRs.getString("cntr_no"));

			// TransMode = WR/WT 일 경우 무조건 Barge로 변환
			String transMode = relredInfoRs.getString("trans_mode").substring(0, 1);
			if ("W".equals(transMode)) {
				transMode = "B";
			}

			String blCntr = fullDbDao.searchEdiFullCntrRlseOrderBlCntr(relredInfoRs.getString("bkg_no"), relredInfoRs.getString("cntr_no"), transMode);

			// Flat File Create
			StringBuffer buffer = new StringBuffer();
			buffer.append(fullCgoHeader);
			buffer.append(blInfo);
			buffer.append(cntrInfo);
			buffer.append(eurInfo);
			buffer.append(cntrSealNo);
			buffer.append(dgInfo);
			buffer.append(blCntr);

			sendFlatFileVO = new SendFlatFileVO();
			sendFlatFileVO.setFlatFile(buffer.toString());
			log.debug("COREOR : " + buffer.toString());

			// QueueNm
			bookingUtil = new BookingUtil();
			sendFlatFileVO.setQueueNm(SubSystemConfigFactory.get("BKG.OPUSBKG_UBIZCOM_VENDOR.IBMMQ.QUEUE"));

			bookingUtil.sendFlatFile(sendFlatFileVO);
		} catch (Exception ex) {
			log.error("\n\n[BCImpl - sendEdi] Exception :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] { "" }).getMessage(), ex);
		}
	}

	/**
	 * RELRED Master F/F을 생성하는 메소드
	 * 
	 * @param relRedVo
	 * @param flatFile
	 * @return
	 * @throws EventException
	 */
	public StringBuilder makeFlatFileMst(SearchRelredMasterForEdiVO relRedVo, StringBuilder flatFile) throws EventException {
		try {
			flatFile.append("STATUS:").append(relRedVo.getStatus()).append(NEW_LINE);
			flatFile.append("BOUND:").append(relRedVo.getBd()).append(NEW_LINE);
			flatFile.append("MSG_ID:").append(relRedVo.getMsgId()).append(NEW_LINE);
			flatFile.append("EQREL:").append(relRedVo.getEqrel()).append(NEW_LINE);
			flatFile.append("EQREL_LOC:").append(relRedVo.getEqrelLoc()).append(NEW_LINE);
			flatFile.append("EQREL_NAME:").append(relRedVo.getEqrelName()).append(NEW_LINE);
			flatFile.append("EQRES:").append(relRedVo.getEqres()).append(NEW_LINE);
			flatFile.append("EQRES_LOC:").append(relRedVo.getEqresLoc()).append(NEW_LINE);
			flatFile.append("EQRES_NAME:").append(relRedVo.getEqresName()).append(NEW_LINE);
			flatFile.append("MTY_CY:").append(relRedVo.getEmptyCy()).append(NEW_LINE);
			flatFile.append("MTY_CY_DESC:").append(relRedVo.getEmptyDest()).append(NEW_LINE);
			flatFile.append("BKG_NO:").append(relRedVo.getBkgNo()).append(NEW_LINE);
			flatFile.append("BL_NO:").append(relRedVo.getBlNo()).append(NEW_LINE);
			flatFile.append("WO_NO:").append(relRedVo.getWoNo()).append(NEW_LINE);
			flatFile.append("EPP_REF:").append(relRedVo.getEppRef()).append(NEW_LINE);
			flatFile.append("VSL_CALL:").append(relRedVo.getVslCall()).append(NEW_LINE);
			flatFile.append("VSL_LOYD:").append(relRedVo.getVslLoyd()).append(NEW_LINE);
			flatFile.append("VSL_NAME:").append(relRedVo.getVslName()).append(NEW_LINE);
			flatFile.append("VVD:").append(relRedVo.getVvd()).append(NEW_LINE);
			flatFile.append("CONSORT_VOY:").append(relRedVo.getConsortVoy()).append(NEW_LINE);
			flatFile.append("POL:").append(relRedVo.getPol()).append(NEW_LINE);
			flatFile.append("POL_DESC:").append(relRedVo.getPolDesc()).append(NEW_LINE);
			flatFile.append("POD:").append(relRedVo.getPod()).append(NEW_LINE);
			flatFile.append("POD_DESC:").append(relRedVo.getPodDesc()).append(NEW_LINE);
			flatFile.append("DEST:").append(relRedVo.getDest()).append(NEW_LINE);
			flatFile.append("DEST_DESC:").append(relRedVo.getDestDesc()).append(NEW_LINE);
			flatFile.append("VVD_ETD:").append(relRedVo.getVvdEtd()).append(NEW_LINE);
			flatFile.append("VVD_ETA:").append(relRedVo.getVvdEta()).append(NEW_LINE);
			flatFile.append("SHPR:").append(relRedVo.getShpr()).append(NEW_LINE);
			flatFile.append("CNEE:").append(relRedVo.getCnee()).append(NEW_LINE);
			flatFile.append("NTFY:").append(relRedVo.getNtfy()).append(NEW_LINE);
			flatFile.append("HAUL_TYPE:").append(relRedVo.getHaulType()).append(NEW_LINE);
			flatFile.append("SHIP_OPR:").append(relRedVo.getShipOpr()).append(NEW_LINE);
			flatFile.append("DR_IND:").append(relRedVo.getDrInd()).append(NEW_LINE);
			flatFile.append("RF_IND:").append(relRedVo.getRfInd()).append(NEW_LINE);
			flatFile.append("AK_IND:").append(relRedVo.getAkInd()).append(NEW_LINE);
		} catch (Exception ex) {
			log.error("\n\n[BCImpl - sendEdi] Exception :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] { "" }).getMessage(), ex);
		}
		return flatFile;
	}

	/**
	 * RELRED Info F/F을 생성하는 메소드
	 * 
	 * @param relredInfoRs
	 * @param flatFile
	 * @return
	 * @throws EventException
	 */
	public StringBuilder makeFlatFileInfo(DBRowSet relredInfoRs, StringBuilder flatFile) throws EventException {
		DBRowSet bkgVgmVOs = null;
		DBRowSet bkgDgCgoVOs = null;
		try {
			flatFile.append("{RELRED_INFO").append(NEW_LINE);
			flatFile.append("VENDOR:").append(relredInfoRs.getString("vendor")).append(NEW_LINE);
			flatFile.append("TRANS_MODE:").append(relredInfoRs.getString("trans_mode")).append(NEW_LINE);
			flatFile.append("PD_DT:").append(relredInfoRs.getString("pd_dt")).append(NEW_LINE);
			flatFile.append("SPCL_INST:").append(relredInfoRs.getString("spcl_inst")).append(NEW_LINE);
			flatFile.append("CNTR_NO:").append(relredInfoRs.getString("cntr_no")).append(NEW_LINE);
			flatFile.append("CSN:").append(relredInfoRs.getString("cntr_slt_no")).append(NEW_LINE);
			flatFile.append("CNTR_TYPE:").append(relredInfoRs.getString("cntr_type")).append(NEW_LINE);
			// flatFile.append("UCR:").append(relredInfoRs.getString("ucr")).append(NEW_LINE);
			flatFile.append("CARGOTYPE:").append(relredInfoRs.getString("cargotype")).append(NEW_LINE);
			flatFile.append("SEAL:").append(relredInfoRs.getString("seal")).append(NEW_LINE);
			flatFile.append("CNTR_QTY:").append(relredInfoRs.getString("cntr_qty")).append(NEW_LINE);
			flatFile.append("DIND:").append(relredInfoRs.getString("dind")).append(NEW_LINE);
			flatFile.append("RIND:").append(relredInfoRs.getString("rind")).append(NEW_LINE);
			flatFile.append("AIND:").append(relredInfoRs.getString("aind")).append(NEW_LINE);
			flatFile.append("TEMP_F:").append(relredInfoRs.getString("temp_f")).append(NEW_LINE);
			flatFile.append("TEMP_C:").append(relredInfoRs.getString("temp_c")).append(NEW_LINE);
			flatFile.append("RF_VOLTAGE:").append(relredInfoRs.getString("rf_voltage")).append(NEW_LINE);
			flatFile.append("VENT:").append(relredInfoRs.getString("vent")).append(NEW_LINE);
			flatFile.append("VENT_CMH:").append(relredInfoRs.getString("vent_cmh")).append(NEW_LINE);
			flatFile.append("VENT_PCT:").append(relredInfoRs.getString("vent_pct")).append(NEW_LINE);
			flatFile.append("HUMID:").append(relredInfoRs.getString("humid")).append(NEW_LINE);
			flatFile.append("GENSET:").append(relredInfoRs.getString("genset")).append(NEW_LINE);
			flatFile.append("RF_REMARK:").append(relredInfoRs.getString("rf_remark")).append(NEW_LINE);
			flatFile.append("RFDRY_IND:").append(relredInfoRs.getString("rfdry_ind")).append(NEW_LINE);
			flatFile.append("RF_DRAIN:").append(relredInfoRs.getString("rf_drain")).append(NEW_LINE);
			flatFile.append("OVF:").append(relredInfoRs.getString("ovf")).append(NEW_LINE);
			flatFile.append("OVR:").append(relredInfoRs.getString("ovr")).append(NEW_LINE);
			flatFile.append("OVH:").append(relredInfoRs.getString("ovh")).append(NEW_LINE);
			flatFile.append("OVLW:").append(relredInfoRs.getString("ovlw")).append(NEW_LINE);
			flatFile.append("OVRW:").append(relredInfoRs.getString("ovrw")).append(NEW_LINE);
			flatFile.append("OVWGT:").append(relredInfoRs.getString("ovwgt")).append(NEW_LINE);
			flatFile.append("VOID_SLOT:").append(relredInfoRs.getString("void_slot")).append(NEW_LINE);
			flatFile.append("STWG_REQ:").append(relredInfoRs.getString("stwg_req")).append(NEW_LINE);
			flatFile.append("TTL_DIM_LEN:").append(relredInfoRs.getString("ttl_dim_len")).append(NEW_LINE);
			flatFile.append("TTL_DIM_WDT:").append(relredInfoRs.getString("ttl_dim_wdt")).append(NEW_LINE);
			flatFile.append("TTL_DIM_HGT:").append(relredInfoRs.getString("ttl_dim_hgt")).append(NEW_LINE);
			flatFile.append("GWGTUNIT:").append(relredInfoRs.getString("gwgtunit")).append(NEW_LINE);
			flatFile.append("GWGT:").append(relredInfoRs.getString("gwgt")).append(NEW_LINE);
			flatFile.append("NWGTUNIT:").append(relredInfoRs.getString("nwgtunit")).append(NEW_LINE);
			flatFile.append("NWGT:").append(relredInfoRs.getString("nwgt")).append(NEW_LINE);
			flatFile.append("TWGTUNIT:").append(relredInfoRs.getString("twgtunit")).append(NEW_LINE);
			flatFile.append("TWGT:").append(relredInfoRs.getString("twgt")).append(NEW_LINE);
			flatFile.append("CMD:").append(relredInfoRs.getString("cmd")).append(NEW_LINE);
			flatFile.append("CMDD:").append(relredInfoRs.getString("cmdd")).append(NEW_LINE);

			// 2016.06.10 CHAN WOO PARK
			// BKG VGM
//			bkgVgmVOs = dbDao.searchBkgVgmForEdi(relredInfoRs.getString("bkg_no"), relredInfoRs.getString("cntr_no"));
//			if (bkgVgmVOs.getRowCount() > 0) { // VGM exists
//				while (bkgVgmVOs.next()) {
//					flatFile.append("{VGM").append(NEW_LINE);
//					flatFile.append("DOC_ID:").append(NEW_LINE);
//					flatFile.append("MEAS:").append(bkgVgmVOs.getString("MEAS")).append(NEW_LINE);
//					flatFile.append("MEAS_UT:").append(bkgVgmVOs.getString("MEAS_UT")).append(NEW_LINE);
//					flatFile.append("DOC_TP:").append(bkgVgmVOs.getString("DOC_TP")).append(NEW_LINE);
//					flatFile.append("DATE_TP:").append(NEW_LINE);
//					flatFile.append("DATE:").append(NEW_LINE);
//					flatFile.append("CUST_CNTC_TP:").append(bkgVgmVOs.getString("CUST_CNTC_TP")).append(NEW_LINE);
//					flatFile.append("CUST_CNTC_NM:").append(NEW_LINE);
//					flatFile.append("CUST_FAX:").append(NEW_LINE);
//					flatFile.append("CUST_EML:").append(bkgVgmVOs.getString("CUST_EML")).append(NEW_LINE);
//					flatFile.append("CUST_PHN:").append(NEW_LINE);
//					flatFile.append("CUST_ML_ADDR:").append(NEW_LINE);
//					flatFile.append("}VGM").append(NEW_LINE);
//				}
//			} else { // VGM Not exists.
				flatFile.append("{VGM").append(NEW_LINE);
				flatFile.append("DOC_ID:").append(NEW_LINE);
				flatFile.append("MEAS:").append(NEW_LINE);
				flatFile.append("MEAS_UT:").append(NEW_LINE);
				flatFile.append("DOC_TP:").append(NEW_LINE);
				flatFile.append("DATE_TP:").append(NEW_LINE);
				flatFile.append("DATE:").append(NEW_LINE);
				flatFile.append("CUST_CNTC_TP:").append(NEW_LINE);
				flatFile.append("CUST_CNTC_NM:").append(NEW_LINE);
				flatFile.append("CUST_FAX:").append(NEW_LINE);
				flatFile.append("CUST_EML:").append(NEW_LINE);
				flatFile.append("CUST_PHN:").append(NEW_LINE);
				flatFile.append("CUST_ML_ADDR:").append(NEW_LINE);
				flatFile.append("}VGM").append(NEW_LINE);
//			}
			
			bkgDgCgoVOs = dbDao.searchBkgDgCgoforEdi(relredInfoRs.getString("trsp_so_ofc_cty_cd"), relredInfoRs.getString("trsp_so_seq"));
			if (bkgDgCgoVOs.getRowCount() > 0) {
				while (bkgDgCgoVOs.next()) {
					flatFile.append("{CNTR_DANGER").append(NEW_LINE);
					flatFile.append("UNBR:").append(bkgDgCgoVOs.getString("unbr")).append(NEW_LINE);
					flatFile.append("CLAS:").append(bkgDgCgoVOs.getString("clas")).append(NEW_LINE);
					flatFile.append("DESC:").append(bkgDgCgoVOs.getString("dg_desc")).append(NEW_LINE);
					flatFile.append("PROPER_NM:").append(bkgDgCgoVOs.getString("proper_nm")).append(NEW_LINE);
					flatFile.append("TECH_NM:").append(bkgDgCgoVOs.getString("tech_nm")).append(NEW_LINE);
					flatFile.append("DG_APPROVAL:").append(bkgDgCgoVOs.getString("dg_approval")).append(NEW_LINE);
					flatFile.append("PHON:").append(bkgDgCgoVOs.getString("phon")).append(NEW_LINE);
					flatFile.append("FPNT:").append(bkgDgCgoVOs.getString("fpnt")).append(NEW_LINE);
					flatFile.append("FPUN:").append(bkgDgCgoVOs.getString("fpun")).append(NEW_LINE);
					flatFile.append("DG_REMARK:").append(bkgDgCgoVOs.getString("dg_remark")).append(NEW_LINE);
					flatFile.append("EMSNO:").append(bkgDgCgoVOs.getString("emsno")).append(NEW_LINE);
					flatFile.append("PSACLS:").append(bkgDgCgoVOs.getString("psacls")).append(NEW_LINE);
					flatFile.append("PKGGRP:").append(bkgDgCgoVOs.getString("pkggrp")).append(NEW_LINE);
					flatFile.append("MAR_POLL:").append(bkgDgCgoVOs.getString("mar_poll")).append(NEW_LINE);
					flatFile.append("HAZ_CONT:").append(bkgDgCgoVOs.getString("haz_cont")).append(NEW_LINE);
					flatFile.append("IMO_LIMIT:").append(bkgDgCgoVOs.getString("imo_limit")).append(NEW_LINE);
					flatFile.append("}CNTR_DANGER").append(NEW_LINE);
				}
				bkgDgCgoVOs = null;
			} else {
				flatFile.append("{CNTR_DANGER").append(NEW_LINE);
				flatFile.append("UNBR:").append(NEW_LINE);
				flatFile.append("CLAS:").append(NEW_LINE);
				flatFile.append("DESC:").append(NEW_LINE);
				flatFile.append("PROPER_NM:").append(NEW_LINE);
				flatFile.append("TECH_NM:").append(NEW_LINE);
				flatFile.append("DG_APPROVAL:").append(NEW_LINE);
				flatFile.append("PHON:").append(NEW_LINE);
				flatFile.append("FPNT:").append(NEW_LINE);
				flatFile.append("FPUN:").append(NEW_LINE);
				flatFile.append("DG_REMARK:").append(NEW_LINE);
				flatFile.append("EMSNO:").append(NEW_LINE);
				flatFile.append("PSACLS:").append(NEW_LINE);
				flatFile.append("PKGGRP:").append(NEW_LINE);
				flatFile.append("MAR_POLL:").append(NEW_LINE);
				flatFile.append("HAZ_CONT:").append(NEW_LINE);
				flatFile.append("IMO_LIMIT:").append(NEW_LINE);
				flatFile.append("}CNTR_DANGER").append(NEW_LINE);
			}
			flatFile.append("}RELRED_INFO").append(NEW_LINE);
		} catch (Exception ex) {
			log.error("\n\n[BCImpl - sendEdi] Exception :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] { "" }).getMessage(), ex);
		}
		return flatFile;
	}
}
