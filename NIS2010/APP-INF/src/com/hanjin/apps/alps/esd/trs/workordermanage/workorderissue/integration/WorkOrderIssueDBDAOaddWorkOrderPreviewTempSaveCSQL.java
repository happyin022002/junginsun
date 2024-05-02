/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : WorkOrderIssueDBDAOaddWorkOrderPreviewTempSaveCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.09
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.09 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.workordermanage.workorderissue.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WorkOrderIssueDBDAOaddWorkOrderPreviewTempSaveCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * W/O save
	  * </pre>
	  */
	public WorkOrderIssueDBDAOaddWorkOrderPreviewTempSaveCSQL(){
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
		params.put("scg_grp_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("form_cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.workordermanage.workorderissue.integration").append("\n"); 
		query.append("FileName : WorkOrderIssueDBDAOaddWorkOrderPreviewTempSaveCSQL").append("\n"); 
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
		query.append("INSERT INTO TRS_TRSP_WRK_ORD_PRV_TMP" ).append("\n"); 
		query.append("(		" ).append("\n"); 
		query.append("	TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("	, TRSP_SO_SEQ" ).append("\n"); 
		query.append("	, WO_PRV_GRP_SEQ" ).append("\n"); 
		query.append("	, WO_ISS_STS_CD" ).append("\n"); 
		query.append("	, WO_ISS_NO" ).append("\n"); 
		query.append("	, VNDR_SEQ" ).append("\n"); 
		query.append("	, WO_CXL_FLG" ).append("\n"); 
		query.append("	, DTN_USE_FLG" ).append("\n"); 
		query.append("	, WO_BL_NO_ISS_FLG" ).append("\n"); 
		query.append("	, CURR_CD" ).append("\n"); 
		query.append("	, BZC_AMT" ).append("\n"); 
		query.append("	, NEGO_AMT" ).append("\n"); 
		query.append("	, ETC_ADD_AMT" ).append("\n"); 
		query.append("	, FUEL_SCG_AMT" ).append("\n"); 
		query.append("	, SCG_VAT_AMT" ).append("\n"); 
		query.append("    , TOLL_FEE_AMT" ).append("\n"); 
		query.append("	, OVR_WGT_SCG_AMT" ).append("\n"); 
		query.append("	, N3PTY_BIL_FLG" ).append("\n"); 
		query.append("	, USD_TTL_AMT" ).append("\n"); 
		query.append("	, CUST_CNT_CD" ).append("\n"); 
		query.append("	, CUST_SEQ" ).append("\n"); 
		query.append("	, CUST_NOMI_TRKR_FLG" ).append("\n"); 
		query.append("	, TRSP_AGMT_RT_TP_CD" ).append("\n"); 
		query.append("	, TRSP_AGMT_WY_TP_CD" ).append("\n"); 
		query.append("	, TRSP_FRST_FLG" ).append("\n"); 
		query.append("	, TRSP_RJCT_RSN_CD" ).append("\n"); 
		query.append("	, TRSP_DFLT_VNDR_FLG" ).append("\n"); 
		query.append("	, N1ST_NOD_PLN_DT" ).append("\n"); 
		query.append("	, LST_NOD_PLN_DT" ).append("\n"); 
		query.append("	, DOR_NOD_PLN_DT" ).append("\n"); 
		query.append("	, INTER_RMK" ).append("\n"); 
		query.append("	, SPCL_INSTR_RMK" ).append("\n"); 
		query.append("    , NEGO_RMK" ).append("\n"); 
		query.append("	, FCTRY_NM" ).append("\n"); 
		query.append("	, DOR_PST_CD" ).append("\n"); 
		query.append("	, CNTC_PSON_PHN_NO" ).append("\n"); 
		query.append("	, CNTC_PSON_FAX_NO" ).append("\n"); 
		query.append("	, CNTC_PSON_NM" ).append("\n"); 
		query.append("	, N3PTY_CUST_CNT_CD" ).append("\n"); 
		query.append("	, N3PTY_CUST_SEQ" ).append("\n"); 
		query.append("	, N3PTY_DESC" ).append("\n"); 
		query.append("	, N3PTY_VNDR_SEQ" ).append("\n"); 
		query.append("	, N3PTY_OFC_CD" ).append("\n"); 
		query.append("	, N3PTY_BIL_BZC_AMT" ).append("\n"); 
		query.append("	, N3PTY_BIL_TP_CD" ).append("\n"); 
		query.append("	, N3PTY_CURR_CD" ).append("\n"); 
		query.append("    , WTR_RCV_TERM_CD" ).append("\n"); 
		query.append("    , WTR_DE_TERM_CD" ).append("\n"); 
		query.append("    , TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("    , TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("    , TRSP_AGMT_CFM_FLG" ).append("\n"); 
		query.append("    , TRSP_AGMT_RT_SEQ" ).append("\n"); 
		query.append("    , TRSP_AGMT_UPD_DT" ).append("\n"); 
		query.append("    , AGMT_MOR_CNDDT_APLY_FLG" ).append("\n"); 
		query.append("    , SCG_DTL_TMP_SEQ" ).append("\n"); 
		query.append("    , CRE_USR_ID" ).append("\n"); 
		query.append("	, CRE_DT" ).append("\n"); 
		query.append("	, UPD_USR_ID" ).append("\n"); 
		query.append("	, UPD_DT" ).append("\n"); 
		query.append(") " ).append("\n"); 
		query.append("SELECT TRSP_SO_OFC_CTY_CD," ).append("\n"); 
		query.append("       TRSP_SO_SEQ," ).append("\n"); 
		query.append("       @[wo_prv_grp_seq]," ).append("\n"); 
		query.append("       'I' WO_ISS_STS_CD," ).append("\n"); 
		query.append("       1 WO_ISS_NO," ).append("\n"); 
		query.append("       VNDR_SEQ," ).append("\n"); 
		query.append("       'N' WO_CXL_FLG," ).append("\n"); 
		query.append("       DTN_USE_FLG," ).append("\n"); 
		query.append("       WO_BL_NO_ISS_FLG," ).append("\n"); 
		query.append("       CURR_CD," ).append("\n"); 
		query.append("       BZC_AMT," ).append("\n"); 
		query.append("       NEGO_AMT," ).append("\n"); 
		query.append("       ETC_ADD_AMT," ).append("\n"); 
		query.append("       FUEL_SCG_AMT," ).append("\n"); 
		query.append("       SCG_VAT_AMT," ).append("\n"); 
		query.append("       TOLL_FEE_AMT," ).append("\n"); 
		query.append("       OVR_WGT_SCG_AMT," ).append("\n"); 
		query.append("       N3PTY_BIL_FLG," ).append("\n"); 
		query.append("       NULL USD_TTL_AMT," ).append("\n"); 
		query.append("       CUST_CNT_CD," ).append("\n"); 
		query.append("       CUST_SEQ," ).append("\n"); 
		query.append("       CUST_NOMI_TRKR_FLG," ).append("\n"); 
		query.append("       TRSP_AGMT_RT_TP_CD," ).append("\n"); 
		query.append("       TRSP_AGMT_WY_TP_CD," ).append("\n"); 
		query.append("       TRSP_FRST_FLG," ).append("\n"); 
		query.append("       TRSP_RJCT_RSN_CD," ).append("\n"); 
		query.append("       TRSP_DFLT_VNDR_FLG," ).append("\n"); 
		query.append("       N1ST_NOD_PLN_DT," ).append("\n"); 
		query.append("       LST_NOD_PLN_DT," ).append("\n"); 
		query.append("       DOR_NOD_PLN_DT," ).append("\n"); 
		query.append("       INTER_RMK," ).append("\n"); 
		query.append("       SPCL_INSTR_RMK," ).append("\n"); 
		query.append("       NEGO_RMK," ).append("\n"); 
		query.append("       FCTRY_NM," ).append("\n"); 
		query.append("       DOR_PST_CD," ).append("\n"); 
		query.append("       CNTC_PSON_PHN_NO," ).append("\n"); 
		query.append("       CNTC_PSON_FAX_NO," ).append("\n"); 
		query.append("       CNTC_PSON_NM," ).append("\n"); 
		query.append("       N3PTY_CUST_CNT_CD," ).append("\n"); 
		query.append("       N3PTY_CUST_SEQ," ).append("\n"); 
		query.append("       N3PTY_DESC," ).append("\n"); 
		query.append("       N3PTY_VNDR_SEQ," ).append("\n"); 
		query.append("       N3PTY_OFC_CD," ).append("\n"); 
		query.append("       N3PTY_BIL_BZC_AMT," ).append("\n"); 
		query.append("       N3PTY_BIL_TP_CD," ).append("\n"); 
		query.append("       N3PTY_CURR_CD," ).append("\n"); 
		query.append("       WTR_RCV_TERM_CD," ).append("\n"); 
		query.append("       WTR_DE_TERM_CD," ).append("\n"); 
		query.append("       TRSP_AGMT_OFC_CTY_CD," ).append("\n"); 
		query.append("       TRSP_AGMT_SEQ," ).append("\n"); 
		query.append("       TRSP_AGMT_CFM_FLG," ).append("\n"); 
		query.append("       TRSP_AGMT_RT_SEQ," ).append("\n"); 
		query.append("       TRSP_AGMT_UPD_DT," ).append("\n"); 
		query.append("       AGMT_MOR_CNDDT_APLY_FLG," ).append("\n"); 
		query.append("       @[scg_grp_seq]," ).append("\n"); 
		query.append("       @[form_cre_usr_id]," ).append("\n"); 
		query.append("       SYSDATE," ).append("\n"); 
		query.append("       @[form_cre_usr_id]," ).append("\n"); 
		query.append("       SYSDATE" ).append("\n"); 
		query.append("  FROM TRS_TRSP_SVC_ORD" ).append("\n"); 
		query.append(" WHERE TRSP_SO_OFC_CTY_CD = @[trsp_so_ofc_cty_cd]" ).append("\n"); 
		query.append("   AND TRSP_SO_SEQ = @[trsp_so_seq]" ).append("\n"); 
		query.append("   AND HJL_NO IS NULL" ).append("\n"); 

	}
}