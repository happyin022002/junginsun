/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : KorManifestListDBDAO.java
 *@FileTitle : Korea Manifest List Download DB DAO
 *Open Issues :
 *Change history :
 *@LastModifyDate :
 *@LastModifier :
 *@LastVersion : 1.0
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.vo.DateVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.vo.HjtRcvMsgVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorBkgCstmsVvdSmryVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorMrnCreateInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.basic.JapanManifestListDownloadBCImpl;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.*;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.BkgCstmsKrCustVO;
import com.clt.syscommon.common.table.BkgCstmsKrDlHisVO;
import com.clt.syscommon.common.table.BkgCstmsKrXptLicVO;
import com.clt.syscommon.common.table.BkgRateVO;


/**
 * OPUS JapanManifestListDownloadDBDAO <br>
 * - OPUS-CustomsDeclaration system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author SON YUN SEUK
 * @see JapanManifestListDownloadBCImpl 참조
 * @since J2EE 1.4
 */
public class KorManifestListDBDAO  extends DBDAOSupport {

	private static final long serialVersionUID = 8970020093005417506L;

	/**
	 * KorManifestListDownloadDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 *
	 * @param KorMrnNoVO korMrnNoVO
	 * @return KorMrnNoVO
	 * @exception DAOException
	 **/
	@SuppressWarnings("unchecked")
	public KorMrnNoVO searchMrnNo(KorMrnNoVO korMrnNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		KorMrnNoVO rtnMrnNoVO = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		List<KorMrnNoVO> list = null;

		try {
			if(korMrnNoVO != null) {
				Map<String, String> mapVO = korMrnNoVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);

				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorManifestListDBDAOSearchMrnNoRSQL(),param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, KorMrnNoVO.class);
				if(list.size() > 0) rtnMrnNoVO = list.get(0);
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return rtnMrnNoVO;
	}

	/**
	 * Manifest List정보를 조회하기 위해 우선 MrnNo를 조회한다.
	 * @param KorMrnNoVO korMrnNoVO
	 * @return KorMrnVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public KorMrnVO searchMrnNoKor(KorMrnNoVO korMrnNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		KorMrnVO rtnkorMrnNoVO = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		List<KorMrnVO> list = null;

		try {
			if(korMrnNoVO != null) {
				Map<String, String> mapVO = korMrnNoVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);

				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorManifestListDBDAOSearchMrnNoKorRSQL(),param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, KorMrnVO.class);
				if(list.size() > 0) rtnkorMrnNoVO = list.get(0);
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return rtnkorMrnNoVO;
	}

	/**
	 * ManifestList 조회
	 * @param KorMrnNoVO KorMrnNoVO
	 * @return List<KorManifestInfoVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<KorManifestInfoVO> searchManifestInfoList(KorMrnNoVO KorMrnNoVO)throws DAOException {
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		List<KorManifestInfoVO> list = null;

		try {
			Map<String, String> mapVO = KorMrnNoVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorManifestListDBDAOSearchManifestInfoRSQL(),param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, KorManifestInfoVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return list;
	}

	/**
	 * 세관에 이미 다운로드 시키기 위해 다시 ManifestInfo조회
	 * @param KorMrnNoVO KorMrnNoVO
	 * @return List<KorManifestCrsChkInfoVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<KorManifestCrsChkInfoVO> searchManifestCrsChkInfoKorList(KorMrnNoVO KorMrnNoVO)throws DAOException {
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		List<KorManifestCrsChkInfoVO> list = null;

		try {
			Map<String, String> mapVO = KorMrnNoVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorManifestListDBDAOSearchManifestCrsChkInfoKorRSQL(),param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, KorManifestCrsChkInfoVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return list;
	}

	/**
	 * 세관에 이미 다운로드 시키기 위해 다시 ManifestInfo조회
	 * @param KorMrnNoVO korMrnNoVO
	 * @return List<KorManifestInfoVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<KorManifestInfoVO> searchManifestInfoKorList(KorMrnNoVO korMrnNoVO)throws DAOException {
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		List<KorManifestInfoVO> list = null;

		try {
			Map<String, String> mapVO = korMrnNoVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorManifestListDBDAOSearchManifestInfoKorRSQL(),param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, KorManifestInfoVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return list;
	}

	/**
	 * 컨테이너 정보조회
	 * @param String bkgNo
	 * @param String bkgNoSplit
	 * @return List<KorBkgCntrQtyInfoVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<KorBkgCntrQtyInfoVO> searchCntrInfo(String bkgNo, String bkgNoSplit)throws DAOException {
		//KorBkgCntrQtyInfoVO korBkgCntrQtyInfoVO = null;

		DBRowSet dbRowset = null;
		//KorMrnNoVO korMrnNoVO = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		List<KorBkgCntrQtyInfoVO> list = null;

		try {
			param.put("bkg_no", bkgNo);
			velParam.put("bkg_no", bkgNo);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorManifestListDBDAOSearchCNTRInfoRSQL(),param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, KorBkgCntrQtyInfoVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return list;
	}

	/**
	 * Download 된 컨테이너 목록 조회
	 * @param String bkgNo
	 * @param String tpCd
	 * @param String portCd
	 * @param String vvdCd
	 * @param String cBlNo
	 * @return List<KorBkgCntrQtyInfoVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<KorBkgCntrQtyInfoVO> searchCNTRCntInfoList(String bkgNo, String tpCd, String portCd, String vvdCd, String cBlNo) throws DAOException {
		//KorBkgCntrQtyInfoVO korBkgCntrQtyInfoVO = null;

		DBRowSet dbRowset = null;
		//KorMrnNoVO korMrnNoVO = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		List<KorBkgCntrQtyInfoVO> list = null;

		try {
			Map<String, String> mapVO = new HashMap<String, String>();

			mapVO.put("bkg_no",  bkgNo);
			mapVO.put("tp_cd",   tpCd);
			mapVO.put("port_cd", portCd);
			mapVO.put("vvd_cd",  vvdCd);
			mapVO.put("c_bl_no",  cBlNo);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorManifestListDBDAOsearchCNTRCntInfoListRSQL(),param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, KorBkgCntrQtyInfoVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return list;
	}

	/**
	 * ExportInfo 조회
	 * @param String bkgNo
	 * @param String bkgNoSplit
	 * @return KorExportNoVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public KorExportNoVO searchExportInfo(String bkgNo, String bkgNoSplit) throws DAOException {
		KorExportNoVO korExportNoVO = null;
		DBRowSet dbRowset = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		List<KorExportNoVO> list = null;

		try {
			param.put("a_bkg_no", bkgNo);
			param.put("a_bkg_no_split", bkgNoSplit);
			velParam.put("a_bkg_no", bkgNo);
			velParam.put("a_bkg_no_split", bkgNoSplit);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorManifestListDBDAOSearchExportInfoRSQL(),param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, KorExportNoVO.class);
			if(list.size() > 0) korExportNoVO = list.get(0);

		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return korExportNoVO;
	}

	/**
	 * ExportCheckInfo 조회
	 * @param String bkgNo
	 * @param String bkgNoSplit
	 * @return KorExportCheckInfoVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public KorExportCheckInfoVO searchExportCheckInfo(String bkgNo, String bkgNoSplit) throws DAOException {
		KorExportCheckInfoVO korExportNoVO = null;
		DBRowSet dbRowset = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		List<KorExportCheckInfoVO> list = null;

		try {
			param.put("a_bkg_no", bkgNo);
			param.put("a_bkg_no_split", bkgNoSplit);
			velParam.put("a_bkg_no", bkgNo);
			velParam.put("a_bkg_no_split", bkgNoSplit);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorManifestLIstDBDAOSearchExportCheckInfoRSQL(),param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, KorExportCheckInfoVO.class);
			if(list.size() > 0) korExportNoVO = list.get(0);

		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return korExportNoVO;
	}

	/**
	 * CustInfo 를 조회한다.
	 * @param String in_bound
	 * @param String bkgNo
	 * @param String bkgNoSplit
	 * @return KorCustInfoVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public KorCustInfoVO searchCustInfo(String in_bound, String bkgNo, String bkgNoSplit) throws DAOException {
		KorCustInfoVO korCustInfoVO = null;

		//KorExportCheckInfoVO korExportNoVO = null;
		DBRowSet dbRowset = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		List<KorCustInfoVO> list = null;

		try {
			param.put("in_bound", in_bound);
			param.put("bkg_no", bkgNo);
			velParam.put("in_bound", in_bound);
			velParam.put("bkg_no", bkgNo);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorManifestListDBDAOsearchCustInfoRSQL(),param, velParam);

			list = (List)RowSetUtil.rowSetToVOs(dbRowset, KorCustInfoVO.class);
			if(list.size() > 0) korCustInfoVO = list.get(0);

		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return korCustInfoVO;
	}

	/**
	 * CargoDesc를 구한다.
	 * @param KorCgoDescVO korCgoDescVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchCargoDesc(KorCgoDescVO korCgoDescVO) throws DAOException {
		String korCargoDescVO = null;

		//KorExportCheckInfoVO korExportNoVO = null;
		DBRowSet dbRowset = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();


		try {
			Map<String, String> mapVO = korCgoDescVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorManifestListDBDAOSearchCargoDescRSQL(),param, velParam);
			if(dbRowset.next()) {
				korCargoDescVO = dbRowset.getString("cstms_desc");
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return korCargoDescVO;
	}

	/**
	 * CargoDesc를 구한다.
	 * @param KorCgoDescVO korCgoDescVO
	 * @return KorCgoDescVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public KorCgoDescVO searchCargoDescDN(KorCgoDescVO korCgoDescVO) throws DAOException {
		KorCgoDescVO returnVO = null;
		List<KorCgoDescVO> list = null;
		DBRowSet dbRowset = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = korCgoDescVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorManifestListDBDAOSearchCargoDescDNRSQL(),param, velParam);

			list = (List)RowSetUtil.rowSetToVOs(dbRowset, KorCgoDescVO.class);
			if(list.size() > 0) returnVO = list.get(0);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return returnVO;
	}

	/**
	 * BizNo를 구한다.
	 * @param KorCgoDescVO korBizNoVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchOBBizNo(KorCgoDescVO korBizNoVO) throws DAOException {
		String returnString = null;

		//KorExportCheckInfoVO korExportNoVO = null;
		DBRowSet dbRowset = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = korBizNoVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorManifestListDBDAOSearchOBBizNoRSQL(),param, velParam);
			if(dbRowset.next()) {
				returnString = dbRowset.getString("biz_no");
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return returnString;
	}

	/**
	 * BizNo를 구한다.
	 * @param KorCgoDescVO korBizNoVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchBizNo(KorCgoDescVO korBizNoVO) throws DAOException {
		String returnString = null;

		DBRowSet dbRowset = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = korBizNoVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorManifestListDBDAOSearchBizNoRSQL(),param, velParam);
			if(dbRowset.next()) {
				returnString = dbRowset.getString("biz_no");
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return returnString;
	}

	/**
	 * 컨테이너 타입을 구한다.
	 * @param String bkgNo
	 * @param String bkgNoSplit
	 * @return KorCustVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public KorCustVO searchCntCdTpS(String bkgNo, String bkgNoSplit)throws DAOException {
		KorCustVO returnValue = null;

		DBRowSet dbRowset = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		List<KorCustVO> list = null;

		try {
			param.put("a_bkg_no", bkgNo);
			param.put("a_bkg_no_split", bkgNoSplit);
			velParam.put("a_bkg_no", bkgNo);
			velParam.put("a_bkg_no_split", bkgNoSplit);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorManifestListDBDAOSearchCntCdTpSRSQL(),param, velParam);

			list = (List)RowSetUtil.rowSetToVOs(dbRowset, KorCustVO.class);
			if(list.size() > 0) returnValue = list.get(0);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return returnValue;
	}

	/**
	 * 컨테이너 타입을 구한다.
	 * @param String bkgNo
	 * @param String bkgNoSplit
	 * @return KorCustVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public KorCustVO searchCntCdTpC(String bkgNo, String bkgNoSplit)throws DAOException {
		KorCustVO returnValue = null;

		//KorExportCheckInfoVO korExportNoVO = null;
		DBRowSet dbRowset = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		List<KorCustVO> list = null;

		try {
			param.put("a_bkg_no", bkgNo);
			param.put("a_bkg_no_split", bkgNoSplit);
			velParam.put("a_bkg_no", bkgNo);
			velParam.put("a_bkg_no_split", bkgNoSplit);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorManifestListDBDAOSearchCntCdTpCRSQL(),param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, KorCustVO.class);
			if(list.size() > 0) returnValue = list.get(0);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return returnValue;
	}

	/**
	 * 컨테이너 번호를 구한다.
	 * @param BkgCstmsKrCntrVO bkgCstmsKrCntrVO
	 * @return List<KorCntrNoKorVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<KorCntrNoKorVO> searchCntrNoKorList(BkgCstmsKrCntrVO bkgCstmsKrCntrVO)throws DAOException {
		DBRowSet dbRowset = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		List<KorCntrNoKorVO> list = null;

		try {
			Map<String, String> mapVO = bkgCstmsKrCntrVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorManifestListDBDAOSearchCntrNoKorRSQL(),param, velParam);
			if (dbRowset!=null) list = (List)RowSetUtil.rowSetToVOs(dbRowset, KorCntrNoKorVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return list;

	}

	/**
	 * 컨테이너 정보를 조회한다.
	 * @param String bkgNo
	 * @param String bkgNoSplit
	 * @return KorCustVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public KorCustVO searchCntCdTpN(String bkgNo, String bkgNoSplit)throws DAOException {
		KorCustVO returnValue = null;

		DBRowSet dbRowset = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		List<KorCustVO> list = null;

		try {
			param.put("a_bkg_no", bkgNo);
			param.put("a_bkg_no_split", bkgNoSplit);
			velParam.put("a_bkg_no", bkgNo);
			velParam.put("a_bkg_no_split", bkgNoSplit);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorManifestListDBDAOSearchCntCdTpNRSQL(),param, velParam);

			list = (List)RowSetUtil.rowSetToVOs(dbRowset, KorCustVO.class);
			if(list.size() > 0) returnValue = list.get(0);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return returnValue;
	}

	/**
	 * 국가정보를 조회한다.
	 * @param String bkgNo
	 * @param String bkgNoSplit
	 * @param String bcsTp
	 * @return KorCustVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public KorCustVO searchCountryCode(String bkgNo, String bkgNoSplit, String bcsTp) throws DAOException {
		KorCustVO returnValue = null;

		DBRowSet dbRowset = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		List<KorCustVO> list = null;

		try {
			param.put("a_bkg_no", bkgNo);
			param.put("a_bkg_no_split", bkgNoSplit);
			param.put("biz_no_op", bcsTp);
			velParam.put("a_bkg_no", bkgNo);
			velParam.put("a_bkg_no_split", bkgNoSplit);
			velParam.put("biz_no_op", bcsTp);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorManifestListDBDAOSearchCountryCodeRSQL(),param, velParam);

			list = (List)RowSetUtil.rowSetToVOs(dbRowset, KorCustVO.class);
			if(list.size() > 0) returnValue = list.get(0);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return returnValue;
	}

	/**
	 * RegNo를 조회한다.
	 * @param String cntCd
	 * @param String custCd
	 * @return String
	 * @exception DAOException
	 */
	public String searchRegNo(String cntCd, String custCd)throws DAOException {
		DBRowSet dbRowset = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		String returnString = null;
		try {
			param.put("cnt_cd", cntCd);
			param.put("cust_cd", custCd);
			velParam.put("cnt_cd", cntCd);
			velParam.put("cust_cd", custCd);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorManifestListDBDAOSearchRegNoRSQL(),param, velParam);
			if(dbRowset.next()) {
				returnString = dbRowset.getString(1);
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return returnString;
	}

	/**
	 * ManifestList 조회
	 * @param String inPol
	 * @param KorManifestInfoVO korManifestInfoVO
	 * @return KorManifestInfoVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public KorManifestInfoVO searchIBManifestInfoKor( String inPol, KorManifestInfoVO korManifestInfoVO )throws DAOException {
		KorManifestInfoVO iBManifest = null;
		DBRowSet dbRowset = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		List<KorManifestInfoVO> list = null;

		try {
			param.put("in_pol",   inPol);
			param.put("a_bkg_no", korManifestInfoVO.getBkgNo());
			param.put("in_vvd", korManifestInfoVO.getInVvd());

			velParam.put("in_pol", inPol);
			velParam.put("a_bkg_no", korManifestInfoVO.getBkgNo());
			velParam.put("in_vvd", korManifestInfoVO.getInVvd());

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorManifestListDBDAOsearchIBManifestKorRSQL(),param, velParam);

			list = (List)RowSetUtil.rowSetToVOs(dbRowset, KorManifestInfoVO.class);
			if(list!=null && list.size() > 0) {
				iBManifest = list.get(0);
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return iBManifest;
	}

	/**
	 * Cust정보를 조회한다.
	 * @param KorManifestInfoVO korManifestInfoVO
	 * @return KorManifestInfoVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public KorManifestInfoVO searchCustInfoKor( KorManifestInfoVO korManifestInfoVO )throws DAOException {
		KorManifestInfoVO korCustInfo = null;
		DBRowSet dbRowset = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		List<KorManifestInfoVO> list = null;

		try {
			param.put("a_bkg_no",korManifestInfoVO.getBkgNo());
			param.put("a_tr_cd", korManifestInfoVO.getTp());
			param.put("kt_port", korManifestInfoVO.getKtPort());
			param.put("a_kt_seq",korManifestInfoVO.getHidden3());

			velParam.put("a_bkg_no",korManifestInfoVO.getBkgNo());
			velParam.put("a_tr_cd", korManifestInfoVO.getTp());
			velParam.put("kt_port", korManifestInfoVO.getKtPort());
			velParam.put("a_kt_seq",korManifestInfoVO.getHidden3());

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorManifestListDBDAOSearchCustInfoKorRSQL(),param, velParam);

			list = (List)RowSetUtil.rowSetToVOs(dbRowset, KorManifestInfoVO.class);
			if(list !=null && list.size() > 0) {
				korCustInfo = list.get(0);
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return korCustInfo;
	}

	/**
	 * CustInfoCheck
	 * @param KorManifestInfoVO korManifestInfoVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchCustInfoCheck(KorManifestInfoVO korManifestInfoVO )throws DAOException {
		String returnValue = "";
		DBRowSet dbRowset = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("a_bkg_no",korManifestInfoVO.getBkgNo());
			param.put("a_tr_cd", korManifestInfoVO.getTp());
			param.put("kt_port", korManifestInfoVO.getKtPort());
			param.put("a_kt_seq",korManifestInfoVO.getHidden3());

			velParam.put("a_bkg_no",korManifestInfoVO.getBkgNo());
			velParam.put("a_tr_cd", korManifestInfoVO.getTp());
			velParam.put("kt_port", korManifestInfoVO.getKtPort());
			velParam.put("a_kt_seq",korManifestInfoVO.getHidden3());

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorManifestListDBDAOSearchCustInfoCheckRSQL(),param, velParam);
			if(dbRowset.next()) {
				returnValue = dbRowset.getString("CUST_CHECK");
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return returnValue;
	}

	/**
	 * 컨테이너 토탈 카운트를 구한다.
	 * @param KorManifestInfoVO korManifestInfoVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchCntrTtlCntKor(KorManifestInfoVO korManifestInfoVO )throws DAOException {
		String returnValue = "";
		DBRowSet dbRowset = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("a_bkg_no",korManifestInfoVO.getBkgNo());
			param.put("a_tr_cd", korManifestInfoVO.getTp());
			param.put("kt_port", korManifestInfoVO.getKtPort());
			param.put("a_kt_seq",korManifestInfoVO.getHidden3());
			param.put("c_bl_no",korManifestInfoVO.getCBlNo());

			velParam.put("a_bkg_no",korManifestInfoVO.getBkgNo());
			velParam.put("a_tr_cd", korManifestInfoVO.getTp());
			velParam.put("kt_port", korManifestInfoVO.getKtPort());
			velParam.put("a_kt_seq",korManifestInfoVO.getHidden3());
			velParam.put("c_bl_no", korManifestInfoVO.getCBlNo());

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorManifestListDBDAOSearchCntrTtlCntKorRSQL(),param, velParam);
			if(dbRowset.next()) {
				returnValue = dbRowset.getString("CNT");
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return returnValue;
	}

	/**
	 * ExportInfo정보를 구한다.
	 * @param KorManifestInfoVO korManifestInfoVO
	 * @return KorExportNoVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public KorExportNoVO searchExportInfoKor(KorManifestInfoVO korManifestInfoVO) throws DAOException {
		KorExportNoVO korExportInfo = null;
		DBRowSet dbRowset = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		List<KorExportNoVO> list = null;


		try {
			param.put("a_bkg_no",korManifestInfoVO.getBkgNo());
			param.put("a_tr_cd", korManifestInfoVO.getTp());
			param.put("kt_port", korManifestInfoVO.getKtPort());
			param.put("a_kt_seq",korManifestInfoVO.getHidden3());

			velParam.put("a_bkg_no",korManifestInfoVO.getBkgNo());
			velParam.put("a_tr_cd", korManifestInfoVO.getTp());
			velParam.put("kt_port", korManifestInfoVO.getKtPort());
			velParam.put("a_kt_seq",korManifestInfoVO.getHidden3());

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorManifestListDBDAOSearchExportInfoKorRSQL(),param, velParam);

			list = (List)RowSetUtil.rowSetToVOs(dbRowset, KorExportNoVO.class);
			if(list!=null && list.size()>0) {
				korExportInfo = list.get(0);
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return korExportInfo;
	}

	/**
	 * 다운로드할 Manifest정보를 조회한다.
	 * @param KorManifestInfoVO korManifestInfoVO
	 * @return KorManifestDNVO[]
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public KorManifestDNVO[] searchDownManifestInfo(KorManifestInfoVO korManifestInfoVO) throws DAOException {
		KorManifestDNVO[] korManifestDNVOs = null;
		DBRowSet dbRowset = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		List<KorManifestDNVO> list = null;

		try {
			Map<String, String> mapVO = korManifestInfoVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorManifestListDBDAOSearchDownManifestInfoRSQL(),param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, KorManifestDNVO.class);
			if(list != null && list.size() > 0) {
				korManifestDNVOs = list.toArray(new KorManifestDNVO[0]);
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return korManifestDNVOs;
	}

	/**
	 * 면체여부 체크할 정보를 구한다.
	 * @param String inBkgNo
	 * @return KorRateHeadVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public KorRateHeadVO searchExemptWhf(String inBkgNo) throws DAOException {
		KorRateHeadVO whfNode = null;
		DBRowSet dbRowset = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		List<KorRateHeadVO> list = null;

		try {
			param.put("in_bkg_no", inBkgNo);
			velParam.put("in_bkg_no", inBkgNo);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorManifestListDBDAOSearchExemptWhfRSQL(),param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, KorRateHeadVO.class);
			if(list != null) {
				if(list.size() > 0)	whfNode = list.get(0);
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return whfNode;
	}

	/**
	 * 위험여부 정보를 구한다.
	 * @param String bkgNo
	 * @param String bkgNoSplit
	 * @return String[]
	 * @exception DAOException
	 */
	public String[] searchDangerInfo(String bkgNo, String bkgNoSplit) throws DAOException {
		String[] a_imo_class = new String[3];
		DBRowSet dbRowset = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("a_bkg_no", bkgNo);
			velParam.put("a_bkg_no_split", bkgNoSplit);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorManifestListDBDAOSearchDangerInfoRSQL(),param, velParam);
			int i=0;
//			while(dbRowset.next() && i < 3 )
//			{
//				a_imo_class[i] = dbRowset.getString(1);
//				i++;
//			}
//			for(int j=i;j<3;j++)
//			{
//				a_imo_class[j] = "";
//			}

			// R4J Rule에 의한 변경
			for(int j=0;j<3;j++) {
				a_imo_class[j] = "";
			}
			while(dbRowset.next()){
				if(i<3){
					 a_imo_class[i] = dbRowset.getString(1);
					 i++;
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return a_imo_class;
	}

	/**
	 * BkgCntrList를 구한다.
	 * @param String bkgNo
	 * @param String bkgNoSplit
	 * @return List<KorBkgCntrVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<KorBkgCntrVO> searchBKGCNTRList(String bkgNo, String bkgNoSplit) throws DAOException {
		DBRowSet dbRowset = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		List<KorBkgCntrVO> list = null;

		try {
			param.put("bkg_no", bkgNo);
			velParam.put("bkg_no", bkgNo);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorManifestListDBDAOSearchBKGCNTRListRSQL(),param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, KorBkgCntrVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return list;
	}

	/**
	 * ExportInfo를 구한다.
	 * @param String bkgNo
	 * @param String bkgNoSplit
	 * @return List<KorExportInfoDNVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<KorExportInfoDNVO> searchExportInfoDNList(String bkgNo, String bkgNoSplit) throws DAOException {
		List<KorExportInfoDNVO> list = null;

		DBRowSet dbRowset = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			param.put("a_bkg_no", bkgNo);
			velParam.put("a_bkg_no", bkgNo);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorManifestListDBDAOSearchExportInfoDNRSQL(),param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, KorExportInfoDNVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return list;
	}

	/**
	 * CustomerInfo를 구한다.
	 * @param String bkgNo
	 * @param String bkgNoSplit
	 * @return List<KorBkgCustVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<KorBkgCustVO> searchCustomerInfoList(String bkgNo, String bkgNoSplit) throws DAOException {
		List<KorBkgCustVO> list = null;
		DBRowSet dbRowset = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			param.put("bkg_no", bkgNo);
			velParam.put("bkg_no", bkgNo);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorManifestListDBDAOSearchCustomerInfoRSQL(),param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, KorBkgCustVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return list;
	}

	/**
	 * ElNo를 구한다.
	 * @param ElNoMakeVO elNoMakeVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchElNoMake(ElNoMakeVO elNoMakeVO)throws DAOException {
		String list = null;
		DBRowSet dbRowset = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = elNoMakeVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorManifestListDBDAOSearchElNoMakeRSQL(),param, velParam);
			if(dbRowset.next()) {
				list = dbRowset.getString(1);
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return list;
	}

	/**
	 * 전송된 Manifest History의 Seq정보를 구한다.
	 * @param BkgCstmsKrBlVO bkgCstmsKrBlVO
	 * @return List<BkgCstmsKrBlVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BkgCstmsKrBlVO> searchSeqNSndHistKor(BkgCstmsKrBlVO bkgCstmsKrBlVO) throws DAOException {
		List<BkgCstmsKrBlVO> list = null;
		DBRowSet dbRowset = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = bkgCstmsKrBlVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorManifestListDBDAOSearchSeqNSndHisKorRSQL(),param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgCstmsKrBlVO.class);
			if (list==null || list.size() < 1) return null;
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return list;
	}

	/**
	 * Mrn No를 구한다.
	 * @param KorBkgCstmsVvdSmryVO paramVO
	 * @return KorBkgCstmsVvdSmryVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public KorBkgCstmsVvdSmryVO searchMrnKor(KorBkgCstmsVvdSmryVO paramVO) throws DAOException {
		KorBkgCstmsVvdSmryVO rtnValue = null;

		List<KorBkgCstmsVvdSmryVO> list = null;
		DBRowSet dbRowset = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = paramVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorManifestListDBDAOSearchMrnKorRSQL(),param, velParam);

			list = (List)RowSetUtil.rowSetToVOs(dbRowset, KorBkgCstmsVvdSmryVO.class);
			if(list != null && list.size() > 0) {
				rtnValue = list.get(0);
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return rtnValue;
	}

	/**
	 * 다운로드 히스토리 Insert를 위한 MaxSeq정보를 구한다.
	 * @param BkgCstmsKrDlHisVO bkgCstmsKrDlHisVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchMaxSeqDownHist(BkgCstmsKrDlHisVO bkgCstmsKrDlHisVO) throws DAOException {
		String list = null;
		DBRowSet dbRowset = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = bkgCstmsKrDlHisVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorManifestListDBDAOSearchMaxSeqDownHistRSQL(),param, velParam);
			if(dbRowset.next()) {
				list = dbRowset.getString(1);
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return list;
	}

	/**
	 * 다운로드 히스토리 Insert를 위한 MaxSeq정보를 구한다.
	 * @param String mrnNbr
	 * @param String vvd
	 * @return String
	 * @exception DAOException
	 */
	public String searchMaxSeqDownHistKor(String mrnNbr, String vvd) throws DAOException {
		String cnt = "0";
		DBRowSet dbRowset = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			param.put("mrn_nbr", mrnNbr);
			param.put("vvd", vvd);
			velParam.put("mrn_nbr", mrnNbr);
			velParam.put("vvd", vvd);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorManifestListDBDAOSearchMaxSeqDownHistKorRSQL(),param, velParam);
			if(dbRowset.next()) {
				cnt = dbRowset.getString(1);
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return cnt;
	}

	/**
	 * VVDInfo에서 MaxSeq를 구한다.
	 * @param KorBkgCstmsVvdSmryVO vvdPararm
	 * @return String
	 * @exception DAOException
	 */
	public String searchMaxSeqVVDKor(KorBkgCstmsVvdSmryVO vvdPararm) throws DAOException {
		String list = null;
		DBRowSet dbRowset = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vvdPararm.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorManifestListDBDAOSearchMaxSeqVVDKorRSQL(),param, velParam);

			if(dbRowset.next()) {
				list = dbRowset.getString(1);
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return list;
	}

	/**
	 * 세관에 다운로드된 히스토리건수를 구한다.
	 * @param BkgCstmsKrDlHisVO cntDnHistParam
	 * @return String
	 * @exception DAOException
	 */
	public String searchCountDownHistKor(BkgCstmsKrDlHisVO cntDnHistParam)throws DAOException {
		String list = null;
		DBRowSet dbRowset = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = cntDnHistParam.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorManifestListDBDAOSearchCountDownHistKorRSQL(),param, velParam);

			if(dbRowset.next()) {
				list = dbRowset.getString(1);
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return list;
	}

	/**
	 * 해당 Manifest 의 BlNo를 조회한다.
	 * @param BkgRateVO bkgRateVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchBizNo (BkgRateVO bkgRateVO) throws DAOException {
		String list = null;
		DBRowSet dbRowset = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = bkgRateVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorManifestListDBDAOSearchBizNoRSQL(),param, velParam);

			if(dbRowset.next()) {
				list = dbRowset.getString(1);
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return list;
	}

	/**
	 * Cust 정보를 다운로드하기 위해 Seq값을 구한다.
	 * @param KorBizNoVO korBizNoVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchCustRegNo(KorBizNoVO korBizNoVO)throws DAOException {
		String list = null;
		DBRowSet dbRowset = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = korBizNoVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorManifestListDBDAOSearchCustRegNoRSQL(),param, velParam);

			if(dbRowset.next()) {
				list = dbRowset.getString(1);
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return list;
	}

	/**
	 * ElNo조회
	 * @param KorElNoKorVO elNoVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchElNoKor(KorElNoKorVO elNoVO) throws DAOException {
		String list = null;
		DBRowSet dbRowset = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = elNoVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorManifestListDBDAOSearchElNoKorRSQL(),param, velParam);

			if(dbRowset.next()) {
				list = dbRowset.getString(1);
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return list;
	}

	/**
	 * 세관에 다운로드된 히스토리를 체크한다.
	 * @param BkgCstmsKrDlHisVO bkgCstmsKrDlHisVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchDownHistCheck(BkgCstmsKrDlHisVO bkgCstmsKrDlHisVO) throws DAOException {
		String list = null;
		DBRowSet dbRowset = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = bkgCstmsKrDlHisVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorManifestListDBDAOSearchDownHistCheckRSQL(),param, velParam);

			if(dbRowset.next()) {
				list = dbRowset.getString(1);
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return list;
	}

	/**
	 * 해당 부킹에 BREAK BULK가 있는 지 체크한다.
	 * @param BkgCstmsKrDlHisVO bkgCstmsKrDlHisVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchBreakBulkCheck(BkgCstmsKrDlHisVO bkgCstmsKrDlHisVO) throws DAOException {
		String list = null;
		DBRowSet dbRowset = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = bkgCstmsKrDlHisVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorManifestListDBDAOsearchBreakBulkCheckRSQL(),param, velParam);

			if(dbRowset.next()) {
				list = dbRowset.getString(1);
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return list;
	}

	/**
	 * BkgSts정보를 조회한다.
	 * @param BkgCstmsKrBlVO bkgCstmsKrBlVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchBkgSts(BkgCstmsKrBlVO bkgCstmsKrBlVO)throws DAOException {
		String rtn = null;
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = bkgCstmsKrBlVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorManifestListDBDAOSearchBkgStsRSQL(),param, velParam);
			//list = (List)RowSetUtil.rowSetToVOs(dbRowset, KorManifestInfoVO.class);
			if(dbRowset.next()) {
				rtn = dbRowset.getString(1);
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return rtn;
	}

	/**
	 * 이미 다운로드된 정보를 다시 다운로드 하기 위해 해당 Manifest정보를 ReLoad한다.
	 * @param KorMrnNoVO manifestInfoVO
	 * @return List<KorManifestInfoVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<KorManifestInfoVO> searchReManifestInfoList(KorMrnNoVO manifestInfoVO)throws DAOException {
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		List<KorManifestInfoVO> list = null;

		try {
			Map<String, String> mapVO = manifestInfoVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorManifestListDBDAOSearchReManifestInfoRSQL(),param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, KorManifestInfoVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return list;
	}

	/**
	 * Export정보를 조회한다.
	 * @param BkgCstmsKrXptLicVO bkgCstmsKrXptLicVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchExportChk(BkgCstmsKrXptLicVO bkgCstmsKrXptLicVO) throws DAOException {
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		String rtn = null;
		try {
			Map<String, String> mapVO = bkgCstmsKrXptLicVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorManifestListDBDAOSearchExportChkRSQL(),param, velParam);

			if(dbRowset.next()) {
				rtn = dbRowset.getString(1);
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return rtn;
	}

	/**
	 * 세관에 전송되었는지 여부를 알아본다.
	 * @param BkgCstmsKrBlVO bkgCstmsKrBlVO
	 * @return BkgCstmsKrBlVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public BkgCstmsKrBlVO searchTransmitCheckKor(BkgCstmsKrBlVO bkgCstmsKrBlVO) throws DAOException {
		List<BkgCstmsKrBlVO> list = null;
		BkgCstmsKrBlVO rtnNode = null;
		DBRowSet dbRowset = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = bkgCstmsKrBlVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorManifestListDBDAOSearchTransmitCheckKorRSQL(),param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgCstmsKrBlVO.class);
			if(list != null && list.size() > 0) {
				rtnNode = list.get(0);
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return rtnNode;
	}

	/**
	 * VVD Yard Insert를 위한 Max Seq값을 구한다.
	 * @param KorBkgCstmsVvdSmryVO bkgCstmsKrVvdSmryVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchMaxSeqVVDYard(KorBkgCstmsVvdSmryVO bkgCstmsKrVvdSmryVO) throws DAOException {
		String yd_chk = null;
		DBRowSet dbRowset = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = bkgCstmsKrVvdSmryVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorManifestListDBDAOSearchMaxSeqVVDYardRSQL(),param, velParam);
			if(dbRowset.next()) {
				yd_chk = dbRowset.getString(1);
			}

		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return yd_chk;
	}

	/**
	 * 다운로드하기 위한 max Seq값을 조회한다.
	 * @param KorBkgCstmsVvdSmryVO bkgCstmsKrVvdSmryVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchMaxSendCheckKor(KorBkgCstmsVvdSmryVO bkgCstmsKrVvdSmryVO) throws DAOException {
		String mf_snd_dt = null;
		DBRowSet dbRowset = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = bkgCstmsKrVvdSmryVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorManifestListDBDAOSearchMaxSendCheckKorRSQL(),param, velParam);
			if(dbRowset.next()) {
				mf_snd_dt = dbRowset.getString(1);
			}

		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return mf_snd_dt;
	}

	/**
	 * BkgStatus정보를 조회한다.
	 * @param BkgCstmsKrBlVO bkgCstmsKrBlVO
	 * @return List<BkgCstmsKrBlVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BkgCstmsKrBlVO> searchBkgStsKorList(BkgCstmsKrBlVO bkgCstmsKrBlVO)throws DAOException {
		List<BkgCstmsKrBlVO> list = null;
		DBRowSet dbRowset = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = bkgCstmsKrBlVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorManifestListDBDAOSearchBkgStsKorRSQL(),param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgCstmsKrBlVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return list;
	}

	/**
	 * 세관에 다운로드된 정보가 이미 전송되지 않았는지 여부를 체크한다.
	 * @param BkgCstmsKrBlVO bkgCstmsKrBlVO
	 * @return int
	 * @exception DAOException
	 */
	public int searchNotTransmitCheck(BkgCstmsKrBlVO bkgCstmsKrBlVO) throws DAOException {
		String stringCount = null;
		int returnCount = 0;
		DBRowSet dbRowset = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = bkgCstmsKrBlVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorManifestListDBDAOSearchNotTransmitCheckRSQL(),param, velParam);
			if(dbRowset.next()) {
				stringCount = dbRowset.getString(1);
			}
			if("".equals(stringCount)) stringCount = "0";
			returnCount = Integer.parseInt(stringCount);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return returnCount;
	}

	/**
	 * 세관에 다운로드된 Break Bulk가 포함된경우 이미 전송되지 않았는지 여부를 체크한다.
	 * @param BkgCstmsKrBlVO bkgCstmsKrBlVO
	 * @return int
	 * @exception DAOException
	 */
	public int searchBbNotTransmitCheck(BkgCstmsKrBlVO bkgCstmsKrBlVO) throws DAOException {
		String stringCount = null;
		int returnCount = 0;
		DBRowSet dbRowset = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = bkgCstmsKrBlVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorManifestListDBDAOsearchBbNotTransmitCheckRSQL(),param, velParam);
			if(dbRowset.next()) {
				stringCount = dbRowset.getString(1);
			}
			if("".equals(stringCount)) stringCount = "0";
			returnCount = Integer.parseInt(stringCount);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return returnCount;
	}

	/**
	 * 세관에 다운로드시킬 Trans정보의 Seq번호를 구한다.
	 * @param BkgCstmsKrBlVO bkgCstmsKrBlVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchMaxTransSeqKor(BkgCstmsKrBlVO bkgCstmsKrBlVO)throws DAOException {
		String stringCount = "0";
		DBRowSet dbRowset = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = bkgCstmsKrBlVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorManifestListDBDAOSearchMaxTransSeqKorRSQL(),param, velParam);
			if(dbRowset.next()) {
				stringCount = dbRowset.getString(1);
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return stringCount;
	}

	/**
	 * 세관에 다운로드시킬 Trans정보의 Seq번호를 구한다.(Break Bulk 혼재된 경우)
	 * @param BkgCstmsKrBlVO bkgCstmsKrBlVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchBbMaxTransSeqKor(BkgCstmsKrBlVO bkgCstmsKrBlVO)throws DAOException {
		String stringCount = "0";
		DBRowSet dbRowset = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = bkgCstmsKrBlVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorManifestListDBDAOSearchBbMaxTransSeqKorRSQL(),param, velParam);
			if(dbRowset.next()) {
				stringCount = dbRowset.getString(1);
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return stringCount;
	}

	/**
	 * 세관에 다운로드된 Manifest가 이미 전송되었는지 그 여부를 체크한다.
	 * @param KorBkgCstmsVvdSmryVO bkgCstmsKrVvdSmryVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchSendCheckKor(KorBkgCstmsVvdSmryVO bkgCstmsKrVvdSmryVO) throws DAOException {
		String stringCount = null;
		DBRowSet dbRowset = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = bkgCstmsKrVvdSmryVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorManifestListDBDAOSearchSendCheckKorRSQL(),param, velParam);
			if(dbRowset.next()) {
				stringCount = dbRowset.getString(1);
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return stringCount;
	}

	/**
	 * 인바운드의 경우 TransType을 구한다.
	 * @param KorIbTransWhfVO ibTransWhfVO
	 * @return KorIbTransWhfVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public KorIbTransWhfVO searchIBTransTypeChg(KorIbTransWhfVO ibTransWhfVO) throws DAOException {
		List <KorIbTransWhfVO> list = null;
		KorIbTransWhfVO returnVal = null;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = ibTransWhfVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new KorManifestListDBDAOSearchIBTransTypeChgRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, KorIbTransWhfVO.class);
			if(list == null) return null;
			if(list.size() > 0) {
				returnVal = list.get(0);
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return returnVal;
	}

	/**
	 * 아웃바운드의 경우 TransType을 구한다.
	 * @param KorObTransWhfVO obTransWhfVO
	 * @return KorObTransWhfVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public KorObTransWhfVO searchOBTransTypeChg(KorObTransWhfVO obTransWhfVO) throws DAOException {
		List <KorObTransWhfVO> list = null;
		KorObTransWhfVO returnVal = null;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = obTransWhfVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new KorManifestListDBDAOSearchOBTransTypeChgRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, KorObTransWhfVO.class);
			if(list == null) return null;
			if(list.size() > 0) {
				returnVal = list.get(0);
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return returnVal;
	}

	/**
	 * 세관에 Send Count를 구한다.
	 * @param BkgCstmsKrBlVO bkgCstmsKrBlVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchKorMainSndCount(BkgCstmsKrBlVO bkgCstmsKrBlVO)throws DAOException {
		String transType = null;
		DBRowSet dbRowset = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = bkgCstmsKrBlVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorManifestListDBDAOSearchKorMainSndCountRSQL(),param, velParam);
			if(dbRowset.next()) {
				transType = dbRowset.getString(1);
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return transType;
	}

	/**
	 * 세관으로 Bl정보를 다운로드한다.
	 * @param KorManifestDNVO korManifestDNVO
	 * @return int
	 * @exception DAOException
	 */
	public int addBlInfoKor(KorManifestDNVO korManifestDNVO) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int rtn = 0;
		try {
			Map<String, String> mapVO = korManifestDNVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			rtn = new SQLExecuter("").executeUpdate((ISQLTemplate) new KorManifestListDBDAOaddBlInfoKorCSQL(),param, velParam);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return rtn;
	}

	/**
	 * 세관으로 컨테이너 정보를 다운로드한다.
	 * @param BkgCstmsKrCntrVO bkgCstmsKrCntrVO
	 * @return int
	 * @exception DAOException
	 */
	public int addCNTRInfoKor(BkgCstmsKrCntrVO bkgCstmsKrCntrVO) throws DAOException {
		int insertCount = 0;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = bkgCstmsKrCntrVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			insertCount = new SQLExecuter("").executeUpdate((ISQLTemplate) new KorManifestListDBDAOaddCntrInfoKorCSQL(),param, velParam);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return insertCount;
	}

	/**
	 * 세관으로 ExportNo를 다운로드한다.
	 * @param BkgCstmsKrXptLicVO xptlicVO
	 * @return int
	 * @exception DAOException
	 */
	public int addExportNoMake(BkgCstmsKrXptLicVO xptlicVO) throws DAOException {
		int insertCount = 0;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = xptlicVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			insertCount = new SQLExecuter("").executeUpdate((ISQLTemplate) new KorManifestListDBDAOAddExportNoMakeCSQL(),param, velParam);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			if(se.getErrorCode() == 1) { // 무결성 에러가 날 경우
				throw new DAOException("BKG01125@" + xptlicVO.getCBlNo());
			}

			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return insertCount;
	}

	/**
	 * 세관으로 ExportNo를 다운로드한다.
	 * @param BkgCstmsKrXptLicVO xptlicVO
	 * @return int
	 * @exception DAOException
	 */
	public int addExportNoKor(BkgCstmsKrXptLicVO xptlicVO) throws DAOException {
		int insertCount = 0;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = xptlicVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			insertCount = new SQLExecuter("").executeUpdate((ISQLTemplate) new KorManifestListDBDAOAddExportNoKorCSQL(),param, velParam);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			if(se.getErrorCode() == 1) { // 무결성 에러가 날 경우
				throw new DAOException("BKG01125@" + xptlicVO.getCBlNo());
			}

			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return insertCount;
	}

	/**
	 * 세관으로 ExportNo를 다운로드한다.
	 * @param KorMailBoxVO korMailBoxVO
	 * @return int
	 * @exception DAOException
	 */
	public int addExportNo(KorMailBoxVO korMailBoxVO)throws DAOException {
		int insertCount = 0;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = korMailBoxVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			insertCount = new SQLExecuter("").executeUpdate((ISQLTemplate) new KorManifestListDBDAOAddExportNoCSQL(),param, velParam);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			if(se.getErrorCode() == 1) { // 무결성 에러가 날 경우
				throw new DAOException("BKG01125@" + korMailBoxVO.getCBlNo());
			}
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return insertCount;
	}

	/**
	 * B/L List check후 조회된 Cust 정보 Insert
	 * @param BkgCstmsKrCustVO custKrVO
	 * @return int
	 * @exception DAOException
	 */
	public int addCustInfoKor(BkgCstmsKrCustVO custKrVO)throws DAOException {
		int insertCount = 0;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = custKrVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			insertCount = new SQLExecuter("").executeUpdate((ISQLTemplate) new KorManifestListDBDAOaddCustInfoKorCSQL(),param, velParam);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return insertCount;
	}

	/**
	 * B/L List check후 조회된 Cust 정보 Insert(Break Bulk인 경우)
	 * @param BkgCstmsKrCustVO custKrVO
	 * @return int
	 * @exception DAOException
	 */
	public int addBbCustInfoKor(BkgCstmsKrCustVO custKrVO)throws DAOException {
		int insertCount = 0;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = custKrVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			insertCount = new SQLExecuter("").executeUpdate((ISQLTemplate) new KorManifestListDBDAOaddBbCustInfoKorCSQL(),param, velParam);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return insertCount;
	}

	/**
	 * 세관에 다운로드된 Manifest DownLoad History를 Insert한다.
	 * @param KorDownHistVO korDownHistVO
	 * @return int
	 * @exception DAOException
	 */
	public int addDownHistSeq(KorDownHistVO korDownHistVO) throws DAOException {
		int insertCount = 0;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = korDownHistVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			insertCount = new SQLExecuter("").executeUpdate((ISQLTemplate) new KorManifestListDBDAOAddDownHistSeqCSQL(),param, velParam);
		} catch(SQLException se) {
			int errcd = se.getErrorCode();
			if(errcd != 1) {
				log.error(se.getMessage(), se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			}
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return insertCount;
	}

	/**
	 * 세관에 다운로드된 Manifest DownLoad History를 Insert한다.
	 * @param BkgCstmsKrDlHisVO hisParam
	 * @return int
	 * @exception DAOException
	 */
	public int addDownHistKor(BkgCstmsKrDlHisVO hisParam) throws DAOException {
		int insertCount = 0;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = hisParam.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			insertCount = new SQLExecuter("").executeUpdate((ISQLTemplate) new KorManifestListDBDAOAddDownHistKorCSQL(),param, velParam);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return insertCount;
	}

	/**
	 * 세관에 다운로드된 Manifest DownLoad History를 Insert한다.
	 * @param KorDownHistVO korDownHistVO
	 * @return int
	 * @exception DAOException
	 */
	public int addDownHist(KorDownHistVO korDownHistVO) throws DAOException {
		int insertCount = 0;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = korDownHistVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			insertCount = new SQLExecuter("").executeUpdate((ISQLTemplate) new KorManifestListDBDAOAddDownHistCSQL(),param, velParam);
		} catch(SQLException se) {
			int errcd = se.getErrorCode();
			if(errcd != 1) {
				log.error(se.getMessage(), se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			}
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return insertCount;
	}

	/**
	 * 세관으로 Vessel정보를 다운로드한다.
	 * @param KorBkgCstmsVvdSmryVO vvdParam
	 * @return int
	 * @exception DAOException
	 */
	public int addVVDInfo(KorBkgCstmsVvdSmryVO vvdParam) throws DAOException {
		int insertCount = 0;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = vvdParam.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			insertCount = new SQLExecuter("").executeUpdate((ISQLTemplate) new KorManifestListDBDAOAddVVDInfoCSQL(),param, velParam);
		} catch(SQLException se) {
			int errcd = se.getErrorCode();
			if(errcd != 1) {
				log.error(se.getMessage(), se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			}
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return insertCount;
	}

	/**
	 * 세관에 B/L정보를 다운로드한다.(이미 다운로드되었던 B/L정보)
	 * @param KorManifestDNVO korManifestDNVO
	 * @return int
	 * @exception DAOException
	 */
	public int addReBlInfoKor(KorManifestDNVO korManifestDNVO) throws DAOException {
		int insertCount = 0;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = korManifestDNVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			insertCount = new SQLExecuter("").executeUpdate((ISQLTemplate) new KorManifestListDBDAOAddReBlInfoKorCSQL(),param, velParam);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return insertCount;
	}

	/**
	 * 세관에 ExportNo를 다운로드한다.
	 * @param KorMailBoxVO korMailBoxVO
	 * @return int
	 * @exception DAOException
	 */
	public int addExportNoMailBoxKor(KorMailBoxVO korMailBoxVO)throws DAOException {
		int insertCount = 0;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = korMailBoxVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			insertCount = new SQLExecuter("").executeUpdate((ISQLTemplate) new KorManifestListDBDAOAddExportNoMailBoxKorCSQL(),param, velParam);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			if(se.getErrorCode() == 1) { // 무결성 에러가 날 경우
				throw new DAOException("BKG01125@" + korMailBoxVO.getCBlNo());
			}
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return insertCount;
	}

	/**
	 * 세관에 다운로드된 MrnNo정보를 업데이트한다.
	 * @param KorBkgCstmsVvdSmryVO mrnParam
	 * @return int
	 * @exception DAOException
	 */
	public int modifyMrnNoKor(KorBkgCstmsVvdSmryVO mrnParam) throws DAOException {
		int modifyCount = 0;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = mrnParam.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			modifyCount = new SQLExecuter("").executeUpdate((ISQLTemplate) new KorManifestListDBDAOModifyMrnNoKorUSQL(),param, velParam);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return modifyCount;
	}

	/**
	 * 세관에 다운로드된 히스토리정보를 업데이트한다.
	 * @param BkgCstmsKrDlHisVO bkgCstmsKrDlHisVO
	 * @return int
	 * @exception DAOException
	 */
	public int modifyDownHistKor(BkgCstmsKrDlHisVO bkgCstmsKrDlHisVO) throws DAOException {
		int modifyCount = 0;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = bkgCstmsKrDlHisVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			modifyCount = new SQLExecuter("").executeUpdate((ISQLTemplate) new KorManifestListDBDAOModifyDownHistKorUSQL(),param, velParam);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return modifyCount;
	}

	/**
	 * 세관에 다운로드된 BizNo정보를 업데이트한다.
	 * @param BkgCstmsKrBlVO bkgCstmsKrBlVO
	 * @return int
	 * @exception DAOException
	 */
	public int modifyBizNo(BkgCstmsKrBlVO bkgCstmsKrBlVO) throws DAOException {
		int modifyCount = 0;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = bkgCstmsKrBlVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			modifyCount = new SQLExecuter("").executeUpdate((ISQLTemplate) new KorManifestListDBDAOModifyBizNoUSQL(),param, velParam);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return modifyCount;

	}

	/**
	 * 세관에 다운로드된 삭제 표시 테이블의 정보를 업데이트한다.
	 * @param BkgCstmsKrBlVO bkgCstmsKrBlVO
	 * @return int
	 * @exception DAOException
	 */
	public int modifyDelMarkKor(BkgCstmsKrBlVO bkgCstmsKrBlVO) throws DAOException {
		int modifyCount = 0;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = bkgCstmsKrBlVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			modifyCount = new SQLExecuter("").executeUpdate((ISQLTemplate) new KorManifestListDBDAOModifyDelMarkKorUSQL(),param, velParam);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return modifyCount;
	}

	/**
	 * 다운로드 히스토리를 업데이트 한다.
	 * @param BkgCstmsKrDlHisVO bkgCstmsKrDlHisVO
	 * @return int
	 * @exception DAOException
	 */
	public int modifyDownHist(BkgCstmsKrDlHisVO bkgCstmsKrDlHisVO)throws DAOException {
		int modifyCount = 0;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = bkgCstmsKrDlHisVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			modifyCount = new SQLExecuter("").executeUpdate((ISQLTemplate) new KorManifestListDBDAOModifyDownHistUSQL(),param, velParam);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return modifyCount;
	}

	/**
	 * 세관에 다운로드된 Bl정보중에 가장 최근의 정보를 삭제한다.
	 * @param BkgCstmsKrBlVO bkgCstmsKrBlVO
	 * @return int
	 * @exception DAOException
	 */
	public int removeBlMaxInfoKor(BkgCstmsKrBlVO bkgCstmsKrBlVO) throws DAOException {
		int deleteCount = 0;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = bkgCstmsKrBlVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			deleteCount = new SQLExecuter("").executeUpdate((ISQLTemplate) new KorManifestListDBDAORemoveBlMaxInfoKorDSQL(),param, velParam);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return deleteCount;
	}

	/**
	 * 세관에 다운로드된 Bl정보중에 가장 최근의 정보를 삭제한다.(break bulk 포함된 경우)
	 * @param BkgCstmsKrBlVO bkgCstmsKrBlVO
	 * @return int
	 * @exception DAOException
	 */
	public int removeBbBlMaxInfoKor(BkgCstmsKrBlVO bkgCstmsKrBlVO) throws DAOException {
		int deleteCount = 0;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = bkgCstmsKrBlVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			deleteCount = new SQLExecuter("").executeUpdate((ISQLTemplate) new KorManifestListDBDAORemoveBbBlMaxInfoKorDSQL(),param, velParam);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return deleteCount;
	}

	/**
	 * 세관에 다운로드된 컨테이너 정보중에 가장 최근의 정보를 삭제한다.
	 * @param BkgCstmsKrCntrVO bkgCstmsKrCntrVO
	 * @return int
	 * @exception DAOException
	 */
	public int removeCNTRMaxInfoKor(BkgCstmsKrCntrVO bkgCstmsKrCntrVO) throws DAOException {
		int deleteCount = 0;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = bkgCstmsKrCntrVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			deleteCount = new SQLExecuter("").executeUpdate((ISQLTemplate) new KorManifestListDBDAORemoveCNTRMaxInfoKorDSQL(),param, velParam);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return deleteCount;
	}

	/**
	 * 세관에 다운로드된 컨테이너 정보중에 가장 최근의 정보를 삭제한다.(Break Bulk포함된 경우)
	 * @param BkgCstmsKrCntrVO bkgCstmsKrCntrVO
	 * @return int
	 * @exception DAOException
	 */
	public int removeBbCNTRMaxInfoKor(BkgCstmsKrCntrVO bkgCstmsKrCntrVO) throws DAOException {
		int deleteCount = 0;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = bkgCstmsKrCntrVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			deleteCount = new SQLExecuter("").executeUpdate((ISQLTemplate) new KorManifestListDBDAORemoveBbCNTRMaxInfoKorDSQL(),param, velParam);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return deleteCount;
	}

	/**
	 * 세관에 다운로드된 고객정보중에 가장 최근의 정보를 삭제한다.
	 * @param BkgCstmsKrCustVO bkgCstmsKrCustVO
	 * @return int
	 * @exception DAOException
	 */
	public int removeCustMaxInfoKor(BkgCstmsKrCustVO bkgCstmsKrCustVO) throws DAOException {
		int deleteCount = 0;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = bkgCstmsKrCustVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			deleteCount = new SQLExecuter("").executeUpdate((ISQLTemplate) new KorManifestListDBDAORemoveCustMaxInfoKorDSQL(),param, velParam);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return deleteCount;
	}

	/**
	 * 세관에 다운로드된 고객정보중에 가장 최근의 정보를 삭제한다. (Break Bulk포함된 경우)
	 * @param BkgCstmsKrCustVO bkgCstmsKrCustVO
	 * @return int
	 * @exception DAOException
	 */
	public int removeBbCustMaxInfoKor(BkgCstmsKrCustVO bkgCstmsKrCustVO) throws DAOException {
		int deleteCount = 0;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = bkgCstmsKrCustVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			deleteCount = new SQLExecuter("").executeUpdate((ISQLTemplate) new KorManifestListDBDAORemoveBbCustMaxInfoKorDSQL(),param, velParam);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return deleteCount;
	}

	/**
	 * 세관에 다운로드된 ElNo중에서 가장 최근의 Seq번호를 삭제한다.
	 * @param BkgCstmsKrXptLicVO bkgCstmsKrXptLicVO
	 * @return int
	 * @exception DAOException
	 */
	public int removeElNoMaxInfoKor(BkgCstmsKrXptLicVO bkgCstmsKrXptLicVO) throws DAOException {
		int deleteCount = 0;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = bkgCstmsKrXptLicVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			deleteCount = new SQLExecuter("").executeUpdate((ISQLTemplate) new KorManifestListDBDAORemoveElNoMaxInfoKorDSQL(),param, velParam);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return deleteCount;
	}

	/**
	 * 세관에 다운로드된 ElNo중에서 가장 최근의 Seq번호를 삭제한다.(Break Bulk 포함된 경우)
	 * @param BkgCstmsKrXptLicVO bkgCstmsKrXptLicVO
	 * @return int
	 * @exception DAOException
	 */
	public int removeBbElNoMaxInfoKor(BkgCstmsKrXptLicVO bkgCstmsKrXptLicVO) throws DAOException {
		int deleteCount = 0;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = bkgCstmsKrXptLicVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			deleteCount = new SQLExecuter("").executeUpdate((ISQLTemplate) new KorManifestListDBDAORemoveBbElNoMaxInfoKorDSQL(),param, velParam);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return deleteCount;
	}

	/**
	 * 세관에 다운로드된 컨테이너 정보를 삭제한다.
	 * @param BkgCstmsKrCntrVO bkgCstmsKrCntrVO
	 * @return int
	 * @exception DAOException
	 */
	public int removeCNTRInfoKor(BkgCstmsKrCntrVO bkgCstmsKrCntrVO) throws DAOException {
		int deleteCount = 0;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = bkgCstmsKrCntrVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			deleteCount = new SQLExecuter("").executeUpdate((ISQLTemplate) new KorManifestListDBDAORemoveCNTRInfoKorDSQL(),param, velParam);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return deleteCount;
	}

	/**
	 * 세관에 DownLoad되어 있는 ElNo정보를 삭제한다.
	 * @param BkgCstmsKrXptLicVO bkgCstmsKrXptLicVO
	 * @return int
	 * @exception DAOException
	 */
	public int removeElNoInfoKor(BkgCstmsKrXptLicVO bkgCstmsKrXptLicVO) throws DAOException {
		int deleteCount = 0;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = bkgCstmsKrXptLicVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			deleteCount = new SQLExecuter("").executeUpdate((ISQLTemplate) new KorManifestListDBDAORemoveElNoInfoKorDSQL(),param, velParam);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return deleteCount;
	}

	/**
	 * 세관으로 DownLoad되어 있는 Cust정보를 삭제한다.
	 * @param BkgCstmsKrCustVO bkgCstmsKrCustVO
	 * @return int
	 * @exception DAOException
	 */
	public int removeCustInfoKor(BkgCstmsKrCustVO bkgCstmsKrCustVO) throws DAOException {
		int deleteCount = 0;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = bkgCstmsKrCustVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			deleteCount = new SQLExecuter("").executeUpdate((ISQLTemplate) new KorManifestListDBDAORemoveCustInfoKorDSQL(),param, velParam);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return deleteCount;
	}

	/**
	 * 한국세관 BL 정보 삭제
	 *
	 * @param KorBlInfoDelAmdVO korBlInfoDelAmdVO
	 * @return int
	 * @throws DAOException
	 */
	public int removeBlInfoForDelAmd(KorBlInfoDelAmdVO korBlInfoDelAmdVO) throws DAOException {
		int deleteCount = 0;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = korBlInfoDelAmdVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			deleteCount = new SQLExecuter("").executeUpdate((ISQLTemplate) new KorManifestListDBDAOremoveBlInfoForDelAmdDSQL(),param, velParam);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return deleteCount;
	}

	/**
	 * 세관에 DownLoad되어 있는 Bl정보를 삭제한다.
	 * @param BkgCstmsKrBlVO bkgCstmsKrBlVO
	 * @return int
	 * @exception DAOException
	 */
	public int removeBlInfoKor(BkgCstmsKrBlVO bkgCstmsKrBlVO) throws DAOException {
		int deleteCount = 0;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = bkgCstmsKrBlVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			deleteCount = new SQLExecuter("").executeUpdate((ISQLTemplate) new KorManifestListDBDAORemoveBlInfoKorDSQL(),param, velParam);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return deleteCount;
	}

	/**
	 * VVD , PORT 로 MSN 정보 조회
	 * @param KorMrnInfoVO korMrnInfoVO
	 * @return KorMrnInfoVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public KorMrnInfoVO searchMrnInfoByVVD(KorMrnInfoVO korMrnInfoVO) throws DAOException{
		DBRowSet dbRowset = null;
		KorMrnInfoVO returnData = null;
		List<KorMrnInfoVO> resultList = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = korMrnInfoVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorManifestListDBDAOsearchMrnInfoByVVDRSQL(),param, velParam);
			resultList = (List)RowSetUtil.rowSetToVOs(dbRowset, KorMrnInfoVO.class);
			if(resultList == null) return null;
			if(resultList.size() > 0) {
				returnData = resultList.get(0);
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return returnData;
	}

	/**
	 * MRN 으로 MSN 정보 조회
	 * @param KorMrnInfoVO korMrnInfoVO
	 * @return KorMrnInfoVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public KorMrnInfoVO searchMrnInfoByMRN(KorMrnInfoVO korMrnInfoVO) throws DAOException{
		DBRowSet dbRowset = null;
		KorMrnInfoVO returnData = null;
		List<KorMrnInfoVO> resultList = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = korMrnInfoVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorManifestListDBDAOsearchMrnInfoByMRNRSQL(),param, velParam);
			resultList = (List)RowSetUtil.rowSetToVOs(dbRowset, KorMrnInfoVO.class);
			if(resultList == null) return null;
			if(resultList.size() > 0) {
				returnData = resultList.get(0);
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return returnData;
	}

	/**
	 * IN-Bound Booking 정보 조회
	 * @param KorBkgInfoVO korBkgInfoVO
	 * @return List<KorBkgInfoVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<KorBkgInfoVO> searchIBBkgInfoList(KorBkgInfoVO korBkgInfoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<KorBkgInfoVO> korBkgInfoVOs = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = korBkgInfoVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorManifestListDBDAOsearchIBBkgInfoRSQL(),param, velParam);
			korBkgInfoVOs = (List)RowSetUtil.rowSetToVOs(dbRowset, KorBkgInfoVO.class);
			if(korBkgInfoVOs == null) return null;
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return korBkgInfoVOs;
	}

	/**
	 * Customer Type("C") Count 추출
	 *
	 * @param KorCntCustVO korCntCustVO
	 * @return KorCntCustVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public KorCntCustVO searchCntCustTpC(KorCntCustVO korCntCustVO) throws DAOException {
		DBRowSet dbRowset = null;
		KorCntCustVO returnData = null;
		List<KorCntCustVO> resultList = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = korCntCustVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorManifestListDBDAOsearchCntCustTpCRSQL(),param, velParam);
			resultList = (List)RowSetUtil.rowSetToVOs(dbRowset, KorCntCustVO.class);
			if(resultList == null) return null;
			if(resultList.size() > 0) returnData = resultList.get(0);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return returnData;
	}

	/**
	 * Customer Type("N") Count 추출
	 *
	 * @param KorCntCustVO korCntCustVO
	 * @return KorCntCustVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public KorCntCustVO searchCntCustTpN(KorCntCustVO korCntCustVO) throws DAOException {
		DBRowSet dbRowset = null;
		KorCntCustVO returnData = null;
		List<KorCntCustVO> resultList = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = korCntCustVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorManifestListDBDAOsearchCntCustTpNRSQL(),param, velParam);
			resultList = (List)RowSetUtil.rowSetToVOs(dbRowset, KorCntCustVO.class);
			if(resultList == null) return null;
			if(resultList.size() > 0) returnData = resultList.get(0);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return returnData;
	}

	/**
	 * Discharging Location 조회
	 * @param KorDiscLocVO korDiscLocVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchDiscLoc(KorDiscLocVO korDiscLocVO) throws DAOException {
		DBRowSet dbRowset = null;
		String discCd = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = korDiscLocVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorManifestListDBDAOsearchDiscLocRSQL(),param, velParam);
			if (dbRowset==null) return null;
			if(dbRowset.next())	discCd = dbRowset.getString("OTR_DCHG_CD");
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return discCd;
	}

	/**
	 * MSN Infomation을 관리하는 테이블에서 BKG, MSN별 해당 정보를 조회
	 * @param KorMsnInfoVO inKorMsnInfoVO
	 * @return KorMsnInfoVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public KorMsnInfoVO searchMSNInfo(KorMsnInfoVO inKorMsnInfoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<KorMsnInfoVO> korMsnInfoVOs = null;
		KorMsnInfoVO outKorMsnInfoVO = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = inKorMsnInfoVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorManifestListDBDAOsearchMSNInfoRSQL(),param, velParam);
			korMsnInfoVOs = (List)RowSetUtil.rowSetToVOs(dbRowset, KorMsnInfoVO.class);
			if (korMsnInfoVOs==null) return null;
			if (korMsnInfoVOs.size() > 0) outKorMsnInfoVO = korMsnInfoVOs.get(0);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return outKorMsnInfoVO;
	}

	/**
	 * MSN 정보 INSERT
	 * @param KorMsnInfoVO korMsnInfoVO
	 * @exception DAOException
	 */
	public void addMSNInfo(KorMsnInfoVO korMsnInfoVO) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = korMsnInfoVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			new SQLExecuter("").executeUpdate((ISQLTemplate) new KorManifestListDBDAOaddMSNInfoCSQL(),param, velParam);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * MSN INFO 삭제 처리
	 * @param KorMsnInfoVO korMsnInfoVO
	 * @exception DAOException
	 */
	public void removeMSNInfo(KorMsnInfoVO korMsnInfoVO) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = korMsnInfoVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			new SQLExecuter("").executeUpdate((ISQLTemplate) new KorManifestListDBDAOremoveMSNInfoDSQL(),param, velParam);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * EDI 전송 관련 UPDATE CHECK 조회
	 * @param KorMsnInfoVO korMsnInfoVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchMSNUpdtChk(KorMsnInfoVO korMsnInfoVO) throws DAOException {
		String result = null;
		DBRowSet dbRowset = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = korMsnInfoVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorManifestListDBDAOsearchMSNUpdtChkRSQL(),param, velParam);
			if (dbRowset==null) return null;
			result = "1";
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}

	/**
	 * MSN INFO UPDATE
	 * @param KorMsnInfoVO korMsnInfoVO
	 * @exception DAOException
	 */
	public void modifyMSNInfo(KorMsnInfoVO korMsnInfoVO) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = korMsnInfoVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			new SQLExecuter("").executeUpdate((ISQLTemplate) new KorManifestListDBDAOmodifyMSNInfoUSQL(),param, velParam);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * MRN 조회
	 *
	 * @param KorMrnNoVO korMrnNoVO
	 * @return KorMrnNoVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public KorMrnNoVO searchMrn(KorMrnNoVO korMrnNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<KorMrnNoVO> korMrnNoVOs = null;
		KorMrnNoVO outKorMrnNoVO = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = korMrnNoVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorManifestListDBDAOsearchMRNRSQL(),param, velParam);
			korMrnNoVOs = (List)RowSetUtil.rowSetToVOs(dbRowset, KorMrnNoVO.class);
			if (korMrnNoVOs==null) return null;
			if (korMrnNoVOs.size() > 0) outKorMrnNoVO = korMrnNoVOs.get(0);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return outKorMrnNoVO;
	}

	/**
	 * LOCAL 의 BL TYPE COUNT 조회
	 * @param KorBlTypeCntVO korBlTypeCntVO
	 * @return KorBlTypeCntVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public KorBlTypeCntVO searchIBLocBlTpCnt(KorBlTypeCntVO korBlTypeCntVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<KorBlTypeCntVO> korBlTypeCntVOs = null;
		KorBlTypeCntVO outKorBlTypeCntVO = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = korBlTypeCntVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorManifestListDBDAOsearchIBLocBlTpCntRSQL(),param, velParam);
			korBlTypeCntVOs = (List)RowSetUtil.rowSetToVOs(dbRowset, KorBlTypeCntVO.class);
			if (korBlTypeCntVOs==null) return null;
			if (korBlTypeCntVOs.size() > 0) outKorBlTypeCntVO = korBlTypeCntVOs.get(0);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return outKorBlTypeCntVO;
	}

	/**
	 * TS 의 BL TYPE COUNT 조회
	 * @param KorBlTypeCntVO korBlTypeCntVO
	 * @return KorBlTypeCntVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public KorBlTypeCntVO searchIBTSBlTpCnt(KorBlTypeCntVO korBlTypeCntVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<KorBlTypeCntVO> korBlTypeCntVOs = null;
		KorBlTypeCntVO outKorBlTypeCntVO = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = korBlTypeCntVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorManifestListDBDAOsearchIBTSBlTpCntRSQL(),param, velParam);
			korBlTypeCntVOs = (List)RowSetUtil.rowSetToVOs(dbRowset, KorBlTypeCntVO.class);
			if (korBlTypeCntVOs==null) return null;
			if (korBlTypeCntVOs.size() > 0) outKorBlTypeCntVO = korBlTypeCntVOs.get(0);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return outKorBlTypeCntVO;
	}

	/**
	 * LOCAL Manifest 신고 LIST 조회
	 * @param KorMsnInfoVO korMsnInfoVO
	 * @return List<KorMsnInfoVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<KorMsnInfoVO> searchIBMSNInfoList(KorMsnInfoVO korMsnInfoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<KorMsnInfoVO> korMsnInfoVOs = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = korMsnInfoVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorManifestListDBDAOsearchIBMSNInfoRSQL(),param, velParam);
			korMsnInfoVOs = (List)RowSetUtil.rowSetToVOs(dbRowset, KorMsnInfoVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return korMsnInfoVOs;
	}

	/**
	 * B/L NO 로 BKG_NO 조회
	 * @param KorDiscBondVO discBondVO
	 * @return KorDiscBondVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public KorDiscBondVO searchBkgNoByBl(KorDiscBondVO discBondVO) throws DAOException {
		KorDiscBondVO outKorDiscBondVO = null;
		List<KorDiscBondVO> listKorDiscBondVO = null;

		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = discBondVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorManifestListDBDAOsearchBkgNoByBlRSQL(),param, velParam);
			listKorDiscBondVO = (List)RowSetUtil.rowSetToVOs(dbRowset, KorDiscBondVO.class);
			if (listKorDiscBondVO!=null && listKorDiscBondVO.size() > 0) outKorDiscBondVO = listKorDiscBondVO.get(0);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}


		return outKorDiscBondVO;
	}

	/**
	 * BKG_NO로 B/L NO 조회
	 * @param KorDiscBondVO discBondVO
	 * @return KorDiscBondVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public KorDiscBondVO searchBlNoByBkg(KorDiscBondVO discBondVO) throws DAOException {
		KorDiscBondVO outKorDiscBondVO = null;
		List<KorDiscBondVO> listKorDiscBondVO = null;

		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = discBondVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorManifestListDBDAOsearchBlNoByBkgRSQL(),param, velParam);
			listKorDiscBondVO = (List)RowSetUtil.rowSetToVOs(dbRowset, KorDiscBondVO.class);
			if (listKorDiscBondVO!=null && listKorDiscBondVO.size() > 0) outKorDiscBondVO = listKorDiscBondVO.get(0);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}


		return outKorDiscBondVO;
	}

	/**
	 * BKG_NO로 B/L Description 조회
	 *
	 * @param KorDiscCYBondInfoVO discCyBondInfoVO
	 * @return KorDiscCYBondInfoVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public KorDiscCYBondInfoVO searchDesc(KorDiscCYBondInfoVO discCyBondInfoVO) throws DAOException {
		KorDiscCYBondInfoVO outKorDiscCyBondInfoVO = null;
		List<KorDiscCYBondInfoVO> listKorDiscCyBondInfoVO = null;

		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = discCyBondInfoVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorManifestListDBDAOsearchDescRSQL(),param, velParam);
			listKorDiscCyBondInfoVO = (List)RowSetUtil.rowSetToVOs(dbRowset, KorDiscCYBondInfoVO.class);
			if (listKorDiscCyBondInfoVO!=null && listKorDiscCyBondInfoVO.size() > 0) outKorDiscCyBondInfoVO = listKorDiscCyBondInfoVO.get(0);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}


		return outKorDiscCyBondInfoVO;
	}

	/**
	 * BKG VVD테이블에서 Lane과 Dir code를 조회
	 * @param KorBkgVvdVO bkgVvdVO
	 * @return KorBkgVvdVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public KorBkgVvdVO searchBKGVVD(KorBkgVvdVO bkgVvdVO) throws DAOException {
		KorBkgVvdVO outKorBkgVvdVO = null;
		List<KorBkgVvdVO> listKorBkgVvdVO = null;

		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = bkgVvdVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorManifestListDBDAOsearchBKGVVDRSQL(),param, velParam);
			listKorBkgVvdVO = (List)RowSetUtil.rowSetToVOs(dbRowset, KorBkgVvdVO.class);
			if (listKorBkgVvdVO!=null && listKorBkgVvdVO.size() > 0) outKorBkgVvdVO = listKorBkgVvdVO.get(0);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}


		return outKorBkgVvdVO;
	}

	/**
	 * Discharging Location Name 조회
	 * @param KorDiscLocVO discLocVO
	 * @return String
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public String searchDiscLocName(KorDiscLocVO discLocVO) throws DAOException {
		String locNm = "";
		List<KorDiscLocVO> listKorDiscLocVO = null;

		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = discLocVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorManifestListDBDAOsearchDiscLocNameRSQL(),param, velParam);
			listKorDiscLocVO = (List)RowSetUtil.rowSetToVOs(dbRowset, KorDiscLocVO.class);
			if (listKorDiscLocVO!=null && listKorDiscLocVO.size() > 0) locNm = listKorDiscLocVO.get(0).getLocNm();
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return locNm;
	}

	/**
	 * Wharfage 정보 조회
	 * @param KorWhfExptVO whfExptVO
	 * @return KorWhfExptVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public KorWhfExptVO searchWhfExptInfo(KorWhfExptVO whfExptVO) throws DAOException {
		KorWhfExptVO outKorWhfExptVO = null;
		List<KorWhfExptVO> listKorWhfExptVO = null;

		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = whfExptVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorManifestListDBDAOsearchWhfExptInfoRSQL(),param, velParam);
			listKorWhfExptVO = (List)RowSetUtil.rowSetToVOs(dbRowset, KorWhfExptVO.class);
			if (listKorWhfExptVO!=null && listKorWhfExptVO.size() > 0) outKorWhfExptVO = listKorWhfExptVO.get(0);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}


		return outKorWhfExptVO;
	}

	/**
	 * Discharge CY, Bonded Warehouse, Bonded Type등을 조회
	 *
	 * @param KorDiscCYBondInfoVO discCyBondInfoVO
	 * @return KorDiscCYBondInfoVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public KorDiscCYBondInfoVO searchDiscCYBondInfo(KorDiscCYBondInfoVO discCyBondInfoVO) throws DAOException {
		KorDiscCYBondInfoVO outKorDiscCyBondInfoVO = null;
		List<KorDiscCYBondInfoVO> listKorDiscCyBondInfoVO = null;

		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = discCyBondInfoVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorManifestListDBDAOsearchDiscCYBondInfoRSQL(),param, velParam);
			listKorDiscCyBondInfoVO = (List)RowSetUtil.rowSetToVOs(dbRowset, KorDiscCYBondInfoVO.class);
			if (listKorDiscCyBondInfoVO!=null && listKorDiscCyBondInfoVO.size() > 0) outKorDiscCyBondInfoVO = listKorDiscCyBondInfoVO.get(0);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}


		return outKorDiscCyBondInfoVO;
	}

	/**
	 * D/O No., Update Time 조회
	 *
	 * @param String bkgNo
	 * @return String[]
	 * @exception DAOException
	 */
	public String[] searchDoNoUptTm(String bkgNo) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.put("bkg_no", bkgNo);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorManifestListDBDAOsearchDoNoUptTmRSQL(), param, null);
			String[] result = new String[2];
			if (dbRowset.next()) {
				result[0] = dbRowset.getString("DO_NO");
				result[1] = dbRowset.getString("EVNT_DT");
			} else {
				result[0] = "";
				result[1] = "";
			}
			return result;
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * INBOUND DETAIL Update Check
	 *
	 * @param KorDiscCYBondInfoVO discCYBondInfoVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchIBUpdateChk(KorDiscCYBondInfoVO discCYBondInfoVO) throws DAOException {
		String result = null;
		DBRowSet dbRowset = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = discCYBondInfoVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorManifestListDBDAOsearchIBUpdateChkRSQL(),param, velParam);
			if (dbRowset==null) return null;
			result = "1";
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}

	/**
	 * DISCH LOC HISTORY 추출
	 * @param String bkgNo
	 * @param String mfRefNo
	 * @return KorOldDiscLocVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public KorOldDiscLocVO searchOldDiscLoc(String bkgNo, String mfRefNo) throws DAOException {
		KorOldDiscLocVO korOldDiscLocVO = null;
		List<KorOldDiscLocVO> list = null;
		DBRowSet dbRowset = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("bkg_no", bkgNo);
			mapVO.put("mf_ref_no", mfRefNo);
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorManifestListDBDAOsearchOldDiscLocRSQL(),param, velParam);
			if (dbRowset!=null) list = (List)RowSetUtil.rowSetToVOs(dbRowset, KorOldDiscLocVO.class);
			if (list!=null && list.size() > 0)	korOldDiscLocVO = list.get(0);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return korOldDiscLocVO;
	}

	/**
	 * BKG History Sequence 추출
	 * @param KorBkgHistVO bkgHistVO
	 * @return KorBkgHistVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public KorBkgHistVO searchMaxBKGHistSeq(KorBkgHistVO bkgHistVO) throws DAOException {
		KorBkgHistVO korBkgHistVO = null;
		List<KorBkgHistVO> list = null;
		DBRowSet dbRowset = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = bkgHistVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorManifestListDBDAOsearchMaxBKGHistSeqRSQL(),param, velParam);
			if (dbRowset!=null) list = (List)RowSetUtil.rowSetToVOs(dbRowset, KorBkgHistVO.class);
			if (list!=null && list.size() > 0) korBkgHistVO = list.get(0);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return korBkgHistVO;
	}

	/**
	 * BKG History Detail 의 MAX SEQUENCE 추출
	 * @param KorBkgHistVO bkgHistVO
	 * @return KorBkgHistVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public KorBkgHistVO searchMaxBKGHistSeqDtl(KorBkgHistVO bkgHistVO) throws DAOException {
		KorBkgHistVO korBkgHistVO = null;
		List<KorBkgHistVO> list = null;
		DBRowSet dbRowset = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = bkgHistVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorManifestListDBDAOsearchMaxBKGHistSeqDtlRSQL(),param, velParam);
			if (dbRowset!=null) list = (List)RowSetUtil.rowSetToVOs(dbRowset, KorBkgHistVO.class);
			if (list!=null && list.size() > 0) korBkgHistVO = list.get(0);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return korBkgHistVO;
	}

	/**
	 * 한국세관 신고시 필수 Item인 Discharge CY, Bonded Warehouse, Bonded Type등을 수정
	 *
	 * @param KorDiscCYBondInfoVO discCYBondInfoVO
	 * @exception DAOException
	 */
	public void modifyDiscCYBondInfo(KorDiscCYBondInfoVO discCYBondInfoVO) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = discCYBondInfoVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			new SQLExecuter("").executeUpdate((ISQLTemplate) new KorManifestListDBDAOmodifyDiscCYBondInfoUSQL(),param, velParam);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * B/L Inquiry화면에서 보여지는 B/L Info 를 조회
	 * @param KorBlInqInfoVO blInqInfoVO
	 * @return KorBlInqInfoVO
	 * @exception DAOException
	 */
	public KorBlInqInfoVO searchBlInqInfo(KorBlInqInfoVO blInqInfoVO) throws DAOException {
		KorBlInqInfoVO korBlInqInfoVO = null;
		DBRowSet dbRowset = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = blInqInfoVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorManifestListDBDAOsearchBlInqInfoRSQL(),param, velParam);
			if (dbRowset!=null ) {
				List<Object> rslt = RowSetUtil.rowSetToVOs(dbRowset, KorBlInqInfoVO.class);
				if (rslt!=null && rslt.size() > 0) korBlInqInfoVO = (KorBlInqInfoVO)rslt.get(0);
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return korBlInqInfoVO;
	}

	/**
	 * 한국세관 CNTR테이블에 다운로드된 데이터 조회
	 * @param KorCntrInqInfoVO cntrInqInfoVO
	 * @return KorCntrInqInfoVO[]
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public KorCntrInqInfoVO[] searchCNTRinqInfoList(KorCntrInqInfoVO cntrInqInfoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<KorCntrInqInfoVO> listKorCntrInqInfoVOs = null;
		KorCntrInqInfoVO[] korCntrInqInfoVOs = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = cntrInqInfoVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorManifestListDBDAOsearchCNTRinqInfoListRSQL(),param, velParam);
			listKorCntrInqInfoVOs = (List)RowSetUtil.rowSetToVOs(dbRowset, KorCntrInqInfoVO.class);
			if (listKorCntrInqInfoVOs!=null) {
				korCntrInqInfoVOs = listKorCntrInqInfoVOs.toArray(new KorCntrInqInfoVO[0]);
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return korCntrInqInfoVOs;
	}

	/**
	 * 한국세관 Customer테이블에 다운로드된 데이터 조회
	 * @param KorCustInqInfoVO custInqInfoVO
	 * @return KorCustInqInfoVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public KorCustInqInfoVO searchCustInqInfo(KorCustInqInfoVO custInqInfoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<KorCustInqInfoVO> listKorCustInqInfoVOs = null;
		KorCustInqInfoVO korCustInqInfoVO = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = custInqInfoVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorManifestListDBDAOsearchCustInqInfoListRSQL(),param, velParam);
			listKorCustInqInfoVOs = (List)RowSetUtil.rowSetToVOs(dbRowset, KorCustInqInfoVO.class);
			if (listKorCustInqInfoVOs!=null && listKorCustInqInfoVOs.size() > 0) {
				korCustInqInfoVO = listKorCustInqInfoVOs.get(0);
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return korCustInqInfoVO;
	}

	/**
	 * 한국세관 Elno 테이블에 다운로드된 데이터 조회
	 * @param KorElnoInqInfoVO elnoInqInfoVO
	 * @return KorElnoInqInfoVO[]
	 * @exception DAOException
	 */
	public KorElnoInqInfoVO[] searchElnoInqInfoList(KorElnoInqInfoVO elnoInqInfoVO) throws DAOException {
		KorElnoInqInfoVO[] korElnoInqInfoVOs = null;
		DBRowSet dbRowset = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = elnoInqInfoVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorManifestListDBDAOsearchElnoInqInfoRSQL(),param, velParam);
			if (dbRowset!=null) korElnoInqInfoVOs = RowSetUtil.rowSetToVOs(dbRowset, KorElnoInqInfoVO.class).toArray(new KorElnoInqInfoVO[0]);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return korElnoInqInfoVOs;
	}

	/**
	 * Package Code, Name 조회
	 * @param KorPckInfoVO pckInfoVO
	 * @return KorPckInfoVO[]
	 * @exception DAOException
	 */
	public KorPckInfoVO[] searchPckInfo(KorPckInfoVO pckInfoVO) throws DAOException {
		KorPckInfoVO[] korPckInfoVOs = null;
		DBRowSet dbRowset = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = pckInfoVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorManifestListDBDAOsearchPckInfoRSQL(),param, velParam);
			if (dbRowset!=null) korPckInfoVOs = RowSetUtil.rowSetToVOs(dbRowset, KorPckInfoVO.class).toArray(new KorPckInfoVO[0]);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return korPckInfoVOs;
	}

	/**
	 * Korea Commodity 정보 조회
	 * @param KorCmdtVO korCmdtVO
	 * @return KorCmdtVO[]
	 * @exception DAOException
	 */
	public KorCmdtVO[] searchKorCmdtInfo(KorCmdtVO korCmdtVO) throws DAOException {
		KorCmdtVO[] korCmdtVOs = null;
		DBRowSet dbRowset = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = korCmdtVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorManifestListDBDAOsearchKorCmdtInfoRSQL(),param, velParam);
			if (dbRowset!=null) korCmdtVOs = RowSetUtil.rowSetToVOs(dbRowset, KorCmdtVO.class).toArray(new KorCmdtVO[0]);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return korCmdtVOs;
	}

	/**
	 * MDM에서 CNTR Type Size별 코드를 추출
	 * @param KorCntrTpSzVO cntrTpSzVO
	 * @return KorCntrTpSzVO[]
	 * @exception DAOException
	 */
	public KorCntrTpSzVO[] searchCntrTpSz(KorCntrTpSzVO cntrTpSzVO) throws DAOException {
		KorCntrTpSzVO[] korCntrTpSzVOs = null;
		DBRowSet dbRowset = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = cntrTpSzVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorManifestListDBDAOsearchCntrTpSzRSQL(),param, velParam);
			if (dbRowset!=null) korCntrTpSzVOs = RowSetUtil.rowSetToVOs(dbRowset, KorCntrTpSzVO.class).toArray(new KorCntrTpSzVO[0]);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return korCntrTpSzVOs;
	}

	/**
	 * ADD B/L 시 BL 정보 INSERT
	 * @param KorBlInqInfoVO blInqInfoVO
	 * @exception DAOException
	 */
	public void addBlInqInfo(KorBlInqInfoVO blInqInfoVO) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = blInqInfoVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			new SQLExecuter("").executeUpdate((ISQLTemplate) new KorManifestListDBDAOaddBlInqInfoCSQL(),param, velParam);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * BL별 Container 정보, EL등 정보를 맞추기 위하여 Max SEQ 조회
	 * @param BkgCstmsKrBlVO bkgCstmsKrBlVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchMaxSeq(BkgCstmsKrBlVO bkgCstmsKrBlVO) throws DAOException {
		String seq = "0";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		DBRowSet dbRowset = null;
		try {
			Map<String, String> mapVO = bkgCstmsKrBlVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorManifestListDBDAOsearchMaxSeqRSQL(),param, velParam);
			if(dbRowset.next()) seq = dbRowset.getString("TRNS_SEQ");
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return seq;
	}

	/**
	 * Add B/L 후 입력된 Customer 정보를 Insert
	 * @param KorCustInqInfoVO custInqInfoVO
	 * @exception DAOException
	 */
	public void addCustInqInfo(KorCustInqInfoVO custInqInfoVO) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = custInqInfoVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			new SQLExecuter("").executeUpdate((ISQLTemplate) new KorManifestListDBDAOaddCustInqInfoCSQL(),param, velParam);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * CNTR 정보를 Insert하기에 앞서서 Delete
	 * @param KorCntrInqInfoVO cntrInqInfoVO
	 * @exception DAOException
	 */
	public void removeCNTRInqInfo(KorCntrInqInfoVO cntrInqInfoVO) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = cntrInqInfoVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			new SQLExecuter("").executeUpdate((ISQLTemplate) new KorManifestListDBDAOremoveCNTRInqInfoDSQL(),param, velParam);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Container 정보 INSERT
	 * @param KorCntrInqInfoVO cntrInqInfoVO
	 * @exception DAOException
	 */
	public void addCNTRInqInfo(KorCntrInqInfoVO cntrInqInfoVO) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = cntrInqInfoVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			new SQLExecuter("").executeUpdate((ISQLTemplate) new KorManifestListDBDAOaddCNTRInqInfoCSQL(),param, velParam);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Export Lic No 삭제
	 * @param KorElnoInqInfoVO elnoInqInfoVO
	 * @exception DAOException
	 */
	public void removeElnoInqInfo(KorElnoInqInfoVO elnoInqInfoVO) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = elnoInqInfoVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			new SQLExecuter("").executeUpdate((ISQLTemplate) new KorManifestListDBDAOremoveElnoInqInfoDSQL(),param, velParam);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Export Lic No INSERT
	 * @param KorElnoInqInfoVO elnoInqInfoVO
	 * @exception DAOException
	 */
	public void addElnoInqInfo(KorElnoInqInfoVO elnoInqInfoVO) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = elnoInqInfoVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			new SQLExecuter("").executeUpdate((ISQLTemplate) new KorManifestListDBDAOaddElnoInqInfoCSQL(),param, velParam);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Edit B/L 된후 B/L 정보를 UPDATE
	 * @param KorBlInqInfoVO blInqInfoVO
	 * @return int
	 * @exception DAOException
	 */
	public int modifyBlInqInfo(KorBlInqInfoVO blInqInfoVO) throws DAOException {
		int modifyCount = 0;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = blInqInfoVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			modifyCount = new SQLExecuter("").executeUpdate((ISQLTemplate) new KorManifestListDBDAOmodifyBlInqInfoUSQL(),param, velParam);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return modifyCount;
	}

	/**
	 * Edit B/L 후 Customer 정보 UPDATE
	 * @param KorCustInqInfoVO custInqInfoVO
	 * @return int
	 * @exception DAOException
	 */
	public int modifyCustInqInfo(KorCustInqInfoVO custInqInfoVO) throws DAOException {
		int modifyCount = 0;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = custInqInfoVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			modifyCount = new SQLExecuter("").executeUpdate((ISQLTemplate) new KorManifestListDBDAOmodifyCustInqInfoUSQL(),param, velParam);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return modifyCount;
	}

	/**
	 * 초기 BKG NO 를 만든다.
	 * @return String
	 * @exception DAOException
	 */
	public String searchFirstTmpBkgNoAssign() throws DAOException {
		String bkgNo = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		DBRowSet dbRowset = null;
		try {
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorManifestListDBDAOsearchFirstTmpBkgNoAssignRSQL(),param, velParam);
			if(dbRowset.next()) bkgNo = dbRowset.getString("BKG_NO");
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return bkgNo;
	}

	/**
	 * 초기 BL No 생성
	 * @return String
	 * @exception DAOException
	 */
	public String searchFirstTmpBlNoAssign() throws DAOException {
		String blNo = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		DBRowSet dbRowset = null;
		try {
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorManifestListDBDAOsearchFirstTmpBlNoAssignRSQL(),param, velParam);
			if(dbRowset.next()) blNo = dbRowset.getString("BL_NO");
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return blNo;
	}

	/**
	 * 생성된 BL 번호가 존재하는지 확인
	 * @param BkgCstmsKrBlVO bkgCstmsKrBlVO
	 * @return int
	 * @exception DAOException
	 */
	public int searchTmpBlExistKor(BkgCstmsKrBlVO bkgCstmsKrBlVO) throws DAOException {
		int cnt =0;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		DBRowSet dbRowset = null;
		try {
			Map<String, String> mapVO = bkgCstmsKrBlVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorManifestListDBDAOsearchTmpBlExistKorRSQL(),param, velParam);
			if(dbRowset.next()) cnt = dbRowset.getInt("CNT");
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return cnt;
	}

	/**
	 * 생성된 BKG NO와 Seq를 합쳐 새로운 BKG No를 생성
	 * @param KorBkgGenVO bkgGenVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchSndTmpBkgNoAssign(KorBkgGenVO bkgGenVO) throws DAOException {
		String bkgNo = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		DBRowSet dbRowset = null;
		try {
			Map<String, String> mapVO = bkgGenVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorManifestListDBDAOsearchSndTmpBkgNoAssignRSQL(),param, velParam);
			if(dbRowset.next()) bkgNo = dbRowset.getString("BKG_NO");
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return bkgNo;
	}

	/**
	 * BKG NO 자동 생성 ( PACKAGE 이용 )
	 * @param String ofcCd
	 * @param String usrId
	 * @return String
	 * @exception DAOException
	 */
	public String searchFirstTmpBkgNoAssign(String ofcCd, String usrId) throws DAOException {
		String bkgNo = "";

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		DBRowSet dbRowset = null;
		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("ofc_cd", ofcCd);
			mapVO.put("usr_id", usrId);
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorManifestListDBDAOsearchFirstTmpBkgNoAssignRSQL(),param, velParam);
			if(dbRowset.next()) bkgNo = dbRowset.getString("BKG_NO");
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return bkgNo;
	}

	/**
	 * MSN Number의 최대값 조회해서 +1을 해준 값을 리턴
	 * @param BkgCstmsKrMfSeqNoVO bkgCstmsKrMfSeqNoVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchMaxMsnNo(BkgCstmsKrMfSeqNoVO bkgCstmsKrMfSeqNoVO) throws DAOException {
		String msnNo = "";

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		DBRowSet dbRowset = null;
		try {
			Map<String, String> mapVO = bkgCstmsKrMfSeqNoVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorManifestListDBDAOsearchMaxMsnNoRSQL(),param, velParam);
			if(dbRowset.next()) msnNo = dbRowset.getString("MSN_NO");
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return msnNo;
	}

	/**
	 * 입력값(MRN_NO, VVD)에 해당하는 MRN_MODE 조회
	 * @param BkgCstmsKrMfRefNoVO bkgCstmsKrMfRefNoVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchMrnMode(BkgCstmsKrMfRefNoVO bkgCstmsKrMfRefNoVO) throws DAOException {
		String ioBndCd = "";

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		DBRowSet dbRowset = null;
		try {
			Map<String, String> mapVO = bkgCstmsKrMfRefNoVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorManifestListDBDAOsearchMrnModeRSQL(),param, velParam);
			if(dbRowset.next()) ioBndCd = dbRowset.getString("IO_BND_CD");
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return ioBndCd;
	}

	/**
	 * 한국세관 신고시 필수 내역인 Disch CY, Bonded WH, Bonded Type등 조회
	 * @param KorBondedInfoVO bondLocalInfoVO
	 * @return KorBondLocalInfoVO[]
	 * @exception DAOException
	 */
	public KorBondLocalInfoVO[] searchBondLocalInfoList(KorBondedInfoVO bondLocalInfoVO) throws DAOException {
		KorBondLocalInfoVO[] korBondLocalInfoVOs = null;
		DBRowSet dbRowset = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = bondLocalInfoVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorManifestListDBDAOsearchBondLocalInfoListRSQL(),param, velParam);
			if (dbRowset!=null) korBondLocalInfoVOs = RowSetUtil.rowSetToVOs(dbRowset, KorBondLocalInfoVO.class).toArray(new KorBondLocalInfoVO[0]);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return korBondLocalInfoVOs;
	}

	/**
	 * 한국세관 신고시 필수 내역인 Bonded Info T/S정보를 조회한다.
	 * @param KorBondedInfoVO bondTsInfoVO
	 * @return KorBondTsInfoVO[]
	 * @exception DAOException
	 */
	public KorBondTsInfoVO[] searchBondTsInfoList(KorBondedInfoVO bondTsInfoVO) throws DAOException {
		KorBondTsInfoVO[] korBondTsInfoVOs = null;
		DBRowSet dbRowset = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = bondTsInfoVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorManifestListDBDAOsearchBondTsInfoListRSQL(),param, velParam);
			if (dbRowset!=null) korBondTsInfoVOs = RowSetUtil.rowSetToVOs(dbRowset, KorBondTsInfoVO.class).toArray(new KorBondTsInfoVO[0]);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return korBondTsInfoVOs;
	}

	/**
	 * Bonded WareHouse 코드 조회
	 * @param String cstmsCd
	 * @return String
	 * @exception DAOException
	 */
	public String searchWareHouseLoc(String cstmsCd) throws DAOException {
		String locCd = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		Map<String, String> mapVO = new HashMap<String, String>();

		DBRowSet dbRowset = null;
		try {
			mapVO.put("cstms_cd", cstmsCd);
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorManifestListDBDAOsearchWarehouseLocRSQL(),param, velParam);
			if(dbRowset.next()) locCd = dbRowset.getString("LOC_CD");
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return locCd;
	}

	/**
	 * MRN_NO,MSN_CSTMCTP,MSN_CSTMCWH 변경 일자 입력을 위한 사전 확인작업
	 * @param BkgCstmsKrMfSeqNoVO bkgCstmsKrMfSeqNoVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchMsnUpdate(BkgCstmsKrMfSeqNoVO bkgCstmsKrMfSeqNoVO) throws DAOException {
		String updateChk = "Y";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		DBRowSet dbRowset = null;
		try {
			Map<String, String> mapVO = bkgCstmsKrMfSeqNoVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorManifestListDBDAOsearchMsnUpdateRSQL(),param, velParam);
			if(dbRowset.next()) updateChk = dbRowset.getString("UPDATE_CHK");
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return updateChk;
	}

	/**
	 * Bonded Information update
	 * @param BkgCstmsKrMfSeqNoVO bkgCstmsKrMfSeqNoVO
	 * @exception DAOException
	 */
	public void modifyBondedInfo(BkgCstmsKrMfSeqNoVO bkgCstmsKrMfSeqNoVO) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = bkgCstmsKrMfSeqNoVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			new SQLExecuter("").executeUpdate((ISQLTemplate) new KorManifestListDBDAOmodifyBondedInfoUSQL(),param, velParam);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Container No가 추가되었을때 해당 CNTR의 Type을 조회
	 * @param KorContainerCondVO containerCondVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchContainerType(KorContainerCondVO containerCondVO) throws DAOException {
		String tpszCd = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		DBRowSet dbRowset = null;
		try {
			Map<String, String> mapVO = containerCondVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorManifestListDBDAOsearchContainerTypeRSQL(),param, velParam);
			if(dbRowset.next()) tpszCd = dbRowset.getString("CNTR_TPSZ_CD");
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return tpszCd;
	}

	/**
	 * Cargo Spec 자동 조회를 위한 SUM 체크
	 * @param KorCgoSpecVO cgoSpecVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchCgoSpec(KorCgoSpecVO cgoSpecVO) throws DAOException {
		String cgoSpec = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		DBRowSet dbRowset = null;
		try {
			Map<String, String> mapVO = cgoSpecVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorManifestListDBDAOsearchCgoSpecRSQL(),param, velParam);
			if(dbRowset.next()) cgoSpec = dbRowset.getString(1);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return cgoSpec;
	}

	/**
	 * Amend Info 조회
	 * @param KorAmendInfoVO amendInfoVO
	 * @return KorAmendInfoVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public KorAmendInfoVO searchAmendInfo(KorAmendInfoVO amendInfoVO) throws DAOException {
		DBRowSet dbRowset = null;
		KorAmendInfoVO korAmendInfoVO = null;
		List<KorAmendInfoVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = amendInfoVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorManifestListDBDAOsearchAmendInfoRSQL(),param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, KorAmendInfoVO.class);
			if(list!=null && list.size() > 0) korAmendInfoVO = list.get(0);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return korAmendInfoVO;
	}

	/**
	 * In-Bound 의 경우 Korea Cust 테이블에서 CNT, CODE 를 조회
	 * @param KorCntCustVO cntCustVO
	 * @return KorCntCustVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public KorCntCustVO searchIBCntCustTypeC(KorCntCustVO cntCustVO) throws DAOException {
		DBRowSet dbRowset = null;
		KorCntCustVO korCntCustVO = null;
		List<KorCntCustVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = cntCustVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorManifestListDBDAOsearchIBCntCustTypeCRSQL(),param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, KorCntCustVO.class);
			if(list!=null && list.size() > 0) korCntCustVO = list.get(0);

		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return korCntCustVO;
	}

	/**
	 * searchIBCntCustTypeC에서 cnt_cd의 값이 " " (값이 없을 경우) 일 경우 Type N을 조회
	 * @param KorCntCustVO cntCustVO
	 * @return KorCntCustVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public KorCntCustVO searchIBCntCustTypeN(KorCntCustVO cntCustVO) throws DAOException {
		DBRowSet dbRowset = null;
		KorCntCustVO korCntCustVO = null;
		List<KorCntCustVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = cntCustVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorManifestListDBDAOsearchIBCntCustTypeNRSQL(),param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, KorCntCustVO.class);
			if(list!=null && list.size() > 0) korCntCustVO = list.get(0);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return korCntCustVO;
	}

	/**
	 * OUT-BOUND 의 경우 CUST 테이블의 CNT, CODE 조회
	 * @param KorCntCustVO cntCustVO
	 * @return KorCntCustVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public KorCntCustVO searchOBCntCustTypeS(KorCntCustVO cntCustVO) throws DAOException {
		DBRowSet dbRowset = null;
		KorCntCustVO korCntCustVO = null;
		List<KorCntCustVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = cntCustVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorManifestListDBDAOsearchOBCntCustTypeSRSQL(),param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, KorCntCustVO.class);
			if(list!=null && list.size() > 0) korCntCustVO = list.get(0);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return korCntCustVO;
	}

	/**
	 * OUT-BOUND 의 경우 MRN, VVD 정보 조회
	 * @param KorMrnVvdInfoVO mrnVvdInfoVO
	 * @return KorMrnVvdInfoVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public KorMrnVvdInfoVO searchOBMRNVVDInfo(KorMrnVvdInfoVO mrnVvdInfoVO) throws DAOException {
		DBRowSet dbRowset = null;
		KorMrnVvdInfoVO korMrnVvdInfoVO = null;
		List<KorMrnVvdInfoVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = mrnVvdInfoVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorManifestListDBDAOsearchOBMRNVVDInfoRSQL(),param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, KorMrnVvdInfoVO.class);
			if(list!=null && list.size() > 0) korMrnVvdInfoVO = list.get(0);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return korMrnVvdInfoVO;
	}

	/**
	 * IN-BOUND 의 경우 MRN, VVD 정보 조회
	 * @param KorMrnVvdInfoVO mrnVvdInfoVO
	 * @return KorMrnVvdInfoVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public KorMrnVvdInfoVO searchIBMRNVVDInfo(KorMrnVvdInfoVO mrnVvdInfoVO) throws DAOException {
		DBRowSet dbRowset = null;
		KorMrnVvdInfoVO korMrnVvdInfoVO = null;
		List<KorMrnVvdInfoVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = mrnVvdInfoVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorManifestListDBDAOsearchIBMRNVVDInfoRSQL(),param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, KorMrnVvdInfoVO.class);
			if(list!=null && list.size() > 0) korMrnVvdInfoVO = list.get(0);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return korMrnVvdInfoVO;
	}

	/**
	 * Korea Correction 테이블에 SUB_NO가 있는지 여부 check
	 * @param KorCorrVO corrVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchSubmitNoCheck(KorCorrVO corrVO) throws DAOException {

		DBRowSet dbRowset = null;
		String submitCheck = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = corrVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorManifestListDBDAOsearchSubmitNoCheckRSQL(),param, velParam);
			if (dbRowset!=null && dbRowset.next()) submitCheck = dbRowset.getString(1);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return submitCheck;
	}

	/**
	 * 세관전송된 B/L정보 및 Correction정보를 조회 ( TRANS CHECK = Y )
	 * @param KorCorrTransVO corrTransVO
	 * @return KorCorrTransVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public KorCorrTransVO searchBlCorrTransY(KorCorrTransVO corrTransVO) throws DAOException {
		DBRowSet dbRowset = null;
		KorCorrTransVO korCorrTransVO = null;
		List<KorCorrTransVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = corrTransVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorManifestListDBDAOsearchBlCorrTransYRSQL(),param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, KorCorrTransVO.class);
			if(list!=null && list.size() > 0) korCorrTransVO = list.get(0);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return korCorrTransVO;
	}

	/**
	 * 세관전송되지 않은 B/L정보 및 Correction정보를 조회 ( TRANS CHECK = N )
	 * @param KorCorrTransVO corrTransVO
	 * @return KorCorrTransVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public KorCorrTransVO searchBlCorrTransN(KorCorrTransVO corrTransVO) throws DAOException {
		DBRowSet dbRowset = null;
		KorCorrTransVO korCorrTransVO = null;
		List<KorCorrTransVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = corrTransVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorManifestListDBDAOsearchBlCorrTransNRSQL(),param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, KorCorrTransVO.class);
			if(list!=null && list.size() > 0) korCorrTransVO = list.get(0);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return korCorrTransVO;
	}

	/**
	 * BL별 Container 정보 조회
	 * @param KorCntrCorrVO cntrCorrVO
	 * @return KorCntrCorrVO[]
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public KorCntrCorrVO[] searchCNTRCorrInfo(KorCntrCorrVO cntrCorrVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<KorCntrCorrVO> listKorCntrCorrVOs = null;
		KorCntrCorrVO[] korCntrCorrVOs = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = cntrCorrVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorManifestListDBDAOsearchCNTRCorrInfoRSQL(),param, velParam);
			if (dbRowset!=null) {
				listKorCntrCorrVOs = (List)RowSetUtil.rowSetToVOs(dbRowset, KorCntrCorrVO.class);
				if (listKorCntrCorrVOs!=null) {
					korCntrCorrVOs = listKorCntrCorrVOs.toArray(new KorCntrCorrVO[0]);
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return korCntrCorrVOs;
	}

	/**
	 * Customer 정보 조회
	 * @param KorCustCorrVO custCorrVO
	 * @return KorCustCorrVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public KorCustCorrVO searchCustCorrInfo(KorCustCorrVO custCorrVO) throws DAOException {
		DBRowSet dbRowset = null;
		KorCustCorrVO korCustCorrVO = null;
		List<KorCustCorrVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = custCorrVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorManifestListDBDAOsearchCustCorrInfoRSQL(),param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, KorCustCorrVO.class);
			if(list!=null && list.size() > 0) korCustCorrVO = list.get(0);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return korCustCorrVO;
	}

	/**
	 * Export License정보를 조회
	 * @param KorExpCorrVO expCorrVO
	 * @return KorExpCorrVO[]
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public KorExpCorrVO[] searchExportCorrInfo(KorExpCorrVO expCorrVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<KorExpCorrVO> listKorExpCorrVOs = null;
		KorExpCorrVO[] korExpCorrVOs = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = expCorrVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorManifestListDBDAOsearchExportCorrInfoRSQL(),param, velParam);
			if (dbRowset!=null) {
				listKorExpCorrVOs = (List)RowSetUtil.rowSetToVOs(dbRowset, KorExpCorrVO.class);
				if (listKorExpCorrVOs!=null) {
					korExpCorrVOs = listKorExpCorrVOs.toArray(new KorExpCorrVO[0]);
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return korExpCorrVOs;
	}

	/**
	 * BL 별 Corr List 조회
	 * @param KorCorrListVO corrListVO
	 * @return KorCorrListVO[]
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public KorCorrListVO[] searchCorrList(KorCorrListVO corrListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<KorCorrListVO> listKorCorrListVOs = null;
		KorCorrListVO[] korCorrListVOs = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = corrListVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorManifestListDBDAOsearchCorrListRSQL(),param, velParam);
			if (dbRowset!=null) {
				listKorCorrListVOs = (List)RowSetUtil.rowSetToVOs(dbRowset, KorCorrListVO.class);
				if (listKorCorrListVOs!=null) {
					korCorrListVOs = listKorCorrListVOs.toArray(new KorCorrListVO[0]);
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return korCorrListVOs;
	}

	/**
	 * Amendment B/L 정보 추가
	 * @param KorBlAmdVO blAmdVO
	 * @exception DAOException
	 */
	public void addBlAmdInfo(KorBlAmdVO blAmdVO) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = blAmdVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			new SQLExecuter("").executeUpdate((ISQLTemplate) new KorManifestListDBDAOaddBlAmdInfoCSQL(),param, velParam);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * 전송여부 체크
	 * @param KorCorrTransVO corrTransVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchCorrTransChk(KorCorrTransVO corrTransVO) throws DAOException {
		DBRowSet dbRowset = null;
		String transChk = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = corrTransVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorManifestListDBDAOsearchCorrTransChkRSQL(),param, velParam);
			if (dbRowset.next()) transChk = dbRowset.getString(1);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return transChk;
	}

	/**
	 * Submit No 생성
	 * @param KorMakeSubNoVO makeSubNoVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchMakeSubNo(KorMakeSubNoVO makeSubNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		String subNo = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = makeSubNoVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorManifestListDBDAOsearchMakeSubNoRSQL(),param, velParam);
			if (dbRowset.next()) subNo = dbRowset.getString(1);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return subNo;
	}

	/**
	 * Amendment 정정 정보 삭제
	 * @param String subNo
	 * @exception DAOException
	 */
	public void removeCorrInfo(String subNo) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("sub_no", subNo);
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			new SQLExecuter("").executeUpdate((ISQLTemplate) new KorManifestListDBDAOremoveCorrInfoDSQL(),param, velParam);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

	}

	/**
	 * Amendment 정정 정보 추가
	 * @param KorCorrInfoVO corrInfoVO
	 * @exception DAOException
	 */
	public void addCorrInfo(KorCorrInfoVO corrInfoVO) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = corrInfoVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			new SQLExecuter("").executeUpdate((ISQLTemplate) new KorManifestListDBDAOaddCorrInfoCSQL(),param, velParam);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Amendment BL 정정 정보 삭제
	 * @param String subNo
	 * @exception DAOException
	 */
	public void removeBlCorrInfo(String subNo) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("sub_no", subNo);
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			new SQLExecuter("").executeUpdate((ISQLTemplate) new KorManifestListDBDAOremoveBlCorrInfoDSQL(),param, velParam);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

	}

	/**
	 * Amendment BL 정정 세부 정보 추가
	 * @param KorBlCorrVO blCorrVO
	 * @exception DAOException
	 */
	public void addBlCorrInfo(KorBlCorrVO blCorrVO) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = blCorrVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			new SQLExecuter("").executeUpdate((ISQLTemplate) new KorManifestListDBDAOaddBlCorrInfoCSQL(),param, velParam);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Amendment Container 정정 정보 삭제
	 * @param String subNo
	 * @exception DAOException
	 */
	public void removeCNTRCorrInfo(String subNo) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("sub_no", subNo);
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			new SQLExecuter("").executeUpdate((ISQLTemplate) new KorManifestListDBDAOremoveCNTRCorrInfoDSQL(),param, velParam);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

	}

	/**
	 * Amendment CNTR Correction 정보를 Insert
	 * @param KorCntrCorrVO cntrCorrVO
	 * @exception DAOException
	 */
	public void addCNTRCorrInfo(KorCntrCorrVO cntrCorrVO) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = cntrCorrVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			new SQLExecuter("").executeUpdate((ISQLTemplate) new KorManifestListDBDAOaddCNTRCorrInfoCSQL(),param, velParam);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Amendment Export Lic. No정보를 삭제
	 * @param String subNo
	 * @exception DAOException
	 */
	public void removeExportCorrInfo(String subNo) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("sub_no", subNo);
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			new SQLExecuter("").executeUpdate((ISQLTemplate) new KorManifestListDBDAOremoveExportCorrInfoDSQL(),param, velParam);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

	}

	/**
	 * Amendment Export Lic No 정보를 Insert
	 * @param KorExportCorrVO exportCorrVO
	 * @exception DAOException
	 */
	public void addExportCorrInfo(KorExportCorrVO exportCorrVO) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = exportCorrVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			new SQLExecuter("").executeUpdate((ISQLTemplate) new KorManifestListDBDAOaddExportCorrInfoCSQL(),param, velParam);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Amendment BL 수정 정보를 수정
	 * @param KorBlAmdVO blAmdVO
	 * @exception DAOException
	 */
	public void modifyBlAmdInfo(KorBlAmdVO blAmdVO) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = blAmdVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			new SQLExecuter("").executeUpdate((ISQLTemplate) new KorManifestListDBDAOmodifyBlAmdInfoUSQL(),param, velParam);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * MRN Validation Check
	 * @param KorMrnValidVO mrnValidVO
	 * @return Stirng
	 * @exception DAOException
	 */
	public String searchMrnValidChk(KorMrnValidVO mrnValidVO) throws DAOException {
		DBRowSet dbRowset = null;
		String mrnCheck = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = mrnValidVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorManifestListDBDAOsearchMrnValidChkRSQL(),param, velParam);
			if (dbRowset.next()) mrnCheck = dbRowset.getString(1);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return mrnCheck;
	}

	/**
	 * Danger CNTR Count 조회
	 * @param KorBkgDgCntrVO bkgDgCntrVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchBkgDgCntrCnt(KorBkgDgCntrVO bkgDgCntrVO) throws DAOException {
		DBRowSet dbRowset = null;
		String cntrCnt = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = bkgDgCntrVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorManifestListDBDAOsearchBkgDgCntrCntRSQL(),param, velParam);
			if (dbRowset.next()) cntrCnt = dbRowset.getString(1);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return cntrCnt;
	}

	/**
	 * 한국 지역 DG Cargo Manifest List조회
	 * @param KorBkgDgCgoVO bkgDgCgoVO
	 * @return KorBkgDgCgoVO[]
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public KorBkgDgCgoVO[] searchBkgDgCgoList(KorBkgDgCgoVO bkgDgCgoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<KorBkgDgCgoVO> listKorBkgDgCgoVOs = null;
		KorBkgDgCgoVO[] korBkgDgCgoVOs = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = bkgDgCgoVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorManifestListDBDAOsearchBkgDgCgoListRSQL(),param, velParam);
			if (dbRowset!=null) {
				listKorBkgDgCgoVOs = (List)RowSetUtil.rowSetToVOs(dbRowset, KorBkgDgCgoVO.class);
				if (listKorBkgDgCgoVOs!=null) {
					korBkgDgCgoVOs = listKorBkgDgCgoVOs.toArray(new KorBkgDgCgoVO[0]);
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return korBkgDgCgoVOs;
	}

	/**
	 * VVD 기본 정보를 조회
	 * @param KorBkgDgVvdVO bkgDgVvdVO
	 * @return KorBkgDgVvdVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public KorBkgDgVvdVO searchBkgDgVVDInfo(KorBkgDgVvdVO bkgDgVvdVO) throws DAOException {
		DBRowSet dbRowset = null;
		KorBkgDgVvdVO korBkgDgVvdVO = null;
		List<KorBkgDgVvdVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = bkgDgVvdVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorManifestListDBDAOsearchBkgDgVVDInfoRSQL(),param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, KorBkgDgVvdVO.class);
			if(list!=null && list.size() > 0) korBkgDgVvdVO = list.get(0);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return korBkgDgVvdVO;
	}

	/**
	 * Korea VVD 기본 정보 조회
	 * @param KorDgVvdVO korDgVvdVO
	 * @return KorDgVvdVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public KorDgVvdVO searchKorDgVVDInfo(KorDgVvdVO korDgVvdVO) throws DAOException {
		DBRowSet dbRowset = null;
		KorDgVvdVO outVO = null;
		List<KorDgVvdVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = korDgVvdVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorManifestListDBDAOsearchKorDgVVDInfoRSQL(),param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, KorDgVvdVO.class);
			if(list != null && list.size() > 0) outVO = list.get(0);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return outVO;
	}

	/**
	 * I/B CNTR Info를 조회
	 * @param KorIbDgCgoVO ibDgCgoVO
	 * @return KorIbDgCgoVO[]
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public KorIbDgCgoVO[] searchKorIBDgCgoList(KorIbDgCgoVO ibDgCgoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<KorIbDgCgoVO> listKorIbDgCgoVOs = null;
		KorIbDgCgoVO[] korIbDgCgoVOs = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = ibDgCgoVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorManifestListDBDAOsearchKorIBDgCgoListRSQL(),param, velParam);
			if (dbRowset!=null) {
				listKorIbDgCgoVOs = (List)RowSetUtil.rowSetToVOs(dbRowset, KorIbDgCgoVO.class);
				if (listKorIbDgCgoVOs!=null) {
					korIbDgCgoVOs = listKorIbDgCgoVOs.toArray(new KorIbDgCgoVO[0]);
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return korIbDgCgoVOs;
	}

	/**
	 * O/B CNTR 정보를 조회
	 * @param KorObDgCgoVO obDgCgoVO
	 * @return KorObDgCgoVO[]
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public KorObDgCgoVO[] searchKorOBDgCgoList(KorObDgCgoVO obDgCgoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<KorObDgCgoVO> listKorObDgCgoVOs = null;
		KorObDgCgoVO[] korObDgCgoVOs = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = obDgCgoVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorManifestListDBDAOsearchKorOBDgCgoListRSQL(),param, velParam);
			if (dbRowset!=null) {
				listKorObDgCgoVOs = (List)RowSetUtil.rowSetToVOs(dbRowset, KorObDgCgoVO.class);
				if (listKorObDgCgoVOs!=null) {
					korObDgCgoVOs = listKorObDgCgoVOs.toArray(new KorObDgCgoVO[0]);
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return korObDgCgoVOs;
	}

	/**
	 * Download후에 DG VVD정보를 modify
	 * @param BkgCstmsKrDgCgoVvdVO bkgCstmsKrDgCgoVvdVO
	 * @exception DAOException
	 */
	public void modifyDgVVDInfo(BkgCstmsKrDgCgoVvdVO bkgCstmsKrDgCgoVvdVO) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = bkgCstmsKrDgCgoVvdVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			new SQLExecuter("").executeUpdate((ISQLTemplate) new KorManifestListDBDAOmodifyDgVVDInfoUSQL(),param, velParam);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Danger VVD의 Max Seq 조회
	 * @param KorDgSeqVO dgSeqVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchMaxDgVvdSeq(KorDgSeqVO dgSeqVO) throws DAOException {
		DBRowSet dbRowset = null;
		String maxVvdSeq = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = dgSeqVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorManifestListDBDAOsearchMaxDgVvdSeqRSQL(),param, velParam);
			if (dbRowset.next()) maxVvdSeq = dbRowset.getString(1);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return maxVvdSeq;
	}

	/**
	 * 최초 Download시 DG VVD 정보 INSERT
	 * @param bkgCstmsKrDgCgoVvdVO
	 * @exception DAOException
	 */
	public void addDgVVDInfo(BkgCstmsKrDgCgoVvdVO bkgCstmsKrDgCgoVvdVO) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = bkgCstmsKrDgCgoVvdVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			new SQLExecuter("").executeUpdate((ISQLTemplate) new KorManifestListDBDAOaddDgVVDInfoCSQL(),param, velParam);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * DG 전송여부 체크
	 * @param BkgCstmsKrDgCgoVvdVO bkgCstmsKrDgCgoVvdVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchDgSendDate(BkgCstmsKrDgCgoVvdVO bkgCstmsKrDgCgoVvdVO) throws DAOException {
		DBRowSet dbRowset = null;
		String sendCheck = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = bkgCstmsKrDgCgoVvdVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorManifestListDBDAOsearchDgSendDateRSQL(),param, velParam);
			if (dbRowset.next()) sendCheck = dbRowset.getString(1);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return sendCheck;
	}

	/**
	 * 전송이 되지 않은 정보 삭제
	 * @param BkgCstmsKrDgCgoVO bkgCstmsKrDgCgoVO
	 * @exception DAOException
	 */
	public void removeDgCNTRInfoKor(BkgCstmsKrDgCgoVO bkgCstmsKrDgCgoVO) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = bkgCstmsKrDgCgoVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			new SQLExecuter("").executeUpdate((ISQLTemplate) new KorManifestListDBDAOremoveDgCNTRInfoKorDSQL(),param, velParam);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Delete후 새롭게 Insert하기 위해 InBound 의 MRN, SEQ 조회
	 * @param KorDgInfoVO dgInfoVO
	 * @return KorCertiVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public KorCertiVO searchCertiNoList(KorDgInfoVO dgInfoVO) throws DAOException {
		DBRowSet dbRowset = null;
		KorCertiVO outVO = null;
		List<KorCertiVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = dgInfoVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorManifestListDBDAOsearchCertiNoListRSQL(),param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, KorCertiVO.class);
			if(list!=null && list.size() > 0) outVO = list.get(0);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return outVO;
	}

	/**
	 * Container 의 CertiNo, CertiSeq 조회
	 * @param KorCntrCertiVO cntrCertiVO
	 * @return KorCntrCertiVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public KorCntrCertiVO searchCntrCertiNoList(KorCntrCertiVO cntrCertiVO) throws DAOException {
		DBRowSet dbRowset = null;
		KorCntrCertiVO outVO = null;
		List<KorCntrCertiVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = cntrCertiVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorManifestListDBDAOsearchCntrCertiNoListRSQL(),param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, KorCntrCertiVO.class);
			if(list!=null && list.size() > 0) outVO = list.get(0);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return outVO;
	}

	/**
	 * DG Container 정보 추가
	 * @param BkgCstmsKrDgCgoVO bkgCstmsKrDgCgoVO
	 * @exception DAOException
	 */
	public void addDgCNTRInfo(BkgCstmsKrDgCgoVO bkgCstmsKrDgCgoVO) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = bkgCstmsKrDgCgoVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			new SQLExecuter("").executeUpdate((ISQLTemplate) new KorManifestListDBDAOaddDgCNTRInfoCSQL(), param, velParam);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

	}

	/**
	 * 다른 항차로 이미 D/L 된 BKG이있을 경우에, Dup Error를 피하고 Update하기위한 조회
	 * @param BkgCstmsKrDgCgoVO bkgCstmsKrDgCgoVO
	 * @return BkgCstmsKrDgCgoVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public BkgCstmsKrDgCgoVO searchDgCNTRInfo(BkgCstmsKrDgCgoVO bkgCstmsKrDgCgoVO) throws DAOException {
		DBRowSet dbRowset = null;
		BkgCstmsKrDgCgoVO outVO = null;
		List<BkgCstmsKrDgCgoVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = bkgCstmsKrDgCgoVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorManifestListDBDAOsearchDgCNTRInfoRSQL(),param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgCstmsKrDgCgoVO.class);
			if(list!=null && list.size() > 0) outVO = list.get(0);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return outVO;
	}

	/**
	 * 다른 항차로 이미 D/L 된 BKG이있을 경우에, Dup Error를 피하고 Update
	 * @param BkgCstmsKrDgCgoVO bkgCstmsKrDgCgoVO
	 * @return int
	 * @exception DAOException
	 */
	public int modifyDgCNTRInfo(BkgCstmsKrDgCgoVO bkgCstmsKrDgCgoVO) throws DAOException {
		int cnt = 0;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = bkgCstmsKrDgCgoVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			cnt = new SQLExecuter("").executeUpdate((ISQLTemplate) new KorManifestListDBDAOmodifyDgCNTRInfoUSQL(), param, velParam);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return cnt;
	}

	/**
	 *  신규 Download하기위해 다른 VVD로 같은 B/L이 Download된것이 있는지 여부 확인하기 위해 조회
	 * @param KorDownCheckVO downCheckVO
	 * @return KorDownCheckVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public KorDownCheckVO searchDownCheck(KorDownCheckVO downCheckVO) throws DAOException {
		DBRowSet dbRowset = null;
		KorDownCheckVO outVO = null;
		List<KorDownCheckVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = downCheckVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorManifestListDBDAOsearchDownCheckRSQL(),param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, KorDownCheckVO.class);
			if(list!=null && list.size() > 0) outVO = list.get(0);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return outVO;
	}

	/**
	 * DEL Code와 Delivery Term 정보를 조회한다.
	 * @param String bkgNo
	 * @return KorDelTermVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public KorDelTermVO searchDelTermInfo(String bkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		KorDelTermVO outVO = null;
		List<KorDelTermVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("bkg_no", bkgNo);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorManifestListDBDAOsearchDelTermInfoRSQL(),param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, KorDelTermVO.class);
			if(list!=null && list.size() > 0) outVO = list.get(0);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return outVO;
	}

	/**
	 * Discharing CY 의 Validation Check
	 * @param String dischCy
	 * @return String
	 * @throws DAOException
	 */
	public String searchDischCyValChk(String dischCy) throws DAOException {
		DBRowSet dbRowset = null;
		String valCheck = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("otr_dchg_cd", dischCy);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorManifestListDBDAOsearchDischCyValChkRSQL(),param, velParam);
			if (dbRowset.next()) valCheck = dbRowset.getString(1);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return valCheck;
	}

	/**
	 *  MSN Assign을 하면서 기존에 사용된 MSN이 있는지 여부를 체크
	 * @param BkgCstmsKrMfSeqNoVO bkgCstmsKrMfSeqNoVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchMsnValChk(BkgCstmsKrMfSeqNoVO bkgCstmsKrMfSeqNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		String valCheck = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = bkgCstmsKrMfSeqNoVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorManifestListDBDAOsearchMsnValChkRSQL(),param, velParam);
			if (dbRowset.next()) valCheck = dbRowset.getString(1);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return valCheck;
	}

	/**
	 * 입력받은 BAC 일괄 UPDATE (UPDATE BONDED AREA CODE)
	 * @param KorBondCdVO korBondCdVO
	 * @exception DAOException
	 */
	public void modifyBondCdKor(KorBondCdVO korBondCdVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = korBondCdVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			new SQLExecuter("").executeUpdate((ISQLTemplate)new KorManifestListDBDAOmodifyBondCdKorUSQL(), param, velParam);

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * BKG VVD Summary Info 정보를 UPDATE
	 * @param BkgCstmsKrVvdSmryVO bkgCstmsKrVvdSmryVO
	 * @exception DAOException
	 */
	public void modifyManifestSmryInfo(BkgCstmsKrVvdSmryVO bkgCstmsKrVvdSmryVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = bkgCstmsKrVvdSmryVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			 new SQLExecuter("").executeUpdate((ISQLTemplate)new KorManifestListDBDAOmodifyManifestSmryInfoUSQL(), param, velParam);

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * B/L INFO 삭제
	 * @param KorBlInfoKorVO korBlInfoKorVO
	 * @return int
	 * @exception DAOException
	 */
	public int removeBlInfo(KorBlInfoKorVO korBlInfoKorVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		int cnt = 0;
		try {
			Map<String, String> mapVO = korBlInfoKorVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			cnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new KorManifestListDBDAOremoveBlInfoDSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return cnt;
	}

	/**
	 * 전송 후 전송일 + 전송자 저장
	 * @param KorBlInfoKorVO korBlInfoKorVO
	 * @exception DAOException
	 */
	public void modifyDiscSendDate(KorBlInfoKorVO korBlInfoKorVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = korBlInfoKorVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			new SQLExecuter("").executeUpdate((ISQLTemplate)new KorManifestListDBDAOmodifyDiscSendDateUSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Manifest VVD 전송정보 UPDATE
	 * @param bkgCstmsKrVvdSmryVO
	 * @exception DAOException
	 */
	public void modifyVVDSendKor(BkgCstmsKrVvdSmryVO bkgCstmsKrVvdSmryVO)throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = bkgCstmsKrVvdSmryVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			new SQLExecuter("").executeUpdate((ISQLTemplate)new KorManifestListDBDAOmodifyVVDSendKorUSQL(), param, velParam);

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Manifest 전송일시 UPDATE
	 * @param KorBondCdVO korBondCdVO
	 * @exception DAOException
	 */
	public void modifyKorManiSndDateUser(KorBondCdVO korBondCdVO)throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = korBondCdVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			new SQLExecuter("").executeUpdate((ISQLTemplate)new KorManifestListDBDAOmodifyKorManiSndDateUserUSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * HJT로 부터 수신된 메시지를 Update한다.
	 * @param HjtRcvMsgVO hjtRcvMsgVO
	 * @exception DAOException
	 */
	public void modifyHJTResponse(HjtRcvMsgVO hjtRcvMsgVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = hjtRcvMsgVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			new SQLExecuter("").executeUpdate((ISQLTemplate)new KorManifestListDBDAOmodifyHJTResponseUSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * 전송이 안된경우 SNED DATE UPDATE
	 *
	 * @param KorBlInfoKorVO korBlInfoKorVO
	 * @exception DAOException
	 */
	public void modifyTransmitDate(KorBlInfoKorVO korBlInfoKorVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = korBlInfoKorVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			new SQLExecuter("").executeUpdate((ISQLTemplate)new KorManifestListDBDAOmodifyTransmitDateUSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * EDI_SND_DT(Only once at first) Update
	 * @param KorEdiMrnVO ediMrnVO
	 * @exception DAOException
	 */
	public void modifyEDIMrn(KorEdiMrnVO ediMrnVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = ediMrnVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			new SQLExecuter("").executeUpdate((ISQLTemplate)new KorManifestListDBDAOmodifyEDIMrnUSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * EDI전송후 MSN_SND_DT Update
	 * @param KorEdiMsnVO ediMsnVO
	 * @exception DAOException
	 */
	public void modifyEDIMsn(KorEdiMsnVO ediMsnVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = ediMsnVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			new SQLExecuter("").executeUpdate((ISQLTemplate)new KorManifestListDBDAOmodifyEDIMsnUSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * MRN 정보 추가
	 * @param List<KorMrnCreateInfoVO> korMrnCreateInfoVOList
	 * @exception DAOException
	 */
	public void addMrnCreateInfo(List<KorMrnCreateInfoVO> korMrnCreateInfoVOList) throws DAOException {
		try {
			if (korMrnCreateInfoVOList.size() > 0) {
				int insCnt[] = new SQLExecuter("").executeBatch((ISQLTemplate) new KorManifestListDBDAOaddMrnCreateInfoCSQL(), korMrnCreateInfoVOList, null);
				for(int i=0; i<insCnt.length; i++) {
					if (insCnt[i]== Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * MSN table에서 MRN Info를 Delete
	 * @param List<KorMrnCreateInfoVO> korMrnCreateInfoVOList
	 * @exception DAOException
	 */
	public void removeMsnCreateInfo(List<KorMrnCreateInfoVO> korMrnCreateInfoVOList) throws DAOException {
		try {
			if (korMrnCreateInfoVOList.size() > 0) {
				int delCnt[] = new SQLExecuter("").executeBatch((ISQLTemplate) new KorManifestListDBDAOremoveMsnCreateInfoDSQL(), korMrnCreateInfoVOList, null);
				for(int i=0; i<delCnt.length; i++) {
					if (delCnt[i]== Statement.EXECUTE_FAILED) throw new DAOException("Fail to delete No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * MRN 정보 DELETE
	 * @param List<KorMrnCreateInfoVO> korMrnCreateInfoVOList
	 * @exception DAOException
	 */
	public void removeMrnCreateInfo(List<KorMrnCreateInfoVO> korMrnCreateInfoVOList) throws DAOException {
		try {
			if (korMrnCreateInfoVOList.size() > 0) {
				int delCnt[] = new SQLExecuter("").executeBatch((ISQLTemplate) new KorManifestListDBDAOremoveMrnCreateInfoDSQL(), korMrnCreateInfoVOList, null);
				for(int i=0; i<delCnt.length; i++) {
					if (delCnt[i]== Statement.EXECUTE_FAILED) throw new DAOException("Fail to delete No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * CNTR 마다 MSN 동일하게 입력받은 Cargo SEQ + 1 하여 따로 저장
	 * @param BkgCstmsKrDgCgoVO bkgCstmsKrDgCgoVO
	 * @exception DAOException
	 */
	public void modifyDgCgoSeq(BkgCstmsKrDgCgoVO bkgCstmsKrDgCgoVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = bkgCstmsKrDgCgoVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			new SQLExecuter("").executeUpdate((ISQLTemplate)new KorManifestListDBDAOmodifyDgCgoSeqUSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * EDI Send후 Update( 전송 날짜, 전송 사용자 저장)
	 * @param BkgCstmsKrDgCgoVvdVO bkgCstmsKrDgCgoVvdVO
	 * @exception DAOException
	 */
	public void modifyDgEdiVVDInfo(BkgCstmsKrDgCgoVvdVO bkgCstmsKrDgCgoVvdVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = bkgCstmsKrDgCgoVvdVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			new SQLExecuter("").executeUpdate((ISQLTemplate)new KorManifestListDBDAOmodifyDgEdiVVDInfoUSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * EDI Send후 Container 정보 Update( 전송 날짜, 전송 사용자 저장)
	 * @param BkgCstmsKrDgCgoVO bkgCstmsKrDgCgoVO
	 * @exception DAOException
	 */
	public void modifyDgEdiCNTRInfo(BkgCstmsKrDgCgoVO bkgCstmsKrDgCgoVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = bkgCstmsKrDgCgoVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			new SQLExecuter("").executeUpdate((ISQLTemplate)new KorManifestListDBDAOmodifyDgEdiCNTRInfoUSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * MRN 정보 조회
	 * @param KorMrnInfoKorVO mrnInfoKorVO
	 * @return KorMrnInfoKorVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public KorMrnInfoKorVO searchMrnInfoKor(KorMrnInfoKorVO mrnInfoKorVO) throws DAOException {
		KorMrnInfoKorVO korMrnInfoKorVO = null;
		List<KorMrnInfoKorVO> list = null;
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = mrnInfoKorVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorManifestListDBDAOsearchMrnInfoKorRSQL(),param, velParam);
			if (dbRowset==null) return null;
			list =  (List)RowSetUtil.rowSetToVOs(dbRowset, KorMrnInfoKorVO.class);
			if (list!=null && list.size() > 0) korMrnInfoKorVO = list.get(0);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return korMrnInfoKorVO;
	}

	/**
	 * 전송할 DATA가 존재하는지 COUNT 조회
	 * @param KorExistCntVO korExistCntVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchExistCntKor(KorExistCntVO korExistCntVO) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String cnt = null;

		try {
			Map<String, String> mapVO = korExistCntVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new KorManifestListDBDAOsearchExistCntKorRSQL(), param, velParam);
			if(dbRowset.next()) {
				cnt = dbRowset.getString(1);
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return cnt;
	}

	/**
	 * Container Summary 정보 조회
	 * @param KorSumVO sumVO
	 * @return KorSumVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public KorSumVO searchSummaryInfo(KorSumVO sumVO) throws DAOException {
		List <KorSumVO> list = null;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		KorSumVO korSumVO = null;
		try {
			Map<String, String> mapVO = sumVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new KorManifestListDBDAOsearchSummaryInfoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, KorSumVO.class);
			if(list != null && list.size() > 0) korSumVO = list.get(0);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return korSumVO;
	}

	/**
	 * Master, Console, Empty B/L Count 및 Package, Weight, Measure Total 값 조회
	 * @param BlSummaryCondVO blSummaryCondVO
	 * @return BlSummaryVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public BlSummaryVO searchBlSummaryInfo(BlSummaryCondVO blSummaryCondVO) throws DAOException {
		List <BlSummaryVO> list = null;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		BlSummaryVO returnNode = null;
		try {
			Map<String, String> mapVO = blSummaryCondVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new KorManifestListDBDAOsearchBlSummaryInfoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BlSummaryVO.class);
			if(list == null) return null;
			if(list.size() > 0) returnNode = list.get(0);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return returnNode;
	}

	/**
	 * VVD Max Sequence 조회
	 * @param BkgCstmsKrVvdSmryVO bkgCstmsKrVvdSmryVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchVVDSeqKor(BkgCstmsKrVvdSmryVO bkgCstmsKrVvdSmryVO)throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String rtnString = "";
		try {
			Map<String, String> mapVO = bkgCstmsKrVvdSmryVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new KorManifestListDBDAOsearchVVDSeqKorRSQL(), param, velParam);
			if(dbRowset.next()) {
				rtnString = dbRowset.getString(1);
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return rtnString;
	}

	/**
	 * VVD INFO가 이전에 전송되었는지 여부 조회
	 * @param BkgCstmsKrVvdSmryVO bkgCstmsKrVvdSmryVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchVVDSendCheck(BkgCstmsKrVvdSmryVO bkgCstmsKrVvdSmryVO) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String rtnString = null;
		try {
			Map<String, String> mapVO = bkgCstmsKrVvdSmryVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new KorManifestListDBDAOsearchVVDSendCheckRSQL(), param, velParam);
			if(dbRowset.next()) {
				rtnString = dbRowset.getString(1);
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return rtnString;
	}

	/**
	 * 전송되었거나 데이터가 없는 경우 새로운 데이터를 추가
	 * @param BkgCstmsKrVvdSmryVO bkgCstmsKrVvdSmryVO
	 * @exception DAOException
	 */
	public void addVVDInfoInKorCstm(BkgCstmsKrVvdSmryVO bkgCstmsKrVvdSmryVO) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = bkgCstmsKrVvdSmryVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			new SQLExecuter("").executeUpdate((ISQLTemplate) new KorManifestListDBDAOaddVVDInfoInKorCstmCSQL(),param, velParam);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * 전송되지 않은 데이터인 경우 조회 조건으로 UPDATE
	 * @param BkgCstmsKrVvdSmryVO bkgCstmsKrVvdSmryVO
	 * @exception DAOException
	 */
	public void modifyVVDInfoKor(BkgCstmsKrVvdSmryVO bkgCstmsKrVvdSmryVO) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = bkgCstmsKrVvdSmryVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			new SQLExecuter("").executeUpdate((ISQLTemplate) new KorManifestListDBDAOmodifyVVDInfoKorUSQL(),param, velParam);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * OutBound 'A' Type 의 Bond Area Code 조회
	 * @param BkgCstmsKrBlCondVO bkgCstmsKrBlCondVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchBondAreaCd(BkgCstmsKrBlCondVO bkgCstmsKrBlCondVO)throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String rtnString = null;
		try {
			Map<String, String> mapVO = bkgCstmsKrBlCondVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new KorManifestListDBDAOsearchBondAreaCdRSQL(), param, velParam);
			if(dbRowset.next()) {
				rtnString = dbRowset.getString(1);
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return rtnString;
	}

	/**
	 * 전송 날짜와 시간을 조회
	 * @param BkgCstmsKrVvdSmryVO bkgCstmsKrVvdSmryVO
	 * @return DateVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public DateVO searchSendDate(BkgCstmsKrVvdSmryVO bkgCstmsKrVvdSmryVO)throws DAOException {
		List <DateVO> list = null;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		DateVO returnNode = null;
		try {
			Map<String, String> mapVO = bkgCstmsKrVvdSmryVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new KorManifestListDBDAOsearchSendDateRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, DateVO.class);
			if(list == null) return null;
			if(list.size() > 0) returnNode = list.get(0);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return returnNode;
	}

	/**
	 * C Type 의 Transmit Count 조회
	 * @param BkgCstmsKrVvdSmryVO bkgCstmsKrVvdSmryVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchTransPreCnt(BkgCstmsKrVvdSmryVO bkgCstmsKrVvdSmryVO)throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String rtnString = null;
		try {
			Map<String, String> mapVO = bkgCstmsKrVvdSmryVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new KorManifestListDBDAOsearchTransPreCntRSQL(), param, velParam);
			if(dbRowset.next()) {
				rtnString = dbRowset.getString(1);
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return rtnString;
	}

	/**
	 * BKG_0344 화면에 조회되는 VVD 정보 조회
	 * @param BkgCstmsKrVvdSmryVO bkgCstmsKrVvdSmryVO
	 * @return BkgCstmsKrVvdSmryVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public BkgCstmsKrVvdSmryVO searchVVDInfoKor(BkgCstmsKrVvdSmryVO bkgCstmsKrVvdSmryVO)throws DAOException {
		List <BkgCstmsKrVvdSmryVO> list = null;
		BkgCstmsKrVvdSmryVO returnVal = null;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = bkgCstmsKrVvdSmryVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new KorManifestListDBDAOsearchVVDInfoKorRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgCstmsKrVvdSmryVO.class);
			if(list == null) return null;
			if(list.size() > 0) {
				returnVal = list.get(0);
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return returnVal;
	}

	/**
	 * Manifest Main VVD 정보 삭제
	 * @param BkgCstmsKrVvdSmryVO bkgCstmsKrVvdSmryVO
	 * @exception DAOException
	 */
	public void removeVvdInfoKor(BkgCstmsKrVvdSmryVO bkgCstmsKrVvdSmryVO)throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = bkgCstmsKrVvdSmryVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			new SQLExecuter("").executeUpdate((ISQLTemplate)new KorManifestListDBDAOremoveVvdInfoKorDSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * B/L Container 정보 삭제
	 * @param KorCntrDataVO korCntrDataVO
	 * @exception DAOException
	 */
	public void removeCNTRDataKor(KorCntrDataVO korCntrDataVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = korCntrDataVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			new SQLExecuter("").executeUpdate((ISQLTemplate)new KorManifestListDBDAOremoveCNTRDataKorDSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * B/L Customer 정보 삭제
	 * @param KorBlCustInfoVO korBlCustInfoVO
	 * @exception DAOException
	 */
	public void removeBlCustInfoKor(KorBlCustInfoVO korBlCustInfoVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = korBlCustInfoVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			new SQLExecuter("").executeUpdate((ISQLTemplate)new KorManifestListDBDAOremoveBlCustInfoKorDSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Export License 정보 삭제
	 * @param KorExpDataVO korExpDataVO
	 * @exception DAOException
	 */
	public void removeExportDataKor(KorExpDataVO korExpDataVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = korExpDataVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			new SQLExecuter("").executeUpdate((ISQLTemplate)new KorManifestListDBDAOremoveExportDataKorDSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * 삭제를 하기 위해 DOWN LOAD SEQ 를 조회
	 * @param KorDnHistVO korDnHistVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchMaxSeqDnHistKor(KorDnHistVO korDnHistVO)throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String dlSeq = null;
		try {
			Map<String, String> mapVO = korDnHistVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new KorManifestListDBDAOsearchMaxSeqDnHistKorRSQL(), param, velParam);
			if (dbRowset.next()) dlSeq = dbRowset.getString(1);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return dlSeq;
	}

	/**
	 * DownLoad History 추가
	 * @param KorDnHistVO korDnHistVO
	 * @exception DAOException
	 */
	public void addDnHistKor(KorDnHistVO korDnHistVO)throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = korDnHistVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			new SQLExecuter("").executeUpdate((ISQLTemplate)new KorManifestListDBDAOaddDnHistKorCSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * BKG VVD Summary Info 정보를 UPDATE (하선신고)
	 * @param BkgCstmsKrVvdSmryVO bkgCstmsKrVvdSmryVO
	 * @exception DAOException
	 */
	public void modifyDiscVVDSmryKorInfo(BkgCstmsKrVvdSmryVO bkgCstmsKrVvdSmryVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = bkgCstmsKrVvdSmryVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			new SQLExecuter("").executeUpdate((ISQLTemplate)new KorManifestListDBDAOmodifyDiscVVDSmryKorInfoUSQL(), param, velParam);

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Correction TABLE UPDATE
	 * @param KorBlInfoKorVO korBlInfoKorVO
	 * @exception DAOException
	 */
	public void modifyCorrInfo(KorBlInfoKorVO korBlInfoKorVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = korBlInfoKorVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			new SQLExecuter("").executeUpdate((ISQLTemplate)new KorManifestListDBDAOmodifyCorrInfoUSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * OutBound BKG 목록 조회
	 *
	 * @param KorBkgInfoVO korBkgInfoVO
	 * @return KorBkgInfoVO[]
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public KorBkgInfoVO[] searchOBBkgInfoList(KorBkgInfoVO korBkgInfoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<KorBkgInfoVO> listKorBkgInfoVO = null;
		KorBkgInfoVO[] korBkgInfoVOs = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = korBkgInfoVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorManifestListDBDAOsearchOBBkgInfoListRSQL(),param, velParam);
			if (dbRowset!=null) {
				listKorBkgInfoVO = (List)RowSetUtil.rowSetToVOs(dbRowset, KorBkgInfoVO.class);
				if (listKorBkgInfoVO!=null) {
					korBkgInfoVOs = listKorBkgInfoVO.toArray(new KorBkgInfoVO[0]);
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return korBkgInfoVOs;
	}

	/**
	 * MSN관리 테이블에 해당 BKG No가 존재하는지 여부 확인
	 * @param KorMsnInfoVO korMsnInfoVO
	 * @return KorMsnInfoVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public KorMsnInfoVO searchObMsnBkgNoChk(KorMsnInfoVO korMsnInfoVO) throws DAOException {
		List <KorMsnInfoVO> list = null;
		KorMsnInfoVO returnVal = null;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = korMsnInfoVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new KorManifestListDBDAOsearchObMsnBkgNoChkRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, KorMsnInfoVO.class);
			if(list == null) return null;
			if(list.size() > 0) {
				returnVal = list.get(0);
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return returnVal;
	}

	/**
	 * Download 전의 MRN No 와 ETA/ETD, Sysdate 조회
	 *
	 * @param KorMrnVslSysEtaEtdVO mrnVslSysEtaEtdVO
	 * @return KorMrnVslSysEtaEtdVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public KorMrnVslSysEtaEtdVO searchMrnVslSysDtEtaEtdDt(KorMrnVslSysEtaEtdVO mrnVslSysEtaEtdVO) throws DAOException {
		List <KorMrnVslSysEtaEtdVO> list = null;
		KorMrnVslSysEtaEtdVO returnVal = null;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = mrnVslSysEtaEtdVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new KorManifestListDBDAOsearchMrnVslSysDtEtaEtdDtRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, KorMrnVslSysEtaEtdVO.class);
			if(list == null) return null;
			if(list.size() > 0) {
				returnVal = list.get(0);
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return returnVal;
	}

	/**
	 * searcMrnNoSysDtEtaEtdDt에서 조회값이 없을 경우 Vessel Port Skd상의 Max calling Indicator를 이용하여 다시조회
	 *
	 * @param KorMrnVslSysEtaEtdVO mrnVslSysEtaEtdVO
	 * @return KorMrnVslSysEtaEtdVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public KorMrnVslSysEtaEtdVO searchMrnVslSysDtEtaEtdMaxDt(KorMrnVslSysEtaEtdVO mrnVslSysEtaEtdVO) throws DAOException {
		List <KorMrnVslSysEtaEtdVO> list = null;
		KorMrnVslSysEtaEtdVO returnVal = null;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = mrnVslSysEtaEtdVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new KorManifestListDBDAOsearchMrnVslSysDtEtaEtdMaxDtRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, KorMrnVslSysEtaEtdVO.class);
			if(list == null) return null;
			if(list.size() > 0) {
				returnVal = list.get(0);
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return returnVal;
	}

	/**
	 * InBound Trans Type 조회, WHF/CTT Exception CHECK
	 *
	 * @param KorIbTransWhfVO ibTransWhfVO
	 * @return KorIbTransWhfVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public KorIbTransWhfVO searchIbTransTpExpWhf(KorIbTransWhfVO ibTransWhfVO) throws DAOException {
		List <KorIbTransWhfVO> list = null;
		KorIbTransWhfVO returnVal = null;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = ibTransWhfVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new KorManifestListDBDAOsearchIbTransTpExpWhfRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, KorIbTransWhfVO.class);
			if(list == null) return null;
			if(list.size() > 0) {
				returnVal = list.get(0);
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return returnVal;
	}

	/**
	 * OutBound Trans Type 조회, WHF/CTT Exception CHECK
	 *
	 * @param KorObTransWhfVO obTransWhfVO
	 * @return KorObTransWhfVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public KorObTransWhfVO searchObTransTpExpWhf(KorObTransWhfVO ObTransWhfVO) throws DAOException {
		List <KorObTransWhfVO> list = null;
		KorObTransWhfVO returnVal = null;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = ObTransWhfVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new KorManifestListDBDAOsearchObTransTpExpWhfRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, KorObTransWhfVO.class);
			if(list == null) return null;
			if(list.size() > 0) {
				returnVal = list.get(0);
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return returnVal;
	}

	/**
	 * BKG Creation_Customer Info.화면상의 BL Type과 같은 걸로 조회
	 * @param String bkgNo
	 * @return String
	 * @throws DAOException
	 */
	public String searchBlTp(String bkgNo) throws DAOException {
		String blTp = "S";

		//KorExportCheckInfoVO korExportNoVO = null;
		DBRowSet dbRowset = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();


		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("bkg_no", bkgNo);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorManifestListDBDAOsearchBlTpRSQL(),param, velParam);
			if(dbRowset.next()) blTp = dbRowset.getString("BL_TP");
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return blTp;
	}

	/**
	 * 2009/12/22일 이후 Outbound로 다운로드된 데이터중에서 Inbound B/L정보를 조회
	 * @param cntrNo
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public KorIbMtInfoVO searchIbTsMtInfo(String cntrNo) throws DAOException {
		KorIbMtInfoVO korIbMtInfoVO = null;
		List <KorIbMtInfoVO> list = null;
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("cntr_no", cntrNo);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorManifestListDBDAOsearchIbTsMtInfoRSQL(),param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, KorIbMtInfoVO.class);
			if(list == null) return null;
			if(list.size() > 0) korIbMtInfoVO = list.get(0);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}


		return korIbMtInfoVO;
	}

	/**
	 * C_BL 별 KCD_TP 재 조회
	 * @param KorCblVO korCblVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchCblKcdTp(KorCblVO korCblVO) throws DAOException {
		String kcdTp = null;

		//KorExportCheckInfoVO korExportNoVO = null;
		DBRowSet dbRowset = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();


		try {
			Map<String, String> mapVO = korCblVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorManifestListDBDAOsearchCblKcdTpRSQL(),param, velParam);
			if(dbRowset.next()) kcdTp = dbRowset.getString("CSTMS_DECL_TP_CD");
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return kcdTp;
	}

	/**
	 * Customer테이블에 BL테이블의 CSTMS_DEL_TP_CD와 같은 코드를 넣기위해 재 조회
	 * @param KorKcdVO korKcdVO
	 * @return String[]
	 * @throws DAOException
	 */
	public String[] searchKcdTpCust(KorKcdVO korKcdVO) throws DAOException {
		String[] kcdTp = null;
		List<String> list = new ArrayList<String>();

		//KorExportCheckInfoVO korExportNoVO = null;
		DBRowSet dbRowset = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();


		try {
			Map<String, String> mapVO = korKcdVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorManifestListDBDAOsearchKcdTpCustRSQL(),param, velParam);
			if (dbRowset!=null) {
				while(dbRowset.next()) {
					list.add(dbRowset.getString("CSTMS_DECL_TP_CD"));
				}
			}
			if(list == null) return null;
			if(list.size() > 0) {
				kcdTp = new String[list.size()];
				for(int i=0; i < list.size(); i++) {
					kcdTp[i] = list.get(i);
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return kcdTp;
	}

	/**
	 * MSN 이 존재하는지 여부 체크
	 * @param String vvdCd
	 * @param String portCd
	 * @param String msnNo
	 * @return String
	 * @throws DAOException
	 */
	public String searchMsnExistCnt(String vvdCd, String portCd, String msnNo) throws DAOException {
		String check = null;

		//KorExportCheckInfoVO korExportNoVO = null;
		DBRowSet dbRowset = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();


		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("in_vvd", vvdCd);
			mapVO.put("kt_port", portCd);
			mapVO.put("msn_number", msnNo);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorManifestListDBDAOsearchMsnExistCntRSQL(),param, velParam);
			if(dbRowset.next()) check = dbRowset.getString("CNT");
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return check;
	}

	/**
	 * Msn No를 Update
	 * @param KorMsnNoVO korMsnNoVO
	 * @throws DAOException
	 */
	public void modifyMsnNo(KorMsnNoVO korMsnNoVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = korMsnNoVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			new SQLExecuter("").executeUpdate((ISQLTemplate)new KorManifestListDBDAOmodifyMsnNoUSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Wharfage Notice 정보 조회
	 * @param String inVvd
	 * @return String
	 * @throws DAOException
	 */
	public String searchWhfNotice(String inVvd) throws DAOException {
		String notice = null;

		//KorExportCheckInfoVO korExportNoVO = null;
		DBRowSet dbRowset = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();


		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("in_vvd", inVvd);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorManifestListDBDAOsearchWhfNoticeRSQL(),param, velParam);
			if(dbRowset.next()) notice = dbRowset.getString("CNT");
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return notice;
	}

	/**
	 * Original BL No 조회
	 * @param String cBlNo
	 * @return KorOrgBlVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public KorOrgBlVO searchOrgBlNo(String cBlNo) throws DAOException {
		KorOrgBlVO korOrgBlVO = null;
		List <KorOrgBlVO> list = null;
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("c_bl_no", cBlNo);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorManifestListDBDAOsearchOrgBlNoRSQL(),param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, KorOrgBlVO.class);
			if(list == null) return null;
			if(list.size() > 0) korOrgBlVO = list.get(0);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return korOrgBlVO;
	}

	/**
	 * SUB_NO 조회
	 * @param KorSubNoVO korSubNoVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchSubNo(KorSubNoVO korSubNoVO) throws DAOException {
		String subNo = null;

		//KorExportCheckInfoVO korExportNoVO = null;
		DBRowSet dbRowset = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = korSubNoVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorManifestListDBDAOsearchSubNoRSQL(),param, velParam);
			if(dbRowset.next()) subNo = dbRowset.getString("SUB_NO");
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return subNo;
	}

	/**
	 * SUB_NO 정보 삭제
	 * @param String subNo
	 * @exception DAOException
	 */
	public void removeSubNo(String subNo) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("sub_no", subNo);

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			new SQLExecuter("").executeUpdate((ISQLTemplate)new KorManifestListDBDAOremoveSubNoDSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Empty Amend 정보 추가
	 * @param KorEmptyCorrInfoVO emptyCorrInfoVO
	 * @throws DAOException
	 */
	public void addEmptyCorrInfo(KorEmptyCorrInfoVO emptyCorrInfoVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = emptyCorrInfoVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			new SQLExecuter("").executeUpdate((ISQLTemplate)new KorManifestListDBDAOaddEmptyCorrInfoCSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * InBound Empty 전송일시 UPDATE
	 *
	 * @param KorEmpBlInfoVO empBlInfoVO
	 * @throws DAOException
	 */
	public void modifyEmpTransmitDate(KorEmpBlInfoVO empBlInfoVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = empBlInfoVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			new SQLExecuter("").executeUpdate((ISQLTemplate)new KorManifestListDBDAOmodifyEmpTransmitDateUSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * InBound Empty 전송일시 UPDATE
	 *
	 * @param KorEmpBlInfoVO empBlInfoVO
	 * @throws DAOException
	 */
	public void modifyEmpCorrInfo(KorEmpBlInfoVO empBlInfoVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = empBlInfoVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			new SQLExecuter("").executeUpdate((ISQLTemplate)new KorManifestListDBDAOmodifyEmpCorrInfoUSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * TYPE 변경 처리
	 * @param KorKcdTpChgVO kcdTpChgVO
	 * @throws DAOException
	 */
	public void modifyKcdTpByInVVD(KorKcdTpChgVO kcdTpChgVO) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = kcdTpChgVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			new SQLExecuter("").executeUpdate((ISQLTemplate) new KorManifestListDBDAOmodifyKcdTpByInVVDUSQL(),param, velParam);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * MSN NO 변경 처리
	 * @param KorMsnNoInfoVO msnNoInfoVO
	 * @throws DAOException
	 */
	public void modifyMsnNoInfo(KorMsnNoInfoVO msnNoInfoVO) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = msnNoInfoVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			new SQLExecuter("").executeUpdate((ISQLTemplate) new KorManifestListDBDAOmodifyMsnNoInfoUSQL(),param, velParam);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Container KCD TP NO 변경 처리
	 * @param KorKcdTpCntrVO kcdTpCntrVO
	 * @throws DAOException
	 */
	public void modifyKcdTpInCntr(KorKcdTpCntrVO kcdTpCntrVO) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = kcdTpCntrVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			new SQLExecuter("").executeUpdate((ISQLTemplate) new KorManifestListDBDAOmodifyKcdTpInCntrUSQL(),param, velParam);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Elno 의 KCD TP 수정
	 *
	 * @param KorKcdTpElnoVO korKcdTpElnoVO
	 * @throws DAOException
	 */
	public void modifyKcdTpInElno(KorKcdTpElnoVO korKcdTpElnoVO) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = korKcdTpElnoVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			new SQLExecuter("").executeUpdate((ISQLTemplate) new KorManifestListDBDAOmodifyKcdTpInElnoUSQL(),param, velParam);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Customer Cnt 조회
	 *
	 * @param KorCustCntVO custCntVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchCustCnt(KorCustCntVO custCntVO) throws DAOException {
		String cnt = "0";

		//KorExportCheckInfoVO korExportNoVO = null;
		DBRowSet dbRowset = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = custCntVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorManifestListDBDAOsearchCustCntRSQL(),param, velParam);
			if(dbRowset.next()) cnt = dbRowset.getString("CNT");
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return cnt;

	}

	/**
	 * Edit B/L 후 Customer 정보 UPDATE (Count 가 0이 아닌 경우)
	 * @param KorCustInqVO custInqVO
	 * @exception DAOException
	 */
	public void modifyCustInq(KorCustInqVO custInqVO) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = custInqVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			new SQLExecuter("").executeUpdate((ISQLTemplate) new KorManifestListDBDAOmodifyCustInqUSQL(),param, velParam);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Empty BL 의 CSTMS_BL_NO 재조회
	 *
	 * @param KorCblCntrVO cblCntrVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchCblNo(KorCblCntrVO cblCntrVO) throws DAOException {
		String cBlNo = null;

		//KorExportCheckInfoVO korExportNoVO = null;
		DBRowSet dbRowset = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = cblCntrVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorManifestListDBDAOsearchCblNoRSQL(),param, velParam);
			if(dbRowset.next()) cBlNo = dbRowset.getString("C_BL_NO");
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return cBlNo;
	}

	/**
	 * Full/Empty Container Summary 조회
	 *
	 * @param KorSumVO sumVO
	 * @return KorFullEmpSumVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public KorFullEmpSumVO searchFullEmpCntrSum(KorSumVO sumVO) throws DAOException {
		KorFullEmpSumVO korFullEmpSumVO = null;
		List <KorFullEmpSumVO> list = null;
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = sumVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorManifestListDBDAOsearchFullEmpCntrSumRSQL(),param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, KorFullEmpSumVO.class);
			if(list == null) return null;
			if(list.size() > 0) korFullEmpSumVO = list.get(0);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return korFullEmpSumVO;
	}

	/**
	 * Customer 정보가 존재하는지 체크
	 *
	 * @param KorCustExistVO custExistVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchCustExistCnt(KorCustExistVO  custExistVO) throws DAOException {
		String cnt = "0";

		//KorExportCheckInfoVO korExportNoVO = null;
		DBRowSet dbRowset = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = custExistVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorManifestListDBDAOsearchCustExistCntRSQL(),param, velParam);
			if(dbRowset.next()) cnt = dbRowset.getString("CNT");
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return cnt;
	}

	/**
	 * searchExportInfoDNList의 조회갯수와 비교하기위해 조회
	 * @param KorOldExpChkVO korOldExpChkVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchOldExportChk(KorOldExpChkVO KorOldExpChkVO) throws DAOException {
		String cnt = "0";

		//KorExportCheckInfoVO korExportNoVO = null;
		DBRowSet dbRowset = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = KorOldExpChkVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorManifestListDBDAOsearchOldExportChkRSQL(),param, velParam);
			if(dbRowset.next()) cnt = dbRowset.getString("CNT");
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return cnt;
	}

	/**
	 * 최초 다운인지 여부를 판단 조회
	 *
	 * @param BkgCstmsKrDlHisVO bkgCstmsKrDlHisVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchDownHistChkForRtv(BkgCstmsKrDlHisVO bkgCstmsKrDlHisVO) throws DAOException {
		String cnt = "0";

		//KorExportCheckInfoVO korExportNoVO = null;
		DBRowSet dbRowset = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = bkgCstmsKrDlHisVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorManifestListDBDAOsearchDownHistChkForRtvRSQL(),param, velParam);
			if(dbRowset.next()) cnt = dbRowset.getString("CNT");
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return cnt;
	}

	/**
	 * Group MSN정보조회를 위한 정보 search
	 * @param String bkgNo
	 * @return KorGrpMsnVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public KorGrpMsnVO searchInfoForGrpMsn(String bkgNo) throws DAOException {
		KorGrpMsnVO korGrpMsnVO = null;
		List <KorGrpMsnVO> list = null;
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("bkg_no", bkgNo);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorManifestListDBDAOsearchInfoForGrpMsnRSQL(),param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, KorGrpMsnVO.class);
			if(list == null) return null;
			if(list.size() > 0) korGrpMsnVO = list.get(0);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return korGrpMsnVO;
	}

	/**
	 * Correction 전송후 SendDate Update
	 *
	 * @param String usrId
	 * @param String subNo
	 * @throws DAOException
	 */
	public void modifySndDtCorrInfo(String usrId, String subNo) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = new HashMap<String,String>();

			mapVO.put("usr_id", usrId);
			mapVO.put("sub_no", subNo);

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			new SQLExecuter("").executeUpdate((ISQLTemplate)new KorManifestListDBDAOmodifyEmpCorrInfoUSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * OutBound 조회시 ETB Date 조회
	 *
	 * @param String vvdCd
	 * @param String polCd
	 * @return String
	 * @throws DAOException
	 */
	public String searchEtbDate(String vvdCd, String polCd) throws DAOException {
		String etbDt = "";

		//KorExportCheckInfoVO korExportNoVO = null;
		DBRowSet dbRowset = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();


		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("in_vvd", vvdCd);
			mapVO.put("in_pol", polCd);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorManifestListDBDAOsearchEtbDateRSQL(),param, velParam);
			if(dbRowset.next()) etbDt = dbRowset.getString("ETB_DT");
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return etbDt;
	}

	/**
	 * Shipper Code에 따라 MDM Customer에서 Customer Type을 조회
	 *
	 * @param String bkgNo
	 * @return String
	 * @throws DAOException
	 */
	public String searchCustType(String bkgNo) throws DAOException {
		String custType = "";

		//KorExportCheckInfoVO korExportNoVO = null;
		DBRowSet dbRowset = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();


		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("bkg_no", bkgNo);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorManifestListDBDAOsearchCustTypeRSQL(),param, velParam);
			if(dbRowset.next()) custType = dbRowset.getString("CUST_TYPE");
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return custType;
	}

	/**
	 * 해당 VVD가 B/L이 없는 공동 VVD 인지 체크
	 *
	 * @param String vvd
	 * @param String portCd
	 * @param String polCd
	 * @return int
	 * @throws DAOException
	 */
	public int searchNoneBLCheck(String vvd, String portCd, String polCd) throws DAOException {
		int cntBkg = 0;

		DBRowSet dbRowset = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();


		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("vvd", vvd);
			mapVO.put("port_cd", portCd);
			mapVO.put("pol_cd", polCd);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorManifestListDBDAOSearchNoneBLVVDCheckRSQL(),param, velParam);
			if(dbRowset.next()) cntBkg = dbRowset.getInt("CNTBKG");
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return cntBkg;
	}

	/**
	 * 해당 VVD가 B/L이 없는 VVD 정보를 조회
	 *
	 * @param BkgCstmsKrVvdSmryVO bkgCstmsKrVvdSmryVO
	 * @return BkgCstmsKrVvdSmryVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public BkgCstmsKrVvdSmryVO searchNoneBLInfo(BkgCstmsKrVvdSmryVO bkgCstmsKrVvdSmryVO) throws DAOException {
		BkgCstmsKrVvdSmryVO returnVal = null;
		List <BkgCstmsKrVvdSmryVO> list = null;
		DBRowSet dbRowset = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();


		try {
			Map<String, String> mapVO = bkgCstmsKrVvdSmryVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorManifestListDBDAOSearchNoneBLVVDInfoRSQL(),param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgCstmsKrVvdSmryVO.class);
			if(list == null) return null;
			if(list.size() > 0) returnVal = list.get(0);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return returnVal;
	}

	/**
	 * Bonded type을 업데이트<br>
	 *
	 * @param BkgWebServiceVO webVo
	 * @exception DAOException
	 */
	public void modifyBondType(BkgWebServiceVO webVo)throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = webVo.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			if(webVo != null){
				int result = sqlExe.executeUpdate((ISQLTemplate)new KorManifestListDBDAOmodifyDiscCYBondInfoFromWebUSQL(), param, velParam);

				if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}

	/**
	 * [ESM_BKG_0329]cross check 관련 result remark 저장<br>
	 *
	 * @param KorManifestCrsChkInfoVO korManifestCrsChkInfoVO
	 * @throws EventException
	 * @throws DAOException
	 */
	public void modifyCrossInfoKor(KorManifestCrsChkInfoVO korManifestCrsChkInfoVO) throws EventException, DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = -1;
		try	{
			Map<String, String> mapVO = korManifestCrsChkInfoVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new KorManifestListDBDAOmodifyCrossInfoKorUSQL(), param,	velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		}catch (SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch (Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [ESM_BKG_0329]cross check 관련 result remark 저장<br>
	 *
	 * @param KorManifestCrsChkInfoVO korManifestCrsChkInfoVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 * @throws DAOException
	 */
	public void addCrossInfoKor(KorManifestCrsChkInfoVO korManifestCrsChkInfoVO , SignOnUserAccount account ) throws EventException, DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try	{
			Map<String, String> mapVO = korManifestCrsChkInfoVO.getColumnValues();

			param.put("usr_id", account.getUsr_id());

			param.putAll(mapVO);
			velParam.putAll(mapVO);


//			SQLExecuter sqlExe = new SQLExecuter("");
//			result = sqlExe.executeUpdate((ISQLTemplate) new KorManifestListDBDAOaddCrossInfoKorCSQL(), param,	velParam);
//			if (result == Statement.EXECUTE_FAILED)
//				throw new DAOException("Fail to insert SQL");
			new SQLExecuter("").executeUpdate((ISQLTemplate) new KorManifestListDBDAOaddCrossInfoKorCSQL(),param, velParam);
		}catch (SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch (Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * amand 후에 snd flg 업데이트
	 *
	 * @param KorBlInfoKorVO korBlInfoKorVO
	 * @exception DAOException
	 */
	public void modifySndFlg(KorBlInfoKorVO korBlInfoKorVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = korBlInfoKorVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			new SQLExecuter("").executeUpdate((ISQLTemplate)new KorManifestListDBDAOmodifySndFlgUSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * 한국세관 Cross Chk 화면에 BL Count 조회
	 *
	 * @param KorMrnNoVO manifestInfoVO
	 * @return KorMrnNoVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public KorMrnNoVO searchManifestCrsChkInfoSumKorList(KorMrnNoVO manifestInfoVO)throws DAOException {
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		List<KorMrnNoVO> list = null;
		KorMrnNoVO returnVal = null;

		try {
			Map<String, String> mapVO = manifestInfoVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorManifestListDBDAOSearchManifestCrsChkInfoSumKorRSQL(),param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, KorMrnNoVO.class);

			if(list == null) return null;
			if(list.size() > 0) returnVal = list.get(0);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return returnVal;
	}
}