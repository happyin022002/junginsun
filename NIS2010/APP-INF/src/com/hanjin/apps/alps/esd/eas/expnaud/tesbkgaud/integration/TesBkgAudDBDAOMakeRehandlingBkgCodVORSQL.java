/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : TesBkgAudDBDAOMakeRehandlingBkgCodVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.27
*@LastModifier : 최종혁
*@LastVersion : 1.0
* 2015.03.27 최종혁
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.expnaud.tesbkgaud.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CJH
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TesBkgAudDBDAOMakeRehandlingBkgCodVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VO for Rehandling(BKG COD)
	  * </pre>
	  */
	public TesBkgAudDBDAOMakeRehandlingBkgCodVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.expnaud.tesbkgaud.integration").append("\n"); 
		query.append("FileName : TesBkgAudDBDAOMakeRehandlingBkgCodVORSQL").append("\n"); 
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
		query.append("SELECT	 '' s_rhq_ofc_cd" ).append("\n"); 
		query.append("		,''	s_ofc_cd" ).append("\n"); 
		query.append("		,''	s_fm_dt " ).append("\n"); 
		query.append("		,''	s_to_dt " ).append("\n"); 
		query.append("		,''	s_scg_cd" ).append("\n"); 
		query.append("		,''	s_ca_item_cd" ).append("\n"); 
		query.append("		,''	s_vvd" ).append("\n"); 
		query.append("		,''	s_bkg_no" ).append("\n"); 
		query.append("		,''	s_eac_if" ).append("\n"); 
		query.append("		,''	chk" ).append("\n"); 
		query.append("		,''	seq" ).append("\n"); 
		query.append("		,''	bkg_no" ).append("\n"); 
		query.append("		,''	cntr_qty" ).append("\n"); 
		query.append("		,''	bkg_ofc_cd" ).append("\n"); 
		query.append("		,''	corr_ofc_cd" ).append("\n"); 
		query.append("		,''	corr_dt" ).append("\n"); 
		query.append("		,''	vvd" ).append("\n"); 
		query.append("        ,'' svc_scp_cd" ).append("\n"); 
		query.append("		,''	o_pod_cd" ).append("\n"); 
		query.append("		,''	o_del_cd" ).append("\n"); 
		query.append("		,''	o_rly_port_cd" ).append("\n"); 
		query.append("		,''	c_pod_cd" ).append("\n"); 
		query.append("		,''	c_del_cd" ).append("\n"); 
		query.append("		,''	c_rly_port_cd" ).append("\n"); 
		query.append("		,''	corr_no" ).append("\n"); 
		query.append("		,''	bkg_corr_rmk" ).append("\n"); 
		query.append("		,''	corr_usr_nm" ).append("\n"); 
		query.append("		,''	dvc_trf_itm_no" ).append("\n"); 
		query.append("		,''	dvc_curr_cd" ).append("\n"); 
		query.append("		,''	dvc_chg_amt" ).append("\n"); 
		query.append("		,''	dvc_chg_usd_amt" ).append("\n"); 
		query.append("		,''	dvc_rat_as_qty" ).append("\n"); 
		query.append("		,''	dvc_incl_oft_flg" ).append("\n"); 
		query.append("		,''	och_trf_itm_no" ).append("\n"); 
		query.append("		,''	och_curr_cd" ).append("\n"); 
		query.append("		,''	och_chg_amt" ).append("\n"); 
		query.append("		,''	och_chg_usd_amt" ).append("\n"); 
		query.append("		,''	och_rat_as_qty" ).append("\n"); 
		query.append("		,''	och_incl_oft_flg" ).append("\n"); 
		query.append("		,''	dch_trf_itm_no" ).append("\n"); 
		query.append("		,''	dch_curr_cd" ).append("\n"); 
		query.append("		,''	dch_chg_amt" ).append("\n"); 
		query.append("		,''	dch_chg_usd_amt" ).append("\n"); 
		query.append("		,''	dch_rat_as_qty" ).append("\n"); 
		query.append("		,''	dch_incl_oft_flg" ).append("\n"); 
		query.append("		,''	mis_trf_itm_no" ).append("\n"); 
		query.append("		,''	mis_curr_cd" ).append("\n"); 
		query.append("		,''	mis_chg_amt" ).append("\n"); 
		query.append("		,''	mis_chg_usd_amt" ).append("\n"); 
		query.append("		,''	mis_rat_as_qty" ).append("\n"); 
		query.append("		,''	mis_incl_oft_flg" ).append("\n"); 
		query.append("		,''	eac_if_flg" ).append("\n"); 
		query.append("FROM	DUAL" ).append("\n"); 

	}
}