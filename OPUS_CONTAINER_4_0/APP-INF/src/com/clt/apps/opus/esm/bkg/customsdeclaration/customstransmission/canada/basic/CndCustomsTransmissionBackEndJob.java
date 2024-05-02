/*========================================================= 
 *Copyright(c) 2009 CyberLogitec
 *@FileName : CndCustomsTransmissionBackEndJob.java
 *@FileTitle : CndCustomsTransmissionBackEndJob
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.29
 *@LastModifier : 김민정
 *@LastVersion : 1.0
 * 2009.04.29 김민정
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.canada.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

import com.clt.apps.opus.bcm.sup.valuemanage.util.ConstantMgr;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookinghistorymgt.basic.BookingHistoryMgtBC;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookinghistorymgt.basic.BookingHistoryMgtBCImpl;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.FlatFileAckVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.SendFlatFileVO;
import com.clt.apps.opus.esm.bkg.common.CountryCode;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customscommonmgt.basic.CustomsCommonMgtBC;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customscommonmgt.basic.CustomsCommonMgtBCImpl;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.canada.integration.CndCustomsTransmissionDBDAO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.canada.vo.BlInfoForFlatFileVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.canada.vo.CmInfoForFlatFileVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.canada.vo.CndCstmsManifestAmendmentVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.canada.vo.CndCstmsManifestVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.canada.vo.CndVesselArrivalTransmitVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.canada.vo.CntrInfoForFlatFileVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.canada.vo.CstmsSendLogVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.canada.vo.SealNoInfoForFlatFileVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.canada.vo.StiDetailCndVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.ManifestTransmitVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.canada.basic.CndManifestListDownloadBC;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.canada.basic.CndManifestListDownloadBCImpl;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.canada.vo.CndManifestModificationVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.util.object.ObjectCloner;
import com.clt.framework.core.config.SubSystemConfigFactory;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.backend.BackEndCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.BkgCstmsAdvEdiBlRspnVO;
import com.clt.syscommon.common.table.BkgCstmsAdvSndLogDtlVO;
import com.clt.syscommon.common.table.BkgCstmsAdvSndLogVO;
import com.clt.syscommon.common.table.BkgDocProcSkdVO;
import com.clt.syscommon.common.table.BkgNtcHisVO;

/**
 * OPUS-CustomsDeclaration Business Logic Basic Command implementation<br>
 * - OPUS-CustomsDeclaration에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Kim Min Jeong
 * @see ESM_BKG_0016EventResponse,CndBackEndBCImpl 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class CndCustomsTransmissionBackEndJob extends BackEndCommandSupport {
	private static final long serialVersionUID = -3034414164961318353L;
	private ManifestTransmitVO manifestTransmitVO;
	private SignOnUserAccount account;
	private StiDetailCndVO[] detailVOs;
	private String pgmNo = "";

	/**
	 * 다운로드 할 데이터 세팅
	 *
	 * @param manifestListDetailVOs
	 * @param account
	 */
	public void setManifestTransmitVO(ManifestTransmitVO manifestTransmitVO, SignOnUserAccount account) {
		this.manifestTransmitVO = manifestTransmitVO;
		this.account = account;
//		this.pgmNo = manifestTransmitVO.getPgmNo();
	}

	/**
	 * BackEndCommand Start
	 *
	 * @return DBRowSet
	 * @throws Exception
	 */
	public String doStart() throws Exception {

		//Vessel Stowage Plan Transmit
		if (pgmNo.startsWith("ESM_BKG_1023"))
		{
			CndCustomsTransmissionBCImpl command = new CndCustomsTransmissionBCImpl();
			command.transmitStowageManifest(detailVOs);

		} else{

			CndCustomsTransmissionDBDAO dbDao = new CndCustomsTransmissionDBDAO();
			/***********************************************************
			 * FlatFile 생성
			 ***********************************************************/
			List<String> listFlatFile = this.transmitManifest(dbDao);
			/***********************************************************
			 * EDI 전송 START
			 ***********************************************************/
			for (String flatFile : listFlatFile) {
				if (flatFile.startsWith("$$$MSGSTART:")) {
					SendFlatFileVO sendFlatFileVO = new SendFlatFileVO();
					sendFlatFileVO.setFlatFile(flatFile);
					sendFlatFileVO.setQueueNm(SubSystemConfigFactory.get("BKG.OPUSBKG_UBIZCOM_CANCUS.IBMMQ.QUEUE"));
					BookingUtil utilCommand = new BookingUtil();
					FlatFileAckVO flatFileAckVO = utilCommand.sendFlatFile(sendFlatFileVO);
					if (flatFileAckVO.getAckStsCd().equals("E")) throw new EventException(new ErrorHandler("BKG00205", new String[]{}).getMessage());
				} else {
					log.error("\n\n==================== [Incorrect Flatfile] ====================" +
								"\nCndCustomsTransmissionBackEndJob > doStart\n" +
								"\n--------------------------------------------------------------\n" +
								flatFile +
								"\n==============================================================\n");
				}
			}
		}
		return "Success";
	}

	/**
	 * FlatFile 생성
	 * @param dbDao CndCustomsTransmissionDBDAO
	 * @return List<String>
	 * @throws DAOException
	 * @throws EventException
	 */
	private List<String> transmitManifest(CndCustomsTransmissionDBDAO dbDao) throws DAOException, EventException {
		CndCstmsManifestVO cndCstmsManifestVO = (CndCstmsManifestVO) manifestTransmitVO;
		/***************************************************
		 * CRN NO.가 없으면 에러처리
		 ***************************************************/
		CndVesselArrivalTransmitVO cndVesselArrivalTransmitVO = new CndVesselArrivalTransmitVO();
		cndVesselArrivalTransmitVO.setBlNo(cndCstmsManifestVO.getBlNos()[0]);
		cndVesselArrivalTransmitVO = dbDao.searchVesselArrival(cndVesselArrivalTransmitVO);
		if (cndVesselArrivalTransmitVO == null) throw new EventException(new ErrorHandler("BKG06090").getMessage());
		/***************************************************
		 * 결과 FlatFile A6A, S10, E10 3가지가 있을수 있으므로 List로 선언
		 ***************************************************/
		List<String> listFlatFile = null;
		log.debug(cndCstmsManifestVO.getIbflag());
		if (!"Terminal".equals(cndCstmsManifestVO.getIbflag())) {
			/***********************************************
			 * BKG_CSTMS_ADV_BL 수정하기 위한 정보세팅
			 ***********************************************/
			CndManifestListDownloadBC downBC = new CndManifestListDownloadBCImpl();
			CndManifestModificationVO[] cndManifestModificationVOs = new CndManifestModificationVO[cndCstmsManifestVO.getBlNos().length];
			for (int i = 0; i < cndCstmsManifestVO.getBlNos().length; i++) {
				cndManifestModificationVOs[i] = new CndManifestModificationVO();
				cndManifestModificationVOs[i].setBlNo(cndCstmsManifestVO.getBlNos()[i]);
				cndManifestModificationVOs[i].setCstmsTrsmStsCd("00"); // 최초전송
				/***********************************************************
				 * A6A:Manifest, S10:HB/L Manifest, E10:Empty B/L<br>
				 * cndManifestModificationVOs[i].setCstmsMfTpCd는 필요없음<br>
				 * downBC.manageManifest의 쿼리에서 구함<br>
				 **********************************************************/
			}
			downBC.manageManifest(cndManifestModificationVOs, account);
			/***************************************************
			 * BKG_CSTMS_ADV_BL 의 MI OR AI SEND DATE와 <br>
			 * 로그테이블의 SEND DATE에 같은 값을 넣기 위해<br>
			 ***************************************************/
			cndCstmsManifestVO.setMiSndDt(cndManifestModificationVOs[0].getEdiSndDt());

		} else {
			CndManifestListDownloadBC downBC = new CndManifestListDownloadBCImpl();
			CndManifestModificationVO[] cndManifestModificationVOs = new CndManifestModificationVO[1];
			cndManifestModificationVOs[0] = new CndManifestModificationVO();
			cndManifestModificationVOs[0].setPgmNo("Terminal_Trans");
			downBC.manageManifest(cndManifestModificationVOs, account);
			cndCstmsManifestVO.setMiSndDt(cndManifestModificationVOs[0].getEdiSndDt());
		}
		/***********************************************************
		 * 전송 FlatFile 만들어서 로그테이블에 등록
		 **********************************************************/
		listFlatFile = this.makeCndCstmsMfFlatFile(dbDao, cndCstmsManifestVO, account);

		return listFlatFile;
	}

	/**
	 * FlatFile 만들고 로그테이블 저장
	 * @param dbDao CndCustomsTransmissionDBDAO
	 * @param cndCstmsManifestVO 전송정보
	 * @param account 세션정보
	 * @return List<String>
	 * @throws DAOException
	 * @throws EventException
	 */
	public List<String> makeCndCstmsMfFlatFile(CndCustomsTransmissionDBDAO dbDao, CndCstmsManifestVO cndCstmsManifestVO, SignOnUserAccount account) throws DAOException, EventException {
		this.account = account;
		this.manifestTransmitVO = cndCstmsManifestVO;
		/***********************************************************
		 * FlatFile
		 ***********************************************************/
		List<String> listFlatFile = new ArrayList<String>();
		StringBuilder flatFileM = new StringBuilder(); // Master B/L
		StringBuilder flatFileH = new StringBuilder(); // House B/L
		StringBuilder flatFileE = new StringBuilder(); // Empty B/L
		int iMblHeader = -1;
		int iHblHeader = -1;
		int iEblHeader = -1;
		// AI와 MI의 FlatFile 만드는걸 같이 쓰려고 하다보니 VO에 값을 넣어야함.
		CndCstmsManifestAmendmentVO cstmsManifestAmendmentVO = new CndCstmsManifestAmendmentVO();
		cstmsManifestAmendmentVO.setMiSndDt(cndCstmsManifestVO.getMiSndDt());
		BlInfoForFlatFileVO blInfo = null;
		// 헤더를 위해
		BookingUtil utilBC = new BookingUtil();
		String crrBatNoA6A = "";
		String crrBatNoS10 = "";
		String crrBatNoE10 = "";
		List<BkgCstmsAdvEdiBlRspnVO> blRspnVOs = new ArrayList<BkgCstmsAdvEdiBlRspnVO>();
		List<BkgNtcHisVO> hisVOs = new ArrayList<BkgNtcHisVO>();
		String sPodCd = "";

		for (int bl = 0; bl < cndCstmsManifestVO.getBlNos().length; bl++) {
			cstmsManifestAmendmentVO.setBlNo(cndCstmsManifestVO.getBlNos()[bl]);
			// 추가 2010.11.30 Termial EDI/ Transmit 기능구분 Ibflag  By KIM HYUNHWA [CHM-201007146-01]
			cstmsManifestAmendmentVO.setIbflag(cndCstmsManifestVO.getIbflag());
			/************************************************
			 * BL 조회
			 ***********************************************/
			blInfo = dbDao.searchBlInfoForFlatFile(cstmsManifestAmendmentVO);

			if (bl == 0 && "Terminal".equals(cndCstmsManifestVO.getIbflag())) {
				sPodCd = blInfo.getBlpod();
				cndCstmsManifestVO.setMiSndDt(dbDao.searchLocalTime(sPodCd));
			}

			// 추가 2009.09.25 CC_CUSTOFCO, CC_CUSTOFCD
			if ("".equals(blInfo.getCustofcd()) && blInfo.getHubLocCd().startsWith("CA")) {
				blInfo.setCustofcd(blInfo.getCustofco());
			}
			if ("".equals(blInfo.getHubLocCd())) {
				throw new EventException(new ErrorHandler("BKG08062", new String[]{"HUB"}).getMessage());
			}

			if (blInfo.getHubLocCd().startsWith("CA") &&
					"".equals(blInfo.getCustofco()) && "".equals(blInfo.getCustofcd())) {
				String[] arrErrCd = new String[3];
				arrErrCd[0] = blInfo.getBlnbr();
				arrErrCd[1] = blInfo.getBlpod();
				arrErrCd[2] = blInfo.getDelcode();
				throw new EventException(new ErrorHandler("BKG06040", arrErrCd).getMessage());
			}
			if ("A6A".equals(blInfo.getCstmsMfTpCd())) {
				if (iMblHeader == -1) {
					// Header는 한번만
					iMblHeader = bl;
					if ("Terminal".equals(cndCstmsManifestVO.getIbflag())) {
						if ("CAVAN,CAPRR,CAMTR,CAHAL".indexOf(blInfo.getBlpod()) >= 0) {
//							flatFileM.append(utilBC.searchCstmsEdiHeader(ConstantMgr.getCompanyCode()+"_311", blInfo.getBlpod() + "_A6A", "311")).append("\n");
							flatFileM.append(utilBC.searchCstmsEdiHeaderNew("CA_" + blInfo.getBlpod() + "_A6A")).append("\n");
						}
					} else {
//						flatFileM.append(utilBC.searchCstmsEdiHeader("CK92756", "RCCECECPP", "311A6A")).append("\n");
						flatFileM.append(utilBC.searchCstmsEdiHeaderNew("CA_311A6A")).append("\n");
					}
					crrBatNoA6A = flatFileM.toString().substring(62, 77);
				}
				// A6A FlatFile 만들기
				flatFileM.append(this.makeFlatFile(dbDao, cstmsManifestAmendmentVO, blInfo));

				// BL별 CrrBatNo 셋팅
				blRspnVOs.add(this.setBkgCstmsAdvEdiBlRspnVO(cstmsManifestAmendmentVO.getBlNo(), crrBatNoA6A));

				// Terminal 전송이력
				if ("Terminal".equals(cndCstmsManifestVO.getIbflag())) {
					hisVOs.add(this.setBkgNtcHisVO(blInfo.getBkgNo(), crrBatNoA6A, cndCstmsManifestVO.getMiSndDt()));
				}
			} else if ("S10".equals(blInfo.getCstmsMfTpCd())) {
				// NYK에는 S10, E10은 Terminal 전송을 하지 않는다.
				if (!"Terminal".equals(cndCstmsManifestVO.getIbflag())) {
					if (iHblHeader == -1) {
						iHblHeader = bl;
//						if ("Terminal".equals(cndCstmsManifestVO.getIbflag())) {
//							if ("CAVAN,CAPRR,CAMTR,CAHAL".indexOf(blInfo.getBlpod()) >= 0) {
//								flatFileH.append(utilBC.searchCstmsEdiHeader(ConstantMgr.getCompanyCode()+"_311", blInfo.getBlpod() + "_S10", "311")).append("\n");
//							}
//						} else {
//							flatFileH.append(utilBC.searchCstmsEdiHeader("CK92756", "RCCECECPP", "311S10")).append("\n");
//						}
						flatFileH.append(utilBC.searchCstmsEdiHeaderNew("CA_311S10")).append("\n");
						crrBatNoS10 = flatFileH.toString().substring(62, 77);
					}
					// S10 FlatFile 만들기
					flatFileH.append(this.makeFlatFile(dbDao, cstmsManifestAmendmentVO, blInfo));

					// BL별 CrrBatNo 셋팅
					blRspnVOs.add(this.setBkgCstmsAdvEdiBlRspnVO(cstmsManifestAmendmentVO.getBlNo(), crrBatNoS10));

					// Terminal 전송이력
//					if ("Terminal".equals(cndCstmsManifestVO.getIbflag())) {
//						hisVOs.add(this.setBkgNtcHisVO(blInfo.getBkgNo(), crrBatNoS10, cndCstmsManifestVO.getMiSndDt()));
//					}
				}
			} else if ("E10".equals(blInfo.getCstmsMfTpCd())) {
				// NYK에는 S10, E10은 Terminal 전송을 하지 않는다.
				if (iEblHeader == -1) {
					iEblHeader = bl;
//					flatFileE.append(utilBC.searchCstmsEdiHeader(ConstantMgr.getCompanyCode()+"_311", "CANCUS_E10", "311")).append("\n");
					flatFileE.append(utilBC.searchCstmsEdiHeaderNew("CA_311E10")).append("\n");
					crrBatNoE10 = flatFileE.toString().substring(62, 77);
				}
				// E10 FlatFile 만들기
				flatFileE.append(this.makeFlatFile(dbDao, cstmsManifestAmendmentVO, blInfo));

				// BL별 CrrBatNo 셋팅
				blRspnVOs.add(this.setBkgCstmsAdvEdiBlRspnVO(cstmsManifestAmendmentVO.getBlNo(), crrBatNoE10));

//				// Terminal 전송이력
//				if ("Terminal".equals(cndCstmsManifestVO.getIbflag())) {
//					hisVOs.add(this.setBkgNtcHisVO(blInfo.getBkgNo(), crrBatNoE10, cndCstmsManifestVO.getMiSndDt()));
//				}
			}

			if (bl == cndCstmsManifestVO.getBlNos().length -1) {
				if (iMblHeader > -1) {
					if (flatFileM.toString().startsWith("$$$MSGSTART:")) {
						blInfo.setCstmsMfTpCd("A6A");
						/***********************************************************
						 * 로그남기기
						 ***********************************************************/
						this.makeManifestLog(dbDao, blInfo, cstmsManifestAmendmentVO.getMiSndDt(), flatFileM.toString(), account, cndCstmsManifestVO.getIbflag());
						listFlatFile.add(flatFileM.toString());
					} else {
						log.error("\n\n==================== [Incorrect Flatfile] ====================" +
									"\nCndCustomsTransmissionBackEndJob > makeCndCstmsMfFlatFile(A6A)" +
									"\n--------------------------------------------------------------\n" +
									flatFileM.toString() +
									"\n==============================================================\n");
					}
				}
				if (iHblHeader > -1) {
					if (flatFileH.toString().startsWith("$$$MSGSTART:")) {
						blInfo.setCstmsMfTpCd("S10");
						/***********************************************************
						 * 로그남기기
						 ***********************************************************/
						this.makeManifestLog(dbDao, blInfo, cstmsManifestAmendmentVO.getMiSndDt(), flatFileH.toString(), account, cndCstmsManifestVO.getIbflag());
						listFlatFile.add(flatFileH.toString());
					} else {
						log.error("\n\n==================== [Incorrect Flatfile] ====================" +
									"\nCndCustomsTransmissionBackEndJob > makeCndCstmsMfFlatFile(S10)" +
									"\n--------------------------------------------------------------\n" +
									flatFileH.toString() +
									"\n==============================================================\n");
					}
				}
				if (iEblHeader > -1) {
					if (flatFileE.toString().startsWith("$$$MSGSTART:")) {
						blInfo.setCstmsMfTpCd("E10");
						/***********************************************************
						 * 로그남기기
						 ***********************************************************/
						this.makeManifestLog(dbDao, blInfo, cstmsManifestAmendmentVO.getMiSndDt(), flatFileE.toString(), account, cndCstmsManifestVO.getIbflag());
						listFlatFile.add(flatFileE.toString());
					} else {
						log.error("\n\n==================== [Incorrect Flatfile] ====================" +
									"\nCndCustomsTransmissionBackEndJob > makeCndCstmsMfFlatFile(E10)" +
									"\n--------------------------------------------------------------\n" +
									flatFileE.toString() +
									"\n==============================================================\n");
					}
				}
			}
		}
		// BL별 CrrBatNo 등록
		dbDao.addBkgCstmsAdvEdiBlRspn(blRspnVOs);
		if ("Terminal".equals(cndCstmsManifestVO.getIbflag())) {
			// Terminal 전송의 경우 BKG_NTC_HIS 테이블에 넣기
			BookingHistoryMgtBC bookingHistoryMgtBC = new BookingHistoryMgtBCImpl();
			bookingHistoryMgtBC.createBkgNtcHis(hisVOs, account.getUsr_id());
		}
		return listFlatFile;
	}

	/**
	 * FlatFile 만들기
	 *
	 * @param dbDao CndCustomsTransmissionDBDAO
	 * @param cstmsManifestAmendmentVO 전송정보
	 * @param blInfo BL정보
	 * @return String
	 * @throws DAOException
	 */
	public String makeFlatFile(CndCustomsTransmissionDBDAO dbDao, CndCstmsManifestAmendmentVO cstmsManifestAmendmentVO,
			BlInfoForFlatFileVO blInfo) throws DAOException, EventException {
		// FlatFile
		StringBuilder flatFile = new StringBuilder();
		CustomsCommonMgtBC comBc = new CustomsCommonMgtBCImpl();
		/************************************************
		 * BL 조회(AI와 같이 사용하기 위해서)
		 ***********************************************/
		flatFile.append("{ST").append("\n");
		flatFile.append("CC_BLSEQ:").append(blInfo.getBlseq()).append("\n");
		flatFile.append("CC_BLTRANS:").append(blInfo.getBltrans()).append("\n");
		flatFile.append("CC_STATUS:").append(blInfo.getStatus()).append("\n");
		flatFile.append("CC_BLREPNO:").append("9165").append("\n");
		flatFile.append("CC_BLNBR:").append(blInfo.getBlnbr()).append("\n");
		flatFile.append("CC_BLREFNO:").append(blInfo.getBlrefno()).append("\n");
		flatFile.append("CC_VCREPNO:").append(blInfo.getVcrepno()).append("\n");
		flatFile.append("CC_SMTRIND:").append(blInfo.getSmtrind()).append("\n");
		flatFile.append("CC_VSLNAME:").append(blInfo.getVslname()).append("\n");
		flatFile.append("CC_VVD:").append(blInfo.getVvd()).append("\n");
		// 추가
		flatFile.append("CC_CON_VVD:").append(comBc.searchConVvd(blInfo.getVvd(), blInfo.getBlpod(), "I")).append("\n");
		flatFile.append("CC_TERMINAL:").append(blInfo.getTerminal()).append("\n");
		flatFile.append("CC_FPOA:").append(blInfo.getFpoa()).append("\n");
		flatFile.append("CC_BLPOL:").append(blInfo.getBlpol()).append("\n");
		flatFile.append("CC_POLETD:").append(blInfo.getPoletd()).append("\n");
		flatFile.append("CC_BLPOD:").append(blInfo.getBlpod()).append("\n");
		flatFile.append("CC_POLETL:").append(blInfo.getPoletl()).append("\n");
		flatFile.append("CC_TO_ORDER:").append(blInfo.getToOrder()).append("\n");
		flatFile.append("CC_SHPRNAME:").append(blInfo.getShprname()).append("\n");
		flatFile.append("CC_SHPRADDR:").append(blInfo.getShpraddr()).append("\n");
		flatFile.append("CC_SHPRCITY:").append(blInfo.getShprcity()).append("\n");
		flatFile.append("CC_SHPRSTAT:").append(blInfo.getShprstat()).append("\n");
		flatFile.append("CC_SHPRCTRY:").append(blInfo.getShprctry()).append("\n");
		flatFile.append("CC_SHPRZIP:").append(blInfo.getShprzip()).append("\n");
		// 추가
		flatFile.append("CC_SHPRTEL:").append("").append("\n");
		flatFile.append("CC_CNEENAME:").append(blInfo.getCneename()).append("\n");
		flatFile.append("CC_CNEEADDR:").append(blInfo.getCneeaddr()).append("\n");
		flatFile.append("CC_CNEECITY:").append(blInfo.getCneecity()).append("\n");
		flatFile.append("CC_CNEESTAT:").append(blInfo.getCneestat()).append("\n");
		flatFile.append("CC_CNEECTRY:").append(blInfo.getCneectry()).append("\n");
		flatFile.append("CC_CNEEZIP:").append(blInfo.getCneezip()).append("\n");
		// 추가
		flatFile.append("CC_CNEETEL:").append("").append("\n");
		flatFile.append("CC_NTFYNAME:").append(blInfo.getNtfyname()).append("\n");
		flatFile.append("CC_NTFYADDR:").append(blInfo.getNtfyaddr()).append("\n");
		flatFile.append("CC_NTFYCITY:").append(blInfo.getNtfycity()).append("\n");
		flatFile.append("CC_NTFYSTAT:").append(blInfo.getNtfystat()).append("\n");
		flatFile.append("CC_NTFYCTRY:").append(blInfo.getNtfyctry()).append("\n");
		flatFile.append("CC_NTFYZIP:").append(blInfo.getNtfyzip()).append("\n");
		// 추가
		flatFile.append("CC_NTFYTEL:").append("").append("\n");
		// Delivery Location 추가
		flatFile.append("CC_DELLYARDCD:").append(blInfo.getDellyardcd()).append("\n");
		flatFile.append("CC_DELLNAME:").append(blInfo.getDellname()).append("\n");
		flatFile.append("CC_DELLNAME2:").append(blInfo.getDellname2()).append("\n");
		flatFile.append("CC_DELLADDR:").append(blInfo.getDelladdr()).append("\n");
		flatFile.append("CC_DELLCITY:").append(blInfo.getDellcity()).append("\n");
		flatFile.append("CC_DELLSTAT:").append(blInfo.getDellstat()).append("\n");
		flatFile.append("CC_DELLCTRY:").append(blInfo.getDellctry()).append("\n");
		flatFile.append("CC_DELLZIP:").append(blInfo.getDellzip()).append("\n");
		// Delivery Location 추가
		flatFile.append("CC_PORNAME:").append(blInfo.getPorname()).append("\n");
		flatFile.append("CC_POLNAME:").append(blInfo.getPolname()).append("\n");
		flatFile.append("CC_PORCODE:").append(blInfo.getPorcode()).append("\n");
		flatFile.append("CC_PORSTAT:").append(blInfo.getPorstat()).append("\n");
		flatFile.append("CC_CUSTOFCO:").append(blInfo.getCustofco()).append("\n");
		flatFile.append("CC_CUSTOFCD:").append(blInfo.getCustofcd()).append("\n");
		flatFile.append("CC_DELNAME:").append(blInfo.getDelname()).append("\n");
		flatFile.append("CC_LOCGOOD:").append(blInfo.getLocgood()).append("\n");
		flatFile.append("CC_DELCODE:").append(blInfo.getDelcode()).append("\n");
		flatFile.append("CC_DELSTAT:").append(blInfo.getDelstat()).append("\n");
		flatFile.append("CC_COMMENT:").append(blInfo.getComment1()).append("\n");
		/************************************************
		 * Container 조회
		 ***********************************************/
		List<CntrInfoForFlatFileVO> cntrList = dbDao.searchCntrInfoForFlatFile(cstmsManifestAmendmentVO);
		for (int i = 0; i < cntrList.size(); i++) {
			flatFile.append("{CC_CNTR").append("\n");
			flatFile.append("CC_RDTERM:").append(cntrList.get(i).getRdterm()).append("\n");
			flatFile.append("CC_CNTRTS:").append(cntrList.get(i).getCntrts()).append("\n");
			flatFile.append("CC_CNTRNBR:").append(cntrList.get(i).getCntrnbr()).append("\n");
			flatFile.append("CC_LDMT:").append(cntrList.get(i).getLdmt()).append("\n");
			flatFile.append("CC_SEAL:");
			/**********************************************************
			 * SEAL NO 조회
			 *********************************************************/
			cstmsManifestAmendmentVO.setCntrNo(cntrList.get(i).getCntrnbr());
			cstmsManifestAmendmentVO.setMblNo(blInfo.getBlnbr());
			List<SealNoInfoForFlatFileVO> sealList = dbDao.searchSealNoInfoForFlatFile(cstmsManifestAmendmentVO);
			if (sealList.size() > 0) {
				flatFile.append(sealList.get(0).getSealNo()).append("\n");
			} else {
				flatFile.append("\n");
			}
			for (int j = 0; j < sealList.size(); j++) {
				flatFile.append("{CNTR_SEAL_NO").append("\n");
				flatFile.append("SEAL_NO:").append(sealList.get(j).getSealNo()).append("\n");
				flatFile.append("}CNTR_SEAL_NO").append("\n");
			}
			/**********************************************************
			 * CM 조회
			 *********************************************************/
			List<CmInfoForFlatFileVO> cmList = dbDao.searchCmInfoForFlatFile(cstmsManifestAmendmentVO);
			for (int j = 0; j < cmList.size(); j++) {
				flatFile.append("{CC_CM").append("\n");
				flatFile.append("CC_CMCODE:").append(cmList.get(j).getCmcode()).append("\n");
				flatFile.append("CC_CMPKG:").append(cmList.get(j).getCmpkg()).append("\n");
				flatFile.append("CC_CMPKGU:").append(cmList.get(j).getCmpkgu()).append("\n");
				flatFile.append("CC_CMWGT:").append(cmList.get(j).getCmwgt()).append("\n");
				flatFile.append("CC_CMWGTU:").append(cmList.get(j).getCmwgtu()).append("\n");
				flatFile.append("CC_CMDESC:").append(cmList.get(j).getCmdesc()).append("\n");
				flatFile.append("CC_CMUNNO:").append(cmList.get(j).getCmunno()).append("\n");
				flatFile.append("}CC_CM").append("\n");
			}
			flatFile.append("}CC_CNTR").append("\n");
		}
		flatFile.append("}SE").append("\n");

		/***********************************************************
		 * 세관 전송 후 부킹정보가 변경되면 세관에 재전송하기 위해 DocProcAIFlag = 'N'으로 등록한다.<br>
		 * 그 후 세관화면에서 전송을 완료하면 DocProcAIFlag='Y' 로 처리한다.
		 ***********************************************************/
		// HOSTORY BCImpl - mbl, hbl ai flag update
		BookingHistoryMgtBC bkgHisBC = new BookingHistoryMgtBCImpl();
		BkgDocProcSkdVO bkgDocProcSkdVO = new BkgDocProcSkdVO();
		bkgDocProcSkdVO.setBkgDocProcTpCd("CA_SND");
		String mfNo = "X"; // 'X'이면 마스터, 아니면 하우스.
		String blNo = blInfo.getBlnbr();

		// HOUSE
		if (!"".equals(blInfo.getBlrefno())) {
			mfNo = blInfo.getBkgNo();
			blNo = blInfo.getBlrefno().substring(4);
		}

		bkgDocProcSkdVO.setBkgNo(blNo);
		bkgDocProcSkdVO.setUpdUsrId(account.getUsr_id());
		bkgHisBC.manageDocProcAIFlag(mfNo, bkgDocProcSkdVO);

		return flatFile.toString();
	}

	/**
	 * Manifest 로그남기기
	 *
	 * @param dbDao CndCustomsTransmissionDBDAO
	 * @param blInfo BL정보
	 * @param sToday 현재일
	 * @param flatFile flatFile
	 * @param account 세션정보
	 * @param terminal terminal유무
	 * @throws DAOException
	 */
	public void makeManifestLog(CndCustomsTransmissionDBDAO dbDao, BlInfoForFlatFileVO blInfo, String sToday,
			String flatFile, SignOnUserAccount account, String terminal) throws DAOException {
		CstmsSendLogVO logVO = new CstmsSendLogVO();
		logVO.setCntCd(CountryCode.CA);
		logVO.setIoBndCd("I");
		logVO.setSndDt(sToday);
		if (!"Terminal".equals(terminal)) {
			logVO.setTrsmMsgTpId(blInfo.getCstmsMfTpCd());
		} else {
			logVO.setTrsmMsgTpId("PA");
		}
		logVO.setVslCd(blInfo.getVslCd());
		logVO.setSkdVoyNo(blInfo.getSkdVoyNo());
		logVO.setSkdDirCd(blInfo.getSkdDirCd());
		logVO.setPolCd(blInfo.getBlpol());
		logVO.setPodCd(blInfo.getBlpod());
		// 전송헤더 15자리(BKC......)
		logVO.setCrrBatNo(flatFile.substring(62, 77));
		logVO.setDeltFlg("N");
		logVO.setSndUsrId(account.getUsr_id());
		logVO.setSndUsrOfcCd(account.getOfc_cd());
		logVO.setCreUsrId(account.getUsr_id());
		logVO.setEdiSndLogCtnt(flatFile);
		this.writeCstmsSendLog(dbDao, logVO);
	}

	/**
	 * 세관 신고 전송 기록
	 *
	 * @param dbDao CndCustomsTransmissionDBDAO
	 * @param cstmsSendLogVO 전송정보
	 * @throws DAOException
	 */
	public void writeCstmsSendLog(CndCustomsTransmissionDBDAO dbDao, CstmsSendLogVO cstmsSendLogVO) throws DAOException {
		List<BkgCstmsAdvSndLogVO> listLog = new ArrayList<BkgCstmsAdvSndLogVO>();
		List<BkgCstmsAdvSndLogDtlVO> listLogDtl = new ArrayList<BkgCstmsAdvSndLogDtlVO>();
		// 로그VO
		BkgCstmsAdvSndLogVO logVO = new BkgCstmsAdvSndLogVO();
		ObjectCloner.build(cstmsSendLogVO, logVO);
		// 일련번호(상세로그VO에 셋팅하기 위해 변수선언)
		String sLogSeq = dbDao.searchMaxSndLogSeq(logVO);
		logVO.setHisSeq(sLogSeq);
		listLog.add(logVO);
		// 상세로그 Enter 기준으로 String 잘라 멀티 insert
		StringTokenizer st = new StringTokenizer(cstmsSendLogVO.getEdiSndLogCtnt(), "\n");
		String[] arrFlatFile = new String[st.countTokens()];
		for (int i = 0; i < arrFlatFile.length; i++) {
			BkgCstmsAdvSndLogDtlVO dtlVO = new BkgCstmsAdvSndLogDtlVO();
			dtlVO.setCntCd(logVO.getCntCd());
			dtlVO.setIoBndCd(logVO.getIoBndCd());
			dtlVO.setSndDt(logVO.getSndDt());
			dtlVO.setHisSeq(logVO.getHisSeq());
			dtlVO.setDtlSeq(String.valueOf(i + 1));
			dtlVO.setEdiSndLogCtnt(st.nextToken());
			dtlVO.setCreUsrId(logVO.getCreUsrId());
			listLogDtl.add(dtlVO);
		}
		// Send Log 테이블
		dbDao.addBkgCstmsAdvSndLog(listLog);
		// Send Log Detail 테이블
		dbDao.addBkgCstmsAdvSndLogDtl(listLogDtl);
	}

	/**
	 * BkgCstmsAdvEdiBlRspnVO 세팅
	 *
	 * @param blNo
	 * @param crrBatNo
	 * @return
	 */
	private BkgCstmsAdvEdiBlRspnVO setBkgCstmsAdvEdiBlRspnVO(String blNo, String crrBatNo) {
		BkgCstmsAdvEdiBlRspnVO bkgCstmsAdvEdiBlRspnVO = new BkgCstmsAdvEdiBlRspnVO();
		bkgCstmsAdvEdiBlRspnVO.setCntCd(CountryCode.CA);
		bkgCstmsAdvEdiBlRspnVO.setBlNo(blNo);
		bkgCstmsAdvEdiBlRspnVO.setCrrBatNo(crrBatNo);
		bkgCstmsAdvEdiBlRspnVO.setCreUsrId(account.getUsr_id());
		return bkgCstmsAdvEdiBlRspnVO;
	}

	/**
	 * BkgNtcHisVO 세팅
	 *
	 * @param bkgNo
	 * @param crrBatNo
	 * @param sndDt
	 * @return
	 */
	private BkgNtcHisVO setBkgNtcHisVO(String bkgNo, String crrBatNo, String sndDt) {
		BkgNtcHisVO bkgNtcHisVO = new BkgNtcHisVO();
		bkgNtcHisVO.setBkgNo(bkgNo);
		bkgNtcHisVO.setNtcViaCd("E");
		bkgNtcHisVO.setNtcKndCd("CA");
		bkgNtcHisVO.setSndOfcCd(account.getOfc_cd());
		bkgNtcHisVO.setSndUsrId(account.getUsr_id());
		bkgNtcHisVO.setEdiId(crrBatNo);
		bkgNtcHisVO.setSndId(ConstantMgr.getCompanyCode()+"_311");
		bkgNtcHisVO.setSndDt(sndDt);
		bkgNtcHisVO.setSndRqstDt(sndDt);
		bkgNtcHisVO.setCreUsrId(account.getUsr_id());
		bkgNtcHisVO.setUpdUsrId(account.getUsr_id());
		CndCstmsManifestVO cndCstmsManifestVO = (CndCstmsManifestVO) manifestTransmitVO;
		bkgNtcHisVO.setDiffRmk(cndCstmsManifestVO.getTerminalAutoSnd());
		return bkgNtcHisVO;
	}

	/**
	 * 페이지 넘버 셋팅
	 *
	 * @param String pgmNo
	 * @return void
	 */
	public void setPgmNo(String pgmNo) {
		this.pgmNo = pgmNo;
	}

	/**
	 * 1023 화면을 위한 VO 세팅
	 *
	 * @param StiDetailCndVO[] detailVOs
	 * @return void
	 */
	public void setStiDetailCndVO(StiDetailCndVO[] detailVOs){
		if(detailVOs != null){
			StiDetailCndVO[] tmpVOs = Arrays.copyOf(detailVOs, detailVOs.length);
			this.detailVOs = tmpVOs;
		}
	}
}
