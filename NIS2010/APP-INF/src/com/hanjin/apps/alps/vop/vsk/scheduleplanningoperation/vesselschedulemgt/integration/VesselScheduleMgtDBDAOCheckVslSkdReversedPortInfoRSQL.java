/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : VesselScheduleMgtDBDAOCheckVslSkdReversedPortInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.17
*@LastModifier : 
*@LastVersion : 1.0
* 2015.04.17 
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

public class VesselScheduleMgtDBDAOCheckVslSkdReversedPortInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Daily Berth Window의 ETA, ETB, ETD 수정시 기준 VVD Port와 이전 Port의 ETD 또는 이후 Port의 ETA의 시간 역전 Validation Check
	  * </pre>
	  */
	public VesselScheduleMgtDBDAOCheckVslSkdReversedPortInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vps_eta_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vps_etd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clpt_ind_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration").append("\n"); 
		query.append("FileName : VesselScheduleMgtDBDAOCheckVslSkdReversedPortInfoRSQL").append("\n"); 
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
		query.append("SELECT  XX.PRE_VSL_CD " ).append("\n"); 
		query.append("        ,XX.PRE_SKD_VOY_NO" ).append("\n"); 
		query.append("        ,XX.PRE_SKD_DIR_CD" ).append("\n"); 
		query.append("        ,XX.PRE_VPS_PORT_CD" ).append("\n"); 
		query.append("        ,XX.PRE_CLPT_IND_SEQ" ).append("\n"); 
		query.append("        ,XX.PRE_ETD_DT " ).append("\n"); 
		query.append("                                          " ).append("\n"); 
		query.append("        ,XX.VSL_CD                        " ).append("\n"); 
		query.append("        ,XX.SKD_VOY_NO                    " ).append("\n"); 
		query.append("        ,XX.SKD_DIR_CD                    " ).append("\n"); 
		query.append("        ,XX.VPS_PORT_CD                   " ).append("\n"); 
		query.append("        ,XX.CLPT_IND_SEQ                  " ).append("\n"); 
		query.append("        ,XX.CLPT_SEQ                      " ).append("\n"); 
		query.append("        ,TO_DATE(@[vps_eta_dt], 'YYYYMMDDHH24:MI')                    " ).append("\n"); 
		query.append("        ,XX.VPS_ETB_DT                    " ).append("\n"); 
		query.append("        ,TO_DATE(@[vps_etd_dt], 'YYYYMMDDHH24:MI')                    " ).append("\n"); 
		query.append("                                            " ).append("\n"); 
		query.append("        ,XX.NXT_VSL_CD" ).append("\n"); 
		query.append("        ,XX.NXT_SKD_VOY_NO" ).append("\n"); 
		query.append("        ,XX.NXT_SKD_DIR_CD" ).append("\n"); 
		query.append("        ,XX.NXT_VPS_PORT_CD" ).append("\n"); 
		query.append("        ,XX.NXT_CLPT_IND_SEQ                                                                                              " ).append("\n"); 
		query.append("        ,XX.NXT_ETA_DT" ).append("\n"); 
		query.append("        ,CASE WHEN  TO_DATE(@[vps_eta_dt], 'YYYYMMDDHH24:MI') - XX.PRE_ETD_DT <= 0 THEN 'Y'" ).append("\n"); 
		query.append("              ELSE  'N'" ).append("\n"); 
		query.append("         END  AS    PRE_RVS_EXIST_FLG" ).append("\n"); 
		query.append("        ,CASE WHEN  XX.NXT_ETA_DT - TO_DATE(@[vps_etd_dt], 'YYYYMMDDHH24:MI') <= 0 THEN 'Y'" ).append("\n"); 
		query.append("              ELSE  'N'" ).append("\n"); 
		query.append("         END  AS    NXT_RVS_EXIST_FLG" ).append("\n"); 
		query.append("                           " ).append("\n"); 
		query.append("FROM    (          " ).append("\n"); 
		query.append("        SELECT    LAG(T1.VSL_CD       , 1 , T1.VSL_CD      ) OVER(PARTITION BY T5.VSL_SVC_TP_CD, T1.VSL_CD ORDER BY T1.VPS_ETB_DT, T1.SKD_VOY_NO, T4.VSL_SLAN_DIR_SEQ, T1.CLPT_SEQ) AS PRE_VSL_CD" ).append("\n"); 
		query.append("                , LAG(T1.SKD_VOY_NO   , 1 , T1.SKD_VOY_NO  ) OVER(PARTITION BY T5.VSL_SVC_TP_CD, T1.VSL_CD ORDER BY T1.VPS_ETB_DT, T1.SKD_VOY_NO, T4.VSL_SLAN_DIR_SEQ, T1.CLPT_SEQ) AS PRE_SKD_VOY_NO" ).append("\n"); 
		query.append("                , LAG(T1.SKD_DIR_CD   , 1 , T1.SKD_DIR_CD  ) OVER(PARTITION BY T5.VSL_SVC_TP_CD, T1.VSL_CD ORDER BY T1.VPS_ETB_DT, T1.SKD_VOY_NO, T4.VSL_SLAN_DIR_SEQ, T1.CLPT_SEQ) AS PRE_SKD_DIR_CD" ).append("\n"); 
		query.append("                , LAG(T1.VPS_PORT_CD  , 1 , T1.VPS_PORT_CD ) OVER(PARTITION BY T5.VSL_SVC_TP_CD, T1.VSL_CD ORDER BY T1.VPS_ETB_DT, T1.SKD_VOY_NO, T4.VSL_SLAN_DIR_SEQ, T1.CLPT_SEQ) AS PRE_VPS_PORT_CD" ).append("\n"); 
		query.append("                , LAG(T1.CLPT_IND_SEQ , 1 , T1.CLPT_IND_SEQ) OVER(PARTITION BY T5.VSL_SVC_TP_CD, T1.VSL_CD ORDER BY T1.VPS_ETB_DT, T1.SKD_VOY_NO, T4.VSL_SLAN_DIR_SEQ, T1.CLPT_SEQ) AS PRE_CLPT_IND_SEQ" ).append("\n"); 
		query.append("                , LAG(T1.VPS_ETD_DT   , 1 , TO_DATE('19000101', 'YYYYMMDD')  ) OVER(PARTITION BY T5.VSL_SVC_TP_CD, T1.VSL_CD ORDER BY T1.VPS_ETB_DT, T1.SKD_VOY_NO, T4.VSL_SLAN_DIR_SEQ, T1.CLPT_SEQ) AS PRE_ETD_DT " ).append("\n"); 
		query.append("                " ).append("\n"); 
		query.append("                , T1.VSL_CD" ).append("\n"); 
		query.append("                , T1.SKD_VOY_NO" ).append("\n"); 
		query.append("                , T1.SKD_DIR_CD" ).append("\n"); 
		query.append("                , T1.VPS_PORT_CD" ).append("\n"); 
		query.append("                , T1.CLPT_IND_SEQ" ).append("\n"); 
		query.append("                , T1.CLPT_SEQ          " ).append("\n"); 
		query.append("                , T1.VPS_ETA_DT    " ).append("\n"); 
		query.append("                , T1.VPS_ETB_DT" ).append("\n"); 
		query.append("                , T1.VPS_ETD_DT" ).append("\n"); 
		query.append("                " ).append("\n"); 
		query.append("                , LEAD(T1.VSL_CD       , 1, T1.VSL_CD      ) OVER(PARTITION BY T5.VSL_SVC_TP_CD, T1.VSL_CD ORDER BY T1.VPS_ETB_DT, T1.SKD_VOY_NO, T4.VSL_SLAN_DIR_SEQ, T1.CLPT_SEQ) AS NXT_VSL_CD" ).append("\n"); 
		query.append("                , LEAD(T1.SKD_VOY_NO   , 1, T1.SKD_VOY_NO  ) OVER(PARTITION BY T5.VSL_SVC_TP_CD, T1.VSL_CD ORDER BY T1.VPS_ETB_DT, T1.SKD_VOY_NO, T4.VSL_SLAN_DIR_SEQ, T1.CLPT_SEQ) AS NXT_SKD_VOY_NO" ).append("\n"); 
		query.append("                , LEAD(T1.SKD_DIR_CD   , 1, T1.SKD_DIR_CD  ) OVER(PARTITION BY T5.VSL_SVC_TP_CD, T1.VSL_CD ORDER BY T1.VPS_ETB_DT, T1.SKD_VOY_NO, T4.VSL_SLAN_DIR_SEQ, T1.CLPT_SEQ) AS NXT_SKD_DIR_CD" ).append("\n"); 
		query.append("                , LEAD(T1.VPS_PORT_CD  , 1, T1.VPS_PORT_CD ) OVER(PARTITION BY T5.VSL_SVC_TP_CD, T1.VSL_CD ORDER BY T1.VPS_ETB_DT, T1.SKD_VOY_NO, T4.VSL_SLAN_DIR_SEQ, T1.CLPT_SEQ) AS NXT_VPS_PORT_CD" ).append("\n"); 
		query.append("                , LEAD(T1.CLPT_IND_SEQ , 1, T1.CLPT_IND_SEQ) OVER(PARTITION BY T5.VSL_SVC_TP_CD, T1.VSL_CD ORDER BY T1.VPS_ETB_DT, T1.SKD_VOY_NO, T4.VSL_SLAN_DIR_SEQ, T1.CLPT_SEQ) AS NXT_CLPT_IND_SEQ" ).append("\n"); 
		query.append("                , LEAD(T1.VPS_ETA_DT   , 1, TO_DATE('29991231', 'YYYYMMDD')) OVER(PARTITION BY T5.VSL_SVC_TP_CD, T1.VSL_CD ORDER BY T1.VPS_ETB_DT, T1.SKD_VOY_NO, T4.VSL_SLAN_DIR_SEQ, T1.CLPT_SEQ) AS NXT_ETA_DT" ).append("\n"); 
		query.append("        FROM    VSK_VSL_PORT_SKD T1" ).append("\n"); 
		query.append("                ,(" ).append("\n"); 
		query.append("                   SELECT  VSL_CD, SKD_VOY_NO, SKD_DIR_CD" ).append("\n"); 
		query.append("                           , CASE WHEN TURN_PORT_IND_CD IN ('V', 'F') THEN 1 ELSE 3 END AS SEQ" ).append("\n"); 
		query.append("                   FROM    VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("                   WHERE   1=1" ).append("\n"); 
		query.append("                   AND     VSL_CD                = @[vsl_cd]" ).append("\n"); 
		query.append("                   AND     TURN_SKD_VOY_NO       = @[skd_voy_no]" ).append("\n"); 
		query.append("                   AND     TURN_SKD_DIR_CD       = @[skd_dir_cd]" ).append("\n"); 
		query.append("                   GROUP BY VSL_CD, SKD_VOY_NO, SKD_DIR_CD, CASE WHEN TURN_PORT_IND_CD IN ('V', 'F') THEN 1 ELSE 3 END" ).append("\n"); 
		query.append("                   UNION ALL" ).append("\n"); 
		query.append("                   SELECT  @[vsl_cd], @[skd_voy_no], @[skd_dir_cd], 2 SEQ" ).append("\n"); 
		query.append("                   FROM DUAL" ).append("\n"); 
		query.append("                ) T2" ).append("\n"); 
		query.append("                , MDM_VSL_SVC_LANE_DIR T4" ).append("\n"); 
		query.append("                , MDM_VSL_SVC_LANE T5" ).append("\n"); 
		query.append("        WHERE   1=1" ).append("\n"); 
		query.append("        AND     T1.VSL_CD       = T2.VSL_CD" ).append("\n"); 
		query.append("        AND     T1.SKD_VOY_NO   = T2.SKD_VOY_NO" ).append("\n"); 
		query.append("        AND     T1.SKD_DIR_CD   = T2.SKD_DIR_CD" ).append("\n"); 
		query.append("        AND      NVL(T1.SKD_CNG_STS_CD, ' ') <> 'S'" ).append("\n"); 
		query.append("        AND      NVL(T1.TURN_PORT_IND_CD, ' ') NOT IN ('D', 'V', 'F')" ).append("\n"); 
		query.append("        AND      T1.SLAN_CD      = T4.VSL_SLAN_CD" ).append("\n"); 
		query.append("        AND      T1.SKD_DIR_CD   = T4.VSL_SLAN_DIR_CD" ).append("\n"); 
		query.append("        AND      T1.SLAN_CD      = T5.VSL_SLAN_CD" ).append("\n"); 
		query.append("          ) XX" ).append("\n"); 
		query.append("WHERE     1 = 1                " ).append("\n"); 
		query.append("AND      XX.VSL_CD           = @[vsl_cd]" ).append("\n"); 
		query.append("AND      XX.SKD_VOY_NO       = @[skd_voy_no]" ).append("\n"); 
		query.append("AND      XX.SKD_DIR_CD       = @[skd_dir_cd]" ).append("\n"); 
		query.append("AND      XX.VPS_PORT_CD      = @[vps_port_cd]" ).append("\n"); 
		query.append("AND      XX.CLPT_IND_SEQ     = @[clpt_ind_seq]" ).append("\n"); 
		query.append("AND      (TO_DATE(@[vps_eta_dt], 'YYYYMMDDHH24:MI') - XX.PRE_ETD_DT <= 0 " ).append("\n"); 
		query.append("          OR " ).append("\n"); 
		query.append("		  XX.NXT_ETA_DT - TO_DATE(@[vps_etd_dt], 'YYYYMMDDHH24:MI') <= 0" ).append("\n"); 
		query.append("          )" ).append("\n"); 

	}
}