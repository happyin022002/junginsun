/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CargoReleaseOrderDBDAOMergeOtsUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.08.31
*@LastModifier : 이지영
*@LastVersion : 1.0
* 2010.08.31 이지영
* 1.0 Creation
 --------------------------------------------------------------------------------------
* History
* 2010.09.06 이지영 [CHM-201005721-01] [ESM-BKG] VVD별 OTS 미수금 수신
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author LEE JI-YOUNG
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CargoReleaseOrderDBDAOMergeOtsUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ...
	  * </pre>
	  */
	public CargoReleaseOrderDBDAOMergeOtsUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ots_occr_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ots_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clt_bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cr_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ots_due_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ots_bnd_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n2nd_clt_rqst_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lst_upd_chk_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ots_stl_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clt_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lst_clt_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n1st_clt_rqst_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ots_tj_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bil_to_cust_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xch_rt_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ots_grp_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3rd_clt_rqst_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration").append("\n"); 
		query.append("FileName : CargoReleaseOrderDBDAOMergeOtsUSQL").append("\n"); 
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
		query.append("MERGE INTO BKG_OUTSTANDING A" ).append("\n"); 
		query.append("USING (SELECT  @[ofc_cd]                                            AS OFC_CD             " ).append("\n"); 
		query.append("              ,@[clt_bl_no]                                         AS CLT_BL_NO          " ).append("\n"); 
		query.append("              ,@[inv_no]                                            AS INV_NO             " ).append("\n"); 
		query.append("              ,@[ofc_curr_cd]                                       AS OFC_CURR_CD        " ).append("\n"); 
		query.append("              ,@[ots_bkg_no]                                        AS OTS_BKG_NO   " ).append("\n"); 
		query.append("              ,@[cr_flg]                                            AS CR_FLG        " ).append("\n"); 
		query.append("              ,TO_DATE(@[ots_due_dt],'YYYY-MM-DD HH24:MI:SS')       AS OTS_DUE_DT         " ).append("\n"); 
		query.append("              ,@[ots_stl_flg]                                       AS OTS_STL_FLG        " ).append("\n"); 
		query.append("              ,@[xch_rt_tp_cd]                                      AS XCH_RT_TP_CD " ).append("\n"); 
		query.append("              ,@[bil_to_cust_cd]                                    AS BIL_TO_CUST_CD         " ).append("\n"); 
		query.append("              ,@[clt_rmk]                                           AS CLT_RMK            " ).append("\n"); 
		query.append("              ,@[ots_grp_tp_cd]                                     AS OTS_GRP_TP_CD      " ).append("\n"); 
		query.append("              ,@[ots_occr_tp_cd]                                    AS OTS_OCCR_TP_CD     " ).append("\n"); 
		query.append("              ,TO_DATE(@[n1st_clt_rqst_dt],'YYYY-MM-DD HH24:MI:SS') AS N1ST_CLT_RQST_DT   " ).append("\n"); 
		query.append("              ,TO_DATE(@[n2nd_clt_rqst_dt],'YYYY-MM-DD HH24:MI:SS') AS N2ND_CLT_RQST_DT   " ).append("\n"); 
		query.append("              ,TO_DATE(@[n3rd_clt_rqst_dt],'YYYY-MM-DD HH24:MI:SS') AS N3RD_CLT_RQST_DT   " ).append("\n"); 
		query.append("              ,@[lst_clt_ofc_cd]                                    AS LST_CLT_OFC_CD     " ).append("\n"); 
		query.append("              ,TO_DATE(@[lst_upd_chk_dt],'YYYY-MM-DD HH24:MI:SS')   AS LST_UPD_CHK_DT     " ).append("\n"); 
		query.append("              ,@[ots_bnd_tp_cd]                                     AS OTS_BND_TP_CD   " ).append("\n"); 
		query.append("              ,NULL 						    AS XTRA_RMK1" ).append("\n"); 
		query.append("              ,NULL 						    AS XTRA_RMK2" ).append("\n"); 
		query.append("              ,NULL						        AS XTRA_RMK3     " ).append("\n"); 
		query.append("              ,@[ots_tj_seq]						        AS OTS_TJ_SEQ     " ).append("\n"); 
		query.append("              ,SYSDATE                                              AS CRE_DT             " ).append("\n"); 
		query.append("              ,'BKG_ESM071'                                         AS CRE_USR_ID         " ).append("\n"); 
		query.append("              ,SYSDATE                                              AS UPD_DT             " ).append("\n"); 
		query.append("              ,'BKG_ESM071'                                         AS UPD_USR_ID         " ).append("\n"); 
		query.append("       FROM DUAL" ).append("\n"); 
		query.append("      ) B" ).append("\n"); 
		query.append("ON (A.OFC_CD = B.OFC_CD AND A.CLT_BL_NO = B.CLT_BL_NO AND A.INV_NO = B.INV_NO )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UPDATE  SET CR_FLG = B.CR_FLG" ).append("\n"); 
		query.append("       ,BIL_TO_CUST_CD    = B.BIL_TO_CUST_CD" ).append("\n"); 
		query.append("       ,OFC_CURR_CD       = B.OFC_CURR_CD" ).append("\n"); 
		query.append("       ,OTS_BKG_NO        = B.OTS_BKG_NO" ).append("\n"); 
		query.append("       ,OTS_DUE_DT        = B.OTS_DUE_DT" ).append("\n"); 
		query.append("       ,OTS_STL_FLG       = B.OTS_STL_FLG" ).append("\n"); 
		query.append("       ,XCH_RT_TP_CD      = B.XCH_RT_TP_CD" ).append("\n"); 
		query.append("       ,CLT_RMK           = B.CLT_RMK" ).append("\n"); 
		query.append("       ,OTS_GRP_TP_CD     = B.OTS_GRP_TP_CD" ).append("\n"); 
		query.append("       ,OTS_OCCR_TP_CD    = B.OTS_OCCR_TP_CD" ).append("\n"); 
		query.append("       ,N1ST_CLT_RQST_DT  = B.N1ST_CLT_RQST_DT" ).append("\n"); 
		query.append("       ,N2ND_CLT_RQST_DT  = B.N2ND_CLT_RQST_DT" ).append("\n"); 
		query.append("       ,N3RD_CLT_RQST_DT  = B.N3RD_CLT_RQST_DT" ).append("\n"); 
		query.append("       ,LST_CLT_OFC_CD    = B.LST_CLT_OFC_CD" ).append("\n"); 
		query.append("       ,LST_UPD_CHK_DT    = B.LST_UPD_CHK_DT" ).append("\n"); 
		query.append("       ,OTS_BND_TP_CD     = B.OTS_BND_TP_CD" ).append("\n"); 
		query.append("       ,OTS_TJ_SEQ        = B.OTS_TJ_SEQ" ).append("\n"); 
		query.append("       ,CRE_DT            = B.CRE_DT" ).append("\n"); 
		query.append("       ,CRE_USR_ID        = B.CRE_USR_ID" ).append("\n"); 
		query.append("       ,UPD_DT            = B.UPD_DT" ).append("\n"); 
		query.append("       ,UPD_USR_ID        = B.UPD_USR_ID" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("INSERT ( CR_FLG" ).append("\n"); 
		query.append("               ,BIL_TO_CUST_CD" ).append("\n"); 
		query.append("               ,OFC_CD" ).append("\n"); 
		query.append("               ,CLT_BL_NO" ).append("\n"); 
		query.append("               ,INV_NO" ).append("\n"); 
		query.append("               ,OFC_CURR_CD" ).append("\n"); 
		query.append("               ,OTS_BKG_NO" ).append("\n"); 
		query.append("               ,OTS_DUE_DT" ).append("\n"); 
		query.append("               ,OTS_STL_FLG" ).append("\n"); 
		query.append("               ,XCH_RT_TP_CD" ).append("\n"); 
		query.append("               ,CLT_RMK" ).append("\n"); 
		query.append("               ,OTS_GRP_TP_CD" ).append("\n"); 
		query.append("               ,OTS_OCCR_TP_CD" ).append("\n"); 
		query.append("               ,N1ST_CLT_RQST_DT" ).append("\n"); 
		query.append("               ,N2ND_CLT_RQST_DT" ).append("\n"); 
		query.append("               ,N3RD_CLT_RQST_DT" ).append("\n"); 
		query.append("               ,LST_CLT_OFC_CD" ).append("\n"); 
		query.append("               ,LST_UPD_CHK_DT" ).append("\n"); 
		query.append("               ,OTS_BND_TP_CD" ).append("\n"); 
		query.append("               ,OTS_TJ_SEQ" ).append("\n"); 
		query.append("               ,CRE_DT" ).append("\n"); 
		query.append("               ,CRE_USR_ID" ).append("\n"); 
		query.append("               ,UPD_DT" ).append("\n"); 
		query.append("               ,UPD_USR_ID" ).append("\n"); 
		query.append(") VALUES( B.CR_FLG             " ).append("\n"); 
		query.append("         ,B.BIL_TO_CUST_CD     " ).append("\n"); 
		query.append("         ,B.OFC_CD             " ).append("\n"); 
		query.append("         ,B.CLT_BL_NO          " ).append("\n"); 
		query.append("         ,B.INV_NO             " ).append("\n"); 
		query.append("         ,B.OFC_CURR_CD        " ).append("\n"); 
		query.append("         ,B.OTS_BKG_NO         " ).append("\n"); 
		query.append("         ,B.OTS_DUE_DT         " ).append("\n"); 
		query.append("         ,B.OTS_STL_FLG        " ).append("\n"); 
		query.append("         ,B.XCH_RT_TP_CD       " ).append("\n"); 
		query.append("         ,B.CLT_RMK            " ).append("\n"); 
		query.append("         ,B.OTS_GRP_TP_CD      " ).append("\n"); 
		query.append("         ,B.OTS_OCCR_TP_CD     " ).append("\n"); 
		query.append("         ,B.N1ST_CLT_RQST_DT   " ).append("\n"); 
		query.append("         ,B.N2ND_CLT_RQST_DT   " ).append("\n"); 
		query.append("         ,B.N3RD_CLT_RQST_DT   " ).append("\n"); 
		query.append("         ,B.LST_CLT_OFC_CD     " ).append("\n"); 
		query.append("         ,B.LST_UPD_CHK_DT     " ).append("\n"); 
		query.append("         ,B.OTS_BND_TP_CD  " ).append("\n"); 
		query.append("         ,B.OTS_TJ_SEQ    " ).append("\n"); 
		query.append("         ,B.CRE_DT             " ).append("\n"); 
		query.append("         ,B.CRE_USR_ID         " ).append("\n"); 
		query.append("         ,B.UPD_DT             " ).append("\n"); 
		query.append("         ,B.UPD_USR_ID         " ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}