/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : Kor24CustomsTransmissionBCImpl.java
*@FileTitle : Kor24CustomsTransmissionBCImpl
*Open Issues :
*Change history :
*@LastModifyDate : 2011.01.17 이수진
*@LastModifier : 이수진
*@LastVersion : 1.0
* 2011.01.17 이수진
* 1.0 Creation
* -----------------------------------------------------
* History
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea24.basic;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.FlatFileAckVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.SendFlatFileVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea24.integration.Kor24CustomsTransmissionDBDAO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea24.vo.BkgCstmsKrBlVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea24.vo.BkgCstmsKrSndLogDtlVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea24.vo.BkgCstmsKrSndLogVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea24.vo.BkgCstmsKrVvdSmryVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea24.vo.Kor24AmendManifestTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea24.vo.Kor24AutoImfSndDtlVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea24.vo.Kor24AutoImfSndVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea24.vo.Kor24AutoMacSndDtlVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea24.vo.Kor24AutoMacSndVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea24.vo.Kor24CancelManifestTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea24.vo.Kor24CntrCntVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea24.vo.Kor24CorrVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea24.vo.Kor24CusmanVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea24.vo.Kor24CusrepVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea24.vo.Kor24DiscFlatFileVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea24.vo.Kor24DischManifestTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea24.vo.Kor24EmpAmdManiTransVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea24.vo.Kor24EmpImfmodVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea24.vo.Kor24EmpMacamdVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea24.vo.Kor24ImfmodVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea24.vo.Kor24MacamdVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea24.vo.Kor24MakeSubNoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea24.vo.Kor24ManifestTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea24.vo.Kor24UNLocVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.AmendManifestTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.CancelManifestTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.DischManifestTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.EmpAmdManiTransVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.ManifestTransmitVO;
import com.hanjin.framework.component.backend.core.BackEndJobManager;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.util.object.ObjectCloner;
import com.hanjin.framework.core.config.SubSystemConfigFactory;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;


/**
 * ALPS-CustomsDeclaration Business Logic Basic Command implementation<br>
 * - ALPS-CustomsDeclaration에 대한 비지니스 로직을 처리<br>
 *
 * @author KIM, Sang-Soo
 * @see 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class Kor24CustomsTransmissionBCImpl extends BasicCommandSupport implements Kor24CustomsTransmissionBC {

	// Database Access Object
	private transient Kor24CustomsTransmissionDBDAO dbDao = null;

	/**
	 * JapanCustomsTransmissionBCImpl 객체 생성<br>
	 * JapanCustomsTransmissionDAO를 생성한다.<br>
	 */
	public Kor24CustomsTransmissionBCImpl() {
		dbDao = new Kor24CustomsTransmissionDBDAO();
	}

	/**
	 * Manifest Transmit Discharge ( 하선신고 )
	 * @param DischManifestTransmitVO dischManifestTransmitVO
	 * @return String
	 * @exception EventException
	 */
	public String transmitDischManifest(DischManifestTransmitVO dischManifestTransmitVO) throws EventException {
		// 파라메터 변환
		Kor24DischManifestTransmitVO condVO = (Kor24DischManifestTransmitVO)dischManifestTransmitVO;

		// IN TYPE 처리
		String inType = condVO.getInType();
		if ("|A|B|C|D|M".indexOf(inType) < 1) inType = "N";
		// PORT CD 처리
		String portCd = condVO.getPodCd();
//		if ("|A|B|C|D".indexOf(inType) > 0) portCd = condVO.getPolCd();
		if ( "O".equals(condVO.getIoBndCd())){
			portCd = condVO.getPolCd();
		}

		// FlatFile 객체
		String 		 flatFileHeader = null;
		StringBuffer flatFileBody   = new StringBuffer();
		StringBuffer tempData 		= new StringBuffer();
		StringBuffer flatFile 		= new StringBuffer();
		String		 flatFileRefNo 	= null;
		StringBuffer bfTemp 		= new StringBuffer();
		String[]     arTemp 		= null;
		// flatFile 생성용 객체
		Kor24DiscFlatFileVO   kor24DiscFlatFileVO = new Kor24DiscFlatFileVO();
		Kor24DiscFlatFileVO[] kor24DiscFlatFileVOs = null;
		String[] cntrDatas 		= null;
		BookingUtil bookingUtil = new BookingUtil();
		int k=0;

		// 전송일시
		String sndDt = null;

		// 전송 로그 기록을 위한 객체
		BkgCstmsKrSndLogVO bkgCstmsKrSndLogVO 		= new BkgCstmsKrSndLogVO();
		BkgCstmsKrSndLogDtlVO bkgCstmsKrSndLogDtlVO = new BkgCstmsKrSndLogDtlVO();
		// TEU, FEU count 용 객체
		Kor24CntrCntVO kor24CntrCntVO = new Kor24CntrCntVO();
		int teuCnt=0, feuCnt=0;

		try {

			// Header 생성
			flatFileHeader = bookingUtil.searchCstmsEdiHeader("SSSMLMM010", "KTNETMFCSS", "CUSAGD");
			flatFileRefNo = flatFileHeader.substring(flatFileHeader.indexOf("BKC"));
			// FlatFile 에 추가
			flatFile.append(flatFileHeader).append("\n");


			// FLATFILE 헤더 생성(DB 이용)
			kor24DiscFlatFileVO.setCstmsDschCd	(condVO.getCstmsDchgCd()	);
			kor24DiscFlatFileVO.setMrnNo			(condVO.getMrnNo()			);
			kor24DiscFlatFileVO.setLoclCstmsCd	(condVO.getLoclCstmsCd()	);
			kor24DiscFlatFileVO.setLoclCstmsPrtCd	(condVO.getLoclCstmsPrtCd()	);
			// 헤더 생성
			flatFileHeader = dbDao.makeDiscHeadFlatFile(kor24DiscFlatFileVO);
			arTemp = flatFileHeader.split("~", 100);

			k=0;
			bfTemp.setLength(0);
			bfTemp.append("NEWMOD:").append(arTemp[k++]).append("\n");
			bfTemp.append("MRNNBR:").append(arTemp[k++]).append("\n");
			bfTemp.append("PARTY:").append(arTemp[k++]).append("\n");
			bfTemp.append("DSCH_COM:").append(arTemp[k++]).append("\n");
			bfTemp.append("PLI:").append(arTemp[k++]).append("\n");
			bfTemp.append("RPLI:").append(arTemp[k++]).append("\n");

			// FlatFile 에 추가
			flatFile.append(bfTemp.toString());
			flatFileHeader = flatFile.toString();

			// 전송일시 생성 (YYYYMMDD hh24:mi:ss)
			sndDt = dbDao.searchSysDate();

			// SEND LOG 추가
			// BL_CNT 는 화면에서 넘어오는 MST_BL_KNT 로 사용
			bkgCstmsKrSndLogVO.setBlKnt			(condVO.getMstBlKnt()	);
			bkgCstmsKrSndLogVO.setVvd			(condVO.getVvd()		);
			bkgCstmsKrSndLogVO.setOfcCd			(condVO.getOfcCd()		);
			bkgCstmsKrSndLogVO.setFltFileRefNo	(flatFileRefNo			);
			bkgCstmsKrSndLogVO.setUserId		(condVO.getUserId()		);
			bkgCstmsKrSndLogVO.setIoBndCd		(condVO.getIoBndCd()	);
			// 공동 VVD 인 경우에는 Type 을 'E'로 설정
			if("E".equals(condVO.getNoneBlInType())){
				bkgCstmsKrSndLogVO.setInType		(condVO.getNoneBlInType());
			} else {
				bkgCstmsKrSndLogVO.setInType		(inType					);
			}
			bkgCstmsKrSndLogVO.setPolCd			(condVO.getPolCd()		);
			bkgCstmsKrSndLogVO.setPodCd			(condVO.getPodCd()		);
			bkgCstmsKrSndLogVO.setSndDt			(sndDt					);
			// 로그 기록
			//dbDao.addDiscSndLog(bkgCstmsKrSndLogVO);

			// DETAIL LOG 기록
			bkgCstmsKrSndLogDtlVO.setSndDt			(sndDt				);
			bkgCstmsKrSndLogDtlVO.setEdiSndMsg		(flatFileHeader		);
			bkgCstmsKrSndLogDtlVO.setOfcCd			(condVO.getOfcCd()	);
			bkgCstmsKrSndLogDtlVO.setFltFileRefNo	(flatFileRefNo		);
			bkgCstmsKrSndLogDtlVO.setUserId			(condVO.getUserId()	);
			// 로그 기록
			//dbDao.addDiscHeadSndDtlLog(bkgCstmsKrSndLogDtlVO);

			if(!"E".equals(condVO.getNoneBlInType())){

				// FLATFILE BODY 생성
				kor24DiscFlatFileVO.setVvd(condVO.getVvd());
				kor24DiscFlatFileVO.setPortCd(portCd);
				kor24DiscFlatFileVO.setInType(inType);
				kor24DiscFlatFileVO.setIoBndCd(condVO.getIoBndCd());
				kor24DiscFlatFileVO.setPodCd(condVO.getPodCd());
				kor24DiscFlatFileVO.setPolCd(condVO.getPolCd());
				// 조회
					kor24DiscFlatFileVOs = dbDao.makeDiscBodyFlatFile(kor24DiscFlatFileVO);
				// 조회 결과 LOOP
				for(int i=0; i < kor24DiscFlatFileVOs.length; i++) {
					kor24DiscFlatFileVO = kor24DiscFlatFileVOs[i];
					// FlatFile 만들기
					arTemp = kor24DiscFlatFileVO.getBlData().split("~",100);

					tempData.setLength(0);
					k=0;

					tempData.append("{BL_CNTR").append("\n");
					tempData.append("BLNBR:").append(arTemp[k++]).append("\n");
					tempData.append("T_REF_NO:").append(arTemp[k++]).append("\n");
					tempData.append("BOND_AREA_CODE:").append(arTemp[k++]).append("\n");
					tempData.append("PKG:").append(arTemp[k++].replaceAll(",","")).append("\n");
					tempData.append("PKGU:").append(arTemp[k++]).append("\n");
					tempData.append("WGT:").append(arTemp[k++].replaceAll(",","")).append("\n");

					// BODY SEND LOG 기록
					bkgCstmsKrSndLogDtlVO.setEdiSndMsg(tempData.toString());
					//dbDao.addDiscBodySendDtlLog(bkgCstmsKrSndLogDtlVO);
					// FLATFILE BODY 추가
					flatFileBody.append(tempData);

					// CONTAINER FLATFILE 생성
					kor24DiscFlatFileVO.setPortCd(portCd);
					kor24DiscFlatFileVO.setUserId(condVO.getUserId());
					cntrDatas = dbDao.makeDiscCntrFlatFile(kor24DiscFlatFileVO);
					// TEU, FEU 카운트 조회
					kor24CntrCntVO = new Kor24CntrCntVO();
					// 중복 제거
					if (i==0 || !kor24DiscFlatFileVOs[i-1].getBkgNo().equals(kor24DiscFlatFileVOs[i].getBkgNo()) ) {
						kor24CntrCntVO.setBkgNo			(kor24DiscFlatFileVOs[i].getBkgNo()			);
						kor24CntrCntVO.setCstmsDeclTpCd	(kor24DiscFlatFileVOs[i].getCstmsDeclTpCd()	);
						kor24CntrCntVO.setPortCd			(portCd										);
						kor24CntrCntVO = dbDao.searchTeuFeuCnt(kor24CntrCntVO);

						if (kor24CntrCntVO!=null) {
							// COUNT 누적
							teuCnt = teuCnt + Integer.parseInt(kor24CntrCntVO.getTeuCnt());
							feuCnt = feuCnt + Integer.parseInt(kor24CntrCntVO.getFeuCnt());
						}
					}

					// CONTAINER LOOP
					if (cntrDatas!=null) {
						for(int j=0; j < cntrDatas.length; j++) {
							// TEMP 에 추가
							tempData.setLength(0);
							tempData.append("{CNTR_INFO").append("\n");
							tempData.append("CNTRNBR:").append(cntrDatas[j]).append("\n");
							tempData.append("}CNTR_INFO").append("\n");
							// Container Send Log 추가
							bkgCstmsKrSndLogDtlVO.setEdiSndMsg(tempData.toString());
							//dbDao.addDiscCNTRSendDtlLog(bkgCstmsKrSndLogDtlVO);
							// flatFile Body 에 추가
							flatFileBody.append(tempData);

						}
					}

					// FLATFILE FOOTER 생성
					bkgCstmsKrSndLogDtlVO.setEdiSndMsg("}BL_CNTR\n");
					flatFileBody.append(bkgCstmsKrSndLogDtlVO.getEdiSndMsg());

					// End Send Log 추가
					//dbDao.addDiscEndSendDtlLog(bkgCstmsKrSndLogDtlVO);
				}
			}

			// 전송 로그 업데이트
			bkgCstmsKrSndLogVO.setTeuCnt(String.valueOf(teuCnt));
			bkgCstmsKrSndLogVO.setFeuCnt(String.valueOf(feuCnt));
			//dbDao.modifyDiscSndLog(bkgCstmsKrSndLogVO);

			// FLATFILE 조립
			flatFile.append(flatFileBody);

			// flatFile 전송
			ediSendMessage(flatFile.toString(), "BKG.ALPSBKG_UBIZHJS_KRCUS_GENERAL.IBMMQ.QUEUE");

			return flatFile.toString();

		}catch(DAOException de) {
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), de);
		}catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		}

	}

	/**
	 * BackEndJob을 실행.
	 *
	 * @param SignOnUserAccount account
	 * @param ManifestTransmitVO manifestTransmitVO
	 * @param String pgmNo
	 * @return String
	 * @throws EventException
	 *
	 */
	public String startBackEndJob(SignOnUserAccount account, ManifestTransmitVO manifestTransmitVO, String pgmNo )  throws EventException{
		String resultStr = "";
		if(pgmNo.equals("ESM_BKG_1344")) {
			Kor24CustomsTransmissionBackEndJob backEndJob = new Kor24CustomsTransmissionBackEndJob();
			backEndJob.setPgmNo(pgmNo);
			backEndJob.setManifestTransmitVO(manifestTransmitVO);
			BackEndJobManager backEndJobManager = new BackEndJobManager();
			resultStr = backEndJobManager.execute(backEndJob , account.getUsr_id(), "KOR EDI Transmit");
		}
		return resultStr;
	}

	/**
	 * Manifest를 신고하기 위해 FlatFile을 생성한다.
	 *
	 * @param ManifestTransmitVO manifestTransmitVO
	 * @return String
	 * @exception EventException
	 */
	public String transmitManifest(ManifestTransmitVO manifestTransmitVO) throws EventException {
		// FLATFILE
		StringBuffer flatFile = new StringBuffer();
		String fltFileRefNo = null;
		String[] arTemp = null;
		StringBuffer bfTemp = new StringBuffer();
		int k=0;

		// 파라메터 변환
		Kor24ManifestTransmitVO condVO = (Kor24ManifestTransmitVO)manifestTransmitVO;

		// POD TML 생성
		String podTml = condVO.getPodCd() + condVO.getTmlCd();
		// IN TYPE 처리
		String inType = condVO.getInType();
		if ("|A|B|C|D|M".indexOf(inType) < 1) inType = "N";

		// PORT CD 처리
		String portCd = condVO.getPodCd();
//		if ("|A|B|C|D".indexOf(inType) > 0) portCd = condVO.getPolCd();
		if ( "O".equals(condVO.getIoBndCd())){
			portCd = condVO.getPolCd();
		}

		// Bond Code Update 용 객체
		BkgCstmsKrBlVO bkgCstmsKrBlVO = new BkgCstmsKrBlVO();
		// VVD SEND UPDATE 용 객체
		BkgCstmsKrVvdSmryVO bkgCstmsKrVvdSmryVO = new BkgCstmsKrVvdSmryVO();
		// PORT 검색결과
		String unPolCd = null;
		String unPodCd = null;
		String delCd = null;
		// 일괄삭제 후 재전송 여부
		String resndChk = null;

		// FLATFILE 관련 객체
		String flatFileHeader = null;
		StringBuffer flatFileBody   = new StringBuffer();
		StringBuffer flatFileExport = new StringBuffer();
		StringBuffer flatFileCNTR   = new StringBuffer();

		// 헤더 생성용 객체
		BookingUtil bookingUtil = new BookingUtil();
		Kor24CusrepVO kor24CusrepVO = new Kor24CusrepVO();
		// BODY 생성용 객체
		Kor24CusmanVO   kor24CusmanVO  = new Kor24CusmanVO();
		Kor24CusmanVO[] kor24CusmanVOs = null;

		// 전송 로그 기록을 위한 객체
		BkgCstmsKrSndLogVO 	  bkgCstmsKrSndLogVO 	= new BkgCstmsKrSndLogVO();
		BkgCstmsKrSndLogDtlVO bkgCstmsKrSndLogDtlVO = new BkgCstmsKrSndLogDtlVO();
		// TEU, FEU COUNT 용 객체
		Kor24CntrCntVO cntrCntVO = new Kor24CntrCntVO();
		// Export License 객체
		String[] elDatas = null;
		// Container 객체
		String[] cntrDatas = null;
		// Seal Number 관련
		String tempSealNumber = null;
		String[] sealNumbers = null;

		// TEU,FEU 누적용 변수
		int teuCnt = 0;
		int feuCnt = 0;

		// SEND DATE
		String sndDt = null;

		try {

			bkgCstmsKrBlVO.setVvd		(condVO.getVvd()	);
			bkgCstmsKrBlVO.setPortCd	(portCd				);
			bkgCstmsKrBlVO.setInType	(inType				);
			bkgCstmsKrBlVO.setIoBndCd	(condVO.getIoBndCd());
			bkgCstmsKrBlVO.setPolCd		(condVO.getPolCd()	);
			bkgCstmsKrBlVO.setPodCd		(condVO.getPodCd()	);
			bkgCstmsKrBlVO.setPodTml	(podTml				);
			bkgCstmsKrBlVO.setUserId	(condVO.getUserId()	);

			// VVD Summary 정보 UPDATE
			bkgCstmsKrVvdSmryVO.setVvd			 (condVO.getVvd()			);
			bkgCstmsKrVvdSmryVO.setVslCntCd		 (condVO.getVslCntCd()		);
			bkgCstmsKrVvdSmryVO.setVslNm		 (condVO.getVslNm()			);
			bkgCstmsKrVvdSmryVO.setVslCallSgnCd	 (condVO.getVslCallSgnCd()	);
			bkgCstmsKrVvdSmryVO.setEtaDt		 (condVO.getEtaDt()			);
			bkgCstmsKrVvdSmryVO.setEtdDt		 (condVO.getEtdDt()			);
			bkgCstmsKrVvdSmryVO.setCstmsDchgCd	 (condVO.getCstmsDchgCd()	);
			bkgCstmsKrVvdSmryVO.setUserId		 (condVO.getUserId()		);
			bkgCstmsKrVvdSmryVO.setCallKnt		 (condVO.getCallKnt()		);
			bkgCstmsKrVvdSmryVO.setDchgMzdCd	 (condVO.getDchgMzdCd()		);
			bkgCstmsKrVvdSmryVO.setIoTmlLocCd	 (condVO.getIoTmlLocCd()	);
			bkgCstmsKrVvdSmryVO.setLoclCstmsCd	 (condVO.getLoclCstmsCd()	);
			bkgCstmsKrVvdSmryVO.setLoclCstmsPrtCd(condVO.getLoclCstmsPrtCd());
			bkgCstmsKrVvdSmryVO.setMrnNo		 (condVO.getMrnNo()			);
			bkgCstmsKrVvdSmryVO.setVvdSeq		 (condVO.getVvdSeq()		);
			bkgCstmsKrVvdSmryVO.setInType		 (inType					);

			// UNLOCODE 조회
			if (condVO.getIoBndCd().equals("O")) {
				// OUT-BOUND 처리
				unPolCd = dbDao.searchOBUNLocCd(condVO.getPolCd());
			}else {
				// IN-BOUND 처리
				unPodCd = dbDao.searchIBUNLocCd(condVO.getPodCd());
			}

			// 일괄삭제후 재전송일 경우
			if (condVO.getInReceiver().equals("1")) resndChk = "P";

			// 송수신처 판단
			String sender 	= "SSSMLMM010";

			//2013.10.29 서범적용 관련 변경

			String receiver = "KTNETULHS4G";

/*
			// 공동 VVD 인 경우
			if("E".equals(condVO.getNoneBlInType())){
				sender   = "SSSMLMM010"; receiver = "KTNETMFCSS";
			}
			if (resndChk!=null && resndChk.equals("P")) sender = "SMLM0001";
			if (resndChk!=null && resndChk.equals("P")) {
				if (condVO.getKtPa().equals("020") || condVO.getKtPa().equals("20")) {
					receiver = "KMPAE010";
				}else if (condVO.getKtPa().equals("030") || condVO.getKtPa().equals("30") || condVO.getKtPa().equals("031") || condVO.getKtPa().equals("31") || condVO.getKtPa().equals("050") || condVO.getKtPa().equals("50")) {
					receiver = "KMPAE030";
				}else if (condVO.getKtPa().equals("622")) {
					receiver = "KMPAE050";
				}
			}*/

			// 헤더 생성
			flatFileHeader = bookingUtil.searchCstmsEdiHeader(sender, receiver, "CUSREP");
			fltFileRefNo = flatFileHeader.substring(flatFileHeader.indexOf("BKC"));

			// flatFile 에 추가
			flatFile.append(flatFileHeader).append("\n");

			// FLATFILE 헤더 생성
			kor24CusrepVO.setResndChk			(resndChk					);
			kor24CusrepVO.setKtPa				(condVO.getKtPa()			);
			kor24CusrepVO.setIoBndCd			(condVO.getIoBndCd()		);
			kor24CusrepVO.setLoclCstmsCd		(condVO.getLoclCstmsCd()	);
			kor24CusrepVO.setLoclCstmsPrtCd	(condVO.getLoclCstmsPrtCd()	);
			kor24CusrepVO.setVslCntCd			(condVO.getVslCntCd()		);
			kor24CusrepVO.setVslNm			(condVO.getVslNm()			);
			kor24CusrepVO.setVslCallSgnCd		(condVO.getVslCallSgnCd()	);
			kor24CusrepVO.setMrnNo			(condVO.getMrnNo()			);
			kor24CusrepVO.setVvd				(condVO.getVvd()			);
			kor24CusrepVO.setUnPodCd			(unPodCd					);
			kor24CusrepVO.setUnPolCd			(unPolCd					);
			kor24CusrepVO.setPolCd			(condVO.getPolCd()			);
			kor24CusrepVO.setPodCd			(condVO.getPodCd()			);
			kor24CusrepVO.setEtaDt			(condVO.getEtaDt()			);
			kor24CusrepVO.setEtdDt			(condVO.getEtdDt()			);
			kor24CusrepVO.setMsnNo			(condVO.getJoCrrKnt()		);
			kor24CusrepVO.setInType			(inType						);
			kor24CusrepVO.setVvdSeq			(condVO.getVvdSeq()			);
			kor24CusrepVO.setCallKnt			(condVO.getCallKnt());
			kor24CusrepVO.setDelCd			(condVO.getDelCd()			);

			// 헤더 추가정보 생성
			// 공동 VVD 인 경우
			if("E".equals(condVO.getNoneBlInType())){
				// Out bound 일때만 inType = 'E'로 세팅.
				if (condVO.getIoBndCd().equals("O")) {
					kor24CusrepVO.setInType(condVO.getNoneBlInType());
				}
				flatFileHeader = dbDao.makeCUSREPNoneBLVVDFlatFile(kor24CusrepVO);
			} else {
			// 일반 헤더 파일
				flatFileHeader = dbDao.makeCUSREPFlatFile(kor24CusrepVO);
			}
			arTemp = flatFileHeader.split("~",100);

			k=0;
			bfTemp.setLength(0);

			bfTemp.append("{MASTER:").append(arTemp[k++]).append("\n");
			bfTemp.append("PLI:").append(arTemp[k++]).append("\n");
			bfTemp.append("RPLI:").append(arTemp[k++]).append("\n");
			bfTemp.append("VSLCOUNTRY:").append(arTemp[k++]).append("\n");
			bfTemp.append("VSLFULLNAME:").append(arTemp[k++]).append("\n");
			bfTemp.append("CALLSIGN:").append(arTemp[k++]).append("\n");
			bfTemp.append("NEWMOD:").append(arTemp[k++]).append("\n");
			bfTemp.append("MRNNBR:").append(arTemp[k++]).append("\n");
			bfTemp.append("VSLCODE:").append(arTemp[k++]).append("\n");
			bfTemp.append("VSLVOY:").append(arTemp[k++]).append("\n");
			bfTemp.append("VSLDIR:").append(arTemp[k++]).append("\n");
			bfTemp.append("SENDDATE:").append(arTemp[k++]).append("\n");
			bfTemp.append("SENDTIME:").append(arTemp[k++]).append("\n");
			bfTemp.append("PARTY:").append(arTemp[k++]).append("\n");
			bfTemp.append("POL:").append(arTemp[k++]).append("\n");
			bfTemp.append("POD:").append(arTemp[k++]).append("\n");

			delCd =dbDao.searchDelCd(condVO.getVvd(),condVO.getPolCd());
			bfTemp.append("DEL:").append(delCd).append("\n");
			bfTemp.append("ETA:").append(arTemp[k++]).append("\n");
			bfTemp.append("ETD:").append(arTemp[k++]).append("\n");
			bfTemp.append("MBT:").append(arTemp[k++]).append("\n");
			bfTemp.append("CBT:").append(arTemp[k++]).append("\n");
			bfTemp.append("TWGT:").append(arTemp[k++].replaceAll(",","")).append("\n");
			bfTemp.append("TMEA:").append(arTemp[k++].replaceAll(",","")).append("\n");
			bfTemp.append("TPKG:").append(arTemp[k++].replaceAll(",","")).append("\n");
			bfTemp.append("FCT:").append(arTemp[k++]).append("\n");
			bfTemp.append("ECT:").append(arTemp[k++]).append("\n");
			bfTemp.append("JOINT:").append(arTemp[k++]).append("\n");
			bfTemp.append("AGENCY:").append(arTemp[k++]).append("\n");
			bfTemp.append("INPORT_YYYY:").append(arTemp[k++]).append("\n");
			bfTemp.append("INPORT_CNT:").append(arTemp[k++].replaceAll(",","")).append("\n");
			bfTemp.append("PORT_AUTH:").append(arTemp[k++]).append("\n");
			bfTemp.append("VSLCOM_CODE:").append(arTemp[k++]).append("\n");
			bfTemp.append("}MASTER").append("\n");

			flatFile.append(bfTemp);

			flatFileHeader = flatFile.toString();

			// Send Data 생성
			sndDt = dbDao.searchSysDate();

			// 전송 로그 기록
			bkgCstmsKrSndLogVO.setIoBndCd		(condVO.getIoBndCd()	);
			bkgCstmsKrSndLogVO.setSndDt			(sndDt					);
			bkgCstmsKrSndLogVO.setOfcCd			(condVO.getOfcCd()		);
			bkgCstmsKrSndLogVO.setFltFileRefNo	(fltFileRefNo			);
			bkgCstmsKrSndLogVO.setUserId		(condVO.getUserId()		);
			bkgCstmsKrSndLogVO.setVvd			(condVO.getVvd()		);
			bkgCstmsKrSndLogVO.setPolCd			(condVO.getPolCd()		);
			bkgCstmsKrSndLogVO.setPodCd			(condVO.getPodCd()		);
			// 공동 VVD 인 경우에는 Type 을 'E'로 설정
			if("E".equals(condVO.getNoneBlInType())){
				bkgCstmsKrSndLogVO.setInType		(condVO.getNoneBlInType());
			} else {
				bkgCstmsKrSndLogVO.setInType		(inType					);
			}
			bkgCstmsKrSndLogVO.setBlKnt			(condVO.getMstBlKnt()	);
			bkgCstmsKrSndLogVO.setResndChk		(resndChk				);
			bkgCstmsKrSndLogVO.setKtPa			(condVO.getKtPa()		);
			// 로그기록
			//dbDao.addCUSREPSndLog(bkgCstmsKrSndLogVO);

			// 전송 세부 로그 기록
			bkgCstmsKrSndLogDtlVO.setIoBndCd		(condVO.getIoBndCd());
			bkgCstmsKrSndLogDtlVO.setSndDt			(sndDt				);
			bkgCstmsKrSndLogDtlVO.setEdiSndMsg		(flatFileHeader		);
			bkgCstmsKrSndLogDtlVO.setOfcCd			(condVO.getOfcCd()	);
			bkgCstmsKrSndLogDtlVO.setFltFileRefNo	(fltFileRefNo		);
			bkgCstmsKrSndLogDtlVO.setUserId			(condVO.getUserId()	);
			// 로그 기록
			//dbDao.addCUSREPSndDtlLog(bkgCstmsKrSndLogDtlVO);

			// FLATFILE BODY 생성시작
			flatFileHeader = bookingUtil.searchCstmsEdiHeader(sender, receiver, "CUSMAN");
			flatFileHeader = flatFileHeader.substring(0, flatFileHeader.indexOf("BKC")) + fltFileRefNo;

			// 공동 VVD 인 경우에는 Type 을 'E'로 설정
			if(!"E".equals(condVO.getNoneBlInType())){

				kor24CusmanVO.setResndChk	(resndChk				);
				kor24CusmanVO.setKtPa		(condVO.getKtPa()		);
				kor24CusmanVO.setIoBndCd	(condVO.getIoBndCd()	);
				kor24CusmanVO.setMrnNo	(condVO.getMrnNo()		);
				kor24CusmanVO.setD2Cnt	(condVO.getTtlLcTeuQty());
				kor24CusmanVO.setD4Cnt	(condVO.getTtlTsTeuQty());
				kor24CusmanVO.setDiscMdCd	(condVO.getDchgMzdCd()	);
				kor24CusmanVO.setIoQuay	(condVO.getIoTmlLocCd()	);
				kor24CusmanVO.setVvd		(condVO.getVvd()		);
				kor24CusmanVO.setBlNo		(condVO.getBlNo()		);
				kor24CusmanVO.setPortCd	(portCd					);
				kor24CusmanVO.setInType	(inType					);
				kor24CusmanVO.setPodCd	(condVO.getPodCd()		);
				kor24CusmanVO.setPolCd	(condVO.getPolCd()		);
				kor24CusmanVO.setPortTmlCd(podTml					);
				kor24CusmanVOs = dbDao.makeCUSMANBlFlatFile(kor24CusmanVO);

				if (kor24CusmanVOs==null) throw new EventException(new ErrorHandler("BKG00889").getMessage());

				// BODY LOOP ( CUSMAN )
				for(int i=0; i < kor24CusmanVOs.length; i++) {
					// DETAIL 전송 로그 기록
					bfTemp.setLength(0);
					k=0;
					arTemp = kor24CusmanVOs[i].getBlData().split("~",200);

					bfTemp.append(flatFileHeader).append("\n");
					bfTemp.append("MSGTYPE:").append(arTemp[k++]).append("\n");
					bfTemp.append("NEWMOD:").append(arTemp[k++]).append("\n");
					bfTemp.append("MRNNBR:").append(arTemp[k++]).append("\n");
					bfTemp.append("BLNBR:").append(arTemp[k++]).append("\n");
					bfTemp.append("BKGNBR:").append(arTemp[k++]).append("\n");
					bfTemp.append("BLTYPE:").append(arTemp[k++]).append("\n");
					bfTemp.append("TRANS:").append(arTemp[k++]).append("\n");
					bfTemp.append("CGO_SP:").append(arTemp[k++]).append("\n");
					bfTemp.append("BLPKG:").append(arTemp[k++].replaceAll(",","")).append("\n");
					bfTemp.append("BLPKGU:").append(arTemp[k++]).append("\n");
					bfTemp.append("BLWGT:").append(arTemp[k++].replaceAll(",","")).append("\n");
					bfTemp.append("BLWGTU:").append(arTemp[k++]).append("\n");
					bfTemp.append("BLMEA:").append(arTemp[k++].replaceAll(",","")).append("\n");
					bfTemp.append("BLMEAU:").append(arTemp[k++]).append("\n");
					bfTemp.append("BOND_AREA_CODE:").append(arTemp[k++]).append("\n");
					bfTemp.append("IMDGCODE1:").append(arTemp[k++]).append("\n");
					bfTemp.append("IMDGCODE2:").append(arTemp[k++]).append("\n");
					bfTemp.append("IMDGCODE3:").append(arTemp[k++]).append("\n");
					bfTemp.append("BLPOL:").append(arTemp[k++]).append("\n");
					bfTemp.append("WHOUSE:").append(arTemp[k++]).append("\n");
					bfTemp.append("WHOUSE_DESC:").append(arTemp[k++]).append("\n");
					bfTemp.append("BLPOD:").append(arTemp[k++]).append("\n");
					bfTemp.append("BLDEL:").append(arTemp[k++]).append("\n");
					bfTemp.append("DESC1:").append(arTemp[k++].replace(",", "")).append("\n");
					bfTemp.append("DESC2:").append(arTemp[k++].replace(",", "")).append("\n");
					bfTemp.append("SHPR1:").append(arTemp[k++]).append("\n");
					bfTemp.append("SHPR2:").append(arTemp[k++]).append("\n");
					bfTemp.append("SHPR3:").append(arTemp[k++]).append("\n");
					bfTemp.append("SHPR4:").append(arTemp[k++]).append("\n");
					bfTemp.append("SHPR5:").append(arTemp[k++]).append("\n");
					bfTemp.append("STEL:").append(arTemp[k++]).append("\n");
					bfTemp.append("CNEE1:").append(arTemp[k++]).append("\n");
					bfTemp.append("CNEE2:").append(arTemp[k++]).append("\n");
					bfTemp.append("CNEE3:").append(arTemp[k++]).append("\n");
					bfTemp.append("CNEE4:").append(arTemp[k++]).append("\n");
					bfTemp.append("CNEE5:").append(arTemp[k++]).append("\n");
					bfTemp.append("CTEL:").append(arTemp[k++]).append("\n");
					bfTemp.append("NTFY1:").append(arTemp[k++]).append("\n");
					bfTemp.append("NTFY2:").append(arTemp[k++]).append("\n");
					bfTemp.append("NTFY3:").append(arTemp[k++]).append("\n");
					bfTemp.append("NTFY4:").append(arTemp[k++]).append("\n");
					bfTemp.append("NTFY5:").append(arTemp[k++]).append("\n");
					bfTemp.append("NTEL:").append(arTemp[k++]).append("\n");
					bfTemp.append("CNTRTYPE1:").append(arTemp[k++]).append("\n");
					bfTemp.append("CNTRVOL1:").append(arTemp[k++]).append("\n");
					bfTemp.append("CNTRTYPE2:").append(arTemp[k++]).append("\n");
					bfTemp.append("CNTRVOL2:").append(arTemp[k++]).append("\n");
					bfTemp.append("CNTRTYPE3:").append(arTemp[k++]).append("\n");
					bfTemp.append("CNTRVOL3:").append(arTemp[k++]).append("\n");
					bfTemp.append("CNTRTYPE4:").append(arTemp[k++]).append("\n");
					bfTemp.append("CNTRVOL4:").append(arTemp[k++]).append("\n");
					bfTemp.append("CNTRTYPE5:").append(arTemp[k++]).append("\n");
					bfTemp.append("CNTRVOL5:").append(arTemp[k++]).append("\n");
					bfTemp.append("BLSTAT:").append(arTemp[k++]).append("\n");
					bfTemp.append("T_REF_NO:").append(arTemp[k++]).append("\n");
					bfTemp.append("RESND_BIT:").append(arTemp[k++]).append("\n");
					bfTemp.append("MODI_CODE:").append(arTemp[k++]).append("\n");
					bfTemp.append("CNTRCNT:").append(arTemp[k++].replaceAll(",","")).append("\n");
					bfTemp.append("CMDT_REP:").append(arTemp[k++]).append("\n");
					bfTemp.append("MEA_TON:").append(arTemp[k++].replaceAll(",","")).append("\n");
					bfTemp.append("SBIZNO:").append(arTemp[k++]).append("\n");
					bfTemp.append("CBIZNO:").append(arTemp[k++]).append("\n");
					bfTemp.append("NBIZNO:").append(arTemp[k++]).append("\n");
					bfTemp.append("DISC_COMP:").append(arTemp[k++]).append("\n");
					bfTemp.append("BLK_TOT_WGT:").append(arTemp[k++].replaceAll(",","")).append("\n");
					bfTemp.append("BLK_TOT_MEA:").append(arTemp[k++].replaceAll(",","")).append("\n");
					bfTemp.append("DISC_MD_CD:").append(arTemp[k++]).append("\n");
					bfTemp.append("IO_QUAY:").append(arTemp[k++]).append("\n");

					//로그기록
					bkgCstmsKrSndLogDtlVO.setEdiSndMsg(bfTemp.toString());
					//dbDao.addCUSMANSndDtlLog(bkgCstmsKrSndLogDtlVO);

					// TEU, FEU CNT 조회
					cntrCntVO = new Kor24CntrCntVO();
					// 중복 제거
					if (i == 0 || !kor24CusmanVOs[i-1].getBkgNo().equals(kor24CusmanVOs[i].getBkgNo())) {
						cntrCntVO.setCstmsDeclTpCd	(kor24CusmanVOs[i].getCstmsDeclTpCd()	);
						cntrCntVO.setBkgNo			(kor24CusmanVOs[i].getBkgNo()			);
						cntrCntVO.setPortCd			(kor24CusmanVOs[i].getPortCd()		);
						cntrCntVO = dbDao.searchTeuFeuCnt(cntrCntVO);
						// TEU, FEU CNT 누적
						if (cntrCntVO!=null) {
							teuCnt = teuCnt + Integer.parseInt(cntrCntVO.getTeuCnt());
							feuCnt = feuCnt + Integer.parseInt(cntrCntVO.getFeuCnt());
						}
					}
					// FLATFILE 합치기
					flatFileBody.append(bfTemp);

					// SC_DIV 가 'C'가 아닌것만 ELNO FLATFILE 생성
					if (!kor24CusmanVOs[i].getScDiv().equals("C")) {
						// Export License FlatFile 생성 ( EXPORT )
						elDatas = dbDao.makeCUSMANExpFlatFile(kor24CusmanVOs[i]);
						// LOOP
						if (elDatas!=null) {

							for(int j=0; j < elDatas.length; j++) {
								flatFileExport.setLength(0);
								k=0;

								arTemp = elDatas[j].split("~",100);

								flatFileExport.append("{KCS_EXNO").append("\n");
								flatFileExport.append("B_EXNO:").append(arTemp[k++].replaceAll("-", "")).append("\n");
								if (!"".equals(condVO.getPolCd()) && condVO.getPolCd()!= null){
								flatFileExport.append("B_UCRNO:").append(arTemp[k++]).append("\n");
								}
								flatFileExport.append("B_PKGU:").append(arTemp[k++]).append("\n");
								flatFileExport.append("B_PKG:").append(arTemp[k++].replaceAll(",","")).append("\n");
								flatFileExport.append("B_WGTU:").append(arTemp[k++]).append("\n");
								flatFileExport.append("B_WGT:").append(arTemp[k++].replaceAll(",","")).append("\n");
								flatFileExport.append("PART_EXNO:").append(arTemp[k++].replaceAll("-", "")).append("\n");
								flatFileExport.append("THIS_EXNO:").append(arTemp[k++].replaceAll("-", "")).append("\n");
								flatFileExport.append("UNIT_EXNO:").append(arTemp[k++].replaceAll("-", "")).append("\n");
								flatFileExport.append("UNIT_PKGU:").append(arTemp[k++]).append("\n");
								flatFileExport.append("UNIT_PKG:").append(arTemp[k++].replaceAll(",","")).append("\n");
								flatFileExport.append("}KCS_EXNO").append("\n");

								// Export License 전송로그 기록
								if (flatFileExport!=null) bkgCstmsKrSndLogDtlVO.setEdiSndMsg(flatFileExport.toString());
								//dbDao.addCUSMANExpSndDtlLog(bkgCstmsKrSndLogDtlVO);

								flatFileBody.append(flatFileExport);
							}
						} // END LOOP
					}

					// Container FlatFile 생성
					kor24CusmanVOs[i].setVvd(condVO.getVvd());
					cntrDatas = dbDao.makeCUSMANCntrFlatFile(kor24CusmanVOs[i]);
					if (cntrDatas!=null) {
						// LOOP
						for(int j=0; j < cntrDatas.length; j++) {
							flatFileCNTR.setLength(0);
							k=0;
							arTemp = cntrDatas[j].split("~",100);

							flatFileCNTR.append("{CNTR_INFO").append("\n");
							flatFileCNTR.append("CNTRNBR:").append(arTemp[k++]).append("\n");
							flatFileCNTR.append("LDMT:").append(arTemp[k++]).append("\n");
							flatFileCNTR.append("SEALNBR:").append(arTemp[k++]).append("\n");
							flatFileCNTR.append("CNTRTYPE:").append(arTemp[k++]).append("\n");
							flatFileCNTR.append("PKG:").append(arTemp[k++].replaceAll(",","")).append("\n");
							flatFileCNTR.append("PKGU:").append(arTemp[k++]).append("\n");
							flatFileCNTR.append("WGT:").append(arTemp[k++].replaceAll(",","")).append("\n");
							flatFileCNTR.append("WGTU:").append(arTemp[k++]).append("\n");
							flatFileCNTR.append("MEA:").append(arTemp[k++].replaceAll(",","")).append("\n");
							flatFileCNTR.append("MEAU:").append(arTemp[k++]).append("\n");
							// SEAL NUMBER 추가
							kor24CusmanVOs[i].setCntrNo(arTemp[0]);
							tempSealNumber = dbDao.makeCUSMANSealFlatFile(kor24CusmanVOs[i]);
							if (tempSealNumber!=null) {
								sealNumbers = tempSealNumber.split("~",100);
								flatFileCNTR.append("{CNTR_SEAL_NO").append("\n");
								flatFileCNTR.append("CNTR_SEAL:").append(sealNumbers[0]).append("\n");
								flatFileCNTR.append("}CNTR_SEAL_NO").append("\n");
								flatFileCNTR.append("{CNTR_SEAL_NO").append("\n");
								flatFileCNTR.append("CNTR_SEAL:").append(sealNumbers[1]).append("\n");
								flatFileCNTR.append("}CNTR_SEAL_NO").append("\n");
							}

							flatFileCNTR.append("}CNTR_INFO").append("\n");

							// Container 전송 로그 기록
							bkgCstmsKrSndLogDtlVO.setEdiSndMsg(flatFileCNTR.toString());
							//dbDao.addCUSMANCNTRSndDtlLog(bkgCstmsKrSndLogDtlVO);

							flatFileBody.append(flatFileCNTR);
						} // END LOOP
					}
				}
			} // end Not E type

			// CUSREP SEND LOG UPDATE (TEU, FEU CNT)
			bkgCstmsKrSndLogVO.setTeuCnt(String.valueOf(teuCnt));
			bkgCstmsKrSndLogVO.setFeuCnt(String.valueOf(feuCnt));
			//dbDao.modifyCUSREPSndLog(bkgCstmsKrSndLogVO);

			// FLATFILE 조립
			flatFile.append(flatFileBody);

			// flatFile 전송
			ediSendMessage(flatFile.toString(), "BKG.ALPSBKG_UBIZHJS_KRCUS_MNFT.IBMMQ.QUEUE");

			return flatFile.toString();

		}catch(EventException evx) {
			throw evx;
		}catch(DAOException de) {
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), de);
		}catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		}

	}

	/**
	 * Trans Amendment To PA
	 * @param AmendManifestTransmitVO amendManifestTransmitVO
	 * @return String
	 * @exception EventException
	 */
	public String transAmendManifest(AmendManifestTransmitVO amendManifestTransmitVO) throws EventException {
		// FlatFile
		StringBuffer flatFile = new StringBuffer();
		StringBuffer bfTemp = new StringBuffer();
		String[] arTemp = null;
		String fltFileRefNo = null;
		int k=0;

		// 파라메터 변환
		Kor24AmendManifestTransmitVO condVO = (Kor24AmendManifestTransmitVO)amendManifestTransmitVO;

		// FlatFile Header 용 객체
		Kor24MacamdVO kor24MacamdVO = new Kor24MacamdVO();
		// FlatFile 조회용 객체
		Kor24CorrVO corrVO = new Kor24CorrVO();

		// FlatFile 객체
		String flatFileHeader = null;
		String flatFileTemp   = null;
		StringBuffer flatFileBody = new StringBuffer();

		// Send Date
		String sndDt = null;
		// 정정 코드 배열
		String[] corrCodes = new String[5];
		String[] mdatas    = new String[5];
		// UNLocCd
		Kor24UNLocVO kor24UNLocVO = null;

		// 로그 저장용 객체
		BkgCstmsKrSndLogVO bkgCstmsKrSndLogVO = new BkgCstmsKrSndLogVO();
		BkgCstmsKrSndLogDtlVO bkgCstmsKrSndLogDtlVO = new BkgCstmsKrSndLogDtlVO();
		// 헤더 생성용 객체
		BookingUtil bookingUtil = new BookingUtil();
		String receiver = "";
		String subNo = null;

		try {

			// 수신처 판단
			if (condVO.getKtPa()!=null) {
				if (condVO.getKtPa().equals("20") || condVO.getKtPa().equals("020")) {
					receiver = "BPAED020";
				}else if (condVO.getKtPa().equals("30") || condVO.getKtPa().equals("31") || condVO.getKtPa().equals("030") || condVO.getKtPa().equals("031")) {
					receiver = "KMPAE030";
				}else if (condVO.getKtPa().equals("622")) {
					receiver = "KMPAE050";
				}
			}
			// FLATFILE 헤더 생성
			flatFileHeader = bookingUtil.searchCstmsEdiHeader("SMLM0001", receiver, "MACAMD");
			fltFileRefNo = flatFileHeader.substring(flatFileHeader.indexOf("BKC"));

			// flatFile 에 추가
			flatFile.append(flatFileHeader).append("\n");

			// UNLocCd
			kor24UNLocVO = dbDao.searchUNLocCd(condVO.getPolCd(), condVO.getPodCd());
			// 조회결과 없을경우 빈칸 처리
			if (kor24UNLocVO==null) {
				kor24UNLocVO = new Kor24UNLocVO();
				kor24UNLocVO.setPodUn("");
				kor24UNLocVO.setPolUn("");
			}

			kor24MacamdVO.setPolCd		(condVO.getPolCd()			);
			kor24MacamdVO.setPodCd		(condVO.getPodCd()			);
			kor24MacamdVO.setKtPa			(condVO.getKtPa()			);
			kor24MacamdVO.setIoBndCd		(condVO.getIoBndCd()		);
			kor24MacamdVO.setCallYear		(condVO.getCallYear()		);
			kor24MacamdVO.setCallKnt		(condVO.getCallKnt()		);
			kor24MacamdVO.setVslCallSgnCd	(condVO.getVslCallSgnCd()	);
			kor24MacamdVO.setMrnNo		(condVO.getMrnNo()			);
			kor24MacamdVO.setVvd			(condVO.getVvd()			);
			kor24MacamdVO.setVslNm		(condVO.getVslNm()			);
			kor24MacamdVO.setVslCntCd		(condVO.getVslCntCd()		);
			kor24MacamdVO.setBlNo			(condVO.getBlNo()			);
			kor24MacamdVO.setDchgMzdCd	(condVO.getDchgMzdCd()		);
			kor24MacamdVO.setIoTmlLocCd	(condVO.getIoTmlLocCd()		);
			kor24MacamdVO.setBdAreaCd		(condVO.getBdAreaCd()		);
			kor24MacamdVO.setTtlPckUtCd	(condVO.getTtlPckUtCd()		);
			kor24MacamdVO.setTtlWgt		(condVO.getTtlWgt()			);
			kor24MacamdVO.setTtlMeasUtCd	(condVO.getTtlMeasUtCd()	);
			kor24MacamdVO.setTtlMeasQty	(condVO.getTtlMeasQty()		);
			kor24MacamdVO.setUnPodCd		(kor24UNLocVO.getPodUn()		);
			kor24MacamdVO.setUnPolCd		(kor24UNLocVO.getPolUn()		);

			// 헤더 추가정보 생성
			// 공동 VVD 인 경우에는 Type 을 'E'로 설정
			if("E".equals(condVO.getNoneBlInType())){
				kor24MacamdVO.setCallYear("");
				kor24MacamdVO.setDchgMzdCd("");
			}
			flatFileHeader = dbDao.makeMACAMDFlatFile(kor24MacamdVO);
			arTemp = flatFileHeader.split("~", 100);
			k=0;

			bfTemp.setLength(0);

			bfTemp.append("MSG_CD:").append(arTemp[k++]).append("\n");
			bfTemp.append("MSG_NO:").append(arTemp[k++]).append("\n");
			bfTemp.append("SEND_DT:").append(arTemp[k++]).append("\n");
			bfTemp.append("PORT_CD:").append(arTemp[k++]).append("\n");
			bfTemp.append("MRN_NO:").append(arTemp[k++]).append("\n");
			bfTemp.append("SCAC:").append(arTemp[k++]).append("\n");
			bfTemp.append("CARRIER_CD:").append(arTemp[k++]).append("\n");
			bfTemp.append("VVD:").append(arTemp[k++]).append("\n");
			bfTemp.append("CALLSIGN:").append(arTemp[k++]).append("\n");
			bfTemp.append("VSL_NAME:").append(arTemp[k++]).append("\n");
			bfTemp.append("VSL_FLAG:").append(arTemp[k++]).append("\n");
			bfTemp.append("ETA:").append(arTemp[k++]).append("\n");
			bfTemp.append("IN_SEQ:").append(arTemp[k++]).append("\n");
			bfTemp.append("BL_NO:").append(arTemp[k++]).append("\n");
			bfTemp.append("MSN_NO:").append(arTemp[k++]).append("\n");
			bfTemp.append("CORR_CD:").append(arTemp[k++]).append("\n");
			bfTemp.append("BL_TP:").append(arTemp[k++]).append("\n");
			bfTemp.append("CGO_TP:").append(arTemp[k++]).append("\n");
			bfTemp.append("DISC_MD_CD:").append(arTemp[k++]).append("\n");
			bfTemp.append("BKG_POL:").append(arTemp[k++]).append("\n");
			bfTemp.append("BKG_POD:").append(arTemp[k++]).append("\n");
			bfTemp.append("QUAY_CD:").append(arTemp[k++]).append("\n");
			bfTemp.append("BOND_AREA_CODE:").append(arTemp[k++]).append("\n");
			bfTemp.append("PKG_CD:").append(arTemp[k++]).append("\n");
			bfTemp.append("CGO_CD:").append(arTemp[k++]).append("\n");
			bfTemp.append("CGO_DESC1:").append(arTemp[k++]).append("\n");
			bfTemp.append("CGO_DESC2:").append(arTemp[k++]).append("\n");
			bfTemp.append("IMO_CLASS1:").append(arTemp[k++]).append("\n");
			bfTemp.append("IMO_CLASS2:").append(arTemp[k++]).append("\n");
			bfTemp.append("IMO_CLASS3:").append(arTemp[k++]).append("\n");
			bfTemp.append("WGT:").append(arTemp[k++].replaceAll(",", "")).append("\n");
			bfTemp.append("MEA_TP:").append("").append("\n");
			k++; // MEA_TP Skip 처리
			bfTemp.append("MEA:").append(arTemp[k++].replaceAll(",", "")).append("\n");
			bfTemp.append("SHPR1:").append(arTemp[k++]).append("\n");
			bfTemp.append("SHPR2:").append(arTemp[k++]).append("\n");
			bfTemp.append("SHPR3:").append(arTemp[k++]).append("\n");
			bfTemp.append("SHPR4:").append(arTemp[k++]).append("\n");
			bfTemp.append("CNEE1:").append(arTemp[k++]).append("\n");
			bfTemp.append("CNEE2:").append(arTemp[k++]).append("\n");
			bfTemp.append("CNEE3:").append(arTemp[k++]).append("\n");
			bfTemp.append("CNEE4:").append(arTemp[k++]).append("\n");
			bfTemp.append("NTFY1:").append(arTemp[k++]).append("\n");
			bfTemp.append("NTFY2:").append(arTemp[k++]).append("\n");
			bfTemp.append("NTFY3:").append(arTemp[k++]).append("\n");
			bfTemp.append("NTFY4:").append(arTemp[k++]).append("\n");
			bfTemp.append("DISC_CO_CD:").append(condVO.getCstmsDchgCd()).append("\n");
			k++; // 하역회사 화면에서 넘어오는 값으로 대체
			bfTemp.append("GO_BIZ_NO:").append(arTemp[k++]).append("\n");

			flatFile.append(bfTemp);

			flatFileHeader = flatFile.toString();

			// SysDate 조회
			sndDt = dbDao.searchSysDate();

			// 일괄정정, 일괄삭제 MASTER LOG 테이블에 기록
			bkgCstmsKrSndLogVO.setIoBndCd		(condVO.getIoBndCd());
			bkgCstmsKrSndLogVO.setSndDt			(sndDt				);
			bkgCstmsKrSndLogVO.setOfcCd			(condVO.getOfcCd()	);
			bkgCstmsKrSndLogVO.setFltFileRefNo	(fltFileRefNo		);
			bkgCstmsKrSndLogVO.setUserId		(condVO.getUserId()	);
			bkgCstmsKrSndLogVO.setVvd			(condVO.getVvd()	);
			bkgCstmsKrSndLogVO.setPolCd			(condVO.getPolCd()	);
			// 로그에 POD 추가
			bkgCstmsKrSndLogVO.setPodCd			(condVO.getPodCd()	);
			bkgCstmsKrSndLogVO.setBlNo			(condVO.getBlNo()	);
			bkgCstmsKrSndLogVO.setKtPa			(condVO.getKtPa()	);
			// 공동 VVD 인 경우에는 Type 을 'E'로 설정
			if("E".equals(condVO.getNoneBlInType())){
				bkgCstmsKrSndLogVO.setInType(condVO.getNoneBlInType());
			}

			// 로그 기록
			dbDao.addMACAMDModiDelSndLog(bkgCstmsKrSndLogVO);

			// Detail 로그 및 FlatFile 내용 저장
			bkgCstmsKrSndLogDtlVO.setIoBndCd		(condVO.getIoBndCd());
			bkgCstmsKrSndLogDtlVO.setSndDt			(sndDt				);
			bkgCstmsKrSndLogDtlVO.setEdiSndMsg		(flatFileHeader		);
			bkgCstmsKrSndLogDtlVO.setOfcCd			(condVO.getOfcCd()	);
			bkgCstmsKrSndLogDtlVO.setFltFileRefNo	(fltFileRefNo		);
			bkgCstmsKrSndLogDtlVO.setUserId			(condVO.getUserId()	);
			// 로그 기록
			dbDao.addMACAMDModiDelSndDtlLog(bkgCstmsKrSndLogDtlVO);

			// 정정부호에 따른 처리 (ZD 가 존재하면 나머지 코드는 무시)
			if (condVO.getCancelFlg()!=null && condVO.getCancelFlg().equals("ZD")) {
				corrCodes[0] = condVO.getCancelFlg();		// ZD
				mdatas[0]    = "";
			}else {
				corrCodes[1] = condVO.getInChgMeth();		// ZH1
				corrCodes[2] = condVO.getInChgPort();		// ZH2
				corrCodes[3] = condVO.getInChgComp();		// ZH3
				corrCodes[4] = condVO.getInChgEta();		// AI
				mdatas[1]    = condVO.getDchgMzdCd();
				mdatas[2]	 = condVO.getIoTmlLocCd();
				mdatas[3]	 = condVO.getCstmsDchgCd();
				mdatas[4]    = condVO.getEtaDt().replaceAll("-","");
			}

			// LOOP
			for(int i=0; i < corrCodes.length; i++) {

				if (corrCodes[i]==null || corrCodes[i].trim().equals("")) continue;

				// makeCorrFlatFile
				corrVO.setCorrCd(corrCodes[i]);
				corrVO.setMdata1(mdatas[i]	 );
				flatFileTemp = dbDao.makeCorrFlatFile(corrVO);

				arTemp = flatFileTemp.split("~",100);
				k=0;
				bfTemp.setLength(0);

				bfTemp.append("{MODI_INFO").append("\n");
				bfTemp.append("MODI_CORR_CD:").append(arTemp[k++]).append("\n");
				bfTemp.append("MODI_VVD:").append(arTemp[k++]).append("\n");
				bfTemp.append("MODI_FTX1:").append(arTemp[k++].replace(",", "")).append("\n");
				bfTemp.append("MODI_FTX2:").append(arTemp[k++].replace(",", "")).append("\n");
				bfTemp.append("MODI_FTX3:").append(arTemp[k++].replace(",", "")).append("\n");
				bfTemp.append("MODI_FTX4:").append(arTemp[k++].replace(",", "")).append("\n");
				bfTemp.append("}MODI_INFO").append("\n");

				// 정정부호 전송 내역을 Detail LOG Table로 전송일 및 Flat File 내용 저장
				bkgCstmsKrSndLogDtlVO.setEdiSndMsg(bfTemp.toString());
				dbDao.addMACAMDModiCdSndDtlLog(bkgCstmsKrSndLogDtlVO);

				flatFileBody.append(bfTemp);
			}

			// FLATFILE 조립
			flatFile.append(flatFileBody);

			// flatFile 전송
			ediSendMessage(flatFile.toString(), "BKG.ALPSBKG_UBIZHJS_KRCUS_GENERAL.IBMMQ.QUEUE");


			// InBound 이고 ETA 항목 변경시 EDI 전송
			if (condVO.getIoBndCd().equals("I") && condVO.getInChgEta().equals("AI")) {

				flatFile.setLength(0);
				//if("".equals(kor24UNLocVO.getPodUn())|| kor24UNLocVO.getPodUn()== null){


				//}else {
				//	log.debug("발송 xml" + "KCS0004");
					flatFileHeader = bookingUtil.searchCstmsEdiHeader("SSSMLM0001", "KCS4G002", "IMFMOD");

				//}
				fltFileRefNo = flatFileHeader.substring(flatFileHeader.indexOf("BKC"));

				String userName = dbDao.searchComUser(condVO.getUserId());

				// SysDate 조회
				sndDt = dbDao.searchSysDate();

				// SubNo 생성
				Kor24MakeSubNoVO kor24MakeSubNoVO = new Kor24MakeSubNoVO();
				kor24MakeSubNoVO.setVvd		(condVO.getVvd()	);
				kor24MakeSubNoVO.setIoBndCd	(condVO.getIoBndCd());
				kor24MakeSubNoVO.setPolLoc	(condVO.getPolCd()	);
				kor24MakeSubNoVO.setPodLoc	(condVO.getPodCd()	);
				subNo = dbDao.searchMakeSubNo(kor24MakeSubNoVO);

				Kor24ImfmodVO kor24ImfmodVO = new Kor24ImfmodVO();
				ObjectCloner.build		(condVO, kor24ImfmodVO	);
				kor24ImfmodVO.setOfcCd		(condVO.getLoclCstmsCd());
				kor24ImfmodVO.setUserName		(userName		  		);
				kor24ImfmodVO.setPodCd		(kor24UNLocVO.getPodUn()	);
				kor24ImfmodVO.setPolCd		(kor24UNLocVO.getPolUn()	);
				kor24ImfmodVO.setKrCstmsCorrId("A"					);
				kor24ImfmodVO.setCorrRsn		("사무착오"				);
				kor24ImfmodVO.setSubNo		(subNo					);
				kor24ImfmodVO.setCntrTtlWgt	(condVO.getTtlWgt().replaceAll(",", ""));
				kor24ImfmodVO.setMeasQty		(condVO.getTtlMeasQty().replaceAll(",", ""));

				/*
				 * Revenue Empty이면서 kr_cstms_bl_tp_cd가   S(Simple) 이나 C(Consol) 이면 "E"로 변환
				 */
				if( checkRevenueEmpty(kor24ImfmodVO.getBkgCgoTpCd(), kor24ImfmodVO.getKrCstmsBlTpCd()) ) {
					kor24ImfmodVO.setKrCstmsBlTpCd("E");
				}

				flatFileTemp = dbDao.makeIMFMODBlFlatFile(kor24ImfmodVO);
				arTemp = flatFileTemp.split("~",100);
				k=0;
				bfTemp.setLength(0);

				bfTemp.append("MSG_CD:").append(arTemp[k++]).append("\n");
				bfTemp.append("MSG_NO:").append(arTemp[k++]).append("\n");
				bfTemp.append("SEND_DT:").append(arTemp[k++]).append("\n");
				bfTemp.append("PORT_CD:").append(arTemp[k++]).append("\n");
				bfTemp.append("DEPT_CD:").append(arTemp[k++]).append("\n");
				bfTemp.append("SENDER:").append(arTemp[k++]).append("\n");
				bfTemp.append("CORR_CD:").append(arTemp[k++]).append("\n");
				bfTemp.append("CORR_RS:").append(arTemp[k++]).append("\n");
				bfTemp.append("MSN_NO:").append(arTemp[k++]).append("\n");
				bfTemp.append("BL_NO:").append(arTemp[k++]).append("\n");
				bfTemp.append("BL_TP:").append(arTemp[k++]).append("\n");
				bfTemp.append("FW_CD:").append(arTemp[k++]).append("\n");
				bfTemp.append("CGO_TP:").append(arTemp[k++]).append("\n");
				bfTemp.append("BKG_POL:").append(arTemp[k++]).append("\n");
				bfTemp.append("BKG_POD:").append(arTemp[k++]).append("\n");
				bfTemp.append("BOND_AREA_CODE:").append(arTemp[k++]).append("\n");
				bfTemp.append("DISC_LOC:").append(arTemp[k++]).append("\n");
				bfTemp.append("PKG:").append(arTemp[k++].replaceAll(",","")).append("\n");
				bfTemp.append("PKG_CD:").append(arTemp[k++]).append("\n");
				bfTemp.append("CGO_DESC1:").append(arTemp[k++]).append("\n");
				bfTemp.append("CGO_DESC2:").append(arTemp[k++]).append("\n");
				bfTemp.append("IMO_CLASS1:").append(arTemp[k++]).append("\n");
				bfTemp.append("IMO_CLASS2:").append(arTemp[k++]).append("\n");
				bfTemp.append("IMO_CLASS3:").append(arTemp[k++]).append("\n");
				bfTemp.append("WGT:").append(arTemp[k++].replaceAll(",","")).append("\n");
				bfTemp.append("MEA:").append(arTemp[k++].replaceAll(",","")).append("\n");
				bfTemp.append("HBL_CNT:").append(arTemp[k++].replaceAll(",","")).append("\n");
				bfTemp.append("SHPR1:").append(arTemp[k++]).append("\n");
				bfTemp.append("SHPR2:").append(arTemp[k++]).append("\n");
				bfTemp.append("SHPR3:").append(arTemp[k++]).append("\n");
				bfTemp.append("SHPR4:").append(arTemp[k++]).append("\n");
				bfTemp.append("CNEE1:").append(arTemp[k++]).append("\n");
				bfTemp.append("CNEE2:").append(arTemp[k++]).append("\n");
				bfTemp.append("CNEE3:").append(arTemp[k++]).append("\n");
				bfTemp.append("CNEE4:").append(arTemp[k++]).append("\n");
				bfTemp.append("CBIZNO:").append(arTemp[k++]).append("\n");
				bfTemp.append("NTFY1:").append(arTemp[k++]).append("\n");
				bfTemp.append("NTFY2:").append(arTemp[k++]).append("\n");
				bfTemp.append("NTFY3:").append(arTemp[k++]).append("\n");
				bfTemp.append("NTFY4:").append(arTemp[k++]).append("\n");
				bfTemp.append("NBIZNO:").append(arTemp[k++]).append("\n");

				// FlatFile 합치기
				flatFile.append(flatFileHeader).append("\n");
				flatFile.append(bfTemp);

				// 전송 로그 기록
				bkgCstmsKrSndLogVO.setSndDt			(sndDt				);
				bkgCstmsKrSndLogVO.setOfcCd			(condVO.getOfcCd()	);
				bkgCstmsKrSndLogVO.setFltFileRefNo	(fltFileRefNo		);
				bkgCstmsKrSndLogVO.setUserId		(condVO.getUserId()	);
				bkgCstmsKrSndLogVO.setVvd			(condVO.getVvd()	);
				bkgCstmsKrSndLogVO.setPolCd			(condVO.getPolCd()	);
				bkgCstmsKrSndLogVO.setBlNo			(condVO.getBlNo()	);
				bkgCstmsKrSndLogVO.setSubNo			(subNo				);
				bkgCstmsKrSndLogVO.setCorrCd		("A"				);
				dbDao.addIMFMODSndLog(bkgCstmsKrSndLogVO);

				// 전송 세부 로그 기록
				bkgCstmsKrSndLogDtlVO.setSndDt			(sndDt						);
				bkgCstmsKrSndLogDtlVO.setOfcCd			(condVO.getOfcCd()			);
				bkgCstmsKrSndLogDtlVO.setFltFileRefNo	(fltFileRefNo				);
				bkgCstmsKrSndLogDtlVO.setUserId			(condVO.getUserId()			);
				bkgCstmsKrSndLogDtlVO.setEdiSndMsg		(flatFile.toString()		);
				dbDao.addIMFMODSndDtlLog(bkgCstmsKrSndLogDtlVO);

				// CORRECTION FLATFILE 만들기
				kor24ImfmodVO.setKrCstmsCorrId("AI");
				kor24ImfmodVO.setCorrRsn("01");
				kor24ImfmodVO.setPreCtnt1(condVO.getOldEtaDt());
				kor24ImfmodVO.setCrntCtnt1(condVO.getEtaDt());

				String imfmodBLCorrFlatFile = dbDao.makeIMFMODCorrFlatFile(kor24ImfmodVO);
				arTemp = imfmodBLCorrFlatFile.split("~", 100);

				k=0;
				bfTemp.setLength(0);

				bfTemp.append("{UNIT_MODI").append("\n");
				bfTemp.append("MODI_CORR_CD:").append(arTemp[k++]).append("\n");
				bfTemp.append("MODI_CORR_RSCD:").append(arTemp[k++]).append("\n");
				bfTemp.append("MODI_PRE_TXT1:").append(arTemp[k++].replace("-", "")).append("\n");
				bfTemp.append("MODI_PRE_TXT2:").append(arTemp[k++].replace("-", "")).append("\n");
				bfTemp.append("MODI_PRE_TXT3:").append(arTemp[k++].replace("-", "")).append("\n");
				bfTemp.append("MODI_PRE_TXT4:").append(arTemp[k++].replace("-", "")).append("\n");
				bfTemp.append("MODI_TXT1:").append(arTemp[k++].replace("-", "")).append("\n");
				bfTemp.append("MODI_TXT2:").append(arTemp[k++].replace("-", "")).append("\n");
				bfTemp.append("MODI_TXT3:").append(arTemp[k++].replace("-", "")).append("\n");
				bfTemp.append("MODI_TXT4:").append(arTemp[k++].replace("-", "")).append("\n");
				bfTemp.append("}UNIT_MODI").append("\n");

				imfmodBLCorrFlatFile = bfTemp.toString();

				flatFile.append(imfmodBLCorrFlatFile);

				// 전송 로그 기록
				bkgCstmsKrSndLogDtlVO.setEdiSndMsg(imfmodBLCorrFlatFile);
				dbDao.addIMFMODSndDtlLog(bkgCstmsKrSndLogDtlVO);

				// flatFile 전송
				ediSendMessage(flatFile.toString(), "BKG.ALPSBKG_UBIZHJS_KRCUS_GENERAL.IBMMQ.QUEUE");
			}

		}catch(DAOException de) {
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), de);
		}catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		}

		return subNo;
	}

	/**
	 * InBound Empty Amend 전송
	 * @param EmpAmdManiTransVO[] empAmdManiTransVOs
	 * @throws EventException
	 */
	public void transmitEmpAmdManifest(EmpAmdManiTransVO[] empAmdManiTransVOs) throws EventException {
		// 파라메터 변환
		Kor24EmpAmdManiTransVO[] kor24EmpAmdManiTransVOs = (Kor24EmpAmdManiTransVO[])empAmdManiTransVOs;

		// EDI 전송용 객체
		String sysdate = null;
		String maxSeq = null;
		SendFlatFileVO sendFlatFileVO = new SendFlatFileVO();
		BookingUtil utilCommand = new BookingUtil();
		FlatFileAckVO flatFileAckVO = null;

		// IMFMOD
		Kor24EmpImfmodVO kor24EmpImfmodVO = null;
		// MACAMD
		Kor24EmpMacamdVO kor24EmpMacamdVO = null;

		// FlatFile 전송용 객체
		StringBuffer flatFile = new StringBuffer();
		String flatFileHeader = null;
		String flatFileRefNo = null;
		String usrNm = null;

		// Log 저장용 객체
		Kor24AutoImfSndVO kor24AutoImfSndVO = new Kor24AutoImfSndVO();
		Kor24AutoImfSndDtlVO kor24AutoImfSndDtlVO = new Kor24AutoImfSndDtlVO();
		Kor24AutoMacSndVO kor24AutoMacSndVO = new Kor24AutoMacSndVO();
		Kor24AutoMacSndDtlVO kor24AutoMacSndDtlVO = new Kor24AutoMacSndDtlVO();

		try {

			// MAIN LOOP
			for(int i=0; i < kor24EmpAmdManiTransVOs.length; i++) {

				flatFile.setLength(0);

				// 헤더 생성

				flatFileHeader = utilCommand.searchCstmsEdiHeader("SSSMLM0001", "KCS4G002", "IMFMOD");
				flatFileRefNo = flatFileHeader.substring(flatFileHeader.indexOf("BKC"));

				// flatFile Header
				flatFile.append(flatFileHeader).append("\n");

				// 전송일시
				sysdate = dbDao.searchSysDate();

				// User name 조회
				usrNm = dbDao.searchComUser(kor24EmpAmdManiTransVOs[i].getUsrId());

				kor24EmpImfmodVO = new Kor24EmpImfmodVO();
				// Receiver 가 All 인 경우 처리
				if (kor24EmpAmdManiTransVOs[i].getReceiver().equals("0")) {
					// 파라메터 설정
					kor24EmpImfmodVO.setUsrNm			(usrNm									);
					kor24EmpImfmodVO.setSubNo			(kor24EmpAmdManiTransVOs[i].getSubNo()	);
					kor24EmpImfmodVO.setCstmsBlNo		(kor24EmpAmdManiTransVOs[i].getIbTsCblno());
					kor24EmpImfmodVO.setTrnsSeq		(kor24EmpAmdManiTransVOs[i].getIbTsSeq()	);
					kor24EmpImfmodVO.setDmstPortCd	(kor24EmpAmdManiTransVOs[i].getIbTsPort()	);
					kor24EmpImfmodVO.setBkgNo			(kor24EmpAmdManiTransVOs[i].getIbTsBkgno());
					kor24EmpImfmodVO.setCstmsDeclTpCd	(kor24EmpAmdManiTransVOs[i].getIbTsType()	);
					kor24EmpImfmodVO = dbDao.makeAutoIMFMODFlatFile(kor24EmpImfmodVO);

					flatFile.append(kor24EmpImfmodVO.getFlatData().replaceAll("~", "\n")).append("\n");


					// Send Log Seq 조회
					maxSeq = dbDao.searchMaxImfSndLogSeq(sysdate, kor24EmpAmdManiTransVOs[i].getOfcCd());

					// 마스터 로그테이블에 IMF 전송기록 저장
					kor24AutoImfSndVO.setSndDt		(sysdate								);
					kor24AutoImfSndVO.setOfcCd		(kor24EmpAmdManiTransVOs[i].getOfcCd()	);
					kor24AutoImfSndVO.setFltFileRefNo	(flatFileRefNo							);
					kor24AutoImfSndVO.setUsrId		(kor24EmpAmdManiTransVOs[i].getUsrId()	);
					kor24AutoImfSndVO.setVvdCd		(kor24EmpAmdManiTransVOs[i].getIbTsVvd()	);
					kor24AutoImfSndVO.setPolCd		(kor24EmpAmdManiTransVOs[i].getIbTsPort()	);
					kor24AutoImfSndVO.setBlNo			(kor24EmpAmdManiTransVOs[i].getIbTsCblno());
					kor24AutoImfSndVO.setSubNo		(kor24EmpAmdManiTransVOs[i].getSubNo()	);
					kor24AutoImfSndVO.setSndSeq		(maxSeq									);
					dbDao.addAutoIMFMODSndLog(kor24AutoImfSndVO);

					// 디테일 로그 테이블에 IMF 전송기록 저장
					ObjectCloner.build(kor24AutoImfSndVO, kor24AutoImfSndDtlVO);
					kor24AutoImfSndDtlVO.setEdiSndMsg(flatFile.toString());
					dbDao.addAutoIMFMODSndDtlLog(kor24AutoImfSndDtlVO);

					// IMFMOD CORRECTION FLATFILE 생성
					flatFile.append(dbDao.makeAutoIMFMODCorrFlatFile().replaceAll("~", "\n")).append("\n");

					// 디테일 로그 테이블에 추가 저장
					kor24AutoImfSndDtlVO.setEdiSndMsg(flatFile.toString());
					dbDao.addAutoIMFMODSndDtlLog(kor24AutoImfSndDtlVO);

					// EDI 전송
					sendFlatFileVO.setFlatFile(flatFile.toString());
					sendFlatFileVO.setQueueNm(SubSystemConfigFactory.get("BKG.ALPSBKG_UBIZHJS_KRCUS_GENERAL.IBMMQ.QUEUE"));
					flatFileAckVO = utilCommand.sendFlatFile(sendFlatFileVO);
					if (flatFileAckVO.getAckStsCd().equals("E"))
					  	throw new EventException(new ErrorHandler("BKG00205", new String[] {}).getMessage());
				}

				// RECEIVER 가 ALL 이거나 PA 인 경우 추가
				if (kor24EmpAmdManiTransVOs[i].getReceiver().equals("0") || kor24EmpAmdManiTransVOs[i].getReceiver().equals("1")) {
					flatFile.setLength(0);

					// 헤더 생성
					flatFileHeader = utilCommand.searchCstmsEdiHeader("SMLM0001", "BPAED020", "MACAMD");
					flatFileRefNo = flatFileHeader.substring(flatFileHeader.indexOf("BKC"));

					// flatFile Header
					flatFile.append(flatFileHeader).append("\n");

					// MACAMD FlatFile 생성
					kor24EmpMacamdVO = new Kor24EmpMacamdVO();
					kor24EmpMacamdVO.setCstmsBlNo		(kor24EmpAmdManiTransVOs[i].getIbTsCblno()	);
					kor24EmpMacamdVO.setTrnsSeq		(kor24EmpAmdManiTransVOs[i].getIbTsSeq()		);
					kor24EmpMacamdVO.setDmstPortCd	(kor24EmpAmdManiTransVOs[i].getIbTsPort()		);
					kor24EmpMacamdVO.setBkgNo			(kor24EmpAmdManiTransVOs[i].getIbTsBkgno()	);
					kor24EmpMacamdVO.setCstmsDeclTpCd	(kor24EmpAmdManiTransVOs[i].getIbTsType()		);
					kor24EmpMacamdVO = dbDao.makeAutoMACAMDFlatFile(kor24EmpMacamdVO);

					flatFile.append(kor24EmpMacamdVO.getEdiSndData().replaceAll("~", "\n")).append("\n");

					// 전송일시
					sysdate = dbDao.searchSysDate();

					// MaxSEQ 조회
					maxSeq = dbDao.searchMaxMacSndLogSeq(sysdate, kor24EmpAmdManiTransVOs[i].getOfcCd());

					// MACAMD 로그 기록
					kor24AutoMacSndVO.setSndDt		(sysdate								);
					kor24AutoMacSndVO.setOfcCd		(kor24EmpAmdManiTransVOs[i].getOfcCd()	);
					kor24AutoMacSndVO.setFltFileRefNo	(flatFileRefNo							);
					kor24AutoMacSndVO.setUsrId		(kor24EmpAmdManiTransVOs[i].getUsrId()	);
					kor24AutoMacSndVO.setVvdCd		(kor24EmpAmdManiTransVOs[i].getIbTsVvd()	);
					kor24AutoMacSndVO.setPolCd		(kor24EmpAmdManiTransVOs[i].getIbTsPort()	);
					kor24AutoMacSndVO.setBlNo			(kor24EmpAmdManiTransVOs[i].getIbTsCblno());
					kor24AutoMacSndVO.setSubNo		(kor24EmpAmdManiTransVOs[i].getSubNo()	);
					kor24AutoMacSndVO.setSndSeq		(maxSeq									);
					dbDao.addAutoMACAMDSndLog(kor24AutoMacSndVO);

					// 디테일 로그 테이블에 IMF 전송기록 저장
					ObjectCloner.build(kor24AutoMacSndVO, kor24AutoMacSndDtlVO);
					kor24AutoMacSndDtlVO.setEdiSndMsg(flatFile.toString());
					dbDao.addAutoMACAMDSndDtlLog(kor24AutoMacSndDtlVO);

					// IMFMOD CORRECTION FLATFILE 생성
					flatFile.append(dbDao.makeAutoMACAMDCorrFlatFile().replaceAll("~", "\n")).append("\n");

					// 디테일 로그 테이블에 추가 저장
					kor24AutoMacSndDtlVO.setEdiSndMsg(flatFile.toString());
					dbDao.addAutoMACAMDSndDtlLog(kor24AutoMacSndDtlVO);

					// EDI 전송
					sendFlatFileVO.setFlatFile(flatFile.toString());
					sendFlatFileVO.setQueueNm(SubSystemConfigFactory.get("BKG.ALPSBKG_UBIZHJS_KRCUS_GENERAL.IBMMQ.QUEUE"));
					flatFileAckVO = utilCommand.sendFlatFile(sendFlatFileVO);
					if (flatFileAckVO.getAckStsCd().equals("E"))
					  	throw new EventException(new ErrorHandler("BKG00205", new String[] {}).getMessage());

				}

			}

		}catch(DAOException de) {
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), de);
		}catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * 한국세관 Cancel per B/L EDI 전송
	 *
	 * @param CancelManifestTransmitVO cancelManifestTransmitVO
	 * @return String
	 * @throws EventException
	 */
	public String transCancelManifest(CancelManifestTransmitVO cancelManifestTransmitVO) throws EventException {
		// FlatFile
		StringBuffer flatFile = new StringBuffer();
		StringBuffer bfTemp = new StringBuffer();
		String[] arTemp = null;
		String fltFileRefNo = null;
		int k=0;
		// FlatFile Header 용 객체
		Kor24MacamdVO kor24MacamdVO = new Kor24MacamdVO();

		// FlatFile 객체
		String flatFileHeader = null;

		// Send Date
		String sndDt = null;
		// UNLocCd
		Kor24UNLocVO kor24UNLocVO = null;

		// 로그 저장용 객체
		BkgCstmsKrSndLogVO bkgCstmsKrSndLogVO = new BkgCstmsKrSndLogVO();
		BkgCstmsKrSndLogDtlVO bkgCstmsKrSndLogDtlVO = new BkgCstmsKrSndLogDtlVO();
		// 헤더 생성용 객체
		BookingUtil bookingUtil = new BookingUtil();
		String receiver = "";

		// 화면에서 넘어온 VO
		Kor24CancelManifestTransmitVO condVO = null;

		try {

			// 파라메터 변환
			condVO = (Kor24CancelManifestTransmitVO)cancelManifestTransmitVO;

			// 수신처 판단
			if (condVO.getKtPa()!=null) {
				if (condVO.getKtPa().equals("20") || condVO.getKtPa().equals("020")) {
					receiver = "BPAED020";
				}else if (condVO.getKtPa().equals("30") || condVO.getKtPa().equals("31") || condVO.getKtPa().equals("030") || condVO.getKtPa().equals("031")) {
					receiver = "KMPAE030";
				}else if (condVO.getKtPa().equals("622")) {
					receiver = "KMPAE050";
				}
			}
			// FLATFILE 헤더 생성
			flatFileHeader = bookingUtil.searchCstmsEdiHeader("SMLM0001", receiver, "MACAMD");
			fltFileRefNo = flatFileHeader.substring(flatFileHeader.indexOf("BKC"));

			// flatFile 에 추가
			flatFile.append(flatFileHeader).append("\n");

			// UNLocCd
			kor24UNLocVO = dbDao.searchUNLocCd(condVO.getPolCd(), condVO.getPodCd());
			// 조회결과 없을경우 빈칸 처리
			if (kor24UNLocVO==null) {
				kor24UNLocVO = new Kor24UNLocVO();
				kor24UNLocVO.setPodUn("");
				kor24UNLocVO.setPolUn("");
			}

			kor24MacamdVO.setKtPa			(condVO.getKtPa()			);
			kor24MacamdVO.setIoBndCd		(condVO.getIoBndCd()		);
			kor24MacamdVO.setCallYear		(condVO.getCallYear()		);
			kor24MacamdVO.setCallKnt		(condVO.getCallKnt()		);
			kor24MacamdVO.setVslCallSgnCd	(condVO.getVslCallSgnCd()	);
			kor24MacamdVO.setMrnNo		(condVO.getMrnNo()			);
			kor24MacamdVO.setVvd			(condVO.getVvd()			);
			kor24MacamdVO.setVslNm		(condVO.getVslNm()			);
			kor24MacamdVO.setVslCntCd		(condVO.getVslCntCd()		);
			kor24MacamdVO.setBlNo			(condVO.getBlNo()			);
			kor24MacamdVO.setDchgMzdCd	(condVO.getDchgMzdCd()		);
			kor24MacamdVO.setIoTmlLocCd	(condVO.getIoTmlLocCd()		);
			kor24MacamdVO.setBdAreaCd		(condVO.getBdAreaCd()		);
			kor24MacamdVO.setTtlPckUtCd	(condVO.getTtlPckUtCd()		);
			kor24MacamdVO.setTtlWgt		(condVO.getTtlWgt()			);
			kor24MacamdVO.setTtlMeasUtCd	(condVO.getTtlMeasUtCd()	);
			kor24MacamdVO.setTtlMeasQty	(condVO.getTtlMeasQty()		);
			kor24MacamdVO.setUnPodCd		(kor24UNLocVO.getPodUn()		);
			kor24MacamdVO.setUnPolCd		(kor24UNLocVO.getPolUn()		);
			// 헤더 추가정보 생성
			flatFileHeader = dbDao.makeMACAMDFlatFile(kor24MacamdVO);
			arTemp = flatFileHeader.split("~", 100);
			k=0;

			bfTemp.setLength(0);

			bfTemp.append("MSG_CD:").append(arTemp[k++]).append("\n");
			bfTemp.append("MSG_NO:").append(arTemp[k++]).append("\n");
			bfTemp.append("SEND_DT:").append(arTemp[k++]).append("\n");
			bfTemp.append("PORT_CD:").append(arTemp[k++]).append("\n");
			bfTemp.append("MRN_NO:").append(arTemp[k++]).append("\n");
			bfTemp.append("SCAC:").append(arTemp[k++]).append("\n");
			bfTemp.append("CARRIER_CD:").append(arTemp[k++]).append("\n");
			bfTemp.append("VVD:").append(arTemp[k++]).append("\n");
			bfTemp.append("CALLSIGN:").append(arTemp[k++]).append("\n");
			bfTemp.append("VSL_NAME:").append(arTemp[k++]).append("\n");
			bfTemp.append("VSL_FLAG:").append(arTemp[k++]).append("\n");
			bfTemp.append("ETA:").append(arTemp[k++]).append("\n");
			bfTemp.append("IN_SEQ:").append(arTemp[k++]).append("\n");
			bfTemp.append("BL_NO:").append(arTemp[k++]).append("\n");
			bfTemp.append("MSN_NO:").append(arTemp[k++]).append("\n");
			bfTemp.append("CORR_CD:F").append("\n");
			k++; // Correction Code 는 F로 셋팅하고 Skip 처리
			bfTemp.append("BL_TP:").append(arTemp[k++]).append("\n");
			bfTemp.append("CGO_TP:").append(arTemp[k++]).append("\n");
			bfTemp.append("DISC_MD_CD:").append(arTemp[k++]).append("\n");
			bfTemp.append("BKG_POL:").append(arTemp[k++]).append("\n");
			bfTemp.append("BKG_POD:").append(arTemp[k++]).append("\n");
			bfTemp.append("QUAY_CD:").append(arTemp[k++]).append("\n");
			bfTemp.append("BOND_AREA_CODE:").append(arTemp[k++]).append("\n");
			bfTemp.append("PKG_CD:").append(arTemp[k++]).append("\n");
			bfTemp.append("CGO_CD:").append(arTemp[k++]).append("\n");
			bfTemp.append("CGO_DESC1:").append(arTemp[k++]).append("\n");
			bfTemp.append("CGO_DESC2:").append(arTemp[k++]).append("\n");
			bfTemp.append("IMO_CLASS1:").append(arTemp[k++]).append("\n");
			bfTemp.append("IMO_CLASS2:").append(arTemp[k++]).append("\n");
			bfTemp.append("IMO_CLASS3:").append(arTemp[k++]).append("\n");
			bfTemp.append("WGT:").append(arTemp[k++].replaceAll(",", "")).append("\n");
			bfTemp.append("MEA_TP:").append("").append("\n");
			k++; // MEA_TP Skip 처리
			bfTemp.append("MEA:").append(arTemp[k++].replaceAll(",", "")).append("\n");
			bfTemp.append("SHPR1:").append(arTemp[k++]).append("\n");
			bfTemp.append("SHPR2:").append(arTemp[k++]).append("\n");
			bfTemp.append("SHPR3:").append(arTemp[k++]).append("\n");
			bfTemp.append("SHPR4:").append(arTemp[k++]).append("\n");
			bfTemp.append("CNEE1:").append(arTemp[k++]).append("\n");
			bfTemp.append("CNEE2:").append(arTemp[k++]).append("\n");
			bfTemp.append("CNEE3:").append(arTemp[k++]).append("\n");
			bfTemp.append("CNEE4:").append(arTemp[k++]).append("\n");
			bfTemp.append("NTFY1:").append(arTemp[k++]).append("\n");
			bfTemp.append("NTFY2:").append(arTemp[k++]).append("\n");
			bfTemp.append("NTFY3:").append(arTemp[k++]).append("\n");
			bfTemp.append("NTFY4:").append(arTemp[k++]).append("\n");
			bfTemp.append("DISC_CO_CD:").append(arTemp[k++]).append("\n");
			bfTemp.append("GO_BIZ_NO:").append(arTemp[k++]).append("\n");

			flatFile.append(bfTemp);

			flatFileHeader = flatFile.toString();

			// SysDate 조회
			sndDt = dbDao.searchSysDate();

			// 일괄정정, 일괄삭제 MASTER LOG 테이블에 기록
			bkgCstmsKrSndLogVO.setIoBndCd		(condVO.getIoBndCd());
			bkgCstmsKrSndLogVO.setSndDt			(sndDt				);
			bkgCstmsKrSndLogVO.setOfcCd			(condVO.getOfcCd()	);
			bkgCstmsKrSndLogVO.setFltFileRefNo	(fltFileRefNo		);
			bkgCstmsKrSndLogVO.setUserId		(condVO.getUserId()	);
			bkgCstmsKrSndLogVO.setVvd			(condVO.getVvd()	);
			bkgCstmsKrSndLogVO.setPolCd			(condVO.getPolCd()	);
			bkgCstmsKrSndLogVO.setBlNo			(condVO.getBlNo()	);
			bkgCstmsKrSndLogVO.setKtPa			(condVO.getKtPa()	);
			// 로그 기록
			dbDao.addMACAMDModiDelSndLog(bkgCstmsKrSndLogVO);

			// Detail 로그 및 FlatFile 내용 저장
			bkgCstmsKrSndLogDtlVO.setIoBndCd		(condVO.getIoBndCd());
			bkgCstmsKrSndLogDtlVO.setSndDt			(sndDt				);
			bkgCstmsKrSndLogDtlVO.setEdiSndMsg		(flatFileHeader		);
			bkgCstmsKrSndLogDtlVO.setOfcCd			(condVO.getOfcCd()	);
			bkgCstmsKrSndLogDtlVO.setFltFileRefNo	(fltFileRefNo		);
			bkgCstmsKrSndLogDtlVO.setUserId			(condVO.getUserId()	);
			// 로그 기록
			dbDao.addMACAMDModiDelSndDtlLog(bkgCstmsKrSndLogDtlVO);

			// flatFile 전송
			ediSendMessage(flatFile.toString(), "BKG.ALPSBKG_UBIZHJS_KRCUS_GENERAL.IBMMQ.QUEUE");

		}catch(DAOException de) {
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), de);
		}catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		}

		return null;
	}

	/**
	 * Revenue Empty이면서 kr_cstms_bl_tp_cd가   S(Simple) 이나 C(Consol) 이면 true 아니면 false
	 * @param bkgCgoTpCd
	 * @param krCstmsBlTpCd
	 * @return boolean
	 */
	private boolean checkRevenueEmpty(String bkgCgoTpCd, String krCstmsBlTpCd) {
		boolean retVal = false;
		if("R".equals(bkgCgoTpCd)) {
			if("S".equals(krCstmsBlTpCd) || "C".equals(krCstmsBlTpCd)) {
				retVal = true;
			}
		}
		return retVal;
	}

	/**
	 * EDI 전송 처리부
	 * @param String flatFile
	 * @param String queueName
	 * @exception EventException
	 */
	private void ediSendMessage(String flatFile, String queueName) throws EventException {
		try {
		  // FlatFile 이 빈 경우 SKIP 처리
			if (flatFile!=null && flatFile.trim().length() > 1) {
			  SendFlatFileVO sendFlatFileVO = new SendFlatFileVO();
			  sendFlatFileVO.setFlatFile(flatFile);
			  sendFlatFileVO.setQueueNm(SubSystemConfigFactory.get(queueName));
			  BookingUtil utilCommand = new BookingUtil();
			  FlatFileAckVO flatFileAckVO = utilCommand.sendFlatFile(sendFlatFileVO);
			  if (flatFileAckVO.getAckStsCd().equals("E"))
			  	throw new EventException(new ErrorHandler("BKG00205", new String[] {}).getMessage());
			}
		}catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		}
	}

}
