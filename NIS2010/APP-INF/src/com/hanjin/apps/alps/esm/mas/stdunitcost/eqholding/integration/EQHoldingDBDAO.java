/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EQHoldingDBDAO.java
*@FileTitle : 실적장비비 표준단가 조회, 생성
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.26
*@LastModifier : 송호진
*@LastVersion : 1.0
* 2009.08.26 송호진
* 1.0 Creation
* 2012.08.02 이석준[CHM-201219334-01] EQ Holding Cost 화면 Month Copy 기능 추가
=========================================================*/
package com.hanjin.apps.alps.esm.mas.stdunitcost.eqholding.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.mas.common.vo.SearchConditionVO;
import com.hanjin.apps.alps.esm.mas.stdunitcost.demdet3rd.integration.DemDet3rdDBDAOMultiDemDet3rdMonthCopyCSQL;
import com.hanjin.apps.alps.esm.mas.stdunitcost.eqholding.basic.EQHoldingBCImpl;
import com.hanjin.apps.alps.esm.mas.stdunitcost.eqholding.vo.CntrPdmInvtVO;
import com.hanjin.apps.alps.esm.mas.stdunitcost.eqholding.vo.EqCntrHldCostVO;
import com.hanjin.apps.alps.esm.mas.stdunitcost.eqholding.vo.EqDayMgmtVO;
import com.hanjin.apps.alps.esm.mas.stdunitcost.eqholding.vo.EqHoldingCostVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;


/**
 * ALPS EQHoldingDBDAO <br>
 * - ALPS-STDUnitCost system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Song Ho Jin
 * @see EQHoldingBCImpl 참조
 * @since J2EE 1.6
 */
public class EQHoldingDBDAO extends DBDAOSupport {

	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param SearchConditionVO conditionVO
	 * @return List<EqCntrHldCostVO>
	 * @throws DAOException
	 */
	public List<EqCntrHldCostVO> searchEQCntrHldCost(SearchConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<EqCntrHldCostVO> list = null;
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
//			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EQHoldingDBDAOSearchEQHoldingCostRSQL(), param, velParam);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EQHoldingDBDAOSearchEQCntrHldCostRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, EqCntrHldCostVO .class);
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
	 * @param SearchConditionVO conditionVO
	 * @return List<EqCntrHldCostVO>
	 * @throws DAOException
	 */
	public List<EqCntrHldCostVO> searchEQHldCostSum(SearchConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<EqCntrHldCostVO> list = null;
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EQHoldingDBDAOSearchEQHldCostSumRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, EqCntrHldCostVO .class);
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
	 * @param SearchConditionVO conditionVO
	 * @return List<EqCntrHldCostVO>
	 * @throws DAOException
	 */
	public List<EqCntrHldCostVO> searchEQHldCostPdm(SearchConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<EqCntrHldCostVO> list = null;
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EQHoldingDBDAOSearchEQHldCostPdmRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, EqCntrHldCostVO .class);
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
	 * @param List<EqHoldingCostVO> eqHoldingCostVO
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] modifyEQHoldingCost(List<EqHoldingCostVO> eqHoldingCostVO) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(eqHoldingCostVO .size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new EQHoldingDBDAOMultiEQHoldingCostUSQL(), eqHoldingCostVO,null);
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
	 * @param List<EqHoldingCostVO> eqHoldingCostVO
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] removeEQHoldingCost(List<EqHoldingCostVO> eqHoldingCostVO) throws DAOException,Exception {
		int delCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(eqHoldingCostVO .size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new EQHoldingDBDAOMultiEQHoldingCostDSQL(), eqHoldingCostVO,null);
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
     * @param List<EqHoldingCostVO> eqHoldingCostVO
     * @return int[]
     * @throws DAOException
     * @throws Exception
     */
    public int[] multiEQHldCostPdm(List<EqCntrHldCostVO> eqCntrHldCostVO) throws DAOException,Exception {
        int updCnt[] = null;
        try {
            SQLExecuter sqlExe = new SQLExecuter("");
            if(eqCntrHldCostVO.size() > 0){
                updCnt = sqlExe.executeBatch((ISQLTemplate)new EQHoldingDBDAOmultiEQHldCostPdmUSQL(), eqCntrHldCostVO, null);
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
	 * EQ Holding Cost Table을 삭제 한다. 
	 *
	 * @param HashMap<String, String> map
	 * @throws DAOException
	 */
	public void removeEqHoldingCost(HashMap<String, String> map) throws DAOException {
		int saveCnt = 0;

        try{
            	
        	saveCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new EQHoldingDBDAORemoveEqHoldingCostDSQL(), map, null);

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
	 * EQ Holding UC 월단가를 복사해서 생성한다.
	 *
	 * @param  HashMap<String, String> map
	 * @throws DAOException
	 */
	public void createEqHoldingMonthCopy(HashMap<String, String> map) throws DAOException {
		int saveCnt = 0;

        try{
            saveCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new EQHoldingDBDAOCreateEqHoldingMonthCopyCSQL(), map, null);
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
	 * EQ Holding UC 월단가 복사 상태를 단가 관리 table에 update한다.
	 *
	 * @param  HashMap<String, String> map
	 * @throws DAOException
	 */
	public void modifyEqHoldingCreationStatus(HashMap<String, String> map) throws DAOException {
		int saveCnt = 0;

        try{
            saveCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new EQHoldingDBDAOModifyEqHoldingCreationStatusUSQL(), map, null);
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
	 * @param CntrPdmInvtVO cntrPdmInvtVO
	 * @return List<CntrPdmInvtVO>
	 * @throws DAOException
	 */
	public List<CntrPdmInvtVO> searchCntrPdmInvtList(CntrPdmInvtVO cntrPdmInvtVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CntrPdmInvtVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(cntrPdmInvtVO != null){
				Map<String, String> mapVO = cntrPdmInvtVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EQHoldingDBDAOSearchCntrPdmInvtListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CntrPdmInvtVO .class);
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
	 * @param List<CntrPdmInvtVO> cntrPdmInvtVO
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] addCntrPdmInvt(List<CntrPdmInvtVO> cntrPdmInvtVO) throws DAOException,Exception {
		int addCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(cntrPdmInvtVO .size() > 0){
				addCnt = sqlExe.executeBatch((ISQLTemplate)new EQHoldingDBDAOAddCntrPdmInvtCSQL(), cntrPdmInvtVO,null);
				for(int i = 0; i < addCnt.length; i++){
					if(addCnt[i]== Statement.EXECUTE_FAILED)
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
		return addCnt;
	}
	
	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<CntrPdmInvtVO> cntrPdmInvtVO
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] modifyCntrPdmInvt(List<CntrPdmInvtVO> cntrPdmInvtVO) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(cntrPdmInvtVO .size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new EQHoldingDBDAOModifyCntrPdmInvtUSQL(), cntrPdmInvtVO,null);
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
	 * @param List<CntrPdmInvtVO> cntrPdmInvtVO
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] removeCntrPdmInvt(List<CntrPdmInvtVO> cntrPdmInvtVO) throws DAOException,Exception {
		int delCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(cntrPdmInvtVO .size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new EQHoldingDBDAORemoveCntrPdmInvtDSQL(), cntrPdmInvtVO,null);
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
	 * @param EqDayMgmtVO eqDayMgmtVO
	 * @return List<EqDayMgmtVO>
	 * @throws DAOException
	 */
	public List<EqDayMgmtVO> searchEqDayMgmtList(EqDayMgmtVO eqDayMgmtVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<EqDayMgmtVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		List<String> cntrTpszArr = new ArrayList();		
		String cntrTpszLst = eqDayMgmtVO.getFCntrTpszCd();
		
		try{
			if(eqDayMgmtVO != null){
				Map<String, String> mapVO = eqDayMgmtVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);

				if (cntrTpszLst != null && cntrTpszLst.indexOf(",") > -1) {
					String[] tpsz = cntrTpszLst.split(",");
					for (int i=0; i<tpsz.length; i++) {
						cntrTpszArr.add(tpsz[i]);
					}
					velParam.put("f_cntr_tpsz_cd", cntrTpszArr);
				}
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EQHoldingDBDAOSearchEqDayMgmtRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, EqDayMgmtVO .class);
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
	 * @param List<EqDayMgmtVO> eqDayMgmtVO
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] addEqDayMgmt(List<EqDayMgmtVO> eqDayMgmtVO) throws DAOException,Exception {
		int addCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(eqDayMgmtVO .size() > 0){
				addCnt = sqlExe.executeBatch((ISQLTemplate)new EQHoldingDBDAOAddEqDayMgmtCSQL(), eqDayMgmtVO,null);
				for(int i = 0; i < addCnt.length; i++){
					if(addCnt[i]== Statement.EXECUTE_FAILED)
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
		return addCnt;
	}

	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<EqDayMgmtVO> eqDayMgmtVO
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] modifyEqDayMgmt(List<EqDayMgmtVO> eqDayMgmtVO) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(eqDayMgmtVO .size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new EQHoldingDBDAOModifyEqDayMgmtUSQL(), eqDayMgmtVO,null);
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
	 * @param List<EqDayMgmtVO> eqDayMgmtVO
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] removeEqDayMgmt(List<EqDayMgmtVO> eqDayMgmtVO) throws DAOException,Exception {
		int delCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(eqDayMgmtVO .size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new EQHoldingDBDAORemoveEqDayMgmtDSQL(), eqDayMgmtVO,null);
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
     * @param EqHoldingCostVO eqHoldingCostVO
     * @throws DAOException
     * @throws Exception
     */
    public void removeEQHoldingIFMgmt(Map<String, String> map) throws DAOException,Exception {
         
        try {
           int saveCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new EQHoldingDBDAOMultiEQHoldingIFMgmtDSQL(), map, null);

            if(saveCnt== Statement.EXECUTE_FAILED)
                throw new DAOException("Fail to modify SQL");
             
        } catch(SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch(Exception ex) {
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
    }
    
    
    /**
     * MAS_CNTR_HLD_COST를 바탕으로 재 생성
     *
     * @param HashMap<String, String> map
     * @throws DAOException
     */
    public void addEQHoldingIFMgmt(Map<String, String> param) throws DAOException {

        int saveCnt = 0;
        try{
        
            saveCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new EQHoldingDBDAOMultiEQHoldingIFMgmtCSQL(), param, param);
            
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
     * [처리대상] 정보를 [행위] 합니다.<br>
     * 
     * @param SearchConditionVO conditionVO
     * @return List<EqCntrHldCostVO>
     * @throws DAOException
     */
    public List<EqCntrHldCostVO> searchEQHldCostPdmNormal(SearchConditionVO conditionVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<EqCntrHldCostVO> list = null;
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
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EQHoldingDBDAOSearchEQHldCostPdmNormalRSQL(), param, velParam);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, EqCntrHldCostVO .class);
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
     * @param List<EqHoldingCostVO> eqHoldingCostVO
     * @return int[]
     * @throws DAOException
     * @throws Exception
     */
    public int[] multiEQHldCostPdmNormal(List<EqCntrHldCostVO> eqCntrHldCostVO) throws DAOException,Exception {
        int updCnt[] = null;
        try {
            SQLExecuter sqlExe = new SQLExecuter("");
            if(eqCntrHldCostVO.size() > 0){
                updCnt = sqlExe.executeBatch((ISQLTemplate)new EQHoldingDBDAOmultiEQHldCostPdmNormalUSQL(), eqCntrHldCostVO, null);
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
}