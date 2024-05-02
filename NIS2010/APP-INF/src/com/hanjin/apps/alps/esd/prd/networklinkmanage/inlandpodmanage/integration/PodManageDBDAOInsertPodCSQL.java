/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : PodManageDBDAOInsertPodCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.04.04
*@LastModifier : 
*@LastVersion : 1.0
* 2013.04.04 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandpodmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PodManageDBDAOInsertPodCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * InsertPod
	  * </pre>
	  */
	public PodManageDBDAOInsertPodCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_code",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pctl_imdg_clss_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("remarks",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pctl_io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("del_term",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trans_mode",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_code",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lane_code",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("service",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandpodmanage.integration").append("\n"); 
		query.append("FileName : PodManageDBDAOInsertPodCSQL").append("\n"); 
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
		query.append("MERGE INTO PRD_POD_MGMT T                       " ).append("\n"); 
		query.append("USING (SELECT @[pod_code]        AS POD_CD        " ).append("\n"); 
		query.append("            , @[lane_code]       AS SLAN_CD         " ).append("\n"); 
		query.append("            , @[del_code]        AS DEL_CD          " ).append("\n"); 
		query.append("            , @[del_term]        AS BKG_DE_TERM_CD  " ).append("\n"); 
		query.append("            , @[trans_mode]      AS TRSP_MOD_CD     " ).append("\n"); 
		query.append("            , ( SELECT STE_CD FROM MDM_LOCATION WHERE 1 = 1 AND LOC_CD = @[del_code] AND NVL(DELT_FLG, 'N') <> 'Y' ) ARR_STE_CD " ).append("\n"); 
		query.append("            , @[service]         AS APLY_SVC_MOD_FLG" ).append("\n"); 
		query.append("            , @[remarks]         AS BKG_RMK         " ).append("\n"); 
		query.append("            , 'N'                AS DELT_FLG   " ).append("\n"); 
		query.append("            , @[cre_ofc_cd]      AS CRE_OFC_CD     " ).append("\n"); 
		query.append("            , @[cre_usr_id]      AS CRE_USR_ID      " ).append("\n"); 
		query.append("            , SYSDATE            AS CRE_DT    " ).append("\n"); 
		query.append("            , @[upd_ofc_cd]      AS UPD_OFC_CD         " ).append("\n"); 
		query.append("            , @[upd_usr_id]      AS UPD_USR_ID      " ).append("\n"); 
		query.append("            , SYSDATE            AS UPD_DT          " ).append("\n"); 
		query.append("            , @[pctl_io_bnd_cd]  AS PCTL_IO_BND_CD  " ).append("\n"); 
		query.append("			, @[pctl_imdg_clss_ctnt] as pctl_imdg_clss_ctnt" ).append("\n"); 
		query.append("       FROM DUAL ) S" ).append("\n"); 
		query.append("ON ( 	T.POD_CD         = S.POD_CD        " ).append("\n"); 
		query.append("	AND T.SLAN_CD        = S.SLAN_CD       " ).append("\n"); 
		query.append("	AND T.DEL_CD         = S.DEL_CD        " ).append("\n"); 
		query.append("	AND T.BKG_DE_TERM_CD = S.BKG_DE_TERM_CD" ).append("\n"); 
		query.append("	AND T.TRSP_MOD_CD    = S.TRSP_MOD_CD   " ).append("\n"); 
		query.append("	AND T.PCTL_IO_BND_CD = S.PCTL_IO_BND_CD" ).append("\n"); 
		query.append("   )" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("UPDATE  " ).append("\n"); 
		query.append("SET T.ARR_STE_CD       = S.ARR_STE_CD       " ).append("\n"); 
		query.append("	, T.APLY_SVC_MOD_FLG = S.APLY_SVC_MOD_FLG " ).append("\n"); 
		query.append("	, T.BKG_RMK          = S.BKG_RMK          " ).append("\n"); 
		query.append("	, T.DELT_FLG         = S.DELT_FLG    " ).append("\n"); 
		query.append("    , T.CRE_OFC_CD       = S.CRE_OFC_CD     " ).append("\n"); 
		query.append("	, T.CRE_USR_ID       = S.CRE_USR_ID       " ).append("\n"); 
		query.append("	, T.CRE_DT           = S.CRE_DT    " ).append("\n"); 
		query.append("    , T.UPD_OFC_CD       = S.UPD_OFC_CD       " ).append("\n"); 
		query.append("	, T.UPD_USR_ID       = S.UPD_USR_ID       " ).append("\n"); 
		query.append("	, T.UPD_DT           = S.UPD_DT" ).append("\n"); 
		query.append("    , t.pctl_imdg_clss_ctnt = s.pctl_imdg_clss_ctnt" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN " ).append("\n"); 
		query.append("INSERT " ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("	  T.POD_CD" ).append("\n"); 
		query.append("    , T.SLAN_CD" ).append("\n"); 
		query.append("    , T.DEL_CD" ).append("\n"); 
		query.append("    , T.BKG_DE_TERM_CD" ).append("\n"); 
		query.append("    , T.TRSP_MOD_CD " ).append("\n"); 
		query.append("    , T.ARR_STE_CD " ).append("\n"); 
		query.append("    , T.APLY_SVC_MOD_FLG " ).append("\n"); 
		query.append("    , T.BKG_RMK " ).append("\n"); 
		query.append("    , T.DELT_FLG " ).append("\n"); 
		query.append("    , T.CRE_OFC_CD" ).append("\n"); 
		query.append("    , T.CRE_USR_ID " ).append("\n"); 
		query.append("    , T.CRE_DT " ).append("\n"); 
		query.append("    , T.UPD_OFC_CD" ).append("\n"); 
		query.append("    , T.UPD_USR_ID " ).append("\n"); 
		query.append("    , T.UPD_DT" ).append("\n"); 
		query.append("    , T.PCTL_IO_BND_CD" ).append("\n"); 
		query.append("	, t.pctl_imdg_clss_ctnt" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES(" ).append("\n"); 
		query.append("	  S.POD_CD" ).append("\n"); 
		query.append("    , S.SLAN_CD" ).append("\n"); 
		query.append("    , S.DEL_CD" ).append("\n"); 
		query.append("    , S.BKG_DE_TERM_CD" ).append("\n"); 
		query.append("    , S.TRSP_MOD_CD " ).append("\n"); 
		query.append("    , S.ARR_STE_CD " ).append("\n"); 
		query.append("    , S.APLY_SVC_MOD_FLG " ).append("\n"); 
		query.append("    , S.BKG_RMK " ).append("\n"); 
		query.append("    , S.DELT_FLG " ).append("\n"); 
		query.append("    , S.CRE_OFC_CD" ).append("\n"); 
		query.append("    , S.CRE_USR_ID " ).append("\n"); 
		query.append("    , S.CRE_DT " ).append("\n"); 
		query.append("    , S.UPD_OFC_CD" ).append("\n"); 
		query.append("    , S.UPD_USR_ID " ).append("\n"); 
		query.append("    , S.UPD_DT" ).append("\n"); 
		query.append("    , S.PCTL_IO_BND_CD " ).append("\n"); 
		query.append("    , s.pctl_imdg_clss_ctnt" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}