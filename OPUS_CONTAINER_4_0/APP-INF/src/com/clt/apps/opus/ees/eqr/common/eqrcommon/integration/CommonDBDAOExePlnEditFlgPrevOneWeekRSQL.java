/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CommonDBDAOExePlnEditFlgPrevOneWeekRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.03.18
*@LastModifier : 
*@LastVersion : 1.0
* 2014.03.18 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.common.eqrcommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CommonDBDAOExePlnEditFlgPrevOneWeekRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * execution plan 에서 plan 의 yrwk이 현재 local 의 yrwk 보다 한주이상 작으면edit 불가.(VD Add 버튼에 적용됨)
	  * </pre>
	  */
	public CommonDBDAOExePlnEditFlgPrevOneWeekRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("localDate",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.eqr.common.eqrcommon.integration").append("\n"); 
		query.append("FileName : CommonDBDAOExePlnEditFlgPrevOneWeekRSQL").append("\n"); 
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
		query.append("SELECT                            							" ).append("\n"); 
		query.append("	CASE WHEN -->  (PLAN WK - LOCAL WK)  < EDIT FALSE...   	" ).append("\n"); 
		query.append("				" ).append("\n"); 
		query.append("		NVL(TO_NUMBER(( " ).append("\n"); 
		query.append("						SELECT " ).append("\n"); 
		query.append("							WK_ST_DT LOCALDATE         		          " ).append("\n"); 
		query.append("              			FROM " ).append("\n"); 
		query.append("							EQR_WK_PRD                   			" ).append("\n"); 
		query.append("              			WHERE PLN_YR||PLN_WK = @[yyyyww] " ).append("\n"); 
		query.append("					 )), 0)				" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   		  - TO_NUMBER((    										" ).append("\n"); 
		query.append("						SELECT " ).append("\n"); 
		query.append("							TO_CHAR(TO_DATE(WK_ST_DT, 'YYYYMMDD')-7, 'YYYYMMDD') LOCALDATE" ).append("\n"); 
		query.append("  						FROM " ).append("\n"); 
		query.append("							EQR_WK_PRD                               		" ).append("\n"); 
		query.append(" 						WHERE " ).append("\n"); 
		query.append("							@[localDate] BETWEEN WK_ST_DT AND WK_END_DT  			" ).append("\n"); 
		query.append(" 					 ))  < 0 THEN " ).append("\n"); 
		query.append("		'FALSE' " ).append("\n"); 
		query.append("	ELSE " ).append("\n"); 
		query.append("		'TRUE' " ).append("\n"); 
		query.append("	END EXEPLNEDITFLG  	" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}