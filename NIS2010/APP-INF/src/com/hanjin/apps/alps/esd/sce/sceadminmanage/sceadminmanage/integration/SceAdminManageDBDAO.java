/*=========================================================
 *Copyright(c) 2010 CyberLogitec
 *@FileName : SceAdminManageDBDAO.java
 *@FileTitle : SCE Admin
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2010.12.02
 *@LastModifier : 김인수
 *@LastVersion : 1.0
 * 2010.12.02 김인수
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.sceadminmanage.sceadminmanage.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.hanjin.apps.alps.esd.sce.copdetailreceive.vo.SceActRcvIfVO;
import com.hanjin.apps.alps.esd.sce.sceadminmanage.sceadminmanage.basic.SceAdminManageBCImpl;
import com.hanjin.apps.alps.esd.sce.sceadminmanage.sceadminmanage.event.EsdSce6000Event;
import com.hanjin.apps.alps.esd.sce.sceadminmanage.sceadminmanage.vo.CntrDiffVO;
import com.hanjin.apps.alps.esd.sce.sceadminmanage.sceadminmanage.vo.SceActTmlRtvVO;
import com.hanjin.apps.alps.esd.sce.sceadminmanage.sceadminmanage.vo.SceAdminObjVO;
import com.hanjin.apps.alps.esd.sce.sceadminmanage.sceadminmanage.vo.SearchLeaMonthlyWorkVO;
import com.hanjin.apps.alps.esd.sce.sceadminmanage.sceadminmanage.vo.SearchSceMnlRplnVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.SceActTmlIfVO;
import com.hanjin.syscommon.common.table.SceCopHdrVO;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;

/**
 * ALPS SceAdminManageDBDAO <br>
 * - ALPS-SceAdminManage system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Kim In-soo
 * @see SceAdminManageBCImpl 참조
 * @since J2EE 1.6
 */
public class SceAdminManageDBDAO extends DBDAOSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4936906160762652127L;

	/**
	 * @param tml_fm_dt - String
	 * @param tml_to_dt - String
	 * @return List<SceActTmlIfVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SceActTmlIfVO> searchTmlChgRslt(String tml_fm_dt, String tml_to_dt) throws DAOException {

		Map<String, String> velParam = new HashMap<String, String>();
		Map<String, String> param = new HashMap<String, String>();

		DBRowSet dbRowset = null;

		param.put("tml_fm_dt", tml_fm_dt);
		param.put("tml_to_dt", tml_to_dt);

		velParam.put("tml_fm_dt", tml_fm_dt);
		velParam.put("tml_to_dt", tml_to_dt);

		List<SceActTmlIfVO> rtnList = new ArrayList<SceActTmlIfVO>();

		try {
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SceAdminManageDBDAOSearchTmlChgRsltRSQL(),
					param, velParam);

			rtnList = (List) RowSetUtil.rowSetToVOs(dbRowset, SceActTmlRtvVO.class);

		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnList;
	}

	/**
	 * @param SceActTmlIfVO
	 *            sceActTmlIfVO
	 * @return int
	 * @throws DAOException
	 */
	public int modifyActTmlIfSts(SceActTmlIfVO sceActTmlIfVO) throws DAOException {
		Map<String, String> velParam = new HashMap<String, String>();
		Map<String, String> param = new HashMap<String, String>();

		String act_rcv_dt = sceActTmlIfVO.getActRcvDt();
		String act_rcv_no = sceActTmlIfVO.getActRcvNo();

		param.put("act_rcv_dt", act_rcv_dt);
		param.put("act_rcv_no", act_rcv_no);

		velParam.put("act_rcv_dt", act_rcv_dt);
		velParam.put("act_rcv_no", act_rcv_no);

		int updcnt = 0;
		try {
			updcnt = new SQLExecuter("").executeUpdate((ISQLTemplate) new SceAdminManageDBDAOModifyActTmlIfStsUSQL(),
					param, velParam);

		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return updcnt;
	}

	/**
	 * @param SceAdminObjVO sceAdminObjVO
	 * @return List<SceCopHdrVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SceCopHdrVO> searchRplnCops(SceAdminObjVO sceAdminObjVO ) throws DAOException {

		Map<String, String> velParam = new HashMap<String, String>();
		Map<String, String> param = new HashMap<String, String>();

		DBRowSet dbRowset = null;

		param.putAll(sceAdminObjVO.getColumnValues());
		velParam.putAll(sceAdminObjVO.getColumnValues());

		List<SceCopHdrVO> rtnList = new ArrayList<SceCopHdrVO>();

		try {
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SceAdminManageDBDAOSearchRplnCopsRSQL(),
					param, velParam);

			rtnList = (List) RowSetUtil.rowSetToVOs(dbRowset, SceCopHdrVO.class);

		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnList;
	}
	
	/**
	 * @param Set<String> bkgNoSet
	 * @return int
	 * @throws DAOException
	 */
	public int mergeMasCopIfMgmt(Set<String> bkgNoSet) throws DAOException {
		int mergeCnt = 0;

		try {
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			Map<String, Object> param = new HashMap<String, Object>();
			
			param.put("bkg_no", bkgNoSet.toArray());
			
			velParam.put("bkg_no", bkgNoSet.toArray());
			
			SQLExecuter sqlExe = new SQLExecuter("");
			
			mergeCnt = sqlExe.executeUpdate(new SceAdminManageDBDAOMergeMasCopIfMgmtUSQL(), param, velParam );
			if(mergeCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to merge No"+ mergeCnt + " SQL");

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
	 * @param Set<String> bkgNoSet
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
			
			mergeCnt = sqlExe.executeUpdate(new SceAdminManageDBDAOMergeCoaCopIfMgmtUSQL(), param, velParam );
			if(mergeCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to merge No"+ mergeCnt + " SQL");

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
	 * @param String fm_dt
	 * @param String to_dt
	 * @return List<SceCopHdrVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SceCopHdrVO> searchMstCopNoDiff(String fm_dt, String to_dt) throws DAOException {
		Map<String, String> velParam = new HashMap<String, String>();
		Map<String, String> param = new HashMap<String, String>();
		
		DBRowSet dbRowset = null;
		
		param.put("fm_dt", fm_dt);
		param.put("to_dt", to_dt);
		
		velParam.put("fm_dt", fm_dt);
		velParam.put("to_dt", to_dt);
		
		List<SceCopHdrVO> rtnList = new ArrayList<SceCopHdrVO> ();
		
		try {
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new SceAdminManageDBDAOSearchMstCopNoDiffRSQL(),
					param, velParam);
			
			rtnList = (List) RowSetUtil.rowSetToVOs(dbRowset, SceCopHdrVO.class);

		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnList;
	}
	
	/**
	 * @param String fm_dt
	 * @param String to_dt
	 * @return List<CntrDiffVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CntrDiffVO> searchCntrDiff(String fm_dt, String to_dt) throws DAOException {
		Map<String, String> velParam = new HashMap<String, String>();
		Map<String, String> param = new HashMap<String, String>();
		
		DBRowSet dbRowset = null;
		
		param.put("fm_dt", fm_dt);
		param.put("to_dt", to_dt);
		
		velParam.put("fm_dt", fm_dt);
		velParam.put("to_dt", to_dt);
		
		List<CntrDiffVO> rtnList = new ArrayList<CntrDiffVO> ();
		
		try {
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new SceAdminManageDBDAOSearchCntrDiffRSQL(),
					param, velParam);
			
			rtnList = (List) RowSetUtil.rowSetToVOs(dbRowset, CntrDiffVO.class);

		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnList;
	}
	
	/**
	 * @param SceAdminObjVO sceAdminObjVO
	 * @return List<SceActRcvIfVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SceActRcvIfVO> searchActDatRcvIf(SceAdminObjVO sceAdminObjVO) throws DAOException {
		Map<String, String> velParam = new HashMap<String, String>();
		Map<String, String> param = new HashMap<String, String>();
		
		DBRowSet dbRowset = null;
		
		param.putAll(sceAdminObjVO.getColumnValues());
		velParam.putAll(sceAdminObjVO.getColumnValues());
		
		List<SceActRcvIfVO> rtnList = new ArrayList<SceActRcvIfVO> ();
		
		try {
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new SceAdminManageDBDAOSearchActRcvIfRSQL(),
					param, velParam);
			
			rtnList = (List) RowSetUtil.rowSetToVOs(dbRowset, SceActRcvIfVO.class);

		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnList;
	}
	
	/**
	 * LEA 월말 결산 대상을 조회한다.
	 * @param Event e
	 * @return List<SearchLeaMonthlyWorkVO>
	 * @throws DAOException
	 */	
	@SuppressWarnings("unchecked")
	public List<SearchLeaMonthlyWorkVO> searchLeaMonthlyWorkCandidate(Event e) throws DAOException {
		Map<String, String> velParam = new HashMap<String, String>();
		Map<String, String> param = new HashMap<String, String>();
		
		DBRowSet dbRowset = null;
		EsdSce6000Event event = (EsdSce6000Event) e;
		
		List<SearchLeaMonthlyWorkVO> rtnList = new ArrayList<SearchLeaMonthlyWorkVO> ();
		param.put("leaAccMon", event.getLeaAccMon());
		velParam.put("leaAccMon", event.getLeaAccMon());
		
		try {
			dbRowset = new SQLExecuter("LEA_HJSLEA").executeQuery(
					(ISQLTemplate) new SceAdminManageDBDAOSearchLeaMonthlyWorkCandiateRSQL(),
					param, velParam);

			rtnList = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchLeaMonthlyWorkVO.class);

			log.debug("poong size = "+rtnList.size());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnList;
	}

	/**
	 * SCE_CSR_MNTR TABLE의 DATA를 삭제한다.
	 * @return int
	 * @throws DAOException
	 */
	public int delSceCsrMntr() throws DAOException {
		Map<String, String> velParam = new HashMap<String, String>();
		Map<String, String> param = new HashMap<String, String>();
		
		int returnCnt = 0;
			
		try {
			
			returnCnt = new SQLExecuter("").executeUpdate(
					(ISQLTemplate) new SceAdminManageDBDAODelSceCsrMntrDSQL(),
					param, velParam);
			
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return returnCnt;
	}
	
	/**
	 * LEA 대상을 SCE로 IF 한다.
	 * @param SearchLeaMonthlyWorkVO rtnList
	 * @return int
	 * @throws DAOException
	 */
	public int addCandidateSceCsrMntr(SearchLeaMonthlyWorkVO rtnList) throws DAOException {
		Map<String, String> velParam = new HashMap<String, String>();
		Map<String, String> param = new HashMap<String, String>();
		
		int returnCnt = 0;
		
		param.putAll(rtnList.getColumnValues());
		velParam.putAll(rtnList.getColumnValues());
		
		try {

			returnCnt = new SQLExecuter("").executeUpdate(
					(ISQLTemplate) new SceAdminManageDBDAOaddCandidateSceCsrMntrCSQL(),
					param, velParam);

		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return returnCnt;
	}
	
	/**
	 * LEA 결산 대상 데이타를 조회한다.
	 * @return List<SearchSceMnlRplnVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchSceMnlRplnVO> searchSceMngRplnCandidate() throws DAOException {
		Map<String, String> velParam = new HashMap<String, String>();
		Map<String, String> param = new HashMap<String, String>();
		
		DBRowSet dbRowset = null;
		
		List<SearchSceMnlRplnVO> rtnList = new ArrayList<SearchSceMnlRplnVO> ();
		
		try {
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new SceAdminManageDBDAOSearchSceMnlRplnCandidateRSQL(),
					param, velParam);
			
			rtnList = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchSceMnlRplnVO.class);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnList;
	}
	
	/**
	 * Manual Replan table에 replan대상을 추가한다.
	 * @param SearchSceMnlRplnVO rplnVo
	 * @return int
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public int addSceMngRpln(SearchSceMnlRplnVO rplnVo) throws DAOException {
		Map<String, String> velParam = new HashMap<String, String>();
		Map<String, String> param = new HashMap<String, String>();
		int returnCnt = 0;
		
		param.putAll(rplnVo.getColumnValues());
		velParam.putAll(rplnVo.getColumnValues());

		try {
			returnCnt = new SQLExecuter("").executeUpdate(
					(ISQLTemplate) new SceAdminManageDBDAOaddSceMngRplnCSQL(),
					param, velParam);

		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return returnCnt;
	}
	
	/**
	 * LEA 결산 대상 데이타를 조회한다.
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchSceMngRpln() throws DAOException {
		Map<String, String> velParam = new HashMap<String, String>();
		Map<String, String> param = new HashMap<String, String>();
		
		DBRowSet dbRowset = null;
		
		try {
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new SceAdminManageDBDAOSearchSceMngRplnRSQL(),
					param, velParam);
			
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}
}