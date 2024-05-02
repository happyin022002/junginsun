/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ARInvoiceCustomerMgtDBDAOmodifySVATNoUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.10.17
*@LastModifier : 
*@LastVersion : 1.0
* 2011.10.17 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ARInvoiceCustomerMgtDBDAOmodifySVATNoUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * INV_AR_SPND_VAT_RGST_NO insert or update query
	  * </pre>
	  */
	public ARInvoiceCustomerMgtDBDAOmodifySVATNoUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("creUsrId",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("custSeq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("custCntCd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("updUsrId",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svatRgstNo",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.integration").append("\n"); 
		query.append("FileName : ARInvoiceCustomerMgtDBDAOmodifySVATNoUSQL").append("\n"); 
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
		query.append("MERGE INTO INV_AR_SPND_VAT_RGST_NO TT" ).append("\n"); 
		query.append("    USING DUAL" ).append("\n"); 
		query.append("    ON  (TT.CUST_CNT_CD = @[custCntCd] AND TT.CUST_SEQ = @[custSeq])" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("    UPDATE SET" ).append("\n"); 
		query.append("        SPND_VAT_RGST_NO = @[svatRgstNo]" ).append("\n"); 
		query.append("        , UPD_USR_ID = @[updUsrId]" ).append("\n"); 
		query.append("        , UPD_DT = SYSDATE" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("    INSERT  " ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("            CUST_CNT_CD" ).append("\n"); 
		query.append("            , CUST_SEQ" ).append("\n"); 
		query.append("            , SPND_VAT_RGST_NO" ).append("\n"); 
		query.append("            , CRE_USR_ID" ).append("\n"); 
		query.append("            , CRE_DT" ).append("\n"); 
		query.append("            , UPD_USR_ID" ).append("\n"); 
		query.append("            , UPD_DT" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("    VALUES " ).append("\n"); 
		query.append("        (   " ).append("\n"); 
		query.append("            @[custCntCd]" ).append("\n"); 
		query.append("            , @[custSeq]" ).append("\n"); 
		query.append("            , @[svatRgstNo]" ).append("\n"); 
		query.append("            , @[creUsrId]" ).append("\n"); 
		query.append("            , SYSDATE" ).append("\n"); 
		query.append("            , @[updUsrId]" ).append("\n"); 
		query.append("            , SYSDATE" ).append("\n"); 
		query.append("        )" ).append("\n"); 

	}
}