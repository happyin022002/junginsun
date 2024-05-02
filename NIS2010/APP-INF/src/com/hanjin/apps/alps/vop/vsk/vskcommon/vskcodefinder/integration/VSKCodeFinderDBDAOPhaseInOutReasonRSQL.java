/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VSKCodeFinderDBDAOPhaseInOutReasonRSQL.java
*@FileTitle : test2
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.02
*@LastModifier : 유혁
*@LastVersion : 1.0
* 2009.06.02 유혁
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Ryu Hyuk
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VSKCodeFinderDBDAOPhaseInOutReasonRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Phase In/Out Reason 을 조회한다.
	  * </pre>
	  */
	public VSKCodeFinderDBDAOPhaseInOutReasonRSQL(){
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
		query.append("INTG_CD_VAL_CTNT AS RSN_CODE," ).append("\n"); 
		query.append("INTG_CD_VAL_DESC AS RSN_NAME" ).append("\n"); 
		query.append("FROM  COM_INTG_CD_DTL B" ).append("\n"); 
		query.append("WHERE INTG_CD_ID = 'CD01819'" ).append("\n"); 
		query.append("ORDER BY INTG_CD_VAL_DP_SEQ" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.nis2010.vop.vsk.vskcommon.vskcodefinder.integration ").append("\n"); 
		query.append("FileName : VSKCodeFinderDBDAOPhaseInOutReasonRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}