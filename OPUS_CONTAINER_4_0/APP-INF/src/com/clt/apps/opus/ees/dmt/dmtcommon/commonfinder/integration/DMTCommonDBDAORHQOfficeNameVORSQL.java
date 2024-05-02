/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : DMTCommonDBDAORHQOfficeNameVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.23
*@LastModifier : 김태균
*@LastVersion : 1.0
* 2011.03.23 김태균
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

public class DMTCommonDBDAORHQOfficeNameVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RHQOfficeNameVO
	  * </pre>
	  */
	public DMTCommonDBDAORHQOfficeNameVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.integration").append("\n"); 
		query.append("FileName : DMTCommonDBDAORHQOfficeNameVORSQL").append("\n"); 
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
		query.append("/*" ).append("\n"); 
		query.append("SELECT DISTINCT A.OFC_CD" ).append("\n"); 
		query.append("               ,A.OFC_ENG_NM" ).append("\n"); 
		query.append("           FROM MDM_ORGANIZATION A" ).append("\n"); 
		query.append("               ,MDM_ORGANIZATION B" ).append("\n"); 
		query.append("          WHERE A.OFC_CD = B.AR_HD_QTR_OFC_CD" ).append("\n"); 
		query.append("            AND NVL(A.DELT_FLG,'N') = 'N'" ).append("\n"); 
		query.append("       ORDER BY A.OFC_CD ASC" ).append("\n"); 
		query.append("*/" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT OFC_N8TH_LVL_CD" ).append("\n"); 
		query.append("  FROM DMT_OFC_LVL_V" ).append("\n"); 
		query.append(" WHERE OFC_KND_CD = 2 " ).append("\n"); 
		query.append("   AND OFC_LVL = 2" ).append("\n"); 

	}
}