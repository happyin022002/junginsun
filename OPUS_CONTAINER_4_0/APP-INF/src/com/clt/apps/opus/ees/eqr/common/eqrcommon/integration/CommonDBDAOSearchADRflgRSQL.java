/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CommonDBDAOSearchADRflgRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.28
*@LastModifier : 정은호
*@LastVersion : 1.0
* 2009.07.28 정은호
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.common.eqrcommon.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author ChungEunHo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CommonDBDAOSearchADRflgRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EQR_SCNR_MST ADFflag 조회
	  * </pre>
	  */
	public CommonDBDAOSearchADRflgRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scnr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.eqr.common.eqrcommon.integration ").append("\n"); 
		query.append("FileName : CommonDBDAOSearchADRflgRSQL").append("\n"); 
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
		query.append("SCNR_AUTO_GEN_FLG," ).append("\n"); 
		query.append("REPO_PLN_CRE_FLG," ).append("\n"); 
		query.append("REPO_PLN_DTRB_FLG ," ).append("\n"); 
		query.append("CASE WHEN (SCNR_AUTO_GEN_FLG='Y' OR REPO_PLN_CRE_FLG ='Y' OR REPO_PLN_DTRB_FLG = 'Y') THEN" ).append("\n"); 
		query.append("'FALSE'" ).append("\n"); 
		query.append("ELSE" ).append("\n"); 
		query.append("'TRUE'" ).append("\n"); 
		query.append("END AS ADRflg" ).append("\n"); 
		query.append("FROM EQR_SCNR_MST" ).append("\n"); 
		query.append("WHERE SCNR_ID = @[scnr_id]" ).append("\n"); 

	}
}