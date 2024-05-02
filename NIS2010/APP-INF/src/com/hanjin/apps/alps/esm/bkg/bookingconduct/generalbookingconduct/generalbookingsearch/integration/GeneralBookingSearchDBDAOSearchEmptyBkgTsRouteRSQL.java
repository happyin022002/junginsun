/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : GeneralBookingSearchDBDAOSearchEmptyBkgTsRouteRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.08
*@LastModifier : 
*@LastVersion : 1.0
* 2010.03.08 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingSearchDBDAOSearchEmptyBkgTsRouteRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Empty Transhipment Route 조회
	  * </pre>
	  */
	public GeneralBookingSearchDBDAOSearchEmptyBkgTsRouteRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration").append("\n"); 
		query.append("FileName : GeneralBookingSearchDBDAOSearchEmptyBkgTsRouteRSQL").append("\n"); 
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
		query.append("select 	  vvd.vsl_pre_pst_cd" ).append("\n"); 
		query.append(", vvd.vsl_seq" ).append("\n"); 
		query.append(", vvd.vsl_cd||vvd.skd_voy_no||vvd.skd_dir_Cd vvd_cd" ).append("\n"); 
		query.append(", vvd.pol_cd" ).append("\n"); 
		query.append(", vvd.pod_cd" ).append("\n"); 
		query.append(", vvd.slan_cd" ).append("\n"); 
		query.append(", (select to_char(pol.vps_etd_dt,'yyyymmdd hh24:mi')" ).append("\n"); 
		query.append("from vsk_vsl_port_skd pol" ).append("\n"); 
		query.append("where pol.vsl_cd(+)       = vvd.vsl_cd" ).append("\n"); 
		query.append("and pol.skd_voy_no(+)   = vvd.skd_voy_no" ).append("\n"); 
		query.append("and pol.skd_dir_cd(+)   = vvd.skd_dir_cd" ).append("\n"); 
		query.append("and pol.vps_port_cd(+)  = vvd.pol_cd" ).append("\n"); 
		query.append("and pol.clpt_ind_seq(+) = nvl(vvd.pol_clpt_ind_seq, '1')) etd" ).append("\n"); 
		query.append(", (select to_char(pod.vps_eta_dt,'yyyymmdd hh24:mi')" ).append("\n"); 
		query.append("from vsk_vsl_port_skd pod" ).append("\n"); 
		query.append("where pod.vsl_cd(+)       = vvd.vsl_cd" ).append("\n"); 
		query.append("and pod.skd_voy_no(+)   = vvd.skd_voy_no" ).append("\n"); 
		query.append("and pod.skd_dir_cd(+)   = vvd.skd_dir_cd" ).append("\n"); 
		query.append("and pod.vps_port_cd(+)  = vvd.pod_cd" ).append("\n"); 
		query.append("and pod.clpt_ind_seq(+) = nvl(vvd.pod_clpt_ind_seq, '1')) eta" ).append("\n"); 
		query.append("from bkg_vvd vvd" ).append("\n"); 
		query.append("where vvd.bkg_no = @[bkg_no]" ).append("\n"); 
		query.append("--and pol.clpt_seq < pod.clpt_seq" ).append("\n"); 
		query.append("order by vsl_pre_pst_cd,vsl_seq" ).append("\n"); 

	}
}