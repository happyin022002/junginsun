/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : InvoiceIssueCollectionMgtDBDAOSearchSheetOptionDwRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.22
*@LastModifier : 
*@LastVersion : 1.0
* 2010.03.22 
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

public class InvoiceIssueCollectionMgtDBDAOSearchSheetOptionDwRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * INVOICE 생성 및 징수관리
	  * EES_DMT_4103
	  * Sheet Option
	  * </pre>
	  */
	public InvoiceIssueCollectionMgtDBDAOSearchSheetOptionDwRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("isof",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration").append("\n"); 
		query.append("FileName : InvoiceIssueCollectionMgtDBDAOSearchSheetOptionDwRSQL").append("\n"); 
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
		query.append("AA.CR_TERM_SEQ AS SEQQ" ).append("\n"); 
		query.append(", AA.DMDT_SH_TP_CD AS SHTP" ).append("\n"); 
		query.append(", DECODE(AA.ALL_TRF_TP_FLG, 'Y', '1', 'N', '0', '1') AS ALLL" ).append("\n"); 
		query.append(", MAX ( DECODE ( BB.CR_TERM_SEQ , AA.CR_TERM_SEQ , DECODE ( BB.DMDT_TRF_CD , 'DMIF' , 1 , 0 ) , 0 ) ) AS DMIF" ).append("\n"); 
		query.append(", MAX ( DECODE ( BB.CR_TERM_SEQ , AA.CR_TERM_SEQ , DECODE ( BB.DMDT_TRF_CD , 'DTIC' , 1 , 0 ) , 0 ) ) AS DTIC" ).append("\n"); 
		query.append(", MAX ( DECODE ( BB.CR_TERM_SEQ , AA.CR_TERM_SEQ , DECODE ( BB.DMDT_TRF_CD , 'DMOF' , 1 , 0 ) , 0 ) ) AS DMOF" ).append("\n"); 
		query.append(", MAX ( DECODE ( BB.CR_TERM_SEQ , AA.CR_TERM_SEQ , DECODE ( BB.DMDT_TRF_CD , 'DTOC' , 1 , 0 ) , 0 ) ) AS DTOC" ).append("\n"); 
		query.append(", MAX ( DECODE ( BB.CR_TERM_SEQ , AA.CR_TERM_SEQ , DECODE ( BB.DMDT_TRF_CD , 'CTIC' , 1 , 0 ) , 0 ) ) AS CTIC" ).append("\n"); 
		query.append(", MAX ( DECODE ( BB.CR_TERM_SEQ , AA.CR_TERM_SEQ , DECODE ( BB.DMDT_TRF_CD , 'CTOC' , 1 , 0 ) , 0 ) ) AS CTOC" ).append("\n"); 
		query.append(", AA.CSTMZ_TIT_DESC AS TITL" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("DMT_CSTMZ_TIT_OPT AA" ).append("\n"); 
		query.append(", DMT_CSTMZ_TIT_TRF_OPT BB" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("AA.OFC_CD      = BB.OFC_CD(+)" ).append("\n"); 
		query.append("AND     AA.CR_TERM_SEQ = BB.CR_TERM_SEQ(+)" ).append("\n"); 
		query.append("AND     AA.OFC_CD = @[isof]" ).append("\n"); 
		query.append("GROUP BY" ).append("\n"); 
		query.append("AA.CR_TERM_SEQ" ).append("\n"); 
		query.append(", AA.DMDT_SH_TP_CD" ).append("\n"); 
		query.append(", AA.ALL_TRF_TP_FLG" ).append("\n"); 
		query.append(", AA.CSTMZ_TIT_DESC" ).append("\n"); 
		query.append("ORDER BY" ).append("\n"); 
		query.append("AA.CR_TERM_SEQ" ).append("\n"); 

	}
}