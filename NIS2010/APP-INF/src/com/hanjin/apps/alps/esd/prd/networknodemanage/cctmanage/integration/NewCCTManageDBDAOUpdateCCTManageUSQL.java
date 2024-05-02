/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : NewCCTManageDBDAOUpdateCCTManageUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.23
*@LastModifier : 김귀진
*@LastVersion : 1.0
* 2009.10.23 김귀진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.prd.networknodemanage.cctmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author kIm kwi-jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class NewCCTManageDBDAOUpdateCCTManageUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * UpdateCCTManage
	  * </pre>
	  */
	public NewCCTManageDBDAOUpdateCCTManageUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cct_hour",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cargo_type",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sun_flag",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cct_old_type",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yard_code",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("holi_flag",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cct_type",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cct_time",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("user_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lane_dir_code",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sat_flag",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cct_day",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.prd.networknodemanage.cctmanage.integration").append("\n"); 
		query.append("FileName : NewCCTManageDBDAOUpdateCCTManageUSQL").append("\n"); 
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
		query.append("UPDATE PRD_TML_CCT_MGMT SET" ).append("\n"); 
		query.append("cct_tp_cd= @[cct_type]" ).append("\n"); 
		query.append(", cct_hr = @[cct_hour]" ).append("\n"); 
		query.append("#if(${cct_type} == 'CMN')" ).append("\n"); 
		query.append(", cct_dy_cd = ''" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(",cct_dy_cd = @[cct_day]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(", cct_hrmnt = @[cct_time]" ).append("\n"); 
		query.append(", xcld_hol_sat_flg = @[sat_flag]" ).append("\n"); 
		query.append(", xcld_hol_sun_flg = @[sun_flag]" ).append("\n"); 
		query.append(", xcld_hol_hol_flg = @[holi_flag]" ).append("\n"); 
		query.append("#if(${ibflag} == 'I' || ${ibflag} == 'U')" ).append("\n"); 
		query.append(", delt_flg = 'N'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(", delt_flg = 'Y'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("--, skd_voy_no = null" ).append("\n"); 
		query.append("--, skd_dir_cd = null" ).append("\n"); 
		query.append("--, vps_port_cd = null" ).append("\n"); 
		query.append("--, clpt_ind_seq = null" ).append("\n"); 
		query.append("--, vsl_cd = null" ).append("\n"); 
		query.append(", upd_usr_id = @[user_id]" ).append("\n"); 
		query.append(", upd_dt = SYSDATE" ).append("\n"); 
		query.append("where" ).append("\n"); 
		query.append("YD_CD   =     @[yard_code]" ).append("\n"); 
		query.append("AND VSL_SLAN_CD    = @[lane_code]" ).append("\n"); 
		query.append("AND VSL_SLAN_DIR_CD     = @[lane_dir_code]" ).append("\n"); 
		query.append("AND CGO_TP_CD           = @[cargo_type]" ).append("\n"); 
		query.append("AND CCT_TP_CD    =  @[cct_old_type]" ).append("\n"); 

	}
}