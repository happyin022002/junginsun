/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CSRIssueTransferSlipManageDBDAOSearchGwApprAgmtAttach2RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.15
*@LastModifier : DONG- IL, SHIN
*@LastVersion : 1.0
* 2014.12.15 DONG- IL, SHIN
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.invoicemanage.csrissuetranferslip.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author DONG- IL, SHIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CSRIssueTransferSlipManageDBDAOSearchGwApprAgmtAttach2RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GW Approval 관련 정보
	  * </pre>
	  */
	public CSRIssueTransferSlipManageDBDAOSearchGwApprAgmtAttach2RSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esd.trs.invoicemanage.csrissuetranferslip.integration").append("\n"); 
		query.append("FileName : CSRIssueTransferSlipManageDBDAOSearchGwApprAgmtAttach2RSQL").append("\n"); 
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
		query.append("SELECT  DISTINCT  AA.CSR_NO AS CSR_NO" ).append("\n"); 
		query.append("      , AA.INV_NO AS INV_NO" ).append("\n"); 
		query.append("      , AA.INV_VNDR_SEQ  AS VNDR_SEQ" ).append("\n"); 
		query.append("      , BB.AGMT_DOC_NO   AS L_ASSETCD" ).append("\n"); 
		query.append("      , BB.AGMT_DOC_DESC AS L_DOCUMENT_TITLE" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT A.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("              ,A.TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("              ,B.INV_NO" ).append("\n"); 
		query.append("              ,B.INV_VNDR_SEQ" ).append("\n"); 
		query.append("              ,B.CSR_NO" ).append("\n"); 
		query.append("          FROM TRS_TRSP_SVC_ORD A" ).append("\n"); 
		query.append("              ,TRS_TRSP_INV_WRK B" ).append("\n"); 
		query.append("         WHERE A.INV_NO = B.INV_NO" ).append("\n"); 
		query.append("           AND A.INV_VNDR_SEQ = B.INV_VNDR_SEQ" ).append("\n"); 
		query.append("           AND B.CSR_NO = @[csr_no]" ).append("\n"); 
		query.append("        GROUP BY A.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("                ,A.TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("                ,B.INV_NO" ).append("\n"); 
		query.append("                ,B.INV_VNDR_SEQ" ).append("\n"); 
		query.append("                ,B.CSR_NO" ).append("\n"); 
		query.append("        UNION" ).append("\n"); 
		query.append("        SELECT A.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("              ,A.TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("              ,B.INV_NO" ).append("\n"); 
		query.append("              ,B.INV_VNDR_SEQ" ).append("\n"); 
		query.append("              ,B.CSR_NO" ).append("\n"); 
		query.append("          FROM TRS_TRSP_RAIL_BIL_VNDR_SET A" ).append("\n"); 
		query.append("              ,TRS_TRSP_RAIL_INV_WRK      B" ).append("\n"); 
		query.append("         WHERE A.INV_NO = B.INV_NO" ).append("\n"); 
		query.append("           AND A.INV_VNDR_SEQ = B.INV_VNDR_SEQ" ).append("\n"); 
		query.append("           AND B.CSR_NO = @[csr_no]" ).append("\n"); 
		query.append("         GROUP BY A.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("                 ,A.TRSP_AGMT_SEQ " ).append("\n"); 
		query.append("                 ,B.INV_NO" ).append("\n"); 
		query.append("                 ,B.INV_VNDR_SEQ" ).append("\n"); 
		query.append("                 ,B.CSR_NO               " ).append("\n"); 
		query.append("       ) AA" ).append("\n"); 
		query.append("      , TRS_AGMT_CTRT_ATCH BB" ).append("\n"); 
		query.append(" WHERE AA.TRSP_AGMT_OFC_CTY_CD = BB.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("   AND AA.TRSP_AGMT_SEQ        = BB.TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("   --AND BB.AGMT_DOC_NO IS NOT NULL" ).append("\n"); 

	}
}