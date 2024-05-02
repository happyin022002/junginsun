/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MASDBDAO.java
*@FileTitle : ABC (PA) / STP Cost (RA) 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.04
*@LastModifier : 전윤주
*@LastVersion : 1.0
* 2009.08.04 전윤주
* 1.0 Creation 
* 
* 2012.08.27 이석준[CHM-201219844-01]   ABC(PA)/STP Cost(RA)화면에 Month Copy 기능 추가 
=========================================================*/
package com.hanjin.apps.alps.esm.mas.stdunitcost.mas.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.mas.common.vo.SearchConditionVO;
import com.hanjin.apps.alps.esm.mas.stdunitcost.mas.basic.MASBCImpl;
import com.hanjin.apps.alps.esm.mas.stdunitcost.mas.vo.SearchMAS0012ListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.MasSvcTrnsPrcVO;


/**
 * ALPS MASDBDAO <br>
 * - ALPS-STDUnitCost system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Jeon Yun Joo
 * @see MASBCImpl 참조
 * @since J2EE 1.6
 */
public class MASDBDAO extends DBDAOSupport {

	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param SearchMAS0012ListVO searchMAS0012ListVO
	 * @param SearchConditionVO searchConditionVO
	 * @return List<SearchMAS0012ListVO>
	 * @throws DAOException
	 */
	public List<SearchMAS0012ListVO> searchMAS0012List(SearchMAS0012ListVO searchMAS0012ListVO
			                                          ,SearchConditionVO searchConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchMAS0012ListVO> list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchMAS0012ListVO != null){
				Map<String, String> mapVO = searchMAS0012ListVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			if(searchConditionVO != null){
				Map<String, String> mapVO = searchConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MASDBDAOSearchMAS0012ListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchMAS0012ListVO .class);
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
	 * @param List<MasSvcTrnsPrcVO> updModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] modifyMAS0012(List<MasSvcTrnsPrcVO> updModels) throws DAOException,Exception {
		int updCnt[] = null;
		try {			
			SQLExecuter sqlExe = new SQLExecuter("");
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new MASDBDAOMasSvcTrnsPrcVOUSQL(), updModels,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return updCnt;
	}	
	
	/**
	 * ABC/STP관련 Table을 삭제 한다. 
	 *
	 * @param HashMap<String, String> map
	 * @throws DAOException
	 */
	public void removeAbcStpCost(HashMap<String, String> map) throws DAOException {
		int saveCnt = 0;
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();


        try{
        	velParam.put("table_name", "MAS_SVC_TRNS_PRC");
        	saveCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new MASDBDAORemoveAbcStpCostDSQL(), map, velParam);
            if(saveCnt== Statement.EXECUTE_FAILED)
                throw new DAOException("Fail to modify SQL");

        	velParam.put("table_name", "MAS_SVC_TRNS_OFC_MAPG");
        	saveCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new MASDBDAORemoveAbcStpCostDSQL(), map, velParam);
            if(saveCnt== Statement.EXECUTE_FAILED)
                throw new DAOException("Fail to modify SQL");  
            
        	velParam.put("table_name", "MAS_OFC_ROUT_MAPG");
        	saveCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new MASDBDAORemoveAbcStpCostDSQL(), map, velParam);
            if(saveCnt== Statement.EXECUTE_FAILED)
                throw new DAOException("Fail to modify SQL");
            
        	velParam.put("table_name", "MAS_SVC_TRNS_PRC_MGN");
        	saveCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new MASDBDAORemoveAbcStpCostDSQL(), map, velParam);
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
	 * ABC/STP관련  데이터를 전월로부터 복사한다.
	 *
	 * @param HashMap<String, String> map
	 * @throws DAOException
	 */
	public void createCopyAbcStpCost(HashMap<String, String> map) throws DAOException {
		int saveCnt = 0;
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();


        try{
        	velParam.put("table_name", "MAS_SVC_TRNS_PRC");
        	saveCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new MASDBDAOCreateCopyAbcStpCostCSQL(), map, velParam);
            if(saveCnt== Statement.EXECUTE_FAILED)
                throw new DAOException("Fail to modify SQL");

        	velParam.put("table_name", "MAS_SVC_TRNS_OFC_MAPG");
        	saveCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new MASDBDAOCreateCopyAbcStpCostCSQL(), map, velParam);
            if(saveCnt== Statement.EXECUTE_FAILED)
                throw new DAOException("Fail to modify SQL");  
            
        	velParam.put("table_name", "MAS_OFC_ROUT_MAPG");
        	saveCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new MASDBDAOCreateCopyAbcStpCostCSQL(), map, velParam);
            if(saveCnt== Statement.EXECUTE_FAILED)
                throw new DAOException("Fail to modify SQL");
            
        	velParam.put("table_name", "MAS_SVC_TRNS_PRC_MGN");
        	saveCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new MASDBDAOCreateCopyAbcStpCostCSQL(), map, velParam);
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
	 *ABC/STP UC 월단가 복사 상태를 단가 관리 table에 update한다.
	 *
	 * @param  HashMap<String, String> map
	 * @throws DAOException
	 */
	public void modifyAbcStpCopyCreationStatus(HashMap<String, String> map) throws DAOException {
		int saveCnt = 0;

        try{
            saveCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new MASDBDAOModifyAbcStpCopyCreationStatusUSQL(), map, null);
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

}