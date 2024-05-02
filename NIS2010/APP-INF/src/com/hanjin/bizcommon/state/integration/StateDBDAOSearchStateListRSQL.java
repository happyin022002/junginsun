/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : StateDBDAOSearchStateListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.09.16
*@LastModifier : 
*@LastVersion : 1.0
* 2011.09.16 
* 1.0 Creation
=========================================================*/
package com.hanjin.bizcommon.state.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class StateDBDAOSearchStateListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchStateList
	  * </pre>
	  */
	public StateDBDAOSearchStateListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.bizcommon.state.integration ").append("\n"); 
		query.append("FileName : StateDBDAOSearchStateListRSQL").append("\n"); 
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
		query.append("SELECT STE_CD," ).append("\n"); 
		query.append("       STE_NM" ).append("\n"); 
		query.append("FROM MDM_STATE" ).append("\n"); 
		query.append("WHERE 1 = 1 " ).append("\n"); 
		query.append("AND nvl(DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${cnt_cd} != '') " ).append("\n"); 
		query.append("AND cnt_cd = @[cnt_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}