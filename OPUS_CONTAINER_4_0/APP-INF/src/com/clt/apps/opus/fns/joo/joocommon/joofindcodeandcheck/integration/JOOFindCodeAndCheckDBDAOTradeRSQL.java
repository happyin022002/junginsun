/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : JOOFindCodeAndCheckDBDAOTradeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.02
*@LastModifier : 
*@LastVersion : 1.0
* 2016.08.02 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.joo.joocommon.joofindcodeandcheck.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JOOFindCodeAndCheckDBDAOTradeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Trade 조회
	  * </pre>
	  */
	public JOOFindCodeAndCheckDBDAOTradeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("super_cd1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("code",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("auth_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.joo.joocommon.joofindcodeandcheck.integration").append("\n"); 
		query.append("FileName : JOOFindCodeAndCheckDBDAOTradeRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT A.TRD_CD AS CODE" ).append("\n"); 
		query.append("     , A.TRD_CD AS NAME" ).append("\n"); 
		query.append("  FROM JOO_CARRIER A" ).append("\n"); 
		query.append("     , JOO_CRR_AUTH AUTH" ).append("\n"); 
		query.append(" WHERE A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("   AND A.JO_CRR_CD = AUTH.JO_CRR_CD" ).append("\n"); 
		query.append("   AND A.RLANE_CD  = AUTH.RLANE_CD" ).append("\n"); 
		query.append("#if (${auth_delcheck_yn} == 'N') -- N : WHERE 절에 걸지 않음.(AUTH.DELT_FLG)" ).append("\n"); 
		query.append("   --AND NVL(AUTH.DELT_FLG,'N') = 'N'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("   AND NVL(AUTH.DELT_FLG,'N') = 'N'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ofc_cd} != '')   " ).append("\n"); 
		query.append("   AND AUTH.AUTH_OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${auth_ofc_cd} != '')" ).append("\n"); 
		query.append("   /*2016.08.01 추가 개발된 코드.*/" ).append("\n"); 
		query.append("   AND AUTH.AUTH_OFC_CD = @[auth_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${super_cd1} != '')" ).append("\n"); 
		query.append("   AND A.JO_CRR_CD = @[super_cd1]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${super_cds1}!=''  && ${super_cds1} != 'ALL')" ).append("\n"); 
		query.append("   /* Condition super_cds */" ).append("\n"); 
		query.append("   AND A.JO_CRR_CD    IN ( #foreach($key IN ${super_cds1})#if($velocityCount < $super_cds1.size()) '$key', #else '$key' #end #end)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${code} != '')" ).append("\n"); 
		query.append("   AND A.TRD_CD = @[code]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY 1" ).append("\n"); 

	}
}