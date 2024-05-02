/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : WorkOrderPreviewDBDAOSearchEdi102297ShDelRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.21
*@LastModifier : 신동일
*@LastVersion : 1.0
* 2015.07.21 신동일
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.workordermanage.workorderpreview.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author DONG- IL, SHIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WorkOrderPreviewDBDAOSearchEdi102297ShDelRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchEdi_102297_SH_DEL
	  * </pre>
	  */
	public WorkOrderPreviewDBDAOSearchEdi102297ShDelRSQL(){
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
		query.append("FileName : WorkOrderPreviewDBDAOSearchEdi102297ShDelRSQL").append("\n"); 
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
		query.append("SELECT so.to_nod_cd del_cy" ).append("\n"); 
		query.append(" 		,yd_nm del_cy_nm" ).append("\n"); 
		query.append(" 		,DECODE(so.trsp_cost_dtl_mod_cd,'TS',so.ob_vvd_cd,DECODE(so.trsp_bnd_cd, 'I',so.ib_vvd_cd,so.ob_vvd_cd)) out_vvd" ).append("\n"); 
		query.append(" 		,vsl_eng_nm vsl_eng_nm" ).append("\n"); 
		query.append(" 		,SUBSTR(DECODE(so.trsp_cost_dtl_mod_cd,'TS',so.ob_vvd_cd,DECODE(so.trsp_bnd_cd, 'I',so.ib_vvd_cd,so.ob_vvd_cd)),5) voy_dir" ).append("\n"); 
		query.append(" 		,TO_CHAR(vps.vps_eta_dt,'YYYYMMDD') eta_dt" ).append("\n"); 
		query.append(" 		,SUM(DECODE(SUBSTR(so.eq_tpsz_cd,2,1),'2',1,0)) qty_teu_s" ).append("\n"); 
		query.append(" 		,SUM(DECODE(SUBSTR(so.eq_tpsz_cd,2,1),'2',0,1)) qty_feu_s" ).append("\n"); 
		query.append(" 		,ROUND(SUM(DECODE(SUBSTR(so.eq_tpsz_cd,2,1),'2',DECODE(so.wgt_meas_ut_cd ,'LBS',cntr_wgt/2.2,cntr_wgt),0)),2) wgt_teu_s" ).append("\n"); 
		query.append(" 		,ROUND(SUM(DECODE(SUBSTR(so.eq_tpsz_cd,2,1),'2',0,DECODE(so.wgt_meas_ut_cd ,'LBS',cntr_wgt/2.2,cntr_wgt) )),2) wgt_feu_s" ).append("\n"); 
		query.append(" 		,SUM(NVL(so.bzc_amt,0) + NVL(so.nego_amt,0)+ NVL(so.etc_add_amt,0) + NVL(so.toll_fee_amt,0))	amt_s" ).append("\n"); 
		query.append(" 	FROM mdm_yard yd" ).append("\n"); 
		query.append("     	,mdm_vsl_cntr vc" ).append("\n"); 
		query.append("     	,vsk_vsl_port_skd vps" ).append("\n"); 
		query.append("     	,trs_trsp_wrk_ord wo" ).append("\n"); 
		query.append("     	,trs_trsp_svc_ord so" ).append("\n"); 
		query.append("   WHERE so.delt_flg <> 'Y'					            " ).append("\n"); 
		query.append(" 	 AND wo.trsp_wo_ofc_cty_cd = @[trsp_wo_ofc_cty_cd]" ).append("\n"); 
		query.append(" 	 AND wo.trsp_wo_seq = @[trsp_wo_seq]" ).append("\n"); 
		query.append(" 	 AND wo.trsp_wo_ofc_cty_cd = so.trsp_wo_ofc_cty_cd             " ).append("\n"); 
		query.append(" 	 AND wo.trsp_wo_seq = so.trsp_wo_seq                    " ).append("\n"); 
		query.append(" 	 AND so.to_nod_cd	= yd.yd_cd                          " ).append("\n"); 
		query.append("	 AND NVL(SUBSTR(DECODE(so.trsp_bnd_cd, 'T',so.ib_vvd_cd,'I',so.ib_vvd_cd,'O',so.ob_vvd_cd) ,1,4),SO.VSL_CD)= vc.vsl_cd" ).append("\n"); 
		query.append("	 AND NVL(SUBSTR(DECODE(so.trsp_bnd_cd, 'T',so.ib_vvd_cd,'I',so.ib_vvd_cd,'O',so.ob_vvd_cd) ,1,4),SO.VSL_CD)= vps.vsl_cd (+)" ).append("\n"); 
		query.append("	 AND NVL(SUBSTR(DECODE(so.trsp_bnd_cd, 'T',so.ib_vvd_cd,'I',so.ib_vvd_cd,'O',so.ob_vvd_cd) ,5,4),SO.SKD_VOY_NO)= vps.skd_voy_no(+)" ).append("\n"); 
		query.append("	 AND NVL(SUBSTR(DECODE(so.trsp_bnd_cd, 'T',so.ib_vvd_cd,'I',so.ib_vvd_cd,'O',so.ob_vvd_cd) ,9,1),SO.SKD_DIR_CD)= vps.skd_dir_cd(+)		" ).append("\n"); 
		query.append(" 	 AND SUBSTR(so.fm_nod_cd,1,5) = vps.vps_port_cd (+)" ).append("\n"); 
		query.append(" 	 AND vps.clpt_ind_seq(+) =1" ).append("\n"); 
		query.append(" 	 AND so.hjl_no IS NULL" ).append("\n"); 
		query.append(" 	 AND wo.hjl_no IS NULL" ).append("\n"); 
		query.append("GROUP BY so.to_nod_cd" ).append("\n"); 
		query.append(" 		,yd_nm" ).append("\n"); 
		query.append(" 		,DECODE(so.trsp_cost_dtl_mod_cd,'TS',so.ob_vvd_cd, DECODE(so.trsp_bnd_cd, 'I',so.ib_vvd_cd, so.ob_vvd_cd))" ).append("\n"); 
		query.append(" 		,vsl_eng_nm" ).append("\n"); 
		query.append(" 		,SUBSTR(so.ob_vvd_cd,5)" ).append("\n"); 
		query.append(" 		,vps.vps_eta_dt" ).append("\n"); 

	}
}