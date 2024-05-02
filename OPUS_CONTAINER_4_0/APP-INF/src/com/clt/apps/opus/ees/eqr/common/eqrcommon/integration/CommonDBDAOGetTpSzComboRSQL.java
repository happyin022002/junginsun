/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CommonDBDAOGetTpSzComboRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.09
*@LastModifier : 
*@LastVersion : 1.0
* 2015.12.09 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.common.eqrcommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CommonDBDAOGetTpSzComboRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Container TpSz Search
	  * </pre>
	  */
	public CommonDBDAOGetTpSzComboRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("main_code",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.eqr.common.eqrcommon.integration").append("\n"); 
		query.append("FileName : CommonDBDAOGetTpSzComboRSQL").append("\n"); 
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
		query.append("SELECT TS.CNTR_TPSZ_CD AS INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append("	FROM MDM_CNTR_TP_SZ TS" ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("	#if(${del_option} != 'Y') " ).append("\n"); 
		query.append("		AND TS.DELT_FLG = 'N'" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("		AND TS.DELT_FLG = 'Y'" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if(${main_code} != '') " ).append("\n"); 
		query.append("		AND TS.CNTR_TPSZ_GRP_CD = @[main_code]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("    ORDER BY TS.RPT_DP_SEQ" ).append("\n"); 

	}
}