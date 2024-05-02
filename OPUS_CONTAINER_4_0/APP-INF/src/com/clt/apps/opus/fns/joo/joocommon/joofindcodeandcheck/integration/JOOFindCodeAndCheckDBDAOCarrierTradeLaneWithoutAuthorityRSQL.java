/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : JOOFindCodeAndCheckDBDAOCarrierTradeLaneWithoutAuthorityRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.29
*@LastModifier : 박희동
*@LastVersion : 1.0
* 2010.12.29 박희동
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

public class JOOFindCodeAndCheckDBDAOCarrierTradeLaneWithoutAuthorityRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 권한없이 Carrier 조회
	  * </pre>
	  */
	public JOOFindCodeAndCheckDBDAOCarrierTradeLaneWithoutAuthorityRSQL(){
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
		params.put("code",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.joo.joocommon.joofindcodeandcheck.integration").append("\n"); 
		query.append("FileName : JOOFindCodeAndCheckDBDAOCarrierTradeLaneWithoutAuthorityRSQL").append("\n"); 
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
		query.append("       a.trd_cd    as super_cd1," ).append("\n"); 
		query.append("       a.rlane_cd  as super_cd2," ).append("\n"); 
		query.append("       a.jo_crr_cd as code" ).append("\n"); 
		query.append("FROM   joo_carrier  a" ).append("\n"); 
		query.append("WHERE  a.delt_flg = 'N'" ).append("\n"); 
		query.append("#if (${super_cd1} != '')" ).append("\n"); 
		query.append("AND	   a.trd_cd  = @[super_cd1]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${super_cd2} != '')" ).append("\n"); 
		query.append("AND	   a.rlane_cd = @[super_cd2]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${code} != '')" ).append("\n"); 
		query.append("AND	   a.jo_crr_cd = @[code]" ).append("\n"); 
		query.append("#end          " ).append("\n"); 
		query.append("ORDER BY 1,2,3" ).append("\n"); 

	}
}