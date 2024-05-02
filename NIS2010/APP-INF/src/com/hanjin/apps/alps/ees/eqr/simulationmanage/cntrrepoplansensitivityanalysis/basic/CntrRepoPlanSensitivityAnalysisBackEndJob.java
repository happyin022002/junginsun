/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OnewaySimulateBackEndJob.java
*@FileTitle : OnewaySimulate
*Open Issues : 기존 JMS 호출부분을 backEndJob으로 변경 하여 반영된 java 
*Change history :
*@LastModifyDate : 2009.09.14
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2009.09.14 채창호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.simulationmanage.cntrrepoplansensitivityanalysis.basic;

import java.util.HashMap;

import com.hanjin.apps.alps.ees.eqr.common.Utils;
import com.hanjin.apps.alps.ees.eqr.common.eqrcommon.basic.CommonBCImpl;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.cntrrepoplanoptiexecute.basic.CntrRepoPlanOptiExecuteBCImpl;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.cntrrepoplanoptiexecute.vo.EesEqr0049ConditionVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.layer.backend.BackEndCommandSupport;

/**
 * ALPS-CntrRepoPlanSensitivityAnalysis Business Logic Command Interface<br>
 * - ALPS-CntrRepoPlanSensitivityAnalysis에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Chae Change Ho
 * @see EventResponse 참조
 * @since J2EE 1.6
 */
public class CntrRepoPlanSensitivityAnalysisBackEndJob extends BackEndCommandSupport{


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
		
		// 호출되는 화면을 구분을 하기 위한 값을 추출을 해온다.
		//String uiname = (String)hm.get("uiname");
		//0065화면에서 호출이 되었을때 
		
		//HashMap<String,String> hm = Utils.createMap(str);
		EesEqr0049ConditionVO condiVO049 = new EesEqr0049ConditionVO();
	 	CntrRepoPlanOptiExecuteBCImpl cntrRepoPlanOptiExecuteBC = new CntrRepoPlanOptiExecuteBCImpl();
	 	GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonBCImpl commonBC = new CommonBCImpl();

		String old_scnario_id        = (String)hm.get("oldScrnid");
		String new_scnd_id           = "";
		String new_repo_id           = "";
		// 과거 repo_plan_id의 속성을 정의 한다. 
		String incl_onh_flg          =""; 
		String incl_offh_flg         = "";
		String repo_pln_dtrb_flg     = "N";
		String repo_pln_auto_gen_flg = "N";
		String incl_cntr_tpsz_ctntg  = "";
		String duration              = "";
		String sim_pln_id            = (String)hm.get("sim_pln_id");
		String delt_flg              = "N";
		String st_year               = "";
		String st_month              = "";
		String st_weekly             = "";
		String end_year              = "";
		String end_month             = "";
		String end_weekly            = "";
		String[] old_repo_id_type    = null;
		String[] st_end_between_yearwk = null;
		String   run_id_no           = (String)hm.get("run_id_no");;
		String   sense               = (String)hm.get("sens");
		String   cost_code           = (String)hm.get("cost_code");
		String   limit_code          = (String)hm.get("limit_code");
		String   weekStdt  = "";
	        
	    
		try {
	    	String usr_id        = (String)hm.get("user_id");
			new_scnd_id           = commonBC.createNewScnarioId(old_scnario_id).getResultString();  // 새로운 scnario id을 생성한다. 
			new_repo_id           = commonBC.createNewRepoPlanId(sim_pln_id).getResultString();  // 새로운 repo_plan_id을 생성한다.
			old_repo_id_type      = commonBC.searchOldRepoPlantype(sim_pln_id).getResultStrArray(); // 과거 repo_pln_id 의 속성을 가져온다.
			st_end_between_yearwk = commonBC.weewklyConvertMonth((String)hm.get("yyyyww") , 10).getResultStrArray(); // 해당 주 10주에 대한 시작 , 끝나는 주차 년 월 주차를 가져 온다. 
			
			// old_repo_plan_id type 성격을 가져온다. 
			incl_onh_flg          = old_repo_id_type[0];
			incl_offh_flg         = old_repo_id_type[1];
			incl_cntr_tpsz_ctntg  = old_repo_id_type[2];
			duration              = old_repo_id_type[3];
			
			// 기존 주차를 기준으로 해서 시작 년 월 주차, 종료 년 월, 주차를 가져온다. 
			st_year               = st_end_between_yearwk[0];   // 시작 년도 
			st_weekly             = st_end_between_yearwk[1];   // 시작 주차  
			st_month              = st_end_between_yearwk[2];   // 시작 년월 
			
			end_year              = st_end_between_yearwk[3];   // 종료 년도 
			end_weekly            = st_end_between_yearwk[4];   // 종료 주차 
			end_month             = st_end_between_yearwk[5];   // 종료 년월
			
			weekStdt        = commonBC.searchWeekToDate(st_year +st_weekly).getResultString();
			//ees_eqr49 event에 데이터를 setting 
			
			condiVO049.setScnrid(old_scnario_id);
			//condiVO049.setOld_scnr_id(old_scnario_id);
			condiVO049.setRepo_plan_id(new_repo_id);
			condiVO049.setInclu_onh_flg(incl_onh_flg);
			condiVO049.setInclu_offh_flg(incl_offh_flg);
			condiVO049.setRepo_pln_dtrb_flg(repo_pln_dtrb_flg);
			condiVO049.setRepo_auto_gen_flg(repo_pln_auto_gen_flg);
			condiVO049.setSim_pln_id(sim_pln_id);
			condiVO049.setDelt_flg(delt_flg);
			condiVO049.setUser_id(usr_id);
			condiVO049.setCntrTpszCd(incl_cntr_tpsz_ctntg);
			condiVO049.setRepo_pln_rmk("S");
			condiVO049.setStyear(st_year);
			condiVO049.setStmonth(st_month);
			condiVO049.setStweekly(st_weekly);
			condiVO049.setEndyear(end_year);
			condiVO049.setEndmonth(end_month);
			condiVO049.setEndweekly(end_weekly);
			condiVO049.setDuration(duration);
			condiVO049.setSold_flg("");
			condiVO049.setSensitivity_code(sense);
			if(sense.equals("0")){ //cost
				condiVO049.setObject_code(cost_code);
			}else {
				condiVO049.setObject_code(limit_code);
			}
			condiVO049.setRun_id_no(run_id_no);
				
			cntrRepoPlanOptiExecuteBC.enginRunOptimizer(condiVO049, weekStdt);
			//run_id_no = condiVO049.getRun_id_no();
			eventResponse.setETCData("run_id_no", run_id_no);
		    //return eventResponse;
	    	}catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		    }
	  return null;
	}

}