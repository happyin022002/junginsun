/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AgencyCommissionDBDAO.java
*@FileTitle : Other Commission Inquiry (PA/RA)
*Open Issues :
*@LastModifyDate : 2009.09.21
*@LastModifier : 장영석
*@LastVersion : 1.2
* 2009.09.21 장영석
* 1.0 Creation
* *Change history :
=========================================================*/
package com.clt.apps.opus.esm.coa.stdunitcost.avgagncommission.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.coa.common.vo.SearchConditionVO;
import com.clt.apps.opus.esm.coa.stdunitcost.agencycommission.basic.AgencyCommissionBCImpl;
import com.clt.apps.opus.esm.coa.stdunitcost.avgagncommission.vo.AvgAgencyCommissionVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;



/**
 * opus AgencyCommissionDBDAO <br>
 * - opus-STDUnitCost system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Jang Yeong-seok
 * @see AgencyCommissionBCImpl 참조
 * @since J2EE 1.6
 */
public class AvgAgencyCommissionDBDAO extends DBDAOSupport {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Office Average Agency Commission 정보를 조회 합니다.<br>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @return List<AvgAgencyCommissionVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<AvgAgencyCommissionVO> searchAvgAgencyCommissionOfficeList(SearchConditionVO searchConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AvgAgencyCommissionVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchConditionVO != null){
				Map<String, String> mapVO = searchConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AvgAgencyCommissionDBDAOSearchAvgAgencyCommissionOfficeListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AvgAgencyCommissionVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * Country Average Agency Commission 정보를 조회 합니다.<br>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @return List<AvgAgencyCommissionVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<AvgAgencyCommissionVO> searchAvgAgencyCommissionCountryList(SearchConditionVO searchConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AvgAgencyCommissionVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchConditionVO != null){
				Map<String, String> mapVO = searchConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AvgAgencyCommissionDBDAOSearchAvgAgencyCommissionCountryListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AvgAgencyCommissionVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	


	/**
	 * Office Average Agency Commission 정보를 삭제 합니다.
	 * 
	 * @param AvgAgencyCommissionVO avgAgencyCommissionVO
	 * @throws DAOException
	 */
	public int removeAvgAgencyCommissionOfficeList(AvgAgencyCommissionVO avgAgencyCommissionVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int rtnCnt = 0;
		try {
			Map<String, String> mapVO = avgAgencyCommissionVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			rtnCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new AvgAgencyCommissionDBDAORemoveAvgAgencyCommissionOfficeListDSQL(), param, velParam);
			if(rtnCnt == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return rtnCnt;
	}

	/**
	 * Office Average Agency Commission 정보를 저장/수정 합니다.
	 * 
	 * @param AvgAgencyCommissionVO avgAgencyCommissionVO
	 * @throws DAOException
	 */
	public int mergeAvgAgencyCommissionOfficeList(AvgAgencyCommissionVO avgAgencyCommissionVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int rtnCnt = 0;
		try {
			Map<String, String> mapVO = avgAgencyCommissionVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			rtnCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new AvgAgencyCommissionDBDAOMergeAvgAgencyCommissionOfficeListCSQL(), param, velParam);
			if(rtnCnt == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to merge SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return rtnCnt;
	}
	


	/**
	 * Country Average Agency Commission 정보를 삭제 합니다.
	 * 
	 * @param AvgAgencyCommissionVO avgAgencyCommissionVO
	 * @throws DAOException
	 */
	public int removeAvgAgencyCommissionCountryList(AvgAgencyCommissionVO avgAgencyCommissionVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int rtnCnt = 0;
		try {
			Map<String, String> mapVO = avgAgencyCommissionVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			rtnCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new AvgAgencyCommissionDBDAORemoveAvgAgencyCommissionCountryListDSQL(), param, velParam);
			if(rtnCnt == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return rtnCnt;
	}

	/**
	 * Country Average Agency Commission 정보를 저장/수정 합니다.
	 * 
	 * @param AvgAgencyCommissionVO avgAgencyCommissionVO
	 * @throws DAOException
	 */
	public int mergeAvgAgencyCommissionCountryList(AvgAgencyCommissionVO avgAgencyCommissionVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int rtnCnt = 0;
		try {
			Map<String, String> mapVO = avgAgencyCommissionVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			rtnCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new AvgAgencyCommissionDBDAOMergeAvgAgencyCommissionCountryListCSQL(), param, velParam);
			if(rtnCnt == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to merge SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return rtnCnt;
	}
	
}