/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CODCorrectionDBDAOaddBkgCodCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.07
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2010.01.07 류대영
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingcorrection.codcorrection.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Dae-Young RYU
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CODCorrectionDBDAOaddBkgCodCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * bkg_cod에 insert한다.
	  * </pre>
	  */
	public CODCorrectionDBDAOaddBkgCodCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("new_por_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("old_de_term_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("new_del_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("old_por_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("new_pod_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cod_rhnd_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("old_skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cod_rjct_rsn_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cod_rhnd_port_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cod_rqst_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cod_trf_cost_amt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("old_del_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("new_pol_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("old_skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cod_chg_ttl_cost_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("new_de_term_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cod_auth_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("old_pol_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("new_skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cod_mnl_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pctl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cod_rqst_rsn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cod_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cod_rjct_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rgn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("new_skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cod_cng_cost_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("old_vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("old_pod_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("new_vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cod_fnl_cost_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cod_rqst_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingcorrection.codcorrection.integration").append("\n"); 
		query.append("FileName : CODCorrectionDBDAOaddBkgCodCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_COD (" ).append("\n"); 
		query.append("BKG_NO" ).append("\n"); 
		query.append(",	COD_RQST_SEQ" ).append("\n"); 
		query.append(",	COD_STS_CD" ).append("\n"); 
		query.append(",	COD_RQST_RSN_CD" ).append("\n"); 
		query.append(",	RGN_CD" ).append("\n"); 
		query.append(",	OLD_VSL_CD" ).append("\n"); 
		query.append(",	OLD_SKD_VOY_NO" ).append("\n"); 
		query.append(",	OLD_SKD_DIR_CD" ).append("\n"); 
		query.append(",	OLD_POR_YD_CD" ).append("\n"); 
		query.append(",	OLD_POL_YD_CD" ).append("\n"); 
		query.append(",	OLD_POD_YD_CD" ).append("\n"); 
		query.append(",	OLD_DEL_YD_CD" ).append("\n"); 
		query.append(",   OLD_DE_TERM_CD" ).append("\n"); 
		query.append(",	NEW_VSL_CD" ).append("\n"); 
		query.append(",	NEW_SKD_VOY_NO" ).append("\n"); 
		query.append(",	NEW_SKD_DIR_CD" ).append("\n"); 
		query.append(",	NEW_POR_YD_CD" ).append("\n"); 
		query.append(",	NEW_POL_YD_CD" ).append("\n"); 
		query.append(",	NEW_POD_YD_CD" ).append("\n"); 
		query.append(",	NEW_DEL_YD_CD" ).append("\n"); 
		query.append(",   NEW_DE_TERM_CD" ).append("\n"); 
		query.append(",	COD_RHND_PORT_CD" ).append("\n"); 
		query.append(",	COD_RHND_PORT_YD_CD" ).append("\n"); 
		query.append(",	COD_CNG_COST_RMK" ).append("\n"); 
		query.append(",	COD_CHG_TTL_COST_AMT" ).append("\n"); 
		query.append(",	COD_TRF_COST_AMT" ).append("\n"); 
		query.append(",	COD_FNL_COST_AMT" ).append("\n"); 
		query.append(",	COD_RQST_OFC_CD" ).append("\n"); 
		query.append(",	COD_AUTH_FLG" ).append("\n"); 
		query.append(",	COD_RJCT_CD" ).append("\n"); 
		query.append(",	COD_RJCT_RSN_RMK" ).append("\n"); 
		query.append(",	PCTL_NO" ).append("\n"); 
		query.append(",	DIFF_RMK" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append(", 	COD_MNL_FLG" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES(" ).append("\n"); 
		query.append("@[bkg_no]" ).append("\n"); 
		query.append(",	@[cod_rqst_seq]" ).append("\n"); 
		query.append(",	@[cod_sts_cd]" ).append("\n"); 
		query.append(",	@[cod_rqst_rsn_cd]" ).append("\n"); 
		query.append(",	@[rgn_cd]" ).append("\n"); 
		query.append(",	@[old_vsl_cd]" ).append("\n"); 
		query.append(",	@[old_skd_voy_no]" ).append("\n"); 
		query.append(",	@[old_skd_dir_cd]" ).append("\n"); 
		query.append(",	@[old_por_yd_cd]" ).append("\n"); 
		query.append(",	@[old_pol_yd_cd]" ).append("\n"); 
		query.append(",	@[old_pod_yd_cd]" ).append("\n"); 
		query.append(",	@[old_del_yd_cd]" ).append("\n"); 
		query.append(",	@[old_de_term_cd]" ).append("\n"); 
		query.append(",	@[new_vsl_cd]" ).append("\n"); 
		query.append(",	@[new_skd_voy_no]" ).append("\n"); 
		query.append(",	@[new_skd_dir_cd]" ).append("\n"); 
		query.append(",	@[new_por_yd_cd]" ).append("\n"); 
		query.append(",	@[new_pol_yd_cd]" ).append("\n"); 
		query.append(",	@[new_pod_yd_cd]" ).append("\n"); 
		query.append(",	@[new_del_yd_cd]" ).append("\n"); 
		query.append(",   @[new_de_term_cd]" ).append("\n"); 
		query.append(",	@[cod_rhnd_port_cd]" ).append("\n"); 
		query.append(",	@[cod_rhnd_port_yd_cd]" ).append("\n"); 
		query.append(",	@[cod_cng_cost_rmk]" ).append("\n"); 
		query.append(",	@[cod_chg_ttl_cost_amt]" ).append("\n"); 
		query.append(",	@[cod_trf_cost_amt]" ).append("\n"); 
		query.append(",	@[cod_fnl_cost_amt]" ).append("\n"); 
		query.append(",	@[cod_rqst_ofc_cd]" ).append("\n"); 
		query.append(",	@[cod_auth_flg]" ).append("\n"); 
		query.append(",	@[cod_rjct_cd]" ).append("\n"); 
		query.append(",	@[cod_rjct_rsn_rmk]" ).append("\n"); 
		query.append(",	@[pctl_no]" ).append("\n"); 
		query.append(",	@[diff_rmk]" ).append("\n"); 
		query.append(",	@[usr_id]" ).append("\n"); 
		query.append(",	sysdate" ).append("\n"); 
		query.append(",	@[usr_id]" ).append("\n"); 
		query.append(",	sysdate" ).append("\n"); 
		query.append(", 	@[cod_mnl_flg]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}