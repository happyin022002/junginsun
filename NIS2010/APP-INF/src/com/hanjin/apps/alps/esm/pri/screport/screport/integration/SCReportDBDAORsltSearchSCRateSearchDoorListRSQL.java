/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SCReportDBDAORsltSearchSCRateSearchDoorListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.24
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2015.06.24 최성환
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.screport.screport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sunghwan Choi
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCReportDBDAORsltSearchSCRateSearchDoorListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * US Route Cost Inquiry Door List
	  * 2015.06.30 최성환 [CHM-201536493] Split03-주간 MAS Open에 따른 타모듈 프로그램 적용 요청
	  * </pre>
	  */
	public SCReportDBDAORsltSearchSCRateSearchDoorListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmdt_hdr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gen_spcl_rt_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prop_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("amdt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rout_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.screport.screport.integration").append("\n"); 
		query.append("FileName : SCReportDBDAORsltSearchSCRateSearchDoorListRSQL").append("\n"); 
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
		query.append("AR AS   (" ).append("\n"); 
		query.append("SELECT  @[prop_no]           AS PROP_NO            ," ).append("\n"); 
		query.append("        TO_NUMBER(@[amdt_seq])          AS AMDT_SEQ           ," ).append("\n"); 
		query.append("        @[svc_scp_cd]        AS SVC_SCP_CD         ," ).append("\n"); 
		query.append("        @[gen_spcl_rt_tp_cd] AS GEN_SPCL_RT_TP_CD  ," ).append("\n"); 
		query.append("        TO_NUMBER(@[cmdt_hdr_seq]) AS CMDT_HDR_SEQ       ," ).append("\n"); 
		query.append("        TO_NUMBER(@[rout_seq])          AS ROUT_SEQ           ," ).append("\n"); 
		query.append("        TO_NUMBER(@[rt_seq])            AS RT_SEQ" ).append("\n"); 
		query.append("FROM        DUAL" ).append("\n"); 
		query.append(")   ," ).append("\n"); 
		query.append("DE AS (" ).append("\n"); 
		query.append("SELECT  FM_LOC_CD       ," ).append("\n"); 
		query.append("                FM_ECC_CD       ," ).append("\n"); 
		query.append("                FM_LCC_CD       ," ).append("\n"); 
		query.append("                FM_RCC_CD       ," ).append("\n"); 
		query.append("                HUB_LOC_CD  ," ).append("\n"); 
		query.append("                HUB_ECC_CD  ," ).append("\n"); 
		query.append("                HUB_LCC_CD  ," ).append("\n"); 
		query.append("                HUB_RCC_CD  ," ).append("\n"); 
		query.append("                TO_LOC_CD       ," ).append("\n"); 
		query.append("                TO_ECC_CD       ," ).append("\n"); 
		query.append("                TO_LCC_CD       ," ).append("\n"); 
		query.append("                TO_RCC_CD       ," ).append("\n"); 
		query.append("                RAT_UT_CD       ," ).append("\n"); 
		query.append("                CNTR_SZ_CD" ).append("\n"); 
		query.append("FROM        (" ).append("\n"); 
		query.append("                SELECT  RT.FM_LOC_CD                    ," ).append("\n"); 
		query.append("                                E1.ECC_CD   FM_ECC_CD       ," ).append("\n"); 
		query.append("                                E1.LCC_CD   FM_LCC_CD       ," ).append("\n"); 
		query.append("                                E1.RCC_CD FM_RCC_CD     ," ).append("\n"); 
		query.append("                                SUBSTR(IR.HUB_NOD_CD, 1, 5)                     HUB_LOC_CD  ," ).append("\n"); 
		query.append("                                E2.ECC_CD   HUB_ECC_CD  ," ).append("\n"); 
		query.append("                                E2.LCC_CD   HUB_LCC_CD  ," ).append("\n"); 
		query.append("                                E2.RCC_CD HUB_RCC_CD    ," ).append("\n"); 
		query.append("                                RT.TO_LOC_CD                    ," ).append("\n"); 
		query.append("                                E3.ECC_CD   TO_ECC_CD       ," ).append("\n"); 
		query.append("                                E3.LCC_CD   TO_LCC_CD       ," ).append("\n"); 
		query.append("                                E3.RCC_CD TO_RCC_CD     ," ).append("\n"); 
		query.append("                                RT.RAT_UT_CD                    ," ).append("\n"); 
		query.append("                                ( SELECT A.CNTR_SZ_CD FROM PRI_RAT_UT A WHERE A.RAT_UT_CD = RT.RAT_UT_CD )  CNTR_SZ_CD  ," ).append("\n"); 
		query.append("                                ROW_NUMBER() OVER ( PARTITION BY RT.FM_LOC_CD, RT.TO_LOC_CD, RT.RAT_UT_CD ORDER BY IR.ROUT_SEQ DESC ) ROW_NUMBER" ).append("\n"); 
		query.append("                FROM        (" ).append("\n"); 
		query.append("                                SELECT  DISTINCT" ).append("\n"); 
		query.append("                                                DECODE(DV.ROUT_VIA_PORT_TP_CD, 'L', DV.ROUT_VIA_PORT_DEF_CD, D1.LOC_CD) FM_LOC_CD       ," ).append("\n"); 
		query.append("                                                DECODE(DP.ROUT_PNT_LOC_TP_CD, 'L', DP.ROUT_PNT_LOC_DEF_CD, D2.LOC_CD)       TO_LOC_CD       ," ).append("\n"); 
		query.append("                                                RT.RAT_UT_CD" ).append("\n"); 
		query.append("                                FROM        AR                                                  ," ).append("\n"); 
		query.append("                                                PRI_SP_SCP_RT_CMDT_ROUT CR  ," ).append("\n"); 
		query.append("                                                PRI_SP_SCP_RT_ROUT_VIA  DV  ," ).append("\n"); 
		query.append("                                                PRI_SP_SCP_RT_ROUT_PNT  DP  ," ).append("\n"); 
		query.append("                                                PRI_SP_SCP_GRP_LOC          G1  ," ).append("\n"); 
		query.append("                                                PRI_SP_SCP_GRP_LOC_DTL  D1  ," ).append("\n"); 
		query.append("                                                PRI_SP_SCP_GRP_LOC          G2  ," ).append("\n"); 
		query.append("                                                PRI_SP_SCP_GRP_LOC_DTL  D2  ," ).append("\n"); 
		query.append("                                                PRI_SP_SCP_RT                       RT" ).append("\n"); 
		query.append("                                WHERE       DV.PROP_NO                      =   CR.PROP_NO" ).append("\n"); 
		query.append("                                AND         DV.AMDT_SEQ                     = CR.AMDT_SEQ" ).append("\n"); 
		query.append("                                AND         DV.SVC_SCP_CD                   = CR.SVC_SCP_CD" ).append("\n"); 
		query.append("                                AND         DV.GEN_SPCL_RT_TP_CD    = CR.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("                                AND         DV.CMDT_HDR_SEQ             = CR.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                                AND         DV.ROUT_SEQ                     = CR.ROUT_SEQ" ).append("\n"); 
		query.append("                                AND         DV.ORG_DEST_TP_CD           = 'D'" ).append("\n"); 
		query.append("                                AND         DP.PROP_NO                      =   CR.PROP_NO" ).append("\n"); 
		query.append("                                AND         DP.AMDT_SEQ                     = CR.AMDT_SEQ" ).append("\n"); 
		query.append("                                AND         DP.SVC_SCP_CD                   = CR.SVC_SCP_CD" ).append("\n"); 
		query.append("                                AND         DP.GEN_SPCL_RT_TP_CD    = CR.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("                                AND         DP.CMDT_HDR_SEQ             = CR.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                                AND         DP.ROUT_SEQ                     = CR.ROUT_SEQ" ).append("\n"); 
		query.append("                                AND         DP.ORG_DEST_TP_CD           = 'D'" ).append("\n"); 
		query.append("                                AND         G1.PROP_NO(+)                   = DV.PROP_NO" ).append("\n"); 
		query.append("                                AND         G1.AMDT_SEQ(+)              = DV.AMDT_SEQ" ).append("\n"); 
		query.append("                                AND         G1.SVC_SCP_CD(+)            = DV.SVC_SCP_CD" ).append("\n"); 
		query.append("                                AND         G1.PRC_GRP_LOC_CD(+)    = DV.ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append("                                AND         D1.PROP_NO(+)                   = G1.PROP_NO" ).append("\n"); 
		query.append("                                AND         D1.AMDT_SEQ(+)              = G1.AMDT_SEQ" ).append("\n"); 
		query.append("                                AND         D1.SVC_SCP_CD(+)            = G1.SVC_SCP_CD" ).append("\n"); 
		query.append("                                AND         D1.GRP_LOC_SEQ(+)           = G1.GRP_LOC_SEQ" ).append("\n"); 
		query.append("                                AND         G2.PROP_NO(+)                   = DP.PROP_NO" ).append("\n"); 
		query.append("                                AND         G2.AMDT_SEQ(+)              = DP.AMDT_SEQ" ).append("\n"); 
		query.append("                                AND         G2.SVC_SCP_CD(+)            = DP.SVC_SCP_CD" ).append("\n"); 
		query.append("                                AND         G2.PRC_GRP_LOC_CD(+)    = DP.ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("                                AND         D2.PROP_NO(+)                   = G2.PROP_NO" ).append("\n"); 
		query.append("                                AND         D2.AMDT_SEQ(+)              = G2.AMDT_SEQ" ).append("\n"); 
		query.append("                                AND         D2.SVC_SCP_CD(+)            = G2.SVC_SCP_CD" ).append("\n"); 
		query.append("                                AND         D2.GRP_LOC_SEQ(+)           = G2.GRP_LOC_SEQ" ).append("\n"); 
		query.append("                                AND         RT.PROP_NO                      =   CR.PROP_NO" ).append("\n"); 
		query.append("                                AND         RT.AMDT_SEQ                     = CR.AMDT_SEQ" ).append("\n"); 
		query.append("                                AND         RT.SVC_SCP_CD                   = CR.SVC_SCP_CD" ).append("\n"); 
		query.append("                                AND         RT.GEN_SPCL_RT_TP_CD    = CR.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("                                AND         RT.CMDT_HDR_SEQ             = CR.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                                AND         RT.ROUT_SEQ                     = CR.ROUT_SEQ" ).append("\n"); 
		query.append("                                /* 조회 조건 */" ).append("\n"); 
		query.append("                                AND         CR.PROP_NO                      = AR.PROP_NO" ).append("\n"); 
		query.append("                                AND         CR.AMDT_SEQ                     = AR.AMDT_SEQ" ).append("\n"); 
		query.append("                                AND         CR.SVC_SCP_CD                   = AR.SVC_SCP_CD" ).append("\n"); 
		query.append("                                AND         CR.GEN_SPCL_RT_TP_CD    = AR.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("                                AND         CR.CMDT_HDR_SEQ             = AR.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                                AND         CR.ROUT_SEQ                     = AR.ROUT_SEQ" ).append("\n"); 
		query.append("                                AND         RT.RT_SEQ                           = AR.RT_SEQ" ).append("\n"); 
		query.append("                                )   RT  ," ).append("\n"); 
		query.append("                                PRD_INLND_ROUT_MST  IR  ," ).append("\n"); 
		query.append("                                MDM_LOCATION                L1  ," ).append("\n"); 
		query.append("                                MDM_EQ_ORZ_CHT          E1  ," ).append("\n"); 
		query.append("                                MDM_LOCATION                L2  ," ).append("\n"); 
		query.append("                                MDM_EQ_ORZ_CHT          E2  ," ).append("\n"); 
		query.append("                                MDM_LOCATION                L3  ," ).append("\n"); 
		query.append("                                MDM_EQ_ORZ_CHT          E3" ).append("\n"); 
		query.append("                WHERE       IR.ROUT_ORG_NOD_CD      LIKE RT.FM_LOC_CD||'%'" ).append("\n"); 
		query.append("                AND         IR.ROUT_DEST_NOD_CD     LIKE RT.TO_LOC_CD||'%'" ).append("\n"); 
		query.append("                AND         IR.PRIO_SEQ                     = '1'" ).append("\n"); 
		query.append("                AND         IR.PCTL_IO_BND_CD           = 'I'" ).append("\n"); 
		query.append("                AND         NVL(IR.DELT_FLG, 'N')   = 'N'" ).append("\n"); 
		query.append("                AND         L1.LOC_CD       = SUBSTR(IR.ROUT_ORG_NOD_CD, 1, 5)" ).append("\n"); 
		query.append("                AND         E1.SCC_CD       = L1.SCC_CD" ).append("\n"); 
		query.append("                AND         L2.LOC_CD       = SUBSTR(IR.HUB_NOD_CD, 1, 5)" ).append("\n"); 
		query.append("                AND         E2.SCC_CD       = L2.SCC_CD" ).append("\n"); 
		query.append("                AND         L3.LOC_CD       = SUBSTR(IR.ROUT_DEST_NOD_CD, 1, 5)" ).append("\n"); 
		query.append("                AND         E3.SCC_CD       = L3.SCC_CD" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("WHERE       ROW_NUMBER  = 1" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT  FM_LOC_CD           ," ).append("\n"); 
		query.append("                HUB_LOC_CD      ," ).append("\n"); 
		query.append("                TO_LOC_CD           ," ).append("\n"); 
		query.append("                CNTR_TPSZ_CD    ," ).append("\n"); 
		query.append("                CURR_CD             ," ).append("\n"); 
		query.append("                FLOOR(TRUCKAGE / 100) * 100 +" ).append("\n"); 
		query.append("                CASE" ).append("\n"); 
		query.append("                WHEN MOD(TRUCKAGE, 100) BETWEEN 1       AND 25 THEN 25" ).append("\n"); 
		query.append("                WHEN MOD(TRUCKAGE, 100) BETWEEN 26  AND 50 THEN 50" ).append("\n"); 
		query.append("                WHEN MOD(TRUCKAGE, 100) BETWEEN 51  AND 75 THEN 75" ).append("\n"); 
		query.append("                WHEN MOD(TRUCKAGE, 100) BETWEEN 76  AND 99 THEN 100" ).append("\n"); 
		query.append("                ELSE 0" ).append("\n"); 
		query.append("                END TRUCKAGE ," ).append("\n"); 
		query.append("				'' AS PROP_NO           , -- param" ).append("\n"); 
		query.append("				'' AS AMDT_SEQ          , -- param" ).append("\n"); 
		query.append("				'' AS SVC_SCP_CD        , -- param" ).append("\n"); 
		query.append("				'' AS GEN_SPCL_RT_TP_CD , -- param" ).append("\n"); 
		query.append("				'' AS CMDT_HDR_SEQ      , -- param" ).append("\n"); 
		query.append("				'' AS ROUT_SEQ          , -- param" ).append("\n"); 
		query.append("				'' AS RT_SEQ              -- param" ).append("\n"); 
		query.append("FROM        (" ).append("\n"); 
		query.append("                SELECT  FM_LOC_CD           ," ).append("\n"); 
		query.append("                                HUB_LOC_CD      ," ).append("\n"); 
		query.append("                                TO_LOC_CD           ," ).append("\n"); 
		query.append("                                CNTR_TPSZ_CD    ," ).append("\n"); 
		query.append("                                'USD'   CURR_CD ," ).append("\n"); 
		query.append("                                ROUND( COALESCE(" ).append("\n"); 
		query.append("                                    SUM(DECODE(COST_LOC_GRP_CD, 'C', STND_COST_USD_AMT))    ," ).append("\n"); 
		query.append("                                    SUM(DECODE(COST_LOC_GRP_CD, 'E', STND_COST_USD_AMT))    ," ).append("\n"); 
		query.append("                                    SUM(DECODE(COST_LOC_GRP_CD, 'L', STND_COST_USD_AMT))    ," ).append("\n"); 
		query.append("                                    SUM(DECODE(COST_LOC_GRP_CD, 'R', STND_COST_USD_AMT))" ).append("\n"); 
		query.append("                                ), 0)   TRUCKAGE" ).append("\n"); 
		query.append("                FROM        (" ).append("\n"); 
		query.append("                                SELECT  DE.FM_LOC_CD                    ," ).append("\n"); 
		query.append("                                                DE.HUB_LOC_CD                   ," ).append("\n"); 
		query.append("                                                DE.TO_LOC_CD                    ," ).append("\n"); 
		query.append("                                                ST.CNTR_TPSZ_CD             ," ).append("\n"); 
		query.append("                                                ST.COST_LOC_GRP_CD      ," ).append("\n"); 
		query.append("                                                ST.STND_COST_USD_AMT" ).append("\n"); 
		query.append("                                FROM        DE  ," ).append("\n"); 
		query.append("                                                MAS_LNK_AVG_STND_COST   ST" ).append("\n"); 
		query.append("                                WHERE       ST.COST_YRMON               = LEAST(MAS_BZC_COST_YRMON_FNC(''), TO_CHAR(SYSDATE, 'YYYYMM'))" ).append("\n"); 
		query.append("                                AND         (" ).append("\n"); 
		query.append("                                                        (" ).append("\n"); 
		query.append("                                                                ST.COST_LOC_GRP_CD  =   'C' /* LOCATION */" ).append("\n"); 
		query.append("                                                        AND ST.LNK_FM_NOD_CD        = NVL(DE.HUB_LOC_CD, DE.FM_LOC_CD)" ).append("\n"); 
		query.append("                                                        AND ST.LNK_TO_NOD_CD        = DE.TO_LOC_CD" ).append("\n"); 
		query.append("                                                        )" ).append("\n"); 
		query.append("                                                        OR" ).append("\n"); 
		query.append("                                                        (" ).append("\n"); 
		query.append("                                                                ST.COST_LOC_GRP_CD  =   'E' /* ECC */" ).append("\n"); 
		query.append("                                                        AND ST.LNK_FM_NOD_CD        = NVL(DE.HUB_ECC_CD, DE.FM_ECC_CD)" ).append("\n"); 
		query.append("                                                        AND ST.LNK_TO_NOD_CD        = DE.TO_ECC_CD" ).append("\n"); 
		query.append("                                                        )" ).append("\n"); 
		query.append("                                                        OR" ).append("\n"); 
		query.append("                                                        (" ).append("\n"); 
		query.append("                                                                ST.COST_LOC_GRP_CD  =   'L' /* LCC */" ).append("\n"); 
		query.append("                                                        AND ST.LNK_FM_NOD_CD        = NVL(DE.HUB_LCC_CD, DE.FM_LCC_CD)" ).append("\n"); 
		query.append("                                                        AND ST.LNK_TO_NOD_CD        = DE.TO_LCC_CD" ).append("\n"); 
		query.append("                                                        )" ).append("\n"); 
		query.append("                                                        OR" ).append("\n"); 
		query.append("                                                        (" ).append("\n"); 
		query.append("                                                                ST.COST_LOC_GRP_CD  =   'R' /* RCC */" ).append("\n"); 
		query.append("                                                        AND ST.LNK_FM_NOD_CD        = NVL(DE.HUB_RCC_CD, DE.FM_RCC_CD)" ).append("\n"); 
		query.append("                                                        AND ST.LNK_TO_NOD_CD        = DE.TO_RCC_CD" ).append("\n"); 
		query.append("                                                        )" ).append("\n"); 
		query.append("                                                )" ).append("\n"); 
		query.append("                                AND         (" ).append("\n"); 
		query.append("                                                                ST.CNTR_TPSZ_CD         = DE.RAT_UT_CD" ).append("\n"); 
		query.append("                                                        OR" ).append("\n"); 
		query.append("                                                        (" ).append("\n"); 
		query.append("                                                                DE.RAT_UT_CD    IN ( '20', '40', 'HC', '45', '53' )" ).append("\n"); 
		query.append("                                                AND ( SELECT A.CNTR_SZ_CD FROM MDM_CNTR_TP_SZ A WHERE A.CNTR_TPSZ_CD = ST.CNTR_TPSZ_CD )    = DE.CNTR_SZ_CD" ).append("\n"); 
		query.append("                                                        )" ).append("\n"); 
		query.append("                                                )" ).append("\n"); 
		query.append("                                AND         ST.FULL_MTY_CD          = 'F'" ).append("\n"); 
		query.append("                                AND         ST.MAS_COST_SRC_CD  = 'TRDRTD'" ).append("\n"); 
		query.append("                                AND         ST.CNTR_TPSZ_CD         <> 'BOX'" ).append("\n"); 
		query.append("                                --AND           ST.CNTR_TPSZ_CD         LIKE 'D%'" ).append("\n"); 
		query.append("                                UNION ALL" ).append("\n"); 
		query.append("                                SELECT  DE.FM_LOC_CD                    ," ).append("\n"); 
		query.append("                                                DE.HUB_LOC_CD                   ," ).append("\n"); 
		query.append("                                                DE.TO_LOC_CD                    ," ).append("\n"); 
		query.append("                                                RE.CNTR_TPSZ_CD             ," ).append("\n"); 
		query.append("                                                ST.COST_LOC_GRP_CD      ," ).append("\n"); 
		query.append("                                                ST.STND_COST_USD_AMT" ).append("\n"); 
		query.append("                                FROM        DE  ," ).append("\n"); 
		query.append("                                                MAS_LNK_AVG_STND_COST   ST  ," ).append("\n"); 
		query.append("                                                (" ).append("\n"); 
		query.append("                                                SELECT  DISTINCT" ).append("\n"); 
		query.append("                                                                SPCL_CNTR_TPSZ_CD   CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                                                FROM        MAS_SPCL_REPO_CNTR_RGST" ).append("\n"); 
		query.append("                                                WHERE       SPCL_CNTR_TPSZ_CD NOT IN ( 'Q2', 'Q4' )" ).append("\n"); 
		query.append("                                                AND         SPCL_CNTR_TPSZ_CD NOT LIKE 'RD_'" ).append("\n"); 
		query.append("                                                --AND           SPCL_CNTR_TPSZ_CD LIKE 'D%'" ).append("\n"); 
		query.append("                                                AND         DELT_FLG = 'N'" ).append("\n"); 
		query.append("                                                ) RE" ).append("\n"); 
		query.append("                                WHERE       SUBSTR(ST.CNTR_TPSZ_CD, 1, 1) = DECODE(SUBSTR(RE.CNTR_TPSZ_CD, -1),'2','2','4')" ).append("\n"); 
		query.append("                                AND         ST.COST_YRMON                   = LEAST(MAS_BZC_COST_YRMON_FNC(''), TO_CHAR(SYSDATE, 'YYYYMM'))" ).append("\n"); 
		query.append("                                AND         (" ).append("\n"); 
		query.append("                                                        (" ).append("\n"); 
		query.append("                                                                ST.COST_LOC_GRP_CD  =   'C' /* LOCATION */" ).append("\n"); 
		query.append("                                                        AND ST.LNK_FM_NOD_CD        = NVL(DE.HUB_LOC_CD, DE.FM_LOC_CD)" ).append("\n"); 
		query.append("                                                        AND ST.LNK_TO_NOD_CD        = DE.TO_LOC_CD" ).append("\n"); 
		query.append("                                                        )" ).append("\n"); 
		query.append("                                                        OR" ).append("\n"); 
		query.append("                                                        (" ).append("\n"); 
		query.append("                                                                ST.COST_LOC_GRP_CD  =   'E' /* ECC */" ).append("\n"); 
		query.append("                                                        AND ST.LNK_FM_NOD_CD        = NVL(DE.HUB_ECC_CD, DE.FM_ECC_CD)" ).append("\n"); 
		query.append("                                                        AND ST.LNK_TO_NOD_CD        = DE.TO_ECC_CD" ).append("\n"); 
		query.append("                                                        )" ).append("\n"); 
		query.append("                                                        OR" ).append("\n"); 
		query.append("                                                        (" ).append("\n"); 
		query.append("                                                                ST.COST_LOC_GRP_CD  =   'L' /* LCC */" ).append("\n"); 
		query.append("                                                        AND ST.LNK_FM_NOD_CD        = NVL(DE.HUB_LCC_CD, DE.FM_LCC_CD)" ).append("\n"); 
		query.append("                                                        AND ST.LNK_TO_NOD_CD        = DE.TO_LCC_CD" ).append("\n"); 
		query.append("                                                        )" ).append("\n"); 
		query.append("                                                        OR" ).append("\n"); 
		query.append("                                                        (" ).append("\n"); 
		query.append("                                                                ST.COST_LOC_GRP_CD  =   'R' /* RCC */" ).append("\n"); 
		query.append("                                                        AND ST.LNK_FM_NOD_CD        = NVL(DE.HUB_RCC_CD, DE.FM_RCC_CD)" ).append("\n"); 
		query.append("                                                        AND ST.LNK_TO_NOD_CD        = DE.TO_RCC_CD" ).append("\n"); 
		query.append("                                                        )" ).append("\n"); 
		query.append("                                                )" ).append("\n"); 
		query.append("                                AND         ST.FULL_MTY_CD          = 'F'" ).append("\n"); 
		query.append("                                AND         ST.MAS_COST_SRC_CD  LIKE 'SC%'" ).append("\n"); 
		query.append("                                AND         ST.CNTR_TPSZ_CD         <> 'BOX'" ).append("\n"); 
		query.append("                                AND         ST.CNTR_TPSZ_CD         IN ( '20', '40' )" ).append("\n"); 
		query.append("                                AND         (" ).append("\n"); 
		query.append("                                                                RE.CNTR_TPSZ_CD         = DE.RAT_UT_CD" ).append("\n"); 
		query.append("                                                        OR" ).append("\n"); 
		query.append("                                                        (" ).append("\n"); 
		query.append("                                                                DE.RAT_UT_CD    IN ( '20', '40', 'HC', '45', '53' )" ).append("\n"); 
		query.append("                                                AND ( SELECT A.CNTR_SZ_CD FROM MDM_CNTR_TP_SZ A WHERE A.CNTR_TPSZ_CD = RE.CNTR_TPSZ_CD )    = DE.CNTR_SZ_CD" ).append("\n"); 
		query.append("                                                        )" ).append("\n"); 
		query.append("                                                )" ).append("\n"); 
		query.append("                                )" ).append("\n"); 
		query.append("                GROUP BY" ).append("\n"); 
		query.append("                                FM_LOC_CD           ," ).append("\n"); 
		query.append("                                HUB_LOC_CD      ," ).append("\n"); 
		query.append("                                TO_LOC_CD           ," ).append("\n"); 
		query.append("                                CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                )" ).append("\n"); 

	}
}