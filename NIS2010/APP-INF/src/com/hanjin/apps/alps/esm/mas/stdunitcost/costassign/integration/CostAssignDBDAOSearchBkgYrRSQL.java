/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CostAssignDBDAOSearchBkgYrRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.19
*@LastModifier : 최덕우
*@LastVersion : 1.0
* 2015.06.19 최덕우
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.stdunitcost.costassign.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Duk Woo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CostAssignDBDAOSearchBkgYrRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BKG Cost YR 조회
	  * </pre>
	  */
	public CostAssignDBDAOSearchBkgYrRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.stdunitcost.costassign.integration").append("\n"); 
		query.append("FileName : CostAssignDBDAOSearchBkgYrRSQL").append("\n"); 
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
		query.append("SELECT MIN(BKG_YR) BKG_YR" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("	SELECT SUBSTR(COST_YRMON,1,4) BKG_YR " ).append("\n"); 
		query.append("		FROM MAS_BKG_EXPN_DTL" ).append("\n"); 
		query.append("		WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("	UNION ALL" ).append("\n"); 
		query.append("	SELECT TO_CHAR(SYSDATE, 'YYYY') BKG_YR FROM DUAL" ).append("\n"); 
		query.append("	)" ).append("\n"); 

	}
}