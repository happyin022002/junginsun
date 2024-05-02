/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : JOOFindCodeAndCheckDBDAORlaneWithOptRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.14
*@LastModifier : 박희동
*@LastVersion : 1.0
* 2010.01.14 박희동
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.joo.joocommon.joofindcodeandcheck.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Hee Dong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JOOFindCodeAndCheckDBDAORlaneWithOptRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Basic Port에서 사용하기 위해 RLANE과 JO_STL_OPT_CD를 같이 조회한다.
	  * </pre>
	  */
	public JOOFindCodeAndCheckDBDAORlaneWithOptRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("super_cd2",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.joo.joocommon.joofindcodeandcheck.integration").append("\n"); 
		query.append("FileName : JOOFindCodeAndCheckDBDAORlaneWithOptRSQL").append("\n"); 
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
		query.append("	   A.RLANE_CD AS CODE," ).append("\n"); 
		query.append("	   A.JO_STL_OPT_CD AS NAME," ).append("\n"); 
		query.append("       CASE WHEN A.VNDR_SEQ IS NOT NULL AND A.CUST_SEQ IS NOT NULL THEN 'A'" ).append("\n"); 
		query.append("            ELSE CASE WHEN A.VNDR_SEQ IS NOT NULL THEN 'E'" ).append("\n"); 
		query.append("                 ELSE CASE WHEN A.CUST_SEQ IS NOT NULL THEN 'R'" ).append("\n"); 
		query.append("                      ELSE 'N'" ).append("\n"); 
		query.append("                 END" ).append("\n"); 
		query.append("            END" ).append("\n"); 
		query.append("       END SUPER_CD1," ).append("\n"); 
		query.append("       NVL(B.JO_CRR_AUTH_CD,'R') AS AUTH_CD" ).append("\n"); 
		query.append("FROM   JOO_CARRIER  A," ).append("\n"); 
		query.append("       JOO_CRR_AUTH B" ).append("\n"); 
		query.append("WHERE  A.JO_CRR_CD   = B.JO_CRR_CD" ).append("\n"); 
		query.append("AND    A.RLANE_CD    = B.RLANE_CD " ).append("\n"); 
		query.append("AND    B.AUTH_OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("AND    A.DELT_FLG    = 'N'" ).append("\n"); 
		query.append("AND    B.DELT_FLG    = 'N'" ).append("\n"); 
		query.append("AND	   A.JO_CRR_CD   = @[super_cd1]" ).append("\n"); 
		query.append("AND	   A.TRD_CD      = @[super_cd2]" ).append("\n"); 
		query.append("ORDER  BY 1" ).append("\n"); 

	}
}