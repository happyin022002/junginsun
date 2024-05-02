/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ExpensePlanDBDAO.java
*@FileTitle : Lease Expense-CNTR/CHSS
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.24
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2009.06.24 장준우
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containercostanalysis.expenseplan.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.ees.lse.containercostanalysis.expenseplan.basic.ExpensePlanBCImpl;
import com.hanjin.apps.alps.ees.lse.containercostanalysis.expenseplan.vo.ExpensePlanPerformanceVO;
import com.hanjin.apps.alps.ees.lse.containercostanalysis.expenseplan.vo.ExpensePlanVO;
import com.hanjin.apps.alps.ees.lse.containercostanalysis.expenseplan.vo.SearchParamVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;


/**
 * ALPS ExpensePlanDBDAO <br>
 * - ALPS-ContainerCostAnalysis system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author Jang Jun-Woo
 * @see ExpensePlanBCImpl 참조
 * @since J2EE 1.6
 */
public class ExpensePlanDBDAO extends DBDAOSupport {

	/**
	 * CNTR/CHSS에 대한 년간 사업계획 목록을 조회합니다.<br>
	 *
	 * @param String plnYr
	 * @param String verSeq
	 * @param String cmdType
	 * @return List<ExpensePlanVO>
	 * @throws DAOException
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<ExpensePlanVO> searchLeaseExpensePlanListData(String plnYr, String verSeq, String cmdType) throws DAOException {

		DBRowSet dbRowset = null;
		List<ExpensePlanVO> resultVOs = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("pln_yr", plnYr);
			param.put("ver_seq", verSeq);
			param.put("cmd_type", cmdType);

			velParam.put("pln_yr", plnYr);
			velParam.put("ver_seq", verSeq);
			velParam.put("cmd_type", cmdType);

			dbRowset  = new SQLExecuter().executeQuery(new ExpensePlanDBDAOExpensePlanListRSQL(), param, velParam);
			resultVOs = (List)RowSetUtil.rowSetToVOs(dbRowset, ExpensePlanVO.class);
		} catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

		return resultVOs;
	}

	/**
	 * 년도별 최대 사업계획 버전 관리번호를 조회합니다.<br>
	 *
	 * @param  String plnYr
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int searchLeaseExpenseVersionSeqData(String plnYr) throws DAOException {
		int verSeq = 0;
	    DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

	    try {
    		param.put("pln_yr", plnYr);
			velParam.put("pln_yr", plnYr);

			dbRowset = new SQLExecuter().executeQuery(new ExpensePlanDBDAOExpenseVerSeqRSQL(), param, velParam);
	    	if(dbRowset.next()) {
	    		verSeq = dbRowset.getInt("VER_SEQ");
	    	}
	    } catch(SQLException se) {
	    	log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(ex.getMessage());
		}

		return verSeq;
	}

	/**
	 * 년간/월간 장비임차 형태별 임차료 실적자료를 일괄 저장합니다.<br>
	 *
	 * @param  List<ExpensePlanVO> expensePlanVOs
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addLeaseExpensePlanListData(List<ExpensePlanVO> expensePlanVOs) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter();
			int insCnt[] = null;
			if(expensePlanVOs.size() > 0) {
				insCnt = sqlExe.executeBatch(new ExpensePlanDBDAOExpensePlanCSQL(), expensePlanVOs, null);
				for(int i = 0; i < insCnt.length; i++) {
					if(insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 년간/월별 장비임차 형태별 임차료 실적목록을 조회합니다.<br>
	 *
	 * @param  SearchParamVO searchParamVO
	 * @return List<ExpensePlanPerformanceVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<ExpensePlanPerformanceVO> searchExpensePlanPerformanceListData(SearchParamVO searchParamVO) throws DAOException {

		DBRowSet dbRowset = null;
		List<ExpensePlanPerformanceVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchParamVO != null){
				Map<String, String> mapVO = searchParamVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);

				List<String> arrExpnMonCd  = null;
				List<String> arrEqTermNm = null;

				if ( !JSPUtil.getNull(searchParamVO.getExpnMonCd()).equals("") ) {
					arrExpnMonCd = JSPUtil.convertStringToArrayList(JSPUtil.replace(searchParamVO.getExpnMonCd(),",","|"));
					param.put("expn_mon_cd_seq", arrExpnMonCd);
					velParam.put("expn_mon_cd_seq", arrExpnMonCd);
				}

				if ( !JSPUtil.getNull(searchParamVO.getEqTermNm()).equals("") ) {
					arrEqTermNm = JSPUtil.convertStringToArrayList(JSPUtil.replace(searchParamVO.getEqTermNm(),",","|"));
					param.put("eq_term_nm_seq", arrEqTermNm);
					velParam.put("eq_term_nm_seq", arrEqTermNm);
				}
			}

			dbRowset = new SQLExecuter("").executeQuery(new ExpensePlanDBDAOExpensePlanPerformanceListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ExpensePlanPerformanceVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
}