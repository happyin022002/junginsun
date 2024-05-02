/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : UsaCustomsReportDAO.java
 *@FileTitle : 
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.06.01
 *@LastModifier : 이수빈
 *@LastVersion : 1.0
 * 2009.06.01 이수빈
 * 1.0 Creation
 * 
 * 2011.07.06 민정호 [CHM-201111866] US AMS : AMS Report 의 general의 조회 기능 보완
 * 2011.07.15 민정호 [CHM-201111822] Split 05-R4J Rule Upgrade 관련 소스품질 향상을 위한 조치 건
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.usa.integration;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import com.clt.apps.opus.esm.bkg.common.CountryCode;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.usa.vo.BaplieMonitorCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.usa.vo.ContainerDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.usa.vo.DispoCdDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.usa.vo.LocCdVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.usa.vo.MiTransmitHistoryCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.usa.vo.RailHistoryDetailListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.usa.vo.RailHistoryListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.usa.vo.RcvHistListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.usa.vo.RcvHistListDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.usa.vo.ReceivedFileCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.usa.vo.ReceivedFileDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.usa.vo.ScacReportCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.usa.vo.TransmissionChkListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.usa.vo.UsaAmsReportBaplieListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.usa.vo.UsaAmsReportIsf5ListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.usa.vo.UsaAmsReportListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.usa.vo.UsaAmsReportListDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.usa.vo.UsaCheckListDetailListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.usa.vo.UsaMiTransmitHistoryDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.usa.vo.UsaScacReportDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.usa.vo.UsaTransmitHistFileCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.usa.vo.UsaTransmitHistFileDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.usa.vo.UsaTransmitHistListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.usa.vo.UsaTransmitHistListDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.usa.vo.UsaVesselArrivalCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.usa.vo.UsaVesselArrivalDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.vo.AmsReportListDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.vo.RcvHistDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.vo.ReceiveLogDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.vo.ScacReportDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.vo.TransmitHistFileCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.vo.TransmitHistFileDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.vo.TransmitHistListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.vo.TransmitHistListDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.integration.UsaCustomsTransmissionDBDAOsearchMinClptSeqRSQL;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.syscommon.common.table.MdmLocationVO;

/**
 * ALPS CustomsTransmissionDAO <br>
 * - ALPS-customsreport system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Do-Wan, Kim
 * @see KoreaCustomsReportBCImpl 참조
 * @since J2EE 1.4
 */
public class UsaCustomsReportDBDAO extends DBDAOSupport {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * NVOCC가 전송한 신고내역에 대한 조회
	 * 
	 * @param ScacReportCondVO scacReportCondVO
	 * @return List<ScacReportDetailVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ScacReportDetailVO> searchScacReport(ScacReportCondVO scacReportCondVO) throws DAOException {
		List<ScacReportDetailVO> list = null;
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			if (scacReportCondVO != null)
			{
				Map<String, String> mapVO = scacReportCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("DEFAULT").executeQuery(
					(ISQLTemplate) new UsaCustomsReportDBDAOsearchScacReportRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, UsaScacReportDetailVO.class);
		}
		catch (SQLException se)
		{
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch (Exception ex)
		{
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * LocCd에 대한 ams_port_cd를 구한다.
	 * 
	 * @param String locCd
	 * @return String
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public String searchAmsPodCdByLocCd(String locCd) throws DAOException {
		String loc_cd = "";
		List<LocCdVO> list = null;
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			if (locCd != null)
			{
				param.put("pod", locCd);
				velParam.put("pod", locCd);
			}
			dbRowset = new SQLExecuter("DEFAULT").executeQuery(
					(ISQLTemplate) new UsaCustomsReportDBDAOsearchAmsPodCdByLocCdRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, LocCdVO.class);
			if (list != null)
			{
				if (list.size() > 0)
				{
					LocCdVO rtn = list.get(0);
					loc_cd = rtn.getLocAmsPortCd();
				}
			}
		}
		catch (SQLException se)
		{
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch (Exception ex)
		{
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return loc_cd;
	}

	/**
	 * IE(63) 신고 대상 조회를 위해 MI 전송 현황을 보여 준다.
	 * 
	 * @param MiTransmitHistoryCondVO miTransmitHistoryCondVO
	 * @return List<AmsReportListDetailVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<AmsReportListDetailVO> searchMiTransmitHistoryForIE(MiTransmitHistoryCondVO miTransmitHistoryCondVO)
			throws DAOException {
		List<AmsReportListDetailVO> list = null;
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			if (miTransmitHistoryCondVO != null)
			{
				String gubunVal = miTransmitHistoryCondVO.getGubun();
				if (gubunVal.equals("0"))
				{
					miTransmitHistoryCondVO.setFromd("");
					miTransmitHistoryCondVO.setTod("");
				}
				else
				{
					miTransmitHistoryCondVO.setVvd("");
				}
				Map<String, String> mapVO = miTransmitHistoryCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("DEFAULT").executeQuery(
					(ISQLTemplate) new UsaCustomsReportDBDAOsearchMiTransmitHistoryForIERSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, UsaMiTransmitHistoryDetailVO.class);
		}
		catch (SQLException se)
		{
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch (Exception ex)
		{
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * 수신내역을 조회한다.
	 * 
	 * @param RcvHistListCondVO rcvHistListCondVO
	 * @return List<RcvHistDetailVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RcvHistDetailVO> searchReceivedHistoryList(RcvHistListCondVO rcvHistListCondVO) throws DAOException {
		List<RcvHistDetailVO> list = null;
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			if (rcvHistListCondVO != null)
			{
				String gubunVal = rcvHistListCondVO.getGubun();
				if (!gubunVal.equals("on"))
				{
					rcvHistListCondVO.setFromd("");
					rcvHistListCondVO.setTod("");
				}
				Map<String, String> mapVO = rcvHistListCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				param.put("cnt_cd", CountryCode.US);
				velParam.put("cnt_cd", CountryCode.US);
				int pageNo = Integer.parseInt("".equals(rcvHistListCondVO.getPageNo()) ? "1" : rcvHistListCondVO
						.getPageNo());
				int pageRows = Integer.parseInt("".equals(rcvHistListCondVO.getPagerows()) ? "100" : rcvHistListCondVO
						.getPagerows());
				int pageEndNo = Integer.parseInt("".equals(rcvHistListCondVO.getEndNo()) ? "0" : rcvHistListCondVO
						.getEndNo());
//				int startNo = (pageNo - 1) * pageRows + 1;
//				int endNo = pageNo * pageRows;
				int startNo = 0;
				int endNo = 0;
				startNo = (pageNo * pageRows) - pageRows + 1;
				endNo = startNo + pageRows - 1;
				
				// 마지막 행까지 조회
				if(pageEndNo > 0) {
					if(endNo < pageEndNo) {
						endNo = pageEndNo;
					}
				}
				
				param.put("io_bnd_cd", "");
				param.put("start_no", startNo);
				param.put("end_no", endNo);
				
			}
			dbRowset = new SQLExecuter("DEFAULT").executeQuery(
					(ISQLTemplate) new UsaCustomsReportDBDAOsearchReceivedHistoryListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RcvHistListDetailVO.class);
			if (list != null && list.size() > 0)
			{
				RcvHistListDetailVO detailVO = (RcvHistListDetailVO) list.get(0);
				detailVO.setMaxRows(Integer.parseInt(detailVO.getTotal()));
			}
		}
		catch (SQLException se)
		{
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch (Exception ex)
		{
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * 수신 로그의 F/File 을 조회한다.
	 * 
	 * @param ReceivedFileCondVO receivedFileCondVO
	 * @return List<ReceiveLogDetailVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ReceiveLogDetailVO> searchReceivedFile(ReceivedFileCondVO receivedFileCondVO) throws DAOException {
		List<ReceiveLogDetailVO> list = null;
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			if (receivedFileCondVO != null)
			{
				Map<String, String> mapVO = receivedFileCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				param.put("cnt_cd", CountryCode.US);
				velParam.put("cnt_cd", CountryCode.US);
			}
			dbRowset = new SQLExecuter("DEFAULT").executeQuery(
					(ISQLTemplate) new UsaCustomsReportDBDAOsearchReceivedFileRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, ReceivedFileDetailVO.class);
		}
		catch (SQLException se)
		{
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch (Exception ex)
		{
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * 송신 로그를 조회한다.
	 * 
	 * @param TransmitHistListCondVO transmitHistListCondVO
	 * @return List<TransmitHistListDetailVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<TransmitHistListDetailVO> searchTransmitHistoryList(TransmitHistListCondVO transmitHistListCondVO)
			throws DAOException {
		List<TransmitHistListDetailVO> list = null;
		UsaTransmitHistListCondVO condVo = (UsaTransmitHistListCondVO) transmitHistListCondVO;
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String trsmMsgTp = null;
		try
		{
			if (condVo != null)
			{
				String gubunVal = condVo.getGubun();
				if (!gubunVal.equals("on"))
				{
					condVo.setSndFromd("");
					condVo.setSndTod("");
				}
				Map<String, String> mapVO = condVo.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				param.put("cnt_cd", CountryCode.US);
				velParam.put("cnt_cd", CountryCode.US);
				int pageNo = Integer.parseInt("".equals(condVo.getPageNo()) ? "1" : condVo.getPageNo());
				int pageRows = Integer.parseInt("".equals(condVo.getPagerows()) ? "100" : condVo.getPagerows());
				int startNo = (pageNo - 1) * pageRows + 1;
				int endNo = pageNo * pageRows;
				param.put("start_no", startNo);
				param.put("end_no", endNo);
				velParam.put("start_no", startNo);
				velParam.put("end_no", endNo);
				trsmMsgTp = condVo.getTrsmMsgTpId();
			}
			dbRowset = new SQLExecuter("DEFAULT").executeQuery(
					(ISQLTemplate) new UsaCustomsReportDBDAOsearchTransmitHistoryList3RSQL(), param, velParam);
			
//			if ("AL".equals(trsmMsgTp))
//			{
//				dbRowset = new SQLExecuter("DEFAULT").executeQuery(
//						(ISQLTemplate) new UsaCustomsReportDBDAOsearchTransmitHistoryList3RSQL(), param, velParam);
//			}
//			else if ("N".equals(condVo.getOfmFlg()) && ("BA".equals(trsmMsgTp) || "SN".equals(trsmMsgTp)))
//			{
//				dbRowset = new SQLExecuter("DEFAULT").executeQuery(
//						(ISQLTemplate) new UsaCustomsReportDBDAOsearchTransmitHistoryList2RSQL(), param, velParam);
//			}
//			else
//			{
//				dbRowset = new SQLExecuter("DEFAULT").executeQuery(
//						(ISQLTemplate) new UsaCustomsReportDBDAOsearchTransmitHistoryListRSQL(), param, velParam);
//			}
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, UsaTransmitHistListDetailVO.class);
			if (list != null && list.size() > 0)
			{
				UsaTransmitHistListDetailVO detailVO = (UsaTransmitHistListDetailVO) list.get(0);
				detailVO.setMaxRows(Integer.parseInt(detailVO.getTotal()));
			}
		}
		catch (SQLException se)
		{
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch (Exception ex)
		{
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * 송신 로그의 F/File 을 조회한다.
	 * 
	 * @param TransmitHistFileCondVO transmitHistFileCondVO
	 * @return List<TransmitHistFileDetailVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<TransmitHistFileDetailVO> searchTransmitHistoryFile(TransmitHistFileCondVO transmitHistFileCondVO)
			throws DAOException {
		List<TransmitHistFileDetailVO> list = null;
		UsaTransmitHistFileCondVO condVo = (UsaTransmitHistFileCondVO) transmitHistFileCondVO;
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String trsmMsgTp = null;
		try
		{
			if (condVo != null)
			{
				Map<String, String> mapVO = condVo.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				param.put("cnt_cd", CountryCode.US);
				velParam.put("cnt_cd", CountryCode.US);
				trsmMsgTp = condVo.getTrsmMsgTpId();
			}
			if ("BAPLIE".equals(trsmMsgTp) || "ISF-5".equals(trsmMsgTp))
			{
				dbRowset = new SQLExecuter("DEFAULT").executeQuery(
						(ISQLTemplate) new UsaCustomsReportDBDAOsearchTransmitHistoryFile2RSQL(), param, velParam);
			}
			else
			{
				dbRowset = new SQLExecuter("DEFAULT").executeQuery(
						(ISQLTemplate) new UsaCustomsReportDBDAOsearchTransmitHistoryFileRSQL(), param, velParam);
			}
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, UsaTransmitHistFileDetailVO.class);
		}
		catch (SQLException se)
		{
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch (Exception ex)
		{
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * 컨테이너 넘버로 B/L내역을 조회
	 * 
	 * @param String cntrNo
	 * @param String vvd
	 * @param String blType
	 * @return List<ContainerDetailVO>
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public List<ContainerDetailVO> searchBlListByCntrNo(String cntrNo, String vvd, String blType) throws DAOException {
		List<ContainerDetailVO> list = null;
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			param.put("cntr_no", cntrNo);
			velParam.put("cntr_no", cntrNo);
			param.put("vvd", vvd);
			velParam.put("vvd", vvd);
			param.put("blType", blType);
			velParam.put("blType", blType);
			dbRowset = new SQLExecuter("DEFAULT").executeQuery(
					(ISQLTemplate) new UsaCustomsReportDBDAOsearchBlListByCntrNoRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, ContainerDetailVO.class);
		}
		catch (SQLException se)
		{
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch (Exception ex)
		{
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * 0359 Manifest Status 내역을 조회.
	 * 
	 * @param TransmissionChkListCondVO transmissionChkListCondVO
	 * @return List<UsaCheckListDetailListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<UsaCheckListDetailListVO> searchTransmissionCheckListByVVD(
			TransmissionChkListCondVO transmissionChkListCondVO) throws DAOException {
		List<UsaCheckListDetailListVO> list = null;
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			if (transmissionChkListCondVO != null)
			{
				Map<String, String> mapVO = transmissionChkListCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				// Vessel 스케줄 조회
				param.put("vvd_cd", transmissionChkListCondVO.getVvd());
				velParam.put("vvd_cd", transmissionChkListCondVO.getVvd());
				dbRowset = new SQLExecuter("").executeQuery(
						(ISQLTemplate) new UsaCustomsTransmissionDBDAOsearchMinClptSeqRSQL(), param, velParam);
				if (dbRowset.next())
				{
					param.put("min_seq", dbRowset.getString(1));
					velParam.put("min_seq", dbRowset.getString(1));
				}
			}
			dbRowset = new SQLExecuter("DEFAULT").executeQuery(
					(ISQLTemplate) new UsaCustomsReportDBDAOsearchTransmissionCheckListByVVDRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, UsaCheckListDetailListVO.class);
		}
		catch (SQLException se)
		{
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch (Exception ex)
		{
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * 0359_1 B/L to be deleted 내역을 조회.
	 * 
	 * @param TransmissionChkListCondVO transmissionChkListCondVO
	 * @return List<UsaCheckListDetailListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<UsaCheckListDetailListVO> searchToBeDeletedList(TransmissionChkListCondVO transmissionChkListCondVO)
			throws DAOException {
		List<UsaCheckListDetailListVO> list = null;
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			if (transmissionChkListCondVO != null)
			{
				Map<String, String> mapVO = transmissionChkListCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				// Vessel 스케줄 조회
				param.put("vvd_cd", transmissionChkListCondVO.getVvd());
				velParam.put("vvd_cd", transmissionChkListCondVO.getVvd());
				dbRowset = new SQLExecuter("").executeQuery(
						(ISQLTemplate) new UsaCustomsTransmissionDBDAOsearchMinClptSeqRSQL(), param, velParam);
				if (dbRowset.next())
				{
					param.put("min_seq", dbRowset.getString(1));
					velParam.put("min_seq", dbRowset.getString(1));
				}
			}
			dbRowset = new SQLExecuter("DEFAULT").executeQuery(
					(ISQLTemplate) new UsaCustomsReportDBDAOsearchToBeDeletedListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, UsaCheckListDetailListVO.class);
		}
		catch (SQLException se)
		{
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch (Exception ex)
		{
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * 0359에서 VVD, POL 입력후 Focus out할시 ETA를 조회한다.
	 * 
	 * @param UsaVesselArrivalCondVO usaVesselArrivalCondVO
	 * @return List<UsaVesselArrivalDetailVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<UsaVesselArrivalDetailVO> searchVesselEta(UsaVesselArrivalCondVO usaVesselArrivalCondVO)
			throws DAOException {
		List<UsaVesselArrivalDetailVO> list = null;
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			if (usaVesselArrivalCondVO != null)
			{
				Map<String, String> mapVO = usaVesselArrivalCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("DEFAULT").executeQuery(
					(ISQLTemplate) new UsaCustomsReportDBDAOsearchVesselEtaRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, UsaVesselArrivalDetailVO.class);
		}
		catch (SQLException se)
		{
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch (Exception ex)
		{
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * Mail : Disposition 코드 리스트를 조회한다.
	 * 
	 * @return List<DispoCdDetailVO>
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public List<DispoCdDetailVO> searchUsaDespositionCdList() throws DAOException {
		List<DispoCdDetailVO> list = null;
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			dbRowset = new SQLExecuter("DEFAULT").executeQuery(
					(ISQLTemplate) new UsaCustomsReportDBDAOsearchUsaDespositionCdListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, DispoCdDetailVO.class);
		}
		catch (SQLException se)
		{
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch (Exception ex)
		{
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * 0041에서 VVD, POL 입력후 Focus out할시 ETA를 조회한다.
	 * 
	 * @param UsaAmsReportListCondVO usaAmsReportListCondVO
	 * @return List<AmsReportListDetailVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<AmsReportListDetailVO> searchAmsReportListbyDate(UsaAmsReportListCondVO usaAmsReportListCondVO) throws DAOException {
		List<AmsReportListDetailVO> list2 = new ArrayList<AmsReportListDetailVO>();
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {

			Map<String, String> mapVO = usaAmsReportListCondVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			int pageNo = Integer.parseInt("".equals(usaAmsReportListCondVO.getPageNo()) ? "1" : usaAmsReportListCondVO.getPageNo());
			int pageRows = Integer.parseInt("".equals(usaAmsReportListCondVO.getPagerows()) ? "1000" : usaAmsReportListCondVO.getPagerows());
			int startNo = (pageNo - 1) * pageRows + 1;
			int endNo = pageNo * pageRows;
			// tmp4에 Total RowCount가 있는 경우, 마지막 까지 조회를 실행한다.
			if (!"".equals(usaAmsReportListCondVO.getTmp4())) {
				endNo = Integer.parseInt(usaAmsReportListCondVO.getTmp4());
			}
			param.put("start_no", startNo);
			param.put("end_no", endNo);
			velParam.put("start_no", startNo);
			velParam.put("end_no", endNo);

			String sEqOfc = usaAmsReportListCondVO.getEqOfc();

			List<String> eqOfcList = new ArrayList<String>();
			StringTokenizer st = new StringTokenizer(sEqOfc, ",");

			while (st.hasMoreTokens()) {
				eqOfcList.add(st.nextToken());
			}
			velParam.put("vel_eq_ofc", eqOfcList);

			if ("ISF5".equals(usaAmsReportListCondVO.getGeneralOrRail())) {
				if ("".equals(usaAmsReportListCondVO.getDateSearch())) {
					dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new UsaCustomsReportDBDAOsearchMinClptSeqRSQL(), param,
							velParam);
					if (dbRowset.next()) {
						param.put("clpt_seq", dbRowset.getString(1));
						param.put("vsl_cd", dbRowset.getString(2));
						param.put("skd_voy_no", dbRowset.getString(3));
						param.put("skd_dir_cd", dbRowset.getString(4));
					}
				}
				dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new UsaCustomsReportDBDAOsearchUsaAmsReportIsf5ListRSQL(), param,
						velParam);
				list2 = (List) RowSetUtil.rowSetToVOs(dbRowset, UsaAmsReportIsf5ListVO.class);
			} else if ("GENERAL".equals(usaAmsReportListCondVO.getGeneralOrRail()) || "RAILAMS".equals(usaAmsReportListCondVO.getGeneralOrRail())) {
				dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new UsaCustomsReportDBDAOsearchAmsReportListbyDateRSQL(), param,
						velParam);
				list2 = (List) RowSetUtil.rowSetToVOs(dbRowset, UsaAmsReportListDetailVO.class);
				String blNo = usaAmsReportListCondVO.getLastBl();
				int iBlCnt = 0;
				String sLastBlCnt = usaAmsReportListCondVO.getLastRnum();
				if (sLastBlCnt != null && !"".equals(sLastBlCnt))
					iBlCnt = Integer.parseInt(sLastBlCnt);
				for (int i = 0; i < list2.size(); i++) {
					UsaAmsReportListDetailVO vo = (UsaAmsReportListDetailVO) list2.get(i);
					list2.get(0).setMaxRows(Integer.parseInt(vo.getTotal()));
					if (!blNo.equals(vo.getAmsFileNo())) {
						blNo = vo.getAmsFileNo();
						iBlCnt++;
						vo.setSeq("" + iBlCnt);
					} else {
						vo.setSeq("" + iBlCnt);
					}
				}
			} else {
				// BAPLIE
				dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new UsaCustomsReportDBDAOsearchAmsReportBaplieListRSQL(), param,
						velParam);
				list2 = (List) RowSetUtil.rowSetToVOs(dbRowset, UsaAmsReportBaplieListVO.class);
			}
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list2;
	}

	/**
	 * 1037에서 컨테이너에 대한 PARTIAL BL LIST를 조회한다.
	 * 
	 * @param RailHistoryListCondVO railHistoryListCondVO
	 * @return List<RailHistoryDetailListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RailHistoryDetailListVO> searchBlListByCntr(RailHistoryListCondVO railHistoryListCondVO)
			throws DAOException {
		List<RailHistoryDetailListVO> list = null;
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			if (railHistoryListCondVO != null)
			{
				Map<String, String> mapVO = railHistoryListCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("DEFAULT").executeQuery(
					(ISQLTemplate) new UsaCustomsReportDBDAOsearchBlListByCntrRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RailHistoryDetailListVO.class);
		}
		catch (SQLException se)
		{
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch (Exception ex)
		{
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * 1037에서 컨테이너, BL에 대한 HISTORY HEADER를 조회한다.
	 * 
	 * @param RailHistoryListCondVO railHistoryListCondVO
	 * @return List<RailHistoryDetailListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RailHistoryDetailListVO> searchRailHistoryHeader(RailHistoryListCondVO railHistoryListCondVO)
			throws DAOException {
		List<RailHistoryDetailListVO> list = null;
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			if (railHistoryListCondVO != null)
			{
				Map<String, String> mapVO = railHistoryListCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("DEFAULT").executeQuery(
					(ISQLTemplate) new UsaCustomsReportDBDAOsearchRailHistoryHeaderRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RailHistoryDetailListVO.class);
		}
		catch (SQLException se)
		{
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch (Exception ex)
		{
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * 1037에서 컨테이너, BL에 대한 RAIL AMS HISTORY 내역를 조회한다.
	 * 
	 * @param RailHistoryListCondVO railHistoryListCondVO
	 * @return List<RailHistoryDetailListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RailHistoryDetailListVO> searchRailHistoryListByCntr(RailHistoryListCondVO railHistoryListCondVO)
			throws DAOException {
		List<RailHistoryDetailListVO> list = null;
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			if (railHistoryListCondVO != null)
			{
				Map<String, String> mapVO = railHistoryListCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("DEFAULT").executeQuery(
					(ISQLTemplate) new UsaCustomsReportDBDAOsearchRailHistoryListByCntrRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RailHistoryDetailListVO.class);
		}
		catch (SQLException se)
		{
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch (Exception ex)
		{
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * 미국 현재 날짜 가져오기<br>
	 * 
	 * @return String
	 * @exception DAOException
	 */
	public String searchUsaSysdate() throws DAOException {
		DBRowSet dbRowset = null;
		String today = null;
		try
		{
			dbRowset = new SQLExecuter("DEFAULT").executeQuery(
					(ISQLTemplate) new UsaCustomsReportDBDAOsearchUsaSysdateRSQL(), null, null);
			if (dbRowset.next())
				today = dbRowset.getString(1);
		}
		catch (SQLException se)
		{
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch (Exception ex)
		{
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return today;
	}
	
	/**
	 * 미세관 VVD별 BAPLIE Manifest (Vessel Stowage Plan) 전송 현황 report 조회
	 * 
	 * @param BaplieMonitorCondVO baplieMonitorCondVO
	 * @return List<BaplieMonitorCondVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BaplieMonitorCondVO> searchBaplieMonitor(BaplieMonitorCondVO baplieMonitorCondVO) throws DAOException {
		List<BaplieMonitorCondVO> list = null;
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try	{

			Map<String, String> mapVO = baplieMonitorCondVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("DEFAULT").executeQuery(
					(ISQLTemplate) new UsaCustomsReportDBDAOsearchBaplieMonitorRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, BaplieMonitorCondVO.class);
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	/**
	 * 미세관 VVD별 BAPLIE Manifest (Vessel Stowage Plan) 전송 현황 report 조회
	 * 
	 * @param String vvd
	 * @return String crrCd
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BaplieMonitorCondVO> searchUsLastForeignPort(String vvd) throws DAOException {
		List<BaplieMonitorCondVO> list = null;
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try	{

			param.put("vvd", vvd);
			velParam.put("vvd", vvd);
			dbRowset = new SQLExecuter("DEFAULT").executeQuery(
					(ISQLTemplate) new UsaCustomsReportDBDAOsearchUsLastForeignPortRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, BaplieMonitorCondVO.class);
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	/**
	 * EQ Control OFC Cd 코드 리스트를 조회한다.
	 * 
	 * @return List<EqCtrlOfcCdVO>
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public List<MdmLocationVO> searchEQCtrlOfcCdList() throws DAOException {
		List<MdmLocationVO> list = null;
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try
		{
			dbRowset = new SQLExecuter("DEFAULT").executeQuery(
					(ISQLTemplate) new UsaCustomsReportDBDAOsearchEQCtrlOfcCdListRSQL(), param, null, true);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, MdmLocationVO.class);
		}
		catch (SQLException se)
		{
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch (Exception ex)
		{
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}	
}