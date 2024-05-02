/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PickUpNoticeBCImpl.java
*@FileTitle : Pick up Notice Setup
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.12
*@LastModifier :
*@LastVersion : 1.0
* 2009.06.12
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.basic;

import java.io.IOException;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import m2soft.rdsystem.server.core.rddbagent.util.serverexport.ExportInfo;

import com.clt.apps.opus.bcm.sup.valuemanage.util.ConstantMgr;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration.InboundNoticeEAIDAO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration.PickUpNoticeDBDAO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.FaxSendVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.PkupCntrRtnYdVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.PkupNoMnlUpldSearchVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.PkupNoMnlUpldVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.PkupNoRptEmlCtntVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.PkupNoRptEmlUpldVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.PkupNoRptVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.PkupNoVerifyVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.PkupNtcFormCopyVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.PkupNtcFormVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.PkupNtcHrVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.PkupNtcManualListVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.PkupNtcSearchVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.PkupNtcSendListVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.PkupNtcSentHisListVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.PkupNtcSentHisSchVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.PkupWdVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.RDMailSendVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.util.log4j.StringUtils;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.framework.table.ComRptDsgnXptInfoVO;
import com.clt.syscommon.common.table.BkgNtcHisVO;
import com.clt.syscommon.common.table.BkgPkupCntrRtnYdVO;
import com.clt.syscommon.common.table.BkgPkupNtcDtlVO;
import com.clt.syscommon.common.table.BkgPkupNtcPkupNoHisVO;
import com.clt.syscommon.common.table.BkgPkupNtcPkupNoVO;
import com.clt.syscommon.common.table.BkgPkupNtcStupVO;
import com.clt.syscommon.common.table.BkgPkupNtcVO;
import com.clt.syscommon.common.util.ScheduleUtil;

/**
 *   InboundBLMgt Business Logic Basic Command implementation<br>
 * - InboundBLMgt에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author
 * @see ESM_BKG_0411EventResponse,PickUpNoticeBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class PickUpNoticeBCImpl extends BasicCommandSupport implements PickUpNoticeBC {

	// Database Access Object
	private transient PickUpNoticeDBDAO dbDao = null;

	/**
	 * PickUpNoticeBCImpl 객체 생성<br>
	 * PickUpNoticeDBDAO를 생성한다.<br>
	 */
	public PickUpNoticeBCImpl() {
		dbDao = new PickUpNoticeDBDAO();
	}

	/**
	 * PickUp Notice Form에 대한 기등록된 Office별 Del 목록을 조회한다.<br>
	 *
	 * @param String ntcSndTpCd Pickup Notice Send Type(A:Auto, M:Manual)
	 * @param String ofcCd Office Code
	 * @return List<BkgComboVO> Pickup Notice DEL Combo List
	 * @exception EventException
	 */
	public List<BkgComboVO> searchPkupNtcFormDelList (String ntcSndTpCd, String ofcCd) throws EventException {
		try {
			return dbDao.searchPkupNtcFormDelList(ntcSndTpCd, ofcCd);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}


	/**
	 * PickUp Notice Form에 대한 Setting 정보를 조회한다.<br>
	 *
	 * @param String ntcSndTpCd Pickup Notice Send Type(A:Auto, M:Manual)
	 * @param String ofcCd Office Code
	 * @param String delCd DEL Code
	 * @return PkupNtcFormVO Pickup Notice Setting Information
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public PkupNtcFormVO searchPkupNtcForm(String ntcSndTpCd, String ofcCd, String delCd) throws EventException {

		PkupNtcFormVO pickUpNoticeFormVO = new PkupNtcFormVO();
		BkgPkupNtcStupVO bkgPkupNtcStupVO = new BkgPkupNtcStupVO();
		PkupWdVO[] bkgPkupWdVOs = new PkupWdVO[2];
		List<PkupNtcHrVO>[] bkgPkupNtcHrVOs = new ArrayList[2];

		String preFomCd = "PRE";
		String arrFomCd = "ARR";

		try {

			bkgPkupNtcStupVO = dbDao.searchPkupNtcStup(ntcSndTpCd, ofcCd, delCd);

			if (bkgPkupNtcStupVO != null) {
				// Pre-Arrival Notice
				bkgPkupWdVOs[0] = dbDao.searchPkupWd(preFomCd, bkgPkupNtcStupVO.getPkupNtcSeq());
				if (bkgPkupWdVOs[0] != null) {
					bkgPkupNtcHrVOs[0] = dbDao.searchPkupNtcHr(preFomCd, bkgPkupNtcStupVO.getPkupNtcSeq());
				}

				// Arrival Notice
				bkgPkupWdVOs[1] = dbDao.searchPkupWd(arrFomCd, bkgPkupNtcStupVO.getPkupNtcSeq());
				if (bkgPkupWdVOs[1] != null) {
					bkgPkupNtcHrVOs[1] = dbDao.searchPkupNtcHr(arrFomCd, bkgPkupNtcStupVO.getPkupNtcSeq());
				}

				pickUpNoticeFormVO.setBkgPkupNtcStupVO(bkgPkupNtcStupVO);
				pickUpNoticeFormVO.setBkgPkupWdVOs(bkgPkupWdVOs);
				pickUpNoticeFormVO.setBkgPkupNtcHrVOs(bkgPkupNtcHrVOs);
			} else {
//				BkgPkupNtcStupVO bkgPkupNtcStupTempVO = new BkgPkupNtcStupVO();
//				PkupWdVO[] bkgPkupWdTempVOs = new PkupWdVO[2];
//				List<PkupNtcHrVO>[] bkgPkupNtcHrTempVOs = new ArrayList[2];
//
//				pickUpNoticeFormVO.setBkgPkupNtcStupVO(bkgPkupNtcStupTempVO);
//				pickUpNoticeFormVO.setBkgPkupWdVOs(bkgPkupWdTempVOs);
//				pickUpNoticeFormVO.setBkgPkupNtcHrVOs(bkgPkupNtcHrTempVOs);

				pickUpNoticeFormVO.setBkgPkupNtcStupVO(bkgPkupNtcStupVO);
				pickUpNoticeFormVO.setBkgPkupWdVOs(bkgPkupWdVOs);
				pickUpNoticeFormVO.setBkgPkupNtcHrVOs(bkgPkupNtcHrVOs);
			}


			return pickUpNoticeFormVO;

		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}


	/**
	 * PickUp Notice Form 정보를 수정 혹은 저장한다.<br>
	 *
	 * @param String ofcCd Office Code
	 * @return PkupNtcFormVO Pickup Notice Setting Information
	 * @exception EventException
	 */
	public PkupNtcFormVO searchPkupNtcFormByManual(String ofcCd) throws EventException {

		PkupNtcFormVO pickUpNoticeFormVO = new PkupNtcFormVO();
		BkgPkupNtcStupVO bkgPkupNtcStupVO = new BkgPkupNtcStupVO();
		PkupWdVO[] bkgPkupWdVOs = new PkupWdVO[3];

		String ev1FomCd = "EV1";
		String ev2FomCd = "EV2";
		String ev3FomCd = "EV3";

		try {
			/** PickUp Notice Send Type Code(A:Auto, M:Manual) */
			String ntcSndTpCd = "M";
			String delCd = "*"; // DEL Code

			bkgPkupNtcStupVO = dbDao.searchPkupNtcStup(ntcSndTpCd, ofcCd, delCd);

			if (bkgPkupNtcStupVO != null) {
//			if (bkgPkupNtcStupVO.getMaxRows() > 0) {
				// Event #1
				bkgPkupWdVOs[0] = dbDao.searchPkupWd(ev1FomCd, bkgPkupNtcStupVO.getPkupNtcSeq());

				// Event #2
				bkgPkupWdVOs[1] = dbDao.searchPkupWd(ev2FomCd, bkgPkupNtcStupVO.getPkupNtcSeq());

				// Event #3
				bkgPkupWdVOs[2] = dbDao.searchPkupWd(ev3FomCd, bkgPkupNtcStupVO.getPkupNtcSeq());

				pickUpNoticeFormVO.setBkgPkupNtcStupVO(bkgPkupNtcStupVO);
				pickUpNoticeFormVO.setBkgPkupWdVOs(bkgPkupWdVOs);
			} else {
				pickUpNoticeFormVO.setBkgPkupNtcStupVO(bkgPkupNtcStupVO);
				pickUpNoticeFormVO.setBkgPkupWdVOs(bkgPkupWdVOs);
			}



			return pickUpNoticeFormVO;

		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 * PickUp Notice Form 정보를 수정 혹은 저장한다.<br>
	 *
	 * @param BkgPkupNtcStupVO ntcStup Pickup Notice Setup Information
	 * @param PkupWdVO[] wds Pickup Notice Word Information
	 * @param PkupNtcHrVO[] ntcHrs Pickup Notice Hour Information
	 * @param SignOnUserAccount account User Account
	 * @exception EventException
	 */
	public void setupPkupNtcForm (BkgPkupNtcStupVO ntcStup, PkupWdVO[] wds, PkupNtcHrVO[] ntcHrs, SignOnUserAccount account) throws EventException {

		try {

			/** PickUp Notice Setup */
			ntcStup.setCreUsrId(account.getUsr_id());
			ntcStup.setUpdUsrId(account.getUsr_id());

			dbDao.mergePkupNtcStup(ntcStup);


			/** PickUp Word */
			List<PkupWdVO> wdVoList = new ArrayList<PkupWdVO>();

			for ( int i=0; i<wds.length; i++ ) {
				wds[i].setCreUsrId(account.getUsr_id());
				wds[i].setUpdUsrId(account.getUsr_id());
				wdVoList.add(wds[i]);
			}

			if ( wdVoList.size() > 0 ) {
				dbDao.mergePkupWd(wdVoList);
			}


			/** PickUp Notice Hour */
			List<PkupNtcHrVO> insertHrVoList = new ArrayList<PkupNtcHrVO>();

			for ( int i=0; i<ntcHrs.length; i++ ) {
				if (ntcStup.getIbflag().equals("I")) ntcHrs[i].setPkupNtcSeq(ntcStup.getPkupNtcSeq());
				ntcHrs[i].setCreUsrId(account.getUsr_id());
				ntcHrs[i].setUpdUsrId(account.getUsr_id());
				insertHrVoList.add(ntcHrs[i]);
			}

			dbDao.removePkupNtcHr(ntcStup.getPkupNtcSeq());

			if ( insertHrVoList.size() > 0 ) {
				dbDao.addPkupNtcHr(insertHrVoList);
			}

		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}


	/**
	 * PickUp Notice Form 정보를 삭제한다.<br>
	 *
	 * @param String pkupNtcSeq
	 * @exception EventException
	 */
	public void removePkupNtcForm (String pkupNtcSeq) throws EventException {

		try {

			/** PickUp Notice Hour */
			dbDao.removePkupNtcHr(pkupNtcSeq);

			/** PickUp Word */
			dbDao.removePkupWd(pkupNtcSeq);

			/** PickUp Notice Setup */
			dbDao.removePkupNtcStup(pkupNtcSeq);

		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 * PickUp Notice Form 정보를 수정 혹은 저장한다.<br>
	 *
	 * @param BkgPkupNtcStupVO ntcStup Pickup Notice Setup Information
	 * @param PkupWdVO[] wds Pickup Notice Word Information
	 * @param SignOnUserAccount account User Account
	 * @exception EventException
	 */
	public void setupPkupNtcFormByManual (BkgPkupNtcStupVO ntcStup, PkupWdVO[] wds, SignOnUserAccount account) throws EventException {

		try {

			/** PickUp Notice Setup */
			ntcStup.setCreUsrId(account.getUsr_id());
			ntcStup.setUpdUsrId(account.getUsr_id());

			dbDao.mergePkupNtcStup(ntcStup);


			/** PickUp Word */
			List<PkupWdVO> wdVoList = new ArrayList<PkupWdVO>();

			for ( int i=0; i<wds.length; i++ ) {
				wds[i].setCreUsrId(account.getUsr_id());
				wds[i].setUpdUsrId(account.getUsr_id());
				wdVoList.add(wds[i]);
			}

			if ( wdVoList.size() > 0 ) {
				dbDao.mergePkupWd(wdVoList);
			}

		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 * Manually Pickup Notice를 송부할 대상(Container)을 Upload한 후 해당 컨테이너별 상세 정보를 조회한다.<br>
	 *
	 * @param String[] blNo Pickup Notice Basic Information
	 * @return List<PkupNtcManualListVO>
	 * @exception EventException
	 */
	public List<PkupNtcManualListVO> searchPkupNtcListByManual(String[] blNo) throws EventException {
		try {
			return dbDao.searchPkupNtcListByManual(blNo);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 * Manually Upload한 컨테이너별 P/N 대상 데이타를 Setup한다.<br>
	 *
	 * @param PkupNtcManualListVO[] pkupNtcManualLists
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void setupPkupNtcListByManual(PkupNtcManualListVO[] pkupNtcManualLists, SignOnUserAccount account) throws EventException{

		PkupNtcManualListVO vo = null;
		BkgPkupNtcPkupNoVO noVo = null;

		try {

			for (int i=0; i<pkupNtcManualLists.length; i++) {
				vo = pkupNtcManualLists[i];

				// Yard 코드 유효성 체크
				if (!"".equals(vo.getPkupYdCd())) {
					if (dbDao.checkYardCode(vo.getPkupYdCd()) == false)
						throw new EventException(new ErrorHandler("BKG01078", new String[]{vo.getPkupYdCd()}).getMessage());
				}

				// Yard 코드 유효성 체크
				if (!"".equals(vo.getRtnYdCd())) {
					if (dbDao.checkYardCode(vo.getRtnYdCd()) == false)
						throw new EventException(new ErrorHandler("BKG01078", new String[]{vo.getRtnYdCd()}).getMessage());
				}

				// Pickup Number
				noVo = new BkgPkupNtcPkupNoVO();

				noVo.setBkgNo(vo.getBkgNo());
				noVo.setCntrNo(vo.getCntrNo());
				// 신규인 경우, DEL 의 EQ Office 코드로 저장
				noVo.setOfcCd(vo.getEqCtrlOfcCd());
				noVo.setBlNo(vo.getBlNo());
				noVo.setVslCd(vo.getVslCd());
				noVo.setSkdVoyNo(vo.getSkdVoyNo());
				noVo.setSkdDirCd(vo.getSkdDirCd());
				noVo.setPodCd(vo.getPodCd());
				noVo.setDelCd(vo.getDelCd());
				noVo.setDeTermCd(vo.getDeTermCd());
				noVo.setIbdTrspHubCd(vo.getIbdTrspHubCd());
				noVo.setPkupYdCd(vo.getPkupYdCd());
				noVo.setPkupNo(vo.getPkupNo());
				noVo.setPkupAvalDt(vo.getPkupAvalDt());
				noVo.setLstFreeDt(vo.getLstFreeDt());
				noVo.setRtnYdCd(vo.getRtnYdCd());
				noVo.setPkupNtcSndKnt(vo.getPkupNtcSndKnt());
				noVo.setPkupCreDt("");
				noVo.setPkupCreUsrId(account.getUsr_id());
				noVo.setPkupUpdDt("");
				noVo.setPkupUpdUsrId(account.getUsr_id());
				noVo.setDeltFlg("N");
				noVo.setCreUsrId(account.getUsr_id());
				noVo.setCreDt("");
				noVo.setUpdUsrId(account.getUsr_id());
				noVo.setUpdDt("");
				noVo.setRailArrDt(vo.getRailArrDt());
				noVo.setRailDepDt(vo.getRailDepDt());
				noVo.setPkupMnlUpldFlg("Y");


				// History 기록 - 변경전 데이터 등록
				dbDao.addPkupNtcPkupNoHis(noVo.getBkgNo(), noVo.getCntrNo(), noVo.getOfcCd());

				// Pickup No. 수정 또는 등록
				if (dbDao.modifyPkupNtcPkupNo(noVo) == 0) {
					dbDao.addPkupNtcPkupNo(noVo);
				}

				// PickUp Notice 관련 데이터 변경
				dbDao.modifyPkupNtcByPkupNtcNo(noVo);
			}

		} catch(EventException ex) {
			throw ex;
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 * PickUp Notice를 발송(Success)한 대상 및 미 발송(Fail or 누락)된 대상정보들을 조회한다.<br>
	 *
	 * @param PkupNtcSearchVO search 검색 조건
	 * @return List<PkupNtcSendListVO>
	 * @exception EventException
	 */
	public List<PkupNtcSendListVO> searchPkupNtcSendList(PkupNtcSearchVO search) throws EventException {
		try {
			return dbDao.searchPkupNtcSendList(search);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}


	/**
	 * 미 발송(Fail or 누락)된 대상정보들을 조회 후 부가 정보를 수정 후 저장한다.<br>
	 *
	 * @param PkupNtcSendListVO[] pkupNtcSendLists
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyPkupNtcSendList (PkupNtcSendListVO[] pkupNtcSendLists, SignOnUserAccount account) throws EventException {

		BkgPkupNtcDtlVO bkgPkupNtcDtlVO = null;
		PkupNtcSendListVO vo = null;
		String bkgNo  = "";
		String ntcSeq = "";
		String mnlFlg = "";

		try {

			for (int i=0; i<pkupNtcSendLists.length; i++) {

				vo = pkupNtcSendLists[i];


				/* Booking Pickup Notice */
				bkgNo  = vo.getBkgNo();
				ntcSeq = vo.getNtcSeq();
				mnlFlg = vo.getMnlFlg();


				// 미전송인 경우에 한하여 팩스/이메일 변경 가능
				if ("Y".equals(vo.getSndYn())) continue;

				// 미전송인 경우에 한하여 팩스/이메일 변경 가능 - 최종 확인!!
				if ("N".equals(dbDao.searchPkupNtcSndStsCd(bkgNo, ntcSeq)))
				{
					/* Booking Pickup Notice Detail */
					for (int k=0; k<5; k++) {

						bkgPkupNtcDtlVO = new BkgPkupNtcDtlVO();

						bkgPkupNtcDtlVO.setBkgNo(bkgNo);
						bkgPkupNtcDtlVO.setNtcSeq(ntcSeq);

						if (k == 0) {
							bkgPkupNtcDtlVO.setCustCntcTpCd("C1");
							bkgPkupNtcDtlVO.setFaxNo(vo.getC1FaxNo());
							bkgPkupNtcDtlVO.setNtcEml(vo.getC1NtcEml());
						} else if (k == 1) {
							bkgPkupNtcDtlVO.setCustCntcTpCd("C2");
							bkgPkupNtcDtlVO.setFaxNo(vo.getC2FaxNo());
							bkgPkupNtcDtlVO.setNtcEml(vo.getC2NtcEml());
						} else if (k == 2) {
							bkgPkupNtcDtlVO.setCustCntcTpCd("B1");
							bkgPkupNtcDtlVO.setFaxNo(vo.getB1FaxNo());
							bkgPkupNtcDtlVO.setNtcEml(vo.getB1NtcEml());
						} else if (k == 3) {
							bkgPkupNtcDtlVO.setCustCntcTpCd("B2");
							bkgPkupNtcDtlVO.setFaxNo(vo.getB2FaxNo());
							bkgPkupNtcDtlVO.setNtcEml(vo.getB2NtcEml());
						} else if (k == 4) {
							bkgPkupNtcDtlVO.setCustCntcTpCd("AN");
							bkgPkupNtcDtlVO.setFaxNo(vo.getAnFaxNo());
							bkgPkupNtcDtlVO.setNtcEml(vo.getAnNtcEml());
						}

						bkgPkupNtcDtlVO.setFaxTpCd("M");
						bkgPkupNtcDtlVO.setEmlTpCd("M");
						bkgPkupNtcDtlVO.setCreUsrId(account.getUsr_id());
						bkgPkupNtcDtlVO.setUpdUsrId(account.getUsr_id());


						// 데이터가 없으면 삭제
						if ("".equals(bkgPkupNtcDtlVO.getFaxNo()) && "".equals(bkgPkupNtcDtlVO.getNtcEml()))
						{
							dbDao.deletePkupNtcDtlByBkgNo(bkgPkupNtcDtlVO);
						}
						// 데이터가 있으면 등록/수정
						else
						{
							if (dbDao.modifyPkupNtcDtlByBkgNo(bkgPkupNtcDtlVO) == 0) {
								dbDao.addPkupNtcDtlByBkgNo(bkgPkupNtcDtlVO);
							}
						}
					}
				}

			}

		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}


	/**
	 * 픽업 대상정보들을 사용자 확인을 저장한다<br>
	 *
	 * @param PkupNtcSendListVO[] pkupNtcSendLists
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void verifyPkupNtcSendList (PkupNtcSendListVO[] pkupNtcSendLists, SignOnUserAccount account) throws EventException {

		PkupNtcSendListVO vo = null;
		String bkgNo  = "";
		String ntcSeq = "";
		String mnlFlg = "";

		try {

			for (int i=0; i<pkupNtcSendLists.length; i++) {

				vo = pkupNtcSendLists[i];


				/* Booking Pickup Notice */
				bkgNo  = vo.getBkgNo();
				ntcSeq = vo.getNtcSeq();
				mnlFlg = vo.getMnlFlg();

				dbDao.modifyPkupNtcByMnl(bkgNo, ntcSeq, mnlFlg, account.getUsr_id());
			}

		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}


	/**
	 * 미 발송(Fail or 누락)된 대상정보들을 Manual로 Pick-up Notice Fax 전송한다.
	 *
	 * @param PkupNtcSendListVO[] pkupNtcSendLists
	 * @param SignOnUserAccount account
	 * @return List<BkgNtcHisVO>
	 * @exception EventException
	 */
	public List<BkgNtcHisVO> sendPkupNtcByFax(PkupNtcSendListVO[] pkupNtcSendLists, SignOnUserAccount account) throws EventException {

		PkupNtcSendListVO vo  = null;
		List<PkupNtcSendListVO> sendInfo = null;
		BkgPkupNtcVO bkgPkupNtc = null;
		BkgPkupNtcDtlVO bkgPkupNtcDtl = null;
		List <BkgPkupNtcDtlVO> bkgPkupNtcDtls = new ArrayList<BkgPkupNtcDtlVO>();

		FaxSendVO faxInfo = null;
		String sendId = null;
		HashMap<String, String> sendIdList = new HashMap<String, String>();
		BkgNtcHisVO bkgNtcHisVO = null;
		List<BkgNtcHisVO> bkgNtcHisVOs = new ArrayList<BkgNtcHisVO>();
		InboundNoticeEAIDAO eaiDao = new InboundNoticeEAIDAO();

		Date now = new Date();
		SimpleDateFormat sndFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


		try {

			/*
			 *  BL 기준으로 정렬 - BL 기준으로 한건만 보내기 위해
			 */
			List<Object> sortLists = sortArray(pkupNtcSendLists, "blNo", "bkgCustTpCd");


			/*
			 * Pickup Notice 등록 -> Pickup Notice Detail 등록 -> Fax 전송 -> Send History 반환
			 */
			for (int i=0; i<sortLists.size(); i++) {

				sendInfo = (List<PkupNtcSendListVO>) sortLists.get(i);

				// start
				for (int ss=0; ss<sendInfo.size(); ss++) {

					vo = sendInfo.get(ss);


					/*
					 *  1. Booking Pickup Notice
					 */
					// Pickup Notice VO 생성
					bkgPkupNtc = new BkgPkupNtcVO();

					bkgPkupNtc.setBkgNo(vo.getBkgNo());
					bkgPkupNtc.setNtcSeq(vo.getNtcSeq());
					bkgPkupNtc.setPkupNtcTpCd(vo.getPkupNtcTpCd());
					bkgPkupNtc.setPkupNtcFomCd(vo.getPkupNtcFomCd());
					bkgPkupNtc.setCustCntCd(vo.getCustCntCd());
					bkgPkupNtc.setCustSeq(vo.getCustSeq());
					bkgPkupNtc.setCustNm(vo.getCustNm());
					bkgPkupNtc.setPkupNtcEvntDt(sndFormat.format(now));
					bkgPkupNtc.setExpSndDt(sndFormat.format(now));
					bkgPkupNtc.setCntrNo(vo.getCntrNo());
					bkgPkupNtc.setRailLodDt(vo.getRailLodDt());
					bkgPkupNtc.setNtfcDt(vo.getPkupAvalDt()); // avalDt 와 동일하게 입력!!
					bkgPkupNtc.setFrtCltFlg(vo.getFrtCltFlg());
					bkgPkupNtc.setOblCltFlg(vo.getOblCltFlg());
					bkgPkupNtc.setCstmsClrFlg(vo.getCstmsClrFlg());
					bkgPkupNtc.setEdi322MvmtCd(vo.getEdi322MvmtCd());
					bkgPkupNtc.setDorTrkrWoFlg(vo.getDorTrkrWoFlg());
					bkgPkupNtc.setPkupNtcSndStsCd("Y"); // 전송처리
					bkgPkupNtc.setIbdTrspHubCd(vo.getIbdTrspHubCd());
					bkgPkupNtc.setDiffRmk(vo.getDiffRmk());
					bkgPkupNtc.setCreUsrId(account.getUsr_id());
					bkgPkupNtc.setUpdUsrId(account.getUsr_id());
					bkgPkupNtc.setMnlCngFlg("Y");
					bkgPkupNtc.setBkgCustTpCd(vo.getBkgCustTpCd());
					bkgPkupNtc.setTrspSoOfcCtyCd(vo.getTrspSoOfcCtyCd());
					bkgPkupNtc.setTrspSoSeq(vo.getTrspSoSeq());
					bkgPkupNtc.setEclzOblCpyFlg(vo.getEclzOblCpyFlg());
					bkgPkupNtc.setMnlFlg(vo.getMnlFlg());

					bkgPkupNtc.setNtcSeq(dbDao.searchPkupNtcNextSeq(vo.getBkgNo()));
					bkgPkupNtc.setPkupNtcTpCd("MA");

					dbDao.addPkupNtc(bkgPkupNtc);



					/* 2. Booking Pickup Notice Detail */
					bkgPkupNtcDtls = new ArrayList<BkgPkupNtcDtlVO>();
					for (int k=0; k<5; k++) {

						if (k == 0) {
							if (!"1".equals(vo.getC1FaxNoChk())) continue;
						} else if (k == 1) {
							if (!"1".equals(vo.getC2FaxNoChk())) continue;
						} else if (k == 2) {
							if (!"1".equals(vo.getB1FaxNoChk())) continue;
						} else if (k == 3) {
							if (!"1".equals(vo.getB2FaxNoChk())) continue;
						} else if (k == 4) {
							if (!"1".equals(vo.getAnFaxNoChk())) continue;
						}

						bkgPkupNtcDtl = new BkgPkupNtcDtlVO();

						bkgPkupNtcDtl.setBkgNo(bkgPkupNtc.getBkgNo());
						bkgPkupNtcDtl.setNtcSeq(bkgPkupNtc.getNtcSeq());

						if (k == 0) {
							bkgPkupNtcDtl.setCustCntcTpCd("C1");
							bkgPkupNtcDtl.setFaxNo(vo.getC1FaxNo());
						} else if (k == 1) {
							bkgPkupNtcDtl.setCustCntcTpCd("C2");
							bkgPkupNtcDtl.setFaxNo(vo.getC2FaxNo());
						} else if (k == 2) {
							bkgPkupNtcDtl.setCustCntcTpCd("B1");
							bkgPkupNtcDtl.setFaxNo(vo.getB1FaxNo());
						} else if (k == 3) {
							bkgPkupNtcDtl.setCustCntcTpCd("B2");
							bkgPkupNtcDtl.setFaxNo(vo.getB2FaxNo());
						} else if (k == 4) {
							bkgPkupNtcDtl.setCustCntcTpCd("AN");
							bkgPkupNtcDtl.setFaxNo(vo.getAnFaxNo());
						}

						bkgPkupNtcDtl.setFaxTpCd("M");
						bkgPkupNtcDtl.setFaxSndUsrId(account.getUsr_id());
						bkgPkupNtcDtl.setCreUsrId(account.getUsr_id());
						bkgPkupNtcDtl.setUpdUsrId(account.getUsr_id());


						bkgPkupNtcDtls.add(bkgPkupNtcDtl);
					}

					dbDao.addPkupNtcDtls(bkgPkupNtcDtls);



					/* 3. Fax 전송 */
					if (ss == 0) sendIdList = new HashMap<String, String>();

					for (int k=0; k<bkgPkupNtcDtls.size(); k++) {

						bkgPkupNtcDtl = bkgPkupNtcDtls.get(k);

						// 한번만 전송. 이외는 SendID 공유
						if (ss == 0) {

							faxInfo = new FaxSendVO();

							if((vo.getPodCd() != null  && vo.getDelCd() != null && !"".equals(vo.getPodCd()) && !"".equals(vo.getDelCd()) &&
									"CA".equals(vo.getPodCd().substring(0,2)) && "CA".equals(vo.getDelCd().substring(0,2)))
									|| ("CAHAL01".equals(vo.getPkupYdCd()) && vo.getPkupYdCd() != null && !"".equals(vo.getPkupYdCd()))){
							faxInfo.setTmplMrd("ESM_BKG_5032.mrd");
							}else{
							faxInfo.setTmplMrd("ESM_BKG_5018.mrd");
							}
							faxInfo.setSysCd("BKG");
							faxInfo.setBatchFlg("N");
							faxInfo.setTitle("PickUp Notice(BL#: "+bkgPkupNtcDtl.getBkgNo()+")");
							faxInfo.setTmplParam("/rv bkg_no['" + bkgPkupNtcDtl.getBkgNo() + "'] ntc_seq['" + bkgPkupNtcDtl.getNtcSeq() + "'] usr_id['" +
												 account.getUsr_id() + "'] ofc_cd['" + account.getOfc_cd() + "'] p_pkup_ntc_fom_cd[''] p_pkup_yd_cd[''] p_rtn_yd_cd[''] p_rmk[''] form_showPuFlg['" + bkgPkupNtcDtl.getShowPuFlg() + "'] ");
							faxInfo.setRcvInfo(vo.getCustNm().replaceAll("\r\n", " ").replaceAll(";", " ") + ";" + bkgPkupNtcDtl.getFaxNo());
							faxInfo.setOffice(account.getOfc_cd());
							faxInfo.setCrtUserId(account.getUsr_id());

							// Send Fax
							sendId = eaiDao.sendFax(faxInfo);


							if ("Y".equals(vo.getEclzOblCpyFlg())) {
								faxInfo = new FaxSendVO();

								faxInfo.setTmplMrd("ESM_BKG_0109_OBL_A4.mrd");
								faxInfo.setSysCd("BKG");
								faxInfo.setBatchFlg("N");
								faxInfo.setTitle("BL Copy(BL#: "+bkgPkupNtcDtl.getBkgNo()+")");
								faxInfo.setTmplParam("/rv form_bkgNo[('" + bkgPkupNtcDtl.getBkgNo() + "')] " +
														" form_type[2] " +
														" form_dataOnly[N] " +
														" form_manifest[N] " +
														" form_usrId[" + account.getUsr_id() + "] " +
														" form_hiddeData[N] " +
														" form_level[(6)] " +
														" form_remark[] " +
														" form_Cntr[1] " +
														" form_mainOnly[N] " +
														" form_CorrNo[] " +
														" form_his_cntr[BKG_CONTAINER] " +
														" form_his_bkg[BKG_BOOKING] " +
														" form_his_mkd[BKG_BL_MK_DESC] " +
														" form_his_xpt[BKG_XPT_IMP_LIC] " +
														" form_his_bl[BKG_BL_DOC] " +

														//2015.01.27 안진응 추가
														" form_rqst_via_cd[] " +
														" form_his_bl_mkd[BKG_BL_ISS] " +
														" form_path[] " +
														" isEncode[Y] " +
														" form_end_no[] " +
														" form_esig[] form_cpy_esig[] form_knt_flg[] form_count[] " +

													 "/rp [] /riprnmargin");
								faxInfo.setRcvInfo(vo.getCustNm().replaceAll("\r\n", " ").replaceAll(";", " ") + ";"+bkgPkupNtcDtl.getFaxNo());
								faxInfo.setOffice(account.getOfc_cd());
								faxInfo.setCrtUserId(account.getUsr_id());

								// Send Fax
								eaiDao.sendFax(faxInfo);
							}

							sendIdList.put(bkgPkupNtcDtl.getCustCntcTpCd(),sendId);
						}
						else {
							sendId = sendIdList.get(bkgPkupNtcDtl.getCustCntcTpCd());
						}


						bkgPkupNtcDtls.get(k).setFaxSndUsrId(account.getUsr_id());
						bkgPkupNtcDtls.get(k).setFaxNtcSndId(sendId);
					}



					/* 4. SendId 기록 */
					dbDao.modifySendIdByFax(bkgPkupNtcDtls);


					/* 5. Notice History Setting */
					for (int k=0; k<bkgPkupNtcDtls.size(); k++) {
						bkgPkupNtcDtl = bkgPkupNtcDtls.get(k);


						bkgNtcHisVO = new BkgNtcHisVO();

						bkgNtcHisVO.setNtcViaCd("F"); //F:Fax,M:Email
						bkgNtcHisVO.setSndId(bkgPkupNtcDtl.getFaxNtcSndId());
						bkgNtcHisVO.setSndOfcCd(account.getOfc_cd());
						bkgNtcHisVO.setSndUsrId(account.getUsr_id());
						bkgNtcHisVO.setCreUsrId(account.getUsr_id());
						bkgNtcHisVO.setUpdUsrId(account.getUsr_id());
						bkgNtcHisVO.setBkgNo(bkgPkupNtcDtl.getBkgNo());
						bkgNtcHisVO.setNtcSeq(bkgPkupNtcDtl.getNtcSeq());
						bkgNtcHisVO.setCustCntcTpCd(bkgPkupNtcDtl.getCustCntcTpCd());

						bkgNtcHisVOs.add(dbDao.searchPkupNtcHistory(bkgNtcHisVO));
					}

				}  // end~
			}


			return bkgNtcHisVOs;

		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}


	/**
	 * Array를 정렬조건(compareName)를 기준으로 재정렬한다.<br>
	 * <br>
	 * 예) <br>
	 * ConfirmHldNtcSendListVO[] hldNtcSendLists = new ConfirmHldNtcSendListVO[];<br>
	 * sortArray(hldNtcSendLists, "ntcEml");<br>
	 *
	 * @param Object[] objects 정렬 대상
	 * @param String compareName1 정렬 조건명
	 * @param String compareName2 정렬 조건명
	 * @return List<Object>
	 * @throws Exception
	 */
	private List<Object> sortArray(Object[] objects, String compareName1, String compareName2) throws Exception {

		List<Object> results = new ArrayList<Object>();

		Object temp = null; // 비교대상을 담는 임시 Object
		List<Object> temps = null; // 비교값이 동일한 Object 모음
		String str11, str12, str21, str22;
		int i, j, cnt = 0;
		String funcName1 = "";
		String funcName2 = "";


		// 널인 경우
		if (objects == null || objects.length == 0) return null;
		if (compareName1 == null || compareName1.length() == 0) return null;


		if (compareName1.length() > 1) funcName1 = "get" + compareName1.substring(0,1).toUpperCase() + compareName1.substring(1);
		else funcName1 = "get" + compareName1.toUpperCase();

		if (compareName2.length() > 1) funcName2 = "get" + compareName2.substring(0,1).toUpperCase() + compareName2.substring(1);
		else funcName2 = "get" + compareName2.toUpperCase();


		Method meth1 = objects[0].getClass().getMethod(funcName1);
		Method meth2 = objects[0].getClass().getMethod(funcName2);


		for (i=0; i<objects.length; i++)
		{
			str11 = "";
			str12 = "";
			str21 = "";
			str22 = "";
			temps = new ArrayList<Object>();

			for(cnt=0, j=i; j<objects.length; j++)
			{
				if (j == i) {
					str11 = (String) meth1.invoke(objects[i]);
					str12 = (String) meth2.invoke(objects[i]);

					// 시작 Object
					temps.add(objects[j]);
				} else {
					str21 = (String) meth1.invoke(objects[j]);
					str22 = (String) meth2.invoke(objects[j]);

					if (str11.compareTo(str21) == 0 && str12.compareTo(str22) == 0)
					{
						// 동일값을 갖는 Object 추가
						temps.add(objects[j]);

						cnt++;

						// 배열 위치 이동(재비교하지 않기 위해)
						temp = objects[i+cnt];
						objects[i+cnt] = objects[j];
						objects[j] = temp;
					}
				}
			}

			// 비교값이 동일한 Object 들을 추가
			results.add(temps);

			// 동일 Object 만큼 Skip
			i = i + cnt;
		}

		return results;
	}

	/**
	 * 미 발송(Fail or 누락)된 대상정보들을 Manual로 Pick-up Notice Email 전송한다.
	 *
	 * @param PkupNtcSendListVO[] pkupNtcSendLists
	 * @param SignOnUserAccount account
	 * @return List<BkgNtcHisVO>
	 * @exception EventException
	 */
	public List<BkgNtcHisVO> sendPkupNtcByEmail(PkupNtcSendListVO[] pkupNtcSendLists, SignOnUserAccount account) throws EventException {

		PkupNtcSendListVO vo  = null;
		List<PkupNtcSendListVO> sendInfo = null;

		BkgPkupNtcVO bkgPkupNtc = null;
		List<BkgPkupNtcVO> bkgPkupNtcs = new ArrayList<BkgPkupNtcVO>();
		BkgPkupNtcDtlVO bkgPkupNtcDtl = null;
		List <BkgPkupNtcDtlVO> bkgPkupNtcDtls = null;

		List <List<BkgPkupNtcDtlVO>> bkgPkupNtcDtlGroup = null;
		List <List<List<BkgPkupNtcDtlVO>>> bkgPkupNtcDtlList = new ArrayList<List<List<BkgPkupNtcDtlVO>>>();

		RDMailSendVO mailInfo = null;
		List<RDMailSendVO> mailInfos = new ArrayList<RDMailSendVO>();
		ComRptDsgnXptInfoVO rdVO = null;
		List<ComRptDsgnXptInfoVO> rdVOs = null;
		Map<String, String> arguments = null;

		Date now = new Date();
		SimpleDateFormat sndFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		//"PickUp Notice(BL#: "+bkg_no+")";

		try {

			/*
			 *  BL 기준으로 정렬 - BL 기준으로 메일 한건만 보내기 위해
			 */
			List<Object> sortLists = sortArray(pkupNtcSendLists, "blNo", "bkgCustTpCd");



			/*
			 * Pickup Notice 등록 -> Pickup Notice Detail 등록 -> 이메일 전송 -> Send History 반환
			 */
			for (int i=0; i<sortLists.size(); i++) {

				// BL 별 Pickup 목록 가져오기
				sendInfo = (List<PkupNtcSendListVO>) sortLists.get(i);

				// BL 별 Fax/Email 저장용 변수
				bkgPkupNtcDtlGroup = new ArrayList<List<BkgPkupNtcDtlVO>>();


				// start - BL 별 정보 시작
				for (int bb=0; bb<sendInfo.size(); bb++) {

					vo = sendInfo.get(bb);

					/*
					 *  1. Booking Pickup Notice 생성
					 */
					bkgPkupNtc = new BkgPkupNtcVO();

					bkgPkupNtc.setBkgNo(vo.getBkgNo());
					bkgPkupNtc.setNtcSeq(dbDao.searchPkupNtcNextSeq(vo.getBkgNo()));
					bkgPkupNtc.setPkupNtcTpCd("MA");
					bkgPkupNtc.setPkupNtcFomCd(vo.getPkupNtcFomCd());
					bkgPkupNtc.setCustCntCd(vo.getCustCntCd());
					bkgPkupNtc.setCustSeq(vo.getCustSeq());
					bkgPkupNtc.setCustNm(vo.getCustNm());
					bkgPkupNtc.setPkupNtcEvntDt(sndFormat.format(now));
					bkgPkupNtc.setExpSndDt(sndFormat.format(now));
					bkgPkupNtc.setCntrNo(vo.getCntrNo());
					bkgPkupNtc.setRailLodDt(vo.getRailLodDt());
					bkgPkupNtc.setNtfcDt(vo.getPkupAvalDt()); // avalDt 와 동일하게 입력!!
					bkgPkupNtc.setFrtCltFlg(vo.getFrtCltFlg());
					bkgPkupNtc.setOblCltFlg(vo.getOblCltFlg());
					bkgPkupNtc.setCstmsClrFlg(vo.getCstmsClrFlg());
					bkgPkupNtc.setEdi322MvmtCd(vo.getEdi322MvmtCd());
					bkgPkupNtc.setDorTrkrWoFlg(vo.getDorTrkrWoFlg());
					bkgPkupNtc.setPkupNtcSndStsCd("Y"); // 전송처리
					bkgPkupNtc.setIbdTrspHubCd(vo.getIbdTrspHubCd());
					bkgPkupNtc.setDiffRmk(vo.getDiffRmk());
					bkgPkupNtc.setCreUsrId(account.getUsr_id());
					bkgPkupNtc.setUpdUsrId(account.getUsr_id());
					bkgPkupNtc.setMnlCngFlg("Y");
					bkgPkupNtc.setBkgCustTpCd(vo.getBkgCustTpCd());
					bkgPkupNtc.setTrspSoOfcCtyCd(vo.getTrspSoOfcCtyCd());
					bkgPkupNtc.setTrspSoSeq(vo.getTrspSoSeq());
					bkgPkupNtc.setEclzOblCpyFlg(vo.getEclzOblCpyFlg());
					bkgPkupNtc.setMnlFlg(vo.getMnlFlg());


					// Pickup Notice 등록
					dbDao.addPkupNtc(bkgPkupNtc);


					/*
					 * 2. Booking Pickup Notice Detail 생성
					 */
					// Start - Detail
					bkgPkupNtcDtls = new ArrayList<BkgPkupNtcDtlVO>();

					for (int k=0; k<5; k++) {

						if (k == 0) {
							if (!"1".equals(vo.getC1NtcEmlChk())) continue;
						} else if (k == 1) {
							if (!"1".equals(vo.getC2NtcEmlChk())) continue;
						} else if (k == 2) {
							if (!"1".equals(vo.getB1NtcEmlChk())) continue;
						} else if (k == 3) {
							if (!"1".equals(vo.getB2NtcEmlChk())) continue;
						} else if (k == 4) {
							if (!"1".equals(vo.getAnNtcEmlChk())) continue;
						}

						bkgPkupNtcDtl = new BkgPkupNtcDtlVO();

						bkgPkupNtcDtl.setBkgNo(bkgPkupNtc.getBkgNo());
						bkgPkupNtcDtl.setNtcSeq(bkgPkupNtc.getNtcSeq());

						if (k == 0) {
							bkgPkupNtcDtl.setCustCntcTpCd("C1");
							bkgPkupNtcDtl.setNtcEml(vo.getC1NtcEml());
						} else if (k == 1) {
							bkgPkupNtcDtl.setCustCntcTpCd("C2");
							bkgPkupNtcDtl.setNtcEml(vo.getC2NtcEml());
						} else if (k == 2) {
							bkgPkupNtcDtl.setCustCntcTpCd("B1");
							bkgPkupNtcDtl.setNtcEml(vo.getB1NtcEml());
						} else if (k == 3) {
							bkgPkupNtcDtl.setCustCntcTpCd("B2");
							bkgPkupNtcDtl.setNtcEml(vo.getB2NtcEml());
						} else if (k == 4) {
							bkgPkupNtcDtl.setCustCntcTpCd("AN");
							bkgPkupNtcDtl.setNtcEml(vo.getAnNtcEml());
						}

						bkgPkupNtcDtl.setEmlTpCd("M");
						bkgPkupNtcDtl.setEmlSndUsrId(account.getUsr_id());
						bkgPkupNtcDtl.setCreUsrId(account.getUsr_id());
						bkgPkupNtcDtl.setUpdUsrId(account.getUsr_id());
						bkgPkupNtcDtl.setShowPuFlg(vo.getShowPuFlg());

						bkgPkupNtcDtls.add(bkgPkupNtcDtl);


						String titNm = "PickUp Notice(BL#: "+bkgPkupNtc.getBkgNo()+")";
						/*
						 * 3. Email 전송 대상 생성
						 */
						// BL별 한번만 전송. 이외는 SendID 공유
						if (bb == 0) {

							rdVOs = new ArrayList<ComRptDsgnXptInfoVO>();
							mailInfo = new RDMailSendVO();

							// TPJT_INBOUND
							mailInfo.setSndrNm("shipment.info@notifications.nykline.com"); // account.getUsr_nm()
							mailInfo.setSndrEml("shipment.info@notifications.nykline.com");
							mailInfo.setRcvrEml(bkgPkupNtcDtl.getNtcEml());
							mailInfo.setBccRcvrEml(new com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil().searchBccEmailAddrRSQL("PN"));    // 숨은참조

							mailInfo.setEmlTitNm(titNm);
							//CA Halifax에서 나가는 Pick Up Notice는 Rail이 없으므로 Rail 뺀 Email Form
							if("CAHAL01".equals(vo.getPkupYdCd()) && vo.getPkupYdCd() != null && !"".equals(vo.getPkupYdCd())){
								mailInfo.setTemplate("ESM_BKG_1059_02T.html");
							} else {
								mailInfo.setTemplate("ESM_BKG_1059_01T.html");
							}
							arguments = new HashMap<String, String>();
							mailInfo.setArguments(arguments);



							// RD Setting
							rdVO = new ComRptDsgnXptInfoVO();
							rdVO.setCreUsrId(account.getUsr_id());
							rdVO.setUpdUsrId(account.getUsr_id());

							if ((vo.getPodCd() != null  && vo.getDelCd() != null && !"".equals(vo.getPodCd()) && !"".equals(vo.getDelCd())
									&& "CA".equals(vo.getPodCd().substring(0,2)) && "CA".equals(vo.getDelCd().substring(0,2)))
									|| ("CAHAL01".equals(vo.getPkupYdCd()) && vo.getPkupYdCd() != null && !"".equals(vo.getPkupYdCd()))) {
								rdVO.setRdTmpltNm("ESM_BKG_5032.mrd");
							} else {
								rdVO.setRdTmpltNm("ESM_BKG_5018.mrd");
							}
							rdVO.setRdParaCtnt("/rv bkg_no['"+bkgPkupNtcDtl.getBkgNo()+"'] ntc_seq['"+bkgPkupNtcDtl.getNtcSeq()+
									"'] usr_id['" + account.getUsr_id() + "'] ofc_cd['" + account.getOfc_cd() + "']  p_pkup_ntc_fom_cd[''] p_pkup_yd_cd[''] p_rtn_yd_cd[''] p_rmk[''] form_showPuFlg['" + bkgPkupNtcDtl.getShowPuFlg() + "'] ");
							rdVO.setXptFileTpCd(ExportInfo.FTYPE_PDF);
							rdVO.setXptFileNm("PickupNotice_" + vo.getBlNo() + ".pdf");
							rdVOs.add(rdVO);


							if ("Y".equals(vo.getEclzOblCpyFlg())) {
								rdVO = new ComRptDsgnXptInfoVO();

								rdVO.setCreUsrId(account.getUsr_id());
								rdVO.setUpdUsrId(account.getUsr_id());
								rdVO.setRdTmpltNm("ESM_BKG_0109_OBL_A4.mrd");
								rdVO.setRdParaCtnt("/rv form_bkgNo[('" + vo.getBkgNo() + "')] " +
														" form_type[2] " +
														" form_dataOnly[N] " +
														" form_manifest[N] " +
														" form_usrId[" + account.getUsr_id() + "] " +
														" form_hiddeData[N] " +
														" form_level[(6)] " +
														" form_remark[] " +
														" form_Cntr[1] " +
														" form_mainOnly[N] " +
														" form_CorrNo[] " +
														" form_his_cntr[BKG_CONTAINER] " +
														" form_his_bkg[BKG_BOOKING] " +
														" form_his_mkd[BKG_BL_MK_DESC] " +
														" form_his_xpt[BKG_XPT_IMP_LIC] " +
														" form_his_bl[BKG_BL_DOC] " +

														//2015.01.27 안진응 추가
														" form_rqst_via_cd[] " +
														" form_his_bl_mkd[BKG_BL_ISS] " +
														" form_path[] " +
														" isEncode[Y] " +
														" form_end_no[] " +
														" form_esig[] form_cpy_esig[] form_knt_flg[] form_count[] " +

													 "/rp [] /riprnmargin");
								rdVO.setXptFileTpCd(ExportInfo.FTYPE_PDF);
								rdVO.setXptFileNm("OBL_" + vo.getBlNo()+ ".pdf");
								rdVOs.add(rdVO);
							}

							mailInfo.setComRptDsgnXptInfoVOs(rdVOs);

							mailInfos.add(mailInfo);	// BL 별 첫번째 데이터에 대해서만 전송
						}
					} // End - Detail



					// Fax/Email 정보 생성
					dbDao.addPkupNtcDtls(bkgPkupNtcDtls);



					// Notice History 기록을 위해 저장해 둠
					bkgPkupNtcs.add(bkgPkupNtc);

					// 향후 이메일 Send ID를 찾기 위해 BL 별 Detail 저장해 둠
					bkgPkupNtcDtlGroup.add(bkgPkupNtcDtls);

				} // end - BL 별 정보 시작



				// 향후 이메일 Send ID를 찾기 위해 전체 Detail 저장해 둠
				bkgPkupNtcDtlList.add(bkgPkupNtcDtlGroup);
			}


			/*
			 * 메일 전송
			 */
//			List<String> sendIds = (new InboundNoticeEAIDAO()).sendEmailGroup(mailInfos);
			List<String> sendIds = new ArrayList<String>();
			String retSndId = "";
			for(int i = 0; i < mailInfos.size(); i++){
				retSndId = (new InboundNoticeEAIDAO()).sendEmail(mailInfos.get(i));
				if (retSndId != null && !"".equals(retSndId)) {
					sendIds.add(retSndId);
				} else {
					sendIds.add("");
				}
			}


			HashMap<String, String> custList = null;
			BkgNtcHisVO bkgNtcHisVO = null;
			List<BkgNtcHisVO> bkgNtcHisVOs = new ArrayList<BkgNtcHisVO>();
			String sendId = null;
			int ntcCnt = 0; // PickUp Notice 인덱스용
			int sndCnt = 0;	// Send ID 인덱스용

			// 전체 Detail 목록 - start
			for (int i=0; i<bkgPkupNtcDtlList.size(); i++) {

				bkgPkupNtcDtlGroup = (List<List<BkgPkupNtcDtlVO>>) bkgPkupNtcDtlList.get(i);

				// BL 별 Detail 목록 - start
				for (int j=0; j<bkgPkupNtcDtlGroup.size(); j++) {

					bkgPkupNtc = bkgPkupNtcs.get(ntcCnt++);
					bkgPkupNtcDtls = (List<BkgPkupNtcDtlVO>) bkgPkupNtcDtlGroup.get(j);

					// 첫번째 BL 인 경우 Send ID를 Cust Type 별로 저장하여 둔다.(첫번째 이후인 경우는 저장해둔 Send ID 를 읽어옴)
					if (j == 0) custList = new HashMap<String, String>();

					for (int k=0; k<bkgPkupNtcDtls.size(); k++) {
						if (j == 0) {
							custList.put(bkgPkupNtcDtls.get(k).getCustCntcTpCd(), sendIds.get(sndCnt++));
						}

						sendId = custList.get(bkgPkupNtcDtls.get(k).getCustCntcTpCd());

						bkgPkupNtcDtls.get(k).setEmlSndUsrId(account.getUsr_id());
						bkgPkupNtcDtls.get(k).setEmlNtcSndId(sendId);
					}


					/* SendId 기록 */
					dbDao.modifySendIdByEmail(bkgPkupNtcDtls);


					/*
					 * Notice History 기록
					 */
					for (int d=0; d<bkgPkupNtcDtls.size(); d++) {

						bkgPkupNtcDtl = bkgPkupNtcDtls.get(d);

						/* Notice History Setting */
						bkgNtcHisVO = new BkgNtcHisVO();

						bkgNtcHisVO.setNtcViaCd("M"); //F:Fax,M:Email
						bkgNtcHisVO.setSndId(bkgPkupNtcDtl.getEmlNtcSndId());
						bkgNtcHisVO.setSndOfcCd(account.getOfc_cd());
						bkgNtcHisVO.setSndUsrId(account.getUsr_id());
						bkgNtcHisVO.setCreUsrId(account.getUsr_id());
						bkgNtcHisVO.setUpdUsrId(account.getUsr_id());
						bkgNtcHisVO.setBkgNo(bkgPkupNtcDtl.getBkgNo());
						bkgNtcHisVO.setNtcSeq(bkgPkupNtcDtl.getNtcSeq());
						bkgNtcHisVO.setCustCntcTpCd(bkgPkupNtcDtl.getCustCntcTpCd());

						bkgNtcHisVOs.add(dbDao.searchPkupNtcHistory(bkgNtcHisVO));

					}
				}

			}

			return bkgNtcHisVOs;

		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}



	/**
	 * 발송 예정인 Pick-up Notice Email/Fax 자동 전송을 중지한다.
	 *
	 * @param PkupNtcSendListVO[] pkupNtcSendLists
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void stopPkupNtcSend(PkupNtcSendListVO[] pkupNtcSendLists, SignOnUserAccount account) throws EventException {

		List<BkgPkupNtcVO> list = new ArrayList<BkgPkupNtcVO>();;
		BkgPkupNtcVO bkgPkupNtcVO = null;

		try {

			for (int i=0; i<pkupNtcSendLists.length; i++) {

				/* 1. Booking Pickup Notice */
				bkgPkupNtcVO = new BkgPkupNtcVO();

				bkgPkupNtcVO.setBkgNo(pkupNtcSendLists[i].getBkgNo());
				bkgPkupNtcVO.setNtcSeq(pkupNtcSendLists[i].getNtcSeq());
				bkgPkupNtcVO.setAutoSndStopUsrId(account.getUsr_id());
				bkgPkupNtcVO.setUpdUsrId(account.getUsr_id());


				list.add(bkgPkupNtcVO);
			}

			dbDao.stopPkupNtcSend(list);

		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}


	/**
	 * 발송 예정인 Pick-up Notice Email/Fax 자동 전송을 중지를 해지한다.
	 *
	 * @param PkupNtcSendListVO[] pkupNtcSendLists
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void resumePkupNtcSend(PkupNtcSendListVO[] pkupNtcSendLists, SignOnUserAccount account) throws EventException {

		List<BkgPkupNtcVO> list = new ArrayList<BkgPkupNtcVO>();;
		BkgPkupNtcVO bkgPkupNtcVO = null;

		try {

			for (int i=0; i<pkupNtcSendLists.length; i++) {

				/* 1. Booking Pickup Notice */
				bkgPkupNtcVO = new BkgPkupNtcVO();

				bkgPkupNtcVO.setBkgNo(pkupNtcSendLists[i].getBkgNo());
				bkgPkupNtcVO.setNtcSeq(pkupNtcSendLists[i].getNtcSeq());
				bkgPkupNtcVO.setAutoSndResmUsrId(account.getUsr_id());
				bkgPkupNtcVO.setUpdUsrId(account.getUsr_id());

				list.add(bkgPkupNtcVO);
			}

			dbDao.resumePkupNtcSend(list);

		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}



	/**
	 * Pick-up Notice에 기입될 Port(POD), Rail Destination Location, DEL기준으로 Office별로 Empty Return CY코드를 조회한다.<br>
	 *
	 * @param PkupCntrRtnYdVO pkupCntrRtnYd
	 * @return List<BkgPkupCntrRtnYdVO>
	 * @exception EventException
	 */
	public List<BkgPkupCntrRtnYdVO> searchPkupMtRtnCy(PkupCntrRtnYdVO pkupCntrRtnYd) throws EventException {
		try {
			return dbDao.searchPkupMtRtnCy(pkupCntrRtnYd);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 * Return YARD코드및 Location에 대한 등록 혹은 수정 시 Validation 체크 작업을 수행한다.
	 *
	 * @param String chkTp
	 * @param String locCd
	 * @exception EventException
	 */
	public void checkPkupMtRtnCy(String chkTp ,String locCd) throws EventException {
		try {
			if ("L".equals(chkTp))
			{
				if (dbDao.checkLocCode(locCd) == false)
					throw new EventException(new ErrorHandler("BKG00061", new String[]{locCd}).getMessage());
			} else if ("P".equals(chkTp))
			{
				if (dbDao.checkPortCode(locCd) == false)
					throw new EventException(new ErrorHandler("BKG00059").getMessage());
			} else if ("Y".equals(chkTp))
			{
				if (dbDao.checkYardCode(locCd) == false)
					throw new EventException(new ErrorHandler("BKG04013", new String[]{locCd}).getMessage());
			} else if ("YL".equals(chkTp))
			{
				if (dbDao.checkYardCode(locCd) == false) {
					if (dbDao.checkLocCode(locCd) == false)
						throw new EventException(new ErrorHandler("BKG00061", new String[]{locCd}).getMessage());
				}
			}

		} catch(EventException ex) {
			throw ex;
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 * Pick-up Notice에 기입될 Port(POD), Rail Destination Location, DEL기준으로 Office별로 Empty Return CY코드를 등록, 수정,삭제한다.<br>
	 *
	 * @param BkgPkupCntrRtnYdVO[] bkgPkupCntrRtnYds
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void setupPkupMtRtnCy(BkgPkupCntrRtnYdVO[] bkgPkupCntrRtnYds, SignOnUserAccount account) throws EventException{
		try {
			List<BkgPkupCntrRtnYdVO> insertVoList = new ArrayList<BkgPkupCntrRtnYdVO>();
			List<BkgPkupCntrRtnYdVO> updateVoList = new ArrayList<BkgPkupCntrRtnYdVO>();
			List<BkgPkupCntrRtnYdVO> deleteVoList = new ArrayList<BkgPkupCntrRtnYdVO>();

			for ( int i=0; i<bkgPkupCntrRtnYds .length; i++ ) {

				if (bkgPkupCntrRtnYds[i].getIbflag().equals("I")){

					bkgPkupCntrRtnYds[i].setCreUsrId(account.getUsr_id());
					bkgPkupCntrRtnYds[i].setUpdUsrId(account.getUsr_id());

					insertVoList.add(bkgPkupCntrRtnYds[i]);

				} else if (bkgPkupCntrRtnYds[i].getIbflag().equals("U")) {

					bkgPkupCntrRtnYds[i].setUpdUsrId(account.getUsr_id());

					updateVoList.add(bkgPkupCntrRtnYds[i]);

				} else if ( bkgPkupCntrRtnYds[i].getIbflag().equals("D")){

					bkgPkupCntrRtnYds[i].setDeltUsrId(account.getUsr_id());
					bkgPkupCntrRtnYds[i].setUpdUsrId(account.getUsr_id());

					deleteVoList.add(bkgPkupCntrRtnYds[i]);
				}
			}
			if ( deleteVoList.size() > 0 ) {
				dbDao.removePkupMtRtnCy(deleteVoList);
			}

			if ( updateVoList.size() > 0 ) {
				// 중복데이터 존재
				if (dbDao.checkPkupMtRtnCyDup(updateVoList) == true) {
					throw new EventException(new ErrorHandler("BKG04008").getMessage());
				}
				dbDao.modifyPkupMtRtnCy(updateVoList);
			}

			if ( insertVoList.size() > 0 ) {
				// 중복데이터 존재
				if (dbDao.checkPkupMtRtnCyDup(insertVoList) == true) {
					throw new EventException(new ErrorHandler("BKG04008").getMessage());
				}
				dbDao.addPkupMtRtnCy(insertVoList);
			}

		} catch(EventException ex) {
			throw ex;
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 * 기 입력된 P/N Notice Form Setup 정보를 Check한다.<br>
	 *
	 * @param String ofcCd
	 * @param String delCd
	 * @return boolean
	 * @exception EventException
	 */
	public boolean checkPkupNtcFormExist(String ofcCd, String delCd) throws EventException {
		try {
			return dbDao.checkPkupNtcFormExist(ofcCd, delCd);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 * 기 입력된 P/N Notice Form Setup 정보를 Copy한다.<br>
	 *
	 * @param PkupNtcFormCopyVO pkupNtcFormCopy
	 * @exception EventException
	 */
	public void copyPkupNtcForm (PkupNtcFormCopyVO pkupNtcFormCopy) throws EventException {
		try {
			dbDao.copyPkupNtcForm(pkupNtcFormCopy);
			dbDao.copyPkupNtcFormWd(pkupNtcFormCopy);
			dbDao.removePkupNtcHrByCopy(pkupNtcFormCopy);
			dbDao.copyPkupNtcFormHr(pkupNtcFormCopy);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 * UI-BKG-0414 Pick-Up Notice History<br>
	 * Pick-Up Notice History를 조회한다.<br>
	 *  @author
	 *  @param PkupNtcSentHisSchVO pkupNtcSentHisSch
	 *  @return List<PkupNtcSentHisListVO>
	 *  @exception EventException
	 */
	public List<PkupNtcSentHisListVO> searchPkupNtcSentHistory(PkupNtcSentHisSchVO pkupNtcSentHisSch) throws EventException {
		try {
			return dbDao.searchPkupNtcSentHistory(pkupNtcSentHisSch);
		}catch (DAOException de) {
			// BKG00450 : 조회에 실패했습니다.
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), de);
		}catch (Exception ex) {
			// BKG00450 : 조회에 실패했습니다.
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}
	}

	/**
	 * Pick-up No를 수동으로 업로드하기 위해 조회<br>
	 *
	 * @param PkupNoMnlUpldSearchVO pkupNoMnlUpldSearch
	 * @return List<PkupNoMnlUpldVO>
	 * @exception EventException
	 */
	public List<PkupNoMnlUpldVO> searchPkupNoMnlUpldList(PkupNoMnlUpldSearchVO pkupNoMnlUpldSearch) throws EventException {
		try {
			return dbDao.searchPkupNoMnlUpldList(pkupNoMnlUpldSearch);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 * 수동으로 입력된 Pick-up No및 부가 정보 저장<br>
	 *
	 * @param PkupNoMnlUpldVO[] pkupNoMnlUpldVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void managePkupNoMnlUpldList (PkupNoMnlUpldVO[] pkupNoMnlUpldVOs, SignOnUserAccount account) throws EventException {

		PkupNoMnlUpldVO  vo = null;
		BkgPkupNtcPkupNoVO noVo = null;
		//BkgPkupNtcPkupNoHisVO hisVo = null;

		try {

			for (int i=0; i<pkupNoMnlUpldVOs.length; i++) {
				vo = pkupNoMnlUpldVOs[i];

				// Yard 코드 유효성 체크
				if (!"".equals(vo.getPkupYdCd())) {
					if (dbDao.checkYardCode(vo.getPkupYdCd()) == false)
						throw new EventException(new ErrorHandler("BKG01078", new String[]{vo.getPkupYdCd()}).getMessage());
				}

				// Yard 코드 유효성 체크
				if (!"".equals(vo.getRtnYdCd())) {
					if (dbDao.checkYardCode(vo.getRtnYdCd()) == false)
						throw new EventException(new ErrorHandler("BKG01078", new String[]{vo.getRtnYdCd()}).getMessage());
				}

				// Pickup Number
				noVo = new BkgPkupNtcPkupNoVO();

				noVo.setBkgNo(vo.getBkgNo());
				noVo.setCntrNo(vo.getCntrNo());
				// 신규인 경우, DEL 의 EQ Office 코드로 저장
				noVo.setOfcCd(vo.getOfcCd());
				noVo.setBlNo(vo.getBlNo());
				noVo.setVslCd(vo.getVslCd());
				noVo.setSkdVoyNo(vo.getSkdVoyNo());
				noVo.setSkdDirCd(vo.getSkdDirCd());
				noVo.setPodCd(vo.getPodCd());
				noVo.setDelCd(vo.getDelCd());
				noVo.setDeTermCd(vo.getDeTermCd());
				noVo.setIbdTrspHubCd(vo.getIbdTrspHubCd());
				noVo.setPkupYdCd(vo.getPkupYdCd());
				noVo.setPkupNo(vo.getPkupNo());
				noVo.setPkupAvalDt(vo.getPkupAvalDt());
				noVo.setLstFreeDt(vo.getLstFreeDt());
				noVo.setRtnYdCd(vo.getRtnYdCd());
				noVo.setPkupNtcSndKnt(vo.getPkupNtcSndKnt());
				noVo.setPkupCreDt("");
				noVo.setPkupCreUsrId(account.getUsr_id());
				noVo.setPkupUpdDt("");
				noVo.setPkupUpdUsrId(account.getUsr_id());
				noVo.setDeltFlg(vo.getDeltFlg());
				noVo.setCreUsrId(account.getUsr_id());
				noVo.setCreDt("");
				noVo.setUpdUsrId(account.getUsr_id());
				noVo.setUpdDt("");
				noVo.setRailArrDt(vo.getRailArrDt());
				noVo.setRailDepDt(vo.getRailDepDt());
				noVo.setPkupMnlUpldFlg("N");


				// History 기록 - 변경전 데이터 등록
				dbDao.addPkupNtcPkupNoHis(noVo.getBkgNo(), noVo.getCntrNo(), noVo.getOfcCd());

				// Pickup No. 수정 또는 등록
				if (dbDao.modifyPkupNtcPkupNo(noVo) == 0) {
					dbDao.addPkupNtcPkupNo(noVo);
				}

				// PickUp Notice 관련 데이터 변경
				dbDao.modifyPkupNtcByPkupNtcNo(noVo);
			}

		} catch(EventException ex) {
			throw ex;
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}


	/**
	 * Pick-up No를 생성/정정/삭제 이력 조회<br>
	 *
	 * @param String bkgNo
	 * @param String cntrNo
	 * @param String ofcCd
	 * @return List<BkgPkupNtcPkupNoHisVO>
	 * @exception EventException
	 */
	public List<BkgPkupNtcPkupNoHisVO> searchPkupNoHisList(String bkgNo, String cntrNo, String ofcCd) throws EventException {
		try {
			return dbDao.searchPkupNoHisList(bkgNo, cntrNo, ofcCd);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}

	}


	/**
	 * 정수인지 아닌지 판단<br>
	 *
	 * @param String str
	 * @return boolean
	 */
	private boolean isStringInt(String str) {
		try {
			Integer.parseInt(str);
			return true;
		} catch (NumberFormatException e) {
			log.error("err : " + e.toString(), e);
			return false;
		}
	}


	/**
	 * <br>
	 *
	 * @param List<BkgComboVO> railList
	 * @param PkupNoRptEmlCtntVO[] pkupNoRptEmlCtntVOs
	 * @return List<PkupNoRptVO>
	 * @exception EventException
	 */
	private List<PkupNoRptVO> parseBnEmlRpt(List<BkgComboVO> railList, PkupNoRptEmlCtntVO[] pkupNoRptEmlCtntVOs) throws EventException {

		List<PkupNoRptVO> list = new ArrayList<PkupNoRptVO>();
		PkupNoRptVO vo = null;
		String comp = "N";
		String str = "";
		String orgStr = "";
		String tmpStr = "";
		String colVal = "";
		int strLen;
		int iStart, iEnd;

		String [] arrData = null;
		int arrLen = -1;
		String ydCd   = "";

		SimpleDateFormat dateForm = new SimpleDateFormat("yyyy-MM-dd");
		String curDate = "";
		Calendar cal = Calendar.getInstance();
		int curMM = cal.get(cal.MONTH) + 1;
		int curYYYY = cal.get(cal.YEAR);
		int year;
		int month;
		int day;


		try {

			for (int i=0; i<pkupNoRptEmlCtntVOs.length; i++) {

				orgStr = pkupNoRptEmlCtntVOs[i].getCol1();
				str = orgStr;


				/**----------------------------------------------
				 *  데이터 분석하기
				 *-----------------------------------------------*/
				if ( "W".equals(comp) && str.length() > 5) {

					str = str.trim();
					strLen = str.length();


					/**----------------------------------------------
					 *  Free Date  -- Start
					 *-----------------------------------------------*/
					iStart = strLen - 22;
					iEnd   = iStart + 9;

					if (iStart < 0 || strLen < iStart || strLen < iEnd) continue;

					tmpStr = str.substring(0, iStart);
					colVal = (str.substring(iStart, iEnd)).trim();
					if ( colVal.length() > 0) {
						tmpStr = tmpStr + colVal.replace(" ", "_");
					} else {
						tmpStr = tmpStr + "NO_FREE";
					}
					str = tmpStr + str.substring(iEnd);
					/**----------------------------------------------
					 *  Free Date  -- End
					 *-----------------------------------------------*/


					/**----------------------------------------------
					 *  Vessel  -- Start
					 *-----------------------------------------------*/
					iStart = strLen - 51;
					iEnd   = iStart + 28;

					if (iStart < 0 || strLen < iStart || strLen < iEnd) continue;

					tmpStr = str.substring(0, iStart);
					colVal = (str.substring(iStart, iEnd)).trim();
					if ( colVal.length() > 0) {
						tmpStr = tmpStr + colVal.replace(" ", "_");
					} else {
						tmpStr = tmpStr + "NO_VESS";
					}
					str = tmpStr + str.substring(iEnd);
					/**----------------------------------------------
					 *  Vessel  -- End
					 *-----------------------------------------------*/


					/**----------------------------------------------
					 *  Chassis -- Start
					 *-----------------------------------------------*/
					iStart = str.indexOf("-") + 25;
					iEnd   = iStart + 10;

					if (iStart < 0 || strLen < iStart || strLen < iEnd) continue;

					tmpStr = str.substring(0, iStart);
					colVal = (str.substring(iStart, iEnd)).trim();
					if (colVal.length() < 1) {
						tmpStr = tmpStr + "NO_CHSS";
						str = tmpStr + str.substring(iEnd);
					}
					/**----------------------------------------------
					 *  Chassis -- End
					 *-----------------------------------------------*/


					str = str.trim().replace(" ", "@");



					/**----------------------------------------------
					 *  VO 생성하기
					 *-----------------------------------------------*/
					arrData = StringUtils.tokenizeToStringArray(str, "@", false, true);
					arrLen  = arrData.length;

					vo = new PkupNoRptVO();

					// Container No.
					if (arrLen > 5) {
						vo.setCntrNo(arrData[5]);
					} else {
						vo.setCntrNo("");
					}

					// BL No.
					if (arrLen > 12) {
						vo.setBlNo(arrData[12]);
					} else {
						vo.setBlNo("");
					}

					// Pickup No.
					if (arrLen > 9) {
						vo.setPkupNo(arrData[9]);
					} else {
						vo.setPkupNo("");
					}

					// Avail Date
					curDate = "";
					if (arrLen > 2 && arrData[2].length() >= 5) {
						tmpStr = arrData[2];
						if (tmpStr.startsWith("NO") == false) {

							if (isStringInt(tmpStr.substring(0, 2)) && isStringInt(tmpStr.substring(3, 5))) {
								// 년도 구하기
								year  = curYYYY;
								month = Integer.parseInt(tmpStr.substring(0, 2));
								day   = Integer.parseInt(tmpStr.substring(3, 5));

								if (curMM - month > 10) year = curYYYY + 1;
								else if (curMM - month < -9) year = curYYYY - 1;

								cal.set(year, month - 1, day, 0, 0, 0);
								curDate = dateForm.format(cal.getTime());
							}
						}
					}

					vo.setPkupAvalDt(curDate);


					// Free Date
					curDate = "";
					if (arrLen > 11 && arrData[11].length() >= 5) {
						tmpStr = arrData[11];
						if (tmpStr.startsWith("NO") == false) {
							if (isStringInt(tmpStr.substring(0, 2)) && isStringInt(tmpStr.substring(3, 5))) {
								// 년도 구하기
								year  = curYYYY;
								month = Integer.parseInt(tmpStr.substring(0, 2));
								day   = Integer.parseInt(tmpStr.substring(3, 5));

								if (curMM - month > 10) year = curYYYY + 1;
								else if (curMM - month < -9) year = curYYYY - 1;

								// Store Day 의 하루 전일 구하기
								cal.set(year, month - 1, day - 1, 0, 0, 0);

								curDate = dateForm.format(cal.getTime());
							}
						}
					}

					vo.setLstFreeDt(curDate);


					// Pickup Yard
					ydCd = "";
					if (arrLen > 1 && arrData[1].length() >= 3) {
						tmpStr = arrData[1];
						if (tmpStr.startsWith("MEM") || tmpStr.startsWith("REM")) {
							tmpStr = tmpStr.substring(0,3);
							for (int k=0; k<railList.size(); k++) {
								if (railList.get(k).getName().startsWith(tmpStr)) {
									ydCd = railList.get(k).getVal();
									break;
								}
							}
						} else {
							for (int k=0; k<railList.size(); k++) {
								if (tmpStr.equals(railList.get(k).getName())) {
									ydCd = railList.get(k).getVal();
									break;
								}
							}
						}
					}

					vo.setPkupYdCd(ydCd);


					// Remark
					vo.setRemark(orgStr);


					/**----------------------------------------------
					 *  List 완성하기
					 *-----------------------------------------------*/
					list.add(vo);

				}

				// Location 이후부터 실제 데이터 시작
				if (str.indexOf("Location") > -1) comp = "W";
			}

			return list;

		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}


	/**
	 * @param List<BkgComboVO> railList
	 * @param PkupNoRptEmlCtntVO[] pkupNoRptEmlCtntVOs
	 * @return List<PkupNoRptVO>
	 * @throws EventException
	 */
	private List<PkupNoRptVO> parseUpEmlRpt(List<BkgComboVO> railList, PkupNoRptEmlCtntVO[] pkupNoRptEmlCtntVOs) throws EventException {
		List<PkupNoRptVO> list = new ArrayList<PkupNoRptVO>();
		PkupNoRptVO vo = null;
		String comp = "N";
		String lineSt = "N";
		String str = "";
		String orgStr = "";
		String oldStr = "";
		String tmpStr = "";
		int strLen = -1;
		int iStart = 0;

		String [] arrData = null;
		int arrLen = -1;
		String ydCd   = "";
		String [] ymd = null;

		SimpleDateFormat dateForm = new SimpleDateFormat("yyyy-MM-dd");
		String curDate = "";
		Calendar cal = Calendar.getInstance();
		int curMM   = cal.get(cal.MONTH) + 1;
		int curYYYY = cal.get(cal.YEAR);
		int year;
		int month;
		int day;

		try {

			for (int i=0; i<pkupNoRptEmlCtntVOs.length; i++) {

				str = pkupNoRptEmlCtntVOs[i].getCol1();

				if ("N".equals(lineSt) && str.startsWith("SEQ")) lineSt = "Y";
				if ("Y".equals(lineSt) && str.length() >= 2 && ("0".equals(str.substring(0, 1)) || "0".equals(str.substring(1, 2)))) comp = "Y";

				if ("Y".equals(comp)) {

					/**----------------------------------------------
					 *  데이터 분석하기
					 *-----------------------------------------------*/

					orgStr = orgStr + str + "\n";

					str = str.trim();
					strLen = str.length();

					if (strLen > 0 && "@".equals(oldStr) == false) {

						if (strLen < 5) continue;

						iStart = str.indexOf("ORG:");
						if (iStart >= 0) {
							str = " ";
						}

						if (iStart < 0) {
							iStart = str.indexOf("LAST EVENT:");
							if (iStart >= 0) {
								// 26칸 이후 20글자
								if (strLen >= (iStart + 26) + 20) {
									str = str.substring(iStart + 26, (iStart + 26) + 20);
									str = str.replace(" ","_");
								}
							}
						}

						if (iStart < 0) {
							iStart = str.indexOf("E START");
							if (iStart >= 0) {
								// 8칸 이후 5(MM/DD) 글자 이상
								if (strLen >= (iStart+8) + 5) {
									str = str.substring(iStart+8);
								}
							}
						}

						tmpStr = tmpStr + "  " + str.trim();

					} else {

						if ( "@".equals(oldStr) && tmpStr.trim().length() > 0) {

							tmpStr = tmpStr.trim();

							tmpStr = tmpStr.replace(": ",":");
							tmpStr = tmpStr.replace(ConstantMgr.getCompanyName().toUpperCase() + " LIMITED", "");
							tmpStr = tmpStr.replace(" ","@");


							/**----------------------------------------------
							 *  VO 생성하기
							 *-----------------------------------------------*/
							arrData = StringUtils.tokenizeToStringArray(tmpStr, "@", false, true);
							arrLen  = arrData.length;

							vo = new PkupNoRptVO();


							// Container No.
							if (arrLen > 2) {
								vo.setCntrNo(arrData[1] + arrData[2]);
							} else {
								vo.setCntrNo("");
							}

							// BL No.
							if (arrLen > 8) {
								vo.setBlNo(arrData[8]);
							} else {
								vo.setBlNo("");
							}


							// Avail Date
							curDate = "";
							if (arrLen > 5 && arrData[5].length() >= 4) {
								tmpStr = arrData[5];

								if (tmpStr.indexOf("@") < 0) {
									if (isStringInt(tmpStr.substring(0, 2)) && isStringInt(tmpStr.substring(2, 4))) {
										// 년도 구하기
										year  = curYYYY;
										month = Integer.parseInt(tmpStr.substring(0, 2));
										day   = Integer.parseInt(tmpStr.substring(2, 4));

										if (curMM - month > 10) year = curYYYY + 1;
										else if (curMM - month < -9) year = curYYYY - 1;

										cal.set(year, month - 1, day, 0, 0, 0);
										curDate = dateForm.format(cal.getTime());
									}
								}
							}

							vo.setPkupAvalDt(curDate);



							// Free Date
							curDate = "";
							if (arrLen > 11) {
								ymd = arrData[11].split("/");
								if (ymd != null && ymd.length == 2) {
									if (isStringInt(ymd[0]) && isStringInt(ymd[1])) {
										if (Integer.parseInt(ymd[0]) != 0 && Integer.parseInt(ymd[1]) != 0) {
											// 년도 구하기
											year  = curYYYY;
											month = Integer.parseInt(ymd[0]);
											day   = Integer.parseInt(ymd[1]);

											if (curMM - month > 10) year = curYYYY + 1;
											else if (curMM - month < -9) year = curYYYY - 1;

											// Store Day 의 하루 전일 구하기
											cal.set(year, month - 1, day - 1, 0, 0, 0);

											curDate = dateForm.format(cal.getTime());
										}
									}
								}
							}

							vo.setLstFreeDt(curDate);



							// Pickup No.
							if (arrLen > 9) {
								if (isStringInt(arrData[9])) {
									vo.setPkupNo(Integer.toString(Integer.parseInt(arrData[9])));
								} else {
									vo.setPkupNo("");
								}
							} else {
								vo.setPkupNo("");
							}


							// Pickup Yard
							ydCd = "";
							if (arrLen > 10 && arrData[10].length() >= 3) {
								tmpStr = arrData[10].substring(0,3);
								for (int k=0; k<railList.size(); k++) {
									if (railList.get(k).getName().startsWith(tmpStr)) {
										ydCd = railList.get(k).getVal();
										break;
									}
								}
							}
							vo.setPkupYdCd(ydCd);


							// Remark
							vo.setRemark(orgStr);

							list.add(vo);


							orgStr = "";
							tmpStr = "";
							comp   = "N";
						}
					}

					oldStr = str.substring(str.length() - 1);
				}
			}

			return list;

		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}


	/**
	 * 날짜 문자열을 받아서 표준 날짜포맷으로 변형한다.
	 * @param String flag
	 * @param String str
	 * @return String
	 */
	private String getDate(String flag, String str) {

		SimpleDateFormat hyphDateForm = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat dashDateForm = new SimpleDateFormat("MM/dd/yy");
		SimpleDateFormat dateForm = new SimpleDateFormat("yyyy-MM-dd");

		String date = "";

		try {

			if ("D".equals(flag)) {
				date = dateForm.format(dashDateForm.parse(str));
			}
			else if ("H".equals(flag)) {
				date = dateForm.format(hyphDateForm.parse(str));
			} else
				date = "";

		} catch (ParseException ex) {
			log.error("err : " + ex.toString(), ex);
			date = "";
		}


		return date;
	}


	/**
	 * <br>
	 *
	 * @param List<BkgComboVO> railList
	 * @param PkupNoRptEmlCtntVO[] pkupNoRptEmlCtntVOs
	 * @return List<PkupNoRptVO>
	 * @exception EventException
	 */
	private List<PkupNoRptVO> parseNsEmlRpt(List<BkgComboVO> railList, PkupNoRptEmlCtntVO[] pkupNoRptEmlCtntVOs) throws EventException {

		List<PkupNoRptVO> list = new ArrayList<PkupNoRptVO>();
		PkupNoRptVO vo = null;
		PkupNoRptEmlCtntVO emlVo = null;
		String comp = "N";
		String str = "";
		String orgStr = "";
		String tmpStr = "";
		String cntrPadding = "000000";
		int iStart;

		String ydCd   = "";

		String curDate = "";
		String ymd = "";
		String [] arrDate = null;

		try {

			for (int i=0; i<pkupNoRptEmlCtntVOs.length; i++) {

				emlVo = pkupNoRptEmlCtntVOs[i];

				str = emlVo.getCol1();

				if (str.startsWith("Unit")) {
					comp = "N";
				}

				iStart = str.indexOf("LTD - ");
				if (iStart >= 0) {
					ydCd = "";
					if (str.length() >= 11) {
						tmpStr = ((str.substring(iStart + 6)).trim()).substring(0, 5);
						for (int k=0; k<railList.size(); k++) {
							if (railList.get(k).getName().startsWith(tmpStr)) {
								ydCd = railList.get(k).getVal();
								break;
							}
						}
					}
				}

				/**----------------------------------------------
				 *  데이터 분석하기
				 *-----------------------------------------------*/
				if ( "Y".equals(comp) && str.length() > 5) {

					str = str.trim();


					/**----------------------------------------------
					 *  VO 생성하기
					 *-----------------------------------------------*/
					vo = new PkupNoRptVO();


					// Container No.
					if (emlVo.getCol3().length() > 0 && emlVo.getCol4().length() >0) {
						tmpStr = emlVo.getCol4();
						vo.setCntrNo(emlVo.getCol3() + cntrPadding.subSequence(0, 6-tmpStr.length()) + tmpStr);

					} else {
						vo.setCntrNo("");
					}

					// BL No.
					vo.setBlNo(emlVo.getCol11());

					// Pickup No.
					vo.setPkupNo(emlVo.getCol10());

					// Avail Date
					curDate = "";
					tmpStr = emlVo.getCol1();
					if (tmpStr.indexOf("/") > 0) {
						curDate = getDate("D", tmpStr);

					} else if (tmpStr.indexOf("-") > 0) {

						if (tmpStr.length() >= 10) {
							if (tmpStr.length() == 10) {
								curDate = getDate("H", tmpStr);
							} else {

								arrDate = tmpStr.split(" ");
								if (arrDate!= null && arrDate.length > 1) {
									ymd = "";

									for (int t=0; t<arrDate.length; t++) {
										if (arrDate[t].indexOf("-") > 0) ymd = arrDate[t];
									}

									if (ymd.length() > 0)
										curDate = getDate("H", ymd);
								}
							}
						}
					}

					vo.setPkupAvalDt(curDate);


					// Free Date
					curDate = "";
					tmpStr = emlVo.getCol9();
					if (tmpStr.indexOf("/") > 0) {
						if (tmpStr.length() >= 8) {
							curDate = getDate("D", tmpStr);
						}
					} else if (tmpStr.indexOf("-") > 0) {
						if (tmpStr.length() >= 10) {
							if (tmpStr.length() == 10) {
								curDate = getDate("H", tmpStr);
							} else {

								arrDate = tmpStr.split(" ");
								if (arrDate != null && arrDate.length > 1) {
									ymd = "";

									for (int t=0; t<arrDate.length; t++) {
										if (arrDate[t].indexOf("-") > 0) ymd = arrDate[t];
									}

									if (ymd.length() > 0)
										curDate = getDate("H", ymd);
								}
							}
						}
					}
					vo.setLstFreeDt(curDate);


					// Pickup Yard
					vo.setPkupYdCd(ydCd);


					// Remark
					orgStr = emlVo.getCol1() + "\n" +
							 emlVo.getCol2() + "\n" +
							 emlVo.getCol3() + "\n" +
							 emlVo.getCol4() + "\n" +
							 emlVo.getCol5() + "\n" +
							 emlVo.getCol6() + "\n" +
							 emlVo.getCol7() + "\n" +
							 emlVo.getCol8() + "\n" +
							 emlVo.getCol9() + "\n" +
							 emlVo.getCol10() + "\n" +
							 emlVo.getCol11() + "\n" +
							 emlVo.getCol12() + "\n" +
							 emlVo.getCol13() + "\n" +
							 emlVo.getCol14() + "\n" +
							 emlVo.getCol15();

					vo.setRemark(orgStr);


					list.add(vo);
				}

				// 실제 데이터 시작
				if (str.startsWith("Date")) comp = "Y";
				else if (str.startsWith("Unit")) comp = "N";
			}

			return list;

		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}



	/**
	 * @param List<BkgComboVO> railList
	 * @param PkupNoRptEmlCtntVO[] pkupNoRptEmlCtntVOs
	 * @return List<PkupNoRptVO>
	 * @throws EventException
	 */
	private List<PkupNoRptVO> parseCnEmlRpt(List<BkgComboVO> railList, PkupNoRptEmlCtntVO[] pkupNoRptEmlCtntVOs) throws EventException {
		List<PkupNoRptVO> list = new ArrayList<PkupNoRptVO>();
		PkupNoRptVO vo = null;
		String comp = "N";
		String lineSt = "N";
		String str = "";
		String orgStr = "";
		String tmpStr = "";
		String avlDt = "";
		String pkupCy = "";
		int strLen = -1;
		int iStart = 0;

		String ydCd   = "";
		String [] ymd = null;

		SimpleDateFormat dateForm = new SimpleDateFormat("yyyy-MM-dd");
		String curDate = "";
		Calendar cal = Calendar.getInstance();
		int year;
		int month;
		int day;
		int sz = 0;
		String cntrNo = "";
		List<Integer> compSize = new ArrayList<Integer>();

		try {

			for (int i=0; i<pkupNoRptEmlCtntVOs.length; i++) {

				tmpStr = pkupNoRptEmlCtntVOs[i].getCol1();

				tmpStr = tmpStr.substring(tmpStr.indexOf("[")+1);
				orgStr = tmpStr.substring(0, tmpStr.lastIndexOf("]"));

				str = orgStr;

				if ("N".equals(lineSt) && str.startsWith("SEQ")) lineSt = "Y";

				if ("Y".equals(lineSt) && "N".equals(comp) && str.startsWith("--- ")) {
					String[] arrTmp = str.trim().split(" ");
					for (int t=0; t<arrTmp.length; t++) {
						compSize.add(arrTmp[t].trim().length());
					}

					continue;
				}

				if ("Y".equals(lineSt) && str.length() >= 3 && isStringInt(str.substring(0, 3).trim())) comp = "Y";


				strLen = str.length();

				if ("Y".equals(comp)) {

					/**----------------------------------------------
					 *  데이터 분석하기
					 *-----------------------------------------------*/
					if (str.endsWith("K")) {

						/**----------------------------------------------
						 *  VO 생성하기
						 *-----------------------------------------------*/
						vo = new PkupNoRptVO();

						for (int j=0; j<compSize.size(); j++) {
							sz = compSize.get(j);

							if (str.length() <= sz) sz = str.length();

							tmpStr = str.substring(0, sz).trim();

							// Container No. & BL No.
							if (j == 1) cntrNo = tmpStr;
							if (j == 2) {
								cntrNo = cntrNo + tmpStr;
								vo.setCntrNo(cntrNo);
								vo.setBlNo(dbDao.searchRecentBlNo(vo.getCntrNo()));
							}

							// Free Date
							if (j == 10) {
								ymd = tmpStr.split("/");

								if (ymd != null && ymd.length == 3) {
									if (isStringInt(ymd[0]) && isStringInt(ymd[1]) && isStringInt(ymd[2])) {
										if (Integer.parseInt(ymd[0]) == 0 || Integer.parseInt(ymd[2]) == 0) {
											vo.setLstFreeDt("");
										} else {
											year  = 2000 + Integer.parseInt(ymd[2]);
											month = Integer.parseInt(ymd[0]);
											day   = Integer.parseInt(ymd[1]);

											cal.set(year, month - 1, day - 1, 0, 0, 0);
											curDate = dateForm.format(cal.getTime());
											vo.setLstFreeDt(curDate);
										}
									} else {
										vo.setLstFreeDt("");
									}
								} else {
									vo.setLstFreeDt("");
								}
							}

							// Pickup No.
							if (j == 11) {
								vo.setPkupNo(tmpStr);
							}

							if (str.length() > sz)
								str = str.substring(sz + 1);
						}


						// Avail Date
						vo.setPkupAvalDt(avlDt);

						// Pickup Yard
						vo.setPkupYdCd(ydCd);

						// Remark
						vo.setRemark(orgStr);


						list.add(vo);

						comp = "N";

					}

				} else {

					if (pkupCy.length() == 0) {
						iStart = str.indexOf("DETINTTER MI ");
						if (iStart >= 0)
						{
							pkupCy = "DETINTTER";
							if (strLen >= (iStart + 13) + 8)
								avlDt = str.substring(iStart + 13, (iStart + 13) + 8);
						}

						if (iStart < 0) {
							iStart = str.indexOf("CHIINTTER IL ");
							if (iStart >= 0)
							{
								pkupCy = "CHIINTTER";
								if (strLen >= (iStart + 13) + 8)
									avlDt = str.substring(iStart + 13, (iStart + 13) + 8);
							}
						}

						if (iStart < 0) {
							iStart = str.indexOf("MEMINTTER TN ");
							if (iStart >= 0)
							{
								pkupCy = "MEMINTTER";
								if (strLen >= (iStart + 13) + 8)
									avlDt = str.substring(iStart + 13, (iStart + 13) + 8);
							}
						}

						if (iStart >= 0) {
							if (avlDt.length() > 0) {
								// Avail Date
								ymd = avlDt.split("/");
								if (ymd != null && ymd.length == 3) {
									if (isStringInt(ymd[0]) && isStringInt(ymd[1]) && isStringInt(ymd[2])) {
										year  = 2000 + Integer.parseInt(ymd[2]);
										month = Integer.parseInt(ymd[0]);
										day   = Integer.parseInt(ymd[1]);

										cal.set(year, month - 1, day, 0, 0, 0);
										curDate = dateForm.format(cal.getTime());

										avlDt = curDate;
									} else {
										avlDt = "";
									}
								} else {
									avlDt = "";
								}
							}

							ydCd = "";
							if (pkupCy != null && pkupCy.length() >= 3) {
								tmpStr = pkupCy.substring(0,3);
								for (int k=0; k<railList.size(); k++) {
									if (tmpStr.equals(railList.get(k).getName().substring(0, 3))) {
										ydCd = railList.get(k).getVal();
										break;
									}
								}
							}
						}
					}
				}
			}

			return list;

		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}



	/**
	 * 철도 회사로 부터 받은 e-mail Report를 분석하여 pick up No upload 관련 정보 추출<br>
	 *
	 * @param PkupNoRptEmlUpldVO	pkupNoRptEmlUpldVO
	 * @return List<PkupNoRptVO>
	 * @exception EventException
	 */
	public List<PkupNoRptVO> searchParsedPkupNoRpt(PkupNoRptEmlUpldVO pkupNoRptEmlUpldVO) throws EventException {

		String emlFrom = pkupNoRptEmlUpldVO.getEmlFrom();
		PkupNoRptEmlCtntVO[] pkupNoRptEmlCtntVOs = pkupNoRptEmlUpldVO.getPkupNoRptEmlCtntVOs();

		try {

			List<BkgComboVO> railList = dbDao.searchRailYdCd(emlFrom);
			if (pkupNoRptEmlCtntVOs != null) {
				if ("BN".equals(emlFrom))
				{
					return parseBnEmlRpt(railList, pkupNoRptEmlCtntVOs);
				}
				else if ("UP".equals(emlFrom))
				{
					return parseUpEmlRpt(railList, pkupNoRptEmlCtntVOs);
				}
				else if ("NS".equals(emlFrom))
				{
					return parseNsEmlRpt(railList, pkupNoRptEmlCtntVOs);
				}
				else if ("CN".equals(emlFrom))
				{
					return parseCnEmlRpt(railList, pkupNoRptEmlCtntVOs);
				} else {
					throw new EventException(new ErrorHandler("BKG04020", new String[] {emlFrom}).getMessage());
				}
			}

			return null;

		} catch (EventException ex) {
			throw ex;
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}


	/**
	 * 철송 회사로 부터 e-mail을 받은 pick-up No upload 결과를 검증(Verify) 한다<br>
	 *
	 * @param PkupNoRptVO[] pkupNoRptVOs
	 * @return PkupNoVerifyVO
	 * @exception EventException
	 */
	public PkupNoVerifyVO searchPkupNoVerifyRpt(PkupNoRptVO[] pkupNoRptVOs) throws EventException {

		PkupNoVerifyVO pkupNtcVerifyVO = new PkupNoVerifyVO();
		List<PkupNoRptVO> list = new ArrayList<PkupNoRptVO>();

		try {

			for (int i=0; i<pkupNoRptVOs.length; i++) {
				if ("1".equals(pkupNoRptVOs[i].getChk())) {
					list.add(dbDao.searchPkupNoVerifyResultList(pkupNoRptVOs[i]));
				} else {
					list.add(pkupNoRptVOs[i]);
				}
			}

			pkupNtcVerifyVO.setPkupNoRptVOs(list);



			List<PkupNoMnlUpldVO> resultList = new ArrayList<PkupNoMnlUpldVO>();
			PkupNoMnlUpldVO resultVO = null;



			PkupNoRptVO blVO = null;
			List<PkupNoRptVO> blList = new ArrayList<PkupNoRptVO>();

			if (list != null) {
				for (int i=0; i<list.size(); i++) {
					blVO = list.get(i);

					// 유효한 데이터에 한하여 수동 업로드할 데이터 대상이 된다.
					if ("1".equals(blVO.getChk()) &&
						"Y".equals(blVO.getCntrNoChkFlg()) &&
						"Y".equals(blVO.getBlNoChkFlg()) &&
						"Y".equals(blVO.getPkupYdCdChkFlg()) &&
						"Y".equals(blVO.getPkupAvalDtChkFlg()) &&
						"Y".equals(blVO.getLstFreeDtChkFlg()))
					{
						blList.add(blVO);
					}
				}

				// 수동 업로드할 데이터 조회
				resultList = dbDao.searchPkupNoMnlUpldList(blList);

				// 업로드할 데이터를 목록 데이터에 셋팅한다.
				int cnt = 0;
				int j = 0;
				for (int i=0; i<resultList.size(); i++) {
					resultVO = resultList.get(i);

					cnt = 0;
					for (; cnt<blList.size();j++) {
						if (j>=blList.size()) j=0;

						blVO = blList.get(j);
						if (resultVO.getBlNo().equals(blVO.getBlNo()) &&
								resultVO.getCntrNo().startsWith(blVO.getCntrNo()))
						{
							resultList.get(i).setChkYn("Y");
							resultList.get(i).setPkupNo(blVO.getPkupNo());
							resultList.get(i).setPkupAvalDt(blVO.getPkupAvalDt());
							resultList.get(i).setLstFreeDt(blVO.getLstFreeDt());
							resultList.get(i).setPkupYdCd(blVO.getPkupYdCd());

							break;
						}

						cnt++;
					}
				}
			}

			pkupNtcVerifyVO.setPkupNoMnlUpldVOs(resultList);



			return pkupNtcVerifyVO;

		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}


	/**
	 * 배치 실행 <br>
	 *
	 * @param String pgmNo
	 * @param String params
	 * @return String
	 * @exception EventException
	 */
	public String executeBatch(String pgmNo, String params) throws EventException {
		ScheduleUtil su = new ScheduleUtil();

		try {

			return su.directExecuteJob(pgmNo, params);

		} catch (IOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (InterruptedException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}

	}


	/**
	 * 배치 실행 상태 가져오기 <br>
	 *
	 * @param String jobId
	 * @param String pgmNo
	 * @return String
	 * @exception EventException
	 */
	public String getBatchStatus(String jobId, String pgmNo) throws EventException {
		ScheduleUtil su = new ScheduleUtil();

		try {

			int jobStatus = su.getJobStatus(jobId, pgmNo);

			return Integer.toString(jobStatus);

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}


	/**
	 * 배치 실행 여부 확인 <br>
	 *
	 * @param String pgmNo
	 * @return boolean
	 * @exception EventException
	 */
	public boolean isRunningBatch(String pgmNo) throws EventException {
		ScheduleUtil su = new ScheduleUtil();

		try {
			return su.isRunning(pgmNo);

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}

	}


	/**
	 * <br>
	 *
	 * @param String bkgNo
	 * @param String cntrNo
	 * @param String ofcCd
	 * @exception EventException
	 */
	public void modifyPkupNoN1stRlseDt (String bkgNo, String cntrNo, String ofcCd) throws EventException {

		try {
			dbDao.modifyPkupNoN1stRlseDt(bkgNo, cntrNo, ofcCd);

		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 * Pickup Notice setting시에 eq office의 country code 가져온다.
	 * @param String ofcCd
	 * @return String eqOfcCntCd
	 * @exception EventException
	 */
	public String searchPkupNtcEqOfcCntCd(String ofcCd) throws EventException {
		String eqOfcCntCd = null;
		try {
			eqOfcCntCd = dbDao.searchPkupNtcEqOfcCntCd(ofcCd);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eqOfcCntCd;
	}

}