/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GeneralARInvoiceCreationDBDAOsearchArMstRevVvdTmlRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.13
*@LastModifier : 정휘택
*@LastVersion : 1.0
* 2009.10.13 정휘택
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

public class GeneralARInvoiceCreationDBDAOsearchArMstRevVvdTmlRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GeneralARInvoiceCreationDBDAOsearchArMstRevVvdTmlRSQL
	  * </pre>
	  */
	public GeneralARInvoiceCreationDBDAOsearchArMstRevVvdTmlRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.integration ").append("\n"); 
		query.append("FileName : GeneralARInvoiceCreationDBDAOsearchArMstRevVvdTmlRSQL").append("\n"); 
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
		query.append("SELECT VSL_CD" ).append("\n"); 
		query.append(", SKD_VOY_NO" ).append("\n"); 
		query.append(", 'E' SKD_DIR_CD" ).append("\n"); 
		query.append("FROM AR_MST_REV_VVD" ).append("\n"); 
		query.append("WHERE VSL_CD = 'CFDR'" ).append("\n"); 
		query.append("AND REV_YRMON = (SELECT MAX(REV_YRMON)" ).append("\n"); 
		query.append("FROM AR_MST_REV_VVD" ).append("\n"); 
		query.append("WHERE VSL_CD = 'CFDR')" ).append("\n"); 

	}
}