/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : SimulationDBDAOSearchTrndLineItmListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.12
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2012.04.12 진마리아
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

public class SimulationDBDAOSearchTrndLineItmListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 이미 선택된 조건들로 target 정보를 조회한다.
	  * </pre>
	  */
	public SimulationDBDAOSearchTrndLineItmListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_dzn_capa",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("trnd_line_fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trnd_line_to_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.hanjin.apps.alps.vop.fcm.simulation.simulation.integration").append("\n"); 
		query.append("FileName : SimulationDBDAOSearchTrndLineItmListRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("#if (${target} != 'cntr_dzn_capa')" ).append("\n"); 
		query.append("DISTINCT ${target}" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("DISTINCT M.CNTR_DZN_CAPA" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("FROM FCM_NOON_RPT T1" ).append("\n"); 
		query.append("#if (${target} == 'cntr_dzn_capa')" ).append("\n"); 
		query.append(", MDM_VSL_CNTR M" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if (${target} == 'cntr_dzn_capa')" ).append("\n"); 
		query.append("AND T1.VSL_CD=M.VSL_CD" ).append("\n"); 
		query.append("AND M.CNTR_DZN_CAPA IS NOT NULL" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND ${target} IS NOT NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${trnd_line_fm_dt} != '' && ${trnd_line_to_dt} != '') " ).append("\n"); 
		query.append("AND NOON_RPT_DT BETWEEN TO_DATE(@[trnd_line_fm_dt], 'YYYY-MM-DD') AND TO_DATE(@[trnd_line_to_dt], 'YYYY-MM-DD')+0.99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cntr_dzn_capa} != '' && ${cntr_dzn_capa}!='A')" ).append("\n"); 
		query.append("AND T1.VSL_CD IN (SELECT VSL_CD FROM MDM_VSL_CNTR WHERE CNTR_DZN_CAPA = @[cntr_dzn_capa])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vsl_cd} != '' && ${vsl_cd}!='A')" ).append("\n"); 
		query.append("AND T1.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vsl_slan_cd} != '' && ${vsl_slan_cd}!='A')" ).append("\n"); 
		query.append("AND T1.VSL_SLAN_CD = @[vsl_slan_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${skd_dir_cd} != '' && ${skd_dir_cd}!='A')" ).append("\n"); 
		query.append("AND T1.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND T1.VSL_CD IN (SELECT VSL_CD FROM FCM_VSL_CNTR_RGST WHERE VSL_CD = T1.VSL_CD AND NVL(TRND_LINE_USE_FLG,' ')<>'N')" ).append("\n"); 
		query.append("AND MN_FOIL_CSM_QTY != '0'" ).append("\n"); 
		query.append("AND MN_FOIL_CSM_QTY IS NOT NULL" ).append("\n"); 
		query.append("AND TO_CHAR(TO_NUMBER(SUBSTR(SAIL_HRMNT, 1, 2))+(TO_NUMBER(SUBSTR(SAIL_HRMNT, 3, 2))/60)) IN ('23','24','25')" ).append("\n"); 
		query.append("AND ((SLP_RT > -16) AND (SLP_RT < 25))--SLP_RT IS NOT NULL 조건 포함" ).append("\n"); 
		query.append("AND TO_NUMBER(NVL(WND_SCL_NO,0))<=7" ).append("\n"); 
		query.append("AND TO_NUMBER(NVL(SEA_STE_NO,0))<=7" ).append("\n"); 
		query.append("AND T1.ENG_ML_DIST <> '0'" ).append("\n"); 
		query.append("ORDER BY ${target}" ).append("\n"); 

	}
}