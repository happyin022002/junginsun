/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ReplanManageBCImpl.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.sce.replanmanage.replanmanage.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

import com.clt.apps.opus.esd.prd.common.prdcreate.basic.PrdCreateManageBC;
import com.clt.apps.opus.esd.prd.common.prdcreate.basic.PrdCreateManageBCImpl;
import com.clt.apps.opus.esd.prd.productcatalogcreate.productcatalogcreate.basic.ProductCatalogCreateBC;
import com.clt.apps.opus.esd.prd.productcatalogcreate.productcatalogcreate.basic.ProductCatalogCreateBCImpl;
import com.clt.apps.opus.esd.sce.bkgcopmanage.basic.BkgCopManageBC;
import com.clt.apps.opus.esd.sce.bkgcopmanage.basic.BkgCopManageBCImpl;
import com.clt.apps.opus.esd.sce.common.SCEConstants;
import com.clt.apps.opus.esd.sce.common.util.integration.CodeUtilDBDAO;
import com.clt.apps.opus.esd.sce.common.util.vo.SearchExptTgtVO;
import com.clt.apps.opus.esd.sce.copdetailreceive.basic.CopDetailReceiveBC;
import com.clt.apps.opus.esd.sce.copdetailreceive.basic.CopDetailReceiveBCImpl;
import com.clt.apps.opus.esd.sce.copdetailreceive.vo.SceActRcvIfVO;
import com.clt.apps.opus.esd.sce.replanmanage.replanmanage.integration.ReplanManageDBDAO;
import com.clt.apps.opus.esd.sce.replanmanage.replanmanage.vo.ReplanResultVO;
import com.clt.apps.opus.esd.sce.replanmanage.replanmanage.vo.SearchSoByCopVO;
import com.clt.apps.opus.esd.trs.cydoorsomanage.singletransportationsomanage.vo.SingleTransportationVO;
import com.clt.apps.opus.esm.coa.stdunitcost.costassign.basic.CostAssignBC;
import com.clt.apps.opus.esm.coa.stdunitcost.costassign.basic.CostAssignBCImpl;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.util.object.ObjectCloner;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.CoaBkgComIfVO;
import com.clt.syscommon.common.table.PrdBkgCopMapVO;
import com.clt.syscommon.common.table.PrdProdCtlMstVO;
import com.clt.syscommon.common.table.SceCopDtlVO;
import com.clt.syscommon.common.table.SceCopHdrVO;
import com.clt.syscommon.common.table.ScePlnSoListVO;
import com.clt.syscommon.common.table.SceTroMapgVO;
import com.clt.syscommon.common.table.TrsTrspEdiRailOrdVO;
import com.clt.syscommon.common.table.TrsTrspRailBilOrdVO;
import com.clt.syscommon.common.table.TrsTrspSvcOrdVO;

/**
 * ReplanManage Business Logic Command Interface<br>
 *
 * @author 
 * @see BasicCommandSupport , ReplanManageBC 
 * @since J2EE 1.6
 */
public class ReplanManageBCImpl extends BasicCommandSupport implements ReplanManageBC {

	// Database Access Object
	private transient ReplanManageDBDAO dbDao = null;
	private transient ProductCatalogCreateBC prdBC = null;
	private transient CopDetailReceiveBC copDetailReceiveBC = null;
	private transient PrdCreateManageBC prdCreateManageBC = null;
	
	private transient CodeUtilDBDAO dbUtilDao = null;

	/**
	 * ReplanManageBCImpl 객체 생성<br>
	 * ReplanManageDBDAO를 생성한다.<br>
	 */
	public ReplanManageBCImpl() {
		dbDao = new ReplanManageDBDAO();
		prdBC = new ProductCatalogCreateBCImpl();
		prdCreateManageBC = new PrdCreateManageBCImpl();
		copDetailReceiveBC = new CopDetailReceiveBCImpl();
		
		dbUtilDao = new CodeUtilDBDAO();
	}
	
	/**
	 * COP unit performs replan. 
	 * 
	 * Booking replan (updateBkg) except for the case of all the basic standards will replan..
	 * Based on the information in the PRD_PROD_CTL_MST SCE_COP_HDR to update
	 * SCE_PLN_SO_LIST, SCE_COP_DTL delete an existing information and then re-create some of the data that keeps. (ex> so status, Check outgoing edi etc)
	 * In addition, information-based materials obtained by collecting actual date on COP Detail is remapped. There is a re-transfer the EDI 315.
	 * 
	 * @param sceCopHdrVO
	 * @param cop_upd_rmk
	 * @return boolean
	 * @throws EventException
	 * @see com.clt.apps.opus.esd.sce.replanmanage.replanmanage.basic.ReplanManageBC#replanCop(com.clt.syscommon.common.table.SceCopHdrVO, java.lang.String)
	 */
	public boolean replanCop (SceCopHdrVO sceCopHdrVO, String cop_upd_rmk) throws EventException {
		int hdrCnt = 0;
		int plnSoCnt = 0;
		int copDtlCnt = 0;
		
		boolean isSuccess = true;
		try {
			// 1. SCE_COP_HDR 부분 수정 작업
			String pctl_no = sceCopHdrVO.getPctlNo();
			String cop_no = sceCopHdrVO.getCopNo();
			String bkg_no = sceCopHdrVO.getBkgNo();
			String mst_cop_no = sceCopHdrVO.getMstCopNo();
			
			dbDao.callPrdSetActDwTimePrc(pctl_no, "I", "N", "SYS");	
			prdCreateManageBC.updateActivityGroupIncludePatternSceReplan(pctl_no, bkg_no, cop_no, "SYS");
			
			List<SceCopHdrVO> toBeUpdtHdrList = new ArrayList<SceCopHdrVO> ();
			List<PrdProdCtlMstVO> prdProdCtlMstList = dbDao.searchPrdMst(pctl_no);
			
			if (prdProdCtlMstList.size() == 0) 
				return false;
			
			PrdProdCtlMstVO prdProdCtlMstVO = prdProdCtlMstList.get(0);
			
			ObjectCloner.build(prdProdCtlMstVO, sceCopHdrVO);
			
			sceCopHdrVO.setCopNo(cop_no);
			sceCopHdrVO.setPctlNo(pctl_no);
			sceCopHdrVO.setBkgNo(bkg_no);
			
			String copRailChkCd = dbDao.searchCopRailChk(pctl_no);
			sceCopHdrVO.setCopRailChkCd(copRailChkCd);
			
			sceCopHdrVO.setCopUpdRmk("Rpln:" + cop_upd_rmk + ":" + pctl_no);
			
			toBeUpdtHdrList.add(sceCopHdrVO);
			
			hdrCnt = dbDao.modifyCopHdr(toBeUpdtHdrList, cop_no);
			
			// 2. SCE_PLN_SO_LIST 생성 작업
			// 새로 생성될 SCE_PLN_SO_LIST 를 가져온다.
			List<ScePlnSoListVO> toBePlnSoList = dbDao.searchPlnSoListToBeInserted(sceCopHdrVO);
			
			// 기존의 SCE_PLN_SO_LIST 를 가져온다.
			List<ScePlnSoListVO> crntPlnSoList = dbDao.searchPlnSoListByCop(cop_no);			
			List<ScePlnSoListVO> toBeInsertedPlnSoVO = new ArrayList<ScePlnSoListVO> ();
					
			//TODO 2010.04.11 단순 cost_act_grp_seq 비교에서 from ~ to node / trsp mode check 로 수정 필요
			for (int i = 0 ; i < toBePlnSoList.size(); i ++) {
				ScePlnSoListVO toBeRowVO = toBePlnSoList.get(i);
				for (int j = 0 ; j < crntPlnSoList.size(); j ++) {
					ScePlnSoListVO crntRowVO = crntPlnSoList.get(j);
					if (crntRowVO.getCostActGrpSeq().equals(toBeRowVO.getCostActGrpSeq()) && crntRowVO.getCopNo().equals(toBeRowVO.getCopNo())) {
						// so 가 발생한 cop 의 cost_act_grp_seq 에 대해서 so status 를 변경
						if (crntRowVO.getTrspSoStsCd() != null && !crntRowVO.getTrspSoStsCd().equals("") && !crntRowVO.getTrspSoStsCd().equals("P"))						
							toBeRowVO.setTrspSoStsCd (crntRowVO.getTrspSoStsCd());
					}
				}
				toBeInsertedPlnSoVO.add(toBeRowVO);
			}
			
			dbDao.removeSoList(cop_no);
			
			if (toBeInsertedPlnSoVO.size() != 0) 
				plnSoCnt = dbDao.addPlnSoList(toBeInsertedPlnSoVO);
			
			// 3. SCE_COP_DTL 생성 작업
			// 기존의 SCE_COP_DTL 정보를 가져온다.
			List<SceCopDtlVO> crntDtlList = dbDao.searchCopDtl(sceCopHdrVO);
			
			List<SceCopDtlVO> toBeDtlList = dbDao.searchCopDtlToBeInserted(sceCopHdrVO);
			
			List<SceCopDtlVO> toBeInsertedDtlVO = new ArrayList<SceCopDtlVO> ();
			

			for (int i = 0; i < toBeDtlList.size(); i ++) {
				SceCopDtlVO toBeRowVO = toBeDtlList.get(i);
				for (int j = 0 ; j < crntDtlList.size(); j ++) {
					SceCopDtlVO crntRowVO = crntDtlList.get(j);
					if (crntRowVO.getActCd().equals(toBeRowVO.getActCd()) && crntRowVO.getNodCd().equals(toBeRowVO.getNodCd()) && !crntRowVO.getActDt().equals("") ) {
						
						toBeRowVO.setVndrSeq(crntRowVO.getVndrSeq());
						toBeRowVO.setEdiMsgTpCd(crntRowVO.getEdiMsgTpCd());
						toBeRowVO.setEdiActSndDt(crntRowVO.getEdiActSndDt());
						toBeRowVO.setEdiSndTpCd(crntRowVO.getEdiSndTpCd());
						toBeRowVO.setStndEdiStsCd(crntRowVO.getStndEdiStsCd());
						
					} else { // toBeRow 에 기존 act_dt 가 존재 하지 않을 경우에는 actual mapping table 에서 정보를 찾는다.
						if (i == 0) {
							toBeRowVO.setActStsCd("C");
						}
					}
				}
				toBeInsertedDtlVO.add(toBeRowVO);
			}
			
			dbDao.removeCopDtl(cop_no);
			copDtlCnt = dbDao.addCopDtl(toBeInsertedDtlVO);
			
			if (copDtlCnt != 0 && (sceCopHdrVO.getCntrNo() != null && !sceCopHdrVO.getCntrNo().equals(SCEConstants.PSEUDO_CNTR_NO))) {
				List<SceActRcvIfVO> actualList = dbDao.searchActualToBeUpdated(sceCopHdrVO.getCopNo());
//				public void copDetailReceiveREPLAN(SceActRcvIfVO actVo) throws EventException METHOD 사용!
				for (int i = 0; i < actualList.size(); i ++) {
					SceActRcvIfVO actVO = actualList.get(i);
					copDetailReceiveBC.copDetailReceiveREPLAN(actVO);
				}
				
			} 
			
			// master cop 이고 sce_cop_hdr, sce_pln_so_list, sce_cop_dtl 중 처리된 건이 하나도 없는 경우가 있으면 false
			if ((hdrCnt == 0 || plnSoCnt == 0 || copDtlCnt == 0) && cop_no.equals(mst_cop_no))
				isSuccess = false;
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException (new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException (new ErrorHandler(ex).getMessage());
		}	
		return isSuccess; 
	}
	
	/**
	 * Temporary cop replan logic management
	 * @param sceCopHdrVO
	 * @throws EventException
	 * @see com.clt.apps.opus.esd.sce.replanmanage.replanmanage.basic.ReplanManageBC#replanCopTmp(com.clt.syscommon.common.table.SceCopHdrVO)
	 */
	public void replanCopTmp (SceCopHdrVO sceCopHdrVO) throws EventException {
		
		try {
			if (sceCopHdrVO.getCntrNo() != null && !sceCopHdrVO.getCntrNo().equals(SCEConstants.PSEUDO_CNTR_NO)) {
				List<SceActRcvIfVO> actualList = dbDao.searchActualToBeUpdatedTmpPrc(sceCopHdrVO.getCopNo());
//				public void copDetailReceiveREPLAN(SceActRcvIfVO actVo) throws EventException METHOD Used!
				if (actualList.size() != 0 ) {
					for (int i = 0; i < actualList.size(); i ++) {
						SceActRcvIfVO actVO = actualList.get(i);
						copDetailReceiveBC.modifyActDatRcvDtByTmpRole(actVO);
					}	
				}
			}
			// master cop and sce_cop_hdr, sce_pln_so_list, sce_cop_dtl If you do not even thing of the treated cases if there is false
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException (new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException (new ErrorHandler(ex).getMessage());
		}	
	}
	
	/**
	 * Temporary cop replan logic management
	 * @param sceCopHdrVO
	 * @throws EventException
	 * @see com.clt.apps.opus.esd.sce.replanmanage.replanmanage.basic.ReplanManageBC#replanCopTmp(com.clt.syscommon.common.table.SceCopHdrVO)
	 */
	public void replanCopTmpVSK (SceCopHdrVO sceCopHdrVO) throws EventException {
		
		try {
			if (sceCopHdrVO.getCntrNo() != null && !sceCopHdrVO.getCntrNo().equals(SCEConstants.PSEUDO_CNTR_NO)) {
				List<SceActRcvIfVO> actualList = dbDao.searchActualToBeUpdatedTmpVSK(sceCopHdrVO.getCopNo());
//				public void copDetailReceiveREPLAN(SceActRcvIfVO actVo) throws EventException METHOD 사용!
				
				if (actualList.size() != 0 ) {
					for (int i = 0; i < actualList.size(); i ++) {
						SceActRcvIfVO actVO = actualList.get(i);
						copDetailReceiveBC.modifyActDatRcvDtByTmpVSK(actVO);
					}	
				}
			}
			// master cop and sce_cop_hdr, sce_pln_so_list, sce_cop_dtl If you do not even thing of the treated cases if there is false
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException (new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException (new ErrorHandler(ex).getMessage());
		}	
	}
	
	/**
	 * When booking replan updateBkg method call to the PRD_CHANGE_FRM_MAP, PSEUDO_VVD_UPDATE_FRM_MAP operation type is invoked when a replan is performed 
	 * The basic logic of the replanCop (SceCopHdrVO, String) and similar
	 * @param prdBkgCopMapVO
	 * @throws EventException
	 * @see com.clt.apps.opus.esd.sce.replanmanage.replanmanage.basic.ReplanManageBC#replanCopByPrdMap(com.clt.syscommon.common.table.PrdBkgCopMapVO)
	 */
	public void replanCopByPrdMap (PrdBkgCopMapVO prdBkgCopMapVO) throws EventException {
		String cop_no = prdBkgCopMapVO.getCopNo();
		String pctl_no = prdBkgCopMapVO.getPctlNo();
		String bkg_no = prdBkgCopMapVO.getBkgNo();
		
		String cntr_tpsz_cd = prdBkgCopMapVO.getCntrTpszCd();
//		String cntr_no = prdBkgCopMapVO.getCntrNo();
		
		try {
			// 1. (Edit) SCE_COP_HDR
			List<SceCopHdrVO> toBeUpdtHdrList = new ArrayList<SceCopHdrVO> ();
			List<PrdProdCtlMstVO> prdProdCtlMstList = dbDao.searchPrdMst(pctl_no);
			
			if (prdProdCtlMstList.size() == 0) {
				throw new EventException("No PCTL No found = " + pctl_no);
			}
				
			PrdProdCtlMstVO prdProdCtlMstVO = prdProdCtlMstList.get(0);
			
			String tobeVVD = prdProdCtlMstVO.getTrnkVslCd() + prdProdCtlMstVO.getTrnkSkdVoyNo() + prdProdCtlMstVO.getTrnkSkdDirCd();
			
			SceCopHdrVO sceCopHdrVO = new SceCopHdrVO();
			
			ObjectCloner.build(prdProdCtlMstVO, sceCopHdrVO);
			
			sceCopHdrVO.setCopNo(cop_no);
			sceCopHdrVO.setPctlNo(pctl_no);
			sceCopHdrVO.setBkgNo(bkg_no);
			
			if (prdBkgCopMapVO.getCntrTpszCd().startsWith("Q")) {
				sceCopHdrVO.setCopStsCd("X");	
			}
		
			
			String copRailChkCd = dbDao.searchCopRailChk(pctl_no);
			sceCopHdrVO.setCopRailChkCd(copRailChkCd);
			
			if (cntr_tpsz_cd != null && !cntr_tpsz_cd.equals("")) {
				if (prdBkgCopMapVO.getCntrTpszCd().startsWith("Q")) {
					sceCopHdrVO.setCntrTpszCd(prdBkgCopMapVO.getCntrTpszCd());
					sceCopHdrVO.setCopStsCd("X");	
				} else {
					sceCopHdrVO.setCntrTpszCd(cntr_tpsz_cd);	
				}
			} 
			
			// pc no change when trying to replan skip without
			SceCopHdrVO crntCopHdr = dbDao.searchCopHdr(prdBkgCopMapVO.getCopNo());
//			if (prdBkgCopMapVO.getPctlNo().equals(crntCopHdr.getPctlNo())) {
			
//			if (dbDao.comparePcCtnt(prdBkgCopMapVO.getPctlNo(), crntCopHdr.getPctlNo())) {
//				SceCopHdrVO tmpVO = new SceCopHdrVO();
//				tmpVO.setCopUpdRmk("SameRoute:Rpln SKIP> " + prdBkgCopMapVO.getCopMapgSeq());
//				tmpVO.setCopNo(crntCopHdr.getCopNo());
//				toBeUpdtHdrList.add(tmpVO);
//				
//				dbDao.modifyCopHdr(toBeUpdtHdrList);
//				return;
//			}
			
			String asisVVD = crntCopHdr.getTrnkVslCd() + crntCopHdr.getTrnkSkdVoyNo() + 
						crntCopHdr.getTrnkSkdDirCd();
			
			sceCopHdrVO.setCopUpdRmk("UpdBkg:ByPrdMap:" + prdBkgCopMapVO.getPctlNo() +"/cop_mapg_seq:" + prdBkgCopMapVO.getCopMapgSeq());
			
			toBeUpdtHdrList.add(sceCopHdrVO);
			dbDao.modifyCopHdr(toBeUpdtHdrList, cop_no);
			
			// 2. SCE_PLN_SO_LIST creation
			// Brings the newly created SCE_PLN_SO_LIST.
			List<ScePlnSoListVO> toBePlnSoList = dbDao.searchPlnSoListToBeInserted(sceCopHdrVO);
			
			// Brings existing SCE_PLN_SO_LIST.
			List<ScePlnSoListVO> crntPlnSoList = dbDao.searchPlnSoListByCop(cop_no);
			
			List<ScePlnSoListVO> toBeInsertedVO = new ArrayList<ScePlnSoListVO> ();
			
			// TRSP_SO_STS_CD, CTRL_OFC_CD maintain its current value
			for (int i = 0 ; i < toBePlnSoList.size(); i ++) {
				ScePlnSoListVO toBeRowVO = toBePlnSoList.get(i);
				for (int j = 0 ; j < crntPlnSoList.size(); j ++) {
					ScePlnSoListVO crntRowVO = crntPlnSoList.get(j);
					if (crntRowVO.getCostActGrpSeq().equals(toBeRowVO.getCostActGrpSeq()) && crntRowVO.getCopNo().equals(toBeRowVO.getCopNo())) {
						// SO occurred after the COP so status changes for the cost_act_grp_seq
						if (crntRowVO.getTrspSoStsCd() != null && !crntRowVO.getTrspSoStsCd().equals("") && !crntRowVO.getTrspSoStsCd().equals("P"))						
							toBeRowVO.setTrspSoStsCd (crntRowVO.getTrspSoStsCd());
					}
				}
				toBeInsertedVO.add(toBeRowVO);
			}
			
			dbDao.removeSoList(cop_no);
			
			if (toBeInsertedVO.size() != 0)
				dbDao.addPlnSoList(toBeInsertedVO);
			
			// 3. SCE_COP_DTL Created
			// Brings existing  SCE_COP_DTL .
			List<SceCopDtlVO> crntDtlList = dbDao.searchCopDtl(sceCopHdrVO);
			
			List<SceCopDtlVO> toBeDtlList = dbDao.searchCopDtlToBeInserted(sceCopHdrVO);
			
			List<SceCopDtlVO> toBeInsertedDtlVO = new ArrayList<SceCopDtlVO> ();
			
			for (int i = 0; i < toBeDtlList.size(); i ++) {
				SceCopDtlVO toBeRowVO = toBeDtlList.get(i);
				for (int j = 0 ; j < crntDtlList.size(); j ++) {
					SceCopDtlVO crntRowVO = crntDtlList.get(j);
					if (crntRowVO.getActCd().equals(toBeRowVO.getActCd()) && crntRowVO.getNodCd().equals(toBeRowVO.getNodCd()) && !crntRowVO.getActDt().equals("") ) {
						toBeRowVO.setVndrSeq(crntRowVO.getVndrSeq());
						toBeRowVO.setEdiMsgTpCd(crntRowVO.getEdiMsgTpCd());
						toBeRowVO.setEdiActSndDt(crntRowVO.getEdiActSndDt());
						toBeRowVO.setEdiSndTpCd(crntRowVO.getEdiSndTpCd());
						toBeRowVO.setStndEdiStsCd(crntRowVO.getStndEdiStsCd());
						
					} else {
						if (i == 0) {
							toBeRowVO.setActStsCd("C");
						}
							
					}
				}
				toBeInsertedDtlVO.add(toBeRowVO);
			}
			
			dbDao.removeCopDtl(cop_no);
			int copDtlCnt = dbDao.addCopDtl(toBeInsertedDtlVO);
			
			if (copDtlCnt != 0 && !crntCopHdr.getCntrNo().equals(SCEConstants.PSEUDO_CNTR_NO)) {
				List<SceActRcvIfVO> actualList = dbDao.searchActualToBeUpdated(cop_no);
				for (int i = 0; i < actualList.size(); i ++) {
					SceActRcvIfVO actVO = actualList.get(i);
					copDetailReceiveBC.copDetailReceiveREPLAN(actVO);
				}				
				
				List<SearchExptTgtVO> exptTgtList = dbUtilDao.searchExptTgt(cop_no);
				
				for (int i = 0; i < exptTgtList.size(); i ++) {
					SearchExptTgtVO rowVO = exptTgtList.get(i);
					dbUtilDao.callSceExcetionResistActPrc(rowVO.getCopNo(), rowVO.getCopDtlSeq(), rowVO.getActDt(), "exptBR", "Y");
				}
			}

			
			if (!asisVVD.equals(tobeVVD) && !crntCopHdr.getCntrNo().equals(SCEConstants.PSEUDO_CNTR_NO)) { // VVD is different from cleanup operations, the master
				arrangeMstCopNo(crntCopHdr.getBkgNo(), crntCopHdr.getCntrNo(), crntCopHdr.getCopNo());
			}
			
			dbUtilDao.addSceCopHistory(cop_no, "BR", "sysbkg", "sysbkg", "Y");
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * @param singleTransportationVO
	 * @return ReplanResultVO
	 * @throws EventException
	 * @see com.clt.apps.opus.esd.sce.replanmanage.replanmanage.basic.ReplanManageBC#replanCop(com.clt.apps.opus.esd.trs.cydoorsomanage.singletransportationsomanage.vo.SingleTransportationVO)
	 */
	public ReplanResultVO replanCop (SingleTransportationVO singleTransportationVO) throws EventException {
		ReplanResultVO rsltVO = replanCop (singleTransportationVO.getColumnValues());
		return rsltVO;
	}
	
	/**
	 * @param trsTrspRailBilOrdVO
	 * @return ReplanResultVO
	 * @throws EventException
	 * @see com.clt.apps.opus.esd.sce.replanmanage.replanmanage.basic.ReplanManageBC#replanCop(com.clt.syscommon.common.table.TrsTrspRailBilOrdVO)
	 */
	public ReplanResultVO replanCop (TrsTrspRailBilOrdVO trsTrspRailBilOrdVO) throws EventException {
		ReplanResultVO rsltVO = replanCop (trsTrspRailBilOrdVO.getColumnValues());
		return rsltVO;
	}
	
	/**
	 * @param trsTrspSvcOrdVO
	 * @return ReplanResultVO
	 * @throws EventException
	 * @see com.clt.apps.opus.esd.sce.replanmanage.replanmanage.basic.ReplanManageBC#replanCop(com.clt.syscommon.common.table.TrsTrspSvcOrdVO)
	 */
	public ReplanResultVO replanCop (TrsTrspSvcOrdVO trsTrspSvcOrdVO) throws EventException {
		ReplanResultVO rsltVO = replanCop (trsTrspSvcOrdVO.getColumnValues());
		return rsltVO;
	}
	
	/**
	 * @param trsTrspEdiRailOrdVO
	 * @return ReplanResultVO
	 * @throws EventException
	 * @see com.clt.apps.opus.esd.sce.replanmanage.replanmanage.basic.ReplanManageBC#replanCop(com.clt.syscommon.common.table.TrsTrspEdiRailOrdVO)
	 */
	public ReplanResultVO replanCop (TrsTrspEdiRailOrdVO trsTrspEdiRailOrdVO) throws EventException {
		ReplanResultVO rsltVO = replanCop (trsTrspEdiRailOrdVO.getColumnValues());
		return rsltVO;
	}
	
	/**
	 * @param sceCopHdrVO
	 * @param account
	 * @throws EventException
	 * @see com.clt.apps.opus.esd.sce.replanmanage.replanmanage.basic.ReplanManageBC#replanCopInclPrt(com.clt.syscommon.common.table.SceCopHdrVO)
	 */
	public void replanCopInclPrt(SceCopHdrVO sceCopHdrVO, SignOnUserAccount account) throws EventException {
		try {
			String bkg_no = sceCopHdrVO.getBkgNo();
			String cntr_no = sceCopHdrVO.getCntrNo();
			String pctl_no = sceCopHdrVO.getPctlNo();
			
			List<SceCopHdrVO> partialList = new ArrayList<SceCopHdrVO> ();
			
			if (sceCopHdrVO.getCopStsCd().equals("F") || (cntr_no == null || cntr_no.equals("") || cntr_no.equals(SCEConstants.PSEUDO_CNTR_NO))) {
				partialList.add(sceCopHdrVO);
			} else {
				partialList = dbDao.searchPartialCops(bkg_no, cntr_no, "C");
			}
			
			if (partialList.size() == 0) {
				log.error("No data found in Search COP!!!");
				return;
			}
			
			String tmpOfcCd = "";
			String tmpUsrId = "";
			if(null != account){
				tmpOfcCd = StringUtils.isEmpty(account.getOfc_cd()) ? "SysMan" : account.getOfc_cd();
				tmpUsrId = StringUtils.isEmpty(account.getUsr_id()) ? "SysMan" : account.getUsr_id();
			}else{
				tmpOfcCd = "SysMan";
				tmpUsrId = "SysMan";
			}
					
			
			for (int i = 0; i < partialList.size(); i ++) {
				// replan invokes pc no return
				SceCopHdrVO rowVO = partialList.get(i);
				rowVO.setPctlNo(pctl_no);
				replanCop(rowVO, "CopInclPrt");
				
				dbUtilDao.addSceCopHistory(rowVO.getCopNo(), "MC", tmpOfcCd, tmpUsrId, "Y");
				
				//COA I/F
				CostAssignBC coaCommand = new CostAssignBCImpl();
				CoaBkgComIfVO coaBkgComIfVo = new CoaBkgComIfVO();

				coaBkgComIfVo.setBkgNo(bkg_no);
				coaBkgComIfVo.setCostSrcSysCd("SCE"); //TRS, TES, SCE, BKG등 SUB SYSTEM CODE
				coaBkgComIfVo.setIfRmk("COP Change"); 
				coaBkgComIfVo.setCreUsrId("SceMan");
				coaBkgComIfVo.setUpdUsrId("SceMan");

				int result_cnt = coaCommand.modifyCoaCommonInterface(coaBkgComIfVo);

				if (result_cnt < 0)
					throw new EventException((new ErrorHandler("TRS00099",new String[]{"COA I/F Error"})).getMessage());
			}
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
	/**
	 * @param singleTransportationVO
	 * @return int
	 * @throws EventException
	 * @see com.clt.apps.opus.esd.sce.replanmanage.replanmanage.basic.ReplanManageBC#modifySoList(com.clt.apps.opus.esd.trs.cydoorsomanage.singletransportationsomanage.vo.SingleTransportationVO)
	 */
	public int modifySoList (SingleTransportationVO singleTransportationVO) throws EventException {
		ScePlnSoListVO scePlnSoListVO = new ScePlnSoListVO();		
		ObjectCloner.build(singleTransportationVO, scePlnSoListVO);
		
		int cnt = 0;
		
		try {
			cnt = modifySoList(scePlnSoListVO, singleTransportationVO.getTrspBndCd(), singleTransportationVO.getTrspSoOfcCtyCd(), singleTransportationVO.getTrspSoSeq());
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
		return cnt;
	}
	
	/**
	 * @param trsTrspRailBilOrdVO
	 * @return int
	 * @throws EventException
	 * @see com.clt.apps.opus.esd.sce.replanmanage.replanmanage.basic.ReplanManageBC#modifySoList(com.clt.syscommon.common.table.TrsTrspRailBilOrdVO)
	 */
	public int modifySoList (TrsTrspRailBilOrdVO trsTrspRailBilOrdVO) throws EventException {
		ScePlnSoListVO scePlnSoListVO = new ScePlnSoListVO();		
		ObjectCloner.build(trsTrspRailBilOrdVO, scePlnSoListVO);
		
		int cnt = 0;
		
		try {
			cnt = modifySoList(scePlnSoListVO, trsTrspRailBilOrdVO.getTrspBndCd(), trsTrspRailBilOrdVO.getTrspSoOfcCtyCd(), trsTrspRailBilOrdVO.getTrspSoSeq());
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
		return cnt;
	}
	
	/**
	 * @param trsTrspEdiRailOrdVO
	 * @return int
	 * @throws EventException
	 * @see com.clt.apps.opus.esd.sce.replanmanage.replanmanage.basic.ReplanManageBC#modifySoList(com.clt.syscommon.common.table.TrsTrspEdiRailOrdVO)
	 */
	public int modifySoList (TrsTrspEdiRailOrdVO trsTrspEdiRailOrdVO) throws EventException {
		ScePlnSoListVO scePlnSoListVO = new ScePlnSoListVO();		
		ObjectCloner.build(trsTrspEdiRailOrdVO, scePlnSoListVO);
		
		int cnt = 0;
		
		try {
			cnt = modifySoList(scePlnSoListVO, "", trsTrspEdiRailOrdVO.getTrspSoOfcCtyCd(), trsTrspEdiRailOrdVO.getTrspSoSeq());
			
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
		return cnt;
	}
	
	/**
	 * @param scePlnSoListVO
	 * @param trsp_bnd_cd
	 * @param trspSoOfcCtyCd
	 * @param trspSoSeq
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	private int modifySoList (ScePlnSoListVO scePlnSoListVO, String trsp_bnd_cd, String trspSoOfcCtyCd, String trspSoSeq) throws DAOException, Exception {
		int cnt = 0;
		
		try {
			cnt = dbDao.modifyPlnSoList(scePlnSoListVO);
			
			SceCopHdrVO sceCopHdrVO = new SceCopHdrVO();
			if (cnt > 0) {
				if (scePlnSoListVO.getTrspSoStsCd() != null && scePlnSoListVO.getTrspSoStsCd().equals(SCEConstants.SO_CREATION)) {
					dbUtilDao.addSceCopHistory(scePlnSoListVO.getCopNo(), "S" + trsp_bnd_cd, "SysSo", "GenS/O", "Y");	
					sceCopHdrVO.setCopNo(scePlnSoListVO.getCopNo());
					sceCopHdrVO.setCopUpdRmk("SOcrt>" + trspSoOfcCtyCd + " " + trspSoSeq+"/grpSeq=" + scePlnSoListVO.getCostActGrpSeq());
				} else if (scePlnSoListVO.getTrspSoStsCd() != null && scePlnSoListVO.getTrspSoStsCd().equals(SCEConstants.SO_CANDIDATE_DELETED)) {
					sceCopHdrVO.setCopNo(scePlnSoListVO.getCopNo());
					sceCopHdrVO.setCopUpdRmk("CandidateDeleted>" + trspSoOfcCtyCd + " " + trspSoSeq+"/grpSeq=" + scePlnSoListVO.getCostActGrpSeq() + " / by " + scePlnSoListVO.getUpdUsrId());
				} else {
					sceCopHdrVO.setCopNo(scePlnSoListVO.getCopNo());
					sceCopHdrVO.setCopUpdRmk("PlnSoChg>" + trspSoOfcCtyCd + " " + trspSoSeq + "/soSts=" + scePlnSoListVO.getTrspSoStsCd()+"/grpSeq="+scePlnSoListVO.getCostActGrpSeq());
				}
			} else {
				sceCopHdrVO.setCopNo(scePlnSoListVO.getCopNo());
				sceCopHdrVO.setCopUpdRmk("PlnSoChg>" + trspSoOfcCtyCd + " " + trspSoSeq + "/soSts=" + scePlnSoListVO.getTrspSoStsCd()+"/grpSeq="+scePlnSoListVO.getCostActGrpSeq());
			}
			dbDao.modifyCopHdr(sceCopHdrVO);
				
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		}
		
		return cnt;
	}
	

	
	/**
	 * @param sceCopHdrVO
	 * @return int
	 * @throws EventException
	 * @see com.clt.apps.opus.esd.sce.replanmanage.replanmanage.basic.ReplanManageBC#modifyProvCntrByWRS(com.clt.syscommon.common.table.SceCopHdrVO)
	 */
	public int modifyProvCntrByWRS (SceCopHdrVO sceCopHdrVO) throws EventException {
		int cnt = 0;
		
		try {
			cnt = dbDao.modifyProvCntrByWRS(sceCopHdrVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
		return cnt;
	}
	
	/**
	 * S / O logic by running the replan for the case
	 * @param srcMap
	 * @return ReplanResultVO
	 * @throws EventException
	 */
	private ReplanResultVO replanCop (Map<String, String> srcMap) throws EventException {
		// COP 별로 replan 을 수행
		// so 가 생성 되었다면 해당 SO No 를 가지고 어떤 PC 를 생성 가능한지를 판단하고 PC 를 호출 해야 한다.
		
		// PC 없이 수행 가능한 업무와 PC 가 존재해야 하는 업무를 판단할 필요 있음
		// route 가 변경되었는지에 대한 확인이 필요... 가능한가???
		// unplanned S/O 의 case
		log.debug("========함수 호출====");
		ReplanResultVO rsltVO = new ReplanResultVO();
		rsltVO.setFmNodCd(srcMap.get("fm_nod_cd"));
		rsltVO.setToNodCd(srcMap.get("to_nod_cd"));
		rsltVO.setTrspSoOfcCtyCd(srcMap.get("trsp_so_ofc_cty_cd"));
		rsltVO.setTrspSoSeq(srcMap.get("trsp_so_seq"));
		rsltVO.setRplnRsltFlg("Y");
		rsltVO.setUmchFlg("N");
		rsltVO.setUpdRmk("");
		
		/** 
		 * TRS 로 부터 필수로 받아야 하는 항목
		 */
		String cop_no = srcMap.get("cop_no");
		String cntr_no = srcMap.get("eq_no");
		String bkg_no = srcMap.get("bkg_no");
		String trsp_bnd_cd = srcMap.get("trsp_bnd_cd");
		String act_grp_cd = srcMap.get("act_grp_cd");
		String usRailUnplaned  = null;
		if(srcMap.containsKey("upln_so_flg")) {
			usRailUnplaned = srcMap.get("upln_so_flg");
		}
		int partialCnt = 0;
		
		if (cop_no == null || cop_no.equals(""))
			throw new EventException("No Data : Cop No");

		if (bkg_no == null || bkg_no.equals(""))
			throw new EventException("No Data : Booking No");
		
		if (trsp_bnd_cd == null || trsp_bnd_cd.equals(""))
			throw new EventException("No Data : trsp_bnd_cd");
		
		if (act_grp_cd == null || act_grp_cd.equals(""))
			throw new EventException("No Data : act_grp_cd");
		
		try {

//			List<SceCopHdrVO> partialList = new ArrayList<SceCopHdrVO> (); 
			
			SceCopHdrVO sceCopHdrVO = dbDao.searchCopHdr(cop_no);

//			partialList = dbDao.searchPartialCops(bkg_no, cntr_no, "C");
			
			if (sceCopHdrVO == null){
				log.error("No data found in Search COP!!!");
				rsltVO.setCopNo("");
				rsltVO.setCostActGrpSeq("");
				rsltVO.setRplnRsltFlg("N");
				rsltVO.setUpdRmk("No data found in Search COP!!!");			
				return rsltVO;
			}else{
				// replan 호출하여 pc no return
				SceCopHdrVO rowVO = sceCopHdrVO;
				//log.debug("************* ReplanManageBackEndJob createSceSoReplan ***************");	
				//2015.04.21 Add.
				String pctl_no = "";
                try {
                	pctl_no = prdBC.createSceSoReplan(rowVO.getCopNo(), trsp_bnd_cd, "REP_SO"); // PC 호출 필요!
                } catch(Exception ex ) {
                    log.error("err " + ex.toString(), ex);
                }
                //2015.04.21 Modify
				//String pctl_no = prdBC.createSceSoReplan(rowVO.getCopNo(), trsp_bnd_cd, "REP_SO"); // PC 호출 필요!
				//log.debug("************* ReplanManageBackEndJob pctl_no="+pctl_no);			
				if (pctl_no != null && !pctl_no.equals("")) { //생성된 pctl_no 로 replan 시작
										
					// partial건중 slave 건에 대해서는 back-end-job으로 실행한다.
					partialCnt = dbDao.searchPartialCopsCount(bkg_no, cntr_no, "C");
//					log.debug("************* ReplanManageBackEndJob doStart partialCnt="+partialCnt+"***************");
					rowVO.setPctlNo(pctl_no);					
					boolean replanResult = replanCop(rowVO, "SoRpln[so#:" + rsltVO.getTrspSoOfcCtyCd()+rsltVO.getTrspSoSeq()+"]");
					
					ScePlnSoListVO tmp = new ScePlnSoListVO();
					tmp.setCopNo(srcMap.get("cop_no"));
					tmp.setCostActGrpSeq(srcMap.get("cost_act_grp_seq"));

					tmp.setTrspSoStsCd(srcMap.get("trsp_so_sts_cd"));
					dbDao.modifyPlnSoList(tmp);
//					log.debug("************* ReplanManageBackEndJob replanResult="+replanResult);			
					if (replanResult) {
						rsltVO.setUpdRmk("Replan succeeded!!");
						dbUtilDao.addSceCopHistory(rowVO.getCopNo(), "S" + trsp_bnd_cd, "SysSo", "SysSo", "Y");
						rsltVO.setUmchFlg("");
						// correction시 unmatch건이 match될수도 있으므로 null값으로 변경하도록 기능 추가
						dbDao.modifySvcOrdUmchFlg(rsltVO);
						
//						log.debug("************* ReplanManageBackEndJob doStart partialCnt="+partialCnt+"***************");
						if(partialCnt>1){
							ReplanManageBackEndJobBCImpl backEndJobCommand = new ReplanManageBackEndJobBCImpl(pctl_no, bkg_no, cntr_no);
							backEndJobCommand.doStart();
//							log.debug("************* ReplanManageBackEndJob doStart ***************");
						}
					}else{
						//replan 이 fail 난 경우
						rsltVO.setRplnRsltFlg("N");
						rsltVO.setUpdRmk("master cop replan fail");
					}
					
					
				} else { // unmatch case 로 so replan 불가함
					if (rowVO.getCopNo().equals(srcMap.get("cop_no"))) {
						// sce_COP_HDR 의 UMCH_STS_CD 를 set 한다.(Y)
						rowVO.setUmchStsCd("Y");
						rowVO.setCopUpdRmk("UmchSO:GrpSeq=" + srcMap.get("cost_act_grp_seq") + "/soOfc=" + rsltVO.getTrspSoOfcCtyCd() + "/soSeq=" + rsltVO.getTrspSoSeq());
						if(!("USRAIL_UNPLAN".equals(usRailUnplaned))) {
							dbDao.modifyCopHdr(rowVO);
						}
						
						rsltVO.setRplnRsltFlg("N");
						rsltVO.setUmchFlg("Y");
						rsltVO.setUpdRmk("Unmatch case occurred!!");
						
						// PRD 에서 BKG Replan 시 Unmatch 된 S/O 는 route 생성에 포함시키지 않게 rpln_umch_flg 를 S/O table 에 관리한다.
						dbDao.modifySvcOrdUmchFlg(rsltVO);
						
						if(!("USRAIL_UNPLAN".equals(usRailUnplaned))) {
						// Planned 가 아닌 status 를 cop 에 가지고있고 해당 cop_no, cost_act_grp_seq 로 생성된 s/o 가 unmatch 인 경우 cop 의 status 를 P 로 환원
//						if (srcMap.get("trsp_so_sts_cd") != null && srcMap.get("trsp_so_sts_cd").equals(SCEConstants.SO_CORRECTED)) {
							dbDao.modifySoStsPlnByUmchSo(srcMap.get("cop_no"), srcMap.get("cost_act_grp_seq") );	
//						}
						
						// unmatch된 case 이더라도 cost_act_grp_seq, cop_no 에 해당 하는 row 에 대한 update 를 시도한다.
						// 2010.04.11 현업과의 협의를 통해 unmatch S/O 건에 대해서는 status 를 관리하지 않는다.
							dbUtilDao.addSceCopHistory(rowVO.getCopNo(), "UM", "sysbkg","sysbkg","N");	
						}

						rsltVO.setRplnRsltFlg("N");
						rsltVO.setUmchFlg("Y");
						rsltVO.setUpdRmk("Unmatch case occurred!!");
						
						// PRD 에서 BKG Replan 시 Unmatch 된 S/O 는 route 생성에 포함시키지 않게 rpln_umch_flg 를 S/O table 에 관리한다.
						dbDao.modifySvcOrdUmchFlg(rsltVO);
					}
				}

			}
			
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
		return rsltVO;
	}
	
	
	/**
	 * Master flag to clean up
	 * 1. container detach will detach when the target was the master booking.
	 * 2. when the container attach partial relationship was established.
	 * 3. When booking split partial relationship was established.
	 * 4. When booking combine combine container that has become the target of booking if there is no relationship between the partial 
	 * 	(There may be a new relationship is split.)
	 * 5. booking 이 cancel 될 대상이 master
	 * 
	 *
	 * Note :For partial booking the event ended determine whether the COP should be targeted.
	 * 
	 * vvd is changed, the change event to change the master is passed to COP-related things, but those that must not re-organize the
	 * @param bkg_no
	 * @param cntr_no
	 * @param cop_no 
	 * @return String
	 * @exception EventException
	 */
	public String arrangeMstCopNo(String bkg_no, String cntr_no, String cop_no) throws EventException {
		// TODO Auto-generated method stub
		
		try {
			if (cntr_no.equals(SCEConstants.PSEUDO_CNTR_NO))
				return "";
			
//			String invokeCopNo = "";
			SceCopHdrVO tmpCop = dbDao.searchCopHdr(cop_no);
			String sts_flg = "C";
			
			if (tmpCop != null && tmpCop.getCopStsCd().equals("X"))
				sts_flg = "X";
			
			List<SceCopHdrVO> sceCopHdrVOs = dbDao.searchPartialCops(bkg_no, cntr_no, sts_flg); // C, T status of the COP to target ten thousand Partial exist beyond the termination of booking event whether and judgment.
			
			String toBeMstCopNo = "";
			
			List<String> copNoList = new ArrayList<String>();
			
			Set<String> mstCopNoSet = new HashSet<String>();
			
			ListIterator<SceCopHdrVO> listItr = sceCopHdrVOs.listIterator();
			while (listItr.hasNext()) {
				SceCopHdrVO sceCopHdrVO = listItr.next();
				copNoList.add(sceCopHdrVO.getCopNo());
				mstCopNoSet.add(sceCopHdrVO.getMstCopNo());
			}
			
			if (sceCopHdrVOs != null && sceCopHdrVOs.size() >= 2) { 
				List<SceCopHdrVO> sceCopHdrVOsClone = new ArrayList<SceCopHdrVO> ();
				Collections.copy(sceCopHdrVOs, sceCopHdrVOsClone); 
				
				List<SceCopHdrVO> updateSceCopHdrVOs = null;
				
				
				
				if (mstCopNoSet.size() != 1 || !copNoList.contains(mstCopNoSet)) {
					toBeMstCopNo = chooseToBeMstCopNo(sceCopHdrVOsClone);
					
					// SO, TRO, actual shipping if I can not confirm a case-by-catches the first COP.
					if (toBeMstCopNo.equals("")) {
						// If there is his own master that other cop no you invoke this method that will change the cop's mst_cop_no.
						if (mstCopNoSet.size() == 2) {
							mstCopNoSet.remove(cop_no);
							toBeMstCopNo = (String) mstCopNoSet.toArray()[0];
						} else {
							toBeMstCopNo = copNoList.get(0);
						}
					}
					// master cop change.
					if (!toBeMstCopNo.equals("")) {
						updateSceCopHdrVOs = new ArrayList<SceCopHdrVO> ();
						for (int i = 0; i < copNoList.size(); i ++) {
							SceCopHdrVO rowVO = new SceCopHdrVO();
							rowVO.setCopNo(copNoList.get(i));
							rowVO.setMstCopNo(toBeMstCopNo);
							
							updateSceCopHdrVOs.add(rowVO);
						}
						dbDao.modifyCopHdr(updateSceCopHdrVOs, cop_no);
						
						// That were issued in the past COP NO S / O No Change to the new cop no.
						TrsTrspSvcOrdVO trsTrspSvcOrdVO = new TrsTrspSvcOrdVO();
						TrsTrspRailBilOrdVO trsTrspRailBilOrdVO = new TrsTrspRailBilOrdVO();
						
						for (int i = 0; i < copNoList.size(); i ++) {
							if (!copNoList.get(i).equals(toBeMstCopNo)) {
								// cost_act_grp_seq No chaange.
								// If a different cop no and mst_cop_no mst_cop_no each s / o changing the cop_no.
								trsTrspSvcOrdVO.setCopNo(copNoList.get(i));
								trsTrspRailBilOrdVO.setCopNo(copNoList.get(i));
								dbDao.modifySvcOrdByCop(toBeMstCopNo, trsTrspSvcOrdVO);
								dbDao.modifyRailBilOrdByCop(toBeMstCopNo, trsTrspRailBilOrdVO);
							}
						}
					} else {
						// master cop no Allocation error
					}
				} 
				if (cop_no.equals(toBeMstCopNo)) { // When the master cop no change
					 // Although there was the master himself here with his master cop of the cop again, another master cop no need to do is update selecting.
					
					List <SceCopHdrVO> cops = dbDao.searchCopHdrByMstCopNoExptItself(cop_no, copNoList);
					if (cops.size() != 0) {
						toBeMstCopNo = chooseToBeMstCopNo(cops);
						
						// SO, TO, actual shipping if I can not confirm a case-by-catches the first COP.
						if (toBeMstCopNo.equals("")) {
								toBeMstCopNo = (cops.get(0)).getCopNo();
						}	
						List<SceCopHdrVO> tmpList = new ArrayList<SceCopHdrVO> ();
						for (int i = 0; i < cops.size(); i ++) {
							
							SceCopHdrVO tmp = cops.get(i);
							SceCopHdrVO rowVO = new SceCopHdrVO();
							rowVO.setCopNo(tmp.getCopNo());
							rowVO.setMstCopNo(toBeMstCopNo);
							tmpList.add(rowVO);
						}	
						dbDao.modifyCopHdr(tmpList, cop_no);
					}
				}
				
			} else if (null != sceCopHdrVOs && sceCopHdrVOs.size() == 1) { // Partial relationship does not exist or partial master, but when the cancel?
				// mst_cop_no 를 cop_no 로 update .
				SceCopHdrVO sceCopHdrVO = sceCopHdrVOs.get(0);
				if (   
						(sceCopHdrVO.getMstCopNo() == null || sceCopHdrVO.getMstCopNo().equals("")) ||
						!sceCopHdrVO.getCopNo().equals(sceCopHdrVO.getMstCopNo())		
				) {
					sceCopHdrVO.setMstCopNo(sceCopHdrVO.getCopNo());
					List<SceCopHdrVO> toBeUpdVO = new ArrayList<SceCopHdrVO>();
					toBeUpdVO.add(sceCopHdrVO);
					dbDao.modifyCopHdr(toBeUpdVO, cop_no);
				} 
				
				if (sceCopHdrVOs != null && sceCopHdrVOs.size() == 1) {
					SceCopHdrVO tmpVO = sceCopHdrVOs.get(0);
					if ((tmpVO.getMstCopNo() == null || tmpVO.getMstCopNo().equals("")) ||
					 (!tmpVO.getCopNo().equals(tmpVO.getMstCopNo())) 		
					) {
						SceCopHdrVO tmp = new SceCopHdrVO();
						tmp.setCopNo(tmpVO.getCopNo());
						tmp.setMstCopNo(tmpVO.getCopNo());
						
						List<SceCopHdrVO> toBeUpdVO = new ArrayList<SceCopHdrVO>();
						toBeUpdVO.add(tmp);
						dbDao.modifyCopHdr(toBeUpdVO, cop_no);
					} else if ((tmpVO.getMstCopNo() != null && !tmpVO.getMstCopNo().equals("")) &&
					 (tmpVO.getCopNo().equals(tmpVO.getMstCopNo())) 		
					) { 
						
						List <SceCopHdrVO> cops = dbDao.searchCopHdrByMstCopNoExptItself(tmpVO.getCopNo(), copNoList);
						if (cops.size() != 0) {
							toBeMstCopNo = chooseToBeMstCopNo(cops);
							
							// SO, TO, actual shipping if I can not confirm a case-by-catches the first COP.
							if (toBeMstCopNo.equals("")) {
									toBeMstCopNo = (cops.get(0)).getCopNo();
							}	
							List<SceCopHdrVO> tmpList = new ArrayList<SceCopHdrVO> ();
							for (int i = 0; i < cops.size(); i ++) {
								SceCopHdrVO tmp = cops.get(i);
								SceCopHdrVO rowVO = new SceCopHdrVO();
								rowVO.setCopNo(tmp.getCopNo());
								rowVO.setMstCopNo(toBeMstCopNo);
								tmpList.add(rowVO);
							}	
							dbDao.modifyCopHdr(tmpList, cop_no);
						}
						
					}
				}
			} 
			return toBeMstCopNo;
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * @param toBeMstCopNo
	 * @param sceCopHdrVOsClone
	 * @return
	 * @throws DAOException
	 */
	private String chooseToBeMstCopNo(List<SceCopHdrVO> sceCopHdrVOsClone) throws DAOException {
		/**
		 * mst cop no must not be managed properly or part of the newly generated partial
		 * Master target catch rule
		 *  1. Not by default, be released from master
		 *  2. attach the container
		 *  3. the presence of Confirm a TRO
		 *  4. COP has started shipping
		 *  5. S / O exists 
		 */
		String toBeMstCopNo = "";
		ListIterator<SceCopHdrVO> listItrClone = sceCopHdrVOsClone.listIterator();
		
		
		while (listItrClone.hasNext()) {
			SceCopHdrVO sceCopHdrVO = listItrClone.next();
			
			String copNo = sceCopHdrVO.getCopNo();
			String copStsCd = sceCopHdrVO.getCopStsCd();
			
			if (sceCopHdrVO.getCntrNo().equals(SCEConstants.PSEUDO_CNTR_NO)) {
				continue;
			}
			
			List<SearchSoByCopVO> soVO = dbDao.searchSoByCop(copNo);
			
			if (soVO != null && soVO.size() != 0) {
				toBeMstCopNo = copNo;
				break;
			}
			
			if ( 
					(sceCopHdrVO.getObTroFlg() != null && sceCopHdrVO.getObTroFlg().equals("Y")) ||
					(sceCopHdrVO.getIbTroFlg() != null && sceCopHdrVO.getIbTroFlg().equals("Y"))
			) {
				toBeMstCopNo = copNo;
				break;
			}
			
			if (copStsCd.equals("T")) {
				toBeMstCopNo = copNo;
				break;
			}
			
		}
		return toBeMstCopNo;
	}
	
	/**
	 * @param fm_cop_no 
	 * @param to_cop_no 
	 * @return int
	 * @throws EventException
	 */
	public int moveMstFlg(String fm_cop_no, String to_cop_no) throws EventException {
		SceCopHdrVO fmCopHdrVO = null;
		SceCopHdrVO toCopHdrVO = null;

		int rtnVal = SCEConstants.MST_ORDINARY;
		int updtVal = 0;

		try {
			fmCopHdrVO = dbDao.searchCopHdr(fm_cop_no);
			toCopHdrVO = dbDao.searchCopHdr(to_cop_no);
			
			String fm_cntr_no = fmCopHdrVO.getCntrNo();
			String fm_mst_cop_no = fmCopHdrVO.getMstCopNo();
			fm_mst_cop_no = (fm_mst_cop_no == null || fm_mst_cop_no.equals("")) ? fmCopHdrVO.getCopNo() :
				fm_mst_cop_no;
			
			String to_mst_cop_no = toCopHdrVO.getMstCopNo();
			to_mst_cop_no = (to_mst_cop_no == null || to_mst_cop_no.equals("")) ? toCopHdrVO.getCopNo() :
				to_mst_cop_no;
			
				
			List<SceCopHdrVO> sceCopHdrVOs = dbDao.searchPartialCops(fmCopHdrVO.getBkgNo(), fm_cntr_no, "C");
			ListIterator<SceCopHdrVO> listItr = sceCopHdrVOs.listIterator();
			
			while (listItr.hasNext()) {
				SceCopHdrVO rowVO = listItr.next();
				String rowMstCopNo = rowVO.getMstCopNo();
				
				rowMstCopNo = (rowMstCopNo == null || rowMstCopNo.equals("")) ? rowVO.getCopNo() : rowMstCopNo;
				
			}
			
			if (fm_cntr_no.equals(SCEConstants.PSEUDO_CNTR_NO))
				rtnVal = SCEConstants.MST_CNTR_NO_ERROR;

			if (rtnVal == SCEConstants.MST_ORDINARY) {
				updtVal = dbDao.moveMstFlg(fm_mst_cop_no, to_mst_cop_no, to_cop_no);
			}
			
			if (updtVal != 0)
				rtnVal = SCEConstants.MST_SUCCESS;
			else 
				rtnVal = SCEConstants.MST_FAIL;
			
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
		return rtnVal;
	}
	
	/**
	 * SCE_COP_HDR given in accordance with the terms of any other generation COP should perform the task of creating.
	 * Generated from SCE_COP_HDR all COP / actual mapping / edi is responsible for tasks such as retransmission.
	 * 
	 * Have been generated based on transit container to adjust if the master flag.
	 * 
	 * However, partial I replan for a case of this method to determine which should proceed from outside.
	 * 
	 * Usually proceeds with BkgCopManageDBDAO searchCopHdrToBeCreated method of.
	 * 
	 * @param List<SceCopHdrVO> sceCopHdrVOs
	 * @exception EventException
	 */
	public void createNewCop(List<SceCopHdrVO> sceCopHdrVOs) throws EventException {
		ListIterator<SceCopHdrVO> sceCopHdrVOItr = sceCopHdrVOs.listIterator();
		log.info("\n[poong] createNewCop start");
		while (sceCopHdrVOItr.hasNext()) {

			SceCopHdrVO sceCopHdrVO = sceCopHdrVOItr.next();
			
			if (sceCopHdrVO.getCntrTpszCd() != null && sceCopHdrVO.getCntrTpszCd().startsWith("Q")) {
				continue;
			}

			String pctl_no = sceCopHdrVO.getPctlNo() == null ? "" : sceCopHdrVO.getPctlNo();

			try {
				if (sceCopHdrVO.getPctlNo() == null || sceCopHdrVO.getPctlNo().equals("")) {

					pctl_no = dbDao.searchRepPctlNo(sceCopHdrVO.getBkgNo(), sceCopHdrVO.getCntrTpszCd());
					if (pctl_no == null || pctl_no.equals("")) {
						pctl_no = prdBC.createSceSoReplan(sceCopHdrVO.getCopNo(), "T", "CrtNewCop"); // 도는 경우는 없을 것 같다..
					}
				}
				if (pctl_no.equals("")) {
					// history 남기고 return
					return;
				}
				
				//rail 정보를 cop 별로 가져와서 cop header vo 에 set
				String copRailChkCd = dbDao.searchCopRailChk(sceCopHdrVO.getPctlNo());
				sceCopHdrVO.setCopRailChkCd(copRailChkCd);
								
				sceCopHdrVO.setObTroFlg("N");
				sceCopHdrVO.setIbTroFlg("N");
				sceCopHdrVO.setCopUpdRmk("CrtByRpln");
				
				dbDao.addCopHdrByCop(sceCopHdrVO);
				dbDao.addSoListByCop(sceCopHdrVO); // TODO 기 발행된 S/O 정보와 status 의 재 mapping 필요
				
				dbDao.addCopDtl(dbDao.searchCopDtlToBeInserted(sceCopHdrVO));

				// 대상 booking 으로 생성된 actual 을 입어오는 process 가 필요하다.
				
				// master slave 정리 필요 : container no 가 존재 할 경우
				String tobeCopNo = null;
				if (!sceCopHdrVO.getCntrNo().equals(SCEConstants.PSEUDO_CNTR_NO))
				    tobeCopNo = arrangeMstCopNo(sceCopHdrVO.getBkgNo(), sceCopHdrVO.getCntrNo(), sceCopHdrVO.getCopNo());
				log.info("\n[poong] tobeCopNo="+tobeCopNo+"/sceCopHdrVO.getCopNo()="+sceCopHdrVO.getCopNo()+"/cntr_no="+sceCopHdrVO.getCntrNo()+"/bkg_no="+sceCopHdrVO.getBkgNo());
				
				SceTroMapgVO sceTroMapg = null;
				
				sceTroMapg = dbDao.searchSceTroMapg(sceCopHdrVO.getCopNo());
				
				BkgCopManageBC          copBC      = new BkgCopManageBCImpl();
				if(sceTroMapg != null){
					copBC.confirmTro(sceCopHdrVO.getBkgNo(), sceTroMapg.getTroSeq(), sceTroMapg.getTroSubSeq(), "O", pctl_no, "X" ); 
				}
				
				
				// container number 가 존재할 경우
				// 생성 booking 에 대해서 split 이전 booking , combine 이전 원 booking 으로  sce_act_rcv_if 조회
				// 214 조회도 필요
				
//				List<SceActRcvIfVO> sceActRcvIfList = new ArrayList<SceActRcvIfVO> ();
				
//				List<SceCopHdrVO> bfSplitHdrList = dbDao.searchBfSplitCopInfo(sceCopHdrVO.getBkgNo(), sceCopHdrVO.getCntrNo());
				
//				List<SceCopHdrVO> bfCombineHdrList = dbDao.searchBfCombineCopInfo(sceCopHdrVO.getBkgNo(), sceCopHdrVO.getCntrNo());
/*				
				if (copDtlCnt != 0 && (!sceCopHdrVO.getCntrNo().equals("") && !sceCopHdrVO.getCntrNo().equals(SCEConstants.PSEUDO_CNTR_NO))) {
//					List<SceCopHdrVO> bfSplitList = dbDao.searchBfSplitCopInfo(sceCopHdrVO.getBkgNo(), sceCopHdrVO.getCntrNo());
					
					//split 이전 bkg_no 를 가져온다.
					List<BkgBookingVO> bfSplitList = dbDao.searchBfSplitBkgInfo(sceCopHdrVO.getBkgNo());
					
					// split 이전 booking 으로 접수된 actual 내역 접수
					for (int j = 0; j < bfSplitList.size(); j ++) {
						SceCopHdrVO tmpHdrVO = new SceCopHdrVO();// sce_act_rcv_if 에 insert 하기 위한 temp VO
						
						BkgBookingVO bfBkgVO = bfSplitList.get(j);

						tmpHdrVO.setBkgNo(sceCopHdrVO.getBkgNo());
						tmpHdrVO.setCopNo(sceCopHdrVO.getCopNo());
						tmpHdrVO.setCntrNo(sceCopHdrVO.getCntrNo());
						
						List<String> bkgList = new ArrayList<String> ();
						List<SceCopHdrVO> prtlList = dbDao.searchPartialCops(bfBkgVO.getBkgNo(), sceCopHdrVO.getCntrNo(), "C");
						
						if (prtlList.size() == 0) {
							bkgList.add(bfBkgVO.getBkgNo());
						} else {
							for (int k = 0; k < prtlList.size(); k ++) {
								SceCopHdrVO tmpHdrVOPrtl = prtlList.get(k);
								bkgList.add (tmpHdrVOPrtl.getBkgNo());
							}	
						}
						
						if (bkgList.size() > 0) 
							dbDao.addSceActRcvIfBySplit(tmpHdrVO, bkgList);
					}
					
//					List<BkgBookingVO> bfSplitList = dbDao.searchBfSplitBkgInfo(sceCopHdrVO.getBkgNo());
//					
//					// split 이전 booking 으로 접수된 actual 내역 접수
//					for (int j = 0; j < bfSplitList.size(); j ++) {
//						BkgBookingVO tmp = bfSplitList.get(j);
//						
//						List<SceCopHdrVO> prtlList = dbDao.searchPartialCops(tmp.getBkgNo(), tmp.getCntrNo(), "C");
//						List<String> bkgList = new ArrayList<String> ();
//						for (int k = 0; k < prtlList.size(); k ++) {
//							SceCopHdrVO tmpPrtl = prtlList.get(k);
//							bkgList.add (tmpPrtl.getBkgNo());
//						}
//						tmp.setBkgNo(sceCopHdrVO.getBkgNo());
//						tmp.setCopNo(sceCopHdrVO.getCopNo());
//						if (bkgList.size() > 0) 
//							dbDao.addSceActRcvIfBySplit(tmp, bkgList);
//					}
					
					List<BkgBookingVO> bfCombList = dbDao.searchBfCombineBkgInfo(sceCopHdrVO.getBkgNo());
					
					// combine 이전 booking 으로 접수된 actual 내역 접수
					for (int j = 0; j < bfCombList.size(); j ++) {
						SceCopHdrVO tmpHdrVO = new SceCopHdrVO();// sce_act_rcv_if 에 insert 하기 위한 temp VO
						
						BkgBookingVO bfBkgVO = bfCombList.get(j);

						tmpHdrVO.setBkgNo(sceCopHdrVO.getBkgNo());
						tmpHdrVO.setCopNo(sceCopHdrVO.getCopNo());
						tmpHdrVO.setCntrNo(sceCopHdrVO.getCntrNo());
						
						List<String> bkgList = new ArrayList<String> ();
						List<SceCopHdrVO> prtlList = dbDao.searchPartialCops(bfBkgVO.getBkgNo(), sceCopHdrVO.getCntrNo(), "C");
						
						if (prtlList.size() == 0) {
							bkgList.add(bfBkgVO.getBkgNo());
						} else {
							for (int k = 0; k < prtlList.size(); k ++) {
								SceCopHdrVO tmpHdrVOPrtl = prtlList.get(k);
								bkgList.add (tmpHdrVOPrtl.getBkgNo());
							}	
						}
						
						if (bkgList.size() > 0) 
							dbDao.addSceActRcvIfBySplit(tmpHdrVO, bkgList);
					}
					
					// partial booking 으로 접수된 actual 내역 접수
					List<SceCopHdrVO> prtlList = dbDao.searchPartialCops(sceCopHdrVO.getBkgNo(), sceCopHdrVO.getCntrNo(), "C");
					List<String> bkgList = new ArrayList<String> ();
					for (int j = 0; j < prtlList.size(); j++) {
						SceCopHdrVO tmpPrtl = prtlList.get(j);
						bkgList.add (tmpPrtl.getBkgNo());
					}
					if (bkgList.size() > 0)
						dbDao.addSceActRcvIfBySplit(sceCopHdrVO, bkgList);
					
				}
				
				*/
			} catch (DAOException ex) {
				log.error("err " + ex.toString(), ex);
				throw new EventException(new ErrorHandler(ex).getMessage());
			} catch (Exception ex) {
				log.error("err " + ex.toString(), ex);
				throw new EventException(new ErrorHandler(ex).getMessage());
			}
		}
	}
}