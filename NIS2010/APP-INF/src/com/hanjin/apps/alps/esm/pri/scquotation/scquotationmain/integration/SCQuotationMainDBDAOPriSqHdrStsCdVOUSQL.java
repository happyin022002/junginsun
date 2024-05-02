/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SCQuotationMainDBDAOPriSqHdrStsCdVOUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.16
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2010.04.16 공백진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scquotation.scquotationmain.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kong Back Jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCQuotationMainDBDAOPriSqHdrStsCdVOUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Proposal 삭제 시 해당하는 Quotation Header 의 qttn_sts_cd 를 N으로 업데이트 한다.
	  * </pre>
	  */
	public SCQuotationMainDBDAOPriSqHdrStsCdVOUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.scquotation.scquotationmain.integration").append("\n"); 
		query.append("FileName : SCQuotationMainDBDAOPriSqHdrStsCdVOUSQL").append("\n"); 
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
		query.append("UPDATE PRI_SQ_HDR" ).append("\n"); 
		query.append("SET QTTN_STS_CD ='N'" ).append("\n"); 
		query.append("WHERE QTTN_NO =" ).append("\n"); 
		query.append("			(" ).append("\n"); 
		query.append("			SELECT QTTN_NO FROM PRI_SQ_MN " ).append("\n"); 
		query.append("			WHERE PROP_NO =@[prop_no]" ).append("\n"); 
		query.append("			AND ROWNUM = 1" ).append("\n"); 
		query.append("			)" ).append("\n"); 

	}
}