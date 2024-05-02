/*=========================================================
 *Copyright(c) SMlines. All Rights Reserved.
 *@FileName :  CndExpCustomsTransmissionBCImpl.java
 *@FileTitle : CndExpCustomsTransmissionBCImpl
 *Open Issues :
 *Change history :
 *@LastModifyDate :
 *@LastModifier :
 *@LastVersion :
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.basic;

import java.util.ArrayList; 
import java.util.List;
import java.util.StringTokenizer;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.FlatFileAckVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.SendFlatFileVO;
import com.hanjin.apps.alps.esm.bkg.common.CountryCode;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customscommonmgt.basic.CustomsCommonMgtBC;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customscommonmgt.basic.CustomsCommonMgtBCImpl;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customscommonmgt.vo.CstmsEmlNtfcVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.integration.CndExpCustomsTransmissionDBDAO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.vo.BayPlanCntrDetailCndVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.vo.BayPlanCntrListConCndVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.vo.BayPlanPolDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.vo.BlInfoForFlatFileVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.vo.CndCstmsBlByKeyVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.vo.CndCstmsManifestAmendmentCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.vo.CndCstmsManifestAmendmentVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.vo.CndCstmsManifestCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.vo.CndCstmsManifestVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.vo.CndCstmsRcvHisListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.vo.CndCstmsRcvLogDtlCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.vo.CndCstmsRcvLogVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.vo.CndCstmsSndHisListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.vo.CndCstmsSndHisVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.vo.CndCstmsSndLogDtlCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.vo.CndCstmsSndLogDtlVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.vo.CndCstmsTrsmRsltListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.vo.CndCstmsTrsmRsltVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.vo.CndVesselArrivalTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.vo.CstmsSendLogVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.vo.SendDetailLogCndVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.vo.SendLogDetailCndVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.vo.StiCondListCndVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.vo.StiDetailCndVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.vo.VesselEtaCondCndVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.vo.VesselEtaInfoCndVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.CstmsManifestAmendmentCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.CstmsManifestAmendmentVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.CstmsManifestCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.CstmsManifestVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.CstmsRcvHisListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.CstmsRcvHisVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.CstmsRcvLogDtlCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.CstmsRcvLogDtlVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.CstmsRcvLogVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.CstmsSndLogDtlCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.CstmsTrsmRsltListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.CstmsTrsmRsltVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.ManifestTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.RcvMsgVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.StowageManifestCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.VesselArrivalTransmitVO;
import com.hanjin.framework.component.backend.core.BackEndJobManager;
import com.hanjin.framework.component.javamail.TemplateMail;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.util.object.ObjectCloner;
import com.hanjin.framework.core.config.SubSystemConfigFactory;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.BkgCstmsAdvEdiBlRspnVO;
import com.hanjin.syscommon.common.table.BkgCstmsAdvRcvLogDtlVO;
import com.hanjin.syscommon.common.table.BkgCstmsAdvRcvLogVO;
import com.hanjin.syscommon.common.table.BkgCstmsAdvSndLogVO;
import com.hanjin.syscommon.common.table.BkgCstmsCndVslVO;
import com.hanjin.syscommon.common.table.MdmVslCntrVO;


/**
 * - CustomsDeclarationCanadaCes Business Logic Command implementation<br>
 * - CustomsDeclarationCanadaCes handling business logic<br>
 *
 * @author
 * @see Related DAO class
 * @since J2EE 1.6
 */
public class CndExpCustomsTransmissionBCImpl extends BasicCommandSupport implements CndExpCustomsTransmissionBC {
	// Database Access Object
	private transient CndExpCustomsTransmissionDBDAO dbDao = null;

	/**
	 * CndExpCustomsTransmissionBCImpl 객체 생성<br>
	 * CndExpCustomsTransmissionDBDAO 생성한다.<br>
	 */
	public CndExpCustomsTransmissionBCImpl() {
		dbDao = new CndExpCustomsTransmissionDBDAO();
	}

	/**
	 * 입출항 선박 신고된 적하목록 현황 조회
	 * 
	 * @param CstmsManifestCondVO cstmsManifestCondVO
	 * @return List<CstmsManifestVO>
	 * @exception EventException
	 */
	public List<CstmsManifestVO> searchManifestList(CstmsManifestCondVO cstmsManifestCondVO) throws EventException {
		try {
			return dbDao.searchCndCstmsManifest((CndCstmsManifestCondVO) cstmsManifestCondVO);

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);

		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * 세관 신고 대상 상세List를 조회한다.
	 *
	 * @param CstmsManifestCondVO cstmsManifestCondVO
	 * @return List<CstmsManifestVO>
	 * @throws EventException
	 */
	public List<CstmsManifestVO> searchManifestDtlList(CstmsManifestCondVO cstmsManifestCondVO) throws EventException {
		try {
			return dbDao.searchCndCstmsManifestDtl((CndCstmsManifestCondVO) cstmsManifestCondVO);

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);

		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Vessel Arrival 신고하기 위해 FlatFile을 생성한다.
	 *
	 * @param VesselArrivalTransmitVO vesselArrivalTransmitVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @throws EventException
	 */
	public String transmitVesselArrival(VesselArrivalTransmitVO vesselArrivalTransmitVO, SignOnUserAccount account) throws EventException {
		CndVesselArrivalTransmitVO condVO = (CndVesselArrivalTransmitVO) vesselArrivalTransmitVO;

		try {
			// ACI Vessel Information
			CndVesselArrivalTransmitVO vslVO = dbDao.searchVesselDeparture(condVO); 
			if (!"".equals(vslVO.getDtNullChk())) {
				// ACI Vessel Information 화면 (UI_BKG-0016) 에 data 가 빠져있는 경우 에러처리
				String[] changeStr = { vslVO.getDtNullChk() };
				throw new EventException(new ErrorHandler("BKG00976", changeStr).getMessage());
			}
			if (!"".equals(vslVO.getDtDiffChk())) {
				// 만료일자가 Last Foreign Port Departure Date 보다 이전인 경우 에러처리
				String[] changeStr = { vslVO.getDtDiffChk() };
				throw new EventException(new ErrorHandler("BKG00977", changeStr).getMessage());
			}
			// 해당 VVD의 Vessel Arrival이 신고된 적이 있고 997 ACK를 받았으면 04 (Update) 그 외는 00 (Original)로 Status 결정
			if ("D".equals(condVO.getDelFlag())) {
				vslVO.setStatus("03");
			} else {
				if ("A".equals(vslVO.getCndAckRspnCd())) {
					vslVO.setStatus("04");
				} else {
					vslVO.setStatus("00");
				}
			}
			// MAX POL POD
			CndVesselArrivalTransmitVO polVO = dbDao.searchPolPodForDeparture(condVO);
			// PORT List
			List<CndVesselArrivalTransmitVO> portList = dbDao.searchVesselPort(condVO);
			/***********************************************************
			 * flatFile 만들기
			 ***********************************************************/
			String flatFile = makeCndVesselArrivalFlatFile(condVO, vslVO, polVO, portList);
			/***********************************************************
			 * 로그VO 세팅
			 ***********************************************************/
			CstmsSendLogVO logVO = new CstmsSendLogVO();
			logVO.setCntCd(CountryCode.CA);
			logVO.setIoBndCd("O");
			logVO.setSndDt(condVO.getVslDepRptSndDt());
			if ("Terminal".equals(condVO.getIbflag())) {
				logVO.setTrsmMsgTpId("A6PA");
			} else {
				logVO.setTrsmMsgTpId("A6");
			}
			logVO.setTrsmMsgTpId("A6");
			logVO.setVslCd(condVO.getVslCd());
			logVO.setSkdVoyNo(condVO.getSkdVoyNo());
			logVO.setSkdDirCd(condVO.getSkdDirCd());
//			logVO.setPolCd(polVO.getPolCd()); // 헤깔림
			logVO.setPodCd(condVO.getPodCd());
			logVO.setSndUsrId(account.getUsr_id());
			logVO.setSndUsrOfcCd(account.getOfc_cd());
			logVO.setCreUsrId(account.getUsr_id());
			logVO.setEdiSndLogCtnt(flatFile);
			logVO.setCrrBatNo(flatFile.substring(62, 77));
			/***********************************************************
			 * 로그DB Insert
			 ***********************************************************/
			CndExpCustomsTransmissionBackEndJob cndBackEndJob = new CndExpCustomsTransmissionBackEndJob();
			cndBackEndJob.writeCstmsSendLog(dbDao, logVO);

			return flatFile;

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);

		} catch (EventException ex) {
			throw ex;

		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Vessel Departure(수입 시 - Arrival 신고) 신고하기 위해 FlatFile을 생성한다.
	 *
	 * @param VesselArrivalTransmitVO vesselArrivalTransmitVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @throws EventException
	 */
	public String transmitVesselDeparture(VesselArrivalTransmitVO vesselArrivalTransmitVO, SignOnUserAccount account) throws EventException {
		CndVesselArrivalTransmitVO condVO = (CndVesselArrivalTransmitVO) vesselArrivalTransmitVO;

		try {
			// ACI Vessel Information
			CndVesselArrivalTransmitVO vslVO = dbDao.searchVesselDeparture(condVO);
			if (!"".equals(vslVO.getDtNullChk())) {
				// ACI Vessel Information 화면 (UI_BKG-0016) 에 data 가 빠져있는 경우 에러처리
				String[] changeStr = { vslVO.getDtNullChk() };
				throw new EventException(new ErrorHandler("BKG00976", changeStr).getMessage());
			}
			if (!"".equals(vslVO.getDtDiffChk())) {
				// 만료일자가 Last Foreign Port Departure Date 보다 이전인 경우 에러처리
				String[] changeStr = { vslVO.getDtDiffChk() };
				throw new EventException(new ErrorHandler("BKG00977", changeStr).getMessage());
			}
			// 해당 VVD의 Vessel Arrival이 신고된 적이 있고 997 ACK를 받았으면 04 (Update) 그 외는 00 (Original)로 Status 결정
			if ("D".equals(condVO.getDelFlag())) {
				vslVO.setStatus("03");
			} else {
				if ("A".equals(vslVO.getCndAckRspnCd())) {
					vslVO.setStatus("04");
				} else {
					vslVO.setStatus("00");
				}
			}
			// MAX POL POD
			CndVesselArrivalTransmitVO polVO = dbDao.searchPolPodForDeparture(condVO);
			// PORT List
			List<CndVesselArrivalTransmitVO> portList = dbDao.searchVesselPort(condVO);
			/***********************************************************
			 * flatFile 만들기
			 ***********************************************************/
			String flatFile = makeCndVesselDepartureFlatFile(condVO, vslVO, polVO, portList);
			/***********************************************************
			 * 로그VO 세팅
			 ***********************************************************/
			CstmsSendLogVO logVO = new CstmsSendLogVO();
			logVO.setCntCd(CountryCode.CA);
			logVO.setIoBndCd("O");
			logVO.setSndDt(condVO.getVslDepRptSndDt());
			if ("Terminal".equals(condVO.getIbflag())) {
				logVO.setTrsmMsgTpId("A6PA");
			} else {
				logVO.setTrsmMsgTpId("A6");
			}
			logVO.setTrsmMsgTpId("A6");
			logVO.setVslCd(condVO.getVslCd());
			logVO.setSkdVoyNo(condVO.getSkdVoyNo());
			logVO.setSkdDirCd(condVO.getSkdDirCd());
//			logVO.setPolCd(polVO.getPolCd()); // 헤깔림
			logVO.setPodCd(condVO.getPodCd());
			logVO.setSndUsrId(account.getUsr_id());
			logVO.setSndUsrOfcCd(account.getOfc_cd());
			logVO.setCreUsrId(account.getUsr_id());
			logVO.setEdiSndLogCtnt(flatFile);
			logVO.setCrrBatNo(flatFile.substring(62, 77));
			/***********************************************************
			 * 로그DB Insert
			 ***********************************************************/
			CndExpCustomsTransmissionBackEndJob cndBackEndJob = new CndExpCustomsTransmissionBackEndJob();
			cndBackEndJob.writeCstmsSendLog(dbDao, logVO);

			return flatFile;

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);

		} catch (EventException ex) {
			throw ex;

		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		}
	}	
	/**
	 * Vessel Actual Departure 신고하기 위해 FlatFile을 생성한다.
	 *
	 * @param VesselArrivalTransmitVO vesselArrivalTransmitVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @throws EventException
	 */
	public String transmitActualVesselDeparture(VesselArrivalTransmitVO vesselArrivalTransmitVO, SignOnUserAccount account) throws EventException {
		CndVesselArrivalTransmitVO condVO = (CndVesselArrivalTransmitVO) vesselArrivalTransmitVO;

		try {
			// ACI Vessel Information
			CndVesselArrivalTransmitVO vslVO = dbDao.searchVesselDeparture(condVO);
			if (!"".equals(vslVO.getDtNullChk())) {
				// ACI Vessel Information 화면 (UI_BKG-0016) 에 data 가 빠져있는 경우 에러처리
				String[] changeStr = { vslVO.getDtNullChk() };
				throw new EventException(new ErrorHandler("BKG00976", changeStr).getMessage());
			}
			if (!"".equals(vslVO.getDtDiffChk())) {
				// 만료일자가 Last Foreign Port Departure Date 보다 이전인 경우 에러처리
				String[] changeStr = { vslVO.getDtDiffChk() };
				throw new EventException(new ErrorHandler("BKG00977", changeStr).getMessage());
			}
			/***********************************************************
			 * flatFile 만들기
			 ***********************************************************/
			String flatFile = makeCndActualVesselDepartureFlatFile(vslVO);
			/***********************************************************
			 * 로그VO 세팅
			 ***********************************************************/
			CstmsSendLogVO logVO = new CstmsSendLogVO();
			logVO.setCntCd(CountryCode.CA);
			logVO.setIoBndCd("O");
			logVO.setSndDt(condVO.getVslDepRptSndDt());
			logVO.setTrsmMsgTpId("ATA");
			logVO.setVslCd(condVO.getVslCd());
			logVO.setSkdVoyNo(condVO.getSkdVoyNo());
			logVO.setSkdDirCd(condVO.getSkdDirCd());
//			logVO.setPolCd(polVO.getPolCd()); // 헤깔림
			logVO.setPodCd(condVO.getPodCd());

			if (account.getAccess_system() != null && "EsmBkgB908".equals(account.getAccess_system())) {
				// batch 에서 넘어 왔을 경우
				logVO.setSndUsrId("EsmBkgB908");
				logVO.setSndUsrOfcCd("SYS");
				logVO.setCreUsrId("EsmBkgB908");

			} else {
				// 화면에서 넘어 왔을 경우

				logVO.setSndUsrId(account.getUsr_id());
				logVO.setSndUsrOfcCd(account.getOfc_cd());
				logVO.setCreUsrId(account.getUsr_id());
			}

			logVO.setEdiSndLogCtnt(flatFile);
			logVO.setCrrBatNo(flatFile.substring(62, 77));
			/***********************************************************
			 * 로그DB Insert
			 ***********************************************************/
			CndExpCustomsTransmissionBackEndJob cndBackEndJob = new CndExpCustomsTransmissionBackEndJob();
			cndBackEndJob.writeCstmsSendLog(dbDao, logVO);
			return flatFile;

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);

		} catch (EventException ex) {
			throw ex;

		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Receive History Detail
	 *
	 * @param CstmsRcvLogDtlCondVO cstmsRcvLogDtlCondVO
	 * @return List<CstmsRcvLogDtlVO>
	 * @throws EventException
	 */
	public List<CstmsRcvLogDtlVO> searchCstmsRcvLogDtl(CstmsRcvLogDtlCondVO cstmsRcvLogDtlCondVO) throws EventException {
		try {
			return dbDao.searchCndCstmsRcvLogDtl((CndCstmsRcvLogDtlCondVO) cstmsRcvLogDtlCondVO);

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);

		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * SendLog History Detail
	 *
	 * @param CstmsSndLogDtlCondVO cstmsSndLogDtlCondVO
	 * @return List<CndCstmsSndLogDtlVO>
	 * @throws EventException
	 */
	public List<CndCstmsSndLogDtlVO> searchCstmsSndLogDtl(CstmsSndLogDtlCondVO cstmsSndLogDtlCondVO) throws EventException {
		try {
			CndCstmsSndLogDtlCondVO cndCstmsSndLogDtlCondVO = (CndCstmsSndLogDtlCondVO) cstmsSndLogDtlCondVO;
			if ("BAPLIE".equals(cndCstmsSndLogDtlCondVO.getTrsmMsgTpId())) {
				List<CndCstmsSndLogDtlVO> cndCstmsSndLogDtlVOList = new ArrayList<CndCstmsSndLogDtlVO>();
				CndCstmsSndLogDtlVO cndCstmsSndLogDtlVO = new CndCstmsSndLogDtlVO();
				for(CndCstmsSndLogDtlVO tempSndLogDtlVO : dbDao.searchCndCstmsSndStwgLogDtl(cndCstmsSndLogDtlCondVO)) {
					String[] flatFileRowArray = tempSndLogDtlVO.getEdiSndLogCtnt().split("\n");
					for(String flatFileRow : flatFileRowArray) {
						cndCstmsSndLogDtlVO = new CndCstmsSndLogDtlVO();
						cndCstmsSndLogDtlVO.setEdiSndLogCtnt(flatFileRow);
						cndCstmsSndLogDtlVOList.add(cndCstmsSndLogDtlVO);
					}
				}
				return cndCstmsSndLogDtlVOList;
			}else{
				return dbDao.searchCndCstmsSndLogDtl(cndCstmsSndLogDtlCondVO);
			}


		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);

		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * 세관 적하 목록 정정 신고를 위한 적하 정정 목록 조회
	 *
	 * @param CstmsManifestAmendmentCondVO cstmsManifestAmendmentCondVO
	 * @param String aiDiv
	 * @return List<CstmsManifestAmendmentVO>
	 * @throws EventException
	 */
	public List<CstmsManifestAmendmentVO> searchCstmsManifestAmendment(CstmsManifestAmendmentCondVO cstmsManifestAmendmentCondVO, String aiDiv) throws EventException {
		List<CstmsManifestAmendmentVO> list = new ArrayList<CstmsManifestAmendmentVO>();

		try {
			if ("GEN".equals(aiDiv)) {
				list = dbDao.searchCndCstmsManifestAmendment((CndCstmsManifestAmendmentCondVO) cstmsManifestAmendmentCondVO);
			} else if ("DEL".equals(aiDiv)) {
				list = dbDao.searchDelManifestAmendment((CndCstmsManifestAmendmentCondVO) cstmsManifestAmendmentCondVO);
		}

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);

		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
		return list;
	}

	/**
	 * ACI Report
	 *
	 * @param CstmsTrsmRsltListCondVO cstmsTrsmRsltListCondVO
	 * @return List<CstmsTrsmRsltVO>
	 * @throws EventException
	 */
	public List<CstmsTrsmRsltVO> searchCstmsTrsmRsltList(CstmsTrsmRsltListCondVO cstmsTrsmRsltListCondVO) throws EventException {
		try {
			CndCstmsTrsmRsltListCondVO condVO = (CndCstmsTrsmRsltListCondVO) cstmsTrsmRsltListCondVO;
			condVO.setTotcountFlag("true");
			List<CstmsTrsmRsltVO> list = dbDao.searchCndCstmsTrsmRsltList(condVO);
			// 유형별 건수
			int iManifestTtl = 0;
			int iSentByA6a = 0;
			int iSentByAl = 0;
			int iTargetTtl = 0;
			int iUnmanifest = 0;
			int iTotal = 0;
			int iProcessed = 0;
			int iError = 0;
			for (int i = 0; i < list.size(); i++) {
				CndCstmsTrsmRsltVO vo = (CndCstmsTrsmRsltVO) list.get(i);
				if (!"".equals(vo.getBlNo())) {
					if ("00".equals(vo.getCstmsTrsmStsCd())) {
						iManifestTtl++;
						iSentByA6a++;
						iTargetTtl++;
					}
					if ("04".equals(vo.getCstmsTrsmStsCd())) {
						iManifestTtl++;
						iSentByAl++;
						iTargetTtl++;
					}
					if ("".equals(vo.getCstmsTrsmStsCd()) || "03".equals(vo.getCstmsTrsmStsCd())) {
						iTargetTtl++;
						iUnmanifest++;
					}
					/* 01	Cancellation
					 * 06	Confirmation
					 * 21	Transaction on Hold
					 * 37	Authority Declined (Reply) * 44	Rejection
					 * 48	Suspended */
					if ("06".equals(vo.getCstmsAckProcRsltCd()) || "01".equals(vo.getCstmsAckProcRsltCd())) iProcessed++;
					if ("".equals(vo.getCstmsAckProcRsltCd()) && ("A".equals(vo.getCstmsAckRcvRsltCd()) || "E".equals(vo.getCstmsAckRcvRsltCd()))) iProcessed++;
//					if (!"".equals(vo.getCstmsAckProcRsltCd()) && !"06".equals(vo.getCstmsAckProcRsltCd())
//							&& !"".equals(vo.getCstmsAckRcvRsltCd()) && !"E".equals(vo.getCstmsAckRcvRsltCd())
//							&& !"A".equals(vo.getCstmsAckRcvRsltCd()))
					if ("37".equals(vo.getCstmsAckProcRsltCd()) || "44".equals(vo.getCstmsAckProcRsltCd()) || "21".equals(vo.getCstmsAckProcRsltCd()) || "48".equals(vo.getCstmsAckProcRsltCd()) || (!"A".equals(vo.getCstmsAckRcvRsltCd()) && !"E".equals(vo.getCstmsAckRcvRsltCd()) && !"01".equals(vo.getCstmsAckProcRsltCd())) ) {
						iError++;
					}
				}
				iTotal++;
			}
			if (list.size() > 0) {
				CndCstmsTrsmRsltVO vo = (CndCstmsTrsmRsltVO) list.get(0);
				vo.setManifestTtl("" + iManifestTtl);
				vo.setSentByA6a("" + iSentByA6a);
				vo.setSentByAl("" + iSentByAl);
				vo.setTargetTtl("" + iTargetTtl);
				vo.setUnmanifest("" + iUnmanifest);
				vo.setTotal("" + iTotal);
				vo.setProcessed("" + iProcessed);
				vo.setError("" + iError);
			}
			return list;

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);

		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Manifest를 신고하기 위해 FlatFile을 생성한다.
	 *
	 * @param ManifestTransmitVO manifestTransmitVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String transmitManifest(ManifestTransmitVO manifestTransmitVO, SignOnUserAccount account) throws EventException {
		CndExpCustomsTransmissionBackEndJob cndBackEndJob = new CndExpCustomsTransmissionBackEndJob();
		BackEndJobManager backEndJobManager = new BackEndJobManager();

		try {
			if ("ESM_BKG_N002".equals(manifestTransmitVO.getPgmNo())) {
				cndBackEndJob.setManifestTransmitVO(manifestTransmitVO, account);
				/*******************************************************
				 * BackEndJob 방식으로 호출
				 *******************************************************/
				return backEndJobManager.execute(cndBackEndJob, account.getUsr_id(), "Canada Export Manifest Transmit(MI)");

			} else {
				// ESM_BKG_N003, ESM_BKG_N004
				CndCstmsManifestVO cndVO = (CndCstmsManifestVO) manifestTransmitVO;
				/***********************************************************
				 * 전송 FlatFile 만들어서 로그테이블에 등록
				 **********************************************************/
				// 1건이기 때문에
				String[] blNos = new String[1];
				blNos[0] = cndVO.getBlNo();
				cndVO.setBlNos(blNos);
				cndBackEndJob.setManifestTransmitVO(cndVO, account);
				/*******************************************************
				 * 내부적으로 1건씩 SC를 호출하기 때문에
				 *   BackEndJob 방식을 사용하지 않음에 유의!!!
				 *******************************************************/
				return cndBackEndJob.doStart();
			}

		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * AI 전송(재전송)
	 *
	 * @param CstmsManifestAmendmentVO cstmsManifestAmendmentVO
	 * @param SignOnUserAccount account
	 * @return String FlatFile
	 */
	public String transAmendManifest(CstmsManifestAmendmentVO cstmsManifestAmendmentVO, SignOnUserAccount account) throws EventException {
		// FlatFile
		StringBuilder flatFile = new StringBuilder();

		try {
			CndCstmsManifestAmendmentVO cndVO = (CndCstmsManifestAmendmentVO) cstmsManifestAmendmentVO;
			/************************************************
			 * BL 조회
			 ***********************************************/
			BlInfoForFlatFileVO blInfo = dbDao.searchBlInfoForFlatFile(cndVO);

			// 추가 2009.09.25 CC_CUSTOFCO, CC_CUSTOFCD
			if ("".equals(blInfo.getCustofcd()) && blInfo.getHubLocCd().startsWith("CA")) blInfo.setCustofcd(blInfo.getCustofco());
			if (blInfo.getHubLocCd().startsWith("CA") && "".equals(blInfo.getCustofco()) && "".equals(blInfo.getCustofcd())) {
				String[] arrErrCd = new String[3];
				arrErrCd[0] = blInfo.getBlnbr();
				arrErrCd[1] = blInfo.getBlpod();
				arrErrCd[2] = blInfo.getDelcode();
				throw new EventException(new ErrorHandler("BKG06040", arrErrCd).getMessage());
			}
			if ("".equals(blInfo.getHubLocCd())) throw new EventException(new ErrorHandler("BKG08062", new String[]{"HUB"}).getMessage());
			/************************************************
			 * FlatFile 만들기
			 ***********************************************/
			// Header
			BookingUtil utilBC = new BookingUtil();
			//@------------------------------------------------------------------------------------------------------------ 삭제 코드
//			if ("A6A".equals(blInfo.getCstmsMfTpCd())) {
//				flatFile.append(utilBC.searchCstmsEdiHeader("SMLINE", "RCCECECPP", "311A6A")).append("\n");
//				flatFile.append(utilBC.searchCstmsEdiHeaderNew("CA_311A6A")).append("\n");
//			} else if ("S10".equals(blInfo.getCstmsMfTpCd())) {
//				flatFile.append(utilBC.searchCstmsEdiHeader("SMLINE", "RCCECECPP", "311S10")).append("\n");
//				flatFile.append(utilBC.searchCstmsEdiHeaderNew("CA_311S10")).append("\n");
//			} else if ("E10".equals(blInfo.getCstmsMfTpCd())) {
//				flatFile.append(utilBC.searchCstmsEdiHeader(ConstantMgr.getCompanyCode()+"_311", "CANCUS_E10", "311")).append("\n");
//				flatFile.append(utilBC.searchCstmsEdiHeaderNew("CA_311E10")).append("\n");
//			}
			// 2017.12.27 Header 변경  CK92756 > SMLINE
			if ("A6A".equals(blInfo.getCstmsMfTpCd())) {
				flatFile.append(utilBC.searchCstmsEdiHeader("SMLINE", "RCCECECPP", "311A6A")).append("\n");
			} else if ("S10".equals(blInfo.getCstmsMfTpCd())) {
				flatFile.append(utilBC.searchCstmsEdiHeader("SMLINE", "RCCECECPP", "311S10")).append("\n");
			} else if ("E10".equals(blInfo.getCstmsMfTpCd())) {
				flatFile.append(utilBC.searchCstmsEdiHeader("SMLINE_311", "CANCUS_E10", "311")).append("\n");
			}
			
			// Body
			CndExpCustomsTransmissionBackEndJob cndBackEndJob = new CndExpCustomsTransmissionBackEndJob();
			cndBackEndJob.setManifestTransmitVO(null, account);
			flatFile.append(cndBackEndJob.makeFlatFile(dbDao, cndVO, blInfo));
			/***********************************************************
			 * BL별 CrrBatNo 셋팅<BR>
			 * 사실 캐나다는 CrrBatNo를 세팅할 필요는 없다<BR>
			 * 수신에서 BL별로 오기 때문에 해당BL의 CSTMS_ACK_KEY_NO로 BL을 찾아서<BR>
			 * BL테이블에 UPDATE하면된다.<BR>
			 * 송신한 BL별 수신결과를 보기위함이라면 필요하겠지만..
			 ***********************************************************/
			BkgCstmsAdvEdiBlRspnVO bkgCstmsAdvEdiBlRspnVO = new BkgCstmsAdvEdiBlRspnVO();
			bkgCstmsAdvEdiBlRspnVO.setCntCd(CountryCode.CA);
			bkgCstmsAdvEdiBlRspnVO.setBlNo(cndVO.getBlNo());
			bkgCstmsAdvEdiBlRspnVO.setCrrBatNo(flatFile.toString().substring(62, 77));
//			bkgCstmsAdvEdiBlRspnVO.setCrrBatNo("HJSC" + blInfo.getVvd() + blInfo.getBlpod());
			bkgCstmsAdvEdiBlRspnVO.setCreUsrId(account.getUsr_id());
			List<BkgCstmsAdvEdiBlRspnVO> bkgCstmsAdvEdiBlRspnVOs = new ArrayList<BkgCstmsAdvEdiBlRspnVO>();
			bkgCstmsAdvEdiBlRspnVOs.add(bkgCstmsAdvEdiBlRspnVO);
			dbDao.addBkgCstmsAdvEdiBlRspn(bkgCstmsAdvEdiBlRspnVOs);
			/***********************************************************
			 * 로그남기기
			 ***********************************************************/
			cndBackEndJob.makeManifestLog(dbDao, blInfo, cndVO.getMiSndDt(), flatFile.toString(), account, "");

			/***********************************************************
			 * EDI 전송 START
			 ***********************************************************/
			if (flatFile.toString().startsWith("$$$MSGSTART:")) {
				SendFlatFileVO sendFlatFileVO = new SendFlatFileVO();
				BookingUtil utilCommand = new BookingUtil();
				sendFlatFileVO.setFlatFile(flatFile.toString());
				sendFlatFileVO.setQueueNm(SubSystemConfigFactory.get("BKG.ALPSBKG_UBIZHJS_CANCUS.IBMMQ.QUEUE"));
				FlatFileAckVO flatFileAckVO = utilCommand.sendFlatFile(sendFlatFileVO);
				if (flatFileAckVO.getAckStsCd().equals("E")) throw new EventException(new ErrorHandler("BKG00205", new String[] {}).getMessage());
			} else {
				log.error("\n\n==================== [Incorrect Flatfile] ====================" +
							"\nCndExpCustomsTransmissionBCImpl > transAmendManifest" +
							"\n--------------------------------------------------------------\n" +
							flatFile.toString() +
							"\n==============================================================\n");
			}

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);

		} catch (EventException ex) {
			throw ex;

		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		}
		return flatFile.toString();
	}

	/**
	 * EDI Inbound 처리 메서드
	 *
	 * @param CstmsRcvLogVO cstmsRcvLogVO
	 * @return RcvMsgVO
	 * @throws EventException
	 */
	public RcvMsgVO loadCstmsRcvMsg(CstmsRcvLogVO cstmsRcvLogVO) throws EventException {
		BookingUtil utilCmd = new BookingUtil();
		BkgCstmsAdvRcvLogVO bkgCstmsAdvRcvLogVO = new BkgCstmsAdvRcvLogVO();

		try {
			CndCstmsRcvLogVO cndCstmsRcvLogVO = (CndCstmsRcvLogVO) cstmsRcvLogVO;

			String flatFile = cndCstmsRcvLogVO.getFlatFile();
			String sUsrId = "CANCUS_ACK";
			// 수신 메시지
			String sDiv = "";
			if (flatFile.indexOf("\r\n") != -1) {
				sDiv = "\r\n";
			} else {
				sDiv = "\n";
			}
			String[] arrRcvMsg = flatFile.split(sDiv);
			bkgCstmsAdvRcvLogVO.setCntCd(CountryCode.CA);
			bkgCstmsAdvRcvLogVO.setIoBndCd("I");

			// 수신로그상세
			List<BkgCstmsAdvRcvLogDtlVO> bkgCstmsAdvRcvLogDtlVOs = new ArrayList<BkgCstmsAdvRcvLogDtlVO>();
			// 송신로그
			BkgCstmsAdvSndLogVO bkgCstmsAdvSndLogVO = new BkgCstmsAdvSndLogVO();

			if ("CUSRES".equals(arrRcvMsg[0].substring(52, 58))) {    // BAPLIE
				//BAPLIE Response
				bkgCstmsAdvRcvLogVO.setRcvMsgTpId("BRC");
				bkgCstmsAdvRcvLogVO.setCreUsrId(sUsrId);
				utilCmd.addBkgLog("BKG_BAPLIE", "CA_BAPLIE", bkgCstmsAdvRcvLogVO.getRcvMsgTpId());
				// VO Object Set
				List<BkgCstmsAdvRcvLogVO> bkgCstmsAdvRcvLogVOs = new ArrayList<BkgCstmsAdvRcvLogVO>();
				bkgCstmsAdvRcvLogVOs.add(bkgCstmsAdvRcvLogVO);
				cndCstmsRcvLogVO.setBkgCstmsAdvRcvLogVOs(bkgCstmsAdvRcvLogVOs);
				this.writeCstmsBaplieRcvLog(cstmsRcvLogVO);

			} else {    //  997, 824
				for (int i = 0; i < arrRcvMsg.length; i++) {
					if (arrRcvMsg[i].startsWith("CANCUSRCV")) {
						/**
						 * 첫라인 샘플 : CANCUSRCV82420100301002405
						 */
						bkgCstmsAdvRcvLogVO.setRcvDt(arrRcvMsg[i].substring(12));
						bkgCstmsAdvRcvLogVO.setRcvMsgTpId(arrRcvMsg[i].substring(9, 12));
						bkgCstmsAdvRcvLogVO.setCreUsrId(sUsrId);
					}

					BkgCstmsAdvRcvLogDtlVO bkgCstmsAdvRcvLogDtlVO = new BkgCstmsAdvRcvLogDtlVO();
					bkgCstmsAdvRcvLogDtlVO.setCntCd(CountryCode.CA);
					bkgCstmsAdvRcvLogDtlVO.setIoBndCd("I");
					bkgCstmsAdvRcvLogDtlVO.setRcvDt(bkgCstmsAdvRcvLogVO.getRcvDt());
					bkgCstmsAdvRcvLogDtlVO.setRcvMsgDtlSeq("" + (i + 1));
					bkgCstmsAdvRcvLogDtlVO.setMsgDesc(arrRcvMsg[i]);
					bkgCstmsAdvRcvLogDtlVO.setCreUsrId(sUsrId);
					bkgCstmsAdvRcvLogDtlVOs.add(bkgCstmsAdvRcvLogDtlVO);

					if (arrRcvMsg[i].startsWith("BKC")) {
						// 전송 시 BKG_CSTMS_ADV_SND_LOG의  CRR_BAT_NO
						bkgCstmsAdvRcvLogVO.setCrrBatNo(arrRcvMsg[i]);
					}
					// 컬럼[0]:값[1]
					String[] sValue = arrRcvMsg[i].split(":");
					if (arrRcvMsg[i].startsWith("CONTROL NO:")) {
						// BKG_CSTMS_ADV_BL의 CSTMS_ACK_KEY_NO
						bkgCstmsAdvRcvLogVO.setCstmsBatNo(sValue[1]);
					}
					if ("997".equals(bkgCstmsAdvRcvLogVO.getRcvMsgTpId())) {
						if (arrRcvMsg[i].startsWith("RESPONSE:")) bkgCstmsAdvRcvLogVO.setCndAckRcvId(sValue[1].split("-")[0]);
						if (arrRcvMsg[i].startsWith("GROUP RESPONSE:")) bkgCstmsAdvSndLogVO.setAckRcvTpId(sValue[1]);
						if (arrRcvMsg[i].startsWith("NO OF INCLUDED:")) bkgCstmsAdvSndLogVO.setAckSndKnt(sValue[1]);
						if (arrRcvMsg[i].startsWith("NO OF RECEIVED:")) bkgCstmsAdvSndLogVO.setAckRcvKnt(sValue[1]);
						if (arrRcvMsg[i].startsWith("NO OF ACCEPTED:")) bkgCstmsAdvSndLogVO.setAckAcptKnt(sValue[1]);
					} else if ("824".equals(bkgCstmsAdvRcvLogVO.getRcvMsgTpId())) {
						if (arrRcvMsg[i].startsWith("PURPOSE CODE:")) bkgCstmsAdvRcvLogVO.setCndAckSubCd(sValue[1].split("-")[0]);
						if (arrRcvMsg[i].startsWith("TECHNICAL ERROR:")) bkgCstmsAdvRcvLogVO.setCstmsRjctMsg(sValue[1].split("-")[0]);
						if (arrRcvMsg[i].startsWith("ERROR NOTES:")) bkgCstmsAdvRcvLogVO.setCndAckErrNoteDesc(sValue[1]);
					}
				}

				/*****************************************************************************************
				 * 기존 수신로직에는 첫줄에 receive date가 있어<br>
				 * BKG_CSTMS_ADV_RCV_LOG 테이블의 RCV_DT를 설정하고 DTL 테이블에서 사용했는데<br>
				 * NYK는 첫 라인이 헤더 정보가 들어와 RCV_DT가 나중에 설정되기 때문에 처음 설정안된 부분을 다시 설정함
				 *****************************************************************************************/
				for (int i = 0; i<bkgCstmsAdvRcvLogDtlVOs.size(); i++) {
					if (bkgCstmsAdvRcvLogDtlVOs.get(i).getRcvDt() == null) bkgCstmsAdvRcvLogDtlVOs.get(i).setRcvDt(bkgCstmsAdvRcvLogVO.getRcvDt());
				}
				// 송신로그 업데이트를 위한 리스트 (원래는 단건인데 모델상으로 파라메터가 List이기 때문에 List로 넘김)
				List<BkgCstmsAdvSndLogVO> bkgCstmsAdvSndLogVOs = new ArrayList<BkgCstmsAdvSndLogVO>();
				if (bkgCstmsAdvRcvLogVO.getCrrBatNo() != null && !"".equals(bkgCstmsAdvRcvLogVO.getCrrBatNo())) {
					bkgCstmsAdvSndLogVO.setCntCd(CountryCode.CA);
					bkgCstmsAdvSndLogVO.setIoBndCd("I");
					bkgCstmsAdvSndLogVO.setCrrBatNo(bkgCstmsAdvRcvLogVO.getCrrBatNo());
					bkgCstmsAdvSndLogVO.setAckRcvDt(bkgCstmsAdvRcvLogVO.getRcvDt());
					bkgCstmsAdvSndLogVOs.add(bkgCstmsAdvSndLogVO);
				}
				// 수신로그 등록을 위한 리스트 (원래는 단건인데 모델상으로 파라메터가 List이기 때문에 List로 넘김)
				List<BkgCstmsAdvRcvLogVO> bkgCstmsAdvRcvLogVOs = new ArrayList<BkgCstmsAdvRcvLogVO>();
				bkgCstmsAdvRcvLogVOs.add(bkgCstmsAdvRcvLogVO);
				// VO Object Set
				cndCstmsRcvLogVO.setBkgCstmsAdvRcvLogDtlVOs(bkgCstmsAdvRcvLogDtlVOs);
				cndCstmsRcvLogVO.setBkgCstmsAdvRcvLogVOs(bkgCstmsAdvRcvLogVOs);
				cndCstmsRcvLogVO.setBkgCstmsAdvSndLogVOs(bkgCstmsAdvSndLogVOs);
				utilCmd.addBkgLog("BKG_BAPLIE", "CA_BAPLIE_BCM", "1 loadCstmsRcvMsg : " + bkgCstmsAdvRcvLogVO.getRcvMsgTpId());
				this.writeCstmsRcvLog(cstmsRcvLogVO);
			}

		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return null;
	}

	/**
	 * FlatFile
	 *
	 * @param CndVesselArrivalTransmitVO condVO
	 * @param CndVesselArrivalTransmitVO vslVO
	 * @param CndVesselArrivalTransmitVO polVO
	 * @param List<CndVesselArrivalTransmitVO> portList
	 * @return String
	 */
	public String makeCndVesselArrivalFlatFile(CndVesselArrivalTransmitVO condVO, CndVesselArrivalTransmitVO vslVO, CndVesselArrivalTransmitVO polVO, List<CndVesselArrivalTransmitVO> portList) throws EventException {
		// flatFile
		StringBuilder flatFile = new StringBuilder();
		// 로그를 남기기 위한 값을 cndVesselArrivalTransmitVO에 담는다(일단 POL정보만)
		condVO.setPolCd(polVO.getPolCd());
		// 헤더
		BookingUtil utilBC = new BookingUtil();
		// 2017.12.27 Header 변경  CK92756 > SMLINE
//		flatFile.append(utilBC.searchCstmsEdiHeader("SMLINE", "RCCECECPP", "311A6")).append("\n");

		// NYK에는 Terminal 전송이 추가됨
//		if ("Terminal".equals(condVO.getIbflag())) {
//			flatFile.append(utilBC.searchCstmsEdiHeaderNew("CA_" + polVO.getPodCd() + "_A6")).append("\n");
//		} else {
//			flatFile.append(utilBC.searchCstmsEdiHeaderNew("CA_311A6")).append("\n");
//		}
		
		if ("Terminal".equals(condVO.getIbflag()))
		{
			flatFile.append(utilBC.searchCstmsEdiHeader("SMLINE_311", polVO.getPodCd() + "_A6A", "311")).append("\n");
		} else {
			// 2017.12.27 Header 변경  CK92756 > SMLINE
			flatFile.append(utilBC.searchCstmsEdiHeader("SMLINE", "RCCECECPP", "311A6A")).append("\n");
		}
		
		// 메시지 시작
		flatFile.append("{ST").append("\n");
		flatFile.append("STCNT:").append(vslVO.getCndAckCtrlNo()).append("\n");
		flatFile.append("CC_TRANS:").append(vslVO.getCcTrans()).append("\n");
		flatFile.append("CC_STATUS:").append(vslVO.getStatus()).append("\n");
		flatFile.append("CC_REPNO:").append(vslVO.getCvyRefNo()).append("\n");
		flatFile.append("SFCDATE:").append(vslVO.getVslSftCstruCertiExpDt()).append("\n");
		flatFile.append("SFRDATE:").append(vslVO.getVslSftRdoCertiExpDt()).append("\n");
		flatFile.append("SFEDATE:").append(vslVO.getVslSftEqCertiExpDt()).append("\n");
		flatFile.append("LLDATE:").append(vslVO.getVslLodLineCertiExpDt()).append("\n");
		flatFile.append("DERDATE:").append(vslVO.getVslDeratCertiExpDt()).append("\n");
		flatFile.append("LLOYDCODE:").append(vslVO.getLloydNo()).append("\n");
		flatFile.append("VSLFULLNAME:").append(vslVO.getVslEngNm()).append("\n");
		flatFile.append("VSLCOUNTRY:").append(vslVO.getVslRgstCntCd()).append("\n");
		flatFile.append("VOYAGE:").append(condVO.getSkdVoyNo()).append(condVO.getSkdDirCd()).append("\n");
		flatFile.append("VSLTPCD:CT").append("\n");
		flatFile.append("PORTREG:").append(vslVO.getRgstPortCd()).append("\n");
		flatFile.append("OFFICE:").append(vslVO.getRgstNo()).append("\n");
		flatFile.append("NETWGT:").append(vslVO.getNetRgstTongWgt()).append("\n");
		flatFile.append("NETWGTU:E").append("\n");
		flatFile.append("GROSSWGT:").append(vslVO.getGrsRgstTongWgt()).append("\n");
		flatFile.append("GROSSWGTU:E").append("\n");
		flatFile.append("CC_MAINWGT:").append(condVO.getCgoWgt()).append("\n");
		flatFile.append("CC_MAINWGTU:E").append("\n");
		flatFile.append("NCCT:0").append("\n");
		flatFile.append("NCCTU:E").append("\n");
		flatFile.append("DEADWGT:").append(vslVO.getDwtWgt()).append("\n");
		flatFile.append("DEADWGTU:E").append("\n");
		flatFile.append("CC_CAPTNAME:").append(vslVO.getCapNm()).append("\n");
		flatFile.append("LOA:").append(vslVO.getLoaLen()).append("\n");
		flatFile.append("LOAU:MR").append("\n");
		flatFile.append("CREW:").append(vslVO.getCrwKnt()).append("\n");
		flatFile.append("PASG:0").append("\n");
		// 선적항, 선적일, 양하항 (polVO정보) flatFile.append("CC_POL:").append(polVO.getPolCd()).append("\n");
		flatFile.append("CC_ETD:").append(polVO.getVpsEtdDt()).append("\n");
		flatFile.append("CC_POL:").append(polVO.getPolCd()).append("\n");
		flatFile.append("CC_POD:").append(polVO.getPodCd()).append("\n");
		flatFile.append("CC_ETA:").append(vslVO.getEtaDt()).append("\n");
		flatFile.append("REGDATE:").append(vslVO.getRgstDt()).append("\n");

		// 양하 터미널 이름
		flatFile.append("CC_TERMNAME:");
		if ("HNKH0059E".equals(condVO.getVslCd() + condVO.getSkdVoyNo() + condVO.getSkdDirCd())) {
			flatFile.append("CENTERM (3380)").append("\n");
		} else {
			flatFile.append("VANTERM (3395)").append("\n");
		}
		// Port 정보
		for (int i = 0; i < portList.size(); i++) {
			flatFile.append("{CC_PORT").append("\n");
			flatFile.append("CC_PORT:").append(((CndVesselArrivalTransmitVO) portList.get(i)).getVpsPortCd()).append("\n");
			flatFile.append("}CC_PORT").append("\n");
		}
		// 선적 컨테이너 정보
		flatFile.append("CC_TEU:").append(condVO.getTeuFul()).append("\n");
		flatFile.append("CC_FEU:").append(condVO.getFeuFul()).append("\n");
		flatFile.append("CC_OTL:").append(condVO.getOthFul()).append("\n");
		flatFile.append("CC_TEUE:").append(condVO.getTeuMty()).append("\n");
		flatFile.append("CC_FEUE:").append(condVO.getFeuMty()).append("\n");
		flatFile.append("CC_OTE:").append(condVO.getOthMty()).append("\n");
		flatFile.append("}SE").append("\n");
		return flatFile.toString();
	}
	/**
	 * FlatFile
	 *
	 * @param CndVesselArrivalTransmitVO condVO
	 * @param CndVesselArrivalTransmitVO vslVO
	 * @param CndVesselArrivalTransmitVO polVO
	 * @param List<CndVesselArrivalTransmitVO> portList
	 * @return String
	 */
	public String makeCndVesselDepartureFlatFile(CndVesselArrivalTransmitVO condVO, CndVesselArrivalTransmitVO vslVO, CndVesselArrivalTransmitVO polVO, List<CndVesselArrivalTransmitVO> portList) throws EventException {
		// flatFile
		StringBuilder flatFile = new StringBuilder();
		// 로그를 남기기 위한 값을 cndVesselArrivalTransmitVO에 담는다(일단 POL정보만)
		condVO.setPolCd(polVO.getPolCd());
		// 헤더
		BookingUtil utilBC = new BookingUtil();
		// 2017.12.27 Header 변경  CK92756 > SMLINE
//		flatFile.append(utilBC.searchCstmsEdiHeader("SMLINE", "RCCECECPP", "311A6")).append("\n");
		
		// NYK에는 Terminal 전송이 추가됨
//		if ("Terminal".equals(condVO.getIbflag())) {
//			flatFile.append(utilBC.searchCstmsEdiHeaderNew("CA_" + polVO.getPodCd() + "_A6")).append("\n");
//		} else {
//			flatFile.append(utilBC.searchCstmsEdiHeaderNew("CA_311A6")).append("\n");
//		}
		
		if ("Terminal".equals(condVO.getIbflag()))
		{
			flatFile.append(utilBC.searchCstmsEdiHeader("SMLINE_311", polVO.getPodCd() + "_A6A", "311")).append("\n");
		} else {
			// 2017.12.27 Header 변경  CK92756 > SMLINE			
			flatFile.append(utilBC.searchCstmsEdiHeader("SMLINE", "RCCECECPP", "311A6A")).append("\n");
		}
		
		// 메시지 시작
		flatFile.append("{ST").append("\n");
		flatFile.append("STCNT:").append(vslVO.getCndAckCtrlNo()).append("\n");
		flatFile.append("CC_TRANS:").append(vslVO.getCcTrans()).append("\n");
		flatFile.append("CC_STATUS:").append(vslVO.getStatus()).append("\n");
		flatFile.append("CC_REPNO:").append(vslVO.getCvyRefNo()).append("\n");
		flatFile.append("SFCDATE:").append(vslVO.getVslSftCstruCertiExpDt()).append("\n");
		flatFile.append("SFRDATE:").append(vslVO.getVslSftRdoCertiExpDt()).append("\n");
		flatFile.append("SFEDATE:").append(vslVO.getVslSftEqCertiExpDt()).append("\n");
		flatFile.append("LLDATE:").append(vslVO.getVslLodLineCertiExpDt()).append("\n");
		flatFile.append("DERDATE:").append(vslVO.getVslDeratCertiExpDt()).append("\n");
		flatFile.append("LLOYDCODE:").append(vslVO.getLloydNo()).append("\n");
		flatFile.append("VSLFULLNAME:").append(vslVO.getVslEngNm()).append("\n");
		flatFile.append("VSLCOUNTRY:").append(vslVO.getVslRgstCntCd()).append("\n");
		flatFile.append("VOYAGE:").append(condVO.getSkdVoyNo()).append(condVO.getSkdDirCd()).append("\n");
		flatFile.append("VSLTPCD:CT").append("\n");
		flatFile.append("PORTREG:").append(vslVO.getRgstPortCd()).append("\n");
		flatFile.append("OFFICE:").append(vslVO.getRgstNo()).append("\n");
		flatFile.append("NETWGT:").append(vslVO.getNetRgstTongWgt()).append("\n");
		flatFile.append("NETWGTU:E").append("\n");
		flatFile.append("GROSSWGT:").append(vslVO.getGrsRgstTongWgt()).append("\n");
		flatFile.append("GROSSWGTU:E").append("\n");
		flatFile.append("CC_MAINWGT:").append(condVO.getCgoWgt()).append("\n");
		flatFile.append("CC_MAINWGTU:E").append("\n");
		flatFile.append("NCCT:0").append("\n");
		flatFile.append("NCCTU:E").append("\n");
		flatFile.append("DEADWGT:").append(vslVO.getDwtWgt()).append("\n");
		flatFile.append("DEADWGTU:E").append("\n");
		flatFile.append("CC_CAPTNAME:").append(vslVO.getCapNm()).append("\n");
		flatFile.append("LOA:").append(vslVO.getLoaLen()).append("\n");
		flatFile.append("LOAU:MR").append("\n");
		flatFile.append("CREW:").append(vslVO.getCrwKnt()).append("\n");
		flatFile.append("PASG:0").append("\n");
		// 선적항, 선적일, 양하항 (polVO정보)
		//CC_POL 해외 포트 > Export CA이후 첫 도착 POD_CD
		flatFile.append("CC_POL:").append(polVO.getPolCd()).append("\n");
		flatFile.append("CC_ETD:").append(vslVO.getEtdDt()).append("\n");
		//CC_POD CA 포트 > Export CA이후 첫 도착 POD_CD
		flatFile.append("CC_POD:").append(polVO.getPodCd()).append("\n");
		flatFile.append("CC_ETA:").append(polVO.getVpsEtaDt()).append("\n");
		flatFile.append("REGDATE:").append(vslVO.getRgstDt()).append("\n");
		
		// 양하 터미널 이름
		flatFile.append("CC_TERMNAME:");
		if ("HNKH0059E".equals(condVO.getVslCd() + condVO.getSkdVoyNo() + condVO.getSkdDirCd())) {
			flatFile.append("CENTERM (3380)").append("\n");
		} else {
			flatFile.append("VANTERM (3395)").append("\n");
		}
		// Port 정보
		for (int i = 0; i < portList.size(); i++) {
			flatFile.append("{CC_PORT").append("\n");
			flatFile.append("CC_PORT:").append(((CndVesselArrivalTransmitVO) portList.get(i)).getVpsPortCd()).append("\n");
			flatFile.append("}CC_PORT").append("\n");
		}
		// 선적 컨테이너 정보
		flatFile.append("CC_TEU:").append(condVO.getTeuFul()).append("\n");
		flatFile.append("CC_FEU:").append(condVO.getFeuFul()).append("\n");
		flatFile.append("CC_OTL:").append(condVO.getOthFul()).append("\n");
		flatFile.append("CC_TEUE:").append(condVO.getTeuMty()).append("\n");
		flatFile.append("CC_FEUE:").append(condVO.getFeuMty()).append("\n");
		flatFile.append("CC_OTE:").append(condVO.getOthMty()).append("\n");
		flatFile.append("}SE").append("\n");
		return flatFile.toString();
	}

	/**
	 * Actual FlatFile
	 *
	 * @param CndVesselArrivalTransmitVO actVslVO
	 * @return String
	 * @throws EventException
	 */
	public String makeCndActualVesselDepartureFlatFile(CndVesselArrivalTransmitVO actVslVO) throws EventException {
		// flatFile
		StringBuilder flatFile = new StringBuilder();
		// 헤더
		BookingUtil utilBC = new BookingUtil();
		flatFile.append(utilBC.searchCstmsEdiHeader("SMLINE", "CANCUS_ACICA", "353")).append("\n");
		// 메시지 시작
		flatFile.append("{ARR_INFO").append("\n");
		flatFile.append("E_I_IND:I").append("\n");
		flatFile.append("CBSA_CARRIER_CD:918P").append("\n");
		flatFile.append("VVD:").append(actVslVO.getVslCd()).append(actVslVO.getSkdVoyNo()).append(actVslVO.getSkdDirCd()).append("\n");
		flatFile.append("VSL_FULLNAME:").append(actVslVO.getVslEngNm()).append("\n");
		flatFile.append("VSL_NATION_CD:").append(actVslVO.getVslRgstCntCd()).append("\n");
		flatFile.append("POD_CD:").append(actVslVO.getPodCd()).append("\n");
		flatFile.append("POD_NM:").append(actVslVO.getPodNm()).append("\n");

		String actArrDt[] = actVslVO.getActArrDt().split(":");
		String date = "";
		String time = "";
		if (actArrDt != null) {
			 if ( actArrDt.length == 1 ) {
				 date  = actArrDt[0];
			 } else if ( actArrDt.length > 1 ) {
				 date  = actArrDt[0];
				 time  = actArrDt[1];
			 }
		}
		flatFile.append("POD_ATA_D:").append(date).append("\n");
		flatFile.append("POD_ATA_T:").append(time).append("\n");
		flatFile.append("CRN:").append(actVslVO.getCvyRefNo()).append("\n");
		flatFile.append("}ARR_INFO").append("\n");
		return flatFile.toString();
	}

	/**
	 * 수신정보 로그기록
	 *
	 * @param CstmsRcvLogVO cstmsRcvLogVO
	 * @throws Exception
	 */
	private void writeCstmsRcvLog(CstmsRcvLogVO cstmsRcvLogVO) throws Exception {

		String strEmlType = "";

		log.info("<<<<<<<<<<<< writeCstmsRcvLog Start >>>>>>>>>>>>>>>");
		CndCstmsRcvLogVO cndCstmsRcvLogVO = (CndCstmsRcvLogVO) cstmsRcvLogVO;
		BkgCstmsAdvRcvLogVO bkgCstmsAdvRcvLogVO = cndCstmsRcvLogVO.getBkgCstmsAdvRcvLogVOs().get(0);
		// MaxRcvSeq를 Proxy에서 가져올수 없으므로(Proxy에서 DAO를 호출하면 안될거 같아서..)
		String rcvSeq = dbDao.searchMaxRcvLogSeq(bkgCstmsAdvRcvLogVO);
		log.info("MaxRcvSeq=" + rcvSeq);
		bkgCstmsAdvRcvLogVO.setRcvSeq(rcvSeq);
		// VslCd, VoyNo, DirCd, BLNo, Pod, Pol 정보조회
		CndCstmsBlByKeyVO cndCstmsBlByKeyVO = dbDao.searchCndCstmsBlByKey(bkgCstmsAdvRcvLogVO.getCstmsBatNo());
		if (cndCstmsBlByKeyVO != null) {
			bkgCstmsAdvRcvLogVO.setBlNo(cndCstmsBlByKeyVO.getBlNo());
			bkgCstmsAdvRcvLogVO.setVslCd(cndCstmsBlByKeyVO.getVslCd());
			bkgCstmsAdvRcvLogVO.setSkdVoyNo(cndCstmsBlByKeyVO.getSkdVoyNo());
			bkgCstmsAdvRcvLogVO.setSkdDirCd(cndCstmsBlByKeyVO.getSkdDirCd());
			bkgCstmsAdvRcvLogVO.setPolCd(cndCstmsBlByKeyVO.getCstmsPolCd());
			bkgCstmsAdvRcvLogVO.setPodCd(cndCstmsBlByKeyVO.getCstmsPodCd());

			// 37 :DNL, 21 : HOLD, 44 : REJECT, 01 : RELEASE
			if ("44".equals(bkgCstmsAdvRcvLogVO.getCndAckSubCd())) {
				// REJECT
				strEmlType = "03";
			} else if ("37".equals(bkgCstmsAdvRcvLogVO.getCndAckSubCd())) {
				// DNL
				strEmlType = "04";
			} else if ("21".equals(bkgCstmsAdvRcvLogVO.getCndAckSubCd())) {
				// HOLD
				strEmlType = "06";
			} else if ("01".equals(bkgCstmsAdvRcvLogVO.getCndAckSubCd())) {
				// Removal
				// BL의  CSTMS_ACK_RCV_RSLT_CD 값이 "37"의 경우 DNL Removal, "21"의 경우 HOLD Removal
				if ("37".equals(cndCstmsBlByKeyVO.getLastAck())) {
					// DNL Removal
					strEmlType = "05";
				} else if ("21".equals(cndCstmsBlByKeyVO.getLastAck())) {
					// HOLD Removal
					strEmlType = "07";
				}
			}


			for (int i = 0; i < cndCstmsRcvLogVO.getBkgCstmsAdvRcvLogDtlVOs().size(); i++) {
				BkgCstmsAdvRcvLogDtlVO bkgCstmsAdvRcvLogDtlVO = cndCstmsRcvLogVO.getBkgCstmsAdvRcvLogDtlVOs().get(i);
//				bkgCstmsAdvRcvLogDtlVO.setRcvSeq(rcvSeq);

				if (bkgCstmsAdvRcvLogDtlVO.getMsgDesc().startsWith("EQUIPMENT:")) cndCstmsBlByKeyVO.setCntrNo(bkgCstmsAdvRcvLogDtlVO.getMsgDesc().substring(10));
			}
			// 담당자에 수신결과에 따른 메일전송
			if (!"".equals(strEmlType)) this.sendEml(strEmlType, bkgCstmsAdvRcvLogVO, cndCstmsBlByKeyVO);
		} else {
			// VslCd, VoyNo, DirCd 정보조회
			BkgCstmsCndVslVO bkgCstmsCndVslVO = dbDao.searchCndCstmsVvdByKey(bkgCstmsAdvRcvLogVO.getCstmsBatNo());
			if (bkgCstmsCndVslVO != null) {
				bkgCstmsAdvRcvLogVO.setVslCd(bkgCstmsCndVslVO.getVslCd());
				bkgCstmsAdvRcvLogVO.setSkdVoyNo(bkgCstmsCndVslVO.getSkdVoyNo());
				bkgCstmsAdvRcvLogVO.setSkdDirCd(bkgCstmsCndVslVO.getSkdDirCd());
			}
		}
		for (int i = 0; i < cndCstmsRcvLogVO.getBkgCstmsAdvRcvLogDtlVOs().size(); i++) {
			BkgCstmsAdvRcvLogDtlVO bkgCstmsAdvRcvLogDtlVO = cndCstmsRcvLogVO.getBkgCstmsAdvRcvLogDtlVOs().get(i);
			bkgCstmsAdvRcvLogDtlVO.setRcvSeq(rcvSeq);
		}
		dbDao.addBkgCstmsAdvRcvLog(cndCstmsRcvLogVO.getBkgCstmsAdvRcvLogVOs());
		dbDao.addBkgCstmsAdvRcvLogDtl(cndCstmsRcvLogVO.getBkgCstmsAdvRcvLogDtlVOs());
		dbDao.modifyBkgCstmsAdvSndLog(cndCstmsRcvLogVO.getBkgCstmsAdvSndLogVOs());
	}

	/**
	 * 수신결과에 따른 메일전송<br>
	 * 37 :DNL, 21 : HOLD, 44 : REJECT, 01 : RELEASE
	 *
	 * @param String strEmlType
	 * @param BkgCstmsAdvRcvLogVO bkgCstmsAdvRcvLogVO
	 * @param CndCstmsBlByKeyVO cndCstmsBlByKeyVO
	 */
	private void sendEml(String strEmlType, BkgCstmsAdvRcvLogVO bkgCstmsAdvRcvLogVO, CndCstmsBlByKeyVO cndCstmsBlByKeyVO) {
		try {
			TemplateMail template = new TemplateMail();
			String strSubject = "CA24 - ";
			CstmsEmlNtfcVO emlParam = new CstmsEmlNtfcVO();
			emlParam.setCntCd("CA");
			emlParam.setEdiMsg("ACI");
			emlParam.setPolCd(cndCstmsBlByKeyVO.getCstmsPolCd());
			emlParam.setPodCd(cndCstmsBlByKeyVO.getCstmsPodCd());

			if ("03".equals(strEmlType)) {
				emlParam.setEdiMsgTpId("Rejection(Error)");
				strSubject = strSubject + "Rejection : " + cndCstmsBlByKeyVO.getCstmsPodCd() + "(POD)-" + cndCstmsBlByKeyVO.getCstmsPolCd() + "(POL)-" + cndCstmsBlByKeyVO.getBlNo();
				this.setTemplateArg(template, bkgCstmsAdvRcvLogVO, cndCstmsBlByKeyVO, true, true, false, false, true, true, true, false, true);
			} else if ("04".equals(strEmlType)) {
				emlParam.setEdiMsgTpId("DNL/DNL Removals");
				strSubject = strSubject + "Do Not Load : " + cndCstmsBlByKeyVO.getCstmsPodCd() + "(POD)-" + cndCstmsBlByKeyVO.getCstmsPolCd() + "(POL)-" + cndCstmsBlByKeyVO.getBlNo();
				this.setTemplateArg(template, bkgCstmsAdvRcvLogVO, cndCstmsBlByKeyVO, true, true, true, true, true, true, true, true, true);
			} else if ("05".equals(strEmlType)) {
				emlParam.setEdiMsgTpId("DNL/DNL Removals");
				strSubject = strSubject + "Do Not Load Removal : " + cndCstmsBlByKeyVO.getCstmsPodCd() + "(POD)-" + cndCstmsBlByKeyVO.getCstmsPolCd() + "(POL)-" + cndCstmsBlByKeyVO.getBlNo();
				this.setTemplateArg(template, bkgCstmsAdvRcvLogVO, cndCstmsBlByKeyVO, true, true, true, true, true, true, true, true, false);
			} else if ("06".equals(strEmlType)) {
				emlParam.setEdiMsgTpId("Hold/Hold Removals");
				strSubject = strSubject + "Hold : " + cndCstmsBlByKeyVO.getCstmsPodCd() + "(POD)-" + cndCstmsBlByKeyVO.getCstmsPolCd() + "(POL)-" + cndCstmsBlByKeyVO.getBlNo();
				this.setTemplateArg(template, bkgCstmsAdvRcvLogVO, cndCstmsBlByKeyVO, true, true, true, true, true, true, true, true, true);
			} else if ("07".equals(strEmlType)) {
				emlParam.setEdiMsgTpId("Hold/Hold Removals");
				strSubject = strSubject + "Hold Removal : " + cndCstmsBlByKeyVO.getCstmsPodCd() + "(POD)-" + cndCstmsBlByKeyVO.getCstmsPolCd() + "(POL)-" + cndCstmsBlByKeyVO.getBlNo();
				this.setTemplateArg(template, bkgCstmsAdvRcvLogVO, cndCstmsBlByKeyVO, true, true, true, true, true, true, true, true, false);
			}
			/***************************************
			 * 수신처 조회
			 ***************************************/
			CustomsCommonMgtBC comBc = new CustomsCommonMgtBCImpl();
			CstmsEmlNtfcVO eml = comBc.searchCstmsEmlNtfcInfo(emlParam);
			/***************************************
			 * Mail Template
			 ***************************************/
			if (eml != null) {
				template.setHtmlTemplate("ESM_BKG_RCV_EML_CA" + strEmlType + "T.html");
				template.setBatFlg("N");
				template.setFrom("noreply@cyberlogitec.com", "CTM EDI Monitor");
				template.setRecipient(eml.getToEmlCtnt());
				template.setCcRcvrEml(eml.getCcEmlCtnt());
				template.setSubject(strSubject);
				template.send();
			}


		} catch (Exception ex) {
			log.error(new ErrorHandler("BKG00707", new String[] { "CA Recieve Mail Send " }).getMessage());
		}
	}

	/**
	 * Mail Template Argument 설정
	 * 
	 * @param TemplateMail template,
	 * @param BkgCstmsAdvRcvLogVO bkgCstmsAdvRcvLogVO,
	 * @param CndCstmsBlByKeyVO cndCstmsBlByKeyVO,
	 * @param boolean vvd,
	 * @param boolean blNo,
	 * @param boolean shipper,
	 * @param boolean consignee,
	 * @param boolean ofcNm,
	 * @param boolean pol,
	 * @param boolean pod,
	 * @param boolean container,
	 * @param boolean reason
	 * @throws Exception
	 */
	private void setTemplateArg(TemplateMail template,
								BkgCstmsAdvRcvLogVO bkgCstmsAdvRcvLogVO,
								CndCstmsBlByKeyVO cndCstmsBlByKeyVO,
								boolean vvd,
								boolean blNo,
								boolean shipper,
								boolean consignee,
								boolean ofcNm,
								boolean pol,
								boolean pod,
								boolean container,
								boolean reason) throws Exception {
		if (vvd) template.setArg("vvd", (cndCstmsBlByKeyVO.getVvd() == null) ? "" : cndCstmsBlByKeyVO.getVvd());
		if (blNo) template.setArg("blNo", (cndCstmsBlByKeyVO.getBlNo() == null) ? "" : cndCstmsBlByKeyVO.getBlNo());
		if (shipper) template.setArg("shipper", (cndCstmsBlByKeyVO.getShipper() == null) ? "" : cndCstmsBlByKeyVO.getShipper());
		if (consignee) template.setArg("consignee", (cndCstmsBlByKeyVO.getConsignee() == null) ? "" : cndCstmsBlByKeyVO.getConsignee());
//		if (ofcNm) template.setArg("ofcNm", cndCstmsBlByKeyVO.getOfcEngNm());
		if (pol)template.setArg("pol", (cndCstmsBlByKeyVO.getCstmsPolCd() == null) ? "" : cndCstmsBlByKeyVO.getCstmsPolCd());
		if (pod)template.setArg("pod", (cndCstmsBlByKeyVO.getCstmsPodCd() == null) ? "" : cndCstmsBlByKeyVO.getCstmsPodCd());
		if (container)template.setArg("container", (cndCstmsBlByKeyVO.getCntrNo() == null) ? "" : cndCstmsBlByKeyVO.getCntrNo());
		if (reason) template.setArg("reason", (bkgCstmsAdvRcvLogVO.getCndAckErrNoteDesc() == null) ? "" : bkgCstmsAdvRcvLogVO.getCndAckErrNoteDesc());
	}

	/**
	 * EDI 오류
	 * 
	 * @param String msg
	 * @throws Exception
	 */
	public void loadEdiErr(String msg) throws Exception {
		String sDiv = "";
		if (msg.indexOf("\r\n") != -1) sDiv = "\r\n";
		else							sDiv = "\n";

		String[] arrRcvMsg = msg.split(sDiv);
		String orgMsgKey = "";

		for (int i = 0; i < arrRcvMsg.length; i++) {
			if (arrRcvMsg[i].startsWith("ORG_MSG_KEY:")) orgMsgKey = arrRcvMsg[i].substring(12);
		}
		CstmsEmlNtfcVO eml = null;
		// BL조회
		List<CndCstmsBlByKeyVO> list = dbDao.searchBlForCrrBatNo(orgMsgKey);
		CndCstmsBlByKeyVO bl = null;
		StringBuffer sbBlNo = new StringBuffer();
		CstmsEmlNtfcVO emlParam = new CstmsEmlNtfcVO();

		for (int i = 0; i < list.size(); i++) {
			// 수신인 조회
			if (i == 0) {
				bl = list.get(0);
				emlParam.setCntCd("CA");
				emlParam.setEdiMsg("ACI");
				emlParam.setEdiMsgTpId("EDI Technical Failure");
				emlParam.setPolCd(bl.getCstmsPolCd());
				emlParam.setPodCd(bl.getCstmsPodCd());
			} else {
				sbBlNo.append(", ");
			}
			sbBlNo.append(list.get(i).getBlNo());
		}

		/***************************************
		 * 수신처 조회
		 ***************************************/
		if (bl != null ) {
			CustomsCommonMgtBC comBc = new CustomsCommonMgtBCImpl();
			eml = comBc.searchCstmsEmlNtfcInfo(emlParam);

			if (eml != null && eml.getToEmlCtnt() != null) {
				TemplateMail template = new TemplateMail();
				template.setHtmlTemplate("ESM_BKG_RCV_EML_CA02T.html");
				template.setSubject("CA24 - Technical Failure BL Number : " + bl.getBlNo());
				template.setBatFlg("N");
				template.setFrom("noreply@cyberlogitec.com", "CTM EDI Monitor");
				template.setRecipient(eml.getToEmlCtnt());
				template.setCcRcvrEml(eml.getCcEmlCtnt());

				template.setArg("vvd",  bl.getVvd());
				template.setArg("blNo", sbBlNo.toString());
				template.setArg("pol",  bl.getCstmsPolCd());
				template.setArg("pod",  bl.getCstmsPodCd());

				template.send();
			}
		}
	}

	/**
	 * Vessel Stowage Plan Transmit 화면을 조회.
	 *
	 * @param StowageManifestCondVO stowageManifestCondVO
	 * @return List<ManifestTransmitVO>
	 * @throws EventException
	 */
	public List<ManifestTransmitVO> searchStowageManifestList(StowageManifestCondVO stowageManifestCondVO) throws EventException {
		StiCondListCndVO condVO = (StiCondListCndVO) stowageManifestCondVO;
		List<ManifestTransmitVO> rtnList = new ArrayList<ManifestTransmitVO>();
		List<StiDetailCndVO> list = null;
		String paramVvd = ""; 	// 파라메터로 넘오는 vvd
		String tmpVvd = "";		// 가공한 값을 담을 vvd
		String sLane = "";

		try {
			// 조회조건이 유효한 조건일때 로직 실행.
			if (condVO != null) {
				paramVvd = tmpVvd = condVO.getVvd();
				sLane = dbDao.searchSvcLane(paramVvd); // service lane값을 조회한다.

				/* 20090602 JHPARK Lane 이 PNS 이거나 CEN 이면 temp_vvd 를 바꿔준다. (입력된 E/B 를 W/B 로) */
				if ("PNS".equals(sLane) || "CEN".equals(sLane)) {

					tmpVvd = paramVvd.subSequence(0, 8) + "W";
				}

				/****************************************************************************/
				/* 20090602 JHPARK 아시아 -> 캐나다 -> 미국인 경우에 캐나다에서는 West Bound*/
				/* 로 Upload 한다. (아시아 선적분 포함) PNS, CEN Lane 의 경우에는 User 가 	*/
				/* E/B 로 조회하더라도 W/B 로 Upload 된 데이터를 조회할 수 있어야 한다. 	*/
				/****************************************************************************/
				if ("EXCLUDECA".equals(condVO.getExcludeca())) {
					condVO.setVvd(tmpVvd);
				} else {
					// 화면에서 가져온 vvd를 그대로 사용한다.
					condVO.setVvd(paramVvd);
				}

				list = dbDao.searchStiListAtCnd(condVO);
				if (list != null) {
					// Vessel Info.를 조회한다.
					MdmVslCntrVO vo = dbDao.searchVslInfo(paramVvd);
					// vos의 결과 수 만큼 루프를 돌며, list를 채워준다.
					StiDetailCndVO itemVO = null;
					for (int i = 0; i < list.size(); i++) {
						itemVO = list.get(i);
						itemVO.setVslEngNm(vo.getVslEngNm());
						itemVO.setVslVoy(paramVvd.substring(4));
						itemVO.setCrrCd(vo.getCrrCd());
						rtnList.add(itemVO);
					}
				}
			}
			return rtnList;

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);

		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Vessel Stowage Plan Transmit 화면에서 캐나다 입항 전 항구 조회.
	 *
	 * @param StowageManifestCondVO stowageManifestCondVO
	 * @return List<ManifestTransmitVO>
	 * @throws EventException
	 */
	public List<ManifestTransmitVO> searchLastForeignPort(StowageManifestCondVO stowageManifestCondVO) throws EventException {
		StiCondListCndVO condVO = (StiCondListCndVO) stowageManifestCondVO;
		List<StiDetailCndVO> list = null;
		List<ManifestTransmitVO> rtnList = new ArrayList<ManifestTransmitVO>();
		String vvd = ""; 	// 파라메터로 넘오는 vvd

		try {
			StiDetailCndVO itemVO = null;
			vvd = condVO.getVvd();
			list = dbDao.searchLastForeignPort(vvd);
			for(int i=0; i<list.size();i++) {
				itemVO = list.get(i);
				rtnList.add(itemVO);
			}
			return rtnList;

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);

		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Select CRN for Baplie 화면에서 CRN No.를 조회.
	 *
	 * @param StowageManifestCondVO stowageManifestCondVO
	 * @return List<ManifestTransmitVO>
	 * @throws EventException
	 */
	public List<ManifestTransmitVO> searchCrnNo(StowageManifestCondVO stowageManifestCondVO) throws EventException {
		StiCondListCndVO condVO = (StiCondListCndVO) stowageManifestCondVO;
		List<StiDetailCndVO> list = null;
		List<ManifestTransmitVO> rtnList = new ArrayList<ManifestTransmitVO>();
		String vvd = ""; 	// 파라메터로 넘오는 vvd
		String vpsPortCd ="";
		String clptIndSeq = "";

		try {
			StiDetailCndVO itemVO = null;
			vvd = condVO.getVvd();
			vpsPortCd = condVO.getVpsPortCd();
			clptIndSeq = condVO.getClptIndSeq();
			list = dbDao.searchCrnNo(vvd, vpsPortCd,clptIndSeq);
			for(int i=0; i<list.size();i++) {
				itemVO = list.get(i);
				rtnList.add(itemVO);
			}
			return rtnList;

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);

		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Vessel Stowage Plan Transmit을 실행.
	 *
	 * @param ManifestTransmitVO[] manifestTransmitVOs
	 * @return String
	 * @throws EventException
	 */
	public String transmitStowageManifest(ManifestTransmitVO[] manifestTransmitVOs) throws EventException {

		String condVvd = ""; // 조회조건 vvd값
		String searchVvdCd = ""; // 조회시 조회된 vvd 값
		String pod = "";
		String lastpol = "";
		String usrId = "";
		String ofcCd = "";
		String usPortCd = "";
		String fristPod = "";
		String polEstDepDt = "";
		String polActDepDt = "";
		String fristCaEtaDt = "";
		String originTran = "";
		String vpsPortCd = "";
		//String clptIndSeq = "";
		String lpolClptIndSeq = "";
		String hiddenVvd = "";

		String lsDate = dbDao.searchSysdate();//현재시간

		try {
			StringBuffer flatFile = new StringBuffer();
			if (manifestTransmitVOs != null) {
				// searchVesselEta 를 위한 파라미터 변수VO
				VesselEtaCondCndVO vslCondVo = new VesselEtaCondCndVO();
				// StowageManifestDetailVO[] cvos 를 할당받아 형변환된 vo변수.
				StiDetailCndVO vo = new StiDetailCndVO();
				// searchVesselEta 의 결과를 담을 변수VO
				VesselEtaInfoCndVO vslVo = new VesselEtaInfoCndVO();
				// 컨테이너 번호별로 BayPlan데이터를 조회하기 위한 조회조건 VO.
				BayPlanCntrListConCndVO bayCondVo = new BayPlanCntrListConCndVO();
				// 컨테이너 번호별로 BayPlan데이터를 조회하기 위한 조회결과 VO.
				BayPlanCntrDetailCndVO bayDetailVo = new BayPlanCntrDetailCndVO();
				List<BayPlanCntrDetailCndVO>  bayCmVos = new ArrayList<BayPlanCntrDetailCndVO>();

				// Last Pol을 위한 조회결과 VO.
				BayPlanPolDetailVO bayPolDetailVo = new BayPlanPolDetailVO();

				// 컨테이너 번호별로 BayPlan데이터를 조회하기 위한 조회결과 VO들의 배열.
				// 두번째 루프에서 다시 컨테이너별 BayPlan을 조회하지 않고, 이 결과배열로 루프를 돌린다.
				BayPlanCntrDetailCndVO[] bayDetailVos = new BayPlanCntrDetailCndVO[manifestTransmitVOs.length];
				condVvd = ((StiDetailCndVO) manifestTransmitVOs[0]).getVvd();
				/*
				 * 조회시 skd_dir_cd가 "E" -> "W"바뀌는 경우가 있습니다.
				 * 로직은 조회 로직 참고 하세요
				 */
				searchVvdCd = ((StiDetailCndVO) manifestTransmitVOs[0]).getSearchVvdCd();
				pod = ((StiDetailCndVO) manifestTransmitVOs[0]).getPod();
				lastpol = ((StiDetailCndVO) manifestTransmitVOs[0]).getLPol();
				usrId = ((StiDetailCndVO) manifestTransmitVOs[0]).getTmp1();
				ofcCd = ((StiDetailCndVO) manifestTransmitVOs[0]).getTmp2();
				vpsPortCd = ((StiDetailCndVO) manifestTransmitVOs[0]).getVpsPortCd();
				//clptIndSeq = ((StiDetailCndVO) manifestTransmitVOs[0]).getClptIndSeq();
				lpolClptIndSeq = ((StiDetailCndVO) manifestTransmitVOs[0]).getLpolClptIndSeq();
				hiddenVvd = ((StiDetailCndVO) manifestTransmitVOs[0]).getHiddenVvd();
				for (int i = 0; i < manifestTransmitVOs.length; i++) {
					if (i == 0) {
						vslCondVo = new VesselEtaCondCndVO();
						vo = (StiDetailCndVO) manifestTransmitVOs[i];
						vslCondVo.setVvd(condVvd);
						vslCondVo.setLastpol(vo.getLPol());
						vslCondVo.setSndDt(lsDate);
						vslCondVo.setVpsPortCd(vpsPortCd);
						vslCondVo.setHiddenVvd(hiddenVvd);
						vslCondVo.setLpolClptIndSeq(lpolClptIndSeq);
						vslVo = dbDao.searchVesselEta(vslCondVo);

						/***************************************************
						 * CRN NO.가 없으면 에러처리인데 메시지가 안나온다.
						 ***************************************************/
						if (vslVo == null) throw new EventException(new ErrorHandler("BKG00841", new String[] {}).getMessage());
						if ( "".equals(vslVo.getCvyRefNo())) throw new EventException(new ErrorHandler("BKG06090").getMessage());

						bayCondVo = new BayPlanCntrListConCndVO();
						bayCondVo.setVvd(searchVvdCd);
						bayCondVo.setPol(lastpol);
						bayCondVo.setPod(pod);
						bayCondVo.setVpsPortCd(vpsPortCd);
						bayCondVo.setClptIndSeq(lpolClptIndSeq);
						bayCondVo.setCvyRefNo(vslVo.getCvyRefNo());
						bayPolDetailVo = dbDao.searchBayPlanPolInfo(bayCondVo);
						if (bayPolDetailVo == null) {
							fristPod = "";
							polEstDepDt = "";
							polActDepDt = "";
							fristCaEtaDt = "";
							originTran = "";
						} else {
							fristPod = bayPolDetailVo.getFristCaPort();
							polEstDepDt = bayPolDetailVo.getPolEstDepDt();
							polActDepDt = bayPolDetailVo.getPolActDepDt();
							fristCaEtaDt = bayPolDetailVo.getFristCaEtaDt();
							originTran	= bayPolDetailVo.getOriginTran();
						}


						usPortCd = vslVo.getCaPortCd();
						if ("Y".equals(originTran)) {
							flatFile.append("MSG_FUNC:").append("4").append("\n"); //CRN을 기준으로 보낸 내역이 있으면 4(update) 전송
						}else{
							flatFile.append("MSG_FUNC:").append("9").append("\n"); //CRN을 기준으로 보낸 내역이 없으면 9(original) 전송
						}

						flatFile.append("MSG_DATE:").append(vslVo.getCurrdate()).append("\n");
						flatFile.append("CARRIER_CD:").append(vslVo.getCrrCode()).append("\n");//추가
						flatFile.append("VSL_CD:").append(vslVo.getVslCd()).append("\n");
						flatFile.append("VOY:").append(vslVo.getSkdVoyNo()).append("\n");
						flatFile.append("DIR:").append(vslVo.getSkdDirCd()).append("\n");
						flatFile.append("CON_VVD:").append(vslVo.getConVvd()).append("\n");//추가
						flatFile.append("CALLSIGN:").append(vslVo.getCallSgnNo()).append("\n");
						flatFile.append("LLOYD_CD:").append(vslVo.getLloydNo()).append("\n");
						flatFile.append("VSL_NM:").append(vslVo.getVslEngNm()).append("\n");
						flatFile.append("CRN:").append(vslVo.getCvyRefNo()).append("\n");//추가
						flatFile.append("POL_ETD:").append(polEstDepDt).append("\n");//추가 필수X 마지막 Foreign Port에서 떠나는 Estimated Time of Depart
						flatFile.append("POL_ATD:").append(polActDepDt).append("\n");//추가	마지막 Foreign Port에서 떠난 Actual Time of Depart
						flatFile.append("POD_ETA:").append(fristCaEtaDt).append("\n");//추가 첫번째 Canadian Port에 도착하는 Estimated Time of Arrival
						flatFile.append("LAST_POL:").append(lastpol).append("\n");//추가
						flatFile.append("FIRST_POD:").append(fristPod).append("\n");//추가
					}

					bayCondVo = new BayPlanCntrListConCndVO();
					vo = (StiDetailCndVO) manifestTransmitVOs[i];
					bayCondVo.setVvd(searchVvdCd);
					bayCondVo.setPol(vo.getLPol());
					bayCondVo.setCntrNo(vo.getCntrNo());
					bayDetailVo = dbDao.searchBayPlanCntrList(bayCondVo);
					bayCmVos = dbDao.searchBayPlanCntrCmList(bayCondVo);
					if (bayDetailVo != null) {
						flatFile.append("{CNTR_INFO").append("\n");
						flatFile.append("CNTRNBR:").append(bayDetailVo.getCntrNo()).append("\n");
						flatFile.append("CNTRTYPE:").append(bayDetailVo.getCntrtype()).append("\n");
						flatFile.append("CNTR_LENGTH:").append(bayDetailVo.getXterLen()).append("\n");//추가
						flatFile.append("CNTR_LENGTH_UNIT:").append("CM").append("\n");//추가
						flatFile.append("CNTR_WIDTH:").append(bayDetailVo.getXterWdt()).append("\n");//추가
						flatFile.append("CNTR_WIDTH_UNIT:").append("CM").append("\n");//추가
						flatFile.append("CNTR_HEIGHT:").append(bayDetailVo.getXterHgt()).append("\n");//추가
						flatFile.append("CNTR_HEIGHT_UNIT:").append("CM").append("\n");//추가
						flatFile.append("FM_IND:").append(bayDetailVo.getFmInd()).append("\n");
						flatFile.append("CNTR_STATUS:").append(bayDetailVo.getCntrStatus()).append("\n");
						flatFile.append("EQA_UNIT:").append("\n");
						flatFile.append("EQA_VAL:").append("\n");
						flatFile.append("STW_POS:").append(bayDetailVo.getPos()).append("\n");
						flatFile.append("WGT_UNIT:").append("KGM").append("\n");
						flatFile.append("WGT_VAL:").append(bayDetailVo.getWgt()).append("\n");
						flatFile.append("OVF_IND:").append("\n");
						flatFile.append("OVF_VAL:").append("\n");
						flatFile.append("OVR_IND:").append("\n");
						flatFile.append("OVR_VAL:").append("\n");
						flatFile.append("OVLW_IND:").append("\n");
						flatFile.append("OVLW_VAL:").append("\n");
						flatFile.append("OVRW_IND:").append("\n");
						flatFile.append("OVRW_VAL:").append("\n");
						flatFile.append("OVH_IND:").append("\n");
						flatFile.append("OVH_VAL:").append("\n");

						for (int k = 0; k < bayCmVos.size(); k++) {
							flatFile.append("{DESC").append("\n");
							flatFile.append("DESC:").append(bayCmVos.get(k).getCntrMfGdsDesc()).append("\n");//추가
							flatFile.append("PKG_TOTAL:").append(bayCmVos.get(k).getPckQty()).append("\n");//추가
							flatFile.append("PKG_UNIT:").append(bayCmVos.get(k).getPckTpCd()).append("\n");//추가
							flatFile.append("}DESC").append("\n");
						}

						flatFile.append("TUNIT:").append(bayDetailVo.getTunit()).append("\n");
						flatFile.append("TEMP:").append(bayDetailVo.getTemp()).append("\n");
						flatFile.append("TEMP_MIN:").append("\n");
						flatFile.append("TEMP_MAX:").append("\n");
						flatFile.append("POR:").append(bayDetailVo.getPor()).append("\n");
						flatFile.append("POL:").append(bayDetailVo.getPol()).append("\n");
						flatFile.append("POD:").append(bayDetailVo.getPod()).append("\n");
						flatFile.append("DEL:").append(bayDetailVo.getDel()).append("\n");
						flatFile.append("REF_NO:").append("\n");

						if (bayDetailVo.getImdg() != "" ) {
							flatFile.append("{DANGER").append("\n");//추가
							flatFile.append("IMDG_CD:").append(bayDetailVo.getImdg()).append("\n");
							flatFile.append("PAGE:").append("\n");
							flatFile.append("UNNBR:").append(bayDetailVo.getUnno()).append("\n");
							flatFile.append("FLSH_UNIT:").append("\n");
							flatFile.append("FLSH_TEMP:").append("\n");
							flatFile.append("CLASS:").append("\n");
							flatFile.append("EMS:").append("\n");
							flatFile.append("MFAG:").append("\n");
							flatFile.append("DG_DESC:").append("").append("\n");//추가
							flatFile.append("}DANGER").append("\n");
						}
						// IMDG_CD(2),UNNBR(4) 값은 CoLoad_ed 컬럼에 있다.
						if (bayDetailVo.getCoLoaded() != "" ) {

							String strCoLoad = bayDetailVo.getCoLoaded();
							int num = strCoLoad.length()/6;

							int checkLen = 0;
							for (int q = 0; q < num; q++) {
								checkLen = q*6;
								bayDetailVo.setImdg(strCoLoad.substring(checkLen,checkLen+2));
								bayDetailVo.setUnno(strCoLoad.substring(checkLen+2,checkLen+6));

								flatFile.append("{DANGER").append("\n");//추가
								flatFile.append("IMDG_CD:").append(bayDetailVo.getImdg()).append("\n");
								flatFile.append("PAGE:").append("\n");
								flatFile.append("UNNBR:").append(bayDetailVo.getUnno()).append("\n");
								flatFile.append("FLSH_UNIT:").append("\n");
								flatFile.append("FLSH_TEMP:").append("\n");
								flatFile.append("CLASS:").append("\n");
								flatFile.append("EMS:").append("\n");
								flatFile.append("MFAG:").append("\n");
								flatFile.append("DG_DESC:").append("").append("\n");//추가
								flatFile.append("}DANGER").append("\n");
							}
						}

						flatFile.append("SCAC:").append(bayDetailVo.getScac()).append("\n");
						flatFile.append("}CNTR_INFO").append("\n");

					}
					// 조회결과를 배열에 Set up.
					bayDetailVos[i] = bayDetailVo;
				}

				//--------------------------------------------------------------- 삭제 코드
				// BKG_CSTMS_ADV_STWG_SND_LOG 입력을 위한 VO.
//				BookingUtil command = new BookingUtil();
//				String sEdiHeader = command.searchCstmsEdiHeaderNew("CA_BAPLIE");
//				flatFile.insert(0, sEdiHeader + "\n");
				
				String seq = dbDao.searchDateSeq();
				flatFile.insert(0, "$$$MSGSTART:SMLINE              RCCECECPP           BAPLIE    BKC" + seq+ "\n");
				
				SendDetailLogCndVO sendDetailLogVO = new SendDetailLogCndVO();
				sendDetailLogVO.setSndProcId("STW_CA");
//				sendDetailLogVO.setSeq(sEdiHeader.substring(62,77));
				sendDetailLogVO.setSeq(seq);
				sendDetailLogVO.setVvd(condVvd);
				sendDetailLogVO.setPol(lastpol);
				sendDetailLogVO.setUsrId(usrId);
				sendDetailLogVO.setOfcCd(ofcCd);
				sendDetailLogVO.setCntrCount(Integer.toString(manifestTransmitVOs.length));
				sendDetailLogVO.setSndDt(lsDate);
				sendDetailLogVO.setCvyRefNo(vslVo.getCvyRefNo());
				sendDetailLogVO.setHiddenVvd(hiddenVvd);
				// POD는 Row중 첫번째 POD로 지정한다. 이 방법은 추후 확인을 받아야 한다.
				// 조회조건상의 POD를 입력한다. 없으면 안 넣는다.
				sendDetailLogVO.setPod(pod);
				sendDetailLogVO.setCstmsPortCd(usPortCd);	// CSTMS_PORT_CD 칼럼 추가

				// BKG_CSTMS_ADV_STWG_SND_LOG 입력 실행.
				int result = dbDao.addStowageSendLog(sendDetailLogVO);
				if (result > 0) {
					StringTokenizer token = new StringTokenizer(flatFile.toString(), "\n");
					int i = 1;
					int j = 0; // 개행문자를 j 가 0보다 큰경우, 구문 앞에 추가한다.
					String tmpStr = "";
					String lineStr = "";
					StringBuffer lineBuf = new StringBuffer();
					while (token.hasMoreTokens()) {
						tmpStr = token.nextToken();
						if (j > 0) tmpStr = "\n" + tmpStr;
						lineStr = lineBuf.toString();
						lineBuf.append(tmpStr);
						// 4000Byte 까지 채운다.
						// tmpStr까지 합친 값이 3900바이트를 넘는다면, 이전까지 취합되었던 lineStr만을
						// 로그에 넣고, 다시 초기화 한다.
						if (lineBuf.length() > 3900) {
							sendDetailLogVO.setDtlSeq(i + "");
							sendDetailLogVO.setMsg(lineStr.trim());
							dbDao.addSendDetailLog(sendDetailLogVO);
							i++;
							lineBuf = new StringBuffer(tmpStr);
						}
						j++;
					}
					if (lineBuf.length() > 0) {
						sendDetailLogVO.setDtlSeq(i + "");
						sendDetailLogVO.setMsg(lineBuf.toString().trim());
						dbDao.addSendDetailLog(sendDetailLogVO);
					}
				}
				result = 0;
				SendLogDetailCndVO sendLogDetailVO = new SendLogDetailCndVO();
				// ams_stowplan Proc파일에서는 전달받은 컨테이너 번호를 다시 한번 루프돌려 조회하는 로직.
				// 그러나, 조회내용이 위에서 조회한 searchBayPlanCntrList 와 동일하므로 이를 생략하고, // 위에서 구한 bayDetailVos로 루프를 돌려 이후 로직을 구현한다.

				for (int i = 0; i < bayDetailVos.length; i++) {
					bayDetailVo = new BayPlanCntrDetailCndVO(); // 초기화.
					bayDetailVo = bayDetailVos[i];
					// BKG_CSTMS_ADV_STWG_CNTR 갱신및 입력을 위한 VO.
					sendLogDetailVO.setCntrNo(bayDetailVo.getCntrNo());
					sendLogDetailVO.setDel(bayDetailVo.getDel());
					sendLogDetailVO.setLastpol(lastpol);
					sendLogDetailVO.setOfcCd(ofcCd);
					sendLogDetailVO.setPod(bayDetailVo.getPod());
					sendLogDetailVO.setPol(bayDetailVo.getPol());
					sendLogDetailVO.setPos(bayDetailVo.getPos());
					sendLogDetailVO.setSeq(seq);
					sendLogDetailVO.setUsrId(usrId);
					sendLogDetailVO.setVvd(searchVvdCd);
					sendLogDetailVO.setCvyRefNo(vslVo.getCvyRefNo());
					sendLogDetailVO.setHiddenVvd(hiddenVvd);
					// BKG_CSTMS_ADV_STWG_CNTR 갱신 실행.
					result = dbDao.modifySendLogByCntr(sendLogDetailVO);
					if (result == 0) result = dbDao.addSendLogByCntr(sendLogDetailVO);
				}
			}

			/*********************************************
			 * // Message Send Start
			 *********************************************/
			BookingUtil command2 = new BookingUtil();
			FlatFileAckVO flatFileAckVO = null;
			SendFlatFileVO sendFlatFileVO = new SendFlatFileVO();
			sendFlatFileVO.setQueueNm(SubSystemConfigFactory.get("BKG.ALPSBKG_UBIZHJS_CANCUS.IBMMQ.QUEUE"));
			sendFlatFileVO.setFlatFile(flatFile.toString());
			flatFileAckVO = command2.sendFlatFile(sendFlatFileVO);
			if (flatFileAckVO.getAckStsCd().equals("E")) throw new EventException(new ErrorHandler("BKG00205", new String[] {}).getMessage());
			/*********************************************
			 * // Message Send End.
			 *********************************************/

//			System.out.println("★★★★★★★★★★★★★★★★★★★★★★★★");
//			System.out.println(flatFile.toString());
//			System.out.println("★★★★★★★★★★★★★★★★★★★★★★★★");

			return flatFile.toString();

		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);

		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * BAPLIE 수신메시지 저장
	 *
	 * @param CstmsRcvLogVO cstmsRcvLogVO
	 * @throws DAOException
	 *
	 */
	private void writeCstmsBaplieRcvLog(CstmsRcvLogVO cstmsRcvLogVO) throws DAOException {

		log.info("<<<<<<<<<< 2 writeCstmsBaplieRcvLog >>>>>>>>>>>>>>>>");
		CndCstmsRcvLogVO cndCstmsRcvLogVO = (CndCstmsRcvLogVO) cstmsRcvLogVO;
		String rcvMsg = cndCstmsRcvLogVO.getFlatFile();
		if (rcvMsg == null || rcvMsg.equals("")) return;

		String orgRefNo = getReceiveSingleItem(rcvMsg, "ORG_FF_REF_NO:", "\n");
		String msgVvd = getReceiveSingleItem(rcvMsg, "VVD:", "\n");
		//String msgCrn = getReceiveSingleItem(rcvMsg, "CRN:", "\n");
		String cstmsAckStsCd = getReceiveSingleItem(rcvMsg, "ACK_RESULT:", "\n");
		String cstmsAckCd = getReceiveSingleItem(rcvMsg, "ACK_CODE:", "\n"); // 1은 A 그리고 2는 R
		String cstmsAckDesc = getReceiveSingleItem(rcvMsg, "ACK_DESCRIPTION:", "\n");
		String rcvDt = getReceiveSingleItem(rcvMsg, "FILE_PROCESS_DATE:", "\n"); //201604081405

		BkgCstmsAdvRcvLogVO bkgCstmsAdvRcvLogVO = cndCstmsRcvLogVO.getBkgCstmsAdvRcvLogVOs().get(0);
		bkgCstmsAdvRcvLogVO.setRcvDt(rcvDt);
		String rcvSeq = dbDao.searchMaxRcvLogSeq(bkgCstmsAdvRcvLogVO);
		bkgCstmsAdvRcvLogVO.setRcvSeq(rcvSeq);

		BkgCstmsAdvRcvLogVO orgRefVO = dbDao.searchCusResDataBySndId(orgRefNo); // 수신 msg 의 ORG_FF_REF_NO로 관련 데이터 구하기
		if (orgRefVO != null) {
			bkgCstmsAdvRcvLogVO.setVslCd(orgRefVO.getVslCd());
			bkgCstmsAdvRcvLogVO.setSkdVoyNo(orgRefVO.getSkdVoyNo());
			bkgCstmsAdvRcvLogVO.setSkdDirCd(orgRefVO.getSkdDirCd());
			bkgCstmsAdvRcvLogVO.setPodCd(orgRefVO.getPodCd());
			bkgCstmsAdvRcvLogVO.setPolCd(orgRefVO.getPolCd());
		}else{ //해당하는 값이 존재하지 않을 때 수신한 msg로부터 Data를 획득해서 입력한다.
			bkgCstmsAdvRcvLogVO.setSkdVoyNo(msgVvd.substring(0,4)); //수신 msg의 VVD형식 : ex>0106E
			bkgCstmsAdvRcvLogVO.setSkdDirCd(msgVvd.substring(4,5));
		}

		String errorDesc = "";
		//{ERROR_DETAIL 있지만, CRN단위로 수신으로 여러개의 ERROR 불필요.
		List<String> errList = getReceiveMultiItem(rcvMsg, "\\{ERROR_DETAIL","}ERROR_DETAIL");
		if (errList != null && errList.size()> 0) {
			cstmsAckCd = getReceiveSingleItem(errList.get(0), "ERROR_RESULT:", "\n"); // 22 , 29
			errorDesc = getReceiveSingleItem(errList.get(0), "ERROR_CODE:", "\n");
		}

		//BKG_CSTMS_ADV_RCV_LOG insert
		bkgCstmsAdvRcvLogVO.setCstmsBatNo("");
		bkgCstmsAdvRcvLogVO.setCrrBatNo(orgRefNo);
		bkgCstmsAdvRcvLogVO.setCndAckSubCd(cstmsAckCd);
		bkgCstmsAdvRcvLogVO.setCndAckRcvId(cstmsAckStsCd);  //A or R
		bkgCstmsAdvRcvLogVO.setCstmsRjctMsg(errorDesc);
		bkgCstmsAdvRcvLogVO.setCndAckErrNoteDesc("");
		dbDao.addBkgCstmsAdvRcvLog(cndCstmsRcvLogVO.getBkgCstmsAdvRcvLogVOs());

		//BKG_CSTMS_ADV_RCV_LOG_DTL insert
		List<BkgCstmsAdvRcvLogDtlVO> bkgCstmsAdvRcvLogDtlVOs = new ArrayList<BkgCstmsAdvRcvLogDtlVO>();
		StringTokenizer token = new StringTokenizer(rcvMsg, "\n");
		token = new StringTokenizer(rcvMsg, "\n");
		int k = 0;
		while (token.hasMoreTokens()) {
			String str = token.nextToken();
			k++;

			BkgCstmsAdvRcvLogDtlVO bkgCstmsAdvRcvLogDtlVO  = new BkgCstmsAdvRcvLogDtlVO();
			bkgCstmsAdvRcvLogDtlVO.setCntCd(CountryCode.CA);
			bkgCstmsAdvRcvLogDtlVO.setIoBndCd("I");
			bkgCstmsAdvRcvLogDtlVO.setRcvDt(rcvDt);
			bkgCstmsAdvRcvLogDtlVO.setRcvSeq(rcvSeq);
			bkgCstmsAdvRcvLogDtlVO.setRcvMsgDtlSeq(Integer.toString(k));
			bkgCstmsAdvRcvLogDtlVO.setMsgDesc(str);
			bkgCstmsAdvRcvLogDtlVO.setCstmsBatNo(""); //BKG_CSTMS_ADV_RCV_LOG_DTL에는 해당 값을 Insert 하지 않는다.
			bkgCstmsAdvRcvLogDtlVO.setCreUsrId("BAPLIE_ACK");
			bkgCstmsAdvRcvLogDtlVO.setUpdUsrId("BAPLIE_ACK");
			bkgCstmsAdvRcvLogDtlVOs.add(bkgCstmsAdvRcvLogDtlVO);
		}
		dbDao.addBkgCstmsAdvRcvLogDtl(bkgCstmsAdvRcvLogDtlVOs);
		cndCstmsRcvLogVO.setBkgCstmsAdvRcvLogDtlVOs(bkgCstmsAdvRcvLogDtlVOs);

		//STOWAGE SEND LOG 테이블 업데이트
		SendDetailLogCndVO sendDetailLogVO  = new SendDetailLogCndVO();
		sendDetailLogVO.setCrrBatNo(orgRefNo);
		sendDetailLogVO.setCstmsAckStsCd(cstmsAckStsCd);
		sendDetailLogVO.setCstmsAckCd(cstmsAckCd);
		sendDetailLogVO.setCstmsAckDesc(cstmsAckDesc);
		sendDetailLogVO.setRcvDt(rcvDt);
		dbDao.modifyBaplieCusResSndLog(sendDetailLogVO);

		if (errList != null && errList.size()> 0) {
			sendDetailLogVO.setErrResult("R");
			sendDetailLogVO.setErrCode("");
			sendDetailLogVO.setErrDesc(errorDesc);
			sendDetailLogVO.setRcvDt(rcvDt);
			dbDao.modifyBaplieCusResByCntr(sendDetailLogVO);
		} else {
			//ERROR_DETAIL 없을 시 나머지 항목 모두 ACK로 업데이트
			dbDao.modifyBaplieCusResByVvd(sendDetailLogVO);
		}
		BkgCstmsAdvSndLogVO bkgCstmsAdvSndLogVO = new BkgCstmsAdvSndLogVO();
		ObjectCloner.build(sendDetailLogVO, bkgCstmsAdvSndLogVO);
		List<BkgCstmsAdvSndLogVO> bkgCstmsAdvSndLogVOList = new ArrayList<BkgCstmsAdvSndLogVO>();
		bkgCstmsAdvSndLogVOList.add(bkgCstmsAdvSndLogVO);
		cndCstmsRcvLogVO.setBkgCstmsAdvSndLogVOs(bkgCstmsAdvSndLogVOList);
	}

	/**
	 * loadCstmsRcvMsg에서 사용하는 내부 메소드<br>
	 * 수신메시지에서 각항목별 정보를 추출한다.<br>
	 *
	 * @param String src
	 * @param String prefix
	 * @param String endDelimeter
	 * @return String
	 */
	private String getReceiveSingleItem(String src, String prefix, String endDelimeter) {
		if (src == null) return "";
		String tmp ="";
		int index   = src.indexOf(prefix);
		if ( index >= 0) {
			tmp = src.substring(index+prefix.length());
			return JSPUtil.getNull(tmp.substring(0,tmp.indexOf(endDelimeter)).replace("\r",""));
		}
		return "";
	}

	/**
	 * loadCstmsRcvMsg에서 사용하는 내부 메소드<br>
	 * 수신메시지에서 각항목별 반복되는 정보를 추출한다.<br>
	 *
	 * @param String src
	 * @param String prefix
	 * @param String surfix
	 * @return List<String>
	 */
	private List<String> getReceiveMultiItem(String src, String prefix, String surfix) {
		String[] srcArr = src.split(prefix);
		List<String> rlist = null;
		if (srcArr.length > 1) {
			rlist = new ArrayList<String>();
			for (int i = 1; i < srcArr.length; i++) {
				rlist.add(srcArr[i].substring(0,srcArr[i].indexOf(surfix)));
			}
		}
		return rlist;
	}

	/**
	 * SendLog History
	 *
	 * @param CndCstmsSndHisListCondVO cndCstmsSndHisListCondVO
	 * @return List<CndCstmsSndHisVO>
	 * @throws EventException
	 */
	public List<CndCstmsSndHisVO> searchCndCstmsSndHisList(CndCstmsSndHisListCondVO cndCstmsSndHisListCondVO) throws EventException {
		try {
			return dbDao.searchCndCstmsSndHisList(cndCstmsSndHisListCondVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Receive History
	 *
	 * @param CstmsRcvHisListCondVO cstmsRcvHisListCondVO
	 * @return List<CstmsRcvHisVO>
	 * @throws EventException
	 */
	public List<CstmsRcvHisVO> searchCstmsRcvHisList(CstmsRcvHisListCondVO cstmsRcvHisListCondVO) throws EventException {
		try {
			return dbDao.searchCndCstmsRcvHisList((CndCstmsRcvHisListCondVO) cstmsRcvHisListCondVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}

}
