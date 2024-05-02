/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CommonDBDAOSearchRhqComboListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.28
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.28 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.common.common.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CommonDBDAOSearchRhqComboListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ESM_SPC_0021의 RHQ COMBO DATA 조회
	  * </pre>
	  */
	public CommonDBDAOSearchRhqComboListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.common.common.integration").append("\n"); 
		query.append("FileName : CommonDBDAOSearchRhqComboListRSQL").append("\n"); 
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
		query.append("SELECT T.OFC_CD    ," ).append("\n"); 
		query.append("         T.OFC_ENG_NM" ).append("\n"); 
		query.append("    FROM SPC_OFC_LVL T," ).append("\n"); 
		query.append("         MAS_WK_PRD  W" ).append("\n"); 
		query.append("   WHERE T.OFC_LVL = 2" ).append("\n"); 
		query.append("     AND W.COST_YR || W.COST_WK BETWEEN T.OFC_APLY_FM_YRWK AND T.OFC_APLY_TO_YRWK" ).append("\n"); 
		query.append("     AND TO_CHAR(SYSDATE, 'YYYYMMDD') BETWEEN W.SLS_FM_DT AND W.SLS_TO_DT" ).append("\n"); 
		query.append("     AND T.DELT_FLG ='N'" ).append("\n"); 
		query.append("#if (${mrhq} =='Y')" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 'SHARC,SINRS', " ).append("\n"); 
		query.append("       'SHARC,SINRS'" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 
		query.append("#elseif (${mrhq1} =='Y')" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 'SHARC,SINRS,SELSC,TYOSC', " ).append("\n"); 
		query.append("       'SHARC,SINRS,SELSC,TYOSC'" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 'SELSC', " ).append("\n"); 
		query.append("       'SELSC'" ).append("\n"); 
		query.append("FROM DUAL  " ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 'TYOSC', " ).append("\n"); 
		query.append("       'TYOSC'" ).append("\n"); 
		query.append("FROM DUAL     " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY 1" ).append("\n"); 

	}
}