/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : StatementCommonDBDAOsearchPopCenterListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.21
*@LastModifier : 
*@LastVersion : 1.0
* 2014.04.21 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sco.statementcommon.statementcommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class StatementCommonDBDAOsearchPopCenterListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * STM_SCO_0053의 검색조건 VO
	  * </pre>
	  */
	public StatementCommonDBDAOsearchPopCenterListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_center",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sco.statementcommon.statementcommon.integration").append("\n"); 
		query.append("FileName : StatementCommonDBDAOsearchPopCenterListRSQL").append("\n"); 
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
		query.append("SELECT CTR_ERP_NO" ).append("\n"); 
		query.append("     , CTR_ERP_CD || CTR_ENG_NM AS CTR_DESC" ).append("\n"); 
		query.append("FROM   GL_CTR_ERP  " ).append("\n"); 
		query.append("WHERE  NVL(DELT_FLG,'N') != 'Y'" ).append("\n"); 
		query.append("#if (${f_center} != '')" ).append("\n"); 
		query.append("AND    UPPER(CTR_ERP_NO) LIKE '%'||UPPER(@[f_center])||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}