﻿/*=========================================================
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
 * ------------------------------------------------------
 * history
 * 2011.04.06 김영철 [CHM-201109426-01] Sea-NACCS MFR 송신에러( WGT 정수자리수가 7자리 이상인지 체크함.)
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.japan.vo.JapanTransmitBlKeyVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.basic.JapanManifestListDownloadBCImpl;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo.ApprovalCstmsCdVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo.CstmsJpWhRoutVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo.CstmsJpWhVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo.JapanBlKeyVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo.JapanBlVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo.JapanManifestListBkgCntrInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo.JapanManifestListBkgCorrVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo.JapanManifestListBkgCustInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo.JapanManifestListBkgDetail2VO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo.JapanManifestListBkgDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo.JapanManifestListBkgInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo.JapanManifestListBkgQtyVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo.JapanManifestListBkgVvdInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo.JapanManifestListBlMdVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo.JapanManifestListCmfDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo.JapanManifestListCntrDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo.JapanManifestListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo.JapanManifestListDorListInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo.JapanManifestListEtcVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo.JapanManifestListMfrCntrInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo.JapanManifestListMfrCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo.JapanManifestListMfrCustInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo.JapanManifestListMfsDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo.JapanManifestListVslPortSkdVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo.JapanManifestModificationVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo.JapanVesselArrivalVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo.VpsCallIndInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListCondVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.syscommon.common.table.BkgCstmsJpBlCntrVO;
import com.clt.syscommon.common.table.BkgCstmsJpBlCustVO;
import com.clt.syscommon.common.table.BkgCstmsJpBlMkVO;
import com.clt.syscommon.common.table.BkgCstmsJpBlVO;
import com.clt.syscommon.common.table.BkgCstmsJpVslSkdVO;
import com.clt.syscommon.common.table.BkgCstmsJpVslVO;


/**
 * OPUS JapanManifestListDownloadDBDAO <br>
 * - OPUS-CustomsDeclaration system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author KIM SEUNG MIN
 * @see JapanManifestListDownloadBCImpl 참조
 * @since J2EE 1.4
 */
@SuppressWarnings("serial")
public class JapanManifestListDownloadDBDAO  extends DBDAOSupport {

	/**
	 * Vessel Port Schedule Call Indicator를 조회한다.<br>
	 *
	 * @param JapanManifestListCondVO japanManifestListCondVO
	 * @return List<VpsCallIndInfoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings( { "unchecked", "rawtypes" })
	public List<VpsCallIndInfoVO> searchVpsCallInd(JapanManifestListCondVO japanManifestListCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<VpsCallIndInfoVO> list= null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (japanManifestListCondVO != null) {
				Map<String, String> mapVO = japanManifestListCondVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new JapanManifestListDownloadDBDAOsearchVpsCallIndRSQL(), param, velParam, true);
			list =(List) RowSetUtil.rowSetToVOs(dbRowset, VpsCallIndInfoVO.class);

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
	 * Booking Correction 정보를 조회한다.<br>
	 *
	 * @param String bkgNo
	 * @return String corrNo
	 * @throws DAOException
	 */
	public String searchBkgCorr(String bkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		String corrNo = null;

		try {
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("bkg_no", bkgNo);
			//param.put("bkg_no_split", bkgNoSplit);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JapanManifestListDownloadDBDAOsearchBkgCorrRSQL(), param, null, true);
			if (dbRowset.next()) {
				corrNo = dbRowset.getString(1);
			} else {
				corrNo = "";
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return corrNo;
	}

	/**
	 * Vessel Port Schedule 정보를 조회한다.<br>
	 *
	 * @param JapanManifestListCondVO japanManifestListCondVO
	 * @return List<JapanManifestListVslPortSkdVO>
	 * @throws DAOException
	 */
	@SuppressWarnings( { "unchecked", "rawtypes" })
	public List<JapanManifestListVslPortSkdVO> searchVslPortSkd(JapanManifestListCondVO japanManifestListCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<JapanManifestListVslPortSkdVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (japanManifestListCondVO != null) {
				Map<String, String> mapVO = japanManifestListCondVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new JapanManifestListDownloadDBDAOsearchVslPortSkdRSQL(), param, velParam, true);
			list =(List) RowSetUtil.rowSetToVOs(dbRowset, JapanManifestListVslPortSkdVO.class);
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
	 * Booking Detail 정보를 조회한다.<br>
	 *
	 * @param JapanManifestListCondVO japanManifestListCondVO
	 * @return List<JapanManifestListBkgDetailVO>
	 * @throws DAOException
	 */
	@SuppressWarnings( { "unchecked", "rawtypes" })
	public List<JapanManifestListBkgDetailVO> searchBkgDetail(JapanManifestListCondVO japanManifestListCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<JapanManifestListBkgDetailVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (japanManifestListCondVO != null) {
				Map<String, String> mapVO = japanManifestListCondVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new JapanManifestListDownloadDBDAOsearchBkgDetailRSQL(), param, velParam, true);
			list =(List) RowSetUtil.rowSetToVOs(dbRowset, JapanManifestListBkgDetailVO.class);
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
	 * Booking Detail 정보를 조회한다.<br>
	 *
	 * @param JapanManifestListCondVO japanManifestListCondVO
	 * @return List<JapanManifestListBkgDetail2VO>
	 * @throws DAOException
	 */
	@SuppressWarnings( { "unchecked", "rawtypes" })
	public List<JapanManifestListBkgDetail2VO> searchBkgDetail2(JapanManifestListCondVO japanManifestListCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<JapanManifestListBkgDetail2VO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (japanManifestListCondVO != null) {
				Map<String, String> mapVO = japanManifestListCondVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new JapanManifestListDownloadDBDAOsearchBkgDetail2RSQL(), param, velParam, true);
			list =(List) RowSetUtil.rowSetToVOs(dbRowset, JapanManifestListBkgDetail2VO.class);
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
	 * Container Detail 정보를 조회한다.<br>
	 *
	 * @param JapanManifestListCondVO japanManifestListCondVO
	 * @return List<JapanManifestListCntrDetailVO>
	 * @throws DAOException
	 */
	@SuppressWarnings( { "unchecked", "rawtypes" })
	public List<JapanManifestListCntrDetailVO> searchCntrDetail(JapanManifestListCondVO japanManifestListCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<JapanManifestListCntrDetailVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (japanManifestListCondVO != null) {
				Map<String, String> mapVO = japanManifestListCondVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new JapanManifestListDownloadDBDAOsearchCntrDetailRSQL(), param, velParam, true);
			list =(List) RowSetUtil.rowSetToVOs(dbRowset, JapanManifestListCntrDetailVO.class);
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
	 * Booking Correction 정보를 조회한다.<br>
	 *
	 * @param String bkgNo
	 * @return List<JapanManifestListBkgCorrVO>
	 * @throws DAOException
	 */
	@SuppressWarnings( { "unchecked", "rawtypes" })
	public List<JapanManifestListBkgCorrVO> searchBkgCorr2(String bkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<JapanManifestListBkgCorrVO> list = null;

		try {
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("bkg_no", bkgNo);

			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new JapanManifestListDownloadDBDAOsearchBkgCorr2RSQL(), param, null, true);
			list =(List) RowSetUtil.rowSetToVOs(dbRowset, JapanManifestListBkgCorrVO.class);
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
	 * Booking VVD 정보를 조회한다.<br>
	 *
	 * @param String bkgNo
	 * @param String podCd
	 * @param String pstPreDiv
	 * @return List<JapanManifestListBkgVvdInfoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<JapanManifestListBkgVvdInfoVO> searchBkgVvd(String bkgNo, String podCd, String pstPreDiv) throws DAOException {
		DBRowSet dbRowset = null;
		List<JapanManifestListBkgVvdInfoVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("bkg_no", bkgNo);
			param.put("pod_cd", podCd);
			velParam.put("pst_pre_div", pstPreDiv);

			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new JapanManifestListDownloadDBDAOsearchBkgVvdRSQL(), param, velParam, true);
			list =(List) RowSetUtil.rowSetToVOs(dbRowset, JapanManifestListBkgVvdInfoVO.class);
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
	 * Booking Qty 정보를 조회한다.<br>
	 *
	 * @param String bkgNo
	 * @return List<JapanManifestListBkgQtyVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<JapanManifestListBkgQtyVO> searchBkgQty(String bkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<JapanManifestListBkgQtyVO> list = null;

		try {
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("bkg_no", bkgNo);
			//param.put("bkg_no_split", bkg_no_split);

			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new JapanManifestListDownloadDBDAOsearchBkgQtyRSQL(), param, null, true);
			list =(List) RowSetUtil.rowSetToVOs(dbRowset, JapanManifestListBkgQtyVO.class);
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
	 * Booking Main 정보를 조회한다.<br>
	 *
	 * @param String bkgNo
	 * @return List<JapanManifestListBkgInfoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<JapanManifestListBkgInfoVO> searchBooking(String bkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<JapanManifestListBkgInfoVO> list = null;

		try {
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("bkg_no", bkgNo);
			//param.put("bkg_no_split", bkg_no_split);

			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new JapanManifestListDownloadDBDAOsearchBookingRSQL(), param, null, true);
			list =(List) RowSetUtil.rowSetToVOs(dbRowset, JapanManifestListBkgInfoVO.class);
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
	 * Booking Customer 정보를 조회한다.<br>
	 *
	 * @param String bkgNo
	 * @return List<JapanManifestListBkgCustInfoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<JapanManifestListBkgCustInfoVO> searchBkgCust(String bkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<JapanManifestListBkgCustInfoVO> list = null;

		try {
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("bkg_no", bkgNo);
			//param.put("bkg_no_split", bkg_no_split);

			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new JapanManifestListDownloadDBDAOsearchBkgCustRSQL(), param, null, true);
			list =(List) RowSetUtil.rowSetToVOs(dbRowset, JapanManifestListBkgCustInfoVO.class);
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
	 * BL CM Descriptin 정보를 조회한다.<br>
	 *
	 * @param String bkgNo
	 * @return String cstmsDesc
	 * @throws DAOException
	 */
	public String searchBlCmDesc(String bkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		String cstmsDesc = null;

		try {
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("bkg_no", bkgNo);
			//param.put("bkg_no_split", bkg_no_split);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JapanManifestListDownloadDBDAOsearchBlCmDescRSQL(), param, null, true);
			if (dbRowset.next()) {
				cstmsDesc = dbRowset.getString(1);
			} else {
				cstmsDesc = "";
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return cstmsDesc;
	}

	/**
	 * BL M&D 정보를 조회한다.<br>
	 *
	 * @param String bkgNo
	 * @return List<JapanManifestListBlMdVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<JapanManifestListBlMdVO> searchBlMd(String bkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<JapanManifestListBlMdVO> list = null;

		try {
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("bkg_no", bkgNo);
			//param.put("bkg_no_split", bkg_no_split);

			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new JapanManifestListDownloadDBDAOsearchBlMdRSQL(), param, null, true);
			list =(List) RowSetUtil.rowSetToVOs(dbRowset, JapanManifestListBlMdVO.class);
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
	 * Booking Container 정보를 조회한다.<br>
	 *
	 * @param String bkgNo
	 * @param String bkgCgoTpCd
	 * @return List<JapanManifestListBkgCntrInfoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<JapanManifestListBkgCntrInfoVO> searchBkgCntr(String bkgNo, String bkgCgoTpCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<JapanManifestListBkgCntrInfoVO> list = null;

		try {
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("bkg_no", bkgNo);
			//param.put("bkg_no_split", bkg_no_split);
			param.put("bkg_cgo_tp_cd", bkgCgoTpCd);

			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new JapanManifestListDownloadDBDAOsearchBkgCntrRSQL(), param, null, true);
			list =(List) RowSetUtil.rowSetToVOs(dbRowset, JapanManifestListBkgCntrInfoVO.class);
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
	 * Estimated Vessel Arrival 정보를 조회한다.<br>
	 *
	 * @param JapanManifestListCondVO japanManifestListCondVO
	 * @return String[]
	 * @throws DAOException
	 */
	public String[] searchEta(JapanManifestListCondVO japanManifestListCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		String[] rtnVal = new String[2];
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (japanManifestListCondVO != null) {
				Map<String, String> mapVO = japanManifestListCondVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JapanManifestListDownloadDBDAOsearchEtaRSQL(), param, null, true);
			if (dbRowset.next()) {
				rtnVal[0] = dbRowset.getString("VPS_ETA_DT");
				rtnVal[1] = dbRowset.getString("IB_CSSM_VOY_NO");
			} else {
				rtnVal[0] = "";
				rtnVal[1] = "";
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnVal;
	}

	/**
	 * 일본세관 Manifest 신고용 Estimated Vessel Arrival 정보를 조회한다.<br>
	 *
	 * @param JapanManifestListCondVO japanManifestListCondVO
	 * @return List<JapanManifestListEtcVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<JapanManifestListEtcVO> searchJpcusEta(JapanManifestListCondVO japanManifestListCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<JapanManifestListEtcVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (japanManifestListCondVO != null) {
				Map<String, String> mapVO = japanManifestListCondVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new JapanManifestListDownloadDBDAOsearchJpcusEtaRSQL(), param, null, true);
			list =(List) RowSetUtil.rowSetToVOs(dbRowset, JapanManifestListEtcVO.class);
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
	 * Vessel Call Sign 번호를 조회한다.<br>
	 *
	 * @param String inVslCd
	 * @return String callSgnNo
	 * @throws DAOException
	 */
	public String searchVslCallsign(String inVslCd) throws DAOException {
		DBRowSet dbRowset = null;
		String callSgnNo = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("in_vsl_cd", inVslCd);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JapanmanifestListDownloadDBDAOsearchVslCallsignRSQL(), param, velParam, true);
			if (dbRowset.next()) {
				callSgnNo = dbRowset.getString(1);
			} else {
				callSgnNo = "";
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return callSgnNo;
	}

	/**
	 * 일본세관에 신고하기 위한 Manifest Detail 정보를 조회한다.(MFS) <br>
	 *
	 * @param JapanManifestListCondVO japanManifestListCondVO
	 * @return List<JapanManifestListMfsDetailVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<JapanManifestListMfsDetailVO> searchMfsDetail(JapanManifestListCondVO japanManifestListCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<JapanManifestListMfsDetailVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (japanManifestListCondVO != null) {
				Map<String, String> mapVO = japanManifestListCondVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new JapanManifestListDownloadDBDAOsearchMfsDetailRSQL(), param, velParam, true);
			list =(List) RowSetUtil.rowSetToVOs(dbRowset, JapanManifestListMfsDetailVO.class);
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
	 * 일본세관 Manifest 신고용 Stage 정보를 조회한다.<br>
	 *
	 * @param JapanBlVO japanBlVO
	 * @return String jpEdiTrsmStgTpCd
	 * @throws DAOException
	 */
	public String searchJbStage(JapanBlVO japanBlVO) throws DAOException {
		DBRowSet dbRowset = null;
		String jpEdiTrsmStgTpCd = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (japanBlVO != null) {
				Map<String, String> mapVO = japanBlVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JapanManifestListDownloadDBDAOsearchJbStageRSQL(), param, velParam, true);
			if (dbRowset.next()) {
				jpEdiTrsmStgTpCd = dbRowset.getString(1);
			} else {
				jpEdiTrsmStgTpCd = "";
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return jpEdiTrsmStgTpCd;
	}

	/**
	 * 일본세관으로 전송할 MFR  메시지의 Customer 정보를 조회한다.<br>
	 *
	 * @param JapanManifestListMfrCondVO japanManifestListMfrCondVO
	 * @return List<JapanManifestListMfrCustInfoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<JapanManifestListMfrCustInfoVO> searchMfrCust(JapanManifestListMfrCondVO japanManifestListMfrCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<JapanManifestListMfrCustInfoVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (japanManifestListMfrCondVO != null) {
				Map<String, String> mapVO = japanManifestListMfrCondVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new JapanManifestListDownloadDBDAOsearchMfrCustRSQL(), param, velParam, true);
			list =(List) RowSetUtil.rowSetToVOs(dbRowset, JapanManifestListMfrCustInfoVO.class);
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
	 * 일본세관으로 전송할 MFR  메시지의 Container 정보를 조회한다.<br>
	 *
	 * @param JapanManifestListMfrCondVO japanManifestListMfrCondVO
	 * @return List<JapanManifestListMfrCntrInfoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<JapanManifestListMfrCntrInfoVO> searchMfrCntr(JapanManifestListMfrCondVO japanManifestListMfrCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<JapanManifestListMfrCntrInfoVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (japanManifestListMfrCondVO != null) {
				Map<String, String> mapVO = japanManifestListMfrCondVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new JapanManifestListDownloadDBDAOsearchMfrCntrRSQL(), param, velParam, true);
			list =(List) RowSetUtil.rowSetToVOs(dbRowset, JapanManifestListMfrCntrInfoVO.class);
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
	 * 일본세관에서 BL COUNT를 조회한다.<br>
	 *
	 * @param String blNo
	 * @param String blSplitNo
	 * @return int count
	 * @throws DAOException
	 */
	public int searchBkgBlCount(String blNo, String blSplitNo) throws DAOException {
		DBRowSet dbRowset = null;
		int count = 0;

		try {
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("bl_no", blNo);
			//param.put("bl_no_tp", bl_no_tp);
			//param.put("bl_no_chk", bl_no_chk);
			param.put("bl_split_no", blSplitNo);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JapanManifestListDownloadDBDAOsearchBkgBlCountRSQL(), param, null, true);
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

	/**
	 * 일본세관 BL 정보를 조회한다.<br>
	 *
	 * @param String blNo
	 * @param String blSplitNo
	 * @return List<BkgCstmsJpBlVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BkgCstmsJpBlVO> searchJpcusBl(String blNo, String blSplitNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgCstmsJpBlVO> list = null;

		try {
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("bl_no", blNo);
			param.put("bl_split_no", blSplitNo);

			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new JapanManifestListDownloadDBDAOsearchJpcusBlRSQL(), param, null, true);
			list =(List) RowSetUtil.rowSetToVOs(dbRowset, BkgCstmsJpBlVO.class);
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
	 * 일본세관 BL CUST정보를 조회한다.<br>
	 *
	 * @param String blNo
	 * @param String blSplitNo
	 * @return List<BkgCstmsJpBlCustVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BkgCstmsJpBlCustVO> searchJpcusBlCust(String blNo, String blSplitNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgCstmsJpBlCustVO> list = null;

		try {
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("bl_no", blNo);
			//param.put("bl_no_tp", bl_no_tp);
			//param.put("bl_no_chk", bl_no_chk);
			param.put("bl_split_no", blSplitNo);

			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new JapanManifestListDownloadDBDAOsearchJpcusBlCustRSQL(), param, null, true);
			list =(List) RowSetUtil.rowSetToVOs(dbRowset, BkgCstmsJpBlCustVO.class);
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
	 * 일본세관 BL CNTR정보를 조회한다.<br>
	 *
	 * @param String blNo
	 * @return List<BkgCstmsJpBlCntrVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BkgCstmsJpBlCntrVO> searchJpcusBlCntr(String blNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgCstmsJpBlCntrVO> list = null;

		try {
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("bl_no", blNo);
			//param.put("bl_no_tp", bl_no_tp);
			//param.put("bl_no_chk", bl_no_chk);

			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new JapanManifestListDownloadDBDAOsearchJpcusBlCntrRSQL(), param, null, true);
			list =(List) RowSetUtil.rowSetToVOs(dbRowset, BkgCstmsJpBlCntrVO.class);
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
	 * 일본세관 BL M&D정보를 조회한다.<br>
	 *
	 * @param String blNo
	 * @param String blSplitNo
	 * @return List<BkgCstmsJpBlMkVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BkgCstmsJpBlMkVO> searchJpcusBlMd(String blNo, String blSplitNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgCstmsJpBlMkVO> list = null;

		try {
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("bl_no", blNo);
			//param.put("bl_no_tp", bl_no_tp);
			//param.put("bl_no_chk", bl_no_chk);
			param.put("bl_split_no", blSplitNo);

			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new JapanManifestListDownloadDBDAOsearchJpcusBlMdRSQL(), param, null, true);
			list =(List) RowSetUtil.rowSetToVOs(dbRowset, BkgCstmsJpBlMkVO.class);
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
	 * 일본세관으로 DOR 메시지를 전송하기 위한 B/L List 를 조회한다.<br>
	 *
	 * @return List<JapanManifestListDorListInfoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<JapanManifestListDorListInfoVO> searchDorList() throws DAOException {
		DBRowSet dbRowset = null;
		List<JapanManifestListDorListInfoVO> list = null;

		try {
			//Map<String, Object> param = new HashMap<String, Object>();
			//param.put("bl_no", bl_no);
			//param.put("bl_no_tp", bl_no_tp);
			//param.put("bl_no_chk", bl_no_chk);
			//param.put("bl_split_no", bl_split_no);

			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new JapanManifestListDownloadDBDAOsearchDorListRSQL(), null, null, true);
			list =(List) RowSetUtil.rowSetToVOs(dbRowset, JapanManifestListDorListInfoVO.class);
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
	 * 일본세관에 신고하기 위한 Manifest Detail 정보를 조회한다.(CMF) <br>
	 *
	 * @param JapanManifestListCondVO japanManifestListCondVO
	 * @return List<JapanManifestListCmfDetailVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<JapanManifestListCmfDetailVO> searchCmfDetail(JapanManifestListCondVO japanManifestListCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<JapanManifestListCmfDetailVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (japanManifestListCondVO != null) {
				Map<String, String> mapVO = japanManifestListCondVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new JapanManifestListDownloadDBDAOsearchCmfDetailRSQL(), param, null, true);
			list =(List) RowSetUtil.rowSetToVOs(dbRowset, JapanManifestListCmfDetailVO.class);
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
	 * 일본세관으로 DMF 전송하기 위한 Vessel ETA 및 Remark 정보를 조회한다.<br>
	 *
	 * @param JapanVesselArrivalVO japanVesselArrivalVO
	 * @return List<JapanVesselArrivalVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<JapanVesselArrivalVO> searchVslEtaDmfRemark(JapanVesselArrivalVO japanVesselArrivalVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<JapanVesselArrivalVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (japanVesselArrivalVO != null) {
				Map<String, String> mapVO = japanVesselArrivalVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new JapanManifestListDownloadDBDAOsearchVslEtaDmfRemarkRSQL(), param, null, true);
			list =(List) RowSetUtil.rowSetToVOs(dbRowset, JapanVesselArrivalVO.class);
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
	 * 일본세관 Manifest 신고용 B/L 정보를 삭제한다.<br>
	 *
	 * @param String blNo
	 * @return int result
	 * @throws DAOException
	 */
	public int removeJpcusBl(String blNo) throws DAOException, Exception {
		int result = 0;

		try {
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("bl_no", blNo);
			//param.put("bl_no_tp", bl_no_tp);
			//param.put("bl_no_chk", bl_no_chk);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new JapanManifestListDownloadDBDAOremoveJpcusBlDSQL(), param, null, true);
			if (result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to delete SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}

	/**
	 * 일본세관 Manifest 신고용 B/L Customer 정보를 삭제한다.<br>
	 *
	 * @param String blNo
	 * @return int result
	 * @throws DAOException
	 */
	public int removeJpcusBlCust(String blNo) throws DAOException, Exception {
		int result = 0;

		try {
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("bl_no", blNo);
			//param.put("bl_no_tp", bl_no_tp);
			//param.put("bl_no_chk", bl_no_chk);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new JapanManifestListDownloadDBDAOremoveJpcusBlCustDSQL(), param, null, true);
			if (result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to delete SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}

	/**
	 * 일본세관 Manifest 신고용 B/L Mark, Description 정보를 삭제한다.<br>
	 *
	 * @param String blNo
	 * @return int result
	 * @throws DAOException
	 */
	public int removeJpcusBlMdForDL(String blNo) throws DAOException, Exception {
		int result = 0;

		try {
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("bl_no", blNo);
			//param.put("bl_no_tp", bl_no_tp);
			//param.put("bl_no_chk", bl_no_chk);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new JapanManifestListDownloadDBDAOremoveJpcusBlMdForDLDSQL(), param, null, true);
			if (result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to delete SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}

	/**
	 * 일본세관 Manifest 신고용 B/L Container 정보를 삭제한다.<br>
	 *
	 * @param String blNo
	 * @return int result
	 * @throws DAOException
	 */
	public int removeJpcusBlCntr(String blNo) throws DAOException, Exception {
		int result = 0;

		try {
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("bl_no", blNo);
			//param.put("bl_no_tp", bl_no_tp);
			//param.put("bl_no_chk", bl_no_chk);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new JapanManifestListDownloadDBDAOremoveJpcusBlCntrDSQL(), param, null, true);
			if (result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to delete SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}

	/**
	 * 일본세관 Manifest 신고용 B/L 정보를 삭제한다.<br>
	 *
	 * @param JapanManifestModificationVO japanManifestModificationVO
	 * @throws DAOException
	 */
	public void removeJpcusBl(JapanManifestModificationVO japanManifestModificationVO) throws DAOException, Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;

		try {
			Map<String, String> mapVO = japanManifestModificationVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new JapanManifestListDownloadDBDAOremoveJpcusBlUSQL(), param, null, true);
			if (result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to delete SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 일본세관 Manifest 신고용 B/L Mark, Description 정보를 삭제한다. <br>
	 *
	 * @param BkgCstmsJpBlMkVO bkgCstmsJpBlMkVO
	 * @throws DAOException
	 */
	public void removeJpcusBlMd(BkgCstmsJpBlMkVO bkgCstmsJpBlMkVO) throws DAOException, Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;

		try {
			Map<String, String> mapVO = bkgCstmsJpBlMkVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new JapanManifestListDownloadDBDAOremoveJpcusBlMdDSQL(), param, null, true);
			if (result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to delete SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 일본세관 Manifest 신고용 B/L 정보를 생성한다.<br>
	 *
	 * @param BkgCstmsJpBlVO bkgCstmsJpBlVO
	 * @throws DAOException
	 */
	public void addJpcusBl(BkgCstmsJpBlVO bkgCstmsJpBlVO) throws DAOException, Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;

		try {
			Map<String, String> mapVO = bkgCstmsJpBlVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new JapanManifestListDownloadDBDAOaddJpcusBlCSQL(), param, velParam, true);
			if (result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 일본세관 Manifest 신고용 B/L Customer 정보를 생성한다.<br>
	 *
	 * @param BkgCstmsJpBlCustVO bkgCstmsJpBlCustVO
	 * @throws DAOException
	 */
	public void addJpcusBlCust(BkgCstmsJpBlCustVO bkgCstmsJpBlCustVO) throws DAOException, Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;

		try {
			Map<String, String> mapVO = bkgCstmsJpBlCustVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new JapanManifestListDownloadDBDAOaddJpcusBlCustCSQL(), param, velParam, true);
			if (result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 일본세관 Manifest 신고용 B/L Mark, Description 정보를 생성한다.<br>
	 *
	 * @param BkgCstmsJpBlMkVO bkgCstmsJpBlMkVO
	 * @throws DAOException
	 */
	public void addJpcusBlMd(BkgCstmsJpBlMkVO bkgCstmsJpBlMkVO) throws DAOException, Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;

		try {
			Map<String, String> mapVO = bkgCstmsJpBlMkVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new JapanManifestListDownloadDBDAOaddJpcusBlMdCSQL(), param, velParam, true);
			if (result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 일본세관 Manifest 신고용 B/L Container 정보를 생성한다.<br>
	 *
	 * @param BkgCstmsJpBlCntrVO bkgCstmsJpBlCntrVO
	 * @return int
	 * @throws DAOException
	 */
	public int addJpcusBlCntr(BkgCstmsJpBlCntrVO bkgCstmsJpBlCntrVO) throws DAOException, Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;

		try {
			Map<String, String> mapVO = bkgCstmsJpBlCntrVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new JapanManifestListDownloadDBDAOaddJpcusBlCntrCSQL(), param, velParam, true);
			if (result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}

	/**
	 * 일본세관 Manifest 신고용 B/L Vessel Schedule 정보를 생성한다.<br>
	 *
	 * @param BkgCstmsJpVslSkdVO bkgCstmsJpVslSkdVO
	 * @throws DAOException
	 */
	public void addJpcusVslSkd(BkgCstmsJpVslSkdVO bkgCstmsJpVslSkdVO) throws DAOException, Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;

		try {
			Map<String, String> mapVO = bkgCstmsJpVslSkdVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new JapanManifestListDownloadDBDAOaddJpcusVslSkdCSQL(), param, velParam, true);
			if (result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 일본세관 Manifest 신고용 B/L Vessel 정보를 생성한다.<br>
	 *
	 * @param BkgCstmsJpVslVO bkgCstmsJpVslVO
	 * @throws DAOException
	 */
	public void addVesselInfo(BkgCstmsJpVslVO bkgCstmsJpVslVO) throws DAOException, Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;

		try {
			Map<String, String> mapVO = bkgCstmsJpVslVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new JapanManifestListDownloadDBDAOaddVesselInfoCSQL(), param, velParam, true);
			if (result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 일본세관 Manifest 신고용 B/L Vessel Schedule 정보를 생성한다.<br>
	 *
	 * @param BkgCstmsJpVslSkdVO bkgCstmsJpVslSkdVO
	 * @throws DAOException
	 */
	public void addJpcusVslSkd2(BkgCstmsJpVslSkdVO bkgCstmsJpVslSkdVO) throws DAOException, Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;

		try {
			Map<String, String> mapVO = bkgCstmsJpVslSkdVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new JapanManifestListDownloadDBDAOaddJpcusVslSkd2CSQL(), param, velParam, true);
			if (result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 일본세관 Manifest 신고용 B/L 정보를 수정한다.<br>
	 *
	 * @param JapanManifestModificationVO japanManifestModificationVO
	 * @throws DAOException
	 */
	public void modifyJpcusBl(JapanManifestModificationVO japanManifestModificationVO) throws DAOException, Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;

		try {
			Map<String, String> mapVO = japanManifestModificationVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new JapanManifestListDownloadDBDAOmodifyJpcusBlUSQL(), param, velParam, true);
			if (result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to update SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 일본세관 Manifest 신고용 B/L 정보를 수정한다.<br>
	 *
	 * @param BkgCstmsJpBlVO bkgCstmsJpBlVO
	 * @throws DAOException
	 */
	public void modifyJpcusBl2(BkgCstmsJpBlVO bkgCstmsJpBlVO) throws DAOException, Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;

		try {
			Map<String, String> mapVO = bkgCstmsJpBlVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new JapanManifestListDownloadDBDAOmodifyJpcusBl2USQL(), param, velParam, true);
			if (result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to update SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 일본세관 Manifest 신고용 B/L 정보를 수정한다.<br>
	 *
	 * @param BkgCstmsJpBlVO bkgCstmsJpBlVO
	 * @throws DAOException
	 */
	public void modifyJpcusBl3(BkgCstmsJpBlVO bkgCstmsJpBlVO) throws DAOException, Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;

		try {
			Map<String, String> mapVO = bkgCstmsJpBlVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new JapanManifestListDownloadDBDAOmodifyJpcusBl3USQL(), param, velParam, true);
			if (result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to update SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 일본세관 Manifest 신고용 B/L Vessel Schedule 정보를 수정한다.<br>
	 *
	 * @param BkgCstmsJpVslSkdVO bkgCstmsJpVslSkdVO
	 * @return int
	 * @throws DAOException
	 */
	public int modifyJpcusVslSkd(BkgCstmsJpVslSkdVO bkgCstmsJpVslSkdVO) throws DAOException, Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;

		try {
			Map<String, String> mapVO = bkgCstmsJpVslSkdVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new JapanManifestListDownloadDBDAOmodifyJpcusVslSkdUSQL(), param, velParam, true);
			if (result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to update SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}

	/**
	 * 일본세관 Manifest 신고용 B/L Customer 정보를 수정한다.<br>
	 *
	 * @param BkgCstmsJpBlCustVO bkgCstmsJpBlCustVO
	 * @return int
	 * @throws DAOException
	 */
	public int modifyJpcusBlCust(BkgCstmsJpBlCustVO bkgCstmsJpBlCustVO) throws DAOException, Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;

		try {
			Map<String, String> mapVO = bkgCstmsJpBlCustVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new JapanManifestListDownloadDBDAOmodifyJpcusBlCustUSQL(), param, velParam, true);
			if (result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to update SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}

	/**
	 * 일본세관 Manifest 신고용 B/L Container 정보를 수정한다.<br>
	 *
	 * @param BkgCstmsJpBlCntrVO bkgCstmsJpBlCntrVO
	 * @return int
	 * @throws DAOException
	 */
	public int modifyJpcusBlCntr(BkgCstmsJpBlCntrVO bkgCstmsJpBlCntrVO) throws DAOException, Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;

		try {
			Map<String, String> mapVO = bkgCstmsJpBlCntrVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new JapanManifestListDownloadDBDAOmodifyJpcusBlCntrUSQL(), param, velParam, true);
			if (result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to update SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}

	/**
	 * 일본세관 Manifest 신고용 B/L SplitNo를 수정한다.<br>
	 *
	 * @param BkgCstmsJpBlCntrVO bkgCstmsJpBlCntrVO
	 * @return int
	 * @throws DAOException
	 */
	public int modifyJpcusBlCntrSplitNo(BkgCstmsJpBlCntrVO bkgCstmsJpBlCntrVO) throws DAOException, Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;

		try {
			Map<String, String> mapVO = bkgCstmsJpBlCntrVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new JapanManifestListDownloadDBDAOmodifyJpcusBlCntrSplitNoUSQL(), param, velParam, true);
			if (result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to update SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}

	/**
	 * 일본세관 Manifest 신고용 B/L SplitInd를 수정한다.<br>
	 *
	 * @param String blNo
	 * @return int result
	 * @throws DAOException
	 */
	public int modifyJpcusBlSplitInd(String blNo) throws DAOException, Exception {
		//query parameter
		int result = 0;

		try {
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("bl_no", blNo);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new JapanManifestListDownloadDBDAOmodifyJpcusBlSplitIndUSQL(), param, null, true);
			if (result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to update SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}

	/**
	 * 일본세관 Manifest 신고용 B/L Mark, Description 정보를 수정한다.<br>
	 *
	 * @param BkgCstmsJpBlMkVO bkgCstmsJpBlMkVO
	 * @return int result
	 * @throws DAOException
	 */
	public int modifyJpcusBlMd(BkgCstmsJpBlMkVO bkgCstmsJpBlMkVO) throws DAOException, Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;

		try {
			Map<String, String> mapVO = bkgCstmsJpBlMkVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new JapanManifestListDownloadDBDAOmodifyJpcusBlMdUSQL(), param, velParam, true);
			if (result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to update SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}

	/**
	 * 일본세관 Manifest 신고용 B/L Mark, Description Seq를 수정한다.<br>
	 *
	 * @param String blNo
	 * @param String blSplitNo
	 * @param String blSeq
	 * @param String SeqNum
	 * @return int result
	 * @throws DAOException
	 */
	public int modifyJpcusBlMdSeq(String blNo, String blSplitNo, String blSeq, String SeqNum) throws DAOException, Exception {
		//query parameter
		int result = 0;

		try {
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("bl_no", blNo);
			param.put("bl_split_jo", blSplitNo);
			param.put("bl_seq", blSeq);
			param.put("seq_num", SeqNum);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new JapanManifestListDownloadDBDAOmodifyJpcusBlMdSeqUSQL(), param, null, true);
			if (result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to update SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}

	/**
	 * 일본세관 신고용 B/L 정보 Status를 수정한다.<br>
	 *
	 * @param JapanBlKeyVO japanBlKeyVO
	 * @throws DAOException
	 */
	public void modifyJpcusBlStatus(JapanBlKeyVO japanBlKeyVO) throws DAOException, Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;

		try {
			Map<String, String> mapVO = japanBlKeyVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new JapanManifestListDownloadDBDAOmodifyJpcusBlStatusUSQL(), param, velParam, true);
			if (result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to update SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 일본세관 신고용 B/L CNTR Status를 수정한다.<br>
	 *
	 * @param JapanBlKeyVO japanBlKeyVO
	 * @throws DAOException
	 */
	public void modifyJpcusBlCntrStatus(JapanBlKeyVO japanBlKeyVO) throws DAOException, Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;

		try {
			Map<String, String> mapVO = japanBlKeyVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new JapanManifestListDownloadDBDAOmodifyJpcusBlCntrStatusUSQL(), param, velParam, true);
			if (result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to update SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 일본세관 Manifest 신고용 B/L Vessel 정보를 수정한다.<br>
	 *
	 * @param BkgCstmsJpVslVO bkgCstmsJpVslVO
	 * @return int result
	 * @throws DAOException
	 */
	public int modifyVesselInfo(BkgCstmsJpVslVO bkgCstmsJpVslVO) throws DAOException, Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;

		try {
			Map<String, String> mapVO = bkgCstmsJpVslVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new JapanManifestListDownloadDBDAOmodifyVesselInfoUSQL(), param, velParam, true);
			if (result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to update SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}

	/**
	 * 일본세관 Manifest 신고용 B/L Vessel Schedule 정보를 수정한다.<br>
	 *
	 * @param BkgCstmsJpVslSkdVO bkgCstmsJpVslSkdVO
	 * @return int result
	 * @throws DAOException
	 */
	public int modifyJpcusVslSkd2(BkgCstmsJpVslSkdVO bkgCstmsJpVslSkdVO) throws DAOException, Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;

		try {
			Map<String, String> mapVO = bkgCstmsJpVslSkdVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new JapanManifestListDownloadDBDAOmodifyJpcusVslSkd2USQL(), param, velParam, true);
			if (result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to update SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}

	/**
	 * 일본세관 전송용 Manifest B/L Status를 Active or Deleted로 업데이트한다.<br>
	 *
	 * @param JapanTransmitBlKeyVO blKeyVO
	 * @throws DAOException
	 */
	public void modifyMsgStatus(JapanTransmitBlKeyVO blKeyVO) throws DAOException, Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;

		try {
			Map<String, String> mapVO = blKeyVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new JapanManifestListDownloadDBDAOmodifyMsgStatusUSQL(), param, velParam, true);
			if (result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to modify SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * BKG_DO_REF 테이블에 CY_OP_CD 를 업데이트.
	 * 즉, MFR 에서 변경된 CY Operator Code를 JP Cargo Release 화면쪽 CY Operation Code에도 반영<br>
	 *
	 * @param String bkgNo    : 선적예약 요청 번호
	 * @param String cyOpId   : CY Operator Code로 User Input, 일본 세관으로 CMF01, CMF02를 전송시 사용됨
	 * @exception DAOException
	 * @author Lim JinYoung
	 */
	public void modifyCYOperationCode(String bkgNo, String cyOpId) throws DAOException {
	//query parameter
	Map<String, Object> param = new HashMap<String, Object>();
	//velocity parameter
	Map<String, Object> velParam = new HashMap<String, Object>();
	int result =0;
	try {
		Map<String, String> mapVO = new HashMap<String, String>();

		mapVO.put("bkg_no", bkgNo);
		mapVO.put("cy_op_cd", cyOpId);

		param.putAll(mapVO);
		velParam.putAll(mapVO);

		SQLExecuter sqlExe = new SQLExecuter("");
		result = sqlExe.executeUpdate((ISQLTemplate) new JapanManifestListDownloadDBDAOmodifyCYOperationCodeUSQL(), param, velParam);
		if (result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert SQL");
	} catch(SQLException se) {
		log.error(se.getMessage(), se);
		throw new DAOException(new ErrorHandler(se).getMessage(), se);
	} catch(Exception ex) {
		log.error(ex.getMessage(), ex);
		throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
	}
	}

	/**
	 * 일본세관 Manifest 신고용 B/L Vessel Schedule 정보를 수정한다.<br>
	 *
	 * @param ManifestListCondVO japanManifestListCondVO
	 * @return string
	 * @throws DAOException
	 */
	public String searchWgtErrBkgNo(ManifestListCondVO japanManifestListCondVO) throws DAOException, Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String result = "";

		try {
			Map<String, String> mapVO = japanManifestListCondVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			DBRowSet dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new JapanManifestListDownloadDBDAOsearchWgtErrBkgNoRSQL(), param, velParam, true);
			while(dbRowset.next()) {
				result = dbRowset.getString("BKG_NO");
		}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}

	/**
	 * [ESM_BKG_1510]
	 * Approval Number and Place of Arrival (from BKG_CSTMS_JP_BL) 조회<br>
	 *
	 * @param ApprovalCstmsCdVO approvalCstmsCdVO
	 * @return List<ApprovalCstmsCdVO>
	 * @exception DAOException
	 */
	@SuppressWarnings( { "unchecked", "rawtypes" })
	public List<ApprovalCstmsCdVO> searchAproNoFromJpBl(ApprovalCstmsCdVO approvalCstmsCdVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (approvalCstmsCdVO != null) {
				Map<String, String> mapVO = approvalCstmsCdVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JapanManifestListDownloadDBDAOsearchAproNoFromJpBlRSQL(), param, velParam);
			return (List)RowSetUtil.rowSetToVOs(dbRowset, ApprovalCstmsCdVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [ESM_BKG_1510]
	 * Approval Number and Place of Arrival (from BKG_CSTMS_JP_WH_ROUT) 조회<br>
	 *
	 * @param ApprovalCstmsCdVO approvalCstmsCdVO
	 * @return List<ApprovalCstmsCdVO>
	 * @exception DAOException
	 */
	@SuppressWarnings( { "unchecked", "rawtypes" })
	public List<ApprovalCstmsCdVO> searchAproNoFromWhRout(ApprovalCstmsCdVO approvalCstmsCdVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (approvalCstmsCdVO != null) {
				Map<String, String> mapVO = approvalCstmsCdVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JapanManifestListDownloadDBDAOsearchAproNoFromWhRoutRSQL(), param, velParam);
			return (List)RowSetUtil.rowSetToVOs(dbRowset, ApprovalCstmsCdVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [ESM_BKG_1510]
	 * Approval Number and Place of Arrival 목록 수정 저장<br>
	 *
	 * @param ApprovalCstmsCdVO approvalCstmsCdVO
	 * @exception DAOException, Exception
	 */
	public void modifyApprovalCstmsCd(ApprovalCstmsCdVO approvalCstmsCdVO) throws DAOException, Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			if (approvalCstmsCdVO != null) {
				Map<String, String> mapVO = approvalCstmsCdVO.getColumnValues();
				param.putAll(mapVO);
			}
			int result = new SQLExecuter("").executeUpdate((ISQLTemplate) new JapanManifestListDownloadDBDAOmodifyApprovalCstmsCdUSQL(), param, null);
			if (result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to update SQL");
		} catch(SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [ESM_BKG_1511]
	 * Bonded Place Code 목록 조회<br>
	 *
	 * @param CstmsJpWhVO cstmsJpWhVO
	 * @return List<CstmsJpWhVO>
	 * @exception DAOException
	 */
	@SuppressWarnings( { "unchecked", "rawtypes" })
	public List<CstmsJpWhVO> searchCstmsJpWh(CstmsJpWhVO cstmsJpWhVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (cstmsJpWhVO != null) {
				Map<String, String> mapVO = cstmsJpWhVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JapanManifestListDownloadDBDAOsearchCstmsJpWhRSQL(), param, velParam);
			return (List)RowSetUtil.rowSetToVOs(dbRowset, CstmsJpWhVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [ESM_BKG_1511] Data Download
	 * Bonded Place Code 목록 신규 저장<br>
	 *
	 * @param List<CstmsJpWhVO> cstmsJpWhVOList
	 * @exception DAOException, Exception
	 */
	public void addCstmsJpWh(List<CstmsJpWhVO> cstmsJpWhVOList) throws DAOException, Exception {

		try {
			if (cstmsJpWhVOList.size() > 0) {
				int insCnt[] = new SQLExecuter("").executeBatch((ISQLTemplate) new JapanManifestListDownloadDBDAOaddCstmsJpWhCSQL(), cstmsJpWhVOList, null);
				for(int i=0; i<insCnt.length; i++) {
					if (insCnt[i]== Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [ESM_BKG_1511]
	 * Bonded Place Code 목록 수정 저장<br>
	 *
	 * @param List<CstmsJpWhVO> cstmsJpWhVOList
	 * @exception DAOException, Exception
	 */
	public void modifyCstmsJpWh(List<CstmsJpWhVO> cstmsJpWhVOList) throws DAOException, Exception {

		try {
			if (cstmsJpWhVOList.size() > 0) {
				int updCnt[] = new SQLExecuter("").executeBatch((ISQLTemplate) new JapanManifestListDownloadDBDAOmodifyCstmsJpWhUSQL(), cstmsJpWhVOList, null);
				for(int i=0; i<updCnt.length; i++) {
					if (updCnt[i]== Statement.EXECUTE_FAILED) throw new DAOException("Fail to update No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [ESM_BKG_1511]
	 * Bonded Place Code 목록 삭제<br>
	 *
	 * @param List<CstmsJpWhVO> cstmsJpWhVOList
	 * @exception DAOException, Exception
	 */
	public void removeCstmsJpWh(List<CstmsJpWhVO> cstmsJpWhVOList) throws DAOException, Exception {

		try {
			if (cstmsJpWhVOList.size() > 0) {
				int delCnt[] = new SQLExecuter("").executeBatch((ISQLTemplate) new JapanManifestListDownloadDBDAOremoveCstmsJpWhDSQL(), cstmsJpWhVOList, null);
				for(int i=0; i<delCnt.length; i++) {
					if (delCnt[i]== Statement.EXECUTE_FAILED) throw new DAOException("Fail to delete No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}


	/**
	 * [ESM_BKG_1512]
	 * CSTMS_CD Combo Item 목록 조회<br>
	 *
	 * @param CstmsJpWhRoutVO cstmsJpWhRoutVO
	 * @return List<CstmsJpWhRoutVO>
	 * @exception DAOException
	 */
	@SuppressWarnings( { "unchecked", "rawtypes" })
	public List<CstmsJpWhRoutVO> getComboCstmsCd(CstmsJpWhRoutVO cstmsJpWhRoutVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (cstmsJpWhRoutVO != null) {
				Map<String, String> mapVO = cstmsJpWhRoutVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JapanManifestListDownloadDBDAOgetComboCstmsCdRSQL(), param, velParam);
			return (List)RowSetUtil.rowSetToVOs(dbRowset, CstmsJpWhRoutVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [ESM_BKG_1512]
	 * Approval Number and Place of Arrival 목록 조회<br>
	 *
	 * @param CstmsJpWhRoutVO cstmsJpWhRoutVO
	 * @return List<CstmsJpWhRoutVO>
	 * @exception DAOException
	 */
	@SuppressWarnings( { "unchecked", "rawtypes" })
	public List<CstmsJpWhRoutVO> searchCstmsJpWhRout(CstmsJpWhRoutVO cstmsJpWhRoutVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (cstmsJpWhRoutVO != null) {
				Map<String, String> mapVO = cstmsJpWhRoutVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JapanManifestListDownloadDBDAOsearchCstmsJpWhRoutRSQL(), param, velParam);
			return (List)RowSetUtil.rowSetToVOs(dbRowset, CstmsJpWhRoutVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [ESM_BKG_1512] Data Download
	 * Approval Number and Place of Arrival 목록 신규 저장<br>
	 *
	 * @param List<CstmsJpWhRoutVO> cstmsJpWhRoutVOList
	 * @exception DAOException, Exception
	 */
	public void addCstmsJpWhRout(List<CstmsJpWhRoutVO> cstmsJpWhRoutVOList) throws DAOException, Exception {

		try {
			if (cstmsJpWhRoutVOList.size() > 0) {
				int insCnt[] = new SQLExecuter("").executeBatch((ISQLTemplate) new JapanManifestListDownloadDBDAOaddCstmsJpWhRoutCSQL(), cstmsJpWhRoutVOList, null);
				for(int i=0; i<insCnt.length; i++) {
					if (insCnt[i]== Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [ESM_BKG_1512]
	 * Approval Number and Place of Arrival 목록 수정 저장<br>
	 *
	 * @param List<CstmsJpWhRoutVO> cstmsJpWhRoutVOList
	 * @exception DAOException, Exception
	 */
	public void modifyCstmsJpWhRout(List<CstmsJpWhRoutVO> cstmsJpWhRoutVOList) throws DAOException, Exception {

		try {
			if (cstmsJpWhRoutVOList.size() > 0) {
				int updCnt[] = new SQLExecuter("").executeBatch((ISQLTemplate) new JapanManifestListDownloadDBDAOmodifyCstmsJpWhRoutUSQL(), cstmsJpWhRoutVOList, null);
				for(int i=0; i<updCnt.length; i++) {
					if (updCnt[i]== Statement.EXECUTE_FAILED) throw new DAOException("Fail to update No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [ESM_BKG_1512]
	 * Approval Number and Place of Arrival 목록 삭제<br>
	 *
	 * @param List<CstmsJpWhRoutVO> cstmsJpWhRoutVOList
	 * @exception DAOException, Exception
	 */
	public void removeCstmsJpWhRout(List<CstmsJpWhRoutVO> cstmsJpWhRoutVOList) throws DAOException, Exception {

		try {
			if (cstmsJpWhRoutVOList.size() > 0) {
				int delCnt[] = new SQLExecuter("").executeBatch((ISQLTemplate) new JapanManifestListDownloadDBDAOremoveCstmsJpWhRoutDSQL(), cstmsJpWhRoutVOList, null);
				for(int i=0; i<delCnt.length; i++) {
					if (delCnt[i]== Statement.EXECUTE_FAILED) throw new DAOException("Fail to delete No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}


}

