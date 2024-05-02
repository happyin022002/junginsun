/**
 * Copyright(c) 2012 CyberLogitec
 * @FileName : ACMSimulationBCImpl.java
 * @FileTitle : ACMSimulationBCImpl
 * Open Issues :
 * Change history :
 * @LastModifyDate : 2015.08.05
 * @LastModifier : Sang-Hyun Kim
 * @LastVersion : 1.2
 * 2012.04.09 김상수 1.0 Creation.
 * ---------------------------------------------
 * History
 * 2012.12.21 김봉균 [CHM-201221923] ACM/ Simulation 계산 로직 고도화
 * 2014.06.03 박다은 [CHM-201430120] Agent Comm. Mass simulation 에 기능 추가
 * 2015.05.18 김상현 [CHM-201534767]대리점비 공제로직 변경으로 인한 ACM 시스템 적용 (Own feederage 단가 테이블 로직 구성 하여 공제에 활용)
 * 2015.08.05 Sang-Hyun Kim 1.2 [CHM-201537067] Split01-[그룹사 표준 코드 시행] HJS 프로그램 대응 및 데이타 마이그레이션 작업 요청
 */
package com.hanjin.apps.alps.esm.acm.acmsimulation.acmsimulation.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.acm.acmsimulation.acmsimulation.integration.ACMSimulationDBDAO;
import com.hanjin.apps.alps.esm.acm.acmsimulation.acmsimulation.vo.AGNCommMassSimVO;
import com.hanjin.apps.alps.esm.acm.acmsimulation.acmsimulation.vo.AGNCommSimulationVO;
import com.hanjin.apps.alps.esm.acm.acmsimulation.acmsimulation.vo.AgmtInfoVO;
import com.hanjin.apps.alps.esm.acm.acmsimulation.acmsimulation.vo.AgnReqCalCondVO;
import com.hanjin.apps.alps.esm.acm.acmsimulation.acmsimulation.vo.AgnReqRevInfoVO;
import com.hanjin.apps.alps.esm.acm.acmsimulation.acmsimulation.vo.BkgCreDtInfoVO;
import com.hanjin.apps.alps.esm.acm.acmsimulation.acmsimulation.vo.BkgNumberInfoVO;
import com.hanjin.apps.alps.esm.acm.acmsimulation.acmsimulation.vo.BkgQtyInfoVO;
import com.hanjin.apps.alps.esm.acm.acmsimulation.acmsimulation.vo.ChgAmtInfoVO;
import com.hanjin.apps.alps.esm.acm.acmsimulation.acmsimulation.vo.ChgAmtRtInfoVO;
import com.hanjin.apps.alps.esm.acm.acmsimulation.acmsimulation.vo.ChgInfoVO;
import com.hanjin.apps.alps.esm.acm.acmsimulation.acmsimulation.vo.OfficeCodeInfoVO;
import com.hanjin.apps.alps.esm.acm.acmsimulation.acmsimulation.vo.SaDtInfoVO;
import com.hanjin.apps.alps.esm.acm.acmsimulation.acmsimulation.vo.SearchAgreementVO;
import com.hanjin.apps.alps.esm.acm.acmsimulation.acmsimulation.vo.SimAgnRateDetailSubVO;
import com.hanjin.apps.alps.esm.acm.acmsimulation.acmsimulation.vo.SimAgnRateDetailVO;
import com.hanjin.apps.alps.esm.acm.acmsimulation.acmsimulation.vo.SimAgnRateMasterVO;
import com.hanjin.apps.alps.esm.acm.acmsimulation.acmsimulation.vo.SimulationNoVO;
import com.hanjin.apps.alps.esm.acm.acmsimulation.acmsimulation.vo.VslSvcLaneInfoVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-ACMSimulation Business Logic Command Interface<br>
 * - ALPS-ACMReques에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author KIM, Sang-Soo
 * @see Esm_Acm_0106Event,ACMSimulationBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class ACMSimulationBCImpl extends BasicCommandSupport implements ACMSimulationBC {

	// Database Access Object
	private transient ACMSimulationDBDAO dbDao = null;

	/**
	 * ACMSimulationBCImpl 객체 생성<br>
	 * ACMSimulationDBDAO를 생성한다.<br>
	 */
	public ACMSimulationBCImpl() {
		dbDao = new ACMSimulationDBDAO();
	}

	/**
	 * [ESM_ACM_0106]
	 * Agreement Search화면의 Actual Agreement 목록을 조회<br>
	 *
	 * @param SearchAgreementVO searchAgreementVO
	 * @return List<SearchAgreementVO>
	 * @exception EventException
	 */
	public List<SearchAgreementVO> searchActualAgreement(SearchAgreementVO searchAgreementVO) throws EventException {
		try {
			return dbDao.searchActualAgreement(searchAgreementVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_ACM_0106]
	 * Agreement Search화면의 Simulation Agreement 목록을 조회<br>
	 *
	 * @param SearchAgreementVO searchAgreementVO
	 * @return List<SearchAgreementVO>
	 * @exception EventException
	 */
	public List<SearchAgreementVO> searchSimulationAgreement(SearchAgreementVO searchAgreementVO) throws EventException {
		try {
			return dbDao.searchSimulationAgreement(searchAgreementVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_ACM_0010]
	 * Agent Commission Simulation 목록을 조회<br>
	 *
	 * @param AGNCommSimulationVO agnCommSimulationVO
	 * @return List<AGNCommSimulationVO>
	 * @exception EventException
	 */
	public List<AGNCommSimulationVO> searchAGNCommSimulation(AGNCommSimulationVO agnCommSimulationVO) throws EventException {
		try {
			return dbDao.searchAGNCommSimulation(agnCommSimulationVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * [ESM_ACM_0010]
	 * Agent Commission Simulation 결과 목록을 조회<br>
	 *
	 * @param AGNCommSimulationVO agnCommSimulationVO
	 * @return List<AGNCommSimulationVO>
	 * @exception EventException
	 */
	public List<AGNCommSimulationVO> searchAGNCommSimulationResult(AGNCommSimulationVO agnCommSimulationVO) throws EventException {
		try {
			return dbDao.searchAGNCommSimulationResult(agnCommSimulationVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * [ESM_ACM_0010]
	 * New Simulation No. 를 조회<br>
	 *
	 * @return String
	 * @exception EventException
	 */
	public String getNewSimulationNo() throws EventException {
		try {
			return dbDao.getNewSimulationNo();
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * [ESM_ACM_0010]
	 * Simulation No. Max 값 조회<br>
	 *
	 * @return String
	 * @exception EventException
	 */
	public String getMaxSimulationNo() throws EventException {
		try {
			return dbDao.getMaxSimulationNo();
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_ACM_0010] Start Simulation<br>
	 * Simulation Info. 저장<br>
	 *
	 * @param SimulationNoVO simulationNoVO
	 * @exception EventException
	 */
	public void addAcmSimInfo(SimulationNoVO simulationNoVO) throws EventException {
		try {
			dbDao.addAcmSimInfo(simulationNoVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * [ESM_ACM_0010] Start Simulation<br>
	 * Agent Commission Simulation 화면의 Start Simulation 버튼 이벤트<br>
	 *
	 * @param String bkgNo
	 * @param String usrId
	 * @param String simNo
	 * @exception EventException
	 */
	public void simulateAGNCommSimulation(String bkgNo, String usrId, String simNo) throws EventException {
		List<AgmtInfoVO> agmtInfoList = null;

		BkgNumberInfoVO bkgNumberVO = null;
		BkgQtyInfoVO bkgQtyInfoVO = null;
		BkgCreDtInfoVO bkgCreDtInfoVO = null;
		SaDtInfoVO saDtInfoVO = null;
		ChgAmtInfoVO chgAmtInfoVO = null;
		OfficeCodeInfoVO officeCodeInfoVO = null;
		OfficeCodeInfoVO ofcInfoVO = null;
		AgnReqRevInfoVO blRevInfoVO = null;
		AgnReqRevInfoVO strcRevInfoVO = null;
		AgnReqRevInfoVO cafRevInfoVO = null;
		ChgInfoVO chgInfoVO1 = null;
		ChgInfoVO chgInfoVO2 = null;
		VslSvcLaneInfoVO vslSvcLaneInfoVO = null;

		StringBuffer commProcRsltRsn = new StringBuffer();
//		String calcNo 			= null;
		String reCalcFlg 		= "Y";
		String bdrFlg 			= null;
		String blCvrdTpCd 		= null;

		String mstBkgNo 		= null;

		String bkgCreDt			= null;
		String svcScpCd         = null;
		String revMon 			= null;
		String rtAplyDt 		= null;

		String obSaDt           = null;
		String obVvd            = null;
		String obVslCd          = null;
		String obSkdVoyNo       = null;
		String obSkdDirCd       = null;
		String obPort           = null;
		String obSlanCd         = null;
		String obRlaneCd        = null;
		String obRevDirCd       = null;
		String ibSaDt           = null;
		String ibVvd            = null;
		String ibVslCd          = null;
		String ibSkdVoyNo       = null;
		String ibSkdDirCd       = null;
		String ibPort           = null;
		String ibSlanCd         = null;
		String ibRlaneCd        = null;
		String ibRevDirCd       = null;

		String ppdOfrtAmt       = null;
		String ppdChgAmt        = null;
		String cltOfrtAmt       = null;
		String cltChgAmt        = null;
		String masCoaFlg		= null;

		try {
			log.debug("===================== simulateAGNCommSimulation Start bkgNo, simNo : "+bkgNo+", "+simNo+" =====================");

//			//GET_CALC_NO
//			calcNo = dbDao.getCalcNo();
//			log.debug("calcNo : " + calcNo);
			//GET_BKG_NUMBER
			masCoaFlg = dbDao.getMasCoaFlg(bkgNo);

			bkgNumberVO = dbDao.getBkgNumber(bkgNo);
			if(bkgNumberVO != null) {
				mstBkgNo = bkgNumberVO.getMstBkgNo();
				blCvrdTpCd = bkgNumberVO.getBlCvrdTpCd();
				log.debug("bkgStsCd : " + bkgNumberVO.getBkgStsCd() + " / mstBkgNo : " + mstBkgNo);
				if("X".equals(bkgNumberVO.getBkgStsCd())) {
					AgnReqCalCondVO agnCondVO = new AgnReqCalCondVO();
					agnCondVO.setSimNo(simNo);
//					agnCondVO.setCalcNo(calcNo);
					agnCondVO.setUsrId(usrId);
					if(!"".equals(mstBkgNo)) {
						agnCondVO.setBkgNo(mstBkgNo);
						dbDao.modifyAcmSimBkgInfo(agnCondVO);
//						dbDao.removeAcmSimComm(mstBkgNo);
//						dbDao.modifyAcmSimCommZeroSum(agnCondVO); //추가변경
					} else {
						agnCondVO.setBkgNo(bkgNo);
						dbDao.modifyAcmSimBkgInfo(agnCondVO);
//						dbDao.removeAcmSimComm(bkgNo);
//						dbDao.modifyAcmSimCommZeroSum(agnCondVO); //추가변경
					}
					return;
				}
			}

			
//			//해당 Bkg No. 의 데이터를 삭제
//			dbDao.removeAcmSimCommByBkgNo(mstBkgNo);
			//ACM_AGN_COMM의 데이터를 ACM_SIM_COMM에 넣기
//			dbDao.addAcmSimCommFromAgnComm(mstBkgNo, simNo); //추가변경

			//GET_BKG_BDR_FLG
			bdrFlg = dbDao.getBkgBdrFlg(mstBkgNo);
			log.debug("bdrFlg : " + bdrFlg);
			//GET_BKG_QTY
			bkgQtyInfoVO = dbDao.getBkgQty(mstBkgNo);
			log.debug("bkgQtyInfoVO.getBox() : " + bkgQtyInfoVO.getBox());
			if(bkgQtyInfoVO.getBox() == null || "".equals(bkgQtyInfoVO.getBox())) {
				commProcRsltRsn.append("QTY_is_Null ");
			}

			if("C".equals(blCvrdTpCd)) {
				AgnReqCalCondVO blCvrpTpVO = new AgnReqCalCondVO();
				blCvrpTpVO.setSimNo(simNo);
//				blCvrpTpVO.setCalcNo(calcNo);
				blCvrpTpVO.setUsrId(usrId);
				blCvrpTpVO.setBkgNo(bkgNo);
				dbDao.modifyAcmSimBkgInfo(blCvrpTpVO);
//				dbDao.removeAcmSimComm(bkgNo, simNo); //추가변경
//				dbDao.modifyAcmSimCommZeroSum(blCvrpTpVO); //추가변경
			}
			//GET_BKG_CRE_DT
			bkgCreDtInfoVO = dbDao.getBkgCreDt(mstBkgNo);
			if(bkgCreDtInfoVO != null) {
				bkgCreDt = bkgCreDtInfoVO.getBkgCreDt();
//				bkgStsCd = bkgCreDtInfoVO.getBkgStsCd();
				svcScpCd = bkgCreDtInfoVO.getSvcScpCd();
			}

			//GET_REV_MON
			revMon = dbDao.getRevMon(mstBkgNo);
			if(revMon == null || "".equals(revMon)) {
				commProcRsltRsn.append("REV_MON_is_Null ");
			}
			//GET_RT_APLY_DT
			rtAplyDt = dbDao.getRtAplyDt(mstBkgNo);
			if(rtAplyDt == null || "".equals(rtAplyDt)) {
				commProcRsltRsn.append("RT_APLY_DT_is_Null ");
			}
			//GET_SA_DT	//
			saDtInfoVO = dbDao.getSaDt(mstBkgNo);
			if(saDtInfoVO != null) {
				obSaDt = saDtInfoVO.getObSaDt();
				obVvd = saDtInfoVO.getObVvd();
				obVslCd = saDtInfoVO.getObVslCd();
				obSkdVoyNo = saDtInfoVO.getObSkdVoyNo();
				obSkdDirCd = saDtInfoVO.getObSkdDirCd();
				obPort = saDtInfoVO.getObPort();
				obSlanCd = saDtInfoVO.getObSlanCd();
				obRlaneCd = saDtInfoVO.getObRlaneCd();
				obRevDirCd = saDtInfoVO.getObRevDirCd();
				ibSaDt = saDtInfoVO.getIbSaDt();
				ibVvd = saDtInfoVO.getIbVvd();
				ibVslCd = saDtInfoVO.getIbVslCd();
				ibSkdVoyNo = saDtInfoVO.getIbSkdVoyNo();
				ibSkdDirCd = saDtInfoVO.getIbSkdDirCd();
				ibPort = saDtInfoVO.getIbPort();
				ibSlanCd = saDtInfoVO.getIbSlanCd();
				ibRlaneCd = saDtInfoVO.getIbRlaneCd();
				ibRevDirCd = saDtInfoVO.getIbRevDirCd();
			}
			log.debug("BKG_NO:"+mstBkgNo+" - "+obSaDt+" - "+ibSaDt+" - "+bkgCreDt+" - "+revMon+" - "+rtAplyDt+" -->obsa-ibsa-cre-revmon-rtaply");
			log.debug("BKG_NO:"+mstBkgNo+" - "+obVvd+" - "+obPort+" - "+obSlanCd+" - "+obRlaneCd+" - "+obRevDirCd+" -->ob");
			log.debug("BKG_NO:"+mstBkgNo+" - "+ibVvd+" - "+ibPort+" - "+ibSlanCd+" - "+ibRlaneCd+" - "+ibRevDirCd+" -->ib");

			if(obSaDt == null || "".equals(obSaDt)) {
				commProcRsltRsn.append("VSL_SKD_is_Null ");
			}
			//GET_CHG_AMT
			chgAmtInfoVO = dbDao.getChgAmt(mstBkgNo,rtAplyDt);
			if(chgAmtInfoVO != null) {
				log.debug("chgAmtInfoVO => "+chgAmtInfoVO.toString());
				ppdOfrtAmt   = chgAmtInfoVO.getPpdOfrtAmt();
				ppdChgAmt    = chgAmtInfoVO.getPpdChgAmt();
				cltOfrtAmt   = chgAmtInfoVO.getCltOfrtAmt();
				cltChgAmt    = chgAmtInfoVO.getCltChgAmt();
			}
			log.debug("BKG_NO:"+mstBkgNo+" - AMT - "+ppdOfrtAmt+" - "+ppdChgAmt+" - "+cltOfrtAmt+" - "+cltChgAmt);

			//SEARCH_OFFICE_CODE
			officeCodeInfoVO = dbDao.getOfficeCode(mstBkgNo);//getOfficeInfo
			log.debug("officeCodeInfoVO => " + officeCodeInfoVO.toString());
			if(officeCodeInfoVO.getBkgOfcCd() == null || "".equals(officeCodeInfoVO.getBkgOfcCd())) {
				commProcRsltRsn.append("OFC_Info_is_Null ");
			}
			officeCodeInfoVO.setSimNo(simNo);
			officeCodeInfoVO.setCommProcRsltRsn(commProcRsltRsn.toString());
			officeCodeInfoVO.setPpdOfrtAmt(ppdOfrtAmt);
			officeCodeInfoVO.setPpdChgAmt(ppdChgAmt);
			officeCodeInfoVO.setCltOfrtAmt(cltOfrtAmt);
			officeCodeInfoVO.setCltChgAmt(cltChgAmt);
			officeCodeInfoVO.setUsrId(usrId);
			

			/** DELETE DATA */
			//DELETE ACM_SIM_BKG_INFO
			dbDao.removeAcmSimBkgInfo(mstBkgNo, simNo);
			//DELETE ACM_SIM_COMM_DTL
			dbDao.removeAcmSimCommDtl(mstBkgNo, simNo);
			//DELETE ACM_SIM_COMM
			dbDao.removeAcmSimComm(mstBkgNo, simNo); //추가변경
			//DELETE ACM_SIM_COMM_CHG
			dbDao.removeAcmSimCommChg(mstBkgNo, simNo);
			//DELETE ACM_SIM_COMM_REV
			dbDao.removeAcmSimCommRev(mstBkgNo, simNo);
			//DELETE ACM_SIM_COMM_TRSP
			dbDao.removeAcmSimCommTrsp(mstBkgNo, simNo);

			//Agreement 와 비교하기 위한 데이터 (ACM_SIM_COMM)
//			List<AgmtInfoVO> zeroSumList = dbDao.getZeroSumObjList(mstBkgNo, usrId, simNo); //추가변경

			AgnReqCalCondVO condVO = new AgnReqCalCondVO();
			condVO.setSimNo(simNo);
			condVO.setBkgNo(mstBkgNo);
//			condVO.setCalcNo(calcNo);
			condVO.setUsrId(usrId);
			//INSERT INTO ACM_SIM_BKG_INFO
			dbDao.addAcmSimBkgInfo(officeCodeInfoVO);

			//SEARCH_AGMT_NO
			AgnReqCalCondVO agnReqCalCondVO = new AgnReqCalCondVO();
			agnReqCalCondVO.setBkgNo(mstBkgNo);
			agnReqCalCondVO.setObSaDt(obSaDt);
			agnReqCalCondVO.setIbSaDt(ibSaDt);
			agnReqCalCondVO.setBkgCreDt(bkgCreDt);
			agnReqCalCondVO.setRevMon(revMon);

			agmtInfoList = dbDao.getAgmtInfo(agnReqCalCondVO);
			log.debug("agmtInfoList.size() => "+ agmtInfoList.size());
			log.debug("agmtInfoList => "+ agmtInfoList.toString());

			for(int i=0; i<agmtInfoList.size(); i++) {
				String saDt 	= null;
				String port 	= null;
				String slanCd	= null;
				String rlaneCd	= null;
				String vslCd 	= null;
				String skdVoyNo = null;
				String skdDirCd = null;
				String revDirCd = null;

				String hlgDdctOrgFlg   = null; // H OB
				String hlgDdctDestFlg  = null; // H IB
				String fdrgDdctOrgFlg  = null; // F OB
				String fdrgDdctDestFlg = null; // F IB

				String commPayTermCd	= null;

				String payXchRt 	 = null;

				double ppdOftAmt         = 0;
				double ppdOthAmt         = 0;
				double cctOftAmt         = 0;
				double cctOthAmt         = 0;
				double ppdCafAmt         = 0;
				double cctCafAmt         = 0;
				double ttlRevAmt         = 0;
				double ppdStrcRev        = 0;
				double cctStrcRev        = 0;

				int ho               = 0;
				int hd               = 0;
				int fo               = 0;
				int fd               = 0;

				String maxAcSeq      = null;

				AgmtInfoVO agmtVO = agmtInfoList.get(i);
				log.debug("agmtInfoVO => "+ agmtVO.toString());
				commPayTermCd 	= agmtVO.getCommPayTermCd();
				hlgDdctOrgFlg   = agmtVO.getHlgDdctOrgFlg(); // H OB
				hlgDdctDestFlg  = agmtVO.getHlgDdctDestFlg(); // H IB
				fdrgDdctOrgFlg  = agmtVO.getFdrgDdctOrgFlg(); // F OB
				fdrgDdctDestFlg = agmtVO.getFdrgDdctDestFlg(); // F IB

				agmtVO.setSimNo(simNo);
				agmtVO.setBkgNo(mstBkgNo);
				agmtVO.setUsrId(usrId);
				agmtVO.setRtAplyDt(rtAplyDt);
				agmtVO.setBdrFlg(bdrFlg);
				agmtVO.setSvcScpCd(svcScpCd);
				agmtVO.setRevMon(revMon);
				agmtVO.setPpdOfrtAmt(ppdOfrtAmt);
				agmtVO.setPpdChgAmt(ppdChgAmt);
				agmtVO.setCltOfrtAmt(cltOfrtAmt);
				agmtVO.setCltChgAmt(cltChgAmt);

				agmtVO.setBox(bkgQtyInfoVO.getBox());
				agmtVO.setTeu(bkgQtyInfoVO.getTeu());
				agmtVO.setFeu(bkgQtyInfoVO.getFeu());
				agmtVO.setRbox(bkgQtyInfoVO.getRbox());
				agmtVO.setRteu(bkgQtyInfoVO.getRteu());
				agmtVO.setRfeu(bkgQtyInfoVO.getRfeu());

				
				log.debug("PayTermCd[comm]:"+agmtVO.getCommPayTermCd());
				if("C".equals(commPayTermCd)||"P".equals(commPayTermCd)) {
					String commPayTermMatCnt = "N";

					commPayTermMatCnt = dbDao.searchBkgChgOftTermMatCnt(agmtVO.getBkgNo(), commPayTermCd);
					log.debug("commPayTermMatCnt:"+commPayTermMatCnt);

					if("N".equals(commPayTermMatCnt)){
						continue;
					}
				}
				log.debug("PayTermCd[oft]:"+agmtVO.getOftPayTermCd());
				if("C".equals(agmtVO.getOftPayTermCd())||"P".equals(agmtVO.getOftPayTermCd())) {
					String oftTermMatCnt = "N";

					oftTermMatCnt = dbDao.searchBkgChgOftTermMatCnt(agmtVO.getBkgNo(), agmtVO.getOftPayTermCd());
					log.debug("oftTermMatCnt:"+oftTermMatCnt);
					if("N".equals(oftTermMatCnt)){
						continue;
					}
				}

//추가변경
				// 4개 컬럼 비교하여 같으면  zeroSum 갱신대상에서 제외
//				log.debug("zeroSumList.size() : "+zeroSumList.size());
//				for(int k=0; k<zeroSumList.size(); k++) {
//					AgmtInfoVO zeroSumVO = zeroSumList.get(k);
//					log.debug("zeroSumVO == "+ zeroSumVO.getBkgNo() +"/"+zeroSumVO.getAgnCd()+"/"+zeroSumVO.getIoBndCd()+"/"+zeroSumVO.getAcTpCd());
//					if( agmtVO.getBkgNo() != null && agmtVO.getAgnCd() != null && agmtVO.getIoBndCd() != null && agmtVO.getAcTpCd() != null
//							&& agmtVO.getBkgNo().equals(zeroSumVO.getBkgNo()) && agmtVO.getAgnCd().equals(zeroSumVO.getAgnCd())
//							&& agmtVO.getIoBndCd().equals(zeroSumVO.getIoBndCd()) && agmtVO.getAcTpCd().equals(zeroSumVO.getAcTpCd()) ) {
//						zeroSumList.remove(k);
//						break;
//					}
//				}
				

				//SELECT NVL(MAX(AC_SEQ),0) + 1
				maxAcSeq = dbDao.getMaxAcSeq(agmtVO);
				log.debug("maxAcSeq : "+maxAcSeq);
				agmtVO.setMaxAcSeq(maxAcSeq);

				log.debug("DUP_CHK_CNT:" + agmtVO.getDupChkCnt());
				if(this.stringToInt(agmtVO.getDupChkCnt()) <= 1) {
					if("S".equals(agmtVO.getAcTpCd())) {//IF(v_ac_tp_cd = 'S')
						saDt = agmtVO.getTsSaDt();
						port = agmtVO.getTsLoc();
						slanCd = agmtVO.getTsSlanCd();
						rlaneCd = agmtVO.getTsRlaneCd();
						vslCd = agmtVO.getTsVslCd();
						skdVoyNo = agmtVO.getTsSkdVoyNo();
						skdDirCd = agmtVO.getTsSkdDirCd();
						revDirCd = agmtVO.getTsRevDirCd();
					} else if("O".equals(agmtVO.getIoBndCd())) {//ELSIF(v_io_bnd_cd = 'O')
						saDt = obSaDt;
						port = obPort;
						slanCd = obSlanCd;
						rlaneCd = obRlaneCd;
						vslCd = obVslCd;
						skdVoyNo = obSkdVoyNo;
						skdDirCd = obSkdDirCd;
						revDirCd = obRevDirCd;
					} else {//
						saDt = ibSaDt;
						port = ibPort;
						slanCd = ibSlanCd;
						rlaneCd = ibRlaneCd;
						vslCd = ibVslCd;
						skdVoyNo = ibSkdVoyNo;
						skdDirCd = ibSkdDirCd;
						revDirCd = ibRevDirCd;
					}
					agmtVO.setSaDt(saDt);
					agmtVO.setPort(port);
					agmtVO.setSlanCd(slanCd);
					agmtVO.setRlaneCd(rlaneCd);
					agmtVO.setVslCd(vslCd);
					agmtVO.setSkdVoyNo(skdVoyNo);
					agmtVO.setSkdDirCd(skdDirCd);
					agmtVO.setRevDirCd(revDirCd);

					//로직 변경 ( OFC_CHR_CD가 3, 4 : AR_OFC_CD / 그 외 : AGN_CD  => 구분 없이 AR_OFC_CD ) 
					//GET_OFC_INFO
					ofcInfoVO = dbDao.getOfcInfo(agmtVO.getArOfcCd());
					agmtVO.setArOfcCd(ofcInfoVO.getArOfcCd());
					agmtVO.setApOfcCd(ofcInfoVO.getApOfcCd());
					agmtVO.setApCtrCd(ofcInfoVO.getApCtrCd());
					

					if("USD".equals(agmtVO.getOfcCurrCd())) {//IF (v_ofc_curr_cd = 'USD')
						payXchRt = "1";
					} else {//ELSIF ( v_ofc_curr_cd <> 'USD' AND v_xch_rt_div_lvl = 1 )
						payXchRt = dbDao.getPayXchRt(agmtVO);
					}
					agmtVO.setPayXchRt(payXchRt);

					log.debug("comm_rt : "+agmtVO.getCommRt());
					if(!"X".equals(agmtVO.getCommRt())) {//commRt != null
						log.debug("--> RATE BASE");
						log.debug("--> REVENUE");
						//(commFxAmt == null) => 0
						String commFxAmtFlg = agmtVO.getCommFxAmt();
						if("X".equals(commFxAmtFlg)) {
							agmtVO.setCommFxAmt("0");
						}
						
						//GET_BL_REV
						blRevInfoVO = dbDao.getBlRev(mstBkgNo, saDt);
						if(blRevInfoVO != null) {
							ppdOftAmt = this.stringToDouble(blRevInfoVO.getPpdOftAmt());
							ppdOthAmt = this.stringToDouble(blRevInfoVO.getPpdOthAmt());
							cctOftAmt = this.stringToDouble(blRevInfoVO.getCctOftAmt());
							cctOthAmt = this.stringToDouble(blRevInfoVO.getCctOthAmt());
						}
						log.debug("REV 초기 : "+ppdOftAmt+" - "+ppdOthAmt+" - "+cctOftAmt+" - "+cctOthAmt+" - "+ppdCafAmt+" - "+cctCafAmt);
						//GET_STRC_REV
						agmtVO.setBkgCreDt(bkgCreDt);
						strcRevInfoVO = dbDao.getStrcRev(agmtVO);
						if(strcRevInfoVO != null) {
							ppdStrcRev = this.stringToDouble(strcRevInfoVO.getPpdStrcRev());
							cctStrcRev = this.stringToDouble(strcRevInfoVO.getCctStrcRev());
						}

						// 2015.08.05 Sang-Hyun Kim [CHM-201537067] Split01-[그룹사 표준 코드 시행] HJS 프로그램 대응 및 데이타 마이그레이션 작업 요청
						if( ("O".equals(agmtVO.getIoBndCd()) && "G".equals(agmtVO.getAcTpCd()) && "BOMSC".equals(agmtVO.getAgnCd()) && "E".equals(officeCodeInfoVO.getDelContiCd())) //IF(   (v_io_bnd_cd = 'O' AND v_ac_tp_cd = 'G' AND v_agn_cd = 'BOMSC' AND v_del_conti_cd = 'E')
								|| ("I".equals(agmtVO.getIoBndCd()) && "G".equals(agmtVO.getAcTpCd()) && "BOMSC".equals(agmtVO.getAgnCd()) && "E".equals(officeCodeInfoVO.getPorContiCd())) ) {//or (v_io_bnd_cd = 'I' AND v_ac_tp_cd = 'G' AND v_agn_cd = 'BOMSC' AND v_por_conti_cd = 'E') )
							//GET_CAF_REV
							cafRevInfoVO = dbDao.getCafRev(agmtVO);
							if(cafRevInfoVO != null) {
								ppdCafAmt = this.stringToDouble(cafRevInfoVO.getPpdCafAmt());
								cctCafAmt = this.stringToDouble(cafRevInfoVO.getCctCafAmt());
							}

							if( (ppdCafAmt != 0 || cctCafAmt !=0) && "N".equals(agmtVO.getRevDivCd()) ) {//IF (v_ppd_caf_amt <> 0 or v_cct_caf_amt <> 0)
								if("P".equals(commPayTermCd)) {
									ppdOftAmt = ppdOftAmt + ppdCafAmt;
								} else if("C".equals(commPayTermCd)) {
									cctOftAmt = cctOftAmt + cctCafAmt;
								} else if("T".equals(commPayTermCd)) {
									ppdOftAmt = ppdOftAmt + ppdCafAmt;
									cctOftAmt = cctOftAmt + cctCafAmt;
								}
							}
							log.debug("      REV 2 CAF : "+ppdCafAmt+" - "+cctCafAmt);
						}

						if("N".equals(agmtVO.getRevDivCd())) {//IF( v_rev_div_cd = 'N' )
							ppdOthAmt = 0;
							cctOthAmt = 0;
						}
						if("P".equals(commPayTermCd)) {//IF( v_comm_pay_term_cd = 'P' )
							cctOftAmt = 0;
							cctOthAmt = 0;
						} else if("C".equals(commPayTermCd)) {//ELSIF( v_comm_pay_term_cd = 'C' )
							ppdOftAmt = 0;
							ppdOthAmt = 0;
						}
						ttlRevAmt = ppdOftAmt + ppdOthAmt + cctOftAmt + cctOthAmt + ppdStrcRev + cctStrcRev;
						log.debug("REV 최종 : "+ppdOftAmt+" - "+ppdOthAmt+" - "+cctOftAmt+" - "+cctOthAmt+" - "+ppdCafAmt+" - "+cctCafAmt+" - "
								+ppdStrcRev +" - "+ cctStrcRev+" TTL : "+ttlRevAmt +" --> pOft - pOth - cOft - cOth - pCaf - cCaf - pStrc - cStrc");
						agmtVO.setTtlRevAmt(ttlRevAmt+"");

						if(!"0".equals(agmtVO.getMatCntChg())) {//IF(v_mat_cnt_chg <> 0)
							log.info("Deduct Charge.");
							//DELETE ACM_SIM_COMM_CHG_REF
							dbDao.removeAcmSimCommChgRef(mstBkgNo, simNo);

							if (Integer.valueOf(saDt) < 20151101) {
								dbDao.addAcmSimCommChgRef(agmtVO);
								dbDao.addAcmSimCommChg(agmtVO);
							} else {
								dbDao.addAcmSimCommChgRefFromAutoRt(agmtVO);
								dbDao.addAcmSimCommChgFromAutoRt(agmtVO);
							}
						}

						String ownFdrgDdctOrgFlg = new String(fdrgDdctOrgFlg); // Own Feederage를 적용하기 위해 agreement 정보 저장
						String ownFdrgDdctDestFlg = new String(fdrgDdctDestFlg); // Own Feederage를 적용하기 위해 agreement 정보 저장
						if ("1".equals(agmtVO.getRnk1()) && ("Y".equals(hlgDdctOrgFlg) || "Y".equals(hlgDdctDestFlg) || "Y".equals(fdrgDdctOrgFlg) || "Y".equals(fdrgDdctDestFlg))) {
							log.debug("--> DDCT TRSP");
							chgInfoVO1 = dbDao.getChgInfo1(mstBkgNo);
							if (!"".equals(chgInfoVO1.getHo())) {
								ho = ho + this.stringToInt(chgInfoVO1.getHo());
								hd = hd + this.stringToInt(chgInfoVO1.getHd());
								fo = fo + this.stringToInt(chgInfoVO1.getFo());
								fd = fd + this.stringToInt(chgInfoVO1.getFd());
							}
							chgInfoVO2 = dbDao.getChgInfo2(mstBkgNo);
							if (!"".equals(chgInfoVO2.getHo())) {
								ho = ho + this.stringToInt(chgInfoVO2.getHo());
								hd = hd + this.stringToInt(chgInfoVO2.getHd());
								fo = fo + this.stringToInt(chgInfoVO2.getFo());
								fd = fd + this.stringToInt(chgInfoVO2.getFd());
							}

							vslSvcLaneInfoVO = dbDao.getVslSvcLaneInfo(mstBkgNo);

							if (ho != 0) {
								hlgDdctOrgFlg = "X";
							}
							if (hd != 0) {
								hlgDdctDestFlg = "X";
							}
							if (fo != 0 || "0".equals(vslSvcLaneInfoVO.getPreFeederCheck())) {
								fdrgDdctOrgFlg = "X";
							}
							if (fd != 0 || "0".equals(vslSvcLaneInfoVO.getPstFeederCheck())) {
								fdrgDdctDestFlg = "X";
							}
							agmtVO.setHlgDdctOrgFlg(hlgDdctOrgFlg);
							agmtVO.setHlgDdctDestFlg(hlgDdctDestFlg);
							agmtVO.setFdrgDdctOrgFlg(fdrgDdctOrgFlg);
							agmtVO.setFdrgDdctDestFlg(fdrgDdctDestFlg);
							log.debug("--> cnt = " + ho + "+" + hd + "+" + fo + "+" + fd);
							log.debug("--> ddct_flg = " + hlgDdctOrgFlg + "+" + hlgDdctDestFlg + "+" + fdrgDdctOrgFlg + "+" + fdrgDdctDestFlg + " >> HO HD FO FD" );

							if ("Y".equals(reCalcFlg)) {
								if ("COA".equals(masCoaFlg)) {
									dbDao.addAcmSimCommTrspFromCoa(agmtVO);
								} else {
									dbDao.addAcmSimCommTrsp(agmtVO);
								}
							}

							// [CHM-201534767]대리점비 공제로직 변경으로 인한 ACM 시스템 적용 (Own feederage 단가 테이블 로직 구성 하여 공제에 활용)
							// TRSP 비용 공제 예외 로직 적용, Agreement 내용 Check 후 Own Feederage 계산
							if ((fo == 0 && "Y".equals(ownFdrgDdctOrgFlg)) || (fd == 0 && "Y".equals(ownFdrgDdctDestFlg))) {
								if (fo == 0 && "Y".equals(ownFdrgDdctOrgFlg)) {
									agmtVO.setFdrgDdctOrgFlg("Y");
								}
								if (fd == 0 && "Y".equals(ownFdrgDdctDestFlg)) {
									agmtVO.setFdrgDdctDestFlg("Y");
								}
								dbDao.addAcmSimOtrFdrgDdctCSQL(agmtVO);
							}
						}

						//select Info
						ChgAmtRtInfoVO chgAmtRtInfoVO = dbDao.getChgAmtRtInfo(agmtVO);
						log.debug("chgAmtRtInfoVO => "+chgAmtRtInfoVO.toString());
						agmtVO.setCommRev(chgAmtRtInfoVO.getCommRev());
						agmtVO.setDdctSpcl(chgAmtRtInfoVO.getDdctSpcl());
						agmtVO.setDdctChg(chgAmtRtInfoVO.getDdctChg());
						agmtVO.setDdctTrs(chgAmtRtInfoVO.getDdctTrs());
						agmtVO.setCommAmt(chgAmtRtInfoVO.getCommAmt());
						agmtVO.setPpdCrntAmt(chgAmtRtInfoVO.getPpdCrntAmt());
						agmtVO.setPpdPayCrntAmt(chgAmtRtInfoVO.getPpdPayCrntAmt());

						//INSERT INTO ACM_SIM_COMM
						log.debug("===ACM_SIM_COMM Data of Rt===" + agmtVO.toString());
						dbDao.addAcmSimCommRt(agmtVO);
						// "0"으로 TABLE에 입력한 다음 단계에서 null 구분을 위해 "X"로 값 넣는다.
						if("X".equals(commFxAmtFlg)) {
							agmtVO.setCommFxAmt("X");
						}
					}//IF(v_comm_rt<>0)

					String commFxAmt = agmtVO.getCommFxAmt();
					log.debug("--> commFxAmt : " + commFxAmt);
//					if(commFxAmt != 0) {//IF(v_comm_fx_amt<>0)
					if(!"X".equals(commFxAmt)) {//commFxAmt != null
						log.debug("--> FIXED BASE");

						//(commRt == null) => 0
						if("X".equals(agmtVO.getCommRt())) {
							agmtVO.setCommRt("0");
						}

//						String comm = null;
						String usdFxComm = "0";
						String payFxComm = "0";
						
						String fxRealAmt = dbDao.getFxRealAmt(agmtVO);
						agmtVO.setFxRealAmt(fxRealAmt);
						if("USD".equals(agmtVO.getAgmtCurrCd()) && "USD".equals(agmtVO.getOfcCurrCd())) {//IF ( agmt_curr_cd == 'USD' ) 
							log.debug("--> fx curr_cd USD USD ");
							usdFxComm = fxRealAmt;
							payFxComm = fxRealAmt;
						} else if ("JPY".equals(agmtVO.getAgmtCurrCd()) && "JPY".equals(agmtVO.getOfcCurrCd())){
							log.debug("--> fx curr_cd JPY JPY ");
							
							//SELECT USD_LOCL_XCH_RT
							AgmtInfoVO commVO = dbDao.getLoclXchRtComm(agmtVO);
							usdFxComm = commVO.getUsdFxComm();
							payFxComm = fxRealAmt;
						} else if("USD".equals(agmtVO.getAgmtCurrCd()) && !"USD".equals(agmtVO.getOfcCurrCd())){
							log.debug("--> fx curr_cd USD !USD ");
							//SELECT USD_LOCL_XCH_RT
							AgmtInfoVO commVO = dbDao.getLoclXchRtComm(agmtVO);
							usdFxComm = fxRealAmt;
							if(commVO.getPayFxComm() == null){
								payFxComm = "0";			
							}else{
								payFxComm = commVO.getPayFxComm();			
							}
						}


						log.debug("usdFxComm: "+usdFxComm+" payFxComm: "+payFxComm);
						agmtVO.setUsdFxComm(usdFxComm);
						agmtVO.setPayFxComm(payFxComm);

						agmtVO.setTtlRevAmt(ttlRevAmt+"");

						ChgAmtRtInfoVO chgAmtRtInfoVO2 = dbDao.getChgAmtRtInfo(agmtVO);
						log.debug("chgAmtRtInfoVO2 => "+chgAmtRtInfoVO2.toString());
						agmtVO.setCommRev(chgAmtRtInfoVO2.getCommRev());
						agmtVO.setDdctSpcl(chgAmtRtInfoVO2.getDdctSpcl());
						agmtVO.setDdctChg(chgAmtRtInfoVO2.getDdctChg());
						agmtVO.setDdctTrs(chgAmtRtInfoVO2.getDdctTrs());
						agmtVO.setCommAmt(chgAmtRtInfoVO2.getCommAmt());
						agmtVO.setPpdCrntAmt(chgAmtRtInfoVO2.getPpdCrntAmt());
						agmtVO.setPpdPayCrntAmt(chgAmtRtInfoVO2.getPpdPayCrntAmt());

						//INSERT INTO ACM_SIM_COMM
						log.debug("===ACM_SIM_COMM Data of Fx===" + agmtVO.toString());
						dbDao.addAcmSimCommFx(agmtVO);
					}//if(!"X".equals(commFxAmt)) {

				}//if(Integer.parseInt(agmtVO.getDupChkCnt()) <= 1) {
			}//for(int i=0; i<agmtInfoList.size(); i++) {

//추가변경
//			log.debug("zeroSumList Cnt: "+ zeroSumList.size());
//			//Agreement 에 존재하지 않는 건에 대해서 데이터 갱신
//			dbDao.modifyAcmSimCommZeroSum2(zeroSumList);
			
			//INSERT INTO ACM_SIM_COMM_DTL
			dbDao.addAcmSimCommDtl(condVO);
			
			log.debug("===================== simulateAGNCommSimulation End =====================");

		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_ACM_0011-01 / ESM_ACM_0011-03 / ESM_ACM_0115]
	 * [Master]탭 / [Summary]탭 - Master 목록을 조회<br>
	 *
	 * @param SimAgnRateMasterVO simAgnRateMasterVO
	 * @return List<SimAgnRateMasterVO>
	 * @exception EventException
	 */
	public List<SimAgnRateMasterVO> searchSimAgnRateMaster(SimAgnRateMasterVO simAgnRateMasterVO) throws EventException {
		try {
			return dbDao.searchSimAgnRateMaster(simAgnRateMasterVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_ACM_0011-01]
	 * [Master]탭 목록을 저장<br>
	 *
	 * @param SimAgnRateMasterVO[] simAgnRateMasterVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageSimAgnRateMaster(SimAgnRateMasterVO[] simAgnRateMasterVOs, SignOnUserAccount account) throws EventException {
		try {
			List<SimAgnRateMasterVO> insertVoList = new ArrayList<SimAgnRateMasterVO>();
			List<SimAgnRateMasterVO> updateVoList = new ArrayList<SimAgnRateMasterVO>();
			for (int i=0; i<simAgnRateMasterVOs.length; i++) {
				// ACM_AGN_AGMT_MST 테이블에서 AGN_FM_DT, AGN_TO_DT로 중복 체크 - DATE_ERR_CHK에 Y가 나오면 Err
				if ("Y".equals(dbDao.getDupDataFromAcmAgmAgmtMstInfo(simAgnRateMasterVOs[i]).get(0).getDateErrChk())) {
					// [ACM00004] - $s is duplicated. Please check $s again!
					throw new EventException(new ErrorHandler("ACM00004", new String[]{"Effective date of  [" + simAgnRateMasterVOs[i].getAgnCd() + "]", "effective date or office information"}).getMessage());
				}

				simAgnRateMasterVOs[i].setUsrId(account.getUsr_id());
				if (simAgnRateMasterVOs[i].getIbflag().equals("I")) {
					insertVoList.add(simAgnRateMasterVOs[i]);
				} else {
					updateVoList.add(simAgnRateMasterVOs[i]);
				}
			}

			if (insertVoList.size() > 0) {
				dbDao.addSimAgnRateMaster(insertVoList);
			}
			if (updateVoList.size() > 0) {
				dbDao.modifySimAgnRateMaster(updateVoList);
			}

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_ACM_0011-02 / ESM_ACM_0011-03]
	 * [Detail]탭 - Compensation Master / [Summary]탭 - Detail 목록을 조회<br>
	 *
	 * @param SimAgnRateMasterVO simAgnRateMasterVO
	 * @return List<SimAgnRateDetailVO>
	 * @exception EventException
	 */
	public List<SimAgnRateDetailVO> searchSimAgnRateDetail(SimAgnRateMasterVO simAgnRateMasterVO) throws EventException {
		try {
			return dbDao.searchSimAgnRateDetail(simAgnRateMasterVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_ACM_0011-02]
	 * [Detail]탭 - Compensation Master 목록을 저장<br>
	 *
	 * @param SimAgnRateDetailVO[] simAgnRateDetailVOs
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageSimAgnRateDetail(SimAgnRateDetailVO[] simAgnRateDetailVOs, SignOnUserAccount account) throws EventException {
		try {
			List<SimAgnRateDetailVO> insertVoList = new ArrayList<SimAgnRateDetailVO>();
			List<SimAgnRateDetailVO> updateVoList = new ArrayList<SimAgnRateDetailVO>();
			List<SimAgnRateDetailVO> deleteVoList = new ArrayList<SimAgnRateDetailVO>();

			List<SimAgnRateDetailSubVO> subDeleteVoList = new ArrayList<SimAgnRateDetailSubVO>();
			List<SimAgnRateDetailSubVO> subInsertCntrVoList = new ArrayList<SimAgnRateDetailSubVO>();
			List<SimAgnRateDetailSubVO> subInsertRoutVoList = new ArrayList<SimAgnRateDetailSubVO>();
			List<SimAgnRateDetailSubVO> subInsertChgVoList = new ArrayList<SimAgnRateDetailSubVO>();

			for (int i=0; i<simAgnRateDetailVOs.length; i++) {
				// DETAIL용 VO setting
				simAgnRateDetailVOs[i].setUsrId(account.getUsr_id());
				if ("F".equals(simAgnRateDetailVOs[i].getRateDiv())) {
					simAgnRateDetailVOs[i].setCommPayTermCd("");
					simAgnRateDetailVOs[i].setRevDivCd("");
					simAgnRateDetailVOs[i].setCommRt("");
				} else {
					simAgnRateDetailVOs[i].setCntrTpszCd("");
					simAgnRateDetailVOs[i].setFullMtyCd("");
					simAgnRateDetailVOs[i].setCurrCd("");
					simAgnRateDetailVOs[i].setCommFxAmt("");
				}

				if ("I".equals(simAgnRateDetailVOs[i].getIbflag())) {
					// 현재 insert는 한row만 허용하므로 가능
					String agnAgmtSeq = dbDao.getAgnAgmtSeqInfo(simAgnRateDetailVOs[i]).get(0).getAgnAgmtSeq();
					simAgnRateDetailVOs[i].setAgnAgmtSeq(agnAgmtSeq);
					insertVoList.add(simAgnRateDetailVOs[i]);
				} else if ("U".equals(simAgnRateDetailVOs[i].getIbflag())) {
						updateVoList.add(simAgnRateDetailVOs[i]);
				} else if ("D".equals(simAgnRateDetailVOs[i].getIbflag())) {
					deleteVoList.add(simAgnRateDetailVOs[i]);
				}
				// CNTR_TPSZ_CD, ROUTE, REP_CHG_CD, CHG_CD 각 해당 테이블용 VO setting
				// (Insert, Update일 경우도 각 해당 테이블에 delete후 insert로 진행)
				SimAgnRateDetailSubVO simAgnRateDetailSubVO = new SimAgnRateDetailSubVO();
				simAgnRateDetailSubVO.setAgnCd(simAgnRateDetailVOs[i].getAgnCd());
				simAgnRateDetailSubVO.setAgnAgmtNo(simAgnRateDetailVOs[i].getAgnAgmtNo());
				simAgnRateDetailSubVO.setIoBndCd(simAgnRateDetailVOs[i].getIoBndCd());
				simAgnRateDetailSubVO.setAcTpCd(simAgnRateDetailVOs[i].getAcTpCd());
				simAgnRateDetailSubVO.setAgnAgmtSeq(simAgnRateDetailVOs[i].getAgnAgmtSeq());
				simAgnRateDetailSubVO.setUsrId(account.getUsr_id());
				subDeleteVoList.add(simAgnRateDetailSubVO);

				if ("I".equals(simAgnRateDetailVOs[i].getIbflag()) || "U".equals(simAgnRateDetailVOs[i].getIbflag())) {
					// CNTR_TPSZ_CD insertVoList setting
					if (!"".equals(simAgnRateDetailVOs[i].getCntrTpszCd())) {
						String[] cntrTpszCdArr = simAgnRateDetailVOs[i].getCntrTpszCd().split(",");
						for (int k=0; k<cntrTpszCdArr.length; k++) {
							SimAgnRateDetailSubVO simAgnRateDetailCntrVO = new SimAgnRateDetailSubVO();
							// 반드시 컬럼 하나씩 복사(simAgnRateDetailSubVO를 그대로 복사하지 말것)
							simAgnRateDetailCntrVO.setAgnCd(simAgnRateDetailVOs[i].getAgnCd());
							simAgnRateDetailCntrVO.setAgnAgmtNo(simAgnRateDetailVOs[i].getAgnAgmtNo());
							simAgnRateDetailCntrVO.setIoBndCd(simAgnRateDetailVOs[i].getIoBndCd());
							simAgnRateDetailCntrVO.setAcTpCd(simAgnRateDetailVOs[i].getAcTpCd());
							simAgnRateDetailCntrVO.setAgnAgmtSeq(simAgnRateDetailVOs[i].getAgnAgmtSeq());
							simAgnRateDetailCntrVO.setAgnAgmtCntrSeq(Integer.toString(k + 1));
							simAgnRateDetailCntrVO.setCntrTpszCd(cntrTpszCdArr[k]);
							simAgnRateDetailCntrVO.setUsrId(account.getUsr_id());
							subInsertCntrVoList.add(simAgnRateDetailCntrVO);
						}
					}

					// ROUTE insertVoList setting
					int routSeq = 0;
					// por_1
					if (!"".equals(simAgnRateDetailVOs[i].getPor1())) {
						String[] por1Arr = simAgnRateDetailVOs[i].getPor1().split(",");
						for (int k=0; k<por1Arr.length; k++) {
							SimAgnRateDetailSubVO simAgnRateDetailPorVO = new SimAgnRateDetailSubVO();
							// 반드시 컬럼 하나씩 복사(simAgnRateDetailSubVO를 그대로 복사하지 말것)
							simAgnRateDetailPorVO.setAgnCd(simAgnRateDetailVOs[i].getAgnCd());
							simAgnRateDetailPorVO.setAgnAgmtNo(simAgnRateDetailVOs[i].getAgnAgmtNo());
							simAgnRateDetailPorVO.setIoBndCd(simAgnRateDetailVOs[i].getIoBndCd());
							simAgnRateDetailPorVO.setAcTpCd(simAgnRateDetailVOs[i].getAcTpCd());
							simAgnRateDetailPorVO.setAgnAgmtSeq(simAgnRateDetailVOs[i].getAgnAgmtSeq());
							simAgnRateDetailPorVO.setAgnAgmtRoutSeq(Integer.toString(routSeq++));
							simAgnRateDetailPorVO.setRoutRefDivCd("PORV");
							simAgnRateDetailPorVO.setRoutLvlCd("1");
							simAgnRateDetailPorVO.setRoutInfoCd(por1Arr[k]);
							simAgnRateDetailPorVO.setUsrId(account.getUsr_id());
							subInsertRoutVoList.add(simAgnRateDetailPorVO);
						}
					}
					// por_2
					if (!"".equals(simAgnRateDetailVOs[i].getPor2())) {
						String[] por2Arr = simAgnRateDetailVOs[i].getPor2().split(",");
						for (int k=0; k<por2Arr.length; k++) {
							SimAgnRateDetailSubVO simAgnRateDetailPorVO = new SimAgnRateDetailSubVO();
							// 반드시 컬럼 하나씩 복사(simAgnRateDetailSubVO를 그대로 복사하지 말것)
							simAgnRateDetailPorVO.setAgnCd(simAgnRateDetailVOs[i].getAgnCd());
							simAgnRateDetailPorVO.setAgnAgmtNo(simAgnRateDetailVOs[i].getAgnAgmtNo());
							simAgnRateDetailPorVO.setIoBndCd(simAgnRateDetailVOs[i].getIoBndCd());
							simAgnRateDetailPorVO.setAcTpCd(simAgnRateDetailVOs[i].getAcTpCd());
							simAgnRateDetailPorVO.setAgnAgmtSeq(simAgnRateDetailVOs[i].getAgnAgmtSeq());
							simAgnRateDetailPorVO.setAgnAgmtRoutSeq(Integer.toString(routSeq++));
							simAgnRateDetailPorVO.setRoutRefDivCd("PORV");
							simAgnRateDetailPorVO.setRoutLvlCd("2");
							simAgnRateDetailPorVO.setRoutInfoCd(por2Arr[k]);
							simAgnRateDetailPorVO.setUsrId(account.getUsr_id());
							subInsertRoutVoList.add(simAgnRateDetailPorVO);
						}
					}
					// por_3
					if (!"".equals(simAgnRateDetailVOs[i].getPor3())) {
						String[] por3Arr = simAgnRateDetailVOs[i].getPor3().split(",");
						for (int k=0; k<por3Arr.length; k++) {
							SimAgnRateDetailSubVO simAgnRateDetailPorVO = new SimAgnRateDetailSubVO();
							// 반드시 컬럼 하나씩 복사(simAgnRateDetailSubVO를 그대로 복사하지 말것)
							simAgnRateDetailPorVO.setAgnCd(simAgnRateDetailVOs[i].getAgnCd());
							simAgnRateDetailPorVO.setAgnAgmtNo(simAgnRateDetailVOs[i].getAgnAgmtNo());
							simAgnRateDetailPorVO.setIoBndCd(simAgnRateDetailVOs[i].getIoBndCd());
							simAgnRateDetailPorVO.setAcTpCd(simAgnRateDetailVOs[i].getAcTpCd());
							simAgnRateDetailPorVO.setAgnAgmtSeq(simAgnRateDetailVOs[i].getAgnAgmtSeq());
							simAgnRateDetailPorVO.setAgnAgmtRoutSeq(Integer.toString(routSeq++));
							simAgnRateDetailPorVO.setRoutRefDivCd("PORV");
							simAgnRateDetailPorVO.setRoutLvlCd("3");
							simAgnRateDetailPorVO.setRoutInfoCd(por3Arr[k]);
							simAgnRateDetailPorVO.setUsrId(account.getUsr_id());
							subInsertRoutVoList.add(simAgnRateDetailPorVO);
						}
					}
					// por_4
					if (!"".equals(simAgnRateDetailVOs[i].getPor4())) {
						String[] por4Arr = simAgnRateDetailVOs[i].getPor4().split(",");
						for (int k=0; k<por4Arr.length; k++) {
							SimAgnRateDetailSubVO simAgnRateDetailPorVO = new SimAgnRateDetailSubVO();
							// 반드시 컬럼 하나씩 복사(simAgnRateDetailSubVO를 그대로 복사하지 말것)
							simAgnRateDetailPorVO.setAgnCd(simAgnRateDetailVOs[i].getAgnCd());
							simAgnRateDetailPorVO.setAgnAgmtNo(simAgnRateDetailVOs[i].getAgnAgmtNo());
							simAgnRateDetailPorVO.setIoBndCd(simAgnRateDetailVOs[i].getIoBndCd());
							simAgnRateDetailPorVO.setAcTpCd(simAgnRateDetailVOs[i].getAcTpCd());
							simAgnRateDetailPorVO.setAgnAgmtSeq(simAgnRateDetailVOs[i].getAgnAgmtSeq());
							simAgnRateDetailPorVO.setAgnAgmtRoutSeq(Integer.toString(routSeq++));
							simAgnRateDetailPorVO.setRoutRefDivCd("PORV");
							simAgnRateDetailPorVO.setRoutLvlCd("4");
							simAgnRateDetailPorVO.setRoutInfoCd(por4Arr[k]);
							simAgnRateDetailPorVO.setUsrId(account.getUsr_id());
							subInsertRoutVoList.add(simAgnRateDetailPorVO);
						}
					}
					// POR
					if (!"".equals(simAgnRateDetailVOs[i].getPor())) {
						String[] porArr = simAgnRateDetailVOs[i].getPor().split(",");
						for (int k=0; k<porArr.length; k++) {
							SimAgnRateDetailSubVO simAgnRateDetailPorVO = new SimAgnRateDetailSubVO();
							// 반드시 컬럼 하나씩 복사(simAgnRateDetailSubVO를 그대로 복사하지 말것)
							simAgnRateDetailPorVO.setAgnCd(simAgnRateDetailVOs[i].getAgnCd());
							simAgnRateDetailPorVO.setAgnAgmtNo(simAgnRateDetailVOs[i].getAgnAgmtNo());
							simAgnRateDetailPorVO.setIoBndCd(simAgnRateDetailVOs[i].getIoBndCd());
							simAgnRateDetailPorVO.setAcTpCd(simAgnRateDetailVOs[i].getAcTpCd());
							simAgnRateDetailPorVO.setAgnAgmtSeq(simAgnRateDetailVOs[i].getAgnAgmtSeq());
							simAgnRateDetailPorVO.setAgnAgmtRoutSeq(Integer.toString(routSeq++));
							simAgnRateDetailPorVO.setRoutRefDivCd("POR");
							simAgnRateDetailPorVO.setRoutLvlCd(simAgnRateDetailVOs[i].getPorLvlCd());
							simAgnRateDetailPorVO.setRoutInfoCd(porArr[k]);
							simAgnRateDetailPorVO.setUsrId(account.getUsr_id());
							subInsertRoutVoList.add(simAgnRateDetailPorVO);
						}
					}
					// pol_1
					if (!"".equals(simAgnRateDetailVOs[i].getPol1())) {
						String[] pol1Arr = simAgnRateDetailVOs[i].getPol1().split(",");
						for (int k=0; k<pol1Arr.length; k++) {
							SimAgnRateDetailSubVO simAgnRateDetailPolVO = new SimAgnRateDetailSubVO();
							// 반드시 컬럼 하나씩 복사(simAgnRateDetailSubVO를 그대로 복사하지 말것)
							simAgnRateDetailPolVO.setAgnCd(simAgnRateDetailVOs[i].getAgnCd());
							simAgnRateDetailPolVO.setAgnAgmtNo(simAgnRateDetailVOs[i].getAgnAgmtNo());
							simAgnRateDetailPolVO.setIoBndCd(simAgnRateDetailVOs[i].getIoBndCd());
							simAgnRateDetailPolVO.setAcTpCd(simAgnRateDetailVOs[i].getAcTpCd());
							simAgnRateDetailPolVO.setAgnAgmtSeq(simAgnRateDetailVOs[i].getAgnAgmtSeq());
							simAgnRateDetailPolVO.setAgnAgmtRoutSeq(Integer.toString(routSeq++));
							simAgnRateDetailPolVO.setRoutRefDivCd("POLV");
							simAgnRateDetailPolVO.setRoutLvlCd("1");
							simAgnRateDetailPolVO.setRoutInfoCd(pol1Arr[k]);
							simAgnRateDetailPolVO.setUsrId(account.getUsr_id());
							subInsertRoutVoList.add(simAgnRateDetailPolVO);
						}
					}
					// pol_2
					if (!"".equals(simAgnRateDetailVOs[i].getPol2())) {
						String[] pol2Arr = simAgnRateDetailVOs[i].getPol2().split(",");
						for (int k=0; k<pol2Arr.length; k++) {
							SimAgnRateDetailSubVO simAgnRateDetailPolVO = new SimAgnRateDetailSubVO();
							// 반드시 컬럼 하나씩 복사(simAgnRateDetailSubVO를 그대로 복사하지 말것)
							simAgnRateDetailPolVO.setAgnCd(simAgnRateDetailVOs[i].getAgnCd());
							simAgnRateDetailPolVO.setAgnAgmtNo(simAgnRateDetailVOs[i].getAgnAgmtNo());
							simAgnRateDetailPolVO.setIoBndCd(simAgnRateDetailVOs[i].getIoBndCd());
							simAgnRateDetailPolVO.setAcTpCd(simAgnRateDetailVOs[i].getAcTpCd());
							simAgnRateDetailPolVO.setAgnAgmtSeq(simAgnRateDetailVOs[i].getAgnAgmtSeq());
							simAgnRateDetailPolVO.setAgnAgmtRoutSeq(Integer.toString(routSeq++));
							simAgnRateDetailPolVO.setRoutRefDivCd("POLV");
							simAgnRateDetailPolVO.setRoutLvlCd("2");
							simAgnRateDetailPolVO.setRoutInfoCd(pol2Arr[k]);
							simAgnRateDetailPolVO.setUsrId(account.getUsr_id());
							subInsertRoutVoList.add(simAgnRateDetailPolVO);
						}
					}
					// pol_3
					if (!"".equals(simAgnRateDetailVOs[i].getPol3())) {
						String[] pol3Arr = simAgnRateDetailVOs[i].getPol3().split(",");
						for (int k=0; k<pol3Arr.length; k++) {
							SimAgnRateDetailSubVO simAgnRateDetailPolVO = new SimAgnRateDetailSubVO();
							// 반드시 컬럼 하나씩 복사(simAgnRateDetailSubVO를 그대로 복사하지 말것)
							simAgnRateDetailPolVO.setAgnCd(simAgnRateDetailVOs[i].getAgnCd());
							simAgnRateDetailPolVO.setAgnAgmtNo(simAgnRateDetailVOs[i].getAgnAgmtNo());
							simAgnRateDetailPolVO.setIoBndCd(simAgnRateDetailVOs[i].getIoBndCd());
							simAgnRateDetailPolVO.setAcTpCd(simAgnRateDetailVOs[i].getAcTpCd());
							simAgnRateDetailPolVO.setAgnAgmtSeq(simAgnRateDetailVOs[i].getAgnAgmtSeq());
							simAgnRateDetailPolVO.setAgnAgmtRoutSeq(Integer.toString(routSeq++));
							simAgnRateDetailPolVO.setRoutRefDivCd("POLV");
							simAgnRateDetailPolVO.setRoutLvlCd("3");
							simAgnRateDetailPolVO.setRoutInfoCd(pol3Arr[k]);
							simAgnRateDetailPolVO.setUsrId(account.getUsr_id());
							subInsertRoutVoList.add(simAgnRateDetailPolVO);
						}
					}
					// pol_4
					if (!"".equals(simAgnRateDetailVOs[i].getPol4())) {
						String[] pol4Arr = simAgnRateDetailVOs[i].getPol4().split(",");
						for (int k=0; k<pol4Arr.length; k++) {
							SimAgnRateDetailSubVO simAgnRateDetailPolVO = new SimAgnRateDetailSubVO();
							// 반드시 컬럼 하나씩 복사(simAgnRateDetailSubVO를 그대로 복사하지 말것)
							simAgnRateDetailPolVO.setAgnCd(simAgnRateDetailVOs[i].getAgnCd());
							simAgnRateDetailPolVO.setAgnAgmtNo(simAgnRateDetailVOs[i].getAgnAgmtNo());
							simAgnRateDetailPolVO.setIoBndCd(simAgnRateDetailVOs[i].getIoBndCd());
							simAgnRateDetailPolVO.setAcTpCd(simAgnRateDetailVOs[i].getAcTpCd());
							simAgnRateDetailPolVO.setAgnAgmtSeq(simAgnRateDetailVOs[i].getAgnAgmtSeq());
							simAgnRateDetailPolVO.setAgnAgmtRoutSeq(Integer.toString(routSeq++));
							simAgnRateDetailPolVO.setRoutRefDivCd("POLV");
							simAgnRateDetailPolVO.setRoutLvlCd("4");
							simAgnRateDetailPolVO.setRoutInfoCd(pol4Arr[k]);
							simAgnRateDetailPolVO.setUsrId(account.getUsr_id());
							subInsertRoutVoList.add(simAgnRateDetailPolVO);
						}
					}
					// POL
					if (!"".equals(simAgnRateDetailVOs[i].getPol())) {
						String[] polArr = simAgnRateDetailVOs[i].getPol().split(",");
						for (int k=0; k<polArr.length; k++) {
							SimAgnRateDetailSubVO simAgnRateDetailPolVO = new SimAgnRateDetailSubVO();
							// 반드시 컬럼 하나씩 복사(simAgnRateDetailSubVO를 그대로 복사하지 말것)
							simAgnRateDetailPolVO.setAgnCd(simAgnRateDetailVOs[i].getAgnCd());
							simAgnRateDetailPolVO.setAgnAgmtNo(simAgnRateDetailVOs[i].getAgnAgmtNo());
							simAgnRateDetailPolVO.setIoBndCd(simAgnRateDetailVOs[i].getIoBndCd());
							simAgnRateDetailPolVO.setAcTpCd(simAgnRateDetailVOs[i].getAcTpCd());
							simAgnRateDetailPolVO.setAgnAgmtSeq(simAgnRateDetailVOs[i].getAgnAgmtSeq());
							simAgnRateDetailPolVO.setAgnAgmtRoutSeq(Integer.toString(routSeq++));
							simAgnRateDetailPolVO.setRoutRefDivCd("POL");
							simAgnRateDetailPolVO.setRoutLvlCd(simAgnRateDetailVOs[i].getPolLvlCd());
							simAgnRateDetailPolVO.setRoutInfoCd(polArr[k]);
							simAgnRateDetailPolVO.setUsrId(account.getUsr_id());
							subInsertRoutVoList.add(simAgnRateDetailPolVO);
						}
					}
					// pod_1
					if (!"".equals(simAgnRateDetailVOs[i].getPod())) {
						String[] podArr = simAgnRateDetailVOs[i].getPod().split(",");
						for (int k=0; k<podArr.length; k++) {
							SimAgnRateDetailSubVO simAgnRateDetailPodVO = new SimAgnRateDetailSubVO();
							// 반드시 컬럼 하나씩 복사(simAgnRateDetailSubVO를 그대로 복사하지 말것)
							simAgnRateDetailPodVO.setAgnCd(simAgnRateDetailVOs[i].getAgnCd());
							simAgnRateDetailPodVO.setAgnAgmtNo(simAgnRateDetailVOs[i].getAgnAgmtNo());
							simAgnRateDetailPodVO.setIoBndCd(simAgnRateDetailVOs[i].getIoBndCd());
							simAgnRateDetailPodVO.setAcTpCd(simAgnRateDetailVOs[i].getAcTpCd());
							simAgnRateDetailPodVO.setAgnAgmtSeq(simAgnRateDetailVOs[i].getAgnAgmtSeq());
							simAgnRateDetailPodVO.setAgnAgmtRoutSeq(Integer.toString(routSeq++));
							simAgnRateDetailPodVO.setRoutRefDivCd("PODV");
							simAgnRateDetailPodVO.setRoutLvlCd("1");
							simAgnRateDetailPodVO.setRoutInfoCd(podArr[k]);
							simAgnRateDetailPodVO.setUsrId(account.getUsr_id());
							subInsertRoutVoList.add(simAgnRateDetailPodVO);
						}
					}
					// pod_2
					if (!"".equals(simAgnRateDetailVOs[i].getPod())) {
						String[] podArr = simAgnRateDetailVOs[i].getPod().split(",");
						for (int k=0; k<podArr.length; k++) {
							SimAgnRateDetailSubVO simAgnRateDetailPodVO = new SimAgnRateDetailSubVO();
							// 반드시 컬럼 하나씩 복사(simAgnRateDetailSubVO를 그대로 복사하지 말것)
							simAgnRateDetailPodVO.setAgnCd(simAgnRateDetailVOs[i].getAgnCd());
							simAgnRateDetailPodVO.setAgnAgmtNo(simAgnRateDetailVOs[i].getAgnAgmtNo());
							simAgnRateDetailPodVO.setIoBndCd(simAgnRateDetailVOs[i].getIoBndCd());
							simAgnRateDetailPodVO.setAcTpCd(simAgnRateDetailVOs[i].getAcTpCd());
							simAgnRateDetailPodVO.setAgnAgmtSeq(simAgnRateDetailVOs[i].getAgnAgmtSeq());
							simAgnRateDetailPodVO.setAgnAgmtRoutSeq(Integer.toString(routSeq++));
							simAgnRateDetailPodVO.setRoutRefDivCd("PODV");
							simAgnRateDetailPodVO.setRoutLvlCd("2");
							simAgnRateDetailPodVO.setRoutInfoCd(podArr[k]);
							simAgnRateDetailPodVO.setUsrId(account.getUsr_id());
							subInsertRoutVoList.add(simAgnRateDetailPodVO);
						}
					}
					// pod_3
					if (!"".equals(simAgnRateDetailVOs[i].getPod3())) {
						String[] pod3Arr = simAgnRateDetailVOs[i].getPod3().split(",");
						for (int k=0; k<pod3Arr.length; k++) {
							SimAgnRateDetailSubVO simAgnRateDetailPodVO = new SimAgnRateDetailSubVO();
							// 반드시 컬럼 하나씩 복사(simAgnRateDetailSubVO를 그대로 복사하지 말것)
							simAgnRateDetailPodVO.setAgnCd(simAgnRateDetailVOs[i].getAgnCd());
							simAgnRateDetailPodVO.setAgnAgmtNo(simAgnRateDetailVOs[i].getAgnAgmtNo());
							simAgnRateDetailPodVO.setIoBndCd(simAgnRateDetailVOs[i].getIoBndCd());
							simAgnRateDetailPodVO.setAcTpCd(simAgnRateDetailVOs[i].getAcTpCd());
							simAgnRateDetailPodVO.setAgnAgmtSeq(simAgnRateDetailVOs[i].getAgnAgmtSeq());
							simAgnRateDetailPodVO.setAgnAgmtRoutSeq(Integer.toString(routSeq++));
							simAgnRateDetailPodVO.setRoutRefDivCd("PODV");
							simAgnRateDetailPodVO.setRoutLvlCd("3");
							simAgnRateDetailPodVO.setRoutInfoCd(pod3Arr[k]);
							simAgnRateDetailPodVO.setUsrId(account.getUsr_id());
							subInsertRoutVoList.add(simAgnRateDetailPodVO);
						}
					}
					// pod_4
					if (!"".equals(simAgnRateDetailVOs[i].getPod4())) {
						String[] pod4Arr = simAgnRateDetailVOs[i].getPod4().split(",");
						for (int k=0; k<pod4Arr.length; k++) {
							SimAgnRateDetailSubVO simAgnRateDetailPodVO = new SimAgnRateDetailSubVO();
							// 반드시 컬럼 하나씩 복사(simAgnRateDetailSubVO를 그대로 복사하지 말것)
							simAgnRateDetailPodVO.setAgnCd(simAgnRateDetailVOs[i].getAgnCd());
							simAgnRateDetailPodVO.setAgnAgmtNo(simAgnRateDetailVOs[i].getAgnAgmtNo());
							simAgnRateDetailPodVO.setIoBndCd(simAgnRateDetailVOs[i].getIoBndCd());
							simAgnRateDetailPodVO.setAcTpCd(simAgnRateDetailVOs[i].getAcTpCd());
							simAgnRateDetailPodVO.setAgnAgmtSeq(simAgnRateDetailVOs[i].getAgnAgmtSeq());
							simAgnRateDetailPodVO.setAgnAgmtRoutSeq(Integer.toString(routSeq++));
							simAgnRateDetailPodVO.setRoutRefDivCd("PODV");
							simAgnRateDetailPodVO.setRoutLvlCd("4");
							simAgnRateDetailPodVO.setRoutInfoCd(pod4Arr[k]);
							simAgnRateDetailPodVO.setUsrId(account.getUsr_id());
							subInsertRoutVoList.add(simAgnRateDetailPodVO);
						}
					}
					// POD
					if (!"".equals(simAgnRateDetailVOs[i].getPod())) {
						String[] podArr = simAgnRateDetailVOs[i].getPod().split(",");
						for (int k=0; k<podArr.length; k++) {
							SimAgnRateDetailSubVO simAgnRateDetailPodVO = new SimAgnRateDetailSubVO();
							// 반드시 컬럼 하나씩 복사(simAgnRateDetailSubVO를 그대로 복사하지 말것)
							simAgnRateDetailPodVO.setAgnCd(simAgnRateDetailVOs[i].getAgnCd());
							simAgnRateDetailPodVO.setAgnAgmtNo(simAgnRateDetailVOs[i].getAgnAgmtNo());
							simAgnRateDetailPodVO.setIoBndCd(simAgnRateDetailVOs[i].getIoBndCd());
							simAgnRateDetailPodVO.setAcTpCd(simAgnRateDetailVOs[i].getAcTpCd());
							simAgnRateDetailPodVO.setAgnAgmtSeq(simAgnRateDetailVOs[i].getAgnAgmtSeq());
							simAgnRateDetailPodVO.setAgnAgmtRoutSeq(Integer.toString(routSeq++));
							simAgnRateDetailPodVO.setRoutRefDivCd("POD");
							simAgnRateDetailPodVO.setRoutLvlCd(simAgnRateDetailVOs[i].getPodLvlCd());
							simAgnRateDetailPodVO.setRoutInfoCd(podArr[k]);
							simAgnRateDetailPodVO.setUsrId(account.getUsr_id());
							subInsertRoutVoList.add(simAgnRateDetailPodVO);
						}
					}
					// del_1
					if (!"".equals(simAgnRateDetailVOs[i].getDel1())) {
						String[] del1Arr = simAgnRateDetailVOs[i].getDel1().split(",");
						for (int k=0; k<del1Arr.length; k++) {
							SimAgnRateDetailSubVO simAgnRateDetailDelVO = new SimAgnRateDetailSubVO();
							// 반드시 컬럼 하나씩 복사(simAgnRateDetailSubVO를 그대로 복사하지 말것)
							simAgnRateDetailDelVO.setAgnCd(simAgnRateDetailVOs[i].getAgnCd());
							simAgnRateDetailDelVO.setAgnAgmtNo(simAgnRateDetailVOs[i].getAgnAgmtNo());
							simAgnRateDetailDelVO.setIoBndCd(simAgnRateDetailVOs[i].getIoBndCd());
							simAgnRateDetailDelVO.setAcTpCd(simAgnRateDetailVOs[i].getAcTpCd());
							simAgnRateDetailDelVO.setAgnAgmtSeq(simAgnRateDetailVOs[i].getAgnAgmtSeq());
							simAgnRateDetailDelVO.setAgnAgmtRoutSeq(Integer.toString(routSeq++));
							simAgnRateDetailDelVO.setRoutRefDivCd("DELV");
							simAgnRateDetailDelVO.setRoutLvlCd("1");
							simAgnRateDetailDelVO.setRoutInfoCd(del1Arr[k]);
							simAgnRateDetailDelVO.setUsrId(account.getUsr_id());
							subInsertRoutVoList.add(simAgnRateDetailDelVO);
						}
					}
					// del_2
					if (!"".equals(simAgnRateDetailVOs[i].getDel2())) {
						String[] del2Arr = simAgnRateDetailVOs[i].getDel2().split(",");
						for (int k=0; k<del2Arr.length; k++) {
							SimAgnRateDetailSubVO simAgnRateDetailDelVO = new SimAgnRateDetailSubVO();
							// 반드시 컬럼 하나씩 복사(simAgnRateDetailSubVO를 그대로 복사하지 말것)
							simAgnRateDetailDelVO.setAgnCd(simAgnRateDetailVOs[i].getAgnCd());
							simAgnRateDetailDelVO.setAgnAgmtNo(simAgnRateDetailVOs[i].getAgnAgmtNo());
							simAgnRateDetailDelVO.setIoBndCd(simAgnRateDetailVOs[i].getIoBndCd());
							simAgnRateDetailDelVO.setAcTpCd(simAgnRateDetailVOs[i].getAcTpCd());
							simAgnRateDetailDelVO.setAgnAgmtSeq(simAgnRateDetailVOs[i].getAgnAgmtSeq());
							simAgnRateDetailDelVO.setAgnAgmtRoutSeq(Integer.toString(routSeq++));
							simAgnRateDetailDelVO.setRoutRefDivCd("DELV");
							simAgnRateDetailDelVO.setRoutLvlCd("2");
							simAgnRateDetailDelVO.setRoutInfoCd(del2Arr[k]);
							simAgnRateDetailDelVO.setUsrId(account.getUsr_id());
							subInsertRoutVoList.add(simAgnRateDetailDelVO);
						}
					}
					// del_3
					if (!"".equals(simAgnRateDetailVOs[i].getDel3())) {
						String[] del3Arr = simAgnRateDetailVOs[i].getDel3().split(",");
						for (int k=0; k<del3Arr.length; k++) {
							SimAgnRateDetailSubVO simAgnRateDetailDelVO = new SimAgnRateDetailSubVO();
							// 반드시 컬럼 하나씩 복사(simAgnRateDetailSubVO를 그대로 복사하지 말것)
							simAgnRateDetailDelVO.setAgnCd(simAgnRateDetailVOs[i].getAgnCd());
							simAgnRateDetailDelVO.setAgnAgmtNo(simAgnRateDetailVOs[i].getAgnAgmtNo());
							simAgnRateDetailDelVO.setIoBndCd(simAgnRateDetailVOs[i].getIoBndCd());
							simAgnRateDetailDelVO.setAcTpCd(simAgnRateDetailVOs[i].getAcTpCd());
							simAgnRateDetailDelVO.setAgnAgmtSeq(simAgnRateDetailVOs[i].getAgnAgmtSeq());
							simAgnRateDetailDelVO.setAgnAgmtRoutSeq(Integer.toString(routSeq++));
							simAgnRateDetailDelVO.setRoutRefDivCd("DELV");
							simAgnRateDetailDelVO.setRoutLvlCd("3");
							simAgnRateDetailDelVO.setRoutInfoCd(del3Arr[k]);
							simAgnRateDetailDelVO.setUsrId(account.getUsr_id());
							subInsertRoutVoList.add(simAgnRateDetailDelVO);
						}
					}
					// del_4
					if (!"".equals(simAgnRateDetailVOs[i].getDel4())) {
						String[] del4Arr = simAgnRateDetailVOs[i].getDel4().split(",");
						for (int k=0; k<del4Arr.length; k++) {
							SimAgnRateDetailSubVO simAgnRateDetailDelVO = new SimAgnRateDetailSubVO();
							// 반드시 컬럼 하나씩 복사(simAgnRateDetailSubVO를 그대로 복사하지 말것)
							simAgnRateDetailDelVO.setAgnCd(simAgnRateDetailVOs[i].getAgnCd());
							simAgnRateDetailDelVO.setAgnAgmtNo(simAgnRateDetailVOs[i].getAgnAgmtNo());
							simAgnRateDetailDelVO.setIoBndCd(simAgnRateDetailVOs[i].getIoBndCd());
							simAgnRateDetailDelVO.setAcTpCd(simAgnRateDetailVOs[i].getAcTpCd());
							simAgnRateDetailDelVO.setAgnAgmtSeq(simAgnRateDetailVOs[i].getAgnAgmtSeq());
							simAgnRateDetailDelVO.setAgnAgmtRoutSeq(Integer.toString(routSeq++));
							simAgnRateDetailDelVO.setRoutRefDivCd("DELV");
							simAgnRateDetailDelVO.setRoutLvlCd("4");
							simAgnRateDetailDelVO.setRoutInfoCd(del4Arr[k]);
							simAgnRateDetailDelVO.setUsrId(account.getUsr_id());
							subInsertRoutVoList.add(simAgnRateDetailDelVO);
						}
					}
					// DEL
					if (!"".equals(simAgnRateDetailVOs[i].getDel())) {
						String[] delArr = simAgnRateDetailVOs[i].getDel().split(",");
						for (int k=0; k<delArr.length; k++) {
							SimAgnRateDetailSubVO simAgnRateDetailDelVO = new SimAgnRateDetailSubVO();
							// 반드시 컬럼 하나씩 복사(simAgnRateDetailSubVO를 그대로 복사하지 말것)
							simAgnRateDetailDelVO.setAgnCd(simAgnRateDetailVOs[i].getAgnCd());
							simAgnRateDetailDelVO.setAgnAgmtNo(simAgnRateDetailVOs[i].getAgnAgmtNo());
							simAgnRateDetailDelVO.setIoBndCd(simAgnRateDetailVOs[i].getIoBndCd());
							simAgnRateDetailDelVO.setAcTpCd(simAgnRateDetailVOs[i].getAcTpCd());
							simAgnRateDetailDelVO.setAgnAgmtSeq(simAgnRateDetailVOs[i].getAgnAgmtSeq());
							simAgnRateDetailDelVO.setAgnAgmtRoutSeq(Integer.toString(routSeq++));
							simAgnRateDetailDelVO.setRoutRefDivCd("DEL");
							simAgnRateDetailDelVO.setRoutLvlCd(simAgnRateDetailVOs[i].getDelLvlCd());
							simAgnRateDetailDelVO.setRoutInfoCd(delArr[k]);
							simAgnRateDetailDelVO.setUsrId(account.getUsr_id());
							subInsertRoutVoList.add(simAgnRateDetailDelVO);
						}
					}

					// REP_CHG_CD, CHG_CD insertVoList setting
					int chgSeq = 0;
					if (!"".equals(simAgnRateDetailVOs[i].getRepChgCd())) {
						String[] repChgCdArr = simAgnRateDetailVOs[i].getRepChgCd().split(",");
						for (int k=0; k<repChgCdArr.length; k++) {
							SimAgnRateDetailSubVO simAgnRateDetailRegChgVO = new SimAgnRateDetailSubVO();
							// 반드시 컬럼 하나씩 복사(simAgnRateDetailSubVO를 그대로 복사하지 말것)
							simAgnRateDetailRegChgVO.setAgnCd(simAgnRateDetailVOs[i].getAgnCd());
							simAgnRateDetailRegChgVO.setAgnAgmtNo(simAgnRateDetailVOs[i].getAgnAgmtNo());
							simAgnRateDetailRegChgVO.setIoBndCd(simAgnRateDetailVOs[i].getIoBndCd());
							simAgnRateDetailRegChgVO.setAcTpCd(simAgnRateDetailVOs[i].getAcTpCd());
							simAgnRateDetailRegChgVO.setAgnAgmtSeq(simAgnRateDetailVOs[i].getAgnAgmtSeq());
							simAgnRateDetailRegChgVO.setAgnAgmtChgSeq(Integer.toString(chgSeq++));
							simAgnRateDetailRegChgVO.setChgDivCd("R");
							simAgnRateDetailRegChgVO.setChgCd(repChgCdArr[k]);
							simAgnRateDetailRegChgVO.setUsrId(account.getUsr_id());
							subInsertChgVoList.add(simAgnRateDetailRegChgVO);
						}
					}
					if (!"".equals(simAgnRateDetailVOs[i].getChgCd())) {
						String[] chgCdArr = simAgnRateDetailVOs[i].getChgCd().split(",");
						for (int k=0; k<chgCdArr.length; k++) {
							SimAgnRateDetailSubVO simAgnRateDetailChgVO = new SimAgnRateDetailSubVO();
							// 반드시 컬럼 하나씩 복사(simAgnRateDetailSubVO를 그대로 복사하지 말것)
							simAgnRateDetailChgVO.setAgnCd(simAgnRateDetailVOs[i].getAgnCd());
							simAgnRateDetailChgVO.setAgnAgmtNo(simAgnRateDetailVOs[i].getAgnAgmtNo());
							simAgnRateDetailChgVO.setIoBndCd(simAgnRateDetailVOs[i].getIoBndCd());
							simAgnRateDetailChgVO.setAcTpCd(simAgnRateDetailVOs[i].getAcTpCd());
							simAgnRateDetailChgVO.setAgnAgmtSeq(simAgnRateDetailVOs[i].getAgnAgmtSeq());
							simAgnRateDetailChgVO.setUsrId(account.getUsr_id());
							simAgnRateDetailChgVO.setAgnAgmtChgSeq(Integer.toString(chgSeq++));
							simAgnRateDetailChgVO.setChgDivCd("C");
							simAgnRateDetailChgVO.setChgCd(chgCdArr[k]);
							simAgnRateDetailChgVO.setUsrId(account.getUsr_id());
							subInsertChgVoList.add(simAgnRateDetailChgVO);
						}
					}
				}
			}

			if (subDeleteVoList.size() > 0) {
				// CNTR_TPSZ_CD, ROUTE, REP_CHG_CD, CHG_CD의 delete는 일괄처리
				dbDao.removeSimAgnRateDetailCntr(subDeleteVoList);
				dbDao.removeSimAgnRateDetailRout(subDeleteVoList);
				dbDao.removeSimAgnRateDetailChg(subDeleteVoList);
			}
			if (subInsertCntrVoList.size() > 0) {
				dbDao.addSimAgnRateDetailCntr(subInsertCntrVoList);
			}
			if (subInsertRoutVoList.size() > 0) {
				dbDao.addSimAgnRateDetailRout(subInsertRoutVoList);
			}
			if (subInsertChgVoList.size() > 0) {
				dbDao.addSimAgnRateDetailChg(subInsertChgVoList);
			}

			if (deleteVoList.size() > 0) {
				dbDao.removeSimAgnRateDetail(deleteVoList);
			}
			if (updateVoList.size() > 0) {
				dbDao.modifySimAgnRateDetail(updateVoList);
			}
			if (insertVoList.size() > 0) {
				dbDao.addSimAgnRateDetail(insertVoList);
			}

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_ACM_0006] Calculate<br>
	 *
	 * @param String
	 * @return int
	 */
	private int stringToInt(String strVal) {
		int rtnInt = 0;
		if(strVal != null) {
			rtnInt = Integer.parseInt(strVal);
		}
		return rtnInt;
	}

	/**
	 * [ESM_ACM_0006] Calculate<br>
	 *
	 * @param String
	 * @return double
	 */
	private double stringToDouble(String strVal) {
		double rtnDouble = 0;
		if(strVal != null) {
			rtnDouble = Double.parseDouble(strVal);
		}
		return rtnDouble;
	}

	/**
	 * [ESM_ACM_0011-01]
	 * New Agreement No. 조회<br>
	 *
	 * @param SimAgnRateMasterVO simAgnRateMasterVO
	 * @return List<SimAgnRateMasterVO>
	 * @exception EventException
	 */
	public List<SimAgnRateMasterVO> getNewAgreementNo(SimAgnRateMasterVO simAgnRateMasterVO) throws EventException {
		try {
			return dbDao.getNewAgreementNo(simAgnRateMasterVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_ACM_0115]
	 * 사용자가 입력한 Agreement No.의 유효성 검증<br>
	 *
	 * @param SimAgnRateMasterVO simAgnRateMasterVO
	 * @exception EventException
	 */
	public void getAgreementNoInfo(SimAgnRateMasterVO simAgnRateMasterVO) throws EventException {
		try {
			if (dbDao.getAgreementNoInfo(simAgnRateMasterVO).size() < 1) {
				// [ACM00005] - $s does not exist!
				throw new EventException(new ErrorHandler("ACM00005", new String[]{"Agreement No. [" + simAgnRateMasterVO.getAgnAgmtNo() + "]"}).getMessage());
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_ACM_0115]
	 * 선택된 Agreement No.의 Master와 Detail, TP/SZ, Route, Charge 목록을 New Ageement No.로 저장<br>
	 *
	 * @param SimAgnRateMasterVO simAgnRateMasterVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageAgmtCopy(SimAgnRateMasterVO simAgnRateMasterVO, SignOnUserAccount account) throws EventException {
		try {
			List<SimAgnRateMasterVO> simAgnRateMasterVOList = new ArrayList<SimAgnRateMasterVO>();
			if (simAgnRateMasterVO != null) {
				simAgnRateMasterVO.setUsrId(account.getUsr_id());
				// New Agreement No. 조회 후 setting
				String newAgmtNo = dbDao.getNewAgreementNo(simAgnRateMasterVO).get(0).getNewAgmtNo();
				simAgnRateMasterVO.setNewAgmtNo(newAgmtNo);

				simAgnRateMasterVOList.add(simAgnRateMasterVO);

				// New Agreement No.로 저장된 데이터가 있다면 삭제
				dbDao.removeAgmtCopyMaster(simAgnRateMasterVOList);
				dbDao.removeAgmtCopyDetail(simAgnRateMasterVOList);
				dbDao.removeAgmtCopyDetailCntr(simAgnRateMasterVOList);
				dbDao.removeAgmtCopyDetailRout(simAgnRateMasterVOList);
				dbDao.removeAgmtCopyDetailChg(simAgnRateMasterVOList);

				// New Agreement No.로 기존 데이터 Coopy
				dbDao.addAgmtCopyMaster(simAgnRateMasterVOList);
				dbDao.addAgmtCopyDetail(simAgnRateMasterVOList);
				dbDao.addAgmtCopyDetailCntr(simAgnRateMasterVOList);
				dbDao.addAgmtCopyDetailRout(simAgnRateMasterVOList);
				dbDao.addAgmtCopyDetailChg(simAgnRateMasterVOList);
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_ACM_0033] Simulation Target Search
	 * Target Booking 목록을 조회<br>
	 *
	 * @param AGNCommMassSimVO agnCommMassSimVO
	 * @return List<AGNCommMassSimVO>
	 * @exception EventException
	 */
	public List<AGNCommMassSimVO> searchAGNCommMassSimList(AGNCommMassSimVO agnCommMassSimVO) throws EventException {
		try {
			return dbDao.searchAGNCommMassSimList(agnCommMassSimVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_ACM_0033] Start Simulation<br>
	 * 대상 Booking 을 Batch 에 입력한다<br>
	 *
	 * @param AGNCommMassSimVO agnCommMassSimVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageAGNCommMassSimList(AGNCommMassSimVO agnCommMassSimVO, SignOnUserAccount account) throws EventException {
		try {
			agnCommMassSimVO.setUsrId(account.getUsr_id());
			dbDao.manageAGNCommMassSimList(agnCommMassSimVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_ACM_0033] BKG Export<br>
	 * 조회 결과를 Excel 파일 다운로드한다.<br>
	 *
	 * @param AGNCommMassSimVO agnCommMassSimVO
	 * @return DBRowSet
	 * @exception EventException
	 */
	public DBRowSet searchAGNCommMassSimExcel(AGNCommMassSimVO agnCommMassSimVO) throws EventException {
		try {
			return dbDao.searchAGNCommMassSimExcel(agnCommMassSimVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_ACM_0110] Simulation No. Search<br>
	 * Simulation No. Search 목록을 조회<br>
	 *
	 * @param SimulationNoVO simulationNoVO
	 * @return List<SimulationNoVO>
	 * @exception EventException
	 */
	public List<SimulationNoVO> searchSimulationNoList(SimulationNoVO simulationNoVO) throws EventException {
		try {
			return dbDao.searchSimulationNoList(simulationNoVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_ACM_0110]Simulation No 의 Simulation Office 조회<br>
	 * Simulation Office 조회
	 *
	 * @param SimulationNoVO simulationNoVO
	 * @return List<SimulationNoVO>
	 * @exception EventException
	 */
	public List<SimulationNoVO> getSimulationOfficeList(SimulationNoVO simulationNoVO) throws EventException {
		try {
			return dbDao.getSimulationOfficeList(simulationNoVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_ACM_0033] Simulation Result - Simulation Number<br>
	 * Simulation Result - Simulation Number Excel 파일 다운로드한다.<br>
	 *
	 * @param AGNCommMassSimVO agnCommMassSimVO
	 * @return DBRowSet
	 * @exception EventException
	 */
	public DBRowSet searchAGNCommMassSimSimulationNumberExcel(AGNCommMassSimVO agnCommMassSimVO) throws EventException {
		try {
			return dbDao.searchAGNCommMassSimSimulationNumberExcel(agnCommMassSimVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * [ESM_ACM_0033] Add Batch<br>
	 * 대상 Actual Agreement 를 Batch 에 입력한다<br>
	 *
	 * @param AGNCommMassSimVO agnCommMassSimVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageAGNCommAddBatchList(AGNCommMassSimVO agnCommMassSimVO, SignOnUserAccount account) throws EventException {
		try {
			agnCommMassSimVO.setUsrId(account.getUsr_id());
			dbDao.manageAGNCommAddBatchList(agnCommMassSimVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * [ESM_ACM_0033] Add Batch<br>
	 * 대상 Simulation Agreement 를 Batch 에 입력한다<br>
	 *
	 * @param AGNCommMassSimVO agnCommMassSimVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageSimCommAddBatchList(AGNCommMassSimVO agnCommMassSimVO, SignOnUserAccount account) throws EventException {
		try {
			agnCommMassSimVO.setUsrId(account.getUsr_id());
			dbDao.manageSimCommAddBatchList(agnCommMassSimVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
}