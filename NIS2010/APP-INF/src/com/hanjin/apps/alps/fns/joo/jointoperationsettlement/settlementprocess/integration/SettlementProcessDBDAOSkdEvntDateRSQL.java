/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SettlementProcessDBDAOSkdEvntDateRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.10
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2015.08.10 민정호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationsettlement.settlementprocess.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jung Ho Min
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SettlementProcessDBDAOSkdEvntDateRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Skd Evnt Date 조회
	  * </pre>
	  */
	public SettlementProcessDBDAOSkdEvntDateRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnmv_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mvmt_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnmv_id_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cnmv_evnt_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.joo.jointoperationsettlement.settlementprocess.integration").append("\n"); 
		query.append("FileName : SettlementProcessDBDAOSkdEvntDateRSQL").append("\n"); 
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
		query.append(" @[cntr_no] AS CNTR_NO" ).append("\n"); 
		query.append(",@[cnmv_yr] AS CNMV_YR" ).append("\n"); 
		query.append(",@[cnmv_id_no] AS CNMV_ID_NO" ).append("\n"); 
		query.append(",@[mvmt_sts_cd] AS MVMT_STS_CD" ).append("\n"); 
		query.append(",@[cnmv_evnt_dt] AS CNMV_EVNT_DT" ).append("\n"); 
		query.append(",V.VSL_CD" ).append("\n"); 
		query.append(",V.SKD_VOY_NO" ).append("\n"); 
		query.append(",V.SKD_DIR_CD" ).append("\n"); 
		query.append(",V.YD_CD" ).append("\n"); 
		query.append(",V.CLPT_IND_SEQ" ).append("\n"); 
		query.append(",V.VPS_ETA_DT " ).append("\n"); 
		query.append(",V.VPS_ETB_DT " ).append("\n"); 
		query.append(",V.VPS_ETD_DT " ).append("\n"); 
		query.append("FROM VSK_VSL_PORT_SKD V" ).append("\n"); 
		query.append("WHERE V.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("AND V.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("AND V.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("AND V.YD_CD = @[yd_cd]" ).append("\n"); 

	}
}