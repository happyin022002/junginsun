/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : PayableRentalCostDBDAOPayableChargeCreationDetailRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.05.24
*@LastModifier : 
*@LastVersion : 1.0
* 2018.05.24 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containerrentalcost.payablerentalcost.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
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
	  * 2010.12.09 남궁진호 [CHM-201007442-01] LT일때 Per-Diem LCC로 변경
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
		params.put("agmt_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_cost_yrmon",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("chg_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.lse.containerrentalcost.payablerentalcost.integration").append("\n"); 
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
		query.append("WITH" ).append("\n"); 
		query.append("  CNTR_LIST_DATA AS" ).append("\n"); 
		query.append("         (" ).append("\n"); 
		query.append("           SELECT   TLS.AGMT_CTY_CD" ).append("\n"); 
		query.append("                  , TLS.AGMT_SEQ" ).append("\n"); 
		query.append("                  , TLS.LSTM_CD" ).append("\n"); 
		query.append("                  , TLS.CNTR_NO" ).append("\n"); 
		query.append("                  , TLS.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                  , TLS.ONH_DT" ).append("\n"); 
		query.append("                  , TLS.OFFH_DT" ).append("\n"); 
		query.append("                  , TLS.ONH_LOC_CD" ).append("\n"); 
		query.append("                  , TLS.OFFH_LOC_CD" ).append("\n"); 
		query.append("                  , TLS.CHG_FREE_DYS" ).append("\n"); 
		query.append("                  , TLS.USE_STRT_DT" ).append("\n"); 
		query.append("                  , NVL(TLS.OFFH_DT, LAST_DAY(TO_DATE(@[chg_cost_yrmon],'YYYYMM'))) - TLS.USE_STRT_DT + 1 AS COST_DYS -- TTL_DYS" ).append("\n"); 
		query.append("                  , TLS.PYBL_USE_STRT_DT" ).append("\n"); 
		query.append("                  , CASE WHEN TLS.PYBL_USE_STRT_DT <= NVL(TLS.OFFH_DT, LAST_DAY(TO_DATE(@[chg_cost_yrmon],'YYYYMM'))) + 0.99999 THEN NVL(TLS.OFFH_DT, LAST_DAY(TO_DATE(@[chg_cost_yrmon],'YYYYMM'))) - TLS.PYBL_USE_STRT_DT + 1 ELSE 0 END BIL_DYS" ).append("\n"); 
		query.append("                  , TLS.CNTR_LSTM_CNG_FLG" ).append("\n"); 
		query.append("                  , TLS.ONH_STS_CD" ).append("\n"); 
		query.append("                  , TLS.OFH_STS_CD" ).append("\n"); 
		query.append("                  , TLS.LFT_ON_CHG_AMT" ).append("\n"); 
		query.append("                  , TLS.LFT_OF_CHG_AMT" ).append("\n"); 
		query.append("                  , TLS.PUC_PCR_CHG_AMT" ).append("\n"); 
		query.append("                  , TLS.DOC_DCR_CHG_AMT" ).append("\n"); 
		query.append("                  , TLS.ONH_YD_CD" ).append("\n"); 
		query.append("                  , DECODE(TLS.LSTM_CD,'LT',CHT.LCC_CD,LOC.SCC_CD) AS ONH_YD_SCC_CD" ).append("\n"); 
		query.append("           FROM     (" ).append("\n"); 
		query.append("                      SELECT   OF_LSI_DATA.AGMT_CTY_CD" ).append("\n"); 
		query.append("                             , OF_LSI_DATA.AGMT_SEQ" ).append("\n"); 
		query.append("                             , OF_LSI_DATA.LSTM_CD" ).append("\n"); 
		query.append("                             , OF_LSO_DATA.CNTR_NO" ).append("\n"); 
		query.append("                             , OF_LSO_DATA.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                             , OF_LSI_DATA.CNTR_STS_CD      AS ONH_STS_CD" ).append("\n"); 
		query.append("                             , OF_LSI_DATA.CNTR_STS_EVNT_DT AS ONH_DT" ).append("\n"); 
		query.append("                             , OF_LSI_DATA.LOC_CD           AS ONH_LOC_CD" ).append("\n"); 
		query.append("                             , OF_LSO_DATA.CNTR_STS_CD      AS OFH_STS_CD" ).append("\n"); 
		query.append("                             , OF_LSO_DATA.CNTR_STS_EVNT_DT AS OFFH_DT" ).append("\n"); 
		query.append("                             , OF_LSO_DATA.LOC_CD           AS OFFH_LOC_CD" ).append("\n"); 
		query.append("                             , OF_LSO_DATA.CNTR_LFT_CHG_AMT" ).append("\n"); 
		query.append("                             , OF_LSO_DATA.CNTR_LSTM_CNG_FLG" ).append("\n"); 
		query.append("                             , OF_LSI_DATA.RNTL_CHG_FREE_DYS AS CHG_FREE_DYS" ).append("\n"); 
		query.append("                             , CASE WHEN TO_CHAR(OF_LSI_DATA.CNTR_STS_EVNT_DT, 'YYYYMM') = TO_CHAR(TO_DATE(@[chg_cost_yrmon], 'YYYYMM'), 'YYYYMM') THEN OF_LSI_DATA.CNTR_STS_EVNT_DT ELSE TO_DATE(@[chg_cost_yrmon], 'YYYYMM') END AS USE_STRT_DT" ).append("\n"); 
		query.append("                             , CASE WHEN TO_CHAR(OF_LSI_DATA.CNTR_STS_EVNT_DT + OF_LSI_DATA.RNTL_CHG_FREE_DYS, 'YYYYMM') < TO_CHAR(TO_DATE(@[chg_cost_yrmon], 'YYYYMM'), 'YYYYMM') THEN TO_DATE(@[chg_cost_yrmon], 'YYYYMM')" ).append("\n"); 
		query.append("                                    ELSE OF_LSI_DATA.CNTR_STS_EVNT_DT + OF_LSI_DATA.RNTL_CHG_FREE_DYS" ).append("\n"); 
		query.append("                               END AS PYBL_USE_STRT_DT" ).append("\n"); 
		query.append("                             , OF_LSI_DATA.CNTR_LFT_CHG_AMT  AS LFT_ON_CHG_AMT" ).append("\n"); 
		query.append("                             , OF_LSO_DATA.CNTR_LFT_CHG_AMT  AS LFT_OF_CHG_AMT" ).append("\n"); 
		query.append("                             , OF_LSI_DATA.CNTR_PKUP_CHG_AMT AS PUC_PCR_CHG_AMT" ).append("\n"); 
		query.append("                             , OF_LSO_DATA.CNTR_DRFF_CR_AMT  AS DOC_DCR_CHG_AMT" ).append("\n"); 
		query.append("                             , OF_LSI_DATA.ONH_YD_CD" ).append("\n"); 
		query.append("                      FROM     (" ).append("\n"); 
		query.append("                                 SELECT   CNTR.CNTR_NO" ).append("\n"); 
		query.append("                                        , LSI.CNTR_STS_SEQ" ).append("\n"); 
		query.append("                                        , LSI.CNTR_STS_CD" ).append("\n"); 
		query.append("                                        , LSI.CNTR_STS_EVNT_DT" ).append("\n"); 
		query.append("                                        , LSI.LOC_CD" ).append("\n"); 
		query.append("                                        , NVL(LSI.RNTL_CHG_FREE_DYS,0) AS RNTL_CHG_FREE_DYS" ).append("\n"); 
		query.append("                                        , LSI.AGMT_CTY_CD" ).append("\n"); 
		query.append("                                        , LSI.AGMT_SEQ" ).append("\n"); 
		query.append("                                        , CNTR.LSTM_CD" ).append("\n"); 
		query.append("                                        , LSI.CNTR_LFT_CHG_AMT" ).append("\n"); 
		query.append("                                        , LSI.CNTR_PKUP_CHG_AMT" ).append("\n"); 
		query.append("                                        , LSI.LCC_CD" ).append("\n"); 
		query.append("                                        , CNTR.ONH_YD_CD" ).append("\n"); 
		query.append("                                 FROM     MST_CONTAINER     CNTR" ).append("\n"); 
		query.append("                                        , MST_CNTR_STS_HIS  LSI" ).append("\n"); 
		query.append("                                 WHERE    1 = 1" ).append("\n"); 
		query.append("                                 AND      CNTR.CNTR_NO    = LSI.CNTR_NO" ).append("\n"); 
		query.append("                                 AND      LSI.CNTR_STS_EVNT_DT <= LAST_DAY(TO_DATE(@[chg_cost_yrmon],'YYYYMM')) + 0.99999" ).append("\n"); 
		query.append("                                 AND      LSI.CNTR_STS_CD IN ('DII','LSI')" ).append("\n"); 
		query.append("                                 AND      LSI.AGMT_SEQ    = @[agmt_seq]" ).append("\n"); 
		query.append("                                 AND      LSI.AGMT_CTY_CD = @[agmt_cty_cd]" ).append("\n"); 
		query.append("                               ) OF_LSI_DATA" ).append("\n"); 
		query.append("                             , (" ).append("\n"); 
		query.append("                                 SELECT   LSO.CNTR_NO" ).append("\n"); 
		query.append("                                        , CNTR.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                                        , LSO.CNTR_STS_CD" ).append("\n"); 
		query.append("                                        , DECODE(LSO.CNTR_STS_CD, 'TLL', LSO.CNTR_LOST_NTFY_DT" ).append("\n"); 
		query.append("                                                                       , LSO.CNTR_STS_EVNT_DT) AS CNTR_STS_EVNT_DT" ).append("\n"); 
		query.append("                                        , LSO.LOC_CD" ).append("\n"); 
		query.append("                                        , LSO.PRNR_STS_SEQ" ).append("\n"); 
		query.append("                                        , LSO.CNTR_LFT_CHG_AMT" ).append("\n"); 
		query.append("                                        , LSO.CNTR_LSTM_CNG_FLG" ).append("\n"); 
		query.append("                                        , LSO.CNTR_DRFF_CR_AMT" ).append("\n"); 
		query.append("                                 FROM     MST_CONTAINER     CNTR" ).append("\n"); 
		query.append("                                        , MST_CNTR_STS_HIS  LSO" ).append("\n"); 
		query.append("                                 WHERE    1 = 1" ).append("\n"); 
		query.append("                                 AND      CNTR.CNTR_NO    = LSO.CNTR_NO" ).append("\n"); 
		query.append("                                 AND      DECODE(LSO.CNTR_STS_CD, 'TLL', CNTR_LOST_NTFY_DT, CNTR_STS_EVNT_DT) BETWEEN TO_DATE(@[chg_cost_yrmon], 'YYYYMM') AND LAST_DAY(TO_DATE(@[chg_cost_yrmon],'YYYYMM')) + 0.99999" ).append("\n"); 
		query.append("                                 AND      LSO.CNTR_STS_CD IN ('TLL', 'DIO', 'LSO', 'SCR', 'SRO')" ).append("\n"); 
		query.append("                                 AND      LSO.AGMT_SEQ    = @[agmt_seq]" ).append("\n"); 
		query.append("                                 AND      LSO.AGMT_CTY_CD = @[agmt_cty_cd]" ).append("\n"); 
		query.append("                               ) OF_LSO_DATA" ).append("\n"); 
		query.append("                      WHERE    1 = 1" ).append("\n"); 
		query.append("                      AND      OF_LSI_DATA.CNTR_NO      = OF_LSO_DATA.CNTR_NO" ).append("\n"); 
		query.append("                      AND      OF_LSI_DATA.CNTR_STS_SEQ = OF_LSO_DATA.PRNR_STS_SEQ" ).append("\n"); 
		query.append("                      UNION ALL" ).append("\n"); 
		query.append("                      SELECT   LSI.AGMT_CTY_CD" ).append("\n"); 
		query.append("                             , LSI.AGMT_SEQ" ).append("\n"); 
		query.append("                             , CNTR.LSTM_CD" ).append("\n"); 
		query.append("                             , LSI.CNTR_NO" ).append("\n"); 
		query.append("                             , CNTR.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                             , LSI.CNTR_STS_CD      AS ONH_STS_CD" ).append("\n"); 
		query.append("                             , LSI.CNTR_STS_EVNT_DT AS ONH_DT" ).append("\n"); 
		query.append("                             , LSI.LOC_CD           AS ONH_LOC_CD" ).append("\n"); 
		query.append("                             , NULL                 AS OFH_STS_CD" ).append("\n"); 
		query.append("                             , NULL                 AS OFFH_DT" ).append("\n"); 
		query.append("                             , NULL                 AS OFFH_LOC_CD" ).append("\n"); 
		query.append("                             , LSI.CNTR_LFT_CHG_AMT" ).append("\n"); 
		query.append("                             , LSI.CNTR_LSTM_CNG_FLG" ).append("\n"); 
		query.append("                             , NVL(LSI.RNTL_CHG_FREE_DYS,0) AS CHG_FREE_DYS" ).append("\n"); 
		query.append("                             , CASE WHEN TO_CHAR(LSI.CNTR_STS_EVNT_DT, 'YYYYMM') = TO_CHAR(TO_DATE(@[chg_cost_yrmon], 'YYYYMM'), 'YYYYMM') THEN LSI.CNTR_STS_EVNT_DT ELSE TO_DATE(@[chg_cost_yrmon], 'YYYYMM') END AS USE_STRT_DT" ).append("\n"); 
		query.append("                             , CASE WHEN TO_CHAR(LSI.CNTR_STS_EVNT_DT + NVL(LSI.RNTL_CHG_FREE_DYS,0), 'YYYYMM') < TO_CHAR(TO_DATE(@[chg_cost_yrmon], 'YYYYMM'), 'YYYYMM') THEN TO_DATE(@[chg_cost_yrmon], 'YYYYMM')" ).append("\n"); 
		query.append("                                    ELSE LSI.CNTR_STS_EVNT_DT + NVL(LSI.RNTL_CHG_FREE_DYS,0)" ).append("\n"); 
		query.append("                               END                   AS PYBL_USE_STRT_DT" ).append("\n"); 
		query.append("                             , LSI.CNTR_LFT_CHG_AMT  AS LFT_ON_CHG_AMT" ).append("\n"); 
		query.append("                             , 0                     AS LFT_OF_CHG_AMT" ).append("\n"); 
		query.append("                             , LSI.CNTR_PKUP_CHG_AMT AS PUC_PCR_CHG_AMT" ).append("\n"); 
		query.append("                             , 0                     AS DOC_DCR_CHG_AMT" ).append("\n"); 
		query.append("                             , CNTR.ONH_YD_CD" ).append("\n"); 
		query.append("                      FROM     MST_CONTAINER     CNTR" ).append("\n"); 
		query.append("                             , MST_CNTR_STS_HIS  LSI" ).append("\n"); 
		query.append("                      WHERE    1 = 1" ).append("\n"); 
		query.append("                      AND      CNTR.CNTR_NO     = LSI.CNTR_NO" ).append("\n"); 
		query.append("                      AND      LSI.AGMT_SEQ     = @[agmt_seq]" ).append("\n"); 
		query.append("                      AND      LSI.AGMT_CTY_CD  = @[agmt_cty_cd]" ).append("\n"); 
		query.append("                      AND      ( LSI.ROWID ) IN" ).append("\n"); 
		query.append("                               (" ).append("\n"); 
		query.append("                                 SELECT   SUBSTR(MAX(TO_CHAR(HIS.CNTR_STS_EVNT_DT,'RRRRMMDD') || TO_CHAR(HIS.CNTR_STS_SEQ, '000000000') || HIS.ROWID), 19) AS ROW_ID" ).append("\n"); 
		query.append("                                 FROM     MST_CNTR_STS_HIS  HIS" ).append("\n"); 
		query.append("                                 WHERE    1 = 1" ).append("\n"); 
		query.append("                                 AND      HIS.CNTR_STS_CD IN ('TLL', 'DIO', 'LSO', 'DII', 'LSI', 'SCR', 'SRO','FND')" ).append("\n"); 
		query.append("                                 AND      DECODE(HIS.CNTR_STS_CD, 'TLL', HIS.CNTR_LOST_NTFY_DT, HIS.CNTR_STS_EVNT_DT) <= LAST_DAY(TO_DATE(@[chg_cost_yrmon],'YYYYMM'))" ).append("\n"); 
		query.append("                                 AND      HIS.AGMT_SEQ    = @[agmt_seq]" ).append("\n"); 
		query.append("                                 AND      HIS.AGMT_CTY_CD = @[agmt_cty_cd]" ).append("\n"); 
		query.append("                                 GROUP BY HIS.CNTR_NO " ).append("\n"); 
		query.append("                                 HAVING   SUBSTR(MAX(TO_CHAR(DECODE(HIS.CNTR_STS_CD, 'TLL', HIS.CNTR_LOST_NTFY_DT, HIS.CNTR_STS_EVNT_DT),'RRRRMMDD')" ).append("\n"); 
		query.append("                                                   || TO_CHAR(HIS.CNTR_STS_SEQ, '000000000')" ).append("\n"); 
		query.append("                                                   || HIS.CNTR_STS_CD), 19, 3)" ).append("\n"); 
		query.append("                                           IN ('DII','LSI','FND')" ).append("\n"); 
		query.append("                               )" ).append("\n"); 
		query.append("                    ) TLS" ).append("\n"); 
		query.append("                  , MDM_YARD     YARD" ).append("\n"); 
		query.append("                  , MDM_LOCATION LOC 			" ).append("\n"); 
		query.append("  	              , MDM_EQ_ORZ_CHT  CHT" ).append("\n"); 
		query.append("           WHERE    1 = 1" ).append("\n"); 
		query.append("           AND      TLS.ONH_YD_CD = YARD.YD_CD" ).append("\n"); 
		query.append("           AND      YARD.LOC_CD = LOC.LOC_CD" ).append("\n"); 
		query.append("	       AND      LOC.SCC_CD = CHT.SCC_CD" ).append("\n"); 
		query.append("         )" ).append("\n"); 
		query.append(", APP_PDGM_DATA AS" ).append("\n"); 
		query.append("         (" ).append("\n"); 
		query.append("           SELECT   PDGVA.AGMT_CTY_CD" ).append("\n"); 
		query.append("                  , PDGVA.AGMT_SEQ" ).append("\n"); 
		query.append("                  , PDGVA.PDGV_SCC_CD" ).append("\n"); 
		query.append("                  , PDGVA.TEU_NO" ).append("\n"); 
		query.append("                  , NVL(PDGVB.TEU_NO2, 999999) AS TEU_NO2" ).append("\n"); 
		query.append("                  , PDGVA.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                  , PDGVA.PDM_RT" ).append("\n"); 
		query.append("           FROM     (" ).append("\n"); 
		query.append("                      SELECT   RT.AGMT_CTY_CD" ).append("\n"); 
		query.append("                             , RT.AGMT_SEQ" ).append("\n"); 
		query.append("                             , RANK() OVER (PARTITION BY RT.AGMT_CTY_CD, RT.AGMT_SEQ, RT.CNTR_TPSZ_CD ORDER BY RT.AGMT_CTY_CD, RT.AGMT_SEQ, RT.CNTR_TPSZ_CD, RT.AGMT_CHG_VAL) AS PDGV_RANK" ).append("\n"); 
		query.append("                             , RT.LOC_CD AS PDGV_SCC_CD" ).append("\n"); 
		query.append("                             , RT.AGMT_CHG_VAL AS TEU_NO" ).append("\n"); 
		query.append("                             , RT.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                             , RT.N1ST_CHG_AMT AS PDM_RT" ).append("\n"); 
		query.append("                      FROM     LSE_AGMT_RT RT" ).append("\n"); 
		query.append("                      WHERE    1 = 1" ).append("\n"); 
		query.append("                      AND      RT.CNTR_RNTL_CHG_TP_CD = 'PDGV'" ).append("\n"); 
		query.append("                      AND      RT.AGMT_SEQ    = @[agmt_seq] " ).append("\n"); 
		query.append("                      AND      RT.AGMT_CTY_CD = @[agmt_cty_cd]" ).append("\n"); 
		query.append("                    ) PDGVA" ).append("\n"); 
		query.append("                  , (" ).append("\n"); 
		query.append("                      SELECT   AGMT_CTY_CD" ).append("\n"); 
		query.append("                             , AGMT_SEQ" ).append("\n"); 
		query.append("                             , PDGV_RANK - 1 AS PDGV_RANK2" ).append("\n"); 
		query.append("                             , CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                             , PDGV_SCC_CD" ).append("\n"); 
		query.append("                             , TEU_NO-1 AS TEU_NO2" ).append("\n"); 
		query.append("                      FROM     (" ).append("\n"); 
		query.append("                                 SELECT   RT.AGMT_CTY_CD" ).append("\n"); 
		query.append("                                        , RT.AGMT_SEQ" ).append("\n"); 
		query.append("                                        , RANK() OVER (PARTITION BY RT.AGMT_CTY_CD, RT.AGMT_SEQ, RT.CNTR_TPSZ_CD ORDER BY RT.AGMT_CTY_CD, RT.AGMT_SEQ, RT.CNTR_TPSZ_CD, RT.AGMT_CHG_VAL) AS PDGV_RANK" ).append("\n"); 
		query.append("                                        , RT.LOC_CD AS PDGV_SCC_CD" ).append("\n"); 
		query.append("                                        , RT.AGMT_CHG_VAL AS TEU_NO" ).append("\n"); 
		query.append("                                        , RT.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                                        , RT.N1ST_CHG_AMT AS PDM_RT" ).append("\n"); 
		query.append("                                 FROM     LSE_AGMT_RT RT" ).append("\n"); 
		query.append("                                 WHERE    1 = 1" ).append("\n"); 
		query.append("                                 AND      RT.CNTR_RNTL_CHG_TP_CD = 'PDGV'" ).append("\n"); 
		query.append("                                 AND      RT.AGMT_SEQ    = @[agmt_seq] " ).append("\n"); 
		query.append("                                 AND      RT.AGMT_CTY_CD = @[agmt_cty_cd]" ).append("\n"); 
		query.append("                               ) AGMT_PDGV_DATA" ).append("\n"); 
		query.append("                      WHERE    1 = 1" ).append("\n"); 
		query.append("                      AND      PDGV_RANK > 1" ).append("\n"); 
		query.append("                    ) PDGVB" ).append("\n"); 
		query.append("           WHERE    PDGVA.AGMT_CTY_CD  = PDGVB.AGMT_CTY_CD(+) " ).append("\n"); 
		query.append("           AND      PDGVA.AGMT_SEQ     = PDGVB.AGMT_SEQ(+)" ).append("\n"); 
		query.append("           AND      PDGVA.PDGV_RANK    = PDGVB.PDGV_RANK2(+)" ).append("\n"); 
		query.append("           AND      PDGVA.CNTR_TPSZ_CD = PDGVB.CNTR_TPSZ_CD(+)" ).append("\n"); 
		query.append("           AND      PDGVA.PDGV_SCC_CD  = PDGVB.PDGV_SCC_CD(+)" ).append("\n"); 
		query.append("         )" ).append("\n"); 
		query.append("SELECT   @[chg_seq] AS CHG_SEQ" ).append("\n"); 
		query.append("       , CLD.CNTR_NO" ).append("\n"); 
		query.append("       , 'PDM' AS LSE_PAY_CHG_TP_CD" ).append("\n"); 
		query.append("       , CLD.AGMT_CTY_CD" ).append("\n"); 
		query.append("       , CLD.AGMT_SEQ" ).append("\n"); 
		query.append("       , CLD.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("       , TO_CHAR(CLD.ONH_DT,'YYYYMMDD')  AS ONH_DT" ).append("\n"); 
		query.append("       , TO_CHAR(CLD.OFFH_DT,'YYYYMMDD') AS OFFH_DT" ).append("\n"); 
		query.append("       , CLD.ONH_LOC_CD" ).append("\n"); 
		query.append("       , CLD.OFFH_LOC_CD" ).append("\n"); 
		query.append("       , CLD.CHG_FREE_DYS" ).append("\n"); 
		query.append("       , PDGT.PDM_RT AS PD_RT_AMT" ).append("\n"); 
		query.append("       , ROUND(CLD.BIL_DYS * PDGT.PDM_RT,2) AS TTL_COST_AMT" ).append("\n"); 
		query.append("       , CLD.COST_DYS" ).append("\n"); 
		query.append("       , CLD.BIL_DYS" ).append("\n"); 
		query.append("       , @[usr_id] AS CRE_USR_ID" ).append("\n"); 
		query.append("       , @[usr_id] AS UPD_USR_ID" ).append("\n"); 
		query.append("FROM     CNTR_LIST_DATA CLD" ).append("\n"); 
		query.append("       , (" ).append("\n"); 
		query.append("           SELECT   TS.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                  , NULL AS ONH_YD_SCC_CD" ).append("\n"); 
		query.append("                  , TS.MNTHLY_TTL_CNT" ).append("\n"); 
		query.append("                  , PDGM.PDM_RT" ).append("\n"); 
		query.append("           FROM     (" ).append("\n"); 
		query.append("                      SELECT   CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                             , COUNT(CNTR_NO) AS MNTHLY_TTL_CNT" ).append("\n"); 
		query.append("                      FROM     CNTR_LIST_DATA" ).append("\n"); 
		query.append("                      GROUP BY CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                    ) TS" ).append("\n"); 
		query.append("                  , APP_PDGM_DATA PDGM" ).append("\n"); 
		query.append("                  , LSE_AGREEMENT A" ).append("\n"); 
		query.append("           WHERE    1 = 1" ).append("\n"); 
		query.append("           AND      TS.CNTR_TPSZ_CD = PDGM.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("           AND      PDGM.TEU_NO <= TS.MNTHLY_TTL_CNT" ).append("\n"); 
		query.append("           AND      PDGM.TEU_NO2 >= TS.MNTHLY_TTL_CNT" ).append("\n"); 
		query.append("           AND      PDGM.AGMT_CTY_CD = A.AGMT_CTY_CD" ).append("\n"); 
		query.append("           AND      PDGM.AGMT_SEQ = A.AGMT_SEQ" ).append("\n"); 
		query.append("           AND      A.LSTM_CD <> 'LT'" ).append("\n"); 
		query.append("           UNION ALL" ).append("\n"); 
		query.append("           SELECT   TS.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                  , TS.ONH_YD_SCC_CD" ).append("\n"); 
		query.append("                  , TS.MNTHLY_TTL_CNT" ).append("\n"); 
		query.append("                  , PDGM.PDM_RT" ).append("\n"); 
		query.append("           FROM     (" ).append("\n"); 
		query.append("                      SELECT CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                           , ONH_YD_SCC_CD" ).append("\n"); 
		query.append("                           , COUNT(CNTR_NO) AS MNTHLY_TTL_CNT" ).append("\n"); 
		query.append("                      FROM   CNTR_LIST_DATA" ).append("\n"); 
		query.append("                      GROUP  BY CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                              , ONH_YD_SCC_CD" ).append("\n"); 
		query.append("                    ) TS" ).append("\n"); 
		query.append("                  , APP_PDGM_DATA PDGM" ).append("\n"); 
		query.append("                  , LSE_AGREEMENT A" ).append("\n"); 
		query.append("           WHERE    1 = 1" ).append("\n"); 
		query.append("           AND      TS.CNTR_TPSZ_CD = PDGM.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("           AND      TS.ONH_YD_SCC_CD = PDGM.PDGV_SCC_CD" ).append("\n"); 
		query.append("           AND      PDGM.AGMT_CTY_CD = A.AGMT_CTY_CD" ).append("\n"); 
		query.append("           AND      PDGM.AGMT_SEQ = A.AGMT_SEQ" ).append("\n"); 
		query.append("           AND      A.LSTM_CD = 'LT'" ).append("\n"); 
		query.append("         ) PDGT" ).append("\n"); 
		query.append("WHERE    1 = 1" ).append("\n"); 
		query.append("AND      CLD.ONH_YD_SCC_CD = DECODE(CLD.LSTM_CD, 'LT', PDGT.ONH_YD_SCC_CD, CLD.ONH_YD_SCC_CD)" ).append("\n"); 
		query.append("AND      CLD.CNTR_TPSZ_CD = PDGT.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT   @[chg_seq] AS CHG_SEQ" ).append("\n"); 
		query.append("       , CLD.CNTR_NO" ).append("\n"); 
		query.append("       , 'LON' AS LSE_PAY_CHG_TP_CD" ).append("\n"); 
		query.append("       , CLD.AGMT_CTY_CD" ).append("\n"); 
		query.append("       , CLD.AGMT_SEQ" ).append("\n"); 
		query.append("       , CLD.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("       , TO_CHAR(CLD.ONH_DT,'YYYYMMDD')  AS ONH_DT" ).append("\n"); 
		query.append("       , TO_CHAR(CLD.OFFH_DT,'YYYYMMDD') AS OFFH_DT" ).append("\n"); 
		query.append("       , CLD.ONH_LOC_CD" ).append("\n"); 
		query.append("       , CLD.OFFH_LOC_CD" ).append("\n"); 
		query.append("       , CLD.CHG_FREE_DYS" ).append("\n"); 
		query.append("       , NVL(CLD.LFT_ON_CHG_AMT, 0) AS PD_RT_AMT" ).append("\n"); 
		query.append("       , NVL(CLD.LFT_ON_CHG_AMT, 0) AS TTL_COST_AMT" ).append("\n"); 
		query.append("       , 0 AS COST_DYS --CLD.COST_DYS" ).append("\n"); 
		query.append("       , CLD.BIL_DYS" ).append("\n"); 
		query.append("       , @[usr_id] AS CRE_USR_ID" ).append("\n"); 
		query.append("       , @[usr_id] AS UPD_USR_ID" ).append("\n"); 
		query.append("FROM     CNTR_LIST_DATA CLD" ).append("\n"); 
		query.append("WHERE    CLD.ONH_STS_CD IN ('DII', 'LSI')" ).append("\n"); 
		query.append("AND      CLD.CNTR_LSTM_CNG_FLG <> 'Y'" ).append("\n"); 
		query.append("AND      CLD.ONH_DT BETWEEN TO_DATE(@[chg_cost_yrmon], 'YYYYMM') AND LAST_DAY(TO_DATE(@[chg_cost_yrmon],'YYYYMM')) + 0.99999" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT   @[chg_seq] AS CHG_SEQ" ).append("\n"); 
		query.append("       , CLD.CNTR_NO" ).append("\n"); 
		query.append("       , 'LOF' AS LSE_PAY_CHG_TP_CD" ).append("\n"); 
		query.append("       , CLD.AGMT_CTY_CD" ).append("\n"); 
		query.append("       , CLD.AGMT_SEQ" ).append("\n"); 
		query.append("       , CLD.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("       , TO_CHAR(CLD.ONH_DT,'YYYYMMDD')  AS ONH_DT" ).append("\n"); 
		query.append("       , TO_CHAR(CLD.OFFH_DT,'YYYYMMDD') AS OFFH_DT" ).append("\n"); 
		query.append("       , CLD.ONH_LOC_CD" ).append("\n"); 
		query.append("       , CLD.OFFH_LOC_CD" ).append("\n"); 
		query.append("       , CLD.CHG_FREE_DYS" ).append("\n"); 
		query.append("       , 0 AS PD_RT_AMT --CLD.LFT_OF_CHG_AMT AS PD_RT_AMT" ).append("\n"); 
		query.append("       , NVL(CLD.LFT_OF_CHG_AMT, 0) AS TTL_COST_AMT" ).append("\n"); 
		query.append("       , 0 AS COST_DYS --CLD.COST_DYS" ).append("\n"); 
		query.append("       , CLD.BIL_DYS" ).append("\n"); 
		query.append("       , @[usr_id] AS CRE_USR_ID" ).append("\n"); 
		query.append("       , @[usr_id] AS UPD_USR_ID" ).append("\n"); 
		query.append("FROM     CNTR_LIST_DATA CLD" ).append("\n"); 
		query.append("WHERE    1 = 1" ).append("\n"); 
		query.append("AND      CLD.CNTR_LSTM_CNG_FLG <> 'Y'" ).append("\n"); 
		query.append("AND      CLD.OFH_STS_CD IN ('DIO', 'LSO')" ).append("\n"); 
		query.append("AND      CLD.OFFH_DT BETWEEN TO_DATE(@[chg_cost_yrmon], 'YYYYMM') AND LAST_DAY(TO_DATE(@[chg_cost_yrmon],'YYYYMM')) + 0.99999" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT   @[chg_seq] AS CHG_SEQ" ).append("\n"); 
		query.append("       , CLD.CNTR_NO" ).append("\n"); 
		query.append("       , CASE WHEN CLD.PUC_PCR_CHG_AMT > 0 THEN 'PUC'" ).append("\n"); 
		query.append("              WHEN CLD.PUC_PCR_CHG_AMT < 0 THEN 'PCR'" ).append("\n"); 
		query.append("         END AS LSE_PAY_CHG_TP_CD" ).append("\n"); 
		query.append("       , CLD.AGMT_CTY_CD" ).append("\n"); 
		query.append("       , CLD.AGMT_SEQ" ).append("\n"); 
		query.append("       , CLD.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("       , TO_CHAR(CLD.ONH_DT,'YYYYMMDD')  AS ONH_DT" ).append("\n"); 
		query.append("       , TO_CHAR(CLD.OFFH_DT,'YYYYMMDD') AS OFFH_DT" ).append("\n"); 
		query.append("       , CLD.ONH_LOC_CD" ).append("\n"); 
		query.append("       , CLD.OFFH_LOC_CD" ).append("\n"); 
		query.append("       , CLD.CHG_FREE_DYS" ).append("\n"); 
		query.append("       , 0 AS PD_RT_AMT --CLD.PUC_PCR_CHG_AMT AS PD_RT_AMT" ).append("\n"); 
		query.append("       , NVL(CLD.PUC_PCR_CHG_AMT, 0) AS TTL_COST_AMT" ).append("\n"); 
		query.append("       , 0 AS COST_DYS --CLD.COST_DYS" ).append("\n"); 
		query.append("       , CLD.BIL_DYS" ).append("\n"); 
		query.append("       , @[usr_id] AS CRE_USR_ID" ).append("\n"); 
		query.append("       , @[usr_id] AS UPD_USR_ID" ).append("\n"); 
		query.append("FROM     CNTR_LIST_DATA CLD" ).append("\n"); 
		query.append("WHERE    (CLD.PUC_PCR_CHG_AMT > 0 OR CLD.PUC_PCR_CHG_AMT < 0)" ).append("\n"); 
		query.append("AND      CLD.ONH_STS_CD IN ('DII', 'LSI')" ).append("\n"); 
		query.append("AND      CLD.CNTR_LSTM_CNG_FLG <> 'Y'" ).append("\n"); 
		query.append("AND      CLD.ONH_DT BETWEEN TO_DATE(@[chg_cost_yrmon], 'YYYYMM') AND LAST_DAY(TO_DATE(@[chg_cost_yrmon],'YYYYMM')) + 0.99999" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT   @[chg_seq] AS CHG_SEQ" ).append("\n"); 
		query.append("       , CLD.CNTR_NO" ).append("\n"); 
		query.append("       , CASE WHEN CLD.DOC_DCR_CHG_AMT > 0 THEN 'DOC'" ).append("\n"); 
		query.append("              WHEN CLD.DOC_DCR_CHG_AMT < 0 THEN 'DCR'" ).append("\n"); 
		query.append("         END AS LSE_PAY_CHG_TP_CD" ).append("\n"); 
		query.append("       , CLD.AGMT_CTY_CD" ).append("\n"); 
		query.append("       , CLD.AGMT_SEQ" ).append("\n"); 
		query.append("       , CLD.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("       , TO_CHAR(CLD.ONH_DT,'YYYYMMDD')  AS ONH_DT" ).append("\n"); 
		query.append("       , TO_CHAR(CLD.OFFH_DT,'YYYYMMDD') AS OFFH_DT" ).append("\n"); 
		query.append("       , CLD.ONH_LOC_CD" ).append("\n"); 
		query.append("       , CLD.OFFH_LOC_CD" ).append("\n"); 
		query.append("       , CLD.CHG_FREE_DYS" ).append("\n"); 
		query.append("       , 0 AS PD_RT_AMT --CLD.DOC_DCR_CHG_AMT AS PD_RT_AMT" ).append("\n"); 
		query.append("       , NVL(CLD.DOC_DCR_CHG_AMT, 0) AS TTL_COST_AMT" ).append("\n"); 
		query.append("       , 0 AS COST_DYS --CLD.COST_DYS" ).append("\n"); 
		query.append("       , CLD.BIL_DYS" ).append("\n"); 
		query.append("       , @[usr_id] AS CRE_USR_ID" ).append("\n"); 
		query.append("       , @[usr_id] AS UPD_USR_ID" ).append("\n"); 
		query.append("FROM     CNTR_LIST_DATA CLD" ).append("\n"); 
		query.append("WHERE    1 = 1" ).append("\n"); 
		query.append("AND      ( CLD.DOC_DCR_CHG_AMT > 0 OR CLD.DOC_DCR_CHG_AMT < 0 )" ).append("\n"); 
		query.append("AND      CLD.OFH_STS_CD IN ('DIO', 'LSO')" ).append("\n"); 
		query.append("AND      CLD.OFFH_DT BETWEEN TO_DATE(@[chg_cost_yrmon], 'YYYYMM') AND LAST_DAY(TO_DATE(@[chg_cost_yrmon],'YYYYMM')) + 0.99999" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT   @[chg_seq] AS CHG_SEQ" ).append("\n"); 
		query.append("       , CLD.CNTR_NO" ).append("\n"); 
		query.append("       , 'DPP' AS LSE_PAY_CHG_TP_CD" ).append("\n"); 
		query.append("       , CLD.AGMT_CTY_CD" ).append("\n"); 
		query.append("       , CLD.AGMT_SEQ" ).append("\n"); 
		query.append("       , CLD.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("       , TO_CHAR(CLD.ONH_DT,'YYYYMMDD')  AS ONH_DT" ).append("\n"); 
		query.append("       , TO_CHAR(CLD.OFFH_DT,'YYYYMMDD') AS OFFH_DT" ).append("\n"); 
		query.append("       , CLD.ONH_LOC_CD" ).append("\n"); 
		query.append("       , CLD.OFFH_LOC_CD" ).append("\n"); 
		query.append("       , CLD.CHG_FREE_DYS" ).append("\n"); 
		query.append("       , 0 AS PD_RT_AMT --RT.AGMT_CHG_VAL AS PD_RT_AMT" ).append("\n"); 
		query.append("       , NVL(RT.AGMT_CHG_VAL, 0) AS TTL_COST_AMT" ).append("\n"); 
		query.append("       , 0 AS COST_DYS --CLD.COST_DYS" ).append("\n"); 
		query.append("       , CLD.BIL_DYS" ).append("\n"); 
		query.append("       , @[usr_id] AS CRE_USR_ID" ).append("\n"); 
		query.append("       , @[usr_id] AS UPD_USR_ID" ).append("\n"); 
		query.append("FROM     CNTR_LIST_DATA CLD" ).append("\n"); 
		query.append("       , LSE_AGMT_RT RT" ).append("\n"); 
		query.append("       , LSE_AGREEMENT A" ).append("\n"); 
		query.append("WHERE    1 = 1" ).append("\n"); 
		query.append("AND      CLD.CNTR_TPSZ_CD = RT.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("AND      CLD.AGMT_CTY_CD = RT.AGMT_CTY_CD" ).append("\n"); 
		query.append("AND      CLD.AGMT_SEQ = RT.AGMT_SEQ" ).append("\n"); 
		query.append("AND      CLD.AGMT_CTY_CD = A.AGMT_CTY_CD" ).append("\n"); 
		query.append("AND      CLD.AGMT_SEQ = A.AGMT_SEQ" ).append("\n"); 
		query.append("AND      CLD.CNTR_LSTM_CNG_FLG <> 'Y'" ).append("\n"); 
		query.append("AND      CLD.OFH_STS_CD IN ('DIO', 'LSO')" ).append("\n"); 
		query.append("AND      CLD.OFFH_DT BETWEEN TO_DATE(@[chg_cost_yrmon], 'YYYYMM') AND LAST_DAY(TO_DATE(@[chg_cost_yrmon],'YYYYMM')) + 0.99999" ).append("\n"); 
		query.append("AND      RT.CNTR_RNTL_CHG_TP_CD = 'DPPV'" ).append("\n"); 
		query.append("AND      RT.AGMT_SEQ = @[agmt_seq]" ).append("\n"); 
		query.append("AND      RT.AGMT_CTY_CD = @[agmt_cty_cd]" ).append("\n"); 
		query.append("AND      A.DPP_TP_CD = 'Y'" ).append("\n"); 

	}
}