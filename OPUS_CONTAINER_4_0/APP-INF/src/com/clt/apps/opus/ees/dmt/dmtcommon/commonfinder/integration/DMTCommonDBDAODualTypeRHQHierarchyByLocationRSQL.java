/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DMTCommonDBDAODualTypeRHQHierarchyByLocationRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.25
*@LastModifier : 이성훈
*@LastVersion : 1.0
* 2009.05.25 이성훈
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author SungHoon, Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DMTCommonDBDAODualTypeRHQHierarchyByLocationRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Location 을 포함하는 Dual Type 의 RHQ, Country, Region or State 를 조회하는 쿼리
	  * </pre>
	  */
	public DMTCommonDBDAODualTypeRHQHierarchyByLocationRSQL(){
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
		query.append("SELECT	A.CNT_CD, B.CNT_NM, A.RGN_CD, C.RGN_NM, A.STE_CD, D.STE_NM" ).append("\n"); 
		query.append("FROM	DMT_CALC_TP A, MDM_COUNTRY B, MDM_REGION C, MDM_STATE D" ).append("\n"); 
		query.append("WHERE	A.LOC_CD = @[loc_cd]" ).append("\n"); 
		query.append("AND A.DMDT_CALC_TP_CD = 'D'" ).append("\n"); 
		query.append("AND A.CNT_CD = B.CNT_CD" ).append("\n"); 
		query.append("AND A.CNT_CD = C.CNT_CD(+)" ).append("\n"); 
		query.append("AND A.RGN_CD = C.RGN_CD(+)" ).append("\n"); 
		query.append("AND A.CNT_CD = D.CNT_CD(+)" ).append("\n"); 
		query.append("AND A.STE_CD = D.STE_CD(+)" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtcommon.dmtcommonfinder.integration ").append("\n"); 
		query.append("FileName : DMTCommonDBDAODualTypeRHQHierarchyByLocationRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}