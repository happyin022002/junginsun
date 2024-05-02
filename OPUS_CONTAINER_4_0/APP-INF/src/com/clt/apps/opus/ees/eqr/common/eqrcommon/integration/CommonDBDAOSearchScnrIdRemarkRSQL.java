/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CommonDBDAOSearchScnrIdRemarkRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.31
*@LastModifier : 정은호
*@LastVersion : 1.0
* 2009.07.31 정은호
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

public class CommonDBDAOSearchScnrIdRemarkRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SCNR_ID 기준으로 해서 REMARK 정보와 기타 정보를 가져온다.
	  * </pre>
	  */
	public CommonDBDAOSearchScnrIdRemarkRSQL(){
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
		query.append("FileName : CommonDBDAOSearchScnrIdRemarkRSQL").append("\n"); 
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
		query.append("CASE WHEN REPO_PLN_CRE_FLG = 'Y' or REPO_PLN_DTRB_FLG ='Y' or SCNR_AUTO_GEN_FLG ='Y'  THEN" ).append("\n"); 
		query.append("'FALSE'" ).append("\n"); 
		query.append("ELSE" ).append("\n"); 
		query.append("'TRUE'" ).append("\n"); 
		query.append("END  STATUS," ).append("\n"); 
		query.append("SCNR_RMK" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("EQR_SCNR_MST" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("SCNR_ID =@[scnr_id]" ).append("\n"); 

	}
}