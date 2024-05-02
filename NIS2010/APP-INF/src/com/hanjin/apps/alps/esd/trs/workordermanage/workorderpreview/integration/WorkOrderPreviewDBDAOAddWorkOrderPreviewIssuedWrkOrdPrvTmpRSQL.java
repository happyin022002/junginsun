/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : WorkOrderPreviewDBDAOAddWorkOrderPreviewIssuedWrkOrdPrvTmpRSQL.java
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

public class WorkOrderPreviewDBDAOAddWorkOrderPreviewIssuedWrkOrdPrvTmpRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * trs_trsp_wrk_ord_prv_tmp select
	  * </pre>
	  */
	public WorkOrderPreviewDBDAOAddWorkOrderPreviewIssuedWrkOrdPrvTmpRSQL(){
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
		query.append("FileName : WorkOrderPreviewDBDAOAddWorkOrderPreviewIssuedWrkOrdPrvTmpRSQL").append("\n"); 
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
		query.append("SELECT                                                           " ).append("\n"); 
		query.append("    TRSP_SO_OFC_CTY_CD                                           " ).append("\n"); 
		query.append("    , TRSP_SO_SEQ                                                  " ).append("\n"); 
		query.append("    , WO_CXL_FLG                                                   " ).append("\n"); 
		query.append("    , WO_PRV_GRP_SEQ                                               " ).append("\n"); 
		query.append("    , WO_BL_NO_ISS_FLG                                             " ).append("\n"); 
		query.append("    , DTN_USE_FLG                                                  " ).append("\n"); 
		query.append("    , CURR_CD                                                      " ).append("\n"); 
		query.append("    , BZC_AMT                                                      " ).append("\n"); 
		query.append("    , NEGO_AMT                                                     " ).append("\n"); 
		query.append("    , ETC_ADD_AMT                                                  " ).append("\n"); 
		query.append("    , FUEL_SCG_AMT " ).append("\n"); 
		query.append("	, SCG_VAT_AMT  " ).append("\n"); 
		query.append("    , TOLL_FEE_AMT                                                 " ).append("\n"); 
		query.append("    , OVR_WGT_SCG_AMT                                              " ).append("\n"); 
		query.append("    , N3PTY_BIL_FLG                                                " ).append("\n"); 
		query.append("    , USD_TTL_AMT                                                  " ).append("\n"); 
		query.append("    , CUST_CNT_CD                                                  " ).append("\n"); 
		query.append("    , CUST_SEQ                                                     " ).append("\n"); 
		query.append("    , CUST_NOMI_TRKR_FLG                                           " ).append("\n"); 
		query.append("    , TRSP_AGMT_RT_TP_CD                                           " ).append("\n"); 
		query.append("    , TRSP_AGMT_WY_TP_CD                                           " ).append("\n"); 
		query.append("    , TRSP_FRST_FLG                                                " ).append("\n"); 
		query.append("    , TRSP_RJCT_RSN_CD                                             " ).append("\n"); 
		query.append("    , TRSP_DFLT_VNDR_FLG                                           " ).append("\n"); 
		query.append("    , TO_CHAR(N1ST_NOD_PLN_DT,'YYYYMMDDHH24MISS') N1ST_NOD_PLN_DT                      " ).append("\n"); 
		query.append("    , TO_CHAR(LST_NOD_PLN_DT,'YYYYMMDDHH24MISS') LST_NOD_PLN_DT                       " ).append("\n"); 
		query.append("    , TO_CHAR(DOR_NOD_PLN_DT,'YYYYMMDDHH24MISS') DOR_NOD_PLN_DT                       " ).append("\n"); 
		query.append("    , INTER_RMK                                                    " ).append("\n"); 
		query.append("    , SPCL_INSTR_RMK                                               " ).append("\n"); 
		query.append("    , FCTRY_NM                                                     " ).append("\n"); 
		query.append("    , DOR_PST_CD                                                   " ).append("\n"); 
		query.append("    , CNTC_PSON_PHN_NO                                             " ).append("\n"); 
		query.append("    , CNTC_PSON_FAX_NO                                             " ).append("\n"); 
		query.append("    , CNTC_PSON_NM                                                 " ).append("\n"); 
		query.append("    , N3PTY_BIL_BZC_AMT                                            " ).append("\n"); 
		query.append("    , N3PTY_VNDR_SEQ                                               " ).append("\n"); 
		query.append("    , N3PTY_OFC_CD                                                 " ).append("\n"); 
		query.append("    , N3PTY_DESC                                                 	" ).append("\n"); 
		query.append("    , N3PTY_CUST_SEQ                                               " ).append("\n"); 
		query.append("    , N3PTY_CUST_CNT_CD                                            " ).append("\n"); 
		query.append("    , N3PTY_BIL_TP_CD                                              " ).append("\n"); 
		query.append("    , N3PTY_CURR_CD" ).append("\n"); 
		query.append("    , TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("    , TRSP_AGMT_SEQ	 " ).append("\n"); 
		query.append("    , TRSP_AGMT_CFM_FLG" ).append("\n"); 
		query.append("    , TRSP_AGMT_RT_SEQ" ).append("\n"); 
		query.append("    , TO_CHAR(TRSP_AGMT_UPD_DT, 'YYYYMMDDHH24MISS') TRSP_AGMT_UPD_DT" ).append("\n"); 
		query.append("    , AGMT_MOR_CNDDT_APLY_FLG" ).append("\n"); 
		query.append("    , NEGO_RMK" ).append("\n"); 
		query.append("    , CUST_NOMI_TRKR_IND_CD" ).append("\n"); 
		query.append("    , TRSP_SP_CNG_RSN_CD" ).append("\n"); 
		query.append("    , TRSP_SP_CNG_RSN_RMK" ).append("\n"); 
		query.append("	, VGM_FLG" ).append("\n"); 
		query.append("FROM                                                             " ).append("\n"); 
		query.append("    TRS_TRSP_WRK_ORD_PRV_TMP                                     " ).append("\n"); 
		query.append("WHERE                                                            " ).append("\n"); 
		query.append("    WO_PRV_GRP_SEQ = @[wo_prv_grp_seq]                              " ).append("\n"); 
		query.append("    AND WO_ISS_NO  = @[wo_iss_no]                                 " ).append("\n"); 
		query.append("    AND WO_CXL_FLG = 'N'" ).append("\n"); 

	}
}