/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : WorkOrderPreviewDBDAOSearchEdi102297DrdgHeadRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.11.04
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2011.11.04 민정호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.workordermanage.workorderpreview.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Min Jung Ho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WorkOrderPreviewDBDAOSearchEdi102297DrdgHeadRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchEdi_102297_DRBG_HEAD
	  * </pre>
	  */
	public WorkOrderPreviewDBDAOSearchEdi102297DrdgHeadRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_wo_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_wo_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.workordermanage.workorderpreview.integration").append("\n"); 
		query.append("FileName : WorkOrderPreviewDBDAOSearchEdi102297DrdgHeadRSQL").append("\n"); 
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
		query.append("NVL(wo.trsp_wo_ofc_cty_cd||LPAD(wo.trsp_wo_seq, 17, '0'),@[trsp_wo_ofc_cty_cd]||LPAD(@[trsp_wo_seq], 17, '0')) AS wo_no" ).append("\n"); 
		query.append(",DECODE (wo.wo_iss_sts_cd,'I','C','R','U','C','U','N','X') purpose" ).append("\n"); 
		query.append(",TO_CHAR(wo.LOCL_CRE_DT,'YYYYMMDDHH24MI') snd_dt" ).append("\n"); 
		query.append(",'Hanjin Transportation (PUS Brandch)' receiver" ).append("\n"); 
		query.append(",usr.usr_nm sender" ).append("\n"); 
		query.append(",usr.xtn_phn_no tel_no" ).append("\n"); 
		query.append(",DECODE(so.trsp_crr_mod_cd,'TD','TR','WD','BR') trt_mode" ).append("\n"); 
		query.append(",SUM(DECODE(SUBSTR(so.eq_tpsz_cd,2,1),'2',1,0)) qty_teu_t" ).append("\n"); 
		query.append(",SUM(DECODE(SUBSTR(so.eq_tpsz_cd,2,1),'2',0,1)) qty_feu_t" ).append("\n"); 
		query.append(",so.curr_cd amt_cur" ).append("\n"); 
		query.append(",SUM(so.bzc_amt+so.nego_amt+so.etc_add_amt) amt_t" ).append("\n"); 
		query.append(",so.fm_nod_cd org_yd" ).append("\n"); 
		query.append(",so.to_nod_cd dest_yd" ).append("\n"); 
		query.append(",'' ins" ).append("\n"); 
		query.append(",wo.wo_rmk rmk" ).append("\n"); 
		query.append("FROM bkg_bkg_vvd vvd" ).append("\n"); 
		query.append(",com_user usr" ).append("\n"); 
		query.append(",mdm_yard yd" ).append("\n"); 
		query.append(",trs_trsp_wrk_ord wo" ).append("\n"); 
		query.append(",trs_trsp_svc_ord so" ).append("\n"); 
		query.append("WHERE so.delt_flg <> 'Y'" ).append("\n"); 
		query.append("AND wo.trsp_wo_ofc_cty_cd = @[trsp_wo_ofc_cty_cd]" ).append("\n"); 
		query.append("AND wo.trsp_wo_seq = @[trsp_wo_seq]" ).append("\n"); 
		query.append("AND wo.trsp_wo_ofc_cty_cd = so.trsp_wo_ofc_cty_cd" ).append("\n"); 
		query.append("AND wo.trsp_wo_seq = so.trsp_wo_seq" ).append("\n"); 
		query.append("AND wo.cre_usr_id = usr.usr_id" ).append("\n"); 
		query.append("AND so.fm_nod_cd = yd.yd_cd" ).append("\n"); 
		query.append("AND so.bkg_no = vvd.bkg_no(+)" ).append("\n"); 
		query.append("AND SUBSTR(so.fm_nod_cd,1,5) = SUBSTR(vvd.vsl_pod_cd(+) ,1,5)" ).append("\n"); 
		query.append("AND so.hjl_no IS NULL" ).append("\n"); 
		query.append("AND wo.hjl_no IS NULL" ).append("\n"); 
		query.append("GROUP BY wo.trsp_wo_ofc_cty_cd||LPAD(wo.trsp_wo_seq, 17, '0')" ).append("\n"); 
		query.append(",wo.wo_iss_sts_cd" ).append("\n"); 
		query.append(",wo.LOCL_CRE_DT" ).append("\n"); 
		query.append(",usr.usr_nm" ).append("\n"); 
		query.append(",usr.xtn_phn_no" ).append("\n"); 
		query.append(",so.trsp_crr_mod_cd" ).append("\n"); 
		query.append(",so.curr_cd" ).append("\n"); 
		query.append(",so.fm_nod_cd" ).append("\n"); 
		query.append(",so.to_nod_cd" ).append("\n"); 
		query.append(",wo.wo_rmk" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 

	}
}