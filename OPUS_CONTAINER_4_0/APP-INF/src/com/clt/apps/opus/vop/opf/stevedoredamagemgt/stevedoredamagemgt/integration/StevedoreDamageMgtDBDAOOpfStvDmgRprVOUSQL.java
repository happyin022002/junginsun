/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : StevedoreDamageMgtDBDAOOpfStvDmgRprVOUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.20
*@LastModifier : 장석현
*@LastVersion : 1.0
* 2009.11.20 장석현
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

public class StevedoreDamageMgtDBDAOOpfStvDmgRprVOUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * OpfStvDmgRprVO Update Query
	  * </pre>
	  */
	public StevedoreDamageMgtDBDAOOpfStvDmgRprVOUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.REAL + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rpr_cost_usd_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rpr_inv_atch_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rpr_rslt_rpt_atch_knt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rpr_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rpr_eml_snd_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rpr_inv_atch_knt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rpr_doc_atch_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.REAL + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("qttn_cost_locl_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rpr_pict_atch_knt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rpr_pict_atch_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rpr_rslt_rpt_atch_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rpr_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rpr_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("qttn_locl_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stv_dmg_rpr_proc_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ustl_acct_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rpr_vndr_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stv_dmg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.REAL + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("qttn_cost_usd_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rpr_doc_atch_knt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("run_rpr_acct_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rpr_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stv_dmg_rpr_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.opf.stevedoredamagemgt.stevedoredamagemgt.integration").append("\n"); 
		query.append("FileName : StevedoreDamageMgtDBDAOOpfStvDmgRprVOUSQL").append("\n"); 
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
		query.append("UPDATE OPF_STV_DMG_RPR SET" ).append("\n"); 
		query.append("STV_DMG_NO = @[stv_dmg_no]" ).append("\n"); 
		query.append(",	STV_DMG_RPR_SEQ = @[stv_dmg_rpr_seq]" ).append("\n"); 
		query.append(",	STV_DMG_RPR_PROC_STS_CD = @[stv_dmg_rpr_proc_sts_cd]" ).append("\n"); 
		query.append(",	QTTN_LOCL_CURR_CD = @[qttn_locl_curr_cd]" ).append("\n"); 
		query.append(",	QTTN_COST_LOCL_AMT = @[qttn_cost_locl_amt]" ).append("\n"); 
		query.append(",	QTTN_COST_USD_AMT = @[qttn_cost_usd_amt]" ).append("\n"); 
		query.append(",	RPR_PORT_CD = @[rpr_port_cd]" ).append("\n"); 
		query.append(",	RPR_DT = TO_DATE(@[rpr_dt],'YYYY-MM-DD')" ).append("\n"); 
		query.append(",	RPR_VNDR_NM = @[rpr_vndr_nm]" ).append("\n"); 
		query.append(",	USTL_ACCT_NO = @[ustl_acct_no]" ).append("\n"); 
		query.append(",	RUN_RPR_ACCT_NO = @[run_rpr_acct_no]" ).append("\n"); 
		query.append(",	RPR_CURR_CD = @[rpr_curr_cd]" ).append("\n"); 
		query.append(",	RPR_COST_USD_AMT = @[rpr_cost_usd_amt]" ).append("\n"); 
		query.append(",	RPR_RSLT_RPT_ATCH_FLG = @[rpr_rslt_rpt_atch_flg]" ).append("\n"); 
		query.append(",	RPR_INV_ATCH_FLG = @[rpr_inv_atch_flg]" ).append("\n"); 
		query.append(",	RPR_PICT_ATCH_FLG = @[rpr_pict_atch_flg]" ).append("\n"); 
		query.append(",	RPR_DOC_ATCH_FLG = @[rpr_doc_atch_flg]" ).append("\n"); 
		query.append(",	RPR_RMK = @[rpr_rmk]" ).append("\n"); 
		query.append(",	RPR_EML_SND_NO = @[rpr_eml_snd_no]" ).append("\n"); 
		query.append(",   RPR_RSLT_RPT_ATCH_KNT = @[rpr_rslt_rpt_atch_knt]" ).append("\n"); 
		query.append(",   RPR_INV_ATCH_KNT = @[rpr_inv_atch_knt]" ).append("\n"); 
		query.append(",   RPR_PICT_ATCH_KNT = @[rpr_pict_atch_knt]" ).append("\n"); 
		query.append(",   RPR_DOC_ATCH_KNT = @[rpr_doc_atch_knt]" ).append("\n"); 
		query.append(",	UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append(",	UPD_DT = SYSDATE" ).append("\n"); 
		query.append("WHERE	STV_DMG_NO = @[stv_dmg_no]" ).append("\n"); 
		query.append("AND	STV_DMG_RPR_SEQ = @[stv_dmg_rpr_seq]" ).append("\n"); 

	}
}