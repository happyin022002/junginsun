/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ScenarioDefaultManageDBDAOSearchEqrHolidayEffectDetailRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.05
*@LastModifier : 정은호
*@LastVersion : 1.0
* 2009.11.05 정은호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author ChungEunHo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ScenarioDefaultManageDBDAOSearchEqrHolidayEffectDetailRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EQR_HOL_PERF 테이블의 상세 정보 조회
	  * </pre>
	  */
	public ScenarioDefaultManageDBDAOSearchEqrHolidayEffectDetailRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gubun",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stdt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcc_div_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntcd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.integration").append("\n"); 
		query.append("FileName : ScenarioDefaultManageDBDAOSearchEqrHolidayEffectDetailRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("C.CNT_NM" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("EQR_HOL_PERF A" ).append("\n"); 
		query.append(", EQR_HOLIDAY  C" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("A.HOL_PERF_YR = C.HOL_YR" ).append("\n"); 
		query.append("AND A.CNT_CD = C.CNT_CD" ).append("\n"); 
		query.append("AND A.RCC_DIV_FLG = C.RCC_DIV_FLG" ).append("\n"); 
		query.append("AND A.RCC_DIV_FLG = @[rcc_div_flg]" ).append("\n"); 
		query.append("AND A.CNT_CD  = @[cntcd]" ).append("\n"); 
		query.append("AND A.IO_BND_CD  = @[gubun]" ).append("\n"); 
		query.append("AND ROWNUM=1" ).append("\n"); 
		query.append(")  CNT_NM" ).append("\n"); 
		query.append(", D.INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append("#foreach( ${key} in ${wkarr})" ).append("\n"); 
		query.append(", MAX(NVL(B.HOL_EFF_RTO,A.HOL_PERF_RTO))  WEEK$key" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", MAX(NVL(B.HOL_EFF_RTO,A.HOL_PERF_RTO))  RTO" ).append("\n"); 
		query.append(", A.HOL_PERF_YR" ).append("\n"); 
		query.append(", A.CNT_CD" ).append("\n"); 
		query.append(", A.RCC_DIV_FLG" ).append("\n"); 
		query.append(", A.IO_BND_CD" ).append("\n"); 
		query.append(", '' AS NBLK" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("EQR_HOL_PERF A" ).append("\n"); 
		query.append(", EQR_HOL_EFF_RTO  B" ).append("\n"); 
		query.append(", COM_INTG_CD_DTL D" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("A.HOL_PERF_YR = B.HOL_YR(+)" ).append("\n"); 
		query.append("AND A.CNT_CD = B.CNT_CD(+)" ).append("\n"); 
		query.append("AND A.RCC_DIV_FLG = B.RCC_DIV_FLG(+)" ).append("\n"); 
		query.append("AND A.WK_DY_CD = B.WK_DY_CD(+)" ).append("\n"); 
		query.append("AND A.IO_BND_CD = B.IO_BND_CD(+)" ).append("\n"); 
		query.append("AND A.IO_BND_CD(+) = @[gubun]" ).append("\n"); 
		query.append("AND A.RCC_DIV_FLG(+) = @[rcc_div_flg]" ).append("\n"); 
		query.append("AND A.CNT_CD(+) = @[cntcd]" ).append("\n"); 
		query.append("AND B.ST_DT(+) = @[stdt]" ).append("\n"); 
		query.append("AND A.WK_DY_CD(+) = D.INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append("AND D.INTG_CD_ID = 'CD00131'" ).append("\n"); 
		query.append("GROUP BY" ).append("\n"); 
		query.append("A.CNT_CD" ).append("\n"); 
		query.append(", B.CNT_NM" ).append("\n"); 
		query.append(", D.INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append(", D.INTG_CD_VAL_DP_SEQ" ).append("\n"); 
		query.append(", A.HOL_PERF_YR" ).append("\n"); 
		query.append(", A.CNT_CD" ).append("\n"); 
		query.append(", A.RCC_DIV_FLG" ).append("\n"); 
		query.append(", A.IO_BND_CD" ).append("\n"); 
		query.append("ORDER BY" ).append("\n"); 
		query.append("D.INTG_CD_VAL_DP_SEQ" ).append("\n"); 
		query.append(", A.CNT_CD" ).append("\n"); 

	}
}