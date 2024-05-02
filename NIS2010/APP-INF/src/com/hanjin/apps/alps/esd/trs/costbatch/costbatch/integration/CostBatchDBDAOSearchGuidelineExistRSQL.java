/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : CostBatchDBDAOSearchGuidelineExistRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.18
*@LastModifier : 
*@LastVersion : 1.0
* 2012.06.18 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.costbatch.costbatch.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CostBatchDBDAOSearchGuidelineExistRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2012.06.14 변종건 [CHM-201217633] Inland Cost Batch Creation의 Confirm/Unconfirm 기능 추가
	  * </pre>
	  */
	public CostBatchDBDAOSearchGuidelineExistRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_trf_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.costbatch.costbatch.integration").append("\n"); 
		query.append("FileName : CostBatchDBDAOSearchGuidelineExistRSQL").append("\n"); 
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
		query.append("SELECT  DECODE(SIGN(SUM(CNT)),1,'Y','N') EXIST_FLG" ).append("\n"); 
		query.append("FROM    (" ).append("\n"); 
		query.append("--Inland Cost의 Guideline 존재 여부 확인 ( Count > 0 일 경우 Guideline 존재 )" ).append("\n"); 
		query.append("SELECT  COUNT(1) CNT" ).append("\n"); 
		query.append("FROM    PRI_TRF_IHC_HDR" ).append("\n"); 
		query.append("WHERE   1 = 1" ).append("\n"); 
		query.append("AND     COST_TRF_NO = @[cost_trf_no]" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("--Inland Cost의 Tariff No.가 가장 최신인지 여부 확인 ( Count > 0 일 경우 최신 Tariff NO. 아님 )" ).append("\n"); 
		query.append("SELECT  COUNT(1) CNT" ).append("\n"); 
		query.append("FROM    TRS_INLND_COST_TRF_HDR" ).append("\n"); 
		query.append("WHERE   CNT_CD    = SUBSTR(@[cost_trf_no], 1,2)" ).append("\n"); 
		query.append("AND     IO_BND_CD = SUBSTR(@[cost_trf_no], 9,1)" ).append("\n"); 
		query.append("AND     COST_TRF_NO > @[cost_trf_no]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}