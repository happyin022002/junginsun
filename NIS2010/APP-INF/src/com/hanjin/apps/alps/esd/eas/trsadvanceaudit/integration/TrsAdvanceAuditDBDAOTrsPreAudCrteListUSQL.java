/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : TrsAdvanceAuditDBDAOTrsPreAudCrteListUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.19
*@LastModifier : 최종혁
*@LastVersion : 1.0
* 2015.06.19 최종혁
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.trsadvanceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CJH
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TrsAdvanceAuditDBDAOTrsPreAudCrteListUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TrsPreAudCrteList
	  * </pre>
	  */
	public TrsAdvanceAuditDBDAOTrsPreAudCrteListUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("expn_aud_tgt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cgo_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("expn_prmt_rto_rsn",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("trsp_crr_mod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("expn_aud_crte_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("aud_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.trsadvanceaudit.integration").append("\n"); 
		query.append("FileName : TrsAdvanceAuditDBDAOTrsPreAudCrteListUSQL").append("\n"); 
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
		query.append("MERGE INTO EAS_TRSP_AUTO_AUD_CRTE K USING(" ).append("\n"); 
		query.append("        SELECT" ).append("\n"); 
		query.append("           @[aud_ofc_cd]      AS AUD_OFC_CD" ).append("\n"); 
		query.append("          ,@[trsp_crr_mod_cd] AS TRSP_CRR_MOD_CD" ).append("\n"); 
		query.append("          ,@[cgo_tp_cd]       AS CGO_TP_CD" ).append("\n"); 
		query.append("          ,@[expn_aud_crte_tp_cd] AS EXPN_AUD_CRTE_TP_CD" ).append("\n"); 
		query.append("         FROM DUAL " ).append("\n"); 
		query.append("        ) B" ).append("\n"); 
		query.append("        ON( K.AUD_OFC_CD            = B.AUD_OFC_CD" ).append("\n"); 
		query.append("        AND K.TRSP_CRR_MOD_CD       = B.TRSP_CRR_MOD_CD" ).append("\n"); 
		query.append("        AND K.CGO_TP_CD             = B.CGO_TP_CD" ).append("\n"); 
		query.append("        AND K.EXPN_AUD_CRTE_TP_CD   = B.EXPN_AUD_CRTE_TP_CD" ).append("\n"); 
		query.append("        ) " ).append("\n"); 
		query.append("        WHEN MATCHED THEN" ).append("\n"); 
		query.append("        UPDATE" ).append("\n"); 
		query.append("        SET K.EXPN_AUD_TGT_FLG  = DECODE(@[expn_aud_tgt_flg],'0','N','Y')" ).append("\n"); 
		query.append("           ,K.EXPN_MAX_PRMT_RTO = @[expn_max_prmt_rto]" ).append("\n"); 
		query.append("           ,K.EXPN_PRMT_RTO_RSN = @[expn_prmt_rto_rsn]" ).append("\n"); 
		query.append("           ,K.CRE_OFC_CD        = @[cre_ofc_cd]" ).append("\n"); 
		query.append("           ,K.UPD_DT            = SYSDATE" ).append("\n"); 
		query.append("           ,K.UPD_USR_ID        = @[upd_usr_id]" ).append("\n"); 
		query.append("        WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("        INSERT(" ).append("\n"); 
		query.append("             K.AUD_OFC_CD" ).append("\n"); 
		query.append("            ,K.TRSP_CRR_MOD_CD" ).append("\n"); 
		query.append("            ,K.CGO_TP_CD" ).append("\n"); 
		query.append("            ,K.EXPN_AUD_CRTE_TP_CD" ).append("\n"); 
		query.append("            ,K.EXPN_MAX_PRMT_RTO" ).append("\n"); 
		query.append("            ,K.EXPN_AUD_TGT_FLG" ).append("\n"); 
		query.append("            ,K.EXPN_PRMT_RTO_RSN" ).append("\n"); 
		query.append("            ,K.CRE_OFC_CD" ).append("\n"); 
		query.append("            ,K.CRE_USR_ID" ).append("\n"); 
		query.append("            ,K.CRE_DT" ).append("\n"); 
		query.append("            ,K.UPD_USR_ID" ).append("\n"); 
		query.append("            ,K.UPD_DT" ).append("\n"); 
		query.append("        ) VALUES(" ).append("\n"); 
		query.append("             @[aud_ofc_cd]" ).append("\n"); 
		query.append("            ,@[trsp_crr_mod_cd]" ).append("\n"); 
		query.append("            ,@[cgo_tp_cd]" ).append("\n"); 
		query.append("            ,@[expn_aud_crte_tp_cd]" ).append("\n"); 
		query.append("            ,@[expn_max_prmt_rto]" ).append("\n"); 
		query.append("            ,DECODE(@[expn_aud_tgt_flg],'0','N','Y')" ).append("\n"); 
		query.append("            ,@[expn_prmt_rto_rsn]" ).append("\n"); 
		query.append("            ,@[cre_ofc_cd]" ).append("\n"); 
		query.append("            ,@[upd_usr_id]" ).append("\n"); 
		query.append("            ,SYSDATE" ).append("\n"); 
		query.append("            ,@[upd_usr_id]" ).append("\n"); 
		query.append("            ,SYSDATE" ).append("\n"); 
		query.append("        )" ).append("\n"); 

	}
}