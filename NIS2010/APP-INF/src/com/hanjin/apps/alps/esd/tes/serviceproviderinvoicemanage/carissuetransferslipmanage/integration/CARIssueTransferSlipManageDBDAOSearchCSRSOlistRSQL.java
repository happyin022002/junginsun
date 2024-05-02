/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CARIssueTransferSlipManageDBDAOSearchCSRSOlistRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.07
*@LastModifier : 
*@LastVersion : 1.0
* 2015.01.07 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CARIssueTransferSlipManageDBDAOSearchCSRSOlistRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchCSRSOlist
	  * </pre>
	  */
	public CARIssueTransferSlipManageDBDAOSearchCSRSOlistRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("csr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.integration").append("\n"); 
		query.append("FileName : CARIssueTransferSlipManageDBDAOSearchCSRSOlistRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append(" T.TML_SO_OFC_CTY_CD, T.TML_SO_SEQ, A.AFT_ACT_FLG," ).append("\n"); 
		query.append(" CASE" ).append("\n"); 
		query.append(" WHEN T.TML_INV_STS_CD='C' AND T.TML_INV_RJCT_STS_CD='RJ' THEN 0" ).append("\n"); 
		query.append(" WHEN T.TML_INV_STS_CD='R' AND T.TML_INV_RJCT_STS_CD='RJ' THEN 1" ).append("\n"); 
		query.append(" ELSE 0" ).append("\n"); 
		query.append(" END CHK," ).append("\n"); 
		query.append(" T.INV_NO, NVL(T.TTL_INV_AMT,0) TTL_INV_AMT, NVL(T.VAT_AMT,0) VAT_AMT, NVL(T.WHLD_TAX_AMT,0) WHLD_TAX_AMT," ).append("\n"); 
		query.append(" NVL(T.TTL_INV_AMT,0) + NVL(T.VAT_AMT,0) - NVL(T.WHLD_TAX_AMT,0) TOTAL_AMT, TO_CHAR(T.ISS_DT,'YYYY-MM-DD') ISS_DT, TO_CHAR(T.RCV_DT,'YYYY-MM-DD') RCV_DT," ).append("\n"); 
		query.append(" TO_CHAR(T.INV_CFM_DT,'YYYY-MM-DD') INV_CFM_DT" ).append("\n"); 
		query.append(", T.EDI_FLG, " ).append("\n"); 
		query.append("NVL(" ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN T.EDI_FLG = 'Y'" ).append("\n"); 
		query.append("THEN  (" ).append("\n"); 
		query.append("    SELECT " ).append("\n"); 
		query.append("        CASE" ).append("\n"); 
		query.append("        WHEN F.FILE_SEQ IS NOT NULL AND F.ORG_FILE_NM IS NOT NULL AND F.FILE_SAV_ID IS NOT NULL AND C.FILE_SAV_ID IS NOT NULL" ).append("\n"); 
		query.append("        THEN 'Y'" ).append("\n"); 
		query.append("        ELSE 'N'" ).append("\n"); 
		query.append("        END FILE_CHK" ).append("\n"); 
		query.append("    FROM TES_EDI_SO_HDR E, TES_EDI_SO_FILE F, COM_UPLD_FILE C" ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("    AND E.TML_SO_OFC_CTY_CD = T.TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("    AND E.TML_SO_SEQ = T.TML_SO_SEQ" ).append("\n"); 
		query.append("    AND NVL(E.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("    AND ((E.TML_EDI_SO_OFC_CTY_CD = F.TML_EDI_SO_OFC_CTY_CD AND E.TML_EDI_SO_SEQ = F.TML_EDI_SO_SEQ)" ).append("\n"); 
		query.append("		OR" ).append("\n"); 
		query.append("		 (E.TML_SO_OFC_CTY_CD = F.TML_SO_OFC_CTY_CD AND E.TML_SO_SEQ = F.TML_SO_SEQ))" ).append("\n"); 
		query.append("    AND NVL(F.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("    AND F.FILE_SAV_ID = C.FILE_SAV_ID" ).append("\n"); 
		query.append("    AND NVL(C.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("	AND ROWNUM = 1" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("ELSE 'N'" ).append("\n"); 
		query.append("END,'N') FILE_CHK, T.YD_CD" ).append("\n"); 
		query.append(" FROM TES_TML_SO_HDR T, AP_INV_HDR A" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append(" AND T.CSR_NO = A.CSR_NO" ).append("\n"); 
		query.append(" AND T.CSR_NO = @[csr_no]" ).append("\n"); 
		query.append(" AND NVL(T.DELT_FLG,'N') <> 'Y'" ).append("\n"); 

	}
}