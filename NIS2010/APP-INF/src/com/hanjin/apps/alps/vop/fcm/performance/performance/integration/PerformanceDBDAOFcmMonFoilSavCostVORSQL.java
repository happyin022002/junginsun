/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : PerformanceDBDAOFcmMonFoilSavCostVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.07.18
*@LastModifier : 이혜민
*@LastVersion : 1.0
* 2012.07.18 이혜민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.fcm.performance.performance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Hyemin Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PerformanceDBDAOFcmMonFoilSavCostVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Monthly Fuel Oil Saving Cost 정보를 조회한다.
	  * 
	  * History
	  * 2012.04.04 진마리아 CHM-201216636-01 [FCM] ALPS 모델 및 DB 구조 불일치 복구
	  * 2012.07.18 이혜민    CHM-201219005-01 [FCM] fuel_adt 컬럼명 fuel_adtv 로 수정
	  * </pre>
	  */
	public PerformanceDBDAOFcmMonFoilSavCostVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sav_itm_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_yrmon",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.hanjin.apps.alps.vop.fcm.performance.performance.integration").append("\n"); 
		query.append("FileName : PerformanceDBDAOFcmMonFoilSavCostVORSQL").append("\n"); 
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
		query.append("SAV_ITM_CD," ).append("\n"); 
		query.append("SAV_COST_CRE_YRMON," ).append("\n"); 
		query.append("VSL_CD," ).append("\n"); 
		query.append("SKD_VOY_NO," ).append("\n"); 
		query.append("SKD_DIR_CD," ).append("\n"); 
		query.append("VSL_CD||SKD_VOY_NO||SKD_DIR_CD VVD," ).append("\n"); 
		query.append("VPS_PORT_CD," ).append("\n"); 
		query.append("VSL_CLSS_CD," ).append("\n"); 
		query.append("VSL_CLSS_SUB_CD," ).append("\n"); 
		query.append("VSL_SLAN_CD," ).append("\n"); 
		query.append("NVGT_DIST," ).append("\n"); 
		query.append("AVG_SPD," ).append("\n"); 
		query.append("AVG_RPM_PWR," ).append("\n"); 
		query.append("LOD_IND_QTY," ).append("\n"); 
		query.append("FOIL_CSM_WGT," ).append("\n"); 
		query.append("FOIL_CSM_COST_AMT," ).append("\n"); 
		query.append("SAV_RTO," ).append("\n"); 
		query.append("SAV_QTY," ).append("\n"); 
		query.append("SAV_COST_AMT," ).append("\n"); 
		query.append("PORT_PAIR_SEA_FOIL_CSM_WGT," ).append("\n"); 
		query.append("FUEL_ADTV_CSM_WGT," ).append("\n"); 
		query.append("FUEL_ADTV_UC_AMT," ).append("\n"); 
		query.append("FUEL_ADTV_CSM_COST_AMT," ).append("\n"); 
		query.append("FUEL_ADTV_DEP_CSM_COST_AMT," ).append("\n"); 
		query.append("FUEL_ADTV_SAV_COST_AMT," ).append("\n"); 
		query.append("CRE_USR_ID," ).append("\n"); 
		query.append("CRE_DT," ).append("\n"); 
		query.append("UPD_USR_ID," ).append("\n"); 
		query.append("UPD_DT," ).append("\n"); 
		query.append("(SELECT CLPT_SEQ FROM VSK_VSL_PORT_SKD WHERE VSL_CD=T1.VSL_CD AND SKD_VOY_NO=T1.SKD_VOY_NO AND SKD_DIR_CD=T1.SKD_DIR_CD AND VPS_PORT_CD=T1.VPS_PORT_CD AND CLPT_IND_SEQ=T1.CLPT_IND_SEQ) CLPT_SEQ" ).append("\n"); 
		query.append("FROM FCM_MON_FUEL_OIL_SAV_COST T1" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND SAV_ITM_CD=@[sav_itm_cd]" ).append("\n"); 
		query.append("AND SAV_COST_CRE_YRMON BETWEEN @[fm_yrmon] AND @[to_yrmon]" ).append("\n"); 
		query.append("#if (${vsl_slan_cd} != '')" ).append("\n"); 
		query.append("AND VSL_SLAN_CD=@[vsl_slan_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vsl_cd} != '')" ).append("\n"); 
		query.append("AND VSL_CD=@[vsl_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY VSL_CLSS_CD, VSL_CD, SKD_VOY_NO, SKD_DIR_CD, CLPT_SEQ" ).append("\n"); 

	}
}