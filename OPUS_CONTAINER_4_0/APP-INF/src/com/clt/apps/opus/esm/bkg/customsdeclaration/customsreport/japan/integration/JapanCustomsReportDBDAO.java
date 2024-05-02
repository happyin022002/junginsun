/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : JapanManifestListDownloadDBDAO.java
 *@FileTitle : UI_BKG-0462
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.18
 *@LastModifier : 김승민
 *@LastVersion : 1.0
 * 2009.05.18 김승민
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.japan.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.japan.vo.JapanManifestListReceiveHistDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.japan.vo.JapanManifestListTransmitHistDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.japan.vo.JapanRcvHistCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.japan.vo.JapanReceiveLogCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.japan.vo.JapanSendLogCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.japan.vo.JapanTransmitHistCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.basic.JapanManifestListDownloadBCImpl;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;


/**
 * OPUS JapanManifestListDownloadDBDAO <br>
 * - OPUS-CustomsDeclaration system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author KIM SEUNG MIN
 * @see JapanManifestListDownloadBCImpl 참조
 * @since J2EE 1.4
 */
@SuppressWarnings("serial")
public class JapanCustomsReportDBDAO  extends DBDAOSupport {


	/**
	 * 일본세관으로 전송한 Manifest 내용을 조회한다.<br>
	 *
	 * @param JapanSendLogCondVO japanSendLogCondVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchJpcusSendLog(JapanSendLogCondVO japanSendLogCondVO) throws DAOException {
		StringBuffer ediSndMsg = new StringBuffer();
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (japanSendLogCondVO != null) {
				Map<String, String> mapVO = japanSendLogCondVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JapanCustomsReportDBDAOsearchJpcusSendLogRSQL(), param, velParam, true);
			while(dbRowset.next()) {
				ediSndMsg.append(dbRowset.getString("EDI_SND_MSG"));
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return ediSndMsg.toString();
	}

	/**
	 * 일본세관으로부터 수신한 Manifest 내용을 조회한다.<br>
	 *
	 * @param JapanReceiveLogCondVO japanReceiveLogCondVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchJpcusReceiveLog(JapanReceiveLogCondVO japanReceiveLogCondVO) throws DAOException {
		StringBuffer ediSndMsg = new StringBuffer();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (japanReceiveLogCondVO != null) {
				Map<String, String> mapVO = japanReceiveLogCondVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JapanCustomsReportDBDAOsearchJpcusReceiveLogRSQL(), param, velParam);
			while(dbRowset.next()) {
				ediSndMsg.append(dbRowset.getString("EDI_RCV_MSG_CTNT"));
			}
		} catch(SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return ediSndMsg.toString();
	}

	/**
	 * 일본세관으로 전송한 History를 조회한다.<br>
	 *
	 * @param JapanTransmitHistCondVO japanTransmitHistCondVO
	 * @return List<JapanManifestListTransmitHistDetailVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<JapanManifestListTransmitHistDetailVO> searchJpcusSendList(JapanTransmitHistCondVO japanTransmitHistCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<JapanManifestListTransmitHistDetailVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int currentPage = Integer.parseInt(japanTransmitHistCondVO.getIPage().equals("") ?"1":japanTransmitHistCondVO.getIPage());
		int startNo = Integer.parseInt(japanTransmitHistCondVO.getPagerows().equals("") ?"100":japanTransmitHistCondVO.getPagerows()) *(currentPage - 1) + 1;
		int endNo = Integer.parseInt(japanTransmitHistCondVO.getPagerows().equals("") ?"100":japanTransmitHistCondVO.getPagerows()) * currentPage;

		try {
			if (japanTransmitHistCondVO != null) {
				Map<String, String> mapVO = japanTransmitHistCondVO.getColumnValues();
				param.put("startno", startNo);
				param.put("endno", endNo);
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JapanCustomsReportDBDAOsearchJpcusSendListRSQL(), param, velParam, true);
			list =(List) RowSetUtil.rowSetToVOs(dbRowset, JapanManifestListTransmitHistDetailVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * 일본 세관 SEA-NACCS에서 수신한 MSG 를 조회한다.  MSG Type이 "MFR" 이고, "ERROR" 조건이 선택된 경우 조회<br>
	 *
	 * @param JapanRcvHistCondVO  japanRcvHistCondVO
	 * @return List<JapanManifestListReceiveHistDetailVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<JapanManifestListReceiveHistDetailVO> searchJpcusMfrErrList(JapanRcvHistCondVO  japanRcvHistCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<JapanManifestListReceiveHistDetailVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int currentPage = Integer.parseInt(japanRcvHistCondVO.getIPage().equals("") ?"1":japanRcvHistCondVO.getIPage());
		int startNo = Integer.parseInt(japanRcvHistCondVO.getPagerows().equals("") ?"100":japanRcvHistCondVO.getPagerows()) *(currentPage - 1) + 1;
		int endNo = Integer.parseInt(japanRcvHistCondVO.getPagerows().equals("") ?"100":japanRcvHistCondVO.getPagerows()) * currentPage;

		try {
			if (japanRcvHistCondVO != null) {
				Map<String, String> mapVO = japanRcvHistCondVO.getColumnValues();
				param.put("startno", startNo);
				param.put("endno", endNo);
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JapanCustomsReportDBDAOsearchJpcusMfrErrListRSQL(), param, velParam, true);
			list =(List) RowSetUtil.rowSetToVOs(dbRowset, JapanManifestListReceiveHistDetailVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * 일본세관으로부터 수신한 History를 조회한다.<br>
	 *
	 * @param JapanRcvHistCondVO japanRcvHistCondVO
	 * @return List<JapanManifestListReceiveHistDetailVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<JapanManifestListReceiveHistDetailVO> searchJpcusReceiveList(JapanRcvHistCondVO  japanRcvHistCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<JapanManifestListReceiveHistDetailVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int currentPage = Integer.parseInt(japanRcvHistCondVO.getIPage().equals("") ? "1" : japanRcvHistCondVO.getIPage());
		int startNo = Integer.parseInt(japanRcvHistCondVO.getPagerows().equals("") ? "100" : japanRcvHistCondVO.getPagerows()) *(currentPage - 1) + 1;
		int endNo = Integer.parseInt(japanRcvHistCondVO.getPagerows().equals("") ? "100" : japanRcvHistCondVO.getPagerows()) * currentPage;

		try {
			if (japanRcvHistCondVO != null) {
				Map<String, String> mapVO = japanRcvHistCondVO.getColumnValues();
				param.put("startno", startNo);
				param.put("endno", endNo);
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JapanCustomsReportDBDAOsearchJpcusReceiveListRSQL(), param, velParam, true);
			list =(List) RowSetUtil.rowSetToVOs(dbRowset, JapanManifestListReceiveHistDetailVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * 일본세관(JP24) 으로부터 수신한 History를 조회한다.<br>
	 *
	 * @param JapanRcvHistCondVO japanRcvHistCondVO
	 * @return List<JapanManifestListReceiveHistDetailVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<JapanManifestListReceiveHistDetailVO> searchJp24ReceiveList(JapanRcvHistCondVO  japanRcvHistCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<JapanManifestListReceiveHistDetailVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int currentPage = Integer.parseInt(japanRcvHistCondVO.getIPage().equals("") ? "1" : japanRcvHistCondVO.getIPage());
		int startNo = Integer.parseInt(japanRcvHistCondVO.getPagerows().equals("") ? "100" : japanRcvHistCondVO.getPagerows()) *(currentPage - 1) + 1;
		int endNo = Integer.parseInt(japanRcvHistCondVO.getPagerows().equals("") ? "100" : japanRcvHistCondVO.getPagerows()) * currentPage;

		try {
			if (japanRcvHistCondVO != null) {
				Map<String, String> mapVO = japanRcvHistCondVO.getColumnValues();
				param.put("startno", startNo);
				param.put("endno", endNo);
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JapanCustomsReportDBDAOsearchJp24ReceiveListRSQL(), param, velParam, true);
			list =(List) RowSetUtil.rowSetToVOs(dbRowset, JapanManifestListReceiveHistDetailVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * 일본세관으로부터 수신한 Manifest Count를 조회한다.<br>
	 *
	 * @return int count
	 * @throws DAOException
	 */
	public int searchRcvLogCnt() throws DAOException {
		DBRowSet dbRowset = null;
		int count = 0;

		try {
			Map<String, Object> param = new HashMap<String, Object>();
			//param.put("bl_no", bl_no);
			//param.put("bl_no_tp", bl_no_tp);
			//param.put("bl_no_chk", bl_no_chk);
			//param.put("bl_split_no", bl_split_no);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JapanCustomsReportDBDAOsearchRcvLogCntRSQL(), param, null, true);
			if (dbRowset.next()) {
				count = dbRowset.getInt(1);
			} else {
				count = 0;
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return count;
	}



}
