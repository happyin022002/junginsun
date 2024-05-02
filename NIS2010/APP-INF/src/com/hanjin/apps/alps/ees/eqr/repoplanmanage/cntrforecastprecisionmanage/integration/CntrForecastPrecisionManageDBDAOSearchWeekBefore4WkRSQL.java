/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CntrForecastPrecisionManageDBDAOSearchWeekBefore4WkRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.21
*@LastModifier : 
*@LastVersion : 1.0
* 2010.01.21 
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

public class CntrForecastPrecisionManageDBDAOSearchWeekBefore4WkRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * <EES_EQR_0037 컨테이너 수급 예측실적 및 정확도 조회>
	  * EQR_WK_PRD 데이터 조회 (4주전)
	  * 
	  * <Change History>
	  * 1	2009.10.15	Lee ByoungHun	최초작성
	  * 2	2010.01.21	Lee ByoungHun	연도가 넘어가는 경우 에러 수정 (YYYYIW -> IYYYIW)
	  * </pre>
	  */
	public CntrForecastPrecisionManageDBDAOSearchWeekBefore4WkRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrforecastprecisionmanage.integration").append("\n"); 
		query.append("FileName : CntrForecastPrecisionManageDBDAOSearchWeekBefore4WkRSQL").append("\n"); 
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
		query.append("YRWK_BEF" ).append("\n"); 
		query.append(", YRWK_CUR" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("PLN_YR||PLN_WK YRWK_BEF" ).append("\n"); 
		query.append(", ROWNUM RNUM" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("EQR_WK_PRD" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("PLN_YR||PLN_WK BETWEEN" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("TO_CHAR(TO_DATE(" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT WK_END_DT" ).append("\n"); 
		query.append("FROM EQR_WK_PRD" ).append("\n"); 
		query.append("WHERE PLN_YR||PLN_WK = @[fmPlnYrWk]" ).append("\n"); 
		query.append("), 'YYYYMMDD')-3*7, 'IYYYIW')YRWK" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("TO_CHAR(TO_DATE(" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT WK_END_DT" ).append("\n"); 
		query.append("FROM EQR_WK_PRD" ).append("\n"); 
		query.append("WHERE PLN_YR||PLN_WK = @[toPlnYrWk]" ).append("\n"); 
		query.append("), 'YYYYMMDD')-3*7, 'IYYYIW')YRWK" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("ORDER BY" ).append("\n"); 
		query.append("PLN_YR||PLN_WK" ).append("\n"); 
		query.append(") A," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("PLN_YR||PLN_WK YRWK_CUR" ).append("\n"); 
		query.append(", ROWNUM RNUM" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("EQR_WK_PRD" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("PLN_YR||PLN_WK BETWEEN  @[fmPlnYrWk] AND @[toPlnYrWk]" ).append("\n"); 
		query.append("ORDER BY" ).append("\n"); 
		query.append("PLN_YR||PLN_WK" ).append("\n"); 
		query.append(") B" ).append("\n"); 
		query.append("WHERE A.RNUM = B.RNUM" ).append("\n"); 

	}
}