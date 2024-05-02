/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : WorkOrderPreviewDBDAOAddWorkOrderPreviewIssuedRjctHisCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.02
*@LastModifier : 
*@LastVersion : 1.0
* 2011.03.02 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.workordermanage.workorderpreview.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WorkOrderPreviewDBDAOAddWorkOrderPreviewIssuedRjctHisCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * trs_trsp_rjct_his insert
	  * </pre>
	  */
	public WorkOrderPreviewDBDAOAddWorkOrderPreviewIssuedRjctHisCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wo_prv_grp_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("wo_iss_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.workordermanage.workorderpreview.integration").append("\n"); 
		query.append("FileName : WorkOrderPreviewDBDAOAddWorkOrderPreviewIssuedRjctHisCSQL").append("\n"); 
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
		query.append("INSERT INTO TRS_TRSP_WRK_ORD_RJCT_HIS " ).append("\n"); 
		query.append("( " ).append("\n"); 
		query.append("    TRSP_SO_OFC_CTY_CD " ).append("\n"); 
		query.append("    , TRSP_SO_SEQ " ).append("\n"); 
		query.append("    , TRSP_WO_OFC_CTY_CD " ).append("\n"); 
		query.append("    , TRSP_WO_SEQ " ).append("\n"); 
		query.append("    , WO_VNDR_SEQ " ).append("\n"); 
		query.append("    , WO_RJCT_DT " ).append("\n"); 
		query.append("    , CRE_OFC_CD " ).append("\n"); 
		query.append("    , CRE_USR_ID " ).append("\n"); 
		query.append("    , CRE_DT " ).append("\n"); 
		query.append("    , UPD_USR_ID " ).append("\n"); 
		query.append("    , UPD_DT " ).append("\n"); 
		query.append("	, LOCL_CRE_DT" ).append("\n"); 
		query.append("	, LOCL_UPD_DT" ).append("\n"); 
		query.append("    , WO_RJCT_RSN " ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("    TMP.TRSP_SO_OFC_CTY_CD " ).append("\n"); 
		query.append("    , TMP.TRSP_SO_SEQ " ).append("\n"); 
		query.append("    , NVL(A.TRSP_WO_OFC_CTY_CD, TMP.TRSP_WO_OFC_CTY_CD)" ).append("\n"); 
		query.append("    , NVL(A.TRSP_WO_SEQ, TMP.TRSP_WO_SEQ) " ).append("\n"); 
		query.append("    , A.VNDR_SEQ " ).append("\n"); 
		query.append("    , SYSDATE " ).append("\n"); 
		query.append("    , @[cre_ofc_cd] " ).append("\n"); 
		query.append("    , @[cre_usr_id] " ).append("\n"); 
		query.append("    , SYSDATE " ).append("\n"); 
		query.append("    , @[upd_usr_id] " ).append("\n"); 
		query.append("    , SYSDATE " ).append("\n"); 
		query.append("    , GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[cre_ofc_cd]) " ).append("\n"); 
		query.append("    , GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[cre_ofc_cd])" ).append("\n"); 
		query.append("    , 'Rejected By S/P'" ).append("\n"); 
		query.append("FROM TRS_TRSP_WRK_ORD_PRV_TMP TMP, TRS_TRSP_SVC_ORD A" ).append("\n"); 
		query.append("WHERE TMP.WO_PRV_GRP_SEQ = @[wo_prv_grp_seq]" ).append("\n"); 
		query.append("    AND TMP.WO_ISS_NO = @[wo_iss_no]" ).append("\n"); 
		query.append("    AND TMP.TRSP_SO_OFC_CTY_CD = A.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("    AND TMP.TRSP_SO_SEQ = A.TRSP_SO_SEQ" ).append("\n"); 
		query.append("    AND TMP.TRSP_RJCT_RSN_CD = 'R'" ).append("\n"); 

	}
}