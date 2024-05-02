/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : CommonDBDAOSearchCurrencyListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.07.15
*@LastModifier : 이행지
*@LastVersion : 1.0
* 2011.07.15 이행지
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bsa.common.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Haeng-ji,Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CommonDBDAOSearchCurrencyListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * <Currency List>
	  * History-----------------------------
	  * 2011.07.15 이행지 [CHM-201112101-01] Currency Code 추가
	  * </pre>
	  */
	public CommonDBDAOSearchCurrencyListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bsa.common.integration").append("\n"); 
		query.append("FileName : CommonDBDAOSearchCurrencyListRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("		CURR_CD AS CODE" ).append("\n"); 
		query.append("	,	CURR_CD AS NAME" ).append("\n"); 
		query.append("	,	CURR_NM" ).append("\n"); 
		query.append("	,	CURR_DESC" ).append("\n"); 
		query.append("	,	CNT_CD" ).append("\n"); 
		query.append("FROM	MDM_CURRENCY" ).append("\n"); 
		query.append("WHERE	1=1" ).append("\n"); 
		query.append("#if(${curr_cd} != '')" ).append("\n"); 
		query.append("  AND	CURR_CD		= @[curr_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("  AND	DELT_FLG	= 'N'" ).append("\n"); 
		query.append("ORDER BY CURR_CD" ).append("\n"); 

	}
}