/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : CommonDBDAOSearchSaqMonthlyQuotaCurrentReleaseYearMonthRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.21
*@LastModifier : 
*@LastVersion : 1.0
* 2011.02.21 
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

public class CommonDBDAOSearchSaqMonthlyQuotaCurrentReleaseYearMonthRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 연간 Multi account 생성 가능 여부 확인
	  * </pre>
	  */
	public CommonDBDAOSearchSaqMonthlyQuotaCurrentReleaseYearMonthRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.saq.common.common.integration").append("\n"); 
		query.append("FileName : CommonDBDAOSearchSaqMonthlyQuotaCurrentReleaseYearMonthRSQL").append("\n"); 
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
		query.append("  CASE WHEN YR_MON ='Q' THEN" ).append("\n"); 
		query.append("  	TO_CHAR(SYSDATE,'YYYY')||RPAD(DECODE(MOD(TO_CHAR(TO_DATE(SYSDATE),'Q')+1,4),0,4,MOD(TO_CHAR(TO_DATE(SYSDATE),'Q')+1,4)),2,'Q') 	--데이터 존재하지 않을 경우 현재 Quarter+1 셋팅" ).append("\n"); 
		query.append("  ELSE" ).append("\n"); 
		query.append("  	YR_MON" ).append("\n"); 
		query.append("  END CODE_CD," ).append("\n"); 
		query.append("  CASE WHEN YR_MON ='Q' THEN" ).append("\n"); 
		query.append("  	TO_CHAR(SYSDATE,'YYYY')||RPAD(DECODE(MOD(TO_CHAR(TO_DATE(SYSDATE),'Q')+1,4),0,4,MOD(TO_CHAR(TO_DATE(SYSDATE),'Q')+1,4)),2,'Q')" ).append("\n"); 
		query.append("  ELSE" ).append("\n"); 
		query.append("  	YR_MON" ).append("\n"); 
		query.append("  END CODE_NM" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("  (" ).append("\n"); 
		query.append("      SELECT" ).append("\n"); 
		query.append("         DECODE(MON,'4',TO_NUMBER(YR)+1||'1Q',YR||TO_NUMBER(MON)+1)||'Q' YR_MON" ).append("\n"); 
		query.append("      FROM" ).append("\n"); 
		query.append("      (" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("          SELECT" ).append("\n"); 
		query.append("             SUBSTR(MAX(BSE_YR||SUBSTR(BSE_QTR_CD,1,1)),1,4) YR," ).append("\n"); 
		query.append("             SUBSTR(MAX(BSE_YR||SUBSTR(BSE_QTR_CD,1,1)),5,2) MON" ).append("\n"); 
		query.append("          FROM  SAQ_MON_QTA_RLSE" ).append("\n"); 
		query.append("          WHERE QTA_RLSE_STS_CD = 'R'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("      )" ).append("\n"); 
		query.append("  )" ).append("\n"); 

	}
}