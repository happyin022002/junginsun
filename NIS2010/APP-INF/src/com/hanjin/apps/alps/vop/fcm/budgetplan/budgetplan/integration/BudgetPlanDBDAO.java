/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : TrendLineDBDAO.java
*@FileTitle : TrendLineDBDAO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.11.15
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2011.11.15 진마리아
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.fcm.budgetplan.budgetplan.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.vop.fcm.budgetplan.budgetplan.vo.FcmBudTgtVvdCsmVO;
import com.hanjin.apps.alps.vop.fcm.budgetplan.budgetplan.vo.FcmBudTgtVvdInqVO;
import com.hanjin.apps.alps.vop.fcm.budgetplan.budgetplan.vo.FcmBudTgtVvdVO;
import com.hanjin.apps.alps.vop.fcm.trendline.trendline.basic.TrendLineBCImpl;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;

/**
 * ALPS TrendLineDBDAO<br>
 * ALPS TEMP1 Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Maria Chin
 * @see TrendLineBCImpl 참조
 * @since J2EE 1.6
 */

public class BudgetPlanDBDAO extends DBDAOSupport {

	
	private static final long serialVersionUID = 1L;
	
	/**
	 * Vessel Report에 대한 주어진 구간의 LANE 정보를 조회한다.<br>
	 * 
	 * @param FcmBudTgtVvdInqVO fcmBudTgtVvdInqVO
	 * @return List<FcmBudTgtVvdVO>
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public List<FcmBudTgtVvdVO> searchBudTgtVvdList(FcmBudTgtVvdInqVO fcmBudTgtVvdInqVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<FcmBudTgtVvdVO> vfcmBudTgtVvdVO = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(fcmBudTgtVvdInqVO != null){
				Map<String, String> mapVO = fcmBudTgtVvdInqVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BudgetPlanDBDAOFcmBudTgtVvdVORSQL(), param, velParam);
			vfcmBudTgtVvdVO = (List) RowSetUtil.rowSetToVOs(dbRowset, FcmBudTgtVvdVO.class);
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return vfcmBudTgtVvdVO;
	}
	
	/**
	 * Vessel Report에 대한 주어진 구간의 LANE 정보를 조회한다.<br>
	 * 
	 * @param FcmBudTgtVvdInqVO fcmBudTgtVvdInqVO
	 * @return List<FcmBudTgtVvdVO>
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public List<FcmBudTgtVvdCsmVO> searchBudTgtVvdCmsList(FcmBudTgtVvdInqVO fcmBudTgtVvdInqVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<FcmBudTgtVvdCsmVO> vfcmBudTgtVvdCsmVO = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(fcmBudTgtVvdInqVO != null){
				Map<String, String> mapVO = fcmBudTgtVvdInqVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BudgetPlanDBDAOFcmBudTgtVvdCsmVORSQL(), param, velParam);
			vfcmBudTgtVvdCsmVO = (List) RowSetUtil.rowSetToVOs(dbRowset, FcmBudTgtVvdCsmVO.class);
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return vfcmBudTgtVvdCsmVO;
	}	
}
