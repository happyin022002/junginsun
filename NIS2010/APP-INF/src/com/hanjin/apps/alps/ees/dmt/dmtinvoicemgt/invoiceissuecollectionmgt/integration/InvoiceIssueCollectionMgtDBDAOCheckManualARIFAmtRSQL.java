/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : InvoiceIssueCollectionMgtDBDAOCheckManualARIFAmtRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.19
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.19 
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

public class InvoiceIssueCollectionMgtDBDAOCheckManualARIFAmtRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Manual Invoice의 BIL_AMT - INV_CHG_AMT 값을 조회 한다.
	  * </pre>
	  */
	public InvoiceIssueCollectionMgtDBDAOCheckManualARIFAmtRSQL(){
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
		query.append("FileName : InvoiceIssueCollectionMgtDBDAOCheckManualARIFAmtRSQL").append("\n"); 
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
		query.append("SELECT INV_CURR_CD, NVL(CASE WHEN NVL(( SELECT 'Y' FROM DMT_HRD_CDG_CTNT WHERE HRD_CDG_ID = 'INV_AR_IF' AND ATTR_CTNT1 = A.CR_INV_NO AND ROWNUM = 1 ),'N') = 'Y' " ).append("\n"); 
		query.append("                         THEN BIL_AMT - INV_CHG_AMT" ).append("\n"); 
		query.append("                    ELSE" ).append("\n"); 
		query.append("                        CASE WHEN INV_CURR_CD IN ( 'KRW','JPY' , 'BEF' ,'DJF' , 'ESP' ,'GRD' , 'ITL' ,'LAK' , 'MGF' ,'MRO' , 'MXP' ,'PTE' , 'SDD' ,'MXN' ) THEN" ).append("\n"); 
		query.append("                            TRUNC( BIL_AMT*DECODE(INV_XCH_RT,-1,1,INV_XCH_RT), 0)" ).append("\n"); 
		query.append("                           WHEN INV_CURR_CD IN ( 'TWD','IDR' ) THEN" ).append("\n"); 
		query.append("                            ROUND( BIL_AMT*DECODE(INV_XCH_RT,-1,1,INV_XCH_RT), 0)" ).append("\n"); 
		query.append("                           ELSE" ).append("\n"); 
		query.append("                            ROUND( BIL_AMT*DECODE(INV_XCH_RT,-1,1,INV_XCH_RT), 2)" ).append("\n"); 
		query.append("                           END - INV_CHG_AMT" ).append("\n"); 
		query.append("                     END,0) AS M_AMT" ).append("\n"); 
		query.append("FROM DMT_INV_MN A" ).append("\n"); 
		query.append("WHERE DMDT_INV_NO = @[invoice_no]" ).append("\n"); 
		query.append("AND CRE_OFC_CD = @[cre_ofc_cd]" ).append("\n"); 

	}
}