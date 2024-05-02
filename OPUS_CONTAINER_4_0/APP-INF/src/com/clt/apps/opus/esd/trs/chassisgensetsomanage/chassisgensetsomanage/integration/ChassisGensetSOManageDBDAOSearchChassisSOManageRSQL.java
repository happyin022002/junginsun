/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : ChassisGensetSOManageDBDAOSearchChassisSOManageRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.16
*@LastModifier : 박찬우
*@LastVersion : 1.0
* 2017.01.16 박찬우
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.chassisgensetsomanage.chassisgensetsomanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Chanwoo Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChassisGensetSOManageDBDAOSearchChassisSOManageRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Chassis List Retrieve f_cmd : SEARCH01
	  * </pre>
	  */
	public ChassisGensetSOManageDBDAOSearchChassisSOManageRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.chassisgensetsomanage.chassisgensetsomanage.integration").append("\n"); 
		query.append("FileName : ChassisGensetSOManageDBDAOSearchChassisSOManageRSQL").append("\n"); 
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
		query.append("SELECT a.eq_no" ).append("\n"); 
		query.append("      ,a.eq_tpsz_cd" ).append("\n"); 
		query.append("      ,b.diff_desc chss_tpsz_desc" ).append("\n"); 
		query.append("      ,SUBSTR (a.onh_yd_cd,1,5) fm_loc_value" ).append("\n"); 
		query.append("      ,SUBSTR (a.onh_yd_cd,6,2) fm_yard_value" ).append("\n"); 
		query.append("      ,SUBSTR (a.chss_mvmt_dest_yd_cd,1,5) to_loc_value" ).append("\n"); 
		query.append("      ,SUBSTR (a.chss_mvmt_dest_yd_cd,6,2) to_yard_value" ).append("\n"); 
		query.append("      ,a.vndr_seq" ).append("\n"); 
		query.append("      ,c.vndr_abbr_nm" ).append("\n"); 
		query.append("      ,a.agmt_lstm_cd lstm_cd" ).append("\n"); 
		query.append("      ,a.chss_ownr_co_cd ownr_co_cd" ).append("\n"); 
		query.append("      ,a.lst_use_co_cd usr_co_cd" ).append("\n"); 
		query.append("      ,a.chss_mvmt_sts_cd  mvmt_sts_cd" ).append("\n"); 
		query.append("      ,d.mvmt_sts_nm" ).append("\n"); 
		query.append("      ,e.sts_evnt_yd_cd lst_sts_yd_cd" ).append("\n"); 
		query.append("      ,TO_CHAR (a.chss_mvmt_dt, 'YYYYMMDD') mvmt_dt" ).append("\n"); 
		query.append("      ,a.gate_io_cd gate_io_flg" ).append("\n"); 
		query.append("  FROM cgm_equipment a" ).append("\n"); 
		query.append("      ,cgm_eq_tp_sz b" ).append("\n"); 
		query.append("      ,mdm_vendor c" ).append("\n"); 
		query.append("      ,mdm_mvmt_sts d" ).append("\n"); 
		query.append("      ,cgm_eq_sts_his e" ).append("\n"); 
		query.append(" WHERE a.eq_tpsz_cd = b.eq_tpsz_cd" ).append("\n"); 
		query.append("   AND a.eq_no = e.eq_no" ).append("\n"); 
		query.append("   AND a.eq_sts_seq = e.eq_sts_seq" ).append("\n"); 
		query.append("   AND a.eq_knd_cd = 'Z'" ).append("\n"); 
		query.append("   AND a.eq_knd_cd = b.eq_knd_cd" ).append("\n"); 
		query.append("   AND a.eq_knd_cd = e.eq_knd_cd" ).append("\n"); 
		query.append("   AND a.vndr_seq = c.vndr_seq(+)" ).append("\n"); 
		query.append("   AND a.chss_mvmt_sts_cd = d.mvmt_sts_cd(+)" ).append("\n"); 
		query.append("   AND a.eq_no = @[eq_no]" ).append("\n"); 

	}
}