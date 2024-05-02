/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DMTCommonDBDAOSheetOptionByOfficeVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.21
*@LastModifier : 김태균
*@LastVersion : 1.0
* 2009.12.21 김태균
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfinder.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Tae Kyun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DMTCommonDBDAOSheetOptionByOfficeVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SheetOptionVO 생성
	  * </pre>
	  */
	public DMTCommonDBDAOSheetOptionByOfficeVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtcommon.dmtcommonfinder.integration ").append("\n"); 
		query.append("FileName : DMTCommonDBDAOSheetOptionByOfficeVORSQL").append("\n"); 
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
		query.append("'' AS DC_AMT_FLG" ).append("\n"); 
		query.append(",	'' AS OFC_CD" ).append("\n"); 
		query.append(",	'' AS BIL_TO_LOC_DIV_CD" ).append("\n"); 
		query.append(",	'' AS CUST_REF_PRN_FLG" ).append("\n"); 
		query.append(",	'' AS PHN_FAX_PRN_FLG" ).append("\n"); 
		query.append(",	'' AS CUST_VAT_PRN_FLG" ).append("\n"); 
		query.append(",	'' AS DFLT_TAX_RTO" ).append("\n"); 
		query.append(",	'' AS TAX_AMT_PRN_FLG" ).append("\n"); 
		query.append(",	'' AS CRE_USR_ID" ).append("\n"); 
		query.append(",	'' AS CRE_DT" ).append("\n"); 
		query.append(",	'' AS UPD_USR_ID" ).append("\n"); 
		query.append(",	'' AS UPD_DT" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}