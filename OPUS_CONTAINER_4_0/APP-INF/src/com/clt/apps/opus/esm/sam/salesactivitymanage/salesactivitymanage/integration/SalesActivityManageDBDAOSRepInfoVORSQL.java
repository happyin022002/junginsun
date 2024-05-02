/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : SalesActivityManageDBDAOSRepInfoVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.06.16
*@LastModifier : 김보배
*@LastVersion : 1.0
* 2011.06.16 김보배
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.sam.salesactivitymanage.salesactivitymanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author BOBAE KIM
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SalesActivityManageDBDAOSRepInfoVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Sales Report Informaion 관련 VO 생성 쿼리
	  * </pre>
	  */
	public SalesActivityManageDBDAOSRepInfoVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.sam.salesactivitymanage.salesactivitymanage.integration").append("\n"); 
		query.append("FileName : SalesActivityManageDBDAOSRepInfoVORSQL").append("\n"); 
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
		query.append("SELECT ' ' cust_cd" ).append("\n"); 
		query.append("	 , ' ' cust_cnt_cd" ).append("\n"); 
		query.append("     , ' ' cust_seq" ).append("\n"); 
		query.append("     , ' ' cust_lgl_eng_nm" ).append("\n"); 
		query.append("     , ' ' sls_act_seq" ).append("\n"); 
		query.append("     , ' ' sls_act_act_dt" ).append("\n"); 
		query.append("     , ' ' srep_cd" ).append("\n"); 
		query.append("     , ' ' srep_nm" ).append("\n"); 
		query.append("     , ' ' cntc_pson_nm" ).append("\n"); 
		query.append("     , ' ' sls_rpt_clss_cd" ).append("\n"); 
		query.append("     , ' ' sls_rpt_smry_desc" ).append("\n"); 
		query.append("     , ' ' prb_clss_cd" ).append("\n"); 
		query.append("     , ' ' prb_desc" ).append("\n"); 
		query.append("     , ' ' sgs_clss_cd" ).append("\n"); 
		query.append("     , ' ' sgs_desc" ).append("\n"); 
		query.append("     , ' ' nxt_pln_clss_cd" ).append("\n"); 
		query.append("     , ' ' nxt_pln_desc" ).append("\n"); 
		query.append("     , ' ' vst_plc_ctnt" ).append("\n"); 
		query.append("     , ' ' sls_prmt_desc" ).append("\n"); 
		query.append("     , ' ' biz_area_cd" ).append("\n"); 
		query.append("	 , ' ' cre_usr_id" ).append("\n"); 
		query.append("	 , ' ' cre_dt" ).append("\n"); 
		query.append("	 , ' ' upd_usr_id" ).append("\n"); 
		query.append("	 , ' ' upd_dt" ).append("\n"); 
		query.append("	 , ' ' user_id" ).append("\n"); 
		query.append("	 , ' ' user_name" ).append("\n"); 
		query.append("	 , ' ' free_rpt_ctnt" ).append("\n"); 
		query.append("	 , ' ' ats" ).append("\n"); 
		query.append("	 , ' ' boc" ).append("\n"); 
		query.append("	 , ' ' cah" ).append("\n"); 
		query.append("	 , ' ' clh" ).append("\n"); 
		query.append("	 , ' ' cun" ).append("\n"); 
		query.append("	 , ' ' dob" ).append("\n"); 
		query.append("	 , ' ' eqs" ).append("\n"); 
		query.append("	 , ' ' qur" ).append("\n"); 
		query.append("	 , ' ' rel" ).append("\n"); 
		query.append("	 , ' ' scr" ).append("\n"); 
		query.append("	 , ' ' sep" ).append("\n"); 
		query.append("	 , ' ' ses" ).append("\n"); 
		query.append("	 , ' ' usf" ).append("\n"); 
		query.append("	 , ' ' ses_rsn" ).append("\n"); 
		query.append("	 , ' ' scr_rsn" ).append("\n"); 
		query.append("	 , ' ' eqs_rsn" ).append("\n"); 
		query.append("	 , ' ' cah_rsn" ).append("\n"); 
		query.append("	 , ' ' sep_rsn" ).append("\n"); 
		query.append("	 , ' ' rel_rsn" ).append("\n"); 
		query.append("	 , ' ' usf_rsn" ).append("\n"); 
		query.append("	 , ' ' boc_rsn" ).append("\n"); 
		query.append("	 , ' ' dob_rsn" ).append("\n"); 
		query.append("	 , ' ' ats_rsn" ).append("\n"); 
		query.append("	 , ' ' clh_rsn" ).append("\n"); 
		query.append("	 , ' ' qur_rsn" ).append("\n"); 
		query.append("	 , ' ' cun_rsn" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	 , ' ' wh_sh_b_imp" ).append("\n"); 
		query.append("	 , ' ' cust_recom" ).append("\n"); 
		query.append("	 , ' ' stfc_rep_comp" ).append("\n"); 
		query.append("	 , ' ' stfc_rsn" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	 , ' ' wsi_rsn" ).append("\n"); 
		query.append("	 , ' ' cur_rsn" ).append("\n"); 
		query.append("	 , ' ' src_rsn" ).append("\n"); 
		query.append("	 , ' ' wsi" ).append("\n"); 
		query.append("	 , ' ' cur" ).append("\n"); 
		query.append("	 , ' ' src" ).append("\n"); 
		query.append("	 , ' ' src" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	 , '' grd" ).append("\n"); 
		query.append("	 , '' rsn" ).append("\n"); 
		query.append("     , '' cust_satsfc_itm_cd" ).append("\n"); 
		query.append("FROM dual" ).append("\n"); 

	}
}