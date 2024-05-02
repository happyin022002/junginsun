/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SettlementProcessDBDAOMvntEvntDateCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.31
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2015.08.31 민정호
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

public class SettlementProcessDBDAOMvntEvntDateCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Mvnt Evnt Date 저장
	  * </pre>
	  */
	public SettlementProcessDBDAOMvntEvntDateCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnmv_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vps_eta_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vps_etb_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cnmv_evnt_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vps_etd_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clpt_ind_seq3",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.joo.jointoperationsettlement.settlementprocess.integration").append("\n"); 
		query.append("FileName : SettlementProcessDBDAOMvntEvntDateCSQL").append("\n"); 
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
		query.append("INSERT INTO JOO_CNTR_MVMT_EVNT_DT" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append(" CNTR_NO " ).append("\n"); 
		query.append(",CNMV_YR " ).append("\n"); 
		query.append(",CNMV_ID_NO " ).append("\n"); 
		query.append(",MVMT_STS_CD " ).append("\n"); 
		query.append(",CNMV_EVNT_DT " ).append("\n"); 
		query.append(",VSL_CD " ).append("\n"); 
		query.append(",SKD_VOY_NO " ).append("\n"); 
		query.append(",SKD_DIR_CD " ).append("\n"); 
		query.append(",YD_CD " ).append("\n"); 
		query.append(",CLPT_IND_SEQ " ).append("\n"); 
		query.append(",VPS_ETA_DT " ).append("\n"); 
		query.append(",VPS_ETB_DT " ).append("\n"); 
		query.append(",VPS_ETD_DT " ).append("\n"); 
		query.append(",CNMV_DT " ).append("\n"); 
		query.append(",DELT_FLG " ).append("\n"); 
		query.append(",CRE_DT " ).append("\n"); 
		query.append(",CRE_USR_ID " ).append("\n"); 
		query.append(",UPD_DT " ).append("\n"); 
		query.append(",UPD_USR_ID " ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append(" @[cntr_no] AS CNTR_NO " ).append("\n"); 
		query.append(",@[cnmv_yr] AS CNMV_YR " ).append("\n"); 
		query.append(",@[cnmv_id_no] AS CNMV_ID_NO " ).append("\n"); 
		query.append(",@[mvmt_sts_cd] AS MVMT_STS_CD " ).append("\n"); 
		query.append(",TO_DATE(@[cnmv_evnt_dt],'YYYYMMDDHH24MISS') AS CNMV_EVNT_DT " ).append("\n"); 
		query.append(",@[vsl_cd] AS VSL_CD " ).append("\n"); 
		query.append(",@[skd_voy_no] AS SKD_VOY_NO " ).append("\n"); 
		query.append(",@[skd_dir_cd] AS SKD_DIR_CD " ).append("\n"); 
		query.append(",@[yd_cd] AS YD_CD " ).append("\n"); 
		query.append(",@[clpt_ind_seq3] AS CLPT_IND_SEQ " ).append("\n"); 
		query.append(",TO_DATE(@[vps_eta_dt],'YYYYMMDDHH24MISS') AS VPS_ETA_DT " ).append("\n"); 
		query.append(",TO_DATE(@[vps_etb_dt],'YYYYMMDDHH24MISS') AS VPS_ETB_DT " ).append("\n"); 
		query.append(",TO_DATE(@[vps_etd_dt],'YYYYMMDDHH24MISS') AS VPS_ETD_DT " ).append("\n"); 
		query.append(",TO_DATE(@[cnmv_dt],'YYYYMMDDHH24MISS') AS CNMV_DT " ).append("\n"); 
		query.append(",'N' AS DELT_FLG " ).append("\n"); 
		query.append(",SYSDATE AS CRE_DT " ).append("\n"); 
		query.append(",@[upd_usr_id] AS CRE_USR_ID " ).append("\n"); 
		query.append(",SYSDATE AS UPD_DT " ).append("\n"); 
		query.append(",@[upd_usr_id] AS UPD_USR_ID " ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}