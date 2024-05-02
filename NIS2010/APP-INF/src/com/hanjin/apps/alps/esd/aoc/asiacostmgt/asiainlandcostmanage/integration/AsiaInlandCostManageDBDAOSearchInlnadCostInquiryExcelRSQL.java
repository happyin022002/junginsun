/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : AsiaInlandCostManageDBDAOSearchInlnadCostInquiryExcelRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.10.11
*@LastModifier : 
*@LastVersion : 1.0
* 2012.10.11 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.aoc.asiacostmgt.asiainlandcostmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AsiaInlandCostManageDBDAOSearchInlnadCostInquiryExcelRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchInlnadCostInquiryExcel
	  * </pre>
	  */
	public AsiaInlandCostManageDBDAOSearchInlnadCostInquiryExcelRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.aoc.asiacostmgt.asiainlandcostmanage.integration").append("\n"); 
		query.append("FileName : AsiaInlandCostManageDBDAOSearchInlnadCostInquiryExcelRSQL").append("\n"); 
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
		query.append("select " ).append("\n"); 
		query.append("'1' AS curr_cd," ).append("\n"); 
		query.append("'1' AS rhq_cd," ).append("\n"); 
		query.append("'1' AS cnt_cd," ).append("\n"); 
		query.append("'1' AS in_sort_by," ).append("\n"); 
		query.append("'1' AS in_cnt_cd," ).append("\n"); 
		query.append("'1' AS in_cost_trf_no," ).append("\n"); 
		query.append("'1' AS io_bnd_cd," ).append("\n"); 
		query.append("'1' AS in_asc_desc," ).append("\n"); 
		query.append("'1' AS cost_sel_rout_flg," ).append("\n"); 
		query.append("'1' AS date_flg," ).append("\n"); 
		query.append("'1' AS from_dt," ).append("\n"); 
		query.append("'1' AS to_dt," ).append("\n"); 
		query.append("'1' AS eff_to_dt," ).append("\n"); 
		query.append("'1' AS loc_nod_cd," ).append("\n"); 
		query.append("'1' AS hub_nod_cd," ).append("\n"); 
		query.append("'1' AS port_nod_cd," ).append("\n"); 
		query.append("'1' AS trsp_crr_mod_cd," ).append("\n"); 
		query.append("'1' AS rcv_de_term_cd," ).append("\n"); 
		query.append("'1' AS cost_trf_no," ).append("\n"); 
		query.append("'1' AS cost_factor_cd," ).append("\n"); 
		query.append("'1' AS sys_src_cd," ).append("\n"); 
		query.append("'1' AS adjustment_cd" ).append("\n"); 
		query.append("from dual" ).append("\n"); 

	}
}