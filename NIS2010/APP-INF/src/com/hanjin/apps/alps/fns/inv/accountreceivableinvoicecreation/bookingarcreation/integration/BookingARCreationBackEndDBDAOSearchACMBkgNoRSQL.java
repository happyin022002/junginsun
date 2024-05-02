/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : BookingARCreationBackEndDBDAOSearchACMBkgNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.02.23
*@LastModifier : 
*@LastVersion : 1.0
* 2018.02.23 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingARCreationBackEndDBDAOSearchACMBkgNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Search ACM Bkg No
	  * </pre>
	  */
	public BookingARCreationBackEndDBDAOSearchACMBkgNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("locl_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration").append("\n"); 
		query.append("FileName : BookingARCreationBackEndDBDAOSearchACMBkgNoRSQL").append("\n"); 
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
		query.append("#if (${xch_rt_tp_cd} == 'V')" ).append("\n"); 
		query.append("    SELECT DISTINCT BKG_NO" ).append("\n"); 
		query.append("    FROM ACM_AGN_COMM" ).append("\n"); 
		query.append("    WHERE SAIL_ARR_DT >= TO_CHAR(ADD_MONTHS(SYSDATE, -3), 'YYYYMMDD')  " ).append("\n"); 
		query.append("    AND AC_VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("    AND AC_SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("    AND AC_SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("    AND AC_OCCR_INFO_CD = @[port_cd]" ).append("\n"); 
		query.append("    AND IO_BND_CD = @[io_bnd_cd]  " ).append("\n"); 
		query.append("    AND CURR_CD = @[locl_curr_cd]" ).append("\n"); 
		query.append("    AND PAY_XCH_RT = 0" ).append("\n"); 
		query.append("    AND XCH_RT_APLY_LVL = '1'" ).append("\n"); 
		query.append("#elseif (${xch_rt_tp_cd} == 'D')" ).append("\n"); 
		query.append("    SELECT DISTINCT BKG_NO" ).append("\n"); 
		query.append("    FROM ACM_AGN_COMM" ).append("\n"); 
		query.append("    WHERE SAIL_ARR_DT BETWEEN REPLACE(@[fm_dt], '-', '') AND REPLACE(@[to_dt], '-', '')" ).append("\n"); 
		query.append("    AND IO_BND_CD = DECODE(@[io_bnd_cd], '', IO_BND_CD, @[io_bnd_cd])  " ).append("\n"); 
		query.append("    AND CURR_CD = @[locl_curr_cd]" ).append("\n"); 
		query.append("    AND PAY_XCH_RT = 0" ).append("\n"); 
		query.append("    AND XCH_RT_APLY_LVL = '3'" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}