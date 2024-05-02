/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DMTCommonDBDAOSearchHierarchyByStateRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.17
*@LastModifier : 이성훈
*@LastVersion : 1.0
* 2009.06.17 이성훈
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author SungHoon, Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DMTCommonDBDAOSearchHierarchyByStateRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchHierarchyByState
	  * </pre>
	  */
	public DMTCommonDBDAOSearchHierarchyByStateRSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ste_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("D.CONTI_CD" ).append("\n"); 
		query.append(",	D.CONTI_NM" ).append("\n"); 
		query.append(",	B.CNT_CD" ).append("\n"); 
		query.append(",	B.CNT_NM" ).append("\n"); 
		query.append(",	A.STE_CD" ).append("\n"); 
		query.append(",	A.STE_NM" ).append("\n"); 
		query.append("FROM MDM_STATE A" ).append("\n"); 
		query.append(",MDM_COUNTRY B" ).append("\n"); 
		query.append(",MDM_SUBCONTINENT C" ).append("\n"); 
		query.append(",MDM_CONTINENT D" ).append("\n"); 
		query.append("WHERE A.STE_CD = @[ste_cd]" ).append("\n"); 
		query.append("AND A.CNT_CD IN ('US','CA')" ).append("\n"); 
		query.append("AND A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND A.CNT_CD = B.CNT_CD" ).append("\n"); 
		query.append("AND B.SCONTI_CD = C.SCONTI_CD" ).append("\n"); 
		query.append("AND C.CONTI_CD = D.CONTI_CD" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtcommon.dmtcommonfinder.integration").append("\n"); 
		query.append("FileName : DMTCommonDBDAOSearchHierarchyByStateRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}