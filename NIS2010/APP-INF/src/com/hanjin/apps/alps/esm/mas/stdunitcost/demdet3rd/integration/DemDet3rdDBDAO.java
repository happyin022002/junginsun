/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DemDet3rdDBDAO.java
*@FileTitle : DEM/DET 3RD조회수정
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.25
*@LastModifier : 송호진
*@LastVersion : 1.0
* 2009.08.25 송호진
* 1.0 Creation
* 2017.05.15 송민석 ERP MAS의 Phase out에 따라 영향 받는 화면에 대한 수정 프로젝트 1차
=========================================================*/
package com.hanjin.apps.alps.esm.mas.stdunitcost.demdet3rd.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.mas.common.vo.SearchConditionVO;
import com.hanjin.apps.alps.esm.mas.stdunitcost.demdet3rd.basic.DemDet3rdBCImpl;
import com.hanjin.apps.alps.esm.mas.stdunitcost.demdet3rd.vo.DemDet3rdVO;
import com.hanjin.apps.alps.esm.mas.stdunitcost.usdomestic.integration.USDomesticDBDAODomesticStatusMonthCopyCSQL;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.integration.NetworkCostDBDAOCreateDailyHireFromFMSMonthCopyCSQL;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.integration.NetworkCostDBDAORemoveDailyHireDSQL;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;


/**
 * ALPS DemDet3rdDBDAO <br>
 * - ALPS-STDUnitCost system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Song Ho Jin
 * @see DemDet3rdBCImpl 참조
 * @since J2EE 1.6
DemDet3rdDBDAODemDet3rdVOUSQL
DemDet3rdDBDAOMultiDEMDET3RDUSQL
 */
public class DemDet3rdDBDAO extends DBDAOSupport {

	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param SearchConditionVO conditionVO
	 * @return List<DemDet3rdVO>
	 * @throws DAOException
	 */
	public List<DemDet3rdVO> searchDEMDET3RDList(SearchConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<DemDet3rdVO> list = null;
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DemDet3rdDBDAOSearchDEMDET3RDListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, DemDet3rdVO .class);
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
	 * @param List<DemDet3rdVO> demDet3rdVO
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] modifyDEMDET3RD(List<DemDet3rdVO> demDet3rdVO) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(demDet3rdVO .size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new DemDet3rdDBDAOMultiDEMDET3RDUSQL(), demDet3rdVO,null);
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
     * @param List<DemDet3rdVO> demDet3rdVO
     * @return int[]
     * @throws DAOException
     * @throws Exception
     */
    public int[] removeDEMDET3RD(List<DemDet3rdVO> demDet3rdVO) throws DAOException,Exception {
        int updCnt[] = null;
        try {
            SQLExecuter sqlExe = new SQLExecuter("");
            if(demDet3rdVO .size() > 0){
                updCnt = sqlExe.executeBatch((ISQLTemplate)new DemDet3rdDBDAOMultiDEMDET3RDDSQL(), demDet3rdVO,null);
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
  * @param List<DemDet3rdVO> demDet3rdVO
  * @return int[]
  * @throws DAOException
  * @throws Exception
  */
 public int[] addDEMDET3RD(List<DemDet3rdVO> demDet3rdVO) throws DAOException,Exception {
     int updCnt[] = null;
     try {
         SQLExecuter sqlExe = new SQLExecuter("");
         if(demDet3rdVO .size() > 0){
             updCnt = sqlExe.executeBatch((ISQLTemplate)new DemDet3rdDBDAOMultiDEMDET3RDCSQL(), demDet3rdVO,null);
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
     * @param SearchConditionVO conditionVO
     * @return List<DemDet3rdVO>
     * @throws DAOException
     */
    public Integer searchDemDet3rdMonthCount(SearchConditionVO conditionVO) throws DAOException {
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
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DemDet3rdDBDAOSearchDemDet3rdMonthCountRSQL(), param, velParam);
            
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
    
    
    
 
    /**
     * [처리대상] 정보를 [행위] 합니다.<br>
     * 
     * @param List<DemDet3rdVO> demDet3rdVO
     * @return int[]
     * @throws DAOException
     * @throws Exception
     */
    public void removeDemDet3rdMonth(HashMap<String, String> param) throws DAOException,Exception {
         try {
             new SQLExecuter("").executeUpdate((ISQLTemplate)new DemDet3rdDBDAOMultiDemDet3rdMonthDSQL(), param, null);

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
    public void addDemDet3rdMonthCopy(HashMap<String, String> param) throws DAOException {

        int saveCnt = 0;
        try{
        
            saveCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new DemDet3rdDBDAOMultiDemDet3rdMonthCopyCSQL(), param, null);
            
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
    public int addDemDet3rdStatusMonthCopy(HashMap<String, String> map) throws DAOException,Exception {
        
        int result = 0;
        try {
            SQLExecuter sqlExe = new SQLExecuter("");
            result = sqlExe.executeUpdate((ISQLTemplate)new DemDet3rdDBDAOMultiDemDet3rdCreationStatusUSQL(), map, null);
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