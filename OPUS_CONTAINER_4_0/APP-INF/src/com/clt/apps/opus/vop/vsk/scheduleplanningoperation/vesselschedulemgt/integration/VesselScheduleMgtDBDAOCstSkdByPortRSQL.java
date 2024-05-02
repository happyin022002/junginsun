/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : VesselScheduleMgtDBDAOCstSkdByPortRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.10.19
*@LastModifier : 
*@LastVersion : 1.0
* 2016.10.19 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VesselScheduleMgtDBDAOCstSkdByPortRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 해당 Port의 Costal Schedule 정보를 조회합니다.
	  * </pre>
	  */
	public VesselScheduleMgtDBDAOCstSkdByPortRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("type_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("carrier_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vps_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration").append("\n"); 
		query.append("FileName : VesselScheduleMgtDBDAOCstSkdByPortRSQL").append("\n"); 
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
		query.append("SELECT  VSL_CD" ).append("\n"); 
		query.append("        , SKD_VOY_NO" ).append("\n"); 
		query.append("        , SKD_DIR_CD" ).append("\n"); 
		query.append("        , VSL_CD || SKD_VOY_NO || SKD_DIR_CD AS VVD" ).append("\n"); 
		query.append("        , (" ).append("\n"); 
		query.append("            SELECT  VSL_ENG_NM" ).append("\n"); 
		query.append("            FROM    MDM_VSL_CNTR" ).append("\n"); 
		query.append("            WHERE   VSL_CD = T11.VSL_CD" ).append("\n"); 
		query.append("          ) AS VSL_ENG_NM" ).append("\n"); 
		query.append("        , VSL_SLAN_CD" ).append("\n"); 
		query.append("        , IB_CSSM_VOY_NO" ).append("\n"); 
		query.append("        , OB_CSSM_VOY_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		, CASE 	WHEN CGO_CLZ_DT IS NOT NULL 	THEN TO_CHAR(CGO_CLZ_DT		, 'YYYYMMDDHH24MI')	" ).append("\n"); 
		query.append("				--:2016-10-19:--ELSE TO_CHAR(PRD_GET_CCT_FNC(POL_YARD,VSL_SLAN_CD,SKD_DIR_CD,'DR',VSL_CD||SKD_VOY_NO||SKD_DIR_CD,CLPT_IND_SEQ,POL_ETB,POL_ETD), 'YYYYMMDDHH24MI')	" ).append("\n"); 
		query.append("				ELSE TO_CHAR(PRD_COMMON_PKG.PRD_GET_CCT_BY_BKG_INFO_FNC(VSL_CD,SKD_VOY_NO,SKD_DIR_CD,VPS_PORT_CD,CLPT_IND_SEQ,POL_YARD,'NNNNY'), 'YYYYMMDDHH24MI')	" ).append("\n"); 
		query.append("		  END	AS CGO_CLZ_DT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		, CASE 	WHEN DCGO_CLZ_DT IS NOT NULL 	THEN TO_CHAR(DCGO_CLZ_DT	, 'YYYYMMDDHH24MI')	" ).append("\n"); 
		query.append("				--:2016-10-19:--ELSE TO_CHAR(PRD_GET_CCT_FNC(POL_YARD,VSL_SLAN_CD,SKD_DIR_CD,'DG',VSL_CD||SKD_VOY_NO||SKD_DIR_CD,CLPT_IND_SEQ,POL_ETB,POL_ETD), 'YYYYMMDDHH24MI')	" ).append("\n"); 
		query.append("				ELSE TO_CHAR(PRD_COMMON_PKG.PRD_GET_CCT_BY_BKG_INFO_FNC(VSL_CD,SKD_VOY_NO,SKD_DIR_CD,VPS_PORT_CD,CLPT_IND_SEQ,POL_YARD,'YNNNN'), 'YYYYMMDDHH24MI')	" ).append("\n"); 
		query.append("		  END	AS DCGO_CLZ_DT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		, CASE 	WHEN RC_CLZ_DT IS NOT NULL 		THEN TO_CHAR(RC_CLZ_DT		, 'YYYYMMDDHH24MI')	" ).append("\n"); 
		query.append("				--:2016-10-19:--ELSE TO_CHAR(PRD_GET_CCT_FNC(POL_YARD,VSL_SLAN_CD,SKD_DIR_CD,'RF',VSL_CD||SKD_VOY_NO||SKD_DIR_CD,CLPT_IND_SEQ,POL_ETB,POL_ETD), 'YYYYMMDDHH24MI')	" ).append("\n"); 
		query.append("				ELSE TO_CHAR(PRD_COMMON_PKG.PRD_GET_CCT_BY_BKG_INFO_FNC(VSL_CD,SKD_VOY_NO,SKD_DIR_CD,VPS_PORT_CD,CLPT_IND_SEQ,POL_YARD,'NYNNN'), 'YYYYMMDDHH24MI')	" ).append("\n"); 
		query.append("		  END	AS RC_CLZ_DT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		, CASE 	WHEN AWK_CGO_CLZ_DT IS NOT NULL THEN TO_CHAR(AWK_CGO_CLZ_DT	, 'YYYYMMDDHH24MI')	" ).append("\n"); 
		query.append("				--:2016-10-19:--ELSE TO_CHAR(PRD_GET_CCT_FNC(POL_YARD,VSL_SLAN_CD,SKD_DIR_CD,'AK',VSL_CD||SKD_VOY_NO||SKD_DIR_CD,CLPT_IND_SEQ,POL_ETB,POL_ETD), 'YYYYMMDDHH24MI')	" ).append("\n"); 
		query.append("				ELSE TO_CHAR(PRD_COMMON_PKG.PRD_GET_CCT_BY_BKG_INFO_FNC(VSL_CD,SKD_VOY_NO,SKD_DIR_CD,VPS_PORT_CD,CLPT_IND_SEQ,POL_YARD,'NNYNN'), 'YYYYMMDDHH24MI')	" ).append("\n"); 
		query.append("		  END	AS AWK_CGO_CLZ_DT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		, CASE 	WHEN BB_CGO_CLZ_DT IS NOT NULL  THEN TO_CHAR(BB_CGO_CLZ_DT  , 'YYYYMMDDHH24MI')	" ).append("\n"); 
		query.append("				--:2016-10-19:--ELSE TO_CHAR(PRD_GET_CCT_FNC(POL_YARD,VSL_SLAN_CD,SKD_DIR_CD,'BB',VSL_CD||SKD_VOY_NO||SKD_DIR_CD,CLPT_IND_SEQ,POL_ETB,POL_ETD), 'YYYYMMDDHH24MI')	" ).append("\n"); 
		query.append("				ELSE TO_CHAR(PRD_COMMON_PKG.PRD_GET_CCT_BY_BKG_INFO_FNC(VSL_CD,SKD_VOY_NO,SKD_DIR_CD,VPS_PORT_CD,CLPT_IND_SEQ,POL_YARD,'NNNYN'), 'YYYYMMDDHH24MI')	" ).append("\n"); 
		query.append("		  END	AS BB_CGO_CLZ_DT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		, CASE 	WHEN VGM_CLZ_DT IS NOT NULL 	THEN TO_CHAR(VGM_CLZ_DT		, 'YYYYMMDDHH24MI')	" ).append("\n"); 
		query.append("				ELSE TO_CHAR(BKG_GET_VGM_CCT_FNC(POL_YARD,VSL_SLAN_CD,SKD_DIR_CD,'DR',VSL_CD||SKD_VOY_NO||SKD_DIR_CD,CLPT_IND_SEQ,POL_ETB,POL_ETD), 'YYYYMMDDHH24MI')	" ).append("\n"); 
		query.append("		  END	AS VGM_CLZ_DT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        , POL_PORT" ).append("\n"); 
		query.append("        , POL_YARD" ).append("\n"); 
		query.append("		, (" ).append("\n"); 
		query.append("			SELECT YD_NM" ).append("\n"); 
		query.append("			FROM MDM_YARD" ).append("\n"); 
		query.append("			WHERE YD_CD = POL_YARD" ).append("\n"); 
		query.append("		) AS POL_YARD_NM" ).append("\n"); 
		query.append("        , NVL(POL_YARD, '') AS POL_TML_CD" ).append("\n"); 
		query.append("        , TO_CHAR(POL_ETA, 'YYYYMMDDHH24MI') AS POL_ETA" ).append("\n"); 
		query.append("        , TO_CHAR(POL_ETB, 'YYYYMMDDHH24MI') AS POL_ETB" ).append("\n"); 
		query.append("        , TO_CHAR(POL_ETD, 'YYYYMMDDHH24MI') AS POL_ETD" ).append("\n"); 
		query.append("        , SUBSTR(NEXT_PORT_ETA, 13, 5 ) AS NEXT_PORT" ).append("\n"); 
		query.append("        , SUBSTR(NEXT_PORT_ETA, 18    ) AS NEXT_YARD" ).append("\n"); 
		query.append("        , SUBSTR(NEXT_PORT_ETA, 1, 12) AS NEXT_ETA" ).append("\n"); 
		query.append("        , TO_CHAR(PF_ETB, 'YYYYMMDDHH24MI') AS PF_ETB" ).append("\n"); 
		query.append("        , TO_CHAR(PF_ETD, 'YYYYMMDDHH24MI') AS PF_ETD" ).append("\n"); 
		query.append("        , ROUND(DECODE(PF_ETB, NULL, 0, POL_ETB - PF_ETB), 1) AS DELY_ETB_TM" ).append("\n"); 
		query.append("        , ROUND(DECODE(PF_ETD, NULL, 0, POL_ETD - PF_ETD), 1) AS DELY_ETD_TM" ).append("\n"); 
		query.append("        , CARRIER_CD" ).append("\n"); 
		query.append("        , VPS_PORT_CD" ).append("\n"); 
		query.append("        , '' AS TYPE_CD" ).append("\n"); 
		query.append("        , '' AS FM_DT" ).append("\n"); 
		query.append("        , '' AS TO_DT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM    (" ).append("\n"); 
		query.append("            SELECT  T1.VSL_CD,  T1.SKD_VOY_NO, T1.SKD_DIR_CD, T1.VSL_SLAN_CD" ).append("\n"); 
		query.append("                    , T2.VPS_PORT_CD AS POL_PORT" ).append("\n"); 
		query.append("					, T2.CLPT_SEQ" ).append("\n"); 
		query.append("					, T2.CLPT_IND_SEQ" ).append("\n"); 
		query.append("                    , T2.YD_CD       AS POL_YARD" ).append("\n"); 
		query.append("                    , T2.VPS_ETA_DT  AS POL_ETA                    " ).append("\n"); 
		query.append("                    , T2.VPS_ETB_DT  AS POL_ETB" ).append("\n"); 
		query.append("                    , T2.VPS_ETD_DT  AS POL_ETD               " ).append("\n"); 
		query.append("                    , T2.PF_ETB_DT   AS PF_ETB" ).append("\n"); 
		query.append("                    , T2.PF_ETD_DT   AS PF_ETD" ).append("\n"); 
		query.append("                    , T2.TURN_PORT_IND_CD    " ).append("\n"); 
		query.append("                    , T2.IB_CSSM_VOY_NO" ).append("\n"); 
		query.append("                    , T2.OB_CSSM_VOY_NO      " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("					, T2.CGO_CLZ_DT" ).append("\n"); 
		query.append("					, T2.DCGO_CLZ_DT" ).append("\n"); 
		query.append("					, T2.RC_CLZ_DT" ).append("\n"); 
		query.append("					, T2.AWK_CGO_CLZ_DT" ).append("\n"); 
		query.append("					, T2.BB_CGO_CLZ_DT" ).append("\n"); 
		query.append("					, T2.VGM_CLZ_DT" ).append("\n"); 
		query.append("					          " ).append("\n"); 
		query.append("                    , (" ).append("\n"); 
		query.append("                        SELECT  TO_CHAR(S1.VPS_ETA_DT, 'YYYYMMDDHH24MI')||S1.VPS_PORT_CD||S1.YD_CD" ).append("\n"); 
		query.append("                        FROM    VSK_VSL_PORT_SKD S1" ).append("\n"); 
		query.append("                        WHERE   VSL_CD = T2.VSL_CD" ).append("\n"); 
		query.append("                        AND     SKD_VOY_NO = T2.SKD_VOY_NO" ).append("\n"); 
		query.append("                        AND     SKD_DIR_CD = T2.SKD_DIR_CD" ).append("\n"); 
		query.append("                        AND     CLPT_SEQ =  (" ).append("\n"); 
		query.append("                                                SELECT  MIN(CLPT_SEQ)" ).append("\n"); 
		query.append("                                                FROM    VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("                                                WHERE   VSL_CD = T2.VSL_CD" ).append("\n"); 
		query.append("                                                AND     SKD_VOY_NO = T2.SKD_VOY_NO" ).append("\n"); 
		query.append("                                                AND     SKD_DIR_CD = T2.SKD_DIR_CD" ).append("\n"); 
		query.append("                                                AND     CLPT_SEQ > T2.CLPT_SEQ" ).append("\n"); 
		query.append("                                                      AND     (SKD_CNG_STS_CD IS NULL OR SKD_CNG_STS_CD != 'S')" ).append("\n"); 
		query.append("                         and 	rownum  	= 1" ).append("\n"); 
		query.append("                        )" ).append("\n"); 
		query.append("						AND		ROWNUM		= 1" ).append("\n"); 
		query.append("                      ) AS NEXT_PORT_ETA" ).append("\n"); 
		query.append("                    , NVL(T1.ACT_CRR_CD, T3.CRR_CD) AS CARRIER_CD" ).append("\n"); 
		query.append("                    , DECODE(T4.VSL_SVC_TP_CD, NULL, 'O', 'O', 'O', 'T') AS VSL_SVC_TP_CD" ).append("\n"); 
		query.append("                    , VPS_PORT_CD" ).append("\n"); 
		query.append("            FROM    VSK_VSL_SKD T1, VSK_VSL_PORT_SKD T2, MDM_VSL_CNTR T3, MDM_VSL_SVC_LANE T4" ).append("\n"); 
		query.append("            WHERE   T1.VSL_CD       = T2.VSL_CD" ).append("\n"); 
		query.append("            AND     T1.SKD_VOY_NO   = T2.SKD_VOY_NO" ).append("\n"); 
		query.append("            AND     T1.SKD_DIR_CD   = T2.SKD_DIR_CD" ).append("\n"); 
		query.append("            AND     T1.VSL_CD       = T3.VSL_CD" ).append("\n"); 
		query.append("            AND     T1.VSL_SLAN_CD  = T4.VSL_SLAN_CD" ).append("\n"); 
		query.append("#if (${vps_port_cd} != '') " ).append("\n"); 
		query.append("            AND     T2.VPS_PORT_CD  = @[vps_port_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vsl_cd} != '') " ).append("\n"); 
		query.append("            AND     T1.VSL_CD  = @[vsl_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vsl_slan_cd} != '') " ).append("\n"); 
		query.append("            AND     T1.VSL_SLAN_CD  LIKE @[vsl_slan_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${carrier_cd} != '') " ).append("\n"); 
		query.append("            AND     @[carrier_cd] = NVL(T1.ACT_CRR_CD, T3.CRR_CD)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("            AND     T2.VPS_ETA_DT   BETWEEN TO_DATE(@[fm_dt], 'YYYY-MM-DD') AND  TO_DATE(@[to_dt], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("            AND     (T2.TURN_PORT_IND_CD IS NULL OR T2.TURN_PORT_IND_CD NOT IN ('D', 'V', 'F'))" ).append("\n"); 
		query.append("            AND     (T2.SKD_CNG_STS_CD IS NULL OR T2.SKD_CNG_STS_CD != 'S')" ).append("\n"); 
		query.append("            AND     T4.VSL_TP_CD = 'C' /*컨테이너선*/" ).append("\n"); 
		query.append("        ) T11" ).append("\n"); 
		query.append("WHERE   1 = 1" ).append("\n"); 
		query.append("#if (${type_cd} != '') " ).append("\n"); 
		query.append("AND		VSL_SVC_TP_CD = @[type_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY VSL_CD, SKD_VOY_NO, SKD_DIR_CD, CLPT_SEQ" ).append("\n"); 

	}
}