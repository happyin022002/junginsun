/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : InvoiceIssueCollectionMgtDBDAOSearchManualInvoiceChargeDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.21
*@LastModifier : 
*@LastVersion : 1.0
* 2010.04.21 
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

public class InvoiceIssueCollectionMgtDBDAOSearchManualInvoiceChargeDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Charge 정보를 조회하는 쿼리
	  * </pre>
	  */
	public InvoiceIssueCollectionMgtDBDAOSearchManualInvoiceChargeDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_trf_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration").append("\n"); 
		query.append("FileName : InvoiceIssueCollectionMgtDBDAOSearchManualInvoiceChargeDataRSQL").append("\n"); 
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
		query.append("SELECT	CHG_CNTR.BKG_NO" ).append("\n"); 
		query.append(",	CHG_CNTR.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append(",	CHG_CNTR.CNTR_NO" ).append("\n"); 
		query.append(",	CHG_CNTR.CNTR_CYC_NO" ).append("\n"); 
		query.append(",	CHG_CNTR.CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",	CHG_CNTR.SC_NO" ).append("\n"); 
		query.append(",	TO_CHAR(CHG_CALC.FM_MVMT_DT, 'YYYY-MM-DD') AS FM_MVMT_DT" ).append("\n"); 
		query.append(",	TO_CHAR(CHG_CALC.TO_MVMT_DT, 'YYYY-MM-DD') AS TO_MVMT_DT" ).append("\n"); 
		query.append(",	TO_CHAR(DECODE(NVL(CHG_CALC.FT_CMNC_DT, ''), '', CHG_CALC.FM_MVMT_DT, CHG_CALC.FT_CMNC_DT), 'YYYY-MM-DD') AS FT_CMNC_DT" ).append("\n"); 
		query.append(",	TO_CHAR(CHG_CALC.FT_END_DT, 'YYYY-MM-DD') AS FT_END_DT" ).append("\n"); 
		query.append(",	CHG_CALC.FT_DYS" ).append("\n"); 
		query.append(",	CHG_CALC.BZC_TRF_CURR_CD" ).append("\n"); 
		query.append(",	CHG_CALC.VNDR_SEQ" ).append("\n"); 
		query.append(",	VENDOR.VNDR_LGL_ENG_NM AS VNDR_NM" ).append("\n"); 
		query.append(",	CHG_CALC.ACT_CNT_CD || LPAD(CHG_CALC.ACT_CUST_SEQ, 6, '0') AS ACT_PAYR_CUST_CD" ).append("\n"); 
		query.append(",	(" ).append("\n"); 
		query.append("SELECT	B.CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("FROM	DMT_CHG_CALC A, MDM_CUSTOMER B" ).append("\n"); 
		query.append("WHERE	SYS_AREA_GRP_ID = CHG_CALC.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("AND	A.CNTR_NO = CHG_CALC.CNTR_NO" ).append("\n"); 
		query.append("AND	A.CNTR_CYC_NO = CHG_CALC.CNTR_CYC_NO" ).append("\n"); 
		query.append("AND	A.DMDT_TRF_CD = CHG_CALC.DMDT_TRF_CD" ).append("\n"); 
		query.append("AND	A.DMDT_CHG_LOC_DIV_CD = CHG_CALC.DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("AND A.CHG_SEQ = CHG_CALC.CHG_SEQ" ).append("\n"); 
		query.append("AND A.ACT_CNT_CD = B.CUST_CNT_CD" ).append("\n"); 
		query.append("AND A.ACT_CUST_SEQ = B.CUST_SEQ" ).append("\n"); 
		query.append(") AS ACT_PAYR_CUST_NM" ).append("\n"); 
		query.append(",	(" ).append("\n"); 
		query.append("SELECT	B.VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("FROM	DMT_CHG_CALC A, MDM_VENDOR B" ).append("\n"); 
		query.append("WHERE	SYS_AREA_GRP_ID = CHG_CALC.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("AND	A.CNTR_NO = CHG_CALC.CNTR_NO" ).append("\n"); 
		query.append("AND	A.CNTR_CYC_NO = CHG_CALC.CNTR_CYC_NO" ).append("\n"); 
		query.append("AND	A.DMDT_TRF_CD = CHG_CALC.DMDT_TRF_CD" ).append("\n"); 
		query.append("AND	A.DMDT_CHG_LOC_DIV_CD = CHG_CALC.DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("AND A.CHG_SEQ = CHG_CALC.CHG_SEQ" ).append("\n"); 
		query.append("AND A.ACT_CUST_SEQ = B.VNDR_SEQ" ).append("\n"); 
		query.append("AND A.ACT_CNT_CD = B.VNDR_CNT_CD" ).append("\n"); 
		query.append(") AS ACT_PAYR_VNDR_NM" ).append("\n"); 
		query.append(",	CHG_CALC.DMDT_TRF_APLY_TP_CD" ).append("\n"); 
		query.append(",	CHG_CALC.OFC_TRNS_FLG" ).append("\n"); 
		query.append(",	CHG_CALC.DMDT_TRF_CD" ).append("\n"); 
		query.append(",	CHG_CALC.DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append(",	CHG_CALC.CHG_SEQ" ).append("\n"); 
		query.append(",	CHG_CALC.BZC_TRF_SEQ" ).append("\n"); 
		query.append(",	CHG_CALC.BZC_TRF_GRP_SEQ" ).append("\n"); 
		query.append(",	CHG_CALC.FX_FT_OVR_DYS" ).append("\n"); 
		query.append(",	CHG_CALC.RFA_EXPT_DAR_NO" ).append("\n"); 
		query.append(",	CHG_CALC.RFA_EXPT_MAPG_SEQ" ).append("\n"); 
		query.append(",	CHG_CALC.RFA_EXPT_VER_SEQ" ).append("\n"); 
		query.append(",	CHG_CALC.RFA_RQST_DTL_SEQ" ).append("\n"); 
		query.append(",	CHG_CALC.SC_EXPT_VER_SEQ" ).append("\n"); 
		query.append(",	CHG_CALC.SC_EXPT_GRP_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM	DMT_CHG_BKG_CNTR CHG_CNTR" ).append("\n"); 
		query.append(",	DMT_CHG_CALC CHG_CALC" ).append("\n"); 
		query.append(",	MDM_VENDOR VENDOR" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE	CHG_CNTR.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND CHG_CNTR.SYS_AREA_GRP_ID =" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT  SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("FROM    COM_SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("WHERE   CNT_CD =" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN SUBSTR(@[dmdt_trf_cd], 2, 1) = 'M' AND SUBSTR(@[dmdt_trf_cd], 3, 1) = 'I'" ).append("\n"); 
		query.append("THEN SUBSTR(CHG_CNTR.POD_CD, 0, 2)" ).append("\n"); 
		query.append("WHEN SUBSTR(@[dmdt_trf_cd], 2, 1) = 'M' AND SUBSTR(@[dmdt_trf_cd], 3, 1) = 'O'" ).append("\n"); 
		query.append("THEN SUBSTR(CHG_CNTR.POL_CD, 0, 2)" ).append("\n"); 
		query.append("WHEN SUBSTR(@[dmdt_trf_cd], 2, 1) = 'T' AND SUBSTR(@[dmdt_trf_cd], 3, 1) = 'I'" ).append("\n"); 
		query.append("THEN SUBSTR(CHG_CNTR.DEL_CD, 0, 2)" ).append("\n"); 
		query.append("WHEN SUBSTR(@[dmdt_trf_cd], 2, 1) = 'T' AND SUBSTR(@[dmdt_trf_cd], 3, 1) = 'O'" ).append("\n"); 
		query.append("THEN SUBSTR(CHG_CNTR.POR_CD, 0, 2)" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND CO_IND_CD = 'H'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND CHG_CNTR.SYS_AREA_GRP_ID = CHG_CALC.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("AND CHG_CNTR.CNTR_NO = CHG_CALC.CNTR_NO" ).append("\n"); 
		query.append("AND CHG_CNTR.CNTR_CYC_NO = CHG_CALC.CNTR_CYC_NO" ).append("\n"); 
		query.append("AND CHG_CALC.DMDT_TRF_CD = @[dmdt_trf_cd]" ).append("\n"); 
		query.append("AND CHG_CALC.DMDT_CHG_LOC_DIV_CD <> 'TSP'" ).append("\n"); 
		query.append("AND CHG_CALC.DMDT_CHG_STS_CD IN ('D', 'E')" ).append("\n"); 
		query.append("AND CHG_CALC.VNDR_SEQ = VENDOR.VNDR_SEQ(+)" ).append("\n"); 
		query.append("AND CHG_CALC.VNDR_CNT_CD = VENDOR.VNDR_CNT_CD(+)" ).append("\n"); 
		query.append("ORDER BY CHG_CALC.CNTR_NO" ).append("\n"); 

	}
}