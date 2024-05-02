/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : InvoiceInquiryCorrectionDBDAOSearchInvoiceInquiryIdaListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.11.29
*@LastModifier : 
*@LastVersion : 1.0
* 2017.11.29 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.invoicemanage.invoiceinquirycorrection.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceInquiryCorrectionDBDAOSearchInvoiceInquiryIdaListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Invoice Inquiry Ida
	  * </pre>
	  */
	public InvoiceInquiryCorrectionDBDAOSearchInvoiceInquiryIdaListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("todate",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fmdate",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.invoicemanage.invoiceinquirycorrection.integration").append("\n"); 
		query.append("FileName : InvoiceInquiryCorrectionDBDAOSearchInvoiceInquiryIdaListRSQL").append("\n"); 
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
		query.append("SELECT INV.CRE_OFC_CD AS INV_OFC_CD," ).append("\n"); 
		query.append("       INV.COST_OFC_CD," ).append("\n"); 
		query.append("       (SELECT Q.IDA_GST_RGST_NO" ).append("\n"); 
		query.append("          FROM MDM_ORGANIZATION P, MDM_CUSTOMER Q" ).append("\n"); 
		query.append("         WHERE     P.OFC_CD = INV.COST_OFC_CD" ).append("\n"); 
		query.append("               AND P.REP_CUST_CNT_CD = Q.CUST_CNT_CD" ).append("\n"); 
		query.append("               AND P.REP_CUST_SEQ = Q.CUST_SEQ) AS CST_OFC_GST_NO," ).append("\n"); 
		query.append("       (SELECT R.IDA_STE_CD" ).append("\n"); 
		query.append("          FROM MDM_ORGANIZATION P, MDM_LOCATION Q, MDM_STATE R" ).append("\n"); 
		query.append("         WHERE     P.LOC_CD = Q.LOC_CD" ).append("\n"); 
		query.append("               AND Q.CNT_CD = R.CNT_CD" ).append("\n"); 
		query.append("               AND Q.STE_CD = R.STE_CD" ).append("\n"); 
		query.append("               AND P.OFC_CD = INV.COST_OFC_CD) AS CST_OFC_STE_CD," ).append("\n"); 
		query.append("       (SELECT IDA_GST_RGST_NO" ).append("\n"); 
		query.append("          FROM MDM_VENDOR MV" ).append("\n"); 
		query.append("         WHERE MV.DELT_FLG = 'N' AND MV.VNDR_SEQ = INV.INV_VNDR_SEQ) AS VNDR_GST_NO," ).append("\n"); 
		query.append("       (SELECT MS.IDA_STE_CD" ).append("\n"); 
		query.append("          FROM MDM_VENDOR MV, MDM_LOCATION ML, MDM_STATE MS" ).append("\n"); 
		query.append("         WHERE     MV.LOC_CD = ML.LOC_CD" ).append("\n"); 
		query.append("               AND MS.CNT_CD = MV.VNDR_CNT_CD" ).append("\n"); 
		query.append("               AND MS.STE_CD = ML.STE_CD" ).append("\n"); 
		query.append("               AND MV.DELT_FLG = 'N'" ).append("\n"); 
		query.append("               AND MV.VNDR_SEQ = INV.INV_VNDR_SEQ) AS VNDR_STE_CD," ).append("\n"); 
		query.append("       LPAD (TO_CHAR (INV.INV_VNDR_SEQ), 6, '0') AS INV_VNDR_SEQ," ).append("\n"); 
		query.append("       MAX (VNDR.VNDR_LGL_ENG_NM) AS INV_VNDR_NM," ).append("\n"); 
		query.append("       INV.INV_NO," ).append("\n"); 
		query.append("       COMMCODE_PKG.GET_COMDTL_NAME_FNC ('CD00914', INV.IF_SYS_KND_CD) AS IF_SYS_KND_NM," ).append("\n"); 
		query.append("       COMMCODE_PKG.GET_COMDTL_NAME_FNC ('CD00824', INV.TRSP_INV_AUD_STS_CD) AS TRSP_INV_AUD_STS_NM," ).append("\n"); 
		query.append("       SO.CURR_CD," ).append("\n"); 
		query.append("       SUM (NVL (SO.BZC_AMT, 0) + NVL (SO.ETC_ADD_AMT, 0) + NVL (SO.FUEL_SCG_AMT, 0) + NVL (SO.SCG_VAT_AMT, 0) + NVL (SO.NEGO_AMT, 0) + NVL (SO.TOLL_FEE_AMT, 0)) AS WO_TOT_AMT," ).append("\n"); 
		query.append("       SO.INV_XCH_RT," ).append("\n"); 
		query.append("       COMMCODE_PKG.GET_COMDTL_NAME_FNC ('CD00874', SO.TRSP_INV_CALC_LGC_TP_CD) AS TRSP_INV_CALC_LGC_TP_NM," ).append("\n"); 
		query.append("       TO_CHAR (INV.INV_ISS_DT, 'YYYYMMDD') INV_ISS_DT," ).append("\n"); 
		query.append("       TO_CHAR (INV.INV_RCV_DT, 'YYYYMMDD') INV_RCV_DT," ).append("\n"); 
		query.append("       TO_CHAR (INV.PAY_DT, 'YYYYMMDD') PAY_DT," ).append("\n"); 
		query.append("       INV.GL_DT," ).append("\n"); 
		query.append("       TO_CHAR (INV.UPD_DT, 'YYYYMMDD') UPD_DT," ).append("\n"); 
		query.append("       TO_CHAR (INV.INV_CFM_DT, 'YYYYMMDD') INV_CFM_DT," ).append("\n"); 
		query.append("       INV.CSR_NO," ).append("\n"); 
		query.append("       IDA.IDA_SAC_CD," ).append("\n"); 
		query.append("       (SELECT IDA_SAC_NM" ).append("\n"); 
		query.append("          FROM BKG_IDA_SAC_MST B" ).append("\n"); 
		query.append("         WHERE     B.IDA_SAC_CD = IDA.IDA_SAC_CD" ).append("\n"); 
		query.append("               AND B.DELT_FLG = 'N'" ).append("\n"); 
		query.append("               AND ROWNUM = 1) AS IDA_SAC_NM," ).append("\n"); 
		query.append("       DECODE (IDA.IDA_PAY_TP_CD,  'S', 'Services',  'G', 'Goods',  '') AS IDA_PAY_TP_CD," ).append("\n"); 
		query.append("       NVL (INV.AP_RVS_CNG_FLG, 'N') AS AP_RVS_CNG_FLG," ).append("\n"); 
		query.append("       NVL (INV.INV_HLD_FLG, 'N') AS INV_HLD_FLG," ).append("\n"); 
		query.append("       INV.INV_CURR_CD," ).append("\n"); 
		query.append("       INV.INV_BZC_AMT," ).append("\n"); 
		query.append("       IDA.IDA_CGST_RTO," ).append("\n"); 
		query.append("       SUM (IDA.IDA_CGST_AMT) AS IDA_CGST_AMT," ).append("\n"); 
		query.append("       IDA.IDA_SGST_RTO," ).append("\n"); 
		query.append("       SUM (IDA.IDA_SGST_AMT) AS IDA_SGST_AMT," ).append("\n"); 
		query.append("       IDA.IDA_IGST_RTO," ).append("\n"); 
		query.append("       SUM (IDA.IDA_IGST_AMT) AS IDA_IGST_AMT," ).append("\n"); 
		query.append("       IDA.IDA_UGST_RTO," ).append("\n"); 
		query.append("       SUM (IDA.IDA_UGST_AMT) AS IDA_UGST_AMT," ).append("\n"); 
		query.append("       (  IDA.IDA_CGST_RTO + IDA.IDA_SGST_RTO + IDA.IDA_IGST_RTO + IDA.IDA_UGST_RTO) AS IDA_GST_RTO, " ).append("\n"); 
		query.append("       INV.IDA_CGST_AMT + INV.IDA_SGST_AMT + INV.IDA_IGST_AMT + INV.IDA_UGST_AMT AS GST_AMT," ).append("\n"); 
		query.append("         INV.IDA_CGST_AMT + INV.IDA_SGST_AMT + INV.IDA_IGST_AMT + INV.IDA_UGST_AMT + NVL (INV.INV_BZC_AMT, 0) AS TOTAL_AMT," ).append("\n"); 
		query.append("       INV.INV_PAY_MZD_CD," ).append("\n"); 
		query.append("       INV.INV_CHK_TRNS_NO," ).append("\n"); 
		query.append("       SO.INV_RMK," ).append("\n"); 
		query.append("       SO.SP_INV_RMK," ).append("\n"); 
		query.append("       INV.CRE_OFC_CD," ).append("\n"); 
		query.append("       INV.CRE_USR_ID," ).append("\n"); 
		query.append("       USR.USR_NM AS UPD_USR_NM," ).append("\n"); 
		query.append("       INV.UPD_USR_ID," ).append("\n"); 
		query.append("       DECODE (INV.HJL_NO, '', 'N', 'Y') AS ETS_STS_FLG," ).append("\n"); 
		query.append("       'N' AS RFND_FLG" ).append("\n"); 
		query.append("  FROM TRS_IDA_GST IDA," ).append("\n"); 
		query.append("       TRS_TRSP_SVC_ORD SO," ).append("\n"); 
		query.append("       TRS_TRSP_INV_WRK INV," ).append("\n"); 
		query.append("       MDM_VENDOR VNDR," ).append("\n"); 
		query.append("       COM_USER USR" ).append("\n"); 
		query.append(" WHERE     IDA.TRSP_SO_OFC_CTY_CD = SO.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("       AND IDA.TRSP_SO_SEQ = SO.TRSP_SO_SEQ" ).append("\n"); 
		query.append("       AND SO.INV_VNDR_SEQ = INV.INV_VNDR_SEQ" ).append("\n"); 
		query.append("       AND SO.INV_NO = INV.INV_NO" ).append("\n"); 
		query.append("       AND INV.INV_VNDR_SEQ = VNDR.VNDR_SEQ" ).append("\n"); 
		query.append("       AND INV.UPD_USR_ID = USR.USR_ID(+)" ).append("\n"); 
		query.append("       AND SO.DELT_FLG = 'N'" ).append("\n"); 
		query.append("       AND IDA.DELT_FLG = 'N'" ).append("\n"); 
		query.append("       AND VNDR.DELT_FLG = 'N'" ).append("\n"); 
		query.append("       AND SO.TRSP_SO_STS_CD = 'I'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${fmdate} == '' && $noCdArr.size() == 0)" ).append("\n"); 
		query.append("        AND 1=0  --필수조회조건(DATE,INVOICE 혹은 CSR) 이 모두 없는 경우 발생함.(20120926, YONGCHAN SHIN)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ( !(${fmdate} == '' ))" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #if(${date_cd} == 'IS' )" ).append("\n"); 
		query.append("            AND INV.INV_ISS_DT " ).append("\n"); 
		query.append("    #elseif(${date_cd} == 'PD')" ).append("\n"); 
		query.append("        AND INV.PAY_DT " ).append("\n"); 
		query.append("    #elseif(${date_cd} == 'GL')" ).append("\n"); 
		query.append("        AND TO_DATE(NVL(INV.GL_DT,'00010101')||'000001','YYYYMMDDHH24MISS')  " ).append("\n"); 
		query.append("    #elseif(${date_cd} == 'SU' )" ).append("\n"); 
		query.append("        AND INV.UPD_DT " ).append("\n"); 
		query.append("    #elseif(${date_cd} == 'IC')" ).append("\n"); 
		query.append("        AND INV.INV_CFM_DT " ).append("\n"); 
		query.append("    #else" ).append("\n"); 
		query.append("        AND INV.INV_RCV_DT " ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    BETWEEN TO_DATE(@[fmdate]||'000000','YYYYMMDDHH24MISS') AND TO_DATE(@[todate]||'235959','YYYYMMDDHH24MISS')        " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${status_cd} != 'ALL')" ).append("\n"); 
		query.append("    AND INV.TRSP_INV_AUD_STS_CD = '${status_cd}'        " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${recieved_cd} != 'ALL')" ).append("\n"); 
		query.append("    AND INV.IF_SYS_KND_CD = '${recieved_cd}'                " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${hold_cd} != 'ALL')" ).append("\n"); 
		query.append("    AND NVL(INV.INV_HLD_FLG, 'N') = '${hold_cd}'                    " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (!(${combo_svc_provider} == '') ) " ).append("\n"); 
		query.append("    #if(${sp_tp} == 'wo')" ).append("\n"); 
		query.append("        AND INV.WO_VNDR_SEQ = ${combo_svc_provider}                " ).append("\n"); 
		query.append("    #elseif(${sp_tp} == 'py')" ).append("\n"); 
		query.append("        AND INV.INV_VNDR_SEQ = ${combo_svc_provider}    " ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( $noCdArr.size() > 0)    " ).append("\n"); 
		query.append("    #if(${no_tp} == 'iv')" ).append("\n"); 
		query.append("        AND INV.INV_NO " ).append("\n"); 
		query.append("    #else" ).append("\n"); 
		query.append("        AND INV.CSR_NO " ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    IN ( " ).append("\n"); 
		query.append("    #foreach( ${key} in ${noCdArr})" ).append("\n"); 
		query.append("        #if($velocityCount == 1)" ).append("\n"); 
		query.append("             '${key}'" ).append("\n"); 
		query.append("        #else" ).append("\n"); 
		query.append("            ,  '${key}'" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    )                    " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( $ofcCdArr.size() > 0)    " ).append("\n"); 
		query.append("        AND INV.CRE_OFC_CD " ).append("\n"); 
		query.append("    IN ( " ).append("\n"); 
		query.append("    #foreach( ${key} in ${ofcCdArr})" ).append("\n"); 
		query.append("        #if($velocityCount == 1)" ).append("\n"); 
		query.append("             '${key}'" ).append("\n"); 
		query.append("        #else" ).append("\n"); 
		query.append("            ,  '${key}'" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    )                    " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(!(${ivc_upd_usr_id} == ''))" ).append("\n"); 
		query.append("    AND UPPER(USR.USR_NM) LIKE '%'||UPPER('${ivc_upd_usr_id}')||'%'        " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("GROUP BY INV.COST_OFC_CD," ).append("\n"); 
		query.append("         INV.INV_VNDR_SEQ," ).append("\n"); 
		query.append("         INV.INV_NO," ).append("\n"); 
		query.append("         INV.IF_SYS_KND_CD," ).append("\n"); 
		query.append("         INV.TRSP_INV_AUD_STS_CD," ).append("\n"); 
		query.append("         SO.CURR_CD," ).append("\n"); 
		query.append("         INV.CRE_OFC_CD," ).append("\n"); 
		query.append("         SO.INV_XCH_RT," ).append("\n"); 
		query.append("         SO.TRSP_INV_CALC_LGC_TP_CD," ).append("\n"); 
		query.append("         INV.INV_ISS_DT," ).append("\n"); 
		query.append("         INV.INV_RCV_DT," ).append("\n"); 
		query.append("         INV.PAY_DT," ).append("\n"); 
		query.append("         INV.GL_DT," ).append("\n"); 
		query.append("         INV.UPD_DT," ).append("\n"); 
		query.append("         INV.INV_CFM_DT," ).append("\n"); 
		query.append("         INV.CSR_NO," ).append("\n"); 
		query.append("         IDA.IDA_SAC_CD," ).append("\n"); 
		query.append("         IDA.IDA_PAY_TP_CD," ).append("\n"); 
		query.append("         INV.AP_RVS_CNG_FLG," ).append("\n"); 
		query.append("         INV.INV_HLD_FLG," ).append("\n"); 
		query.append("         INV.INV_CURR_CD," ).append("\n"); 
		query.append("         IDA.IDA_CGST_RTO," ).append("\n"); 
		query.append("         IDA.IDA_SGST_RTO," ).append("\n"); 
		query.append("         IDA.IDA_IGST_RTO," ).append("\n"); 
		query.append("         IDA.IDA_UGST_RTO," ).append("\n"); 
		query.append("         INV.INV_PAY_MZD_CD," ).append("\n"); 
		query.append("         INV.INV_CHK_TRNS_NO," ).append("\n"); 
		query.append("         SO.INV_RMK," ).append("\n"); 
		query.append("         SO.SP_INV_RMK," ).append("\n"); 
		query.append("         INV.CRE_USR_ID," ).append("\n"); 
		query.append("         USR.USR_NM," ).append("\n"); 
		query.append("         INV.UPD_USR_ID," ).append("\n"); 
		query.append("         INV.HJL_NO," ).append("\n"); 
		query.append("         INV.INV_BZC_AMT," ).append("\n"); 
		query.append("         INV.IDA_CGST_AMT," ).append("\n"); 
		query.append("         INV.IDA_SGST_AMT," ).append("\n"); 
		query.append("         INV.IDA_IGST_AMT," ).append("\n"); 
		query.append("         INV.IDA_UGST_AMT" ).append("\n"); 
		query.append("#if(${amount_verify_cd} == 'T')" ).append("\n"); 
		query.append("    HAVING INV.INV_NO IS NOT NULL    AND    SUM(NVL(SO.INV_ETC_ADD_AMT,0)) = 0    " ).append("\n"); 
		query.append("#elseif(${amount_verify_cd} == 'F')" ).append("\n"); 
		query.append("     HAVING INV.INV_NO IS NOT NULL AND SUM(NVL(SO.INV_ETC_ADD_AMT,0)) <> 0    " ).append("\n"); 
		query.append("#end      " ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("UNION ALL                    " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT /*+ INDEX(C XPKTRS_TRSP_RFND_INV)*/" ).append("\n"); 
		query.append("      INV.CRE_OFC_CD AS INV_OFC_CD," ).append("\n"); 
		query.append("       INV.COST_OFC_CD," ).append("\n"); 
		query.append("       (SELECT Q.IDA_GST_RGST_NO" ).append("\n"); 
		query.append("          FROM MDM_ORGANIZATION P, MDM_CUSTOMER Q" ).append("\n"); 
		query.append("         WHERE     P.OFC_CD = INV.COST_OFC_CD" ).append("\n"); 
		query.append("               AND P.REP_CUST_CNT_CD = Q.CUST_CNT_CD" ).append("\n"); 
		query.append("               AND P.REP_CUST_SEQ = Q.CUST_SEQ) AS CST_OFC_GST_NO," ).append("\n"); 
		query.append("       (SELECT R.IDA_STE_CD" ).append("\n"); 
		query.append("          FROM MDM_ORGANIZATION P, MDM_LOCATION Q, MDM_STATE R" ).append("\n"); 
		query.append("         WHERE     P.LOC_CD = Q.LOC_CD" ).append("\n"); 
		query.append("               AND Q.CNT_CD = R.CNT_CD" ).append("\n"); 
		query.append("               AND Q.STE_CD = R.STE_CD" ).append("\n"); 
		query.append("               AND P.OFC_CD = INV.COST_OFC_CD) AS CST_OFC_STE_CD," ).append("\n"); 
		query.append("       (SELECT IDA_GST_RGST_NO" ).append("\n"); 
		query.append("          FROM MDM_VENDOR MV" ).append("\n"); 
		query.append("         WHERE MV.DELT_FLG = 'N' AND MV.VNDR_SEQ = INV.INV_VNDR_SEQ) AS VNDR_GST_NO," ).append("\n"); 
		query.append("       (SELECT MS.IDA_STE_CD" ).append("\n"); 
		query.append("          FROM MDM_VENDOR MV, MDM_LOCATION ML, MDM_STATE MS" ).append("\n"); 
		query.append("         WHERE     MV.LOC_CD = ML.LOC_CD" ).append("\n"); 
		query.append("               AND MS.CNT_CD = MV.VNDR_CNT_CD" ).append("\n"); 
		query.append("               AND MS.STE_CD = ML.STE_CD" ).append("\n"); 
		query.append("               AND MV.DELT_FLG = 'N'" ).append("\n"); 
		query.append("               AND MV.VNDR_SEQ = INV.INV_VNDR_SEQ) AS VNDR_STE_CD," ).append("\n"); 
		query.append("       LPAD (TO_CHAR (INV.INV_VNDR_SEQ), 6, '0') AS INV_VNDR_SEQ," ).append("\n"); 
		query.append("       MAX (VNDR.VNDR_LGL_ENG_NM) AS INV_VNDR_NM," ).append("\n"); 
		query.append("       INV.INV_NO," ).append("\n"); 
		query.append("       COMMCODE_PKG.GET_COMDTL_NAME_FNC ('CD00914', INV.IF_SYS_KND_CD) AS IF_SYS_KND_NM," ).append("\n"); 
		query.append("       COMMCODE_PKG.GET_COMDTL_NAME_FNC ('CD00824', INV.TRSP_INV_AUD_STS_CD) AS TRSP_INV_AUD_STS_NM," ).append("\n"); 
		query.append("       SO.CURR_CD," ).append("\n"); 
		query.append("       0 AS WO_TOT_AMT," ).append("\n"); 
		query.append("       0 AS INV_XCH_RT," ).append("\n"); 
		query.append("       '' AS TRSP_INV_CALC_LGC_TP_NM," ).append("\n"); 
		query.append("       TO_CHAR (INV.INV_ISS_DT, 'YYYYMMDD') INV_ISS_DT," ).append("\n"); 
		query.append("       TO_CHAR (INV.INV_RCV_DT, 'YYYYMMDD') INV_RCV_DT," ).append("\n"); 
		query.append("       TO_CHAR (INV.PAY_DT, 'YYYYMMDD') PAY_DT," ).append("\n"); 
		query.append("       INV.GL_DT," ).append("\n"); 
		query.append("       TO_CHAR (INV.UPD_DT, 'YYYYMMDD') UPD_DT," ).append("\n"); 
		query.append("       TO_CHAR (INV.INV_CFM_DT, 'YYYYMMDD') INV_CFM_DT," ).append("\n"); 
		query.append("       INV.CSR_NO," ).append("\n"); 
		query.append("       IDA.IDA_SAC_CD," ).append("\n"); 
		query.append("       (SELECT IDA_SAC_NM" ).append("\n"); 
		query.append("          FROM BKG_IDA_SAC_MST B" ).append("\n"); 
		query.append("         WHERE     B.IDA_SAC_CD = IDA.IDA_SAC_CD" ).append("\n"); 
		query.append("               AND B.DELT_FLG = 'N'" ).append("\n"); 
		query.append("               AND ROWNUM = 1) AS IDA_SAC_NM," ).append("\n"); 
		query.append("       DECODE (IDA.IDA_PAY_TP_CD,  'S', 'Services',  'G', 'Goods',  '') AS IDA_PAY_TP_CD," ).append("\n"); 
		query.append("       NVL (INV.AP_RVS_CNG_FLG, 'N') AS AP_RVS_CNG_FLG," ).append("\n"); 
		query.append("       NVL (INV.INV_HLD_FLG, 'N') AS INV_HLD_FLG," ).append("\n"); 
		query.append("       INV.INV_CURR_CD," ).append("\n"); 
		query.append("       RFND.TRSP_RFND_INV_AMT * -1 AS INV_BZC_AMT," ).append("\n"); 
		query.append("       IDA.IDA_CGST_RTO," ).append("\n"); 
		query.append("       SUM (IDA.IDA_CGST_AMT) * -1 AS IDA_CGST_AMT," ).append("\n"); 
		query.append("       IDA.IDA_SGST_RTO," ).append("\n"); 
		query.append("       SUM (IDA.IDA_SGST_AMT) * -1 AS IDA_SGST_AMT," ).append("\n"); 
		query.append("       IDA.IDA_IGST_RTO," ).append("\n"); 
		query.append("       SUM (IDA.IDA_IGST_AMT) * -1 AS IDA_IGST_AMT," ).append("\n"); 
		query.append("       IDA.IDA_UGST_RTO," ).append("\n"); 
		query.append("       SUM (IDA.IDA_UGST_AMT) * -1 AS IDA_UGST_AMT," ).append("\n"); 
		query.append("       (  IDA.IDA_CGST_RTO + IDA.IDA_SGST_RTO + IDA.IDA_IGST_RTO + IDA.IDA_UGST_RTO) AS IDA_GST_RTO," ).append("\n"); 
		query.append("         (  INV.IDA_CGST_AMT + INV.IDA_SGST_AMT + INV.IDA_IGST_AMT + INV.IDA_UGST_AMT) * -1 AS GST_AMT," ).append("\n"); 
		query.append("         (  INV.IDA_CGST_AMT + INV.IDA_SGST_AMT + INV.IDA_IGST_AMT + INV.IDA_UGST_AMT + NVL (RFND.TRSP_RFND_INV_AMT, 0)) * -1 AS TOTAL_AMT," ).append("\n"); 
		query.append("       INV.INV_PAY_MZD_CD," ).append("\n"); 
		query.append("       INV.INV_CHK_TRNS_NO," ).append("\n"); 
		query.append("       SO.INV_RMK," ).append("\n"); 
		query.append("       SO.SP_INV_RMK," ).append("\n"); 
		query.append("       INV.CRE_OFC_CD," ).append("\n"); 
		query.append("       INV.CRE_USR_ID," ).append("\n"); 
		query.append("       USR.USR_NM AS UPD_USR_NM," ).append("\n"); 
		query.append("       INV.UPD_USR_ID," ).append("\n"); 
		query.append("       DECODE (INV.HJL_NO, '', 'N', 'Y') AS ETS_STS_FLG," ).append("\n"); 
		query.append("       'Y' AS RFND_FLG" ).append("\n"); 
		query.append("  FROM TRS_IDA_GST IDA," ).append("\n"); 
		query.append("       TRS_TRSP_SVC_ORD SO," ).append("\n"); 
		query.append("       TRS_TRSP_INV_WRK INV," ).append("\n"); 
		query.append("       MDM_VENDOR VNDR," ).append("\n"); 
		query.append("       COM_USER USR," ).append("\n"); 
		query.append("       TRS_TRSP_RFND_INV RFND" ).append("\n"); 
		query.append(" WHERE     IDA.TRSP_SO_OFC_CTY_CD = SO.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("       AND IDA.TRSP_SO_SEQ = SO.TRSP_SO_SEQ" ).append("\n"); 
		query.append("       AND SO.INV_VNDR_SEQ = INV.INV_VNDR_SEQ" ).append("\n"); 
		query.append("       AND SO.INV_NO = INV.INV_NO" ).append("\n"); 
		query.append("       AND INV.INV_VNDR_SEQ = VNDR.VNDR_SEQ" ).append("\n"); 
		query.append("       AND INV.INV_VNDR_SEQ = RFND.INV_VNDR_SEQ" ).append("\n"); 
		query.append("       AND INV.INV_NO = RFND.INV_NO" ).append("\n"); 
		query.append("       AND INV.UPD_USR_ID = USR.USR_ID(+)" ).append("\n"); 
		query.append("       AND SO.DELT_FLG = 'N'" ).append("\n"); 
		query.append("       AND IDA.DELT_FLG = 'N'" ).append("\n"); 
		query.append("       AND VNDR.DELT_FLG = 'N'" ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("#if(${fmdate} == '' && $noCdArr.size() == 0)" ).append("\n"); 
		query.append("    AND 1=0  --필수조회조건(DATE,INVOICE 혹은 CSR) 이 모두 없는 경우 발생함.(20120926, YONGCHAN SHIN)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ( !(${fmdate} == '' ))" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #if( ${date_cd} == 'IS' )" ).append("\n"); 
		query.append("            AND INV.INV_ISS_DT " ).append("\n"); 
		query.append("    #elseif(${date_cd} == 'PD' )" ).append("\n"); 
		query.append("        AND INV.PAY_DT " ).append("\n"); 
		query.append("    #elseif(${date_cd} == 'GL' )" ).append("\n"); 
		query.append("        AND TO_DATE(NVL(INV.GL_DT,'00010101')||'000001','YYYYMMDDHH24MISS')  " ).append("\n"); 
		query.append("    #elseif(${date_cd} == 'SU' )" ).append("\n"); 
		query.append("        AND INV.UPD_DT " ).append("\n"); 
		query.append("    #elseif(${date_cd} == 'IC' )" ).append("\n"); 
		query.append("        AND INV.INV_CFM_DT " ).append("\n"); 
		query.append("    #else" ).append("\n"); 
		query.append("        AND INV.INV_RCV_DT " ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    BETWEEN TO_DATE(@[fmdate]||'000000','YYYYMMDDHH24MISS') AND TO_DATE(@[todate]||'235959','YYYYMMDDHH24MISS')        " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${status_cd} != 'ALL')" ).append("\n"); 
		query.append("    AND INV.TRSP_INV_AUD_STS_CD = '${status_cd}'        " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${recieved_cd} != 'ALL')" ).append("\n"); 
		query.append("    AND INV.IF_SYS_KND_CD = '${recieved_cd}'                " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${hold_cd} != 'ALL')" ).append("\n"); 
		query.append("    AND NVL(INV.INV_HLD_FLG, 'N') = '${hold_cd}'                    " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (!(${combo_svc_provider} == '') ) " ).append("\n"); 
		query.append("    #if(${sp_tp} == 'wo')" ).append("\n"); 
		query.append("        AND INV.WO_VNDR_SEQ = ${combo_svc_provider}                " ).append("\n"); 
		query.append("    #elseif(${sp_tp} == 'py')" ).append("\n"); 
		query.append("        AND INV.INV_VNDR_SEQ = ${combo_svc_provider}    " ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( $noCdArr.size() > 0)    " ).append("\n"); 
		query.append("    #if(${no_tp} == 'iv')" ).append("\n"); 
		query.append("        AND INV.INV_NO " ).append("\n"); 
		query.append("    #else" ).append("\n"); 
		query.append("        AND INV.CSR_NO " ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    IN ( " ).append("\n"); 
		query.append("    #foreach( ${key} in ${noCdArr})" ).append("\n"); 
		query.append("        #if($velocityCount == 1)" ).append("\n"); 
		query.append("             '${key}'" ).append("\n"); 
		query.append("        #else" ).append("\n"); 
		query.append("            ,  '${key}'" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    )                    " ).append("\n"); 
		query.append("#end    " ).append("\n"); 
		query.append("#if ( $ofcCdArr.size() > 0)    " ).append("\n"); 
		query.append("        AND INV.CRE_OFC_CD " ).append("\n"); 
		query.append("    IN ( " ).append("\n"); 
		query.append("    #foreach( ${key} in ${ofcCdArr})" ).append("\n"); 
		query.append("        #if($velocityCount == 1)" ).append("\n"); 
		query.append("             '${key}'" ).append("\n"); 
		query.append("        #else" ).append("\n"); 
		query.append("            ,  '${key}'" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    )                    " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(!(${ivc_upd_usr_id} == ''))" ).append("\n"); 
		query.append("    AND UPPER(USR.USR_NM) LIKE '%'||UPPER('${ivc_upd_usr_id}')||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("GROUP BY INV.COST_OFC_CD," ).append("\n"); 
		query.append("         INV.INV_VNDR_SEQ," ).append("\n"); 
		query.append("         INV.INV_NO," ).append("\n"); 
		query.append("         INV.IF_SYS_KND_CD," ).append("\n"); 
		query.append("         INV.TRSP_INV_AUD_STS_CD," ).append("\n"); 
		query.append("         SO.CURR_CD," ).append("\n"); 
		query.append("         INV.CRE_OFC_CD," ).append("\n"); 
		query.append("         SO.INV_XCH_RT," ).append("\n"); 
		query.append("         SO.TRSP_INV_CALC_LGC_TP_CD," ).append("\n"); 
		query.append("         INV.INV_ISS_DT," ).append("\n"); 
		query.append("         INV.INV_RCV_DT," ).append("\n"); 
		query.append("         INV.PAY_DT," ).append("\n"); 
		query.append("         INV.GL_DT," ).append("\n"); 
		query.append("         INV.UPD_DT," ).append("\n"); 
		query.append("         INV.INV_CFM_DT," ).append("\n"); 
		query.append("         INV.CSR_NO," ).append("\n"); 
		query.append("         IDA.IDA_SAC_CD," ).append("\n"); 
		query.append("         IDA.IDA_PAY_TP_CD," ).append("\n"); 
		query.append("         INV.AP_RVS_CNG_FLG," ).append("\n"); 
		query.append("         INV.INV_HLD_FLG," ).append("\n"); 
		query.append("         INV.INV_CURR_CD," ).append("\n"); 
		query.append("         IDA.IDA_CGST_RTO," ).append("\n"); 
		query.append("         IDA.IDA_SGST_RTO," ).append("\n"); 
		query.append("         IDA.IDA_IGST_RTO," ).append("\n"); 
		query.append("         IDA.IDA_UGST_RTO," ).append("\n"); 
		query.append("         INV.INV_PAY_MZD_CD," ).append("\n"); 
		query.append("         INV.INV_CHK_TRNS_NO," ).append("\n"); 
		query.append("         SO.INV_RMK," ).append("\n"); 
		query.append("         SO.SP_INV_RMK," ).append("\n"); 
		query.append("         INV.CRE_USR_ID," ).append("\n"); 
		query.append("         USR.USR_NM," ).append("\n"); 
		query.append("         INV.UPD_USR_ID," ).append("\n"); 
		query.append("         INV.HJL_NO," ).append("\n"); 
		query.append("         INV.IDA_CGST_AMT," ).append("\n"); 
		query.append("         INV.IDA_SGST_AMT," ).append("\n"); 
		query.append("         INV.IDA_IGST_AMT," ).append("\n"); 
		query.append("         INV.IDA_UGST_AMT," ).append("\n"); 
		query.append("         RFND.TRSP_RFND_INV_AMT" ).append("\n"); 

	}
}