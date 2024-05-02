/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : CLLCDLManifestDBDAO.java
 *@FileTitle : ESM_BKG_0930
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.07.10
 *@LastModifier : 김승민
 *@LastVersion : 1.0
 * 2009.07.10 김승민
 * 1.0 Creation
 * ------------------------------------------------------
 * History
 * 2011.11.10 민정호 [CHM-201114288] Container Loadign Cross-Check (KOR) 기능 추가 요청
 * 2012.08.17 김보배 [CHM-201219430] [BKG] COPRAR (Pre-S/O) EDI 보완건
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.integration.UsaManifestListDownloadDBDAOsearchDownloadContainerListRSQL;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.basic.CLLCDLManifestBCImpl;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.CLLCDLManifestBkgQtyByCntrtsInfoVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.CLLCDLManifestCdlBkgVvdInfoVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.CLLCDLManifestCdlBlInfoVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.CLLCDLManifestCdlChargeInfoVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.CLLCDLManifestCdlChargeTotalInfoVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.CLLCDLManifestCdlCntrDescInfoVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.CLLCDLManifestCdlCstmsDescInfoVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.CLLCDLManifestCdlDgCntrInfoVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.CLLCDLManifestCdlMkDescInfoVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.CLLCDLManifestCdlQtyInfoVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.CLLCDLManifestCllBkgVvdInfoVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.CLLCDLManifestCllBlInfoVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.CLLCDLManifestCllCdlForODCYVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.CLLCDLManifestCllCntrDescInfoVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.CLLCDLManifestCllDgByCntrUnInfoVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.CLLCDLManifestCllDgCntrInfoVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.CLLCDLManifestCllQtyInfoVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.CLLCDLManifestCntrDetailVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.CLLCDLManifestCntrInfoVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.CLLCDLManifestEdiTerminalInfoVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.CLLCDLManifestEtaEtdInfoVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.CLLCDLManifestGateInDtInfoVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.CLLCDLManifestKorCllRemarkInfoVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.CLLCDLManifestLoadSumByPodDetailVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.CLLCDLManifestSearchVvdCdForRecieveInfoVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.CLLCDLManifestSpclCgoSumByPodDetailVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.CLLCDLManifestSpclCgoTotalByPodDetailVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.CLLCDLManifestSpclStowRqstByPodDetailVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.CLLCDLManifestStowDgInfoVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.CLLCDLManifestTbnTbxInfoVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.CLLCDLManifestVslSkdInfoVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.CdlCondVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.CdlDetailVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.CdlEdiDetailVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.CdlEdiListForSplitVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.CllCdlCheckCondVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.CllCdlCheckListDetailVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.CllCdlCheckUsaCondVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.CllCdlCheckUsaVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.CllCdlCntrInfoVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.CllCdlTransmitVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.CllDetailVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.CllDgCgoDetailVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.CllRfAkCgoDetailVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.CllSpclCondVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.CntrListForImportDetailVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.ExCntrTransmitBlInfoVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.ExCntrTransmitCntrBkgVvdInfoVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.ExCntrTransmitCntrDescInfoVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.ExCntrTransmitCntrDgInfoVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.ExCntrTransmitCntrInfoVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.ExCntrTransmitCntrQtyInfoVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.ExCntrTransmitCntrSpecialInfoVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.ExCntrTransmitCondVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.ExCntrTransmitVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.ExCntrVvdInfoVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.KorCllCdlCondVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.KorCllCdlDetailVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.KorCllCondVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.KorCllCrossChkCondVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.KorCllCrossChkListVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.KorCllDetailVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.KorCllLoadSumDetailVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.KorCllModifyVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.KorCllRemarkVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.KorCllRtvOptionVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.KorCllSpclCgoDetailVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.KorCllSpclCgoSumDetailVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.KorCllSpclStowRqstDetail2VO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.KorCllSpclStowRqstDetail3VO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.KorCllSpclStowRqstDetailVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.KorCllSppDetailVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.KorCllSppVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.PreAdviceManifestListVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.PreAdviceVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.PreAdviceVvdInfoVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.SpclCgoEtcDetailVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.TerminalCllVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.BkgCstmsCdConvCtntVO;
import com.hanjin.syscommon.common.table.BkgCstmsTmlCllDgCgoVO;
import com.hanjin.syscommon.common.table.BkgCstmsTmlCllVO;
import com.hanjin.syscommon.common.table.BkgCstmsTmlEurVO;
import com.hanjin.syscommon.common.table.MdmCntrTpSzVO;

/**
 * ALPS CLLCDLManifestDBDAO <br>
 * - ALPS-TerminalDocumentation system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Kim Seung Min
 * @see CLLCDLManifestBCImpl 참조
 * @since J2EE 1.6
 */
@SuppressWarnings("serial")
public class CLLCDLManifestDBDAO extends DBDAOSupport { 

	/**
	 * Container Loading List(Korea) 관련 Vessel Schedule 정보를 조회한다.<br>
	 * 
	 * @param KorCllCondVO korCllCondVO
	 * @return List<CLLCDLManifestVslSkdInfoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CLLCDLManifestVslSkdInfoVO> searchVslSkd(KorCllCondVO korCllCondVO) throws DAOException { 
		DBRowSet dbRowset = null;
		List<CLLCDLManifestVslSkdInfoVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (korCllCondVO != null) {
				Map<String, String> mapVO = korCllCondVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CLLCDLManifestDBDAOsearchVslSkdRSQL(), param, velParam, true);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CLLCDLManifestVslSkdInfoVO.class);
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
	 * Container Loading List(Korea) Loading Summary By POD 정보를 조회한다.<br>
	 * 
	 * @param KorCllCondVO korCllCondVO
	 * @return List<CLLCDLManifestLoadSumByPodDetailVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CLLCDLManifestLoadSumByPodDetailVO> searchLoadSumByPod(KorCllCondVO korCllCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CLLCDLManifestLoadSumByPodDetailVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (korCllCondVO != null) {
				Map<String, String> mapVO = korCllCondVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CLLCDLManifestDBDAOsearchLoadSumByPodRSQL(),
					param, velParam, true);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CLLCDLManifestLoadSumByPodDetailVO.class);
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
	 * Container Loading List(Korea) Special Cargo Summary By POD 정보를 조회한다.<br>
	 * 
	 * @param KorCllCondVO korCllCondVO
	 * @return List<CLLCDLManifestSpclCgoSumByPodDetailVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CLLCDLManifestSpclCgoSumByPodDetailVO> searchSpclCgoSumByPod(KorCllCondVO korCllCondVO)
			throws DAOException {
		DBRowSet dbRowset = null;
		List<CLLCDLManifestSpclCgoSumByPodDetailVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (korCllCondVO != null) {
				Map<String, String> mapVO = korCllCondVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CLLCDLManifestDBDAOsearchSpclCgoSumByPodRSQL(), param, velParam, true);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CLLCDLManifestSpclCgoSumByPodDetailVO.class);
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
	 * Container Loading List(Korea) Special Stowage Request POD 정보를 조회한다.<br>
	 * 
	 * @param KorCllCondVO korCllCondVO
	 * @return List<CLLCDLManifestSpclStowRqstByPodDetailVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CLLCDLManifestSpclStowRqstByPodDetailVO> searchSpclStowRqstByPod(KorCllCondVO korCllCondVO)
			throws DAOException {
		DBRowSet dbRowset = null;
		List<CLLCDLManifestSpclStowRqstByPodDetailVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (korCllCondVO != null) {
				Map<String, String> mapVO = korCllCondVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CLLCDLManifestDBDAOsearchSpclStowRqstByPodRSQL(), param, velParam, true);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CLLCDLManifestSpclStowRqstByPodDetailVO.class);
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
	 * Container Loading List(Korea) 관련 터미널 Vessel Code를 조회한다.<br>
	 * 
	 * @param String vslCd
	 * @return String attrCtnt
	 * @throws DAOException
	 * @throws Exception
	 */
	public String searchTmnlVslCd(String vslCd) throws DAOException {
		DBRowSet dbRowset = null;
		String attrCtnt = null;

		try {
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("vsl_cd", vslCd);
			// param.put("bkg_no_split", bkgNoSplit);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CLLCDLManifestDBDAOsearchTmnlVslCdRSQL(),
					param, null, true);
			if (dbRowset.next()) {
				attrCtnt = dbRowset.getString(1);
			} else {
				attrCtnt = "";
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return attrCtnt;
	}

	/**
	 * Container Loading List(Korea) Data를 조회한다.<br>
	 * 
	 * @param String vslCd
	 * @param String skdVoyNo
	 * @param String skdDirCd
	 * @param String polCd
	 * @param String polYdCd
	 * @param String sortType
	 * @param String inBkgStsCd
	 * @param String inCntrCfmFlg
	 * @return List<KorCllDetailVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<KorCllDetailVO> searchKorCllList(String vslCd, String skdVoyNo, String skdDirCd, String polCd,
			String polYdCd, String sortType, String inBkgStsCd, String inCntrCfmFlg) throws DAOException {
		DBRowSet dbRowset = null;
		List<KorCllDetailVO> list = null;

		try {
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("in_vsl_cd", vslCd);
			param.put("in_skd_voy_no", skdVoyNo);
			param.put("in_skd_dir_cd", skdDirCd);
			param.put("in_pol_cd", polCd);
			param.put("in_pol_yd_cd", polYdCd);
			param.put("in_sort_type", sortType);
			param.put("in_bkg_sts_cd", inBkgStsCd);
			param.put("in_cntr_cfm_flg", inCntrCfmFlg);
			// velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			velParam.put("in_vsl_cd", vslCd);
			velParam.put("in_skd_voy_no", skdVoyNo);
			velParam.put("in_skd_dir_cd", skdDirCd);
			velParam.put("in_pol_cd", polCd);
			velParam.put("in_pol_yd_cd", polYdCd);
			velParam.put("in_sort_type", sortType);
			velParam.put("in_bkg_sts_cd", inBkgStsCd);
			velParam.put("in_cntr_cfm_flg", inCntrCfmFlg);			

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CLLCDLManifestDBDAOsearchKorCllListRSQL(), param, velParam, true);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, KorCllDetailVO.class);
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
	 * Container Loading List(Korea) T/S Cargo Data를 조회한다.<br>
	 * 
	 * @param String vslCd
	 * @param String skdVoyNo
	 * @param String skdDirCd
	 * @param String polCd
	 * @param String polYdCd
	 * @param String bkgStsCd
	 * @param String cntrCfmFlg
	 * @param String sortType
	 * @param String inPolCntCd
	 * @return List<KorCllDetailVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<KorCllDetailVO> searchKorCllTsList(String vslCd, String skdVoyNo, String skdDirCd, String polCd,
			String polYdCd, String bkgStsCd, String cntrCfmFlg, String sortType, String inPolCntCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<KorCllDetailVO> list = null;

		try {
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("in_bkg_sts_cd", bkgStsCd);
			param.put("in_cntr_cfm_flg", cntrCfmFlg);
			param.put("in_vsl_cd", vslCd);
			param.put("in_skd_voy_no", skdVoyNo);
			param.put("in_skd_dir_cd", skdDirCd);
			param.put("in_pol_cd", polCd);
			param.put("in_pol_yd_cd", polYdCd);
			param.put("in_sort_type", sortType);
			param.put("in_pol_cnt_cd", inPolCntCd);
			Map<String, Object> velParam = new HashMap<String, Object>();
			velParam.put("in_bkg_sts_cd", bkgStsCd);
			velParam.put("in_cntr_cfm_flg", cntrCfmFlg);
			velParam.put("in_vsl_cd", vslCd);
			velParam.put("in_skd_voy_no", skdVoyNo);
			velParam.put("in_skd_dir_cd", skdDirCd);
			velParam.put("in_pol_cd", polCd);
			velParam.put("in_pol_yd_cd", polYdCd);
			velParam.put("in_sort_type", sortType);
			velParam.put("in_pol_cnt_cd", inPolCntCd);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CLLCDLManifestDBDAOsearchKorCllTsListRSQL(),
					param, velParam, true);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, KorCllDetailVO.class);
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
	 * Container Loading List(Korea) Local Cargo Data를 조회한다.<br>
	 * 
	 * @param String vslCd
	 * @param String skdVoyNo
	 * @param String skdDirCd
	 * @param String polCd
	 * @param String polYdCd
	 * @param String bkgStsCd
	 * @param String cntrCfmFlg
	 * @param String sortType
	 * @param String inPolCntCd
	 * @return List<KorCllDetailVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<KorCllDetailVO> searchKorCllLocalList(String vslCd, String skdVoyNo, String skdDirCd, String polCd,
			String polYdCd, String bkgStsCd, String cntrCfmFlg, String sortType, String inPolCntCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<KorCllDetailVO> list = null;

		try {
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("in_bkg_sts_cd", bkgStsCd);
			param.put("in_cntr_cfm_flg", cntrCfmFlg);
			param.put("in_vsl_cd", vslCd);
			param.put("in_skd_voy_no", skdVoyNo);
			param.put("in_skd_dir_cd", skdDirCd);
			param.put("in_pol_cd", polCd);
			param.put("in_pol_yd_cd", polYdCd);
			param.put("in_sort_type", sortType);
			param.put("in_pol_cnt_cd", inPolCntCd);
			Map<String, Object> velParam = new HashMap<String, Object>();
			velParam.put("in_bkg_sts_cd", bkgStsCd);
			velParam.put("in_cntr_cfm_flg", cntrCfmFlg);
			velParam.put("in_vsl_cd", vslCd);
			velParam.put("in_skd_voy_no", skdVoyNo);
			velParam.put("in_skd_dir_cd", skdDirCd);
			velParam.put("in_pol_cd", polCd);
			velParam.put("in_pol_yd_cd", polYdCd);
			velParam.put("in_sort_type", sortType);
			velParam.put("in_pol_cnt_cd", inPolCntCd);

			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CLLCDLManifestDBDAOsearchKorCllLocalListRSQL(), param, velParam, true);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, KorCllDetailVO.class);
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
	 * Container Loading List(Korea) Empty Cargo Data를 조회한다.<br>
	 * 
	 * @param String vslCd
	 * @param String skdVoyNo
	 * @param String skdDirCd
	 * @param String polCd
	 * @param String polYdCd
	 * @param String bkgStsCd
	 * @param String cntrCfmFlg
	 * @param String sortType
	 * @param String inPolCntCd
	 * @return List<KorCllDetailVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<KorCllDetailVO> searchKorCllEmptyList(String vslCd, String skdVoyNo, String skdDirCd, String polCd,
			String polYdCd, String bkgStsCd, String cntrCfmFlg, String sortType, String inPolCntCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<KorCllDetailVO> list = null;

		try {
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("in_bkg_sts_cd", bkgStsCd);
			param.put("in_cntr_cfm_flg", cntrCfmFlg);
			param.put("in_vsl_cd", vslCd);
			param.put("in_skd_voy_no", skdVoyNo);
			param.put("in_skd_dir_cd", skdDirCd);
			param.put("in_pol_cd", polCd);
			param.put("in_pol_yd_cd", polYdCd);
			param.put("in_sort_type", sortType);
			param.put("in_pol_cnt_cd", inPolCntCd);
			Map<String, Object> velParam = new HashMap<String, Object>();
			velParam.put("in_bkg_sts_cd", bkgStsCd);
			velParam.put("in_cntr_cfm_flg", cntrCfmFlg);
			velParam.put("in_vsl_cd", vslCd);
			velParam.put("in_skd_voy_no", skdVoyNo);
			velParam.put("in_skd_dir_cd", skdDirCd);
			velParam.put("in_pol_cd", polCd);
			velParam.put("in_pol_yd_cd", polYdCd);
			velParam.put("in_sort_type", sortType);
			velParam.put("in_pol_cnt_cd", inPolCntCd);

			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CLLCDLManifestDBDAOsearchKorCllEmptyListRSQL(), param, velParam, true);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, KorCllDetailVO.class);
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
	 * double calling된 Yard Code가 있는 지 체크한다.<br>
	 * 
	 * @param String vslCd
	 * @param String skdVoyNo
	 * @param String skdDirCd
	 * @param String vslCd2
	 * @param String skdVoyNo2
	 * @param String skdDirCd2
	 * @param String inPolCd
	 * @return int ydCount
	 * @throws DAOException
	 * @throws Exception
	 */
	public int searchDoubleCallYd(String vslCd, String skdVoyNo, String skdDirCd, String vslCd2, String skdVoyNo2,
			String skdDirCd2, String inPolCd) throws DAOException {
		DBRowSet dbRowset = null;
		int ydCount = 0;

		try {
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("vsl_cd", vslCd);
			param.put("skd_voy_no", skdVoyNo);
			param.put("skd_dir_cd", skdDirCd);
			param.put("vsl_cd2", vslCd2);
			param.put("skd_voy_no2", skdVoyNo2);
			param.put("skd_dir_cd2", skdDirCd2);
			param.put("in_pol_cd", inPolCd);
			// param.put("bkg_no_split", bkgNoSplit);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CLLCDLManifestDBDAOsearchDoubleCallYdRSQL(),
					param, null, true);
			if (dbRowset.next()) {
				ydCount = dbRowset.getInt(1);
			} else {
				ydCount = 0;
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return ydCount;
	}

	/**
	 * AWKWARD Cargo 존재 여부를 체크한다.<br>
	 * 
	 * @param String bkgNo
	 * @param String cntrNo
	 * @return String awkNo
	 * @throws DAOException
	 * @throws Exception
	 */
	public String searchAwkCgo(String bkgNo, String cntrNo) throws DAOException {
		DBRowSet dbRowset = null;
		String awkNo = null;

		try {
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("bkg_no", bkgNo);
			param.put("cntr_no", cntrNo);
			// param.put("bkg_no_split", bkgNoSplit);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CLLCDLManifestDBDAOsearchAwkCgoRSQL(),
					param, null, true);
			if (dbRowset.next()) {
				awkNo = dbRowset.getString(1);
			} else {
				awkNo = "";
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return awkNo;
	}

	/**
	 * Danger Cargo 존재 여부를 체크한다.<br>
	 * 
	 * @param String bkgNo
	 * @param String cntrNo
	 * @return String dgExist
	 * @throws DAOException
	 * @throws Exception
	 */
	public String searchDgCgo(String bkgNo, String cntrNo) throws DAOException {
		DBRowSet dbRowset = null;
		String dgExist = null;

		try {
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("bkg_no", bkgNo);
			param.put("cntr_no", cntrNo);
			// param.put("bkg_no_split", bkgNoSplit);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CLLCDLManifestDBDAOsearchDgCgoRSQL(), param,
					null, true);
			if (dbRowset.next()) {
				dgExist = dbRowset.getString(1);
			} else {
				dgExist = "";
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dgExist;
	}

	/**
	 * Reefer Dry Cargo 존재 여부를 체크한다.<br>
	 * 
	 * @param String bkgNo
	 * @param String cntrNo
	 * @return String rdExist
	 * @throws DAOException
	 * @throws Exception
	 */
	public String searchRdCgo(String bkgNo, String cntrNo) throws DAOException {
		DBRowSet dbRowset = null;
		String rdExist = null;

		try {
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("bkg_no", bkgNo);
			param.put("cntr_no", cntrNo);
			// param.put("bkg_no_split", bkgNoSplit);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CLLCDLManifestDBDAOsearchRdCgoRSQL(), param,
					null, true);
			if (dbRowset.next()) {
				rdExist = dbRowset.getString(1);
			} else {
				rdExist = "";
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rdExist;
	}

	/**
	 * Break Bulk Cargo 정보로 구성된 Break Bulk No 를 조회한다.<br>
	 * 
	 * @param String bkgNo
	 * @param String cntrNo
	 * @return String bBExist
	 * @throws DAOException
	 * @throws Exception
	 */
	public String searchBbCgo(String bkgNo, String cntrNo) throws DAOException {
		DBRowSet dbRowset = null;
		String bBExist = null;

		try {
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("bkg_no", bkgNo);
			param.put("cntr_no", cntrNo);
			// param.put("bkg_no_split", bkgNoSplit);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CLLCDLManifestDBDAOsearchBbCgoRSQL(), param,
					null, true);
			if (dbRowset.next()) {
				bBExist = dbRowset.getString(1);
			} else {
				bBExist = "";
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return bBExist;
	}

	/**
	 * Stowage, Danger Cargo 존재 여부를 체크한다.<br>
	 * 
	 * @param String bkgNo
	 * @return List<CLLCDLManifestStowDgInfoVO>
	 * @throws DAOException
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<CLLCDLManifestStowDgInfoVO> searchStowDg(String bkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<CLLCDLManifestStowDgInfoVO> list = null;

		try {
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("bkg_no", bkgNo);
			// param.put("bkg_no_split", bkgNoSplit);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CLLCDLManifestDBDAOsearchStowDgRSQL(),
					param, null, true);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CLLCDLManifestStowDgInfoVO.class);
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
	 * 해당 Booking Trunk Vessel Service Lane 정보를 조회한다.<br>
	 * 
	 * @param String bkgNo
	 * @return String slanCd
	 * @throws DAOException
	 * @throws Exception
	 */
	public String searchSvcLane(String bkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		String slanCd = null;

		try {
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("bkg_no", bkgNo);
			// param.put("bkg_no_split", bkgNoSplit);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CLLCDLManifestDBDAOsearchSvcLaneRSQL(),
					param, null, true);
			if (dbRowset.next()) {
				slanCd = dbRowset.getString(1);
			} else {
				slanCd = "";
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return slanCd;
	}

	/**
	 * Container Loading List(Korea) General Data를 조회한다.<br>
	 * 
	 * @param String inVslCd
	 * @param String inSkdVoyNo
	 * @param String inSkdDirCd
	 * @param String inPolCd
	 * @param String inPolYdCd
	 * @param String inRcvId
	 * @param String flatfileRefNo
	 * @return String generalInfo
	 * @throws DAOException
	 * @throws Exception
	 */
	public String searchGeneralInfo(String inVslCd, String inSkdVoyNo, String inSkdDirCd, String inPolCd,
			String inPolYdCd, String inRcvId, String flatfileRefNo) throws DAOException {
		DBRowSet dbRowset = null;
		String generalInfo = null;

		try {
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("in_vsl_cd", inVslCd);
			param.put("in_skd_voy_no", inSkdVoyNo);
			param.put("in_skd_dir_cd", inSkdDirCd);
			param.put("in_pol_cd", inPolCd);
			param.put("in_pol_yd_cd", inPolYdCd);
			param.put("in_rcv_id", inRcvId);
			param.put("flat_file_ref_no", flatfileRefNo);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CLLCDLManifestDBDAOsearchGeneralInfoRSQL(),
					param, null, true);
			if (dbRowset.next()) {
				generalInfo = dbRowset.getString(1);
			} else {
				generalInfo = "";
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return generalInfo;
	}

	/**
	 * Container Loading List(Korea) Container Detail 정보를 조회한다.<br>
	 * 
	 * @param String inVslCd
	 * @param String inSkdVoyNo
	 * @param String inSkdDirCd
	 * @param String inPolCd
	 * @param String inPolYdCd
	 * @param String inRcvId
	 * @return List<CLLCDLManifestCntrDetailVO>
	 * @throws DAOException
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<CLLCDLManifestCntrDetailVO> searchCntrDetail(String inVslCd, String inSkdVoyNo, String inSkdDirCd,
			String inPolCd, String inPolYdCd, String inRcvId) throws DAOException {
		DBRowSet dbRowset = null;
		List<CLLCDLManifestCntrDetailVO> list = null;
		try {
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("in_vsl_cd", inVslCd);
			param.put("in_skd_voy_no", inSkdVoyNo);
			param.put("in_skd_dir_cd", inSkdDirCd);
			param.put("in_pol_cd", inPolCd);
			param.put("in_pol_yd_cd", inPolYdCd);
			param.put("in_rcv_id", inRcvId);
			
			Map<String, Object> velParam = new HashMap<String, Object>();
			velParam.put("in_vsl_cd", inVslCd);
			velParam.put("in_skd_voy_no", inSkdVoyNo);
			velParam.put("in_skd_dir_cd", inSkdDirCd);
			velParam.put("in_pol_cd", inPolCd);
			velParam.put("in_pol_yd_cd", inPolYdCd);
			velParam.put("in_rcv_id", inRcvId);


			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CLLCDLManifestDBDAOsearchCntrDetailRSQL(),
					param, velParam, true);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CLLCDLManifestCntrDetailVO.class);
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
	 * Container Loading List(Korea) 관련 FlatfileRefNo를 조회한다.<br>
	 * 
	 * @return String flatfileRefNo
	 * @throws DAOException
	 * @throws Exception
	 */
	public String searchFlatfileRefNo() throws DAOException {
		DBRowSet dbRowset = null;
		String flatfileRefNo = null;

		try {
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			// param.put("vsl_cd", vslCd);
			// param.put("bkg_no_split", bkgNoSplit);

			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CLLCDLManifestDBDAOsearchFlatfileRefNoRSQL(), param, null, true);
			if (dbRowset.next()) {
				flatfileRefNo = dbRowset.getString(1);
			} else {
				flatfileRefNo = "";
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return flatfileRefNo;
	}

	/**
	 * Container Loading List(Korea) Loading Summary By POD 정보를 조회한다.<br>
	 * 
	 * @param KorCllCondVO korCllCondVO
	 * @return List<KorCllLoadSumDetailVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<KorCllLoadSumDetailVO> searchCllLoadSumByPod(KorCllCondVO korCllCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<KorCllLoadSumDetailVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (korCllCondVO != null) {
				Map<String, String> mapVO = korCllCondVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CLLCDLManifestDBDAOsearchCllLoadSumByPodRSQL(), param, velParam, true);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, KorCllLoadSumDetailVO.class);
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
	 * Container Loading List(Korea) Special Cargo Summary By POD 정보를 조회한다.<br>
	 * 
	 * @param KorCllCondVO korCllCondVO
	 * @return List<KorCllSpclCgoSumDetailVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<KorCllSpclCgoSumDetailVO> searchCllSpclCgoSumByPod(KorCllCondVO korCllCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<KorCllSpclCgoSumDetailVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (korCllCondVO != null) {
				Map<String, String> mapVO = korCllCondVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CLLCDLManifestDBDAOsearchCllSpclCgoSumByPodRSQL(), param, velParam, true);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, KorCllSpclCgoSumDetailVO.class);
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
	 * Container Loading List(Korea) Special Stowage Request POD 정보를 조회한다.<br>
	 * 
	 * @param KorCllCondVO korCllCondVO
	 * @return List<KorCllSpclStowRqstDetailVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<KorCllSpclStowRqstDetailVO> searchCllSpclStowRqstByPod(KorCllCondVO korCllCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<KorCllSpclStowRqstDetailVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (korCllCondVO != null) {
				Map<String, String> mapVO = korCllCondVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CLLCDLManifestDBDAOsearchCllSpclStowRqstByPodRSQL(), param, velParam, true);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, KorCllSpclStowRqstDetailVO.class);
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
	 * Container Loading List(Korea) Special Stowage Request POD 정보를 조회한다.<br>
	 * 
	 * @param KorCllCondVO korCllCondVO
	 * @return List<KorCllSpclStowRqstDetail2VO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<KorCllSpclStowRqstDetail2VO> searchCllSpclStowRqst2ByPod(KorCllCondVO korCllCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<KorCllSpclStowRqstDetail2VO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (korCllCondVO != null) {
				Map<String, String> mapVO = korCllCondVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CLLCDLManifestDBDAOsearchCllSpclStowRqst2ByPodRSQL(), param, velParam, true);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, KorCllSpclStowRqstDetail2VO.class);
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
	 * Container Loading List(Korea) Special Stowage Request POD 정보를 조회한다.<br>
	 * 
	 * @param KorCllCondVO korCllCondVO
	 * @return List<KorCllSpclStowRqstDetailVO3>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<KorCllSpclStowRqstDetail3VO> searchCllSpclStowRqst3ByPod(KorCllCondVO korCllCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<KorCllSpclStowRqstDetail3VO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (korCllCondVO != null) {
				Map<String, String> mapVO = korCllCondVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CLLCDLManifestDBDAOsearchCllSpclStowRqst3ByPodRSQL(), param, velParam, true);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, KorCllSpclStowRqstDetail3VO.class);
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
	 * Container Loading List(Korea) Loading Summary By POD 정보를 조회한다.<br>
	 * 
	 * @param KorCllCondVO korCllCondVO
	 * @return List<KorCllLoadSumDetailVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<KorCllLoadSumDetailVO> searchLoadSumByActPod(KorCllCondVO korCllCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<KorCllLoadSumDetailVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (korCllCondVO != null) {
				Map<String, String> mapVO = korCllCondVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CLLCDLManifestDBDAOsearchLoadSumByActPodRSQL(), param, velParam, true);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, KorCllLoadSumDetailVO.class);
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
	 * Container Loading List(Korea) Special Cargo Summary By POD 정보를 조회한다.<br>
	 * 
	 * @param KorCllCondVO korCllCondVO
	 * @return List<KorCllSpclCgoSumDetailVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<KorCllSpclCgoSumDetailVO> searchSpclCgoSumByActPod(KorCllCondVO korCllCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<KorCllSpclCgoSumDetailVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (korCllCondVO != null) {
				Map<String, String> mapVO = korCllCondVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CLLCDLManifestDBDAOsearchSpclCgoSumByActPodRSQL(), param, velParam, true);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, KorCllSpclCgoSumDetailVO.class);
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
	 * Container Loading List(Korea) Special Stowage Request POD 정보를 조회한다.<br>
	 * 
	 * @param KorCllCondVO korCllCondVO
	 * @return List<KorCllSpclStowRqstDetailVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<KorCllSpclStowRqstDetailVO> searchSpclStowRqstByActPod(KorCllCondVO korCllCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<KorCllSpclStowRqstDetailVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (korCllCondVO != null) {
				Map<String, String> mapVO = korCllCondVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CLLCDLManifestDBDAOsearchSpclStowRqstByActPodRSQL(), param, velParam, true);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, KorCllSpclStowRqstDetailVO.class);
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
	 * Container Loading List(Korea) Loading Summary By MLB 정보를 조회한다.<br>
	 * 
	 * @param KorCllCondVO korCllCondVO
	 * @return List<KorCllLoadSumDetailVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<KorCllLoadSumDetailVO> searchLoadSumByMlb(KorCllCondVO korCllCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<KorCllLoadSumDetailVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (korCllCondVO != null) {
				Map<String, String> mapVO = korCllCondVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CLLCDLManifestDBDAOsearchLoadSumByMlbRSQL(),
					param, velParam, true);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, KorCllLoadSumDetailVO.class);
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
	 * Container Loading List(Korea) Special Cargo Summary By MLB 정보를 조회한다..<br>
	 * 
	 * @param KorCllCondVO korCllCondVO
	 * @return List<KorCllSpclCgoSumDetailVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<KorCllSpclCgoSumDetailVO> searchSpclCgoSumByMlb(KorCllCondVO korCllCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<KorCllSpclCgoSumDetailVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (korCllCondVO != null) {
				Map<String, String> mapVO = korCllCondVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CLLCDLManifestDBDAOsearchSpclCgoSumByMlbRSQL(), param, velParam, true);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, KorCllSpclCgoSumDetailVO.class);
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
	 * Container Loading List(Korea) Special Stowage Request MLB 정보를 조회한다.<br>
	 * 
	 * @param KorCllCondVO korCllCondVO
	 * @return List<KorCllSpclStowRqstDetailVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<KorCllSpclStowRqstDetailVO> searchSpclStowRqstByMlb(KorCllCondVO korCllCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<KorCllSpclStowRqstDetailVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (korCllCondVO != null) {
				Map<String, String> mapVO = korCllCondVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CLLCDLManifestDBDAOsearchSpclStowRqstByMlbRSQL(), param, velParam, true);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, KorCllSpclStowRqstDetailVO.class);
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
	 * Container Loading List(Korea) Special Stowage Request MLB 정보를 조회한다.<br>
	 * 
	 * @param KorCllCondVO korCllCondVO
	 * @return List<KorCllSpclStowRqstDetail2VO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<KorCllSpclStowRqstDetail2VO> searchSpclStowRqst2ByMlb(KorCllCondVO korCllCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<KorCllSpclStowRqstDetail2VO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (korCllCondVO != null) {
				Map<String, String> mapVO = korCllCondVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CLLCDLManifestDBDAOsearchSpclStowRqst2ByMlbRSQL(), param, velParam, true);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, KorCllSpclStowRqstDetail2VO.class);
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
	 * Container Loading List(Korea) Special Stowage Request MLB 정보를 조회한다.<br>
	 * 
	 * @param KorCllCondVO korCllCondVO
	 * @return List<KorCllSpclStowRqstDetail3VO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<KorCllSpclStowRqstDetail3VO> searchSpclStowRqst3ByMlb(KorCllCondVO korCllCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<KorCllSpclStowRqstDetail3VO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (korCllCondVO != null) {
				Map<String, String> mapVO = korCllCondVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CLLCDLManifestDBDAOsearchSpclStowRqst3ByMlbRSQL(), param, velParam, true);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, KorCllSpclStowRqstDetail3VO.class);
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
	 * Container Loading List(Korea) Specail Cargo Data를 조회한다.<br>
	 * 
	 * @param KorCllCondVO korCllCondVO
	 * @return List<KorCllSpclCgoDetailVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<KorCllSpclCgoDetailVO> searchSpclCgoDtl(KorCllCondVO korCllCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<KorCllSpclCgoDetailVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			// query parameter
			if (korCllCondVO != null) {
				Map<String, String> mapVO = korCllCondVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CLLCDLManifestDBDAOsearchSpclCgoDtlRSQL(),
					param, velParam, true);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, KorCllSpclCgoDetailVO.class);
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
	 * Container Loading List(Korea) Special Cargo Total By POD 정보를 조회한다.<br>
	 * 
	 * @param KorCllCondVO korCllCondVO
	 * @return List<CLLCDLManifestSpclCgoTotalByPodDetailVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CLLCDLManifestSpclCgoTotalByPodDetailVO> searchSpclCgoTotalByPod(KorCllCondVO korCllCondVO)
			throws DAOException {
		DBRowSet dbRowset = null;
		List<CLLCDLManifestSpclCgoTotalByPodDetailVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			// query parameter
			if (korCllCondVO != null) {
				Map<String, String> mapVO = korCllCondVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CLLCDLManifestDBDAOsearchSpclCgoTotalByPodRSQL(), param, velParam, true);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CLLCDLManifestSpclCgoTotalByPodDetailVO.class);
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
	 * Container Loading List(Korea) Special Cargo R/D, PC, STOW 정보를 조회한다.<br>
	 * 
	 * @param KorCllCondVO korCllCondVO
	 * @return List<SpclCgoEtcDetailVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SpclCgoEtcDetailVO> searchSpclCgoEtc(KorCllCondVO korCllCondVO)
			throws DAOException {
		DBRowSet dbRowset = null;
		List<SpclCgoEtcDetailVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			// query parameter
			if (korCllCondVO != null) {
				Map<String, String> mapVO = korCllCondVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CLLCDLManifestDBDAOsearchSpclCgoEtcRSQL(), param, velParam, true);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SpclCgoEtcDetailVO.class);
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
	 * 해당 VVD, POL/POD port의 Contanier Loading/Discharging List를 조회한다.<br>
	 * 
	 * @param KorCllCdlCondVO korCllCdlCondVO
	 * @return List<KorCllCdlDetailVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<KorCllCdlDetailVO> searchCllCdl(KorCllCdlCondVO korCllCdlCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<KorCllCdlDetailVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			// query parameter
			if (korCllCdlCondVO != null) {
				Map<String, String> mapVO = korCllCdlCondVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CLLCDLManifestDBDAOsearchCllCdlRSQL(),
					param, velParam, true);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, KorCllCdlDetailVO.class);
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
	 * 해당 VVD, POL/POD port의 Contanier Loading/Discharging List를 조회한다.<br>
	 * 
	 * @param KorCllCdlCondVO korCllCdlCondVO
	 * @return List<CLLCDLManifestCllCdlForODCYVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CLLCDLManifestCllCdlForODCYVO> searchCllCdlForODCY(KorCllCdlCondVO korCllCdlCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CLLCDLManifestCllCdlForODCYVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			// query parameter
			if (korCllCdlCondVO != null) {
				Map<String, String> mapVO = korCllCdlCondVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CLLCDLManifestDBDAOsearchCllCdlForODCYRSQL(),
					param, velParam, true);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CLLCDLManifestCllCdlForODCYVO.class);
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
	 * 해당 VVD, POL/POD port의 Contanier Loading/Discharging List 중 해당 booking에 container가 없는 List를 조회한다. (조회옵션 중
	 * Container Status Match = 'N' 인 경우에 실행)<br>
	 * 
	 * @param KorCllCdlCondVO korCllCdlCondVO
	 * @return List<KorCllCdlDetailVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<KorCllCdlDetailVO> searchCllCdlNoCntr(KorCllCdlCondVO korCllCdlCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<KorCllCdlDetailVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			// query parameter
			if (korCllCdlCondVO != null) {
				Map<String, String> mapVO = korCllCdlCondVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CLLCDLManifestDBDAOsearchCllCdlNoCntrRSQL(),
					param, velParam, true);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, KorCllCdlDetailVO.class);
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
	 * 해당 VVD, POL/POD port의 Contanier Loading/Discharging List Yard Gate In Date를 조회한다.<br>
	 * 
	 * @param KorCllCdlCondVO korCllCdlCondVO
	 * @return String spclCgoDesc
	 * @throws DAOException
	 */
	public String searchSpecialCgo(KorCllCdlCondVO korCllCdlCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String spclCgoDesc = null;
		try {
			// query parameter
			if (korCllCdlCondVO != null) {
				Map<String, String> mapVO = korCllCdlCondVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CLLCDLManifestDBDAOsearchSpecialCgoRSQL(),
					param, velParam, true);
			if (dbRowset.next()) {
				spclCgoDesc = dbRowset.getString(1);
			} else {
				spclCgoDesc = "";
			}

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return spclCgoDesc;
	}

	/**
	 * Terminal EDI Transmit 대상 Contanier Loading/Discharging List를 조회한다.<br>
	 * 
	 * @param KorCllCdlCondVO korCllCdlCondVO
	 * @return List<CLLCDLManifestGateInDtInfoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CLLCDLManifestGateInDtInfoVO> searchGateInDt(KorCllCdlCondVO korCllCdlCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CLLCDLManifestGateInDtInfoVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			// query parameter
			if (korCllCdlCondVO != null) {
				Map<String, String> mapVO = korCllCdlCondVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CLLCDLManifestDBDAOsearchGateInDtRSQL(),
					param, velParam, true);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CLLCDLManifestGateInDtInfoVO.class);
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
	 * Terminal EDI Transmit 대상 Contanier Loading/Discharging List를 조회한다.<br>
	 * 
	 * @return List<MdmCntrTpSzVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<MdmCntrTpSzVO> searchMdmCntrTpSz() throws DAOException {
		DBRowSet dbRowset = null;
		List<MdmCntrTpSzVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			// query parameter

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CLLCDLManifestDBDAOsearchMdmCntrTpSzRSQL(),
					param, null, true);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, MdmCntrTpSzVO.class);
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
	 * Container Loading List 데이터 다운로드 관련 POL ETA, ETD 를 조회한다.<br>
	 * 
	 * @param TerminalCllVO terminalCllVO
	 * @return List<CLLCDLManifestEtaEtdInfoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CLLCDLManifestEtaEtdInfoVO> searchEtaEtd(TerminalCllVO terminalCllVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CLLCDLManifestEtaEtdInfoVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			// query parameter
			if (terminalCllVO != null) {
				Map<String, String> mapVO = terminalCllVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CLLCDLManifestDBDAOsearchEtaEtdRSQL(),
					param, velParam, true);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CLLCDLManifestEtaEtdInfoVO.class);
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
	 * Container Loading List 데이터 다운로드를 위한 TBN, TBX를 구한다.<br>
	 * 
	 * @return List<CLLCDLManifestTbnTbxInfoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CLLCDLManifestTbnTbxInfoVO> searchTbnTbx() throws DAOException {
		DBRowSet dbRowset = null;
		List<CLLCDLManifestTbnTbxInfoVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			// query parameter

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CLLCDLManifestDBDAOsearchTbnTbxRSQL(),
					param, null, true);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CLLCDLManifestTbnTbxInfoVO.class);
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
	 * Container Discharging List Data를 split하기 위한 리스트<br>
	 * 
	 * @return List<CdlEdiListForSplitVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CdlEdiListForSplitVO> searchCdlEdiListForSplit() throws DAOException {
		DBRowSet dbRowset = null;
		List<CdlEdiListForSplitVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			// query parameter

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CLLCDLManifestDBDAOsearchCdlEdiListForSplitRSQL(),
					param, null, true);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CdlEdiListForSplitVO.class);
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
	 * Container Loading List 데이터 다운로드를 위한 컨테이너 타입, 사이즈별 Count를 구한다.<br>
	 * 
	 * @param TerminalCllVO terminalCllVO
	 * @return List<CLLCDLManifestBkgQtyByCntrtsInfoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CLLCDLManifestBkgQtyByCntrtsInfoVO> searchBkgQtyByCntrts(TerminalCllVO terminalCllVO)
			throws DAOException {
		DBRowSet dbRowset = null;
		List<CLLCDLManifestBkgQtyByCntrtsInfoVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			// query parameter
			if (terminalCllVO != null) {
				Map<String, String> mapVO = terminalCllVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CLLCDLManifestDBDAOsearchBkgQtyByCntrtsRSQL(), param, velParam, true);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CLLCDLManifestBkgQtyByCntrtsInfoVO.class);
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
	 * Container Loading List 데이터 다운로드를 위한 컨테이너 Weight 정보를 구한다.<br>
	 * 
	 * @param TerminalCllVO terminalCllVO
	 * @return String inWGT
	 * @throws DAOException
	 */
	public String searchCntrWgt(TerminalCllVO terminalCllVO) throws DAOException {
		DBRowSet dbRowset = null;
		String inWGT = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			// query parameter
			if (terminalCllVO != null) {
				Map<String, String> mapVO = terminalCllVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CLLCDLManifestDBDAOsearchCntrWgtRSQL(),
					param, velParam, true);
			if (dbRowset.next()) {
				inWGT = dbRowset.getString(1);
			} else {
				inWGT = "";
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return inWGT;
	}

	/**
	 * Container Loading List 데이터 다운로드를 위한 컨테이너 Weight 정보를 구한다.<br>
	 * 
	 * @param TerminalCllVO terminalCllVO
	 * @return List<CLLCDLManifestCllDgByCntrUnInfoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CLLCDLManifestCllDgByCntrUnInfoVO> searchCllDgByCntrUn(TerminalCllVO terminalCllVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CLLCDLManifestCllDgByCntrUnInfoVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			// query parameter
			if (terminalCllVO != null) {
				Map<String, String> mapVO = terminalCllVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CLLCDLManifestDBDAOsearchCllDgByCntrUnRSQL(), param, velParam, true);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CLLCDLManifestCllDgByCntrUnInfoVO.class);
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
	 * Container Loading List(Korea) Remark Data를 조회한다.<br>
	 * 
	 * @param KorCllCondVO korCllCondVO
	 * @return List<CLLCDLManifestKorCllRemarkInfoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CLLCDLManifestKorCllRemarkInfoVO> searchKorCllRemark(KorCllCondVO korCllCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CLLCDLManifestKorCllRemarkInfoVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			// query parameter
			if (korCllCondVO != null) {
				Map<String, String> mapVO = korCllCondVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CLLCDLManifestDBDAOsearchKorCllRemarkRSQL(),
					param, velParam, true);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CLLCDLManifestKorCllRemarkInfoVO.class);
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
	 * Container Loading List(Korea) Data를 조회한다.<br>
	 * 
	 * @param String vvdCd
	 * @param String polCd
	 * @param String localTs
	 * @param String updUsrId
	 * @param String polSplitNo
	 * @return List<CllDetailVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CllDetailVO> searchCllList(String vvdCd, String polCd, String localTs, String updUsrId, String polSplitNo, String cntrVgmOnly, String localType, String tsType)
			throws DAOException {
		DBRowSet dbRowset = null;
		List<CllDetailVO> list = null;

		try {
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("in_vvd_cd", vvdCd);
			param.put("in_pol_cd", polCd);
			param.put("in_local_ts", localTs);
			param.put("in_usr_id", updUsrId);
			param.put("in_pol_split_no", polSplitNo); // Add. 2015.02.09. CHM-201533845
			param.put("cntr_vgm_only", cntrVgmOnly);
			param.put("local_type", localType);
			param.put("ts_type", tsType);
			
			// velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			/*param.put("in_vvd_cd", vvdCd);
			param.put("in_pol_cd", polCd);
			param.put("in_local_ts", localTs);
			param.put("in_usr_id", updUsrId);
			*/ // 2015.02.09.
			velParam.put("in_vvd_cd", vvdCd);
			velParam.put("in_pol_cd", polCd);
			velParam.put("in_local_ts", localTs);
			velParam.put("in_usr_id", updUsrId);
			velParam.put("in_pol_split_no", polSplitNo); // Add. 2015.02.09. CHM-201533845
			velParam.put("cntr_vgm_only", cntrVgmOnly);
			velParam.put("local_type", localType); // Add. 2015.02.09. CHM-201533845
			velParam.put("ts_type", tsType);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CLLCDLManifestDBDAOsearchCllListRSQL(),
					param, velParam, true);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CllDetailVO.class);
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
	 * Container Loading List(Korea) Data를 조회한다.<br>
	 * 
	 * @param String bkgNo
	 * @param String cntrNo
	 * @param String polCd
	 * @param String podCd
	 * @return List<CLLCDLManifestCntrInfoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CLLCDLManifestCntrInfoVO> searchCntrInfo(String bkgNo, String cntrNo, String polCd, String podCd)
			throws DAOException {
		DBRowSet dbRowset = null;
		List<CLLCDLManifestCntrInfoVO> list = null;

		try {
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("bkg_no", bkgNo);
			param.put("cntr_no", cntrNo);
			param.put("pol_cd", polCd);
			param.put("pod_cd", podCd);
			// velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			param.put("bkg_no", bkgNo);
			param.put("cntr_no", cntrNo);
			param.put("pol_cd", polCd);
			param.put("pod_cd", podCd);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CLLCDLManifestDBDAOsearchCntrInfoRSQL(),
					param, velParam, true);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CLLCDLManifestCntrInfoVO.class);
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
	 * Container Loading List - Danger Cargo Data를 조회한다.<br>
	 * 
	 * @param CllSpclCondVO cllSpclCondVO
	 * @return List<CllDgCgoDetailVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CllDgCgoDetailVO> searchCllDgCgo(CllSpclCondVO cllSpclCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CllDgCgoDetailVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			// query parameter
			if (cllSpclCondVO != null) {
				Map<String, String> mapVO = cllSpclCondVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CLLCDLManifestDBDAOsearchCllDgCgoRSQL(),
					param, velParam, true);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CllDgCgoDetailVO.class);
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
	 * Container Loading List - Reefer, Awkward Cargo Data를 조회한다.<br>
	 * 
	 * @param CllSpclCondVO cllSpclCondVO
	 * @return List<CllRfAkCgoDetailVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CllRfAkCgoDetailVO> searchCllRfAkCgo(CllSpclCondVO cllSpclCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CllRfAkCgoDetailVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			// query parameter
			if (cllSpclCondVO != null) {
				Map<String, String> mapVO = cllSpclCondVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CLLCDLManifestDBDAOsearchCllRfAkCgoRSQL(),
					param, velParam, true);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CllRfAkCgoDetailVO.class);
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
	 * Container Discharging List EDI 전송을 위한 Termial Yard Code, EDI Receiver ID, EDI Sender ID를 조회한다.<br>
	 * 
	 * @param String svrCd
	 * @param String inListType
	 * @return List<CLLCDLManifestEdiTerminalInfoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CLLCDLManifestEdiTerminalInfoVO> searchEdiTerminal(String svrCd, String inListType) throws DAOException {
		DBRowSet dbRowset = null;
		List<CLLCDLManifestEdiTerminalInfoVO> list = null;
		try {
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("in_cnt_cd", svrCd);
			param.put("in_list_type", inListType);
			// velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			param.put("in_cnt_cd", svrCd);
			param.put("in_list_type", inListType);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CLLCDLManifestDBDAOsearchEdiTerminalRSQL(),
					param, velParam, true);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CLLCDLManifestEdiTerminalInfoVO.class);
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
	 * Container Loading List 전송 관련 Location Description 정보를 조회한다.<br>
	 * 
	 * @param CllCdlTransmitVO cllCdlTransmitVO
	 * @return String locNm
	 * @throws DAOException
	 */
	public String searchCllLocDesc(CllCdlTransmitVO cllCdlTransmitVO) throws DAOException {
		DBRowSet dbRowset = null;
		String locNm = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			// query parameter
			if (cllCdlTransmitVO != null) {
				Map<String, String> mapVO = cllCdlTransmitVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CLLCDLManifestDBDAOsearchCllLocDescRSQL(),
					param, velParam, true);
			if (dbRowset.next()) {
				locNm = dbRowset.getString(1);
			} else {
				locNm = "";
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return locNm;
	}

	/**
	 * Container Loading List 전송 관련 Vessel 정보를 조회한다.<br>
	 * 
	 * @param CllCdlTransmitVO cllCdlTransmitVO
	 * @return String pseudoVvd
	 * @throws DAOException
	 */
	public String searchCllVslInfo(CllCdlTransmitVO cllCdlTransmitVO) throws DAOException {
		DBRowSet dbRowset = null;
		String pseudoVvd = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			// query parameter
			if (cllCdlTransmitVO != null) {
				Map<String, String> mapVO = cllCdlTransmitVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CLLCDLManifestDBDAOsearchCllVslInfoRSQL(),
					param, velParam, true);
			if (dbRowset.next()) {
				pseudoVvd = dbRowset.getString(1);
			} else {
				pseudoVvd = "";
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return pseudoVvd;
	}

	/**
	 * Container Loading List 전송 관련 PSEUDO VVD 정보를 조회한다.<br>
	 * 
	 * @param CllCdlTransmitVO cllCdlTransmitVO
	 * @return String pseudoVvd
	 * @throws DAOException
	 */
	public String searchCllPseudoVslInfo(CllCdlTransmitVO cllCdlTransmitVO) throws DAOException {
		DBRowSet dbRowset = null;
		String pseudoVvd = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			// query parameter
			if (cllCdlTransmitVO != null) {
				Map<String, String> mapVO = cllCdlTransmitVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CLLCDLManifestDBDAOsearchCllPseudoVslInfoRSQL(), param, velParam, true);
			if (dbRowset.next()) {
				pseudoVvd = dbRowset.getString(1);
			} else {
				pseudoVvd = "";
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return pseudoVvd;
	}

	/**
	 * Container Loading List 전송 관련 Local IPI 정보를 조회한다.<br>
	 * 
	 * @param CllCdlTransmitVO cllCdlTransmitVO
	 * @return String localIpi
	 * @throws DAOException
	 */
	public String searchCllLocalIpi(CllCdlTransmitVO cllCdlTransmitVO) throws DAOException {
		DBRowSet dbRowset = null;
		String localIpi = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			// query parameter
			if (cllCdlTransmitVO != null) {
				Map<String, String> mapVO = cllCdlTransmitVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CLLCDLManifestDBDAOsearchCllLocalIpiRSQL(),
					param, velParam, true);
			if (dbRowset.next()) {
				localIpi = dbRowset.getString(1);
			} else {
				localIpi = "";
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return localIpi;
	}

	/**
	 * Container Loading List 전송 관련 B/L 정보를 조회한다.<br>
	 * 
	 * @param CllCdlTransmitVO cllCdlTransmitVO
	 * @return List<CLLCDLManifestCllBlInfoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CLLCDLManifestCllBlInfoVO> searchCllBl(CllCdlTransmitVO cllCdlTransmitVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CLLCDLManifestCllBlInfoVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			// query parameter
			if (cllCdlTransmitVO != null) {
				Map<String, String> mapVO = cllCdlTransmitVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CLLCDLManifestDBDAOsearchCllBlRSQL(), param,
					velParam, true);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CLLCDLManifestCllBlInfoVO.class);
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
	 * Container Loading List 전송 관련 Container 정보를 조회한다.<br>
	 * 
	 * @param CllCdlTransmitVO cllCdlTransmitVO
	 * @return List<CllCdlCntrInfoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CllCdlCntrInfoVO> searchCllCntr(CllCdlTransmitVO cllCdlTransmitVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CllCdlCntrInfoVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			// query parameter
			if (cllCdlTransmitVO != null) {
				Map<String, String> mapVO = cllCdlTransmitVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CLLCDLManifestDBDAOsearchCllCntrRSQL(),
					param, velParam, true);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CllCdlCntrInfoVO.class);
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
	 * Container Loading List 전송 관련 Danger Container 정보를 조회한다.<br>
	 * 
	 * @param CllCdlCntrInfoVO cllCdlCntrInfoVO
	 * @return List<CLLCDLManifestCllDgCntrInfoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CLLCDLManifestCllDgCntrInfoVO> searchCllDgCntr(CllCdlCntrInfoVO cllCdlCntrInfoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CLLCDLManifestCllDgCntrInfoVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			// query parameter
			if (cllCdlCntrInfoVO != null) {
				Map<String, String> mapVO = cllCdlCntrInfoVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CLLCDLManifestDBDAOsearchCllDgCntrRSQL(),
					param, velParam, true);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CLLCDLManifestCllDgCntrInfoVO.class);
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
	 * Container Loading List 전송 관련 Container Description 정보를 조회한다.<br>
	 * 
	 * @param CllCdlCntrInfoVO cllCdlCntrInfoVO
	 * @return List<CLLCDLManifestCllCntrDescInfoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CLLCDLManifestCllCntrDescInfoVO> searchCllCntrDesc(CllCdlCntrInfoVO cllCdlCntrInfoVO)
			throws DAOException {
		DBRowSet dbRowset = null;
		List<CLLCDLManifestCllCntrDescInfoVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			// query parameter
			if (cllCdlCntrInfoVO != null) {
				Map<String, String> mapVO = cllCdlCntrInfoVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CLLCDLManifestDBDAOsearchCllCntrDescRSQL(),
					param, velParam, true);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CLLCDLManifestCllCntrDescInfoVO.class);
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
	 * Container Loading List 전송 관련 BKG QTY 정보를 조회한다.<br>
	 * 
	 * @param CllCdlCntrInfoVO cllCdlCntrInfoVO
	 * @return List<CLLCDLManifestCllQtyInfoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CLLCDLManifestCllQtyInfoVO> searchCllQty(CllCdlCntrInfoVO cllCdlCntrInfoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CLLCDLManifestCllQtyInfoVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			// query parameter
			if (cllCdlCntrInfoVO != null) {
				Map<String, String> mapVO = cllCdlCntrInfoVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CLLCDLManifestDBDAOsearchCllQtyRSQL(),
					param, velParam, true);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CLLCDLManifestCllQtyInfoVO.class);
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
	 * Container Loading List 전송 관련 BKG VVD 정보를 조회한다.<br>
	 * 
	 * @param CllCdlCntrInfoVO cllCdlCntrInfoVO
	 * @return List<CLLCDLManifestCllBkgVvdInfoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CLLCDLManifestCllBkgVvdInfoVO> searchCllBkgVvd(CllCdlCntrInfoVO cllCdlCntrInfoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CLLCDLManifestCllBkgVvdInfoVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			// query parameter
			if (cllCdlCntrInfoVO != null) {
				Map<String, String> mapVO = cllCdlCntrInfoVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CLLCDLManifestDBDAOsearchCllBkgVvdRSQL(),
					param, velParam, true);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CLLCDLManifestCllBkgVvdInfoVO.class);
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
	 * Container Discharging List 전송 관련 Sender ID 정보를 조회한다.<br>
	 * 
	 * @param CllCdlTransmitVO cllCdlTransmitVO
	 * @return String ediSndId
	 * @throws DAOException
	 */
	public String searchCdlSenderId(CllCdlTransmitVO cllCdlTransmitVO) throws DAOException {
		DBRowSet dbRowset = null;
		String ediSndId = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			// query parameter
			if (cllCdlTransmitVO != null) {
				Map<String, String> mapVO = cllCdlTransmitVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CLLCDLManifestDBDAOsearchCdlSenderIdRSQL(),
					param, velParam, true);
			if (dbRowset.next()) {
				ediSndId = dbRowset.getString(1);
			} else {
				ediSndId = "";
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return ediSndId;
	}

	/**
	 * Container Discharging List 전송 관련 Sender ID(SGC) 정보를 조회한다.<br>
	 * 
	 * @param CllCdlTransmitVO cllCdlTransmitVO
	 * @return String ediSndId
	 * @throws DAOException
	 */
	public String searchCdlSenderIdForSGC(CllCdlTransmitVO cllCdlTransmitVO) throws DAOException {
		DBRowSet dbRowset = null;
		String ediSndId = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			// query parameter
			if (cllCdlTransmitVO != null) {
				Map<String, String> mapVO = cllCdlTransmitVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CLLCDLManifestDBDAOsearchCdlSenderIdForSGCRSQL(), param, velParam, true);
			if (dbRowset.next()) {
				ediSndId = dbRowset.getString(1);
			} else {
				ediSndId = "";
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return ediSndId;
	}

	/**
	 * Container Discharging List 전송 관련 Location 정보를 조회한다.<br>
	 * 
	 * @param CllCdlTransmitVO cllCdlTransmitVO
	 * @return String locNm
	 * @throws DAOException
	 */
	public String searchCdlLocDesc(CllCdlTransmitVO cllCdlTransmitVO) throws DAOException {
		DBRowSet dbRowset = null;
		String locNm = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			// query parameter
			if (cllCdlTransmitVO != null) {
				Map<String, String> mapVO = cllCdlTransmitVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CLLCDLManifestDBDAOsearchCdlLocDescRSQL(),
					param, velParam, true);
			if (dbRowset.next()) {
				locNm = dbRowset.getString(1);
			} else {
				locNm = "";
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return locNm;
	}

	/**
	 * Container Discharging List 전송 관련 Vessel 정보를 조회한다.<br>
	 * 
	 * @param CllCdlTransmitVO cllCdlTransmitVO
	 * @return String pseudoVvd
	 * @throws DAOException
	 */
	public String searchCdlVslInfo(CllCdlTransmitVO cllCdlTransmitVO) throws DAOException {
		DBRowSet dbRowset = null;
		String pseudoVvd = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			// query parameter
			if (cllCdlTransmitVO != null) {
				Map<String, String> mapVO = cllCdlTransmitVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CLLCDLManifestDBDAOsearchCdlVslInfoRSQL(),
					param, velParam, true);
			if (dbRowset.next()) {
				pseudoVvd = dbRowset.getString(1);
			} else {
				pseudoVvd = "";
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return pseudoVvd;
	}

	/**
	 * Container Discharging List 전송 관련 Pseudo Vessel 정보를 조회한다.<br>
	 * 
	 * @param CllCdlTransmitVO cllCdlTransmitVO
	 * @return String pseudoVvd
	 * @throws DAOException
	 */
	public String searchCdlPseudoVslInfo(CllCdlTransmitVO cllCdlTransmitVO) throws DAOException {
		DBRowSet dbRowset = null;
		String pseudoVvd = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			// query parameter
			if (cllCdlTransmitVO != null) {
				Map<String, String> mapVO = cllCdlTransmitVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CLLCDLManifestDBDAOsearchCdlPseudoVslInfoRSQL(), param, velParam, true);
			if (dbRowset.next()) {
				pseudoVvd = dbRowset.getString(1);
			} else {
				pseudoVvd = "";
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return pseudoVvd;
	}

	/**
	 * Container Discharging List 전송 관련 Commodity 정보를 조회한다.<br>
	 * 
	 * @param CllCdlTransmitVO cllCdlTransmitVO
	 * @return String cmdtNm
	 * @throws DAOException
	 */
	public String searchCdlCmdt(CllCdlTransmitVO cllCdlTransmitVO) throws DAOException {
		DBRowSet dbRowset = null;
		String cmdtNm = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			// query parameter
			if (cllCdlTransmitVO != null) {
				Map<String, String> mapVO = cllCdlTransmitVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CLLCDLManifestDBDAOsearchCdlCmdtRSQL(),
					param, velParam, true);
			if (dbRowset.next()) {
				cmdtNm = dbRowset.getString(1);
			} else {
				cmdtNm = "";
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return cmdtNm;
	}

	/**
	 * Container Discharging List 전송 관련 Rep Commodity 정보를 조회한다.<br>
	 * 
	 * @param CllCdlTransmitVO cllCdlTransmitVO
	 * @return String repCmdtNm
	 * @throws DAOException
	 */
	public String searchCdlRepCmdt(CllCdlTransmitVO cllCdlTransmitVO) throws DAOException {
		DBRowSet dbRowset = null;
		String repCmdtNm = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			// query parameter
			if (cllCdlTransmitVO != null) {
				Map<String, String> mapVO = cllCdlTransmitVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CLLCDLManifestDBDAOsearchCdlRepCmdtRSQL(),
					param, velParam, true);
			if (dbRowset.next()) {
				repCmdtNm = dbRowset.getString(1);
			} else {
				repCmdtNm = "";
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return repCmdtNm;
	}

	/**
	 * Container Discharging List 전송 관련 Local IPI (For USA) 정보를 조회한다.<br>
	 * 
	 * @param CllCdlTransmitVO cllCdlTransmitVO
	 * @return String localIpi
	 * @throws DAOException
	 */
	public String searchCdlLocalIpiForUsa(CllCdlTransmitVO cllCdlTransmitVO) throws DAOException {
		DBRowSet dbRowset = null;
		String localIpi = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			// query parameter
			if (cllCdlTransmitVO != null) {
				Map<String, String> mapVO = cllCdlTransmitVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CLLCDLManifestDBDAOsearchCdlLocalIpiForUsaRSQL(), param, velParam, true);
			if (dbRowset.next()) {
				localIpi = dbRowset.getString(1);
			} else {
				localIpi = "";
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return localIpi;
	}

	/**
	 * Container Discharging List 전송 관련 Local IPI 정보를 조회한다.<br>
	 * 
	 * @param CllCdlTransmitVO cllCdlTransmitVO
	 * @return String localIpi
	 * @throws DAOException
	 */
	public String searchCdlLocalIpi(CllCdlTransmitVO cllCdlTransmitVO) throws DAOException {
		DBRowSet dbRowset = null;
		String localIpi = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			// query parameter
			if (cllCdlTransmitVO != null) {
				Map<String, String> mapVO = cllCdlTransmitVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CLLCDLManifestDBDAOsearchCdlLocalIpiRSQL(),
					param, velParam, true);
			if (dbRowset.next()) {
				localIpi = dbRowset.getString(1);
			} else {
				localIpi = "";
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return localIpi;
	}

	/**
	 * Container Discharging List 전송 정보를 조회한다.<br>
	 * 
	 * @param CllCdlTransmitVO cllCdlTransmitVO
	 * @return String custrefNum
	 * @throws DAOException
	 */
	public String searchCdlTransmitHist(CllCdlTransmitVO cllCdlTransmitVO) throws DAOException {
		DBRowSet dbRowset = null;
		String custrefNum = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			// query parameter
			if (cllCdlTransmitVO != null) {
				Map<String, String> mapVO = cllCdlTransmitVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CLLCDLManifestDBDAOsearchCdlTransmitHistRSQL(), param, velParam, true);
			if (dbRowset.next()) {
				custrefNum = dbRowset.getString(1);
			} else {
				custrefNum = "";
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return custrefNum;
	}

	/**
	 * Container Discharging List 전송 정보를 조회한다.<br>
	 * 
	 * @param CllCdlTransmitVO cllCdlTransmitVO
	 * @return String vslPrePstCd
	 * @throws DAOException
	 */
	public String searchCdlCurBvInd(CllCdlTransmitVO cllCdlTransmitVO) throws DAOException {
		DBRowSet dbRowset = null;
		String vslPrePstCd = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			// query parameter
			if (cllCdlTransmitVO != null) {
				Map<String, String> mapVO = cllCdlTransmitVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CLLCDLManifestDBDAOsearchCdlCurBvIndRSQL(),
					param, velParam, true);
			if (dbRowset.next()) {
				vslPrePstCd = dbRowset.getString(1);
			} else {
				vslPrePstCd = "";
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return vslPrePstCd;
	}

	/**
	 * Container Discharging List 전송 관련 Transmode 정보를 조회한다.<br>
	 * 
	 * @param CllCdlTransmitVO cllCdlTransmitVO
	 * @return String transMode
	 * @throws DAOException
	 */
	public String searchCdlTransmode(CllCdlTransmitVO cllCdlTransmitVO) throws DAOException {
		DBRowSet dbRowset = null;
		String transMode = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			// query parameter
			if (cllCdlTransmitVO != null) {
				Map<String, String> mapVO = cllCdlTransmitVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CLLCDLManifestDBDAOsearchCdlTransmodeRSQL(),
					param, velParam, true);
			if (dbRowset.next()) {
				transMode = dbRowset.getString(1);
			} else {
				transMode = "";
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return transMode;
	}

	/**
	 * Container Discharging List 전송 관련 Transmode 정보를 조회한다.<br>
	 * 
	 * @param CllCdlTransmitVO cllCdlTransmitVO
	 * @return String ibdTrspNo
	 * @throws DAOException
	 */
	public String searchCdlTrspNo(CllCdlTransmitVO cllCdlTransmitVO) throws DAOException {
		DBRowSet dbRowset = null;
		String ibdTrspNo = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			// query parameter
			if (cllCdlTransmitVO != null) {
				Map<String, String> mapVO = cllCdlTransmitVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CLLCDLManifestDBDAOsearchCdlTrspNoRSQL(),
					param, velParam, true);
			if (dbRowset.next()) {
				ibdTrspNo = dbRowset.getString(1);
			} else {
				ibdTrspNo = "";
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return ibdTrspNo;
	}

	/**
	 * Container Discharging List 전송 관련 B/L 정보를 조회한다.<br>
	 * 
	 * @param CllCdlTransmitVO cllCdlTransmitVO
	 * @return List<CLLCDLManifestCdlBlInfoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CLLCDLManifestCdlBlInfoVO> searchCdlBl(CllCdlTransmitVO cllCdlTransmitVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CLLCDLManifestCdlBlInfoVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			// query parameter
			if (cllCdlTransmitVO != null) {
				Map<String, String> mapVO = cllCdlTransmitVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CLLCDLManifestDBDAOsearchCdlBlRSQL(), param,
					velParam, true);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CLLCDLManifestCdlBlInfoVO.class);
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
	 * Container Discharging List 전송 관련 Customer 정보를 조회한다.<br>
	 * 
	 * @param CllCdlTransmitVO cllCdlTransmitVO
	 * @return String custInfo
	 * @throws DAOException
	 */
	public String searchCdlCust(CllCdlTransmitVO cllCdlTransmitVO) throws DAOException {
		DBRowSet dbRowset = null;
		String custInfo = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			// query parameter
			if (cllCdlTransmitVO != null) {
				Map<String, String> mapVO = cllCdlTransmitVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CLLCDLManifestDBDAOsearchCdlCustRSQL(),
					param, velParam, true);
			if (dbRowset.next()) {
				custInfo = dbRowset.getString(1);
			} else {
				custInfo = "";
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return custInfo;
	}

	/**
	 * Container Discharging List 전송 관련 Charge 정보를 조회한다.<br>
	 * 
	 * @param CllCdlTransmitVO cllCdlTransmitVO
	 * @return List<CLLCDLManifestCdlChargeInfoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CLLCDLManifestCdlChargeInfoVO> searchCdlCharge(CllCdlTransmitVO cllCdlTransmitVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CLLCDLManifestCdlChargeInfoVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			// query parameter
			if (cllCdlTransmitVO != null) {
				Map<String, String> mapVO = cllCdlTransmitVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CLLCDLManifestDBDAOsearchCdlChargeRSQL(),
					param, velParam, true);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CLLCDLManifestCdlChargeInfoVO.class);
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
	 * Container Discharging List 전송 관련 Charge Total 정보를 조회한다.<br>
	 * 
	 * @param CllCdlTransmitVO cllCdlTransmitVO
	 * @return List<CLLCDLManifestCdlChargeTotalInfoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CLLCDLManifestCdlChargeTotalInfoVO> searchCdlChargeTotal(CllCdlTransmitVO cllCdlTransmitVO)
			throws DAOException {
		DBRowSet dbRowset = null;
		List<CLLCDLManifestCdlChargeTotalInfoVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			// query parameter
			if (cllCdlTransmitVO != null) {
				Map<String, String> mapVO = cllCdlTransmitVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CLLCDLManifestDBDAOsearchCdlChargeTotalRSQL(), param, velParam, true);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CLLCDLManifestCdlChargeTotalInfoVO.class);
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
	 * Container Discharging List 전송 관련 Mark & Description 정보를 조회한다.<br>
	 * 
	 * @param CllCdlTransmitVO cllCdlTransmitVO
	 * @return List<CLLCDLManifestCdlMkDescInfoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CLLCDLManifestCdlMkDescInfoVO> searchCdlMkDesc(CllCdlTransmitVO cllCdlTransmitVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CLLCDLManifestCdlMkDescInfoVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			// query parameter
			if (cllCdlTransmitVO != null) {
				Map<String, String> mapVO = cllCdlTransmitVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CLLCDLManifestDBDAOsearchCdlMkDescRSQL(),
					param, velParam, true);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CLLCDLManifestCdlMkDescInfoVO.class);
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
	 * Container Discharging List 전송 관련 Container 정보를 조회한다.<br>
	 * 
	 * @param CllCdlTransmitVO cllCdlTransmitVO
	 * @return List<CLLCDLManifestCdlCstmsDescInfoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CLLCDLManifestCdlCstmsDescInfoVO> searchCdlCstmsDesc(CllCdlTransmitVO cllCdlTransmitVO)
			throws DAOException {
		DBRowSet dbRowset = null;
		List<CLLCDLManifestCdlCstmsDescInfoVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			// query parameter
			if (cllCdlTransmitVO != null) {
				Map<String, String> mapVO = cllCdlTransmitVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CLLCDLManifestDBDAOsearchCdlCstmsDescRSQL(),
					param, velParam, true);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CLLCDLManifestCdlCstmsDescInfoVO.class);
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
	 * Container Discharging List 전송 관련 Container 정보를 조회한다.<br>
	 * 
	 * @param CllCdlTransmitVO cllCdlTransmitVO
	 * @return List<CllCdlCntrInfoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CllCdlCntrInfoVO> searchCdlCntr(CllCdlTransmitVO cllCdlTransmitVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CllCdlCntrInfoVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			// query parameter
			if (cllCdlTransmitVO != null) {
				Map<String, String> mapVO = cllCdlTransmitVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CLLCDLManifestDBDAOsearchCdlCntrRSQL(),
					param, velParam, true);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CllCdlCntrInfoVO.class);
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
	 * Container Discharging List 전송 관련 Danger Container 정보를 조회한다.<br>
	 * 
	 * @param CllCdlCntrInfoVO cllCdlCntrInfoVO
	 * @return List<CLLCDLManifestCdlDgCntrInfoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CLLCDLManifestCdlDgCntrInfoVO> searchCdlDgCntr(CllCdlCntrInfoVO cllCdlCntrInfoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CLLCDLManifestCdlDgCntrInfoVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			// query parameter
			if (cllCdlCntrInfoVO != null) {
				Map<String, String> mapVO = cllCdlCntrInfoVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CLLCDLManifestDBDAOsearchCdlDgCntrRSQL(),
					param, velParam, true);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CLLCDLManifestCdlDgCntrInfoVO.class);
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
	 * Container Discharging List 전송 관련 Container Description(For USA) 정보를 조회한다.<br>
	 * 
	 * @param CllCdlCntrInfoVO cllCdlCntrInfoVO
	 * @return List<CLLCDLManifestCdlCntrDescInfoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CLLCDLManifestCdlCntrDescInfoVO> searchCdlCntrDescForUsa(CllCdlCntrInfoVO cllCdlCntrInfoVO)
			throws DAOException {
		DBRowSet dbRowset = null;
		List<CLLCDLManifestCdlCntrDescInfoVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			// query parameter
			if (cllCdlCntrInfoVO != null) {
				Map<String, String> mapVO = cllCdlCntrInfoVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CLLCDLManifestDBDAOsearchCdlCntrDescForUsaRSQL(), param, velParam, true);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CLLCDLManifestCdlCntrDescInfoVO.class);
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
	 * Container Discharging List 전송 관련 Container Description 정보를 조회한다.<br>
	 * 
	 * @param CllCdlCntrInfoVO cllCdlCntrInfoVO
	 * @return List<CLLCDLManifestCdlCntrDescInfoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CLLCDLManifestCdlCntrDescInfoVO> searchCdlCntrDesc(CllCdlCntrInfoVO cllCdlCntrInfoVO)
			throws DAOException {
		DBRowSet dbRowset = null;
		List<CLLCDLManifestCdlCntrDescInfoVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			// query parameter
			if (cllCdlCntrInfoVO != null) {
				Map<String, String> mapVO = cllCdlCntrInfoVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CLLCDLManifestDBDAOsearchCdlCntrDescRSQL(),
					param, velParam, true);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CLLCDLManifestCdlCntrDescInfoVO.class);
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
	 * Container Discharging List 전송 관련 BKG QTY 정보를 조회한다.<br>
	 * 
	 * @param CllCdlTransmitVO cllCdlTransmitVO
	 * @return List<CLLCDLManifestCdlQtyInfoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CLLCDLManifestCdlQtyInfoVO> searchCdlQty(CllCdlTransmitVO cllCdlTransmitVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CLLCDLManifestCdlQtyInfoVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			// query parameter
			if (cllCdlTransmitVO != null) {
				Map<String, String> mapVO = cllCdlTransmitVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CLLCDLManifestDBDAOsearchCdlQtyRSQL(),
					param, velParam, true);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CLLCDLManifestCdlQtyInfoVO.class);
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
	 * Container Discharging List 전송 관련 BKG VVD 정보를 조회한다.<br>
	 * 
	 * @param CllCdlTransmitVO cllCdlTransmitVO
	 * @return List<CLLCDLManifestCdlBkgVvdInfoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CLLCDLManifestCdlBkgVvdInfoVO> searchCdlBkgVvd(CllCdlTransmitVO cllCdlTransmitVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CLLCDLManifestCdlBkgVvdInfoVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			// query parameter
			if (cllCdlTransmitVO != null) {
				Map<String, String> mapVO = cllCdlTransmitVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CLLCDLManifestDBDAOsearchCdlBkgVvdRSQL(),
					param, velParam, true);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CLLCDLManifestCdlBkgVvdInfoVO.class);
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
	 * Container Discharging List 정보를 조회한다.<br>
	 * 
	 * @param CdlCondVO cdlCondVO
	 * @return List<CdlDetailVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CdlDetailVO> searchCdlList(CdlCondVO cdlCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CdlDetailVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			// query parameter
			if (cdlCondVO != null) {
				Map<String, String> mapVO = cdlCondVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CLLCDLManifestDBDAOsearchCdlListRSQL(),
					param, velParam, true);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CdlDetailVO.class);
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
	 * CLL, CDL 테이블에 저장되어 있는 데이터와 비교할 NIS 데이터를 조회한다.<br>
	 * 
	 * @param CllCdlCheckCondVO cllCdlCheckCondVO
	 * @return List<CllCdlCheckListDetailVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CllCdlCheckListDetailVO> searchCllCdlCheckList(CllCdlCheckCondVO cllCdlCheckCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CllCdlCheckListDetailVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			// query parameter
			if (cllCdlCheckCondVO != null) {
				Map<String, String> mapVO = cllCdlCheckCondVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CLLCDLManifestDBDAOsearchCllCdlCheckListRSQL(), param, velParam, true);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CllCdlCheckListDetailVO.class);
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
	 * CLL 수신처리시 VSL_CD 찾기<br>
	 * 
	 * @param String searchGubun
	 * @param String keyword
	 * @return String
	 * @throws DAOException
	 */
	public String searchVslCdForReceive(String searchGubun, String keyword) throws DAOException {
		DBRowSet dbRowset = null;
		String vslCd = null;

		try {
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("search_gubun", searchGubun);
			param.put("keyword", keyword);
			// velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			param.put("search_gubun", searchGubun);
			param.put("keyword", keyword);

			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CLLCDLManifestDBDAOsearchVslCdForReceiveRSQL(), param, velParam, true);
			if (dbRowset.next()) {
				vslCd = dbRowset.getString(1);
			} else {
				vslCd = "";
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return vslCd;
	}

	/**
	 * CLL 수신처리시 VVD_CD 찾기<br>
	 * 
	 * @param String inVvdcll
	 * @param String inVvd
	 * @return List<CLLCDLManifestSearchVvdCdForRecieveInfoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CLLCDLManifestSearchVvdCdForRecieveInfoVO> searchVvdCdForRecieve(String inVvdcll, String inVvd)
			throws DAOException {
		DBRowSet dbRowset = null;
		List<CLLCDLManifestSearchVvdCdForRecieveInfoVO> list = null;

		try {
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("in_vvdcll", inVvdcll);
			param.put("in_vvd", inVvd);
			// velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			param.put("in_vvdcll", inVvdcll);
			param.put("in_vvd", inVvd);

			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CLLCDLManifestDBDAOSearchVvdCdForRecieveRSQL(), param, velParam, true);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CLLCDLManifestSearchVvdCdForRecieveInfoVO.class);
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
	 * CLL 수신처리시 Data 존재여부 Search<br>
	 * 
	 * @param String inVslcd
	 * @param String inVslvoy
	 * @param String inVsldir
	 * @param String inCntr
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int searchDataExist(String inVslcd, String inVslvoy, String inVsldir, String inCntr) throws DAOException {
		DBRowSet dbRowset = null;
		int dataCount = 0;

		try {
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("in_vslcd", inVslcd);
			param.put("in_vslvoy", inVslvoy);
			param.put("in_vsldir", inVsldir);
			param.put("in_cntr", inCntr);
			// param.put("bkg_no_split", bkgNoSplit);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CLLCDLManifestDBDAOsearchDataExistRSQL(),
					param, null, true);
			if (dbRowset.next()) {
				dataCount = dbRowset.getInt(1);
			} else {
				dataCount = 0;
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dataCount;
	}

	/**
	 * CLL 수신처리시 Data 존재여부 Search2<br>
	 * 
	 * @param String inVslcd
	 * @param String inVslvoy
	 * @param String inVsldir
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int searchDataExist2(String inVslcd, String inVslvoy, String inVsldir) throws DAOException {
		DBRowSet dbRowset = null;
		int dataCount = 0;

		try {
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("in_vslcd", inVslcd);
			param.put("in_vslvoy", inVslvoy);
			param.put("in_vsldir", inVsldir);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CLLCDLManifestDBDAOsearchDataExist2RSQL(),
					param, null, true);
			if (dbRowset.next()) {
				dataCount = dbRowset.getInt(1);
			} else {
				dataCount = 0;
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dataCount;
	}

	/**
	 * CLL 수신처리시 Data 존재여부 Search3<br>
	 * 
	 * @param String inVslcd
	 * @param String inVslvoy
	 * @param String inVsldir
	 * @param String inCntr
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int searchDataExist3(String inVslcd, String inVslvoy, String inVsldir, String inCntr) throws DAOException {
		DBRowSet dbRowset = null;
		int dataCount = 0;

		try {
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("in_vslcd", inVslcd);
			param.put("in_vslvoy", inVslvoy);
			param.put("in_vsldir", inVsldir);
			param.put("in_cntr", inCntr);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CLLCDLManifestDBDAOsearchDataExist3RSQL(),
					param, null, true);
			if (dbRowset.next()) {
				dataCount = dbRowset.getInt(1);
			} else {
				dataCount = 0;
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dataCount;
	}

	/**
	 * Container Loading List(Korea) 관련 터미널 Vessel Code를 조회한다.<br>
	 * 
	 * @param String tmlCd
	 * @return String LocalTime
	 * @throws DAOException
	 * @throws Exception
	 */
	public String searchLocalTime(String tmlCd) throws DAOException {
		DBRowSet dbRowset = null;
		String localTime = null;

		try {
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("tml_cd", tmlCd);
			// param.put("bkg_no_split", bkgNoSplit);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CLLCDLManifestDBDAOsearchLocalTimeRSQL(),
					param, null, true);
			if (dbRowset.next()) {
				localTime = dbRowset.getString(1);
			} else {
				localTime = "";
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return localTime;
	}
	
	/**
	 * Container Loading List(Korea) 관련 터미널 Vessel Code를 조회한다.<br>
	 * 
	 * @param String bkgNo
	 * @return String rfTemp
	 * @throws DAOException
	 * @throws Exception
	 */
	public String searchCntrExportRfTemp(String bkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		String rfTemp = "Y";

		try {
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("bkg_no", bkgNo);
			// param.put("bkg_no_split", bkgNoSplit);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CLLCDLManifestDBDAOsearchCntrExportRfTempRSQL(),
					param, null, true);
			if (dbRowset.next()) {
				rfTemp = dbRowset.getString(1);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rfTemp;
	}	
	
	/**
	 * Terminal EDI 를 한번에 전송하기 위해 VVD의 동일 POD 에 대한 모든 BKG_NO, CNTR_NO 를 구한다.<br>
	 * 
	 * @param String inVslcd
	 * @param String inSkdVoyNo
	 * @param String inSkdDirCd
	 * @param String inPolCd
	 * @param String inPodCd
	 * @param String inBkgCgoTpCd
	 * @return List<CllCdlTransmitVO>
	 * @throws DAOException
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<CllCdlTransmitVO> searchDownloadContainerList(String inVslCd, String inSkdVoyNo, String inSkdDirCd, String inPolCd, String inPodCd, String inBkgCgoTpCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<CllCdlTransmitVO> list = null;

		try {
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("vsl_cd", inVslCd);
			param.put("skd_voy_no", inSkdVoyNo);
			param.put("skd_dir_cd", inSkdDirCd);
			param.put("pol_cd", inPolCd);
			param.put("pod_cd", inPodCd);
			param.put("bkg_no", "");
			param.put("bkg_cgo_tp_cd", inBkgCgoTpCd);
			
			// query parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			velParam.put("vsl_cd", inVslCd);
			velParam.put("skd_voy_no", inSkdVoyNo);
			velParam.put("skd_dir_cd", inSkdDirCd);
			velParam.put("pol_cd", inPolCd);
			velParam.put("pod_cd", inPodCd);
			velParam.put("bkg_no", "");
			velParam.put("bkg_cgo_tp_cd", inBkgCgoTpCd);			

			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new UsaManifestListDownloadDBDAOsearchDownloadContainerListRSQL(), param, velParam, true);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CllCdlTransmitVO.class);
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
	 * Booking 메인에서 Import 전송을 위한 조회<br>
	 * 
	 * @param String bkgNo
	 * @return List<CntrListForImportDetailVO>
	 * @throws DAOException
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<CntrListForImportDetailVO> searchCntrListForImport(String bkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<CntrListForImportDetailVO> list = null;

		try {
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("bkg_no", bkgNo);
			// param.put("bkg_no_split", bkgNoSplit);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CLLCDLManifestDBDAOsearchCntrListForImportRSQL(),
					param, null, true);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CntrListForImportDetailVO.class);
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
	 * Container Loading List(Korea) Data를 생성한다.<br>
	 * 
	 * @param KorCllModifyVO korCllModifyVO
	 * @return int result
	 * @throws DAOException
	 * @throws Exception
	 */
	public int addKorCll(KorCllModifyVO korCllModifyVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = korCllModifyVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new CLLCDLManifestDBDAOaddKorCllCSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");
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
	 * Container Loading List(Korea) 관련 터미널 Vessel Code를 생성한다.<br>
	 * 
	 * @param String inVslCd
	 * @param String inKtmlCd
	 * @param String creUsrID
	 * @return int result
	 * @throws DAOException
	 * @throws Exception
	 */
	public int addTmnlVslCd(String inVslCd, String inKtmlCd, String creUsrID) throws DAOException, Exception {

		int result = 0;
		try {
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("in_vsl_cd", inVslCd);
			param.put("in_ktml_cd", inKtmlCd);
			param.put("cre_usr_id", creUsrID);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new CLLCDLManifestDBDAOaddTmnlVslCdCSQL(), param, null, true);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");
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
	 * Container Loading List 전송을 위한 Data를 CLL 테이블로 Download 한다.<br>
	 * 
	 * @param TerminalCllVO terminalCllVO
	 * @return int result
	 * @throws DAOException
	 * @throws Exception
	 */
	public int addCllMainForDownload(TerminalCllVO terminalCllVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = terminalCllVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new CLLCDLManifestDBDAOaddCllMainForDownloadCSQL(), param,
					velParam, true);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");
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
	 * Container Loading List 전송을 위한 DG Cargo Data를 CLL 테이블로 Download 한다.<br>
	 * 
	 * @param BkgCstmsTmlCllDgCgoVO bkgCstmsTmlCllDgCgoVO
	 * @return int result
	 * @throws DAOException
	 * @throws Exception
	 */
	public int addCllDgForDownload(BkgCstmsTmlCllDgCgoVO bkgCstmsTmlCllDgCgoVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = bkgCstmsTmlCllDgCgoVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new CLLCDLManifestDBDAOaddCllDgForDownloadCSQL(), param,
					velParam, true);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");
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
	 * Container Loading List(Korea) Remark Data를 생성한다.<br>
	 * 
	 * @param KorCllRemarkVO korCllRemarkVO
	 * @return void
	 * @throws DAOException
	 * @throws Exception
	 */
	public int addKorCllRemark(KorCllRemarkVO korCllRemarkVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = korCllRemarkVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new CLLCDLManifestDBDAOaddKorCllRemarkCSQL(), param, velParam,
					true);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");
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
	 * Container Loading List Data를 생성한다.<br>
	 * 
	 * @param BkgCstmsTmlCllVO bkgCstmsTmlCllVO
	 * @return void
	 * @throws DAOException
	 * @throws Exception
	 */
	public int addCll(BkgCstmsTmlCllVO bkgCstmsTmlCllVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = bkgCstmsTmlCllVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new CLLCDLManifestDBDAOaddCllCSQL(), param, velParam, true);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");
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
	 * Container Loading List - Danger Cargo Data를 생성한다.<br>
	 * 
	 * @param BkgCstmsTmlCllDgCgoVO bkgCstmsTmlCllDgCgoVO
	 * @return void
	 * @throws DAOException
	 * @throws Exception
	 */
	public int addCllDgCgo(BkgCstmsTmlCllDgCgoVO bkgCstmsTmlCllDgCgoVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = bkgCstmsTmlCllDgCgoVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new CLLCDLManifestDBDAOaddCllDgCgoCSQL(), param, velParam,
					true);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");
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
	 * CLL 수신처리시 Terminal Cll 등록<br>
	 * 
	 * @param BkgCstmsTmlCllVO bkgCstmsTmlCllVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int addTmlCllForRecieve(BkgCstmsTmlCllVO bkgCstmsTmlCllVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = bkgCstmsTmlCllVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new CLLCDLManifestDBDAOaddTmlCllForRecieveCSQL(), param,
					velParam, true);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");
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
	 * CLL 수신처리시 Terminal Eur 등록<br>
	 * 
	 * @param BkgCstmsTmlEurVO bkgCstmsTmlEurVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int addTmlEurForRecieve(BkgCstmsTmlEurVO bkgCstmsTmlEurVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = bkgCstmsTmlEurVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new CLLCDLManifestDBDAOaddTmlEurForRecieveCSQL(), param,
					velParam, true);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");
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
	 * CLL 수신처리시 Terminal Eur 등록<br>
	 * 
	 * @param bkgCstmsCdConvCtntVOs bkgCstmsCdConvCtntVOs
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int addCdConvCtnt(List<BkgCstmsCdConvCtntVO> bkgCstmsCdConvCtntVOs) throws DAOException, Exception {
		int result = 0;
		try {
			Map<String, Object> velParam = new HashMap<String, Object>();
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (bkgCstmsCdConvCtntVOs.size() > 0)
			{
				Map<String, String> mapVO = bkgCstmsCdConvCtntVOs.get(0).getColumnValues();
				velParam.putAll(mapVO);
				updCnt = sqlExe.executeBatch((ISQLTemplate) new CLLCDLManifestDBDAOaddCdConvCtntCSQL(),
						bkgCstmsCdConvCtntVOs, velParam);
				for (int i = 0; i < updCnt.length; i++)
				{
					if (updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}
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
	 * Container Loading List(Korea) 관련 터미널 Vessel Code를 수정한다.<br>
	 * 
	 * @param String inVslCd
	 * @param String inKtmlCd
	 * @param String updUsrID
	 * @return int result
	 * @throws DAOException
	 * @throws Exception
	 */
	public int modifyTmnlVslCd(String inVslCd, String inKtmlCd, String updUsrID) throws DAOException, Exception {

		int result = 0;
		try {
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("in_vsl_cd", inVslCd);
			param.put("in_ktml_cd", inKtmlCd);
			param.put("upd_usr_id", updUsrID);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new CLLCDLManifestDBDAOmodifyTmnlVslCdUSQL(), param, null,
					true);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");
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
	 * Container Loading List(Korea) 전송 후 CLL Update Date를 업데이트 한다.<br>
	 * 
	 * @param String inVslCd
	 * @param String inSkdVoyNo
	 * @param String inSkdDirCd
	 * @param String inPolCd
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int modifyUpdateDt(String inVslCd, String inSkdVoyNo, String inSkdDirCd, String inPolCd)
			throws DAOException, Exception {

		int result = 0;
		try {
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("in_vsl_cd", inVslCd);
			param.put("in_skd_voy_no", inSkdVoyNo);
			param.put("in_skd_dir_cd", inSkdDirCd);
			param.put("in_pol_cd", inPolCd);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe
					.executeUpdate((ISQLTemplate) new CLLCDLManifestDBDAOmodifyUpdateDtUSQL(), param, null, true);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");
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
	 * Container Loading List(Korea) Remark Data를 수정한다.<br>
	 * 
	 * @param KorCllRemarkVO korCllRemarkVO
	 * @return int result
	 * @throws DAOException
	 * @throws Exception
	 */
	public int modifyKorCllRemark(KorCllRemarkVO korCllRemarkVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = korCllRemarkVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new CLLCDLManifestDBDAOmodifyKorCllRemarkUSQL(), param,
					velParam, true);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");
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
	 * Container Loading List Data를 업데이트 한다.<br>
	 * 
	 * @param CllDetailVO cllDetailVO
	 * @return int result
	 * @throws DAOException
	 * @throws Exception
	 */
	public int modifyCll(CllDetailVO cllDetailVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = cllDetailVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new CLLCDLManifestDBDAOmodifyCllUSQL(), param, velParam, true);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");
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
	 * Container Loading List - Reefer, Awkward Cargo Data를 업데이트 한다.<br>
	 * 
	 * @param CllRfAkCgoDetailVO cllRfAkCgoDetailVO
	 * @return int result
	 * @throws DAOException
	 * @throws Exception
	 */
	public int modifyCllRfAkCgo(CllRfAkCgoDetailVO cllRfAkCgoDetailVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = cllRfAkCgoDetailVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new CLLCDLManifestDBDAOmodifyCllRfAkCgoUSQL(), param,
					velParam, true);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");
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
	 * Container Discharging List 전송 관련 전송 정보를 저장한다.<br>
	 * 
	 * @param CllCdlTransmitVO cllCdlTransmitVO
	 * @return int result
	 * @throws DAOException
	 * @throws Exception
	 */
	public int modifyTmnlCllSendLog(CllCdlTransmitVO cllCdlTransmitVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = cllCdlTransmitVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new CLLCDLManifestDBDAOmodifyTmnlCllSendLogUSQL(), param,
					velParam, true);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");
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
	 * Container Loading List(Korea) 전송 후 CLL Update Date를 업데이트 한다.<br>
	 * 
	 * @param String inVslcd
	 * @param String inVslvoy
	 * @param String inVsldir
	 * @param String inCntr
	 * @param String updUsrId
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int modifyCllForRecieve(String inVslcd, String inVslvoy, String inVsldir, String inCntr, String updUsrId)
			throws DAOException, Exception {

		int result = 0;
		try {
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("in_vslcd", inVslcd);
			param.put("in_vslvoy", inVslvoy);
			param.put("in_vsldir", inVsldir);
			param.put("in_cntr", inCntr);
			param.put("upd_usr_id", updUsrId);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new CLLCDLManifestDBDAOmodifyCllForRecieveUSQL(), param, null,
					true);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");
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
	 * Container Discharging List 전송 관련 전송 정보를 저장한다.<br>
	 * 
	 * @param bkgCstmsCdConvCtntVOs bkgCstmsCdConvCtntVOs
	 * @return int result
	 * @throws DAOException
	 * @throws Exception
	 */
	public int modifyCdConvCtnt(List<BkgCstmsCdConvCtntVO> bkgCstmsCdConvCtntVOs) throws DAOException, Exception {
		int result = 0;
		try {
			Map<String, Object> velParam = new HashMap<String, Object>();
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (bkgCstmsCdConvCtntVOs.size() > 0)
			{
				Map<String, String> mapVO = bkgCstmsCdConvCtntVOs.get(0).getColumnValues();
				velParam.putAll(mapVO);
				updCnt = sqlExe.executeBatch((ISQLTemplate) new CLLCDLManifestDBDAOmodifyCdConvCtntUSQL(),
						bkgCstmsCdConvCtntVOs, velParam);
				for (int i = 0; i < updCnt.length; i++)
				{
					if (updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}
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
	 * Container Loading List(Korea) Data를 삭제한다.<br>
	 * 
	 * @param String inVslCd
	 * @param String inSkdVoyNo
	 * @param String inSkdDirCd
	 * @param String inPolCd
	 * @param String inPolYdCd
	 * @param String inCllType
	 * @return int result
	 * @throws DAOException
	 * @throws Exception
	 */
	public int removeKorCll(String inVslCd, String inSkdVoyNo, String inSkdDirCd, String inPolCd, String inPolYdCd,
			String inCllType) throws DAOException, Exception {
		int result = 0;
		try {
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("in_vsl_cd", inVslCd);
			param.put("in_skd_voy_no", inSkdVoyNo);
			param.put("in_skd_dir_cd", inSkdDirCd);
			param.put("in_pol_cd", inPolCd);
			param.put("in_pol_yd_cd", inPolYdCd);
			param.put("in_cll_type", inCllType);

			Map<String, Object> velParam = new HashMap<String, Object>();
			velParam.put("in_vsl_cd", inVslCd);
			velParam.put("in_skd_voy_no", inSkdVoyNo);
			velParam.put("in_skd_dir_cd", inSkdDirCd);
			velParam.put("in_pol_cd", inPolCd);
			velParam.put("in_pol_yd_cd", inPolYdCd);
			velParam.put("in_cll_type", inCllType);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new CLLCDLManifestDBDAOremoveKorCllDSQL(), param, velParam,
					true);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to delete SQL");
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
	 * Container Loading List 데이터 다운로드 수행 전에 기존에 저장되어 있던 CLL Danger Cargo 데이터를 삭제한다.<br>
	 * 
	 * @param TerminalCllVO terminalCllVO
	 * @throws DAOException
	 */
	public void removeCllDgForDownload(TerminalCllVO terminalCllVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try {
			Map<String, String> mapVO = terminalCllVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new CLLCDLManifestDBDAOremoveCllDgForDownloadDSQL(), param,
					velParam, true);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to delete SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Container Loading List 데이터 다운로드 수행 전에 기존에 저장되어 있던 CLL Main 데이터를 삭제한다.<br>
	 * 
	 * @param TerminalCllVO terminalCllVO
	 * @throws DAOException
	 */
	public void removeCllMainForDownload(TerminalCllVO terminalCllVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try {
			Map<String, String> mapVO = terminalCllVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new CLLCDLManifestDBDAOremoveCllMainForDownloadDSQL(), param,
					velParam, true);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to delete SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Container Loading List Data(Danger Cargo)를 삭제한다.<br>
	 * 
	 * @param String vvdCd
	 * @param String portCd
	 * @param String bkgNo
	 * @param String cntrNo
	 * @param String usrId
	 * @param String inPolSplitNo
	 * @throws DAOException
	 */
	public void removeCllDg(String vvdCd, String portCd, String bkgNo, String cntrNo, String usrId, String inPolSplitNo)
			throws DAOException, Exception {
		int result = 0;
		try {
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("in_vvd_cd", vvdCd);
			param.put("in_pol_cd", portCd);
			param.put("bkg_no", bkgNo);
			param.put("cntr_no", cntrNo);
			param.put("upd_usr_id", usrId);
			param.put("in_pol_split_no", inPolSplitNo);

			Map<String, Object> velParam = new HashMap<String, Object>();
			velParam.put("in_vvd_cd", vvdCd);
			velParam.put("in_pol_cd", portCd);
			velParam.put("bkg_no", bkgNo);
			velParam.put("cntr_no", cntrNo);
			velParam.put("upd_usr_id", usrId);
			
			velParam.put("in_pol_split_no", inPolSplitNo);  // Add. 2015.02.09

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new CLLCDLManifestDBDAOremoveCllDgDSQL(), param, velParam,
					true);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to delete SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Container Loading List Data를 삭제한다.<br>
	 * 
	 * @param String vvdCd
	 * @param String portCd
	 * @param String bkgNo
	 * @param String cntrNo
	 * @param String usrId
	 * @param String inPolSplitNo
	 * @throws DAOException
	 */
	public void removeCllMain(String vvdCd, String portCd, String bkgNo, String cntrNo, String usrId, String inPolSplitNo)
			throws DAOException, Exception {
		int result = 0;
		try {
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("in_vvd_cd", vvdCd);
			param.put("in_pol_cd", portCd);
			param.put("bkg_no", bkgNo);
			param.put("cntr_no", cntrNo);
			param.put("upd_usr_id", usrId);

			Map<String, Object> velParam = new HashMap<String, Object>();
			velParam.put("in_vvd_cd", vvdCd);
			velParam.put("in_pol_cd", portCd);
			velParam.put("bkg_no", bkgNo);
			velParam.put("cntr_no", cntrNo);
			velParam.put("upd_usr_id", usrId);

			velParam.put("in_pol_split_no", inPolSplitNo); // Add. 2015.02.09
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new CLLCDLManifestDBDAOremoveCllMainDSQL(), param, velParam,
					true);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to delete SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Container Loading List - Danger Cargo Data를 삭제한다.<br>
	 * 
	 * @param BkgCstmsTmlCllDgCgoVO bkgCstmsTmlCllDgCgoVO
	 * @throws DAOException
	 */
	public void removeCllDgGgo(BkgCstmsTmlCllDgCgoVO bkgCstmsTmlCllDgCgoVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try {
			Map<String, String> mapVO = bkgCstmsTmlCllDgCgoVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new CLLCDLManifestDBDAOremoveCllDgCgoDSQL(), param, velParam,
					true);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to delete SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Container Loading List - Danger Cargo Data를 삭제한다.<br>
	 * 
	 * @param bkgCstmsCdConvCtntVOs bkgCstmsCdConvCtntVOs
	 * @throws DAOException
	 */
	public void removeCdConvCtnt(List<BkgCstmsCdConvCtntVO> bkgCstmsCdConvCtntVOs) throws DAOException, Exception {
		try {
			Map<String, Object> velParam = new HashMap<String, Object>();
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (bkgCstmsCdConvCtntVOs.size() > 0)
			{
				Map<String, String> mapVO = bkgCstmsCdConvCtntVOs.get(0).getColumnValues();
				velParam.putAll(mapVO);
				updCnt = sqlExe.executeBatch((ISQLTemplate) new CLLCDLManifestDBDAOremoveCdConvCtntDSQL(),
						bkgCstmsCdConvCtntVOs, velParam);
				for (int i = 0; i < updCnt.length; i++)
				{
					if (updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}	

	/**
	 * 한국의 Container Loading 대상 목록의 Summary 화면에서의 SPP Code를 Select<br>
	 * 
	 * @programID : ESM_BKG_1056 - search
	 * @param String entryTp
	 * @return List<KorCllSppDetailVO>
	 * @throws DAOException, Exception
	 * @author Son Yun Seuk
	 */
	@SuppressWarnings("unchecked")
	public List<KorCllSppDetailVO> searchKorCllSppList(String entryTp) throws DAOException, Exception {
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		List<KorCllSppDetailVO> list = null;

		String delt_flg = "N";
		String cnt_cd = "KR";
		String cstms_div_id = "CLL_SPP_CD";

		try {
			param.put("delt_flg", delt_flg);
			param.put("cnt_cd", cnt_cd);
			param.put("cstms_div_id", cstms_div_id);
			param.put("attr_ctnt1", entryTp);
			velParam.put("attr_ctnt1", entryTp);

			SQLExecuter sqlExe = new SQLExecuter("");
			dbRowset = sqlExe.executeQuery((ISQLTemplate) new CLLCDLManifestDBDAOsearchKorCllSppListRSQL(), param,
					velParam, true);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, KorCllSppDetailVO.class);
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
	 * 한국의 Container Loading 대상 목록의 Summary 화면에서의 SPP Code를 Creation, Inquiry<br>
	 * 
	 * @programID : ESM_BKG_1056 - Insert
	 * @param KorCllSppVO korCllSppVOs
	 * @throws DAOException, Exception
	 * @author Son Yun Seuk
	 */
	public void addKorCllSppList(KorCllSppVO korCllSppVOs) throws DAOException, Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try {
			Map<String, String> mapVO = korCllSppVOs.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new CLLCDLManifestDBDAOaddKorCllSppListCSQL(), param,
					velParam, true);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 한국의 Container Loading 대상 목록의 Summary 화면에서의 SPP Code를 Creation, Inquiry<br>
	 * 
	 * @programID : ESM_BKG_1056 - Update(삭제는 Delt_Flg를 'Y'로 설정하여 처리
	 * @param List<KorCllSppVO> korCllSppVOs
	 * @throws DAOException, Exception
	 * @author Son Yun Seuk
	 */
	public void modifyKorCllSppList(List<KorCllSppVO> korCllSppVOs) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (korCllSppVOs.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new CLLCDLManifestDBDAOmodifyKorCllSppListUSQL(),
						korCllSppVOs, null);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Terminal 에 EDI 전송할 Export Container List 정보를 조회한다.<br>
	 * 
	 * @param String bkgNo
	 * @param String polCd
	 * @return List<ExCntrTransmitVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ExCntrTransmitVO> searchCntrExportInfo(String bkgNo, String polCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<ExCntrTransmitVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			param.put("bkg_no", bkgNo);
			velParam.put("bkg_no", bkgNo);
			param.put("pol_cd", polCd);
			velParam.put("pol_cd", polCd);

			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CLLCDLManifestDBDAOsearchCntrExportInfoRSQL(), param, velParam, true);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, ExCntrTransmitVO.class);

			return list;
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Terminal 에 EDI 전송할 Export Container List 정보를 조회한다.<br>
	 * 
	 * @param String bkgNo
	 * @param String polCd
	 * @return List<ExCntrTransmitVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ExCntrTransmitVO> searchCntrExportInfo2(String bkgNo, String polCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<ExCntrTransmitVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			param.put("bkg_no", bkgNo);
			velParam.put("bkg_no", bkgNo);
			param.put("pol_cd", polCd);
			velParam.put("pol_cd", polCd);

			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CLLCDLManifestDBDAOsearchCntrExportInfo2RSQL(), param, velParam, true);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, ExCntrTransmitVO.class);

			return list;
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}	

	/**
	 * 미주 터미널에 보낼 엑셀 형식의 데이터와 비교할 NIS 데이터를 조회한다.<br>
	 * 
	 * @param CllCdlCheckUsaCondVO cllCdlCheckUsaCondVO
	 * @return List<CllCdlCheckUsaVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CllCdlCheckUsaVO> searchCllCdlCheckForUS(CllCdlCheckUsaCondVO cllCdlCheckUsaCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CllCdlCheckUsaVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = cllCdlCheckUsaCondVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CLLCDLManifestDBDAOsearchCllCdlCheckForUSRSQL(), param, velParam, true);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CllCdlCheckUsaVO.class);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * 구주 Container Export EDI 전송시 필요한 VVD DATA를 조회 한다.<br>
	 * 
	 * @param ExCntrTransmitCondVO exCntrTransmitCondVO
	 * @return List<ExCntrVvdInfoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ExCntrVvdInfoVO> searchCntrExportVvd(ExCntrTransmitCondVO exCntrTransmitCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ExCntrVvdInfoVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = exCntrTransmitCondVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CLLCDLManifestDBDAOsearchCntrExportVvdRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, ExCntrVvdInfoVO.class);
			// dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new
			// CLLCDLManifestDBDAOsearchCntrExportVvdRSQL(), param, velParam);
			// list = (List)new SQLExecuter("").executeQuery((ISQLTemplate)new
			// CLLCDLManifestDBDAOsearchCntrExportVvdRSQL(), param, velParam, ExCntrVvdInfoVO.class);

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
	 * 구주 Container Export EDI 전송시 필요한 BL DATA를 조회 한다.<br>
	 * 
	 * @param ExCntrTransmitCondVO exCntrTransmitCondVO
	 * @return List<ExCntrTransmitBlInfoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ExCntrTransmitBlInfoVO> searchCntrExportTranmitBl(ExCntrTransmitCondVO exCntrTransmitCondVO)
			throws DAOException {
		DBRowSet dbRowset = null;
		List<ExCntrTransmitBlInfoVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = exCntrTransmitCondVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CLLCDLManifestDBDAOsearchCntrExportTransmitBlRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, ExCntrTransmitBlInfoVO.class);
			// dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new
			// CLLCDLManifestDBDAOsearchCntrExportVvdRSQL(), param, velParam);
			// list = (List)new SQLExecuter("").executeQuery((ISQLTemplate)new
			// CLLCDLManifestDBDAOsearchCntrExportVvdRSQL(), param, velParam, ExCntrVvdInfoVO.class);

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
	 * 구주 Container Export EDI 전송시 필요한 Container DATA를 조회 한다.<br>
	 * 
	 * @param ExCntrTransmitCondVO exCntrTransmitCondVO
	 * @return List<ExCntrTransmitCntrInfoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ExCntrTransmitCntrInfoVO> searchCntrExportTransmitCntr(ExCntrTransmitCondVO exCntrTransmitCondVO)
			throws DAOException {
		DBRowSet dbRowset = null;
		List<ExCntrTransmitCntrInfoVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = exCntrTransmitCondVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CLLCDLManifestDBDAOsearchCntrExportTransmitCntrRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, ExCntrTransmitCntrInfoVO.class);
			// dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new
			// CLLCDLManifestDBDAOsearchCntrExportVvdRSQL(), param, velParam);
			// list = (List)new SQLExecuter("").executeQuery((ISQLTemplate)new
			// CLLCDLManifestDBDAOsearchCntrExportVvdRSQL(), param, velParam, ExCntrVvdInfoVO.class);

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
	 * 구주 Container Export EDI 전송시 필요한 Container Description DATA를 조회 한다.<br>
	 * 
	 * @param ExCntrTransmitCondVO exCntrTransmitCondVO
	 * @return List<ExCntrTransmitCntrDescInfoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ExCntrTransmitCntrDescInfoVO> searchCntrExportTransmitCntrDesc(ExCntrTransmitCondVO exCntrTransmitCondVO)
			throws DAOException {
		DBRowSet dbRowset = null;
		List<ExCntrTransmitCntrDescInfoVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = exCntrTransmitCondVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CLLCDLManifestDBDAOsearchCntrExportTransmitCntrDescRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, ExCntrTransmitCntrDescInfoVO.class);
			// dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new
			// CLLCDLManifestDBDAOsearchCntrExportVvdRSQL(), param, velParam);
			// list = (List)new SQLExecuter("").executeQuery((ISQLTemplate)new
			// CLLCDLManifestDBDAOsearchCntrExportVvdRSQL(), param, velParam, ExCntrVvdInfoVO.class);

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
	 * 구주 Container Export EDI 전송시 필요한 Container speccial cargoDATA를 조회 한다.<br>
	 * 
	 * @param ExCntrTransmitCondVO exCntrTransmitCondVO
	 * @return List<ExCntrTransmitCntrSpecialInfoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ExCntrTransmitCntrSpecialInfoVO> searchCntrExportTransmitCntrSpecial(
			ExCntrTransmitCondVO exCntrTransmitCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ExCntrTransmitCntrSpecialInfoVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = exCntrTransmitCondVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CLLCDLManifestDBDAOsearchCntrExportTransmitCntrSpecialRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, ExCntrTransmitCntrSpecialInfoVO.class);
			// dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new
			// CLLCDLManifestDBDAOsearchCntrExportVvdRSQL(), param, velParam);
			// list = (List)new SQLExecuter("").executeQuery((ISQLTemplate)new
			// CLLCDLManifestDBDAOsearchCntrExportVvdRSQL(), param, velParam, ExCntrVvdInfoVO.class);

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
	 * 구주 Container Export EDI 전송시 필요한 Danger Cgo정보를 조회 한다.<br>
	 * 
	 * @param ExCntrTransmitCondVO exCntrTransmitCondVO
	 * @return List<ExCntrTransmitCntrInfoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ExCntrTransmitCntrDgInfoVO> searchCntrExportTransmitCntrDg(ExCntrTransmitCondVO exCntrTransmitCondVO)
			throws DAOException {
		DBRowSet dbRowset = null;
		List<ExCntrTransmitCntrDgInfoVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = exCntrTransmitCondVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CLLCDLManifestDBDAOsearchCntrExportTransmitCntrDgRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, ExCntrTransmitCntrDgInfoVO.class);
			// dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new
			// CLLCDLManifestDBDAOsearchCntrExportVvdRSQL(), param, velParam);
			// list = (List)new SQLExecuter("").executeQuery((ISQLTemplate)new
			// CLLCDLManifestDBDAOsearchCntrExportVvdRSQL(), param, velParam, ExCntrVvdInfoVO.class);

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
	 * 구주 Container Export EDI 전송시 필요한 Container Type별 Qty를 조회 한다.<br>
	 * 
	 * @param ExCntrTransmitCondVO exCntrTransmitCondVO
	 * @return List<ExCntrTransmitCntrQtyInfoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ExCntrTransmitCntrQtyInfoVO> searchCntrExportTransmitCntrQty(ExCntrTransmitCondVO exCntrTransmitCondVO)
			throws DAOException {
		DBRowSet dbRowset = null;
		List<ExCntrTransmitCntrQtyInfoVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = exCntrTransmitCondVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CLLCDLManifestDBDAOsearchCntrExportTransmitCntrQtyRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, ExCntrTransmitCntrQtyInfoVO.class);
			// dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new
			// CLLCDLManifestDBDAOsearchCntrExportVvdRSQL(), param, velParam);
			// list = (List)new SQLExecuter("").executeQuery((ISQLTemplate)new
			// CLLCDLManifestDBDAOsearchCntrExportVvdRSQL(), param, velParam, ExCntrVvdInfoVO.class);

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
	 * 구주 Container Export EDI 전송시 필요한 Booking no별 VVD정보를 조회 한다.<br>
	 * 
	 * @param ExCntrTransmitCondVO exCntrTransmitCondVO
	 * @return List<ExCntrTransmitCntrBkgVvdInfoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ExCntrTransmitCntrBkgVvdInfoVO> searchCntrExportTransmitCntrBkgVvd(
			ExCntrTransmitCondVO exCntrTransmitCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ExCntrTransmitCntrBkgVvdInfoVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = exCntrTransmitCondVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CLLCDLManifestDBDAOsearchCntrExportTransmitCntrBkgVvdRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, ExCntrTransmitCntrBkgVvdInfoVO.class);
			// dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new
			// CLLCDLManifestDBDAOsearchCntrExportVvdRSQL(), param, velParam);
			// list = (List)new SQLExecuter("").executeQuery((ISQLTemplate)new
			// CLLCDLManifestDBDAOsearchCntrExportVvdRSQL(), param, velParam, ExCntrVvdInfoVO.class);

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
	 * Export Container Terminal 정보 존재 여부를 체크한다.
	 * 
	 * @param ExCntrTransmitCondVO exCntrTransmitCondVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchCntrExportTml(ExCntrTransmitCondVO exCntrTransmitCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		String sCnt = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			// query parameter
			Map<String, String> mapVO = exCntrTransmitCondVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CLLCDLManifestDBDAOsearchCntrExportTmlRSQL(),
					param, velParam, true);
			if (dbRowset.next()) {
				sCnt = dbRowset.getString(1);
			} else {
				sCnt = "";
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return sCnt;
	}
	
	/**
	 * Export Container Terminal 정보 를 저장한다.
	 * 
	 * @param ExCntrTransmitCondVO exCntrTransmitCondVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int addCntrExportTml(ExCntrTransmitCondVO exCntrTransmitCondVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = exCntrTransmitCondVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new CLLCDLManifestDBDAOaddCntrExportTmlCSQL(), param, velParam, true);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");
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
	 * Export Container Terminal 정보 를 수정한다.<br>
	 * 
	 * @param ExCntrTransmitCondVO exCntrTransmitCondVO
	 * @return int result
	 * @throws DAOException
	 * @throws Exception
	 */
	public int modifyCntrExportTml(ExCntrTransmitCondVO exCntrTransmitCondVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = exCntrTransmitCondVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new CLLCDLManifestDBDAOmodifyCntrExportTmlUSQL(), param,
					velParam, true);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");
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
	 * Export Container Terminal Detail 정보 존재 여부를 체크한다.
	 * 
	 * @param ExCntrTransmitCondVO exCntrTransmitCondVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchCntrExportTmlDtl(ExCntrTransmitCondVO exCntrTransmitCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		String sCnt = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			// query parameter
			Map<String, String> mapVO = exCntrTransmitCondVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CLLCDLManifestDBDAOsearchCntrExportTmlDtlRSQL(),
					param, velParam, true);
			if (dbRowset.next()) {
				sCnt = dbRowset.getString(1);
			} else {
				sCnt = "";
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return sCnt;
	}
	
	/**
	 * Export Container Terminal Detail 정보 를 저장한다.
	 * 
	 * @param ExCntrTransmitCondVO exCntrTransmitCondVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int addCntrExportTmlDtl(ExCntrTransmitCondVO exCntrTransmitCondVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = exCntrTransmitCondVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new CLLCDLManifestDBDAOaddCntrExportTmlDtlCSQL(), param, velParam, true);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");
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
	 * Export Container Terminal Detail 정보 를 수정한다.<br>
	 * 
	 * @param ExCntrTransmitCondVO exCntrTransmitCondVO
	 * @return int result
	 * @throws DAOException
	 * @throws Exception
	 */
	public int modifyCntrExportTmlDtl(ExCntrTransmitCondVO exCntrTransmitCondVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = exCntrTransmitCondVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new CLLCDLManifestDBDAOmodifyCntrExportTmlDtlUSQL(), param,
					velParam, true);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");
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
	 * Container Discharging List Data를 생성한다.<br>
	 * 
	 * @param CllCdlTransmitVO cllCdlTransmitVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int addCdlEdiList(CllCdlTransmitVO cllCdlTransmitVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = cllCdlTransmitVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new CLLCDLManifestDBDAOaddCdlEdiListCSQL(), param, velParam, true);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");
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
	 * Container Discharging List FlatFile을 생성한다.<br>
	 * 
	 * @param CllCdlTransmitVO cllCdlTransmitVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int addCdlEdiMain(CllCdlTransmitVO cllCdlTransmitVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = cllCdlTransmitVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			SQLExecuter sqlExe = new SQLExecuter("");
			log.info("############################");
			log.info("mapVO : " + mapVO);
			log.info("############################");
			result = sqlExe.executeUpdate((ISQLTemplate) new CLLCDLManifestDBDAOaddCdlEdiMainCSQL(), param, null, true);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");
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
	 * Container Discharging List FlatFile(Mark And Description)을 생성한다.<br>
	 * 
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int addCdlEdiMnd() throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			//Map<String, String> mapVO = cllCdlTransmitVO.getColumnValues();

			//param.putAll(mapVO);
			//velParam.putAll(mapVO);
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new CLLCDLManifestDBDAOaddCdlEdiMndCSQL(), param, velParam, true);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");
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
	 * Container Discharging List 생성한 FlatFile을 검색한다.<br>
	 * 
	 * @param String startIndex
	 * @param String endIndex
	 * @return List<CdlEdiDetailVO>
	 * @throws DAOException
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<CdlEdiDetailVO> searchCdlEdi(String startIndex, String endIndex) throws DAOException {
		DBRowSet dbRowset = null;
		List<CdlEdiDetailVO> list = null;

		try {
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("start_index", startIndex);
			param.put("end_index", endIndex);

			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CLLCDLManifestDBDAOsearchCdlEdiRSQL(), param, null);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CdlEdiDetailVO.class);

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
	 * BKG_CSTMS_TML_EDI_SND_LOG 테이블에 EDI 전송 LOG 를 입력한다.
	 * 
	 * @param KorCllRtvOptionVO korCllRtvOptionVO
	 * @return int result
	 * @throws DAOException
	 * @throws Exception
	 */
	public int addKorCllEdiSendLog(KorCllRtvOptionVO korCllRtvOptionVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = korCllRtvOptionVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new CLLCDLManifestDBDAOaddKorCllEdiSendLogCSQL(), param, velParam, true);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");
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
	 * Container Loading List(Korea) 관련 Vessel Schedule 정보를 조회한다.<br>
	 * 
	 * @param String vslCd
	 * @param String skdVoyNo
	 * @param String skdDirCd
	 * @param String polCd
	 * @param String polYdCd
	 * @return String
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public String searchKorCllFinalEdiDt(String vslCd, String skdVoyNo, String skdDirCd, String polCd, String polYdCd) throws DAOException { 
		DBRowSet dbRowset = null;
		String ediSndDt = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
				param.put("vsl_cd", vslCd);
				param.put("skd_voy_no", skdVoyNo);
				param.put("skd_dir_cd", skdDirCd);
				param.put("pol_cd", polCd);
				param.put("pol_yd_cd", polYdCd);
				
				velParam.put("pol_yd_cd", polYdCd);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CLLCDLManifestDBDAOsearchKorCllFinalEdiDtRSQL(), param, velParam, true);
			if (dbRowset.next()) {
				ediSndDt = dbRowset.getString(1);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex); 
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return ediSndDt;
	}
	
	/**
	 * EDI 로 전송된 CLL 상의 Booking 데이터와 B/L Data Input Cross-Check 상의 Booking 데이터를 대조하여 Un-match된 항목을 보여준다.<br>
	 * 
	 * @param KorCllCrossChkCondVO korCllCrossChkCondVO
	 * @return List<KorCllCrossChkCondVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<KorCllCrossChkCondVO> searchKorCllCrossCheck(KorCllCrossChkCondVO korCllCrossChkCondVO) throws DAOException { 		
		DBRowSet dbRowset = null;
		List<KorCllCrossChkCondVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (korCllCrossChkCondVO != null) {
				Map<String, String> mapVO = korCllCrossChkCondVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CLLCDLManifestDBDAOsearchKorCllCrossCheckRSQL(), param, velParam, true);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, KorCllCrossChkListVO.class);
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
     * 한건의 B/L에 대한 FF 생성 후 BKG_CSTMS_TML_EDI_TMP 및 BKG_CSTMS_TML_EDI_GEN_TMP 테이블의 내역을 삭제 한다.<br>
     *
     * @param String delTblFlg
     * @throws DAOException
     */
    public void removeEdiTmpTbl(String delTblFlg) throws DAOException {

    	Map<String, Object> param = new HashMap<String, Object>();
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            Map<String, String> mapVO = new HashMap();
            mapVO.put("delTblFlg" , delTblFlg);

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate)new CLLCDLManifestDBDAOremoveEdiTmpTblDSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                    throw new DAOException("Fail to insert SQL");
            
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }
    
    
    
    /**
     * Work Order 생성여부 체크
     * 
     * @param String bkgNo
     * @param String inListType
     * @param String inPolCd
     * @param String inPodCd
     * @return String woFlg
     * @throws DAOException
     */
    public String searchWOFlag(String bkgNo, String inListType, String inPolCd, String inPodCd) throws DAOException {
    	DBRowSet dbRowset = null;
        String woFlg = null;

        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
        	HashMap<String, Object> mapVO = new HashMap<String, Object>();
            mapVO.put("bkg_no", bkgNo);
            mapVO.put("in_list_type", inListType);
            mapVO.put("in_pol_cd", inPolCd);
            mapVO.put("in_pod_cd", inPolCd);
            param.putAll(mapVO);
            velParam.putAll(mapVO);

            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CLLCDLManifestDBDAOsearchWOFlagRSQL(), param, velParam);
            while (dbRowset.next()) {
            	woFlg = dbRowset.getString(1);
            }
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return woFlg;
    }
    
	/**
     * 500건 이상의 EDI를 전송 할 경우 2번째 묶음의 EDI의 해더 내용을 변경한다.<br>
     *
     * @throws DAOException
     */
    public void updateCdlEdiHdr() throws DAOException {

    	Map<String, Object> param = new HashMap<String, Object>();
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate)new CLLCDLManifestDBDAOupdateCdlEdiHdrUSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                    throw new DAOException("Fail to insert SQL");
            
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }
    
    
    /**
	 * EDI 로 전송된 CLL 상의 Booking 데이터와 B/L Data Input Cross-Check 상의 Booking 데이터를 대조하여 Un-match된 항목을 보여준다.<br>
	 * 
	 * @param PreAdviceVO preAdviceVO
	 * @return List<PreAdviceVvdInfoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<PreAdviceVvdInfoVO> searchPreAdviceVvdInfo(PreAdviceVO preAdviceVO) throws DAOException { 		
		DBRowSet dbRowset = null;
		List<PreAdviceVvdInfoVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (preAdviceVO != null) {
				Map<String, String> mapVO = preAdviceVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CLLCDLManifestDBDAOsearchPreAdivceVvdInfoRSQL(), param, velParam, true);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, PreAdviceVvdInfoVO.class);
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
	 * EDI 로 전송된 CLL 상의 Booking 데이터와 B/L Data Input Cross-Check 상의 Booking 데이터를 대조하여 Un-match된 항목을 보여준다.<br>
	 * 
	 * @param PreAdviceVO preAdviceVO
	 * @return List<PreAdviceManifestListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<PreAdviceManifestListVO> searchPreAdviceManifestList(PreAdviceVO preAdviceVO) throws DAOException { 		
		DBRowSet dbRowset = null;
		List<PreAdviceManifestListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (preAdviceVO != null) {
				Map<String, String> mapVO = preAdviceVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CLLCDLManifestDBDAOsearchPreAdviceManifestListRSQL(), param, velParam, true);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, PreAdviceManifestListVO.class);
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
	 * Container Loading List - Reefer Data를 조회 한다.<br>
	 * 
	 * @param CllRfAkCgoDetailVO cllRfAkCgoDetailVO
	 * @return List<CllRfAkCgoDetailVO>
	 * @throws DAOException
	 * @throws Exception
	 */    
	@SuppressWarnings("unchecked")
	public List<CllRfAkCgoDetailVO> searchCllBkgRfCgo(CllRfAkCgoDetailVO cllRfAkCgoDetailVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CllRfAkCgoDetailVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (cllRfAkCgoDetailVO != null) {
				Map<String, String> mapVO = cllRfAkCgoDetailVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CLLCDLManifestDBDAOsearchCllBkgRfCgoRSQL(), param, velParam, true);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CllRfAkCgoDetailVO.class);
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
	 * Container Loading List - Awkward Data를 조회 한다.<br>
	 * 
	 * @param CllRfAkCgoDetailVO cllRfAkCgoDetailVO
	 * @return List<CllRfAkCgoDetailVO>
	 * @throws DAOException
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<CllRfAkCgoDetailVO> searchCllBkgAkCgo(CllRfAkCgoDetailVO cllRfAkCgoDetailVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CllRfAkCgoDetailVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (cllRfAkCgoDetailVO != null) {
				Map<String, String> mapVO = cllRfAkCgoDetailVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CLLCDLManifestDBDAOsearchCllBkgAwkCgoRSQL(), param, velParam, true);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CllRfAkCgoDetailVO.class);
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
	 * Container Loading List - Reefer, Awkward Cargo Data를 업데이트 및 RF, AWK, DG Flag Updatge 한다.<br>
	 * 
	 * @param CllRfAkCgoDetailVO cllRfAkCgoDetailVO
	 * @return int result
	 * @throws DAOException
	 * @throws Exception
	 */
	public int modifyCllRfAkCgoFlag(CllRfAkCgoDetailVO cllRfAkCgoDetailVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = cllRfAkCgoDetailVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new CLLCDLManifestDBDAOmodifyCllRfAkCgoFlagUSQL(), param,
					velParam, true);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}
}