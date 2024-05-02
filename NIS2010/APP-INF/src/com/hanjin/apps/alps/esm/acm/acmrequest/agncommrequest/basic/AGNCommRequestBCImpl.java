/**
 * Copyright(c) 2012 CyberLogitec
 * @FileName : AGNCommRequestBCImpl.java
 * @FileTitle : AGNCommRequestBCImpl
 * Open Issues :
 * Change history :
 * @LastModifyDate : 2015.08.05
 * @LastModifier : Sang-Hyun Kim
 * @LastVersion : 1.2
 * 2012.03.26 김상수 1.0 Creation
 * 2012.09.13 김봉균 [선처리]커미션 계산 시 AP_OFC_CD, AP_CTR_CD 생성 기준 변경
 * 2013.01.25 이윤정 [CHM-201322566] Calculation 시, Covered이면서 Cancel된 부킹 처리. 기존엔 Cancel 경우는 Master BKG 처리로직만 존재
 * 2013.03.13 이윤정 [CHM-201323152] 커미션 생성 후 CNTR 에 따라 배부 시 로직 변경
 * 2013.10.24 박다은 [CHM-201326610] Audit 화면 조회 오류, 로직 변경 요청 (LIMBA / GYEBA)
 * 2015.05.21 Sang-Hyun Kim 1.1 [CHM-201534767] 대리점비 공제로직 변경으로 인한 ACM 시스템 적용 (Own feederage 단가 테이블 로직 구성 하여 공제에 활용)
 * 2015.05.27 Sang-Hyun Kim 1.11 [CHM-201536062] Own Feederage 공제 로직 추가 보완 요청
 * 2015.06.30 Sang-Hyun Kim 1.12 [CHM-201536386] Split13-주간 MAS Open에 따른 타모듈 프로그램 적용 요청
 * 2015.08.05 Sang-Hyun Kim 1.2 [CHM-201537067] Split01-[그룹사 표준 코드 시행] HJS 프로그램 대응 및 데이타 마이그레이션 작업 요청
 */
package com.hanjin.apps.alps.esm.acm.acmrequest.agncommrequest.basic;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.hanjin.apps.alps.esm.acm.acmagreement.vipdeductagreement.vo.VIPAgreementVO;
import com.hanjin.apps.alps.esm.acm.acmrequest.agncommrequest.integration.AGNCommRequestDBDAO;
import com.hanjin.apps.alps.esm.acm.acmrequest.agncommrequest.vo.AGNCommRequestVO;
import com.hanjin.apps.alps.esm.acm.acmrequest.agncommrequest.vo.AgmtInfoVO;
import com.hanjin.apps.alps.esm.acm.acmrequest.agncommrequest.vo.AgnReqCalCondVO;
import com.hanjin.apps.alps.esm.acm.acmrequest.agncommrequest.vo.AgnReqRevInfoVO;
import com.hanjin.apps.alps.esm.acm.acmrequest.agncommrequest.vo.BkgCreDtInfoVO;
import com.hanjin.apps.alps.esm.acm.acmrequest.agncommrequest.vo.BkgNumberInfoVO;
import com.hanjin.apps.alps.esm.acm.acmrequest.agncommrequest.vo.BkgQtyInfoVO;
import com.hanjin.apps.alps.esm.acm.acmrequest.agncommrequest.vo.CHGCommAmtVO;
import com.hanjin.apps.alps.esm.acm.acmrequest.agncommrequest.vo.CalcDtlBkgRevenueVO;
import com.hanjin.apps.alps.esm.acm.acmrequest.agncommrequest.vo.ChgAmtInfoVO;
import com.hanjin.apps.alps.esm.acm.acmrequest.agncommrequest.vo.ChgAmtRtInfoVO;
import com.hanjin.apps.alps.esm.acm.acmrequest.agncommrequest.vo.ChgInfoVO;
import com.hanjin.apps.alps.esm.acm.acmrequest.agncommrequest.vo.OfficeCodeInfoVO;
import com.hanjin.apps.alps.esm.acm.acmrequest.agncommrequest.vo.SaDtInfoVO;
import com.hanjin.apps.alps.esm.acm.acmrequest.agncommrequest.vo.VslSvcLaneInfoVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

 
/**
 * ALPS-ACMRequest Business Logic Command Interface<br>
 * - ALPS-ACMReques에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author KIM, Sang-Soo
 * @see Esm_Acm_0006Event,AGNCommRequestBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class AGNCommRequestBCImpl extends BasicCommandSupport implements AGNCommRequestBC {

	// Database Access Object
	private transient AGNCommRequestDBDAO dbDao = null;

	/**
	 * AGNCommRequestBCImpl 객체 생성<br>
	 * AGNCommRequestDBDAO를 생성한다.<br>
	 */
	public AGNCommRequestBCImpl() {
		dbDao = new AGNCommRequestDBDAO();
	}

	/**
	 * [ESM_ACM_0006]
	 * Agent Commission Request 목록을 조회<br>
	 *
	 * @param AGNCommRequestVO agnCommRequestVO
	 * @return List<AGNCommRequestVO>
	 * @exception EventException
	 */
	public List<AGNCommRequestVO> searchAGNCommRequest(AGNCommRequestVO agnCommRequestVO) throws EventException {
		try {
			return dbDao.searchAGNCommRequest(agnCommRequestVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Agent Commission Request 화면의 요청 관련 정보 저장
	 * @param agnCommRequestVOs
	 * @param account
	 * @param acTpCd
	 * @throws EventException
	 */
	public void requestAGNCommRequest(AGNCommRequestVO[] agnCommRequestVOs, SignOnUserAccount account, String acTpCd) throws EventException {
		List<AGNCommRequestVO> updateVoList = null;
		try {
			updateVoList = new ArrayList<AGNCommRequestVO>();
			for(int i=0; i<agnCommRequestVOs.length; i++) {
				if( !"RS".equals(agnCommRequestVOs[i].getAcStsCd()) ) {
					agnCommRequestVOs[i].setAcTpCd(acTpCd);
					agnCommRequestVOs[i].setUsrId(account.getUsr_id());
					updateVoList.add(agnCommRequestVOs[i]);
				}
			}
			dbDao.requestAGNCommRequest(updateVoList, acTpCd);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_ACM_0006] <br>
	 * calling procedure<br>
	 *
	 * @param AGNCommRequestVO agnCommRequestVO
	 * @exception EventException
	 */
	public void executeAcmTest3Prc(AGNCommRequestVO agnCommRequestVO) throws EventException {
		try {
			dbDao.executeAcmTest3Prc(agnCommRequestVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_ACM_0006] Ex. Rate Input<br>
	 *
	 * @param AGNCommRequestVO[] agnCommRequestVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void executeRateInput(AGNCommRequestVO[] agnCommRequestVOs, SignOnUserAccount account) throws EventException {
		List<AGNCommRequestVO> agnCommRequestVOlist = null;
		try {
			for(int i=0; i<agnCommRequestVOs.length; i++) {
				agnCommRequestVOlist = dbDao.searchRateInput(agnCommRequestVOs[i]);
				if ( 0 < agnCommRequestVOlist.size() ) {
					agnCommRequestVOlist.get(0).setUsrId(account.getUsr_id());
					dbDao.executeRateInput(agnCommRequestVOlist.get(0));
					dbDao.executeRateDetalInput(agnCommRequestVOlist.get(0));

				}
			}
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_ACM_0006] Calculate<br>
	 *
	 * @param String bkgNo
	 * @param String usrId
	 * @exception EventException
	 */
	public void createAgnComm(String bkgNo, String usrId) throws EventException {
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
		String calcNo 		= null;
		String reCalcFlg 	= "Y";
		String bdrFlg 		= null;
		String blCvrdTpCd 	= null;

		String mstBkgNo 	= null;

		String bkgCreDt          = null;
		String svcScpCd          = null;
		String revMon 			 = null;
		String rtAplyDt 		 = null;

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
			log.debug("===================== createAgnComm Start =====================");
			//GET_MAS_COA_FLG
			masCoaFlg = dbDao.getMasCoaFlg(bkgNo);
			//GET_CALC_NO
			calcNo = dbDao.getCalcNo();
			log.debug("calcNo : " + calcNo);
			//GET_BKG_NUMBER
			bkgNumberVO = dbDao.getBkgNumber(bkgNo);
			if(bkgNumberVO != null) {
				mstBkgNo = bkgNumberVO.getMstBkgNo();
				blCvrdTpCd = bkgNumberVO.getBlCvrdTpCd();
				log.debug("bkgStsCd : " + bkgNumberVO.getBkgStsCd() + " / mstBkgNo : " + mstBkgNo);
				if("X".equals(bkgNumberVO.getBkgStsCd())) {
					AgnReqCalCondVO agnCondVO = new AgnReqCalCondVO();
					agnCondVO.setCalcNo(calcNo);
					agnCondVO.setUsrId(usrId);
					if(!"".equals(mstBkgNo)) {
						//[CHM-201322566] Calculation 시, Covered이면서 Cancel된 부킹 처리.
						// covered BKG 상계 로직
						agnCondVO.setBkgNo(bkgNo);
						dbDao.modifyAcmAgnBkgInfo(agnCondVO);
						dbDao.removeAcmAgnComm(bkgNo);
						dbDao.removeAcmAgnCommDtl(bkgNo);		//DELETE ACM_AGN_COMM_DTL
						dbDao.removeAcmAgnCommChgRef(bkgNo);	//DELETE ACM_AGN_COMM_CHG_REF
						dbDao.removeAcmAgnCommChg(bkgNo);		//DELETE ACM_AGN_COMM_CHG
						dbDao.removeAcmAgnCommRev(bkgNo);		//DELETE ACM_AGN_COMM_REV
						dbDao.removeAcmAgnCommTrsp(bkgNo);		//DELETE ACM_AGN_COMM_TRSP
						dbDao.modifyAcmAgnCommZeroSum(agnCondVO);
						dbDao.addAcmAgnCommDtl(agnCondVO);
						dbDao.addAcmAgnBkgInfoHis(agnCondVO);	//Data FROM ACM_AGN_BKG_INFO
						dbDao.addAcmAgnCommHis(agnCondVO);
						
						//[CHM-201323152] 커미션 생성 후 CNTR 에 따라 배부 시 로직 변경 
						if(!bkgNo.equals(mstBkgNo)){	
							// master BKG 상계 로직
							agnCondVO.setBkgNo(mstBkgNo);
							dbDao.modifyAcmAgnBkgInfo(agnCondVO);
							dbDao.removeAcmAgnComm(mstBkgNo);
							dbDao.removeAcmAgnCommDtl(mstBkgNo);	//DELETE ACM_AGN_COMM_DTL
							dbDao.removeAcmAgnCommChgRef(mstBkgNo);	//DELETE ACM_AGN_COMM_CHG_REF
							dbDao.removeAcmAgnCommChg(mstBkgNo);	//DELETE ACM_AGN_COMM_CHG
							dbDao.removeAcmAgnCommRev(mstBkgNo);	//DELETE ACM_AGN_COMM_REV
							dbDao.removeAcmAgnCommTrsp(mstBkgNo);	//DELETE ACM_AGN_COMM_TRSP
							dbDao.addAcmAgnBkgInfoHis(agnCondVO);	//Data FROM ACM_AGN_BKG_INFO
							dbDao.addAcmAgnCommHis(agnCondVO);
						}

					} else {
						
						agnCondVO.setBkgNo(bkgNo);
						dbDao.modifyAcmAgnBkgInfo(agnCondVO);
						dbDao.removeAcmAgnComm(bkgNo);
						dbDao.removeAcmAgnCommDtl(bkgNo);		//DELETE ACM_AGN_COMM_DTL
						dbDao.removeAcmAgnCommChgRef(bkgNo);	//DELETE ACM_AGN_COMM_CHG_REF
						dbDao.removeAcmAgnCommChg(bkgNo);		//DELETE ACM_AGN_COMM_CHG
						dbDao.removeAcmAgnCommRev(bkgNo);		//DELETE ACM_AGN_COMM_REV
						dbDao.removeAcmAgnCommTrsp(bkgNo);		//DELETE ACM_AGN_COMM_TRSP
						dbDao.modifyAcmAgnCommZeroSum(agnCondVO);
						dbDao.addAcmAgnCommDtl(agnCondVO);
						dbDao.addAcmAgnBkgInfoHis(agnCondVO);	//Data FROM ACM_AGN_BKG_INFO
						dbDao.addAcmAgnCommHis(agnCondVO);
					}
					return;
				}
			}

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
				dbDao.addAcmAgnBkgInfoHis(bkgNo, calcNo, blCvrdTpCd);//FROM BKG_BOOKING

				AgnReqCalCondVO blCvrpTpVO = new AgnReqCalCondVO();
				blCvrpTpVO.setCalcNo(calcNo);
				blCvrpTpVO.setUsrId(usrId);
				blCvrpTpVO.setBkgNo(bkgNo);
				dbDao.modifyAcmAgnBkgInfo(blCvrpTpVO);
				dbDao.removeAcmAgnComm(bkgNo);
				dbDao.removeAcmAgnCommDtl(bkgNo);//DELETE ACM_AGN_COMM_DTL
				dbDao.removeAcmAgnCommChgRef(bkgNo);//DELETE ACM_AGN_COMM_CHG_REF
				dbDao.removeAcmAgnCommChg(bkgNo);//DELETE ACM_AGN_COMM_CHG
				dbDao.removeAcmAgnCommRev(bkgNo);//DELETE ACM_AGN_COMM_REV
				dbDao.removeAcmAgnCommTrsp(bkgNo);//DELETE ACM_AGN_COMM_TRSP
				dbDao.modifyAcmAgnCommZeroSum(blCvrpTpVO);
				dbDao.addAcmAgnCommHis(blCvrpTpVO);
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
			officeCodeInfoVO.setCommProcRsltRsn(commProcRsltRsn.toString());
			officeCodeInfoVO.setPpdOfrtAmt(ppdOfrtAmt);
			officeCodeInfoVO.setPpdChgAmt(ppdChgAmt);
			officeCodeInfoVO.setCltOfrtAmt(cltOfrtAmt);
			officeCodeInfoVO.setCltChgAmt(cltChgAmt);
			officeCodeInfoVO.setUsrId(usrId);


			/** DELETE DATA */
			
			dbDao.removeAcmAgnBkgInfo(mstBkgNo);//DELETE ACM_AGN_BKG_INFO
			dbDao.removeAcmAgnComm(mstBkgNo);//DELETE ACM_AGN_COMM
			dbDao.removeAcmAgnCommDtl(mstBkgNo);//DELETE ACM_AGN_COMM_DTL
			dbDao.removeAcmAgnCommChg(mstBkgNo);//DELETE ACM_AGN_COMM_CHG
			dbDao.removeAcmAgnCommRev(mstBkgNo);//DELETE ACM_AGN_COMM_REV
			dbDao.removeAcmAgnCommTrsp(mstBkgNo);//DELETE ACM_AGN_COMM_TRSP
			dbDao.removeAcmAgnCHGCommDetail(mstBkgNo);	// 2017.08.24 Charge Commission 추가

			//Agreement 와 비교하기 위한 데이터 (ACM_AGN_COMM)
			List<AgmtInfoVO> zeroSumList = dbDao.getZeroSumObjList(mstBkgNo, usrId);

			AgnReqCalCondVO condVO = new AgnReqCalCondVO();
			condVO.setBkgNo(mstBkgNo);
			condVO.setCalcNo(calcNo);
			condVO.setUsrId(usrId);
			//INSERT INTO ACM_AGN_BKG_INFO
			dbDao.addAcmAgnBkgInfo(officeCodeInfoVO);
			//insert into ACM_AGN_BKG_INFO_HIS
			dbDao.addAcmAgnBkgInfoHis(condVO);

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

				String commPayTermCd    = null;

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

				int spclAgmtCnt       = 0;
				String maxAcSeq       = null;


				AgmtInfoVO agmtVO = agmtInfoList.get(i);
				log.debug("agmtInfoVO => "+ agmtVO.toString());
				commPayTermCd 	= agmtVO.getCommPayTermCd();
				hlgDdctOrgFlg   = agmtVO.getHlgDdctOrgFlg(); // H OB
				hlgDdctDestFlg  = agmtVO.getHlgDdctDestFlg(); // H IB
				fdrgDdctOrgFlg  = agmtVO.getFdrgDdctOrgFlg(); // F OB
				fdrgDdctDestFlg = agmtVO.getFdrgDdctDestFlg(); // F IB

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


				// 4개 컬럼 비교하여 같으면  zeroSum 갱신대상에서 제외
				log.debug("zeroSumList.size() : "+zeroSumList.size());
				for(int k=0; k<zeroSumList.size(); k++) {
					AgmtInfoVO zeroSumVO = zeroSumList.get(k);
					log.debug("zeroSumVO == "+ zeroSumVO.getBkgNo() +"/"+zeroSumVO.getAgnCd()+"/"+zeroSumVO.getIoBndCd()+"/"+zeroSumVO.getAcTpCd());
					if( agmtVO.getBkgNo() != null && agmtVO.getAgnCd() != null && agmtVO.getIoBndCd() != null && agmtVO.getAcTpCd() != null
							&& agmtVO.getBkgNo().equals(zeroSumVO.getBkgNo()) && agmtVO.getAgnCd().equals(zeroSumVO.getAgnCd())
							&& agmtVO.getIoBndCd().equals(zeroSumVO.getIoBndCd()) && agmtVO.getAcTpCd().equals(zeroSumVO.getAcTpCd()) ) {
						zeroSumList.remove(k);
						break;
					}
				}
				

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
//					if(commRt != 0) {//IF(v_comm_rt<>0)
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

						/*
						 * 2015.08.05 Sang-Hyun Kim [CHM-201537067] Split01-[그룹사 표준 코드 시행] HJS 프로그램 대응 및 데이타 마이그레이션 작업 요청
						 *   Office code가 BOMBB → BOMSC로 변경 됨
						 */
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

						/*
						 * 2015.11.06 Sang-Hyun Kim [] 대리점 계산 로직 기간별 상이하도록 SOURCE 조정 요청
						 *  - 2015년 11월 1일 기준으로 대리점 계산 로직 변경됨.
						 *  - Charge 공제시 PRI에서 조회하던 logic을 booking auto rating 결과를 참조하도록 변경
						 *  - 단, 2015년 10월 31일까지는 기존 logic으로 처리 되도록 분기 처리
						 */
						if (!"0".equals(agmtVO.getMatCntChg())) {
							log.info("Deduct Charge.");
							dbDao.removeAcmAgnCommChgRef(mstBkgNo); // 기존에 조회딘 charge list 삭제

							// 4개 대리점에 대한 테스트 재계산을 위한 임시 소스 반영.
							if (agmtVO.getAgnCd().equals("BUDSC") || agmtVO.getAgnCd().equals("GDYSC") || agmtVO.getAgnCd().equals("PRGSC") || agmtVO.getAgnCd().equals("WRPSO")) {
								dbDao.addAcmAgnCommChgRefFromAutoRt(agmtVO); // Booking auto rating 결과 조회 후 저장.
								dbDao.addAcmAgnCommChgFromAutoRt(agmtVO);    // Agreement에 따라 실제 공제 charge list 저장.
							} else {
								if (Integer.valueOf(saDt) < 20151101) {          // 2015년 10월 31일까지는 기존 logic으로 처리
									dbDao.addAcmAgnCommChgRef(agmtVO);           // Pri에서 공제 대상이 되는 charge list 조회 후 저장.
									dbDao.addAcmAgnCommChg(agmtVO);              // Agreement에 따라 실제 공제 해야 하는 charge list 저장. 
								} else {                                         // 2015년 11월 1일부터 booking auto rating 처리 이후 data 참조.
									dbDao.addAcmAgnCommChgRefFromAutoRt(agmtVO); // Booking auto rating 결과 조회 후 저장.
									dbDao.addAcmAgnCommChgFromAutoRt(agmtVO);    // Agreement에 따라 실제 공제 charge list 저장.
								}
							}
						}

						// [CHM-201641880] ALPS ACM TRS Cost Update 관련
						//  - Sail arrival date 기준 6개월 전 booking은 TRS 비용 재산출하지 않음.
						//  - 이전 계산 값 사용(maxAcSeq
						Calendar calendar = Calendar.getInstance();
						calendar.add(Calendar.MONTH, -6);
						StringBuffer termDateBuffer = new StringBuffer();
						termDateBuffer.append(calendar.get(Calendar.YEAR));
						termDateBuffer.append(String.format("%02d", calendar.get(Calendar.MONTH) + 1));
						termDateBuffer.append(String.format("%02d", calendar.get(Calendar.DATE)));

						// Sail arrival date 기준 6개월 이내거나 처음 계산일 경우, MAS 데이터 조회.
						if (Integer.valueOf(saDt) > Integer.valueOf(termDateBuffer.toString()) || "1".equals(maxAcSeq)) {
							String ownFdrgDdctOrgFlg = new String(fdrgDdctOrgFlg);   // Own Feederage 적용을 위해 Agreement 정보 별도 저장
							String ownFdrgDdctDestFlg = new String(fdrgDdctDestFlg); // Own Feederage 적용을 위해 Agreement 정보 별도 저장
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
								log.debug("--> cnt        = " + ho + "+" + hd + "+" + fo + "+" + fd);
								log.debug("--> ddct_flg   = " + hlgDdctOrgFlg + "+" + hlgDdctDestFlg + "+" + fdrgDdctOrgFlg + "+" + fdrgDdctDestFlg + " >> HO HD FO FD" );

								if ("Y".equals(reCalcFlg)) { // IF (nvl(v_re_calc_flg,'N') = 'Y')
									// INSERT INTO ACM_AGN_COMM_TRSP
									if ("COA".equals(masCoaFlg)) {
										dbDao.addAcmAgnCommTrspFromCoa(agmtVO);
									} else {
										dbDao.addAcmAgnCommTrsp(agmtVO);
									}
								}

								// TRSP 비용 공제 예외 로직 적용, Agreement 내용 Check 후 Own Feederage 계산
								if ((fo == 0 && "Y".equals(ownFdrgDdctOrgFlg)) || (fd == 0 && "Y".equals(ownFdrgDdctDestFlg))) {
									if (fo == 0 && "Y".equals(ownFdrgDdctOrgFlg)) {
										agmtVO.setFdrgDdctOrgFlg("Y");
									}
									if (fd == 0 && "Y".equals(ownFdrgDdctDestFlg)) {
										agmtVO.setFdrgDdctDestFlg("Y");
									}
									dbDao.addAcmOtrFdrgDdct(agmtVO);
								}
							}
						} else {
							dbDao.addAcmAgnPreDdctTrsp(agmtVO);
						}

						// 2016.05.25 김상현 [CHM-201641395] VIP 공제 위한 화면 개발
						//  - VIP 공제 logic 추가
						double vipTotalAmount = 0;
						if ("N".equals(agmtVO.getRevDivCd())) {
							List<VIPAgreementVO> vipAgmtList = dbDao.searchVIPDeductAgreementList(agmtVO);
							for (int j=0; j<vipAgmtList.size(); j++) {
								double amount = dbDao.searchVIPDeductAmount(vipAgmtList.get(j), agmtVO.getBkgNo());
								vipTotalAmount = vipTotalAmount + amount;
							}
						}
						agmtVO.setDdctVipAmt((new Double(vipTotalAmount)).toString());
						log.debug("VIP Deduction Amount : " + vipTotalAmount);

						log.debug("agmtVO.getAgnCd()=> "+agmtVO.getAgnCd());
						spclAgmtCnt = this.stringToInt(dbDao.getSpclAgmtCnt(agmtVO.getAgnCd()));
						//[CHM-201326610] Audit 화면 조회 오류, 로직 변경 요청 (LIMBA / GYEBA)
						String spclCmpnFlg    = "N";
						//get v_spcl_agmt_cnt
						if(spclAgmtCnt > 0 && "N".equalsIgnoreCase(spclCmpnFlg)) {//IF(v_spcl_agmt_cnt>0)
							//DELETE ACM_SPCL_CMPN
							dbDao.removeAcmSpclCmpn(agmtVO);
							dbDao.removeAcmSpclCmpnDtl(agmtVO);
							//SELECT NVL(MAX(SPCL_CMPN_SEQ),0) + 1
							agmtVO.setMaxSpclCmpnSeq(dbDao.getMaxSpclCmpnSeq(agmtVO));
							//SELECT NVL(MAX(CRNT_AMT),0) AS PPD_CRNT_SPCL_AMT
							agmtVO.setPpdCrntSpclAmt(dbDao.getPpdCrntSpclAmt(agmtVO));
							//INSERT INTO ACM_SPCL_CMPN
							dbDao.addAcmSpclCmpn(agmtVO);
							dbDao.addAcmSpclCmpnDtl(agmtVO);
							spclCmpnFlg = "Y";
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
						
						if(("G").equals(agmtVO.getAcTpCd())){
							//Minimum Commission 로직 추가
							String minCommAmt = dbDao.getMinCommAmtInfo(agmtVO);
							log.debug("minCommAmt => "+minCommAmt);
	
							
							if(minCommAmt != null &&  !"".equals(minCommAmt)){
								// Minmum Commission 이 기존 계산된 CommAmt 보다 크면 Minimum Commission 을 적용
								//if((Float.parseFloat(minCommAmt) > Float.parseFloat(chgAmtRtInfoVO.getCommAmt())) && Float.parseFloat(chgAmtRtInfoVO.getCommAmt()) >= 0){
								if((Float.parseFloat(minCommAmt) > Float.parseFloat(chgAmtRtInfoVO.getCommAmt()))){ // Commission 값이 0 이하라도 Minimum Commission 값을 적용
									agmtVO.setMinCommAmt(minCommAmt);
									agmtVO.setMinCommFlg("Y");
									agmtVO.setOrgCommAmt(agmtVO.getCommAmt());
									agmtVO.setCommAmt(minCommAmt);
								}
								else{
									agmtVO.setMinCommAmt(minCommAmt);
									agmtVO.setMinCommFlg("N");
									agmtVO.setOrgCommAmt(agmtVO.getCommAmt());
								}
							}
							else{
								agmtVO.setMinCommFlg("N");
								agmtVO.setOrgCommAmt(agmtVO.getCommAmt());							
							}
						}
						else{
							agmtVO.setMinCommAmt("");
							agmtVO.setMinCommFlg("");
							agmtVO.setOrgCommAmt("");							
						}

						//INSERT INTO ACM_AGN_COMM
						log.debug("===ACM_AGN_COMM DATA 01===" + agmtVO.toString());
						dbDao.addAcmAgnCommRt(agmtVO);
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
//						agmtVO.setComm(comm);
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

						//INSERT INTO ACM_AGN_COMM
						log.debug("===ACM_AGN_COMM DATA 02===" + agmtVO.toString());
						dbDao.addAcmAgnCommFx(agmtVO);
					}//if(!"X".equals(commFxAmt)) {

					// 2017.08.24 Charge Commission 추가
					if(("P").equals(agmtVO.getAcTpCd())){
												
						List<AgmtInfoVO> chgCommList = dbDao.getCHGCommList(agmtVO);
						
						int chgCnt = 0;
						
						for(int p = 0; p < chgCommList.size(); p++){	
							chgCommList.get(p).setCommChgSeq(Integer.toString(chgCnt));
							int insCnt = dbDao.addAcmAgnCHGCommDetail(chgCommList.get(p));
							chgCnt = chgCnt + insCnt;
						}
						
						CHGCommAmtVO chgCommAmtVO = dbDao.getCHGCommAmt(agmtVO);
						agmtVO.setUsdChgComm(chgCommAmtVO.getUsdChgComm());
						agmtVO.setPayChgComm(chgCommAmtVO.getPayChgComm());
						
						ChgAmtRtInfoVO chgAmtRtInfoVO3 = dbDao.getChgAmtRtInfo(agmtVO);
						agmtVO.setPpdCrntAmt(chgAmtRtInfoVO3.getPpdCrntAmt());
						agmtVO.setPpdPayCrntAmt(chgAmtRtInfoVO3.getPpdPayCrntAmt());
						
						dbDao.addAcmAgnCHGComm(agmtVO);
						
					}
					
				}//if(Integer.parseInt(agmtVO.getDupChkCnt()) <= 1) {
			}//for(int i=0; i<agmtInfoList.size(); i++) {

			log.debug("zeroSumList Cnt: "+ zeroSumList.size());
			//Agreement 에 존재하지 않는 건에 대해서 데이터 갱신
			dbDao.modifyAcmAgnCommZeroSum2(zeroSumList);
			
			//INSERT INTO ACM_AGN_COMM_DTL
			dbDao.addAcmAgnCommDtl(condVO);
			/** History 테이블 입력 */
			dbDao.addAcmAgnCommChgRefHis(condVO);//INSERT INTO ACM_AGN_COMM_CHG_REF_HIS
			dbDao.addAcmAgnCommChgHis(condVO);//INSERT INTO ACM_AGN_COMM_CHG_HIS
			dbDao.addAcmAgnCommRevHis(condVO);//INSERT INTO ACM_AGN_COMM_REV_HIS
			dbDao.addAcmAgnCommTrspHis(condVO);//INSERT INTO ACM_AGN_COMM_TRSP_HIS
			dbDao.addAcmAgnCommDtlHis(condVO);//INSERT INTO ACM_AGN_COMM_DTL_HIS
			dbDao.addAcmAgnCommHis(condVO);//INSERT INTO ACM_AGN_COMM_HIS
			dbDao.addAcmAgnCHGCommDetailHis(condVO);	// 2017.08.24 Charge Commission 추가

			//UPDATE /*+ bypass_ujvc */
//			dbDao.modifyCoaComCostAmt(condVO);
			log.debug("===================== createAgnComm End =====================");

		} catch(DAOException ex) {
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
	 * [ESM_ACM_0105] Retrive<br>
	 * Calculation Detail의 Booking Revenue 목록을 조회<br>
	 *
	 * @param CalcDtlBkgRevenueVO calcDtlBkgRevenueVO
	 * @return List<CalcDtlBkgRevenueVO>
	 * @exception EventException
	 */
	public List<CalcDtlBkgRevenueVO> searchCalcDtlBkgRevenue(CalcDtlBkgRevenueVO calcDtlBkgRevenueVO) throws EventException {
		try {
			return dbDao.searchCalcDtlBkgRevenue(calcDtlBkgRevenueVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_ACM_0105] Retrive<br>
	 * Calculation Detail의 Booking Q'ty 목록을 조회<br>
	 *
	 * @param CalcDtlBkgRevenueVO calcDtlBkgRevenueVO
	 * @return List<CalcDtlBkgRevenueVO>
	 * @exception EventException
	 */
	public List<CalcDtlBkgRevenueVO> searchCalcDtlBkgQty(CalcDtlBkgRevenueVO calcDtlBkgRevenueVO) throws EventException {
		try {
			return dbDao.searchCalcDtlBkgQty(calcDtlBkgRevenueVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_ACM_0105] Retrive<br>
	 * Calculation Detail의 Booking Route 목록을 조회<br>
	 *
	 * @param CalcDtlBkgRevenueVO calcDtlBkgRevenueVO
	 * @return List<CalcDtlBkgRevenueVO>
	 * @exception EventException
	 */
	public List<CalcDtlBkgRevenueVO> searchCalcDtlBkgRoute(CalcDtlBkgRevenueVO calcDtlBkgRevenueVO) throws EventException {
		try {
			return dbDao.searchCalcDtlBkgRoute(calcDtlBkgRevenueVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_ACM_0105] Retrive<br>
	 * Calculation Detail의 Charge Deduction 목록을 조회<br>
	 *
	 * @param CalcDtlBkgRevenueVO calcDtlBkgRevenueVO
	 * @return List<CalcDtlBkgRevenueVO>
	 * @exception EventException
	 */
	public List<CalcDtlBkgRevenueVO> searchCalcDtlChgDeduction(CalcDtlBkgRevenueVO calcDtlBkgRevenueVO) throws EventException {
		try {
			return dbDao.searchCalcDtlChgDeduction(calcDtlBkgRevenueVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_ACM_0105] Retrieve
	 * Calculation Detail의 Transportation Cost Deduction 목록을 조회
	 * @param CalcDtlBkgRevenueVO calcDtlBkgRevenueVO
	 * @return List<CalcDtlBkgRevenueVO>
	 * @exception EventException
	 */
	public List<CalcDtlBkgRevenueVO> searchCalcDtlTrsCstDeduction(CalcDtlBkgRevenueVO calcDtlBkgRevenueVO) throws EventException {
		try {
			if ("MAS".equals(dbDao.getMasCoaFlg(calcDtlBkgRevenueVO.getBkgNo()))) {
				return dbDao.searchCalcDtlTrsCstDeduction(calcDtlBkgRevenueVO);
			} else {
				return dbDao.searchCalcDtlTrsCstDeductionFromCoa(calcDtlBkgRevenueVO);
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_ACM_0105] Retrive<br>
	 * Calculation Detail의 Transportation Cost Deduction 목록을 조회<br>
	 *
	 * @param CalcDtlBkgRevenueVO calcDtlBkgRevenueVO
	 * @return List<CalcDtlBkgRevenueVO>
	 * @exception EventException
	 */
	public List<CalcDtlBkgRevenueVO> searchCalcDtlTrsCstAcmDeduction(CalcDtlBkgRevenueVO calcDtlBkgRevenueVO) throws EventException {
		try {
			return dbDao.searchCalcDtlTrsCstAcmDeduction(calcDtlBkgRevenueVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_ACM_0105] Retrive<br>
	 * Calculation Detail의 General Commission 목록을 조회<br>
	 *
	 * @param CalcDtlBkgRevenueVO calcDtlBkgRevenueVO
	 * @return List<CalcDtlBkgRevenueVO>
	 * @exception EventException
	 */
	public List<CalcDtlBkgRevenueVO> searchCalcDtlGeneralComm(CalcDtlBkgRevenueVO calcDtlBkgRevenueVO) throws EventException {
		try {
			return dbDao.searchCalcDtlGeneralComm(calcDtlBkgRevenueVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_ACM_0105] Retrive<br>
	 * Calculation Detail의 Container Handling Fee (CHF) 목록을 조회<br>
	 *
	 * @param CalcDtlBkgRevenueVO calcDtlBkgRevenueVO
	 * @return List<CalcDtlBkgRevenueVO>
	 * @exception EventException
	 */
	public List<CalcDtlBkgRevenueVO> searchCalcDtlCntrHandlingFee(CalcDtlBkgRevenueVO calcDtlBkgRevenueVO) throws EventException {
		try {
			return dbDao.searchCalcDtlCntrHandlingFee(calcDtlBkgRevenueVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_ACM_0105] Retrive<br>
	 * Calculation Detail의 T/S Commission 목록을 조회<br>
	 *
	 * @param CalcDtlBkgRevenueVO calcDtlBkgRevenueVO
	 * @return List<CalcDtlBkgRevenueVO>
	 * @exception EventException
	 */
	public List<CalcDtlBkgRevenueVO> searchCalcDtlTSCommission(CalcDtlBkgRevenueVO calcDtlBkgRevenueVO) throws EventException {
		try {
			return dbDao.searchCalcDtlTSCommission(calcDtlBkgRevenueVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_ACM_0105] Retrive<br>
	 * Calculation Detail의 Charge Commission 목록을 조회<br>
	 *
	 * @param CalcDtlBkgRevenueVO calcDtlBkgRevenueVO
	 * @return List<CalcDtlBkgRevenueVO>
	 * @exception EventException
	 */
	public List<CalcDtlBkgRevenueVO> searchCalcDtlChargeComm(CalcDtlBkgRevenueVO calcDtlBkgRevenueVO) throws EventException {
		try {
			return dbDao.searchCalcDtlChargeComm(calcDtlBkgRevenueVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
}