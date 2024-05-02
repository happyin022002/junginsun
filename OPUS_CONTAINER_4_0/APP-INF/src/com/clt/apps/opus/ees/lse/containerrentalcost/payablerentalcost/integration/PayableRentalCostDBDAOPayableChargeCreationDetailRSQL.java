/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : PayableRentalCostDBDAOPayableChargeCreationDetailRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.11.02
*@LastModifier : 이주현
*@LastVersion : 1.0
* 2016.11.02 이주현
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.lse.containerrentalcost.payablerentalcost.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author LEE JU HYUN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PayableRentalCostDBDAOPayableChargeCreationDetailRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Payable Rental Charge Creation : Charge Detail Search
	  *  LT일때 Per-Diem LCC로 변경
	  * </pre>
	  */
	public PayableRentalCostDBDAOPayableChargeCreationDetailRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_cost_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.lse.containerrentalcost.payablerentalcost.integration").append("\n"); 
		query.append("FileName : PayableRentalCostDBDAOPayableChargeCreationDetailRSQL").append("\n"); 
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
		query.append("WITH PARAM AS" ).append("\n"); 
		query.append("     ( SELECT A.*" ).append("\n"); 
		query.append("            , TO_DATE(@[chg_cost_yrmon], 'YYYYMM')          AS FIRST_DT" ).append("\n"); 
		query.append("            , LAST_DAY(TO_DATE(@[chg_cost_yrmon],'YYYYMM')) AS LAST_DT" ).append("\n"); 
		query.append("            , TRUNC(LAST_DAY(TO_DATE(@[chg_cost_yrmon], 'YYYYMM'))) AS BASE_DT" ).append("\n"); 
		query.append("            , @[chg_seq]                                    AS CHG_SEQ" ).append("\n"); 
		query.append("            , @[usr_id]                                     AS USR_ID" ).append("\n"); 
		query.append("       FROM   LSE_AGREEMENT A" ).append("\n"); 
		query.append("       WHERE  A.AGMT_SEQ    = @[agmt_seq]" ).append("\n"); 
		query.append("       AND    A.AGMT_CTY_CD = @[agmt_cty_cd]" ).append("\n"); 
		query.append("     )" ).append("\n"); 
		query.append("   , OF_LSI_DATA AS" ).append("\n"); 
		query.append("     ( SELECT CNTR.CNTR_NO" ).append("\n"); 
		query.append("            , LSI.CNTR_STS_SEQ" ).append("\n"); 
		query.append("            , LSI.CNTR_STS_CD" ).append("\n"); 
		query.append("            , LSI.CNTR_STS_EVNT_DT" ).append("\n"); 
		query.append("            , LSI.LOC_CD" ).append("\n"); 
		query.append("            , NVL(LSI.RNTL_CHG_FREE_DYS, 0) RNTL_CHG_FREE_DYS" ).append("\n"); 
		query.append("            , LSI.AGMT_CTY_CD" ).append("\n"); 
		query.append("            , LSI.AGMT_SEQ" ).append("\n"); 
		query.append("            , P.LSTM_CD" ).append("\n"); 
		query.append("            , LSI.CNTR_LFT_CHG_AMT" ).append("\n"); 
		query.append("            , LSI.CNTR_PKUP_CHG_AMT" ).append("\n"); 
		query.append("            , LSI.LCC_CD" ).append("\n"); 
		query.append("            , CNTR.ONH_YD_CD" ).append("\n"); 
		query.append("       FROM   MST_CONTAINER     CNTR" ).append("\n"); 
		query.append("            , MST_CNTR_STS_HIS  LSI" ).append("\n"); 
		query.append("            , PARAM             P" ).append("\n"); 
		query.append("       WHERE  CNTR.CNTR_NO    = LSI.CNTR_NO" ).append("\n"); 
		query.append("       AND    LSI.CNTR_STS_EVNT_DT <= P.LAST_DT + 0.99999" ).append("\n"); 
		query.append("       AND    LSI.CNTR_STS_CD IN ('DII','LSI')" ).append("\n"); 
		query.append("       AND    LSI.AGMT_SEQ    = P.AGMT_SEQ" ).append("\n"); 
		query.append("       AND    LSI.AGMT_CTY_CD = P.AGMT_CTY_CD" ).append("\n"); 
		query.append("     )" ).append("\n"); 
		query.append("   , OF_LSO_DATA AS" ).append("\n"); 
		query.append("     ( SELECT LSO.CNTR_NO" ).append("\n"); 
		query.append("            , CNTR.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("            , LSO.CNTR_STS_CD" ).append("\n"); 
		query.append("            , DECODE(LSO.CNTR_STS_CD, 'TLL', LSO.CNTR_LOST_NTFY_DT" ).append("\n"); 
		query.append("                                           , LSO.CNTR_STS_EVNT_DT - DECODE(LSO.CNTR_LSTM_CNG_FLG, 'Y', 0, 0)) AS CNTR_STS_EVNT_DT" ).append("\n"); 
		query.append("            , LSO.LOC_CD" ).append("\n"); 
		query.append("            , LSO.PRNR_STS_SEQ" ).append("\n"); 
		query.append("            , LSO.CNTR_LFT_CHG_AMT" ).append("\n"); 
		query.append("            , LSO.CNTR_LSTM_CNG_FLG" ).append("\n"); 
		query.append("            , LSO.CNTR_DRFF_CR_AMT" ).append("\n"); 
		query.append("       FROM   MST_CONTAINER     CNTR" ).append("\n"); 
		query.append("            , MST_CNTR_STS_HIS  LSO" ).append("\n"); 
		query.append("            , PARAM             P" ).append("\n"); 
		query.append("       WHERE  CNTR.CNTR_NO    = LSO.CNTR_NO" ).append("\n"); 
		query.append("       AND    DECODE(LSO.CNTR_STS_CD, 'TLL', CNTR_LOST_NTFY_DT, LSO.CNTR_STS_EVNT_DT - DECODE(LSO.CNTR_LSTM_CNG_FLG, 'Y', 0, 0)) BETWEEN P.FIRST_DT AND P.LAST_DT + 0.99999" ).append("\n"); 
		query.append("       AND    LSO.CNTR_STS_CD IN ('TLL', 'DIO', 'LSO', 'SCR', 'SRO')" ).append("\n"); 
		query.append("       AND    LSO.AGMT_SEQ    = P.AGMT_SEQ" ).append("\n"); 
		query.append("       AND    LSO.AGMT_CTY_CD = P.AGMT_CTY_CD" ).append("\n"); 
		query.append("     )" ).append("\n"); 
		query.append("   , ON_LSI_DATA AS" ).append("\n"); 
		query.append("     ( SELECT SUBSTR(MAX(TO_CHAR(HIS.CNTR_STS_EVNT_DT,'RRRRMMDD') || TO_CHAR(HIS.CNTR_STS_SEQ, '00') || HIS.ROWID), 12) AS ROW_ID" ).append("\n"); 
		query.append("       FROM   MST_CNTR_STS_HIS  HIS" ).append("\n"); 
		query.append("            , PARAM             P" ).append("\n"); 
		query.append("       WHERE  HIS.CNTR_STS_CD IN ('TLL', 'DIO', 'LSO', 'DII', 'LSI', 'SCR', 'SRO')" ).append("\n"); 
		query.append("       AND    DECODE(HIS.CNTR_STS_CD, 'TLL', HIS.CNTR_LOST_NTFY_DT, HIS.CNTR_STS_EVNT_DT) <= P.LAST_DT" ).append("\n"); 
		query.append("       AND    HIS.AGMT_SEQ    = P.AGMT_SEQ" ).append("\n"); 
		query.append("       AND    HIS.AGMT_CTY_CD = P.AGMT_CTY_CD" ).append("\n"); 
		query.append("       GROUP  BY HIS.CNTR_NO" ).append("\n"); 
		query.append("       HAVING SUBSTR(MAX(TO_CHAR(DECODE(HIS.CNTR_STS_CD, 'TLL', HIS.CNTR_LOST_NTFY_DT, HIS.CNTR_STS_EVNT_DT),'RRRRMMDD')" ).append("\n"); 
		query.append("                         || TO_CHAR(HIS.CNTR_STS_SEQ, '00')" ).append("\n"); 
		query.append("                         || HIS.CNTR_STS_CD), 12, 3)" ).append("\n"); 
		query.append("                 IN ('DII','LSI')" ).append("\n"); 
		query.append("     )" ).append("\n"); 
		query.append("   , CNTR_LIST_DATA AS" ).append("\n"); 
		query.append("     ( SELECT A.AGMT_CTY_CD" ).append("\n"); 
		query.append("            , A.AGMT_SEQ" ).append("\n"); 
		query.append("            , A.LSTM_CD" ).append("\n"); 
		query.append("            , A.CNTR_NO" ).append("\n"); 
		query.append("            , A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("            , A.ONH_DT" ).append("\n"); 
		query.append("            , A.OFFH_DT" ).append("\n"); 
		query.append("            , A.ONH_LOC_CD" ).append("\n"); 
		query.append("            , A.OFFH_LOC_CD" ).append("\n"); 
		query.append("            , A.CHG_FREE_DYS" ).append("\n"); 
		query.append("            , A.USE_STRT_DT" ).append("\n"); 
		query.append("            , NVL(A.OFFH_DT, P.LAST_DT) - A.USE_STRT_DT + 1 AS COST_DYS -- TTL_DYS" ).append("\n"); 
		query.append("            , A.PYBL_USE_STRT_DT" ).append("\n"); 
		query.append("            , CASE WHEN A.PYBL_USE_STRT_DT <= NVL(A.OFFH_DT, P.LAST_DT) + 0.99999 THEN NVL(A.OFFH_DT, P.LAST_DT) - A.PYBL_USE_STRT_DT + 1 ELSE 0 END BIL_DYS" ).append("\n"); 
		query.append("            , A.CNTR_LSTM_CNG_FLG" ).append("\n"); 
		query.append("            , A.ONH_STS_CD" ).append("\n"); 
		query.append("            , A.OFH_STS_CD" ).append("\n"); 
		query.append("            , A.LFT_ON_CHG_AMT" ).append("\n"); 
		query.append("            , A.LFT_OF_CHG_AMT" ).append("\n"); 
		query.append("            , A.PUC_PCR_CHG_AMT" ).append("\n"); 
		query.append("            , A.DOC_DCR_CHG_AMT" ).append("\n"); 
		query.append("--            , A.LCC_CD AS ONH_LCC_CD" ).append("\n"); 
		query.append("            , A.ONH_YD_CD" ).append("\n"); 
		query.append("            , DECODE(A.LSTM_CD,'LT',CHT.LCC_CD,LOC.SCC_CD) AS ONH_YD_SCC_CD /* 2010.12.13 LT 일때 SCC->LCC변경*/" ).append("\n"); 
		query.append("--            , LOC.SCC_CD AS ONH_YD_SCC_CD" ).append("\n"); 
		query.append("       FROM   ( SELECT LSI.AGMT_CTY_CD" ).append("\n"); 
		query.append("                     , LSI.AGMT_SEQ" ).append("\n"); 
		query.append("                     , LSI.LSTM_CD" ).append("\n"); 
		query.append("                     , LSO.CNTR_NO" ).append("\n"); 
		query.append("                     , LSO.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                     , LSI.CNTR_STS_CD      AS ONH_STS_CD" ).append("\n"); 
		query.append("                     , LSI.CNTR_STS_EVNT_DT AS ONH_DT" ).append("\n"); 
		query.append("                     , LSI.LOC_CD           AS ONH_LOC_CD" ).append("\n"); 
		query.append("                     , LSO.CNTR_STS_CD      AS OFH_STS_CD" ).append("\n"); 
		query.append("                     , LSO.CNTR_STS_EVNT_DT AS OFFH_DT" ).append("\n"); 
		query.append("                     , LSO.LOC_CD           AS OFFH_LOC_CD" ).append("\n"); 
		query.append("                     , LSO.CNTR_LFT_CHG_AMT" ).append("\n"); 
		query.append("                     , LSO.CNTR_LSTM_CNG_FLG" ).append("\n"); 
		query.append("                     , LSI.RNTL_CHG_FREE_DYS AS CHG_FREE_DYS" ).append("\n"); 
		query.append("                     , DECODE(TO_CHAR(LSI.CNTR_STS_EVNT_DT, 'YYYYMM'), TO_CHAR(P.FIRST_DT, 'YYYYMM'), LSI.CNTR_STS_EVNT_DT" ).append("\n"); 
		query.append("                                                                                                    , P.FIRST_DT)" ).append("\n"); 
		query.append("                                             AS USE_STRT_DT" ).append("\n"); 
		query.append("                     , CASE WHEN TO_CHAR(LSI.CNTR_STS_EVNT_DT + LSI.RNTL_CHG_FREE_DYS, 'YYYYMM') < TO_CHAR(P.FIRST_DT, 'YYYYMM') THEN P.FIRST_DT" ).append("\n"); 
		query.append("                            ELSE LSI.CNTR_STS_EVNT_DT + LSI.RNTL_CHG_FREE_DYS" ).append("\n"); 
		query.append("                       END                   AS PYBL_USE_STRT_DT" ).append("\n"); 
		query.append("                     , LSI.CNTR_LFT_CHG_AMT  AS LFT_ON_CHG_AMT" ).append("\n"); 
		query.append("                     , LSO.CNTR_LFT_CHG_AMT  AS LFT_OF_CHG_AMT" ).append("\n"); 
		query.append("                     , LSI.CNTR_PKUP_CHG_AMT AS PUC_PCR_CHG_AMT" ).append("\n"); 
		query.append("                     , LSO.CNTR_DRFF_CR_AMT  AS DOC_DCR_CHG_AMT" ).append("\n"); 
		query.append("--                     , LSI.LCC_CD" ).append("\n"); 
		query.append("                     , LSI.ONH_YD_CD" ).append("\n"); 
		query.append("                FROM   OF_LSI_DATA  LSI" ).append("\n"); 
		query.append("                     , OF_LSO_DATA  LSO" ).append("\n"); 
		query.append("                     , PARAM        P" ).append("\n"); 
		query.append("                WHERE  LSI.CNTR_NO      = LSO.CNTR_NO" ).append("\n"); 
		query.append("                AND    LSI.CNTR_STS_SEQ = LSO.PRNR_STS_SEQ" ).append("\n"); 
		query.append("                UNION ALL" ).append("\n"); 
		query.append("                SELECT LSI.AGMT_CTY_CD" ).append("\n"); 
		query.append("                     , LSI.AGMT_SEQ" ).append("\n"); 
		query.append("                     , P.LSTM_CD" ).append("\n"); 
		query.append("                     , LSI.CNTR_NO" ).append("\n"); 
		query.append("                     , CNTR.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                     , LSI.CNTR_STS_CD      AS ONH_STS_CD" ).append("\n"); 
		query.append("                     , LSI.CNTR_STS_EVNT_DT AS ONH_DT" ).append("\n"); 
		query.append("                     , LSI.LOC_CD           AS ONH_LOC_CD" ).append("\n"); 
		query.append("                     , NULL                 AS OFH_STS_CD" ).append("\n"); 
		query.append("                     , NULL                 AS OFFH_DT" ).append("\n"); 
		query.append("                     , NULL                 AS OFFH_LOC_CD" ).append("\n"); 
		query.append("                     , LSI.CNTR_LFT_CHG_AMT" ).append("\n"); 
		query.append("                     , LSI.CNTR_LSTM_CNG_FLG" ).append("\n"); 
		query.append("                     , NVL(LSI.RNTL_CHG_FREE_DYS, 0) AS CHG_FREE_DYS" ).append("\n"); 
		query.append("                     , DECODE(TO_CHAR(LSI.CNTR_STS_EVNT_DT, 'YYYYMM'), TO_CHAR(P.FIRST_DT, 'YYYYMM'), LSI.CNTR_STS_EVNT_DT" ).append("\n"); 
		query.append("                                                                                                    , P.FIRST_DT)" ).append("\n"); 
		query.append("                                             AS USE_STRT_DT" ).append("\n"); 
		query.append("                     , CASE WHEN TO_CHAR(LSI.CNTR_STS_EVNT_DT + NVL(LSI.RNTL_CHG_FREE_DYS, 0), 'YYYYMM') < TO_CHAR(P.FIRST_DT, 'YYYYMM') THEN P.FIRST_DT" ).append("\n"); 
		query.append("                            ELSE LSI.CNTR_STS_EVNT_DT + NVL(LSI.RNTL_CHG_FREE_DYS, 0)" ).append("\n"); 
		query.append("                       END                   AS PYBL_USE_STRT_DT" ).append("\n"); 
		query.append("                     , LSI.CNTR_LFT_CHG_AMT  AS LFT_ON_CHG_AMT" ).append("\n"); 
		query.append("                     , 0                     AS LFT_OF_CHG_AMT" ).append("\n"); 
		query.append("                     , LSI.CNTR_PKUP_CHG_AMT AS PUC_PCR_CHG_AMT" ).append("\n"); 
		query.append("                     , 0                     AS DOC_DCR_CHG_AMT" ).append("\n"); 
		query.append("--                     , LSI.LCC_CD" ).append("\n"); 
		query.append("                     , CNTR.ONH_YD_CD" ).append("\n"); 
		query.append("                FROM   MST_CONTAINER     CNTR" ).append("\n"); 
		query.append("                     , MST_CNTR_STS_HIS  LSI" ).append("\n"); 
		query.append("                     , PARAM             P" ).append("\n"); 
		query.append("                WHERE  CNTR.CNTR_NO     = LSI.CNTR_NO" ).append("\n"); 
		query.append("                AND    P.AGMT_SEQ    = LSI.AGMT_SEQ" ).append("\n"); 
		query.append("                AND    P.AGMT_CTY_CD = LSI.AGMT_CTY_CD" ).append("\n"); 
		query.append("                AND    (LSI.ROWID) IN ( SELECT ROW_ID FROM ON_LSI_DATA )" ).append("\n"); 
		query.append("              ) A" ).append("\n"); 
		query.append("            , PARAM P" ).append("\n"); 
		query.append("            , MDM_YARD     YARD" ).append("\n"); 
		query.append("            , MDM_LOCATION LOC 			" ).append("\n"); 
		query.append("  	        , MDM_EQ_ORZ_CHT  CHT /* 2010.12.13 Lcc정보 추가*/" ).append("\n"); 
		query.append("       WHERE  LOC.LOC_CD = YARD.LOC_CD" ).append("\n"); 
		query.append("	   AND    LOC.SCC_CD = CHT.SCC_CD" ).append("\n"); 
		query.append("       AND    YARD.YD_CD = A.ONH_YD_CD" ).append("\n"); 
		query.append("     )" ).append("\n"); 
		query.append("   , AGMT_PDGV_DATA AS" ).append("\n"); 
		query.append("     ( SELECT A.AGMT_CTY_CD" ).append("\n"); 
		query.append("            , A.AGMT_SEQ" ).append("\n"); 
		query.append("            , RANK() OVER (PARTITION BY A.AGMT_CTY_CD, A.AGMT_SEQ, A.CNTR_TPSZ_CD ORDER BY A.AGMT_CTY_CD, A.AGMT_SEQ, A.CNTR_TPSZ_CD, A.AGMT_CHG_VAL) AS PDGV_RANK" ).append("\n"); 
		query.append("            , A.LOC_CD AS PDGV_SCC_CD" ).append("\n"); 
		query.append("            , A.AGMT_CHG_VAL AS TEU_NO" ).append("\n"); 
		query.append("             , A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("            , A.N1ST_CHG_AMT AS PDM_RT" ).append("\n"); 
		query.append("       FROM   LSE_AGMT_RT_V A" ).append("\n"); 
		query.append("            , PARAM       P" ).append("\n"); 
		query.append("       WHERE  A.CNTR_RNTL_CHG_TP_CD = 'PDGV'" ).append("\n"); 
		query.append("       AND    A.AGMT_SEQ     = P.AGMT_SEQ " ).append("\n"); 
		query.append("       AND    A.AGMT_CTY_CD  = P.AGMT_CTY_CD" ).append("\n"); 
		query.append("       AND    A.AGMT_VER_SEQ = MST_COMMON_PKG.MST_AGMT_LST_VER_GET_FNC(P.AGMT_CTY_CD, P.AGMT_SEQ, P.BASE_DT)" ).append("\n"); 
		query.append("     )" ).append("\n"); 
		query.append("   , APP_PDGM_DATA AS" ).append("\n"); 
		query.append("     ( SELECT A.PDGV_SCC_CD" ).append("\n"); 
		query.append("            , A.TEU_NO" ).append("\n"); 
		query.append("            , NVL(B.TEU_NO2, 999999) AS TEU_NO2" ).append("\n"); 
		query.append("            , A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("            , PDM_RT" ).append("\n"); 
		query.append("       FROM   AGMT_PDGV_DATA A" ).append("\n"); 
		query.append("            , ( SELECT AGMT_CTY_CD" ).append("\n"); 
		query.append("                     , AGMT_SEQ" ).append("\n"); 
		query.append("                     , PDGV_RANK - 1 AS PDGV_RANK2" ).append("\n"); 
		query.append("                     , CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                     , PDGV_SCC_CD" ).append("\n"); 
		query.append("                     , TEU_NO-1 AS TEU_NO2" ).append("\n"); 
		query.append("                FROM   AGMT_PDGV_DATA" ).append("\n"); 
		query.append("                WHERE  PDGV_RANK > 1" ).append("\n"); 
		query.append("              ) B" ).append("\n"); 
		query.append("       WHERE  A.AGMT_CTY_CD  = B.AGMT_CTY_CD(+) " ).append("\n"); 
		query.append("       AND    A.AGMT_SEQ     = B.AGMT_SEQ(+)" ).append("\n"); 
		query.append("       AND    A.PDGV_RANK    = B.PDGV_RANK2(+)" ).append("\n"); 
		query.append("       AND    A.CNTR_TPSZ_CD = B.CNTR_TPSZ_CD(+)" ).append("\n"); 
		query.append("       AND    A.PDGV_SCC_CD  = B.PDGV_SCC_CD(+)" ).append("\n"); 
		query.append("     )" ).append("\n"); 
		query.append("SELECT P.CHG_SEQ" ).append("\n"); 
		query.append("     , A.CNTR_NO" ).append("\n"); 
		query.append("     , 'PDM' AS LSE_PAY_CHG_TP_CD" ).append("\n"); 
		query.append("     , A.AGMT_CTY_CD" ).append("\n"); 
		query.append("     , A.AGMT_SEQ" ).append("\n"); 
		query.append("     , A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("     , TO_CHAR(A.ONH_DT,'YYYYMMDD')  AS ONH_DT" ).append("\n"); 
		query.append("     , TO_CHAR(A.OFFH_DT,'YYYYMMDD') AS OFFH_DT" ).append("\n"); 
		query.append("     , A.ONH_LOC_CD" ).append("\n"); 
		query.append("     , A.OFFH_LOC_CD" ).append("\n"); 
		query.append("     , A.CHG_FREE_DYS" ).append("\n"); 
		query.append("--     , B.MNTHLY_TTL_CNT" ).append("\n"); 
		query.append("     , B.PDM_RT AS PD_RT_AMT" ).append("\n"); 
		query.append("     , ROUND(A.BIL_DYS*B.PDM_RT,2) AS TTL_COST_AMT" ).append("\n"); 
		query.append("--     , A.USE_STRT_DT" ).append("\n"); 
		query.append("     , A.COST_DYS" ).append("\n"); 
		query.append("--     , A.PYBL_USE_STRT_DT" ).append("\n"); 
		query.append("     , A.BIL_DYS" ).append("\n"); 
		query.append("     , P.USR_ID AS CRE_USR_ID" ).append("\n"); 
		query.append("     , P.USR_ID AS UPD_USR_ID" ).append("\n"); 
		query.append("FROM   CNTR_LIST_DATA A" ).append("\n"); 
		query.append("     , ( SELECT A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("              , NULL AS ONH_YD_SCC_CD" ).append("\n"); 
		query.append("              , A.MNTHLY_TTL_CNT" ).append("\n"); 
		query.append("              , B.PDM_RT" ).append("\n"); 
		query.append("         FROM   ( SELECT CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                       , COUNT(CNTR_NO) AS MNTHLY_TTL_CNT" ).append("\n"); 
		query.append("                  FROM   CNTR_LIST_DATA" ).append("\n"); 
		query.append("                  GROUP  BY CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                 )             A" ).append("\n"); 
		query.append("               , APP_PDGM_DATA B" ).append("\n"); 
		query.append("               , PARAM         P" ).append("\n"); 
		query.append("         WHERE  A.CNTR_TPSZ_CD = B.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("         AND    B.TEU_NO <= A.MNTHLY_TTL_CNT AND B.TEU_NO2 >= A.MNTHLY_TTL_CNT" ).append("\n"); 
		query.append("         AND    P.LSTM_CD <> 'LT'" ).append("\n"); 
		query.append("         UNION ALL" ).append("\n"); 
		query.append("         SELECT A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("              , A.ONH_YD_SCC_CD" ).append("\n"); 
		query.append("              , A.MNTHLY_TTL_CNT" ).append("\n"); 
		query.append("              , NVL(MST_COMMON_PKG.MST_LSE_AGMT_RT_GET_FNC(P.AGMT_CTY_CD, P.AGMT_SEQ, 'PDM', A.CNTR_TPSZ_CD, A.ONH_YD_SCC_CD, P.BASE_DT), 0) AS PDM_RT" ).append("\n"); 
		query.append("         FROM   ( SELECT CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                       , ONH_YD_SCC_CD" ).append("\n"); 
		query.append("                       , COUNT(CNTR_NO) AS MNTHLY_TTL_CNT" ).append("\n"); 
		query.append("                  FROM   CNTR_LIST_DATA" ).append("\n"); 
		query.append("                  GROUP  BY CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                          , ONH_YD_SCC_CD" ).append("\n"); 
		query.append("                 )              A" ).append("\n"); 
		query.append("               , PARAM          P" ).append("\n"); 
		query.append("         WHERE P.LSTM_CD    = 'LT'" ).append("\n"); 
		query.append("       ) B" ).append("\n"); 
		query.append("     , PARAM P" ).append("\n"); 
		query.append("WHERE  A.ONH_YD_SCC_CD   = DECODE(P.LSTM_CD, 'LT', B.ONH_YD_SCC_CD, A.ONH_YD_SCC_CD)" ).append("\n"); 
		query.append("AND    A.CNTR_TPSZ_CD = B.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT P.CHG_SEQ" ).append("\n"); 
		query.append("     , A.CNTR_NO" ).append("\n"); 
		query.append("     , 'LON' AS LSE_PAY_CHG_TP_CD" ).append("\n"); 
		query.append("     , A.AGMT_CTY_CD" ).append("\n"); 
		query.append("     , A.AGMT_SEQ" ).append("\n"); 
		query.append("     , A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("     , TO_CHAR(A.ONH_DT,'YYYYMMDD')  AS ONH_DT" ).append("\n"); 
		query.append("     , TO_CHAR(A.OFFH_DT,'YYYYMMDD') AS OFFH_DT" ).append("\n"); 
		query.append("     , A.ONH_LOC_CD" ).append("\n"); 
		query.append("     , A.OFFH_LOC_CD" ).append("\n"); 
		query.append("     , A.CHG_FREE_DYS" ).append("\n"); 
		query.append("--     , 0 AS MNTHLY_TTL_CNT" ).append("\n"); 
		query.append("     , 0 AS PD_RT_AMT --A.LFT_ON_CHG_AMT AS PD_RT_AMT" ).append("\n"); 
		query.append("     , NVL(A.LFT_ON_CHG_AMT, 0) AS TTL_COST_AMT" ).append("\n"); 
		query.append("--     , A.USE_STRT_DT" ).append("\n"); 
		query.append("     , 0 AS COST_DYS --A.COST_DYS" ).append("\n"); 
		query.append("--     , A.PYBL_USE_STRT_DT" ).append("\n"); 
		query.append("     , A.BIL_DYS" ).append("\n"); 
		query.append("     , P.USR_ID AS CRE_USR_ID" ).append("\n"); 
		query.append("     , P.USR_ID AS UPD_USR_ID" ).append("\n"); 
		query.append("FROM   CNTR_LIST_DATA A" ).append("\n"); 
		query.append("     , PARAM          P" ).append("\n"); 
		query.append("WHERE  A.ONH_STS_CD IN ('DII', 'LSI')" ).append("\n"); 
		query.append("AND    A.CNTR_LSTM_CNG_FLG <> 'Y'" ).append("\n"); 
		query.append("AND    A.ONH_DT BETWEEN P.FIRST_DT AND P.LAST_DT + 0.99999" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT P.CHG_SEQ" ).append("\n"); 
		query.append("     , A.CNTR_NO" ).append("\n"); 
		query.append("     , 'LOF' AS LSE_PAY_CHG_TP_CD" ).append("\n"); 
		query.append("     , A.AGMT_CTY_CD" ).append("\n"); 
		query.append("     , A.AGMT_SEQ" ).append("\n"); 
		query.append("     , A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("     , TO_CHAR(A.ONH_DT,'YYYYMMDD')  AS ONH_DT" ).append("\n"); 
		query.append("     , TO_CHAR(A.OFFH_DT,'YYYYMMDD') AS OFFH_DT" ).append("\n"); 
		query.append("     , A.ONH_LOC_CD" ).append("\n"); 
		query.append("     , A.OFFH_LOC_CD" ).append("\n"); 
		query.append("     , A.CHG_FREE_DYS" ).append("\n"); 
		query.append("--     , 0 AS MNTHLY_TTL_CNT" ).append("\n"); 
		query.append("     , 0 AS PD_RT_AMT --A.LFT_OF_CHG_AMT AS PD_RT_AMT" ).append("\n"); 
		query.append("     , NVL(A.LFT_OF_CHG_AMT, 0) AS TTL_COST_AMT" ).append("\n"); 
		query.append("--     , A.USE_STRT_DT" ).append("\n"); 
		query.append("     , 0 AS COST_DYS --A.COST_DYS" ).append("\n"); 
		query.append("--     , A.PYBL_USE_STRT_DT" ).append("\n"); 
		query.append("     , A.BIL_DYS" ).append("\n"); 
		query.append("     , P.USR_ID AS CRE_USR_ID" ).append("\n"); 
		query.append("     , P.USR_ID AS UPD_USR_ID" ).append("\n"); 
		query.append("FROM   CNTR_LIST_DATA A" ).append("\n"); 
		query.append("     , PARAM          P" ).append("\n"); 
		query.append("WHERE  A.CNTR_LSTM_CNG_FLG <> 'Y'" ).append("\n"); 
		query.append("AND    A.OFH_STS_CD IN ('DIO', 'LSO')" ).append("\n"); 
		query.append("AND    A.OFFH_DT BETWEEN P.FIRST_DT AND P.LAST_DT + 0.99999" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT P.CHG_SEQ" ).append("\n"); 
		query.append("     , A.CNTR_NO" ).append("\n"); 
		query.append("     , CASE WHEN A.PUC_PCR_CHG_AMT > 0 THEN 'PUC'" ).append("\n"); 
		query.append("            WHEN A.PUC_PCR_CHG_AMT < 0 THEN 'PCR'" ).append("\n"); 
		query.append("       END AS LSE_PAY_CHG_TP_CD" ).append("\n"); 
		query.append("     , A.AGMT_CTY_CD" ).append("\n"); 
		query.append("     , A.AGMT_SEQ" ).append("\n"); 
		query.append("     , A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("     , TO_CHAR(A.ONH_DT,'YYYYMMDD')  AS ONH_DT" ).append("\n"); 
		query.append("     , TO_CHAR(A.OFFH_DT,'YYYYMMDD') AS OFFH_DT" ).append("\n"); 
		query.append("     , A.ONH_LOC_CD" ).append("\n"); 
		query.append("     , A.OFFH_LOC_CD" ).append("\n"); 
		query.append("     , A.CHG_FREE_DYS" ).append("\n"); 
		query.append("--     , 0 AS MNTHLY_TTL_CNT" ).append("\n"); 
		query.append("     , 0 AS PD_RT_AMT --A.PUC_PCR_CHG_AMT AS PD_RT_AMT" ).append("\n"); 
		query.append("     , NVL(A.PUC_PCR_CHG_AMT, 0) AS TTL_COST_AMT" ).append("\n"); 
		query.append("--     , A.USE_STRT_DT" ).append("\n"); 
		query.append("     , 0 AS COST_DYS --A.COST_DYS" ).append("\n"); 
		query.append("--     , A.PYBL_USE_STRT_DT" ).append("\n"); 
		query.append("     , A.BIL_DYS" ).append("\n"); 
		query.append("     , P.USR_ID AS CRE_USR_ID" ).append("\n"); 
		query.append("     , P.USR_ID AS UPD_USR_ID" ).append("\n"); 
		query.append("FROM   CNTR_LIST_DATA A" ).append("\n"); 
		query.append("     , PARAM          P" ).append("\n"); 
		query.append("WHERE  (A.PUC_PCR_CHG_AMT > 0 OR A.PUC_PCR_CHG_AMT < 0)" ).append("\n"); 
		query.append("AND    A.ONH_STS_CD IN ('DII', 'LSI')" ).append("\n"); 
		query.append("AND    A.CNTR_LSTM_CNG_FLG <> 'Y'" ).append("\n"); 
		query.append("AND    A.ONH_DT BETWEEN P.FIRST_DT AND P.LAST_DT + 0.99999" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT P.CHG_SEQ" ).append("\n"); 
		query.append("     , A.CNTR_NO" ).append("\n"); 
		query.append("     , CASE WHEN A.DOC_DCR_CHG_AMT > 0 THEN 'DOC'" ).append("\n"); 
		query.append("            WHEN A.DOC_DCR_CHG_AMT < 0 THEN 'DCR'" ).append("\n"); 
		query.append("       END AS LSE_PAY_CHG_TP_CD" ).append("\n"); 
		query.append("     , A.AGMT_CTY_CD" ).append("\n"); 
		query.append("     , A.AGMT_SEQ" ).append("\n"); 
		query.append("     , A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("     , TO_CHAR(A.ONH_DT,'YYYYMMDD')  AS ONH_DT" ).append("\n"); 
		query.append("     , TO_CHAR(A.OFFH_DT,'YYYYMMDD') AS OFFH_DT" ).append("\n"); 
		query.append("     , A.ONH_LOC_CD" ).append("\n"); 
		query.append("     , A.OFFH_LOC_CD" ).append("\n"); 
		query.append("     , A.CHG_FREE_DYS" ).append("\n"); 
		query.append("--     , 0 AS MNTHLY_TTL_CNT" ).append("\n"); 
		query.append("     , 0 AS PD_RT_AMT --A.DOC_DCR_CHG_AMT AS PD_RT_AMT" ).append("\n"); 
		query.append("     , NVL(A.DOC_DCR_CHG_AMT, 0) AS TTL_COST_AMT" ).append("\n"); 
		query.append("--     , A.USE_STRT_DT" ).append("\n"); 
		query.append("     , 0 AS COST_DYS --A.COST_DYS" ).append("\n"); 
		query.append("--     , A.PYBL_USE_STRT_DT" ).append("\n"); 
		query.append("     , A.BIL_DYS" ).append("\n"); 
		query.append("     , P.USR_ID AS CRE_USR_ID" ).append("\n"); 
		query.append("     , P.USR_ID AS UPD_USR_ID" ).append("\n"); 
		query.append("FROM   CNTR_LIST_DATA A" ).append("\n"); 
		query.append("     , PARAM          P" ).append("\n"); 
		query.append("WHERE  (A.DOC_DCR_CHG_AMT > 0 OR A.DOC_DCR_CHG_AMT < 0)" ).append("\n"); 
		query.append("AND    A.OFH_STS_CD IN ('DIO', 'LSO')" ).append("\n"); 
		query.append("AND    A.OFFH_DT BETWEEN P.FIRST_DT AND P.LAST_DT + 0.99999" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT P.CHG_SEQ" ).append("\n"); 
		query.append("     , A.CNTR_NO" ).append("\n"); 
		query.append("     , 'GTI' AS LSE_PAY_CHG_TP_CD" ).append("\n"); 
		query.append("     , A.AGMT_CTY_CD" ).append("\n"); 
		query.append("     , A.AGMT_SEQ" ).append("\n"); 
		query.append("     , A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("     , TO_CHAR(A.ONH_DT,'YYYYMMDD')  AS ONH_DT" ).append("\n"); 
		query.append("     , TO_CHAR(A.OFFH_DT,'YYYYMMDD') AS OFFH_DT" ).append("\n"); 
		query.append("     , A.ONH_LOC_CD" ).append("\n"); 
		query.append("     , A.OFFH_LOC_CD" ).append("\n"); 
		query.append("     , A.CHG_FREE_DYS" ).append("\n"); 
		query.append("--     , 0 AS MNTHLY_TTL_CNT" ).append("\n"); 
		query.append("     , 0 AS PD_RT_AMT --A.LFT_ON_CHG_AMT AS PD_RT_AMT" ).append("\n"); 
		query.append("     , NVL(MST_COMMON_PKG.MST_LSE_AGMT_RT_GET_FNC(P.AGMT_CTY_CD, P.AGMT_SEQ, 'GTI', A.CNTR_TPSZ_CD, A.ONH_LOC_CD, P.BASE_DT), 0) AS TTL_COST_AMT" ).append("\n"); 
		query.append("--     , A.USE_STRT_DT" ).append("\n"); 
		query.append("     , 0 AS COST_DYS --A.COST_DYS" ).append("\n"); 
		query.append("--     , A.PYBL_USE_STRT_DT" ).append("\n"); 
		query.append("     , A.BIL_DYS" ).append("\n"); 
		query.append("     , P.USR_ID AS CRE_USR_ID" ).append("\n"); 
		query.append("     , P.USR_ID AS UPD_USR_ID" ).append("\n"); 
		query.append("FROM   CNTR_LIST_DATA A" ).append("\n"); 
		query.append("     , PARAM          P" ).append("\n"); 
		query.append("WHERE  A.ONH_STS_CD IN ('DII', 'LSI')" ).append("\n"); 
		query.append("AND    A.CNTR_LSTM_CNG_FLG <> 'Y'" ).append("\n"); 
		query.append("AND    A.ONH_DT BETWEEN P.FIRST_DT AND P.LAST_DT + 0.99999" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT P.CHG_SEQ" ).append("\n"); 
		query.append("     , A.CNTR_NO" ).append("\n"); 
		query.append("     , 'GTO' AS LSE_PAY_CHG_TP_CD" ).append("\n"); 
		query.append("     , A.AGMT_CTY_CD" ).append("\n"); 
		query.append("     , A.AGMT_SEQ" ).append("\n"); 
		query.append("     , A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("     , TO_CHAR(A.ONH_DT,'YYYYMMDD')  AS ONH_DT" ).append("\n"); 
		query.append("     , TO_CHAR(A.OFFH_DT,'YYYYMMDD') AS OFFH_DT" ).append("\n"); 
		query.append("     , A.ONH_LOC_CD" ).append("\n"); 
		query.append("     , A.OFFH_LOC_CD" ).append("\n"); 
		query.append("     , A.CHG_FREE_DYS" ).append("\n"); 
		query.append("--     , 0 AS MNTHLY_TTL_CNT" ).append("\n"); 
		query.append("     , 0 AS PD_RT_AMT --A.LFT_OF_CHG_AMT AS PD_RT_AMT" ).append("\n"); 
		query.append("     , NVL(MST_COMMON_PKG.MST_LSE_AGMT_RT_GET_FNC(P.AGMT_CTY_CD, P.AGMT_SEQ, 'GTO', A.CNTR_TPSZ_CD, A.ONH_LOC_CD, P.BASE_DT), 0) AS TTL_COST_AMT" ).append("\n"); 
		query.append("--     , A.USE_STRT_DT" ).append("\n"); 
		query.append("     , 0 AS COST_DYS --A.COST_DYS" ).append("\n"); 
		query.append("--     , A.PYBL_USE_STRT_DT" ).append("\n"); 
		query.append("     , A.BIL_DYS" ).append("\n"); 
		query.append("     , P.USR_ID AS CRE_USR_ID" ).append("\n"); 
		query.append("     , P.USR_ID AS UPD_USR_ID" ).append("\n"); 
		query.append("FROM   CNTR_LIST_DATA A" ).append("\n"); 
		query.append("     , PARAM          P" ).append("\n"); 
		query.append("WHERE  A.CNTR_LSTM_CNG_FLG <> 'Y'" ).append("\n"); 
		query.append("AND    A.OFH_STS_CD IN ('DIO', 'LSO')" ).append("\n"); 
		query.append("AND    A.OFFH_DT BETWEEN P.FIRST_DT AND P.LAST_DT + 0.99999" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT P.CHG_SEQ" ).append("\n"); 
		query.append("     , A.CNTR_NO" ).append("\n"); 
		query.append("     , 'DPP' AS LSE_PAY_CHG_TP_CD" ).append("\n"); 
		query.append("     , A.AGMT_CTY_CD" ).append("\n"); 
		query.append("     , A.AGMT_SEQ" ).append("\n"); 
		query.append("     , A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("     , TO_CHAR(A.ONH_DT,'YYYYMMDD')  AS ONH_DT" ).append("\n"); 
		query.append("     , TO_CHAR(A.OFFH_DT,'YYYYMMDD') AS OFFH_DT" ).append("\n"); 
		query.append("     , A.ONH_LOC_CD" ).append("\n"); 
		query.append("     , A.OFFH_LOC_CD" ).append("\n"); 
		query.append("     , A.CHG_FREE_DYS" ).append("\n"); 
		query.append("--     , 0 AS MNTHLY_TTL_CNT" ).append("\n"); 
		query.append("     , 0 AS PD_RT_AMT --B.AGMT_CHG_VAL AS PD_RT_AMT" ).append("\n"); 
		query.append("     , NVL(MST_COMMON_PKG.MST_LSE_AGMT_RT_GET_FNC(P.AGMT_CTY_CD, P.AGMT_SEQ, 'DPP', A.CNTR_TPSZ_CD, A.OFFH_LOC_CD, P.BASE_DT), 0) AS TTL_COST_AMT" ).append("\n"); 
		query.append("--     , A.USE_STRT_DT" ).append("\n"); 
		query.append("     , 0 AS COST_DYS --A.COST_DYS" ).append("\n"); 
		query.append("--     , A.PYBL_USE_STRT_DT" ).append("\n"); 
		query.append("     , A.BIL_DYS" ).append("\n"); 
		query.append("     , P.USR_ID AS CRE_USR_ID" ).append("\n"); 
		query.append("     , P.USR_ID AS UPD_USR_ID" ).append("\n"); 
		query.append("FROM   CNTR_LIST_DATA A" ).append("\n"); 
		query.append("     , PARAM          P" ).append("\n"); 
		query.append("WHERE  A.CNTR_LSTM_CNG_FLG <> 'Y'" ).append("\n"); 
		query.append("AND    A.OFH_STS_CD IN ('DIO', 'LSO')" ).append("\n"); 
		query.append("AND    A.OFFH_DT BETWEEN P.FIRST_DT AND P.LAST_DT + 0.99999" ).append("\n"); 
		query.append("AND    A.AGMT_SEQ = P.AGMT_SEQ" ).append("\n"); 
		query.append("AND    A.AGMT_CTY_CD = P.AGMT_CTY_CD" ).append("\n"); 
		query.append("AND    P.DPP_TP_CD = 'Y'" ).append("\n"); 

	}
}