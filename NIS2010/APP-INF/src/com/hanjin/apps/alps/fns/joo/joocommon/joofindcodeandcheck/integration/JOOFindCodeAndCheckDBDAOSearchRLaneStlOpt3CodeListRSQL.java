/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : JOOFindCodeAndCheckDBDAOSearchRLaneStlOpt3CodeListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.21
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2010.01.21 장강철
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.joocommon.joofindcodeandcheck.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author jang kang cheol
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JOOFindCodeAndCheckDBDAOSearchRLaneStlOpt3CodeListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public JOOFindCodeAndCheckDBDAOSearchRLaneStlOpt3CodeListRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_crr_auth_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.joo.joocommon.joofindcodeandcheck.integration").append("\n"); 
		query.append("FileName : JOOFindCodeAndCheckDBDAOSearchRLaneStlOpt3CodeListRSQL").append("\n"); 
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
		query.append("SUBSTR(A.RLANE_CD,1,3) AS CODE" ).append("\n"); 
		query.append("FROM   JOO_CARRIER  A," ).append("\n"); 
		query.append("JOO_CRR_AUTH B" ).append("\n"); 
		query.append("WHERE  A.JO_CRR_CD   = B.JO_CRR_CD" ).append("\n"); 
		query.append("AND    A.RLANE_CD    = B.RLANE_CD" ).append("\n"); 
		query.append("AND    B.AUTH_OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("AND    A.DELT_FLG    = 'N'" ).append("\n"); 
		query.append("AND    B.DELT_FLG    = 'N'" ).append("\n"); 
		query.append("AND	   A.JO_CRR_CD   = @[super_cd1]" ).append("\n"); 
		query.append("AND	   A.TRD_CD      = @[super_cd2]" ).append("\n"); 
		query.append("#if (${jo_crr_auth_cd} != '')" ).append("\n"); 
		query.append("AND    B.JO_CRR_AUTH_CD = @[jo_crr_auth_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER  BY 1" ).append("\n"); 

	}
}