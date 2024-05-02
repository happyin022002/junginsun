/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : Edi315SendDBDAOEdi315SendOptionsRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.16
*@LastModifier : 이윤정
*@LastVersion : 1.0
* 2009.11.16 이윤정
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.edi315send.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee YounJung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Edi315SendDBDAOEdi315SendOptionsRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * for options create flat file
	  * </pre>
	  */
	public Edi315SendDBDAOEdi315SendOptionsRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.edi315send.integration").append("\n"); 
		query.append("FileName : Edi315SendDBDAOEdi315SendOptionsRSQL").append("\n"); 
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
		query.append("''edi_group_cd," ).append("\n"); 
		query.append("''group_seq," ).append("\n"); 
		query.append("''bkg_no," ).append("\n"); 
		query.append("''bkg_no_split," ).append("\n"); 
		query.append("''cntr_no," ).append("\n"); 
		query.append("''cntr_no_1, -- antinative of cntr_no" ).append("\n"); 
		query.append("''edi_sts," ).append("\n"); 
		query.append("''cntr_tpsz_cd," ).append("\n"); 
		query.append("''org_yd_cd," ).append("\n"); 
		query.append("''event_dt," ).append("\n"); 
		query.append("''nod," ).append("\n"); 
		query.append("''edi_grp_cd," ).append("\n"); 
		query.append("''host_tp_id," ).append("\n"); 
		query.append("''cust_tp_id," ).append("\n"); 
		query.append("''cust_edi_sts_cd," ).append("\n"); 
		query.append("''cnmv_full_flg," ).append("\n"); 
		query.append("''edi_snd_flg," ).append("\n"); 
		query.append("''cust_no," ).append("\n"); 
		query.append("''cop_no," ).append("\n"); 
		query.append("''call_from," ).append("\n"); 
		query.append("''cre_id," ).append("\n"); 
		query.append("''upd_id," ).append("\n"); 
		query.append("''cnmv_yr," ).append("\n"); 
		query.append("''cnmv_seq," ).append("\n"); 
		query.append("''dtl_seq," ).append("\n"); 
		query.append("''act_rcv_dt," ).append("\n"); 
		query.append("''rslt_snd_cnt," ).append("\n"); 
		query.append("''snd_seq," ).append("\n"); 
		query.append("''cust_cnt_cd," ).append("\n"); 
		query.append("''cust_seq," ).append("\n"); 
		query.append("''edi_snd_itval_hr," ).append("\n"); 
		query.append("''isSend_tp_cntr," ).append("\n"); 
		query.append("''v_message," ).append("\n"); 
		query.append("''v_error_code," ).append("\n"); 
		query.append("''act_rcv_if_key," ).append("\n"); 
		query.append("''curr_vvd," ).append("\n"); 
		query.append("''v_bound," ).append("\n"); 
		query.append("''org_edi_sts_cd," ).append("\n"); 
		query.append("''e_bkg_no," ).append("\n"); 
		query.append("''e_por_loc," ).append("\n"); 
		query.append("''e_pol_loc," ).append("\n"); 
		query.append("''e_pod_loc," ).append("\n"); 
		query.append("''e_del_loc," ).append("\n"); 
		query.append("''e_cop_no," ).append("\n"); 
		query.append("''cost_act_grp_seq" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}