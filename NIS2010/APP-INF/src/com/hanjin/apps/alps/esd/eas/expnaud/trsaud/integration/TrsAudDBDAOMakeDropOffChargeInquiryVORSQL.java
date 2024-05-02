/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : TrsAudDBDAOMakeDropOffChargeInquiryVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.02
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.02 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.expnaud.trsaud.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TrsAudDBDAOMakeDropOffChargeInquiryVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Drop-Off Charge Inquiry 조회
	  * </pre>
	  */
	public TrsAudDBDAOMakeDropOffChargeInquiryVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.expnaud.trsaud.integration").append("\n"); 
		query.append("FileName : TrsAudDBDAOMakeDropOffChargeInquiryVORSQL").append("\n"); 
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
		query.append("SELECT	 '' s_ecc" ).append("\n"); 
		query.append("		,''	s_loc" ).append("\n"); 
		query.append("        ,''	s_bkg_no" ).append("\n"); 
		query.append("        ,''	s_cntr_tpsz" ).append("\n"); 
		query.append("        ,''	s_cntr_no" ).append("\n"); 
		query.append("        ,''	s_fm_dt" ).append("\n"); 
		query.append("        ,''	s_to_dt" ).append("\n"); 
		query.append("        ,''	s_de_term_cd" ).append("\n"); 
		query.append("        ,''	s_eac_if" ).append("\n"); 
		query.append("        ,''	s_cust_tp_cd" ).append("\n"); 
		query.append("        ,''	s_cust_cd" ).append("\n"); 
		query.append("        ,''	s_cust_nm" ).append("\n"); 
		query.append("        ,''	chk" ).append("\n"); 
		query.append("        ,''	ecc_cd" ).append("\n"); 
		query.append("        ,''	bkg_sts_cd" ).append("\n"); 
		query.append("        ,''	cntr_no" ).append("\n"); 
		query.append("        ,''	cntr_tpsz_cd" ).append("\n"); 
		query.append("        ,''	bkg_no" ).append("\n"); 
		query.append("        ,''	por_cd" ).append("\n"); 
		query.append("        ,''	pol_cd" ).append("\n"); 
		query.append("        ,''	pod_cd" ).append("\n"); 
		query.append("        ,''	del_cd" ).append("\n"); 
		query.append("        ,''	de_term_cd" ).append("\n"); 
		query.append("        ,''	shp_cd" ).append("\n"); 
		query.append("        ,''	cne_cd" ).append("\n"); 
		query.append("        ,''	del_yd_cd" ).append("\n"); 
		query.append("        ,''	act_rtn_yd_cd" ).append("\n"); 
		query.append("        ,''	sc_no" ).append("\n"); 
		query.append("        ,''	rfa_no" ).append("\n"); 
		query.append("        ,''	bkg_scg_cd" ).append("\n"); 
		query.append("        ,''	bkg_scg_cur_cd" ).append("\n"); 
		query.append("        ,''	bkg_scg_rat_ut_cd" ).append("\n"); 
		query.append("        ,''	bkg_scg_amt" ).append("\n"); 
		query.append("        ,''	bkg_scg_term_nm" ).append("\n"); 
		query.append("        ,''	tpb_no" ).append("\n"); 
		query.append("        ,''	tpb_amt" ).append("\n"); 
		query.append("        ,''	eac_if_flg" ).append("\n"); 
		query.append("FROM	DUAL" ).append("\n"); 

	}
}