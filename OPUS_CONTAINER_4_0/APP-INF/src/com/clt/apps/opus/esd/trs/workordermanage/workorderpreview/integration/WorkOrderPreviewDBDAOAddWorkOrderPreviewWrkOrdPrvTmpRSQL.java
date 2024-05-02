/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : WorkOrderPreviewDBDAOAddWorkOrderPreviewWrkOrdPrvTmpRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.23
*@LastModifier : 김성욱
*@LastVersion : 1.0
* 2016.06.23 김성욱
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.workordermanage.workorderpreview.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sung-Wook Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WorkOrderPreviewDBDAOAddWorkOrderPreviewWrkOrdPrvTmpRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * trs_trsp_wrk_ord_prv_tmp select
	  * </pre>
	  */
	public WorkOrderPreviewDBDAOAddWorkOrderPreviewWrkOrdPrvTmpRSQL(){
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
		query.append("Path : com.clt.apps.opus.esd.trs.workordermanage.workorderpreview.integration").append("\n"); 
		query.append("FileName : WorkOrderPreviewDBDAOAddWorkOrderPreviewWrkOrdPrvTmpRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("    A.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("    , A.TRSP_SO_SEQ" ).append("\n"); 
		query.append("    , A.WO_CXL_FLG" ).append("\n"); 
		query.append("    , A.WO_PRV_GRP_SEQ" ).append("\n"); 
		query.append("    , A.WO_BL_NO_ISS_FLG" ).append("\n"); 
		query.append("    , A.DTN_USE_FLG" ).append("\n"); 
		query.append("    , A.CURR_CD" ).append("\n"); 
		query.append("    , A.BZC_AMT" ).append("\n"); 
		query.append("    , A.NEGO_AMT" ).append("\n"); 
		query.append("    , A.ETC_ADD_AMT" ).append("\n"); 
		query.append("    , A.FUEL_SCG_AMT" ).append("\n"); 
		query.append("    , A.OVR_WGT_SCG_AMT" ).append("\n"); 
		query.append("    , A.N3PTY_BIL_FLG" ).append("\n"); 
		query.append("    , A.USD_TTL_AMT" ).append("\n"); 
		query.append("    , A.CUST_CNT_CD" ).append("\n"); 
		query.append("    , A.CUST_SEQ" ).append("\n"); 
		query.append("    , A.CUST_NOMI_TRKR_FLG" ).append("\n"); 
		query.append("    , A.TRSP_AGMT_RT_TP_CD" ).append("\n"); 
		query.append("    , A.TRSP_AGMT_WY_TP_CD" ).append("\n"); 
		query.append("    , A.TRSP_FRST_FLG" ).append("\n"); 
		query.append("    , A.TRSP_RJCT_RSN_CD" ).append("\n"); 
		query.append("    , A.TRSP_DFLT_VNDR_FLG" ).append("\n"); 
		query.append("    , TO_CHAR(A.N1ST_NOD_PLN_DT, 'YYYYMMDDHH24MISS') N1ST_NOD_PLN_DT" ).append("\n"); 
		query.append("    , TO_CHAR(A.LST_NOD_PLN_DT, 'YYYYMMDDHH24MISS') LST_NOD_PLN_DT" ).append("\n"); 
		query.append("    , TO_CHAR(A.DOR_NOD_PLN_DT, 'YYYYMMDDHH24MISS') DOR_NOD_PLN_DT" ).append("\n"); 
		query.append("    , A.INTER_RMK" ).append("\n"); 
		query.append("    , A.SPCL_INSTR_RMK" ).append("\n"); 
		query.append("    , A.FCTRY_NM" ).append("\n"); 
		query.append("    , A.DOR_PST_CD" ).append("\n"); 
		query.append("    , A.CNTC_PSON_PHN_NO" ).append("\n"); 
		query.append("    , A.CNTC_PSON_FAX_NO" ).append("\n"); 
		query.append("    , A.CNTC_PSON_NM" ).append("\n"); 
		query.append("    , A.N3PTY_BIL_BZC_AMT" ).append("\n"); 
		query.append("    , A.N3PTY_VNDR_SEQ" ).append("\n"); 
		query.append("    , A.N3PTY_OFC_CD" ).append("\n"); 
		query.append("    , A.N3PTY_DESC" ).append("\n"); 
		query.append("    , A.N3PTY_CUST_SEQ" ).append("\n"); 
		query.append("    , A.N3PTY_CUST_CNT_CD" ).append("\n"); 
		query.append("    , A.N3PTY_BIL_TP_CD" ).append("\n"); 
		query.append("    , A.N3PTY_CURR_CD" ).append("\n"); 
		query.append("	, B.BKG_NO 				-- COA I/F 위해 필요" ).append("\n"); 
		query.append("	, B.COP_NO" ).append("\n"); 
		query.append("	, B.EQ_NO" ).append("\n"); 
		query.append("	, NVL(B.COST_ACT_GRP_SEQ, 0) COST_ACT_GRP_SEQ" ).append("\n"); 
		query.append("	, B.COST_ACT_GRP_CD" ).append("\n"); 
		query.append("	, B.TRSP_CRR_MOD_CD" ).append("\n"); 
		query.append("	, B.TRSP_BND_CD" ).append("\n"); 
		query.append("	, B.CRE_OFC_CD" ).append("\n"); 
		query.append("	, B.FM_NOD_CD" ).append("\n"); 
		query.append("	, B.VIA_NOD_CD" ).append("\n"); 
		query.append("	, B.DOR_NOD_CD" ).append("\n"); 
		query.append("	, B.TO_NOD_CD" ).append("\n"); 
		query.append("	, B.UPLN_SO_FLG" ).append("\n"); 
		query.append("	, B.TRSP_SO_TP_CD 		-- COA I/F 위해 필요 (2010-07-23 추가)" ).append("\n"); 
		query.append("	, A.WGT_MEAS_UT_CD" ).append("\n"); 
		query.append("	, A.CNTR_KGS_WGT" ).append("\n"); 
		query.append("	, A.CNTR_LBS_WGT" ).append("\n"); 
		query.append("    , A.CGO_TP_CD" ).append("\n"); 
		query.append("	, A.CNTR_PKUP_NO" ).append("\n"); 
		query.append("    , A.SCG_IND_CD" ).append("\n"); 
		query.append("FROM TRS_TRSP_WRK_ORD_PRV_TMP A, TRS_TRSP_SVC_ORD B" ).append("\n"); 
		query.append("WHERE A.TRSP_SO_OFC_CTY_CD = B.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("	AND A.TRSP_SO_SEQ = B.TRSP_SO_SEQ" ).append("\n"); 
		query.append("	AND A.WO_PRV_GRP_SEQ = @[wo_prv_grp_seq]" ).append("\n"); 
		query.append("  	AND A.WO_ISS_NO = @[wo_iss_no]" ).append("\n"); 

	}
}