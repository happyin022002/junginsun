/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : NewZealandManifestListDownloadDBDAO.java
*@FileTitle : NewZealandManifestListDownloadDBDAO
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion : 1.0
* 2014.06.28
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.newzealand.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.newzealand.vo.NewZealandCstmsMfDtl2VO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.newzealand.vo.NewZealandCstmsMfDtlCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.newzealand.vo.NewZealandCstmsMfVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.newzealand.vo.NewZealandCstmsVvdInfoCondVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.syscommon.common.table.BkgCstmsCndVslVO;


/**
 * OPUS NewZealandManifestListDownloadDBDAO <br>
 * - NewZealandManifestListDownload system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author
 * @see Related NewZealandManifestListDownloadBCImpl
 * @since J2EE 1.6
 */
@SuppressWarnings("serial")
public class NewZealandManifestListDownloadDBDAO extends DBDAOSupport {

	/**
	 * NewZealand 세관 신고용 VVD 정보 조회
	 *
	 * @param NewZealandCstmsVvdInfoCondVO newZealandCstmsVvdInfoCondVO
	 * @return List<CstmsVvdInfoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<NewZealandCstmsVvdInfoCondVO> searchCstmsVvdInfo(NewZealandCstmsVvdInfoCondVO newZealandCstmsVvdInfoCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<NewZealandCstmsVvdInfoCondVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (newZealandCstmsVvdInfoCondVO != null) {
				Map<String, String> mapVO = newZealandCstmsVvdInfoCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new NewZealandManifestListDownloadDBDAOsearchCstmsVvdInfoRSQL(),param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,NewZealandCstmsVvdInfoCondVO.class);
		} catch (SQLException se) {

			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {

			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * VVD,Port 등 입력 후 세관 신고 대상 List를 조회한다.
	 *
	 * @param NewZealandCstmsMfDtlCondVO newZealandCstmsMfDtlCondVO
	 * @return List<ManifestListDetailVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<NewZealandCstmsMfVO> searchCstmsMfList(NewZealandCstmsMfDtlCondVO newZealandCstmsMfDtlCondVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (newZealandCstmsMfDtlCondVO != null) {
				Map<String, String> mapVO = newZealandCstmsMfDtlCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new NewZealandManifestListDownloadDBDAOsearchCstmsMfListRSQL(), param, velParam);
			return (List) RowSetUtil.rowSetToVOs(dbRowset, NewZealandCstmsMfVO.class);
		} catch (SQLException se) {

			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {

			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 세관 적하 목록 상세 정보를 조회
	 *
	 * @param NewZealandCstmsMfDtlCondVO newZealandCstmsMfDtlCondVO
	 * @return List<ManifestListDetailVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<NewZealandCstmsMfDtl2VO> searchCstmsMfDtlList(NewZealandCstmsMfDtlCondVO newZealandCstmsMfDtlCondVO) throws DAOException {

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (newZealandCstmsMfDtlCondVO != null) {
				Map<String, String> mapVO = newZealandCstmsMfDtlCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new NewZealandManifestListDownloadDBDAOsearchCstmsMfDtlListRSQL(), param, velParam);
			List<NewZealandCstmsMfDtl2VO> list = (List) RowSetUtil.rowSetToVOs(dbRowset, NewZealandCstmsMfDtl2VO.class);

			String blNo = "";
			int blKnt = 0;
			for (int i = 0; i < list.size(); i++) {
				NewZealandCstmsMfDtl2VO vo = (NewZealandCstmsMfDtl2VO) list.get(i);
				if (!blNo.equals(vo.getBlNo())) {
					blNo = vo.getBlNo();
					blKnt++;
				}
				vo.setSeq("" + blKnt);
				vo.setKind("N");
			}
			return list;

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}


	/**
	 * 중복된 VVD조회
	 *
	 * @param bkgCstmsCndVslVO VVD 정보
	 * @return String
	 * @throws DAOException
	 */
	@SuppressWarnings("rawtypes")
	public String searchDuplicateVvd(List<BkgCstmsCndVslVO> bkgCstmsCndVslVO) throws DAOException {
		DBRowSet dbRowset = null;
		String vvdCd = "";
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			String vvd_cd = "";
			for (int i = 0; i < bkgCstmsCndVslVO.size(); i++) {
				if (i == 0) {
					vvd_cd = "'" + bkgCstmsCndVslVO.get(i).getVslCd() + bkgCstmsCndVslVO.get(i).getSkdVoyNo() + bkgCstmsCndVslVO.get(i).getSkdDirCd() + "'";
				} else {
					vvd_cd = vvd_cd + ",'" + bkgCstmsCndVslVO.get(i).getVslCd() + bkgCstmsCndVslVO.get(i).getSkdVoyNo() + bkgCstmsCndVslVO.get(i).getSkdDirCd() + "'";
				}
			}
			param.put("cvy_ref_no", bkgCstmsCndVslVO.get(0).getCvyRefNo());
			velParam.put("vvd_cd", vvd_cd);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new NewZealandManifestListDownloadDBDAOsearchDuplicateVvdRSQL(), param, velParam);
			List list = RowSetUtil.rowSetToVOs(dbRowset, BkgCstmsCndVslVO.class);
			if (list != null && list.size() > 0) {
				vvdCd = ((BkgCstmsCndVslVO) list.get(0)).getVslCd();
			}
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return vvdCd;
	}

	/**
	 * 세관 관련 VVD 정보 생성
	 *
	 * @param bkgCstmsCndVslVO VVD 정보
	 * @throws DAOException
	 */
	public void addBkgCstmsCndVsl(List<BkgCstmsCndVslVO> bkgCstmsCndVslVO) throws DAOException {
		try {
			Map<String, Object> velParam = new HashMap<String, Object>();
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (bkgCstmsCndVslVO.size() > 0) {
				Map<String, String> mapVO = bkgCstmsCndVslVO.get(0).getColumnValues();
				velParam.putAll(mapVO);
				updCnt = sqlExe.executeBatch((ISQLTemplate) new NewZealandManifestListDownloadDBDAOaddBkgCstmsCndVsl1CSQL(), bkgCstmsCndVslVO, velParam);
				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i] == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * 세관 신고용 VVD별 Reference No 생성
	 *
	 * @param cndCarrierCd CrrCode
	 * @return String
	 * @throws DAOException
	 */
	public String createCndCstmsVvdRefNo(String cndCarrierCd) throws DAOException {
		DBRowSet dbRowset = null;
		String strVvdRefNo = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("crr_cd", cndCarrierCd);
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new NewZealandManifestListDownloadDBDAOcreateCndCstmsVvdRefNoRSQL(), param, velParam);
			if (dbRowset.next()) {
				strVvdRefNo = dbRowset.getString(1);
			}
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return strVvdRefNo;
	}
}