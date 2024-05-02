/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : JOOFindCodeAndCheckDBDAOJooLaneByTrdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.25
*@LastModifier : 박희동
*@LastVersion : 1.0
* 2010.01.25 박희동
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

public class JOOFindCodeAndCheckDBDAOJooLaneByTrdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Joo Lane By Trade
	  * </pre>
	  */
	public JOOFindCodeAndCheckDBDAOJooLaneByTrdRSQL(){
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
		query.append("Path : com.clt.apps.opus.fns.joo.joocommon.joofindcodeandcheck.integration").append("\n"); 
		query.append("FileName : JOOFindCodeAndCheckDBDAOJooLaneByTrdRSQL").append("\n"); 
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
		query.append("      distinct" ).append("\n"); 
		query.append("	  a.rlane_cd as code," ).append("\n"); 
		query.append("	  a.rlane_cd as name," ).append("\n"); 
		query.append("      a.trd_cd   as super_cd1" ).append("\n"); 
		query.append("FROM  joo_carrier  a," ).append("\n"); 
		query.append("      joo_crr_auth b" ).append("\n"); 
		query.append("WHERE a.delt_flg = 'N'" ).append("\n"); 
		query.append("and   b.delt_flg = 'N'" ).append("\n"); 
		query.append("and   a.jo_crr_cd = b.jo_crr_cd" ).append("\n"); 
		query.append("and   a.rlane_cd  = b.rlane_cd" ).append("\n"); 
		query.append("and   b.auth_ofc_cd = @[ofc_cd]" ).append("\n"); 
		query.append("order by 1" ).append("\n"); 

	}
}