/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : JOOFindCodeAndCheckDBDAOEstmRlaneRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.18
*@LastModifier : 박희동
*@LastVersion : 1.0
* 2010.03.18 박희동
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.joocommon.joofindcodeandcheck.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Hee Dong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JOOFindCodeAndCheckDBDAOEstmRlaneRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * JOO_ESTM_ACT_RSLT 테이블에서 Rlane 코드조회
	  * </pre>
	  */
	public JOOFindCodeAndCheckDBDAOEstmRlaneRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_yrmon_to",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("re_divr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_yrmon_fr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("exe_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.joo.joocommon.joofindcodeandcheck.integration").append("\n"); 
		query.append("FileName : JOOFindCodeAndCheckDBDAOEstmRlaneRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("       A.RLANE_CD" ).append("\n"); 
		query.append("FROM   JOO_ESTM_ACT_RSLT A," ).append("\n"); 
		query.append("       JOO_CARRIER       B" ).append("\n"); 
		query.append("WHERE  A.JO_CRR_CD  = B.JO_CRR_CD" ).append("\n"); 
		query.append("AND    A.RLANE_CD   = B.RLANE_CD" ).append("\n"); 
		query.append("AND    A.EXE_YRMON  = REPLACE(@[exe_yrmon],'-','')" ).append("\n"); 
		query.append("#if (${rev_yrmon_fr} != '')" ).append("\n"); 
		query.append("AND    A.REV_YRMON >= REPLACE(@[rev_yrmon_fr],'-','')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rev_yrmon_to} != '')" ).append("\n"); 
		query.append("AND    A.REV_YRMON <= REPLACE(@[rev_yrmon_to],'-','')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${re_divr_cd} != '')" ).append("\n"); 
		query.append("AND    A.ACCT_CD   LIKE DECODE(@[re_divr_cd],'R','4','5')||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${trd_cd} != '')" ).append("\n"); 
		query.append("AND    B.TRD_CD   = @[trd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("GROUP  BY A.RLANE_CD" ).append("\n"); 
		query.append("ORDER  BY A.RLANE_CD" ).append("\n"); 

	}
}