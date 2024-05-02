/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EacMgtDBDAOEACSpContactPointVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.05
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.01.05 백형인
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.eac.eacmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author HI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EacMgtDBDAOEACSpContactPointVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * S/P Contact point 의 VO 를 설정한다.
	  * </pre>
	  */
	public EacMgtDBDAOEACSpContactPointVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.eac.eacmgt.integration").append("\n"); 
		query.append("FileName : EacMgtDBDAOEACSpContactPointVORSQL").append("\n"); 
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
		query.append("SELECT '' AS VNDR_SEQ" ).append("\n"); 
		query.append("     , '' AS VNDR_CNTC_PNT_SEQ" ).append("\n"); 
		query.append("     , '' AS VNDR_CNTC_PNT_NM" ).append("\n"); 
		query.append("     , '' AS PSN_NM" ).append("\n"); 
		query.append("     , '' AS PSN_DESC" ).append("\n"); 
		query.append("     , '' AS STE_NM" ).append("\n"); 
		query.append("     , '' AS CTY_NM" ).append("\n"); 
		query.append("     , '' AS PHN_NO" ).append("\n"); 
		query.append("     , '' AS FAX_NO" ).append("\n"); 
		query.append("     , '' AS VNDR_EML" ).append("\n"); 
		query.append("     , '' AS EAC_EML_USE_FLG" ).append("\n"); 
		query.append("     , '' AS EAC_FAX_USE_FLG" ).append("\n"); 
		query.append("     , '' AS DELT_FLG" ).append("\n"); 
		query.append("     , '' AS CRE_USR_ID" ).append("\n"); 
		query.append("     , '' AS CRE_DT" ).append("\n"); 
		query.append("     , '' AS UPD_USR_ID" ).append("\n"); 
		query.append("     , '' AS UPD_DT " ).append("\n"); 
		query.append("     , '' AS VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("     , '' AS ZIP_CD" ).append("\n"); 
		query.append("     , '' AS ENG_ADDR" ).append("\n"); 
		query.append("     , '' AS STE_CD" ).append("\n"); 
		query.append("     , '' AS CRE_USR_NM" ).append("\n"); 
		query.append("     , '' AS VNDR_CNTC_PNT_SEQ" ).append("\n"); 
		query.append("     , '' AS EAC_FAX_USE_FLG" ).append("\n"); 
		query.append("     , '' AS EAC_EML_USE_FLG" ).append("\n"); 
		query.append("FROM   DUAL" ).append("\n"); 

	}
}