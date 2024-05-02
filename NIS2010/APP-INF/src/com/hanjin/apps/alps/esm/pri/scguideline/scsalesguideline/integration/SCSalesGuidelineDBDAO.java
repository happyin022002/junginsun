/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : SCGuidelineMainDAO.java
 *@FileTitle : Guideline Creation
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.15
 *@LastModifier : 박성수
 *@LastVersion : 1.0
 * 2009.04.15 박성수
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scguideline.scsalesguideline.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.pri.scguideline.scsalesguideline.basic.SCSalesGuidelineBCImpl;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.PriSgMnVO;
import com.hanjin.syscommon.common.table.PriSgSlsRefVO;

/**
 * NIS2010 SCSalesGuidelineDAO <br>
 * - NIS2010-SCGuideline system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Park Sungsoo
 * @see SCSalesGuidelineBCImpl 참조
 * @since J2EE 1.4
 */
public class SCSalesGuidelineDBDAO extends DBDAOSupport {

	/**
	 * Sales Guideline을 조회합니다. <br>
	 * Sales 참조 내역을 조회하여 화면에 출력
	 * 
	 * @param PriSgSlsRefVO priSgSlsRefVO
	 * @return List<PriSgSlsRefVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<PriSgSlsRefVO> searchSalesGuidelineList(PriSgSlsRefVO priSgSlsRefVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PriSgSlsRefVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priSgSlsRefVO != null) {
				Map<String, String> mapVO = priSgSlsRefVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SCSalesGuidelineDBDAOPriSgSlsRefVORSQL(),
					param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, PriSgSlsRefVO.class);
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
	 * Sales Guideline에 대하여 다건의 데이터를 일괄적으로 생성한다.<br>
	 * Sales 대상 내역의 신규 내용을 추가함
	 * @param List<PriSgSlsRefVO> insModels
	 * @exception DAOException
	 */
	public void addSalesGuideline(List<PriSgSlsRefVO> insModels) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (insModels.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new SCSalesGuidelineDBDAOPriSgSlsRefVOCSQL(), insModels,
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
	 * Sales Guideline에 대하여 다건의 데이터를 일괄적으로 갱신한다.<br>
	 * Sales 참조 내역의 수정 내역을 반영함
	 * 
	 * @param List<PriSgSlsRefVO> updModels
	 * @exception DAOException
	 */
	public void modifySalesGuideline(List<PriSgSlsRefVO> updModels) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (updModels.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new SCSalesGuidelineDBDAOPriSgSlsRefVOUSQL(), updModels,
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
	 * Sales Guideline에 대하여 다건의 데이터를 일괄적으로 삭제한다.<br>
	 * Sales 참조 내역의 삭제 내역을 반영함
	 * 
	 * @param List<PriSgSlsRefVO> delModels
	 * @exception DAOException
	 */
	public void removeSalesGuideline(List<PriSgSlsRefVO> delModels) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (delModels.size() > 0) {
				delCnt = sqlExe.executeBatch((ISQLTemplate) new SCSalesGuidelineDBDAOPriSgSlsRefVODSQL(), delModels,
						null);
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
	 * Guideline Main에서 Guideline을 삭제한다.<br>
	 * Main Guideline 이 삭제되었을 경우 Sales 참조 내역을 일괄 삭제함
	 * 
	 * @param PriSgMnVO priSgMnVO
	 * @return int
	 * @exception DAOException
	 */
	public int removeGuidelineMainSalesGuideline(PriSgMnVO priSgMnVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = priSgMnVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new SCSalesGuidelineDBDAOPriSgMnVODSQL(), param, velParam);
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
}
