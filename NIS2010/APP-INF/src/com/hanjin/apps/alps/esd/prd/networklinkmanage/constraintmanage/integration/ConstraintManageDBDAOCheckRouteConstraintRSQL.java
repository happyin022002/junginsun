/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ConstraintManageDBDAOCheckRouteConstraintRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.05.10
*@LastModifier : 
*@LastVersion : 1.0
* 2013.05.10 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.prd.networklinkmanage.constraintmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ConstraintManageDBDAOCheckRouteConstraintRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CheckRouteConstraint
	  * </pre>
	  */
	public ConstraintManageDBDAOCheckRouteConstraintRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n2nd_ts_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trnk_lane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n1st_lane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n1st_ts_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3rd_lane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n2nd_lane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.prd.networklinkmanage.constraintmanage.integration").append("\n"); 
		query.append("FileName : ConstraintManageDBDAOCheckRouteConstraintRSQL").append("\n"); 
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
		query.append("SELECT CHK_FIELD " ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT CHK_FIELD, PRIORITY" ).append("\n"); 
		query.append("      FROM (" ).append("\n"); 
		query.append("        SELECT" ).append("\n"); 
		query.append("          CASE" ).append("\n"); 
		query.append("            WHEN LENGTH(@[trnk_lane_cd]) = 3" ).append("\n"); 
		query.append("            AND @[trnk_lane_cd] <> 'ALL' THEN NVL((" ).append("\n"); 
		query.append("                SELECT 'Y'" ).append("\n"); 
		query.append("                FROM MDM_VSL_SVC_LANE" ).append("\n"); 
		query.append("                WHERE VSL_SLAN_CD = @[trnk_lane_cd]" ).append("\n"); 
		query.append("                  AND NVL( DELT_FLG, 'N') <> 'Y'), 's_trnk_lane_cd')" ).append("\n"); 
		query.append("            WHEN @[trnk_lane_cd] = 'ALL' THEN 'Y' ---> CRUD가 S 이면" ).append("\n"); 
		query.append("            ELSE 's_trnk_lane_cd'" ).append("\n"); 
		query.append("          END CHK_FIELD," ).append("\n"); 
		query.append("    	  1 AS PRIORITY" ).append("\n"); 
		query.append("        FROM DUAL" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        UNION" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        SELECT" ).append("\n"); 
		query.append("          CASE" ).append("\n"); 
		query.append("            WHEN LENGTH(@[pol_cd]) = 5 THEN NVL((" ).append("\n"); 
		query.append("                SELECT 'Y'" ).append("\n"); 
		query.append("                FROM MDM_LOCATION P" ).append("\n"); 
		query.append("                WHERE P.LOC_CD = @[pol_cd]" ).append("\n"); 
		query.append("                  AND P.CALL_PORT_FLG = 'Y'" ).append("\n"); 
		query.append("                  AND NVL( DELT_FLG, 'N') <> 'Y'), 's_pol_cd')" ).append("\n"); 
		query.append("            WHEN @[pol_cd] = 'ALL' THEN 'Y'" ).append("\n"); 
		query.append("            WHEN LENGTH(@[pol_cd]) =2 THEN NVL((" ).append("\n"); 
		query.append("                 SELECT 'Y' " ).append("\n"); 
		query.append("                   FROM MDM_COUNTRY " ).append("\n"); 
		query.append("                  WHERE CNT_CD= @[pol_cd]" ).append("\n"); 
		query.append("                    AND NVL( DELT_FLG, 'N') <> 'Y'),'s_pol_cd')" ).append("\n"); 
		query.append("            ELSE 's_pol_cd'" ).append("\n"); 
		query.append("          END," ).append("\n"); 
		query.append("          2 AS PRIORITY" ).append("\n"); 
		query.append("        FROM DUAL" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        UNION" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        SELECT" ).append("\n"); 
		query.append("          CASE" ).append("\n"); 
		query.append("            WHEN LENGTH(@[pol_cd]||@[pol_nod_cd]) = 7 THEN NVL((" ).append("\n"); 
		query.append("                SELECT 'Y'" ).append("\n"); 
		query.append("                FROM PRD_NODE N" ).append("\n"); 
		query.append("                WHERE N.NOD_CD = @[pol_cd]||@[pol_nod_cd]" ).append("\n"); 
		query.append("                  AND NVL( DELT_FLG, 'N') <> 'Y'), 's_pol_nod_cd')" ).append("\n"); 
		query.append("            WHEN (@[pol_nod_cd] IS NULL OR LENGTH(@[pol_nod_cd]) = 0) THEN 'Y'" ).append("\n"); 
		query.append("            ELSE 's_pol_nod_cd'" ).append("\n"); 
		query.append("          END," ).append("\n"); 
		query.append("          3 AS PRIORITY" ).append("\n"); 
		query.append("        FROM DUAL " ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        UNION" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        SELECT" ).append("\n"); 
		query.append("          CASE" ).append("\n"); 
		query.append("            WHEN LENGTH(@[n1st_lane_cd]) = 3 THEN NVL((" ).append("\n"); 
		query.append("                SELECT 'Y'" ).append("\n"); 
		query.append("                FROM MDM_VSL_SVC_LANE" ).append("\n"); 
		query.append("                WHERE VSL_SLAN_CD = @[n1st_lane_cd]" ).append("\n"); 
		query.append("                  AND NVL( DELT_FLG, 'N') <> 'Y'), 's_n1st_lane_cd')" ).append("\n"); 
		query.append("            WHEN @[n1st_lane_cd] IS NULL THEN 'Y'" ).append("\n"); 
		query.append("            ELSE 's_n1st_lane_cd'" ).append("\n"); 
		query.append("          END," ).append("\n"); 
		query.append("          4 AS PRIORITY" ).append("\n"); 
		query.append("        FROM DUAL " ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        UNION" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        SELECT" ).append("\n"); 
		query.append("          CASE" ).append("\n"); 
		query.append("            WHEN LENGTH(@[n1st_ts_port_cd]) = 5 THEN NVL((" ).append("\n"); 
		query.append("                SELECT 'Y'" ).append("\n"); 
		query.append("                FROM MDM_LOCATION P" ).append("\n"); 
		query.append("                WHERE P.LOC_CD = @[n1st_ts_port_cd]" ).append("\n"); 
		query.append("                  AND P.CALL_PORT_FLG = 'Y'" ).append("\n"); 
		query.append("                  AND NVL( DELT_FLG, 'N') <> 'Y'), 's_n1st_ts_port_cd')" ).append("\n"); 
		query.append("            WHEN @[n1st_ts_port_cd] IS NULL THEN 'Y'" ).append("\n"); 
		query.append("            ELSE 's_n1st_ts_port_cd'" ).append("\n"); 
		query.append("          END," ).append("\n"); 
		query.append("          5 AS PRIORITY" ).append("\n"); 
		query.append("        FROM DUAL " ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        UNION" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        SELECT" ).append("\n"); 
		query.append("          CASE" ).append("\n"); 
		query.append("            WHEN LENGTH(@[n2nd_lane_cd]) = 3 THEN NVL((" ).append("\n"); 
		query.append("                SELECT 'Y'" ).append("\n"); 
		query.append("                FROM MDM_VSL_SVC_LANE" ).append("\n"); 
		query.append("                WHERE VSL_SLAN_CD = @[n2nd_lane_cd]" ).append("\n"); 
		query.append("                  AND NVL( DELT_FLG, 'N') <> 'Y'), 's_n2nd_lane_cd')" ).append("\n"); 
		query.append("            WHEN @[n2nd_lane_cd] IS NULL THEN 'Y'" ).append("\n"); 
		query.append("            ELSE 's_n2nd_lane_cd'" ).append("\n"); 
		query.append("          END," ).append("\n"); 
		query.append("          6 AS PRIORITY" ).append("\n"); 
		query.append("        FROM DUAL " ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        UNION" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        SELECT" ).append("\n"); 
		query.append("          CASE" ).append("\n"); 
		query.append("            WHEN LENGTH(@[n2nd_ts_port_cd]) = 5 THEN NVL((" ).append("\n"); 
		query.append("                SELECT 'Y'" ).append("\n"); 
		query.append("                FROM MDM_LOCATION P" ).append("\n"); 
		query.append("                WHERE P.LOC_CD = @[n2nd_ts_port_cd]" ).append("\n"); 
		query.append("                  AND P.CALL_PORT_FLG = 'Y'" ).append("\n"); 
		query.append("                  AND NVL( DELT_FLG, 'N') <> 'Y'), 's_n2nd_ts_port_cd')" ).append("\n"); 
		query.append("            WHEN @[n2nd_ts_port_cd] IS NULL THEN 'Y'" ).append("\n"); 
		query.append("            ELSE 's_n2nd_ts_port_cd'" ).append("\n"); 
		query.append("          END," ).append("\n"); 
		query.append("          7 AS PRIORITY" ).append("\n"); 
		query.append("        FROM DUAL " ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        UNION" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        SELECT" ).append("\n"); 
		query.append("          CASE" ).append("\n"); 
		query.append("            WHEN LENGTH(@[n3rd_lane_cd]) = 3 THEN NVL((" ).append("\n"); 
		query.append("                SELECT 'Y'" ).append("\n"); 
		query.append("                FROM MDM_VSL_SVC_LANE" ).append("\n"); 
		query.append("                WHERE VSL_SLAN_CD = @[n3rd_lane_cd]" ).append("\n"); 
		query.append("                  AND NVL( DELT_FLG, 'N') <> 'Y'), 's_n3rd_lane_cd')" ).append("\n"); 
		query.append("            WHEN @[n3rd_lane_cd] IS NULL THEN 'Y'" ).append("\n"); 
		query.append("            ELSE 's_n3rd_lane_cd'" ).append("\n"); 
		query.append("          END," ).append("\n"); 
		query.append("          8 AS PRIORITY" ).append("\n"); 
		query.append("        FROM DUAL " ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        UNION" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        SELECT" ).append("\n"); 
		query.append("          CASE" ).append("\n"); 
		query.append("            WHEN LENGTH(@[pod_cd]) = 5 THEN NVL((" ).append("\n"); 
		query.append("                SELECT 'Y'" ).append("\n"); 
		query.append("                FROM MDM_LOCATION P" ).append("\n"); 
		query.append("                WHERE P.LOC_CD = @[pod_cd]" ).append("\n"); 
		query.append("                  AND P.CALL_PORT_FLG = 'Y'" ).append("\n"); 
		query.append("                  AND NVL( DELT_FLG, 'N') <> 'Y'), 's_pod_cd')" ).append("\n"); 
		query.append("            WHEN LENGTH(@[pod_cd]) =2 THEN NVL((" ).append("\n"); 
		query.append("                 SELECT 'Y' " ).append("\n"); 
		query.append("                   FROM MDM_COUNTRY " ).append("\n"); 
		query.append("                  WHERE CNT_CD= @[pod_cd]" ).append("\n"); 
		query.append("                    AND NVL( DELT_FLG, 'N') <> 'Y'),'s_pod_cd')" ).append("\n"); 
		query.append("            WHEN @[pod_cd] = 'ALL' THEN 'Y'" ).append("\n"); 
		query.append("            ELSE 's_pod_cd'" ).append("\n"); 
		query.append("          END," ).append("\n"); 
		query.append("          9 AS PRIORITY" ).append("\n"); 
		query.append("        FROM DUAL " ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        UNION" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        SELECT" ).append("\n"); 
		query.append("          CASE" ).append("\n"); 
		query.append("            WHEN LENGTH(@[pod_cd]||@[pod_nod_cd]) = 7 THEN NVL((" ).append("\n"); 
		query.append("                SELECT 'Y'" ).append("\n"); 
		query.append("                FROM PRD_NODE N" ).append("\n"); 
		query.append("                WHERE N.NOD_CD = @[pod_cd]||@[pod_nod_cd]" ).append("\n"); 
		query.append("                  AND NVL( DELT_FLG, 'N') <> 'Y'), 's_pod_nod_cd')" ).append("\n"); 
		query.append("            WHEN (@[pod_nod_cd] IS NULL OR LENGTH(@[pod_nod_cd]) = 0) THEN 'Y'" ).append("\n"); 
		query.append("            ELSE 's_pod_nod_cd'" ).append("\n"); 
		query.append("          END," ).append("\n"); 
		query.append("          10 AS PRIORITY" ).append("\n"); 
		query.append("        FROM DUAL " ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        UNION" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        SELECT" ).append("\n"); 
		query.append("          CASE" ).append("\n"); 
		query.append("            WHEN LENGTH(@[del_cd]) = 5 THEN NVL((" ).append("\n"); 
		query.append("                SELECT 'Y'" ).append("\n"); 
		query.append("                FROM MDM_LOCATION P" ).append("\n"); 
		query.append("                WHERE P.LOC_CD = @[del_cd]" ).append("\n"); 
		query.append("                  --AND P.CALL_PORT_FLG = 'Y'" ).append("\n"); 
		query.append("                  AND NVL( DELT_FLG, 'N') <> 'Y'), 's_del_cd')" ).append("\n"); 
		query.append("            WHEN LENGTH(@[del_cd]) =2 THEN NVL((" ).append("\n"); 
		query.append("                 SELECT 'Y' " ).append("\n"); 
		query.append("                   FROM MDM_COUNTRY " ).append("\n"); 
		query.append("                  WHERE CNT_CD= @[del_cd]" ).append("\n"); 
		query.append("                    AND NVL( DELT_FLG, 'N') <> 'Y'),'s_del_cd')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("            WHEN (@[del_cd] IS NULL OR LENGTH(@[del_cd]) = 0) THEN 'Y'" ).append("\n"); 
		query.append("            ELSE 's_del_cd'" ).append("\n"); 
		query.append("          END," ).append("\n"); 
		query.append("          11 AS PRIORITY" ).append("\n"); 
		query.append("        FROM DUAL " ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        UNION" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        SELECT" ).append("\n"); 
		query.append("          CASE" ).append("\n"); 
		query.append("            WHEN LENGTH(@[del_cd]||@[del_nod_cd]) = 7 THEN NVL((" ).append("\n"); 
		query.append("                SELECT 'Y'" ).append("\n"); 
		query.append("                FROM PRD_NODE N" ).append("\n"); 
		query.append("                WHERE N.NOD_CD = @[del_cd]||@[del_nod_cd]" ).append("\n"); 
		query.append("                  AND NVL( DELT_FLG, 'N') <> 'Y'), 's_del_nod_cd')" ).append("\n"); 
		query.append("            WHEN (@[del_nod_cd] IS NULL OR LENGTH(@[del_nod_cd]) = 0) THEN 'Y'" ).append("\n"); 
		query.append("            ELSE 's_del_nod_cd'" ).append("\n"); 
		query.append("          END," ).append("\n"); 
		query.append("          12 AS PRIORITY" ).append("\n"); 
		query.append("        FROM DUAL" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("    WHERE CHK_FIELD <> 'Y'" ).append("\n"); 
		query.append("    ORDER BY PRIORITY" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}