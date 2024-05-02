/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CodeManageDBDAOSearchCodescListSubjRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.09.09
*@LastModifier : yOnghO
*@LastVersion : 1.0
* 2015.09.09 yOnghO
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.codemanage.codemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author yOnghO
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
		query.append("Path : com.hanjin.apps.alps.esd.tes.codemanage.codemanage.integration").append("\n"); 
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
		query.append("SELECT	LGS_COST_CD AS LGS_COST_SUBJ_CD" ).append("\n"); 
		query.append("FROM	TES_LGS_COST" ).append("\n"); 
		query.append("WHERE	1	= 1" ).append("\n"); 
		query.append("AND		LGS_COST_CD IN (" ).append("\n"); 
		query.append("						SELECT	LC.LGS_COST_SUBJ_CD" ).append("\n"); 
		query.append("						FROM	TES_LGS_COST LC" ).append("\n"); 
		query.append("								, TES_TML_SO_COST SC" ).append("\n"); 
		query.append("						WHERE	1	= 1" ).append("\n"); 
		query.append("						AND		LC.LGS_COST_CD	= SC.LGS_COST_CD" ).append("\n"); 
		query.append("						AND		LC.LGS_COST_SUBJ_CD IS NOT NULL " ).append("\n"); 
		query.append("						AND		LC.DELT_FLG		= 'N'" ).append("\n"); 
		query.append("						)" ).append("\n"); 
		query.append("AND		LGS_COST_CD_CLSS_LVL	= 'S'" ).append("\n"); 
		query.append("ORDER BY LGS_COST_CD					" ).append("\n"); 

	}
}