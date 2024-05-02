/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : MonthlyQuotaCreationDBDAOSearchMonthlyQuotaModelLogList0047Tab02RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.09
*@LastModifier : 
*@LastVersion : 1.0
* 2011.03.09 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotacreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MonthlyQuotaCreationDBDAOSearchMonthlyQuotaModelLogList0047Tab02RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Engine Status 조회
	  * </pre>
	  */
	public MonthlyQuotaCreationDBDAOSearchMonthlyQuotaModelLogList0047Tab02RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("intervalTime",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotacreation.integration").append("\n"); 
		query.append("FileName : MonthlyQuotaCreationDBDAOSearchMonthlyQuotaModelLogList0047Tab02RSQL").append("\n"); 
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
		query.append("SELECT TO_CHAR(SYSDATE, 'YYYY.MM.DD HH24:MI:SS') SYS_DATE, " ).append("\n"); 
		query.append("		TO_CHAR(A.EXEC_DT, 'YYYY/MM/DD HH24:MI:SS') EXEC_DT, " ).append("\n"); 
		query.append("		A.MOD_NAME MOD_NAME, " ).append("\n"); 
		query.append("		A.LOG_DESC LOG_DESC" ).append("\n"); 
		query.append("FROM   ENIS_LOG A " ).append("\n"); 
		query.append("WHERE  1=1       " ).append("\n"); 
		query.append("AND    EXEC_DT  > SYSDATE - @[intervalTime]" ).append("\n"); 
		query.append("AND    MOD_NAME IN ( " ).append("\n"); 
		query.append("                    -- 분기 진행상태 조회 " ).append("\n"); 
		query.append("                     UPPER('SAQ_MON_PROCESS_CRE'            )                " ).append("\n"); 
		query.append("                    -- 평균단가 생성  " ).append("\n"); 
		query.append("                    ,UPPER('MAIN_SAQ_AVG_COST_CRE'          )          -- 수행시간 : 20분 " ).append("\n"); 
		query.append("                    ,UPPER('SAQ_AVG_COST_IF_CRE'            )                    " ).append("\n"); 
		query.append("                    ,UPPER('SAQ_AVG_COST_CRE'               )          -- 수행시간 : 1분 " ).append("\n"); 
		query.append("                    ,UPPER('SAQ_AVG_COST_OFC_CRE'           )          -- 수행시간 : 1 ~ 2분 " ).append("\n"); 
		query.append("                    -- RBC FORECAST I/F " ).append("\n"); 
		query.append("                    --,UPPER('SAQ_RBC_FCAST_IF_CRE'           )          -- 수행시간 : 10초 " ).append("\n"); 
		query.append("                    -- SALES FORECAST I/F " ).append("\n"); 
		query.append("                    ,UPPER('SAQ_MON_FCAST_TRNS_NEW_CRE'     )          -- 수행시간 : 6분 " ).append("\n"); 
		query.append("                    ,UPPER('SAQ_BKG_INFO_CRE_PRC'           )" ).append("\n"); 
		query.append("                    -- LOGICAL CHECK " ).append("\n"); 
		query.append("                    ,UPPER('SAQ_MON_FCAST_LOGIC_CHK'        ) " ).append("\n"); 
		query.append("                    -- RBC FORECAST 실적비용 생성 " ).append("\n"); 
		query.append("                    ,UPPER('MAIN_SAQ_MON_RBC_PA_NEW_CRE'    )          -- 수행시간 : 7분 " ).append("\n"); 
		query.append("                    -- MAS 단가 I/F (ETL) CHECK " ).append("\n"); 
		query.append("                    ,UPPER('SAQ_MON_SMU_UC_CHK'             )          -- 수행시간 : 1분 " ).append("\n"); 
		query.append("                    ,UPPER('SAQ_MON_EMU_CRE_PRC'            )" ).append("\n"); 
		query.append("                    ,UPPER('SAQ_MON_SMU_CRE_PRC'            )" ).append("\n"); 
		query.append("                    -- SALES FORECAST 실적비용 생성 " ).append("\n"); 
		query.append("                    ,UPPER('MAIN_SAQ_MON_PA_NEW_CRE'        )          -- 수행시간 : 6분 " ).append("\n"); 
		query.append("                    -- FORECAST EMU 생성 " ).append("\n"); 
		query.append("                    ,UPPER('MAIN_SAQ_MON_RA_EMU_COST_CRE'   )          -- 수행시간 : 4분 " ).append("\n"); 
		query.append("                    -- FORECAST SMU 생성 " ).append("\n"); 
		query.append("                    ,UPPER('SAQ_MON_RA_SMU_COST_CRE'        )          -- 수행시간 : 14분 " ).append("\n"); 
		query.append("                    -- T.VVD CHECK " ).append("\n"); 
		query.append("                    ,UPPER('SAQ_MON_TGT_VVD_CHK'            )          -- 수행시간 : 1분 " ).append("\n"); 
		query.append("                    -- FORECAST를 VVD 배부 및 FORECAST SUMMARY 생성 " ).append("\n"); 
		query.append("                    ,UPPER('SAQ_MON_INIT_MDL_SMRY_CRE'      )          -- 수행시간 : 2분           " ).append("\n"); 
		query.append("                    ) " ).append("\n"); 
		query.append("ORDER BY A.EXEC_DT DESC" ).append("\n"); 

	}
}