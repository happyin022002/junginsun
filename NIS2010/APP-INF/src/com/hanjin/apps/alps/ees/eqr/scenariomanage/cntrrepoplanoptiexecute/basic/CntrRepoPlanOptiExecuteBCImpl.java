/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CntrRepoPlanOptiExecuteBCImpl.java
*@FileTitle : run_optimizer
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.28
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2009.07.28 채창호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.scenariomanage.cntrrepoplanoptiexecute.basic;

import java.util.HashMap;
import com.hanjin.apps.alps.ees.eqr.common.Constants;
import com.hanjin.apps.alps.ees.eqr.common.Utils;
import com.hanjin.apps.alps.ees.eqr.common.vo.CommonRsVO;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.cntrrepoplanoptiexecute.event.EesEqr0050Event;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.cntrrepoplanoptiexecute.integration.CntrRepoPlanOptiExecuteDBDAO;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.cntrrepoplanoptiexecute.vo.CntrRepoPlanOptiExecuteRsVO;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.cntrrepoplanoptiexecute.vo.EesEqr0049ConditionVO;
import com.hanjin.framework.component.backend.core.BackEndJobManager;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;


/**
 * ALPS-CntrRepoPlanOptiExecute Business Logic Basic Command implementation<br>
 * - ALPS-CntrRepoPlanOptiExecute에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Chae Change Ho
 * @see EES_EQR_0049EventResponse,CntrRepoPlanOptiExecuteBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class CntrRepoPlanOptiExecuteBCImpl extends BasicCommandSupport implements CntrRepoPlanOptiExecuteBC {

	// Database Access Object
	private transient CntrRepoPlanOptiExecuteDBDAO dbDao = null;
	
	/**
	 * CntrRepoPlanOptiExecuteBCImpl 객체 생성<br>
	 * CntrRepoPlanOptiExecuteDBDAO를 생성한다.<br>
	 */
	public CntrRepoPlanOptiExecuteBCImpl() {
		dbDao = new CntrRepoPlanOptiExecuteDBDAO();
	}
	
	/**
	 * 시나리오 List를 조회.<br>
	 * 
	 * @param eesEqr0049ConditionVO EesEqr0049ConditionVO
	 * @return CntrRepoPlanOptiExecuteRsVO
	 * @exception EventException
	 */
	public CntrRepoPlanOptiExecuteRsVO searchScenarioList(EesEqr0049ConditionVO eesEqr0049ConditionVO) throws EventException {
		try {
			return dbDao.searchScenarioList(eesEqr0049ConditionVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
	/**
	 * 엔진 running 개수 체크 .<br>
	 * 0049 화면에서 사용 
	 * @exception EventException
	 */
	public void selectEnginCheck() throws EventException{
		String run_sts_cd ="START";
		String run_sts_cd1 ="RUNNING";
		int runing_count = 0;
		int runing_count1 = 0;
		try {
			//동시에 1개 이상의 START를 표시를 하지 못하게 메세지경고 메세지를 뜨워줌
			 CntrRepoPlanOptiExecuteRsVO rsVO	= dbDao.selectEnginCheck(run_sts_cd);
			 DBRowSet rowSet  = rsVO.getDbRowset();
			 if(rowSet.next()){
				runing_count = rowSet.getInt(1); 
			 }
			 if (runing_count >0){
				 throw new DAOException(new ErrorHandler("EQR10029").getMessage());
			 }
			 
			//동시에 2개 이상의 엔진 running이 안되게 경고 메세지를 띄워줌
			 CntrRepoPlanOptiExecuteRsVO rsVO1	= dbDao.selectEnginCheck(run_sts_cd1);
			 DBRowSet rowSet1  = rsVO1.getDbRowset();
			 
			 if(rowSet1.next()){
					runing_count1 = rowSet1.getInt(1); 
			  }
			 if (runing_count1 >0){
					 throw new DAOException(new ErrorHandler("EQR10029").getMessage());
			 }
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param eesEqr0049ConditionVO EesEqr0049ConditionVO
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public CommonRsVO searchMaxPlanID(EesEqr0049ConditionVO eesEqr0049ConditionVO) throws EventException {
		try {
			return dbDao.searchMaxPlanID(eesEqr0049ConditionVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
	/**
	 * Multi 이벤트 처리<br>
	 *  Scenariodefaultmanage화면에 대한 조회 이벤트 처리<br>
	 *  
	 * @param eesEqr0049ConditionVO EesEqr0049ConditionVO
	 * @param weekStdt String
	 * @param userId String
	 * @exception EventException
	 */
	public void createRepoPlanRunOptimizer(EesEqr0049ConditionVO eesEqr0049ConditionVO,String weekStdt, String userId) throws EventException{
		String inclu_onh_flg ="";
		String inclu_offh_flg ="";
		String repo_auto_gen_flg ="";
		String sold_flg ="";
		String repo_pln_rmk ="";
		try {
			//String repo_pln_id       = eesEqr0049ConditionVO.getRepo_plan_id();
			
				
			if(eesEqr0049ConditionVO.getInclu_onh_flg().equals("")) {
				inclu_onh_flg = "N";
			} else {
				inclu_onh_flg = "Y";
			}
			if(eesEqr0049ConditionVO.getInclu_offh_flg().equals("")) {
				inclu_offh_flg = "N";
			} else {
				inclu_offh_flg = "Y";
			}
			if(eesEqr0049ConditionVO.getRepo_auto_gen_flg().equals("")) {
				repo_auto_gen_flg = "N";
			} else {
				repo_auto_gen_flg = "Y";
			}	
			// sold_flg = eesEqr0049ConditionVO.getSold_flg();
			if(eesEqr0049ConditionVO.getSold_flg().equals("")) {
				sold_flg = "N";
			} else {
				sold_flg = "Y";
			}			
			
			// 일반 REPO_PLN을 생성시키기 환경에서 rnning 시킬때 
			if(eesEqr0049ConditionVO.getRepo_pln_rmk().equals("R")) {
				repo_pln_rmk = Constants.RUN_RUOP;
			}
			// Change vessel 스케즐 화면에서 엔진을 running 시킬때 
		    if(eesEqr0049ConditionVO.getRepo_pln_rmk().equals("V")) {
		    	repo_pln_rmk = Constants.RUN_VESL;
		    }
		    // ONE Way off로 엔진을 돌리려고 할때 
		    if(eesEqr0049ConditionVO.getRepo_pln_rmk().equals("O")) {
		    	repo_pln_rmk = Constants.RUN_ONOF;
		    }
		    
		    // 민감도로 엔진을 돌리려고 할때 
		    if(eesEqr0049ConditionVO.getRepo_pln_rmk().equals("S")) {
		    	repo_pln_rmk = Constants.RUN_SENS;
		    }
		    //String run_id   = repo_pln_id.substring(4,10) + repo_pln_id.substring(11,14);
			//String duration = eesEqr0049ConditionVO.getDuration();
		    // 사용하지 않는 변수 삭제 modify By ChungEunHo 09.10.16
		    
		   
		    // EQR_EQ_REPO_PLN 테이블에 Insert를 한다.
			dbDao.insertRepoPlanId(eesEqr0049ConditionVO, inclu_onh_flg , inclu_offh_flg ,repo_auto_gen_flg ,sold_flg ,repo_pln_rmk ,userId);
			// EQR_ENG_INP_OPMZ_RUN 테이블에 Insert를 한다.
			dbDao.insertEqrEngRun(eesEqr0049ConditionVO,  weekStdt ,inclu_onh_flg , inclu_offh_flg ,repo_auto_gen_flg ,sold_flg ,repo_pln_rmk ,userId);
		} catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	
	/**
	 * Multi 이벤트 처리<br>
	 *  Scenariodefaultmanage화면에 대한 조회 이벤트 처리<br>
	 *  
	 * @param eesEqr0049ConditionVO EesEqr0049ConditionVO
	 * @exception EventException
	 */
	public void deleteRepoPlanRunOptimizer(EesEqr0049ConditionVO eesEqr0049ConditionVO) throws EventException{
		try {
			String repo_pln_id       = eesEqr0049ConditionVO.getRepo_plan_id();
			//String seq               = repo_pln_id.substring(11,14);
	  	    String run_id           = repo_pln_id.substring(4,10) + repo_pln_id.substring(11,14);
			
		    // EQR_EQ_REPO_PLN 테이블에 DELETE를 한다.
			dbDao.deleteRepoPlanId(repo_pln_id);
			// EQR_ENG_INP_OPMZ_RUN 테이블에 DELETE를 한다.
			dbDao.deleteEqrEngRun(run_id);
		
		} catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * Multi 이벤트 처리<br>
	 *  JMS 호출을 이벤트 처리<br>
	 *  
	 * @param eesEqr0049ConditionVO EesEqr0049ConditionVO
	 * @param userid String
	 * @exception EventException
	 */
	public void send0049ReRunSteve(EesEqr0049ConditionVO eesEqr0049ConditionVO ,String userid) throws EventException{
		try {
			
			
			CntrRepoPlanOptiExecuteBackEndJob cntrRepoPlanOptiExecuteBJ = new CntrRepoPlanOptiExecuteBackEndJob();
			
			/*
			 * 전달하는 파라메터로 String을 만든다. 
			 */
			String sendStr = "";
			sendStr = sendStr + "oldScrnid" + ":" + Constants.SCNR_WORD + eesEqr0049ConditionVO.getScnrYrWk() + Constants.SCNR_WEEK + eesEqr0049ConditionVO.getScnrSeq() + "|";
			sendStr = sendStr + "sim_pln_id" + ":" + eesEqr0049ConditionVO.getRepo_plan_id() + "|";
			sendStr = sendStr + "user_id" + ":" + userid+ "|";
			sendStr = sendStr + "yyyyww"  + ":" + eesEqr0049ConditionVO.getScnrYrWk()+ "|";
			sendStr = sendStr + "repo_pln_rmk" + ":" + eesEqr0049ConditionVO.getRepo_pln_rmk() + "|";
			sendStr = sendStr + "run_id_no" + ":" + eesEqr0049ConditionVO.getRun_id_no() + "|";
			sendStr = sendStr + "scnrId"  + ":" + Constants.SCNR_WORD + eesEqr0049ConditionVO.getScnrYrWk() + Constants.SCNR_WEEK + eesEqr0049ConditionVO.getScnrSeq() + "|";
			sendStr = sendStr + "uiname"  + ":" + "EES_EQR_0049";
			//------------------------------------------------
		
			cntrRepoPlanOptiExecuteBJ.setParamString(sendStr);
			
			BackEndJobManager backEndJobManager = new BackEndJobManager();
			String key = backEndJobManager.execute(cntrRepoPlanOptiExecuteBJ, userid ,"EQR_OPTIMIZATION_RUN");
		    // JMS로 제어권을 넘겨 주기위해 EAIDAO를 호출한다.
			//eaiDao.send0049ReRunSteve(eesEqr0049ConditionVO ,userid);
		    log.debug("=======호출 번호:" + key);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * Multi 이벤트 처리<br>
	 *  Scenariodefaultmanage화면에 대한 조회 이벤트 처리<br>
	 *  
	 * @param eesEqr0049ConditionVO EesEqr0049ConditionVO
	 * @param weekStdt String
	 * @exception EventException
	 */	
	public void enginRunOptimizer(EesEqr0049ConditionVO eesEqr0049ConditionVO ,String weekStdt) throws EventException{
		try {
			String userId   = eesEqr0049ConditionVO.getUser_id();
	    	String flg_name = eesEqr0049ConditionVO.getRepo_pln_rmk();
			
	   
    		if (flg_name.equals("V")){
    			createRepoPlanRunOptimizer(eesEqr0049ConditionVO, weekStdt, userId);			// eqr_eq_repo_pln, eqr_eng_inp_opmz_run insert
    		} else if ( flg_name.equals("S")){
    			//dbDao.createNewScenarioID_1(eesEqr0049ConditionVO ,userId);
    			createRepoPlanRunOptimizer(eesEqr0049ConditionVO, weekStdt, userId);	// eqr_eq_repo_pln, eqr_eng_inp_opmz_run insert
    		}
	        dbDao.createEqrIfRepoPlanPrcExecute(eesEqr0049ConditionVO , userId);  // EQR_IF_REPO_PLAN_PRC procedures 호출
		} catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * EES_EQR_050화면에 대한 조회 이벤트 처리<br>
	 * @param eesEqr0050Event EesEqr0050Event
	 * @param account SignOnUserAccount
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public CommonRsVO searchMonitor(EesEqr0050Event eesEqr0050Event ,SignOnUserAccount account ) throws EventException {
		
		CommonRsVO rsVO = null;
		
		String run_id_no  = eesEqr0050Event.getRunIdNo();
		String percntage  = eesEqr0050Event.getPercentage();
		String cancel     = eesEqr0050Event.getCancel();
		String userId     = account.getUsr_id(); 	// user id information
		CntrRepoPlanOptiExecuteBackEndJob cntrRepoPlanOptiExecuteBJ = new CntrRepoPlanOptiExecuteBackEndJob();
		
		try {
			 if(percntage.equals("70")) {
    			 dbDao.updateEqrEngOutPut(run_id_no); // COMPLETE 시 70%에서 80%로 UPDATE (한번만 수행을 시키기 위해서)
    			
    			    /*
    				 * 전달하는 파라메터로 String을 만든다. 
    				 */
    				String sendStr = "";
    				sendStr = sendStr + "run_id_no" + ":" + eesEqr0050Event.getRunIdNo() + "|";
    				sendStr = sendStr + "user_id" + ":" + userId + "|";
    				sendStr = sendStr + "uiname"  + ":" +"EES_EQR_0050";
    				//------------------------------------------------
    				cntrRepoPlanOptiExecuteBJ.setParamString(sendStr);
    				
    				BackEndJobManager backEndJobManager = new BackEndJobManager();
    				String key = backEndJobManager.execute(cntrRepoPlanOptiExecuteBJ, userId ,"EQR_OUTPUT_RUN");
    			
    		        log.debug("===호출번호:"+ key);		
    			// eaiDao.send0050OutSteve(eesEqr0050Event, userId); // 프로시져 호출을 위한 JMS 호출 메소드
    			 		
     		 }
			 if(cancel.equals("Y")) {
    			 dbDao.updateEqrEngCancel(eesEqr0050Event.getRunIdNo() , eesEqr0050Event.getCancel());
    		 }
			 rsVO = dbDao.searchMonitor(run_id_no, cancel);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		  return rsVO;
	}

	/**
	 * OUT_PUT procedures 호출<br>
	 * JMS Proxy 제어권을 받아오는 메소드<br> 
	 * @param str String
	 * @exception EventException
	 */
	public void enginOutput(String str) throws EventException {
	 	//PDTO(Data Transfer Object including Parameters)
        HashMap<String,String> hm = Utils.createMap(str); 
        
        String run_id_no   = (String)hm.get("run_id_no");
        String repo_pln_id = Constants.REPO_WORD + run_id_no.substring(0,6) + Constants.REPO_WEEK + run_id_no.substring(6,9);
        String user_id     = (String)hm.get("user_id");
	    
		try {
			dbDao.createEqrEngOutPutRepoPrc(run_id_no,repo_pln_id,user_id);
			
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}

	}

	/**
	 * [ EES_EQR_0127 : Scenario Copy Monitoring ]<br>
	 * 
	 * @param scnr_id String
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public CommonRsVO scnrCopysearchMonitor (String scnr_id) throws EventException {
		try {
			return dbDao.scnrCopysearchMonitor (scnr_id);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
}
