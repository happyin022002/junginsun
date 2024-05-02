/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : TrsAdvanceAuditDBDAOTrsPreAudCrteListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.22
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.06.22 백형인
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.trsadvanceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author HI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TrsAdvanceAuditDBDAOTrsPreAudCrteListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TrsPreAudCrteList
	  * </pre>
	  */
	public TrsAdvanceAuditDBDAOTrsPreAudCrteListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_cgo_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_expn_aud_tgt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_rhq_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_trsp_crr_mod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_expn_aud_crte_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.trsadvanceaudit.integration").append("\n"); 
		query.append("FileName : TrsAdvanceAuditDBDAOTrsPreAudCrteListRSQL").append("\n"); 
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
		query.append("SELECT 'TRS'                                         AS MDL_CD" ).append("\n"); 
		query.append("     , TRS_COMMON_PKG.TRS_GET_RHQ_OFC_CD(AUD_OFC_CD) AS RHQ_OFC_CD" ).append("\n"); 
		query.append("     , AUD_OFC_CD                                    AS AUD_OFC_CD" ).append("\n"); 
		query.append("     , EXPN_AUD_CRTE_TP_CD" ).append("\n"); 
		query.append("     , CGO_TP_CD" ).append("\n"); 
		query.append("     , TRSP_CRR_MOD_CD" ).append("\n"); 
		query.append("     , (SELECT X.INTG_CD_VAL_DESC FROM COM_INTG_CD_DTL X WHERE  X.INTG_CD_ID = 'CD00794' AND X.INTG_CD_VAL_CTNT = TRSP_CRR_MOD_CD) AS TRSP_CRR_MOD_NM" ).append("\n"); 
		query.append("     , EXPN_AUD_TGT_FLG" ).append("\n"); 
		query.append("     , EXPN_MAX_PRMT_RTO" ).append("\n"); 
		query.append("     , CRE_OFC_CD" ).append("\n"); 
		query.append("     , UPD_USR_ID" ).append("\n"); 
		query.append("     , TO_CHAR(UPD_DT,'YYYY-MM-DD') AS UPD_DT" ).append("\n"); 
		query.append("     , EXPN_PRMT_RTO_RSN" ).append("\n"); 
		query.append("  FROM EAS_TRSP_AUTO_AUD_CRTE" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("    AND EXPN_AUD_CRTE_TP_CD = @[s_expn_aud_crte_tp_cd]" ).append("\n"); 
		query.append("#if (${s_rhq_ofc_cd} !='')" ).append("\n"); 
		query.append("   AND TRS_COMMON_PKG.TRS_GET_RHQ_OFC_CD(AUD_OFC_CD) = @[s_rhq_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append("#if (${s_ofc_cd} !='')" ).append("\n"); 
		query.append("   AND AUD_OFC_CD=@[s_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${s_cgo_tp_cd} !='')" ).append("\n"); 
		query.append("   AND CGO_TP_CD=@[s_cgo_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${s_trsp_crr_mod_cd} !='')" ).append("\n"); 
		query.append("   AND TRSP_CRR_MOD_CD=@[s_trsp_crr_mod_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${s_expn_aud_tgt_flg} != '')    " ).append("\n"); 
		query.append("   AND EXPN_AUD_TGT_FLG = @[s_expn_aud_tgt_flg]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}