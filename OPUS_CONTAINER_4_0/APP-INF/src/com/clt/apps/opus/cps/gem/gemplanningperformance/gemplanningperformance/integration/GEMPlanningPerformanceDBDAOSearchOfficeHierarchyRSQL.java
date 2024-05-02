/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GEMPlanningPerformanceDBDAOSearchOfficeHierarchyRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.19
*@LastModifier : 진윤오
*@LastVersion : 1.0
* 2009.05.19 진윤오
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.integration;

import java.util.HashMap;

import org.apache.log4j.Logger;

import com.clt.framework.core.layer.integration.DAO;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author J.Y.O
 * @see DAO 참조
 * @since J2EE 1.4
 */

public class GEMPlanningPerformanceDBDAOSearchOfficeHierarchyRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 로그인 조직(Office)의 Hierarchy 구조 조회
	  * </pre>
	  */
	public GEMPlanningPerformanceDBDAOSearchOfficeHierarchyRSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("SELECT L_1 LEVEL1" ).append("\n"); 
		query.append(",L_2 LEVEL2" ).append("\n"); 
		query.append(",L_3 LEVEL3" ).append("\n"); 
		query.append(",L_4 LEVEL4" ).append("\n"); 
		query.append(",RGN_OFC_FLG" ).append("\n"); 
		query.append("FROM   GEM_OFC_LEVEL_V" ).append("\n"); 
		query.append("WHERE  L_4 = @[ofc_cd]" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.nis2010.cps.gem.gemplanningperformance.gemplanningperformance.integration").append("\n"); 
		query.append("FileName : GEMPlanningPerformanceDBDAOSearchOfficeHierarchyRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}