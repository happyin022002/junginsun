/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : TesAdvanceAuditDBDAOTesInvoiceConfirmRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.28
*@LastModifier : 최종혁
*@LastVersion : 1.0
* 2015.08.28 최종혁
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.tesadvanceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CJH
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TesAdvanceAuditDBDAOTesInvoiceConfirmRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TesInvoiceConfirm
	  * </pre>
	  */
	public TesAdvanceAuditDBDAOTesInvoiceConfirmRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("s_inv_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_from_inv_cfm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_to_inv_cfm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_inv_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.tesadvanceaudit.integration").append("\n"); 
		query.append("FileName : TesAdvanceAuditDBDAOTesInvoiceConfirmRSQL").append("\n"); 
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
		query.append("SELECT   " ).append("\n"); 
		query.append("    RHQ_CD" ).append("\n"); 
		query.append("  , INV_OFC_CD" ).append("\n"); 
		query.append("  , COST_OFC_CD" ).append("\n"); 
		query.append("  , TML_INV_TP_CD" ).append("\n"); 
		query.append("  , YD_CD" ).append("\n"); 
		query.append("  , VNDR_SEQ" ).append("\n"); 
		query.append("  , INV_NO" ).append("\n"); 
		query.append("  , EXPN_AUD_SEQ" ).append("\n"); 
		query.append("  , TO_CHAR(ISS_DT, 'YYYY-MM-DD') AS ISS_DT" ).append("\n"); 
		query.append("  , TO_CHAR(INV_CFM_DT, 'YYYY-MM-DD') AS INV_CFM_DT" ).append("\n"); 
		query.append("  , VSL_CD" ).append("\n"); 
		query.append("  , SKD_VOY_NO" ).append("\n"); 
		query.append("  , SKD_DIR_CD" ).append("\n"); 
		query.append("  , VSL_CD || SKD_VOY_NO || SKD_DIR_CD AS VVD" ).append("\n"); 
		query.append("  , IO_BND_CD" ).append("\n"); 
		query.append("  , ATB_DT" ).append("\n"); 
		query.append("  , FM_PRD_DT" ).append("\n"); 
		query.append("  , TO_PRD_DT" ).append("\n"); 
		query.append("  , BAT_VOL_RSLT_CD" ).append("\n"); 
		query.append("  , BAT_AMT_RSLT_CD" ).append("\n"); 
		query.append("  , BAT_ESTM_VOL_RSLT_CD" ).append("\n"); 
		query.append("  , EXPN_AUD_STS_CD" ).append("\n"); 
		query.append("  , (SELECT CICD.INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL CICD WHERE CICD.INTG_CD_ID = 'CD03348' AND CICD.INTG_CD_VAL_CTNT = EXPN_AUD_STS_CD) AS EXPN_AUD_STS_NM" ).append("\n"); 
		query.append("FROM EAS_TML_AUD" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("  AND NVL(AUTO_EXPN_AUD_STS_CD,' ') <> 'X'" ).append("\n"); 
		query.append("  -- 1. RHQ" ).append("\n"); 
		query.append("#if (${s_rhq_ofc_cd} != '')" ).append("\n"); 
		query.append("  AND RHQ_CD = @[s_rhq_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("  -- 2. INVOICE OFFICE" ).append("\n"); 
		query.append("#if (${s_inv_ofc_cd} != '')" ).append("\n"); 
		query.append("  AND INV_OFC_CD   = @[s_inv_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("  -- 3. CONFIRM DATE" ).append("\n"); 
		query.append("  AND INV_CFM_DT BETWEEN TO_DATE(REPLACE(@[s_from_inv_cfm_dt],'-',''),'YYYYMMDD') AND TO_DATE(REPLACE(@[s_to_inv_cfm_dt],'-',''),'YYYYMMDD') + 0.99999" ).append("\n"); 
		query.append("  -- 5. INVOICE NO." ).append("\n"); 
		query.append("#if (${s_inv_no} != '')" ).append("\n"); 
		query.append("  AND INV_NO    = @[s_inv_no]" ).append("\n"); 
		query.append("#end  " ).append("\n"); 
		query.append("-- 4. BATCH RESULT " ).append("\n"); 
		query.append("#if (${s_bat_rslt_cd} == 'S')" ).append("\n"); 
		query.append("  AND BAT_VOL_RSLT_CD = 'S' AND BAT_AMT_RSLT_CD = 'S' AND BAT_ESTM_VOL_RSLT_CD = 'S'" ).append("\n"); 
		query.append("#elseif (${s_bat_rslt_cd} == 'F')" ).append("\n"); 
		query.append("  AND (BAT_VOL_RSLT_CD = 'F' OR BAT_AMT_RSLT_CD = 'F' OR BAT_ESTM_VOL_RSLT_CD = 'F')" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}