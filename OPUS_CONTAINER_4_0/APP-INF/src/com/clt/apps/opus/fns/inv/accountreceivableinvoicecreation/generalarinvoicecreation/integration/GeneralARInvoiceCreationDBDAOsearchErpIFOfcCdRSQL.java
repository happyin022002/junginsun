/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GeneralARInvoiceCreationDBDAOsearchErpIFOfcCdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.22
*@LastModifier : 정휘택
*@LastVersion : 1.0
* 2009.10.22 정휘택
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jung Hwi Taek
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralARInvoiceCreationDBDAOsearchErpIFOfcCdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GeneralARInvoiceCreationDBDAOsearchErpIFOfcCdRSQL
	  * </pre>
	  */
	public GeneralARInvoiceCreationDBDAOsearchErpIFOfcCdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.integration ").append("\n"); 
		query.append("FileName : GeneralARInvoiceCreationDBDAOsearchErpIFOfcCdRSQL").append("\n"); 
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
		query.append("SELECT CR_CLT_OFC_CD" ).append("\n"); 
		query.append("FROM MDM_CR_CUST" ).append("\n"); 
		query.append("WHERE CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("AND CUST_SEQ = @[cust_seq]" ).append("\n"); 

	}
}