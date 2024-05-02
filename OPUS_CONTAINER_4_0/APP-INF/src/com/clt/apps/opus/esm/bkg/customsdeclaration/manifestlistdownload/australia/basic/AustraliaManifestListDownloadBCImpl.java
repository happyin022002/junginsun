/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AustraliaManifestListDownloadBCImpl.java
*@FileTitle : AustraliaManifestListDownloadBCImpl
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.11
*@LastModifier :
*@LastVersion : 1.0
* 2014.12.11
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.australia.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.australia.integration.AustraliaManifestListDownloadDBDAO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.australia.vo.AusResultCuscarVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.australia.vo.AusResultSeacrSumVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.australia.vo.AusSearchCuscarVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.australia.vo.ErrorReportVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.australia.vo.AusDgListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.australia.vo.AusDgListDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.australia.vo.AusSendHistoryCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.australia.vo.AusSendHistoryDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.australia.vo.AusSpecialContainerVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.syscommon.common.table.BkgCstmsAusSndLogVO;


/**
 * OPUS-AustraliaManifestListDownload Business Logic Basic Command implementation<br>
 * - OPUS-AustraliaManifestListDownload 대한 비지니스 로직을 처리한다.<br>
 *
 * @author
 * @see 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class AustraliaManifestListDownloadBCImpl extends BasicCommandSupport implements AustraliaManifestListDownloadBC {
	// Database Access Object
	private transient AustraliaManifestListDownloadDBDAO dbDao = null;

	/**
	 * AustraliaManifestListDownloadDBDAO 객체 생성
	 */
	public AustraliaManifestListDownloadBCImpl() {
		dbDao = new AustraliaManifestListDownloadDBDAO();
	}

	/**
	 * [ESM_BKG_1514] : CARLST
	 * [ESM_BKG_1517] : UBMREQ
	 * Australia Customs Cargo 목록 조회<br>
	 *
	 * @param AusSearchCuscarVO searchCuscarVO
	 * @return List<AusResultCuscarVO>
	 * @exception EventException
	 */
	public List<AusResultCuscarVO> searchAusCarlstUbmreq(AusSearchCuscarVO searchCuscarVO) throws EventException {
		try {
			return dbDao.searchAusCarlstUbmreq(searchCuscarVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_BKG_1516]
	 * Australia Sea Cargo Report - SEACR Summary 조회<br>
	 *
	 * @param AusSearchCuscarVO searchCuscarVO
	 * @return List<AusResultSeacrSumVO>
	 * @exception EventException
	 */
	public List<AusResultSeacrSumVO> searchAusSeacrSum(AusSearchCuscarVO searchCuscarVO) throws EventException {
		try {
			return dbDao.searchAusSeacrSum(searchCuscarVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_BKG_1516]
	 * Australia Sea Cargo Report - B/L 목록 조회<br>
	 *
	 * @param AusSearchCuscarVO searchCuscarVO
	 * @return List<AusResultCuscarVO>
	 * @exception EventException
	 */
	public List<AusResultCuscarVO> searchAusSeacrBl(AusSearchCuscarVO searchCuscarVO) throws EventException {
		try {
			return dbDao.searchAusSeacrBl(searchCuscarVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_BKG_1515]
	 * Transmit Result Error Report 목록 조회
	 *
	 * @param ErrorReportVO errorReportVO
	 * @return List<ErrorReportVO>
	 * @exception EventException
	 */
	public List<ErrorReportVO> searchErrorReport(ErrorReportVO errorReportVO) throws EventException {
		try {
			List<ErrorReportVO> ErrorReportVOList = new ArrayList<ErrorReportVO>();

			List<BkgCstmsAusSndLogVO> bkgCstmsAusSndLogVOList = dbDao.searchReceiveFlatFile(errorReportVO.getEdiRefId());
			if (bkgCstmsAusSndLogVOList.size() > 0) {
				String[] ediRcvMsgCtnt = bkgCstmsAusSndLogVOList.get(0).getEdiRcvMsgCtnt().replaceAll("\r\n", "\n").trim().split("\\{ERRORS");

				if (ediRcvMsgCtnt.length > 1) {

					ErrorReportVO returnReportVO = null;
					for (int i=1; i<ediRcvMsgCtnt.length; i++) {
						String[] errStringArray = ediRcvMsgCtnt[i].split("\n");
						if (errStringArray.length > 1) {
							String errCd = "";
							String errMsg = "";
							for (String errString : errStringArray) {
								if (errString.startsWith("ERR_CODE")) {
									String[] tmpStrArr = errString.split(":");
									if (tmpStrArr.length > 1) errCd = tmpStrArr[1].trim();
								}
								if (errString.startsWith("ERR_MSG")) {
									String[] tmpStrArr = errString.split(":");
									if (tmpStrArr.length > 1) errMsg = tmpStrArr[1].trim();
								}
							}
							returnReportVO = new ErrorReportVO();
							returnReportVO.setErrCd(errCd);
							returnReportVO.setErrMsg(errMsg);
							ErrorReportVOList.add(returnReportVO);
						}
					}
				}
			}
			return ErrorReportVOList;
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}


	/**
	 * 수출,수입, T/S, Barge별로 전송 대상을 조회한다.<br>
	 *
	 * @param AusDgListCondVO ausDgListCondVO
	 * @return List<AusDgListDetailVO>
	 * @throws EventException
	 */
	public List<AusDgListDetailVO> searchAusDgManifestList(AusDgListCondVO ausDgListCondVO) throws EventException {
		AusSpecialContainerVO ausSpecialContainerVO = new AusSpecialContainerVO();
		List<AusDgListDetailVO> retVOList = new ArrayList<AusDgListDetailVO>();

		try {
			/*
			 * Lloyd, vessel name등 Vessel 정보를 조회해옴-(Booking 쪽 data),
			 *  도착일시/출발일시 정보를 Local 운항스케쥴에서 조회함-(Booking 쪽 data)
			 */
			List<AusDgListDetailVO> vslInfoList = dbDao.serachAusVslAtCommon(ausDgListCondVO);
			if (vslInfoList != null && vslInfoList.size() > 0) {
				ausSpecialContainerVO.setAusVslInfo(vslInfoList.get(0));
			}

			// booking쪽 위험물 데이타를 조회
			ausDgListCondVO.setAppendFlag("N");
			List<AusDgListDetailVO> ausDetailList = dbDao.searchAusDgInfoAtBkgDg(ausDgListCondVO);
			if (ausDetailList != null && ausDetailList.size() > 0) {
				ausSpecialContainerVO.setAusDetailList(ausDetailList);
			}

			retVOList.add(ausSpecialContainerVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {} ).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {} ).getMessage(), ex);
		}
		return retVOList;
	}

	/**
	 * 위험물 Sent결과를 조회해 온다.<br>
	 *
	 * @param  AusSendHistoryCondVO ausSendHistoryCondVO
	 * @return List<AusSendHistoryDetailVO>
	 * @throws EventException
	 */
	public List<AusSendHistoryDetailVO> searchAusSendHistory(AusSendHistoryCondVO ausSendHistoryCondVO) throws EventException {
		try {
			return dbDao.searchAusSendHistoryByCntrNo(ausSendHistoryCondVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {} ).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {} ).getMessage(), ex);
		}
	}

	/**
	 * B/L No.로 BKG의 위험물 테이블에서 데이타를 조회해온다.<br>
	 *
	 * @param AusDgListCondVO ausDgListCondVO
	 * @return List<AusDgListDetailVO>
	 * @throws EventException
	 */
	public List<AusDgListDetailVO> searchAusDgInfoAtBkgDgByBlNo(AusDgListCondVO ausDgListCondVO) throws EventException {
		try {
			return dbDao.searchAusDgInfoAtBkgDg(ausDgListCondVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {} ).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {} ).getMessage(), ex);
		}
	}

}
