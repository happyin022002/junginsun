/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : FACCommCalculationDBDAOSearchSADateOfSURSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.09.16
*@LastModifier : 
*@LastVersion : 1.0
* 2015.09.16 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmcalculation.faccommcalculation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class FACCommCalculationDBDAOSearchSADateOfSURSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * FACCommCalculationDBDAOSearchSADateOfSURSQL
	  * </pre>
	  */
	public FACCommCalculationDBDAOSearchSADateOfSURSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_pre_pst_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_pod_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vsl_pol_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.clt.apps.opus.esm.acm.acmcalculation.faccommcalculation.integration").append("\n"); 
		query.append("FileName : FACCommCalculationDBDAOSearchSADateOfSURSQL").append("\n"); 
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
		query.append("MAX(T.VSL_PRE_PST_CD) AS VSL_PRE_PST_CD" ).append("\n"); 
		query.append(", MAX(T.VPS_ETD_DT) AS VPS_ETD_DT" ).append("\n"); 
		query.append(", MAX(T.VPS_ETA_DT) AS VPS_ETA_DT" ).append("\n"); 
		query.append(", MAX(T.SINWA_TS_SA_DT) AS SINWA_TS_SA_DT" ).append("\n"); 
		query.append("FROM (SELECT " ).append("\n"); 
		query.append("	@[vsl_pre_pst_cd] VSL_PRE_PST_CD, " ).append("\n"); 
		query.append("	DECODE(@[vsl_pre_pst_cd], 'S', TO_CHAR(T1.VPS_ETD_DT,'YYYYMMDDHH24MISS'), '' ) AS VPS_ETD_DT," ).append("\n"); 
		query.append("    DECODE(@[vsl_pre_pst_cd], 'S', '', TO_CHAR(T1.VPS_ETA_DT,'YYYYMMDDHH24MISS') ) AS VPS_ETA_DT," ).append("\n"); 
		query.append("    '' AS SINWA_TS_SA_DT" ).append("\n"); 
		query.append("FROM VSK_VSL_PORT_SKD T1, " ).append("\n"); 
		query.append("	(SELECT MIN(CLPT_IND_SEQ) CAL_IND " ).append("\n"); 
		query.append("      FROM VSK_VSL_PORT_SKD " ).append("\n"); 
		query.append("     WHERE VSL_CD = @[vsl_cd] " ).append("\n"); 
		query.append("	     AND SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("	     AND SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("	     AND VPS_PORT_CD = DECODE(@[vsl_pre_pst_cd], 'S', @[vsl_pol_cd], @[vsl_pod_cd]) " ).append("\n"); 
		query.append("	     AND NVL(SKD_CNG_STS_CD,'*') <> 'S' " ).append("\n"); 
		query.append("	     AND VT_ADD_CALL_FLG IS NULL" ).append("\n"); 
		query.append("    ) T3 " ).append("\n"); 
		query.append("WHERE T1.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("	AND T1.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("	AND T1.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("	AND T1.VPS_PORT_CD = DECODE(@[vsl_pre_pst_cd], 'S', @[vsl_pol_cd], @[vsl_pod_cd])   " ).append("\n"); 
		query.append("	AND T1.CLPT_IND_SEQ = T3.CAL_IND " ).append("\n"); 
		query.append("	AND NVL(T1.SKD_CNG_STS_CD,' ') <> 'S' " ).append("\n"); 
		query.append("	AND T1.VT_ADD_CALL_FLG IS NULL" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("	@[vsl_pre_pst_cd] VSL_PRE_PST_CD," ).append("\n"); 
		query.append("    '' AS VPS_ETD_DT," ).append("\n"); 
		query.append("    '' AS VPS_ETA_DT," ).append("\n"); 
		query.append("	TO_CHAR(T1.VPS_ETD_DT,'YYYYMMDDHH24MISS') SINWA_TS_SA_DT" ).append("\n"); 
		query.append("FROM VSK_VSL_PORT_SKD T1," ).append("\n"); 
		query.append("	(SELECT MIN(CLPT_IND_SEQ) CAL_IND" ).append("\n"); 
		query.append("      FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("     WHERE VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("	     AND SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("	     AND SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("	     AND VPS_PORT_CD = @[vsl_pol_cd]" ).append("\n"); 
		query.append("	     AND NVL(SKD_CNG_STS_CD,'*') <> 'S'" ).append("\n"); 
		query.append("	     AND VT_ADD_CALL_FLG IS NULL" ).append("\n"); 
		query.append("    ) T3" ).append("\n"); 
		query.append("WHERE T1.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("	AND T1.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("	AND T1.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("	AND T1.VPS_PORT_CD = @[vsl_pol_cd]" ).append("\n"); 
		query.append("	AND T1.CLPT_IND_SEQ = T3.CAL_IND" ).append("\n"); 
		query.append("	AND NVL(T1.SKD_CNG_STS_CD,' ') <> 'S'" ).append("\n"); 
		query.append("	AND T1.VT_ADD_CALL_FLG IS NULL" ).append("\n"); 
		query.append(") T" ).append("\n"); 

	}
}