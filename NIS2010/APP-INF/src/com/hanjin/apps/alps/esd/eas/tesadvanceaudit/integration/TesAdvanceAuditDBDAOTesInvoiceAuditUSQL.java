/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : TesAdvanceAuditDBDAOTesInvoiceAuditUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.09.21
*@LastModifier : 
*@LastVersion : 1.0
* 2017.09.21 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.tesadvanceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TesAdvanceAuditDBDAOTesInvoiceAuditUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TesInvoiceAudit
	  * </pre>
	  */
	public TesAdvanceAuditDBDAOTesInvoiceAuditUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("sel_aud_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("expn_aud_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("expn_aud_rslt_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("s_save_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_cfm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("expn_aud_rslt_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.tesadvanceaudit.integration").append("\n"); 
		query.append("FileName : TesAdvanceAuditDBDAOTesInvoiceAuditUSQL").append("\n"); 
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
		query.append("UPDATE EAS_TML_AUD SET" ).append("\n"); 
		query.append("	   EXPN_AUD_STS_CD		= DECODE(@[s_save_tp_cd], 'C', @[sel_aud_cd], EXPN_AUD_STS_CD)" ).append("\n"); 
		query.append("	 , EXPN_AUD_RSLT_RMK	= DECODE(@[s_save_tp_cd], 'S', @[expn_aud_rslt_rmk], EXPN_AUD_RSLT_RMK)" ).append("\n"); 
		query.append("	 , EXPN_AUD_RSLT_USR_ID	= DECODE(@[s_save_tp_cd], 'S', @[expn_aud_rslt_usr_id], EXPN_AUD_RSLT_USR_ID)" ).append("\n"); 
		query.append("	 , ATCH_FILE_LNK_ID		= @[atch_file_lnk_id]" ).append("\n"); 
		query.append("     , EXPN_AUD_RSLT_CD 	= DECODE(@[s_save_tp_cd], 'S', @[expn_aud_rslt_cd], EXPN_AUD_RSLT_CD)" ).append("\n"); 
		query.append("     , UPD_USR_ID      		= @[upd_usr_id]" ).append("\n"); 
		query.append("     , UPD_DT          		= SYSDATE" ).append("\n"); 
		query.append("	 , AUD_CURR_CD 			= @[inv_aud_curr_cd]" ).append("\n"); 
		query.append("	 , AUD_DIFF_AMT 		= @[inv_aud_diff_amt]" ).append("\n"); 
		query.append("	 , AUD_USD_DIFF_AMT 	= @[inv_aud_usd_diff_amt]" ).append("\n"); 
		query.append(" WHERE INV_NO          		= @[inv_no]" ).append("\n"); 
		query.append("   AND VNDR_SEQ        		= @[vndr_seq]" ).append("\n"); 
		query.append("   AND EXPN_AUD_SEQ    		= @[expn_aud_seq]" ).append("\n"); 
		query.append("   AND TO_CHAR(INV_CFM_DT, 'YYYYMMDDHH24MISS') = @[inv_cfm_dt]" ).append("\n"); 

	}
}