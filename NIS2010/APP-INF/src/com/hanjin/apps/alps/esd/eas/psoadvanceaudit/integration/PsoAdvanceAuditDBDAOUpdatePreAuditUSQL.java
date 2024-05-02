/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : PsoAdvanceAuditDBDAOUpdatePreAuditUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.09.21
*@LastModifier : 
*@LastVersion : 1.0
* 2017.09.21 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.psoadvanceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PsoAdvanceAuditDBDAOUpdatePreAuditUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * * 2016.03.25 CHM-201640191 Split02-Auto Audit - Invoice Batch 개발 요청
	  * </pre>
	  */
	public PsoAdvanceAuditDBDAOUpdatePreAuditUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("iss_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("select_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_chg_aud_rslt_rmk",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("s_save_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("so_dtl_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("expn_aud_rslt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("so_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.psoadvanceaudit.integration").append("\n"); 
		query.append("FileName : PsoAdvanceAuditDBDAOUpdatePreAuditUSQL").append("\n"); 
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
		query.append("MERGE INTO EAS_PORT_SO_CFM_INV K USING DUAL" ).append("\n"); 
		query.append("ON( K.ISS_CTY_CD = @[iss_cty_cd]" ).append("\n"); 
		query.append("AND K.SO_SEQ     = @[so_seq]" ).append("\n"); 
		query.append("AND K.SO_DTL_SEQ = @[so_dtl_seq]" ).append("\n"); 
		query.append(") " ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("    UPDATE" ).append("\n"); 
		query.append("    SET UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append("        , UPD_DT = SYSDATE" ).append("\n"); 
		query.append("		, PORT_CHG_AUD_CHK_CD = DECODE(@[s_save_tp_cd], 'C', @[select_flg], PORT_CHG_AUD_CHK_CD)" ).append("\n"); 
		query.append("		, PORT_CHG_AUD_RSLT_RMK = DECODE(@[s_save_tp_cd], 'S', @[port_chg_aud_rslt_rmk], PORT_CHG_AUD_RSLT_RMK)" ).append("\n"); 
		query.append("		, PORT_CHG_AUD_RSLT_USR_ID = DECODE(@[s_save_tp_cd], 'S', @[upd_usr_id], PORT_CHG_AUD_RSLT_USR_ID)" ).append("\n"); 
		query.append("        , ATCH_FILE_LNK_ID = @[atch_file_lnk_id]" ).append("\n"); 
		query.append("        , EXPN_AUD_RSLT_CD = DECODE(@[s_save_tp_cd], 'S', @[expn_aud_rslt_cd], EXPN_AUD_RSLT_CD)" ).append("\n"); 
		query.append("        , PORT_CHG_AUD_DT = DECODE(@[s_save_tp_cd], 'C', SYSDATE, PORT_CHG_AUD_DT) -- Confirm이면 audit dt" ).append("\n"); 
		query.append("        , PORT_CHG_AUD_USR_ID = DECODE(@[s_save_tp_cd], 'C', @[upd_usr_id], PORT_CHG_AUD_USR_ID) -- Confirm이면 audit id" ).append("\n"); 
		query.append(" 	 	, AUD_CURR_CD = @[inv_aud_curr_cd]" ).append("\n"); 
		query.append("		, AUD_DIFF_AMT = @[inv_aud_diff_amt]" ).append("\n"); 
		query.append("	 	, AUD_USD_DIFF_AMT = @[inv_aud_usd_diff_amt]" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("    INSERT(" ).append("\n"); 
		query.append("     K.ISS_CTY_CD" ).append("\n"); 
		query.append("    ,K.SO_SEQ" ).append("\n"); 
		query.append("    ,K.SO_DTL_SEQ" ).append("\n"); 
		query.append("    ,K.PORT_CHG_AUD_CHK_CD" ).append("\n"); 
		query.append("	,K.PORT_CHG_AUD_RSLT_RMK" ).append("\n"); 
		query.append("	,K.PORT_CHG_AUD_RSLT_USR_ID" ).append("\n"); 
		query.append("	,K.ATCH_FILE_LNK_ID" ).append("\n"); 
		query.append("	,K.EXPN_AUD_RSLT_CD" ).append("\n"); 
		query.append("    ,K.CRE_USR_ID" ).append("\n"); 
		query.append("    ,K.CRE_DT" ).append("\n"); 
		query.append("    ,K.UPD_USR_ID" ).append("\n"); 
		query.append("    ,K.UPD_DT" ).append("\n"); 
		query.append("    , K.PORT_CHG_AUD_DT -- Confirm이면 audit dt" ).append("\n"); 
		query.append("    , K.PORT_CHG_AUD_USR_ID -- Confirm이면 audit id" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("    values" ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("      @[iss_cty_cd]" ).append("\n"); 
		query.append("    , @[so_seq]" ).append("\n"); 
		query.append("    , @[so_dtl_seq]" ).append("\n"); 
		query.append("    , DECODE(@[s_save_tp_cd], 'C', @[select_flg])" ).append("\n"); 
		query.append("    , DECODE(@[s_save_tp_cd], 'S', @[port_chg_aud_rslt_rmk])" ).append("\n"); 
		query.append("    , DECODE(@[s_save_tp_cd], 'S', @[upd_usr_id])" ).append("\n"); 
		query.append("	, @[atch_file_lnk_id]" ).append("\n"); 
		query.append("	, DECODE(@[s_save_tp_cd], 'S', @[expn_aud_rslt_cd])" ).append("\n"); 
		query.append("    , @[upd_usr_id]" ).append("\n"); 
		query.append("    , SYSDATE" ).append("\n"); 
		query.append("    , @[upd_usr_id]" ).append("\n"); 
		query.append("    , SYSDATE" ).append("\n"); 
		query.append("    , DECODE(@[s_save_tp_cd], 'C', SYSDATE)  -- Confirm이면 audit dt" ).append("\n"); 
		query.append("    , DECODE(@[s_save_tp_cd], 'C', @[upd_usr_id])  -- Confirm이면 audit id" ).append("\n"); 
		query.append("    )" ).append("\n"); 

	}
}