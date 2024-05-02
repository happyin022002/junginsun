/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CustomsTransmissionBCImpl.java
*@FileTitle : UI_BKG-0017
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.20
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2009.05.20 박상훈
* 1.0 Creation
* 2011.11.16 변종건[CHM-201114372-01] 한국지역 적하목록 사전 제출 관련 SYS보완 요청
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.korea.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.korea.integration.KoreaCustomsReportDBDAO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.korea.vo.KorCntrDgVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.korea.vo.KorDiscEtbVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.korea.vo.KorDiscHeadInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.korea.vo.KorDischCYCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.korea.vo.KorDischCYVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.korea.vo.KorDischLocCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.korea.vo.KorDischPrintCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.korea.vo.KorDischPrintListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.korea.vo.KorEntryTpCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.korea.vo.KorImpPrintCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.korea.vo.KorImpPrintListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.korea.vo.KorImpPrtBlInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.korea.vo.KorImpPrtCntrVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.korea.vo.KorImpPrtCustVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.korea.vo.KorImpPrtLocNmVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.korea.vo.KorImpPrtMsnVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.korea.vo.KorImpPrtVslNmVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.korea.vo.KorMrnCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.korea.vo.KorMrnInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.korea.vo.KorMsnInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.korea.vo.KorOFMCustVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.korea.vo.KorPntBlQtyVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.korea.vo.KorPntCustNmVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.korea.vo.KorPntDchgLocVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.korea.vo.KorRcvHistCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.korea.vo.KorRcvHistVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.korea.vo.KorReportHistContainerVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.korea.vo.KorTransHistVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.korea.vo.KorTransmitHistDtlCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.korea.vo.KorWareHouseCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.vo.DischCYCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.vo.DischCYVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.vo.DischLocCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.vo.DischLocVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.vo.DischPrintCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.vo.DischPrintListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.vo.EntryTpCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.vo.EntryTpVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.vo.ImpPrintCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.vo.ImpPrintListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.vo.MrnCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.vo.MrnVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.vo.RcvHistCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.vo.RcvHistVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.vo.ReportHistCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.vo.ReportHistDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.vo.TransmitHistDtlCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.vo.TransmitHistDtlVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.vo.WareHouseCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.vo.WareHouseVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.util.object.ObjectCloner;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.syscommon.common.table.BkgCstmsKrDlHisVO;

/**
 * OPUS-CustomsReport Business Logic Basic Command implementation<br>
 * - OPUS-CustomsReport 대한 비지니스 로직을 처리한다.<br>
 *
 * @author charves
 * @see UI_BKG-0215EventResponse,CustomsReportBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class KorCustomsReportBCImpl extends BasicCommandSupport implements KorCustomsReportBC {

	private transient KoreaCustomsReportDBDAO dbDao = null;

	public KorCustomsReportBCImpl() {
		dbDao = new KoreaCustomsReportDBDAO();
	}

	/**
	 * 한국세관에 다운로드된 내역을 조회
	 * @param BkgCstmsKrDlHisVO bkgCstmsKrDlHisVO
	 * @return List<BkgCstmsKrDlHisVO>
	 * @exception EventException
	 */
	public List<BkgCstmsKrDlHisVO> searchDownLoadHist (BkgCstmsKrDlHisVO bkgCstmsKrDlHisVO)	throws EventException {
		List <BkgCstmsKrDlHisVO> list = null;
		try {
			// 날짜에서 - 문자 제거
			String datefrom = bkgCstmsKrDlHisVO.getDateFrom().replaceAll("-", "");
			String dateto   = bkgCstmsKrDlHisVO.getDateTo().replaceAll("-", "");
			bkgCstmsKrDlHisVO.setDateFrom	(datefrom	);
			bkgCstmsKrDlHisVO.setDateTo		(dateto		);

			// 조회
			list = dbDao.searchDownLoadHistList(bkgCstmsKrDlHisVO);

		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), de);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
		return list;
	}

	/**
	 * Discharging CY Code List 조회
	 * @param DischLocCondVO dischLocCondVO
	 * @return DischLocVO[]
	 * @exception EventException
	 */
	public DischLocVO[] searchDischCYCodeList(DischLocCondVO dischLocCondVO) throws EventException {
		DischLocVO[] dischLocVOs = null;
		// 파라메터 객체 변환
		KorDischLocCondVO korDischLocCondVO = (KorDischLocCondVO)dischLocCondVO;

		try {
			// 조회 처리
			dischLocVOs = dbDao.searchDiscCYCodeList(korDischLocCondVO);
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), de);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}

		return dischLocVOs;
	}

	/**
	 * Discharging CY Code List 처리 (추가/수정/삭제)
	 * @param DischLocCondVO[] dischLocCondVOs
	 * @exception EventException
	 */
	public void manageDiscCYCodeList(DischLocCondVO[] dischLocCondVOs) throws EventException {
		// 파라메터 객체 변환
		KorDischLocCondVO[] korDischLocCondVOs = (KorDischLocCondVO[])dischLocCondVOs;
		List<KorDischLocCondVO> removeVOs 	= new ArrayList<KorDischLocCondVO>();
		List<KorDischLocCondVO> addVOs 		= new ArrayList<KorDischLocCondVO>();
		List<KorDischLocCondVO> modifyVOs 	= new ArrayList<KorDischLocCondVO>();
		try {
			// 작업 구분 분할
			for (int i=0; i < korDischLocCondVOs.length; i++) {

				if (korDischLocCondVOs[i].getIbflag().equals("D")) {
					removeVOs.add(korDischLocCondVOs[i]);
				} else  if (korDischLocCondVOs[i].getIbflag().equals("I")) {
					addVOs.add(korDischLocCondVOs[i]);
				} else  if (korDischLocCondVOs[i].getIbflag().equals("U")) {
					modifyVOs.add(korDischLocCondVOs[i]);
				}
			}

			// REMOVE
			dbDao.removeDiscCYCodeList(removeVOs.toArray(new KorDischLocCondVO[0]));
			// INSERT
			dbDao.addDiscCYCodeList(addVOs.toArray(new KorDischLocCondVO[0]));
			// MODIFY
			dbDao.modifyDiscCYCodeList(modifyVOs.toArray(new KorDischLocCondVO[0]));

		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), de);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		}

	}

	/**
	 * 세관 Transmit History조회
	 * @param ReportHistCondVO reportHistContainer
	 * @return ReportHistDetailVO
	 * @exception EventException
	 */
	public ReportHistDetailVO searchTransmitHist(ReportHistCondVO reportHistContainer) throws EventException {
		KorReportHistContainerVO korReportHistContainerVO = new KorReportHistContainerVO();
		List<KorTransHistVO> list = new ArrayList<KorTransHistVO>();
		KorTransHistVO korTransHistVO = new KorTransHistVO();
		KorTransHistVO fromClient = (KorTransHistVO) reportHistContainer;
		String smtAmdNo = "";
		String amdRcvCd = "";

		try {
			String option = fromClient.getPSearchOption();
			if ("VVD".equals(option)) {
				list = dbDao.searchTransHistByVVDList(fromClient);
			} else if ("BL".equals(option)) {
				list = dbDao.searchTransHistByBlList(fromClient);
			} else if ("SUB".equals(option)) {
				list = dbDao.searchTransHistBySubmitNoList(fromClient);
			} else if ("SEND_DATE".equals(option)) {
				list = dbDao.searchTransHistBySndDtList(fromClient);
			} else if ("ETA".equals(option)) {
				list = dbDao.searchTransHistByETAList(fromClient);
			} else if ("ETD".equals(option)) {
				list = dbDao.searchTransHistByETDList(fromClient);
			}

			// MSG Code 가 5CG, 5LI, 6SK, 6SJ 인 경우 TYPE 조회 셋팅
			if (list.size() > 0 && ("5CG".equals(fromClient.getInMsgType()) || "5LI".equals(fromClient.getInMsgType()) || "6SK".equals(fromClient.getInMsgType()) || "6SJ".equals(fromClient.getInMsgType())) ) {
				for (int i=0; i < list.size(); i++) {
					korTransHistVO = list.get(i);
					smtAmdNo = korTransHistVO.getASubmitNo().trim();
					amdRcvCd = dbDao.searchAmdRcvCd(smtAmdNo);
					korTransHistVO.setAKsType(amdRcvCd);
					list.set(i, korTransHistVO);
				}
			}
			korReportHistContainerVO.setKorTransHistVOs(list);

		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), de);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
		return korReportHistContainerVO;
	}

	/**
	 * 한국/인도 세관에 적하 목록 전송할 때 B/L의 통관 Type Code를 Inquiry
	 *
	 * @param EntryTpCondVO entryTpCondVO
	 * @return EntryTpVO[]
	 * @exception EventException
	 */
	public EntryTpVO[] searchCstmEntryTpList(EntryTpCondVO entryTpCondVO) throws EventException {
		EntryTpVO[] entryTpVOs = null;
		// 파라메터 객체 변환
		KorEntryTpCondVO korEntryTpCondVO = (KorEntryTpCondVO)entryTpCondVO;

		try {
			// 조회 처리
			entryTpVOs = dbDao.searchCstmEntryTpList(korEntryTpCondVO);
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), de);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}

		return entryTpVOs;
	}

	/**
	 * 한국/인도 세관에 적하 목록 전송할 때 B/L의 통관 Type Code 추가/수정/삭제
	 * @param EntryTpCondVO[] entryTpCondVOs
	 * @exception EventException
	 */
	public void manageCstmEntryTpList(EntryTpCondVO[] entryTpCondVOs) throws EventException {
		// 파라메터 객체 변환
		KorEntryTpCondVO[] korEntryTpCondVOs = (KorEntryTpCondVO[])entryTpCondVOs;

		try {
			// 처리 넘김
			dbDao.removeCstmEntryTpList	(korEntryTpCondVOs);
			dbDao.addCstmEntryTpList	(korEntryTpCondVOs);
			dbDao.modifyCstmEntryTpList	(korEntryTpCondVOs);
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), de);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * 하선신고서(Discharging Cargo Declaration) 정보를 조회
	 * @param DischCYCondVO dischCYCondVO
	 * @return DischCYVO[]
	 * @exception EventException
	 */
	public DischCYVO[] searchDischCYList(DischCYCondVO dischCYCondVO) throws EventException {
		// 파라메터 객체 변환
		KorDischCYCondVO korDischCYCondVO = (KorDischCYCondVO)dischCYCondVO;
		KorDischCYVO[] korDischCYVOs = null;
		// 임시객체 (LOOP 용)
		KorDischCYVO korDischCYVO = null;
		// CUST NM, WH NAME, DG_CLASS 용 객체
		KorDischCYVO custNmObj, whNmObj;
		KorOFMCustVO korOFMCustVO = null;
		String dgClassObj = null;
		// MRN 정보 객체
		KorMrnInfoVO inKorMrnInfoVO = new KorMrnInfoVO();
		KorMrnInfoVO outKorMrnInfoVO = null;
		// 조회 결과 상단 추가정보
		String vvd,portCd,mrnNo,mrnChkNo;

		try {
			// MRN INFO 조회 처리
			if (korDischCYCondVO.getSearchType().equals("vvd")) {
				// VVD로 조회
				// 파라메터 셋팅
				inKorMrnInfoVO.setVslCd		(korDischCYCondVO.getVslCd()	);
				inKorMrnInfoVO.setSkdVoyNo	(korDischCYCondVO.getSkdVoyNo()	);
				inKorMrnInfoVO.setSkdDirCd	(korDischCYCondVO.getSkdDirCd()	);
				inKorMrnInfoVO.setIoBndCd	(korDischCYCondVO.getIoBndCd()	);
				inKorMrnInfoVO.setPortCd	(korDischCYCondVO.getPortCd()	);
				// 조회
				outKorMrnInfoVO = dbDao.searchMRNInfo(inKorMrnInfoVO);
				// 결과가 없으면 오류 리턴
				if (outKorMrnInfoVO==null) throw new EventException(new ErrorHandler("BKG00889").getMessage());
				// MRN 정보 셋팅
				korDischCYCondVO.setMrnNo	(outKorMrnInfoVO.getMrnNo()	);
				korDischCYCondVO.setMfRefNo	(outKorMrnInfoVO.getMrnNo()	);
				vvd 	= korDischCYCondVO.getVslCd() + korDischCYCondVO.getSkdVoyNo() + korDischCYCondVO.getSkdDirCd();
				portCd 	= korDischCYCondVO.getPortCd();
				mrnNo	= outKorMrnInfoVO.getMrnNo();
				mrnChkNo= outKorMrnInfoVO.getMrnChkNo();
			} else {
				// MRN으로 조회
				// 파라메터 셋팅
				inKorMrnInfoVO.setMrnNo		(korDischCYCondVO.getMrnNo()	);
				inKorMrnInfoVO.setIoBndCd	(korDischCYCondVO.getIoBndCd()	);
				// 조회
				outKorMrnInfoVO = dbDao.searchMRNVVDInfo(inKorMrnInfoVO);
				// 결과가 없으면 오류 리턴
				if (outKorMrnInfoVO==null) throw new EventException(new ErrorHandler("BKG00889").getMessage());
				// VVD 정보 셋팅
				korDischCYCondVO.setVslCd(outKorMrnInfoVO.getVslCd());
				korDischCYCondVO.setSkdVoyNo(outKorMrnInfoVO.getSkdVoyNo());
				korDischCYCondVO.setSkdDirCd(outKorMrnInfoVO.getSkdDirCd());
				korDischCYCondVO.setPortCd(outKorMrnInfoVO.getPortCd());
				korDischCYCondVO.setMfRefNo(korDischCYCondVO.getMrnNo());
				vvd 	= outKorMrnInfoVO.getVslCd() + outKorMrnInfoVO.getSkdVoyNo() + outKorMrnInfoVO.getSkdDirCd();
				portCd 	= outKorMrnInfoVO.getPortCd();
				mrnNo	= outKorMrnInfoVO.getMrnNo();
				mrnChkNo= outKorMrnInfoVO.getMrnChkNo();
			}

			// EVENT에 따른 분리
			if (korDischCYCondVO.getEventNo().equals("0340")) {
				// EVENT 0340

				// DISCHARGE CY LIST 조회
				korDischCYVOs = dbDao.searchDischCYList(korDischCYCondVO);

				if (korDischCYVOs != null) {
					// LOOP 돌며 CUST INFO, Bond WH NAME 추출 처리
					for (int i=0; i < korDischCYVOs.length; i++) {
						korDischCYVO = korDischCYVOs[i];

						// BKG_NO 설정
						korDischCYCondVO.setBkgNo(korDischCYVO.getBkgNo());
						// CSTMS_DCHG_LOC_WH_CD 설정
						korDischCYCondVO.setCstmsDchgLocWhCd(korDischCYVO.getCstmsDchgLocWhCd());

						// CUST INFO 추출
						custNmObj = dbDao.searchCustInfo(korDischCYCondVO);
						// Bonded W/H Name 추출
						whNmObj = dbDao.searchBondWHName(korDischCYCondVO);
						// 추출 값 적용
						if (custNmObj != null) korDischCYVO.setCustCNm(custNmObj.getCustCNm());
						if (custNmObj != null) korDischCYVO.setCustNNm(custNmObj.getCustNNm());
						if (whNmObj != null)   korDischCYVO.setWhName(whNmObj.getWhName());

						korDischCYVO.setMrnNo(mrnNo);
						korDischCYVO.setMrnChkNo(mrnChkNo);
						korDischCYVO.setVvd(vvd);
						korDischCYVO.setPortCd(portCd);

						korDischCYVOs[i] = korDischCYVO;
					}
				}
			} else {
				// EVENT 0341
				// IN-Bound , OUT-Bound 구분철
				if (korDischCYCondVO.getIoBndCd().equals("I")) {

					// IN BOUND

					// Inward Foreign Manifest List를 조회
					korDischCYVOs = dbDao.searchIFMList(korDischCYCondVO);

					if (korDischCYVOs != null) {
						// LOOP 돌며 CUST INFO, Bond WH NAME 추출 처리
						for (int i=0; i < korDischCYVOs.length; i++) {
							korDischCYVO = korDischCYVOs[i];

							// BKG_NO 설정
							korDischCYCondVO.setBkgNo(korDischCYVO.getBkgNo());
							// CSTMS_DCHG_LOC_WH_CD 설정
							korDischCYCondVO.setCstmsDchgLocWhCd(korDischCYVO.getCstmsDchgLocWhCd());

							// CUST INFO 추출
							custNmObj = dbDao.searchCustInfo(korDischCYCondVO);
							// DG Class 추출
							dgClassObj = dbDao.searchDGClass(korDischCYCondVO);
							// Bonded W/H Name 추출
							whNmObj = dbDao.searchBondWHName(korDischCYCondVO);
							// 추출 값 적용
							if (custNmObj != null) korDischCYVO.setCustCNm(custNmObj.getCustCNm());
							if (custNmObj != null) korDischCYVO.setCustNNm(custNmObj.getCustNNm());
							if (whNmObj != null)   korDischCYVO.setWhName(whNmObj.getWhName());
							korDischCYVO.setImdgClssCd(dgClassObj);

							korDischCYVO.setMrnNo(mrnNo);
							korDischCYVO.setMrnChkNo(mrnChkNo);
							korDischCYVO.setVvd(vvd);
							korDischCYVO.setPortCd(portCd);

							korDischCYVOs[i] = korDischCYVO;
						}
					}
				} else {

					// OUT BOUND

					// Outbound Foreign Manifest List 조회
					korDischCYVOs = dbDao.searchOFMList(korDischCYCondVO);

					// LOOP 돌며 CUST INFO, Bond WH NAME 추출 처리
					if (korDischCYVOs != null) {
						for (int i=0; i < korDischCYVOs.length; i++) {
							korDischCYVO = korDischCYVOs[i];

							// BKG_NO 설정
							korDischCYCondVO.setBkgNo(korDischCYVO.getBkgNo());
							// CSTMS_DCHG_LOC_WH_CD 설정
							korDischCYCondVO.setCstmsDchgLocWhCd(korDischCYVO.getCstmsDchgLocWhCd());

							// CUST INFO 추출
							korOFMCustVO = dbDao.searchOFMCustInfo(korDischCYVO.getBkgNo());

							// DG Class 추출
							dgClassObj = dbDao.searchDGClass(korDischCYCondVO);

							// 추출 값 적용
							if (korOFMCustVO != null) korDischCYVO.setCustCNm(korOFMCustVO.getCustCNm());
							if (korOFMCustVO != null) korDischCYVO.setCustNNm(korOFMCustVO.getCustNNm());
							korDischCYVO.setImdgClssCd(dgClassObj);

							korDischCYVO.setMrnNo(mrnNo);
							korDischCYVO.setMrnChkNo(mrnChkNo);
							korDischCYVO.setVvd(vvd);
							korDischCYVO.setPortCd(portCd);

							korDischCYVOs[i] = korDischCYVO;
						}
					}
				}
			}
		} catch (EventException evx) {
			throw evx;
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), de);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}

		return korDischCYVOs;
	}

	/**
	 * Korea에서 입/출항 선박 신고 적하목록 전송 문서의 상세내역 조회
	 * @param TransmitHistDtlCondVO transmitHistDtlCondVO
	 * @return TransmitHistDtlVO[]
	 * @exception EventException
	 */
	public TransmitHistDtlVO[] searchTransmitHistDtl(TransmitHistDtlCondVO transmitHistDtlCondVO) throws EventException {
		TransmitHistDtlVO[] transmitHistDtlVOs = null;

		try {
			transmitHistDtlVOs = dbDao.searchTransmitHistDtl((KorTransmitHistDtlCondVO)transmitHistDtlCondVO);
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), de);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}

		return transmitHistDtlVOs;
	}

	/**
	 * 한국세관, 일본세관, 인도세관 Manifest 신고 등록시 Warehouse (Bonded Area) Detail을 조회
	 * @param WareHouseCondVO warehouseCondVO
	 * @return WareHouseVO[]
	 * @exception EventException
	 */
	public WareHouseVO[] searchWareHouseInfo(WareHouseCondVO warehouseCondVO) throws EventException {
		// 최종 조회 결과 배열
		WareHouseVO[] wareHouseVOs = null;

		try {
			wareHouseVOs = dbDao.searchWareHouseInfo((KorWareHouseCondVO)warehouseCondVO);
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), de);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}

		return wareHouseVOs;
	}

	/**
	 * 한국 세관 신고용 화물 관리 번호 Master Reference Number를 조회
	 * @param MrnCondVO mrnCondVO
	 * @return MrnVO[]
	 * @exception EventException
	 */
	public MrnVO[] searchMRNNoList(MrnCondVO mrnCondVO) throws EventException {
		// 최종 조회 결과 배열
		MrnVO[] mrnVOs = null;

		try {
			mrnVOs = dbDao.searchMRNNoList((KorMrnCondVO)mrnCondVO);
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), de);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}

		return mrnVOs;
	}

	/**
	 * 하선 신고서 RD 인쇄를 위한 데이터 조회
	 * @param DischPrintCondVO[] dischPrintCondVOs
	 * @return DischPrintListVO[]
	 * @exception EventException
	 */
	public DischPrintListVO[] searchDischPrintList(DischPrintCondVO[] dischPrintCondVOs) throws EventException {

		// 처리 결과 객체
		KorDischPrintListVO[] korDischPrintListVOs = null;
		KorDischPrintListVO   korDischPrintListVO = null;
		List<KorDischPrintListVO> list = new ArrayList<KorDischPrintListVO>();

		// BL QTY 조회용 객체
		KorPntBlQtyVO korPntBlQtyVO = null;
		// Discharging Warehouse 조회용 객체
		KorPntDchgLocVO korPntDchgLocVO = null;
		// Customer Name 조회용 객체
		KorPntCustNmVO korPntCustNmVO = null;
		// Container No 조회용 객체
		int c = 0;
		String[] containerNOs = null;
		StringBuffer bfContainerNo = new StringBuffer();
		// Head VVD 조회용 객체
		KorDiscHeadInfoVO korDiscHeadInfoVO = null;
		// Head Vsl Name
		String headVslName = null;
		// Head Etb Date 조회용 객체
		String headEtbDate = null;
		KorDiscEtbVO korDiscEtbVO = null;

		// 파라메터 객체 변환
		KorDischPrintCondVO[] condVOs = (KorDischPrintCondVO[])dischPrintCondVOs;

		try {

			// 화면에서 넘어온 BKG_NO 갯수 만큼 LOOP
			for (int i=0; i < condVOs.length; i++) {

				// 결과 객체 생성
				korDischPrintListVO = new KorDischPrintListVO();

				// BL_QTY 조회
				korPntBlQtyVO = dbDao.searchDiscPntBlQtyInfo(condVOs[i].getBkgNo());
				// DCHG_LOG 조회
				korPntDchgLocVO = dbDao.searchDiscPntDchgLoc(condVOs[i].getBkgNo(), condVOs[i].getMrnNo());
				// Customer Name 조회
				korPntCustNmVO = dbDao.searchDiscPntCustNm(condVOs[i].getBkgNo());
				// Container NO 조회
				containerNOs = dbDao.searchDiscPntCntrList(condVOs[i].getBkgNo());
				bfContainerNo.setLength(0);
				for (c=0; c < containerNOs.length; c++) {
					if (c > 0) bfContainerNo.append("\n");
					bfContainerNo.append(containerNOs[c]);
				}
				// HEAD VVD 조회
				korDiscHeadInfoVO = new KorDiscHeadInfoVO();
				korDiscHeadInfoVO.setMrnNo		(condVOs[i].getMrnNo()		);
				korDiscHeadInfoVO.setVslCd		(condVOs[i].getVslCd()		);
				korDiscHeadInfoVO.setSkdVoyNo	(condVOs[i].getSkdVoyNo()	);
				korDiscHeadInfoVO.setSkdDirCd	(condVOs[i].getSkdDirCd()	);
				korDiscHeadInfoVO = dbDao.searchDiscPntHeadVvd(korDiscHeadInfoVO);
				// Head Vsl Name 조회
				headVslName = dbDao.searchDiscPntHeadVslNm(condVOs[i].getVslCd());
				// Head Etb Date 조회
				korDiscEtbVO = new KorDiscEtbVO();
				korDiscEtbVO.setVslCd		(condVOs[i].getVslCd()		);
				korDiscEtbVO.setSkdVoyNo	(condVOs[i].getSkdVoyNo()	);
				korDiscEtbVO.setSkdDirCd	(condVOs[i].getSkdDirCd()	);
				korDiscEtbVO.setVpsPortCd	(condVOs[i].getPortCd()		);
				headEtbDate = dbDao.searchDiscPntHeadEtbDt(korDiscEtbVO);

				// 조회 결과값 매핑
				ObjectCloner.build(korPntBlQtyVO, 		korDischPrintListVO	);
				ObjectCloner.build(korPntDchgLocVO, 	korDischPrintListVO	);
				ObjectCloner.build(korPntCustNmVO, 		korDischPrintListVO	);
				ObjectCloner.build(korDiscHeadInfoVO, 	korDischPrintListVO	);
				korDischPrintListVO.setCntrNo	(bfContainerNo.toString()	);
				korDischPrintListVO.setVslEngNm	(headVslName				);
				korDischPrintListVO.setVpsEtbDt	(headEtbDate				);

				// 결과 LIST 에 담기
				list.add(korDischPrintListVO);
			}

			korDischPrintListVOs = list.toArray(new KorDischPrintListVO[0]);

		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), de);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}

		return korDischPrintListVOs;
	}

	/**
	 * 적하목록 RD 인쇄를 위한 데이터 조회
	 * @param ImpPrintCondVO[] impPrintCondVOs
	 * @return ImpPrintListVO[]
	 * @exception EventException
	 */
	public ImpPrintListVO[] searchImpCgoManiPrtList(ImpPrintCondVO[] impPrintCondVOs) throws EventException {
		// 최종 리턴용 객체
		List<KorImpPrintListVO> korImpPrintListVOs = new ArrayList<KorImpPrintListVO>();
		KorImpPrintListVO korImpPrintListVO = null;
		// 조회 조건 객체
		KorImpPrintCondVO[] korImpPrintCondVOs = (KorImpPrintCondVO[])impPrintCondVOs;
		KorImpPrintCondVO[] condVOs = new KorImpPrintCondVO[korImpPrintCondVOs.length];
		int cnt = 0;

		// 조회 조건
		String bkgNo = null;
		String mrnNo = null;

		// CUST INFO 조회용
		KorImpPrtCustVO[] korImpPrtCustVOs = null;
		// Container INFO 조회용
		KorImpPrtCntrVO[] korImpPrtCntrVOs = null;
		KorCntrDgVO[] korCntrDgVOs = null;
		StringBuilder containerInfo = null;
		// MSN INFO 조회용
		KorImpPrtMsnVO korImpPrtMsnVO = null;
		KorMsnInfoVO korMsnInfoVO = null;
		// LocNm 조회용
		KorImpPrtLocNmVO korImpPrtLocNmVO = null;
		// VslNM 조회용
		KorImpPrtVslNmVO korImpPrtVslNmVO = null;
		// ETB DT 조회용
		KorDiscEtbVO discEtbVO = new KorDiscEtbVO();
		// BL INFO 조회용
		KorImpPrtBlInfoVO korImpPrtBlInfoVO = null;
		// 특수화물 코드 조회용
		StringBuilder imdgUnNo = null;

		try {

			// TYPE 순서에 따라 담기
			for (int i=0; i < korImpPrintCondVOs.length; i++) {
				if (korImpPrintCondVOs[i].getMrnBlTsCd().equals("T") || korImpPrintCondVOs[i].getMrnBlTsCd().equals("R")) continue;
				condVOs[cnt] = korImpPrintCondVOs[i];
				cnt++;
			}
			for (int i=0; i < korImpPrintCondVOs.length; i++) {
				if (korImpPrintCondVOs[i].getMrnBlTsCd().equals("I") || korImpPrintCondVOs[i].getMrnBlTsCd().equals("E")) continue;
				condVOs[cnt] = korImpPrintCondVOs[i];
				cnt++;
			}

			// BOUND 구분
			if (condVOs[0].getIoBndCd().equals("I")) {

				// IN-BOUND

				// 메인 LOOP
				for (int i=0; i < condVOs.length; i++) {

					korImpPrintListVO = new KorImpPrintListVO();

					bkgNo = condVOs[i].getBkgNo();
					mrnNo = condVOs[i].getMrnNo().substring(0, 10);

					korImpPrintListVO.setMrnBlTsCd	(condVOs[i].getMrnBlTsCd()							);
					korImpPrintListVO.setSkdVoyNo	(condVOs[i].getSkdVoyNo()+condVOs[i].getSkdDirCd()	);
					korImpPrintListVO.setMrnNo		(condVOs[i].getMrnNo()								);

					// CUST INFO 조회
					korImpPrtCustVOs = dbDao.searchImpCgoManiPrtCustInfo(bkgNo);
					if (korImpPrtCustVOs != null) {
						for (int j=0; j < korImpPrtCustVOs.length; j++) {
							if (korImpPrtCustVOs[j].getBkgCustTpCd().equals("C")) {
								korImpPrintListVO.setCCustInfo(korImpPrtCustVOs[j].getCustInfo());
							} else  if (korImpPrtCustVOs[j].getBkgCustTpCd().equals("N")) {
								korImpPrintListVO.setNCustInfo(korImpPrtCustVOs[j].getCustInfo());
							} else  if (korImpPrtCustVOs[j].getBkgCustTpCd().equals("S")) {
								korImpPrintListVO.setSCustInfo(korImpPrtCustVOs[j].getCustInfo());
							}
						}
					}

					// Container INFO / 특수화물코드 조회
					korImpPrtCntrVOs = dbDao.searchImpCgoManiPrtCNTRDgClssInfo(bkgNo);
					containerInfo = new StringBuilder();
					imdgUnNo = new StringBuilder();
					if (korImpPrtCntrVOs != null) {
						for (int j=0; j < korImpPrtCntrVOs.length; j++) {
							if (j > 0 ) containerInfo.append("\n");
							if (j > 0 ) imdgUnNo.append("\n");
							if (j > 0 && korImpPrtCntrVOs[j-1].getCntrInfo().equals(korImpPrtCntrVOs[j].getCntrInfo())) {
								containerInfo.append("\n\n");
							} else {
								containerInfo.append(korImpPrtCntrVOs[j].getCntrInfo());
							}
							imdgUnNo.append(korImpPrtCntrVOs[j].getDgClss()).append("\n");
						}
					}

					// 값이 없으면 무한루프 오류를 막기위해 빈칸 처리
					if (imdgUnNo.toString().replaceAll("\n", "").trim().length() < 1) imdgUnNo.delete(0, imdgUnNo.length());

					korImpPrintListVO.setCntrInfo(containerInfo.toString());
					korImpPrintListVO.setImdgUnNo(imdgUnNo.toString());

					// 품명 조회
					korImpPrintListVO.setCstmsDesc(dbDao.searchImpCgoManiPrtCstmDesc(bkgNo));

					// MSN INFO 조회
					korImpPrtMsnVO = dbDao.searchImpCgoManiPrtMSN(bkgNo, mrnNo);
					korImpPrintListVO.setMsnNo(korImpPrtMsnVO.getMsnNo());
					korImpPrintListVO.setBlTpCd(korImpPrtMsnVO.getBlTpCd());

					// LocNm 조회
					if (condVOs[i].getMrnBlTsCd().equals("I")) {
						korImpPrtLocNmVO = dbDao.searchImpCgoManiPrtLocNm(condVOs[i].getPolCd(), condVOs[i].getPodCd());
					} else {
						korImpPrtLocNmVO = dbDao.searchImpCgoManiPrtLocNm(condVOs[i].getPolCd(), condVOs[i].getFnlPodCd());
					}
					korImpPrintListVO.setLoc1Info(korImpPrtLocNmVO.getLoc1Info());
					korImpPrintListVO.setLoc2Info(korImpPrtLocNmVO.getLoc2Info());

					// VSL NAME 조회
					korImpPrtVslNmVO = dbDao.searchImpCgoManiVslNm(condVOs[i].getVslCd());
					korImpPrintListVO.setCallSgnNo	(korImpPrtVslNmVO.getCallSgnNo()	);
					korImpPrintListVO.setVslEngNm	(korImpPrtVslNmVO.getVslEngNm()		);
					korImpPrintListVO.setCntNm		(korImpPrtVslNmVO.getCntNm()		);

					// ETB DT 조회
					discEtbVO.setVslCd		(condVOs[i].getVslCd()		);
					discEtbVO.setSkdVoyNo	(condVOs[i].getSkdVoyNo()	);
					discEtbVO.setSkdDirCd	(condVOs[i].getSkdDirCd()	);
					discEtbVO.setVpsPortCd	(condVOs[i].getPortCd()		);
					korImpPrintListVO.setVpsEtbDt(dbDao.searchDiscPntHeadEtbDt(discEtbVO));

					// BL INFO 조회
					korImpPrtBlInfoVO = dbDao.searchImpCgoManiBlInfo(bkgNo);
					korImpPrintListVO.setBlNo	(korImpPrtBlInfoVO.getBlNo()	);
					korImpPrintListVO.setTotWgt	(korImpPrtBlInfoVO.getTotWgt()	);
					korImpPrintListVO.setPckQty	(korImpPrtBlInfoVO.getPckQty()	);

					// Bonded WareHouse Name 조회
					korImpPrintListVO.setWhNm(dbDao.searchImpCgoManiBondWhName(bkgNo));

					// LIST에 담기
					korImpPrintListVOs.add(korImpPrintListVO);
				}
			} else {

				// OUT-BOUND

				// 메인 LOOP
				for (int i=0; i < condVOs.length; i++) {

					korImpPrintListVO = new KorImpPrintListVO();

					bkgNo = condVOs[i].getBkgNo();
					mrnNo = condVOs[i].getMrnNo().substring(0, 10);

					korImpPrintListVO.setMrnBlTsCd	(condVOs[i].getMrnBlTsCd()							);
					korImpPrintListVO.setSkdVoyNo	(condVOs[i].getSkdVoyNo()+condVOs[i].getSkdDirCd()	);
					korImpPrintListVO.setMrnNo		(condVOs[i].getMrnNo()								);

					// VSL NAME 조회
					korImpPrtVslNmVO = dbDao.searchImpCgoManiVslNm(condVOs[i].getVslCd());
					korImpPrintListVO.setCallSgnNo	(korImpPrtVslNmVO.getCallSgnNo()	);
					korImpPrintListVO.setVslEngNm	(korImpPrtVslNmVO.getVslEngNm()		);
					korImpPrintListVO.setCntNm		(korImpPrtVslNmVO.getCntNm()		);


					// LocNm 조회
					if (condVOs[i].getMrnBlTsCd().equals("E")) {
						korImpPrtLocNmVO = dbDao.searchImpCgoManiPrtLocNm(condVOs[i].getPolCd(), condVOs[i].getPodCd());
					} else {
						korImpPrtLocNmVO = dbDao.searchImpCgoManiPrtLocNm(condVOs[i].getPolCd(), condVOs[i].getFnlPodCd());
					}
					korImpPrintListVO.setLoc1Info(korImpPrtLocNmVO.getLoc1Info());
					korImpPrintListVO.setLoc2Info(korImpPrtLocNmVO.getLoc2Info());

					// ETD DT 조회
					korImpPrintListVO.setVpsEtdDt(dbDao.searchOfmEtdDt(condVOs[i].getVslCd()+condVOs[i].getSkdVoyNo()+condVOs[i].getSkdDirCd(), condVOs[i].getPolCd()));

					// BL INFO 조회
					korImpPrtBlInfoVO = dbDao.searchImpCgoManiBlInfo(bkgNo);
					korImpPrintListVO.setBlNo	(korImpPrtBlInfoVO.getBlNo()	);
					korImpPrintListVO.setTotWgt	(korImpPrtBlInfoVO.getTotWgt()	);
					korImpPrintListVO.setPckQty	(korImpPrtBlInfoVO.getPckQty()	);

					// MSN 정보 조회
					korMsnInfoVO = dbDao.searchOfmMsnInfo(bkgNo, mrnNo);
					korImpPrintListVO.setBlTpCd(korMsnInfoVO.getKrCstmsBlTpCd());

					// CUST INFO 조회
					korImpPrtCustVOs = dbDao.searchImpCgoManiPrtCustInfo(bkgNo);
					if (korImpPrtCustVOs != null) {
						for (int j=0; j < korImpPrtCustVOs.length; j++) {
							if (korImpPrtCustVOs[j].getBkgCustTpCd().equals("C")) {
								korImpPrintListVO.setCCustInfo(korImpPrtCustVOs[j].getCustInfo());
							} else  if (korImpPrtCustVOs[j].getBkgCustTpCd().equals("N")) {
								korImpPrintListVO.setNCustInfo(korImpPrtCustVOs[j].getCustInfo());
							} else  if (korImpPrtCustVOs[j].getBkgCustTpCd().equals("S")) {
								korImpPrintListVO.setSCustInfo(korImpPrtCustVOs[j].getCustInfo());
							}
						}
					}

					// 품명 조회
					korImpPrintListVO.setCstmsDesc(dbDao.searchImpCgoManiPrtCstmDesc(bkgNo));

					// Container Info 조회
					korCntrDgVOs = dbDao.searchOfmCntrInfo(bkgNo);
					containerInfo = new StringBuilder();
					imdgUnNo = new StringBuilder();
					if (korCntrDgVOs != null) {
						for (int j=0; j < korCntrDgVOs.length; j++) {
							if (j > 0 ) containerInfo.append("\n");
							if (j > 0 ) imdgUnNo.append("\n");
							if (j > 0 && korCntrDgVOs[j-1].getCntrInfo().equals(korCntrDgVOs[j].getCntrInfo())) {
								containerInfo.append("\n\n");
							} else {
								containerInfo.append(korCntrDgVOs[j].getCntrInfo());
							}
							imdgUnNo.append(korCntrDgVOs[j].getDgClss()).append("\n");
						}
					}
					// 값이 없으면 무한루프 오류를 막기위해 빈칸 처리
					if (imdgUnNo.toString().replaceAll("\n", "").trim().length() < 1) imdgUnNo.delete(0, imdgUnNo.length());

					korImpPrintListVO.setCntrInfo(containerInfo.toString());
					korImpPrintListVO.setImdgUnNo(imdgUnNo.toString());

					// LIST에 담기
					korImpPrintListVOs.add(korImpPrintListVO);
				}

			}

		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), de);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}

		return korImpPrintListVOs.toArray(new KorImpPrintListVO[0]);
	}

	/**
	 * 관세청에서 수신된 응답문서 조회
	 * @param RcvHistCondVO rcvHistCondVO
	 * @return RcvHistVO[]
	 * @exception EventException
	 */
	public RcvHistVO[] searchReceiveAckHist(RcvHistCondVO rcvHistCondVO) throws EventException {
		// 최종 리턴 객체
		KorRcvHistVO[] korRcvHistVOs = null;

		// 파라메터 변환
		KorRcvHistCondVO condVO = (KorRcvHistCondVO)rcvHistCondVO;

		try {

			// 조회 조건에 따른 검색 처리
			if (condVO.getSearchType().trim().equals("vvd")) {
				korRcvHistVOs = dbDao.searchReceiveHistByVVD(condVO);
			} else  if (condVO.getSearchType().trim().equals("bl_no")) {
				korRcvHistVOs = dbDao.searchReceiveHistByBl(condVO);
			} else  if (condVO.getSearchType().trim().equals("smt_no")) {
				korRcvHistVOs = dbDao.searchReceiveHistBySubmitNo(condVO);
			} else  if (condVO.getSearchType().trim().equals("recv_dt")) {
				if ( condVO.getCboMsgTp().trim().equals("5VJ") ||
					condVO.getCboMsgTp().trim().equals("6GB") ||
					condVO.getCboMsgTp().trim().equals("6G9") ||
					condVO.getCboMsgTp().trim().equals("6TB") ||
					condVO.getCboMsgTp().trim().equals("6TV") ||
					condVO.getCboMsgTp().trim().equals("6G2") ||
					condVO.getCboMsgTp().trim().equals("6G3") ) {
					korRcvHistVOs = dbDao.searchReceiveHistByCxlRcvDt(condVO);
				} else {
					korRcvHistVOs = dbDao.searchReceiveHistByRcvDt(condVO);
				}
			}

		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), de);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}

		return korRcvHistVOs;
	}

}

