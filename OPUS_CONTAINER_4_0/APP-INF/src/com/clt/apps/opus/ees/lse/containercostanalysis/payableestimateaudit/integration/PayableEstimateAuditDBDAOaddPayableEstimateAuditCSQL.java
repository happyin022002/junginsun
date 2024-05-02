/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : PayableEstimateAuditDBDAOaddPayableEstimateAuditCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.21
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.21 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.lse.containercostanalysis.payableestimateaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PayableEstimateAuditDBDAOaddPayableEstimateAuditCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 저장된 임차료에 대한 추정 실적을 저장 합니다
	  * </pre>
	  */
	public PayableEstimateAuditDBDAOaddPayableEstimateAuditCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_plc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("biz_ut_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_act_plc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("estm_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sys_src_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rev_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lse_pay_chg_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("locl_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acct_dtl_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("act_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("estm_seq_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("exe_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("accl_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.lse.containercostanalysis.payableestimateaudit.integration").append("\n"); 
		query.append("FileName : PayableEstimateAuditDBDAOaddPayableEstimateAuditCSQL").append("\n"); 
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
		query.append("INSERT INTO GL_ESTM_IF_ERP (" ).append("\n"); 
		query.append("   EXE_YRMON," ).append("\n"); 
		query.append("   SYS_SRC_ID," ).append("\n"); 
		query.append("   REV_YRMON," ).append("\n"); 
		query.append("   ACCT_CD," ).append("\n"); 
		query.append("   ESTM_SEQ_NO," ).append("\n"); 
		query.append("   AGMT_NO," ).append("\n"); 
		query.append("   WO_NO," ).append("\n"); 
		query.append("   BIZ_UT_ID," ).append("\n"); 
		query.append("   LOC_CD," ).append("\n"); 
		query.append("   VSL_CD," ).append("\n"); 
		query.append("   SKD_VOY_NO," ).append("\n"); 
		query.append("   SKD_DIR_CD," ).append("\n"); 
		query.append("   REV_DIR_CD," ).append("\n"); 
		query.append("   CNTR_TPSZ_CD," ).append("\n"); 
		query.append("   CNTR_QTY," ).append("\n"); 
		query.append("   BSA_SLT_QTY," ).append("\n"); 
		query.append("   SLT_COST_AMT," ).append("\n"); 
		query.append("   CUST_SEQ," ).append("\n"); 
		query.append("   HIR_DT_AMT," ).append("\n"); 
		query.append("   ESTM_AMT," ).append("\n"); 
		query.append("   ACT_AMT," ).append("\n"); 
		query.append("   ACCL_AMT," ).append("\n"); 
		query.append("   OP_LSE_DIV_FLG," ).append("\n"); 
		query.append("   TTL_TRF_AMT," ).append("\n"); 
		query.append("   CRE_USR_ID," ).append("\n"); 
		query.append("   CRE_DT," ).append("\n"); 
		query.append("   UPD_USR_ID," ).append("\n"); 
		query.append("   UPD_DT," ).append("\n"); 
		query.append("   ESTM_VVD_TP_CD," ).append("\n"); 
		query.append("   ESTM_IOC_DIV_CD," ).append("\n"); 
		query.append("   ESTM_BC_DIV_CD," ).append("\n"); 
		query.append("   LOCL_CURR_CD," ).append("\n"); 
		query.append("   ACT_DT," ).append("\n"); 
		query.append("   ACT_PLC_CD," ).append("\n"); 
		query.append("   SLAN_CD," ).append("\n"); 
		query.append("   ACCT_DTL_CD," ).append("\n"); 
		query.append("   COST_ACT_PLC_CD" ).append("\n"); 
		query.append(")VALUES(" ).append("\n"); 
		query.append("   @[exe_yrmon]," ).append("\n"); 
		query.append("   @[sys_src_id]," ).append("\n"); 
		query.append("   @[rev_yrmon]," ).append("\n"); 
		query.append("   @[acct_cd]," ).append("\n"); 
		query.append("   @[estm_seq_no]," ).append("\n"); 
		query.append("   @[agmt_no]," ).append("\n"); 
		query.append("   @[lse_pay_chg_tp_cd]," ).append("\n"); 
		query.append("   @[biz_ut_id]," ).append("\n"); 
		query.append("   @[loc_cd]," ).append("\n"); 
		query.append("   @[vsl_cd]," ).append("\n"); 
		query.append("   @[skd_voy_no]," ).append("\n"); 
		query.append("   @[skd_dir_cd]," ).append("\n"); 
		query.append("   @[rev_dir_cd]," ).append("\n"); 
		query.append("   @[cntr_tpsz_cd]," ).append("\n"); 
		query.append("   @[cntr_qty]," ).append("\n"); 
		query.append("   0," ).append("\n"); 
		query.append("   0," ).append("\n"); 
		query.append("   @[vndr_seq]," ).append("\n"); 
		query.append("   0," ).append("\n"); 
		query.append("   @[estm_amt]," ).append("\n"); 
		query.append("   @[act_amt]," ).append("\n"); 
		query.append("   @[accl_amt]," ).append("\n"); 
		query.append("   'N'," ).append("\n"); 
		query.append("   0," ).append("\n"); 
		query.append("   @[cre_usr_id]," ).append("\n"); 
		query.append("   SYSDATE," ).append("\n"); 
		query.append("   @[upd_usr_id]," ).append("\n"); 
		query.append("   SYSDATE," ).append("\n"); 
		query.append("   'RV'," ).append("\n"); 
		query.append("   'XX'," ).append("\n"); 
		query.append("   'C'," ).append("\n"); 
		query.append("   @[locl_curr_cd]," ).append("\n"); 
		query.append("   @[act_dt]," ).append("\n"); 
		query.append("   @[act_plc_cd]," ).append("\n"); 
		query.append("   'COM'," ).append("\n"); 
		query.append("   @[acct_dtl_cd]," ).append("\n"); 
		query.append("   @[cost_act_plc_cd]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}