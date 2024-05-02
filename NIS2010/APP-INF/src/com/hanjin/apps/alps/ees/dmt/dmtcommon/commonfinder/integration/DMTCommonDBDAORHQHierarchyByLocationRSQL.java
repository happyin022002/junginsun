/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DMTCommonDBDAORHQHierarchyByLocationRSQL.java
*@FileTitle : Current Collection Status by Office
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.21
*@LastModifier : 황효근
*@LastVersion : 1.0
* 2009.09.21 황효근
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfinder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Hwang HyoKeun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DMTCommonDBDAORHQHierarchyByLocationRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Location 을 포함하는 RHQ, Country, Region or State 정보를 조회하는 쿼리
	  * </pre>
	  */
	public DMTCommonDBDAORHQHierarchyByLocationRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtcommon.dmtcommonfinder.integration").append("\n"); 
		query.append("FileName : DMTCommonDBDAORHQHierarchyByLocationRSQL").append("\n"); 
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
		query.append("SELECT	A.CNT_CD, B.CNT_NM, A.RGN_CD, C.RGN_NM, A.STE_CD, D.STE_NM, E.SYS_AREA_GRP_ID SVR_ID" ).append("\n"); 
		query.append("FROM	MDM_LOCATION A, MDM_COUNTRY B, MDM_REGION C, MDM_STATE D, COM_SYS_AREA_GRP_ID E" ).append("\n"); 
		query.append("WHERE	A.LOC_CD = @[loc_cd]" ).append("\n"); 
		query.append("AND A.CNT_CD = B.CNT_CD" ).append("\n"); 
		query.append("AND A.RGN_CD = C.RGN_CD(+)" ).append("\n"); 
		query.append("AND A.CNT_CD = D.CNT_CD(+)" ).append("\n"); 
		query.append("AND A.STE_CD = D.STE_CD(+)" ).append("\n"); 
		query.append("AND A.CNT_CD = E.CNT_CD" ).append("\n"); 
		query.append("AND E.CO_IND_CD = 'H'" ).append("\n"); 

	}
}