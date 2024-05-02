/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : InvoiceIssueCollectionMgtDBDAOInsertIndiaInvoiceNoCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.09.19
*@LastModifier : 
*@LastVersion : 1.0
* 2017.09.19 
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

public class InvoiceIssueCollectionMgtDBDAOInsertIndiaInvoiceNoCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * InvoiceIssueCollectionMgtDBDAOInsertIndiaInvoiceNoCSQL
	  * </pre>
	  */
	public InvoiceIssueCollectionMgtDBDAOInsertIndiaInvoiceNoCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ser_no_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fsc_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_inv_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration").append("\n"); 
		query.append("FileName : InvoiceIssueCollectionMgtDBDAOInsertIndiaInvoiceNoCSQL").append("\n"); 
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
		query.append("INSERT INTO COM_SER_NO_CTNT(" ).append("\n"); 
		query.append("    MDL_ID" ).append("\n"); 
		query.append("   ,SER_NO_DIV_CD" ).append("\n"); 
		query.append("   ,SER_NO_DIV_SEQ" ).append("\n"); 
		query.append("   ,SER_NO_SEQ" ).append("\n"); 
		query.append("   ,ATTR_CTNT1" ).append("\n"); 
		query.append("   ,ATTR_CTNT2" ).append("\n"); 
		query.append("   ,ATTR_CTNT3" ).append("\n"); 
		query.append("   ,CRE_USR_ID" ).append("\n"); 
		query.append("   ,CRE_DT" ).append("\n"); 
		query.append("   ,UPD_USR_ID" ).append("\n"); 
		query.append("   ,UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES(" ).append("\n"); 
		query.append("    'DMT'" ).append("\n"); 
		query.append("   ,'II'" ).append("\n"); 
		query.append("   ,(" ).append("\n"); 
		query.append("		SELECT  NVL(MAX(SER_NO_DIV_SEQ), 0) + 1" ).append("\n"); 
		query.append("		  FROM  COM_SER_NO_CTNT" ).append("\n"); 
		query.append("		 WHERE  MDL_ID        = 'DMT'" ).append("\n"); 
		query.append("		   AND  SER_NO_DIV_CD = 'II'" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("   ,@[ser_no_seq]" ).append("\n"); 
		query.append("   ,@[ofc_cty_cd]" ).append("\n"); 
		query.append("   ,@[fsc_yr]" ).append("\n"); 
		query.append("   ,@[dmdt_inv_no]" ).append("\n"); 
		query.append("   ,@[usr_id]" ).append("\n"); 
		query.append("   ,SYSDATE" ).append("\n"); 
		query.append("   ,@[usr_id]" ).append("\n"); 
		query.append("   ,SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}