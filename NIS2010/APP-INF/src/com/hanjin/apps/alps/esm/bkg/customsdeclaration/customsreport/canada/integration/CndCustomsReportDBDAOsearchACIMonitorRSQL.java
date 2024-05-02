/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : CndCustomsReportDBDAOsearchACIMonitorRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.02.07
*@LastModifier : 
*@LastVersion : 1.0
* 2018.02.07 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.canada.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CndCustomsReportDBDAOsearchACIMonitorRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ACI 전송 및 관련 Surcharge 현황 모니터링 조회
	  * 2011.08.10 김보배 [CHM-201112720] [BKG] ACI Monitor 기능 보완
	  * </pre>
	  */
	public CndCustomsReportDBDAOsearchACIMonitorRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_b_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_pod",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_pol_yd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_from_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_to_mt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_pol",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_from_mt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rhq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.canada.integration").append("\n"); 
		query.append("FileName : CndCustomsReportDBDAOsearchACIMonitorRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append(" VVD, LANE, RHQ, BKG_OFC, POL, POD, BL_TYPE" ).append("\n"); 
		query.append(",BL_COUNT, ACCEPTED, REJECTED, DNL, RELEASED, POD_HOLD, DO_NOT_UNLOAD, NOT_RECEIVED" ).append("\n"); 
		query.append(",UNSENT, AMEND_CNT" ).append("\n"); 
		query.append(",CMS_SMC_AMT, MCF_AMT" ).append("\n"); 
		query.append(",SUM(NVL(BL_COUNT,0)) OVER()        AS BL_CNT" ).append("\n"); 
		query.append(",SUM(NVL(ACCEPTED, 0)) OVER()       AS ACCEPTED_CNT" ).append("\n"); 
		query.append(",SUM(NVL(REJECTED, 0)) OVER()       AS REJECTED_CNT" ).append("\n"); 
		query.append(",SUM(NVL(DNL, 0)) OVER()            AS DNL_CNT" ).append("\n"); 
		query.append(",SUM(NVL(RELEASED, 0)) OVER()       AS RELEASE_CNT" ).append("\n"); 
		query.append(",SUM(NVL(POD_HOLD,0)) OVER()        AS POD_HOLD_CNT" ).append("\n"); 
		query.append(",SUM(NVL(DO_NOT_UNLOAD,0)) OVER()   AS DO_NOT_UNLOAD_CNT" ).append("\n"); 
		query.append(",SUM(NVL(NOT_RECEIVED,0)) OVER()    AS NOT_RECEIVED_CNT" ).append("\n"); 
		query.append(",SUM(NVL(UNSENT,0)) OVER()          AS UNSENT_CNT" ).append("\n"); 
		query.append(",SUM(NVL(AMEND_CNT,0)) OVER()       AS AMEND_CNT2" ).append("\n"); 
		query.append(",SUM(NVL(CMS_SMC_AMT+CMS_SMC_AMT2,0)) OVER()         AS TOTAL_CMS_SMC_AMT" ).append("\n"); 
		query.append(",SUM(DECODE(RHQ,'SHARC',NVL(CMS_SMC_AMT+CMS_SMC_AMT2,0),0)) OVER() AS TOTAL_SHAAS_ENS" ).append("\n"); 
		query.append(",SUM(DECODE(RHQ,'NYCRA',NVL(CMS_SMC_AMT+CMS_SMC_AMT2,0),0)) OVER() AS TOTAL_NYCNA_ENS" ).append("\n"); 
		query.append(",SUM(DECODE(RHQ,'HAMRU',NVL(CMS_SMC_AMT+CMS_SMC_AMT2,0),0)) OVER() AS TOTAL_HAMUR_ENS" ).append("\n"); 
		query.append(",SUM(DECODE(RHQ,'SINRS',NVL(CMS_SMC_AMT+CMS_SMC_AMT2,0),0)) OVER() AS TOTAL_SINWA_ENS" ).append("\n"); 
		query.append(",SUM(NVL(MCF_AMT,0)) OVER()         AS TOTAL_MCF_AMT" ).append("\n"); 
		query.append(",SUM(DECODE(RHQ,'SHARC',NVL(MCF_AMT,0),0)) OVER() AS TOTAL_SHAAS_MCF" ).append("\n"); 
		query.append(",SUM(DECODE(RHQ,'NYCRA',NVL(MCF_AMT,0),0)) OVER() AS TOTAL_NYCNA_MCF" ).append("\n"); 
		query.append(",SUM(DECODE(RHQ,'HAMRU',NVL(MCF_AMT,0),0)) OVER() AS TOTAL_HAMUR_MCF" ).append("\n"); 
		query.append(",SUM(DECODE(RHQ,'SINRS',NVL(MCF_AMT,0),0)) OVER() AS TOTAL_SINWA_MCF" ).append("\n"); 
		query.append(",COUNT(DISTINCT VVD) OVER() AS TOTAL_VVD_CNT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("        SELECT" ).append("\n"); 
		query.append("         A.VSL_CD || A.SKD_VOY_NO || A.SKD_DIR_CD AS VVD, A.LANE, A.RHQ, A.BKG_OFC, A.POL, A.POD, A.BL_TYPE" ).append("\n"); 
		query.append("        ,COUNT(DISTINCT A.BKG_NO)                                           AS BL_COUNT" ).append("\n"); 
		query.append("        ,COUNT(DISTINCT DECODE(A.CSTMS_ACK_PROC_RSLT_CD,'06',A.BKG_NO))                     AS ACCEPTED" ).append("\n"); 
		query.append("        ,COUNT(DISTINCT DECODE(A.CSTMS_ACK_PROC_RSLT_CD,'44',A.BKG_NO))                     AS REJECTED" ).append("\n"); 
		query.append("        ,COUNT(DISTINCT DECODE(A.CSTMS_ACK_PROC_RSLT_CD,'37',A.BKG_NO))                     AS DNL" ).append("\n"); 
		query.append("        ,COUNT(DISTINCT DECODE(A.CSTMS_ACK_PROC_RSLT_CD,'01',A.BKG_NO))                     AS RELEASED" ).append("\n"); 
		query.append("        ,COUNT(DISTINCT DECODE(A.CSTMS_ACK_PROC_RSLT_CD,'21',A.BKG_NO))                     AS POD_HOLD" ).append("\n"); 
		query.append("        ,COUNT(DISTINCT DECODE(A.CSTMS_ACK_PROC_RSLT_CD,'48',A.BKG_NO))                     AS DO_NOT_UNLOAD" ).append("\n"); 
		query.append("        ,COUNT(DISTINCT DECODE(A.MF_SND_DT,NULL,NULL,DECODE(A.CSTMS_ACK_PROC_RSLT_CD,NULL,A.BKG_NO))) AS NOT_RECEIVED         " ).append("\n"); 
		query.append("        ,COUNT(DISTINCT DECODE(A.MF_SND_DT,NULL,A.BKG_NO))                                  AS UNSENT" ).append("\n"); 
		query.append("        ,COUNT (DISTINCT DECODE(A.MF_SND_DT,NULL,NULL ," ).append("\n"); 
		query.append("          DECODE(A.AMDT_SND_DT,NULL, NULL," ).append("\n"); 
		query.append("                DECODE(A.MF_SND_DT,A.AMDT_SND_DT, NULL , A.BKG_NO)  " ).append("\n"); 
		query.append("          )     " ).append("\n"); 
		query.append("         )) AS AMEND_CNT" ).append("\n"); 
		query.append("        ,SUM(NVL(DECODE(BCR_ENS.CURR_CD,'USD',BCR_ENS.CHG_AMT,(BCR_ENS.CHG_AMT)/(SELECT XCH_RT.USD_LOCL_XCH_RT FROM GL_MON_XCH_RT XCH_RT WHERE XCH_RT.ACCT_XCH_RT_YRMON IN TO_CHAR(A.VPS_ETB_DT,'YYYYMM') AND XCH_RT.CURR_CD = BCR_ENS.CURR_CD AND XCH_RT.ACCT_XCH_RT_LVL = 1)),0)) AS CMS_SMC_AMT" ).append("\n"); 
		query.append("        ,SUM(NVL(DECODE(BCR_ENS2.CURR_CD,'USD',BCR_ENS2.CHG_AMT,(BCR_ENS2.CHG_AMT)/(SELECT XCH_RT.USD_LOCL_XCH_RT FROM GL_MON_XCH_RT XCH_RT WHERE XCH_RT.ACCT_XCH_RT_YRMON IN TO_CHAR(A.VPS_ETB_DT,'YYYYMM') AND XCH_RT.CURR_CD = BCR_ENS2.CURR_CD AND XCH_RT.ACCT_XCH_RT_LVL = 1)),0)) AS CMS_SMC_AMT2" ).append("\n"); 
		query.append("        ,SUM(NVL(DECODE(BCR_MCF.CURR_CD,'USD',BCR_MCF.CHG_AMT,(BCR_MCF.CHG_AMT)/(SELECT XCH_RT.USD_LOCL_XCH_RT FROM GL_MON_XCH_RT XCH_RT WHERE XCH_RT.ACCT_XCH_RT_YRMON IN TO_CHAR(A.VPS_ETB_DT,'YYYYMM') AND XCH_RT.CURR_CD = BCR_MCF.CURR_CD AND XCH_RT.ACCT_XCH_RT_LVL = 1)),0)) AS MCF_AMT " ).append("\n"); 
		query.append("        FROM" ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("            SELECT" ).append("\n"); 
		query.append("                 A.VSL_CD " ).append("\n"); 
		query.append("                ,A.SKD_VOY_NO" ).append("\n"); 
		query.append("                ,A.SKD_DIR_CD" ).append("\n"); 
		query.append("                ,(SELECT VSL_SLAN_CD FROM VSK_VSL_SKD WHERE VSL_CD = A.VSL_CD AND SKD_VOY_NO = A.SKD_VOY_NO AND SKD_DIR_CD = A.SKD_DIR_CD) AS LANE" ).append("\n"); 
		query.append("                ,OLA.REGION AS RHQ" ).append("\n"); 
		query.append("#if (${p_rhq_gb} == 'BO')" ).append("\n"); 
		query.append(",A.BKG_OFC_CD AS BKG_OFC" ).append("\n"); 
		query.append("#elseif (${p_rhq_gb} == 'PO')" ).append("\n"); 
		query.append(",MDM_LOC.EQ_CTRL_OFC_CD AS BKG_OFC" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("                ,A.POL_CD   AS POL" ).append("\n"); 
		query.append("                ,A.POD_CD   AS POD" ).append("\n"); 
		query.append("                ,A.CSTMS_ACK_PROC_RSLT_CD" ).append("\n"); 
		query.append("                ,A.BKG_NO" ).append("\n"); 
		query.append("                ,A.MF_SND_DT" ).append("\n"); 
		query.append("                ,A.AMDT_SND_DT" ).append("\n"); 
		query.append("                ,A.VPS_ETB_DT" ).append("\n"); 
		query.append("                ,A.BL_TYPE" ).append("\n"); 
		query.append("            FROM" ).append("\n"); 
		query.append("            (" ).append("\n"); 
		query.append("                SELECT " ).append("\n"); 
		query.append("                     TB.*" ).append("\n"); 
		query.append("                FROM   (SELECT " ).append("\n"); 
		query.append("                               VVD.BKG_NO,  " ).append("\n"); 
		query.append("                               ABL.CSTMS_ACK_PROC_RSLT_CD ," ).append("\n"); 
		query.append("                               VVD.VSL_CD ," ).append("\n"); 
		query.append("                               VVD.SKD_VOY_NO ," ).append("\n"); 
		query.append("                               VVD.SKD_DIR_CD ," ).append("\n"); 
		query.append("                               VVD.POL_CD ," ).append("\n"); 
		query.append("                               VVD.POD_CD ," ).append("\n"); 
		query.append("                               BKG.BKG_CGO_TP_CD ," ).append("\n"); 
		query.append("                               'M' BL_TYPE," ).append("\n"); 
		query.append("                               MF_SND_DT,                     " ).append("\n"); 
		query.append("                               AMDT_SND_DT,                   " ).append("\n"); 
		query.append("                               BKG.BKG_OFC_CD,                " ).append("\n"); 
		query.append("                               VVD.POL_YD_CD,                 " ).append("\n"); 
		query.append("                               VVD.POD_YD_CD," ).append("\n"); 
		query.append("							   POL_SKD.VPS_ETB_DT" ).append("\n"); 
		query.append("                        FROM   BKG_VVD VVD ," ).append("\n"); 
		query.append("                               BKG_BOOKING BKG ," ).append("\n"); 
		query.append("                               BKG_CSTMS_ADV_BL ABL ," ).append("\n"); 
		query.append("                               VSK_VSL_PORT_SKD POL_SKD ," ).append("\n"); 
		query.append("                               VSK_VSL_PORT_SKD POD_SKD" ).append("\n"); 
		query.append("                        WHERE  1=1          " ).append("\n"); 
		query.append("                    #if (${p_vvd} != '') " ).append("\n"); 
		query.append("                        AND VVD.VSL_CD = SUBSTR(@[p_vvd], 1, 4)" ).append("\n"); 
		query.append("                        AND VVD.SKD_VOY_NO = SUBSTR(@[p_vvd], 5, 4)" ).append("\n"); 
		query.append("                        AND VVD.SKD_DIR_CD = SUBSTR(@[p_vvd], 9, 1)" ).append("\n"); 
		query.append("                    #end            " ).append("\n"); 
		query.append("                    #if (${p_pol} != '')" ).append("\n"); 
		query.append("                        AND VVD.POL_CD = @[p_pol]" ).append("\n"); 
		query.append("                    #end" ).append("\n"); 
		query.append("                    #if (${p_pol_yd} != '')" ).append("\n"); 
		query.append("                        AND SUBSTR(VVD.POL_YD_CD,6) = @[p_pol_yd]" ).append("\n"); 
		query.append("                    #end               " ).append("\n"); 
		query.append("                    #if (${p_pod} != '')" ).append("\n"); 
		query.append("                        AND VVD.POD_CD = @[p_pod]" ).append("\n"); 
		query.append("                    #end                    " ).append("\n"); 
		query.append("                        AND    VVD.BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("                        AND    BKG.BKG_STS_CD IN ('F','W')" ).append("\n"); 
		query.append("                        AND    BKG.BL_NO IS NOT NULL" ).append("\n"); 
		query.append("                        AND    ABL.CNT_CD(+) = 'CA'" ).append("\n"); 
		query.append("                        AND    BKG.BL_NO = ABL.BL_NO(+)" ).append("\n"); 
		query.append("                        AND    BKG.BKG_NO = ABL.BKG_NO(+)" ).append("\n"); 
		query.append("                        AND    VVD.VSL_CD = POL_SKD.VSL_CD" ).append("\n"); 
		query.append("                        AND    VVD.SKD_VOY_NO= POL_SKD.SKD_VOY_NO" ).append("\n"); 
		query.append("                        AND    VVD.SKD_DIR_cD = POL_SKD.SKD_DIR_cD" ).append("\n"); 
		query.append("                        AND    VVD.POL_CD= POL_SKD.VPS_PORT_CD" ).append("\n"); 
		query.append("                        AND    VVD.POL_CLPT_IND_SEQ= POL_SKD.CLPT_IND_SEQ" ).append("\n"); 
		query.append("                        AND    VVD.VSL_CD = POD_SKD.VSL_CD" ).append("\n"); 
		query.append("                        AND    VVD.SKD_VOY_NO= POD_SKD.SKD_VOY_NO" ).append("\n"); 
		query.append("                        AND    VVD.SKD_DIR_cD = POD_SKD.SKD_DIR_cD" ).append("\n"); 
		query.append("                        AND    VVD.POD_CD= POD_SKD.VPS_PORT_CD" ).append("\n"); 
		query.append("                        AND    VVD.POD_CLPT_IND_SEQ= POD_SKD.CLPT_IND_SEQ                                                " ).append("\n"); 
		query.append("                #if (${p_date_gb} == 'A')" ).append("\n"); 
		query.append("                    #if (${p_from_dt} != '')" ).append("\n"); 
		query.append("                        AND POL_SKD.VPS_ETA_DT >= TO_DATE(REPLACE(@[p_from_dt],'-','')||' ' ||NVL(@[p_from_mt],'00:00') ,'YYYYMMDD HH24:MI')" ).append("\n"); 
		query.append("                    #end" ).append("\n"); 
		query.append("                    #if (${p_to_dt} != '')" ).append("\n"); 
		query.append("                        AND POL_SKD.VPS_ETA_DT <= TO_DATE(REPLACE(@[p_to_dt],'-','')||' ' ||NVL(@[p_to_mt],'59:59'),'YYYYMMDD HH24:MI')" ).append("\n"); 
		query.append("                    #end" ).append("\n"); 
		query.append("                #elseif (${p_date_gb} == 'B')" ).append("\n"); 
		query.append("                    #if (${p_from_dt} != '') " ).append("\n"); 
		query.append("                        AND POL_SKD.VPS_ETB_DT >= TO_DATE(REPLACE(@[p_from_dt],'-','')||' ' ||NVL(@[p_from_mt],'00:00') ,'YYYYMMDD HH24:MI')" ).append("\n"); 
		query.append("                    #end" ).append("\n"); 
		query.append("                    #if (${p_to_dt} != '') " ).append("\n"); 
		query.append("                        AND POL_SKD.VPS_ETB_DT <= TO_DATE(REPLACE(@[p_to_dt],'-','')||' ' ||NVL(@[p_to_mt],'59:59'),'YYYYMMDD HH24:MI')" ).append("\n"); 
		query.append("                    #end" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("                #if (${p_bl_type} == 'H')                " ).append("\n"); 
		query.append("                        AND  1=2" ).append("\n"); 
		query.append("                #end        " ).append("\n"); 
		query.append("                        AND    NVL(POD_SKD.SKD_CNG_STS_CD,'X') != 'S'" ).append("\n"); 
		query.append("                        AND    NVL(POL_SKD.SKD_CNG_STS_CD,'X') != 'S'" ).append("\n"); 
		query.append("  						AND    POD_SKD.CLPT_SEQ >= (SELECT MIN(CLPT_SEQ)" ).append("\n"); 
		query.append("                                            FROM   VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("                                            WHERE  VPS_PORT_CD LIKE 'CA%'" ).append("\n"); 
		query.append("                                            AND    NVL(SKD_CNG_STS_CD,'X') != 'S'" ).append("\n"); 
		query.append("                                            AND    VSL_CD = POD_SKD.VSL_CD" ).append("\n"); 
		query.append("                                            AND    SKD_VOY_NO = POD_SKD.SKD_VOY_NO" ).append("\n"); 
		query.append("                                            AND    SKD_DIR_CD = POD_SKD.SKD_DIR_CD )" ).append("\n"); 
		query.append("                        AND		POL_SKD.CLPT_SEQ < ( SELECT MAX(CLPT_SEQ)" ).append("\n"); 
		query.append("                                            FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("                                            WHERE VPS_PORT_CD LIKE 'CA%'" ).append("\n"); 
		query.append("                                            AND NVL(SKD_CNG_STS_CD,'X') != 'S'" ).append("\n"); 
		query.append("                                            AND VSL_CD = POD_SKD.VSL_CD" ).append("\n"); 
		query.append("                                            AND SKD_VOY_NO = POD_SKD.SKD_VOY_NO" ).append("\n"); 
		query.append("                                            AND SKD_DIR_CD = POD_SKD.SKD_DIR_CD ) " ).append("\n"); 
		query.append("                        UNION ALL" ).append("\n"); 
		query.append("                        SELECT       " ).append("\n"); 
		query.append("                               H.CNTR_MF_NO AS BKG_NO ," ).append("\n"); 
		query.append("                               ABL.CSTMS_ACK_PROC_RSLT_CD ," ).append("\n"); 
		query.append("                               VVD.VSL_CD ," ).append("\n"); 
		query.append("                               VVD.SKD_VOY_NO ," ).append("\n"); 
		query.append("                               VVD.SKD_DIR_CD ," ).append("\n"); 
		query.append("                               VVD.POL_CD ," ).append("\n"); 
		query.append("                               VVD.POD_CD ," ).append("\n"); 
		query.append("                               BKG.BKG_CGO_TP_CD ," ).append("\n"); 
		query.append("                               'H' BL_TYPE," ).append("\n"); 
		query.append("                               MF_SND_DT,                     " ).append("\n"); 
		query.append("                               AMDT_SND_DT,                   " ).append("\n"); 
		query.append("                               BKG.BKG_OFC_CD,                " ).append("\n"); 
		query.append("                               VVD.POL_YD_CD,                 " ).append("\n"); 
		query.append("                               VVD.POD_YD_CD," ).append("\n"); 
		query.append("							   POL_SKD.VPS_ETB_DT  " ).append("\n"); 
		query.append("                        FROM   BKG_VVD VVD ," ).append("\n"); 
		query.append("                               BKG_BOOKING BKG ," ).append("\n"); 
		query.append("                               BKG_HBL H ," ).append("\n"); 
		query.append("                               BKG_CSTMS_ADV_BL ABL ," ).append("\n"); 
		query.append("                               VSK_VSL_PORT_SKD POL_SKD ," ).append("\n"); 
		query.append("                               VSK_VSL_PORT_SKD POD_SKD" ).append("\n"); 
		query.append("                        WHERE  1=1" ).append("\n"); 
		query.append("                    #if (${p_vvd} != '') " ).append("\n"); 
		query.append("                        AND VVD.VSL_CD = SUBSTR(@[p_vvd], 1, 4)" ).append("\n"); 
		query.append("                        AND VVD.SKD_VOY_NO = SUBSTR(@[p_vvd], 5, 4)" ).append("\n"); 
		query.append("                        AND VVD.SKD_DIR_CD = SUBSTR(@[p_vvd], 9, 1)" ).append("\n"); 
		query.append("                    #end            " ).append("\n"); 
		query.append("                    #if (${p_pol} != '')" ).append("\n"); 
		query.append("                        AND VVD.POL_CD = @[p_pol]" ).append("\n"); 
		query.append("                    #end" ).append("\n"); 
		query.append("                    #if (${p_pol_yd} != '')" ).append("\n"); 
		query.append("                        AND SUBSTR(VVD.POL_YD_CD,6) = @[p_pol_yd]" ).append("\n"); 
		query.append("                    #end            " ).append("\n"); 
		query.append("                    #if (${p_pod} != '')" ).append("\n"); 
		query.append("                        AND VVD.POD_CD = @[p_pod]" ).append("\n"); 
		query.append("                    #end " ).append("\n"); 
		query.append("                        AND    VVD.BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("                        AND    BKG.BKG_NO = H.BKG_NO" ).append("\n"); 
		query.append("                        AND    BKG.BKG_STS_CD IN ('F','W')" ).append("\n"); 
		query.append("                        AND    H.CNTR_MF_NO IS NOT NULL" ).append("\n"); 
		query.append("                        AND    ABL.CNT_CD(+) = 'CA'" ).append("\n"); 
		query.append("                        AND    H.CNTR_MF_NO = ABL.BL_NO(+)" ).append("\n"); 
		query.append("                        AND    BKG.CND_CSTMS_FILE_CD = '1'" ).append("\n"); 
		query.append("                        AND    VVD.VSL_CD = POL_SKD.VSL_CD" ).append("\n"); 
		query.append("                        AND    VVD.SKD_VOY_NO= POL_SKD.SKD_VOY_NO" ).append("\n"); 
		query.append("                        AND    VVD.SKD_DIR_cD = POL_SKD.SKD_DIR_cD" ).append("\n"); 
		query.append("                        AND    VVD.POL_CD= POL_SKD.VPS_PORT_CD" ).append("\n"); 
		query.append("                        AND    VVD.POL_CLPT_IND_SEQ= POL_SKD.CLPT_IND_SEQ" ).append("\n"); 
		query.append("                        AND    VVD.VSL_CD = POD_SKD.VSL_CD" ).append("\n"); 
		query.append("                        AND    VVD.SKD_VOY_NO= POD_SKD.SKD_VOY_NO" ).append("\n"); 
		query.append("                        AND    VVD.SKD_DIR_cD = POD_SKD.SKD_DIR_cD" ).append("\n"); 
		query.append("                        AND    VVD.POD_CD= POD_SKD.VPS_PORT_CD" ).append("\n"); 
		query.append("                        AND    VVD.POD_CLPT_IND_SEQ= POD_SKD.CLPT_IND_SEQ" ).append("\n"); 
		query.append("                #if (${p_date_gb} == 'A')" ).append("\n"); 
		query.append("                    #if (${p_from_dt} != '')" ).append("\n"); 
		query.append("                        AND POL_SKD.VPS_ETA_DT >= TO_DATE(REPLACE(@[p_from_dt],'-','')||' ' ||NVL(@[p_from_mt],'00:00') ,'YYYYMMDD HH24:MI')" ).append("\n"); 
		query.append("                    #end" ).append("\n"); 
		query.append("                    #if (${p_to_dt} != '')" ).append("\n"); 
		query.append("                        AND POL_SKD.VPS_ETA_DT <= TO_DATE(REPLACE(@[p_to_dt],'-','')||' ' ||NVL(@[p_to_mt],'59:59'),'YYYYMMDD HH24:MI')" ).append("\n"); 
		query.append("                    #end" ).append("\n"); 
		query.append("                #elseif (${p_date_gb} == 'B')" ).append("\n"); 
		query.append("                    #if (${p_from_dt} != '') " ).append("\n"); 
		query.append("                        AND POL_SKD.VPS_ETB_DT >= TO_DATE(REPLACE(@[p_from_dt],'-','')||' ' ||NVL(@[p_from_mt],'00:00') ,'YYYYMMDD HH24:MI')" ).append("\n"); 
		query.append("                    #end" ).append("\n"); 
		query.append("                    #if (${p_to_dt} != '') " ).append("\n"); 
		query.append("                        AND POL_SKD.VPS_ETB_DT <= TO_DATE(REPLACE(@[p_to_dt],'-','')||' ' ||NVL(@[p_to_mt],'59:59'),'YYYYMMDD HH24:MI')" ).append("\n"); 
		query.append("                    #end" ).append("\n"); 
		query.append("                #end   " ).append("\n"); 
		query.append("                #if (${p_bl_type} == 'M')                " ).append("\n"); 
		query.append("                        AND  1=2" ).append("\n"); 
		query.append("                #end        " ).append("\n"); 
		query.append("                        AND     NVL(POD_SKD.SKD_CNG_STS_CD,'X') != 'S'" ).append("\n"); 
		query.append("                        AND     NVL(POL_SKD.SKD_CNG_STS_CD,'X') != 'S'" ).append("\n"); 
		query.append("					    AND		POD_SKD.CLPT_SEQ >= (SELECT MIN(CLPT_SEQ)" ).append("\n"); 
		query.append("                                            FROM   VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("                                            WHERE  VPS_PORT_CD LIKE 'CA%'" ).append("\n"); 
		query.append("                                            AND    NVL(SKD_CNG_STS_CD,'X') != 'S'" ).append("\n"); 
		query.append("                                            AND    VSL_CD = POD_SKD.VSL_CD" ).append("\n"); 
		query.append("                                            AND    SKD_VOY_NO = POD_SKD.SKD_VOY_NO" ).append("\n"); 
		query.append("                                            AND    SKD_DIR_CD = POD_SKD.SKD_DIR_CD )" ).append("\n"); 
		query.append("                        AND		POL_SKD.CLPT_SEQ < ( SELECT MAX(CLPT_SEQ)" ).append("\n"); 
		query.append("                                            FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("                                            WHERE VPS_PORT_CD LIKE 'CA%'" ).append("\n"); 
		query.append("                                            AND NVL(SKD_CNG_STS_CD,'X') != 'S'" ).append("\n"); 
		query.append("                                            AND VSL_CD = POD_SKD.VSL_CD" ).append("\n"); 
		query.append("                                            AND SKD_VOY_NO = POD_SKD.SKD_VOY_NO" ).append("\n"); 
		query.append("                                            AND SKD_DIR_CD = POD_SKD.SKD_DIR_CD )  " ).append("\n"); 
		query.append("                       ) TB ," ).append("\n"); 
		query.append("                       VSK_VSL_PORT_SKD SKD" ).append("\n"); 
		query.append("                WHERE  1=1" ).append("\n"); 
		query.append("                AND    SKD.CLPT_SEQ >= (SELECT MIN(CLPT_SEQ)" ).append("\n"); 
		query.append("                        FROM   VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("                        WHERE  VPS_PORT_CD LIKE 'CA%'" ).append("\n"); 
		query.append("                        AND    NVL(SKD_CNG_STS_CD,'X') != 'S'" ).append("\n"); 
		query.append("                        AND    VSL_CD = TB.VSL_CD" ).append("\n"); 
		query.append("                        AND    SKD_VOY_NO = TB.SKD_VOY_NO" ).append("\n"); 
		query.append("                        AND    SKD_DIR_CD = TB.SKD_DIR_CD )" ).append("\n"); 
		query.append("                AND    TB.VSL_CD = SKD.VSL_CD" ).append("\n"); 
		query.append("                AND    TB.SKD_VOY_NO = SKD.SKD_VOY_NO" ).append("\n"); 
		query.append("                AND    TB.SKD_DIR_CD = SKD.SKD_DIR_CD" ).append("\n"); 
		query.append("                AND    TB.POD_CD = SKD.VPS_PORT_CD" ).append("\n"); 
		query.append("                AND    SKD.CLPT_IND_SEQ = 1" ).append("\n"); 
		query.append("                AND    NVL(SKD.SKD_CNG_STS_CD,'X') != 'S'" ).append("\n"); 
		query.append("                AND    TB.BKG_CGO_TP_CD IN ('F','R') " ).append("\n"); 
		query.append("            ) A," ).append("\n"); 
		query.append("              MDM_LOCATION MDM_LOC" ).append("\n"); 
		query.append("             ," ).append("\n"); 
		query.append("              (" ).append("\n"); 
		query.append("                SELECT OFC_N3RD_LVL_CD REGION , OFC_N8TH_LVL_CD OFC_CD" ).append("\n"); 
		query.append("                FROM (" ).append("\n"); 
		query.append("                    SELECT OFC_KIND OFC_KND_CD , A.DEL , A.OFC_CD OFC_N8TH_LVL_CD , L1 OFC_LVL , DECODE(A.L1, 1, A.OFC_CD, 2, A.OFC_CD, 3, A.OFC_CD, 4, A.OFC_CD, 5, A.OFC_CD, 6, A.OFC_CD, 7, A.OFC_CD, 8, B.OFC_CD) OFC_N7TH_LVL_CD , DECODE(A.L1, 1, A.OFC_CD, 2, A.OFC_CD, 3, A.OFC_CD, 4, A.OFC_CD, 5, A.OFC_CD, 6, A.OFC_CD, 7, B.OFC_CD, 8, C.OFC_CD) OFC_N6TH_LVL_CD , DECODE(A.L1, 1, A.OFC_CD, 2, A.OFC_CD, 3, A.OFC_CD, 4, A.OFC_CD, 5, A.OFC_CD, 6, B.OFC_CD, 7, C.OFC_CD, 8, D.OFC_CD) OFC_N5TH_LVL_CD , DECODE(A.L1, 1, A.OFC_CD, 2, A.OFC_CD, 3, A.OFC_CD, 4, A.OFC_CD, 5, B.OFC_CD, 6, C.OFC_CD, 7, D.OFC_CD, 8, E.OFC_CD) OFC_N4TH_LVL_CD , DECODE(A.L1, 1, A.OFC_CD, 2, A.OFC_CD, 3, A.OFC_CD, 4, B.OFC_CD, 5, C.OFC_CD, 6, D.OFC_CD, 7, E.OFC_CD, 8, F.OFC_CD) OFC_N3RD_LVL_CD , DECODE(A.L1, 1, A.OFC_CD, 2, A.OFC_CD, 3, B.OFC_CD, 4, C.OFC_CD, 5, D.OFC_CD, 6, E.OFC_CD, 7, F.OFC_CD, 8, G.OFC_CD) OFC_N2ND_LVL_CD , DECODE(A.L1, 1, A.OFC_CD, 2, B.OFC_CD, 3, C.OFC_CD, 4, D.OFC_CD, 5, E.OFC_CD, 6, F.OFC_CD, 7, G.OFC_CD, 8, H.OFC_CD) OFC_N1ST_LVL_CD" ).append("\n"); 
		query.append("                    FROM (" ).append("\n"); 
		query.append("                        SELECT OFC_CD , LOC_CD , PRNT_OFC_CD , DELT_FLG DEL , A.OFC_KND_CD OFC_KIND , LEVEL L1" ).append("\n"); 
		query.append("                        FROM MDM_ORGANIZATION A START WITH A.OFC_CD = 'SELHO' CONNECT BY PRIOR A.OFC_CD = A.PRNT_OFC_CD ) A , MDM_ORGANIZATION B , MDM_ORGANIZATION C , MDM_ORGANIZATION D , MDM_ORGANIZATION E , MDM_ORGANIZATION F , MDM_ORGANIZATION G , MDM_ORGANIZATION H" ).append("\n"); 
		query.append("                        WHERE A.PRNT_OFC_CD = B.OFC_CD(+)" ).append("\n"); 
		query.append("                        AND B.PRNT_OFC_CD = C.OFC_CD(+)" ).append("\n"); 
		query.append("                        AND C.PRNT_OFC_CD = D.OFC_CD(+)" ).append("\n"); 
		query.append("                        AND D.PRNT_OFC_CD = E.OFC_CD(+)" ).append("\n"); 
		query.append("                        AND E.PRNT_OFC_CD = F.OFC_CD(+)" ).append("\n"); 
		query.append("                        AND F.PRNT_OFC_CD = G.OFC_CD(+)" ).append("\n"); 
		query.append("                        AND G.PRNT_OFC_CD = H.OFC_CD(+) )" ).append("\n"); 
		query.append("                WHERE 1=1" ).append("\n"); 
		query.append("                --  AND NVL(DEL, 'N') = 'N'" ).append("\n"); 
		query.append("                AND OFC_N3RD_LVL_CD IS NOT NULL" ).append("\n"); 
		query.append("                AND OFC_N3RD_LVL_CD IN (" ).append("\n"); 
		query.append("                    SELECT OFC_CD" ).append("\n"); 
		query.append("                    FROM (" ).append("\n"); 
		query.append("                            SELECT OFC_CD , LOC_CD , PRNT_OFC_CD , DELT_FLG DEL , A.OFC_KND_CD OFC_KIND , LEVEL L1" ).append("\n"); 
		query.append("                            FROM MDM_ORGANIZATION A START WITH A.OFC_CD = 'SELHO' CONNECT BY PRIOR A.OFC_CD = A.PRNT_OFC_CD )" ).append("\n"); 
		query.append("                            WHERE L1 =3" ).append("\n"); 
		query.append("                            AND OFC_KIND = '2' )" ).append("\n"); 
		query.append("                AND OFC_N6TH_LVL_CD IS NOT NULL " ).append("\n"); 
		query.append("             ) OLA " ).append("\n"); 
		query.append("            WHERE 1=1" ).append("\n"); 
		query.append("            AND A.POL_CD = MDM_LOC.LOC_CD                     " ).append("\n"); 
		query.append("        #if (${p_rhq_gb} == 'BO')" ).append("\n"); 
		query.append("            AND A.BKG_OFC_CD = OLA.OFC_CD" ).append("\n"); 
		query.append("            #if (${p_b_ofc_cd} != '') " ).append("\n"); 
		query.append("              AND A.BKG_OFC_CD = @[p_b_ofc_cd]" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("        #elseif (${p_rhq_gb} == 'PO')" ).append("\n"); 
		query.append("            AND MDM_LOC.EQ_CTRL_OFC_CD = OLA.OFC_CD" ).append("\n"); 
		query.append("            #if (${p_b_ofc_cd} != '') " ).append("\n"); 
		query.append("              AND MDM_LOC.EQ_CTRL_OFC_CD = @[p_b_ofc_cd]" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("        #end                                    " ).append("\n"); 
		query.append("        ) A" ).append("\n"); 
		query.append("        ,BKG_CHG_RT BCR_ENS" ).append("\n"); 
		query.append("        ,BKG_CHG_RT BCR_ENS2" ).append("\n"); 
		query.append("        ,BKG_CHG_RT BCR_MCF " ).append("\n"); 
		query.append("        WHERE 1=1" ).append("\n"); 
		query.append("        AND A.BKG_NO                        = BCR_ENS.BKG_NO(+)                " ).append("\n"); 
		query.append("        AND A.BKG_NO                        = BCR_ENS2.BKG_NO(+)                " ).append("\n"); 
		query.append("        AND A.BKG_NO                        = BCR_MCF.BKG_NO(+)                " ).append("\n"); 
		query.append("        AND BCR_ENS.CHG_CD(+)               = 'CMS' /* CARRIER MANIFEST CHARGE - Auto Rating시 자동부과  */" ).append("\n"); 
		query.append("        AND BCR_ENS2.CHG_CD(+)              = 'SMC' /* SECURITY MANIFEST DOCUMENT CHARGE - SVC_SCP_CD ASW,MMW,TAW 유럽,인도발 미국향, 대서양 관련 2018.1.1일 현재 서비스 안함. */" ).append("\n"); 
		query.append("        AND BCR_ENS.FRT_INCL_XCLD_DIV_CD(+) = 'N'       " ).append("\n"); 
		query.append("        AND BCR_MCF.CHG_CD(+)               = 'MCF' /* MANIFEST CORRECTION FEE - 수정사항 발생 시 요금 부과 */" ).append("\n"); 
		query.append("        AND BCR_MCF.FRT_INCL_XCLD_DIV_CD(+) = 'N'       " ).append("\n"); 
		query.append("        GROUP BY A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD, A.LANE, A.RHQ, A.BKG_OFC, A.POL, A.POD, A.BL_TYPE" ).append("\n"); 
		query.append(") J" ).append("\n"); 
		query.append("GROUP BY " ).append("\n"); 
		query.append("J.VVD, J.LANE, J.RHQ, J.BKG_OFC, J.POL, J.POD, J.BL_TYPE," ).append("\n"); 
		query.append("J.BL_COUNT, J.ACCEPTED, J.REJECTED, J.DNL, J.RELEASED, J.POD_HOLD, J.DO_NOT_UNLOAD, J.NOT_RECEIVED," ).append("\n"); 
		query.append("UNSENT, AMEND_CNT," ).append("\n"); 
		query.append("CMS_SMC_AMT, CMS_SMC_AMT2, MCF_AMT" ).append("\n"); 
		query.append("#if (${rhq} != '')" ).append("\n"); 
		query.append("HAVING J.RHQ = @[rhq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY" ).append("\n"); 
		query.append("J.VVD, J.LANE, J.RHQ, J.BKG_OFC, J.POL, J.POD" ).append("\n"); 

	}
}