/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : InvoiceIssueCollectionMgtDBDAOCheckPayerContactPointRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.10
*@LastModifier : 김기태
*@LastVersion : 1.0
* 2016.05.10 김기태
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kitae Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceIssueCollectionMgtDBDAOCheckPayerContactPointRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DEM/DET Payer Info & Fax/E-mail
	  * </pre>
	  */
	public InvoiceIssueCollectionMgtDBDAOCheckPayerContactPointRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_cust_cntc_pnt_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration").append("\n"); 
		query.append("FileName : InvoiceIssueCollectionMgtDBDAOCheckPayerContactPointRSQL").append("\n"); 
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
		query.append("SELECT DECODE(COUNT(*),0,'N',1,'Y','X') AS PAYR_CONT_YN" ).append("\n"); 
		query.append("FROM DMT_PAYR_CNTC_PNT" ).append("\n"); 
		query.append("WHERE	SYS_AREA_GRP_ID = (SELECT SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("        				   FROM COM_SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("        				   WHERE CNT_CD = (SELECT SUBSTR(LOC_CD, 1, 2)" ).append("\n"); 
		query.append("                        				   FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("                        				   WHERE OFC_CD = SUBSTR(@[s_ofc_cd], 0, 5))" ).append("\n"); 
		query.append("        				   AND CO_IND_CD = 'H')" ).append("\n"); 
		query.append("#if (${s_vndr_flg} == 'V') " ).append("\n"); 
		query.append("AND CUST_CNT_CD = '00' " ).append("\n"); 
		query.append("AND CUST_SEQ 	= @[s_cust_cd]" ).append("\n"); 
		query.append("#elseif (${s_vndr_flg} == 'C') " ).append("\n"); 
		query.append("AND	CUST_CNT_CD 		= SUBSTR(@[s_cust_cd], 1, 2)" ).append("\n"); 
		query.append("AND	CUST_SEQ 			= SUBSTR(@[s_cust_cd], 3, 6)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND CUST_CNTC_PNT_SEQ	= @[s_cust_cntc_pnt_seq]" ).append("\n"); 

	}
}