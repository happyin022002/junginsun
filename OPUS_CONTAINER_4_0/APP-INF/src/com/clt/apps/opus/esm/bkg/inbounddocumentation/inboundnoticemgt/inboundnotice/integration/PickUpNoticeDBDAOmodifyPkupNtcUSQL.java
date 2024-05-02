/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PickUpNoticeDBDAOmodifyPkupNtcUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.01
*@LastModifier : 
*@LastVersion : 1.0
* 2010.04.01 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PickUpNoticeDBDAOmodifyPkupNtcUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Pickup Notice 내역을 수정한다
	  * </pre>
	  */
	public PickUpNoticeDBDAOmodifyPkupNtcUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ntc_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rtn_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pkup_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pkup_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("eclz_obl_cpy_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pkup_aval_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("diff_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lst_free_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration").append("\n"); 
		query.append("FileName : PickUpNoticeDBDAOmodifyPkupNtcUSQL").append("\n"); 
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
		query.append("/* 삭제됨!!!!" ).append("\n"); 
		query.append("UPDATE BKG_PKUP_NTC A" ).append("\n"); 
		query.append("SET " ).append("\n"); 
		query.append("	MNL_CNG_FLG       = 'Y'" ).append("\n"); 
		query.append("--,	PKUP_NTC_FOM_CD   = pkup_ntc_fom_cd" ).append("\n"); 
		query.append("--,	CUST_CNT_CD       = cust_cnt_cd" ).append("\n"); 
		query.append("--,	CUST_SEQ          = cust_seq" ).append("\n"); 
		query.append("--,	CUST_NM           = cust_nm" ).append("\n"); 
		query.append(",	PKUP_AVAL_DT      = TO_DATE(@[pkup_aval_dt],'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append(",	LST_FREE_DT       = TO_DATE(@[lst_free_dt],'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append(",	PKUP_NO           = @[pkup_no]" ).append("\n"); 
		query.append(",	PKUP_YD_CD        = @[pkup_yd_cd]" ).append("\n"); 
		query.append(",	RTN_YD_CD         = @[rtn_yd_cd]" ).append("\n"); 
		query.append(",	DIFF_RMK          = @[diff_rmk]" ).append("\n"); 
		query.append(",	RAIL_RMP_FREE_DYS = (TO_DATE(@[lst_free_dt],'YYYY-MM-DD HH24:MI:SS') - TO_DATE(@[pkup_aval_dt],'YYYY-MM-DD HH24:MI:SS'))" ).append("\n"); 
		query.append(",	UPD_USR_ID        = @[upd_usr_id]" ).append("\n"); 
		query.append(",	UPD_DT            = SYSDATE" ).append("\n"); 
		query.append(",	ECLZ_OBL_CPY_FLG  = @[eclz_obl_cpy_flg]" ).append("\n"); 
		query.append("--,	BKG_CUST_TP_CD = bkg_cust_tp_cd" ).append("\n"); 
		query.append("--	AUTO_SND_STOP_FLG = auto_snd_stop_flg" ).append("\n"); 
		query.append("--,	AUTO_SND_STOP_DT = TO_DATE(auto_snd_stop_dt,'YYYY-MM-DD')" ).append("\n"); 
		query.append("--,	AUTO_SND_STOP_USR_ID = auto_snd_stop_usr_id" ).append("\n"); 
		query.append("--,	AUTO_SND_RESM_FLG = auto_snd_resm_flg" ).append("\n"); 
		query.append("--,	AUTO_SND_RESM_DT = TO_DATE(auto_snd_resm_dt,'YYYY-MM-DD')" ).append("\n"); 
		query.append("--,	AUTO_SND_RESM_USR_ID = auto_snd_resm_usr_id" ).append("\n"); 
		query.append("--,	TRSP_SO_OFC_CTY_CD = trsp_so_ofc_cty_cd" ).append("\n"); 
		query.append("--,	TRSP_SO_SEQ = trsp_so_seq" ).append("\n"); 
		query.append("--,	PKUP_NTC_TP_CD = pkup_ntc_tp_cd" ).append("\n"); 
		query.append("--,	PKUP_NTC_EVNT_DT = TO_DATE(pkup_ntc_evnt_dt,'YYYY-MM-DD')" ).append("\n"); 
		query.append("--,	EXP_SND_DT = TO_DATE(exp_snd_dt,'YYYY-MM-DD')" ).append("\n"); 
		query.append("--,	CNTR_NO = cntr_no" ).append("\n"); 
		query.append("--,	RAIL_LOD_DT = TO_DATE(rail_lod_dt,'YYYY-MM-DD')" ).append("\n"); 
		query.append("--,	NTFC_DT = TO_DATE(ntfc_dt,'YYYY-MM-DD')" ).append("\n"); 
		query.append("--,	FRT_CLT_FLG = frt_clt_flg" ).append("\n"); 
		query.append("--,	OBL_CLT_FLG = obl_clt_flg" ).append("\n"); 
		query.append("--,	CSTMS_CLR_FLG = cstms_clr_flg" ).append("\n"); 
		query.append("--,	EDI_322_MVMT_CD = edi_322_mvmt_cd" ).append("\n"); 
		query.append("--,	DOR_TRKR_WO_FLG = dor_trkr_wo_flg" ).append("\n"); 
		query.append("--,	PKUP_NTC_SND_STS_CD = pkup_ntc_snd_sts_cd" ).append("\n"); 
		query.append("--,	IBD_TRSP_HUB_CD = ibd_trsp_hub_cd" ).append("\n"); 
		query.append("--,	CRE_USR_ID = cre_usr_id" ).append("\n"); 
		query.append("--,	CRE_DT = TO_DATE(cre_dt,'YYYY-MM-DD')" ).append("\n"); 
		query.append("WHERE	BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND	NTC_SEQ = @[ntc_seq]" ).append("\n"); 
		query.append("AND PKUP_NTC_SND_STS_CD = 'N'" ).append("\n"); 
		query.append("*/" ).append("\n"); 

	}
}