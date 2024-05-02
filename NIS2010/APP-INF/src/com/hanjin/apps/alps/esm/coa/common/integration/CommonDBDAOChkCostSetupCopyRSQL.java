/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CommonDBDAOChkCostSetupCopyRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.07.21
*@LastModifier : 최덕우
*@LastVersion : 1.0
* 2014.07.21 최덕우
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.coa.common.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Duk Woo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CommonDBDAOChkCostSetupCopyRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * COA_MNL_COST_STUP에 데이터 존재여부 확인
	  * </pre>
	  */
	public CommonDBDAOChkCostSetupCopyRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_tar_week",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.coa.common.integration").append("\n"); 
		query.append("FileName : CommonDBDAOChkCostSetupCopyRSQL").append("\n"); 
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
		query.append("SELECT COUNT(COST_YRMON) AS CNT FROM COA_MNL_COST_STUP " ).append("\n"); 
		query.append("WHERE COST_YRMON = (SELECT COST_YR||EQ_WK FROM COA_WK_PRD WHERE COST_YR = SUBSTR(REPLACE(@[f_tar_week],'-',''),1,4) AND COST_WK = SUBSTR(REPLACE(@[f_tar_week],'-',''),5,2))" ).append("\n"); 
		query.append("    AND COST_WK = SUBSTR(REPLACE(@[f_tar_week],'-',''),5,2)" ).append("\n"); 
		query.append("	AND RLANE_CD = @[rlane_cd]" ).append("\n"); 

	}
}