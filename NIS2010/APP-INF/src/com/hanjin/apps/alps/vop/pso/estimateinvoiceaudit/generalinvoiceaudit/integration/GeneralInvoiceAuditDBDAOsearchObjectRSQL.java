/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GeneralInvoiceAuditDBDAOsearchObjectRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.18
*@LastModifier : 김진일
*@LastVersion : 1.0
* 2009.06.18 김진일
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Jin Ihl
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralInvoiceAuditDBDAOsearchObjectRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchObject
	  * </pre>
	  */
	public GeneralInvoiceAuditDBDAOsearchObjectRSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xpr",new String[]{arrTmp[0],arrTmp[1]});
	}
	/**
	 * 
	 * @param strXpr
	 */
	public GeneralInvoiceAuditDBDAOsearchObjectRSQL(String strXpr){
		setQuery(strXpr);
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
	public void setQuery(String strXpr){
		query.append("SELECT  DISTINCT REGEXP_SUBSTR (xpr," ).append("\n"); 
		query.append("'\\[[0-9]+\\]'," ).append("\n"); 
		query.append("1," ).append("\n"); 
		query.append("b.rn) OBJECT_NO" ).append("\n"); 
		query.append("FROM   (SELECT   '"+strXpr.replace("'", "''")+"' xpr FROM DUAL) a," ).append("\n"); 
		query.append("(SELECT   ROWNUM rn" ).append("\n"); 
		query.append("FROM   (SELECT   1" ).append("\n"); 
		query.append("FROM   dict" ).append("\n"); 
		query.append("WHERE   ROWNUM <= 100), (SELECT   1" ).append("\n"); 
		query.append("FROM   dict" ).append("\n"); 
		query.append("WHERE   ROWNUM <= 100)) b" ).append("\n"); 
		query.append("WHERE   REGEXP_INSTR (xpr," ).append("\n"); 
		query.append("'\\[[0-9]+\\]'," ).append("\n"); 
		query.append("1," ).append("\n"); 
		query.append("b.rn) > 0" ).append("\n"); 
		
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration").append("\n"); 
		query.append("FileName : GeneralInvoiceAuditDBDAOsearchObjectRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
	/**
	 * Query 생성
	 */
	public void setQuery(){
		query.append("SELECT  DISTINCT REGEXP_SUBSTR (xpr," ).append("\n"); 
		query.append("'(#[0-9]#)+'," ).append("\n"); 
		query.append("1," ).append("\n"); 
		query.append("b.rn) OBJECT_NO" ).append("\n"); 
		query.append("FROM   (SELECT   replace(replace(@[xpr], '[', '#'), ']', '#') xpr FROM DUAL) a," ).append("\n"); 
		query.append("(SELECT   ROWNUM rn" ).append("\n"); 
		query.append("FROM   (SELECT   1" ).append("\n"); 
		query.append("FROM   dict" ).append("\n"); 
		query.append("WHERE   ROWNUM <= 100), (SELECT   1" ).append("\n"); 
		query.append("FROM   dict" ).append("\n"); 
		query.append("WHERE   ROWNUM <= 100)) b" ).append("\n"); 
		query.append("WHERE   REGEXP_INSTR (xpr," ).append("\n"); 
		query.append("'(#[0-9]#)+'," ).append("\n"); 
		query.append("1," ).append("\n"); 
		query.append("b.rn) > 0" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration").append("\n"); 
		query.append("FileName : GeneralInvoiceAuditDBDAOsearchObjectRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}