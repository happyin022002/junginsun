/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : Edi315SendDBDAOEdi315DetailRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.06.08
*@LastModifier : 이윤정
*@LastVersion : 1.0
* 2010.06.08 이윤정
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.edi315send.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Yoonjung Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Edi315SendDBDAOEdi315DetailRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * for Esi315Detail
	  * </pre>
	  */
	public Edi315SendDBDAOEdi315DetailRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.edi315send.integration").append("\n"); 
		query.append("FileName : Edi315SendDBDAOEdi315DetailRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("''rcv_dt," ).append("\n"); 
		query.append("''rcv_seq," ).append("\n"); 
		query.append("''rcv_dtl_seq," ).append("\n"); 
		query.append("''edi_grp_cd," ).append("\n"); 
		query.append("''host_tp_id," ).append("\n"); 
		query.append("''cust_tp_id," ).append("\n"); 
		query.append("--''cust_cnt_cd," ).append("\n"); 
		query.append("--''cust_seq," ).append("\n"); 
		query.append("''cust_no," ).append("\n"); 
		query.append("--''sc_no," ).append("\n"); 
		query.append("''org_edi_sts," ).append("\n"); 
		query.append("--''send_flg," ).append("\n"); 
		query.append("''log_flg," ).append("\n"); 
		query.append("''edi_sts," ).append("\n"); 
		query.append("''cust_edi_sts_cd," ).append("\n"); 
		query.append("''co_div_cd," ).append("\n"); 
		query.append("''edi_evnt_cd," ).append("\n"); 
		query.append("''edi_vsl_tp_cd," ).append("\n"); 
		query.append("''edi_snd_itval_hrmnt," ).append("\n"); 
		query.append("''edi_cntr_snd_tp_cd," ).append("\n"); 
		query.append("''org_conti_desc," ).append("\n"); 
		query.append("''org_dest_cnt_desc," ).append("\n"); 
		query.append("''dest_conti_desc," ).append("\n"); 
		query.append("''dest_cnt_desc," ).append("\n"); 
		query.append("''edi_cgo_rmk," ).append("\n"); 
		query.append("''edi_auto_snd_flg," ).append("\n"); 
		query.append("''edi_rmk1," ).append("\n"); 
		query.append("''edi_rmk2," ).append("\n"); 
		query.append("''edi_rmk3," ).append("\n"); 
		query.append("''cre_usr_id," ).append("\n"); 
		query.append("''cre_dt," ).append("\n"); 
		query.append("''upd_usr_id," ).append("\n"); 
		query.append("''upd_dt," ).append("\n"); 
		query.append("''bkg_no," ).append("\n"); 
		query.append("''bl_no," ).append("\n"); 
		query.append("''cop_no," ).append("\n"); 
		query.append("''cntr_no," ).append("\n"); 
		query.append("''rslt_flg," ).append("\n"); 
		query.append("''edi_snd_rslt_rmk  ," ).append("\n"); 
		query.append("''snd_skip_flg  ," ).append("\n"); 
		query.append("--master VO ObjectCloner Start !!" ).append("\n"); 
		query.append("''cntr_tpsz_cd," ).append("\n"); 
		query.append("''cop_rail_chk_cd," ).append("\n"); 
		query.append("''trunk_vvd," ).append("\n"); 
		query.append("''cop_sts_cd," ).append("\n"); 
		query.append("''por_nod_cd," ).append("\n"); 
		query.append("''pol_nod_cd," ).append("\n"); 
		query.append("''pod_nod_cd," ).append("\n"); 
		query.append("''del_nod_cd," ).append("\n"); 
		query.append("''por_cd," ).append("\n"); 
		query.append("''pol_cd," ).append("\n"); 
		query.append("''pod_cd," ).append("\n"); 
		query.append("''del_cd," ).append("\n"); 
		query.append("''sc_no," ).append("\n"); 
		query.append("''bl_tp_cd," ).append("\n"); 
		query.append("''to_vsl," ).append("\n"); 
		query.append("''to_voyage," ).append("\n"); 
		query.append("''to_dir," ).append("\n"); 
		query.append("''pre_rly," ).append("\n"); 
		query.append("''post_rly," ).append("\n"); 
		query.append("''BKG_CRE_TP_CD," ).append("\n"); 
		query.append("''ORG_CONTI," ).append("\n"); 
		query.append("''DEST_CONTI," ).append("\n"); 
		query.append("''RCV_TERM_CD," ).append("\n"); 
		query.append("''DE_TERM_CD," ).append("\n"); 
		query.append("''DCGO_FLG," ).append("\n"); 
		query.append("''vsl_nm," ).append("\n"); 
		query.append("''vsl_cnt_cd," ).append("\n"); 
		query.append("''lloyd_cd" ).append("\n"); 
		query.append("--master VO ObjectCloner End !!" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}