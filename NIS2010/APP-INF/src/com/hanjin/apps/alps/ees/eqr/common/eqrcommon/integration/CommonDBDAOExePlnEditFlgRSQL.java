/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CommonDBDAOExePlnEditFlgRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.29
*@LastModifier : 정은호
*@LastVersion : 1.0
* 2009.07.29 정은호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.common.eqrcommon.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author ChungEunHo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CommonDBDAOExePlnEditFlgRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * execution plan 에서 plan 의 yrwk이 현재 local 의 yrwk 보다 작으면 edit 불가.(SAVE Button과 기타 수정버튼에 적용됨)
	  * </pre>
	  */
	public CommonDBDAOExePlnEditFlgRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.ees.eqr.common.eqrcommon.integration ").append("\n"); 
		query.append("FileName : CommonDBDAOExePlnEditFlgRSQL").append("\n"); 
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
		query.append("CASE WHEN   -->  (PLAN WK - LOCAL WK)  < EDIT FALSE..." ).append("\n"); 
		query.append("TO_NUMBER( @[yyyyww] ) - TO_NUMBER((" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("PLN_YR||PLN_WK LOCALDATE" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("EQR_WK_PRD" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("@[localDate] BETWEEN WK_ST_DT AND WK_END_DT" ).append("\n"); 
		query.append("))  < 0 THEN" ).append("\n"); 
		query.append("'FALSE'" ).append("\n"); 
		query.append("ELSE" ).append("\n"); 
		query.append("'TRUE'" ).append("\n"); 
		query.append("END EXEPLNEDITFLG" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("-- MODIFIED BY SHIN YONGCHAN 20070529" ).append("\n"); 

	}
}