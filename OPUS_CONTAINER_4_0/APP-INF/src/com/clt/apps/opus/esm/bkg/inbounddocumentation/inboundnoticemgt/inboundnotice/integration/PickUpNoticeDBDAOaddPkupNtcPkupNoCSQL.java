/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PickUpNoticeDBDAOaddPkupNtcPkupNoCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.20
*@LastModifier : 
*@LastVersion : 1.0
* 2010.04.20 
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

public class PickUpNoticeDBDAOaddPkupNtcPkupNoCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * .
	  * </pre>
	  */
	public PickUpNoticeDBDAOaddPkupNtcPkupNoCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("rail_dest_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("can_pcf_ind_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rail_arr_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pkup_cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pkup_delt_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("stop_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("uni_pcf_ind_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("lst_free_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rail_org_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("de_term_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pkup_ntc_ind_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pkup_upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pkup_ntc_snd_knt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rail_dep_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration").append("\n"); 
		query.append("FileName : PickUpNoticeDBDAOaddPkupNtcPkupNoCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_PKUP_NTC_PKUP_NO" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("	BKG_NO" ).append("\n"); 
		query.append(",	CNTR_NO" ).append("\n"); 
		query.append(",	OFC_CD" ).append("\n"); 
		query.append(",	BL_NO" ).append("\n"); 
		query.append(",	VSL_CD" ).append("\n"); 
		query.append(",	SKD_VOY_NO" ).append("\n"); 
		query.append(",	SKD_DIR_CD" ).append("\n"); 
		query.append(",	POD_CD" ).append("\n"); 
		query.append(",	DEL_CD" ).append("\n"); 
		query.append(",	DE_TERM_CD" ).append("\n"); 
		query.append(",	RAIL_ORG_LOC_CD" ).append("\n"); 
		query.append(",	RAIL_DEST_LOC_CD" ).append("\n"); 
		query.append(",	IBD_TRSP_HUB_CD" ).append("\n"); 
		query.append(",	PKUP_YD_CD" ).append("\n"); 
		query.append(",	PKUP_NO" ).append("\n"); 
		query.append(",	PKUP_AVAL_DT" ).append("\n"); 
		query.append(",	LST_FREE_DT" ).append("\n"); 
		query.append(",	RTN_YD_CD" ).append("\n"); 
		query.append(",	UNI_PCF_IND_FLG" ).append("\n"); 
		query.append(",	CAN_PCF_IND_FLG" ).append("\n"); 
		query.append(",	PKUP_NTC_IND_CD" ).append("\n"); 
		query.append(",	PKUP_NTC_SND_KNT" ).append("\n"); 
		query.append(",	STOP_USR_ID" ).append("\n"); 
		query.append(",	STOP_DT" ).append("\n"); 
		query.append(",	PKUP_CRE_DT" ).append("\n"); 
		query.append(",	PKUP_CRE_USR_ID" ).append("\n"); 
		query.append(",	PKUP_UPD_DT" ).append("\n"); 
		query.append(",	PKUP_UPD_USR_ID" ).append("\n"); 
		query.append(",	DELT_FLG" ).append("\n"); 
		query.append(",	PKUP_DELT_DT" ).append("\n"); 
		query.append(",	PKUP_DELT_USR_ID" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append(",	RAIL_ARR_DT" ).append("\n"); 
		query.append(",	RAIL_DEP_DT" ).append("\n"); 
		query.append(",	PKUP_MNL_UPLD_FLG" ).append("\n"); 
		query.append(") VALUES( " ).append("\n"); 
		query.append("	@[bkg_no]" ).append("\n"); 
		query.append(",	@[cntr_no]" ).append("\n"); 
		query.append(",	(SELECT EQ_CTRL_OFC_CD " ).append("\n"); 
		query.append("     FROM MDM_LOCATION" ).append("\n"); 
		query.append("     WHERE LOC_CD = (SELECT DEL_CD FROM  BKG_BOOKING WHERE BKG_NO = @[bkg_no]))" ).append("\n"); 
		query.append(",	@[bl_no]" ).append("\n"); 
		query.append(",	@[vsl_cd]" ).append("\n"); 
		query.append(",	@[skd_voy_no]" ).append("\n"); 
		query.append(",	@[skd_dir_cd]" ).append("\n"); 
		query.append(",	@[pod_cd]" ).append("\n"); 
		query.append(",	@[del_cd]" ).append("\n"); 
		query.append(",	@[de_term_cd]" ).append("\n"); 
		query.append(",	@[rail_org_loc_cd]" ).append("\n"); 
		query.append(",	@[rail_dest_loc_cd]" ).append("\n"); 
		query.append(",	@[ibd_trsp_hub_cd]" ).append("\n"); 
		query.append(",	@[pkup_yd_cd]" ).append("\n"); 
		query.append(",	@[pkup_no]" ).append("\n"); 
		query.append(",	TO_DATE(@[pkup_aval_dt], 'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append(",	TRUNC(TO_DATE(@[lst_free_dt], 'YYYY-MM-DD HH24:MI:SS'))" ).append("\n"); 
		query.append(",	@[rtn_yd_cd]" ).append("\n"); 
		query.append(",	@[uni_pcf_ind_flg]" ).append("\n"); 
		query.append(",	@[can_pcf_ind_flg]" ).append("\n"); 
		query.append(",	@[pkup_ntc_ind_cd]" ).append("\n"); 
		query.append(",	@[pkup_ntc_snd_knt]" ).append("\n"); 
		query.append(",	@[stop_usr_id]" ).append("\n"); 
		query.append(",	NULL" ).append("\n"); 
		query.append(",	GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC((SELECT EQ_CTRL_OFC_CD " ).append("\n"); 
		query.append("                                         FROM MDM_LOCATION" ).append("\n"); 
		query.append("                                        WHERE LOC_CD = (SELECT DEL_CD FROM  BKG_BOOKING WHERE BKG_NO = @[bkg_no])))" ).append("\n"); 
		query.append(",	@[pkup_cre_usr_id]" ).append("\n"); 
		query.append(",	GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC((SELECT EQ_CTRL_OFC_CD " ).append("\n"); 
		query.append("                                         FROM MDM_LOCATION" ).append("\n"); 
		query.append("                                        WHERE LOC_CD = (SELECT DEL_CD FROM  BKG_BOOKING WHERE BKG_NO = @[bkg_no])))" ).append("\n"); 
		query.append(",	@[pkup_upd_usr_id]" ).append("\n"); 
		query.append(",	'N'" ).append("\n"); 
		query.append(",	NULL" ).append("\n"); 
		query.append(",	@[pkup_delt_usr_id]" ).append("\n"); 
		query.append(",	@[cre_usr_id]" ).append("\n"); 
		query.append(",	SYSDATE" ).append("\n"); 
		query.append(",	@[upd_usr_id]" ).append("\n"); 
		query.append(",	SYSDATE" ).append("\n"); 
		query.append(",	TO_DATE(@[rail_arr_dt], 'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append(",	TO_DATE(@[rail_dep_dt], 'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append(",	'Y'" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}