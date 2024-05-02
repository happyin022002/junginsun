/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : PrdCommonManageBCImpl.java
 *@FileTitle : PRD Common Management
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 1.0 
=========================================================*/
package com.clt.apps.opus.esd.prd.common.prdcreate.basic;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.clt.apps.opus.esd.prd.common.PrdConstants;
import com.clt.apps.opus.esd.prd.common.prdcreate.integration.PrdCreateManageDBDAO;
import com.clt.apps.opus.esd.prd.common.prdcreate.vo.PrdPcCreateVO;
import com.clt.apps.opus.esd.prd.productcatalogcreate.productcatalogcreate.event.EsdPrd0080Event;
import com.clt.apps.opus.esd.prd.productcatalogcreate.productcatalogcreate.integration.ProductCatalogCreateDBDAO;
import com.clt.apps.opus.esd.prd.productcatalogcreate.productcatalogcreate.vo.PrdCreateParamVO;
import com.clt.apps.opus.esd.prd.productcatalogcreate.productcatalogcreate.vo.PrdPatternVO;
import com.clt.apps.opus.esd.prd.productcatalogcreate.productcatalogcreate.vo.PrdQuantityVO;
import com.clt.apps.opus.esd.prd.productcatalogcreate.productcatalogcreate.vo.PrdSubQuantityVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.PrdMainInfoVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.PrdParameterVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.PrdQtyInfoVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.PrdTroInfoVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.framework.utility.CheckUtilities;
import com.clt.syscommon.common.table.PrdBkgCopMapVO;

/**
 * PRD Business Logic Basic Command implementation<br>
 * 
 * @author jungsunyoung
 * @see EventResponse,PrdCommonManageBC
 * @since J2EE 1.4
 */
public class PrdCreateManageBCImpl extends BasicCommandSupport implements PrdCreateManageBC {

	// Database Access Object
	private transient PrdCreateManageDBDAO dbDao = null;
	private transient ProductCatalogCreateDBDAO productCatalogCreateDBDAO = null;

	/**
	 * creating PrdCommonManageBCImpl Object<br>
	 * creating PrdCommonManageDBDAO<br>
	 */
	public PrdCreateManageBCImpl() {
		dbDao = new PrdCreateManageDBDAO();
		productCatalogCreateDBDAO = new ProductCatalogCreateDBDAO();
	}

	/**
	 * biz scenario closing - PRD<br>
	 * clearing related objects<br>
	 */
	public void doEnd() {
		dbDao = null;
	}

	/**
	 * PrdCreateManageBCImpl's createPrdCtlNoGen
	 * 
	 * @param pcMode
	 * @return
	 * @throws EventException EventResponse
	 */
	public String createPrdCtlNoGen(String pcMode) throws EventException {
		int cnt = 0;
		String hdPctlNo = "";

		try {
			hdPctlNo = dbDao.createPrdCtlNoGenCop(pcMode);
		} catch (DAOException e) {
			log.error("createPrdCtlNoGen err " + e.toString(), e);
			throw new EventException((new ErrorHandler("PRD00003")).getMessage());

		}
		log.debug("\n do while cnt  " + cnt + " , prdCtlNo:" + hdPctlNo + "prdCtlNo.length():" + hdPctlNo.length()); // format 'B061205000000001' + XXXX

		if (hdPctlNo.length() < 16) {
			log.debug("\n fail to create prd ctl no !   prdCtlNo:" + hdPctlNo);
			throw new EventException((new ErrorHandler("PRD00003")).getMessage());
		}

		return hdPctlNo;
	}

	/**
	 * @param e
	 * @throws EventException
	 */
	public void createActivityGroup(Event e) throws EventException {
		EsdPrd0080Event event = (EsdPrd0080Event) e;
		PrdPcCreateVO prdPcCreateVo = event.getPrdPcCreateVO();
		SignOnUserAccount account = (SignOnUserAccount) e.getAttribute("account");

		try {
			dbDao.createActivityGroup(prdPcCreateVo.getHdPctlNo(), "A", account.getUsr_id());
		} catch (DAOException e1) {
			log.error("err " + e1.toString(), e1);
			throw new EventException(e1.getMessage());
		}
	}

	/**
	 * 
	 * @param e
	 * @throws EventException
	 */
	public void dataArrangement(Event e) throws EventException {
		try {

			EsdPrd0080Event event = (EsdPrd0080Event) e;
			PrdCreateParamVO prdCreateParamVO = event.getPrdCreateParamVO();
			PrdPcCreateVO prdPcCreateVo = event.getPrdPcCreateVO();
			// BKG Replan - filtering PC by checking SO
			// BKG Replan Filtering START

			updateCmlTztmHrs(prdPcCreateVo.getHdPctlNo());

			/*
			 * updating lane VVD of PRD DTL = VVD of VSK_VSL_SKD, lane of PRD DTL != lane of VSK_VSL_SKD => updating with lane of MDM_VSL_SVC_LANE
			 */
			updateLaneForFrd(prdPcCreateVo.getHdPctlNo());

			// deletePrdDtlNotSkd( prdPcCreateVo.getHdPctlNo());

			// deletePrdDtlByRank( prdPcCreateVo.getHdPctlNo() );

			// deletePrdQtyNotPcNo( prdPcCreateVo.getHdPctlNo() );

			// deletePrdMstNotPcNo( prdPcCreateVo.getHdPctlNo() );

			updatePrdMstTtlTztm(prdPcCreateVo.getHdPctlNo(), prdCreateParamVO.getTVvd());

			/*
			 * updatePrdDtlN1stVndrSeqOb ( ) updatePrdDtlN1stVndrSeqIb ( )
			 */

			// updatePrdDtlObTrspModDterm( prdPcCreateVo.getHdPctlNo() );
			// updatePrdDtlIbTrspModDterm( prdPcCreateVo.getHdPctlNo() );

			/*
			 * updating constraint Info. of PRD MST
			 */
			updatePrdMstRoutCnst(prdPcCreateVo.getHdPctlNo());

			/*
			 * updating route cnst of PRD MST X : SVC_USE_FLG = 'N' R : SVC_USE_FLG != 'N'
			 */
			updatePrdMstByRoutCnst(prdPcCreateVo.getHdPctlNo());

			/*
			 * updating Link Cnst of PRD DTL not showing Error Message in case of being checked at RD Column
			 */
			updatePrdDtlLnkCnst(prdPcCreateVo.getHdPctlNo(), prdCreateParamVO.getRdF());

			/*
			 * updating node Cnst of PRD DTL
			 */
			updatePrdDtlNodCnst(prdPcCreateVo.getHdPctlNo());

			/*
			 * updating Hub Loc Cnst of PRD DTL
			 */
			updatePrdDtlHubCnst(prdPcCreateVo.getHdPctlNo());

			/**
			 * updating cnst_flg of PRD MST <br>
			 * X : MST의 CNST_FLG = X or CNST_FLG of LINK of DLT = X or CNST_FLG of NODE of DTL = X <br>
			 * A : CNST_FLG of MST = R and LINK CNST_FLG of DTL = L and NODE CNST_FLG of DTL = N <br>
			 * O : CNST_FLG of MST = R and LINK CNST_FLG of DTL = L <br>
			 * P : CNST_FLG of MST = R and NODE CNST_FLG of DTL = N <br>
			 * R : CNST_FLG of MST = R <br>
			 * I : CNST_FLG of LNK = L and NODE CNST_FLG of DTL = N <br>
			 * L : CNST_FLG of LNK = L <br>
			 * N : NODE CNST_FLG of DTL = N
			 */
			updatePrdMstCnstFlg(prdPcCreateVo.getHdPctlNo());

			if ((prdCreateParamVO.getPcMode().equals(PrdConstants.PRD_PC_MOD_B) || prdCreateParamVO.getPcMode().equals(PrdConstants.PRD_PC_MOD_R)) && "Y".equals(prdCreateParamVO.getCnstDelFlg())) {
				// extra feautures [2015.01.20]
				removeCnstSvc(prdPcCreateVo.getHdPctlNo());
			}
			/*
			 * min, max pc no
			 */
			DBRowSet dbR = selectPcNoMinMax(prdPcCreateVo.getHdPctlNo());
			if (dbR.next()) {
				prdPcCreateVo.setMinPctlNo(dbR.getString("min_pc"));
				prdPcCreateVo.setMaxPctlNo(dbR.getString("max_pc"));
				log.debug("\n min pc:" + prdPcCreateVo.getMinPctlNo());
				log.debug("\n max pc:" + prdPcCreateVo.getMaxPctlNo());
				if (CheckUtilities.isInBlank(prdPcCreateVo.getMinPctlNo()) || CheckUtilities.isInBlank(prdPcCreateVo.getMaxPctlNo())) {
					throw new EventException((new ErrorHandler("PRD00074")).getMessage());
				}
			}
		} catch (SQLException e1) {
			log.error("updatePrdMstRoutCnst err " + e1.toString(), e1);
			throw new EventException((new ErrorHandler("PRD00003")).getMessage());

		} catch (EventException ee) {
			throw ee;
		} catch (Exception ex) {
			log.error("updatePrdMstRoutCnst err " + ex.toString(), ex);
			throw new EventException((new ErrorHandler("PRD00003")).getMessage());
		}
	}

	/**
	 * Constraints Service Flag :: “N” => Remove
	 * 
	 * @param hdPctlNo
	 * @throws EventException
	 */
	private void removeCnstSvc(String hdPctlNo) throws EventException {
		try {
			DBRowSet dbRowSet = dbDao.selectPrdProdMstByCnstSvc(hdPctlNo);
			while (dbRowSet.next()) {
				String pctl_no = dbRowSet.getString("pctl_no");
				dbDao.deletePrdProdCtlQty(pctl_no);
				dbDao.deletePrdProdCtlRoutDtl(pctl_no);
				dbDao.deletePrdProdCtlMst(pctl_no);
			}
		} catch (Exception e) {
			log.error("removeCnstSvc err " + e.toString(), e);
			throw new EventException((new ErrorHandler("PRD00003")).getMessage());
		}
	}

	/**
	 * selectPcNoMinMax
	 * 
	 * @param hdPctlNo
	 * @return
	 * @throws EventException
	 */
	private DBRowSet selectPcNoMinMax(String hdPctlNo) throws EventException {
		DBRowSet dbR = null;
		try {
			dbR = dbDao.selectPcNoMinMax(hdPctlNo);
		} catch (DAOException e) {
			log.error("selectPcNoMinMax err " + e.toString(), e);
			throw new EventException((new ErrorHandler("PRD00003")).getMessage());
		}
		return dbR;
	}

	/**
	 * updatePrdMstCnstFlg
	 * 
	 * @param hdPctlNo
	 * @throws EventException
	 */
	private void updatePrdMstCnstFlg(String hdPctlNo) throws EventException {
		try {
			dbDao.updatePrdMstCnstFlg(hdPctlNo);
		} catch (DAOException e) {
			log.error("updatePrdMstRoutCnst err " + e.toString(), e);
			throw new EventException((new ErrorHandler("PRD00003")).getMessage());

		}

	}

	/**
	 * updatePrdDtlNodCnst
	 * 
	 * @param hdPctlNo
	 * @throws EventException
	 */
	private void updatePrdDtlNodCnst(String hdPctlNo) throws EventException {
		try {
			dbDao.updatePrdDtlNodCnst(hdPctlNo);
		} catch (DAOException e) {
			log.error("updatePrdMstRoutCnst err " + e.toString(), e);
			throw new EventException((new ErrorHandler("PRD00003")).getMessage());

		}

	}

	/**
	 * updatePrdDtlNodCnst
	 * 
	 * @param hdPctlNo
	 * @throws EventException
	 */
	private void updatePrdDtlHubCnst(String hdPctlNo) throws EventException {
		try {
			dbDao.updatePrdDtlHubCnst(hdPctlNo);
		} catch (DAOException e) {
			log.error("updatePrdMstRoutCnst err " + e.toString(), e);
			throw new EventException((new ErrorHandler("PRD00003")).getMessage());

		}

	}

	/**
	 * updatePrdDtlLnkCnst
	 * 
	 * @param hdPctlNo
	 * @param rdF
	 * @throws EventException
	 */
	private void updatePrdDtlLnkCnst(String hdPctlNo, String rdF) throws EventException {
		try {
			dbDao.updatePrdDtlLnkCnst(hdPctlNo, rdF);
		} catch (DAOException e) {
			log.error("updatePrdMstRoutCnst err " + e.toString(), e);
			throw new EventException((new ErrorHandler("PRD00003")).getMessage());

		}

	}

	/**
	 * updatePrdMstByRoutCnst
	 * 
	 * @param hdPctlNo
	 * @throws EventException
	 */
	private void updatePrdMstByRoutCnst(String hdPctlNo) throws EventException {
		try {
			dbDao.updatePrdMstByRoutCnst(hdPctlNo);
		} catch (DAOException e) {
			log.error("updatePrdMstRoutCnst err " + e.toString(), e);
			throw new EventException((new ErrorHandler("PRD00003")).getMessage());
		}

	}

	/**
	 * updatePrdMstRoutCnst
	 * 
	 * @param hdPctlNo
	 * @throws EventException
	 */
	private void updatePrdMstRoutCnst(String hdPctlNo) throws EventException {
		try {
			dbDao.updatePrdMstRoutCnst(hdPctlNo);
		} catch (DAOException e) {
			log.error("updatePrdMstRoutCnst err " + e.toString(), e);
			throw new EventException((new ErrorHandler("PRD00003")).getMessage());
		}

	}

	/**
	 * updatePrdMstTtlTztm
	 * 
	 * @param hdPctlNo
	 * @param tVvd
	 * @throws EventException
	 */
	private void updatePrdMstTtlTztm(String hdPctlNo, String tVvd) throws EventException {
		try {
			dbDao.updatePrdMstTtlTztm(hdPctlNo, tVvd);
		} catch (DAOException e) {
			log.error("updatePrdMstTtlTztm err " + e.toString(), e);
			throw new EventException((new ErrorHandler("PRD00003")).getMessage());

		}

	}

	/**
	 * updateLaneForFrd
	 * 
	 * @param hdPctlNo
	 * @throws EventException
	 */
	private void updateLaneForFrd(String hdPctlNo) throws EventException {
		try {
			dbDao.updateLaneForFrd(hdPctlNo);
		} catch (DAOException e) {
			log.error("UpdateLaneForFrd err " + e.toString(), e);
			throw new EventException((new ErrorHandler("PRD00003")).getMessage());
		}

	}

	/**
	 * updateActivityGroup
	 * 
	 * @param hdPctlNo
	 * @throws EventException
	 */
	public void updateActivityGroup(String hdPctlNo) throws EventException {
		try {
			// dbDao.updateActivityGroup(hdPctlNo);
			dbDao.updateActivityGroupForLocShuttleSo(hdPctlNo);
		} catch (DAOException e1) {
			log.error("err " + e1.toString(), e1);
			throw new EventException(e1.getMessage());
		}
	}

	/**
	 * createContainerQty
	 * 
	 * @param e
	 * @throws EventException
	 */
	public void createContainerQty(Event e) throws EventException {
		EsdPrd0080Event event = (EsdPrd0080Event) e;
		PrdPcCreateVO prdPcCreateVo = event.getPrdPcCreateVO();
		PrdQuantityVO[] prdQuantityVO = event.getPrdQuantityVOs();
		PrdSubQuantityVO[] prdSubQuantityVO = event.getPrdSubQuantityVOs();
		SignOnUserAccount account = (SignOnUserAccount) e.getAttribute("account");
		DBRowSet dbRowset = null;
		try {
			// creating qty as much as created PC(mst)
			dbRowset = dbDao.selectPrdMst(prdPcCreateVo.getHdPctlNo());
			String newPctlNo = "";
			// in case of SUB - Container Type/Size to REV_..., Sub Container Type/Size to CNTR_TPSZ_CD/PCTL_QTY
			while (dbRowset.next()) {
				newPctlNo = dbRowset.getString(1);
				log.debug("new pc no :[" + newPctlNo + "]prdQuantityVO.length:" + prdQuantityVO.length);
				for (int i = 0; i < prdQuantityVO.length; i++) {
					log.debug("\n\n qty  i :[" + i + "]prdQuantityVO.:" + prdQuantityVO[i].getCTpsz());
				}
				for (int i = 0; i < prdQuantityVO.length; i++) {
					if (prdSubQuantityVO != null && prdSubQuantityVO.length > 0) {
						dbDao.createContainerQty(newPctlNo, prdSubQuantityVO[i].getSTpsz(), prdSubQuantityVO[i].getSQty(), prdQuantityVO[i].getCTpsz(), prdQuantityVO[i].getCQty(), account.getUsr_id());
					} else {
						dbDao.createContainerQty(newPctlNo, prdQuantityVO[i].getCTpsz(), prdQuantityVO[i].getCQty(), "", "0", account.getUsr_id());
					}
				}

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
	 * checkMixedRterm
	 * 
	 * @param bkgNo
	 * @param por
	 * @param rTerm
	 * @return String
	 * @throws EventException
	 */
	public String checkMixedRterm(String bkgNo, String por, String rTerm) throws EventException {

		String retValue = "";
		try {
			if (rTerm.equals("M")) {
				retValue = dbDao.searchMixedRterm(bkgNo, por);
			} else if (rTerm.equals("I")) {
				retValue = "F";
			} else {
				retValue = rTerm;
			}

		} catch (DAOException e1) {
			log.error("err " + e1.toString(), e1);
			throw new EventException(e1.getMessage());
		}
		return retValue;

	}

	/**
	 * PrdCreateManageBCImpl.java's checkMixedDterm
	 * 
	 * @param bkgNo
	 * @param del
	 * @param dTerm
	 * @return String
	 * @throws EventException
	 */
	public String checkMixedDterm(String bkgNo, String del, String dTerm) throws EventException {

		String retValue = "";
		try {
			if (dTerm.equals("M")) {
				retValue = dbDao.searchMixedDterm(bkgNo, del);
			} else if (dTerm.equals("O")) {
				retValue = "F";
			} else {
				retValue = dTerm;
			}

		} catch (DAOException e1) {
			log.error("err " + e1.toString(), e1);
			throw new EventException(e1.getMessage());
		}
		return retValue;

	}

	/**
	 * PrdCreateManageBC's getSkdType
	 * 
	 * @param vvd
	 * @param ldDt
	 * @param pol1
	 * @return
	 * @throws EventException
	 */
	public String getSkdType(String vvd, String ldDt, String pol1) throws EventException {
		String sSkdType = "";

		vvd = JSPUtil.getNull(vvd);
		ldDt = JSPUtil.getNull(ldDt);
		pol1 = JSPUtil.getNull(pol1);

		if (!"".equals(pol1)) {
			if (!"".equals(vvd)) {
				sSkdType = "V";
			} else if (!ldDt.equals("")) {
				sSkdType = "L";
			} else {
				sSkdType = "V";
			}
		} else if (!"".equals(vvd)) {
			if (!pol1.equals("")) {
				throw new EventException(new ErrorHandler("PRD00004").getMessage());
			}
			sSkdType = "V";
			log.debug("\n\n vvd not null");
		} else if ("".equals(pol1) && "".equals(vvd)) {
			if (!"".equals(ldDt)) {
				sSkdType = "L";
				log.debug("\n\n laoddate not null");
			}
		}
		return sSkdType;
	}

	/**
	 * PrdCreateManageBC's setPrdCreateParam
	 * 
	 * @param prdParameterVO
	 * @return
	 * @throws EventException
	 */
	public Event setPrdCreateParam(PrdParameterVO prdParameterVO) throws EventException {
		EsdPrd0080Event event = new EsdPrd0080Event();
		PrdMainInfoVO prdMainInfoVO = prdParameterVO.getPrdMainInfoVO();
		PrdCreateParamVO prdCreateParamVO = new PrdCreateParamVO();

		prdCreateParamVO.setAkF(prdMainInfoVO.getAkF());
		prdCreateParamVO.setBbF(prdMainInfoVO.getBbF());
		prdCreateParamVO.setBkgNo(prdMainInfoVO.getBkgNo());
		prdCreateParamVO.setBkgOfc(prdMainInfoVO.getBkgOfc());
		prdCreateParamVO.setCgoTp(prdMainInfoVO.getCgoTp());
		prdCreateParamVO.setCngn(prdMainInfoVO.getCngn());
		prdCreateParamVO.setCom(prdMainInfoVO.getCom());
		prdCreateParamVO.setCopyCnt(prdMainInfoVO.getCopyCnt());
		prdCreateParamVO.setDel(prdMainInfoVO.getDel());
		prdCreateParamVO.setDelN(prdMainInfoVO.getDelN());
		prdCreateParamVO.setDelT(prdMainInfoVO.getDelT());
		prdCreateParamVO.setDgF(prdMainInfoVO.getDgF());
		prdCreateParamVO.setDrDt(prdMainInfoVO.getDrDt());
		prdCreateParamVO.setFCmd(prdMainInfoVO.getFCmd());
		prdCreateParamVO.setFRt(prdMainInfoVO.getFRt());
		prdCreateParamVO.setHgF(prdMainInfoVO.getHgF());
		prdCreateParamVO.setHitchment(prdMainInfoVO.getHitchment());
		prdCreateParamVO.setImdg(prdMainInfoVO.getImdg());
		prdCreateParamVO.setLane1(prdMainInfoVO.getLane1());
		prdCreateParamVO.setLane2(prdMainInfoVO.getLane2());
		prdCreateParamVO.setLane3(prdMainInfoVO.getLane3());
		prdCreateParamVO.setLane4(prdMainInfoVO.getLane4());
		prdCreateParamVO.setLdDt(prdMainInfoVO.getLdDt());
		prdCreateParamVO.setMPu(prdMainInfoVO.getMPu());
		prdCreateParamVO.setOrgSalOfc(prdMainInfoVO.getOrgSalOfc());
		prdCreateParamVO.setPcMode(prdMainInfoVO.getPcMode());

		prdCreateParamVO.setFlexHgtFlg(prdMainInfoVO.getFlexHgtFlg());
		prdCreateParamVO.setPor(prdMainInfoVO.getPor());
		prdCreateParamVO.setPorN(prdMainInfoVO.getPorN());
		prdCreateParamVO.setPmF(prdMainInfoVO.getPmF());
		prdCreateParamVO.setPod(prdMainInfoVO.getPod());
		prdCreateParamVO.setPod1(prdMainInfoVO.getPod1());
		prdCreateParamVO.setPod1N(prdMainInfoVO.getPod1N());
		prdCreateParamVO.setPod2(prdMainInfoVO.getPod2());
		prdCreateParamVO.setPod2N(prdMainInfoVO.getPod2N());
		prdCreateParamVO.setPod3(prdMainInfoVO.getPod3());
		prdCreateParamVO.setPod3N(prdMainInfoVO.getPod3N());
		prdCreateParamVO.setPod4(prdMainInfoVO.getPod4());
		prdCreateParamVO.setPod4N(prdMainInfoVO.getPod4N());
		prdCreateParamVO.setPodN(prdMainInfoVO.getPodN());
		prdCreateParamVO.setPol(prdMainInfoVO.getPol());
		prdCreateParamVO.setPol1(prdMainInfoVO.getPol1());
		prdCreateParamVO.setPol1N(prdMainInfoVO.getPol1N());
		prdCreateParamVO.setPol2(prdMainInfoVO.getPol2());
		prdCreateParamVO.setPol2N(prdMainInfoVO.getPol2N());
		prdCreateParamVO.setPol3(prdMainInfoVO.getPol3());
		prdCreateParamVO.setPol3N(prdMainInfoVO.getPol3N());
		prdCreateParamVO.setPol4(prdMainInfoVO.getPol4());
		prdCreateParamVO.setPol4N(prdMainInfoVO.getPol4N());
		prdCreateParamVO.setPolN(prdMainInfoVO.getPolN());
		prdCreateParamVO.setRcvT(prdMainInfoVO.getRcvT());
		prdCreateParamVO.setRdF(prdMainInfoVO.getRdF());
		prdCreateParamVO.setRepCom(prdMainInfoVO.getRepCom());
		prdCreateParamVO.setRfa(prdMainInfoVO.getRfa());
		prdCreateParamVO.setRfaOfc(prdMainInfoVO.getRfaOfc());
		prdCreateParamVO.setRfF(prdMainInfoVO.getRfF());
		prdCreateParamVO.setSc(prdMainInfoVO.getSc());
		prdCreateParamVO.setScOfc(prdMainInfoVO.getScOfc());
		prdCreateParamVO.setShpr(prdMainInfoVO.getShpr());
		prdCreateParamVO.setSocF(prdMainInfoVO.getSocF());
		prdCreateParamVO.setSubF(prdMainInfoVO.getSubF());
		prdCreateParamVO.setTVvd(prdMainInfoVO.getTVvd());
		prdCreateParamVO.setVvd1(prdMainInfoVO.getVvd1());
		prdCreateParamVO.setVvd2(prdMainInfoVO.getVvd2());
		prdCreateParamVO.setVvd3(prdMainInfoVO.getVvd3());
		prdCreateParamVO.setVvd4(prdMainInfoVO.getVvd4());
		log.debug("\n booking prdMainInfoVO.getTVvd():" + prdMainInfoVO.getTVvd());
		prdCreateParamVO.setWgt(prdMainInfoVO.getWgt());
		prdCreateParamVO.setWgtUn(prdMainInfoVO.getWgtUn());

		prdCreateParamVO.setMtPkupDt(prdMainInfoVO.getMtPkupDt());
		log.debug("\n booking prdMainInfoVO.getMtPkupDt():" + prdMainInfoVO.getMtPkupDt());
		prdCreateParamVO.setObTrspMode(prdMainInfoVO.getOrgTrnsMode());
		prdCreateParamVO.setIbTrspMode(prdMainInfoVO.getDestTrnsMode());
		
		prdCreateParamVO.setIgnoreHitch(prdMainInfoVO.getIgnoreHitch());

		// booking qty
		List<PrdQtyInfoVO> prdQtyInfoVoList = prdParameterVO.getPrdQtyInfo();
		PrdQtyInfoVO prdQtyInfoVO = new PrdQtyInfoVO();

		// prd qty
		Collection<PrdQuantityVO> models = new ArrayList<PrdQuantityVO>();
		log.debug("\n booking PrdQtyInfoVoList.size():" + prdQtyInfoVoList.size());

		double sumBkgQty = 0;
		StringBuilder sumCTpSz = new StringBuilder();

		for (int i = 0; i < prdQtyInfoVoList.size(); i++) {
			PrdQuantityVO prdQuantityVO = new PrdQuantityVO();
			log.debug("\n booking prdQtyInfoVO:" + prdQtyInfoVO.toString());
			prdQtyInfoVO = prdQtyInfoVoList.get(i);
			prdQuantityVO.setCTpsz(prdQtyInfoVO.getCTpsz());
			prdQuantityVO.setCQty(prdQtyInfoVO.getCQty());

			sumBkgQty += Double.parseDouble(prdQtyInfoVO.getCQty());
			models.add(prdQuantityVO);
			String tpSz = prdQuantityVO.getCTpsz().substring(0, 1);
			sumCTpSz.append(sumCTpSz.indexOf(tpSz) > 0 ? "" : tpSz);
		}
		prdCreateParamVO.setSumBkgQty(Double.toString(sumBkgQty));
		prdCreateParamVO.setSumCTpSz(sumCTpSz.toString());

		PrdQuantityVO[] vos = (PrdQuantityVO[]) models.toArray(new PrdQuantityVO[models.size()]);

		// booking tro
		if (prdParameterVO.getPrdMainInfoVO().getPcMode().equals(PrdConstants.PRD_PC_MOD_O) || prdParameterVO.getPrdMainInfoVO().getPcMode().equals(PrdConstants.PRD_PC_MOD_I)) {
			PrdTroInfoVO bkgPrdTroInfoVO = prdParameterVO.getPrdTroInfoVO();
			prdCreateParamVO.setCntrNo(bkgPrdTroInfoVO.getCntrNo());
			prdCreateParamVO.setDorZone(bkgPrdTroInfoVO.getDorZone());
			prdCreateParamVO.setHaulage(bkgPrdTroInfoVO.getHaulage());
			prdCreateParamVO.setTrMode(bkgPrdTroInfoVO.getTrMode());
			prdCreateParamVO.setTroPkupCy(bkgPrdTroInfoVO.getTroPkupCy());
			prdCreateParamVO.setTroRtnCy(bkgPrdTroInfoVO.getTroRtnCy());
			prdCreateParamVO.setTroSeq(bkgPrdTroInfoVO.getTroSeq());
			prdCreateParamVO.setTroSubSeq(bkgPrdTroInfoVO.getTroSubSeq());
			prdCreateParamVO.setReplaneBndCd(prdParameterVO.getPrdMainInfoVO().getPcMode());
			prdCreateParamVO.setAreaContiCd(bkgPrdTroInfoVO.getAreaContiCd());
		}

		// double calling - setting seq
		prdCreateParamVO.setN1stPolDcSeq(prdMainInfoVO.getPol1C());
		prdCreateParamVO.setN1stPodDcSeq(prdMainInfoVO.getPod1C());
		prdCreateParamVO.setN2ndPolDcSeq(prdMainInfoVO.getPol2C());
		prdCreateParamVO.setN2ndPodDcSeq(prdMainInfoVO.getPod2C());
		prdCreateParamVO.setN3rdPolDcSeq(prdMainInfoVO.getPol3C());
		prdCreateParamVO.setN3rdPodDcSeq(prdMainInfoVO.getPod3C());
		prdCreateParamVO.setN4thPolDcSeq(prdMainInfoVO.getPol4C());
		prdCreateParamVO.setN4thPodDcSeq(prdMainInfoVO.getPod4C());
		prdCreateParamVO.setOcnSeq(prdMainInfoVO.getOcnSeq());
		event.setPrdCreateParamVO(prdCreateParamVO);
		event.setPrdQuantityVOs(vos);

		return event;
	}

	/**
	 * PrdCreateManageBCImpl.java's createActivityGroupIncludePattern
	 * 
	 * @param prdPcCreateVo
	 * @param prdPatternVO
	 * @param usr_id
	 * @throws EventException
	 */
	public void createActivityGroupIncludePattern(PrdPcCreateVO prdPcCreateVo, PrdPatternVO prdPatternVO, String usr_id) throws EventException {

		String ioBndCd = "A";
		String patternStr = "";
		String hdPctlNo = prdPcCreateVo.getHdPctlNo();
		String obTroFlg = prdPcCreateVo.getObTroFlg();
		String ibTroFlg = prdPcCreateVo.getIbTroFlg();

		if (prdPatternVO == null) {
			patternStr = "";
		} else {
			patternStr = prdPatternVO.getObItchgCtnt() + prdPatternVO.getOcnItchgCtnt() + prdPatternVO.getIbItchgCtnt();
			log.debug("\n before patternStr:" + patternStr);
			patternStr = JSPUtil.replace(patternStr, "%%", "%");
			log.debug("\n after patternStr:" + patternStr);
		}
		log.error("\n patternStr:" + patternStr);

		try {
			dbDao.createActivityGroupIncludePattern(hdPctlNo, ioBndCd, patternStr, usr_id, obTroFlg, ibTroFlg);
		} catch (DAOException e1) {
			log.error("err " + e1.toString(), e1);
			throw new EventException(e1.getMessage());
		}
	}

	/**
	 * PrdCreateManageBCImpl.java's checkMixedTermYard
	 * 
	 * @param term
	 * @param node
	 * @return
	 * @throws EventException
	 */
	public String checkMixedTermYard(String term, String node) throws EventException {
		String retValue = "";
		try {
			retValue = dbDao.searchMixedTermNodeValidation(term, node);
		} catch (DAOException e1) {
			log.error("err " + e1.toString(), e1);
			throw new EventException(e1.getMessage());
		}
		return retValue;
	}

	/**
	 * PrdCreateManageBCImpl.java's updateActivityGroupIncludePattern
	 * 
	 * @param prdBkgCopMapVO
	 * @param hdPctlNo
	 * @param mapSeq
	 * @param usr_id
	 * @throws EventException
	 */
	public void updateActivityGroupIncludePattern(PrdBkgCopMapVO prdBkgCopMapVO, String hdPctlNo, String[] mapSeq, String usr_id) throws EventException {
		String obTroFlg = "N";
		String ibTroFlg = "N";
		String patternStr = "";
		PrdPatternVO prdPatternVO = null;
		List<PrdPatternVO> prdPatternVOs = null;
		try {
			if (prdBkgCopMapVO != null) {
				obTroFlg = prdBkgCopMapVO.getObTroFlg();
				ibTroFlg = prdBkgCopMapVO.getIbTroFlg();
				patternStr = JSPUtil.replace(prdBkgCopMapVO.getObItchgCtnt() + prdBkgCopMapVO.getOcnItchgCtnt() + prdBkgCopMapVO.getIbItchgCtnt(), "%%", "%");
				dbDao.updateActivityGroupIncludePattern(hdPctlNo, "A", patternStr, usr_id, obTroFlg, ibTroFlg);
			} else {
				if (mapSeq != null) {
					for (int i = 0; i < mapSeq.length; i++) {
						if (CheckUtilities.isInBlank(mapSeq[i]))
							continue;
						prdPatternVOs = productCatalogCreateDBDAO.searchCurrentPatternOrd(mapSeq[i]);
						if (prdPatternVOs != null && prdPatternVOs.size() >= 1) {
							prdPatternVO = (PrdPatternVO) prdPatternVOs.get(0);
							obTroFlg = prdPatternVO.getObTroFlg();
							ibTroFlg = prdPatternVO.getIbTroFlg();
							patternStr = JSPUtil.replace(prdPatternVO.getObItchgCtnt() + prdPatternVO.getOcnItchgCtnt() + prdPatternVO.getIbItchgCtnt(), "%%", "%");
							dbDao.updateActivityGroupIncludePattern(hdPctlNo, "A", patternStr, usr_id, obTroFlg, ibTroFlg);
						}
					}
				} else {
					dbDao.updateActivityGroupIncludePattern(hdPctlNo, "A", patternStr, usr_id, obTroFlg, ibTroFlg);
				}
			}
		} catch (DAOException e1) {
			log.error("err " + e1.toString(), e1);
			throw new EventException(e1.getMessage());
		}
	}

	/**
	 * PRD_PROD_CTL_MST [ CML_OCN_TZTM_HRS / CML_TTL_TZTM_HRS ]
	 * 
	 * @param hdPctlNo
	 * @throws EventException
	 */
	private void updateCmlTztmHrs(String hdPctlNo) throws EventException {
		try {
			dbDao.updateCmlTztmHrs(hdPctlNo);
		} catch (DAOException e1) {
			log.error("updateCmlTztmHrs err " + e1.toString(), e1);
			throw new EventException(e1.getMessage());
		}
	}

	/**
	 * 
	 * @param hdPctlNo
	 * @param bkgNo
	 * @param copNo
	 * @param usr_id
	 * @throws EventException
	 */
	public void updateActivityGroupIncludePatternSceReplan(String hdPctlNo, String bkgNo, String copNo, String usr_id) throws EventException {
		try {
			if (!CheckUtilities.isInBlank(hdPctlNo) && !CheckUtilities.isInBlank(bkgNo) && !CheckUtilities.isInBlank(copNo)) {
				List<PrdPatternVO> prdPatternVOs = productCatalogCreateDBDAO.searchCurrentPatternOrd(hdPctlNo, bkgNo, copNo);
				if (prdPatternVOs != null && prdPatternVOs.size() >= 1) {
					PrdPatternVO prdPatternVO = (PrdPatternVO) prdPatternVOs.get(0);
					updateActivityGroupIncludePattern(null, hdPctlNo, new String[] { prdPatternVO.getCopMapgSeq() }, usr_id);
				}
			}
		} catch (DAOException e1) {
			log.error("err " + e1.toString(), e1);
			throw new EventException(e1.getMessage());
		}
	}
}