/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : CommonDBDAOCheckMaxBatSeqRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.06.05
*@LastModifier : 
*@LastVersion : 1.0
* 2013.06.05 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.coa.common.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CommonDBDAOCheckMaxBatSeqRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CheckMaxBatSeq
	  * </pre>
	  */
	public CommonDBDAOCheckMaxBatSeqRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.coa.common.integration").append("\n"); 
		query.append("FileName : CommonDBDAOCheckMaxBatSeqRSQL").append("\n"); 
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
		query.append("SELECT NVL(MAX(COA_BAT_SEQ),0)+1 AS MAX_SEQ" ).append("\n"); 
		query.append("FROM COA_BKG_RTRO_HIS" ).append("\n"); 

	}
}