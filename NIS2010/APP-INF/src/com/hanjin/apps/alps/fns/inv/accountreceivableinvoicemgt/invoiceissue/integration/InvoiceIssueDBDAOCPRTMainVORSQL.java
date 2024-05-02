/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : InvoiceIssueDBDAOCPRTMainVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.02
*@LastModifier : 한동훈
*@LastVersion : 1.0
* 2010.02.02 한동훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author donghoon han
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceIssueDBDAOCPRTMainVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public InvoiceIssueDBDAOCPRTMainVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_rpt_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.integration").append("\n"); 
		query.append("FileName : InvoiceIssueDBDAOCPRTMainVORSQL").append("\n"); 
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
		query.append("SELECT  A.CUST_RPT_ID" ).append("\n"); 
		query.append("		,A.RPT_TMPLT_NM" ).append("\n"); 
		query.append("        ,TO_CHAR(A.CRE_DT,'YYYY-MM-DD') CRE_DT" ).append("\n"); 
		query.append("        ,A.BL_SRC_NO" ).append("\n"); 
		query.append("        ,A.POR_CD" ).append("\n"); 
		query.append("        ,A.POL_CD" ).append("\n"); 
		query.append("        ,A.POD_CD" ).append("\n"); 
		query.append("        ,A.DEL_CD" ).append("\n"); 
		query.append("        ,(A.TRNK_VSL_CD||A.TRNK_SKD_VOY_NO||A.TRNK_SKD_DIR_CD) TRNK_VVD" ).append("\n"); 
		query.append("		,A.TRNK_VSL_CD" ).append("\n"); 
		query.append("		,A.TRNK_SKD_VOY_NO" ).append("\n"); 
		query.append("		,A.TRNK_SKD_DIR_CD" ).append("\n"); 
		query.append("        ,DECODE(A.SC_NO,'X','',A.SC_NO) SC_NO" ).append("\n"); 
		query.append("        ,DECODE(A.RFA_NO,'X','',A.RFA_NO) RFA_NO" ).append("\n"); 
		query.append("        ,A.PPD_USD_TTL_AMT" ).append("\n"); 
		query.append("        ,A.CLT_USD_TTL_AMT" ).append("\n"); 
		query.append("        ,A.N3RD_PAYR_USD_TTL_AMT" ).append("\n"); 
		query.append("		,A.AR_OFC_CD" ).append("\n"); 
		query.append("		,A.CRE_USR_ID" ).append("\n"); 
		query.append("		,A.UPD_USR_ID" ).append("\n"); 
		query.append("		,A.UPD_DT" ).append("\n"); 
		query.append("FROM    INV_CPRT_HIS A" ).append("\n"); 
		query.append("WHERE    A.CUST_RPT_ID = @[cust_rpt_id]" ).append("\n"); 
		query.append("ORDER BY A.CUST_RPT_ID" ).append("\n"); 

	}
}