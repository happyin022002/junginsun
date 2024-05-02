/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ContainerSelectPopupDBDAOSearchContainerSelectReplaceTPSZListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.26
*@LastModifier : 손은주(TRS)
*@LastVersion : 1.0
* 2009.07.26 손은주(TRS)
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.common.containerselectpopup.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Eun ju Son(TRS)
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerSelectPopupDBDAOSearchContainerSelectReplaceTPSZListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 교체 가능한 CNTR TYPE/SIZE LIST 조회
	  * </pre>
	  */
	public ContainerSelectPopupDBDAOSearchContainerSelectReplaceTPSZListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.common.containerselectpopup.integration").append("\n"); 
		query.append("FileName : ContainerSelectPopupDBDAOSearchContainerSelectReplaceTPSZListRSQL").append("\n"); 
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
		query.append("CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",   PROV_CNTR_TPSZ_CD" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("SCE_COP_CNTR_REPO_RULE" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("ACT_FLG                      = 'Y'" ).append("\n"); 
		query.append("ORDER BY" ).append("\n"); 
		query.append("CNTR_TPSZ_CD" ).append("\n"); 

	}
}