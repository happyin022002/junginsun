/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : InvoiceIssueCollectionMgtDBDAOSearchInvoiceDetailRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.07.19
*@LastModifier : 김태균
*@LastVersion : 1.0
* 2010.07.19 김태균
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM TAE KYUN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceIssueCollectionMgtDBDAOSearchInvoiceDetailRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DMT_INV_MN, DMT_INV_DTL, DMT_CHG_CALC, DMT_CHG_BKG_CNTR
	  * </pre>
	  */
	public InvoiceIssueCollectionMgtDBDAOSearchInvoiceDetailRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_invoice_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration").append("\n"); 
		query.append("FileName : InvoiceIssueCollectionMgtDBDAOSearchInvoiceDetailRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT B.CNTR_NO" ).append("\n"); 
		query.append("	,C.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("	,TO_CHAR(B.FM_MVMT_DT, 'YYYY-MM-DD') AS FM_MVMT_DT" ).append("\n"); 
		query.append("	,TO_CHAR(B.TO_MVMT_DT, 'YYYY-MM-DD') AS TO_MVMT_DT" ).append("\n"); 
		query.append("	,TO_CHAR(B.FT_CMNC_DT, 'YYYY-MM-DD') AS FT_CMNC_DT" ).append("\n"); 
		query.append("	,TO_CHAR(B.FT_END_DT, 'YYYY-MM-DD') AS FT_END_DT" ).append("\n"); 
		query.append("	,B.FT_DYS" ).append("\n"); 
		query.append("	,B.FX_FT_OVR_DYS" ).append("\n"); 
		query.append("	,A.CHG_CURR_CD AS BZC_TRF_CURR_CD" ).append("\n"); 
		query.append("	,B.ORG_CHG_AMT" ).append("\n"); 
		query.append("	,NVL(B.SC_RFA_EXPT_AMT,0) AS EXPT_AMT" ).append("\n"); 
		query.append("	,B.AFT_EXPT_DC_AMT" ).append("\n"); 
		query.append("	,B.BIL_AMT" ).append("\n"); 
		query.append("	,DECODE(B.CHG_SEQ,'1','G','B') AS GB" ).append("\n"); 
		query.append("	,B.SYS_AREA_GRP_ID AS SVR_ID" ).append("\n"); 
		query.append("	,B.CNTR_CYC_NO" ).append("\n"); 
		query.append("	,B.DMDT_TRF_CD" ).append("\n"); 
		query.append("	,B.DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("	,B.CHG_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	,D.BZC_TRF_SEQ" ).append("\n"); 
		query.append("	,D.BZC_TRF_GRP_SEQ" ).append("\n"); 
		query.append("	,D.DMDT_CHG_STS_CD" ).append("\n"); 
		query.append("	,D.ORG_FT_OVR_DYS" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	,D.RFA_EXPT_DAR_NO" ).append("\n"); 
		query.append("	,D.RFA_EXPT_MAPG_SEQ" ).append("\n"); 
		query.append("	,D.RFA_EXPT_VER_SEQ" ).append("\n"); 
		query.append("	,D.RFA_RQST_DTL_SEQ" ).append("\n"); 
		query.append("	,D.SC_NO" ).append("\n"); 
		query.append("	,D.SC_EXPT_VER_SEQ" ).append("\n"); 
		query.append("	,D.SC_EXPT_GRP_SEQ" ).append("\n"); 
		query.append("	,D.DMDT_TRF_APLY_TP_CD	" ).append("\n"); 
		query.append("	,D.OFC_TRNS_FLG" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	,NVL(D.CMDT_EXPT_AMT,0) AS CMDT_EXPT_AMT" ).append("\n"); 
		query.append("	,B.INV_DTL_SEQ AS RT_DTL_GRP" ).append("\n"); 
		query.append("	,C.BKG_NO" ).append("\n"); 
		query.append("	,D.OFC_CD AS CHG_OFC_CD" ).append("\n"); 
		query.append("FROM DMT_INV_MN A, DMT_INV_DTL B, DMT_CHG_BKG_CNTR C, DMT_CHG_CALC D" ).append("\n"); 
		query.append("WHERE A.DMDT_INV_NO = B.DMDT_INV_NO" ).append("\n"); 
		query.append("AND A.CRE_OFC_CD 	= B.CRE_OFC_CD" ).append("\n"); 
		query.append("--AND B.SYS_AREA_GRP_ID 		= C.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("AND B.CNTR_NO 		= C.CNTR_NO" ).append("\n"); 
		query.append("AND B.CNTR_CYC_NO 	= C.CNTR_CYC_NO" ).append("\n"); 
		query.append("--AND B.SYS_AREA_GRP_ID 		= D.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("AND B.CNTR_NO 		= D.CNTR_NO" ).append("\n"); 
		query.append("AND B.CNTR_CYC_NO 	= D.CNTR_CYC_NO" ).append("\n"); 
		query.append("AND A.DMDT_INV_NO 	= @[s_invoice_no]" ).append("\n"); 
		query.append("AND A.CRE_OFC_CD	= @[ofc_cd]" ).append("\n"); 
		query.append("AND A.DMDT_TRF_CD	= D.DMDT_TRF_CD" ).append("\n"); 
		query.append("AND (" ).append("\n"); 
		query.append("        (D.DMDT_CHG_STS_CD = 'I' AND A.DMDT_INV_NO = D.DMDT_INV_NO AND A.DMDT_INV_STS_CD = 'I'" ).append("\n"); 
		query.append("			AND B.SYS_AREA_GRP_ID = C.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("    		AND B.SYS_AREA_GRP_ID = D.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("  			AND B.CNTR_NO = D.CNTR_NO" ).append("\n"); 
		query.append("			AND B.CNTR_CYC_NO = D.CNTR_CYC_NO" ).append("\n"); 
		query.append("  			AND B.DMDT_TRF_CD = D.DMDT_TRF_CD" ).append("\n"); 
		query.append("  			AND B.DMDT_CHG_LOC_DIV_CD = D.DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("  			AND B.CHG_SEQ = D.CHG_SEQ" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("	  OR" ).append("\n"); 
		query.append("		(D.DMDT_CHG_STS_CD = 'I' AND A.DMDT_INV_STS_CD <> 'I'" ).append("\n"); 
		query.append("			AND B.SYS_AREA_GRP_ID = C.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("    		AND B.SYS_AREA_GRP_ID = D.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("  			AND B.CNTR_NO = D.CNTR_NO" ).append("\n"); 
		query.append("			AND B.CNTR_CYC_NO = D.CNTR_CYC_NO" ).append("\n"); 
		query.append("  			AND B.DMDT_TRF_CD = D.DMDT_TRF_CD" ).append("\n"); 
		query.append("  			AND B.DMDT_CHG_LOC_DIV_CD = D.DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("  			AND B.CHG_SEQ = D.CHG_SEQ" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("      OR " ).append("\n"); 
		query.append("        (D.DMDT_CHG_STS_CD <> 'I'" ).append("\n"); 
		query.append("    		AND C.SYS_AREA_GRP_ID = D.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("  			AND B.CNTR_NO = D.CNTR_NO" ).append("\n"); 
		query.append("			AND B.CNTR_CYC_NO = D.CNTR_CYC_NO" ).append("\n"); 
		query.append("  			AND B.DMDT_TRF_CD = D.DMDT_TRF_CD" ).append("\n"); 
		query.append("  			AND B.DMDT_CHG_LOC_DIV_CD = D.DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("  			AND B.CHG_SEQ = D.CHG_SEQ" ).append("\n"); 
		query.append("         )" ).append("\n"); 
		query.append("    )" ).append("\n"); 

	}
}