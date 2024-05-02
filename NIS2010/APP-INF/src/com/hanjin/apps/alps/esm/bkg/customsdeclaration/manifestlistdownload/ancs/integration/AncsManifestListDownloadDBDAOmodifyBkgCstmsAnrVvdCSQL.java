/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : AncsManifestListDownloadDBDAOmodifyBkgCstmsAnrVvdCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.10.17
*@LastModifier : 김보배
*@LastVersion : 1.0
* 2013.10.17 김보배
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.ancs.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author BOBAE KIM
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AncsManifestListDownloadDBDAOmodifyBkgCstmsAnrVvdCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * INSERT
	  * </pre>
	  */
	public AncsManifestListDownloadDBDAOmodifyBkgCstmsAnrVvdCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lloyd_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("anr_msg_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("lst_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("gen_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eta_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gen_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lloyd_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_rqst_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dat_cre_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("dep_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rgst_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("brth_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.ancs.integration").append("\n"); 
		query.append("FileName : AncsManifestListDownloadDBDAOmodifyBkgCstmsAnrVvdCSQL").append("\n"); 
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
		query.append("MERGE INTO BKG_CSTMS_ANR_VVD A" ).append("\n"); 
		query.append("	  USING ( SELECT BVVD 			  " ).append("\n"); 
		query.append("	  		  FROM (SELECT B.VSL_CD || B.SKD_VOY_NO || B.SKD_DIR_CD AS BVVD" ).append("\n"); 
		query.append("		   		  FROM BKG_CSTMS_ANR_VVD B" ).append("\n"); 
		query.append("				  WHERE 1=1" ).append("\n"); 
		query.append("				  AND B.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("				  AND B.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("				  AND B.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("				  UNION  			  " ).append("\n"); 
		query.append("				  SELECT 'ZZZZ' AS BVVD " ).append("\n"); 
		query.append("				  FROM DUAL )	" ).append("\n"); 
		query.append("			WHERE ROWNUM = 1	 )" ).append("\n"); 
		query.append("	  ON( BVVD = (A.VSL_CD || A.SKD_VOY_NO || A.SKD_DIR_CD) )" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("   UPDATE SET" ).append("\n"); 
		query.append(" SVC_RQST_NO   = @[svc_rqst_no]                                                                                                                                                                                                                    " ).append("\n"); 
		query.append(",LLOYD_TP_CD   = @[lloyd_tp_cd]                                                                                                                                                                                                                         " ).append("\n"); 
		query.append(",LLOYD_NO      = @[lloyd_no]   " ).append("\n"); 
		query.append(",VSL_CNT_CD    = @[vsl_cnt_cd]                                                                                                                                                                                                                 " ).append("\n"); 
		query.append(",VVD_NM        = @[vvd_nm] " ).append("\n"); 
		query.append(",DEP_LOC_CD    = @[dep_loc_cd] " ).append("\n"); 
		query.append(",BRTH_DESC     = @[brth_desc]" ).append("\n"); 
		query.append(",ETA_DT        = TO_DATE(@[eta_dt],'YYYY-MM-DD')                                                                                                                                                                                          " ).append("\n"); 
		query.append(",DEM_FREE_DT   = TO_DATE(@[dem_free_dt],'YYYY-MM-DD')" ).append("\n"); 
		query.append(",DIFF_RMK      = @[diff_rmk]" ).append("\n"); 
		query.append(",UPD_OFC_CD    = @[upd_ofc_cd]" ).append("\n"); 
		query.append(",UPD_USR_ID    = @[upd_usr_id]                                                                                                                                                                                                                " ).append("\n"); 
		query.append(",UPD_DT        = SYSDATE" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("INSERT " ).append("\n"); 
		query.append("(VSL_CD" ).append("\n"); 
		query.append(",SKD_VOY_NO" ).append("\n"); 
		query.append(",SKD_DIR_CD" ).append("\n"); 
		query.append(",SVC_RQST_NO" ).append("\n"); 
		query.append(",LLOYD_TP_CD" ).append("\n"); 
		query.append(",LLOYD_NO" ).append("\n"); 
		query.append(",VSL_CNT_CD" ).append("\n"); 
		query.append(",VVD_NM" ).append("\n"); 
		query.append(",ETA_DT" ).append("\n"); 
		query.append(",DEP_LOC_CD" ).append("\n"); 
		query.append(",BRTH_DESC" ).append("\n"); 
		query.append(",DEM_FREE_DT" ).append("\n"); 
		query.append(",DIFF_RMK" ).append("\n"); 
		query.append(",DAT_CRE_FLG" ).append("\n"); 
		query.append(",GEN_OFC_CD" ).append("\n"); 
		query.append(",GEN_DT" ).append("\n"); 
		query.append(",ANR_MSG_STS_CD" ).append("\n"); 
		query.append(",LST_SEQ" ).append("\n"); 
		query.append(",RGST_USR_ID" ).append("\n"); 
		query.append(",CRE_OFC_CD" ).append("\n"); 
		query.append(",UPD_OFC_CD" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",CRE_DT" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(",UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append(" @[vsl_cd]                                       " ).append("\n"); 
		query.append(",@[skd_voy_no]                                  " ).append("\n"); 
		query.append(",@[skd_dir_cd]                                  " ).append("\n"); 
		query.append(",@[svc_rqst_no]                                 " ).append("\n"); 
		query.append(",@[lloyd_tp_cd]                                 " ).append("\n"); 
		query.append(",@[lloyd_no]                                    " ).append("\n"); 
		query.append(",@[vsl_cnt_cd]                                  " ).append("\n"); 
		query.append(",@[vvd_nm]                                      " ).append("\n"); 
		query.append(",TO_DATE(@[eta_dt],'YYYY-MM-DD')                " ).append("\n"); 
		query.append(",@[dep_loc_cd]                                  " ).append("\n"); 
		query.append(",@[brth_desc]                                   " ).append("\n"); 
		query.append(",TO_DATE(@[dem_free_dt],'YYYY-MM-DD')           " ).append("\n"); 
		query.append(",@[diff_rmk]                                    " ).append("\n"); 
		query.append(",NVL(@[dat_cre_flg], 'N')" ).append("\n"); 
		query.append(",@[gen_ofc_cd]                                  " ).append("\n"); 
		query.append(",TO_DATE(@[gen_dt],'YYYY-MM-DD')                " ).append("\n"); 
		query.append(",@[anr_msg_sts_cd]                              " ).append("\n"); 
		query.append(",@[lst_seq]                                     " ).append("\n"); 
		query.append(",@[rgst_usr_id]                                 " ).append("\n"); 
		query.append(",@[cre_ofc_cd]                                  " ).append("\n"); 
		query.append(",@[upd_ofc_cd]                                  " ).append("\n"); 
		query.append(",@[cre_usr_id]                                  " ).append("\n"); 
		query.append(",SYSDATE                                        " ).append("\n"); 
		query.append(",@[upd_usr_id]                                  " ).append("\n"); 
		query.append(",SYSDATE                                        " ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}