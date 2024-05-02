/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SurchargeDBDAOPriScgRtVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.27
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.27 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.surcharge.surcharge.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SurchargeDBDAOPriScgRtVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PRI_SCG_RT 테이블 조회
	  * 2013.03.07 전윤주 [CHM-201323465] Reefer condition type 추가
	  * 2013.04.17 전윤주 [CHM-201324203] Contract date 추가
	  * 2013.10.01 전윤주 [CHM-201326927] MDM rating flag와 연계하여 Auto 항목 추가
	  * 2013.10.01 전윤주 [CHM-201326929] BL Printing시 숨길 수 있는 Hide 항목 추가
	  * 2014.02.20 전윤주 [CHM-201428968] Surcharge effective/expiration date 입력 시 경고 팝업 추가 요청
	  * 2014.03.20 전윤주 [CHM-201429456] Food Grade 항목 추가
	  * 2014.04.10 전윤주 [CHM-201429656] State code 항목 추가  
	  * 2015.04.10 전지예 [CHM-201535041] Arrival Date 항목 추가
	  * </pre>
	  */
	public SurchargeDBDAOPriScgRtVORSQL(){
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
		params.put("exp_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("chg_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("scg_rqst_proc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scg_imdg_clss_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.surcharge.surcharge.integration").append("\n"); 
		query.append("FileName : SurchargeDBDAOPriScgRtVORSQL").append("\n"); 
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
		query.append("SELECT A.SVC_SCP_CD" ).append("\n"); 
		query.append("     , A.CHG_CD " ).append("\n"); 
		query.append("     , A.SCG_SEQ" ).append("\n"); 
		query.append("	 , G.SCG_RQST_SEQ" ).append("\n"); 
		query.append("     , TO_CHAR(A.EFF_DT, 'YYYY-MM-DD') AS EFF_DT" ).append("\n"); 
		query.append("     , TO_CHAR(A.EFF_DT, 'YYYY-MM-DD') AS ORG_EFF_DT" ).append("\n"); 
		query.append("     , DECODE(TO_CHAR(A.EXP_DT, 'YYYYMMDD'), '99991231', NULL, TO_CHAR(A.EXP_DT, 'YYYY-MM-DD')) AS EXP_DT" ).append("\n"); 
		query.append("     , DECODE(TO_CHAR(A.EXP_DT, 'YYYYMMDD'), '99991231', NULL, TO_CHAR(A.EXP_DT, 'YYYY-MM-DD')) AS ORG_EXP_DT" ).append("\n"); 
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
		query.append("     , A.SCG_CRTE_DY_KNT" ).append("\n"); 
		query.append("     , A.SCG_PRD_TP_CD" ).append("\n"); 
		query.append("     , A.SCG_PRD_CRTE_CD" ).append("\n"); 
		query.append("	 , A.PSA_NO" ).append("\n"); 
		query.append("     , A.RC_AIR_COND_TP_CD" ).append("\n"); 
		query.append("     , TO_CHAR(A.CTRT_DT, 'YYYY-MM-DD') AS CTRT_DT" ).append("\n"); 
		query.append("     , A.ACT_RAT_FLG" ).append("\n"); 
		query.append("     , A.PRN_HDN_FLG" ).append("\n"); 
		query.append("     , A.FD_GRD_FLG" ).append("\n"); 
		query.append("     , A.CNT_CD" ).append("\n"); 
		query.append("     , A.STE_CD" ).append("\n"); 
		query.append("     , TO_CHAR(A.ARR_DT, 'YYYY-MM-DD') AS ARR_DT" ).append("\n"); 
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
		query.append("	 , '' SEQ" ).append("\n"); 
		query.append("     , '' UPD_USR_NM" ).append("\n"); 
		query.append("     , F.AUTO_RAT_FLG" ).append("\n"); 
		query.append("     , G.SCG_RQST_PROC_CD" ).append("\n"); 
		query.append("     , G.SCG_RQST_STS_CD" ).append("\n"); 
		query.append("	 , G.RQST_USR_ID" ).append("\n"); 
		query.append("	 , TO_CHAR(G.RQST_DT, 'YYYY-MM-DD') AS RQST_DT" ).append("\n"); 
		query.append("	 , G.APRO_USR_ID" ).append("\n"); 
		query.append("	 , TO_CHAR(G.APRO_DT, 'YYYY-MM-DD') AS APRO_DT" ).append("\n"); 
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
		query.append("               ) " ).append("\n"); 
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
		query.append("                 WHERE A.SVC_SCP_CD IN (SELECT SVC_SCP_CD FROM PRI_SCG_TRD_SVC_SCP_MAPG WHERE TRD_CD = @[trd_cd])" ).append("\n"); 
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
		query.append("                 WHERE A.SVC_SCP_CD IN (SELECT SVC_SCP_CD FROM PRI_SCG_TRD_SVC_SCP_MAPG WHERE TRD_CD = @[trd_cd])" ).append("\n"); 
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
		query.append("                 WHERE A.SVC_SCP_CD IN (SELECT SVC_SCP_CD FROM PRI_SCG_TRD_SVC_SCP_MAPG WHERE TRD_CD = @[trd_cd])" ).append("\n"); 
		query.append("                   AND A.CHG_CD = @[chg_cd]" ).append("\n"); 
		query.append("                   AND A.DTL_LOC_DEF_CD = B.DEL_DEF_CD" ).append("\n"); 
		query.append("               ) B1" ).append("\n"); 
		query.append("         WHERE A1.SVC_SCP_CD = B1.SVC_SCP_CD" ).append("\n"); 
		query.append("           AND A1.CHG_CD = B1.CHG_CD" ).append("\n"); 
		query.append("           AND A1.GRP_LOC_SEQ = B1.GRP_LOC_SEQ" ).append("\n"); 
		query.append("           AND A1.DELT_FLG = 'N'      " ).append("\n"); 
		query.append("       ) E" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("     ,MDM_CHARGE F" ).append("\n"); 
		query.append("     ,PRI_SCG_RQST_RT G" ).append("\n"); 
		query.append("	 ,(" ).append("\n"); 
		query.append("        SELECT A.SVC_SCP_CD" ).append("\n"); 
		query.append("             , A.CHG_CD" ).append("\n"); 
		query.append("             , A.SCG_SEQ" ).append("\n"); 
		query.append("             , MAX(A.SCG_RQST_SEQ) SCG_RQST_SEQ" ).append("\n"); 
		query.append("          FROM PRI_SCG_RQST_RT A" ).append("\n"); 
		query.append("         WHERE 1 = 1" ).append("\n"); 
		query.append("            AND A.SVC_SCP_CD IN (SELECT SVC_SCP_CD FROM PRI_SCG_TRD_SVC_SCP_MAPG WHERE TRD_CD = @[trd_cd])" ).append("\n"); 
		query.append("           AND A.CHG_CD =  @[chg_cd]" ).append("\n"); 
		query.append("         GROUP BY A.SVC_SCP_CD" ).append("\n"); 
		query.append("             , A.CHG_CD" ).append("\n"); 
		query.append("             , A.SCG_SEQ" ).append("\n"); 
		query.append("     ) B" ).append("\n"); 
		query.append(" WHERE 1 = 1" ).append("\n"); 
		query.append("   AND G.SVC_SCP_CD  = B.SVC_SCP_CD " ).append("\n"); 
		query.append("   AND G.CHG_CD = B.CHG_CD" ).append("\n"); 
		query.append("   AND G.SCG_SEQ = B.SCG_SEQ" ).append("\n"); 
		query.append("   AND G.SCG_RQST_SEQ = B.SCG_RQST_SEQ" ).append("\n"); 
		query.append("   AND A.SVC_SCP_CD IN (SELECT SVC_SCP_CD FROM PRI_SCG_TRD_SVC_SCP_MAPG WHERE TRD_CD = @[trd_cd])" ).append("\n"); 
		query.append("   AND A.CHG_CD = @[chg_cd]" ).append("\n"); 
		query.append("   AND A.CHG_CD = F.CHG_CD" ).append("\n"); 
		query.append("   AND A.SVC_SCP_CD = G.SVC_SCP_CD(+)" ).append("\n"); 
		query.append("   AND A.CHG_CD = G.CHG_CD(+)" ).append("\n"); 
		query.append("   AND A.SCG_SEQ = G.SCG_SEQ(+)" ).append("\n"); 
		query.append("#if (${svc_scp_cd} != '') " ).append("\n"); 
		query.append("   AND A.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${scg_seq} != '') " ).append("\n"); 
		query.append("   AND A.SCG_SEQ = @[scg_seq]" ).append("\n"); 
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
		query.append("AND (TO_DATE(@[eff_dt], 'YYYY-MM-DD') BETWEEN A.EFF_DT AND A.EXP_DT OR (A.EFF_DT >= TO_DATE(@[eff_dt], 'YYYY-MM-DD') AND A.EXP_DT <= TO_DATE(@[exp_dt], 'YYYY-MM-DD')) OR TO_DATE(@[exp_dt], 'YYYY-MM-DD') BETWEEN A.EFF_DT AND A.EXP_DT)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${scg_imdg_clss_cd} != '')" ).append("\n"); 
		query.append("   AND NVL(A.SCG_IMDG_CLSS_CD, 'NULL') IN (@[scg_imdg_clss_cd], 'NULL')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${prc_cgo_tp_cd} != '')" ).append("\n"); 
		query.append("   AND	NVL(A.PRC_CGO_TP_CD, 'NULL') IN (" ).append("\n"); 
		query.append("					#foreach(${key} in ${prc_cgo_tp_cd})" ).append("\n"); 
		query.append("						#if($velocityCount < $prc_cgo_tp_cd.size())" ).append("\n"); 
		query.append("							'$key', " ).append("\n"); 
		query.append("						#else  " ).append("\n"); 
		query.append("							'$key'" ).append("\n"); 
		query.append("						#end " ).append("\n"); 
		query.append("					#end " ).append("\n"); 
		query.append(" 					)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${scg_rqst_proc_cd} != '') " ).append("\n"); 
		query.append("   AND G.SCG_RQST_PROC_CD = @[scg_rqst_proc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT A.SVC_SCP_CD" ).append("\n"); 
		query.append("     , A.CHG_CD " ).append("\n"); 
		query.append("     , A.SCG_SEQ" ).append("\n"); 
		query.append("	 , G.SCG_RQST_SEQ" ).append("\n"); 
		query.append("     , TO_CHAR(A.EFF_DT, 'YYYY-MM-DD') AS EFF_DT" ).append("\n"); 
		query.append("     , TO_CHAR(A.EFF_DT, 'YYYY-MM-DD') AS ORG_EFF_DT" ).append("\n"); 
		query.append("     , DECODE(TO_CHAR(A.EXP_DT, 'YYYYMMDD'), '99991231', NULL, TO_CHAR(A.EXP_DT, 'YYYY-MM-DD')) AS EXP_DT" ).append("\n"); 
		query.append("     , DECODE(TO_CHAR(A.EXP_DT, 'YYYYMMDD'), '99991231', NULL, TO_CHAR(A.EXP_DT, 'YYYY-MM-DD')) AS ORG_EXP_DT" ).append("\n"); 
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
		query.append("     , A.SCG_CRTE_DY_KNT" ).append("\n"); 
		query.append("     , A.SCG_PRD_TP_CD" ).append("\n"); 
		query.append("     , A.SCG_PRD_CRTE_CD" ).append("\n"); 
		query.append("	 , A.PSA_NO" ).append("\n"); 
		query.append("     , A.RC_AIR_COND_TP_CD" ).append("\n"); 
		query.append("     , TO_CHAR(A.CTRT_DT, 'YYYY-MM-DD') AS CTRT_DT" ).append("\n"); 
		query.append("     , A.ACT_RAT_FLG" ).append("\n"); 
		query.append("     , A.PRN_HDN_FLG" ).append("\n"); 
		query.append("     , A.FD_GRD_FLG" ).append("\n"); 
		query.append("     , A.CNT_CD" ).append("\n"); 
		query.append("     , A.STE_CD" ).append("\n"); 
		query.append("     , TO_CHAR(A.ARR_DT, 'YYYY-MM-DD') AS ARR_DT" ).append("\n"); 
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
		query.append("	 , '' SEQ" ).append("\n"); 
		query.append("     , '' UPD_USR_NM" ).append("\n"); 
		query.append("     , F.AUTO_RAT_FLG" ).append("\n"); 
		query.append("     , G.SCG_RQST_PROC_CD" ).append("\n"); 
		query.append("     , G.SCG_RQST_STS_CD" ).append("\n"); 
		query.append("	 , G.RQST_USR_ID" ).append("\n"); 
		query.append("	 , TO_CHAR(G.RQST_DT, 'YYYY-MM-DD') AS RQST_DT" ).append("\n"); 
		query.append("	 , G.APRO_USR_ID" ).append("\n"); 
		query.append("	 , TO_CHAR(G.APRO_DT, 'YYYY-MM-DD') AS APRO_DT" ).append("\n"); 
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
		query.append("                 WHERE A.SVC_SCP_CD IN (SELECT SVC_SCP_CD FROM PRI_SCG_TRD_SVC_SCP_MAPG WHERE TRD_CD = @[trd_cd])" ).append("\n"); 
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
		query.append("                 WHERE A.SVC_SCP_CD IN (SELECT SVC_SCP_CD FROM PRI_SCG_TRD_SVC_SCP_MAPG WHERE TRD_CD = @[trd_cd])" ).append("\n"); 
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
		query.append("                 WHERE A.SVC_SCP_CD IN (SELECT SVC_SCP_CD FROM PRI_SCG_TRD_SVC_SCP_MAPG WHERE TRD_CD = @[trd_cd])" ).append("\n"); 
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
		query.append("                 WHERE A.SVC_SCP_CD IN (SELECT SVC_SCP_CD FROM PRI_SCG_TRD_SVC_SCP_MAPG WHERE TRD_CD = @[trd_cd])" ).append("\n"); 
		query.append("                   AND A.CHG_CD = @[chg_cd]" ).append("\n"); 
		query.append("                   AND A.DTL_LOC_DEF_CD = B.DEL_DEF_CD" ).append("\n"); 
		query.append("               ) B1" ).append("\n"); 
		query.append("         WHERE A1.SVC_SCP_CD = B1.SVC_SCP_CD" ).append("\n"); 
		query.append("           AND A1.CHG_CD = B1.CHG_CD" ).append("\n"); 
		query.append("           AND A1.GRP_LOC_SEQ = B1.GRP_LOC_SEQ" ).append("\n"); 
		query.append("           AND A1.DELT_FLG = 'N'      " ).append("\n"); 
		query.append("       ) E" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("     ,MDM_CHARGE F" ).append("\n"); 
		query.append("     ,PRI_SCG_RQST_RT G" ).append("\n"); 
		query.append(" WHERE 1 = 1" ).append("\n"); 
		query.append("   AND A.SVC_SCP_CD IN (SELECT SVC_SCP_CD FROM PRI_SCG_TRD_SVC_SCP_MAPG WHERE TRD_CD = @[trd_cd])" ).append("\n"); 
		query.append("   AND A.CHG_CD = @[chg_cd]" ).append("\n"); 
		query.append("   AND A.CHG_CD = F.CHG_CD" ).append("\n"); 
		query.append("   AND A.SVC_SCP_CD = G.SVC_SCP_CD(+)" ).append("\n"); 
		query.append("   AND A.CHG_CD = G.CHG_CD(+)" ).append("\n"); 
		query.append("   AND A.SCG_SEQ = G.SCG_SEQ(+)" ).append("\n"); 
		query.append("   AND G.SCG_RQST_SEQ IS NULL" ).append("\n"); 
		query.append("#if (${svc_scp_cd} != '') " ).append("\n"); 
		query.append("   AND A.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${scg_seq} != '') " ).append("\n"); 
		query.append("   AND A.SCG_SEQ = @[scg_seq]" ).append("\n"); 
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
		query.append("AND (TO_DATE(@[eff_dt], 'YYYY-MM-DD') BETWEEN A.EFF_DT AND A.EXP_DT OR (A.EFF_DT >= TO_DATE(@[eff_dt], 'YYYY-MM-DD') AND A.EXP_DT <= TO_DATE(@[exp_dt], 'YYYY-MM-DD')) OR TO_DATE(@[exp_dt], 'YYYY-MM-DD') BETWEEN A.EFF_DT AND A.EXP_DT)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${scg_imdg_clss_cd} != '')" ).append("\n"); 
		query.append("   AND NVL(A.SCG_IMDG_CLSS_CD, 'NULL') IN (@[scg_imdg_clss_cd], 'NULL')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${prc_cgo_tp_cd} != '')" ).append("\n"); 
		query.append("   AND	NVL(A.PRC_CGO_TP_CD, 'NULL') IN (" ).append("\n"); 
		query.append("					#foreach(${key} in ${prc_cgo_tp_cd})" ).append("\n"); 
		query.append("						#if($velocityCount < $prc_cgo_tp_cd.size())" ).append("\n"); 
		query.append("							'$key', " ).append("\n"); 
		query.append("						#else  " ).append("\n"); 
		query.append("							'$key'" ).append("\n"); 
		query.append("						#end " ).append("\n"); 
		query.append("					#end " ).append("\n"); 
		query.append(" 					)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${scg_rqst_proc_cd} != '') " ).append("\n"); 
		query.append("   AND G.SCG_RQST_PROC_CD = @[scg_rqst_proc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY SVC_SCP_CD,  LVL1, LVL2, LVL3, LVL4, SUB_TRD_CD, VSL_SLAN_CD, TS_PORT_CD, DIR_CALL_FLG, TML_CD, ORG_TRSP_MOD_CD, DEST_TRSP_MOD_CD, USA_SVC_MOD_CD, PRC_RCV_TERM_CD" ).append("\n"); 
		query.append("     , PRC_DE_TERM_CD, PRC_HNGR_BAR_TP_CD, MIN_CGO_WGT, MAX_CGO_WGT, CMDT_CD, SCG_GRP_CMDT_CD, SOC_FLG, IO_GA_CD, RAT_UT_CD, PRC_CGO_TP_CD, SCG_IMDG_CLSS_CD, CURR_CD" ).append("\n"); 
		query.append("     , SCG_AMT, PAY_TERM_CD" ).append("\n"); 

	}
}