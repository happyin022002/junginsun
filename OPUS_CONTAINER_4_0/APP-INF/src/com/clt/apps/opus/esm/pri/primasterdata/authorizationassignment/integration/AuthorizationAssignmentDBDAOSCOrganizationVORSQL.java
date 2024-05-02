/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : AuthorizationAssignmentDBDAOSCOrganizationVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.23
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2011.02.23 송민석
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.primasterdata.authorizationassignment.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author SONG Min Seok
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AuthorizationAssignmentDBDAOSCOrganizationVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * S/C Organization Tree
	  * </pre>
	  */
	public AuthorizationAssignmentDBDAOSCOrganizationVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.primasterdata.authorizationassignment.integration").append("\n"); 
		query.append("FileName : AuthorizationAssignmentDBDAOSCOrganizationVORSQL").append("\n"); 
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
		query.append("	SELECT  OFC.LVL AS LVL" ).append("\n"); 
		query.append("	 		, OFC.PRNT_OFC_CD" ).append("\n"); 
		query.append("            , OFC.OFC_CD" ).append("\n"); 
		query.append("            ,  OFC.OFC_ENG_NM" ).append("\n"); 
		query.append("			, OFC.BY_PATH" ).append("\n"); 
		query.append("    FROM " ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("        SELECT LEVEL AS LVL" ).append("\n"); 
		query.append("             , PRNT_OFC_CD" ).append("\n"); 
		query.append("             , OFC_CD" ).append("\n"); 
		query.append("             , OFC_CD AS OFC_ENG_NM" ).append("\n"); 
		query.append("             , LTRIM(SYS_CONNECT_BY_PATH(LPAD(OFC_CD, 6, ' '), '|'), '|') BY_PATH" ).append("\n"); 
		query.append("             , CONNECT_BY_ISLEAF" ).append("\n"); 
		query.append("        FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("        WHERE 1=1" ).append("\n"); 
		query.append("        AND   DECODE(DELT_FLG, 'Y', 0, 1) = 1" ).append("\n"); 
		query.append("        START WITH OFC_CD=COM_ConstantMgr_PKG.COM_getHeadOfficeCode_FNC()" ).append("\n"); 
		query.append("        CONNECT BY PRIOR OFC_CD = PRNT_OFC_CD" ).append("\n"); 
		query.append("        ORDER SIBLINGS BY OFC_CD" ).append("\n"); 
		query.append("    ) OFC, (SELECT OFC_CD FROM TABLE(COM_OfficeCodeMgr_PKG.COM_getOfficeCodeList_FNC('000001','PRI'))) APP_OFC" ).append("\n"); 
		query.append("    WHERE     OFC.BY_PATH LIKE '%' || LPAD(APP_OFC.OFC_CD,6,' ')" ).append("\n"); 
		query.append("    order by by_path" ).append("\n"); 

	}
}