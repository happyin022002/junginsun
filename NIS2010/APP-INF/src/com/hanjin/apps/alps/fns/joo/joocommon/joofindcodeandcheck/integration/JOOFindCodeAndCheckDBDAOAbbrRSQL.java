/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : JOOFindCodeAndCheckDBDAOAbbrRSQL.java
*@FileTitle : Other
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.02
*@LastModifier : 박희동
*@LastVersion : 1.0
* 2009.06.02 박희동
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

public class JOOFindCodeAndCheckDBDAOAbbrRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ABBR Code List
	  * </pre>
	  */
	public JOOFindCodeAndCheckDBDAOAbbrRSQL(){
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
		query.append("select" ).append("\n"); 
		query.append("jo_stl_itm_cd as code," ).append("\n"); 
		query.append("jo_stl_itm_nm as name" ).append("\n"); 
		query.append("from   joo_stl_itm" ).append("\n"); 
		query.append("where  1=1" ).append("\n"); 
		query.append("#if (${super_cd1} != '')" ).append("\n"); 
		query.append("and    jo_auto_cre_flg = @[super_cd1]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${super_cd2} != '')" ).append("\n"); 
		query.append("and    jo_mnl_cre_flg = @[super_cd2]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("order  by 1" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.nis2010.fns.joo.common.joofindcodeandcheck.integration").append("\n"); 
		query.append("FileName : JOOFindCodeAndCheckDBDAOAbbrRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}