/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : NetworkDistributionDBDAO.java
 *@FileTitle : Network Distribution DBDAO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2006-11-28
 *@LastModifier : KimJongBeom
 *@LastVersion : 1.0
 * 2006-11-28 KimJongBeom
 * 1.0 최초 생성
 * 
 *=========================================================
 * History
 =========================================================*/

package com.clt.apps.opus.esm.coa.weeklypfmc.networkdistribution.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.coa.common.vo.ProcedureParamVO;
import com.clt.apps.opus.esm.coa.common.vo.SearchConditionVO;
import com.clt.apps.opus.esm.coa.weeklypfmc.networkdistribution.basic.NetworkDistributionBCImpl;
import com.clt.apps.opus.esm.coa.weeklypfmc.networkdistribution.vo.NetworkDistributionCommonVO;
import com.clt.apps.opus.esm.coa.weeklypfmc.networkdistribution.vo.SearchFixCostDistListVO;
import com.clt.apps.opus.esm.coa.weeklypfmc.networkdistribution.vo.SearchFixCostDistResultListVO;
import com.clt.apps.opus.esm.coa.weeklypfmc.networkdistribution.vo.SearchCOMSalesAmountListVO;
import com.clt.apps.opus.esm.coa.weeklypfmc.networkdistribution.vo.SearchMissingStatusVO;
import com.clt.apps.opus.esm.coa.weeklypfmc.networkdistribution.vo.SearchSpcChtrRevMssListVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.syscommon.common.table.CoaFxAmtDtrbVO;

/**
 * WeeklyPFMC에 대한 DB 처리를 담당<br>
 * - WeeklyPFMC Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author KimJongBeom
 * @see NetworkDistributionBCImpl 참조
 * @since J2EE 1.4
 */

public class NetworkDistributionDBDAO extends DBDAOSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2114963809317934574L;
	/**
	 * NetworkDistribution의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 사용 프로그램 : ESM_COA_0045
	 * 
	 * @param SearchConditionVO searchVO
	 * @return List<SearchCOMSalesAmountListVO>
	 * @throws DAOException
	 */
    @SuppressWarnings("unchecked")
	public List<SearchCOMSalesAmountListVO> searchCOMSalesAmountList(SearchConditionVO searchVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<SearchCOMSalesAmountListVO> list = null;
        
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
        try{
        	if ( searchVO != null ) {
	        	Map<String, String> map = searchVO.getColumnValues();
	        	
	        	param.putAll(map);
	        	velParam.putAll(map);
	        	
                dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new NetworkDistributionDBDAOSearchCOMSalesAmountListRSQL(), param, velParam);
                list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchCOMSalesAmountListVO.class);        		
        	}
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            log.error("err " + se.toString(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            log.error("err " + ex.toString(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return list;
    }

	/**
	 * NetworkDistribution의 해당되는 값을 불러온다.<br>
	 * 사용 프로그램 : ESM_COA_0045
	 * 
	 * @param NetworkDistributionCommonVO vo
	 * @return List<SearchMissingStatusVO>
	 * @throws DAOException
	 */
    @SuppressWarnings("unchecked")
	public List<SearchMissingStatusVO> searchMissingStatus(NetworkDistributionCommonVO vo) throws DAOException {
        DBRowSet dbRowset = null;
        List<SearchMissingStatusVO> list = null;
        try{
            if(vo == null) return null;
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new NetworkDistributionDBDAOSearchMissingStatusRSQL(), vo.getIndirectQueryParameter(), vo.getIndirectVelocityParameter());
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchMissingStatusVO.class);
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            log.error("err " + se.toString(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            log.error("err " + ex.toString(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return list;
    }	

	/**
	 * NetworkDistribution의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 사용 프로그램 : ESM_COA_0047
	 * 
	 * @param SearchConditionVO searchVO
	 * @return List<SearchFixCostDistListVO>
	 * @throws DAOException
	 */
    @SuppressWarnings("unchecked")
	public List<SearchFixCostDistListVO> searchFixCostDistList(SearchConditionVO searchVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<SearchFixCostDistListVO> list = null;
        
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
        try{
        	if ( searchVO != null ) {
	        	Map<String, String> map = searchVO.getColumnValues();
	        	
	        	param.putAll(map);
	        	velParam.putAll(map);
            	
                dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new NetworkDistributionDBDAOSearchFixCostDistListRSQL(), param, velParam);
                list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchFixCostDistListVO.class);        		
        	}
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            log.error("err " + se.toString(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            log.error("err " + ex.toString(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return list;
    }	


	/**
	 * NetworkDistribution의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 사용 프로그램 : ESM_COA_0106
	 * 
	 * @param NetworkDistributionCommonVO vo
	 * @return List<SearchFixCostDistResultListVO>
	 * @throws DAOException
	 */
    @SuppressWarnings("unchecked")
	public List<SearchFixCostDistResultListVO> searchFixCostDistResultList(NetworkDistributionCommonVO vo) throws DAOException {
        DBRowSet dbRowset = null;
        List<SearchFixCostDistResultListVO> list = null;
        try{
            if(vo == null) return null;
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new NetworkDistributionDBDAOSearchFixCostDistResultListRSQL(), vo.getIndirectQueryParameter(), vo.getIndirectVelocityParameter());
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchFixCostDistResultListVO.class);
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            log.error("err " + se.toString(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            log.error("err " + ex.toString(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return list;
    }	

	/**
	 * NetworkDistribution의 데이타 모델에 해당되는 값을 생성한다.<br>
	 * - 사용 프로그램 : ESM_COA_0106
	 *
	 * @param NetworkDistributionCommonVO vo
	 * @throws DAOException
	 */
    public void applyToPL(NetworkDistributionCommonVO vo) throws DAOException {
        int insCnt [] = null;
        int insCnt2[] = null;
        int insCnt3[] = null;
        int updCnt[]  = null;
        try{
            SQLExecuter sqlExe = new SQLExecuter("");
            //Space Charter Revenue를 제외한 총 고정비 비용을 PL Chart에 반영
            if(vo.getMultiCreateList() != null && vo.getMultiCreateList().size() > 0){
                insCnt = sqlExe.executeBatch((ISQLTemplate)new NetworkDistributionDBDAOApplyToPL1CSQL(), vo.getMultiCreateList(), vo.getIndirectVelocityParameter());
                for(int i = 0; i < insCnt.length; i++){
                    if(insCnt[i]== Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to insert No"+ i + " SQL");
                }
            }
            
            //Space Chater Revenue및 BSA를 밀어넣기
            //Intra Isia 로직 반영 요청이 있으면 이 부분은 주석처리 하고 아래의 2개를 풀어서 적용하여야 함.
            if(vo.getMultiCreateList2() != null && vo.getMultiCreateList2().size() > 0){
                insCnt2 = sqlExe.executeBatch((ISQLTemplate)new NetworkDistributionDBDAOApplyToPL2CSQL(), vo.getMultiCreateList2(), vo.getIndirectVelocityParameter());
                for(int i = 0; i < insCnt2.length; i++){
                    if(insCnt2[i]== Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to insert No"+ i + " SQL");
                }
            }
         
            //Special Lane에 대한 LOAD(수송량)을 BSA(공급량)으로 밀어넣기 
            if(vo.getMultiCreateList3() != null && vo.getMultiCreateList3().size() > 0){
                insCnt3 = sqlExe.executeBatch((ISQLTemplate)new NetworkDistributionDBDAOApplyToPL3CSQL(), vo.getMultiCreateList3(), vo.getIndirectVelocityParameter());
                for(int i = 0; i < insCnt3.length; i++){
                    if(insCnt3[i]== Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to insert No"+ i + " SQL");
                }
            }            

            //
            if(vo.getMultiUpdateList() != null && vo.getMultiUpdateList().size() > 0){
                updCnt = sqlExe.executeBatch((ISQLTemplate)new NetworkDistributionDBDAOApplyToPLUSQL(), vo.getMultiUpdateList(), vo.getIndirectVelocityParameter());
                for(int i = 0; i < updCnt.length; i++){
                    if(updCnt[i]== Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to update No"+ i + " SQL");
                }
            }
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
	 * Allocation Result 화면에서 PL Apply 시 Space Charter Revenue Missing 를 보여주는 화면.<br>
	 * 사용 프로그램 : ESM_COA_0153
	 * 
	 * @param NetworkDistributionCommonVO vo
	 * @return List<SearchSpcChtrRevMssListVO>
	 * @throws DAOException
	 */
    @SuppressWarnings("unchecked")
	public List<SearchSpcChtrRevMssListVO> searchSpcChtrRevMssList(NetworkDistributionCommonVO vo) throws DAOException {
        DBRowSet dbRowset = null;
        List<SearchSpcChtrRevMssListVO> list = null;
        try{
            if(vo == null) return null;
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new NetworkDistributionDBDAOSearchSpcChtrRevMssListRSQL(), vo.getIndirectQueryParameter(), vo.getIndirectVelocityParameter());
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchSpcChtrRevMssListVO.class);
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            log.error("err " + se.toString(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            log.error("err " + ex.toString(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return list;
    }	

	/**
	 * NetworkDistribution의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 사용 프로그램 : ESM_COA_0107
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @return List<CoaFxAmtDtrbVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CoaFxAmtDtrbVO> searchAllocationResultInter(SearchConditionVO searchConditionVO) throws DAOException {
        DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
        List<CoaFxAmtDtrbVO> list = null;
        try{
        	if( searchConditionVO != null){
        		Map<String, String> mapVO = searchConditionVO.getColumnValues();
        		param.putAll(mapVO);
        		velParam.putAll(mapVO);
        		dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new NetworkDistributionDBDAOSearchAllocationResultInterRSQL(), param, velParam);
                list = (List)RowSetUtil.rowSetToVOs(dbRowset, CoaFxAmtDtrbVO.class);
        	}            
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            log.error("err " + se.toString(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            log.error("err " + ex.toString(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return list;
    }
	
	/**
	 * Allocation Result(Internal Pricing) Create 이벤트 처리<br>
	 * 
	 * @param ProcedureParamVO procedureParamVO
	 * @return ProcedureParamVO
	 * @exception DAOException
	 */
	public ProcedureParamVO createAllocationResultInter(ProcedureParamVO procedureParamVO) throws DAOException {
		Map<String, Object> resultMap = new HashMap<String, Object>();
    	ProcedureParamVO resultVO = new ProcedureParamVO();
		
		try{
			resultMap = new SQLExecuter("").executeSP((ISQLTemplate)new NetworkDistributionDBDAOCreateAllocationResultInterCSQL(), procedureParamVO.getColumnValues(), null);
        	
        	if ( resultMap != null) {
        		resultVO.setOutErrCd((String) resultMap.get("out_err_cd"));
        		resultVO.setOutErrMsg((String) resultMap.get("out_err_msg"));
        	}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return resultVO;
	}
	/**
	 * NetworkDistribution의 데이타 모델에 해당되는 값을 생성한다.<br>
	 * - 사용 프로그램 : ESM_COA_0107
	 *
	 * @param ProcedureParamVO procedureParamVO
	 * @return ProcedureParamVO
	 * @exception DAOException
	 */
    @SuppressWarnings("unchecked")
	public ProcedureParamVO applyToPLInter(ProcedureParamVO procedureParamVO) throws DAOException {
    	Map<String, Object> resultMap = new HashMap<String, Object>();
    	ProcedureParamVO resultVO = new ProcedureParamVO();
		
		try{
			resultMap = new SQLExecuter("").executeSP((ISQLTemplate)new NetworkDistributionDBDAOCreateAllocationResultInterCSQL(), procedureParamVO.getColumnValues(), null);
        	
        	if ( resultMap != null) {
        		resultVO.setOutErrCd((String) resultMap.get("out_err_cd"));
        		resultVO.setOutErrMsg((String) resultMap.get("out_err_msg"));
        	}

        }catch (SQLException se) {
            log.error("err " + se.toString(), se);
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error("err " + ex.toString(), ex);
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
		return resultVO;
    }
}