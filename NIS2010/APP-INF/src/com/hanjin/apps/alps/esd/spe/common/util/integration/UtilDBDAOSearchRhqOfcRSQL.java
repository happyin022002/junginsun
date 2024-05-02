/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : UtilDBDAOSearchRhqOfcRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.13
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.02.13 백형인
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.spe.common.util.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author HI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UtilDBDAOSearchRhqOfcRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RHQ Office 를 조회합니다
	  * </pre>
	  */
	public UtilDBDAOSearchRhqOfcRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.spe.common.util.integration").append("\n"); 
		query.append("FileName : UtilDBDAOSearchRhqOfcRSQL").append("\n"); 
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
		query.append("SELECT INTG_CD_VAL_CTNT AS EG_OFC_CD" ).append("\n"); 
		query.append("     , INTG_CD_VAL_DP_SEQ" ).append("\n"); 
		query.append("  FROM (SELECT INTG_CD_VAL_CTNT " ).append("\n"); 
		query.append("             , TO_CHAR(INTG_CD_VAL_DP_SEQ) AS INTG_CD_VAL_DP_SEQ" ).append("\n"); 
		query.append("          FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("         WHERE INTG_CD_ID ='CD03373'" ).append("\n"); 
		query.append("         UNION ALL" ).append("\n"); 
		query.append("         SELECT OFC_CD AS EG_OFC_CD ,  OFC_ENG_NM" ).append("\n"); 
		query.append("           FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("          WHERE OFC_TP_CD =  'HQ'" ).append("\n"); 
		query.append("            AND DELT_FLG = 'N' " ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("ORDER BY INTG_CD_VAL_DP_SEQ" ).append("\n"); 

	}
}