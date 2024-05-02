/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : NetworkCostDBDAOAvgHireOwnVslRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.18
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.18 
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

public class NetworkCostDBDAOAvgHireOwnVslRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AVG-hire by Own-VSL (PA) 을 조회한다
	  * 2015.04.01 김시몬 week 제거하여 보여지도록 변경
	  * </pre>
	  */
	public NetworkCostDBDAOAvgHireOwnVslRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_selvessel",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tab_item",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.integration").append("\n"); 
		query.append("FileName : NetworkCostDBDAOAvgHireOwnVslRSQL").append("\n"); 
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
		query.append("#if (${tab_item} != '')" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("       SUBSTR(COST_YRMON,1,4)||'-'||SUBSTR(COST_YRMON,5,2) AS COST_YRMON," ).append("\n"); 
		query.append("#if (${f_yrtype} == 'yrwk')" ).append("\n"); 
		query.append("       COST_WK," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("       '00'   AS  COST_WK," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("       VSL_CD," ).append("\n"); 
		query.append("       VSL_CLSS_CAPA," ).append("\n"); 
		query.append("       STND_COST_CD, -- HIDDEN      " ).append("\n"); 
		query.append("       EFF_FM_YRMON, -- COST PERIOD" ).append("\n"); 
		query.append("       --EFF_TO_YRMON, -- COST PERIOD" ).append("\n"); 
		query.append("	   EFF_FM_YRMON||' ~ '||EFF_TO_YRMON AS EFF_FM_TO_YRMON," ).append("\n"); 
		query.append("       VSL_AMT,      -- VSL COST" ).append("\n"); 
		query.append("       COM_DTRB_AMT, -- COMMON COST" ).append("\n"); 
		query.append("       TTL_COST,     -- TTL COST" ).append("\n"); 
		query.append("       DHIR_BFR_AMT AS HB_COST, -- Monthly Hire" ).append("\n"); 
		query.append("       DHIR_ADD_AMT AS ADDHB_COST, -- COST ADD HIRE + MODIFICATION" ).append("\n"); 
		query.append("       DHIR_AMT,     -- COST ADD HIRE + Monthly Hire" ).append("\n"); 
		query.append("	   FIN_COST," ).append("\n"); 
		query.append("       OWN_VSL_RMK" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT" ).append("\n"); 
		query.append("               DISTINCT D2.COST_YRMON                             COST_YRMON," ).append("\n"); 
		query.append("		#if (${f_yrtype} == 'yrwk')" ).append("\n"); 
		query.append("               D2.COST_WK                                          COST_WK," ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("               D2.VSL_CD                                           VSL_CD," ).append("\n"); 
		query.append("               D2.VSL_CLSS_CAPA                                    VSL_CLSS_CAPA," ).append("\n"); 
		query.append("               " ).append("\n"); 
		query.append("               D1.STND_COST_CD, -- HIDDEN      " ).append("\n"); 
		query.append("               D1.EFF_FM_YRMON, -- COST PERIOD" ).append("\n"); 
		query.append("               D1.EFF_TO_YRMON, -- COST PERIOD" ).append("\n"); 
		query.append("               D1.VSL_AMT,      -- VSL COST" ).append("\n"); 
		query.append("               D1.COM_DTRB_AMT, -- COMMON COST" ).append("\n"); 
		query.append("               D1.VSL_AMT + D1.COM_DTRB_AMT AS TTL_COST, -- TTL COST" ).append("\n"); 
		query.append("               D1.DHIR_BFR_AMT, -- Monthly Hire" ).append("\n"); 
		query.append("               D1.DHIR_ADD_AMT, -- COST ADD HIRE + MODIFICATION" ).append("\n"); 
		query.append("               D1.DHIR_AMT  AS FIN_COST, -- FINAL COST --D1.VSL_AMT + D1.COM_DTRB_AMT + D1.CORR_AMT AS FIN_COST," ).append("\n"); 
		query.append("               D1.DHIR_AMT,     -- Cost / Day" ).append("\n"); 
		query.append("               DECODE(D1.VSL_CLSS_CAPA, '', 'AVG', D1.OWN_VSL_RMK) OWN_VSL_RMK" ).append("\n"); 
		query.append("          FROM MAS_OWN_VSL_DLY_HIR D1," ).append("\n"); 
		query.append("               (" ).append("\n"); 
		query.append("                SELECT DISTINCT" ).append("\n"); 
		query.append("                #if (${f_yrtype} == 'yrwk')" ).append("\n"); 
		query.append("                       B1.COST_YRMON  AS COST_YRMON," ).append("\n"); 
		query.append("                       B1.COST_WK    AS COST_WK,  " ).append("\n"); 
		query.append("				#else" ).append("\n"); 
		query.append("                       B1.COST_YRMON AS COST_YRMON, " ).append("\n"); 
		query.append("                       '00'          AS COST_WK,  " ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("                       B1.VSL_CD,      " ).append("\n"); 
		query.append("                       B2.VSL_CLSS_CAPA" ).append("\n"); 
		query.append("                  FROM MAS_MON_VVD B1," ).append("\n"); 
		query.append("                       (SELECT A1.VSL_SEQ," ).append("\n"); 
		query.append("                               A1.VSL_CD," ).append("\n"); 
		query.append("                               A1.VSL_TP_CD," ).append("\n"); 
		query.append("                               A1.VSL_OSHP_CD," ).append("\n"); 
		query.append("                               A1.VOP_CD," ).append("\n"); 
		query.append("                               A1.PORT_CLSS_CAPA," ).append("\n"); 
		query.append("                               A1.VSL_CLSS_CAPA," ).append("\n"); 
		query.append("    						   NVL(A1.VSL_APLY_FM_DT, A1.VSL_RETN_FM_DT)  AS FM_DT,			" ).append("\n"); 
		query.append("                      		   NVL(A1.VSL_APLY_TO_DT , A1.VSL_RETN_TO_DT) AS TO_DT " ).append("\n"); 
		query.append("                          FROM MAS_VSL_RGST A1" ).append("\n"); 
		query.append("                         WHERE 1 = 1" ).append("\n"); 
		query.append("                           AND NVL(A1.DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("                       ) B2" ).append("\n"); 
		query.append("                 WHERE B1.VSL_CD = B2.VSL_CD" ).append("\n"); 
		query.append("               #if (${f_yrtype} == 'yrwk')" ).append("\n"); 
		query.append("                   AND B1.COST_YRMON LIKE SUBSTR(@[f_yearweek],1,4)||'%'" ).append("\n"); 
		query.append("				   AND B1.COST_WK = SUBSTR(@[f_yearweek],5,2)" ).append("\n"); 
		query.append("               #else" ).append("\n"); 
		query.append("				   AND B1.COST_YRMON = SUBSTR(@[f_yearweek],1,6)" ).append("\n"); 
		query.append("               #end" ).append("\n"); 
		query.append("                   AND B1.DELT_FLG            <> 'Y'" ).append("\n"); 
		query.append("                   AND B2.VSL_TP_CD           = 'C'" ).append("\n"); 
		query.append("                   AND B2.VSL_OSHP_CD         = 'OWN'" ).append("\n"); 
		query.append("                   AND B2.VOP_CD              = 'SML'" ).append("\n"); 
		query.append("                   AND TO_CHAR(B1.N1ST_LODG_PORT_ETD_DT, 'YYYYMMDD')" ).append("\n"); 
		query.append("                               BETWEEN NVL(TO_CHAR(B2.FM_DT, 'YYYYMMDD'), '19000101')" ).append("\n"); 
		query.append("                               AND     NVL(TO_CHAR(B2.TO_DT, 'YYYYMMDD'), '99991231')" ).append("\n"); 
		query.append("                   AND B2.VSL_CD = NVL(@[f_selvessel], B2.VSL_CD)" ).append("\n"); 
		query.append("				   AND B1.SUB_TRD_CD <> 'IP'" ).append("\n"); 
		query.append("               ) D2" ).append("\n"); 
		query.append("         WHERE 1 = 1" ).append("\n"); 
		query.append("           AND D2.COST_YRMON    = D1.COST_YRMON(+)" ).append("\n"); 
		query.append("           AND D2.VSL_CD        = D1.VSL_CD(+)" ).append("\n"); 
		query.append("           AND D2.VSL_CLSS_CAPA = D1.VSL_CLSS_CAPA(+)" ).append("\n"); 
		query.append("           AND D1.COST_WK(+)    = '00'" ).append("\n"); 
		query.append("       	 )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" WHERE STND_COST_CD = @[tab_item]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("       COST_YRMON," ).append("\n"); 
		query.append("       VSL_CD," ).append("\n"); 
		query.append("       VSL_CLSS_CAPA, " ).append("\n"); 
		query.append("       NVL(SUM(cre_amt),0) AS cre_amt, --Crew Expense" ).append("\n"); 
		query.append("       NVL(SUM(ins_amt),0) AS ins_amt, --Insurance" ).append("\n"); 
		query.append("       NVL(SUM(sto_amt),0) AS sto_amt, --Store supply Exp" ).append("\n"); 
		query.append("       NVL(SUM(lub_amt),0) AS lub_amt, --Lubricant Exp" ).append("\n"); 
		query.append("       NVL(SUM(mnr_amt),0) AS mnr_amt, --Vessel M&R" ).append("\n"); 
		query.append("       NVL(SUM(dep_amt),0) AS dep_amt, --Depreciations" ).append("\n"); 
		query.append("       NVL(SUM(tel_amt),0) AS tel_amt, --Telecom Exp" ).append("\n"); 
		query.append("       NVL(SUM(vsl_amt),0) AS vsl_amt, --Vessel Interest" ).append("\n"); 
		query.append("       NVL(SUM(otr_amt),0) AS otr_amt, --Other Operation Exp" ).append("\n"); 
		query.append("       NVL(SUM(cre_amt),0) +" ).append("\n"); 
		query.append("       NVL(SUM(ins_amt),0) +" ).append("\n"); 
		query.append("       NVL(SUM(sto_amt),0) +" ).append("\n"); 
		query.append("       NVL(SUM(lub_amt),0) +" ).append("\n"); 
		query.append("       NVL(SUM(mnr_amt),0) +" ).append("\n"); 
		query.append("       NVL(SUM(dep_amt),0) +" ).append("\n"); 
		query.append("       NVL(SUM(tel_amt),0) +" ).append("\n"); 
		query.append("       NVL(SUM(vsl_amt),0) +" ).append("\n"); 
		query.append("       NVL(SUM(otr_amt),0) AS TTL_AMT" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT" ).append("\n"); 
		query.append("               SUBSTR(COST_YRMON,1,4)||'-'||SUBSTR(COST_YRMON,5,2) AS COST_YRMON," ).append("\n"); 
		query.append("               VSL_CD," ).append("\n"); 
		query.append("               VSL_CLSS_CAPA," ).append("\n"); 
		query.append("               DECODE(STND_COST_CD,'54100000',DHIR_AMT,0) AS cre_amt, --Crew Expense" ).append("\n"); 
		query.append("               DECODE(STND_COST_CD,'54250000',DHIR_AMT,0) AS ins_amt, --Insurance" ).append("\n"); 
		query.append("               DECODE(STND_COST_CD,'54200000',DHIR_AMT,0) AS sto_amt, --Store supply Exp" ).append("\n"); 
		query.append("               DECODE(STND_COST_CD,'54300000',DHIR_AMT,0) AS lub_amt, --Lubricant Exp" ).append("\n"); 
		query.append("               DECODE(STND_COST_CD,'54150000',DHIR_AMT,0) AS mnr_amt, --Vessel M&R" ).append("\n"); 
		query.append("               DECODE(STND_COST_CD,'54450000',DHIR_AMT,0) AS dep_amt, --Depreciations" ).append("\n"); 
		query.append("               DECODE(STND_COST_CD,'54180000',DHIR_AMT,0) AS tel_amt, --Telecom Exp" ).append("\n"); 
		query.append("               DECODE(STND_COST_CD,'72100000',DHIR_AMT,0) AS vsl_amt, --Vessel Interest" ).append("\n"); 
		query.append("               DECODE(STND_COST_CD,'54550000',DHIR_AMT,0) AS otr_amt  --Other Operation Exp" ).append("\n"); 
		query.append("          FROM MAS_OWN_VSL_DLY_HIR" ).append("\n"); 
		query.append("         WHERE COST_YRMON = SUBSTR(@[f_yearweek],1,6)" ).append("\n"); 
		query.append("           AND COST_WK    = '00'" ).append("\n"); 
		query.append("         #if (${f_selvessel} != '')" ).append("\n"); 
		query.append("           AND VSL_CD = @[f_selvessel]" ).append("\n"); 
		query.append("         #end" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append(" GROUP BY COST_YRMON," ).append("\n"); 
		query.append("       VSL_CD," ).append("\n"); 
		query.append("       VSL_CLSS_CAPA" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" ORDER BY COST_YRMON" ).append("\n"); 
		query.append("#if (${f_yrtype} == 'yrwk')" ).append("\n"); 
		query.append("        , COST_WK" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        , VSL_CD" ).append("\n"); 
		query.append("        , VSL_CLSS_CAPA" ).append("\n"); 

	}
}