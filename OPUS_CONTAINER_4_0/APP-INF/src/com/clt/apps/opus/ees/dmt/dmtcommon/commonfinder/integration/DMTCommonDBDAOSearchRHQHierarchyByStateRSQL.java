/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : DMTCommonDBDAOSearchRHQHierarchyByStateRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.02
*@LastModifier : 
*@LastVersion : 1.0
* 2010.02.02 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DMTCommonDBDAOSearchRHQHierarchyByStateRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * State 코드값으로 상위 RHQ, Country 정보를 조회하는 쿼리
	  * </pre>
	  */
	public DMTCommonDBDAOSearchRHQHierarchyByStateRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.integration").append("\n"); 
		query.append("FileName : DMTCommonDBDAOSearchRHQHierarchyByStateRSQL").append("\n"); 
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
		query.append("SELECT	A.STE_CD AS RGN_CD" ).append("\n"); 
		query.append(", 	A.STE_NM AS RGN_NM" ).append("\n"); 
		query.append(",	A.CNT_CD" ).append("\n"); 
		query.append(", 	B.CNT_NM" ).append("\n"); 
		query.append(", 	C.SYS_AREA_GRP_ID AS CONTI_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM	MDM_STATE A" ).append("\n"); 
		query.append(", 	MDM_COUNTRY B" ).append("\n"); 
		query.append(", 	COM_SYS_AREA_GRP_ID C" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE	A.CNT_CD 	IN ('CA', 'US')" ).append("\n"); 
		query.append("AND	A.STE_CD 	= @[ste_cd]" ).append("\n"); 
		query.append("AND A.CNT_CD 	= B.CNT_CD" ).append("\n"); 
		query.append("AND A.CNT_CD 	= C.CNT_CD" ).append("\n"); 
		query.append("AND C.CO_IND_CD = 'H'" ).append("\n"); 

	}
}