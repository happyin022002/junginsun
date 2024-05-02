/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : trdCdCommonDBDAOSearchTradeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.08.06
*@LastModifier : 
*@LastVersion : 1.0
* 2014.08.06 
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

public class trdCdCommonDBDAOSearchTradeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Trade 상단 콤보에 나오는 검색 쿼리
	  * </pre>
	  */
	public trdCdCommonDBDAOSearchTradeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.eqr.common.eqrcommon.integration").append("\n"); 
		query.append("FileName : trdCdCommonDBDAOSearchTradeRSQL").append("\n"); 
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
		query.append("SELECT  TRD_CD trdCd" ).append("\n"); 
		query.append("         , TRD_NM trdNm" ).append("\n"); 
		query.append("         , FM_CONTI_CD fmContiCd" ).append("\n"); 
		query.append("         , TO_CONTI_CD toContiCd" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("        SELECT 'A' PRI" ).append("\n"); 
		query.append("                , 'ALL' TRD_CD" ).append("\n"); 
		query.append("                , '' TRD_NM" ).append("\n"); 
		query.append("                , '' FM_CONTI_CD" ).append("\n"); 
		query.append("                , '' TO_CONTI_CD" ).append("\n"); 
		query.append("        FROM DUAL" ).append("\n"); 
		query.append("        UNION ALL   " ).append("\n"); 
		query.append("        SELECT 'B' PRI" ).append("\n"); 
		query.append("                , TRD_CD" ).append("\n"); 
		query.append("                , TRD_NM" ).append("\n"); 
		query.append("                , FM_CONTI_CD" ).append("\n"); 
		query.append("                , TO_CONTI_CD" ).append("\n"); 
		query.append("        FROM MDM_TRADE        " ).append("\n"); 
		query.append("        WHERE 1=1" ).append("\n"); 
		query.append("        AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("   )" ).append("\n"); 
		query.append("ORDER BY PRI, TRD_CD" ).append("\n"); 

	}
}