/*=========================================================
*Copyright(c) 2018 SM Line
*@FileName : LocationDBDAOaddLocIbisIfCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.04.02
*@LastModifier : 
*@LastVersion : 1.0
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.bcm.ccd.commoncode.location.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class LocationDBDAOaddLocIbisIfCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public LocationDBDAOaddLocIbisIfCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("loc_nm",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("new_loc_lat",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("eq_ctrl_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("modi_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sls_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("scc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("zip_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("conti_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("hub_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("call_port_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("new_loc_lon",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("lat_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_inlnd_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("mty_pkup_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ecom_insf_dv_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("finc_ctrl_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cstms_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lon_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.bcm.ccd.commoncode.location.integration").append("\n"); 
		query.append("FileName : LocationDBDAOaddLocIbisIfCSQL").append("\n"); 
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
		query.append("INSERT INTO MDM_LOCATION_IBIS_IF( " ).append("\n"); 
		query.append("             LOC_IBIS_IF_SEQ" ).append("\n"); 
		query.append("            ,LOC_CD" ).append("\n"); 
		query.append("            ,SCC_CD" ).append("\n"); 
		query.append("            ,LOC_NM" ).append("\n"); 
		query.append("            ,RGN_CD" ).append("\n"); 
		query.append("            ,CNT_CD" ).append("\n"); 
		query.append("            ,STE_CD" ).append("\n"); 
		query.append("            ,CONTI_CD" ).append("\n"); 
		query.append("            ,PORT_INLND_FLG" ).append("\n"); 
		query.append("            ,LOC_CHR_CD" ).append("\n"); 
		query.append("            ,HUB_LOC_CD" ).append("\n"); 
		query.append("            ,SLS_OFC_CD" ).append("\n"); 
		query.append("            ,GMT_HRS" ).append("\n"); 
		query.append("            ,CALL_PORT_FLG" ).append("\n"); 
		query.append("            ,LOC_AMS_PORT_CD" ).append("\n"); 
		query.append("            ,FINC_CTRL_OFC_CD" ).append("\n"); 
		query.append("            ,EQ_CTRL_OFC_CD" ).append("\n"); 
		query.append("            ,MTY_PKUP_YD_CD" ).append("\n"); 
		query.append("            ,EQ_RTN_YD_CD" ).append("\n"); 
		query.append("            ,UN_LOC_IND_CD" ).append("\n"); 
		query.append("            ,UN_LOC_CD" ).append("\n"); 
		query.append("            ,CML_ZN_FLG" ).append("\n"); 
		query.append("            ,CSTMS_CD" ).append("\n"); 
		query.append("            ,LOC_TP_CD" ).append("\n"); 
		query.append("            ,REP_ZN_CD" ).append("\n"); 
		query.append("            ,ZIP_CD" ).append("\n"); 
		query.append("            ,SCONTI_CD" ).append("\n"); 
		query.append("            ,LOC_LOCL_LANG_NM" ).append("\n"); 
		query.append("            ,LOC_LAT" ).append("\n"); 
		query.append("            ,LAT_UT_CD" ).append("\n"); 
		query.append("            ,LOC_LON" ).append("\n"); 
		query.append("            ,LON_UT_CD" ).append("\n"); 
		query.append("            ,CRE_USR_ID" ).append("\n"); 
		query.append("            ,CRE_DT" ).append("\n"); 
		query.append("            ,UPD_USR_ID" ).append("\n"); 
		query.append("            ,UPD_DT" ).append("\n"); 
		query.append("            ,DELT_FLG" ).append("\n"); 
		query.append("            ,MODI_LOC_CD" ).append("\n"); 
		query.append("            ,IF_MNPL_CD" ).append("\n"); 
		query.append("            ,NEW_LOC_LAT" ).append("\n"); 
		query.append("            ,NEW_LOC_LON" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("    VALUES(  MDM_LOCATION_IBIS_IF_SEQ.NEXTVAL" ).append("\n"); 
		query.append("            ,@[loc_cd]" ).append("\n"); 
		query.append("            ,@[scc_cd]" ).append("\n"); 
		query.append("            ,@[loc_nm]" ).append("\n"); 
		query.append("            ,@[rgn_cd]" ).append("\n"); 
		query.append("            ,@[cnt_cd]" ).append("\n"); 
		query.append("            ,@[ste_cd]" ).append("\n"); 
		query.append("            ,@[conti_cd]" ).append("\n"); 
		query.append("            ,@[port_inlnd_flg]" ).append("\n"); 
		query.append("            ,@[loc_chr_cd]" ).append("\n"); 
		query.append("            ,@[hub_loc_cd]" ).append("\n"); 
		query.append("            ,@[sls_ofc_cd]" ).append("\n"); 
		query.append("            ,@[gmt_hrs]" ).append("\n"); 
		query.append("            ,@[call_port_flg]" ).append("\n"); 
		query.append("            ,@[loc_ams_port_cd]" ).append("\n"); 
		query.append("            ,@[finc_ctrl_ofc_cd]" ).append("\n"); 
		query.append("            ,@[eq_ctrl_ofc_cd]" ).append("\n"); 
		query.append("            ,@[mty_pkup_yd_cd]" ).append("\n"); 
		query.append("            ,@[eq_rtn_yd_cd]" ).append("\n"); 
		query.append("            ,@[un_loc_ind_cd]" ).append("\n"); 
		query.append("            ,@[un_loc_cd]" ).append("\n"); 
		query.append("            ,@[cml_zn_flg]" ).append("\n"); 
		query.append("            ,@[cstms_cd]" ).append("\n"); 
		query.append("            ,@[loc_tp_cd]" ).append("\n"); 
		query.append("            ,@[rep_zn_cd]" ).append("\n"); 
		query.append("            ,@[zip_cd]" ).append("\n"); 
		query.append("            ,@[sconti_cd]" ).append("\n"); 
		query.append("            ,@[loc_locl_lang_nm]" ).append("\n"); 
		query.append("            ,@[loc_lat]" ).append("\n"); 
		query.append("            ,@[lat_ut_cd]" ).append("\n"); 
		query.append("            ,@[loc_lon]" ).append("\n"); 
		query.append("            ,@[lon_ut_cd]" ).append("\n"); 
		query.append("            ,@[cre_usr_id]" ).append("\n"); 
		query.append("            ,SYSDATE" ).append("\n"); 
		query.append("            ,@[upd_usr_id]" ).append("\n"); 
		query.append("            ,SYSDATE" ).append("\n"); 
		query.append("            ,@[delt_flg]" ).append("\n"); 
		query.append("            ,@[modi_loc_cd]" ).append("\n"); 
		query.append("            ,@[ecom_insf_dv_cd]" ).append("\n"); 
		query.append("            ,@[new_loc_lat]" ).append("\n"); 
		query.append("            ,@[new_loc_lon]" ).append("\n"); 
		query.append("            ) " ).append("\n"); 

	}
}