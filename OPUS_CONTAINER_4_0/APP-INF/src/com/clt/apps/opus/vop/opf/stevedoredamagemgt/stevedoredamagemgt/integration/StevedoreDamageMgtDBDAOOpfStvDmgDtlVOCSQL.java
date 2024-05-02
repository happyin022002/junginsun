/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : StevedoreDamageMgtDBDAOOpfStvDmgDtlVOCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.05
*@LastModifier : 
*@LastVersion : 1.0
* 2015.01.05 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.opf.stevedoredamagemgt.stevedoredamagemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class StevedoreDamageMgtDBDAOOpfStvDmgDtlVOCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * OpfStvDmgDtlVO Insert Query
	  * </pre>
	  */
	public StevedoreDamageMgtDBDAOOpfStvDmgDtlVOCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stv_dmg_respb_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stv_dmg_rpt_atch_knt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stv_dmg_prt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_dmg_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stv_dmg_pict_atch_knt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stv_dmg_loc_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_tm_lss_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("req_vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stv_dmg_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stv_dmg_rpt_atch_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stv_dmg_respb_pty_kwn_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("req_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmg_eml_snd_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stv_dmg_doc_atch_knt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_tm_lss_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stv_dmg_qttn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stv_dmg_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stv_dmg_prt_cate_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("req_skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stv_dmg_req_cate_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stv_dmg_doc_atch_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stv_dmg_pict_atch_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stv_dmg_qttn_rsn_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stv_dmg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cgo_dmg_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("req_skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stv_dmg_respb_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("req_eta_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.opf.stevedoredamagemgt.stevedoredamagemgt.integration").append("\n"); 
		query.append("FileName : StevedoreDamageMgtDBDAOOpfStvDmgDtlVOCSQL").append("\n"); 
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
		query.append("INSERT INTO OPF_STV_DMG_DTL (" ).append("\n"); 
		query.append("	STV_DMG_NO" ).append("\n"); 
		query.append(",	STV_DMG_PRT_CATE_CD" ).append("\n"); 
		query.append(",	STV_DMG_PRT_CD" ).append("\n"); 
		query.append(",	STV_DMG_TP_CD" ).append("\n"); 
		query.append(",	STV_DMG_LOC_DESC" ).append("\n"); 
		query.append(",	STV_DMG_RPT_ATCH_FLG" ).append("\n"); 
		query.append(",	STV_DMG_PICT_ATCH_FLG" ).append("\n"); 
		query.append(",	STV_DMG_DOC_ATCH_FLG" ).append("\n"); 
		query.append(",	CNTR_DMG_FLG" ).append("\n"); 
		query.append(",	CGO_DMG_FLG" ).append("\n"); 
		query.append(",	CNTR_NO" ).append("\n"); 
		query.append(",	FM_TM_LSS_DT" ).append("\n"); 
		query.append(",	TO_TM_LSS_DT" ).append("\n"); 
		query.append(",	STV_DMG_RMK" ).append("\n"); 
		query.append(",	STV_DMG_REQ_CATE_CD" ).append("\n"); 
		query.append(",	REQ_VSL_CD" ).append("\n"); 
		query.append(",	REQ_SKD_VOY_NO" ).append("\n"); 
		query.append(",	REQ_SKD_DIR_CD" ).append("\n"); 
		query.append(",	REQ_PORT_CD" ).append("\n"); 
		query.append(",	REQ_ETA_DT" ).append("\n"); 
		query.append(",	STV_DMG_QTTN_CD" ).append("\n"); 
		query.append(",	STV_DMG_QTTN_RSN_DESC" ).append("\n"); 
		query.append(",	STV_DMG_RESPB_PTY_KWN_FLG" ).append("\n"); 
		query.append(",	STV_DMG_RESPB_CD" ).append("\n"); 
		query.append(",	STV_DMG_RESPB_DESC" ).append("\n"); 
		query.append(",	DMG_EML_SND_NO" ).append("\n"); 
		query.append(",	STV_DMG_RPT_ATCH_KNT" ).append("\n"); 
		query.append(",	STV_DMG_PICT_ATCH_KNT" ).append("\n"); 
		query.append(",	STV_DMG_DOC_ATCH_KNT" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append(") VALUES( " ).append("\n"); 
		query.append("	@[stv_dmg_no]" ).append("\n"); 
		query.append(",	@[stv_dmg_prt_cate_cd]" ).append("\n"); 
		query.append(",	@[stv_dmg_prt_cd]" ).append("\n"); 
		query.append(",	@[stv_dmg_tp_cd]" ).append("\n"); 
		query.append(",	@[stv_dmg_loc_desc]" ).append("\n"); 
		query.append(",	@[stv_dmg_rpt_atch_flg]" ).append("\n"); 
		query.append(",	@[stv_dmg_pict_atch_flg]" ).append("\n"); 
		query.append(",	@[stv_dmg_doc_atch_flg]" ).append("\n"); 
		query.append(",	@[cntr_dmg_flg]" ).append("\n"); 
		query.append(",	@[cgo_dmg_flg]" ).append("\n"); 
		query.append(",	@[cntr_no]" ).append("\n"); 
		query.append(",	TO_DATE(@[fm_tm_lss_dt],'YYYY-MM-DD HH24:MI')" ).append("\n"); 
		query.append(",	TO_DATE(@[to_tm_lss_dt],'YYYY-MM-DD HH24:MI')" ).append("\n"); 
		query.append(",	@[stv_dmg_rmk]" ).append("\n"); 
		query.append(",	@[stv_dmg_req_cate_cd]" ).append("\n"); 
		query.append(",	@[req_vsl_cd]" ).append("\n"); 
		query.append(",	@[req_skd_voy_no]" ).append("\n"); 
		query.append(",	@[req_skd_dir_cd]" ).append("\n"); 
		query.append(",	@[req_port_cd]" ).append("\n"); 
		query.append(",	TO_DATE(@[req_eta_dt],'YYYY-MM-DD')" ).append("\n"); 
		query.append(",	@[stv_dmg_qttn_cd]" ).append("\n"); 
		query.append(",	@[stv_dmg_qttn_rsn_desc]" ).append("\n"); 
		query.append(",	@[stv_dmg_respb_pty_kwn_flg]" ).append("\n"); 
		query.append(",	@[stv_dmg_respb_cd]" ).append("\n"); 
		query.append(",	@[stv_dmg_respb_desc]" ).append("\n"); 
		query.append(",	@[dmg_eml_snd_no]" ).append("\n"); 
		query.append(",	@[stv_dmg_rpt_atch_knt]" ).append("\n"); 
		query.append(",	@[stv_dmg_pict_atch_knt]" ).append("\n"); 
		query.append("--::2015-01-05::--,	[stv_dmg_doc_atch_knt]" ).append("\n"); 
		query.append(",	SUBSTR(@[stv_dmg_doc_atch_knt], 0, DECODE(INSTR(@[stv_dmg_doc_atch_knt],'s'), 0, 1, INSTR(@[stv_dmg_doc_atch_knt],'s')-1)) --@@bug>임시 차후재변경" ).append("\n"); 
		query.append(",	@[cre_usr_id]" ).append("\n"); 
		query.append(",	SYSDATE" ).append("\n"); 
		query.append(",	@[upd_usr_id]" ).append("\n"); 
		query.append(",	SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}