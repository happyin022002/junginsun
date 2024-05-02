/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TESInvoiceCommonDBDAOSearchOldCsrExistChkRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.11.18
*@LastModifier : 
*@LastVersion : 1.0
* 2010.11.18 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tes.common.tesinvoicecommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TESInvoiceCommonDBDAOSearchOldCsrExistChkRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CSR이 만들어진 후 3개월이 경과한 건이 있는지 check하는 조회
	  * </pre>
	  */
	public TESInvoiceCommonDBDAOSearchOldCsrExistChkRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.tes.common.tesinvoicecommon.integration").append("\n"); 
		query.append("FileName : TESInvoiceCommonDBDAOSearchOldCsrExistChkRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT DECODE( SIGN(COUNT(0)), 1, 'Y', 'N') AS CSR_EXIST_CHK" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT TO_CHAR(A.CRE_DT, 'YYYY.MM.DD') CRE_DT," ).append("\n"); 
		query.append("            A.CRE_USR_ID," ).append("\n"); 
		query.append("            A.CSR_NO," ).append("\n"); 
		query.append("            H.INV_OFC_CD," ).append("\n"); 
		query.append("            A.CSR_CURR_CD," ).append("\n"); 
		query.append("            A.CSR_AMT," ).append("\n"); 
		query.append("            A.VNDR_NO," ).append("\n"); 
		query.append("            CASE WHEN A.RCV_ERR_FLG = 'E' THEN 'A/P Rejected' " ).append("\n"); 
		query.append("                 WHEN A.IF_FLG = 'E' AND H.TML_INV_RJCT_STS_CD <> 'RJ' THEN 'I/F Error' " ).append("\n"); 
		query.append("                 WHEN H.TML_INV_RJCT_STS_CD = 'RJ' AND NVL(A.APRO_FLG, 'N') = 'N' THEN 'Disapproved' " ).append("\n"); 
		query.append("                 WHEN A.IF_FLG IS NULL AND TML_INV_STS_CD='A' THEN DECODE(A.APRO_FLG, 'Y', 'Sending', 'Approval Requested') " ).append("\n"); 
		query.append("            END IF_STATUS" ).append("\n"); 
		query.append("    FROM TES_TML_SO_HDR H," ).append("\n"); 
		query.append("         AP_INV_HDR A," ).append("\n"); 
		query.append("         MDM_ORGANIZATION M" ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("      AND H.CSR_NO = A.CSR_NO" ).append("\n"); 
		query.append("      AND H.INV_OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("      AND NVL(H.DELT_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append("      AND H.TML_INV_STS_CD IN ('A','P')" ).append("\n"); 
		query.append("      AND A.SRC_CTNT = 'SO_TERMINAL'" ).append("\n"); 
		query.append("      AND A.CRE_DT < SYSDATE-90" ).append("\n"); 
		query.append("      AND A.AFT_ACT_FLG IS NULL" ).append("\n"); 
		query.append("      AND M.OFC_CD = H.INV_OFC_CD" ).append("\n"); 
		query.append("      AND M.OFC_KND_CD IN ('3','4','5','6','9')" ).append("\n"); 
		query.append(") B" ).append("\n"); 
		query.append("GROUP BY B.INV_OFC_CD, B.CSR_NO, B.CSR_CURR_CD, B.CSR_AMT, B.VNDR_NO, B.CRE_DT, B.CRE_USR_ID, B.IF_STATUS" ).append("\n"); 
		query.append("HAVING B.IF_STATUS IS NOT NULL" ).append("\n"); 

	}
}