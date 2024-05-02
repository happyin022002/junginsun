/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : CostAssignDBDAOPrcExecAllCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.12.13
*@LastModifier : 
*@LastVersion : 1.0
* 2012.12.13 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.stdunitcost.costassign.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CostAssignDBDAOPrcExecAllCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 비용계산용 PRC, PKG 실행
	  * </pre>
	  */
	public CostAssignDBDAOPrcExecAllCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("err_msg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("end_pctl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pctl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("start_pctl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("out_para_number",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("out_para_varchar",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_para",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.coa.stdunitcost.costassign.integration").append("\n"); 
		query.append("FileName : CostAssignDBDAOPrcExecAllCSQL").append("\n"); 
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
		query.append("#if (${methodname} == 'createCoaCostPkgMainPrdAvg') " ).append("\n"); 
		query.append("/*" ).append("\n"); 
		query.append("  PRD 호출시 비용계산(PKG)" ).append("\n"); 
		query.append("  01. int createCoaCostPkgMainPrdAvg(String str)" ).append("\n"); 
		query.append("  bkg_no, start_pctl_no, end_pctl_no, cost_yrmon" ).append("\n"); 
		query.append("*/" ).append("\n"); 
		query.append("CALL COA_COST_PARA_ASSIGN_PKG.MAIN_PRD_AVG('',@[start_pctl_no],@[end_pctl_no],@[cost_yrmon])" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'createCoaCostPkgMainCopAvg') " ).append("\n"); 
		query.append("/*" ).append("\n"); 
		query.append("  COP(배치) 호출시 비용계산(PKG)" ).append("\n"); 
		query.append("  02. int createCoaCostPkgMainCopAvg(String str)" ).append("\n"); 
		query.append("  bkg_no, start_pctl_no, end_pctl_no, cost_yrmon" ).append("\n"); 
		query.append("*/" ).append("\n"); 
		query.append("CALL COA_COST_PARA_ASSIGN_PKG.MAIN_COP_AVG(@[bkg_no],@[start_pctl_no],@[end_pctl_no],@[cost_yrmon])" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'createCoaCostPkgMainPrdMst')" ).append("\n"); 
		query.append("/*" ).append("\n"); 
		query.append("06. int createCoaCostPkgMainPrdMst(String str)" ).append("\n"); 
		query.append("start_pctl_no, end_pctl_no, cost_yrmon" ).append("\n"); 
		query.append("*/" ).append("\n"); 
		query.append("CALL COA_COST_PARA_ASSIGN_PKG.main_prd_prod_ctl_mst(@[start_pctl_no],@[end_pctl_no],@[cost_yrmon])" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'createCoaCostPkgMainComTtl')" ).append("\n"); 
		query.append("/*" ).append("\n"); 
		query.append("07. int createCoaCostPkgMainComTtl(String str)" ).append("\n"); 
		query.append("bkg_no, start_pctl_no, end_pctl_no, cost_yrmon" ).append("\n"); 
		query.append("*/" ).append("\n"); 
		query.append("CALL COA_COST_PARA_ASSIGN_PKG.MAIN_COM_TTL_PARA(@[bkg_no],@[start_pctl_no],@[end_pctl_no],@[cost_yrmon])" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'createLog')" ).append("\n"); 
		query.append("/*" ).append("\n"); 
		query.append("08. String createLog(String errMsg)" ).append("\n"); 
		query.append("errMsg" ).append("\n"); 
		query.append("*/" ).append("\n"); 
		query.append("CALL ENIS_LOG_PRC (SYSDATE, 'PRD_CALL', @[err_msg], 'ERROR')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'createCoaBkgExpnDtl')" ).append("\n"); 
		query.append("/*" ).append("\n"); 
		query.append("18. int createCoaBkgExpnDtl(String str) " ).append("\n"); 
		query.append("B, NULL, NULL, NULL, bkg_no" ).append("\n"); 
		query.append("*/" ).append("\n"); 
		query.append("CALL COA_BKG_EXPN_DTL_PRC( 'B','','','',@[bkg_no])" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'createCoaCostPrcAssignPrd')" ).append("\n"); 
		query.append("/* " ).append("\n"); 
		query.append("  PRD에서 Call한 경우 기본정보 생성" ).append("\n"); 
		query.append("  09. int createCoaCostPrcAssignPrd(String str) " ).append("\n"); 
		query.append("  OracleTypes.NUMBER, start_pctl_no, end_pctl_no, user_id, cost_yrmon" ).append("\n"); 
		query.append("*/" ).append("\n"); 
		query.append("CALL COA_COST_ASSIGN_PRC(@[out_para_number],@[start_pctl_no],@[end_pctl_no],@[usr_id], @[cost_yrmon])" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'createCoaCostPrcAssignCop')" ).append("\n"); 
		query.append("/* " ).append("\n"); 
		query.append("  COP에서 Call한 경우(배치작업)" ).append("\n"); 
		query.append("  10. int createCoaCostPrcAssignCop(String str) " ).append("\n"); 
		query.append("  OracleTypes.NUMBER, bkg_no, user_id" ).append("\n"); 
		query.append("*/" ).append("\n"); 
		query.append("CALL COA_COST_ASSIGN_COP_PRC(@[out_para_number],@[bkg_no],@[usr_id])" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'createTrsAgmtApplyToCoa')" ).append("\n"); 
		query.append("/* " ).append("\n"); 
		query.append("  TRS 계약 비용 계산" ).append("\n"); 
		query.append("  13. int createTrsAgmtApplyToCoa(String str) " ).append("\n"); 
		query.append("  bkg_no, start_pctl_no, end_pctl_no, OracleTypes.VARCHAR" ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("  2010.06.30 박은주  TRS 계약 비용요율 계산 Procedure명 변경" ).append("\n"); 
		query.append("                    TRS_AGMT_APPLY_TO_COA_PRC -> TRS_AGMT_APLY_TO_COA_PRC" ).append("\n"); 
		query.append("  2010.07.09 박은주  프로시져에 debug flag 추가로 소스변경" ).append("\n"); 
		query.append("*/" ).append("\n"); 
		query.append("CALL TRS_AGMT_APLY_TO_COA_PRC(@[bkg_no],@[start_pctl_no],@[end_pctl_no],'N',@[out_para_number])" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'createTesCoaRate')" ).append("\n"); 
		query.append("/* " ).append("\n"); 
		query.append("  TES 계약 비용 계산" ).append("\n"); 
		query.append("  14. int createTesCoaRate(String str) " ).append("\n"); 
		query.append("  bkg_no, start_pctl_no, end_pctl_no, OracleTypes.NUMBER" ).append("\n"); 
		query.append("*/" ).append("\n"); 
		query.append("CALL TES_COA_RATE_PRC(@[bkg_no],@[start_pctl_no],@[end_pctl_no],@[out_para_number])" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'createAcmAplyOtrCommToCoa')" ).append("\n"); 
		query.append("/* " ).append("\n"); 
		query.append("  Agent commission other 계약 비용 계산" ).append("\n"); 
		query.append("  15. int createAcmAplyOtrCommToCoa(String str, String str) " ).append("\n"); 
		query.append("  pctl_no, usr_id" ).append("\n"); 
		query.append("*/" ).append("\n"); 
		query.append("CALL ACM_APLY_OTR_COMM_TO_COA_PRC(@[pctl_no], @[usr_id])" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'createAcmAplyCommToCoa')" ).append("\n"); 
		query.append("/* " ).append("\n"); 
		query.append("  Agent commission 계약 비용 계산" ).append("\n"); 
		query.append("  15. int createAcmAplyCommToCoa(String str, String str) " ).append("\n"); 
		query.append("  bkg_no, usr_id" ).append("\n"); 
		query.append("*/" ).append("\n"); 
		query.append("CALL ACM_APLY_COMM_TO_COA_PRC(@[bkg_no], @[usr_id])" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'createCoaBkgInfoInst')" ).append("\n"); 
		query.append("/* " ).append("\n"); 
		query.append("  BKG 정보 생성" ).append("\n"); 
		query.append("  15. int createCoaBkgInfoInst(String str) " ).append("\n"); 
		query.append("  bkg_no, user_id, OracleTypes.VARCHAR" ).append("\n"); 
		query.append("*/" ).append("\n"); 
		query.append("CALL COA_BKG_INFO_INST_PRC(@[bkg_no], @[usr_id], @[out_para_varchar])" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'createCoaBkgCostSmry')" ).append("\n"); 
		query.append("/* " ).append("\n"); 
		query.append("  SANDARD COST CODE Level의 BKG 비용 생성" ).append("\n"); 
		query.append("  16. int createCoaBkgCostSmry(String str) " ).append("\n"); 
		query.append("  bkg_no, user_id, del_para, OracleTypes.VARCHAR" ).append("\n"); 
		query.append("*/" ).append("\n"); 
		query.append("CALL  COA_BKG_COST_SMRY_PRC(@[bkg_no], @[usr_id], @[del_para],@[out_para_varchar])" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'createCoaBkgRevDtl')" ).append("\n"); 
		query.append("/*" ).append("\n"); 
		query.append("  BKG 수입  생성" ).append("\n"); 
		query.append("  20. int createCoaBkgRevDtl(String str)" ).append("\n"); 
		query.append("  bkg_no, OracleTypes.VARCHAR" ).append("\n"); 
		query.append("*/" ).append("\n"); 
		query.append("CALL COA_BKG_REV_DTL_PRC(@[bkg_no],@[out_para_varchar])" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}