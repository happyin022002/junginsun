/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DMTCommonDBDAOSubOfficeNameVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.16
*@LastModifier : 황효근
*@LastVersion : 1.0
* 2009.07.16 황효근
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Hwang HyoKeun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DMTCommonDBDAOSubOfficeNameVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * .
	  * </pre>
	  */
	public DMTCommonDBDAOSubOfficeNameVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtcommon.dmtcommonfinder.integration").append("\n"); 
		query.append("FileName : DMTCommonDBDAOSubOfficeNameVORSQL").append("\n"); 
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
		query.append("SELECT DISTINCT OFC_CD" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#foreach( $ofc_cd in ${prnt_ofc_cd} )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if($velocityCount < $prnt_ofc_cd.size())" ).append("\n"); 
		query.append("SELECT OFC_CD" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT OFC_CD, PRNT_OFC_CD" ).append("\n"); 
		query.append("FROM MDM_ORGANIZATION O" ).append("\n"); 
		query.append(", (	SELECT DISTINCT DMDT_OFC_CD" ).append("\n"); 
		query.append("FROM MDM_YARD" ).append("\n"); 
		query.append("WHERE DMDT_OFC_CD IS NOT NULL" ).append("\n"); 
		query.append("AND DELT_FLG = 'N' ) Y" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE O.OFC_CD = Y.DMDT_OFC_CD" ).append("\n"); 
		query.append("AND NVL(O.DELT_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("START WITH OFC_CD = '$ofc_cd'" ).append("\n"); 
		query.append("CONNECT BY NOCYCLE PRIOR OFC_CD = PRNT_OFC_CD" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("SELECT OFC_CD" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT OFC_CD, PRNT_OFC_CD" ).append("\n"); 
		query.append("FROM MDM_ORGANIZATION O" ).append("\n"); 
		query.append(", (	SELECT DISTINCT DMDT_OFC_CD" ).append("\n"); 
		query.append("FROM MDM_YARD" ).append("\n"); 
		query.append("WHERE DMDT_OFC_CD IS NOT NULL" ).append("\n"); 
		query.append("AND DELT_FLG = 'N' ) Y" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE O.OFC_CD = Y.DMDT_OFC_CD" ).append("\n"); 
		query.append("AND NVL(O.DELT_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("START WITH OFC_CD = '$ofc_cd'" ).append("\n"); 
		query.append("CONNECT BY NOCYCLE PRIOR OFC_CD = PRNT_OFC_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY OFC_CD" ).append("\n"); 

	}
}