/*=========================================================
 *Copyright(c) SMLines. All Rights Reserved.
 *@FileName : CndExpManifestListDownloadDBDAO.java
 *@FileTitle : CndExpManifestListDownloadDBDAO
 *Open Issues :
 *Change history :
 *@LastModifyDate :
 *@LastModifier :
 *@LastVersion :
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.canada.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.bkg.common.CountryCode;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.vo.CndCstmsManifestAmendmentVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.canada.vo.CndCstmsBlCstmsRsltVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.canada.vo.CndCstmsBlCustVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.canada.vo.CndCstmsBlHblListVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.canada.vo.CndCstmsBlMainVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.canada.vo.CndCstmsMfDtlListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.canada.vo.CndCstmsMfDtlVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.canada.vo.CndCstmsMfListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.canada.vo.CndCstmsMfVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.canada.vo.CndCstmsVesselArrivalInfoCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.canada.vo.CndCstmsVslCrnNoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.canada.vo.CndCstmsVvdInfoCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.canada.vo.CndManifestModificationVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.canada.vo.CndVesselArrivalDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UsaCntrListRsltVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UsaCntrSealNoListRsltVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UsaContainerListVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UsaContainerManifestInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UsaContainerManifestListVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ContainerListRsltVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.CstmsVvdInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.VesselArrivalDetailVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.BkgCstmsAdvBlVO;
import com.hanjin.syscommon.common.table.BkgCstmsAdvCntrMfVO;
import com.hanjin.syscommon.common.table.BkgCstmsAdvCntrVO;
import com.hanjin.syscommon.common.table.BkgCstmsAdvCustVO;
import com.hanjin.syscommon.common.table.BkgCstmsAdvMkDescVO;
import com.hanjin.syscommon.common.table.BkgCstmsCndVslVO;
import com.hanjin.syscommon.common.table.BkgCstmsSealNoVO;


/**
 * CndExpManifestListDownloadDBDAO<br>
 * CndExpManifestListDownloadDBDAO system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author
 * @see 상위 BCImpl 참조
 * @since J2EE 1.6
 */
public class CndExpManifestListDownloadDBDAO extends DBDAOSupport {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;


	/**
	 * 세관 BL수정
	 * 
	 * @param List<BkgCstmsAdvBlVO> bkgCstmsAdvBlVOList
	 * @throws DAOException
	 */
	public void modifyBkgCstmsAdvBl(List<BkgCstmsAdvBlVO> bkgCstmsAdvBlVOList) throws DAOException {
		Map<String, Object> velParam = new HashMap<String, Object>();
		SQLExecuter sqlExe = new SQLExecuter("");
		int rsltCnt[] = null;

		try {
			if (bkgCstmsAdvBlVOList.size() > 0) {
				Map<String, String> mapVO = bkgCstmsAdvBlVOList.get(0).getColumnValues();
				velParam.putAll(mapVO);
				if (bkgCstmsAdvBlVOList.get(0).getCstmsAckKeyNo() != null && !"".equals(bkgCstmsAdvBlVOList.get(0).getCstmsAckKeyNo())) {
					// EDI 수신메시지
					rsltCnt = sqlExe.executeBatch((ISQLTemplate) new CndExpManifestListDownloadDBDAOmodifyBkgCstmsAdvBl4USQL(), bkgCstmsAdvBlVOList, velParam);
				} else if ("AvcNoteSetUp".equals(bkgCstmsAdvBlVOList.get(0).getIbflag())) {
					// 화면 0025(Advice Notes (Canada))에서 A/N Type 수정
					rsltCnt = sqlExe.executeBatch((ISQLTemplate) new CndExpManifestListDownloadDBDAOmodifyBkgCstmsAdvBl2USQL(), bkgCstmsAdvBlVOList, velParam);
				} else if ("MF_STS_CD".equals(bkgCstmsAdvBlVOList.get(0).getIbflag())) {
					// 화면 N002, 0028에서 MF_STS_CD 변경
					rsltCnt = sqlExe.executeBatch((ISQLTemplate) new CndExpManifestListDownloadDBDAOmodifyMfStsCdUSQL(), bkgCstmsAdvBlVOList, velParam);
				} else {
					rsltCnt = sqlExe.executeBatch((ISQLTemplate) new CndExpManifestListDownloadDBDAOmodifyBkgCstmsAdvBlUSQL(), bkgCstmsAdvBlVOList, velParam);
				}
				for (int i=0; i<rsltCnt.length; i++) {
					if (rsltCnt[i] == Statement.EXECUTE_FAILED) throw new DAOException("Fail to update No" + i + " SQL");
				}
			}

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	 /**
	 * 기 다운로드 된 B/L 정보를 삭제한다.<br>
	 * 
	 * @param CndManifestModificationVO cndManifestModificationVO
	 * @throws DAOException
	 */
	public void removeBKGAdvManifestBlCA(CndManifestModificationVO cndManifestModificationVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			if (cndManifestModificationVO != null) {
				Map<String, String> mapVO = cndManifestModificationVO.getColumnValues();
				param.putAll(mapVO);
				int result = new SQLExecuter("").executeUpdate((ISQLTemplate) new CndExpManifestListDownloadDBDAOremoveBkgCstmsAdvBlByVVDDSQL(), param, null);
				if (result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to delete SQL");
			}

		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	 /**
	 * 기 다운로드 된 B/L 정보를 삭제한다.<br>
	 * 
	 * @param CndManifestModificationVO cndManifestModificationVO
	 * @throws DAOException
	 */
	public void removeBKGAdvManifestCntrCA(CndManifestModificationVO cndManifestModificationVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			if (cndManifestModificationVO != null) {
				Map<String, String> mapVO = cndManifestModificationVO.getColumnValues();
				param.putAll(mapVO);
				int result = new SQLExecuter("").executeUpdate((ISQLTemplate) new CndExpManifestListDownloadDBDAOremoveBkgCstmsAdvCntrByVVDDSQL(), param, null);
				if (result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to delete SQL");
			}

		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	 /**
	 * 기 다운로드 된 B/L 정보를 삭제한다.<br>
	 * 
	 * @param CndManifestModificationVO cndManifestModificationVO
	 * @exception DAOException
	 */
	public void removeBKGAdvManifestCustCA(CndManifestModificationVO cndManifestModificationVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			if (cndManifestModificationVO != null) {
				Map<String, String> mapVO = cndManifestModificationVO.getColumnValues();
				param.putAll(mapVO);
				int result = new SQLExecuter("").executeUpdate((ISQLTemplate) new CndExpManifestListDownloadDBDAOremoveBkgCstmsAdvCustByVVDDSQL(), param, null);
				if (result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to delete SQL");
			}

		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	 /**
	 * 기 다운로드 된 B/L 정보를 삭제한다.<br>
	 * 
	 * @param CndManifestModificationVO cndManifestModificationVO
	 * @exception DAOException
	 */
	public void removeBKGAdvManifestSealNoCA(CndManifestModificationVO cndManifestModificationVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			if (cndManifestModificationVO != null) {
				Map<String, String> mapVO = cndManifestModificationVO.getColumnValues();
				param.putAll(mapVO);
				int result = new SQLExecuter("").executeUpdate((ISQLTemplate) new CndExpManifestListDownloadDBDAOremoveBkgCstmsAdvSealNoByVVDDSQL(), param, null);
				if (result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to delete SQL");
			}

		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	 /**
	 * 기 다운로드 된 B/L 정보를 삭제한다.<br>
	 * 
	 * @param CndManifestModificationVO cndManifestModificationVO
	 * @exception DAOException
	 */
	public void removeBKGAdvManifestCntrMfCA(CndManifestModificationVO cndManifestModificationVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			if (cndManifestModificationVO != null) {
				Map<String, String> mapVO = cndManifestModificationVO.getColumnValues();
				param.putAll(mapVO);
				int result = new SQLExecuter("").executeUpdate((ISQLTemplate) new CndExpManifestListDownloadDBDAOremoveBkgCstmsAdvCntrMfByVVDDSQL(), param, null);
				if (result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to delete SQL");
			}

		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * CUSTOMER 수정
	 *
	 * @param bkgCstmsAdvCustVOs CUSTOMER정보
	 * @throws DAOException
	 */
	public void modifyBkgCstmsAdvCust(List<BkgCstmsAdvCustVO> bkgCstmsAdvCustVOs) throws DAOException {
		try {
			if (bkgCstmsAdvCustVOs.size() > 0) {
				int updCnt[] = new SQLExecuter("").executeBatch((ISQLTemplate) new CndExpManifestListDownloadDBDAOmodifyBkgCstmsAdvCustUSQL(), bkgCstmsAdvCustVOs, null);
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
	 * CONTAINER 수정
	 *
	 * @param List<BkgCstmsAdvCntrVO> bkgCstmsAdvCntrVOList
	 * @throws DAOException
	 */
	public void modifyBkgCstmsAdvCntr(List<BkgCstmsAdvCntrVO> bkgCstmsAdvCntrVOList) throws DAOException {
		try {
			if (bkgCstmsAdvCntrVOList.size() > 0) {
				int rsltCnt[] = new SQLExecuter("").executeBatch((ISQLTemplate) new CndExpManifestListDownloadDBDAOmodifyBkgCstmsAdvCntrUSQL(), bkgCstmsAdvCntrVOList, null);
				for (int i=0; i<rsltCnt.length; i++) {
					if (rsltCnt[i] == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * 대상 B/L 조회 기능
	 *
	 * @param CndCstmsMfListCondVO cndCstmsMfListCondVO
	 * @return List<ManifestListDetailVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<ManifestListDetailVO> searchCndCstmsMfList(CndCstmsMfListCondVO cndCstmsMfListCondVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (cndCstmsMfListCondVO != null) {
				Map<String, String> mapVO = new HashMap<String, String>();
				mapVO = cndCstmsMfListCondVO.getColumnValues();
				mapVO.put("cnt_cd", CountryCode.CA);
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CndExpManifestListDownloadDBDAOsearchCndCstmsMfListRSQL(), param, velParam);
			return (List) RowSetUtil.rowSetToVOs(dbRowset, CndCstmsMfVO.class);

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * 대상 B/L 상세 조회 기능
	 *
	 * @param CndCstmsMfDtlListCondVO cndCstmsMfDtlListCondVO
	 * @return List<ManifestListDetailVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<ManifestListDetailVO> searchCndCstmsMfDtlList(CndCstmsMfDtlListCondVO cndCstmsMfDtlListCondVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (cndCstmsMfDtlListCondVO != null) {
				Map<String, String> mapVO = cndCstmsMfDtlListCondVO.getColumnValues();
				mapVO.put("cnt_cd", CountryCode.CA);
				int pageNo = Integer.parseInt("".equals(cndCstmsMfDtlListCondVO.getPageNo()) ? "1" : cndCstmsMfDtlListCondVO.getPageNo());
				int pageRows = Integer.parseInt(cndCstmsMfDtlListCondVO.getPagerows());
				int totalRows = Integer.parseInt(cndCstmsMfDtlListCondVO.getTotal());
				int startNo = (pageNo - 1) * pageRows + 1;
				int endNo = pageNo * pageRows;
				endNo = (totalRows > 0 && endNo > totalRows) ? totalRows : endNo;
				mapVO.put("startNo", String.valueOf(startNo));
				mapVO.put("endNo", String.valueOf(endNo));
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CndExpManifestListDownloadDBDAOsearchCndCstmsMfDtlListRSQL(), param, velParam);
			return (List) RowSetUtil.rowSetToVOs(dbRowset, CndCstmsMfDtlVO.class);

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * CCN prefix 존재여부 (Export용은 POD가 아닌 POL로 check)
	 *
	 * @param String vslCd
	 * @param String skdVoyNo
	 * @param String skdDirCd
	 * @param  String polCd
	 * @return boolean
	 * @throws DAOException
	 */
	public boolean checkIfCCNAval(String vslCd, String skdVoyNo, String skdDirCd, String polCd) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("vsl_cd", vslCd);
			param.put("skd_voy_no", skdVoyNo);
			param.put("skd_dir_cd", skdDirCd);
			param.put("pol_cd", polCd);
			velParam.put("cnt_cd", polCd.substring(0, 2));
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CndExpManifestListDownloadDBDAOcheckIfCCNAvalRSQL(), param, velParam);
			return dbRowset.next() ? true : false;

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Canada B/L Download 시 BKG_CSTMS_ADV_CNTR 테이블의 RAIL_CRR_REF_NO, USA_IB_TRSP_NO 2개 칼럼 기존 데이터 유지
	 *
	 * @param BkgCstmsAdvCntrVO bkgCstmsAdvCntrVO
	 * @return List<BkgCstmsAdvCntrVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<BkgCstmsAdvCntrVO> searchBkgCstmsAdvCntr(BkgCstmsAdvCntrVO bkgCstmsAdvCntrVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			if (bkgCstmsAdvCntrVO != null) {
				Map<String, String> mapVO = bkgCstmsAdvCntrVO.getColumnValues();
				param.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CndExpManifestListDownloadDBDAOsearchBkgCstmsAdvCntrRSQL(), param, null);
			return (List) RowSetUtil.rowSetToVOs(dbRowset, BkgCstmsAdvCntrVO.class);

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Manifest Desc 삭제
	 *
	 * @param BkgCstmsAdvMkDescVO bkgCstmsAdvMkDesc
	 * @throws DAOException
	 */
	public void removeBkgCstmsAdvMkDesc(BkgCstmsAdvMkDescVO bkgCstmsAdvMkDesc) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			if (bkgCstmsAdvMkDesc != null) {
				Map<String, String> mapVO = bkgCstmsAdvMkDesc.getColumnValues();
				param.putAll(mapVO);
				int result = new SQLExecuter("").executeUpdate((ISQLTemplate) new CndExpManifestListDownloadDBDAOremoveBkgCstmsAdvMkDescDSQL(), param, null);
				if (result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to delete SQL");
			}

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * 컨테이너 Manifest 삭제
	 *
	 * @param BkgCstmsAdvCntrMfVO bkgCstmsAdvCntrMf
	 * @throws DAOException
	 */
	public void removeBkgCstmsAdvCntrMf(BkgCstmsAdvCntrMfVO bkgCstmsAdvCntrMf) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			if (bkgCstmsAdvCntrMf != null) {
				Map<String, String> mapVO = bkgCstmsAdvCntrMf.getColumnValues();
				param.putAll(mapVO);
				int result = new SQLExecuter("").executeUpdate((ISQLTemplate) new CndExpManifestListDownloadDBDAOremoveBkgCstmsAdvCntrMfDSQL(), param, null);
				if (result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to delete SQL");
			}

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * 컨테이너 SEAL NO 삭제
	 *
	 * @param BkgCstmsSealNoVO bkgCstmsSealNoVO
	 * @throws DAOException
	 */
	public void removeBkgCstmsSealNo(BkgCstmsSealNoVO bkgCstmsSealNoVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			if (bkgCstmsSealNoVO != null) {
				Map<String, String> mapVO = bkgCstmsSealNoVO.getColumnValues();
				param.putAll(mapVO);
				int result = new SQLExecuter("").executeUpdate((ISQLTemplate) new CndExpManifestListDownloadDBDAOremoveBkgCstmsSealNoDSQL(), param, null);
				if (result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to delete SQL");
			}

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * 컨테이너 삭제
	 *
	 * @param BkgCstmsAdvCntrVO bkgCstmsAdvCntr
	 * @throws DAOException
	 */
	public void removeBkgCstmsAdvCntr(BkgCstmsAdvCntrVO bkgCstmsAdvCntr) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			if (bkgCstmsAdvCntr != null) {
				Map<String, String> mapVO = bkgCstmsAdvCntr.getColumnValues();
				param.putAll(mapVO);
				int result = new SQLExecuter("").executeUpdate((ISQLTemplate) new CndExpManifestListDownloadDBDAOremoveBkgCstmsAdvCntrDSQL(), param, null);
				if (result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to delete SQL");
			}

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Customer 삭제
	 *
	 * @param BkgCstmsAdvCustVO bkgCstmsAdvCust
	 * @throws DAOException
	 */
	public void removeBkgCstmsAdvCust(BkgCstmsAdvCustVO bkgCstmsAdvCust) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			if (bkgCstmsAdvCust != null) {
				Map<String, String> mapVO = bkgCstmsAdvCust.getColumnValues();
				param.putAll(mapVO);
				int result = new SQLExecuter("").executeUpdate((ISQLTemplate) new CndExpManifestListDownloadDBDAOremoveBkgCstmsAdvCustDSQL(), param, null);
				if (result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to delete SQL");
			}

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Booking Table의 원정보조회
	 *
	 * @param String bkgNo
	 * @param String vslCd
	 * @param String skdVoyNo
	 * @param String skdDirCd
	 * @return BkgCstmsAdvBlVO
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public BkgCstmsAdvBlVO searchBkgBookingMaster(String bkgNo, String vslCd, String skdVoyNo, String skdDirCd) throws DAOException {
		try {
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("bkg_no", bkgNo);
			param.put("vsl_cd", vslCd);
			param.put("skd_voy_no", skdVoyNo);
			param.put("skd_dir_cd", skdDirCd);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CndExpManifestListDownloadDBDAOsearchBkgBookingMasterRSQL(), param, null);
			List<BkgCstmsAdvBlVO> list = (List) RowSetUtil.rowSetToVOs(dbRowset, BkgCstmsAdvBlVO.class);
			return list.size() > 0 ? list.get(0) : null;

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Booking Table의 원정보조회
	 *
	 * @paramString bkgNo
	 * @param String blNo
	 * @param String vslCd
	 * @param  String skdVoyNo
	 * @param String skdDirCd
	 * @return BkgCstmsAdvBlVO
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public BkgCstmsAdvBlVO searchBkgBookingHBl(String bkgNo, String blNo, String vslCd, String skdVoyNo, String skdDirCd) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			param.put("bkg_no", bkgNo);
			param.put("bl_no", blNo);
			param.put("vsl_cd", vslCd);
			param.put("skd_voy_no", skdVoyNo);
			param.put("skd_dir_cd", skdDirCd);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CndExpManifestListDownloadDBDAOsearchBkgBookingHBlRSQL(), param, null);
			List<BkgCstmsAdvBlVO> list = (List) RowSetUtil.rowSetToVOs(dbRowset, BkgCstmsAdvBlVO.class);
			return list.size() > 0 ? list.get(0) : null;

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * BDR 이후 정보조회
	 *
	 * @param String bkgNo
	 * @return BkgCstmsAdvBlVO
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public BkgCstmsAdvBlVO searchBkgCorrection(String bkgNo) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			param.put("bkg_no", bkgNo);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CndExpManifestListDownloadDBDAOsearchBkgCorrectionRSQL(), param, null);
			List<BkgCstmsAdvBlVO> list = (List) RowSetUtil.rowSetToVOs(dbRowset, BkgCstmsAdvBlVO.class);
			return list.size() > 0 ? list.get(0) : null;

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * BKG_CSTMS_ADV_BL Insert Or Update
	 *
	 * @param BkgCstmsAdvBlVO bkgCstmsAdvBlVO
	 * @throws DAOException
	 */
	public void mergeSelectBkgCstmsAdvBl(BkgCstmsAdvBlVO bkgCstmsAdvBlVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			if (bkgCstmsAdvBlVO != null) {
				Map<String, String> mapVO = bkgCstmsAdvBlVO.getColumnValues();
				param.putAll(mapVO);
				if ("C".equals(bkgCstmsAdvBlVO.getIbflag())) {
					new SQLExecuter("").executeUpdate((ISQLTemplate) new CndExpManifestListDownloadDBDAOaddBkgCstmsAdvBlCSQL(), param, null);
				} else {
					new SQLExecuter("").executeUpdate((ISQLTemplate) new CndExpManifestListDownloadDBDAOmodifyBkgCstmsAdvBl3USQL(), param, null);
				}
			}

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * BKG_CUSTOMER 정보조회
	 *
	 * @param BkgCstmsAdvBlVO bkgCstmsAdvBlVO
	 * @return List<BkgCstmsAdvCustVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<BkgCstmsAdvCustVO> searchBkgCustomer(BkgCstmsAdvBlVO bkgCstmsAdvBlVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		SQLExecuter sqlExe = new SQLExecuter("");
		DBRowSet dbRowset = null;

		try {
			Map<String, String> mapVO = bkgCstmsAdvBlVO.getColumnValues();
			param.putAll(mapVO);
			dbRowset = sqlExe.executeQuery((ISQLTemplate) new CndExpManifestListDownloadDBDAOsearchBkgCustomerRSQL(), param, null);
			List<BkgCstmsAdvCustVO> list = (List) RowSetUtil.rowSetToVOs(dbRowset, BkgCstmsAdvCustVO.class);

			for (int i=0; i<list.size(); i++) {
				BkgCstmsAdvCustVO cust = list.get(i);
				if ("S".equals(cust.getBkgCustTpCd()) && ("".equals(cust.getCustCtyNm()) || "".equals(cust.getCustSteCd()) || "".equals(cust.getCstmsDeclCntCd()))) {
					// Shipper 정보가 없을때
					dbRowset = sqlExe.executeQuery((ISQLTemplate) new CndExpManifestListDownloadDBDAOsearchBkgCustomerShprRSQL(), param, null);
				} else if ("C".equals(cust.getBkgCustTpCd()) && ("".equals(cust.getCustCtyNm()) || "".equals(cust.getCustSteCd()) || "".equals(cust.getCstmsDeclCntCd()))) {
					// Consignee 정보가 없을때
					dbRowset = sqlExe.executeQuery((ISQLTemplate) new CndExpManifestListDownloadDBDAOsearchBkgCustomerCneeRSQL(), param, null);
				} else if ("N".equals(cust.getBkgCustTpCd()) && ("".equals(cust.getCustCtyNm()) || "".equals(cust.getCustSteCd()) || "".equals(cust.getCstmsDeclCntCd()))) {
					// Notify 정보가 없을때
					dbRowset = sqlExe.executeQuery((ISQLTemplate) new CndExpManifestListDownloadDBDAOsearchBkgCustomerNtfyRSQL(), param, null);
				} if (dbRowset != null && dbRowset.next()) {
					if ("".equals(cust.getCustCtyNm())) cust.setCustCtyNm(dbRowset.getString("CUST_CTY_NM"));
					if ("".equals(cust.getCstmsDeclCntCd())) cust.setCstmsDeclCntCd(dbRowset.getString("CUST_CNT_CD"));
					if ("".equals(cust.getCustSteCd())) cust.setCustSteCd(dbRowset.getString("CUST_STE_CD"));
				}
			}
			return list;

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * BKG_HBL_CUST 정보조회
	 *
	 * @param BkgCstmsAdvBlVO bkgCstmsAdvBlVO
	 * @return List<BkgCstmsAdvCustVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<BkgCstmsAdvCustVO> searchBkgHblCust(BkgCstmsAdvBlVO bkgCstmsAdvBlVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		SQLExecuter sqlExe = new SQLExecuter("");
		DBRowSet dbRowset = null;

		try {
			Map<String, String> mapVO = bkgCstmsAdvBlVO.getColumnValues();
			param.putAll(mapVO);
			dbRowset = sqlExe.executeQuery((ISQLTemplate) new CndExpManifestListDownloadDBDAOsearchBkgHblCustRSQL(), param, null);
			List<BkgCstmsAdvCustVO> list = (List) RowSetUtil.rowSetToVOs(dbRowset, BkgCstmsAdvCustVO.class);

			for (int i=0; i<list.size(); i++) {
				BkgCstmsAdvCustVO cust = list.get(i);
				if ("S".equals(cust.getBkgCustTpCd()) && ("".equals(cust.getCustCtyNm()) || "".equals(cust.getCustSteCd()) || "".equals(cust.getCstmsDeclCntCd()))) {
					// Shipper 정보가 없을때
					dbRowset = sqlExe.executeQuery((ISQLTemplate) new CndExpManifestListDownloadDBDAOsearchBkgCustomerShprRSQL(), param, null);
				} else if ("C".equals(cust.getBkgCustTpCd()) && ("".equals(cust.getCustCtyNm()) || "".equals(cust.getCustSteCd()) || "".equals(cust.getCstmsDeclCntCd()))) {
					// Consignee 정보가 없을때
					dbRowset = sqlExe.executeQuery((ISQLTemplate) new CndExpManifestListDownloadDBDAOsearchBkgCustomerCneeRSQL(), param, null);
				} else if ("N".equals(cust.getBkgCustTpCd()) && ("".equals(cust.getCustCtyNm()) || "".equals(cust.getCustSteCd()) || "".equals(cust.getCstmsDeclCntCd()))) {
					// Notify 정보가 없을때
					dbRowset = sqlExe.executeQuery((ISQLTemplate) new CndExpManifestListDownloadDBDAOsearchBkgCustomerNtfyRSQL(), param, null);
				}
				if (dbRowset != null && dbRowset.next()) {
					if ("".equals(cust.getCustCtyNm())) cust.setCustCtyNm(dbRowset.getString("CUST_CTY_NM"));
					if ("".equals(cust.getCstmsDeclCntCd())) cust.setCstmsDeclCntCd(dbRowset.getString("CUST_CNT_CD"));
					if ("".equals(cust.getCustSteCd())) cust.setCustSteCd(dbRowset.getString("CUST_STE_CD"));
				}
			}
			return list;

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * BKG_CSTMS_ADV_CUST Insert
	 *
	 * @param List<BkgCstmsAdvCustVO> bkgCstmsAdvCustVOList
	 * @throws DAOException
	 */
	public void addBkgCstmsAdvCust(List<BkgCstmsAdvCustVO> bkgCstmsAdvCustVOList) throws DAOException {
		try {
			if (bkgCstmsAdvCustVOList != null && bkgCstmsAdvCustVOList.size() > 0) {
				int rsltCnt[] = new SQLExecuter("").executeBatch((ISQLTemplate) new CndExpManifestListDownloadDBDAOaddBkgCstmsAdvCustCSQL(), bkgCstmsAdvCustVOList, null);
				for (int i=0; i<rsltCnt.length; i++) {
					if (rsltCnt[i] == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * BKG_CONTAINER 정보조회
	 *
	 * @param BkgCstmsAdvBlVO bkgCstmsAdvBlVO
	 * @return List<BkgCstmsAdvCntrVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<BkgCstmsAdvCntrVO> searchBkgContainer(BkgCstmsAdvBlVO bkgCstmsAdvBlVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = bkgCstmsAdvBlVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CndExpManifestListDownloadDBDAOsearchBkgContainerRSQL(), param, velParam);
			return (List) RowSetUtil.rowSetToVOs(dbRowset, BkgCstmsAdvCntrVO.class);

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * BKG_CSTMS_ADV_CNTR Insert
	 *
	 * @param List<BkgCstmsAdvCntrVO> bkgCstmsAdvCntrVOList
	 * @throws DAOException
	 */
	public void addBkgCstmsAdvCntr(List<BkgCstmsAdvCntrVO> bkgCstmsAdvCntrVOList) throws DAOException {
		try {
			if (bkgCstmsAdvCntrVOList != null && bkgCstmsAdvCntrVOList.size() > 0) {
				int rsltCnt[] = new SQLExecuter("").executeBatch((ISQLTemplate) new CndExpManifestListDownloadDBDAOaddBkgCstmsAdvCntrCSQL(), bkgCstmsAdvCntrVOList, null);
				for (int i=0; i<rsltCnt.length; i++) {
					if (rsltCnt[i] == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * BKG_CNTR_SEAL_NO 정보조회
	 *
	 * @param BkgCstmsAdvBlVO bkgCstmsAdvBlVO
	 * @return List<BkgCstmsSealNoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<BkgCstmsSealNoVO> searchBkgCntrSealNo(BkgCstmsAdvBlVO bkgCstmsAdvBlVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = bkgCstmsAdvBlVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CndExpManifestListDownloadDBDAOsearchBkgCntrSealNoRSQL(), param, velParam);
			return (List) RowSetUtil.rowSetToVOs(dbRowset, BkgCstmsSealNoVO.class);

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * BKG_CSTMS_SEAL_NO Insert
	 *
	 * @param List<BkgCstmsSealNoVO> bkgCstmsSealNoVOlist
	 * @throws DAOException
	 */
	public void addBkgCstmsSealNo(List<BkgCstmsSealNoVO> bkgCstmsSealNoVOlist) throws DAOException {
		try {
			if (bkgCstmsSealNoVOlist != null && bkgCstmsSealNoVOlist.size() > 0) {
				int rsltCnt[] = new SQLExecuter("").executeBatch((ISQLTemplate) new CndExpManifestListDownloadDBDAOaddBkgCstmsSealNoCSQL(), bkgCstmsSealNoVOlist, null);
				for (int i=0; i<rsltCnt.length; i++) {
					if (rsltCnt[i] == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * BKG_CNTR_MF_DESC 정보조회
	 *
	 * @param BkgCstmsAdvBlVO bkgCstmsAdvBlVO
	 * @return List<BkgCstmsAdvCntrMfVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<BkgCstmsAdvCntrMfVO> searchBkgCntrMfDesc(BkgCstmsAdvBlVO bkgCstmsAdvBlVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (bkgCstmsAdvBlVO != null) {
				Map<String, String> mapVO = bkgCstmsAdvBlVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CndExpManifestListDownloadDBDAOsearchBkgCntrMfDescRSQL(), param, velParam);
			return (List) RowSetUtil.rowSetToVOs(dbRowset, BkgCstmsAdvCntrMfVO.class);

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * BKG_CSTMS_ADV_CNTR_MF Insert
	 *
	 * @param List<BkgCstmsAdvCntrMfVO> bkgCstmsAdvCntrMfVOList
	 * @throws DAOException
	 */
	public void addBkgCstmsAdvCntrMf(List<BkgCstmsAdvCntrMfVO> bkgCstmsAdvCntrMfVOList) throws DAOException {
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (bkgCstmsAdvCntrMfVOList != null && bkgCstmsAdvCntrMfVOList.size() > 0) {
				Map<String, String> mapVO = bkgCstmsAdvCntrMfVOList.get(0).getColumnValues();
				velParam.putAll(mapVO);
				int rsltCnt[] = new SQLExecuter("").executeBatch((ISQLTemplate) new CndExpManifestListDownloadDBDAOaddBkgCstmsAdvCntrMfCSQL(), bkgCstmsAdvCntrMfVOList, velParam);
				for (int i=0; i<rsltCnt.length; i++) {
					if (rsltCnt[i] == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * BKG_BL_MK_DESC 정보조회
	 *
	 * @param BkgCstmsAdvBlVO bkgCstmsAdvBlVO
	 * @return List<BkgCstmsAdvMkDescVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<BkgCstmsAdvMkDescVO> searchBkgBlMkDesc(BkgCstmsAdvBlVO bkgCstmsAdvBlVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (bkgCstmsAdvBlVO != null) {
				Map<String, String> mapVO = bkgCstmsAdvBlVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CndExpManifestListDownloadDBDAOsearchBkgBlMkDescRSQL(), param, null);
			return (List) RowSetUtil.rowSetToVOs(dbRowset, BkgCstmsAdvMkDescVO.class);

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * BKG_CSTMS_ADV_MK_DESC Insert
	 *
	 * @param List<BkgCstmsAdvMkDescVO> bkgCstmsAdvMkDescVOList
	 * @throws DAOException
	 */
	public void addBkgCstmsAdvMkDesc(List<BkgCstmsAdvMkDescVO> bkgCstmsAdvMkDescVOList) throws DAOException {
		try {
			if (bkgCstmsAdvMkDescVOList != null && bkgCstmsAdvMkDescVOList.size() > 0) {
				int rsltCnt[] = new SQLExecuter("").executeBatch((ISQLTemplate) new CndExpManifestListDownloadDBDAOaddBkgCstmsAdvMkDescCSQL(), bkgCstmsAdvMkDescVOList, null);
				for (int i=0; i<rsltCnt.length; i++) {
					if (rsltCnt[i] == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * 현재시간 EST 시간대 구하기
	 *
	 * @return String
	 * @throws DAOException
	 */
	public String searchSysdate() throws DAOException {
		try {
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CndExpManifestListDownloadDBDAOsearchSysdateRSQL(), null, null);
			return dbRowset.next() ? dbRowset.getString(1) : "";

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * SEND LOG 테이블에 데이타 있는지 여부
	 *
	 * @param sBlNo BL_NO
	 * @return boolean
	 * @throws DAOException
	 */
	public boolean checkMiSendLog(String sBlNo) throws DAOException {
		boolean isMiSendLog = false;

		try {
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("bl_no", sBlNo);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CndExpManifestListDownloadDBDAOcheckMiSendLogRSQL(), param, null);
			if (dbRowset.next()) isMiSendLog = true;

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return isMiSendLog;
	}

	/**
	 * 세관에 적하목록을 신고시 필요한 Vessel Details 데이타를 수정 저장<br>
	 *
	 * @param List<CndCstmsManifestAmendmentVO> cndCstmsManifestAmendmentVOList
	 * @param String aiDiv
	 * @exception DAOException, Exception
	 */
	public void modifyCstmsAmendManifest(List<CndCstmsManifestAmendmentVO> cndCstmsManifestAmendmentVOList, String aiDiv) throws DAOException, Exception {
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (cndCstmsManifestAmendmentVOList != null && cndCstmsManifestAmendmentVOList.size() > 0) {
				velParam.put("ai_div", aiDiv);
				int rsltCnt[] = new SQLExecuter("").executeBatch((ISQLTemplate) new CndExpManifestListDownloadDBDAOmodifyCstmsAmendManifestUSQL(), cndCstmsManifestAmendmentVOList, velParam);
				for (int i=0; i<rsltCnt.length; i++) {
					if (rsltCnt[i]== Statement.EXECUTE_FAILED) throw new DAOException("Fail to update No"+ i + " SQL");
				}
			}

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Hub 정보 취득
	 *
	 * @param podCd
	 * @param delCd
	 * @param podNodCd
	 * @return
	 * @throws DAOException
	 */
	public String[] searchHubInfo(String podCd, String delCd, String podNodCd) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("pod_cd", podCd);
			param.put("del_cd", delCd);
			if (podNodCd != null && podNodCd.length() == 7) {
				param.put("pod_yd_no", podNodCd.substring(5, 7));
				velParam.put("pod_yd_no", podNodCd.substring(5, 7));
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CndExpManifestListDownloadDBDAOsearchHubInfoRSQL(), param, velParam);
			return (dbRowset.next() ? new String[]{dbRowset.getString(1), dbRowset.getString(2)} : new String[]{"", ""});

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * 세관 신고를 위해 다운로드 받은 B/L Main 정보 조회
	 *
	 * @param blNo B/L No.
	 * @return CndCstmsBlMainVO
	 * @throws DAOException
	 */
	@SuppressWarnings("rawtypes")
	public CndCstmsBlMainVO searchCndCstmsBlMain(String blNo) throws DAOException {
		CndCstmsBlMainVO vo = new CndCstmsBlMainVO();
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (blNo != null) {
				param.put("bl_no", blNo);
				velParam.put("bl_no", blNo);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CndExpManifestListDownloadDBDAOsearchCndCstmsBlMainRSQL(), param, velParam);
			List list = (List) RowSetUtil.rowSetToVOs(dbRowset, CndCstmsBlMainVO.class);
			if (list.size() > 0) vo = (CndCstmsBlMainVO) list.get(0);

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return vo;
	}

	/**
	 * B/L별 Customer 정보 조회
	 *
	 * @param blNo B/L No.
	 * @return CndCstmsBlCustVO
	 * @throws DAOException
	 */
	@SuppressWarnings("rawtypes")
	public CndCstmsBlCustVO searchCndCstmsBlCust(String blNo) throws DAOException {
		CndCstmsBlCustVO vo = new CndCstmsBlCustVO();;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (blNo != null) {
				param.put("bl_no", blNo);
				velParam.put("bl_no", blNo);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CndExpManifestListDownloadDBDAOsearchCndCstmsBlCustRSQL(), param, velParam);
			List list = (List) RowSetUtil.rowSetToVOs(dbRowset, CndCstmsBlCustVO.class);
			if (list.size() > 0) vo = (CndCstmsBlCustVO) list.get(0);

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return vo;
	}

	/**
	 * B/L별 세관 신고 전송 결과 조회
	 *
	 * @param blNo B/L No.
	 * @return List<CndCstmsBlCstmsRsltVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<CndCstmsBlCstmsRsltVO> searchCndCstmsBlCstmsRslt(String blNo) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (blNo != null) {
				param.put("bl_no", blNo);
				velParam.put("bl_no", blNo);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CndExpManifestListDownloadDBDAOsearchCndCstmsBlCstmsRsltRSQL(), param, velParam);
			return (List) RowSetUtil.rowSetToVOs(dbRowset, CndCstmsBlCstmsRsltVO.class);

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * B/L별 House B/L 정보 조회
	 *
	 * @param blNo B/L No.
	 * @return List<CndCstmsBlHblListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<CndCstmsBlHblListVO> searchCndCstmsBlHblList(String blNo) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (blNo != null) {
				param.put("bl_no", blNo);
				velParam.put("bl_no", blNo);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CndExpManifestListDownloadDBDAOsearchCndCstmsBlHblListRSQL(), param, velParam);
			return (List) RowSetUtil.rowSetToVOs(dbRowset, CndCstmsBlHblListVO.class);

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * BL의 컨테이너 정보를 조회한다.<br>
	 *
	 * @param String cntCd
	 * @param String blNo
	 * @return List<ContainerListRsltVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<ContainerListRsltVO> searchContainerByBl(String cntCd, String blNo) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("cnt_cd", cntCd);
			velParam.put("cnt_cd", cntCd);
			param.put("bl_no", blNo);
			velParam.put("bl_no", blNo);

			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CndExpManifestListDownloadDBDAOsearchContainerByBl2RSQL(), param, velParam);
			return (List) RowSetUtil.rowSetToVOs(dbRowset, UsaCntrListRsltVO.class);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * BL의 컨테이너 Seal No. 정보를 조회한다.<br>
	 *
	 * @param String cntCd
	 * @param String blNo
	 * @return List<ContainerListRsltVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<ContainerListRsltVO> searchContainerSealNoByBl(String cntCd, String blNo) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("cnt_cd", cntCd);
			velParam.put("cnt_cd", cntCd);
			param.put("bl_no", blNo);
			velParam.put("bl_no", blNo);

			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CndExpManifestListDownloadDBDAOsearchContainerSealNoByBl2RSQL(), param, velParam);
			return (List) RowSetUtil.rowSetToVOs(dbRowset, UsaCntrSealNoListRsltVO.class);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * BL의 컨테이너 정보를 수정한다.<br>
	 *
	 * @param UsaCntrListRsltVO usaCntrListRsltVO
	 * @param SignOnUserAccount account
	 * @return Integer
	 * @exception DAOException
	 */
	public int modifyContainer(UsaCntrListRsltVO usaCntrListRsltVO, SignOnUserAccount account) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = -1;

		try {
			Map<String, String> mapVO = usaCntrListRsltVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			param.put("cre_usr_id", account.getUsr_id());
			velParam.put("cre_usr_id", account.getUsr_id());
			param.put("upd_usr_id", account.getUsr_id());
			velParam.put("upd_usr_id", account.getUsr_id());
			param.put("cnt_cd", usaCntrListRsltVO.getCntCd());
			velParam.put("cnt_cd", usaCntrListRsltVO.getCntCd());

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new CndExpManifestListDownloadDBDAOmodifyContainerUSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert SQL");

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}

	/**
	 * BL의 컨테이너 Seal No. 정보를 수정한다.<br>
	 *
	 * @param UsaCntrSealNoListRsltVO usaCntrSealListRsltVO
	 * @param SignOnUserAccount account
	 * @return Integer
	 * @exception DAOException
	 */
	public int modifyContainerSealNo(UsaCntrSealNoListRsltVO usaCntrSealListRsltVO, SignOnUserAccount account) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = -1;

		try {
			Map<String, String> mapVO = usaCntrSealListRsltVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			param.put("usr_id", account.getUsr_id());
			velParam.put("usr_id", account.getUsr_id());
			param.put("cnt_cd", usaCntrSealListRsltVO.getCntCd());
			velParam.put("cnt_cd", usaCntrSealListRsltVO.getCntCd());

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new CndExpManifestListDownloadDBDAOmodifyContainerSealNoUSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert SQL");

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}

	/**
	 * BL의 컨테이너 Seal No. 정보를 삭제한다.<br>
	 *
	 * @param UsaCntrSealNoListRsltVO usaCntrSealListRsltVO
	 * @return Integer
	 * @exception DAOException
	 */
	public int removeContainerSealNo(UsaCntrSealNoListRsltVO usaCntrSealListRsltVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = -1;

		try {
			Map<String, String> mapVO = usaCntrSealListRsltVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			param.put("cnt_cd", usaCntrSealListRsltVO.getCntCd());
			velParam.put("cnt_cd", usaCntrSealListRsltVO.getCntCd());

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new CndExpManifestListDownloadDBDAOremoveContainerSealNo2DSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert SQL");

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}

	/**
	 * 컨테이너 Type Size Code(D2, D4...)를 가져온다.<br>
	 *
	 * @param String cntrNo
	 * @return List<ContainerListRsltVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<ContainerListRsltVO> searchCntrTySzCd(String cntrNo) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("cntr_no", cntrNo);
			velParam.put("cntr_no", cntrNo);

			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CndExpManifestListDownloadDBDAOsearchCntrTySzCdRSQL(), param, velParam);
			return (List) RowSetUtil.rowSetToVOs(dbRowset, UsaCntrListRsltVO.class);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Container가 활성화 상태인지 Delete상태인지를 업데이트 한다.<br>
	 *
	 * @param UsaCntrListRsltVO usaCntrListRsltVO
	 * @return Integer
	 * @exception DAOException
	 */
	public int modifyContainerStatus(UsaCntrListRsltVO usaCntrListRsltVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = -1;

		try {
			Map<String, String> mapVO = usaCntrListRsltVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			param.put("cnt_cd", usaCntrListRsltVO.getCntCd());
			velParam.put("cnt_cd", usaCntrListRsltVO.getCntCd());

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new CndExpManifestListDownloadDBDAOmodifyContainerStatusUSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert SQL");

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}

	/**
	 * BL의 컨테이너 CM 정보를 삭제한다.<br>
	 *
	 * @param UsaContainerManifestListVO usaCmVO
	 * @return Integer
	 * @exception DAOException
	 */
	public int removeCM(UsaContainerManifestListVO usaCmVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = -1;

		try {
			Map<String, String> mapVO = usaCmVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			param.put("cnt_cd", usaCmVO.getCntCd());
			velParam.put("cnt_cd", usaCmVO.getCntCd());

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new CndExpManifestListDownloadDBDAOremoveCMDSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert SQL");

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}

	/**
	 * BL의 컨테이너 목록을 조회한다.<br>
	 *
	 * @param String cntCd
	 * @param String blNo
	 * @return List<UsaContainerListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<UsaContainerListVO> searchContainerList(String cntCd, String blNo) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("cnt_cd", cntCd);
			velParam.put("cnt_cd", cntCd);
			param.put("bl_no", blNo);
			velParam.put("bl_no", blNo);

			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CndExpManifestListDownloadDBDAOsearchContainerListRSQL(), param, velParam);
			return (List) RowSetUtil.rowSetToVOs(dbRowset, UsaContainerListVO.class);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * BL의 컨테이너 CM 목록을 조회한다.<br>
	 *
	 * @param String cntCd
	 * @param String blNo
	 * @param String cntrNo
	 * @return List<UsaContainerManifestListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<UsaContainerManifestListVO> searchContainerManifestList(String cntCd, String blNo, String cntrNo) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try {
			param.put("cnt_cd", cntCd);
			velParam.put("cnt_cd", cntCd);
			param.put("bl_no", blNo);
			velParam.put("bl_no", blNo);
			param.put("cntr_no", cntrNo);
			velParam.put("cntr_no", cntrNo);
	
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CndExpManifestListDownloadDBDAOsearchContainerManifestListRSQL(), param, velParam);
			return (List) RowSetUtil.rowSetToVOs(dbRowset, UsaContainerManifestListVO.class);
	
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * BL의 컨테이너 정보를 조회한다.<br>
	 *
	 * @param String cntCd
	 * @param String blNo
	 * @return List<UsaContainerManifestInfoVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<UsaContainerManifestInfoVO> searchContainerManifestInfo(String cntCd, String blNo) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("cnt_cd", cntCd);
			velParam.put("cnt_cd", cntCd);
			param.put("bl_no", blNo);
			velParam.put("bl_no", blNo);

			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CndExpManifestListDownloadDBDAOsearchContainerManifestInfoRSQL(), param, velParam);
			return (List) RowSetUtil.rowSetToVOs(dbRowset, UsaContainerManifestInfoVO.class);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * BL의 컨테이너 CM 정보를 수정 또는 등록한다.<br>
	 *
	 * @param UsaContainerManifestListVO usaCmVO
	 * @param SignOnUserAccount account
	 * @return Integer
	 * @exception DAOException
	 */
	public int modifyCM(UsaContainerManifestListVO usaCmVO, SignOnUserAccount account) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = -1;

		try {
			Map<String, String> mapVO = usaCmVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			param.put("usr_id", account.getUsr_id());
			velParam.put("usr_id", account.getUsr_id());
			param.put("cnt_cd", usaCmVO.getCntCd());
			velParam.put("cnt_cd", usaCmVO.getCntCd());

			result = new SQLExecuter("").executeUpdate((ISQLTemplate) new CndExpManifestListDownloadDBDAOmodifyCMUSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert SQL");

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}

	/**
	 * Canada ACI_CRN(Conveyance Ref. No.) 생성을 위해 VVD 정보 조회<br>
	 *
	 * @param cndCstmsVvdInfoCondVO 조회조건
 	 * @return List<CstmsVvdInfoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<CstmsVvdInfoVO> searchCndCstmsVvdInfo(CndCstmsVvdInfoCondVO cndCstmsVvdInfoCondVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (cndCstmsVvdInfoCondVO != null) {
				Map<String, String> mapVO = cndCstmsVvdInfoCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CndExpManifestListDownloadDBDAOsearchCstmsVvdInfoRSQL(), param, velParam);
			return (List)RowSetUtil.rowSetToVOs(dbRowset, CstmsVvdInfoVO.class);

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * 중복된 VVD조회
	 *
	 * @param bkgCstmsCndVslVO VVD 정보
	 * @return String
	 * @throws DAOException
	 */
	public String searchDuplicateVvd(List<BkgCstmsCndVslVO> bkgCstmsCndVslVO) throws DAOException {
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
			param.put("vps_port_cd", bkgCstmsCndVslVO.get(0).getVpsPortCd());
			velParam.put("vvd_cd", vvd_cd);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CndExpManifestListDownloadDBDAOsearchDuplicateVvdRSQL(), param, velParam);
			return (dbRowset.next() ? dbRowset.getString("VSL_CD") : "");

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * 세관 관련 VVD 정보 생성
	 *
	 * @param bkgCstmsCndVslVO VVD 정보
	 * @throws DAOException
	 */
	public void addBkgCstmsCndVsl(List<BkgCstmsCndVslVO> bkgCstmsCndVslVO) throws DAOException {
		Map<String, Object> velParam = new HashMap<String, Object>();
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			if (bkgCstmsCndVslVO.size() > 0) {
				Map<String, String> mapVO = bkgCstmsCndVslVO.get(0).getColumnValues();
				velParam.putAll(mapVO);
				param.putAll(mapVO);
				
				int insCnt[] = new SQLExecuter("").executeBatch((ISQLTemplate) new CndExpManifestListDownloadDBDAOaddBkgCstmsCndVsl1CSQL(), bkgCstmsCndVslVO, velParam);
				
				for (int i=0; i<insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * 세관 신고용 VVD별 Max Reference No 조회
	 * Carrier Code와 상관없이 SML의 Carrier Code 918P로 조회한다.
	 * @param cndCarrierCd CrrCode
	 * @return String
	 * @throws DAOException
	 */
	public String searchMaxCndCstmsVvdRefNo(String cndCarrierCd) throws DAOException {
		DBRowSet dbRowset = null;
		String strVvdRefNo = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("crr_cd", cndCarrierCd);
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CndExpManifestListDownloadDBDAOcreateCndCstmsVvdRefNoRSQL(), param, velParam);
			if (dbRowset.next())
			{
				strVvdRefNo = dbRowset.getString(1);
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
		return strVvdRefNo;
	}
	

	/**
	 * CRN 정보 조회
	 * 
	 * @param CndCstmsVslCrnNoVO cndCstmsVslCrnNoVO 
	 * @return List<CndCstmsVslCrnNoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CndCstmsVslCrnNoVO> searchBkgCstmsCndVslCrnNo(CndCstmsVslCrnNoVO cndCstmsVslCrnNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CndCstmsVslCrnNoVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(cndCstmsVslCrnNoVO != null){
				Map<String, String> mapVO = cndCstmsVslCrnNoVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CndExpManifestListDownloadDBDAOsearchBkgCstmsCndVslCrnNoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CndCstmsVslCrnNoVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * CRN 삭제
	 * 
	 * @param CndCstmsVslCrnNoVO cndCstmsVslCrnNoVO 
	 * @throws DAOException
	 */
	public void removeBkgCstmsCndVslCrnNo(CndCstmsVslCrnNoVO cndCstmsVslCrnNoVO) throws DAOException {
		//query parameter
		Map<String, String> mapVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(cndCstmsVslCrnNoVO != null){
				mapVO = cndCstmsVslCrnNoVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new CndExpManifestListDownloadDBDAOremoveBkgCstmsCndVslCrnNoDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED){
				throw new DAOException("Fail to insert No"+ " SQL");
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
	 * Customer, Container, Commodity(CM) 등의 BL 정보 조회/확인<br>
	 * 
	 * @param cndCstmsVesselArrivalInfoCondVO 조회조건
	 * @return List<VesselArrivalDetailVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<VesselArrivalDetailVO> searchVesselArrival(CndCstmsVesselArrivalInfoCondVO cndCstmsVesselArrivalInfoCondVO)
			throws DAOException {
		DBRowSet dbRowset = null;
		List<VesselArrivalDetailVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			if (cndCstmsVesselArrivalInfoCondVO != null)
			{
				Map<String, String> mapVO = cndCstmsVesselArrivalInfoCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CndExpManifestListDownloadDBDAOsearchVesselArrivalRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CndVesselArrivalDetailVO.class);
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
	 * Customer, Container, Commodity(CM) 등의 BL 정보 조회/확인<br>
	 * 
	 * @param cndCstmsVesselArrivalInfoCondVO 조회조건
	 * @return List<VesselArrivalDetailVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<VesselArrivalDetailVO> searchVesselDeparture(CndCstmsVesselArrivalInfoCondVO cndCstmsVesselArrivalInfoCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<VesselArrivalDetailVO> list = null;
		Map<String, Object> param    = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			if (cndCstmsVesselArrivalInfoCondVO != null)
			{
				Map<String, String> mapVO = cndCstmsVesselArrivalInfoCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CndExpManifestListDownloadDBDAOsearchVesselDepartureRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CndVesselArrivalDetailVO.class);
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
	 * 세관 관련 VVD 정보 생성
	 * 
	 * @param bkgCstmsCndVslVO VVD 정보
	 * @throws DAOException
	 */
	public void mergeBkgCstmsCndVsl(List<BkgCstmsCndVslVO> bkgCstmsCndVslVO) throws DAOException {
		try
		{
			Map<String, Object> velParam = new HashMap<String, Object>();
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (bkgCstmsCndVslVO.size() > 0)
			{
				Map<String, String> mapVO = bkgCstmsCndVslVO.get(0).getColumnValues();
				velParam.putAll(mapVO);
				updCnt = sqlExe.executeBatch((ISQLTemplate) new CndExpManifestListDownloadDBDAOaddBkgCstmsCndVsl1CSQL(),
						bkgCstmsCndVslVO, velParam);
				for (int i = 0; i < updCnt.length; i++)
				{
					if (updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
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
	}	
}
