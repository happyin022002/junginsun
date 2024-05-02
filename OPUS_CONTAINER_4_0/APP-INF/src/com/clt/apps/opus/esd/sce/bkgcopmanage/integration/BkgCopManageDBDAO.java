/*=========================================================
 *Copyright(c) 2010 CyberLogitec
 *@FileName : BkgCopManageDBDAO.java
 *@FileTitle : Bkg Cop Manage
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.08.10
 *@LastModifier : Kim In-soo
 *@LastVersion : 1.0
 * 2010.10.29 김진승 [소스품질 보완] searchAttachCopInfo 메서드 주석 생성
=========================================================*/
package com.clt.apps.opus.esd.sce.bkgcopmanage.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.clt.apps.opus.esd.sce.bkgcopmanage.basic.BkgCopManageBCImpl;
import com.clt.apps.opus.esd.sce.bkgcopmanage.vo.CntrDiffVO;
import com.clt.apps.opus.esd.sce.bkgcopmanage.vo.CopHdrToBeCopiedVO;
import com.clt.apps.opus.esd.sce.bkgcopmanage.vo.SceActTmlRtvVO;
import com.clt.apps.opus.esd.sce.bkgcopmanage.vo.Search315VEToBeSentVO;
import com.clt.apps.opus.esd.sce.bkgcopmanage.vo.SearchCopBndVO;
import com.clt.apps.opus.esd.sce.bkgcopmanage.vo.SearchCopCntLimitVO;
import com.clt.apps.opus.esd.sce.bkgcopmanage.vo.SearchCopVO;
import com.clt.apps.opus.esd.sce.bkgcopmanage.vo.SearchDiffCntrListVO;
import com.clt.apps.opus.esd.sce.bkgcopmanage.vo.SearchDiffQtyListVO;
import com.clt.apps.opus.esd.sce.bkgcopmanage.vo.SearchIBDoorDtlVO;
import com.clt.apps.opus.esd.sce.bkgcopmanage.vo.SearchPorForSendBFVO;
import com.clt.apps.opus.esd.sce.bkgcopmanage.vo.UpdBkgForBkgCodVO;
import com.clt.apps.opus.esd.sce.bkgcopmanage.vo.ValidateTROSequenceVO;
import com.clt.apps.opus.esd.sce.common.SCEConstants;
import com.clt.apps.opus.esd.sce.copdetailreceive.vo.SceActRcvIfVO;
import com.clt.apps.opus.esd.sce.replanmanage.replanmanage.integration.ReplanManageDBDAOModifyRailBilOrdByCopUSQL;
import com.clt.apps.opus.esd.sce.replanmanage.replanmanage.integration.ReplanManageDBDAOModifySvcOrdByCopUSQL;
import com.clt.apps.opus.esd.sce.replanmanage.replanmanage.integration.ReplanManageDBDAOSearchActualToBeUpdatedRSQL;
import com.clt.apps.opus.esd.sce.replanmanage.replanmanage.integration.ReplanManageDBDAOSearchBfCombineBkgInfoRSQL;
import com.clt.apps.opus.esd.sce.replanmanage.replanmanage.integration.ReplanManageDBDAOSearchCopRailChkRSQL;
import com.clt.apps.opus.esd.sce.replanmanage.replanmanage.integration.ReplanManageDBDAOSearchPartialCopsRSQL;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.CombineTroNewSeqVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.syscommon.common.table.BkgBlDocVO;
import com.clt.syscommon.common.table.BkgBookingVO;
import com.clt.syscommon.common.table.BkgContainerVO;
import com.clt.syscommon.common.table.BkgEurTroDtlVO;
import com.clt.syscommon.common.table.BkgEurTroVO;
import com.clt.syscommon.common.table.BkgQuantityVO;
import com.clt.syscommon.common.table.BkgTroDtlVO;
import com.clt.syscommon.common.table.BkgTroVO;
import com.clt.syscommon.common.table.LeaCntrBkgHisVO;
import com.clt.syscommon.common.table.MstContainerVO;
import com.clt.syscommon.common.table.PrdBkgCopMapVO;
import com.clt.syscommon.common.table.SceBkgOpHisVO;
import com.clt.syscommon.common.table.SceBkgOpParaVO;
import com.clt.syscommon.common.table.SceCopDtlVO;
import com.clt.syscommon.common.table.SceCopHdrVO;
import com.clt.syscommon.common.table.ScePlnSoListVO;
import com.clt.syscommon.common.table.SceTroMapgVO;
import com.clt.syscommon.common.table.TrsTrspRailBilOrdVO;
import com.clt.syscommon.common.table.TrsTrspSvcOrdVO;

/**
 * @author 2002701
 * @see BkgCopManageBCImpl
 * @since J2EE 1.4
 */
@SuppressWarnings("serial")
public class BkgCopManageDBDAO extends DBDAOSupport {
	/**
	 * @param bkg_no
	 * @param pctl_no
	 * @return List<SceCopHdrVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SceCopHdrVO> searchCopInfo(String bkg_no, String pctl_no) throws DAOException {
		Map<String, String> velParam = new HashMap<String, String>();
		Map<String, String> param = new HashMap<String, String>();
		DBRowSet dbRowset = null;

		param.put("bkg_no", bkg_no);
		param.put("pctl_no", pctl_no);

		List<SceCopHdrVO> rtnList = new ArrayList<SceCopHdrVO>();

		try {
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BkgCopManageDBDAOSearchCopInfoRSQL(), param, velParam);

			rtnList = (List) RowSetUtil.rowSetToVOs(dbRowset, SceCopHdrVO.class);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnList;
	}

	/**
	 * @param bkg_no
	 * @param cntr_no
	 * @param cntr_tpsz_cd
	 * @param pctl_no
	 * @param cop_no
	 * @return List<SceCopHdrVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SceCopHdrVO> searchCopHdrToBeCreated(String bkg_no, String cntr_no, String cntr_tpsz_cd, String pctl_no, String cop_no) throws DAOException {
		Map<String, String> velParam = new HashMap<String, String>();
		Map<String, String> param = new HashMap<String, String>();
		DBRowSet dbRowset = null;

		param.put("bkg_no", bkg_no);
		param.put("cntr_no", cntr_no);
		param.put("pctl_no", pctl_no);
		param.put("cntr_tpsz_cd", cntr_tpsz_cd);
		param.put("cop_no", cop_no);

		velParam.put("bkg_no", bkg_no);
		velParam.put("cntr_no", cntr_no);
		velParam.put("pctl_no", pctl_no);
		velParam.put("cntr_tpsz_cd", cntr_tpsz_cd);
		velParam.put("cop_no", cop_no);

		List<SceCopHdrVO> rtnList = new ArrayList<SceCopHdrVO>();

		try {
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BkgCopManageDBDAOSearchCopHdrToBeCreatedRSQL(), param, velParam);

			rtnList = (List) RowSetUtil.rowSetToVOs(dbRowset, SceCopHdrVO.class);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnList;
	}

	/**
	 * @param bkg_no
	 * @param cop_sts_cd
	 * @param cop_upd_rmk
	 * @return List<CopHdrToBeCopiedVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<CopHdrToBeCopiedVO> searchCopHdrToBeCopied(String bkg_no, String cop_sts_cd, String cop_upd_rmk) throws DAOException {
		Map<String, String> velParam = new HashMap<String, String>();
		Map<String, String> param = new HashMap<String, String>();
		DBRowSet dbRowset = null;

		param.put("bkg_no", bkg_no);
		param.put("cop_sts_cd", cop_sts_cd);
		param.put("cop_upd_rmk", cop_upd_rmk);

		velParam.put("bkg_no", bkg_no);
		velParam.put("cop_sts_cd", cop_sts_cd);
		velParam.put("cop_upd_rmk", cop_upd_rmk);

		List<CopHdrToBeCopiedVO> rtnList = new ArrayList<CopHdrToBeCopiedVO>();

		try {
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BkgCopManageDBDAOSearchCopHdrToBeCopiedRSQL(), param, velParam);

			rtnList = (List) RowSetUtil.rowSetToVOs(dbRowset, CopHdrToBeCopiedVO.class);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnList;
	}

	/**
	 * @param bkg_no
	 * @param tro_seq
	 * @param tro_sub_seq
	 * @param io_bnd_cd
	 * @param area_conti_cd
	 * @return List<ValidateTROSequenceVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<ValidateTROSequenceVO> validateTROSequence(String bkg_no, String tro_seq, String tro_sub_seq, String io_bnd_cd, String area_conti_cd) throws DAOException {
		Map<String, String> velParam = new HashMap<String, String>();
		Map<String, String> param = new HashMap<String, String>();
		DBRowSet dbRowset = null;

		param.put("bkg_no", bkg_no);
		param.put("tro_seq", tro_seq);
		param.put("tro_sub_seq", tro_sub_seq);
		param.put("io_bnd_cd", io_bnd_cd);
		param.put("area_conti_cd", area_conti_cd);

		velParam.put("bkg_no", bkg_no);
		velParam.put("tro_seq", tro_seq);
		velParam.put("tro_sub_seq", tro_sub_seq);
		velParam.put("io_bnd_cd", io_bnd_cd);
		velParam.put("area_conti_cd", area_conti_cd);

		List<ValidateTROSequenceVO> rtnList = new ArrayList<ValidateTROSequenceVO>();

		try {
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BkgCopManageDBDAOValidateTROSequenceRSQL(), param, velParam);

			rtnList = (List) RowSetUtil.rowSetToVOs(dbRowset, ValidateTROSequenceVO.class);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnList;
	}

	/**
	 * @param bkg_no
	 * @param io_bnd_cd
	 * @param area_conti_cd
	 * @return List<ValidateTROSequenceVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<ValidateTROSequenceVO> validateTROSequence(String bkg_no, String io_bnd_cd, String area_conti_cd) throws DAOException {
		Map<String, String> velParam = new HashMap<String, String>();
		Map<String, String> param = new HashMap<String, String>();
		DBRowSet dbRowset = null;

		param.put("bkg_no", bkg_no);
		param.put("io_bnd_cd", io_bnd_cd);
		param.put("area_conti_cd", area_conti_cd);

		List<ValidateTROSequenceVO> rtnList = new ArrayList<ValidateTROSequenceVO>();

		try {
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BkgCopManageDBDAOValidateTROSequenceRSQL(), param, velParam);

			rtnList = (List) RowSetUtil.rowSetToVOs(dbRowset, ValidateTROSequenceVO.class);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnList;
	}

	/**
	 * @param bkg_no
	 * @param tro_seq
	 * @param tro_sub_seq
	 * @param io_bnd_cd
	 * @param area_conti_cd
	 * @return List<SearchCopVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SearchCopVO> searchOBCop(String bkg_no, String tro_seq, String tro_sub_seq, String io_bnd_cd, String area_conti_cd) throws DAOException {
		Map<String, String> velParam = new HashMap<String, String>();

		Map<String, String> param = new HashMap<String, String>();

		DBRowSet dbRowset = null;

		param.put("bkg_no", bkg_no);
		param.put("tro_seq", tro_seq);
		param.put("tro_sub_seq", tro_sub_seq);
		param.put("io_bnd_cd", io_bnd_cd);
		param.put("area_conti_cd", area_conti_cd);

		velParam.put("bkg_no", bkg_no);
		velParam.put("tro_seq", tro_seq);
		velParam.put("tro_sub_seq", tro_sub_seq);
		velParam.put("io_bnd_cd", io_bnd_cd);
		velParam.put("area_conti_cd", area_conti_cd);

		List<SearchCopVO> rtnList = new ArrayList<SearchCopVO>();

		try {
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BkgCopManageDBDAOSearchOBCopRSQL(), param, velParam);

			rtnList = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchCopVO.class);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnList;
	}

	/**
	 * @param bkg_no
	 * @param tro_seq
	 * @param tro_sub_seq
	 * @param io_bnd_cd
	 * @param area_conti_cd
	 * @return List<SearchCopVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SearchCopVO> searchIBCop(String bkg_no, String tro_seq, String tro_sub_seq, String io_bnd_cd, String area_conti_cd) throws DAOException {
		Map<String, String> velParam = new HashMap<String, String>();

		Map<String, String> param = new HashMap<String, String>();

		DBRowSet dbRowset = null;

		param.put("bkg_no", bkg_no);
		param.put("tro_seq", tro_seq);
		param.put("tro_sub_seq", tro_sub_seq);
		param.put("io_bnd_cd", io_bnd_cd);
		param.put("area_conti_cd", area_conti_cd);

		velParam.put("bkg_no", bkg_no);
		velParam.put("tro_seq", tro_seq);
		velParam.put("tro_sub_seq", tro_sub_seq);
		velParam.put("io_bnd_cd", io_bnd_cd);
		velParam.put("area_conti_cd", area_conti_cd);

		List<SearchCopVO> rtnList = new ArrayList<SearchCopVO>();

		try {
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BkgCopManageDBDAOSearchIBCopRSQL(), param, velParam);

			rtnList = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchCopVO.class);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnList;

	}

	/**
	 * @param bkg_no
	 * @param cntr_no
	 * @return List<SceCopHdrVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SceCopHdrVO> searchPartialCop(String bkg_no, String cntr_no) throws DAOException {
		Map<String, String> velParam = new HashMap<String, String>();

		Map<String, String> param = new HashMap<String, String>();

		DBRowSet dbRowset = null;

		param.put("bkg_no", bkg_no);
		param.put("cntr_no", cntr_no);

		List<SceCopHdrVO> rtnList = new ArrayList<SceCopHdrVO>();

		try {
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BkgCopManageDBDAOSearchPartialCopRSQL(), param, velParam);

			rtnList = (List) RowSetUtil.rowSetToVOs(dbRowset, SceCopHdrVO.class);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnList;

	}

	/**
	 * @param bkg_no
	 * @return List<SceCopHdrVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SceCopHdrVO> searchCopHdr(String bkg_no) throws DAOException {
		Map<String, String> velParam = new HashMap<String, String>();

		Map<String, String> param = new HashMap<String, String>();

		DBRowSet dbRowset = null;

		param.put("bkg_no", bkg_no);

		List<SceCopHdrVO> rtnList = new ArrayList<SceCopHdrVO>();

		try {
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BkgCopManageDBDAOSearchCopHdrRSQL(), param, velParam);

			rtnList = (List) RowSetUtil.rowSetToVOs(dbRowset, SceCopHdrVO.class);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnList;
	}

	/**
	 * @param sceCopHdrVO
	 * @return List<SceCopHdrVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SceCopHdrVO> searchCopHdr(SceCopHdrVO sceCopHdrVO) throws DAOException {
		Map<String, String> velParam = new HashMap<String, String>();

		Map<String, String> param = new HashMap<String, String>();

		DBRowSet dbRowset = null;

		param.putAll(sceCopHdrVO.getColumnValues());
		velParam.putAll(sceCopHdrVO.getColumnValues());

		List<SceCopHdrVO> rtnList = new ArrayList<SceCopHdrVO>();

		try {
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BkgCopManageDBDAOSearchCopHdrRSQL(), param, velParam);

			rtnList = (List) RowSetUtil.rowSetToVOs(dbRowset, SceCopHdrVO.class);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnList;
	}

	/**
	 * @param bkg_no
	 * @return List<SceCopHdrVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SceCopHdrVO> searchCopHdrInclCncl(String bkg_no) throws DAOException {
		Map<String, String> velParam = new HashMap<String, String>();

		Map<String, String> param = new HashMap<String, String>();

		DBRowSet dbRowset = null;

		param.put("bkg_no", bkg_no);

		List<SceCopHdrVO> rtnList = new ArrayList<SceCopHdrVO>();

		try {
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BkgCopManageDBDAOSearchCopHdrInclCnclRSQL(), param, velParam);

			rtnList = (List) RowSetUtil.rowSetToVOs(dbRowset, SceCopHdrVO.class);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnList;

	}

	/**
	 * @param bkg_no
	 * @param cntr_no
	 * @return List<SceCopHdrVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SceCopHdrVO> searchCopHdr(String bkg_no, String cntr_no) throws DAOException {
		Map<String, String> velParam = new HashMap<String, String>();

		Map<String, String> param = new HashMap<String, String>();

		DBRowSet dbRowset = null;

		param.put("bkg_no", bkg_no);
		param.put("cntr_no", cntr_no);

		velParam.put("bkg_no", bkg_no);
		velParam.put("cntr_no", cntr_no);

		// SceCopHdrVO rtnCopHdr = null; //new SceCopHdrVO();

		List rtnList = null;
		try {
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BkgCopManageDBDAOSearchCopHdrRSQL(), param, velParam);

			rtnList = (List) RowSetUtil.rowSetToVOs(dbRowset, SceCopHdrVO.class);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnList;
	}

	/**
	 * @param sceCopHdrVO
	 * @return List<SceCopHdrVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SceCopHdrVO> searchToBeMaster(SceCopHdrVO sceCopHdrVO) throws DAOException {
		Map<String, String> velParam = new HashMap<String, String>();

		Map<String, String> param = new HashMap<String, String>();

		DBRowSet dbRowset = null;

		param.put("trnk_vsl_cd", sceCopHdrVO.getTrnkVslCd());
		param.put("trnk_skd_voy_no", sceCopHdrVO.getTrnkSkdVoyNo());
		param.put("trnk_skd_dir_cd", sceCopHdrVO.getTrnkSkdDirCd());
		param.put("pol_nod_cd", sceCopHdrVO.getPolNodCd());
		param.put("cntr_no", sceCopHdrVO.getCntrNo());

		List<SceCopHdrVO> rtnList = new ArrayList<SceCopHdrVO>();

		try {
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BkgCopManageDBDAOSearchToBeMasterRSQL(), param, velParam);

			rtnList = (List) RowSetUtil.rowSetToVOs(dbRowset, SceCopHdrVO.class);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnList;
	}

	/**
	 * @param bkg_nos
	 * @param cntr_no
	 * @return List<SceCopHdrVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SceCopHdrVO> searchMstCopByBkgs(String[] bkg_nos, String cntr_no) throws DAOException {
		Map<String, Object> velParam = new HashMap<String, Object>();

		Map<String, Object> param = new HashMap<String, Object>();

		DBRowSet dbRowset = null;

		List<SceCopHdrVO> rtnList = new ArrayList<SceCopHdrVO>();

		param.put("bkg_no", bkg_nos);
		param.put("cntr_no", cntr_no);

		velParam.put("bkg_no", bkg_nos);
		velParam.put("cntr_no", cntr_no);

		try {
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BkgCopManageDBDAOSearchMstCopByBkgsRSQL(), param, velParam);

			rtnList = (List) RowSetUtil.rowSetToVOs(dbRowset, SceCopHdrVO.class);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnList;
	}

	/**
	 * @param bkg_no
	 * @return List<SearchDiffQtyListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SearchDiffQtyListVO> searchDiffQtyList(String bkg_no) throws DAOException {
		Map<String, String> velParam = new HashMap<String, String>();

		Map<String, String> param = new HashMap<String, String>();

		DBRowSet dbRowset = null;

		param.put("bkg_no", bkg_no);
		velParam.put("bkg_no", bkg_no);

		List<SearchDiffQtyListVO> rtnList = new ArrayList<SearchDiffQtyListVO>();

		try {
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BkgCopManageDBDAOSearchDiffQtyListRSQL(), param, velParam);

			rtnList = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchDiffQtyListVO.class);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnList;
	}

	/**
	 * @param bkg_no
	 * @param cntrTpszCdSet
	 * @param org_cntrTpszCd
	 * @return List<SceCopHdrVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SceCopHdrVO> searchAttachCopInfo(String bkg_no, Set<String> cntrTpszCdSet, String org_cntrTpszCd) throws DAOException {
		Map<String, Object> velParam = new HashMap<String, Object>();

		Map<String, Object> param = new HashMap<String, Object>();

		DBRowSet dbRowset = null;

		param.put("bkg_no", bkg_no);
		param.put("org_cntrTpszCd", org_cntrTpszCd);
		param.put("cntr_tpsz_cd", cntrTpszCdSet.toArray());

		velParam.put("bkg_no", bkg_no);
		velParam.put("org_cntrTpszCd", org_cntrTpszCd);
		velParam.put("cntr_tpsz_cd", cntrTpszCdSet.toArray());

		List<SceCopHdrVO> rtnList = new ArrayList<SceCopHdrVO>();

		try {
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BkgCopManageDBDAOSearchAttachCopInfoRSQL(), param, velParam);

			rtnList = (List) RowSetUtil.rowSetToVOs(dbRowset, SceCopHdrVO.class);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnList;
	}

	/**
	 * @param bkg_no
	 * @param cntr_no
	 * @return List<SceCopHdrVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SceCopHdrVO> searchCopToBeClosed(String bkg_no, String cntr_no) throws DAOException {
		Map<String, String> velParam = new HashMap<String, String>();

		Map<String, String> param = new HashMap<String, String>();

		DBRowSet dbRowset = null;

		param.put("cntr_no", cntr_no);
		param.put("bkg_no", bkg_no);

		List<SceCopHdrVO> rtnList = new ArrayList<SceCopHdrVO>();

		try {
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BkgCopManageDBDAOSearchCopToBeClosedRSQL(), param, velParam);

			rtnList = (List) RowSetUtil.rowSetToVOs(dbRowset, SceCopHdrVO.class);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnList;
	}

	/**
	 * @param cop_no
	 * @return String
	 * @throws DAOException
	 */
	public String searchMaxActDt(String cop_no) throws DAOException {
		Map<String, String> velParam = new HashMap<String, String>();

		Map<String, String> param = new HashMap<String, String>();

		DBRowSet dbRowset = null;

		param.put("cop_no", cop_no);

		String act_dt = "";

		try {
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BkgCopManageDBDAOSearchMaxActDtRSQL(), param, velParam);

			if (dbRowset.next())
				act_dt = dbRowset.getString(1);

		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return act_dt;
	}

	/**
	 * @param bkg_no
	 * @param cntr_tpsz_cd
	 * @return String
	 * @throws DAOException
	 */
	public String searchRepPctlNo(String bkg_no, String cntr_tpsz_cd) throws DAOException {
		Map<String, String> velParam = new HashMap<String, String>();

		Map<String, String> param = new HashMap<String, String>();

		DBRowSet dbRowset = null;

		param.put("bkg_no", bkg_no);
		param.put("cntr_tpsz_cd", cntr_tpsz_cd);

		velParam.put("bkg_no", bkg_no);
		velParam.put("cntr_tpsz_cd", cntr_tpsz_cd);

		String rtnPctlNo = "";

		try {
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BkgCopManageDBDAOSearchRepPctlNoRSQL(), param, velParam);

			if (dbRowset.next())
				rtnPctlNo = dbRowset.getString("PCTL_NO");

		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnPctlNo;
	}

	/**
	 * @param bkg_no
	 * @param cntr_no
	 * @return List<SceCopHdrVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SceCopHdrVO> searchProvCntr(String bkg_no, String cntr_no) throws DAOException {
		Map<String, String> velParam = new HashMap<String, String>();

		Map<String, String> param = new HashMap<String, String>();

		DBRowSet dbRowset = null;

		param.put("cntr_no", cntr_no);
		param.put("bkg_no", bkg_no);

		List<SceCopHdrVO> rtnList = new ArrayList<SceCopHdrVO>();

		try {
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BkgCopManageDBDAOSearchProvCntrRSQL(), param, velParam);

			rtnList = (List) RowSetUtil.rowSetToVOs(dbRowset, SceCopHdrVO.class);

		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnList;
	}

	/**
	 * @param cop_no
	 * @return List<SearchIBDoorDtlVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SearchIBDoorDtlVO> searchIBDoorDtl(String cop_no) throws DAOException {
		Map<String, String> velParam = new HashMap<String, String>();

		Map<String, String> param = new HashMap<String, String>();

		DBRowSet dbRowset = null;

		param.put("cop_no", cop_no);
		velParam.put("cop_no", cop_no);

		List<SearchIBDoorDtlVO> rtnList = new ArrayList<SearchIBDoorDtlVO>();

		try {
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BkgCopManageDBDAOSearchIBDoorDtlRSQL(), param, velParam);

			rtnList = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchIBDoorDtlVO.class);

		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnList;
	}

	/**
	 * @param cop_no
	 * @return List<SceCopDtlVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SceCopDtlVO> searchOBDoorDtl(String cop_no) throws DAOException {
		Map<String, String> velParam = new HashMap<String, String>();

		Map<String, String> param = new HashMap<String, String>();

		DBRowSet dbRowset = null;

		param.put("cop_no", cop_no);
		velParam.put("cop_no", cop_no);

		List<SceCopDtlVO> rtnList = new ArrayList<SceCopDtlVO>();

		try {
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BkgCopManageDBDAOSearchOBDoorDtlRSQL(), param, velParam);

			rtnList = (List) RowSetUtil.rowSetToVOs(dbRowset, SceCopDtlVO.class);

		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnList;
	}

	/**
	 * @param bkg_no
	 * @return BkgBookingVO
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public BkgBookingVO searchBkgBooking(String bkg_no) throws DAOException {
		Map<String, String> velParam = new HashMap<String, String>();

		Map<String, String> param = new HashMap<String, String>();

		DBRowSet dbRowset = null;

		param.put("bkg_no", bkg_no);

		List<BkgBookingVO> rtnList = new ArrayList<BkgBookingVO>();

		try {
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BkgCopManageDBDAOSearchBkgBookingRSQL(), param, velParam);

			rtnList = (List) RowSetUtil.rowSetToVOs(dbRowset, BkgBookingVO.class);

		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnList.size() >= 1 ? rtnList.get(0) : new BkgBookingVO();
	}

	/**
	 * @param bkg_no
	 * @return BkgBlDocVO
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public BkgBlDocVO searchBkgBlDoc(String bkg_no) throws DAOException {
		Map<String, String> velParam = new HashMap<String, String>();

		Map<String, String> param = new HashMap<String, String>();

		DBRowSet dbRowset = null;

		param.put("bkg_no", bkg_no);

		List<BkgBlDocVO> rtnList = new ArrayList<BkgBlDocVO>();

		try {
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BkgCopManageDBDAOSearchBkgBlDocRSQL(), param, velParam);

			rtnList = (List) RowSetUtil.rowSetToVOs(dbRowset, BkgBlDocVO.class);

		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnList.size() >= 1 ? rtnList.get(0) : new BkgBlDocVO();
	}

	/**
	 * @param bkg_no
	 * @param cntr_no
	 * @return List<BkgContainerVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<BkgContainerVO> searchBkgContainer(String bkg_no, String cntr_no) throws DAOException {
		Map<String, String> velParam = new HashMap<String, String>();

		Map<String, String> param = new HashMap<String, String>();

		DBRowSet dbRowset = null;

		param.put("bkg_no", bkg_no);
		param.put("cntr_no", cntr_no);

		velParam.put("bkg_no", bkg_no);
		velParam.put("cntr_no", cntr_no);

		List<BkgContainerVO> rtnList = new ArrayList<BkgContainerVO>();

		try {
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BkgCopManageDBDAOSearchBkgContainerRSQL(), param, velParam);

			rtnList = (List) RowSetUtil.rowSetToVOs(dbRowset, BkgContainerVO.class);

		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnList;
	}

	/**
	 * @param bkg_no
	 * @return List<BkgContainerVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<BkgContainerVO> searchBkgContainer(String bkg_no) throws DAOException {
		Map<String, String> velParam = new HashMap<String, String>();

		Map<String, String> param = new HashMap<String, String>();

		DBRowSet dbRowset = null;

		param.put("bkg_no", bkg_no);

		velParam.put("bkg_no", bkg_no);

		List<BkgContainerVO> rtnList = new ArrayList<BkgContainerVO>();

		try {
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BkgCopManageDBDAOSearchBkgContainerRSQL(), param, velParam);

			rtnList = (List) RowSetUtil.rowSetToVOs(dbRowset, BkgContainerVO.class);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnList;

	}

	/**
	 * @param cop_no
	 * @return SearchCopBndVO
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public SearchCopBndVO searchCopBnd(String cop_no) throws DAOException {
		Map<String, String> velParam = new HashMap<String, String>();

		Map<String, String> param = new HashMap<String, String>();

		DBRowSet dbRowset = null;

		param.put("cop_no", cop_no);

		List<SearchCopBndVO> rtnList = new ArrayList<SearchCopBndVO>();

		try {
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BkgCopManageDBDAOSearchCopBndRSQL(), param, velParam);

			rtnList = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchCopBndVO.class);

		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnList.get(0);
	}

	// public String searchCopRailChk (String cop_no) throws DAOException {
	// Map<String, String> velParam = new HashMap<String, String>();
	//
	// Map<String, String> param = new HashMap<String, String>();
	//
	// DBRowSet dbRowset = null;
	//
	// param.put("cop_no", cop_no);
	//
	// String rtnRailChk = "";
	//
	// try {
	// dbRowset = new SQLExecuter("").executeQuery(
	// (ISQLTemplate) new BkgCopManageDBDAOSearchCop,
	// param, velParam);
	//
	// if (dbRowset.next())
	// rtnRailChk = dbRowset.getString("COP_RAIL_CHK_CD");
	//
	// } catch (Exception ex) {
	// log.error(ex.getMessage(), ex);
	// throw new DAOException(new ErrorHandler(ex).getMessage());
	// }
	// return rtnRailChk;
	// }

	/**
	 * @param cntr_tpsz_cd
	 * @return Set<String>
	 * @throws DAOException
	 */
	public Set<String> searchRepoRule(String cntr_tpsz_cd) throws DAOException {
		Map<String, String> velParam = new HashMap<String, String>();

		Map<String, String> param = new HashMap<String, String>();

		DBRowSet dbRowset = null;

		param.put("cntr_tpsz_cd", cntr_tpsz_cd);

		Set<String> rtnSet = new HashSet<String>();

		try {
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BkgCopManageDBDAOSearchRepoRuleRSQL(), param, velParam);
			while (dbRowset.next())
				rtnSet.add(dbRowset.getString("PROV_CNTR_TPSZ_CD"));

		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnSet;
	}

	/**
	 * @param new_bkg_no
	 * @param mapg_seq
	 * @return List<PrdBkgCopMapVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<PrdBkgCopMapVO> searchPrdMap(String[] new_bkg_no, String[] mapg_seq) throws DAOException {
		Map<String, Object> velParam = new HashMap<String, Object>();

		Map<String, Object> param = new HashMap<String, Object>();

		DBRowSet dbRowset = null;

		// List<String> bkg_no = new ArrayList<String> ();
		// List<String> cop_mapg_seq = new ArrayList<String> ();

		// for (int i = 0 ; i < new_bkg_no.length ; i++) {
		// bkg_no.add(new_bkg_no[i]);
		// }
		//
		// for (int i = 0 ; i < mapg_seq.length ; i++) {
		// cop_mapg_seq.add(mapg_seq[i]);
		// }
		// velParam.put("bkg_no", bkg_no.toArray());
		// param.put("bkg_no", bkg_no);
		//
		// velParam.put("cop_mapg_seq", cop_mapg_seq.toArray());
		// param.put("cop_mapg_seq", cop_mapg_seq);

		velParam.put("bkg_no", new_bkg_no);
		param.put("bkg_no", new_bkg_no);

		velParam.put("cop_mapg_seq", mapg_seq);
		param.put("cop_mapg_seq", mapg_seq);

		List<PrdBkgCopMapVO> rtnList = new ArrayList<PrdBkgCopMapVO>();

		try {
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BkgCopManageDBDAOSearchPrdMapRSQL(), null, velParam);

			rtnList = (List) RowSetUtil.rowSetToVOs(dbRowset, PrdBkgCopMapVO.class);

		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnList;
	}

	/**
	 * @param bkg_no
	 * @param tro_seq
	 * @param io_bnd_cd
	 * @return List<BkgEurTroVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<BkgEurTroVO> searchBkgEurTro(String bkg_no, String tro_seq, String io_bnd_cd) throws DAOException {
		Map<String, Object> velParam = new HashMap<String, Object>();

		Map<String, Object> param = new HashMap<String, Object>();

		DBRowSet dbRowset = null;

		param.put("bkg_no", bkg_no);
		param.put("tro_seq", tro_seq);
		param.put("io_bnd_cd", io_bnd_cd);

		velParam.put("bkg_no", bkg_no);
		velParam.put("tro_seq", tro_seq);
		velParam.put("io_bnd_cd", io_bnd_cd);

		List<BkgEurTroVO> rtnList = new ArrayList<BkgEurTroVO>();

		try {
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BkgCopManageDBDAOSearchBkgEurTroRSQL(), param, velParam);

			rtnList = (List) RowSetUtil.rowSetToVOs(dbRowset, BkgEurTroVO.class);

		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnList;
	}

	/**
	 * @param bkg_no
	 * @param tro_seq
	 * @param tro_sub_seq
	 * @param io_bnd_cd
	 * @return List<BkgEurTroDtlVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<BkgEurTroDtlVO> searchBkgEurTroDtl(String bkg_no, String tro_seq, String tro_sub_seq, String io_bnd_cd) throws DAOException {
		Map<String, Object> velParam = new HashMap<String, Object>();

		Map<String, Object> param = new HashMap<String, Object>();

		DBRowSet dbRowset = null;

		param.put("bkg_no", bkg_no);
		param.put("tro_seq", tro_seq);
		param.put("tro_sub_seq", tro_sub_seq);
		param.put("io_bnd_cd", io_bnd_cd);

		velParam.put("bkg_no", bkg_no);
		velParam.put("tro_seq", tro_seq);
		velParam.put("tro_sub_seq", tro_sub_seq);
		velParam.put("io_bnd_cd", io_bnd_cd);

		List<BkgEurTroDtlVO> rtnList = new ArrayList<BkgEurTroDtlVO>();

		try {
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BkgCopManageDBDAOSearchBkgEurTroDtlRSQL(), param, velParam);

			rtnList = (List) RowSetUtil.rowSetToVOs(dbRowset, BkgEurTroDtlVO.class);

		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnList;
	}

	/**
	 * @param bkg_no
	 * @param tro_seq
	 * @param io_bnd_cd
	 * @return List<BkgTroVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<BkgTroVO> searchBkgTro(String bkg_no, String tro_seq, String io_bnd_cd) throws DAOException {
		Map<String, Object> velParam = new HashMap<String, Object>();

		Map<String, Object> param = new HashMap<String, Object>();

		DBRowSet dbRowset = null;

		param.put("bkg_no", bkg_no);
		param.put("tro_seq", tro_seq);
		param.put("io_bnd_cd", io_bnd_cd);

		velParam.put("bkg_no", bkg_no);
		velParam.put("tro_seq", tro_seq);
		velParam.put("io_bnd_cd", io_bnd_cd);

		List<BkgTroVO> rtnList = new ArrayList<BkgTroVO>();

		try {
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BkgCopManageDBDAOSearchBkgTroRSQL(), param, velParam);

			rtnList = (List) RowSetUtil.rowSetToVOs(dbRowset, BkgTroVO.class);

		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnList;
	}

	/**
	 * @param bkg_no
	 * @param tro_seq
	 * @param tro_sub_seq
	 * @param io_bnd_cd
	 * @return List<BkgTroDtlVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<BkgTroDtlVO> searchBkgTroDtl(String bkg_no, String tro_seq, String tro_sub_seq, String io_bnd_cd) throws DAOException {
		Map<String, Object> velParam = new HashMap<String, Object>();

		Map<String, Object> param = new HashMap<String, Object>();

		DBRowSet dbRowset = null;

		param.put("bkg_no", bkg_no);
		param.put("tro_seq", tro_seq);
		param.put("tro_sub_seq", tro_sub_seq);
		param.put("io_bnd_cd", io_bnd_cd);

		velParam.put("bkg_no", bkg_no);
		velParam.put("tro_seq", tro_seq);
		velParam.put("tro_sub_seq", tro_sub_seq);
		velParam.put("io_bnd_cd", io_bnd_cd);

		List<BkgTroDtlVO> rtnList = new ArrayList<BkgTroDtlVO>();

		try {
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BkgCopManageDBDAOSearchBkgTroDtlRSQL(), param, velParam);

			rtnList = (List) RowSetUtil.rowSetToVOs(dbRowset, BkgTroDtlVO.class);

		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnList;
	}

	/**
	 * @param bkg_no
	 * @return List<BkgQuantityVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<BkgQuantityVO> searchBkgQuantity(String bkg_no) throws DAOException {
		Map<String, Object> velParam = new HashMap<String, Object>();
		Map<String, Object> param = new HashMap<String, Object>();

		DBRowSet dbRowset = null;

		param.put("bkg_no", bkg_no);
		velParam.put("bkg_no", bkg_no);

		List<BkgQuantityVO> rtnList = new ArrayList<BkgQuantityVO>();

		try {
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BkgCopManageDBDAOSearchBkgQuantityRSQL(), param, velParam);

			rtnList = (List) RowSetUtil.rowSetToVOs(dbRowset, BkgQuantityVO.class);

		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnList;
	}

	/**
	 * @param bkg_no
	 * @return List<SearchDiffCntrListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SearchDiffCntrListVO> searchDiffCntrList(String bkg_no) throws DAOException {
		Map<String, Object> velParam = new HashMap<String, Object>();
		Map<String, Object> param = new HashMap<String, Object>();

		DBRowSet dbRowset = null;

		param.put("bkg_no", bkg_no);
		velParam.put("bkg_no", bkg_no);

		List<SearchDiffCntrListVO> rtnList = new ArrayList<SearchDiffCntrListVO>();

		try {
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BkgCopManageDBDAOSearchDiffCntrListRSQL(), param, velParam);

			rtnList = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchDiffCntrListVO.class);

		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnList;
	}

	/**
	 * @return SceBkgOpHisVO
	 * @throws DAOException
	 */
	public SceBkgOpHisVO searchBkgRcvNo() throws DAOException {

		DBRowSet dbRowset = null;

		SceBkgOpHisVO sceBkgOpHisVO = new SceBkgOpHisVO();

		Map<String, Object> velParam = new HashMap<String, Object>();

		Map<String, Object> param = new HashMap<String, Object>();

		try {
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BkgCopManageDBDAOSearchBkgRcvNoRSQL(), param, velParam);

			if (dbRowset.next()) {
				sceBkgOpHisVO.setBkgRcvDt(dbRowset.getString("BKG_RCV_DT"));
				sceBkgOpHisVO.setBkgRcvNo(dbRowset.getString("BKG_RCV_NO"));
			}

		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return sceBkgOpHisVO;
	}

	/**
	 * @param pctl_no
	 * @return String
	 * @throws DAOException
	 */
	public String searchCopRailChk(String pctl_no) throws DAOException {
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		param.put("pctl_no", pctl_no);

		String rtnCopRailChkCd = "";

		try {

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ReplanManageDBDAOSearchCopRailChkRSQL(), param, velParam);

			if (dbRowset.next())
				rtnCopRailChkCd = dbRowset.getString("COP_RAIL_CHK_CD");

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnCopRailChkCd;
	}

	/**
	 * @param bkg_no
	 * @return List<SceCopHdrVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SceCopHdrVO> searchCopHdrByBkgNos(String[] bkg_no) throws DAOException {
		Map<String, Object> velParam = new HashMap<String, Object>();

		Map<String, Object> param = new HashMap<String, Object>();

		DBRowSet dbRowset = null;

		param.put("bkg_no", bkg_no);
		velParam.put("bkg_no", bkg_no);

		List<SceCopHdrVO> rtnList = new ArrayList<SceCopHdrVO>();

		try {
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BkgCopManageDBDAOSearchCopHdrByBkgNosRSQL(), param, velParam);

			rtnList = (List) RowSetUtil.rowSetToVOs(dbRowset, SceCopHdrVO.class);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnList;
	}

	/**
	 * @param bkg_no
	 * @param cntr_no
	 * @param cop_sts
	 * @return List<SceCopHdrVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SceCopHdrVO> searchPartialCops(String bkg_no, String cntr_no, String cop_sts) throws DAOException {
		DBRowSet dbRowset = null;
		List<SceCopHdrVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		param.put("cntr_no", cntr_no);
		velParam.put("cntr_no", cntr_no);

		param.put("sts_flg", cop_sts);
		velParam.put("sts_flg", cop_sts);

		param.put("bkg_no", bkg_no);
		velParam.put("bkg_no", bkg_no);

		try {

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ReplanManageDBDAOSearchPartialCopsRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SceCopHdrVO.class);
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
	 * @param bkg_no
	 * @return List<Search315VEToBeSentVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<Search315VEToBeSentVO> search315VEToBeSent(String bkg_no) throws DAOException {
		DBRowSet dbRowset = null;
		List<Search315VEToBeSentVO> list = new ArrayList<Search315VEToBeSentVO>();
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		param.put("bkg_no", bkg_no);
		velParam.put("bkg_no", bkg_no);

		try {
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BkgCopManageDBDAOSearch315VEToBeSentRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, Search315VEToBeSentVO.class);
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
	 * @param bkg_no
	 * @return boolean
	 * @throws DAOException
	 */

	public boolean checkExecBackEndJob(String bkg_no) throws DAOException {
		DBRowSet dbRowset = null;
		boolean returnFlg = false;

		Map<String, Object> param = new HashMap<String, Object>();

		param.put("bkg_no", bkg_no);

		try {
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BkgCopManageDBDAOCheckExecBackEndJobRSQL(), param, param);
			if (dbRowset.next()) {
				returnFlg = true;
			}

			log.info("\ncheckExecBackEndJob-result=" + returnFlg);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return returnFlg;
	}

	/**
	 * @param bkg_no
	 * @return List<SearchCopCntLimitVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SearchCopCntLimitVO> searchCopCntLimit(String bkg_no) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchCopCntLimitVO> list = new ArrayList<SearchCopCntLimitVO>();
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		param.put("bkg_no", bkg_no);
		velParam.put("bkg_no", bkg_no);

		try {
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BkgCopManageDBDAOSearchCopCntLimitRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchCopCntLimitVO.class);
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
	 * @param cop_no
	 * @return List<TrsTrspSvcOrdVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<TrsTrspSvcOrdVO> searchOdSoByCop(String cop_no) throws DAOException {
		DBRowSet dbRowset = null;
		List<TrsTrspSvcOrdVO> list = new ArrayList<TrsTrspSvcOrdVO>();
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		param.put("cop_no", cop_no);
		velParam.put("cop_no", cop_no);

		try {
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BkgCopManageDBDAOSearchOdSoByCopRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, TrsTrspSvcOrdVO.class);
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
	 * @param bkg_no
	 * @return List<SceCopHdrVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SceCopHdrVO> searchRailRcvCoffDt(String bkg_no) throws DAOException {
		DBRowSet dbRowset = null;
		List<SceCopHdrVO> list = new ArrayList<SceCopHdrVO>();
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		param.put("bkg_no", bkg_no);
		velParam.put("bkg_no", bkg_no);

		try {
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BkgCopManageDBDAOSearchRailRcvCoffDtRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SceCopHdrVO.class);
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
	 * @param cntr_no
	 * @return List<MstContainerVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<MstContainerVO> searchMstContainer(String cntr_no) throws DAOException {
		DBRowSet dbRowset = null;
		List<MstContainerVO> list = new ArrayList<MstContainerVO>();
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		param.put("cntr_no", cntr_no);
		velParam.put("cntr_no", cntr_no);

		try {
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BkgCopManageDBDAOSearchMstContainerRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, MstContainerVO.class);
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
	 * @param bkg_no
	 * @param cntr_no
	 * @return List<SceCopHdrVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SceCopHdrVO> searchPrivBkgCntr(String bkg_no, String cntr_no) throws DAOException {
		DBRowSet dbRowset = null;
		List<SceCopHdrVO> list = new ArrayList<SceCopHdrVO>();
		// query parameter
		Map<String, String> param = new HashMap<String, String>();
		// velocity parameter
		Map<String, String> velParam = new HashMap<String, String>();

		param.put("cntr_no", cntr_no);
		velParam.put("cntr_no", cntr_no);

		param.put("bkg_no", bkg_no);
		velParam.put("bkg_no", bkg_no);

		try {
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BkgCopManageDBDAOSearchPrivBkgCntrRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SceCopHdrVO.class);
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
	 * @param cop_no
	 * @return List<SceActRcvIfVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SceActRcvIfVO> searchActualToBeUpdated(String cop_no) throws DAOException {
		DBRowSet dbRowset = null;
		List<SceActRcvIfVO> list = new ArrayList<SceActRcvIfVO>();
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		param.put("cop_no", cop_no);
		velParam.put("cop_no", cop_no);

		try {
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ReplanManageDBDAOSearchActualToBeUpdatedRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SceActRcvIfVO.class);
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
	 * @param bkg_no
	 * @param cntr_no
	 * @param cop_no
	 * @return List<SceActRcvIfVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SceActRcvIfVO> searchActualToBeUpdated(String bkg_no, String cntr_no, String cop_no) throws DAOException {
		DBRowSet dbRowset = null;
		List<SceActRcvIfVO> list = new ArrayList<SceActRcvIfVO>();
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		param.put("bkg_no", bkg_no);
		param.put("cntr_no", cntr_no);
		param.put("cop_no", cop_no);

		velParam.put("bkg_no", bkg_no);
		velParam.put("cntr_no", cntr_no);
		velParam.put("cop_no", cop_no);

		try {
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ReplanManageDBDAOSearchActualToBeUpdatedRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SceActRcvIfVO.class);
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
	 * @param bkg_no
	 * @return List<BkgBookingVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<BkgBookingVO> searchBfCombineBkgInfo(String bkg_no) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgBookingVO> list = new ArrayList<BkgBookingVO>();
		// TrsTrspSvcOrdVO rtnVO = new TrsTrspSvcOrdVO();
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		param.put("bkg_no", bkg_no);
		velParam.put("bkg_no", bkg_no);

		try {

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ReplanManageDBDAOSearchBfCombineBkgInfoRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, BkgBookingVO.class);

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
	 * @param bkg_no
	 * @param cntr_no
	 * @return List<SceCopHdrVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SceCopHdrVO> searchBfSplitCopInfo(String bkg_no, String cntr_no) throws DAOException {
		DBRowSet dbRowset = null;
		List<SceCopHdrVO> list = new ArrayList<SceCopHdrVO>();
		// TrsTrspSvcOrdVO rtnVO = new TrsTrspSvcOrdVO();
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		param.put("bkg_no", bkg_no);
		param.put("cntr_no", cntr_no);
		velParam.put("bkg_no", bkg_no);
		velParam.put("cntr_no", cntr_no);

		try {

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BkgCopManageDBDAOSearchBfSplitCopInfoRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SceCopHdrVO.class);

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
	 * @param bkg_no
	 * @return List<BkgBookingVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<BkgBookingVO> searchBfSplitBkgInfo(String bkg_no) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgBookingVO> list = new ArrayList<BkgBookingVO>();
		// TrsTrspSvcOrdVO rtnVO = new TrsTrspSvcOrdVO();
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		param.put("bkg_no", bkg_no);
		velParam.put("bkg_no", bkg_no);

		try {

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BkgCopManageDBDAOSearchBfSplitBkgInfoRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, BkgBookingVO.class);

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
	 * @param mapvo
	 * @return List<SceCopHdrVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SceCopHdrVO> searchPartialBkgBfBkgSplit(PrdBkgCopMapVO mapvo) throws DAOException {
		DBRowSet dbRowset = null;
		List<SceCopHdrVO> list = new ArrayList<SceCopHdrVO>();
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		param.put("cop_no", mapvo.getCopNo());
		param.put("bkg_no", mapvo.getBkgNo());
		param.put("cntr_no", mapvo.getCntrNo());
		velParam.putAll(param);

		try {

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BkgCopManageDBDAOsearchPartialBkgBfBkgSplitRSQL(), param, velParam);

			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SceCopHdrVO.class);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	// SearchPorForSendBF_

	/**
	 * @param bkg_no
	 * @param cntr_no
	 * @return List<SearchPorForSendBFVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SearchPorForSendBFVO> searchPorForSendBF(String bkg_no, String cntr_no) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchPorForSendBFVO> list = new ArrayList<SearchPorForSendBFVO>();
		// TrsTrspSvcOrdVO rtnVO = new TrsTrspSvcOrdVO();
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		param.put("bkg_no", bkg_no);
		velParam.put("bkg_no", bkg_no);

		param.put("cntr_no", cntr_no);
		velParam.put("cntr_no", cntr_no);

		try {

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BkgCopManageDBDAOSearchPorForSendBFRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchPorForSendBFVO.class);

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
	 * @param bkg_no
	 * @param cntr_no
	 * @return SceCopDtlVO
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public SceCopDtlVO searchNodSysDtForCX(String bkg_no, String cntr_no) throws DAOException {
		Map<String, String> velParam = new HashMap<String, String>();
		Map<String, String> param = new HashMap<String, String>();

		DBRowSet dbRowset = null;

		param.put("bkg_no", bkg_no);
		param.put("cntr_no", cntr_no);

		velParam.put("bkg_no", bkg_no);
		velParam.put("cntr_no", cntr_no);

		List<SceCopDtlVO> rtnList = new ArrayList<SceCopDtlVO>();

		try {
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BkgCopManageDBDAOSearchNodSysDtForCXRSQL(), param, velParam);

			rtnList = (List) RowSetUtil.rowSetToVOs(dbRowset, SceCopDtlVO.class);

		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnList.size() >= 1 ? rtnList.get(0) : new SceCopDtlVO();

	}

	/**
	 * @param bkg_no
	 * @param cntr_no
	 * @return SceCopDtlVO
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public SceCopDtlVO searchVDLSendHistory(String bkg_no, String cntr_no) throws DAOException {
		Map<String, String> velParam = new HashMap<String, String>();
		Map<String, String> param = new HashMap<String, String>();

		DBRowSet dbRowset = null;

		param.put("bkg_no", bkg_no);
		param.put("cntr_no", cntr_no);

		velParam.put("bkg_no", bkg_no);
		velParam.put("cntr_no", cntr_no);

		List<SceCopDtlVO> rtnList = new ArrayList<SceCopDtlVO>();

		try {
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BkgCopManageDBDAOSearchVDLSendHistoryRSQL(), param, velParam);

			rtnList = (List) RowSetUtil.rowSetToVOs(dbRowset, SceCopDtlVO.class);

		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnList.size() >= 1 ? rtnList.get(0) : new SceCopDtlVO();

	}

	/**
	 * @param dtlVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchLstATDForSendVDL(SceCopDtlVO dtlVO) throws DAOException {
		Map<String, String> velParam = new HashMap<String, String>();
		Map<String, String> param = new HashMap<String, String>();

		DBRowSet dbRowset = null;

		String act_dt = "";

		velParam.putAll(dtlVO.getColumnValues());
		param.putAll(dtlVO.getColumnValues());

		try {
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BkgCopManageDBDAOSearchLstATDForSendVDLRSQL(), param, velParam);

			if (dbRowset.next()) {
				act_dt = dbRowset.getString("ACT_DT");
			}
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return act_dt;

	}

	/**
	 * @param cop_no
	 * @return List<ScePlnSoListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<ScePlnSoListVO> searchPlnSoList(String cop_no) throws DAOException {
		Map<String, String> velParam = new HashMap<String, String>();
		Map<String, String> param = new HashMap<String, String>();

		DBRowSet dbRowset = null;

		param.put("cop_no", cop_no);
		velParam.put("cop_no", cop_no);

		List<ScePlnSoListVO> rtnList = new ArrayList<ScePlnSoListVO>();

		try {
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BkgCopManageDBDAOSearchPlnSoListRSQL(), param, velParam);

			rtnList = (List) RowSetUtil.rowSetToVOs(dbRowset, ScePlnSoListVO.class);

		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnList;
	}

	/**
	 * @param fm_dt
	 * @param to_dt
	 * @return List<SceActTmlRtvVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SceActTmlRtvVO> searchActTmlIfDtl(String fm_dt, String to_dt) throws DAOException {
		Map<String, String> velParam = new HashMap<String, String>();
		Map<String, String> param = new HashMap<String, String>();

		DBRowSet dbRowset = null;

		param.put("fm_dt", fm_dt);
		param.put("to_dt", to_dt);

		velParam.put("fm_dt", fm_dt);
		velParam.put("to_dt", to_dt);

		List<SceActTmlRtvVO> rtnList = new ArrayList<SceActTmlRtvVO>();

		try {
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BkgCopManageDBDAOSearchActTmlIfDtlRSQL(), param, velParam);

			rtnList = (List) RowSetUtil.rowSetToVOs(dbRowset, SceActTmlRtvVO.class);

		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnList;
	}

	/**
	 * @param fm_dt
	 * @param to_dt
	 * @return List<SceCopHdrVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SceCopHdrVO> searchMstCopNoDiff(String fm_dt, String to_dt) throws DAOException {
		Map<String, String> velParam = new HashMap<String, String>();
		Map<String, String> param = new HashMap<String, String>();

		DBRowSet dbRowset = null;

		param.put("fm_dt", fm_dt);
		param.put("to_dt", to_dt);

		velParam.put("fm_dt", fm_dt);
		velParam.put("to_dt", to_dt);

		List<SceCopHdrVO> rtnList = new ArrayList<SceCopHdrVO>();

		try {
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BkgCopManageDBDAOSearchMstCopNoDiffRSQL(), param, velParam);

			rtnList = (List) RowSetUtil.rowSetToVOs(dbRowset, SceCopHdrVO.class);

		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnList;
	}

	/**
	 * @param fm_dt
	 * @param to_dt
	 * @return List<CntrDiffVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<CntrDiffVO> searchCntrDiff(String fm_dt, String to_dt) throws DAOException {
		Map<String, String> velParam = new HashMap<String, String>();
		Map<String, String> param = new HashMap<String, String>();

		DBRowSet dbRowset = null;

		param.put("fm_dt", fm_dt);
		param.put("to_dt", to_dt);

		velParam.put("fm_dt", fm_dt);
		velParam.put("to_dt", to_dt);

		List<CntrDiffVO> rtnList = new ArrayList<CntrDiffVO>();

		try {
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BkgCopManageDBDAOSearchCntrDiffRSQL(), param, velParam);

			rtnList = (List) RowSetUtil.rowSetToVOs(dbRowset, CntrDiffVO.class);

		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnList;
	}

	/**
	 * cop_no 로 부터 tro 정보를 인계받을 cop 를 선정한다.
	 * @param String cop_no
	 * @param String src_cd
	 * @return SceCopHdrVO
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public SceCopHdrVO searchCopToRcvTro(String cop_no, String src_cd) throws DAOException {
		Map<String, String> velParam = new HashMap<String, String>();
		Map<String, String> param = new HashMap<String, String>();

		DBRowSet dbRowset = null;

		velParam.put("cop_no", cop_no);
		velParam.put("src_cd", src_cd);
		param.put("cop_no", cop_no);

		List<SceCopHdrVO> rtnList = new ArrayList<SceCopHdrVO>();
		SceCopHdrVO rtnVO = new SceCopHdrVO();

		try {
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BkgCopManageDBDAOSearchCopToRcvTroRSQL(), param, velParam);

			if (dbRowset.getRowCount() >= 1) {
				rtnList = (List) RowSetUtil.rowSetToVOs(dbRowset, SceCopHdrVO.class);

				rtnVO = rtnList.get(0);
			}
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnVO;
	}

	/**
	 * @param bkg_no
	 * @param cntr_no
	 * @param edi_sts_cd
	 * @return int
	 * @throws DAOException
	 */
	public int validateEdiSndRslt(String bkg_no, String cntr_no, String edi_sts_cd) throws DAOException {
		Map<String, String> velParam = new HashMap<String, String>();

		Map<String, String> param = new HashMap<String, String>();

		DBRowSet dbRowset = null;

		param.put("cntr_no", cntr_no);
		param.put("bkg_no", bkg_no);
		param.put("edi_sts_cd", edi_sts_cd);

		int rsltCnt = 0;

		try {
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BkgCopManageDBDAOValidateEdiSndRsltRSQL(), param, velParam);
			if (dbRowset.next())
				rsltCnt = dbRowset.getInt("CNT");
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rsltCnt;
	}

	/**
	 * @param bkg_no
	 * @param cntr_no
	 * @return int
	 * @throws DAOException
	 */
	public int validateLeaCntrBkgHis(String bkg_no, String cntr_no) throws DAOException {
		Map<String, String> velParam = new HashMap<String, String>();

		Map<String, String> param = new HashMap<String, String>();

		DBRowSet dbRowset = null;

		param.put("cntr_no", cntr_no);
		param.put("bkg_no", bkg_no);

		int rsltCnt = 0;

		try {
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BkgCopManageDBDAOValidateLeaCntrBkgHisRSQL(), param, velParam);
			if (dbRowset.next())
				rsltCnt = dbRowset.getInt("CNT");
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rsltCnt;
	}

	/**
	 * @param org_cop_no
	 * @param dest_cop_no
	 * @return boolean
	 * @throws DAOException
	 */
	public boolean searchDiffRoute(String org_cop_no, String dest_cop_no) throws DAOException {
		Map<String, String> velParam = new HashMap<String, String>();
		Map<String, String> param = new HashMap<String, String>();

		DBRowSet dbRowset = null;

		param.put("org_cop_no", org_cop_no);
		param.put("dest_cop_no", dest_cop_no);

		velParam.put("org_cop_no", org_cop_no);
		velParam.put("dest_cop_no", dest_cop_no);

		boolean rtnRslt = false;

		try {
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BkgCopManageDBDAOSearchDiffRouteRSQL(), param, velParam);

			rtnRslt = dbRowset.next();

		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnRslt;
	}

	/**
	 * @param bkg_no
	 * @return List<SceCopHdrVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SceCopHdrVO> searchNoCntrObTroCopsRSQL(String bkg_no) throws DAOException {
		Map<String, String> velParam = new HashMap<String, String>();
		Map<String, String> param = new HashMap<String, String>();

		List<SceCopHdrVO> rtnList = new ArrayList<SceCopHdrVO>();

		DBRowSet dbRowset = null;

		param.put("bkg_no", bkg_no);

		velParam.put("bkg_no", bkg_no);

		try {
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BkgCopManageDBDAOSearchNoCntrObTroCopsRSQL(), param, velParam);

			rtnList = (List) RowSetUtil.rowSetToVOs(dbRowset, SceCopHdrVO.class);

		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnList;
	}

	/**
	 * od-so 구간의 route 정보 중 diff 부분이 있는지 확인한다. diff 가 있어 data 존재시 true / 없으면 data 미 존재로 false
	 * @param String fm_cop_no
	 * @param String to_cop_no
	 * @return boolean
	 * @throws DAOException
	 */
	public boolean checkOdRouteDiff(String fm_cop_no, String to_cop_no) throws DAOException {
		Map<String, String> velParam = new HashMap<String, String>();
		Map<String, String> param = new HashMap<String, String>();

		DBRowSet dbRowset = null;

		param.put("fm_cop_no", fm_cop_no);
		param.put("to_cop_no", to_cop_no);

		velParam.put("fm_cop_no", fm_cop_no);
		velParam.put("to_cop_no", to_cop_no);

		boolean rtnRslt = false;

		try {
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BkgCopManageDBDAOCheckOdRouteDiffRSQL(), param, velParam);

			rtnRslt = dbRowset.next();

		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnRslt;
	}

	/**
	 * @param cop_no
	 * @return boolean : cancel 되어야 하면 true
	 * @throws DAOException
	 */
	public boolean checkCopToBeCanceled(String cop_no) throws DAOException {
		Map<String, String> velParam = new HashMap<String, String>();
		Map<String, String> param = new HashMap<String, String>();

		DBRowSet dbRowset = null;

		param.put("cop_no", cop_no);

		velParam.put("cop_no", cop_no);

		boolean rtnRslt = false;

		try {
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BkgCopManageDBDAOCheckCopToBeCanceledRSQL(), param, velParam);

			if (dbRowset.next()) {
				String rslt = dbRowset.getString("CHK_RSLT");
				log.debug("check rslt = " + rslt);
				rtnRslt = rslt.equals("CANCEL");
			}

		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnRslt;
	}

	/**
	 * @param sceTroMapgVOs
	 * @return int
	 * @throws DAOException
	 */
	public int addTroInfo(List<SceTroMapgVO> sceTroMapgVOs) throws DAOException {
		int rowCnt = 0;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");

			for (int i = 0; i < sceTroMapgVOs.size(); i++) {
				Map<String, Object> param = new HashMap<String, Object>();
				Map<String, Object> velParam = new HashMap<String, Object>();

				SceTroMapgVO troMapg = sceTroMapgVOs.get(i);

				param.put("cop_no", troMapg.getCopNo());
				param.put("io_bnd_cd", troMapg.getIoBndCd());
				param.put("area_conti_cd", troMapg.getAreaContiCd());
				param.put("bkg_no", troMapg.getBkgNo());
				param.put("tro_seq", troMapg.getTroSeq());
				param.put("tro_sub_seq", troMapg.getTroSubSeq());

				velParam.put("cop_no", troMapg.getCopNo());
				velParam.put("io_bnd_cd", troMapg.getIoBndCd());
				velParam.put("area_conti_cd", troMapg.getAreaContiCd());
				velParam.put("bkg_no", troMapg.getBkgNo());
				velParam.put("tro_seq", troMapg.getTroSeq());
				velParam.put("tro_sub_seq", troMapg.getTroSubSeq());

				rowCnt = sqlExe.executeUpdate(new BkgCopManageDBDAOAddTROInfoCSQL(), param, velParam);
			}

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rowCnt;
	}

	/**
	 * @param sceCopHdrVO
	 * @param prtlBkgList
	 * @param cre_usr_id
	 * @return int
	 * @throws DAOException
	 */
	public int addSceActRcvIfBySplit(SceCopHdrVO sceCopHdrVO, List<String> prtlBkgList, String cre_usr_id) throws DAOException {
		int rowCnt = 0;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");

			Map<String, Object> param = new HashMap<String, Object>();
			Map<String, Object> velParam = new HashMap<String, Object>();

			param.put("new_bkg_no", sceCopHdrVO.getBkgNo());

			param.put("cntr_no", sceCopHdrVO.getCntrNo());
			param.put("cop_no", sceCopHdrVO.getCopNo());
			param.put("bkg_no", prtlBkgList.toArray());
			param.put("cre_usr_id", cre_usr_id);

			velParam.put("new_bkg_no", sceCopHdrVO.getBkgNo());

			velParam.put("cntr_no", sceCopHdrVO.getCntrNo());
			velParam.put("cop_no", sceCopHdrVO.getCopNo());
			velParam.put("bkg_no", prtlBkgList.toArray());
			velParam.put("cre_usr_id", cre_usr_id);

			rowCnt = sqlExe.executeUpdate(new BkgCopManageDBDAOAddSceActRcvIfBySplitCSQL(), param, velParam);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rowCnt;
	}

	/**
	 * @param sceCopHdrVO
	 * @param prtlBkgList
	 * @param user_id
	 * @return int
	 * @throws DAOException
	 */
	public int copySceActRcvIfBySplit(SceCopHdrVO sceCopHdrVO, List<SceCopHdrVO> prtlBkgList, String user_id) throws DAOException {
		int rowCnt = 0;
		try {
			if (SCEConstants.PSEUDO_CNTR_NO.equals(sceCopHdrVO.getCntrNo())) {
				return 0;
			}
			Map<String, Object> param = new HashMap<String, Object>();
			Map<String, Object> velParam = new HashMap<String, Object>();
			Set<String> bkgArray = new HashSet<String>();
			Set<String> copArray = new HashSet<String>();
			for (int i = 0; i < prtlBkgList.size(); i++) {
				SceCopHdrVO sceCop = prtlBkgList.get(i);
				bkgArray.add(sceCop.getBkgNo());
				copArray.add(sceCop.getCopNo());
			}
			param.put("new_bkg_no", sceCopHdrVO.getBkgNo());
			param.put("cntr_no", sceCopHdrVO.getCntrNo());
			param.put("new_cop_no", sceCopHdrVO.getCopNo());
			param.put("user_id", user_id);
			param.put("old_prtl_bkg_list", bkgArray.toArray());
			param.put("old_prtl_cop_list", copArray.toArray());

			velParam.putAll(param);
			rowCnt = new SQLExecuter().executeUpdate(new BkgCopManageDBDAOCopySceActRcvIfBySplitCSQL(), param, velParam);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rowCnt;
	}

	/**
	 * @param sceCopHdrVO
	 * @param prtlBkgList
	 * @param user_id
	 * @return int
	 * @throws DAOException
	 */
	public int copySceActRcvIfByOneTime(SceCopHdrVO sceCopHdrVO, List<SceCopHdrVO> prtlBkgList, String user_id) throws DAOException {
		int rowCnt = 0;
		try {
			if (SCEConstants.PSEUDO_CNTR_NO.equals(sceCopHdrVO.getCntrNo())) {
				return 0;
			}
			Map<String, Object> param = new HashMap<String, Object>();
			Map<String, Object> velParam = new HashMap<String, Object>();
			Set<String> bkgArray = new HashSet<String>();
			Set<String> copArray = new HashSet<String>();
			
			for (int i = 0; i < prtlBkgList.size(); i++) {
				SceCopHdrVO sceCop = prtlBkgList.get(i);
				bkgArray.add(sceCop.getBkgNo());
				copArray.add(sceCop.getCopNo());
			}

			param.put("new_bkg_no", sceCopHdrVO.getBkgNo());
			param.put("old_prtl_bkg_list", bkgArray.toArray());
			param.put("old_prtl_cop_list", copArray.toArray());
			param.put("cntr_no", sceCopHdrVO.getCntrNo());
			param.put("new_cop_no", sceCopHdrVO.getCopNo());
			param.put("user_id", user_id);

			velParam.putAll(param);
			rowCnt = new SQLExecuter().executeUpdate(new BkgCopManageDBDAOCopySceActRcvIfByOnetimeCSQL(), param, velParam);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rowCnt;
	}

	/**
	 * @param sceCopHdrVOList
	 * @return int
	 * @throws DAOException
	 */
	public int addCopHdr(List<SceCopHdrVO> sceCopHdrVOList) throws DAOException {
		int[] updCnt = null;

		int rowCnt = 0;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");

			updCnt = sqlExe.executeBatch(new BkgCopManageDBDAOAddCopHdrByValuesCSQL(), sceCopHdrVOList, null);
			for (int i = 0; i < updCnt.length; i++) {
				if (updCnt[i] == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update No" + i + " SQL");
				else {
					rowCnt += updCnt[i];
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rowCnt;
	}

	/**
	 * @param sceCopHdrVO
	 * @return int
	 * @throws DAOException
	 */
	public int addCopHdr(SceCopHdrVO sceCopHdrVO) throws DAOException {

		int rowCnt = 0;

		Map<String, String> velParam = new HashMap<String, String>();

		Map<String, String> param = new HashMap<String, String>();

		param.putAll(sceCopHdrVO.getColumnValues());
		velParam.putAll(sceCopHdrVO.getColumnValues());

		try {
			SQLExecuter sqlExe = new SQLExecuter("");

			rowCnt = sqlExe.executeUpdate(new BkgCopManageDBDAOAddCopHdrByValuesCSQL(), param, velParam);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rowCnt;
	}

	/**
	 * @param cop_no
	 * @param org_cop_no
	 * @return int
	 * @throws DAOException
	 */
	public int copyPlnSoList(String cop_no, String org_cop_no) throws DAOException {

		int rowCnt = 0;

		Map<String, String> velParam = new HashMap<String, String>();

		Map<String, String> param = new HashMap<String, String>();

		param.put("cop_no", cop_no);
		param.put("org_cop_no", org_cop_no);

		velParam.put("cop_no", cop_no);
		velParam.put("org_cop_no", org_cop_no);

		try {
			SQLExecuter sqlExe = new SQLExecuter("");

			rowCnt = sqlExe.executeUpdate(new BkgCopManageDBDAOCopyPlnSoListCSQL(), param, velParam);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rowCnt;
	}

	/**
	 * @param cop_no
	 * @param org_cop_no
	 * @return int
	 * @throws DAOException
	 */
	public int copyCopDtl(String cop_no, String org_cop_no) throws DAOException {

		int rowCnt = 0;

		Map<String, String> velParam = new HashMap<String, String>();

		Map<String, String> param = new HashMap<String, String>();

		param.put("cop_no", cop_no);
		param.put("org_cop_no", org_cop_no);

		velParam.put("cop_no", cop_no);
		velParam.put("org_cop_no", org_cop_no);

		try {
			SQLExecuter sqlExe = new SQLExecuter("");

			rowCnt = sqlExe.executeUpdate(new BkgCopManageDBDAOCopyCopDtlCSQL(), param, velParam);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rowCnt;
	}

	/**
	 * @param sceBkgOpHisVO
	 * @return int
	 * @throws DAOException
	 */
	public int addBkgOpHis(SceBkgOpHisVO sceBkgOpHisVO) throws DAOException {

		int rowCnt = 0;
		try {
			Map<String, String> velParam = new HashMap<String, String>();

			Map<String, String> param = new HashMap<String, String>();

			velParam.putAll(sceBkgOpHisVO.getColumnValues());
			param.putAll(sceBkgOpHisVO.getColumnValues());

			rowCnt = new SQLExecuter("").executeUpdate((ISQLTemplate) new BkgCopManageDBDAOAddBkgOpHisCSQL(), param, velParam);

			if (rowCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update No" + rowCnt + " SQL");

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rowCnt;
	}

	/**
	 * @param sceBkgOpHisVO
	 * @return int
	 * @throws DAOException
	 */
	public int addBkgOpPara(SceBkgOpParaVO sceBkgOpHisVO) throws DAOException {

		int rowCnt = 0;
		try {
			Map<String, String> velParam = new HashMap<String, String>();

			Map<String, String> param = new HashMap<String, String>();

			param.putAll(sceBkgOpHisVO.getColumnValues());
			velParam.putAll(sceBkgOpHisVO.getColumnValues());

			rowCnt = new SQLExecuter("").executeUpdate((ISQLTemplate) new BkgCopManageDBDAOAddBkgOpParaCSQL(), param, velParam);

			if (rowCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update No" + rowCnt + " SQL");

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rowCnt;
	}

	/**
	 * @param leaCntrBkgHisVO
	 * @return int
	 * @throws DAOException
	 */
	public int addLeaCntrBkgHis(LeaCntrBkgHisVO leaCntrBkgHisVO) throws DAOException {

		int rowCnt = 0;
		try {
			Map<String, String> velParam = new HashMap<String, String>();

			Map<String, String> param = new HashMap<String, String>();

			param.putAll(leaCntrBkgHisVO.getColumnValues());
			velParam.putAll(leaCntrBkgHisVO.getColumnValues());

			rowCnt = new SQLExecuter("").executeUpdate((ISQLTemplate) new BkgCopManageDBDAOAddLeaCntrBkgHisCSQL(), param, velParam);

			if (rowCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update No" + rowCnt + " SQL");

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rowCnt;
	}

	/**
	 * @param sceCopHdrVOs
	 * @return int[]
	 * @throws DAOException
	 */
	public int modifyCopHdr(List<SceCopHdrVO> sceCopHdrVOs) throws DAOException {
		int rowCnt = 0;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			for (int i = 0; i < sceCopHdrVOs.size(); i++) {
				SceCopHdrVO sceCopHdrVO = sceCopHdrVOs.get(i);
				Map<String, Object> param = new HashMap<String, Object>();
				Map<String, Object> velParam = new HashMap<String, Object>();

				param.putAll(sceCopHdrVO.getColumnValues());
				velParam.putAll(sceCopHdrVO.getColumnValues());

				int sub_rowCnt = sqlExe.executeUpdate(new BkgCopManageDBDAOModifyCopHdrUSQL(), param, velParam);

				if (sub_rowCnt == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update No" + rowCnt + " SQL");
				else
					rowCnt += sub_rowCnt;
			}

			// rowCnt = new SQLExecuter("").executeUpdate((ISQLTemplate) new BkgCopManageDBDAOAddCopHdrCSQL(), param, velParam);

			// if(rowCnt == Statement.EXECUTE_FAILED)
			// throw new DAOException("Fail to update No"+ rowCnt + " SQL");

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rowCnt;
	}

	/**
	 * @param sceCopHdrVO
	 * @return int
	 * @throws DAOException
	 */
	public int modifyCopHdr(SceCopHdrVO sceCopHdrVO) throws DAOException {

		int rowCnt = 0;
		try {
			Map<String, Object> param = new HashMap<String, Object>();
			Map<String, Object> velParam = new HashMap<String, Object>();

			param.putAll(sceCopHdrVO.getColumnValues());
			velParam.putAll(sceCopHdrVO.getColumnValues());

			rowCnt = new SQLExecuter("").executeUpdate((ISQLTemplate) new BkgCopManageDBDAOModifyCopHdrUSQL(), param, velParam);

			if (rowCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update No" + rowCnt + " SQL");

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rowCnt;
	}

	/**
	 * @param sceCopDtlVOs
	 * @return int
	 * @throws DAOException
	 */
	public int modifyCopDtl(List<SceCopDtlVO> sceCopDtlVOs) throws DAOException {
		int[] updCnt = null;

		int rowCnt = 0;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");

			updCnt = sqlExe.executeBatch(new BkgCopManageDBDAOModifyCopDtlUSQL(), sceCopDtlVOs, null);
			for (int i = 0; i < updCnt.length; i++) {
				if (updCnt[i] == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update No" + i + " SQL");
				else
					rowCnt += updCnt[i];
			}

			// rowCnt = new SQLExecuter("").executeUpdate((ISQLTemplate) new BkgCopManageDBDAOAddCopHdrCSQL(), param, velParam);

			// if(rowCnt == Statement.EXECUTE_FAILED)
			// throw new DAOException("Fail to update No"+ rowCnt + " SQL");

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rowCnt;
	}

	/**
	 * @param sceTroMapgVOList
	 * @return int
	 * @throws DAOException
	 */
	public int modifyTroMapgByCop(List<SceTroMapgVO> sceTroMapgVOList) throws DAOException {
		int[] updCnt = null;

		int rowCnt = 0;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");

			updCnt = sqlExe.executeBatch(new BkgCopManageDBDAOModifyTroMapgByCopUSQL(), sceTroMapgVOList, null);
			for (int i = 0; i < updCnt.length; i++) {
				if (updCnt[i] == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update No" + i + " SQL");
				else
					rowCnt += updCnt[i];
			}

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rowCnt;
	}

	/**
	 * @param combineTroNewSeqVOs
	 * @return int
	 * @throws DAOException
	 */
	public int modifyTroMapgByNewSeqVO(List<CombineTroNewSeqVO> combineTroNewSeqVOs) throws DAOException {
		int[] updCnt = null;

		int rowCnt = 0;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");

			updCnt = sqlExe.executeBatch(new BkgCopManageDBDAOModifyTroMapgByNewSeqVOUSQL(), combineTroNewSeqVOs, null);
			for (int i = 0; i < updCnt.length; i++) {
				if (updCnt[i] == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update No" + i + " SQL");
				else
					rowCnt += updCnt[i];
			}

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rowCnt;
	}

	/**
	 * @param combineTroNewSeqVOs
	 * @return int
	 * @throws DAOException
	 */
	public int modifyOdSoByNewVO(List<CombineTroNewSeqVO> combineTroNewSeqVOs) throws DAOException {
		int[] updCnt = null;

		int rowCnt = 0;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");

			updCnt = sqlExe.executeBatch(new BkgCopManageDBDAOModifyOdSoByNewVOUSQL(), combineTroNewSeqVOs, null);
			for (int i = 0; i < updCnt.length; i++) {
				if (updCnt[i] == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update No" + i + " SQL");
				else
					rowCnt += updCnt[i];
			}

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rowCnt;
	}

	/**
	 * @param cop_no
	 * @return int
	 * @throws DAOException
	 */
	public int modifyCopDtlForActReMap(String cop_no) throws DAOException {
		int rowCnt = 0;
		try {
			Map<String, Object> param = new HashMap<String, Object>();
			Map<String, Object> velParam = new HashMap<String, Object>();

			param.put("cop_no", cop_no);
			velParam.put("cop_no", cop_no);

			rowCnt = new SQLExecuter("").executeUpdate((ISQLTemplate) new BkgCopManageDBDAOModifyCopDtlForActReMapUSQL(), param, velParam);

			if (rowCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update No" + rowCnt + " SQL");

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rowCnt;
	}

	/**
	 * @param toBeSoUpdList
	 * @return int
	 * @throws DAOException
	 */
	public int modifySvcOrdBkgNo(List<TrsTrspSvcOrdVO> toBeSoUpdList) throws DAOException {
		int[] updCnt = null;

		int rowCnt = 0;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");

			updCnt = sqlExe.executeBatch(new BkgCopManageDBDAOModifySvcOrdBkgNoUSQL(), toBeSoUpdList, null);
			for (int i = 0; i < updCnt.length; i++) {
				if (updCnt[i] == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update No" + i + " SQL");
				else
					rowCnt += updCnt[i];
			}

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rowCnt;
	}

	/**
	 * OD/SO 를 포함한 모든 SO 의 BKG_NO / BL_NO 를 변경
	 * @param List<TrsTrspSvcOrdVO> toBeSoUpdList
	 * @return
	 * @throws DAOException
	 */
	public int modifySvcOrdBkgNoInclODSO(List<TrsTrspSvcOrdVO> toBeSoUpdList) throws DAOException {
		int[] updCnt = null;

		int rowCnt = 0;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");

			updCnt = sqlExe.executeBatch(new BkgCopManageDBDAOModifySvcOrdBkgNoInclODSOUSQL(), toBeSoUpdList, null);
			for (int i = 0; i < updCnt.length; i++) {
				if (updCnt[i] == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update No" + i + " SQL");
				else
					rowCnt += updCnt[i];
			}

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rowCnt;
	}

	/**
	 * @param toBeSoUpdList
	 * @return int
	 * @throws DAOException
	 */
	public int modifyRailBilOrdBkgNo(List<TrsTrspSvcOrdVO> toBeSoUpdList) throws DAOException {
		int[] updCnt = null;

		int rowCnt = 0;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");

			updCnt = sqlExe.executeBatch(new BkgCopManageDBDAOModifyRailBilOrdBkgNoUSQL(), toBeSoUpdList, null);
			for (int i = 0; i < updCnt.length; i++) {
				if (updCnt[i] == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update No" + i + " SQL");
				else
					rowCnt += updCnt[i];
			}

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rowCnt;
	}

	/**
	 * Outbound Door S/O 를 포함하여 모든 S/O 의 bkg_no 를 변경
	 * @param List<TrsTrspSvcOrdVO> toBeSoUpdList
	 * @return int
	 * @throws DAOException
	 */
	public int modifyRailBilOrdBkgNoInclODSO(List<TrsTrspSvcOrdVO> toBeSoUpdList) throws DAOException {
		int[] updCnt = null;

		int rowCnt = 0;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");

			updCnt = sqlExe.executeBatch(new BkgCopManageDBDAOModifyRailBilOrdBkgNoInclODSOUSQL(), toBeSoUpdList, null);
			for (int i = 0; i < updCnt.length; i++) {
				if (updCnt[i] == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update No" + i + " SQL");
				else
					rowCnt += updCnt[i];
			}

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rowCnt;
	}

	/**
	 * @param to_be_cop_no
	 * @param trsTrspSvcOrdVO
	 * @return int
	 * @throws DAOException
	 */
	public int modifySvcOrdByCop(String to_be_cop_no, TrsTrspSvcOrdVO trsTrspSvcOrdVO) throws DAOException {

		int rowCnt = 0;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");

			Map<String, Object> param = new HashMap<String, Object>();
			Map<String, Object> velParam = new HashMap<String, Object>();

			param.put("to_be_cop_no", to_be_cop_no);
			param.putAll(trsTrspSvcOrdVO.getColumnValues());
			velParam.put("to_be_cop_no", to_be_cop_no);
			velParam.putAll(trsTrspSvcOrdVO.getColumnValues());

			rowCnt = sqlExe.executeUpdate(new ReplanManageDBDAOModifySvcOrdByCopUSQL(), param, velParam);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rowCnt;
	}

	/**
	 * @param to_be_cop_no
	 * @param trsTrspRailBilOrdVO
	 * @return int
	 * @throws DAOException
	 */
	public int modifyRailBilOrdByCop(String to_be_cop_no, TrsTrspRailBilOrdVO trsTrspRailBilOrdVO) throws DAOException {

		int rowCnt = 0;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");

			Map<String, Object> param = new HashMap<String, Object>();
			Map<String, Object> velParam = new HashMap<String, Object>();

			param.put("to_be_cop_no", to_be_cop_no);
			param.putAll(trsTrspRailBilOrdVO.getColumnValues());
			velParam.put("to_be_cop_no", to_be_cop_no);
			velParam.putAll(trsTrspRailBilOrdVO.getColumnValues());

			rowCnt = sqlExe.executeUpdate(new ReplanManageDBDAOModifyRailBilOrdByCopUSQL(), param, velParam);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rowCnt;
	}

	/**
	 * @param cop_no
	 * @param estm_dt
	 * @param dor_arr_dt
	 * @return int
	 * @throws DAOException
	 */
	public int modifyOBMtEstmDt(String cop_no, String estm_dt, String dor_arr_dt) throws DAOException {

		int rowCnt = 0;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");

			Map<String, Object> param = new HashMap<String, Object>();
			Map<String, Object> velParam = new HashMap<String, Object>();

			param.put("cop_no", cop_no);
			param.put("estm_dt", estm_dt);
			param.put("dor_arr_dt", dor_arr_dt);

			velParam.put("cop_no", cop_no);
			velParam.put("estm_dt", estm_dt);
			velParam.put("dor_arr_dt", dor_arr_dt);

			rowCnt = sqlExe.executeUpdate(new BkgCopManageDBDAOModifyOBMtEstmDtUSQL(), param, velParam);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rowCnt;
	}

	/**
	 * @param cop_no
	 * @param estm_dt
	 * @param dor_arr_dt
	 * @param post_estm_dt
	 * @return int
	 * @throws DAOException
	 */
	public int modifyIBMtEstmDt(String cop_no, String estm_dt, String dor_arr_dt, String post_estm_dt) throws DAOException {

		int rowCnt = 0;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");

			Map<String, Object> param = new HashMap<String, Object>();
			Map<String, Object> velParam = new HashMap<String, Object>();

			param.put("cop_no", cop_no);
			param.put("estm_dt", estm_dt);
			param.put("dor_arr_dt", dor_arr_dt);
			param.put("post_estm_dt", post_estm_dt);

			velParam.put("cop_no", cop_no);
			velParam.put("estm_dt", estm_dt);
			velParam.put("dor_arr_dt", dor_arr_dt);
			velParam.put("post_estm_dt", post_estm_dt);

			rowCnt = sqlExe.executeUpdate(new BkgCopManageDBDAOModifyIBMtEstmDtUSQL(), param, velParam);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rowCnt;
	}

	/**
	 * @param bkg_no
	 * @param rail_rcv_coff_fm_dt
	 * @param rail_rcv_coff_to_dt
	 * @param upd_usr_id
	 * @return int
	 * @throws DAOException
	 */
	public int modifyRailRcvCoffDt(String bkg_no, String rail_rcv_coff_fm_dt, String rail_rcv_coff_to_dt, String upd_usr_id) throws DAOException {

		int rowCnt = 0;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");

			Map<String, Object> param = new HashMap<String, Object>();
			Map<String, Object> velParam = new HashMap<String, Object>();

			param.put("bkg_no", bkg_no);
			param.put("rail_rcv_coff_fm_dt", rail_rcv_coff_fm_dt);
			param.put("rail_rcv_coff_to_dt", rail_rcv_coff_to_dt);
			param.put("upd_usr_id", upd_usr_id);

			velParam.put("bkg_no", bkg_no);
			velParam.put("rail_rcv_coff_fm_dt", rail_rcv_coff_fm_dt);
			velParam.put("rail_rcv_coff_to_dt", rail_rcv_coff_to_dt);
			velParam.put("upd_usr_id", upd_usr_id);

			rowCnt = sqlExe.executeUpdate(new BkgCopManageDBDAOModifyRailRcvCoffDtUSQL(), param, velParam);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rowCnt;
	}

	/**
	 * @param bkg_no
	 * @param cntr_no
	 * @return int
	 * @throws DAOException
	 */
	public int initializeSceActRcvIf(String bkg_no, String cntr_no) throws DAOException {

		int rowCnt = 0;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");

			Map<String, Object> param = new HashMap<String, Object>();
			Map<String, Object> velParam = new HashMap<String, Object>();

			param.put("bkg_no", bkg_no);
			param.put("cntr_no", cntr_no);

			velParam.put("bkg_no", bkg_no);
			velParam.put("cntr_no", cntr_no);

			rowCnt = sqlExe.executeUpdate(new BkgCopManageDBDAOInitializeSceActRcvIfUSQL(), param, velParam);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rowCnt;
	}

	/**
	 * @param bkg_no
	 * @param cntr_no
	 * @param cop_sts_cd
	 * @return int
	 * @throws DAOException
	 */
	public int modifyLeaCntrBkgHis(String bkg_no, String cntr_no, String cop_sts_cd) throws DAOException {

		int rowCnt = 0;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");

			Map<String, Object> param = new HashMap<String, Object>();
			Map<String, Object> velParam = new HashMap<String, Object>();

			param.put("bkg_no", bkg_no);
			param.put("cntr_no", cntr_no);
			param.put("cop_sts_cd", cop_sts_cd);

			velParam.put("bkg_no", bkg_no);
			velParam.put("cntr_no", cntr_no);
			velParam.put("cop_sts_cd", cop_sts_cd);

			rowCnt = sqlExe.executeUpdate(new BkgCopManageDBDAOModifyLeaCntrBkgHisUSQL(), param, velParam);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rowCnt;
	}

	/**
	 * @param newSo
	 * @param oldCop
	 * @return int
	 * @throws DAOException
	 */
	public int modifySvcOrdByMvCntr(TrsTrspSvcOrdVO newSo, SceCopHdrVO oldCop) throws DAOException {

		int rowCnt = 0;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");

			Map<String, Object> param = new HashMap<String, Object>();
			Map<String, Object> velParam = new HashMap<String, Object>();

			param.put("new_bkg_no", newSo.getBkgNo());
			param.put("new_bl_no", newSo.getBlNo());
			param.put("new_cop_no", newSo.getCopNo());

			param.put("old_cop_no", oldCop.getCopNo());

			velParam.put("new_bkg_no", newSo.getBkgNo());
			velParam.put("new_bl_no", newSo.getBlNo());
			velParam.put("new_cop_no", newSo.getCopNo());

			velParam.put("old_cop_no", oldCop.getCopNo());

			rowCnt = sqlExe.executeUpdate(new BkgCopManageDBDAOModifySvcOrdByMvCntrUSQL(), param, velParam);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rowCnt;
	}

	/**
	 * @param newSo
	 * @param oldCop
	 * @return int
	 * @throws DAOException
	 */
	public int modifyRailBilOrdByMvCntr(TrsTrspSvcOrdVO newSo, SceCopHdrVO oldCop) throws DAOException {

		int rowCnt = 0;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");

			Map<String, Object> param = new HashMap<String, Object>();
			Map<String, Object> velParam = new HashMap<String, Object>();

			param.put("new_bkg_no", newSo.getBkgNo());
			param.put("new_bl_no", newSo.getBlNo());
			param.put("new_cop_no", newSo.getCopNo());

			param.put("old_cop_no", oldCop.getCopNo());

			velParam.put("new_bkg_no", newSo.getBkgNo());
			velParam.put("new_bl_no", newSo.getBlNo());
			velParam.put("new_cop_no", newSo.getCopNo());

			velParam.put("old_cop_no", oldCop.getCopNo());

			rowCnt = sqlExe.executeUpdate(new BkgCopManageDBDAOModifyRailBilOrdByMvCntrUSQL(), param, velParam);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rowCnt;
	}

	/**
	 * @param scePlnSoList
	 * @return int
	 * @throws DAOException
	 */
	public int modifySoStsByMvCntr(List<ScePlnSoListVO> scePlnSoList) throws DAOException {
		int[] updCnt = null;

		int rowCnt = 0;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");

			updCnt = sqlExe.executeBatch(new BkgCopManageDBDAOModifySoStsByMvCntrUSQL(), scePlnSoList, null);
			for (int i = 0; i < updCnt.length; i++) {
				if (updCnt[i] == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update No" + i + " SQL");
				else
					rowCnt += updCnt[i];
			}

			// rowCnt = new SQLExecuter("").executeUpdate((ISQLTemplate) new BkgCopManageDBDAOAddCopHdrCSQL(), param, valParam);

			// if(rowCnt == Statement.EXECUTE_FAILED)
			// throw new DAOException("Fail to update No"+ rowCnt + " SQL");

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rowCnt;
	}

	/**
	 * @param org_bkg_no
	 * @param combined_bkg_no
	 * @return int
	 * @throws DAOException
	 */
	public int modifyTroMapgByBkg(String[] org_bkg_no, String combined_bkg_no) throws DAOException {
		// int[] updCnt = null;

		int rowCnt = 0;

		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			for (int i = 0; i < org_bkg_no.length; i++) {
				Map<String, String> velParam = new HashMap<String, String>();
				Map<String, String> param = new HashMap<String, String>();

				velParam.put("org_bkg_no", org_bkg_no[i]);
				velParam.put("combined_bkg_no", combined_bkg_no);

				param.put("org_bkg_no", org_bkg_no[i]);
				param.put("combined_bkg_no", combined_bkg_no);

				rowCnt += sqlExe.executeUpdate(new BkgCopManageDBDAOModifyTroMapgByBkgUSQL(), param, velParam);

			}
			// rowCnt = new SQLExecuter("").executeUpdate((ISQLTemplate) new BkgCopManageDBDAOAddCopHdrCSQL(), param, valParam);

			// if(rowCnt == Statement.EXECUTE_FAILED)
			// throw new DAOException("Fail to update No"+ rowCnt + " SQL");

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rowCnt;
	}

	/**
	 * @param String fm_cop_no
	 * @param String to_cop_no
	 * @param String io_bnd_cd
	 * @return int
	 * @throws DAOException
	 */
	public int modifyTroMapgCopNoByCop(String fm_cop_no, String to_cop_no, String io_bnd_cd) throws DAOException {
		int rowCnt = 0;

		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String, String> velParam = new HashMap<String, String>();
			Map<String, String> param = new HashMap<String, String>();

			velParam.put("fm_cop_no", fm_cop_no);
			velParam.put("to_cop_no", to_cop_no);
			velParam.put("io_bnd_cd", io_bnd_cd);

			param.put("fm_cop_no", fm_cop_no);
			param.put("to_cop_no", to_cop_no);
			param.put("io_bnd_cd", io_bnd_cd);

			rowCnt = sqlExe.executeUpdate(new BkgCopManageDBDAOModifyTroMapgCopNoByCopUSQL(), param, velParam);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rowCnt;
	}

	/**
	 * @param fm_cop_no
	 * @param to_cop_no
	 * @return
	 * @throws DAOException
	 */
	public int modifyOdSoCopNo(String fm_cop_no, String to_cop_no) throws DAOException {
		int rowCnt = 0;

		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String, String> velParam = new HashMap<String, String>();
			Map<String, String> param = new HashMap<String, String>();

			velParam.put("fm_cop_no", fm_cop_no);
			velParam.put("to_cop_no", to_cop_no);

			param.put("fm_cop_no", fm_cop_no);
			param.put("to_cop_no", to_cop_no);

			rowCnt = sqlExe.executeUpdate(new BkgCopManageDBDAOModifyOdSoCopNoUSQL(), param, velParam);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rowCnt;
	}

	/**
	 * @param String fm_cop_no
	 * @param String to_cop_no
	 * @return int
	 * @throws DAOException
	 */
	public int modifyPlnSoListSoSts(String fm_cop_no, String to_cop_no) throws DAOException {
		int rowCnt = 0;

		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String, String> velParam = new HashMap<String, String>();
			Map<String, String> param = new HashMap<String, String>();

			velParam.put("fm_cop_no", fm_cop_no);
			velParam.put("to_cop_no", to_cop_no);

			param.put("fm_cop_no", fm_cop_no);
			param.put("to_cop_no", to_cop_no);

			rowCnt = sqlExe.executeUpdate(new BkgCopManageDBDAOModifyPlnSoListSoStsUSQL(), param, velParam);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rowCnt;
	}

	/**
	 * @param cop_no
	 * @param io_bnd_cd
	 * @return int
	 * @throws DAOException
	 */
	public int modifySoListFrstByTroCnfm(String cop_no, String io_bnd_cd) throws DAOException {

		int rowCnt = 0;

		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String, String> velParam = new HashMap<String, String>();
			Map<String, String> param = new HashMap<String, String>();

			velParam.put("cop_no", cop_no);
			velParam.put("io_bnd_cd", io_bnd_cd);

			param.put("cop_no", cop_no);
			param.put("io_bnd_cd", io_bnd_cd);

			rowCnt = sqlExe.executeUpdate(new BkgCopManageDBDAOModifySoListFrstByTroCnfmUSQL(), param, velParam);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rowCnt;
	}

	/**
	 * @param String cop_no
	 * @return int
	 * @throws DAOException
	 */
	public int modifyOdSoStsPlned(String cop_no) throws DAOException {
		int rowCnt = 0;

		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String, String> velParam = new HashMap<String, String>();
			Map<String, String> param = new HashMap<String, String>();

			velParam.put("cop_no", cop_no);

			param.put("cop_no", cop_no);

			rowCnt = sqlExe.executeUpdate(new BkgCopManageDBDAOModifyOdSoStsPlnedUSQL(), param, velParam);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rowCnt;

	}

	/**
	 * @param sceCopHdrVOList
	 * @return int
	 * @throws DAOException
	 */
	public int addSoList(List<SceCopHdrVO> sceCopHdrVOList) throws DAOException {
		int[] updCnt = null;

		int rowCnt = 0;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");

			updCnt = sqlExe.executeBatch(new BkgCopManageDBDAOAddSoListCSQL(), sceCopHdrVOList, null);
			for (int i = 0; i < updCnt.length; i++) {
				if (updCnt[i] == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update No" + i + " SQL");
				else
					rowCnt += updCnt[i];
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rowCnt;
	}

	/**
	 * @param sceCopHdrVOList
	 * @return int
	 * @throws DAOException
	 */
	public int addCopDtl(List<SceCopHdrVO> sceCopHdrVOList) throws DAOException {
		int[] updCnt = null;

		int rowCnt = 0;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");

			updCnt = sqlExe.executeBatch(new BkgCopManageDBDAOAddCopDtlCSQL(), sceCopHdrVOList, null);
			for (int i = 0; i < updCnt.length; i++) {
				if (updCnt[i] == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update No" + i + " SQL");
				else
					rowCnt += updCnt[i];
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rowCnt;
	}

	/**
	 * @param sceCopDtlVOs
	 * @return int
	 * @throws DAOException
	 */
	public int removeCopDtl(List<SceCopDtlVO> sceCopDtlVOs) throws DAOException {
		int[] delCnt = null;

		int rowCnt = 0;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");

			delCnt = sqlExe.executeBatch(new BkgCopManageDBDAORemoveCopDtlDSQL(), sceCopDtlVOs, null);
			for (int i = 0; i < delCnt.length; i++) {
				if (delCnt[i] == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to delete No" + i + " SQL");
				else
					rowCnt += delCnt[i];
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rowCnt;
	}

	/**
	 * @param validateTROSequenceVOs
	 * @return int
	 * @throws DAOException
	 */
	public int removeTroMapInfo(List<ValidateTROSequenceVO> validateTROSequenceVOs) throws DAOException {
		int[] delCnt = null;

		int rowCnt = 0;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");

			delCnt = sqlExe.executeBatch(new BkgCopManageDBDAORemoveTROInfoDSQL(), validateTROSequenceVOs, null);
			for (int i = 0; i < delCnt.length; i++) {
				if (delCnt[i] == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to delete No" + i + " SQL");
				else
					rowCnt += delCnt[i];
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rowCnt;
	}

	/**
	 * @param validateTROSequenceVO
	 * @return int
	 * @throws DAOException
	 */
	public int removeTroMapInfo(ValidateTROSequenceVO validateTROSequenceVO) throws DAOException {

		int rowCnt = 0;
		try {
			Map<String, String> velParam = new HashMap<String, String>();
			Map<String, String> param = new HashMap<String, String>();

			param.putAll(validateTROSequenceVO.getColumnValues());
			velParam.putAll(validateTROSequenceVO.getColumnValues());

			SQLExecuter sqlExe = new SQLExecuter("");

			rowCnt = sqlExe.executeUpdate(new BkgCopManageDBDAORemoveTROInfoDSQL(), param, velParam);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rowCnt;
	}

	/**
	 * @param scePlnSoListVOs
	 * @return int
	 * @throws DAOException
	 */
	public int removeSoList(List<ScePlnSoListVO> scePlnSoListVOs) throws DAOException {
		int[] delCnt = null;

		int rowCnt = 0;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");

			delCnt = sqlExe.executeBatch(new BkgCopManageDBDAORemoveSoListDSQL(), scePlnSoListVOs, null);
			for (int i = 0; i < delCnt.length; i++) {
				if (delCnt[i] == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to delete No" + i + " SQL");
				else
					rowCnt += delCnt[i];
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rowCnt;
	}

	/**
	 * @param bkg_no
	 * @param flg_dummy
	 * @return int
	 * @throws DAOException
	 */
	public int cancelCop(String bkg_no, String flg_dummy) throws DAOException {
		int delCnt = 0;

		try {
			Map<String, String> velParam = new HashMap<String, String>();

			Map<String, String> param = new HashMap<String, String>();

			param.put("bkg_no", bkg_no);

			velParam.put("flg_dummy", flg_dummy);

			SQLExecuter sqlExe = new SQLExecuter("");

			delCnt = sqlExe.executeUpdate(new BkgCopManageDBDAOCancelCopUSQL(), param, velParam);
			if (delCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to delete No" + delCnt + " SQL");

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return delCnt;
	}

	/**
	 * @param bkg_no
	 * @param cntr_no
	 * @param bkg_evnt_dt
	 * @throws DAOException
	 */
	public void callLeaBkgCntrHisPrc(String bkg_no, String cntr_no, String bkg_evnt_dt) throws DAOException {

		try {
			Map<String, String> velParam = new HashMap<String, String>();
			Map<String, String> param = new HashMap<String, String>();

			String out_rslt_cd = "";

			param.put("bkg_no", bkg_no);
			param.put("cntr_no", cntr_no);
			param.put("bkg_evnt_dt", bkg_evnt_dt);
			param.put("out_rslt_cd", out_rslt_cd);

			velParam.put("bkg_no", bkg_no);
			velParam.put("cntr_no", cntr_no);
			velParam.put("bkg_evnt_dt", bkg_evnt_dt);
			velParam.put("out_rslt_cd", out_rslt_cd);

			SQLExecuter sqlExe = new SQLExecuter("");

			sqlExe.executeSP((ISQLTemplate) new BkgCopManageDBDAOCallLeaCntrBkgHisPrcRSQL(), param, velParam);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * @param cop_no
	 * @throws DAOException
	 */
	public void callTrsCtrlOfcExptRule(String cop_no) throws DAOException {

		try {
			Map<String, String> velParam = new HashMap<String, String>();
			Map<String, String> param = new HashMap<String, String>();

			param.put("cop_no", cop_no);
			velParam.put("cop_no", cop_no);

			SQLExecuter sqlExe = new SQLExecuter("");

			sqlExe.executeQuery((ISQLTemplate) new BkgCopManageDBDAOCallTrsCtrlOfcExptRuleRSQL(), param, velParam);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * @param pctl_no
	 * @param io_bnd_cd
	 * @param cmmt_flg
	 * @param upd_usr_id
	 * @return String
	 * @throws EventException
	 * @throws SQLException
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public String callPrdSetActDwTimePrc(String pctl_no, String io_bnd_cd, String cmmt_flg, String upd_usr_id) throws EventException, SQLException, DAOException {

		Map<String, String> velParam = new HashMap<String, String>();
		Map<String, String> param = new HashMap<String, String>();

		String out_rslt_cd = "";
		param.put("pctl_no", pctl_no);
		param.put("io_bnd_cd", io_bnd_cd);
		param.put("cmmt_flg", cmmt_flg);
		param.put("upd_usr_id", upd_usr_id);
		param.put("out_rslt_cd", out_rslt_cd);

		velParam.put("pctl_no", pctl_no);
		velParam.put("io_bnd_cd", io_bnd_cd);
		velParam.put("cmmt_flg", cmmt_flg);
		velParam.put("upd_usr_id", upd_usr_id);
		param.put("out_rslt_cd", out_rslt_cd);

		SQLExecuter sqlExe = new SQLExecuter("");

		Map<String, Object> rtnrslt = sqlExe.executeSP((ISQLTemplate) new BkgCopManageDBDAOCallPrdSetActDwTimePrcRSQL(), param, velParam);

		String rtnStr = "";
		if (rtnrslt != null)
			rtnStr = (String) rtnrslt.get("out_rslt_cd");

		return rtnStr;

	}

	/**
	 * @param cop_no
	 * @return int
	 * @throws DAOException
	 */
	public int cancelObExptMst(String cop_no) throws DAOException {
		int delCnt = 0;

		try {
			Map<String, String> velParam = new HashMap<String, String>();

			Map<String, String> param = new HashMap<String, String>();

			param.put("cop_no", cop_no);

			velParam.put("cop_no", cop_no);

			SQLExecuter sqlExe = new SQLExecuter("");

			delCnt = sqlExe.executeUpdate(new BkgCopManageDBDAOCancelObExptMstUSQL(), param, velParam);
			if (delCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to delete No" + delCnt + " SQL");

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return delCnt;
	}

	/**
	 * @param cop_no
	 * @return int
	 * @throws DAOException
	 */
	public int cancelIbExptMst(String cop_no) throws DAOException {
		int delCnt = 0;

		try {
			Map<String, String> velParam = new HashMap<String, String>();

			Map<String, String> param = new HashMap<String, String>();

			param.put("cop_no", cop_no);

			velParam.put("cop_no", cop_no);

			SQLExecuter sqlExe = new SQLExecuter("");

			delCnt = sqlExe.executeUpdate(new BkgCopManageDBDAOCancelIbExptMstUSQL(), param, velParam);
			if (delCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to delete No" + delCnt + " SQL");

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return delCnt;
	}

	/**
	 * @param sceCopHdrList
	 * @return int
	 * @throws DAOException
	 */
	public int mergeCoaBkgComIf(List<SceCopHdrVO> sceCopHdrList) throws DAOException {
		int delCnt = 0;

		try {
			Map<String, Object> velParam = new HashMap<String, Object>();

			Map<String, Object> param = new HashMap<String, Object>();

			param.put("bkg_no", sceCopHdrList.toArray());

			velParam.put("bkg_no", sceCopHdrList.toArray());

			SQLExecuter sqlExe = new SQLExecuter("");

			delCnt = sqlExe.executeUpdate(new BkgCopManageDBDAOMergeCoaBkgComIfCSQL(), param, velParam);
			if (delCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to delete No" + delCnt + " SQL");

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return delCnt;
	}

	/**
	 * @param bkgNoSet
	 * @return int
	 * @throws DAOException
	 */
	public int mergeCoaCopIfMgmt(Set<String> bkgNoSet) throws DAOException {
		int mergeCnt = 0;

		try {
			Map<String, Object> velParam = new HashMap<String, Object>();

			Map<String, Object> param = new HashMap<String, Object>();

			param.put("bkg_no", bkgNoSet.toArray());

			velParam.put("bkg_no", bkgNoSet.toArray());

			SQLExecuter sqlExe = new SQLExecuter("");

			mergeCnt = sqlExe.executeUpdate(new BkgCopManageDBDAOMergeCoaCopIfMgmtCSQL(), param, velParam);
			if (mergeCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to merge No" + mergeCnt + " SQL");

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return mergeCnt;
	}

	/**
	 * @param String bkg_no
	 * @return boolean
	 * @throws DAOException
	 */
	public boolean reviveCopsByBkgRqst(String bkg_no) throws DAOException {
		int updCnt = 0;

		try {
			Map<String, Object> velParam = new HashMap<String, Object>();
			Map<String, Object> param = new HashMap<String, Object>();

			param.put("bkg_no", bkg_no);
			velParam.put("bkg_no", bkg_no);

			SQLExecuter sqlExe = new SQLExecuter("");

			updCnt = sqlExe.executeUpdate(new BkgCopManageDBDAOReviveCopsByBkgRqstUSQL(), param, velParam);
			if (updCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to revive Cop = " + updCnt + " ");

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return updCnt > 0 ? true : false;
	}

	/**
	 * @param cop_no
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SceCopHdrVO> searchSceCopHdr(String cop_no) throws DAOException {
		List<SceCopHdrVO> copHdrVOs = null;
		DBRowSet dbRowset = null;
		try {
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("cop_no", cop_no);
			dbRowset = new SQLExecuter("").executeQuery(new BkgCopManageDBDAOSearchSceCopHdrRSQL(), param, param);
			copHdrVOs = (List) RowSetUtil.rowSetToVOs(dbRowset, SceCopHdrVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return copHdrVOs;
	}

	/**
	 * @param cop_no
	 * @return boolean : sce_tro_mapg에 데이타가 있으면 true
	 * @throws DAOException
	 */
	public boolean checkCopToBeTroMapgAlive(String cop_no) throws DAOException {
		Map<String, String> param = new HashMap<String, String>();
		DBRowSet dbRowset = null;
		param.put("cop_no", cop_no);
		boolean rtnRslt = false;

		try {
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BkgCopManageDBDAOCheckCopToBeTroMapgAliveRSQL(), param, param);

			if (dbRowset.next()) {
				int rslt = dbRowset.getInt("CHK_RSLT");
				log.debug("check rslt = " + rslt);
				rtnRslt = rslt > 0 ? true : false;
			}

		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnRslt;
	}

	/**
	 * @param updBkgForBkgCodVO
	 * @return int
	 * @throws DAOException
	 */
	public int addSceCodHisForBkgCod(UpdBkgForBkgCodVO updBkgForBkgCodVO) throws DAOException {
		int updCnt = 0;

		try {
			Map<String, Object> param = new HashMap<String, Object>();

			param.putAll(updBkgForBkgCodVO.getColumnValues());

			SQLExecuter sqlExe = new SQLExecuter("");
			updCnt = sqlExe.executeUpdate(new BkgCopManageDBDAOAddSceCodHisForBkgCodCSQL(), param, param);
			if (updCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to revive Cop = " + updCnt + " ");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return updCnt;
	}

}
