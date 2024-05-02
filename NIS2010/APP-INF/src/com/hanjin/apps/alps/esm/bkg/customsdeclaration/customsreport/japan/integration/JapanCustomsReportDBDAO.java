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
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.japan.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.japan.vo.JapanManifestListRcvLogDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.japan.vo.JapanManifestListReceiveHistDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.japan.vo.JapanManifestListSndLogDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.japan.vo.JapanManifestListTransmitHistDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.japan.vo.JapanRcvHistCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.japan.vo.JapanReceiveLogCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.japan.vo.JapanSendLogCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.japan.vo.JapanTransmitHistCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.japan.basic.JapanManifestListDownloadBCImpl;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;


/**
 * ALPS JapanManifestListDownloadDBDAO <br>
 * - ALPS-CustomsDeclaration system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author KIM SEUNG MIN
 * @see JapanManifestListDownloadBCImpl 참조
 * @since J2EE 1.4
 */
public class JapanCustomsReportDBDAO  extends DBDAOSupport {


	/**
	 * 일본세관으로 전송한 Manifest 내용을 조회한다.<br>
	 *
	 * @param JapanSendLogCondVO japanSendLogCondVO
	 * @return List<JapanManifestListSndLogDetailVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<JapanManifestListSndLogDetailVO> searchJpcusSendLog(JapanSendLogCondVO japanSendLogCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<JapanManifestListSndLogDetailVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

        //int currentPage = Integer.parseInt(japanSendLogCondVO.getIPage().equals("")?"1":japanSendLogCondVO.getIPage());
		//int startNo   = Integer.parseInt(japanSendLogCondVO.getPagerows().equals("")?"100":japanSendLogCondVO.getPagerows()) * (currentPage - 1) + 1;
		//int endNo     = Integer.parseInt(japanSendLogCondVO.getPagerows().equals("")?"100":japanSendLogCondVO.getPagerows()) * currentPage;
		try {
			if (japanSendLogCondVO != null) {
				Map<String, String> mapVO = japanSendLogCondVO.getColumnValues();
				//param.put("startno", startNo);
				//param.put("endno", endNo);
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new JapanCustomsReportDBDAOsearchJpcusSendLogRSQL(),param, velParam, true);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset,
					JapanManifestListSndLogDetailVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * 일본세관으로부터 수신한 Manifest 내용을 조회한다.<br>
	 *
	 * @param JapanReceiveLogCondVO  japanReceiveLogCondVO
	 * @return List<JapanManifestListRcvLogDetailVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<JapanManifestListRcvLogDetailVO> searchJpcusReceiveLog(JapanReceiveLogCondVO  japanReceiveLogCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<JapanManifestListRcvLogDetailVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		//int currentPage = Integer.parseInt(japanReceiveLogCondVO.getIPage().equals("")?"1":japanReceiveLogCondVO.getIPage());
		//int startNo   = Integer.parseInt(japanReceiveLogCondVO.getPagerows().equals("")?"100":japanReceiveLogCondVO.getPagerows()) * (currentPage - 1) + 1;
		//int endNo     = Integer.parseInt(japanReceiveLogCondVO.getPagerows().equals("")?"100":japanReceiveLogCondVO.getPagerows()) * currentPage;
		try {
			if (japanReceiveLogCondVO != null) {
				Map<String, String> mapVO = japanReceiveLogCondVO.getColumnValues();
				//param.put("startno", startNo);
				//param.put("endno", endNo);
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new JapanCustomsReportDBDAOsearchJpcusReceiveLogRSQL(),param, velParam, true);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset,
					JapanManifestListRcvLogDetailVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}



	/**
	 * 일본세관으로 전송한 History를 조회한다.<br>
	 *
	 * @param JapanTransmitHistCondVO japanTransmitHistCondVO
	 * @return List<JapanManifestListTransmitHistDetailVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<JapanManifestListTransmitHistDetailVO> searchJpcusSendList(JapanTransmitHistCondVO japanTransmitHistCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<JapanManifestListTransmitHistDetailVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		log.info("#########################################");
		log.info("IPage1 :" + japanTransmitHistCondVO.getIPage()==null+":");
		log.info("IPage2 :" + japanTransmitHistCondVO.getIPage().equals("")+":");
		log.info("#########################################");
        int currentPage = Integer.parseInt(japanTransmitHistCondVO.getIPage().equals("")?"1":japanTransmitHistCondVO.getIPage());
		int startNo   = Integer.parseInt(japanTransmitHistCondVO.getPagerows().equals("")?"100":japanTransmitHistCondVO.getPagerows()) * (currentPage - 1) + 1;
		int endNo     = Integer.parseInt(japanTransmitHistCondVO.getPagerows().equals("")?"100":japanTransmitHistCondVO.getPagerows()) * currentPage;
		log.info("#########################################");
		log.info("startNo : " + startNo);
		log.info("endNo : " + endNo);
		log.info("#########################################");
		try {
			if (japanTransmitHistCondVO != null) {
				Map<String, String> mapVO = japanTransmitHistCondVO.getColumnValues();
				param.put("startno", startNo);
				param.put("endno", endNo);
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new JapanCustomsReportDBDAOsearchJpcusSendListRSQL(),param, velParam, true);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset,
					JapanManifestListTransmitHistDetailVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
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
	@SuppressWarnings("unchecked")
	public List<JapanManifestListReceiveHistDetailVO> searchJpcusMfrErrList(JapanRcvHistCondVO  japanRcvHistCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<JapanManifestListReceiveHistDetailVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int currentPage = Integer.parseInt(japanRcvHistCondVO.getIPage().equals("")?"1":japanRcvHistCondVO.getIPage());
		int startNo   = Integer.parseInt(japanRcvHistCondVO.getPagerows().equals("")?"100":japanRcvHistCondVO.getPagerows()) * (currentPage - 1) + 1;
		int endNo     = Integer.parseInt(japanRcvHistCondVO.getPagerows().equals("")?"100":japanRcvHistCondVO.getPagerows()) * currentPage;
		try {
			if (japanRcvHistCondVO != null) {
				Map<String, String> mapVO = japanRcvHistCondVO.getColumnValues();
				param.put("startno", startNo);
				param.put("endno", endNo);
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new JapanCustomsReportDBDAOsearchJpcusMfrErrListRSQL(),param, velParam, true);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset,
					JapanManifestListReceiveHistDetailVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
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
	@SuppressWarnings("unchecked")
	public List<JapanManifestListReceiveHistDetailVO> searchJpcusReceiveList(JapanRcvHistCondVO  japanRcvHistCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<JapanManifestListReceiveHistDetailVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int currentPage = Integer.parseInt(japanRcvHistCondVO.getIPage().equals("") ? "1" : japanRcvHistCondVO.getIPage());
		int startNo = Integer.parseInt(japanRcvHistCondVO.getPagerows().equals("") ? "100" : japanRcvHistCondVO.getPagerows()) * (currentPage - 1) + 1;
		int endNo = Integer.parseInt(japanRcvHistCondVO.getPagerows().equals("") ? "100" : japanRcvHistCondVO.getPagerows()) * currentPage;
		try {
			if (japanRcvHistCondVO != null) {
				Map<String, String> mapVO = japanRcvHistCondVO.getColumnValues();
				param.put("startno", startNo);
				param.put("endno", endNo);
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new JapanCustomsReportDBDAOsearchJpcusReceiveListRSQL(),param, velParam, true);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, JapanManifestListReceiveHistDetailVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * 일본세관(JP24)으로부터 수신한 History를 조회한다.<br>
	 *
	 * @param JapanRcvHistCondVO japanRcvHistCondVO
	 * @return List<JapanManifestListReceiveHistDetailVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<JapanManifestListReceiveHistDetailVO> searchJp24ReceiveList(JapanRcvHistCondVO  japanRcvHistCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<JapanManifestListReceiveHistDetailVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int currentPage = Integer.parseInt(japanRcvHistCondVO.getIPage().equals("") ? "1" : japanRcvHistCondVO.getIPage());
		int startNo = Integer.parseInt(japanRcvHistCondVO.getPagerows().equals("") ? "100" : japanRcvHistCondVO.getPagerows()) * (currentPage - 1) + 1;
		int endNo = Integer.parseInt(japanRcvHistCondVO.getPagerows().equals("") ? "100" : japanRcvHistCondVO.getPagerows()) * currentPage;
		try {
			if (japanRcvHistCondVO != null) {
				Map<String, String> mapVO = japanRcvHistCondVO.getColumnValues();
				param.put("startno", startNo);
				param.put("endno", endNo);
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new JapanCustomsReportDBDAOsearchJp24ReceiveListRSQL(),param, velParam, true);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, JapanManifestListReceiveHistDetailVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
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

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JapanCustomsReportDBDAOsearchRcvLogCntRSQL(),param, null, true);
			 if (dbRowset.next()) {
				 count = dbRowset.getInt(1);
			 } else {
				 count = 0;
			 }
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return count;
	}



}
