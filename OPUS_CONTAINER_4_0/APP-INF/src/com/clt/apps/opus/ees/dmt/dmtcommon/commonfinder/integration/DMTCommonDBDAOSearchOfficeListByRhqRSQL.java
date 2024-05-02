/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : DMTCommonDBDAOSearchOfficeListByRhqRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.02
*@LastModifier : 김태균
*@LastVersion : 1.0
* 2011.03.02 김태균
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KimTaeKyun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DMTCommonDBDAOSearchOfficeListByRhqRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchOfficeListByRhq
	  * </pre>
	  */
	public DMTCommonDBDAOSearchOfficeListByRhqRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rhq_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.integration").append("\n"); 
		query.append("FileName : DMTCommonDBDAOSearchOfficeListByRhqRSQL").append("\n"); 
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
		query.append("  FROM MDM_ORGANIZATION O" ).append("\n"); 
		query.append("      , (SELECT DISTINCT DMDT_OFC_CD" ).append("\n"); 
		query.append("                    FROM MDM_YARD Y" ).append("\n"); 
		query.append("                        , (	SELECT DISTINCT OFC_CD" ).append("\n"); 
		query.append("							  FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("							 WHERE NVL (DELT_FLG, ' ') <> 'Y'" ).append("\n"); 
		query.append("						#if (${rhq_ofc_cd} != ${head_office}) " ).append("\n"); 
		query.append("							CONNECT BY PRIOR OFC_CD = PRNT_OFC_CD" ).append("\n"); 
		query.append("							START WITH OFC_CD = @[rhq_ofc_cd]" ).append("\n"); 
		query.append("						#end" ).append("\n"); 
		query.append("						  ) O" ).append("\n"); 
		query.append("                   WHERE Y.DMDT_OFC_CD = O.OFC_CD" ).append("\n"); 
		query.append("                     AND DELT_FLG = 'N') Y" ).append("\n"); 
		query.append(" WHERE O.OFC_CD = Y.DMDT_OFC_CD" ).append("\n"); 
		query.append("   --AND NVL (O.OFC_SLS_DELT_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append("ORDER BY ofc_cd" ).append("\n"); 

	}
}