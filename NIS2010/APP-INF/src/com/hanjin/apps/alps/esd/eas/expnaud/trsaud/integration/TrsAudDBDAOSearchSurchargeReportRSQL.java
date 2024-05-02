/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : TrsAudDBDAOSearchSurchargeReportRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.06.12
*@LastModifier : 
*@LastVersion : 1.0
* 2018.06.12 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.expnaud.trsaud.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TrsAudDBDAOSearchSurchargeReportRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Surcharge Report 데이타를 조회
	  * </pre>
	  */
	public TrsAudDBDAOSearchSurchargeReportRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_cgo_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_rhq_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_eac_if",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_trns_mod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_dt_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.expnaud.trsaud.integration").append("\n"); 
		query.append("FileName : TrsAudDBDAOSearchSurchargeReportRSQL").append("\n"); 
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
		query.append("SELECT YR_MON" ).append("\n"); 
		query.append("      ,SO_NO" ).append("\n"); 
		query.append("      ,WO_NO" ).append("\n"); 
		query.append("      ,INV_NO" ).append("\n"); 
		query.append("      ,BKG_NO" ).append("\n"); 
		query.append("      ,EQ_NO" ).append("\n"); 
		query.append("      ,EQ_TPSZ_CD" ).append("\n"); 
		query.append("      ,CGO_TP_CD" ).append("\n"); 
		query.append("      ,COST_NM" ).append("\n"); 
		query.append("      ,CURR_CD " ).append("\n"); 
		query.append("      ,SCG_AMT" ).append("\n"); 
		query.append("      ,SCG_USD_AMT" ).append("\n"); 
		query.append("      ,INV_CURR_CD" ).append("\n"); 
		query.append("      ,INV_SCG_AMT" ).append("\n"); 
		query.append("      ,INV_USD_SCG_AMT" ).append("\n"); 
		query.append("      ,TRSP_CRR_MOD_CD" ).append("\n"); 
		query.append("      ,FM_NOD_CD" ).append("\n"); 
		query.append("      ,VIA_NOD_CD" ).append("\n"); 
		query.append("      ,TO_NOD_CD" ).append("\n"); 
		query.append("      ,DOR_NOD_CD" ).append("\n"); 
		query.append("      ,TRSP_BND_CD" ).append("\n"); 
		query.append("      ,OTR_RMK" ).append("\n"); 
		query.append("      ,TRSP_PURP_RSN" ).append("\n"); 
		query.append("      ,INTER_RMK" ).append("\n"); 
		query.append("      ,INV_OTR_RMK" ).append("\n"); 
		query.append("      ,INV_RMK" ).append("\n"); 
		query.append("      ,RHQ_OFC_CD" ).append("\n"); 
		query.append("      ,SO_OFC_CD" ).append("\n"); 
		query.append("      ,SO_USR_NM" ).append("\n"); 
		query.append("      ,(SELECT 'Y'" ).append("\n"); 
		query.append("          FROM TPB_OTS_GRP X" ).append("\n"); 
		query.append("              ,TPB_OTS_DTL Y" ).append("\n"); 
		query.append("         WHERE X.N3PTY_NO           = Y.N3PTY_NO " ).append("\n"); 
		query.append("           AND Y.N3PTY_EXPN_TP_CD   = 'TRS'" ).append("\n"); 
		query.append("           AND Y.N3PTY_DELT_TP_CD IN ('N')" ).append("\n"); 
		query.append("           AND Y.BKG_NO = AA.BKG_NO" ).append("\n"); 
		query.append("           AND Y.EQ_NO  = AA.EQ_NO" ).append("\n"); 
		query.append("           AND ROWNUM = 1" ).append("\n"); 
		query.append("       ) N3PTY_BIL_FLG" ).append("\n"); 
		query.append("      ,WO_VNDR_SEQ" ).append("\n"); 
		query.append("      ,WO_VNDR_NM" ).append("\n"); 
		query.append("      ,INV_VNDR_SEQ" ).append("\n"); 
		query.append("      ,INV_VNDR_NM" ).append("\n"); 
		query.append("      ,SC_NO" ).append("\n"); 
		query.append("      ,RFA_NO" ).append("\n"); 
		query.append("      ,SHIPPER" ).append("\n"); 
		query.append("      ,CONSIGNEE" ).append("\n"); 
		query.append("      ,LGS_COST_CD" ).append("\n"); 
		query.append("      ,EAC_IF_FLG" ).append("\n"); 
		query.append("      ,(SELECT CASE WHEN X.DCGO_FLG = 'Y' THEN 'DG'" ).append("\n"); 
		query.append("                    WHEN X.BB_CGO_FLG = 'Y' THEN 'BB'" ).append("\n"); 
		query.append("                    WHEN X.AWK_CGO_FLG= 'Y' THEN 'AK'" ).append("\n"); 
		query.append("                    WHEN X.RC_FLG = 'Y' THEN 'RF'" ).append("\n"); 
		query.append("                    WHEN X.RD_CGO_FLG = 'Y' THEN 'RD' END" ).append("\n"); 
		query.append("          FROM BKG_CONTAINER X " ).append("\n"); 
		query.append("         WHERE X.BKG_NO  = AA.BKG_NO" ).append("\n"); 
		query.append("           AND X.CNTR_NO = AA.EQ_NO" ).append("\n"); 
		query.append("       ) CNTR_SPE" ).append("\n"); 
		query.append("      ,NEGO_RMK" ).append("\n"); 
		query.append("      ,SPCL_INSTR_RMK" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT CASE WHEN @[s_dt_tp_cd] = 'W' THEN TO_CHAR(C.LOCL_CRE_DT, 'YYYYMM')" ).append("\n"); 
		query.append("                    WHEN @[s_dt_tp_cd] = 'I' THEN TO_CHAR(D.INV_CFM_DT, 'YYYYMM')            " ).append("\n"); 
		query.append("               END YR_MON" ).append("\n"); 
		query.append("              ,A.TRSP_SO_OFC_CTY_CD||A.TRSP_SO_SEQ AS SO_NO" ).append("\n"); 
		query.append("              ,A.TRSP_WO_OFC_CTY_CD||A.TRSP_WO_SEQ AS WO_NO" ).append("\n"); 
		query.append("              ,A.INV_NO" ).append("\n"); 
		query.append("              ,A.BKG_NO" ).append("\n"); 
		query.append("              ,A.EQ_NO" ).append("\n"); 
		query.append("              ,A.EQ_TPSZ_CD" ).append("\n"); 
		query.append("              ,A.CGO_TP_CD" ).append("\n"); 
		query.append("              ,(SELECT X.LGS_COST_FULL_NM FROM TES_LGS_COST X WHERE X.LGS_COST_CD = B.LGS_COST_CD) AS COST_NM" ).append("\n"); 
		query.append("              ,A.CURR_CD" ).append("\n"); 
		query.append("              ,B.SCG_AMT -- W/O SURCHARGE" ).append("\n"); 
		query.append("              ,ROUND (B.SCG_AMT / " ).append("\n"); 
		query.append("                     CASE WHEN NVL(A.CURR_CD,'USD') = 'USD' THEN 1" ).append("\n"); 
		query.append("                          ELSE " ).append("\n"); 
		query.append("                          (SELECT USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                             FROM GL_MON_XCH_RT XCH" ).append("\n"); 
		query.append("                            WHERE XCH.ACCT_XCH_RT_LVL = 1 " ).append("\n"); 
		query.append("                              AND XCH.CURR_CD           = A.CURR_CD" ).append("\n"); 
		query.append("                              AND XCH.ACCT_XCH_RT_YRMON = NVL(TO_CHAR(C.LOCL_CRE_DT,'YYYYMM'),TO_CHAR (A.LOCL_CRE_DT, 'YYYYMM')))" ).append("\n"); 
		query.append("                           END" ).append("\n"); 
		query.append("                     , 2) SCG_USD_AMT" ).append("\n"); 
		query.append("              ,A.INV_CURR_CD" ).append("\n"); 
		query.append("              ,B.INV_SCG_AMT" ).append("\n"); 
		query.append("              ,ROUND (B.INV_SCG_AMT / " ).append("\n"); 
		query.append("                     CASE WHEN NVL(A.CURR_CD,'USD') = 'USD' THEN 1" ).append("\n"); 
		query.append("                          ELSE " ).append("\n"); 
		query.append("                          (SELECT USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                             FROM GL_MON_XCH_RT XCH" ).append("\n"); 
		query.append("                            WHERE XCH.ACCT_XCH_RT_LVL = 1 " ).append("\n"); 
		query.append("                              AND XCH.CURR_CD           = A.INV_CURR_CD" ).append("\n"); 
		query.append("                              AND XCH.ACCT_XCH_RT_YRMON = TO_CHAR(D.LOCL_CRE_DT,'YYYYMM'))" ).append("\n"); 
		query.append("                           END" ).append("\n"); 
		query.append("                     , 2) INV_USD_SCG_AMT" ).append("\n"); 
		query.append("              ,A.TRSP_CRR_MOD_CD" ).append("\n"); 
		query.append("              ,A.FM_NOD_CD" ).append("\n"); 
		query.append("              ,A.VIA_NOD_CD" ).append("\n"); 
		query.append("              ,A.TO_NOD_CD" ).append("\n"); 
		query.append("              ,A.DOR_NOD_CD" ).append("\n"); 
		query.append("              ,A.TRSP_BND_CD      " ).append("\n"); 
		query.append("              ,B.OTR_RMK             -- W/O Surcharge - Other Surcharge Remark" ).append("\n"); 
		query.append("              ,A.TRSP_PURP_RSN         -- W/O Surcharge - Remark" ).append("\n"); 
		query.append("              ,A.INTER_RMK             -- W/O Surcharge - Internal Remark" ).append("\n"); 
		query.append("              ,B.INV_OTR_RMK         -- Invoice Surcharge - Other Surcharge Remark" ).append("\n"); 
		query.append("              ,A.INV_RMK             -- Invoice Surcharge - Inv Remark" ).append("\n"); 
		query.append("              ,TRS_COMMON_PKG.TRS_GET_RHQ_OFC_CD(A.CRE_OFC_CD) RHQ_OFC_CD" ).append("\n"); 
		query.append("              ,A.CRE_OFC_CD AS SO_OFC_CD" ).append("\n"); 
		query.append("              ,(SELECT X.USR_NM FROM COM_USER X WHERE X.USR_ID = C.CRE_USR_ID) AS SO_USR_NM" ).append("\n"); 
		query.append("              ,WVDR.VNDR_SEQ     AS WO_VNDR_SEQ" ).append("\n"); 
		query.append("              ,WVDR.VNDR_LGL_ENG_NM AS WO_VNDR_NM" ).append("\n"); 
		query.append("              ,IVDR.VNDR_SEQ     AS INV_VNDR_SEQ" ).append("\n"); 
		query.append("              ,IVDR.VNDR_LGL_ENG_NM AS INV_VNDR_NM " ).append("\n"); 
		query.append("              ,(SELECT BKG.SC_NO" ).append("\n"); 
		query.append("                  FROM BKG_BOOKING BKG     " ).append("\n"); 
		query.append("                 WHERE BKG.BKG_NO = A.BKG_NO) SC_NO" ).append("\n"); 
		query.append("              ,(SELECT BKG.RFA_NO " ).append("\n"); 
		query.append("                  FROM BKG_BOOKING BKG     " ).append("\n"); 
		query.append("                 WHERE BKG.BKG_NO = A.BKG_NO) RFA_NO" ).append("\n"); 
		query.append("              ,(SELECT REPLACE (CUST_NM, CHR (13) || CHR (10),' ')" ).append("\n"); 
		query.append("                  FROM BKG_CUSTOMER CUST" ).append("\n"); 
		query.append("                 WHERE CUST.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("                   AND CUST.BKG_CUST_TP_CD = 'S' ) AS SHIPPER" ).append("\n"); 
		query.append("              ,(SELECT REPLACE (CUST_NM, CHR (13) || CHR (10),' ')" ).append("\n"); 
		query.append("                  FROM BKG_CUSTOMER CUST" ).append("\n"); 
		query.append("                 WHERE CUST.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("                   AND CUST.BKG_CUST_TP_CD = 'C' ) AS CONSIGNEE" ).append("\n"); 
		query.append("              ,B.LGS_COST_CD" ).append("\n"); 
		query.append("              ,(SELECT 'Y'" ).append("\n"); 
		query.append("                  FROM EAS_TRSP_COST_CHK X" ).append("\n"); 
		query.append("                 WHERE X.TRSP_SO_OFC_CTY_CD = A.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("                   AND X.TRSP_SO_SEQ        = A.TRSP_SO_SEQ" ).append("\n"); 
		query.append("                   AND X.EAC_SYS_IF_CD      = 'TR2'" ).append("\n"); 
		query.append("                   AND X.LGS_COST_CD        = B.LGS_COST_CD" ).append("\n"); 
		query.append("               ) EAC_IF_FLG" ).append("\n"); 
		query.append("              ,A.NEGO_RMK" ).append("\n"); 
		query.append("              ,A.SPCL_INSTR_RMK" ).append("\n"); 
		query.append("          FROM TRS_TRSP_SVC_ORD A  " ).append("\n"); 
		query.append("              ,TRS_TRSP_SCG_DTL B" ).append("\n"); 
		query.append("              ,TRS_TRSP_WRK_ORD C" ).append("\n"); 
		query.append("              ,TRS_TRSP_INV_WRK D" ).append("\n"); 
		query.append("              ,MDM_VENDOR WVDR" ).append("\n"); 
		query.append("              ,MDM_VENDOR IVDR" ).append("\n"); 
		query.append("         WHERE A.TRSP_SO_OFC_CTY_CD = B.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("           AND A.TRSP_SO_SEQ        = B.TRSP_SO_SEQ" ).append("\n"); 
		query.append("           AND A.TRSP_WO_OFC_CTY_CD = C.TRSP_WO_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("           AND A.TRSP_WO_SEQ        = C.TRSP_WO_SEQ(+)" ).append("\n"); 
		query.append("           AND A.INV_NO             = D.INV_NO(+)" ).append("\n"); 
		query.append("           AND A.INV_VNDR_SEQ       = D.INV_VNDR_SEQ(+)" ).append("\n"); 
		query.append("           /*" ).append("\n"); 
		query.append("           AND WVDR.VNDR_SEQ = CASE WHEN A.HJL_NO IS NOT NULL THEN (SELECT X.HJL_VNDR_SEQ FROM TRS_TRSP_HJL_SVC_ORD X WHERE X.TRSP_SO_OFC_CTY_CD = A.TRSP_SO_OFC_CTY_CD AND X.TRSP_SO_SEQ = A.TRSP_SO_SEQ)" ).append("\n"); 
		query.append("                                    ELSE A.VNDR_SEQ" ).append("\n"); 
		query.append("                               END" ).append("\n"); 
		query.append("           AND IVDR.VNDR_SEQ = CASE WHEN A.HJL_NO IS NOT NULL THEN (SELECT X.HJL_INV_VNDR_SEQ FROM TRS_TRSP_HJL_SVC_ORD X WHERE X.TRSP_SO_OFC_CTY_CD = A.TRSP_SO_OFC_CTY_CD AND X.TRSP_SO_SEQ = A.TRSP_SO_SEQ)" ).append("\n"); 
		query.append("                                    ELSE A.INV_VNDR_SEQ" ).append("\n"); 
		query.append("                               END" ).append("\n"); 
		query.append("           */" ).append("\n"); 
		query.append("           AND WVDR.VNDR_SEQ = A.VNDR_SEQ" ).append("\n"); 
		query.append("           AND IVDR.VNDR_SEQ(+) = A.INV_VNDR_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("           #if (${s_ofc_tp_cd} == 'W' && ${s_dt_tp_cd} == 'W' && ${s_ofc_cd} == '')" ).append("\n"); 
		query.append("                AND C.CRE_OFC_CD IN (SELECT OFC_CD " ).append("\n"); 
		query.append("                                       FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("                                      WHERE DELT_FLG = 'N'" ).append("\n"); 
		query.append("                                    CONNECT BY NOCYCLE PRIOR OFC_CD = PRNT_OFC_CD" ).append("\n"); 
		query.append("                                      START WITH OFC_CD = @[s_rhq_ofc_cd]" ).append("\n"); 
		query.append("                                    )" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("           #if ((${s_ofc_tp_cd} == 'I' || ${s_dt_tp_cd} == 'I') && ${s_ofc_cd} == '')" ).append("\n"); 
		query.append("                AND 1=2" ).append("\n"); 
		query.append("           #end " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("           #if (${s_ofc_tp_cd} == 'W' && ${s_ofc_cd} != '')" ).append("\n"); 
		query.append("                AND C.CRE_OFC_CD = @[s_ofc_cd]" ).append("\n"); 
		query.append("           #elseif (${s_ofc_tp_cd} == 'I' && ${s_ofc_cd} != '')" ).append("\n"); 
		query.append("                AND D.CRE_OFC_CD = @[s_ofc_cd]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           " ).append("\n"); 
		query.append("           #if (${s_dt_tp_cd} == 'W')" ).append("\n"); 
		query.append("                AND C.LOCL_CRE_DT BETWEEN TO_DATE (REPLACE(@[s_fm_dt],'-',''), 'rrrrmmdd') AND TO_DATE (REPLACE(@[s_to_dt],'-',''), 'rrrrmmdd') + 0.999999 -- s_dt_tp_cd = 'W' 일 경우 (Work order Date)" ).append("\n"); 
		query.append("           #elseif (${s_dt_tp_cd} == 'I')" ).append("\n"); 
		query.append("                AND D.INV_CFM_DT BETWEEN TO_DATE (REPLACE(@[s_fm_dt],'-',''), 'rrrrmmdd') AND TO_DATE (REPLACE(@[s_to_dt],'-',''), 'rrrrmmdd') + 0.999999 -- s_dt_tp_cd = 'I' 일 경우 (Invoice Date)" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           " ).append("\n"); 
		query.append("           #if (${s_trns_mod_cd} != '')" ).append("\n"); 
		query.append("                AND A.TRSP_CRR_MOD_CD = @[s_trns_mod_cd]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if($s_scg_cd.size() > 0) " ).append("\n"); 
		query.append("                AND (" ).append("\n"); 
		query.append("                    #foreach( ${key} in ${s_scg_cd}) " ).append("\n"); 
		query.append("                        #if($velocityCount == 1)" ).append("\n"); 
		query.append("                              #if ($key.length() == 4)" ).append("\n"); 
		query.append("                                SUBSTR(B.LGS_COST_CD, 3,4)= '$key'" ).append("\n"); 
		query.append("                            #else" ).append("\n"); 
		query.append("                                SUBSTR(B.LGS_COST_CD, 3,2)= '$key'" ).append("\n"); 
		query.append("                            #end" ).append("\n"); 
		query.append("                        #else" ).append("\n"); 
		query.append("                            #if ($key.length() == 4)" ).append("\n"); 
		query.append("                                OR SUBSTR(B.LGS_COST_CD, 3,4)= '$key'" ).append("\n"); 
		query.append("                            #else" ).append("\n"); 
		query.append("                                OR SUBSTR(B.LGS_COST_CD, 3,2)= '$key'" ).append("\n"); 
		query.append("                            #end" ).append("\n"); 
		query.append("                        #end " ).append("\n"); 
		query.append("                    #end" ).append("\n"); 
		query.append("                   )" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("           #if (${s_cgo_tp_cd} != '')" ).append("\n"); 
		query.append("                AND A.CGO_TP_CD = @[s_cgo_tp_cd]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           " ).append("\n"); 
		query.append("           #if (${s_srch_opt_cd} == 'WP') " ).append("\n"); 
		query.append("                AND NVL(B.SCG_AMT,0) > 0" ).append("\n"); 
		query.append("           #elseif (${s_srch_opt_cd} == 'WM')" ).append("\n"); 
		query.append("                AND NVL(B.SCG_AMT,0) < 0" ).append("\n"); 
		query.append("           #elseif (${s_srch_opt_cd} == 'WN')" ).append("\n"); 
		query.append("                AND NVL(B.SCG_AMT,0) <> 0" ).append("\n"); 
		query.append("           #elseif (${s_srch_opt_cd} == 'IP')                " ).append("\n"); 
		query.append("                AND NVL(B.INV_SCG_AMT,0) > 0" ).append("\n"); 
		query.append("           #elseif (${s_srch_opt_cd} == 'IM')                " ).append("\n"); 
		query.append("                AND NVL(B.INV_SCG_AMT,0) < 0" ).append("\n"); 
		query.append("           #elseif (${s_srch_opt_cd} == 'IN')" ).append("\n"); 
		query.append("                AND NVL(B.INV_SCG_AMT,0) <> 0" ).append("\n"); 
		query.append("           #elseif (${s_srch_opt_cd} == 'NR')" ).append("\n"); 
		query.append("               #if (${s_ofc_tp_cd} == 'W')" ).append("\n"); 
		query.append("                   AND ( TRIM(B.OTR_RMK) IS NULL AND TRIM(A.SPCL_INSTR_RMK) IS NULL AND TRIM(A.INTER_RMK) IS NULL AND TRIM(A.NEGO_RMK) IS NULL)" ).append("\n"); 
		query.append("               #elseif (${s_ofc_tp_cd} == 'I')" ).append("\n"); 
		query.append("                   AND ( TRIM(A.INV_RMK) IS NULL AND TRIM(B.INV_OTR_RMK) IS NULL )" ).append("\n"); 
		query.append("               #end" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT TO_CHAR(C.LOCL_CRE_DT, 'YYYYMM') YR_MON" ).append("\n"); 
		query.append("              ,A.TRSP_SO_OFC_CTY_CD||A.TRSP_SO_SEQ AS SO_NO" ).append("\n"); 
		query.append("              ,A.TRSP_WO_OFC_CTY_CD||A.TRSP_WO_SEQ AS WO_NO" ).append("\n"); 
		query.append("              ,A.INV_NO" ).append("\n"); 
		query.append("              ,A.BKG_NO" ).append("\n"); 
		query.append("              ,A.EQ_NO" ).append("\n"); 
		query.append("              ,A.EQ_TPSZ_CD" ).append("\n"); 
		query.append("              ,A.CGO_TP_CD" ).append("\n"); 
		query.append("              ,'Nego' AS COST_NM" ).append("\n"); 
		query.append("              ,A.CURR_CD" ).append("\n"); 
		query.append("              ,A.NEGO_AMT                     -- W/O SURCHARGE" ).append("\n"); 
		query.append("              ,ROUND (A.NEGO_AMT / " ).append("\n"); 
		query.append("                     CASE WHEN NVL(A.CURR_CD,'USD') = 'USD' THEN 1" ).append("\n"); 
		query.append("                          ELSE " ).append("\n"); 
		query.append("                          (SELECT USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                             FROM GL_MON_XCH_RT XCH" ).append("\n"); 
		query.append("                            WHERE XCH.ACCT_XCH_RT_LVL = 1 " ).append("\n"); 
		query.append("                              AND XCH.CURR_CD           = A.CURR_CD" ).append("\n"); 
		query.append("                              AND XCH.ACCT_XCH_RT_YRMON = NVL(TO_CHAR(C.LOCL_CRE_DT,'YYYYMM'),TO_CHAR (A.LOCL_CRE_DT, 'YYYYMM')))" ).append("\n"); 
		query.append("                           END" ).append("\n"); 
		query.append("                     , 2) SCG_USD_AMT" ).append("\n"); 
		query.append("              ,'' INV_CURR_CD" ).append("\n"); 
		query.append("              ,NULL INV_SCG_AMT" ).append("\n"); 
		query.append("              ,NULL INV_USD_SCG_AMT" ).append("\n"); 
		query.append("              ,A.TRSP_CRR_MOD_CD" ).append("\n"); 
		query.append("              ,A.FM_NOD_CD" ).append("\n"); 
		query.append("              ,A.VIA_NOD_CD" ).append("\n"); 
		query.append("              ,A.TO_NOD_CD" ).append("\n"); 
		query.append("              ,A.DOR_NOD_CD" ).append("\n"); 
		query.append("              ,A.TRSP_BND_CD      " ).append("\n"); 
		query.append("              ,NULL OTR_RMK                 -- W/O Surcharge - Other Surcharge Remark" ).append("\n"); 
		query.append("              ,A.TRSP_PURP_RSN                 -- W/O Surcharge - Remark" ).append("\n"); 
		query.append("              ,A.INTER_RMK                     -- W/O Surcharge - Internal Remark" ).append("\n"); 
		query.append("              ,NULL INV_OTR_RMK             -- Invoice Surcharge - Other Surcharge Remark" ).append("\n"); 
		query.append("              ,A.INV_RMK                     -- Invoice Surcharge - Inv Remark" ).append("\n"); 
		query.append("              ,TRS_COMMON_PKG.TRS_GET_RHQ_OFC_CD(A.CRE_OFC_CD) RHQ_OFC_CD" ).append("\n"); 
		query.append("              ,A.CRE_OFC_CD AS SO_OFC_CD" ).append("\n"); 
		query.append("              ,(SELECT X.USR_NM FROM COM_USER X WHERE X.USR_ID = A.UPD_USR_ID) AS SO_USR_NM" ).append("\n"); 
		query.append("              ,WVDR.VNDR_SEQ     AS WO_VNDR_SEQ" ).append("\n"); 
		query.append("              ,WVDR.VNDR_ABBR_NM AS WO_VNDR_NM" ).append("\n"); 
		query.append("              ,IVDR.VNDR_SEQ     AS INV_VNDR_SEQ" ).append("\n"); 
		query.append("              ,IVDR.VNDR_ABBR_NM AS INV_VNDR_NM " ).append("\n"); 
		query.append("              ,(SELECT BKG.SC_NO" ).append("\n"); 
		query.append("                  FROM BKG_BOOKING BKG     " ).append("\n"); 
		query.append("                 WHERE BKG.BKG_NO = A.BKG_NO) SC_NO" ).append("\n"); 
		query.append("              ,(SELECT BKG.RFA_NO " ).append("\n"); 
		query.append("                  FROM BKG_BOOKING BKG     " ).append("\n"); 
		query.append("                 WHERE BKG.BKG_NO = A.BKG_NO) RFA_NO" ).append("\n"); 
		query.append("              ,(SELECT REPLACE (CUST_NM, CHR (13) || CHR (10),' ')" ).append("\n"); 
		query.append("                  FROM BKG_CUSTOMER CUST" ).append("\n"); 
		query.append("                 WHERE CUST.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("                   AND CUST.BKG_CUST_TP_CD = 'S' ) AS SHIPPER" ).append("\n"); 
		query.append("              ,(SELECT REPLACE (CUST_NM, CHR (13) || CHR (10),' ')" ).append("\n"); 
		query.append("                  FROM BKG_CUSTOMER CUST" ).append("\n"); 
		query.append("                 WHERE CUST.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("                   AND CUST.BKG_CUST_TP_CD = 'C' ) AS CONSIGNEE" ).append("\n"); 
		query.append("              ,A.LGS_COST_CD" ).append("\n"); 
		query.append("              ,(SELECT 'Y'" ).append("\n"); 
		query.append("                  FROM EAS_TRSP_COST_CHK X" ).append("\n"); 
		query.append("                 WHERE X.TRSP_SO_OFC_CTY_CD = A.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("                   AND X.TRSP_SO_SEQ        = A.TRSP_SO_SEQ" ).append("\n"); 
		query.append("                   AND X.EAC_SYS_IF_CD      = 'TR2'" ).append("\n"); 
		query.append("                   AND X.LGS_COST_CD        = A.LGS_COST_CD" ).append("\n"); 
		query.append("               ) EAC_IF_FLG" ).append("\n"); 
		query.append("              ,A.NEGO_RMK" ).append("\n"); 
		query.append("              ,A.SPCL_INSTR_RMK" ).append("\n"); 
		query.append("          FROM TRS_TRSP_SVC_ORD A  " ).append("\n"); 
		query.append("              ,TRS_TRSP_WRK_ORD C" ).append("\n"); 
		query.append("              ,TRS_TRSP_INV_WRK D" ).append("\n"); 
		query.append("              ,MDM_VENDOR WVDR" ).append("\n"); 
		query.append("              ,MDM_VENDOR IVDR" ).append("\n"); 
		query.append("         WHERE A.TRSP_WO_OFC_CTY_CD = C.TRSP_WO_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("           AND A.TRSP_WO_SEQ        = C.TRSP_WO_SEQ(+)" ).append("\n"); 
		query.append("           AND A.INV_NO             = D.INV_NO(+)" ).append("\n"); 
		query.append("           AND A.INV_VNDR_SEQ       = D.INV_VNDR_SEQ(+)" ).append("\n"); 
		query.append("           /*" ).append("\n"); 
		query.append("           AND WVDR.VNDR_SEQ = CASE WHEN A.HJL_NO IS NOT NULL THEN (SELECT X.HJL_VNDR_SEQ FROM TRS_TRSP_HJL_SVC_ORD X WHERE X.TRSP_SO_OFC_CTY_CD = A.TRSP_SO_OFC_CTY_CD AND X.TRSP_SO_SEQ = A.TRSP_SO_SEQ)" ).append("\n"); 
		query.append("                                    ELSE A.VNDR_SEQ" ).append("\n"); 
		query.append("                               END" ).append("\n"); 
		query.append("           AND IVDR.VNDR_SEQ = CASE WHEN A.HJL_NO IS NOT NULL THEN (SELECT X.HJL_INV_VNDR_SEQ FROM TRS_TRSP_HJL_SVC_ORD X WHERE X.TRSP_SO_OFC_CTY_CD = A.TRSP_SO_OFC_CTY_CD AND X.TRSP_SO_SEQ = A.TRSP_SO_SEQ)" ).append("\n"); 
		query.append("                                    ELSE A.INV_VNDR_SEQ" ).append("\n"); 
		query.append("                               END" ).append("\n"); 
		query.append("           */" ).append("\n"); 
		query.append("           AND WVDR.VNDR_SEQ = A.VNDR_SEQ" ).append("\n"); 
		query.append("           AND IVDR.VNDR_SEQ(+) = A.INV_VNDR_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("           #if (${s_ofc_tp_cd} == 'W' && ${s_dt_tp_cd} == 'W' && ${s_ofc_cd} == '')" ).append("\n"); 
		query.append("                AND C.CRE_OFC_CD IN (SELECT OFC_CD " ).append("\n"); 
		query.append("                                       FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("                                      WHERE DELT_FLG = 'N'" ).append("\n"); 
		query.append("                                    CONNECT BY NOCYCLE PRIOR OFC_CD = PRNT_OFC_CD" ).append("\n"); 
		query.append("                                      START WITH OFC_CD = @[s_rhq_ofc_cd]" ).append("\n"); 
		query.append("                                    )" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("           #if ((${s_ofc_tp_cd} == 'I' || ${s_dt_tp_cd} == 'I') && ${s_ofc_cd} == '')" ).append("\n"); 
		query.append("                AND 1=2" ).append("\n"); 
		query.append("           #end " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("           #if (${s_ofc_tp_cd} == 'W' && ${s_ofc_cd} != '')" ).append("\n"); 
		query.append("                AND C.CRE_OFC_CD = @[s_ofc_cd]" ).append("\n"); 
		query.append("           #elseif (${s_ofc_tp_cd} == 'I' && ${s_ofc_cd} != '')" ).append("\n"); 
		query.append("                AND D.CRE_OFC_CD = @[s_ofc_cd]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("           #if (${s_dt_tp_cd} == 'W')" ).append("\n"); 
		query.append("                AND C.LOCL_CRE_DT BETWEEN TO_DATE (REPLACE(@[s_fm_dt],'-',''), 'rrrrmmdd') AND TO_DATE (REPLACE(@[s_to_dt],'-',''), 'rrrrmmdd') + 0.999999 -- s_dt_tp_cd = 'W' 일 경우 (Work order Date)" ).append("\n"); 
		query.append("           #elseif (${s_dt_tp_cd} == 'I')" ).append("\n"); 
		query.append("                AND D.INV_CFM_DT BETWEEN TO_DATE (REPLACE(@[s_fm_dt],'-',''), 'rrrrmmdd') AND TO_DATE (REPLACE(@[s_to_dt],'-',''), 'rrrrmmdd') + 0.999999 -- s_dt_tp_cd = 'I' 일 경우 (Invoice Date)" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("           AND NVL(A.NEGO_AMT,0) <> 0" ).append("\n"); 
		query.append("           " ).append("\n"); 
		query.append("           #if (${s_trns_mod_cd} != '')" ).append("\n"); 
		query.append("                AND A.TRSP_CRR_MOD_CD = @[s_trns_mod_cd]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if($s_scg_cd.size() > 0) " ).append("\n"); 
		query.append("                AND (" ).append("\n"); 
		query.append("                    #foreach( ${key} in ${s_scg_cd})" ).append("\n"); 
		query.append("                        #if($velocityCount == 1)" ).append("\n"); 
		query.append("                              #if ($key == 'NE')" ).append("\n"); 
		query.append("                                'NE' = '$key'" ).append("\n"); 
		query.append("                            #else" ).append("\n"); 
		query.append("                                1=2" ).append("\n"); 
		query.append("                            #end" ).append("\n"); 
		query.append("                        #else" ).append("\n"); 
		query.append("                            #if ($key == 'NE')" ).append("\n"); 
		query.append("                                OR 'NE' = '$key'" ).append("\n"); 
		query.append("                            #else" ).append("\n"); 
		query.append("                                OR 1=2" ).append("\n"); 
		query.append("                            #end" ).append("\n"); 
		query.append("                        #end " ).append("\n"); 
		query.append("                    #end" ).append("\n"); 
		query.append("                   )" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("           #if (${s_cgo_tp_cd} != '')" ).append("\n"); 
		query.append("                AND A.CGO_TP_CD = @[s_cgo_tp_cd]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           " ).append("\n"); 
		query.append("           #if (${s_srch_opt_cd} == 'WP') " ).append("\n"); 
		query.append("                AND NVL(A.NEGO_AMT,0) > 0" ).append("\n"); 
		query.append("           #elseif (${s_srch_opt_cd} == 'WM')     " ).append("\n"); 
		query.append("                AND NVL(A.NEGO_AMT,0) < 0" ).append("\n"); 
		query.append("           #elseif (${s_srch_opt_cd} == 'WN')          " ).append("\n"); 
		query.append("                AND NVL(A.NEGO_AMT,0) <> 0" ).append("\n"); 
		query.append("           #elseif (${s_srch_opt_cd} == 'IP')                " ).append("\n"); 
		query.append("                AND 1=2" ).append("\n"); 
		query.append("           #elseif (${s_srch_opt_cd} == 'IM')                " ).append("\n"); 
		query.append("                AND 1=2" ).append("\n"); 
		query.append("           #elseif (${s_srch_opt_cd} == 'IN')" ).append("\n"); 
		query.append("                AND 1=2" ).append("\n"); 
		query.append("           #elseif (${s_srch_opt_cd} == 'NR')" ).append("\n"); 
		query.append("               #if (${s_ofc_tp_cd} == 'W')" ).append("\n"); 
		query.append("                   AND ( TRIM(A.SPCL_INSTR_RMK) IS NULL AND TRIM(A.INTER_RMK) IS NULL AND TRIM(A.NEGO_RMK) IS NULL)" ).append("\n"); 
		query.append("               #elseif (${s_ofc_tp_cd} == 'I')" ).append("\n"); 
		query.append("                   AND ( TRIM(A.INV_RMK) IS NULL )" ).append("\n"); 
		query.append("               #end" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append(") AA" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("    #if (${s_eac_if} != '')" ).append("\n"); 
		query.append("        #if (${s_eac_if} == 'Y')" ).append("\n"); 
		query.append("           AND EAC_IF_FLG = @[s_eac_if]" ).append("\n"); 
		query.append("        #else" ).append("\n"); 
		query.append("           AND EAC_IF_FLG IS NULL" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("    #end" ).append("\n"); 

	}
}