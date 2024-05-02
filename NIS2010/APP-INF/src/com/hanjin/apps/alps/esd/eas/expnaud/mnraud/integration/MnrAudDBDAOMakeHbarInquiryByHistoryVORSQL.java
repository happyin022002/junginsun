/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : MnrAudDBDAOMakeHbarInquiryByHistoryVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.14
*@LastModifier : 
*@LastVersion : 1.0
* 2015.05.14 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.expnaud.mnraud.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MnrAudDBDAOMakeHbarInquiryByHistoryVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VO for HBar Inquiry by History
	  * </pre>
	  */
	public MnrAudDBDAOMakeHbarInquiryByHistoryVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.expnaud.mnraud.integration").append("\n"); 
		query.append("FileName : MnrAudDBDAOMakeHbarInquiryByHistoryVORSQL").append("\n"); 
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
		query.append("SELECT	 ''	s_fm_dt" ).append("\n"); 
		query.append("        ,''	s_to_dt" ).append("\n"); 
		query.append("        ,''	s_cnt_cd" ).append("\n"); 
		query.append("        ,''	s_loc_cd" ).append("\n"); 
		query.append("        ,''	s_yd_cd" ).append("\n"); 
		query.append("        ,''	s_cntr_no" ).append("\n"); 
		query.append("        ,''	s_wo_flg" ).append("\n"); 
		query.append("        ,''	s_eac_if" ).append("\n"); 
		query.append("		,'' s_reg_ofc_cd" ).append("\n"); 
		query.append("        ,''	chk" ).append("\n"); 
		query.append("        ,''	seq" ).append("\n"); 
		query.append("        ,''	rhq_cd" ).append("\n"); 
		query.append("        ,''	mnr_flg_yd_cd" ).append("\n"); 
		query.append("        ,''	reg_ofc_cd" ).append("\n"); 
		query.append("        ,''	eq_no" ).append("\n"); 
		query.append("        ,''	eq_tpsz_cd" ).append("\n"); 
		query.append("        ,''	hngr_bar_amd_qty" ).append("\n"); 
		query.append("        ,''	wo_no" ).append("\n"); 
		query.append("        ,''	wo_curr_cd" ).append("\n"); 
		query.append("        ,''	wo_amt" ).append("\n"); 
		query.append("        ,''	vndr_seq" ).append("\n"); 
		query.append("        ,''	vndr_nm" ).append("\n"); 
		query.append("        ,''	bkg_no" ).append("\n"); 
		query.append("        ,''	bkg_curr_cd" ).append("\n"); 
		query.append("        ,''	bkg_scg_amt" ).append("\n"); 
		query.append("        ,''	bkg_scg_mix_flg" ).append("\n"); 
		query.append("        ,''	por_nod_cd" ).append("\n"); 
		query.append("        ,''	pol_nod_cd" ).append("\n"); 
		query.append("		,'' oft_in" ).append("\n"); 
		query.append("FROM	DUAL" ).append("\n"); 

	}
}