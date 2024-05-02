/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ProductCatalogCreateBCImpl.java
 *@FileTitle : ProductCatalogCreate
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 1.0 
=========================================================*/
package com.clt.apps.opus.esd.prd.productcatalogcreate.productcatalogcreate.basic;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esd.prd.common.PrdConstants;
import com.clt.apps.opus.esd.prd.common.prdcreate.basic.PrdCreateManageBC;
import com.clt.apps.opus.esd.prd.common.prdcreate.basic.PrdCreateManageBCImpl;
import com.clt.apps.opus.esd.prd.common.prdcreate.vo.PrdPcCreateVO;
import com.clt.apps.opus.esd.prd.common.productcatalogcreateverify.basic.ProductCatalogCreateVerifyBCImpl;
import com.clt.apps.opus.esd.prd.productcatalogcreate.productcatalogcreate.event.EsdPrd0080Event;
import com.clt.apps.opus.esd.prd.productcatalogcreate.productcatalogcreate.event.EsdPrd0081Event;
import com.clt.apps.opus.esd.prd.productcatalogcreate.productcatalogcreate.event.EsdPrd0083Event;
import com.clt.apps.opus.esd.prd.productcatalogcreate.productcatalogcreate.integration.ProductCatalogCreateDBDAO;
import com.clt.apps.opus.esd.prd.productcatalogcreate.productcatalogcreate.integration.ProductCatalogSceDBDAO;
import com.clt.apps.opus.esd.prd.productcatalogcreate.productcatalogcreate.integration.ProductCatalogTroDBDAO;
import com.clt.apps.opus.esd.prd.productcatalogcreate.productcatalogcreate.vo.PrdCnstRemarkVO;
import com.clt.apps.opus.esd.prd.productcatalogcreate.productcatalogcreate.vo.PrdCreateParamVO;
import com.clt.apps.opus.esd.prd.productcatalogcreate.productcatalogcreate.vo.PrdOcnRoutDoubleCallingVO;
import com.clt.apps.opus.esd.prd.productcatalogcreate.productcatalogcreate.vo.PrdPatternVO;
import com.clt.apps.opus.esd.prd.productcatalogcreate.productcatalogcreate.vo.PrdQuantityVO;
import com.clt.apps.opus.esd.prd.productcatalogcreate.productcatalogcreate.vo.PrdSceGetParamVO;
import com.clt.apps.opus.esd.prd.productcatalogcreate.productcatalogcreate.vo.PrdSearchEurDrRePatternVO;
import com.clt.apps.opus.esd.prd.productcatalogcreate.productcatalogcreate.vo.PrdSearchParamVO;
import com.clt.apps.opus.esd.prd.productcatalogcreate.productcatalogcreate.vo.PrdValChkVO;
import com.clt.apps.opus.esd.sce.bkgcopmanage.basic.BkgCopManageBC;
import com.clt.apps.opus.esd.sce.bkgcopmanage.basic.BkgCopManageBCImpl;
import com.clt.apps.opus.esd.sce.bkgcopmanage.vo.SearchCopVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.PrdMainInfoVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.PrdParameterVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.PrdQtyInfoVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.DateTime;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.framework.utility.CheckUtilities;
import com.clt.syscommon.common.table.PrdBkgCopMapVO;
import com.clt.syscommon.common.table.PrdProdCtlMstVO;

/**
 * ProductCatalogCreate Business Logic Command Interface<br>
 * 
 * @author sun yong Jung
 * @see EventResponse,ProductCatalogCreateDBDAO,ProductCatalogSceDBDAO,ProductCatalogTroDBDAO
 * @since J2EE 1.6
 */
public class ProductCatalogCreateBCImpl extends BasicCommandSupport implements ProductCatalogCreateBC {
	private transient ProductCatalogCreateDBDAO dbDao = null;
	private transient ProductCatalogTroDBDAO dbDaoTro = null;
	private transient ProductCatalogSceDBDAO dbDaoSce = null;

	/**
	 * creating ProductCatalogCreateBCImpl Object<br>
	 * creating ProductCatalogCreateDBDAO<br>
	 */
	public ProductCatalogCreateBCImpl() {
		dbDao = new ProductCatalogCreateDBDAO();
		dbDaoTro = new ProductCatalogTroDBDAO();
		dbDaoSce = new ProductCatalogSceDBDAO();
	}

	/**
	 *** calling from BOOKING MAIN*** Mode B: return in case of creating 1 pc Mode Y: BKG COPY
	 * 
	 * @param prdParameterVO
	 * @param account
	 * @return String
	 * @throws EventException
	 */
	@SuppressWarnings("rawtypes")
	public String createPrdCtlgRout(PrdParameterVO prdParameterVO, SignOnUserAccount account) throws EventException {
		String returnStr = "";
		String rTerm = "";
		String dTerm = "";
		String por = "";
		String del = "";
		String eurDrChk = "";
		String bkgNo = "";
		String returnTerm = "";
		EsdPrd0080Event esdPrd0080Event = null;

		// creating pc no
		PrdCreateManageBC prdCreateManageBc = new PrdCreateManageBCImpl();
		// setting parameters from bkg to prd param vo
		EsdPrd0080Event event = (EsdPrd0080Event) prdCreateManageBc.setPrdCreateParam(prdParameterVO);
		rTerm = event.getPrdCreateParamVO().getRcvT();
		dTerm = event.getPrdCreateParamVO().getDelT();
		por = event.getPrdCreateParamVO().getPor();
		del = event.getPrdCreateParamVO().getDel();
		bkgNo = event.getPrdCreateParamVO().getBkgNo();
		// handling mixed term
		if (rTerm != null && (rTerm.equals("M") || rTerm.equals("I"))) {
			// to keep original data in case of changing term
			event.getPrdCreateParamVO().setBkgRcvT(rTerm);
			event.getPrdCreateParamVO().setRcvT(prdCreateManageBc.checkMixedRterm(bkgNo, por, rTerm));
			returnTerm = prdCreateManageBc.checkMixedTermYard(event.getPrdCreateParamVO().getRcvT(), event.getPrdCreateParamVO().getPorN());
			if (returnTerm.equals("N")) {
				event.getPrdCreateParamVO().setPorN("");
			}
		}
		if (dTerm != null && (dTerm.equals("M") || dTerm.equals("O"))) {
			event.getPrdCreateParamVO().setBkgDelT(dTerm);
			event.getPrdCreateParamVO().setDelT(prdCreateManageBc.checkMixedDterm(bkgNo, del, dTerm));
			returnTerm = prdCreateManageBc.checkMixedTermYard(event.getPrdCreateParamVO().getDelT(), event.getPrdCreateParamVO().getDelN());
			if (returnTerm.equals("N")) {
				event.getPrdCreateParamVO().setDelN("");
			}
		}
		event.setAttribute("account", account);
		try {

			PrdCreateParamVO prdCreateParamVO = event.getPrdCreateParamVO();
			/*
			 * checking PSEUDO VVD in case of using PSEUDO VVD as T-VVD at BKG-MAIN -.creating PC with LDD regardless T/S -.PC return DIRECT section -.setting VVD with PSEUDO VVD after creating PC with LDD
			 */
			if (prdCreateParamVO.getPcMode().equals(PrdConstants.PRD_PC_MOD_BASIC) || prdCreateParamVO.getPcMode().equals(PrdConstants.PRD_PC_MOD_REPLAN)) {
				if (prdCreateParamVO.getTVvd() != null && (prdCreateParamVO.getTVvd().contains("COXX") || prdCreateParamVO.getTVvd().contains("COYY") || prdCreateParamVO.getTVvd().contains("COZZ"))) {

					prdCreateParamVO.setPseudoVvd(prdCreateParamVO.getTVvd());
					prdCreateParamVO.setTVvd("");
					prdCreateParamVO.setVvd1("");
					prdCreateParamVO.setVvd2("");
					prdCreateParamVO.setVvd3("");
					prdCreateParamVO.setVvd4("");
					prdCreateParamVO.setLane1("");
					prdCreateParamVO.setLane2("");
					prdCreateParamVO.setLane3("");
					prdCreateParamVO.setLane4("");

					prdCreateParamVO.setPol1("");
					prdCreateParamVO.setPod1("");
					prdCreateParamVO.setPol2("");
					prdCreateParamVO.setPod2("");
					prdCreateParamVO.setPol3("");
					prdCreateParamVO.setPod3("");
					prdCreateParamVO.setPol4("");
					prdCreateParamVO.setPod4("");
					prdCreateParamVO.setPol1N("");
					prdCreateParamVO.setPod1N("");
					prdCreateParamVO.setPol2N("");
					prdCreateParamVO.setPod2N("");
					prdCreateParamVO.setPol3N("");
					prdCreateParamVO.setPod3N("");
					prdCreateParamVO.setPol4N("");
					prdCreateParamVO.setPod4N("");

				}
			}

			/*
			 * PRD_PC_MOD_BASIC
			 */
			if (prdCreateParamVO.getPcMode().equals(PrdConstants.PRD_PC_MOD_BASIC)) {

				/*---------------------------------------------
				 * creating pc 
				 *---------------------------------------------*/
				this.createPrdCtlgFullRout(event);
				// ----------------------------------------------

				PrdPcCreateVO prdPcCreateVO = event.getPrdPcCreateVO();

				// returning PC which is related to direct ocn route in case of PSEUDO VVD
				// returning 1 PC when PCs are created
				if (!prdCreateParamVO.getPseudoVvd().equals("")) {
					returnStr = dbDao.searchDirectOcn(prdPcCreateVO.getHdPctlNo());
					// updating VVD
					if (!returnStr.equals("FAIL")) {
						// changing TRUNC VVD with PSEUDO VVD. setting the other VVD with ''
						dbDao.updatePrdDtlByPseudoVvd(returnStr, prdCreateParamVO.getPseudoVvd());
						dbDao.updatePrdMstByPseudoVvd(returnStr, prdCreateParamVO.getPseudoVvd());
					}

				} else {
					// returning when 1 PC is created
					// calling selection window if count of PC is larger than 1

					log.debug("\npc min:" + prdPcCreateVO.getMinPctlNo());
					log.debug("\npc max:" + prdPcCreateVO.getMaxPctlNo());

					// 1 PC
					if (!prdPcCreateVO.getMinPctlNo().equals("") && prdPcCreateVO.getMinPctlNo().equals(prdPcCreateVO.getMaxPctlNo())) {
						// return
						returnStr = prdPcCreateVO.getMinPctlNo();

						// EXCEPTION if input MT PU DATE is later than SKD DATE
						// changing SKD DATE with input value if input MT PU DATE is faster than SKD DATE
						log.debug("\n getRcvT():[" + prdCreateParamVO.getRcvT() + "], getMtPkupDt():[" + prdCreateParamVO.getMtPkupDt() + "]");
						if (!prdCreateParamVO.getRcvT().equals("S") && prdCreateParamVO.getMtPkupDt() != null && !prdCreateParamVO.getMtPkupDt().equals("")) {
							if (checkMtPkupDt(returnStr, prdCreateParamVO.getMtPkupDt())) {
								setMtPkupDt(returnStr, prdCreateParamVO.getMtPkupDt());
							} else {
								throw new EventException(new ErrorHandler("PRD00058").getMessage());
							}
						}
						// checking constraint
						List mstList = dbDao.getPrdMst(returnStr);
						log.debug("\n checking constraint  mstList.size() :" + mstList.size());
						if (mstList.size() > 0) {
							PrdProdCtlMstVO prdProdCtlMstVO = (PrdProdCtlMstVO) mstList.get(0);
							if (prdProdCtlMstVO.getCnstFlg().equals("X")) {
								log.debug("\n checking constraint prdProdCtlMstVO.getCnstFlg() :" + prdProdCtlMstVO.getCnstFlg());
								throw new EventException(new ErrorHandler("PRD00059").getMessage());
							}
						}

					} else {
						// when count of PC is lager than 1 (EXCEPTION in case of not creating PC)
						returnStr = "FAIL";
					}
				}

				/*
				 * PRD_PC_MOD_COPY_VVD_UNCHANGE: Y
				 */
			} else if (prdCreateParamVO.getPcMode().equals(PrdConstants.PRD_PC_MOD_COPY_VVD_UNCHANGE)) {
				returnStr = createBkgCopyVvdUnchange(event);

				/*
				 * PRD_PC_MOD_SPLIT_VVD_UNCHANGE: S
				 */
			} else if (prdCreateParamVO.getPcMode().equals(PrdConstants.PRD_PC_MOD_SPLIT_VVD_UNCHANGE)) {

				this.createBkgSplitVvd(prdParameterVO, account, null, 0, null);
				/*
				 * 1.bkg replan 2.group vvd assign
				 */
			} else if (prdCreateParamVO.getPcMode().equals(PrdConstants.PRD_PC_MOD_REPLAN)) {

				// PctlNo with cop_map_seq
				// logic handling pseudo vvd is contained
				// return 1 PC NO(PC_NO + COP_MAP_SEQ)
				returnStr = createBkgReplane(event);
				PrdPcCreateVO prdPcCreateVO = event.getPrdPcCreateVO();

				log.debug("\n pc createBkgReplane return:" + returnStr);
				// EXCEPTION if input MT PU DATE is later than SKD DATE
				// changing SKD DATE with input value if input MT PU DATE is faster than SKD DATE
				log.debug("\n getRcvT():[" + prdCreateParamVO.getRcvT() + "], getMtPkupDt():[" + prdCreateParamVO.getMtPkupDt() + "]");
				if (!prdCreateParamVO.getRcvT().equals("S") && prdCreateParamVO.getMtPkupDt() != null && !prdCreateParamVO.getMtPkupDt().equals("")) {
					if (checkMtPkupDt(prdPcCreateVO.getMinPctlNo(), prdCreateParamVO.getMtPkupDt())) {
						// changing mt dt
						setMtPkupDt(prdPcCreateVO.getMinPctlNo(), prdCreateParamVO.getMtPkupDt());
					} else {
						throw new EventException(new ErrorHandler("PRD00058").getMessage());

					}
				}

				// checking constraint
				List mstList = dbDao.getPrdMst(prdPcCreateVO.getMinPctlNo());
				log.debug("\n constraint checking  mstList.size() :" + mstList.size());
				if (mstList.size() > 0) {
					PrdProdCtlMstVO prdProdCtlMstVO = (PrdProdCtlMstVO) mstList.get(0);
					log.debug("\n constraint checking prdProdCtlMstVO.getCnstFlg() :" + prdProdCtlMstVO.getCnstFlg());
					if (prdProdCtlMstVO.getCnstFlg().equals("X")) {
						throw new EventException(new ErrorHandler("PRD00059").getMessage());
					}
				}

				// handling EUR TRO
				// 1. checking if EUR TRO exists
				// 2. searching with new PATTERN
				// --> 1) if S/O or TRO of Europe area that are different POR/DEL NODE are exist
				// 2) searching S/O. searching TRO DATA if S/O is not exist
				// 3. creating new TRO PC and updating PC NO

				eurDrChk = dbDao.chkEurDr(prdCreateParamVO.getBkgNo());

				if (eurDrChk.equals("Y")) {
					//
					dbDao.updatePrdMapReInit(prdCreateParamVO.getBkgNo(), event.getAttribute("eur_dr_seq") + "");

					// select
					List<PrdSearchEurDrRePatternVO> eurDrList = dbDao.getEurDr(prdCreateParamVO.getBkgNo(), event.getAttribute("eur_dr_seq") + "");

					// creating pc
					PrdSearchEurDrRePatternVO prdSearchEurDrRePatternVO = null;
					for (int i = 0; i < eurDrList.size(); i++) {

						prdSearchEurDrRePatternVO = (PrdSearchEurDrRePatternVO) eurDrList.get(i);

						PrdPatternVO prdPatternVO = new PrdPatternVO();
						prdPatternVO.setObItchgCtnt(prdSearchEurDrRePatternVO.getObContent());
						prdPatternVO.setIbItchgCtnt(prdSearchEurDrRePatternVO.getIbContent());
						prdPatternVO.setOcnItchgCtnt(prdSearchEurDrRePatternVO.getOcnContent());

						createPrdCtlgEurDoor(event, prdSearchEurDrRePatternVO, prdPatternVO);

					}

				}
				// TRO
			} else if (prdCreateParamVO.getPcMode().equals(PrdConstants.PRD_PC_MOD_I) || prdCreateParamVO.getPcMode().equals(PrdConstants.PRD_PC_MOD_O)) {
				returnStr = createIrgSoReplane(event, account.getUsr_id());
				// CMTX
			} else if (prdCreateParamVO.getPcMode().equals(PrdConstants.PRD_PC_MOD_P)) {
				int oceanRouteCount = 0;
				oceanRouteCount = dbDao.searchProdOceanRout(prdCreateParamVO);
				if (oceanRouteCount == 0) {
					throw new EventException("There is no matched ocean route in product catalog.");
				}
				esdPrd0080Event = this.createPrdCtlgFullRout(event);
				if (esdPrd0080Event.getPrdPcCreateVO() != null) {
					returnStr = esdPrd0080Event.getPrdPcCreateVO().getHdPctlNo();
				}
			}
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		log.debug("\n\n -------------------------------------------------------------" + "\n ♡ ♡♡♡♡♡♡                      PC end.     ♡♡♡♡♡♡♡♡♡♡♡♡♡♡" + "\n ★★★★★             createPrdCtlgRout end return :" + returnStr + "\n----------------------------------------------------------------\n\n");
		return returnStr;

	}

	/**
	 * calling from bkg by each split bkg
	 * 
	 * @param PrdParameterVO prdParameterVO
	 * @param SignOnUserAccount account
	 * @param List<String> cntrList
	 * @param int splitSeq
	 * @param List<String> bkgNoList
	 * @return String
	 * @throws EventException
	 */
	public String createPrdCtlgRoutSplit(PrdParameterVO prdParameterVO, SignOnUserAccount account, List<String> cntrList, int splitSeq, List<String> bkgNoList) throws EventException {
		PrdCreateManageBC prdCreateManageBc = new PrdCreateManageBCImpl();
		EsdPrd0080Event event = (EsdPrd0080Event) prdCreateManageBc.setPrdCreateParam(prdParameterVO);
		PrdCreateParamVO prdCreateParamVO = event.getPrdCreateParamVO();
		/*
		 * PRD_PC_MOD_COPY_VVD_UNCHANGE: Y
		 */
		String copMapSeq = null; // ""
		if (prdCreateParamVO.getPcMode().equals(PrdConstants.PRD_PC_MOD_COPY_VVD_UNCHANGE)) {
			this.createBkgCopyVvdUnchange(event);

			/*
			 * PRD_PC_MOD_SPLIT_VVD_UNCHANGE: S
			 */
		} else if (prdCreateParamVO.getPcMode().equals(PrdConstants.PRD_PC_MOD_SPLIT_VVD_UNCHANGE)) {
			copMapSeq = this.createBkgSplitVvd(prdParameterVO, account, cntrList, splitSeq, bkgNoList);
		}
		log.debug("\n\n createPrdCtlgRoutSplit return: " + copMapSeq);
		return copMapSeq;
	}

	/**
	 * @param e
	 * @return return only 1 pc no
	 * @throws EventException
	 */
	private String createBkgReplane(Event e) throws EventException {
		EsdPrd0080Event event = (EsdPrd0080Event) e;
		PrdCreateParamVO prdCreateParamVO = event.getPrdCreateParamVO();
		SignOnUserAccount account = (SignOnUserAccount) e.getAttribute("account");
		prdCreateParamVO.setCntrTpszQtyStr(this.getReplanCntrTpszQty(prdCreateParamVO.getBkgNo(), event.getPrdQuantityVOs()));
		/**
		 * replane check
		 */
		checkReplan(prdCreateParamVO);
		List<PrdPatternVO> list = null;

		// using original term data not changed data at PRD in case of pattern(mixed)----------
		String orgRterm = "";
		String orgDterm = "";
		String chgRterm = "";
		String chgDterm = "";

		if (prdCreateParamVO.getBkgRcvT().equals("M")) {
			orgRterm = prdCreateParamVO.getBkgRcvT();
		}
		chgRterm = prdCreateParamVO.getRcvT();

		if (prdCreateParamVO.getBkgDelT().equals("M")) {
			orgDterm = prdCreateParamVO.getBkgDelT();
		}
		chgDterm = prdCreateParamVO.getDelT();

		// ------------------------------------------------------------------------------------

		/*
		 * pseudo vvd
		 */
		if (!prdCreateParamVO.getPseudoVvd().equals("")) {
			list = this.getReplanePattern(event.getPrdQuantityVOs(), prdCreateParamVO.getBkgNo(), prdCreateParamVO.getBkgOfc(), orgRterm, orgDterm, chgRterm, chgDterm, "V", prdCreateParamVO.getFlexHgtFlg(), prdCreateParamVO.getCntrTpszQtyStr());
		} else {

			/**
			 * checking pattern 1.updating CRNT_FLGfmf of map table with 'N' 2.getting PRD_BKG_COP_MAP_SEQ sequence 3.creating prd map 4.correcting prd map qty 5.grouping COP_PATT_ORD_NO to create PC as much as COP_PATT_ORD_NO
			 */
			list = this.getReplanePattern(event.getPrdQuantityVOs(), prdCreateParamVO.getBkgNo(), prdCreateParamVO.getBkgOfc(), orgRterm, orgDterm, chgRterm, chgDterm, "P", prdCreateParamVO.getFlexHgtFlg(), prdCreateParamVO.getCntrTpszQtyStr());
		}
		/**
		 * creating replane pc as much as count of pattern
		 */
		// creating pc in case of not existing pattern
		PrdPatternVO prdPatternVO = null;

		// cho
		log.debug("\n\n TESTEST-----------");
		EsdPrd0080Event eventcho = (EsdPrd0080Event) e;
		log.debug("\n\n -------------------------------" + "\n createBkgReplane getTVvd:" + eventcho.getPrdCreateParamVO().getTVvd() + "\n createBkgReplane getVvd1:" + eventcho.getPrdCreateParamVO().getVvd1() + "\n createBkgReplane getVvd2:" + eventcho.getPrdCreateParamVO().getVvd2());

		// CHO END
		String returnPctlNo = "";
		String subPatternPctlNo = "";

		if (list == null || list.size() < 1) {
			log.debug("\n\n list ==null-----------");
			// Could not find replan date(pattern not find).
			throw new EventException(new ErrorHandler("PRD00062").getMessage());
		} else {

			log.error("\n list.size():" + list.size());
			for (int i = 0; i < list.size(); i++) {
				log.debug("\n creating pattern by pattern.pattern count:" + list.size());

				// creating PC as prime pattern of ord= 1
				prdPatternVO = (PrdPatternVO) list.get(i);
				if (prdPatternVO.getCopPattOrdNo().equals("1")) {
					log.debug("\n ord= 1 main pattern pc create------------------");

					// creating PC -----------------------------------
					createPrdCtlgIncludeReplane(e, prdPatternVO);
					// creating PC -----------------------------------

					// returning only 1 PC in case of psedo vvd
					PrdPcCreateVO prdPcCreateVO = event.getPrdPcCreateVO();

					if (!prdCreateParamVO.getPseudoVvd().equals("")) {
						// PSEUDO REPLAN
						try {

							// returning only 1 PC in case of psedo vvd
							event.setAttribute("eur_dr_seq", prdPatternVO.getCopMapgSeq());
							returnPctlNo = dbDao.searchDirectOcn(prdPcCreateVO.getHdPctlNo());
							// updating VVD
							if (!returnPctlNo.equals("FAIL")) {
								dbDao.updatePrdDtlByPseudoVvd(returnPctlNo, prdCreateParamVO.getPseudoVvd());
								dbDao.updatePrdMstByPseudoVvd(returnPctlNo, prdCreateParamVO.getPseudoVvd());

								updatePrdMapByPcCreate(prdPatternVO.getCopPattOrdNo(), prdPatternVO.getCopMapgSeq(), returnPctlNo, prdCreateParamVO.getBkgNo());
								event.setAttribute("eur_dr_seq", prdPatternVO.getCopMapgSeq());
								returnPctlNo = returnPctlNo + "|" + prdPatternVO.getCopMapgSeq();
								log.debug("\n\n----------------------------------------------------" + "\n pseudo vvd - replan pc create success PCTL no + map seq =[" + returnPctlNo + "]" + "\n--------------------------------------------------------");

							}
						} catch (DAOException ex) {
							throw new EventException(ex.getMessage(), ex);
						} catch (Exception ex) {
							throw new EventException(ex.getMessage(), ex);
						}

					} else {
						log.debug("\n\n MIN -----------" + prdPcCreateVO.getMinPctlNo());
						log.debug("\n\n MAX -----------" + prdPcCreateVO.getMaxPctlNo());

						if (CheckUtilities.isInBlank(prdPcCreateVO.getMaxPctlNo())) {
							if (prdCreateParamVO == null || prdPcCreateVO == null || (prdCreateParamVO != null && "".equals(prdCreateParamVO.getPol()))) {
								throw new EventException(new ErrorHandler("PRD00075").getMessage());
							}

							String verifyMessage = new ProductCatalogCreateVerifyBCImpl().getPcVerify(event,prdCreateParamVO, prdPcCreateVO, prdPatternVO);
							log.debug("\n noh verifyMessage \n" + verifyMessage);
							throw new EventException(new ErrorHandler("PRD99998", new String[] { verifyMessage }).getMessage());

						} else if (!prdPcCreateVO.getMinPctlNo().equals("") && !(prdPcCreateVO.getMinPctlNo().equals(prdPcCreateVO.getMaxPctlNo()))) {
							throw new EventException(new ErrorHandler("PRD00077").getMessage());
						} else {
							// in case of creating 1 PC
							// updating map table (cop_patt_ord_no=1 , updating pc no using COP_MAPG_SEQ)
							updatePrdMapByPcCreate(prdPatternVO.getCopPattOrdNo(), prdPatternVO.getCopMapgSeq(), prdPcCreateVO.getMinPctlNo(), prdCreateParamVO.getBkgNo());
							event.setAttribute("eur_dr_seq", prdPatternVO.getCopMapgSeq());
							returnPctlNo = prdPcCreateVO.getMinPctlNo() + "|" + prdPatternVO.getCopMapgSeq();
							// handling eur tro. --in case of 1 prime pattern PC
							log.debug("\n\n----------------------------------------------------" + "\n replan pc create success PCTL no + map seq =[" + returnPctlNo + "]" + "\n--------------------------------------------------------");
						}
					}

				} else {
					// creating sub pattern PC(ignoring even though it fails)
					log.debug("\n ord> 1 , sub pattern pc create.------------------");

					// -----------------------------------------
					createPrdCtlgIncludeReplane(e, prdPatternVO);
					// creating PC-----------------------------------------

					// returning PC which is related to direct ocn route in case of PSEUDO VVD
					PrdPcCreateVO prdPcCreateVO = event.getPrdPcCreateVO();

					if (!prdCreateParamVO.getPseudoVvd().equals("")) {
						// handling pseudo vvd (sub pattern)
						try {
							// finding PC which is related to direct ocn route in case of PSEUDO VVD
							subPatternPctlNo = dbDao.searchDirectOcn(prdPcCreateVO.getHdPctlNo());
							// updating VVD
							if (subPatternPctlNo.equals("FAIL")) {
								int updateCnt = dbDao.updatePrdMapByPcCreateFail(prdPatternVO.getCopPattOrdNo(), prdPatternVO.getCopMapgSeq());
								if (updateCnt == 0) {
									log.debug("\n\n PRD log On:");
									Map<String, Object> map = new HashMap<String, Object>();

									map.put("PrdPatternVO", prdPatternVO);
									map.put("usrId", account.getUsr_id());

									String logDesc = this.getParamString(map);
									log.debug("\n\n log::::" + logDesc);
									dbDao.createPrdExecLog(logDesc, "createBkgReplane F_1", account.getUsr_id());
								}
							} else {
								dbDao.updatePrdDtlByPseudoVvd(subPatternPctlNo, prdCreateParamVO.getPseudoVvd());
								dbDao.updatePrdMstByPseudoVvd(subPatternPctlNo, prdCreateParamVO.getPseudoVvd());

								// upating map table (cop_patt_ord_no=1 , pc no update using COP_MAPG_SEQ)
								int successCnt = updatePrdMapByPcCreate(prdPatternVO.getCopPattOrdNo(), prdPatternVO.getCopMapgSeq(), subPatternPctlNo, prdCreateParamVO.getBkgNo());
								if (successCnt == 0) {
									log.debug("\n\n PRD log On:");
									Map<String, Object> map = new HashMap<String, Object>();

									map.put("PrdCreateParamVO", prdCreateParamVO);
									map.put("PrdPatternVO", prdPatternVO);
									map.put("subPatternPctlNo", subPatternPctlNo);
									map.put("BkgNo", prdCreateParamVO.getBkgNo());
									map.put("usrId", account.getUsr_id());

									String logDesc = this.getParamString(map);
									log.debug("\n\n log::::" + logDesc);
									dbDao.createPrdExecLog(logDesc, "createBkgReplane S_1", account.getUsr_id());
								}
							}
						} catch (DAOException ex) {
							throw new EventException(ex.getMessage(), ex);
						} catch (Exception ex) {
							throw new EventException(ex.getMessage(), ex);
						}

					} else {
						// handling normal replan (sub pattern)
						if (prdPcCreateVO.getMaxPctlNo().equals("")) {
							// creating PC fail - updating COP_OP_TP_CD as fail in case of sub pattern
							log.debug("\n ord> 1 , sub pattern pc create fail.------------------");
							try {
								int updateCnt = dbDao.updatePrdMapByPcCreateFail(prdPatternVO.getCopPattOrdNo(), prdPatternVO.getCopMapgSeq());
								log.debug("\n\n PRD log On:");
								Map<String, Object> map = new HashMap<String, Object>();

								map.put("PrdPatternVO", prdPatternVO);
								map.put("usrId", account.getUsr_id());

								String logDesc = "successFlag " + Integer.toString(updateCnt) + " " + this.getParamString(map);
								log.debug("\n\n log::::" + logDesc);

							} catch (DAOException ex) {
								throw new EventException(ex.getMessage(), ex);
							} catch (Exception ex) {
								throw new EventException(ex.getMessage(), ex);
							}
						} else {
							// in case of creating 1 PC
							// map table update (cop_patt_ord_no>1 , pc no update using COP_MAPG_SEQ )
							log.debug("\n ord> 1 , sub pattern pc create success.------------------");
							int updateCnt = updatePrdMapByPcCreate(prdPatternVO.getCopPattOrdNo(), prdPatternVO.getCopMapgSeq(), prdPcCreateVO.getMinPctlNo(), prdCreateParamVO.getBkgNo());
							try {
								log.debug("\n\n PRD log On:");
								Map<String, Object> map = new HashMap<String, Object>();

								map.put("PrdPatternVO", prdPatternVO);
								map.put("MinPctlNo", prdPcCreateVO.getMinPctlNo());
								map.put("BkgNo", prdCreateParamVO.getBkgNo());
								map.put("usrId", account.getUsr_id());

								String logDesc = "successFlag " + Integer.toString(updateCnt) + " " + this.getParamString(map);
								log.debug("\n\n log::::" + logDesc);

								dbDao.createPrdExecLog(logDesc, "createBkgReplane SM_F", account.getUsr_id());
							} catch (DAOException e1) {
								log.error("err " + e1.toString(), e1);
								throw new EventException(new ErrorHandler(e1).getMessage());
							}
						}
					}

				} // sub pattern ----------------------------------
			}
		}
		return returnPctlNo;

	}

	/**
	 * calling when assigning VVD which contains "COXX COZZ COYY" at BKG
	 * 
	 * @param PrdParameterVO prdParameterVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @throws EventException
	 */
	public String updateBkgAssignVvd(PrdParameterVO prdParameterVO, SignOnUserAccount account) throws EventException {
		EsdPrd0080Event event = (EsdPrd0080Event) new PrdCreateManageBCImpl().setPrdCreateParam(prdParameterVO);
		PrdCreateParamVO prdCreateParamVO = event.getPrdCreateParamVO();
		prdCreateParamVO.setCntrTpszQtyStr(this.getReplanCntrTpszQty(prdCreateParamVO.getBkgNo(), event.getPrdQuantityVOs()));
		String pod = null;
		String vvd = null;
		String psudoVvd = "COXX COZZ COYY"; //

		if (psudoVvd.contains((prdCreateParamVO.getTVvd() + "    ").substring(0, 4))) {
			vvd = "";
			pod = prdCreateParamVO.getPod();
		} else if (psudoVvd.contains((prdCreateParamVO.getVvd1() + "    ").substring(0, 4))) {
			vvd = "";
			pod = prdCreateParamVO.getPod1();
		} else if (psudoVvd.contains((prdCreateParamVO.getVvd2() + "    ").substring(0, 4))) {
			vvd = "";
			pod = prdCreateParamVO.getPod2();
		} else if (psudoVvd.contains((prdCreateParamVO.getVvd3() + "    ").substring(0, 4))) {
			vvd = "";
			pod = prdCreateParamVO.getPod3();
		} else if (psudoVvd.contains((prdCreateParamVO.getVvd4() + "    ").substring(0, 4))) {
			vvd = "";
			pod = prdCreateParamVO.getPod4();
		}
		String pctlNo = null;
		if (vvd != null) {
			this.checkReplan(prdCreateParamVO);

			String bkgNo = prdCreateParamVO.getBkgNo();

			try {
				int successFlag = dbDao.updateAssignVvdDetail(bkgNo, vvd, pod, account.getUsr_id());
				if (successFlag == 0) {
					log.debug("\n\n PRD log On:");
					Map<String, Object> map = new HashMap<String, Object>();
					map.put("PrdCreateParamVO", prdCreateParamVO);
					map.put("vvd", vvd);
					map.put("pod", pod);
					map.put("usrId", account.getUsr_id());
					String logDesc = this.getParamString(map);
					log.debug("\n\n log::::" + logDesc);
					dbDao.createPrdExecLog(logDesc, "updateBkgAssignVvd", account.getUsr_id());
				}

			} catch (DAOException ex) {
				throw new EventException(ex.getMessage(), ex);
			} catch (Exception ex) {
				throw new EventException(ex.getMessage(), ex);
			}
			// no change of term
			List<PrdPatternVO> list = this.getReplanePattern(event.getPrdQuantityVOs(), bkgNo, prdCreateParamVO.getBkgOfc(), prdCreateParamVO.getRcvT(), prdCreateParamVO.getDelT(), prdCreateParamVO.getRcvT(), prdCreateParamVO.getDelT(), "V", prdCreateParamVO.getFlexHgtFlg(),
					prdCreateParamVO.getCntrTpszQtyStr());
			if (list != null && list.size() > 0) {
				pctlNo = ((PrdPatternVO) list.get(0)).getPctlNo() + "|" + ((PrdPatternVO) list.get(0)).getCopMapgSeq();
			}
		}
		return pctlNo;
	}

	/**
	 * @param copPattOrdNo
	 * @param copMapgSeq
	 * @param minPctlNo
	 * @param bkgNo
	 * @throws EventException
	 */
	private int updatePrdMapByPcCreate(String copPattOrdNo, String copMapgSeq, String minPctlNo, String bkgNo) throws EventException {
		int successCnt = 0;
		try {
			successCnt = dbDao.updatePrdMapByPcCreate(copPattOrdNo, copMapgSeq, minPctlNo, bkgNo);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return successCnt;
	}

	/**
	 * @param PrdQuantityVO[] prdQuantityVOs
	 * @param String bkgNo
	 * @param String bkgOfc
	 * @param String bkgRcvT
	 * @param String bkgDelT
	 * @param String chgRterm
	 * @param String chgDterm
	 * @param String currentFlag
	 * @param String flxHgtFlg
	 * @param String cntrTpszQty
	 * @return List<PrdPatternVO>
	 * @throws EventException
	 */
	private List<PrdPatternVO> getReplanePattern(PrdQuantityVO[] prdQuantityVOs, String bkgNo, String bkgOfc, String bkgRcvT, String bkgDelT, String chgRterm, String chgDterm, String currentFlag, String flxHgtFlg, String cntrTpszQty) throws EventException {

		List<PrdPatternVO> prdPatternVOs = null;
		List<PrdBkgCopMapVO> prdBkgCopMapVOs = new ArrayList<PrdBkgCopMapVO>();
		try {
			// updating CRNT_FLG of map table with 'N'
			dbDao.updatePrdMapInit(bkgNo, "");

			// getting PRD_BKG_COP_MAP_SEQ sequence
			String mapSeq = dbDao.getPrdBkgCopMapSeq();

			// prd map create
			prdBkgCopMapVOs = dbDao.getReplanePattern(bkgRcvT, bkgDelT, chgRterm, chgDterm, bkgNo, mapSeq, currentFlag, flxHgtFlg, cntrTpszQty, bkgOfc);
			dbDao.addReplanPatterns(prdBkgCopMapVOs);

			// grouping COP_PATT_ORD_NO
			// creating PC as much as COP_PATT_ORD_NO
			prdPatternVOs = dbDao.searchCurrentPatternOrd(mapSeq);
			log.debug("\n\n getReplanePattern end-----------------------");
			// getting map data by mapSeq
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}

		return prdPatternVOs;
	}

	/**
	 * @param PrdCreateParamVO prdCreateParamVO
	 * @throws EventException
	 */
	public void checkReplan(PrdCreateParamVO prdCreateParamVO) throws EventException {
		DBRowSet dbR = null;
		try {

			dbR = dbDao.checkReplane(prdCreateParamVO.getPor(), prdCreateParamVO.getPol(), prdCreateParamVO.getPod(), prdCreateParamVO.getDel(), prdCreateParamVO.getTVvd(), prdCreateParamVO.getRcvT(), prdCreateParamVO.getDelT(), prdCreateParamVO.getBkgNo());

			if (dbR.next()) {
				String errCd = dbR.getString("e_cd");
				String orgPctlNo = dbR.getString("pctl_no");
				String orgPctlSeq = dbR.getString("pctl_seq");
				String errTp = dbR.getString("e_tp");
				String errSoBnd = dbR.getString("so_bnd");
				String errMvmtBnd = dbR.getString("mvmt_bnd");

				log.debug("\n ------------------------------------------------------------------" + "\n   replan check code :" + errCd + "\n-------------------------------------------------------------------");

				if (!errCd.equals(PrdConstants.PRD_REPLAN_CHK_CD_E0000)) {
					// error - need to mapping the error message
					/*
					 * E0001 : Could not change the POR E0002 : Could not change the POL E0003 : Could not change the VVD E0004 : Could not change the POD E0005 : Could not change the DEL E0006 : Could not change the Receive Term E0007 : Could not change the Delivery Term E0009 : This status could
					 * not be replanned when the actual movement in COP status is IC, TN which is "I/B Truck terminal arrival or departure". Please, change the status to "YES"
					 */
					String errMSg = "";
					if (errCd.equals("E0001")) {
						errMSg = "PRD00014";
					} else if (errCd.equals("E0002")) {
						errMSg = "PRD00014";
					} else if (errCd.equals("E0003")) {
						errMSg = "PRD00014";
					} else if (errCd.equals("E0004")) {
						errMSg = "PRD00014";
					} else if (errCd.equals("E0005")) {
						errMSg = "PRD00014";
					} else if (errCd.equals("E0006")) {
						errMSg = "PRD00014";
					} else if (errCd.equals("E0007")) {
						errMSg = "PRD00014";
					} else if (errCd.equals("E0009")) {
						errMSg = "PRD00055";
					} else {
						errMSg = "PRD00013";
					}

					if (!errMSg.equals("")) {
						if (errTp.equals("MVMT")) {
							// The BKG can’t be updated with current CNTR MVMT status. Pls change “Status Change” of COP from “NO” to “YES” to update the BKG.
							errMSg = "PRD00078";
						} else if (errTp.equals("SOWO")) {
							// S/O of containers have been created already. Pls check the S/O of this booking in advance.
							errMSg = "PRD00014";
						} else if (errTp.equals("ALL")) {
							// Pls check both below to update the BKG
							// The BKG can’t be updated with current CNTR MVMT status. Pls change “Status Change” of COP from “NO” to “YES” to update the BKG.
							// S/O of containers have been created already. Pls check the S/O of this booking in advance.
							errMSg = "PRD00079";
						}
					}

					log.debug("\n\n PRD log On:");
					Map<String, Object> map = new HashMap<String, Object>();

					map.put("PrdCreateParamVO", prdCreateParamVO);
					map.put("errCd", errCd);
					map.put("orgPctlNo", orgPctlNo);
					map.put("orgPctlSeq", orgPctlSeq);
					map.put("errTp", errTp);
					map.put("errSoBnd", errSoBnd);
					map.put("errMvmtBnd", errMvmtBnd);

					String logDesc = this.getParamString(map);
					log.debug("\n\n log::::" + logDesc);
					dbDao.createPrdExecLog(logDesc, "checkReplan", "");

					log.debug("\n replan check :Replan is not available ! :  " + errMSg);
					throw new EventException((errMSg.equals("PRD00014") ? "" : ((new ErrorHandler(errMSg)).getMessage() + " #@ ")) + (new ErrorHandler("PRD00014")).getMessage());
				}
				dbR = dbDao.checkQtyReplan(prdCreateParamVO.getCntrTpszQtyStr(), prdCreateParamVO.getBkgNo(), prdCreateParamVO.getFlexHgtFlg());
				if (dbR.next()) {
					String result = dbR.getString("RESULT");
					if (!result.equals(PrdConstants.PRD_REPLAN_QTY_CHK_RESULT_OK)) {
						// error: can't change container quantity
						log.debug("\n\n PRD log On:");
						Map<String, Object> map = new HashMap<String, Object>();
						map.put("exec result", result);
						map.put("PrdCreateParamVO", prdCreateParamVO);

						String logDesc = this.getParamString(map);
						log.debug("\n\n log::::" + logDesc);
						dbDao.createPrdExecLog(logDesc, "checkQty", "");
						// PRD00056: The Container's Q'ty between BKG and COP is different.
						throw new EventException((new ErrorHandler("PRD00056")).getMessage());
					}

				}
			} else {
				// ERROR
				log.debug("\n no data for REPLAN");
				throw new EventException((new ErrorHandler("PRD00015")).getMessage());
			}

		} catch (DAOException e1) {
			log.error("err " + e1.toString(), e1);
			throw new EventException(new ErrorHandler(e1).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}

	}

	/**
	 * @param PrdParameterVO prdParameterVO
	 * @param SignOnUserAccount account
	 * @param List<String> cntrList
	 * @param int splitSeq
	 * @param List<String>
	 * @return String
	 * @throws EventException
	 */
	private String createBkgSplitVvd(PrdParameterVO prdParameterVO, SignOnUserAccount account, List<String> cntrList, int splitSeq, List<String> bkgNoList) throws EventException {
		PrdMainInfoVO prdMainInfoVO = prdParameterVO.getPrdMainInfoVO();
		String mapgSeq = "";
		StringBuilder succSum = new StringBuilder(); // for log

		try {
			boolean successFlag = false;
			String cntrTpszQtyStr = "";
			StringBuilder cntrSum = new StringBuilder();
			StringBuilder bkgNoSum = new StringBuilder();
			StringBuilder sbAdjQtyStr = new StringBuilder();
			StringBuilder sbSplitQtyCntStr = new StringBuilder();

			// PRD_BKG_COP_MAP_SEQ sequence get
			mapgSeq = dbDao.getPrdBkgCopMapSeq();
			String memoFlag = bkgNoList.contains(prdMainInfoVO.getParentBkgNo()) ? "0" : "1";
			if (cntrList != null) {
				for (int i = 0; i < cntrList.size(); i++) {
					cntrSum.append(cntrList.get(i)).append(", ");
				}
			}
			if (bkgNoList != null) {
				for (int i = 0; i < bkgNoList.size(); i++) {
					bkgNoSum.append(bkgNoList.get(i)).append(",");
				}
			}
			if ("1".equals(memoFlag)) {
				bkgNoSum.append(prdMainInfoVO.getParentBkgNo());
			}

			// if parent booking -> copying bkg_prd_cop_map
			if (prdMainInfoVO.getBkgNo().equals(prdMainInfoVO.getParentBkgNo())) {
				// because of Transaction guarantee, error in case of exsiting other bkg excepting parent in sce_cop_hdr
				if (!dbDao.checkBeforeBkgSplit(prdMainInfoVO.getBkgNo(), bkgNoSum.toString())) {
					// throws exception
					String[] msg = new String[] { prdMainInfoVO.getBkgNo() };
					throw new EventException(new ErrorHandler("PRD00080", msg).getMessage());
				}
				dbDao.updatePrdMapInit(prdMainInfoVO.getBkgNo(), bkgNoSum.toString());
				dbDao.createBkgSplitMapBase(prdMainInfoVO.getBkgNo(), mapgSeq);
			}

			// if !(parent booking && memo)
			if (!(prdMainInfoVO.getBkgNo().equals(prdMainInfoVO.getParentBkgNo()) && memoFlag.equals("1"))) {

				// recovering Booking data in case of Current = Y and existing Container
				successFlag = dbDao.createBkgSplitMapCntr(prdMainInfoVO, mapgSeq, cntrSum.toString(), bkgNoSum.toString());
				succSum.append("createBkgSplitMapCntr [").append(successFlag).append("]\n");

				// BKG_QUANTITY of SPLIT BOOKING - D4@4@BKG,D5@6@SO pattern
				List<PrdQtyInfoVO> prdQtyInfoVOList = prdParameterVO.getPrdQtyInfo();

				PrdQuantityVO[] prdQuantityVOs = new PrdQuantityVO[prdQtyInfoVOList.size()];
				if (prdQtyInfoVOList.size() > 0) {
					for (int i = 0; i < prdQtyInfoVOList.size(); i++) {
						prdQuantityVOs[i] = new PrdQuantityVO();
						prdQuantityVOs[i].setCTpsz(((PrdQtyInfoVO) prdQtyInfoVOList.get(i)).getCTpsz());
						prdQuantityVOs[i].setCQty(((PrdQtyInfoVO) prdQtyInfoVOList.get(i)).getCQty());
					}
				}
				cntrTpszQtyStr = this.getReplanCntrTpszQty(prdMainInfoVO.getBkgNo(), prdQuantityVOs);

				// check qty
				DBRowSet rowset = dbDao.searchBkgSplitQtyCount(prdMainInfoVO.getParentBkgNo(), prdMainInfoVO.getBkgNo(), mapgSeq, null, cntrTpszQtyStr); // using DB data if flexHgtFlg, cntrTpszQty is null

				log.debug(" ************************************************************ ");
				log.debug(" ************ BOOKING SPLIT ADJUSTMENT QTY ****************** ");
				log.debug(" CNTR_TPSZ_CD, BKG_QTY, PC_QTY, MOV_QTY, CALC_QTY, QTY(작업) ");

				boolean bFirst = true;
				while (rowset.next()) {
					log.debug(rowset.getString("cntr_tpsz_cd") + ", " + rowset.getString("bkg_qty") + ", " + rowset.getString("pc_qty") + ", " + rowset.getString("mov_qty") + ", " + rowset.getString("calc_qty") + ", " + rowset.getString("qty"));
					if (!bFirst) {
						sbAdjQtyStr.append(",");
					}
					sbAdjQtyStr.append(rowset.getString("cntr_tpsz_cd")).append("@").append(rowset.getString("qty"));
					sbSplitQtyCntStr.append(" : cntr_tpsz_cd[").append(rowset.getString("cntr_tpsz_cd")).append("]");
					sbSplitQtyCntStr.append(" : bkg_qty[").append(rowset.getString("bkg_qty")).append("]");
					sbSplitQtyCntStr.append(" : pc_qty[").append(rowset.getString("pc_qty")).append("]");
					sbSplitQtyCntStr.append(" : mov_qty[").append(rowset.getString("mov_qty")).append("]");
					sbSplitQtyCntStr.append(" : calc_qty[").append(rowset.getString("calc_qty")).append("]");
					sbSplitQtyCntStr.append(" : qty[").append(rowset.getString("qty")).append("]\n");
					bFirst = false;
				}
				log.debug(" ************************************************************ ");
				log.debug(" result [" + splitSeq + "]" + prdMainInfoVO.getBkgNo() + "[" + sbAdjQtyStr.toString() + "]");
				log.debug(" ************************************************************ ");

				if (!bFirst) { //
					successFlag = dbDao.createBkgSplitMapAdj(prdMainInfoVO, sbAdjQtyStr.toString(), mapgSeq, bkgNoSum.toString());
					succSum.append("createBkgSplitMapAdj [").append(successFlag).append("]\n");
				}
			}
			log.debug("\n\n PRD log On:");
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("successFlag", successFlag);
			map.put("succSum", succSum.toString());
			map.put("bkgNo", prdMainInfoVO.getBkgNo());
			map.put("ParentBkgNo", prdMainInfoVO.getParentBkgNo());
			map.put("memoFlag", memoFlag);
			map.put("cntrSum", cntrSum);
			map.put("splitSeq", splitSeq);
			map.put("bkgNoList", bkgNoList != null ? bkgNoList : null);
			map.put("cntrTpszQtyStr", cntrTpszQtyStr);
			map.put("sbAdjQtyStr", sbAdjQtyStr.toString());
			String logDesc = this.getParamString(map);
			log.debug("\n\n log::::" + logDesc);
			dbDao.createPrdExecLog(logDesc, "createBkgSplitVvd_1", account.getUsr_id());
			if (bkgNoList != null) {
				if (prdMainInfoVO.getBkgNo().equals(bkgNoList.get(bkgNoList.size() - 1))) {
					String firstBkgNo = bkgNoList.get(0);
					successFlag = dbDao.createBkgSplitMapCopAdj(prdMainInfoVO.getParentBkgNo(), firstBkgNo, mapgSeq);
				}
			}

		} catch (DAOException ex) {
			if (ex.getMessage() != null && ex.getMessage().indexOf("ORA-00054") != -1) {
				throw new EventException(new ErrorHandler("PRD00080").getMessage(), ex);
			} else {
				throw new EventException(ex.getMessage(), ex);
			}
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		log.debug("\n\n createBkgSplitVvd return :" + prdMainInfoVO.getBkgNo() + "|" + mapgSeq);
		return prdMainInfoVO.getBkgNo() + "|" + mapgSeq;

	}

	/**
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private String createBkgCopyVvdUnchange(Event e) throws EventException {
		EsdPrd0080Event event = (EsdPrd0080Event) e;
		PrdCreateParamVO prdCreateParamVO = event.getPrdCreateParamVO();
		SignOnUserAccount account = (SignOnUserAccount) e.getAttribute("account");

		// creating pc no
		PrdCreateManageBC prdCreateManageBc = new PrdCreateManageBCImpl();
		String hdPctlNo = prdCreateManageBc.createPrdCtlNoGen(prdCreateParamVO.getPcMode());

		// pc return value object create
		PrdPcCreateVO prdPcCreateVo = new PrdPcCreateVO();
		// pc_no_head set
		prdPcCreateVo.setHdPctlNo(hdPctlNo);

		event.setPrdPcCreateVO(prdPcCreateVo);
		int copyCnt = Integer.parseInt(prdCreateParamVO.getCopyCnt());
		DBRowSet rowSet = null;
		try {

			rowSet = dbDao.checkBkgCopy(prdCreateParamVO.getBkgNo());

			String bkgPctlNo = "";
			if (!rowSet.next()) {
				throw new EventException((new ErrorHandler("PRD00015")).getMessage());
			} else {
				String outB = rowSet.getString("out_b");
				String inB = rowSet.getString("in_b");
				bkgPctlNo = rowSet.getString("pctl_no");

				log.debug(" outB:" + outB + " inB:" + inB);
				if (outB.equals("X")) {
					throw new EventException((new ErrorHandler("PRD00026")).getMessage());
				}
				if (inB.equals("X")) {
					throw new EventException((new ErrorHandler("PRD00027")).getMessage());
				}
			}

			// // prd mst,dtl create
			for (int i = 1; i <= copyCnt; i++) {
				dbDao.createBkgCopyPrdMstVvdUnchange(bkgPctlNo, hdPctlNo, prdCreateParamVO.getScOfc(), prdCreateParamVO.getRfaOfc(), account.getUsr_id(), i, prdCreateParamVO.getSc(), prdCreateParamVO.getRfa());
				dbDao.createBkgCopyPrdDtlVvdUnchange(bkgPctlNo, hdPctlNo, account.getUsr_id(), i);
				dbDao.createBkgCopyPrdActGrpDtlVvdUnchange(bkgPctlNo, hdPctlNo, prdCreateParamVO.getScOfc(), prdCreateParamVO.getRfaOfc(), account.getUsr_id(), i);
				dbDao.updateBkgCopyVndr(hdPctlNo, i);
				dbDao.createBkgCopyPrdQtyVvdUnchange(bkgPctlNo, hdPctlNo, i);
				log.debug("\n\n PRD log On:");
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("PrdCreateParamVO", prdCreateParamVO);
				map.put("PrdPcCreateVO", prdPcCreateVo);
				map.put("bkgPctlNo", bkgPctlNo);
				map.put("hdPctlNo", hdPctlNo);
				map.put("usrId", account.getUsr_id());

				String logDesc = this.getParamString(map);
				log.debug("\n\n log::::" + logDesc);
				dbDao.createPrdExecLog(logDesc, "createPrdCtlgFullRout", account.getUsr_id());
			}

//			String sc_cust_cnt_cd = "";
//			String sc_cust_seq = "";
//			if (prdCreateParamVO.getSc().length() > 2) {
//				sc_cust_cnt_cd = prdCreateParamVO.getSc().substring(0, 2);
//				sc_cust_seq = prdCreateParamVO.getSc().substring(2);
//			}
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		log.debug("\n\n createBkgCopyVvdUnchange return :" + hdPctlNo + "0001");

		return hdPctlNo + "0001";
	}

	/**
	 * @param minPctlNo
	 * @return
	 * @throws EventException
	 */
	public String selectReturnStrToBkg(String minPctlNo) throws EventException {
		DBRowSet rowSet = null;
		String returnPrd = "";
		try {
			rowSet = dbDao.selectReturnStrToBkg(minPctlNo);
			String mtPuCy = "";
			String mPuDt = "";
			String flRtCy = "";
			String flPuCy = "";
			String doorDt = "";
			String loadDt = "";
			String delDt = "";
			String obMode = "";
			String ibMode = "";
			String porN = "";
			String delN = "";
			String mtRtnCy = "";
			String pcNo = "";
			String vvd = "";
			int cnt = 1;
			while (rowSet.next()) {

				if (rowSet.getString("VVD_GB").equals("T")) {

					vvd = rowSet.getString("VVD");

					returnPrd = returnPrd + "@*VVD" + cnt + "=" + rowSet.getString("VVD") + "@*POL" + cnt + "=" + rowSet.getString("ORG_NOD_CD") + "@*ETD" + cnt + "=" + rowSet.getString("ETD") + "@*POD" + cnt + "=" + rowSet.getString("DEST_NOD_CD") + "@*ETB" + cnt + "=" + rowSet.getString("ETB")
							+ "@*LAN" + cnt + "=" + rowSet.getString("VSL_SLAN_CD") + "@*MODE" + cnt + "=" + rowSet.getString("PCTL_WTR_DIV_CD") + "@*TRUNK_FLG" + cnt + "=" + (vvd.equals(rowSet.getString("T_VVD")) ? "Y" : "") + "@*GE" + cnt + "=" + rowSet.getString("GEN_AVAL_SPC") + "@*D7" + cnt
							+ "=" + rowSet.getString("D7_AVAL_SPC") + "@*RF" + cnt + "=" + rowSet.getString("RF_AVAL_SPC");

					log.debug("\n\n GEN:" + rowSet.getString("GEN_AVAL_SPC"));
					cnt++;
				}

				if (rowSet.getString("LOC").equals("RTN CY")) {
					mtRtnCy = rowSet.getString("NODE_LINK");
				}
				if (rowSet.getString("MTY_YD_FLG").equals("Y") && rowSet.getString("PCTL_SEQ").equals("1")) {
					mtPuCy = rowSet.getString("NODE_LINK");
					mPuDt = rowSet.getString("ETB");
				}
				if (rowSet.getString("PCTL_SEQ").equals("1")) {
					porN = rowSet.getString("ROUT_ORG_NOD_CD");
					pcNo = rowSet.getString("PCTL_NO");
				}

				if (rowSet.getString("DOOR_DT").equals("Y")) {
					doorDt = rowSet.getString("ETD");
				}
				if (rowSet.getString("MTY_YD_FLG").equals("N")) {
					delDt = rowSet.getString("DELIVERY_DT");
				}
				obMode = rowSet.getString("O_T_MODE");
				ibMode = rowSet.getString("I_T_MODE");

				if (rowSet.getString("PCTL_SEQ").equals(rowSet.getString("LOAD_DT_PCTL_SEQ"))) {
					loadDt = rowSet.getString("ETD");
				}

				flRtCy = rowSet.getString("NODE_LINK");

				flPuCy = rowSet.getString("NODE_LINK");
				delN = rowSet.getString("ROUT_DEST_NOD_CD");
			} // while

			returnPrd = "PCNo=" + pcNo + returnPrd + "@*MT_PU_CY=" + mtPuCy + "@*M_PU_DT=" + mPuDt + "@*FL_RT_CY=" + flRtCy + "@*FL_PU_CY=" + flPuCy + "@*DOOR_DT=" + doorDt + "@*LOAD_DT=" + loadDt + "@*DEL_DT=" + delDt + "@*OB_MODE=" + obMode + "@*IB_MODE=" + ibMode + "@*POR_N=" + porN + "@*DEL_N="
					+ delN + "@*MT_RTN_CY=" + mtRtnCy;
			log.debug("\n\n returnAutoPrd1=[" + returnPrd + "]");
		} catch (DAOException e1) {
			log.error("err " + e1.toString(), e1);
			throw new EventException(new ErrorHandler(e1).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return returnPrd;
	}

	/**
	 * PC create logic for creating PC at BKG
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	@SuppressWarnings("rawtypes")
	public EsdPrd0080Event createPrdCtlgFullRout(Event e) throws EventException {
		EsdPrd0080Event event = (EsdPrd0080Event) e;
		PrdCreateParamVO prdCreateParamVO = event.getPrdCreateParamVO();
		SignOnUserAccount account = (SignOnUserAccount) e.getAttribute("account");
		PrdPatternVO prdPatternVO = null;
		int successFlag = 0;
		PrdCreateManageBC prdCreateManageBc = new PrdCreateManageBCImpl();
		String hdPctlNo = prdCreateManageBc.createPrdCtlNoGen(prdCreateParamVO.getPcMode());

		PrdPcCreateVO prdPcCreateVo = new PrdPcCreateVO();
		prdPcCreateVo.setHdPctlNo(hdPctlNo);
		String skdType = prdCreateParamVO.getInternalSkdType();
		if (!"L".equals(skdType)) {
			skdType = prdCreateManageBc.getSkdType(prdCreateParamVO.getTVvd(), prdCreateParamVO.getLdDt(), prdCreateParamVO.getPol1());
		}
		prdPcCreateVo.setSkdType(skdType);

		log.debug("\n\n ========= " + prdPcCreateVo.getSkdType());
		if (skdType.equals("L")) {
			if (prdCreateParamVO.getInternalSkdType() != null && !prdCreateParamVO.getInternalSkdType().equals("") && prdCreateParamVO.getLdDt().equals("")) {
				prdCreateParamVO.setLdDt(new SimpleDateFormat("yyyyMMdd").format(new Date()));
			}
			prdPcCreateVo.setSkdDate(prdCreateParamVO.getLdDt());
		} else {
			prdPcCreateVo.setSkdDate(prdCreateParamVO.getTVvd());
		}

		event.setPrdPcCreateVO(prdPcCreateVo);

		try {
			if (prdCreateParamVO.getPcMode().equals(PrdConstants.PRD_PC_MOD_N)) {
				successFlag = dbDao.createProductCatalogInternalTemp(prdCreateParamVO, prdPcCreateVo, account.getUsr_id());
			} else if (prdCreateParamVO.getPcMode().equals(PrdConstants.PRD_PC_MOD_T)) {
				// if("".equals(prdCreateParamVO.getPol())){ // PRS > COA 용
				// successFlag = dbDao.createProductCatalogIncludeReplanePRS(prdCreateParamVO, prdPcCreateVo, account.getUsr_id());
				// }else{
				successFlag = dbDao.createProductCatalogIncludeReplane(event, prdCreateParamVO, prdPcCreateVo, null, skdType);
				// }
			} else if (prdCreateParamVO.getPcMode().equals(PrdConstants.PRD_PC_MOD_P)) {

				successFlag = dbDao.createProductCatalogIncludeReplane(event, prdCreateParamVO, prdPcCreateVo, null, skdType);

			} else if (prdCreateParamVO.getPcMode().equals(PrdConstants.PRD_PC_MOD_REPLAN)) {
				List list = (List) event.getAttribute("PATTERN_LIST");
				if (list != null && list.size() > 0) {
					prdPatternVO = (PrdPatternVO) list.get(0);
				}
				// pc mst, dtl create.
				successFlag = dbDao.createProductCatalogIncludeReplane(event, prdCreateParamVO, prdPcCreateVo, prdPatternVO != null ? prdPatternVO : null, account.getUsr_id());
				log.debug("\n\n createPrdCtlgFullRout creating PCsuccessFlag: " + successFlag);

				if (successFlag == 0) {
					log.debug("\n\n PRD log On:");
					Map<String, Object> map = new HashMap<String, Object>();
					map.put("PrdCreateParamVO", prdCreateParamVO);
					map.put("PrdPcCreateVO", prdPcCreateVo);
					map.put("PrdPatternVO", prdPatternVO != null ? prdPatternVO : null);
					map.put("hdPctlNo", hdPctlNo);
					map.put("usrId", account.getUsr_id());

					String logDesc = "successFlag " + Integer.toString(successFlag) + " " + this.getParamString(map);
					log.debug("\n\n log::::" + logDesc);
					dbDao.createPrdExecLog(logDesc, "createPrdCtlgFullRout", account.getUsr_id());
				}
				// MT PU DATE checking in case of calling from PC screen
				// MT PU DATE is later than SKD -> EXCEPTION
				// else -> changing SKD with new value
				log.debug("\n getRcvT():[" + prdCreateParamVO.getRcvT() + "], getMtPkupDt():[" + prdCreateParamVO.getMtPkupDt() + "]");
				if (!prdCreateParamVO.getRcvT().equals("S") && prdCreateParamVO.getMtPkupDt() != null && !prdCreateParamVO.getMtPkupDt().equals("")) {
					List prdMstList = dbDao.selectPrdMstByHdPctlNO(hdPctlNo);
					int prdMstCnt = prdMstList.size();

					int i = 0;
					int deleteCnt = 0;
					while (prdMstCnt >= 1 && i < prdMstCnt) {
						PrdProdCtlMstVO prdProdCtlMstVO = (PrdProdCtlMstVO) prdMstList.get(i);

						// deleting dtl and updating mode with 'X'
						if (!checkMtPkupDt(prdProdCtlMstVO.getPctlNo(), prdCreateParamVO.getMtPkupDt())) {
							int successsFlgMt = dbDao.updatePrdDtlByMtPuDtValidate(prdProdCtlMstVO.getPctlNo(), prdCreateParamVO.getMtPkupDt());
							log.debug("\n\n updatePrdDtlByMtPuDtValidate  successFlag: " + successsFlgMt);

							successsFlgMt = dbDao.updatePrdMstByMtPuDtValidate(prdProdCtlMstVO.getPctlNo());
							log.debug("\n\n updatePrdMstByMtPuDtValidate  successFlag: " + successsFlgMt);
							deleteCnt++;
						} else {
							// changing mt dt
							setMtPkupDt(prdProdCtlMstVO.getPctlNo(), prdCreateParamVO.getMtPkupDt());
						}
						i++;
					}
					log.debug("\n\n\n creating PC count = deleted count => exception -------------" + "\n prdMstCnt:" + prdMstCnt + "\n deleteCnt:" + deleteCnt + "\n-------------------------------------------------------------------\n\n");
					if (prdMstCnt >= 1 && prdMstCnt == deleteCnt) {
						throw new EventException(new ErrorHandler("PRD00058").getMessage());
					}
				}
			} else { // creating norma PC(B)
				successFlag = dbDao.createProductCatalogIncludeReplane(event, prdCreateParamVO, prdPcCreateVo, prdPatternVO != null ? prdPatternVO : null, account.getUsr_id());
				if (successFlag == 0) {
					log.debug("\n\n PRD log On:");
					Map<String, Object> map = new HashMap<String, Object>();
					map.put("PrdCreateParamVO", prdCreateParamVO);
					map.put("PrdPcCreateVO", prdPcCreateVo);
					map.put("PrdPatternVO", prdPatternVO != null ? prdPatternVO : null);
					map.put("hdPctlNo", hdPctlNo);
					map.put("usrId", account.getUsr_id());

					String logDesc = "successFlag " + Integer.toString(successFlag) + " " + this.getParamString(map);
					log.debug("\n\n log::::" + logDesc);
					dbDao.createPrdExecLog(logDesc, "createPrdCtlgFullRout", account.getUsr_id());
				}

				// MT PU DATE checking in case of calling from PC screen
				// MT PU DATE is later than SKD -> EXCEPTION
				// else updating SKD with new value
				log.debug("\n getRcvT():[" + prdCreateParamVO.getRcvT() + "], getMtPkupDt():[" + prdCreateParamVO.getMtPkupDt() + "]");
				log.debug("\n\n  %%%%%%%  prdCreateParamVO.getMtPkupDt(): " + prdCreateParamVO.getMtPkupDt());
				if (!prdCreateParamVO.getRcvT().equals("S") && prdCreateParamVO.getMtPkupDt() != null && !prdCreateParamVO.getMtPkupDt().equals("")) {
					List prdMstList = dbDao.selectPrdMstByHdPctlNO(hdPctlNo);
					int prdMstCnt = prdMstList.size();
					log.debug("\n\n  %%%%%%%  prdMstCnt: " + prdMstCnt);

					int i = 0;
					int deleteCnt = 0;
					while (prdMstCnt >= 1 && i < prdMstCnt) {
						PrdProdCtlMstVO prdProdCtlMstVO = (PrdProdCtlMstVO) prdMstList.get(i);
						log.debug("\n\n  %%%%%%%  getPctlNo: " + prdProdCtlMstVO.getPctlNo());
						if (!checkMtPkupDt(prdProdCtlMstVO.getPctlNo(), prdCreateParamVO.getMtPkupDt())) {
							// dtl delete
							int successsFlgMt = dbDao.updatePrdDtlByMtPuDtValidate(prdProdCtlMstVO.getPctlNo(), prdCreateParamVO.getMtPkupDt());
							log.debug("\n\n updatePrdDtlByMtPuDtValidate  successFlag: " + successsFlgMt);
							// pc mode -> X
							successsFlgMt = dbDao.updatePrdMstByMtPuDtValidate(prdProdCtlMstVO.getPctlNo());
							log.debug("\n\n updatePrdMstByMtPuDtValidate  successFlag: " + successsFlgMt);
							deleteCnt++;

						} else {
							// changing mt dt
							setMtPkupDt(prdProdCtlMstVO.getPctlNo(), prdCreateParamVO.getMtPkupDt());
						}
						i++;
					}
					log.debug("\n\n\n creating PC cnt =  deleted count -> exception -------------" + "\n prdMstCnt:" + prdMstCnt + "\n deleteCnt:" + deleteCnt + "\n-------------------------------------------------------------------\n\n");
					if (prdMstCnt >= 1 && prdMstCnt == deleteCnt) {
						throw new EventException(new ErrorHandler("PRD00058").getMessage());
					}
				}

			}

			// no error but not created PC
			if (successFlag <= 0) {
				event.setAttribute("prdPatternVO", prdPatternVO != null ? prdPatternVO : null);
				throw new EventException((new ErrorHandler("PRD00074")).getMessage());
			}
			// qty create
			prdCreateManageBc.createContainerQty(e);
			// data (min, max pc no )
			prdCreateManageBc.dataArrangement(e);
			log.debug("\n\n -------------dataArrangement e----------------------");

			// activity group dtl creating
			prdCreateManageBc.createActivityGroupIncludePattern(prdPcCreateVo, prdPatternVO != null ? prdPatternVO : null, account.getUsr_id());
			log.debug("\n\n -------------createActivityGroup end----------------------");
			// activity group dtl update
			prdCreateManageBc.updateActivityGroup(hdPctlNo);

			log.debug("\n\n -------------createActivityGroup end----------------------");
			return event;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * @param pctlNo
	 * @param mtPkupDt
	 * @return
	 * @throws EventException
	 */
	private boolean checkMtPkupDt(String pctlNo, String mtPkupDt) throws EventException {
		DBRowSet dbR = null;
		boolean returnVal = true;
		try {
			dbR = dbDao.checkMtPkupDt(pctlNo, mtPkupDt);
			if (dbR.next()) {
				if (dbR.getString("CHECK_MT_PU").equals("OK")) {
					log.debug("\n\ncheckMtPkupDt:OK");
					returnVal = true;
				} else {
					log.debug("\n\ncheckMtPkupDt:Exception");
					returnVal = false;

				}
			}

		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return returnVal;
	}

	/**
	 * @param pctlNo
	 * @param mtPkupDt
	 * @throws EventException
	 */
	private void setMtPkupDt(String pctlNo, String mtPkupDt) throws EventException {
		int ret = 0;
		try {
			ret = dbDao.setMtPkupDt(pctlNo, mtPkupDt);
			log.debug("\n setMtPkupDt update ret value: " + ret);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * @param e
	 * @param prdPatternVO
	 * @throws EventException
	 */
	public void createPrdCtlgIncludeReplane(Event e, PrdPatternVO prdPatternVO) throws EventException {
		EsdPrd0080Event event = (EsdPrd0080Event) e;
		PrdCreateParamVO prdCreateParamVO = event.getPrdCreateParamVO();

		SignOnUserAccount account = (SignOnUserAccount) e.getAttribute("account");

		// creating pc no
		PrdCreateManageBC prdCreateManageBc = new PrdCreateManageBCImpl();
		String hdPctlNo = prdCreateManageBc.createPrdCtlNoGen(prdCreateParamVO.getPcMode());

		// pc return value object create (create)
		PrdPcCreateVO prdPcCreateVo = new PrdPcCreateVO();
		// pc_no_head set
		prdPcCreateVo.setHdPctlNo(hdPctlNo);

		// skdType(L,V) .
		String skdType = prdCreateManageBc.getSkdType(prdCreateParamVO.getTVvd(), prdCreateParamVO.getLdDt(), prdCreateParamVO.getPol1());

		// skdType(L,V) setting, skdDate setting.
		prdPcCreateVo.setSkdType(skdType);

		// skdDate setting. (date, vvd)
		if (skdType.equals("L")) {
			prdPcCreateVo.setSkdDate(prdCreateParamVO.getLdDt());
		} else {
			prdPcCreateVo.setSkdDate(prdCreateParamVO.getTVvd());
		}

		// setting created PC.
		event.setPrdPcCreateVO(prdPcCreateVo);

		try {
			int successCnt = dbDao.createProductCatalogIncludeReplane(event, prdCreateParamVO, prdPcCreateVo, prdPatternVO, account.getUsr_id());

			if (successCnt == 0) {
				log.debug("\n\n PRD log On:");
				Map<String, Object> map = new HashMap<String, Object>();

				map.put("PrdCreateParamVO", prdCreateParamVO);
				map.put("PrdPcCreateVO", prdPcCreateVo);
				map.put("PrdPatternVO", prdPatternVO);
				map.put("usrId", account.getUsr_id());

				String logDesc = "successFlag " + Integer.toString(successCnt) + " " + this.getParamString(map);
				log.debug("\n\n log::::" + logDesc);

				dbDao.createPrdExecLog(logDesc, "createPrdCtlgIncludeReplane", account.getUsr_id());
			}

			// // qty create
			prdCreateManageBc.createContainerQty(e);
			//
			// // data (min, max pc no )
			prdCreateManageBc.dataArrangement(e);
			//
			log.debug("\n\n -------------dataArrangement end----------------------");

			// // activity group dtl create
			prdCreateManageBc.createActivityGroupIncludePattern(prdPcCreateVo, prdPatternVO, account.getUsr_id());

			log.debug("\n\n -------------createActivityGroup end----------------------");
			//
			// // activity group dtl update
			prdCreateManageBc.updateActivityGroup(hdPctlNo);

			log.debug("\n\n -------------createActivityGroup end----------------------");

		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}

	}

	private String getParamString(Map<String, Object> map) {
		HashMap<String, Object> hMap = (HashMap<String, Object>) map;
		PrdCreateParamVO prdCreateParamVO = null;
		PrdPcCreateVO prdPcCreateVo = null;
		PrdPatternVO prdPatternVO = null;
		PrdSceGetParamVO prdSceGetParamVO = null;
		PrdQtyInfoVO prdQtyInfoVO = null; // split log
		StringBuilder sb = new StringBuilder();
		Map<String, String> vo1 = new HashMap<String, String>();

		Object[] keyL = (Object[]) hMap.keySet().toArray();
		for (int i = 0; i < keyL.length; i++) {
			String keyS = (String) keyL[i];
			log.debug("n\n\n" + keyS);
			if (((String) keyL[i]).contains("PrdCreateParamVO")) {
				prdCreateParamVO = (PrdCreateParamVO) map.get((String) keyL[i]);
				sb.append("\r▶" + (String) keyL[i] + " ▶ ");
				if (prdCreateParamVO == null) {

					sb.append("\r▶  " + "is NULL");
				} else {
					vo1 = prdCreateParamVO.getColumnValues();
					sb.append("\r▶  " + vo1.toString());
				}
			} else if (((String) keyL[i]).contains("PrdPcCreateVO")) {
				prdPcCreateVo = (PrdPcCreateVO) map.get((String) keyL[i]);
				sb.append("\r▶" + (String) keyL[i] + " ▶ ");
				if (prdPcCreateVo == null) {
					sb.append("\r▶  " + "is NULL");
				} else {
					vo1 = prdPcCreateVo.getColumnValues();
					sb.append("\r▶  " + vo1.toString());
				}

			} else if (((String) keyL[i]).contains("PrdPatternVO")) {
				prdPatternVO = (PrdPatternVO) map.get((String) keyL[i]);
				sb.append("\r▶" + (String) keyL[i] + " ▶ ");
				if (prdPatternVO == null) {
					sb.append("\r▶  " + "is NULL");
				} else {
					vo1 = prdPatternVO.getColumnValues();
					sb.append("\r▶  " + vo1.toString());
				}

			} else if (((String) keyL[i]).contains("PrdSceGetParamVO")) {
				prdSceGetParamVO = (PrdSceGetParamVO) map.get((String) keyL[i]);

				sb.append("\r▶" + (String) keyL[i] + " ▶ ");
				if (prdSceGetParamVO == null) {
					sb.append("\r▶  " + "is NULL");
				} else {
					vo1 = prdSceGetParamVO.getColumnValues();
					sb.append("\r▶  " + vo1.toString());
				}
			} else if (((String) keyL[i]).contains("PrdQtyInfoVO")) {
				prdQtyInfoVO = (PrdQtyInfoVO) map.get((String) keyL[i]);

				sb.append("\r▶" + (String) keyL[i] + " ▶ ");
				if (prdQtyInfoVO == null) {
					sb.append("\r▶  " + "is NULL");
				} else {
					vo1 = prdQtyInfoVO.getColumnValues();
					sb.append("\r▶  " + vo1.toString());
				}
			} else {
				sb.append("\r▶" + (String) keyL[i] + " ▶ ");
				sb.append(hMap.get((String) keyL[i]) == null ? "is Null" : hMap.get((String) keyL[i]));
			}

		}

		return sb.toString();

	}

	/**
	 * @param e
	 * @param prdSearchEurDrRePatternVO
	 * @param prdPatternVO
	 * @throws EventException
	 */
	public void createPrdCtlgEurDoor(Event e, PrdSearchEurDrRePatternVO prdSearchEurDrRePatternVO, PrdPatternVO prdPatternVO) throws EventException {
		EsdPrd0080Event event = (EsdPrd0080Event) e;
		PrdCreateParamVO prdCreateParamVO = event.getPrdCreateParamVO();

		SignOnUserAccount account = (SignOnUserAccount) e.getAttribute("account");

		// creating pc no
		PrdCreateManageBC prdCreateManageBc = new PrdCreateManageBCImpl();
		String hdPctlNo = prdCreateManageBc.createPrdCtlNoGen(prdCreateParamVO.getPcMode());

		PrdSceGetParamVO prdSceGetParamVO = null;

		// pc return value object create (create)
		PrdPcCreateVO prdPcCreateVo = new PrdPcCreateVO();
		// pc_no_head set
		prdPcCreateVo.setHdPctlNo(hdPctlNo);

		event.setPrdPcCreateVO(prdPcCreateVo);

		String obPctlNo = null;
		String ibPctlNo = null;
		String ocnPctlNo = null;

		String rePctlNo = null;

		String ioBndCd = null;
		String doorZn = null;
		String fullRtnCy = null;
		String fullPuCy = null;
		String mtPu = null;
		String mtRtn = null;
//		String trspModCd = null;
		String copNo = prdSearchEurDrRePatternVO.getCopNo();
		String pcMode = null;
		String srTerm = null;
		String sdTerm = null;
//		String cct = null;
//		String podT = null;
//		String polT = null;
//		String inlndRoutOrg = null;
//		String prdCtlNo = null;
//		String subRout = null;
//		String fullCy = null;

		if (prdSearchEurDrRePatternVO.getEurObFlg().equals("Y") && prdSearchEurDrRePatternVO.getPolTmlDiffFlg().equals("N")) {
			obPctlNo = prdSearchEurDrRePatternVO.getOldPctlNo();
		} else {
			obPctlNo = prdSearchEurDrRePatternVO.getNewPctlNo();
		}
		if (prdSearchEurDrRePatternVO.getEurIbFlg().equals("Y") && prdSearchEurDrRePatternVO.getPodTmlDiffFlg().equals("N")) {
			ibPctlNo = prdSearchEurDrRePatternVO.getOldPctlNo();
		} else {
			ibPctlNo = prdSearchEurDrRePatternVO.getNewPctlNo();
		}
		ocnPctlNo = prdSearchEurDrRePatternVO.getNewPctlNo();

		srTerm = prdSearchEurDrRePatternVO.getBkgRcvTermCd();
		sdTerm = prdSearchEurDrRePatternVO.getBkgDeTermCd();
//		cct = prdSearchEurDrRePatternVO.getCct();
//		podT = prdSearchEurDrRePatternVO.getPodT();
//		polT = prdSearchEurDrRePatternVO.getPolT();
		fullPuCy = prdSearchEurDrRePatternVO.getFullPkupYdCd();
		mtRtn = prdSearchEurDrRePatternVO.getMtyRtnYdCd();
		fullRtnCy = prdSearchEurDrRePatternVO.getFullRtnYdCd();
		mtPu = prdSearchEurDrRePatternVO.getMtyPkupYdCd();
//		prdCtlNo = prdSearchEurDrRePatternVO.getNewPctlNo();

		int successCnt = 0;

		if ((prdSearchEurDrRePatternVO.getPodTmlDiffFlg().equals("Y") && prdSearchEurDrRePatternVO.getEurIbFlg().equals("Y")) || (prdSearchEurDrRePatternVO.getPolTmlDiffFlg().equals("Y") && prdSearchEurDrRePatternVO.getEurObFlg().equals("Y"))) {
			// param set start
			if ("Y".equals(prdSearchEurDrRePatternVO.getEurObFlg())) {
				ioBndCd = "O";
				pcMode = "O";
				srTerm = "D";
				doorZn = prdSearchEurDrRePatternVO.getNewPor();
//				trspModCd = prdSearchEurDrRePatternVO.getObTrspMod();
//				subRout = prdSearchEurDrRePatternVO.getObContent();
//				fullCy = prdSearchEurDrRePatternVO.getFullRtnYdCd();
			} else if ("Y".equals(prdSearchEurDrRePatternVO.getEurIbFlg())) {
				ioBndCd = "I";
				pcMode = "I";
				sdTerm = "D";
				doorZn = prdSearchEurDrRePatternVO.getNewDel();
//				trspModCd = prdSearchEurDrRePatternVO.getIbTrspMod();
//				subRout = prdSearchEurDrRePatternVO.getIbContent();
//				fullCy = prdSearchEurDrRePatternVO.getFullPkupYdCd();
			} else {
				ioBndCd = "";
				pcMode = "";
				doorZn = "";
			}

			List<PrdSceGetParamVO> list = null;
			try {
				list = dbDaoSce.sceGetParam(copNo, ioBndCd, pcMode, doorZn, fullRtnCy, fullPuCy, mtPu, mtRtn);
			} catch (DAOException e1) {
				log.error("err " + e1.toString(), e1);
				throw new EventException(new ErrorHandler(e1).getMessage());
			}

			if (list != null && list.size() > 0) {
				prdSceGetParamVO = (PrdSceGetParamVO) list.get(0);
//				inlndRoutOrg = JSPUtil.getNull(prdSceGetParamVO.getRoutOrgNodCd());

				if (ioBndCd != null && "O".equals(ioBndCd)) {
					prdSceGetParamVO.setDelCd(prdCreateParamVO.getDel());
					prdSceGetParamVO.setDelNodCd(prdCreateParamVO.getDelN());
					if (doorZn != null) {
						prdSceGetParamVO.setPorCd(doorZn.substring(0, 5));
						prdSceGetParamVO.setPorNodCd(doorZn);
					}
				} else {
					prdSceGetParamVO.setPorCd(prdCreateParamVO.getPor());
					prdSceGetParamVO.setPorNodCd(prdCreateParamVO.getPorN());
					if (doorZn != null) {
						prdSceGetParamVO.setDelCd(doorZn.substring(0, 5));
						prdSceGetParamVO.setDelNodCd(doorZn);
					}
				}

				prdSceGetParamVO.setEurCheck("Y");
				prdSceGetParamVO.setRcvTermCd(srTerm);
				prdSceGetParamVO.setDeTermCd(sdTerm);
				prdSceGetParamVO.setPolCd(prdCreateParamVO.getPol());
				prdSceGetParamVO.setPodCd(prdCreateParamVO.getPod());
				prdSceGetParamVO.setMtPu(mtPu);

				prdSceGetParamVO.setFullRtnYdCd(prdSearchEurDrRePatternVO.getFullRtnYdCd());
				prdSceGetParamVO.setFullPkupYdCd(prdSearchEurDrRePatternVO.getFullPkupYdCd());
				prdSceGetParamVO.setObTrspMode(prdSearchEurDrRePatternVO.getObTrspMod());
				prdSceGetParamVO.setIbTrspMode(prdSearchEurDrRePatternVO.getIbTrspMod());

				prdSceGetParamVO.setOcnBound(prdSearchEurDrRePatternVO.getOcnContent());
				prdSceGetParamVO.setOutBound(prdSearchEurDrRePatternVO.getObContent());
				prdSceGetParamVO.setInBound(prdSearchEurDrRePatternVO.getIbContent());

				prdSceGetParamVO.setNewPod(prdSearchEurDrRePatternVO.getNewPod());
				prdSceGetParamVO.setNewPol(prdSearchEurDrRePatternVO.getNewPol());
				prdSceGetParamVO.setN1PolClptSeq(prdSearchEurDrRePatternVO.getN1PolClptSeq());
				prdSceGetParamVO.setN1PodClptSeq(prdSearchEurDrRePatternVO.getN1PodClptSeq());
				prdSceGetParamVO.setN2PolClptSeq(prdSearchEurDrRePatternVO.getN2PolClptSeq());
				prdSceGetParamVO.setN2PodClptSeq(prdSearchEurDrRePatternVO.getN2PodClptSeq());
				prdSceGetParamVO.setN3PolClptSeq(prdSearchEurDrRePatternVO.getN3PolClptSeq());
				prdSceGetParamVO.setN3PodClptSeq(prdSearchEurDrRePatternVO.getN3PodClptSeq());
				prdSceGetParamVO.setN4PolClptSeq(prdSearchEurDrRePatternVO.getN4PolClptSeq());
				prdSceGetParamVO.setN4PodClptSeq(prdSearchEurDrRePatternVO.getN4PodClptSeq());

				prdSceGetParamVO.setVvd1(prdSearchEurDrRePatternVO.getVvd1());
				prdSceGetParamVO.setVvd2(prdSearchEurDrRePatternVO.getVvd2());
				prdSceGetParamVO.setVvd3(prdSearchEurDrRePatternVO.getVvd3());
				prdSceGetParamVO.setVvd4(prdSearchEurDrRePatternVO.getVvd4());
				prdSceGetParamVO.setOrgLocCd(prdSearchEurDrRePatternVO.getOrgLocCd());
				prdSceGetParamVO.setDestLocCd(prdSearchEurDrRePatternVO.getDestLocCd());
				prdSceGetParamVO.setOcnSeq(prdSearchEurDrRePatternVO.getOcnSeq());
				prdSceGetParamVO.setTVvd(prdSearchEurDrRePatternVO.getTVvd());
			}
			try {
				successCnt = dbDaoSce.createSceSoReplaneOcnInlndChange(prdSceGetParamVO != null ? prdSceGetParamVO : null, hdPctlNo);
				if (successCnt == 0) {
					log.debug("\n\n PRD log On:");
					Map<String, Object> map = new HashMap<String, Object>();
					if (prdSceGetParamVO != null) {
						map.put("PrdSceGetParamVO", prdSceGetParamVO);
					} else {
						map.put("PrdSceGetParamVO", null);
					}
					map.put("hdPctlNo", hdPctlNo);
					map.put("usrId", account.getUsr_id());

					String logDesc = "successFlag " + Integer.toString(successCnt) + " " + this.getParamString(map);
					log.debug("\n\n log::::" + logDesc);

					dbDao.createPrdExecLog(logDesc, "createPrdCtlgEurDoor_1", account.getUsr_id());
				}
			} catch (DAOException e2) {
				log.error("err " + e2.toString(), e2);
				throw new EventException(new ErrorHandler(e2).getMessage());
			}
		} else {
			try {
				successCnt = dbDao.reCreatePrdForEurDoor(obPctlNo, ibPctlNo, ocnPctlNo, hdPctlNo);
				if (successCnt == 0) {
					log.debug("\n\n PRD log On:");
					Map<String, Object> map = new HashMap<String, Object>();

					map.put("obPctlNo", obPctlNo);
					map.put("ibPctlNo", ibPctlNo);
					map.put("ocnPctlNo", ocnPctlNo);
					map.put("hdPctlNo", hdPctlNo);
					map.put("usrId", account.getUsr_id());

					String logDesc = "successFlag " + Integer.toString(successCnt) + " " + this.getParamString(map);
					log.debug("\n\n log::::" + logDesc);

					dbDao.createPrdExecLog(logDesc, "createPrdCtlgEurDoor_2", account.getUsr_id());
				}
			} catch (DAOException e3) {
				log.error("err " + e3.toString(), e3);
				throw new EventException(new ErrorHandler(e3).getMessage());
			}
		}

		try {
			rePctlNo = dbDao.searchDirectOcn(prdPcCreateVo.getHdPctlNo());
			if (rePctlNo.equals("FAIL")) {
				if (ioBndCd != null) {
					if (!CheckUtilities.isInBlank(ioBndCd)) {
						if ("O".equals(ioBndCd) && prdSearchEurDrRePatternVO.getObUnconfirmFlg().equals("N")) {
							successCnt = dbDao.updatePrdMapByPcCreateFail(prdSearchEurDrRePatternVO.getCopPattOrdNo(), event.getAttribute("eur_dr_seq") + "");
						} else if ("I".equals(ioBndCd) && prdSearchEurDrRePatternVO.getIbUnconfirmFlg().equals("N")) {
							successCnt = dbDao.updatePrdMapByPcCreateFail(prdSearchEurDrRePatternVO.getCopPattOrdNo(), event.getAttribute("eur_dr_seq") + "");
						}
					}
				}
				if (successCnt == 0) {
					log.debug("\n\n PRD log On:");
					Map<String, Object> map = new HashMap<String, Object>();

					map.put("CopPattOrdNo", prdSearchEurDrRePatternVO.getCopPattOrdNo());
					map.put("eur_dr_seq", event.getAttribute("eur_dr_seq"));

					map.put("usrId", account.getUsr_id());

					String logDesc = "successFlag " + Integer.toString(successCnt) + " " + this.getParamString(map);
					log.debug("\n\n log::::" + logDesc);

					dbDao.createPrdExecLog(logDesc, "createPrdCtlgEurDoor_mf", account.getUsr_id());
				}
			} else {

				// // qty create
				prdCreateManageBc.createContainerQty(e);
				//
				// // data (min, max pc no )
				prdCreateManageBc.dataArrangement(e);
				// log.debug("\n\n -------------dataArrangement end----------------------");

				// // activity group dtl create
				prdCreateManageBc.createActivityGroupIncludePattern(prdPcCreateVo, prdPatternVO, account.getUsr_id());
				log.debug("\n\n -------------createActivityGroup end----------------------");
				//
				// // activity group dtl update
				prdCreateManageBc.updateActivityGroup(hdPctlNo);
				log.debug("\n\n -------------createActivityGroup end----------------------");

				successCnt = updatePrdMapByPcCreate(prdSearchEurDrRePatternVO.getCopPattOrdNo(), event.getAttribute("eur_dr_seq") + "", rePctlNo, prdCreateParamVO.getBkgNo());
				if (successCnt == 0) {
					log.debug("\n\n PRD log On:");
					Map<String, Object> map = new HashMap<String, Object>();

					map.put("hdPctlNo", hdPctlNo);
					map.put("usrId", account.getUsr_id());

					String logDesc = "successFlag " + Integer.toString(successCnt) + " " + this.getParamString(map);
					log.debug("\n\n log::::" + logDesc);

					dbDao.createPrdExecLog(logDesc, "createPrdCtlgEurDoor_map", account.getUsr_id());
				}
			}

		} catch (DAOException e4) {
			log.error("err " + e4.toString(), e4);
			throw new EventException(new ErrorHandler(e4).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}

	}

	/**
	 * @param e
	 * @throws EventException
	 */
	public void addValCheck(Event e) throws EventException {
		EsdPrd0083Event event = (EsdPrd0083Event) e;
		PrdValChkVO prdValChkVO = event.getPrdValChkVO();
		SignOnUserAccount account = (SignOnUserAccount) event.getAttribute("account");
		int successFlag = 0;

		try {
			// from val check table
			successFlag = dbDao.addValCheck(prdValChkVO.getPcno(), prdValChkVO.getValChkcd(), prdValChkVO.getRemark(), account.getUsr_id());
			log.debug("\n\n addValCheck successFlag: " + successFlag);

		} catch (DAOException e1) {
			log.error("err " + e1.toString(), e1);
			throw new EventException(new ErrorHandler(e1).getMessage());
		}
	}

	/**
	 * using at COA CM/OP Simulation
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	@Override
	public DBRowSet createPrdCtlgFullRoutForCOA(Event e) throws EventException {
		EsdPrd0080Event event = (EsdPrd0080Event) e;
		DBRowSet rowset = null;
		try {
			// creating PC ---------------------------------------------------------------------------
			this.createPrdCtlgFullRout(event);
			// master retrieving ---------------------------------------------------------------------------
			rowset = new ProductCatalogCreateDBDAO().searchProductCatalogInternalMst_1(event.getPrdPcCreateVO().getHdPctlNo());
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}

		return rowset;

	}

	/**
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse selectPrdRoutUnit(Event e) throws EventException {
		EsdPrd0080Event event = (EsdPrd0080Event) e;
		// selected screen
		// 1.ocn route
		// 2.mt pick up yard
		// 3.full return yard
		DBRowSet dbRowsetEmpty = null;
		DBRowSet dbRowsetFullRtn = null;
		DBRowSet dbRowsetRouteInfo = null;
		DBRowSet dbRowsetPortCct = null;

		GeneralEventResponse eventResponse = new GeneralEventResponse();

		PrdPcCreateVO prdPcCreateVO = (PrdPcCreateVO) event.getPrdPcCreateVO();
		PrdCreateParamVO prdCreateParamVO = (PrdCreateParamVO) event.getPrdCreateParamVO();
		try {
			List<PrdOcnRoutDoubleCallingVO> listOcn = dbDao.searchPrdCtlOcnRoutDoubleCalling(prdPcCreateVO.getHdPctlNo(), prdPcCreateVO.getSkdDate(), prdPcCreateVO.getSkdType());

			// default pc no
			String viewPctlNo = "";
			log.debug("\n\n searchPrdCtlOcnRoutDoubleCalling listOcn size" + listOcn.size());
			if (listOcn.size() > 0) {
				PrdOcnRoutDoubleCallingVO prdOcnRoutDoubleCallingVO = (PrdOcnRoutDoubleCallingVO) listOcn.get(0);
				viewPctlNo = prdOcnRoutDoubleCallingVO.getPctlNo();
			}

			String prePol1Dc1Flg = "N";
			String postPol1Dc1Flg = "N";
			String prePod1Dc1Flg = "N";
			String postPod1Dc1Flg = "N";
			String prePol2Dc1Flg = "N";
			String postPol2Dc1Flg = "N";
			String prePod2Dc1Flg = "N";
			String postPod2Dc1Flg = "N";
			String prePol3Dc1Flg = "N";
			String postPol3Dc1Flg = "N";
			String prePod3Dc1Flg = "N";
			String postPod3Dc1Flg = "N";
			String prePol4Dc1Flg = "N";
			String postPol4Dc1Flg = "N";
			String prePod4Dc1Flg = "N";
			String postPod4Dc1Flg = "N";

			for (int i = 0; i < listOcn.size(); i++) {
				PrdOcnRoutDoubleCallingVO prdOcnRoutDoubleCallingVO = (PrdOcnRoutDoubleCallingVO) listOcn.get(i);
				if (!prdOcnRoutDoubleCallingVO.getPreN1stPolDc().equals("")) {
					prePol1Dc1Flg = "Y";
				}
				if (!prdOcnRoutDoubleCallingVO.getPostN1stPolDc().equals("")) {
					postPol1Dc1Flg = "Y";
				}

				if (!prdOcnRoutDoubleCallingVO.getPreN1stPodDc().equals("")) {
					prePod1Dc1Flg = "Y";
				}
				if (!prdOcnRoutDoubleCallingVO.getPostN1stPodDc().equals("")) {
					postPod1Dc1Flg = "Y";
				}
				// --------------
				if (!prdOcnRoutDoubleCallingVO.getPreN2ndPolDc().equals("")) {
					prePol2Dc1Flg = "Y";
				}
				if (!prdOcnRoutDoubleCallingVO.getPostN2ndPolDc().equals("")) {
					postPol2Dc1Flg = "Y";
				}
				if (!prdOcnRoutDoubleCallingVO.getPreN2ndPodDc().equals("")) {
					prePod2Dc1Flg = "Y";
				}
				if (!prdOcnRoutDoubleCallingVO.getPostN2ndPodDc().equals("")) {
					postPod2Dc1Flg = "Y";
				}
				// -----------------
				if (!prdOcnRoutDoubleCallingVO.getPreN3rdPolDc().equals("")) {
					prePol3Dc1Flg = "Y";
				}
				if (!prdOcnRoutDoubleCallingVO.getPostN3rdPolDc().equals("")) {
					postPol3Dc1Flg = "Y";
				}
				if (!prdOcnRoutDoubleCallingVO.getPreN3rdPodDc().equals("")) {
					prePod3Dc1Flg = "Y";
				}
				if (!prdOcnRoutDoubleCallingVO.getPostN3rdPodDc().equals("")) {
					postPod3Dc1Flg = "Y";
				}
				// ------------------
				if (!prdOcnRoutDoubleCallingVO.getPreN4thPolDc().equals("")) {
					prePol4Dc1Flg = "Y";
				}
				if (!prdOcnRoutDoubleCallingVO.getPostN4thPolDc().equals("")) {
					postPol4Dc1Flg = "Y";
				}
				if (!prdOcnRoutDoubleCallingVO.getPreN4thPodDc().equals("")) {
					prePod4Dc1Flg = "Y";
				}
				if (!prdOcnRoutDoubleCallingVO.getPostN4thPodDc().equals("")) {
					postPod4Dc1Flg = "Y";
				}
			}

			if (prePol1Dc1Flg.equals("Y")) {
				eventResponse.setETCData("pre_pol1_dc_flg", "Y");
			} else {
				eventResponse.setETCData("pre_pol1_dc_flg", "N");
			}
			if (postPol1Dc1Flg.equals("Y")) {
				eventResponse.setETCData("post_pol1_dc_flg", "Y");
			} else {
				eventResponse.setETCData("post_pol1_dc_flg", "N");
			}

			if (prePod1Dc1Flg.equals("Y")) {
				eventResponse.setETCData("pre_pod1_dc_flg", "Y");
			} else {
				eventResponse.setETCData("pre_pod1_dc_flg", "N");
			}
			if (postPod1Dc1Flg.equals("Y")) {
				eventResponse.setETCData("post_pod1_dc_flg", "Y");
			} else {
				eventResponse.setETCData("post_pod1_dc_flg", "N");
			}

			if (prePol2Dc1Flg.equals("Y")) {
				eventResponse.setETCData("pre_pol2_dc_flg", "Y");
			} else {
				eventResponse.setETCData("pre_pol2_dc_flg", "N");
			}
			if (postPol2Dc1Flg.equals("Y")) {
				eventResponse.setETCData("post_pol2_dc_flg", "Y");
			} else {
				eventResponse.setETCData("post_pol2_dc_flg", "N");
			}

			if (prePod2Dc1Flg.equals("Y")) {
				eventResponse.setETCData("pre_pod2_dc_flg", "Y");
			} else {
				eventResponse.setETCData("pre_pod2_dc_flg", "N");
			}

			if (postPod2Dc1Flg.equals("Y")) {
				eventResponse.setETCData("post_pod2_dc_flg", "Y");
			} else {
				eventResponse.setETCData("post_pod2_dc_flg", "N");
			}

			if (prePol3Dc1Flg.equals("Y")) {
				eventResponse.setETCData("pre_pol3_dc_flg", "Y");
			} else {
				eventResponse.setETCData("pre_pol3_dc_flg", "N");
			}
			if (postPol3Dc1Flg.equals("Y")) {
				eventResponse.setETCData("post_pol3_dc_flg", "Y");
			} else {
				eventResponse.setETCData("post_pol3_dc_flg", "N");
			}

			if (prePod3Dc1Flg.equals("Y")) {
				eventResponse.setETCData("pre_pod3_dc_flg", "Y");
			} else {
				eventResponse.setETCData("pre_pod3_dc_flg", "N");
			}
			if (postPod3Dc1Flg.equals("Y")) {
				eventResponse.setETCData("post_pod3_dc_flg", "Y");
			} else {
				eventResponse.setETCData("post_pod3_dc_flg", "N");
			}

			if (prePol4Dc1Flg.equals("Y")) {
				eventResponse.setETCData("pre_pol4_dc_flg", "Y");
			} else {
				eventResponse.setETCData("pre_pol4_dc_flg", "N");
			}
			if (postPol4Dc1Flg.equals("Y")) {
				eventResponse.setETCData("post_pol4_dc_flg", "Y");
			} else {
				eventResponse.setETCData("post_pol4_dc_flg", "N");
			}

			if (prePod4Dc1Flg.equals("Y")) {
				eventResponse.setETCData("pre_pod4_dc_flg", "Y");
			} else {
				eventResponse.setETCData("pre_pod4_dc_flg", "N");
			}
			if (postPod4Dc1Flg.equals("Y")) {
				eventResponse.setETCData("post_pod4_dc_flg", "Y");
			} else {
				eventResponse.setETCData("post_pod4_dc_flg", "N");
			}
			log.debug("\n view pc no:" + viewPctlNo);
			log.debug("\n prdCreateParamVO.getSumBkgQty():" + prdCreateParamVO.getSumBkgQty());

			String from = "";
			String to = "";
			if (prdCreateParamVO.getPor().substring(0, 2).equals("US")||prdCreateParamVO.getPor().substring(0, 2).equals("CA")) {
				// ---free time CALL(USA)--------------------------------------------------------------------------------------
				Map<String, String> map = this.getRailRecevingTime(viewPctlNo, null, prdCreateParamVO.getSumBkgQty(), prdCreateParamVO.getSumCTpSz());

				from = map.get("RTN_TIME") == null ? "" : (String) map.get("RTN_TIME");
				to = map.get("CUT_OFF") == null ? "" : (String) map.get("CUT_OFF");
			}

			dbRowsetEmpty = dbDao.selectPrdEmpty(viewPctlNo, prdCreateParamVO.getMPu(), prdCreateParamVO.getMRt());
			eventResponse.setRsVoList(listOcn);
			eventResponse.setRs(dbRowsetEmpty);

			dbRowsetPortCct = dbDao.searchPortCct(viewPctlNo);
			String port = "";
			String cct = "";
			if (dbRowsetPortCct.next()) {
				String cutOffFlag = "";
				if ("Y".equals(dbRowsetPortCct.getString("rf_spcl_flg"))) {
					cutOffFlag = "RF-";
				} else if ("Y".equals(dbRowsetPortCct.getString("dg_spcl_flg"))) {
					cutOffFlag = "DG-";
				}
				port = dbRowsetPortCct.getString("port");
				cct = cutOffFlag + dbRowsetPortCct.getString("cct");
				eventResponse.setETCData("port_cct_msg", "※ Port CCT (" + port + ") : " + cct);
			}

			dbRowsetFullRtn = dbDao.searchFullRtnYdCct(viewPctlNo, prdCreateParamVO.getPor(), from, to, port, cct);
			eventResponse.setRs(dbRowsetFullRtn);

			dbRowsetRouteInfo = dbDao.searchRouteInfoByPctlNo(viewPctlNo);
			if (dbRowsetRouteInfo.next()) {
				eventResponse.setETCData("arr_dt", dbRowsetRouteInfo.getString("EST_ARR_DATE"));
				eventResponse.setETCData("mt_pu_dt", dbRowsetRouteInfo.getString("MT_PU_DATE"));
				eventResponse.setETCData("transit_dt", dbRowsetRouteInfo.getString("TRANSIT_DAY"));
				eventResponse.setETCData("pc_ldd", dbRowsetRouteInfo.getString("LOAD_DT"));
				eventResponse.setETCData("cnst_flg", dbRowsetRouteInfo.getString("CNST_FLG"));
				eventResponse.setETCData("por_cd", dbRowsetRouteInfo.getString("POR_CD"));
				eventResponse.setETCData("pod_cd", dbRowsetRouteInfo.getString("POD_CD"));
				eventResponse.setETCData("del_cd", dbRowsetRouteInfo.getString("DEL_CD"));
				eventResponse.setETCData("ttl_expn_amt", dbRowsetRouteInfo.getString("TTL_EXPN_AMT"));
				eventResponse.setETCData("cml_tztm_day", dbRowsetRouteInfo.getString("CML_TZTM_DAY"));
			} else {
				eventResponse.setETCData("arr_dt", "");
				eventResponse.setETCData("mt_pu_dt", "");
				eventResponse.setETCData("transit_dt", "");
				eventResponse.setETCData("pc_ldd", "");
				eventResponse.setETCData("cnst_flg", "");
				eventResponse.setETCData("por_cd", "");
				eventResponse.setETCData("pod_cd", "");
				eventResponse.setETCData("del_cd", "");
				eventResponse.setETCData("ttl_expn_amt", "");
				eventResponse.setETCData("cml_tztm_day", "");
			}
			eventResponse.setETCData("sum_ctp_sz", prdCreateParamVO.getSumCTpSz());
			eventResponse.setETCData("sum_bkg_qty", prdCreateParamVO.getSumBkgQty());

		} catch (DAOException e1) {
			log.error("err " + e1.toString(), e1);
			throw new EventException(new ErrorHandler(e1).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;

	}

	/**
	 * @param e
	 * @param railCargoAvailRtnTmMap
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse searchRouteInfoByPctlNo(Event e, Map<String, String> railCargoAvailRtnTmMap) throws EventException {
		return null;
	}

	/**
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse searchRouteInfoByPctlNo(Event e) throws EventException {
		EsdPrd0080Event event = (EsdPrd0080Event) e;
		EventResponse eventResponse = new GeneralEventResponse();
		DBRowSet dbRowsetEmpty = null;
		DBRowSet dbRowsetPortCct = null;
		DBRowSet dbRowsetFullRtn = null;
		DBRowSet dbRowsetRouteInfo = null;
		PrdSearchParamVO prdSearchParamVO = (PrdSearchParamVO) event.getPrdSearchParamVO();
		PrdCreateParamVO prdCreateParamVO = (PrdCreateParamVO) event.getPrdCreateParamVO();

		try {
			String from = "";
			String to = "";
			if (prdSearchParamVO.getPor().substring(0, 2).equals("US")||prdSearchParamVO.getPor().substring(0, 2).equals("CA")) {
				Map<String, String> map = this.getRailRecevingTime(prdSearchParamVO.getPctlNo(), null, prdCreateParamVO.getSumBkgQty(), prdCreateParamVO.getSumCTpSz());
				from = map.get("RTN_TIME") == null ? "" : (String) map.get("RTN_TIME");
				to = map.get("CUT_OFF") == null ? "" : (String) map.get("CUT_OFF");
			}

			dbRowsetEmpty = dbDao.selectPrdEmpty(prdSearchParamVO.getPctlNo(), prdSearchParamVO.getMPu(), "");
			eventResponse.setRs(dbRowsetEmpty);

			dbRowsetPortCct = dbDao.searchPortCct(prdSearchParamVO.getPctlNo());
			String port = "";
			String cct = "";
			if (dbRowsetPortCct.next()) {
				String cutOffFlag = "";
				if ("Y".equals(dbRowsetPortCct.getString("rf_spcl_flg"))) {
					cutOffFlag = "RF-";
				} else if ("Y".equals(dbRowsetPortCct.getString("dg_spcl_flg"))) {
					cutOffFlag = "DG-";
				}
				port = dbRowsetPortCct.getString("port");
				cct = cutOffFlag + dbRowsetPortCct.getString("cct");
				eventResponse.setETCData("port_cct_msg", "※ Port CCT (" + port + ") : " + cct);
			}
			dbRowsetFullRtn = dbDao.searchFullRtnYdCct(prdSearchParamVO.getPctlNo(), prdCreateParamVO.getPor(), from, to, port, cct);
			eventResponse.setRs(dbRowsetFullRtn);
			dbRowsetRouteInfo = dbDao.searchRouteInfoByPctlNo(prdSearchParamVO.getPctlNo());
			if (dbRowsetRouteInfo.next()) {
				eventResponse.setETCData("arr_dt", dbRowsetRouteInfo.getString("EST_ARR_DATE"));
				eventResponse.setETCData("mt_pu_dt", dbRowsetRouteInfo.getString("MT_PU_DATE"));
				eventResponse.setETCData("transit_dt", dbRowsetRouteInfo.getString("TRANSIT_DAY"));
				eventResponse.setETCData("pc_ldd", dbRowsetRouteInfo.getString("LOAD_DT"));
				eventResponse.setETCData("cnst_flg", dbRowsetRouteInfo.getString("CNST_FLG"));
				eventResponse.setETCData("por_cd", dbRowsetRouteInfo.getString("POR_CD"));
				eventResponse.setETCData("pod_cd", dbRowsetRouteInfo.getString("POD_CD"));
				eventResponse.setETCData("del_cd", dbRowsetRouteInfo.getString("DEL_CD"));
				eventResponse.setETCData("ttl_expn_amt", dbRowsetRouteInfo.getString("TTL_EXPN_AMT"));
				eventResponse.setETCData("cml_tztm_day", dbRowsetRouteInfo.getString("CML_TZTM_DAY"));
			}

			String returnStr = selectReturnStrToBkg(prdSearchParamVO.getPctlNo());
			eventResponse.setETCData("returnStr", returnStr);

		} catch (DAOException e1) {
			log.error("err " + e1.toString(), e1);
			throw new EventException(new ErrorHandler(e1).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	@Override
	public EventResponse searchPrdCtlgFullRout(Event e) throws EventException {
		EsdPrd0081Event event = (EsdPrd0081Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		DBRowSet dbRowsetRouteInfo = null;
		PrdSearchParamVO prdSearchParamVO = (PrdSearchParamVO) event.getPrdSearchParamVO();
		try {
			dbRowsetRouteInfo = dbDao.searchPrdCtlgFullRout(prdSearchParamVO.getPctlNo());
			eventResponse.setRs(dbRowsetRouteInfo);

		} catch (DAOException e1) {
			log.error("err " + e1.toString(), e1);
			throw new EventException(new ErrorHandler(e1).getMessage());
		}
		return eventResponse;
	}

	/**
	 * @param pctlNo
	 * @return EventResponse
	 * @throws EventException
	 */
	@Override
	public EventResponse searchPrdConstraint(String pctlNo) throws EventException {
		EventResponse eventResponse = new GeneralEventResponse();
		DBRowSet dbRowset = null;
		try {
			dbRowset = dbDao.searchPrdConstraint(pctlNo);
			eventResponse.setRs(dbRowset);

		} catch (DAOException e1) {
			log.error("err " + e1.toString(), e1);
			throw new EventException(new ErrorHandler(e1).getMessage());
		}
		return eventResponse;
	}

	/**
	 * @param Event e
	 * @return List<PrdPatternVO>
	 * @throws EventException
	 */
	@Override
	public List<PrdPatternVO> getReplanePatternForMultiPrd(Event e) throws EventException {
		EsdPrd0080Event event = (EsdPrd0080Event) e;
		PrdCreateParamVO prdCreateParamVO = event.getPrdCreateParamVO();
		List<PrdBkgCopMapVO> insertVoList = new ArrayList<PrdBkgCopMapVO>();
		String mapSeq = "";
		List<PrdPatternVO> list = null;
		try {
			// map table - updating CRNT_FLGfmf = 'N'
			dbDao.updatePrdMapInit(prdCreateParamVO.getBkgNo(), "");

			// PRD_BKG_COP_MAP_SEQ sequence get
			mapSeq = dbDao.getPrdBkgCopMapSeq();

			// prd map create
			insertVoList = dbDao.getReplanePattern(prdCreateParamVO.getBkgRcvT(), prdCreateParamVO.getBkgDelT(), prdCreateParamVO.getRcvT(), prdCreateParamVO.getDelT(), prdCreateParamVO.getBkgNo(), mapSeq, "P", prdCreateParamVO.getFlexHgtFlg(), prdCreateParamVO.getCntrTpszQtyStr(),
					prdCreateParamVO.getBkgOfc());
			log.debug("getReplanePattern ====OK");
			dbDao.addReplanPatterns(insertVoList);

			// grouping COP_PATT_ORD_NO
			// creating PC as much as COP_PATT_ORD_NO
			list = dbDao.searchCurrentPatternOrd(mapSeq);
			log.debug("\n\n searchCurrentPatternOrd(grouping COP_PATT_ORD_NO  ) list size:" + list.size());

		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return list;
	}

	/**
	 * @param mapSeq
	 * @return List<PrdPatternVO>
	 * @throws EventException
	 */
	private List<PrdPatternVO> getReplanePatternByMapSeq(String mapSeq) throws EventException {
		List<PrdPatternVO> list = null;
		try {
			list = dbDao.searchCurrentPatternOrd(mapSeq);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return list;
	}

	/**
	 * @param mapSeq
	 * @param bkgNo
	 * @param mainPatternPctlNo
	 * @param copPattOrdNo
	 * @return int
	 * @throws EventException
	 */
	@Override
	public int updatePrdMapByPcNo(String mapSeq, String bkgNo, String mainPatternPctlNo, String copPattOrdNo) throws EventException {
		int ret = 0;
		try {
			ret = dbDao.updatePrdMapByPcNo(mapSeq, bkgNo, mainPatternPctlNo, copPattOrdNo);
		} catch (DAOException e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler(e).getMessage());
		}

		return ret;
	}

	/**
	 * @param e
	 * @throws EventException
	 */
	public void createSubPatternPrdCtlgFullRout(Event e) throws EventException {
		EsdPrd0080Event event = (EsdPrd0080Event) e;
		PrdCreateParamVO prdCreateParamVO = event.getPrdCreateParamVO();
		SignOnUserAccount account = (SignOnUserAccount) e.getAttribute("account");
		PrdPatternVO prdPatternVO = null;
		if (prdPatternVO == null) {
			log.debug("\n\n ------------prdPatternVO == null ----------\n\n");
		}
		// creating pc no
		PrdCreateManageBC prdCreateManageBc = new PrdCreateManageBCImpl();
		String hdPctlNo = prdCreateManageBc.createPrdCtlNoGen(prdCreateParamVO.getPcMode());

		// pc return value object create
		PrdPcCreateVO prdPcCreateVo = new PrdPcCreateVO();
		// pc_no_head set
		prdPcCreateVo.setHdPctlNo(hdPctlNo);

		// skdType(L,V) .
		String skdType = prdCreateManageBc.getSkdType(prdCreateParamVO.getTVvd(), prdCreateParamVO.getLdDt(), prdCreateParamVO.getPol1());

		// skdType(L,V) setting, skdDate setting.
		prdPcCreateVo.setSkdType(skdType);

		// skdDate setting. (date, vvd)
		if (skdType.equals("L")) {
			prdPcCreateVo.setSkdDate(prdCreateParamVO.getLdDt());
		} else {
			prdPcCreateVo.setSkdDate(prdCreateParamVO.getTVvd());
		}

		event.setPrdPcCreateVO(prdPcCreateVo);

		@SuppressWarnings("rawtypes")
		List list = (List) event.getAttribute("PATTERN_LIST");

		for (int i = 0; i < list.size(); i++) {
			int successCnt = 0;
			try {
				// creating PC sub pattern of ord= 1
				prdPatternVO = (PrdPatternVO) list.get(0);
				successCnt = dbDao.createProductCatalogIncludeReplane(event, prdCreateParamVO, prdPcCreateVo, prdPatternVO, account.getUsr_id());
				if (successCnt == 0) {
					log.debug("\n\n PRD log On:");
					Map<String, Object> map = new HashMap<String, Object>();

					map.put("PrdPatternVO", prdPatternVO);
					map.put("PrdCreateParamVO", prdCreateParamVO);
					map.put("hdPctlNo", hdPctlNo);
					map.put("usrId", account.getUsr_id());

					String logDesc = "successFlag " + Integer.toString(successCnt) + " " + this.getParamString(map);
					log.debug("\n\n log::::" + logDesc);

					dbDao.createPrdExecLog(logDesc, "createSubPatternPrdCtlgFullRout", account.getUsr_id());
				}
			} catch (Exception ex1) {
				log.error("err " + ex1.toString(), ex1);
				throw new EventException(new ErrorHandler(ex1).getMessage());
			}
			if (successCnt <= 0) {
				try {
					// pc is not created -> 'F'
					dbDao.updatePrdMapByPcCreateFail(prdPatternVO.getCopPattOrdNo(), prdPatternVO.getCopMapgSeq());
				} catch (Exception ex2) {
					log.error("err " + ex2.toString(), ex2);
					throw new EventException(new ErrorHandler(ex2).getMessage());
				}

			} else { // pc create success

				// sub pattern can be fail
				try {
					// // qty create
					prdCreateManageBc.createContainerQty(e);
					//
					// // data (min, max pc no )
					prdCreateManageBc.dataArrangement(e);
					//
					log.debug("\n\n -------------dataArrangement end----------------------");

					// // activity group dtl creating
					prdCreateManageBc.createActivityGroupIncludePattern(prdPcCreateVo, prdPatternVO, account.getUsr_id());

					log.debug("\n\n -------------createActivityGroup end----------------------");
					//
					// // activity group dtl update
					prdCreateManageBc.updateActivityGroup(hdPctlNo);

					log.debug("\n\n -------------createActivityGroup end----------------------");

					log.debug("\n\n sub pattern의prdPatternVO.getCopPattOrdNo() :" + prdPatternVO.getCopPattOrdNo());

					/*
					 * prdPatternVO: sub pattern info hdPctlNo : sub pattern created pc
					 */
					successCnt = dbDao.updatePrdBkgCopMapBySubPatternOrdNo(prdPatternVO, hdPctlNo);
					int successFailCnt = 0;
					if (successCnt == 0) {
						successFailCnt = dbDao.updatePrdMapByPcCreateFail(prdPatternVO.getCopPattOrdNo(), prdPatternVO.getCopMapgSeq());
					}
					log.debug("\n\n PRD log On:");
					Map<String, Object> map = new HashMap<String, Object>();

					map.put("PrdPatternVO", prdPatternVO);
					map.put("MapgSeq", prdPatternVO.getCopMapgSeq());
					map.put("hdPctlNo", hdPctlNo);
					map.put("usrId", account.getUsr_id());

					String logDesc = "successCnt " + Integer.toString(successCnt) + "successFailCnt " + Integer.toString(successFailCnt) + " " + this.getParamString(map);
					log.debug("\n\n log::::" + logDesc);

					dbDao.createPrdExecLog(logDesc, "createSubPattern Map", account.getUsr_id());

				} catch (Exception e1) {
					try {
						if (successCnt == 0) {
							log.debug("\n\n PRD log On:");
							Map<String, Object> map = new HashMap<String, Object>();

							map.put("PrdPatternVO", prdPatternVO);
							map.put("PrdCreateParamVO", prdCreateParamVO);
							map.put("hdPctlNo", hdPctlNo);
							map.put("usrId", account.getUsr_id());

							String logDesc = "successFlag " + Integer.toString(successCnt) + " " + this.getParamString(map);
							log.debug("\n\n log::::" + logDesc);

							dbDao.createPrdExecLog(logDesc, "createSubPattern Exec", account.getUsr_id());
						}

					} catch (Exception ex3) {
						log.error("err " + ex3.toString(), ex3);
						throw new EventException(new ErrorHandler(ex3).getMessage());
					}
					log.error("err " + e1.toString(), e1);
					throw new EventException(new ErrorHandler(e1).getMessage());

				}

			}

		}
	}

	/**
	 * @param e
	 * @return DBRowSet
	 * @throws EventException
	 */
	public DBRowSet createProductCatalogInquiry(Event e) throws EventException {
		EsdPrd0080Event event = (EsdPrd0080Event) e;
		DBRowSet rowset = null;
		try {
			rowset = new ProductCatalogCreateDBDAO().searchProductCatalogInternalMst_1(event.getPrdPcCreateVO().getHdPctlNo());
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}

		return rowset;
	}

	/**
	 * @param e
	 * @return List
	 * @throws EventException
	 */
	@SuppressWarnings("rawtypes")
	public List searchProductCatalogInquiryDetail(Event e) throws EventException {
		List list = null;
		try {
			list = new ProductCatalogCreateDBDAO().searchProductCatalogInternalDetail((String) e.getAttribute("search_pctl_no"));
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}

		return list;
	}

	/**
	 * updating Empty Pick Up Date
	 * 
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse searchEqInventory(Event e) throws EventException {
		EsdPrd0080Event event = (EsdPrd0080Event) e;
		DBRowSet dbRowsetEmpty = null;
		EventResponse eventResponse = new GeneralEventResponse();
		PrdSearchParamVO prdSearchParamVO = (PrdSearchParamVO) event.getPrdSearchParamVO();
		try {
			dbRowsetEmpty = dbDao.selectPrdEmpty(prdSearchParamVO.getPctlNo(), prdSearchParamVO.getMPu(), prdSearchParamVO.getMPuDt());
			eventResponse.setRs(dbRowsetEmpty);
		} catch (DAOException e1) {
			log.error("err " + e1.toString(), e1);
			throw new EventException(new ErrorHandler(e1).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * Constraint Remarking
	 * 
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse searchCnstRemark(Event e) throws EventException {
		EsdPrd0080Event event = (EsdPrd0080Event) e;
		DBRowSet dbRowsetCnstRmk = null;
		EventResponse eventResponse = new GeneralEventResponse();
		PrdCnstRemarkVO prdCnstRemarkVO = (PrdCnstRemarkVO) event.getPrdCnstRemarkVO();
		try {
			dbRowsetCnstRmk = dbDao.searchCnstRemark(prdCnstRemarkVO);
			StringBuilder cnst_rmk = new StringBuilder("Your booking is under Network Constraint in PRD. \n");
			while (dbRowsetCnstRmk.next()) {
				cnst_rmk.append(dbRowsetCnstRmk.getString("CNST_RMK")).append("\n");
			}
			eventResponse.setETCData("cnst_rmk", cnst_rmk.toString());
		} catch (DAOException e1) {
			log.error("err " + e1.toString(), e1);
			throw new EventException(new ErrorHandler(e1).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * TRO handling.
	 * 
	 * @param e
	 * @param creUsrId
	 * @return
	 * @throws EventException
	 */
	public String createIrgSoReplane(Event e, String creUsrId) throws EventException {
		EsdPrd0080Event event = (EsdPrd0080Event) e;
		String retPctlNo = "";
		try {
			// creating pc no
			PrdCreateManageBC prdCreateManageBc = new PrdCreateManageBCImpl();
			PrdCreateParamVO prdCreateParamVO = event.getPrdCreateParamVO();
			PrdPatternVO prdPatternVO = new PrdPatternVO();

			String hdPctlNo = prdCreateManageBc.createPrdCtlNoGen(prdCreateParamVO.getPcMode());

			// pc return value object create
			PrdPcCreateVO prdPcCreateVo = new PrdPcCreateVO();
			// pc_no_head set
			prdPcCreateVo.setHdPctlNo(hdPctlNo);

			event.setPrdPcCreateVO(prdPcCreateVo);

			String troSeq = prdCreateParamVO.getTroSeq();
			String troSubSeq = prdCreateParamVO.getTroSubSeq();

			String copNo = "";
			String pcMode = "";
			String doorZn = "";
			String fullRtnCy = "";
			String fullPuCy = "";
			String mtPu = "";
			String mtRtn = "";
			String area_conti_cd = prdCreateParamVO.getAreaContiCd();// whether EU or not
			String ioBndCd = prdCreateParamVO.getReplaneBndCd();

			// checking TRO mapping
//			int cnt = dbDaoTro.checkSceTroMapping(ioBndCd, area_conti_cd, prdCreateParamVO.getBkgNo(), troSeq, troSubSeq);
//			if (cnt > 0) {
//				throw new EventException(new ErrorHandler("PRD00060").getMessage());
//			}
			// :IO_BND_CD
			// :AREA_CONTI_CD
			// :BKG_NO
			// :TRO_SEQ
			// :TRO_SUB_SEQ
			BkgCopManageBC bkgCopManageBC = new BkgCopManageBCImpl();
			SearchCopVO copVO = bkgCopManageBC.searchCopNoFrmPrdByTro(prdCreateParamVO.getBkgNo(), troSeq, troSubSeq, ioBndCd, area_conti_cd);
			// cop_no
			copNo = copVO.getCopNo();
			log.debug("\n\n ----------------------" + "\n pc_mode prdCreateParamVO.getPcMode() :" + prdCreateParamVO.getPcMode() + "\n copNo:" + copNo);

			pcMode = prdCreateParamVO.getPcMode();
			log.debug("\n\n ----------------------" + "\n pc_mode prdCreateParamVO.getPcMode() :" + prdCreateParamVO.getPcMode() + "\n pc_mode:" + pcMode);
			doorZn = prdCreateParamVO.getDorZone();
			// o/b - full return yard
			fullRtnCy = prdCreateParamVO.getTroRtnCy();
			// i/b - full pick up yard
			fullPuCy = prdCreateParamVO.getTroPkupCy();
			// o/b- m'ty pick up cy
			mtPu = prdCreateParamVO.getMPu();
			// i/b- m'ty return cy
			if (prdCreateParamVO.getTroRtnCy() != null && !prdCreateParamVO.getTroRtnCy().trim().equals("")) {
				mtRtn = prdCreateParamVO.getTroRtnCy();
			} else {
				mtRtn = prdCreateParamVO.getMRt();
			}

			List<PrdSceGetParamVO> list = null;
			list = dbDaoSce.sceGetParam(copNo, ioBndCd, pcMode, doorZn, fullRtnCy, fullPuCy, mtPu, mtRtn);

			String srTerm = "";
			String sdTerm = "";
			String cct = "";
			String pmF = "";
			String podT = "";
			String polT = "";
			String spmFlg = "";
			String srfCntr = prdCreateParamVO.getRfF();
			String smtPu = "";
			String smtRtn = "";
			String inlndRoutOrg = "";
			String inlndRoutDest = "";
			String sinclShtlSoFlg = "";
			String subRout = "";
			String fullCy = "";
			String trspModCd = prdCreateParamVO.getTrMode();
			String stermNode = "";
			String prdCtlNo = "";
			String outStr = "";
			String inStr = "";
			String ocnStr = "";
			String obTroFlg = "";
			String ibTroFlg = "";
			String porNodCd = "";
			String polNodCd = "";
			String delNodCd = "";
			String fullRtnYdCd = "";
			String fullPkUpYdCd = "";
			String obTrspMode = "";
			String ibTrspMode = "";

			PrdSceGetParamVO prdSceGetParamVO = null;

			if (list != null && list.size() > 0) {
				prdSceGetParamVO = (PrdSceGetParamVO) list.get(0);
				srTerm = JSPUtil.getNull(prdSceGetParamVO.getRcvTermCd());
				sdTerm = JSPUtil.getNull(prdSceGetParamVO.getDeTermCd());
				cct = JSPUtil.getNull(prdSceGetParamVO.getCct());
				podT = JSPUtil.getNull(prdSceGetParamVO.getPodT());
				polT = JSPUtil.getNull(prdSceGetParamVO.getPolT());
				smtPu = JSPUtil.getNull(prdSceGetParamVO.getMtPu());
				smtRtn = JSPUtil.getNull(prdSceGetParamVO.getMtRtn());
				inlndRoutOrg = JSPUtil.getNull(prdSceGetParamVO.getRoutOrgNodCd());
				inlndRoutDest = JSPUtil.getNull(prdSceGetParamVO.getRoutDestNodCd());
				// I/O Bound Included Shuttle S/O Flag
				sinclShtlSoFlg = JSPUtil.getNull(prdSceGetParamVO.getIoBndCd()).equals("I") ? JSPUtil.getNull(prdSceGetParamVO.getIbInclShtlSoFlg()) : JSPUtil.getNull(prdSceGetParamVO.getObInclShtlSoFlg());
				prdCtlNo = JSPUtil.getNull(prdSceGetParamVO.getPctlNo());
				// returning in case of existing PCTL_NO(COP_SEARCH_SAME_ROUTE.txt)-----------------------------------------
				outStr = JSPUtil.getNull(prdSceGetParamVO.getOutBound());
				inStr = JSPUtil.getNull(prdSceGetParamVO.getInBound());
				ocnStr = JSPUtil.getNull(prdSceGetParamVO.getOcnBound());

				if (ioBndCd.equals("O")) {
					subRout = outStr;
					log.debug("\n o/b inlndRoutOrg before: " + inlndRoutOrg);
					inlndRoutOrg = JSPUtil.getNull(prdSceGetParamVO.getPorNodCd()).equals("") ? inlndRoutOrg : prdSceGetParamVO.getPorNodCd();
					log.debug("\n o/b inlndRoutOrg after: " + inlndRoutOrg);
				} else if (ioBndCd.equals("I")) {
					subRout = inStr;
					log.debug("\n i/b inlndRoutDest before: " + inlndRoutDest);
					inlndRoutDest = JSPUtil.getNull(prdSceGetParamVO.getDelNodCd()).equals("") ? inlndRoutDest : prdSceGetParamVO.getDelNodCd();
					log.debug("\n i/b inlndRoutDest after: " + inlndRoutDest);
				} else if (ioBndCd.equals("T")) {
					subRout = ocnStr;
				}
				obTroFlg = JSPUtil.getNull(prdSceGetParamVO.getObTroFlg());
				ibTroFlg = JSPUtil.getNull(prdSceGetParamVO.getIbTroFlg());
				porNodCd = JSPUtil.getNull(prdSceGetParamVO.getPorNodCd());
				polNodCd = JSPUtil.getNull(prdSceGetParamVO.getPolYdCd());
				delNodCd = JSPUtil.getNull(prdSceGetParamVO.getPolYdCd());
				fullRtnYdCd = JSPUtil.getNull(prdSceGetParamVO.getFullRtnYdCd());
				fullPkUpYdCd = JSPUtil.getNull(prdSceGetParamVO.getFullPkupYdCd());

				if (pcMode.equals("O")) {
					obTrspMode = JSPUtil.getNull(prdCreateParamVO.getObTrspMode());
				} else {
					obTrspMode = JSPUtil.getNull(prdSceGetParamVO.getObTrspMode());
				}

				if (pcMode.equals("I")) {
					ibTrspMode = JSPUtil.getNull(prdCreateParamVO.getIbTrspMode());
				} else {
					ibTrspMode = JSPUtil.getNull(prdSceGetParamVO.getIbTrspMode());
				}
			}

			// tro o/b FULL_rtn_cy or i/b FULL_pick_up_cy
			if (JSPUtil.getNull(prdCreateParamVO.getPcMode()).equals(PrdConstants.PRD_PC_MOD_I)) {
				fullCy = JSPUtil.getNull(prdCreateParamVO.getTroPkupCy());
			} else if (JSPUtil.getNull(prdCreateParamVO.getPcMode()).equals(PrdConstants.PRD_PC_MOD_O)) {
				fullCy = JSPUtil.getNull(prdCreateParamVO.getTroRtnCy());
			}

			if (ioBndCd.equals("O")) {
				retPctlNo = searchSameRoutSce(prdCreateParamVO.getBkgNo(), outStr, inStr, ocnStr, smtPu, smtRtn, obTroFlg, ibTroFlg, inlndRoutOrg, polNodCd, srTerm, sdTerm, delNodCd, fullRtnYdCd, fullPkUpYdCd, obTrspMode, ibTrspMode);
			} else if (ioBndCd.equals("I")) {
				retPctlNo = searchSameRoutSce(prdCreateParamVO.getBkgNo(), outStr, inStr, ocnStr, smtPu, smtRtn, obTroFlg, ibTroFlg, porNodCd, polNodCd, srTerm, sdTerm, inlndRoutDest, fullRtnYdCd, fullPkUpYdCd, obTrspMode, ibTrspMode);
			}

			if (retPctlNo.equals("")) {
				if (list != null && list.size() > 0) {
					prdSceGetParamVO = (PrdSceGetParamVO) list.get(0);
					int successCnt = 0;
					if (!prdSceGetParamVO.getNewPol().equals("") || !prdSceGetParamVO.getNewPod().equals("")) {
						successCnt = dbDaoSce.createSceSoReplaneOcnInlndChange(prdSceGetParamVO, hdPctlNo);

					} else {
						successCnt = dbDaoTro.troAutoChange(ioBndCd, srTerm, sdTerm, creUsrId, hdPctlNo, cct, pmF, podT, polT, spmFlg, srfCntr, smtPu, smtRtn, inlndRoutOrg, inlndRoutDest, sinclShtlSoFlg, subRout, fullCy, trspModCd, stermNode, prdCtlNo);
					}

					if (successCnt == 0) {
						log.debug("\n\n PRD log On:");
						Map<String, Object> map = new HashMap<String, Object>();

						map.put("prdSceGetParamVO", prdSceGetParamVO);
						map.put("PrdCreateParamVO", prdCreateParamVO);
						map.put("hdPctlNo", hdPctlNo);

						map.put("ioBndCd", ioBndCd);
						map.put("srTerm", srTerm);
						map.put("sdTerm", sdTerm);
						map.put("creUsrId", creUsrId);
						map.put("cct", cct);
						map.put("pmF", pmF);
						map.put("podT", podT);
						map.put("polT", polT);
						map.put("spmFlg", spmFlg);
						map.put("srfCntr", srfCntr);
						map.put("smtPu", smtPu);
						map.put("smtRtn", smtRtn);
						map.put("inlndRoutOrg", inlndRoutOrg);
						map.put("inlndRoutDest", inlndRoutDest);
						map.put("sinclShtlSoFlg", sinclShtlSoFlg);
						// I/O Included Shuttle S/O Flag
						map.put("ibInclShtlSoFlg", prdSceGetParamVO.getIbInclShtlSoFlg());
						map.put("obInclShtlSoFlg", prdSceGetParamVO.getObInclShtlSoFlg());
						map.put("subRout", subRout);
						map.put("fullCy", fullCy);
						map.put("trspModCd", trspModCd);
						map.put("stermNode", stermNode);
						map.put("prdCtlNo", prdCtlNo);

						String logDesc = "successFlag " + Integer.toString(successCnt) + " " + this.getParamString(map);
						log.debug("\n\n log::::" + logDesc);

						dbDao.createPrdExecLog(logDesc, "createIrgSoReplane", creUsrId);
					}
				}

				// to set obTroFlg, ibTroFlg
				prdPcCreateVo.setObTroFlg(obTroFlg);
				prdPcCreateVo.setIbTroFlg(ibTroFlg);

				prdPatternVO.setObItchgCtnt(outStr);
				prdPatternVO.setOcnItchgCtnt(ocnStr);
				prdPatternVO.setIbItchgCtnt(inStr);

				// qty creating
				prdCreateManageBc.createContainerQty(event);
				// // data (min, max pc no )
				prdCreateManageBc.dataArrangement(event);
				log.debug("\n\n -------------dataArrangement end----------------------");
				prdCreateManageBc.createActivityGroupIncludePattern(prdPcCreateVo, prdPatternVO, creUsrId);
				log.debug("\n\n -------------createActivityGroup end----------------------");
				prdCreateManageBc.updateActivityGroup(hdPctlNo);
				log.debug("\n\n -------------createActivityGroup end----------------------");

				retPctlNo = prdPcCreateVo.getMinPctlNo();
			}
			// ---------------------------------------------------------------------------------------------------------

		} catch (DAOException e1) {
			log.error("err " + e1.toString(), e1);
			throw new EventException(new ErrorHandler(e1).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}

		return retPctlNo;
	}

	/**
	 * @param bkgNo
	 * @param outStr
	 * @param inStr
	 * @param ocnStr
	 * @param smtPu
	 * @param smtRtn
	 * @param obTroFlg
	 * @param ibTroFlg
	 * @param porNodCd
	 * @param polNodCd
	 * @param srTerm
	 * @param sdTerm
	 * @param ibTrspMode
	 * @param obTrspMode
	 * @param fullPkUpYdCd
	 * @param fullRtnYdCd
	 * @param delNodCd
	 * @return
	 * @throws EventException
	 */
	private String searchSameRoutSce(String bkgNo, String outStr, String inStr, String ocnStr, String smtPu, String smtRtn, String obTroFlg, String ibTroFlg, String porNodCd, String polNodCd, String srTerm, String sdTerm, String delNodCd, String fullRtnYdCd, String fullPkUpYdCd, String obTrspMode,
			String ibTrspMode) throws EventException {

		String pctlNo = "";
		try {
			pctlNo = dbDaoSce.searchSameRoutSce(bkgNo, outStr, inStr, ocnStr, smtPu, smtRtn, obTroFlg, ibTroFlg, porNodCd, polNodCd, srTerm, sdTerm, delNodCd, fullRtnYdCd, fullPkUpYdCd, obTrspMode, ibTrspMode);

		} catch (DAOException e1) {
			log.error("err " + e1.toString(), e1);
			throw new EventException(new ErrorHandler(e1).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}

		return pctlNo;
	}

	/**
	 * moving next step in case of terminal change(T) terminal change - calling from cop batch
	 * 
	 * @param copNo
	 * @param ioBndCd
	 * @param creUsrId
	 * @return
	 * @throws EventException
	 */
	public String createSceSoReplan(String copNo, String ioBndCd, String creUsrId) throws EventException {
		EsdPrd0080Event event = new EsdPrd0080Event();
		String retPctlNo = "";
		try {
			PrdCreateManageBC prdCreateManageBc = new PrdCreateManageBCImpl();
			PrdCreateParamVO prdCreateParamVO = new PrdCreateParamVO();
			PrdPatternVO prdPatternVO = new PrdPatternVO();

			String hdPctlNo = prdCreateManageBc.createPrdCtlNoGen(PrdConstants.PRD_PC_MOD_SCE_SO_REPLAN);
			prdCreateParamVO.setPcMode(PrdConstants.PRD_PC_MOD_SCE_SO_REPLAN);

			List<PrdSceGetParamVO> list = null;

			// pc return value object create
			PrdPcCreateVO prdPcCreateVo = new PrdPcCreateVO();
			// pc_no_head set
			prdPcCreateVo.setHdPctlNo(hdPctlNo);

			event.setPrdPcCreateVO(prdPcCreateVo);
			String pcMode = "";
			String doorZn = "";
			String fullRtnCy = "";
			String fullPuCy = "";
			String mtPu = "";
			String mtRtn = "";

			pcMode = prdCreateParamVO.getPcMode();
			String srTerm = "";
			String sdTerm = "";
			String cct = "";
			String pmF = "";
			String podT = "";
			String polT = "";
			String spmFlg = "";
			String srfCntr = prdCreateParamVO.getRfF();
			String smtPu = "";
			String smtRtn = "";
			String inlndRoutOrg = "";
			String inlndRoutDest = "";
			String sinclShtlSoFlg = "";
			String subRout = "";
			String fullCy = "";
			String trspModCd = prdCreateParamVO.getTrMode();
			String stermNode = "";
			String prdCtlNo = "";
			String outStr = "";
			String inStr = "";
			String ocnStr = "";
			String obTroFlg = "";
			String ibTroFlg = "";
			String porNodCd = "";
			String polNodCd = "";
			String delNodCd = "";
			String fullRtnYdCd = "";
			String fullPkUpYdCd = "";
			String obTrspMode = "";
			String ibTrspMode = "";

			list = dbDaoSce.sceGetParam(copNo, ioBndCd, pcMode, doorZn, fullRtnCy, fullPuCy, mtPu, mtRtn);
			PrdSceGetParamVO prdSceGetParamVO = null;
			if (list != null && list.size() > 0) {
				prdSceGetParamVO = (PrdSceGetParamVO) list.get(0);
				srTerm = JSPUtil.getNull(prdSceGetParamVO.getRcvTermCd());
				sdTerm = JSPUtil.getNull(prdSceGetParamVO.getDeTermCd());
				cct = JSPUtil.getNull(prdSceGetParamVO.getCct());
				podT = JSPUtil.getNull(prdSceGetParamVO.getPodT());
				polT = JSPUtil.getNull(prdSceGetParamVO.getPolT());
				smtPu = JSPUtil.getNull(prdSceGetParamVO.getMtPu());
				smtRtn = JSPUtil.getNull(prdSceGetParamVO.getMtRtn());
				sinclShtlSoFlg = JSPUtil.getNull(prdSceGetParamVO.getIoBndCd()).equals("I") ? JSPUtil.getNull(prdSceGetParamVO.getIbInclShtlSoFlg()) : JSPUtil.getNull(prdSceGetParamVO.getObInclShtlSoFlg());
				prdCtlNo = JSPUtil.getNull(prdSceGetParamVO.getPctlNo());
				outStr = JSPUtil.getNull(prdSceGetParamVO.getOutBound());
				inStr = JSPUtil.getNull(prdSceGetParamVO.getInBound());
				ocnStr = JSPUtil.getNull(prdSceGetParamVO.getOcnBound());
				inlndRoutOrg = JSPUtil.getNull(prdSceGetParamVO.getRoutOrgNodCd());
				inlndRoutDest = JSPUtil.getNull(prdSceGetParamVO.getRoutDestNodCd());

				if (ioBndCd.equals("O")) {
					subRout = outStr;
					// door so
					log.debug("\n o/b inlndRoutOrg before: " + inlndRoutOrg);
					inlndRoutOrg = JSPUtil.getNull(prdSceGetParamVO.getPorNodCd()).equals("") ? inlndRoutOrg : prdSceGetParamVO.getPorNodCd();
					log.debug("\n o/b inlndRoutOrg after: " + inlndRoutOrg);
				} else if (ioBndCd.equals("I")) {
					subRout = inStr;
					// door so
					log.debug("\n i/b inlndRoutDest before: " + inlndRoutDest);
					inlndRoutDest = JSPUtil.getNull(prdSceGetParamVO.getDelNodCd()).equals("") ? inlndRoutDest : prdSceGetParamVO.getDelNodCd();
					log.debug("\n i/b inlndRoutDest after: " + inlndRoutDest);
				} else if (ioBndCd.equals("T")) {
					subRout = ocnStr;
				}
				obTroFlg = JSPUtil.getNull(prdSceGetParamVO.getObTroFlg());
				ibTroFlg = JSPUtil.getNull(prdSceGetParamVO.getIbTroFlg());
				porNodCd = JSPUtil.getNull(prdSceGetParamVO.getPorNodCd());
				polNodCd = JSPUtil.getNull(prdSceGetParamVO.getPolYdCd());
				delNodCd = JSPUtil.getNull(prdSceGetParamVO.getDelNodCd());
				fullRtnYdCd = JSPUtil.getNull(prdSceGetParamVO.getFullRtnYdCd());
				fullPkUpYdCd = JSPUtil.getNull(prdSceGetParamVO.getFullPkupYdCd());
				obTrspMode = JSPUtil.getNull(prdSceGetParamVO.getObTrspMode());
				ibTrspMode = JSPUtil.getNull(prdSceGetParamVO.getIbTrspMode());

				// in case of inbound/outbound
				if (ioBndCd.equals("O")) {
					retPctlNo = searchSameRoutSce(prdCreateParamVO.getBkgNo(), outStr, inStr, ocnStr, smtPu, smtRtn, obTroFlg, ibTroFlg, inlndRoutOrg, polNodCd, srTerm, sdTerm, delNodCd, fullRtnYdCd, fullPkUpYdCd, obTrspMode, ibTrspMode);
					log.debug("\n\n searchSameRoutSce pctl_no:" + retPctlNo);
				} else if (ioBndCd.equals("I")) {
					retPctlNo = searchSameRoutSce(prdCreateParamVO.getBkgNo(), outStr, inStr, ocnStr, smtPu, smtRtn, obTroFlg, ibTroFlg, porNodCd, polNodCd, srTerm, sdTerm, inlndRoutDest, fullRtnYdCd, fullPkUpYdCd, obTrspMode, ibTrspMode);
					log.debug("\n\n searchSameRoutSce pctl_no:" + retPctlNo);
				}

				// in case of Ocn section or searchSameRoutSce = ""
				if (retPctlNo.equals("")) {
					// 1.Ocn section(T) 2. existing newPol or newPod at searchSameRoutSce list -> location changed -> pc creating .
					int successCnt = 0;
					String pcVerifyMsg = "";
					if (ioBndCd.equals("T")) {// T 일때 || !prdSceGetParamVO.getNewPol().equals("") || !prdSceGetParamVO.getNewPod().equals("")){
						// COP_AUTO_CHANGE_OCN_INLAND_CHANGE.txt .
						// prd mst, dtl creating
						successCnt = dbDaoSce.createSceSoReplaneOcnInlndChange(prdSceGetParamVO, hdPctlNo);
					} else {
						successCnt = dbDaoTro.troAutoChange(ioBndCd, srTerm, sdTerm, creUsrId, hdPctlNo, cct, pmF, podT, polT, spmFlg, srfCntr, smtPu, smtRtn, inlndRoutOrg, inlndRoutDest, sinclShtlSoFlg, subRout, fullCy, trspModCd, stermNode, prdCtlNo);
					}
					if (successCnt == 0) {
						log.debug("\n\n PRD log On:");
						Map<String, Object> map = new HashMap<String, Object>();

						map.put("prdSceGetParamVO", prdSceGetParamVO);
						map.put("PrdCreateParamVO", prdCreateParamVO);
						map.put("hdPctlNo", hdPctlNo);

						map.put("ioBndCd", ioBndCd);
						map.put("srTerm", srTerm);
						map.put("sdTerm", sdTerm);
						map.put("creUsrId", creUsrId);
						map.put("hdPctlNo", hdPctlNo);
						map.put("cct", cct);
						map.put("pmF", pmF);
						map.put("podT", podT);
						map.put("polT", polT);
						map.put("spmFlg", spmFlg);
						map.put("srfCntr", srfCntr);
						map.put("smtPu", smtPu);
						map.put("smtRtn", smtRtn);
						map.put("inlndRoutOrg", inlndRoutOrg);
						map.put("inlndRoutDest", inlndRoutDest);
						map.put("sinclShtlSoFlg", sinclShtlSoFlg);
						// I/O Included Shuttle S/O Flag - #Add 2010.05.27 by sj
						map.put("ibInclShtlSoFlg", prdSceGetParamVO.getIbInclShtlSoFlg());
						map.put("obInclShtlSoFlg", prdSceGetParamVO.getObInclShtlSoFlg());
						map.put("subRout", subRout);
						map.put("fullCy", fullCy);
						map.put("trspModCd", trspModCd);
						map.put("stermNode", stermNode);
						map.put("prdCtlNo", prdCtlNo);
						map.put("pcVerifyMsg", pcVerifyMsg);

						String logDesc = "successFlag " + Integer.toString(successCnt) + " " + this.getParamString(map);
						log.debug("\n\n log::::" + logDesc);

						dbDao.createPrdExecLog(logDesc, "createSceSoReplan", creUsrId);
					}

					// param setting
					prdCreateParamVO.setTVvd(prdSceGetParamVO.getTVvd());
					event.setPrdCreateParamVO(prdCreateParamVO);

					// to set obTroFlg, ibTroFlg
					prdPcCreateVo.setObTroFlg(obTroFlg);
					prdPcCreateVo.setIbTroFlg(ibTroFlg);

					prdPatternVO.setObItchgCtnt(outStr);
					prdPatternVO.setOcnItchgCtnt(ocnStr);
					prdPatternVO.setIbItchgCtnt(inStr);

					// data (min, max pc no )
					prdCreateManageBc.dataArrangement(event);
					log.debug("\n\n -------------dataArrangement end----------------------");
					prdCreateManageBc.createActivityGroupIncludePattern(prdPcCreateVo, prdPatternVO, creUsrId);
					log.debug("\n\n -------------createActivityGroup end----------------------");
					prdCreateManageBc.updateActivityGroup(hdPctlNo);
					log.debug("\n\n -------------createActivityGroup end----------------------");
					retPctlNo = prdPcCreateVo.getMinPctlNo();
					log.debug("\n\n -------------createSceSoReplan end----------------------" + "\n return PCTL NO : " + retPctlNo);
				}
			} else { // param list is null
				throw new EventException(new ErrorHandler("PRD00061").getMessage());
			}

		} catch (DAOException e1) {
			log.error("err " + e1.toString(), e1);
			throw new EventException(new ErrorHandler(e1).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return retPctlNo;
	}

	/**
	 * @param copNo
	 * @param ioBndCd
	 * @param creUsrId
	 * @return
	 * @throws EventException
	 */
	public String createSceSoReplanByBkgInfo(String copNo, String ioBndCd, String creUsrId) throws EventException {
		EsdPrd0080Event event = new EsdPrd0080Event();
		String retPctlNo = "";
		try {

			// creating pc no
			PrdCreateManageBC prdCreateManageBc = new PrdCreateManageBCImpl();
			PrdCreateParamVO prdCreateParamVO = new PrdCreateParamVO();
			PrdPatternVO prdPatternVO = new PrdPatternVO();

			String hdPctlNo = prdCreateManageBc.createPrdCtlNoGen(PrdConstants.PRD_PC_MOD_SCE_SO_REPLAN);
			prdCreateParamVO.setPcMode(PrdConstants.PRD_PC_MOD_SCE_SO_REPLAN);

			List<PrdSceGetParamVO> list = null;

			// pc return value object create
			PrdPcCreateVO prdPcCreateVo = new PrdPcCreateVO();
			// pc_no_head set
			prdPcCreateVo.setHdPctlNo(hdPctlNo);

			event.setPrdPcCreateVO(prdPcCreateVo);
			// ------------------
			String pcMode = "";
			String doorZn = "";
			String fullRtnCy = "";
			String fullPuCy = "";
			String mtPu = "";
			String mtRtn = "";

			pcMode = prdCreateParamVO.getPcMode();

			// -------------------------------

			String srTerm = "";
			String sdTerm = "";
			String cct = "";
			String pmF = "";
			String podT = "";
			String polT = "";
			String spmFlg = "";
			String srfCntr = prdCreateParamVO.getRfF();
			String smtPu = "";
			String smtRtn = "";
			String inlndRoutOrg = "";
			String inlndRoutDest = "";
			String sinclShtlSoFlg = "";
			String subRout = "";
			String fullCy = "";
			String trspModCd = prdCreateParamVO.getTrMode();
			String stermNode = "";
			String prdCtlNo = "";
			String outStr = "";
			String inStr = "";
			String ocnStr = "";
			String obTroFlg = "";
			String ibTroFlg = "";
			String porNodCd = "";
			String polNodCd = "";
			String delNodCd = "";
			String fullRtnYdCd = "";
			String fullPkUpYdCd = "";
			String obTrspMode = "";
			String ibTrspMode = "";

			// from sce(cop_no, io_bnd_cd)
			list = dbDaoSce.sceBkgGetParam(copNo, ioBndCd, pcMode, doorZn, fullRtnCy, fullPuCy, mtPu, mtRtn);
			PrdSceGetParamVO prdSceGetParamVO = null;
			if (list != null && list.size() > 0) {
				prdSceGetParamVO = (PrdSceGetParamVO) list.get(0);
				srTerm = JSPUtil.getNull(prdSceGetParamVO.getRcvTermCd());
				sdTerm = JSPUtil.getNull(prdSceGetParamVO.getDeTermCd());
				cct = JSPUtil.getNull(prdSceGetParamVO.getCct());
				podT = JSPUtil.getNull(prdSceGetParamVO.getPodT());
				polT = JSPUtil.getNull(prdSceGetParamVO.getPolT());
				smtPu = JSPUtil.getNull(prdSceGetParamVO.getMtPu());
				smtRtn = JSPUtil.getNull(prdSceGetParamVO.getMtRtn());
				// according to I/O Bound -Included Shuttle S/O Flag
				sinclShtlSoFlg = JSPUtil.getNull(prdSceGetParamVO.getIoBndCd()).equals("I") ? JSPUtil.getNull(prdSceGetParamVO.getIbInclShtlSoFlg()) : JSPUtil.getNull(prdSceGetParamVO.getObInclShtlSoFlg());
				prdCtlNo = JSPUtil.getNull(prdSceGetParamVO.getPctlNo());
				// returning PCTL_NO - COP_SEARCH_SAME_ROUTE.txt-----------------------------------------
				outStr = JSPUtil.getNull(prdSceGetParamVO.getOutBound());
				inStr = JSPUtil.getNull(prdSceGetParamVO.getInBound());
				ocnStr = JSPUtil.getNull(prdSceGetParamVO.getOcnBound());
				inlndRoutOrg = JSPUtil.getNull(prdSceGetParamVO.getRoutOrgNodCd());
				inlndRoutDest = JSPUtil.getNull(prdSceGetParamVO.getRoutDestNodCd());

				if (ioBndCd.equals("O")) {
					subRout = outStr;
					// door so
					log.debug("\n o/b inlndRoutOrg before: " + inlndRoutOrg);
					inlndRoutOrg = JSPUtil.getNull(prdSceGetParamVO.getPorNodCd()).equals("") ? inlndRoutOrg : prdSceGetParamVO.getPorNodCd();
					log.debug("\n o/b inlndRoutOrg after: " + inlndRoutOrg);
				} else if (ioBndCd.equals("I")) {
					subRout = inStr;
					// door so
					log.debug("\n i/b inlndRoutDest before: " + inlndRoutDest);
					inlndRoutDest = JSPUtil.getNull(prdSceGetParamVO.getDelNodCd()).equals("") ? inlndRoutDest : prdSceGetParamVO.getDelNodCd();
					log.debug("\n i/b inlndRoutDest after: " + inlndRoutDest);
				} else if (ioBndCd.equals("T")) {
					subRout = ocnStr;
				}
				obTroFlg = JSPUtil.getNull(prdSceGetParamVO.getObTroFlg());
				ibTroFlg = JSPUtil.getNull(prdSceGetParamVO.getIbTroFlg());
				porNodCd = JSPUtil.getNull(prdSceGetParamVO.getPorNodCd());
				polNodCd = JSPUtil.getNull(prdSceGetParamVO.getPolYdCd());
				delNodCd = JSPUtil.getNull(prdSceGetParamVO.getDelNodCd());
				fullRtnYdCd = JSPUtil.getNull(prdSceGetParamVO.getFullRtnYdCd());
				fullPkUpYdCd = JSPUtil.getNull(prdSceGetParamVO.getFullPkupYdCd());
				obTrspMode = JSPUtil.getNull(prdSceGetParamVO.getObTrspMode());
				ibTrspMode = JSPUtil.getNull(prdSceGetParamVO.getIbTrspMode());

				// not to check validation
				prdSceGetParamVO.setSkipActValFlg("Y");

				// in case of inbound/outbound
				if (ioBndCd.equals("O")) {
					retPctlNo = searchSameRoutSce(prdCreateParamVO.getBkgNo(), outStr, inStr, ocnStr, smtPu, smtRtn, obTroFlg, ibTroFlg, inlndRoutOrg, polNodCd, srTerm, sdTerm, delNodCd, fullRtnYdCd, fullPkUpYdCd, obTrspMode, ibTrspMode);
					log.debug("\n\n searchSameRoutSce pctl_no:" + retPctlNo);
				} else if (ioBndCd.equals("I")) {
					retPctlNo = searchSameRoutSce(prdCreateParamVO.getBkgNo(), outStr, inStr, ocnStr, smtPu, smtRtn, obTroFlg, ibTroFlg, porNodCd, polNodCd, srTerm, sdTerm, inlndRoutDest, fullRtnYdCd, fullPkUpYdCd, obTrspMode, ibTrspMode);
					log.debug("\n\n searchSameRoutSce pctl_no:" + retPctlNo);

				}

				// 1.Ocn section 2.searchSameRoutSce = ""
				if (retPctlNo.equals("")) {
					// 1.Ocn section(T) 2. existing newPol or newPod at searchSameRoutSce list -> location changed -> pc creating .
					int successCnt = 0;
					if (ioBndCd.equals("T")) {// in case of T || !prdSceGetParamVO.getNewPol().equals("") || !prdSceGetParamVO.getNewPod().equals("")){
						// COP_AUTO_CHANGE_OCN_INLAND_CHANGE.txt .
						// prd mst, dtl creating
						successCnt = dbDaoSce.createSceSoReplaneOcnInlndChange(prdSceGetParamVO, hdPctlNo);

					} else {
						successCnt = dbDaoTro.troAutoChange(ioBndCd, srTerm, sdTerm, creUsrId, hdPctlNo, cct, pmF, podT, polT, spmFlg, srfCntr, smtPu, smtRtn, inlndRoutOrg, inlndRoutDest, sinclShtlSoFlg, subRout, fullCy, trspModCd, stermNode, prdCtlNo);
					}

					if (successCnt == 0) {
						Map<String, Object> map = new HashMap<String, Object>();

						map.put("prdSceGetParamVO", prdSceGetParamVO);
						map.put("PrdCreateParamVO", prdCreateParamVO);
						map.put("hdPctlNo", hdPctlNo);

						map.put("ioBndCd", ioBndCd);
						map.put("srTerm", srTerm);
						map.put("sdTerm", sdTerm);
						map.put("creUsrId", creUsrId);
						map.put("hdPctlNo", hdPctlNo);
						map.put("cct", cct);
						map.put("pmF", pmF);
						map.put("podT", podT);
						map.put("polT", polT);
						map.put("spmFlg", spmFlg);
						map.put("srfCntr", srfCntr);
						map.put("smtPu", smtPu);
						map.put("smtRtn", smtRtn);
						map.put("inlndRoutOrg", inlndRoutOrg);
						map.put("inlndRoutDest", inlndRoutDest);
						map.put("sinclShtlSoFlg", sinclShtlSoFlg);
						// I/O Included Shuttle S/O Flag
						map.put("ibInclShtlSoFlg", prdSceGetParamVO.getIbInclShtlSoFlg());
						map.put("obInclShtlSoFlg", prdSceGetParamVO.getObInclShtlSoFlg());
						map.put("subRout", subRout);
						map.put("fullCy", fullCy);
						map.put("trspModCd", trspModCd);
						map.put("stermNode", stermNode);
						map.put("prdCtlNo", prdCtlNo);

						String logDesc = "successFlag " + Integer.toString(successCnt) + " " + this.getParamString(map);
						log.debug("\n\n log::::" + logDesc);

						dbDao.createPrdExecLog(logDesc, "createSceSoReplan", creUsrId);
					}

					// param setting
					prdCreateParamVO.setTVvd(prdSceGetParamVO.getTVvd());
					event.setPrdCreateParamVO(prdCreateParamVO);

					// to set obTroFlg, ibTroFlg
					prdPcCreateVo.setObTroFlg(obTroFlg);
					prdPcCreateVo.setIbTroFlg(ibTroFlg);

					prdPatternVO.setObItchgCtnt(outStr);
					prdPatternVO.setOcnItchgCtnt(ocnStr);
					prdPatternVO.setIbItchgCtnt(inStr);

					// data (min, max pc no )
					prdCreateManageBc.dataArrangement(event);
					log.debug("\n\n -------------dataArrangement end----------------------");
					prdCreateManageBc.createActivityGroupIncludePattern(prdPcCreateVo, prdPatternVO, creUsrId);
					log.debug("\n\n -------------createActivityGroup end----------------------");
					prdCreateManageBc.updateActivityGroup(hdPctlNo);
					log.debug("\n\n -------------createActivityGroup end----------------------");
					retPctlNo = prdPcCreateVo.getMinPctlNo();
					log.debug("\n\n -------------createSceSoReplan end----------------------" + "\n return PCTL NO : " + retPctlNo);
				}
			} else { // param list is null
				throw new EventException(new ErrorHandler("PRD00061").getMessage());
			}

		} catch (DAOException e1) {
			log.error("err " + e1.toString(), e1);
			throw new EventException(new ErrorHandler(e1).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return retPctlNo;
	}

	/**
	 * moving to next step in case of terminal change(T)
	 * 
	 * calling from oltp of Sce
	 * 
	 * @param copNo
	 * @param ioBndCd
	 * @param newNod
	 * @param creUsrId
	 * @return String
	 * @throws EventException
	 */
	public String createSceManualReplan(String copNo, String ioBndCd, String newNod, String creUsrId) throws EventException {
		EsdPrd0080Event event = new EsdPrd0080Event();
		String hdPctlNo = "";

		String retPctlNo = "";
		try {

			// creating pc no
			PrdCreateManageBC prdCreateManageBc = new PrdCreateManageBCImpl();
			PrdCreateParamVO prdCreateParamVO = new PrdCreateParamVO();
			PrdPatternVO prdPatternVO = new PrdPatternVO();

			hdPctlNo = prdCreateManageBc.createPrdCtlNoGen(PrdConstants.PRD_PC_MOD_SCE_SO_REPLAN);
			prdCreateParamVO.setPcMode(PrdConstants.PRD_PC_MOD_SCE_SO_REPLAN);

			List<PrdSceGetParamVO> list = null;

			// pc return value object create
			PrdPcCreateVO prdPcCreateVo = new PrdPcCreateVO();
			// pc_no_head set
			prdPcCreateVo.setHdPctlNo(hdPctlNo);

			event.setPrdPcCreateVO(prdPcCreateVo);
			String pcMode = "";
			String doorZn = "";
			String fullRtnCy = "";
			String fullPuCy = "";
			String mtPu = "";
			String mtRtn = "";

			pcMode = prdCreateParamVO.getPcMode();
			list = dbDaoSce.sceGetParam(copNo, ioBndCd, pcMode, doorZn, fullRtnCy, fullPuCy, mtPu, mtRtn);

			PrdSceGetParamVO prdSceGetParamVO = null;
			if (list != null && list.size() > 0) {
				prdSceGetParamVO = (PrdSceGetParamVO) list.get(0);

				if (ioBndCd.equals("O") && newNod != null && !newNod.equals("")) {
					prdSceGetParamVO.setRoutOrgNodCd(newNod);
					// prdSceGetParamVO.setOutBound("");
					prdSceGetParamVO.setPorNodCd(newNod);
					prdSceGetParamVO.setPorCd(newNod.substring(0, 5));
					prdSceGetParamVO.setFullRtnYdCd("");
					prdSceGetParamVO.setObTrspMode("");

				} else if (ioBndCd.equals("O") && (newNod == null || newNod.equals(""))) {
					// prdSceGetParamVO.setOutBound("");
					prdSceGetParamVO.setFullRtnYdCd("");
					prdSceGetParamVO.setObTrspMode("");
				}

				if (ioBndCd.equals("I") && newNod != null && !newNod.equals("")) {
					prdSceGetParamVO.setRoutDestNodCd(newNod);
					// prdSceGetParamVO.setInBound("");
					prdSceGetParamVO.setDelNodCd(newNod);
					prdSceGetParamVO.setDelCd(newNod.substring(0, 5));
					prdSceGetParamVO.setFullPkupYdCd("");
					prdSceGetParamVO.setIbTrspMode("");
				} else if (ioBndCd.equals("I") && (newNod == null || newNod.equals(""))) {
					// prdSceGetParamVO.setInBound("");
					prdSceGetParamVO.setFullPkupYdCd("");
					prdSceGetParamVO.setIbTrspMode("");
				}

				prdSceGetParamVO.setManualFlag("Y");
				int successCnt = dbDaoSce.createSceSoReplaneOcnInlndChange(prdSceGetParamVO, hdPctlNo);

				if (successCnt == 0) {
					log.debug("\n\n PRD log On:");
					Map<String, Object> map = new HashMap<String, Object>();

					map.put("PrdSceGetParamVO", prdSceGetParamVO);
					map.put("hdPctlNo", hdPctlNo);
					map.put("usrId", "SCE");

					String logDesc = "successFlag " + Integer.toString(successCnt) + " " + this.getParamString(map);
					log.debug("\n\n log::::" + logDesc);

					dbDao.createPrdExecLog(logDesc, "createSceManualReplan", "SCE");
				}

				// param setting
				prdCreateParamVO.setTVvd(prdSceGetParamVO.getTVvd());
				event.setPrdCreateParamVO(prdCreateParamVO);

				// qty creating
				prdPatternVO.setObItchgCtnt(JSPUtil.getNull(prdSceGetParamVO.getOutBound()));
				prdPatternVO.setOcnItchgCtnt(JSPUtil.getNull(prdSceGetParamVO.getOcnBound()));
				prdPatternVO.setIbItchgCtnt(JSPUtil.getNull(prdSceGetParamVO.getInBound()));

				// data (min, max pc no )
				prdCreateManageBc.dataArrangement(event);
				log.debug("\n\n -------------dataArrangement end----------------------");
				prdCreateManageBc.createActivityGroupIncludePattern(prdPcCreateVo, prdPatternVO, creUsrId);
				log.debug("\n\n -------------createActivityGroup end----------------------");
				prdCreateManageBc.updateActivityGroup(hdPctlNo);
				log.debug("\n\n -------------createActivityGroup end----------------------");
				retPctlNo = prdPcCreateVo.getMinPctlNo();
				log.debug("\n\n -------------createSceSoReplan end----------------------" + "\n return PCTL NO : " + retPctlNo);

			} else { // list is null
				// SCE MENUAL REPLAN PARAMETER SEARCH NOT AVAILABLE.
				throw new EventException(new ErrorHandler("PRD00061").getMessage());
			}

		} catch (DAOException e1) {
			log.error("err " + e1.toString(), e1);
			throw new EventException(new ErrorHandler(e1).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return hdPctlNo;
	}

	/**
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse processReplaneFinish(Event e) throws EventException {
		EsdPrd0080Event event = (EsdPrd0080Event) e;
		PrdCreateParamVO prdCreateParamVO = event.getPrdCreateParamVO();
		List<PrdPatternVO> list = null;
		EventResponse eventResponse = new GeneralEventResponse();
		String eurDrChk = null;
		/*
		 * retrieving data. not creating PC
		 */
		// getting map sequence in case of replane
		String mapSeq = prdCreateParamVO.getMapSeq();
		if (prdCreateParamVO.getPcMode().equals(PrdConstants.PRD_PC_MOD_REPLAN)) {
			list = this.getReplanePatternByMapSeq(mapSeq);
			if (list != null && list.size() > 0) {
				log.debug("\n\n excepting prime pattern----------------");
				list.remove(0);
				log.debug("\n  list.size:" + list.size());
			}
			// sub pattern list
			if (list != null) {
				event.setAttribute("PATTERN_LIST", list);
				if (list.size() > 0) {
					log.debug("\n ord > 1 인 sub pattern으로 pc를 creating한다.list.size:" + list.size());
					PrdPatternVO prdPatternVO = (PrdPatternVO) list.get(0);
					if (prdPatternVO != null) {
						eventResponse.setETCData("map_seq", prdPatternVO.getCopMapgSeq());
					} else {
						eventResponse.setETCData("map_seq", "");
					}
					this.createSubPatternPrdCtlgFullRout(e);
					event.setAttribute("eur_dr_seq", mapSeq);
					try {
						eurDrChk = dbDao.chkEurDr(prdCreateParamVO.getBkgNo());

						if (eurDrChk.equals("Y")) {
							dbDao.updatePrdMapReInit(prdCreateParamVO.getBkgNo(), event.getAttribute("eur_dr_seq") + "");

							List<PrdSearchEurDrRePatternVO> eurDrList = dbDao.getEurDr(prdCreateParamVO.getBkgNo(), event.getAttribute("eur_dr_seq") + "");

							// creating PC
							PrdSearchEurDrRePatternVO prdSearchEurDrRePatternVO = null;
							for (int i = 0; i < eurDrList.size(); i++) {

								prdSearchEurDrRePatternVO = (PrdSearchEurDrRePatternVO) eurDrList.get(i);

								PrdPatternVO prdPatternVO2 = new PrdPatternVO();

								prdPatternVO2.setObItchgCtnt(prdSearchEurDrRePatternVO.getObContent());
								prdPatternVO2.setIbItchgCtnt(prdSearchEurDrRePatternVO.getIbContent());
								prdPatternVO2.setOcnItchgCtnt(prdSearchEurDrRePatternVO.getOcnContent());

								createPrdCtlgEurDoor(event, prdSearchEurDrRePatternVO, prdPatternVO2);

							}

						}
					} catch (Exception ex) {
						log.error("err " + ex.toString(), ex);
						try {
							log.debug("\n\n PRD log On:");
							Map<String, Object> map = new HashMap<String, Object>();
							String userId = ((SignOnUserAccount) event.getAttribute("account")).getUsr_id();
							map.put("bkgNO", prdCreateParamVO.getBkgNo());
							map.put("MainPatternPctlNo", prdCreateParamVO.getMainPatternPctlNo());
							map.put("mapSeq", mapSeq);
							map.put("usrId", userId);

							String logDesc = this.getParamString(map);
							log.debug("\n\n log::::" + logDesc);
							dbDao.createPrdExecLog(logDesc, "processReplaneFinish_err", userId);
						} catch (DAOException e1) {
							log.error("err " + e1.toString(), e1);
							throw new EventException(new ErrorHandler(e1).getMessage());
						}
						throw new EventException(new ErrorHandler(ex).getMessage());
					}
				}
			}
		}
		return eventResponse;
	}

	/**
	 * 
	 * @param pctlNo
	 * @param prdQtyInfoVO
	 * @param sumQty
	 * @param sumTpsz
	 * @return railCargoAvailRtnTmMap [from = get("RTN_TIME") , to = get("CUT_OFF")]
	 * 
	 */
	public Map<String, String> getRailRecevingTime(String pctlNo, PrdQtyInfoVO[] prdQtyInfoVOs, String sumQty, String sumTpsz) {
		Map<String, String> railCargoAvailRtnTmMap = null;
		try {
			if (prdQtyInfoVOs != null) {
				double thisSumQty = 0;
				String thisSumTpsz = "";

				for (int i = 0; i < prdQtyInfoVOs.length; i++) {
					String tpszSubstring = prdQtyInfoVOs[i].getCTpsz().substring(0, 1);
					if (!thisSumTpsz.contains(tpszSubstring)) {
						thisSumTpsz = thisSumTpsz + tpszSubstring;
					}
					thisSumQty += Double.parseDouble(prdQtyInfoVOs[i].getCQty());
				}

				sumQty = thisSumQty + "";
				sumTpsz = thisSumTpsz;
			}
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
		}
		try {
			PrdProdCtlMstVO mstVo = (PrdProdCtlMstVO) dbDao.getPrdMst(pctlNo).get(0);
			/****************************************************************
			 * getCargoReturnTime 에서 Rail Receive To Date(CUT_OFF)를 산출한 후 <br>
			 * Rail Receive To date기준으로 DMT에서 계산한 Free day 제하여<br>
			 * Rail Receive From date(RTN_TIME)를 계산함.<br>
			 ***************************************************************/
			railCargoAvailRtnTmMap = dbDao.getCargoReturnTime(pctlNo);
			mstVo.setN1stVslLodgDueDt(railCargoAvailRtnTmMap.get("CUT_OFF"));
			@SuppressWarnings("rawtypes")
			Map freeTmMap = dbDao.getFreeTime(mstVo, sumQty, sumTpsz);
			String ftTotDay = (String) freeTmMap.get("o_ft_total_day");
			if (!CheckUtilities.isInBlank(mstVo.getN1stVslLodgDueDt())) {
				int rtime = 0;
				if (!CheckUtilities.isInBlank(ftTotDay)) {
					rtime = Integer.parseInt(ftTotDay);
				}
				railCargoAvailRtnTmMap.put("RTN_TIME", DateTime.addDays(mstVo.getN1stVslLodgDueDt(), (rtime == 0 ? 3 : rtime) * -1, "yyyyMMdd"));
			} else {
				railCargoAvailRtnTmMap.put("CUT_OFF", "");
				railCargoAvailRtnTmMap.put("RTN_TIME", "");
			}
		} catch (DAOException e1) {
			log.error("err " + e1.toString(), e1);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
		}
		return railCargoAvailRtnTmMap;
	}
	

	/**
	 * @param e
	 * @return int
	 * @throws EventException
	 */
	public int updateMainMapSeq(Event e) throws EventException {
		EsdPrd0080Event event = (EsdPrd0080Event) e;
		PrdCreateParamVO prdCreateParamVO = event.getPrdCreateParamVO();
		SignOnUserAccount account = (SignOnUserAccount) e.getAttribute("account");
		/*
		 * careting PC, retrieving data
		 */
		// getting map sequence in case of replane
		String mapSeq = prdCreateParamVO.getMapSeq();
		log.debug("\n\n replane prime pattern handling-----------------------------------" + "\n processReplaneFinish ------------------------------------ " + "\n mapSeq : " + mapSeq);
		// updating map table with pc no of selected prime pattern
		int successCnt = this.updatePrdMapByPcNo(mapSeq, prdCreateParamVO.getBkgNo(), prdCreateParamVO.getMainPatternPctlNo(), "1");
		try {
			if (successCnt == 0) {
				log.debug("\n\n PRD log On:");
				Map<String, Object> map = new HashMap<String, Object>();

				map.put("bkgNO", prdCreateParamVO.getBkgNo());
				map.put("MainPatternPctlNo", prdCreateParamVO.getMainPatternPctlNo());
				map.put("mapSeq", mapSeq);
				map.put("usrId", account.getUsr_id());

				String logDesc = "successFlag " + Integer.toString(successCnt) + " " + this.getParamString(map);
				log.debug("\n\n log::::" + logDesc);

				dbDao.createPrdExecLog(logDesc, "updateMainMapSeq", account.getUsr_id());
			}
		} catch (DAOException e1) {
			log.error("err " + e1.toString(), e1);
			throw new EventException(new ErrorHandler(e1).getMessage());
		}
		return successCnt;
	}

	/**
	 * @param String bkgNo
	 * @param PrdQuantityVO[] prdQuantityVOs
	 * @return String .
	 * @throws EventException
	 */
	public String getReplanCntrTpszQty(String bkgNo, PrdQuantityVO[] prdQuantityVOs) throws EventException {
		StringBuffer cntrTpszQtyTblStr = new StringBuffer();
		try {
			ArrayList<String> alConType = new ArrayList<String>(); // Container Type
			ArrayList<String> alConQty = new ArrayList<String>(); // Container Quantity

			// 1. prdQuantityVO is null -> prepare Container Quantity basic info. with Bkg_quantity Info
			if (prdQuantityVOs.length == 0) {
				DBRowSet dbR = dbDao.checkBkgQty(bkgNo);
				while (dbR.next()) {
					alConQty.add(dbR.getString("C_QTY"));
					alConType.add(dbR.getString("C_TPSZ"));
				}
			} else {
				for (int t = 0; t < prdQuantityVOs.length; t++) {
					alConQty.add(prdQuantityVOs[t].getCQty());
					alConType.add(prdQuantityVOs[t].getCTpsz());
				}
			}

			// 3. D4@2@BKG,D5@1@SO pattern
			for (int j = 0; j < (alConType.isEmpty() ? 0 : alConType.size()); j++) {
				cntrTpszQtyTblStr.append(((j == 0) ? "" : ",") + alConType.get(j) + "@" + alConQty.get(j));
			}
			// cntrTpszQtyTblStr is null
			if (cntrTpszQtyTblStr.toString().equals("")) {
				cntrTpszQtyTblStr.append("''");
			}

			log.debug("\n D4@2@BKG,D5@1@SO pattern: " + cntrTpszQtyTblStr.toString());
		} catch (DAOException e1) {
			log.error("err " + e1.toString(), e1);
			throw new EventException(new ErrorHandler(e1).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}

		return cntrTpszQtyTblStr.toString();
	}

	/**
	 * checkEmptyPickUpYardValid
	 * 
	 * @param e
	 * @return String
	 * @throws EventException
	 */
	public String checkEmptyPickUpYardValid(Event e) throws EventException {
		try {
			EsdPrd0080Event event = (EsdPrd0080Event) e;
			PrdCreateParamVO prdCreateParamVO = event.getPrdCreateParamVO();
			return dbDao.checkEmptyPickUpYardValid(prdCreateParamVO.getChkYd());
		} catch (DAOException e1) {
			log.error("err " + e1.toString(), e1);
			throw new EventException(new ErrorHandler(e1).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * checkTpSz
	 * 
	 * @param e
	 * @return String
	 * @throws EventException
	 */
	public String checkTpSz(Event e) throws EventException {
		try {
			return dbDao.checkTpSz((String) ((EsdPrd0080Event) e).getAttribute("cntr_tpsz_cd"));
		} catch (DAOException e1) {
			log.error("err " + e1.toString(), e1);
			throw new EventException(new ErrorHandler(e1).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * modifyPrdProdCtlMstByPRI
	 * 
	 * @param prdParameterVO
	 * @throws EventException
	 */
	public void modifyPrdProdCtlMstByPRI(PrdParameterVO prdParameterVO) throws EventException {
		try {
			if (prdParameterVO.getPrdPriSetParamVO() != null) {
				dbDao.modifyPrdProdCtlMstByPRI(prdParameterVO.getPrdPriSetParamVO());
			}
		} catch (DAOException e1) {
			log.error("err " + e1.toString(), e1);
			throw new EventException(new ErrorHandler(e1).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Search Inland Cut Off Time
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public String searchInlandCutOffTime(Event e) throws EventException {
		try {
			return dbDao.searchInlandCutOffTime((String) e.getAttribute("search_pctl_no"));
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
}