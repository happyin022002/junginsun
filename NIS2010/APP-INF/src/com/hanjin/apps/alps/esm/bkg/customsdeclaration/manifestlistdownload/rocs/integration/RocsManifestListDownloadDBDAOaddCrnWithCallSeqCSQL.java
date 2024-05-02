/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : RocsManifestListDownloadDBDAOaddCrnWithCallSeqCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.02
*@LastModifier : 
*@LastVersion : 1.0
* 2015.04.02 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.rocs.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RocsManifestListDownloadDBDAOaddCrnWithCallSeqCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CRN 정보 등록
	  * </pre>
	  */
	public RocsManifestListDownloadDBDAOaddCrnWithCallSeqCSQL(){
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
		params.put("pod_clpt_ind_seq",new String[]{arrTmp[0],arrTmp[1]});

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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.rocs.integration ").append("\n"); 
		query.append("FileName : RocsManifestListDownloadDBDAOaddCrnWithCallSeqCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_CSTMS_RTM_VSL" ).append("\n"); 
		query.append("( VSL_CALL_REF_NO" ).append("\n"); 
		query.append(" ,VSL_CALL_REF_STS_CD" ).append("\n"); 
		query.append(" ,VSL_CD,SKD_VOY_NO" ).append("\n"); 
		query.append(" ,SKD_DIR_CD" ).append("\n"); 
		query.append(" ,VVD_NM" ).append("\n"); 
		query.append(" ,VVD_ETA_DT" ).append("\n"); 
		query.append(" ,VVD_ETD_DT" ).append("\n"); 
		query.append(" ,SLAN_CD" ).append("\n"); 
		query.append(" ,DEM_FREE_DT" ).append("\n"); 
		query.append(" ,BRTH_CTNT" ).append("\n"); 
		query.append(" ,NTFY_LTR_CTNT" ).append("\n"); 
		query.append(" ,CSTMS_DECL_USR_ID" ).append("\n"); 
		query.append(" ,CRE_USR_ID" ).append("\n"); 
		query.append(" ,CRE_DT" ).append("\n"); 
		query.append(" ,UPD_USR_ID" ).append("\n"); 
		query.append(" ,UPD_DT" ).append("\n"); 
		query.append(" ,CRE_OFC_CD" ).append("\n"); 
		query.append(" ,POD_CLPT_IND_SEQ" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT  @[vsl_call_ref_no]" ).append("\n"); 
		query.append("        , 'N'" ).append("\n"); 
		query.append("        , @[vsl_cd] " ).append("\n"); 
		query.append("        , @[skd_voy_no]" ).append("\n"); 
		query.append("        , @[skd_dir_cd]" ).append("\n"); 
		query.append("        , @[vsl_eng_nm]" ).append("\n"); 
		query.append("        , VPS_ETA_DT" ).append("\n"); 
		query.append("        , VPS_ETD_DT" ).append("\n"); 
		query.append("        , SLAN_CD" ).append("\n"); 
		query.append("        , TO_DATE(@[dem_free_dt],'YYYY-MM-DD')" ).append("\n"); 
		query.append("        , @[brth_ctnt]" ).append("\n"); 
		query.append("        , @[ntfy_ltr_ctnt]" ).append("\n"); 
		query.append("        , @[cstms_decl_usr_id]" ).append("\n"); 
		query.append("        , @[cstms_decl_usr_id]" ).append("\n"); 
		query.append("        , sysdate" ).append("\n"); 
		query.append("        , @[cstms_decl_usr_id]" ).append("\n"); 
		query.append("        , sysdate" ).append("\n"); 
		query.append("        , @[user_ofc_cd]" ).append("\n"); 
		query.append("        , @[pod_clpt_ind_seq]" ).append("\n"); 
		query.append("FROM  VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("WHERE VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("  AND SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("  AND SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("  AND VPS_PORT_CD = 'NLRTM'" ).append("\n"); 
		query.append("  AND CLPT_IND_SEQ = @[pod_clpt_ind_seq]" ).append("\n"); 
		query.append("  AND rownum = 1" ).append("\n"); 

	}
}