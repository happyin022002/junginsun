/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GEMMasterCodeMgtDBDAOSearchExpenseListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.03
*@LastModifier : 최정미
*@LastVersion : 1.0
* 2009.06.03 최정미
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.gem.gemcommon.gemmastercodemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author choijungmi
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GEMMasterCodeMgtDBDAOSearchExpenseListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * select
	  * </pre>
	  */
	public GEMMasterCodeMgtDBDAOSearchExpenseListRSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
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
		query.append("SELECT   GEN_EXPN_CD" ).append("\n"); 
		query.append(",ENG_ABBR_NM" ).append("\n"); 
		query.append(",KRN_ABBR_NM" ).append("\n"); 
		query.append("FROM     GEM_EXPENSE" ).append("\n"); 
		query.append("WHERE    DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND      GEN_EXPN_CD IN (SELECT L_4 CODE" ).append("\n"); 
		query.append("FROM   GEM_EXPN_LEVEL_V)" ).append("\n"); 
		query.append("ORDER BY 1" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.nis2010.cps.gem.gemcommon.gemmastercodemgt.integration").append("\n"); 
		query.append("FileName : GEMMasterCodeMgtDBDAOSearchExpenseListRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}