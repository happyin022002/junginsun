/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CommonDBDAOWeewklyMaxWkStrRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.05
*@LastModifier : 정은호
*@LastVersion : 1.0
* 2009.11.05 정은호
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.common.eqrcommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author ChungEunHo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CommonDBDAOWeewklyMaxWkStrRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * plan_id 기준으로 해서 9주차 수정가능 주차를 콤마구분으로 만든값 Max sk Str
	  * </pre>
	  */
	public CommonDBDAOWeewklyMaxWkStrRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yyyyww",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("WeeklyGap",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yyyy",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("next_yyyy",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.eqr.common.eqrcommon.integration").append("\n"); 
		query.append("FileName : CommonDBDAOWeewklyMaxWkStrRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("(PLN_YR||'-'||PLN_WK)  MAXWKSTR" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("(ROWNUM)SEQ," ).append("\n"); 
		query.append("PLN_YR," ).append("\n"); 
		query.append("PLN_WK," ).append("\n"); 
		query.append("PLN_MON" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("EQR_WK_PRD" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("PLN_YR IN( @[yyyy] , @[next_yyyy] )" ).append("\n"); 
		query.append("AND PLN_YR || PLN_WK >= @[yyyyww]" ).append("\n"); 
		query.append(")B" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("SEQ <=  @[WeeklyGap]" ).append("\n"); 

	}
}