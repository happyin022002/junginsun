/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VesselScheduleChangeSimulateBackEndJob.java
*@FileTitle : Vessel Schedule 변경 Simulation 조회/수정
*Open Issues : 기존 JMS 호출부분을 backEndJob으로 변경 하여 반영된 java 
*Change history :
*@LastModifyDate : 2010.01.19
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2009.09.14 채창호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.simulationmanage.vesselschedulechangesimulate.basic;

import java.util.HashMap;

import com.hanjin.apps.alps.ees.eqr.common.Utils;
import com.hanjin.apps.alps.ees.eqr.common.eqrcommon.basic.CommonBCImpl;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.cntrrepoplanoptiexecute.basic.CntrRepoPlanOptiExecuteBC;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.cntrrepoplanoptiexecute.basic.CntrRepoPlanOptiExecuteBCImpl;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.cntrrepoplanoptiexecute.vo.EesEqr0049ConditionVO;
import com.hanjin.apps.alps.ees.eqr.simulationmanage.vesselschedulechangesimulate.vo.SearchVesselPlanCompareVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.layer.backend.BackEndCommandSupport;

/**
 * ALPS-VesselScheduleChangeSimulate Business Logic Basic Command implementation<br>
 * - ALPS-VesselScheduleChangeSimulate에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author 정은호
 * @see SearchVesselPlanCompareVO ,VesselScheduleChangeSimulateBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class VesselScheduleChangeSimulateBackEndJob extends BackEndCommandSupport{


	// parameter ( 넘겨주는 파라메너 xml 또는 String )
	String paramString = "";
	
	/**
	 * parameter get 
	 * @return String  
	 */
	public String getParamString() {
		return paramString;
	}

	/**
	 * parameter set 
	 * @param paramString
	 */
	public void setParamString(String paramString) {
		this.paramString = paramString;
	}

	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = 8226210199438116006L;

	/**
	 * doStart
	 * @return null 
	 */
	public Object doStart() throws Exception {
		
//		if( log.isDebugEnabled())
//		{
//			log.debug("\n\n==> " + paramString );
//		}
		HashMap<String,String> hm = Utils.createMap(paramString);
		// EES_EQR_0011을 호출했을때 
		EesEqr0049ConditionVO condiVO049 = new EesEqr0049ConditionVO();
       // HashMap<String,String> hm = Utils.createMap(str);
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        
        String newScnrId  =(String)hm.get("newScrnid");
        String repoPlanId = "";
        String sim_pln_id = (String)hm.get("sim_pln_id");
        String repo_pln_dtrb_flg     = "N";
        String repo_pln_auto_gen_flg = "N";
        String[] old_repo_id_type = null;
        String[] st_end_between_yearwk = null;
        String userId = (String)hm.get("user_id");   // user id information
        String st_year               = "";
        String st_month              = "";
        String st_weekly             = "";
        String end_year              = "";
        String end_month             = "";
        String end_weekly            = "";
        String weekStdt              = "";
        
        CntrRepoPlanOptiExecuteBC cntrRepoPlanOptiExecuteImpl = new CntrRepoPlanOptiExecuteBCImpl();
        CommonBCImpl commonImpl = new CommonBCImpl();
        VesselScheduleChangeSimulateBC command  = new VesselScheduleChangeSimulateBCImpl();
        
        try {
        	cntrRepoPlanOptiExecuteImpl.selectEnginCheck();									    // 현재 RUNNING 하는 엔진의 있는 지 체크
			repoPlanId            = commonImpl.createNewRepoPlanId(sim_pln_id).getResultString();  				// 새로운 repo_plan_id을 생성한다.
			old_repo_id_type      = commonImpl.searchOldRepoPlantype(sim_pln_id).getResultStrArray();   			// 과거 repo_pln_id 의 속성을 가져온다.
			st_end_between_yearwk = commonImpl.weewklyConvertMonth((String)hm.get("yyyyww") , 16).getResultStrArray();   	// 해당 주 16주에 대한 시작 , 끝나는 주차 년 월 주차를 가져 온다.
			
			
			// 기존 주차를 기준으로 해서 시작 년 월 주차, 종료 년 월, 주차를 가져온다. 
			st_year               = st_end_between_yearwk[0];   // 시작 년도 
			st_weekly             = st_end_between_yearwk[1];   // 시작 주차  
			st_month              = st_end_between_yearwk[2];   // 시작 년월 
			
			end_year              = st_end_between_yearwk[3];   // 종료 년도 
			end_weekly            = st_end_between_yearwk[4];   // 종료 주차 
			end_month             = st_end_between_yearwk[5];   // 종료 년월			

			weekStdt        = commonImpl.searchWeekToDate(st_year +st_weekly).getResultString(); 
			// EES_EQR_049Event setting
			condiVO049.setRepo_pln_dtrb_flg(repo_pln_dtrb_flg);
			condiVO049.setRepo_auto_gen_flg(repo_pln_auto_gen_flg);
			condiVO049.setScnrid(newScnrId);
			condiVO049.setOld_scnr_id(((String)hm.get("scnrId")));
			condiVO049.setRepo_plan_id(repoPlanId);
			condiVO049.setSim_pln_id(sim_pln_id);
			condiVO049.setInclu_onh_flg(old_repo_id_type[0]);
			condiVO049.setInclu_offh_flg(old_repo_id_type[1]);
	        condiVO049.setCntrTpszCd(old_repo_id_type[2]);
	        condiVO049.setRepo_pln_rmk("V");
	        condiVO049.setUser_id(userId);
	        condiVO049.setStyear(st_year);
	        condiVO049.setStmonth(st_month);
	        condiVO049.setStweekly(st_weekly);
	        condiVO049.setEndyear(end_year);
	        condiVO049.setStmonth(end_month);
	        condiVO049.setEndweekly(end_weekly);
	        condiVO049.setDuration(old_repo_id_type[3]);
			        	
	        command.reRunVesselPlan(condiVO049 , userId);
           // cntrRepoPlanOptiExecuteImpl.createRepoPlanRunOptimizer(condiVO049 , weekStdt , userId);
	        cntrRepoPlanOptiExecuteImpl.enginRunOptimizer(condiVO049 , weekStdt);
            log.debug("\n reRunVesselPlanJMS ::event049.getRun_id_no(): " + condiVO049.getRun_id_no());
             eventResponse.setETCData("run_id_no" ,condiVO049.getRun_id_no());
        	}catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		    }
      return null;
	}

}