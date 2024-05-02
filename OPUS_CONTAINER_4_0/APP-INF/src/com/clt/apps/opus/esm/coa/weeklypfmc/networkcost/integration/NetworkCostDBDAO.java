 /*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : NetworkCostDBDAO.java
 *@FileTitle : Network Cost DBDAO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2006-11-13
 *@LastModifier : kimyoungchul
 *@LastVersion : 1.0
 * 2006-11-13 kimyoungchul
 * 1.0 최초 생성
 * =========================================================
 * History
 =========================================================*/
package com.clt.apps.opus.esm.coa.weeklypfmc.networkcost.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.coa.common.vo.CommonCoaRsVO;
import com.clt.apps.opus.esm.coa.common.vo.ProcedureParamVO;
import com.clt.apps.opus.esm.coa.common.vo.SearchConditionVO;
import com.clt.apps.opus.esm.coa.weeklypfmc.networkcost.integration.NetworkCostDBDAOPndlmSvcBatchUSQL;
import com.clt.apps.opus.esm.coa.weeklypfmc.networkcost.integration.NetworkCostDBDAOPndlmSvcDtlCSQL;
import com.clt.apps.opus.esm.coa.weeklypfmc.networkcost.integration.NetworkCostDBDAOPndlmSvcDtlDSQL;
import com.clt.apps.opus.esm.coa.weeklypfmc.networkcost.integration.NetworkCostDBDAOPndlmSvcDtlRSQL;
import com.clt.apps.opus.esm.coa.weeklypfmc.networkcost.integration.NetworkCostDBDAOPndlmSvcCSQL;
import com.clt.apps.opus.esm.coa.weeklypfmc.networkcost.integration.NetworkCostDBDAOPndlmSvcDSQL;
import com.clt.apps.opus.esm.coa.weeklypfmc.networkcost.integration.NetworkCostDBDAOPndlmSvcRSQL;
import com.clt.apps.opus.esm.coa.weeklypfmc.networkcost.vo.PndlmSvcVO;
import com.clt.apps.opus.esm.coa.weeklypfmc.networkcost.basic.NetworkCostBCImpl;
import com.clt.apps.opus.esm.coa.weeklypfmc.networkcost.vo.CoaPortTrfParamVO;
import com.clt.apps.opus.esm.coa.weeklypfmc.networkcost.vo.NetworkCostCommonVO;
import com.clt.apps.opus.esm.coa.weeklypfmc.networkcost.vo.SearchBunkerTariff2MonthCountVO;
import com.clt.apps.opus.esm.coa.weeklypfmc.networkcost.vo.SearchBunkerTariffListVO;
import com.clt.apps.opus.esm.coa.weeklypfmc.networkcost.vo.SearchDailyHire2MonthCountVO;
import com.clt.apps.opus.esm.coa.weeklypfmc.networkcost.vo.SearchDailyHireListVO;
import com.clt.apps.opus.esm.coa.weeklypfmc.networkcost.vo.SearchFixCostByVVDListVO;
import com.clt.apps.opus.esm.coa.weeklypfmc.networkcost.vo.SearchIntervalTransitTimeListVO;
import com.clt.apps.opus.esm.coa.weeklypfmc.networkcost.vo.SearchMissingStatusListVO;
import com.clt.apps.opus.esm.coa.weeklypfmc.networkcost.vo.SearchNWCreListVO;
import com.clt.apps.opus.esm.coa.weeklypfmc.networkcost.vo.SearchNWCreRStatusListVO;
import com.clt.apps.opus.esm.coa.weeklypfmc.networkcost.vo.SearchOptFixedCostListVO;
import com.clt.apps.opus.esm.coa.weeklypfmc.networkcost.vo.SearchPortTariffDetailListVO;
import com.clt.apps.opus.esm.coa.weeklypfmc.networkcost.vo.SearchPortTariffListVO;
import com.clt.apps.opus.esm.coa.weeklypfmc.networkcost.vo.SearchSltChtrCreListVO;
import com.clt.apps.opus.esm.coa.weeklypfmc.networkcost.vo.SearchSltChtrCreRStatusListVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.CoaInterPrcUtCostVO;
import com.clt.syscommon.common.table.CoaInterPrcVvdExpnVO;
import com.clt.syscommon.common.table.CoaMonVvdPortOpDysVO;
import com.clt.syscommon.common.table.CoaNtwkCostCreVO;
import com.clt.syscommon.common.table.CoaSltChtrInfoVO;



/**
 * COA에 대한 DB 처리를 담당<br>
 * - COA Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author kimyoungchul
 * @see NetworkCostBCImpl 참조
 * @since J2EE 1.4 
 */
public class NetworkCostDBDAO extends DBDAOSupport {

    /**
     *  목록을 가져온다.<br>
     *
     * @param SearchConditionVO searchConditionVO
     * @return List<SearchIntervalTransitTimeListVO>
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
	public List<SearchIntervalTransitTimeListVO> searchIntervalTransitTimeList(SearchConditionVO searchConditionVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<SearchIntervalTransitTimeListVO> list = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
        try{
            if(searchConditionVO == null) return null;
            
            param.putAll(searchConditionVO.getColumnValues());
            velParam.putAll(searchConditionVO.getColumnValues());
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new NetworkCostDBDAOSearchIntervalTransitTimeListRSQL(), param, velParam);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchIntervalTransitTimeListVO.class);
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
     * COA_PORT_TARIFF 여러 데이타 모델을 지정된 ibflag 값에 따라 DB에 반영한다.(수정)<br>
     *
     * @param  List<CoaMonVvdPortOpDysVO> multiList
     * @throws DAOException
     */
	public void multiIntervalTransitTime(List<CoaMonVvdPortOpDysVO> multiList) throws DAOException {
        int updCnt[] = null;
        try{
            SQLExecuter sqlExe = new SQLExecuter("");
            if(multiList != null ){
                updCnt = sqlExe.executeBatch((ISQLTemplate)new NetworkCostDBDAOMultiIntervalTransitTimeUSQL(), multiList, null);
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
     * COA_PORT_TARIFF 목록을 조회한다.
     *
     * @param SearchConditionVO searchConditionVO
     * @return List<SearchPortTariffListVO>
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
	public List<SearchPortTariffListVO> searchPortTariffList(SearchConditionVO searchConditionVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<SearchPortTariffListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
        try{
            if(searchConditionVO == null) return null;
            
            param.putAll(searchConditionVO.getColumnValues());
            velParam.putAll(searchConditionVO.getColumnValues());
            if(searchConditionVO.getFYrtype().equals("M")){
            	velParam.put("apply", Integer.parseInt(searchConditionVO.getFYear()+searchConditionVO.getFFmMon()));
            } else {
            	velParam.put("apply", Integer.parseInt(searchConditionVO.getFYear()+searchConditionVO.getFFmWk()));
            }
            
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new NetworkCostDBDAOSearchPortTariffListRSQL(), param, velParam);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchPortTariffListVO.class);
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
     * COA_PORT_TARIFF 목록을 생성한다.
     *
     * @param SearchConditionVO searchConditionVO
     * @param SignOnUserAccount account
     * @throws DAOException
     */
	public void createPortTariff(SearchConditionVO searchConditionVO, SignOnUserAccount account) throws DAOException {
        int insCnt = 0;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            SQLExecuter sqlExe = new SQLExecuter("");
            if(searchConditionVO != null){
                param.putAll(searchConditionVO.getColumnValues());
                velParam.putAll(searchConditionVO.getColumnValues());

                param.put("cre_usr_id", account.getUsr_id());
                param.put("upd_usr_id", account.getUsr_id());

                insCnt = sqlExe.executeUpdate((ISQLTemplate)new NetworkCostDBDAOCreatePortTariffCSQL(), param, velParam);
                if(insCnt == Statement.EXECUTE_FAILED)
                    throw new DAOException("Fail to createPortTariff SQL");
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

    
//    public void multiPortTariff(NetworkCostCommonVO vo) throws DAOException {
//        int insCnt[] = null;
//        int updCnt[] = null;
//        int delCnt[] = null;
//
//        try{
//            SQLExecuter sqlExe = new SQLExecuter("");
//            if(vo.getMultiCreateList().size() > 0){
//                insCnt = sqlExe.executeBatch((ISQLTemplate)new NetworkCostDBDAOMultiPortTariffCSQL(), vo.getMultiCreateList(), null);
//                for(int i = 0; i < insCnt.length; i++){
//                    if(insCnt[i]== Statement.EXECUTE_FAILED)
//                        throw new DAOException("Fail to insert No"+ i + " SQL");
//                }
//            }
//
//            if(vo.getMultiUpdateList().size() > 0){
//                updCnt = sqlExe.executeBatch((ISQLTemplate)new NetworkCostDBDAOMultiPortTariffUSQL(), vo.getMultiUpdateList(), null);
//                for(int i = 0; i < updCnt.length; i++){
//                    if(updCnt[i]== Statement.EXECUTE_FAILED)
//                        throw new DAOException("Fail to update No"+ i + " SQL");
//                }
//            }
//
//            if(vo.getMultiDeleteList().size() > 0){
//                delCnt = sqlExe.executeBatch((ISQLTemplate)new NetworkCostDBDAOMultiPortTariffDSQL(), vo.getMultiDeleteList(), null);
//                for(int i = 0; i < delCnt.length; i++){
//                    if(delCnt[i]== Statement.EXECUTE_FAILED)
//                        throw new DAOException("Fail to delete No"+ i + " SQL");
//                }
//            }
//        }catch (SQLException se) {
//            log.error("err " + se.toString(), se);
//            log.error(se.getMessage(),se);
//            throw new DAOException(new ErrorHandler(se).getMessage());
//        }catch(Exception ex){
//            log.error("err " + ex.toString(), ex);
//            log.error(ex.getMessage(),ex);
//            throw new DAOException(new ErrorHandler(ex).getMessage());
//        }
//    }

    /**
     * COA_PORT_TARIFF 데이타를 삽입한다.<br>
     *
     * @param  List<CoaPortTrfParamVO> createList
     * @throws DAOException
     */
    public void addPortTariff(List<CoaPortTrfParamVO> createList) throws DAOException {
        int insCnt[] = null;
        try{
            if(createList.size() > 0){
                insCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new NetworkCostDBDAOMultiPortTariffCSQL(), createList, null);
                for(int i = 0; i < insCnt.length; i++){
                    if(insCnt[i]== Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to insert No"+ i + " SQL");
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
     * COA_BUNKER_TARIFF 한주차에 2개월이 공존하는 경우 조사
     *
     * @param  NetworkCostCommonVO vo
     * @return List<SearchBunkerTariff2MonthCountVO>
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
	public List<SearchBunkerTariff2MonthCountVO> searchBunkerTariff2MonthCount(NetworkCostCommonVO vo) throws DAOException {
        DBRowSet dbRowset = null;
        List<SearchBunkerTariff2MonthCountVO> list = null;
        try{
            if(vo == null) return null;
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new NetworkCostDBDAOSearchBunkerTariff2MonthCountRSQL(), vo.getIndirectQueryParameter(), null);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchBunkerTariff2MonthCountVO.class);
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
     * COA_BUNKER_TARIFF 목록을 조회한다.
     *
     * @param  NetworkCostCommonVO vo
     * @return List<SearchBunkerTariffListVO>
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
	public List<SearchBunkerTariffListVO> searchBunkerTariffList(NetworkCostCommonVO vo) throws DAOException {
        DBRowSet dbRowset = null;
        List<SearchBunkerTariffListVO> list = null;
        try{
        	
            if(vo == null) return null;
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new NetworkCostDBDAOSearchBunkerTariffListRSQL(), vo.getIndirectQueryParameter(), vo.getIndirectVelocityParameter());
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchBunkerTariffListVO.class);
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
     * COA_BUNKER_TARIFF 여러 데이타 모델을 지정된 ibflag 값에 따라 DB에 반영한다.(수정)<br>
     *
     * @param  NetworkCostCommonVO vo
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
	public void multiBunkerTariff(NetworkCostCommonVO vo) throws DAOException {
        int saveCnt[] = null;
        try{
            SQLExecuter sqlExe = new SQLExecuter("");
            if(vo.getMultiSaveList().size() > 0){
                saveCnt = sqlExe.executeBatch((ISQLTemplate)new NetworkCostDBDAOMultiBunkerTariffCSQL(), vo.getMultiSaveList(), null);
                for(int i = 0; i < saveCnt.length; i++){
                    if(saveCnt[i]== Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to insert No"+ i + " SQL");
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
     * COA_BUNKER_TARIFF 한주차에 2개월이 공존하는 경우 조사
     *
     * @param  NetworkCostCommonVO vo
     * @return List<SearchDailyHire2MonthCountVO>
     * @throws DAOException
     */
	@SuppressWarnings("unchecked")
	public List<SearchDailyHire2MonthCountVO> searchDailyHire2MonthCount(NetworkCostCommonVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchDailyHire2MonthCountVO> list = null;
		try{
			if(vo == null) return null;	
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new NetworkCostDBDAOSearchDailyHire2MonthCountRSQL(), vo.getIndirectQueryParameter(), null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchDailyHire2MonthCountVO.class);
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
     * NetworkCost의 데이타 모델에 해당되는 값을 불러온다.<br>
     *
     * @param NetworkCostCommonVO vo
     * @return List<SearchDailyHireListVO>
     * @throws DAOException
     */
	@SuppressWarnings("unchecked")
	public List<SearchDailyHireListVO> searchDailyHireList(NetworkCostCommonVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchDailyHireListVO> list = null;
		try{
			if(vo == null) return null;	
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new NetworkCostDBDAOSearchDailyHireListRSQL(), vo.getIndirectQueryParameter(), vo.getIndirectVelocityParameter());
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchDailyHireListVO.class);
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
     * NetworkCost의 여러 데이타 모델을 지정된 ibflag 값에 따라 DB에 반영한다.(추가, 수정, 삭제)<br>
     *
     * @param NetworkCostCommonVO vo
     * @see ESM_COA_042Event
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
	public void multiDailyHire(NetworkCostCommonVO vo) throws DAOException {
        int insCnt[] = null;
        int updCnt[] = null;
        try{
        	SQLExecuter sqlExe = new SQLExecuter("");
            if(vo.getMultiCreateList().size() > 0){
                insCnt = sqlExe.executeBatch((ISQLTemplate)new NetworkCostDBDAOMultiDailyHireCSQL(), vo.getMultiCreateList(), null);
                for(int i = 0; i < insCnt.length; i++){
                    if(insCnt[i]== Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to insert No"+ i + " SQL");
                }            	
            }
            
            if(vo.getMultiUpdateList().size() > 0){
            	updCnt = sqlExe.executeBatch((ISQLTemplate)new NetworkCostDBDAOMultiDailyHireUSQL(), vo.getMultiUpdateList(), null);
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
     * COA_STND_ACCT 에서 고정비 항목을 조회한다.
     *  Operation Fixed Cost
     *  
     * @param NetworkCostCommonVO vo
     * @return List<SearchOptFixedCostListVO>
     * @throws DAOException
     */
	@SuppressWarnings("unchecked")
	public List<SearchOptFixedCostListVO> searchOptFixedCostList(NetworkCostCommonVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchOptFixedCostListVO> list = null;
		try{
			if(vo == null) return null;	
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new NetworkCostDBDAOSearchOptFixedCostListRSQL(), vo.getQueryParameter(), vo.getVelocityParameter());
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchOptFixedCostListVO.class);
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
     * COA_OWN_VSL_DLY_HIR 목록을 조회한다.
     *
     * @param  NetworkCostCommonVO vo
     * @return NetworkCostCommonVO
     * @throws DAOException
     */
	public NetworkCostCommonVO searchOwnDailyHireList(NetworkCostCommonVO vo) throws DAOException {
		DBRowSet dbRowset = null;
        NetworkCostCommonVO retVo = null;
		try{
			if(vo == null) return null;	
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new NetworkCostDBDAOSearchOwnDailyHireListRSQL(), vo.getIndirectQueryParameter(), vo.getIndirectVelocityParameter());
            retVo = new NetworkCostCommonVO();
			retVo.setRowSet(dbRowset);			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			log.error("err " + se.toString(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			log.error("err " + ex.toString(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return retVo;		
	}    

    /**
     * COA_OWN_VSL_DLY_HIR 여러 데이타 모델을 지정된 ibflag 값에 따라 DB에 반영한다.(수정)<br>
     *
     * @param  NetworkCostCommonVO vo
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
	public void multiOwnDailyHire(NetworkCostCommonVO vo) throws DAOException {
        int insCnt[] = null;
        try{
        	SQLExecuter sqlExe = new SQLExecuter("");
            if(vo.getMultiCreateList().size() > 0){            	
                insCnt = sqlExe.executeBatch((ISQLTemplate)new NetworkCostDBDAOMultiOwnDailyHireCSQL(), vo.getMultiCreateList(), null);
                for(int i = 0; i < insCnt.length; i++){
                    if(insCnt[i]== Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to insert No"+ i + " SQL");
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
     * NetworkCost의 데이타 모델에 해당되는 값을 불러온다.<br>
     * 사용 프로그램 : ESM_COA_0044
     * 
     * @param NetworkCostCommonVO vo
     * @return List<SearchFixCostByVVDListVO>
     * @throws DAOException
     */
    public List<SearchFixCostByVVDListVO> searchFixCostByVVDList(NetworkCostCommonVO vo) throws DAOException {
        DBRowSet dbRowset = null;
        List<SearchFixCostByVVDListVO> list = null;
        try{
            if(vo == null) return null;
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new NetworkCostDBDAOSearchFixCostByVVDListRSQL(), vo.getIndirectQueryParameter(), vo.getIndirectVelocityParameter());
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchFixCostByVVDListVO.class);
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
     * NetworkCost의 데이타 모델에 해당되는 값을 불러온다.<br>
     * 사용 프로그램 : ESM_COA_0110
     *
     * @param NetworkCostCommonVO vo
     * @return List<SearchNWCreListVO>
     * @throws DAOException
    */
    public List<SearchNWCreListVO> searchNWCreList(NetworkCostCommonVO vo) throws DAOException {
        DBRowSet dbRowset = null;
        List<SearchNWCreListVO> list = null;
        try{
            if(vo == null) return null;
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new NetworkCostDBDAOSearchNWCreListRSQL(), null, null);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchNWCreListVO.class);
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
     * NetworkCost의 데이타 모델에 해당되는 값을 불러온다.<br>
     * 사용 프로그램 : ESM_COA_0110
     *
     * @param  NetworkCostCommonVO vo
     * @return List<SearchNWCreRStatusListVO>
     * @throws DAOException
     */
    public List<SearchNWCreRStatusListVO> searchNWCreRStatusList(NetworkCostCommonVO vo) throws DAOException {
        DBRowSet dbRowset = null;
        List<SearchNWCreRStatusListVO> list = null;
        try{
            if(vo == null) return null;
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new NetworkCostDBDAOSearchNWCreRStatusListRSQL(), null, null);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchNWCreRStatusListVO.class);
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
     * COA_NTWK_COST_CRE를 DB에 반영한다.(삭제, 추가)<br>
     * 사용 프로그램 : ESM_COA_0110
     *
     * @param List<CoaNtwkCostCreVO> createList
     * @throws DAOException
     */
    public void multiNWCreForVVD(List<CoaNtwkCostCreVO> createList) throws DAOException {
        int insCnt[] = null;
        int delCnt = 0;
        try{
            SQLExecuter sqlExe = new SQLExecuter("");
            
            if(createList != null ){
                // COA_NTWK_COST_CRE 테이블 전체 삭제 
                delCnt = sqlExe.executeUpdate((ISQLTemplate)new NetworkCostDBDAOMultiNWCreForVVDDSQL(), null, null);
                    if(delCnt== Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to delete SQL");
                // 화면에 조회된 사항을 테이블에 삽입..
                insCnt = sqlExe.executeBatch((ISQLTemplate)new NetworkCostDBDAOMultiNWCreForVVDCSQL(), createList, null);
                for(int i = 0; i < insCnt.length; i++){
                    if(insCnt[i]== Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to insert No"+ i + " SQL");
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
     * NetworkCost의 데이타 모델에 해당되는 값을 불러온다.<br>
     * 사용 프로그램 : ESM_COA_0110
     *
     * @param NetworkCostCommonVO vo
     * @return List<SearchSltChtrCreListVO>
     * @throws DAOException
     */
    public List<SearchSltChtrCreListVO> searchSltChtrCreList(NetworkCostCommonVO vo) throws DAOException {
        DBRowSet dbRowset = null;
        List<SearchSltChtrCreListVO> list = null;
        try{
            if(vo == null) return null;
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new NetworkCostDBDAOSearchSltChtrCreListRSQL(), null, null);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchSltChtrCreListVO.class);
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
     * NetworkCost의 데이타 모델에 해당되는 값을 불러온다.<br>
     * 사용 프로그램 : ESM_COA_0110
     *
     * @param  NetworkCostCommonVO vo
     * @return List<SearchSltChtrCreRStatusListVO>
     * @throws DAOException
     */
    public List<SearchSltChtrCreRStatusListVO> searchSltChtrCreRStatusList(NetworkCostCommonVO vo) throws DAOException {
        DBRowSet dbRowset = null;
        List<SearchSltChtrCreRStatusListVO> list = null;
        try{
            if(vo == null) return null;
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new NetworkCostDBDAOSearchSltChtrCreRStatusListRSQL(), null, null);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchSltChtrCreRStatusListVO.class);
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
     * COA_SLT_CHTR_INFO를 DB에 반영한다.(삭제, 추가)<br>
     * 사용 프로그램 : ESM_COA_0110
     *
     * @param List<CoaSltChtrInfoVO> createList
     * @throws DAOException
     */
    public void multiSltChtrCre(List<CoaSltChtrInfoVO> createList) throws DAOException {
        int insCnt[] = null;
        int delCnt = 0;
        try{
            SQLExecuter sqlExe = new SQLExecuter("");
            
            if(createList != null && createList.size() > 0){
            	// COA_SLT_CHTR_INFO 전체삭제 
	            delCnt = sqlExe.executeUpdate((ISQLTemplate)new NetworkCostDBDAOMultiSltChtrCreDSQL(), null, null);

                if(delCnt== Statement.EXECUTE_FAILED)
                    throw new DAOException("Fail to delete SQL.");
                
	            // 조회된 내용으로 COA_SLT_CHTR_INFO 삽입
                insCnt = sqlExe.executeBatch((ISQLTemplate)new NetworkCostDBDAOMultiSltChtrCreCSQL(), createList, null);
                for(int i = 0; i < insCnt.length; i++){
                    if(insCnt[i]== Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to insert No"+ i + " SQL");
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

// ******************************************************************
//  [중요]변환 작업중 사용 안함으로 판단 주석 처리 ---> 2009.09.22
//******************************************************************    
//    /**
//     * NetworkCost의 데이타 모델에 해당되는 값을 불러온다.<br>
//     * 사용 프로그램 : ESM_COA_110
//     *
//     * @param et Event
//     * @return void
//     * @throws DAOException
//     */
//    public void createSltChtrCre(Event et) throws DAOException {
//        if (et == null) {
//            return;
//        }
//
//        Connection con = null; // Connection Interface
//        CallableStatement cs = null; // 정적파싱을 지원하는 SQL Statement
//        int i = 1; // PreparedStatement에 bind 변수를 넣을시 증가되는 변수
//
//        ESM_COA_110Event event = (ESM_COA_110Event) et;
//        int resultCount = 0; // 수행 결과가 정상인지를 판별하기 위한 변수
//        String err_cd  = ""; //에러코드
//        String err_msg = ""; //에러메시지
//
//        String txtYear     = event.getString("txtYear");
//        String txtFmWeek   = event.getString("txtFmWeek");
//        String cobTrade    = event.getCobTrade();
//        String cobLane     = event.getCobLane();
//        String cobDir      = event.getCobDir();
//        String txtVessel   = event.getTxtVessel();
//        String txtVoyage   = event.getTxtVoyage();
//        String txtDir      = event.getTxtDir();
//
//        String strYear = txtYear;
//        String strWeek = txtFmWeek;
//        String strDir = cobDir;
//        if (cobDir.trim().equals("")) {
//            strDir = txtDir;
//        }
//
//        StringBuffer strBuf = new StringBuffer();
//        strBuf.append("CALL COA_CREATE_SPC_CHT_PRC(?,?,?,?,?,?,?, ?,?,?) ");
//
//        try {
//            con = getConnection();
//
//            // Loggable Statement 사용에 의해 추가 ??
//            cs = con.prepareCall(strBuf.toString());
//
//            if (cobTrade == null) cobTrade = "";
//            if (cobLane == null) cobLane = "";
//            if (cobDir == null) cobDir = "";
//            if (txtVessel == null) txtVessel = "";
//            if (txtVoyage == null) txtVoyage = "";
//            if (txtDir == null) txtDir = "";
//
//            String user_id = event.getUserId();
//
//            // 쿼리에 변수 세팅.
//            cs.setString(i++, strYear);
//            cs.setString(i++, strWeek);
//            cs.setString(i++, cobTrade);
//            cs.setString(i++, cobLane);
//            cs.setString(i++, txtVessel);
//            cs.setString(i++, txtVoyage);
//            cs.setString(i++, strDir);
//
//            cs.setString(i++, user_id);
//
//            int out_param = i;
//
//            cs.registerOutParameter(i++, Types.VARCHAR);
//            cs.registerOutParameter(i++, Types.VARCHAR);
//
//            log.info("\n PROCEDURE : " + strBuf.toString() +
//             "\n IN Param (1) : " + strYear +
//             "\n IN Param (2) : " + strWeek +
//             "\n IN Param (3) : " + cobTrade +
//             "\n IN Param (4) : " + cobLane +
//             "\n IN Param (5) : " + txtVessel +
//             "\n IN Param (6) : " + txtVoyage +
//             "\n IN Param (7) : " + strDir +
//             "\n IN Param (8) : " + user_id);
//
//            resultCount = cs.executeUpdate();
//
//            err_cd  = cs.getString(out_param++);
//            err_msg = cs.getString(out_param++);
//
//            log.info("\n >>>>>>>>>>>> 생성결과(resultCount) = " + resultCount);
//            log.info("\n PROCEDURE : " + strBuf.toString() +
//             "\n OUT Param (err_cd)  : " + err_cd +
//             "\n OUT Param (err_msg) : " + err_msg);
//
//
//            event.setErrorCode(err_cd);
//            event.setErrorMsg(err_msg);
//
//      if (!err_cd.equals("00000")) {
//                String[] errMessage = {err_cd,err_msg};
//                throw new DAOException(new ErrorHandler("COA00025",errMessage).getMessage());
//      }
//        } catch (SQLException se) {
//            log.error("SQLException " + se.getMessage(), se);
//            throw new DAOException(new ErrorHandler(se).getMessage());
//        } catch (DAOException de) {
//      if (!err_cd.equals("00000")) {
//        log.error("정보:: ErrorHandler에 의한 DAOException 입니다. >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> \n");
//      }
//            log.error("DAOException " + de.getMessage(), de);
//            throw de;
//        } catch (Exception e) {
//            log.error("Exception " + e.getMessage(), e);
//            throw new DAOException(e.getMessage());
//        } finally {
//            closeStatement(cs);
//            closeConnection(con);
//        }
//    }

    /**
     * Missing List<br>
     * 사용 프로그램 : ESM_COA_0114
     * 
     * @param NetworkCostCommonVO vo
     * @return List<SearchMissingStatusListVO>
     * @throws DAOException
     */
    public List<SearchMissingStatusListVO> searchMissingStatusList(NetworkCostCommonVO vo) throws DAOException {
        DBRowSet dbRowset = null;
        List<SearchMissingStatusListVO> list = null;
        try{
            if(vo == null) return null;
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new NetworkCostDBDAOSearchMissingStatusListRSQL(), vo.getIndirectQueryParameter(), vo.getIndirectVelocityParameter());
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchMissingStatusListVO.class);
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
	 * [Trunk IPC Internal Pricing 단가] 정보를 [조회] 합니다.<br>
	 * 
	 * @param String cost_yrmon
	 * @return List<CoaInterPrcUtCostVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CoaInterPrcUtCostVO> searchTrunkIPCPricing(String cost_yrmon) throws DAOException {
		DBRowSet dbRowset = null;
		List<CoaInterPrcUtCostVO> list = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try{
			param.put("f_cost_yrmon", cost_yrmon);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new NetworkCostDBDAOSearchTrunkIPCPricingRSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CoaInterPrcUtCostVO .class);
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
	 * [Trunk IPC Internal Pricing 단가] 정보를 [삽입] 합니다.<br>
	 * 
	 * @param List<CoaInterPrcUtCostVO> insertVoList
	 * @return int[]
	 * @exception DAOException
	 * @exception Exception
	 */
	public int[] addTrunkIPCPricing(List<CoaInterPrcUtCostVO> insertVoList) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(insertVoList .size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new NetworkCostDBDAOMultiTrunkIPCPricingCSQL(), insertVoList,null);
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
	 * [Trunk IPC Internal Pricing 단가] 정보를 [수정] 합니다.<br>
	 * 
	 * @param List<CoaInterPrcUtCostVO> updateVoList
	 * @return int[]
	 * @exception DAOException
	 * @exception Exception
	 */
	public int[] modifyTrunkIPCPricing(List<CoaInterPrcUtCostVO> updateVoList) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(updateVoList .size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new NetworkCostDBDAOMultiTrunkIPCPricingUSQL(), updateVoList,null);
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
	 * [Re-Assignment by Bound(Internal Pricing)] 정보를 [조회] 합니다.<br>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @return List<CoaInterPrcVvdExpnVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CoaInterPrcVvdExpnVO> searchFixCostByVVDInterPrcList(SearchConditionVO searchConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CoaInterPrcVvdExpnVO> list = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//query parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			param.putAll(searchConditionVO.getColumnValues());
			velParam.putAll(searchConditionVO.getColumnValues());
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new NetworkCostDBDAOSearchFixCostByVVDInterPrcListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CoaInterPrcVvdExpnVO .class);
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
	 * [Re-Assignment by Bound(Internal Pricing)] 정보를 [조회] 합니다.<br>
	 * 
	 * @param ProcedureParamVO procedureParamVO
	 * @return ProcedureParamVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public ProcedureParamVO createFixCostByVVDInterPrc(ProcedureParamVO procedureParamVO) throws DAOException {
		Map<String, Object> resultMap = new HashMap<String, Object>();
    	ProcedureParamVO resultVO = new ProcedureParamVO();
		
		try{
			resultMap = new SQLExecuter("").executeSP((ISQLTemplate)new NetworkCostDBDAOCreateFixCostByVVDInterPrcCSQL(), procedureParamVO.getColumnValues(), null);
        	
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
     * 경리환율이 있는지 check하는 함수 (ESM_COA_0042)<br>
     *
     * @param String yyyymm
     * @return int
     * @throws DAOException
     * @SJH.20140728 ADD
     */
	public int checkExchangeRate(String yyyymm) throws DAOException {
        DBRowSet dbRowset = null;
        int select_row = 0;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
        try{
            if(yyyymm != null){
            	param.put("f_yearweek", yyyymm);
            	velParam.put("f_yearweek", yyyymm);
	            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new NetworkCostDBDAOCheckExchangeRateRSQL(), param, velParam);
	            select_row = dbRowset.getRowCount();
            }
            
        } catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
        return select_row;
    }
	
	/**
	 * Daily Hire I/F Table을 삭제 한다.
	 *
	 * @param String yyyymm
	 * @throws DAOException
	 */
	public void removeDailyHireIF(String yyyymm) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		int saveCnt = 0;

        try{
            if(yyyymm != null){
            	param.put("f_yearweek", yyyymm);
            	
        		saveCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new NetworkCostDBDAORemoveDailyHireIFDSQL(), param, null);
        	}

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
	 * Daily Hire I/F Table을 삭제 한다.
	 *
	 * @param String yyyymm
	 * @throws DAOException
	 */
	public void removeDailyHire(String yyyymm) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		int saveCnt = 0;

        try{
            if(yyyymm != null){
            	param.put("f_yearweek", yyyymm);
            	
        		saveCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new NetworkCostDBDAORemoveDailyHireDSQL(), param, null);
        	}

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
	 * FMS로부터 Daily Hire를 I/F 한다.
	 *
	 * @param SearchConditionVO searchConditionVO
	 * @param SignOnUserAccount account
	 * @throws DAOException
	 */
	public void createDailyHireFromFMS(SearchConditionVO searchConditionVO, SignOnUserAccount account) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		int saveCnt = 0;

        try{
        	if( searchConditionVO != null ){
        		param.putAll(searchConditionVO.getColumnValues());
        		param.put("user_id", account.getUsr_id());
        		saveCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new NetworkCostDBDAOCreateDailyHireFromFMSCSQL(), param, null);
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
	 * FMS로부터 I/F한 DailyHire를 COA 용선료 관리 Table로 입력한다.
	 *
	 * @param SearchConditionVO searchConditionVO
	 * @param SignOnUserAccount account
	 * @throws DAOException
	 */
	public void createDailyHireFromIFTable(SearchConditionVO searchConditionVO, SignOnUserAccount account) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		int saveCnt = 0;

        try{
        	if( searchConditionVO != null ){
        		param.putAll(searchConditionVO.getColumnValues());
        		param.put("user_id", account.getUsr_id());
        		saveCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new NetworkCostDBDAOCreateDailyHireFromIFTableCSQL(), param, null);
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
	 * DailyHire를 생성한뒤에 단가 관리 Table에 입력한다.
	 *
	 * @param HashMap<String, String> map
	 * @throws DAOException
	 */
	public void modifyDailyHireCreationStatus(HashMap<String, String> map) throws DAOException {

		int saveCnt = 0;

        try{
      		saveCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new NetworkCostDBDAOUpdateDailyHireCreationStatusUSQL(), map, null);
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
     * COA_PORT_TARIFF 데이타를 수정한다.<br>
     *
     * @param  List<SearchPortTariffListVO> removeList
     * @throws DAOException
     */
    public void removePortTariff(List<SearchPortTariffListVO> removeList) throws DAOException {
        int insCnt[] = null;

        try{
            if(removeList.size() > 0){
                insCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new NetworkCostDBDAOMultiPortTariffDSQL(), removeList, null);
                for(int i = 0; i < insCnt.length; i++){
                    if(insCnt[i]== Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to remove No"+ i + " SQL");
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
	 * PSO에서 생성된 Port Tariff Data를 COA로 IF한다<br>
	 * 
	 * @param List<SearchPortTariffListVO> insertVoList
	 * @return int[]
	 * @exception DAOException
	 * @exception Exception
	 */
	public int[] createPortTariffFromPSO(List<SearchPortTariffListVO> insertVoList)  throws DAOException {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(insertVoList .size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new NetworkCostDBDAOCreatePortTariffFromPSOCSQL(), insertVoList,null);
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
     * COA_PORT_TARIFF 목록을 조회한다.
     *
     * @param SearchConditionVO searchConditionVO
     * @return List<SearchPortTariffDetailListVO>
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
	public List<SearchPortTariffDetailListVO> searchPortTariffDetailList(SearchConditionVO searchConditionVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<SearchPortTariffDetailListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
        try{
            if(searchConditionVO == null) return null;

            param.putAll(searchConditionVO.getColumnValues());
            velParam.putAll(searchConditionVO.getColumnValues());
log.debug(searchConditionVO.getColumnValues());
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new NetworkCostDBDAOSearchPortTariffDetailListRSQL(), param, velParam);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchPortTariffDetailListVO.class);
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
     * COA_PORT_TARIFF 데이타를 수정한다.<br>
     *
     * @param  List<SearchPortTariffDetailListVO> modifyList
     * @throws DAOException
     */
    public void modifyPortTariffDetail(List<SearchPortTariffDetailListVO> modifyList) throws DAOException {
        int insCnt[] = null;

        try{
            if(modifyList.size() > 0){
                insCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new NetworkCostDBDAOMultiPortTariffDetailUSQL(), modifyList, null);
                for(int i = 0; i < insCnt.length; i++){
                    if(insCnt[i]== Statement.EXECUTE_FAILED)
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
     * COA_PORT_TARIFF 데이타를 수정한다.<br>
     *
     * @param  List<SearchPortTariffListVO> modifyList
     * @throws DAOException
     */
    public void modifyPortTariff( List<SearchPortTariffListVO> modifyList) throws DAOException {
        int insCnt[] = null;

        try{
            if(modifyList.size()> 0){
                insCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new NetworkCostDBDAOMultiPortTariffUSQL(), modifyList, null);
                for(int i = 0; i < insCnt.length; i++){
                    if(insCnt[i]== Statement.EXECUTE_FAILED)
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
     * COA_PORT_TARIFF 데이타를 삭제한다.<br>
     *
     * @param  List<CoaPortTrfParamVO> deleteList
     * @throws DAOException
     */
    public void deletePortTariff(List<CoaPortTrfParamVO> deleteList) throws DAOException {
        int insCnt[] = null;
        try{
            if(deleteList.size() > 0){
                insCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new NetworkCostDBDAOMultiPortTariffDSQL(), deleteList, null);
                for(int i = 0; i < insCnt.length; i++){
                    if(insCnt[i]== Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to insert No"+ i + " SQL");
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
	 * [Re-Assignment by VVD (Slot Internal Pricing)] 정보를 [조회] 합니다.<br>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @param CommonCoaRsVO commonCoaRsVO
	 * @return CommonCoaRsVO
	 * @exception DAOException
	 * @author SJH.20141028
	 */
	@SuppressWarnings("unchecked")
	public CommonCoaRsVO searchFixCostByVVDSltInterPrcList(SearchConditionVO searchConditionVO, CommonCoaRsVO commonCoaRsVO) throws DAOException {
		DBRowSet dbRowset = null;
		CommonCoaRsVO retVO = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//query parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			param.putAll(searchConditionVO.getColumnValues());
			velParam.putAll(searchConditionVO.getColumnValues());
			
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new NetworkCostDBDAOSearchFixCostByVVDSltInterPrcListRSQL(), param, velParam);
            retVO = new CommonCoaRsVO();
            retVO.setDbRowset(dbRowset);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return retVO;
	}
	/**
	 * [Re-Assignment by VVD (Slot Internal Pricing)] 정보를 [조회] 합니다.<br>
	 * 
	 * @param ProcedureParamVO procedureParamVO
	 * @return ProcedureParamVO
	 * @exception DAOException
	 * @author SJH.20141028
	 */
	@SuppressWarnings("unchecked")
	public ProcedureParamVO createFixCostByVVDSltInterPrc(ProcedureParamVO procedureParamVO) throws DAOException {
		Map<String, Object> resultMap = new HashMap<String, Object>();
    	ProcedureParamVO resultVO = new ProcedureParamVO();
		
		try{
			resultMap = new SQLExecuter("").executeSP((ISQLTemplate)new NetworkCostDBDAOCreateFixCostByVVDSltInterPrcCSQL(), procedureParamVO.getColumnValues(), null);
        	
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
     * ESM_COA_4012 <br>
     * 
     * @param  SearchConditionVO searchVO
     * @return CommonCoaRsVO
     * @throws DAOException
     * @author 20151001.ADD
     */
    public CommonCoaRsVO searchPndlmSvcList(SearchConditionVO searchVO) throws DAOException {
    	DBRowSet dbRowset = null;
        CommonCoaRsVO retVO = null;
        
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
        try{
            if( searchVO != null ) {
            	Map<String, String> mapVO = searchVO.getColumnValues();
				param.putAll(mapVO);				
            	velParam = param;
            	
            	dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new NetworkCostDBDAOPndlmSvcRSQL(), param, velParam);	            
	            retVO = new CommonCoaRsVO();
	            retVO.setDbRowset(dbRowset);
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
        return retVO;
    }
    
    /**
     * ESM_COA_4012 <br>
     * 
     * @param  SearchConditionVO searchVO
     * @param  String pHeader
     * @return CommonCoaRsVO
     * @throws DAOException
     * @author 20151001.ADD
     */	
	public CommonCoaRsVO searchPndlmSvcDtlList(SearchConditionVO searchVO, String pHeader) throws DAOException {
		DBRowSet dbRowset = null;
		CommonCoaRsVO rVo = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();		
		try{
			if(searchVO!= null){
				String tmpStr = pHeader;
		        if(tmpStr.equals("")) tmpStr = " | ";
		        String[] header = tmpStr.split("[|]");
				Map<String, String> mapVO = searchVO.getColumnValues();
				param.putAll(mapVO);
				List<String> aryYdSeq = new ArrayList();   
				for(int i = 0; i < header.length; i++){   
				    aryYdSeq.add(header[i]);   
				}   
				velParam.put("header", aryYdSeq);
				int header_size = header.length-1;
				velParam.put("header_size", header_size);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new NetworkCostDBDAOPndlmSvcDtlRSQL(), param, velParam);
			rVo = new CommonCoaRsVO();
			rVo.setDbRowset(dbRowset);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			log.error("err "+se.toString(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			log.error("err "+ex.toString(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rVo;		
	}	
	
	/**
	 * ESM_COA_4012 <br>
	 * 
	 * @param PndlmSvcVO pndlmSvcVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 * @author 20151001.ADD
	 */
	public int checkPndlmSvcInt(PndlmSvcVO pndlmSvcVO) throws DAOException,Exception {
		int checkCnt = 0;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = pndlmSvcVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			log.debug("=============== param : "+param);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new NetworkCostDBDAOCheckPndlmSvcDtlRSQL(), param, velParam);
            while(dbRowset.next()){
            	checkCnt = dbRowset.getInt(1);
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return checkCnt;
	}	
    
	/**
	 * 멀티 이벤트 처리<br>
	 * ESM_COA_4012 화면에 대한 멀티 이벤트 처리(INSERT)<br>
	 * 
	 * @param List<PndlmSvcVO> pndlmSvcVO
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 * @author 20151001.ADD
	 */
	public int[] multiPndlmSvc(List<PndlmSvcVO> pndlmSvcVO) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(pndlmSvcVO .size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new NetworkCostDBDAOPndlmSvcCSQL(), pndlmSvcVO,null);
				
				if(insCnt != null) {
					for(int i = 0; i < insCnt.length; i++){
						if(insCnt[i]== Statement.EXECUTE_FAILED)
							throw new DAOException("Fail to insert No"+ i + " SQL");
					}						
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
	 * Pendulum Service Setup 정보를 삭제한다.<br>
	 * 
	 * @param List<PndlmSvcVO> delModels
	 * @exception DAOException
	 * @exception Exception 
	 * @author 20151001.ADD
	 */
	public void removePndlmSvc(List<PndlmSvcVO> delModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(delModels.size() > 0){				
				HashMap<String, Object> velParam = new HashMap<String, Object>();	
				delCnt = sqlExe.executeBatch((ISQLTemplate)new NetworkCostDBDAOPndlmSvcDSQL(), delModels, velParam);
				
				if(delCnt != null) {
					for(int i = 0; i < delCnt.length; i++){
						if(delCnt[i]== Statement.EXECUTE_FAILED)
							throw new DAOException("Fail to delete No"+ i + " SQL");
					}						
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}	    
    
	/**
	 * 멀티 이벤트 처리<br>
	 * ESM_COA_4012 화면에 대한 TO_YYYYMMDD 일괄 처리(UPDATE)<br>
	 * 
	 * @param List<PndlmSvcVO> pndlmSvcVO
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 * @author 20151001.ADD
	 */
	public int[] batchUpPndlmSvc(List<PndlmSvcVO> pndlmSvcVO) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(pndlmSvcVO .size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new NetworkCostDBDAOPndlmSvcBatchUSQL(), pndlmSvcVO,null);
				
				if(updCnt != null) {
					for(int i = 0; i < updCnt.length; i++){
						if(updCnt[i]== Statement.EXECUTE_FAILED)
							throw new DAOException("Fail to insert No"+ i + " SQL");
					}						
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
	 * 멀티 이벤트 처리<br>
	 * ESM_COA_4012 화면에 대한 멀티 이벤트 처리(INSERT)<br>
	 * 
	 * @param List<PndlmSvcVO> pndlmSvcVO
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 * @author 20151001.ADD
	 */
	public int[] multiPndlmDtlSvc(List<PndlmSvcVO> pndlmSvcVO) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(pndlmSvcVO .size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new NetworkCostDBDAOPndlmSvcDtlCSQL(), pndlmSvcVO,null);
				
				if(insCnt != null) {
					for(int i = 0; i < insCnt.length; i++){
						if(insCnt[i]== Statement.EXECUTE_FAILED)
							throw new DAOException("Fail to insert No"+ i + " SQL");
					}						
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
	 * Pendulum Service Setup 정보를 삭제한다.<br>
	 * 
	 * @param List<PndlmSvcVO> delModels
	 * @exception DAOException
	 * @exception Exception 
	 * @author 20151001.ADD
	 */		
	public void removePndlmDtlSvc(List<PndlmSvcVO> delModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(delModels.size() > 0){				
				HashMap<String, Object> velParam = new HashMap<String, Object>();	
				delCnt = sqlExe.executeBatch((ISQLTemplate)new NetworkCostDBDAOPndlmSvcDtlDSQL(), delModels, velParam);
				
				if(delCnt != null) {
					for(int i = 0; i < delCnt.length; i++){
						if(delCnt[i]== Statement.EXECUTE_FAILED)
							throw new DAOException("Fail to delete No"+ i + " SQL");
					}						
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}	
	
	
	/**
	 * 멀티 이벤트 처리<br>
	 * ESM_COA_4012 화면에 대한 멀티 이벤트 처리(INSERT)<br>
	 * 
	 * @param PndlmSvcVO vo
	 * @throws DAOException
	 * @author 20151001.ADD
	 */
	public void createPndlmDtlSvc(PndlmSvcVO vo) throws DAOException {
        int insCnt = 0;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            SQLExecuter sqlExe = new SQLExecuter("");
            if(vo != null){
                param.putAll(vo.getColumnValues());
                velParam.putAll(vo.getColumnValues());

                insCnt = sqlExe.executeUpdate((ISQLTemplate)new NetworkCostDBDAOCreatePndlmSvcDtlCSQL(), param, velParam);
                if(insCnt == Statement.EXECUTE_FAILED)
                    throw new DAOException("Fail to createPndlmDtlSvc SQL");
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
	 * ESM_COA_4012  가변헤더를 가져온다.<br>
	 * 
	 * @param SearchConditionVO searchVO
	 * @return DBRowSet
	 * @exception DAOException
	 * @author 20151001.ADD
	 */		
	public DBRowSet searchPndlmSvcDtlHeaderList(SearchConditionVO searchVO) throws DAOException{
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		try{	
			if(searchVO!= null){
				Map<String, String> mapVO = searchVO.getColumnValues();
				param.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new NetworkCostDBDAOPndlmSvcDtlHeadRSQL(), param, null);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}	

}
