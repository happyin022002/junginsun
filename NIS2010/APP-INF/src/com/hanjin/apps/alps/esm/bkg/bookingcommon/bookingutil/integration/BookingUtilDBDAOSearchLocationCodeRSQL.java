/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BookingUtilDBDAOSearchLocationCodeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.29
*@LastModifier : 김병규
*@LastVersion : 1.0
* 2009.06.29 김병규
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Byung Kyu
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingUtilDBDAOSearchLocationCodeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 특정 Location Code 를 조회한다.
	  * </pre>
	  */
	public BookingUtilDBDAOSearchLocationCodeRSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("SELECT" ).append("\n"); 
		query.append("loc_cd" ).append("\n"); 
		query.append(",	scc_cd" ).append("\n"); 
		query.append(",	loc_nm" ).append("\n"); 
		query.append(",	rgn_cd" ).append("\n"); 
		query.append(",	cnt_cd" ).append("\n"); 
		query.append(",	ste_cd" ).append("\n"); 
		query.append(",	conti_cd" ).append("\n"); 
		query.append(",	port_inlnd_cd" ).append("\n"); 
		query.append(",	loc_chr_cd" ).append("\n"); 
		query.append(",	blk_port_flg" ).append("\n"); 
		query.append(",	hub_loc_cd" ).append("\n"); 
		query.append(",	sls_ofc_cd" ).append("\n"); 
		query.append(",	loc_grd_no" ).append("\n"); 
		query.append(",	gmt_hrs" ).append("\n"); 
		query.append(",	bkg_bl_pfx_cd" ).append("\n"); 
		query.append(",	call_port_flg" ).append("\n"); 
		query.append(",	loc_ams_port_cd" ).append("\n"); 
		query.append(",	finc_ctrl_ofc_cd" ).append("\n"); 
		query.append(",	eq_ctrl_ofc_cd" ).append("\n"); 
		query.append(",	mty_pkup_yd_cd" ).append("\n"); 
		query.append(",	sen_eq_ofc_cd" ).append("\n"); 
		query.append(",	eq_rtn_yd_cd" ).append("\n"); 
		query.append(",	un_loc_ind_cd" ).append("\n"); 
		query.append(",	un_loc_cd" ).append("\n"); 
		query.append(",	cml_zn_flg" ).append("\n"); 
		query.append(",	cstms_cd" ).append("\n"); 
		query.append(",	loc_tp_cd" ).append("\n"); 
		query.append(",	bfr_finc_ctrl_ofc_cd" ).append("\n"); 
		query.append(",	bfr_eq_ctrl_ofc_cd" ).append("\n"); 
		query.append(",	bfr_sls_ofc_cd" ).append("\n"); 
		query.append(",	bfr_ofc_cng_dt" ).append("\n"); 
		query.append(",	rep_zn_cd" ).append("\n"); 
		query.append(",	zip_cd" ).append("\n"); 
		query.append(",	sconti_cd" ).append("\n"); 
		query.append(",	cre_usr_id" ).append("\n"); 
		query.append(",	cre_dt" ).append("\n"); 
		query.append(",	upd_usr_id" ).append("\n"); 
		query.append(",	upd_dt" ).append("\n"); 
		query.append(",	delt_flg" ).append("\n"); 
		query.append(",	eai_evnt_dt" ).append("\n"); 
		query.append(",	expt_lgs_ofc_cd" ).append("\n"); 
		query.append(",	expt_cust_svc_ofc_cd" ).append("\n"); 
		query.append(",	vop_port_rhq_cd" ).append("\n"); 
		query.append(",	vop_port_ctrl_ofc_cd" ).append("\n"); 
		query.append(",	vop_port_mntr_flg" ).append("\n"); 
		query.append(",	vop_loc_url" ).append("\n"); 
		query.append(",	vop_port_flg" ).append("\n"); 
		query.append("FROM mdm_location" ).append("\n"); 
		query.append("WHERE	loc_cd = @[loc_cd]" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.nis2010.esm.bkg.bookingcommon.bookingutil.integration").append("\n"); 
		query.append("FileName : BookingUtilDBDAOSearchLocationCodeRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}