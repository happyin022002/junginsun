/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TargetGroupDBDAOSearchTargetGroup0014ListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.09
*@LastModifier : 김종호
*@LastVersion : 1.0
* 2010.03.09 김종호
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.saq.basicdatamanage.targetgroup.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jong-Ho Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TargetGroupDBDAOSearchTargetGroup0014ListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Target Group List
	  * </pre>
	  */
	public TargetGroupDBDAOSearchTargetGroup0014ListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.saq.basicdatamanage.targetgroup.integration").append("\n"); 
		query.append("FileName : TargetGroupDBDAOSearchTargetGroup0014ListRSQL").append("\n"); 
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
		query.append("SELECT A.SAQ_TGT_GRP_CD, " ).append("\n"); 
		query.append("		A.OFC_CD, " ).append("\n"); 
		query.append("		A.SAQ_TGT_GRP_DESC, " ).append("\n"); 
		query.append("		A.DELT_FLG          " ).append("\n"); 
		query.append("FROM SAQ_TGT_GRP A" ).append("\n"); 
		query.append("ORDER BY A.SAQ_TGT_GRP_CD, " ).append("\n"); 
		query.append("		A.SAQ_TGT_GRP_DESC" ).append("\n"); 

	}
}