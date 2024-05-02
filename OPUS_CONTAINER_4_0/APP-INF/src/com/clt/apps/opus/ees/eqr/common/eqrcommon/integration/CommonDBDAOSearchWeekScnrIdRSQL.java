/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : CommonDBDAOSearchWeekScnrIdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.03
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2012.04.03 채창호
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.common.eqrcommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Chang HO Chae
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CommonDBDAOSearchWeekScnrIdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Week에 해당하는 ScnrId 정보를 검색
	  * 기준 week정보가 null일 경우 sysdate를 기준으로 scnr_id를 조회한다.
	  * </pre>
	  */
	public CommonDBDAOSearchWeekScnrIdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("plnyrwk",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.eqr.common.eqrcommon.integration").append("\n"); 
		query.append("FileName : CommonDBDAOSearchWeekScnrIdRSQL").append("\n"); 
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
		query.append("    REPO_PLN_ID SCNR_ID " ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("    EQR_VSL_LODG_DCHG_PLN	" ).append("\n"); 
		query.append("WHERE substr(REPO_PLN_ID, 5,6) = " ).append("\n"); 
		query.append("        #if( ${gubun} == 'Load')" ).append("\n"); 
		query.append("         ( " ).append("\n"); 
		query.append("            SELECT " ).append("\n"); 
		query.append("                PLN_YR||PLN_WK WEEK " ).append("\n"); 
		query.append("            FROM " ).append("\n"); 
		query.append("                EQR_WK_PRD " ).append("\n"); 
		query.append("            WHERE " ).append("\n"); 
		query.append("                TO_CHAR(SYSDATE,'yyyymmdd') BETWEEN WK_ST_DT AND WK_END_DT" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("        #else" ).append("\n"); 
		query.append("    			@[plnyrwk]" ).append("\n"); 
		query.append("    	#end" ).append("\n"); 

	}
}