/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : SimulationDBDAOSearchTrndLineForFOCRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.03.20
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2012.03.20 진마리아
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

public class SimulationDBDAOSearchTrndLineForFOCRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 조건에 맞는 Trnd Line(1,3,6)을 조회한다.
	  * </pre>
	  */
	public SimulationDBDAOSearchTrndLineForFOCRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_clss_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_clss_sub_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vsl_slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.fcm.simulation.simulation.integration").append("\n"); 
		query.append("FileName : SimulationDBDAOSearchTrndLineForFOCRSQL").append("\n"); 
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
		query.append("SELECT TRND_LINE_TP_CD," ).append("\n"); 
		query.append("       TRND_LINE_CHT_TP_CD," ).append("\n"); 
		query.append("       TRND_LINE_FM_DT," ).append("\n"); 
		query.append("       TRND_LINE_TO_DT," ).append("\n"); 
		query.append("       VSL_CLSS_CD," ).append("\n"); 
		query.append("       VSL_CLSS_SUB_CD," ).append("\n"); 
		query.append("       VSL_SLAN_CD," ).append("\n"); 
		query.append("       VSL_CD," ).append("\n"); 
		query.append("       SKD_DIR_CD," ).append("\n"); 
		query.append("       TRND_LINE_TP_SUB_CD," ).append("\n"); 
		query.append("       N1ST_COEF_VAL," ).append("\n"); 
		query.append("       N2ND_COEF_VAL," ).append("\n"); 
		query.append("       TRND_LINE_CONS_VAL," ).append("\n"); 
		query.append("       OP_MAX_SPD," ).append("\n"); 
		query.append("       OP_MIN_SPD," ).append("\n"); 
		query.append("       UPD_DT," ).append("\n"); 
		query.append("       UPD_USR_ID," ).append("\n"); 
		query.append("       APLY_SLP_RT" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT * FROM FCM_TRND_LINE" ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("    #if (${vsl_clss_cd} != '')" ).append("\n"); 
		query.append("    AND VSL_CLSS_CD=@[vsl_clss_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${vsl_clss_sub_cd} != '')" ).append("\n"); 
		query.append("    AND VSL_CLSS_SUB_CD=@[vsl_clss_sub_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${vsl_slan_cd} != '')" ).append("\n"); 
		query.append("    AND VSL_SLAN_CD=DECODE(@[vsl_slan_cd],'ALL','A',@[vsl_slan_cd])" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${vsl_cd} != '')" ).append("\n"); 
		query.append("    AND VSL_CD=@[vsl_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${skd_dir_cd} != '')" ).append("\n"); 
		query.append("    AND SKD_DIR_CD=DECODE(@[skd_dir_cd],'ALL','A',@[skd_dir_cd])" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    AND TRND_LINE_CHT_TP_CD IN ('01', '03', '06')" ).append("\n"); 
		query.append("    AND TRND_LINE_USE_TP_CD='N'" ).append("\n"); 
		query.append("    ORDER BY UPD_DT DESC, TRND_LINE_TP_SUB_CD DESC" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE ROWNUM<=3" ).append("\n"); 
		query.append("ORDER BY TRND_LINE_CHT_TP_CD" ).append("\n"); 

	}
}