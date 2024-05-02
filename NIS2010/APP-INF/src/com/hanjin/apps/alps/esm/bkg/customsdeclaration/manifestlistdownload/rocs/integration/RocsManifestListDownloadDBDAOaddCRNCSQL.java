/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RocsManifestListDownloadDBDAOaddCRNCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.06
*@LastModifier : 임재택
*@LastVersion : 1.0
* 2009.07.06 임재택
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.rocs.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author LIM JAE TAEK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RocsManifestListDownloadDBDAOaddCRNCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * crn 정보 등록
	  * </pre>
	  */
	public RocsManifestListDownloadDBDAOaddCRNCSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_eng_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ntfy_ltr_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dem_free_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cstms_decl_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("brth_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_call_ref_no",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("INSERT INTO BKG_CSTMS_RTM_VSL" ).append("\n"); 
		query.append("(VSL_CALL_REF_NO,VSL_CALL_REF_STS_CD,VSL_CD,SKD_VOY_NO,SKD_DIR_CD,VVD_NM," ).append("\n"); 
		query.append("VVD_ETA_DT,      VVD_ETD_DT, 		 SLAN_CD," ).append("\n"); 
		query.append("DEM_FREE_DT,     BRTH_CTNT, 	     NTFY_LTR_CTNT," ).append("\n"); 
		query.append("CSTMS_DECL_USR_ID,CRE_USR_ID, UPD_USR_ID,     CRE_OFC_CD,         UPD_DT, 		CRE_DT)" ).append("\n"); 
		query.append("SELECT  @[vsl_call_ref_no],'N',@[vsl_cd],@[skd_voy_no], @[skd_dir_cd],@[vsl_eng_nm]," ).append("\n"); 
		query.append("VPS_ETA_DT, VPS_ETD_DT, SLAN_CD," ).append("\n"); 
		query.append("TO_DATE(@[dem_free_dt],'YYYY-MM-DD'),@[brth_ctnt],@[ntfy_ltr_ctnt]," ).append("\n"); 
		query.append("@[cstms_decl_usr_id],@[cstms_decl_usr_id],@[cstms_decl_usr_id],@[user_ofc_cd],sysdate,sysdate" ).append("\n"); 
		query.append("FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("WHERE   VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("AND 	SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("AND 	SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("AND 	VPS_PORT_CD = 'NLRTM'" ).append("\n"); 
		query.append("AND 	rownum = 1" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.nis2010.esm.bkg.customsdeclaration.manifestlistdownload.rocs.integration").append("\n"); 
		query.append("FileName : RocsManifestListDownloadDBDAOaddCRNCSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}