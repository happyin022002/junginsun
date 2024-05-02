/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : USDomesticDBDAO.java
*@FileTitle : US domestic cost/credit 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.10.16
*@LastModifier : 김보배
*@LastVersion : 1.0 
* 2012.10.16 김보배
* 1.0 Creation
=========================================================
* History
* 2012.11.19 송호진 [CHM-201221090-01] [COA] US DOMESTIC 반영 - 컬럼 추가에 의한 Creation Logic 및 변경 저장 로직 수정 
* 2012.11.20 송호진 [CHM-201221090-01] [COA] US DOMESTIC 반영 - CNTR_SZ_CD -> CNTR_TPSZ_CD 컬럼명 변경에 따른 수정
* 2013.05.10 최성민 [CHM-201324573-01] [COA] Domestic Saving Credit 화면 버튼 추가 
=========================================================*/
package com.hanjin.apps.alps.esm.coa.stdunitcost.usdomestic.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.coa.stdunitcost.usdomestic.basic.USDomesticBCImpl;
import com.hanjin.apps.alps.esm.coa.stdunitcost.usdomestic.vo.SearchUSDomesticVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;



/**
 * ALPS USDomesticDBDAO <br>
 * - ALPS-STDUnitCost system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author BOBAE KIM	
 * @see USDomesticBCImpl 참조
 * @since J2EE 1.5
 */
public class USDomesticDBDAO extends DBDAOSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8054340430556693140L;

	/**
	 * USDomesticCost 조회
	 * 
	 * @param SearchUSDomesticVO searchUSDomesticVO
	 * @return List<SearchUSDomesticVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SearchUSDomesticVO> searchUSDomesticCost(SearchUSDomesticVO searchUSDomesticVO) throws DAOException {
		
		DBRowSet dbRowset = null;
		List<SearchUSDomesticVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchUSDomesticVO != null){
				Map<String, String> mapVO = searchUSDomesticVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new USDomesticDBDAOSearchUSDomesticCostRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchUSDomesticVO.class);
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
	 * USDomesticCost 생성
	 * Domestic Revenue 데이터 삭제
	 * 
	 * @param SearchUSDomesticVO searchUSDomesticVO
	 * @throws DAOException
	 */
	public void removeDomRev(SearchUSDomesticVO searchUSDomesticVO) throws DAOException {

		Map<String, Object> param = new HashMap<String, Object>();
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
        	Map<String, String> mapVO = searchUSDomesticVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate)new USDomesticDBDAORemoveDomRevDSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                    throw new DAOException("Fail to insert SQL");
    
        }catch (SQLException se) {
            log.error("err " + se.toString(), se);
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error("err " + ex.toString(), ex);
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
	}
	
	
	/**
	 * USDomesticCost 생성
	 * Domestic Revenue 데이터 생성
	 * 
	 * @param SearchUSDomesticVO searchUSDomesticVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addDomRev(SearchUSDomesticVO searchUSDomesticVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = searchUSDomesticVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new USDomesticDBDAOAddDomRevCSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	
	/**
	 * USDomesticCost 생성
	 * Domestic Rail 데이터 생성
	 * 
	 * @param SearchUSDomesticVO searchUSDomesticVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addDomRailCost(SearchUSDomesticVO searchUSDomesticVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = searchUSDomesticVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new USDomesticDBDAOAddDomRailCostCSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	
	/**
	 * USDomesticCost 생성
	 * Location data 를 ECC Level 로 Summary 데이터 생성
	 * 
	 * @param SearchUSDomesticVO searchUSDomesticVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addLocEccSum(SearchUSDomesticVO searchUSDomesticVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = searchUSDomesticVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new USDomesticDBDAOAddLocEccSumCSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	
	/**
	 * USDomesticCost 생성
	 * Domestic total cost 데이터 생성
	 * 
	 * @param SearchUSDomesticVO searchUSDomesticVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addDomCost(SearchUSDomesticVO searchUSDomesticVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = searchUSDomesticVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new USDomesticDBDAOAddDomCostUSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	
	/**
	 * USDomesticCost 생성
	 * Simulated empty reposition 데이터 생성
	 * 
	 * @param SearchUSDomesticVO searchUSDomesticVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addEmptyRepo(SearchUSDomesticVO searchUSDomesticVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = searchUSDomesticVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new USDomesticDBDAOAddEmptyRepoCSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	
	/**
	 * USDomesticCost 생성
	 * Domestic savings 데이터 생성
	 * 
	 * @param SearchUSDomesticVO searchUSDomesticVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addDomSav(SearchUSDomesticVO searchUSDomesticVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = searchUSDomesticVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new USDomesticDBDAOAddDomSavUSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	
	/**
	 * USDomesticCost 생성
	 * Simulated empty reposition 데이터 수정 후 저장
	 * 
	 * @param List<SearchUSDomesticVO> searchUSDomesticVOs
	 * @throws DAOException
	 * @throws Exception
	 */
	public void modifyEmptyRepo(List<SearchUSDomesticVO> searchUSDomesticVOs) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {

			for(int i = 0; i < searchUSDomesticVOs.size(); i++) {
				SearchUSDomesticVO searchUSDomesticVO = searchUSDomesticVOs.get(i);
				
	        	if(searchUSDomesticVO != null) {
		            Map<String, String> mapVO = searchUSDomesticVO.getColumnValues();
		            
		            param.putAll(mapVO);
		            velParam.putAll(mapVO);
	        	}
				
	            result = new SQLExecuter("").executeUpdate((ISQLTemplate)new USDomesticDBDAOModifyEmptyRepoUSQL(), param, velParam);
	
	            if (result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");
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
	 * USDomesticCost 생성
	 * Domestic savings 데이터 수정 후 저장
	 * 
	 * @param List<SearchUSDomesticVO> searchUSDomesticVOs
	 * @throws DAOException
	 * @throws Exception
	 */
	public void modifyDomSav(List<SearchUSDomesticVO> searchUSDomesticVOs) throws DAOException, Exception {
		
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			for(int i = 0; i < searchUSDomesticVOs.size(); i++) {
				SearchUSDomesticVO searchUSDomesticVO = searchUSDomesticVOs.get(i);
				
	        	if(searchUSDomesticVO != null) {
		            Map<String, String> mapVO = searchUSDomesticVO.getColumnValues();
		            
		            param.putAll(mapVO);
		            velParam.putAll(mapVO);
	        	}
				
	            result = new SQLExecuter("").executeUpdate((ISQLTemplate)new USDomesticDBDAOModifyDomSavUSQL(), param, velParam);
	
	            if (result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");
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
	 * Empty Repo Credit 변경 부분 저장
	 * Domestic savings 데이터 수정 후 저장
	 * 
	 * @param List<SearchUSDomesticVO> searchUSDomesticVOs
	 * @throws DAOException
	 * @throws Exception
	 */
	public void modifyEmptyRepoCredit(List<SearchUSDomesticVO> searchUSDomesticVOs) throws DAOException, Exception {
		
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			for(int i = 0; i < searchUSDomesticVOs.size(); i++) {
				SearchUSDomesticVO searchUSDomesticVO = searchUSDomesticVOs.get(i);
				
	        	if(searchUSDomesticVO != null) {
		            Map<String, String> mapVO = searchUSDomesticVO.getColumnValues();
		            
		            param.putAll(mapVO);
		            velParam.putAll(mapVO);
	        	}
				
	            result = new SQLExecuter("").executeUpdate((ISQLTemplate)new USDomesticDBDAOModifyEmptyRepoCreditUSQL(), param, velParam);
	
	            if (result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");
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
	 * CREATE 하기 전 COA_MTY_ECC_UT_COST 테이블 데이터 유무 확인
	 * 
	 * @param fCostYrmon
	 * @return String
	 * @throws DAOException
	 */
	public String searchCoaMtyEccUtCostCnt(String fCostYrmon) throws DAOException {
		
		String retCnt = "";
		DBRowSet dbRowset = null;
		
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (!fCostYrmon.equals("")) {
				Map<String, String> mapVO = new HashMap<String, String>();

				mapVO.put("f_cost_yrmon", fCostYrmon);
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new USDomesticDBDAOSearchCoaMtyEccUtCostCntRSQL(), param, velParam);

			if(dbRowset.getRowCount() > 0) {
				if (dbRowset.next()) {
					retCnt = dbRowset.getString(1);
				}
			}
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return retCnt;
	}
	
	
	/**
	 * ESM_COA_0014 : CREATE 를 하기 위한 기간 히스토리 생성
	 *
	 * @param SearchUSDomesticVO searchUSDomesticVO
	 * @param SignOnUserAccount account
	 * @throws DAOException
	 */
	public void createUSDomCreationStatus(SearchUSDomesticVO searchUSDomesticVO, SignOnUserAccount account) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		int saveCnt = 0;

        try{
        	if( searchUSDomesticVO != null ){
        		param.putAll(searchUSDomesticVO.getColumnValues());
        		saveCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new USDomesticDBDAOAddUSDomCreationStatusCSQL(), param, null);
        	}

            if(saveCnt == Statement.EXECUTE_FAILED)
                throw new DAOException("Fail to insert No SQL");

        } catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

	}
	
	
	/**
	 * ESM_COA_0014 : CREATE 된 기간 조회
	 *
	 * @param fCostYrmon
	 * @return String
	 * @throws EventException
	 */
	public String searchUSDomCreationStatus(String fCostYrmon) throws DAOException {
		
		String retVal = "";
		DBRowSet dbRowset = null;
		
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (!fCostYrmon.equals("")) {
				Map<String, String> mapVO = new HashMap<String, String>();

				mapVO.put("f_cost_yrmon", fCostYrmon);
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new USDomesticDBDAOSearchUSDomCreationStatusRSQL(), param, velParam);

			if(dbRowset.getRowCount() > 0) {
				if (dbRowset.next()) {
					retVal = dbRowset.getString(1);
				}
			}
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return retVal;
	}

	/**
	 * USDomesticTRPCost 생성
	 * Domestic TRP 데이터 생성
	 * 
	 * @param SearchUSDomesticVO searchUSDomesticVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addUSDomesticTRP(SearchUSDomesticVO searchUSDomesticVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = searchUSDomesticVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new USDomesticDBDAOAddUSDomesticTRPCSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	

	/**
	 * EQ Off-hire 데이터 생성 (Sub lease out , CN Domestic)
	 * 
	 * @param SearchUSDomesticVO searchUSDomesticVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addLeaseOut(SearchUSDomesticVO searchUSDomesticVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = searchUSDomesticVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new USDomesticDBDAOAddLeaseOutCSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * EQ Off-hire 데이터 생성 (Disposal)
	 * 
	 * @param SearchUSDomesticVO searchUSDomesticVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addDisposal(SearchUSDomesticVO searchUSDomesticVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = searchUSDomesticVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new USDomesticDBDAOAddDisposalCSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * EQ Off-hire 데이터 생성 (EQ Off-hire)
	 * 
	 * @param SearchUSDomesticVO searchUSDomesticVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addEQOffhire(SearchUSDomesticVO searchUSDomesticVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = searchUSDomesticVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new USDomesticDBDAOAddEQOffhireCSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * EQ Off-hire US Rail Invoice Amount 데이터 생성 (DRP cost)
	 * 
	 * @param SearchUSDomesticVO searchUSDomesticVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addDRPInvoiceAmount(SearchUSDomesticVO searchUSDomesticVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = searchUSDomesticVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new USDomesticDBDAOaddDRPInvoiceAmountUSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
		
	
	/**
	 * [Domestic Saving Credit 단가] 정보를 [복사] 합니다.<br>
	 * 
	 * @param HashMap<String, String> map
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int addDomesticMonthCopy(HashMap<String, String> map) throws DAOException,Exception {
		
		int result = 0;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new USDomesticDBDAODomesticMonthCopyCSQL(), map, null);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to modify SQL");
			
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}
	
	/**
	 * [Domestic Saving Credit 단가] 정보를 [삭제] 합니다.<br>
	 * 
	 * @param HashMap<String, String> map
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int removeDomesticMonthCopy(HashMap<String, String> map) throws DAOException,Exception {
		
		int result = 0;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new USDomesticDBDAODomesticMonthCopyDSQL(), map, null);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to modify SQL");
			
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}
	
	/**
	 * [Domestic Saving Credit 의 생성] 정보를 [복사] 합니다.<br>
	 * 
	 * @param HashMap<String, String> map
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int addDomesticStatusMonthCopy(HashMap<String, String> map) throws DAOException,Exception {
		
		int result = 0;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new USDomesticDBDAODomesticStatusMonthCopyCSQL(), map, null);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to modify SQL");
			
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}
}