/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SCQuotationMainDBDAOPriSqHdrMaxQuotationNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.06
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2010.01.06 이승준
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scquotation.scquotationmain.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Seung-Jun,Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCQuotationMainDBDAOPriSqHdrMaxQuotationNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Max Quotation no
	  * </pre>
	  */
	public SCQuotationMainDBDAOPriSqHdrMaxQuotationNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("qttn_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.scquotation.scquotationmain.integration").append("\n"); 
		query.append("FileName : SCQuotationMainDBDAOPriSqHdrMaxQuotationNoRSQL").append("\n"); 
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
		query.append("SELECT  (SUBSTR(@[qttn_ofc_cd],0,3) || SUBSTR(TO_CHAR(SYSDATE,'YYYYMMDD'),3,2) || 'S' ||" ).append("\n"); 
		query.append("DECODE(LENGTH(A.QTTN_NO), 1, '000' || A.QTTN_NO," ).append("\n"); 
		query.append("2, '00'  || A.QTTN_NO," ).append("\n"); 
		query.append("3, '0'   || A.QTTN_NO," ).append("\n"); 
		query.append("4,A.QTTN_NO)) AS MAX_QTTN_NO" ).append("\n"); 
		query.append("FROM    (" ).append("\n"); 
		query.append("SELECT  TO_NUMBER(SUBSTR(NVL(MAX(QTTN_NO),'0000000000'), 7,4)) + 1 AS QTTN_NO" ).append("\n"); 
		query.append("FROM    PRI_SQ_HDR" ).append("\n"); 
		query.append("WHERE   SUBSTR(NVL(QTTN_NO,'0000000000'), 0,3) = SUBSTR(@[qttn_ofc_cd],0,3)" ).append("\n"); 
		query.append("AND		SUBSTR(NVL(QTTN_NO,'0000000000'), 4,2) = SUBSTR(TO_CHAR(SYSDATE,'YYYYMMDD'),3,2)" ).append("\n"); 
		query.append(") A" ).append("\n"); 

	}
}