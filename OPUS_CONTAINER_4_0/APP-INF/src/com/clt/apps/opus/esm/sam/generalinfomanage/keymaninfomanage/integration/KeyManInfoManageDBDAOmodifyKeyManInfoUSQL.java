/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : KeyManInfoManageDBDAOmodifyKeyManInfoUSQL.java
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

public class KeyManInfoManageDBDAOmodifyKeyManInfoUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * KeyManInfoDBDAOmodifyKeyManInfo
	  * </pre>
	  */
	public KeyManInfoManageDBDAOmodifyKeyManInfoUSQL(){
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
		params.put("kman_gnd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : KeyManInfoManageDBDAOmodifyKeyManInfoUSQL").append("\n"); 
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
		query.append("UPDATE SAM_CUST_KMAN_INFO" ).append("\n"); 
		query.append("SET" ).append("\n"); 
		query.append("	 KMAN_N1ST_NM      = @[kman_n1st_nm]" ).append("\n"); 
		query.append("     , KMAN_LST_NM       = @[kman_lst_nm]" ).append("\n"); 
		query.append("     , KMAN_GND_CD       = @[kman_gnd_cd]" ).append("\n"); 
		query.append("     , KMAN_EML          = @[kman_eml]" ).append("\n"); 
		query.append("     , JB_TIT_RMK        = @[jb_tit_rmk]" ).append("\n"); 
		query.append("     , CHG_DESC          = @[chg_desc]" ).append("\n"); 
		query.append("     , KMAN_DEPT_DESC    = @[kman_dept_desc]" ).append("\n"); 
		query.append("     , KMAN_SGNF_IND_CD  = @[kman_sgnf_ind_cd]" ).append("\n"); 
		query.append("     , KMAN_NKNM_NM      = @[kman_nknm_nm]" ).append("\n"); 
		query.append("     , KMAN_BRDY_DT      = replace(@[kman_brdy_dt], '-', '')" ).append("\n"); 
		query.append("     , KMAN_EDU_CATE_CD  = @[kman_edu_cate_cd]" ).append("\n"); 
		query.append("     , KMAN_MJR_DESC     = @[kman_mjr_desc]" ).append("\n"); 
		query.append("     , KMAN_HBY_DESC     = @[kman_hby_desc]" ).append("\n"); 
		query.append("     , KMAN_MARR_FLG     = @[kman_marr_flg]" ).append("\n"); 
		query.append("     , KMAN_SPS_NM       = @[kman_sps_nm]" ).append("\n"); 
		query.append("     , KMAN_SPS_BRDY_DT  = replace(@[kman_sps_brdy_dt], '-', '')" ).append("\n"); 
		query.append("     , KMAN_WEDD_ANV_DT  = replace(@[kman_wedd_anv_dt], '-', '')" ).append("\n"); 
		query.append("     , KMAN_OFC_ADDR     = @[kman_ofc_addr]" ).append("\n"); 
		query.append("     , KMAN_HM_ADDR      = @[kman_hm_addr]" ).append("\n"); 
		query.append("     , BIZ_ISS_DESC      = @[biz_iss_desc]" ).append("\n"); 
		query.append("     , KMAN_RMK_DESC     = @[kman_rmk_desc]" ).append("\n"); 
		query.append("     , UPD_USR_ID        = @[usr_id]" ).append("\n"); 
		query.append("     , UPD_DT            = sysdate" ).append("\n"); 
		query.append("	 , KMAN_OFC_FAX_NO   = @[kman_ofc_fax_no]" ).append("\n"); 
		query.append("	 , INTL_PHN_NO       = @[intl_phn_no]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE CUST_KMAN_SEQ = @[cust_kman_seq]" ).append("\n"); 
		query.append("AND CUST_CNT_CD||LPAD(CUST_SEQ,6,0) = @[cust_cd]" ).append("\n"); 

	}
}