/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : PickUpNoticeDBDAOaddPkupNtcCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.11
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.11 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PickUpNoticeDBDAOaddPkupNtcCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Manully로 P/N 대상 정보를 등록한다.
	  * </pre>
	  */
	public PickUpNoticeDBDAOaddPkupNtcCSQL(){
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
		params.put("ibd_trsp_hub_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnl_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pkup_ntc_fom_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_nm",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pkup_ntc_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_322_mvmt_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rail_lod_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("exp_snd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_cust_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dor_trkr_wo_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("obl_clt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ntfc_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cstms_clr_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("trsp_so_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frt_clt_flg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration").append("\n"); 
		query.append("FileName : PickUpNoticeDBDAOaddPkupNtcCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_PKUP_NTC (" ).append("\n"); 
		query.append("	BKG_NO" ).append("\n"); 
		query.append(",	NTC_SEQ" ).append("\n"); 
		query.append(",	PKUP_NTC_TP_CD" ).append("\n"); 
		query.append(",	PKUP_NTC_FOM_CD" ).append("\n"); 
		query.append(",	BKG_CUST_TP_CD" ).append("\n"); 
		query.append(",	CUST_CNT_CD" ).append("\n"); 
		query.append(",	CUST_SEQ" ).append("\n"); 
		query.append(",	CUST_NM" ).append("\n"); 
		query.append(",	PKUP_NTC_EVNT_DT" ).append("\n"); 
		query.append(",	EXP_SND_DT" ).append("\n"); 
		query.append(",	EXP_SND_GDT" ).append("\n"); 
		query.append(",	EXP_SND_KR_DT" ).append("\n"); 
		query.append(",	CNTR_NO" ).append("\n"); 
		query.append(",	RAIL_LOD_DT" ).append("\n"); 
		query.append(",	NTFC_DT" ).append("\n"); 
		query.append(",	FRT_CLT_FLG" ).append("\n"); 
		query.append(",	OBL_CLT_FLG" ).append("\n"); 
		query.append(",	CSTMS_CLR_FLG" ).append("\n"); 
		query.append(",	PKUP_NO" ).append("\n"); 
		query.append(",	RAIL_RMP_FREE_DYS" ).append("\n"); 
		query.append(",	LST_FREE_DT" ).append("\n"); 
		query.append(",	MNL_CNG_FLG" ).append("\n"); 
		query.append(",	EDI_322_MVMT_CD" ).append("\n"); 
		query.append(",	PKUP_YD_CD" ).append("\n"); 
		query.append(",	RTN_YD_CD" ).append("\n"); 
		query.append(",	DOR_TRKR_WO_FLG" ).append("\n"); 
		query.append(",	PKUP_NTC_SND_STS_CD" ).append("\n"); 
		query.append(",	IBD_TRSP_HUB_CD" ).append("\n"); 
		query.append(",	DIFF_RMK" ).append("\n"); 
		query.append(",	PKUP_AVAL_DT" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append(",	AUTO_SND_STOP_FLG" ).append("\n"); 
		query.append(",	AUTO_SND_STOP_DT" ).append("\n"); 
		query.append(",	AUTO_SND_STOP_USR_ID" ).append("\n"); 
		query.append(",	AUTO_SND_RESM_FLG" ).append("\n"); 
		query.append(",	AUTO_SND_RESM_DT" ).append("\n"); 
		query.append(",	AUTO_SND_RESM_USR_ID" ).append("\n"); 
		query.append(",	TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append(",	TRSP_SO_SEQ" ).append("\n"); 
		query.append(",	ECLZ_OBL_CPY_FLG" ).append("\n"); 
		query.append(",	MNL_FLG" ).append("\n"); 
		query.append(") " ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("	A.BKG_NO" ).append("\n"); 
		query.append(",	@[ntc_seq]" ).append("\n"); 
		query.append(",	@[pkup_ntc_tp_cd]" ).append("\n"); 
		query.append(",	@[pkup_ntc_fom_cd]" ).append("\n"); 
		query.append(",	@[bkg_cust_tp_cd]" ).append("\n"); 
		query.append(",	@[cust_cnt_cd]" ).append("\n"); 
		query.append(",	@[cust_seq]" ).append("\n"); 
		query.append(",	@[cust_nm]" ).append("\n"); 
		query.append(",   DECODE(A.LST_FREE_DT,NULL,A.PKUP_AVAL_DT,A.LST_FREE_DT)" ).append("\n"); 
		query.append(",	TO_DATE(@[exp_snd_dt],'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append(",	GLOBALDATE_PKG.TIME_CONV_FNC('KRSEL', TO_DATE(@[exp_snd_dt],'YYYY-MM-DD HH24:MI:SS'), 'GMT')" ).append("\n"); 
		query.append(",	SYSDATE" ).append("\n"); 
		query.append(",	A.CNTR_NO" ).append("\n"); 
		query.append(",	TO_DATE(@[rail_lod_dt],'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append(",	TO_DATE(@[ntfc_dt],'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append(",	@[frt_clt_flg]" ).append("\n"); 
		query.append(",	@[obl_clt_flg]" ).append("\n"); 
		query.append(",	@[cstms_clr_flg]" ).append("\n"); 
		query.append(",	A.PKUP_NO" ).append("\n"); 
		query.append(",	(A.LST_FREE_DT - A.PKUP_AVAL_DT)" ).append("\n"); 
		query.append(",	A.LST_FREE_DT" ).append("\n"); 
		query.append(",	'Y'" ).append("\n"); 
		query.append(",   NVL(DECODE(A.LST_FREE_DT,NULL,DECODE(A.PKUP_AVAL_DT,NULL,NULL,'NT'),'NF'),@[edi_322_mvmt_cd])" ).append("\n"); 
		query.append(",	A.PKUP_YD_CD" ).append("\n"); 
		query.append(",	A.RTN_YD_CD" ).append("\n"); 
		query.append(",	@[dor_trkr_wo_flg]" ).append("\n"); 
		query.append(",	'Y'" ).append("\n"); 
		query.append(",	@[ibd_trsp_hub_cd]" ).append("\n"); 
		query.append(",	@[diff_rmk]" ).append("\n"); 
		query.append(",	A.PKUP_AVAL_DT" ).append("\n"); 
		query.append(",	@[cre_usr_id]" ).append("\n"); 
		query.append(",	SYSDATE" ).append("\n"); 
		query.append(",	@[upd_usr_id]" ).append("\n"); 
		query.append(",	SYSDATE" ).append("\n"); 
		query.append(",	'N' -- AUTO_SND_STOP_FLG" ).append("\n"); 
		query.append(",	'' -- AUTO_SND_STOP_DT" ).append("\n"); 
		query.append(",	'' -- AUTO_SND_STOP_USR_ID" ).append("\n"); 
		query.append(",	'N' -- AUTO_SND_RESM_FLG" ).append("\n"); 
		query.append(",	'' -- AUTO_SND_RESM_DT" ).append("\n"); 
		query.append(",	'' -- AUTO_SND_RESM_USR_ID" ).append("\n"); 
		query.append(",	@[trsp_so_ofc_cty_cd]" ).append("\n"); 
		query.append(",	@[trsp_so_seq]" ).append("\n"); 
		query.append(",	@[eclz_obl_cpy_flg]" ).append("\n"); 
		query.append(",	@[mnl_flg]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM BKG_PKUP_NTC_PKUP_NO A" ).append("\n"); 
		query.append(",BKG_BOOKING B" ).append("\n"); 
		query.append(",MDM_LOCATION C" ).append("\n"); 
		query.append("WHERE A.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND A.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("AND B.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("AND C.LOC_CD = B.DEL_CD" ).append("\n"); 
		query.append("AND A.OFC_CD = DECODE(SUBSTR(B.DEL_CD,1,2),'US','PHXSA',C.EQ_CTRL_OFC_CD)" ).append("\n"); 

	}
}