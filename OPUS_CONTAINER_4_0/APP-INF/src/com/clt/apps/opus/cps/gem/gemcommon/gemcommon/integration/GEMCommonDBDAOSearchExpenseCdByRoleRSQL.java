/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GEMCommonDBDAOSearchExpenseCdByRoleRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.12
*@LastModifier : 진윤오
*@LastVersion : 1.0
* 2009.06.12 진윤오
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.gem.gemcommon.gemcommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author J.Y.O
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
		params.put("gem_expn_grp_cd1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gen_expn_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("SELECT B.GEN_EXPN_CD" ).append("\n"); 
		query.append("FROM   GEM_EXPN_GRP_V A, GEM_OFC_MTX B" ).append("\n"); 
		query.append("WHERE  A.GEN_EXPN_CD = B.GEN_EXPN_CD" ).append("\n"); 
		query.append("#if (${gem_expn_grp_cd1} != '')" ).append("\n"); 
		query.append("AND    A.GEM_EXPN_GRP_CD1 = @[gem_expn_grp_cd1]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${gen_expn_cd} != '')" ).append("\n"); 
		query.append("AND    A.GEN_EXPN_CD = @[gen_expn_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ofc_cd} != '')" ).append("\n"); 
		query.append("AND    B.OFC_CD IN (${ofc_cd})" ).append("\n"); 
		query.append("#end" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.nis2010.cps.gem.gemcommon.gemcommon.integration").append("\n"); 
		query.append("FileName : GEMCommonDBDAOSearchExpenseCdByRoleRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}