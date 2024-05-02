/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RailBillingReqCreateDBDAOsearchTrsRailOrderListFullRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.26
*@LastModifier : 박연진
*@LastVersion : 1.0
* 2009.10.26 박연진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.servicesio.railbilling.requestcreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Yeon-Jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RailBillingReqCreateDBDAOsearchTrsRailOrderListFullRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Rail Billing Full Cntr Request (Excel Down)화면에 대한 조회
	  * </pre>
	  */
	public RailBillingReqCreateDBDAOsearchTrsRailOrderListFullRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.servicesio.railbilling.requestcreation.integration").append("\n"); 
		query.append("FileName : RailBillingReqCreateDBDAOsearchTrsRailOrderListFullRSQL").append("\n"); 
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
		query.append("SELECT 'Y' io_flag" ).append("\n"); 
		query.append(",a.trsp_so_ofc_cty_cd so_ofc_cty_cd" ).append("\n"); 
		query.append(",a.trsp_so_seq so_seq" ).append("\n"); 
		query.append(",a.eq_no cntr_no" ).append("\n"); 
		query.append(",a.eq_tpsz_cd cntr_tpsz_cd" ).append("\n"); 
		query.append(",b.cntr_tpsz_rmk cntr_tpsz_nm" ).append("\n"); 
		query.append(",a.pck_qty pkg_qty" ).append("\n"); 
		query.append(",a.cntr_wgt wgt_qty" ).append("\n"); 
		query.append(",a.auto_xpt_sys_cd" ).append("\n"); 
		query.append(",a.auto_xpt_sys_no" ).append("\n"); 
		query.append(",'' remark_desc" ).append("\n"); 
		query.append(",'1' bkg_qty" ).append("\n"); 
		query.append(",a.blk_flg bulk_flag" ).append("\n"); 
		query.append(",a.stel_wire_flg steel_flag" ).append("\n"); 
		query.append(",a.coil_shp_flg coil_flag" ).append("\n"); 
		query.append(",a.fumg_flg fum_flag" ).append("\n"); 
		query.append("FROM trs_trsp_rail_bil_ord a" ).append("\n"); 
		query.append(",mdm_cntr_tp_sz b" ).append("\n"); 
		query.append("WHERE a.eq_tpsz_cd = b.cntr_tpsz_cd" ).append("\n"); 
		query.append("AND a.delt_flg = 'N'" ).append("\n"); 
		query.append("--AND a.spnd_flg = 'N'" ).append("\n"); 
		query.append("--AND a.cxl_rqst_flg = 'N'" ).append("\n"); 
		query.append("--AND a.cxl_rqst_rjct_flg = 'N'" ).append("\n"); 
		query.append("#if($trsRailOrderKey.size() > 0)" ).append("\n"); 
		query.append("AND (a.trsp_so_ofc_cty_cd, a.trsp_so_seq) IN (" ).append("\n"); 
		query.append("#foreach( ${key} in ${trsRailOrderKey})" ).append("\n"); 
		query.append("#if($velocityCount < $trsRailOrderKey.size())" ).append("\n"); 
		query.append("('$key.velParamField1','$key.velParamField2')," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("('$key.velParamField1','$key.velParamField2')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}