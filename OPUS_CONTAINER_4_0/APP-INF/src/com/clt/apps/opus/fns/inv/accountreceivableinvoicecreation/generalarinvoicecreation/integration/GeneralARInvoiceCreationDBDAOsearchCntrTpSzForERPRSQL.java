/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GeneralARInvoiceCreationDBDAOsearchCntrTpSzForERPRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.26
*@LastModifier : 정휘택
*@LastVersion : 1.0
* 2009.10.26 정휘택
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

public class GeneralARInvoiceCreationDBDAOsearchCntrTpSzForERPRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GeneralARInvoiceCreationDBDAOsearchCntrTpSzForERPRSQL
	  * </pre>
	  */
	public GeneralARInvoiceCreationDBDAOsearchCntrTpSzForERPRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("if_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.integration ").append("\n"); 
		query.append("FileName : GeneralARInvoiceCreationDBDAOsearchCntrTpSzForERPRSQL").append("\n"); 
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
		query.append("SELECT A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append(", NVL(COUNT(1),0) CNTR_TPSZ_CNT" ).append("\n"); 
		query.append("FROM INV_AR_CNTR A" ).append("\n"); 
		query.append("WHERE A.AR_IF_NO = @[if_no]" ).append("\n"); 
		query.append("GROUP BY A.CNTR_TPSZ_CD" ).append("\n"); 

	}
}