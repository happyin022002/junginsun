/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CostAssignDBDAOPrcExecAllCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.17
*@LastModifier : 최덕우
*@LastVersion : 1.0
* 2016.02.17 최덕우
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.stdunitcost.costassign.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Duk Woo
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
	  * 2012.04.10 최윤성 [CHM-201217066-01] [MAS] EMU 로직 보완 - MAS_COST_ASSIGN_PRECM_PRC 파라메타 추가
	  * 2012.08.03 전윤주 [CHM-201216347] [MAS] ACM 프로젝트 연동 변경 작업
	  *                  기존 AGT JAVA 소스를 호출하던 부분을 ACM 프로시져 호출로 변경함  
	  * 2013.01.16 성미영 [CHM-201322341]Split 02-[AOC] Batch creation 시 기준 WGT 입력 기능추가 요청 
	  * 2013.09.26 김수정 [CHM-201326654] EMU 로직 보완_Trunk 구간 평균단가 제외 및 BKG DEL 기준에서 MT Return CY 기준으로 변경
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
		params.put("pctl_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntr_mt_dys",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mod_name",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("start_pctl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aoc_bat_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_para",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.stdunitcost.costassign.integration").append("\n"); 
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
		query.append("#if (${methodname} == 'createMasCostPkgMainPrdAvg') " ).append("\n"); 
		query.append("/*" ).append("\n"); 
		query.append("  PRD 호출시 비용계산(PKG)" ).append("\n"); 
		query.append("  01. int createMasCostPkgMainPrdAvg(String str)" ).append("\n"); 
		query.append("  bkg_no, start_pctl_no, end_pctl_no, cost_yrmon" ).append("\n"); 
		query.append("*/" ).append("\n"); 
		query.append("CALL MAS_COST_PARA_ASSIGN_PKG.MAIN_PRD_AVG('',@[start_pctl_no],@[end_pctl_no],@[cost_yrmon])" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'createMasCostPkgMainCopAvg') " ).append("\n"); 
		query.append("/*" ).append("\n"); 
		query.append("  COP(배치) 호출시 비용계산(PKG)" ).append("\n"); 
		query.append("  02. int createMasCostPkgMainCopAvg(String str)" ).append("\n"); 
		query.append("  bkg_no, start_pctl_no, end_pctl_no, cost_yrmon" ).append("\n"); 
		query.append("*/" ).append("\n"); 
		query.append("CALL MAS_COST_PARA_ASSIGN_PKG.MAIN_COP_AVG(@[bkg_no],@[start_pctl_no],@[end_pctl_no],@[cost_yrmon])" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'callBatchAuditPkg')" ).append("\n"); 
		query.append("/*" ).append("\n"); 
		query.append(" 03. int callBatchAuditPkg(String modName, String method)" ).append("\n"); 
		query.append(" method, modName" ).append("\n"); 
		query.append(" call BATCH_AUDIT_PKG.method ()" ).append("\n"); 
		query.append("*/" ).append("\n"); 
		query.append("CALL BATCH_AUDIT_PKG.${method}(@[mod_name])" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'createMasCostPkgMainPrdCtrt')" ).append("\n"); 
		query.append("/*" ).append("\n"); 
		query.append("04. int createMasCostPkgMainPrdCtrt(String str)" ).append("\n"); 
		query.append("bkg_no, start_pctl_no, end_pctl_no, cost_yrmon" ).append("\n"); 
		query.append("*/" ).append("\n"); 
		query.append("MAS_COST_PARA_ASSIGN_PKG.MAIN_PRD_CTRT(@[bkg_no],@[start_pctl_no],@[end_pctl_no],@[cost_yrmon])" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'createMasCostPkgMainCopCtrt')" ).append("\n"); 
		query.append("/*" ).append("\n"); 
		query.append("05. int createMasCostPkgMainCopCtrt(String str)" ).append("\n"); 
		query.append("bkg_no, start_pctl_no, end_pctl_no, cost_yrmon" ).append("\n"); 
		query.append("*/" ).append("\n"); 
		query.append("CALL MAS_COST_PARA_ASSIGN_PKG.MAIN_COP_CTRT(@[bkg_no],@[start_pctl_no],@[end_pctl_no],@[cost_yrmon])" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'createMasCostPkgMainPrdMst')" ).append("\n"); 
		query.append("/*" ).append("\n"); 
		query.append("06. int createMasCostPkgMainPrdMst(String str)" ).append("\n"); 
		query.append("start_pctl_no, end_pctl_no, cost_yrmon" ).append("\n"); 
		query.append("*/" ).append("\n"); 
		query.append("CALL MAS_COST_PARA_ASSIGN_PKG.main_prd_prod_ctl_mst(@[start_pctl_no],@[end_pctl_no],@[cost_yrmon])" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'createMasCostPkgMainComTtl')" ).append("\n"); 
		query.append("/*" ).append("\n"); 
		query.append("07. int createMasCostPkgMainComTtl(String str)" ).append("\n"); 
		query.append("bkg_no, start_pctl_no, end_pctl_no, cost_yrmon" ).append("\n"); 
		query.append("*/" ).append("\n"); 
		query.append("CALL MAS_COST_PARA_ASSIGN_PKG.MAIN_COM_TTL_PARA(@[bkg_no],@[start_pctl_no],@[end_pctl_no],@[cost_yrmon])" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'createLog')" ).append("\n"); 
		query.append("/*" ).append("\n"); 
		query.append("08. String createLog(String errMsg)" ).append("\n"); 
		query.append("errMsg" ).append("\n"); 
		query.append("*/" ).append("\n"); 
		query.append("CALL ENIS_LOG_PRC (SYSDATE, 'PRD_CALL', @[err_msg], 'ERROR')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'createMasCostPrcPrdAbc')" ).append("\n"); 
		query.append("/*" ).append("\n"); 
		query.append("11. int createMasCostPrcPrdAbc(String str) " ).append("\n"); 
		query.append("start_pctl_no, end_pctl_no, cost_yrmon" ).append("\n"); 
		query.append("*/" ).append("\n"); 
		query.append("CALL MAS_COST_PARA_ASSIGN_PKG.MAIN_PRD_ABC_STP(@[start_pctl_no],@[end_pctl_no],@[cost_yrmon])" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'createMasCostPrcCopAbc')" ).append("\n"); 
		query.append("/*" ).append("\n"); 
		query.append("12. int createMasCostPrcCopAbc(String str) " ).append("\n"); 
		query.append("bkg_no, cost_yrmon" ).append("\n"); 
		query.append("*/" ).append("\n"); 
		query.append("CALL MAS_COST_PARA_ASSIGN_PKG.MAIN_COP_ABC_STP(@[bkg_no], @[cost_yrmon])" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'createMasCostPrcCntrRepo')" ).append("\n"); 
		query.append("/*" ).append("\n"); 
		query.append("17. int createMasCostPrcCntrRepo(String str) " ).append("\n"); 
		query.append("cost_yrmon, bkg_no" ).append("\n"); 
		query.append("*/" ).append("\n"); 
		query.append("CALL MAS_CNTR_REPO_IDX_ITM_INST_PRC(@[cost_yrmon], @[bkg_no])" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'createMasBkgExpnDtl')" ).append("\n"); 
		query.append("/*" ).append("\n"); 
		query.append("18. int createMasBkgExpnDtl(String str) " ).append("\n"); 
		query.append("B, NULL, NULL, NULL, bkg_no" ).append("\n"); 
		query.append("*/" ).append("\n"); 
		query.append("CALL MAS_BKG_EXPN_DTL_PRC( 'B','','','',@[bkg_no])" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'createMasBkgSvcTrnsPrcInst')" ).append("\n"); 
		query.append("/*" ).append("\n"); 
		query.append("19. int createMasBkgSvcTrnsPrcInst(String str)" ).append("\n"); 
		query.append("*/" ).append("\n"); 
		query.append("CALL MAS_BKG_SVC_TRNS_PRC_INST_PRC()" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'createMasCostPrcAssignPrd')" ).append("\n"); 
		query.append("/* " ).append("\n"); 
		query.append("  PRD에서 Call한 경우 기본정보 생성" ).append("\n"); 
		query.append("  09. int createMasCostPrcAssignPrd(String str) " ).append("\n"); 
		query.append("  OracleTypes.NUMBER, start_pctl_no, end_pctl_no, user_id, revenue(USD), Contract Ofc, PrePaid Ofc, Collect Ofc, cntr_mt_dys" ).append("\n"); 
		query.append("*/" ).append("\n"); 
		query.append("CALL MAS_COST_ASSIGN_PRECM_PRC(	@[out_para_number],@[start_pctl_no],@[end_pctl_no],@[usr_id],NULL,NULL,NULL,NULL,NULL,NULL,NULL,@[cntr_mt_dys])" ).append("\n"); 
		query.append("#elseif (${methodname} == 'createMasCostPrcAssignCop')" ).append("\n"); 
		query.append("/* " ).append("\n"); 
		query.append("  COP에서 Call한 경우(배치작업)" ).append("\n"); 
		query.append("  10. int createMasCostPrcAssignCop(String str) " ).append("\n"); 
		query.append("  OracleTypes.NUMBER, bkg_no, user_id" ).append("\n"); 
		query.append("*/" ).append("\n"); 
		query.append("CALL MAS_COST_ASSIGN_COP_PRC(@[out_para_number],@[bkg_no],@[usr_id])" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'createTrsAgmtApplyToMas')" ).append("\n"); 
		query.append("/* " ).append("\n"); 
		query.append("  TRS 계약 비용 계산" ).append("\n"); 
		query.append("  13. int createTrsAgmtApplyToMas(String str) " ).append("\n"); 
		query.append("  bkg_no, start_pctl_no, end_pctl_no, OracleTypes.VARCHAR" ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("  2010.06.30 박은주  TRS 계약 비용요율 계산 Procedure명 변경" ).append("\n"); 
		query.append("                    TRS_AGMT_APPLY_TO_MAS_PRC -> TRS_AGMT_APLY_TO_MAS_PRC" ).append("\n"); 
		query.append("  2010.07.09 박은주  프로시져에 debug flag 추가로 소스변경" ).append("\n"); 
		query.append("  2013.01.16 성미영  Split 02-[AOC] Batch creation 시 기준 WGT 입력 기능추가 요청" ).append("\n"); 
		query.append("*/" ).append("\n"); 
		query.append("CALL TRS_AGMT_APLY_TO_MAS_PRC(@[bkg_no],@[start_pctl_no],@[end_pctl_no],@[aoc_bat_seq],'N',@[out_para_number])" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'createTesMasRate')" ).append("\n"); 
		query.append("/* " ).append("\n"); 
		query.append("  TES 계약 비용 계산" ).append("\n"); 
		query.append("  14. int createTesMasRate(String str) " ).append("\n"); 
		query.append("  bkg_no, start_pctl_no, end_pctl_no, OracleTypes.NUMBER" ).append("\n"); 
		query.append("*/" ).append("\n"); 
		query.append("CALL TES_MAS_RATE_PRC(@[bkg_no],@[start_pctl_no],@[end_pctl_no],@[out_para_number])" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'createAcmAplyOtrCommToMas')" ).append("\n"); 
		query.append("/* " ).append("\n"); 
		query.append("  Agent commission other 계약 비용 계산" ).append("\n"); 
		query.append("  15. int createAcmAplyOtrCommToMas(String str, String str) " ).append("\n"); 
		query.append("  pctl_no, usr_id" ).append("\n"); 
		query.append("*/" ).append("\n"); 
		query.append("CALL ACM_APLY_OTR_COMM_TO_MAS_PRC(@[pctl_no], @[usr_id])" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'createAcmAplyCommToMas')" ).append("\n"); 
		query.append("/* " ).append("\n"); 
		query.append("  Agent commission 계약 비용 계산" ).append("\n"); 
		query.append("  15. int createAcmAplyCommToMas(String str, String str) " ).append("\n"); 
		query.append("  bkg_no, usr_id" ).append("\n"); 
		query.append("*/" ).append("\n"); 
		query.append("CALL ACM_APLY_COMM_TO_MAS_PRC(@[bkg_no], @[usr_id])" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'createMasBkgInfoInst')" ).append("\n"); 
		query.append("/* " ).append("\n"); 
		query.append("  BKG 정보 생성" ).append("\n"); 
		query.append("  16. int createMasBkgInfoInst(String str) " ).append("\n"); 
		query.append("  bkg_no, user_id, OracleTypes.VARCHAR" ).append("\n"); 
		query.append("*/" ).append("\n"); 
		query.append("CALL MAS_BKG_INFO_INST_PRC(@[bkg_no], @[usr_id], @[out_para_varchar])" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'createMasBkgCostSmry')" ).append("\n"); 
		query.append("/* " ).append("\n"); 
		query.append("  SANDARD COST CODE Level의 BKG 비용 생성" ).append("\n"); 
		query.append("  17. int createMasBkgCostSmry(String str) " ).append("\n"); 
		query.append("  bkg_no, user_id, 'T', del_para, OracleTypes.VARCHAR" ).append("\n"); 
		query.append("*/" ).append("\n"); 
		query.append("CALL  MAS_BKG_COST_SMRY_PRC(@[bkg_no], @[usr_id], 'T', @[del_para],@[out_para_varchar])" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'createMasBkgRevDtl')" ).append("\n"); 
		query.append("/*" ).append("\n"); 
		query.append("  BKG 수입  생성" ).append("\n"); 
		query.append("  18. int createMasBkgRevDtl(String str)" ).append("\n"); 
		query.append("  bkg_no, OracleTypes.VARCHAR" ).append("\n"); 
		query.append("*/" ).append("\n"); 
		query.append("CALL MAS_BKG_REV_DTL_PRC(@[bkg_no],@[out_para_varchar])" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'createMasCostPkgMainBkgAvg') " ).append("\n"); 
		query.append("/*" ).append("\n"); 
		query.append("  BKG(SPC) 호출시 비용계산(PKG) CHM-201534179" ).append("\n"); 
		query.append("  19. int createMasCostPkgMainBkgAvg(String str)" ).append("\n"); 
		query.append("  bkg_no, start_pctl_no, end_pctl_no, cost_yrmon" ).append("\n"); 
		query.append("*/" ).append("\n"); 
		query.append("CALL MAS_COST_PARA_ASSIGN_PKG.MAIN_BKG_AVG(@[bkg_no],@[start_pctl_no],@[end_pctl_no],@[cost_yrmon])" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'createMasCostPkgMainPrdMst2') " ).append("\n"); 
		query.append("/*" ).append("\n"); 
		query.append("  BKG(SPC) 호출시 비용계산(PKG) CHM-201534179" ).append("\n"); 
		query.append("  20. int createMasCostPkgMainPrdMst2(String str)" ).append("\n"); 
		query.append("  start_pctl_no, end_pctl_no, cost_yrmon" ).append("\n"); 
		query.append("*/" ).append("\n"); 
		query.append("CALL MAS_COST_PARA_ASSIGN_PKG.main_prd_prod_ctl_mst_2(@[start_pctl_no],@[end_pctl_no],@[cost_yrmon])" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'createMasCostPkgMainCopAvg2') " ).append("\n"); 
		query.append("/*" ).append("\n"); 
		query.append("  COP(배치) 호출시 비용계산(PKG)- BKG Create시 [CHM-201539244] - 2015.12.10" ).append("\n"); 
		query.append("  02. int createMasCostPkgMainCopAvg2(String str)" ).append("\n"); 
		query.append("  bkg_no, start_pctl_no, end_pctl_no, cost_yrmon" ).append("\n"); 
		query.append("*/" ).append("\n"); 
		query.append("CALL MAS_COST_PARA_ASSIGN_PKG.main_bkg_avg2(@[bkg_no],@[start_pctl_no],@[end_pctl_no],@[cost_yrmon])" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'createMasCostPkgMainPrdMst3') " ).append("\n"); 
		query.append("/*" ).append("\n"); 
		query.append("  PRD 호출시 계산된 금액 합계를 PRD에 넣어줌 " ).append("\n"); 
		query.append("  SPC CMPB 재계산 로직 변경에 따른 신규 추가부분 [CHM-201539244] - 2015.12.10" ).append("\n"); 
		query.append("  20. int createMasCostPkgMainPrdMst3(String str)" ).append("\n"); 
		query.append("  bkg_no, start_pctl_no, end_pctl_no, cost_yrmon" ).append("\n"); 
		query.append("*/" ).append("\n"); 
		query.append("CALL MAS_COST_PARA_ASSIGN_PKG.main_bkg_prod_ctl_mst(@[bkg_no],@[cost_yrmon])" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'createAcmAplyOtrCommToSpc2')" ).append("\n"); 
		query.append("/* " ).append("\n"); 
		query.append("  Agent commission other 계약 비용 계산 (SPC용 프로시저 호출) - [CHM-201539244] - 2015.12.10" ).append("\n"); 
		query.append("  15. int createAcmAplyOtrCommToSpc2(String str, String str, String str, String str) " ).append("\n"); 
		query.append("  bkg_no, pctl_no, usr_id, cost_yrmon" ).append("\n"); 
		query.append("*/" ).append("\n"); 
		query.append("CALL ACM_APLY_OTR_COMM_TO_SPC2_PRC(@[bkg_no], @[pctl_no], @[usr_id], @[cost_yrmon])" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'createAcmAplySpclCommToMas')" ).append("\n"); 
		query.append("/* " ).append("\n"); 
		query.append("  Agent commission Special Compensation 계약 비용 계산" ).append("\n"); 
		query.append("  21. int createAcmAplySpclCommToMas(String str, String str) " ).append("\n"); 
		query.append("  bkg_no, usr_id" ).append("\n"); 
		query.append("*/" ).append("\n"); 
		query.append("CALL ACM_APLY_SPCL_COMM_TO_MAS_PRC(@[bkg_no], @[usr_id])" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}