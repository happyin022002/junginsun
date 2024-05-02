/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : InvoiceIssueCollectionMgtDBDAOSearchSheetOptionRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.15
*@LastModifier : 
*@LastVersion : 1.0
* 2010.04.15 
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

public class InvoiceIssueCollectionMgtDBDAOSearchSheetOptionRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Invoice Creation & Issue - Booking
	  * </pre>
	  */
	public InvoiceIssueCollectionMgtDBDAOSearchSheetOptionRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_trf_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration").append("\n"); 
		query.append("FileName : InvoiceIssueCollectionMgtDBDAOSearchSheetOptionRSQL").append("\n"); 
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
		query.append("SELECT DECODE(C.DMDT_TRF_CD, NULL, 'Y', B.ISS_DT_PRN_FLG) AS ISS_DT_PRN_FLG" ).append("\n"); 
		query.append(", DECODE(C.DMDT_TRF_CD, NULL, 0, B.CR_TERM_DYS) AS CR_TERM_DYS" ).append("\n"); 
		query.append(", A.DFLT_TAX_RTO" ).append("\n"); 
		query.append(", B.OFC_CD" ).append("\n"); 
		query.append(", C.DMDT_TRF_CD" ).append("\n"); 
		query.append(", A.BIL_TO_LOC_DIV_CD" ).append("\n"); 
		query.append("FROM DMT_OFC_SH_OPT A, DMT_CR_TERM_OPT B, DMT_CR_TERM_TRF_OPT C" ).append("\n"); 
		query.append("WHERE A.OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("AND A.OFC_CD = B.OFC_CD" ).append("\n"); 
		query.append("AND B.OFC_CD = C.OFC_CD" ).append("\n"); 
		query.append("AND B.CR_TERM_SEQ = C.CR_TERM_SEQ" ).append("\n"); 
		query.append("AND C.DMDT_TRF_CD = @[dmdt_trf_cd]" ).append("\n"); 

	}
}