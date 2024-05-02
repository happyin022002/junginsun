/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SurchargeDBDAOPriScgPrfVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.25
*@LastModifier : 
*@LastVersion : 1.0
* 2015.11.25 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.surcharge.surcharge.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SurchargeDBDAOPriScgPrfVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public SurchargeDBDAOPriScgPrfVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.surcharge.surcharge.integration").append("\n"); 
		query.append("FileName : SurchargeDBDAOPriScgPrfVORSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("	SVC_SCP_CD" ).append("\n"); 
		query.append(",	CHG_CD" ).append("\n"); 
		query.append(",	FLT_PCT_TP_CD" ).append("\n"); 
		query.append(",	PCT_BSE_CD" ).append("\n"); 
		query.append(",	SUB_TRD_USE_FLG" ).append("\n"); 
		query.append(",   (SELECT NVL(SUM(CASE" ).append("\n"); 
		query.append("                   WHEN SUB_TRD_CD IS NULL THEN 0" ).append("\n"); 
		query.append("                   ELSE 1" ).append("\n"); 
		query.append("                END), 0)" ).append("\n"); 
		query.append("       FROM PRI_SCG_RT " ).append("\n"); 
		query.append("      WHERE SVC_SCP_CD = @[svc_scp_cd] " ).append("\n"); 
		query.append("        AND CHG_CD = @[chg_cd]" ).append("\n"); 
		query.append("        AND DELT_FLG = 'N') AS SUB_TRD_CNT" ).append("\n"); 
		query.append(",	SLAN_USE_FLG" ).append("\n"); 
		query.append(",   (SELECT NVL(SUM(CASE" ).append("\n"); 
		query.append("                   WHEN VSL_SLAN_CD IS NULL THEN 0" ).append("\n"); 
		query.append("                   ELSE 1" ).append("\n"); 
		query.append("                END), 0)" ).append("\n"); 
		query.append("       FROM PRI_SCG_RT " ).append("\n"); 
		query.append("      WHERE SVC_SCP_CD = @[svc_scp_cd] " ).append("\n"); 
		query.append("        AND CHG_CD = @[chg_cd]" ).append("\n"); 
		query.append("        AND DELT_FLG = 'N') AS VSL_SLAN_CNT" ).append("\n"); 
		query.append(",	POR_USE_FLG" ).append("\n"); 
		query.append(",   (SELECT NVL(SUM(CASE" ).append("\n"); 
		query.append("                   WHEN POR_DEF_CD IS NULL THEN 0" ).append("\n"); 
		query.append("                   ELSE 1" ).append("\n"); 
		query.append("                END), 0)" ).append("\n"); 
		query.append("       FROM PRI_SCG_RT " ).append("\n"); 
		query.append("      WHERE SVC_SCP_CD = @[svc_scp_cd] " ).append("\n"); 
		query.append("        AND CHG_CD = @[chg_cd]" ).append("\n"); 
		query.append("        AND DELT_FLG = 'N') AS POR_DEF_CNT" ).append("\n"); 
		query.append(",	POL_USE_FLG" ).append("\n"); 
		query.append(",   (SELECT NVL(SUM(CASE" ).append("\n"); 
		query.append("                   WHEN POL_DEF_CD IS NULL THEN 0" ).append("\n"); 
		query.append("                   ELSE 1" ).append("\n"); 
		query.append("                END), 0)" ).append("\n"); 
		query.append("       FROM PRI_SCG_RT " ).append("\n"); 
		query.append("      WHERE SVC_SCP_CD = @[svc_scp_cd] " ).append("\n"); 
		query.append("        AND CHG_CD = @[chg_cd]" ).append("\n"); 
		query.append("        AND DELT_FLG = 'N') AS POL_DEF_CNT" ).append("\n"); 
		query.append(",	POD_USE_FLG" ).append("\n"); 
		query.append(",   (SELECT NVL(SUM(CASE" ).append("\n"); 
		query.append("                   WHEN POD_DEF_CD IS NULL THEN 0" ).append("\n"); 
		query.append("                   ELSE 1" ).append("\n"); 
		query.append("                END), 0)" ).append("\n"); 
		query.append("       FROM PRI_SCG_RT " ).append("\n"); 
		query.append("      WHERE SVC_SCP_CD = @[svc_scp_cd] " ).append("\n"); 
		query.append("        AND CHG_CD = @[chg_cd]" ).append("\n"); 
		query.append("        AND DELT_FLG = 'N') AS POD_DEF_CNT" ).append("\n"); 
		query.append(",	DEL_USE_FLG" ).append("\n"); 
		query.append(",   (SELECT NVL(SUM(CASE" ).append("\n"); 
		query.append("                   WHEN DEL_DEF_CD IS NULL THEN 0" ).append("\n"); 
		query.append("                   ELSE 1" ).append("\n"); 
		query.append("                END), 0)" ).append("\n"); 
		query.append("       FROM PRI_SCG_RT " ).append("\n"); 
		query.append("      WHERE SVC_SCP_CD = @[svc_scp_cd] " ).append("\n"); 
		query.append("        AND CHG_CD = @[chg_cd]" ).append("\n"); 
		query.append("        AND DELT_FLG = 'N') AS DEL_DEF_CNT" ).append("\n"); 
		query.append(",	IMDG_CLSS_USE_FLG" ).append("\n"); 
		query.append(",   (SELECT NVL(SUM(CASE" ).append("\n"); 
		query.append("                   WHEN SCG_IMDG_CLSS_CD IS NULL THEN 0" ).append("\n"); 
		query.append("                   ELSE 1" ).append("\n"); 
		query.append("                END), 0)" ).append("\n"); 
		query.append("       FROM PRI_SCG_RT " ).append("\n"); 
		query.append("      WHERE SVC_SCP_CD = @[svc_scp_cd] " ).append("\n"); 
		query.append("        AND CHG_CD = @[chg_cd]" ).append("\n"); 
		query.append("        AND DELT_FLG = 'N') AS SCG_IMDG_CLSS_CNT" ).append("\n"); 
		query.append(",	TS_PORT_USE_FLG" ).append("\n"); 
		query.append(",   (SELECT NVL(SUM(CASE" ).append("\n"); 
		query.append("                   WHEN TS_PORT_CD IS NULL THEN 0" ).append("\n"); 
		query.append("                   ELSE 1" ).append("\n"); 
		query.append("                END), 0)" ).append("\n"); 
		query.append("       FROM PRI_SCG_RT " ).append("\n"); 
		query.append("      WHERE SVC_SCP_CD = @[svc_scp_cd] " ).append("\n"); 
		query.append("        AND CHG_CD = @[chg_cd]" ).append("\n"); 
		query.append("        AND DELT_FLG = 'N') AS TS_PORT_CNT" ).append("\n"); 
		query.append(",	TML_USE_FLG" ).append("\n"); 
		query.append(",   (SELECT NVL(SUM(CASE" ).append("\n"); 
		query.append("                   WHEN TML_CD IS NULL THEN 0" ).append("\n"); 
		query.append("                   ELSE 1" ).append("\n"); 
		query.append("                END), 0)" ).append("\n"); 
		query.append("       FROM PRI_SCG_RT " ).append("\n"); 
		query.append("      WHERE SVC_SCP_CD = @[svc_scp_cd] " ).append("\n"); 
		query.append("        AND CHG_CD = @[chg_cd]" ).append("\n"); 
		query.append("        AND DELT_FLG = 'N') AS TML_CNT" ).append("\n"); 
		query.append(",	TRNS_MOD_USE_FLG" ).append("\n"); 
		query.append(",   (SELECT NVL(SUM(CASE" ).append("\n"); 
		query.append("                   WHEN ORG_TRSP_MOD_CD IS NULL AND DEST_TRSP_MOD_CD IS NULL THEN 0" ).append("\n"); 
		query.append("                   ELSE 1" ).append("\n"); 
		query.append("                END), 0)" ).append("\n"); 
		query.append("       FROM PRI_SCG_RT " ).append("\n"); 
		query.append("      WHERE SVC_SCP_CD = @[svc_scp_cd] " ).append("\n"); 
		query.append("        AND CHG_CD = @[chg_cd]" ).append("\n"); 
		query.append("        AND DELT_FLG = 'N') AS TRNS_MOD_CNT" ).append("\n"); 
		query.append(",	USA_SVC_MOD_USE_FLG" ).append("\n"); 
		query.append(",   (SELECT NVL(SUM(CASE" ).append("\n"); 
		query.append("                   WHEN USA_SVC_MOD_CD IS NULL THEN 0" ).append("\n"); 
		query.append("                   ELSE 1" ).append("\n"); 
		query.append("                END), 0)" ).append("\n"); 
		query.append("       FROM PRI_SCG_RT " ).append("\n"); 
		query.append("      WHERE SVC_SCP_CD = @[svc_scp_cd] " ).append("\n"); 
		query.append("        AND CHG_CD = @[chg_cd]" ).append("\n"); 
		query.append("        AND DELT_FLG = 'N') AS USA_SVC_MOD_CNT" ).append("\n"); 
		query.append(",	RCV_DE_TERM_USE_FLG" ).append("\n"); 
		query.append(",   (SELECT NVL(SUM(CASE" ).append("\n"); 
		query.append("                   WHEN PRC_RCV_TERM_CD IS NULL AND PRC_DE_TERM_CD IS NULL THEN 0" ).append("\n"); 
		query.append("                   ELSE 1" ).append("\n"); 
		query.append("                END), 0)" ).append("\n"); 
		query.append("       FROM PRI_SCG_RT " ).append("\n"); 
		query.append("      WHERE SVC_SCP_CD = @[svc_scp_cd] " ).append("\n"); 
		query.append("        AND CHG_CD = @[chg_cd]" ).append("\n"); 
		query.append("        AND DELT_FLG = 'N') AS RCV_DE_TERM_CNT" ).append("\n"); 
		query.append(",	HNGR_BAR_USE_FLG" ).append("\n"); 
		query.append(",   (SELECT NVL(SUM(CASE" ).append("\n"); 
		query.append("                   WHEN PRC_HNGR_BAR_TP_CD IS NULL THEN 0" ).append("\n"); 
		query.append("                   ELSE 1" ).append("\n"); 
		query.append("                END), 0)" ).append("\n"); 
		query.append("       FROM PRI_SCG_RT " ).append("\n"); 
		query.append("      WHERE SVC_SCP_CD = @[svc_scp_cd] " ).append("\n"); 
		query.append("        AND CHG_CD = @[chg_cd]" ).append("\n"); 
		query.append("        AND DELT_FLG = 'N') AS HNGR_BAR_CNT" ).append("\n"); 
		query.append(",	DIR_CALL_USE_FLG" ).append("\n"); 
		query.append(",   (SELECT NVL(SUM(CASE" ).append("\n"); 
		query.append("                   WHEN DIR_CALL_FLG IS NULL THEN 0" ).append("\n"); 
		query.append("                   ELSE 1" ).append("\n"); 
		query.append("                END), 0)" ).append("\n"); 
		query.append("       FROM PRI_SCG_RT " ).append("\n"); 
		query.append("      WHERE SVC_SCP_CD = @[svc_scp_cd] " ).append("\n"); 
		query.append("        AND CHG_CD = @[chg_cd]" ).append("\n"); 
		query.append("        AND DELT_FLG = 'N') AS DIR_CALL_CNT" ).append("\n"); 
		query.append(",	CGO_WGT_USE_FLG" ).append("\n"); 
		query.append(",   (SELECT NVL(SUM(CASE" ).append("\n"); 
		query.append("                   WHEN MIN_CGO_WGT IS NULL AND MAX_CGO_WGT IS NULL THEN 0" ).append("\n"); 
		query.append("                   ELSE 1" ).append("\n"); 
		query.append("                END), 0)" ).append("\n"); 
		query.append("       FROM PRI_SCG_RT " ).append("\n"); 
		query.append("      WHERE SVC_SCP_CD = @[svc_scp_cd] " ).append("\n"); 
		query.append("        AND CHG_CD = @[chg_cd]" ).append("\n"); 
		query.append("        AND DELT_FLG = 'N') AS CGO_WGT_CNT" ).append("\n"); 
		query.append(",	CMDT_USE_FLG" ).append("\n"); 
		query.append(",   (SELECT NVL(SUM(CASE" ).append("\n"); 
		query.append("                   WHEN CMDT_CD IS NULL THEN 0" ).append("\n"); 
		query.append("                   ELSE 1" ).append("\n"); 
		query.append("                END), 0)" ).append("\n"); 
		query.append("       FROM PRI_SCG_RT " ).append("\n"); 
		query.append("      WHERE SVC_SCP_CD = @[svc_scp_cd] " ).append("\n"); 
		query.append("        AND CHG_CD = @[chg_cd]" ).append("\n"); 
		query.append("        AND DELT_FLG = 'N') AS CMDT_CNT" ).append("\n"); 
		query.append(",	GRI_CMDT_USE_FLG" ).append("\n"); 
		query.append(",   (SELECT NVL(SUM(CASE" ).append("\n"); 
		query.append("                   WHEN SCG_GRP_CMDT_CD IS NULL THEN 0" ).append("\n"); 
		query.append("                   ELSE 1" ).append("\n"); 
		query.append("                END), 0)" ).append("\n"); 
		query.append("       FROM PRI_SCG_RT " ).append("\n"); 
		query.append("      WHERE SVC_SCP_CD = @[svc_scp_cd] " ).append("\n"); 
		query.append("        AND CHG_CD = @[chg_cd]" ).append("\n"); 
		query.append("        AND DELT_FLG = 'N') AS GRI_CMDT_CNT" ).append("\n"); 
		query.append(",	SOC_USE_FLG" ).append("\n"); 
		query.append(",   (SELECT NVL(SUM(CASE" ).append("\n"); 
		query.append("                   WHEN SOC_FLG IS NULL THEN 0" ).append("\n"); 
		query.append("                   ELSE 1" ).append("\n"); 
		query.append("                END), 0)" ).append("\n"); 
		query.append("       FROM PRI_SCG_RT " ).append("\n"); 
		query.append("      WHERE SVC_SCP_CD = @[svc_scp_cd] " ).append("\n"); 
		query.append("        AND CHG_CD = @[chg_cd]" ).append("\n"); 
		query.append("        AND DELT_FLG = 'N') AS SOC_CNT" ).append("\n"); 
		query.append(",   IO_GA_USE_FLG" ).append("\n"); 
		query.append(",   (SELECT NVL(SUM(CASE" ).append("\n"); 
		query.append("                   WHEN IO_GA_CD IS NULL THEN 0" ).append("\n"); 
		query.append("                   ELSE 1" ).append("\n"); 
		query.append("                END), 0)" ).append("\n"); 
		query.append("       FROM PRI_SCG_RT " ).append("\n"); 
		query.append("      WHERE SVC_SCP_CD = @[svc_scp_cd] " ).append("\n"); 
		query.append("        AND CHG_CD = @[chg_cd]" ).append("\n"); 
		query.append("        AND DELT_FLG = 'N') AS IG_GA_CNT" ).append("\n"); 
		query.append(",   CNL_TZ_FLG" ).append("\n"); 
		query.append(",   (SELECT NVL(SUM(CASE" ).append("\n"); 
		query.append("                   WHEN CNL_TZ_CD IS NULL THEN 0" ).append("\n"); 
		query.append("                   ELSE 1" ).append("\n"); 
		query.append("                END), 0)" ).append("\n"); 
		query.append("       FROM PRI_SCG_RT" ).append("\n"); 
		query.append("      WHERE SVC_SCP_CD = @[svc_scp_cd] " ).append("\n"); 
		query.append("        AND CHG_CD = @[chg_cd]" ).append("\n"); 
		query.append("        AND DELT_FLG = 'N') AS CNL_TZ_CNT" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	TO_CHAR(CRE_DT, 'YYYY-MM-DD') AS CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	TO_CHAR(UPD_DT, 'YYYY-MM-DD') AS UPD_DT" ).append("\n"); 
		query.append(",   ESVC_USE_FLG" ).append("\n"); 
		query.append(",   (SELECT NVL(SUM(CASE" ).append("\n"); 
		query.append("                   WHEN BKG_ESVC_TP_CD IS NULL THEN 0" ).append("\n"); 
		query.append("                   ELSE 1" ).append("\n"); 
		query.append("                END), 0)" ).append("\n"); 
		query.append("       FROM PRI_SCG_RT" ).append("\n"); 
		query.append("      WHERE SVC_SCP_CD = @[svc_scp_cd] " ).append("\n"); 
		query.append("        AND CHG_CD = @[chg_cd]" ).append("\n"); 
		query.append("        AND DELT_FLG = 'N') AS ESVC_CNT" ).append("\n"); 
		query.append("FROM PRI_SCG_PRF" ).append("\n"); 
		query.append("WHERE	SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND	CHG_CD = @[chg_cd]" ).append("\n"); 

	}
}