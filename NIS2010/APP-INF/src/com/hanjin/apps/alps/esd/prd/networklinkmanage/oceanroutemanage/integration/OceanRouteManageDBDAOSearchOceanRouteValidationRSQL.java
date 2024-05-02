/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : OceanRouteManageDBDAOSearchOceanRouteValidationRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.06.01
*@LastModifier : 
*@LastVersion : 1.0
* 2017.06.01 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanroutemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OceanRouteManageDBDAOSearchOceanRouteValidationRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2012.10.22 정선용 [] - Ocean Route Total Transit Time 변경 (45일->50일)
	  * 2011.12.08 변종건 [CHM-201114917-01] Ocean Route Upload Excel 신규 기능 추가건
	  * </pre>
	  */
	public OceanRouteManageDBDAOSearchOceanRouteValidationRSQL(){
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
		params.put("s_route_note",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("s_route_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_route_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : OceanRouteManageDBDAOSearchOceanRouteValidationRSQL").append("\n"); 
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
		query.append("SELECT MIN(ERR_TP) S_ERR_TP" ).append("\n"); 
		query.append("   FROM (" ).append("\n"); 
		query.append("       SELECT SUBQ.LINK_POS, SUBQ.POL_CD, SUBQ.SLAN_CD, SUBQ.POD_CD, DECODE(SLAN_CD, 'FDR',PFDR.SKD_DIR_CD, PFTZ.SKD_DIR_CD) SKD_DIR_CD" ).append("\n"); 
		query.append("            , CASE WHEN TRIM(@[s_pol]) IS NULL OR LENGTH(TRIM(@[s_pol])) <> 5" ).append("\n"); 
		query.append("                        OR TRIM(@[s_ts1_lane]) IS NULL OR LENGTH(TRIM(@[s_ts1_lane])) <> 3" ).append("\n"); 
		query.append("                        OR TRIM(@[s_pod]) IS NULL OR LENGTH(TRIM(@[s_pod])) <> 5" ).append("\n"); 
		query.append("                        OR ((TRIM(@[s_ts1_port]) IS NOT NULL OR TRIM(@[s_ts2_lane]) IS NOT NULL) AND (LENGTH(TRIM(@[s_ts1_port] || @[s_ts2_lane])) <> 8))" ).append("\n"); 
		query.append("                        OR ((TRIM(@[s_ts2_port]) IS NOT NULL OR TRIM(@[s_ts3_lane]) IS NOT NULL) AND (LENGTH(TRIM(@[s_ts2_port] || @[s_ts3_lane])) <> 8))" ).append("\n"); 
		query.append("                        OR ((TRIM(@[s_ts3_port]) IS NOT NULL OR TRIM(@[s_ts4_lane]) IS NOT NULL) AND (LENGTH(TRIM(@[s_ts3_port] || @[s_ts4_lane])) <> 8))" ).append("\n"); 
		query.append("                        OR ((COUNT(1) OVER () - 1) <> LINK_COUNT) THEN 'E14'" ).append("\n"); 
		query.append("                   WHEN MPOL.LOC_CD IS NULL OR (LINK_POS <> 5 AND MPOD.LOC_CD IS NULL) THEN 'E01'" ).append("\n"); 
		query.append("                   WHEN SUBQ.SLAN_CD IS NOT NULL AND MLAN.VSL_SLAN_CD IS NULL THEN 'E02'" ).append("\n"); 
		query.append("                   --WHEN SUBQ.SLAN_CD IS NOT NULL AND (SELECT 1 FROM PRD_PF_TZ_TM WHERE VSL_SLAN_CD = SUBQ.SLAN_CD AND NVL(DELT_FLG,'N') = 'N' AND ROWNUM = 1) IS NULL THEN 'E03'" ).append("\n"); 
		query.append("                   WHEN SUBQ.SLAN_CD IS NOT NULL THEN (CASE WHEN SUBQ.SLAN_CD <> 'FDR' AND (SELECT 1 FROM PRD_PF_TZ_TM WHERE VSL_SLAN_CD = SUBQ.SLAN_CD AND NVL(DELT_FLG,'N') = 'N' AND ROWNUM = 1) IS NULL THEN 'E03' END)" ).append("\n"); 
		query.append("                   WHEN SUBQ.SLAN_CD IS NOT NULL AND ((SUBQ.SLAN_CD <> 'FDR' AND PFTZ.VSL_SLAN_CD IS NULL) OR (SUBQ.SLAN_CD = 'FDR' AND PFDR.VSL_SLAN_CD IS NULL)) THEN 'E04'" ).append("\n"); 
		query.append("                   WHEN DECODE(LINK_POS, 1, 'X', 5, 'X', POL_CD) = MAX(DECODE(LINK_POS, 5, POL_CD)) OVER () THEN 'E05'" ).append("\n"); 
		query.append("                   WHEN POL_CD IN ('EGSUZ', 'PAPAC') OR POD_CD IN ('EGSUZ', 'PAPAC') THEN 'E06'" ).append("\n"); 
		query.append("                   WHEN T_LANE_SEQ < LINK_POS AND SLAN_CD = 'FDR' AND MAX(DECODE(T_LANE_SEQ, LINK_POS, SUBSTR(POL_CD,1,2))) OVER () = SUBSTR(POD_CD,1,2) THEN 'E07'" ).append("\n"); 
		query.append("                   WHEN T_LANE_SEQ > LINK_POS AND SLAN_CD = 'FDR' AND MAX(DECODE(T_LANE_SEQ, LINK_POS, SUBSTR(POD_CD,1,2))) OVER () = SUBSTR(POL_CD,1,2) THEN 'E08'" ).append("\n"); 
		query.append("                   WHEN POL_CD = POD_CD AND SUBSTR(POL_CD,1,2) NOT IN ('CN','AE') THEN 'E09'" ).append("\n"); 
		query.append("                   WHEN MAX(DECODE(LINK_POS, 1, POL_CD)) OVER() = MAX(DECODE(LINK_POS, 5, POL_CD)) OVER() THEN 'E10'" ).append("\n"); 
		query.append("                   WHEN TRIM(@[s_route_flg]) IS NULL OR TRIM(@[s_route_flg]) NOT IN ('S','T','A') THEN 'E12'" ).append("\n"); 
		query.append("                   WHEN DECODE(TRIM(@[s_route_flg]), 'T', 'Y', 'N') <>" ).append("\n"); 
		query.append("                          DECODE(TRIM(@[s_route_rmk]), NULL, 'N', 'Space Shortage', 'Y','Customer Request', 'Y','Port Skip', 'Y','VSL Phase Out', 'Y','Add Call', 'Y'" ).append("\n"); 
		query.append("                                             ,'Customs Problem', 'Y','Clerical Error', 'Y','The Others', DECODE(TRIM(@[s_route_note]), NULL, 'N', 'Y'), 'N')" ).append("\n"); 
		query.append("                        THEN 'E11'" ).append("\n"); 
		query.append("                   WHEN SUM(DECODE(SLAN_CD, 'FDR',PFDR.TZTM_HRS, PFTZ.TZTM_HRS)) OVER () > (50 * 24)  THEN 'E13'" ).append("\n"); 
		query.append("                   END AS ERR_TP" ).append("\n"); 
		query.append("            , T_LANE_SEQ" ).append("\n"); 
		query.append("       FROM(" ).append("\n"); 
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
		query.append("             ) SUBQ" ).append("\n"); 
		query.append("       LEFT OUTER JOIN MDM_LOCATION MPOL" ).append("\n"); 
		query.append("       ON ( SUBQ.POL_CD = MPOL.LOC_CD" ).append("\n"); 
		query.append("           AND NVL(MPOL.DELT_FLG, 'N') = 'N')" ).append("\n"); 
		query.append("       LEFT OUTER JOIN MDM_LOCATION MPOD" ).append("\n"); 
		query.append("       ON ( SUBQ.POD_CD = MPOD.LOC_CD" ).append("\n"); 
		query.append("           AND NVL(MPOD.DELT_FLG, 'N') = 'N')" ).append("\n"); 
		query.append("       LEFT OUTER JOIN MDM_VSL_SVC_LANE MLAN" ).append("\n"); 
		query.append("       ON ( SUBQ.SLAN_CD = MLAN.VSL_SLAN_CD" ).append("\n"); 
		query.append("           AND NVL(MLAN.DELT_FLG, 'N') = 'N')" ).append("\n"); 
		query.append("       LEFT OUTER JOIN PRD_PF_TZ_TM PFTZ" ).append("\n"); 
		query.append("       ON ( SUBQ.SLAN_CD = PFTZ.VSL_SLAN_CD" ).append("\n"); 
		query.append("           AND SUBQ.POL_CD = PFTZ.FM_PORT_CD" ).append("\n"); 
		query.append("           AND SUBQ.POD_CD = PFTZ.TO_PORT_CD" ).append("\n"); 
		query.append("           AND NVL(PFTZ.DELT_FLG, 'N') = 'N')" ).append("\n"); 
		query.append("       LEFT OUTER JOIN PRD_FDR_LNK PFDR" ).append("\n"); 
		query.append("       ON ( SUBQ.SLAN_CD = PFDR.VSL_SLAN_CD" ).append("\n"); 
		query.append("           AND SUBQ.POL_CD = PFDR.LNK_ORG_LOC_CD" ).append("\n"); 
		query.append("           AND SUBQ.POD_CD = PFDR.LNK_DEST_LOC_CD" ).append("\n"); 
		query.append("           AND NVL(PFDR.DELT_FLG, 'N') = 'N')" ).append("\n"); 
		query.append("       JOIN (SELECT PRD_GET_OCN_ROUT_TLANE_FNC(TRIM(@[s_pol]),TRIM(@[s_ts1_port]), TRIM(@[s_ts2_port]), TRIM(@[s_ts3_port]), TRIM(@[s_pod])" ).append("\n"); 
		query.append("                                              , TRIM(@[s_ts1_lane]), TRIM(@[s_ts2_lane]), TRIM(@[s_ts3_lane]), TRIM(@[s_ts4_lane])) T_LANE_SEQ" ).append("\n"); 
		query.append("             FROM DUAL) X" ).append("\n"); 
		query.append("       ON (1=1)" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("    WHERE LINK_POS <> 5" ).append("\n"); 

	}
}