/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AgreementRegistrationDBDAOAgreementListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.29
*@LastModifier : 
*@LastVersion : 1.0
* 2016.08.29 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containerleaseagreementregistration.agreementregistration.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AgreementRegistrationDBDAOAgreementListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Lease Agreement List Search
	  * 2010.12.02 박명신 [CHM-201007443-01] Ref No. 추가
	  * 2010.12.09 남궁진호 [CHM-201007442-01] LT일때 Per-Diem LCC로 변경
	  * </pre>
	  */
	public AgreementRegistrationDBDAOAgreementListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("exp_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("exp_from_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lstm_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.lse.containerleaseagreementregistration.agreementregistration.integration").append("\n"); 
		query.append("FileName : AgreementRegistrationDBDAOAgreementListRSQL").append("\n"); 
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
		query.append("SELECT DD.LSTM_CD" ).append("\n"); 
		query.append("     , NVL(SUBSTR(DECODE(VNDR.VNDR_ABBR_NM,'SEACO','SCO','SEACUBE','SCU',VNDR.VNDR_ABBR_NM), 0, 3), 'S.TTL') AS VNDR_ABBR_NM" ).append("\n"); 
		query.append("     , DD.AGMT_CTY_CD || LPAD(DD.AGMT_SEQ, 6, '0') AS AGMT_NO" ).append("\n"); 
		query.append("     , AGMT.LSE_CTRT_NO                            AS LSE_CTRT_NO" ).append("\n"); 
		query.append("     , AGMT.REF_NO                                 AS REF_NO" ).append("\n"); 
		query.append("     , TO_CHAR(VER.EFF_DT,'YYYYMMDD')              AS EFF_DT" ).append("\n"); 
		query.append("     , TO_CHAR(AGMT.LST_EXP_DT,'YYYYMMDD')         AS EXP_DT" ).append("\n"); 
		query.append("     , DECODE(DD.TYPE_CD, 1, 'Contract QTY', 2, 'Lease Out', 3, 'Current QTY', 4, 'Per-Diem') AS TYPE_NM" ).append("\n"); 
		query.append("     , SUM(DECODE(DD.CNTR_TPSZ_CD, 'S.TTL', DD.VAL, 0)) AS TTL" ).append("\n"); 
		query.append("#foreach($key IN ${cntr_tpsz_cd_seq})" ).append("\n"); 
		query.append("#set ($col_name='CNTR'+$velocityCount+'_QTY')" ).append("\n"); 
		query.append("     , SUM(DECODE(DD.CNTR_TPSZ_CD, '$key', DD.VAL, 0)) AS $col_name" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("FROM   (" ).append("\n"); 
		query.append("         SELECT CC.LSTM_CD" ).append("\n"); 
		query.append("              , CC.VNDR_SEQ                   AS VNDR_SEQ" ).append("\n"); 
		query.append("              , CC.AGMT_CTY_CD                AS AGMT_CTY_CD" ).append("\n"); 
		query.append("              , CC.AGMT_SEQ                   AS AGMT_SEQ" ).append("\n"); 
		query.append("              , NVL(CC.CNTR_TPSZ_CD, 'S.TTL') AS CNTR_TPSZ_CD" ).append("\n"); 
		query.append("              , TP.TYPE_CD" ).append("\n"); 
		query.append("              , DECODE(TP.TYPE_CD, 1, CC.CTRT_CNT, 2, CC.LSO_CNT, 3, CC.CURR_CNT, DECODE(CC.CURR_CNT, 0, 0, ROUND(CC.SUM_PDM_AMT/CC.CURR_CNT, 2))) AS VAL" ).append("\n"); 
		query.append("              , DECODE(GRP_ID, 1, 0, 15, 14, GRP_ID) AS GRP_ID" ).append("\n"); 
		query.append("         FROM   (" ).append("\n"); 
		query.append("                  SELECT BBB.LSTM_CD" ).append("\n"); 
		query.append("                       , BBB.VNDR_SEQ" ).append("\n"); 
		query.append("                       , BBB.AGMT_CTY_CD" ).append("\n"); 
		query.append("                       , BBB.AGMT_SEQ" ).append("\n"); 
		query.append("                       , BBB.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                       , SUM(BBB.CTRT_CNT) AS CTRT_CNT" ).append("\n"); 
		query.append("                       , SUM(BBB.LSO_CNT)  AS LSO_CNT" ).append("\n"); 
		query.append("                       , SUM(BBB.CURR_CNT) AS CURR_CNT" ).append("\n"); 
		query.append("                       , SUM(BBB.PDM_AMT)  AS SUM_PDM_AMT" ).append("\n"); 
		query.append("                       , GROUPING_ID ( BBB.LSTM_CD" ).append("\n"); 
		query.append("                                     , BBB.VNDR_SEQ" ).append("\n"); 
		query.append("                                     , BBB.AGMT_CTY_CD" ).append("\n"); 
		query.append("                                     , BBB.AGMT_SEQ" ).append("\n"); 
		query.append("                                     , BBB.CNTR_TPSZ_CD ) GRP_ID" ).append("\n"); 
		query.append("                  FROM   (" ).append("\n"); 
		query.append("                           SELECT BB.LSTM_CD" ).append("\n"); 
		query.append("                                , BB.VNDR_SEQ" ).append("\n"); 
		query.append("                                , BB.AGMT_CTY_CD" ).append("\n"); 
		query.append("                                , BB.AGMT_SEQ" ).append("\n"); 
		query.append("                                , BB.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                                , BB.LSO_CNT" ).append("\n"); 
		query.append("                                , BB.CURR_CNT" ).append("\n"); 
		query.append("                                , BB.PDM_AMT" ).append("\n"); 
		query.append("                                , NVL(GEN.AGMT_CHG_VAL, 0) AS CTRT_CNT" ).append("\n"); 
		query.append("                           FROM   (" ).append("\n"); 
		query.append("                                    SELECT AA.LSTM_CD" ).append("\n"); 
		query.append("                                         , AA.VNDR_SEQ" ).append("\n"); 
		query.append("                                         , AA.AGMT_CTY_CD" ).append("\n"); 
		query.append("                                         , AA.AGMT_SEQ" ).append("\n"); 
		query.append("                                         , AA.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                                         , SUM(AA.LSO_CNT)          AS LSO_CNT" ).append("\n"); 
		query.append("                                         , SUM(AA.CURR_CNT)         AS CURR_CNT" ).append("\n"); 
		query.append("                                         , SUM(NVL(AA.CURR_CNT*PDM.N1ST_CHG_AMT, 0)) AS PDM_AMT" ).append("\n"); 
		query.append("                                         , ROW_NUMBER() OVER ( PARTITION BY AA.AGMT_CTY_CD" ).append("\n"); 
		query.append("                                                                          , AA.AGMT_SEQ" ).append("\n"); 
		query.append("                                                                          , AA.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                                                               ORDER     BY AA.AGMT_CTY_CD" ).append("\n"); 
		query.append("                                                                          , AA.AGMT_SEQ" ).append("\n"); 
		query.append("                                                                          , AA.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                                                                          , DECODE(AA.LSTM_CD, 'LT', 1, PDM.AGMT_CHG_VAL) DESC ) RNK" ).append("\n"); 
		query.append("                                    FROM   LSE_AGMT_RT      PDM" ).append("\n"); 
		query.append("                                         , (" ).append("\n"); 
		query.append("                                            SELECT DD.LSTM_CD" ).append("\n"); 
		query.append("                                                 , DD.VNDR_SEQ" ).append("\n"); 
		query.append("                                                 , DD.AGMT_CTY_CD" ).append("\n"); 
		query.append("                                                 , DD.AGMT_SEQ" ).append("\n"); 
		query.append("                                                 , DD.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                                                 , DD.LOC_CD" ).append("\n"); 
		query.append("                                                 , DD.LSI_CNT" ).append("\n"); 
		query.append("                                                 , DD.LSO_CNT" ).append("\n"); 
		query.append("                                                 , DD.CURR_CNT" ).append("\n"); 
		query.append("                                            FROM   (" ).append("\n"); 
		query.append("                                                     SELECT CC.LSTM_CD" ).append("\n"); 
		query.append("                                                          , CC.VNDR_SEQ" ).append("\n"); 
		query.append("                                                          , CC.AGMT_CTY_CD" ).append("\n"); 
		query.append("                                                          , CC.AGMT_SEQ" ).append("\n"); 
		query.append("                                                          , CC.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                                                          , CC.LOC_CD" ).append("\n"); 
		query.append("                                                          , CC.LSI_CNT" ).append("\n"); 
		query.append("                                                          , CC.LSO_CNT" ).append("\n"); 
		query.append("                                                          , CC.CURR_CNT" ).append("\n"); 
		query.append("                                                          , SUM(CC.CURR_CNT) OVER ( PARTITION BY CC.LSTM_CD" ).append("\n"); 
		query.append("                                                                                            , CC.VNDR_SEQ" ).append("\n"); 
		query.append("                                                                                            , CC.AGMT_CTY_CD" ).append("\n"); 
		query.append("                                                                                            , CC.AGMT_SEQ ) AS TTL_CURR_CNT" ).append("\n"); 
		query.append("                                                     FROM   (" ).append("\n"); 
		query.append("                                                              SELECT /*+ USE_NL(AGMT LSI LSO CNTR YARD LOC) */" ).append("\n"); 
		query.append("                                                                     AGMT.LSTM_CD" ).append("\n"); 
		query.append("                                                                   , AGMT.VNDR_SEQ" ).append("\n"); 
		query.append("                                                                   , AGMT.AGMT_CTY_CD" ).append("\n"); 
		query.append("                                                                   , AGMT.AGMT_SEQ" ).append("\n"); 
		query.append("                                                                   , CNTR.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                                                                   , COUNT(LSI.CNTR_STS_EVNT_DT) AS LSI_CNT" ).append("\n"); 
		query.append("                                                                   , COUNT(LSO.CNTR_STS_EVNT_DT) AS LSO_CNT" ).append("\n"); 
		query.append("                                                                   , COUNT(LSI.CNTR_STS_EVNT_DT) - COUNT(LSO.CNTR_STS_EVNT_DT) AS CURR_CNT" ).append("\n"); 
		query.append("                                                                   , DECODE(AGMT.LSTM_CD, 'LT', CHT.LCC_CD, 'KRSEL') AS LOC_CD" ).append("\n"); 
		query.append("                                                              FROM   LSE_AGREEMENT    AGMT" ).append("\n"); 
		query.append("                                                                   , MST_CNTR_STS_HIS LSI" ).append("\n"); 
		query.append("                                                                   , MST_CNTR_STS_HIS LSO" ).append("\n"); 
		query.append("                                                                   , MST_CONTAINER    CNTR" ).append("\n"); 
		query.append("                                                                   , MDM_YARD         YARD" ).append("\n"); 
		query.append("                                                                   , MDM_LOCATION     LOC" ).append("\n"); 
		query.append("                                                                   , MDM_EQ_ORZ_CHT   CHT" ).append("\n"); 
		query.append("                                                              WHERE  1 = 1" ).append("\n"); 
		query.append("                                                              AND    LOC.LOC_CD       = YARD.LOC_CD" ).append("\n"); 
		query.append("                                                              AND    LOC.SCC_CD       = CHT.SCC_CD" ).append("\n"); 
		query.append("                                                              AND    YARD.YD_CD       = CNTR.ONH_YD_CD" ).append("\n"); 
		query.append("                                                              AND    LSI.CNTR_STS_CD IN ('LSI','DII','FND')" ).append("\n"); 
		query.append("                                                              AND    LSI.CNTR_NO      = LSO.CNTR_NO(+)" ).append("\n"); 
		query.append("                                                              AND    LSI.CNTR_STS_SEQ = LSO.PRNR_STS_SEQ(+)" ).append("\n"); 
		query.append("                                                              AND    LSI.CNTR_NO      = CNTR.CNTR_NO" ).append("\n"); 
		query.append("                                                              AND    LSI.AGMT_SEQ     = AGMT.AGMT_SEQ" ).append("\n"); 
		query.append("                                                              AND    LSI.AGMT_CTY_CD  = AGMT.AGMT_CTY_CD" ).append("\n"); 
		query.append("                                                              AND    AGMT.LST_EXP_DT BETWEEN TO_DATE(@[exp_from_dt], 'YYYYMMDD') AND TO_DATE(@[exp_to_dt], 'YYYYMMDD')" ).append("\n"); 
		query.append("#if ( ${ofc_cd} != '' )" ).append("\n"); 
		query.append("                                                              AND    AGMT.OFC_CD      = @[ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ( ${lstm_cd} != '' )" ).append("\n"); 
		query.append("#if ( $lstm_cd_seq.size() > 1 )" ).append("\n"); 
		query.append("                                                              AND    AGMT.LSTM_CD IN (" ).append("\n"); 
		query.append("#foreach($key IN ${lstm_cd_seq})" ).append("\n"); 
		query.append("#if($velocityCount < $lstm_cd_seq.size())" ).append("\n"); 
		query.append("                                                                                      '$key'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("                                                                                      '$key'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                                                                                     )" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("                                                              AND    AGMT.LSTM_CD = @[lstm_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${vndr_seq} != '' )" ).append("\n"); 
		query.append("                                                              AND    AGMT.VNDR_SEQ = @[vndr_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                                                              AND    AGMT.AGMT_SEQ <> 999990" ).append("\n"); 
		query.append("                                                              AND    AGMT.AGMT_ACT_FLG = 'N'" ).append("\n"); 
		query.append("                                                              GROUP  BY AGMT.AGMT_CTY_CD" ).append("\n"); 
		query.append("                                                                      , AGMT.VNDR_SEQ" ).append("\n"); 
		query.append("                                                                      , AGMT.AGMT_SEQ" ).append("\n"); 
		query.append("                                                                      , AGMT.LSTM_CD" ).append("\n"); 
		query.append("                                                                      , CNTR.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                                                                      , DECODE(AGMT.LSTM_CD, 'LT', CHT.LCC_CD, 'KRSEL')" ).append("\n"); 
		query.append("                                                            ) CC" ).append("\n"); 
		query.append("                                                   ) DD" ).append("\n"); 
		query.append("                                            WHERE  DD.TTL_CURR_CNT > 0" ).append("\n"); 
		query.append("                                           ) AA" ).append("\n"); 
		query.append("                                    WHERE  PDM.CNTR_RNTL_CHG_TP_CD(+) = 'PDGV'" ).append("\n"); 
		query.append("                                    AND    PDM.AGMT_CHG_VAL(+) <= AA.CURR_CNT" ).append("\n"); 
		query.append("                                    AND    PDM.LOC_CD(+)       = DECODE(AA.LSTM_CD,'LT',AA.LOC_CD,'KRSEL')" ).append("\n"); 
		query.append("                                    AND    PDM.CNTR_TPSZ_CD(+) = AA.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                                    AND    PDM.AGMT_SEQ(+)     = AA.AGMT_SEQ" ).append("\n"); 
		query.append("                                    AND    PDM.AGMT_CTY_CD(+)  = AA.AGMT_CTY_CD" ).append("\n"); 
		query.append("                                    GROUP  BY AA.LSTM_CD" ).append("\n"); 
		query.append("                                         , AA.VNDR_SEQ" ).append("\n"); 
		query.append("                                         , AA.AGMT_CTY_CD" ).append("\n"); 
		query.append("                                         , AA.AGMT_SEQ" ).append("\n"); 
		query.append("                                         , AA.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                                         , DECODE(AA.LSTM_CD, 'LT', 1, PDM.AGMT_CHG_VAL)" ).append("\n"); 
		query.append("                                  ) BB" ).append("\n"); 
		query.append("                                , LSE_AGMT_RT      GEN" ).append("\n"); 
		query.append("                           WHERE  BB.RNK = 1" ).append("\n"); 
		query.append("                           AND    GEN.CNTR_RNTL_CHG_TP_CD(+) = 'GENV'" ).append("\n"); 
		query.append("                           AND    GEN.CNTR_TPSZ_CD(+) = BB.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                           AND    GEN.AGMT_SEQ(+)     = BB.AGMT_SEQ" ).append("\n"); 
		query.append("                           AND    GEN.AGMT_CTY_CD(+)  = BB.AGMT_CTY_CD" ).append("\n"); 
		query.append("                         ) BBB" ).append("\n"); 
		query.append("                  GROUP  BY CUBE ( BBB.LSTM_CD" ).append("\n"); 
		query.append("                                 , BBB.VNDR_SEQ" ).append("\n"); 
		query.append("                                 , BBB.AGMT_CTY_CD" ).append("\n"); 
		query.append("                                 , BBB.AGMT_SEQ" ).append("\n"); 
		query.append("                                 , BBB.CNTR_TPSZ_CD )" ).append("\n"); 
		query.append("                ) CC" ).append("\n"); 
		query.append("              , ( SELECT LEVEL TYPE_CD FROM DUAL CONNECT BY LEVEL <= 4 ) TP" ).append("\n"); 
		query.append("         WHERE  ( GRP_ID = 0 OR GRP_ID = 1 OR GRP_ID = 14 OR GRP_ID = 15 )" ).append("\n"); 
		query.append("       ) DD" ).append("\n"); 
		query.append("     , LSE_AGREEMENT    AGMT" ).append("\n"); 
		query.append("     , LSE_AGMT_VER     VER" ).append("\n"); 
		query.append("     , MDM_VENDOR VNDR" ).append("\n"); 
		query.append("WHERE  DD.VNDR_SEQ    = VNDR.VNDR_SEQ(+)" ).append("\n"); 
		query.append("AND    DD.AGMT_CTY_CD = AGMT.AGMT_CTY_CD(+)" ).append("\n"); 
		query.append("AND    DD.AGMT_SEQ    = AGMT.AGMT_SEQ(+)" ).append("\n"); 
		query.append("AND    DD.AGMT_CTY_CD = VER.AGMT_CTY_CD(+)" ).append("\n"); 
		query.append("AND    DD.AGMT_SEQ    = VER.AGMT_SEQ(+)" ).append("\n"); 
		query.append("AND    VER.AGMT_VER_SEQ(+) = 1" ).append("\n"); 
		query.append("GROUP  BY DD.LSTM_CD" ).append("\n"); 
		query.append("        , VNDR.VNDR_ABBR_NM" ).append("\n"); 
		query.append("        , DD.AGMT_CTY_CD" ).append("\n"); 
		query.append("        , DD.AGMT_SEQ" ).append("\n"); 
		query.append("        , AGMT.REF_NO" ).append("\n"); 
		query.append("        , VER.EFF_DT" ).append("\n"); 
		query.append("        , AGMT.LST_EXP_DT" ).append("\n"); 
		query.append("        , DD.TYPE_CD" ).append("\n"); 
		query.append("        , DD.GRP_ID" ).append("\n"); 
		query.append("        , AGMT.LSE_CTRT_NO" ).append("\n"); 
		query.append("ORDER  BY DD.LSTM_CD, DD.GRP_ID, DD.AGMT_SEQ, DD.TYPE_CD" ).append("\n"); 

	}
}