/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CntrForecastPrecisionManageDBDAOSearchAfterWeekRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.15
*@LastModifier : 
*@LastVersion : 1.0
* 2009.10.15 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrforecastprecisionmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CntrForecastPrecisionManageDBDAOSearchAfterWeekRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * <EES_EQR_0037 컨테이너 수급 예측실적 및 정확도 조회>
	  * EQR_WK_PRD   데이터 조회
	  * - Based on  1st Week와 4 weeks Ago 로 반영 (현재는 4주전 Forcast와 실적 비교)
	  * 
	  * <Change History>
	  * 1	2009.10.15	Lee ByoungHun	최초작성
	  * </pre>
	  */
	public CntrForecastPrecisionManageDBDAOSearchAfterWeekRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bef4Wk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gap",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrforecastprecisionmanage.integration").append("\n"); 
		query.append("FileName : CntrForecastPrecisionManageDBDAOSearchAfterWeekRSQL").append("\n"); 
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
		query.append("SELECT PLN_YR||PLN_WK WEEK" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT (ROWNUM)SEQ, PLN_YR, PLN_WK" ).append("\n"); 
		query.append("FROM EQR_WK_PRD" ).append("\n"); 
		query.append("WHERE PLN_YR||PLN_WK >= @[bef4Wk]" ).append("\n"); 
		query.append("ORDER BY SEQ ASC" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE SEQ = @[gap]" ).append("\n"); 
		query.append("ORDER BY WEEK ASC" ).append("\n"); 

	}
}