/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EvaluationGroupManageDBDAOSearchEGIdAllListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.27
*@LastModifier : 남궁진호
*@LastVersion : 1.0
* 2009.07.27 남궁진호
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.spe.mastermanage.evaluationgroupmanage.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author NAMKOONG Jin Ho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EvaluationGroupManageDBDAOSearchEGIdAllListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchEGIdAllList
	  * </pre>
	  */
	public EvaluationGroupManageDBDAOSearchEGIdAllListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.spe.mastermanage.evaluationgroupmanage.integration ").append("\n"); 
		query.append("FileName : EvaluationGroupManageDBDAOSearchEGIdAllListRSQL").append("\n"); 
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
		query.append("EG_ID||TO_CHAR(EG_ID_SEQ,'000') AS EG_ID" ).append("\n"); 
		query.append("FROM SPE_EV_GRP" ).append("\n"); 

	}
}