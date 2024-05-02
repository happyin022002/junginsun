/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : UsaCustomsReportDBDAOsearchBaplieMonitorRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.04.11
*@LastModifier : 
*@LastVersion : 1.0
* 2018.04.11 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaCustomsReportDBDAOsearchBaplieMonitorRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * US AMS Baplie Monitoring Report 조회
	  * </pre>
	  */
	public UsaCustomsReportDBDAOsearchBaplieMonitorRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("due_from_tm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("due_to_tm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("due_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("l_pol",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("due_from_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("customs",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lane",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.usa.integration").append("\n"); 
		query.append("FileName : UsaCustomsReportDBDAOsearchBaplieMonitorRSQL").append("\n"); 
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
		query.append("WITH VSL_PORT_SKD AS (" ).append("\n"); 
		query.append("SELECT V1.*" ).append("\n"); 
		query.append("FROM VSK_VSL_PORT_SKD V1" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if (${vvd} != '')" ).append("\n"); 
		query.append("      AND V1.VSL_CD = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("      AND V1.SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("      AND V1.SKD_DIR_CD = SUBSTR(@[vvd], 9, 1) " ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if (${lane} != '')" ).append("\n"); 
		query.append("      AND V1.SLAN_CD = @[lane] " ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if (${due_from_dt} != '' && ${due_to_dt} != '') " ).append("\n"); 
		query.append("  #if (${srch_dt} == 'atd')" ).append("\n"); 
		query.append("      AND V1.VPS_ETD_DT BETWEEN TO_DATE(REPLACE(REPLACE(@[due_from_dt], '-', ''), '/', '') ||' '|| REPLACE(REPLACE(@[due_from_tm], ':', ''), '-', ''), 'YYYYMMDD HH24MI') AND TO_DATE(REPLACE(REPLACE(@[due_to_dt], '-', ''), '/', '') ||' '|| REPLACE(REPLACE(@[due_to_tm], ':', ''), '-', ''), 'YYYYMMDD HH24MI') " ).append("\n"); 
		query.append("  #end " ).append("\n"); 
		query.append("  #if (${srch_dt} == 'due')" ).append("\n"); 
		query.append("      AND V1.VPS_ETD_DT+2 BETWEEN TO_DATE(REPLACE(REPLACE(@[due_from_dt], '-', ''), '/', '') ||' '|| REPLACE(REPLACE(@[due_from_tm], ':', ''), '-', ''), 'YYYYMMDD HH24MI') AND TO_DATE(REPLACE(REPLACE(@[due_to_dt], '-', ''), '/', '') ||' '|| REPLACE(REPLACE(@[due_to_tm], ':', ''), '-', ''), 'YYYYMMDD HH24MI') " ).append("\n"); 
		query.append("  #end " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${l_pol} != '')" ).append("\n"); 
		query.append("      AND V1.VPS_PORT_CD = @[l_pol]" ).append("\n"); 
		query.append("      /* 입력한 L POL 기준으로 조회한다. 2018.04.11 */ " ).append("\n"); 
		query.append("      AND V1.CLPT_SEQ = (SELECT MAX(CLPT_SEQ)" ).append("\n"); 
		query.append("                         FROM VSK_VSL_PORT_SKD SV2" ).append("\n"); 
		query.append("                        WHERE V1.VSL_CD      = SV2.VSL_CD" ).append("\n"); 
		query.append("                          AND V1.SKD_VOY_NO  = SV2.SKD_VOY_NO  " ).append("\n"); 
		query.append("                          AND V1.SKD_DIR_CD  = SV2.SKD_DIR_CD" ).append("\n"); 
		query.append("                          AND V1.VPS_PORT_CD = SV2.VPS_PORT_CD" ).append("\n"); 
		query.append("                          AND NVL(SV2.SKD_CNG_STS_CD, 'X') != 'S'  " ).append("\n"); 
		query.append("                        ) " ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("      AND V1.CLPT_SEQ = (" ).append("\n"); 
		query.append("        SELECT --B.VSL_CD, B.SKD_VOY_NO, B.SKD_DIR_CD, " ).append("\n"); 
		query.append("          MAX(SV2.CLPT_SEQ)" ).append("\n"); 
		query.append("        FROM (" ).append("\n"); 
		query.append("            SELECT VSL_CD," ).append("\n"); 
		query.append("              SKD_VOY_NO ," ).append("\n"); 
		query.append("              SKD_DIR_CD," ).append("\n"); 
		query.append("              MIN(CLPT_SEQ) CLPT_SEQ" ).append("\n"); 
		query.append("            FROM VSK_VSL_PORT_SKD K" ).append("\n"); 
		query.append("            WHERE 1=1" ).append("\n"); 
		query.append("              AND VPS_PORT_CD LIKE 'US%'" ).append("\n"); 
		query.append("              AND NVL(SKD_CNG_STS_CD, 'X') != 'S'" ).append("\n"); 
		query.append("            GROUP BY VSL_CD, SKD_VOY_NO , SKD_DIR_CD ) SV1," ).append("\n"); 
		query.append("          VSK_VSL_PORT_sKD SV2" ).append("\n"); 
		query.append("        WHERE sV1.VSl_CD = SV2.VSL_CD" ).append("\n"); 
		query.append("          AND SV1.SKD_VOY_NO = SV2.SKD_VOY_NO" ).append("\n"); 
		query.append("          AND sV1.SKD_dIR_CD = SV2.SKD_dIR_CD" ).append("\n"); 
		query.append("          AND NVL(SV2.SKD_CNG_STS_CD, 'X') != 'S'" ).append("\n"); 
		query.append("          AND sV2.CLPT_SEQ < SV1.CLPT_SEQ" ).append("\n"); 
		query.append("          AND SV2.VSl_CD = V1.VSL_CD" ).append("\n"); 
		query.append("          AND SV2.SKD_VOY_NO = V1.SKD_VOY_NO" ).append("\n"); 
		query.append("          AND SV2.SKD_dIR_CD = V1.SKD_dIR_CD" ).append("\n"); 
		query.append("-- exception for canal type port" ).append("\n"); 
		query.append("          AND SV2.VPS_PORT_CD NOT IN (" ).append("\n"); 
		query.append("            SELECT ATTR_CTNT1" ).append("\n"); 
		query.append("            FROM BKG_CSTMS_CD_CONV_CTNT" ).append("\n"); 
		query.append("            WHERE CNT_CD = 'US'" ).append("\n"); 
		query.append("              AND CSTMS_DIV_ID='CANAL_LOC_CD' )" ).append("\n"); 
		query.append("        GROUP BY SV2.VSL_CD, SV2.SKD_VOY_NO, SV2.SKD_DIR_CD " ).append("\n"); 
		query.append("      )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT LANE,VVD," ).append("\n"); 
		query.append("  RHQ," ).append("\n"); 
		query.append("  L_POL," ).append("\n"); 
		query.append("  CNTR_CNT," ).append("\n"); 
		query.append("  'ACK :'||ACK_KNT||' / REJ :'||REJ_KNT CSTMS_RSLT," ).append("\n"); 
		query.append("  SND_STS," ).append("\n"); 
		query.append("  SND_DT," ).append("\n"); 
		query.append("  ATD," ).append("\n"); 
		query.append("  DUE," ).append("\n"); 
		query.append("  RCV_DT," ).append("\n"); 
		query.append("      NVL( (" ).append("\n"); 
		query.append("        SELECT 'YES'" ).append("\n"); 
		query.append("        FROM BKG_CSTMS_ADV_SND_LOG A ," ).append("\n"); 
		query.append("             BKG_CSTMS_ADV_RCV_lOG B" ).append("\n"); 
		query.append("        WHERE 1=1" ).append("\n"); 
		query.append("          AND A.CNT_CD = 'US'" ).append("\n"); 
		query.append("          AND A.IO_BND_CD= 'I'" ).append("\n"); 
		query.append("          AND A.TRSM_MSG_TP_ID='MI'" ).append("\n"); 
		query.append("		  AND A.CNT_CD = B.CNT_CD" ).append("\n"); 
		query.append("          AND A.IO_BND_CD= B.IO_BND_CD" ).append("\n"); 
		query.append("          AND A.CRR_bAT_NO = B.CRR_BAT_NO" ).append("\n"); 
		query.append("        AND SUBSTR(CI.VVD, 1, 4) = A.VSL_CD" ).append("\n"); 
		query.append("        AND SUBSTR(CI.VVD, 5, 4) = A.SKD_VOY_NO" ).append("\n"); 
		query.append("        AND SUBSTR(CI.VVD, 9, 1) = A.SKD_DIR_CD" ).append("\n"); 
		query.append("        AND ROWNUM=1" ).append("\n"); 
		query.append("       ), 'No' ) MI_STS" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT VC.CRR_CD," ).append("\n"); 
		query.append("      MAX(V1.SLAN_CD) LANE," ).append("\n"); 
		query.append("	  V1.VSL_CD||V1.SKD_VOY_NO||V1.SKD_DIR_CD VVD," ).append("\n"); 
		query.append("      MAX(OLA.REGION) RHQ," ).append("\n"); 
		query.append("      V1.VPS_PORT_CD L_POL," ).append("\n"); 
		query.append("      MAX((" ).append("\n"); 
		query.append("            SELECT VPS_PORT_CD" ).append("\n"); 
		query.append("            FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("            WHERE 1=1" ).append("\n"); 
		query.append("              AND VSL_CD = V1.VSL_CD" ).append("\n"); 
		query.append("              AND SKD_VOY_NO = V1.SKD_VOY_NO" ).append("\n"); 
		query.append("              AND SKD_DIR_CD = V1.SKD_DIR_CD" ).append("\n"); 
		query.append("              AND NVL(SKD_CNG_STS_CD, 'X') != 'S'" ).append("\n"); 
		query.append("              AND CLPT_SEQ > (" ).append("\n"); 
		query.append("                SELECT MAX(CLPT_SEQ)" ).append("\n"); 
		query.append("                FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("                WHERE 1=1" ).append("\n"); 
		query.append("                  AND VSL_CD = V1.VSL_CD" ).append("\n"); 
		query.append("                  AND SKD_VOY_NO = V1.SKD_VOY_NO" ).append("\n"); 
		query.append("                  AND SKD_DIR_CD = V1.SKD_DIR_CD" ).append("\n"); 
		query.append("                  AND VPS_PORT_CD = V1.VPS_PORT_CD" ).append("\n"); 
		query.append("                  AND NVL(SKD_CNG_STS_CD, 'X') != 'S' )" ).append("\n"); 
		query.append("              AND CLPT_IND_SEQ > 0" ).append("\n"); 
		query.append("              AND VPS_PORT_CD LIKE 'US%'" ).append("\n"); 
		query.append("              AND ROWNUM = 1 )) CSTMS_PORT_CD," ).append("\n"); 
		query.append("      COUNT(A.ID) TOT_CNTR_KNT," ).append("\n"); 
		query.append(" -- BAY_PLAN 생성 CNTR 수" ).append("\n"); 
		query.append("      DECODE( COUNT(L.CNTR_NO), 0, COUNT(A.ID), COUNT(L.CNTR_NO) ) CNTR_CNT," ).append("\n"); 
		query.append("      COUNT(L.CNTR_NO) SND_KNT," ).append("\n"); 
		query.append(" -- 전송 CNTR 수" ).append("\n"); 
		query.append("      SUM( DECODE( ACK_RCV_STS_CD, 'A' , 1, 0 ) ) ACK_KNT," ).append("\n"); 
		query.append("      SUM( DECODE( ACK_RCV_STS_CD, 'R' , 1, 0 ) ) REJ_KNT," ).append("\n"); 
		query.append("      DECODE(COUNT(L.CNTR_NO), 0, 'No', 'Yes' ) SND_STS," ).append("\n"); 
		query.append("      TO_CHAR(MAX(L.SND_dT), 'YYYY-MM-DD HH24:MI') SND_DT," ).append("\n"); 
		query.append("      TO_CHAR(MAX(V1.VPS_eTD_DT), 'YYYY-MM-DD HH24:MI') ATD," ).append("\n"); 
		query.append("      TO_CHAR(MAX(V1.VPS_eTD_DT)+2, 'YYYY-MM-DD HH24:MI') DUE," ).append("\n"); 
		query.append("      TO_CHAR(MAX( L.RCV_dT), 'YYYY-MM-DD HH24:MI') RCV_DT" ).append("\n"); 
		query.append("    FROM VSL_PORT_SKD V1," ).append("\n"); 
		query.append("      MDM_VSL_CNTR VC," ).append("\n"); 
		query.append("      (" ).append("\n"); 
		query.append("       SELECT BAY.*" ).append("\n"); 
		query.append("        FROM (" ).append("\n"); 
		query.append("        SELECT RANK() OVER(PARTITION BY SKD.VSL_CD, SKD.SKD_VOY_NO, SKD.SKD_DIR_CD, SKD.VPS_PORT_CD" ).append("\n"); 
		query.append("            ORDER BY SKD.ETD_DT DESC) AS RNK," ).append("\n"); 
		query.append("          SKD.VSL_CD," ).append("\n"); 
		query.append("          SKD.SKD_VOY_NO," ).append("\n"); 
		query.append("          SKD.SKD_DIR_CD," ).append("\n"); 
		query.append("          SKD.VPS_PORT_CD," ).append("\n"); 
		query.append("          SKD.CLPT_IND_SEQ," ).append("\n"); 
		query.append("          DECODE(CHK_MTY_PLN_FLG, 'Y', 'E', 'F') AS PLAN_TYPE" ).append("\n"); 
		query.append("        FROM STO_PLN_VSL_PORT_SKD SKD, VSL_PORT_SKD V1" ).append("\n"); 
		query.append("        WHERE (CHK_FNL_PLN_FLG='Y' OR CHK_MTY_PLN_FLG='Y')" ).append("\n"); 
		query.append("            AND SKD.VSL_CD(+) = V1.VSL_CD" ).append("\n"); 
		query.append("           AND SKD.SKD_VOY_NO(+) = V1.SKD_VOY_NO" ).append("\n"); 
		query.append("           AND SKD.SKD_DIR_CD(+)= V1.SKD_DIR_CD" ).append("\n"); 
		query.append("           AND SKD.VPS_PORT_CD(+)= V1.VPS_PORT_CD" ).append("\n"); 
		query.append("      ) SKD, BAY_PLAN BAY" ).append("\n"); 
		query.append("      WHERE SKD.RNK = 1" ).append("\n"); 
		query.append("           AND SKD.VSL_CD = BAY.VSL_CD" ).append("\n"); 
		query.append("           AND SKD.SKD_VOY_NO = BAY.VOY_NO" ).append("\n"); 
		query.append("           AND SKD.SKD_DIR_CD = BAY.DIR_CD" ).append("\n"); 
		query.append("           AND SKD.VPS_PORT_CD = BAY.PORT_CD" ).append("\n"); 
		query.append("           AND SKD.CLPT_IND_SEQ = BAY.CALL_IND" ).append("\n"); 
		query.append("           AND SKD.PLAN_TYPE = BAY.PLAN_TYPE" ).append("\n"); 
		query.append("      ) A," ).append("\n"); 
		query.append("      BKG_CSTMS_ADV_STWG_CNTR L," ).append("\n"); 
		query.append("      MDM_LOCATION ML," ).append("\n"); 
		query.append("      (" ).append("\n"); 
		query.append("        SELECT OFC_N3RD_LVL_CD REGION ," ).append("\n"); 
		query.append("          OFC_N8TH_LVL_CD OFC_CD" ).append("\n"); 
		query.append("        FROM (" ).append("\n"); 
		query.append("            SELECT OFC_KIND OFC_KND_CD ," ).append("\n"); 
		query.append("              A.DEL ," ).append("\n"); 
		query.append("              A.OFC_CD OFC_N8TH_LVL_CD ," ).append("\n"); 
		query.append("              L1 OFC_LVL ," ).append("\n"); 
		query.append("              DECODE(A.L1, 1, A.OFC_CD, 2, A.OFC_CD, 3, A.OFC_CD, 4, A.OFC_CD, 5, A.OFC_CD, 6, A.OFC_CD, 7, A.OFC_CD, 8, B.OFC_CD) OFC_N7TH_LVL_CD ," ).append("\n"); 
		query.append("              DECODE(A.L1, 1, A.OFC_CD, 2, A.OFC_CD, 3, A.OFC_CD, 4, A.OFC_CD, 5, A.OFC_CD, 6, A.OFC_CD, 7, B.OFC_CD, 8, C.OFC_CD) OFC_N6TH_LVL_CD ," ).append("\n"); 
		query.append("              DECODE(A.L1, 1, A.OFC_CD, 2, A.OFC_CD, 3, A.OFC_CD, 4, A.OFC_CD, 5, A.OFC_CD, 6, B.OFC_CD, 7, C.OFC_CD, 8, D.OFC_CD) OFC_N5TH_LVL_CD ," ).append("\n"); 
		query.append("              DECODE(A.L1, 1, A.OFC_CD, 2, A.OFC_CD, 3, A.OFC_CD, 4, A.OFC_CD, 5, B.OFC_CD, 6, C.OFC_CD, 7, D.OFC_CD, 8, E.OFC_CD) OFC_N4TH_LVL_CD ," ).append("\n"); 
		query.append("              DECODE(A.L1, 1, A.OFC_CD, 2, A.OFC_CD, 3, A.OFC_CD, 4, B.OFC_CD, 5, C.OFC_CD, 6, D.OFC_CD, 7, E.OFC_CD, 8, F.OFC_CD) OFC_N3RD_LVL_CD ," ).append("\n"); 
		query.append("              DECODE(A.L1, 1, A.OFC_CD, 2, A.OFC_CD, 3, B.OFC_CD, 4, C.OFC_CD, 5, D.OFC_CD, 6, E.OFC_CD, 7, F.OFC_CD, 8, G.OFC_CD) OFC_N2ND_LVL_CD ," ).append("\n"); 
		query.append("              DECODE(A.L1, 1, A.OFC_CD, 2, B.OFC_CD, 3, C.OFC_CD, 4, D.OFC_CD, 5, E.OFC_CD, 6, F.OFC_CD, 7, G.OFC_CD, 8, H.OFC_CD) OFC_N1ST_LVL_CD" ).append("\n"); 
		query.append("            FROM (" ).append("\n"); 
		query.append("                SELECT OFC_CD ," ).append("\n"); 
		query.append("                  LOC_CD ," ).append("\n"); 
		query.append("                  PRNT_OFC_CD ," ).append("\n"); 
		query.append("                  DELT_FLG DEL ," ).append("\n"); 
		query.append("                  A.OFC_KND_CD OFC_KIND ," ).append("\n"); 
		query.append("                  LEVEL L1" ).append("\n"); 
		query.append("                FROM MDM_ORGANIZATION A START WITH A.OFC_CD = 'SELHO' CONNECT BY PRIOR A.OFC_CD = A.PRNT_OFC_CD ) A ," ).append("\n"); 
		query.append("              MDM_ORGANIZATION B ," ).append("\n"); 
		query.append("              MDM_ORGANIZATION C ," ).append("\n"); 
		query.append("              MDM_ORGANIZATION D ," ).append("\n"); 
		query.append("              MDM_ORGANIZATION E ," ).append("\n"); 
		query.append("              MDM_ORGANIZATION F ," ).append("\n"); 
		query.append("              MDM_ORGANIZATION G ," ).append("\n"); 
		query.append("              MDM_ORGANIZATION H" ).append("\n"); 
		query.append("            WHERE A.PRNT_OFC_CD = B.OFC_CD(+)" ).append("\n"); 
		query.append("              AND B.PRNT_OFC_CD = C.OFC_CD(+)" ).append("\n"); 
		query.append("              AND C.PRNT_OFC_CD = D.OFC_CD(+)" ).append("\n"); 
		query.append("              AND D.PRNT_OFC_CD = E.OFC_CD(+)" ).append("\n"); 
		query.append("              AND E.PRNT_OFC_CD = F.OFC_CD(+)" ).append("\n"); 
		query.append("              AND F.PRNT_OFC_CD = G.OFC_CD(+)" ).append("\n"); 
		query.append("              AND G.PRNT_OFC_CD = H.OFC_CD(+) )" ).append("\n"); 
		query.append("        WHERE 1=1" ).append("\n"); 
		query.append("--  AND NVL(DEL, 'N') = 'N'" ).append("\n"); 
		query.append("          AND OFC_N3RD_LVL_CD IS NOT NULL" ).append("\n"); 
		query.append("          AND OFC_N3RD_LVL_CD IN (" ).append("\n"); 
		query.append("            SELECT OFC_CD" ).append("\n"); 
		query.append("            FROM (" ).append("\n"); 
		query.append("                SELECT OFC_CD ," ).append("\n"); 
		query.append("                  LOC_CD ," ).append("\n"); 
		query.append("                  PRNT_OFC_CD ," ).append("\n"); 
		query.append("                  DELT_FLG DEL ," ).append("\n"); 
		query.append("                  A.OFC_KND_CD OFC_KIND ," ).append("\n"); 
		query.append("                  LEVEL L1" ).append("\n"); 
		query.append("                FROM MDM_ORGANIZATION A START WITH A.OFC_CD = 'SELHO' CONNECT BY PRIOR A.OFC_CD = A.PRNT_OFC_CD )" ).append("\n"); 
		query.append("            WHERE L1 =3" ).append("\n"); 
		query.append("              AND OFC_KIND = '2' )" ).append("\n"); 
		query.append("          AND OFC_N6TH_LVL_CD IS NOT NULL ) OLA" ).append("\n"); 
		query.append("    WHERE 1=1 " ).append("\n"); 
		query.append("-- V1 : L.Foreign Port 에 대한 체크 (US 바로전 PORT인지)" ).append("\n"); 
		query.append("      AND V1.VSL_CD = A.VSL_CD(+)" ).append("\n"); 
		query.append("      AND V1.SKD_VOY_NO = A.VOY_NO(+)" ).append("\n"); 
		query.append("      AND V1.SKD_DIR_CD = A.DIR_CD(+)" ).append("\n"); 
		query.append("      AND V1.VPS_PORT_CD = A.PORT_CD(+)" ).append("\n"); 
		query.append("      AND A.VSL_CD = L.VSL_CD(+)" ).append("\n"); 
		query.append("      AND A.VOY_NO = L.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("      AND A.DIR_CD = L.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("      AND A.ID = L.CNTR_NO(+)" ).append("\n"); 
		query.append("      AND A.PORT_CD = L.LODG_PORT_CD(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("     /*AND NVL(A.PLAN_TYPE, 'XX')=  " ).append("\n"); 
		query.append("     NVL((" ).append("\n"); 
		query.append("           SELECT DECODE(CHK_MTY_PLN_FLG, 'Y', 'E', 'F') AS PLAN_TYPE" ).append("\n"); 
		query.append("           FROM STO_PLN_VSL_PORT_SKD BB" ).append("\n"); 
		query.append("           WHERE BB.VSL_CD = A.VSL_CD" ).append("\n"); 
		query.append("            AND BB.SKD_VOY_NO= A.VOY_NO" ).append("\n"); 
		query.append("            AND BB.SKD_DIR_CD= A.DIR_CD" ).append("\n"); 
		query.append("            AND BB.VPS_PORT_CD= A.PORT_CD" ).append("\n"); 
		query.append("            AND CLPT_IND_SEQ='1'" ).append("\n"); 
		query.append("       ),'XX')*/" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("      AND V1.VSL_CD = VC.VSL_CD" ).append("\n"); 
		query.append("      AND VC.CRR_CD = 'SML'" ).append("\n"); 
		query.append("      AND ML.LOC_CD = V1.VPS_PORT_CD" ).append("\n"); 
		query.append("      AND OLA.OFC_CD = ML.EQ_CTRL_OFC_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("      AND NOT EXISTS (" ).append("\n"); 
		query.append("                    SELECT 'X'" ).append("\n"); 
		query.append("                    FROM BKG_CSTMS_CD_CONV_CTNT" ).append("\n"); 
		query.append("                    WHERE CNT_CD = 'US'" ).append("\n"); 
		query.append("                    AND CSTMS_DIV_ID= 'BAPLIE_XCLD_CNTR_CD'" ).append("\n"); 
		query.append("                    AND ATTR_CTNT1 = A.ID" ).append("\n"); 
		query.append("                )   " ).append("\n"); 
		query.append("   " ).append("\n"); 
		query.append("    GROUP BY VC.CRR_CD, V1.VSL_CD, V1.SKD_VOY_NO,V1.SKD_DIR_CD , V1.VPS_PORT_CD ) CI" ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${snd_sts} != '') " ).append("\n"); 
		query.append("#if (${snd_sts} == 'N')" ).append("\n"); 
		query.append("  AND CI.SND_KNT = 0 " ).append("\n"); 
		query.append("#elseif (${snd_sts} == 'Y')" ).append("\n"); 
		query.append("  AND CI.SND_KNT > 0 " ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if (${customs} != '')" ).append("\n"); 
		query.append("  AND CI.CSTMS_PORT_CD = @[customs] " ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}