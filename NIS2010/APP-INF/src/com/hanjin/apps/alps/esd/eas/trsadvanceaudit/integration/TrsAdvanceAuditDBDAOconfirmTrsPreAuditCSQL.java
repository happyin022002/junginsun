/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : TrsAdvanceAuditDBDAOconfirmTrsPreAuditCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.09.19
*@LastModifier : 
*@LastVersion : 1.0
* 2017.09.19 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.trsadvanceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TrsAdvanceAuditDBDAOconfirmTrsPreAuditCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * confirmTrsPreAudit insert
	  * </pre>
	  */
	public TrsAdvanceAuditDBDAOconfirmTrsPreAuditCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hjl_inv_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("exceed_avg_diff_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_diff_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_iss_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_diff_pct",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hjl_inv_vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("auto_aud_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("inv_vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("exceed_avg_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("expn_aud_rslt_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pay_term_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_iss_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_aud_usd_diff_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("atch_file_lnk_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("no_optm_rout_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("curr_cng_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sel_aud_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rhq_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("expn_aud_rslt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("expn_aud_rslt_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_aud_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_aud_diff_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_save_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_diff_amt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wo_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("no_agmt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_cfm_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.trsadvanceaudit.integration").append("\n"); 
		query.append("FileName : TrsAdvanceAuditDBDAOconfirmTrsPreAuditCSQL").append("\n"); 
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
		query.append("MERGE INTO EAS_TRSP_AUD K USING DUAL" ).append("\n"); 
		query.append("ON( K.INV_NO = @[inv_no]" ).append("\n"); 
		query.append("AND K.INV_VNDR_SEQ  = @[inv_vndr_seq]" ).append("\n"); 
		query.append("AND K.TRSP_SO_TP_CD = @[trsp_so_tp_cd]" ).append("\n"); 
		query.append(") " ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("    UPDATE" ).append("\n"); 
		query.append("       SET AUTO_AUD_CFM_USR_ID = DECODE(@[s_save_tp_cd], 'C', @[upd_usr_id], AUTO_AUD_CFM_USR_ID)" ).append("\n"); 
		query.append("         , EXPN_AUD_STS_CD = DECODE(@[s_save_tp_cd], 'C', @[sel_aud_cd], EXPN_AUD_STS_CD)" ).append("\n"); 
		query.append("         , EXPN_AUD_RSLT_RMK = DECODE(@[s_save_tp_cd], 'S', @[expn_aud_rslt_rmk], EXPN_AUD_RSLT_RMK)" ).append("\n"); 
		query.append("         , EXPN_AUD_RSLT_USR_ID = DECODE(@[s_save_tp_cd], 'S', @[expn_aud_rslt_usr_id], EXPN_AUD_RSLT_USR_ID)" ).append("\n"); 
		query.append("         , ATCH_FILE_LNK_ID = DECODE(@[s_save_tp_cd], 'C', @[atch_file_lnk_id], 'S', @[atch_file_lnk_id], ATCH_FILE_LNK_ID)" ).append("\n"); 
		query.append("         , EXPN_AUD_RSLT_CD = DECODE(@[s_save_tp_cd], 'S', @[expn_aud_rslt_cd], EXPN_AUD_RSLT_CD)" ).append("\n"); 
		query.append("		 , AUD_CURR_CD = @[inv_aud_curr_cd]" ).append("\n"); 
		query.append("		 , AUD_DIFF_AMT = @[inv_aud_diff_amt]" ).append("\n"); 
		query.append("		 , AUD_USD_DIFF_AMT = @[inv_aud_usd_diff_amt]" ).append("\n"); 
		query.append("#if(${s_save_tp_cd} != '') -- OLTP 프로그램 수행시에만 실행 (배치에서 UPDATE 구문은 자료 이관시에만 실행)" ).append("\n"); 
		query.append("         , CRE_OFC_CD  = @[cre_ofc_cd]" ).append("\n"); 
		query.append("         , UPD_USR_ID  = @[upd_usr_id]" ).append("\n"); 
		query.append("         , UPD_DT      = SYSDATE" ).append("\n"); 
		query.append("         , LOCL_CRE_DT = GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[cre_ofc_cd])" ).append("\n"); 
		query.append("         , AUTO_AUD_CFM_DT = DECODE(@[s_save_tp_cd], 'C', GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[cre_ofc_cd]), AUTO_AUD_CFM_DT)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${batch_tp_cd} != '') -- 배치 프로그램 수행시에만 실행" ).append("\n"); 
		query.append("         , RHQ_CD = @[rhq_ofc_cd]" ).append("\n"); 
		query.append("         , INV_OFC_CD = @[inv_ofc_cd]" ).append("\n"); 
		query.append("         , INV_CFM_DT = TO_DATE(@[inv_cfm_dt], 'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("         , AUTO_EXPN_AUD_STS_CD = @[auto_aud_sts_cd]" ).append("\n"); 
		query.append("         , CURR_CD = @[curr_cd]" ).append("\n"); 
		query.append("         , WO_AMT = @[wo_amt]" ).append("\n"); 
		query.append("         , INV_AMT = @[inv_amt]" ).append("\n"); 
		query.append("         , CURR_CNG_FLG = @[curr_cng_flg]" ).append("\n"); 
		query.append("         , INV_DIFF_AMT = @[inv_diff_amt]" ).append("\n"); 
		query.append("         , INV_DIFF_RTO = @[inv_diff_pct]" ).append("\n"); 
		query.append("         , AGMT_APLY_FLG = @[no_agmt_flg]" ).append("\n"); 
		query.append("         , OPTM_ROUT_FLG = @[no_optm_rout_flg]" ).append("\n"); 
		query.append("         , AVG_OVR_DIFF_AMT = @[exceed_avg_diff_amt]" ).append("\n"); 
		query.append("         , INV_ISS_DT = TO_DATE(@[inv_iss_dt], 'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("         , INV_ISS_USR_ID = @[inv_iss_usr_id]" ).append("\n"); 
		query.append("         , GEN_PAY_TERM_CD = @[pay_term_cd]" ).append("\n"); 
		query.append("         , HJL_INV_NO = @[hjl_inv_no]" ).append("\n"); 
		query.append("         , HJL_INV_VNDR_SEQ = @[hjl_inv_vndr_seq]" ).append("\n"); 
		query.append("         , INV_DIFF_FLG = @[inv_diff_amt_flg]" ).append("\n"); 
		query.append("         , AVG_OVR_DIFF_FLG = @[exceed_avg_flg]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("    INSERT(INV_NO" ).append("\n"); 
		query.append("         , INV_VNDR_SEQ" ).append("\n"); 
		query.append("         , TRSP_SO_TP_CD" ).append("\n"); 
		query.append("         , EXPN_AUD_STS_CD" ).append("\n"); 
		query.append("         , EXPN_AUD_RSLT_RMK" ).append("\n"); 
		query.append("         , EXPN_AUD_RSLT_USR_ID" ).append("\n"); 
		query.append("         , ATCH_FILE_LNK_ID" ).append("\n"); 
		query.append("         , EXPN_AUD_RSLT_CD" ).append("\n"); 
		query.append("         , CRE_OFC_CD" ).append("\n"); 
		query.append("         , CRE_USR_ID" ).append("\n"); 
		query.append("         , CRE_DT" ).append("\n"); 
		query.append("         , UPD_USR_ID" ).append("\n"); 
		query.append("         , UPD_DT" ).append("\n"); 
		query.append("#if(${batch_tp_cd} != '') -- 배치 프로그램 수행시에만 실행" ).append("\n"); 
		query.append("         , RHQ_CD" ).append("\n"); 
		query.append("         , INV_OFC_CD" ).append("\n"); 
		query.append("         , INV_CFM_DT" ).append("\n"); 
		query.append("         , AUTO_EXPN_AUD_STS_CD" ).append("\n"); 
		query.append("         , CURR_CD" ).append("\n"); 
		query.append("         , WO_AMT" ).append("\n"); 
		query.append("         , INV_AMT" ).append("\n"); 
		query.append("         , CURR_CNG_FLG" ).append("\n"); 
		query.append("         , INV_DIFF_AMT" ).append("\n"); 
		query.append("         , INV_DIFF_RTO" ).append("\n"); 
		query.append("         , AGMT_APLY_FLG" ).append("\n"); 
		query.append("         , OPTM_ROUT_FLG" ).append("\n"); 
		query.append("         , AVG_OVR_DIFF_AMT" ).append("\n"); 
		query.append("         , INV_ISS_DT" ).append("\n"); 
		query.append("         , INV_ISS_USR_ID" ).append("\n"); 
		query.append("         , GEN_PAY_TERM_CD" ).append("\n"); 
		query.append("         , HJL_INV_NO" ).append("\n"); 
		query.append("         , HJL_INV_VNDR_SEQ" ).append("\n"); 
		query.append("         , INV_DIFF_FLG" ).append("\n"); 
		query.append("         , AVG_OVR_DIFF_FLG" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("    VALUES" ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("           @[inv_no]" ).append("\n"); 
		query.append("         , @[inv_vndr_seq]" ).append("\n"); 
		query.append("         , @[trsp_so_tp_cd]" ).append("\n"); 
		query.append("         , DECODE(@[s_save_tp_cd], 'C', @[sel_aud_cd])" ).append("\n"); 
		query.append("         , DECODE(@[s_save_tp_cd], 'S', @[expn_aud_rslt_rmk])" ).append("\n"); 
		query.append("         , DECODE(@[s_save_tp_cd], 'S', @[expn_aud_rslt_usr_id])" ).append("\n"); 
		query.append("         , DECODE(@[s_save_tp_cd], 'C', @[atch_file_lnk_id], 'S', @[atch_file_lnk_id])" ).append("\n"); 
		query.append("         , DECODE(@[s_save_tp_cd], 'S', @[expn_aud_rslt_cd])" ).append("\n"); 
		query.append("         , @[cre_ofc_cd]" ).append("\n"); 
		query.append("         , @[cre_usr_id]                                                               " ).append("\n"); 
		query.append("         , SYSDATE" ).append("\n"); 
		query.append("         , @[upd_usr_id]" ).append("\n"); 
		query.append("         , SYSDATE" ).append("\n"); 
		query.append("#if(${batch_tp_cd} != '') -- 배치 프로그램 수행시에만 실행" ).append("\n"); 
		query.append("         , @[rhq_ofc_cd]" ).append("\n"); 
		query.append("         , @[inv_ofc_cd]" ).append("\n"); 
		query.append("         , TO_DATE(@[inv_cfm_dt], 'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("         , @[auto_aud_sts_cd]" ).append("\n"); 
		query.append("         , @[curr_cd]" ).append("\n"); 
		query.append("         , @[wo_amt]" ).append("\n"); 
		query.append("         , @[inv_amt]" ).append("\n"); 
		query.append("         , @[curr_cng_flg]" ).append("\n"); 
		query.append("         , @[inv_diff_amt]" ).append("\n"); 
		query.append("         , @[inv_diff_pct]" ).append("\n"); 
		query.append("         , @[no_agmt_flg]" ).append("\n"); 
		query.append("         , @[no_optm_rout_flg]" ).append("\n"); 
		query.append("         , @[exceed_avg_diff_amt]" ).append("\n"); 
		query.append("         , TO_DATE(@[inv_iss_dt], 'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("         , @[inv_iss_usr_id]" ).append("\n"); 
		query.append("         , @[pay_term_cd]" ).append("\n"); 
		query.append("         , @[hjl_inv_no]" ).append("\n"); 
		query.append("         , @[hjl_inv_vndr_seq]" ).append("\n"); 
		query.append("         , @[inv_diff_amt_flg]" ).append("\n"); 
		query.append("         , @[exceed_avg_flg]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("    )" ).append("\n"); 

	}
}