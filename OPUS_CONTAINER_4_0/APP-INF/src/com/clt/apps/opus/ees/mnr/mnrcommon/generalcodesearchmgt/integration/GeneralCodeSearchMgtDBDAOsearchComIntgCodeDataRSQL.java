/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : GeneralCodeSearchMgtDBDAOsearchComIntgCodeDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.03
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.03 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralCodeSearchMgtDBDAOsearchComIntgCodeDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Common INTG Code를 조회하는 Operation
	  * </pre>
	  */
	public GeneralCodeSearchMgtDBDAOsearchComIntgCodeDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("searchkey",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.integration").append("\n"); 
		query.append("FileName : GeneralCodeSearchMgtDBDAOsearchComIntgCodeDataRSQL").append("\n"); 
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
		query.append("SELECT CD_ID, CD_DESC" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("  INTG_CD_VAL_CTNT AS CD_ID," ).append("\n"); 
		query.append("  INTG_CD_VAL_DP_DESC AS CD_DESC" ).append("\n"); 
		query.append("FROM COM_INTG_CD_DTL " ).append("\n"); 
		query.append("WHERE INTG_CD_ID = @[searchkey]" ).append("\n"); 
		query.append("ORDER BY INTG_CD_VAL_DP_SEQ" ).append("\n"); 
		query.append(")	" ).append("\n"); 

	}
}