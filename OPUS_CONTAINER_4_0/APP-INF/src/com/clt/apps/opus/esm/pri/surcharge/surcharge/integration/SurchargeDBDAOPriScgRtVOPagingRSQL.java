/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SurchargeDBDAOPriScgRtVOPagingRSQL.java
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

public class SurchargeDBDAOPriScgRtVOPagingRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SurchargeDBDAOPriScgRtVORSQL의 페이징
	  * </pre>
	  */
	public SurchargeDBDAOPriScgRtVOPagingRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("startpage",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_def_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_def_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("endpage",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("por_def_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_def_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scg_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_esvc_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scg_imdg_clss_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.surcharge.surcharge.integration").append("\n"); 
		query.append("FileName : SurchargeDBDAOPriScgRtVOPagingRSQL").append("\n"); 
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
		query.append("       SVC_SCP_CD" ).append("\n"); 
		query.append("     , CHG_CD" ).append("\n"); 
		query.append("     , SCG_SEQ" ).append("\n"); 
		query.append("     , EFF_DT" ).append("\n"); 
		query.append("     , EXP_DT" ).append("\n"); 
		query.append("     , SUB_TRD_CD" ).append("\n"); 
		query.append("     , VSL_SLAN_CD" ).append("\n"); 
		query.append("     , POR_TP_CD" ).append("\n"); 
		query.append("     , POR_DEF_CD" ).append("\n"); 
		query.append("     , POL_TP_CD" ).append("\n"); 
		query.append("     , POL_DEF_CD" ).append("\n"); 
		query.append("     , POD_TP_CD" ).append("\n"); 
		query.append("     , POD_DEF_CD" ).append("\n"); 
		query.append("     , DEL_TP_CD" ).append("\n"); 
		query.append("     , DEL_DEF_CD" ).append("\n"); 
		query.append("     , TS_PORT_CD" ).append("\n"); 
		query.append("     , TML_CD" ).append("\n"); 
		query.append("     , ORG_TRSP_MOD_CD" ).append("\n"); 
		query.append("     , DEST_TRSP_MOD_CD" ).append("\n"); 
		query.append("     , USA_SVC_MOD_CD" ).append("\n"); 
		query.append("     , PRC_RCV_TERM_CD" ).append("\n"); 
		query.append("     , PRC_DE_TERM_CD" ).append("\n"); 
		query.append("     , PRC_HNGR_BAR_TP_CD" ).append("\n"); 
		query.append("     , DIR_CALL_FLG" ).append("\n"); 
		query.append("     , MIN_CGO_WGT" ).append("\n"); 
		query.append("     , MAX_CGO_WGT" ).append("\n"); 
		query.append("     , CMDT_CD" ).append("\n"); 
		query.append("     , SCG_GRP_CMDT_CD" ).append("\n"); 
		query.append("     , PRC_CGO_TP_CD" ).append("\n"); 
		query.append("     , SCG_IMDG_CLSS_CD" ).append("\n"); 
		query.append("     , RAT_UT_CD" ).append("\n"); 
		query.append("     , CURR_CD" ).append("\n"); 
		query.append("     , SCG_AMT" ).append("\n"); 
		query.append("     , PAY_TERM_CD" ).append("\n"); 
		query.append("     , WDR_FLG" ).append("\n"); 
		query.append("     , SOC_FLG" ).append("\n"); 
		query.append("     , IO_GA_CD" ).append("\n"); 
		query.append("     , DELT_FLG" ).append("\n"); 
		query.append("     , SCG_RMK" ).append("\n"); 
		query.append("     , CNL_TZ_CD" ).append("\n"); 
		query.append("     , CRE_USR_ID" ).append("\n"); 
		query.append("     , CRE_DT" ).append("\n"); 
		query.append("     , UPD_USR_ID" ).append("\n"); 
		query.append("     , UPD_DT" ).append("\n"); 
		query.append("     , LVL1" ).append("\n"); 
		query.append("     , LVL2" ).append("\n"); 
		query.append("     , LVL3" ).append("\n"); 
		query.append("     , LVL4" ).append("\n"); 
		query.append("     , BKG_ESVC_TP_CD" ).append("\n"); 
		query.append("     , NO" ).append("\n"); 
		query.append("     " ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("       A.SVC_SCP_CD" ).append("\n"); 
		query.append("     , A.CHG_CD" ).append("\n"); 
		query.append("     , A.SCG_SEQ" ).append("\n"); 
		query.append("     , A.EFF_DT" ).append("\n"); 
		query.append("     , A.EXP_DT" ).append("\n"); 
		query.append("     , A.SUB_TRD_CD" ).append("\n"); 
		query.append("     , A.VSL_SLAN_CD" ).append("\n"); 
		query.append("     , A.POR_TP_CD" ).append("\n"); 
		query.append("     , A.POR_DEF_CD" ).append("\n"); 
		query.append("     , A.POL_TP_CD" ).append("\n"); 
		query.append("     , A.POL_DEF_CD" ).append("\n"); 
		query.append("     , A.POD_TP_CD" ).append("\n"); 
		query.append("     , A.POD_DEF_CD" ).append("\n"); 
		query.append("     , A.DEL_TP_CD" ).append("\n"); 
		query.append("     , A.DEL_DEF_CD" ).append("\n"); 
		query.append("     , A.TS_PORT_CD" ).append("\n"); 
		query.append("     , A.TML_CD" ).append("\n"); 
		query.append("     , A.ORG_TRSP_MOD_CD" ).append("\n"); 
		query.append("     , A.DEST_TRSP_MOD_CD" ).append("\n"); 
		query.append("     , A.USA_SVC_MOD_CD" ).append("\n"); 
		query.append("     , A.PRC_RCV_TERM_CD" ).append("\n"); 
		query.append("     , A.PRC_DE_TERM_CD" ).append("\n"); 
		query.append("     , A.PRC_HNGR_BAR_TP_CD" ).append("\n"); 
		query.append("     , A.DIR_CALL_FLG" ).append("\n"); 
		query.append("     , A.MIN_CGO_WGT" ).append("\n"); 
		query.append("     , A.MAX_CGO_WGT" ).append("\n"); 
		query.append("     , A.CMDT_CD" ).append("\n"); 
		query.append("     , A.SCG_GRP_CMDT_CD" ).append("\n"); 
		query.append("     , A.PRC_CGO_TP_CD" ).append("\n"); 
		query.append("     , A.SCG_IMDG_CLSS_CD" ).append("\n"); 
		query.append("     , A.RAT_UT_CD" ).append("\n"); 
		query.append("     , A.CURR_CD" ).append("\n"); 
		query.append("     , A.SCG_AMT" ).append("\n"); 
		query.append("     , A.PAY_TERM_CD" ).append("\n"); 
		query.append("     , A.WDR_FLG" ).append("\n"); 
		query.append("     , A.SOC_FLG" ).append("\n"); 
		query.append("     , A.IO_GA_CD" ).append("\n"); 
		query.append("     , A.DELT_FLG" ).append("\n"); 
		query.append("     , A.SCG_RMK" ).append("\n"); 
		query.append("     , A.CNL_TZ_CD" ).append("\n"); 
		query.append("     , A.CRE_USR_ID" ).append("\n"); 
		query.append("     , A.CRE_DT" ).append("\n"); 
		query.append("     , A.UPD_USR_ID" ).append("\n"); 
		query.append("     , A.UPD_DT" ).append("\n"); 
		query.append("     , A.LVL1" ).append("\n"); 
		query.append("     , A.LVL2" ).append("\n"); 
		query.append("     , A.LVL3" ).append("\n"); 
		query.append("     , A.LVL4" ).append("\n"); 
		query.append("     , A.BKG_ESVC_TP_CD" ).append("\n"); 
		query.append("     , ROW_NUMBER() OVER (ORDER BY LVL1, LVL2, LVL3, LVL4, SUB_TRD_CD, VSL_SLAN_CD, TS_PORT_CD, DIR_CALL_FLG, TML_CD, ORG_TRSP_MOD_CD, DEST_TRSP_MOD_CD, USA_SVC_MOD_CD, PRC_RCV_TERM_CD" ).append("\n"); 
		query.append("     , PRC_DE_TERM_CD, PRC_HNGR_BAR_TP_CD, MIN_CGO_WGT, MAX_CGO_WGT, CMDT_CD, SCG_GRP_CMDT_CD, SOC_FLG, IO_GA_CD, RAT_UT_CD, PRC_CGO_TP_CD, SCG_IMDG_CLSS_CD, CURR_CD" ).append("\n"); 
		query.append("     , SCG_AMT, PAY_TERM_CD) NO" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT A.SVC_SCP_CD" ).append("\n"); 
		query.append("     , A.CHG_CD" ).append("\n"); 
		query.append("     , A.SCG_SEQ" ).append("\n"); 
		query.append("     , TO_CHAR(A.EFF_DT, 'YYYY-MM-DD') AS EFF_DT" ).append("\n"); 
		query.append("     , DECODE(TO_CHAR(A.EXP_DT, 'YYYYMMDD'), '99991231', NULL, TO_CHAR(A.EXP_DT, 'YYYY-MM-DD')) AS EXP_DT" ).append("\n"); 
		query.append("     , A.SUB_TRD_CD" ).append("\n"); 
		query.append("     , A.VSL_SLAN_CD" ).append("\n"); 
		query.append("     , A.POR_TP_CD" ).append("\n"); 
		query.append("     , A.POR_DEF_CD" ).append("\n"); 
		query.append("     , A.POL_TP_CD" ).append("\n"); 
		query.append("     , A.POL_DEF_CD" ).append("\n"); 
		query.append("     , A.POD_TP_CD" ).append("\n"); 
		query.append("     , A.POD_DEF_CD" ).append("\n"); 
		query.append("     , A.DEL_TP_CD" ).append("\n"); 
		query.append("     , A.DEL_DEF_CD" ).append("\n"); 
		query.append("     , A.TS_PORT_CD" ).append("\n"); 
		query.append("     , A.TML_CD" ).append("\n"); 
		query.append("     , A.ORG_TRSP_MOD_CD" ).append("\n"); 
		query.append("     , A.DEST_TRSP_MOD_CD" ).append("\n"); 
		query.append("     , A.USA_SVC_MOD_CD" ).append("\n"); 
		query.append("     , A.PRC_RCV_TERM_CD" ).append("\n"); 
		query.append("     , A.PRC_DE_TERM_CD" ).append("\n"); 
		query.append("     , A.PRC_HNGR_BAR_TP_CD" ).append("\n"); 
		query.append("     , A.DIR_CALL_FLG" ).append("\n"); 
		query.append("     , A.MIN_CGO_WGT" ).append("\n"); 
		query.append("     , A.MAX_CGO_WGT" ).append("\n"); 
		query.append("     , A.CMDT_CD" ).append("\n"); 
		query.append("     , A.SCG_GRP_CMDT_CD" ).append("\n"); 
		query.append("     , A.PRC_CGO_TP_CD" ).append("\n"); 
		query.append("     , A.SCG_IMDG_CLSS_CD" ).append("\n"); 
		query.append("     , A.RAT_UT_CD" ).append("\n"); 
		query.append("     , A.CURR_CD" ).append("\n"); 
		query.append("     , A.SCG_AMT" ).append("\n"); 
		query.append("     , A.PAY_TERM_CD" ).append("\n"); 
		query.append("     , DECODE(A.WDR_FLG, 'N', '0', '1') AS WDR_FLG" ).append("\n"); 
		query.append("     , A.SOC_FLG" ).append("\n"); 
		query.append("     , A.IO_GA_CD" ).append("\n"); 
		query.append("     , A.DELT_FLG" ).append("\n"); 
		query.append("     , A.SCG_RMK" ).append("\n"); 
		query.append("     , A.CNL_TZ_CD" ).append("\n"); 
		query.append("     , A.CRE_USR_ID" ).append("\n"); 
		query.append("     , A.CRE_DT" ).append("\n"); 
		query.append("     , A.UPD_USR_ID" ).append("\n"); 
		query.append("     , TO_CHAR(A.UPD_DT, 'YYYY-MM-DD') AS UPD_DT" ).append("\n"); 
		query.append("     , CASE WHEN A.POR_TP_CD IS NULL THEN 1" ).append("\n"); 
		query.append("            WHEN A.POR_TP_CD = 'C'   THEN 2" ).append("\n"); 
		query.append("            WHEN A.POR_TP_CD = 'G'   THEN 3" ).append("\n"); 
		query.append("            WHEN A.POR_TP_CD = 'R'   THEN 4" ).append("\n"); 
		query.append("            WHEN A.POR_TP_CD = 'L'   THEN 5" ).append("\n"); 
		query.append("       END AS LVL1" ).append("\n"); 
		query.append("     , CASE WHEN A.POL_TP_CD IS NULL THEN 1" ).append("\n"); 
		query.append("            WHEN A.POL_TP_CD = 'C'   THEN 2" ).append("\n"); 
		query.append("            WHEN A.POL_TP_CD = 'G'   THEN 3" ).append("\n"); 
		query.append("            WHEN A.POL_TP_CD = 'R'   THEN 4" ).append("\n"); 
		query.append("            WHEN A.POL_TP_CD = 'L'   THEN 5" ).append("\n"); 
		query.append("       END AS LVL2" ).append("\n"); 
		query.append("     , CASE WHEN A.POD_TP_CD IS NULL THEN 1" ).append("\n"); 
		query.append("            WHEN A.POD_TP_CD = 'C'   THEN 2" ).append("\n"); 
		query.append("            WHEN A.POD_TP_CD = 'G'   THEN 3" ).append("\n"); 
		query.append("            WHEN A.POD_TP_CD = 'R'   THEN 4" ).append("\n"); 
		query.append("            WHEN A.POD_TP_CD = 'L'   THEN 5" ).append("\n"); 
		query.append("       END AS LVL3" ).append("\n"); 
		query.append("     , CASE WHEN A.DEL_TP_CD IS NULL THEN 1" ).append("\n"); 
		query.append("            WHEN A.DEL_TP_CD = 'C'   THEN 2" ).append("\n"); 
		query.append("            WHEN A.DEL_TP_CD = 'G'   THEN 3" ).append("\n"); 
		query.append("            WHEN A.DEL_TP_CD = 'R'   THEN 4" ).append("\n"); 
		query.append("            WHEN A.DEL_TP_CD = 'L'   THEN 5" ).append("\n"); 
		query.append("       END AS LVL4 " ).append("\n"); 
		query.append("     , A.BKG_ESVC_TP_CD" ).append("\n"); 
		query.append("  FROM PRI_SCG_RT A" ).append("\n"); 
		query.append("#if (${por_def_cd} != '')" ).append("\n"); 
		query.append("     , (SELECT POR_DEF_CD" ).append("\n"); 
		query.append("          FROM (" ).append("\n"); 
		query.append("                SELECT DISTINCT(LOC_CD) AS POR_DEF_CD" ).append("\n"); 
		query.append("                  FROM MDM_LOCATION" ).append("\n"); 
		query.append("                 WHERE DECODE(LENGTH(@[por_def_cd]), 5, LOC_CD, 3, RGN_CD, 2, CNT_CD) = @[por_def_cd]" ).append("\n"); 
		query.append("                   AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("                UNION" ).append("\n"); 
		query.append("                SELECT DISTINCT(RGN_CD) AS POR_DEF_CD" ).append("\n"); 
		query.append("                  FROM MDM_LOCATION" ).append("\n"); 
		query.append("                 WHERE DECODE(LENGTH(@[por_def_cd]), 5, LOC_CD, 3, RGN_CD, 2, CNT_CD) = @[por_def_cd]" ).append("\n"); 
		query.append("                   AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("                UNION" ).append("\n"); 
		query.append("                SELECT DISTINCT(CNT_CD) AS POR_DEF_CD" ).append("\n"); 
		query.append("                  FROM MDM_LOCATION" ).append("\n"); 
		query.append("                 WHERE DECODE(LENGTH(@[por_def_cd]), 5, LOC_CD, 3, RGN_CD, 2, CNT_CD) = @[por_def_cd]" ).append("\n"); 
		query.append("                   AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("                UNION " ).append("\n"); 
		query.append("                SELECT 'NULL' AS POR_DEF_CD" ).append("\n"); 
		query.append("                  FROM DUAL" ).append("\n"); 
		query.append("               )" ).append("\n"); 
		query.append("         UNION" ).append("\n"); 
		query.append("         SELECT SCG_GRP_LOC_CD" ).append("\n"); 
		query.append("          FROM PRI_SCG_GRP_LOC" ).append("\n"); 
		query.append("         WHERE SCG_GRP_LOC_CD = @[por_def_cd]" ).append("\n"); 
		query.append("         UNION" ).append("\n"); 
		query.append("         SELECT A1.SCG_GRP_LOC_CD AS POR_DEF_CD" ).append("\n"); 
		query.append("          FROM PRI_SCG_GRP_LOC A1" ).append("\n"); 
		query.append("             , (" ).append("\n"); 
		query.append("                SELECT SVC_SCP_CD" ).append("\n"); 
		query.append("                     , CHG_CD" ).append("\n"); 
		query.append("                     , GRP_LOC_SEQ" ).append("\n"); 
		query.append("                  FROM PRI_SCG_GRP_LOC_DTL A" ).append("\n"); 
		query.append("                     , (SELECT POR_DEF_CD" ).append("\n"); 
		query.append("                          FROM (" ).append("\n"); 
		query.append("                                SELECT DISTINCT(LOC_CD) AS POR_DEF_CD" ).append("\n"); 
		query.append("                                  FROM MDM_LOCATION" ).append("\n"); 
		query.append("                                 WHERE DECODE(LENGTH(@[por_def_cd]), 5, LOC_CD, 3, RGN_CD, 2, CNT_CD) = @[por_def_cd]" ).append("\n"); 
		query.append("                                   AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("                                UNION" ).append("\n"); 
		query.append("                                SELECT DISTINCT(RGN_CD) AS POR_DEF_CD" ).append("\n"); 
		query.append("                                  FROM MDM_LOCATION" ).append("\n"); 
		query.append("                                 WHERE DECODE(LENGTH(@[por_def_cd]), 5, LOC_CD, 3, RGN_CD, 2, CNT_CD) = @[por_def_cd]" ).append("\n"); 
		query.append("                                   AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("                                UNION" ).append("\n"); 
		query.append("                                SELECT DISTINCT(CNT_CD) AS POR_DEF_CD" ).append("\n"); 
		query.append("                                  FROM MDM_LOCATION" ).append("\n"); 
		query.append("                                 WHERE DECODE(LENGTH(@[por_def_cd]), 5, LOC_CD, 3, RGN_CD, 2, CNT_CD) = @[por_def_cd]" ).append("\n"); 
		query.append("                                   AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("                               )" ).append("\n"); 
		query.append("                       ) B" ).append("\n"); 
		query.append("                 WHERE A.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("                   AND A.CHG_CD = @[chg_cd]" ).append("\n"); 
		query.append("                   AND A.DTL_LOC_DEF_CD = B.POR_DEF_CD" ).append("\n"); 
		query.append("               ) B1" ).append("\n"); 
		query.append("         WHERE A1.SVC_SCP_CD = B1.SVC_SCP_CD" ).append("\n"); 
		query.append("           AND A1.CHG_CD = B1.CHG_CD" ).append("\n"); 
		query.append("           AND A1.GRP_LOC_SEQ = B1.GRP_LOC_SEQ" ).append("\n"); 
		query.append("           AND A1.DELT_FLG = 'N'      " ).append("\n"); 
		query.append("       ) B" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pol_def_cd} != '')" ).append("\n"); 
		query.append("     , (SELECT POL_DEF_CD" ).append("\n"); 
		query.append("          FROM (" ).append("\n"); 
		query.append("                SELECT DISTINCT(LOC_CD) AS POL_DEF_CD" ).append("\n"); 
		query.append("                  FROM MDM_LOCATION" ).append("\n"); 
		query.append("                 WHERE DECODE(LENGTH(@[pol_def_cd]), 5, LOC_CD, 3, RGN_CD, 2, CNT_CD) = @[pol_def_cd]" ).append("\n"); 
		query.append("                   AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("                UNION" ).append("\n"); 
		query.append("                SELECT DISTINCT(RGN_CD) AS POL_DEF_CD" ).append("\n"); 
		query.append("                  FROM MDM_LOCATION" ).append("\n"); 
		query.append("                 WHERE DECODE(LENGTH(@[pol_def_cd]), 5, LOC_CD, 3, RGN_CD, 2, CNT_CD) = @[pol_def_cd]" ).append("\n"); 
		query.append("                   AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("                UNION" ).append("\n"); 
		query.append("                SELECT DISTINCT(CNT_CD) AS POL_DEF_CD" ).append("\n"); 
		query.append("                  FROM MDM_LOCATION" ).append("\n"); 
		query.append("                 WHERE DECODE(LENGTH(@[pol_def_cd]), 5, LOC_CD, 3, RGN_CD, 2, CNT_CD) = @[pol_def_cd]" ).append("\n"); 
		query.append("                   AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("                UNION " ).append("\n"); 
		query.append("                SELECT 'NULL' AS POL_DEF_CD" ).append("\n"); 
		query.append("                  FROM DUAL" ).append("\n"); 
		query.append("               )" ).append("\n"); 
		query.append("         UNION" ).append("\n"); 
		query.append("         SELECT SCG_GRP_LOC_CD" ).append("\n"); 
		query.append("          FROM PRI_SCG_GRP_LOC" ).append("\n"); 
		query.append("         WHERE SCG_GRP_LOC_CD = @[pol_def_cd]" ).append("\n"); 
		query.append("         UNION" ).append("\n"); 
		query.append("         SELECT A1.SCG_GRP_LOC_CD AS POL_DEF_CD" ).append("\n"); 
		query.append("          FROM PRI_SCG_GRP_LOC A1" ).append("\n"); 
		query.append("             , (" ).append("\n"); 
		query.append("                SELECT SVC_SCP_CD" ).append("\n"); 
		query.append("                     , CHG_CD" ).append("\n"); 
		query.append("                     , GRP_LOC_SEQ" ).append("\n"); 
		query.append("                  FROM PRI_SCG_GRP_LOC_DTL A" ).append("\n"); 
		query.append("                     , (SELECT POL_DEF_CD" ).append("\n"); 
		query.append("                          FROM (" ).append("\n"); 
		query.append("                                SELECT DISTINCT(LOC_CD) AS POL_DEF_CD" ).append("\n"); 
		query.append("                                  FROM MDM_LOCATION" ).append("\n"); 
		query.append("                                 WHERE DECODE(LENGTH(@[pol_def_cd]), 5, LOC_CD, 3, RGN_CD, 2, CNT_CD) = @[pol_def_cd]" ).append("\n"); 
		query.append("                                   AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("                                UNION" ).append("\n"); 
		query.append("                                SELECT DISTINCT(RGN_CD) AS POL_DEF_CD" ).append("\n"); 
		query.append("                                  FROM MDM_LOCATION" ).append("\n"); 
		query.append("                                 WHERE DECODE(LENGTH(@[pol_def_cd]), 5, LOC_CD, 3, RGN_CD, 2, CNT_CD) = @[pol_def_cd]" ).append("\n"); 
		query.append("                                   AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("                                UNION" ).append("\n"); 
		query.append("                                SELECT DISTINCT(CNT_CD) AS POL_DEF_CD" ).append("\n"); 
		query.append("                                  FROM MDM_LOCATION" ).append("\n"); 
		query.append("                                 WHERE DECODE(LENGTH(@[pol_def_cd]), 5, LOC_CD, 3, RGN_CD, 2, CNT_CD) = @[pol_def_cd]" ).append("\n"); 
		query.append("                                   AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("                               )" ).append("\n"); 
		query.append("                       ) B" ).append("\n"); 
		query.append("                 WHERE A.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("                   AND A.CHG_CD = @[chg_cd]" ).append("\n"); 
		query.append("                   AND A.DTL_LOC_DEF_CD = B.POL_DEF_CD" ).append("\n"); 
		query.append("               ) B1" ).append("\n"); 
		query.append("         WHERE A1.SVC_SCP_CD = B1.SVC_SCP_CD" ).append("\n"); 
		query.append("           AND A1.CHG_CD = B1.CHG_CD" ).append("\n"); 
		query.append("           AND A1.GRP_LOC_SEQ = B1.GRP_LOC_SEQ" ).append("\n"); 
		query.append("           AND A1.DELT_FLG = 'N'      " ).append("\n"); 
		query.append("       ) C" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pod_def_cd} != '')" ).append("\n"); 
		query.append("     , (SELECT POD_DEF_CD" ).append("\n"); 
		query.append("          FROM (" ).append("\n"); 
		query.append("                SELECT DISTINCT(LOC_CD) AS POD_DEF_CD" ).append("\n"); 
		query.append("                  FROM MDM_LOCATION" ).append("\n"); 
		query.append("                 WHERE DECODE(LENGTH(@[pod_def_cd]), 5, LOC_CD, 3, RGN_CD, 2, CNT_CD) = @[pod_def_cd]" ).append("\n"); 
		query.append("                   AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("                UNION" ).append("\n"); 
		query.append("                SELECT DISTINCT(RGN_CD) AS POD_DEF_CD" ).append("\n"); 
		query.append("                  FROM MDM_LOCATION" ).append("\n"); 
		query.append("                 WHERE DECODE(LENGTH(@[pod_def_cd]), 5, LOC_CD, 3, RGN_CD, 2, CNT_CD) = @[pod_def_cd]" ).append("\n"); 
		query.append("                   AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("                UNION" ).append("\n"); 
		query.append("                SELECT DISTINCT(CNT_CD) AS POD_DEF_CD" ).append("\n"); 
		query.append("                  FROM MDM_LOCATION" ).append("\n"); 
		query.append("                 WHERE DECODE(LENGTH(@[pod_def_cd]), 5, LOC_CD, 3, RGN_CD, 2, CNT_CD) = @[pod_def_cd]" ).append("\n"); 
		query.append("                   AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("                UNION " ).append("\n"); 
		query.append("                SELECT 'NULL' AS POD_DEF_CD" ).append("\n"); 
		query.append("                  FROM DUAL" ).append("\n"); 
		query.append("               )" ).append("\n"); 
		query.append("         UNION" ).append("\n"); 
		query.append("         SELECT SCG_GRP_LOC_CD" ).append("\n"); 
		query.append("          FROM PRI_SCG_GRP_LOC" ).append("\n"); 
		query.append("         WHERE SCG_GRP_LOC_CD = @[pod_def_cd]" ).append("\n"); 
		query.append("         UNION" ).append("\n"); 
		query.append("         SELECT A1.SCG_GRP_LOC_CD AS POD_DEF_CD" ).append("\n"); 
		query.append("          FROM PRI_SCG_GRP_LOC A1" ).append("\n"); 
		query.append("             , (" ).append("\n"); 
		query.append("                SELECT SVC_SCP_CD" ).append("\n"); 
		query.append("                     , CHG_CD" ).append("\n"); 
		query.append("                     , GRP_LOC_SEQ" ).append("\n"); 
		query.append("                  FROM PRI_SCG_GRP_LOC_DTL A" ).append("\n"); 
		query.append("                     , (SELECT POD_DEF_CD" ).append("\n"); 
		query.append("                          FROM (" ).append("\n"); 
		query.append("                                SELECT DISTINCT(LOC_CD) AS POD_DEF_CD" ).append("\n"); 
		query.append("                                  FROM MDM_LOCATION" ).append("\n"); 
		query.append("                                 WHERE DECODE(LENGTH(@[pod_def_cd]), 5, LOC_CD, 3, RGN_CD, 2, CNT_CD) = @[pod_def_cd]" ).append("\n"); 
		query.append("                                   AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("                                UNION" ).append("\n"); 
		query.append("                                SELECT DISTINCT(RGN_CD) AS POD_DEF_CD" ).append("\n"); 
		query.append("                                  FROM MDM_LOCATION" ).append("\n"); 
		query.append("                                 WHERE DECODE(LENGTH(@[pod_def_cd]), 5, LOC_CD, 3, RGN_CD, 2, CNT_CD) = @[pod_def_cd]" ).append("\n"); 
		query.append("                                   AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("                                UNION" ).append("\n"); 
		query.append("                                SELECT DISTINCT(CNT_CD) AS POD_DEF_CD" ).append("\n"); 
		query.append("                                  FROM MDM_LOCATION" ).append("\n"); 
		query.append("                                 WHERE DECODE(LENGTH(@[pod_def_cd]), 5, LOC_CD, 3, RGN_CD, 2, CNT_CD) = @[pod_def_cd]" ).append("\n"); 
		query.append("                                   AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("                               )" ).append("\n"); 
		query.append("                       ) B" ).append("\n"); 
		query.append("                 WHERE A.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("                   AND A.CHG_CD = @[chg_cd]" ).append("\n"); 
		query.append("                   AND A.DTL_LOC_DEF_CD = B.POD_DEF_CD" ).append("\n"); 
		query.append("               ) B1" ).append("\n"); 
		query.append("         WHERE A1.SVC_SCP_CD = B1.SVC_SCP_CD" ).append("\n"); 
		query.append("           AND A1.CHG_CD = B1.CHG_CD" ).append("\n"); 
		query.append("           AND A1.GRP_LOC_SEQ = B1.GRP_LOC_SEQ" ).append("\n"); 
		query.append("           AND A1.DELT_FLG = 'N'      " ).append("\n"); 
		query.append("       ) D" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${del_def_cd} != '')" ).append("\n"); 
		query.append("     , (SELECT DEL_DEF_CD" ).append("\n"); 
		query.append("          FROM (" ).append("\n"); 
		query.append("                SELECT DISTINCT(LOC_CD) AS DEL_DEF_CD" ).append("\n"); 
		query.append("                  FROM MDM_LOCATION" ).append("\n"); 
		query.append("                 WHERE DECODE(LENGTH(@[del_def_cd]), 5, LOC_CD, 3, RGN_CD, 2, CNT_CD) = @[del_def_cd]" ).append("\n"); 
		query.append("                   AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("                UNION" ).append("\n"); 
		query.append("                SELECT DISTINCT(RGN_CD) AS DEL_DEF_CD" ).append("\n"); 
		query.append("                  FROM MDM_LOCATION" ).append("\n"); 
		query.append("                 WHERE DECODE(LENGTH(@[del_def_cd]), 5, LOC_CD, 3, RGN_CD, 2, CNT_CD) = @[del_def_cd]" ).append("\n"); 
		query.append("                   AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("                UNION" ).append("\n"); 
		query.append("                SELECT DISTINCT(CNT_CD) AS DEL_DEF_CD" ).append("\n"); 
		query.append("                  FROM MDM_LOCATION" ).append("\n"); 
		query.append("                 WHERE DECODE(LENGTH(@[del_def_cd]), 5, LOC_CD, 3, RGN_CD, 2, CNT_CD) = @[del_def_cd]" ).append("\n"); 
		query.append("                   AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("                UNION " ).append("\n"); 
		query.append("                SELECT 'NULL' AS DEL_DEF_CD" ).append("\n"); 
		query.append("                  FROM DUAL" ).append("\n"); 
		query.append("               )" ).append("\n"); 
		query.append("         UNION" ).append("\n"); 
		query.append("         SELECT SCG_GRP_LOC_CD" ).append("\n"); 
		query.append("          FROM PRI_SCG_GRP_LOC" ).append("\n"); 
		query.append("         WHERE SCG_GRP_LOC_CD = @[del_def_cd]" ).append("\n"); 
		query.append("         UNION" ).append("\n"); 
		query.append("         SELECT A1.SCG_GRP_LOC_CD AS DEL_DEF_CD" ).append("\n"); 
		query.append("          FROM PRI_SCG_GRP_LOC A1" ).append("\n"); 
		query.append("             , (" ).append("\n"); 
		query.append("                SELECT SVC_SCP_CD" ).append("\n"); 
		query.append("                     , CHG_CD" ).append("\n"); 
		query.append("                     , GRP_LOC_SEQ" ).append("\n"); 
		query.append("                  FROM PRI_SCG_GRP_LOC_DTL A" ).append("\n"); 
		query.append("                     , (SELECT DEL_DEF_CD" ).append("\n"); 
		query.append("                          FROM (" ).append("\n"); 
		query.append("                                SELECT DISTINCT(LOC_CD) AS DEL_DEF_CD" ).append("\n"); 
		query.append("                                  FROM MDM_LOCATION" ).append("\n"); 
		query.append("                                 WHERE DECODE(LENGTH(@[del_def_cd]), 5, LOC_CD, 3, RGN_CD, 2, CNT_CD) = @[del_def_cd]" ).append("\n"); 
		query.append("                                   AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("                                UNION" ).append("\n"); 
		query.append("                                SELECT DISTINCT(RGN_CD) AS DEL_DEF_CD" ).append("\n"); 
		query.append("                                  FROM MDM_LOCATION" ).append("\n"); 
		query.append("                                 WHERE DECODE(LENGTH(@[del_def_cd]), 5, LOC_CD, 3, RGN_CD, 2, CNT_CD) = @[del_def_cd]" ).append("\n"); 
		query.append("                                   AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("                                UNION" ).append("\n"); 
		query.append("                                SELECT DISTINCT(CNT_CD) AS DEL_DEF_CD" ).append("\n"); 
		query.append("                                  FROM MDM_LOCATION" ).append("\n"); 
		query.append("                                 WHERE DECODE(LENGTH(@[del_def_cd]), 5, LOC_CD, 3, RGN_CD, 2, CNT_CD) = @[del_def_cd]" ).append("\n"); 
		query.append("                                   AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("                               )" ).append("\n"); 
		query.append("                       ) B" ).append("\n"); 
		query.append("                 WHERE A.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("                   AND A.CHG_CD = @[chg_cd]" ).append("\n"); 
		query.append("                   AND A.DTL_LOC_DEF_CD = B.DEL_DEF_CD" ).append("\n"); 
		query.append("               ) B1" ).append("\n"); 
		query.append("         WHERE A1.SVC_SCP_CD = B1.SVC_SCP_CD" ).append("\n"); 
		query.append("           AND A1.CHG_CD = B1.CHG_CD" ).append("\n"); 
		query.append("           AND A1.GRP_LOC_SEQ = B1.GRP_LOC_SEQ" ).append("\n"); 
		query.append("           AND A1.DELT_FLG = 'N'      " ).append("\n"); 
		query.append("       ) E" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" WHERE SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("   AND CHG_CD = @[chg_cd]" ).append("\n"); 
		query.append("#if (${scg_seq} != '') " ).append("\n"); 
		query.append("   AND SCG_SEQ = @[scg_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${por_def_cd} != '') " ).append("\n"); 
		query.append("   AND NVL(A.POR_DEF_CD, 'NULL') = B.POR_DEF_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pol_def_cd} != '') " ).append("\n"); 
		query.append("   AND NVL(A.POL_DEF_CD, 'NULL') = C.POL_DEF_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pod_def_cd} != '') " ).append("\n"); 
		query.append("   AND NVL(A.POD_DEF_CD, 'NULL') = D.POD_DEF_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${del_def_cd} != '')" ).append("\n"); 
		query.append("   AND NVL(A.DEL_DEF_CD, 'NULL') = E.DEL_DEF_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${eff_dt} != '')" ).append("\n"); 
		query.append("AND TO_DATE(@[eff_dt], 'YYYY-MM-DD') BETWEEN EFF_DT AND EXP_DT" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${scg_imdg_clss_cd} != '')" ).append("\n"); 
		query.append("   AND NVL(SCG_IMDG_CLSS_CD, 'NULL') IN (@[scg_imdg_clss_cd], 'NULL')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${prc_cgo_tp_cd} != '')" ).append("\n"); 
		query.append("   AND	NVL(PRC_CGO_TP_CD, 'NULL') IN (" ).append("\n"); 
		query.append("					#foreach(${key} in ${prc_cgo_tp_cd})" ).append("\n"); 
		query.append("						#if($velocityCount < $prc_cgo_tp_cd.size())" ).append("\n"); 
		query.append("							'$key', " ).append("\n"); 
		query.append("						#else  " ).append("\n"); 
		query.append("							'$key'" ).append("\n"); 
		query.append("						#end " ).append("\n"); 
		query.append("					#end " ).append("\n"); 
		query.append(" 					)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bkg_esvc_tp_cd} != '')" ).append("\n"); 
		query.append("   AND NVL(BKG_ESVC_TP_CD, 'NULL') IN (@[bkg_esvc_tp_cd], 'NULL')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND DELT_FLG = 'N'" ).append("\n"); 
		query.append(") A" ).append("\n"); 
		query.append("   " ).append("\n"); 
		query.append("ORDER BY LVL1, LVL2, LVL3, LVL4, SUB_TRD_CD, VSL_SLAN_CD, TS_PORT_CD, DIR_CALL_FLG, TML_CD, ORG_TRSP_MOD_CD, DEST_TRSP_MOD_CD, USA_SVC_MOD_CD, PRC_RCV_TERM_CD" ).append("\n"); 
		query.append("     , PRC_DE_TERM_CD, PRC_HNGR_BAR_TP_CD, MIN_CGO_WGT, MAX_CGO_WGT, CMDT_CD, SCG_GRP_CMDT_CD, SOC_FLG, IO_GA_CD, RAT_UT_CD, PRC_CGO_TP_CD, SCG_IMDG_CLSS_CD, CURR_CD" ).append("\n"); 
		query.append("     , SCG_AMT, PAY_TERM_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE NO BETWEEN @[startpage] AND @[endpage]" ).append("\n"); 

	}
}