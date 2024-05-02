/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InvoiceIssueDBDAOSearchGIROMainRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.03
*@LastModifier : 박정진
*@LastVersion : 1.0
* 2009.11.03 박정진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jung Jin Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceIssueDBDAOSearchGIROMainRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MDM_CUSTOMER, MDM_CR_CUST, MDM_CUST_ADDR, INV_AR_MN, INV_AR_CHG 테이블에서 select
	  * </pre>
	  */
	public InvoiceIssueDBDAOSearchGIROMainRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_src_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.integration").append("\n"); 
		query.append("FileName : InvoiceIssueDBDAOSearchGIROMainRSQL").append("\n"); 
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
		query.append("SELECT BL_SRC_NO," ).append("\n"); 
		query.append("GIRO_NO," ).append("\n"); 
		query.append("ISS_DT," ).append("\n"); 
		query.append("AR_OFC_CD," ).append("\n"); 
		query.append("ACT_CUST_CNT_CD," ).append("\n"); 
		query.append("ACT_CUST_SEQ," ).append("\n"); 
		query.append("LOCL_NM," ).append("\n"); 
		query.append("CUST_RGST_NO," ).append("\n"); 
		query.append("LOCL_ADDR," ).append("\n"); 
		query.append("OWNR_NM," ).append("\n"); 
		query.append("BZCT_NM," ).append("\n"); 
		query.append("VVD," ).append("\n"); 
		query.append("SAIL_ARR_DT," ).append("\n"); 
		query.append("DUE_DT," ).append("\n"); 
		query.append("GIRO_RMK," ).append("\n"); 
		query.append("INV_SPL_AMT," ).append("\n"); 
		query.append("INV_TVA_AMT" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT T1.DATA_GB," ).append("\n"); 
		query.append("T1.BL_SRC_NO," ).append("\n"); 
		query.append("T1.GIRO_NO," ).append("\n"); 
		query.append("T1.ISS_DT," ).append("\n"); 
		query.append("T1.AR_OFC_CD," ).append("\n"); 
		query.append("T1.ACT_CUST_CNT_CD," ).append("\n"); 
		query.append("T1.ACT_CUST_SEQ," ).append("\n"); 
		query.append("T1.LOCL_NM," ).append("\n"); 
		query.append("T1.CUST_RGST_NO," ).append("\n"); 
		query.append("T1.LOCL_ADDR," ).append("\n"); 
		query.append("T1.OWNR_NM," ).append("\n"); 
		query.append("T1.BZCT_NM," ).append("\n"); 
		query.append("T1.VVD," ).append("\n"); 
		query.append("T1.SAIL_ARR_DT," ).append("\n"); 
		query.append("T1.DUE_DT," ).append("\n"); 
		query.append("T1.GIRO_RMK," ).append("\n"); 
		query.append("NVL(T2.INV_SPL_AMT,'0') INV_SPL_AMT," ).append("\n"); 
		query.append("NVL(T2.INV_TVA_AMT,'0') INV_TVA_AMT" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT '1' DATA_GB," ).append("\n"); 
		query.append("A.BL_SRC_NO," ).append("\n"); 
		query.append("A.GIRO_NO," ).append("\n"); 
		query.append("TO_CHAR(TO_DATE(A.ISS_DT, 'YYYYMMDD'), 'YYYY-MM-DD') ISS_DT," ).append("\n"); 
		query.append("A.AR_OFC_CD," ).append("\n"); 
		query.append("A.ACT_CUST_CNT_CD," ).append("\n"); 
		query.append("LPAD(A.ACT_CUST_SEQ, 6, '0') ACT_CUST_SEQ," ).append("\n"); 
		query.append("B.LOCL_NM," ).append("\n"); 
		query.append("DECODE(C.INDIV_CORP_DIV_CD, 'C', CASE WHEN LENGTH(C.CUST_RGST_NO) = 10 THEN SUBSTR(C.CUST_RGST_NO, 0, 3)||'-'||SUBSTR(C.CUST_RGST_NO, 4, 2)||'-'||SUBSTR(C.CUST_RGST_NO, 6, 5) ELSE C.CUST_RGST_NO END, 'P', CASE WHEN LENGTH(C.CUST_RGST_NO) = 13 THEN SUBSTR(C.CUST_RGST_NO, 0, 6) ||'-'||SUBSTR(C.CUST_RGST_NO, 7, 13) ELSE C.CUST_RGST_NO END) CUST_RGST_NO," ).append("\n"); 
		query.append("B.LOCL_ADDR1||B.LOCL_ADDR2||B.LOCL_ADDR3||B.LOCL_ADDR4 LOCL_ADDR," ).append("\n"); 
		query.append("B.OWNR_NM," ).append("\n"); 
		query.append("B.BZCT_NM," ).append("\n"); 
		query.append("A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD VVD," ).append("\n"); 
		query.append("TO_CHAR(TO_DATE(A.SAIL_ARR_DT, 'YYYYMMDD'), 'YYYY-MM-DD') SAIL_ARR_DT," ).append("\n"); 
		query.append("TO_CHAR(TO_DATE(A.DUE_DT, 'YYYYMMDD'), 'YYYY-MM-DD') DUE_DT," ).append("\n"); 
		query.append("A.GIRO_RMK" ).append("\n"); 
		query.append("FROM INV_AR_GIRO A," ).append("\n"); 
		query.append("MDM_CR_CUST B," ).append("\n"); 
		query.append("MDM_CUSTOMER C" ).append("\n"); 
		query.append("WHERE A.ACT_CUST_CNT_CD = B.CUST_CNT_CD (+)" ).append("\n"); 
		query.append("AND A.ACT_CUST_SEQ = B.CUST_SEQ (+)" ).append("\n"); 
		query.append("AND A.ACT_CUST_CNT_CD = C.CUST_CNT_CD" ).append("\n"); 
		query.append("AND A.ACT_CUST_SEQ = C.CUST_SEQ" ).append("\n"); 
		query.append("AND A.GIRO_NO = (" ).append("\n"); 
		query.append("SELECT MIN(GIRO_NO)" ).append("\n"); 
		query.append("FROM INV_AR_GIRO" ).append("\n"); 
		query.append("WHERE BL_SRC_NO = @[bl_src_no]" ).append("\n"); 
		query.append("AND AR_OFC_CD = @[ar_ofc_cd]" ).append("\n"); 
		query.append("AND DELT_FLG = 'N')" ).append("\n"); 
		query.append("AND A.AR_OFC_CD = @[ar_ofc_cd]" ).append("\n"); 
		query.append("AND A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT '2' DATA_GB," ).append("\n"); 
		query.append("A.BL_SRC_NO," ).append("\n"); 
		query.append("A.BL_SRC_NO||'01' GIRO_NO," ).append("\n"); 
		query.append("TO_CHAR(SYSDATE, 'YYYY-MM-DD') ISS_DT," ).append("\n"); 
		query.append("A.AR_OFC_CD," ).append("\n"); 
		query.append("A.ACT_CUST_CNT_CD," ).append("\n"); 
		query.append("LPAD(A.ACT_CUST_SEQ, 6, '0') ACT_CUST_SEQ," ).append("\n"); 
		query.append("B.LOCL_NM," ).append("\n"); 
		query.append("DECODE(C.INDIV_CORP_DIV_CD, 'C', CASE WHEN LENGTH(C.CUST_RGST_NO) = 10 THEN SUBSTR(C.CUST_RGST_NO, 0, 3)||'-'||SUBSTR(C.CUST_RGST_NO, 4, 2)||'-'||SUBSTR(C.CUST_RGST_NO, 6, 5) ELSE C.CUST_RGST_NO END, 'P', CASE WHEN LENGTH(C.CUST_RGST_NO) = 13 THEN SUBSTR(C.CUST_RGST_NO, 0, 6) ||'-'||SUBSTR(C.CUST_RGST_NO, 7, 13) ELSE C.CUST_RGST_NO END) CUST_RGST_NO," ).append("\n"); 
		query.append("B.LOCL_ADDR1||B.LOCL_ADDR2||B.LOCL_ADDR3||B.LOCL_ADDR4 LOCL_ADDR," ).append("\n"); 
		query.append("B.OWNR_NM," ).append("\n"); 
		query.append("B.BZCT_NM," ).append("\n"); 
		query.append("A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD VVD," ).append("\n"); 
		query.append("TO_CHAR(TO_DATE(A.SAIL_ARR_DT, 'YYYYMMDD'), 'YYYY-MM-DD') SAIL_ARR_DT," ).append("\n"); 
		query.append("TO_CHAR(TO_DATE(A.DUE_DT, 'YYYYMMDD'), 'YYYY-MM-DD') DUE_DT," ).append("\n"); 
		query.append("'' GIRO_RMK" ).append("\n"); 
		query.append("FROM INV_AR_MN A," ).append("\n"); 
		query.append("MDM_CR_CUST B," ).append("\n"); 
		query.append("MDM_CUSTOMER C" ).append("\n"); 
		query.append("WHERE A.ACT_CUST_CNT_CD = B.CUST_CNT_CD (+)" ).append("\n"); 
		query.append("AND A.ACT_CUST_SEQ = B.CUST_SEQ (+)" ).append("\n"); 
		query.append("AND A.ACT_CUST_CNT_CD = C.CUST_CNT_CD" ).append("\n"); 
		query.append("AND A.ACT_CUST_SEQ = C.CUST_SEQ" ).append("\n"); 
		query.append("AND A.AR_IF_NO = (" ).append("\n"); 
		query.append("SELECT MAX(AR_IF_NO)" ).append("\n"); 
		query.append("FROM INV_AR_MN" ).append("\n"); 
		query.append("WHERE BL_SRC_NO = @[bl_src_no]" ).append("\n"); 
		query.append("AND AR_OFC_CD = @[ar_ofc_cd]" ).append("\n"); 
		query.append("AND NVL(INV_DELT_DIV_CD, 'N') <> 'Y')" ).append("\n"); 
		query.append("AND A.AR_OFC_CD = @[ar_ofc_cd]" ).append("\n"); 
		query.append("AND NVL(A.INV_DELT_DIV_CD, 'N') <> 'Y' ) T1," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT BL_SRC_NO," ).append("\n"); 
		query.append("SUM(SPL_AMT) INV_SPL_AMT," ).append("\n"); 
		query.append("SUM(TVA_AMT) INV_TVA_AMT" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT A.BL_SRC_NO," ).append("\n"); 
		query.append("DECODE(B.CHG_CD, 'TVA', 0, ROUND(B.CHG_AMT * B.INV_XCH_RT, 0)) SPL_AMT," ).append("\n"); 
		query.append("DECODE(B.CHG_CD, 'TVA', ROUND(B.CHG_AMT * B.INV_XCH_RT, 0), 0) TVA_AMT" ).append("\n"); 
		query.append("FROM INV_AR_MN A," ).append("\n"); 
		query.append("INV_AR_CHG B" ).append("\n"); 
		query.append("WHERE A.AR_IF_NO = B.AR_IF_NO" ).append("\n"); 
		query.append("AND A.BL_SRC_NO = @[bl_src_no]" ).append("\n"); 
		query.append("AND A.AR_OFC_CD = @[ar_ofc_cd]" ).append("\n"); 
		query.append("AND NVL(A.INV_DELT_DIV_CD, 'N') <> 'Y'" ).append("\n"); 
		query.append("AND B.INV_CLR_FLG = 'N')" ).append("\n"); 
		query.append("GROUP BY BL_SRC_NO) T2" ).append("\n"); 
		query.append("WHERE T1.BL_SRC_NO = T2.BL_SRC_NO (+)" ).append("\n"); 
		query.append("ORDER BY DATA_GB)" ).append("\n"); 
		query.append("WHERE ROWNUM = 1" ).append("\n"); 

	}
}