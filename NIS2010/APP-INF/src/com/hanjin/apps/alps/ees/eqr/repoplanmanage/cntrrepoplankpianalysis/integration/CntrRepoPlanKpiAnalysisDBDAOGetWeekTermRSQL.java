/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CntrRepoPlanKpiAnalysisDBDAOGetWeekTermRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.21
*@LastModifier : 
*@LastVersion : 1.0
* 2009.09.21 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoplankpianalysis.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CntrRepoPlanKpiAnalysisDBDAOGetWeekTermRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * <EES_EQR_0071 컨테이너 이송 계획 KPI 요약 조회>
	  * 주차간의 term 조회
	  * 
	  * <Change History>
	  * 1	2009.09.21	Lee ByoungHun	최초작성
	  * </pre>
	  */
	public CntrRepoPlanKpiAnalysisDBDAOGetWeekTermRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fmPlnYrWk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("toPlnYrWk",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoplankpianalysis.integration").append("\n"); 
		query.append("FileName : CntrRepoPlanKpiAnalysisDBDAOGetWeekTermRSQL").append("\n"); 
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
		query.append("(" ).append("\n"); 
		query.append("SELECT MAX(ROWNUM) TERM" ).append("\n"); 
		query.append("FROM(" ).append("\n"); 
		query.append("SELECT PLN_YR, PLN_WK, ROWNUM" ).append("\n"); 
		query.append("FROM EQR_WK_PRD WHERE PLN_YR || PLN_WK BETWEEN  @[fmPlnYrWk] AND @[toPlnYrWk]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(") TERM," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT PLN_YR||PLN_WK CHECKYRWK--, RM" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT PLN_YR, PLN_WK, ROWNUM  RM" ).append("\n"); 
		query.append("FROM EQR_WK_PRD WHERE PLN_YR || PLN_WK BETWEEN  @[fmPlnYrWk] AND @[toPlnYrWk]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE RM =" ).append("\n"); 
		query.append("(SELECT MAX(ROWNUM) -1" ).append("\n"); 
		query.append("FROM(" ).append("\n"); 
		query.append("SELECT PLN_YR, PLN_WK, ROWNUM" ).append("\n"); 
		query.append("FROM EQR_WK_PRD WHERE PLN_YR || PLN_WK BETWEEN  @[fmPlnYrWk] AND @[toPlnYrWk]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(") CHECKYRWK" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}