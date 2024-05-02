/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GEMPlanningPerformanceDBDAOSearchExpenseGroupByLvlRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.12
*@LastModifier : 진윤오
*@LastVersion : 1.0
* 2009.05.12 진윤오
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.integration;

import java.util.HashMap;

import org.apache.log4j.Logger;

import com.hanjin.framework.core.layer.integration.DAO;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author J.Y.O
 * @see DAO 참조
 * @since J2EE 1.4
 */

public class GEMPlanningPerformanceDBDAOSearchExpenseGroupByLvlRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 그룹레벨별로 expens 정보 취득
	  * </pre>
	  */
	public GEMPlanningPerformanceDBDAOSearchExpenseGroupByLvlRSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gen_expn_grp_lvl",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("select GEN_EXPN_CD , ENG_ABBR_NM , KRN_ABBR_NM" ).append("\n"); 
		query.append("from GEM_EXPENSE" ).append("\n"); 
		query.append("where GEN_EXPN_GRP_LVL = @[gen_expn_grp_lvl]" ).append("\n"); 
		query.append("and DELT_FLG = 'N'" ).append("\n"); 
		query.append("order by GEN_EXPN_CD" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.nis2010.cps.gem.gemplanningperformance.gemplanningperformance.integration").append("\n"); 
		query.append("FileName : GEMPlanningPerformanceDBDAOSearchExpenseGroupByLvlRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}