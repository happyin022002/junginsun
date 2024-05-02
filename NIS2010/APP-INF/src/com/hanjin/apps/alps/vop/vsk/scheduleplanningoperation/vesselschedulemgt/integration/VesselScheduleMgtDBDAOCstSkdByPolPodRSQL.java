/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : VesselScheduleMgtDBDAOCstSkdByPolPodRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.20
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.20 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VesselScheduleMgtDBDAOCstSkdByPolPodRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * POL, POD에 의한 Costal Schedule 정보를 조회합니다.
	  * 
	  * History
	  * 2015.09.04 이병훈	[CHM-201537542] Yarc Code 말풍선 도움말 기능 지원
	  * </pre>
	  */
	public VesselScheduleMgtDBDAOCstSkdByPolPodRSQL(){
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
		params.put("pod_port",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pol_port",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration").append("\n"); 
		query.append("FileName : VesselScheduleMgtDBDAOCstSkdByPolPodRSQL").append("\n"); 
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
		query.append("		, SKD_DIR_CD" ).append("\n"); 
		query.append("        , VSL_CD || SKD_VOY_NO || SKD_DIR_CD AS VVD" ).append("\n"); 
		query.append("		, VSL_SLAN_CD" ).append("\n"); 
		query.append("		, POL_PORT" ).append("\n"); 
		query.append("		, POL_YARD" ).append("\n"); 
		query.append("		, (SELECT YD_NM FROM MDM_YARD WHERE YD_CD = POL_YARD) AS POL_YARD_NM" ).append("\n"); 
		query.append("        , DECODE(POL_YARD, NULL, '', SUBSTR(POL_YARD, 6, 2)) AS POL_TML_CD" ).append("\n"); 
		query.append("        , TO_CHAR(POL_ETA, 'YYYYMMDDHH24MI') AS POL_ETA" ).append("\n"); 
		query.append("        , TO_CHAR(POL_ETB, 'YYYYMMDDHH24MI') AS POL_ETB" ).append("\n"); 
		query.append("        , TO_CHAR(POL_ETD, 'YYYYMMDDHH24MI') AS POL_ETD" ).append("\n"); 
		query.append("		, POD_PORT" ).append("\n"); 
		query.append("		, POD_YARD" ).append("\n"); 
		query.append("		, (SELECT YD_NM FROM MDM_YARD WHERE YD_CD = POD_YARD) AS POD_YARD_NM" ).append("\n"); 
		query.append("        , DECODE(POD_YARD, NULL, '', SUBSTR(POD_YARD, 6, 2)) AS POD_TML_CD" ).append("\n"); 
		query.append("        , TO_CHAR(POD_ETA, 'YYYYMMDDHH24MI') AS POD_ETA" ).append("\n"); 
		query.append("        , TO_CHAR(POD_ETB, 'YYYYMMDDHH24MI') AS POD_ETB" ).append("\n"); 
		query.append("        , TO_CHAR(POD_ETD, 'YYYYMMDDHH24MI') AS POD_ETD" ).append("\n"); 
		query.append("		, ROUND(DECODE(POD_PF_ETB, NULL, 0, POD_ETB - POD_PF_ETB), 1) AS DELAY_DATE" ).append("\n"); 
		query.append("		, CARRIER_CD" ).append("\n"); 
		query.append("        , '' AS FM_DT" ).append("\n"); 
		query.append("        , '' AS TO_DT" ).append("\n"); 
		query.append("FROM    (" ).append("\n"); 
		query.append("            SELECT  T1.VSL_CD,  T1.SKD_VOY_NO, T1.SKD_DIR_CD,T1.VSL_SLAN_CD" ).append("\n"); 
		query.append("                    , T2.VPS_PORT_CD POL_PORT" ).append("\n"); 
		query.append("                    , T2.YD_CD      POL_YARD" ).append("\n"); 
		query.append("                    , T2.VPS_ETA_DT POL_ETA                    " ).append("\n"); 
		query.append("                    , T2.VPS_ETB_DT POL_ETB" ).append("\n"); 
		query.append("                    , T2.VPS_ETD_DT POL_ETD" ).append("\n"); 
		query.append("                    , LEAD(T2.VPS_PORT_CD) OVER (PARTITION BY T1.VSL_CD,  T1.SKD_VOY_NO, T1.SKD_DIR_CD ORDER BY T1.VSL_CD,  T1.SKD_VOY_NO, T1.SKD_DIR_CD, CLPT_SEQ) AS POD_PORT" ).append("\n"); 
		query.append("                    , LEAD(T2.YD_CD      ) OVER (PARTITION BY T1.VSL_CD,  T1.SKD_VOY_NO, T1.SKD_DIR_CD ORDER BY T1.VSL_CD,  T1.SKD_VOY_NO, T1.SKD_DIR_CD, CLPT_SEQ) AS POD_YARD" ).append("\n"); 
		query.append("                    , LEAD(T2.VPS_ETA_DT ) OVER (PARTITION BY T1.VSL_CD,  T1.SKD_VOY_NO, T1.SKD_DIR_CD ORDER BY T1.VSL_CD,  T1.SKD_VOY_NO, T1.SKD_DIR_CD, CLPT_SEQ) AS POD_ETA" ).append("\n"); 
		query.append("                    , LEAD(T2.VPS_ETB_DT ) OVER (PARTITION BY T1.VSL_CD,  T1.SKD_VOY_NO, T1.SKD_DIR_CD ORDER BY T1.VSL_CD,  T1.SKD_VOY_NO, T1.SKD_DIR_CD, CLPT_SEQ) AS POD_ETB" ).append("\n"); 
		query.append("                    , LEAD(T2.PF_ETB_DT  ) OVER (PARTITION BY T1.VSL_CD,  T1.SKD_VOY_NO, T1.SKD_DIR_CD ORDER BY T1.VSL_CD,  T1.SKD_VOY_NO, T1.SKD_DIR_CD, CLPT_SEQ) AS POD_PF_ETB" ).append("\n"); 
		query.append("                    , LEAD(T2.VPS_ETD_DT ) OVER (PARTITION BY T1.VSL_CD,  T1.SKD_VOY_NO, T1.SKD_DIR_CD ORDER BY T1.VSL_CD,  T1.SKD_VOY_NO, T1.SKD_DIR_CD, CLPT_SEQ) AS POD_ETD" ).append("\n"); 
		query.append("                    , NVL(T1.ACT_CRR_CD, T3.CRR_CD) AS CARRIER_CD" ).append("\n"); 
		query.append("            FROM    VSK_VSL_SKD T1, VSK_VSL_PORT_SKD T2, MDM_VSL_CNTR T3" ).append("\n"); 
		query.append("            WHERE   T1.VSL_CD       = T2.VSL_CD" ).append("\n"); 
		query.append("            AND     T1.SKD_VOY_NO   = T2.SKD_VOY_NO" ).append("\n"); 
		query.append("            AND     T1.SKD_DIR_CD   = T2.SKD_DIR_CD" ).append("\n"); 
		query.append("            AND     T1.VSL_CD       = T3.VSL_CD" ).append("\n"); 
		query.append("#if (${vsl_slan_cd} != '' && ${vsl_slan_cd} != '') " ).append("\n"); 
		query.append("            AND     T1.VSL_SLAN_CD  LIKE @[vsl_slan_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("			AND     T2.VPS_ETA_DT   BETWEEN TO_DATE(@[fm_dt], 'YYYY-MM-DD') AND  TO_DATE(@[to_dt], 'YYYY-MM-DD') + 60" ).append("\n"); 
		query.append("            AND     T2.VPS_PORT_CD  IN (@[pol_port], @[pod_port])" ).append("\n"); 
		query.append("#if (${inc_vir_pol} != 'Y')" ).append("\n"); 
		query.append("            AND     EXISTS (SELECT 'X' FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("                            WHERE  VSL_CD=T1.VSL_CD" ).append("\n"); 
		query.append("                            AND    SKD_VOY_NO=T1.SKD_VOY_NO" ).append("\n"); 
		query.append("                            AND    SKD_DIR_CD=T1.SKD_DIR_CD" ).append("\n"); 
		query.append("                            AND    VPS_PORT_CD=@[pol_port]" ).append("\n"); 
		query.append("                            AND    TURN_PORT_IND_CD IN ('Y', 'N'))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("            AND     NVL(T2.SKD_CNG_STS_CD, 'X') <> 'S'" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("WHERE   1 = 1" ).append("\n"); 
		query.append("AND     POL_PORT    = @[pol_port]" ).append("\n"); 
		query.append("AND     POD_PORT    = @[pod_port]" ).append("\n"); 
		query.append("AND     POL_ETA   BETWEEN TO_DATE(@[fm_dt], 'YYYY-MM-DD') AND  TO_DATE(@[to_dt], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("ORDER BY POL_ETA" ).append("\n"); 

	}
}