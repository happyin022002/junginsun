/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : DMTCommonDBDAOSearchOfficeListByRhqRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.12
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.12 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfinder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
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
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfinder.integration").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("  DISTINCT OFC_CD ,OFC_ENG_NM" ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("  MDM_ORGANIZATION" ).append("\n"); 
		query.append("WHERE " ).append("\n"); 
		query.append("  NVL (DELT_FLG, ' ') <> 'Y'" ).append("\n"); 
		query.append("  #if (${ots_flg} != '') " ).append("\n"); 
		query.append("  AND OFC_KND_CD IN ( 3,4,5,6 )" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  #if (${rhq_ofc_cd} != 'SELHO') " ).append("\n"); 
		query.append("  CONNECT BY PRIOR OFC_CD = PRNT_OFC_CD" ).append("\n"); 
		query.append("  START WITH OFC_CD = @[rhq_ofc_cd]" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("ORDER BY OFC_CD" ).append("\n"); 

	}
}