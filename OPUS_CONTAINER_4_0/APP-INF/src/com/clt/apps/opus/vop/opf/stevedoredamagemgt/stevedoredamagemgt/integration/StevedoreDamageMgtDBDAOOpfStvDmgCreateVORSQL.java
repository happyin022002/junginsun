/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : StevedoreDamageMgtDBDAOOpfStvDmgCreateVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.18
*@LastModifier : 장석현
*@LastVersion : 1.0
* 2009.11.18 장석현
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.opf.stevedoredamagemgt.stevedoredamagemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jang Suk Hyun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class StevedoreDamageMgtDBDAOOpfStvDmgCreateVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public StevedoreDamageMgtDBDAOOpfStvDmgCreateVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stv_dmg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.opf.stevedoredamagemgt.stevedoredamagemgt.integration").append("\n"); 
		query.append("FileName : StevedoreDamageMgtDBDAOOpfStvDmgCreateVORSQL").append("\n"); 
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
		query.append("dmg.stv_dmg_no" ).append("\n"); 
		query.append(",	dmg.vsl_cd" ).append("\n"); 
		query.append(",	dmg.skd_voy_no" ).append("\n"); 
		query.append(",	dmg.skd_dir_cd" ).append("\n"); 
		query.append(",	dmg.vps_port_cd" ).append("\n"); 
		query.append(",	TO_CHAR(dmg.stv_dmg_evnt_dt, 'YYYY-MM-DD') AS stv_dmg_evnt_dt" ).append("\n"); 
		query.append(",	dmg.vsl_oshp_cntr_blk_tp_cd" ).append("\n"); 
		query.append(",	dmg.stv_dmg_ref_no" ).append("\n"); 
		query.append(",	dmg.clm_hndl_ofc_cd" ).append("\n"); 
		query.append(",	dmg.dmg_auth_sts_cd" ).append("\n"); 
		query.append(",	dmg.auth_usr_id" ).append("\n"); 
		query.append(",	TO_CHAR(dmg.auth_dt, 'YYYY-MM-DD') AS auth_dt" ).append("\n"); 
		query.append(",	dmg.cre_usr_id" ).append("\n"); 
		query.append(",	dmg.upd_usr_id" ).append("\n"); 
		query.append(",	(select ofc_cd from com_user" ).append("\n"); 
		query.append("where usr_id = dmg.cre_usr_id) AS cre_usr_ofc" ).append("\n"); 
		query.append(",	dmgDtl.stv_dmg_no" ).append("\n"); 
		query.append(",	dmgDtl.stv_dmg_prt_cate_cd" ).append("\n"); 
		query.append(",	dmgDtl.stv_dmg_prt_cd" ).append("\n"); 
		query.append(",	dmgDtl.stv_dmg_tp_cd" ).append("\n"); 
		query.append(",	dmgDtl.stv_dmg_loc_desc" ).append("\n"); 
		query.append(",	dmgDtl.stv_dmg_rpt_atch_flg" ).append("\n"); 
		query.append(",	dmgDtl.stv_dmg_pict_atch_flg" ).append("\n"); 
		query.append(",	dmgDtl.stv_dmg_doc_atch_flg" ).append("\n"); 
		query.append(",	dmgDtl.cntr_dmg_flg" ).append("\n"); 
		query.append(",	dmgDtl.cgo_dmg_flg" ).append("\n"); 
		query.append(",	dmgDtl.cntr_no" ).append("\n"); 
		query.append(",	TO_CHAR(dmgDtl.fm_tm_lss_dt, 'YYYY-MM-DD HH24:MI') AS fm_tm_lss_dt" ).append("\n"); 
		query.append(",	TO_CHAR(dmgDtl.to_tm_lss_dt, 'YYYY-MM-DD HH24:MI') AS to_tm_lss_dt" ).append("\n"); 
		query.append(",	dmgDtl.stv_dmg_rmk" ).append("\n"); 
		query.append(",	dmgDtl.stv_dmg_req_cate_cd" ).append("\n"); 
		query.append(",	dmgDtl.req_vsl_cd" ).append("\n"); 
		query.append(",	dmgDtl.req_skd_voy_no" ).append("\n"); 
		query.append(",	dmgDtl.req_skd_dir_cd" ).append("\n"); 
		query.append(",	dmgDtl.req_port_cd" ).append("\n"); 
		query.append(",	TO_CHAR(dmgDtl.req_eta_dt, 'YYYY-MM-DD') AS req_eta_dt" ).append("\n"); 
		query.append(",	dmgDtl.stv_dmg_qttn_cd" ).append("\n"); 
		query.append(",	dmgDtl.stv_dmg_qttn_rsn_desc" ).append("\n"); 
		query.append(",	dmgDtl.stv_dmg_respb_pty_kwn_flg" ).append("\n"); 
		query.append(",	dmgDtl.stv_dmg_respb_cd" ).append("\n"); 
		query.append(",	dmgDtl.stv_dmg_respb_desc" ).append("\n"); 
		query.append(",	dmgDtl.dmg_eml_snd_no" ).append("\n"); 
		query.append(",	(SELECT COUNT(*) AS CNT FROM OPF_STV_DMG_RPR WHERE STV_DMG_NO = dmg.stv_dmg_no)" ).append("\n"); 
		query.append("+(SELECT COUNT(*) AS CNT FROM OPF_STV_DMG_CMPN WHERE STV_DMG_NO = dmg.stv_dmg_no)" ).append("\n"); 
		query.append("+(SELECT COUNT(*) AS CNT FROM OPF_STV_DMG_STL WHERE STV_DMG_NO = dmg.stv_dmg_no) AS step_cnt" ).append("\n"); 
		query.append(",(SELECT COUNT(*) AS CNT" ).append("\n"); 
		query.append("FROM OPF_STV_DMG_ATCH_FILE" ).append("\n"); 
		query.append("WHERE STV_DMG_NO     = dmg.stv_dmg_no" ).append("\n"); 
		query.append("AND STV_DMG_PROC_CD = 'D'" ).append("\n"); 
		query.append("AND STV_DMG_ATCH_FILE_TP_CD = 'SDR') AS stv_dmg_rpt_atch_knt --SDR Count" ).append("\n"); 
		query.append(",(SELECT COUNT(*) AS CNT" ).append("\n"); 
		query.append("FROM OPF_STV_DMG_ATCH_FILE" ).append("\n"); 
		query.append("WHERE STV_DMG_NO     = dmg.stv_dmg_no" ).append("\n"); 
		query.append("AND STV_DMG_PROC_CD = 'D'" ).append("\n"); 
		query.append("AND STV_DMG_ATCH_FILE_TP_CD = 'PIC') AS stv_dmg_pict_atch_knt --PIC Count" ).append("\n"); 
		query.append(",(SELECT COUNT(*) AS CNT" ).append("\n"); 
		query.append("FROM OPF_STV_DMG_ATCH_FILE" ).append("\n"); 
		query.append("WHERE STV_DMG_NO     = dmg.stv_dmg_no" ).append("\n"); 
		query.append("AND STV_DMG_PROC_CD = 'D'" ).append("\n"); 
		query.append("AND STV_DMG_ATCH_FILE_TP_CD = 'DOC') AS stv_dmg_doc_atch_knt --DOC Count" ).append("\n"); 
		query.append(",'' AS seq" ).append("\n"); 
		query.append("FROM opf_stv_dmg dmg, opf_stv_dmg_dtl dmgDtl" ).append("\n"); 
		query.append("WHERE	dmg.stv_dmg_no LIKE @[stv_dmg_no]||'%'" ).append("\n"); 
		query.append("AND	dmg.stv_dmg_no = dmgDtl.stv_dmg_no" ).append("\n"); 

	}
}