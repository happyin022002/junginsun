/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CommonDBDAORemoveVslLayupWeekCopyDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.14
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.14 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.common.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CommonDBDAORemoveVslLayupWeekCopyDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Manual Detail Cost 테이블 삭제
	  * </pre>
	  */
	public CommonDBDAORemoveVslLayupWeekCopyDSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.mas.common.integration").append("\n"); 
		query.append("FileName : CommonDBDAORemoveVslLayupWeekCopyDSQL").append("\n"); 
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
		query.append("DELETE FROM MAS_MNL_DTL_COST" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("	AND COST_YRMON LIKE SUBSTR(REPLACE(@[f_tar_week],'-',''),1,4)||'%'" ).append("\n"); 
		query.append("    AND COST_WK = SUBSTR(REPLACE(@[f_tar_week],'-',''),5,2)" ).append("\n"); 
		query.append("	AND RLANE_CD = @[rlane_cd]" ).append("\n"); 

	}
}