/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : OceanRouteManageDBDAOSearchLaneConnectionRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.30
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.06.30 백형인
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanroutemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author HI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OceanRouteManageDBDAOSearchLaneConnectionRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchLaneConnection
	  * </pre>
	  */
	public OceanRouteManageDBDAOSearchLaneConnectionRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("i_cost_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("i_lane_from",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("i_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("con_type",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("i_lane_to",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanroutemanage.integration").append("\n"); 
		query.append("FileName : OceanRouteManageDBDAOSearchLaneConnectionRSQL").append("\n"); 
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
		query.append("SELECT LC.STD_PORT, " ).append("\n"); 
		query.append("        LC.FM_LANE, LC.FM_CRR, LC.FM_DIR, LC.FM_TML, LC.FM_TML_NM, " ).append("\n"); 
		query.append("        LC.TO_LANE, LC.TO_CRR, LC.TO_DIR, LC.TO_TML, LC.TO_TML_NM, " ).append("\n"); 
		query.append("        DECODE(  " ).append("\n"); 
		query.append("                 DECODE(LC.FM_ETB, 'SUN', 7, 'MON', 6, 'TUE', 5, 'WED', 4, 'THU', 3, 'FRI', 2, 'SAT', 1) " ).append("\n"); 
		query.append("                 - DECODE(LC.TO_ETB, 'SUN', 7, 'MON', 6, 'TUE', 5, 'WED', 4, 'THU', 3, 'FRI', 2, 'SAT', 1) " ).append("\n"); 
		query.append("                 ,  -1, 7, -2, 6, -3, 5, -4, 4, -5, 3, -6, 2, 0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7 ) * 24 ST_TIME ,  " ).append("\n"); 
		query.append("        STL.LNK_FM_NOD_CD FM_STL, STL.LNK_TO_NOD_CD TO_STL, STL.STL_COST_CD STL_COST_CD,  " ).append("\n"); 
		query.append("        STL.STL_GRP_CD STL_GRP,  " ).append("\n"); 
		query.append("        DECODE(LC.FM_TML, LC.TO_TML, 0, NVL(STL_AMT_D2, PRD_GET_LINK_COST_FNC(LC.STD_PORT, 'D2', @[con_type] , @[i_cost_yrmon] ))) STL_AMT_D2,   " ).append("\n"); 
		query.append("        DECODE(LC.FM_TML, LC.TO_TML, 0, NVL(STL_AMT_D4, PRD_GET_LINK_COST_FNC(LC.STD_PORT, 'D4', @[con_type] , @[i_cost_yrmon] ))) STL_AMT_D4,  " ).append("\n"); 
		query.append("        DECODE(LC.FM_TML, LC.TO_TML, 0, NVL(STL_AMT_D5, PRD_GET_LINK_COST_FNC(LC.STD_PORT, 'D5', @[con_type] , @[i_cost_yrmon] ))) STL_AMT_D5  " ).append("\n"); 
		query.append(" FROM  " ).append("\n"); 
		query.append("     ( " ).append("\n"); 
		query.append("     SELECT DISTINCT B.FM_PORT_CD STD_PORT, " ).append("\n"); 
		query.append("            A.VSL_SLAN_CD FM_LANE, AC.CRR_CD FM_CRR, A.SKD_DIR_CD FM_DIR, AC.TML_CD FM_TML, AD.YD_NM FM_TML_NM, A.TO_PORT_ETB_DY_CD FM_ETB, " ).append("\n"); 
		query.append("            B.VSL_SLAN_CD TO_LANE, BC.CRR_CD TO_CRR, B.SKD_DIR_CD TO_DIR, BC.TML_CD TO_TML, BD.YD_NM TO_TML_NM, B.FM_PORT_ETB_DY_CD TO_ETB " ).append("\n"); 
		query.append("     FROM PRD_PF_TZ_TM A, PRD_PF_TZ_TM B, PRD_PORT_TML_MTX AC, PRD_PORT_TML_MTX BC, MDM_YARD AD, MDM_YARD BD  " ).append("\n"); 
		query.append("     WHERE B.FM_PORT_CD = @[i_port_cd]   " ).append("\n"); 
		query.append("     AND A.VSL_SLAN_CD LIKE @[i_lane_from] || '%'  " ).append("\n"); 
		query.append("     AND B.VSL_SLAN_CD LIKE @[i_lane_to] || '%'  " ).append("\n"); 
		query.append("     AND A.TO_PORT_CD  = B.FM_PORT_CD " ).append("\n"); 
		query.append("     AND A.TO_PORT_CD  = AC.PORT_CD    (+) " ).append("\n"); 
		query.append("     AND A.VSL_SLAN_CD = AC.VSL_SLAN_CD(+) " ).append("\n"); 
		query.append("     AND A.SKD_DIR_CD  = AC.SKD_DIR_CD (+) " ).append("\n"); 
		query.append("     AND B.FM_PORT_CD  = BC.PORT_CD    (+) " ).append("\n"); 
		query.append("     AND B.VSL_SLAN_CD = BC.VSL_SLAN_CD(+) " ).append("\n"); 
		query.append("     AND B.SKD_DIR_CD  = BC.SKD_DIR_CD (+) " ).append("\n"); 
		query.append("     AND AC.TML_CD     = AD.YD_CD      (+) " ).append("\n"); 
		query.append("     AND BC.TML_CD     = BD.YD_CD      (+)" ).append("\n"); 
		query.append("     AND A.DELT_FLG <> 'Y'" ).append("\n"); 
		query.append("     AND B.DELT_FLG <> 'Y'" ).append("\n"); 
		query.append("     ) LC, -- LANE CONNECTION " ).append("\n"); 
		query.append("     ( " ).append("\n"); 
		query.append("     SELECT /*+ INDEX(MAS_LNK_AVG_STND_COST XPKMAS_LNK_AVG_STND_COST) */   " ).append("\n"); 
		query.append("            LNK_FM_NOD_CD, LNK_TO_NOD_CD,  MAS_COST_SRC_CD STL_COST_CD, COST_LOC_GRP_CD STL_GRP_CD,  " ).append("\n"); 
		query.append("            -- CNTR_TPSZ_CD TP_SZ, STND_COST_USD_AMT STL_AMT   -- STND_COST_USD_AMT  " ).append("\n"); 
		query.append("            SUM(DECODE(CNTR_TPSZ_CD, 'D2', STND_COST_USD_AMT)) STL_AMT_D2, " ).append("\n"); 
		query.append("            SUM(DECODE(CNTR_TPSZ_CD, 'D4', STND_COST_USD_AMT)) STL_AMT_D4, " ).append("\n"); 
		query.append("            SUM(DECODE(CNTR_TPSZ_CD, 'D5', STND_COST_USD_AMT)) STL_AMT_D5 " ).append("\n"); 
		query.append("     FROM MAS_LNK_AVG_STND_COST " ).append("\n"); 
		query.append("     WHERE COST_YRMON = @[i_cost_yrmon]   " ).append("\n"); 
		query.append("     AND LNK_FM_NOD_CD LIKE @[i_port_cd] ||'%'  " ).append("\n"); 
		query.append("     AND LNK_TO_NOD_CD LIKE @[i_port_cd] ||'%'   " ).append("\n"); 
		query.append("     AND CO_CD = 'H' " ).append("\n"); 
		query.append("     AND CNTR_TPSZ_CD IN ('D2', 'D4', 'D5') " ).append("\n"); 
		query.append("     AND FULL_MTY_CD = 'F' " ).append("\n"); 
		query.append("     AND MAS_COST_SRC_CD = DECODE(@[con_type] , 'F', 'TRTSTD', 'M', 'TRMTTD', 'TRTSTD') " ).append("\n"); 
		query.append("     AND COST_LOC_GRP_CD = 'N' " ).append("\n"); 
		query.append("     GROUP BY LNK_FM_NOD_CD, LNK_TO_NOD_CD,  MAS_COST_SRC_CD , COST_LOC_GRP_CD " ).append("\n"); 
		query.append("     ) STL -- TS SHUTTLE  " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" WHERE LC.FM_TML = STL.LNK_FM_NOD_CD(+) " ).append("\n"); 
		query.append(" AND   LC.TO_TML = STL.LNK_TO_NOD_CD(+)" ).append("\n"); 

	}
}