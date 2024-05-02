/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : PSOCodeFinderDBDAOsearchAccountListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.25
*@LastModifier : 
*@LastVersion : 1.0
* 2016.02.25 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.pso.psocommon.psocodefinder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PSOCodeFinderDBDAOsearchAccountListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * account 조회
	  * [2015.10.13]962111 OWNERS ACCOUNT INTER-OFFICE ACCT 주석처리.
	  * </pre>
	  */
	public PSOCodeFinderDBDAOsearchAccountListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.pso.psocommon.psocodefinder.integration").append("\n"); 
		query.append("FileName : PSOCodeFinderDBDAOsearchAccountListRSQL").append("\n"); 
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
		query.append("" ).append("\n"); 
		query.append("#if (${ofc_cd} != '') " ).append("\n"); 
		query.append("SELECT DISTINCT T1.ACCT_CD" ).append("\n"); 
		query.append("     , T2.ACCT_ENG_NM" ).append("\n"); 
		query.append("     --, T1.LGS_COST_SUBJ_CD" ).append("\n"); 
		query.append("  FROM TES_LGS_COST T1" ).append("\n"); 
		query.append("     , MDM_ACCOUNT T2" ).append("\n"); 
		query.append("     , PSO_INV_OFC_COST T3" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND T1.LGS_COST_SUBJ_CD IN ('PT', 'CN')" ).append("\n"); 
		query.append("   AND T1.LGS_COST_CD_CLSS_LVL = 'A'" ).append("\n"); 
		query.append("   AND T1.ACCT_CD = T2.ACCT_CD" ).append("\n"); 
		query.append("   AND T2.DELT_FLG = 'N'" ).append("\n"); 
		query.append("   AND T1.LGS_COST_CD = T3.LGS_COST_CD" ).append("\n"); 
		query.append("   AND T1.ACCT_CD NOT IN ( '110911')" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("SELECT DISTINCT T1.ACCT_CD" ).append("\n"); 
		query.append("     , T2.ACCT_ENG_NM" ).append("\n"); 
		query.append("     --, T1.LGS_COST_SUBJ_CD" ).append("\n"); 
		query.append("  FROM TES_LGS_COST T1" ).append("\n"); 
		query.append("     , MDM_ACCOUNT T2" ).append("\n"); 
		query.append(" WHERE T1.LGS_COST_SUBJ_CD IN ('PT', 'CN')" ).append("\n"); 
		query.append("   AND T1.LGS_COST_CD_CLSS_LVL = 'A'" ).append("\n"); 
		query.append("   AND T2.DELT_FLG = 'N'" ).append("\n"); 
		query.append("   AND T1.ACCT_CD = T2.ACCT_CD" ).append("\n"); 
		query.append("   AND T1.ACCT_CD NOT IN ( '110911')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" ORDER BY T1.ACCT_CD" ).append("\n"); 

	}
}