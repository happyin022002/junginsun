/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : PerformanceDBDAOFcmMonFoilSavCostVOCSQL.java
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

public class PerformanceDBDAOFcmMonFoilSavCostVOCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Monthly Fuel Oil Saving Cost 정보를 생성한다.
	  * 
	  * History
	  * 2012.04.04 진마리아 CHM-201216636-01 [FCM] ALPS 모델 및 DB 구조 불일치 복구
	  * 2012.07.18 이혜민    CHM-201219005-01 [FCM] fuel_adt 컬럼명 fuel_adtv 로 수정
	  * </pre>
	  */
	public PerformanceDBDAOFcmMonFoilSavCostVOCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sav_cost_cre_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fuel_adtv_csm_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("avg_rpm_pwr",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("fuel_adtv_uc_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sav_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("lod_ind_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("nvgt_dist",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("foil_csm_cost_amt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vsl_clss_sub_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fuel_adtv_dep_csm_cost_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_pair_sea_foil_csm_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("avg_spd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fuel_adtv_csm_cost_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sav_cost_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fuel_adtv_sav_cost_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("foil_csm_wgt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sav_rto",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.fcm.performance.performance.integration").append("\n"); 
		query.append("FileName : PerformanceDBDAOFcmMonFoilSavCostVOCSQL").append("\n"); 
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
		query.append("/* Monthly Fuel Oil Saving Cost 정보를 생성한다. */" ).append("\n"); 
		query.append("INSERT INTO FCM_MON_FUEL_OIL_SAV_COST (" ).append("\n"); 
		query.append("SAV_ITM_CD," ).append("\n"); 
		query.append("SAV_COST_CRE_YRMON," ).append("\n"); 
		query.append("VSL_CD," ).append("\n"); 
		query.append("SKD_VOY_NO," ).append("\n"); 
		query.append("SKD_DIR_CD," ).append("\n"); 
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
		query.append("CLPT_IND_SEQ" ).append("\n"); 
		query.append(") VALUES(" ).append("\n"); 
		query.append("@[sav_itm_cd]," ).append("\n"); 
		query.append("@[sav_cost_cre_yrmon]," ).append("\n"); 
		query.append("@[vsl_cd]," ).append("\n"); 
		query.append("@[skd_voy_no]," ).append("\n"); 
		query.append("@[skd_dir_cd]," ).append("\n"); 
		query.append("@[vps_port_cd]," ).append("\n"); 
		query.append("@[vsl_clss_cd]," ).append("\n"); 
		query.append("@[vsl_clss_sub_cd]," ).append("\n"); 
		query.append("@[vsl_slan_cd]," ).append("\n"); 
		query.append("@[nvgt_dist]," ).append("\n"); 
		query.append("@[avg_spd]," ).append("\n"); 
		query.append("@[avg_rpm_pwr]," ).append("\n"); 
		query.append("@[lod_ind_qty]," ).append("\n"); 
		query.append("@[foil_csm_wgt]," ).append("\n"); 
		query.append("@[foil_csm_cost_amt]," ).append("\n"); 
		query.append("@[sav_rto]," ).append("\n"); 
		query.append("@[sav_qty]," ).append("\n"); 
		query.append("@[sav_cost_amt]," ).append("\n"); 
		query.append("@[port_pair_sea_foil_csm_wgt]," ).append("\n"); 
		query.append("@[fuel_adtv_csm_wgt]," ).append("\n"); 
		query.append("@[fuel_adtv_uc_amt]," ).append("\n"); 
		query.append("@[fuel_adtv_csm_cost_amt]," ).append("\n"); 
		query.append("@[fuel_adtv_dep_csm_cost_amt]," ).append("\n"); 
		query.append("@[fuel_adtv_sav_cost_amt]," ).append("\n"); 
		query.append("@[cre_usr_id]," ).append("\n"); 
		query.append("SYSDATE," ).append("\n"); 
		query.append("@[cre_usr_id]," ).append("\n"); 
		query.append("SYSDATE," ).append("\n"); 
		query.append("@[clpt_ind_seq]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}