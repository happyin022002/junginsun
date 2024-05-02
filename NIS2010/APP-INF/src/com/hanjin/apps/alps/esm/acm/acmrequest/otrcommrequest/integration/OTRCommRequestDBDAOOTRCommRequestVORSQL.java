/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : OTRCommRequestDBDAOOTRCommRequestVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.23
*@LastModifier : 김영오
*@LastVersion : 1.0
* 2012.04.23 김영오
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmrequest.otrcommrequest.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM YOUNG-OH
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OTRCommRequestDBDAOOTRCommRequestVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * OTRCommRequestVO
	  * </pre>
	  */
	public OTRCommRequestDBDAOOTRCommRequestVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.acm.acmrequest.otrcommrequest.integration ").append("\n"); 
		query.append("FileName : OTRCommRequestDBDAOOTRCommRequestVORSQL").append("\n"); 
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
		query.append("select" ).append("\n"); 
		query.append("'1' AS vndr_cnt_cd," ).append("\n"); 
		query.append("'1' AS curr_cd," ).append("\n"); 
		query.append("'1' AS vndr_lgl_eng_nm," ).append("\n"); 
		query.append("'1' AS agn_cd," ).append("\n"); 
		query.append("'1' AS usr_id," ).append("\n"); 
		query.append("'1' AS usr_eml," ).append("\n"); 
		query.append("'1' AS pay_if_amt," ).append("\n"); 
		query.append("'1' AS ac_sts_cd," ).append("\n"); 
		query.append("'1' AS ac_tp_cd," ).append("\n"); 
		query.append("'1' AS otr_comm_rmk," ).append("\n"); 
		query.append("'1' AS pay_xch_rt," ).append("\n"); 
		query.append("'1' AS comm_stnd_cost_cd," ).append("\n"); 
		query.append("'1' AS comm_yrmon," ).append("\n"); 
		query.append("'1' AS io_bnd_cd," ).append("\n"); 
		query.append("'1' AS apro_dt," ).append("\n"); 
		query.append("'1' AS ar_ofc_cd," ).append("\n"); 
		query.append("'1' AS vvd," ).append("\n"); 
		query.append("'1' AS bkg_no," ).append("\n"); 
		query.append("'1' AS usd_amt," ).append("\n"); 
		query.append("'1' AS ac_seq," ).append("\n"); 
		query.append("'1' AS otr_comm_no," ).append("\n"); 
		query.append("'1' AS ac_proc_desc," ).append("\n"); 
		query.append("'1' AS vndr_seq," ).append("\n"); 
		query.append("'1' AS ac_occr_info_cd," ).append("\n"); 
		query.append("'1' AS vvd_chk_yn," ).append("\n"); 
		query.append("'1' AS aply_dt," ).append("\n"); 
		query.append("'1' AS ap_ctr_cd," ).append("\n"); 
		query.append("'1' AS ofc_cd" ).append("\n"); 
		query.append("from dual" ).append("\n"); 

	}
}