/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CommonDBDAOSearchListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.22
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.22 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.spc.common.common.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CommonDBDAOSearchListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2010.08.23 최윤성 [CHM-201005492-01] RDR 실적 Summary 기능 개발 - Operator List 쿼리 추가
	  * 2010.12.30 최윤성 [CHM-201008093-01] Office Level Table 생성
	  *  - SPC_ORGANIZATION_V 대신 SPC_OFC_LVL 로 대체
	  * 2015.07.22. SKY[CLT-000042051-10] Virtual add call - VT_ADD_CALL_FLG IS  NULL  로직 추가
	  * </pre>
	  */
	public CommonDBDAOSearchListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("login_usr_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trdCd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loginUsrOfcCd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("code",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("date",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("custSeq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("locTrdCd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lane",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofcCd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yardCd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lvl",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvdCd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("year",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("portCd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("custCntCd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rhq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("locSubTrdCd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.spc.common.common.integration").append("\n"); 
		query.append("FileName : CommonDBDAOSearchListRSQL").append("\n"); 
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
		query.append("#if (${methodname} == 'searchTradeComboList')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* Trade List를  가져 온다 */" ).append("\n"); 
		query.append("   SELECT B.TRD_CD," ).append("\n"); 
		query.append("          TRD_NM" ).append("\n"); 
		query.append("     FROM (" ).append("\n"); 
		query.append("             SELECT DISTINCT" ).append("\n"); 
		query.append("                    B.TRD_CD" ).append("\n"); 
		query.append("               FROM MDM_REV_LANE     A," ).append("\n"); 
		query.append("                    MDM_DTL_REV_LANE B," ).append("\n"); 
		query.append("                    MDM_VSL_SVC_LANE C" ).append("\n"); 
		query.append("              WHERE A.RLANE_CD    = B.RLANE_CD" ).append("\n"); 
		query.append("                AND A.VSL_TP_CD   = 'C'" ).append("\n"); 
		query.append("#if (${isRepTrade} == 'true')" ).append("\n"); 
		query.append("                /* Rep Trade 경우 추가 option 조건 */" ).append("\n"); 
		query.append("                AND A.REP_TRD_CD  = B.TRD_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                AND B.DELT_FLG   IN ('N', @[del])" ).append("\n"); 
		query.append("                AND B.TRD_CD     <> 'COM'" ).append("\n"); 
		query.append("                AND A.VSL_SLAN_CD = C.VSL_SLAN_CD" ).append("\n"); 
		query.append("                AND DECODE(C.VSL_SVC_TP_CD, 'I', C.CO_CD, '1') = DECODE(C.VSL_SVC_TP_CD, 'I', 'H', '1')" ).append("\n"); 
		query.append("                AND C.VSL_SVC_TP_CD <> 'O'" ).append("\n"); 
		query.append("         ) A," ).append("\n"); 
		query.append("         MDM_TRADE B" ).append("\n"); 
		query.append("   WHERE A.TRD_CD = B.TRD_CD" ).append("\n"); 
		query.append("ORDER BY B.TRD_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'searchSubTradeComboList')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* Sub Trade List를  가져 온다 */" ).append("\n"); 
		query.append("   SELECT A.TRD_CD    ," ).append("\n"); 
		query.append("          B.SUB_TRD_CD," ).append("\n"); 
		query.append("          NVL(B.SUB_TRD_NM, ( SELECT T.TRD_NM" ).append("\n"); 
		query.append("                                FROM MDM_TRADE T" ).append("\n"); 
		query.append("                               WHERE T.TRD_CD = A.TRD_CD)" ).append("\n"); 
		query.append("          ) AS SUB_TRD_NM" ).append("\n"); 
		query.append("     FROM (" ).append("\n"); 
		query.append("             SELECT DISTINCT" ).append("\n"); 
		query.append("                    B.TRD_CD  ," ).append("\n"); 
		query.append("                    SUB_TRD_CD" ).append("\n"); 
		query.append("               FROM MDM_REV_LANE     A," ).append("\n"); 
		query.append("                    MDM_DTL_REV_LANE B," ).append("\n"); 
		query.append("                    MDM_VSL_SVC_LANE C" ).append("\n"); 
		query.append("              WHERE A.RLANE_CD = B.RLANE_CD" ).append("\n"); 
		query.append("                AND A.VSL_TP_CD  = 'C'" ).append("\n"); 
		query.append("#if (${isRepTrade} == 'true')" ).append("\n"); 
		query.append("                AND A.REP_TRD_CD = B.TRD_CD  /* REP TRADE 경우 추가 OPTION 조건 */" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                AND B.DELT_FLG   IN ('N', @[del])" ).append("\n"); 
		query.append("                AND B.TRD_CD     <> 'COM'" ).append("\n"); 
		query.append("                AND A.VSL_SLAN_CD = C.VSL_SLAN_CD" ).append("\n"); 
		query.append("                AND DECODE(C.VSL_SVC_TP_CD, 'I', C.CO_CD, '1') = DECODE(C.VSL_SVC_TP_CD, 'I', 'H', '1')" ).append("\n"); 
		query.append("                AND C.VSL_SVC_TP_CD <> 'O'" ).append("\n"); 
		query.append("				#if (${trdCd} != '')" ).append("\n"); 
		query.append("					AND B.TRD_CD IN (@[trdCd])" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("				#if (${subTrdCd} != '')" ).append("\n"); 
		query.append("				     AND B.SUB_TRD_CD   IN ($subTrdCd) " ).append("\n"); 
		query.append("				#end    " ).append("\n"); 
		query.append("          ) A," ).append("\n"); 
		query.append("          MDM_SUB_TRD B" ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("#if (${isall} == 'true')" ).append("\n"); 
		query.append("      AND A.SUB_TRD_CD = B.SUB_TRD_CD(+)" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("      AND A.SUB_TRD_CD = B.SUB_TRD_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" ORDER BY A.TRD_CD    ," ).append("\n"); 
		query.append("          B.SUB_TRD_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'searchRLaneComboList')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* Lane List를  가져 온다 */" ).append("\n"); 
		query.append("  SELECT DISTINCT" ).append("\n"); 
		query.append("         B.TRD_CD    ," ).append("\n"); 
		query.append("         B.SUB_TRD_CD," ).append("\n"); 
		query.append("         A.RLANE_CD  ," ).append("\n"); 
		query.append("         A.RLANE_NM" ).append("\n"); 
		query.append("    FROM MDM_REV_LANE     A," ).append("\n"); 
		query.append("         MDM_DTL_REV_LANE B," ).append("\n"); 
		query.append("         MDM_VSL_SVC_LANE C" ).append("\n"); 
		query.append("#if(${isPus} == 'true')" ).append("\n"); 
		query.append("         , (SELECT DISTINCT P.VSL_SLAN_CD, P.SKD_DIR_CD" ).append("\n"); 
		query.append("              FROM VSK_PF_SKD S," ).append("\n"); 
		query.append("                   VSK_PF_SKD_DTL P," ).append("\n"); 
		query.append("                   VSK_VSL_SKD V" ).append("\n"); 
		query.append("             WHERE S.SLAN_STND_FLG = 'Y'" ).append("\n"); 
		query.append("               AND S.VSL_SLAN_CD = P.VSL_SLAN_CD" ).append("\n"); 
		query.append("               AND S.PF_SVC_TP_CD = P.PF_SVC_TP_CD" ).append("\n"); 
		query.append("               AND P.PORT_CD = 'KRPUS'" ).append("\n"); 
		query.append("               AND TURN_PORT_IND_CD <> 'F'" ).append("\n"); 
		query.append("               AND V.VSL_SLAN_CD = S.VSL_SLAN_CD" ).append("\n"); 
		query.append("               AND V.PF_SKD_TP_CD = S.PF_SVC_TP_CD" ).append("\n"); 
		query.append("               AND V.SKD_STS_CD <> 'CLO') P" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   WHERE A.RLANE_CD     = B.RLANE_CD" ).append("\n"); 
		query.append("     AND A.VSL_TP_CD    = 'C'" ).append("\n"); 
		query.append("#if (${ipc} != 'true')" ).append("\n"); 
		query.append("     AND A.REP_TRD_CD   = B.TRD_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("     AND B.DELT_FLG   IN ('N', @[del])" ).append("\n"); 
		query.append("     AND B.TRD_CD     <> 'COM'" ).append("\n"); 
		query.append("     AND A.VSL_SLAN_CD = C.VSL_SLAN_CD" ).append("\n"); 
		query.append("     AND DECODE(C.VSL_SVC_TP_CD, 'I', C.CO_CD, '1') = DECODE(C.VSL_SVC_TP_CD, 'I', 'H', '1')" ).append("\n"); 
		query.append("     AND C.VSL_SVC_TP_CD <> 'O'" ).append("\n"); 
		query.append("#if (${locTrdCd} != '')" ).append("\n"); 
		query.append("	 AND B.TRD_CD     IN (@[locTrdCd]) " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${locSubTrdCd} != '')" ).append("\n"); 
		query.append("	 AND B.SUB_TRD_CD  IN (@[locSubTrdCd]) " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${isPus} == 'true')" ).append("\n"); 
		query.append("     AND A.VSL_SLAN_CD = P.VSL_SLAN_CD" ).append("\n"); 
		query.append("     AND B.VSL_SLAN_DIR_CD = P.SKD_DIR_CD" ).append("\n"); 
		query.append("     AND B.FM_CONTI_CD = 'A'" ).append("\n"); 
		query.append("     AND B.TO_CONTI_CD IN ('E', 'M')" ).append("\n"); 
		query.append("     AND EXISTS (SELECT 'A' " ).append("\n"); 
		query.append("                   FROM COA_MON_VVD M" ).append("\n"); 
		query.append("                  WHERE SUBSTR(M.SLS_YRMON, 1, 4) = TO_CHAR(SYSDATE, 'YYYY')" ).append("\n"); 
		query.append("                    AND CEIL(TO_NUMBER(SUBSTR(M.SLS_YRMON, 5, 2)) / 3)||'Q' = CEIL(TO_NUMBER(TO_CHAR(SYSDATE, 'MM')) / 3)||'Q'" ).append("\n"); 
		query.append("                    AND M.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                    AND M.TRD_CD = B.TRD_CD" ).append("\n"); 
		query.append("                    AND M.RLANE_CD = B.RLANE_CD)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY B.TRD_CD    ," ).append("\n"); 
		query.append("         B.SUB_TRD_CD," ).append("\n"); 
		query.append("         A.RLANE_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'searchVesselSizeList')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* VesselSize List를  가져 온다 */" ).append("\n"); 
		query.append("  SELECT DISTINCT" ).append("\n"); 
		query.append("#if (${lane} != '')" ).append("\n"); 
		query.append("         C.CNTR_VSL_CLSS_CAPA AS CODE," ).append("\n"); 
		query.append("         TO_CHAR(C.CNTR_VSL_CLSS_CAPA, 'FM9,990') AS TEXT" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("         C.CNTR_VSL_CLSS_CAPA AS CODE," ).append("\n"); 
		query.append("         V.RLANE_CD||'|'||C.CNTR_VSL_CLSS_CAPA AS TEXT" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("    FROM MDM_VSL_CNTR C," ).append("\n"); 
		query.append("         COA_MON_VVD  V" ).append("\n"); 
		query.append("   WHERE V.VSL_CD   = C.VSL_CD" ).append("\n"); 
		query.append("#if (${lane} != '')" ).append("\n"); 
		query.append("     AND V.RLANE_CD = @[lane]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY C.CNTR_VSL_CLSS_CAPA" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'searchCustAbbrNmList')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* Customer List를  가져 온다 */" ).append("\n"); 
		query.append("SELECT A.CUST_CNT_CD || TRIM(TO_CHAR(A.CUST_SEQ, '000009')) AS CODE," ).append("\n"); 
		query.append("       DECODE(A.CUST_ABBR_NM, NULL, A.CUST_LGL_ENG_NM, A.CUST_ABBR_NM) || '|' || B.CUST_GRP_NM AS TEXT" ).append("\n"); 
		query.append("  FROM MDM_CUSTOMER      A," ).append("\n"); 
		query.append("       MDM_CUST_PERF_GRP B" ).append("\n"); 
		query.append(" WHERE A.CUST_GRP_ID = B.CUST_GRP_ID(+)" ).append("\n"); 
		query.append("   AND A.CUST_CNT_CD = @[custCntCd]" ).append("\n"); 
		query.append("   AND A.CUST_SEQ    = @[custSeq]" ).append("\n"); 
		query.append("   AND A.DELT_FLG    = 'N'" ).append("\n"); 
		query.append("   AND B.DELT_FLG(+) = 'N'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'searchOfficeList')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* Salse Office List를  가져 온다 */" ).append("\n"); 
		query.append("SELECT OFC_CD     AS CODE," ).append("\n"); 
		query.append("       OFC_ENG_NM AS TEXT" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("          SELECT ROW_NUMBER() OVER (ORDER BY OFC_CD ASC) AS NO," ).append("\n"); 
		query.append("                 OFC_CD    ," ).append("\n"); 
		query.append("                 OFC_ENG_NM," ).append("\n"); 
		query.append("                 OFC_KND_CD," ).append("\n"); 
		query.append("                 LOC_CD" ).append("\n"); 
		query.append("            FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("           WHERE OFC_CD LIKE @[ofcCd]" ).append("\n"); 
		query.append("             AND NVL(DELT_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append("       ) A" ).append("\n"); 
		query.append(" WHERE NO BETWEEN 1 AND 50" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'searchVVDList')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* VVD List를  가져 온다 */" ).append("\n"); 
		query.append("SELECT VVD     AS CODE," ).append("\n"); 
		query.append("       SLAN_CD AS TEXT" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("          SELECT ROW_NUMBER() OVER (ORDER BY SLAN_CD, VSL_CD||SKD_VOY_NO||SKD_DIR_CD, TO_NUMBER(CLPT_SEQ)) AS NO," ).append("\n"); 
		query.append("                 SLAN_CD," ).append("\n"); 
		query.append("                 VSL_CD || SKD_VOY_NO || SKD_DIR_CD AS VVD," ).append("\n"); 
		query.append("                 VPS_PORT_CD," ).append("\n"); 
		query.append("                 VPS_ETA_DT ," ).append("\n"); 
		query.append("                 VPS_ETD_DT" ).append("\n"); 
		query.append("            FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("           WHERE 1=1" ).append("\n"); 
		query.append("             AND VSL_CD || SKD_VOY_NO || SKD_DIR_CD = @[vvdCd]" ).append("\n"); 
		query.append("             AND NVL(SKD_CNG_STS_CD, ' ') <> 'S'" ).append("\n"); 
		query.append("             AND CLPT_IND_SEQ = '1'" ).append("\n"); 
		query.append("             AND VT_ADD_CALL_FLG IS  NULL" ).append("\n"); 
		query.append("       ) A" ).append("\n"); 
		query.append(" WHERE NO BETWEEN 1 AND 50" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'searchCommonCodeList')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* Common Code List를  가져 온다 */" ).append("\n"); 
		query.append("  SELECT INTG_CD_VAL_CTNT    AS CODE," ).append("\n"); 
		query.append("         INTG_CD_VAL_DP_DESC AS TEXT" ).append("\n"); 
		query.append("    FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("   WHERE INTG_CD_ID = @[code]" ).append("\n"); 
		query.append("ORDER BY INTG_CD_VAL_DP_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'searchRHQComboList')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* RHQ List를  가져 온다 */" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  SELECT T.OFC_CD    ," ).append("\n"); 
		query.append("         T.OFC_ENG_NM" ).append("\n"); 
		query.append("    FROM " ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("         SELECT * " ).append("\n"); 
		query.append("         FROM SPC_OFC_LVL T" ).append("\n"); 
		query.append("         WHERE 1=1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if(${login_usr_ofc_cd} != '')" ).append("\n"); 
		query.append("         CONNECT BY NOCYCLE PRIOR T.PRNT_OFC_CD = T.OFC_CD" ).append("\n"); 
		query.append("         START WITH T.OFC_CD = @[login_usr_ofc_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("         )T," ).append("\n"); 
		query.append("         COA_WK_PRD  W" ).append("\n"); 
		query.append("   WHERE T.OFC_LVL = 2" ).append("\n"); 
		query.append("     AND W.COST_YR || W.COST_WK BETWEEN T.OFC_APLY_FM_YRWK AND T.OFC_APLY_TO_YRWK" ).append("\n"); 
		query.append("     AND TO_CHAR(SYSDATE, 'YYYYMMDD') BETWEEN W.SLS_FM_DT AND W.SLS_TO_DT" ).append("\n"); 
		query.append("     AND T.DELT_FLG IN ('N', @[del])" ).append("\n"); 
		query.append("ORDER BY 1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'searchAQComboList')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* AQ List를  가져 온다 */" ).append("\n"); 
		query.append("  SELECT V.OFC_CD    ," ).append("\n"); 
		query.append("         V.OFC_ENG_NM" ).append("\n"); 
		query.append("#if (${module} == 'saq')" ).append("\n"); 
		query.append("    FROM SAQ_ORGANIZATION_V V" ).append("\n"); 
		query.append("   WHERE V.LVL = 3" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("    FROM SPC_OFC_LVL V," ).append("\n"); 
		query.append("         COA_WK_PRD  W" ).append("\n"); 
		query.append("   WHERE V.OFC_LVL = 3" ).append("\n"); 
		query.append("     AND W.COST_YR || W.COST_WK BETWEEN V.OFC_APLY_FM_YRWK AND V.OFC_APLY_TO_YRWK" ).append("\n"); 
		query.append("     AND TO_CHAR(SYSDATE, 'YYYYMMDD') BETWEEN W.SLS_FM_DT AND W.SLS_TO_DT" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rhq} != '')" ).append("\n"); 
		query.append("     AND V.N2ND_PRNT_OFC_CD = @[rhq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${module} != 'saq')" ).append("\n"); 
		query.append("     AND V.DELT_FLG IN ('N', @[del])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY 1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'searchRgnOfcComboList')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* Rgn Office List를  가져 온다 */" ).append("\n"); 
		query.append("  SELECT V.OFC_CD    ," ).append("\n"); 
		query.append("         V.OFC_ENG_NM" ).append("\n"); 
		query.append("#if (${module} == 'saq')" ).append("\n"); 
		query.append("    FROM SAQ_ORGANIZATION_V V" ).append("\n"); 
		query.append("   WHERE V.LVL = 4" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("    FROM SPC_OFC_LVL V," ).append("\n"); 
		query.append("         COA_WK_PRD  W" ).append("\n"); 
		query.append("   WHERE V.OFC_LVL = 4" ).append("\n"); 
		query.append("     AND W.COST_YR || W.COST_WK BETWEEN V.OFC_APLY_FM_YRWK AND V.OFC_APLY_TO_YRWK" ).append("\n"); 
		query.append("     AND TO_CHAR(SYSDATE, 'YYYYMMDD') BETWEEN W.SLS_FM_DT AND W.SLS_TO_DT" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rhq} != '')" ).append("\n"); 
		query.append("     AND (V.N2ND_PRNT_OFC_CD = @[rhq] OR V.N3RD_PRNT_OFC_CD = @[rhq])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${module} != 'saq')" ).append("\n"); 
		query.append("     AND V.DELT_FLG IN ('N', @[del])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY 1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'searchKAMerComboList')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* GAMer List를  가져 온다 */" ).append("\n"); 
		query.append("  SELECT DISTINCT" ).append("\n"); 
		query.append("         V.KEY_ACCT_MGR_USR_ID AS CD," ).append("\n"); 
		query.append("         V.KEY_ACCT_MGR_USR_NM AS NM" ).append("\n"); 
		query.append("    FROM MDM_CUSTOMER V" ).append("\n"); 
		query.append("   WHERE V.KEY_ACCT_FLG = 'Y'" ).append("\n"); 
		query.append("     AND V.DELT_FLG    IN ('N', @[del])" ).append("\n"); 
		query.append("ORDER BY 1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'searchTargetGroupComboList')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* Targer Group List를  가져 온다 */" ).append("\n"); 
		query.append("  SELECT A.SAQ_TGT_GRP_CD   AS GRP_CD  ," ).append("\n"); 
		query.append("         A.SAQ_TGT_GRP_DESC AS GRP_DESC" ).append("\n"); 
		query.append("    FROM SAQ_TGT_GRP A" ).append("\n"); 
		query.append("   WHERE A.DELT_FLG IN ('N', @[del])" ).append("\n"); 
		query.append("#if (${ofc} != '')" ).append("\n"); 
		query.append("     AND A.OFC_CD = @[ofc]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY A.SAQ_TGT_GRP_CD  ," ).append("\n"); 
		query.append("         A.SAQ_TGT_GRP_DESC" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'searchChildOfficeList')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* Child Office List를  가져 온다 */" ).append("\n"); 
		query.append("WITH PARAMS AS (" ).append("\n"); 
		query.append("    SELECT @[ofcCd] AS OFC_CD, --이미 OFFICE CONVERSION이 이루어진 OFFICE" ).append("\n"); 
		query.append("           SPC_SCR_OFC_CONV_FNC(@[loginUsrOfcCd], '') AS USR_OFC_CD, --로그인 USER의 ORIGINAL OFFICE" ).append("\n"); 
		query.append("           TO_NUMBER(@[lvl])         AS LVL," ).append("\n"); 
		query.append("           TO_NUMBER(NVL(@[inc], 0)) AS INC" ).append("\n"); 
		query.append("      FROM DUAL" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", PARAMS_CNV AS (" ).append("\n"); 
		query.append("    SELECT NVL(P.OFC_CD, P.USR_OFC_CD) AS OFC_CD," ).append("\n"); 
		query.append("           P.USR_OFC_CD," ).append("\n"); 
		query.append("           P.LVL       ," ).append("\n"); 
		query.append("           P.INC" ).append("\n"); 
		query.append("      FROM PARAMS P" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", PARAMS_OFC AS (" ).append("\n"); 
		query.append("    SELECT DECODE(SIGN(P.LVL - O.OFC_LVL), -1, DECODE(P.LVL, 1, O.N1ST_PRNT_OFC_CD," ).append("\n"); 
		query.append("                                                             2, O.N2ND_PRNT_OFC_CD," ).append("\n"); 
		query.append("                                                             3, O.N3RD_PRNT_OFC_CD," ).append("\n"); 
		query.append("                                                             4, O.N4TH_PRNT_OFC_CD," ).append("\n"); 
		query.append("                                                             5, O.N5TH_PRNT_OFC_CD," ).append("\n"); 
		query.append("                                                             6, O.N6TH_PRNT_OFC_CD," ).append("\n"); 
		query.append("                                                             7, O.N7TH_PRNT_OFC_CD), P.OFC_CD) AS OFC_CD," ).append("\n"); 
		query.append("           P.USR_OFC_CD," ).append("\n"); 
		query.append("           P.LVL       ," ).append("\n"); 
		query.append("           P.INC       ," ).append("\n"); 
		query.append("           O.OFC_LVL   ," ).append("\n"); 
		query.append("           LEAST(P.LVL, O.OFC_LVL) AS F_LVL" ).append("\n"); 
		query.append("      FROM SPC_OFC_LVL O," ).append("\n"); 
		query.append("           PARAMS_CNV  P," ).append("\n"); 
		query.append("           COA_WK_PRD  W" ).append("\n"); 
		query.append("     WHERE O.OFC_CD = P.OFC_CD" ).append("\n"); 
		query.append("       AND O.OFC_LVL IS NOT NULL" ).append("\n"); 
		query.append("       AND W.COST_YR || W.COST_WK BETWEEN O.OFC_APLY_FM_YRWK AND O.OFC_APLY_TO_YRWK" ).append("\n"); 
		query.append("       AND TO_CHAR(SYSDATE, 'YYYYMMDD') BETWEEN W.SLS_FM_DT AND W.SLS_TO_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("  SELECT O.OFC_CD AS  CODE," ).append("\n"); 
		query.append("         O.OFC_ENG_NM ||'~'|| ( SELECT DECODE(O.OFC_CD, DECODE(P.LVL, 2, OI.N2ND_PRNT_OFC_CD," ).append("\n"); 
		query.append("                                                                      3, OI.N3RD_PRNT_OFC_CD," ).append("\n"); 
		query.append("                                                                      4, OI.N4TH_PRNT_OFC_CD," ).append("\n"); 
		query.append("                                                                      5, OI.N5TH_PRNT_OFC_CD," ).append("\n"); 
		query.append("                                                                      6, OI.N6TH_PRNT_OFC_CD), 1, P.USR_OFC_CD, 1, 0)" ).append("\n"); 
		query.append("                                  FROM SPC_OFC_LVL OI," ).append("\n"); 
		query.append("                                       COA_WK_PRD  W" ).append("\n"); 
		query.append("                                 WHERE OI.OFC_CD = P.USR_OFC_CD" ).append("\n"); 
		query.append("                                   AND W.COST_YR || W.COST_WK BETWEEN OI.OFC_APLY_FM_YRWK AND OI.OFC_APLY_TO_YRWK" ).append("\n"); 
		query.append("                                   AND TO_CHAR(SYSDATE, 'YYYYMMDD') BETWEEN W.SLS_FM_DT AND W.SLS_TO_DT" ).append("\n"); 
		query.append("                              ) AS TEXT" ).append("\n"); 
		query.append("    FROM SPC_OFC_LVL O," ).append("\n"); 
		query.append("         PARAMS_OFC  P," ).append("\n"); 
		query.append("         COA_WK_PRD  W" ).append("\n"); 
		query.append("   WHERE (" ).append("\n"); 
		query.append("              (     DECODE(P.F_LVL, 1, O.N1ST_PRNT_OFC_CD," ).append("\n"); 
		query.append("                                    2, O.N2ND_PRNT_OFC_CD," ).append("\n"); 
		query.append("                                    3, O.N3RD_PRNT_OFC_CD," ).append("\n"); 
		query.append("                                    4, O.N4TH_PRNT_OFC_CD," ).append("\n"); 
		query.append("                                    5, O.N5TH_PRNT_OFC_CD," ).append("\n"); 
		query.append("                                    6, O.N6TH_PRNT_OFC_CD," ).append("\n"); 
		query.append("                                    7, O.N7TH_PRNT_OFC_CD) = P.OFC_CD" ).append("\n"); 
		query.append("                AND O.OFC_LVL = P.LVL" ).append("\n"); 
		query.append("              )" ).append("\n"); 
		query.append("           OR ( O.OFC_CD = P.OFC_CD AND P.INC = '1')" ).append("\n"); 
		query.append("         )" ).append("\n"); 
		query.append("     AND O.DELT_FLG = 'N'" ).append("\n"); 
		query.append("     AND W.COST_YR || W.COST_WK BETWEEN O.OFC_APLY_FM_YRWK AND O.OFC_APLY_TO_YRWK" ).append("\n"); 
		query.append("     AND TO_CHAR(SYSDATE, 'YYYYMMDD') BETWEEN W.SLS_FM_DT AND W.SLS_TO_DT" ).append("\n"); 
		query.append("ORDER BY DECODE(O.OFC_CD, P.OFC_CD, 0, 1)," ).append("\n"); 
		query.append("         O.OFC_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'searchChildTeamOfficeList')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* Child Team Office List를  가져 온다 */" ).append("\n"); 
		query.append("WITH PARAMS AS (" ).append("\n"); 
		query.append("    SELECT @[ofcCd] AS OFC_CD, -- 이미 OFFICE CONVERSION이 이루어진 OFFICE" ).append("\n"); 
		query.append("           SPC_SCR_OFC_CONV_FNC(@[loginUsrOfcCd], '') AS USR_OFC_CD, -- 로그인 USER의 ORIGINAL OFFICE" ).append("\n"); 
		query.append("           TO_NUMBER(@[lvl])         AS LVL," ).append("\n"); 
		query.append("           TO_NUMBER(NVL(@[inc], 0)) AS INC" ).append("\n"); 
		query.append("      FROM DUAL" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", PARAMS_CNV AS (" ).append("\n"); 
		query.append("    SELECT NVL(P.OFC_CD, P.USR_OFC_CD) AS OFC_CD," ).append("\n"); 
		query.append("           P.USR_OFC_CD," ).append("\n"); 
		query.append("           P.LVL       ," ).append("\n"); 
		query.append("           P.INC" ).append("\n"); 
		query.append("      FROM PARAMS P" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", PARAMS_OFC AS (" ).append("\n"); 
		query.append("    SELECT DECODE(SIGN(P.LVL - O.OFC_LVL), -1, DECODE(P.LVL, 1, O.N1ST_PRNT_OFC_CD," ).append("\n"); 
		query.append("                                                             2, O.N2ND_PRNT_OFC_CD," ).append("\n"); 
		query.append("                                                             3, O.N3RD_PRNT_OFC_CD," ).append("\n"); 
		query.append("                                                             4, O.N4TH_PRNT_OFC_CD," ).append("\n"); 
		query.append("                                                             5, O.N5TH_PRNT_OFC_CD," ).append("\n"); 
		query.append("                                                             6, O.N6TH_PRNT_OFC_CD," ).append("\n"); 
		query.append("                                                             7, O.N7TH_PRNT_OFC_CD), P.OFC_CD) AS OFC_CD," ).append("\n"); 
		query.append("           P.USR_OFC_CD," ).append("\n"); 
		query.append("           P.LVL       ," ).append("\n"); 
		query.append("           P.INC       ," ).append("\n"); 
		query.append("           O.OFC_LVL   ," ).append("\n"); 
		query.append("           LEAST(P.LVL, O.OFC_LVL) AS F_LVL" ).append("\n"); 
		query.append("      FROM SPC_OFC_LVL O," ).append("\n"); 
		query.append("           PARAMS_CNV  P," ).append("\n"); 
		query.append("           COA_WK_PRD  W" ).append("\n"); 
		query.append("     WHERE O.OFC_CD = P.OFC_CD" ).append("\n"); 
		query.append("       AND O.OFC_LVL IS NOT NULL" ).append("\n"); 
		query.append("       AND W.COST_YR || W.COST_WK BETWEEN O.OFC_APLY_FM_YRWK AND O.OFC_APLY_TO_YRWK" ).append("\n"); 
		query.append("       AND TO_CHAR(SYSDATE, 'YYYYMMDD') BETWEEN W.SLS_FM_DT AND W.SLS_TO_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("  SELECT O.OFC_CD AS CODE," ).append("\n"); 
		query.append("         (O.OFC_ENG_NM ||'~'|| ( SELECT DECODE(O.OFC_CD, DECODE(P.LVL, 2, OI.N2ND_PRNT_OFC_CD," ).append("\n"); 
		query.append("                                                                       3, OI.N3RD_PRNT_OFC_CD," ).append("\n"); 
		query.append("                                                                       4, OI.N4TH_PRNT_OFC_CD," ).append("\n"); 
		query.append("                                                                       5, OI.N5TH_PRNT_OFC_CD," ).append("\n"); 
		query.append("                                                                       6, OI.N6TH_PRNT_OFC_CD), 1, P.USR_OFC_CD, 1, 0)" ).append("\n"); 
		query.append("                                   FROM SPC_OFC_LVL OI," ).append("\n"); 
		query.append("                                        COA_WK_PRD  W" ).append("\n"); 
		query.append("                                  WHERE OI.OFC_CD = P.USR_OFC_CD" ).append("\n"); 
		query.append("                                    AND W.COST_YR || W.COST_WK BETWEEN OI.OFC_APLY_FM_YRWK AND OI.OFC_APLY_TO_YRWK" ).append("\n"); 
		query.append("                                    AND TO_CHAR(SYSDATE, 'YYYYMMDD') BETWEEN W.SLS_FM_DT AND W.SLS_TO_DT" ).append("\n"); 
		query.append("                               )" ).append("\n"); 
		query.append("         ) AS TEXT" ).append("\n"); 
		query.append("    FROM SPC_OFC_LVL O," ).append("\n"); 
		query.append("         PARAMS_OFC  P," ).append("\n"); 
		query.append("         COA_WK_PRD  W" ).append("\n"); 
		query.append("   WHERE (" ).append("\n"); 
		query.append("              (     DECODE(P.F_LVL, 1, O.N1ST_PRNT_OFC_CD," ).append("\n"); 
		query.append("                                    2, O.N2ND_PRNT_OFC_CD," ).append("\n"); 
		query.append("                                    3, O.N3RD_PRNT_OFC_CD," ).append("\n"); 
		query.append("                                    4, O.N4TH_PRNT_OFC_CD," ).append("\n"); 
		query.append("                                    5, O.N5TH_PRNT_OFC_CD," ).append("\n"); 
		query.append("                                    6, O.N6TH_PRNT_OFC_CD," ).append("\n"); 
		query.append("                                    7, O.N7TH_PRNT_OFC_CD) = P.OFC_CD" ).append("\n"); 
		query.append("                AND O.OFC_LVL = P.LVL )" ).append("\n"); 
		query.append("           OR (     O.OFC_CD  = P.OFC_CD" ).append("\n"); 
		query.append("                AND P.INC     = '1'   )" ).append("\n"); 
		query.append("         )" ).append("\n"); 
		query.append("     AND O.DELT_FLG = 'N'" ).append("\n"); 
		query.append("     AND W.COST_YR || W.COST_WK BETWEEN O.OFC_APLY_FM_YRWK AND O.OFC_APLY_TO_YRWK" ).append("\n"); 
		query.append("     AND TO_CHAR(SYSDATE, 'YYYYMMDD') BETWEEN W.SLS_FM_DT AND W.SLS_TO_DT" ).append("\n"); 
		query.append("ORDER BY DECODE(O.OFC_CD, P.OFC_CD, 0, 1)," ).append("\n"); 
		query.append("         O.OFC_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'searchSalesRepList')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* Sales Rep List를  가져 온다 */" ).append("\n"); 
		query.append("WITH PARAMS AS (" ).append("\n"); 
		query.append("    SELECT @[ofcCd]         AS OFC_CD," ).append("\n"); 
		query.append("           @[lvl]           AS LVL   ," ).append("\n"); 
		query.append("           @[loginUsrOfcCd] AS USR_ID" ).append("\n"); 
		query.append("    FROM DUAL" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", OFFICES AS (" ).append("\n"); 
		query.append("    SELECT O.OFC_CD," ).append("\n"); 
		query.append("           O.OFC_ENG_NM AS OFC_NM," ).append("\n"); 
		query.append("           O.OFC_LVL    AS LVL   ," ).append("\n"); 
		query.append("           P.USR_ID" ).append("\n"); 
		query.append("      FROM SPC_OFC_LVL O," ).append("\n"); 
		query.append("           PARAMS      P," ).append("\n"); 
		query.append("           COA_WK_PRD  W" ).append("\n"); 
		query.append("     WHERE (" ).append("\n"); 
		query.append("                (P.LVL = 1 AND O.N1ST_PRNT_OFC_CD = P.OFC_CD)" ).append("\n"); 
		query.append("             OR (P.LVL = 2 AND O.N2ND_PRNT_OFC_CD = P.OFC_CD)" ).append("\n"); 
		query.append("             OR (P.LVL = 3 AND O.N3RD_PRNT_OFC_CD = P.OFC_CD)" ).append("\n"); 
		query.append("             OR (P.LVL = 4 AND O.N4TH_PRNT_OFC_CD = P.OFC_CD)" ).append("\n"); 
		query.append("             OR (P.LVL = 5 AND (O.N5TH_PRNT_OFC_CD = P.OFC_CD OR (O.N4TH_PRNT_OFC_CD = P.OFC_CD AND O.OFC_LVL = 4)))" ).append("\n"); 
		query.append("             OR (P.LVL = 6 AND O.N6TH_PRNT_OFC_CD = P.OFC_CD)" ).append("\n"); 
		query.append("           )" ).append("\n"); 
		query.append("       AND O.DELT_FLG = 'N'" ).append("\n"); 
		query.append("       AND W.COST_YR || W.COST_WK BETWEEN O.OFC_APLY_FM_YRWK AND O.OFC_APLY_TO_YRWK" ).append("\n"); 
		query.append("       AND TO_CHAR(SYSDATE, 'YYYYMMDD') BETWEEN W.SLS_FM_DT AND W.SLS_TO_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("  SELECT SR.SREP_CD AS CODE," ).append("\n"); 
		query.append("         SR.SREP_NM ||'~'|| O.OFC_CD ||'~'|| O.OFC_NM ||'~'|| DECODE(UPPER(O.USR_ID), UPPER(SR.EMPE_CD), 1, 0) AS TEXT" ).append("\n"); 
		query.append("    FROM MDM_SLS_REP SR," ).append("\n"); 
		query.append("         OFFICES     O" ).append("\n"); 
		query.append("   WHERE SR.OFC_CD      = O.OFC_CD" ).append("\n"); 
		query.append("     AND SR.DELT_FLG = 'N'" ).append("\n"); 
		query.append("ORDER BY O.LVL     ," ).append("\n"); 
		query.append("         O.OFC_CD  ," ).append("\n"); 
		query.append("         SR.SREP_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'searchTeamSalesRepList')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* Team Sales Rep List를  가져 온다 */" ).append("\n"); 
		query.append("WITH PARAMS AS (" ).append("\n"); 
		query.append("    SELECT @[ofcCd]         AS OFC_CD," ).append("\n"); 
		query.append("           @[lvl]           AS LVL   ," ).append("\n"); 
		query.append("           @[loginUsrOfcCd] AS USR_ID" ).append("\n"); 
		query.append("      FROM DUAL" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", OFFICES AS (" ).append("\n"); 
		query.append("    SELECT O.OFC_CD," ).append("\n"); 
		query.append("           O.OFC_ENG_NM AS OFC_NM," ).append("\n"); 
		query.append("           O.OFC_LVL    AS LVL   ," ).append("\n"); 
		query.append("           P.USR_ID" ).append("\n"); 
		query.append("      FROM SPC_OFC_LVL O," ).append("\n"); 
		query.append("           PARAMS      P," ).append("\n"); 
		query.append("           COA_WK_PRD  W" ).append("\n"); 
		query.append("     WHERE (" ).append("\n"); 
		query.append("                (P.LVL = 1 AND O.N1ST_PRNT_OFC_CD = P.OFC_CD)" ).append("\n"); 
		query.append("             OR (P.LVL = 2 AND O.N2ND_PRNT_OFC_CD = P.OFC_CD)" ).append("\n"); 
		query.append("             OR (P.LVL = 3 AND O.N3RD_PRNT_OFC_CD = P.OFC_CD)" ).append("\n"); 
		query.append("             OR (P.LVL = 4 AND O.N4TH_PRNT_OFC_CD = P.OFC_CD)" ).append("\n"); 
		query.append("             OR (P.LVL = 5 AND (O.N5TH_PRNT_OFC_CD = P.OFC_CD OR (O.N4TH_PRNT_OFC_CD = P.OFC_CD AND O.OFC_LVL = 4)))" ).append("\n"); 
		query.append("             OR (P.LVL = 6 AND O.N6TH_PRNT_OFC_CD = P.OFC_CD)" ).append("\n"); 
		query.append("           )" ).append("\n"); 
		query.append("       AND O.DELT_FLG = 'N'" ).append("\n"); 
		query.append("       AND W.COST_YR || W.COST_WK BETWEEN O.OFC_APLY_FM_YRWK AND O.OFC_APLY_TO_YRWK" ).append("\n"); 
		query.append("       AND TO_CHAR(SYSDATE, 'YYYYMMDD') BETWEEN W.SLS_FM_DT AND W.SLS_TO_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("  SELECT SR.SREP_CD AS CODE," ).append("\n"); 
		query.append("         SR.SREP_NM || '~' || O.OFC_CD || '~' || O.OFC_NM || '~' || DECODE(UPPER(O.USR_ID), UPPER(SR.EMPE_CD), 1, 0) AS TEXT" ).append("\n"); 
		query.append("    FROM MDM_SLS_REP SR," ).append("\n"); 
		query.append("         OFFICES     O" ).append("\n"); 
		query.append("   WHERE SR.OFC_CD      = O.OFC_CD" ).append("\n"); 
		query.append("     AND SR.DELT_FLG = 'N'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY O.LVL   ," ).append("\n"); 
		query.append("         O.OFC_CD," ).append("\n"); 
		query.append("         SR.SREP_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'searchPortList')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* Port List를  가져 온다 */" ).append("\n"); 
		query.append("SELECT A.LOC_CD CODE," ).append("\n"); 
		query.append("       A.LOC_NM TEXT" ).append("\n"); 
		query.append("  FROM MDM_LOCATION A" ).append("\n"); 
		query.append(" WHERE A.LOC_CD LIKE @[portCd]" ).append("\n"); 
		query.append("   AND NVL(A.PORT_INLND_CD, 'N') = 'Y'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'searchYardList')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* Yard List를  가져 온다 */" ).append("\n"); 
		query.append("SELECT YD_CD AS CODE," ).append("\n"); 
		query.append("       YD_NM AS TEXT" ).append("\n"); 
		query.append("  FROM MDM_YARD" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("#if (${ofcCd} != '')" ).append("\n"); 
		query.append("   AND OFC_CD = @[ofcCd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND YD_CD LIKE UPPER(@[yardCd])||'%'" ).append("\n"); 
		query.append("   AND NVL(DELT_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'searchOperatorList')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* Operator List를  가져 온다 */" ).append("\n"); 
		query.append("  SELECT DISTINCT" ).append("\n"); 
		query.append("         OPR_CD AS CODE," ).append("\n"); 
		query.append("         OPR_CD AS TEXT" ).append("\n"); 
		query.append("    FROM RDR_SUMMARY" ).append("\n"); 
		query.append("ORDER BY OPR_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'searchWeekComboList')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* Week List를  가져 온다 */" ).append("\n"); 
		query.append("  SELECT COST_WK AS CODE," ).append("\n"); 
		query.append("         COST_WK AS TEXT" ).append("\n"); 
		query.append("    FROM COA_WK_PRD" ).append("\n"); 
		query.append("   WHERE COST_YR = @[year]" ).append("\n"); 
		query.append("ORDER BY COST_WK" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'searchCurrWeekList')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* 현재 Week 를  가져 온다 */" ).append("\n"); 
		query.append("SELECT COST_WK AS CODE," ).append("\n"); 
		query.append("       COST_WK AS TEXT" ).append("\n"); 
		query.append("  FROM COA_WK_PRD" ).append("\n"); 
		query.append(" WHERE @[date] BETWEEN SLS_FM_DT AND SLS_TO_DT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}