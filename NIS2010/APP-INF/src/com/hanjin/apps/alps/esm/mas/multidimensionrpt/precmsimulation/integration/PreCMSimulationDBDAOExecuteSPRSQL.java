/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : PreCMSimulationDBDAOExecuteSPRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.06.22
*@LastModifier : 
*@LastVersion : 1.0
* 2017.06.22 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.multidimensionrpt.precmsimulation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PreCMSimulationDBDAOExecuteSPRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Pre CM/OP Simulation Stored Procedure 실행용 Query 객체
	  * 
	  * 2010.09.10 김기종 [CHM-201004982-01] MAS Architecture 위배사항 수정 - TRS Procedure명 변경
	  * 2012.04.10 최윤성 [CHM-201217066-01] [MAS] EMU 로직 보완 - MAS_COST_ASSIGN_PRECM_PRC 호출시 MTY_PKUP_YD_CD 파라메타 추가
	  * 2012.08.03 전윤주 [CHM-201216347] [MAS] ACM 프로젝트 연동 변경 작업
	  *                 기존 AGT JAVA 소스를 호출하던 부분을 ACM 프로시져 호출로 변경함
	  * 2013.01.16 성미영 [CHM-201322341]Split 02-[AOC] Batch creation 시 기준 WGT 입력 기능추가 요청
	  * 2013.09.26 김수정 [CHM-201326654] EMU 로직 보완_Trunk 구간 평균단가 제외 및 BKG DEL 기준에서 MT Return CY 기준으로 변경
	  * </pre>
	  */
	public PreCMSimulationDBDAOExecuteSPRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_chss_term",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_g_rev",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_void_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_mty_pkup_yd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ttl_dys",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_end_pctl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_mty_rtn_yd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_pctl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_agmt_sgn_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_cost_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_user_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_clt_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_ppd_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_mt_dys",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_start_pctl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_out_param_number",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.multidimensionrpt.precmsimulation.integration").append("\n"); 
		query.append("FileName : PreCMSimulationDBDAOExecuteSPRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
	
	public String getSQL(){
		return query.toString();
	}
	
	public HashMap<String,String[]> getParams() {
		return params;
	}

	/**
	 * Query 생성
	 */
	public void setQuery(){
		query.append("#if (${f_call_id} == 'PRE' )" ).append("\n"); 
		query.append("	CALL MAS_COST_ASSIGN_PRECM_PRC(	@[f_out_param_number],@[f_start_pctl_no],@[f_end_pctl_no],@[f_user_id],@[f_g_rev]," ).append("\n"); 
		query.append("									@[f_agmt_sgn_ofc_cd],@[f_ppd_ofc_cd],@[f_clt_ofc_cd],@[f_mty_pkup_yd],@[f_mty_rtn_yd],@[f_chss_term],@[cntr_mt_dys],@[ttl_dys])" ).append("\n"); 
		query.append("#elseif (${f_call_id} == 'TRS' )" ).append("\n"); 
		query.append("	CALL TRS_AGMT_APLY_TO_MAS_PRC('',@[f_pctl_no],@[f_pctl_no],null,'N',@[f_out_param_number])" ).append("\n"); 
		query.append("#elseif (${f_call_id} == 'TES' )" ).append("\n"); 
		query.append("	CALL TES_MAS_RATE_PRC('',@[f_pctl_no],@[f_pctl_no],@[f_out_param_number])" ).append("\n"); 
		query.append("#elseif (${f_call_id} == 'AVG' )" ).append("\n"); 
		query.append("	CALL MAS_COST_PARA_ASSIGN_PKG.MAIN_PRECM_AVG(@[f_pctl_no],@[f_cost_yrmon],@[f_void_qty])" ).append("\n"); 
		query.append("#elseif (${f_call_id} == 'ABC' )" ).append("\n"); 
		query.append("	CALL MAS_COST_PARA_ASSIGN_PKG.MAIN_PRECM_ABC_STP(@[f_pctl_no],@[f_pctl_no],@[f_cost_yrmon])" ).append("\n"); 
		query.append("#elseif (${f_call_id} == 'AGT' )" ).append("\n"); 
		query.append("	CALL ACM_APLY_OTR_COMM_TO_MAS_PRC(@[f_pctl_no],@[f_user_id])" ).append("\n"); 
		query.append("#elseif (${f_call_id} == 'TTL' )" ).append("\n"); 
		query.append("	CALL MAS_COST_PARA_ASSIGN_PKG.MAIN_COM_TTL_PARA('',@[f_pctl_no],@[f_pctl_no],@[f_cost_yrmon])" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}