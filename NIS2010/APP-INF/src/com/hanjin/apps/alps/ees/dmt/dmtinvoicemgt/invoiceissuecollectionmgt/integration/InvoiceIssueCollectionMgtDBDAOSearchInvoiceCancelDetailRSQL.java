/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : InvoiceIssueCollectionMgtDBDAOSearchInvoiceCancelDetailRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.11
*@LastModifier : 
*@LastVersion : 1.0
* 2016.08.11 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceIssueCollectionMgtDBDAOSearchInvoiceCancelDetailRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Cancel ,Credit Note 일 경우 charge data가 존재하지 않을 경우 invoice data 만으로 조회한다.
	  * </pre>
	  */
	public InvoiceIssueCollectionMgtDBDAOSearchInvoiceCancelDetailRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_inv_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration").append("\n"); 
		query.append("FileName : InvoiceIssueCollectionMgtDBDAOSearchInvoiceCancelDetailRSQL").append("\n"); 
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
		query.append("        , B.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("        , TO_CHAR(B.FM_MVMT_DT, 'YYYY-MM-DD') AS FM_MVMT_DT" ).append("\n"); 
		query.append("        , TO_CHAR(B.TO_MVMT_DT, 'YYYY-MM-DD') AS TO_MVMT_DT" ).append("\n"); 
		query.append("        , TO_CHAR(B.FT_CMNC_DT, 'YYYY-MM-DD') AS FT_CMNC_DT" ).append("\n"); 
		query.append("        , TO_CHAR(B.FT_END_DT, 'YYYY-MM-DD') AS FT_END_DT" ).append("\n"); 
		query.append("        , B.FT_DYS" ).append("\n"); 
		query.append("        , B.FX_FT_OVR_DYS" ).append("\n"); 
		query.append("        , A.CHG_CURR_CD AS BZC_TRF_CURR_CD" ).append("\n"); 
		query.append("        , B.ORG_CHG_AMT" ).append("\n"); 
		query.append("        , NVL(B.SC_RFA_EXPT_AMT,0) AS EXPT_AMT" ).append("\n"); 
		query.append("        , B.AFT_EXPT_DC_AMT" ).append("\n"); 
		query.append("        , B.BIL_AMT" ).append("\n"); 
		query.append("        , DECODE(B.CHG_SEQ,'1','G','B') AS GB" ).append("\n"); 
		query.append("        , B.SYS_AREA_GRP_ID AS SVR_ID" ).append("\n"); 
		query.append("        , B.CNTR_CYC_NO" ).append("\n"); 
		query.append("        , B.DMDT_TRF_CD" ).append("\n"); 
		query.append("        , B.DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("        , B.CHG_SEQ" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        , '' AS BZC_TRF_SEQ" ).append("\n"); 
		query.append("        , '' AS BZC_DMDT_DE_TERM_CD" ).append("\n"); 
		query.append("        , '' AS BZC_TRF_GRP_SEQ" ).append("\n"); 
		query.append("        , '' AS DMDT_CHG_STS_CD" ).append("\n"); 
		query.append("        , '' AS ORG_FT_OVR_DYS" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        , '' AS RFA_EXPT_DAR_NO" ).append("\n"); 
		query.append("        , '' AS RFA_EXPT_MAPG_SEQ" ).append("\n"); 
		query.append("        , '' AS RFA_EXPT_VER_SEQ" ).append("\n"); 
		query.append("        , '' AS RFA_RQST_DTL_SEQ" ).append("\n"); 
		query.append("        , '' AS SC_NO" ).append("\n"); 
		query.append("        , '' AS SC_EXPT_VER_SEQ" ).append("\n"); 
		query.append("        , '' AS SC_EXPT_GRP_SEQ" ).append("\n"); 
		query.append("        , '' AS DMDT_TRF_APLY_TP_CD	" ).append("\n"); 
		query.append("        , '' AS OFC_TRNS_FLG" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        , '' AS CMDT_EXPT_AMT" ).append("\n"); 
		query.append("        , '' AS RT_DTL_GRP" ).append("\n"); 
		query.append("        , '' AS BKG_NO" ).append("\n"); 
		query.append("        , '' AS CHG_OFC_CD" ).append("\n"); 
		query.append("        , ( SELECT DUL_TP_EXPT_FLG FROM DMT_CHG_CALC " ).append("\n"); 
		query.append("             WHERE SYS_AREA_GRP_ID = B.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("               AND CNTR_NO = B.CNTR_NO" ).append("\n"); 
		query.append("               AND CNTR_CYC_NO = B.CNTR_CYC_NO" ).append("\n"); 
		query.append("               AND DMDT_TRF_CD = B.DMDT_TRF_CD" ).append("\n"); 
		query.append("               AND DMDT_CHG_LOC_DIV_CD = B.DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("               AND CHG_SEQ = B.CHG_SEQ ) DUL_TP_EXPT_FLG" ).append("\n"); 
		query.append("FROM    DMT_INV_MN      A," ).append("\n"); 
		query.append("        DMT_INV_DTL     B" ).append("\n"); 
		query.append("WHERE   A.DMDT_INV_NO       = B.DMDT_INV_NO" ).append("\n"); 
		query.append("AND     A.CRE_OFC_CD        = B.CRE_OFC_CD" ).append("\n"); 
		query.append("AND     A.DMDT_INV_NO       = @[dmdt_inv_no]" ).append("\n"); 
		query.append("AND     A.CRE_OFC_CD        = @[cre_ofc_cd]" ).append("\n"); 
		query.append("AND     A.DMDT_INV_STS_CD   = @[dmdt_inv_sts_cd]" ).append("\n"); 

	}
}