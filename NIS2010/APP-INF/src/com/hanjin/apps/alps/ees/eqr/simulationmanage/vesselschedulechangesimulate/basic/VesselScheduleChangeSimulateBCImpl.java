/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VesselScheduleChangeSimulateBCImpl.java
*@FileTitle : Vessel Schedule 변경 Simulation 조회/수정 
*Open Issues :
*Change history :
*@LastModifyDate : 2009-08-04
*@LastModifier : ChungEunHo
*@LastVersion : 1.0
* 2009-08-04 ChungEunHo
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.simulationmanage.vesselschedulechangesimulate.basic;

import java.util.List;

import com.hanjin.apps.alps.ees.eqr.common.Constants;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.cntrrepoplanoptiexecute.basic.CntrRepoPlanOptiExecuteBCImpl;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.cntrrepoplanoptiexecute.vo.EesEqr0049ConditionVO;
import com.hanjin.apps.alps.ees.eqr.simulationmanage.vesselschedulechangesimulate.integration.VesselScheduleChangeSimulateDBDAO;
import com.hanjin.apps.alps.ees.eqr.simulationmanage.vesselschedulechangesimulate.vo.EesEqr0011ConditionVO;
import com.hanjin.apps.alps.ees.eqr.simulationmanage.vesselschedulechangesimulate.vo.SearchVesselPlanCompareVO;
import com.hanjin.framework.component.backend.core.BackEndJobManager;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.EqrScnrVslSkdVO;



/**
 * ALPS-VesselScheduleChangeSimulate Business Logic Basic Command implementation<br>
 * - ALPS-VesselScheduleChangeSimulate에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author 정은호
 * @see SearchVesselPlanCompareVO ,VesselScheduleChangeSimulateBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class VesselScheduleChangeSimulateBCImpl   extends BasicCommandSupport implements VesselScheduleChangeSimulateBC {

	// Database Access Object
	private transient VesselScheduleChangeSimulateDBDAO dbDao=null;
	
	/**
	 * VesselScheduleChangeSimulateBCImpl 객체 생성<br>
	 * VesselScheduleChangeSimulateDBDAO를 생성한다.<br>
	 */
	public VesselScheduleChangeSimulateBCImpl(){
		dbDao = new VesselScheduleChangeSimulateDBDAO();
	}


    /**
     * 조회 이벤트 처리<br>
     * EES_EQR_0097 화면에 대한 조회 이벤트 처리<br>
     * 
     * @param condiVO	EesEqr0011ConditionVO
     * @return List<SearchVesselPlanCompareVO>
     * @exception EventException
     */
    public List<SearchVesselPlanCompareVO> searchVesselPlanCompare(EesEqr0011ConditionVO condiVO) throws EventException {
        
    	List<SearchVesselPlanCompareVO> list = null;
        
        try {
        	list=dbDao.searchVesselPlanCompare(condiVO);
            return list;
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }
    }
    
    /**
     * 멀티 이벤트 처리<br>
     * EES_EQR_011 화면에 대한 멀티 이벤트 처리<br>
     * 
     * @param condiVO	EesEqr0011ConditionVO
     * @param vos		EqrScnrVslSkdVO[]
     * @param account	SignOnUserAccount
     * @exception EventException
     */
    public void createNewVesselPlan(EesEqr0011ConditionVO condiVO ,EqrScnrVslSkdVO[] vos , SignOnUserAccount account) throws EventException{
        // PDTO(Data Transfer Object including Parameters)
        
        String userId = account.getUsr_id(); // user id information
        String maxScnrId = "";
        String newScnrId = condiVO.getNewscnrid();

        try {
        	if(newScnrId.equals("")) {
	        	maxScnrId = dbDao.searchMaxScnrID(condiVO).getResultString();
	            dbDao.createNewVesselPlan(condiVO, userId, maxScnrId);
	            dbDao.multiVesselPlan(condiVO , vos, userId, maxScnrId);
	            condiVO.setNewscnrid(maxScnrId);
        	} else {
        		dbDao.multiVesselPlan(condiVO ,vos, userId, newScnrId);
        	}
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }
    }    
       

    
    /**
     * 멀티 이벤트 처리<br>
     * EES_EQR_0011 화면에 대한 멀티 이벤트 처리<br>
     * 
     * @param condiVO		EesEqr0011ConditionVO
     * @param repoPlanId	String
     * @param account		SignOnUserAccount
     * @exception EventException
     */
    public void reRunCallJMS(EesEqr0011ConditionVO condiVO , String repoPlanId, SignOnUserAccount account) throws EventException{
       
        CntrRepoPlanOptiExecuteBCImpl cntrRepoPlanOptiExecuteImpl = new CntrRepoPlanOptiExecuteBCImpl();
        VesselScheduleChangeSimulateBackEndJob vesselScheduleChangeSimulateBJ = new VesselScheduleChangeSimulateBackEndJob();
    	
        
        try {
        	cntrRepoPlanOptiExecuteImpl.selectEnginCheck();									    // 현재 RUNNING 하는 엔진의 있는 지 체크			
		    String seq               = repoPlanId.substring(11,14);
		    
		  //------------------------------------------------
			String sendStr = "";
			sendStr = sendStr + "newScrnid" + ":" + condiVO.getNewscnrid() + "|";
			sendStr = sendStr + "sim_pln_id" + ":" + Constants.REPO_WORD + condiVO.getYyyyww2() + Constants.REPO_WEEK + condiVO.getSeq2() + "|";
			sendStr = sendStr + "user_id" + ":" + account.getUsr_id()+ "|";
			sendStr = sendStr + "yyyyww"  + ":" + condiVO.getYyyyww2()+ "|";
			sendStr = sendStr + "scnrId"  + ":" + condiVO.getScnrId()  + "|";
			sendStr = sendStr + "uiname"  + ":" + "EES_EQR_0011";
			//------------------------------------------------
			
			vesselScheduleChangeSimulateBJ.setParamString(sendStr);
			
			BackEndJobManager backEndJobManager = new BackEndJobManager();
			String key = backEndJobManager.execute(vesselScheduleChangeSimulateBJ, account.getUsr_id(),"EQR_0011_RERUN");
	        log.debug("호출 아이디 ====>" + key);
		
			//eaiDao.send0011ReRunSteve(condiVO,account.getUsr_id());    //JMS 호출 
            log.debug("\n event049.getRun_id_no(): " + repoPlanId.substring(4,10)+seq);
            condiVO.setRunIdNo(repoPlanId.substring(4,10)+seq);
        } 
//        catch (DAOException de) {
//            log.error("err "+de.toString(),de);
//            throw new EventException(de.getMessage());
//        }
        catch (Exception de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }
    }


    /**
     * 멀티 이벤트 처리<br>
     * EES_EQR_0011 화면에 대한 멀티 이벤트 처리<br>
     * 
     * @param condiVO	EesEqr0049ConditionVO
     * @param userid	String
     * @exception EventException
     */
    public void reRunVesselPlan(EesEqr0049ConditionVO condiVO , String userid) throws EventException{
        
        try {
        	dbDao.reRunVesselPlan(condiVO,userid);    
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }catch (Exception de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }
    }
   
	/**
	 * EQR 업무 시나리오 마감작업<br>
	 * VesselScheduleChangeSimulate업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		dbDao = null;
	}
}