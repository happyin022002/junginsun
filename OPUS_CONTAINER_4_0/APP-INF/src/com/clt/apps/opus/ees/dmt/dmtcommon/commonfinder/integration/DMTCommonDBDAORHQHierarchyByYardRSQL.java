/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : DMTCommonDBDAORHQHierarchyByYardRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.03
*@LastModifier : 김성욱
*@LastVersion : 1.0
* 2016.02.03 김성욱
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sung-Wook Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DMTCommonDBDAORHQHierarchyByYardRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Yard를 포함하는 RHQ, Country, Region or State, Location 정보를 조회하는 쿼리
	  * </pre>
	  */
	public DMTCommonDBDAORHQHierarchyByYardRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.integration").append("\n"); 
		query.append("FileName : DMTCommonDBDAORHQHierarchyByYardRSQL").append("\n"); 
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
		query.append("SELECT	A.CNT_CD, B.CNT_NM, A.RGN_CD, C.RGN_NM, A.STE_CD, D.STE_NM, A.LOC_CD, A.LOC_NM, E.SYS_AREA_GRP_ID SVR_ID" ).append("\n"); 
		query.append("  FROM	MDM_LOCATION A, MDM_COUNTRY B, MDM_REGION C, MDM_STATE D, COM_SYS_AREA_GRP_ID E, MDM_YARD F" ).append("\n"); 
		query.append(" WHERE	1=1" ).append("\n"); 
		query.append("   AND A.CNT_CD = B.CNT_CD" ).append("\n"); 
		query.append("   AND A.RGN_CD = C.RGN_CD(+)" ).append("\n"); 
		query.append("   AND A.CNT_CD = D.CNT_CD(+)" ).append("\n"); 
		query.append("   AND A.STE_CD = D.STE_CD(+)" ).append("\n"); 
		query.append("   AND A.CNT_CD = E.CNT_CD" ).append("\n"); 
		query.append("   AND E.CO_IND_CD = 'H'" ).append("\n"); 
		query.append("   AND F.YD_CD = @[yd_cd]" ).append("\n"); 
		query.append("   AND F.LOC_CD = A.LOC_CD" ).append("\n"); 

	}
}