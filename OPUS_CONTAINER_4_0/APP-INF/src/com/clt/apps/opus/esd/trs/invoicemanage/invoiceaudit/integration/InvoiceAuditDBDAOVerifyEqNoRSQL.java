/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : InvoiceAuditDBDAOVerifyEqNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.10.19
*@LastModifier : 
*@LastVersion : 1.0
* 2015.10.19 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.invoicemanage.invoiceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceAuditDBDAOVerifyEqNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Chassis,Genset,Container  체크
	  * </pre>
	  */
	public InvoiceAuditDBDAOVerifyEqNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.invoicemanage.invoiceaudit.integration").append("\n"); 
		query.append("FileName : InvoiceAuditDBDAOVerifyEqNoRSQL").append("\n"); 
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
		query.append("SELECT EQ_NO      EQ_NO" ).append("\n"); 
		query.append("      ,EQ_TPSZ_CD TP_CD" ).append("\n"); 
		query.append("  FROM CGM_EQUIPMENT" ).append("\n"); 
		query.append(" WHERE EQ_NO = @[eq_no]" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT CNTR_NO      EQ_NO" ).append("\n"); 
		query.append("      ,CNTR_TPSZ_CD TP_CD" ).append("\n"); 
		query.append("  FROM MST_CONTAINER" ).append("\n"); 
		query.append(" WHERE CNTR_NO LIKE CASE WHEN LENGTH(@[eq_no]) >= 10 THEN SUBSTR(@[eq_no], 0, 10) || '%' END" ).append("\n"); 

	}
}