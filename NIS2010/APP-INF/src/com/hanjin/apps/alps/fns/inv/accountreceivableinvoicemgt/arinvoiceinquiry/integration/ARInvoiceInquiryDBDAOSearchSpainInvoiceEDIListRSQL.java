/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ARInvoiceInquiryDBDAOSearchSpainInvoiceEDIListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.03.07
*@LastModifier : 
*@LastVersion : 1.0
* 2012.03.07 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ARInvoiceInquiryDBDAOSearchSpainInvoiceEDIListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Spakin VLCBB Officed의 local SYSTEM용  엑셀데이터를 만들기 위한 데이터 조회.
	  * issue date 기준으로 조회하며 .정해진 item 정보를 조회해 온다.
	  * </pre>
	  */
	public ARInvoiceInquiryDBDAOSearchSpainInvoiceEDIListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("iss_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.integration").append("\n"); 
		query.append("FileName : ARInvoiceInquiryDBDAOSearchSpainInvoiceEDIListRSQL").append("\n"); 
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
		query.append("SELECT TB.AR_IF_NO," ).append("\n"); 
		query.append("RPAD(NVL(TB.BL_NO, ' '), 12, ' ') BL_NO," ).append("\n"); 
		query.append("RPAD(NVL(TB.BL_TP_CD, ' '), 1, ' ') BL_TP_CD," ).append("\n"); 
		query.append("RPAD(NVL(TB.INV_NO, ' '), 9, ' ') INV_NO," ).append("\n"); 
		query.append("RPAD(NVL(TB.BKG_CORR_NO, ' '), 10, ' ') BKG_CORR_NO," ).append("\n"); 
		query.append("RPAD(NVL(TB.BKG_NO, ' '), 13, ' ') BKG_NO," ).append("\n"); 
		query.append("TB.AR_HD_QTR_OFC_CD," ).append("\n"); 
		query.append("TB.ACT_CUST_CNT_CD," ).append("\n"); 
		query.append("TB.ACT_CUST_SEQ," ).append("\n"); 
		query.append("TB.AR_OFC_CD," ).append("\n"); 
		query.append("TB.REV_TP_CD," ).append("\n"); 
		query.append("TB.REV_SRC_CD," ).append("\n"); 
		query.append("TB.VSL_CD," ).append("\n"); 
		query.append("TB.SKD_VOY_NO," ).append("\n"); 
		query.append("TB.SKD_DIR_CD," ).append("\n"); 
		query.append("TB.PORT," ).append("\n"); 
		query.append("TB.LOCL_CURR_CD," ).append("\n"); 
		query.append("TB.SVC_SCP_CD," ).append("\n"); 
		query.append("TB.SAIL_ARR_DT," ).append("\n"); 
		query.append("TB.SLAN_CD," ).append("\n"); 
		query.append("TB.IO_BND_CD," ).append("\n"); 
		query.append("TB.T_VVD," ).append("\n"); 
		query.append("RPAD(NVL(TB.POR_CD, ' '), 5, ' ') POR_CD," ).append("\n"); 
		query.append("RPAD(NVL(TB.POL_CD, ' '), 5, ' ') POL_CD," ).append("\n"); 
		query.append("RPAD(NVL(TB.POD_CD, ' '), 5, ' ') POD_CD," ).append("\n"); 
		query.append("RPAD(NVL(TB.DEL_CD, ' '), 5, ' ') DEL_CD," ).append("\n"); 
		query.append("TO_CHAR(TB.USD_XCH_RT, '00000.000000') USD_XCH_RT," ).append("\n"); 
		query.append("TO_CHAR(ROUND(TB.LCL_CHG, TB.DP_PRCS_KNT_LOCAL), '000000000000000.000') LCL_CHG," ).append("\n"); 
		query.append("TO_CHAR(TB.USD_TOT, '000000000000000.000') USD_TOT," ).append("\n"); 
		query.append("TO_CHAR(ROUND(TB.USD_TOT*TB.USD_XCH_RT, TB.DP_PRCS_KNT_LOCAL), '000000000000000.000') USD_EQV," ).append("\n"); 
		query.append("TO_CHAR(ROUND(TB.INV_TTL_LOCL_AMT, TB.DP_PRCS_KNT_LOCAL), '000000000000000.000') LCL_TOT," ).append("\n"); 
		query.append("TO_CHAR(TB.CGO_WGT, '0000000000.000') CGO_WGT," ).append("\n"); 
		query.append("TO_CHAR(TB.CGO_MEAS_QTY, '0000000000.000') CGO_MEAS_QTY," ).append("\n"); 
		query.append("TO_CHAR(TB.BKG_TEU_QTY, '00000') BKG_TEU_QTY," ).append("\n"); 
		query.append("TO_CHAR(TB.BKG_FEU_QTY, '00000') BKG_FEU_QTY," ).append("\n"); 
		query.append("RPAD(NVL(TB.SC_NO, ' '), 8, ' ') SC_NO," ).append("\n"); 
		query.append("RPAD(NVL(TB.RFA_NO, ' '), 8, ' ') RFA_NO," ).append("\n"); 
		query.append("RPAD(NVL(TB.SREP_CD, ' '), 5, ' ') SREP_CD," ).append("\n"); 
		query.append("TB.DUE_DT," ).append("\n"); 
		query.append("TB.BL_INV_IF_DT," ).append("\n"); 
		query.append("TB.ISS_DT," ).append("\n"); 
		query.append("TB.BL_INV_CFM_DT," ).append("\n"); 
		query.append("TB.GL_EFF_DT," ).append("\n"); 
		query.append("NVL(TB.INV_SPLIT_CD, ' ') INV_SPLIT_CD," ).append("\n"); 
		query.append("TO_CHAR(TB.INV_SEQ, '000') INV_SEQ," ).append("\n"); 
		query.append("TO_CHAR(TB.CHG_SEQ, '000') CHG_SEQ," ).append("\n"); 
		query.append("TB.CHG_CD," ).append("\n"); 
		query.append("TB.CURR_CD," ).append("\n"); 
		query.append("TB.PER_TP_CD," ).append("\n"); 
		query.append("TO_CHAR(TB.TRF_RT_AMT, '000000000.000') TRF_RT_AMT," ).append("\n"); 
		query.append("TO_CHAR(TB.RAT_AS_CNTR_QTY, '000000.000') RAT_AS_CNTR_QTY," ).append("\n"); 
		query.append("RPAD(TO_CHAR(TB.CHG_AMT, '000000000000000.000'), 20, ' ') CHG_AMT," ).append("\n"); 
		query.append("TO_CHAR(TB.INV_XCH_RT, '00000.000000') INV_XCH_RT," ).append("\n"); 
		query.append("TB.TVA_FLG," ).append("\n"); 
		query.append("DECODE(TVA_FLG,'Y', (SELECT ROUND((SELECT NVL(SUM(CHG_AMT),0) IVA_AMT" ).append("\n"); 
		query.append("FROM INV_AR_CHG" ).append("\n"); 
		query.append("WHERE AR_IF_NO = TB.AR_IF_NO" ).append("\n"); 
		query.append("AND CHG_CD = 'IVA') / (SELECT DECODE(NVL(SUM(CHG_AMT),1),0,1,NVL(SUM(CHG_AMT),1)) CHG_AMT" ).append("\n"); 
		query.append("FROM INV_AR_CHG" ).append("\n"); 
		query.append("WHERE AR_IF_NO = TB.AR_IF_NO" ).append("\n"); 
		query.append("AND TVA_FLG = 'Y') * 100)" ).append("\n"); 
		query.append("FROM DUAL) ,'' ) IVA_RATE," ).append("\n"); 
		query.append("TB.MF_DIV_CD" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT A.AR_IF_NO," ).append("\n"); 
		query.append("NVL(A.BL_NO, A.BL_SRC_NO) BL_NO," ).append("\n"); 
		query.append("A.BL_TP_CD," ).append("\n"); 
		query.append("C.INV_NO," ).append("\n"); 
		query.append("A.BKG_CORR_NO," ).append("\n"); 
		query.append("A.BKG_NO," ).append("\n"); 
		query.append("E.AR_HD_QTR_OFC_CD," ).append("\n"); 
		query.append("A.ACT_CUST_CNT_CD," ).append("\n"); 
		query.append("LPAD(A.ACT_CUST_SEQ, 6, '0') ACT_CUST_SEQ," ).append("\n"); 
		query.append("A.AR_OFC_CD," ).append("\n"); 
		query.append("A.REV_TP_CD," ).append("\n"); 
		query.append("A.REV_SRC_CD," ).append("\n"); 
		query.append("A.VSL_CD," ).append("\n"); 
		query.append("A.SKD_VOY_NO," ).append("\n"); 
		query.append("A.SKD_DIR_CD," ).append("\n"); 
		query.append("DECODE(A.IO_BND_CD, 'I', A.POD_CD, 'O', A.POL_CD) PORT," ).append("\n"); 
		query.append("A.LOCL_CURR_CD," ).append("\n"); 
		query.append("A.SVC_SCP_CD," ).append("\n"); 
		query.append("A.SAIL_ARR_DT," ).append("\n"); 
		query.append("A.SLAN_CD," ).append("\n"); 
		query.append("DECODE(A.IO_BND_CD, 'I', 'I/B', 'O', 'O/B') IO_BND_CD," ).append("\n"); 
		query.append("A.TRNK_VSL_CD||A.TRNK_SKD_VOY_NO||A.TRNK_SKD_DIR_CD T_VVD," ).append("\n"); 
		query.append("A.POR_CD," ).append("\n"); 
		query.append("A.POL_CD," ).append("\n"); 
		query.append("A.POD_CD," ).append("\n"); 
		query.append("A.DEL_CD," ).append("\n"); 
		query.append("A.USD_XCH_RT," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT NVL(SUM(S1.CHG_AMT), 0)" ).append("\n"); 
		query.append("FROM INV_AR_CHG S1" ).append("\n"); 
		query.append("WHERE A.AR_IF_NO = S1.AR_IF_NO" ).append("\n"); 
		query.append("AND S1.CURR_CD != 'USD') LCL_CHG," ).append("\n"); 
		query.append("F.DP_PRCS_KNT DP_PRCS_KNT_LOCAL, --" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT NVL(SUM(S2.CHG_AMT), 0)" ).append("\n"); 
		query.append("FROM INV_AR_CHG S2" ).append("\n"); 
		query.append("WHERE A.AR_IF_NO = S2.AR_IF_NO" ).append("\n"); 
		query.append("AND S2.CURR_CD = 'USD') USD_TOT, --" ).append("\n"); 
		query.append("A.INV_TTL_LOCL_AMT, --" ).append("\n"); 
		query.append("A.CGO_WGT," ).append("\n"); 
		query.append("A.CGO_MEAS_QTY," ).append("\n"); 
		query.append("A.BKG_TEU_QTY," ).append("\n"); 
		query.append("A.BKG_FEU_QTY," ).append("\n"); 
		query.append("A.SC_NO," ).append("\n"); 
		query.append("A.RFA_NO," ).append("\n"); 
		query.append("A.SREP_CD," ).append("\n"); 
		query.append("A.DUE_DT," ).append("\n"); 
		query.append("A.BL_INV_IF_DT," ).append("\n"); 
		query.append("D.ISS_DT," ).append("\n"); 
		query.append("A.BL_INV_CFM_DT," ).append("\n"); 
		query.append("A.GL_EFF_DT," ).append("\n"); 
		query.append("A.INV_SPLIT_CD," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT MAX(S3.INV_SEQ)" ).append("\n"); 
		query.append("FROM INV_AR_ISS S3" ).append("\n"); 
		query.append("WHERE C.INV_NO = S3.INV_NO) INV_SEQ," ).append("\n"); 
		query.append("B.CHG_SEQ," ).append("\n"); 
		query.append("B.CHG_CD," ).append("\n"); 
		query.append("B.CURR_CD," ).append("\n"); 
		query.append("B.PER_TP_CD," ).append("\n"); 
		query.append("B.TRF_RT_AMT," ).append("\n"); 
		query.append("B.RAT_AS_CNTR_QTY," ).append("\n"); 
		query.append("B.CHG_AMT," ).append("\n"); 
		query.append("B.INV_XCH_RT," ).append("\n"); 
		query.append("B.TVA_FLG," ).append("\n"); 
		query.append("B.MF_DIV_CD" ).append("\n"); 
		query.append("FROM INV_AR_MN A," ).append("\n"); 
		query.append("INV_AR_CHG B," ).append("\n"); 
		query.append("INV_AR_ISS_DTL C," ).append("\n"); 
		query.append("INV_AR_ISS D," ).append("\n"); 
		query.append("MDM_ORGANIZATION E," ).append("\n"); 
		query.append("MDM_CURRENCY F" ).append("\n"); 
		query.append("WHERE D.ISS_DT BETWEEN TO_CHAR(TO_DATE(@[iss_dt],'YYYYMMDD') - 6,'YYYYMMDD') AND @[iss_dt]" ).append("\n"); 
		query.append("AND D.INV_SEQ = 1" ).append("\n"); 
		query.append("AND D.ISS_OFC_CD IN (" ).append("\n"); 
		query.append("SELECT OFC_CD" ).append("\n"); 
		query.append("FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("WHERE AR_OFC_CD = @[ar_ofc_cd] )" ).append("\n"); 
		query.append("AND D.INV_NO = C.INV_NO" ).append("\n"); 
		query.append("AND C.AR_IF_NO = B.AR_IF_NO" ).append("\n"); 
		query.append("AND C.CHG_SEQ = B.CHG_SEQ" ).append("\n"); 
		query.append("AND B.AR_IF_NO = A.AR_IF_NO" ).append("\n"); 
		query.append("AND A.AR_OFC_CD = @[ar_ofc_cd]" ).append("\n"); 
		query.append("AND NVL(A.INV_DELT_DIV_CD, 'N') <> 'Y'" ).append("\n"); 
		query.append("AND A.EDI_SND_DT IS NULL" ).append("\n"); 
		query.append("AND A.AR_OFC_CD = E.OFC_CD" ).append("\n"); 
		query.append("AND F.CURR_CD = A.LOCL_CURR_CD" ).append("\n"); 
		query.append(") TB" ).append("\n"); 
		query.append("ORDER BY INV_NO,CHG_SEQ" ).append("\n"); 

	}
}