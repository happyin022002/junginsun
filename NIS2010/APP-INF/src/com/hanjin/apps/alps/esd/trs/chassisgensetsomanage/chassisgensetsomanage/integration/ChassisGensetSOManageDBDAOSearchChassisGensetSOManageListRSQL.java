/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ChassisGensetSOManageDBDAOSearchChassisGensetSOManageListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.26
*@LastModifier : 
*@LastVersion : 1.0
* 2010.01.26 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.chassisgensetsomanage.chassisgensetsomanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChassisGensetSOManageDBDAOSearchChassisGensetSOManageListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 조회 조건이 다음과 같을 때, 조회가 가능하다.
	  *  - Kind : Chasis, On Hire, From EQ Master
	  *  - On Hire Creation Date , On Hire Yard이 입력됐을 경우
	  * </pre>
	  */
	public ChassisGensetSOManageDBDAOSearchChassisGensetSOManageListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fmdate",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hire_yd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("todate",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hire_loc",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.chassisgensetsomanage.chassisgensetsomanage.integration").append("\n"); 
		query.append("FileName : ChassisGensetSOManageDBDAOSearchChassisGensetSOManageListRSQL").append("\n"); 
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
		query.append(",gate_io_cd gate_io_cd" ).append("\n"); 
		query.append("FROM cgm_equipment a" ).append("\n"); 
		query.append(",cgm_eq_tp_sz b" ).append("\n"); 
		query.append(",mdm_vendor c" ).append("\n"); 
		query.append(",mdm_mvmt_sts d" ).append("\n"); 
		query.append(",cgm_eq_sts_his e" ).append("\n"); 
		query.append("WHERE a.eq_tpsz_cd = b.eq_tpsz_cd" ).append("\n"); 
		query.append("AND a.eq_no = e.eq_no" ).append("\n"); 
		query.append("AND a.eq_sts_seq = e.eq_sts_seq" ).append("\n"); 
		query.append("AND a.vndr_seq = c.vndr_seq(+)" ).append("\n"); 
		query.append("AND a.chss_mvmt_sts_cd = d.mvmt_sts_cd(+)" ).append("\n"); 
		query.append("AND a.eq_knd_cd = 'Z'" ).append("\n"); 
		query.append("#if (${fmdate} != ''&& ${todate} != '')" ).append("\n"); 
		query.append("AND a.onh_dt BETWEEN TO_DATE (@[fmdate] || '000001', 'YYYYMMDDHH24MISS') AND TO_DATE (@[todate] || '235959', 'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND NOT EXISTS (SELECT ''" ).append("\n"); 
		query.append("FROM trs_trsp_svc_ord f" ).append("\n"); 
		query.append("WHERE a.eq_no = f.eq_no" ).append("\n"); 
		query.append("AND SUBSTR (a.onh_yd_cd, 1, 5) = SUBSTR (f.fm_nod_cd, 1, 5)" ).append("\n"); 
		query.append("AND f.locl_cre_dt > SYSDATE - 14" ).append("\n"); 
		query.append("AND NVL(f.delt_flg,'Y') = 'N')" ).append("\n"); 
		query.append("#if (${hire_loc} != ''&& ${hire_yd} == '')" ).append("\n"); 
		query.append("AND a.onh_yd_cd LIKE @[hire_loc] || '%'" ).append("\n"); 
		query.append("#elseif (${hire_loc} != ''&& ${hire_yd} != '')" ).append("\n"); 
		query.append("AND a.onh_yd_cd = @[hire_loc]||@[hire_yd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}