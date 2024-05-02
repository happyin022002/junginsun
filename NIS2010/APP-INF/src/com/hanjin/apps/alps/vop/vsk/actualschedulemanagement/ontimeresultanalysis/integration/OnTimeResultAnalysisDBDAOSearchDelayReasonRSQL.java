/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : OnTimeResultAnalysisDBDAOSearchDelayReasonRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.07.22
*@LastModifier : 
*@LastVersion : 1.0
* 2014.07.22 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.ontimeresultanalysis.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OnTimeResultAnalysisDBDAOSearchDelayReasonRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchDelayReason
	  * </pre>
	  */
	public OnTimeResultAnalysisDBDAOSearchDelayReasonRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("intg_cd_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.ontimeresultanalysis.integration").append("\n"); 
		query.append("FileName : OnTimeResultAnalysisDBDAOSearchDelayReasonRSQL").append("\n"); 
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
		query.append("SELECT    MAX(DECODE(INTG_CD_VAL_DP_SEQ, 01, INTG_CD_VAL_CTNT)) || '|' " ).append("\n"); 
		query.append("        ||MAX(DECODE(INTG_CD_VAL_DP_SEQ, 02, INTG_CD_VAL_CTNT)) || '|'" ).append("\n"); 
		query.append("        ||MAX(DECODE(INTG_CD_VAL_DP_SEQ, 03, INTG_CD_VAL_CTNT)) || '|'" ).append("\n"); 
		query.append("        ||MAX(DECODE(INTG_CD_VAL_DP_SEQ, 04, INTG_CD_VAL_CTNT)) || '|'" ).append("\n"); 
		query.append("        ||MAX(DECODE(INTG_CD_VAL_DP_SEQ, 05, INTG_CD_VAL_CTNT)) || '|'" ).append("\n"); 
		query.append("        ||MAX(DECODE(INTG_CD_VAL_DP_SEQ, 06, INTG_CD_VAL_CTNT)) || '|'" ).append("\n"); 
		query.append("        ||MAX(DECODE(INTG_CD_VAL_DP_SEQ, 07, INTG_CD_VAL_CTNT)) || '|'" ).append("\n"); 
		query.append("        ||MAX(DECODE(INTG_CD_VAL_DP_SEQ, 08, INTG_CD_VAL_CTNT)) || '|'" ).append("\n"); 
		query.append("        ||MAX(DECODE(INTG_CD_VAL_DP_SEQ, 09, INTG_CD_VAL_CTNT)) || '|'" ).append("\n"); 
		query.append("        ||MAX(DECODE(INTG_CD_VAL_DP_SEQ, 10, INTG_CD_VAL_CTNT)) || '|'" ).append("\n"); 
		query.append("        ||MAX(DECODE(INTG_CD_VAL_DP_SEQ, 11, INTG_CD_VAL_CTNT)) || '|'" ).append("\n"); 
		query.append("        ||MAX(DECODE(INTG_CD_VAL_DP_SEQ, 12, INTG_CD_VAL_CTNT)) || '|'" ).append("\n"); 
		query.append("        ||MAX(DECODE(INTG_CD_VAL_DP_SEQ, 13, INTG_CD_VAL_CTNT)) || '|'" ).append("\n"); 
		query.append("        ||MAX(DECODE(INTG_CD_VAL_DP_SEQ, 14, INTG_CD_VAL_CTNT)) || '|'" ).append("\n"); 
		query.append("        ||MAX(DECODE(INTG_CD_VAL_DP_SEQ, 15, INTG_CD_VAL_CTNT)) || '|'" ).append("\n"); 
		query.append("        ||MAX(DECODE(INTG_CD_VAL_DP_SEQ, 16, INTG_CD_VAL_CTNT)) || '|'" ).append("\n"); 
		query.append("        ||MAX(DECODE(INTG_CD_VAL_DP_SEQ, 17, INTG_CD_VAL_CTNT)) || '|'" ).append("\n"); 
		query.append("        ||MAX(DECODE(INTG_CD_VAL_DP_SEQ, 18, INTG_CD_VAL_CTNT)) || '|'" ).append("\n"); 
		query.append("        ||MAX(DECODE(INTG_CD_VAL_DP_SEQ, 19, INTG_CD_VAL_CTNT)) || '|'" ).append("\n"); 
		query.append("        ||MAX(DECODE(INTG_CD_VAL_DP_SEQ, 20, INTG_CD_VAL_CTNT)) || '|'" ).append("\n"); 
		query.append("        ||MAX(DECODE(INTG_CD_VAL_DP_SEQ, 21, INTG_CD_VAL_CTNT)) AS HEADER" ).append("\n"); 
		query.append("FROM    COM_INTG_CD_DTL" ).append("\n"); 
		query.append("WHERE   INTG_CD_ID = @[intg_cd_id]" ).append("\n"); 
		query.append("ORDER BY INTG_CD_VAL_DP_SEQ" ).append("\n"); 

	}
}