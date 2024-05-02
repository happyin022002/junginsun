/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : VesselPassagePlanManagementDBDAOCreatePassagePlanDtRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.28
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.28 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.externalvesselinfomanagement.vesselpassageplanmanagement.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VesselPassagePlanManagementDBDAOCreatePassagePlanDtRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VSM에서 EAI로 I/F받은 Passage Plan 데이터를 Insert.
	  * </pre>
	  */
	public VesselPassagePlanManagementDBDAOCreatePassagePlanDtRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ttl_mlg_dist",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_to_port_mlg_dist",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dep_pln_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pasg_pln_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pasg_pln_tit_nm",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("plt_stn_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_apro_doc_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("arr_dep_plc_diff_hrs",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("avg_vsl_spd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("self_shp_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("arr_pln_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("arr_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.vsk.externalvesselinfomanagement.vesselpassageplanmanagement.integration").append("\n"); 
		query.append("FileName : VesselPassagePlanManagementDBDAOCreatePassagePlanDtRSQL").append("\n"); 
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
		query.append("--SELECT " ).append("\n"); 
		query.append("--     '' AS VSL_CD" ).append("\n"); 
		query.append("--    ,'' AS SKD_VOY_NO" ).append("\n"); 
		query.append("--    ,'' AS PASG_PLN_DT" ).append("\n"); 
		query.append("--    ,'' AS DEP_PORT_CD" ).append("\n"); 
		query.append("--    ,'' AS ARR_PORT_CD" ).append("\n"); 
		query.append("--    ,'' AS PASG_PLN_TIT_NM" ).append("\n"); 
		query.append("--    ,'' AS VSL_SLAN_CD" ).append("\n"); 
		query.append("--    ,'' AS AVG_VSL_SPD" ).append("\n"); 
		query.append("--    ,'' AS DEP_PLN_DT" ).append("\n"); 
		query.append("--    ,'' AS ARR_PLN_DT" ).append("\n"); 
		query.append("--    ,'' AS ARR_DEP_PLC_DIFF_HRS" ).append("\n"); 
		query.append("--    ,'' AS VSL_APRO_DOC_NO" ).append("\n"); 
		query.append("--    ,'' AS TTL_MLG_DIST" ).append("\n"); 
		query.append("--    ,'' AS PORT_TO_PORT_MLG_DIST" ).append("\n"); 
		query.append("--    ,'' AS SELF_SHP_FLG" ).append("\n"); 
		query.append("--    ,'' AS CRE_USR_ID" ).append("\n"); 
		query.append("--    ,'' AS CRE_DT" ).append("\n"); 
		query.append("--    ,'' AS UPD_USR_ID" ).append("\n"); 
		query.append("--    ,'' AS UPD_DT" ).append("\n"); 
		query.append("--    ,'' AS SKD_DIR_CD" ).append("\n"); 
		query.append("--    ,'' AS PLT_STN_DESC" ).append("\n"); 
		query.append("--FROM DUAL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("INSERT INTO VSK_PASG_PLN_RPT(" ).append("\n"); 
		query.append("          VSL_CD" ).append("\n"); 
		query.append("        , SKD_VOY_NO" ).append("\n"); 
		query.append("        , SKD_DIR_CD" ).append("\n"); 
		query.append("        , PASG_PLN_DT" ).append("\n"); 
		query.append("        , DEP_PORT_CD" ).append("\n"); 
		query.append("        , ARR_PORT_CD" ).append("\n"); 
		query.append("        , PASG_PLN_TIT_NM" ).append("\n"); 
		query.append("        , VSL_SLAN_CD" ).append("\n"); 
		query.append("        , PLT_STN_DESC" ).append("\n"); 
		query.append("        , AVG_VSL_SPD" ).append("\n"); 
		query.append("        , DEP_PLN_DT" ).append("\n"); 
		query.append("        , ARR_PLN_DT" ).append("\n"); 
		query.append("        , ARR_DEP_PLC_DIFF_HRS" ).append("\n"); 
		query.append("        , VSL_APRO_DOC_NO" ).append("\n"); 
		query.append("        , TTL_MLG_DIST" ).append("\n"); 
		query.append("        , PORT_TO_PORT_MLG_DIST" ).append("\n"); 
		query.append("        , SELF_SHP_FLG" ).append("\n"); 
		query.append("        , CRE_USR_ID" ).append("\n"); 
		query.append("        , CRE_DT" ).append("\n"); 
		query.append("        , UPD_USR_ID" ).append("\n"); 
		query.append("        , UPD_DT" ).append("\n"); 
		query.append("      )" ).append("\n"); 
		query.append("VALUES(" ).append("\n"); 
		query.append("          @[vsl_cd]" ).append("\n"); 
		query.append("        , @[skd_voy_no]" ).append("\n"); 
		query.append("        , @[skd_dir_cd]" ).append("\n"); 
		query.append("        , TO_DATE(@[pasg_pln_dt], 'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append("        , @[dep_port_cd]" ).append("\n"); 
		query.append("        , @[arr_port_cd] " ).append("\n"); 
		query.append("        , @[pasg_pln_tit_nm]" ).append("\n"); 
		query.append("        , @[vsl_slan_cd]" ).append("\n"); 
		query.append("        , @[plt_stn_desc]" ).append("\n"); 
		query.append("        , @[avg_vsl_spd]" ).append("\n"); 
		query.append("        , TO_DATE(@[dep_pln_dt], 'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append("        , TO_DATE(@[arr_pln_dt], 'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append("        , @[arr_dep_plc_diff_hrs]" ).append("\n"); 
		query.append("        , @[vsl_apro_doc_no]" ).append("\n"); 
		query.append("        , @[ttl_mlg_dist]" ).append("\n"); 
		query.append("        , @[port_to_port_mlg_dist]" ).append("\n"); 
		query.append("        , @[self_shp_flg]" ).append("\n"); 
		query.append("        , 'EAIUSER_VSK'" ).append("\n"); 
		query.append("        , SYSDATE" ).append("\n"); 
		query.append("        , 'EAIUSER_VSK'" ).append("\n"); 
		query.append("        , SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}