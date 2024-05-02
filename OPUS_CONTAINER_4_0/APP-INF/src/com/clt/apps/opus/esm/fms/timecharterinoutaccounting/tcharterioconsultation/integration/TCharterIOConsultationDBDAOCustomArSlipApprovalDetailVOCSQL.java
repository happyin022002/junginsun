/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : TCharterIOConsultationDBDAOCustomArSlipApprovalDetailVOCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.02.07
*@LastModifier : 
*@LastVersion : 1.0
* 2012.02.07 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TCharterIOConsultationDBDAOCustomArSlipApprovalDetailVOCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AR 전표에 대해 Detail 입력
	  * </pre>
	  */
	public TCharterIOConsultationDBDAOCustomArSlipApprovalDetailVOCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_coa_rgn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rep_chg_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_full_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_coa_co_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_coa_vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_coa_acct_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_rev_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rat_as_cntr_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trf_rt_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sob_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_if_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_coa_inter_co_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tax_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_coa_ctr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_coa_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_if_ser_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_coa_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_coa_skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("chg_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acct_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.integration").append("\n"); 
		query.append("FileName : TCharterIOConsultationDBDAOCustomArSlipApprovalDetailVOCSQL").append("\n"); 
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
		query.append("INSERT INTO JOO_AR_CHG (" ).append("\n"); 
		query.append("	AR_IF_NO" ).append("\n"); 
		query.append("	,AR_IF_SER_NO" ).append("\n"); 
		query.append("	,CHG_SEQ" ).append("\n"); 
		query.append("	,CHG_CD" ).append("\n"); 
		query.append("	,REP_CHG_CD" ).append("\n"); 
		query.append("	,CHG_AMT" ).append("\n"); 
		query.append("	,TRF_RT_AMT" ).append("\n"); 
		query.append("	,RAT_AS_CNTR_QTY" ).append("\n"); 
		query.append("	,SOB_ID" ).append("\n"); 
		query.append("	,CHG_FULL_NM" ).append("\n"); 
		query.append("	,CURR_CD" ).append("\n"); 
		query.append("	,TAX_AMT" ).append("\n"); 
		query.append("	,REV_COA_CO_CD" ).append("\n"); 
		query.append("	,REV_COA_RGN_CD" ).append("\n"); 
		query.append("	,REV_COA_CTR_CD" ).append("\n"); 
		query.append("	,REV_COA_ACCT_CD" ).append("\n"); 
		query.append("	,REV_COA_INTER_CO_CD" ).append("\n"); 
		query.append("	,REV_COA_VSL_CD" ).append("\n"); 
		query.append("	,REV_COA_VOY_NO" ).append("\n"); 
		query.append("	,REV_COA_SKD_DIR_CD" ).append("\n"); 
		query.append("	,REV_COA_DIR_CD" ).append("\n"); 
		query.append("	,ACCT_CD" ).append("\n"); 
		query.append("	,CRE_USR_ID" ).append("\n"); 
		query.append("	,CRE_DT" ).append("\n"); 
		query.append("	,UPD_USR_ID" ).append("\n"); 
		query.append("	,UPD_DT" ).append("\n"); 
		query.append("    ,JO_REV_TP_CD" ).append("\n"); 
		query.append(") VALUES( " ).append("\n"); 
		query.append("	 @[ar_if_no]" ).append("\n"); 
		query.append("	,@[ar_if_ser_no]" ).append("\n"); 
		query.append("	,@[chg_seq]" ).append("\n"); 
		query.append("	,@[chg_cd]" ).append("\n"); 
		query.append("	,@[rep_chg_cd]" ).append("\n"); 
		query.append("	,@[chg_amt]" ).append("\n"); 
		query.append("	,@[trf_rt_amt]" ).append("\n"); 
		query.append("	,@[rat_as_cntr_qty]" ).append("\n"); 
		query.append("	,@[sob_id]" ).append("\n"); 
		query.append("	,@[chg_full_nm]" ).append("\n"); 
		query.append("	,@[curr_cd]" ).append("\n"); 
		query.append("	,@[tax_amt]" ).append("\n"); 
		query.append("	,@[rev_coa_co_cd]" ).append("\n"); 
		query.append("	,@[rev_coa_rgn_cd]" ).append("\n"); 
		query.append("	,@[rev_coa_ctr_cd]" ).append("\n"); 
		query.append("	,@[rev_coa_acct_cd]" ).append("\n"); 
		query.append("	,@[rev_coa_inter_co_cd]" ).append("\n"); 
		query.append("	,@[rev_coa_vsl_cd]" ).append("\n"); 
		query.append("	,@[rev_coa_voy_no]" ).append("\n"); 
		query.append("	,@[rev_coa_skd_dir_cd]" ).append("\n"); 
		query.append("	,@[rev_coa_dir_cd]" ).append("\n"); 
		query.append("	,@[acct_cd]" ).append("\n"); 
		query.append("	,@[cre_usr_id]" ).append("\n"); 
		query.append("    ,SYSDATE" ).append("\n"); 
		query.append("    ,@[cre_usr_id]" ).append("\n"); 
		query.append("    ,SYSDATE" ).append("\n"); 
		query.append("    ,@[jo_rev_tp_cd]" ).append("\n"); 
		query.append("	)" ).append("\n"); 

	}
}