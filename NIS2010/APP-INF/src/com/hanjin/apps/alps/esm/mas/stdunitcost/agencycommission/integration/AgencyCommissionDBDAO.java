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
package com.hanjin.apps.alps.esm.mas.stdunitcost.agencycommission.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.mas.common.vo.SearchConditionVO;
import com.hanjin.apps.alps.esm.mas.stdunitcost.agencycommission.basic.AgencyCommissionBCImpl;
import com.hanjin.apps.alps.esm.mas.stdunitcost.agencycommission.vo.SearchAgnOtrCommCostListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.MasOtrCommVO;



/**
 * ALPS AgencyCommissionDBDAO <br>
 * - ALPS-STDUnitCost system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Jang Yeong-seok
 * @see AgencyCommissionBCImpl 참조
 * @since J2EE 1.6
 */
public class AgencyCommissionDBDAO extends DBDAOSupport {


	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param SearchAgnOtrCommCostListVO searchAgnOtrCommCostListVO
	 * @param SearchConditionVO searchConditionVO
	 * @return List<SearchAgnOtrCommCostListVO>
	 * @throws DAOException
	 */
	public List<SearchAgnOtrCommCostListVO> searchAgnOtrCommCostList(SearchAgnOtrCommCostListVO searchAgnOtrCommCostListVO
			                                                         ,SearchConditionVO searchConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchAgnOtrCommCostListVO> list = null;
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AgencyCommissionDBDAOSearchAgnOtrCommCostListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchAgnOtrCommCostListVO .class);
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
	 * @param List<MasOtrCommVO> masOtrCommVO
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] addmultiAgnOtrCommCost(List<MasOtrCommVO> masOtrCommVO) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(masOtrCommVO .size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AgencyCommissionDBDAOMasOtrCommVOCSQL(), masOtrCommVO,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
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
		return insCnt;
	}
	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<MasOtrCommVO> masOtrCommVO
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] modifymultiAgnOtrCommCost(List<MasOtrCommVO> masOtrCommVO) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(masOtrCommVO .size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new AgencyCommissionDBDAOMasOtrCommVOUSQL(), masOtrCommVO,null);
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
	 * @param List<MasOtrCommVO> masOtrCommVO
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] removemultiAgnOtrCommCost(List<MasOtrCommVO> masOtrCommVO) throws DAOException,Exception {
		int delCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(masOtrCommVO .size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new AgencyCommissionDBDAOMasOtrCommVODSQL(), masOtrCommVO,null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
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
		return delCnt;
	}
	
	
	  
	 
    /**
     * [처리대상] 정보를 [행위] 합니다.<br>
     * 
     * @param List<DemDet3rdVO> demDet3rdVO
     * @return int[]
     * @throws DAOException
     * @throws Exception
     */
    public void removeAgnOtrCommCostMonth(HashMap<String, String> param) throws DAOException,Exception {
         try {
             new SQLExecuter("").executeUpdate((ISQLTemplate)new AgencyCommissionDBDAOMultiAgnOtrCommCostMonthDSQL(), param, null);

        } catch(SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch(Exception ex) {
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
     }  
    
    /**
     * Daily Hire FMS 테이블을 전월 copy 한다.
     *
     * @param HashMap<String, String> map
     * @throws DAOException
     */
    public void addAgnOtrCommCostMonthCopy(HashMap<String, String> param) throws DAOException {

        int saveCnt = 0;
        try{
        
            saveCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new AgencyCommissionDBDAOMultiAgnOtrCommCostMonthCopyCSQL(), param, null);
            
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
     * [Domestic Saving Credit 의 생성] 정보를 [복사] 합니다.<br>
     * 
     * @param HashMap<String, String> map
     * @return int
     * @throws DAOException
     * @throws Exception
     */
    public int addAgnOtrCommCostStatusMonthCopy(HashMap<String, String> map) throws DAOException,Exception {
        
        int result = 0;
        try {
            SQLExecuter sqlExe = new SQLExecuter("");
            result = sqlExe.executeUpdate((ISQLTemplate)new AgencyCommissionDBDAOMultiAgnOtrCommCostCreationStatusUSQL(), map, null);
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
     * [처리대상] 정보를 [행위] 합니다.<br>
     * 
     * @param SearchConditionVO conditionVO
     * @return List<DemDet3rdVO>
     * @throws DAOException
     */
    public Integer searchAgnOtrCommCostMonthCount(SearchConditionVO conditionVO) throws DAOException {
        DBRowSet dbRowset = null;
        int cnt = 0;
//query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            if(conditionVO != null){
                Map<String, String> mapVO = conditionVO .getColumnValues();
            
                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AgencyCommissionDBDAOSearchAgnOtrCommCostMonthCountRSQL(), param, velParam);
            
            if (dbRowset.next()) {
                cnt = dbRowset.getInt(1);
            }
        } catch(SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch(Exception ex) {
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return cnt;
    }
    
	
}