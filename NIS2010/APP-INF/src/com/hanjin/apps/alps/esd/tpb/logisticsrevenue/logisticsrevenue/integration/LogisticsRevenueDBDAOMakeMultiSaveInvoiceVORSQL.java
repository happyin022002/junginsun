/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : LogisticsRevenueDBDAOMakeMultiSaveInvoiceVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.09
*@LastModifier : 
*@LastVersion : 1.0
* 2015.01.09 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.logisticsrevenue.logisticsrevenue.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class LogisticsRevenueDBDAOMakeMultiSaveInvoiceVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MakeMultiSaveInvoiceVO
	  * </pre>
	  */
	public LogisticsRevenueDBDAOMakeMultiSaveInvoiceVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tpb.logisticsrevenue.logisticsrevenue.integration").append("\n"); 
		query.append("FileName : LogisticsRevenueDBDAOMakeMultiSaveInvoiceVORSQL").append("\n"); 
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
		query.append("SELECT	'' s_n3pty_if_tp_cd, " ).append("\n"); 
		query.append("		'' s_n3pty_expn_tp_cd," ).append("\n"); 
		query.append("		'' s_n3pty_bil_tp_cd," ).append("\n"); 
		query.append("		'' s_if_ofc_cd," ).append("\n"); 
		query.append("		'' s_sdate," ).append("\n"); 
		query.append("		'' s_edate," ).append("\n"); 
		query.append("		'' s_curr," ).append("\n"); 
		query.append("        '' s_src_vndr_cnt_cd," ).append("\n"); 
		query.append("        '' s_src_vndr_seq," ).append("\n"); 
		query.append("		'' s_trd_party_val,    /* s_trd_party_val 2 자리 s_vndr_cnt_cd 나머지 s_vndr_cnt_seq  */" ).append("\n"); 
		query.append("        '' s_vndr_cnt_cd," ).append("\n"); 
		query.append("        '' s_vndr_seq," ).append("\n"); 
		query.append("        '' s_src_inv_no," ).append("\n"); 
		query.append("        '' s_bkg_no," ).append("\n"); 
		query.append("        '' s_yd_cd," ).append("\n"); 
		query.append("        '' s_new_bkg," ).append("\n"); 
		query.append("        '' s_cntr_rtn_yd_cd," ).append("\n"); 
		query.append("        '' s_cntr_rtn_dt," ).append("\n"); 
		query.append("        '' s_rev_inv_rt," ).append("\n"); 
		query.append("        '' s_inv_amt," ).append("\n"); 
		query.append("        '' s_tax," ).append("\n"); 
		query.append("		'' s_total,	/* inv amount + tax */" ).append("\n"); 
		query.append("        '' s_ttl_amt," ).append("\n"); 
		query.append("        '' s_user_ofc_cd," ).append("\n"); 
		query.append("        '' s_user_id," ).append("\n"); 
		query.append("		'' s_n3pty_no," ).append("\n"); 
		query.append("		'' s_n3pty_inv_no," ).append("\n"); 
		query.append("		'' s_re_yd_cd" ).append("\n"); 
		query.append("FROM 	DUAL" ).append("\n"); 

	}
}