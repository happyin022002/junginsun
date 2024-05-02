/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : OceanRouteManageDBDAOSearchOceanRouteSingleCreationRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.01.17
*@LastModifier : 박만건
*@LastVersion : 1.0
* 2012.01.17 박만건
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanroutemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Mangeon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OceanRouteManageDBDAOSearchOceanRouteSingleCreationRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2011.09.08 변종건 Ocean Route Multi Creation의 Validation Check 및 Total Time 구하기
	  * </pre>
	  */
	public OceanRouteManageDBDAOSearchOceanRouteSingleCreationRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_pol",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_ts1_lane",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_ts3_port",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_ts2_lane",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_ts4_lane",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_pod",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_ts1_port",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_ts2_port",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_ts3_lane",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanroutemanage.integration").append("\n"); 
		query.append("FileName : OceanRouteManageDBDAOSearchOceanRouteSingleCreationRSQL").append("\n"); 
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
		query.append("SELECT 'M' ST" ).append("\n"); 
		query.append("     , TRIM(@[s_pol]) ORG_LOC_CD" ).append("\n"); 
		query.append("     , TRIM(@[s_pod]) DEST_LOC_CD" ).append("\n"); 
		query.append("     , POL1, POD1, LANE1, DIR1, FDR_FLG1, SVC_TP1" ).append("\n"); 
		query.append("     , POL2, POD2, LANE2, DIR2, FDR_FLG2, SVC_TP2" ).append("\n"); 
		query.append("     , POL3, POD3, LANE3, DIR3, FDR_FLG3, SVC_TP3" ).append("\n"); 
		query.append("     , POL4, POD4, LANE4, DIR4, FDR_FLG4, SVC_TP4" ).append("\n"); 
		query.append("--     , DECODE(LINK_VALID_FLG, 'N', NULL, DECODE(LK.LINK_COUNT,1,1,2,2,3,4,4,6,NULL)) PRIO" ).append("\n"); 
		query.append("     , CASE WHEN LINK_VALID_FLG = 'N' THEN NULL" ).append("\n"); 
		query.append("            WHEN LK.LINK_COUNT = 1 THEN 1" ).append("\n"); 
		query.append("            WHEN LK.LINK_COUNT = 2 THEN DECODE('C', SVC_TP1, 3, SVC_TP2, 3, 2)" ).append("\n"); 
		query.append("            WHEN LK.LINK_COUNT = 3 THEN DECODE('C', SVC_TP1, 5, SVC_TP2, 5, SVC_TP3, 5, 4)" ).append("\n"); 
		query.append("            WHEN LK.LINK_COUNT = 4 THEN 6" ).append("\n"); 
		query.append("            END PRIO" ).append("\n"); 
		query.append("     , '' RMK" ).append("\n"); 
		query.append("     , NVL(TT1 + TT2 + TT3 + TT4,0) TOT_TT" ).append("\n"); 
		query.append("     , LTRIM(TO_CHAR(TRUNC((TT1 + TT2 + TT3 + TT4)/24),'00'))||LTRIM(TO_CHAR(MOD((TT1 + TT2 + TT3 + TT4),24  ),'00')) FMT_TOT_TT" ).append("\n"); 
		query.append("     , TT1, TT2, TT3, TT4" ).append("\n"); 
		query.append("     , ST1 + ST2 + ST3 TOT_ST" ).append("\n"); 
		query.append("     , LTRIM(TO_CHAR(TRUNC((ST1 + ST2 + ST3)/24),'00'))||LTRIM(TO_CHAR(MOD((ST1 + ST2 + ST3),24  ),'00')) FMT_TOT_ST" ).append("\n"); 
		query.append("     , ST1, ST2, ST3" ).append("\n"); 
		query.append("     , LNK_DIST1 N1ST_LNK_DIST, LNK_DIST2 N2ND_LNK_DIST, LNK_DIST3 N3RD_LNK_DIST, LNK_DIST4 N4TH_LNK_DIST" ).append("\n"); 
		query.append("     , TS_IND" ).append("\n"); 
		query.append("     , FDR_USD" ).append("\n"); 
		query.append("     , POD1ETB, POL2ETB, POD2ETB, POL3ETB, POD3ETB, POL4ETB" ).append("\n"); 
		query.append("     , LK.LINK_COUNT" ).append("\n"); 
		query.append("     , '' P1" ).append("\n"); 
		query.append("     , 'N' BKG_IND" ).append("\n"); 
		query.append("     , DECODE(TG.ORG_LOC_CD, NULL, 'N', 'Y') TG_EXIST" ).append("\n"); 
		query.append("     , 0 BKG_CNT" ).append("\n"); 
		query.append("     , NVL(TG.UPD_IND_CD,'S') UPD_IND_CD" ).append("\n"); 
		query.append("     , TO_CHAR(TG.CRE_DT , 'YYYY-MM-DD')C_DATE" ).append("\n"); 
		query.append("     , TG.CRE_USR_ID C_USER" ).append("\n"); 
		query.append("     , TG.ROUT_SEQ" ).append("\n"); 
		query.append("     , CASE WHEN LINK_VALID_FLG = 'Y' THEN 'Y'" ).append("\n"); 
		query.append("            WHEN LK.LK1 = 1 AND SVC_TP1 IS NULL THEN '1'" ).append("\n"); 
		query.append("            WHEN LK.LK2 = 2 AND SVC_TP2 IS NULL THEN '2'" ).append("\n"); 
		query.append("            WHEN LK.LK3 = 3 AND SVC_TP3 IS NULL THEN '3'" ).append("\n"); 
		query.append("            WHEN LK.LK4 = 4 AND SVC_TP4 IS NULL THEN '4'" ).append("\n"); 
		query.append("            ELSE 'N' END LINK_VALID_FLG" ).append("\n"); 
		query.append("     , LTRIM(TO_CHAR(TRUNC((TT1 + TT2 + TT3 + TT4)/24),'00'))||LTRIM(TO_CHAR(MOD((TT1 + TT2 + TT3 + TT4),24  ),'00')) FMT_TOT_TT" ).append("\n"); 
		query.append("     , LTRIM(TO_CHAR(TRUNC((ST1 + ST2 + ST3)/24),'00'))||LTRIM(TO_CHAR(MOD((ST1 + ST2 + ST3),24  ),'00')) FMT_TOT_ST" ).append("\n"); 
		query.append("     , LTRIM(TO_CHAR(TRUNC((TT1 + TT2 + TT3 + TT4 + ST1 + ST2 + ST3)/24),'00'))||LTRIM(TO_CHAR(MOD((TT1 + TT2 + TT3 + TT4 + ST1 + ST2 + ST3),24  ),'00')) FMT_TT" ).append("\n"); 
		query.append("     , TRIM(@[s_pol]) || '/' || TRIM(@[s_ts1_lane]) || '/' || TRIM(@[s_ts1_port])" ).append("\n"); 
		query.append("                      || '/' || TRIM(@[s_ts2_lane]) || '/' || TRIM(@[s_ts2_port])" ).append("\n"); 
		query.append("                      || '/' || TRIM(@[s_ts3_lane]) || '/' || TRIM(@[s_ts3_port])" ).append("\n"); 
		query.append("                      || '/' || TRIM(@[s_ts4_lane]) || '/' || TRIM(@[s_pod]) FULL_ROUT" ).append("\n"); 
		query.append("FROM (SELECT MAX(DECODE(LINK_POS, 1, '1')) LK1" ).append("\n"); 
		query.append("           , MAX(DECODE(LINK_POS, 2, '2')) LK2" ).append("\n"); 
		query.append("           , MAX(DECODE(LINK_POS, 3, '3')) LK3" ).append("\n"); 
		query.append("           , MAX(DECODE(LINK_POS, 4, '4')) LK4" ).append("\n"); 
		query.append("           , MAX(LINK_COUNT) LINK_COUNT" ).append("\n"); 
		query.append("        FROM (" ).append("\n"); 
		query.append("             SELECT LINK_POS, POL_CD, SLAN_CD" ).append("\n"); 
		query.append("                   , DECODE(LINK_POS, MAX(DECODE(LINK_POS, 5, 0, LINK_POS)) OVER (), TRIM(@[s_pod]), POD_CD) POD_CD" ).append("\n"); 
		query.append("                   , MAX(DECODE(LINK_POS, 5, 0, LINK_POS)) OVER () LINK_COUNT" ).append("\n"); 
		query.append("              FROM (" ).append("\n"); 
		query.append("                  SELECT CPY_NO LINK_POS" ).append("\n"); 
		query.append("                       , DECODE(CPY_NO, 1, TRIM(@[s_pol]), 2, TRIM(@[s_ts1_port]), 3, TRIM(@[s_ts2_port]), 4, TRIM(@[s_ts3_port]), 5, TRIM(@[s_pod]) ) POL_CD" ).append("\n"); 
		query.append("                       , DECODE(CPY_NO, 1, TRIM(@[s_ts1_lane]), 2, TRIM(@[s_ts2_lane]), 3, TRIM(@[s_ts3_lane]), 4, TRIM(@[s_ts4_lane]) ) SLAN_CD" ).append("\n"); 
		query.append("                       , DECODE(CPY_NO, 1, TRIM(@[s_ts1_port]), 2, TRIM(@[s_ts2_port]), 3, TRIM(@[s_ts3_port]) ) POD_CD" ).append("\n"); 
		query.append("                  FROM COM_CPY_NO" ).append("\n"); 
		query.append("                  WHERE CPY_NO BETWEEN 1 AND 5" ).append("\n"); 
		query.append("                   )" ).append("\n"); 
		query.append("              WHERE POL_CD IS NOT NULL OR SLAN_CD IS NOT NULL" ).append("\n"); 
		query.append("             )" ).append("\n"); 
		query.append("         WHERE 'Y' = CASE WHEN POL_CD IS NOT NULL AND SLAN_CD IS NOT NULL AND POD_CD IS NOT NULL THEN 'Y' ELSE 'N' END" ).append("\n"); 
		query.append("    ) LK" ).append("\n"); 
		query.append("    LEFT OUTER JOIN" ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("    SELECT MAX(DECODE(LINK_POS, 1, POL    ))     POL1" ).append("\n"); 
		query.append("         , MAX(DECODE(LINK_POS, 1, POD    ))     POD1" ).append("\n"); 
		query.append("         , MAX(DECODE(LINK_POS, 1, LANE   ))    LANE1" ).append("\n"); 
		query.append("         , MAX(DECODE(LINK_POS, 1, DIR    ))     DIR1" ).append("\n"); 
		query.append("         , MAX(DECODE(LINK_POS, 1, FDR_FLG)) FDR_FLG1" ).append("\n"); 
		query.append("         , MAX(DECODE(LINK_POS, 1, SVC_TP ))  SVC_TP1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("         , MAX(DECODE(LINK_POS, 2, POL    ))     POL2" ).append("\n"); 
		query.append("         , MAX(DECODE(LINK_POS, 2, POD    ))     POD2" ).append("\n"); 
		query.append("         , MAX(DECODE(LINK_POS, 2, LANE   ))    LANE2" ).append("\n"); 
		query.append("         , MAX(DECODE(LINK_POS, 2, DIR    ))     DIR2" ).append("\n"); 
		query.append("         , MAX(DECODE(LINK_POS, 2, FDR_FLG)) FDR_FLG2" ).append("\n"); 
		query.append("         , MAX(DECODE(LINK_POS, 2, SVC_TP ))  SVC_TP2" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("         , MAX(DECODE(LINK_POS, 3, POL    ))     POL3" ).append("\n"); 
		query.append("         , MAX(DECODE(LINK_POS, 3, POD    ))     POD3" ).append("\n"); 
		query.append("         , MAX(DECODE(LINK_POS, 3, LANE   ))    LANE3" ).append("\n"); 
		query.append("         , MAX(DECODE(LINK_POS, 3, DIR    ))     DIR3" ).append("\n"); 
		query.append("         , MAX(DECODE(LINK_POS, 3, FDR_FLG)) FDR_FLG3" ).append("\n"); 
		query.append("         , MAX(DECODE(LINK_POS, 3, SVC_TP ))  SVC_TP3" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("         , MAX(DECODE(LINK_POS, 4, POL    ))     POL4" ).append("\n"); 
		query.append("         , MAX(DECODE(LINK_POS, 4, POD    ))     POD4" ).append("\n"); 
		query.append("         , MAX(DECODE(LINK_POS, 4, LANE   ))    LANE4" ).append("\n"); 
		query.append("         , MAX(DECODE(LINK_POS, 4, DIR    ))     DIR4" ).append("\n"); 
		query.append("         , MAX(DECODE(LINK_POS, 4, FDR_FLG)) FDR_FLG4" ).append("\n"); 
		query.append("         , MAX(DECODE(LINK_POS, 4, SVC_TP ))  SVC_TP4" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("         , NVL(MAX(DECODE(LINK_POS, 1, TT)),0)     TT1" ).append("\n"); 
		query.append("         , NVL(MAX(DECODE(LINK_POS, 2, TT)),0)     TT2" ).append("\n"); 
		query.append("         , NVL(MAX(DECODE(LINK_POS, 3, TT)),0)     TT3" ).append("\n"); 
		query.append("         , NVL(MAX(DECODE(LINK_POS, 4, TT)),0)     TT4" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("         , MAX(DECODE(LINK_POS, 1, LNK_DIST))     LNK_DIST1" ).append("\n"); 
		query.append("         , MAX(DECODE(LINK_POS, 2, LNK_DIST))     LNK_DIST2" ).append("\n"); 
		query.append("         , MAX(DECODE(LINK_POS, 3, LNK_DIST))     LNK_DIST3" ).append("\n"); 
		query.append("         , MAX(DECODE(LINK_POS, 4, LNK_DIST))     LNK_DIST4" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("         , CASE WHEN MAX(DECODE(LINK_POS, 1, SVC_TP)) <> 'C' AND MAX(DECODE(LINK_POS, 2, SVC_TP)) <> 'C'" ).append("\n"); 
		query.append("                THEN NVL(DECODE(" ).append("\n"); 
		query.append("                     DECODE(MAX(DECODE(LINK_POS, 1, TO_PORT_ETB_DY_CD)), 'SUN', 7, 'MON', 6, 'TUE', 5, 'WED', 4, 'THU', 3, 'FRI', 2, 'SAT', 1)" ).append("\n"); 
		query.append("                     - DECODE(MAX(DECODE(LINK_POS, 2, FM_PORT_ETB_DY_CD)), 'SUN', 7, 'MON', 6, 'TUE', 5, 'WED', 4, 'THU', 3, 'FRI', 2, 'SAT', 1)" ).append("\n"); 
		query.append("                     ,  -1, 7, -2, 6, -3, 5, -4, 4, -5, 3, -6, 2, 0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7 ) * 24,0)" ).append("\n"); 
		query.append("                ELSE 0 END ST1" ).append("\n"); 
		query.append("         , CASE WHEN MAX(DECODE(LINK_POS, 2, SVC_TP)) <> 'C' AND MAX(DECODE(LINK_POS, 3, SVC_TP)) <> 'C'" ).append("\n"); 
		query.append("                THEN NVL(DECODE(" ).append("\n"); 
		query.append("                     DECODE(MAX(DECODE(LINK_POS, 2, TO_PORT_ETB_DY_CD)), 'SUN', 7, 'MON', 6, 'TUE', 5, 'WED', 4, 'THU', 3, 'FRI', 2, 'SAT', 1)" ).append("\n"); 
		query.append("                     - DECODE(MAX(DECODE(LINK_POS, 3, FM_PORT_ETB_DY_CD)), 'SUN', 7, 'MON', 6, 'TUE', 5, 'WED', 4, 'THU', 3, 'FRI', 2, 'SAT', 1)" ).append("\n"); 
		query.append("                     ,  -1, 7, -2, 6, -3, 5, -4, 4, -5, 3, -6, 2, 0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7 ) * 24,0)" ).append("\n"); 
		query.append("                ELSE 0 END ST2" ).append("\n"); 
		query.append("         , CASE WHEN MAX(DECODE(LINK_POS, 3, SVC_TP)) <> 'C' AND MAX(DECODE(LINK_POS, 4, SVC_TP)) <> 'C'" ).append("\n"); 
		query.append("                THEN NVL(DECODE(" ).append("\n"); 
		query.append("                     DECODE(MAX(DECODE(LINK_POS, 3, TO_PORT_ETB_DY_CD)), 'SUN', 7, 'MON', 6, 'TUE', 5, 'WED', 4, 'THU', 3, 'FRI', 2, 'SAT', 1)" ).append("\n"); 
		query.append("                     - DECODE(MAX(DECODE(LINK_POS, 4, FM_PORT_ETB_DY_CD)), 'SUN', 7, 'MON', 6, 'TUE', 5, 'WED', 4, 'THU', 3, 'FRI', 2, 'SAT', 1)" ).append("\n"); 
		query.append("                     ,  -1, 7, -2, 6, -3, 5, -4, 4, -5, 3, -6, 2, 0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7 ) * 24,0)" ).append("\n"); 
		query.append("                ELSE 0 END ST3" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("         , DECODE(MAX(LINK_COUNT), 0, NULL, NULL, NULL, 1, 'D', 'T') TS_IND" ).append("\n"); 
		query.append("         , 'N' FDR_USD" ).append("\n"); 
		query.append("         , MAX(DECODE(LINK_POS, 1, TO_PORT_ETB_DY_CD    ))     POD1ETB" ).append("\n"); 
		query.append("         , MAX(DECODE(LINK_POS, 2, FM_PORT_ETB_DY_CD    ))     POL2ETB" ).append("\n"); 
		query.append("         , MAX(DECODE(LINK_POS, 2, TO_PORT_ETB_DY_CD    ))     POD2ETB" ).append("\n"); 
		query.append("         , MAX(DECODE(LINK_POS, 3, FM_PORT_ETB_DY_CD    ))     POL3ETB" ).append("\n"); 
		query.append("         , MAX(DECODE(LINK_POS, 3, TO_PORT_ETB_DY_CD    ))     POD3ETB" ).append("\n"); 
		query.append("         , MAX(DECODE(LINK_POS, 4, FM_PORT_ETB_DY_CD    ))     POL4ETB" ).append("\n"); 
		query.append("         , MAX(LINK_COUNT) LINK_COUNT" ).append("\n"); 
		query.append("         , CASE WHEN TRIM(@[s_pod]) IS NULL THEN 'N'" ).append("\n"); 
		query.append("                WHEN MAX(LINK_COUNT) = 4 THEN DECODE(NULL, MAX(DECODE(LINK_POS, 1, DIR)), '1', MAX(DECODE(LINK_POS, 2, DIR)),'2', MAX(DECODE(LINK_POS, 3, DIR)), '3', MAX(DECODE(LINK_POS, 4, DIR)), '4', 'Y')" ).append("\n"); 
		query.append("                WHEN MAX(LINK_COUNT) = 3 THEN DECODE(NULL, MAX(DECODE(LINK_POS, 1, DIR)), '1', MAX(DECODE(LINK_POS, 2, DIR)),'2', MAX(DECODE(LINK_POS, 3, DIR)), '3', 'Y')" ).append("\n"); 
		query.append("                WHEN MAX(LINK_COUNT) = 2 THEN DECODE(NULL, MAX(DECODE(LINK_POS, 1, DIR)), '1', MAX(DECODE(LINK_POS, 2, DIR)),'2', 'Y')" ).append("\n"); 
		query.append("                WHEN MAX(LINK_COUNT) = 1 THEN DECODE(NULL, MAX(DECODE(LINK_POS, 1, DIR)), '1', 'Y')" ).append("\n"); 
		query.append("                ELSE 'N' END LINK_VALID_FLG" ).append("\n"); 
		query.append("        FROM (" ).append("\n"); 
		query.append("              SELECT A.FM_PORT_CD   POL" ).append("\n"); 
		query.append("                   , A.TO_PORT_CD   POD" ).append("\n"); 
		query.append("                   ,  A.VSL_SLAN_CD  LANE" ).append("\n"); 
		query.append("                   ,  A.SKD_DIR_CD   DIR" ).append("\n"); 
		query.append("                   ,  'N'            FDR_FLG" ).append("\n"); 
		query.append("                   , (SELECT DECODE(VSL_SVC_TP_CD, 'O','C', VSL_SVC_TP_CD) FROM MDM_VSL_SVC_LANE WHERE VSL_SLAN_CD = A.VSL_SLAN_CD) SVC_TP" ).append("\n"); 
		query.append("                   , A.TZTM_HRS TT" ).append("\n"); 
		query.append("                   , M.LINK_POS" ).append("\n"); 
		query.append("                   , A.FM_PORT_ETB_DY_CD" ).append("\n"); 
		query.append("                   , A.TO_PORT_ETB_DY_CD" ).append("\n"); 
		query.append("                   , M.LINK_COUNT" ).append("\n"); 
		query.append("                   , A.LNK_DIST" ).append("\n"); 
		query.append("              FROM (SELECT LINK_POS, POL_CD, SLAN_CD" ).append("\n"); 
		query.append("                         , DECODE(LINK_POS, MAX(DECODE(LINK_POS, 5, 0, LINK_POS)) OVER (), TRIM(@[s_pod]), POD_CD) POD_CD" ).append("\n"); 
		query.append("                         , MAX(DECODE(LINK_POS, 5, 0, LINK_POS)) OVER () LINK_COUNT" ).append("\n"); 
		query.append("                      FROM (" ).append("\n"); 
		query.append("                            SELECT CPY_NO LINK_POS" ).append("\n"); 
		query.append("                                 , DECODE(CPY_NO, 1, TRIM(@[s_pol]), 2, TRIM(@[s_ts1_port]), 3, TRIM(@[s_ts2_port]), 4, TRIM(@[s_ts3_port]), 5, TRIM(@[s_pod]) ) POL_CD" ).append("\n"); 
		query.append("                                 , DECODE(CPY_NO, 1, TRIM(@[s_ts1_lane]), 2, TRIM(@[s_ts2_lane]), 3, TRIM(@[s_ts3_lane]), 4, TRIM(@[s_ts4_lane]) ) SLAN_CD" ).append("\n"); 
		query.append("                                 , DECODE(CPY_NO, 1, TRIM(@[s_ts1_port]), 2, TRIM(@[s_ts2_port]), 3, TRIM(@[s_ts3_port]) ) POD_CD" ).append("\n"); 
		query.append("                            FROM COM_CPY_NO" ).append("\n"); 
		query.append("                            WHERE CPY_NO BETWEEN 1 AND 5" ).append("\n"); 
		query.append("                           )" ).append("\n"); 
		query.append("                      WHERE POL_CD IS NOT NULL OR SLAN_CD IS NOT NULL) M" ).append("\n"); 
		query.append("                 , PRD_PF_TZ_TM A" ).append("\n"); 
		query.append("              WHERE M.LINK_POS < 5" ).append("\n"); 
		query.append("                AND A.FM_PORT_CD = M.POL_CD" ).append("\n"); 
		query.append("                AND A.TO_PORT_CD = M.POD_CD" ).append("\n"); 
		query.append("                AND A.VSL_SLAN_CD = M.SLAN_CD" ).append("\n"); 
		query.append("                AND A.DELT_FLG <> 'Y'" ).append("\n"); 
		query.append("             UNION ALL" ).append("\n"); 
		query.append("             SELECT LNK_ORG_LOC_CD POL" ).append("\n"); 
		query.append("                  , LNK_DEST_LOC_CD POD" ).append("\n"); 
		query.append("                  , VSL_SLAN_CD LANE" ).append("\n"); 
		query.append("                  , SKD_DIR_CD DIR" ).append("\n"); 
		query.append("                  , 'Y' FDR_FLG" ).append("\n"); 
		query.append("                  , (SELECT DECODE(VSL_SVC_TP_CD, 'O','C', VSL_SVC_TP_CD) FROM MDM_VSL_SVC_LANE WHERE VSL_SLAN_CD = A.VSL_SLAN_CD) SVC_TP" ).append("\n"); 
		query.append("                  , TZTM_HRS TT" ).append("\n"); 
		query.append("                  , M.LINK_POS" ).append("\n"); 
		query.append("                  , '' FM_PORT_ETB_DY_CD" ).append("\n"); 
		query.append("                  , '' TO_PORT_ETB_DY_CD" ).append("\n"); 
		query.append("                  , M.LINK_COUNT" ).append("\n"); 
		query.append("                  , NVL(B.STND_DIST,0) AS LNK_DIST" ).append("\n"); 
		query.append("              FROM (SELECT LINK_POS, POL_CD, SLAN_CD" ).append("\n"); 
		query.append("                        , DECODE(LINK_POS, MAX(DECODE(LINK_POS, 5, 0, LINK_POS)) OVER (), TRIM(@[s_pod]), POD_CD) POD_CD" ).append("\n"); 
		query.append("                        , MAX(DECODE(LINK_POS, 5, 0, LINK_POS)) OVER () LINK_COUNT" ).append("\n"); 
		query.append("                     FROM (" ).append("\n"); 
		query.append("                           SELECT CPY_NO LINK_POS" ).append("\n"); 
		query.append("                                , DECODE(CPY_NO, 1, TRIM(@[s_pol]), 2, TRIM(@[s_ts1_port]), 3, TRIM(@[s_ts2_port]), 4, TRIM(@[s_ts3_port]), 5, TRIM(@[s_pod]) ) POL_CD" ).append("\n"); 
		query.append("                                , DECODE(CPY_NO, 1, TRIM(@[s_ts1_lane]), 2, TRIM(@[s_ts2_lane]), 3, TRIM(@[s_ts3_lane]), 4, TRIM(@[s_ts4_lane]) ) SLAN_CD" ).append("\n"); 
		query.append("                                , DECODE(CPY_NO, 1, TRIM(@[s_ts1_port]), 2, TRIM(@[s_ts2_port]), 3, TRIM(@[s_ts3_port]) ) POD_CD" ).append("\n"); 
		query.append("                           FROM COM_CPY_NO" ).append("\n"); 
		query.append("                           WHERE CPY_NO BETWEEN 1 AND 5" ).append("\n"); 
		query.append("                         )" ).append("\n"); 
		query.append("                    WHERE POL_CD IS NOT NULL OR SLAN_CD IS NOT NULL) M" ).append("\n"); 
		query.append("                 , PRD_FDR_LNK A" ).append("\n"); 
		query.append("                 , VSK_PORT_DIST B" ).append("\n"); 
		query.append("             WHERE M.LINK_POS < 5" ).append("\n"); 
		query.append("              AND A.LNK_ORG_LOC_CD = M.POL_CD" ).append("\n"); 
		query.append("              AND A.LNK_DEST_LOC_CD = M.POD_CD" ).append("\n"); 
		query.append("              AND A.VSL_SLAN_CD = M.SLAN_CD" ).append("\n"); 
		query.append("              AND NVL(DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("              AND B.FM_LOC_CD(+) = M.POL_CD" ).append("\n"); 
		query.append("              AND B.TO_LOC_CD(+) = M.POD_CD" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("    ) MK" ).append("\n"); 
		query.append("    ON (1=1)" ).append("\n"); 
		query.append("    LEFT OUTER JOIN PRD_OCN_ROUT TG" ).append("\n"); 
		query.append("    ON (TG.UPD_IND_CD NOT IN ('D', 'N', 'O')" ).append("\n"); 
		query.append("        AND   POL1            = TG.N1ST_POL_CD" ).append("\n"); 
		query.append("        AND   LANE1           = TG.N1ST_LANE_CD" ).append("\n"); 
		query.append("        AND   POD1            = TG.N1ST_POD_CD" ).append("\n"); 
		query.append("        AND   NVL(LANE2, 'N') = NVL(TG.N2ND_LANE_CD,'N')" ).append("\n"); 
		query.append("        AND   NVL(POD2,  'N') = NVL(TG.N2ND_POD_CD, 'N')" ).append("\n"); 
		query.append("        AND   NVL(LANE3, 'N') = NVL(TG.N3RD_LANE_CD,'N')" ).append("\n"); 
		query.append("        AND   NVL(POD3,  'N') = NVL(TG.N3RD_POD_CD, 'N')" ).append("\n"); 
		query.append("        AND   NVL(LANE4, 'N') = NVL(TG.N4TH_LANE_CD,'N')" ).append("\n"); 
		query.append("        AND   NVL(POD4,  'N') = NVL(TG.N4TH_POD_CD, 'N')" ).append("\n"); 
		query.append("       )" ).append("\n"); 

	}
}