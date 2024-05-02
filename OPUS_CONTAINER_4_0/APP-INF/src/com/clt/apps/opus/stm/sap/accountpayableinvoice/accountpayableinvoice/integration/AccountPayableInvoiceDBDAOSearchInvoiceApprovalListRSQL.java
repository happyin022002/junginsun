/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AccountPayableInvoiceDBDAOSearchInvoiceApprovalListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.27
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.27 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountPayableInvoiceDBDAOSearchInvoiceApprovalListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CSR Approval List - Retrieve
	  * </pre>
	  */
	public AccountPayableInvoiceDBDAOSearchInvoiceApprovalListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vndr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.integration").append("\n"); 
		query.append("FileName : AccountPayableInvoiceDBDAOSearchInvoiceApprovalListRSQL").append("\n"); 
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
		query.append("SELECT  SIH.OFC_CD                  AS OFC_CD" ).append("\n"); 
		query.append("      , SIH.INV_NO                  AS INV_NO" ).append("\n"); 
		query.append("      , SIH.INV_SEQ                 AS INV_SEQ" ).append("\n"); 
		query.append("      , SIH.VNDR_NO                 AS VNDR_NO" ).append("\n"); 
		query.append("      , MV.VNDR_LGL_ENG_NM          AS VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("      , SIH.GL_DT                   AS GL_DT" ).append("\n"); 
		query.append("      , SIH.INV_DT                  AS INV_DT" ).append("\n"); 
		query.append("      , SIH.CRE_DT                  AS CTE_DT" ).append("\n"); 
		query.append("      , SIH.ATTR_CTNT12             AS PROCESSING_FLAG" ).append("\n"); 
		query.append("      , SIH.ATTR_CTNT15             AS APPROVAL_FLAG" ).append("\n"); 
		query.append("      , SIH.INV_CURR_CD             AS INV_CURR_CD" ).append("\n"); 
		query.append("      , TRIM(OPUSADM.SAP_GET_CUR_AMT_FNC(SIH.INV_CURR_CD, SIH.INV_AMT)) AS INV_AMT" ).append("\n"); 
		query.append("      , SIH.ATTR_CATE_NM            AS ATTR_CATE_NM" ).append("\n"); 
		query.append("      , CU.USR_NM                   AS USR_NM" ).append("\n"); 
		query.append("      , SIH.INV_DESC                AS INV_DESC" ).append("\n"); 
		query.append("      , SIH.CRE_USR_ID              AS CRE_USR_ID" ).append("\n"); 
		query.append("      , SIH.UPD_USR_ID              AS UPD_USR_ID" ).append("\n"); 
		query.append("      , SIH.AP_INV_SRC_CD           AS AP_INV_SRC_CD" ).append("\n"); 
		query.append("      , SPS.DUE_DT                  AS DUE_DATE" ).append("\n"); 
		query.append("FROM    SAP_INV_HDR SIH" ).append("\n"); 
		query.append("      , MDM_VENDOR MV" ).append("\n"); 
		query.append("      , COM_USER CU" ).append("\n"); 
		query.append("      , MDM_ORGANIZATION MO" ).append("\n"); 
		query.append("      , SAP_PAY_SKD SPS" ).append("\n"); 
		query.append("WHERE   1 = 1" ).append("\n"); 
		query.append("AND     SIH.VNDR_NO = TO_CHAR(MV.VNDR_SEQ)" ).append("\n"); 
		query.append("AND     SIH.CRE_USR_ID = CU.USR_ID" ).append("\n"); 
		query.append("AND     SIH.OFC_CD = MO.OFC_CD " ).append("\n"); 
		query.append("AND     SIH.INV_SEQ IS NOT NULL" ).append("\n"); 
		query.append("AND     SPS.INV_SEQ = SIH.INV_SEQ" ).append("\n"); 
		query.append("AND     SPS.ROWID = (SELECT MAX(SPS2.ROWID) FROM SAP_PAY_SKD SPS2 WHERE SPS2.INV_SEQ = SIH.INV_SEQ)" ).append("\n"); 
		query.append("AND     NVL(SPS.INV_HLD_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append("AND     (SIH.ATTR_CTNT15 <> 'Y' OR SIH.ATTR_CTNT15 IS NULL)" ).append("\n"); 
		query.append("AND     SIH.ATTR_CTNT12 IS NOT NULL" ).append("\n"); 
		query.append("AND     SIH.AP_APSTS_CD <> 'MANUALLY APPROVED'" ).append("\n"); 
		query.append("AND     SIH.INV_CXL_DT IS NULL" ).append("\n"); 
		query.append("AND     EXISTS (SELECT 'A' FROM SAP_INV_DTL SID WHERE SIH.INV_SEQ = SID.INV_SEQ AND SID.MTCH_STS_FLG = 'A')" ).append("\n"); 
		query.append("AND     SIH.OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("AND     SIH.CRE_DT < TO_DATE(@[cre_dt], 'YYYY-MM-DD') + 1" ).append("\n"); 
		query.append("#if (${vndr_no} != '') " ).append("\n"); 
		query.append("AND     SIH.VNDR_NO = @[vndr_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${inv_no} != '') " ).append("\n"); 
		query.append("AND     SIH.INV_NO = @[inv_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}