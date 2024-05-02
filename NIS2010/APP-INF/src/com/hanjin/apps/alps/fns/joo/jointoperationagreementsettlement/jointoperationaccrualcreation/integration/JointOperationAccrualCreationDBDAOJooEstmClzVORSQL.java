/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : JointOperationAccrualCreationDBDAOJooEstmClzVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.23
*@LastModifier : 함대성
*@LastVersion : 1.0
* 2009.07.23 함대성
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author HAM DAE SUNG
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JointOperationAccrualCreationDBDAOJooEstmClzVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public JointOperationAccrualCreationDBDAOJooEstmClzVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("estm_clz_yr",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.integration").append("\n"); 
		query.append("FileName : JointOperationAccrualCreationDBDAOJooEstmClzVORSQL").append("\n"); 
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
		query.append("ESTM_CLZ_YR" ).append("\n"); 
		query.append(",	ESTM_CLZ_MON" ).append("\n"); 
		query.append(",	ESTM_CLZ_FLG" ).append("\n"); 
		query.append(",	DECODE(ESTM_CLZ_FLG , 'Y', ESTM_CLZ_DT , NULL) ESTM_CLZ_DT" ).append("\n"); 
		query.append(",	DECODE(ESTM_CLZ_FLG, 'Y', ESTM_RMK, NULL)    ESTM_RMK" ).append("\n"); 
		query.append(",	DECODE(ESTM_CLZ_FLG, 'Y', CRE_DT, NULL)      CRE_DT" ).append("\n"); 
		query.append(",	DECODE(ESTM_CLZ_FLG, 'Y', CRE_USR_ID, NULL)  CRE_USR_ID" ).append("\n"); 
		query.append(",	DECODE(ESTM_CLZ_FLG, 'Y', UPD_DT, NULL)      UPD_DT" ).append("\n"); 
		query.append(",	DECODE(ESTM_CLZ_FLG, 'Y', UPD_USR_ID, NULL)  UPD_USR_ID" ).append("\n"); 
		query.append("FROM JOO_ESTM_CLZ" ).append("\n"); 
		query.append("WHERE	ESTM_CLZ_YR = @[estm_clz_yr]" ).append("\n"); 
		query.append("ORDER BY ESTM_CLZ_MON" ).append("\n"); 

	}
}