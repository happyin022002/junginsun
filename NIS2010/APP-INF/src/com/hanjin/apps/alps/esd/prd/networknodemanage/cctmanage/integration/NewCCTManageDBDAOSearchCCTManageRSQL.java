/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : NewCCTManageDBDAOSearchCCTManageRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.28
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.28 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.prd.networknodemanage.cctmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class NewCCTManageDBDAOSearchCCTManageRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchCCTManage
	  * </pre>
	  */
	public NewCCTManageDBDAOSearchCCTManageRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("status_code",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("location_code",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lane_code",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("country_code",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yard_code",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.prd.networknodemanage.cctmanage.integration").append("\n"); 
		query.append("FileName : NewCCTManageDBDAOSearchCCTManageRSQL").append("\n"); 
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
		query.append("SELECT loc_cd location_code" ).append("\n"); 
		query.append("	, cct.yd_cd yard_code" ).append("\n"); 
		query.append("	, cct.vsl_slan_cd lane_code" ).append("\n"); 
		query.append("	, cct.vsl_slan_dir_cd lane_dir_code" ).append("\n"); 
		query.append("	, cct.cgo_tp_cd cargo_type" ).append("\n"); 
		query.append("	, cct.cct_tp_cd cct_type" ).append("\n"); 
		query.append("	, cct.cct_hr cct_hour" ).append("\n"); 
		query.append("	, decode(cct.cct_dy_cd, 'CMN','OneDayBeforeETB',cct.cct_dy_cd) cct_day" ).append("\n"); 
		query.append("	, cct.cct_hrmnt cct_time" ).append("\n"); 
		query.append("	, '0' delete_flag" ).append("\n"); 
		query.append("	, decode(cct.delt_flg,'Y','1','0') org_delete_flag" ).append("\n"); 
		query.append("	, xcld_hol_sat_flg sat_flag" ).append("\n"); 
		query.append("	, xcld_hol_sun_flg sun_flag" ).append("\n"); 
		query.append("	, xcld_hol_hol_flg holi_flag" ).append("\n"); 
		query.append("	, cct.cct_tp_cd cct_old_type" ).append("\n"); 
		query.append("    , cct.APLY_RAIL_CTNT" ).append("\n"); 
		query.append(",ERT_RCV_DT_FREE_DY" ).append("\n"); 
		query.append(",ERT_RCV_DT_ETA_FLG" ).append("\n"); 
		query.append(",ERT_RCV_DT_SAT_FLG" ).append("\n"); 
		query.append(",ERT_RCV_DT_SUN_FLG" ).append("\n"); 
		query.append(",ERT_RCV_DT_HOL_FLG" ).append("\n"); 
		query.append(",VVD_CD" ).append("\n"); 
		query.append(",to_char(cct.cre_dt,'YYYY-MM-DD') cre_dt" ).append("\n"); 
		query.append(",cct.cre_usr_id" ).append("\n"); 
		query.append(",to_char(cct.upd_dt,'YYYY-MM-DD') upd_dt" ).append("\n"); 
		query.append(",cct.upd_usr_id" ).append("\n"); 
		query.append("FROM prd_tml_cct_mgmt cct, mdm_yard my, mdm_vsl_svc_lane mvl    " ).append("\n"); 
		query.append("WHERE cct.yd_cd LIKE @[country_code] || '%'    " ).append("\n"); 
		query.append("	AND cct.yd_cd LIKE @[location_code] || '%'    " ).append("\n"); 
		query.append("	AND cct.yd_cd LIKE @[yard_code] || '%'    " ).append("\n"); 
		query.append("	AND cct.delt_flg LIKE DECODE (@[status_code], 'N', 'N', 'Y', 'Y', '%')    " ).append("\n"); 
		query.append("	AND my.yd_cd = cct.yd_cd    " ).append("\n"); 
		query.append("	AND NVL (my.delt_flg, 'N') <> 'Y'    " ).append("\n"); 
		query.append("	AND mvl.vsl_slan_cd = cct.vsl_slan_cd    " ).append("\n"); 
		query.append("	AND NVL (mvl.delt_flg, 'N')  <> 'Y'    " ).append("\n"); 
		query.append("	AND cct.vsl_slan_cd LIKE @[lane_code] || '%'" ).append("\n"); 

	}
}