/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : DMTCommonDBDAOOfficeNameVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.11.08
*@LastModifier : 김태균
*@LastVersion : 1.0
* 2010.11.08 김태균
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfinder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM TAE KYUN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DMTCommonDBDAOOfficeNameVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * OfficeNameVO
	  * </pre>
	  */
	public DMTCommonDBDAOOfficeNameVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfinder.integration").append("\n"); 
		query.append("FileName : DMTCommonDBDAOOfficeNameVORSQL").append("\n"); 
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
		query.append("SELECT OFC_CD" ).append("\n"); 
		query.append("      ,OFC_ENG_NM" ).append("\n"); 
		query.append("	  , '' JSPNO" ).append("\n"); 
		query.append("FROM MDM_ORGANIZATION O" ).append("\n"); 
		query.append("      , (SELECT DISTINCT DMDT_OFC_CD" ).append("\n"); 
		query.append("                    FROM MDM_YARD Y" ).append("\n"); 
		query.append("                        ,( SELECT DISTINCT OFC_CD" ).append("\n"); 
		query.append("                           FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("                           WHERE NVL (DELT_FLG, ' ') <> 'Y'" ).append("\n"); 
		query.append("						 ) O" ).append("\n"); 
		query.append("                   WHERE Y.DMDT_OFC_CD = O.OFC_CD" ).append("\n"); 
		query.append("                     AND DELT_FLG = 'N') Y" ).append("\n"); 
		query.append("WHERE O.OFC_CD = Y.DMDT_OFC_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY OFC_CD" ).append("\n"); 

	}
}