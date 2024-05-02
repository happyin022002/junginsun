/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CostSetUpDBDAO.java
*@FileTitle : Manual Cost Set up
*Open Issues :
*Change history :
*@LastModifyDate : 2012.09.14
*@LastModifier : 
*@LastVersion : 1.0
* 2009.08.04 
* 1.0 Creation 
* 2012.10.15 이석준 [CHM-201220161-01] 실시간 영업현황 관련 UI
* 2012.12.13 송호진 [CHM-201221879] [COA] Manual Cost Set up 화면 로직 수정
* 2014.06.19 최덕우 [CHM-201430638] [COA] BU Other (계선/대선) 항목의 각 계정별 분리 반영 위한 CSR 
* 2015.04.09 이윤정 [CHM-201534872] MTY Reposition Cost Detail 상 최종 Creation 날짜 표시
=========================================================*/
package com.hanjin.apps.alps.esm.coa.stdunitcost.costsetup.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.coa.common.vo.SearchConditionVO;
import com.hanjin.apps.alps.esm.coa.stdunitcost.costsetup.vo.GeneralExpenseVO;
import com.hanjin.apps.alps.esm.coa.stdunitcost.costsetup.vo.MtyRepoTESTRSCostVO;
import com.hanjin.apps.alps.esm.coa.stdunitcost.costsetup.vo.SearchCostSetUpListVO;
import com.hanjin.apps.alps.esm.coa.stdunitcost.costsetup.vo.VesselLayupVO;
import com.hanjin.apps.alps.esm.coa.stdunitcost.mas.basic.MASBCImpl;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.CoaMnlCostStupVO;


/**
 * ALPS CostSetUpDBDAO <br>
 * - ALPS-STDUnitCost system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Jeon Yun Joo
 * @see MASBCImpl 참조
 * @since J2EE 1.6
 */
public class CostSetUpDBDAO extends DBDAOSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8860416366174806503L;


	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @return List<SearchCostSetUpListVO>
	 * @throws DAOException
	 */
	public List<SearchCostSetUpListVO> searchCostSetUpList(SearchConditionVO searchConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchCostSetUpListVO> list = null;
		
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CostSetUpDBDAOSearchCostSetUpListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchCostSetUpListVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @return List<SearchCostSetUpListVO>
	 * @throws DAOException
	 */
	public List<SearchCostSetUpListVO> searchCostStupDef(SearchConditionVO searchConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchCostSetUpListVO> list = null;
		
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CostSetUpDBDAOSearchCostStupDefExpAmtRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchCostSetUpListVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @return List<MtyRepoTESTRSCostVO>
	 * @throws DAOException
	 */
	public List<MtyRepoTESTRSCostVO> searchMtyRepoCostCreateDate(SearchConditionVO searchConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MtyRepoTESTRSCostVO> list = null;
		
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CostSetUpDBDAOSearchMtyRepoCostCreateDateRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MtyRepoTESTRSCostVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @return List<SearchCostSetUpListVO>
	 * @throws DAOException
	 */
	public List<SearchCostSetUpListVO> searchCostStupMTAbcList(SearchConditionVO searchConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchCostSetUpListVO> list = null;
		
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CostSetUpDBDAOSearchCostStupMTAbcListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchCostSetUpListVO .class);
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<CoaMnlCostStupVO> coaMnlCostStupVOs
	 * @param SignOnUserAccount account
	 * @param String cost_yrwk
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] multiOtherCostSetup(List<CoaMnlCostStupVO> coaMnlCostStupVOs,SignOnUserAccount account,String cost_yrwk) throws DAOException,Exception {
		int updCnt[] = null;
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			velParam.put("cost_yrwk", cost_yrwk);
			velParam.put("usr_id", account.getUsr_id());
			
			if(coaMnlCostStupVOs .size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new CostSetUpDBDAOModifyOtherCostSetupUSQL(), coaMnlCostStupVOs,velParam);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return updCnt;
	}
	
	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<CoaMnlCostStupVO> coaMnlCostStupVOs
	 * @param SignOnUserAccount account
	 * @param String cost_yrmon
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] multiMTAbcCostSetup(List<CoaMnlCostStupVO> coaMnlCostStupVOs,SignOnUserAccount account,String cost_yrmon) throws DAOException,Exception {
		int updCnt[] = null;
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			velParam.put("cost_yrmon", cost_yrmon);
			velParam.put("usr_id", account.getUsr_id());
			
			if(coaMnlCostStupVOs .size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new CostSetUpDBDAOModifyMTAbcCostSetupUSQL(), coaMnlCostStupVOs,velParam);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return updCnt;
	}
	
	/**
	 * Manual Cost Set-up Table을 삭제 한다. 
	 *
	 * @param HashMap<String, String> map
	 * @throws DAOException
	 */
	public void removeManualCostStupCopy(HashMap<String, String> map) throws DAOException {
		int saveCnt = 0;

        try{
            	
        	saveCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new CostSetUpDBDAORemoveManualCostStupCopyDSQL(), map, null);

            if(saveCnt== Statement.EXECUTE_FAILED)
                throw new DAOException("Fail to modify SQL");

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
	 * Manual Cost Set-up월단가를 복사해서 생성한다.
	 *
	 * @param  HashMap<String, String> map
	 * @throws DAOException
	 */
	public void createManualCostStupCopy(HashMap<String, String> map) throws DAOException {
		int saveCnt = 0;

        try{
            saveCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new CostSetUpDBDAOCreateManualCostStupCopyCSQL(), map, null);
            if(saveCnt== Statement.EXECUTE_FAILED)
                throw new DAOException("Fail to modify SQL");

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
	 *이연 수지를 생성한다.
	 *
	 * @param String cost_yrweek
	 * @param SignOnUserAccount account
	 * @throws DAOException
	 */
	public void createDefExp(String cost_yrweek,SignOnUserAccount account) throws DAOException {
		int saveCnt = 0;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
        try{
        	param.put("cost_yrweek", cost_yrweek);
        	param.put("user_id", account.getUsr_id());
            saveCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new CostSetUpDBDAOCreateDefExpCSQL(), param, null);
            if(saveCnt== Statement.EXECUTE_FAILED)
                throw new DAOException("Fail to modify SQL");

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
	 * 용선료 시장가 차액을 생성한다.
	 *
	 * @param String cost_yrweek
	 * @param SignOnUserAccount account
	 * @throws DAOException
	 */
	public void createVSLMarketRt(String cost_yrweek,SignOnUserAccount account) throws DAOException {
		int saveCnt = 0;

		Map<String, Object> param = new HashMap<String, Object>();
        try{
        	param.put("cost_yrweek", cost_yrweek);
        	param.put("user_id", account.getUsr_id());
            saveCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new CostSetUpDBDAOCreateVSLMarketRtCSQL(), param, null);
            if(saveCnt== Statement.EXECUTE_FAILED)
                throw new DAOException("Fail to modify SQL");

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
	 * 대선 비용을 생성한다.
	 *
	 * @param String cost_yrweek
	 * @param SignOnUserAccount account
	 * @throws DAOException
	 */
	public void createVesselCht(String cost_yrweek,SignOnUserAccount account) throws DAOException {
		int saveCnt = 0;

		Map<String, Object> param = new HashMap<String, Object>();
        try{
        	param.put("cost_yrweek", cost_yrweek);
        	param.put("user_id", account.getUsr_id());
            saveCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new CostSetUpDBDAOCreateVesselChtCSQL(), param, null);
            if(saveCnt== Statement.EXECUTE_FAILED)
                throw new DAOException("Fail to modify SQL");

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
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @return List<MtyRepoTESTRSCostVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<MtyRepoTESTRSCostVO> searchMtyRepoCostDtl(SearchConditionVO searchConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MtyRepoTESTRSCostVO> list = null;
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CostSetUpDBDAOSearchMtyRepoTESTRSCostVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MtyRepoTESTRSCostVO .class);
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
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<MtyRepoTESTRSCostVO> mtyRepoTESTRSCostVOs
	 * @return int[]
	 * @exception DAOException
	 * @exception Exception
	 */
	public int[] createMtyRepoTESTRSCost(List<MtyRepoTESTRSCostVO> mtyRepoTESTRSCostVOs ) throws DAOException,Exception {
		//query parameter
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(mtyRepoTESTRSCostVOs .size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new CostSetUpDBDAOCreateMtyRepoTESTRSCostCSQL(), mtyRepoTESTRSCostVOs,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return updCnt;
	}
	
	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<MtyRepoTESTRSCostVO> mtyRepoTESTRSCostVOs
	 * @return int[]
	 * @exception DAOException
	 * @exception Exception
	 */
	public int[] modifyCoaUtCostCreSts(List<MtyRepoTESTRSCostVO> mtyRepoTESTRSCostVOs ) throws DAOException,Exception {
		//query parameter
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(mtyRepoTESTRSCostVOs .size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new CostSetUpDBDAOModifyCoaUtCostCreStsUSQL(), mtyRepoTESTRSCostVOs,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return updCnt;
	}
	
	
	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<MtyRepoTESTRSCostVO> mtyRepoTESTRSCostVOs
	 * @return int[]
	 * @exception DAOException
	 * @exception Exception
	 */
	public int[] modifyMtyRepositionCost(List<MtyRepoTESTRSCostVO> mtyRepoTESTRSCostVOs) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(mtyRepoTESTRSCostVOs .size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new CostSetUpDBDAOModifyMtyRepoTESTRSCostVOUSQL(), mtyRepoTESTRSCostVOs,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return updCnt;
	}
	
	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<MtyRepoTESTRSCostVO> mtyRepoTESTRSCostVOs
	 * @return int[]
	 * @exception DAOException
	 * @exception Exception
	 */
	public int[] modifyMtInvoiceAmount(List<MtyRepoTESTRSCostVO> mtyRepoTESTRSCostVOs) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(mtyRepoTESTRSCostVOs .size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new CostSetUpDBDAOModifyMtInvoiceAmountUSQL(), mtyRepoTESTRSCostVOs,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return updCnt;
	}

	
	/**
	 * [Rev Month 별 MT Invoicing AMT 비용을 합산하여 저장한다..<br>
	 * 
	 * @param MtyRepoTESTRSCostVO mtyRepoTESTRSCostVO
	 * @exception DAOException
	 */
	public void modifyTotalMtInvoiceAmount(MtyRepoTESTRSCostVO mtyRepoTESTRSCostVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try{
			if(mtyRepoTESTRSCostVO != null){
				Map<String, String> mapVO = mtyRepoTESTRSCostVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}	
			SQLExecuter sqlExe = new SQLExecuter("");			
			result = sqlExe.executeUpdate((ISQLTemplate)new CostSetUpDBDAOModifyTotalMtInvoiceAmountUSQL(), param, velParam);			
			if(result == Statement.EXECUTE_FAILED){
				throw new DAOException("Fail to delete SQL");		
			}				
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	

	/**
	 * [일반관리비]를 [조회] 합니다.<br>
	 * 
	 * @param GeneralExpenseVO generalExpenseVO
	 * @return List<GeneralExpenseVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings({ "unchecked", "rawtypes" })
	public List<GeneralExpenseVO> searchGeneralExpenseList(GeneralExpenseVO generalExpenseVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<GeneralExpenseVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(generalExpenseVO != null){
				Map<String, String> mapVO = generalExpenseVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CostSetUpDBDAOGeneralExpenseVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, GeneralExpenseVO .class);
	 	} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * [일반관리비] 를 [추가] 합니다.<br>
	 * 
	 * @param List<GeneralExpenseVO> list
	 * @return int[]
	 * @exception DAOException
	 * @exception Exception
	 */
	public int[] modifyGeneralExpense(List<GeneralExpenseVO> list) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(list .size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new CostSetUpDBDAOGeneralExpenseVOUSQL(), list,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return insCnt;
	}
	
	
	/**
	 * [일반관리비] 를 [일괄수정] 합니다.<br>
	 * 
	 * @param CoaMnlCostStupVO coaMnlCostStupVO
	 * @exception DAOException
	 */
	public void modifyGeneralExpenseAll(CoaMnlCostStupVO coaMnlCostStupVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try{
			if(coaMnlCostStupVO != null){
				Map<String, String> mapVO = coaMnlCostStupVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}	
			SQLExecuter sqlExe = new SQLExecuter("");			
			result = sqlExe.executeUpdate((ISQLTemplate)new CostSetUpDBDAOGeneralExpenseAllVOUSQL(), param, velParam);			
			if(result == Statement.EXECUTE_FAILED){
				throw new DAOException("Fail to update SQL");		
			}				
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * [ESM_COA_0024]<br>
	 * Vessel Charter / Lay Up Expense 정보를 조회<br>
	 *
	 * @param VesselLayupVO vesselLayupVO
	 * @return List<VesselLayupVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<VesselLayupVO> searchVslLayupList(VesselLayupVO vesselLayupVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<VesselLayupVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (vesselLayupVO != null) {
				Map<String, String> mapVO = vesselLayupVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CostSetUpDBDAOSearchVslLayupListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, VesselLayupVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * [ESM_COA_0024]<br>
	 * Vessel 데이터 Validate<br>
	 *
	 * @param String vslCd
	 * @return String
	 * @exception DAOException
	 */
	public String getVesselChk(String vslCd) throws DAOException {
		DBRowSet dbRowset = null;
		String vslCdCnt = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			if (vslCd != null && !"".equals(vslCd)) {
				param.put("vsl_cd", vslCd);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CostSetUpDBDAOGetVesselChkRSQL(), param, null);
			if(dbRowset.next()) {
				vslCdCnt = dbRowset.getString("VSL_CNT");
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return vslCdCnt;
	}
	

	/**
	 * [ESM_COA_0024]<br>
	 * COA_MNL_COST_STUP 테이블에 해당 데이타가 존재하는지 확인<br>
	 *
	 * @param VesselLayupVO vesselLayupVO
	 * @return int
	 * @exception DAOException
	 */
	public int chkCostSetup(VesselLayupVO vesselLayupVO) throws DAOException {
		DBRowSet dbRowset = null;
		int result = 0;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = vesselLayupVO.getColumnValues();

			param.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CostSetUpDBDAOChkCostSetupRSQL(), param, null);
			if(dbRowset.next()) {
				result = dbRowset.getInt("CNT");
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}
	
	/**
	 * [ESM_COA_0024]<br>
	 *  Total Amount값을 COA_MNL_COST_STUP 테이블에 업데이트 한다<br>
	 *
	 * @param VesselLayupVO vesselLayupVO
	 * @param int totSum
	 * @exception DAOException
	 * @exception Exception
	 */
	public void updateVslLayupTot(VesselLayupVO vesselLayupVO, int totSum) throws DAOException, Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = vesselLayupVO.getColumnValues();

			param.putAll(mapVO);
			param.put("tot_sum", totSum);
			
			SQLExecuter sqlExe = new SQLExecuter("");						
			result = sqlExe.executeUpdate((ISQLTemplate)new CostSetUpDBDAOUpdateVslLayupTotUSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * [ESM_COA_0024]<br>
	 *  Total Amount값을 COA_MNL_COST_STUP 테이블에 신규입력 한다<br>
	 *
	 * @param VesselLayupVO vesselLayupVO
	 * @param int totSum
	 * @exception DAOException
	 * @exception Exception
	 */
	public void insertVslLayupTot(VesselLayupVO vesselLayupVO, int totSum) throws DAOException, Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = vesselLayupVO.getColumnValues();

			param.putAll(mapVO);
			param.put("tot_sum", totSum);
			
			SQLExecuter sqlExe = new SQLExecuter("");						
			result = sqlExe.executeUpdate((ISQLTemplate)new CostSetUpDBDAOInsertVslLayupTotCSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * [ESM_COA_0024]<br>
	 *  Vessel Charter / Lay Up Expense 정보를 일괄적으로 삭제<br>
	 *
	 * @param VesselLayupVO vesselLayupVO
	 * @exception DAOException
	 * @exception Exception
	 */
	public void removeVslLayupList(VesselLayupVO vesselLayupVO) throws DAOException, Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = vesselLayupVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");						
			result = sqlExe.executeUpdate((ISQLTemplate)new CostSetUpDBDAORemoveVslLayupListDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * [ESM_COA_0024]<br>
	 *  Vessel Charter / Lay Up Expense 정보를 일괄적으로 저장<br>
	 * 
	 * @param List<VesselLayupVO> vesselLayupVOs
	 * @exception DAOException
	 * @exception Exception
	 */
	public void addVslLayupList(List<VesselLayupVO> vesselLayupVOs) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(vesselLayupVOs .size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new CostSetUpDBDAOAddVslLayupListCSQL(), vesselLayupVOs, null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
}