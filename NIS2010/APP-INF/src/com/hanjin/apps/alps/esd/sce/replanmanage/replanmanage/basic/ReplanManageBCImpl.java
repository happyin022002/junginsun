/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ReplanManageBCImpl.java
*@FileTitle : Replan 을 수행하는 공통 class 를 구동한다.
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.01
*@LastModifier : 김인수
*@LastVersion : 1.0
* 2009.09.01 김인수
* 1.0 Creation
* 2010.10.29 김진승 [소스품질 보완] arrangeMstCopNo 주석 보완   
* 2010.11.07 김영철 [] R4J 주석보완 ( replanCopInclPrt )
* 2012-05-15 채창호 [CHM-201217749-01]:CLM Data 수신시, RTR Report로 Mapping Logic 보완
=========================================================*/
package com.hanjin.apps.alps.esd.sce.replanmanage.replanmanage.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

import com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.basic.ProductCatalogCreateBC;
import com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.basic.ProductCatalogCreateBCImpl;
import com.hanjin.apps.alps.esd.sce.common.SCEConstants;
import com.hanjin.apps.alps.esd.sce.common.util.integration.CodeUtilDBDAO;
import com.hanjin.apps.alps.esd.sce.copdetailreceive.basic.CopDetailReceiveBC;
import com.hanjin.apps.alps.esd.sce.copdetailreceive.basic.CopDetailReceiveBCImpl;
import com.hanjin.apps.alps.esd.sce.copdetailreceive.vo.SceActRcvIfVO;
import com.hanjin.apps.alps.esd.sce.replanmanage.replanmanage.integration.ReplanManageDBDAO;
import com.hanjin.apps.alps.esd.sce.replanmanage.replanmanage.vo.ReplanResultVO;
import com.hanjin.apps.alps.esd.sce.replanmanage.replanmanage.vo.SearchSoByCopVO;
import com.hanjin.apps.alps.esd.trs.common.trscommon.basic.TrsCommonBCImpl;
import com.hanjin.apps.alps.esd.trs.cydoorsomanage.singletransportationsomanage.vo.SingleTransportationVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.object.ObjectCloner;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.BkgBookingVO;

import com.hanjin.syscommon.common.table.MasBkgComIfVO;
import com.hanjin.syscommon.common.table.PrdBkgCopMapVO;
import com.hanjin.syscommon.common.table.PrdProdCtlMstVO;
import com.hanjin.syscommon.common.table.SceCopDtlVO;
import com.hanjin.syscommon.common.table.SceCopHdrVO;
import com.hanjin.syscommon.common.table.ScePlnSoListVO;
import com.hanjin.syscommon.common.table.TrsTrspEdiRailOrdVO;
import com.hanjin.syscommon.common.table.TrsTrspRailBilOrdVO;
import com.hanjin.syscommon.common.table.TrsTrspSvcOrdVO;

/**
 * ALPS-ReplanManage Business Logic Command Interface<br>
 * - ALPS-ReplanManage에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Kim In-soo
 * @see BasicCommandSupport , ReplanManageBC 
 * @since J2EE 1.6
 */
public class ReplanManageBCImpl extends BasicCommandSupport implements ReplanManageBC {

	// Database Access Object
	private transient ReplanManageDBDAO dbDao = null;
	private transient ProductCatalogCreateBC prdBC = null;
	private transient CopDetailReceiveBC copDetailReceiveBC = null;
	
	private transient CodeUtilDBDAO dbUtilDao = null;

	/**
	 * ReplanManageBCImpl 객체 생성<br>
	 * ReplanManageDBDAO를 생성한다.<br>
	 */
	public ReplanManageBCImpl() {
		dbDao = new ReplanManageDBDAO();
		prdBC = new ProductCatalogCreateBCImpl();
		copDetailReceiveBC = new CopDetailReceiveBCImpl();
		
		dbUtilDao = new CodeUtilDBDAO();
	}
	
	/**
	 * COP 단위 replan 을 수행한다. 
	 * 
	 * Booking replan (updateBkg) 을 제외한 기본적인 replan 시의 모든 뼈대가 된다.
	 * SCE_COP_HDR 는 PRD_PROD_CTL_MST 의 정보를 바탕으로 update 하고
	 * SCE_PLN_SO_LIST, SCE_COP_DTL 은 삭제 후 재 생성하나 기존 정보 중 일부 data 는 유지해 준다. (ex> so status, edi 송신여부 등)
	 * 또한 기 입수된 actual date 정보를 재 수집하여 COP Detail 에 재 매핑하여 주며 이때 EDI 315 재 전송은 없다.
	 * 
	 * @param sceCopHdrVO
	 * @param cop_upd_rmk
	 * @return boolean
	 * @throws EventException
	 * @see com.hanjin.apps.alps.esd.sce.replanmanage.replanmanage.basic.ReplanManageBC#replanCop(com.hanjin.syscommon.common.table.SceCopHdrVO, java.lang.String)
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
			log.error("\n replanCop Log 1");
			dbDao.callPrdSetActDwTimePrc(pctl_no, "I", "N", "SYS");	
			log.error("\n replanCop Log 2");
			List<SceCopHdrVO> toBeUpdtHdrList = new ArrayList<SceCopHdrVO> ();
			List<PrdProdCtlMstVO> prdProdCtlMstList = dbDao.searchPrdMst(pctl_no);
			log.error("\n replanCop Log 3");
			if (prdProdCtlMstList.size() == 0) 
				return false;
			log.error("\n replanCop Log 4");
			PrdProdCtlMstVO prdProdCtlMstVO = prdProdCtlMstList.get(0);
			
			ObjectCloner.build(prdProdCtlMstVO, sceCopHdrVO);
			
			sceCopHdrVO.setCopNo(cop_no);
			sceCopHdrVO.setPctlNo(pctl_no);
			sceCopHdrVO.setBkgNo(bkg_no);
			
			String copRailChkCd = dbDao.searchCopRailChk(pctl_no);
			sceCopHdrVO.setCopRailChkCd(copRailChkCd);
			
			sceCopHdrVO.setCopUpdRmk("Rpln:" + cop_upd_rmk + ":" + pctl_no);
			log.error("\n replanCop Log 5");
			toBeUpdtHdrList.add(sceCopHdrVO);
			log.error("\n replanCop Log 6");
			hdrCnt = dbDao.modifyCopHdr(toBeUpdtHdrList);
			log.error("\n replanCop Log 7");
			// 2. SCE_PLN_SO_LIST 생성 작업
			// 새로 생성될 SCE_PLN_SO_LIST 를 가져온다.
			List<ScePlnSoListVO> toBePlnSoList = dbDao.searchPlnSoListToBeInserted(sceCopHdrVO);
			
			// 기존의 SCE_PLN_SO_LIST 를 가져온다.
			List<ScePlnSoListVO> crntPlnSoList = dbDao.searchPlnSoListByCop(cop_no);			
			List<ScePlnSoListVO> toBeInsertedPlnSoVO = new ArrayList<ScePlnSoListVO> ();
			log.error("\n replanCop Log 8");
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
			log.error("\n replanCop Log 9");
			dbDao.removeSoList(cop_no);
			log.error("\n replanCop Log 10");
			if (toBeInsertedPlnSoVO.size() != 0) 
				plnSoCnt = dbDao.addPlnSoList(toBeInsertedPlnSoVO);
			log.error("\n replanCop Log 11");
			// 3. SCE_COP_DTL 생성 작업
			// 기존의 SCE_COP_DTL 정보를 가져온다.
			List<SceCopDtlVO> crntDtlList = dbDao.searchCopDtl(sceCopHdrVO);
			log.error("\n replanCop Log 12");
			List<SceCopDtlVO> toBeDtlList = dbDao.searchCopDtlToBeInserted(sceCopHdrVO);
			log.error("\n replanCop Log 13");
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
				log.error("\n replanCop Log 14");
				toBeInsertedDtlVO.add(toBeRowVO);
				log.error("\n replanCop Log 15");
			}
			
			dbDao.removeCopDtl(cop_no);
			log.error("\n replanCop Log 16");
			copDtlCnt = dbDao.addCopDtl(toBeInsertedDtlVO);
			if (copDtlCnt != 0 && (sceCopHdrVO.getCntrNo() != null && !sceCopHdrVO.getCntrNo().equals(SCEConstants.PSEUDO_CNTR_NO))) {
				List<SceActRcvIfVO> actualList = dbDao.searchActualToBeUpdated(sceCopHdrVO.getCopNo());
//				public void copDetailReceiveREPLAN(SceActRcvIfVO actVo) throws EventException METHOD 사용!
				for (int i = 0; i < actualList.size(); i ++) {
					SceActRcvIfVO actVO = actualList.get(i);
					
					actVO.setCopUpdRmk(cop_upd_rmk) ;   // CHM-201326862 : manual replan 일때는 COA 호출을 막기 위해 remark ("MnlRpln") 를 넘김
					log.error("\n replanCop Log 17");
					copDetailReceiveBC.copDetailReceiveREPLAN(actVO);
					log.error("\n replanCop Log 18");
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
	 * 임시 cop replan 로직 관리
	 * @param sceCopHdrVO
	 * @throws EventException
	 * @see com.hanjin.apps.alps.esd.sce.replanmanage.replanmanage.basic.ReplanManageBC#replanCopTmp(com.hanjin.syscommon.common.table.SceCopHdrVO)
	 */
	public void replanCopTmp (SceCopHdrVO sceCopHdrVO) throws EventException {
		
		try {
			if (sceCopHdrVO.getCntrNo() != null && !sceCopHdrVO.getCntrNo().equals(SCEConstants.PSEUDO_CNTR_NO)) {
				List<SceActRcvIfVO> actualList = dbDao.searchActualToBeUpdatedTmpPrc(sceCopHdrVO.getCopNo());
//				public void copDetailReceiveREPLAN(SceActRcvIfVO actVo) throws EventException METHOD 사용!
				if (actualList.size() != 0 ) {
					for (int i = 0; i < actualList.size(); i ++) {
						SceActRcvIfVO actVO = actualList.get(i);
						copDetailReceiveBC.modifyActDatRcvDtByTmpRole(actVO);
					}	
				}
			}
			// master cop 이고 sce_cop_hdr, sce_pln_so_list, sce_cop_dtl 중 처리된 건이 하나도 없는 경우가 있으면 false
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException (new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException (new ErrorHandler(ex).getMessage());
		}	
	}
	
	/**
	 * 임시 cop replan 로직 관리
	 * @param sceCopHdrVO
	 * @throws EventException
	 * @see com.hanjin.apps.alps.esd.sce.replanmanage.replanmanage.basic.ReplanManageBC#replanCopTmp(com.hanjin.syscommon.common.table.SceCopHdrVO)
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
			// master cop 이고 sce_cop_hdr, sce_pln_so_list, sce_cop_dtl 중 처리된 건이 하나도 없는 경우가 있으면 false
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException (new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException (new ErrorHandler(ex).getMessage());
		}	
	}
	
	/**
	 * booking replan 으로 updateBkg method call 시 PRD_CHANGE_FRM_MAP, PSEUDO_VVD_UPDATE_FRM_MAP operation type 일 때 호출되어
	 * replan 을 수행한다.
	 * 
	 * 기본적인 logic 은 replanCop (SceCopHdrVO, String) 과 비슷함
	 * @param prdBkgCopMapVO
	 * @throws EventException
	 * @see com.hanjin.apps.alps.esd.sce.replanmanage.replanmanage.basic.ReplanManageBC#replanCopByPrdMap(com.hanjin.syscommon.common.table.PrdBkgCopMapVO)
	 */
	public void replanCopByPrdMap (PrdBkgCopMapVO prdBkgCopMapVO) throws EventException {
		String cop_no = prdBkgCopMapVO.getCopNo();
		String pctl_no = prdBkgCopMapVO.getPctlNo();
		String bkg_no = prdBkgCopMapVO.getBkgNo();
		
		String cntr_tpsz_cd = prdBkgCopMapVO.getCntrTpszCd();
//		String cntr_no = prdBkgCopMapVO.getCntrNo();
		
		try {
			// 1. SCE_COP_HDR 부분 수정 작업
			List<SceCopHdrVO> toBeUpdtHdrList = new ArrayList<SceCopHdrVO> ();
			List<PrdProdCtlMstVO> prdProdCtlMstList = dbDao.searchPrdMst(pctl_no);
			
			if (prdProdCtlMstList.size() == 0) {
				throw new EventException("No PCTL No found = " + pctl_no);
			}
				
			PrdProdCtlMstVO prdProdCtlMstVO = prdProdCtlMstList.get(0);
			
			String tobeVVD = prdProdCtlMstVO.getTrnkVslCd() + prdProdCtlMstVO.getTrnkSkdVoyNo()
				+ prdProdCtlMstVO.getTrnkSkdDirCd();
			
			SceCopHdrVO sceCopHdrVO = new SceCopHdrVO();
			
			ObjectCloner.build(prdProdCtlMstVO, sceCopHdrVO);
			
			sceCopHdrVO.setCopNo(cop_no);
			sceCopHdrVO.setPctlNo(pctl_no);
			sceCopHdrVO.setBkgNo(bkg_no);
			
			if (prdBkgCopMapVO.getCntrTpszCd().startsWith("Q")) {
				sceCopHdrVO.setCopStsCd("X");	
			}
			
			
//			List<SceCopHdrVO> railrcvList = dbDao.searchRailRcvCoffDt(sceCopHdrVO.getBkgNo());
			
//			if (railrcvList.size() > 0) {
//				SceCopHdrVO tmpVO = railrcvList.get(0);
//				sceCopHdrVO.setRailRcvCoffFmDt(tmpVO.getRailRcvCoffFmDt());
//				sceCopHdrVO.setRailRcvCoffToDt(tmpVO.getRailRcvCoffToDt());
//			}
			
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
			
			// pc no 가 변경되지 않고 replan 시도시 skip
			// 2012.01.02 김인수 [] pc 내역 확인시 일부 오류가 발견되 로직 제거 (transaction 문제로 check 가 제대로 되지 않는 것으로 추정)
			SceCopHdrVO crntCopHdr = dbDao.searchCopHdr(prdBkgCopMapVO.getCopNo());
//			if (prdBkgCopMapVO.getPctlNo().equals(crntCopHdr.getPctlNo())) {
//			if (dbDao.comparePcCtnt(prdBkgCopMapVO.getPctlNo(), crntCopHdr.getPctlNo())) {
//				SceCopHdrVO tmpVO = new SceCopHdrVO();
//				tmpVO.setCntrTpszCd(prdBkgCopMapVO.getCntrTpszCd());
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
			dbDao.modifyCopHdr(toBeUpdtHdrList);
			
			// 2. SCE_PLN_SO_LIST 생성 작업
			// 새로 생성될 SCE_PLN_SO_LIST 를 가져온다.
			List<ScePlnSoListVO> toBePlnSoList = dbDao.searchPlnSoListToBeInserted(sceCopHdrVO);
			
			// 기존의 SCE_PLN_SO_LIST 를 가져온다.
			List<ScePlnSoListVO> crntPlnSoList = dbDao.searchPlnSoListByCop(cop_no);
			
			List<ScePlnSoListVO> toBeInsertedVO = new ArrayList<ScePlnSoListVO> ();
			
			// TRSP_SO_STS_CD 와 CTRL_OFC_CD 를 기존의 값으로 유지
			for (int i = 0 ; i < toBePlnSoList.size(); i ++) {
				ScePlnSoListVO toBeRowVO = toBePlnSoList.get(i);
				for (int j = 0 ; j < crntPlnSoList.size(); j ++) {
					ScePlnSoListVO crntRowVO = crntPlnSoList.get(j);
					if (crntRowVO.getCostActGrpSeq().equals(toBeRowVO.getCostActGrpSeq()) && crntRowVO.getCopNo().equals(toBeRowVO.getCopNo())) {
						// so 가 발생한 cop 의 cost_act_grp_seq 에 대해서 so status 를 변경
						if (crntRowVO.getTrspSoStsCd() != null && !crntRowVO.getTrspSoStsCd().equals("") && !crntRowVO.getTrspSoStsCd().equals("P"))						
							toBeRowVO.setTrspSoStsCd (crntRowVO.getTrspSoStsCd());
//						toBeRowVO.setCreUsrId(crntRowVO.getCreUsrId());
//						toBeRowVO.setCreDt(crntRowVO.getCreDt());
					}
				}
				toBeInsertedVO.add(toBeRowVO);
			}
			
			dbDao.removeSoList(cop_no);
			
			if (toBeInsertedVO.size() != 0)
				dbDao.addPlnSoList(toBeInsertedVO);
			
			// 3. SCE_COP_DTL 생성 작업
			// 기존의 SCE_COP_DTL 정보를 가져온다.
			List<SceCopDtlVO> crntDtlList = dbDao.searchCopDtl(sceCopHdrVO);
			
			List<SceCopDtlVO> toBeDtlList = dbDao.searchCopDtlToBeInserted(sceCopHdrVO);
			
			List<SceCopDtlVO> toBeInsertedDtlVO = new ArrayList<SceCopDtlVO> ();
			
			for (int i = 0; i < toBeDtlList.size(); i ++) {
				SceCopDtlVO toBeRowVO = toBeDtlList.get(i);
				for (int j = 0 ; j < crntDtlList.size(); j ++) {
					SceCopDtlVO crntRowVO = crntDtlList.get(j);
//					if (crntRowVO.getCostActGrpSeq().equals(toBeRowVO.getCostActGrpSeq()) && crntRowVO.getCopNo().equals(toBeRowVO.getCopNo())) {
					if (crntRowVO.getActCd().equals(toBeRowVO.getActCd()) && crntRowVO.getNodCd().equals(toBeRowVO.getNodCd()) && !crntRowVO.getActDt().equals("") ) {
						
//						toBeRowVO.setActDt(crntRowVO.getActDt());
//						toBeRowVO.setActStsCd(crntRowVO.getActStsCd());
//						toBeRowVO.setActRcvTpCd(crntRowVO.getActRcvTpCd());
						toBeRowVO.setVndrSeq(crntRowVO.getVndrSeq());
						toBeRowVO.setEdiMsgTpCd(crntRowVO.getEdiMsgTpCd());
//						toBeRowVO.setActStsMapgCd(crntRowVO.getActStsMapgCd());
						toBeRowVO.setEdiActSndDt(crntRowVO.getEdiActSndDt());
//						toBeRowVO.setEstmGdt(crntRowVO.getEstmGdt());
						toBeRowVO.setEdiSndTpCd(crntRowVO.getEdiSndTpCd());
						toBeRowVO.setStndEdiStsCd(crntRowVO.getStndEdiStsCd());
//						toBeRowVO.setActDatRcvDt(crntRowVO.getActDatRcvDt());
						
//						toBeRowVO.setCreUsrId(crntRowVO.getCreUsrId());
//						toBeRowVO.setCreDt(crntRowVO.getCreDt());
					} else {
						if (i == 0) {
							toBeRowVO.setActStsCd("C");
						}
							
					}
				}
//				if (toBeRowVO.getActDt().equals("")) { // 현재 Detail 정보에서의 확인 에도 actual mapping 이 안된경우
//					
//				}
				toBeInsertedDtlVO.add(toBeRowVO);
			}
			
			dbDao.removeCopDtl(cop_no);
			dbDao.addCopDtl(toBeInsertedDtlVO);

			// 2010.12.20 booking replan 시 로직을  BkgCopManageBCImpl 의 replanCopByPrdMap 으로 이전 : transaction time 으로 인한 피해를 줄이기 위한 고육지책
//			if (copDtlCnt != 0 && !crntCopHdr.getCntrNo().equals(SCEConstants.PSEUDO_CNTR_NO)) {
//				List<SceActRcvIfVO> actualList = dbDao.searchActualToBeUpdated(cop_no);
////				public void copDetailReceiveREPLAN(SceActRcvIfVO actVo) throws EventException METHOD 사용!
//				for (int i = 0; i < actualList.size(); i ++) {
//					SceActRcvIfVO actVO = actualList.get(i);
//					copDetailReceiveBC.copDetailReceiveREPLAN(actVO);
//				}				
				
//				List<SearchExptTgtVO> exptTgtList = dbUtilDao.searchExptTgt(cop_no);
//				
//				for (int i = 0; i < exptTgtList.size(); i ++) {
//					SearchExptTgtVO rowVO = exptTgtList.get(i);
////					"exptBR","Y"
//					dbUtilDao.callSceExcetionResistActPrc(rowVO.getCopNo(), rowVO.getCopDtlSeq(), rowVO.getActDt(), "exptBR", "Y");
//				}
//			}
			
			if (!asisVVD.equals(tobeVVD) && !crntCopHdr.getCntrNo().equals(SCEConstants.PSEUDO_CNTR_NO)) { // VVD 가 상이할 경우 master 정리 작업
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
	 * @see com.hanjin.apps.alps.esd.sce.replanmanage.replanmanage.basic.ReplanManageBC#replanCop(com.hanjin.apps.alps.esd.trs.cydoorsomanage.singletransportationsomanage.vo.SingleTransportationVO)
	 */
	public ReplanResultVO replanCop (SingleTransportationVO singleTransportationVO) throws EventException {
		ReplanResultVO rsltVO = replanCop (singleTransportationVO.getColumnValues());
		TrsCommonBCImpl trsBCImpl = new TrsCommonBCImpl();
		trsBCImpl.multiSceSoHistory(singleTransportationVO);
		
		return rsltVO;
	}
	
	/**
	 * @param trsTrspRailBilOrdVO
	 * @return ReplanResultVO
	 * @throws EventException
	 * @see com.hanjin.apps.alps.esd.sce.replanmanage.replanmanage.basic.ReplanManageBC#replanCop(com.hanjin.syscommon.common.table.TrsTrspRailBilOrdVO)
	 */
	public ReplanResultVO replanCop (TrsTrspRailBilOrdVO trsTrspRailBilOrdVO) throws EventException {
		ReplanResultVO rsltVO = replanCop (trsTrspRailBilOrdVO.getColumnValues());
		return rsltVO;
	}
	
	/**
	 * @param trsTrspSvcOrdVO
	 * @return ReplanResultVO
	 * @throws EventException
	 * @see com.hanjin.apps.alps.esd.sce.replanmanage.replanmanage.basic.ReplanManageBC#replanCop(com.hanjin.syscommon.common.table.TrsTrspSvcOrdVO)
	 */
	public ReplanResultVO replanCop (TrsTrspSvcOrdVO trsTrspSvcOrdVO) throws EventException {
		ReplanResultVO rsltVO = replanCop (trsTrspSvcOrdVO.getColumnValues());
		return rsltVO;
	}
	
	/**
	 * @param trsTrspEdiRailOrdVO
	 * @return ReplanResultVO
	 * @throws EventException
	 * @see com.hanjin.apps.alps.esd.sce.replanmanage.replanmanage.basic.ReplanManageBC#replanCop(com.hanjin.syscommon.common.table.TrsTrspEdiRailOrdVO)
	 */
	public ReplanResultVO replanCop (TrsTrspEdiRailOrdVO trsTrspEdiRailOrdVO) throws EventException {
		ReplanResultVO rsltVO = replanCop (trsTrspEdiRailOrdVO.getColumnValues());
		return rsltVO;
	}
	
	/**
	 * @param sceCopHdrVO
	 * @param account
	 * @throws EventException
	 * @see com.hanjin.apps.alps.esd.sce.replanmanage.replanmanage.basic.ReplanManageBC#replanCopInclPrt(com.hanjin.syscommon.common.table.SceCopHdrVO)
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
			
			for (int i = 0; i < partialList.size(); i ++) {
				// replan 호출하여 pc no return
				SceCopHdrVO rowVO = partialList.get(i);
				rowVO.setPctlNo(pctl_no);
				replanCop(rowVO, "CopInclPrt");
				
				String ofcCd = "SysMan";
				String usrId = "SysMan";
				if(account != null){
					ofcCd = account.getOfc_cd();
					usrId = account.getUsr_id();
				}
				
				dbUtilDao.addSceCopHistory(rowVO.getCopNo(), "MC", ofcCd, usrId, "Y");
				
				//COA I/F

				com.hanjin.apps.alps.esm.mas.stdunitcost.costassign.basic.CostAssignBC masCommand 
				= new com.hanjin.apps.alps.esm.mas.stdunitcost.costassign.basic.CostAssignBCImpl();

				MasBkgComIfVO masBkgComIfVo = new MasBkgComIfVO();
				
				masBkgComIfVo.setBkgNo(bkg_no);
				masBkgComIfVo.setCostSrcSysCd("SCE"); //TRS, TES, SCE, BKG등 SUB SYSTEM CODE
				masBkgComIfVo.setIfRmk("COP MT Change"); // 변경사유
				masBkgComIfVo.setCreUsrId("SceMan");
				masBkgComIfVo.setUpdUsrId("SceMan");

				int result_cnt2 = masCommand.modifyMasCommonInterface(masBkgComIfVo);

				if (result_cnt2 < 0)
					throw new EventException((new ErrorHandler("TRS00099",new String[]{"MAS I/F Error"})).getMessage());
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
	 * @see com.hanjin.apps.alps.esd.sce.replanmanage.replanmanage.basic.ReplanManageBC#modifySoList(com.hanjin.apps.alps.esd.trs.cydoorsomanage.singletransportationsomanage.vo.SingleTransportationVO)
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
	 * @see com.hanjin.apps.alps.esd.sce.replanmanage.replanmanage.basic.ReplanManageBC#modifySoList(com.hanjin.syscommon.common.table.TrsTrspRailBilOrdVO)
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
	 * @see com.hanjin.apps.alps.esd.sce.replanmanage.replanmanage.basic.ReplanManageBC#modifySoList(com.hanjin.syscommon.common.table.TrsTrspEdiRailOrdVO)
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
					searchRtrReMap (trspSoOfcCtyCd , trspSoSeq);
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
	
//	private int modifySoListNoLog (ScePlnSoListVO scePlnSoListVO, String trsp_bnd_cd, String trspSoOfcCtyCd, String trspSoSeq) throws DAOException, Exception {
//		int cnt = 0;
//		
//		try {
//			cnt = dbDao.modifyPlnSoList(scePlnSoListVO);
//			
//			if (cnt > 0) {
//				SceCopHdrVO sceCopHdrVO = new SceCopHdrVO();
//				if (scePlnSoListVO.getTrspSoStsCd() != null && scePlnSoListVO.getTrspSoStsCd().equals(SCEConstants.SO_CREATION)) {
//					dbUtilDao.addSceCopHistory(scePlnSoListVO.getCopNo(), "S" + trsp_bnd_cd, "SysSo", "GenS/O", "Y");	
//					sceCopHdrVO.setCopNo(scePlnSoListVO.getCopNo());
//					sceCopHdrVO.setCopUpdRmk("S/O Created > " + trspSoOfcCtyCd + " : " + trspSoSeq);
//				} else {
//					sceCopHdrVO.setCopNo(scePlnSoListVO.getCopNo());
//					sceCopHdrVO.setCopUpdRmk("Pln So Changed > " + trspSoOfcCtyCd + " : " + trspSoSeq + " / trsp_so_sts_cd = " + scePlnSoListVO.getTrspSoStsCd());
//				}
//				dbDao.modifyCopHdr(sceCopHdrVO);
//			}
//				
//		} catch(DAOException ex) {
//			log.error("err " + ex.toString(), ex);
//			throw ex;
//		} catch (Exception ex) {
//			log.error("err " + ex.toString(), ex);
//			throw ex;
//		}
//		
//		return cnt;
//	}
	
	/**
	 * @param sceCopHdrVO
	 * @return int
	 * @throws EventException
	 * @see com.hanjin.apps.alps.esd.sce.replanmanage.replanmanage.basic.ReplanManageBC#modifyProvCntrByWRS(com.hanjin.syscommon.common.table.SceCopHdrVO)
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
	 * S/O 에 의하여 replan 되는 case 에 대하여 로직 수행
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
				String pctl_no = prdBC.createSceSoReplan(rowVO.getCopNo(), trsp_bnd_cd, "REP_SO"); // PC 호출 필요!
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
						dbDao.modifyCopHdr(rowVO);
						
						rsltVO.setRplnRsltFlg("N");
						rsltVO.setUmchFlg("Y");
						rsltVO.setUpdRmk("Unmatch case occurred!!");
						
						// PRD 에서 BKG Replan 시 Unmatch 된 S/O 는 route 생성에 포함시키지 않게 rpln_umch_flg 를 S/O table 에 관리한다.
						dbDao.modifySvcOrdUmchFlg(rsltVO);
						
						// Planned 가 아닌 status 를 cop 에 가지고있고 해당 cop_no, cost_act_grp_seq 로 생성된 s/o 가 unmatch 인 경우 cop 의 status 를 P 로 환원
//						if (srcMap.get("trsp_so_sts_cd") != null && srcMap.get("trsp_so_sts_cd").equals(SCEConstants.SO_CORRECTED)) {
							dbDao.modifySoStsPlnByUmchSo(srcMap.get("cop_no"), srcMap.get("cost_act_grp_seq") );	
//						}
						// unmatch된 case 이더라도 cost_act_grp_seq, cop_no 에 해당 하는 row 에 대한 update 를 시도한다.
						// 2010.04.11 현업과의 협의를 통해 unmatch S/O 건에 대해서는 status 를 관리하지 않는다.
					
						dbUtilDao.addSceCopHistory(rowVO.getCopNo(), "UM", "sysbkg","sysbkg","N");					

						rsltVO.setRplnRsltFlg("N");
						rsltVO.setUmchFlg("Y");
						rsltVO.setUpdRmk("Unmatch case occurred!!");
						
						// PRD 에서 BKG Replan 시 Unmatch 된 S/O 는 route 생성에 포함시키지 않게 rpln_umch_flg 를 S/O table 에 관리한다.
						dbDao.modifySvcOrdUmchFlg(rsltVO);
					}
				}
				//TRS에서 넘어온 신규 Rail S/O에 대해서 이전에 생성한 S/O를 찾는다(SCE_CLM 데이블과 SCE_CLM_IF 테이블의 대상을 찾기 위한 조건값 조회)
				//찾아온 대상을 기준으로 SCE_CLM 테이블의 데이터를 삭제를 한다.
				//찾아온 대상을 기준으로 SCE_CLM_IF 테이블에서 SO_MAPG_STS_CD = '00' 으로 업데이트 처리
				searchRtrReMap(rsltVO.getTrspSoOfcCtyCd() ,rsltVO.getTrspSoSeq());
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

/*	
	private ReplanResultVO replanCop (Map<String, String> srcMap) throws EventException {
		// COP 별로 replan 을 수행
		// so 가 생성 되었다면 해당 SO No 를 가지고 어떤 PC 를 생성 가능한지를 판단하고 PC 를 호출 해야 한다.
		
		// PC 없이 수행 가능한 업무와 PC 가 존재해야 하는 업무를 판단할 필요 있음
		// route 가 변경되었는지에 대한 확인이 필요... 가능한가???
		// unplanned S/O 의 case
		
		ReplanResultVO rsltVO = new ReplanResultVO();
		rsltVO.setFmNodCd(srcMap.get("fm_nod_cd"));
		rsltVO.setToNodCd(srcMap.get("to_nod_cd"));
		rsltVO.setTrspSoOfcCtyCd(srcMap.get("trsp_so_ofc_cty_cd"));
		rsltVO.setTrspSoSeq(srcMap.get("trsp_so_seq"));
		rsltVO.setRplnRsltFlg("Y");
		rsltVO.setUmchFlg("N");
		rsltVO.setUpdRmk("");
		
		String cop_no = srcMap.get("cop_no");
		String cntr_no = srcMap.get("eq_no");
		String bkg_no = srcMap.get("bkg_no");
		String trsp_bnd_cd = srcMap.get("trsp_bnd_cd");
		String act_grp_cd = srcMap.get("act_grp_cd");
		
		if (cop_no == null || cop_no.equals(""))
			throw new EventException("No Data : Cop No");

		if (bkg_no == null || bkg_no.equals(""))
			throw new EventException("No Data : Booking No");
		
		if (trsp_bnd_cd == null || trsp_bnd_cd.equals(""))
			throw new EventException("No Data : trsp_bnd_cd");
		
		if (act_grp_cd == null || act_grp_cd.equals(""))
			throw new EventException("No Data : act_grp_cd");
		
		try {

			List<SceCopHdrVO> partialList = new ArrayList<SceCopHdrVO> (); 
			
			SceCopHdrVO sceCopHdrVO = dbDao.searchCopHdr(cop_no);
			
			 // finish 된 cop 로의 s/o 생성 또는 ODSO 일 경우
			if (sceCopHdrVO.getCopStsCd().equals("F") || ((cntr_no == null || cntr_no.equals("")) && act_grp_cd.startsWith("OD")  )) {
				partialList.add(sceCopHdrVO);
			} else {
				partialList = dbDao.searchPartialCops(bkg_no, cntr_no, "C");
			}
			
			if (partialList.size() == 0) {
				log.error("No data found in Search COP!!!");
				rsltVO.setCopNo("");
				rsltVO.setCostActGrpSeq("");
				rsltVO.setRplnRsltFlg("N");
				rsltVO.setUpdRmk("No data found in Search COP!!!");
				
				return rsltVO;
			}
			// partialList 중 S/O 가 생성된 COP 가 아닐 경우에는 route replan 만 수행해야 한다.
			for (int i = 0; i < partialList.size(); i ++) { 
				// replan 호출하여 pc no return
				SceCopHdrVO rowVO = partialList.get(i);
							
				String pctl_no = prdBC.createSceSoReplan(rowVO.getCopNo(), trsp_bnd_cd, "REP_SO"); // PC 호출 필요!
				if (pctl_no != null && !pctl_no.equals("")) { //생성된 pctl_no 로 replan 시작
					
//					[PRD] Actual Dwell Time 적용 SKD - replan시 호출되고 있다.
					rowVO.setPctlNo(pctl_no);
					
					boolean tmpBool = replanCop(rowVO, "SoRpln");
					
					if (rowVO.getCopNo().equals(srcMap.get("cop_no"))) {
						ScePlnSoListVO tmp = new ScePlnSoListVO();
						tmp.setCopNo(srcMap.get("cop_no"));
						tmp.setCostActGrpSeq(srcMap.get("cost_act_grp_seq"));

						// tmpBool이 replan 성공을 의미한다면 modifyPlnSoList도 해당 조건안에서 실행되야 할듯함.
						
						tmp.setTrspSoStsCd(srcMap.get("trsp_so_sts_cd"));
						dbDao.modifyPlnSoList(tmp);
						
						if (tmpBool) {
							rsltVO.setUpdRmk("Replan succeeded!!");
							dbUtilDao.addSceCopHistory(rowVO.getCopNo(), "S" + trsp_bnd_cd, "SysSo", "SysSo", "Y");
							
							rsltVO.setUmchFlg("");							
							// correction시 unmatch건이 match될수도 있으므로 null값으로 변경하도록 기능 추가
							dbDao.modifySvcOrdUmchFlg(rsltVO);
						
						}
					}
					
					
					if (!tmpBool && rowVO.getCopNo().equals(rowVO.getMstCopNo())) {
						//현재 건이 fail 이고 master cop replan 이 fail 난 경우
						rsltVO.setRplnRsltFlg("N");
						rsltVO.setUpdRmk("master cop replan fail");
					}
					
				} else { // unmatch case 로 so replan 불가함
					if (rowVO.getCopNo().equals(srcMap.get("cop_no"))) {
						// sce_COP_HDR 의 UMCH_STS_CD 를 set 한다.(Y)
						rowVO.setUmchStsCd("Y");
						rowVO.setCopUpdRmk("UmchSO:GrpSeq=" + srcMap.get("cost_act_grp_seq") + "/soOfc=" + rsltVO.getTrspSoOfcCtyCd() + "/soSeq=" + rsltVO.getTrspSoSeq());
						dbDao.modifyCopHdr(rowVO);
						
						rsltVO.setRplnRsltFlg("N");
						rsltVO.setUmchFlg("Y");
						rsltVO.setUpdRmk("Unmatch case occurred!!");
						
						// PRD 에서 BKG Replan 시 Unmatch 된 S/O 는 route 생성에 포함시키지 않게 rpln_umch_flg 를 S/O table 에 관리한다.
						dbDao.modifySvcOrdUmchFlg(rsltVO);
						
						// Planned 가 아닌 status 를 cop 에 가지고있고 해당 cop_no, cost_act_grp_seq 로 생성된 s/o 가 unmatch 인 경우 cop 의 status 를 P 로 환원
//						if (srcMap.get("trsp_so_sts_cd") != null && srcMap.get("trsp_so_sts_cd").equals(SCEConstants.SO_CORRECTED)) {
							dbDao.modifySoStsPlnByUmchSo(srcMap.get("cop_no"), srcMap.get("cost_act_grp_seq") );	
//						}
						// unmatch된 case 이더라도 cost_act_grp_seq, cop_no 에 해당 하는 row 에 대한 update 를 시도한다.
						// 2010.04.11 현업과의 협의를 통해 unmatch S/O 건에 대해서는 status 를 관리하지 않는다.
					
						dbUtilDao.addSceCopHistory(rowVO.getCopNo(), "UM", "sysbkg","sysbkg","N");					

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
*/	
	
	
	/**
	 * Master flag 를 정리함
	 * 발생 case
	 * 1. container detach 될 때 detach 될 대상 booking 이 master 였다.
	 * 2. container attach 될 때 partial 관계가 성립되었다.
	 * 3. booking split 될 때 partial 관계가 성립되었다.
	 * 4. booking combine 될 때 combine 될 대상 booking 들이 가지고 있는 container 가 partial 관계가 없어진 경우 
	 * 	(새로이 split 관계가 생갤 수도 있다.)
	 * 5. booking 이 cancel 될 대상이 master
	 * 
	 *
	 * 주의 : partial 여부 판단은 booking 관련 event 가 종료된 cop 를 대상으로 해야한다.
	 * 
	 * vvd 가 변경되었을 경우 변경 event 가 넘어온 COP 는 master 가 변경되나 기 관련 있던 것들의 재 정리가 안되고 있음
	 * cntr_no, VVD 로 전체가 
	 * @param bkg_no
	 * @param cntr_no
	 * @param cop_no 본 method 를 invoke 시킨 cop_no
	 * @return String
	 * @exception EventException
	 */
	public String arrangeMstCopNo(String bkg_no, String cntr_no, String cop_no) throws EventException {
		// TODO Auto-generated method stub
		log.info("\n[poong] arrangeMstCopNo start");
		log.info("\n[poong] arrangeMstCopNo new_bkg_no="+bkg_no+"/cntr_no="+cntr_no+"/cop_no="+cop_no);
		try {
			if (cntr_no.equals(SCEConstants.PSEUDO_CNTR_NO))
				return "";
			
//			String invokeCopNo = "";
			SceCopHdrVO tmpCop = dbDao.searchCopHdr(cop_no);
			String sts_flg = "C";
			
			if (tmpCop != null && tmpCop.getCopStsCd().equals("X"))
				sts_flg = "X";
			
			List<SceCopHdrVO> sceCopHdrVOs = dbDao.searchPartialCops(bkg_no, cntr_no, sts_flg); // C, T status 의 COP 만 대상으로 booking event 가 종료된 이후 Partial 이 존재하는 가를 판단.
			
			String toBeMstCopNo = "";
			
			List<String> copNoList = new ArrayList<String>();
			
			Set<String> mstCopNoSet = new HashSet<String>();
			
			ListIterator<SceCopHdrVO> listItr = sceCopHdrVOs.listIterator();
			while (listItr.hasNext()) {
				SceCopHdrVO sceCopHdrVO = listItr.next();
				copNoList.add(sceCopHdrVO.getCopNo());
				mstCopNoSet.add(sceCopHdrVO.getMstCopNo());
			}
			
			if (sceCopHdrVOs != null && sceCopHdrVOs.size() >= 2) { // Partial 관계가 존재할 경우
				List<SceCopHdrVO> sceCopHdrVOsClone = new ArrayList<SceCopHdrVO> ();
				Collections.copy(sceCopHdrVOs, sceCopHdrVOsClone); // 재활용할 clone 객체를 생성한다.
				
				List<SceCopHdrVO> updateSceCopHdrVOs = null;
				
				
				
				if (mstCopNoSet.size() != 1 || !copNoList.contains(mstCopNoSet)) {
					toBeMstCopNo = chooseToBeMstCopNo(sceCopHdrVOsClone);
					
					// SO, TRO, actual 운송 case 별로도 확인이 안되면 최초 COP 를 잡는다.
					if (toBeMstCopNo.equals("")) {
						// 자기 자신 외의 master 가 존재한다면 그 cop_no 로 이 method 를 invoke 시킨 cop 의 mst_cop_no 를 변경한다.
						if (mstCopNoSet.size() == 2) {
							mstCopNoSet.remove(cop_no);
							toBeMstCopNo = (String) mstCopNoSet.toArray()[0];
						} else {
							toBeMstCopNo = copNoList.get(0);
						}
					}
					// master cop 가 변경된다.
					if (!toBeMstCopNo.equals("")) {
						updateSceCopHdrVOs = new ArrayList<SceCopHdrVO> ();
						for (int i = 0; i < copNoList.size(); i ++) {
							SceCopHdrVO rowVO = new SceCopHdrVO();
							rowVO.setCopNo(copNoList.get(i));
							rowVO.setMstCopNo(toBeMstCopNo);
							
							updateSceCopHdrVOs.add(rowVO);
						}
						dbDao.modifyCopHdr(updateSceCopHdrVOs);
						
						// 과거 COP NO 로 발행 되어있던 S/O No 를 새로운 cop no 로 변경한다.
						TrsTrspSvcOrdVO trsTrspSvcOrdVO = new TrsTrspSvcOrdVO();
						TrsTrspRailBilOrdVO trsTrspRailBilOrdVO = new TrsTrspRailBilOrdVO();
						
						for (int i = 0; i < copNoList.size(); i ++) {
							if (!copNoList.get(i).equals(toBeMstCopNo)) {
								// cost_act_grp_seq 는 변하지 않으므로 변경하지 않는다.
								// cop_no 와 mst_cop_no 가 다를 경우 mst_cop_no 로 각 s/o 의 cop_no 를 변경하여 준다.
								// 2011.10.06 김인수 [] WRS 에서 Container 가 없는 상태에서 Rail S/O 를 생성하고 container 가 assign 될 때 S/O 가 이동되는 case 가 있어
								//			하기 DBDAO 단에서 to_be_cop_no 에 해당되는 Booking no, BL no 도 TRS table 에 update 하게 로직 수정
								trsTrspSvcOrdVO.setCopNo(copNoList.get(i));
								trsTrspRailBilOrdVO.setCopNo(copNoList.get(i));
								dbDao.modifySvcOrdByCop(toBeMstCopNo, trsTrspSvcOrdVO);
								dbDao.modifyRailBilOrdByCop(toBeMstCopNo, trsTrspRailBilOrdVO);
							}
						}
					} else {
						// master cop no 부여 오류
					}
				} 
				if (cop_no.equals(toBeMstCopNo)) { // master cop no 가 변경되었을 경우
					 // 자기 자신이 master 이었더라도 자신을 master cop 로 여기는 다른 cop 들 중 재차 master cop no 를 선정해 update 해 줘야 한다.
					/**
					 * mst_cop_no = tmpVO.getCopNo()  && cop_no != tmpVO.getCopNo() 인 COP 들을 골라 mst_cop_no 가 될 cop 를 찾아 새로 지정해 줄것
					 * 
					 * 2011.07.20 김인수 수정 : 
					 */
					List <SceCopHdrVO> cops = dbDao.searchCopHdrByMstCopNoExptItself(cop_no, copNoList);
					if (cops.size() != 0) {
						toBeMstCopNo = chooseToBeMstCopNo(cops);
						
						// SO, TRO, actual 운송 case 별로도 확인이 안되면 최초 COP 를 잡는다.
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
						dbDao.modifyCopHdr(tmpList);
					}
				}
				
			} else if (sceCopHdrVOs!=null && sceCopHdrVOs.size() == 1) { // Partial 관계가 존재하지 않을 경우 또는 partial 이었으나 master 가 cancel 될 때?
				// mst_cop_no 를 cop_no 로 update 하여 준다.
				SceCopHdrVO sceCopHdrVO = sceCopHdrVOs.get(0);
				if ( // master cop no 가 없을 경우 또는 LCL 도 아닌데 master cop no 가 cop no 와 다른 경우는 cop_no 로 master cop no 를 update 
						(sceCopHdrVO.getMstCopNo() == null || sceCopHdrVO.getMstCopNo().equals("")) ||
						!sceCopHdrVO.getCopNo().equals(sceCopHdrVO.getMstCopNo())		
				) {
					sceCopHdrVO.setMstCopNo(sceCopHdrVO.getCopNo());
					List<SceCopHdrVO> toBeUpdVO = new ArrayList<SceCopHdrVO>();
					toBeUpdVO.add(sceCopHdrVO);
					dbDao.modifyCopHdr(toBeUpdVO);
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
						dbDao.modifyCopHdr(toBeUpdVO);
					} else if ((tmpVO.getMstCopNo() != null && !tmpVO.getMstCopNo().equals("")) &&
					 (tmpVO.getCopNo().equals(tmpVO.getMstCopNo())) 		
					) { // 자기 자신이 master 이었더라도 자신을 master cop 로 여기는 다른 cop 들 중 재차 master cop no 를 선정해 update 해 줘야 한다.
						/**
						 * mst_cop_no = tmpVO.getCopNo()  && cop_no != tmpVO.getCopNo() 인 COP 들을 골라 mst_cop_no 가 될 cop 를 찾아 새로 지정해 줄것
						 */
						List <SceCopHdrVO> cops = dbDao.searchCopHdrByMstCopNoExptItself(tmpVO.getCopNo(), copNoList);
						if (cops.size() != 0) {
							toBeMstCopNo = chooseToBeMstCopNo(cops);
							
							// SO, TRO, actual 운송 case 별로도 확인이 안되면 최초 COP 를 잡는다.
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
							dbDao.modifyCopHdr(tmpList);
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
		 * mst cop no 가 제대로 관리 안되고 있거나 새로 partial 이 생성된 부분
		 * Master 대상으로 잡을 rule
		 *  1. 기본적으로 master 에서 해제 되는 건은 안됨
		 *  2. container 가 attach
		 *  3. Confirm 된 TRO 가 존재
		 *  4. 운송이 시작된 COP
		 *  5. S/O 가 존재 (당연히 master 가 옮겨가는 case 에서는 S/O 가 없겠지만 기존 정보 재 정리일 수도 있으므로..)
		 */
		//TODO partial 로 엮인 COP 들로 S/O 를 조회하고 해당 S/O 에 엮인 COP no 가 하나뿐이라면
		// 해당 COP NO 로 MASTER COP NO 를 정리해 줘야  한다.
		String toBeMstCopNo = "";
		ListIterator<SceCopHdrVO> listItrClone = sceCopHdrVOsClone.listIterator();
		
		// 새로 master cop 가 될 cop no 를 정한다.
		while (listItrClone.hasNext()) {
			SceCopHdrVO sceCopHdrVO = listItrClone.next();
			
			String copNo = sceCopHdrVO.getCopNo();
//						String bkgNo = sceCopHdrVO.getBkgNo();
//						String cntrNo = sceCopHdrVO.getCntrNo();
//						String mstCopNo = sceCopHdrVO.getMstCopNo();
			String copStsCd = sceCopHdrVO.getCopStsCd();
			
			if (sceCopHdrVO.getCntrNo().equals(SCEConstants.PSEUDO_CNTR_NO)) {
				continue;
			}
			
			List<SearchSoByCopVO> soVO = dbDao.searchSoByCop(copNo);
			
			// 기 생성된 SO 가 존재하면 해당 COP 가 우선적으로 master 가 된다.  
			if (soVO != null && soVO.size() != 0) {
				toBeMstCopNo = copNo;
				break;
			}
			
			if ( // S/O 가 없다면  TRO 가 존재할 경우 ODSO 가 생성될 가능성이 크므로 master 가 된다.
					(sceCopHdrVO.getObTroFlg() != null && sceCopHdrVO.getObTroFlg().equals("Y")) ||
					(sceCopHdrVO.getIbTroFlg() != null && sceCopHdrVO.getIbTroFlg().equals("Y"))
			) {
				toBeMstCopNo = copNo;
				break;
			}
			
			// SO, ODSO 가 없다면 actual 운송이 시작된 case 에 master 를 부여한다.
			if (copStsCd.equals("T")) {
				toBeMstCopNo = copNo;
				break;
			}
			
		}
		return toBeMstCopNo;
	}
	
	/**
	 * @param fm_cop_no : 현재 master 인 cop
	 * @param to_cop_no : master 가 넘어갈 cop
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
			
			// 변경하려는 Master flag 에 대한 validation 을 수행
			// 1. 피 변경 master cop 로 S/O 가 존재하는가
			// 2. 피 변경 master cop 와  변경 될 master cop 이외에 master cop 가 존재하는가
			
			List<SceCopHdrVO> sceCopHdrVOs = dbDao.searchPartialCops(fmCopHdrVO.getBkgNo(), fm_cntr_no, "C");
			ListIterator<SceCopHdrVO> listItr = sceCopHdrVOs.listIterator();
			
			while (listItr.hasNext()) {
				SceCopHdrVO rowVO = listItr.next();
				String rowMstCopNo = rowVO.getMstCopNo();
				
				rowMstCopNo = (rowMstCopNo == null || rowMstCopNo.equals("")) ? rowVO.getCopNo() : rowMstCopNo;
				
//				if (!rowMstCopNo.equals(fm_mst_cop_no) && rowMstCopNo.equals(to_mst_cop_no)) {
//					// 코딩 보류 : validation 이 필요 없이 partial 로 잡힌 모든 COP 의 MST_COP_NO 를 TO 로 변경하면 된다.
//					
//				}
			}
//			SceCopHdrVO updateSceCopHdrVO = new SceCopHdrVO();
			
			if (fm_cntr_no.equals(SCEConstants.PSEUDO_CNTR_NO))
				rtnVal = SCEConstants.MST_CNTR_NO_ERROR;
			
//			if (fm_mst_cop_no == null || (!fm_mst_cop_no.equals(fm_cop_no) || fm_mst_cop_no.equals(""))) {
//				rtnVal = SCEConstants.MST_COP_NO_ERROR;
//			}
			
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
	 * 주어진 SCE_COP_HDR 생성 조건에 따라 기타 다른 COP 생성 작업을 수행한다.
	 * SCE_COP_HDR 부터 모든 COP 생성 / actual mapping / edi 재전송 등의 작업을 총괄한다.
	 * 
	 * 기 운송 중인 container 에 대해 생성되었을 경우에는 master flag 를 조정한다.
	 * 
	 * 단, partial 난 case 에 대한 replan 은 본 method 밖에서 판별하여 진행해야 한다.
	 * 
	 * 보통 BkgCopManageDBDAO 의 searchCopHdrToBeCreated method 와 한쌍으로 진행된다.
	 * 
	 * 2009.12.23 > Rail Rcving cut off date 관리를 재설정 : COP 신규 생성시에 기존 bkg 의 rail_rcv_coff_fm_dt, rail_rcv_coff_to_dt 를 가져옴
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
	
	/**
	 * @param String trspSoOfcCtyCd
	 * @param String trspSoSeq
	 * @throws EventException
	 */
	public void modifyRtrReMap (String trspSoOfcCtyCd , String trspSoSeq) throws EventException {
		try {
			searchRtrReMap (trspSoOfcCtyCd , trspSoSeq);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
	/**
	 *  1.TRS에서 넘어온 신규 Rail S/O에 대해서 이전에 생성한 S/O를 찾는다.
	 *  2.위의 1의 기준으로 SCE_CLM 테이블의 데이터를 삭제를 한다.
	 *  3.위의 1의 기준으로 SCE_CLM_IF 테이블에서 SO_MAPG_STS_CD = '00' 으로 업데이트 처리
	 * @param String trspSoOfcCtyCd
	 * @param String trspSoSeq
	 * @throws DAOException
	 * @throws Exception
	 */
	public void searchRtrReMap ( String trspSoOfcCtyCd, String trspSoSeq) throws EventException {
		int cnt = 0;
		int cnt1 = 0;
		DBRowSet dbRowset = null;
		String cntr_no ="";
		String cnmv_yr = "";
		String cnmv_id_no = "";
		String clm_seq = "";
		try {
			if ("PHX".equals(trspSoOfcCtyCd) || "WRS".equals(trspSoOfcCtyCd)){
				dbRowset = dbDao.searchNewSO(trspSoOfcCtyCd , trspSoSeq);
					while (dbRowset.next()){
						cntr_no = dbRowset.getString("CNTR_NO");
						cnmv_yr = dbRowset.getString("CNMV_YR");
						cnmv_id_no = dbRowset.getString("CNMV_ID_NO");
						clm_seq = dbRowset.getString("CLM_SEQ");
				
						//찾아온 대상을 기준으로 SCE_CLM 테이블의 데이터를 삭제를 한다.
						cnt = dbDao.removeSceClm(cntr_no ,cnmv_yr ,cnmv_id_no , clm_seq);
						//찾아온 대상을 기준으로 SCE_CLM_IF 테이블에서 SO_MAPG_STS_CD = '00' 으로 업데이트 처리
						cnt1 = dbDao.modifySceClmIf(cntr_no ,cnmv_yr ,cnmv_id_no , clm_seq);
					}
			}
	
				
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	/**
	 * fm_cop_no 로 S/O 의 SO key 값을 가져와 
	 * @param fm_cop_no
	 * @param to_cop_no
	 * @throws EventException
	 */
//	private void moveSoBtwnCop(String fm_cop_no, String to_cop_no) throws EventException {
//		try {
//			List<SearchSoByCopVO> soByCops = dbDao.searchSoByCop(fm_cop_no);
//			
//			for (int i = 0 ; i < soByCops.size() ; i++) {
//				SearchSoByCopVO rowVO = soByCops.get(i);
//				
//				TrsTrspRailBilOrdVO trsTrspRailBilOrdVO = new TrsTrspRailBilOrdVO();
//				TrsTrspSvcOrdVO trsTrspSvcOrdVO = new TrsTrspSvcOrdVO();
//				
//				ObjectCloner.build(rowVO, trsTrspRailBilOrdVO);
//				ObjectCloner.build(rowVO, trsTrspSvcOrdVO);
//				
//				dbDao.modifyRailBilOrdByCop(to_cop_no, trsTrspRailBilOrdVO);
//				dbDao.modifySvcOrdByCop(to_cop_no, trsTrspSvcOrdVO);
//			}
//		} catch (DAOException ex) {
//			log.error("err " + ex.toString(), ex);
//			throw new EventException(new ErrorHandler(ex).getMessage());
//		} catch (Exception ex) {
//			log.error("err " + ex.toString(), ex);
//			throw new EventException(new ErrorHandler(ex).getMessage());
//		}
//		
//	}
	
//	private void setActDtByReplan(SceCopDtlVO sceCopDtlVO, String bkg_no, String cntr_no) throws Exception {
//		/**
//		 * 각 bound 와 cop_dtl_seq 의 act_cd 별로 찾아야할 actual date 대상이 다르므로
//		 * 그 규정을 table 로 관리한다.
//		 * cop_dtl_seq act_cd 에 대한 분석작업
//		 * 1. cop_dtl_seq between 4000 and 5999
//		 * 	sce_act_rcv_if 의 act_rcv_tp_cd = 2
//		 * 
//		 * 2. 그외
//		 * 	(1) ACT_CD STARTWITH  'M' 이면서 inbound : edi_214_msg
//		 * 	(2) ACT_CD 가 RAIL 관련 : 322
//		 * 	(3) 그 외 : MVMT
//		 * 
//		 * replan 시에 actual mapping 되지 않은 정보를 찾아서 mapping 해야 하는 이유 : ?
//		 *  
//		 * SCE_ACT_RCV_IF 의 조회 결과를 모두 SceActRcvIfVO 에 담아서 하기 method 를 call 해야한다.
//		 * public void copDetailReceiveREPLAN(SceActRcvIfVO actVo) throws EventException METHOD 사용!
//		 */
//		String cop_no = sceCopDtlVO.getCopNo();
//		int cop_dtl_seq = new Integer(sceCopDtlVO.getCopDtlSeq()).intValue();
//		String act_cd = sceCopDtlVO.getActCd();
//		
//		if (act_cd.startsWith("FITZAD")) {
//						
//		} else if (cop_dtl_seq > 4000 && cop_dtl_seq < 5999) { // ocean 구간 : vsk 검색
//			String vsl_cd = sceCopDtlVO.getVslCd();
//			String skd_voy_no = sceCopDtlVO.getSkdVoyNo();
//			String skd_dir_cd = sceCopDtlVO.getSkdDirCd();
//			String nod_cd = sceCopDtlVO.getNodCd();
//			
//			// vvd 와 act_rcv_tp_cd = 2, nod_cd (1순위) or port_cd (2순위) clpt_ind_seq
//			
//			
//		}
//		
//	}
}