/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CntrRepoExecutionFeedbackExamineDBDAOSearchBeforePlnWkRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.09
*@LastModifier : 
*@LastVersion : 1.0
* 2009.10.09 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionfeedbackexamine.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CntrRepoExecutionFeedbackExamineDBDAOSearchBeforePlnWkRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * <EES_EQR_0063 컨테이너 이송실행 실적 및 Feedback 조회>
	  * eqr_wk_prd 내의 특정주차 내의 week 정보 조회
	  * 
	  * <Change History>
	  * 1	2009.10.09	Lee ByoungHun	최초작성
	  * </pre>
	  */
	public CntrRepoExecutionFeedbackExamineDBDAOSearchBeforePlnWkRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yrwk",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionfeedbackexamine.integration").append("\n"); 
		query.append("FileName : CntrRepoExecutionFeedbackExamineDBDAOSearchBeforePlnWkRSQL").append("\n"); 
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
		query.append("SELECT PLN_YR||PLN_WK PLNWEEK" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT (ROWNUM)SEQ" ).append("\n"); 
		query.append(",PLN_YR" ).append("\n"); 
		query.append(",PLN_WK" ).append("\n"); 
		query.append(",PLN_MON" ).append("\n"); 
		query.append("FROM EQR_WK_PRD" ).append("\n"); 
		query.append("WHERE PLN_YR || PLN_WK < @[yrwk]" ).append("\n"); 
		query.append(") A ," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT COUNT(PLN_WK) MAXWEEK" ).append("\n"); 
		query.append("FROM EQR_WK_PRD" ).append("\n"); 
		query.append("WHERE PLN_YR || PLN_WK  < @[yrwk]" ).append("\n"); 
		query.append(") B" ).append("\n"); 
		query.append("WHERE A.SEQ = B.MAXWEEK" ).append("\n"); 

	}
}