/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : InvoiceIssueCollectionMgtDBDAOSearchPayerEmailRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.28
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.28 
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

public class InvoiceIssueCollectionMgtDBDAOSearchPayerEmailRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Payer Email search
	  * </pre>
	  */
	public InvoiceIssueCollectionMgtDBDAOSearchPayerEmailRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration").append("\n"); 
		query.append("FileName : InvoiceIssueCollectionMgtDBDAOSearchPayerEmailRSQL").append("\n"); 
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
		query.append("SELECT 'DMT' AS JOB_TP" ).append("\n"); 
		query.append("	,'' AS GUBUN" ).append("\n"); 
		query.append("	,PAYR_CNTC_PNT_EML 	AS DMDT_PAYR_N1ST_EML" ).append("\n"); 
		query.append("FROM DMT_PAYR_CNTC_PNT" ).append("\n"); 
		query.append("WHERE SYS_AREA_GRP_ID 	= NVL(@[svr_id]," ).append("\n"); 
		query.append("						  (SELECT SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("						   FROM COM_SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("						   WHERE CNT_CD = (SELECT SUBSTR(LOC_CD, 1, 2) " ).append("\n"); 
		query.append("										   FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("										   WHERE OFC_CD = SUBSTR(@[s_ofc_cd], 0, 5))" ).append("\n"); 
		query.append("						   AND CO_IND_CD = 'H'))" ).append("\n"); 
		query.append("AND CUST_CNT_CD 		= SUBSTR(@[s_cust_cd], 1, 2)" ).append("\n"); 
		query.append("AND CUST_SEQ 			= SUBSTR(@[s_cust_cd], 3)" ).append("\n"); 
		query.append("#if (${s_cust_gubun} == '1')" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("-- MDM - GENERAL" ).append("\n"); 
		query.append("SELECT DISTINCT 'MDM'" ).append("\n"); 
		query.append("    ,'GENERAL'" ).append("\n"); 
		query.append("    , B.VNDR_EML" ).append("\n"); 
		query.append("FROM MDM_VENDOR A, MDM_VNDR_CNTC_PNT B" ).append("\n"); 
		query.append("WHERE A.VNDR_SEQ 		= B.VNDR_SEQ" ).append("\n"); 
		query.append("AND A.VNDR_SEQ 			= @[s_cust_cd]" ).append("\n"); 
		query.append("AND B.VNDR_EML IS NOT NULL" ).append("\n"); 
		query.append("#elseif (${s_cust_gubun} == '2') " ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("-- MDM - CREDIT" ).append("\n"); 
		query.append("SELECT DISTINCT 'MDM'" ).append("\n"); 
		query.append("	,'CREDIT'" ).append("\n"); 
		query.append("	,IB_EML" ).append("\n"); 
		query.append("FROM MDM_CR_CUST" ).append("\n"); 
		query.append("WHERE CUST_CNT_CD 		= SUBSTR(@[s_cust_cd], 1, 2)" ).append("\n"); 
		query.append("AND CUST_SEQ 			= SUBSTR(@[s_cust_cd], 3)" ).append("\n"); 
		query.append("AND IB_EML  IS NOT NULL" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("-- MDM - GENERAL" ).append("\n"); 
		query.append("SELECT DISTINCT 'MDM'" ).append("\n"); 
		query.append("    ,'GENERAL'" ).append("\n"); 
		query.append("    , B.CUST_EML" ).append("\n"); 
		query.append("FROM MDM_CUSTOMER A, MDM_CUST_CNTC_PNT B" ).append("\n"); 
		query.append("WHERE A.CUST_CNT_CD 	= B.CUST_CNT_CD" ).append("\n"); 
		query.append("AND A.CUST_SEQ 			= B.CUST_SEQ" ).append("\n"); 
		query.append("AND A.CUST_CNT_CD 		= SUBSTR(@[s_cust_cd], 1, 2)" ).append("\n"); 
		query.append("AND A.CUST_SEQ 			= SUBSTR(@[s_cust_cd], 3)" ).append("\n"); 
		query.append("AND B.CUST_EML IS NOT NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}