/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : MonthlyQuotaAdjustmentTradeDBDAOGetListByLoadZero0048RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.27
*@LastModifier : 이상용
*@LastVersion : 1.0
* 2010.04.27 이상용
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmenttrade.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author SangYong Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MonthlyQuotaAdjustmentTradeDBDAOGetListByLoadZero0048RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * trd_cd, dir_cd, mqta_ver_no의 조회키별 Load 합이 0인 월을 체크하여 문자열로 리턴.
	  * </pre>
	  */
	public MonthlyQuotaAdjustmentTradeDBDAOGetListByLoadZero0048RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bse_quarter",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trade",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mQtaStepCd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bound",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mQtaVerNo",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmenttrade.integration").append("\n"); 
		query.append("FileName : MonthlyQuotaAdjustmentTradeDBDAOGetListByLoadZero0048RSQL").append("\n"); 
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
		query.append("SELECT TO_CHAR(TO_DATE(BSE_MON, 'MM'), 'MON', 'NLS_DATE_LANGUAGE=AMERICAN')" ).append("\n"); 
		query.append("       ||' / '||RLANE_CD||'-'||SPRT_GRP_CD||'-'||BSA_GRP_CD" ).append("\n"); 
		query.append("       ||' / '||CTRT_RHQ_CD  AS MSG," ).append("\n"); 
		query.append("       SUB_TRD_CD" ).append("\n"); 
		query.append("FROM SAQ_MON_QTA_TRD" ).append("\n"); 
		query.append("WHERE MQTA_STEP_CD = @[mQtaStepCd]" ).append("\n"); 
		query.append("AND   BSE_YR = @[year]" ).append("\n"); 
		query.append("AND   BSE_QTR_CD = @[bse_quarter]" ).append("\n"); 
		query.append("AND   TRD_CD = @[trade]" ).append("\n"); 
		query.append("AND   DIR_CD = @[bound]" ).append("\n"); 
		query.append("AND   MQTA_VER_NO = @[mQtaVerNo]" ).append("\n"); 
		query.append("GROUP BY BSE_MON, SUB_TRD_CD, RLANE_CD, SPRT_GRP_CD, BSA_GRP_CD, CTRT_RHQ_CD" ).append("\n"); 
		query.append("HAVING SUM(LOD_QTY) = 0" ).append("\n"); 
		query.append("ORDER BY BSE_MON, SUB_TRD_CD,DECODE(RLANE_CD,'RBCCO','ZZ',SUBSTR(RLANE_CD,-2)),RLANE_CD, MSG" ).append("\n"); 

	}
}