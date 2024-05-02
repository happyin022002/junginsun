/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BLIssuanceDBDAOBkgEmlEdtRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.27
*@LastModifier : 
*@LastVersion : 1.0
* 2010.05.27 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLIssuanceDBDAOBkgEmlEdtRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BkgEmlEdt
	  * </pre>
	  */
	public BLIssuanceDBDAOBkgEmlEdtRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration").append("\n"); 
		query.append("FileName : BLIssuanceDBDAOBkgEmlEdtRSQL").append("\n"); 
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
		query.append("SELECT '' AS EDT_BKG_NO_LIST," ).append("\n"); 
		query.append("       '' AS EDT_NTC_KND_CD," ).append("\n"); 
		query.append("       '' AS EDT_TO_EML," ).append("\n"); 
		query.append("       '' AS EDT_CC_EML," ).append("\n"); 
		query.append("       '' AS EDT_FROM_EML," ).append("\n"); 
		query.append("       '' AS EDT_SUBJECT," ).append("\n"); 
		query.append("       '' AS EDT_CONTENTS" ).append("\n"); 
		query.append("  FROM DUAL" ).append("\n"); 

	}
}