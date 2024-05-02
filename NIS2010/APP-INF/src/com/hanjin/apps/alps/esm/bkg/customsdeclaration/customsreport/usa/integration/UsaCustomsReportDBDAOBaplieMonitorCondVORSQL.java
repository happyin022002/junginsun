/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : UsaCustomsReportDBDAOBaplieMonitorCondVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.06.24
*@LastModifier : 김봉균
*@LastVersion : 1.0
* 2011.06.24 김봉균
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM BONG GYOON
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaCustomsReportDBDAOBaplieMonitorCondVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * US AMS Baplie Monitoring Report의 조회 SQL
	  * </pre>
	  */
	public UsaCustomsReportDBDAOBaplieMonitorCondVORSQL(){
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
		query.append("FileName : UsaCustomsReportDBDAOBaplieMonitorCondVORSQL").append("\n"); 
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
		query.append("SELECT LANE," ).append("\n"); 
		query.append("  VVD," ).append("\n"); 
		query.append("  RHQ," ).append("\n"); 
		query.append("  L_POL," ).append("\n"); 
		query.append("  CNTR_CNT," ).append("\n"); 
		query.append("  'ACK :'||ACK_KNT||' / REJ :'||REJ_KNT CSTMS_RSLT," ).append("\n"); 
		query.append("  SND_STS," ).append("\n"); 
		query.append("  SND_DT," ).append("\n"); 
		query.append("  ATD," ).append("\n"); 
		query.append("  DUE," ).append("\n"); 
		query.append("  RCV_DT," ).append("\n"); 
		query.append("  MI_STS" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT VC.CRR_CD," ).append("\n"); 
		query.append("      MAX(V1.SLAN_CD) LANE," ).append("\n"); 
		query.append("      V1.VSL_CD || V1.SKD_VOY_NO || V1.SKD_DIR_CD VVD," ).append("\n"); 
		query.append("      '' RHQ," ).append("\n"); 
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
		query.append("                SELECT CLPT_SEQ" ).append("\n"); 
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
		query.append("      COUNT(A.ID) TOT_CNTR_KNT, -- BAY_PLAN 생성 CNTR 수" ).append("\n"); 
		query.append("      DECODE( COUNT(L.CNTR_NO), 0, COUNT(A.ID), COUNT(L.CNTR_NO) ) CNTR_CNT," ).append("\n"); 
		query.append("      COUNT(L.CNTR_NO) SND_KNT, -- 전송 CNTR 수" ).append("\n"); 
		query.append("      SUM( DECODE( ACK_RCV_STS_CD, 'A' , 1, 0 ) ) ACK_KNT," ).append("\n"); 
		query.append("      SUM( DECODE( ACK_RCV_STS_CD, 'R' , 1, 0 ) ) REJ_KNT," ).append("\n"); 
		query.append("      DECODE(COUNT(L.CNTR_NO), 0, 'No', 'Yes' ) SND_STS," ).append("\n"); 
		query.append("      TO_CHAR(MAX(L.SND_dT), 'YYYY-MM-DD HH24:MI') SND_DT," ).append("\n"); 
		query.append("      TO_CHAR(MAX(V1.VPS_eTD_DT), 'YYYY-MM-DD HH24:MI') ATD," ).append("\n"); 
		query.append("      TO_CHAR(MAX(V1.VPS_eTD_DT)+2, 'YYYY-MM-DD HH24:MI') DUE," ).append("\n"); 
		query.append("      TO_CHAR(MAX( L.RCV_dT), 'YYYY-MM-DD HH24:MI') RCV_DT," ).append("\n"); 
		query.append("      DECODE(MAX((" ).append("\n"); 
		query.append("                SELECT TRSM_MSG_TP_ID" ).append("\n"); 
		query.append("                FROM BKG_CSTMS_ADV_SND_LOG A ," ).append("\n"); 
		query.append("                  BKG_CSTMS_ADV_RCV_lOG B" ).append("\n"); 
		query.append("                WHERE 1=1" ).append("\n"); 
		query.append("                  AND A.CNT_CD = 'US'" ).append("\n"); 
		query.append("                  AND A.IO_BND_CD= 'I'" ).append("\n"); 
		query.append("                  AND A.VSL_CD = V1.VSL_CD" ).append("\n"); 
		query.append("                  AND A.SKD_VOY_NO = V1.SKD_VOY_NO" ).append("\n"); 
		query.append("                  AND A.SKD_DIR_CD = V1.SKD_DIR_CD" ).append("\n"); 
		query.append("                  AND A.CRR_bAT_NO = B.CRR_BAT_NO" ).append("\n"); 
		query.append("                  AND ROWNUM = 1 )), 'MI', 'Yes', 'No') MI_STS" ).append("\n"); 
		query.append("    FROM VSK_VSL_PORT_SKD V1," ).append("\n"); 
		query.append("      MDM_VSL_CNTR VC," ).append("\n"); 
		query.append("      BAY_PLAN A," ).append("\n"); 
		query.append("      BKG_CSTMS_ADV_STWG_CNTR L" ).append("\n"); 
		query.append("    WHERE 1=1 " ).append("\n"); 
		query.append("    #if (${vvd} != '')" ).append("\n"); 
		query.append("      AND V1.VSL_CD = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("      AND V1.SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("      AND V1.SKD_DIR_CD = SUBSTR(@[vvd], 9, 1) " ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${l_pol} != '')" ).append("\n"); 
		query.append("      and V1.VPS_PORT_CD = @[l_pol]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${lane} != '')" ).append("\n"); 
		query.append("      AND V1.SLAN_CD = @[lane]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${srch_dt} == 'atd')" ).append("\n"); 
		query.append("      AND V1.VPS_ETD_DT BETWEEN TO_DATE(@[due_from_dt], 'YYYY-MM-DD') AND TO_DATE(@[due_to_dt], 'YYYY-MM-DD')" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${srch_dt} == 'due')" ).append("\n"); 
		query.append("      AND V1.VPS_ETD_DT+2 BETWEEN TO_DATE(@[due_from_dt], 'YYYY-MM-DD') AND TO_DATE(@[due_to_dt], 'YYYY-MM-DD')" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
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
		query.append("        GROUP BY SV2.VSL_CD, SV2.SKD_VOY_NO, SV2.SKD_DIR_CD )" ).append("\n"); 
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
		query.append("      AND V1.VSL_CD = VC.VSL_CD" ).append("\n"); 
		query.append("      AND VC.CRR_CD = 'SML'" ).append("\n"); 
		query.append("    GROUP BY VC.CRR_CD, V1.VSL_CD || V1.SKD_VOY_NO || V1.SKD_DIR_CD , V1.VPS_PORT_CD ) CI" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if (${snd_sts} != '')" ).append("\n"); 
		query.append("#if (${snd_sts} == 'N')" ).append("\n"); 
		query.append("  AND CI.CNTR_CNT = 0" ).append("\n"); 
		query.append("#elseif (${snd_sts} == 'Y')" ).append("\n"); 
		query.append("  AND CI.CNTR_CNT > 0" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${customs} != '')" ).append("\n"); 
		query.append("  AND CI.CSTMS_PORT_CD = @[customs]" ).append("\n"); 
		query.append("#end " ).append("\n"); 

	}
}