/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : PopupDBDAOSearchDeptListOrderRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.05
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.03.05 백형인
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.spe.common.popup.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author HI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PopupDBDAOSearchDeptListOrderRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 조직트리의 키를 정렬순서에 맞게 조회한다.
	  * </pre>
	  */
	public PopupDBDAOSearchDeptListOrderRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.spe.common.popup.integration ").append("\n"); 
		query.append("FileName : PopupDBDAOSearchDeptListOrderRSQL").append("\n"); 
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
		query.append("SELECT INTG_CD_VAL_CTNT,INTG_CD_VAL_DP_SEQ" ).append("\n"); 
		query.append("  FROM COM_INTG_CD_DTL " ).append("\n"); 
		query.append(" WHERE INTG_CD_ID ='CD03373' " ).append("\n"); 
		query.append(" ORDER BY INTG_CD_VAL_DP_SEQ" ).append("\n"); 

	}
}