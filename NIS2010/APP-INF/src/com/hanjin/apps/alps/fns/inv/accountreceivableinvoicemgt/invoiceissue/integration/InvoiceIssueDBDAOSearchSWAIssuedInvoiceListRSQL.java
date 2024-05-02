/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : InvoiceIssueDBDAOSearchSWAIssuedInvoiceListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.22
*@LastModifier : 박정진
*@LastVersion : 1.0
* 2010.01.22 박정진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author JungJin, Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceIssueDBDAOSearchSWAIssuedInvoiceListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Invoice Main, Invoice Charge, Invoice Issue Detail, Invoice Issue Main, Customer 테이블에서 Select
	  * </pre>
	  */
	public InvoiceIssueDBDAOSearchSWAIssuedInvoiceListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("office",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("iss_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bl_src_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("iss_fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("iss_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_inv_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.integration").append("\n"); 
		query.append("FileName : InvoiceIssueDBDAOSearchSWAIssuedInvoiceListRSQL").append("\n"); 
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
		query.append("SELECT TB.ISS_DT," ).append("\n"); 
		query.append("  TB.INV_NO," ).append("\n"); 
		query.append("  TB.ACT_INV_NO," ).append("\n"); 
		query.append("  TB.BL_SRC_NO," ).append("\n"); 
		query.append("  TB.VVD," ).append("\n"); 
		query.append("  TB.CUSTOMER," ).append("\n"); 
		query.append("  TB.CUST_NM," ).append("\n"); 
		query.append("  SUM(ST.LCL_AMT) LCL_AMT," ).append("\n"); 
		query.append("  TB.CRE_USR_ID" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT " ).append("\n"); 
		query.append("#if ((${inv_no} == '') && (${bl_src_no} == ''))" ).append("\n"); 
		query.append("      /*+ USE_NL(C E) INDEX(A XAK1INV_AR_ISS) */" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("      A.ISS_DT," ).append("\n"); 
		query.append("      A.INV_NO," ).append("\n"); 
		query.append("      A.ACT_INV_NO," ).append("\n"); 
		query.append("      C.BL_SRC_NO," ).append("\n"); 
		query.append("      C.VSL_CD||C.SKD_VOY_NO||C.SKD_DIR_CD VVD," ).append("\n"); 
		query.append("      C.ACT_CUST_CNT_CD||'-'||LPAD(C.ACT_CUST_SEQ, 6, '0') CUSTOMER," ).append("\n"); 
		query.append("      NVL(E.CUST_LOCL_LANG_NM, E.CUST_LGL_ENG_NM) CUST_NM," ).append("\n"); 
		query.append("      A.CRE_USR_ID CRE_USR_ID" ).append("\n"); 
		query.append("    FROM INV_AR_ISS A," ).append("\n"); 
		query.append("      INV_AR_ISS_DTL B," ).append("\n"); 
		query.append("      INV_AR_MN C," ).append("\n"); 
		query.append("      MDM_CUSTOMER E" ).append("\n"); 
		query.append("    WHERE A.INV_NO = B.INV_NO" ).append("\n"); 
		query.append("      AND B.AR_IF_NO = C.AR_IF_NO" ).append("\n"); 
		query.append("      AND C.AR_OFC_CD = @[office]" ).append("\n"); 
		query.append("#if (${inv_no} != '')" ).append("\n"); 
		query.append("      AND A.INV_NO = @[inv_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bl_src_no} != '')" ).append("\n"); 
		query.append("      AND C.BL_SRC_NO = @[bl_src_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${iss_fm_dt} != '')" ).append("\n"); 
		query.append("      AND A.ISS_DT BETWEEN REPLACE(@[iss_fm_dt],'-','') AND REPLACE(@[iss_to_dt],'-','')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${iss_ofc_cd} != '')" ).append("\n"); 
		query.append("      AND A.ISS_OFC_CD = @[iss_ofc_cd]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("      AND A.ISS_OFC_CD IN (" ).append("\n"); 
		query.append("        SELECT OFC_CD" ).append("\n"); 
		query.append("        FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("        WHERE AR_OFC_CD = @[office])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("      AND A.INV_SEQ = 1" ).append("\n"); 
		query.append("#if (${cust_cnt_cd} != '')" ).append("\n"); 
		query.append("      AND C.ACT_CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cust_seq} != '')" ).append("\n"); 
		query.append("      AND C.ACT_CUST_SEQ = @[cust_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vvd} != '')" ).append("\n"); 
		query.append("      AND C.VSL_CD = SUBSTR(@[vvd],0,4)" ).append("\n"); 
		query.append("      AND C.SKD_VOY_NO = SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("      AND C.SKD_DIR_CD = SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${act_inv_no} != '')" ).append("\n"); 
		query.append("      AND A.ACT_INV_NO = @[act_inv_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${inv_type} != '')" ).append("\n"); 
		query.append("      ${inv_type}" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${usr_id} != '')" ).append("\n"); 
		query.append("      AND A.CRE_USR_ID = @[usr_id]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("      AND C.AR_IF_NO = (" ).append("\n"); 
		query.append("        SELECT MAX(S1.AR_IF_NO)" ).append("\n"); 
		query.append("        FROM INV_AR_MN S1" ).append("\n"); 
		query.append("        WHERE S1.AR_OFC_CD = C.AR_OFC_CD" ).append("\n"); 
		query.append("          AND S1.BL_SRC_NO = C.BL_SRC_NO" ).append("\n"); 
		query.append("          AND NVL(S1.INV_DELT_DIV_CD, 'N') <> 'Y'" ).append("\n"); 
		query.append("          AND EXISTS (" ).append("\n"); 
		query.append("            SELECT 'X'" ).append("\n"); 
		query.append("            FROM INV_AR_CHG S2," ).append("\n"); 
		query.append("              INV_AR_ISS_DTL S3" ).append("\n"); 
		query.append("            WHERE S1.AR_IF_NO = S2.AR_IF_NO" ).append("\n"); 
		query.append("              AND S2.AR_IF_NO = S3.AR_IF_NO" ).append("\n"); 
		query.append("              AND S2.CHG_SEQ = S3.CHG_SEQ" ).append("\n"); 
		query.append("              AND S3.INV_NO = A.INV_NO )" ).append("\n"); 
		query.append("          AND ROWNUM >= 1 )" ).append("\n"); 
		query.append("      AND C.ACT_CUST_CNT_CD = E.CUST_CNT_CD (+)" ).append("\n"); 
		query.append("      AND C.ACT_CUST_SEQ = E.CUST_SEQ (+)" ).append("\n"); 
		query.append("    GROUP BY A.ISS_DT, A.INV_NO, A.ACT_INV_NO, C.BL_SRC_NO, C.VSL_CD||C.SKD_VOY_NO||C.SKD_DIR_CD, C.ACT_CUST_CNT_CD||'-'||LPAD(C.ACT_CUST_SEQ, 6, '0'), NVL(E.CUST_LOCL_LANG_NM, E.CUST_LGL_ENG_NM), A.CRE_USR_ID ) TB," ).append("\n"); 
		query.append("  (" ).append("\n"); 
		query.append("    SELECT " ).append("\n"); 
		query.append("#if ((${inv_no} == '') && (${bl_src_no} == ''))" ).append("\n"); 
		query.append("      /*+ INDEX(A1 XAK1INV_AR_ISS) */" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("      A1.ISS_DT," ).append("\n"); 
		query.append("      A1.INV_NO," ).append("\n"); 
		query.append("      C1.BL_SRC_NO," ).append("\n"); 
		query.append("      SUM(D1.CHG_AMT) * D1.INV_XCH_RT LCL_AMT" ).append("\n"); 
		query.append("    FROM INV_AR_ISS A1," ).append("\n"); 
		query.append("      INV_AR_ISS_DTL B1," ).append("\n"); 
		query.append("      INV_AR_MN C1," ).append("\n"); 
		query.append("      INV_AR_CHG D1" ).append("\n"); 
		query.append("    WHERE A1.INV_NO = B1.INV_NO" ).append("\n"); 
		query.append("      AND B1.AR_IF_NO = C1.AR_IF_NO" ).append("\n"); 
		query.append("      AND B1.AR_IF_NO = D1.AR_IF_NO" ).append("\n"); 
		query.append("      AND B1.CHG_SEQ = D1.CHG_SEQ" ).append("\n"); 
		query.append("      AND C1.AR_IF_NO = D1.AR_IF_NO" ).append("\n"); 
		query.append("      AND C1.AR_OFC_CD = @[office]" ).append("\n"); 
		query.append("#if (${inv_no} != '')" ).append("\n"); 
		query.append("      AND A1.INV_NO = @[inv_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bl_src_no} != '')" ).append("\n"); 
		query.append("      AND C1.BL_SRC_NO = @[bl_src_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${iss_fm_dt} != '')" ).append("\n"); 
		query.append("      AND A1.ISS_DT BETWEEN REPLACE(@[iss_fm_dt],'-','') AND REPLACE(@[iss_to_dt],'-','')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${iss_ofc_cd} != '')" ).append("\n"); 
		query.append("      AND A1.ISS_OFC_CD = @[iss_ofc_cd]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("      AND A1.ISS_OFC_CD IN (" ).append("\n"); 
		query.append("        SELECT OFC_CD" ).append("\n"); 
		query.append("        FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("        WHERE AR_OFC_CD = @[office])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("      AND A1.INV_SEQ = 1" ).append("\n"); 
		query.append("#if (${cust_cnt_cd} != '')" ).append("\n"); 
		query.append("      AND C1.ACT_CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cust_seq} != '')" ).append("\n"); 
		query.append("      AND C1.ACT_CUST_SEQ = @[cust_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vvd} != '')" ).append("\n"); 
		query.append("      AND C1.VSL_CD = SUBSTR(@[vvd],0,4)" ).append("\n"); 
		query.append("      AND C1.SKD_VOY_NO = SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("      AND C1.SKD_DIR_CD = SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${act_inv_no} != '')" ).append("\n"); 
		query.append("      AND A1.ACT_INV_NO = @[act_inv_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${inv_type1} != '')" ).append("\n"); 
		query.append("      ${inv_type1}" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${usr_id} != '')" ).append("\n"); 
		query.append("      AND A1.CRE_USR_ID = @[usr_id]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("    GROUP BY A1.ISS_DT, A1.INV_NO, C1.BL_SRC_NO, D1.INV_XCH_RT) ST" ).append("\n"); 
		query.append("WHERE TB.ISS_DT = ST.ISS_DT" ).append("\n"); 
		query.append("  AND TB.INV_NO = ST.INV_NO" ).append("\n"); 
		query.append("  AND TB.BL_SRC_NO = ST.BL_SRC_NO" ).append("\n"); 
		query.append("GROUP BY TB.ISS_DT, TB.INV_NO, TB.ACT_INV_NO, TB.BL_SRC_NO, TB.VVD, TB.CUSTOMER, TB.CUST_NM, TB.CRE_USR_ID" ).append("\n"); 
		query.append("ORDER BY TB.ISS_DT, TB.INV_NO, TB.ACT_INV_NO, TB.BL_SRC_NO" ).append("\n"); 

	}
}