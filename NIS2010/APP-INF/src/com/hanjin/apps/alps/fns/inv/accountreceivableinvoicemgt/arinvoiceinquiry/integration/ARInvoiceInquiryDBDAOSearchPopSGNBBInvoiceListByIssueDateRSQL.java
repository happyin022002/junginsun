/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ARInvoiceInquiryDBDAOSearchPopSGNBBInvoiceListByIssueDateRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.24
*@LastModifier : 
*@LastVersion : 1.0
* 2010.03.24 
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

public class ARInvoiceInquiryDBDAOSearchPopSGNBBInvoiceListByIssueDateRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public ARInvoiceInquiryDBDAOSearchPopSGNBBInvoiceListByIssueDateRSQL(){
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
		params.put("iss_fm_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cust_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.integration").append("\n"); 
		query.append("FileName : ARInvoiceInquiryDBDAOSearchPopSGNBBInvoiceListByIssueDateRSQL").append("\n"); 
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
		query.append("SELECT TB.BL_SRC_NO," ).append("\n"); 
		query.append("  TB.INV_NO," ).append("\n"); 
		query.append("  TB.ACT_INV_NO," ).append("\n"); 
		query.append("  TB.VVD," ).append("\n"); 
		query.append("  TB.INV_TYPE," ).append("\n"); 
		query.append("  TB.CUSTOMER," ).append("\n"); 
		query.append("  TB.ISS_DT," ).append("\n"); 
		query.append("  SUM(ST.LCL_AMT) LCL_AMT," ).append("\n"); 
		query.append("  TB.CRE_USR_ID" ).append("\n"); 
		query.append("  --TB.UPD_DT" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT D.BL_SRC_NO," ).append("\n"); 
		query.append("      A.INV_NO," ).append("\n"); 
		query.append("      A.ACT_INV_NO," ).append("\n"); 
		query.append("      D.VSL_CD||D.SKD_VOY_NO||D.SKD_DIR_CD VVD," ).append("\n"); 
		query.append("      DECODE (SUBSTR(A.INV_NO, 0, 1), 'F', 'FRT', 'T', 'THC', 'H', 'DHF', 'D', 'DMR', 'R', 'M&R', 'M', 'MRI', 'S', 'SLF', 'C', 'CLN') INV_TYPE," ).append("\n"); 
		query.append("      D.ACT_CUST_CNT_CD||'-'||LPAD(D.ACT_CUST_SEQ, 6, '0') CUSTOMER," ).append("\n"); 
		query.append("      A.ISS_DT," ).append("\n"); 
		query.append("      A.CRE_USR_ID," ).append("\n"); 
		query.append("      A.UPD_DT" ).append("\n"); 
		query.append("    FROM INV_AR_ISS A," ).append("\n"); 
		query.append("      INV_AR_ISS_DTL B," ).append("\n"); 
		query.append("      INV_AR_MN D" ).append("\n"); 
		query.append("    WHERE A.INV_NO = B.INV_NO" ).append("\n"); 
		query.append("      AND B.AR_IF_NO = D.AR_IF_NO" ).append("\n"); 
		query.append("#if (${iss_fm_dt} != '')" ).append("\n"); 
		query.append("  AND A.ISS_DT BETWEEN REPLACE(@[iss_fm_dt],'-','') AND REPLACE(@[iss_to_dt],'-','')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("  AND A.ISS_OFC_CD IN (" ).append("\n"); 
		query.append("    SELECT OFC_CD" ).append("\n"); 
		query.append("    FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("    WHERE AR_OFC_CD = @[office])" ).append("\n"); 
		query.append("  AND A.INV_SEQ = 1" ).append("\n"); 
		query.append("  AND D.AR_OFC_CD = @[office]" ).append("\n"); 
		query.append("  AND D.AR_IF_NO = (" ).append("\n"); 
		query.append("    SELECT MAX(S1.AR_IF_NO)" ).append("\n"); 
		query.append("    FROM INV_AR_MN S1," ).append("\n"); 
		query.append("      INV_AR_CHG S2," ).append("\n"); 
		query.append("      INV_AR_ISS_DTL S3" ).append("\n"); 
		query.append("    WHERE S1.AR_IF_NO = S2.AR_IF_NO" ).append("\n"); 
		query.append("      AND S2.AR_IF_NO = S3.AR_IF_NO" ).append("\n"); 
		query.append("      AND S2.CHG_SEQ = S3.CHG_SEQ" ).append("\n"); 
		query.append("      AND S1.AR_OFC_CD = D.AR_OFC_CD" ).append("\n"); 
		query.append("      AND S1.BL_SRC_NO = D.BL_SRC_NO" ).append("\n"); 
		query.append("      AND S3.INV_NO = A.INV_NO" ).append("\n"); 
		query.append("      AND NVL(S1.INV_DELT_DIV_CD, 'N') <> 'Y')" ).append("\n"); 
		query.append("#if (${bl_src_no} != '')" ).append("\n"); 
		query.append("      AND D.BL_SRC_NO = @[bl_src_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${inv_no} != '')" ).append("\n"); 
		query.append("      AND A.INV_NO = @[inv_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${act_inv_no} != '')" ).append("\n"); 
		query.append("      AND A.ACT_INV_NO = @[act_inv_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${inv_type} != '' && ${inv_type} != ' ')" ).append("\n"); 
		query.append("	AND (A.INV_NO = '111'" ).append("\n"); 
		query.append("	#if (${inv_type1} == 'F')" ).append("\n"); 
		query.append("      OR A.INV_NO LIKE 'F%'" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${inv_type2} == 'T')" ).append("\n"); 
		query.append("      OR A.INV_NO LIKE 'T%'" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${inv_type3} == 'H')" ).append("\n"); 
		query.append("      OR A.INV_NO LIKE 'H%'" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${inv_type4} == 'D')" ).append("\n"); 
		query.append("      OR A.INV_NO LIKE 'D%'" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${inv_type5} == 'R')" ).append("\n"); 
		query.append("      OR A.INV_NO LIKE 'R%'" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${inv_type6} == 'M')" ).append("\n"); 
		query.append("      OR A.INV_NO LIKE 'M%'" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${inv_type7} == 'S')" ).append("\n"); 
		query.append("      OR A.INV_NO LIKE 'S%'" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${inv_type8} == 'C')" ).append("\n"); 
		query.append("      OR A.INV_NO LIKE 'C%'" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cust_cnt_cd} != '')" ).append("\n"); 
		query.append("      AND D.ACT_CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cust_seq} != '')" ).append("\n"); 
		query.append("      AND D.ACT_CUST_SEQ = @[cust_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${usr_id} != '')" ).append("\n"); 
		query.append("      AND A.CRE_USR_ID = @[usr_id]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("      AND NVL(D.INV_DELT_DIV_CD, 'N') <> 'Y'" ).append("\n"); 
		query.append("    GROUP BY D.BL_SRC_NO, A.INV_NO, A.ACT_INV_NO, D.VSL_CD, D.SKD_VOY_NO, D.SKD_DIR_CD, D.ACT_CUST_CNT_CD, D.ACT_CUST_SEQ, A.ISS_DT, A.CRE_USR_ID, A.UPD_DT ) TB," ).append("\n"); 
		query.append("  (" ).append("\n"); 
		query.append("    SELECT A1.INV_NO," ).append("\n"); 
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
		query.append("#if (${iss_fm_dt} != '')" ).append("\n"); 
		query.append("      AND A1.ISS_DT BETWEEN REPLACE(@[iss_fm_dt],'-','') AND REPLACE(@[iss_to_dt],'-','')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("      AND A1.ISS_OFC_CD IN (" ).append("\n"); 
		query.append("        SELECT OFC_CD" ).append("\n"); 
		query.append("        FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("        WHERE AR_OFC_CD = @[office])" ).append("\n"); 
		query.append("      AND A1.INV_SEQ = 1" ).append("\n"); 
		query.append("      AND C1.AR_OFC_CD = @[office]" ).append("\n"); 
		query.append("#if (${bl_src_no} != '')" ).append("\n"); 
		query.append("      AND C1.BL_SRC_NO = @[bl_src_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${inv_no} != '')" ).append("\n"); 
		query.append("      AND A1.INV_NO = @[inv_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${act_inv_no} != '')" ).append("\n"); 
		query.append("      AND A1.ACT_INV_NO = @[act_inv_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${inv_type} != '' && ${inv_type} != ' ')" ).append("\n"); 
		query.append("	AND (A1.INV_NO = '111'" ).append("\n"); 
		query.append("	#if (${inv_type1} == 'F')" ).append("\n"); 
		query.append("      OR A1.INV_NO LIKE 'F%'" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${inv_type2} == 'T')" ).append("\n"); 
		query.append("      OR A1.INV_NO LIKE 'T%'" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${inv_type3} == 'H')" ).append("\n"); 
		query.append("      OR A1.INV_NO LIKE 'H%'" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${inv_type4} == 'D')" ).append("\n"); 
		query.append("      OR A1.INV_NO LIKE 'D%'" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${inv_type5} == 'R')" ).append("\n"); 
		query.append("      OR A1.INV_NO LIKE 'R%'" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${inv_type6} == 'M')" ).append("\n"); 
		query.append("      OR A1.INV_NO LIKE 'M%'" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${inv_type7} == 'S')" ).append("\n"); 
		query.append("      OR A1.INV_NO LIKE 'S%'" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${inv_type8} == 'C')" ).append("\n"); 
		query.append("      OR A1.INV_NO LIKE 'C%'" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cust_cnt_cd} != '')" ).append("\n"); 
		query.append("      AND C1.ACT_CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cust_seq} != '')" ).append("\n"); 
		query.append("      AND C1.ACT_CUST_SEQ = @[cust_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${usr_id} != '')" ).append("\n"); 
		query.append("      AND A1.CRE_USR_ID = @[usr_id]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("    GROUP BY A1.ISS_DT, A1.INV_NO, A1.ACT_INV_NO, C1.BL_SRC_NO, C1.VSL_CD||C1.SKD_VOY_NO||C1.SKD_DIR_CD, C1.ACT_CUST_CNT_CD||'-'||LPAD(C1.ACT_CUST_SEQ, 6, '0'), D1.INV_XCH_RT) ST" ).append("\n"); 
		query.append("WHERE TB.BL_SRC_NO = ST.BL_SRC_NO" ).append("\n"); 
		query.append("  AND TB.INV_NO = ST.INV_NO" ).append("\n"); 
		query.append("GROUP BY TB.BL_SRC_NO, TB.INV_NO, TB.ACT_INV_NO, TB.VVD, TB.INV_TYPE, TB.CUSTOMER, TB.ISS_DT, TB.CRE_USR_ID, TB.UPD_DT" ).append("\n"); 
		query.append("ORDER BY TB.UPD_DT, TB.BL_SRC_NO, TB.INV_NO" ).append("\n"); 

	}
}