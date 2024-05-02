/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : JOOFindCodeAndCheckDBDAOSearchVslCodeListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.12.20
*@LastModifier : 김영오
*@LastVersion : 1.0
* 2012.12.20 김영오
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.joocommon.joofindcodeandcheck.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM YOUNG-OH
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JOOFindCodeAndCheckDBDAOSearchVslCodeListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchVslCodeList
	  * </pre>
	  */
	public JOOFindCodeAndCheckDBDAOSearchVslCodeListRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.joo.joocommon.joofindcodeandcheck.integration ").append("\n"); 
		query.append("FileName : JOOFindCodeAndCheckDBDAOSearchVslCodeListRSQL").append("\n"); 
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
		query.append("    SELECT VSL_CD AS CODE" ).append("\n"); 
		query.append("    FROM MDM_VSL_CNTR" ).append("\n"); 
		query.append("    WHERE DELT_FLG = 'N'" ).append("\n"); 
		query.append("    AND VSL_CD = @[super_cd1]" ).append("\n"); 

	}
}