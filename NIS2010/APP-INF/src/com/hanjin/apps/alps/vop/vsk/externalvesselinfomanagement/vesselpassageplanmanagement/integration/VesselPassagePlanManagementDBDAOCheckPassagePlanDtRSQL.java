/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : VesselPassagePlanManagementDBDAOCheckPassagePlanDtRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.18
*@LastModifier : 
*@LastVersion : 1.0
* 2015.05.18 
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

public class VesselPassagePlanManagementDBDAOCheckPassagePlanDtRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Passage Plan 테이블 내에 데이터 존재 여부 확인
	  * </pre>
	  */
	public VesselPassagePlanManagementDBDAOCheckPassagePlanDtRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("dep_port_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : VesselPassagePlanManagementDBDAOCheckPassagePlanDtRSQL").append("\n"); 
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
		query.append("SELECT COUNT(*) AS CNT" ).append("\n"); 
		query.append("FROM    VSK_PASG_PLN_RPT A" ).append("\n"); 
		query.append("WHERE	1=1" ).append("\n"); 
		query.append("AND  A.VSL_CD      = @[vsl_cd]" ).append("\n"); 
		query.append("AND  A.SKD_VOY_NO  = @[skd_voy_no]" ).append("\n"); 
		query.append("AND  A.SKD_DIR_CD  = @[skd_dir_cd]" ).append("\n"); 
		query.append("AND  TO_CHAR(A.PASG_PLN_DT, 'YYYYMMDDHH24MI') = TO_CHAR(TO_DATE(@[pasg_pln_dt], 'YYYYMMDDHH24MI'), 'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append("AND  A.DEP_PORT_CD = @[dep_port_cd]" ).append("\n"); 
		query.append("AND  A.ARR_PORT_CD = @[arr_port_cd]" ).append("\n"); 
		query.append("AND  TO_CHAR(A.DEP_PLN_DT, 'YYYYMMDDHH24MI') = TO_CHAR(TO_DATE(@[dep_pln_dt], 'YYYYMMDDHH24MI'), 'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append("AND  TO_CHAR(A.ARR_PLN_DT, 'YYYYMMDDHH24MI') = TO_CHAR(TO_DATE(@[arr_pln_dt], 'YYYYMMDDHH24MI'), 'YYYYMMDDHH24MI')" ).append("\n"); 

	}
}