/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SurchargeInputInquiryDBDAOsearchSurchargeInputInquiryListByAgreementRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.10.31
*@LastModifier : 김성욱
*@LastVersion : 1.0
* 2016.10.31 김성욱
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.invoicemanage.surchargeinputinquiry.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sung-Wook Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SurchargeInputInquiryDBDAOsearchSurchargeInputInquiryListByAgreementRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchSurchargeInputInquiryListByAgreement
	  * </pre>
	  */
	public SurchargeInputInquiryDBDAOsearchSurchargeInputInquiryListByAgreementRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("via_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cgo_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dor_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("so_cre_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("po_trsp_agmt_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("spcl_cgo_cntr_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("po_trsp_agmt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wgt_meas_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("po_local_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_cost_dtl_mod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_crr_mod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lbs_net_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("kgs_net_wgt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.invoicemanage.surchargeinputinquiry.integration").append("\n"); 
		query.append("FileName : SurchargeInputInquiryDBDAOsearchSurchargeInputInquiryListByAgreementRSQL").append("\n"); 
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
		query.append("SELECT  T.TRSP_SO_OFC_CTY_CD," ).append("\n"); 
		query.append("        T.TRSP_SO_SEQ," ).append("\n"); 
		query.append("        T.UNIQUE_CD," ).append("\n"); 
		query.append("        T.LGS_COST_CD," ).append("\n"); 
		query.append("        T.LGS_COST_FULL_NM," ).append("\n"); 
		query.append("        ROUND(T.ORG_SCG_AMT * T.WO_SCG_XCH_RT, 2) AS SCG_AMT," ).append("\n"); 
		query.append("        T.DRY_RUN_RLBL_PTY_TP_CD," ).append("\n"); 
		query.append("        T.FNE_CUZ_DESC," ).append("\n"); 
		query.append("        T.FUMG_COST_TP_CD," ).append("\n"); 
		query.append("        T.MGST_TPSZ_CD," ).append("\n"); 
		query.append("        T.INSP_RF_PTI_CSTMS_TP_CD," ).append("\n"); 
		query.append("        T.LFTG_KNT," ).append("\n"); 
		query.append("        T.LFTG_CUZ_DESC," ).append("\n"); 
		query.append("        T.STOP_LOC_NOD_CD," ).append("\n"); 
		query.append("        T.GRS_WGT," ).append("\n"); 
		query.append("        T.INCRT_DT," ).append("\n"); 
		query.append("        T.SCL_STOP_PLC_NOD_CD," ).append("\n"); 
		query.append("        T.STO_DYS," ).append("\n"); 
		query.append("        T.OB_BKG_NO," ).append("\n"); 
		query.append("        T.WT_HRS," ).append("\n"); 
		query.append("        T.OTR_RMK," ).append("\n"); 
		query.append("        T.INV_SCG_AMT," ).append("\n"); 
		query.append("        T.INV_DRY_RUN_RLBL_PTY_TP_CD," ).append("\n"); 
		query.append("        T.INV_FNE_CUZ_DESC," ).append("\n"); 
		query.append("        T.INV_FUMG_COST_TP_CD," ).append("\n"); 
		query.append("        T.INV_MGST_TPSZ_CD," ).append("\n"); 
		query.append("        T.INV_INSP_RF_PTI_CSTMS_TP_CD," ).append("\n"); 
		query.append("        T.INV_LFTG_KNT," ).append("\n"); 
		query.append("        T.INV_LFTG_CUZ_DESC," ).append("\n"); 
		query.append("        T.INV_STOP_LOC_NOD_CD," ).append("\n"); 
		query.append("        T.INV_GRS_WGT," ).append("\n"); 
		query.append("        T.INV_INCRT_DT," ).append("\n"); 
		query.append("        T.INV_SCL_STOP_PLC_NOD_CD," ).append("\n"); 
		query.append("        T.INV_STO_DYS," ).append("\n"); 
		query.append("        T.INV_OB_BKG_NO," ).append("\n"); 
		query.append("        T.INV_WT_HRS," ).append("\n"); 
		query.append("        T.INV_OTR_RMK," ).append("\n"); 
		query.append("        T.N3PTY_BIL_FLG," ).append("\n"); 
		query.append("        T.CUST_CNT_CD," ).append("\n"); 
		query.append("        T.CUST_SEQ," ).append("\n"); 
		query.append("        T.N3PTY_VNDR_SEQ," ).append("\n"); 
		query.append("        T.N3PTY_OFC_CD," ).append("\n"); 
		query.append("        T.N3PTY_AMT," ).append("\n"); 
		query.append("        T.N3PTY_DESC," ).append("\n"); 
		query.append("        T.N3PTY_CURR_CD," ).append("\n"); 
		query.append("        T.CRE_OFC_CD," ).append("\n"); 
		query.append("        T.CRE_USR_ID," ).append("\n"); 
		query.append("        T.CRE_DT," ).append("\n"); 
		query.append("        T.INCUR_DT," ).append("\n"); 
		query.append("        T.CHSS_NO," ).append("\n"); 
		query.append("        T.INV_INCUR_DT," ).append("\n"); 
		query.append("        T.INV_CHSS_NO," ).append("\n"); 
		query.append("		T.REF_INV_NO," ).append("\n"); 
		query.append("        T.TRSP_AGMT_OFC_CTY_CD," ).append("\n"); 
		query.append("        T.TRSP_AGMT_SEQ," ).append("\n"); 
		query.append("        T.TRSP_AGMT_RT_TP_SER_NO," ).append("\n"); 
		query.append("        T.TRSP_AGMT_SCG_NOD_SEQ," ).append("\n"); 
		query.append("        T.TRSP_AGMT_SCG_RT_SEQ," ).append("\n"); 
		query.append("		T.FUEL_RTO," ).append("\n"); 
		query.append("        T.COM_SCG_KND_CD," ).append("\n"); 
		query.append("        T.COM_SCG_SEQ," ).append("\n"); 
		query.append("        T.SCG_DTL_SEQ," ).append("\n"); 
		query.append("        T.CURR_CD," ).append("\n"); 
		query.append("        T.WO_SCG_XCH_RT," ).append("\n"); 
		query.append("        T.ORG_SCG_AMT" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT DISTINCT @[trsp_so_ofc_cty_cd] AS TRSP_SO_OFC_CTY_CD," ).append("\n"); 
		query.append("                @[trsp_so_seq] AS TRSP_SO_SEQ," ).append("\n"); 
		query.append("                @[trsp_so_seq] AS UNIQUE_CD," ).append("\n"); 
		query.append("                D.TRSP_SCG_CD AS LGS_COST_CD," ).append("\n"); 
		query.append("                COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD30002', D.TRSP_SCG_CD) AS LGS_COST_FULL_NM," ).append("\n"); 
		query.append("                D.ETC_ADD_AMT AS ORG_SCG_AMT," ).append("\n"); 
		query.append("                '' AS DRY_RUN_RLBL_PTY_TP_CD," ).append("\n"); 
		query.append("                '' AS FNE_CUZ_DESC," ).append("\n"); 
		query.append("                '' AS FUMG_COST_TP_CD," ).append("\n"); 
		query.append("                '' AS MGST_TPSZ_CD," ).append("\n"); 
		query.append("                '' AS INSP_RF_PTI_CSTMS_TP_CD," ).append("\n"); 
		query.append("                '' AS LFTG_KNT," ).append("\n"); 
		query.append("                '' AS LFTG_CUZ_DESC," ).append("\n"); 
		query.append("                '' AS STOP_LOC_NOD_CD," ).append("\n"); 
		query.append("                '' AS GRS_WGT," ).append("\n"); 
		query.append("                '' AS INCRT_DT," ).append("\n"); 
		query.append("                '' AS SCL_STOP_PLC_NOD_CD," ).append("\n"); 
		query.append("                '' AS STO_DYS," ).append("\n"); 
		query.append("                '' AS OB_BKG_NO," ).append("\n"); 
		query.append("                '' AS WT_HRS," ).append("\n"); 
		query.append("                '' AS OTR_RMK," ).append("\n"); 
		query.append("                '' AS INV_SCG_AMT," ).append("\n"); 
		query.append("                '' AS INV_DRY_RUN_RLBL_PTY_TP_CD," ).append("\n"); 
		query.append("                '' AS INV_FNE_CUZ_DESC," ).append("\n"); 
		query.append("                '' AS INV_FUMG_COST_TP_CD," ).append("\n"); 
		query.append("                '' AS INV_MGST_TPSZ_CD," ).append("\n"); 
		query.append("                '' AS INV_INSP_RF_PTI_CSTMS_TP_CD," ).append("\n"); 
		query.append("                '' AS INV_LFTG_KNT," ).append("\n"); 
		query.append("                '' AS INV_LFTG_CUZ_DESC," ).append("\n"); 
		query.append("                '' AS INV_STOP_LOC_NOD_CD," ).append("\n"); 
		query.append("                '' AS INV_GRS_WGT," ).append("\n"); 
		query.append("                '' AS INV_INCRT_DT," ).append("\n"); 
		query.append("                '' AS INV_SCL_STOP_PLC_NOD_CD," ).append("\n"); 
		query.append("                '' AS INV_STO_DYS," ).append("\n"); 
		query.append("                '' AS INV_OB_BKG_NO," ).append("\n"); 
		query.append("                '' AS INV_WT_HRS," ).append("\n"); 
		query.append("                '' AS INV_OTR_RMK," ).append("\n"); 
		query.append("                '' AS N3PTY_BIL_FLG," ).append("\n"); 
		query.append("                '' AS CUST_CNT_CD," ).append("\n"); 
		query.append("                '' AS CUST_SEQ," ).append("\n"); 
		query.append("                '' AS N3PTY_VNDR_SEQ," ).append("\n"); 
		query.append("                '' AS N3PTY_OFC_CD," ).append("\n"); 
		query.append("                '' AS N3PTY_AMT," ).append("\n"); 
		query.append("                '' AS N3PTY_DESC," ).append("\n"); 
		query.append("                '' AS N3PTY_CURR_CD," ).append("\n"); 
		query.append("                D.CRE_OFC_CD," ).append("\n"); 
		query.append("                D.CRE_USR_ID," ).append("\n"); 
		query.append("                TO_CHAR(D.CRE_DT, 'YYYYMMDD') CRE_DT," ).append("\n"); 
		query.append("                '' AS INCUR_DT," ).append("\n"); 
		query.append("                '' AS CHSS_NO," ).append("\n"); 
		query.append("                '' AS INV_INCUR_DT," ).append("\n"); 
		query.append("                '' AS INV_CHSS_NO," ).append("\n"); 
		query.append("				'' AS REF_INV_NO," ).append("\n"); 
		query.append("                TRSP_AGMT_OFC_CTY_CD," ).append("\n"); 
		query.append("                TRSP_AGMT_SEQ," ).append("\n"); 
		query.append("                TRSP_AGMT_RT_TP_SER_NO," ).append("\n"); 
		query.append("                TRSP_AGMT_SCG_NOD_SEQ," ).append("\n"); 
		query.append("                TRSP_AGMT_SCG_RT_SEQ," ).append("\n"); 
		query.append("				FUEL_RTO," ).append("\n"); 
		query.append("                COM_SCG_KND_CD," ).append("\n"); 
		query.append("                COM_SCG_SEQ," ).append("\n"); 
		query.append("                NULL AS SCG_DTL_SEQ," ).append("\n"); 
		query.append("                DECODE(D.CURR_CD, 'XXX', @[po_local_curr_cd], D.CURR_CD) AS CURR_CD," ).append("\n"); 
		query.append("                (SELECT ROUND((X1.USD_LOCL_XCH_RT / X2.USD_LOCL_XCH_RT),6) AS RATE" ).append("\n"); 
		query.append("                   FROM GL_MON_XCH_RT X1" ).append("\n"); 
		query.append("                      , GL_MON_XCH_RT X2" ).append("\n"); 
		query.append("                  WHERE X1.ACCT_XCH_RT_YRMON = SUBSTR(REPLACE(@[so_cre_dt],'-',''),1,6) -- S/O Creation Date" ).append("\n"); 
		query.append("                    AND X1.ACCT_XCH_RT_LVL = '1'" ).append("\n"); 
		query.append("                    AND X1.CURR_CD = @[po_local_curr_cd] -- W/O Currency" ).append("\n"); 
		query.append("                    AND X2.ACCT_XCH_RT_YRMON = SUBSTR(REPLACE(@[so_cre_dt],'-',''),1,6) -- S/O Creation Date" ).append("\n"); 
		query.append("                    AND X2.ACCT_XCH_RT_LVL = '1'" ).append("\n"); 
		query.append("                    AND X2.CURR_CD = D.CURR_CD -- SCG Currency" ).append("\n"); 
		query.append("                    AND X1.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                    AND X2.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                ) AS WO_SCG_XCH_RT" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT *" ).append("\n"); 
		query.append("        FROM (               " ).append("\n"); 
		query.append("         SELECT K.*," ).append("\n"); 
		query.append("                ROW_NUMBER() OVER( PARTITION BY TRSP_SCG_CD" ).append("\n"); 
		query.append("                                     ORDER BY EQ_TPSZ_PRIOR_ORDER ASC," ).append("\n"); 
		query.append("                                              CMDT_GRP_CD ASC," ).append("\n"); 
		query.append("                                              LENGTH(DECODE(FM_NOD_CD, '0000000', 'N/A', FM_NOD_CD)) DESC," ).append("\n"); 
		query.append("                                              LENGTH(DECODE(VIA_NOD_CD, '0000000', 'N/A', VIA_NOD_CD)) DESC," ).append("\n"); 
		query.append("                                              LENGTH(DECODE(DOR_NOD_CD, '0000000', 'N/A', DOR_NOD_CD)) DESC," ).append("\n"); 
		query.append("                                              LENGTH(DECODE(TO_NOD_CD, '0000000', 'N/A', TO_NOD_CD)) DESC," ).append("\n"); 
		query.append("                                              CASE WHEN @[trsp_crr_mod_cd] IN ('WD', 'WT', 'TW', 'WR', 'RW') AND @[trsp_bnd_cd] = 'T' THEN TRSP_BND_CD" ).append("\n"); 
		query.append("                                                   WHEN @[trsp_crr_mod_cd] IN ('WD', 'WT', 'TW', 'WR', 'RW') AND NVL(@[trsp_bnd_cd],'N') <> 'T' THEN TRSP_BND_CD" ).append("\n"); 
		query.append("                                                   ELSE NULL" ).append("\n"); 
		query.append("                                              END DESC NULLS LAST," ).append("\n"); 
		query.append("                                              SPCL_CGO_CNTR_TP_CD," ).append("\n"); 
		query.append("                                              TRSP_AGMT_SCG_RT_SEQ DESC," ).append("\n"); 
		query.append("                                              ETC_ADD_AMT" ).append("\n"); 
		query.append("                                 ) AS NUM" ).append("\n"); 
		query.append("          FROM (" ).append("\n"); 
		query.append("                SELECT DISTINCT C.TRSP_AGMT_OFC_CTY_CD," ).append("\n"); 
		query.append("                                C.TRSP_AGMT_SEQ," ).append("\n"); 
		query.append("                                C.TRSP_AGMT_RT_TP_SER_NO," ).append("\n"); 
		query.append("                                C.TRSP_AGMT_SCG_NOD_SEQ," ).append("\n"); 
		query.append("                                C.TRSP_AGMT_SCG_RT_SEQ," ).append("\n"); 
		query.append("                                B.TRSP_SCG_CD," ).append("\n"); 
		query.append("                                A.CRE_OFC_CD," ).append("\n"); 
		query.append("                                C.CRE_USR_ID," ).append("\n"); 
		query.append("                                C.CRE_DT," ).append("\n"); 
		query.append("                                A.TRSP_BND_CD," ).append("\n"); 
		query.append("                                A.CMDT_GRP_CD," ).append("\n"); 
		query.append("                                A.SPCL_CGO_CNTR_TP_CD," ).append("\n"); 
		query.append("                                B.FM_NOD_CD, B.VIA_NOD_CD, B.DOR_NOD_CD, B.TO_NOD_CD," ).append("\n"); 
		query.append("                                CASE" ).append("\n"); 
		query.append("                                    WHEN C.TRSP_AGMT_EQ_TP_SZ_CD IS NULL THEN 9" ).append("\n"); 
		query.append("                                    WHEN C.TRSP_AGMT_EQ_TP_SZ_CD = 'ALAL' THEN 4" ).append("\n"); 
		query.append("                                    WHEN C.TRSP_AGMT_EQ_TP_SZ_CD LIKE '%AL%' THEN 2" ).append("\n"); 
		query.append("                                    WHEN C.TRSP_AGMT_EQ_TP_SZ_CD = @[eq_tpsz_cd] THEN 1" ).append("\n"); 
		query.append("                                    ELSE 3" ).append("\n"); 
		query.append("                                END EQ_TPSZ_PRIOR_ORDER," ).append("\n"); 
		query.append("                                CASE" ).append("\n"); 
		query.append("                                  WHEN @[trsp_cost_dtl_mod_cd] = 'DR' THEN NVL(C.TRSP_RND_RT, C.TRSP_ONE_WY_RT)" ).append("\n"); 
		query.append("                                  ELSE NVL(C.TRSP_ONE_WY_RT, C.TRSP_RND_RT)" ).append("\n"); 
		query.append("                                END AS ETC_ADD_AMT," ).append("\n"); 
		query.append("                                CASE" ).append("\n"); 
		query.append("                                  WHEN @[trsp_cost_dtl_mod_cd] = 'DR' THEN DECODE(C.AGMT_SCG_RT_DIV_CD, 'F', '0.00', NVL(C.TRSP_RND_RT, C.TRSP_ONE_WY_RT))" ).append("\n"); 
		query.append("                                  ELSE DECODE(NVL(C.AGMT_SCG_RT_DIV_CD, 'F'), 'F', '0.00', NVL(C.TRSP_ONE_WY_RT, C.TRSP_RND_RT))" ).append("\n"); 
		query.append("                                END AS FUEL_RTO," ).append("\n"); 
		query.append("                                NULL AS COM_SCG_KND_CD," ).append("\n"); 
		query.append("                                NULL AS COM_SCG_SEQ," ).append("\n"); 
		query.append("                                C.CURR_CD" ).append("\n"); 
		query.append("                  FROM TRS_AGMT_RT_TP   A," ).append("\n"); 
		query.append("                       TRS_AGMT_SCG_NOD B," ).append("\n"); 
		query.append("                       TRS_AGMT_SCG_RT  C" ).append("\n"); 
		query.append("                 WHERE A.TRSP_AGMT_OFC_CTY_CD   = B.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("                   AND A.TRSP_AGMT_SEQ          = B.TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("                   AND A.TRSP_AGMT_RT_TP_SER_NO = B.TRSP_AGMT_RT_TP_SER_NO" ).append("\n"); 
		query.append("                   AND B.TRSP_AGMT_OFC_CTY_CD   = C.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("                   AND B.TRSP_AGMT_SEQ          = C.TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("                   AND B.TRSP_AGMT_RT_TP_SER_NO = C.TRSP_AGMT_RT_TP_SER_NO" ).append("\n"); 
		query.append("                   AND B.TRSP_AGMT_SCG_NOD_SEQ  = C.TRSP_AGMT_SCG_NOD_SEQ" ).append("\n"); 
		query.append("--                   AND B.TRSP_SCG_CD           != 'SCFAAL'" ).append("\n"); 
		query.append("--                   AND B.TRSP_SCG_CD           != 'SCFCAL'" ).append("\n"); 
		query.append("                   AND C.COM_SCG_APLY_FLG      != '1'" ).append("\n"); 
		query.append("                   AND C.WO_APLY_FLG            = '1'" ).append("\n"); 
		query.append("                   AND C.TRSP_AGMT_OFC_CTY_CD   = @[po_trsp_agmt_ofc_cty_cd]" ).append("\n"); 
		query.append("                   AND C.TRSP_AGMT_SEQ          = @[po_trsp_agmt_seq]" ).append("\n"); 
		query.append("                   AND A.TRSP_COST_MOD_CD       = DECODE(@[trsp_cost_dtl_mod_cd], 'DR', 'DR', 'CY')" ).append("\n"); 
		query.append("                   AND A.AGMT_TRSP_TP_CD        = @[trsp_crr_mod_cd]" ).append("\n"); 
		query.append("                   AND C.EQ_KND_CD              = @[eq_knd_cd]" ).append("\n"); 
		query.append("                   AND C.TRSP_AGMT_EQ_TP_SZ_CD IN (@[eq_tpsz_cd], SUBSTR(@[eq_tpsz_cd], 1, 1) || 'AL', 'AL' || SUBSTR(@[eq_tpsz_cd], 2, 1), 'ALAL')" ).append("\n"); 
		query.append("#if (${cgo_tp_cd} != '')" ).append("\n"); 
		query.append("                   AND NVL(A.CGO_TP_CD, DECODE(@[cgo_tp_cd], 'F', 'F', 'C', 'F', 'M', 'M')) = DECODE(@[cgo_tp_cd], 'F', 'F', 'C', 'F', 'M', 'M')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                   AND (A.SPCL_CGO_CNTR_TP_CD IS NULL " ).append("\n"); 
		query.append("                         OR" ).append("\n"); 
		query.append("                        CASE WHEN @[spcl_cgo_cntr_tp_cd] IS NULL THEN A.SPCL_CGO_CNTR_TP_CD" ).append("\n"); 
		query.append("                             ELSE @[spcl_cgo_cntr_tp_cd]" ).append("\n"); 
		query.append("                        END = A.SPCL_CGO_CNTR_TP_CD)" ).append("\n"); 
		query.append("                   AND ((" ).append("\n"); 
		query.append("                              1=1" ).append("\n"); 
		query.append("#if (${fm_nod_cd} != '')" ).append("\n"); 
		query.append("                          AND B.FM_NOD_CD              = DECODE(B.FM_NOD_CD, '0000000', '0000000', DECODE(LENGTH(B.FM_NOD_CD), 7, @[fm_nod_cd], 5, SUBSTR(@[fm_nod_cd], 1, 5)))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${via_nod_cd} != '')" ).append("\n"); 
		query.append("                          AND B.VIA_NOD_CD             = DECODE(B.VIA_NOD_CD, '0000000', '0000000', DECODE(LENGTH(B.VIA_NOD_CD), 7, @[via_nod_cd], 5, SUBSTR(@[via_nod_cd], 1, 5)))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${dor_nod_cd} != '')" ).append("\n"); 
		query.append("                          AND B.DOR_NOD_CD             = DECODE(B.DOR_NOD_CD, '0000000', '0000000', DECODE(LENGTH(B.DOR_NOD_CD), 7, @[dor_nod_cd], 5, SUBSTR(@[dor_nod_cd], 1, 5)))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${to_nod_cd} != '')" ).append("\n"); 
		query.append("                          AND B.TO_NOD_CD              = DECODE(B.TO_NOD_CD, '0000000', '0000000', DECODE(LENGTH(B.TO_NOD_CD), 7, @[to_nod_cd], 5, SUBSTR(@[to_nod_cd], 1, 5)))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                        ) OR (" ).append("\n"); 
		query.append("                              B.FM_NOD_CD              = '0000000'" ).append("\n"); 
		query.append("                          AND B.VIA_NOD_CD             = '0000000'" ).append("\n"); 
		query.append("                          AND B.DOR_NOD_CD             = '0000000'" ).append("\n"); 
		query.append("                          AND B.TO_NOD_CD              = '0000000'" ).append("\n"); 
		query.append("                   ))" ).append("\n"); 
		query.append("#if (${cre_dt} != '')" ).append("\n"); 
		query.append("                   AND SUBSTR(@[cre_dt],1,8) BETWEEN TO_CHAR(C.EFF_FM_DT, 'YYYYMMDD') AND TO_CHAR(C.EFF_TO_DT, 'YYYYMMDD')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                   AND CASE WHEN B.TRSP_SCG_CD = 'SCOWAL'" ).append("\n"); 
		query.append("                            THEN TRS_COMMON_PKG.GET_CONV_WGT_TO_KG_FNC(DECODE(C.WGT_MEAS_UT_CD, NULL, 'KGS', 'XXX', 'KGS', C.WGT_MEAS_UT_CD), C.TO_WGT)" ).append("\n"); 
		query.append("                            ELSE 1" ).append("\n"); 
		query.append("                       END > CASE WHEN B.TRSP_SCG_CD = 'SCOWAL'" ).append("\n"); 
		query.append("                                  THEN TRS_COMMON_PKG.GET_CONV_WGT_TO_KG_FNC(DECODE(@[wgt_meas_ut_cd], NULL, 'KGS', 'XXX', 'KGS', @[wgt_meas_ut_cd]), " ).append("\n"); 
		query.append("                                                                             DECODE(@[wgt_meas_ut_cd], NULL, @[kgs_net_wgt], 'XXX', @[kgs_net_wgt], 'KGS', @[kgs_net_wgt], @[lbs_net_wgt]))" ).append("\n"); 
		query.append("                                  ELSE 0" ).append("\n"); 
		query.append("                             END" ).append("\n"); 
		query.append("	        UNION ALL" ).append("\n"); 
		query.append("	        SELECT DISTINCT C.TRSP_AGMT_OFC_CTY_CD," ).append("\n"); 
		query.append("    	                    C.TRSP_AGMT_SEQ," ).append("\n"); 
		query.append("        	                C.TRSP_AGMT_RT_TP_SER_NO," ).append("\n"); 
		query.append("            	            C.TRSP_AGMT_SCG_NOD_SEQ," ).append("\n"); 
		query.append("                	        C.TRSP_AGMT_SCG_RT_SEQ," ).append("\n"); 
		query.append("                    	    B.TRSP_SCG_CD," ).append("\n"); 
		query.append("	                        A.CRE_OFC_CD," ).append("\n"); 
		query.append("    	                    C.CRE_USR_ID," ).append("\n"); 
		query.append("        	                C.CRE_DT," ).append("\n"); 
		query.append("            	            A.TRSP_BND_CD," ).append("\n"); 
		query.append("                	        A.CMDT_GRP_CD," ).append("\n"); 
		query.append("                    	    A.SPCL_CGO_CNTR_TP_CD," ).append("\n"); 
		query.append("                        	B.FM_NOD_CD, B.VIA_NOD_CD, B.DOR_NOD_CD, B.TO_NOD_CD," ).append("\n"); 
		query.append("	                        CASE" ).append("\n"); 
		query.append("    	                    	WHEN C.TRSP_AGMT_EQ_TP_SZ_CD IS NULL THEN 9" ).append("\n"); 
		query.append("        	                    WHEN C.TRSP_AGMT_EQ_TP_SZ_CD = 'ALAL' THEN 4" ).append("\n"); 
		query.append("            	                WHEN C.TRSP_AGMT_EQ_TP_SZ_CD LIKE '%AL%' THEN 2" ).append("\n"); 
		query.append("                    	        WHEN C.TRSP_AGMT_EQ_TP_SZ_CD = @[eq_tpsz_cd] THEN 1" ).append("\n"); 
		query.append("                	            ELSE 3" ).append("\n"); 
		query.append("                        	END EQ_TPSZ_PRIOR_ORDER," ).append("\n"); 
		query.append("	                        NVL(D.ETC_ADD_AMT, 0) ETC_ADD_AMT," ).append("\n"); 
		query.append("							FUEL_RTO," ).append("\n"); 
		query.append("        	                D.COM_SCG_KND_CD," ).append("\n"); 
		query.append("            	            D.COM_SCG_SEQ," ).append("\n"); 
		query.append("                            D.CURR_CD" ).append("\n"); 
		query.append("	          FROM TRS_AGMT_RT_TP   A," ).append("\n"); 
		query.append("	               TRS_AGMT_SCG_NOD B," ).append("\n"); 
		query.append("    	           TRS_AGMT_SCG_RT  C," ).append("\n"); 
		query.append("	               (SELECT COM_SCG_KND_CD, DECODE(@[trsp_cost_dtl_mod_cd], 'DR', SUM(NVL(RND_RT, ONE_WY_RT)), SUM(NVL(ONE_WY_RT, RND_RT))) ETC_ADD_AMT," ).append("\n"); 
		query.append("						   DECODE(MAX(RT_TP_CD), 'F', '0.00',  DECODE(@[trsp_cost_dtl_mod_cd], 'DR', SUM(NVL(RND_RT, ONE_WY_RT)), SUM(NVL(ONE_WY_RT, RND_RT)))) FUEL_RTO " ).append("\n"); 
		query.append("        	              ,COM_SCG_SEQ" ).append("\n"); 
		query.append("                          ,DECODE(MAX(RT_TP_CD), 'F', MAX(CURR_CD), 'XXX') AS CURR_CD" ).append("\n"); 
		query.append("            	      FROM (" ).append("\n"); 
		query.append("                	         SELECT COM_SCG_KND_CD, ONE_WY_RT, RND_RT, NVL(RT_TP_CD, 'F') RT_TP_CD  " ).append("\n"); 
		query.append("                    	          , ROW_NUMBER() OVER (ORDER BY SCC_CD, LCC_CD, RCC_CD, BND_CD, DECODE(EQ_TPSZ_CD, @[eq_tpsz_cd],1, 'ALAL', 2, SUBSTR(@[eq_tpsz_cd], 1, 1) || 'AL', 3, 'AL' || SUBSTR(@[eq_tpsz_cd], 2, 1), 4) ASC) RN" ).append("\n"); 
		query.append("                        	      , COM_SCG_SEQ" ).append("\n"); 
		query.append("                                  , CURR_CD" ).append("\n"); 
		query.append("	                           FROM TRS_COM_SCG_MGMT" ).append("\n"); 
		query.append("    	                      WHERE 1=1" ).append("\n"); 
		query.append("        	                    AND TRSP_COST_MOD_CD = DECODE(@[trsp_cost_dtl_mod_cd], 'DR', 'DR', 'CY')" ).append("\n"); 
		query.append("            	                AND AGMT_TRSP_TP_CD  = @[trsp_crr_mod_cd]" ).append("\n"); 
		query.append("                                AND EQ_KND_CD = @[eq_knd_cd]" ).append("\n"); 
		query.append("			                    AND (SCC_CD = MST_LOC_FNC(SUBSTR(@[fm_nod_cd], 1, 5),'SCC') OR" ).append("\n"); 
		query.append("			   		                 LCC_CD IN (MST_LOC_FNC(SUBSTR(@[fm_nod_cd], 1, 5),'LCC')) OR" ).append("\n"); 
		query.append("					                 RCC_CD IN (MST_LOC_FNC(SUBSTR(@[fm_nod_cd], 1, 5),'RCC'))" ).append("\n"); 
		query.append("			                        )" ).append("\n"); 
		query.append("#if (${cgo_tp_cd} != '')" ).append("\n"); 
		query.append("	                            AND NVL(CGO_TP_CD, DECODE(@[cgo_tp_cd], 'F', 'F', 'C', 'F', 'M', 'M')) = DECODE(@[cgo_tp_cd], 'F', 'F', 'C', 'F', 'M', 'M')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${trsp_bnd_cd} != '')" ).append("\n"); 
		query.append("	                            AND NVL(BND_CD, @[trsp_bnd_cd]) = @[trsp_bnd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cre_dt} != '')" ).append("\n"); 
		query.append("    	                        AND SUBSTR(@[cre_dt],1,8) BETWEEN TO_CHAR(EFF_FM_DT, 'YYYYMMDD') AND TO_CHAR(EFF_TO_DT, 'YYYYMMDD')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("	                        )" ).append("\n"); 
		query.append("--	                  WHERE RN = 1" ).append("\n"); 
		query.append("	                  GROUP BY COM_SCG_KND_CD" ).append("\n"); 
		query.append("	                          ,COM_SCG_SEQ" ).append("\n"); 
		query.append("    	           ) D" ).append("\n"); 
		query.append("	         WHERE A.TRSP_AGMT_OFC_CTY_CD   = B.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("    	       AND A.TRSP_AGMT_SEQ          = B.TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("        	   AND A.TRSP_AGMT_RT_TP_SER_NO = B.TRSP_AGMT_RT_TP_SER_NO" ).append("\n"); 
		query.append("	           AND B.TRSP_AGMT_OFC_CTY_CD   = C.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("    	       AND B.TRSP_AGMT_SEQ          = C.TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("        	   AND B.TRSP_AGMT_RT_TP_SER_NO = C.TRSP_AGMT_RT_TP_SER_NO" ).append("\n"); 
		query.append("	           AND B.TRSP_AGMT_SCG_NOD_SEQ  = C.TRSP_AGMT_SCG_NOD_SEQ" ).append("\n"); 
		query.append("--  	         AND B.TRSP_SCG_CD           != 'SCFAAL'" ).append("\n"); 
		query.append("--      	     AND B.TRSP_SCG_CD           != 'SCFCAL'" ).append("\n"); 
		query.append("	           AND C.COM_SCG_APLY_FLG       = '1'" ).append("\n"); 
		query.append("    	       AND C.WO_APLY_FLG            = '1'" ).append("\n"); 
		query.append("        	   AND C.TRSP_AGMT_OFC_CTY_CD   = @[po_trsp_agmt_ofc_cty_cd]" ).append("\n"); 
		query.append("	           AND C.TRSP_AGMT_SEQ          = @[po_trsp_agmt_seq]" ).append("\n"); 
		query.append("               AND A.TRSP_COST_MOD_CD       = DECODE(@[trsp_cost_dtl_mod_cd], 'DR', 'DR', 'CY')" ).append("\n"); 
		query.append("               AND A.AGMT_TRSP_TP_CD        = @[trsp_crr_mod_cd]" ).append("\n"); 
		query.append("               AND C.EQ_KND_CD              = @[eq_knd_cd]" ).append("\n"); 
		query.append("#if (${cre_dt} != '')" ).append("\n"); 
		query.append("    	       AND SUBSTR(@[cre_dt],1,8) BETWEEN TO_CHAR(C.EFF_FM_DT, 'YYYYMMDD') AND TO_CHAR(C.EFF_TO_DT, 'YYYYMMDD')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        	   AND (A.SPCL_CGO_CNTR_TP_CD IS NULL " ).append("\n"); 
		query.append("            	     OR" ).append("\n"); 
		query.append("                	CASE WHEN @[spcl_cgo_cntr_tp_cd] IS NULL THEN A.SPCL_CGO_CNTR_TP_CD" ).append("\n"); 
		query.append("                    	 ELSE @[spcl_cgo_cntr_tp_cd]" ).append("\n"); 
		query.append("	                END = A.SPCL_CGO_CNTR_TP_CD)" ).append("\n"); 
		query.append("	           AND B.TRSP_SCG_CD            = D.COM_SCG_KND_CD(+)" ).append("\n"); 
		query.append("    	       AND NVL(D.ETC_ADD_AMT, 0) > 0" ).append("\n"); 
		query.append("#if (${cgo_tp_cd} != '')" ).append("\n"); 
		query.append("               AND NVL(A.CGO_TP_CD, DECODE(@[cgo_tp_cd], 'F', 'F', 'C', 'F', 'M', 'M')) = DECODE(@[cgo_tp_cd], 'F', 'F', 'C', 'F', 'M', 'M')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("               ) K" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("            WHERE TRSP_SCG_CD = 'SCOTAL'" ).append("\n"); 
		query.append("               OR (TRSP_SCG_CD !='SCOTAL' AND NUM < 2)" ).append("\n"); 
		query.append("       ) D" ).append("\n"); 
		query.append(" WHERE D.ETC_ADD_AMT IS NOT NULL" ).append("\n"); 
		query.append(") T" ).append("\n"); 

	}
}