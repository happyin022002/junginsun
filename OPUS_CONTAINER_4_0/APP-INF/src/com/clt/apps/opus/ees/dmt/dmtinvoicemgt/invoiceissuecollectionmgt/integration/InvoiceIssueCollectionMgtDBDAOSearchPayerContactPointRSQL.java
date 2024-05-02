/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InvoiceIssueCollectionMgtDBDAOSearchPayerContactPointRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.26
*@LastModifier : 김태균
*@LastVersion : 1.0
* 2009.10.26 김태균
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Tae Kyun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceIssueCollectionMgtDBDAOSearchPayerContactPointRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DEM/DET Payer Info & Fax/E-mail
	  * </pre>
	  */
	public InvoiceIssueCollectionMgtDBDAOSearchPayerContactPointRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_cust_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration").append("\n"); 
		query.append("FileName : InvoiceIssueCollectionMgtDBDAOSearchPayerContactPointRSQL").append("\n"); 
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
		query.append("SELECT SYS_AREA_GRP_ID AS SVR_ID" ).append("\n"); 
		query.append(",CUST_CNT_CD||LPAD(CUST_SEQ,6,'0') AS CUST_CD" ).append("\n"); 
		query.append(",CUST_CNT_CD" ).append("\n"); 
		query.append(",CUST_SEQ" ).append("\n"); 
		query.append(",CUST_CNTC_PNT_SEQ" ).append("\n"); 
		query.append(",DMDT_PAYR_CNTC_PNT_NM AS PAYR_CNTC_PNT_NM" ).append("\n"); 
		query.append(",PAYR_CNTC_PNT_PHN_NO" ).append("\n"); 
		query.append(",PAYR_CNTC_PNT_FAX_NO" ).append("\n"); 
		query.append(",PAYR_CNTC_PNT_EML" ).append("\n"); 
		query.append("FROM DMT_PAYR_CNTC_PNT" ).append("\n"); 
		query.append("WHERE SYS_AREA_GRP_ID = (SELECT SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("FROM COM_SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("WHERE CNT_CD = (SELECT SUBSTR(LOC_CD, 1, 2)" ).append("\n"); 
		query.append("FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("WHERE OFC_CD = @[s_ofc_cd])" ).append("\n"); 
		query.append("AND CO_IND_CD = 'H'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND CUST_CNT_CD 	= substr(@[s_cust_cd],1,2)" ).append("\n"); 
		query.append("AND CUST_SEQ 		= substr(@[s_cust_cd],3,6)" ).append("\n"); 
		query.append("ORDER BY CUST_CNTC_PNT_SEQ" ).append("\n"); 

	}
}