/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : AgreementCorrectionDBDAOSearchCorrSumAgmtRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.06.05
*@LastModifier : 
*@LastVersion : 1.0
* 2017.06.05 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.agreementmanage.agreementmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AgreementCorrectionDBDAOSearchCorrSumAgmtRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AGMT Correction Summary 조회
	  * </pre>
	  */
	public AgreementCorrectionDBDAOSearchCorrSumAgmtRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_trsp_agmt_rt_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_cmdt_grp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_cust_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_vndr_prmry_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_trsp_cost_mod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_hjscnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_cgo_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_agmt_trsp_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_rail_svc_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_agmtno",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.agreementmanage.agreementmanage.integration").append("\n"); 
		query.append("FileName : AgreementCorrectionDBDAOSearchCorrSumAgmtRSQL").append("\n"); 
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
		query.append("SELECT TRSP_AGMT_RT_TP_CD" ).append("\n"); 
		query.append("      ,AGMT_NO" ).append("\n"); 
		query.append("      ,VNDR_SEQ" ).append("\n"); 
		query.append("      ,VNDR_NM" ).append("\n"); 
		query.append("      ,TRSP_COST_MOD_CD" ).append("\n"); 
		query.append("      ,AGMT_TRSP_TP_CD" ).append("\n"); 
		query.append("      ,CGO_TP_CD" ).append("\n"); 
		query.append("      ,SCG_EXIST_FLG" ).append("\n"); 
		query.append("      ,EFF_FM_DT" ).append("\n"); 
		query.append("      ,EFF_TO_DT" ).append("\n"); 
		query.append("      ,HJS_CNT_CD" ).append("\n"); 
		query.append("      ,CUST_NOMI_TRKR_IND_CD" ).append("\n"); 
		query.append("      ,CUST_CD" ).append("\n"); 
		query.append("      ,CMDT_GRP_CD" ).append("\n"); 
		query.append("      ,RAIL_SVC_TP_CD" ).append("\n"); 
		query.append("      ,AGMT_REF_NO" ).append("\n"); 
		query.append("      ,CTRT_OFC_CD" ).append("\n"); 
		query.append("      ,UPD_DT" ).append("\n"); 
		query.append("      ,UPD_USR_ID" ).append("\n"); 
		query.append("      ,CRE_OFC_CD" ).append("\n"); 
		query.append("      ,TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("      ,TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("      ,TRSP_AGMT_RT_TP_SER_NO" ).append("\n"); 
		query.append("      ,RATE_TOT_CNT" ).append("\n"); 
		query.append("      ,SCG_RATE_TOT_CNT" ).append("\n"); 
		query.append("      ,'( '||RATE_TOT_CNT ||' / '||SCG_RATE_TOT_CNT ||' )'AS EQ_SCG_RATE_TOT_CNT" ).append("\n"); 
		query.append("      ,RATE_CFM_TARGET_CNT" ).append("\n"); 
		query.append("      ,SCG_RATE_CFM_TARGET_CNT" ).append("\n"); 
		query.append("      ,CASE WHEN RATE_CFM_TARGET_CNT+SCG_RATE_CFM_TARGET_CNT = 0 THEN CFM_FLG" ).append("\n"); 
		query.append("            WHEN SCG_RATE_CFM_TARGET_CNT > 0 THEN SCG_CFM_FLG" ).append("\n"); 
		query.append("            WHEN RATE_CFM_TARGET_CNT > 0 THEN CFM_FLG" ).append("\n"); 
		query.append("            ELSE NULL " ).append("\n"); 
		query.append("       END CFM_FLG" ).append("\n"); 
		query.append("      ,CASE WHEN RATE_CFM_TARGET_CNT+SCG_RATE_CFM_TARGET_CNT = 0 THEN CFM_USR_NM " ).append("\n"); 
		query.append("            ELSE NULL " ).append("\n"); 
		query.append("       END CFM_USR_NM" ).append("\n"); 
		query.append("      ,CASE WHEN CTRT_LINK_CNT > 0 THEN 'Y' ELSE '' END CTRT_LINK_FLG" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("    SELECT  TRSP_AGMT_RT_TP_CD" ).append("\n"); 
		query.append("           ,AGMT_NO" ).append("\n"); 
		query.append("           ,VNDR_SEQ" ).append("\n"); 
		query.append("           ,VNDR_NM" ).append("\n"); 
		query.append("           ,TRSP_COST_MOD_CD" ).append("\n"); 
		query.append("           ,AGMT_TRSP_TP_CD" ).append("\n"); 
		query.append("           ,CGO_TP_CD" ).append("\n"); 
		query.append("           ,SCG_EXIST_FLG" ).append("\n"); 
		query.append("		   ,TO_CHAR(MAX(EFF_FM_DT),'YYYYMMDD') EFF_FM_DT" ).append("\n"); 
		query.append("	       ,TO_CHAR(MAX(EFF_TO_DT),'YYYYMMDD') EFF_TO_DT" ).append("\n"); 
		query.append("           ,HJS_CNT_CD" ).append("\n"); 
		query.append("           ,CUST_NOMI_TRKR_IND_CD" ).append("\n"); 
		query.append("           ,DECODE(CUST_CD, 'XX0', NULL, CUST_CD) CUST_CD" ).append("\n"); 
		query.append("           ,DECODE(CMDT_GRP_CD, 'XXXX', NULL, CMDT_GRP_CD) CMDT_GRP_CD" ).append("\n"); 
		query.append("           ,DECODE(RAIL_SVC_TP_CD, '00', NULL, RAIL_SVC_TP_CD) RAIL_SVC_TP_CD" ).append("\n"); 
		query.append("           ,AGMT_REF_NO" ).append("\n"); 
		query.append("           ,CTRT_OFC_CD" ).append("\n"); 
		query.append("           ,UPD_DT" ).append("\n"); 
		query.append("           ,NVL((SELECT MAX(USR_NM) FROM COM_USER A WHERE A.USR_ID = M.UPD_USR_ID),M.UPD_USR_ID) UPD_USR_ID" ).append("\n"); 
		query.append("           ,CRE_OFC_CD" ).append("\n"); 
		query.append("           ,TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("           ,TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("           ,TRSP_AGMT_RT_TP_SER_NO" ).append("\n"); 
		query.append("           ,(SELECT COUNT(*)" ).append("\n"); 
		query.append("               FROM TRS_AGMT_EQ_RT X" ).append("\n"); 
		query.append("              WHERE X.TRSP_AGMT_OFC_CTY_CD = M.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("                AND X.TRSP_AGMT_SEQ        = M.TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("                AND X.TRSP_AGMT_RT_TP_SER_NO = M.TRSP_AGMT_RT_TP_SER_NO" ).append("\n"); 
		query.append("                AND NVL(X.DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("              #if (${fm_effective_agmt} != 'A' )" ).append("\n"); 
		query.append("                AND (SELECT GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(CTRT_OFC_CD)  FROM DUAL ) BETWEEN X.EFF_FM_DT AND X.EFF_TO_DT" ).append("\n"); 
		query.append("              #end" ).append("\n"); 
		query.append("            ) AS RATE_TOT_CNT" ).append("\n"); 
		query.append("           ,(SELECT COUNT(*)" ).append("\n"); 
		query.append("               FROM TRS_AGMT_SCG_RT X" ).append("\n"); 
		query.append("              WHERE X.TRSP_AGMT_OFC_CTY_CD = M.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("                AND X.TRSP_AGMT_SEQ        = M.TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("                AND X.TRSP_AGMT_RT_TP_SER_NO = M.TRSP_AGMT_RT_TP_SER_NO" ).append("\n"); 
		query.append("                AND NVL(X.DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("              #if (${fm_effective_agmt} != 'A' )" ).append("\n"); 
		query.append("                AND (SELECT GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(CTRT_OFC_CD)  FROM DUAL ) BETWEEN X.EFF_FM_DT AND X.EFF_TO_DT" ).append("\n"); 
		query.append("              #end" ).append("\n"); 
		query.append("            ) AS SCG_RATE_TOT_CNT" ).append("\n"); 
		query.append("           ,(SELECT COUNT(*)" ).append("\n"); 
		query.append("               FROM TRS_AGMT_EQ_RT X" ).append("\n"); 
		query.append("              WHERE X.TRSP_AGMT_OFC_CTY_CD = M.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("                AND X.TRSP_AGMT_SEQ        = M.TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("                AND X.TRSP_AGMT_RT_TP_SER_NO = M.TRSP_AGMT_RT_TP_SER_NO" ).append("\n"); 
		query.append("                AND NVL(X.DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("                AND X.CFM_FLG = 'N'" ).append("\n"); 
		query.append("              #if (${fm_effective_agmt} != 'A' )" ).append("\n"); 
		query.append("                AND (SELECT GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(CTRT_OFC_CD)  FROM DUAL ) BETWEEN X.EFF_FM_DT AND X.EFF_TO_DT" ).append("\n"); 
		query.append("              #end" ).append("\n"); 
		query.append("            ) AS RATE_CFM_TARGET_CNT" ).append("\n"); 
		query.append("           ,(SELECT COUNT(*)" ).append("\n"); 
		query.append("               FROM TRS_AGMT_SCG_RT X" ).append("\n"); 
		query.append("              WHERE X.TRSP_AGMT_OFC_CTY_CD = M.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("                AND X.TRSP_AGMT_SEQ        = M.TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("                AND X.TRSP_AGMT_RT_TP_SER_NO = M.TRSP_AGMT_RT_TP_SER_NO" ).append("\n"); 
		query.append("                AND NVL(X.DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("                AND X.CFM_FLG = 'N'" ).append("\n"); 
		query.append("              #if (${fm_effective_agmt} != 'A' )" ).append("\n"); 
		query.append("                AND (SELECT GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(CTRT_OFC_CD)  FROM DUAL ) BETWEEN X.EFF_FM_DT AND X.EFF_TO_DT" ).append("\n"); 
		query.append("              #end" ).append("\n"); 
		query.append("            ) AS SCG_RATE_CFM_TARGET_CNT" ).append("\n"); 
		query.append("           ,SUBSTR(MAX(CFM_INFO), 1, INSTR(MAX(CFM_INFO), '$', 1, 1) - 1) AS CFM_FLG" ).append("\n"); 
		query.append("           ,SUBSTR(MAX(SCG_CFM_INFO), 1, INSTR(MAX(SCG_CFM_INFO), '$', 1, 1) - 1) AS SCG_CFM_FLG" ).append("\n"); 
		query.append("           ,SUBSTR(MAX(CFM_INFO), INSTR(MAX(CFM_INFO), '$', 1, 1) + 1, INSTR(MAX(CFM_INFO), '$', 1, 2) - INSTR(MAX(CFM_INFO), '$', 1, 1) - 1) AS CFM_USR_NM" ).append("\n"); 
		query.append("           ,SUBSTR(MAX(SCG_CFM_INFO), INSTR(MAX(SCG_CFM_INFO), '$', 1, 1) + 1, INSTR(MAX(SCG_CFM_INFO), '$', 1, 2) - INSTR(MAX(SCG_CFM_INFO), '$', 1, 1) - 1) AS SCG_CFM_USR_NM" ).append("\n"); 
		query.append("           ,(SELECT COUNT(*)" ).append("\n"); 
		query.append("               FROM TRS_AGMT_CTRT_ATCH X" ).append("\n"); 
		query.append("              WHERE X.TRSP_AGMT_OFC_CTY_CD = M.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("                AND X.TRSP_AGMT_SEQ = M.TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("                AND X.AGMT_DOC_NO IS NOT NULL) CTRT_LINK_CNT" ).append("\n"); 
		query.append("      FROM (" ).append("\n"); 
		query.append("        SELECT C.TRSP_AGMT_RT_TP_CD" ).append("\n"); 
		query.append("              ,A.TRSP_AGMT_OFC_CTY_CD || A.TRSP_AGMT_SEQ AS AGMT_NO" ).append("\n"); 
		query.append("              ,B.VNDR_SEQ" ).append("\n"); 
		query.append("              ,(SELECT MDM.VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("                  FROM MDM_VENDOR MDM" ).append("\n"); 
		query.append("                 WHERE MDM.VNDR_SEQ = B.VNDR_SEQ" ).append("\n"); 
		query.append("               ) VNDR_NM" ).append("\n"); 
		query.append("              ,C.TRSP_COST_MOD_CD" ).append("\n"); 
		query.append("              ,C.AGMT_TRSP_TP_CD" ).append("\n"); 
		query.append("              ,C.CGO_TP_CD" ).append("\n"); 
		query.append("              ,(SELECT 'Y'" ).append("\n"); 
		query.append("                  FROM TRS_AGMT_SCG_NOD X," ).append("\n"); 
		query.append("                       TRS_AGMT_SCG_RT R" ).append("\n"); 
		query.append("                 WHERE X.TRSP_AGMT_OFC_CTY_CD   = R.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("                   AND X.TRSP_AGMT_SEQ          = R.TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("                   AND X.TRSP_AGMT_RT_TP_SER_NO = R.TRSP_AGMT_RT_TP_SER_NO" ).append("\n"); 
		query.append("                   AND R.TRSP_AGMT_OFC_CTY_CD   = C.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("                   AND R.TRSP_AGMT_SEQ          = C.TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("                   AND R.TRSP_AGMT_RT_TP_SER_NO = C.TRSP_AGMT_RT_TP_SER_NO" ).append("\n"); 
		query.append("                   AND NVL(R.DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("                #if (${fm_effective_agmt} != 'A' )" ).append("\n"); 
		query.append("                   AND (SELECT GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(A.CTRT_OFC_CD) FROM DUAL) BETWEEN R.EFF_FM_DT AND R.EFF_TO_DT" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("                #if (${fm_trsp_scg_cd} == 'F' )" ).append("\n"); 
		query.append("                   AND X.TRSP_SCG_CD IN ('FUA','FUE')" ).append("\n"); 
		query.append("                #elseif (${fm_trsp_scg_cd} == 'O' )" ).append("\n"); 
		query.append("                   AND X.TRSP_SCG_CD NOT IN ('FUA','FUE')" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("                   AND ROWNUM = 1" ).append("\n"); 
		query.append("                ) AS SCG_EXIST_FLG" ).append("\n"); 
		query.append("              ,DECODE(C.CUST_CNT_CD, 'XX', '', 'Y') HJS_CNT_CD" ).append("\n"); 
		query.append("              ,C.CUST_NOMI_TRKR_IND_CD" ).append("\n"); 
		query.append("              ,C.CUST_CNT_CD || C.CUST_SEQ CUST_CD" ).append("\n"); 
		query.append("              ,C.CMDT_GRP_CD" ).append("\n"); 
		query.append("              ,C.RAIL_SVC_TP_CD" ).append("\n"); 
		query.append("              ,A.AGMT_REF_NO" ).append("\n"); 
		query.append("              ,A.CTRT_OFC_CD" ).append("\n"); 
		query.append("              ,TO_CHAR(C.UPD_DT, 'YYYY-MM-DD HH24:MI:SS') UPD_DT" ).append("\n"); 
		query.append("              ,C.UPD_USR_ID" ).append("\n"); 
		query.append("              ,NVL(C.UPD_OFC_CD, C.CRE_OFC_CD) CRE_OFC_CD" ).append("\n"); 
		query.append("              ,C.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("              ,C.TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("              ,C.TRSP_AGMT_RT_TP_SER_NO" ).append("\n"); 
		query.append("			  ,E.EFF_FM_DT" ).append("\n"); 
		query.append("			  ,E.EFF_TO_DT" ).append("\n"); 
		query.append("              ,(SELECT MAX(X.CFM_FLG)||'$'||NVL(MAX(Y.USR_NM), MAX(X.CFM_USR_ID))||'$'" ).append("\n"); 
		query.append("                  FROM TRS_AGMT_EQ_RT X" ).append("\n"); 
		query.append("                      ,COM_USER Y" ).append("\n"); 
		query.append("                 WHERE X.TRSP_AGMT_OFC_CTY_CD = C.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("                   AND X.TRSP_AGMT_SEQ        = C.TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("                   AND X.TRSP_AGMT_RT_TP_SER_NO = C.TRSP_AGMT_RT_TP_SER_NO" ).append("\n"); 
		query.append("                   AND X.CFM_USR_ID = Y.USR_ID(+)" ).append("\n"); 
		query.append("                   AND NVL(X.DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("                   AND X.UPD_DT =  (SELECT MAX(XX.UPD_DT)" ).append("\n"); 
		query.append("                                      FROM TRS_AGMT_EQ_RT XX" ).append("\n"); 
		query.append("                                     WHERE X.TRSP_AGMT_OFC_CTY_CD = XX.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("                                       AND X.TRSP_AGMT_SEQ = XX.TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("                                       AND X.TRSP_AGMT_RT_TP_SER_NO = XX.TRSP_AGMT_RT_TP_SER_NO" ).append("\n"); 
		query.append("                                   )" ).append("\n"); 
		query.append("                 #if (${fm_effective_agmt} != 'A' )" ).append("\n"); 
		query.append("                   AND (SELECT GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(A.CTRT_OFC_CD)  FROM DUAL ) BETWEEN X.EFF_FM_DT AND X.EFF_TO_DT" ).append("\n"); 
		query.append("                 #end" ).append("\n"); 
		query.append("               ) AS CFM_INFO" ).append("\n"); 
		query.append("              ,(SELECT MAX(X.CFM_FLG)||'$'||NVL(MAX(Y.USR_NM), MAX(X.CFM_USR_ID))||'$'" ).append("\n"); 
		query.append("                  FROM TRS_AGMT_SCG_RT X" ).append("\n"); 
		query.append("                      ,COM_USER Y" ).append("\n"); 
		query.append("                 WHERE X.TRSP_AGMT_OFC_CTY_CD = C.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("                   AND X.TRSP_AGMT_SEQ        = C.TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("                   AND X.TRSP_AGMT_RT_TP_SER_NO = C.TRSP_AGMT_RT_TP_SER_NO" ).append("\n"); 
		query.append("                   AND X.CFM_USR_ID = Y.USR_ID(+)" ).append("\n"); 
		query.append("                   AND NVL(X.DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("                   AND X.UPD_DT =  (SELECT MAX(XX.UPD_DT)" ).append("\n"); 
		query.append("                                      FROM TRS_AGMT_SCG_RT XX" ).append("\n"); 
		query.append("                                     WHERE X.TRSP_AGMT_OFC_CTY_CD = XX.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("                                       AND X.TRSP_AGMT_SEQ = XX.TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("                                       AND X.TRSP_AGMT_RT_TP_SER_NO = XX.TRSP_AGMT_RT_TP_SER_NO" ).append("\n"); 
		query.append("                                   )" ).append("\n"); 
		query.append("                 #if (${fm_effective_agmt} != 'A' )" ).append("\n"); 
		query.append("                   AND (SELECT GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(A.CTRT_OFC_CD)  FROM DUAL ) BETWEEN X.EFF_FM_DT AND X.EFF_TO_DT" ).append("\n"); 
		query.append("                 #end" ).append("\n"); 
		query.append("               ) AS SCG_CFM_INFO" ).append("\n"); 
		query.append("          FROM TRS_AGMT_HDR A" ).append("\n"); 
		query.append("              ,TRS_AGMT_APLY_VNDR B" ).append("\n"); 
		query.append("              ,TRS_AGMT_RT_TP C" ).append("\n"); 
		query.append("              ,TRS_AGMT_SCG_RT E" ).append("\n"); 
		query.append("         WHERE A.TRSP_AGMT_OFC_CTY_CD = C.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("           AND A.TRSP_AGMT_SEQ        = C.TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("           AND A.TRSP_AGMT_OFC_CTY_CD = B.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("           AND A.TRSP_AGMT_SEQ        = B.TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("           AND C.TRSP_AGMT_OFC_CTY_CD = E.TRSP_AGMT_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("           AND C.TRSP_AGMT_SEQ = E.TRSP_AGMT_SEQ(+)" ).append("\n"); 
		query.append("           AND C.TRSP_AGMT_RT_TP_SER_NO = E.TRSP_AGMT_RT_TP_SER_NO(+)" ).append("\n"); 
		query.append("           AND 'N' = NVL(E.DELT_FLG(+),'N')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("           AND B.AGMT_VNDR_PRMRY_FLG  = 'Y'" ).append("\n"); 
		query.append("        #if (${fm_agmtno} != '' )" ).append("\n"); 
		query.append("           AND A.TRSP_AGMT_OFC_CTY_CD = SUBSTR(@[fm_agmtno],1,3)" ).append("\n"); 
		query.append("           AND A.TRSP_AGMT_SEQ        = SUBSTR(@[fm_agmtno],4)" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${fm_vndr_prmry_seq} != '' )" ).append("\n"); 
		query.append("           AND (A.TRSP_AGMT_OFC_CTY_CD, A.TRSP_AGMT_SEQ) IN (" ).append("\n"); 
		query.append("                SELECT TRSP_AGMT_OFC_CTY_CD, TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("                  FROM TRS_AGMT_APLY_VNDR" ).append("\n"); 
		query.append("                 WHERE VNDR_SEQ = @[fm_vndr_prmry_seq]" ).append("\n"); 
		query.append("                   AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("               )" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        #if ($arr_ctrt_office.size() > 0) " ).append("\n"); 
		query.append("           AND A.CTRT_OFC_CD in (" ).append("\n"); 
		query.append("           #foreach( ${key} in ${arr_ctrt_office}) " ).append("\n"); 
		query.append("	         #if($velocityCount < $arr_ctrt_office.size()) " ).append("\n"); 
		query.append("		       '$key', " ).append("\n"); 
		query.append("	         #else " ).append("\n"); 
		query.append("		       '$key' " ).append("\n"); 
		query.append("	         #end " ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           )" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        #if (${fm_trsp_agmt_rt_tp_cd} != 'A' )" ).append("\n"); 
		query.append("           AND C.TRSP_AGMT_RT_TP_CD = @[fm_trsp_agmt_rt_tp_cd]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        #if (${fm_hjscnt} != '' )" ).append("\n"); 
		query.append("	        #if (${fm_hjscnt} == 'HJS' )" ).append("\n"); 
		query.append("		   AND C.CUST_NOMI_TRKR_FLG = 'N'" ).append("\n"); 
		query.append("			#else" ).append("\n"); 
		query.append("		   AND C.CUST_NOMI_TRKR_FLG = 'Y'" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("		   AND C.CUST_NOMI_TRKR_IND_CD = @[fm_hjscnt]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${fm_cust_cd} != '' )" ).append("\n"); 
		query.append("           AND C.CUST_CNT_CD = SUBSTR(@[fm_cust_cd],1,2)" ).append("\n"); 
		query.append("           AND C.CUST_SEQ    = SUBSTR(@[fm_cust_cd],3)" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        #if (${fm_trsp_cost_mod_cd} != 'A' )" ).append("\n"); 
		query.append("           AND C.TRSP_COST_MOD_CD = @[fm_trsp_cost_mod_cd]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${fm_agmt_trsp_tp_cd} != '' )" ).append("\n"); 
		query.append("           AND C.AGMT_TRSP_TP_CD = @[fm_agmt_trsp_tp_cd]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${fm_cgo_tp_cd} != '' )" ).append("\n"); 
		query.append("           AND C.CGO_TP_CD = @[fm_cgo_tp_cd]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${fm_rail_svc_tp_cd} != '' )" ).append("\n"); 
		query.append("           AND C.RAIL_SVC_TP_CD = @[fm_rail_svc_tp_cd]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${fm_cmdt_grp_cd} != '' )" ).append("\n"); 
		query.append("           AND C.CMDT_GRP_CD = @[fm_cmdt_grp_cd]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("    ) M" ).append("\n"); 
		query.append(" 	GROUP BY TRSP_AGMT_RT_TP_CD" ).append("\n"); 
		query.append("     		,AGMT_NO" ).append("\n"); 
		query.append("		    ,VNDR_SEQ" ).append("\n"); 
		query.append("		    ,VNDR_NM" ).append("\n"); 
		query.append("		    ,TRSP_COST_MOD_CD" ).append("\n"); 
		query.append("	        ,AGMT_TRSP_TP_CD" ).append("\n"); 
		query.append("	 	    ,CGO_TP_CD" ).append("\n"); 
		query.append("	        ,SCG_EXIST_FLG" ).append("\n"); 
		query.append("		    ,HJS_CNT_CD" ).append("\n"); 
		query.append("            ,CUST_NOMI_TRKR_IND_CD" ).append("\n"); 
		query.append("     		,CUST_CD" ).append("\n"); 
		query.append("     		,CMDT_GRP_CD" ).append("\n"); 
		query.append("     		,RAIL_SVC_TP_CD" ).append("\n"); 
		query.append("     		,AGMT_REF_NO" ).append("\n"); 
		query.append("     		,CTRT_OFC_CD" ).append("\n"); 
		query.append("     		,UPD_DT" ).append("\n"); 
		query.append("     		,UPD_USR_ID" ).append("\n"); 
		query.append("     		,CRE_OFC_CD" ).append("\n"); 
		query.append("     		,TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("     		,TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("     		,TRSP_AGMT_RT_TP_SER_NO" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("  AND RATE_TOT_CNT > 0" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${fm_trsp_scg_cd} != 'A' )" ).append("\n"); 
		query.append("  AND SCG_EXIST_FLG = 'Y'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${fm_cfm_flg} != '' )" ).append("\n"); 
		query.append("  #if (${fm_cfm_flg} == 'N' )" ).append("\n"); 
		query.append("      AND RATE_CFM_TARGET_CNT+SCG_RATE_CFM_TARGET_CNT > 0" ).append("\n"); 
		query.append("  #else" ).append("\n"); 
		query.append("      AND RATE_CFM_TARGET_CNT+SCG_RATE_CFM_TARGET_CNT = 0" ).append("\n"); 
		query.append("      AND (CASE WHEN RATE_CFM_TARGET_CNT+SCG_RATE_CFM_TARGET_CNT = 0 THEN CFM_FLG WHEN SCG_RATE_CFM_TARGET_CNT > 0 THEN SCG_CFM_FLG WHEN RATE_CFM_TARGET_CNT > 0 THEN CFM_FLG ELSE NULL END) = 'Y'" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${fm_link_flg} != '' )" ).append("\n"); 
		query.append("  #if (${fm_link_flg} == 'Y' )" ).append("\n"); 
		query.append("      AND CTRT_LINK_CNT > 0" ).append("\n"); 
		query.append("  #else" ).append("\n"); 
		query.append("      AND CTRT_LINK_CNT = 0" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY CGO_TP_CD" ).append("\n"); 

	}
}