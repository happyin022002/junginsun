/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EQFlagMgtDBDAOaddEQFlagHistoryListDataCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.21
*@LastModifier : 
*@LastVersion : 1.0
* 2015.12.21 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.operationmanage.eqflagmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EQFlagMgtDBDAOaddEQFlagHistoryListDataCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 히스토리 테이블에 등록
	  * </pre>
	  */
	public EQFlagMgtDBDAOaddEQFlagHistoryListDataCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_flg_cmpl_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_mvmt_id_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_hngr_bar_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
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
		params.put("cur_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_flg_inp_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
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
		params.put("eq_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_mvmt_yr",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mnr.operationmanage.eqflagmgt.integration").append("\n"); 
		query.append("FileName : EQFlagMgtDBDAOaddEQFlagHistoryListDataCSQL").append("\n"); 
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
		query.append("INSERT INTO MNR_FLG_HIS (" ).append("\n"); 
		query.append("	EQ_NO" ).append("\n"); 
		query.append(",	MNR_FLG_SEQ" ).append("\n"); 
		query.append(",	EQ_TPSZ_CD" ).append("\n"); 
		query.append(",	MNR_FLG_TP_CD" ).append("\n"); 
		query.append(",	EQ_KND_CD" ).append("\n"); 
		query.append(",	MNR_STS_FLG" ).append("\n"); 
		query.append(",	MNR_FLG_YD_CD" ).append("\n"); 
		query.append(",	MNR_FLG_INP_DT" ).append("\n"); 
		query.append(",	MNR_FLG_INP_TP_CD" ).append("\n"); 
		query.append(",	MNR_FLG_RMK" ).append("\n"); 
		query.append(",	MNR_HNGR_RCK_CD" ).append("\n"); 
		query.append(",	MNR_HNGR_BAR_TP_CD" ).append("\n"); 
		query.append(",	HNGR_BAR_TTL_QTY" ).append("\n"); 
		query.append(",	HNGR_BAR_AMD_QTY" ).append("\n"); 
		query.append(",	MNR_ORD_OFC_CTY_CD" ).append("\n"); 
		query.append(",	MNR_ORD_SEQ" ).append("\n"); 
		query.append(",	MNR_FLG_CMPL_DT" ).append("\n"); 
		query.append(",	EQ_MVMT_YR" ).append("\n"); 
		query.append(",	EQ_MVMT_ID_NO" ).append("\n"); 
		query.append(",	CRE_OFC_CD" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_OFC_CD " ).append("\n"); 
		query.append(",	UPD_USR_ID " ).append("\n"); 
		query.append(",	UPD_DT " ).append("\n"); 
		query.append(") VALUES( " ).append("\n"); 
		query.append("	@[eq_no]" ).append("\n"); 
		query.append(",	(SELECT NVL(MAX(MNR_FLG_SEQ),0)+1 FROM  MNR_FLG_HIS WHERE EQ_NO = @[eq_no])" ).append("\n"); 
		query.append(",	@[eq_tpsz_cd]" ).append("\n"); 
		query.append(",	@[mnr_flg_tp_cd]" ).append("\n"); 
		query.append(",	@[eq_knd_cd]" ).append("\n"); 
		query.append(",	DECODE(@[mnr_sts_flg],'0','N','Y')" ).append("\n"); 
		query.append(",	@[mnr_flg_yd_cd]" ).append("\n"); 
		query.append(",	DECODE(@[mnr_flg_tp_cd], 'DMG', TO_DATE(@[mnr_flg_inp_dt],'YYYY-MM-DD HH24:MI'), " ).append("\n"); 
		query.append("    DECODE(@[mnr_flg_inp_tp_cd],'M'," ).append("\n"); 
		query.append("	GLOBALDATE_PKG.TIME_CONV_OFC_FNC(@[cur_ofc_cd],TO_DATE(@[mnr_flg_inp_dt],'YYYY-MM-DD'),MNR_COMMON_PKG.MNR_GET_HOOFC_FNC())," ).append("\n"); 
		query.append("	DECODE(@[mnr_flg_inp_tp_cd],'S'," ).append("\n"); 
		query.append("	GLOBALDATE_PKG.TIME_CONV_OFC_FNC(@[cur_ofc_cd],TO_DATE(@[mnr_flg_inp_dt],'YYYY-MM-DD'),MNR_COMMON_PKG.MNR_GET_HOOFC_FNC())," ).append("\n"); 
		query.append("	SYSDATE)))" ).append("\n"); 
		query.append(",	@[mnr_flg_inp_tp_cd]" ).append("\n"); 
		query.append(",	@[mnr_flg_rmk]" ).append("\n"); 
		query.append(",	@[mnr_hngr_rck_cd]" ).append("\n"); 
		query.append(",	@[mnr_hngr_bar_tp_cd]" ).append("\n"); 
		query.append(",	@[hngr_bar_ttl_qty]" ).append("\n"); 
		query.append(",	@[hngr_bar_amd_qty]" ).append("\n"); 
		query.append(",   @[mnr_ord_ofc_cty_cd]" ).append("\n"); 
		query.append(",	@[mnr_ord_seq]" ).append("\n"); 
		query.append(",	TO_DATE(@[mnr_flg_cmpl_dt],'YYYY-MM-DD')" ).append("\n"); 
		query.append(",	@[eq_mvmt_yr] " ).append("\n"); 
		query.append(",	@[eq_mvmt_id_no]  " ).append("\n"); 
		query.append(",	@[cre_ofc_cd]" ).append("\n"); 
		query.append(",	@[cre_usr_id] " ).append("\n"); 
		query.append(",	SYSDATE" ).append("\n"); 
		query.append(",	@[cre_ofc_cd]" ).append("\n"); 
		query.append(",	@[cre_usr_id] " ).append("\n"); 
		query.append(",	SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}