/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : OptimizeddistancemgtDBDAOSearchOptimizedDistanceRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.13
*@LastModifier : 
*@LastVersion : 1.0
* 2015.05.13 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.optimizeddistancemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OptimizeddistancemgtDBDAOSearchOptimizedDistanceRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 해당 Port에 따른 Optimized Distance 정보를 조회합니다.
	  * </pre>
	  */
	public OptimizeddistancemgtDBDAOSearchOptimizedDistanceRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_yd_grp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_date",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_date",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_yd_grp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.optimizeddistancemgt.integration").append("\n"); 
		query.append("FileName : OptimizeddistancemgtDBDAOSearchOptimizedDistanceRSQL").append("\n"); 
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
		query.append("SELECT   H.FM_YD_CD" ).append("\n"); 
		query.append("      ,  H.FM_YD_GRP_ID AS FM_YD_GRP_CD" ).append("\n"); 
		query.append("	  ,  H.FM_YD_CD     AS SHEET_FM_PORT_CD  " ).append("\n"); 
		query.append("	  ,  H.FM_YD_GRP_ID AS SHEET_FM_YD_GRP_CD" ).append("\n"); 
		query.append("	  ,  H.TO_YD_CD     AS SHEET_TO_PORT_CD" ).append("\n"); 
		query.append("      ,  H.TO_YD_GRP_ID AS SHEET_TO_YD_GRP_CD" ).append("\n"); 
		query.append("	  ,  H.TO_YD_GRP_ID AS PRE_SHEET_TO_YD_GRP_CD" ).append("\n"); 
		query.append("	  ,  H.FM_YD_GRP_ID AS PRE_SHEET_FM_YD_GRP_CD" ).append("\n"); 
		query.append("      ,  D.GMT_TD_HRS" ).append("\n"); 
		query.append("      ,  D.STND_DIST  " ).append("\n"); 
		query.append("      ,  H.OPMZ_DIST  " ).append("\n"); 
		query.append("      ,  (" ).append("\n"); 
		query.append("            SELECT   AVG(DISTINCT O.PORT_TO_PORT_MLG_DIST)" ).append("\n"); 
		query.append("            FROM      (" ).append("\n"); 
		query.append("                      SELECT  MM.VSL_CD, MM.SKD_VOY_NO, MM.SKD_DIR_CD, MM.DEP_PORT_CD, MM.ARR_PORT_CD, MM.PORT_TO_PORT_MLG_DIST, H.FM_YD_GRP_ID, H.TO_YD_GRP_ID" ).append("\n"); 
		query.append("                             , MM.FM_YD_GRP_ID_2, MM.TO_YD_GRP_ID_2" ).append("\n"); 
		query.append("                             , DECODE(H.FM_YD_GRP_ID,'All', 'All', 'A', FM_YD_GRP_ID_2, 'B', FM_YD_GRP_ID_2) AS FM_YD_GRP_ID_3      " ).append("\n"); 
		query.append("                             , DECODE(H.TO_YD_GRP_ID, 'All', 'All', 'A', TO_YD_GRP_ID_2, 'B',TO_YD_GRP_ID_2) AS TO_YD_GRP_ID_3" ).append("\n"); 
		query.append("                       FROM(       " ).append("\n"); 
		query.append("                               SELECT    P.VSL_CD, P.SKD_VOY_NO, P.SKD_DIR_CD, P.DEP_PORT_CD, P.ARR_PORT_CD, P.PORT_TO_PORT_MLG_DIST" ).append("\n"); 
		query.append("                                          , H.FM_YD_GRP_ID, H.TO_YD_GRP_ID" ).append("\n"); 
		query.append("                                          , FM_PC.YD_GRP_ID AS FM_YD_GRP_ID_2" ).append("\n"); 
		query.append("                                          , TO_PC.YD_GRP_ID AS TO_YD_GRP_ID_2" ).append("\n"); 
		query.append("                                          " ).append("\n"); 
		query.append("                                FROM      VSK_PASG_PLN_RPT P " ).append("\n"); 
		query.append("                                        , MDM_VSL_CNTR     VC" ).append("\n"); 
		query.append("                                        ,( SELECT   PS.VSL_CD" ).append("\n"); 
		query.append("                                                    ,PS.SKD_VOY_NO" ).append("\n"); 
		query.append("                                                    ,PS.SKD_DIR_CD" ).append("\n"); 
		query.append("                                                    ,PS.VPS_PORT_CD" ).append("\n"); 
		query.append("                                                    ,PS.YD_CD" ).append("\n"); 
		query.append("                                                    ,NVL(YG.YD_GRP_ID,'All') as YD_GRP_ID" ).append("\n"); 
		query.append("                                           FROM     VSK_VSL_PORT_SKD PS" ).append("\n"); 
		query.append("                                                    , VSK_YD_GRP       YG" ).append("\n"); 
		query.append("                                           WHERE PS.YD_CD = YG.YD_CD (+) ) FM_PC        " ).append("\n"); 
		query.append("                                        ,( SELECT   PS.VSL_CD " ).append("\n"); 
		query.append("                                                    ,PS.SKD_VOY_NO" ).append("\n"); 
		query.append("                                                    ,PS.SKD_DIR_CD" ).append("\n"); 
		query.append("                                                    ,PS.VPS_PORT_CD" ).append("\n"); 
		query.append("                                                    ,PS.YD_CD" ).append("\n"); 
		query.append("                                                    ,NVL(YG.YD_GRP_ID,'All') as  YD_GRP_ID" ).append("\n"); 
		query.append("                                           FROM     VSK_VSL_PORT_SKD PS" ).append("\n"); 
		query.append("                                                    , VSK_YD_GRP       YG" ).append("\n"); 
		query.append("                                           WHERE PS.YD_CD = YG.YD_CD(+) ) TO_PC" ).append("\n"); 
		query.append("                                           ,VSK_PORT_OPMZ_DIST       H" ).append("\n"); 
		query.append("                                WHERE 1=1" ).append("\n"); 
		query.append("                                AND P.VSL_CD            = VC.VSL_CD" ).append("\n"); 
		query.append("                                AND P.VSL_CD            = FM_PC.VSL_CD (+)" ).append("\n"); 
		query.append("                                AND P.SKD_VOY_NO        = FM_PC.SKD_VOY_NO (+)" ).append("\n"); 
		query.append("                                AND P.SKD_DIR_CD        = FM_PC.SKD_DIR_CD  (+)" ).append("\n"); 
		query.append("                                AND P.DEP_PORT_CD       = FM_PC.VPS_PORT_CD (+)" ).append("\n"); 
		query.append("                                AND P.VSL_CD            = TO_PC.VSL_CD      (+)" ).append("\n"); 
		query.append("                                AND P.SKD_VOY_NO        = TO_PC.SKD_VOY_NO (+)" ).append("\n"); 
		query.append("                                AND P.SKD_DIR_CD        = TO_PC.SKD_DIR_CD  (+)" ).append("\n"); 
		query.append("                                AND P.ARR_PORT_CD       = TO_PC.VPS_PORT_CD (+)" ).append("\n"); 
		query.append("                                AND P.DEP_PORT_CD       = SUBSTR(H.FM_YD_CD,1,5) " ).append("\n"); 
		query.append("                                AND P.ARR_PORT_CD       = SUBSTR(H.TO_YD_CD,1,5)" ).append("\n"); 
		query.append("                                AND P.PORT_TO_PORT_MLG_DIST BETWEEN H.RNG_MIN_DIST AND DECODE(H.RNG_MAX_DIST,NULL,99999,0,99999,H.RNG_MAX_DIST)" ).append("\n"); 
		query.append("                                AND P.PASG_PLN_DT BETWEEN TO_DATE(@[fm_date],'YYYY-MM-DD') AND TO_DATE(@[to_date],'YYYY-MM-DD')+0.99999" ).append("\n"); 
		query.append("                                ) MM    " ).append("\n"); 
		query.append("                                ,VSK_PORT_OPMZ_DIST       H                " ).append("\n"); 
		query.append("                        WHERE   1=1" ).append("\n"); 
		query.append("                        AND     MM.DEP_PORT_CD       = H.FM_YD_CD" ).append("\n"); 
		query.append("                        AND     MM.ARR_PORT_CD       = H.TO_YD_CD" ).append("\n"); 
		query.append("                        ) O" ).append("\n"); 
		query.append("            WHERE   1=1" ).append("\n"); 
		query.append("            AND     O.DEP_PORT_CD       = H.FM_YD_CD" ).append("\n"); 
		query.append("            AND     O.ARR_PORT_CD       = H.TO_YD_CD" ).append("\n"); 
		query.append("            AND     O.FM_YD_GRP_ID_3    = H.FM_YD_GRP_ID" ).append("\n"); 
		query.append("            AND     O.TO_YD_GRP_ID_3    = H.TO_YD_GRP_ID" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		  ) AS VMS_AVG_DIST " ).append("\n"); 
		query.append("      ,  (" ).append("\n"); 
		query.append("            SELECT   MIN(DISTINCT O.PORT_TO_PORT_MLG_DIST)" ).append("\n"); 
		query.append("            FROM      (" ).append("\n"); 
		query.append("                      SELECT  MM.VSL_CD, MM.SKD_VOY_NO, MM.SKD_DIR_CD, MM.DEP_PORT_CD, MM.ARR_PORT_CD, MM.PORT_TO_PORT_MLG_DIST, H.FM_YD_GRP_ID, H.TO_YD_GRP_ID" ).append("\n"); 
		query.append("                             , MM.FM_YD_GRP_ID_2, MM.TO_YD_GRP_ID_2" ).append("\n"); 
		query.append("                             , DECODE(H.FM_YD_GRP_ID,'All', 'All', 'A', FM_YD_GRP_ID_2, 'B', FM_YD_GRP_ID_2) AS FM_YD_GRP_ID_3      " ).append("\n"); 
		query.append("                             , DECODE(H.TO_YD_GRP_ID, 'All', 'All', 'A', TO_YD_GRP_ID_2, 'B',TO_YD_GRP_ID_2) AS TO_YD_GRP_ID_3" ).append("\n"); 
		query.append("                       FROM(       " ).append("\n"); 
		query.append("                               SELECT    P.VSL_CD, P.SKD_VOY_NO, P.SKD_DIR_CD, P.DEP_PORT_CD, P.ARR_PORT_CD, P.PORT_TO_PORT_MLG_DIST" ).append("\n"); 
		query.append("                                          , H.FM_YD_GRP_ID, H.TO_YD_GRP_ID" ).append("\n"); 
		query.append("                                          , FM_PC.YD_GRP_ID AS FM_YD_GRP_ID_2" ).append("\n"); 
		query.append("                                          , TO_PC.YD_GRP_ID AS TO_YD_GRP_ID_2" ).append("\n"); 
		query.append("                                          " ).append("\n"); 
		query.append("                                FROM      VSK_PASG_PLN_RPT P " ).append("\n"); 
		query.append("                                        , MDM_VSL_CNTR     VC" ).append("\n"); 
		query.append("                                        ,( SELECT   PS.VSL_CD" ).append("\n"); 
		query.append("                                                    ,PS.SKD_VOY_NO" ).append("\n"); 
		query.append("                                                    ,PS.SKD_DIR_CD" ).append("\n"); 
		query.append("                                                    ,PS.VPS_PORT_CD" ).append("\n"); 
		query.append("                                                    ,PS.YD_CD" ).append("\n"); 
		query.append("                                                    ,NVL(YG.YD_GRP_ID,'All') as YD_GRP_ID" ).append("\n"); 
		query.append("                                           FROM     VSK_VSL_PORT_SKD PS" ).append("\n"); 
		query.append("                                                    , VSK_YD_GRP       YG" ).append("\n"); 
		query.append("                                           WHERE PS.YD_CD = YG.YD_CD (+) ) FM_PC        " ).append("\n"); 
		query.append("                                        ,( SELECT   PS.VSL_CD " ).append("\n"); 
		query.append("                                                    ,PS.SKD_VOY_NO" ).append("\n"); 
		query.append("                                                    ,PS.SKD_DIR_CD" ).append("\n"); 
		query.append("                                                    ,PS.VPS_PORT_CD" ).append("\n"); 
		query.append("                                                    ,PS.YD_CD" ).append("\n"); 
		query.append("                                                    ,NVL(YG.YD_GRP_ID,'All') as  YD_GRP_ID" ).append("\n"); 
		query.append("                                           FROM     VSK_VSL_PORT_SKD PS" ).append("\n"); 
		query.append("                                                    , VSK_YD_GRP       YG" ).append("\n"); 
		query.append("                                           WHERE PS.YD_CD = YG.YD_CD(+) ) TO_PC" ).append("\n"); 
		query.append("                                           ,VSK_PORT_OPMZ_DIST       H" ).append("\n"); 
		query.append("                                WHERE 1=1" ).append("\n"); 
		query.append("                                AND P.VSL_CD            = VC.VSL_CD" ).append("\n"); 
		query.append("                                AND P.VSL_CD            = FM_PC.VSL_CD (+)" ).append("\n"); 
		query.append("                                AND P.SKD_VOY_NO        = FM_PC.SKD_VOY_NO (+)" ).append("\n"); 
		query.append("                                AND P.SKD_DIR_CD        = FM_PC.SKD_DIR_CD  (+)" ).append("\n"); 
		query.append("                                AND P.DEP_PORT_CD       = FM_PC.VPS_PORT_CD (+)" ).append("\n"); 
		query.append("                                AND P.VSL_CD            = TO_PC.VSL_CD      (+)" ).append("\n"); 
		query.append("                                AND P.SKD_VOY_NO        = TO_PC.SKD_VOY_NO (+)" ).append("\n"); 
		query.append("                                AND P.SKD_DIR_CD        = TO_PC.SKD_DIR_CD  (+)" ).append("\n"); 
		query.append("                                AND P.ARR_PORT_CD       = TO_PC.VPS_PORT_CD (+)" ).append("\n"); 
		query.append("                                AND P.DEP_PORT_CD       = SUBSTR(H.FM_YD_CD,1,5) " ).append("\n"); 
		query.append("                                AND P.ARR_PORT_CD       = SUBSTR(H.TO_YD_CD,1,5)" ).append("\n"); 
		query.append("                                AND P.PORT_TO_PORT_MLG_DIST BETWEEN H.RNG_MIN_DIST AND DECODE(H.RNG_MAX_DIST,NULL,99999,0,99999,H.RNG_MAX_DIST)" ).append("\n"); 
		query.append("                                AND P.PASG_PLN_DT BETWEEN TO_DATE(@[fm_date],'YYYY-MM-DD') AND TO_DATE(@[to_date],'YYYY-MM-DD')+0.99999" ).append("\n"); 
		query.append("                                ) MM    " ).append("\n"); 
		query.append("                                ,VSK_PORT_OPMZ_DIST       H                " ).append("\n"); 
		query.append("                        WHERE   1=1" ).append("\n"); 
		query.append("                        AND     MM.DEP_PORT_CD       = H.FM_YD_CD" ).append("\n"); 
		query.append("                        AND     MM.ARR_PORT_CD       = H.TO_YD_CD" ).append("\n"); 
		query.append("                        ) O" ).append("\n"); 
		query.append("            WHERE   1=1" ).append("\n"); 
		query.append("            AND     O.DEP_PORT_CD       = H.FM_YD_CD" ).append("\n"); 
		query.append("            AND     O.ARR_PORT_CD       = H.TO_YD_CD" ).append("\n"); 
		query.append("            AND     O.FM_YD_GRP_ID_3    = H.FM_YD_GRP_ID" ).append("\n"); 
		query.append("            AND     O.TO_YD_GRP_ID_3    = H.TO_YD_GRP_ID" ).append("\n"); 
		query.append("		) AS VMS_SHTG_DIST" ).append("\n"); 
		query.append("      ,  H.RNG_MAX_DIST" ).append("\n"); 
		query.append("      ,  H.RNG_MIN_DIST" ).append("\n"); 
		query.append("      ,  H.UPD_USR_ID" ).append("\n"); 
		query.append("      ,  TO_CHAR (H.UPD_DT, 'YYYY-MM-DD HH24:MI') AS UPD_DT" ).append("\n"); 
		query.append("      ,  H.FILE_NM" ).append("\n"); 
		query.append("      ,  H.FILE_SAV_ID " ).append("\n"); 
		query.append("FROM     VSK_PORT_OPMZ_DIST       H" ).append("\n"); 
		query.append("      ,  VSK_PORT_DIST            D" ).append("\n"); 
		query.append("#if (${vsl_slan_cd} != '')" ).append("\n"); 
		query.append("      ,  (" ).append("\n"); 
		query.append("            SELECT  D.VSL_SLAN_CD" ).append("\n"); 
		query.append("            , D.PF_SVC_TP_CD" ).append("\n"); 
		query.append("            , D.SKD_DIR_CD" ).append("\n"); 
		query.append("            , T4.VSL_SLAN_DIR_SEQ" ).append("\n"); 
		query.append("            , D.PORT_ROTN_SEQ" ).append("\n"); 
		query.append("            , D.PORT_CD AS FM_PORT_CD" ).append("\n"); 
		query.append("            , LEAD(D.PORT_CD  ) OVER (PARTITION BY D.VSL_SLAN_CD ORDER BY T4.VSL_SLAN_DIR_SEQ, D.PORT_ROTN_SEQ)        AS TO_PORT_CD" ).append("\n"); 
		query.append("            FROM    VSK_PF_SKD M" ).append("\n"); 
		query.append("                    , VSK_PF_SKD_DTL D" ).append("\n"); 
		query.append("                    , MDM_VSL_SVC_LANE_DIR T4" ).append("\n"); 
		query.append("                    , MDM_VSL_SVC_LANE T5" ).append("\n"); 
		query.append("            WHERE   1=1" ).append("\n"); 
		query.append("            AND     M.VSL_SLAN_CD = D.VSL_SLAN_CD" ).append("\n"); 
		query.append("            AND     M.PF_SVC_TP_CD = D.PF_SVC_TP_CD" ).append("\n"); 
		query.append("            AND     M.SLAN_STND_FLG = 'Y'" ).append("\n"); 
		query.append("            AND     D.VSL_SLAN_CD      = T4.VSL_SLAN_CD" ).append("\n"); 
		query.append("            AND     D.SKD_DIR_CD    = T4.VSL_SLAN_DIR_CD" ).append("\n"); 
		query.append("            AND     D.VSL_SLAN_CD      = T5.VSL_SLAN_CD" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        --AND     D.TURN_PORT_IND_CD NOT IN ('D', 'V', 'F')" ).append("\n"); 
		query.append("        AND     M.VSL_SLAN_CD = @[vsl_slan_cd]" ).append("\n"); 
		query.append("        ORDER BY    D.VSL_SLAN_CD, T4.VSL_SLAN_DIR_SEQ, D.PORT_ROTN_SEQ   " ).append("\n"); 
		query.append("        ) X" ).append("\n"); 
		query.append("#end      " ).append("\n"); 
		query.append("WHERE    1=1" ).append("\n"); 
		query.append("AND      SUBSTR(H.FM_YD_CD,1,5) = D.FM_LOC_CD (+)" ).append("\n"); 
		query.append("AND      SUBSTR(H.TO_YD_CD,1,5) = D.TO_LOC_CD (+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${vsl_slan_cd} == '' && ${fm_port_cd} != '')" ).append("\n"); 
		query.append("AND      H.FM_YD_CD LIKE @[fm_port_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${vsl_slan_cd} != '')" ).append("\n"); 
		query.append("AND      D.FM_LOC_CD    = X.FM_PORT_CD (+)" ).append("\n"); 
		query.append("AND      D.TO_LOC_CD    = X.TO_PORT_CD (+)" ).append("\n"); 
		query.append("AND      X.VSL_SLAN_CD = @[vsl_slan_cd]" ).append("\n"); 
		query.append("ORDER BY X.VSL_SLAN_DIR_SEQ, X.PORT_ROTN_SEQ" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${vsl_slan_cd} == '' && ${to_port_cd} != '')" ).append("\n"); 
		query.append("AND      H.TO_YD_CD LIKE @[to_port_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${vsl_slan_cd} == '' && ${fm_yd_grp_cd} != 'All')" ).append("\n"); 
		query.append("AND      H.FM_YD_GRP_ID = @[fm_yd_grp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${vsl_slan_cd} == '' && ${to_yd_grp_cd} != ''&& ${to_yd_grp_cd} != 'All')" ).append("\n"); 
		query.append("AND      H.TO_YD_GRP_ID = @[to_yd_grp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}