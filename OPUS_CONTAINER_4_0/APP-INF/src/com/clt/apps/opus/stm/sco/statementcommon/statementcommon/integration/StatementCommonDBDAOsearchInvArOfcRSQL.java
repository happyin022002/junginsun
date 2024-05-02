/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : StatementCommonDBDAOsearchInvArOfcRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.17
*@LastModifier : 
*@LastVersion : 1.0
* 2015.04.17 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sco.statementcommon.statementcommon.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class StatementCommonDBDAOsearchInvArOfcRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchInvArOfc
	  * </pre>
	  */
	public StatementCommonDBDAOsearchInvArOfcRSQL(){
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
		query.append("Path : com.clt.apps.opus.stm.sco.statementcommon.statementcommon.integration ").append("\n"); 
		query.append("FileName : StatementCommonDBDAOsearchInvArOfcRSQL").append("\n"); 
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
		query.append("SELECT NVL2(MAX(AR_OFC_CD),'Y','N') AS EXIST" ).append("\n"); 
		query.append("  FROM   INV_AR_STUP_OFC" ).append("\n"); 
		query.append("  WHERE  AR_OFC_CD = @[ofc_cd]" ).append("\n"); 

	}
}