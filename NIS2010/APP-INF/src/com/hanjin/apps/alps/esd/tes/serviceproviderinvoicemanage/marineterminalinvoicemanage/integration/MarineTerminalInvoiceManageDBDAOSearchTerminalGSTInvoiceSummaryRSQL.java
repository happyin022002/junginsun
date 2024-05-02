/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : MarineTerminalInvoiceManageDBDAOSearchTerminalGSTInvoiceSummaryRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.11.07
*@LastModifier : 
*@LastVersion : 1.0
* 2017.11.07 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MarineTerminalInvoiceManageDBDAOSearchTerminalGSTInvoiceSummaryRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchTerminalGSTInvoiceSummary
	  * </pre>
	  */
	public MarineTerminalInvoiceManageDBDAOSearchTerminalGSTInvoiceSummaryRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_prd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_prd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_inv_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("csr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_inv_rjct_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.integration").append("\n"); 
		query.append("FileName : MarineTerminalInvoiceManageDBDAOSearchTerminalGSTInvoiceSummaryRSQL").append("\n"); 
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
		query.append("    IDA_SAC_CD," ).append("\n"); 
		query.append("    IDA_SAC_NM," ).append("\n"); 
		query.append("    IDA_PAY_TP_CD," ).append("\n"); 
		query.append("    INV_NO, " ).append("\n"); 
		query.append("    FILE_CHK, " ).append("\n"); 
		query.append("	VVD," ).append("\n"); 
		query.append("    TML_SO_OFC_CTY_CD," ).append("\n"); 
		query.append("    TML_SO_SEQ," ).append("\n"); 
		query.append("    INV_TP_CD," ).append("\n"); 
		query.append("    TML_INV_TP_CD," ).append("\n"); 
		query.append("    TML_INV_STS_CD," ).append("\n"); 
		query.append("    TML_INV_RJCT_STS_CD," ).append("\n"); 
		query.append("    LOCL_CRE_DT," ).append("\n"); 
		query.append("    INV_OFC_CD," ).append("\n"); 
		query.append("    INV_OFC_DEL_FLG," ).append("\n"); 
		query.append("	COST_OFC_CD," ).append("\n"); 
		query.append("    COST_OFC_DEL_FLG," ).append("\n"); 
		query.append("    YD_CD," ).append("\n"); 
		query.append("    YD_DEL_FLG," ).append("\n"); 
		query.append("    CURR_CD," ).append("\n"); 
		query.append("    ISS_DT," ).append("\n"); 
		query.append("    RCV_DT," ).append("\n"); 
		query.append("    HLD_FLG," ).append("\n"); 
		query.append("    VNDR_SEQ," ).append("\n"); 
		query.append("    VNDR_DEL_FLG, " ).append("\n"); 
		query.append("    SUM(INV_AMT) INV_AMT," ).append("\n"); 
		query.append("	NVL(SUM(INV_AMT), 0) + NVL(SUM(IDA_GST_AMT), 0) TOTAL_AMT," ).append("\n"); 
		query.append("	DELT_FLG," ).append("\n"); 
		query.append("    CSR_NO," ).append("\n"); 
		query.append("    CSR_STATUS," ).append("\n"); 
		query.append("    IDA_CGST_RTO," ).append("\n"); 
		query.append("    SUM(IDA_CGST_AMT) IDA_CGST_AMT," ).append("\n"); 
		query.append("    IDA_SGST_RTO," ).append("\n"); 
		query.append("    SUM(IDA_SGST_AMT) IDA_SGST_AMT," ).append("\n"); 
		query.append("    IDA_IGST_RTO," ).append("\n"); 
		query.append("    SUM(IDA_IGST_AMT) IDA_IGST_AMT," ).append("\n"); 
		query.append("    IDA_UGST_RTO," ).append("\n"); 
		query.append("    SUM(IDA_UGST_AMT) IDA_UGST_AMT," ).append("\n"); 
		query.append("    IDA_GST_RTO," ).append("\n"); 
		query.append("    SUM(IDA_GST_AMT) IDA_GST_AMT," ).append("\n"); 
		query.append("    VNDR_GST_NO," ).append("\n"); 
		query.append("    VNDR_STE_CD," ).append("\n"); 
		query.append("    CST_OFC_GST_NO," ).append("\n"); 
		query.append("    CST_OFC_STE_CD," ).append("\n"); 
		query.append("    VNDR_LGL_ENG_NM," ).append("\n"); 
		query.append("    AP_RVS_CNG_FLG," ).append("\n"); 
		query.append("	CRE_DT," ).append("\n"); 
		query.append("	INV_CFM_DT," ).append("\n"); 
		query.append("	CRE_USR_ID" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT  	/*+ FIRST_ROWS */ H.INV_NO,  " ).append("\n"); 
		query.append("		  NVL(" ).append("\n"); 
		query.append("          CASE" ).append("\n"); 
		query.append("          WHEN H.EDI_FLG = 'Y'" ).append("\n"); 
		query.append("          THEN  (" ).append("\n"); 
		query.append("                SELECT " ).append("\n"); 
		query.append("                    CASE" ).append("\n"); 
		query.append("                    WHEN F.FILE_SEQ IS NOT NULL AND F.ORG_FILE_NM IS NOT NULL AND F.FILE_SAV_ID IS NOT NULL AND C.FILE_SAV_ID IS NOT NULL" ).append("\n"); 
		query.append("                    THEN 'Y'" ).append("\n"); 
		query.append("                    ELSE 'N'" ).append("\n"); 
		query.append("                    END FILE_CHK" ).append("\n"); 
		query.append("                FROM TES_EDI_SO_HDR E, TES_EDI_SO_FILE F, COM_UPLD_FILE C" ).append("\n"); 
		query.append("                WHERE 1=1" ).append("\n"); 
		query.append("                AND E.TML_SO_OFC_CTY_CD = H.TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("                AND E.TML_SO_SEQ = H.TML_SO_SEQ" ).append("\n"); 
		query.append("                AND NVL(E.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("                AND ((E.TML_EDI_SO_OFC_CTY_CD = F.TML_EDI_SO_OFC_CTY_CD AND E.TML_EDI_SO_SEQ = F.TML_EDI_SO_SEQ)" ).append("\n"); 
		query.append("					OR" ).append("\n"); 
		query.append("					 (E.TML_SO_OFC_CTY_CD = F.TML_SO_OFC_CTY_CD AND E.TML_SO_SEQ = F.TML_SO_SEQ))" ).append("\n"); 
		query.append("                AND NVL(F.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("                AND F.FILE_SAV_ID = C.FILE_SAV_ID" ).append("\n"); 
		query.append("                AND NVL(C.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("				AND ROWNUM = 1" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("          ELSE 'N'" ).append("\n"); 
		query.append("          END,'N') FILE_CHK, " ).append("\n"); 
		query.append("           CASE" ).append("\n"); 
		query.append("           WHEN H.TML_INV_TP_CD IN ('TM')" ).append("\n"); 
		query.append("           THEN TES_GET_VVD_LIST_FNC(H.TML_SO_OFC_CTY_CD,H.TML_SO_SEQ,'N')" ).append("\n"); 
		query.append("           ELSE ''" ).append("\n"); 
		query.append("           END VVD," ).append("\n"); 
		query.append("			H.TML_SO_OFC_CTY_CD, " ).append("\n"); 
		query.append("			H.TML_SO_SEQ, " ).append("\n"); 
		query.append("			DECODE(H.TML_INV_TP_CD,'TM','MR','ON','RC','OF','OC','ST','MS') INV_TP_CD, " ).append("\n"); 
		query.append("			H.TML_INV_TP_CD, " ).append("\n"); 
		query.append("			DECODE(H.TML_INV_STS_CD,'R','RC','C','CF','A','AR','P','AP','D','PD') TML_INV_STS_CD, " ).append("\n"); 
		query.append("			H.TML_INV_RJCT_STS_CD, " ).append("\n"); 
		query.append("--		/** ALPS에서 LOCL_CRE_DT를 운영할 때까지만 CRE_DT를 LOCAL시간으로 임의 설정 한다. **/" ).append("\n"); 
		query.append(" 			TO_CHAR(H.LOCL_CRE_DT,'YYYYMMDDHH24MISS') LOCL_CRE_DT," ).append("\n"); 
		query.append("		 	H.INV_OFC_CD, " ).append("\n"); 
		query.append("			(SELECT DELT_FLG FROM MDM_ORGANIZATION WHERE OFC_CD = H.INV_OFC_CD)  INV_OFC_DEL_FLG," ).append("\n"); 
		query.append("            H.COST_OFC_CD," ).append("\n"); 
		query.append("			(SELECT DELT_FLG FROM MDM_ORGANIZATION WHERE OFC_CD = H.COST_OFC_CD) COST_OFC_DEL_FLG," ).append("\n"); 
		query.append("			H.YD_CD," ).append("\n"); 
		query.append("			(SELECT DELT_FLG FROM MDM_YARD WHERE YD_CD = H.YD_CD)		YD_DEL_FLG," ).append("\n"); 
		query.append("			H.CURR_CD, " ).append("\n"); 
		query.append("			TO_CHAR(H.ISS_DT,'YYYYMMDD')		ISS_DT, " ).append("\n"); 
		query.append("			TO_CHAR(H.RCV_DT,'YYYYMMDD')		RCV_DT, " ).append("\n"); 
		query.append("			NVL(H.HLD_FLG,'N') HLD_FLG, " ).append("\n"); 
		query.append("			LPAD(H.VNDR_SEQ, 6, '0') 	VNDR_SEQ," ).append("\n"); 
		query.append("			(SELECT DELT_FLG FROM MDM_VENDOR WHERE VNDR_SEQ = H.VNDR_SEQ)	VNDR_DEL_FLG," ).append("\n"); 
		query.append("			D.INV_AMT," ).append("\n"); 
		query.append("            H.DELT_FLG," ).append("\n"); 
		query.append("			H.CSR_NO, " ).append("\n"); 
		query.append("			-- CHM-201537728 Invoice Summary화면에서 CSR I/F Status 미반영 로직 수정 요청 (조아영D 2015-08-28)" ).append("\n"); 
		query.append("			CASE" ).append("\n"); 
		query.append("				WHEN A.AFT_ACT_FLG = 'X' OR A.AFT_ACT_FLG = 'N' THEN 'Canceled'" ).append("\n"); 
		query.append("				WHEN A.RCV_ERR_FLG = 'E' THEN 'Rejected'" ).append("\n"); 
		query.append("				WHEN A.IF_FLG = 'E' THEN 'I/F Error'" ).append("\n"); 
		query.append("				WHEN A.IF_FLG = 'Y' AND A.RCV_ERR_FLG IS NULL THEN 'I/F Success'" ).append("\n"); 
		query.append("				WHEN H.TML_INV_STS_CD = 'R' THEN 'Processing'" ).append("\n"); 
		query.append("				WHEN H.TML_INV_STS_CD = 'C' AND A.IF_FLG IS NULL THEN 'Processing'" ).append("\n"); 
		query.append("				WHEN H.TML_INV_RJCT_STS_CD = 'RJ' AND A.AFT_ACT_FLG IS NULL THEN 'Disapproved'" ).append("\n"); 
		query.append("				WHEN A.IF_FLG IS NULL AND A.APRO_FLG = 'N' AND A.RQST_APRO_STEP_FLG = 'Y' THEN 'Requesting Approval'" ).append("\n"); 
		query.append("				WHEN A.IF_FLG IS NULL AND A.APRO_FLG <> 'Y' THEN 'Approval Requested'" ).append("\n"); 
		query.append("				ELSE 'ALL'" ).append("\n"); 
		query.append("			END CSR_STATUS, " ).append("\n"); 
		query.append("            D.IDA_CGST_RTO," ).append("\n"); 
		query.append("            D.IDA_CGST_AMT," ).append("\n"); 
		query.append("            D.IDA_SGST_RTO," ).append("\n"); 
		query.append("            D.IDA_SGST_AMT," ).append("\n"); 
		query.append("            D.IDA_IGST_RTO," ).append("\n"); 
		query.append("            D.IDA_IGST_AMT," ).append("\n"); 
		query.append("            D.IDA_UGST_RTO," ).append("\n"); 
		query.append("            D.IDA_UGST_AMT," ).append("\n"); 
		query.append("            D.IDA_GST_RTO," ).append("\n"); 
		query.append("            D.IDA_GST_AMT," ).append("\n"); 
		query.append("            D.IDA_SAC_CD," ).append("\n"); 
		query.append("            (SELECT IDA_SAC_NM FROM BKG_IDA_SAC_MST B WHERE B.IDA_SAC_CD = D.IDA_SAC_CD AND B.DELT_FLG='N' AND ROWNUM = 1) IDA_SAC_NM," ).append("\n"); 
		query.append("            D.IDA_PAY_TP_CD," ).append("\n"); 
		query.append("                (SELECT IDA_GST_RGST_NO FROM MDM_VENDOR MV WHERE MV.DELT_FLG = 'N' AND MV.VNDR_SEQ = H.VNDR_SEQ) AS VNDR_GST_NO," ).append("\n"); 
		query.append("                (SELECT MS.IDA_STE_CD " ).append("\n"); 
		query.append("                FROM MDM_VENDOR MV, MDM_LOCATION ML, MDM_STATE MS" ).append("\n"); 
		query.append("                WHERE MV.LOC_CD = ML.LOC_CD" ).append("\n"); 
		query.append("                AND MS.CNT_CD = MV.VNDR_CNT_CD" ).append("\n"); 
		query.append("                AND MS.STE_CD = ML.STE_CD" ).append("\n"); 
		query.append("                AND	MV.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                AND MV.VNDR_SEQ = H.VNDR_SEQ) AS VNDR_STE_CD," ).append("\n"); 
		query.append("                (SELECT Q.IDA_GST_RGST_NO" ).append("\n"); 
		query.append("                    FROM MDM_ORGANIZATION P," ).append("\n"); 
		query.append("                         MDM_CUSTOMER Q" ).append("\n"); 
		query.append("                    WHERE P.OFC_CD = H.COST_OFC_CD" ).append("\n"); 
		query.append("                    AND P.REP_CUST_CNT_CD = Q.CUST_CNT_CD" ).append("\n"); 
		query.append("                    AND P.REP_CUST_SEQ = Q.CUST_SEQ)        AS CST_OFC_GST_NO," ).append("\n"); 
		query.append("                (SELECT   R.IDA_STE_CD " ).append("\n"); 
		query.append("                    FROM     MDM_ORGANIZATION P " ).append("\n"); 
		query.append("                           , MDM_LOCATION Q " ).append("\n"); 
		query.append("                           , MDM_STATE R" ).append("\n"); 
		query.append("                    WHERE    P.LOC_CD = Q.LOC_CD " ).append("\n"); 
		query.append("                    AND      Q.CNT_CD = R.CNT_CD " ).append("\n"); 
		query.append("                    AND      Q.STE_CD = R.STE_CD " ).append("\n"); 
		query.append("                    AND      P.OFC_CD = H.COST_OFC_CD)   AS CST_OFC_STE_CD," ).append("\n"); 
		query.append("                 (SELECT VNDR_LGL_ENG_NM FROM MDM_VENDOR WHERE VNDR_SEQ = H.VNDR_SEQ) AS VNDR_LGL_ENG_NM," ).append("\n"); 
		query.append("           	NVL(H.AP_RVS_CNG_FLG, 'N') AP_RVS_CNG_FLG," ).append("\n"); 
		query.append("			TO_CHAR(H.INV_CFM_DT, 'YYYYMMDD') AS INV_CFM_DT,				-- INVOICE CONFIRMED DATE" ).append("\n"); 
		query.append("			H.CRE_USR_ID," ).append("\n"); 
		query.append("			TO_CHAR(H.CRE_DT,'YYYYMMDD')		CRE_DT" ).append("\n"); 
		query.append("FROM 		TES_TML_SO_HDR H, AP_INV_HDR A, TES_TML_SO_DTL D--// CHM-201537539 Invoice IF Inquiry에서 조건 명칭 추가삭제변경 (조아영D 2015-08-25)" ).append("\n"); 
		query.append("			, COM_APRO_CSR_DTL C, COM_APRO_RQST_HDR R" ).append("\n"); 
		query.append("WHERE 		NVL(H.DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("AND		H.CSR_NO = A.CSR_NO(+)" ).append("\n"); 
		query.append("AND     H.TML_SO_OFC_CTY_CD = D.TML_SO_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("AND     H.TML_SO_SEQ = D.TML_SO_SEQ(+)" ).append("\n"); 
		query.append("--// CHM-201537539 Invoice IF Inquiry에서 조건 명칭 추가삭제변경 (조아영D 2015-08-25)" ).append("\n"); 
		query.append("AND		H.CSR_NO		= C.CSR_NO(+)" ).append("\n"); 
		query.append("AND		C.APRO_RQST_NO	= R.APRO_RQST_NO(+)" ).append("\n"); 
		query.append("AND  'Y' = (SELECT DECODE(COUNT(OFC_CD),0,'N','Y') IDA_OFC_CD FROM MDM_ORGANIZATION A, MDM_LOCATION B WHERE A.LOC_CD = B.LOC_CD" ).append("\n"); 
		query.append("   AND B.CNT_CD = 'IN'" ).append("\n"); 
		query.append("   AND A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("   AND B.DELT_FLG = 'N'" ).append("\n"); 
		query.append("   AND (A.OFC_CD = H.INV_OFC_CD OR A.OFC_CD = H.COST_OFC_CD))" ).append("\n"); 
		query.append("--// CHM-201537539 Invoice IF Inquiry에서 조건 명칭 추가삭제변경 (조아영D 2015-08-25)" ).append("\n"); 
		query.append("#if (${inv_date_type} == 'I') 	-- ISSUED DATE" ).append("\n"); 
		query.append("AND		H.ISS_DT BETWEEN TO_DATE(@[fm_prd_dt],'YYYY-MM-DD') AND TO_DATE(@[to_prd_dt],'YYYY-MM-DD')+0.99999" ).append("\n"); 
		query.append("#elseif (${inv_date_type} == 'R')	-- RECEIVED DATE" ).append("\n"); 
		query.append("AND		H.RCV_DT BETWEEN TO_DATE(@[fm_prd_dt],'YYYY-MM-DD') AND TO_DATE(@[to_prd_dt],'YYYY-MM-DD')+0.99999" ).append("\n"); 
		query.append("#elseif (${inv_date_type} == 'P')	-- INVOICE UPDATE DATE" ).append("\n"); 
		query.append("AND		H.LOCL_UPD_DT BETWEEN TO_DATE(@[fm_prd_dt],'YYYY-MM-DD') AND TO_DATE(@[to_prd_dt],'YYYY-MM-DD')+0.99999" ).append("\n"); 
		query.append("#elseif (${inv_date_type} == 'C')	-- CONFIRMED DATE" ).append("\n"); 
		query.append("AND		H.INV_CFM_DT BETWEEN TO_DATE(@[fm_prd_dt],'YYYY-MM-DD') AND TO_DATE(@[to_prd_dt],'YYYY-MM-DD')+0.99999" ).append("\n"); 
		query.append("#elseif (${inv_date_type} == 'A')	-- ARRROVAL REQUESTED DATE" ).append("\n"); 
		query.append("AND		( (R.RQST_ST_DT BETWEEN TO_DATE(@[fm_prd_dt], 'YYYY-MM-DD') AND TO_DATE(@[to_prd_dt], 'YYYY-MM-DD') + 0.99999 )" ).append("\n"); 
		query.append("OR		( A.CSR_APRO_STEP_ASGN_DT BETWEEN TO_DATE(@[fm_prd_dt], 'YYYY-MM-DD') AND TO_DATE(@[to_prd_dt], 'YYYY-MM-DD') + 0.99999 ) )" ).append("\n"); 
		query.append("#elseif (${inv_date_type} == 'U')	-- I/F STATUS UPDATED" ).append("\n"); 
		query.append("AND		A.IF_DT BETWEEN TO_DATE(@[fm_prd_dt], 'YYYY-MM-DD') AND TO_DATE(@[to_prd_dt], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${yd_cd} != '') " ).append("\n"); 
		query.append("and	h.yd_cd	 =	@[yd_cd]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${inv_no} != '') " ).append("\n"); 
		query.append("and	h.inv_no	like	'%'||@[inv_no]||'%'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/**2013.02.26 log-in office가 HAMUOG, SELCOT에서만 조회되도록 하드코딩 추가...1년 후 삭제 예정 FDRCIV201301 ~ FDRCIV201312 **/" ).append("\n"); 
		query.append("/**2013.06.03 log-in office가 HAMUOG, SELCOT에서만 조회되도록 하드코딩 추가...1년 후 삭제 예정..Rebate Invoice 처리 : 2012년 8월 ~ 2013년 12월..APP201208 ~ APP201312 **/" ).append("\n"); 
		query.append("/**2013.06.03 log-in office가 HAMUOG, SELCOT에서만 조회되도록 하드코딩 추가...2014년 용..APP201401, APP201402, APP201403 **/" ).append("\n"); 
		query.append("#if (${cre_ofc_cd} != 'HAMSEL') " ).append("\n"); 
		query.append("and	h.inv_no NOT IN ('FDRCIV201301','FDRCIV201302','FDRCIV201303','FDRCIV201304','FDRCIV201305','FDRCIV201306','FDRCIV201307','FDRCIV201308','FDRCIV201309','FDRCIV201310','FDRCIV201311','FDRCIV201312'," ).append("\n"); 
		query.append("					 'APP201208','APP201209','APP201210','APP201211','APP201212','APP201301','APP201302','APP201303','APP201304','APP201305','APP201306','APP201307','APP201308','APP201309','APP201310','APP201311','APP201312'," ).append("\n"); 
		query.append("					 'APP201401','APP201402','APP201403'" ).append("\n"); 
		query.append("					 ,'BEST201401Q','BEST201402Q','BEST201403Q','BEST201404Q','BEST201501Q','BEST201502Q','BEST201503Q','BEST201504Q' --// 2014-06-18 추가" ).append("\n"); 
		query.append("					 ,'UOM201406-001' --// 2014-07-08 추가" ).append("\n"); 
		query.append("					 )" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${vndr_seq} != '') " ).append("\n"); 
		query.append("and	h.vndr_seq	=	@[vndr_seq]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${cost_ofc_cd} != '')" ).append("\n"); 
		query.append("	#if($sub_ofc_cd1.size() > 0)" ).append("\n"); 
		query.append("		AND     h.cost_ofc_cd IN (" ).append("\n"); 
		query.append("	#foreach($sub_ofc_cd1_num IN ${sub_ofc_cd1})" ).append("\n"); 
		query.append("		#if($velocityCount < $sub_ofc_cd1.size()) " ).append("\n"); 
		query.append("			'$sub_ofc_cd1_num', " ).append("\n"); 
		query.append("		#else " ).append("\n"); 
		query.append("			'$sub_ofc_cd1_num' " ).append("\n"); 
		query.append("		#end " ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("		AND		h.cost_ofc_cd = @[cost_ofc_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${inv_ofc_cd} != '')" ).append("\n"); 
		query.append("	#if($sub_ofc_cd2.size() > 0)" ).append("\n"); 
		query.append("		AND     h.inv_ofc_cd IN (" ).append("\n"); 
		query.append("	#foreach($sub_ofc_cd2_num IN ${sub_ofc_cd2})" ).append("\n"); 
		query.append("		#if($velocityCount < $sub_ofc_cd2.size()) " ).append("\n"); 
		query.append("			'$sub_ofc_cd2_num', " ).append("\n"); 
		query.append("		#else " ).append("\n"); 
		query.append("			'$sub_ofc_cd2_num' " ).append("\n"); 
		query.append("		#end " ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("		AND		h.inv_ofc_cd = @[inv_ofc_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${tml_inv_sts_cd} != '') " ).append("\n"); 
		query.append("and	h.tml_inv_sts_cd	=	@[tml_inv_sts_cd]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("and	h.tml_inv_sts_cd in ('R','C','A','P','D')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${csr_no} != '') " ).append("\n"); 
		query.append("and	h.csr_no like	'%'||@[csr_no]||'%'	" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${tml_inv_rjct_sts_cd} != '') " ).append("\n"); 
		query.append("and	h.tml_inv_rjct_sts_cd = @[tml_inv_rjct_sts_cd]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("and	h.tml_inv_rjct_sts_cd in ('NL','RJ','RL')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${csr_status} == 'AR') " ).append("\n"); 
		query.append("AND	A.IF_FLG IS NULL" ).append("\n"); 
		query.append("AND	H.CSR_NO IS NOT NULL" ).append("\n"); 
		query.append("#elseif (${csr_status} == 'PC') " ).append("\n"); 
		query.append("AND	( H.TML_INV_STS_CD = 'R' OR (H.TML_INV_STS_CD = 'C' AND A.IF_FLG IS NULL) )" ).append("\n"); 
		query.append("#elseif (${csr_status} == 'IE') " ).append("\n"); 
		query.append("AND	A.IF_FLG = 'E'" ).append("\n"); 
		query.append("#elseif (${csr_status} == 'RJ') " ).append("\n"); 
		query.append("AND	A.RCV_ERR_FLG = 'E'" ).append("\n"); 
		query.append("#elseif (${csr_status} == 'SC') " ).append("\n"); 
		query.append("AND	A.IF_FLG = 'Y'	AND A.RCV_ERR_FLG IS NULL" ).append("\n"); 
		query.append("#elseif (${csr_status} == 'DA') " ).append("\n"); 
		query.append("AND	 H.TML_INV_STS_CD = 'A' AND H.TML_INV_RJCT_STS_CD = 'RJ'" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${hld_flg} == 'Y') -- [CHM-201538036]Hold 검색조건 추가 (조아영D 2015.09.23)" ).append("\n"); 
		query.append("AND NVL(H.HLD_FLG,'N') = 'Y'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("GROUP BY " ).append("\n"); 
		query.append("    IDA_SAC_CD," ).append("\n"); 
		query.append("    IDA_SAC_NM," ).append("\n"); 
		query.append("    IDA_PAY_TP_CD," ).append("\n"); 
		query.append("    INV_NO, " ).append("\n"); 
		query.append("    FILE_CHK," ).append("\n"); 
		query.append("	VVD, " ).append("\n"); 
		query.append("    TML_SO_OFC_CTY_CD," ).append("\n"); 
		query.append("    TML_SO_SEQ," ).append("\n"); 
		query.append("    INV_TP_CD," ).append("\n"); 
		query.append("    TML_INV_TP_CD," ).append("\n"); 
		query.append("    TML_INV_STS_CD," ).append("\n"); 
		query.append("    TML_INV_RJCT_STS_CD," ).append("\n"); 
		query.append("    LOCL_CRE_DT," ).append("\n"); 
		query.append("    INV_OFC_CD," ).append("\n"); 
		query.append("    INV_OFC_DEL_FLG," ).append("\n"); 
		query.append("	COST_OFC_CD," ).append("\n"); 
		query.append("    COST_OFC_DEL_FLG," ).append("\n"); 
		query.append("    YD_CD," ).append("\n"); 
		query.append("    YD_DEL_FLG," ).append("\n"); 
		query.append("    CURR_CD," ).append("\n"); 
		query.append("    ISS_DT," ).append("\n"); 
		query.append("    RCV_DT," ).append("\n"); 
		query.append("    HLD_FLG," ).append("\n"); 
		query.append("    VNDR_SEQ," ).append("\n"); 
		query.append("    VNDR_DEL_FLG, " ).append("\n"); 
		query.append("	DELT_FLG," ).append("\n"); 
		query.append("    CSR_NO," ).append("\n"); 
		query.append("    CSR_STATUS," ).append("\n"); 
		query.append("    VNDR_GST_NO," ).append("\n"); 
		query.append("    VNDR_STE_CD," ).append("\n"); 
		query.append("    CST_OFC_GST_NO," ).append("\n"); 
		query.append("    CST_OFC_STE_CD," ).append("\n"); 
		query.append("    VNDR_LGL_ENG_NM," ).append("\n"); 
		query.append("    IDA_GST_RTO," ).append("\n"); 
		query.append("    IDA_CGST_RTO," ).append("\n"); 
		query.append("    IDA_SGST_RTO," ).append("\n"); 
		query.append("    IDA_IGST_RTO," ).append("\n"); 
		query.append("    IDA_UGST_RTO," ).append("\n"); 
		query.append("    AP_RVS_CNG_FLG," ).append("\n"); 
		query.append("    CRE_DT," ).append("\n"); 
		query.append("	INV_CFM_DT," ).append("\n"); 
		query.append("	CRE_USR_ID" ).append("\n"); 

	}
}