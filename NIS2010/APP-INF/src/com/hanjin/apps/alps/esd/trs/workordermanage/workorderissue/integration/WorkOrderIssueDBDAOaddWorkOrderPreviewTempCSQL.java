/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : WorkOrderIssueDBDAOaddWorkOrderPreviewTempCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.21
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.21 
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

public class WorkOrderIssueDBDAOaddWorkOrderPreviewTempCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * addWorkOrderPreviewTemp
	  * </pre>
	  */
	public WorkOrderIssueDBDAOaddWorkOrderPreviewTempCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("curr_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("form_usr_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("nego_amt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.workordermanage.workorderissue.integration").append("\n"); 
		query.append("FileName : WorkOrderIssueDBDAOaddWorkOrderPreviewTempCSQL").append("\n"); 
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
		query.append("	, TRSP_SO_STS_CD" ).append("\n"); 
		query.append("	, WO_ISS_STS_CD" ).append("\n"); 
		query.append("	, WO_ISS_NO" ).append("\n"); 
		query.append("	, WO_CXL_FLG" ).append("\n"); 
		query.append("	, WO_FMT_TP_CD" ).append("\n"); 
		query.append("	, TRSP_SO_CMB_TP_CD" ).append("\n"); 
		query.append("	, TRSP_COST_DTL_MOD_CD" ).append("\n"); 
		query.append("	, CGO_TP_CD" ).append("\n"); 
		query.append("	, VNDR_SEQ" ).append("\n"); 
		query.append("	, TRSP_CRR_MOD_CD" ).append("\n"); 
		query.append("	, FM_NOD_CD" ).append("\n"); 
		query.append("	, VIA_NOD_CD" ).append("\n"); 
		query.append("	, TO_NOD_CD" ).append("\n"); 
		query.append("	, DOR_NOD_CD" ).append("\n"); 
		query.append("	, FDR_VSL_CD" ).append("\n"); 
		query.append("	, FDR_SKD_VOY_NO" ).append("\n"); 
		query.append("	, FDR_SKD_DIR_CD" ).append("\n"); 
		query.append("	, WO_BL_NO_ISS_FLG" ).append("\n"); 
		query.append("	, DTN_USE_FLG" ).append("\n"); 
		query.append("	, TRSP_WO_OFC_CTY_CD" ).append("\n"); 
		query.append("	, TRSP_WO_SEQ" ).append("\n"); 
		query.append("	, WO_ISS_KNT" ).append("\n"); 
		query.append("	, CURR_CD" ).append("\n"); 
		query.append("	, BZC_AMT" ).append("\n"); 
		query.append("	, ETC_ADD_AMT" ).append("\n"); 
		query.append("	, NEGO_AMT" ).append("\n"); 
		query.append("	, FUEL_SCG_AMT" ).append("\n"); 
		query.append("	, OVR_WGT_SCG_AMT" ).append("\n"); 
		query.append("	, USD_TTL_AMT" ).append("\n"); 
		query.append("	, N3PTY_BIL_FLG" ).append("\n"); 
		query.append("	, CUST_NOMI_TRKR_FLG" ).append("\n"); 
		query.append("	, N3PTY_CUST_CNT_CD" ).append("\n"); 
		query.append("	, CUST_CNT_CD" ).append("\n"); 
		query.append("	, CUST_SEQ" ).append("\n"); 
		query.append("	, N3PTY_CUST_SEQ" ).append("\n"); 
		query.append("	, TRSP_AGMT_RT_TP_CD" ).append("\n"); 
		query.append("	, TRSP_AGMT_WY_TP_CD" ).append("\n"); 
		query.append("	, TRSP_RJCT_RSN_CD" ).append("\n"); 
		query.append("	, TRSP_DFLT_VNDR_FLG" ).append("\n"); 
		query.append("	, TRSP_FRST_FLG" ).append("\n"); 
		query.append("	, TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("	, TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("	, N1ST_NOD_PLN_DT" ).append("\n"); 
		query.append("	, DOR_NOD_PLN_DT" ).append("\n"); 
		query.append("	, LST_NOD_PLN_DT" ).append("\n"); 
		query.append("	, INTER_RMK" ).append("\n"); 
		query.append("	, SPCL_INSTR_RMK" ).append("\n"); 
		query.append("	, CRE_OFC_CD" ).append("\n"); 
		query.append("	, FCTRY_NM" ).append("\n"); 
		query.append("	, DOR_PST_CD" ).append("\n"); 
		query.append("	, CNTC_PSON_PHN_NO" ).append("\n"); 
		query.append("	, CNTC_PSON_FAX_NO" ).append("\n"); 
		query.append("	, CNTC_PSON_NM" ).append("\n"); 
		query.append("	, HJL_VNDR_SEQ" ).append("\n"); 
		query.append("	, HJL_CURR_CD" ).append("\n"); 
		query.append("	, HJL_BZC_AMT" ).append("\n"); 
		query.append("	, HJL_NEGO_AMT" ).append("\n"); 
		query.append("	, HJL_FUEL_SCG_AMT" ).append("\n"); 
		query.append("	, HJL_ETC_ADD_AMT" ).append("\n"); 
		query.append("	, HJL_N3PTY_BIL_FLG" ).append("\n"); 
		query.append("	, N3PTY_VNDR_SEQ" ).append("\n"); 
		query.append("	, N3PTY_OFC_CD" ).append("\n"); 
		query.append("	, HJL_USD_TTL_AMT" ).append("\n"); 
		query.append("	, N3PTY_BIL_BZC_AMT" ).append("\n"); 
		query.append("	, HJL_N3PTY_VNDR_SEQ" ).append("\n"); 
		query.append("	, HJL_N3PTY_OFC_CD" ).append("\n"); 
		query.append("	, N3PTY_DESC" ).append("\n"); 
		query.append("	, HJL_N3PTY_BIL_BZC_AMT" ).append("\n"); 
		query.append("	, HJL_N3PTY_CUST_CNT_CD" ).append("\n"); 
		query.append("	, HJL_N3PTY_CUST_SEQ" ).append("\n"); 
		query.append("	, HJL_N3PTY_DESC" ).append("\n"); 
		query.append("	, N3PTY_BIL_TP_CD" ).append("\n"); 
		query.append("	, HJL_N3PTY_BIL_TP_CD" ).append("\n"); 
		query.append("	, N3PTY_CURR_CD" ).append("\n"); 
		query.append("	, LOCL_CRE_DT" ).append("\n"); 
		query.append("	, LOCL_UPD_DT" ).append("\n"); 
		query.append("	, CRE_USR_ID" ).append("\n"); 
		query.append("	, CRE_DT" ).append("\n"); 
		query.append("	, UPD_USR_ID" ).append("\n"); 
		query.append("	, UPD_DT" ).append("\n"); 
		query.append("	, SCG_VAT_AMT" ).append("\n"); 
		query.append("	, WTR_RCV_TERM_CD" ).append("\n"); 
		query.append("	, WTR_DE_TERM_CD" ).append("\n"); 
		query.append("	, HJL_COST_RCVR_AMT" ).append("\n"); 
		query.append("	, HJL_COMM_AMT" ).append("\n"); 
		query.append("	, HJL_HNDL_AMT" ).append("\n"); 
		query.append("	, SCG_DTL_TMP_SEQ" ).append("\n"); 
		query.append(") " ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("	TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("	, TRSP_SO_SEQ" ).append("\n"); 
		query.append("	, @[wo_prv_grp_seq]" ).append("\n"); 
		query.append("	, TRSP_SO_STS_CD" ).append("\n"); 
		query.append("	, WO_ISS_STS_CD" ).append("\n"); 
		query.append("	, WO_ISS_NO" ).append("\n"); 
		query.append("	, WO_CXL_FLG" ).append("\n"); 
		query.append("	, WO_FMT_TP_CD" ).append("\n"); 
		query.append("	, TRSP_SO_CMB_TP_CD" ).append("\n"); 
		query.append("	, TRSP_COST_DTL_MOD_CD" ).append("\n"); 
		query.append("	, CGO_TP_CD" ).append("\n"); 
		query.append("	, VNDR_SEQ" ).append("\n"); 
		query.append("	, TRSP_CRR_MOD_CD" ).append("\n"); 
		query.append("	, FM_NOD_CD" ).append("\n"); 
		query.append("	, VIA_NOD_CD" ).append("\n"); 
		query.append("	, TO_NOD_CD" ).append("\n"); 
		query.append("	, DOR_NOD_CD" ).append("\n"); 
		query.append("	, FDR_VSL_CD" ).append("\n"); 
		query.append("	, FDR_SKD_VOY_NO" ).append("\n"); 
		query.append("	, FDR_SKD_DIR_CD" ).append("\n"); 
		query.append("	, WO_BL_NO_ISS_FLG" ).append("\n"); 
		query.append("	, DTN_USE_FLG" ).append("\n"); 
		query.append("	, TRSP_WO_OFC_CTY_CD" ).append("\n"); 
		query.append("	, TRSP_WO_SEQ" ).append("\n"); 
		query.append("	, WO_ISS_KNT" ).append("\n"); 
		query.append("	, @[curr_cd]" ).append("\n"); 
		query.append("	, BZC_AMT" ).append("\n"); 
		query.append("	, ETC_ADD_AMT" ).append("\n"); 
		query.append("	, @[nego_amt]" ).append("\n"); 
		query.append("	, FUEL_SCG_AMT" ).append("\n"); 
		query.append("	, OVR_WGT_SCG_AMT" ).append("\n"); 
		query.append("	, USD_TTL_AMT" ).append("\n"); 
		query.append("	, N3PTY_BIL_FLG" ).append("\n"); 
		query.append("	, CUST_NOMI_TRKR_FLG" ).append("\n"); 
		query.append("	, N3PTY_CUST_CNT_CD" ).append("\n"); 
		query.append("	, CUST_CNT_CD" ).append("\n"); 
		query.append("	, CUST_SEQ" ).append("\n"); 
		query.append("	, N3PTY_CUST_SEQ" ).append("\n"); 
		query.append("	, TRSP_AGMT_RT_TP_CD" ).append("\n"); 
		query.append("	, TRSP_AGMT_WY_TP_CD" ).append("\n"); 
		query.append("	, TRSP_RJCT_RSN_CD" ).append("\n"); 
		query.append("	, TRSP_DFLT_VNDR_FLG" ).append("\n"); 
		query.append("	, TRSP_FRST_FLG" ).append("\n"); 
		query.append("	, TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("	, TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("	, N1ST_NOD_PLN_DT" ).append("\n"); 
		query.append("	, DOR_NOD_PLN_DT" ).append("\n"); 
		query.append("	, LST_NOD_PLN_DT" ).append("\n"); 
		query.append("	, INTER_RMK" ).append("\n"); 
		query.append("	, SPCL_INSTR_RMK" ).append("\n"); 
		query.append("	, @[form_usr_ofc_cd]" ).append("\n"); 
		query.append("	, FCTRY_NM" ).append("\n"); 
		query.append("	, DOR_PST_CD" ).append("\n"); 
		query.append("	, CNTC_PSON_PHN_NO" ).append("\n"); 
		query.append("	, CNTC_PSON_FAX_NO" ).append("\n"); 
		query.append("	, CNTC_PSON_NM" ).append("\n"); 
		query.append("	, HJL_VNDR_SEQ" ).append("\n"); 
		query.append("	, HJL_CURR_CD" ).append("\n"); 
		query.append("	, HJL_BZC_AMT" ).append("\n"); 
		query.append("	, HJL_NEGO_AMT" ).append("\n"); 
		query.append("	, HJL_FUEL_SCG_AMT" ).append("\n"); 
		query.append("	, HJL_ETC_ADD_AMT" ).append("\n"); 
		query.append("	, HJL_N3PTY_BIL_FLG" ).append("\n"); 
		query.append("	, N3PTY_VNDR_SEQ" ).append("\n"); 
		query.append("	, N3PTY_OFC_CD" ).append("\n"); 
		query.append("	, HJL_USD_TTL_AMT" ).append("\n"); 
		query.append("	, N3PTY_BIL_BZC_AMT" ).append("\n"); 
		query.append("	, HJL_N3PTY_VNDR_SEQ" ).append("\n"); 
		query.append("	, HJL_N3PTY_OFC_CD" ).append("\n"); 
		query.append("	, N3PTY_DESC" ).append("\n"); 
		query.append("	, HJL_N3PTY_BIL_BZC_AMT" ).append("\n"); 
		query.append("	, HJL_N3PTY_CUST_CNT_CD" ).append("\n"); 
		query.append("	, HJL_N3PTY_CUST_SEQ" ).append("\n"); 
		query.append("	, HJL_N3PTY_DESC" ).append("\n"); 
		query.append("	, N3PTY_BIL_TP_CD" ).append("\n"); 
		query.append("	, HJL_N3PTY_BIL_TP_CD" ).append("\n"); 
		query.append("	, N3PTY_CURR_CD" ).append("\n"); 
		query.append("	, GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[form_usr_ofc_cd])" ).append("\n"); 
		query.append("	, GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[form_usr_ofc_cd])" ).append("\n"); 
		query.append("	, @[form_cre_usr_id]" ).append("\n"); 
		query.append("	, SYSDATE" ).append("\n"); 
		query.append("	, @[form_cre_usr_id]" ).append("\n"); 
		query.append("	, SYSDATE" ).append("\n"); 
		query.append("	, SCG_VAT_AMT" ).append("\n"); 
		query.append("	, WTR_RCV_TERM_CD" ).append("\n"); 
		query.append("	, WTR_DE_TERM_CD" ).append("\n"); 
		query.append("	, HJL_COST_RCVR_AMT" ).append("\n"); 
		query.append("	, HJL_COMM_AMT" ).append("\n"); 
		query.append("	, HJL_HNDL_AMT" ).append("\n"); 
		query.append("	, @[scg_grp_seq]" ).append("\n"); 
		query.append("FROM TRS_TRSP_WRK_ORD_PRV_TMP TMP" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("    AND TMP.TRSP_SO_OFC_CTY_CD = @[trsp_so_ofc_cty_cd]" ).append("\n"); 
		query.append("    AND TMP.TRSP_SO_SEQ = @[trsp_so_seq]" ).append("\n"); 
		query.append("    AND TMP.WO_PRV_GRP_SEQ = (  SELECT MAX(T2.WO_PRV_GRP_SEQ) " ).append("\n"); 
		query.append("                                FROM TRS_TRSP_WRK_ORD_PRV_TMP T2 " ).append("\n"); 
		query.append("                                WHERE TMP.TRSP_SO_OFC_CTY_CD=T2.TRSP_SO_OFC_CTY_CD " ).append("\n"); 
		query.append("                                AND TMP.TRSP_SO_SEQ=T2.TRSP_SO_SEQ " ).append("\n"); 
		query.append("                                GROUP BY TRSP_SO_OFC_CTY_CD,TRSP_SO_SEQ )" ).append("\n"); 

	}
}