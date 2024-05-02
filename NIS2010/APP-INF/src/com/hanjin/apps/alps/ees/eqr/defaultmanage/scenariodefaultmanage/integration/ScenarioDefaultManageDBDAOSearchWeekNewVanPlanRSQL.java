/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ScenarioDefaultManageDBDAOSearchWeekNewVanPlanRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.04
*@LastModifier : 정은호
*@LastVersion : 1.0
* 2009.08.04 정은호
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

public class ScenarioDefaultManageDBDAOSearchWeekNewVanPlanRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EQR_NEW_VAN_LONG_TERM  테이블 조회 (Week단위)
	  * </pre>
	  */
	public ScenarioDefaultManageDBDAOSearchWeekNewVanPlanRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("leaseterm",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.integration").append("\n"); 
		query.append("FileName : ScenarioDefaultManageDBDAOSearchWeekNewVanPlanRSQL").append("\n"); 
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
		query.append("A.CO_CD" ).append("\n"); 
		query.append(",A.RCC_CD" ).append("\n"); 
		query.append(",A.ECC_CD" ).append("\n"); 
		query.append(",A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",A.CNTR_LSTM_CD" ).append("\n"); 
		query.append(",A.VNDR_ABBR_NM" ).append("\n"); 
		query.append(",A.VNDR_CNT_CD||A.VNDR_SEQ" ).append("\n"); 
		query.append("--,A.CNTR_VOL_QTY" ).append("\n"); 
		query.append(",B.NAME" ).append("\n"); 
		query.append("#foreach(${key} IN ${weekArr})" ).append("\n"); 
		query.append(",SUM(DECODE(A.WEEK, '$key', DECODE(A.CNTR_DE_STS_CD, B.CODE, A.CNTR_VOL_QTY))) QTY$key" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(",A.VNDR_CNT_CD	  ## HIDDEN" ).append("\n"); 
		query.append(",A.VNDR_SEQ	      ## HIDDEN" ).append("\n"); 
		query.append(",B.CODE" ).append("\n"); 
		query.append(",B.NUM" ).append("\n"); 
		query.append("#foreach(${key} IN ${weekArr})" ).append("\n"); 
		query.append(",'F' FLAG$key" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("A.PLN_YRMON WEEK," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("##if(${company} == '')" ).append("\n"); 
		query.append("##    'Both' CO_CD," ).append("\n"); 
		query.append("##else" ).append("\n"); 
		query.append("A.CO_CD," ).append("\n"); 
		query.append("##end" ).append("\n"); 
		query.append("A.CNTR_LSTM_CD," ).append("\n"); 
		query.append("A.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("C.RCC_CD," ).append("\n"); 
		query.append("A.ECC_CD," ).append("\n"); 
		query.append("A.VNDR_ABBR_NM," ).append("\n"); 
		query.append("A.VNDR_CNT_CD," ).append("\n"); 
		query.append("A.VNDR_SEQ," ).append("\n"); 
		query.append("A.CNTR_DE_STS_CD," ).append("\n"); 
		query.append("A.CNTR_VOL_QTY" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("EQR_NEW_VAN_LONG_TERM A," ).append("\n"); 
		query.append("EQR_ECC_MST C" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("SUBSTR(A.PLN_YRMON, 0, 4) = @[year]" ).append("\n"); 
		query.append("AND   A.ECC_CD = C.ECC_CD" ).append("\n"); 
		query.append(") A," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("INTG_CD_VAL_CTNT    CODE," ).append("\n"); 
		query.append("INTG_CD_VAL_DP_DESC NAME," ).append("\n"); 
		query.append("ROWNUM NUM" ).append("\n"); 
		query.append("FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND   INTG_CD_ID = 'CD00288'" ).append("\n"); 
		query.append("ORDER BY INTG_CD_VAL_DP_SEQ" ).append("\n"); 
		query.append(") B" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${status} != '')" ).append("\n"); 
		query.append("##String[] eccArr  = eccWhereCondition.split(\",\");" ).append("\n"); 
		query.append("AND A.ECC_CD IN (" ).append("\n"); 
		query.append("#foreach($key IN ${eccArr})" ).append("\n"); 
		query.append("#if($velocityCount < $eccArr.size())" ).append("\n"); 
		query.append("'$key'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$key'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end   ## loc 검색조건" ).append("\n"); 
		query.append("## TP/SZ 에 따른 조건값을 넣어 준다." ).append("\n"); 
		query.append("#if(${tpsztype} != '')" ).append("\n"); 
		query.append("##String[] perfix1 = tpsztype.split(\",\");" ).append("\n"); 
		query.append("AND A.CNTR_TPSZ_CD IN (" ).append("\n"); 
		query.append("#foreach($key IN ${perfix1})" ).append("\n"); 
		query.append("#if($velocityCount < $perfix1.size())" ).append("\n"); 
		query.append("'$key'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$key'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end  ## type size 검색조건" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("##if(${company} != '')  			 ## company  검색조건" ).append("\n"); 
		query.append("##    AND   A.CO_CD = --@ [company]" ).append("\n"); 
		query.append("##end" ).append("\n"); 
		query.append("#if(${leaseterm} != '')  ## lease term 검색조건" ).append("\n"); 
		query.append("AND   A.CNTR_LSTM_CD = @[leaseterm]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("GROUP BY" ).append("\n"); 
		query.append("A.CO_CD" ).append("\n"); 
		query.append(",A.CNTR_LSTM_CD" ).append("\n"); 
		query.append(",A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",A.RCC_CD" ).append("\n"); 
		query.append(",A.ECC_CD" ).append("\n"); 
		query.append(",A.VNDR_ABBR_NM" ).append("\n"); 
		query.append(",A.VNDR_CNT_CD" ).append("\n"); 
		query.append(",A.VNDR_CNT_CD||A.VNDR_SEQ" ).append("\n"); 
		query.append(",B.NAME" ).append("\n"); 
		query.append(",A.VNDR_SEQ" ).append("\n"); 
		query.append(",B.NUM" ).append("\n"); 
		query.append(",B.CODE" ).append("\n"); 
		query.append("ORDER BY 1,2,3,4,5,6,7,B.NUM" ).append("\n"); 

	}
}