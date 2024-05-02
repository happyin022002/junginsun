/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : UsaManifestListDownloadDBDAOaddAdvancedBlByBlCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.19
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2015.06.19 김민정
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Minjung Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaManifestListDownloadDBDAOaddAdvancedBlByBlCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * addAdvancedBlByBl
	  * </pre>
	  */
	public UsaManifestListDownloadDBDAOaddAdvancedBlByBlCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("meas_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scac_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vsl_arr_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cstms_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mf_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ca_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ca_no",new String[]{arrTmp[0],arrTmp[1]});

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

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("meas_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bdr_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frob_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cstms_file_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_to_ord_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bdr_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcv_term_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bdr_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pre_mf_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cstms_pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ams_pck_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_file_skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cstms_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usa_lst_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wgt_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cgo_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pck_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pod_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cstms_pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("full_mty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ca_iss_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("del_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.usa.integration").append("\n"); 
		query.append("FileName : UsaManifestListDownloadDBDAOaddAdvancedBlByBlCSQL").append("\n"); 
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
		query.append("  INTO BKG_CSTMS_ADV_BL" ).append("\n"); 
		query.append("      (CNT_CD" ).append("\n"); 
		query.append("      ,BL_NO" ).append("\n"); 
		query.append("      ,BKG_NO" ).append("\n"); 
		query.append("      ,VSL_CD" ).append("\n"); 
		query.append("      ,SKD_VOY_NO" ).append("\n"); 
		query.append("      ,SKD_DIR_CD" ).append("\n"); 
		query.append("      ,SLAN_CD" ).append("\n"); 
		query.append("      ,VSL_ARR_DT" ).append("\n"); 
		query.append("      ,CSTMS_PORT_CD" ).append("\n"); 
		query.append("      ,CSTMS_POL_CD" ).append("\n"); 
		query.append("      ,CSTMS_POD_CD" ).append("\n"); 
		query.append("      ,CSTMS_LOC_CD" ).append("\n"); 
		query.append("      ,FROB_FLG" ).append("\n"); 
		query.append("      ,POR_CD" ).append("\n"); 
		query.append("      ,POL_CD" ).append("\n"); 
		query.append("      ,POD_CD" ).append("\n"); 
		query.append("      ,DEL_CD" ).append("\n"); 
		query.append("      ,POD_NOD_CD" ).append("\n"); 
		query.append("      ,DEL_NOD_CD" ).append("\n"); 
		query.append("      ,CUST_TO_ORD_FLG" ).append("\n"); 
		query.append("      ,USA_LST_LOC_CD" ).append("\n"); 
		query.append("      ,HUB_LOC_CD" ).append("\n"); 
		query.append("      ,PCK_QTY" ).append("\n"); 
		query.append("      ,AMS_PCK_TP_CD" ).append("\n"); 
		query.append("      ,CGO_WGT" ).append("\n"); 
		query.append("      ,WGT_UT_CD" ).append("\n"); 
		query.append("      ,MEAS_QTY" ).append("\n"); 
		query.append("      ,MEAS_UT_CD" ).append("\n"); 
		query.append("      ,RCV_TERM_CD" ).append("\n"); 
		query.append("      ,DE_TERM_CD" ).append("\n"); 
		query.append("      ,BDR_FLG" ).append("\n"); 
		query.append("      ,BDR_DT" ).append("\n"); 
		query.append("      ,BDR_OFC_CD" ).append("\n"); 
		query.append("      ,CA_FLG" ).append("\n"); 
		query.append("      ,CA_ISS_DT" ).append("\n"); 
		query.append("      ,CA_NO" ).append("\n"); 
		query.append("      ,SCAC_CD" ).append("\n"); 
		query.append("      ,FULL_MTY_CD" ).append("\n"); 
		query.append("      ,MF_STS_CD" ).append("\n"); 
		query.append("      ,IF_FLG" ).append("\n"); 
		query.append("      ,IF_DT" ).append("\n"); 
		query.append("      ,MF_NO" ).append("\n"); 
		query.append("      ,PRE_MF_NO" ).append("\n"); 
		query.append("      ,CSTMS_FILE_TP_CD" ).append("\n"); 
		query.append("      ,ACT_FILE_SKD_DIR_CD" ).append("\n"); 
		query.append("      ,CRE_USR_ID" ).append("\n"); 
		query.append("      ,CRE_DT" ).append("\n"); 
		query.append("      ,UPD_USR_ID" ).append("\n"); 
		query.append("      ,UPD_DT" ).append("\n"); 
		query.append("     )" ).append("\n"); 
		query.append("VALUES" ).append("\n"); 
		query.append("      ( 'US'" ).append("\n"); 
		query.append("       ,@[bl_no]" ).append("\n"); 
		query.append("       ,@[bkg_no]" ).append("\n"); 
		query.append("       ,@[vsl_cd]" ).append("\n"); 
		query.append("       ,@[skd_voy_no]" ).append("\n"); 
		query.append("       ,@[skd_dir_cd]" ).append("\n"); 
		query.append("       ,@[slan_cd]" ).append("\n"); 
		query.append("       ,TO_DATE(@[vsl_arr_dt],'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("       ,@[cstms_port_cd]" ).append("\n"); 
		query.append("       ,@[cstms_pol_cd]" ).append("\n"); 
		query.append("       ,@[cstms_pod_cd]" ).append("\n"); 
		query.append("       ,DECODE(@[cstms_loc_cd], NULL, @[hub_loc_cd], @[cstms_loc_cd])" ).append("\n"); 
		query.append("       ,@[frob_flg]" ).append("\n"); 
		query.append("       ,@[por_cd]" ).append("\n"); 
		query.append("       ,@[pol_cd]" ).append("\n"); 
		query.append("       ,@[pod_cd]" ).append("\n"); 
		query.append("       ,@[del_cd]" ).append("\n"); 
		query.append("       ,@[pod_nod_cd]" ).append("\n"); 
		query.append("       ,@[del_nod_cd]" ).append("\n"); 
		query.append("       ,NVL(@[cust_to_ord_flg], 'N')" ).append("\n"); 
		query.append("       ,@[usa_lst_loc_cd]" ).append("\n"); 
		query.append("       ,@[hub_loc_cd]" ).append("\n"); 
		query.append("       ,NVL(@[pck_qty],0)" ).append("\n"); 
		query.append("       ,@[ams_pck_tp_cd]" ).append("\n"); 
		query.append("       ,NVL(@[cgo_wgt],0)" ).append("\n"); 
		query.append("       ,@[wgt_ut_cd]" ).append("\n"); 
		query.append("       ,NVL(@[meas_qty],0)" ).append("\n"); 
		query.append("       ,@[meas_ut_cd]" ).append("\n"); 
		query.append("       ,@[rcv_term_cd]" ).append("\n"); 
		query.append("       ,@[de_term_cd]" ).append("\n"); 
		query.append("       ,NVL(@[bdr_flg],'N')" ).append("\n"); 
		query.append("       ,TO_DATE(@[bdr_dt],'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("       ,@[bdr_ofc_cd]" ).append("\n"); 
		query.append("       ,NVL(@[ca_flg],'N')" ).append("\n"); 
		query.append("       ,TO_DATE(@[ca_iss_dt],'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("       ,@[ca_no]" ).append("\n"); 
		query.append("       ,@[scac_cd]" ).append("\n"); 
		query.append("       ,DECODE(@[full_mty_cd], 'P', 'M', 'F')" ).append("\n"); 
		query.append("       ,'A'" ).append("\n"); 
		query.append("       ,'Y'" ).append("\n"); 
		query.append("       ,GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS', SYSDATE, 'USNYC')" ).append("\n"); 
		query.append("       ,@[mf_no]" ).append("\n"); 
		query.append("       ,@[pre_mf_no]" ).append("\n"); 
		query.append("       ,@[cstms_file_tp_cd]" ).append("\n"); 
		query.append("       ,CASE WHEN SUBSTR(@[cstms_pol_cd],1,2) = 'CA' AND @[act_file_skd_dir_cd] IS NOT NULL THEN @[act_file_skd_dir_cd]" ).append("\n"); 
		query.append("             WHEN SUBSTR(@[cstms_pol_cd],1,2) = 'CA' AND @[skd_dir_cd] = 'W' THEN 'E'" ).append("\n"); 
		query.append("             WHEN SUBSTR(@[cstms_pol_cd],1,2) = 'CA' AND @[skd_dir_cd] = 'E' THEN 'W'" ).append("\n"); 
		query.append("             ELSE ''" ).append("\n"); 
		query.append("         END" ).append("\n"); 
		query.append("       ,@[cre_usr_id]" ).append("\n"); 
		query.append("       ,SYSDATE" ).append("\n"); 
		query.append("       ,@[upd_usr_id]" ).append("\n"); 
		query.append("       ,SYSDATE" ).append("\n"); 
		query.append("      )" ).append("\n"); 

	}
}