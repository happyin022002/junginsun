/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : NewCCTManageDBDAOMultiCCTManageRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.08.20
*@LastModifier : 
*@LastVersion : 1.0
* 2014.08.20 
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

public class NewCCTManageDBDAOMultiCCTManageRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MultiCCTManage
	  * </pre>
	  */
	public NewCCTManageDBDAOMultiCCTManageRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ert_rcv_dt_free_dy",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cct_hour",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ert_rcv_dt_sun_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("aply_rail_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ert_rcv_dt_sat_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ert_rcv_dt_hol_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : NewCCTManageDBDAOMultiCCTManageRSQL").append("\n"); 
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
		query.append("MERGE INTO PRD_TML_CCT_MGMT c " ).append("\n"); 
		query.append("	USING (    " ).append("\n"); 
		query.append("		SELECT @[yard_code] yd_cd, @[lane_code] vsl_slan_cd" ).append("\n"); 
		query.append("			, @[lane_dir_code] vsl_slan_dir_cd, @[cargo_type] cgo_tp_cd" ).append("\n"); 
		query.append("			, @[cct_type] cct_tp_cd, @[cct_hour] cct_hr" ).append("\n"); 
		query.append("#if(${cct_type} == 'CMN')" ).append("\n"); 
		query.append("			, '' cct_dy_cd" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("			, @[cct_day] cct_dy_cd" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("			, @[cct_time] cct_hrmnt " ).append("\n"); 
		query.append("			, @[aply_rail_ctnt]   aply_rail_ctnt" ).append("\n"); 
		query.append("			, nvl(@[vvd_cd],'ALL') vvd_cd" ).append("\n"); 
		query.append("              FROM DUAL) t    " ).append("\n"); 
		query.append("	ON( c.yd_cd  = t.yd_cd AND c.vsl_slan_cd = t.vsl_slan_cd    " ).append("\n"); 
		query.append("		AND c.vsl_slan_dir_cd = t.vsl_slan_dir_cd AND c.cgo_tp_cd =t.cgo_tp_cd  " ).append("\n"); 
		query.append("		AND C.aply_rail_ctnt = T.aply_rail_ctnt" ).append("\n"); 
		query.append("		and c.vvd_cd = t.vvd_cd" ).append("\n"); 
		query.append("		)    " ).append("\n"); 
		query.append("WHEN MATCHED THEN    " ).append("\n"); 
		query.append("	UPDATE SET " ).append("\n"); 
		query.append("		c.cct_tp_cd= @[cct_type]" ).append("\n"); 
		query.append("		, c.cct_hr = @[cct_hour]" ).append("\n"); 
		query.append("#if(${cct_type} == 'CMN')" ).append("\n"); 
		query.append("		, c.cct_dy_cd = ''" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("		,c.cct_dy_cd = @[cct_day]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("		, c.cct_hrmnt = @[cct_time]" ).append("\n"); 
		query.append("		, xcld_hol_sat_flg = @[sat_flag]" ).append("\n"); 
		query.append("		, xcld_hol_sun_flg = @[sun_flag]" ).append("\n"); 
		query.append("		, xcld_hol_hol_flg = @[holi_flag]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        , ert_rcv_dt_free_dy = @[ert_rcv_dt_free_dy]" ).append("\n"); 
		query.append("        , ert_rcv_dt_sat_flg = DECODE(@[ert_rcv_dt_sat_flg],'1','Y','N')" ).append("\n"); 
		query.append("        , ert_rcv_dt_sun_flg = DECODE(@[ert_rcv_dt_sun_flg],'1','Y','N')" ).append("\n"); 
		query.append("        , ert_rcv_dt_hol_flg = DECODE(@[ert_rcv_dt_hol_flg],'1','Y','N')" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("#if(${ibflag} == 'I' || ${ibflag} == 'U')" ).append("\n"); 
		query.append("		, c.delt_flg = 'N'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("		, c.delt_flg = 'Y'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		, c.upd_usr_id = @[user_id]" ).append("\n"); 
		query.append("		, c.upd_dt = SYSDATE    " ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN    " ).append("\n"); 
		query.append("	INSERT (YD_CD, VSL_SLAN_CD, VSL_SLAN_DIR_CD, CGO_TP_CD, CCT_TP_CD, " ).append("\n"); 
		query.append("            CCT_HR, CCT_DY_CD, CCT_HRMNT, XCLD_HOL_SAT_FLG, XCLD_HOL_SUN_FLG, XCLD_HOL_HOL_FLG, " ).append("\n"); 
		query.append("            DELT_FLG, CRE_USR_ID, CRE_DT, UPD_USR_ID, UPD_DT, APLY_RAIL_CTNT" ).append("\n"); 
		query.append("            ,ERT_RCV_DT_FREE_DY,ERT_RCV_DT_SAT_FLG,ERT_RCV_DT_SUN_FLG,ERT_RCV_DT_HOL_FLG,VVD_CD)" ).append("\n"); 
		query.append("    VALUES (@[yard_code], @[lane_code], @[lane_dir_code], @[cargo_type], @[cct_type]" ).append("\n"); 
		query.append("					, @[cct_hour]" ).append("\n"); 
		query.append("#if(${cct_type} == 'CMN')" ).append("\n"); 
		query.append("					, ''" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("					, @[cct_day]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("					, @[cct_time], @[sat_flag], @[sun_flag], @[holi_flag]" ).append("\n"); 
		query.append("#if(${ibflag} == 'I' || ${ibflag} == 'U')" ).append("\n"); 
		query.append("					, 'N'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("					, 'Y'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("--					, null, null, null, null, null" ).append("\n"); 
		query.append("					, @[user_id], SYSDATE, @[user_id], SYSDATE" ).append("\n"); 
		query.append("					,@[aply_rail_ctnt]" ).append("\n"); 
		query.append("					,@[ert_rcv_dt_free_dy], DECODE(@[ert_rcv_dt_sat_flg],'1','Y','N')" ).append("\n"); 
		query.append("					, DECODE(@[ert_rcv_dt_sun_flg],'1','Y','N')" ).append("\n"); 
		query.append("					, DECODE(@[ert_rcv_dt_hol_flg],'1','Y','N')" ).append("\n"); 
		query.append("					, nvl(@[vvd_cd],'ALL')" ).append("\n"); 
		query.append("					)" ).append("\n"); 

	}
}