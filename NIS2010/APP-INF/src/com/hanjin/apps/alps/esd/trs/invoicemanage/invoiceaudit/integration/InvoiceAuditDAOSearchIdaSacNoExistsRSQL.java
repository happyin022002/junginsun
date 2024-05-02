/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : InvoiceAuditDAOSearchIdaSacNoExistsRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.08.17
*@LastModifier : 
*@LastVersion : 1.0
* 2017.08.17 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.invoicemanage.invoiceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceAuditDAOSearchIdaSacNoExistsRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * IDA SAC NO CHECK
	  * </pre>
	  */
	public InvoiceAuditDAOSearchIdaSacNoExistsRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sac_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.invoicemanage.invoiceaudit.integration").append("\n"); 
		query.append("FileName : InvoiceAuditDAOSearchIdaSacNoExistsRSQL").append("\n"); 
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
		query.append("SELECT DECODE (COUNT (*), 0, 'N', 'Y') AS SAC_NO_EXIST" ).append("\n"); 
		query.append("  FROM BKG_IDA_SAC_MST " ).append("\n"); 
		query.append(" WHERE 1 = 1 AND NVL (DELT_FLG, 'N') = 'N' AND IDA_SAC_CD = @[sac_no]" ).append("\n"); 

	}
}