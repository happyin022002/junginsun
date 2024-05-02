/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : InvoiceIssueDBDAOSearchKORIssueTargetByBLRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.18
*@LastModifier : 한동훈
*@LastVersion : 1.0
* 2010.05.18 한동훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author donghoon han
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceIssueDBDAOSearchKORIssueTargetByBLRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * B/L NO 입력하고 TAB 또는 FOCUS 이동 시 CUSTOMER 테이블에서 CUSTOMER 정보를 SELECT 한다.
	  * </pre>
	  */
	public InvoiceIssueDBDAOSearchKORIssueTargetByBLRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_src_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.integration").append("\n"); 
		query.append("FileName : InvoiceIssueDBDAOSearchKORIssueTargetByBLRSQL").append("\n"); 
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
		query.append("SELECT A.AR_OFC_CD," ).append("\n"); 
		query.append("  A.ACT_CUST_CNT_CD," ).append("\n"); 
		query.append("  LPAD(A.ACT_CUST_SEQ, 6, '0') ACT_CUST_SEQ," ).append("\n"); 
		query.append("  C.CUST_LGL_ENG_NM LOCL_NM," ).append("\n"); 
		query.append("  C.CUST_RGST_NO," ).append("\n"); 
		query.append("  C.INDIV_CORP_DIV_CD," ).append("\n"); 
		query.append("  B.ISS_DIV_CD," ).append("\n"); 
		query.append("  B.CNTC_PSON_NM," ).append("\n"); 
		query.append("  TRIM(B.LOCL_ADDR1)||CASE WHEN B.LOCL_ADDR2 IS NOT NULL THEN ' '||TRIM(B.LOCL_ADDR2) ELSE '' END||CASE WHEN B.LOCL_ADDR3 IS NOT NULL THEN ' '||TRIM(B.LOCL_ADDR3) ELSE '' END LOCL_ADDR," ).append("\n"); 
		query.append("  B.BZCT_NM," ).append("\n"); 
		query.append("  B.BZTP_NM," ).append("\n"); 
		query.append("  '' INV_RMK," ).append("\n"); 
		query.append("  NVL(DECODE(A.IO_BND_CD, 'O', B.OB_FAX_NO, 'I', B.IB_FAX_NO), '') CUST_FAX_NO," ).append("\n"); 
		query.append("  NVL(DECODE(A.IO_BND_CD, 'O', B.OB_EML, 'I', B.IB_EML), '') CUST_EML" ).append("\n"); 
		query.append("FROM INV_AR_MN A," ).append("\n"); 
		query.append("  MDM_CR_CUST B," ).append("\n"); 
		query.append("  MDM_CUSTOMER C" ).append("\n"); 
		query.append("WHERE A.ACT_CUST_CNT_CD = B.CUST_CNT_CD (+)" ).append("\n"); 
		query.append("  AND A.ACT_CUST_SEQ = B.CUST_SEQ (+)" ).append("\n"); 
		query.append("  AND A.ACT_CUST_CNT_CD = C.CUST_CNT_CD" ).append("\n"); 
		query.append("  AND A.ACT_CUST_SEQ = C.CUST_SEQ" ).append("\n"); 
		query.append("  AND A.AR_IF_NO = (" ).append("\n"); 
		query.append("    SELECT AR_IF_NO FROM (" ).append("\n"); 
		query.append("        SELECT AR_IF_NO, CRE_DT" ).append("\n"); 
		query.append("        FROM INV_AR_MN" ).append("\n"); 
		query.append("        WHERE BL_SRC_NO = @[bl_src_no]" ).append("\n"); 
		query.append("          AND AR_OFC_CD IN (" ).append("\n"); 
		query.append("			SELECT DISTINCT A.AR_OFC_CD" ).append("\n"); 
		query.append("            FROM MDM_ORGANIZATION A, MDM_LOCATION B, INV_AR_MN C" ).append("\n"); 
		query.append("            WHERE A.LOC_CD = B.LOC_CD" ).append("\n"); 
		query.append("              AND B.CNT_CD = 'KR'" ).append("\n"); 
		query.append("              AND A.OFC_CD = C.AR_OFC_CD" ).append("\n"); 
		query.append("              AND C.BL_SRC_NO = @[bl_src_no]" ).append("\n"); 
		query.append("              AND A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("              AND A.AR_OFC_CD IS NOT NULL )" ).append("\n"); 
		query.append("          AND NVL(INV_DELT_DIV_CD, 'N') <> 'Y'" ).append("\n"); 
		query.append("          ORDER BY CRE_DT DESC, AR_IF_NO DESC" ).append("\n"); 
		query.append("      ) WHERE ROWNUM = 1)" ).append("\n"); 
		query.append("  AND NVL(A.INV_DELT_DIV_CD, 'N') <> 'Y'" ).append("\n"); 

	}
}