/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : WorkOrderPreviewDBDAOAddWorkOrderPreviewIssuedSvcOrdCnclUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.22
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.22 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.workordermanage.workorderpreview.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WorkOrderPreviewDBDAOAddWorkOrderPreviewIssuedSvcOrdCnclUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * trs_trsp_svc_ord cancel 처리
	  * </pre>
	  */
	public WorkOrderPreviewDBDAOAddWorkOrderPreviewIssuedSvcOrdCnclUSQL(){
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
		params.put("wo_iss_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.workordermanage.workorderpreview.integration").append("\n"); 
		query.append("FileName : WorkOrderPreviewDBDAOAddWorkOrderPreviewIssuedSvcOrdCnclUSQL").append("\n"); 
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
		query.append("UPDATE TRS_TRSP_SVC_ORD" ).append("\n"); 
		query.append("SET  " ).append("\n"); 
		query.append("    TRSP_WO_OFC_CTY_CD  = null" ).append("\n"); 
		query.append("  , TRSP_WO_SEQ         = null" ).append("\n"); 
		query.append("  , DTN_USE_FLG         = null" ).append("\n"); 
		query.append("  , WO_BL_NO_ISS_FLG    = null" ).append("\n"); 
		query.append("  , N3PTY_BIL_FLG       = null" ).append("\n"); 
		query.append("  , CURR_CD             = null" ).append("\n"); 
		query.append("  , BZC_AMT             = null" ).append("\n"); 
		query.append("  , NEGO_AMT            = null" ).append("\n"); 
		query.append("  , ETC_ADD_AMT         = null" ).append("\n"); 
		query.append("  , TOLL_FEE_AMT        = null" ).append("\n"); 
		query.append("  , FUEL_SCG_AMT        = null" ).append("\n"); 
		query.append("  , APNT_DT             = null" ).append("\n"); 
		query.append("  , DE_DT               = null" ).append("\n"); 
		query.append("  , CUST_NOMI_TRKR_FLG  = null" ).append("\n"); 
		query.append("  , TRSP_AGMT_RT_TP_CD  = null" ).append("\n"); 
		query.append("  , TRSP_AGMT_WY_TP_CD  = null" ).append("\n"); 
		query.append("  , TRSP_FRST_FLG       = null" ).append("\n"); 
		query.append("  , TRSP_RJCT_RSN_CD    = null" ).append("\n"); 
		query.append("  , TRSP_DFLT_VNDR_FLG  = null" ).append("\n"); 
		query.append("  , TRSP_SO_STS_CD      = 'C'" ).append("\n"); 
		query.append("  , N3PTY_BIL_BZC_AMT   = null" ).append("\n"); 
		query.append("  , N3PTY_VNDR_SEQ      = null" ).append("\n"); 
		query.append("  , N3PTY_OFC_CD        = null" ).append("\n"); 
		query.append("  , N3PTY_DESC          = null" ).append("\n"); 
		query.append("  , N3PTY_CUST_SEQ      = null" ).append("\n"); 
		query.append("  , N3PTY_CUST_CNT_CD   = null" ).append("\n"); 
		query.append("  , N3PTY_BIL_TP_CD     = null" ).append("\n"); 
		query.append("  , N3PTY_CURR_CD       = null" ).append("\n"); 
		query.append("  , EDI_CTRL_SEQ        = null" ).append("\n"); 
		query.append("  , EDI_SND_MSG_TP_CD   = null" ).append("\n"); 
		query.append("  , EDI_SND_DT          = null" ).append("\n"); 
		query.append("  , SCG_VAT_AMT			= null" ).append("\n"); 
		query.append("  , WTR_RCV_TERM_CD     = null" ).append("\n"); 
		query.append("  , WTR_DE_TERM_CD      = null" ).append("\n"); 
		query.append("  , TRSP_AGMT_OFC_CTY_CD = null" ).append("\n"); 
		query.append("  , TRSP_AGMT_SEQ		 = null" ).append("\n"); 
		query.append("  , TRSP_AGMT_CFM_FLG   = null" ).append("\n"); 
		query.append("  , TRSP_AGMT_RT_SEQ    = null" ).append("\n"); 
		query.append("  , TRSP_AGMT_UPD_DT    = null" ).append("\n"); 
		query.append("  , AGMT_MOR_CNDDT_APLY_FLG = null" ).append("\n"); 
		query.append("  , NEGO_RMK            = null" ).append("\n"); 
		query.append("  , CUST_NOMI_TRKR_IND_CD = null" ).append("\n"); 
		query.append("  , TRSP_SP_CNG_RSN_CD = null" ).append("\n"); 
		query.append("  , TRSP_SP_CNG_RSN_RMK = null" ).append("\n"); 
		query.append("  , VGM_FLG = null" ).append("\n"); 
		query.append("WHERE (TRSP_SO_OFC_CTY_CD, TRSP_SO_SEQ) IN (" ).append("\n"); 
		query.append("        SELECT TRSP_SO_OFC_CTY_CD, TRSP_SO_SEQ" ).append("\n"); 
		query.append("        FROM TRS_TRSP_WRK_ORD_PRV_TMP" ).append("\n"); 
		query.append("        WHERE WO_PRV_GRP_SEQ = @[wo_prv_grp_seq]" ).append("\n"); 
		query.append("        AND WO_ISS_NO = @[wo_iss_no] " ).append("\n"); 
		query.append("		AND WO_CXL_FLG = 'Y')" ).append("\n"); 
		query.append("    -- /* 2008.04.29 ETS OPEN */" ).append("\n"); 
		query.append("    AND HJL_NO IS NULL" ).append("\n"); 

	}
}