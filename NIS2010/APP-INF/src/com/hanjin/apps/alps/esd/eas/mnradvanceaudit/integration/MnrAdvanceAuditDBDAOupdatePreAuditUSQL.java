/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : MnrAdvanceAuditDBDAOupdatePreAuditUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.09.20
*@LastModifier : 
*@LastVersion : 1.0
* 2017.09.20 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.mnradvanceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MnrAdvanceAuditDBDAOupdatePreAuditUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MNR 자동심사 대상 CONFIRM 업데이트
	  * </pre>
	  */
	public MnrAdvanceAuditDBDAOupdatePreAuditUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("auto_expn_aud_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wo_vrfy_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("estm_vrfy_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("wo_vrfy_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("inv_diff_rto",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("inv_rgst_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mlt_wo_curr_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("expn_max_prmt_rto",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("expn_aud_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("inv_chg_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("estm_vrfy_desc",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("inv_cfm_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.mnradvanceaudit.integration").append("\n"); 
		query.append("FileName : MnrAdvanceAuditDBDAOupdatePreAuditUSQL").append("\n"); 
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
		query.append("MERGE INTO EAS_MNR_CFM_INV A" ).append("\n"); 
		query.append("USING DUAL" ).append("\n"); 
		query.append("   ON (A.INV_NO = @[inv_no] AND A.VNDR_SEQ = @[vndr_seq] AND A.EQ_KND_CD = @[eq_knd_cd])" ).append("\n"); 
		query.append(" WHEN MATCHED THEN" ).append("\n"); 
		query.append("        UPDATE SET A.UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append("                 , A.UPD_DT = SYSDATE" ).append("\n"); 
		query.append("				 , AUD_CURR_CD = @[inv_aud_curr_cd]" ).append("\n"); 
		query.append("				 , AUD_DIFF_AMT = @[inv_aud_diff_amt]" ).append("\n"); 
		query.append("				 , AUD_USD_DIFF_AMT = @[inv_aud_usd_diff_amt]" ).append("\n"); 
		query.append("#if(${batch_tp_cd} == '')" ).append("\n"); 
		query.append("                 , A.EXPN_AUD_STS_CD = DECODE(@[s_save_tp_cd], 'S', A.EXPN_AUD_STS_CD, @[expn_aud_sts_cd])" ).append("\n"); 
		query.append("                 , A.AUTO_AUD_CFM_DT = DECODE(@[s_save_tp_cd], 'S', A.AUTO_AUD_CFM_DT, SYSDATE)" ).append("\n"); 
		query.append("                 , A.AUTO_AUD_CFM_USR_ID = DECODE(@[s_save_tp_cd], 'S', A.AUTO_AUD_CFM_USR_ID, @[upd_usr_id])" ).append("\n"); 
		query.append("                 , A.LOCL_CRE_DT = GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[cre_ofc_cd])" ).append("\n"); 
		query.append("                 , A.CRE_OFC_CD = DECODE(A.CRE_OFC_CD, NULL, @[cre_ofc_cd], A.CRE_OFC_CD)" ).append("\n"); 
		query.append("                 , A.EXPN_AUD_RSLT_RMK = DECODE(@[s_save_tp_cd], 'S', @[expn_aud_rslt_rmk], A.EXPN_AUD_RSLT_RMK)" ).append("\n"); 
		query.append("                 , A.EXPN_AUD_RSLT_USR_ID = DECODE(@[s_save_tp_cd], 'S', @[upd_usr_id], A.EXPN_AUD_RSLT_USR_ID)" ).append("\n"); 
		query.append("                 , A.ATCH_FILE_LNK_ID = @[atch_file_lnk_id]" ).append("\n"); 
		query.append("                 , A.EXPN_AUD_RSLT_CD = DECODE(@[s_save_tp_cd], 'S',@[expn_aud_rslt_cd], EXPN_AUD_RSLT_CD)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${batch_tp_cd} != '') -- 배치 프로그램 수행시에만 실행" ).append("\n"); 
		query.append("                 , RHQ_CD = @[rhq_cd]" ).append("\n"); 
		query.append("                 , INV_OFC_CD = @[inv_ofc_cd]" ).append("\n"); 
		query.append("                 , INV_CFM_DT = TO_DATE(@[inv_cfm_dt],'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("                 , AUTO_EXPN_AUD_STS_CD = @[auto_expn_aud_sts_cd]" ).append("\n"); 
		query.append("                 , CURR_CD = @[curr_cd]" ).append("\n"); 
		query.append("                 , WO_AMT = @[wo_amt]" ).append("\n"); 
		query.append("                 , INV_AMT = @[inv_amt]" ).append("\n"); 
		query.append("                 , CURR_CNG_FLG = @[curr_cng_flg]" ).append("\n"); 
		query.append("                 , INV_DIFF_AMT = @[inv_diff_amt]" ).append("\n"); 
		query.append("                 , INV_DIFF_RTO = @[inv_diff_rto]" ).append("\n"); 
		query.append("                 , INV_CHG_AMT = @[inv_chg_amt]" ).append("\n"); 
		query.append("                 , WO_VRFY_FLG = @[wo_vrfy_flg]" ).append("\n"); 
		query.append("                 , ESTM_VRFY_FLG = @[estm_vrfy_flg]" ).append("\n"); 
		query.append("                 , ESTM_VRFY_DESC = @[estm_vrfy_desc]" ).append("\n"); 
		query.append("                 , WO_VRFY_DESC = @[wo_vrfy_desc]" ).append("\n"); 
		query.append("                 , INV_RGST_NO = @[inv_rgst_no]" ).append("\n"); 
		query.append("                 , INV_CURR_CD = @[inv_curr_cd]" ).append("\n"); 
		query.append("                 , EXPN_MAX_PRMT_RTO = @[expn_max_prmt_rto]" ).append("\n"); 
		query.append("                 , MLT_WO_CURR_FLG = @[mlt_wo_curr_flg]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("        INSERT (" ).append("\n"); 
		query.append("              INV_NO" ).append("\n"); 
		query.append("            , VNDR_SEQ" ).append("\n"); 
		query.append("            , EQ_KND_CD" ).append("\n"); 
		query.append("            , EXPN_AUD_STS_CD" ).append("\n"); 
		query.append("            , CRE_USR_ID" ).append("\n"); 
		query.append("            , CRE_DT" ).append("\n"); 
		query.append("            , UPD_USR_ID" ).append("\n"); 
		query.append("            , UPD_DT" ).append("\n"); 
		query.append("#if(${batch_tp_cd} != '') -- 배치 프로그램 수행시에만 실행" ).append("\n"); 
		query.append("            , RHQ_CD" ).append("\n"); 
		query.append("            , INV_OFC_CD" ).append("\n"); 
		query.append("            , INV_CFM_DT" ).append("\n"); 
		query.append("            , AUTO_EXPN_AUD_STS_CD" ).append("\n"); 
		query.append("            , CURR_CD" ).append("\n"); 
		query.append("            , WO_AMT" ).append("\n"); 
		query.append("            , INV_AMT" ).append("\n"); 
		query.append("            , CURR_CNG_FLG" ).append("\n"); 
		query.append("            , INV_DIFF_AMT" ).append("\n"); 
		query.append("            , INV_DIFF_RTO" ).append("\n"); 
		query.append("            , INV_CHG_AMT" ).append("\n"); 
		query.append("            , WO_VRFY_FLG" ).append("\n"); 
		query.append("            , ESTM_VRFY_FLG" ).append("\n"); 
		query.append("            , ESTM_VRFY_DESC" ).append("\n"); 
		query.append("            , WO_VRFY_DESC" ).append("\n"); 
		query.append("            , INV_RGST_NO" ).append("\n"); 
		query.append("            , INV_CURR_CD" ).append("\n"); 
		query.append("            , EXPN_MAX_PRMT_RTO" ).append("\n"); 
		query.append("            , MLT_WO_CURR_FLG" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("        VALUES" ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("              @[inv_no]" ).append("\n"); 
		query.append("            , @[vndr_seq]" ).append("\n"); 
		query.append("            , @[eq_knd_cd]" ).append("\n"); 
		query.append("            , DECODE(@[s_save_tp_cd], NULL, '', @[expn_aud_sts_cd])" ).append("\n"); 
		query.append("            , @[upd_usr_id]" ).append("\n"); 
		query.append("            , SYSDATE" ).append("\n"); 
		query.append("            , @[upd_usr_id]" ).append("\n"); 
		query.append("            , SYSDATE" ).append("\n"); 
		query.append("#if(${batch_tp_cd} != '') -- 배치 프로그램 수행시에만 실행" ).append("\n"); 
		query.append("            , @[rhq_cd]" ).append("\n"); 
		query.append("            , @[inv_ofc_cd]" ).append("\n"); 
		query.append("            , TO_DATE(@[inv_cfm_dt],'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("            , @[auto_expn_aud_sts_cd]" ).append("\n"); 
		query.append("            , @[curr_cd]" ).append("\n"); 
		query.append("            , @[wo_amt]" ).append("\n"); 
		query.append("            , @[inv_amt]" ).append("\n"); 
		query.append("            , @[curr_cng_flg]" ).append("\n"); 
		query.append("            , @[inv_diff_amt]" ).append("\n"); 
		query.append("            , @[inv_diff_rto]" ).append("\n"); 
		query.append("            , @[inv_chg_amt]" ).append("\n"); 
		query.append("            , @[wo_vrfy_flg]" ).append("\n"); 
		query.append("            , @[estm_vrfy_flg]" ).append("\n"); 
		query.append("            , @[estm_vrfy_desc]" ).append("\n"); 
		query.append("            , @[wo_vrfy_desc]" ).append("\n"); 
		query.append("            , @[inv_rgst_no]" ).append("\n"); 
		query.append("            , @[inv_curr_cd]" ).append("\n"); 
		query.append("            , @[expn_max_prmt_rto]" ).append("\n"); 
		query.append("            , @[mlt_wo_curr_flg]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        )" ).append("\n"); 

	}
}