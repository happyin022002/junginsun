/*=========================================================
 *Copyright(c) 2011 CyberLogitec
 *@FileName : seviceDBDAO.java
 *@FileTitle : activity
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2011.02.15
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2011.02.15 
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.bcm.ccd.commoncode.service.integration;
  
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.bcm.ccd.commoncode.service.basic.ServiceBCImpl;
import com.hanjin.apps.alps.bcm.ccd.commoncode.service.vo.ActivityVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.service.vo.MovementStatusVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.service.vo.RLaneDtlIbisIfVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.service.vo.RLaneDtlVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.service.vo.RLaneIbisIfVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.service.vo.RLaneVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.service.vo.SLaneDirVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.service.vo.SLaneIfVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.service.vo.SLaneVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.service.vo.ScopeLaneVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.service.vo.ScopeLimitVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.service.vo.ScopeVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.service.vo.SubTradeVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.service.vo.TradeIbisIfVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.service.vo.TradeVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * OPUS seviceDBDAO <br>
 * - OPUS-commoncode system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author
 * @see ServiceBCImpl 참조
 * @since J2EE 1.6
 */
public class ServiceDBDAO extends DBDAOSupport {

	/**
	 * act code로 상세 정보 조회합니다.<br>
	 * 
	 * @param String actCd
	 * @return ActivityVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public ActivityVO searchActCode(String actCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<ActivityVO> list = new ArrayList<ActivityVO>();
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (actCd != null && !"".equals(actCd)) {
				param.put("act_cd", actCd);
				velParam.put("act_cd", actCd);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ServiceDBDAOSearchActCodeRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, ActivityVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		if (list.size() > 0)
			return list.get(0);
		else
			return null;
	}

	/**
	 * 새로운 act code 생성합니다.<br>
	 * 
	 * @param ActivityVO actvo
	 * @exception DAOException
	 */
	public void addActCode(ActivityVO actvo) throws DAOException {
		int creCnt = 0;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (actvo != null) {
				Map<String, String> mapVO = actvo.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			creCnt = new SQLExecuter("").executeUpdate((ISQLTemplate) new ServiceDBDAOAddActCodeCSQL(), param, velParam);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 조회해 온 act code의 상세정보 수정합니다.<br>
	 * 
	 * @param ActivityVO actvo
	 * @exception DAOException
	 */
	public void modifyActCode(ActivityVO actvo) throws DAOException {
		int creCnt = 0;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (actvo != null) {
				Map<String, String> mapVO = actvo.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			creCnt = new SQLExecuter("").executeUpdate((ISQLTemplate) new ServiceDBDAOModifyActCodeUSQL(), param, velParam);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * mvmt sts code로 상세 정보 조회합니다.<br>
	 * 
	 * @param String mvmtStsCd
	 * @return MovementStatusVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public MovementStatusVO searchMvmtStsCode(String mvmtStsCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<MovementStatusVO> list = new ArrayList<MovementStatusVO>();
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (mvmtStsCd != null && !"".equals(mvmtStsCd)) {
				param.put("mvmt_sts_cd", mvmtStsCd);
				velParam.put("mvmt_sts_cd", mvmtStsCd);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ServiceDBDAOSearchMvmtStsCodeRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, MovementStatusVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		if (list.size() > 0)
			return list.get(0);
		else
			return null;
	}

	/**
	 * 새로운 mvmt sts code 생성합니다.<br>
	 * 
	 * @param MovementStatusVO mvmtstsvo
	 * @exception DAOException
	 */
	public void addMvmtStsCode(MovementStatusVO mvmtstsvo) throws DAOException {
		int creCnt = 0;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (mvmtstsvo != null) {
				Map<String, String> mapVO = mvmtstsvo.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			creCnt = new SQLExecuter("").executeUpdate((ISQLTemplate) new ServiceDBDAOAddMvmtStsCodeCSQL(), param, velParam);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 조회해 온 mvmt sts code의 상세정보 수정합니다.<br>
	 * 
	 * @param MovementStatusVO mvmtstsvo
	 * @exception DAOException
	 */
	public void modifyMvmtStsCode(MovementStatusVO mvmtstsvo) throws DAOException {
		int creCnt = 0;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (mvmtstsvo != null) {
				Map<String, String> mapVO = mvmtstsvo.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			creCnt = new SQLExecuter("").executeUpdate((ISQLTemplate) new ServiceDBDAOModifyMvmtStsCodeUSQL(), param, velParam);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * RLane code로 상세 정보 조회합니다.<br>
	 * 
	 * @param String rlaneCd
	 * @return RLaneVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public RLaneVO searchRlaneCode(String rlaneCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<RLaneVO> list = new ArrayList<RLaneVO>();
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (rlaneCd != null && !"".equals(rlaneCd)) {
				param.put("rlane_cd", rlaneCd);
				velParam.put("rlane_cd", rlaneCd);
				param.put("dtl_flg", "N");
				velParam.put("dtl_flg", "N");
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ServiceDBDAOSearchRlaneCodeRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RLaneVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		if (list.size() > 0)
			return list.get(0);
		else
			return null;
	}
	
	/**
	 * RLane code로 상세 정보 조회합니다.<br>
	 * 
	 * @param String rqstNo
	 * @return RLaneVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public RLaneVO searchRlaneCodeRqst(String rqstNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<RLaneVO> list = new ArrayList<RLaneVO>();
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (rqstNo != null && !"".equals(rqstNo)) {
				param.put("rqst_no", rqstNo);
				velParam.put("rqst_no", rqstNo);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ServiceDBDAOSearchRlaneCodeRqstRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RLaneVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		if (list.size() > 0)
			return list.get(0);
		else
			return null;
	}

	/**
	 * RLane code로 상세 정보 조회합니다.<br>
	 * 
	 * @param String rlaneCd
	 * @return List<RLaneDtlVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RLaneDtlVO> searchRlaneDtlCode(String rlaneCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<RLaneDtlVO> list = new ArrayList<RLaneDtlVO>();
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (rlaneCd != null && !"".equals(rlaneCd)) {
				param.put("rlane_cd", rlaneCd);
				velParam.put("rlane_cd", rlaneCd);
				param.put("dtl_flg", "Y");
				velParam.put("dtl_flg", "Y");
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ServiceDBDAOSearchRlaneCodeRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RLaneDtlVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		if (list.size() > 0)
			return list;
		else
			return null;
	}
	
	/**
	 * RLane code로 상세 정보 조회합니다.<br>
	 * 
	 * @param String rqstNo
	 * @return List<RLaneDtlVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RLaneDtlVO> searchRlaneDtlCodeRqst(String rqstNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<RLaneDtlVO> list = new ArrayList<RLaneDtlVO>();
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (rqstNo != null && !"".equals(rqstNo)) {
				param.put("rqst_no", rqstNo);
				velParam.put("rqst_no", rqstNo);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ServiceDBDAOSearchRlaneCodeRqstRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RLaneDtlVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		if (list.size() > 0)
			return list;
		else
			return null;
	}

	/**
	 * SLane code로 상세 정보 조회합니다.<br>
	 * 
	 * @param String slaneCd
	 * @return SLaneVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public SLaneVO searchSlaneCode(String slaneCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<SLaneVO> list = new ArrayList<SLaneVO>();
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (slaneCd != null && !"".equals(slaneCd)) {
				param.put("vsl_slan_cd", slaneCd);
				velParam.put("vsl_slan_cd", slaneCd);
				param.put("dir_flg", "N");
				velParam.put("dir_flg", "N");
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ServiceDBDAOSearchSlaneCodeRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SLaneVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		if (list.size() > 0)
			return list.get(0);
		else
			return null;
	}
	
	/**
	 * SLane code로 상세 정보 조회합니다.<br>
	 * 
	 * @param String rqstNo
	 * @return SLaneVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public SLaneVO searchSlaneRqst(String rqstNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<SLaneVO> list = new ArrayList<SLaneVO>();
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (rqstNo != null && !"".equals(rqstNo)) {
				param.put("rqst_no", rqstNo);
				velParam.put("rqst_no", rqstNo);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ServiceDBDAOSearchSlaneRqstRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SLaneVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		if (list.size() > 0)
			return list.get(0);
		else
			return null;
	}

	/**
	 * SLane code로 상세 정보 조회합니다.<br>
	 * 
	 * @param String slaneCd
	 * @return List<SLaneDirVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SLaneDirVO> searchSlaneDirCode(String slaneCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<SLaneDirVO> list = new ArrayList<SLaneDirVO>();
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (slaneCd != null && !"".equals(slaneCd)) {
				param.put("vsl_slan_cd", slaneCd);
				velParam.put("vsl_slan_cd", slaneCd);
				param.put("dir_flg", "Y");
				velParam.put("dir_flg", "Y");
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ServiceDBDAOSearchSlaneCodeRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SLaneDirVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		if (list.size() > 0)
			return list;
		else
			return null;
	}
	
	/**
	 * SLane code로 상세 정보 조회합니다.<br>
	 * 
	 * @param String rqstNo
	 * @return List<SLaneDirVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SLaneDirVO> searchSlaneDirRqst(String rqstNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<SLaneDirVO> list = new ArrayList<SLaneDirVO>();
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (rqstNo != null && !"".equals(rqstNo)) {
				param.put("rqst_no", rqstNo);
				velParam.put("rqst_no", rqstNo);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ServiceDBDAOSearchSlaneRqstRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SLaneDirVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		if (list.size() > 0)
			return list;
		else
			return null;
	}

	/**
	 * 새로운 slane code 생성합니다.<br>
	 * 
	 * @param SLaneVO slaneVO
	 * @exception DAOException
	 */
	public void addeSlaneCode(SLaneVO slaneVO) throws DAOException {
		int creCnt = 0;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (slaneVO != null) {
				Map<String, String> mapVO = slaneVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			creCnt = new SQLExecuter("").executeUpdate((ISQLTemplate) new ServiceDBDAOAddSlaneCodeCSQL(), param, velParam);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * 새로운 slane code 생성합니다.<br>
	 * 
	 * @param SLaneVO slaneVO
	 * @exception DAOException
	 */
	public void addeSlaneRqst(SLaneVO slaneVO) throws DAOException {
		int creCnt = 0;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (slaneVO != null) {
				Map<String, String> mapVO = slaneVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			creCnt = new SQLExecuter("").executeUpdate((ISQLTemplate) new ServiceDBDAOAddSlaneRqstCSQL(), param, velParam);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 조회해 온 slane code의 상세정보 수정합니다.<br>
	 * 
	 * @param SLaneVO slaneVO
	 * @exception DAOException
	 */
	public void modifyeSlaneCode(SLaneVO slaneVO) throws DAOException {
		int creCnt = 0;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (slaneVO != null) {
				Map<String, String> mapVO = slaneVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			creCnt = new SQLExecuter("").executeUpdate((ISQLTemplate) new ServiceDBDAOModifySlaneCodeUSQL(), param, velParam);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * 조회해 온 slane code의 상세정보 수정합니다.<br>
	 * 
	 * @param SLaneVO slaneVO
	 * @exception DAOException
	 */
	public void modifyeSlaneRqst(SLaneVO slaneVO) throws DAOException {
		int creCnt = 0;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (slaneVO != null) {
				Map<String, String> mapVO = slaneVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			creCnt = new SQLExecuter("").executeUpdate((ISQLTemplate) new ServiceDBDAOModifySlaneRqstUSQL(), param, velParam);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 새로운 slane detail code 생성합니다.<br>
	 * 
	 * @param List<SLaneDirVO> slaneVOs
	 * @exception DAOException
	 */
	public void addeSlaneDirCode(List<SLaneDirVO> slaneVOs) throws DAOException {
		int creCnt[] = null;
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (slaneVOs != null) {
				Map<String, String> mapVO = slaneVOs.get(0).getColumnValues();

				velParam.putAll(mapVO);
				
				creCnt = new SQLExecuter("").executeBatch((ISQLTemplate) new ServiceDBDAOAddSlaneDirCodeCSQL(), slaneVOs, velParam);
			}else{
				creCnt = new SQLExecuter("").executeBatch((ISQLTemplate) new ServiceDBDAOAddSlaneDirCodeCSQL(), null, velParam);
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
	 * 새로운 slane detail code 생성합니다.<br>
	 * 
	 * @param List<SLaneDirVO> slaneVOs
	 * @exception DAOException
	 */
	public void addeSlaneDirRqst(List<SLaneDirVO> slaneVOs) throws DAOException {
		int creCnt[] = null;
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (slaneVOs != null) {
				Map<String, String> mapVO = slaneVOs.get(0).getColumnValues();

				velParam.putAll(mapVO);
				
				creCnt = new SQLExecuter("").executeBatch((ISQLTemplate) new ServiceDBDAOAddSlaneDirRqstCSQL(), slaneVOs, velParam);
			}else{
				creCnt = new SQLExecuter("").executeBatch((ISQLTemplate) new ServiceDBDAOAddSlaneDirRqstCSQL(), null, velParam);
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
	 * 조회해 온 slane detail code의 상세정보 수정합니다.<br>
	 * 
	 * @param List<SLaneDirVO> slaneVOs
	 * @exception DAOException
	 */
	public void modifySlaneDirCode(List<SLaneDirVO> slaneVOs) throws DAOException {
		int creCnt[] = null;
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (slaneVOs != null) {
				Map<String, String> mapVO = slaneVOs.get(0).getColumnValues();

				velParam.putAll(mapVO);
				creCnt = new SQLExecuter("").executeBatch((ISQLTemplate) new ServiceDBDAOModifySlaneDirCodeUSQL(), slaneVOs, velParam);
			}else{
				creCnt = new SQLExecuter("").executeBatch((ISQLTemplate) new ServiceDBDAOModifySlaneDirCodeUSQL(), null, velParam);
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
	 * 조회해 온 slane detail code의 상세정보 수정합니다.<br>
	 * 
	 * @param List<SLaneDirVO> slaneVOs
	 * @exception DAOException
	 */
	public void modifySlaneDirRqst(List<SLaneDirVO> slaneVOs) throws DAOException {
		int creCnt[] = null;
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (slaneVOs != null) {
				Map<String, String> mapVO = slaneVOs.get(0).getColumnValues();

				velParam.putAll(mapVO);
				creCnt = new SQLExecuter("").executeBatch((ISQLTemplate) new ServiceDBDAOModifySlaneDirRqstUSQL(), slaneVOs, velParam);
			}else{
				creCnt = new SQLExecuter("").executeBatch((ISQLTemplate) new ServiceDBDAOModifySlaneDirRqstUSQL(), null, velParam);
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
	 * 조회해 온 slane code를 완전 삭제합니다.<br>
	 * 
	 * @param List<SLaneDirVO> slaneVOs
	 * @exception DAOException
	 */
	public void removeSlaneDirCode(List<SLaneDirVO> slaneVOs) throws DAOException {
		int creCnt[] = null;
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (slaneVOs != null) {
				Map<String, String> mapVO = slaneVOs.get(0).getColumnValues();

				velParam.putAll(mapVO);
				creCnt = new SQLExecuter("").executeBatch((ISQLTemplate) new ServiceDBDAORemoveSlaneDirCodeDSQL(), slaneVOs, velParam);
			}else{
				creCnt = new SQLExecuter("").executeBatch((ISQLTemplate) new ServiceDBDAORemoveSlaneDirCodeDSQL(), null, velParam);
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
	 * 조회해 온 slane code를 완전 삭제합니다.<br>
	 * 
	 * @param List<SLaneDirVO> slaneVOs
	 * @exception DAOException
	 */
	public void removeSlaneDirRqst(List<SLaneDirVO> slaneVOs) throws DAOException {
		int creCnt[] = null;
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (slaneVOs != null) {
				Map<String, String> mapVO = slaneVOs.get(0).getColumnValues();

				velParam.putAll(mapVO);
				creCnt = new SQLExecuter("").executeBatch((ISQLTemplate) new ServiceDBDAORemoveSlaneDirRqstDSQL(), slaneVOs, velParam);
			}else{
				creCnt = new SQLExecuter("").executeBatch((ISQLTemplate) new ServiceDBDAORemoveSlaneDirRqstDSQL(), null, velParam);
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
	 * 새로운 rlane code 생성합니다.<br>
	 * 
	 * @param RLaneVO rlaneVO
	 * @exception DAOException
	 */
	public void addeRlaneCode(RLaneVO rlaneVO) throws DAOException {
		int creCnt = 0;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (rlaneVO != null) {
				Map<String, String> mapVO = rlaneVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			creCnt = new SQLExecuter("").executeUpdate((ISQLTemplate) new ServiceDBDAOAddRlaneCodeCSQL(), param, velParam);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * rlane code IF 생성합니다.<br>
	 * 
	 * @param RLaneIbisIfVO rlaneVO
	 * @exception DAOException
	 */
	public void addRlaneCodeIbisIf(RLaneIbisIfVO rlaneVO) throws DAOException {
		int creCnt = 0;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (rlaneVO != null) {
				Map<String, String> mapVO = rlaneVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			creCnt = new SQLExecuter("").executeUpdate((ISQLTemplate) new ServiceDBDAOAddRlaneIbisIfCSQL(), param, velParam);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * 새로운 rlane code 생성합니다.<br>
	 * 
	 * @param RLaneVO rlaneVO
	 * @exception DAOException
	 */
	public void addeRlaneCodeRqst(RLaneVO rlaneVO) throws DAOException {
		int creCnt = 0;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (rlaneVO != null) {
				Map<String, String> mapVO = rlaneVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			creCnt = new SQLExecuter("").executeUpdate((ISQLTemplate) new ServiceDBDAOAddRlaneCodeRqstCSQL(), param, velParam);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 조회해 온 rlane code의 상세정보 수정합니다.<br>
	 * 
	 * @param RLaneVO rlaneVO
	 * @exception DAOException
	 */
	public void modifyeRlaneCode(RLaneVO rlaneVO) throws DAOException {
		int creCnt = 0;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (rlaneVO != null) {
				Map<String, String> mapVO = rlaneVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			creCnt = new SQLExecuter("").executeUpdate((ISQLTemplate) new ServiceDBDAOModifyRlaneCodeUSQL(), param, velParam);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * 조회해 온 rlane code의 상세정보 수정합니다.<br>
	 * 
	 * @param RLaneVO rlaneVO
	 * @exception DAOException
	 */
	public void modifyeRlaneCodeRqst(RLaneVO rlaneVO) throws DAOException {
		int creCnt = 0;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (rlaneVO != null) {
				Map<String, String> mapVO = rlaneVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			creCnt = new SQLExecuter("").executeUpdate((ISQLTemplate) new ServiceDBDAOModifyRlaneCodeRqstUSQL(), param, velParam);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 새로운 rlane detail code 생성합니다.<br>
	 * 
	 * @param List<RLaneDtlVO> rlaneVOs
	 * @exception DAOException
	 */
	public void addeRlaneDtlCode(List<RLaneDtlVO> rlaneVOs) throws DAOException {
		int creCnt[] = null;
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (rlaneVOs != null) {
				Map<String, String> mapVO = rlaneVOs.get(0).getColumnValues();

				velParam.putAll(mapVO);
				creCnt = new SQLExecuter("").executeBatch((ISQLTemplate) new ServiceDBDAOAddRlaneDtlCodeCSQL(), rlaneVOs, velParam);
			}else{
				creCnt = new SQLExecuter("").executeBatch((ISQLTemplate) new ServiceDBDAOAddRlaneDtlCodeCSQL(), null, velParam);
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
	 * rlane detail code IF 생성합니다.<br>
	 * 
	 * @param List<RLaneDtlIbisIfVO> rlaneVOs
	 * @exception DAOException
	 */
	public void addRlaneDtlIbisIf(List<RLaneDtlIbisIfVO> rlaneVOs) throws DAOException {
		int creCnt[] = null;
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (rlaneVOs != null) {
				Map<String, String> mapVO = rlaneVOs.get(0).getColumnValues();

				velParam.putAll(mapVO);
				creCnt = new SQLExecuter("").executeBatch((ISQLTemplate) new ServiceDBDAOAddRlaneDtlCodeIbisIfCSQL(), rlaneVOs, velParam);
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
	 * 새로운 rlane detail code 생성합니다.<br>
	 * 
	 * @param List<RLaneDtlVO> rlaneVOs
	 * @exception DAOException
	 */
	public void addeRlaneDtlCodeRqst(List<RLaneDtlVO> rlaneVOs) throws DAOException {
		int creCnt[] = null;
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (rlaneVOs != null) {
				Map<String, String> mapVO = rlaneVOs.get(0).getColumnValues();

				velParam.putAll(mapVO);
				creCnt = new SQLExecuter("").executeBatch((ISQLTemplate) new ServiceDBDAOAddRlaneDtlCodeRqstCSQL(), rlaneVOs, velParam);
			}else{
				creCnt = new SQLExecuter("").executeBatch((ISQLTemplate) new ServiceDBDAOAddRlaneDtlCodeRqstCSQL(), null, velParam);
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
	 * 조회해 온 rlane detail code의 상세정보 수정합니다.<br>
	 * 
	 * @param List<RLaneDtlVO> rlaneVOs
	 * @exception DAOException
	 */
	public void modifyRlaneDtlCode(List<RLaneDtlVO> rlaneVOs) throws DAOException {
		int creCnt[] = null;
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (rlaneVOs != null) {
				Map<String, String> mapVO = rlaneVOs.get(0).getColumnValues();

				velParam.putAll(mapVO);
				creCnt = new SQLExecuter("").executeBatch((ISQLTemplate) new ServiceDBDAOModifyRlaneDtlCodeUSQL(), rlaneVOs, velParam);
			}else{
				creCnt = new SQLExecuter("").executeBatch((ISQLTemplate) new ServiceDBDAOModifyRlaneDtlCodeUSQL(), null, velParam);
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
	 * 조회해 온 rlane detail code의 상세정보 수정합니다.<br>
	 * 
	 * @param List<RLaneDtlVO> rlaneVOs
	 * @exception DAOException
	 */
	public void modifyRlaneDtlCodeRqst(List<RLaneDtlVO> rlaneVOs) throws DAOException {
		int creCnt[] = null;
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (rlaneVOs != null) {
				Map<String, String> mapVO = rlaneVOs.get(0).getColumnValues();

				velParam.putAll(mapVO);
				creCnt = new SQLExecuter("").executeBatch((ISQLTemplate) new ServiceDBDAOModifyRlaneDtlCodeRqstUSQL(), rlaneVOs, velParam);
			}else{
				creCnt = new SQLExecuter("").executeBatch((ISQLTemplate) new ServiceDBDAOModifyRlaneDtlCodeRqstUSQL(), null, velParam);
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
	 * 조회해 온 rlane code를 완전 삭제합니다.<br>
	 * 
	 * @param List<RLaneDtlVO> rlaneVOs
	 * @exception DAOException
	 */
	public void removeRlaneDtlCode(List<RLaneDtlVO> rlaneVOs) throws DAOException {
		int creCnt[] = null;
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (rlaneVOs != null) {
				Map<String, String> mapVO = rlaneVOs.get(0).getColumnValues();

				velParam.putAll(mapVO);
				creCnt = new SQLExecuter("").executeBatch((ISQLTemplate) new ServiceDBDAORemoveRlaneDtlCodeDSQL(), rlaneVOs, velParam);
			}else{
				creCnt = new SQLExecuter("").executeBatch((ISQLTemplate) new ServiceDBDAORemoveRlaneDtlCodeDSQL(), null, velParam);
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
	 * 조회해 온 rlane code를 완전 삭제합니다.<br>
	 * 
	 * @param List<RLaneDtlVO> rlaneVOs
	 * @exception DAOException
	 */
	public void removeRlaneDtlCodeRqst(List<RLaneDtlVO> rlaneVOs) throws DAOException {
		int creCnt[] = null;
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (rlaneVOs != null) {
				Map<String, String> mapVO = rlaneVOs.get(0).getColumnValues();

				velParam.putAll(mapVO);
				creCnt = new SQLExecuter("").executeBatch((ISQLTemplate) new ServiceDBDAORemoveRlaneDtlCodeRqstDSQL(), rlaneVOs, velParam);
			}else{
				creCnt = new SQLExecuter("").executeBatch((ISQLTemplate) new ServiceDBDAORemoveRlaneDtlCodeRqstDSQL(), null, velParam);
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
	 * Scp code로 상세 정보 조회합니다.<br>
	 * 
	 * @param String scpCd
	 * @return ScopeVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public ScopeVO searchScpCode(String scpCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<ScopeVO> list = new ArrayList<ScopeVO>();
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (scpCd != null && !"".equals(scpCd)) {
				param.put("svc_scp_cd", scpCd);
				velParam.put("svc_scp_cd", scpCd);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ServiceDBDAOSearchScpCodeRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, ScopeVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		if (list.size() > 0)
			return list.get(0);
		else
			return null;
	}
	
	/**
	 * Scp code로 상세 정보 조회합니다.<br>
	 * 
	 * @param String rqstNo
	 * @return ScopeVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public ScopeVO searchScpRqst(String rqstNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<ScopeVO> list = new ArrayList<ScopeVO>();
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (rqstNo != null && !"".equals(rqstNo)) {
				param.put("rqst_no", rqstNo);
				velParam.put("rqst_no", rqstNo);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ServiceDBDAOSearchScpRqstRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, ScopeVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		if (list.size() > 0)
			return list.get(0);
		else
			return null;
	}

	/**
	 * Scp code로 상세 정보 조회합니다.<br>
	 * 
	 * @param String scpCd
	 * @return List<ScopeLaneVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ScopeLaneVO> searchScpLaneCode(String scpCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<ScopeLaneVO> list = new ArrayList<ScopeLaneVO>();
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (scpCd != null && !"".equals(scpCd)) {
				param.put("svc_scp_cd", scpCd);
				velParam.put("svc_scp_cd", scpCd);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ServiceDBDAOSearchScpLaneCodeRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, ScopeLaneVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		if (list.size() > 0)
			return list;
		else
			return null;
	}
	
	/**
	 * Scp code로 상세 정보 조회합니다.<br>
	 * 
	 * @param String rqstNo
	 * @return List<ScopeLaneVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ScopeLaneVO> searchScpLaneRqst(String rqstNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<ScopeLaneVO> list = new ArrayList<ScopeLaneVO>();
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (rqstNo != null && !"".equals(rqstNo)) {
				param.put("rqst_no", rqstNo);
				velParam.put("rqst_no", rqstNo);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ServiceDBDAOSearchScpLaneRqstRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, ScopeLaneVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		if (list.size() > 0)
			return list;
		else
			return null;
	}

	/**
	 * Scp code로 상세 정보 조회합니다.<br>
	 * 
	 * @param String scpCd
	 * @return List<ScopeLimitVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ScopeLimitVO> searchScpLimitCode(String scpCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<ScopeLimitVO> list = new ArrayList<ScopeLimitVO>();
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (scpCd != null && !"".equals(scpCd)) {
				param.put("svc_scp_cd", scpCd);
				velParam.put("svc_scp_cd", scpCd);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ServiceDBDAOSearchScpLimitCodeRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, ScopeLimitVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		if (list.size() > 0)
			return list;
		else
			return null;
	}
	
	/**
	 * Scp code로 상세 정보 조회합니다.<br>
	 * 
	 * @param String rqstNo
	 * @return List<ScopeLimitVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ScopeLimitVO> searchScpLimitRqst(String rqstNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<ScopeLimitVO> list = new ArrayList<ScopeLimitVO>();
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (rqstNo != null && !"".equals(rqstNo)) {
				param.put("rqst_no", rqstNo);
				velParam.put("rqst_no", rqstNo);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ServiceDBDAOSearchScpLimitRqstRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, ScopeLimitVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		if (list.size() > 0)
			return list;
		else
			return null;
	}

	/**
	 * 새로운 scp code 생성합니다.<br>
	 * 
	 * @param ScopeVO scpVO
	 * @exception DAOException
	 */
	public void addeScpCode(ScopeVO scpVO) throws DAOException {
		int creCnt = 0;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (scpVO != null) {
				Map<String, String> mapVO = scpVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			creCnt = new SQLExecuter("").executeUpdate((ISQLTemplate) new ServiceDBDAOAddScpCodeCSQL(), param, velParam);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * 새로운 scp code 생성합니다.<br>
	 * 
	 * @param ScopeVO scpVO
	 * @exception DAOException
	 */
	public void addeScpRqst(ScopeVO scpVO) throws DAOException {
		int creCnt = 0;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (scpVO != null) {
				Map<String, String> mapVO = scpVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			creCnt = new SQLExecuter("").executeUpdate((ISQLTemplate) new ServiceDBDAOAddScpRqstCSQL(), param, velParam);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 조회해 온 scp code의 상세정보 수정합니다.<br>
	 * 
	 * @param ScopeVO scpVO
	 * @exception DAOException
	 */
	public void modifyeScpCode(ScopeVO scpVO) throws DAOException {
		int creCnt = 0;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (scpVO != null) {
				Map<String, String> mapVO = scpVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			creCnt = new SQLExecuter("").executeUpdate((ISQLTemplate) new ServiceDBDAOModifyScpCodeUSQL(), param, velParam);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * 조회해 온 scp code의 상세정보 수정합니다.<br>
	 * 
	 * @param ScopeVO scpVO
	 * @exception DAOException
	 */
	public void modifyeScpRqst(ScopeVO scpVO) throws DAOException {
		int creCnt = 0;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (scpVO != null) {
				Map<String, String> mapVO = scpVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			creCnt = new SQLExecuter("").executeUpdate((ISQLTemplate) new ServiceDBDAOModifyScpRqstUSQL(), param, velParam);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 새로운 scp lane code 생성합니다.<br>
	 * 
	 * @param List<ScopeLaneVO> scpLaneVOs
	 * @exception DAOException
	 */
	public void addeScpLaneCode(List<ScopeLaneVO> scpLaneVOs) throws DAOException {
		int creCnt[] = null;
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (scpLaneVOs != null) {
				Map<String, String> mapVO = scpLaneVOs.get(0).getColumnValues();

				velParam.putAll(mapVO);
				creCnt = new SQLExecuter("").executeBatch((ISQLTemplate) new ServiceDBDAOAddScpLaneCodeCSQL(), scpLaneVOs, velParam);
			}else{
				creCnt = new SQLExecuter("").executeBatch((ISQLTemplate) new ServiceDBDAOAddScpLaneCodeCSQL(), null, velParam);
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
	 * 새로운 scp lane code 생성합니다.<br>
	 * 
	 * @param List<ScopeLaneVO> scpLaneVOs
	 * @exception DAOException
	 */
	public void addeScpLaneRqst(List<ScopeLaneVO> scpLaneVOs) throws DAOException {
		int creCnt[] = null;
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (scpLaneVOs != null) {
				Map<String, String> mapVO = scpLaneVOs.get(0).getColumnValues();

				velParam.putAll(mapVO);
				creCnt = new SQLExecuter("").executeBatch((ISQLTemplate) new ServiceDBDAOAddScpLaneRqstCSQL(), scpLaneVOs, velParam);
			}else{
				creCnt = new SQLExecuter("").executeBatch((ISQLTemplate) new ServiceDBDAOAddScpLaneRqstCSQL(), null, velParam);
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
	 * 조회해 온 scp lane code의 상세정보 수정합니다.<br>
	 * 
	 * @param List<ScopeLaneVO> scpLaneVOs
	 * @exception DAOException
	 */
	public void modifyScpLaneCode(List<ScopeLaneVO> scpLaneVOs) throws DAOException {
		int creCnt[] = null;
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (scpLaneVOs != null) {
				Map<String, String> mapVO = scpLaneVOs.get(0).getColumnValues();

				velParam.putAll(mapVO);
				creCnt = new SQLExecuter("").executeBatch((ISQLTemplate) new ServiceDBDAOModifyScpLaneCodeUSQL(), scpLaneVOs, velParam);
			}else{
				creCnt = new SQLExecuter("").executeBatch((ISQLTemplate) new ServiceDBDAOModifyScpLaneCodeUSQL(), null, velParam);
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
	 * 조회해 온 scp lane code의 상세정보 수정합니다.<br>
	 * 
	 * @param List<ScopeLaneVO> scpLaneVOs
	 * @exception DAOException
	 */
	public void modifyScpLaneRqst(List<ScopeLaneVO> scpLaneVOs) throws DAOException {
		int creCnt[] = null;
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (scpLaneVOs != null) {
				Map<String, String> mapVO = scpLaneVOs.get(0).getColumnValues();

				velParam.putAll(mapVO);
				creCnt = new SQLExecuter("").executeBatch((ISQLTemplate) new ServiceDBDAOModifyScpLaneRqstUSQL(), scpLaneVOs, velParam);
			}else{
				creCnt = new SQLExecuter("").executeBatch((ISQLTemplate) new ServiceDBDAOModifyScpLaneRqstUSQL(), null, velParam);
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
	 * 조회해 온 scp lane code를 완전 삭제합니다.<br>
	 * 
	 * @param List<ScopeLaneVO> scpLaneVOs
	 * @exception DAOException
	 */
	public void removeScpLaneCode(List<ScopeLaneVO> scpLaneVOs) throws DAOException {
		int creCnt[] = null;
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (scpLaneVOs != null) {
				Map<String, String> mapVO = scpLaneVOs.get(0).getColumnValues();

				velParam.putAll(mapVO);
				creCnt = new SQLExecuter("").executeBatch((ISQLTemplate) new ServiceDBDAORemoveScpLaneCodeDSQL(), scpLaneVOs, velParam);
			}else{
				creCnt = new SQLExecuter("").executeBatch((ISQLTemplate) new ServiceDBDAORemoveScpLaneCodeDSQL(), null, velParam);
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
	 * 조회해 온 scp lane code를 완전 삭제합니다.<br>
	 * 
	 * @param List<ScopeLaneVO> scpLaneVOs
	 * @exception DAOException
	 */
	public void removeScpLaneRqst(List<ScopeLaneVO> scpLaneVOs) throws DAOException {
		int creCnt[] = null;
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (scpLaneVOs != null) {
				Map<String, String> mapVO = scpLaneVOs.get(0).getColumnValues();

				velParam.putAll(mapVO);
				creCnt = new SQLExecuter("").executeBatch((ISQLTemplate) new ServiceDBDAORemoveScpLaneRqstDSQL(), scpLaneVOs, velParam);
			}else{
				creCnt = new SQLExecuter("").executeBatch((ISQLTemplate) new ServiceDBDAORemoveScpLaneRqstDSQL(), null, velParam);
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
	 * 새로운 scp limit code 생성합니다.<br>
	 * 
	 * @param List<ScopeLimitVO> scplimitVOs
	 * @exception DAOException
	 */
	public void addeScpLimitCode(List<ScopeLimitVO> scplimitVOs) throws DAOException {
		int creCnt[] = null;
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (scplimitVOs != null) {
				Map<String, String> mapVO = scplimitVOs.get(0).getColumnValues();

				velParam.putAll(mapVO);
				creCnt = new SQLExecuter("").executeBatch((ISQLTemplate) new ServiceDBDAOAddScpLimitCodeCSQL(), scplimitVOs, velParam);
			}else{
				creCnt = new SQLExecuter("").executeBatch((ISQLTemplate) new ServiceDBDAOAddScpLimitCodeCSQL(), null, velParam);
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
	 * 새로운 scp limit code 생성합니다.<br>
	 * 
	 * @param List<ScopeLimitVO> scplimitVOs
	 * @exception DAOException
	 */
	public void addeScpLimitRqst(List<ScopeLimitVO> scplimitVOs) throws DAOException {
		int creCnt[] = null;
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (scplimitVOs != null) {
				Map<String, String> mapVO = scplimitVOs.get(0).getColumnValues();

				velParam.putAll(mapVO);
				creCnt = new SQLExecuter("").executeBatch((ISQLTemplate) new ServiceDBDAOAddScpLimitRqstCSQL(), scplimitVOs, velParam);
			}else{
				creCnt = new SQLExecuter("").executeBatch((ISQLTemplate) new ServiceDBDAOAddScpLimitRqstCSQL(), null, velParam);
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
	 * 조회해 온 scp limit code의 상세정보 수정합니다.<br>
	 * 
	 * @param List<ScopeLimitVO> scplimitVOs
	 * @exception DAOException
	 */
	public void modifyScpLimitCode(List<ScopeLimitVO> scplimitVOs) throws DAOException {
		int creCnt[] = null;
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (scplimitVOs != null) {
				Map<String, String> mapVO = scplimitVOs.get(0).getColumnValues();

				velParam.putAll(mapVO);
				creCnt = new SQLExecuter("").executeBatch((ISQLTemplate) new ServiceDBDAOModifyScpLimitCodeUSQL(), scplimitVOs, velParam);
			}else{
				creCnt = new SQLExecuter("").executeBatch((ISQLTemplate) new ServiceDBDAOModifyScpLimitCodeUSQL(), null, velParam);
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
	 * 조회해 온 scp limit code의 상세정보 수정합니다.<br>
	 * 
	 * @param List<ScopeLimitVO> scplimitVOs
	 * @exception DAOException
	 */
	public void modifyScpLimitRqst(List<ScopeLimitVO> scplimitVOs) throws DAOException {
		int creCnt[] = null;
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (scplimitVOs != null) {
				Map<String, String> mapVO = scplimitVOs.get(0).getColumnValues();

				velParam.putAll(mapVO);
				creCnt = new SQLExecuter("").executeBatch((ISQLTemplate) new ServiceDBDAOModifyScpLimitRqstUSQL(), scplimitVOs, velParam);
			}else{
				creCnt = new SQLExecuter("").executeBatch((ISQLTemplate) new ServiceDBDAOModifyScpLimitRqstUSQL(), null, velParam);
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
	 * 조회해 온 scp limit code를 완전 삭제합니다.<br>
	 * 
	 * @param List<ScopeLimitVO> scplimitVOs
	 * @exception DAOException
	 */
	public void removeScpLimitCode(List<ScopeLimitVO> scplimitVOs) throws DAOException {
		int creCnt[] = null;
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (scplimitVOs != null) {
				Map<String, String> mapVO = scplimitVOs.get(0).getColumnValues();

				velParam.putAll(mapVO);
				creCnt = new SQLExecuter("").executeBatch((ISQLTemplate) new ServiceDBDAORemoveScpLimitCodeDSQL(), scplimitVOs, velParam);
			}else{
				creCnt = new SQLExecuter("").executeBatch((ISQLTemplate) new ServiceDBDAORemoveScpLimitCodeDSQL(), null, velParam);
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
	 * 조회해 온 scp limit code를 완전 삭제합니다.<br>
	 * 
	 * @param List<ScopeLimitVO> scplimitVOs
	 * @exception DAOException
	 */
	public void removeScpLimitRqst(List<ScopeLimitVO> scplimitVOs) throws DAOException {
		int creCnt[] = null;
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (scplimitVOs != null) {
				Map<String, String> mapVO = scplimitVOs.get(0).getColumnValues();

				velParam.putAll(mapVO);
				creCnt = new SQLExecuter("").executeBatch((ISQLTemplate) new ServiceDBDAORemoveScpLimitRqstDSQL(), scplimitVOs, velParam);
			}else{
				creCnt = new SQLExecuter("").executeBatch((ISQLTemplate) new ServiceDBDAORemoveScpLimitRqstDSQL(), null, velParam);
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
	 * trd code로 상세 정보 조회합니다.<br>
	 * 
	 * @param String trdCd
	 * @return TradeVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public TradeVO searchTrdCode(String trdCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<TradeVO> list = new ArrayList<TradeVO>();
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (trdCd != null && !"".equals(trdCd)) {
				param.put("trd_cd", trdCd);
				velParam.put("trd_cd", trdCd);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ServiceDBDAOSearchTrdCodeRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, TradeVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		if (list.size() > 0)
			return list.get(0);
		else
			return null;
	}
	
	/**
	 * trd code로 상세 정보 조회합니다.<br>
	 * 
	 * @param String rqstNo
	 * @return TradeVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public TradeVO searchTrdRqst(String rqstNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<TradeVO> list = new ArrayList<TradeVO>();
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (rqstNo != null && !"".equals(rqstNo)) {
				param.put("rqst_no", rqstNo);
				velParam.put("rqst_no", rqstNo);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ServiceDBDAOSearchTrdRqstRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, TradeVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		if (list.size() > 0)
			return list.get(0);
		else
			return null;
	}

	/**
	 * 새로운 trd code 생성합니다.<br>
	 * 
	 * @param TradeVO trdvo
	 * @exception DAOException
	 */
	public void addTrdCode(TradeVO trdvo) throws DAOException {
		int creCnt = 0;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (trdvo != null) {
				Map<String, String> mapVO = trdvo.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			creCnt = new SQLExecuter("").executeUpdate((ISQLTemplate) new ServiceDBDAOAddTrdCodeCSQL(), param, velParam);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Trade IBIS Interface.<br>
	 * 
	 * @param TradeIbisIfVO trdvo
	 * @exception DAOException
	 */
	public void addTrdIbisIf(TradeIbisIfVO trdvo) throws DAOException {
		int creCnt = 0;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (trdvo != null) {
				Map<String, String> mapVO = trdvo.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			creCnt = new SQLExecuter("").executeUpdate((ISQLTemplate) new ServiceDBDAOAddTradeIbisIfCSQL(), param, velParam);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * 새로운 trd code 생성합니다.<br>
	 * 
	 * @param TradeVO trdvo
	 * @exception DAOException
	 */
	public void addTrdRqst(TradeVO trdvo) throws DAOException {
		int creCnt = 0;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (trdvo != null) {
				Map<String, String> mapVO = trdvo.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			creCnt = new SQLExecuter("").executeUpdate((ISQLTemplate) new ServiceDBDAOAddTrdRqstCSQL(), param, velParam);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 조회해 온 trd code의 상세정보 수정합니다.<br>
	 * 
	 * @param TradeVO trdvo
	 * @exception DAOException
	 */
	public void modifyTrdCode(TradeVO trdvo) throws DAOException {
		int creCnt = 0;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (trdvo != null) {
				Map<String, String> mapVO = trdvo.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			creCnt = new SQLExecuter("").executeUpdate((ISQLTemplate) new ServiceDBDAOModifyTrdCodeUSQL(), param, velParam);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * 조회해 온 trd code의 상세정보 수정합니다.<br>
	 * 
	 * @param TradeVO trdvo
	 * @exception DAOException
	 */
	public void modifyTrdRqst(TradeVO trdvo) throws DAOException {
		int creCnt = 0;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (trdvo != null) {
				Map<String, String> mapVO = trdvo.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			creCnt = new SQLExecuter("").executeUpdate((ISQLTemplate) new ServiceDBDAOModifyTrdRqstUSQL(), param, velParam);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * sub trd code로 상세 정보 조회합니다.<br>
	 * 
	 * @param String subTrdCd
	 * @return SubTradeVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public SubTradeVO searchSubTrdCode(String subTrdCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<SubTradeVO> list = new ArrayList<SubTradeVO>();
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (subTrdCd != null && !"".equals(subTrdCd)) {
				param.put("sub_trd_cd", subTrdCd);
				velParam.put("sub_trd_cd", subTrdCd);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ServiceDBDAOSearchSubTrdCodeRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SubTradeVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		if (list.size() > 0)
			return list.get(0);
		else
			return null;
	}

	/**
	 * 새로운 sub trd code 생성합니다.<br>
	 * 
	 * @param SubTradeVO subTrdvo
	 * @exception DAOException
	 */
	public void addSubTrdCode(SubTradeVO subTrdvo) throws DAOException {
		int creCnt = 0;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (subTrdvo != null) {
				Map<String, String> mapVO = subTrdvo.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			creCnt = new SQLExecuter("").executeUpdate((ISQLTemplate) new ServiceDBDAOAddSubTrdCodeCSQL(), param, velParam);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 조회해 온 sub trd code의 상세정보 수정합니다.<br>
	 * 
	 * @param SubTradeVO subTrdvo
	 * @exception DAOException
	 */
	public void modifySubTrdCode(SubTradeVO subTrdvo) throws DAOException {
		int creCnt = 0;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (subTrdvo != null) {
				Map<String, String> mapVO = subTrdvo.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			creCnt = new SQLExecuter("").executeUpdate((ISQLTemplate) new ServiceDBDAOModifySubTrdCodeUSQL(), param, velParam);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * SLane EAI I/F 정보를 생성한다.(BCM_CCD_0028)<br>
	 *  
	 * @param SLaneIfVO slaneifVO
	 * @exception DAOException
	 */

	public void addSlaneInfoIf(SLaneIfVO slaneifVO) throws DAOException, Exception {
		//query parameter ,String usrId
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		//parameter Setting
		
		int result = 0;
		try {
			if(slaneifVO != null){
				Map<String, String> mapVO = slaneifVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}							
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new ServiceDBDAOAddSlaneIfCSQL(), param,velParam);
			if(result == Statement.EXECUTE_FAILED){
				throw new DAOException("Fail to insert SQL");		
		}

		}catch(SQLException se) 
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} 
		catch(Exception ex) 
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
	}
	
	/**
	 * SLane IBIS I/F 정보를 생성한다.(BCM_CCD_0028)<br>
	 *  
	 * @param SLaneIfVO slaneifVO
	 * @exception DAOException
	 */

	public void addSlaneInfoIbisIf(SLaneIfVO slaneifVO) throws DAOException, Exception {
		//query parameter ,String usrId
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		//parameter Setting
		
		int result = 0;
		try {
			if(slaneifVO != null){
				Map<String, String> mapVO = slaneifVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}							
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new ServiceDBDAOAddSlaneIbisIfCSQL(), param,velParam);
			if(result == Statement.EXECUTE_FAILED){
				throw new DAOException("Fail to insert SQL");		
		}

		}catch(SQLException se) 
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} 
		catch(Exception ex) 
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
	}

	/**
	 * SLane EAI I/F 의 테이블(MDM_VSL_SVC_LANE_IF)의 VSL_SLAN_SEQ 생성값을 조회 합니다.(BCM_CCD_0028)<br>
	 * 
	 * @return 	DbRowset 
	 * @exception DAOException
	 */
	public DBRowSet searchSlaneIfSeq() throws DAOException {
		// TODO Auto-generated method stub
		DBRowSet dbRowset = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체	
		try {		
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ServiceDBDAOSearchSlaneIfSeqRSQL(), null, null);
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());			
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);			
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}
}