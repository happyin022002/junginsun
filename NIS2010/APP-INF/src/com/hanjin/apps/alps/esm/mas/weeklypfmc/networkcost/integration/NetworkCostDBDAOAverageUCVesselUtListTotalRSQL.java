/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : NetworkCostDBDAOAverageUCVesselUtListTotalRSQL.java
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

public class NetworkCostDBDAOAverageUCVesselUtListTotalRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Average U/C_Vessel Pooling2 (OP Fixed & Variable cost, etc) 의 'Cost Tatal' 탭의 결과를 조회한다.
	  * </pre>
	  */
	public NetworkCostDBDAOAverageUCVesselUtListTotalRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_yearweek",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.integration").append("\n"); 
		query.append("FileName : NetworkCostDBDAOAverageUCVesselUtListTotalRSQL").append("\n"); 
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
		query.append("SELECT 							" ).append("\n"); 
		query.append("    COST_YRMON," ).append("\n"); 
		query.append("    TRD_CD," ).append("\n"); 
		query.append("    SUB_TRD_CD," ).append("\n"); 
		query.append("    RLANE_CD," ).append("\n"); 
		query.append("    DIR_CD," ).append("\n"); 
		query.append("    HUL_BND_CD," ).append("\n"); 
		query.append("    NVL(SUM(CRE_AMT),0) AS CRE_AMT, --CREW EXPENSE" ).append("\n"); 
		query.append("    NVL(SUM(INS_AMT),0) AS INS_AMT, --INSURANCE" ).append("\n"); 
		query.append("    NVL(SUM(STO_AMT),0) AS STO_AMT, --STORE SUPPLY EXP" ).append("\n"); 
		query.append("    NVL(SUM(LUB_AMT),0) AS LUB_AMT, --LUBRICANT EXP" ).append("\n"); 
		query.append("    NVL(SUM(MNR_AMT),0) AS MNR_AMT, --VESSEL M&R							" ).append("\n"); 
		query.append("    NVL(SUM(DEP_AMT),0) AS DEP_AMT, --DEPRECIATIONS							" ).append("\n"); 
		query.append("    NVL(SUM(TEL_AMT),0) AS TEL_AMT, --TELECOM EXP							" ).append("\n"); 
		query.append("    NVL(SUM(VSL_AMT),0) AS VSL_AMT, --VESSEL INTEREST							" ).append("\n"); 
		query.append("    NVL(SUM(OTR_AMT),0) AS OTR_AMT, --OTHER OPERATION EXP							" ).append("\n"); 
		query.append("    NVL(SUM(TIM_AMT),0) AS TIM_AMT,  --TIME CHARTERAGE							" ).append("\n"); 
		query.append("    NVL(SUM(POR_AMT),0) AS POR_AMT, --Port Expense							" ).append("\n"); 
		query.append("    NVL(SUM(CAN_AMT),0) AS CAN_AMT, --Canal Transit Fee							" ).append("\n"); 
		query.append("    NVL(SUM(BNK_AMT),0) AS BNK_AMT, --Bunker							" ).append("\n"); 
		query.append("    NVL(SUM(SPC_AMT),0) AS SPC_AMT, --Space Charterage                       							" ).append("\n"); 
		query.append("                                " ).append("\n"); 
		query.append("    NVL(SUM(cre_amt),0) + NVL(SUM(ins_amt),0) +							" ).append("\n"); 
		query.append("    NVL(SUM(sto_amt),0) + NVL(SUM(lub_amt),0) +							" ).append("\n"); 
		query.append("    NVL(SUM(MNR_AMT),0) + NVL(SUM(dep_amt),0) +							" ).append("\n"); 
		query.append("    NVL(SUM(tel_amt),0) + NVL(SUM(vsl_amt),0) +							" ).append("\n"); 
		query.append("    NVL(SUM(otr_amt),0) + NVL(SUM(TIM_AMT),0) +							" ).append("\n"); 
		query.append("    NVL(SUM(POR_AMT),0) + NVL(SUM(CAN_AMT),0) +							" ).append("\n"); 
		query.append("    NVL(SUM(BNK_AMT),0) + NVL(SUM(SPC_AMT),0) AS TTL_AMT,  							" ).append("\n"); 
		query.append("                            " ).append("\n"); 
		query.append("    NVL(SUM(SPR_AMT),0) AS SPR_AMT  --Space Charter Revenue							" ).append("\n"); 
		query.append("                            " ).append("\n"); 
		query.append("FROM (							" ).append("\n"); 
		query.append("    SELECT							" ).append("\n"); 
		query.append("          COST_YRMON,							" ).append("\n"); 
		query.append("          TRD_CD,					" ).append("\n"); 
		query.append("          SUB_TRD_CD,					" ).append("\n"); 
		query.append("          RLANE_CD,					" ).append("\n"); 
		query.append("          DIR_CD,					" ).append("\n"); 
		query.append("          HUL_BND_CD,					" ).append("\n"); 
		query.append("          DECODE(STND_COST_CD,'54100000',TEU_UC_AMT,0) AS CRE_AMT, --CREW EXPENSE							" ).append("\n"); 
		query.append("          DECODE(STND_COST_CD,'54250000',TEU_UC_AMT,0) AS INS_AMT, --INSURANCE							" ).append("\n"); 
		query.append("          DECODE(STND_COST_CD,'54200000',TEU_UC_AMT,0) AS STO_AMT, --STORE SUPPLY EXP							" ).append("\n"); 
		query.append("          DECODE(STND_COST_CD,'54300000',TEU_UC_AMT,0) AS LUB_AMT, --LUBRICANT EXP" ).append("\n"); 
		query.append("          DECODE(STND_COST_CD,'54150000',TEU_UC_AMT,0) AS MNR_AMT, --VESSEL M&R" ).append("\n"); 
		query.append("          DECODE(STND_COST_CD,'54450000',TEU_UC_AMT,0) AS DEP_AMT, --DEPRECIATIONS" ).append("\n"); 
		query.append("          DECODE(STND_COST_CD,'54180000',TEU_UC_AMT,0) AS TEL_AMT, --TELECOM EXP" ).append("\n"); 
		query.append("          DECODE(STND_COST_CD,'72100000',TEU_UC_AMT,0) AS VSL_AMT, --VESSEL INTEREST" ).append("\n"); 
		query.append("          DECODE(STND_COST_CD,'54550000',TEU_UC_AMT,0) AS OTR_AMT, --OTHER OPERATION EXP" ).append("\n"); 
		query.append("          DECODE(STND_COST_CD,'54350000',TEU_UC_AMT,0) AS TIM_AMT, --TIME CHARTERAGE" ).append("\n"); 
		query.append("          " ).append("\n"); 
		query.append("          DECODE(STND_COST_CD,'53101000',TEU_UC_AMT,0) AS POR_AMT, --Port Expense" ).append("\n"); 
		query.append("          DECODE(STND_COST_CD,'53102000',TEU_UC_AMT,0) AS CAN_AMT, --Canal Transit Fee" ).append("\n"); 
		query.append("          DECODE(STND_COST_CD,'53200000',TEU_UC_AMT,0) AS BNK_AMT, --Bunker" ).append("\n"); 
		query.append("          DECODE(STND_COST_CD,'54400000',TEU_UC_AMT,0) AS SPC_AMT, --Space Charterage" ).append("\n"); 
		query.append("          DECODE(STND_COST_CD,'43102011',TEU_UC_AMT,0) AS SPR_AMT  --Space Charter Revenue" ).append("\n"); 
		query.append("          " ).append("\n"); 
		query.append("     FROM MAS_POOL_UT_COST" ).append("\n"); 
		query.append("     WHERE COST_YRMON = REPLACE(@[f_yearweek], '-', '')" ).append("\n"); 
		query.append("     )" ).append("\n"); 
		query.append("GROUP BY COST_YRMON," ).append("\n"); 
		query.append("         TRD_CD," ).append("\n"); 
		query.append("         SUB_TRD_CD," ).append("\n"); 
		query.append("         RLANE_CD," ).append("\n"); 
		query.append("         DIR_CD," ).append("\n"); 
		query.append("         HUL_BND_CD" ).append("\n"); 
		query.append("ORDER BY COST_YRMON," ).append("\n"); 
		query.append("         TRD_CD," ).append("\n"); 
		query.append("         SUB_TRD_CD," ).append("\n"); 
		query.append("         RLANE_CD," ).append("\n"); 
		query.append("         DIR_CD," ).append("\n"); 
		query.append("         HUL_BND_CD" ).append("\n"); 

	}
}