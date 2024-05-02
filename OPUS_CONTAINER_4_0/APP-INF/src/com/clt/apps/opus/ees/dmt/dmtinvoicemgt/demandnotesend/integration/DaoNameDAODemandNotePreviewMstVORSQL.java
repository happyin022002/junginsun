/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : DaoNameDAODemandNotePreviewMstVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.17
*@LastModifier : 김태균
*@LastVersion : 1.0
* 2011.03.17 김태균
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtinvoicemgt.demandnotesend.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KimTaeKyun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DaoNameDAODemandNotePreviewMstVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DemandNotePreviewMstVO
	  * </pre>
	  */
	public DaoNameDAODemandNotePreviewMstVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtinvoicemgt.demandnotesend.integration").append("\n"); 
		query.append("FileName : DaoNameDAODemandNotePreviewMstVORSQL").append("\n"); 
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
		query.append("SELECT '' AS CUST_VAT" ).append("\n"); 
		query.append("      ,'' AS OFC_ADD01" ).append("\n"); 
		query.append("      ,'' AS OFC_ADD02" ).append("\n"); 
		query.append("      ,'' AS OFC_ADD03" ).append("\n"); 
		query.append("      ,'' AS ADDRESS01" ).append("\n"); 
		query.append("      ,'' AS HEADER01" ).append("\n"); 
		query.append("      ,'' AS HEADER02" ).append("\n"); 
		query.append("      ,'' AS HEADER03" ).append("\n"); 
		query.append("      ,'' AS HEADER04" ).append("\n"); 
		query.append("      ,'' AS HEADER05" ).append("\n"); 
		query.append("      ,'' AS HEADER06" ).append("\n"); 
		query.append("      ,'' AS HEADER07" ).append("\n"); 
		query.append("      ,'' AS HEADER08" ).append("\n"); 
		query.append("      ,'' AS HEADER09" ).append("\n"); 
		query.append("      ,'' AS HEADER10" ).append("\n"); 
		query.append("      ,'' AS SH_NUM" ).append("\n"); 
		query.append("      ,'' as BIL_TO_LOC_DIV_CD" ).append("\n"); 
		query.append("      ,'' as CUST_REF_PRN_FLG" ).append("\n"); 
		query.append("	  ,'' as PHN_FAX_PRN_FLG" ).append("\n"); 
		query.append("	  ,'' as CUST_VAT_PRN_FLG" ).append("\n"); 
		query.append("	  ,'' as DFLT_TAX_RTO" ).append("\n"); 
		query.append("	  ,'' as TAX_AMT_PRN_FLG" ).append("\n"); 
		query.append("      ,'' AS COM_REF" ).append("\n"); 
		query.append("      ,'' AS PRINT_DATE" ).append("\n"); 
		query.append("      ,'' AS DMDT_TRF_NM" ).append("\n"); 
		query.append("      ,'' AS SHEET_REMARK01" ).append("\n"); 
		query.append("      ,'' AS SHEET_REMARK02" ).append("\n"); 
		query.append("      ,'' AS SHEET_REMARK03" ).append("\n"); 
		query.append("      ,'' AS SHEET_REMARK04" ).append("\n"); 
		query.append("      ,'' AS SHEET_REMARK05" ).append("\n"); 
		query.append("      ,'' AS SHEET_REMARK06" ).append("\n"); 
		query.append("      ,'' AS SHEET_REMARK07" ).append("\n"); 
		query.append("      ,'' AS SHEET_REMARK08" ).append("\n"); 
		query.append("      ,'' AS SHEET_REMARK09" ).append("\n"); 
		query.append("      ,'' AS SHEET_REMARK10" ).append("\n"); 
		query.append("      ,'' AS SHEET_REMARK11" ).append("\n"); 
		query.append("      ,'' AS SHEET_REMARK12" ).append("\n"); 
		query.append("      ,'' AS SHEET_REMARK13" ).append("\n"); 
		query.append("      ,'' AS SHEET_REMARK14" ).append("\n"); 
		query.append("	  ,'' AS TITLE" ).append("\n"); 
		query.append("      ,'' AS TAX_NM" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}