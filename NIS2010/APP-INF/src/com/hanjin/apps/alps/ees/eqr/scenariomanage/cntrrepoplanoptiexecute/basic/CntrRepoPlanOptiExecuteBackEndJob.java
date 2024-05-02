/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CntrRepoPlanOptiExecuteBackEndJob.java
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

import com.hanjin.apps.alps.ees.eqr.common.Utils;
import com.hanjin.apps.alps.ees.eqr.common.eqrcommon.basic.CommonBCImpl;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.cntrrepoplanoptiexecute.basic.CntrRepoPlanOptiExecuteBCImpl;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.cntrrepoplanoptiexecute.vo.EesEqr0049ConditionVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.layer.backend.BackEndCommandSupport;

/**
 * ALPS-CntrRepoPlanOptiExecute Business Logic Basic Command implementation<br>
 * - ALPS-CntrRepoPlanOptiExecute에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Chae Change Ho
 * @see EES_EQR_0049EventResponse,CntrRepoPlanOptiExecuteBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class CntrRepoPlanOptiExecuteBackEndJob extends BackEndCommandSupport{


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
	 * @return null
	 */
	public Object doStart() throws Exception {
		
//		if( log.isDebugEnabled())
//		{
//			log.debug("\n\n==> " + paramString );
//		}
		HashMap<String,String> hm = Utils.createMap(paramString);
		
		// 호출되는 화면을 구분을 하기 위한 값을 추출을 해온다.
		String uiname = (String)hm.get("uiname");
		//0049 화면에서 호출이 되었을때 
		if (uiname.equals("EES_EQR_0049")){
			GeneralEventResponse eventResponse = new GeneralEventResponse();
		  //  HashMap<String,String> hm = Utils.createMap(paramString);  // JMS에서 넘어온 값을 구분하기 위해서 해쉬맵에 담아 놓는다.
		    EesEqr0049ConditionVO eesEqr0049ConditionVO = new EesEqr0049ConditionVO();
			CntrRepoPlanOptiExecuteBCImpl command = new CntrRepoPlanOptiExecuteBCImpl();
			CommonBCImpl commonBC = new CommonBCImpl();
			//CommonVO  rsVO = null;
			
			String old_scnario_id        = (String)hm.get("oldScrnid");
	       // String new_scnd_id         = "";
	        String new_repo_id           = (String)hm.get("sim_pln_id");
	        String repoPlanYrWk          = new_repo_id.substring(4,10);
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
	        String   run_id_no           = (String)hm.get("run_id_no");
	        String  weekStdt             = "";
	    	try {  
	        log.info("new_scnr_id ===========================> " + new_repo_id);
	        log.info("run_id_no ===========================> " + run_id_no);
	    
				String userId        = (String)hm.get("user_id");;
				old_repo_id_type      = commonBC.searchOldRepoPlantype(sim_pln_id).getResultStrArray(); // 과거 repo_pln_id 의 속성을 가져온다.
				st_end_between_yearwk = commonBC.weewklyConvertMonth((String)hm.get("yyyyww") , 16).getResultStrArray(); // 해당 주 16주에 대한 시작 , 끝나는 주차 년 월 주차를 가져 온다.
				weekStdt 			  = commonBC.searchWeekToDate(repoPlanYrWk).getResultString();
				
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
				
				//ees_eqr49 event에 데이터를 setting 
				eesEqr0049ConditionVO.setOld_scnr_id(old_scnario_id);
				eesEqr0049ConditionVO.setScnrid(old_scnario_id);
				eesEqr0049ConditionVO.setRepo_plan_id(new_repo_id);
				eesEqr0049ConditionVO.setInclu_onh_flg(incl_onh_flg);
				eesEqr0049ConditionVO.setInclu_offh_flg(incl_offh_flg);
				eesEqr0049ConditionVO.setRepo_pln_dtrb_flg(repo_pln_dtrb_flg);
				eesEqr0049ConditionVO.setRepo_auto_gen_flg(repo_pln_auto_gen_flg);
				eesEqr0049ConditionVO.setSim_pln_id(sim_pln_id);
				eesEqr0049ConditionVO.setDelt_flg(delt_flg);
				eesEqr0049ConditionVO.setUser_id(userId);
				eesEqr0049ConditionVO.setCntrTpszCd(incl_cntr_tpsz_ctntg);
				eesEqr0049ConditionVO.setRepo_pln_rmk((String)hm.get("repo_pln_rmk"));
				eesEqr0049ConditionVO.setStyear(st_year);
				eesEqr0049ConditionVO.setStmonth(st_month);
				eesEqr0049ConditionVO.setStweekly(st_weekly);
				eesEqr0049ConditionVO.setEndyear(end_year);
				eesEqr0049ConditionVO.setEndmonth(end_month);
				eesEqr0049ConditionVO.setEndweekly(end_weekly);
				eesEqr0049ConditionVO.setDuration(duration);
				eesEqr0049ConditionVO.setRun_id_no(run_id_no);
				
				command.enginRunOptimizer(eesEqr0049ConditionVO , weekStdt);
				run_id_no = eesEqr0049ConditionVO.getRun_id_no();
				log.debug("run_id_no=========>" +run_id_no);
				eventResponse.setETCData("run_id_no" ,run_id_no);
	    	}catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		    }
	    //0050에서 호출이 되었을때 아래의 내용을 수용 
		}else {
			//0050에서 engine output 호출 부분
			CntrRepoPlanOptiExecuteBCImpl command = new CntrRepoPlanOptiExecuteBCImpl();
			command.enginOutput(paramString);
	   	}
		return null;
	}

}