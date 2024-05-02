/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GEMMasterCodeMgtDBDAOSearchGroupListByExpenseRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.03
*@LastModifier : 최정미
*@LastVersion : 1.0
* 2009.06.03 최정미
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.gem.gemcommon.gemmastercodemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author choijungmi
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GEMMasterCodeMgtDBDAOSearchGroupListByExpenseRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * select
	  * </pre>
	  */
	public GEMMasterCodeMgtDBDAOSearchGroupListByExpenseRSQL(){
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
		query.append("SELECT DISTINCT GEN_EXPN_CD" ).append("\n"); 
		query.append(",ENG_ABBR_NM" ).append("\n"); 
		query.append(",KRN_ABBR_NM" ).append("\n"); 
		query.append("FROM            GEM_EXPENSE" ).append("\n"); 
		query.append("WHERE           GEN_EXPN_GRP_LVL = '1'" ).append("\n"); 
		query.append("ORDER BY        1" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.nis2010.cps.gem.gemcommon.gemmastercodemgt.integration").append("\n"); 
		query.append("FileName : GEMMasterCodeMgtDBDAOSearchGroupListByExpenseRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}