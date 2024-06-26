/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : Invoice210EdiDBDAOSearchInvoiceVndrRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.13
*@LastModifier : 최진오
*@LastVersion : 1.0
* 2009.10.13 최진오
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.invoicemanage.invoice210edi.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author JIN O CHOI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Invoice210EdiDBDAOSearchInvoiceVndrRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchInvoiceVndr SELECT
	  * </pre>
	  */
	public Invoice210EdiDBDAOSearchInvoiceVndrRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wo_vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.invoicemanage.invoice210edi.integration ").append("\n"); 
		query.append("FileName : Invoice210EdiDBDAOSearchInvoiceVndrRSQL").append("\n"); 
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
		query.append("WO_VNDR_SEQ," ).append("\n"); 
		query.append("INV_VNDR_SEQ" ).append("\n"); 
		query.append("FROM  TRS_TRSP_INV_EDI_VNDR" ).append("\n"); 
		query.append("WHERE WO_VNDR_SEQ = @[wo_vndr_seq]" ).append("\n"); 

	}
}