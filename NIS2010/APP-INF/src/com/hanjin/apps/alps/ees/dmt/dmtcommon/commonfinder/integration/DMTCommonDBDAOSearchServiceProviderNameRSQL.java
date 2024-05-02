/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : DMTCommonDBDAOSearchServiceProviderNameRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.11.08
*@LastModifier : 임창빈
*@LastVersion : 1.0
* 2013.11.08 임창빈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfinder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lim Chang Bin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DMTCommonDBDAOSearchServiceProviderNameRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Vendor Name을 조회한다.
	  * </pre>
	  */
	public DMTCommonDBDAOSearchServiceProviderNameRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfinder.integration").append("\n"); 
		query.append("FileName : DMTCommonDBDAOSearchServiceProviderNameRSQL").append("\n"); 
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
		query.append("SELECT	LPAD(VNDR_SEQ, 6, '0') AS VNDR_CD, VNDR_LGL_ENG_NM AS VNDR_NM" ).append("\n"); 
		query.append("FROM	MDM_VENDOR" ).append("\n"); 
		query.append("WHERE	VNDR_SEQ   = (" ).append("\n"); 
		query.append("                     CASE" ).append("\n"); 
		query.append("                     WHEN REGEXP_INSTR(@[vndr_cd], '[[:alpha:]]', 1, 1) = 0 THEN" ).append("\n"); 
		query.append("                          TO_NUMBER(@[vndr_cd])" ).append("\n"); 
		query.append("                     ELSE" ).append("\n"); 
		query.append("                             -999999" ).append("\n"); 
		query.append("                     END" ).append("\n"); 
		query.append("                     ) -- 2013.11.09 (ALPS 통합 로그 Error) 숫자 컬럼에 문자 입력시 ORACLE Exception Error가 발생하지 않도록 처리함." ).append("\n"); 
		query.append("AND     DELT_FLG <> 'Y'" ).append("\n"); 

	}
}