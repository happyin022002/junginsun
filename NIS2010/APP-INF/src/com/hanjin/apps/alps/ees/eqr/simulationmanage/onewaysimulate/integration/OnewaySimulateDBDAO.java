/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OnewaySimulateDBDAO.java
*@FileTitle : OnewaySimulate
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.14
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2009.09.14 채창호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.simulationmanage.onewaysimulate.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.ees.eqr.common.Constants;
import com.hanjin.apps.alps.ees.eqr.common.Utils;
import com.hanjin.apps.alps.ees.eqr.common.eqrcommon.vo.CommonVO;
import com.hanjin.apps.alps.ees.eqr.common.vo.CommonRsVO;
import com.hanjin.apps.alps.ees.eqr.simulationmanage.onewaysimulate.basic.OnewaySimulateBCImpl;
import com.hanjin.apps.alps.ees.eqr.simulationmanage.onewaysimulate.vo.EesEqr0010ConditionVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;



/**
 * ALPS OnewaySimulateDBDAO <br>
 * - ALPS-SimulationManage system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Chae Change Ho
 * @see OnewaySimulateBCImpl 참조
 * @since J2EE 1.6
 */
public class OnewaySimulateDBDAO extends DBDAOSupport {


	/**
	 * offer 가 생성이 되었는지 확인을 한다. 
	 * offer 가 생성이 되었으면 생성된 REPO_PLN_ID의 TPSZ 별 총 합을 RETURN을 하고 없으면 
	 * 0을 리턴을 한다. 
	 * 
	 * @param conditionVO EesEqr0010ConditionVO
	 * @return CommonRsVO
	 * @exception DAOException
	*/
	public CommonRsVO searchTotalOneWayOfferExist(EesEqr0010ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		CommonRsVO returnVO = new CommonRsVO();
					
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String repo_pln_id =  Constants.REPO_WORD+conditionVO.getYyyyww()+Constants.REPO_WEEK+conditionVO.getSeq();
		String[] tpszsum  = new String[10];
		String arrFmEccCd = Utils.convertStr(conditionVO.getFmecccd());
		String arrToEccCd = Utils.convertStr(conditionVO.getToecccd());
		String fmType     = conditionVO.getFmtype();
		String toType     = conditionVO.getTotype();
		String tpszCd     = conditionVO.getCntrtpsztype();	
		String fmyrwk     = conditionVO.getFmplnyr() + conditionVO.getFmplnwk();
		String toyrwk     = conditionVO.getToplnyr() + conditionVO.getToplnwk();
		List<String> arrCntrTpsz = Utils.replaceStrToList(conditionVO.getCntrtpsztype());
		String[]  arrTpszCd  = tpszCd.split(",");
	    
		try{
			param.put("repo_pln_id", repo_pln_id);
			param.put("fm_yrwk", fmyrwk);
			param.put("to_yrwk", toyrwk);
			velParam.put("arrtpszcd", arrCntrTpsz);
			velParam.put("fmecccd", arrFmEccCd);
			velParam.put("fmtype", fmType);
			velParam.put("arrfmecccd", arrFmEccCd);
			velParam.put("totype", toType);
			velParam.put("toecccd", arrToEccCd);
			velParam.put("arrtoecccd", arrToEccCd);
	
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OnewaySimulateDBDAOSearchOneWayExistRSQL(), param, velParam);
			while (dbRowset.next()){
				for (int k=0 ; k < arrTpszCd.length  ; k++){
					tpszsum[k]= JSPUtil.getNull(dbRowset.getString("OFFER"+arrTpszCd[k]).trim());
					//log.debug("=============>" + tpszsum[k]);
				}
			}
			returnVO.setResultStrArray(tpszsum);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return returnVO;
	}	
	
    /**
     * offer 가 생성이 되기전 입력된 수량과 실제로 반영되어 보여지는 차를 구한다. 
     *
     * @param conditionVO EesEqr0010ConditionVO
     * @return CommonRsVO
     * @exception DAOException
     */
    public CommonRsVO searchTotalOneWayOfferGap(EesEqr0010ConditionVO conditionVO) throws DAOException {
        DBRowSet dbRowset = null;
        CommonRsVO returnVO = new CommonRsVO();
        
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        //String repo_pln_id =  Constants.REPO_WORD+conditionVO.getYyyyww()+Constants.REPO_WEEK+conditionVO.getSeq();
        String scnr_id = conditionVO.getScnrId();
        String[] tpszsum  = new String[10];
        String arrFmEccCd = Utils.convertStr(conditionVO.getFmecccd());
        String arrToEccCd = Utils.convertStr(conditionVO.getToecccd());
        String fmType     = conditionVO.getFmtype();
        String toType     = conditionVO.getTotype();
        String tpszCd     = conditionVO.getCntrtpsztype();	
        String fmyrwk     = conditionVO.getFmplnyr() + conditionVO.getFmplnwk();
        String toyrwk     = conditionVO.getToplnyr() + conditionVO.getToplnwk();
        List<String> arrCntrTpsz = Utils.replaceStrToList(conditionVO.getCntrtpsztype());
        String[]  arrTpszCd  = tpszCd.split(",");
        
        try{
            //param.put("repo_pln_id", repo_pln_id);
            param.put("scnr_id", scnr_id);
            param.put("fm_yrwk", fmyrwk);
            param.put("to_yrwk", toyrwk);
            velParam.put("arrtpszcd", arrCntrTpsz);
            velParam.put("fmecccd", arrFmEccCd);
            velParam.put("fmtype", fmType);
            velParam.put("arrfmecccd", arrFmEccCd);
            velParam.put("totype", toType);
            velParam.put("toecccd", arrToEccCd);
            velParam.put("arrtoecccd", arrToEccCd);
            
            List<CommonVO> cntrTpSzList = conditionVO.getCntrTpList();
            velParam.put("cntrTpSzList", cntrTpSzList);
            
            
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OnewaySimulateDBDAOSearchOneWayGapRSQL(), param, velParam);
            while (dbRowset.next()){
                for (int k=0 ; k < arrTpszCd.length  ; k++){
                    tpszsum[k]= JSPUtil.getNull(dbRowset.getString("OFF"+arrTpszCd[k]).trim());
                    //log.debug("=============>" + tpszsum[k]);
                }
            }
            returnVO.setResultStrArray(tpszsum);
        } catch(SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch(Exception ex) {
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return returnVO;
    }	
    
    /**
     *각 TPSZ별의 최대값을 구한다. 
     * @param conditionVO EesEqr0010ConditionVO
     * @return CommonRsVO
     * @exception DAOException
     */
    public CommonRsVO searchTotalOneWayOfferMax(EesEqr0010ConditionVO conditionVO) throws DAOException {
        DBRowSet dbRowset = null;
        CommonRsVO returnVO = new CommonRsVO();
        
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        //String repo_pln_id =  Constants.REPO_WORD+conditionVO.getYyyyww()+Constants.REPO_WEEK+conditionVO.getSeq();
        String scnr_id = conditionVO.getScnrId();
        String[] tpszsum  = new String[10];
        String arrFmEccCd = Utils.convertStr(conditionVO.getFmecccd());
        String arrToEccCd = Utils.convertStr(conditionVO.getToecccd());
        String fmType     = conditionVO.getFmtype();
        String toType     = conditionVO.getTotype();
        String tpszCd     = conditionVO.getCntrtpsztype();	
        String fmyrwk     = conditionVO.getFmplnyr() + conditionVO.getFmplnwk();
        String toyrwk     = conditionVO.getToplnyr() + conditionVO.getToplnwk();
        List<String> arrCntrTpsz =  Utils.replaceStrToList(conditionVO.getCntrtpsztype());
        String[]  arrTpszCd  = tpszCd.split(",");
        
        try{
            //param.put("repo_pln_id", repo_pln_id);
            param.put("scnr_id", scnr_id);
            param.put("fm_yrwk", fmyrwk);
            param.put("to_yrwk", toyrwk);
            velParam.put("arrtpszcd", arrCntrTpsz);
            velParam.put("fmecccd", arrFmEccCd);
            velParam.put("fmtype", fmType);
            velParam.put("arrfmecccd", arrFmEccCd);
            velParam.put("totype", toType);
            velParam.put("toecccd", arrToEccCd);
            velParam.put("arrtoecccd", arrToEccCd);
            
            List<CommonVO> cntrTpSzList = conditionVO.getCntrTpList();
            velParam.put("cntrTpSzList", cntrTpSzList);
            
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OnewaySimulateDBDAOSearchOneWayMaxRSQL(), param, velParam);
            while (dbRowset.next()){
                for (int k=0 ; k < arrTpszCd.length  ; k++){
                    tpszsum[k]= JSPUtil.getNull(dbRowset.getString("OFF"+arrTpszCd[k]).trim());
                    //log.debug("=============>" + tpszsum[k]);
                }
            }
            returnVO.setResultStrArray(tpszsum);
        } catch(SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch(Exception ex) {
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return returnVO;
    }	
    
    /**
     * offer 값을 구한다.. 
     * @param conditionVO EesEqr0010ConditionVO
     * @return CommonRsVO
     * @exception DAOException
     */
    public CommonRsVO searchTotalOneWayOffer(EesEqr0010ConditionVO conditionVO) throws DAOException {
        DBRowSet dbRowset = null;
        DBRowSet dbRowset1 = null;
        DBRowSet dbRowset2 = null;
        
        CommonRsVO returnVO = new CommonRsVO();
        
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        String repo_id  ="";
        //String scnr_id_1 ="";
        String repo_id_1 ="";
        String repo_pln_id =  Constants.REPO_WORD+conditionVO.getYyyyww()+Constants.REPO_WEEK+conditionVO.getSeq();
        String scnr_id = conditionVO.getScnrId();
        //String[] tpszsum  = new String[10];
        String arrFmEccCd = Utils.convertStr(conditionVO.getFmecccd());
        String arrToEccCd = Utils.convertStr(conditionVO.getToecccd());
        String fmType     = conditionVO.getFmtype();
        String toType     = conditionVO.getTotype();
        //String tpszCd     = conditionVO.getCntrtpsztype();	
        String fmyrwk     = conditionVO.getFmplnyr() + conditionVO.getFmplnwk();
        String toyrwk     = conditionVO.getToplnyr() + conditionVO.getToplnwk();
        List<String> arrCntrTpsz =  Utils.replaceStrToList(conditionVO.getCntrtpsztype());
        //String[]  arrTpszCd  = tpszCd.split(",");
        
        try{
            param.put("repo_pln_id", repo_pln_id);
            param.put("scnr_id", scnr_id);
            param.put("fm_yrwk", fmyrwk);
            param.put("to_yrwk", toyrwk);
            velParam.put("arrtpszcd", arrCntrTpsz);
            velParam.put("fmecccd", arrFmEccCd);
            velParam.put("fmtype", fmType);
            velParam.put("arrfmecccd", arrFmEccCd);
            velParam.put("totype", toType);
            velParam.put("toecccd", arrToEccCd);
            velParam.put("arrtoecccd", arrToEccCd);
            
            List<CommonVO> cntrTpSzList = conditionVO.getCntrTpList();
            velParam.put("cntrTpSzList", cntrTpSzList);
            
            // repo_pln_id 와 scnr_id을 조회를 한다.
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OnewaySimulateDBDAOSearchRepoPlanIdRSQL(), param, velParam);
            if (dbRowset.next()){
                repo_id = dbRowset.getString("REPO_PLN_ID");
                //scnr_id_1 = dbRowset.getString("SCNR_ID");
            }
            // 해당 repo_pln_id로  oweway offer 테이블에 해당 물량이 있는지 확인을 한다. 
            dbRowset1 = new SQLExecuter("").executeQuery((ISQLTemplate)new OnewaySimulateDBDAOSearchOneWayRepoPlanIdRSQL(), param, velParam);
            
            if (dbRowset1.next()){
                repo_id_1 = dbRowset1.getString("REPO_PLN_ID");
            }
            
            // EQR_EQ_REPO_PLN 과 EQR_ONE_WY_OFFR 의 하나라도 값이 없으면 아래의 내용을 수행을 한다. 
            if(repo_id.equals("") || repo_id_1.equals("")){
                dbRowset2 = new SQLExecuter("").executeQuery((ISQLTemplate)new OnewaySimulateDBDAOSearchOneWayMain01RSQL(), param, velParam);	
            }else {
                dbRowset2 = new SQLExecuter("").executeQuery((ISQLTemplate)new OnewaySimulateDBDAOSearchOneWayMainRSQL(), param, velParam);
            }
            
            returnVO.setDbRowset(dbRowset2);
        
        } catch(SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch(Exception ex) {
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return returnVO;
    }	
    
    /**
     * 해당주의 날짜 개수을 구하는 메소드 
     * @param scnr_id String
     * @param fcast_yrwk String
     * @param fm_ecc_cd String
     * @param to_ecc_cd String
     * @param tpsz_cd String
     * @return int
     * @exception DAOException
     */
    public int searchDailyCount(String scnr_id, String fcast_yrwk, String fm_ecc_cd , String to_ecc_cd , String tpsz_cd) throws DAOException {
        DBRowSet dbRowset = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        int result = 0;
        
        
        try{
            param.put("scnr_id", scnr_id);
            param.put("fcast_yrwk", fcast_yrwk);
            param.put("fm_ecc_cd" , fm_ecc_cd);
            param.put("to_ecc_cd", to_ecc_cd);
            param.put("cntr_tpsz_cd", tpsz_cd);
            
            
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OnewaySimulateDBDAOSearchDailyCountRSQL(), param, velParam);
            if (dbRowset.next()){
                result = dbRowset.getInt("FCAST_COUNT");
            }
            
        } catch(SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch(Exception ex) {
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return result;
    }	
    
    /**
     * 해당주의 Max값을 구하는 메소드
     * @param scnr_id String
     * @param fcast_yrwk String
     * @param fm_ecc_cd String
     * @param to_ecc_cd String
     * @param tpsz_cd String
     * @param dailycount int
     * @param vol int
     * @return int
     * @exception DAOException
     */
    public int searchDailyMax(String scnr_id , String fcast_yrwk, String fm_ecc_cd , String to_ecc_cd , String tpsz_cd  ,int dailycount ,int vol) throws DAOException {
        DBRowSet dbRowset = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        int result = 0;
        
        
        try{
	        param.put("scnr_id", scnr_id);
	        param.put("fcast_yrwk", fcast_yrwk);
	        param.put("fm_ecc_cd" , fm_ecc_cd);
	        param.put("to_ecc_cd", to_ecc_cd);
	        param.put("cntr_tpsz_cd", tpsz_cd);
	        velParam.put("dailycount", dailycount);
	        velParam.put("vol", vol);
	        
	        
	        dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OnewaySimulateDBDAOSearchDailyMaxRSQL(), param, velParam);
	        if (dbRowset.next()){
	        	result = dbRowset.getInt("MAXVALUE");
	        }
	        
	    } catch(SQLException se) {
	    	log.error(se.getMessage(),se);
	    	throw new DAOException(new ErrorHandler(se).getMessage());
	    } catch(Exception ex) {
	    	log.error(ex.getMessage(),ex);
	    	throw new DAOException(new ErrorHandler(ex).getMessage());
	    }
        return result;
    }	

    /**
     * 해당주의 총 VOL값을 구하는 메소드
     * @param scnr_id String
     * @param fcast_yrwk String
     * @param fm_ecc_cd String
     * @param to_ecc_cd String
     * @param tpsz_cd String
     * @param dailycount int
     * @param vol int
     * @return int
     * @exception DAOException
     */
    public int searchDailyGap(String scnr_id , String fcast_yrwk, String fm_ecc_cd , String to_ecc_cd , String tpsz_cd  ,int dailycount ,int vol) throws DAOException {
        DBRowSet dbRowset = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        int result = 0;
        
        
        try{
            param.put("scnr_id", scnr_id);
            param.put("fcast_yrwk", fcast_yrwk);
            param.put("fm_ecc_cd" , fm_ecc_cd);
            param.put("to_ecc_cd", to_ecc_cd);
            param.put("cntr_tpsz_cd", tpsz_cd);
            velParam.put("dailycount", dailycount);
            velParam.put("vol", vol);
            
            
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OnewaySimulateDBDAOSearchDailyGapRSQL(), param, velParam);
            if (dbRowset.next()){
                result = dbRowset.getInt("GAP");
            }
            
        } catch(SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch(Exception ex) {
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return result;
    }	
    
    /**
     * EQR_ONE_WY_OFFR 테이블에 데이터 입력할때 사용할 기초데이터를 EQR_OB_FCAST 에서 조회.<br>
     * 
     * @param param Map<String, Object>
     * @param velparam Map<String, Object>
     * @return CommonRsVO
     * @exception DAOException
     */
    public CommonRsVO earchOneWayOBFcst(Map<String, Object> param , Map<String, Object> velparam) throws DAOException {
        DBRowSet dbRowset = null;
        CommonRsVO returnVO = new CommonRsVO();
        try{
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OnewaySimulateDBDAOSearchOneWayOBFcstRSQL(), param, velparam);
            //list = (List)RowSetUtil.rowSetToVOs(dbRowset, searchKeyRepoPlanInfo .class);
            returnVO.setDbRowset(dbRowset);
        } catch(SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch(Exception ex) {
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return returnVO;
    }
	 
    
    /**
     * EQR_ONE_WY_OFFR 테이블에 데이터 입력.<br>
     * 
     * @param param Map<String, Object>
     * @param velparam Map<String, Object>
     * @exception DAOException
     */
    public void modifyOneWayOffer(Map<String, Object> param , Map<String, Object> velparam) throws DAOException {
        int result = 0;
        try{
            result = new SQLExecuter("").executeUpdate((ISQLTemplate)new OnewaySimulateDBDAOModifyOneWayMaxCSQL(), param, velparam);
            if(result == Statement.EXECUTE_FAILED)
                throw new DAOException("Fail to delete No SQL");
            
        } catch(SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch(Exception ex) {
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
    
    }
    /**
     * 새로 생성된 PLN과 기존 PLN과의 cost 차이를 비교한다.. 
     * @param conditionVO EesEqr0010ConditionVO
     * @return CommonRsVO
     * @exception DAOException
     */
    public CommonRsVO searchOneWayPlanCompare(EesEqr0010ConditionVO conditionVO) throws DAOException {
        DBRowSet dbRowset = null;
        CommonRsVO returnVO = new CommonRsVO();
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        String repo_pln_id =  Constants.REPO_WORD+conditionVO.getYyyyww()+Constants.REPO_WEEK+conditionVO.getSeq();
        String arrFmEccCd = Utils.convertStr(conditionVO.getFmecccd());
        String arrToEccCd = Utils.convertStr(conditionVO.getToecccd());
        String fmType     = conditionVO.getFmtype();
        String toType     = conditionVO.getTotype();
        String tpszCd     = Utils.convertStr(conditionVO.getCntrtpszcd());	
        String fmyrwk     = conditionVO.getFmplnyr() + conditionVO.getFmplnwk();
        String toyrwk     = conditionVO.getToplnyr() + conditionVO.getToplnwk();
        String fmtoyrwk     = conditionVO.getFmtoplnyr() + conditionVO.getFmtoplnwk();
        String totoyrwk     = conditionVO.getTotoplnyr() + conditionVO.getTotoplnwk();
        
        List<String> arrCntrTpsz = Utils.replaceStrToList(conditionVO.getCntrtpszcd());
        try{
            param.put("repo_pln_id", repo_pln_id);
            param.put("new_repo_pln_id", conditionVO.getNewRepoPlan());
            param.put("fm_yrwk", fmyrwk);
            param.put("to_yrwk", toyrwk);
            param.put("fm_to_yrwk", fmtoyrwk);
            param.put("to_to_yrwk", totoyrwk);
            velParam.put("arrtpszcd", arrCntrTpsz);
            velParam.put("fmecccd", arrFmEccCd);
            velParam.put("fmtype", fmType);
            velParam.put("arrfmecccd", arrFmEccCd);
            velParam.put("totype", toType);
            velParam.put("toecccd", arrToEccCd);
            velParam.put("arrtoecccd", arrToEccCd);
            velParam.put("tpszcd", tpszCd);
            velParam.put("arrcntrtpzcd",tpszCd);
            
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OnewaySimulateDBDAOSearchOneWayCompareRSQL(), param, velParam);
            returnVO.setDbRowset(dbRowset);
        } catch(SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch(Exception ex) {
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return returnVO;
    }		 
}