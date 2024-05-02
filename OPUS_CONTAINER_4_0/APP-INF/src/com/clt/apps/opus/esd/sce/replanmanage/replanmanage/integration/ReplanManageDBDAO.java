/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ReplanManageDBDAO.java
 *@FileTitle : Replan 을 수행하는 공통 class 를 구동한다.
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.09.01
 *@LastModifier : 김인수
 *@LastVersion : 1.0
 * 2009.09.01 김인수
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.replanmanage.replanmanage.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esd.sce.bkgcopmanage.integration.BkgCopManageDBDAORemoveCopDtlDSQL;
import com.clt.apps.opus.esd.sce.bkgcopmanage.integration.BkgCopManageDBDAORemoveSoListDSQL;
import com.clt.apps.opus.esd.sce.bkgcopmanage.integration.BkgCopManageDBDAOSearchRailRcvCoffDtRSQL;
import com.clt.apps.opus.esd.sce.copdetailreceive.vo.SceActRcvIfVO;
import com.clt.apps.opus.esd.sce.replanmanage.replanmanage.basic.ReplanManageBCImpl;
import com.clt.apps.opus.esd.sce.replanmanage.replanmanage.vo.ReplanResultVO;
import com.clt.apps.opus.esd.sce.replanmanage.replanmanage.vo.Search315VEToBeSentVO;
import com.clt.apps.opus.esd.sce.replanmanage.replanmanage.vo.SearchSoByCopVO;
import com.clt.apps.opus.esd.sce.replanmanage.replanmanage.vo.SearchTurnVvdVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.framework.utility.CheckUtilities;
import com.clt.syscommon.common.table.BkgBookingVO;
import com.clt.syscommon.common.table.PrdProdCtlMstVO;
import com.clt.syscommon.common.table.SceActTmlIfDtlVO;
import com.clt.syscommon.common.table.SceActTmlIfVO;
import com.clt.syscommon.common.table.SceCopDtlVO;
import com.clt.syscommon.common.table.SceCopHdrVO;
import com.clt.syscommon.common.table.ScePlnSoListVO;
import com.clt.syscommon.common.table.SceTroMapgVO;
import com.clt.syscommon.common.table.TrsTrspRailBilOrdVO;
import com.clt.syscommon.common.table.TrsTrspSvcOrdVO;

/**
 * ReplanManageDBDAO <br>
 * - ReplanManage system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Kim In-soo
 * @see ReplanManageBCImpl 참조
 * @since J2EE 1.6
 */
public class ReplanManageDBDAO extends DBDAOSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5857527981103593230L;

	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * @param bkg_no String
	 * @param cntr_no String
	 * @param cop_sts String
	 * @return List<SceCopHdrVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SceCopHdrVO> searchPartialCops(String bkg_no, String cntr_no, String cop_sts) throws DAOException {
		DBRowSet dbRowset = null;
		List<SceCopHdrVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		param.put("cntr_no", cntr_no);
		velParam.put("cntr_no", cntr_no);
		
		param.put("sts_flg", cop_sts);
		velParam.put("sts_flg", cop_sts);
		
		param.put("bkg_no", bkg_no);
		velParam.put("bkg_no", bkg_no);
		
		try {

			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new ReplanManageDBDAOSearchPartialCopsRSQL(),
					param, velParam);
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
	 * BKG_NO+CNTR_NO로 Master Exception Flag에 따라 Partial건중 Master Cop를 제외하거나 Master Cop만 조회한다. <br>
	 * @param bkg_no String
	 * @param cntr_no String
	 * @param cop_sts String
	 * @param self_expt_flg String
	 * @return List<SceCopHdrVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SceCopHdrVO> searchPartialCopsExptSelf(String bkg_no, String cntr_no, String cop_sts, String self_expt_flg) throws DAOException {
		DBRowSet dbRowset = null;
		List<SceCopHdrVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		param.put("cntr_no", cntr_no);
		velParam.put("cntr_no", cntr_no);
		
		param.put("sts_flg", cop_sts);
		velParam.put("sts_flg", cop_sts);
		
		param.put("bkg_no", bkg_no);
		velParam.put("bkg_no", bkg_no);
		
		param.put("self_expt_flg", self_expt_flg);
		velParam.put("self_expt_flg", self_expt_flg);
		
		try {

			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new ReplanManageDBDAOSearchPartialCopsExptSelfRSQL(),
					param, velParam);
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
	 * BKG_NO+CNTR_NO로 Partial건의 갯수를 조회한다. <br>
	 * @param bkg_no String
	 * @param cntr_no String
	 * @param cop_sts String
	 * @return int
	 * @throws DAOException
	 */
	public int searchPartialCopsCount(String bkg_no, String cntr_no, String cop_sts) throws DAOException {
		DBRowSet dbRowset = null;
		int returnInt = 0;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		param.put("cntr_no", cntr_no);
		velParam.put("cntr_no", cntr_no);
		
		param.put("sts_flg", cop_sts);
		velParam.put("sts_flg", cop_sts);
		
		param.put("bkg_no", bkg_no);
		velParam.put("bkg_no", bkg_no);
		
		try {

			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new ReplanManageDBDAOSearchPartialCopsCountRSQL(),
					param, velParam);
			if(dbRowset.next()){
				returnInt = dbRowset.getInt("CNT");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return returnInt;
	}
	
	
	/**
	 * @param cop_no
	 * @return SceCopHdrVO
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public SceCopHdrVO searchCopHdr(String cop_no) throws DAOException {
		DBRowSet dbRowset = null;
		List<SceCopHdrVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		SceCopHdrVO sceCopHdrVO = new SceCopHdrVO();
		param.put("cop_no", cop_no);
		
		try {
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new ReplanManageDBDAOSearchCopHdrRSQL(),
					param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SceCopHdrVO.class);
			sceCopHdrVO = list.get(0);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return sceCopHdrVO;
	}
	
	/**
	 * @param cop_no
	 * @param copList : master cop no 를 변경해야 할 cop 에서 제외시킬 대상
	 * @return SceCopHdrVO
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SceCopHdrVO> searchCopHdrByMstCopNoExptItself(String cop_no, List copList) throws DAOException {
		DBRowSet dbRowset = null;
		List<SceCopHdrVO> list = new ArrayList<SceCopHdrVO>();
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		param.put("cop_no", cop_no);
		param.put("copList", copList);
		velParam.put("expt_flg", "Y");
		velParam.put("copList", copList);
		
		try {
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new ReplanManageDBDAOSearchCopHdrByMstCopNoRSQL(),
					param, velParam);
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
	 * @return List<ScePlnSoListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<ScePlnSoListVO> searchPlnSoListByCop(String cop_no) throws DAOException {
		DBRowSet dbRowset = null;
		List<ScePlnSoListVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		param.put("cop_no", cop_no);
		
		try {
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new ReplanManageDBDAOSearchPlnSoListByCopRSQL(),
					param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, ScePlnSoListVO.class);
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
	 * @param sceCopHdrVO
	 * @return List<ScePlnSoListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<ScePlnSoListVO> searchPlnSoListToBeInserted(SceCopHdrVO sceCopHdrVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ScePlnSoListVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		param.putAll(sceCopHdrVO.getColumnValues());
		velParam.putAll(sceCopHdrVO.getColumnValues());
		
		try {
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new ReplanManageDBDAOSearchPlnSoListToBeInsertedRSQL(),
					param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, ScePlnSoListVO.class);
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
	 * @param sceCopHdrVO
	 * @return List<SceCopDtlVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SceCopDtlVO> searchCopDtlToBeInserted(SceCopHdrVO sceCopHdrVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SceCopDtlVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		param.putAll(sceCopHdrVO.getColumnValues());
		velParam.putAll(sceCopHdrVO.getColumnValues());
		
		try {
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new ReplanManageDBDAOSearchCopDtlToBeInsertedRSQL(),
					param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SceCopDtlVO.class);
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
	 * @param sceCopHdrVO
	 * @return List<SceCopDtlVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SceCopDtlVO> searchCopDtl(SceCopHdrVO sceCopHdrVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SceCopDtlVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		param.putAll(sceCopHdrVO.getColumnValues());
		velParam.putAll(sceCopHdrVO.getColumnValues());
		
		try {
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new ReplanManageDBDAOSearchCopDtlRSQL(),
					param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SceCopDtlVO.class);
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
	 * @param cntr_tpsz_cd
	 * @return String
	 * @throws DAOException
	 */
	public String searchRepPctlNo(String bkg_no, String cntr_tpsz_cd) throws DAOException {
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		param.put("bkg_no", bkg_no);
		param.put("cntr_tpsz_cd", cntr_tpsz_cd);
		String pctl_no = "";
		
		try {
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new ReplanManageDBDAOSearchRepPctlNoRSQL(),
					param, velParam);
			
			if (dbRowset.next())
				pctl_no = dbRowset.getString("PCTL_NO");
				
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return pctl_no;
	}
	
	/**
	 * @param pctl_no
	 * @return String
	 * @throws DAOException
	 */
	public String searchCopRailChk(String pctl_no) throws DAOException {
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		param.put("pctl_no", pctl_no);
		String rtnCopRailChkCd = "";
		
		try {
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new ReplanManageDBDAOSearchCopRailChkRSQL(),
					param, velParam);
			
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
	 * @param cop_no
	 * @return List<SearchSoByCopVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SearchSoByCopVO> searchSoByCop(String cop_no) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchSoByCopVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		param.put("cop_no", cop_no);
		velParam.put("cop_no", cop_no);
		
		try {
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new ReplanManageDBDAOSearchSoByCopRSQL(),
					param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchSoByCopVO.class);
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
	 * @param trsp_so_ofc_cty_cd
	 * @param trsp_so_seq
	 * @return List<SearchSoByCopVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SearchSoByCopVO> searchSoByKey(String trsp_so_ofc_cty_cd, String trsp_so_seq) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchSoByCopVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		param.put("trsp_so_ofc_cty_cd", trsp_so_ofc_cty_cd);
		param.put("trsp_so_seq", trsp_so_seq);
		
		velParam.put("trsp_so_ofc_cty_cd", trsp_so_ofc_cty_cd);
		velParam.put("trsp_so_seq", trsp_so_seq);
		
		try {
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new ReplanManageDBDAOSearchSoByKeyRSQL(),
					param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchSoByCopVO.class);
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
	 * @return List<SearchSoByCopVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SearchSoByCopVO> searchLastSoByCop(String cop_no) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchSoByCopVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		param.put("cop_no", cop_no);
		velParam.put("cop_no", cop_no);
		
		try {
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new ReplanManageDBDAOSearchSoByCopRSQL(),
					param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchSoByCopVO.class);
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
	 * @param cost_act_grp_seq
	 * @return List<SearchSoByCopVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SearchSoByCopVO> searchSoByCop(String cop_no, String cost_act_grp_seq) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchSoByCopVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		param.put("cop_no", cop_no);
		velParam.put("cop_no", cop_no);
		
		param.put("cost_act_grp_seq", cost_act_grp_seq);
		velParam.put("cost_act_grp_seq", cost_act_grp_seq);
		
		try {
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new ReplanManageDBDAOSearchSoByCopRSQL(),
					param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchSoByCopVO.class);
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
	 * @param cost_act_grp_seq
	 * @return List<TrsTrspSvcOrdVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<TrsTrspSvcOrdVO> searchSoByPlnSo(String cop_no, String cost_act_grp_seq) throws DAOException {
		DBRowSet dbRowset = null;
		List<TrsTrspSvcOrdVO> list = new ArrayList<TrsTrspSvcOrdVO>();
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		param.put("cop_no", cop_no);
		velParam.put("cop_no", cop_no);
		
		param.put("cost_act_grp_seq", cost_act_grp_seq);
		velParam.put("cost_act_grp_seq", cost_act_grp_seq);
		
		try {
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new ReplanManageDBDAOSearchSoByPlnSoRSQL(),
					param, velParam);
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
	 * @param cntr_no
	 * @return List<SceCopHdrVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SceCopHdrVO> searchBfSplitCopInfo(String bkg_no, String cntr_no) throws DAOException {
		DBRowSet dbRowset = null;
		List<SceCopHdrVO> list = new ArrayList<SceCopHdrVO>();
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		param.put("bkg_no", bkg_no);
		param.put("cntr_no", cntr_no);
		velParam.put("bkg_no", bkg_no);
		velParam.put("cntr_no", cntr_no);
		
		try {
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new ReplanManageDBDAOSearchBfSplitCopInfoRSQL(),
					param, velParam);
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
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		param.put("bkg_no", bkg_no);
		velParam.put("bkg_no", bkg_no);
		
		try {
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new ReplanManageDBDAOSearchBfSplitBkgInfoRSQL(),
					param, velParam);
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
	public List<SceCopHdrVO> searchBfCombineCopInfo(String bkg_no, String cntr_no) throws DAOException {
		DBRowSet dbRowset = null;
		List<SceCopHdrVO> list = new ArrayList<SceCopHdrVO>();
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		param.put("bkg_no", bkg_no);
		param.put("cntr_no", cntr_no);
		velParam.put("bkg_no", bkg_no);
		velParam.put("cntr_no", cntr_no);
		
		try {
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new ReplanManageDBDAOSearchBfrCombineCopInfoRSQL(),
					param, velParam);
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
	public List<BkgBookingVO> searchBfCombineBkgInfo(String bkg_no) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgBookingVO> list = new ArrayList<BkgBookingVO>();
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		param.put("bkg_no", bkg_no);
		velParam.put("bkg_no", bkg_no);
		
		try {
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new ReplanManageDBDAOSearchBfCombineBkgInfoRSQL(),
					param, velParam);
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
	 * @param pctl_no
	 * @return List<PrdProdCtlMstVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<PrdProdCtlMstVO> searchPrdMst(String pctl_no) throws DAOException {
		DBRowSet dbRowset = null;
		List<PrdProdCtlMstVO> list = new ArrayList<PrdProdCtlMstVO>();
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		param.put("pctl_no", pctl_no);
		velParam.put("pctl_no", pctl_no);
		
		try {
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new ReplanManageDBDAOSearchPrdMstRSQL(),
					param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, PrdProdCtlMstVO.class);
			
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
	 * @return List<PrdProdCtlMstVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SceActTmlIfVO> searchActualTerminal() throws DAOException {
		DBRowSet dbRowset = null;
		List<SceActTmlIfVO> list = new ArrayList<SceActTmlIfVO>();
		
		try {
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new ReplanManageDBDAOSearchActualTerminalRSQL(),
					null, null);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SceActTmlIfVO.class);
			
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
	 * @param sceActTmlIfVO
	 * @return List<SearchTurnVvdVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SearchTurnVvdVO> searchTurnVvd(SceActTmlIfVO sceActTmlIfVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchTurnVvdVO> list = new ArrayList<SearchTurnVvdVO>();
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		param.putAll(sceActTmlIfVO.getColumnValues());
		velParam.putAll(sceActTmlIfVO.getColumnValues());
		
		try {
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new ReplanManageDBDAOSearchTurnVvdRSQL(),
					param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchTurnVvdVO.class);
			
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
	 * @param sceActTmlIfVO
	 * @param turn_vsl_cd
	 * @param turn_skd_voy_no
	 * @param turn_skd_dir_cd
	 * @return List<SceCopHdrVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SceCopHdrVO> searchActualSCETerminal(SceActTmlIfVO sceActTmlIfVO, String turn_vsl_cd, String turn_skd_voy_no, String turn_skd_dir_cd) throws DAOException {
		DBRowSet dbRowset = null;
		List<SceCopHdrVO> list = new ArrayList<SceCopHdrVO>();
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		param.putAll(sceActTmlIfVO.getColumnValues());
		param.put("turn_vsl_cd", turn_vsl_cd);
		param.put("turn_skd_voy_no", turn_skd_voy_no);
		param.put("turn_skd_dir_cd", turn_skd_dir_cd);
		velParam.putAll(sceActTmlIfVO.getColumnValues());
		velParam.put("turn_vsl_cd", turn_vsl_cd);
		velParam.put("turn_skd_voy_no", turn_skd_voy_no);
		velParam.put("turn_skd_dir_cd", turn_skd_dir_cd);
		
		//20100407 @vps_port_cd 조건 추가함 jsan
		log.error("\n 20100407 @vps_port_cd add : "+sceActTmlIfVO.getVpsPortCd()+"-------------------");
		try {
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new ReplanManageDBDAOSearchActualSCETerminalRSQL(),
					param, velParam);
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
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		param.put("bkg_no", bkg_no);
		velParam.put("bkg_no", bkg_no);
		
		try {
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new ReplanManageDBDAOSearch315VEToBeSentRSQL(),
					param, velParam);
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
	 * @return List<SceCopHdrVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SceCopHdrVO> searchRailRcvCoffDt(String bkg_no) throws DAOException {
		DBRowSet dbRowset = null;
		List<SceCopHdrVO> list = new ArrayList<SceCopHdrVO>();
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		param.put("bkg_no", bkg_no);
		velParam.put("bkg_no", bkg_no);
		
		try {
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new BkgCopManageDBDAOSearchRailRcvCoffDtRSQL(),
					param, velParam);
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
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		param.put("cop_no", cop_no);
		velParam.put("cop_no", cop_no);
		
		try {
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new ReplanManageDBDAOSearchActualToBeUpdatedRSQL(),
					param, velParam);
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
	 * @param cop_no
	 * @return List<SceActRcvIfVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SceActRcvIfVO> searchActualToBeUpdatedTmpPrc(String cop_no) throws DAOException {
		DBRowSet dbRowset = null;
		List<SceActRcvIfVO> list = new ArrayList<SceActRcvIfVO>();
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		param.put("cop_no", cop_no);
		velParam.put("cop_no", cop_no);
		
		try {
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new ReplanManageDBDAOSearchActualToBeUpdatedTmpPrcRSQL(),
					param, velParam);
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
	 * @param cop_no
	 * @return List<SceActRcvIfVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SceActRcvIfVO> searchActualToBeUpdatedTmpVSK(String cop_no) throws DAOException {
		DBRowSet dbRowset = null;
		List<SceActRcvIfVO> list = new ArrayList<SceActRcvIfVO>();
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		param.put("cop_no", cop_no);
		velParam.put("cop_no", cop_no);
		
		try {
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new ReplanManageDBDAOSearchActualToBeUpdatedTmpVSKUSQL(),
					param, velParam);
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
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		param.put("bkg_no", bkg_no);
		param.put("cntr_no", cntr_no);
		param.put("cop_no", cop_no);
		
		velParam.put("bkg_no", bkg_no);
		velParam.put("cntr_no", cntr_no);
		velParam.put("cop_no", cop_no);
		
		try {
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new ReplanManageDBDAOSearchActualToBeUpdatedRSQL(),
					param, velParam);
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
	 * P/C 의 아래 내역을 비교하여 차이가 존재하면 false, 차이가 없다면 true 를 return
	 * 
	 * 비교 항목 :
	 * PCTL_SEQ,
     * ORG_NOD_CD,
  	 * DEST_NOD_CD,
     * NOD_LNK_DIV_CD,
     * PCTL_IO_BND_CD,
     * TRSP_MOD_CD,
     * ARR_ST_DT,
     * DEP_FSH_DT
	 * @param String old_pctl_no
	 * @param String crnt_pctl_no
	 * @return boolean
	 * @throws DAOException
	 */
	public boolean comparePcCtnt(String old_pctl_no, String crnt_pctl_no) throws DAOException {
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		param.put("old_pctl_no", old_pctl_no);
		param.put("crnt_pctl_no", crnt_pctl_no);
		
		velParam.put("old_pctl_no", old_pctl_no);
		velParam.put("crnt_pctl_no", crnt_pctl_no);
		
		boolean rstBool = false;
		
		try {
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new ReplanManageDBDAOComparePcCtntRSQL(),
					param, velParam);
			
			rstBool = !dbRowset.next();
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rstBool;
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
	public String callPrdSetActDwTimePrc(String pctl_no, String io_bnd_cd,
			String cmmt_flg, String upd_usr_id) throws EventException,
			SQLException, DAOException {

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
		velParam.put("out_rslt_cd", out_rslt_cd);

		SQLExecuter sqlExe = new SQLExecuter("");

		Map<String, Object> rtnrslt = sqlExe.executeSP((ISQLTemplate) new ReplanManageDBDAOCallPrdSetActDwlTimePrcUSQL(),
						param, velParam);
		
		String rtnStr = "";
		if (rtnrslt != null) 
			rtnStr = (String) rtnrslt.get("out_rslt_cd");
		
		return rtnStr;

	}
	
	/**
	 * @param sceCopHdrVO
	 * @return int
	 * @throws DAOException
	 */
	public int addCopHdrByCop(SceCopHdrVO sceCopHdrVO) throws DAOException {
		int rowCnt = 0;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			Map<String, Object> param = new HashMap<String, Object> ();
			Map<String, Object> velParam = new HashMap<String, Object> ();
			
			param.putAll(sceCopHdrVO.getColumnValues());
			velParam.putAll(sceCopHdrVO.getColumnValues());
			
			rowCnt = sqlExe.executeUpdate(new ReplanManageDBDAOAddCopHdrByCopCSQL(), param, velParam);
			
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
	public int addSoListByCop(SceCopHdrVO sceCopHdrVO) throws DAOException {
		int rowCnt = 0;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			Map<String, Object> param = new HashMap<String, Object> ();
			Map<String, Object> velParam = new HashMap<String, Object> ();
			
			param.putAll(sceCopHdrVO.getColumnValues());
			velParam.putAll(sceCopHdrVO.getColumnValues());
			
			rowCnt = sqlExe.executeUpdate(new ReplanManageDBDAOAddSoListByCopCSQL(), param, velParam);
			
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
	 * @return int
	 * @throws DAOException
	 */
	public int addSceActRcvIfBySplit(SceCopHdrVO sceCopHdrVO, List<String> prtlBkgList) throws DAOException {
		int rowCnt = 0;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			Map<String, Object> param = new HashMap<String, Object> ();
			Map<String, Object> velParam = new HashMap<String, Object> ();
			
			param.put("new_bkg_no", sceCopHdrVO.getBkgNo());
			
			param.put("cntr_no", sceCopHdrVO.getCntrNo());
			param.put("cop_no", sceCopHdrVO.getCopNo());
			param.put("bkg_no", prtlBkgList.toArray());
			
			velParam.put("new_bkg_no", sceCopHdrVO.getBkgNo());
			
			velParam.put("cntr_no", sceCopHdrVO.getCntrNo());
			velParam.put("cop_no", sceCopHdrVO.getCopNo());
			velParam.put("bkg_no", prtlBkgList.toArray());
			
			rowCnt = sqlExe.executeUpdate(new ReplanManageDBDAOAddSceActRcvIfBySplitCSQL(), param, velParam);
			
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
	 * @param sceActTmlIfDtl
	 * @return int
	 * @throws DAOException
	 */
	public int mergeActTmlIfDtl(List<SceActTmlIfDtlVO> sceActTmlIfDtl) throws DAOException {
		int[] updCnt = null;

		int rowCnt = 0;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			updCnt = sqlExe.executeBatch(new ReplanManageDBDAOMergeActTmlIfDtlCSQL(), sceActTmlIfDtl,null);
			for(int i=0;i<updCnt.length;i++){
				if(updCnt[i]== Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update No"+ i + " SQL");
				else
					rowCnt += updCnt[i];
			}
			
//			rowCnt = new SQLExecuter("").executeUpdate((ISQLTemplate) new BkgCopManageDBDAOAddCopHdrCSQL(), param, valParam);
			
//			if(rowCnt == Statement.EXECUTE_FAILED)
//				throw new DAOException("Fail to update No"+ rowCnt + " SQL");
			
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
	 * @param scePlnSoListVO
	 * @return int
	 * @throws DAOException
	 */
	public int addPlnSoList(List<ScePlnSoListVO> scePlnSoListVO) throws DAOException {
		int[] updCnt = null;

		int rowCnt = 0;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			updCnt = sqlExe.executeBatch(new ReplanManageDBDAOAddPlnSoListCSQL(), scePlnSoListVO,null);
			for(int i=0;i<updCnt.length;i++){
				if(updCnt[i]== Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update No"+ i + " SQL");
				else
					rowCnt += updCnt[i];
			}
			
//			rowCnt = new SQLExecuter("").executeUpdate((ISQLTemplate) new BkgCopManageDBDAOAddCopHdrCSQL(), param, valParam);
			
//			if(rowCnt == Statement.EXECUTE_FAILED)
//				throw new DAOException("Fail to update No"+ rowCnt + " SQL");
			
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
	 * @param sceCopDtlVOList
	 * @return int
	 * @throws DAOException
	 */
	public int addCopDtl(List<SceCopDtlVO> sceCopDtlVOList) throws DAOException {
		int[] updCnt = null;

		int rowCnt = 0;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			updCnt = sqlExe.executeBatch(new ReplanManageDBDAOAddCopDtlByValuesCSQL(), sceCopDtlVOList, null);
			for(int i=0;i<updCnt.length;i++){
				if(updCnt[i]== Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update No"+ i + " SQL");
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
	 * @param sceCopHdrVOs
	 * @param copNo
	 * @return int
	 * @throws DAOException
	 */
	public int modifyCopHdr(List<SceCopHdrVO> sceCopHdrVOs, String copNo) throws DAOException {
		int rowCnt = 0;
		try {
			Map<String, Object> param = new HashMap<String, Object> ();
			Map<String, Object> velParam = new HashMap<String, Object> ();
			SQLExecuter sqlExe = new SQLExecuter();
			for (int i = 0; i < sceCopHdrVOs.size(); i ++) {
				SceCopHdrVO sceCopHdrVO = sceCopHdrVOs.get(i);
				param.clear();
				velParam.clear();
				if(CheckUtilities.isInBlank(copNo)) {
					param.putAll(sceCopHdrVO.getColumnValues());
					velParam.putAll(sceCopHdrVO.getColumnValues());
					int sub_rowCnt = sqlExe.executeUpdate(new ReplanManageDBDAOModifyCopHdrUSQL(), param, velParam);
					if(sub_rowCnt == Statement.EXECUTE_FAILED) {
						throw new DAOException("Fail to update No"+ rowCnt + " SQL");
					} else {						
						rowCnt += sub_rowCnt;
					}
				} else {
					if(sceCopHdrVO.getCopNo().equals(copNo)) {
						param.putAll(sceCopHdrVO.getColumnValues());
						velParam.putAll(sceCopHdrVO.getColumnValues());
						int sub_rowCnt = sqlExe.executeUpdate(new ReplanManageDBDAOModifyCopHdrUSQL(), param, velParam);
						if(sub_rowCnt == Statement.EXECUTE_FAILED) {
							throw new DAOException("Fail to update No"+ rowCnt + " SQL");
						} else {
							rowCnt += sub_rowCnt;
						}
						break;
					} else {
						continue;
					}
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
	public int modifyCopHdr(SceCopHdrVO sceCopHdrVO) throws DAOException {
		int rowCnt = 0;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			Map<String, Object> param = new HashMap<String, Object> ();
			Map<String, Object> velParam = new HashMap<String, Object> ();
			
			param.putAll(sceCopHdrVO.getColumnValues());
			velParam.putAll(sceCopHdrVO.getColumnValues());
			
			rowCnt = sqlExe.executeUpdate(new ReplanManageDBDAOModifyCopHdrUSQL(), param, velParam);
			
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
	public int modifyPlnSoList(ScePlnSoListVO scePlnSoList) throws DAOException {
		int rowCnt = 0;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			Map<String, Object> param = new HashMap<String, Object> ();
			Map<String, Object> velParam = new HashMap<String, Object> ();
			
			param.putAll(scePlnSoList.getColumnValues());
			velParam.putAll(scePlnSoList.getColumnValues());
			
			rowCnt = sqlExe.executeUpdate(new ReplanManageDBDAOModifyPlnSoListUSQL(), param, velParam);
			
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
			
			Map<String, Object> param = new HashMap<String, Object> ();
			Map<String, Object> velParam = new HashMap<String, Object> ();
			
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
	 * @param sceCopHdrVO
	 * @return int
	 * @throws DAOException
	 */
	public int modifyProvCntrByWRS(SceCopHdrVO sceCopHdrVO) throws DAOException {
		int rowCnt = 0;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			Map<String, Object> param = new HashMap<String, Object> ();
			Map<String, Object> velParam = new HashMap<String, Object> ();
			
			param.putAll(sceCopHdrVO.getColumnValues());
			velParam.putAll(sceCopHdrVO.getColumnValues());
			
			rowCnt = sqlExe.executeUpdate(new ReplanManageDBDAOModifyProvCntrByWRSUSQL(), param, velParam);
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
			
			Map<String, Object> param = new HashMap<String, Object> ();
			Map<String, Object> velParam = new HashMap<String, Object> ();
			
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
	 * @param sceActTmlIfList
	 * @return int
	 * @throws DAOException
	 */
	public int modifyActTmlIfStsCd(List<SceActTmlIfVO> sceActTmlIfList) throws DAOException {
		int[] delCnt = null;

		int rowCnt = 0;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			delCnt = sqlExe.executeBatch(new ReplanManageDBDAOModifyActTmlIfStsCdUSQL(), sceActTmlIfList, null);
			for(int i=0;i<delCnt.length;i++){
				if(delCnt[i]== Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to delete No"+ i + " SQL");
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
	 * @param sceActTmlIfList
	 * @return int
	 * @throws DAOException
	 */
	public int modifyActTmlIfRslt(List<SceActTmlIfVO> sceActTmlIfList) throws DAOException {
		int[] delCnt = null;

		int rowCnt = 0;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			delCnt = sqlExe.executeBatch(new ReplanManageDBDAOModifyActTmlIfRsltUSQL(), sceActTmlIfList, null);
			for(int i=0;i<delCnt.length;i++){
				if(delCnt[i]== Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to delete No"+ i + " SQL");
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
	 * @param fm_mst_cop_no
	 * @param to_mst_cop_no
	 * @param to_cop_no
	 * @return int
	 * @throws DAOException
	 */
	public int moveMstFlg(String fm_mst_cop_no, String to_mst_cop_no, String to_cop_no) throws DAOException {
		int rowCnt = 0;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			Map<String, Object> param = new HashMap<String, Object> ();
			Map<String, Object> velParam = new HashMap<String, Object> ();
			
			param.put("fm_mst_cop_no", fm_mst_cop_no);
			param.put("to_mst_cop_no", to_mst_cop_no);
			param.put("to_cop_no", to_cop_no);
			
			velParam.put("fm_mst_cop_no", fm_mst_cop_no);
			velParam.put("to_mst_cop_no", to_mst_cop_no);
			velParam.put("to_cop_no", to_cop_no);
			
			rowCnt = sqlExe.executeUpdate(new ReplanManageDBDAOMoveMstFlgUSQL(), param, velParam);
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
	 * @param cost_act_grp_seq
	 * @return int
	 * @throws DAOException
	 */
	public int modifySoStsPlnByUmchSo (String cop_no, String cost_act_grp_seq) throws DAOException {
		int rowCnt = 0;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			Map<String, Object> param = new HashMap<String, Object> ();
			Map<String, Object> velParam = new HashMap<String, Object> ();
			
			param.put("cop_no", cop_no);
			param.put("cost_act_grp_seq", cost_act_grp_seq);
			
			velParam.put("cop_no", cop_no);
			velParam.put("cost_act_grp_seq", cost_act_grp_seq);
			
			rowCnt = sqlExe.executeUpdate(new ReplanManageDBDAOModifySoStsPlnByUmchSoUSQL(), param, velParam);
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
	 * @param rplnVO
	 * @return int
	 * @throws DAOException
	 */
	public int modifySvcOrdUmchFlg(ReplanResultVO rplnVO) throws DAOException {
		int rowCnt = 0;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			Map<String, Object> param = new HashMap<String, Object> ();
			Map<String, Object> velParam = new HashMap<String, Object> ();
			
			param.put("trsp_so_ofc_cty_cd", rplnVO.getTrspSoOfcCtyCd());
			param.put("trsp_so_seq", rplnVO.getTrspSoSeq());
			param.put("rpln_umch_flg", rplnVO.getUmchFlg());
			
			velParam.put("trsp_so_ofc_cty_cd", rplnVO.getTrspSoOfcCtyCd());
			velParam.put("trsp_so_seq", rplnVO.getTrspSoSeq());
			velParam.put("rpln_umch_flg", rplnVO.getUmchFlg());
			
			rowCnt = sqlExe.executeUpdate(new ReplanManageDBDAOModifySvcOrdUmchFlgUSQL(), param, velParam);
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
	public int modifyPlnSo605(String cop_no) throws DAOException {
		int rowCnt = 0;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			Map<String, Object> param = new HashMap<String, Object> ();
			Map<String, Object> velParam = new HashMap<String, Object> ();
			
			param.put("cop_no", cop_no);
			velParam.put("cop_no", cop_no);
			
			rowCnt = sqlExe.executeUpdate(new ReplanManageDBDAOModifyPlnSo605USQL(), param, velParam);
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
			
			delCnt = sqlExe.executeBatch(new BkgCopManageDBDAORemoveCopDtlDSQL(), sceCopDtlVOs,null);
			for(int i=0;i<delCnt.length;i++){
				if(delCnt[i]== Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to delete No"+ i + " SQL");
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
	 * @param cop_no
	 * @return int
	 * @throws DAOException
	 */
	public int removeCopDtl(String cop_no) throws DAOException {
//		int[] delCnt = null;

		int rowCnt = 0;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			Map<String, Object> param = new HashMap<String, Object> ();
			Map<String, Object> velParam = new HashMap<String, Object> ();
			
			param.put("cop_no", cop_no);
			velParam.put("cop_no", cop_no);
			
			rowCnt = sqlExe.executeUpdate(new BkgCopManageDBDAORemoveCopDtlDSQL(), param, velParam);
//			for(int i=0;i<delCnt.length;i++){
//				if(delCnt[i]== Statement.EXECUTE_FAILED)
//					throw new DAOException("Fail to delete No"+ i + " SQL");
//				else
//					rowCnt += delCnt[i];
//			}
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
			
			delCnt = sqlExe.executeBatch(new BkgCopManageDBDAORemoveSoListDSQL(), scePlnSoListVOs,null);
			for(int i=0;i<delCnt.length;i++){
				if(delCnt[i]== Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to delete No"+ i + " SQL");
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
	 * @param cop_no
	 * @return int
	 * @throws DAOException
	 */
	public int removeSoList(String cop_no) throws DAOException {
		int rowCnt = 0;
		try {
			Map<String, Object> param = new HashMap<String, Object> ();
			Map<String, Object> velParam = new HashMap<String, Object> ();

			param.put("cop_no", cop_no);
			velParam.put("cop_no", cop_no);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			
			rowCnt = sqlExe.executeUpdate(new ReplanManageDBDAORemoveSoListDSQL(), param, velParam);
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
	 * searchSceTroMapg
	 * @param cop_no String
	 * @return SceTroMapgVO
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public SceTroMapgVO searchSceTroMapg(String cop_no) throws DAOException {
		DBRowSet dbRowset = null;
		List<SceTroMapgVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		param.put("cop_no", cop_no);
		velParam.put("cop_no", cop_no);
		SceTroMapgVO sceCopHdrVO = new SceTroMapgVO();
		try {
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new ReplanManageDBDAOSceTroMapgCheckRSQL(),
					param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SceTroMapgVO.class);
			if(list.size() > 0){
				sceCopHdrVO = list.get(0);
			}
			else{
				sceCopHdrVO = null;
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return sceCopHdrVO;
	}
}