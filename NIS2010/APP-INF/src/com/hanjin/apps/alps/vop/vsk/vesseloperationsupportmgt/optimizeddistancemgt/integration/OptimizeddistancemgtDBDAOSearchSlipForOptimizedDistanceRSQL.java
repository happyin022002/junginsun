/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : OptimizeddistancemgtDBDAOSearchSlipForOptimizedDistanceRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.03.06
*@LastModifier : 
*@LastVersion : 1.0
* 2014.03.06 
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

public class OptimizeddistancemgtDBDAOSearchSlipForOptimizedDistanceRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Optimized Distance를 저장하기 위해 Slip관련 계산된 데이터를 조회한다.
	  * </pre>
	  */
	public OptimizeddistancemgtDBDAOSearchSlipForOptimizedDistanceRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("sheet_to_port_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("fm_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.optimizeddistancemgt.integration").append("\n"); 
		query.append("FileName : OptimizeddistancemgtDBDAOSearchSlipForOptimizedDistanceRSQL").append("\n"); 
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
		query.append("SELECT  XX.FM_PORT_CD" ).append("\n"); 
		query.append("      , XX.TO_PORT_CD" ).append("\n"); 
		query.append("      , ROUND(AVG(XX.SLP_RT),2)         AS AVG_SLP_RT" ).append("\n"); 
		query.append("      , COUNT(1)                        AS SLP_KNT" ).append("\n"); 
		query.append("      , MAX(XX.SLP_RT) - MIN(XX.SLP_RT) AS VAR_SLP_RT" ).append("\n"); 
		query.append("  FROM  (" ).append("\n"); 
		query.append("            SELECT      X.FM_PORT_CD" ).append("\n"); 
		query.append("                    ,   X.VPS_PORT_CD AS TO_PORT_CD" ).append("\n"); 
		query.append("                    ,   R.SLP_RT" ).append("\n"); 
		query.append("            FROM        (SELECT    LAG(P.VPS_PORT_CD) OVER (PARTITION BY P.VSL_CD, P.SKD_VOY_NO, P.SKD_DIR_CD ORDER BY P.VPS_ETB_DT ASC) AS FM_PORT_CD" ).append("\n"); 
		query.append("                                ,  P.*" ).append("\n"); 
		query.append("                         FROM      VSK_VSL_PORT_SKD P" ).append("\n"); 
		query.append("                         ) X" ).append("\n"); 
		query.append("                    ,   FCM_NOON_RPT R" ).append("\n"); 
		query.append("            WHERE       1 = 1" ).append("\n"); 
		query.append("            AND         X.VSL_CD            = R.VSL_CD" ).append("\n"); 
		query.append("            AND         X.SKD_VOY_NO        = R.SKD_VOY_NO" ).append("\n"); 
		query.append("            AND         X.SKD_DIR_CD        = R.SKD_DIR_CD" ).append("\n"); 
		query.append("            AND         X.VPS_PORT_CD       = R.NXT_PORT_CD  " ).append("\n"); 
		query.append("            AND         R.NOON_RPT_DT       BETWEEN TO_DATE(@[fm_date],'YYYY-MM-DD') AND TO_DATE(@[to_date],'YYYY-MM-DD')+0.99999" ).append("\n"); 
		query.append("         ) XX" ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("  WHERE  1=1" ).append("\n"); 
		query.append("    AND  XX.FM_PORT_CD = @[fm_port_cd]" ).append("\n"); 
		query.append("    AND  XX.TO_PORT_CD = @[sheet_to_port_cd]" ).append("\n"); 
		query.append("  GROUP BY  XX.FM_PORT_CD" ).append("\n"); 
		query.append("          , XX.TO_PORT_CD" ).append("\n"); 

	}
}