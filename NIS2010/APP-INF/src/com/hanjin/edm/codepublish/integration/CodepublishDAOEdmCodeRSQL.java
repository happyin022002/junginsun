/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CodepublishDAOEdmCodeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.17
*@LastModifier : 김경범
*@LastVersion : 1.0
* 2010.03.17 김경범
* 1.0 Creation
=========================================================*/
package com.hanjin.edm.codepublish.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author kyungbum kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CodepublishDAOEdmCodeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * select edm code domain
	  * </pre>
	  */
	public CodepublishDAOEdmCodeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("codeid",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("subsystem",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.edm.codepublish.integration").append("\n"); 
		query.append("FileName : CodepublishDAOEdmCodeRSQL").append("\n"); 
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
		query.append("SELECT a.var1," ).append("\n"); 
		query.append("a.codeid AS groupid," ).append("\n"); 
		query.append("REPLACE(a.NAME,'&','&'||'amp;') name," ).append("\n"); 
		query.append("a.PRECISION len," ).append("\n"); 
		query.append("a.var5" ).append("\n"); 
		query.append("FROM t_codedomain a" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if (${subsystem} != '')" ).append("\n"); 
		query.append("AND var1 = @[subsystem]" ).append("\n"); 
		query.append("#end    " ).append("\n"); 
		query.append("#if (${codeid} != '')" ).append("\n"); 
		query.append("#if (${searchtype} == '0')" ).append("\n"); 
		query.append("AND CODEID = @[codeid]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND A.NAME LIKE '%'||@[codeid]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end    " ).append("\n"); 
		query.append("ORDER BY a.codeid" ).append("\n"); 

	}
}