/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : InvoiceIssueCollectionMgtDBDAOSearchManualInvoiceMainListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.19
*@LastModifier : 
*@LastVersion : 1.0
* 2010.01.19 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceIssueCollectionMgtDBDAOSearchManualInvoiceMainListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Invoice No. 로 Invoice Main 정보를 조회하는 쿼리
	  * </pre>
	  */
	public InvoiceIssueCollectionMgtDBDAOSearchManualInvoiceMainListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_inv_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration").append("\n"); 
		query.append("FileName : InvoiceIssueCollectionMgtDBDAOSearchManualInvoiceMainListRSQL").append("\n"); 
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
		query.append("SELECT	INV_MN.DMDT_INV_NO" ).append("\n"); 
		query.append(",	TO_CHAR(INV_MN.CRE_DT, 'YYYY-MM-DD') AS ISSUE_DT" ).append("\n"); 
		query.append(",	INV_MN.CRE_OFC_CD AS ISSUE_OFC_CD" ).append("\n"); 
		query.append(",	USER_A.USR_NM AS ISSUE_USR_NM" ).append("\n"); 
		query.append(",	(" ).append("\n"); 
		query.append("SELECT	SUBSTR(LOC_CD,0,2)" ).append("\n"); 
		query.append("FROM 	MDM_ORGANIZATION" ).append("\n"); 
		query.append("WHERE 	OFC_CD = INV_MN.CRE_OFC_CD" ).append("\n"); 
		query.append(") AS CRE_CNT_CD" ).append("\n"); 
		query.append(",	INV_MN.DMDT_INV_STS_CD" ).append("\n"); 
		query.append(",	(" ).append("\n"); 
		query.append("SELECT	INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("FROM 	COM_INTG_CD_DTL" ).append("\n"); 
		query.append("WHERE 	INTG_CD_ID = 'CD01974'" ).append("\n"); 
		query.append("AND INTG_CD_VAL_CTNT = INV_MN.DMDT_INV_STS_CD" ).append("\n"); 
		query.append(") AS DMDT_INV_STS_DESC" ).append("\n"); 
		query.append(",	INV_MN.DMDT_AR_IF_CD" ).append("\n"); 
		query.append(",	TO_CHAR(INV_MN.AR_IF_DT, 'YYYY-MM-DD') AS AR_IF_DT" ).append("\n"); 
		query.append(",	INV_MN.AR_IF_OFC_CD" ).append("\n"); 
		query.append(",	INV_MN.AR_IF_USR_ID" ).append("\n"); 
		query.append(",	USER_B.USR_NM AS AR_IF_USR_NM" ).append("\n"); 
		query.append(",	INV_MN.CR_INV_NO" ).append("\n"); 
		query.append(",	(" ).append("\n"); 
		query.append("SELECT	DMDT_AR_IF_CD" ).append("\n"); 
		query.append("FROM	DMT_INV_MN" ).append("\n"); 
		query.append("WHERE	DMDT_INV_NO = INV_MN.CR_INV_NO" ).append("\n"); 
		query.append("AND CRE_OFC_CD = INV_MN.CRE_OFC_CD" ).append("\n"); 
		query.append(") AS CR_AR_IF_CD" ).append("\n"); 
		query.append(",	INV_MN.BKG_NO" ).append("\n"); 
		query.append(",	INV_MN.BL_NO" ).append("\n"); 
		query.append(",	INV_MN.DMDT_TRF_CD" ).append("\n"); 
		query.append(",	INV_MN.IO_BND_CD" ).append("\n"); 
		query.append(",	INV_MN.MNL_INV_SND_FLG" ).append("\n"); 
		query.append(",	INV_MN.VSL_CD || INV_MN.SKD_VOY_NO || INV_MN.SKD_DIR_CD AS VVD_CD" ).append("\n"); 
		query.append(",	INV_MN.POR_CD" ).append("\n"); 
		query.append(",	INV_MN.POL_CD" ).append("\n"); 
		query.append(",	INV_MN.POD_CD" ).append("\n"); 
		query.append(",	INV_MN.DEL_CD" ).append("\n"); 
		query.append(",	INV_MN.BKG_RCV_TERM_CD AS RCV_TERM_CD" ).append("\n"); 
		query.append(",	INV_MN.BKG_DE_TERM_CD AS DE_TERM_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",	CASE" ).append("\n"); 
		query.append("WHEN DECODE(INV_MN.ACT_PAYR_CNT_CD, '00', '', INV_MN.ACT_PAYR_CNT_CD) || LPAD(INV_MN.ACT_PAYR_SEQ, 6, '0') = '000000'" ).append("\n"); 
		query.append("THEN ''" ).append("\n"); 
		query.append("ELSE DECODE(INV_MN.ACT_PAYR_CNT_CD, '00', '', INV_MN.ACT_PAYR_CNT_CD) || LPAD(INV_MN.ACT_PAYR_SEQ, 6, '0')" ).append("\n"); 
		query.append("END AS ACT_PAYR_CUST_CD" ).append("\n"); 
		query.append(",	(" ).append("\n"); 
		query.append("SELECT	DECODE(NVL(CUST.CUST_LGL_ENG_NM, ''), '', VNDR.VNDR_LGL_ENG_NM, CUST.CUST_LGL_ENG_NM)" ).append("\n"); 
		query.append("FROM	DMT_INV_MN A, MDM_CUSTOMER CUST, MDM_VENDOR VNDR" ).append("\n"); 
		query.append("WHERE	A.DMDT_INV_NO		= INV_MN.DMDT_INV_NO" ).append("\n"); 
		query.append("AND A.ACT_PAYR_CNT_CD 	= CUST.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("AND	A.ACT_PAYR_SEQ		= CUST.CUST_SEQ(+)" ).append("\n"); 
		query.append("AND A.ACT_PAYR_SEQ		= VNDR.VNDR_SEQ(+)" ).append("\n"); 
		query.append(") AS ACT_PAYR_CUST_NM" ).append("\n"); 
		query.append(",	INV_MN.DMDT_PAYR_CNTC_PNT_NM" ).append("\n"); 
		query.append(",	CASE WHEN INSTRB(INV_MN.INV_RMK, chr(10), 1, 1) = 0" ).append("\n"); 
		query.append("THEN SUBSTRB(INV_MN.INV_RMK, INSTRB(INV_MN.INV_RMK, chr(10), -1, 1) + 1)" ).append("\n"); 
		query.append("ELSE SUBSTRB(INV_MN.INV_RMK, 0, INSTRB(INV_MN.INV_RMK, chr(10), 1, 1))" ).append("\n"); 
		query.append("END INV_RMK1" ).append("\n"); 
		query.append(",	CASE WHEN INSTRB(INV_MN.INV_RMK, chr(10), 1, 1) = 0" ).append("\n"); 
		query.append("THEN ''" ).append("\n"); 
		query.append("ELSE SUBSTRB(INV_MN.INV_RMK, INSTRB(INV_MN.INV_RMK, chr(10), -1, 1) + 1)" ).append("\n"); 
		query.append("END INV_RMK2" ).append("\n"); 
		query.append(",	INV_MN.NTC_KNT_CD" ).append("\n"); 
		query.append(",	INV_MN.INV_REF_NO" ).append("\n"); 
		query.append(",	INV_MN.CHG_CURR_CD" ).append("\n"); 
		query.append(",	INV_MN.BIL_AMT" ).append("\n"); 
		query.append(",	INV_MN.INV_CURR_CD" ).append("\n"); 
		query.append(",	INV_MN.INV_XCH_RT" ).append("\n"); 
		query.append(",	INV_MN.BKG_CNTR_QTY" ).append("\n"); 
		query.append(",	INV_MN.DC_AMT" ).append("\n"); 
		query.append(",	INV_MN.INV_CHG_AMT" ).append("\n"); 
		query.append(",	INV_MN.TAX_RTO" ).append("\n"); 
		query.append(",	INV_MN.TAX_AMT" ).append("\n"); 
		query.append(",	INV_MN.INV_AMT" ).append("\n"); 
		query.append(",	INV_MN.DMDT_MNL_INV_RSN_CD" ).append("\n"); 
		query.append(",	INV_MN.MNL_INV_RMK" ).append("\n"); 
		query.append(",	LPAD(INV_MN.VNDR_SEQ, 6, '0') AS VNDR_SEQ" ).append("\n"); 
		query.append(",	VENDOR.VNDR_LGL_ENG_NM AS VNDR_NM" ).append("\n"); 
		query.append(",	INV_MN.DMDT_CXL_RSN_CD" ).append("\n"); 
		query.append(",	(" ).append("\n"); 
		query.append("SELECT	INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("FROM	COM_INTG_CD_DTL" ).append("\n"); 
		query.append("WHERE	INTG_CD_ID = 'CD01962'" ).append("\n"); 
		query.append("AND INTG_CD_VAL_CTNT = INV_MN.DMDT_CXL_RSN_CD" ).append("\n"); 
		query.append(") AS DMDT_CXL_RSN_NM" ).append("\n"); 
		query.append(",	INV_MN.CXL_RMK" ).append("\n"); 
		query.append(",	INV_MN.INV_HLD_RSN_CD" ).append("\n"); 
		query.append(",	(" ).append("\n"); 
		query.append("SELECT	INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("FROM 	COM_INTG_CD_DTL" ).append("\n"); 
		query.append("WHERE	INTG_CD_ID = 'CD01980'" ).append("\n"); 
		query.append("AND INTG_CD_VAL_CTNT = INV_MN.INV_HLD_RSN_CD" ).append("\n"); 
		query.append(") AS INV_HLD_RSN_NM" ).append("\n"); 
		query.append(",	INV_MN.INV_HLD_RMK" ).append("\n"); 
		query.append(",	TO_CHAR(INV_MN.UPD_DT, 'YYYY-MM-DD') AS UPD_DT" ).append("\n"); 
		query.append(",	INV_MN.UPD_OFC_CD" ).append("\n"); 
		query.append(",	INV_MN.UPD_USR_ID" ).append("\n"); 
		query.append(",	USER_A.USR_NM AS UPD_USR_NM" ).append("\n"); 
		query.append(",	SH_OPT.BIL_TO_LOC_DIV_CD" ).append("\n"); 
		query.append(",	INV_MN.CUST_CNTC_PNT_SEQ" ).append("\n"); 
		query.append(",	INV_MN.SUTH_CHN_ISS_FLG" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM    DMT_INV_MN INV_MN" ).append("\n"); 
		query.append(",	COM_USER USER_A" ).append("\n"); 
		query.append(",	COM_USER USER_B" ).append("\n"); 
		query.append(",	MDM_VENDOR VENDOR" ).append("\n"); 
		query.append(",	DMT_OFC_SH_OPT SH_OPT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE   INV_MN.DMDT_INV_NO 		= @[dmdt_inv_no]" ).append("\n"); 
		query.append("AND INV_MN.UPD_USR_ID 		= USER_A.USR_ID(+)" ).append("\n"); 
		query.append("AND INV_MN.AR_IF_USR_ID 	= USER_B.USR_ID(+)" ).append("\n"); 
		query.append("AND INV_MN.VNDR_SEQ 		= VENDOR.VNDR_SEQ(+)" ).append("\n"); 
		query.append("AND INV_MN.CRE_OFC_CD 		= SH_OPT.OFC_CD(+)" ).append("\n"); 

	}
}