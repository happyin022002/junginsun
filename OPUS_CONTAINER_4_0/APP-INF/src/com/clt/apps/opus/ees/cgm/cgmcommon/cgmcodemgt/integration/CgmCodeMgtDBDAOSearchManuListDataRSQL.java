/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CgmCodeMgtDBDAOSearchManuListDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.16
*@LastModifier : 박의수
*@LastVersion : 1.0
* 2009.06.16 박의수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cgm.cgmcommon.cgmcodemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Eui-su Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CgmCodeMgtDBDAOSearchManuListDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Manufacturer
	  * </pre>
	  */
	public CgmCodeMgtDBDAOSearchManuListDataRSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
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
		query.append("SELECT B.VNDR_SEQ AS CODE1," ).append("\n"); 
		query.append("B.VNDR_LGL_ENG_NM AS DESC1" ).append("\n"); 
		query.append("FROM MDM_CNTR_VNDR_CLSS A," ).append("\n"); 
		query.append("MDM_VENDOR B" ).append("\n"); 
		query.append("WHERE A.CNTR_VNDR_SVC_CD = 'MFR'" ).append("\n"); 
		query.append("AND A.VNDR_SEQ = B.VNDR_SEQ" ).append("\n"); 
		query.append("AND NVL(A.DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("AND NVL(B.DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("ORDER BY B.VNDR_LGL_ENG_NM" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.cgm.cgmcommon.cgmcodemgt.integration").append("\n"); 
		query.append("FileName : CgmCodeMgtDBDAOSearchManuListDataRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}