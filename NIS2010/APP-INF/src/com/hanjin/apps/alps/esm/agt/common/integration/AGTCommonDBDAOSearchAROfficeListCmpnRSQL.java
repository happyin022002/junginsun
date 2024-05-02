/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : AGTCommonDBDAOSearchAROfficeListCmpnRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.04.22
*@LastModifier : 박성진
*@LastVersion : 1.0
* 2011.04.22 박성진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.agt.common.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SungJin Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGTCommonDBDAOSearchAROfficeListCmpnRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchAROfficeListCmpn
	  * </pre>
	  */
	public AGTCommonDBDAOSearchAROfficeListCmpnRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("code",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.agt.common.integration").append("\n"); 
		query.append("FileName : AGTCommonDBDAOSearchAROfficeListCmpnRSQL").append("\n"); 
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
		query.append("OR2.AR_OFC_CD CODE," ).append("\n"); 
		query.append("OR2.AR_OFC_CD NAME" ).append("\n"); 
		query.append("FROM MDM_ORGANIZATION ORG," ).append("\n"); 
		query.append("MDM_ORGANIZATION OR2" ).append("\n"); 
		query.append("WHERE OR2.AR_OFC_CD IS NOT NULL" ).append("\n"); 
		query.append("AND OR2.OFC_CD" ).append("\n"); 
		query.append("IN" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN ORG.AR_OFC_CD = OR2.AR_HD_QTR_OFC_CD" ).append("\n"); 
		query.append("THEN OR2.OFC_CD" ).append("\n"); 
		query.append("WHEN ORG.AR_OFC_CD = OR2.AR_OFC_CD" ).append("\n"); 
		query.append("THEN OR2.OFC_CD" ).append("\n"); 
		query.append("ELSE ORG.OFC_CD" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND ORG.OFC_CD = @[code]" ).append("\n"); 
		query.append("GROUP BY OR2.AR_OFC_CD" ).append("\n"); 
		query.append("ORDER BY OR2.AR_OFC_CD" ).append("\n"); 

	}
}