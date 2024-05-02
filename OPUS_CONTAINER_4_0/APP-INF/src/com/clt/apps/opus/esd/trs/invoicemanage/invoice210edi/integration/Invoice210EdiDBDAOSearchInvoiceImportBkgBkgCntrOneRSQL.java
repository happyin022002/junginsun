/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : Invoice210EdiDBDAOSearchInvoiceImportBkgBkgCntrOneRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.01
*@LastModifier : 손은주(TRS)
*@LastVersion : 1.0
* 2009.12.01 손은주(TRS)
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.invoicemanage.invoice210edi.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Eun ju Son(TRS)
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Invoice210EdiDBDAOSearchInvoiceImportBkgBkgCntrOneRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchInvoiceImportBkgBkgCntrOne
	  * </pre>
	  */
	public Invoice210EdiDBDAOSearchInvoiceImportBkgBkgCntrOneRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.invoicemanage.invoice210edi.integration").append("\n"); 
		query.append("FileName : Invoice210EdiDBDAOSearchInvoiceImportBkgBkgCntrOneRSQL").append("\n"); 
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
		query.append("A.CNTR_NO," ).append("\n"); 
		query.append("A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("FROM  BKG_CONTAINER A" ).append("\n"); 
		query.append(",BKG_BOOKING  B" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("( A.BKG_NO	 = @[bkg_no]" ).append("\n"); 
		query.append("OR	   A.BKG_NO  = @[org_bkg_no]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND    A.CNTR_NO = @[eq_no]" ).append("\n"); 
		query.append("AND    A.BKG_NO  = B.BKG_NO" ).append("\n"); 
		query.append("AND   'X'	<>   B.BKG_STS_CD" ).append("\n"); 

	}
}