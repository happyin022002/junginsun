/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : KeyManInfoManageDBDAOaddKeyManInfoCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.07.14
*@LastModifier : 
*@LastVersion : 1.0
* 2011.07.14 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.sam.generalinfomanage.keymaninfomanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KeyManInfoManageDBDAOaddKeyManInfoCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * KeyManInfoDBDAOaddKeyManInfo
	  * </pre>
	  */
	public KeyManInfoManageDBDAOaddKeyManInfoCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("kman_mjr_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("kman_sgnf_ind_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("biz_iss_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("intl_phn_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("kman_marr_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("kman_nknm_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("kman_sps_brdy_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("kman_wedd_anv_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("kman_gnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("kman_hm_addr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("kman_sps_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jb_tit_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("kman_lst_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_kman_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("kman_brdy_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("kman_eml",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("kman_n1st_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("kman_ofc_addr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("kman_ofc_fax_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("kman_rmk_desc",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("kman_dept_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("kman_edu_cate_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("kman_hby_desc",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.sam.generalinfomanage.keymaninfomanage.integration").append("\n"); 
		query.append("FileName : KeyManInfoManageDBDAOaddKeyManInfoCSQL").append("\n"); 
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
		query.append("INSERT INTO SAM_CUST_KMAN_INFO(" ).append("\n"); 
		query.append("	KMAN_N1ST_NM" ).append("\n"); 
		query.append("    , KMAN_LST_NM" ).append("\n"); 
		query.append("    , KMAN_GND_CD" ).append("\n"); 
		query.append("    , KMAN_EML" ).append("\n"); 
		query.append("    , JB_TIT_RMK" ).append("\n"); 
		query.append("    , CHG_DESC" ).append("\n"); 
		query.append("    , KMAN_DEPT_DESC" ).append("\n"); 
		query.append("    , KMAN_SGNF_IND_CD" ).append("\n"); 
		query.append("    , KMAN_NKNM_NM" ).append("\n"); 
		query.append("    , KMAN_BRDY_DT" ).append("\n"); 
		query.append("    , KMAN_EDU_CATE_CD" ).append("\n"); 
		query.append("    , KMAN_MJR_DESC" ).append("\n"); 
		query.append("    , KMAN_HBY_DESC" ).append("\n"); 
		query.append("    , KMAN_MARR_FLG" ).append("\n"); 
		query.append("    , KMAN_SPS_NM" ).append("\n"); 
		query.append("    , KMAN_SPS_BRDY_DT" ).append("\n"); 
		query.append("    , KMAN_WEDD_ANV_DT" ).append("\n"); 
		query.append("    , KMAN_OFC_ADDR" ).append("\n"); 
		query.append("    , KMAN_HM_ADDR" ).append("\n"); 
		query.append("    , BIZ_ISS_DESC" ).append("\n"); 
		query.append("    , KMAN_RMK_DESC" ).append("\n"); 
		query.append("    , CRE_USR_ID" ).append("\n"); 
		query.append("    , CRE_DT" ).append("\n"); 
		query.append("    , UPD_USR_ID" ).append("\n"); 
		query.append("    , UPD_DT" ).append("\n"); 
		query.append("	, CUST_CNT_CD" ).append("\n"); 
		query.append("	, CUST_SEQ" ).append("\n"); 
		query.append("	, CUST_KMAN_SEQ" ).append("\n"); 
		query.append("	, INTL_PHN_NO" ).append("\n"); 
		query.append("	, KMAN_OFC_FAX_NO" ).append("\n"); 
		query.append(") VALUES(" ).append("\n"); 
		query.append("   @[kman_n1st_nm]" ).append("\n"); 
		query.append("  , @[kman_lst_nm]" ).append("\n"); 
		query.append("  , @[kman_gnd_cd]" ).append("\n"); 
		query.append("  , @[kman_eml]" ).append("\n"); 
		query.append("  , @[jb_tit_rmk]" ).append("\n"); 
		query.append("  , @[chg_desc]" ).append("\n"); 
		query.append("  , @[kman_dept_desc]" ).append("\n"); 
		query.append("  , @[kman_sgnf_ind_cd]" ).append("\n"); 
		query.append("  , @[kman_nknm_nm]" ).append("\n"); 
		query.append("  , REPLACE(@[kman_brdy_dt], '-', '')" ).append("\n"); 
		query.append("  , @[kman_edu_cate_cd]" ).append("\n"); 
		query.append("  , @[kman_mjr_desc]" ).append("\n"); 
		query.append("  , @[kman_hby_desc]" ).append("\n"); 
		query.append("  , @[kman_marr_flg]" ).append("\n"); 
		query.append("  , @[kman_sps_nm]" ).append("\n"); 
		query.append("  , REPLACE(@[kman_sps_brdy_dt], '-', '')" ).append("\n"); 
		query.append("  , REPLACE(@[kman_wedd_anv_dt], '-', '')" ).append("\n"); 
		query.append("  , @[kman_ofc_addr]" ).append("\n"); 
		query.append("  , @[kman_hm_addr]" ).append("\n"); 
		query.append("  , @[biz_iss_desc]" ).append("\n"); 
		query.append("  , @[kman_rmk_desc]" ).append("\n"); 
		query.append("  , @[usr_id]" ).append("\n"); 
		query.append("  , sysdate" ).append("\n"); 
		query.append("  , @[usr_id]" ).append("\n"); 
		query.append("  , sysdate" ).append("\n"); 
		query.append("  ,substr(@[cust_cd], 1, 2)" ).append("\n"); 
		query.append("  ,substr(@[cust_cd], 3, 6)" ).append("\n"); 
		query.append("  ,@[cust_kman_seq]" ).append("\n"); 
		query.append("  , @[intl_phn_no]" ).append("\n"); 
		query.append("  , @[kman_ofc_fax_no]" ).append("\n"); 
		query.append(" )" ).append("\n"); 

	}
}