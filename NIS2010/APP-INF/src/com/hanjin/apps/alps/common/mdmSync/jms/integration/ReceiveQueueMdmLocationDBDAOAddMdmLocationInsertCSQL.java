/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ReceiveQueueMdmLocationDBDAOAddMdmLocationInsertCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.06.28
*@LastModifier : 
*@LastVersion : 1.0
* 2010.06.28 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.common.mdmSync.jms.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ReceiveQueueMdmLocationDBDAOAddMdmLocationInsertCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AddMdmLocationInsert
	  * </pre>
	  */
	public ReceiveQueueMdmLocationDBDAOAddMdmLocationInsertCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_ams_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bfr_eq_ctrl_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cstms_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_ctrl_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gmt_hrs",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eai_if_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sen_eq_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cml_zn_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("finc_ctrl_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("port_inlnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_rtn_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_grd_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("un_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("delt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("zip_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hub_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_lat",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sconti_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eai_evnt_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_bl_pfx_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sls_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ste_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("un_loc_ind_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("blk_port_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_lon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("conti_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_chr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mty_pkup_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bfr_finc_ctrl_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lon_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_locl_lang_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("call_port_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bfr_sls_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bfr_ofc_cng_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rep_zn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lat_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.common.mdmSync.jms.integration").append("\n"); 
		query.append("FileName : ReceiveQueueMdmLocationDBDAOAddMdmLocationInsertCSQL").append("\n"); 
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
		query.append("INSERT" ).append("\n"); 
		query.append("INTO mdm_location " ).append("\n"); 
		query.append("( " ).append("\n"); 
		query.append("      loc_cd" ).append("\n"); 
		query.append("      , scc_cd" ).append("\n"); 
		query.append("      , loc_nm" ).append("\n"); 
		query.append("      , rgn_cd" ).append("\n"); 
		query.append("      , cnt_cd" ).append("\n"); 
		query.append("      , ste_cd" ).append("\n"); 
		query.append("      , conti_cd" ).append("\n"); 
		query.append("      , sconti_cd" ).append("\n"); 
		query.append("      , port_inlnd_cd" ).append("\n"); 
		query.append("      , loc_chr_cd" ).append("\n"); 
		query.append("      , blk_port_flg" ).append("\n"); 
		query.append("      , hub_loc_cd" ).append("\n"); 
		query.append("      , sls_ofc_cd" ).append("\n"); 
		query.append("      , loc_grd_no" ).append("\n"); 
		query.append("      , gmt_hrs" ).append("\n"); 
		query.append("      , bkg_bl_pfx_cd" ).append("\n"); 
		query.append("      , call_port_flg" ).append("\n"); 
		query.append("      , loc_ams_port_cd" ).append("\n"); 
		query.append("      , finc_ctrl_ofc_cd" ).append("\n"); 
		query.append("      , eq_ctrl_ofc_cd" ).append("\n"); 
		query.append("      , mty_pkup_yd_cd" ).append("\n"); 
		query.append("      , sen_eq_ofc_cd" ).append("\n"); 
		query.append("      , eq_rtn_yd_cd			" ).append("\n"); 
		query.append("      , un_loc_cd" ).append("\n"); 
		query.append("      , cml_zn_flg" ).append("\n"); 
		query.append("      , cstms_cd" ).append("\n"); 
		query.append("      , loc_tp_cd" ).append("\n"); 
		query.append("      , bfr_finc_ctrl_ofc_cd" ).append("\n"); 
		query.append("      , bfr_eq_ctrl_ofc_cd" ).append("\n"); 
		query.append("      , bfr_sls_ofc_cd" ).append("\n"); 
		query.append("      , bfr_ofc_cng_dt" ).append("\n"); 
		query.append("      , zip_cd" ).append("\n"); 
		query.append("      , cre_usr_id" ).append("\n"); 
		query.append("      , cre_dt" ).append("\n"); 
		query.append("      , upd_usr_id" ).append("\n"); 
		query.append("      , upd_dt" ).append("\n"); 
		query.append("      , delt_flg" ).append("\n"); 
		query.append("      , rep_zn_cd" ).append("\n"); 
		query.append("      , eai_evnt_dt" ).append("\n"); 
		query.append("	  , loc_locl_lang_nm" ).append("\n"); 
		query.append("	  , un_loc_ind_cd" ).append("\n"); 
		query.append("-------2010.04.28" ).append("\n"); 
		query.append("      , loc_lat" ).append("\n"); 
		query.append("      , lat_ut_cd" ).append("\n"); 
		query.append("      , loc_lon" ).append("\n"); 
		query.append("      , lon_ut_cd" ).append("\n"); 
		query.append("	  , eai_if_id" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES " ).append("\n"); 
		query.append("( " ).append("\n"); 
		query.append("	  @[loc_cd]" ).append("\n"); 
		query.append("      , @[scc_cd]" ).append("\n"); 
		query.append("      , @[loc_nm]" ).append("\n"); 
		query.append("      , @[rgn_cd]" ).append("\n"); 
		query.append("      , @[cnt_cd]" ).append("\n"); 
		query.append("      , @[ste_cd]" ).append("\n"); 
		query.append("      , @[conti_cd]" ).append("\n"); 
		query.append("      , @[sconti_cd]" ).append("\n"); 
		query.append("      , @[port_inlnd_cd]" ).append("\n"); 
		query.append("      , @[loc_chr_cd]" ).append("\n"); 
		query.append("      , @[blk_port_flg]" ).append("\n"); 
		query.append("      , @[hub_loc_cd]" ).append("\n"); 
		query.append("      , @[sls_ofc_cd]" ).append("\n"); 
		query.append("      , @[loc_grd_no]" ).append("\n"); 
		query.append("      , @[gmt_hrs]" ).append("\n"); 
		query.append("      , @[bkg_bl_pfx_cd]" ).append("\n"); 
		query.append("      , @[call_port_flg]" ).append("\n"); 
		query.append("      , @[loc_ams_port_cd]" ).append("\n"); 
		query.append("      , @[finc_ctrl_ofc_cd]" ).append("\n"); 
		query.append("      , @[eq_ctrl_ofc_cd]" ).append("\n"); 
		query.append("      , @[mty_pkup_yd_cd]" ).append("\n"); 
		query.append("      , @[sen_eq_ofc_cd]" ).append("\n"); 
		query.append("      , @[eq_rtn_yd_cd]" ).append("\n"); 
		query.append("      , @[un_loc_cd]" ).append("\n"); 
		query.append("      , @[cml_zn_flg]" ).append("\n"); 
		query.append("      , @[cstms_cd]" ).append("\n"); 
		query.append("      , @[loc_tp_cd]" ).append("\n"); 
		query.append("      , @[bfr_finc_ctrl_ofc_cd]" ).append("\n"); 
		query.append("      , @[bfr_eq_ctrl_ofc_cd]" ).append("\n"); 
		query.append("      , @[bfr_sls_ofc_cd]" ).append("\n"); 
		query.append("      , to_date(@[bfr_ofc_cng_dt], 'yyyymmddhh24miss')" ).append("\n"); 
		query.append("      , @[zip_cd]" ).append("\n"); 
		query.append("      , @[cre_usr_id]" ).append("\n"); 
		query.append("      , to_date(@[cre_dt], 'yyyymmddhh24miss')" ).append("\n"); 
		query.append("      , @[upd_usr_id]" ).append("\n"); 
		query.append("      , to_date(@[upd_dt], 'yyyymmddhh24miss')" ).append("\n"); 
		query.append("      , @[delt_flg]" ).append("\n"); 
		query.append("      , @[rep_zn_cd]" ).append("\n"); 
		query.append("      , to_date(@[eai_evnt_dt], 'yyyymmddhh24miss') " ).append("\n"); 
		query.append("      , @[loc_locl_lang_nm]" ).append("\n"); 
		query.append("	  , @[un_loc_ind_cd]" ).append("\n"); 
		query.append("-------2010.04.28" ).append("\n"); 
		query.append("      , @[loc_lat]" ).append("\n"); 
		query.append("      , @[lat_ut_cd]" ).append("\n"); 
		query.append("      , @[loc_lon]" ).append("\n"); 
		query.append("      , @[lon_ut_cd]" ).append("\n"); 
		query.append("	  , @[eai_if_id]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}