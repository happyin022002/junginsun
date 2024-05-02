/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChassisGensetSOManageDBDAOSearchImportedChassisRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.22
*@LastModifier : 손은주(TRS)
*@LastVersion : 1.0
* 2009.10.22 손은주(TRS)
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.chassisgensetsomanage.chassisgensetsomanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Eun ju Son(TRS)
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChassisGensetSOManageDBDAOSearchImportedChassisRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * f_cmd : SEARCH06
	  * Imported Chassis List retrieve
	  * </pre>
	  */
	public ChassisGensetSOManageDBDAOSearchImportedChassisRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.chassisgensetsomanage.chassisgensetsomanage.integration").append("\n"); 
		query.append("FileName : ChassisGensetSOManageDBDAOSearchImportedChassisRSQL").append("\n"); 
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
		query.append(",a.eq_tpsz_cd" ).append("\n"); 
		query.append(",b.diff_desc chss_tpsz_desc" ).append("\n"); 
		query.append(",SUBSTR (a.onh_yd_cd,1,5) fm_loc_value" ).append("\n"); 
		query.append(",SUBSTR (a.onh_yd_cd,6,2) fm_yard_value" ).append("\n"); 
		query.append(",SUBSTR (a.chss_mvmt_dest_yd_cd,1,5) to_loc_value" ).append("\n"); 
		query.append(",SUBSTR (a.chss_mvmt_dest_yd_cd,6,2) to_yard_value" ).append("\n"); 
		query.append(",a.vndr_seq" ).append("\n"); 
		query.append(",c.vndr_abbr_nm" ).append("\n"); 
		query.append(",a.agmt_lstm_cd lstm_cd" ).append("\n"); 
		query.append(",a.chss_ownr_co_cd ownr_co_cd" ).append("\n"); 
		query.append(",a.lst_use_co_cd usr_co_cd" ).append("\n"); 
		query.append(",a.chss_mvmt_sts_cd mvmt_sts_cd" ).append("\n"); 
		query.append(",d.mvmt_sts_nm" ).append("\n"); 
		query.append(",e.sts_evnt_yd_cd lst_sts_yd_cd" ).append("\n"); 
		query.append(",TO_CHAR (a.chss_mvmt_dt, 'YYYYMMDD') mvmt_dt" ).append("\n"); 
		query.append(",a.gate_io_cd gate_io_cd" ).append("\n"); 
		query.append("FROM  cgm_equipment a" ).append("\n"); 
		query.append(",cgm_eq_tp_sz b" ).append("\n"); 
		query.append(",mdm_vendor c" ).append("\n"); 
		query.append(",mdm_mvmt_sts d" ).append("\n"); 
		query.append(",cgm_eq_sts_his e" ).append("\n"); 
		query.append("WHERE a.eq_tpsz_cd = b.eq_tpsz_cd" ).append("\n"); 
		query.append("AND a.eq_no = e.eq_no" ).append("\n"); 
		query.append("AND a.eq_sts_seq = e.eq_sts_seq" ).append("\n"); 
		query.append("AND a.eq_knd_cd = 'Z'" ).append("\n"); 
		query.append("AND b.eq_knd_cd = 'Z'" ).append("\n"); 
		query.append("AND e.eq_knd_cd = 'Z'" ).append("\n"); 
		query.append("AND a.vndr_seq = c.vndr_seq(+)" ).append("\n"); 
		query.append("AND a.chss_mvmt_sts_cd = d.mvmt_sts_cd(+)" ).append("\n"); 
		query.append("AND a.eq_no IN (" ).append("\n"); 
		query.append("#foreach(${key} in ${eq_no})" ).append("\n"); 
		query.append("#if($velocityCount == 1)" ).append("\n"); 
		query.append("'${key}'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(",'${key}'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("ORDER BY a.eq_no" ).append("\n"); 

	}
}