/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : InvoiceIssueCollectionMgtDBDAOSearchInterfaceChargeByInvoiceRateRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.15
*@LastModifier : 
*@LastVersion : 1.0
* 2014.04.15 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lim Chang Bin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceIssueCollectionMgtDBDAOSearchInterfaceChargeByInvoiceRateRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Invoice Rate 조회하여 Interface 한다.
	  * </pre>
	  */
	public InvoiceIssueCollectionMgtDBDAOSearchInterfaceChargeByInvoiceRateRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("cre_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration").append("\n"); 
		query.append("FileName : InvoiceIssueCollectionMgtDBDAOSearchInterfaceChargeByInvoiceRateRSQL").append("\n"); 
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
		query.append("SELECT   ''                                                 AS SRC_IF_DT" ).append("\n"); 
		query.append("        ,''                                                 AS SRC_IF_SEQ" ).append("\n"); 
		query.append("        , CHG_SEQ" ).append("\n"); 
		query.append("        , CURR_CD" ).append("\n"); 
		query.append("        , CHG_CD" ).append("\n"); 
		query.append("        , PER_TP_CD" ).append("\n"); 
		query.append("        , TRF_RT_AMT" ).append("\n"); 
		query.append("        , RAT_AS_CNTR_QTY" ).append("\n"); 
		query.append("        , (-1) * CHG_AMT                                    AS CHG_AMT" ).append("\n"); 
		query.append("        , TRF_NO" ).append("\n"); 
		query.append("        , 'N'                                               AS TVA_FLG" ).append("\n"); 
		query.append("        , T2.CRE_USR_ID                                     AS CRE_USR_ID" ).append("\n"); 
		query.append("        , TO_CHAR(T2.CRE_DT, 'YYYYMMDD')                    AS CRE_DT" ).append("\n"); 
		query.append("        , T2.UPD_USR_ID                                     AS UPD_USR_ID" ).append("\n"); 
		query.append("        , TO_CHAR(T2.UPD_DT, 'YYYYMMDD')                    AS UPD_DT" ).append("\n"); 
		query.append("FROM    INV_AR_CHG      T1," ).append("\n"); 
		query.append("        DMT_INV_MN      T2" ).append("\n"); 
		query.append("WHERE   1=1" ).append("\n"); 
		query.append("AND     T1.AR_IF_NO     IN" ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("        SELECT  T1.AR_IF_NO" ).append("\n"); 
		query.append("        FROM    DMT_INV_MN T1," ).append("\n"); 
		query.append("                DMT_INV_MN T2" ).append("\n"); 
		query.append("        WHERE   T1.DMDT_INV_NO  = T2.CR_INV_NO" ).append("\n"); 
		query.append("        AND     T2.DMDT_INV_NO  = @[invoice_no]" ).append("\n"); 
		query.append("        AND     T2.CRE_OFC_CD   = @[cre_ofc_cd]" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("AND     T2.DMDT_INV_NO  = @[invoice_no]" ).append("\n"); 
		query.append("AND     T2.CRE_OFC_CD   = @[cre_ofc_cd]" ).append("\n"); 

	}
}