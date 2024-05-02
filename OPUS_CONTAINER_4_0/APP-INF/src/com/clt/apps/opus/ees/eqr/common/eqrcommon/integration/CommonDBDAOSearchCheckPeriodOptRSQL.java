/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CommonDBDAOSearchCheckPeriodOptRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.31
*@LastModifier : 정은호
*@LastVersion : 1.0
* 2009.07.31 정은호
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.common.eqrcommon.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author ChungEunHo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CommonDBDAOSearchCheckPeriodOptRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * edit Week & GapWeek 정보를 검색(Fm To At 화면.)
	  * </pre>
	  */
	public CommonDBDAOSearchCheckPeriodOptRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yrwk_03",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yrwk_02",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yrwk_01",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("month",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.eqr.common.eqrcommon.integration ").append("\n"); 
		query.append("FileName : CommonDBDAOSearchCheckPeriodOptRSQL").append("\n"); 
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
		query.append("PLN_YRWK" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("PLN_YR||PLN_WK  PLN_YRWK" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("EQR_WK_PRD" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("PLN_YR||PLN_WK >= @[yrwk_01]" ).append("\n"); 
		query.append("ORDER BY PLN_YRWK" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE ROWNUM <= @[month]" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("PLN_YRWK" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("PLN_YR||PLN_WK  PLN_YRWK" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("EQR_WK_PRD" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("PLN_YR||PLN_WK >= @[yrwk_02]" ).append("\n"); 
		query.append("ORDER BY PLN_YRWK" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE ROWNUM <= @[month]" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("PLN_YRWK" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("PLN_YR||PLN_WK  PLN_YRWK" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("EQR_WK_PRD" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("PLN_YR||PLN_WK >= @[yrwk_03]" ).append("\n"); 
		query.append("ORDER BY PLN_YRWK" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE ROWNUM <= @[month]" ).append("\n"); 

	}
}