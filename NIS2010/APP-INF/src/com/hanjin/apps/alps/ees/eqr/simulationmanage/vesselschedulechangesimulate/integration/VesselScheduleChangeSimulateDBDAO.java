/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VesselScheduleChangeSimulateDBDAOCreateMultiVesselPlanVesselResidualCapaCSQL.java
*@FileTitle : VesselScheduleChangeSimulateDBDAO.java
*Open Issues : Vessel Schedule 변경 Simulation 조회/수정
*Change history :
*@LastModifyDate : 2009.08.05
*@LastModifier : 정은호
*@LastVersion : 1.0
* 2009.08.05 정은호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.simulationmanage.vesselschedulechangesimulate.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.ees.eqr.simulationmanage.vesselschedulechangesimulate.basic.VesselScheduleChangeSimulateBCImpl;
import com.hanjin.apps.alps.ees.eqr.simulationmanage.vesselschedulechangesimulate.vo.EesEqr0011ConditionVO;
import com.hanjin.apps.alps.ees.eqr.simulationmanage.vesselschedulechangesimulate.vo.SearchVesselPlanCompareVO;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.cntrrepoplanoptiexecute.vo.EesEqr0049ConditionVO;
import com.hanjin.apps.alps.ees.eqr.common.Constants;
import com.hanjin.apps.alps.ees.eqr.common.Utils;
import com.hanjin.apps.alps.ees.eqr.common.eqrcommon.vo.CommonVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.EqrScnrVslSkdVO;


/**
 * ENIS-EQR에 대한 DB 처리를 담당<br>
 * - ENIS-EQR Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author sangyool pak
 * @see VesselScheduleChangeSimulateBCImpl 참조
 * @since J2EE 1.4
 */
public class VesselScheduleChangeSimulateDBDAO extends DBDAOSupport {

    /**
     * ScenarioManage의 모든 목록을 가져온다.<br>
     * @param condiVO EesEqr0011ConditionVO
     * 
     * @return List<SearchVesselPlanCompareVO>
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
	public List<SearchVesselPlanCompareVO> searchVesselPlanCompare(EesEqr0011ConditionVO condiVO) throws DAOException {
    	
       
        DBRowSet dRs = null;
        List<SearchVesselPlanCompareVO> list = null;
        
        // Scenario ID
        String repoPlnId1 = Constants.REPO_WORD + condiVO.getYyyyww() + Constants.REPO_WEEK + condiVO.getSeq();
        String repoPlnId2 = condiVO.getRepoplnid2();	
        
		// Period
		String etbSYrWk = condiVO.getEtbsyr() + condiVO.getEtbswk();
		String etbEYrWk = condiVO.getEtbeyr() + condiVO.getEtbewk();
		// Company
		String coCd     = condiVO.getCocd();
		// Lane
		String   vslSlanCd    = condiVO.getVslslancd();
		List<String> arrVslSlanCd = Utils.replaceStrToList(vslSlanCd);
		// VVD
		String vvd      = condiVO.getVvd();
		List<String> arrVvd = Utils.replaceStrToList(vvd);


        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
        try {
        	param.put("repoPlnId1", repoPlnId1);
    		param.put("etbSYrWk", etbSYrWk);
    		param.put("etbEYrWk", etbEYrWk);
    		param.put("repoPlnId2", repoPlnId2);
    		velParam.put("arrVslSlanCd",arrVslSlanCd);
    		velParam.put("arrVvd",arrVvd);
    		velParam.put("vvd",vvd);
    		velParam.put("vslSlanCd",vslSlanCd);
    		velParam.put("coCd",coCd);
    		dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new VesselScheduleChangeSimulateDBDAOSearchVesselPlanCompareRSQL(), param, velParam);
    		list = (List)RowSetUtil.rowSetToVOs(dRs, SearchVesselPlanCompareVO .class);
           
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch (DAOException de) {
            log.error(de.getMessage(), de);
            throw de;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new DAOException(e.getMessage());
        }
        return list;
    } 
    
    
	/**
	 * @param condiVO	EesEqr0011ConditionVO
	 * @return CommonVO
	 * @exception DAOException
	 */
	public CommonVO searchMaxScnrID(EesEqr0011ConditionVO condiVO) throws DAOException {
		DBRowSet dRs = null;
		CommonVO commonVO = new CommonVO();
		String scnrId = condiVO.getScnrId();		
		String rtScnrId = "";
		//query parameter
        Map<String, Object> param = new HashMap<String, Object>();

		try {
			param.put("scnrId",scnrId);
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new VesselScheduleChangeSimulateDBDAOSearchMaxScnrIDRSQL(), param, null);

			if (dRs.next()) {
				rtScnrId = dRs.getString(1);
			}
			commonVO.setResultString(rtScnrId);
			return commonVO;
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
	}	    
    
    
    /**
     * ScenarioManage의 데이타 모델에 해당되는 값을 불러온다.<br>
     * @param condiVO	EesEqr0011ConditionVO
     * @param userId	String
     * @param maxScnrId	String
     * @exception DAOException
     */
    public void createNewVesselPlan(EesEqr0011ConditionVO condiVO, String userId, String maxScnrId) throws DAOException {    	

		//query parameter
        Map<String, Object> param = new HashMap<String, Object>();
		//query parameter
        Map<String, Object> param2 = new HashMap<String, Object>();				
	   
		try {
			SQLExecuter sQLExecuter = new SQLExecuter("");
			param.put("maxScnrId", maxScnrId);
			param.put("scnr_rmk", "Manual Creation");
			param.put("userId", userId);
			
			sQLExecuter.executeUpdate((ISQLTemplate)new VesselScheduleChangeSimulateDBDAOCreateNewVesselScnrMasterCSQL(), param, null);			

			param2.put("maxScnrId", maxScnrId);
			param2.put("scnr_id", condiVO.getScnrId());
			param2.put("userId", userId);
			
			sQLExecuter.executeUpdate((ISQLTemplate)new VesselScheduleChangeSimulateDBDAOCreateNewVesselScnVesselScheduleCSQL(), param2, null);
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
    }    
    
	 /**
	 * @param condiVO	EesEqr0011ConditionVO
	 * @param vos		EqrScnrVslSkdVO[]
	 * @param usrId		String
	 * @param maxScnrId	String
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public void multiVesselPlan(EesEqr0011ConditionVO condiVO ,EqrScnrVslSkdVO[] vos, String usrId, String maxScnrId) throws DAOException {
		boolean isInsert = false ;
		boolean isInsert1 = false;  
        boolean isUpdate = false;	        
        boolean isDelete = false;   

        int insCnt[] = null;
        int insCnt1[] = null;
        int updCnt[] = null;
        int delCnt[] = null;

	        try {
	        	SQLExecuter sqlExe = new SQLExecuter("");
				List insModels 	= new ArrayList();
				List ins1Models = new ArrayList();
				List updModels 	= new ArrayList();
				List delModels 	= new ArrayList();
				
	            for(int i = 0 ; i < vos.length ; i++){
	            	EqrScnrVslSkdVO vo = vos[i];
	            	if(vo.getIbflag() == null){
						vo.setIbflag("");
					}
	            	if(vo.getIbflag().length() > 0){
	            		if (vo.getIbflag().equals("I")) {
	            			isInsert = true;
	            			HashMap<String, String> param = new HashMap<String, String>();
	            			param.putAll(vo.getColumnValues());
	        				param.put("maxScnrId", maxScnrId); 
	        				param.put("usrId", usrId); 
	        				insModels.add(param);
	        				
	        				isInsert1 = true;
	        				HashMap<String, String> param1 = new HashMap<String, String>();
	        				param1.putAll(vo.getColumnValues());
	        				param1.put("maxScnrId", maxScnrId); 
	        				param1.put("usrId", usrId); 
	        				param1.put("co_cd", "H"); // company code 하드코딩
	        				ins1Models.add(param1);
	        				
	            		}else if (vo.getIbflag().equals("U")) {
	            			isUpdate = true;	      
	            			HashMap<String, String> param = new HashMap<String, String>();
	            			param.putAll(vo.getColumnValues());
	        				param.put("maxScnrId", maxScnrId); 
	        				param.put("usrId", usrId); 
	        				updModels.add(param);
	            		}else if (vo.getIbflag().equals("D")) {
	            			isDelete = true ;	
	            			HashMap<String, String> param = new HashMap<String, String>();
	            			param.putAll(vo.getColumnValues());
	        				param.put("maxScnrId", maxScnrId); 
	        				param.put("usrId", usrId); 
	        				delModels.add(param);
	            		}
	            	}
	            }
	            if(vos.length > 0){
					if(isInsert){
						insCnt = sqlExe.executeBatch((ISQLTemplate)new VesselScheduleChangeSimulateDBDAOCreateMultiVesselPlanVesselScheduleCSQL(), insModels,null);
						for(int i = 0; i < insCnt.length; i++){
							if(insCnt[i]== Statement.EXECUTE_FAILED)
								throw new DAOException("Fail to insert No"+ i + " SQL");
						}
					}
					if(isInsert1){
						insCnt1 = sqlExe.executeBatch((ISQLTemplate)new VesselScheduleChangeSimulateDBDAOCreateMultiVesselPlanVesselResidualCapaCSQL(), ins1Models,null);
						for(int i = 0; i < insCnt1.length; i++){
							if(insCnt1[i]== Statement.EXECUTE_FAILED)
								throw new DAOException("Fail to insert No"+ i + " SQL");
						}
					}
					if(isUpdate){
						updCnt = sqlExe.executeBatch((ISQLTemplate)new VesselScheduleChangeSimulateDBDAOUpdateMultiVesselPlanVesselScheduleUSQL(), updModels,null);
						for(int i = 0; i < updCnt.length; i++){
							if(updCnt[i]== Statement.EXECUTE_FAILED)
								throw new DAOException("Fail to insert No"+ i + " SQL");
						}
					}
					if(isDelete){
						delCnt = sqlExe.executeBatch((ISQLTemplate)new VesselScheduleChangeSimulateDBDAODeleteMultiVesselPlanVesselScheduleDSQL(), delModels,null);
						for(int i = 0; i < delCnt.length; i++){
							if(delCnt[i]== Statement.EXECUTE_FAILED)
								throw new DAOException("Fail to insert No"+ i + " SQL");
						}
					}
				}
						
						
	        } catch (SQLException se) {
	            log.error(se.getMessage(),se);
	            throw new DAOException(new ErrorHandler(se).getMessage());
	        } catch (DAOException de) {
	            log.error(de.getMessage(),de);
	            throw de;
	        } catch (Exception e) {
	            log.error(e.getMessage(),e);
	            throw new DAOException(e.getMessage());
	        }
	    }    
	 
	/**
	 * simulation에 맞는 새로운 시나리오 생성 이벤트 처리<br>
	 * 
	 * @param conditionVO	EesEqr0049ConditionVO
	 * @param usrId		String
	 * @exception DAOException
	*/
	@SuppressWarnings("unchecked")
	public void reRunVesselPlan(EesEqr0049ConditionVO conditionVO, String usrId) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		Map resultMap = null;
		String resultNo = null;

		try{
			param.put("new_scnr_id", conditionVO.getScnrid());
			param.put("old_scnr_id", conditionVO.getOld_scnr_id());
			param.put("in_user_id", usrId);
			param.put("out_result_no", "");
			resultMap = new SQLExecuter("").executeSP((ISQLTemplate)new VesselScheduleChangeSimulateDBDAOReRunVesselPlanCSQL(), param, velParam);
			resultNo = (String) resultMap.get("out_result_no");
			
			if ("99".equals(resultNo)) {
				throw new DAOException("Fail to EQR_COPY_REPO_PLAN_PRC! Result No : "+ resultNo);
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