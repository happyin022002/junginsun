/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CntrRepoPlanManageDBSearchDAONowWeekDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.05
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.05 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoplanmanage.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CntrRepoPlanManageDBSearchDAONowWeekDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DB에서 현재 주차 계산
	  * </pre>
	  */
	public CntrRepoPlanManageDBSearchDAONowWeekDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("nowdate",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoplanmanage.integration ").append("\n"); 
		query.append("FileName : CntrRepoPlanManageDBSearchDAONowWeekDataRSQL").append("\n"); 
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
		query.append("SELECT (PLN_YR||PLN_WK) AS NOWWEEK " ).append("\n"); 
		query.append("FROM EQR_WK_PRD " ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND @[nowdate] BETWEEN WK_ST_DT AND WK_END_DT" ).append("\n"); 

	}
}