/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : MnrAudDBDAOMakeHbarInquiryByBkgVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.23
*@LastModifier : 최종혁
*@LastVersion : 1.0
* 2015.03.23 최종혁
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.expnaud.mnraud.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CJH
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MnrAudDBDAOMakeHbarInquiryByBkgVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VO for H/Bar Inquiry by BKG
	  * </pre>
	  */
	public MnrAudDBDAOMakeHbarInquiryByBkgVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.expnaud.mnraud.integration").append("\n"); 
		query.append("FileName : MnrAudDBDAOMakeHbarInquiryByBkgVORSQL").append("\n"); 
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
		query.append("SELECT	 '' s_fm_dt" ).append("\n"); 
		query.append("        ,''	s_to_dt" ).append("\n"); 
		query.append("        ,''	s_vvd" ).append("\n"); 
		query.append("        ,''	s_pol_loc_cd" ).append("\n"); 
		query.append("        ,''	s_pol_yd_cd" ).append("\n"); 
		query.append("        ,''	s_bkg_no" ).append("\n"); 
		query.append("        ,''	s_cntr_tpsz_cd" ).append("\n"); 
		query.append("        ,''	s_cntr_no" ).append("\n"); 
		query.append("        ,''	s_bkg_chg_flg" ).append("\n"); 
		query.append("        ,''	s_eac_if" ).append("\n"); 
		query.append("        ,''	chk" ).append("\n"); 
		query.append("        ,''	seq" ).append("\n"); 
		query.append("        ,''	cntr_no" ).append("\n"); 
		query.append("        ,''	cntr_tpsz_cd" ).append("\n"); 
		query.append("        ,''	bkg_no" ).append("\n"); 
		query.append("        ,''	pol_dt" ).append("\n"); 
		query.append("        ,''	vvd" ).append("\n"); 
		query.append("        ,''	slan_cd" ).append("\n"); 
		query.append("        ,''	por_yd_cd" ).append("\n"); 
		query.append("        ,''	pol_yd_cd" ).append("\n"); 
		query.append("        ,''	bkg_ofc_cd" ).append("\n"); 
		query.append("        ,''	hngr_flg" ).append("\n"); 
		query.append("        ,''	crr_hngr_sgl_bar_qty" ).append("\n"); 
		query.append("        ,''	crr_hngr_dbl_bar_qty" ).append("\n"); 
		query.append("        ,''	crr_hngr_tpl_bar_qty" ).append("\n"); 
		query.append("        ,''	crr_hngr_qty" ).append("\n"); 
		query.append("        ,''	mer_hngr_qty" ).append("\n"); 
		query.append("        ,''	bkg_scg_cur_cd" ).append("\n"); 
		query.append("        ,''	bkg_scg_amt" ).append("\n"); 
		query.append("        ,''	bkg_scg_mix_flg" ).append("\n"); 
		query.append("        ,''	mnr_flg_inp_dt" ).append("\n"); 
		query.append("        ,''	mnr_wo_no" ).append("\n"); 
		query.append("        ,''	mnr_bar_qty" ).append("\n"); 
		query.append("        ,''	mnr_flg_rmk" ).append("\n"); 
		query.append("        ,''	eac_if_flg" ).append("\n"); 
		query.append("FROM    DUAL" ).append("\n"); 

	}
}