/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : MonthlyQuotaAdjustmentTradeDBDAOSearchSaqMonQtaStepTrdLane0048ListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.26
*@LastModifier : 이상용
*@LastVersion : 1.0
* 2010.04.26 이상용
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

public class MonthlyQuotaAdjustmentTradeDBDAOSearchSaqMonQtaStepTrdLane0048ListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 첫번째 rlane_cd를 조회
	  * </pre>
	  */
	public MonthlyQuotaAdjustmentTradeDBDAOSearchSaqMonQtaStepTrdLane0048ListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bse_qtr_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("targetMonth",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : MonthlyQuotaAdjustmentTradeDBDAOSearchSaqMonQtaStepTrdLane0048ListRSQL").append("\n"); 
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
		query.append("SELECT MIN(R.RLANE_CD) RLANE_CD" ).append("\n"); 
		query.append("FROM  SAQ_MON_QTA_STEP_VER V," ).append("\n"); 
		query.append("      SAQ_MON_QTA_TRD R" ).append("\n"); 
		query.append("WHERE V.MQTA_STEP_CD = @[mQtaStepCd]" ).append("\n"); 
		query.append("AND   V.BSE_YR = @[year]" ).append("\n"); 
		query.append("AND   V.TRD_CD = @[trade]" ).append("\n"); 
		query.append("AND   V.DIR_CD = @[bound]" ).append("\n"); 
		query.append("AND   V.MQTA_VER_NO = @[mQtaVerNo]" ).append("\n"); 
		query.append("AND   R.MQTA_STEP_CD = V.MQTA_STEP_CD" ).append("\n"); 
		query.append("AND   R.BSE_YR = V.BSE_YR" ).append("\n"); 
		query.append("AND   R.TRD_CD = V.TRD_CD" ).append("\n"); 
		query.append("AND   R.DIR_CD = V.DIR_CD" ).append("\n"); 
		query.append("AND   R.MQTA_VER_NO = V.MQTA_VER_NO" ).append("\n"); 
		query.append("AND   R.BSE_QTR_CD = @[bse_qtr_cd]" ).append("\n"); 
		query.append("AND   R.BSE_MON = substr(@[targetMonth],5,7)" ).append("\n"); 

	}
}