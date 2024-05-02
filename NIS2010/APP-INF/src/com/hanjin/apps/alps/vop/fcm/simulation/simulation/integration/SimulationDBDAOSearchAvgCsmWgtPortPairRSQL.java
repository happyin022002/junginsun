/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : SimulationDBDAOSearchAvgCsmWgtPortPairRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.01.26
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2012.01.26 진마리아
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.fcm.simulation.simulation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Maria Chin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SimulationDBDAOSearchAvgCsmWgtPortPairRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Search Average Consumption Weight between port pairs using FCM Departure Report.
	  * =================================================================================
	  * </pre>
	  */
	public SimulationDBDAOSearchAvgCsmWgtPortPairRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dep_port_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("nxt_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.fcm.simulation.simulation.integration").append("\n"); 
		query.append("FileName : SimulationDBDAOSearchAvgCsmWgtPortPairRSQL").append("\n"); 
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
		query.append("SELECT NVL(SUM((NVL(DEP_FOIL_WGT,0)+NVL(DEP_LOW_SULP_FOIL_WGT,0))-(NVL(NXT_ARR_FOIL_WGT,0)+NVL(NXT_ARR_LOW_SULP_FOIL_WGT,0)))/COUNT(*), 0) AVG_CSM_WGT" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT ROW_NUMBER() OVER(ORDER BY NXT_PORT_ETA_DT) SEQ" ).append("\n"); 
		query.append("         , T1.VSL_CD" ).append("\n"); 
		query.append("         , T1.SKD_VOY_NO" ).append("\n"); 
		query.append("         , T1.SKD_DIR_CD" ).append("\n"); 
		query.append("         , T1.DEP_PORT_CD" ).append("\n"); 
		query.append("         , T1.NXT_PORT_CD" ).append("\n"); 
		query.append("         , T1.NXT_PORT_ETA_DT" ).append("\n"); 
		query.append("         , T1.DEP_FOIL_WGT" ).append("\n"); 
		query.append("         , T1.DEP_LOW_SULP_FOIL_WGT" ).append("\n"); 
		query.append("         , (SELECT ARR_FOIL_WGT" ).append("\n"); 
		query.append("            FROM   FCM_DEP_RPT" ).append("\n"); 
		query.append("            WHERE  1=1" ).append("\n"); 
		query.append("            AND    T1.VSL_CD=VSL_CD" ).append("\n"); 
		query.append("            AND    T1.SKD_VOY_NO=SKD_VOY_NO" ).append("\n"); 
		query.append("            AND    T1.SKD_DIR_CD=SKD_DIR_CD" ).append("\n"); 
		query.append("            AND    T1.NXT_PORT_CD=DEP_PORT_CD" ).append("\n"); 
		query.append("            AND    T1.NXT_PORT_ETA_DT<NXT_PORT_ETA_DT" ).append("\n"); 
		query.append("            AND    ROWNUM=1) NXT_ARR_FOIL_WGT" ).append("\n"); 
		query.append("         , (SELECT ARR_LOW_SULP_FOIL_WGT" ).append("\n"); 
		query.append("            FROM   FCM_DEP_RPT" ).append("\n"); 
		query.append("            WHERE  1=1" ).append("\n"); 
		query.append("            AND    T1.VSL_CD=VSL_CD" ).append("\n"); 
		query.append("            AND    T1.SKD_VOY_NO=SKD_VOY_NO" ).append("\n"); 
		query.append("            AND    T1.SKD_DIR_CD=SKD_DIR_CD" ).append("\n"); 
		query.append("            AND    T1.NXT_PORT_CD=DEP_PORT_CD" ).append("\n"); 
		query.append("            AND    T1.NXT_PORT_ETA_DT<NXT_PORT_ETA_DT" ).append("\n"); 
		query.append("            AND    ROWNUM=1) NXT_ARR_LOW_SULP_FOIL_WGT" ).append("\n"); 
		query.append("    FROM   FCM_DEP_RPT T1" ).append("\n"); 
		query.append("    WHERE  1=1" ).append("\n"); 
		query.append("    AND    VSL_CD=@[vsl_cd]" ).append("\n"); 
		query.append("    AND    DEP_PORT_CD=@[dep_port_cd]" ).append("\n"); 
		query.append("    AND    NXT_PORT_CD=@[nxt_port_cd]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE SEQ<=3" ).append("\n"); 

	}
}