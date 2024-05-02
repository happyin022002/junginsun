/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : MSTCommonDBDAOSearchLessorCodeDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.07.08
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2013.07.08 채창호
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mst.mstcommon.mstcommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MSTCommonDBDAOSearchLessorCodeDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchLessorCodeData
	  * </pre>
	  */
	public MSTCommonDBDAOSearchLessorCodeDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("code",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mst.mstcommon.mstcommon.integration").append("\n"); 
		query.append("FileName : MSTCommonDBDAOSearchLessorCodeDataRSQL").append("\n"); 
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
		query.append("SELECT A.VNDR_SEQ AS CODE," ).append("\n"); 
		query.append("	   A.VNDR_LGL_ENG_NM AS CODE_NM" ).append("\n"); 
		query.append("FROM   MDM_VENDOR A" ).append("\n"); 
		query.append("WHERE  A.VNDR_SEQ   = (" ).append("\n"); 
		query.append("                          CASE WHEN REGEXP_INSTR(@[code], '[:alpha:]', 1, 1) = 0 THEN" ).append("\n"); 
		query.append("                             TO_NUMBER( @[code] )" ).append("\n"); 
		query.append("                          ELSE" ).append("\n"); 
		query.append("                             -999999" ).append("\n"); 
		query.append("                          END" ).append("\n"); 
		query.append("                        )" ).append("\n"); 

	}
}