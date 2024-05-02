/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : PreCMSimulationDBDAOSearchRevenueDetailListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.28
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.28 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.multidimensionrpt.precmsimulation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PreCMSimulationDBDAOSearchRevenueDetailListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchRevenueDetailList
	  * </pre>
	  */
	public PreCMSimulationDBDAOSearchRevenueDetailListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rat_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_def_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prc_de_term_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_def_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prc_cgo_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por_def_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pol_def_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prc_rcv_term_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.multidimensionrpt.precmsimulation.integration").append("\n"); 
		query.append("FileName : PreCMSimulationDBDAOSearchRevenueDetailListRSQL").append("\n"); 
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
		query.append("SELECT A.SVC_SCP_CD," ).append("\n"); 
		query.append("       A.CHG_CD," ).append("\n"); 
		query.append("       A.RAT_UT_CD," ).append("\n"); 
		query.append("       A.CURR_CD," ).append("\n"); 
		query.append("       A.SCG_AMT," ).append("\n"); 
		query.append("      (SELECT  TO_CHAR(ROUND(TO_NUMBER(A.SCG_AMT) / USD_LOCL_XCH_RT,2)) AS NM" ).append("\n"); 
		query.append("         FROM    GL_MON_XCH_RT" ).append("\n"); 
		query.append("        WHERE   ACCT_XCH_RT_YRMON = SUBSTR(TO_CHAR(SYSDATE,'YYYYMMDD'),0,6)" ).append("\n"); 
		query.append("        AND     CURR_CD = A.CURR_CD" ).append("\n"); 
		query.append("        AND     ACCT_XCH_RT_LVL = '1') AS ADJ_SCG_USD_AMT," ).append("\n"); 
		query.append("       A.SCG_AMT AS TRF_SCG_AMT" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("SELECT ROW_NUMBER() OVER ( PARTITION BY SP.CHG_CD," ).append("\n"); 
		query.append("                                      DECODE(SP.HNGR_BAR_USE_FLG, 'N', NULL, SR.PRC_HNGR_BAR_TP_CD) ,     " ).append("\n"); 
		query.append("                                      DECODE(SP.IO_GA_USE_FLG   , 'N', NULL, SR.IO_GA_CD          ) ,     " ).append("\n"); 
		query.append("                                      DECODE(SP.CGO_WGT_USE_FLG , 'N', NULL, SR.MIN_CGO_WGT       ) ,     " ).append("\n"); 
		query.append("                                      DECODE(SP.CGO_WGT_USE_FLG , 'N', NULL, SR.MAX_CGO_WGT       ) ,     " ).append("\n"); 
		query.append("                                      DECODE(SP.CHG_CD, 'CFR', DECODE(SR.RAT_UT_CD,'CM',SR.RAT_UT_CD,'MT',SR.RAT_UT_CD), 'CFD', DECODE(SR.RAT_UT_CD,'CM',SR.RAT_UT_CD,'MT',SR.RAT_UT_CD), NULL)     " ).append("\n"); 
		query.append("                               ORDER BY     " ).append("\n"); 
		query.append("                                      GREATEST(DECODE(SR.CMDT_CD, NULL, 0, 600), DECODE(SR.SCG_GRP_CMDT_CD, NULL, 0, 500))     " ).append("\n"); 
		query.append("                                        + DECODE(SR.POR_TP_CD, 'L', 600, 'G', 500, 'T', 400, 'R', 300, 'C', 200, 0)     " ).append("\n"); 
		query.append("                                        + DECODE(SR.POL_TP_CD, 'L', 600, 'G', 500, 'T', 400, 'R', 300, 'C', 200, 0)     " ).append("\n"); 
		query.append("                                        + DECODE(SR.POD_TP_CD, 'L', 600, 'G', 500, 'T', 400, 'R', 300, 'C', 200, 0)     " ).append("\n"); 
		query.append("                                        + DECODE(SR.DEL_TP_CD, 'L', 600, 'G', 500, 'T', 400, 'R', 300, 'C', 200, 0)     " ).append("\n"); 
		query.append("                                        + DECODE(SR.TS_PORT_CD          , NULL, 0, 600)  " ).append("\n"); 
		query.append("                                        + DECODE(SR.RAT_UT_CD, '20', 5, '40', 5, 'HC', 5, '45', 5, '53', 5, 'BL', 4, 'BX', 4, 'PC', 4, 'CM', 4, 'MT', 4, 'RM', 4, NULL, 4, 6)     " ).append("\n"); 
		query.append("                                        + DECODE(SR.PRC_CGO_TP_CD       , NULL, 0, DECODE(SR.PRC_CGO_TP_CD,'DG',3,1))     " ).append("\n"); 
		query.append("                                        + DECODE(SR.SCG_IMDG_CLSS_CD    , NULL, 0, 1)     " ).append("\n"); 
		query.append("                                        + DECODE(SR.PSA_NO              , NULL, 0, 1)     " ).append("\n"); 
		query.append("                                        + DECODE(SR.USA_SVC_MOD_CD      , NULL, 0, 1)     " ).append("\n"); 
		query.append("                                        + DECODE(SR.ORG_TRSP_MOD_CD     , NULL, 0, 1)     " ).append("\n"); 
		query.append("                                        + DECODE(SR.DEST_TRSP_MOD_CD    , NULL, 0, 1)     " ).append("\n"); 
		query.append("                                        + DECODE(SR.PRC_RCV_TERM_CD     , NULL, 0, 1)     " ).append("\n"); 
		query.append("                                        + DECODE(SR.PRC_DE_TERM_CD      , NULL, 0, 1)     " ).append("\n"); 
		query.append("                                        + DECODE(SR.VSL_SLAN_CD         , NULL, 0, 1)     " ).append("\n"); 
		query.append("                                        + DECODE(SR.SOC_FLG             , NULL, 0, 1)     " ).append("\n"); 
		query.append("                                        + DECODE(SR.DIR_CALL_FLG        , NULL, 0, 1)     " ).append("\n"); 
		query.append("                                        + DECODE(SR.SUB_TRD_CD          , NULL, 0, 1)" ).append("\n"); 
		query.append("                                        + DECODE(SR.PRC_HNGR_BAR_TP_CD  , 'S', 3, 'D', 2, 'T', 1, 0)" ).append("\n"); 
		query.append("                                        + DECODE(SR.IO_GA_CD            , NULL, 0, 1)     " ).append("\n"); 
		query.append("                                        + DECODE(SR.MIN_CGO_WGT         , NULL, 0, 1)     " ).append("\n"); 
		query.append("                                        + DECODE(SR.MAX_CGO_WGT         , NULL, 0, 1) DESC  ,    " ).append("\n"); 
		query.append("                                      DECODE(SR.CHG_CD,'DDC',DECODE('USD',SR.CURR_CD,1,DECODE(SR.CURR_CD,'USD',3,2)),1)  ,  " ).append("\n"); 
		query.append("                                      DECODE(SR.CHG_CD,'DHF',DECODE('USD',SR.CURR_CD,1,DECODE(SR.CURR_CD,'USD',3,2)),1)  ,  " ).append("\n"); 
		query.append("                                      NVL(SR.CTRT_DT, TO_DATE('19000101','YYYYMMDD')) DESC,   " ).append("\n"); 
		query.append("                                      DECODE(SR.PAY_TERM_CD, 'O', 1, 'C', 2, 'P', 3, 0)" ).append("\n"); 
		query.append("                                  ) ROW_NUMBER" ).append("\n"); 
		query.append("     , RANK() OVER ( PARTITION BY SP.CHG_CD" ).append("\n"); 
		query.append("                        ORDER BY    " ).append("\n"); 
		query.append("                          GREATEST(DECODE(SR.CMDT_CD, NULL, 0, 600), DECODE(SR.SCG_GRP_CMDT_CD, NULL, 0, 500))     " ).append("\n"); 
		query.append("                            + DECODE(SR.POR_TP_CD, 'L', 600, 'G', 500, 'T', 400, 'R', 300, 'C', 200, 0)     " ).append("\n"); 
		query.append("                            + DECODE(SR.POL_TP_CD, 'L', 600, 'G', 500, 'T', 400, 'R', 300, 'C', 200, 0)     " ).append("\n"); 
		query.append("                            + DECODE(SR.POD_TP_CD, 'L', 600, 'G', 500, 'T', 400, 'R', 300, 'C', 200, 0)     " ).append("\n"); 
		query.append("                            + DECODE(SR.DEL_TP_CD, 'L', 600, 'G', 500, 'T', 400, 'R', 300, 'C', 200, 0)     " ).append("\n"); 
		query.append("                            + DECODE(SR.TS_PORT_CD          , NULL, 0, 600)" ).append("\n"); 
		query.append("                            + DECODE(SR.RAT_UT_CD, '20', 5, '40', 5, 'HC', 5, '45', 5, '53', 5, 'BL', 4, 'BX', 4, 'PC', 4, 'CM', 4, 'MT', 4, 'RM', 4, NULL, 4, 6)     " ).append("\n"); 
		query.append("                            + DECODE(SR.PRC_CGO_TP_CD       , NULL, 0, DECODE(SR.PRC_CGO_TP_CD,'DG',3,1))     " ).append("\n"); 
		query.append("                            + DECODE(SR.SCG_IMDG_CLSS_CD    , NULL, 0, 1)     " ).append("\n"); 
		query.append("                            + DECODE(SR.PSA_NO              , NULL, 0, 1)     " ).append("\n"); 
		query.append("                            + DECODE(SR.USA_SVC_MOD_CD      , NULL, 0, 1)     " ).append("\n"); 
		query.append("                            + DECODE(SR.ORG_TRSP_MOD_CD     , NULL, 0, 1)     " ).append("\n"); 
		query.append("                            + DECODE(SR.DEST_TRSP_MOD_CD    , NULL, 0, 1)     " ).append("\n"); 
		query.append("                            + DECODE(SR.PRC_RCV_TERM_CD     , NULL, 0, 1)     " ).append("\n"); 
		query.append("                            + DECODE(SR.PRC_DE_TERM_CD      , NULL, 0, 1)     " ).append("\n"); 
		query.append("                            + DECODE(SR.VSL_SLAN_CD         , NULL, 0, 1)     " ).append("\n"); 
		query.append("                            + DECODE(SR.SOC_FLG             , NULL, 0, 1)     " ).append("\n"); 
		query.append("                            + DECODE(SR.DIR_CALL_FLG        , NULL, 0, 1)     " ).append("\n"); 
		query.append("                            + DECODE(SR.SUB_TRD_CD          , NULL, 0, 1)" ).append("\n"); 
		query.append("                            + DECODE(SR.PRC_HNGR_BAR_TP_CD  , 'S', 3, 'D', 2, 'T', 1, 0)" ).append("\n"); 
		query.append("                            + DECODE(SR.IO_GA_CD            , NULL, 0, 1)     " ).append("\n"); 
		query.append("                            + DECODE(SR.MIN_CGO_WGT         , NULL, 0, 1)     " ).append("\n"); 
		query.append("                            + DECODE(SR.MAX_CGO_WGT         , NULL, 0, 1) DESC  ,     " ).append("\n"); 
		query.append("                          DECODE(SR.CHG_CD,'DDC',DECODE('USD',SR.CURR_CD,1,DECODE(SR.CURR_CD,'USD',3,2)),1)  ,    " ).append("\n"); 
		query.append("                          DECODE(SR.CHG_CD,'DHF',DECODE('USD',SR.CURR_CD,1,DECODE(SR.CURR_CD,'USD',3,2)),1)  ,  " ).append("\n"); 
		query.append("                          NVL(SR.CTRT_DT, TO_DATE('19000101','YYYYMMDD')) DESC," ).append("\n"); 
		query.append("                          DECODE(SR.PAY_TERM_CD, 'O', 1, 'C', 2, 'P', 3, 0)       " ).append("\n"); 
		query.append("                      ) ROW_RANK" ).append("\n"); 
		query.append("     , SR.SVC_SCP_CD" ).append("\n"); 
		query.append("     , SP.CHG_CD" ).append("\n"); 
		query.append("     , SR.RAT_UT_CD" ).append("\n"); 
		query.append("     , SR.CURR_CD" ).append("\n"); 
		query.append("     , CASE WHEN SR.RAT_UT_CD != 'BL' THEN TO_CHAR(SR.SCG_AMT * @[cntr_qty])" ).append("\n"); 
		query.append("       ELSE TO_CHAR(SR.SCG_AMT)" ).append("\n"); 
		query.append("       END AS SCG_AMT" ).append("\n"); 
		query.append("  FROM PRI_SCG_RT SR" ).append("\n"); 
		query.append("     , PRI_SCG_PRF SP" ).append("\n"); 
		query.append("#if (${por_def_cd} != '')" ).append("\n"); 
		query.append("     , (SELECT POR_DEF_CD" ).append("\n"); 
		query.append("          FROM (" ).append("\n"); 
		query.append("                SELECT DISTINCT(LOC_CD) AS POR_DEF_CD" ).append("\n"); 
		query.append("                  FROM MDM_LOCATION" ).append("\n"); 
		query.append("                 WHERE DECODE(LENGTH(@[por_def_cd]), 5, LOC_CD, 3, RGN_CD, 2, CNT_CD) = @[por_def_cd]" ).append("\n"); 
		query.append("                   AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("                UNION" ).append("\n"); 
		query.append("                SELECT DISTINCT(RGN_CD) AS POR_DEF_CD" ).append("\n"); 
		query.append("                  FROM MDM_LOCATION" ).append("\n"); 
		query.append("                 WHERE DECODE(LENGTH(@[por_def_cd]), 5, LOC_CD, 3, RGN_CD, 2, CNT_CD) = @[por_def_cd]" ).append("\n"); 
		query.append("                   AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("                UNION" ).append("\n"); 
		query.append("                SELECT DISTINCT(CNT_CD) AS POR_DEF_CD" ).append("\n"); 
		query.append("                  FROM MDM_LOCATION" ).append("\n"); 
		query.append("                 WHERE DECODE(LENGTH(@[por_def_cd]), 5, LOC_CD, 3, RGN_CD, 2, CNT_CD) = @[por_def_cd]" ).append("\n"); 
		query.append("                   AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("                UNION " ).append("\n"); 
		query.append("                SELECT 'NULL' AS POR_DEF_CD" ).append("\n"); 
		query.append("                  FROM DUAL" ).append("\n"); 
		query.append("               )" ).append("\n"); 
		query.append("         UNION" ).append("\n"); 
		query.append("         SELECT A1.SCG_GRP_LOC_CD AS POR_DEF_CD" ).append("\n"); 
		query.append("          FROM PRI_SCG_GRP_LOC A1" ).append("\n"); 
		query.append("             , (" ).append("\n"); 
		query.append("                SELECT SVC_SCP_CD" ).append("\n"); 
		query.append("                     , CHG_CD" ).append("\n"); 
		query.append("                     , GRP_LOC_SEQ" ).append("\n"); 
		query.append("                  FROM PRI_SCG_GRP_LOC_DTL A" ).append("\n"); 
		query.append("                     , (SELECT POR_DEF_CD" ).append("\n"); 
		query.append("                          FROM (" ).append("\n"); 
		query.append("                                SELECT DISTINCT(LOC_CD) AS POR_DEF_CD" ).append("\n"); 
		query.append("                                  FROM MDM_LOCATION" ).append("\n"); 
		query.append("                                 WHERE DECODE(LENGTH(@[por_def_cd]), 5, LOC_CD, 3, RGN_CD, 2, CNT_CD) = @[por_def_cd]" ).append("\n"); 
		query.append("                                   AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("                                UNION" ).append("\n"); 
		query.append("                                SELECT DISTINCT(RGN_CD) AS POR_DEF_CD" ).append("\n"); 
		query.append("                                  FROM MDM_LOCATION" ).append("\n"); 
		query.append("                                 WHERE DECODE(LENGTH(@[por_def_cd]), 5, LOC_CD, 3, RGN_CD, 2, CNT_CD) = @[por_def_cd]" ).append("\n"); 
		query.append("                                   AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("                                UNION" ).append("\n"); 
		query.append("                                SELECT DISTINCT(CNT_CD) AS POR_DEF_CD" ).append("\n"); 
		query.append("                                  FROM MDM_LOCATION" ).append("\n"); 
		query.append("                                 WHERE DECODE(LENGTH(@[por_def_cd]), 5, LOC_CD, 3, RGN_CD, 2, CNT_CD) = @[por_def_cd]" ).append("\n"); 
		query.append("                                   AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("                               )" ).append("\n"); 
		query.append("                       ) B" ).append("\n"); 
		query.append("                 WHERE A.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("                   AND A.DTL_LOC_DEF_CD = B.POR_DEF_CD" ).append("\n"); 
		query.append("               ) B1" ).append("\n"); 
		query.append("         WHERE A1.SVC_SCP_CD = B1.SVC_SCP_CD" ).append("\n"); 
		query.append("           AND A1.CHG_CD = B1.CHG_CD" ).append("\n"); 
		query.append("           AND A1.GRP_LOC_SEQ = B1.GRP_LOC_SEQ" ).append("\n"); 
		query.append("           AND A1.DELT_FLG = 'N'      " ).append("\n"); 
		query.append("       ) B" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pol_def_cd} != '')" ).append("\n"); 
		query.append("     , (SELECT POL_DEF_CD" ).append("\n"); 
		query.append("          FROM (" ).append("\n"); 
		query.append("                SELECT DISTINCT(LOC_CD) AS POL_DEF_CD" ).append("\n"); 
		query.append("                  FROM MDM_LOCATION" ).append("\n"); 
		query.append("                 WHERE DECODE(LENGTH(@[pol_def_cd]), 5, LOC_CD, 3, RGN_CD, 2, CNT_CD) = @[pol_def_cd]" ).append("\n"); 
		query.append("                   AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("                UNION" ).append("\n"); 
		query.append("                SELECT DISTINCT(RGN_CD) AS POL_DEF_CD" ).append("\n"); 
		query.append("                  FROM MDM_LOCATION" ).append("\n"); 
		query.append("                 WHERE DECODE(LENGTH(@[pol_def_cd]), 5, LOC_CD, 3, RGN_CD, 2, CNT_CD) = @[pol_def_cd]" ).append("\n"); 
		query.append("                   AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("                UNION" ).append("\n"); 
		query.append("                SELECT DISTINCT(CNT_CD) AS POL_DEF_CD" ).append("\n"); 
		query.append("                  FROM MDM_LOCATION" ).append("\n"); 
		query.append("                 WHERE DECODE(LENGTH(@[pol_def_cd]), 5, LOC_CD, 3, RGN_CD, 2, CNT_CD) = @[pol_def_cd]" ).append("\n"); 
		query.append("                   AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("                UNION " ).append("\n"); 
		query.append("                SELECT 'NULL' AS POL_DEF_CD" ).append("\n"); 
		query.append("                  FROM DUAL" ).append("\n"); 
		query.append("               )" ).append("\n"); 
		query.append("         UNION" ).append("\n"); 
		query.append("         SELECT A1.SCG_GRP_LOC_CD AS POL_DEF_CD" ).append("\n"); 
		query.append("          FROM PRI_SCG_GRP_LOC A1" ).append("\n"); 
		query.append("             , (" ).append("\n"); 
		query.append("                SELECT SVC_SCP_CD" ).append("\n"); 
		query.append("                     , CHG_CD" ).append("\n"); 
		query.append("                     , GRP_LOC_SEQ" ).append("\n"); 
		query.append("                  FROM PRI_SCG_GRP_LOC_DTL A" ).append("\n"); 
		query.append("                     , (SELECT POL_DEF_CD" ).append("\n"); 
		query.append("                          FROM (" ).append("\n"); 
		query.append("                                SELECT DISTINCT(LOC_CD) AS POL_DEF_CD" ).append("\n"); 
		query.append("                                  FROM MDM_LOCATION" ).append("\n"); 
		query.append("                                 WHERE DECODE(LENGTH(@[pol_def_cd]), 5, LOC_CD, 3, RGN_CD, 2, CNT_CD) = @[pol_def_cd]" ).append("\n"); 
		query.append("                                   AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("                                UNION" ).append("\n"); 
		query.append("                                SELECT DISTINCT(RGN_CD) AS POL_DEF_CD" ).append("\n"); 
		query.append("                                  FROM MDM_LOCATION" ).append("\n"); 
		query.append("                                 WHERE DECODE(LENGTH(@[pol_def_cd]), 5, LOC_CD, 3, RGN_CD, 2, CNT_CD) = @[pol_def_cd]" ).append("\n"); 
		query.append("                                   AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("                                UNION" ).append("\n"); 
		query.append("                                SELECT DISTINCT(CNT_CD) AS POL_DEF_CD" ).append("\n"); 
		query.append("                                  FROM MDM_LOCATION" ).append("\n"); 
		query.append("                                 WHERE DECODE(LENGTH(@[pol_def_cd]), 5, LOC_CD, 3, RGN_CD, 2, CNT_CD) = @[pol_def_cd]" ).append("\n"); 
		query.append("                                   AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("                               )" ).append("\n"); 
		query.append("                       ) B" ).append("\n"); 
		query.append("                 WHERE A.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("                   AND A.DTL_LOC_DEF_CD = B.POL_DEF_CD" ).append("\n"); 
		query.append("               ) B1" ).append("\n"); 
		query.append("         WHERE A1.SVC_SCP_CD = B1.SVC_SCP_CD" ).append("\n"); 
		query.append("           AND A1.CHG_CD = B1.CHG_CD" ).append("\n"); 
		query.append("           AND A1.GRP_LOC_SEQ = B1.GRP_LOC_SEQ" ).append("\n"); 
		query.append("           AND A1.DELT_FLG = 'N'      " ).append("\n"); 
		query.append("       ) C" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pod_def_cd} != '')" ).append("\n"); 
		query.append("     , (SELECT POD_DEF_CD" ).append("\n"); 
		query.append("          FROM (" ).append("\n"); 
		query.append("                SELECT DISTINCT(LOC_CD) AS POD_DEF_CD" ).append("\n"); 
		query.append("                  FROM MDM_LOCATION" ).append("\n"); 
		query.append("                 WHERE DECODE(LENGTH(@[pod_def_cd]), 5, LOC_CD, 3, RGN_CD, 2, CNT_CD) = @[pod_def_cd]" ).append("\n"); 
		query.append("                   AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("                UNION" ).append("\n"); 
		query.append("                SELECT DISTINCT(RGN_CD) AS POD_DEF_CD" ).append("\n"); 
		query.append("                  FROM MDM_LOCATION" ).append("\n"); 
		query.append("                 WHERE DECODE(LENGTH(@[pod_def_cd]), 5, LOC_CD, 3, RGN_CD, 2, CNT_CD) = @[pod_def_cd]" ).append("\n"); 
		query.append("                   AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("                UNION" ).append("\n"); 
		query.append("                SELECT DISTINCT(CNT_CD) AS POD_DEF_CD" ).append("\n"); 
		query.append("                  FROM MDM_LOCATION" ).append("\n"); 
		query.append("                 WHERE DECODE(LENGTH(@[pod_def_cd]), 5, LOC_CD, 3, RGN_CD, 2, CNT_CD) = @[pod_def_cd]" ).append("\n"); 
		query.append("                   AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("                UNION " ).append("\n"); 
		query.append("                SELECT 'NULL' AS POD_DEF_CD" ).append("\n"); 
		query.append("                  FROM DUAL" ).append("\n"); 
		query.append("               )" ).append("\n"); 
		query.append("         UNION" ).append("\n"); 
		query.append("         SELECT A1.SCG_GRP_LOC_CD AS POD_DEF_CD" ).append("\n"); 
		query.append("          FROM PRI_SCG_GRP_LOC A1" ).append("\n"); 
		query.append("             , (" ).append("\n"); 
		query.append("                SELECT SVC_SCP_CD" ).append("\n"); 
		query.append("                     , CHG_CD" ).append("\n"); 
		query.append("                     , GRP_LOC_SEQ" ).append("\n"); 
		query.append("                  FROM PRI_SCG_GRP_LOC_DTL A" ).append("\n"); 
		query.append("                     , (SELECT POD_DEF_CD" ).append("\n"); 
		query.append("                          FROM (" ).append("\n"); 
		query.append("                                SELECT DISTINCT(LOC_CD) AS POD_DEF_CD" ).append("\n"); 
		query.append("                                  FROM MDM_LOCATION" ).append("\n"); 
		query.append("                                 WHERE DECODE(LENGTH(@[pod_def_cd]), 5, LOC_CD, 3, RGN_CD, 2, CNT_CD) = @[pod_def_cd]" ).append("\n"); 
		query.append("                                   AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("                                UNION" ).append("\n"); 
		query.append("                                SELECT DISTINCT(RGN_CD) AS POD_DEF_CD" ).append("\n"); 
		query.append("                                  FROM MDM_LOCATION" ).append("\n"); 
		query.append("                                 WHERE DECODE(LENGTH(@[pod_def_cd]), 5, LOC_CD, 3, RGN_CD, 2, CNT_CD) = @[pod_def_cd]" ).append("\n"); 
		query.append("                                   AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("                                UNION" ).append("\n"); 
		query.append("                                SELECT DISTINCT(CNT_CD) AS POD_DEF_CD" ).append("\n"); 
		query.append("                                  FROM MDM_LOCATION" ).append("\n"); 
		query.append("                                 WHERE DECODE(LENGTH(@[pod_def_cd]), 5, LOC_CD, 3, RGN_CD, 2, CNT_CD) = @[pod_def_cd]" ).append("\n"); 
		query.append("                                   AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("                               )" ).append("\n"); 
		query.append("                       ) B" ).append("\n"); 
		query.append("                 WHERE A.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("                   AND A.DTL_LOC_DEF_CD = B.POD_DEF_CD" ).append("\n"); 
		query.append("               ) B1" ).append("\n"); 
		query.append("         WHERE A1.SVC_SCP_CD = B1.SVC_SCP_CD" ).append("\n"); 
		query.append("           AND A1.CHG_CD = B1.CHG_CD" ).append("\n"); 
		query.append("           AND A1.GRP_LOC_SEQ = B1.GRP_LOC_SEQ" ).append("\n"); 
		query.append("           AND A1.DELT_FLG = 'N'      " ).append("\n"); 
		query.append("       ) D" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${del_def_cd} != '')" ).append("\n"); 
		query.append("     , (SELECT DEL_DEF_CD" ).append("\n"); 
		query.append("          FROM (" ).append("\n"); 
		query.append("                SELECT DISTINCT(LOC_CD) AS DEL_DEF_CD" ).append("\n"); 
		query.append("                  FROM MDM_LOCATION" ).append("\n"); 
		query.append("                 WHERE DECODE(LENGTH(@[del_def_cd]), 5, LOC_CD, 3, RGN_CD, 2, CNT_CD) = @[del_def_cd]" ).append("\n"); 
		query.append("                   AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("                UNION" ).append("\n"); 
		query.append("                SELECT DISTINCT(RGN_CD) AS DEL_DEF_CD" ).append("\n"); 
		query.append("                  FROM MDM_LOCATION" ).append("\n"); 
		query.append("                 WHERE DECODE(LENGTH(@[del_def_cd]), 5, LOC_CD, 3, RGN_CD, 2, CNT_CD) = @[del_def_cd]" ).append("\n"); 
		query.append("                   AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("                UNION" ).append("\n"); 
		query.append("                SELECT DISTINCT(CNT_CD) AS DEL_DEF_CD" ).append("\n"); 
		query.append("                  FROM MDM_LOCATION" ).append("\n"); 
		query.append("                 WHERE DECODE(LENGTH(@[del_def_cd]), 5, LOC_CD, 3, RGN_CD, 2, CNT_CD) = @[del_def_cd]" ).append("\n"); 
		query.append("                   AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("                UNION " ).append("\n"); 
		query.append("                SELECT 'NULL' AS DEL_DEF_CD" ).append("\n"); 
		query.append("                  FROM DUAL" ).append("\n"); 
		query.append("               )" ).append("\n"); 
		query.append("         UNION" ).append("\n"); 
		query.append("         SELECT A1.SCG_GRP_LOC_CD AS DEL_DEF_CD" ).append("\n"); 
		query.append("          FROM PRI_SCG_GRP_LOC A1" ).append("\n"); 
		query.append("             , (" ).append("\n"); 
		query.append("                SELECT SVC_SCP_CD" ).append("\n"); 
		query.append("                     , CHG_CD" ).append("\n"); 
		query.append("                     , GRP_LOC_SEQ" ).append("\n"); 
		query.append("                  FROM PRI_SCG_GRP_LOC_DTL A" ).append("\n"); 
		query.append("                     , (SELECT DEL_DEF_CD" ).append("\n"); 
		query.append("                          FROM (" ).append("\n"); 
		query.append("                                SELECT DISTINCT(LOC_CD) AS DEL_DEF_CD" ).append("\n"); 
		query.append("                                  FROM MDM_LOCATION" ).append("\n"); 
		query.append("                                 WHERE DECODE(LENGTH(@[del_def_cd]), 5, LOC_CD, 3, RGN_CD, 2, CNT_CD) = @[del_def_cd]" ).append("\n"); 
		query.append("                                   AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("                                UNION" ).append("\n"); 
		query.append("                                SELECT DISTINCT(RGN_CD) AS DEL_DEF_CD" ).append("\n"); 
		query.append("                                  FROM MDM_LOCATION" ).append("\n"); 
		query.append("                                 WHERE DECODE(LENGTH(@[del_def_cd]), 5, LOC_CD, 3, RGN_CD, 2, CNT_CD) = @[del_def_cd]" ).append("\n"); 
		query.append("                                   AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("                                UNION" ).append("\n"); 
		query.append("                                SELECT DISTINCT(CNT_CD) AS DEL_DEF_CD" ).append("\n"); 
		query.append("                                  FROM MDM_LOCATION" ).append("\n"); 
		query.append("                                 WHERE DECODE(LENGTH(@[del_def_cd]), 5, LOC_CD, 3, RGN_CD, 2, CNT_CD) = @[del_def_cd]" ).append("\n"); 
		query.append("                                   AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("                               )" ).append("\n"); 
		query.append("                       ) B" ).append("\n"); 
		query.append("                 WHERE A.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("                   AND A.DTL_LOC_DEF_CD = B.DEL_DEF_CD" ).append("\n"); 
		query.append("               ) B1" ).append("\n"); 
		query.append("         WHERE A1.SVC_SCP_CD = B1.SVC_SCP_CD" ).append("\n"); 
		query.append("           AND A1.CHG_CD = B1.CHG_CD" ).append("\n"); 
		query.append("           AND A1.GRP_LOC_SEQ = B1.GRP_LOC_SEQ" ).append("\n"); 
		query.append("           AND A1.DELT_FLG = 'N'      " ).append("\n"); 
		query.append("       ) E" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("     ,MDM_CHARGE F" ).append("\n"); 
		query.append(" WHERE SR.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("   AND SR.CHG_CD = F.CHG_CD" ).append("\n"); 
		query.append("   AND SR.SVC_SCP_CD = SP.SVC_SCP_CD" ).append("\n"); 
		query.append("   AND SR.CHG_CD = SP.CHG_CD" ).append("\n"); 
		query.append("   AND	NVL(SR.PRC_RCV_TERM_CD, 'NULL') IN (@[prc_rcv_term_cd], 'NULL')" ).append("\n"); 
		query.append("   AND	NVL(SR.PRC_DE_TERM_CD, 'NULL') IN (@[prc_de_term_cd], 'NULL')" ).append("\n"); 
		query.append("   AND	NVL(SR.PRC_CGO_TP_CD, 'NULL') IN (@[prc_cgo_tp_cd], 'NULL')" ).append("\n"); 
		query.append("#if (${por_def_cd} != '') " ).append("\n"); 
		query.append("   AND NVL(SR.POR_DEF_CD, 'NULL') = B.POR_DEF_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pol_def_cd} != '') " ).append("\n"); 
		query.append("   AND NVL(SR.POL_DEF_CD, 'NULL') = C.POL_DEF_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pod_def_cd} != '') " ).append("\n"); 
		query.append("   AND NVL(SR.POD_DEF_CD, 'NULL') = D.POD_DEF_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${del_def_cd} != '')" ).append("\n"); 
		query.append("   AND NVL(SR.DEL_DEF_CD, 'NULL') = E.DEL_DEF_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rat_ut_cd} != '')" ).append("\n"); 
		query.append("AND SR.RAT_UT_CD IN (SELECT RAT_UT_CD" ).append("\n"); 
		query.append("                       FROM (" ).append("\n"); 
		query.append("					        SELECT   @[rat_ut_cd] RAT_UT_CD FROM DUAL" ).append("\n"); 
		query.append("#if (${is_num} == 'Y')" ).append("\n"); 
		query.append("                            UNION" ).append("\n"); 
		query.append("                            SELECT   RAT_UT_CD" ).append("\n"); 
		query.append("                            FROM     PRI_RAT_UT" ).append("\n"); 
		query.append("                            WHERE    CNTR_SZ_CD = (SELECT   CNTR_SZ_CD" ).append("\n"); 
		query.append("                                                   FROM     PRI_RAT_UT" ).append("\n"); 
		query.append("                                                   WHERE    RAT_UT_CD = @[rat_ut_cd])" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("                            UNION" ).append("\n"); 
		query.append("                            SELECT RAT_UT_CD" ).append("\n"); 
		query.append("                            FROM(" ).append("\n"); 
		query.append("                                SELECT   RAT_UT_CD, RANK() OVER (ORDER BY RAT_UT_CD) RNUM" ).append("\n"); 
		query.append("                                FROM     PRI_RAT_UT" ).append("\n"); 
		query.append("                                WHERE    CNTR_SZ_CD = (SELECT   CNTR_SZ_CD" ).append("\n"); 
		query.append("                                                        FROM     PRI_RAT_UT" ).append("\n"); 
		query.append("                                                         WHERE    RAT_UT_CD = @[rat_ut_cd])" ).append("\n"); 
		query.append("                                )" ).append("\n"); 
		query.append("                            WHERE RNUM = 1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                            UNION ALL" ).append("\n"); 
		query.append("                            SELECT   RAT_UT_CD" ).append("\n"); 
		query.append("                            FROM     PRI_RAT_UT" ).append("\n"); 
		query.append("                            WHERE    CNTR_SZ_CD IS NULL" ).append("\n"); 
		query.append("                            AND (SELECT   CNTR_SZ_CD" ).append("\n"); 
		query.append("                                 FROM     PRI_RAT_UT" ).append("\n"); 
		query.append("                                 WHERE    RAT_UT_CD = @[rat_ut_cd]) IS NOT NULL" ).append("\n"); 
		query.append("                            )" ).append("\n"); 
		query.append("                      WHERE RAT_UT_CD NOT IN ('CM', 'MT', 'PC'))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND TO_DATE(TO_CHAR(SYSDATE, 'YYYYMMDD'), 'YYYY-MM-DD') BETWEEN SR.EFF_DT AND SR.EXP_DT" ).append("\n"); 
		query.append("   AND SR.DELT_FLG = 'N'" ).append("\n"); 
		query.append("   AND SR.WDR_FLG = 'N'" ).append("\n"); 
		query.append("   AND F.AUTO_RAT_FLG = 'Y'" ).append("\n"); 
		query.append("   AND SR.SCG_RQST_PROC_CD = 'A'" ).append("\n"); 
		query.append("   AND SR.SUB_TRD_CD IS NULL" ).append("\n"); 
		query.append("   AND SR.VSL_SLAN_CD IS NULL" ).append("\n"); 
		query.append("   AND SR.TS_PORT_CD IS NULL" ).append("\n"); 
		query.append("   AND SR.TML_CD IS NULL" ).append("\n"); 
		query.append("   AND SR.ORG_TRSP_MOD_CD IS NULL" ).append("\n"); 
		query.append("   AND SR.DEST_TRSP_MOD_CD IS NULL" ).append("\n"); 
		query.append("   AND SR.USA_SVC_MOD_CD IS NULL" ).append("\n"); 
		query.append("   AND SR.PRC_HNGR_BAR_TP_CD IS NULL" ).append("\n"); 
		query.append("   AND SR.DIR_CALL_FLG IS NULL" ).append("\n"); 
		query.append("   AND SR.MIN_CGO_WGT IS NULL" ).append("\n"); 
		query.append("   AND SR.MAX_CGO_WGT IS NULL" ).append("\n"); 
		query.append("   AND SR.CMDT_CD IS NULL" ).append("\n"); 
		query.append("   AND SR.SCG_GRP_CMDT_CD IS NULL" ).append("\n"); 
		query.append("   AND SR.SCG_IMDG_CLSS_CD IS NULL" ).append("\n"); 
		query.append("   AND SR.SOC_FLG IS NULL" ).append("\n"); 
		query.append("   AND SR.IO_GA_CD IS NULL" ).append("\n"); 
		query.append("   AND SR.CNL_TZ_CD IS NULL" ).append("\n"); 
		query.append("   AND SR.SCG_RMK IS NULL" ).append("\n"); 
		query.append("   AND SR.SCG_CRTE_DY_KNT IS NULL" ).append("\n"); 
		query.append("   AND SR.SCG_PRD_TP_CD IS NULL" ).append("\n"); 
		query.append("   AND SR.SCG_PRD_CRTE_CD IS NULL" ).append("\n"); 
		query.append("   AND SR.PSA_NO IS NULL" ).append("\n"); 
		query.append("   AND SR.RC_AIR_COND_TP_CD IS NULL" ).append("\n"); 
		query.append("   AND SR.ACT_RAT_FLG IS NULL" ).append("\n"); 
		query.append("   AND SR.PRN_HDN_FLG IS NULL" ).append("\n"); 
		query.append("   AND SR.FD_GRD_FLG IS NULL" ).append("\n"); 
		query.append("   AND SR.CNT_CD IS NULL" ).append("\n"); 
		query.append("   AND SR.STE_CD IS NULL) A" ).append("\n"); 
		query.append("WHERE ROW_NUMBER  = 1" ).append("\n"); 
		query.append("AND ROW_RANK = 1" ).append("\n"); 
		query.append("ORDER BY A.CHG_CD, A.RAT_UT_CD" ).append("\n"); 

	}
}