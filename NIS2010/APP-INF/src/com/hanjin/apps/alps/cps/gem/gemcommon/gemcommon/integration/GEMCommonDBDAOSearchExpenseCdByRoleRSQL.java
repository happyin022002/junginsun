/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : GEMCommonDBDAOSearchExpenseCdByRoleRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.09
*@LastModifier : 
*@LastVersion : 1.0
* 2012.04.09 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.gem.gemcommon.gemcommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GEMCommonDBDAOSearchExpenseCdByRoleRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 로그인한 사용자에 따른 조회 가능한 비용코드 조회
	  * </pre>
	  */
	public GEMCommonDBDAOSearchExpenseCdByRoleRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.cps.gem.gemcommon.gemcommon.integration").append("\n"); 
		query.append("FileName : GEMCommonDBDAOSearchExpenseCdByRoleRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT " ).append("\n"); 
		query.append("       A.GEN_EXPN_CD" ).append("\n"); 
		query.append("  FROM GEM_EXPENSE A" ).append("\n"); 
		query.append("      ,GEM_OFC_MTX B" ).append("\n"); 
		query.append(" WHERE A.GEN_EXPN_CD = B.GEN_EXPN_CD" ).append("\n"); 
		query.append("   AND A.DELT_FLG    = 'N'" ).append("\n"); 
		query.append("   #if (${ofc_cd} != '') " ).append("\n"); 
		query.append("   AND B.OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("   AND B.DELT_FLG    = 'N'" ).append("\n"); 
		query.append(" ORDER BY A.GEN_EXPN_CD" ).append("\n"); 

	}
}