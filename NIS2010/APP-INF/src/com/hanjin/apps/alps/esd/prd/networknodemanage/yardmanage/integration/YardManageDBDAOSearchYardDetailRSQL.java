/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : YardManageDBDAOSearchYardDetailRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.08.19
*@LastModifier : 
*@LastVersion : 1.0
* 2013.08.19 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.prd.networknodemanage.yardmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class YardManageDBDAOSearchYardDetailRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchYardDetail
	  * </pre>
	  */
	public YardManageDBDAOSearchYardDetailRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("node_code",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.prd.networknodemanage.yardmanage.integration").append("\n"); 
		query.append("FileName : YardManageDBDAOSearchYardDetailRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("	-- basic info" ).append("\n"); 
		query.append("	yd_cd yard_code, loc_cd location_code, yd_nm yard_name" ).append("\n"); 
		query.append("	, DECODE (rep_yd_tp_cd,  " ).append("\n"); 
		query.append("              'M', 'Marine Terminal',  " ).append("\n"); 
		query.append("              'B', 'Barge Terminal',  " ).append("\n"); 
		query.append("              'R', 'Rail Terminal',  " ).append("\n"); 
		query.append("              'Y', 'Yard',  " ).append("\n"); 
		query.append("              'S', 'CFS',  " ).append("\n"); 
		query.append("              'P', 'Pseudo',  " ).append("\n"); 
		query.append("              'Z', 'Zone'  " ).append("\n"); 
		query.append("			) node_type" ).append("\n"); 
		query.append("	, hub_yd_flg hub_node" ).append("\n"); 
		query.append("	, yd_fcty_tp_mrn_tml_flg service_type_marinet " ).append("\n"); 
		query.append("	, yd_fcty_tp_brg_rmp_flg service_type_barget" ).append("\n"); 
		query.append("	, yd_fcty_tp_cy_flg service_type_cy" ).append("\n"); 
		query.append("	, yd_fcty_tp_cfs_flg service_type_cfs" ).append("\n"); 
		query.append("	, yd_fcty_tp_rail_rmp_flg service_type_railramp" ).append("\n"); 
		query.append("	, yd_fcty_tp_psdo_yd_flg service_type_pseudoy" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	-- contact point" ).append("\n"); 
		query.append("	, yd_pic_nm person, yd_eml email, phn_no tel, fax_no fax" ).append("\n"); 
		query.append("	, zip_cd postal_code, REPLACE(REPLACE (yd_addr, chr(13), ''), chr(10), '')  yard_address" ).append("\n"); 
		query.append("			" ).append("\n"); 
		query.append("	-- service info" ).append("\n"); 
		query.append("	, gate_opn_hrmnt gate_week_open, gate_clz_hrmnt gate_week_close" ).append("\n"); 
		query.append("	, sat_gate_opn_hrmnt gate_sat_open, sat_gate_clz_hrmnt gate_sat_close" ).append("\n"); 
		query.append("	, sun_gate_opn_hrmnt gate_sun_open, sun_gate_clz_hrmnt gate_sun_close" ).append("\n"); 
		query.append("	, hol_gate_opn_hrmnt gate_holiday_open, hol_gate_clz_hrmnt gate_holiday_close" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("--	, rf_avg_dwll_hrs average_dwell_r, dry_avg_dwll_hrs average_dwell_d" ).append("\n"); 
		query.append("--	, rf_min_dwll_hrs minimum_dwell_r, dry_min_dwll_hrs minimum_dwell_d" ).append("\n"); 
		query.append("	, ib_rf_avg_dwll_hrs ib_average_dwell_r, ib_dry_avg_dwll_hrs ib_average_dwell_d" ).append("\n"); 
		query.append("	, ib_rf_min_dwll_hrs ib_minimum_dwell_r, ib_dry_min_dwll_hrs ib_minimum_dwell_d" ).append("\n"); 
		query.append("	, ob_rf_avg_dwll_hrs ob_average_dwell_r, ob_dry_avg_dwll_hrs ob_average_dwell_d" ).append("\n"); 
		query.append("	, ob_rf_min_dwll_hrs ob_minimum_dwell_r, ob_dry_min_dwll_hrs ob_minimum_dwell_d" ).append("\n"); 
		query.append("	, dry_yd_ft_hrs free_time" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("    , cop_ob_dry_avg_dwll_hrs" ).append("\n"); 
		query.append("	, cop_ib_dry_avg_dwll_hrs" ).append("\n"); 
		query.append("	, cop_ob_rf_avg_dwll_hrs" ).append("\n"); 
		query.append("	, cop_ib_rf_avg_dwll_hrs" ).append("\n"); 
		query.append("	-- yard operator" ).append("\n"); 
		query.append("	, n1st_vndr_seq yard_operator1" ).append("\n"); 
		query.append("    , (SELECT vndr_lgl_eng_nm FROM mdm_vendor " ).append("\n"); 
		query.append("        WHERE vndr_seq = n1st_vndr_seq) operator1_name  " ).append("\n"); 
		query.append("	, n2nd_vndr_seq yard_operator2" ).append("\n"); 
		query.append("    , (SELECT vndr_lgl_eng_nm FROM mdm_vendor  " ).append("\n"); 
		query.append("        WHERE vndr_seq = n2nd_vndr_seq) operator2_name  " ).append("\n"); 
		query.append("	, n3rd_vndr_seq yard_operator3" ).append("\n"); 
		query.append("    , (SELECT vndr_lgl_eng_nm FROM mdm_vendor  " ).append("\n"); 
		query.append("        WHERE vndr_seq = n3rd_vndr_seq) operator3_name  " ).append("\n"); 
		query.append("			" ).append("\n"); 
		query.append("    -- additional info" ).append("\n"); 
		query.append("    , ofc_cd office_code, dem_ib_clt_flg dem_ib_collection, dem_ob_clt_flg dem_ob_collection" ).append("\n"); 
		query.append("    , DECODE(yd_oshp_cd, 'C', 'Contract', 'O', 'Own', 'S', 'Shipper', 'Y', 'Truck', '') yard_ownership " ).append("\n"); 
		query.append("    , bd_yd_flg bonded_yard, '' c_tpat, onf_hir_yd_flg yard_on_off" ).append("\n"); 
		query.append("FROM mdm_yard  " ).append("\n"); 
		query.append("WHERE yd_cd = @[node_code] AND NVL (delt_flg, 'N') <> 'Y'" ).append("\n"); 

	}
}