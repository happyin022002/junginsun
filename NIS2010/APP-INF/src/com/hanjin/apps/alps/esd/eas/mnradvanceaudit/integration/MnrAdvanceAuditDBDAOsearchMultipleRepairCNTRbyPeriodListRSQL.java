/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : MnrAdvanceAuditDBDAOsearchMultipleRepairCNTRbyPeriodListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.08.08
*@LastModifier : 
*@LastVersion : 1.0
* 2017.08.08 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.mnradvanceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MnrAdvanceAuditDBDAOsearchMultipleRepairCNTRbyPeriodListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ESD_EAS_0365
	  * Multiple Repair CNTR by Period
	  * 특정기간 동안 다발 수리한 CNTR 조회 - Cleaning 제외
	  * </pre>
	  */
	public MnrAdvanceAuditDBDAOsearchMultipleRepairCNTRbyPeriodListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_to_eq_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_rpr_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_prefix_eq_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_start_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_rpr_cnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_from_eq_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_ownership",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_rcc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_end_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.mnradvanceaudit.integration").append("\n"); 
		query.append("FileName : MnrAdvanceAuditDBDAOsearchMultipleRepairCNTRbyPeriodListRSQL").append("\n"); 
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
		query.append("WITH ROW_DATA AS (" ).append("\n"); 
		query.append("    SELECT   EQ_NO" ).append("\n"); 
		query.append("           , EQ_TPSZ_CD" ).append("\n"); 
		query.append("           , LSTM_CD,OWNR_CO_CD" ).append("\n"); 
		query.append("           , CURR_CD" ).append("\n"); 
		query.append("           , ONH_DT" ).append("\n"); 
		query.append("           , USING_DAYS" ).append("\n"); 
		query.append("           , EQ_CNT" ).append("\n"); 
		query.append("           , MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC( MNR_INP_DT , CURR_CD, 'USD', COST_AMT ) AS CHG_COST_AMT" ).append("\n"); 
		query.append("           , MNR_COMMON_PKG.MNR_CAL_DV_FNC( 'U', EQ_NO, P_ONH_DT ) AS DV_VALUE" ).append("\n"); 
		query.append("    FROM     (" ).append("\n"); 
		query.append("               SELECT   /*+ USE_NL(B A D E) */" ).append("\n"); 
		query.append("                        B.EQ_NO" ).append("\n"); 
		query.append("                      , MAX(B.EQ_TPSZ_CD) AS EQ_TPSZ_CD" ).append("\n"); 
		query.append("                      , MAX(D.LSTM_CD) AS LSTM_CD" ).append("\n"); 
		query.append("                      , (" ).append("\n"); 
		query.append("                          SELECT   DECODE(INTG_CD_VAL_CTNT,'H','SM Line',INTG_CD_VAL_DP_DESC)" ).append("\n"); 
		query.append("                          FROM     COM_INTG_CD_DTL CD" ).append("\n"); 
		query.append("                          WHERE    1 = 1" ).append("\n"); 
		query.append("                          AND      INTG_CD_ID ='CD01047'" ).append("\n"); 
		query.append("                          AND      CD.INTG_CD_VAL_CTNT = D.OWNR_CO_CD" ).append("\n"); 
		query.append("                        ) AS OWNR_CO_CD" ).append("\n"); 
		query.append("                      , MAX(A.CURR_CD) AS CURR_CD" ).append("\n"); 
		query.append("                      , SUM(B.COST_AMT) AS COST_AMT" ).append("\n"); 
		query.append("                      , TO_CHAR(MAX(A.MNR_INP_DT), 'YYYYMM') AS MNR_INP_DT" ).append("\n"); 
		query.append("                      , TO_CHAR(MAX(D.ONH_DT), 'YYYY-MM-DD') AS ONH_DT" ).append("\n"); 
		query.append("                      , TO_CHAR(MAX(D.ONH_DT), 'YYYYMMDD') AS P_ONH_DT" ).append("\n"); 
		query.append("                      , CASE WHEN MAX(E.CNTR_STS_CD) IN ('LSO', 'SBO', 'DIO', 'MUO', 'LST', 'SRO', 'SLD', 'SCR', 'DON', 'TLL') THEN TRUNC(MAX(E.CNTR_STS_EVNT_DT)) - TRUNC(MAX(D.ONH_DT)) + 1" ).append("\n"); 
		query.append("                             ELSE TRUNC(SYSDATE) - TRUNC(MAX(D.ONH_DT)) + 1" ).append("\n"); 
		query.append("                        END AS USING_DAYS" ).append("\n"); 
		query.append("                      , COUNT(1) OVER( PARTITION BY B.EQ_NO ) AS EQ_CNT" ).append("\n"); 
		query.append("               FROM     MNR_ORD_DTL B" ).append("\n"); 
		query.append("                      , MNR_ORD_HDR A" ).append("\n"); 
		query.append("                      , MST_CONTAINER D" ).append("\n"); 
		query.append("                      , MST_CNTR_STS_HIS E" ).append("\n"); 
		query.append("               WHERE    1 = 1" ).append("\n"); 
		query.append("               AND      A.MNR_ORD_OFC_CTY_CD = B.MNR_ORD_OFC_CTY_CD" ).append("\n"); 
		query.append("               AND      A.MNR_ORD_SEQ = B.MNR_ORD_SEQ " ).append("\n"); 
		query.append("               AND      B.EQ_NO = D.CNTR_NO" ).append("\n"); 
		query.append("               AND      D.CNTR_NO = E.CNTR_NO" ).append("\n"); 
		query.append("               AND      D.LST_STS_SEQ = E.CNTR_STS_SEQ" ).append("\n"); 
		query.append("               AND      A.MNR_GRP_TP_CD = 'RPR'" ).append("\n"); 
		query.append("               AND      B.COST_CD != 'MRDRCL'" ).append("\n"); 
		query.append("               AND      A.EQ_KND_CD = 'U'" ).append("\n"); 
		query.append("               AND      B.EQ_NO IS NOT NULL" ).append("\n"); 
		query.append("               AND      A.MNR_WO_TP_CD IN ('EST', 'SPL')" ).append("\n"); 
		query.append("               AND      A.MNR_INP_DT BETWEEN TO_DATE(@[s_start_dt] || '000000', 'YYYY-MM-DDHH24MISS') AND TO_DATE(@[s_end_dt] || '235959', 'YYYY-MM-DDHH24MISS')" ).append("\n"); 
		query.append("#if(${s_prefix_eq_no} != '')" ).append("\n"); 
		query.append("               AND      B.EQ_NO BETWEEN @[s_prefix_eq_no] || @[s_from_eq_no] AND @[s_prefix_eq_no] || @[s_to_eq_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${s_eq_tpsz_cd} != '')" ).append("\n"); 
		query.append("               AND      B.EQ_TPSZ_CD IN" ).append("\n"); 
		query.append("                        (" ).append("\n"); 
		query.append("    #foreach ($tpszCd IN ${eqTpSzCds})" ).append("\n"); 
		query.append("        #if($velocityCount < $eqTpSzCds.size())" ).append("\n"); 
		query.append("                          '$tpszCd'," ).append("\n"); 
		query.append("        #else" ).append("\n"); 
		query.append("                          '$tpszCd'" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("    #end              " ).append("\n"); 
		query.append("                        )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${s_ownership} != '')" ).append("\n"); 
		query.append("               AND      D.OWNR_CO_CD = @[s_ownership]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${s_rcc_cd} != '')" ).append("\n"); 
		query.append("               AND      EXISTS" ).append("\n"); 
		query.append("                        (" ).append("\n"); 
		query.append("                          SELECT   'X'" ).append("\n"); 
		query.append("                          FROM     MDM_YARD YD" ).append("\n"); 
		query.append("                                 , MDM_LOCATION LOC" ).append("\n"); 
		query.append("                                 , MDM_EQ_ORZ_CHT CHT" ).append("\n"); 
		query.append("                          WHERE    1 = 1" ).append("\n"); 
		query.append("                          AND      B.YD_CD = YD.YD_CD" ).append("\n"); 
		query.append("                          AND      YD.LOC_CD = LOC.LOC_CD" ).append("\n"); 
		query.append("                          AND      LOC.SCC_CD = CHT.SCC_CD" ).append("\n"); 
		query.append("                          AND      CHT.RCC_CD = @[s_rcc_cd]" ).append("\n"); 
		query.append("                        )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("               GROUP BY A.MNR_ORD_OFC_CTY_CD" ).append("\n"); 
		query.append("                      , A.MNR_ORD_SEQ" ).append("\n"); 
		query.append("                      , B.EQ_NO" ).append("\n"); 
		query.append("                      , D.OWNR_CO_CD" ).append("\n"); 
		query.append("             )" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT   EQ_NO" ).append("\n"); 
		query.append("       , MAX(EQ_TPSZ_CD) EQ_TPSZ_CD" ).append("\n"); 
		query.append("       , MAX(LSTM_CD) LSTM_CD" ).append("\n"); 
		query.append("       , MAX(OWNR_CO_CD) OWNR_CO_CD" ).append("\n"); 
		query.append("       , MAX(ONH_DT) ENTRY_DAY" ).append("\n"); 
		query.append("       , MAX(USING_DAYS) USING_DAYS" ).append("\n"); 
		query.append("       , MAX(DV_VALUE) DV_VALUE" ).append("\n"); 
		query.append("       , COUNT(1) NO_OF_CASE" ).append("\n"); 
		query.append("       , SUM(CHG_COST_AMT) TOTAL_AMT" ).append("\n"); 
		query.append("FROM     ROW_DATA" ).append("\n"); 
		query.append("GROUP BY EQ_NO" ).append("\n"); 
		query.append("HAVING   COUNT(1) > NVL(TO_NUMBER(@[s_rpr_cnt]), 3)" ).append("\n"); 
		query.append("#if(${s_rpr_amt} != '')" ).append("\n"); 
		query.append("AND      SUM(CHG_COST_AMT) > TO_NUMBER(@[s_rpr_amt])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${s_over_dv_amt} != '')" ).append("\n"); 
		query.append("AND      SUM(CHG_COST_AMT) > MAX(NVL(DV_VALUE, 0))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY EQ_NO" ).append("\n"); 

	}
}