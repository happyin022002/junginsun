/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : JointOperationAccrualCreationDAOSettlementConditionRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.09.29
*@LastModifier : 원종규
*@LastVersion : 1.0
* 2010.09.29 원종규
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jongkyu Weon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JointOperationAccrualCreationDAOSettlementConditionRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public JointOperationAccrualCreationDAOSettlementConditionRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.integration").append("\n"); 
		query.append("FileName : JointOperationAccrualCreationDAOSettlementConditionRSQL").append("\n"); 
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
		query.append("'' RE_DIVR_CD           ," ).append("\n"); 
		query.append("'' EXE_YRMON            ," ).append("\n"); 
		query.append("'' JO_CRR_CD            ," ).append("\n"); 
		query.append("'' TRD_CD               ," ).append("\n"); 
		query.append("'' RLANE_CD             ," ).append("\n"); 
		query.append("'' REV_YRMON_FR         ," ).append("\n"); 
		query.append("'' REV_YRMON_TO         ," ).append("\n"); 
		query.append("'' AS OFC_CD            ," ).append("\n"); 
		query.append("'' AS CRE_FLG           ," ).append("\n"); 
		query.append("'' AS PAGE_NO           ," ).append("\n"); 
		query.append("'' AS PAGEROWS          ," ).append("\n"); 
		query.append("'' AS USR_ID			," ).append("\n"); 
		query.append("'' AS VVD" ).append("\n"); 
		query.append("FROM   DUAL" ).append("\n"); 

	}
}