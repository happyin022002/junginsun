/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : CommonDBDAOSearchMonthlyQtaStatusInquiryBoundListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.04
*@LastModifier : 
*@LastVersion : 1.0
* 2011.03.04 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.saq.common.common.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CommonDBDAOSearchMonthlyQtaStatusInquiryBoundListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public CommonDBDAOSearchMonthlyQtaStatusInquiryBoundListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("year",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("quarter",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.saq.common.common.integration").append("\n"); 
		query.append("FileName : CommonDBDAOSearchMonthlyQtaStatusInquiryBoundListRSQL").append("\n"); 
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
		query.append("SELECT					" ).append("\n"); 
		query.append("    CODE, 				" ).append("\n"); 
		query.append("    TEXT				" ).append("\n"); 
		query.append("FROM					" ).append("\n"); 
		query.append("    (					" ).append("\n"); 
		query.append("    SELECT '' AS CODE,		" ).append("\n"); 
		query.append("	   ' ' AS TEXT		" ).append("\n"); 
		query.append("    FROM DUAL       			" ).append("\n"); 
		query.append("    UNION 				" ).append("\n"); 
		query.append("    SELECT 				" ).append("\n"); 
		query.append("	DISTINCT DIR_CD AS CODE,	" ).append("\n"); 
		query.append("	DIR_CD AS TEXT			" ).append("\n"); 
		query.append("    					" ).append("\n"); 
		query.append("    FROM SAQ_MON_QTA_STEP_VER		" ).append("\n"); 
		query.append("    					" ).append("\n"); 
		query.append("    WHERE 				" ).append("\n"); 
		query.append("	BSE_YR= @[year]			" ).append("\n"); 
		query.append("	AND BSE_QTR_CD = @[quarter] 		" ).append("\n"); 
		query.append("	#if (${trd_cd} != 'total' )" ).append("\n"); 
		query.append("		AND TRD_CD = @[trd_cd] 		" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("    )					" ).append("\n"); 
		query.append("    					" ).append("\n"); 
		query.append("ORDER BY TEXT 		" ).append("\n"); 

	}
}