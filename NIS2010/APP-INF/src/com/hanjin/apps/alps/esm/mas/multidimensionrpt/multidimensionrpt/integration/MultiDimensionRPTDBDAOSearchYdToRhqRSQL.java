/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : MultiDimensionRPTDBDAOSearchYdToRhqRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.02
*@LastModifier : 최덕우
*@LastVersion : 1.0
* 2016.05.02 최덕우
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.multidimensionrpt.multidimensionrpt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Duk Woo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MultiDimensionRPTDBDAOSearchYdToRhqRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MTY RTN YD로 RHQ 구하기
	  * </pre>
	  */
	public MultiDimensionRPTDBDAOSearchYdToRhqRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_mty_rtn_lst_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.multidimensionrpt.multidimensionrpt.integration").append("\n"); 
		query.append("FileName : MultiDimensionRPTDBDAOSearchYdToRhqRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT ML.LOC_CD MAS_ECC, O.OFC_N3RD_LVL_CD MAS_RHQ, MAS_LOC_FNC(SUBSTR(@[f_mty_rtn_lst_cd],1,5),'RCC') MAS_RCC" ).append("\n"); 
		query.append("FROM MAS_OFC_LVL O" ).append("\n"); 
		query.append("   , MDM_ORGANIZATION MO" ).append("\n"); 
		query.append("   , MDM_LOCATION ML" ).append("\n"); 
		query.append("WHERE O.OFC_CD = MO.OFC_CD" ).append("\n"); 
		query.append(" AND O.OFC_APLY_TO_YRMON = '999912'" ).append("\n"); 
		query.append(" AND O.OFC_LVL < 9" ).append("\n"); 
		query.append(" AND ML.LOC_CD = MO.LOC_CD" ).append("\n"); 
		query.append(" AND ML.LOC_CD = SUBSTR(@[f_mty_rtn_lst_cd],0,5)" ).append("\n"); 

	}
}