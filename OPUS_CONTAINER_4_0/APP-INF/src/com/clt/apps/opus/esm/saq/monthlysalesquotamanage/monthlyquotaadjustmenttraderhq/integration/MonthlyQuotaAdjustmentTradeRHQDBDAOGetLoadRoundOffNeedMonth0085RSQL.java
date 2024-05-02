/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : MonthlyQuotaAdjustmentTradeRHQDBDAOGetLoadRoundOffNeedMonth0085RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.26
*@LastModifier : 이상용
*@LastVersion : 1.0
* 2010.04.26 이상용
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmenttraderhq.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author SangYong Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MonthlyQuotaAdjustmentTradeRHQDBDAOGetLoadRoundOffNeedMonth0085RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Load에 소수점 이하 자리 존재여부, 소수점이하 자리수가 있는 월을 String으로 리턴.
	  * </pre>
	  */
	public MonthlyQuotaAdjustmentTradeRHQDBDAOGetLoadRoundOffNeedMonth0085RSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmenttraderhq.integration").append("\n"); 
		query.append("FileName : MonthlyQuotaAdjustmentTradeRHQDBDAOGetLoadRoundOffNeedMonth0085RSQL").append("\n"); 
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
		query.append("SELECT TO_CHAR(TO_DATE(BSE_MON, 'MM'), 'MON', 'NLS_DATE_LANGUAGE=AMERICAN') AS MON" ).append("\n"); 
		query.append("FROM SAQ_MON_QTA_TRD" ).append("\n"); 
		query.append("WHERE MQTA_STEP_CD = @[mQtaStepCd]" ).append("\n"); 
		query.append("AND   BSE_YR = @[year]" ).append("\n"); 
		query.append("AND   BSE_QTR_CD = @[bse_quarter]" ).append("\n"); 
		query.append("AND   TRD_CD = @[trade]" ).append("\n"); 
		query.append("AND   DIR_CD = @[bound]" ).append("\n"); 
		query.append("AND   MQTA_VER_NO = @[mQtaVerNo]" ).append("\n"); 
		query.append("AND   ROUND(LOD_QTY)-LOD_QTY <> 0" ).append("\n"); 
		query.append("GROUP BY BSE_MON" ).append("\n"); 
		query.append("ORDER BY BSE_MON" ).append("\n"); 

	}
}