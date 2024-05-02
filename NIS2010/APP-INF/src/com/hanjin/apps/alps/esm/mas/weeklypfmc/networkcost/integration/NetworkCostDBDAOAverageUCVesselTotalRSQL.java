/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : NetworkCostDBDAOAverageUCVesselTotalRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.17
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.17 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class NetworkCostDBDAOAverageUCVesselTotalRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Average U/C_Vessel Pooling1 (OP Fixed cost) 의 sheetObjects[10] -> Total 탭의 결과조회
	  * </pre>
	  */
	public NetworkCostDBDAOAverageUCVesselTotalRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_fmyearmonth",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_toyearmonth",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.integration").append("\n"); 
		query.append("FileName : NetworkCostDBDAOAverageUCVesselTotalRSQL").append("\n"); 
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
		query.append("SELECT COST_YRMON,		" ).append("\n"); 
		query.append("       DECODE(LVL,1,VSL_CD,'XXXX') AS VSL_CD,		" ).append("\n"); 
		query.append("       VSL_CLSS_CAPA,		" ).append("\n"); 
		query.append("       NVL(MAX(DECODE(LVL,1,CRE_AMT,AVG_CRE_AMT)),0) AS CRE_AMT,		" ).append("\n"); 
		query.append("       NVL(MAX(DECODE(LVL,1,INS_AMT,AVG_INS_AMT)),0) AS INS_AMT,		" ).append("\n"); 
		query.append("       NVL(MAX(DECODE(LVL,1,STO_AMT,AVG_STO_AMT)),0) AS STO_AMT,		" ).append("\n"); 
		query.append("       NVL(MAX(DECODE(LVL,1,LUB_AMT,AVG_LUB_AMT)),0) AS LUB_AMT,		" ).append("\n"); 
		query.append("       NVL(MAX(DECODE(LVL,1,MNR_AMT,AVG_MNR_AMT)),0) AS MNR_AMT,		" ).append("\n"); 
		query.append("       NVL(MAX(DECODE(LVL,1,DEP_AMT,AVG_DEP_AMT)),0) AS DEP_AMT,		" ).append("\n"); 
		query.append("       NVL(MAX(DECODE(LVL,1,TEL_AMT,AVG_TEL_AMT)),0) AS TEL_AMT,		" ).append("\n"); 
		query.append("       NVL(MAX(DECODE(LVL,1,VSL_AMT,AVG_VSL_AMT)),0) AS VSL_AMT,		" ).append("\n"); 
		query.append("       NVL(MAX(DECODE(LVL,1,OTR_AMT,AVG_OTR_AMT)),0) AS OTR_AMT,		" ).append("\n"); 
		query.append("       NVL(MAX(DECODE(LVL,1,TIM_AMT,AVG_TIM_AMT)),0) AS TIM_AMT,		" ).append("\n"); 
		query.append("       NVL(MAX(DECODE(LVL,1,TTL_AMT,AVG_TTL_AMT)),0) AS TTL_AMT		" ).append("\n"); 
		query.append("  FROM (		" ).append("\n"); 
		query.append("        SELECT COST_YRMON,		" ).append("\n"); 
		query.append("               VSL_CD,		" ).append("\n"); 
		query.append("               VSL_CLSS_CAPA, 		" ).append("\n"); 
		query.append("               CRE_AMT, --CREW EXPENSE		" ).append("\n"); 
		query.append("               AVG(DECODE(CRE_AMT,0,NULL,CRE_AMT)) OVER(PARTITION BY COST_YRMON,VSL_CLSS_CAPA) AS AVG_CRE_AMT,		" ).append("\n"); 
		query.append("               INS_AMT, --INSURANCE		" ).append("\n"); 
		query.append("               AVG(DECODE(INS_AMT,0,NULL,INS_AMT)) OVER(PARTITION BY COST_YRMON,VSL_CLSS_CAPA) AS AVG_INS_AMT,		" ).append("\n"); 
		query.append("               STO_AMT, --STORE SUPPLY EXP		" ).append("\n"); 
		query.append("               AVG(DECODE(STO_AMT,0,NULL,STO_AMT)) OVER(PARTITION BY COST_YRMON,VSL_CLSS_CAPA) AS AVG_STO_AMT,		" ).append("\n"); 
		query.append("               LUB_AMT, --LUBRICANT EXP		" ).append("\n"); 
		query.append("               AVG(DECODE(LUB_AMT,0,NULL,LUB_AMT)) OVER(PARTITION BY COST_YRMON,VSL_CLSS_CAPA) AS AVG_LUB_AMT,		" ).append("\n"); 
		query.append("               MNR_AMT, --VESSEL M&R		" ).append("\n"); 
		query.append("               AVG(DECODE(MNR_AMT,0,NULL,MNR_AMT)) OVER(PARTITION BY COST_YRMON,VSL_CLSS_CAPA) AS AVG_MNR_AMT,		" ).append("\n"); 
		query.append("               DEP_AMT, --DEPRECIATIONS		" ).append("\n"); 
		query.append("               AVG(DECODE(DEP_AMT,0,NULL,DEP_AMT)) OVER(PARTITION BY COST_YRMON,VSL_CLSS_CAPA) AS AVG_DEP_AMT,		" ).append("\n"); 
		query.append("               TEL_AMT, --TELECOM EXP		" ).append("\n"); 
		query.append("               AVG(DECODE(TEL_AMT,0,NULL,TEL_AMT)) OVER(PARTITION BY COST_YRMON,VSL_CLSS_CAPA) AS AVG_TEL_AMT,		" ).append("\n"); 
		query.append("               VSL_AMT, --VESSEL INTEREST		" ).append("\n"); 
		query.append("               AVG(DECODE(VSL_AMT,0,NULL,VSL_AMT)) OVER(PARTITION BY COST_YRMON,VSL_CLSS_CAPA) AS AVG_VSL_AMT,		" ).append("\n"); 
		query.append("               OTR_AMT, --OTHER OPERATION EXP		" ).append("\n"); 
		query.append("               AVG(DECODE(OTR_AMT,0,NULL,OTR_AMT)) OVER(PARTITION BY COST_YRMON,VSL_CLSS_CAPA) AS AVG_OTR_AMT,		" ).append("\n"); 
		query.append("               TIM_AMT, --TIME CHARTERAGE		" ).append("\n"); 
		query.append("               AVG(DECODE(TIM_AMT,0,NULL,TIM_AMT)) OVER(PARTITION BY COST_YRMON,VSL_CLSS_CAPA) AS AVG_TIM_AMT,		" ).append("\n"); 
		query.append("               TTL_AMT,		" ).append("\n"); 
		query.append("               AVG(DECODE(TTL_AMT,0,NULL,TTL_AMT)) OVER(PARTITION BY COST_YRMON,VSL_CLSS_CAPA) AS AVG_TTL_AMT,		" ).append("\n"); 
		query.append("               LVL		" ).append("\n"); 
		query.append("          FROM (		" ).append("\n"); 
		query.append("                SELECT 		" ).append("\n"); 
		query.append("                       COST_YRMON,		" ).append("\n"); 
		query.append("                       VSL_CD,		" ).append("\n"); 
		query.append("                       VSL_CLSS_CAPA, 		" ).append("\n"); 
		query.append("                       NVL(SUM(CRE_AMT),0) AS CRE_AMT, --CREW EXPENSE		" ).append("\n"); 
		query.append("                       NVL(SUM(INS_AMT),0) AS INS_AMT, --INSURANCE		" ).append("\n"); 
		query.append("                       NVL(SUM(STO_AMT),0) AS STO_AMT, --STORE SUPPLY EXP		" ).append("\n"); 
		query.append("                       NVL(SUM(LUB_AMT),0) AS LUB_AMT, --LUBRICANT EXP		" ).append("\n"); 
		query.append("                       NVL(SUM(MNR_AMT),0) AS MNR_AMT, --VESSEL M&R		" ).append("\n"); 
		query.append("                       NVL(SUM(DEP_AMT),0) AS DEP_AMT, --DEPRECIATIONS		" ).append("\n"); 
		query.append("                       NVL(SUM(TEL_AMT),0) AS TEL_AMT, --TELECOM EXP		" ).append("\n"); 
		query.append("                       NVL(SUM(VSL_AMT),0) AS VSL_AMT, --VESSEL INTEREST		" ).append("\n"); 
		query.append("                       NVL(SUM(OTR_AMT),0) AS OTR_AMT, --OTHER OPERATION EXP		" ).append("\n"); 
		query.append("                       NVL(SUM(TIM_AMT),0) AS TIM_AMT,  --TIME CHARTERAGE		" ).append("\n"); 
		query.append("                       NVL(SUM(cre_amt),0) + NVL(SUM(ins_amt),0) +		" ).append("\n"); 
		query.append("                       NVL(SUM(sto_amt),0) + NVL(SUM(lub_amt),0) +		" ).append("\n"); 
		query.append("                       NVL(SUM(MNR_AMT),0) + NVL(SUM(dep_amt),0) +		" ).append("\n"); 
		query.append("                       NVL(SUM(tel_amt),0) + NVL(SUM(vsl_amt),0) +		" ).append("\n"); 
		query.append("                       NVL(SUM(otr_amt),0) + NVL(SUM(TIM_AMT),0) AS TTL_AMT,                       		" ).append("\n"); 
		query.append("                       1 AS FLG1		" ).append("\n"); 
		query.append("                  FROM (		" ).append("\n"); 
		query.append("                        SELECT		" ).append("\n"); 
		query.append("                              COST_YRMON,		" ).append("\n"); 
		query.append("                		      VSL_CD," ).append("\n"); 
		query.append("                              VSL_CLSS_CAPA, 		" ).append("\n"); 
		query.append("                              DECODE(STND_COST_CD,'54100000',DHIR_AMT,0) AS CRE_AMT, --CREW EXPENSE		" ).append("\n"); 
		query.append("                              DECODE(STND_COST_CD,'54250000',DHIR_AMT,0) AS INS_AMT, --INSURANCE		" ).append("\n"); 
		query.append("                              DECODE(STND_COST_CD,'54200000',DHIR_AMT,0) AS STO_AMT, --STORE SUPPLY EXP		" ).append("\n"); 
		query.append("                              DECODE(STND_COST_CD,'54300000',DHIR_AMT,0) AS LUB_AMT, --LUBRICANT EXP		" ).append("\n"); 
		query.append("                              DECODE(STND_COST_CD,'54150000',DHIR_AMT,0) AS MNR_AMT, --VESSEL M&R		" ).append("\n"); 
		query.append("                              DECODE(STND_COST_CD,'54450000',DHIR_AMT,0) AS DEP_AMT, --DEPRECIATIONS		" ).append("\n"); 
		query.append("                              DECODE(STND_COST_CD,'54180000',DHIR_AMT,0) AS TEL_AMT, --TELECOM EXP		" ).append("\n"); 
		query.append("                              DECODE(STND_COST_CD,'72100000',DHIR_AMT,0) AS VSL_AMT, --VESSEL INTEREST		" ).append("\n"); 
		query.append("                              DECODE(STND_COST_CD,'54550000',DHIR_AMT,0) AS OTR_AMT, --OTHER OPERATION EXP		" ).append("\n"); 
		query.append("                              DECODE(STND_COST_CD,'54350000',DHIR_AMT,0) AS TIM_AMT  --TIME CHARTERAGE		" ).append("\n"); 
		query.append("                          FROM MAS_POOL_VSL_DLY_HIR		" ).append("\n"); 
		query.append("                         WHERE COST_YRMON BETWEEN @[f_fmyearmonth] AND @[f_toyearmonth] -- 변수 처리		" ).append("\n"); 
		query.append("                           AND VSL_CD     != 'XXXX'		" ).append("\n"); 
		query.append("                   	   )	" ).append("\n"); 
		query.append("                 GROUP BY COST_YRMON,VSL_CD,VSL_CLSS_CAPA		" ).append("\n"); 
		query.append("               ) A,		" ).append("\n"); 
		query.append("               (SELECT ROWNUM LVL, 1 AS FLG2 FROM MAS_POOL_VSL_DLY_HIR WHERE ROWNUM < 3) B		" ).append("\n"); 
		query.append("         WHERE A.FLG1 = B.FLG2		" ).append("\n"); 
		query.append("       )		" ).append("\n"); 
		query.append(" GROUP BY COST_YRMON,		" ).append("\n"); 
		query.append("       DECODE(LVL,1,VSL_CD,'XXXX'),		" ).append("\n"); 
		query.append("       VSL_CLSS_CAPA,		" ).append("\n"); 
		query.append("       LVL		" ).append("\n"); 
		query.append(" ORDER BY COST_YRMON,		" ).append("\n"); 
		query.append("       VSL_CLSS_CAPA,		" ).append("\n"); 
		query.append("       DECODE(LVL,1,VSL_CD,'XXXX')" ).append("\n"); 

	}
}