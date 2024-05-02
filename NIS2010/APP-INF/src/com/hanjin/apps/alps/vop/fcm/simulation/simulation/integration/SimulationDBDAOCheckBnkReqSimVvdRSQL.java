/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : SimulationDBDAOCheckBnkReqSimVvdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.01.06
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2012.01.06 진마리아
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

public class SimulationDBDAOCheckBnkReqSimVvdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Bunker Request Simulation에 필요한 VVD 정보를 체크한다.
	  * </pre>
	  */
	public SimulationDBDAOCheckBnkReqSimVvdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.fcm.simulation.simulation.integration").append("\n"); 
		query.append("FileName : SimulationDBDAOCheckBnkReqSimVvdRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("CASE WHEN SUM(PORT_CNT)=SUM(RPT_CNT) THEN 0" ).append("\n"); 
		query.append("     WHEN SUM(RPT_CNT)=0 THEN 1" ).append("\n"); 
		query.append("     WHEN SUM(RPT_CNT) IS NULL THEN -1" ).append("\n"); 
		query.append("     ELSE 2 END CHECK_VVD" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("T1.*" ).append("\n"); 
		query.append(",(SELECT COUNT(*) FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("  WHERE 1=1" ).append("\n"); 
		query.append("  AND T1.VSL_CD=VSL_CD" ).append("\n"); 
		query.append("  AND T1.SKD_VOY_NO=SKD_VOY_NO" ).append("\n"); 
		query.append("  AND T1.SKD_DIR_CD=SKD_DIR_CD" ).append("\n"); 
		query.append("  AND TURN_PORT_IND_CD IN ('Y', 'N')" ).append("\n"); 
		query.append("  AND NVL(SKD_CNG_STS_CD, 'X') <> 'S') PORT_CNT" ).append("\n"); 
		query.append(",(SELECT COUNT(*) FROM FCM_DEP_RPT" ).append("\n"); 
		query.append("  WHERE 1=1" ).append("\n"); 
		query.append("  AND T1.VSL_CD=VSL_CD" ).append("\n"); 
		query.append("  AND T1.SKD_VOY_NO=SKD_VOY_NO" ).append("\n"); 
		query.append("  AND T1.SKD_DIR_CD=SKD_DIR_CD) RPT_CNT" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT DISTINCT VSL_CD, SKD_VOY_NO, SKD_DIR_CD FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("    AND VSL_CD=@[vsl_cd] AND TURN_SKD_VOY_NO=@[skd_voy_no] AND TURN_SKD_DIR_CD=@[skd_dir_cd]" ).append("\n"); 
		query.append("    AND TURN_PORT_IND_CD IN ('D', 'V', 'F')" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    SELECT VSL_CD, SKD_VOY_NO, SKD_DIR_CD FROM VSK_VSL_SKD" ).append("\n"); 
		query.append("    WHERE VSL_CD=@[vsl_cd] AND SKD_VOY_NO=@[skd_voy_no] AND SKD_DIR_CD=@[skd_dir_cd]" ).append("\n"); 
		query.append("--    UNION ALL" ).append("\n"); 
		query.append("--    SELECT DISTINCT VSL_CD, TURN_SKD_VOY_NO, TURN_SKD_DIR_CD FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("--    WHERE 1=1" ).append("\n"); 
		query.append("--    AND VSL_CD='HJAA' AND SKD_VOY_NO='0010' AND SKD_DIR_CD='W'" ).append("\n"); 
		query.append("--    AND TURN_PORT_IND_CD IN ('D', 'V', 'F')" ).append("\n"); 
		query.append(")T1" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}