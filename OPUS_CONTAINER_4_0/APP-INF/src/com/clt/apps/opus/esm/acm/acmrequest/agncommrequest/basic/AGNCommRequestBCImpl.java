/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : AGNCommRequestBCImpl.java
*@FileTitle : AGNCommRequestBCImpl
*Open Issues :
*Change history :
*@LastModifyDate : 2012.03.26
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2012.03.26 김상수
* 1.0 Creation
* --------------------------------------------------------
* History
* 2012.09.13 김봉균 [선처리] 커미션 계산 시 AP_OFC_CD, AP_CTR_CD 생성 기준 변경
=========================================================*/
package com.clt.apps.opus.esm.acm.acmrequest.agncommrequest.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esm.acm.acmrequest.agncommrequest.integration.AGNCommRequestDBDAO;
import com.clt.apps.opus.esm.acm.acmrequest.agncommrequest.vo.AGNCommRequestVO;
import com.clt.apps.opus.esm.acm.acmrequest.agncommrequest.vo.AgmtInfoVO;
import com.clt.apps.opus.esm.acm.acmrequest.agncommrequest.vo.AgnReqCalCondVO;
import com.clt.apps.opus.esm.acm.acmrequest.agncommrequest.vo.AgnReqRevInfoVO;
import com.clt.apps.opus.esm.acm.acmrequest.agncommrequest.vo.BkgCreDtInfoVO;
import com.clt.apps.opus.esm.acm.acmrequest.agncommrequest.vo.BkgNumberInfoVO;
import com.clt.apps.opus.esm.acm.acmrequest.agncommrequest.vo.BkgQtyInfoVO;
import com.clt.apps.opus.esm.acm.acmrequest.agncommrequest.vo.CalcDtlBkgRevenueVO;
import com.clt.apps.opus.esm.acm.acmrequest.agncommrequest.vo.ChgAmtInfoVO;
import com.clt.apps.opus.esm.acm.acmrequest.agncommrequest.vo.ChgAmtRtInfoVO;
import com.clt.apps.opus.esm.acm.acmrequest.agncommrequest.vo.ChgInfoVO;
import com.clt.apps.opus.esm.acm.acmrequest.agncommrequest.vo.OfficeCodeInfoVO;
import com.clt.apps.opus.esm.acm.acmrequest.agncommrequest.vo.SaDtInfoVO;
import com.clt.apps.opus.esm.acm.acmrequest.agncommrequest.vo.VslSvcLaneInfoVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;


/**
 * OPUS-ACMRequest Business Logic Command Interface<br>
 * - OPUS-ACMReques에 대한 비지니스 로직에 대한 인터페이스<br>
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
	 * [ESM_ACM_0006] Request<br>
	 * Agent Commission Request 화면의 요청 관련 정보 저장<br>
	 *
	 * @param AGNCommRequestVO[] agnCommRequestVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void requestAGNCommRequest(AGNCommRequestVO[] agnCommRequestVOs, SignOnUserAccount account) throws EventException {
		List<AGNCommRequestVO> updateVoList = null;
		try {
			updateVoList = new ArrayList<AGNCommRequestVO>();
			for(int i=0; i<agnCommRequestVOs.length; i++) {
				if( !"RS".equals(agnCommRequestVOs[i].getAcStsCd()) ) {
					agnCommRequestVOs[i].setUsrId(account.getUsr_id());
					updateVoList.add(agnCommRequestVOs[i]);
				}
			}
			dbDao.requestAGNCommRequest(updateVoList);
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
//		AgnReqRevInfoVO cafRevInfoVO = null;
		ChgInfoVO chgInfoVO1 = null;
		ChgInfoVO chgInfoVO2 = null;
		VslSvcLaneInfoVO vslSvcLaneInfoVO = null;

		StringBuffer commProcRsltRsn = new StringBuffer();
		String calcNo 		= "";
		String reCalcFlg 	= "Y";
		String bdrFlg 		= "";
		String blCvrdTpCd 	= "";

		String mstBkgNo 	= "";

		String bkgCreDt          = "";
		String svcScpCd          = "";
		String revMon 			 = "";
		String rtAplyDt 		 = "";

		String obSaDt           = "";
		String obVvd            = "";
		String obVslCd          = "";
		String obSkdVoyNo       = "";
		String obSkdDirCd       = "";
		String obPort           = "";
		String obSlanCd         = "";
		String obRlaneCd        = "";
		String obRevDirCd       = "";
		String ibSaDt           = "";
		String ibVvd            = "";
		String ibVslCd          = "";
		String ibSkdVoyNo       = "";
		String ibSkdDirCd       = "";
		String ibPort           = "";
		String ibSlanCd         = "";
		String ibRlaneCd        = "";
		String ibRevDirCd       = "";

		String ppdOfrtAmt       = "";
		String ppdChgAmt        = "";
		String cltOfrtAmt       = "";
		String cltChgAmt        = "";

		try {
			log.debug("===================== createAgnComm Start =====================");

			//GET_CALC_NO
			calcNo = dbDao.getCalcNo();
			log.debug("calcNo : " + calcNo);
			//GET_BKG_NUMBER
			bkgNumberVO = dbDao.getBkgNumber(bkgNo);
			if(bkgNumberVO != null) {
				mstBkgNo = bkgNo; // Covered BL 에 대한 special logic 삭제: bkgNumberVO.getMstBkgNo(); -> bkgNo
				blCvrdTpCd = bkgNumberVO.getBlCvrdTpCd();
				log.debug("bkgStsCd : " + bkgNumberVO.getBkgStsCd() + " / mstBkgNo : " + mstBkgNo);
				if("X".equals(bkgNumberVO.getBkgStsCd())) {
					AgnReqCalCondVO agnCondVO = new AgnReqCalCondVO();
					agnCondVO.setCalcNo(calcNo);
					agnCondVO.setUsrId(usrId);
					if(!"".equals(mstBkgNo)) {
						agnCondVO.setBkgNo(mstBkgNo);
						dbDao.modifyAcmAgnBkgInfo(agnCondVO);
						dbDao.removeAcmAgnComm(mstBkgNo);
						dbDao.modifyAcmAgnCommZeroSum(agnCondVO);
						dbDao.addAcmAgnBkgInfoHis(agnCondVO);//Data FROM ACM_AGN_BKG_INFO
						dbDao.addAcmAgnCommHis(agnCondVO);
					} else {
						agnCondVO.setBkgNo(bkgNo);
						dbDao.modifyAcmAgnBkgInfo(agnCondVO);
						dbDao.removeAcmAgnComm(bkgNo);
						dbDao.modifyAcmAgnCommZeroSum(agnCondVO);
						dbDao.addAcmAgnBkgInfoHis(agnCondVO);//Data FROM ACM_AGN_BKG_INFO
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
// Covered BL 에 대한 special logic 삭제
//			if("C".equals(blCvrdTpCd)) { 
//				dbDao.addAcmAgnBkgInfoHis(bkgNo, calcNo, blCvrdTpCd);//FROM BKG_BOOKING
//
//				AgnReqCalCondVO blCvrpTpVO = new AgnReqCalCondVO();
//				blCvrpTpVO.setCalcNo(calcNo);
//				blCvrpTpVO.setUsrId(usrId);
//				blCvrpTpVO.setBkgNo(bkgNo);
//				dbDao.modifyAcmAgnBkgInfo(blCvrpTpVO);
//				dbDao.removeAcmAgnComm(bkgNo);
//				dbDao.modifyAcmAgnCommZeroSum(blCvrpTpVO);
//				dbDao.addAcmAgnCommHis(blCvrpTpVO);
//			}
			//GET_BKG_CRE_DT
			bkgCreDtInfoVO = dbDao.getBkgCreDt(mstBkgNo);
			if(bkgCreDtInfoVO != null) {
				bkgCreDt = bkgCreDtInfoVO.getBkgCreDt();
//				bkgStsCd = bkgCreDtInfoVO.getBkgStsCd();
				svcScpCd = bkgCreDtInfoVO.getSvcScpCd();
			}

			//GET_REV_MON
			revMon = dbDao.getRevMon(mstBkgNo);
			if("".equals(revMon)) {
				commProcRsltRsn.append("REV_MON_is_Null ");
			}
			//GET_RT_APLY_DT
			rtAplyDt = dbDao.getRtAplyDt(mstBkgNo);
			if("".equals(rtAplyDt)) {
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

			if("".equals(obSaDt)) {
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
			//DELETE ACM_AGN_BKG_INFO
			dbDao.removeAcmAgnBkgInfo(mstBkgNo);
			//DELETE ACM_AGN_COMM
			dbDao.removeAcmAgnComm(mstBkgNo);			
			//DELETE ACM_AGN_COMM_DTL
			dbDao.removeAcmAgnCommDtl(mstBkgNo);
			//DELETE ACM_AGN_COMM_CHG
			dbDao.removeAcmAgnCommChg(mstBkgNo);
			//DELETE ACM_AGN_COMM_REV
			dbDao.removeAcmAgnCommRev(mstBkgNo);
			//DELETE ACM_AGN_COMM_TRSP
			dbDao.removeAcmAgnCommTrsp(mstBkgNo);

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
				String payXchRt2	 = null;

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

					if(!"USD".equals(agmtVO.getOfcCurrCd()) && !agmtVO.getAgmtCurrCd().equals(agmtVO.getOfcCurrCd()) || !"USD".equals(agmtVO.getAgmtCurrCd()) && "USD".equals(agmtVO.getOfcCurrCd())){
						agmtVO.setDiffCurrFlg("Y"); 
						payXchRt2 = dbDao.getPayXchRt(agmtVO);
						agmtVO.setPayXchRt2(payXchRt2);
					} 
					
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

// BOMBB 에 대한 로직 삭제					
//						if( ("O".equals(agmtVO.getIoBndCd()) && "G".equals(agmtVO.getAcTpCd()) && "BOMBB".equals(agmtVO.getAgnCd()) && "E".equals(officeCodeInfoVO.getDelContiCd())) //IF(   (v_io_bnd_cd = 'O' AND v_ac_tp_cd = 'G' AND v_agn_cd = 'BOMBB' AND v_del_conti_cd = 'E')
//								|| ("I".equals(agmtVO.getIoBndCd()) && "G".equals(agmtVO.getAcTpCd()) && "BOMBB".equals(agmtVO.getAgnCd()) && "E".equals(officeCodeInfoVO.getPorContiCd())) ) {//or (v_io_bnd_cd = 'I' AND v_ac_tp_cd = 'G' AND v_agn_cd = 'BOMBB' AND v_por_conti_cd = 'E') )
//							//GET_CAF_REV
//							cafRevInfoVO = dbDao.getCafRev(agmtVO);
//							if(cafRevInfoVO != null) {
//								ppdCafAmt = this.stringToDouble(cafRevInfoVO.getPpdCafAmt());
//								cctCafAmt = this.stringToDouble(cafRevInfoVO.getCctCafAmt());
//							}
//
//							if( (ppdCafAmt != 0 || cctCafAmt !=0) && "N".equals(agmtVO.getRevDivCd()) ) {//IF (v_ppd_caf_amt <> 0 or v_cct_caf_amt <> 0)
//								if("P".equals(commPayTermCd)) {
//									ppdOftAmt = ppdOftAmt + ppdCafAmt;
//								} else if("C".equals(commPayTermCd)) {
//									cctOftAmt = cctOftAmt + cctCafAmt;
//								} else if("T".equals(commPayTermCd)) {
//									ppdOftAmt = ppdOftAmt + ppdCafAmt;
//									cctOftAmt = cctOftAmt + cctCafAmt;
//								}
//							}
//							log.debug("      REV 2 CAF : "+ppdCafAmt+" - "+cctCafAmt);
//						}

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

					//Booking rating 되었을 때만 deduct logic 적용.
					if(!"0.0".equals(agmtVO.getTtlRevAmt()) && !"".equals(agmtVO.getTtlRevAmt())) {
						
						if(!"0".equals(agmtVO.getMatCntChg())) {//IF(v_mat_cnt_chg <> 0)
							log.debug("--> DDCT CHG");
							//DELETE ACM_AGN_COMM_CHG_REF
							dbDao.removeAcmAgnCommChgRef(mstBkgNo);
							//INSERT INTO ACM_AGN_COMM_CHG_REF
							dbDao.addAcmAgnCommChgRef(agmtVO);
							//INSERT INTO ACM_AGN_COMM_CHG
							dbDao.addAcmAgnCommChg(agmtVO);
						}

						//IF(v_rnk1 = 1 and (v_hlg_ddct_org_flg||v_hlg_ddct_org_flg||v_hlg_ddct_org_flg||v_hlg_ddct_org_flg LIKE '%Y%'))
						if( "1".equals(agmtVO.getRnk1()) && ("Y".equals(hlgDdctOrgFlg) || "Y".equals(hlgDdctDestFlg) || "Y".equals(fdrgDdctOrgFlg) || "Y".equals(fdrgDdctDestFlg)) ) {
							log.debug("--> DDCT TRSP");
							chgInfoVO1 = dbDao.getChgInfo1(mstBkgNo);
							if(!"".equals(chgInfoVO1.getHo())) {
								ho = ho + this.stringToInt(chgInfoVO1.getHo());
								hd = hd + this.stringToInt(chgInfoVO1.getHd());
								fo = fo + this.stringToInt(chgInfoVO1.getFo());
								fd = fd + this.stringToInt(chgInfoVO1.getFd());
							}
							chgInfoVO2 = dbDao.getChgInfo2(mstBkgNo);
							if(!"".equals(chgInfoVO2.getHo())) {
								ho = ho + this.stringToInt(chgInfoVO2.getHo());
								hd = hd + this.stringToInt(chgInfoVO2.getHd());
								fo = fo + this.stringToInt(chgInfoVO2.getFo());
								fd = fd + this.stringToInt(chgInfoVO2.getFd());
							}

							vslSvcLaneInfoVO = dbDao.getVslSvcLaneInfo(mstBkgNo);

							if(ho != 0) {
								hlgDdctOrgFlg = "X";
							}
							if(hd != 0) {
								hlgDdctDestFlg = "X";
							}
							if(fo != 0 || "0".equals(vslSvcLaneInfoVO.getPreFeederCheck())) {
								fdrgDdctOrgFlg = "X";
							}
							if(fd != 0 || "0".equals(vslSvcLaneInfoVO.getPstFeederCheck())) {
								fdrgDdctDestFlg = "X";
							}
							agmtVO.setHlgDdctOrgFlg(hlgDdctOrgFlg);
							agmtVO.setHlgDdctDestFlg(hlgDdctDestFlg);
							agmtVO.setFdrgDdctOrgFlg(fdrgDdctOrgFlg);
							agmtVO.setFdrgDdctDestFlg(fdrgDdctDestFlg);
							log.debug("--> cnt        = "+ho+"+"+hd+"+"+fo+"+"+fd);
							log.debug("--> ddct_flg   = "+hlgDdctOrgFlg+"+"+hlgDdctDestFlg+"+"+fdrgDdctOrgFlg+"+"+fdrgDdctDestFlg+" >> HO HD FO FD" );

							if("Y".equals(reCalcFlg)) {//IF (nvl(v_re_calc_flg,'N') = 'Y' )
								//INSERT INTO ACM_AGN_COMM_TRSP
								dbDao.addAcmAgnCommTrsp(agmtVO);
							}
						}
						log.debug("agmtVO.getAgnCd()=> "+agmtVO.getAgnCd());
						spclAgmtCnt = this.stringToInt(dbDao.getSpclAgmtCnt(agmtVO.getAgnCd()));
						//get v_spcl_agmt_cnt
						if(spclAgmtCnt > 0) {//IF(v_spcl_agmt_cnt>0)
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
						}
					}//Booking rating 되었을 때만 deduct logic 적용 End
					
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
						String usdFxComm2 = "0";
						
						if(!"".equals(agmtVO.getCommOfcCd()) && agmtVO.getCommOfcCd().equals(agmtVO.getAgnCd())){
							agmtVO.setMhFlg("Y");
						}else{
							agmtVO.setMhFlg("N");
						}

						String fxRealAmt = dbDao.getFxRealAmt(agmtVO);
						agmtVO.setFxRealAmt(fxRealAmt);
						if("USD".equals(agmtVO.getAgmtCurrCd()) && "USD".equals(agmtVO.getOfcCurrCd())) {//IF ( agmt_curr_cd == 'USD' )
							log.debug("--> fx curr_cd USD USD ");
							usdFxComm = fxRealAmt;
							payFxComm = fxRealAmt;
						} else if (!"USD".equals(agmtVO.getAgmtCurrCd()) && !"USD".equals(agmtVO.getOfcCurrCd())){
							//SELECT USD_LOCL_XCH_RT
							AgmtInfoVO commVO = dbDao.getLoclXchRtComm(agmtVO);
							if(agmtVO.getAgmtCurrCd().equals(agmtVO.getOfcCurrCd())){
								log.debug("--> fx curr_cd !USD == !USD ");
								usdFxComm = commVO.getUsdFxComm();
								payFxComm = fxRealAmt;
							}else{
								log.debug("--> fx curr_cd !USD <> !USD ");
								usdFxComm2 = commVO.getUsdFxComm2();
								commVO.setFxRealAmt(usdFxComm2);
								commVO.setPayXchRt(agmtVO.getPayXchRt());
								// !USD -> USD -> !USD
								AgmtInfoVO rsltVO = dbDao.getLoclXchRtComm(commVO);
								usdFxComm = usdFxComm2;
								if(rsltVO.getPayFxComm() == null){
									payFxComm = "0";
								}else{
									payFxComm = rsltVO.getPayFxComm();
								}
							}
							
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
						} else if(!"USD".equals(agmtVO.getAgmtCurrCd()) && "USD".equals(agmtVO.getOfcCurrCd())){
							log.debug("--> fx curr_cd !USD USD ");
							//SELECT USD_LOCL_XCH_RT
							AgmtInfoVO commVO = dbDao.getLoclXchRtComm(agmtVO);
							usdFxComm = commVO.getUsdFxComm2();
							payFxComm = commVO.getUsdFxComm2();									
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
						//INSERT INTO ACM_AGN_COMM_DTL
						dbDao.addAcmAgnCommDtlFx(agmtVO);
						 if(agmtVO.getMhFlg()=="Y"){
							 dbDao.addAcmAgnCommDtlFxMh(agmtVO); 
						 }
					}//if(!"X".equals(commFxAmt)) {

				}//if(Integer.parseInt(agmtVO.getDupChkCnt()) <= 1) {
			}//for(int i=0; i<agmtInfoList.size(); i++) {

			log.debug("zeroSumList Cnt: "+ zeroSumList.size());
			//Agreement 에 존재하지 않는 건에 대해서 데이터 갱신
			dbDao.modifyAcmAgnCommZeroSum2(zeroSumList);

			//INSERT INTO ACM_AGN_COMM_DTL
			dbDao.addAcmAgnCommDtl(condVO);
			/** History 테이블 입력 */
			//INSERT INTO ACM_AGN_COMM_CHG_REF_HIS
			dbDao.addAcmAgnCommChgRefHis(condVO);
			//INSERT INTO ACM_AGN_COMM_CHG_HIS
			dbDao.addAcmAgnCommChgHis(condVO);
			//INSERT INTO ACM_AGN_COMM_REV_HIS
			dbDao.addAcmAgnCommRevHis(condVO);
			//INSERT INTO ACM_AGN_COMM_TRSP_HIS
			dbDao.addAcmAgnCommTrspHis(condVO);
			//INSERT INTO ACM_AGN_COMM_DTL_HIS
			dbDao.addAcmAgnCommDtlHis(condVO);
			//INSERT INTO ACM_AGN_COMM_HIS
			dbDao.addAcmAgnCommHis(condVO);

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
	 * [ESM_ACM_0105] Retrive<br>
	 * Calculation Detail의 Transportation Cost Deduction 목록을 조회<br>
	 *
	 * @param CalcDtlBkgRevenueVO calcDtlBkgRevenueVO
	 * @return List<CalcDtlBkgRevenueVO>
	 * @exception EventException
	 */
	public List<CalcDtlBkgRevenueVO> searchCalcDtlTrsCstDeduction(CalcDtlBkgRevenueVO calcDtlBkgRevenueVO) throws EventException {
		try {
			return dbDao.searchCalcDtlTrsCstDeduction(calcDtlBkgRevenueVO);
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
	 * Calculation Detail의 Commission Detail 목록을 조회<br>
	 *
	 * @param CalcDtlBkgRevenueVO calcDtlBkgRevenueVO
	 * @return List<CalcDtlBkgRevenueVO>
	 * @exception EventException
	 */
	public List<CalcDtlBkgRevenueVO> searchCalcDtlCommissionDtl(CalcDtlBkgRevenueVO calcDtlBkgRevenueVO) throws EventException {
		try {
			return dbDao.searchCalcDtlCommissionDtl(calcDtlBkgRevenueVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

}