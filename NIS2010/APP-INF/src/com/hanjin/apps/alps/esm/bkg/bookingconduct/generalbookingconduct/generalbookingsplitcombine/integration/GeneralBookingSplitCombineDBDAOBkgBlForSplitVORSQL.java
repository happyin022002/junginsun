/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : GeneralBookingSplitCombineDBDAOBkgBlForSplitVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.07.25
*@LastModifier : 
*@LastVersion : 1.0
* 2014.07.25 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingSplitCombineDBDAOBkgBlForSplitVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BkgBlForSplitVO
	  * 2011.06.08 이일민 [CHM-201110982-01] e-SI & DPCS BKG Split & Combine 기능 구현 요청
	  * </pre>
	  */
	public GeneralBookingSplitCombineDBDAOBkgBlForSplitVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.integration").append("\n"); 
		query.append("FileName : GeneralBookingSplitCombineDBDAOBkgBlForSplitVORSQL").append("\n"); 
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
		query.append("select  '' as split_flg" ).append("\n"); 
		query.append("       ,'' as por_cd" ).append("\n"); 
		query.append("       ,'' as stop_off_loc_cd" ).append("\n"); 
		query.append("       ,'' as remark" ).append("\n"); 
		query.append("       ,'' as bkg_sts_cd" ).append("\n"); 
		query.append("       ,'' as bdr_flg" ).append("\n"); 
		query.append("       ,'' as fd_grd_flg" ).append("\n"); 
		query.append("       ,'' as rf" ).append("\n"); 
		query.append("       ,'' as adv_shtg_cd" ).append("\n"); 
		query.append("       ,'' as bl_no" ).append("\n"); 
		query.append("       ,'' as pctl_no" ).append("\n"); 
		query.append("       ,'' as dg" ).append("\n"); 
		query.append("       ,'' as pol_cd" ).append("\n"); 
		query.append("       ,'' as rail_blk_cd" ).append("\n"); 
		query.append("       ,'' as prct_flg" ).append("\n"); 
		query.append("       ,'' as wgt_ut_cd" ).append("\n"); 
		query.append("       ,'' as meas_qty" ).append("\n"); 
		query.append("       ,'' as pck_qty" ).append("\n"); 
		query.append("       ,'' as stwg_cd" ).append("\n"); 
		query.append("       ,'' as bb" ).append("\n"); 
		query.append("       ,'' as pck_tp_cd" ).append("\n"); 
		query.append("       ,'' as meas_ut_cd" ).append("\n"); 
		query.append("       ,'' as tro_flg" ).append("\n"); 
		query.append("       ,'' as tro_tp" ).append("\n"); 
		query.append("       ,'' as obl_iss_flg" ).append("\n"); 
		query.append("       ,'' as first_vvd" ).append("\n"); 
		query.append("       ,'' as del_cd" ).append("\n"); 
		query.append("       ,'' as tvvd" ).append("\n"); 
		query.append("       ,'' as act_wgt" ).append("\n"); 
		query.append("       ,'' as bkg_close" ).append("\n"); 
		query.append("       ,'' as ak" ).append("\n"); 
		query.append("       ,'' as pod_cd" ).append("\n"); 
		query.append("       ,'' as bkg_no" ).append("\n"); 
		query.append("       ,'' as spcl_hide_flg" ).append("\n"); 
		query.append("       ,'' as hngr_flg" ).append("\n"); 
		query.append("       ,'' as edi_hld_flg" ).append("\n"); 
		query.append("       ,'' as bkg_cgo_tp_cd" ).append("\n"); 
		query.append("       ,'' as lt_flg" ).append("\n"); 
		query.append("       ,'' as multi_split_flg" ).append("\n"); 
		query.append("       ,'' as hot_de_flg" ).append("\n"); 
		query.append("       ,'' as spcl_hide_lnr_flg " ).append("\n"); 
		query.append("       ,'' as fumg_loc_cd" ).append("\n"); 
		query.append("       ,'' as crr_soc_flg" ).append("\n"); 
		query.append("from dual" ).append("\n"); 

	}
}