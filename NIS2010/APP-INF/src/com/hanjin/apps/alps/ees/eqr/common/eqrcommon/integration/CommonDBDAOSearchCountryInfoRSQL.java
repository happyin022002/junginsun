/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CommonDBDAOSearchCountryInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.04
*@LastModifier : 정은호
*@LastVersion : 1.0
* 2009.08.04 정은호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.common.eqrcommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author ChungEunHo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CommonDBDAOSearchCountryInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ECC CODE 의 국가코드와 국가명을 검색
	  * </pre>
	  */
	public CommonDBDAOSearchCountryInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("country",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.common.eqrcommon.integration").append("\n"); 
		query.append("FileName : CommonDBDAOSearchCountryInfoRSQL").append("\n"); 
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
		query.append("DISTINCT A.CNT_CD || '|' || REPLACE(B.CNT_NM,'*',' ') TITLE" ).append("\n"); 
		query.append(", A.CNT_CD" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("EQR_ECC_MST A" ).append("\n"); 
		query.append(", MDM_COUNTRY B" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("A.CNT_CD = B.CNT_CD" ).append("\n"); 
		query.append("AND A.CNT_CD LIKE @[country]" ).append("\n"); 
		query.append("AND A.DELT_FLG = 'N' -- 09.08.04 검색조건 추가 (삭제되지 않은 ECC만 조회) 기존버그 수정 By ChungEunHo" ).append("\n"); 
		query.append("ORDER BY CNT_CD" ).append("\n"); 

	}
}