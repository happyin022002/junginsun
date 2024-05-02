/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : RFARateGuidelineDAO.java
 *@FileTitle : RFA Rate Guideline Creation
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.08.06
 *@LastModifier : 박성수
 *@LastVersion : 1.0
 * 2009.08.06 박성수
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaguideline.rfarateguideline.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.hanjin.apps.alps.esm.pri.rfaguideline.rfaguidelinemain.vo.RsltRfaGlineCopyVO;
import com.hanjin.apps.alps.esm.pri.rfaguideline.rfarateguideline.basic.RFARateGuidelineBCImpl;
import com.hanjin.apps.alps.esm.pri.rfaguideline.rfarateguideline.vo.RsltRfaRtListHorizontalExcelVO;
import com.hanjin.apps.alps.esm.pri.rfaguideline.rfarateguideline.vo.RsltRfaRtListVerticalExcelVO;
import com.hanjin.apps.alps.esm.pri.rfaguideline.rfarateguideline.vo.RsltRtCmdtDetailVO;
import com.hanjin.apps.alps.esm.pri.rfaguideline.rfarateguideline.vo.RsltRtCmdtHdrListVO;
import com.hanjin.apps.alps.esm.pri.rfaguideline.rfarateguideline.vo.RsltRtListExcelVO;
import com.hanjin.apps.alps.esm.pri.rfaguideline.rfarateguideline.vo.RsltRtListVO;
import com.hanjin.apps.alps.esm.pri.rfaguideline.rfarateguideline.vo.RsltRtRoutHdrListVO;
import com.hanjin.apps.alps.esm.pri.rfaguideline.rfarateguideline.vo.RsltRtRoutPntListVO;
import com.hanjin.apps.alps.esm.pri.rfaguideline.rfarateguideline.vo.RsltRtRoutViaListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.PriRgMnVO;
import com.hanjin.syscommon.common.table.PriRgRtCmdtHdrVO;
import com.hanjin.syscommon.common.table.PriRgRtCmdtRoutVO;
import com.hanjin.syscommon.common.table.PriRgRtCmdtVO;
import com.hanjin.syscommon.common.table.PriRgRtRoutPntVO;
import com.hanjin.syscommon.common.table.PriRgRtRoutViaVO;
import com.hanjin.syscommon.common.table.PriRgRtVO;

/**
 * NIS2010 RFARateGuidelineDBDAO <br>
 * - NIS2010-RFAGuideline system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Moon Dong Gyu
 * @see RFARateGuidelineBCImpl 참조
 * @since J2EE 1.4
 */
public class RFARateGuidelineDBDAO extends DBDAOSupport {

	/**
	 * Rate Guideline CMDT Header의 리스트를 조회한다.<br>
	 * 
	 * @param PriRgRtCmdtHdrVO vo
	 * @return List<RsltRtCmdtHdrListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltRtCmdtHdrListVO> searchRateCommodityHeaderList(PriRgRtCmdtHdrVO vo)
			throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltRtCmdtHdrListVO> list = null;
		
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (vo != null) {
				Map<String, String> mapVO = vo.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new RFARateGuidelineDBDAORsltRtCmdtHdrListVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltRtCmdtHdrListVO.class);
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
	 * Rate Guideline CMDT Detail의 리스트를 조회한다.<br>
	 * 
	 * @param PriRgRtCmdtHdrVO vo
	 * @return List<RsltRtCmdtDetailVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltRtCmdtDetailVO> searchRateCommodityDetailList(PriRgRtCmdtHdrVO vo)
			throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltRtCmdtDetailVO> list = null;
		
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (vo != null) {
				Map<String, String> mapVO = vo.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new RFARateGuidelineDBDAORsltRtCmdtDetailVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltRtCmdtDetailVO.class);
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
	 * Rate Guideline Route 리스트를 조회한다.<br>
	 * 
	 * @param PriRgRtCmdtRoutVO vo
	 * @return List<RsltRtRoutHdrListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltRtRoutHdrListVO> searchRateRouteHeaderList(PriRgRtCmdtRoutVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltRtRoutHdrListVO> list = null;
		
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (vo != null) {
				Map<String, String> mapVO = vo.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new RFARateGuidelineDBDAORsltRtRoutHdrListVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltRtRoutHdrListVO.class);
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
	 * Origin Point 리스트를 조회한다.<br>
	 * 
	 * @param PriRgRtVO vo
	 * @return List<RsltRtRoutPntListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltRtRoutPntListVO> searchRateRouteOriginPointList(PriRgRtVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltRtRoutPntListVO> list = null;
		
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (vo != null) {
				Map<String, String> mapVO = vo.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new RFARateGuidelineDBDAOOrgPriRgRtRoutPntVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltRtRoutPntListVO.class);
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
	 * Origin Via 리스트를 조회한다.<br>
	 * 
	 * @param PriRgRtVO vo
	 * @return List<RsltRtRoutViaListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltRtRoutViaListVO> searchRateRouteOriginViaList(PriRgRtVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltRtRoutViaListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (vo != null) {
				Map<String, String> mapVO = vo.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new RFARateGuidelineDBDAOOrgPriRgRtRoutViaVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltRtRoutViaListVO.class);
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
	 * Destination Via 리스트를 조회한다.<br>
	 * 
	 * @param PriRgRtVO vo
	 * @return List<RsltRtRoutViaListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltRtRoutViaListVO> searchRateRouteDestinationViaList(PriRgRtVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltRtRoutViaListVO> list = null;
		
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (vo != null) {
				Map<String, String> mapVO = vo.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new RFARateGuidelineDBDAODestPriRgRtRoutViaVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltRtRoutViaListVO.class);
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
	 * Destination Point 리스트를 조회한다.<br>
	 * 
	 * @param PriRgRtVO vo
	 * @return List<RsltRtRoutPntListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltRtRoutPntListVO> searchRateRouteDestinationPointList(PriRgRtVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltRtRoutPntListVO> list = null;
		
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (vo != null) {
				Map<String, String> mapVO = vo.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new RFARateGuidelineDBDAODestPriRgRtRoutPntVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltRtRoutPntListVO.class);
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
	 * Rate 리스트를 조회한다.<br>
	 * 
	 * @param PriRgRtVO vo
	 * @return List<RsltRtListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltRtListVO> searchRateList(PriRgRtVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltRtListVO> list = null;
		
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (vo != null) {
				Map<String, String> mapVO = vo.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateGuidelineDBDAORsltRtListVORSQL(),
					param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltRtListVO.class);
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
	 * Rate Guideline Excel Download 리스트를 조회한다.<br>
	 * 
	 * @param PriRgRtCmdtHdrVO vo
	 * @return List<RsltRtListExcelVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltRtListExcelVO> searchRateListExcel(PriRgRtCmdtHdrVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltRtListExcelVO> list = null;
		
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (vo != null) {
				Map<String, String> mapVO = vo.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateGuidelineDBDAORsltRtListExcelVORSQL(),
					param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltRtListExcelVO.class);
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
	 * RFA Guideline Rate 정보를 생성합니다.<br>
	 * 
	 * @param List<PriRgRtVO> insModels
	 * @exception DAOException
	 */
	public void addRate(List<PriRgRtVO> insModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (insModels.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateGuidelineDBDAOPriRgRtVOCSQL(), insModels, null);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Rate 데이터를 일괄적으로 갱신한다.<br>
	 * 
	 * @param List<PriRgRtVO> updModels
	 * @exception DAOException
	 */
	public void modifyRate(List<PriRgRtVO> updModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (updModels.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateGuidelineDBDAOPriRgRtVOUSQL(), updModels, null);
				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Rate 데이터를 일괄적으로 삭제한다.<br>
	 * 
	 * @param List<PriRgRtVO> delModels
	 * @exception DAOException
	 */
	public void removeRate(List<PriRgRtVO> delModels) throws DAOException {
		try {
			HashMap<String, Object> velParam = new HashMap<String, Object>();
			velParam.put("CASCADE_LEVEL", "3");

			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (delModels.size() > 0) {
				delCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateGuidelineDBDAOPriRgRtVODSQL(), delModels,
						velParam);
				for (int i = 0; i < delCnt.length; i++) {
					if (delCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * RFA Guideline Rate Commodity 정보를 생성합니다.<br>
	 * 
	 * @param List<PriRgRtCmdtVO> insModels
	 * @exception DAOException
	 */
	public void addRateCommodity(List<PriRgRtCmdtVO> insModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (insModels.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateGuidelineDBDAOPriRgRtCmdtVOCSQL(), insModels,
						null);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Commodity 데이터를 갱신한다.<br>
	 * 
	 * @param List<PriRgRtCmdtVO> updModels
	 * @exception DAOException
	 */
	public void modifyRateCommodity(List<PriRgRtCmdtVO> updModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (updModels.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateGuidelineDBDAOPriRgRtCmdtVOUSQL(), updModels,
						null);
				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Commodity 데이터를 삭제한다.<br>
	 * 
	 * @param List<PriRgRtCmdtVO> delModels
	 * @exception DAOException
	 */
	public void removeRateCommodity(List<PriRgRtCmdtVO> delModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (delModels.size() > 0) {
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("CASCADE_LEVEL", "2");

				delCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateGuidelineDBDAOPriRgRtCmdtVODSQL(), delModels,
						velParam);
				for (int i = 0; i < delCnt.length; i++) {
					if (delCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * RFA Guideline Rate Commodity Header 정보를 생성합니다.<br>
	 * 
	 * @param List<PriRgRtCmdtHdrVO> insModels
	 * @exception DAOException
	 */
	public void addRateCommodityHeader(List<PriRgRtCmdtHdrVO> insModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (insModels.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateGuidelineDBDAOPriRgRtCmdtHdrVOCSQL(), insModels,
						null);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Commodity Header 데이터를 갱신한다.<br>
	 * 
	 * @param List<PriRgRtCmdtHdrVO> updModels
	 * @exception DAOException
	 */
	public void modifyRateCommodityHeader(List<PriRgRtCmdtHdrVO> updModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (updModels.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateGuidelineDBDAOPriRgRtCmdtHdrVOUSQL(), updModels,
						null);
				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Commodity Header 데이터를 삭제한다.<br>
	 * 
	 * @param List<PriRgRtCmdtHdrVO> delModels
	 * @exception DAOException
	 */
	public void removeRateCommodityHeader(List<PriRgRtCmdtHdrVO> delModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (delModels.size() > 0) {
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("CASCADE_LEVEL", "1");

				delCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateGuidelineDBDAOPriRgRtCmdtHdrVODSQL(), delModels,
						velParam);
				for (int i = 0; i < delCnt.length; i++) {
					if (delCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Commodity Header 데이터를 삭제한다.<br>
	 * 
	 * @param List<PriRgRtCmdtHdrVO> delModels
	 * @exception DAOException
	 */
	public void removeRateCommodityHeaderCascadeCmdt(List<PriRgRtCmdtHdrVO> delModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (delModels.size() > 0) {
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("CASCADE_LEVEL", "1");

				delCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateGuidelineDBDAOPriRgRtCmdtVODSQL(), delModels,
						velParam);
				for (int i = 0; i < delCnt.length; i++) {
					if (delCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}

			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Commodity Header 데이터를 삭제한다.<br>
	 * 
	 * @param List<PriRgRtCmdtHdrVO> delModels
	 * @exception DAOException
	 */
	public void removeRateCommodityHeaderCascadeCmdtRout(List<PriRgRtCmdtHdrVO> delModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (delModels.size() > 0) {
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("CASCADE_LEVEL", "1");

				delCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateGuidelineDBDAOPriRgRtCmdtRoutVODSQL(), delModels,
						velParam);
				for (int i = 0; i < delCnt.length; i++) {
					if (delCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}

			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Commodity Header 데이터를 삭제한다.<br>
	 * 
	 * @param List<PriRgRtCmdtHdrVO> delModels
	 * @exception DAOException
	 */
	public void removeRateCommodityHeaderCascadeRoutPnt(List<PriRgRtCmdtHdrVO> delModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (delModels.size() > 0) {
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("CASCADE_LEVEL", "1");

				delCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateGuidelineDBDAOPriRgRtRoutPntVODSQL(), delModels,
						velParam);
				for (int i = 0; i < delCnt.length; i++) {
					if (delCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}

			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Commodity Header 데이터를 삭제한다.<br>
	 * 
	 * @param List<PriRgRtCmdtHdrVO> delModels
	 * @exception DAOException
	 */
	public void removeRateCommodityHeaderCascadeRoutVia(List<PriRgRtCmdtHdrVO> delModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (delModels.size() > 0) {
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("CASCADE_LEVEL", "1");

				delCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateGuidelineDBDAOPriRgRtRoutViaVODSQL(), delModels,
						velParam);
				for (int i = 0; i < delCnt.length; i++) {
					if (delCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}

			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Commodity Header 데이터를 삭제한다.<br>
	 * 
	 * @param List<PriRgRtCmdtHdrVO> delModels
	 * @exception DAOException
	 */
	public void removeRateCommodityHeaderCascadeRt(List<PriRgRtCmdtHdrVO> delModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (delModels.size() > 0) {
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("CASCADE_LEVEL", "1");

				delCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateGuidelineDBDAOPriRgRtVODSQL(), delModels,
						velParam);
				for (int i = 0; i < delCnt.length; i++) {
					if (delCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}

			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * RFA Guideline Rate Commodity Route 정보를 생성합니다.<br>
	 * 
	 * @param List<PriRgRtCmdtRoutVO> insModels
	 * @exception DAOException
	 */
	public void addRateCommodityRoute(List<PriRgRtCmdtRoutVO> insModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (insModels.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateGuidelineDBDAOPriRgRtCmdtRoutVOCSQL(), insModels,
						null);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Route 데이터를 일괄적으로 갱신한다.<br>
	 * 
	 * @param List<PriRgRtCmdtRoutVO> updModels
	 * @exception DAOException
	 */
	public void modifyRateCommodityRoute(List<PriRgRtCmdtRoutVO> updModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (updModels.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateGuidelineDBDAOPriRgRtCmdtRoutVOUSQL(), updModels,
						null);
				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Route 데이터를 일괄적으로 삭제한다.<br>
	 * 
	 * @param List<PriRgRtCmdtRoutVO> delModels
	 * @exception DAOException
	 */
	public void removeRateCommodityRoute(List<PriRgRtCmdtRoutVO> delModels) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (delModels.size() > 0) {
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("CASCADE_LEVEL", "2");

				delCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateGuidelineDBDAOPriRgRtCmdtRoutVODSQL(), delModels,
						velParam);
				for (int i = 0; i < delCnt.length; i++) {
					if (delCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Route 데이터를 일괄적으로 삭제한다.<br>
	 * 
	 * @param List<PriRgRtCmdtRoutVO> delModels
	 * @exception DAOException
	 */
	public void removeRateCommodityRouteCascadeRoutPnt(List<PriRgRtCmdtRoutVO> delModels) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (delModels.size() > 0) {
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("CASCADE_LEVEL", "2");

				delCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateGuidelineDBDAOPriRgRtRoutPntVODSQL(), delModels,
						velParam);
				for (int i = 0; i < delCnt.length; i++) {
					if (delCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}

			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Route 데이터를 일괄적으로 삭제한다.<br>
	 * 
	 * @param List<PriRgRtCmdtRoutVO> delModels
	 * @exception DAOException
	 */
	public void removeRateCommodityRouteCascadeRoutVia(List<PriRgRtCmdtRoutVO> delModels) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (delModels.size() > 0) {
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("CASCADE_LEVEL", "2");

				delCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateGuidelineDBDAOPriRgRtRoutViaVODSQL(), delModels,
						velParam);
				for (int i = 0; i < delCnt.length; i++) {
					if (delCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}

			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Route 데이터를 일괄적으로 삭제한다.<br>
	 * 
	 * @param List<PriRgRtCmdtRoutVO> delModels
	 * @exception DAOException
	 */
	public void removeRateCommodityRouteCascadeRt(List<PriRgRtCmdtRoutVO> delModels) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (delModels.size() > 0) {
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("CASCADE_LEVEL", "2");

				delCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateGuidelineDBDAOPriRgRtVODSQL(), delModels,
						velParam);
				for (int i = 0; i < delCnt.length; i++) {
					if (delCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}

			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * RFA Guideline Rate Route Point 정보를 생성합니다.<br>
	 * 
	 * @param List<PriRgRtRoutPntVO> insModels
	 * @exception DAOException
	 */
	public void addRateRoutePoint(List<PriRgRtRoutPntVO> insModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (insModels.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateGuidelineDBDAOPriRgRtRoutPntVOCSQL(), insModels,
						null);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Route Point 데이터를 일괄적으로 갱신한다.<br>
	 * 
	 * @param List<PriRgRtRoutPntVO> updModels
	 * @exception DAOException
	 */
	public void modifyRateRoutePoint(List<PriRgRtRoutPntVO> updModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (updModels.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateGuidelineDBDAOPriRgRtRoutPntVOUSQL(), updModels,
						null);
				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Route Point 데이터를 일괄적으로 삭제한다.<br>
	 * 
	 * @param List<PriRgRtRoutPntVO> delModels
	 * @exception DAOException
	 */
	public void removeRateRoutePoint(List<PriRgRtRoutPntVO> delModels) throws DAOException {
		try {
			HashMap<String, Object> velParam = new HashMap<String, Object>();
			velParam.put("CASCADE_LEVEL", "3");

			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (delModels.size() > 0) {
				delCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateGuidelineDBDAOPriRgRtRoutPntVODSQL(), delModels,
						velParam);
				for (int i = 0; i < delCnt.length; i++) {
					if (delCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * RFA Guideline Rate Route Via 정보를 생성합니다.<br>
	 * 
	 * @param List<PriRgRtRoutViaVO> insModels
	 * @exception DAOException
	 */
	public void addRateRouteVia(List<PriRgRtRoutViaVO> insModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (insModels.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateGuidelineDBDAOPriRgRtRoutViaVOCSQL(), insModels,
						null);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Route Via. 데이터를 일괄적으로 갱신한다.<br>
	 * 
	 * @param List<PriRgRtRoutViaVO> updModels
	 * @exception DAOException
	 */
	public void modifyRateRouteVia(List<PriRgRtRoutViaVO> updModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (updModels.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateGuidelineDBDAOPriRgRtRoutViaVOUSQL(), updModels,
						null);
				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Route Via. 데이터를 일괄적으로 삭제한다.<br>
	 * 
	 * @param List<PriRgRtRoutViaVO> delModels
	 * @exception DAOException
	 */
	public void removeRateRouteVia(List<PriRgRtRoutViaVO> delModels) throws DAOException {
		try {
			HashMap<String, Object> velParam = new HashMap<String, Object>();
			velParam.put("CASCADE_LEVEL", "3");

			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (delModels.size() > 0) {
				delCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateGuidelineDBDAOPriRgRtRoutViaVODSQL(), delModels,
						velParam);
				for (int i = 0; i < delCnt.length; i++) {
					if (delCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * GuidelineMain을 삭제한다.<br>
	 * 
	 * @param PriRgMnVO vo
	 * @return int
	 * @exception DAOException
	 */
	public int removeGuidelineMainRate(PriRgMnVO vo) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = vo.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new RFARateGuidelineDBDAOPriRgMnVORtDSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}

	/**
	 * 단건의 데이터를 삭제한다.<br>
	 * 
	 * @param PriRgMnVO vo
	 * @return int
	 * @exception DAOException
	 */
	public int removeGuidelineMainRateCommodity(PriRgMnVO vo) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = vo.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new RFARateGuidelineDBDAOPriRgMnVOCmdtDSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}

	/**
	 * 단건의 데이터를 삭제한다.<br>
	 * 
	 * @param PriRgMnVO vo
	 * @return int
	 * @exception DAOException
	 */
	public int removeGuidelineMainRateCommodityHdr(PriRgMnVO vo) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = vo.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new RFARateGuidelineDBDAOPriRgMnVOCmdtHdrDSQL(), param,
					velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}

	/**
	 * Route 데이터를 삭제한다.<br>
	 * 
	 * @param PriRgMnVO vo
	 * @return int
	 * @exception DAOException
	 */
	public int removeGuidelineMainRateCommodityRoute(PriRgMnVO vo) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = vo.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new RFARateGuidelineDBDAOPriRgMnVOCmdtRoutDSQL(), param,
					velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}

	/**
	 * Commodity 데이터를 삭제한다.<br>
	 * 
	 * @param PriRgMnVO vo
	 * @return int
	 * @exception DAOException
	 */
	public int removeGuidelineMainRateRoutePoint(PriRgMnVO vo) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = vo.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new RFARateGuidelineDBDAOPriRgMnVORoutPntDSQL(), param,
					velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}

	/**
	 * Route Via. 데이터를 삭제한다.<br>
	 * 
	 * @param PriRgMnVO vo
	 * @return int
	 * @exception DAOException
	 */
	public int removeGuidelineMainRateRouteVia(PriRgMnVO vo) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = vo.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new RFARateGuidelineDBDAOPriRgMnVORoutViaDSQL(), param,
					velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}

    /**
     * RFA Guideline Rate Commodity Header 의 신규 Commodity Header Sequence 를 조회합니다.<br>
     * 
     * @param PriRgRtCmdtHdrVO priRgRtCmdtHdrVO
     * @return int
     * @exception DAOException
     */
    public int searchNextCmdtHdrSeq(PriRgRtCmdtHdrVO priRgRtCmdtHdrVO) throws DAOException {
        int nextSeq = -1;
        DBRowSet dbRowset = null;

        Map<String, Object> param = new HashMap<String, Object>();

        try {
            Map<String, String> mapVO = priRgRtCmdtHdrVO.getColumnValues();
            param.putAll(mapVO);
                
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateGuidelineDBDAOGetNextCmdtHdrSeqRSQL(), param, null);
            if (dbRowset != null && dbRowset.getRowCount() > 0 && dbRowset.next()) {
                nextSeq = dbRowset.getInt("next_seq");
            }

        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return nextSeq;
    }

    /**
     * Commodity Group Code 의 존재여부를 조회합니다.<br>
     * 
     * @param RsltCdListVO rsltCdListVO
     * @return RsltCdListVO
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public RsltCdListVO searchCommodityCodeExists(RsltCdListVO rsltCdListVO) throws DAOException {
        List<RsltCdListVO> list = null;
        DBRowSet dbRowset = null;

        Map<String, Object> param = new HashMap<String, Object>();

        try {
            Map<String, String> mapVO = rsltCdListVO.getColumnValues();
            param.putAll(mapVO);
            
            if (rsltCdListVO.getCd().length() == 5) {
                dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateGuidelineDBDAOLoadExcelCheckGrpCmdtRSQL(), param, null);
            } else if (rsltCdListVO.getCd().length() == 4) {
                dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateGuidelineDBDAOLoadExcelCheckRepCmdtRSQL(), param, null);
            } else if (rsltCdListVO.getCd().length() == 6) {
                dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateGuidelineDBDAOLoadExcelCheckCmdtRSQL(), param, null);
            } else {
                return null;
            }

            list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltCdListVO.class);
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        
        if (list == null || list.size() <= 0) {
            return null;
        } else {
            return list.get(0);
        }
    }

    /**
     * Location Group Code 의 존재여부를 조회합니다.<br>
     * 
     * @param RsltCdListVO rsltCdListVO
     * @return RsltCdListVO
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public RsltCdListVO searchLocationCodeExists(RsltCdListVO rsltCdListVO) throws DAOException {
        List<RsltCdListVO> list = null;
        DBRowSet dbRowset = null;

        Map<String, Object> param = new HashMap<String, Object>();

        try {
            Map<String, String> mapVO = rsltCdListVO.getColumnValues();
            param.putAll(mapVO);
            
            if (rsltCdListVO.getCd().length() == 4) {
                dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateGuidelineDBDAOLoadExcelCheckGrpLocRSQL(), param, null);
            } else if (rsltCdListVO.getCd().length() == 5) {
                dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateGuidelineDBDAOLoadExcelCheckLocRSQL(), param, null);
            } else {
                return null;
            }
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltCdListVO.class);
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        
        if (list == null || list.size() <= 0) {
            return null;
        } else {
            return list.get(0);
        }
    }

    /**
     * Guideline Rate Vertical Excel Download 리스트를 조회합니다.<br>
     * 
     * @param PriRgRtCmdtHdrVO priRgRtCmdtHdrVO
     * @return List<RsltRfaRtListVerticalExcelVO>
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public List<RsltRfaRtListVerticalExcelVO> searchRateListVerticalExcel(PriRgRtCmdtHdrVO priRgRtCmdtHdrVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<RsltRfaRtListVerticalExcelVO> list = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            if (priRgRtCmdtHdrVO != null) {
                Map<String, String> mapVO = priRgRtCmdtHdrVO.getColumnValues();

                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateGuidelineDBDAORsltRtListVerticalExcelVORSQL(),
                    param, velParam);
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltRfaRtListVerticalExcelVO.class);
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
     * Guideline Rate Horizontal Excel Download 리스트를 조회합니다.<br>
     * 
     * @param PriRgRtCmdtHdrVO priRgRtCmdtHdrVO
     * @return List<RsltRfaRtListHorizontalExcelVO>
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public List<RsltRfaRtListHorizontalExcelVO> searchRateListHorizontalExcel(PriRgRtCmdtHdrVO priRgRtCmdtHdrVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<RsltRfaRtListHorizontalExcelVO> list = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            if (priRgRtCmdtHdrVO != null) {
                Map<String, String> mapVO = priRgRtCmdtHdrVO.getColumnValues();

                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateGuidelineDBDAORsltRtListHorizontalExcelVORSQL(),
                    param, velParam);
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltRfaRtListHorizontalExcelVO.class);
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
     * Copy 한 RFA Guideline Rate Commodity Header 정보를 생성합니다.<br>
     * 
     * @param RsltRfaGlineCopyVO rsltRfaGlineCopyVO
     * @exception DAOException
     */
    public void addGlineCopyRateCmdtHdr(RsltRfaGlineCopyVO rsltRfaGlineCopyVO) throws DAOException {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        int result = 0;
        try {
            Map<String, String> mapVO = rsltRfaGlineCopyVO.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            result = sqlExe.executeUpdate(
                    (ISQLTemplate) new RFARateGuidelineDBDAOGlineCopyRtCmdtHdrCSQL(), param, velParam);
            if (result == Statement.EXECUTE_FAILED)
                throw new DAOException("Fail to insert SQL");
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return;
    }
    
    /**
     * Copy 한 RFA Guideline Rate Commodity 정보를 생성합니다.<br>
     * 
     * @param RsltRfaGlineCopyVO rsltRfaGlineCopyVO
     * @exception DAOException
     */
    public void addGlineCopyRateCmdt(RsltRfaGlineCopyVO rsltRfaGlineCopyVO) throws DAOException {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        int result = 0;
        try {
            Map<String, String> mapVO = rsltRfaGlineCopyVO.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            result = sqlExe.executeUpdate(
                    (ISQLTemplate) new RFARateGuidelineDBDAOGlineCopyRtCmdtCSQL(), param, velParam);
            if (result == Statement.EXECUTE_FAILED)
                throw new DAOException("Fail to insert SQL");
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return;
    }
    
    /**
     * Copy 한 RFA Guideline Rate Commodity Route 정보를 생성합니다.<br>
     * 
     * @param RsltRfaGlineCopyVO rsltRfaGlineCopyVO
     * @exception DAOException
     */
    public void addGlineCopyRateCmdtRout(RsltRfaGlineCopyVO rsltRfaGlineCopyVO) throws DAOException {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        int result = 0;
        try {
            Map<String, String> mapVO = rsltRfaGlineCopyVO.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            result = sqlExe.executeUpdate(
                    (ISQLTemplate) new RFARateGuidelineDBDAOGlineCopyRtRoutCSQL(), param, velParam);
            if (result == Statement.EXECUTE_FAILED)
                throw new DAOException("Fail to insert SQL");
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return;
    }
    
    /**
     * Copy 한 RFA Guideline Rate Route Point 정보를 생성합니다.<br>
     * 
     * @param RsltRfaGlineCopyVO rsltRfaGlineCopyVO
     * @exception DAOException
     */
    public void addGlineCopyRateRoutPnt(RsltRfaGlineCopyVO rsltRfaGlineCopyVO) throws DAOException {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        int result = 0;
        try {
            Map<String, String> mapVO = rsltRfaGlineCopyVO.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            result = sqlExe.executeUpdate(
                    (ISQLTemplate) new RFARateGuidelineDBDAOGlineCopyRtRoutPntCSQL(), param, velParam);
            if (result == Statement.EXECUTE_FAILED)
                throw new DAOException("Fail to insert SQL");
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return;
    }
    
    /**
     * Copy 한 RFA Guideline Rate Route Via 정보를 생성합니다.<br>
     * 
     * @param RsltRfaGlineCopyVO rsltRfaGlineCopyVO
     * @exception DAOException
     */
    public void addGlineCopyRateRoutVia(RsltRfaGlineCopyVO rsltRfaGlineCopyVO) throws DAOException {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        int result = 0;
        try {
            Map<String, String> mapVO = rsltRfaGlineCopyVO.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            result = sqlExe.executeUpdate(
                    (ISQLTemplate) new RFARateGuidelineDBDAOGlineCopyRtRoutViaCSQL(), param, velParam);
            if (result == Statement.EXECUTE_FAILED)
                throw new DAOException("Fail to insert SQL");
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return;
    }
    
    /**
     * Copy 한 RFA Guideline Rate 정보를 생성합니다.<br>
     * 
     * @param RsltRfaGlineCopyVO rsltRfaGlineCopyVO
     * @exception DAOException
     */
    public void addGlineCopyRate(RsltRfaGlineCopyVO rsltRfaGlineCopyVO) throws DAOException {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        int result = 0;
        try {
            Map<String, String> mapVO = rsltRfaGlineCopyVO.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            result = sqlExe.executeUpdate(
                    (ISQLTemplate) new RFARateGuidelineDBDAOGlineCopyRtCSQL(), param, velParam);
            if (result == Statement.EXECUTE_FAILED)
                throw new DAOException("Fail to insert SQL");
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return;
    }

}