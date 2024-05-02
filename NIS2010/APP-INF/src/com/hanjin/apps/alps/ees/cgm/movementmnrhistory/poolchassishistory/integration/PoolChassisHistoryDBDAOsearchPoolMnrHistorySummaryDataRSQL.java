/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PoolChassisHistoryDBDAOsearchPoolMnrHistorySummaryDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.01
*@LastModifier : 최민회
*@LastVersion : 1.0
* 2010.02.01 최민회
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.movementmnrhistory.poolchassishistory.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI MIN HOI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PoolChassisHistoryDBDAOsearchPoolMnrHistorySummaryDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public PoolChassisHistoryDBDAOsearchPoolMnrHistorySummaryDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mvmt_dt_to",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mvmt_dt_fr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chss_pool_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cgm.movementmnrhistory.poolchassishistory.integration").append("\n"); 
		query.append("FileName : PoolChassisHistoryDBDAOsearchPoolMnrHistorySummaryDataRSQL").append("\n"); 
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
		query.append("SELECT  DECODE(COUNT( A.CHSS_NO),0,'0', TO_CHAR(COUNT( A.CHSS_NO),'999,999,999,000')) CHSS_CNT" ).append("\n"); 
		query.append(",DECODE(COUNT(DISTINCT A.CHSS_NO),0,'0',TO_CHAR(COUNT(DISTINCT A.CHSS_NO),'999,999,999,000')) UN_CHSS_CNT" ).append("\n"); 
		query.append(",DECODE(NVL(SUM(A.LBR_COST_AMT),0),0,'0.00' ,TO_CHAR(NVL(SUM(A.LBR_COST_AMT),0),'999,999,000.00')) CHSS_LBR" ).append("\n"); 
		query.append(",DECODE(NVL(SUM(A.LBR_COST_AMT),0),0,'0.00', TO_CHAR(NVL(SUM(A.LBR_COST_AMT),0),'999,999,000.00')) UN_CHSS_LBR" ).append("\n"); 
		query.append(",DECODE(NVL(SUM(A.TAX_AMT),0),0,'0.00', TO_CHAR(NVL(SUM(A.TAX_AMT)  ,0)  ,'999,999,000.00'))   CHSS_AMT" ).append("\n"); 
		query.append(",DECODE(NVL(SUM(A.TAX_AMT),0),0,'0.00', TO_CHAR(NVL(SUM(A.TAX_AMT) ,0) ,'999,999,000.00'))     UN_CHSS_AMT" ).append("\n"); 
		query.append(",DECODE(NVL(SUM(A.MTRL_COST_AMT),0),0,'0.00', TO_CHAR(NVL(SUM(A.MTRL_COST_AMT),0) ,'999,999,000.00'))      CHSS_MTRL" ).append("\n"); 
		query.append(",DECODE(NVL(SUM(A.MTRL_COST_AMT),0),0,'0.00', TO_CHAR(NVL(SUM(A.MTRL_COST_AMT) ,0)  ,'999,999,000.00'))    UN_CHSS_MTRL" ).append("\n"); 
		query.append(",DECODE(NVL(SUM(A.COST_TTL_AMT),0),0,'0.00', TO_CHAR(NVL(SUM(A.COST_TTL_AMT) ,0) ,'999,999,000.00'))CHSS_TTL" ).append("\n"); 
		query.append(",DECODE(NVL(SUM(A.COST_TTL_AMT),0),0,'0.00', TO_CHAR(NVL(SUM(A.COST_TTL_AMT) ,0),'999,999,000.00')) UN_CHSS_TTL" ).append("\n"); 
		query.append(",DECODE(NVL(ROUND((SUM(A.COST_TTL_AMT) / COUNT( A.CHSS_NO)) ,2),0),0,'0.00',NVL(ROUND((SUM(A.COST_TTL_AMT) / COUNT( A.CHSS_NO)) ,2),0) )  CHSS_COST" ).append("\n"); 
		query.append(",DECODE(NVL(ROUND((SUM(A.COST_TTL_AMT) / COUNT(DISTINCT A.CHSS_NO)),2) ,0),0,'0.00',NVL(ROUND((SUM(A.COST_TTL_AMT) / COUNT(DISTINCT A.CHSS_NO)),2) ,0) )UN_CHSS_COST" ).append("\n"); 
		query.append("FROM CGM_POOL_MAINT_RPR_HIS A" ).append("\n"); 
		query.append(",CGM_EQUIPMENT B" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND A.CHSS_NO  = B.EQ_NO(+)" ).append("\n"); 
		query.append("AND ( A.CHSS_POOL_CD =  @[chss_pool_cd] OR   B.CHSS_POOL_CD =  @[chss_pool_cd] )" ).append("\n"); 
		query.append("#if ( ${sort} == '0'  )" ).append("\n"); 
		query.append("AND A.INV_CRE_DT BETWEEN  TO_DATE(@[mvmt_dt_fr],'RRRR-MM' ) AND  ADD_MONTHS(TO_DATE(@[mvmt_dt_to]   ,'RRRR-MM' ),1)" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND A.RPR_RQST_DT BETWEEN  TO_DATE(@[mvmt_dt_fr],'YYYY-MM-DD' ) AND  TO_DATE(@[mvmt_dt_to],'YYYY-MM-DD' )" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}