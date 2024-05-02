/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : EQFlagMgtDBDAOaddHangerFlagHistoryListDataCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.28
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2010.12.28 박명신
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.operationmanage.eqflagmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Myoung Sin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EQFlagMgtDBDAOaddHangerFlagHistoryListDataCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * FlagUnflagMgtDBDAOaddHangerFlagHistoryListDataCSQL
	  * </pre>
	  */
	public EQFlagMgtDBDAOaddHangerFlagHistoryListDataCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_invt_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_disp_hngr_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_lost_hngr_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_hngr_bar_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hngr_bar_amd_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_hngr_dmg_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_hngr_trf_otr_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_flg_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_flg_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_flg_inp_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hngr_bar_ttl_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_ord_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_sts_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_hngr_trf_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_ord_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_hngr_rck_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_flg_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_flg_inp_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("eq_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.operationmanage.eqflagmgt.integration").append("\n"); 
		query.append("FileName : EQFlagMgtDBDAOaddHangerFlagHistoryListDataCSQL").append("\n"); 
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
		query.append("INSERT INTO MNR_FLG_HIS(" ).append("\n"); 
		query.append("EQ_NO" ).append("\n"); 
		query.append(",MNR_FLG_SEQ" ).append("\n"); 
		query.append(",EQ_TPSZ_CD" ).append("\n"); 
		query.append(",MNR_FLG_TP_CD" ).append("\n"); 
		query.append(",EQ_KND_CD" ).append("\n"); 
		query.append(",MNR_STS_FLG" ).append("\n"); 
		query.append(",MNR_FLG_YD_CD" ).append("\n"); 
		query.append(",MNR_FLG_INP_DT" ).append("\n"); 
		query.append(",MNR_FLG_INP_TP_CD" ).append("\n"); 
		query.append(",MNR_FLG_RMK" ).append("\n"); 
		query.append(",MNR_HNGR_RCK_CD" ).append("\n"); 
		query.append(",MNR_HNGR_BAR_TP_CD" ).append("\n"); 
		query.append(",HNGR_BAR_TTL_QTY" ).append("\n"); 
		query.append(",HNGR_BAR_AMD_QTY" ).append("\n"); 
		query.append(",MNR_HNGR_TRF_CD" ).append("\n"); 
		query.append(",MNR_HNGR_TRF_OTR_DESC" ).append("\n"); 
		query.append(",MNR_HNGR_DMG_QTY" ).append("\n"); 
		query.append(",ACT_INVT_QTY" ).append("\n"); 
		query.append(",MNR_LOST_HNGR_QTY" ).append("\n"); 
		query.append(",MNR_DISP_HNGR_QTY" ).append("\n"); 
		query.append(",MNR_ORD_OFC_CTY_CD" ).append("\n"); 
		query.append(",MNR_ORD_SEQ" ).append("\n"); 
		query.append(",EQ_MVMT_YR" ).append("\n"); 
		query.append(",EQ_MVMT_ID_NO" ).append("\n"); 
		query.append(",CRE_OFC_CD" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",CRE_DT" ).append("\n"); 
		query.append(",UPD_OFC_CD" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(",UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES(" ).append("\n"); 
		query.append("@[eq_no]" ).append("\n"); 
		query.append(",(SELECT NVL(MAX(MNR_FLG_SEQ),0)+1 FROM  MNR_FLG_HIS WHERE EQ_NO = @[eq_no])" ).append("\n"); 
		query.append(",@[eq_tpsz_cd]" ).append("\n"); 
		query.append(",@[mnr_flg_tp_cd]" ).append("\n"); 
		query.append(",'U'" ).append("\n"); 
		query.append(",@[mnr_sts_flg]" ).append("\n"); 
		query.append(",@[mnr_flg_yd_cd]" ).append("\n"); 
		query.append(",TO_DATE(@[mnr_flg_inp_dt],'YYYY-MM-DD')" ).append("\n"); 
		query.append(",@[mnr_flg_inp_tp_cd]" ).append("\n"); 
		query.append(",@[mnr_flg_rmk]" ).append("\n"); 
		query.append(",@[mnr_hngr_rck_cd]" ).append("\n"); 
		query.append(",@[mnr_hngr_bar_tp_cd]" ).append("\n"); 
		query.append(",@[hngr_bar_ttl_qty]" ).append("\n"); 
		query.append(",@[hngr_bar_amd_qty]" ).append("\n"); 
		query.append(",@[mnr_hngr_trf_cd]" ).append("\n"); 
		query.append(",@[mnr_hngr_trf_otr_desc]" ).append("\n"); 
		query.append(",@[mnr_hngr_dmg_qty]" ).append("\n"); 
		query.append(",@[act_invt_qty]" ).append("\n"); 
		query.append(",@[mnr_lost_hngr_qty]" ).append("\n"); 
		query.append(",@[mnr_disp_hngr_qty]" ).append("\n"); 
		query.append(",@[mnr_ord_ofc_cty_cd]" ).append("\n"); 
		query.append(",@[mnr_ord_seq]" ).append("\n"); 
		query.append(",' '" ).append("\n"); 
		query.append(",0" ).append("\n"); 
		query.append(",@[cre_ofc_cd]" ).append("\n"); 
		query.append(",@[cre_usr_id]" ).append("\n"); 
		query.append(",sysdate" ).append("\n"); 
		query.append(",@[cre_ofc_cd]" ).append("\n"); 
		query.append(",@[cre_usr_id]" ).append("\n"); 
		query.append(",sysdate" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}