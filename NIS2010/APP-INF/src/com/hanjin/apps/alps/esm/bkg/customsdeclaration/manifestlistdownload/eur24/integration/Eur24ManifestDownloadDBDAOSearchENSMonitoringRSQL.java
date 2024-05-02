/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : Eur24ManifestDownloadDBDAOSearchENSMonitoringRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.06
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.06 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.eur24.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Eur24ManifestDownloadDBDAOSearchENSMonitoringRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Europe Advanced Manifest - ENS Monitoring 조회
	  * * History
	  * 2012.05.15 김보배 [CHM-201217766] [BKG] ENS Monitoring 화면상 Lane 조회값 추가요청
	  * </pre>
	  */
	public Eur24ManifestDownloadDBDAOSearchENSMonitoringRSQL(){
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
		params.put("cond_lane",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("p_pofe",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("p_from_mt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rhq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.eur24.integration").append("\n"); 
		query.append("FileName : Eur24ManifestDownloadDBDAOSearchENSMonitoringRSQL").append("\n"); 
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
		query.append("WITH TEMP  AS" ).append("\n"); 
		query.append("( SELECT VVD.VSL_CD" ).append("\n"); 
		query.append("             , VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("             , VVD.SKD_DIR_CD " ).append("\n"); 
		query.append("             , VL.YD_CD" ).append("\n"); 
		query.append("             , (SELECT CSTMS_YD_CD " ).append("\n"); 
		query.append("                  FROM BKG_CSTMS_EUR_BL " ).append("\n"); 
		query.append("                 WHERE VSL_CD = VVD.VSL_CD" ).append("\n"); 
		query.append("                   AND SKD_VOY_NO = VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("                   AND SKD_DIR_CD = VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("                   AND CSTMS_PORT_CD = SKD2.VPS_PORT_CD" ).append("\n"); 
		query.append("                   AND BL_NO = BKG.BL_NO" ).append("\n"); 
		query.append("               ) AS CSTMS_YD_CD" ).append("\n"); 
		query.append("             , SKD2.VPS_PORT_CD AS POFE" ).append("\n"); 
		query.append("             , SKD2.YD_CD AS POFE_YD " ).append("\n"); 
		query.append("             , BKG.BL_NO" ).append("\n"); 
		query.append("             , VVD.POL_CD AS POL " ).append("\n"); 
		query.append("             " ).append("\n"); 
		query.append("             #if (${p_rhq_gb} == 'BO')" ).append("\n"); 
		query.append("             , BKG.BKG_OFC_CD" ).append("\n"); 
		query.append("             #elseif (${p_rhq_gb} == 'PO')" ).append("\n"); 
		query.append("             , MDM_LOC.EQ_CTRL_OFC_CD AS BKG_OFC_CD" ).append("\n"); 
		query.append("             #end" ).append("\n"); 
		query.append("             , OLA.REGION AS RHQ" ).append("\n"); 
		query.append("             , SUM(NVL(DECODE(BCR_ENS.CURR_CD,'USD',BCR_ENS.CHG_AMT,(BCR_ENS.CHG_AMT)/(SELECT XCH_RT.USD_LOCL_XCH_RT FROM GL_MON_XCH_RT XCH_RT WHERE XCH_RT.ACCT_XCH_RT_YRMON IN TO_CHAR(VL.VPS_ETB_DT,'YYYYMM') AND XCH_RT.CURR_CD = BCR_ENS.CURR_CD AND XCH_RT.ACCT_XCH_RT_LVL = 1)),0)) AS ENS_AMT" ).append("\n"); 
		query.append("             , SUM(NVL(DECODE(BCR_MCF.CURR_CD,'USD',BCR_MCF.CHG_AMT,(BCR_MCF.CHG_AMT)/(SELECT XCH_RT.USD_LOCL_XCH_RT FROM GL_MON_XCH_RT XCH_RT WHERE XCH_RT.ACCT_XCH_RT_YRMON IN TO_CHAR(VL.VPS_ETB_DT,'YYYYMM') AND XCH_RT.CURR_CD = BCR_MCF.CURR_CD AND XCH_RT.ACCT_XCH_RT_LVL = 1)),0)) AS MCF_AMT" ).append("\n"); 
		query.append("             , MAX(VL.RN) RN" ).append("\n"); 
		query.append("             , RANK() OVER (PARTITION BY BL_NO ORDER BY VL.VSL_CD,VL.SKD_VOY_NO, VL.SKD_dIR_CD, VL.CLPT_SEQ, VL.CLPT_SEQ) VL_RNK" ).append("\n"); 
		query.append("             , SKD2.VPS_ETA_DT" ).append("\n"); 
		query.append("             , SKD4.VPS_ETB_DT" ).append("\n"); 
		query.append("         FROM BKG_VVD VVD" ).append("\n"); 
		query.append("            , BKG_BOOKING BKG" ).append("\n"); 
		query.append("            --, BKG_OFC_LVL_V OLA" ).append("\n"); 
		query.append("            , BKG_CHG_RT BCR_ENS" ).append("\n"); 
		query.append("            , BKG_CHG_RT BCR_MCF" ).append("\n"); 
		query.append("            , VSK_VSL_PORT_SKD SKD2" ).append("\n"); 
		query.append("            , VSK_VSL_PORT_SKD SKD3" ).append("\n"); 
		query.append("            , VSK_VSL_PORT_SKD SKD4" ).append("\n"); 
		query.append("            , MDM_VSL_CNTR MDM_VSL" ).append("\n"); 
		query.append("            , MDM_LOCATION MDM_LOC" ).append("\n"); 
		query.append("            , ( SELECT OFC_N3RD_LVL_CD REGION , OFC_N8TH_LVL_CD OFC_CD" ).append("\n"); 
		query.append("                  FROM ( SELECT OFC_KIND OFC_KND_CD , A.DEL , A.OFC_CD OFC_N8TH_LVL_CD , L1 OFC_LVL , DECODE(A.L1, 1, A.OFC_CD, 2, A.OFC_CD, 3, A.OFC_CD, 4, A.OFC_CD, 5, A.OFC_CD, 6, A.OFC_CD, 7, A.OFC_CD, 8, B.OFC_CD) OFC_N7TH_LVL_CD , DECODE(A.L1, 1, A.OFC_CD, 2, A.OFC_CD, 3, A.OFC_CD, 4, A.OFC_CD, 5, A.OFC_CD, 6, A.OFC_CD, 7, B.OFC_CD, 8, C.OFC_CD) OFC_N6TH_LVL_CD , DECODE(A.L1, 1, A.OFC_CD, 2, A.OFC_CD, 3, A.OFC_CD, 4, A.OFC_CD, 5, A.OFC_CD, 6, B.OFC_CD, 7, C.OFC_CD, 8, D.OFC_CD) OFC_N5TH_LVL_CD , DECODE(A.L1, 1, A.OFC_CD, 2, A.OFC_CD, 3, A.OFC_CD, 4, A.OFC_CD, 5, B.OFC_CD, 6, C.OFC_CD, 7, D.OFC_CD, 8, E.OFC_CD) OFC_N4TH_LVL_CD , DECODE(A.L1, 1, A.OFC_CD, 2, A.OFC_CD, 3, A.OFC_CD, 4, B.OFC_CD, 5, C.OFC_CD, 6, D.OFC_CD, 7, E.OFC_CD, 8, F.OFC_CD) OFC_N3RD_LVL_CD , DECODE(A.L1, 1, A.OFC_CD, 2, A.OFC_CD, 3, B.OFC_CD, 4, C.OFC_CD, 5, D.OFC_CD, 6, E.OFC_CD, 7, F.OFC_CD, 8, G.OFC_CD) OFC_N2ND_LVL_CD , DECODE(A.L1, 1, A.OFC_CD, 2, B.OFC_CD, 3, C.OFC_CD, 4, D.OFC_CD, 5, E.OFC_CD, 6, F.OFC_CD, 7, G.OFC_CD, 8, H.OFC_CD) OFC_N1ST_LVL_CD" ).append("\n"); 
		query.append("                           FROM ( SELECT OFC_CD , LOC_CD , PRNT_OFC_CD , DELT_FLG DEL , A.OFC_KND_CD OFC_KIND , LEVEL L1" ).append("\n"); 
		query.append("                                   	FROM MDM_ORGANIZATION A START WITH A.OFC_CD = 'SELHO' CONNECT BY PRIOR A.OFC_CD = A.PRNT_OFC_CD ) A , MDM_ORGANIZATION B , MDM_ORGANIZATION C , MDM_ORGANIZATION D , MDM_ORGANIZATION E , MDM_ORGANIZATION F , MDM_ORGANIZATION G , MDM_ORGANIZATION H" ).append("\n"); 
		query.append("                                   WHERE A.PRNT_OFC_CD = B.OFC_CD(+)" ).append("\n"); 
		query.append("                                     AND B.PRNT_OFC_CD = C.OFC_CD(+)" ).append("\n"); 
		query.append("                                     AND C.PRNT_OFC_CD = D.OFC_CD(+)" ).append("\n"); 
		query.append("                                     AND D.PRNT_OFC_CD = E.OFC_CD(+)" ).append("\n"); 
		query.append("                                     AND E.PRNT_OFC_CD = F.OFC_CD(+)" ).append("\n"); 
		query.append("                                     AND F.PRNT_OFC_CD = G.OFC_CD(+)" ).append("\n"); 
		query.append("                                     AND G.PRNT_OFC_CD = H.OFC_CD(+) " ).append("\n"); 
		query.append("                                )" ).append("\n"); 
		query.append("                          WHERE 1=1" ).append("\n"); 
		query.append("                          --  AND NVL(DEL, 'N') = 'N'" ).append("\n"); 
		query.append("                          	AND OFC_N3RD_LVL_CD IS NOT NULL" ).append("\n"); 
		query.append("                            AND OFC_N3RD_LVL_CD IN ( SELECT OFC_CD" ).append("\n"); 
		query.append("                                                	   FROM ( SELECT OFC_CD , LOC_CD , PRNT_OFC_CD , DELT_FLG DEL , A.OFC_KND_CD OFC_KIND , LEVEL L1" ).append("\n"); 
		query.append("                                                                FROM MDM_ORGANIZATION A START WITH A.OFC_CD = 'SELHO' CONNECT BY PRIOR A.OFC_CD = A.PRNT_OFC_CD )" ).append("\n"); 
		query.append("                                                      WHERE L1 = 3" ).append("\n"); 
		query.append("                                                        AND OFC_KIND = '2' )" ).append("\n"); 
		query.append("                            AND OFC_N6TH_LVL_CD IS NOT NULL ) OLA" ).append("\n"); 
		query.append("            , ( SELECT B.*" ).append("\n"); 
		query.append("                     , ROW_NUMBER() OVER (PARTITION BY B.VSL_CD, B.SKD_VOY_NO, B.SKD_DIR_CD" ).append("\n"); 
		query.append("                       ORDER BY B.VSL_CD, B.SKD_VOY_NO, B.SKD_DIR_CD, B.CLPT_SEQ ) RN" ).append("\n"); 
		query.append("                  FROM ( SELECT A.VSL_CD" ).append("\n"); 
		query.append("                              , A.SKD_VOY_NO" ).append("\n"); 
		query.append("                              , A.SKD_DIR_CD" ).append("\n"); 
		query.append("                              , A.VPS_ETB_DT" ).append("\n"); 
		query.append("                              , SLAN_CD" ).append("\n"); 
		query.append("                              , YD_CD" ).append("\n"); 
		query.append("                              , A.VPS_PORT_CD AS EU_1ST_PORT" ).append("\n"); 
		query.append("                              , CLPT_SEQ" ).append("\n"); 
		query.append("                              , CLPT_IND_SEQ" ).append("\n"); 
		query.append("                              , CASE WHEN LAG( EU ) OVER (PARTITION BY A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD" ).append("\n"); 
		query.append("                                          ORDER BY A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD, A.CLPT_SEQ ) IS NULL" ).append("\n"); 
		query.append("                                          AND EU IS NOT NULL" ).append("\n"); 
		query.append("                                          AND CLPT_SEQ >1 " ).append("\n"); 
		query.append("                                     THEN 'EU1ST'" ).append("\n"); 
		query.append("                                END EU_Flag" ).append("\n"); 
		query.append("                           FROM ( SELECT A.VSL_CD" ).append("\n"); 
		query.append("                                       , A.SKD_VOY_NO" ).append("\n"); 
		query.append("                                       , A.SKD_DIR_CD" ).append("\n"); 
		query.append("                                       , A.VPS_ETB_DT" ).append("\n"); 
		query.append("                                       , SLAN_CD" ).append("\n"); 
		query.append("                                       , A.VPS_PORT_CD" ).append("\n"); 
		query.append("                                       , A.YD_CD AS EU_1ST_PORT_YD_CD" ).append("\n"); 
		query.append("                                       , A.YD_CD" ).append("\n"); 
		query.append("                                       , A.CLPT_SEQ" ).append("\n"); 
		query.append("                                       , CLPT_IND_SEQ" ).append("\n"); 
		query.append("                                       , B.ATTR_CTNT1 EU" ).append("\n"); 
		query.append("                                    FROM VSK_VSL_PORT_SKD A, BKG_CSTMS_CD_CONV_CTNT B" ).append("\n"); 
		query.append("                                   WHERE 1=1" ).append("\n"); 
		query.append("                                     AND ( VSL_CD, SKD_VOY_NO, SKD_DIR_CD) " ).append("\n"); 
		query.append("                                           IN ( SELECT VSL_CD, SKD_VOY_NO, SKD_DIR_CD" ).append("\n"); 
		query.append("                                                  FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("                                                 WHERE NVL(SKD_CNG_STS_CD, 'X') <> 'S'" ).append("\n"); 
		query.append("                                               " ).append("\n"); 
		query.append("                                                   #if (${p_vvd} != '') " ).append("\n"); 
		query.append("                                                        AND VSL_CD = SUBSTR(@[p_vvd], 1, 4)" ).append("\n"); 
		query.append("                                                        AND SKD_VOY_NO = SUBSTR(@[p_vvd], 5, 4)" ).append("\n"); 
		query.append("                                                        AND SKD_DIR_CD = SUBSTR(@[p_vvd], 9, 1)" ).append("\n"); 
		query.append("                                                   #end" ).append("\n"); 
		query.append("                                                 " ).append("\n"); 
		query.append("                                                   #if (${p_date_gb} == 'A')" ).append("\n"); 
		query.append("                                                        #if (${p_from_dt} != '')" ).append("\n"); 
		query.append("                                                            AND VPS_ETA_DT >= TO_DATE(REPLACE(@[p_from_dt],'-','')||' ' ||NVL(@[p_from_mt],'00:00') ,'YYYYMMDD HH24:MI') - 50" ).append("\n"); 
		query.append("                                                        #end" ).append("\n"); 
		query.append("                                                        #if (${p_to_dt} != '')" ).append("\n"); 
		query.append("                                                            AND VPS_ETA_DT <= TO_DATE(REPLACE(@[p_to_dt],'-','')||' ' ||NVL(@[p_to_mt],'59:59'),'YYYYMMDD HH24:MI') + 50" ).append("\n"); 
		query.append("                                                        #end" ).append("\n"); 
		query.append("                                                   #elseif (${p_date_gb} == 'B')" ).append("\n"); 
		query.append("                                                        #if (${p_from_dt} != '') " ).append("\n"); 
		query.append("                                                            AND VPS_ETB_DT >= TO_DATE(REPLACE(@[p_from_dt],'-','')||' ' ||NVL(@[p_from_mt],'00:00') ,'YYYYMMDD HH24:MI') - 50" ).append("\n"); 
		query.append("                                                        #end" ).append("\n"); 
		query.append("                                                        #if (${p_to_dt} != '') " ).append("\n"); 
		query.append("                                                            AND VPS_ETB_DT <= TO_DATE(REPLACE(@[p_to_dt],'-','')||' ' ||NVL(@[p_to_mt],'59:59'),'YYYYMMDD HH24:MI') + 50" ).append("\n"); 
		query.append("                                                        #end" ).append("\n"); 
		query.append("                                                   #end" ).append("\n"); 
		query.append("                                              GROUP BY VSL_CD, SKD_VOY_NO, SKD_DIR_CD )" ).append("\n"); 
		query.append("                                     AND NVL(SKD_CNG_STS_CD, 'X') <> 'S'" ).append("\n"); 
		query.append("                                     AND B.CSTMS_DIV_ID(+)='EU_MEMBER_CNT'" ).append("\n"); 
		query.append("                                     AND B.CNT_CD(+) = 'EU'" ).append("\n"); 
		query.append("                                     AND SUBSTR(A.VPS_PORT_CD, 1, 2) = B.ATTR_CTNT1(+) ) A ) B" ).append("\n"); 
		query.append("                 WHERE EU_FLAG IS NOT NULL ) VL" ).append("\n"); 
		query.append("        WHERE 1=1" ).append("\n"); 
		query.append("          AND VVD.BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("          AND BKG.BKG_STS_CD IN ('F','W')" ).append("\n"); 
		query.append("          AND BKG.BKG_CGO_TP_CD IN ('F','R')" ).append("\n"); 
		query.append("          AND BKG.BL_NO IS NOT NULL" ).append("\n"); 
		query.append("          AND VVD.VSL_CD = VL.VSL_CD" ).append("\n"); 
		query.append("          AND VVD.SKD_VOY_NO= VL.SKD_VOY_NO" ).append("\n"); 
		query.append("          AND VVD.SKD_dIR_CD= VL.SKD_DIR_CD" ).append("\n"); 
		query.append("          AND VVD.VSL_CD = SKD2.VSL_CD" ).append("\n"); 
		query.append("          AND VVD.SKD_VOY_NO = SKD2.SKD_VOY_NO" ).append("\n"); 
		query.append("          AND VVD.SKD_DIR_CD = SKD2.SKD_DIR_CD" ).append("\n"); 
		query.append("          " ).append("\n"); 
		query.append("          #if (${p_pofe} != '') " ).append("\n"); 
		query.append("            AND SKD2.YD_CD LIKE @[p_pofe]||'%'" ).append("\n"); 
		query.append("          #end" ).append("\n"); 
		query.append("          " ).append("\n"); 
		query.append("          #if (${p_date_gb} == 'A')" ).append("\n"); 
		query.append("            #if (${p_from_dt} != '')" ).append("\n"); 
		query.append("                AND SKD2.VPS_ETA_DT >= TO_DATE(REPLACE(@[p_from_dt],'-','')||' ' ||NVL(@[p_from_mt],'00:00') ,'YYYYMMDD HH24:MI')" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("            #if (${p_to_dt} != '')" ).append("\n"); 
		query.append("               	AND SKD2.VPS_ETA_DT <= TO_DATE(REPLACE(@[p_to_dt],'-','')||' ' ||NVL(@[p_to_mt],'59:59'),'YYYYMMDD HH24:MI')" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("          #elseif (${p_date_gb} == 'B')" ).append("\n"); 
		query.append("          	#if (${p_from_dt} != '') " ).append("\n"); 
		query.append("                AND SKD4.VPS_ETB_DT >= TO_DATE(REPLACE(@[p_from_dt],'-','')||' ' ||NVL(@[p_from_mt],'00:00') ,'YYYYMMDD HH24:MI')" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("            #if (${p_to_dt} != '') " ).append("\n"); 
		query.append("                AND SKD4.VPS_ETB_DT <= TO_DATE(REPLACE(@[p_to_dt],'-','')||' ' ||NVL(@[p_to_mt],'59:59'),'YYYYMMDD HH24:MI')" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("          #end" ).append("\n"); 
		query.append("          " ).append("\n"); 
		query.append("          AND SKD2.VPS_PORT_CD = VL.EU_1ST_PORT" ).append("\n"); 
		query.append("          AND SKD2.CLPT_IND_SEQ = VL.CLPT_IND_SEQ" ).append("\n"); 
		query.append("          " ).append("\n"); 
		query.append("          #if (${p_pol} != '')" ).append("\n"); 
		query.append("            AND VVD.POL_CD = @[p_pol]" ).append("\n"); 
		query.append("          #end" ).append("\n"); 
		query.append("          " ).append("\n"); 
		query.append("          #if (${p_pol_yd} != '')" ).append("\n"); 
		query.append("            AND SUBSTR(VVD.POL_YD_CD,6) = @[p_pol_yd]" ).append("\n"); 
		query.append("          #end" ).append("\n"); 
		query.append("          " ).append("\n"); 
		query.append("          AND VVD.VSL_CD = SKD3.VSL_CD" ).append("\n"); 
		query.append("          AND VVD.SKD_VOY_NO = SKD3.SKD_VOY_NO" ).append("\n"); 
		query.append("          AND VVD.SKD_DIR_CD = SKD3.SKD_DIR_CD" ).append("\n"); 
		query.append("          AND VVD.POD_CD = SKD3.VPS_PORT_CD" ).append("\n"); 
		query.append("          AND SKD2.CLPT_SEQ <= SKD3.CLPT_SEQ -- 1st EU Port 이후에 POD 기항해야함." ).append("\n"); 
		query.append("          AND VVD.POD_CLPT_IND_SEQ = SKD3.CLPT_IND_SEQ" ).append("\n"); 
		query.append("          " ).append("\n"); 
		query.append("          -- SKD4 : POL SKD  " ).append("\n"); 
		query.append("          AND VVD.VSL_CD = SKD4.VSL_CD" ).append("\n"); 
		query.append("          AND VVD.SKD_VOY_NO = SKD4.SKD_VOY_NO" ).append("\n"); 
		query.append("          AND VVD.SKD_DIR_CD = SKD4.SKD_DIR_CD" ).append("\n"); 
		query.append("          AND VVD.POL_CD = SKD4.VPS_PORT_CD" ).append("\n"); 
		query.append("          AND SKD4.CLPT_SEQ < SKD2.CLPT_SEQ  -- POFE 가 POL 이상이어야함. 같으면 대상아님." ).append("\n"); 
		query.append("          AND SKD2.CLPT_SEQ <= SKD3.CLPT_SEQ -- POD 가 POFE 까지는 가야한다." ).append("\n"); 
		query.append("          AND VVD.POL_CLPT_IND_SEQ = SKD4.CLPT_IND_SEQ" ).append("\n"); 
		query.append("          AND VVD.BKG_NO > ' '" ).append("\n"); 
		query.append("          AND VVD.SLAN_CD> ' '" ).append("\n"); 
		query.append("          AND VVD.VSL_CD = MDM_VSL.VSL_CD" ).append("\n"); 
		query.append("          AND VVD.POL_CD = MDM_LOC.LOC_CD" ).append("\n"); 
		query.append("          " ).append("\n"); 
		query.append("          #if(${p_fdr_yn} == '')" ).append("\n"); 
		query.append("            AND MDM_VSL.FDR_DIV_CD = 'T'" ).append("\n"); 
		query.append("            AND MDM_VSL.VSL_CD <> 'BFCA'" ).append("\n"); 
		query.append("          #end" ).append("\n"); 
		query.append("          " ).append("\n"); 
		query.append("          #if (${p_rhq_gb} == 'BO')" ).append("\n"); 
		query.append("            AND BKG.BKG_OFC_CD = OLA.OFC_CD" ).append("\n"); 
		query.append("            #if (${p_b_ofc_cd} != '') " ).append("\n"); 
		query.append("                AND BKG.BKG_OFC_CD = @[p_b_ofc_cd]" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("          #elseif (${p_rhq_gb} == 'PO')" ).append("\n"); 
		query.append("            AND MDM_LOC.EQ_CTRL_OFC_CD = OLA.OFC_CD" ).append("\n"); 
		query.append("            #if (${p_b_ofc_cd} != '') " ).append("\n"); 
		query.append("                AND MDM_LOC.EQ_CTRL_OFC_CD = @[p_b_ofc_cd]" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("          #end" ).append("\n"); 
		query.append("          " ).append("\n"); 
		query.append("          AND BKG.BKG_NO = BCR_ENS.BKG_NO(+)" ).append("\n"); 
		query.append("          AND BKG.BKG_NO = BCR_MCF.BKG_NO(+)" ).append("\n"); 
		query.append("          AND BCR_ENS.CHG_CD(+) = 'ENS'" ).append("\n"); 
		query.append("          AND BCR_ENS.FRT_INCL_XCLD_DIV_CD(+) = 'N'" ).append("\n"); 
		query.append("          AND BCR_MCF.CHG_CD(+) = 'MCF'" ).append("\n"); 
		query.append("          AND BCR_MCF.FRT_INCL_XCLD_DIV_CD(+) = 'N'" ).append("\n"); 
		query.append("          " ).append("\n"); 
		query.append("     GROUP BY VVD.VSL_CD ,VVD.SKD_VOY_NO ,VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("            , VL.YD_CD" ).append("\n"); 
		query.append("            , SKD2.VPS_PORT_CD ,SKD2.YD_CD" ).append("\n"); 
		query.append("            , BKG.BL_NO " ).append("\n"); 
		query.append("            , VVD.POL_CD " ).append("\n"); 
		query.append("            , BKG.BKG_OFC_CD " ).append("\n"); 
		query.append("            , MDM_LOC.EQ_CTRL_OFC_CD " ).append("\n"); 
		query.append("            , OLA.REGION" ).append("\n"); 
		query.append("            , VL.VSL_CD ,VL.SKD_VOY_NO ,VL.SKD_DIR_CD ,VL.CLPT_SEQ ,VL.CLPT_SEQ" ).append("\n"); 
		query.append("            , SKD2.VPS_ETA_DT ,SKD4.VPS_ETB_DT" ).append("\n"); 
		query.append("      )" ).append("\n"); 
		query.append("SELECT J.VVD ,J.LANE ,J.POFE ,J.RHQ ,J.BKG_OFC_CD ,J.POL" ).append("\n"); 
		query.append("     , J.BL_TOT_CNT ,J.ENS_SNT_CNT ,J.ENS_SNT_ACC ,J.ENS_SNT_REJ ,J.ENS_SNT_NRCV ,J.ENS_SNT_DONLD ,J.ENS_UNSNT_CNT ,J.ENS_TOSND_CNT ,J.ENS_AMD_CNT ,J.ENS_AMT ,J.MCF_AMT" ).append("\n"); 
		query.append("     , TO_CHAR(J.VPS_ETA_DT, 'YYYY-MM-DD HH24:MI:SS') AS VPS_ETA_DT" ).append("\n"); 
		query.append("     , TO_CHAR(J.VPS_ETB_DT, 'YYYY-MM-DD HH24:MI:SS') AS VPS_ETB_DT" ).append("\n"); 
		query.append("     , SUM(NVL(BL_TOT_CNT,0)) OVER() AS TOTAL_BL_CNT" ).append("\n"); 
		query.append("     , SUM(NVL(ENS_SNT_CNT,0)) OVER() AS SENT_BL_CNT" ).append("\n"); 
		query.append("     , SUM(NVL(ENS_SNT_ACC, 0)) OVER() AS ACC_BL_CNT" ).append("\n"); 
		query.append("     , SUM(NVL(ENS_SNT_REJ, 0)) OVER() AS REJ_BL_CNT	" ).append("\n"); 
		query.append("     , SUM(NVL(ENS_SNT_NRCV, 0)) OVER() AS NRCV_BL_CNT" ).append("\n"); 
		query.append("	 , SUM(NVL(ENS_SNT_DONLD, 0)) OVER() AS DONLD_BL_CNT" ).append("\n"); 
		query.append("     , SUM(NVL(ENS_UNSNT_CNT,0)) OVER() AS UNSENT_BL_CNT" ).append("\n"); 
		query.append("     , SUM(NVL(ENS_TOSND_CNT,0)) OVER() AS TOSEND_BL_CNT" ).append("\n"); 
		query.append("	 , SUM(NVL(ENS_AMD_CNT,0)) OVER() AS TOTAL_AMD_CNT" ).append("\n"); 
		query.append("     , SUM(NVL(ENS_AMT,0)) OVER() AS TOTAL_ENS_AMT" ).append("\n"); 
		query.append("     , SUM(DECODE(RHQ,'SHARC',NVL(ENS_AMT,0),0)) OVER() AS TOTAL_SHAAS_ENS" ).append("\n"); 
		query.append("     , SUM(DECODE(RHQ,'NYCRA',NVL(ENS_AMT,0),0)) OVER() AS TOTAL_NYCNA_ENS" ).append("\n"); 
		query.append("     , SUM(DECODE(RHQ,'HAMRU',NVL(ENS_AMT,0),0)) OVER() AS TOTAL_HAMUR_ENS" ).append("\n"); 
		query.append("     , SUM(DECODE(RHQ,'SINRS',NVL(ENS_AMT,0),0)) OVER() AS TOTAL_SINWA_ENS" ).append("\n"); 
		query.append("     , SUM(NVL(MCF_AMT,0)) OVER() AS TOTAL_MCF_AMT" ).append("\n"); 
		query.append("     , SUM(DECODE(RHQ,'SHARC',NVL(MCF_AMT,0),0)) OVER() AS TOTAL_SHAAS_MCF" ).append("\n"); 
		query.append("     , SUM(DECODE(RHQ,'NYCRA',NVL(MCF_AMT,0),0)) OVER() AS TOTAL_NYCNA_MCF" ).append("\n"); 
		query.append("     , SUM(DECODE(RHQ,'HAMRU',NVL(MCF_AMT,0),0)) OVER() AS TOTAL_HAMUR_MCF" ).append("\n"); 
		query.append("     , SUM(DECODE(RHQ,'SINRS',NVL(MCF_AMT,0),0)) OVER() AS TOTAL_SINWA_MCF" ).append("\n"); 
		query.append("     , COUNT(DISTINCT VVD) OVER() AS TOTAL_VVD_CNT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT J1.VVD,J1.LANE,J1.POFE,J1.RHQ,J1.BKG_OFC_CD,J1.POL" ).append("\n"); 
		query.append("     , COUNT(J1.VSL_CD) AS BL_TOT_CNT" ).append("\n"); 
		query.append("     , COUNT(J1.MSG_SND_NO) AS ENS_SNT_CNT" ).append("\n"); 
		query.append("     , COUNT(DECODE(J1.ACK_RCV_STS_CD,'A',ACK_RCV_STS_CD,'AL',1)) AS ENS_SNT_ACC" ).append("\n"); 
		query.append("     , COUNT(DECODE(J1.ACK_RCV_STS_CD,'R',1)) AS ENS_SNT_REJ" ).append("\n"); 
		query.append("     , COUNT(DECODE(J1.MSG_SND_NO,NULL,NULL,DECODE(J1.ACK_RCV_STS_CD,NULL,1))) AS ENS_SNT_NRCV" ).append("\n"); 
		query.append("     , COUNT(DECODE(J1.EUR_CSTMS_ACK_CD,'351',1)) AS ENS_SNT_DONLD" ).append("\n"); 
		query.append("     , COUNT(J1.VSL_CD)-COUNT(J1.MSG_SND_NO) AS ENS_UNSNT_CNT" ).append("\n"); 
		query.append("     , COUNT(DECODE(J1.UP_BL_FLG,'N',1)) AS ENS_TOSND_CNT" ).append("\n"); 
		query.append("	 , COUNT(DECODE(SUBSTR(J1.MSG_SND_NO,18,3),'313',J1.MSG_SND_NO,NULL)) AS ENS_AMD_CNT" ).append("\n"); 
		query.append("     , SUM(ROUND(J1.ENS_AMT,2)) AS ENS_AMT" ).append("\n"); 
		query.append("     , SUM(ROUND(J1.MCF_AMT,2)) AS MCF_AMT" ).append("\n"); 
		query.append("     , J1.VPS_ETA_DT" ).append("\n"); 
		query.append("     , J1.VPS_ETB_DT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM ( SELECT BKG.VSL_CD || BKG.SKD_VOY_NO || BKG.SKD_DIR_CD AS VVD" ).append("\n"); 
		query.append("            , (SELECT VSL_SLAN_CD FROM VSK_VSL_SKD WHERE VSL_CD = BKG.VSL_CD AND SKD_VOY_NO = BKG.SKD_VOY_NO AND SKD_DIR_CD = BKG.SKD_DIR_CD) AS LANE" ).append("\n"); 
		query.append("            --,DECODE(BKG.CSTMS_YD_CD, BKG.YD_CD , BKG.YD_CD, NULL , BKG.YD_CD , BKG.CSTMS_YD_CD ||'('|| BKG.YD_CD ||')') AS POFE" ).append("\n"); 
		query.append("            , DECODE(ENS.CSTMS_YD_CD, BKG.YD_CD , BKG.YD_CD, NULL , BKG.YD_CD , ENS.CSTMS_YD_CD ||'('|| BKG.YD_CD ||')') AS POFE" ).append("\n"); 
		query.append("            , BKG.RHQ AS RHQ" ).append("\n"); 
		query.append("            , BKG.BKG_OFC_CD AS BKG_OFC_CD" ).append("\n"); 
		query.append("            , BKG.POL AS POL" ).append("\n"); 
		query.append("            , BKG.VSL_CD" ).append("\n"); 
		query.append("            , ENS.MSG_SND_NO" ).append("\n"); 
		query.append("            , ENS.ACK_RCV_STS_CD" ).append("\n"); 
		query.append("            , ENS.EUR_CSTMS_ACK_CD" ).append("\n"); 
		query.append("            , DECODE(BKG.VL_RNK,1,BKG.ENS_AMT,0) ENS_AMT" ).append("\n"); 
		query.append("            , DECODE(BKG.VL_RNK,1,BKG.MCF_AMT,0) MCF_AMT" ).append("\n"); 
		query.append("            , BKG.VPS_ETA_DT" ).append("\n"); 
		query.append("            , BKG.VPS_ETB_DT" ).append("\n"); 
		query.append("			      , NVL(BKG_GET_TOKEN_FNC((SELECT MAX(LPAD(DOC_PROC_SEQ,5,'0')||','||BD.DOC_PERF_DELT_FLG)" ).append("\n"); 
		query.append("                 FROM BKG_DOC_PROC_SKD BD" ).append("\n"); 
		query.append("                    , BKG_CSTMS_ADV_EUR_SND SND" ).append("\n"); 
		query.append("                WHERE BD.BKG_NO = SND.BL_NO" ).append("\n"); 
		query.append("                  AND BD.BKG_DOC_PROC_TP_CD = 'AI_SND'" ).append("\n"); 
		query.append("                  AND SND.BL_NO = ENS.BL_NO" ).append("\n"); 
		query.append("                  AND SND.MSG_SND_NO = ENS.MSG_SND_NO),2),'Y')     AS UP_BL_FLG " ).append("\n"); 
		query.append("         FROM TEMP BKG" ).append("\n"); 
		query.append("            , ( SELECT A.VSL_CD, A.SKD_VOY_NO, A.SKD_dIR_CD,  A.BL_NO, A.CSTMS_YD_CD, B.CLPT_SEQ, A.MSG_SND_NO" ).append("\n"); 
		query.append("                     , (SELECT EUR_RCVA.ACK_RCV_STS_CD " ).append("\n"); 
		query.append("                          FROM BKG_CSTMS_ADV_EUR_RCV EUR_RCVA" ).append("\n"); 
		query.append("                         WHERE EUR_RCVA.RCV_TMS = ( SELECT MAX(RCV_TMS)" ).append("\n"); 
		query.append("                                                      FROM BKG_CSTMS_ADV_EUR_RCV EUR_RCVB" ).append("\n"); 
		query.append("                                                     WHERE EUR_RCVB.MSG_RCV_NO = A.MSG_SND_NO" ).append("\n"); 
		query.append("                                                       AND (EUR_RCVB.ACK_KND_ID != 'S' OR EUR_RCVB.ACK_RCV_STS_CD != 'A' ))) ACK_RCV_STS_CD " ).append("\n"); 
		query.append("	                 , (SELECT EUR_RCVA.EUR_CSTMS_ACK_CD" ).append("\n"); 
		query.append("                          FROM BKG_CSTMS_ADV_EUR_RCV EUR_RCVA" ).append("\n"); 
		query.append("                         WHERE EUR_RCVA.RCV_TMS = ( SELECT MAX(RCV_TMS)" ).append("\n"); 
		query.append("                                                      FROM BKG_CSTMS_ADV_EUR_RCV EUR_RCVB" ).append("\n"); 
		query.append("                                                     WHERE EUR_RCVB.MSG_RCV_NO = A.MSG_SND_NO" ).append("\n"); 
		query.append("                                                       AND (EUR_RCVB.ACK_KND_ID != 'S' OR EUR_RCVB.ACK_RCV_STS_CD != 'A' ))) EUR_CSTMS_ACK_CD " ).append("\n"); 
		query.append("                     , ROW_NUMBER() OVER (PARTITION BY A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD, A.BL_NO" ).append("\n"); 
		query.append("                       ORDER BY A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD, B.CLPT_SEQ ) RN" ).append("\n"); 
		query.append("                 " ).append("\n"); 
		query.append("                  FROM TEMP, BKG_CSTMS_EUR_BL A, VSK_VSL_PORT_SKD B" ).append("\n"); 
		query.append("                 WHERE 1=1" ).append("\n"); 
		query.append("                   AND A.VSL_CD= B.VSL_CD  " ).append("\n"); 
		query.append("                   AND A.SKD_VOY_NO = B.SKD_VOY_NO  " ).append("\n"); 
		query.append("                   AND A.SKD_DIR_CD = B.SKD_DIR_CD" ).append("\n"); 
		query.append("                   AND A.CSTMS_PORT_cD = B.VPS_PORT_CD " ).append("\n"); 
		query.append("                    AND TEMP.VSL_CD     = A.VSL_CD" ).append("\n"); 
		query.append("                  AND TEMP.SKD_VOY_NO = A.SKD_VOY_NO" ).append("\n"); 
		query.append("                  AND TEMP.SKD_DIR_CD = A.SKD_DIR_CD" ).append("\n"); 
		query.append("                  AND TEMP.BL_NO      = A.BL_NO" ).append("\n"); 
		query.append("                   #if (${p_vvd} != '') " ).append("\n"); 
		query.append("                        AND A.VSL_CD = SUBSTR(@[p_vvd], 1, 4)" ).append("\n"); 
		query.append("                        AND A.SKD_VOY_NO = SUBSTR(@[p_vvd], 5, 4)" ).append("\n"); 
		query.append("                        AND A.SKD_DIR_CD = SUBSTR(@[p_vvd], 9, 1)" ).append("\n"); 
		query.append("                   #end" ).append("\n"); 
		query.append("                   " ).append("\n"); 
		query.append("                   #if (${p_date_gb} == 'A')" ).append("\n"); 
		query.append("                        #if (${p_from_dt} != '')" ).append("\n"); 
		query.append("                            AND B.VPS_ETA_DT >= TO_DATE(REPLACE(@[p_from_dt],'-','')||' ' ||NVL(@[p_from_mt],'00:00') ,'YYYYMMDD HH24:MI') - 50" ).append("\n"); 
		query.append("                        #end" ).append("\n"); 
		query.append("                        #if (${p_to_dt} != '')" ).append("\n"); 
		query.append("                            AND B.VPS_ETA_DT <= TO_DATE(REPLACE(@[p_to_dt],'-','')||' ' ||NVL(@[p_to_mt],'59:59'),'YYYYMMDD HH24:MI') + 50" ).append("\n"); 
		query.append("                        #end" ).append("\n"); 
		query.append("                   #elseif (${p_date_gb} == 'B')" ).append("\n"); 
		query.append("                        #if (${p_from_dt} != '') " ).append("\n"); 
		query.append("                            AND B.VPS_ETB_DT >= TO_DATE(REPLACE(@[p_from_dt],'-','')||' ' ||NVL(@[p_from_mt],'00:00') ,'YYYYMMDD HH24:MI') - 50" ).append("\n"); 
		query.append("                        #end" ).append("\n"); 
		query.append("                        #if (${p_to_dt} != '') " ).append("\n"); 
		query.append("                            AND B.VPS_ETB_DT <= TO_DATE(REPLACE(@[p_to_dt],'-','')||' ' ||NVL(@[p_to_mt],'59:59'),'YYYYMMDD HH24:MI') + 50" ).append("\n"); 
		query.append("                        #end" ).append("\n"); 
		query.append("                   #end" ).append("\n"); 
		query.append("              ) ENS" ).append("\n"); 
		query.append("        WHERE 1=1" ).append("\n"); 
		query.append("          AND BKG.VSL_CD= ENS.VSL_CD(+)" ).append("\n"); 
		query.append("          AND BKG.SKD_VOY_NO = ENS.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("          AND BKG.SKD_DIR_CD = ENS.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("          AND BKG.BL_NO = ENS.BL_NO(+)" ).append("\n"); 
		query.append("          AND BKG.VL_RNK =  ENS.RN(+)  " ).append("\n"); 
		query.append("    ) J1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #if (${rhq} != '')" ).append("\n"); 
		query.append("        HAVING J1.RHQ = @[rhq]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    GROUP BY J1.VVD" ).append("\n"); 
		query.append("           , J1.LANE" ).append("\n"); 
		query.append("           , J1.POFE" ).append("\n"); 
		query.append("           , J1.RHQ" ).append("\n"); 
		query.append("           , J1.BKG_OFC_CD" ).append("\n"); 
		query.append("           , J1.POL" ).append("\n"); 
		query.append("           , J1.VPS_ETA_DT " ).append("\n"); 
		query.append("           , J1.VPS_ETB_DT" ).append("\n"); 
		query.append(") J" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("  #if(${p_fdr_yn} == '')" ).append("\n"); 
		query.append("    AND LANE NOT IN ( 'GSE', 'BLS')" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("  #if(${cond_lane} != '')" ).append("\n"); 
		query.append("    AND LANE = @[cond_lane]" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY VVD" ).append("\n"); 
		query.append("       , LANE" ).append("\n"); 
		query.append("       , POFE" ).append("\n"); 
		query.append("       , RHQ" ).append("\n"); 
		query.append("       , BKG_OFC_CD" ).append("\n"); 
		query.append("       , POL" ).append("\n"); 
		query.append("       , BL_TOT_CNT" ).append("\n"); 
		query.append("       , VPS_ETA_DT " ).append("\n"); 
		query.append("       , VPS_ETB_DT" ).append("\n"); 

	}
}