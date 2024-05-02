/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CodepublishDAOEdmCodeDetailRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.27
*@LastModifier : 
*@LastVersion : 1.0
* 2009.05.27 
* 1.0 Creation
=========================================================*/
package com.hanjin.edm.codepublish.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CodepublishDAOEdmCodeDetailRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * select edm code value
	  * </pre>
	  */
	public CodepublishDAOEdmCodeDetailRSQL(){
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
		query.append("SELECT   a.codeid," ).append("\n"); 
		query.append("b.codeid AS KEY," ).append("\n"); 
		query.append("REPLACE(b.NAME,'&','&'||'amp;') AS VALUE," ).append("\n"); 
		query.append("b.codeorder" ).append("\n"); 
		query.append("FROM t_codedomain a, t_codevalue b" ).append("\n"); 
		query.append("WHERE a.codeid = @[codeid] AND a.ID = b.ID" ).append("\n"); 
		query.append("ORDER BY a.codeid, b.codeorder" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.edm.codepublish.integration ").append("\n"); 
		query.append("FileName : CodepublishDAOEdmCodeDetailRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}