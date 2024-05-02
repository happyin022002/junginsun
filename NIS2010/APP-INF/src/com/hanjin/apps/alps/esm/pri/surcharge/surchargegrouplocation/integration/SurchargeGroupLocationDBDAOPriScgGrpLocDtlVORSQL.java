/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SurchargeGroupLocationDBDAOPriScgGrpLocDtlVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.19
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.06.19 이승준
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.surcharge.surchargegrouplocation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Seung Jun Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SurchargeGroupLocationDBDAOPriScgGrpLocDtlVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Group Location detail select
	  * </pre>
	  */
	public SurchargeGroupLocationDBDAOPriScgGrpLocDtlVORSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("grp_loc_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("SELECT  a1.svc_scp_cd," ).append("\n"); 
		query.append("a1.chg_cd," ).append("\n"); 
		query.append("a1.grp_loc_seq," ).append("\n"); 
		query.append("a1.grp_loc_dtl_seq," ).append("\n"); 
		query.append("a1.dtl_loc_tp_cd," ).append("\n"); 
		query.append("a1.dtl_loc_def_cd," ).append("\n"); 
		query.append("a1.eff_dt," ).append("\n"); 
		query.append("DECODE(a1.exp_dt,'9999-12-31','',a1.exp_dt) AS exp_dt," ).append("\n"); 
		query.append("a1.cre_usr_id," ).append("\n"); 
		query.append("a1.cre_dt," ).append("\n"); 
		query.append("a1.upd_usr_id," ).append("\n"); 
		query.append("a1.upd_dt," ).append("\n"); 
		query.append("a1.loc_des" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("svc_scp_cd," ).append("\n"); 
		query.append("chg_cd," ).append("\n"); 
		query.append("grp_loc_seq," ).append("\n"); 
		query.append("grp_loc_dtl_seq," ).append("\n"); 
		query.append("dtl_loc_tp_cd," ).append("\n"); 
		query.append("dtl_loc_def_cd," ).append("\n"); 
		query.append("to_char(eff_dt,'yyyy-mm-dd') as eff_dt," ).append("\n"); 
		query.append("to_char(exp_dt,'yyyy-mm-dd') as exp_dt," ).append("\n"); 
		query.append("cre_usr_id," ).append("\n"); 
		query.append("to_char(cre_dt,'yyyy-mm-dd') as cre_dt," ).append("\n"); 
		query.append("upd_usr_id," ).append("\n"); 
		query.append("to_char(upd_dt,'yyyy-mm-dd') as upd_dt," ).append("\n"); 
		query.append("(DECODE (LENGTH(dtl_loc_def_cd)," ).append("\n"); 
		query.append("'2',(SELECT cnt_nm" ).append("\n"); 
		query.append("FROM mdm_country" ).append("\n"); 
		query.append("WHERE cnt_cd = dtl_loc_def_cd )," ).append("\n"); 
		query.append("'5',(SELECT loc_nm" ).append("\n"); 
		query.append("FROM mdm_location" ).append("\n"); 
		query.append("WHERE loc_cd = dtl_loc_def_cd )," ).append("\n"); 
		query.append("'3',(SELECT rgn_nm" ).append("\n"); 
		query.append("FROM mdm_region" ).append("\n"); 
		query.append("WHERE rgn_cd = dtl_loc_def_cd ))" ).append("\n"); 
		query.append(") as loc_des" ).append("\n"); 
		query.append("FROM pri_scg_grp_loc_dtl" ).append("\n"); 
		query.append("WHERE	svc_scp_cd = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND	chg_cd = @[chg_cd]" ).append("\n"); 
		query.append("AND	grp_loc_seq = @[grp_loc_seq]" ).append("\n"); 
		query.append(") a1" ).append("\n"); 
		query.append("ORDER BY a1.dtl_loc_def_cd" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.surcharge.surchargegrouplocation.integration").append("\n"); 
		query.append("FileName : SurchargeGroupLocationDBDAOPriScgGrpLocDtlVORSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}