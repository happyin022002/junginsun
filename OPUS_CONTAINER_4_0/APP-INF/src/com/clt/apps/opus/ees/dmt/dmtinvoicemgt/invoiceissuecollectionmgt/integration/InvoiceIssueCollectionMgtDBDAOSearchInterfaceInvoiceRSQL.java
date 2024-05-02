/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : InvoiceIssueCollectionMgtDBDAOSearchInterfaceInvoiceRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.12
*@LastModifier : 
*@LastVersion : 1.0
* 2016.01.12 
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

public class InvoiceIssueCollectionMgtDBDAOSearchInterfaceInvoiceRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * INV A/R INVOICE INTERFACE 조회
	  * </pre>
	  */
	public InvoiceIssueCollectionMgtDBDAOSearchInterfaceInvoiceRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("invoice_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration").append("\n"); 
		query.append("FileName : InvoiceIssueCollectionMgtDBDAOSearchInterfaceInvoiceRSQL").append("\n"); 
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
		query.append("      A.BL_NO" ).append("\n"); 
		query.append("	  , A.DMDT_INV_NO AS BL_SRC_NO" ).append("\n"); 
		query.append("      , A.DMDT_INV_NO AS INV_SRC_NO" ).append("\n"); 
		query.append("      , A.BKG_NO" ).append("\n"); 
		query.append("	  , CASE WHEN SUBSTR(DMDT_TRF_CD,2,1) = 'T' AND A.ACT_PAYR_CNT_CD = '00' " ).append("\n"); 
		query.append("       THEN ( SELECT CUST_CNT_CD FROM MDM_CUSTOMER WHERE CUST_CNT_CD = 'TB' AND VNDR_SEQ = A.ACT_PAYR_SEQ )" ).append("\n"); 
		query.append("        ELSE" ).append("\n"); 
		query.append("            A.ACT_PAYR_CNT_CD" ).append("\n"); 
		query.append("        END CUST_CNT_CD" ).append("\n"); 
		query.append("      , CASE WHEN SUBSTR(DMDT_TRF_CD,2,1) = 'T' AND A.ACT_PAYR_CNT_CD = '00' " ).append("\n"); 
		query.append("       THEN ( SELECT CUST_SEQ FROM MDM_CUSTOMER WHERE CUST_CNT_CD = 'TB' AND VNDR_SEQ = A.ACT_PAYR_SEQ )" ).append("\n"); 
		query.append("        ELSE" ).append("\n"); 
		query.append("            A.ACT_PAYR_SEQ" ).append("\n"); 
		query.append("        END CUST_SEQ" ).append("\n"); 
		query.append("	  , (SELECT AR_OFC_CD FROM MDM_ORGANIZATION WHERE OFC_CD= @[ar_ofc_cd]) AS OFC_cD" ).append("\n"); 
		query.append("      , CASE WHEN SUBSTR(DMDT_TRF_CD,2,1) = 'M' THEN 'DEM'" ).append("\n"); 
		query.append("             WHEN SUBSTR(DMDT_TRF_CD,2,1) = 'T' THEN 'DET'" ).append("\n"); 
		query.append("         END IF_SRC_CD" ).append("\n"); 
		query.append("      , A.VSL_CD" ).append("\n"); 
		query.append("      , A.SKD_VOY_NO" ).append("\n"); 
		query.append("      , A.SKD_DIR_CD" ).append("\n"); 
		query.append("	  , CASE WHEN A.POL_CD IS NULL THEN A.POD_CD" ).append("\n"); 
		query.append("			ELSE" ).append("\n"); 
		query.append("				A.POL_CD" ).append("\n"); 
		query.append("		END POL_CD" ).append("\n"); 
		query.append("	  , CASE WHEN A.POD_CD IS NULL THEN A.POL_CD" ).append("\n"); 
		query.append("			ELSE" ).append("\n"); 
		query.append("				A.POD_CD" ).append("\n"); 
		query.append("		END POD_CD" ).append("\n"); 
		query.append("      , A.VSL_CD AS TRNK_VSL_CD" ).append("\n"); 
		query.append("      , A.SKD_VOY_NO AS TRNK_SKD_VOY_NO" ).append("\n"); 
		query.append("      , A.SKD_DIR_CD AS TRNK_SKD_DIR_CD" ).append("\n"); 
		query.append("      , A.POR_CD AS POR_CD" ).append("\n"); 
		query.append("      , A.DEL_CD AS DEL_CD" ).append("\n"); 
		query.append("      , (SELECT SUM(DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'2',1,0)) FROM DMT_INV_DTL WHERE DMDT_INV_NO = A.DMDT_INV_NO) AS BKG_TEU_QTY" ).append("\n"); 
		query.append("      , (SELECT SUM(DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'2',0,1)) FROM DMT_INV_DTL WHERE DMDT_INV_NO = A.DMDT_INV_NO) AS BKG_FEU_QTY" ).append("\n"); 
		query.append("      , A.IO_BND_CD" ).append("\n"); 
		query.append("      , @[ar_ofc_cd] AS SLS_OFC_CD" ).append("\n"); 
		query.append("      , A.CRE_USR_ID" ).append("\n"); 
		query.append("      , A.CRE_OFC_CD" ).append("\n"); 
		query.append("	  , TO_CHAR(A.CRE_DT,'yyyymmdd') AS CRE_DT" ).append("\n"); 
		query.append("      , A.UPD_USR_ID" ).append("\n"); 
		query.append("      , A.UPD_OFC_CD" ).append("\n"); 
		query.append("	  , TO_CHAR(A.UPD_DT,'yyyymmdd') AS UPD_DT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	  , INV_REF_NO" ).append("\n"); 
		query.append("	  , REPLACE(REPLACE(INV_RMK,'@*',' '), CHR(10), ' ') AS INV_RMK" ).append("\n"); 
		query.append("	  , ( SELECT B.DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("		  FROM DMT_INV_DTL B" ).append("\n"); 
		query.append("		  WHERE B.DMDT_INV_NO	= A.DMDT_INV_NO" ).append("\n"); 
		query.append("		  AND	B.CRE_OFC_CD	= A.CRE_OFC_CD" ).append("\n"); 
		query.append("		  AND	B.DMDT_CHG_LOC_DIV_CD = 'TSP'" ).append("\n"); 
		query.append("		  AND	ROWNUM = 1 ) AS DEST_TRNS_SVC_MOD_CD" ).append("\n"); 
		query.append("		  	  " ).append("\n"); 
		query.append("FROM DMT_INV_MN A" ).append("\n"); 
		query.append("WHERE A.DMDT_INV_NO = @[invoice_no]" ).append("\n"); 
		query.append("AND A.CRE_OFC_CD = @[cre_ofc_cd]" ).append("\n"); 

	}
}