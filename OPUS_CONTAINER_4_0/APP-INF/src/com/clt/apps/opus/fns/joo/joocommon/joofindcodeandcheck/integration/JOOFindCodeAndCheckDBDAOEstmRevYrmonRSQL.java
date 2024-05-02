/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : JOOFindCodeAndCheckDBDAOEstmRevYrmonRSQL.java
*@FileTitle : Estimate Performance Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.16
*@LastModifier : 박희동
*@LastVersion : 1.0
* 2009.09.16 박희동
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.joo.joocommon.joofindcodeandcheck.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Hee Dong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JOOFindCodeAndCheckDBDAOEstmRevYrmonRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 추정결과테이블에서 MIN~MAX Rev_YRMON 조회
	  * </pre>
	  */
	public JOOFindCodeAndCheckDBDAOEstmRevYrmonRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("exe_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.joo.joocommon.joofindcodeandcheck.integration ").append("\n"); 
		query.append("FileName : JOOFindCodeAndCheckDBDAOEstmRevYrmonRSQL").append("\n"); 
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
		query.append("MIN(A.REV_YRMON) AS REV_YRMON_FR" ).append("\n"); 
		query.append(",MAX(A.REV_YRMON) AS REV_YRMON_TO" ).append("\n"); 
		query.append("FROM   JOO_ESTM_ACT_RSLT A" ).append("\n"); 
		query.append("WHERE  A.EXE_YRMON  = REPLACE(@[exe_yrmon],'-','')" ).append("\n"); 
		query.append("#if(${re_divr_cd} != '')" ).append("\n"); 
		query.append("AND    A.ACCT_CD   LIKE DECODE(@[re_divr_cd],'R','4','5')||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}