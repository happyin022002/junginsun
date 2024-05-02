/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CodeManageDBDAOSearchCodescListSubjRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.18
*@LastModifier : 이정혜
*@LastVersion : 1.0
* 2009.11.18 이정혜
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tes.codemanage.codemanage.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author HARRY
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CodeManageDBDAOSearchCodescListSubjRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchCodescListSubj
	  * </pre>
	  */
	public CodeManageDBDAOSearchCodescListSubjRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.tes.codemanage.codemanage.integration ").append("\n"); 
		query.append("FileName : CodeManageDBDAOSearchCodescListSubjRSQL").append("\n"); 
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
		query.append("SELECT LGS_COST_SUBJ_CD" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT  LGS_COST_SUBJ_CD" ).append("\n"); 
		query.append(", MIN(LGS_COST_OPT_NO)" ).append("\n"); 
		query.append("FROM TES_LGS_COST" ).append("\n"); 
		query.append("WHERE LGS_COST_SUBJ_CD IS NOT NULL" ).append("\n"); 
		query.append("GROUP BY LGS_COST_SUBJ_CD" ).append("\n"); 
		query.append("ORDER BY MIN(LGS_COST_OPT_NO)" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}