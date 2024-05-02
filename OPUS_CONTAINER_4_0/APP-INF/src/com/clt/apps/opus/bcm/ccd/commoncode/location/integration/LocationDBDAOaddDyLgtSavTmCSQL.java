/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : LocationDBDAOaddDyLgtSavTmCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.07
*@LastModifier : 
*@LastVersion : 1.0
* 2011.03.07 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.bcm.ccd.commoncode.location.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class LocationDBDAOaddDyLgtSavTmCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 신규 DayLight Saving Time 정보를 저장합니다.
	  * </pre>
	  */
	public LocationDBDAOaddDyLgtSavTmCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("end_dst_rule_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("st_dst_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("st_dst_hrmnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dst_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dst_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("st_dst_rule_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dst_mnts",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dst_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("end_dst_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("delt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dst_not_aply_ste_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("end_dst_hrmnt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.bcm.ccd.commoncode.location.integration").append("\n"); 
		query.append("FileName : LocationDBDAOaddDyLgtSavTmCSQL").append("\n"); 
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
		query.append("INSERT INTO MDM_DYLGT_SAV_TM (" ).append("\n"); 
		query.append("    DST_ID," ).append("\n"); 
		query.append("    DST_CNT_CD," ).append("\n"); 
		query.append("    DST_NOT_APLY_STE_CD," ).append("\n"); 
		query.append("    DST_YR," ).append("\n"); 
		query.append("    DST_MNTS," ).append("\n"); 
		query.append("    ST_DST_RULE_DESC," ).append("\n"); 
		query.append("    END_DST_RULE_DESC," ).append("\n"); 
		query.append("    ST_DST_DT," ).append("\n"); 
		query.append("    END_DST_DT," ).append("\n"); 
		query.append("    ST_DST_HRMNT," ).append("\n"); 
		query.append("    END_DST_HRMNT," ).append("\n"); 
		query.append("    DELT_FLG," ).append("\n"); 
		query.append("    CRE_USR_ID," ).append("\n"); 
		query.append("    CRE_DT," ).append("\n"); 
		query.append("    UPD_USR_ID," ).append("\n"); 
		query.append("    UPD_DT" ).append("\n"); 
		query.append(") VALUES (" ).append("\n"); 
		query.append("    @[dst_id]," ).append("\n"); 
		query.append("    @[dst_cnt_cd]," ).append("\n"); 
		query.append("    @[dst_not_aply_ste_cd]," ).append("\n"); 
		query.append("    @[dst_yr]," ).append("\n"); 
		query.append("    @[dst_mnts]," ).append("\n"); 
		query.append("    @[st_dst_rule_desc]," ).append("\n"); 
		query.append("    @[end_dst_rule_desc]," ).append("\n"); 
		query.append("    @[st_dst_dt]," ).append("\n"); 
		query.append("    @[end_dst_dt]," ).append("\n"); 
		query.append("    @[st_dst_hrmnt]," ).append("\n"); 
		query.append("    @[end_dst_hrmnt]," ).append("\n"); 
		query.append("    @[delt_flg]," ).append("\n"); 
		query.append("    @[usr_id]," ).append("\n"); 
		query.append("    sysdate," ).append("\n"); 
		query.append("    @[usr_id]," ).append("\n"); 
		query.append("    sysdate" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}