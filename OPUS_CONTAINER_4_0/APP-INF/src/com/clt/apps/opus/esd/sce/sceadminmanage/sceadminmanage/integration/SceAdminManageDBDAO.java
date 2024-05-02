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
package com.clt.apps.opus.esd.sce.sceadminmanage.sceadminmanage.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.clt.apps.opus.esd.sce.copdetailreceive.vo.SceActRcvIfVO;
import com.clt.apps.opus.esd.sce.sceadminmanage.sceadminmanage.basic.SceAdminManageBCImpl;
import com.clt.apps.opus.esd.sce.sceadminmanage.sceadminmanage.vo.CntrDiffVO;
import com.clt.apps.opus.esd.sce.sceadminmanage.sceadminmanage.vo.SceActTmlRtvVO;
import com.clt.apps.opus.esd.sce.sceadminmanage.sceadminmanage.vo.SceAdminObjVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.syscommon.common.table.SceActTmlIfVO;
import com.clt.syscommon.common.table.SceCopHdrVO;

/**
 * SceAdminManageDBDAO <br>
 * - SceAdminManage system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
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
	@SuppressWarnings({ "rawtypes", "unchecked" })
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
	 * @param SceActTmlIfVO sceActTmlIfVO
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
	@SuppressWarnings({ "rawtypes", "unchecked" })
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
	@SuppressWarnings({ "rawtypes", "unchecked" })
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
	@SuppressWarnings({ "rawtypes", "unchecked" })
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
	@SuppressWarnings({ "rawtypes", "unchecked" })
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
}