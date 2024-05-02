/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCGExternalFinderDBDAOSearchClassCompRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.15
*@LastModifier : 김현욱
*@LastVersion : 1.0
* 2009.06.15 김현욱
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.scg.scgcommon.scgexternalfinder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author HyunUk Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCGExternalFinderDBDAOSearchClassCompRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchClassComp  조회
	  * </pre>
	  */
	public SCGExternalFinderDBDAOSearchClassCompRSQL(){
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
		query.append("SELECT" ).append("\n"); 
		query.append("IMDG_COMP_GRP_CD" ).append("\n"); 
		query.append(",	IMDG_COMP_GRP_DESC" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append("FROM SCG_IMDG_COMP_GRP" ).append("\n"); 
		query.append("WHERE	DELT_FLG <> 'Y'" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.scg.scgcommon.scgexternalfinder.integration").append("\n"); 
		query.append("FileName : SCGExternalFinderDBDAOSearchClassCompRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}