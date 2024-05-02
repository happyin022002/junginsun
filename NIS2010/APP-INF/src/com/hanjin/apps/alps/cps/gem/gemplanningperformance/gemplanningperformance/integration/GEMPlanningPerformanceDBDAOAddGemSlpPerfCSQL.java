/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : GEMPlanningPerformanceDBDAOAddGemSlpPerfCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.29
*@LastModifier : 
*@LastVersion : 1.0
* 2012.05.29 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GEMPlanningPerformanceDBDAOAddGemSlpPerfCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ERP(G/L)로부터 일반관리비 비용집계 대상 전표(실적)에 대하여 회계마감(G/L마감) 이후 월 1회 I/F
	  * 2011-02-23 이준범 [CHM-201108800-01]
	  * 제목: Split 01-ERP에서 ALPS>GEM으로 AP slip data 송신 시 추가정보 요청
	  * 보완: upplier code, Supplier Name, Credit card user name 항목 추가
	  * 2011-03-11 이준범 [CHM-201108800-01]
	  *  제목: ERP I/F DATA 추가 요청
	  *  보완: 1. 법인카드 가맹점 정보 추가 I/F
	  *         2. GEM 수신 메뉴
	  *           - INQUIRY > SLIP INQUIRY
	  *           - 화면상 보이지 않고 DOWNLOAD 시 VANDER NAME 옆에 다운로드
	  * 2012.05.29 이준범 [CHM-201218022] GEM/ Slip 중복 발생 방지 기능 및 Uploading 결과값 Pop-up 기능 추가 요청
	  * </pre>
	  */
	public GEMPlanningPerformanceDBDAOAddGemSlpPerfCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slp_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slp_splr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crd_shop_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gen_expn_fnl_locl_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rslt_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sub_gen_expn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slp_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slp_tj_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slp_ctr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slp_seq_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cr_crd_usr_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gen_expn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("subs_acct_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slp_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slp_splr_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sub_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slp_vndr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acct_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gl_eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slp_perf_amt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.integration").append("\n"); 
		query.append("FileName : GEMPlanningPerformanceDBDAOAddGemSlpPerfCSQL").append("\n"); 
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
		query.append("INSERT INTO GEM_SLP_PERF" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("  SLP_TJ_NO" ).append("\n"); 
		query.append(" ,SLP_SEQ_NO" ).append("\n"); 
		query.append(" ,RSLT_YRMON" ).append("\n"); 
		query.append(" ,OFC_CD" ).append("\n"); 
		query.append(" ,SUB_OFC_CD" ).append("\n"); 
		query.append(" ,GEN_EXPN_CD" ).append("\n"); 
		query.append(" ,SUB_GEN_EXPN_CD" ).append("\n"); 
		query.append(" ,ACCT_CD" ).append("\n"); 
		query.append(" ,SLP_CTR_CD" ).append("\n"); 
		query.append(" ,SLP_CURR_CD" ).append("\n"); 
		query.append(" ,SLP_AMT" ).append("\n"); 
		query.append(" ,SLP_VNDR_CD" ).append("\n"); 
		query.append(" ,GL_EFF_DT" ).append("\n"); 
		query.append(" ,GEN_EXPN_FNL_LOCL_AMT" ).append("\n"); 
		query.append(" ,SLP_PERF_AMT" ).append("\n"); 
		query.append(" ,SLP_DESC" ).append("\n"); 
		query.append(" ,CRE_USR_ID" ).append("\n"); 
		query.append(" ,CRE_DT" ).append("\n"); 
		query.append(" ,UPD_USR_ID" ).append("\n"); 
		query.append(" ,UPD_DT" ).append("\n"); 
		query.append(" ,SLP_SPLR_CD" ).append("\n"); 
		query.append(" ,SLP_SPLR_NM" ).append("\n"); 
		query.append(" ,CR_CRD_USR_NM  " ).append("\n"); 
		query.append(" ,CRD_SHOP_NM" ).append("\n"); 
		query.append(" ,SUBS_ACCT_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("  @[slp_tj_no]" ).append("\n"); 
		query.append(" ,SUBSTR(@[slp_seq_no] + 10000,2,5)" ).append("\n"); 
		query.append(" ,SUBSTR(@[rslt_yrmon],1,6)" ).append("\n"); 
		query.append(" ,@[ofc_cd]" ).append("\n"); 
		query.append(" ,@[sub_ofc_cd]" ).append("\n"); 
		query.append(" ,@[gen_expn_cd]" ).append("\n"); 
		query.append(" ,@[sub_gen_expn_cd]" ).append("\n"); 
		query.append(" ,@[acct_cd]" ).append("\n"); 
		query.append(" ,@[slp_ctr_cd]" ).append("\n"); 
		query.append(" ,@[slp_curr_cd]" ).append("\n"); 
		query.append(" ,@[slp_amt]" ).append("\n"); 
		query.append(" ,@[slp_vndr_cd]" ).append("\n"); 
		query.append(" ,@[gl_eff_dt]" ).append("\n"); 
		query.append(" ,@[gen_expn_fnl_locl_amt]" ).append("\n"); 
		query.append(" ,@[slp_perf_amt]" ).append("\n"); 
		query.append(" ,@[slp_desc]" ).append("\n"); 
		query.append(" ,@[cre_usr_id]" ).append("\n"); 
		query.append(" ,SYSDATE" ).append("\n"); 
		query.append(" ,@[upd_usr_id]" ).append("\n"); 
		query.append(" ,SYSDATE" ).append("\n"); 
		query.append(" ,@[slp_splr_cd]" ).append("\n"); 
		query.append(" ,@[slp_splr_nm]" ).append("\n"); 
		query.append(" ,@[cr_crd_usr_nm]" ).append("\n"); 
		query.append(" ,@[crd_shop_nm]" ).append("\n"); 
		query.append(" ,@[subs_acct_cd]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}