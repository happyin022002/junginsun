/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : DMTCommonDBDAOSearchRHQHierarchyByCountryRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.02
*@LastModifier : 
*@LastVersion : 1.0
* 2010.02.02 
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

public class DMTCommonDBDAOSearchRHQHierarchyByCountryRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Country 코드로 해당 상위 RHQ 코드를 조회하는 쿼리
	  * </pre>
	  */
	public DMTCommonDBDAOSearchRHQHierarchyByCountryRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfinder.integration").append("\n"); 
		query.append("FileName : DMTCommonDBDAOSearchRHQHierarchyByCountryRSQL").append("\n"); 
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
		query.append("SELECT	A.CNT_CD" ).append("\n"); 
		query.append(",	A.CNT_NM" ).append("\n"); 
		query.append(",	B.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM	MDM_COUNTRY A" ).append("\n"); 
		query.append(",	COM_SYS_AREA_GRP_ID B" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE	A.CNT_CD 	= @[cnt_cd]" ).append("\n"); 
		query.append("AND A.CNT_CD 	= B.CNT_CD" ).append("\n"); 
		query.append("AND B.CO_IND_CD = 'H'" ).append("\n"); 

	}
}