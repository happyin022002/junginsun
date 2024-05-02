/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : JointOperationAccrualCreationDBDAOEstmConditionVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.17
*@LastModifier : 박희동
*@LastVersion : 1.0
* 2009.09.17 박희동
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Hee Dong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JointOperationAccrualCreationDBDAOEstmConditionVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EstmConditionVO
	  * </pre>
	  */
	public JointOperationAccrualCreationDBDAOEstmConditionVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.integration").append("\n"); 
		query.append("FileName : JointOperationAccrualCreationDBDAOEstmConditionVORSQL").append("\n"); 
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
		query.append("'' AS EXE_YRMON" ).append("\n"); 
		query.append(",'' AS REV_YRMON_FR" ).append("\n"); 
		query.append(",'' AS REV_YRMON_TO" ).append("\n"); 
		query.append(",'' AS RE_DIVR_CD" ).append("\n"); 
		query.append(",'' AS TRD_CD" ).append("\n"); 
		query.append(",'' AS RLANE_CD" ).append("\n"); 
		query.append(",'' AS JO_CRR_CD" ).append("\n"); 
		query.append(",'' AS JO_STL_JB_CD" ).append("\n"); 
		query.append(",'' AS DIFF_OPTION" ).append("\n"); 
		query.append(",'' AS VVD" ).append("\n"); 
		query.append(",'' AS ESTM_COND_FLG" ).append("\n"); 
		query.append("FROM  DUAL" ).append("\n"); 

	}
}