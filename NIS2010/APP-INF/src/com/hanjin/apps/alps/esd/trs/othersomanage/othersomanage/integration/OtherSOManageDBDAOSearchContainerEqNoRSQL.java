/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : OtherSOManageDBDAOSearchContainerEqNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.01.02
*@LastModifier : 최종혁
*@LastVersion : 1.0
* 2012.01.02 최종혁
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.othersomanage.othersomanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author JH CHOI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OtherSOManageDBDAOSearchContainerEqNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Container의 정보를 조회한다.
	  * </pre>
	  */
	public OtherSOManageDBDAOSearchContainerEqNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("row",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.othersomanage.othersomanage.integration").append("\n"); 
		query.append("FileName : OtherSOManageDBDAOSearchContainerEqNoRSQL").append("\n"); 
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
		query.append("#if (${row} != '')" ).append("\n"); 
		query.append("SELECT M.EQ_NO" ).append("\n"); 
		query.append(",M.EQ_TPSZ_CD" ).append("\n"); 
		query.append(",D.S_ROW" ).append("\n"); 
		query.append("FROM (SELECT @[row] S_ROW" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 
		query.append(") D" ).append("\n"); 
		query.append(",(SELECT CNTR_NO AS EQ_NO ," ).append("\n"); 
		query.append("CNTR_TPSZ_CD AS EQ_TPSZ_CD ," ).append("\n"); 
		query.append("@[row] AS S_ROW" ).append("\n"); 
		query.append("FROM MST_CONTAINER" ).append("\n"); 
		query.append("WHERE CNTR_NO in (" ).append("\n"); 
		query.append("#foreach( ${key} in ${eqNo})" ).append("\n"); 
		query.append("#if($velocityCount < $eqNo.size())" ).append("\n"); 
		query.append("'$key'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$key'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND ACIAC_DIV_CD = 'A'" ).append("\n"); 
		query.append(") M" ).append("\n"); 
		query.append("WHERE D.S_ROW = M.S_ROW(+)" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("SELECT CNTR_NO AS EQ_NO" ).append("\n"); 
		query.append(",CNTR_TPSZ_CD AS EQ_TPSZ_CD" ).append("\n"); 
		query.append(",@[row] AS S_ROW" ).append("\n"); 
		query.append("FROM MST_CONTAINER" ).append("\n"); 
		query.append("WHERE CNTR_NO in (" ).append("\n"); 
		query.append("#foreach( ${key} in ${eqNo})" ).append("\n"); 
		query.append("#if($velocityCount < $eqNo.size())" ).append("\n"); 
		query.append("'$key'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$key'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND ACIAC_DIV_CD = 'A'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 

	}
}