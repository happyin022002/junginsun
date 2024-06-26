/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BSAYearlyPlanDBDAODeleteBsaBudSltChtrBzcDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.04.15
*@LastModifier : 최윤성
*@LastVersion : 1.0
* 2011.04.15 최윤성
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bsa.bsayearlyplan.bsayearlyplan.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI Yun Sung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BSAYearlyPlanDBDAODeleteBsaBudSltChtrBzcDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BSA_BUD_SLT_CHTR_BZC 데이타를 삭제한다.
	  * </pre>
	  */
	public BSAYearlyPlanDBDAODeleteBsaBudSltChtrBzcDSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bsa.bsayearlyplan.bsayearlyplan.integration").append("\n"); 
		query.append("FileName : BSAYearlyPlanDBDAODeleteBsaBudSltChtrBzcDSQL").append("\n"); 
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
		query.append("DELETE" ).append("\n"); 
		query.append("  FROM BSA_BUD_SLT_CHTR_BZC" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   " ).append("\n"); 
		query.append("#if (${trd_cd} != 'All')" ).append("\n"); 
		query.append("   AND TRD_CD   = @[trd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${rlane_cd} != 'All')" ).append("\n"); 
		query.append("   AND RLANE_CD = @[rlane_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}