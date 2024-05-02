/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : WorkOrderPreviewDBDAOAddTrsTrspWrkOrdPrvTmpForInquiryCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.31
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.31 
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

public class WorkOrderPreviewDBDAOAddTrsTrspWrkOrdPrvTmpForInquiryCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * WorkOrderPreviewDBDAOAddTrsTrspWrkOrdPrvTmpForInquiry
	  * </pre>
	  */
	public WorkOrderPreviewDBDAOAddTrsTrspWrkOrdPrvTmpForInquiryCSQL(){
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
		params.put("trsp_wo_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_wo_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.workordermanage.workorderpreview.integration").append("\n"); 
		query.append("FileName : WorkOrderPreviewDBDAOAddTrsTrspWrkOrdPrvTmpForInquiryCSQL").append("\n"); 
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
		query.append("INSERT INTO TRS_TRSP_WRK_ORD_PRV_TMP(" ).append("\n"); 
		query.append("   TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("  ,TRSP_SO_SEQ" ).append("\n"); 
		query.append("  ,WO_PRV_GRP_SEQ" ).append("\n"); 
		query.append("  ,TRSP_SO_STS_CD" ).append("\n"); 
		query.append("  ,WO_ISS_STS_CD" ).append("\n"); 
		query.append("  ,WO_ISS_NO" ).append("\n"); 
		query.append("  ,WO_CXL_FLG" ).append("\n"); 
		query.append("  ,WO_FMT_TP_CD" ).append("\n"); 
		query.append("  ,TRSP_SO_CMB_TP_CD" ).append("\n"); 
		query.append("  ,TRSP_COST_DTL_MOD_CD" ).append("\n"); 
		query.append("  ,CGO_TP_CD" ).append("\n"); 
		query.append("  ,VNDR_SEQ" ).append("\n"); 
		query.append("  ,TRSP_CRR_MOD_CD" ).append("\n"); 
		query.append("  ,FM_NOD_CD" ).append("\n"); 
		query.append("  ,VIA_NOD_CD" ).append("\n"); 
		query.append("  ,TO_NOD_CD" ).append("\n"); 
		query.append("  ,DOR_NOD_CD" ).append("\n"); 
		query.append("  ,FDR_VSL_CD" ).append("\n"); 
		query.append("  ,FDR_SKD_VOY_NO" ).append("\n"); 
		query.append("  ,FDR_SKD_DIR_CD" ).append("\n"); 
		query.append("  ,WO_BL_NO_ISS_FLG" ).append("\n"); 
		query.append("  ,DTN_USE_FLG" ).append("\n"); 
		query.append("  ,TRSP_WO_OFC_CTY_CD" ).append("\n"); 
		query.append("  ,TRSP_WO_SEQ" ).append("\n"); 
		query.append("  ,WO_ISS_KNT" ).append("\n"); 
		query.append("  ,CURR_CD" ).append("\n"); 
		query.append("  ,BZC_AMT" ).append("\n"); 
		query.append("  ,ETC_ADD_AMT" ).append("\n"); 
		query.append("  ,NEGO_AMT" ).append("\n"); 
		query.append("  ,FUEL_SCG_AMT" ).append("\n"); 
		query.append("  ,OVR_WGT_SCG_AMT" ).append("\n"); 
		query.append("  ,USD_TTL_AMT" ).append("\n"); 
		query.append("  ,N3PTY_BIL_FLG" ).append("\n"); 
		query.append("  ,CUST_NOMI_TRKR_FLG" ).append("\n"); 
		query.append("  ,N3PTY_CUST_CNT_CD" ).append("\n"); 
		query.append("  ,CUST_CNT_CD" ).append("\n"); 
		query.append("  ,CUST_SEQ" ).append("\n"); 
		query.append("  ,N3PTY_CUST_SEQ" ).append("\n"); 
		query.append("  ,TRSP_AGMT_RT_TP_CD" ).append("\n"); 
		query.append("  ,TRSP_AGMT_WY_TP_CD" ).append("\n"); 
		query.append("  ,TRSP_RJCT_RSN_CD" ).append("\n"); 
		query.append("  ,TRSP_DFLT_VNDR_FLG" ).append("\n"); 
		query.append("  ,TRSP_FRST_FLG" ).append("\n"); 
		query.append("  ,TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("  ,TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("  ,N1ST_NOD_PLN_DT" ).append("\n"); 
		query.append("  ,DOR_NOD_PLN_DT" ).append("\n"); 
		query.append("  ,LST_NOD_PLN_DT" ).append("\n"); 
		query.append("  ,INTER_RMK" ).append("\n"); 
		query.append("  ,SPCL_INSTR_RMK" ).append("\n"); 
		query.append("  ,CRE_OFC_CD" ).append("\n"); 
		query.append("  ,FCTRY_NM" ).append("\n"); 
		query.append("  ,DOR_PST_CD" ).append("\n"); 
		query.append("  ,CNTC_PSON_PHN_NO" ).append("\n"); 
		query.append("  ,CNTC_PSON_FAX_NO" ).append("\n"); 
		query.append("  ,CNTC_PSON_NM" ).append("\n"); 
		query.append("  ,N3PTY_VNDR_SEQ" ).append("\n"); 
		query.append("  ,N3PTY_OFC_CD" ).append("\n"); 
		query.append("  ,N3PTY_BIL_BZC_AMT" ).append("\n"); 
		query.append("  ,N3PTY_DESC" ).append("\n"); 
		query.append("  ,N3PTY_BIL_TP_CD" ).append("\n"); 
		query.append("  ,N3PTY_CURR_CD" ).append("\n"); 
		query.append("  ,LOCL_CRE_DT" ).append("\n"); 
		query.append("  ,LOCL_UPD_DT" ).append("\n"); 
		query.append("  ,CRE_USR_ID" ).append("\n"); 
		query.append("  ,CRE_DT" ).append("\n"); 
		query.append("  ,UPD_USR_ID" ).append("\n"); 
		query.append("  ,UPD_DT" ).append("\n"); 
		query.append("  ,WGT_MEAS_UT_CD" ).append("\n"); 
		query.append("  ,CNTR_KGS_WGT" ).append("\n"); 
		query.append("  ,CNTR_LBS_WGT" ).append("\n"); 
		query.append("  ,TRSP_AGMT_RT_TP_SER_NO" ).append("\n"); 
		query.append("  ,TRSP_AGMT_SCG_NOD_SEQ" ).append("\n"); 
		query.append("  ,TRSP_AGMT_SCG_RT_SEQ" ).append("\n"); 
		query.append(") " ).append("\n"); 
		query.append("  SELECT S.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("        ,S.TRSP_SO_SEQ" ).append("\n"); 
		query.append("        ,@[wo_prv_grp_seq] WO_PRV_GRP_SEQ" ).append("\n"); 
		query.append("        ,S.TRSP_SO_STS_CD" ).append("\n"); 
		query.append("        ,W.WO_ISS_STS_CD" ).append("\n"); 
		query.append("        ,1 WO_ISS_NO" ).append("\n"); 
		query.append("        ,'N' WO_CXL_FLG" ).append("\n"); 
		query.append("        ,W.WO_FMT_TP_CD" ).append("\n"); 
		query.append("        ,S.TRSP_SO_CMB_TP_CD" ).append("\n"); 
		query.append("        ,S.TRSP_COST_DTL_MOD_CD" ).append("\n"); 
		query.append("        ,S.CGO_TP_CD" ).append("\n"); 
		query.append("        ,S.VNDR_SEQ" ).append("\n"); 
		query.append("        ,S.TRSP_CRR_MOD_CD" ).append("\n"); 
		query.append("        ,S.FM_NOD_CD" ).append("\n"); 
		query.append("        ,S.VIA_NOD_CD" ).append("\n"); 
		query.append("        ,S.TO_NOD_CD" ).append("\n"); 
		query.append("        ,S.DOR_NOD_CD" ).append("\n"); 
		query.append("        ,S.FDR_VSL_CD" ).append("\n"); 
		query.append("        ,S.FDR_SKD_VOY_NO" ).append("\n"); 
		query.append("        ,S.FDR_SKD_DIR_CD" ).append("\n"); 
		query.append("        ,S.WO_BL_NO_ISS_FLG" ).append("\n"); 
		query.append("        ,S.DTN_USE_FLG" ).append("\n"); 
		query.append("        ,S.TRSP_WO_OFC_CTY_CD" ).append("\n"); 
		query.append("        ,S.TRSP_WO_SEQ" ).append("\n"); 
		query.append("        ,1 WO_ISS_KNT" ).append("\n"); 
		query.append("        ,S.CURR_CD" ).append("\n"); 
		query.append("        ,S.BZC_AMT" ).append("\n"); 
		query.append("        ,S.ETC_ADD_AMT" ).append("\n"); 
		query.append("        ,S.NEGO_AMT" ).append("\n"); 
		query.append("        ,S.FUEL_SCG_AMT" ).append("\n"); 
		query.append("        ,S.OVR_WGT_SCG_AMT" ).append("\n"); 
		query.append("        ,TRS_COMMON_PKG.GET_CONVERSION_USD_AMT_FNC(S.CURR_CD, NVL(S.BZC_AMT, 0) + NVL(S.ETC_ADD_AMT, 0) + NVL(S.NEGO_AMT, 0) + NVL(S.FUEL_SCG_AMT, 0), TO_CHAR(S.CRE_DT, 'YYYYMMDD')) USD_TTL_AMT" ).append("\n"); 
		query.append("        ,S.N3PTY_BIL_FLG" ).append("\n"); 
		query.append("        ,S.CUST_NOMI_TRKR_FLG" ).append("\n"); 
		query.append("        ,S.N3PTY_CUST_CNT_CD" ).append("\n"); 
		query.append("        ,S.CUST_CNT_CD" ).append("\n"); 
		query.append("        ,S.CUST_SEQ" ).append("\n"); 
		query.append("        ,S.N3PTY_CUST_SEQ" ).append("\n"); 
		query.append("        ,S.TRSP_AGMT_RT_TP_CD" ).append("\n"); 
		query.append("        ,S.TRSP_AGMT_WY_TP_CD" ).append("\n"); 
		query.append("        ,S.TRSP_RJCT_RSN_CD" ).append("\n"); 
		query.append("        ,S.TRSP_DFLT_VNDR_FLG" ).append("\n"); 
		query.append("        ,S.TRSP_FRST_FLG" ).append("\n"); 
		query.append("        ,S.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("        ,S.TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("        ,S.N1ST_NOD_PLN_DT" ).append("\n"); 
		query.append("        ,S.DOR_NOD_PLN_DT" ).append("\n"); 
		query.append("        ,S.LST_NOD_PLN_DT" ).append("\n"); 
		query.append("        ,S.INTER_RMK" ).append("\n"); 
		query.append("        ,S.SPCL_INSTR_RMK" ).append("\n"); 
		query.append("        ,S.CRE_OFC_CD" ).append("\n"); 
		query.append("        ,S.FCTRY_NM" ).append("\n"); 
		query.append("        ,S.DOR_PST_CD" ).append("\n"); 
		query.append("        ,S.CNTC_PSON_PHN_NO" ).append("\n"); 
		query.append("        ,S.CNTC_PSON_FAX_NO" ).append("\n"); 
		query.append("        ,S.CNTC_PSON_NM" ).append("\n"); 
		query.append("        ,S.N3PTY_VNDR_SEQ" ).append("\n"); 
		query.append("        ,S.N3PTY_OFC_CD" ).append("\n"); 
		query.append("        ,S.N3PTY_BIL_BZC_AMT" ).append("\n"); 
		query.append("        ,S.N3PTY_DESC" ).append("\n"); 
		query.append("        ,S.N3PTY_BIL_TP_CD" ).append("\n"); 
		query.append("        ,S.N3PTY_CURR_CD" ).append("\n"); 
		query.append("        ,S.LOCL_CRE_DT" ).append("\n"); 
		query.append("        ,S.LOCL_UPD_DT" ).append("\n"); 
		query.append("        ,S.CRE_USR_ID" ).append("\n"); 
		query.append("        ,S.CRE_DT" ).append("\n"); 
		query.append("        ,S.UPD_USR_ID" ).append("\n"); 
		query.append("        ,S.UPD_DT" ).append("\n"); 
		query.append("        ,S.WGT_MEAS_UT_CD" ).append("\n"); 
		query.append("        ,S.CNTR_KGS_WGT" ).append("\n"); 
		query.append("        ,S.CNTR_LBS_WGT" ).append("\n"); 
		query.append("        ,'' TRSP_AGMT_RT_TP_SER_NO" ).append("\n"); 
		query.append("        ,'' TRSP_AGMT_SCG_NOD_SEQ" ).append("\n"); 
		query.append("        ,'' TRSP_AGMT_SCG_RT_SEQ" ).append("\n"); 
		query.append("    FROM TRS_TRSP_WRK_ORD W" ).append("\n"); 
		query.append("        ,TRS_TRSP_SVC_ORD S" ).append("\n"); 
		query.append("   WHERE W.TRSP_WO_OFC_CTY_CD = S.TRSP_WO_OFC_CTY_CD" ).append("\n"); 
		query.append("     AND W.TRSP_WO_SEQ = S.TRSP_WO_SEQ" ).append("\n"); 
		query.append("     AND W.TRSP_WO_OFC_CTY_CD = @[trsp_wo_ofc_cty_cd]" ).append("\n"); 
		query.append("     AND W.TRSP_WO_SEQ = @[trsp_wo_seq]" ).append("\n"); 

	}
}