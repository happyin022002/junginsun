/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : DMTCommonDBDAOsearchPayerNameRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.27
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.27 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfinder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DMTCommonDBDAOsearchPayerNameRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PayerName을 조회한다.
	  * </pre>
	  */
	public DMTCommonDBDAOsearchPayerNameRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_cust_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfinder.integration").append("\n"); 
		query.append("FileName : DMTCommonDBDAOsearchPayerNameRSQL").append("\n"); 
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
		query.append("#if (${s_cust_gubun} == '1')" ).append("\n"); 
		query.append("SELECT	DELT_FLG, LPAD(VNDR_SEQ, 6, '0') AS CUST_CD, VNDR_LGL_ENG_NM AS CUST_NAME, LGS_FLG, '' NMD_CUST_FLG" ).append("\n"); 
		query.append("FROM	MDM_VENDOR" ).append("\n"); 
		query.append("WHERE	VNDR_SEQ      = (" ).append("\n"); 
		query.append("CASE WHEN REGEXP_INSTR(@[s_cust_cd], '[[:alpha:]]', 1, 1) = 0 THEN" ).append("\n"); 
		query.append("TO_NUMBER(@[s_cust_cd])" ).append("\n"); 
		query.append("ELSE" ).append("\n"); 
		query.append("-999999" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append(") -- 2013.03.27 (ALPS 통합 로그 Error) 숫자 컬럼에 문자 입력시 ORACLE Exception Error가 발생하지 않도록 처리함." ).append("\n"); 
		query.append("AND	    DELT_FLG     <> 'Y'" ).append("\n"); 
		query.append("#elseif (${s_cust_gubun} == '2')" ).append("\n"); 
		query.append("SELECT	DELT_FLG, CUST_CNT_CD||LPAD(CUST_SEQ, 6, '0') AS CUST_CD, CUST_LGL_ENG_NM AS CUST_NAME, '' LGS_FLG, NMD_CUST_FLG" ).append("\n"); 
		query.append("FROM	MDM_CUSTOMER" ).append("\n"); 
		query.append("WHERE	CUST_CNT_CD   = SUBSTR(@[s_cust_cd], 1, 2)" ).append("\n"); 
		query.append("AND	    CUST_SEQ      = (" ).append("\n"); 
		query.append("CASE WHEN REGEXP_INSTR(SUBSTR(@[s_cust_cd], 3, 6), '[[:alpha:]]', 1, 1) = 0 THEN" ).append("\n"); 
		query.append("TO_NUMBER(SUBSTR(@[s_cust_cd], 3, 6) )" ).append("\n"); 
		query.append("ELSE" ).append("\n"); 
		query.append("-999999" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append(") -- 2013.03.27 (ALPS 통합 로그 Error) 숫자 컬럼에 문자 입력시 ORACLE Exception Error가 발생하지 않도록 처리함." ).append("\n"); 
		query.append("AND     DELT_FLG     <> 'Y'" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}