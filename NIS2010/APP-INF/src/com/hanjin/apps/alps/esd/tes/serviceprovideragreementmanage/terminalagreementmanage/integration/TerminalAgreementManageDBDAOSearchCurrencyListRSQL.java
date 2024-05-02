/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TerminalAgreementManageDBDAOSearchCurrencyListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.28
*@LastModifier : yOng hO lEE
*@LastVersion : 1.0
* 2009.08.28 yOng hO lEE
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.serviceprovideragreementmanage.terminalagreementmanage.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author yOng hO lEE
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TerminalAgreementManageDBDAOSearchCurrencyListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Currency Code List 조회
	  * </pre>
	  */
	public TerminalAgreementManageDBDAOSearchCurrencyListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.serviceprovideragreementmanage.terminalagreementmanage.integration ").append("\n"); 
		query.append("FileName : TerminalAgreementManageDBDAOSearchCurrencyListRSQL").append("\n"); 
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
		query.append("(SELECT ar_curr_cd FROM MDM_ORGANIZATION WHERE	ofc_cd = @[ofc_cd]) DEF" ).append("\n"); 
		query.append(", (SELECT ar_curr_cd FROM MDM_ORGANIZATION WHERE ofc_cd = @[ofc_cd]) ||'|'||" ).append("\n"); 
		query.append("(SELECT LTRIM(MAX(SYS_CONNECT_BY_PATH(CURR_CD,'|')),'|')" ).append("\n"); 
		query.append("FROM	(SELECT ROWNUM row_id, z.curr_cd" ).append("\n"); 
		query.append("FROM (SELECT curr_cd FROM MDM_CURRENCY) z)" ).append("\n"); 
		query.append("CONNECT BY PRIOR row_id = row_id - 1" ).append("\n"); 
		query.append("START WITH row_id = 1" ).append("\n"); 
		query.append(") AR_CURR_CD" ).append("\n"); 
		query.append("FROM	DUAL" ).append("\n"); 

	}
}