/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CodepublishDAOComIntgCdRSQL.java
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

public class CodepublishDAOComIntgCdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * select com_ingt_cd
	  * </pre>
	  */
	public CodepublishDAOComIntgCdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.edm.codepublish.integration").append("\n"); 
		query.append("FileName : CodepublishDAOComIntgCdRSQL").append("\n"); 
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
		query.append("A.OWNR_SUB_SYS_CD," ).append("\n"); 
		query.append("A.INTG_CD_ID," ).append("\n"); 
		query.append("REPLACE(A.INTG_CD_NM,'&','&'||'amp;') INTG_CD_NM," ).append("\n"); 
		query.append("A.INTG_CD_LEN," ).append("\n"); 
		query.append("NVL(A.INTG_CD_USE_FLG,'Y') INTG_CD_USE_FLG" ).append("\n"); 
		query.append("FROM COM_INTG_CD A" ).append("\n"); 
		query.append("WHERE A.INTG_CD_ID IN (" ).append("\n"); 
		query.append("#foreach($key IN ${codes})" ).append("\n"); 
		query.append("#if($velocityCount < $codes.size())" ).append("\n"); 
		query.append("'$key'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$key'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("ORDER BY A.INTG_CD_ID" ).append("\n"); 

	}
}