/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : SimulationDBDAOLastDepPortRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.12.27
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2011.12.27 진마리아
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.fcm.simulation.simulation.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Maria Chin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SimulationDBDAOLastDepPortRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SimulationDBDAOLastDepPortRSQL
	  * </pre>
	  */
	public SimulationDBDAOLastDepPortRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.vop.fcm.simulation.simulation.integration ").append("\n"); 
		query.append("FileName : SimulationDBDAOLastDepPortRSQL").append("\n"); 
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
		query.append("VSL_CD, SKD_VOY_NO, SKD_DIR_CD, DEP_PORT_CD, CLPT_IND_SEQ" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("T2.VSL_CD, T2.SKD_VOY_NO, T2.SKD_DIR_CD, T2.DEP_PORT_CD, T2.CLPT_IND_SEQ," ).append("\n"); 
		query.append("ROW_NUMBER() OVER(ORDER BY NXT_PORT_ETA_DT DESC) SEQ" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT DISTINCT VSL_CD, SKD_VOY_NO, SKD_DIR_CD FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("    AND VSL_CD=@[vsl_cd] AND TURN_SKD_VOY_NO=@[skd_voy_no] AND TURN_SKD_DIR_CD=@[skd_dir_cd]" ).append("\n"); 
		query.append("    AND TURN_PORT_IND_CD IN ('D', 'V', 'F')" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    SELECT @[vsl_cd] VSL_CD, @[skd_voy_no] SKD_VOY_NO, @[skd_dir_cd] SKD_DIR_CD FROM DUAL" ).append("\n"); 
		query.append(")T1, FCM_DEP_RPT T2" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND T1.VSL_CD=T2.VSL_CD" ).append("\n"); 
		query.append("AND T1.SKD_VOY_NO=T2.SKD_VOY_NO" ).append("\n"); 
		query.append("AND T1.SKD_DIR_CD=T2.SKD_DIR_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE SEQ=1" ).append("\n"); 

	}
}