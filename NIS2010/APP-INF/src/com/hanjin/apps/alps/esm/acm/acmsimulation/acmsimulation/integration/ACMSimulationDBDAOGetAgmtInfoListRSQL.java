/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : ACMSimulationDBDAOGetAgmtInfoListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.04.05
*@LastModifier : 
*@LastVersion : 1.0
* 2017.04.05 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmsimulation.acmsimulation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ACMSimulationDBDAOGetAgmtInfoListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GetAgmtInfoList
	  * 
	  * 2014.05.09 박다은 [선반영] PRM Charge G.Rev 에서 surchrage 유무에 상관없이 공제 되도록 로직 변경 요청
	  * </pre>
	  */
	public ACMSimulationDBDAOGetAgmtInfoListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_cre_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ib_sa_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ob_sa_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_mon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.acm.acmsimulation.acmsimulation.integration").append("\n"); 
		query.append("FileName : ACMSimulationDBDAOGetAgmtInfoListRSQL").append("\n"); 
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
		query.append("WITH A AS ( " ).append("\n"); 
		query.append("    SELECT " ).append("\n"); 
		query.append("     B.BKG_NO" ).append("\n"); 
		query.append("    ,R.CLT_OFC_CD" ).append("\n"); 
		query.append("    ,ACM_GET_AGN_CD_FNC(B.CTRT_OFC_CD, @[ob_sa_dt], @[bkg_cre_dt], @[rev_mon])   AS CTRT_OFC_CD" ).append("\n"); 
		query.append("    ,ACM_GET_AGN_CD_FNC(O5.AR_OFC_CD, @[ob_sa_dt], @[bkg_cre_dt], @[rev_mon])    AS CTRT_AR " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    ,ACM_GET_AGN_CD_FNC(B.OB_SLS_OFC_CD, @[ob_sa_dt], @[bkg_cre_dt], @[rev_mon]) AS OB_SLS_OFC_CD" ).append("\n"); 
		query.append("    ,ACM_GET_AGN_CD_FNC(O6.AR_OFC_CD, @[ob_sa_dt], @[bkg_cre_dt], @[rev_mon])    AS OB_SLS_AR " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    ,SUBSTR(B.BKG_OFC_CD,1,3) || NVL(B.CHN_AGN_CD,'X') AS CHN_AGN_CD" ).append("\n"); 
		query.append("    ,ACM_GET_AGN_CD_FNC(B.BKG_OFC_CD, @[ob_sa_dt], @[bkg_cre_dt], @[rev_mon]) AS BKG_OFC" ).append("\n"); 
		query.append("    ,ACM_GET_AGN_CD_FNC(OB.AR_OFC_CD, @[ob_sa_dt], @[bkg_cre_dt], @[rev_mon]) AS BKG_AR " ).append("\n"); 
		query.append("    ,B.POR_CD" ).append("\n"); 
		query.append("    ,L1.CONTI_CD         AS POR_CNTI" ).append("\n"); 
		query.append("    ,L1.SCONTI_CD        AS POR_SCNTI" ).append("\n"); 
		query.append("    ,L1.CNT_CD           AS POR_CNT" ).append("\n"); 
		query.append("    ,ACM_GET_AGN_CD_FNC(L1.FINC_CTRL_OFC_CD, @[ob_sa_dt], @[bkg_cre_dt], @[rev_mon]) AS POR_FINC" ).append("\n"); 
		query.append("    ,ACM_GET_AGN_CD_FNC(O1.AR_OFC_CD,        @[ob_sa_dt], @[bkg_cre_dt], @[rev_mon]) AS POR_AR" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    ,B.POL_CD" ).append("\n"); 
		query.append("    ,L2.CONTI_CD         AS POL_CNTI" ).append("\n"); 
		query.append("    ,L2.SCONTI_CD        AS POL_SCNTI" ).append("\n"); 
		query.append("    ,L2.CNT_CD           AS POL_CNT" ).append("\n"); 
		query.append("    ,ACM_GET_AGN_CD_FNC(L2.FINC_CTRL_OFC_CD, @[ob_sa_dt], @[bkg_cre_dt], @[rev_mon]) AS POL_FINC" ).append("\n"); 
		query.append("    ,ACM_GET_AGN_CD_FNC(O2.AR_OFC_CD,        @[ob_sa_dt], @[bkg_cre_dt], @[rev_mon]) AS POL_AR" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    ,B.POD_CD" ).append("\n"); 
		query.append("    ,L3.CONTI_CD         AS POD_CNTI" ).append("\n"); 
		query.append("    ,L3.SCONTI_CD        AS POD_SCNTI" ).append("\n"); 
		query.append("    ,L3.CNT_CD           AS POD_CNT" ).append("\n"); 
		query.append("    ,ACM_GET_AGN_CD_FNC(L3.FINC_CTRL_OFC_CD, @[ib_sa_dt], @[bkg_cre_dt], @[rev_mon]) AS POD_FINC" ).append("\n"); 
		query.append("    ,ACM_GET_AGN_CD_FNC(O3.AR_OFC_CD,        @[ib_sa_dt], @[bkg_cre_dt], @[rev_mon]) AS POD_AR" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    ,B.DEL_CD" ).append("\n"); 
		query.append("    ,L4.CONTI_CD         AS DEL_CNTI" ).append("\n"); 
		query.append("    ,L4.SCONTI_CD        AS DEL_SCNTI" ).append("\n"); 
		query.append("    ,L4.CNT_CD           AS DEL_CNT" ).append("\n"); 
		query.append("    ,ACM_GET_AGN_CD_FNC(L4.FINC_CTRL_OFC_CD, @[ib_sa_dt], @[bkg_cre_dt], @[rev_mon]) AS DEL_FINC" ).append("\n"); 
		query.append("    ,ACM_GET_AGN_CD_FNC(O4.AR_OFC_CD,        @[ib_sa_dt], @[bkg_cre_dt], @[rev_mon]) AS DEL_AR" ).append("\n"); 
		query.append("    ,ACM_GET_AGN_CD_FNC(CN_OB.OB_CHN_AGN,    @[ob_sa_dt], @[bkg_cre_dt], @[rev_mon]) AS CN_OB_FINC" ).append("\n"); 
		query.append("    ,ACM_GET_AGN_CD_FNC(CN_OB.OB_CHN_AGN_AR, @[ob_sa_dt], @[bkg_cre_dt], @[rev_mon]) AS CN_OB_AR" ).append("\n"); 
		query.append("    ,ACM_GET_AGN_CD_FNC(CN_IB.IB_CHN_AGN,    @[ob_sa_dt], @[bkg_cre_dt], @[rev_mon]) AS CN_IB_FINC" ).append("\n"); 
		query.append("    ,ACM_GET_AGN_CD_FNC(CN_IB.IB_CHN_AGN_AR, @[ob_sa_dt], @[bkg_cre_dt], @[rev_mon]) AS CN_IB_AR" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    ,TS.VSL_PRE_PST_CD" ).append("\n"); 
		query.append("    ,TS.TS_SA_DT" ).append("\n"); 
		query.append("    ,TS.TS_LOC" ).append("\n"); 
		query.append("    ,TS.TS_CNTI" ).append("\n"); 
		query.append("    ,TS.TS_SCNTI" ).append("\n"); 
		query.append("    ,TS.TS_CNT" ).append("\n"); 
		query.append("    ,ACM_GET_AGN_CD_FNC(TS.TS_FINC, TS.TS_SA_DT, @[bkg_cre_dt], @[rev_mon]) AS TS_FINC" ).append("\n"); 
		query.append("    ,ACM_GET_AGN_CD_FNC(TS.TS_AR,   TS.TS_SA_DT, @[bkg_cre_dt], @[rev_mon]) AS TS_AR" ).append("\n"); 
		query.append("    ,TS.TS_SLAN_CD" ).append("\n"); 
		query.append("    ,TS.TS_VSL_CD" ).append("\n"); 
		query.append("    ,TS.TS_SKD_VOY_NO" ).append("\n"); 
		query.append("    ,TS.TS_SKD_DIR_CD" ).append("\n"); 
		query.append("    ,TS.TS_RLANE_CD" ).append("\n"); 
		query.append("    ,TS.TS_REV_DIR_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    FROM " ).append("\n"); 
		query.append("     BKG_BOOKING B, BKG_RATE R" ).append("\n"); 
		query.append("    ,MDM_LOCATION L1,MDM_LOCATION L2,MDM_LOCATION L3,MDM_LOCATION L4" ).append("\n"); 
		query.append("    ,MDM_ORGANIZATION O1,MDM_ORGANIZATION O2,MDM_ORGANIZATION O3,MDM_ORGANIZATION O4,MDM_ORGANIZATION OB" ).append("\n"); 
		query.append("    ,MDM_ORGANIZATION O5 -- 용도 : B.CTRT_OFC_CD" ).append("\n"); 
		query.append("    ,MDM_ORGANIZATION O6 -- 용도 : B.OB_SLS_OFC_CD" ).append("\n"); 
		query.append("    ,(" ).append("\n"); 
		query.append("      SELECT" ).append("\n"); 
		query.append("            MAX(AGN_CD)    AS OB_CHN_AGN , " ).append("\n"); 
		query.append("            MAX(AR_OFC_CD) AS OB_CHN_AGN_AR" ).append("\n"); 
		query.append("      FROM (" ).append("\n"); 
		query.append("            SELECT " ).append("\n"); 
		query.append("                 I.AGN_CD , A.FINC_OFC_CD AS AR_OFC_CD" ).append("\n"); 
		query.append("            FROM BKG_CHN_AGN A, BKG_BOOKING K, ACM_OFC_INFO I" ).append("\n"); 
		query.append("            WHERE A.CHN_AGN_CD         = K.CHN_AGN_CD " ).append("\n"); 
		query.append("            AND   A.CHN_AGN_CD         = SUBSTR (I.AGN_CD, 4, 2) " ).append("\n"); 
		query.append("            AND   K.BKG_NO             = @[bkg_no]" ).append("\n"); 
		query.append("            AND   NVL(A.DELT_FLG,'N')  = 'N' " ).append("\n"); 
		query.append("            AND   I.AGN_CD             = SUBSTR(A.FINC_OFC_CD,1,3)||A.CHN_AGN_CD" ).append("\n"); 
		query.append("            AND   CASE " ).append("\n"); 
		query.append("                    WHEN I.AGN_TO_DT_CD = 'S' THEN @[ob_sa_dt] " ).append("\n"); 
		query.append("                    WHEN I.AGN_TO_DT_CD = 'B' THEN @[bkg_cre_dt]" ).append("\n"); 
		query.append("                    WHEN I.AGN_TO_DT_CD = 'R' THEN @[rev_mon]" ).append("\n"); 
		query.append("                  END  " ).append("\n"); 
		query.append("                    BETWEEN I.AGN_FM_DT AND I.AGN_TO_DT   " ).append("\n"); 
		query.append("            UNION ALL " ).append("\n"); 
		query.append("            SELECT ' ', ' '" ).append("\n"); 
		query.append("            FROM DUAL" ).append("\n"); 
		query.append("      )" ).append("\n"); 
		query.append("    )CN_OB" ).append("\n"); 
		query.append("    ,(" ).append("\n"); 
		query.append("      SELECT" ).append("\n"); 
		query.append("            MAX(AGN_CD)        AS IB_CHN_AGN , " ).append("\n"); 
		query.append("            MAX(AGN_AR_OFC_CD) AS IB_CHN_AGN_AR" ).append("\n"); 
		query.append("      FROM (" ).append("\n"); 
		query.append("            SELECT C.AGN_CD, C.AGN_AR_OFC_CD " ).append("\n"); 
		query.append("            FROM BKG_VVD V, BKG_BOOKING B, ACM_AGN_SET_NRTH_CHN_LANE C" ).append("\n"); 
		query.append("            WHERE 1=1" ).append("\n"); 
		query.append("            AND V.BKG_NO  = @[bkg_no]" ).append("\n"); 
		query.append("            AND B.BKG_NO  = V.BKG_NO" ).append("\n"); 
		query.append("            AND C.SLAN_CD IN ( V.SLAN_CD , 'ALL' ) " ).append("\n"); 
		query.append("            AND C.POD_CD  = B.POD_CD --> 기존 BKG_VVD.POD_CD 에서 BKG_BOOKING.POD_CD 로 임종한 과장님 확인 후 변경. FRA105311600 로 테스트 후 결정." ).append("\n"); 
		query.append("            AND NVL(C.DELT_FLG,'N') = 'N' " ).append("\n"); 
		query.append("            AND EXISTS (" ).append("\n"); 
		query.append("                SELECT 1 FROM ACM_OFC_INFO I" ).append("\n"); 
		query.append("                WHERE I.AGN_CD = C.AGN_CD" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("            UNION ALL " ).append("\n"); 
		query.append("            SELECT ' ', ' '" ).append("\n"); 
		query.append("            FROM DUAL" ).append("\n"); 
		query.append("      )" ).append("\n"); 
		query.append("    )CN_IB" ).append("\n"); 
		query.append("    ,(" ).append("\n"); 
		query.append("        SELECT BKG_NO," ).append("\n"); 
		query.append("               L.CONTI_CD AS TS_CNTI, L.SCONTI_CD AS TS_SCNTI, L.CNT_CD AS TS_CNT, L.FINC_CTRL_OFC_CD AS TS_FINC, O.AR_OFC_CD AS TS_AR," ).append("\n"); 
		query.append("               VSL_PRE_PST_CD, TS_LOC, TO_CHAR(DECODE(VSL_PRE_PST_CD,'S',VPS_ETA_DT,VPS_ETD_DT),'YYYYMMDD') AS TS_SA_DT," ).append("\n"); 
		query.append("               TS_VSL_CD,TS_SKD_VOY_NO, TS_SKD_DIR_CD, TS_SLAN_CD, TS_RLANE_CD, TS_REV_DIR_CD" ).append("\n"); 
		query.append("               " ).append("\n"); 
		query.append("        FROM (" ).append("\n"); 
		query.append("            SELECT V.BKG_NO, V.VSL_PRE_PST_CD, V.POL_CLPT_IND_SEQ, V.POD_CLPT_IND_SEQ, " ).append("\n"); 
		query.append("                   V.VSL_CD AS TS_VSL_CD, V.SKD_VOY_NO AS TS_SKD_VOY_NO, V.SKD_DIR_CD AS TS_SKD_DIR_CD ,V.SLAN_CD AS TS_SLAN_CD," ).append("\n"); 
		query.append("                   C.RLANE_CD AS TS_RLANE_CD, SUBSTR(C.FINC_DIR_CD,2,1) AS TS_REV_DIR_CD," ).append("\n"); 
		query.append("                   CASE WHEN VSL_PRE_PST_CD = 'S' AND VSL_SEQ = 1 THEN V.POD_CD" ).append("\n"); 
		query.append("                        WHEN VSL_PRE_PST_CD = 'S' AND VSL_SEQ = 2 THEN V.POD_CD" ).append("\n"); 
		query.append("                        WHEN VSL_PRE_PST_CD = 'S' AND VSL_SEQ = 3 THEN V.POD_CD" ).append("\n"); 
		query.append("                        WHEN VSL_PRE_PST_CD IN ('T','U') AND VSL_SEQ = 1 THEN V.POL_CD" ).append("\n"); 
		query.append("                        WHEN VSL_PRE_PST_CD IN ('T','U') AND VSL_SEQ = 2 THEN V.POL_CD" ).append("\n"); 
		query.append("                        WHEN VSL_PRE_PST_CD IN ('T','U') AND VSL_SEQ = 3 THEN V.POL_CD" ).append("\n"); 
		query.append("                   END  AS TS_LOC" ).append("\n"); 
		query.append("            FROM BKG_VVD V, MAS_RGST_BKG C" ).append("\n"); 
		query.append("            WHERE 1=1" ).append("\n"); 
		query.append("            AND V.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("            AND C.BKG_NO = V.BKG_NO" ).append("\n"); 
		query.append("            ORDER BY VSL_PRE_PST_CD,VSL_SEQ" ).append("\n"); 
		query.append("        )A" ).append("\n"); 
		query.append("        ,MDM_LOCATION L" ).append("\n"); 
		query.append("        ,MDM_ORGANIZATION O" ).append("\n"); 
		query.append("        ,VSK_VSL_PORT_SKD S" ).append("\n"); 
		query.append("        WHERE 1=1" ).append("\n"); 
		query.append("        AND TS_LOC IS NOT NULL " ).append("\n"); 
		query.append("        AND A.TS_LOC = L.LOC_CD" ).append("\n"); 
		query.append("        AND L.FINC_CTRL_OFC_CD = O.OFC_CD " ).append("\n"); 
		query.append("        AND S.VSL_CD           = A.TS_VSL_CD" ).append("\n"); 
		query.append("        AND S.SKD_VOY_NO       = A.TS_SKD_VOY_NO" ).append("\n"); 
		query.append("        AND S.SKD_DIR_CD       = A.TS_SKD_DIR_CD" ).append("\n"); 
		query.append("        AND S.VPS_PORT_CD      = A.TS_LOC" ).append("\n"); 
		query.append("        AND S.CLPT_IND_SEQ     = DECODE(VSL_PRE_PST_CD , 'S' , POD_CLPT_IND_SEQ , POL_CLPT_IND_SEQ )" ).append("\n"); 
		query.append("    )TS" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("    AND B.BKG_NO = @[bkg_no] -- 'AAR200100200'  " ).append("\n"); 
		query.append("    AND B.POR_CD = L1.LOC_CD" ).append("\n"); 
		query.append("    AND B.POL_CD = L2.LOC_CD" ).append("\n"); 
		query.append("    AND B.POD_CD = L3.LOC_CD" ).append("\n"); 
		query.append("    AND B.DEL_CD = L4.LOC_CD" ).append("\n"); 
		query.append("    AND L1.FINC_CTRL_OFC_CD = O1.OFC_CD " ).append("\n"); 
		query.append("    AND L2.FINC_CTRL_OFC_CD = O2.OFC_CD " ).append("\n"); 
		query.append("    AND L3.FINC_CTRL_OFC_CD = O3.OFC_CD " ).append("\n"); 
		query.append("    AND L4.FINC_CTRL_OFC_CD = O4.OFC_CD " ).append("\n"); 
		query.append("    AND B.CTRT_OFC_CD       = O5.OFC_CD " ).append("\n"); 
		query.append("    AND B.OB_SLS_OFC_CD     = O6.OFC_CD " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    AND B.BKG_OFC_CD = OB.OFC_CD" ).append("\n"); 
		query.append("    AND TS.BKG_NO(+) = B.BKG_NO " ).append("\n"); 
		query.append("    AND R.BKG_NO = B.BKG_NO " ).append("\n"); 
		query.append("    ) " ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    SELECT AGN_CD, AGN_AGMT_NO,IO_BND_CD,AC_TP_CD,AGN_AGMT_SEQ,HLG_DDCT_ORG_FLG,HLG_DDCT_DEST_FLG,FDRG_DDCT_ORG_FLG,FDRG_DDCT_DEST_FLG," ).append("\n"); 
		query.append("           OFT_PAY_TERM_CD,FULL_MTY_CD,AGMT_CURR_CD,COMM_FX_AMT,COMM_PAY_TERM_CD,REV_DIV_CD,COMM_RT," ).append("\n"); 
		query.append("           AR_OFC_CD,OFC_CURR_CD,XCH_RT_DIV_LVL,OFC_CHR_CD,VNDR_CNT_CD,VNDR_SEQ,AGN_INFO_SEQ,RHQ_CD," ).append("\n"); 
		query.append("           SUM_MAT_CNT,NO_CHK_ROUT,MAT_CNT_ROUT,LOC_CNT_ROUT,REAL_MAT_CNT_ROUT,NO_CHK_CNTR,MAT_CNT_CNTR," ).append("\n"); 
		query.append("           MAT_CNT_CHG,TS_SA_DT,TS_LOC ,TS_SLAN_CD ,TS_VSL_CD ,TS_SKD_VOY_NO ,TS_SKD_DIR_CD ,TS_RLANE_CD ,TS_REV_DIR_CD," ).append("\n"); 
		query.append("           CLT_OFC_CD,BKG_OFC,BKG_AR,POR_FINC,POR_AR,POL_FINC,POL_AR,POD_FINC,POD_AR,DEL_FINC,DEL_AR,VSL_PRE_PST_CD,TS_FINC,TS_AR," ).append("\n"); 
		query.append("           CHN_AGN_CD,CN_OB_FINC,CN_OB_AR,CN_IB_FINC,CN_IB_AR," ).append("\n"); 
		query.append("           RNK1," ).append("\n"); 
		query.append("           ROW_NUMBER() OVER (PARTITION BY AGN_CD, IO_BND_CD, AC_TP_CD ORDER BY AGN_AGMT_NO DESC ) DUP_CHK_CNT" ).append("\n"); 
		query.append("           " ).append("\n"); 
		query.append("           " ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("        SELECT AGN_CD, AGN_AGMT_NO,IO_BND_CD,AC_TP_CD,AGN_AGMT_SEQ,HLG_DDCT_ORG_FLG,HLG_DDCT_DEST_FLG,FDRG_DDCT_ORG_FLG,FDRG_DDCT_DEST_FLG," ).append("\n"); 
		query.append("               OFT_PAY_TERM_CD,FULL_MTY_CD,AGMT_CURR_CD,COMM_FX_AMT,COMM_PAY_TERM_CD,REV_DIV_CD,COMM_RT," ).append("\n"); 
		query.append("               AR_OFC_CD,OFC_CURR_CD,XCH_RT_DIV_LVL,OFC_CHR_CD,VNDR_CNT_CD,VNDR_SEQ," ).append("\n"); 
		query.append("               NO_CHK_ROUT+((nvl(length(REPLACE(MAT_CNT_ROUT,'0','')),0)*2))+NO_CHK_CNTR+MAT_CNT_CNTR AS SUM_MAT_CNT,AGN_INFO_SEQ,RHQ_CD," ).append("\n"); 
		query.append("               NO_CHK_ROUT,MAT_CNT_ROUT,LOC_CNT_ROUT,(DECODE(MAT_CNT_ROUT,LOC_CNT_ROUT,MAT_CNT_ROUT,0))AS REAL_MAT_CNT_ROUT,NO_CHK_CNTR,MAT_CNT_CNTR," ).append("\n"); 
		query.append("               MAT_CNT_CHG,TS_SA_DT,TS_LOC ,TS_SLAN_CD ,TS_VSL_CD ,TS_SKD_VOY_NO ,TS_SKD_DIR_CD ,TS_RLANE_CD ,TS_REV_DIR_CD," ).append("\n"); 
		query.append("               CLT_OFC_CD,BKG_OFC,BKG_AR,POR_FINC,POR_AR,POL_FINC,POL_AR,POD_FINC,POD_AR,DEL_FINC,DEL_AR,VSL_PRE_PST_CD,TS_FINC,TS_AR," ).append("\n"); 
		query.append("               CHN_AGN_CD,CN_OB_FINC,CN_OB_AR,CN_IB_FINC,CN_IB_AR," ).append("\n"); 
		query.append("               --ROW_NUMBER() OVER (PARTITION BY AGN_AGMT_NO,IO_BND_CD,AC_TP_CD ORDER BY NO_CHK_ROUT+(DECODE(MAT_CNT_ROUT,LOC_CNT_ROUT,MAT_CNT_ROUT,0))+NO_CHK_CNTR+MAT_CNT_CNTR DESC ) RNK1 -- 모든 처리 했음에도 RNK가 2개 이상 나오는지 재 확인 한다. " ).append("\n"); 
		query.append("               ROW_NUMBER() OVER (PARTITION BY AGN_AGMT_NO,IO_BND_CD,AC_TP_CD ORDER BY OFC_MAT_CNT+NO_CHK_ROUT+((nvl(length(REPLACE(MAT_CNT_ROUT,'0','')),0)*2))+NO_CHK_CNTR+MAT_CNT_CNTR DESC ) RNK1" ).append("\n"); 
		query.append("        FROM (" ).append("\n"); 
		query.append("            SELECT D.AGN_CD, D.AGN_AGMT_NO, D.IO_BND_CD, D.AC_TP_CD, D.AGN_AGMT_SEQ" ).append("\n"); 
		query.append("            , DECODE(NVL(D.HLG_DDCT_ORG_FLG  ,'0'),'0','N','Y')  AS HLG_DDCT_ORG_FLG" ).append("\n"); 
		query.append("            , DECODE(NVL(D.HLG_DDCT_DEST_FLG ,'0'),'0','N','Y')  AS HLG_DDCT_DEST_FLG" ).append("\n"); 
		query.append("            , DECODE(NVL(D.FDRG_DDCT_ORG_FLG ,'0'),'0','N','Y')  AS FDRG_DDCT_ORG_FLG" ).append("\n"); 
		query.append("            , DECODE(NVL(D.FDRG_DDCT_DEST_FLG,'0'),'0','N','Y')  AS FDRG_DDCT_DEST_FLG" ).append("\n"); 
		query.append("            " ).append("\n"); 
		query.append("            , NVL(D.OFT_PAY_TERM_CD   ,'X')                      AS OFT_PAY_TERM_CD" ).append("\n"); 
		query.append("            , NVL(D.FULL_MTY_CD       ,'N')                      AS FULL_MTY_CD" ).append("\n"); 
		query.append("            , NVL(D.CURR_CD           ,'AAA')                    AS AGMT_CURR_CD" ).append("\n"); 
		query.append("            , DECODE(D.COMM_FX_AMT    ,'','X',D.COMM_FX_AMT)     AS COMM_FX_AMT" ).append("\n"); 
		query.append("            , NVL(D.COMM_PAY_TERM_CD  ,'X')                      AS COMM_PAY_TERM_CD" ).append("\n"); 
		query.append("            , NVL(D.REV_DIV_CD        ,'X')                      AS REV_DIV_CD" ).append("\n"); 
		query.append("            , DECODE(D.COMM_RT        ,'','X',D.COMM_RT)         AS COMM_RT" ).append("\n"); 
		query.append("            , NVL(I.AR_OFC_CD         ,'BBB')                    AS AR_OFC_CD" ).append("\n"); 
		query.append("            , NVL(I.CURR_CD           ,'BBB')                    AS OFC_CURR_CD" ).append("\n"); 
		query.append("            , NVL(I.XCH_RT_DIV_LVL    ,'0')                      AS XCH_RT_DIV_LVL" ).append("\n"); 
		query.append("            , NVL(I.OFC_CHR_CD        ,'0')                      AS OFC_CHR_CD" ).append("\n"); 
		query.append("            , NVL(I.VNDR_CNT_CD       ,'0')                      AS VNDR_CNT_CD" ).append("\n"); 
		query.append("            , NVL(I.VNDR_SEQ          ,'0')                      AS VNDR_SEQ" ).append("\n"); 
		query.append("            , NVL(I.AGN_INFO_SEQ      ,'0')                      AS AGN_INFO_SEQ" ).append("\n"); 
		query.append("            , NVL(I.RHQ_CD            ,'0')                      AS RHQ_CD" ).append("\n"); 
		query.append("            , DECODE(D.AC_TP_CD, 'S', A.TS_SA_DT     , '')       AS TS_SA_DT" ).append("\n"); 
		query.append("            , DECODE(D.AC_TP_CD, 'S', A.TS_LOC       , '')       AS TS_LOC" ).append("\n"); 
		query.append("            , DECODE(D.AC_TP_CD, 'S', A.TS_SLAN_CD   , '')       AS TS_SLAN_CD" ).append("\n"); 
		query.append("            , DECODE(D.AC_TP_CD, 'S', A.TS_VSL_CD    , '')       AS TS_VSL_CD" ).append("\n"); 
		query.append("            , DECODE(D.AC_TP_CD, 'S', A.TS_SKD_VOY_NO, '')       AS TS_SKD_VOY_NO" ).append("\n"); 
		query.append("            , DECODE(D.AC_TP_CD, 'S', A.TS_SKD_DIR_CD, '')       AS TS_SKD_DIR_CD" ).append("\n"); 
		query.append("            , DECODE(D.AC_TP_CD, 'S', A.TS_RLANE_CD  , '')       AS TS_RLANE_CD" ).append("\n"); 
		query.append("            , DECODE(D.AC_TP_CD, 'S', A.TS_REV_DIR_CD, '')       AS TS_REV_DIR_CD" ).append("\n"); 
		query.append("            , CLT_OFC_CD,BKG_OFC,BKG_AR,POR_FINC,POR_AR,POL_FINC,POL_AR,POD_FINC,POD_AR,DEL_FINC,DEL_AR,VSL_PRE_PST_CD,TS_FINC,TS_AR" ).append("\n"); 
		query.append("            , CHN_AGN_CD,CN_OB_FINC,CN_OB_AR,CN_IB_FINC,CN_IB_AR" ).append("\n"); 
		query.append("            , DECODE(NVL(I.AGN_CD,'BBB') , NVL(D.AGN_CD,'BB') ,'1','0') AS OFC_MAT_CNT --[선처리] 계약의 agn_cd 와 office info 의 agn_cd 가 같은경우 우선순위 부여" ).append("\n"); 
		query.append("            ,(SELECT DECODE(COUNT(1),0,1,0)" ).append("\n"); 
		query.append("              FROM  ACM_SIM_AGMT_DTL_ROUT R " ).append("\n"); 
		query.append("              WHERE 1=1" ).append("\n"); 
		query.append("                AND R.AGN_CD       = D.AGN_CD " ).append("\n"); 
		query.append("                AND R.AGN_AGMT_NO  = D.AGN_AGMT_NO " ).append("\n"); 
		query.append("                AND R.IO_BND_CD    = D.IO_BND_CD " ).append("\n"); 
		query.append("                AND R.AC_TP_CD     = D.AC_TP_CD " ).append("\n"); 
		query.append("                AND R.AGN_AGMT_SEQ = D.AGN_AGMT_SEQ " ).append("\n"); 
		query.append("                )                                       AS NO_CHK_ROUT" ).append("\n"); 
		query.append("            ,(--SELECT COUNT(COUNT(ROUT_REF_DIV_CD)) * 2 " ).append("\n"); 
		query.append("              SELECT nvl ( sum(avg (case 	when ROUT_REF_DIV_CD = 'POR' THEN '1000' " ).append("\n"); 
		query.append("                          					when ROUT_REF_DIV_CD = 'POL' THEN '0100' " ).append("\n"); 
		query.append("                          					when ROUT_REF_DIV_CD = 'POD' THEN '0010' " ).append("\n"); 
		query.append("                          					when ROUT_REF_DIV_CD = 'DEL' THEN '0001' ELSE '0000' END ) ) , 0 )" ).append("\n"); 
		query.append("              FROM  ACM_SIM_AGMT_DTL_ROUT R" ).append("\n"); 
		query.append("              WHERE 1=1" ).append("\n"); 
		query.append("                AND R.AGN_CD       = D.AGN_CD " ).append("\n"); 
		query.append("                AND R.AGN_AGMT_NO  = D.AGN_AGMT_NO " ).append("\n"); 
		query.append("                AND R.IO_BND_CD    = D.IO_BND_CD " ).append("\n"); 
		query.append("                AND R.AC_TP_CD     = D.AC_TP_CD " ).append("\n"); 
		query.append("                AND R.AGN_AGMT_SEQ = D.AGN_AGMT_SEQ " ).append("\n"); 
		query.append("                AND LENGTH(R.ROUT_REF_DIV_CD) = 3" ).append("\n"); 
		query.append("              GROUP BY ROUT_REF_DIV_CD " ).append("\n"); 
		query.append("                )                                       AS LOC_CNT_ROUT" ).append("\n"); 
		query.append("            ,(--SELECT COUNT(1)*2 -- DECODE(COUNT(1),0,0,2)" ).append("\n"); 
		query.append("              SELECT nvl ( sum(avg (case    when ROUT_REF_DIV_CD = 'POR' THEN '1000' " ).append("\n"); 
		query.append("                                            when ROUT_REF_DIV_CD = 'POL' THEN '0100' " ).append("\n"); 
		query.append("                                            when ROUT_REF_DIV_CD = 'POD' THEN '0010' " ).append("\n"); 
		query.append("                                            when ROUT_REF_DIV_CD = 'DEL' THEN '0001' ELSE '0000' END ) ) , 0 )" ).append("\n"); 
		query.append("              FROM  ACM_SIM_AGMT_DTL_ROUT R , A" ).append("\n"); 
		query.append("              WHERE 1=1" ).append("\n"); 
		query.append("                AND R.AGN_CD       = D.AGN_CD " ).append("\n"); 
		query.append("                AND R.AGN_AGMT_NO  = D.AGN_AGMT_NO " ).append("\n"); 
		query.append("                AND R.IO_BND_CD    = D.IO_BND_CD " ).append("\n"); 
		query.append("                AND R.AC_TP_CD     = D.AC_TP_CD " ).append("\n"); 
		query.append("                AND R.AGN_AGMT_SEQ = D.AGN_AGMT_SEQ " ).append("\n"); 
		query.append("                AND R.ROUT_INFO_CD = CASE " ).append("\n"); 
		query.append("                                         WHEN R.ROUT_LVL_CD = 1 AND R.ROUT_REF_DIV_CD = 'POR' THEN A.POR_CNTI" ).append("\n"); 
		query.append("                                         WHEN R.ROUT_LVL_CD = 1 AND R.ROUT_REF_DIV_CD = 'POL' THEN A.POL_CNTI" ).append("\n"); 
		query.append("                                         WHEN R.ROUT_LVL_CD = 1 AND R.ROUT_REF_DIV_CD = 'POD' THEN A.POD_CNTI" ).append("\n"); 
		query.append("                                         WHEN R.ROUT_LVL_CD = 1 AND R.ROUT_REF_DIV_CD = 'DEL' THEN A.DEL_CNTI" ).append("\n"); 
		query.append("                                         WHEN R.ROUT_LVL_CD = 2 AND R.ROUT_REF_DIV_CD = 'POR' THEN A.POR_SCNTI" ).append("\n"); 
		query.append("                                         WHEN R.ROUT_LVL_CD = 2 AND R.ROUT_REF_DIV_CD = 'POL' THEN A.POL_SCNTI" ).append("\n"); 
		query.append("                                         WHEN R.ROUT_LVL_CD = 2 AND R.ROUT_REF_DIV_CD = 'POD' THEN A.POD_SCNTI" ).append("\n"); 
		query.append("                                         WHEN R.ROUT_LVL_CD = 2 AND R.ROUT_REF_DIV_CD = 'DEL' THEN A.DEL_SCNTI" ).append("\n"); 
		query.append("                                         WHEN R.ROUT_LVL_CD = 3 AND R.ROUT_REF_DIV_CD = 'POR' THEN A.POR_CNT" ).append("\n"); 
		query.append("                                         WHEN R.ROUT_LVL_CD = 3 AND R.ROUT_REF_DIV_CD = 'POL' THEN A.POL_CNT" ).append("\n"); 
		query.append("                                         WHEN R.ROUT_LVL_CD = 3 AND R.ROUT_REF_DIV_CD = 'POD' THEN A.POD_CNT" ).append("\n"); 
		query.append("                                         WHEN R.ROUT_LVL_CD = 3 AND R.ROUT_REF_DIV_CD = 'DEL' THEN A.DEL_CNT" ).append("\n"); 
		query.append("                                         WHEN R.ROUT_LVL_CD = 4 AND R.ROUT_REF_DIV_CD = 'POR' THEN A.POR_CD" ).append("\n"); 
		query.append("                                         WHEN R.ROUT_LVL_CD = 4 AND R.ROUT_REF_DIV_CD = 'POL' THEN A.POL_CD" ).append("\n"); 
		query.append("                                         WHEN R.ROUT_LVL_CD = 4 AND R.ROUT_REF_DIV_CD = 'POD' THEN A.POD_CD" ).append("\n"); 
		query.append("                                         WHEN R.ROUT_LVL_CD = 4 AND R.ROUT_REF_DIV_CD = 'DEL' THEN A.DEL_CD" ).append("\n"); 
		query.append("                                     END" ).append("\n"); 
		query.append("                GROUP BY R.ROUT_REF_DIV_CD" ).append("\n"); 
		query.append("                )                                       AS MAT_CNT_ROUT" ).append("\n"); 
		query.append("            ,(SELECT DECODE(COUNT(1),0,1,0)" ).append("\n"); 
		query.append("              FROM  ACM_SIM_AGMT_DTL_CNTR C" ).append("\n"); 
		query.append("              WHERE C.AGN_CD       = D.AGN_CD " ).append("\n"); 
		query.append("                AND C.AGN_AGMT_NO  = D.AGN_AGMT_NO " ).append("\n"); 
		query.append("                AND C.IO_BND_CD    = D.IO_BND_CD " ).append("\n"); 
		query.append("                AND C.AC_TP_CD     = D.AC_TP_CD " ).append("\n"); 
		query.append("                AND C.AGN_AGMT_SEQ = D.AGN_AGMT_SEQ " ).append("\n"); 
		query.append("                AND C.CNTR_TPSZ_CD in (SELECT CNTR_TPSZ_CD FROM BKG_CONTAINER WHERE BKG_NO = @[bkg_no] )" ).append("\n"); 
		query.append("               )                                        AS NO_CHK_CNTR" ).append("\n"); 
		query.append("            ,(SELECT DECODE(COUNT(1),0,0,2)" ).append("\n"); 
		query.append("              FROM  ACM_SIM_AGMT_DTL_CNTR C" ).append("\n"); 
		query.append("              WHERE C.AGN_CD       = D.AGN_CD " ).append("\n"); 
		query.append("                AND C.AGN_AGMT_NO  = D.AGN_AGMT_NO " ).append("\n"); 
		query.append("                AND C.IO_BND_CD    = D.IO_BND_CD " ).append("\n"); 
		query.append("                AND C.AC_TP_CD     = D.AC_TP_CD " ).append("\n"); 
		query.append("                AND C.AGN_AGMT_SEQ = D.AGN_AGMT_SEQ " ).append("\n"); 
		query.append("                AND C.CNTR_TPSZ_CD in (SELECT CNTR_TPSZ_CD FROM BKG_CONTAINER WHERE BKG_NO = @[bkg_no] )" ).append("\n"); 
		query.append("               )                                        AS MAT_CNT_CNTR" ).append("\n"); 
		query.append("            ,(SELECT DECODE(COUNT(1),0,0,1) " ).append("\n"); 
		query.append("              FROM  ACM_SIM_AGMT_DTL_CHG  H " ).append("\n"); 
		query.append("              WHERE H.AGN_CD       = D.AGN_CD " ).append("\n"); 
		query.append("                AND H.AGN_AGMT_NO  = D.AGN_AGMT_NO " ).append("\n"); 
		query.append("                AND H.IO_BND_CD    = D.IO_BND_CD " ).append("\n"); 
		query.append("                AND H.AC_TP_CD     = D.AC_TP_CD " ).append("\n"); 
		query.append("                AND H.AGN_AGMT_SEQ = D.AGN_AGMT_SEQ " ).append("\n"); 
		query.append("              )                                         AS MAT_CNT_CHG" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("            FROM ACM_SIM_AGMT_DTL D" ).append("\n"); 
		query.append("                ,ACM_SIM_AGMT_MST M" ).append("\n"); 
		query.append("                ,ACM_OFC_INFO I" ).append("\n"); 
		query.append("                ,A" ).append("\n"); 
		query.append("                ,(SELECT DISTINCT OFC_GRP_ID " ).append("\n"); 
		query.append("                  FROM A, ACM_OFC_INFO I " ).append("\n"); 
		query.append("                  WHERE I.AGN_CD IN (A.BKG_OFC, A.BKG_AR, A.CLT_OFC_CD" ).append("\n"); 
		query.append("                                    ,A.CTRT_OFC_CD,CTRT_AR" ).append("\n"); 
		query.append("                                    ,A.OB_SLS_OFC_CD,OB_SLS_AR" ).append("\n"); 
		query.append("                                    ,A.POR_FINC, A.POL_FINC, A.POD_FINC, A.DEL_FINC" ).append("\n"); 
		query.append("                                    ,A.POR_AR, A.POL_AR, A.POD_AR, A.DEL_AR" ).append("\n"); 
		query.append("                                    ,A.TS_FINC" ).append("\n"); 
		query.append("                                    ,A.TS_AR" ).append("\n"); 
		query.append("                                    ,A.CN_OB_FINC" ).append("\n"); 
		query.append("                                    ,A.CN_OB_AR" ).append("\n"); 
		query.append("                                    ,A.CN_IB_FINC" ).append("\n"); 
		query.append("                                    ,A.CN_IB_AR" ).append("\n"); 
		query.append("                                    ,A.CHN_AGN_CD" ).append("\n"); 
		query.append("                                    ) " ).append("\n"); 
		query.append("                 )B" ).append("\n"); 
		query.append("                ,(SELECT DISTINCT AC_TP_CD FROM ACM_COMM_TP_CD_MAPG WHERE AC_TP_CD IS NOT NULL " ).append("\n"); 
		query.append("                 )C" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("            WHERE 1=1" ).append("\n"); 
		query.append("            AND M.AGN_CD IN (I.AGN_CD, I.OFC_CD) -- [CHM-201325074] 대리점 조회 로직 변경" ).append("\n"); 
		query.append("            AND I.OFC_GRP_ID IN B.OFC_GRP_ID" ).append("\n"); 
		query.append("            AND CASE " ).append("\n"); 
		query.append("                     WHEN I.AGN_FM_DT_CD = 'S' AND  D.AC_TP_CD  = 'S' THEN A.TS_SA_DT " ).append("\n"); 
		query.append("                     WHEN I.AGN_FM_DT_CD = 'S' AND  D.IO_BND_CD = 'O' THEN @[ob_sa_dt] " ).append("\n"); 
		query.append("                     WHEN I.AGN_FM_DT_CD = 'S' AND  D.IO_BND_CD = 'I' THEN @[ib_sa_dt]" ).append("\n"); 
		query.append("                     WHEN I.AGN_FM_DT_CD = 'B' THEN @[bkg_cre_dt]" ).append("\n"); 
		query.append("                     WHEN I.AGN_FM_DT_CD = 'R' THEN @[rev_mon]" ).append("\n"); 
		query.append("                END  " ).append("\n"); 
		query.append("                     BETWEEN I.AGN_FM_DT AND I.AGN_TO_DT" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("            AND CASE " ).append("\n"); 
		query.append("                     WHEN I.AGN_TO_DT_CD = 'S' AND  D.AC_TP_CD  = 'S' THEN A.TS_SA_DT " ).append("\n"); 
		query.append("                     WHEN I.AGN_TO_DT_CD = 'S' AND  D.IO_BND_CD = 'O' THEN @[ob_sa_dt] " ).append("\n"); 
		query.append("                     WHEN I.AGN_TO_DT_CD = 'S' AND  D.IO_BND_CD = 'I' THEN @[ib_sa_dt]" ).append("\n"); 
		query.append("                     WHEN I.AGN_TO_DT_CD = 'B' THEN @[bkg_cre_dt]" ).append("\n"); 
		query.append("                     WHEN I.AGN_TO_DT_CD = 'R' THEN @[rev_mon]" ).append("\n"); 
		query.append("                END  " ).append("\n"); 
		query.append("                     BETWEEN I.AGN_FM_DT AND I.AGN_TO_DT" ).append("\n"); 
		query.append("            " ).append("\n"); 
		query.append("            AND D.OFC_CD = CASE WHEN I.OFC_CHR_CD IN (3,4) " ).append("\n"); 
		query.append("                                THEN " ).append("\n"); 
		query.append("                                    CASE " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                        WHEN D.OFC_SET_TP_CD = 'B' AND D.IO_BND_CD = 'O' THEN NVL(A.CN_OB_FINC,A.CN_OB_AR)" ).append("\n"); 
		query.append("                                        WHEN D.OFC_SET_TP_CD = 'B' AND D.IO_BND_CD = 'I' THEN NVL(A.CN_IB_FINC,A.CN_IB_AR)" ).append("\n"); 
		query.append("                                        WHEN D.OFC_SET_TP_CD = 'C' THEN DECODE((SELECT COUNT(*)" ).append("\n"); 
		query.append("                                                                                FROM BKG_RATE" ).append("\n"); 
		query.append("                                                                                WHERE BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("                                                                                AND (PPD_RCV_OFC_CD = D.OFC_CD" ).append("\n"); 
		query.append("                                                                                OR CLT_OFC_CD = D.OFC_CD))" ).append("\n"); 
		query.append("                                                                                +" ).append("\n"); 
		query.append("                                                                               (SELECT COUNT(*) " ).append("\n"); 
		query.append("                                                                                FROM BKG_CHG_RT " ).append("\n"); 
		query.append("                                                                                WHERE BKG_NO = A.BKG_NO " ).append("\n"); 
		query.append("                                                                                AND N3PTY_RCV_OFC_CD = D.OFC_CD), 0, 'XXXXX', D.OFC_CD)" ).append("\n"); 
		query.append("                                        --[선처리] Office setting 에 Contract Office, Loading Office 추가" ).append("\n"); 
		query.append("                                        WHEN D.OFC_SET_TP_CD = 'T' THEN NVL(A.CTRT_OFC_CD,CTRT_AR)" ).append("\n"); 
		query.append("                                        WHEN D.OFC_SET_TP_CD = 'L' THEN NVL(A.OB_SLS_OFC_CD,OB_SLS_AR)" ).append("\n"); 
		query.append("                                        --" ).append("\n"); 
		query.append("                                        WHEN D.OFC_SET_TP_CD = 'G' THEN A.CHN_AGN_CD" ).append("\n"); 
		query.append("                                        WHEN D.OFC_SET_TP_CD = 'F' AND D.OFC_CVRG_CD = 'POR' THEN NVL(A.CN_OB_FINC,A.CN_OB_AR)" ).append("\n"); 
		query.append("                                        WHEN D.OFC_SET_TP_CD = 'F' AND D.OFC_CVRG_CD = 'POL' THEN NVL(A.CN_OB_FINC,A.CN_OB_AR)" ).append("\n"); 
		query.append("                                        WHEN D.OFC_SET_TP_CD = 'F' AND D.OFC_CVRG_CD = 'POD' THEN NVL(A.CN_IB_FINC,A.CN_IB_AR)" ).append("\n"); 
		query.append("                                        WHEN D.OFC_SET_TP_CD = 'F' AND D.OFC_CVRG_CD = 'DEL' THEN NVL(A.CN_IB_FINC,A.CN_IB_AR)" ).append("\n"); 
		query.append("                                        " ).append("\n"); 
		query.append("                                        WHEN D.OFC_SET_TP_CD = 'A' AND D.OFC_CVRG_CD = 'POR' THEN A.CN_OB_AR" ).append("\n"); 
		query.append("                                        WHEN D.OFC_SET_TP_CD = 'A' AND D.OFC_CVRG_CD = 'POL' THEN A.CN_OB_AR" ).append("\n"); 
		query.append("                                        WHEN D.OFC_SET_TP_CD = 'A' AND D.OFC_CVRG_CD = 'POD' THEN A.CN_IB_AR" ).append("\n"); 
		query.append("                                        WHEN D.OFC_SET_TP_CD = 'A' AND D.OFC_CVRG_CD = 'DEL' THEN A.CN_IB_AR" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                        WHEN D.OFC_SET_TP_CD = 'F' AND D.IO_BND_CD = 'O' THEN NVL(A.CN_OB_FINC,A.CN_OB_AR)" ).append("\n"); 
		query.append("                                        WHEN D.OFC_SET_TP_CD = 'F' AND D.IO_BND_CD = 'I' THEN NVL(A.CN_IB_FINC,A.CN_IB_AR)" ).append("\n"); 
		query.append("                                        WHEN D.OFC_SET_TP_CD = 'A' AND D.IO_BND_CD = 'O' THEN A.CN_OB_AR" ).append("\n"); 
		query.append("                                        WHEN D.OFC_SET_TP_CD = 'A' AND D.IO_BND_CD = 'I' THEN A.CN_IB_AR" ).append("\n"); 
		query.append("                                    END" ).append("\n"); 
		query.append("                                " ).append("\n"); 
		query.append("                                ELSE" ).append("\n"); 
		query.append("                                    CASE " ).append("\n"); 
		query.append("                                    " ).append("\n"); 
		query.append("                                        WHEN D.OFC_SET_TP_CD = 'B' THEN NVL(A.BKG_OFC,A.BKG_AR)" ).append("\n"); 
		query.append("                                        " ).append("\n"); 
		query.append("                                        WHEN D.OFC_SET_TP_CD = 'C' THEN DECODE((SELECT COUNT(*)" ).append("\n"); 
		query.append("                                                                                FROM BKG_RATE" ).append("\n"); 
		query.append("                                                                                WHERE BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("                                                                                AND (PPD_RCV_OFC_CD = D.OFC_CD" ).append("\n"); 
		query.append("                                                                                OR CLT_OFC_CD = D.OFC_CD))" ).append("\n"); 
		query.append("                                                                                +" ).append("\n"); 
		query.append("                                                                               (SELECT COUNT(*) " ).append("\n"); 
		query.append("                                                                                FROM BKG_CHG_RT " ).append("\n"); 
		query.append("                                                                                WHERE BKG_NO = A.BKG_NO " ).append("\n"); 
		query.append("                                                                                AND N3PTY_RCV_OFC_CD = D.OFC_CD), 0, 'XXXXX', D.OFC_CD)" ).append("\n"); 
		query.append("                                        --[선처리] Office setting 에 Contract Office, Loading Office 추가" ).append("\n"); 
		query.append("                                        WHEN D.OFC_SET_TP_CD = 'T' THEN NVL(A.CTRT_OFC_CD,CTRT_AR)" ).append("\n"); 
		query.append("                                        WHEN D.OFC_SET_TP_CD = 'L' THEN NVL(A.OB_SLS_OFC_CD,OB_SLS_AR)" ).append("\n"); 
		query.append("                                        -- " ).append("\n"); 
		query.append("                                        WHEN D.OFC_SET_TP_CD = 'G' THEN A.CHN_AGN_CD" ).append("\n"); 
		query.append("                                        " ).append("\n"); 
		query.append("                                        WHEN D.OFC_SET_TP_CD = 'F' AND D.OFC_CVRG_CD = 'POR' THEN NVL(A.POR_FINC,A.POR_AR) -->  D.OFC_CD = A.POR_FINC 조건 추가 이유 = POR_FINC 와 Match 되는 계약이 없을 경우는 POR_FINC 의 AR_OFC_CD 로 계약을 찾는다." ).append("\n"); 
		query.append("                                        WHEN D.OFC_SET_TP_CD = 'F' AND D.OFC_CVRG_CD = 'POL' THEN NVL(A.POL_FINC,A.POL_AR) " ).append("\n"); 
		query.append("                                        WHEN D.OFC_SET_TP_CD = 'F' AND D.OFC_CVRG_CD = 'POD' THEN NVL(A.POD_FINC,A.POD_AR)" ).append("\n"); 
		query.append("                                        WHEN D.OFC_SET_TP_CD = 'F' AND D.OFC_CVRG_CD = 'DEL' THEN NVL(A.DEL_FINC,A.DEL_AR)" ).append("\n"); 
		query.append("                                        " ).append("\n"); 
		query.append("                                        WHEN D.OFC_SET_TP_CD = 'A' AND D.OFC_CVRG_CD = 'POR' THEN A.POR_AR" ).append("\n"); 
		query.append("                                        WHEN D.OFC_SET_TP_CD = 'A' AND D.OFC_CVRG_CD = 'POL' THEN A.POL_AR" ).append("\n"); 
		query.append("                                        WHEN D.OFC_SET_TP_CD = 'A' AND D.OFC_CVRG_CD = 'POD' THEN A.POD_AR" ).append("\n"); 
		query.append("                                        WHEN D.OFC_SET_TP_CD = 'A' AND D.OFC_CVRG_CD = 'DEL' THEN A.DEL_AR" ).append("\n"); 
		query.append("                                        " ).append("\n"); 
		query.append("                                        WHEN D.OFC_SET_TP_CD = 'F' AND D.OFC_CVRG_CD = 'PRE' AND  A.VSL_PRE_PST_CD =  'S' THEN NVL(A.TS_FINC,A.TS_AR)" ).append("\n"); 
		query.append("                                        WHEN D.OFC_SET_TP_CD = 'F' AND D.OFC_CVRG_CD = 'PST' AND  A.VSL_PRE_PST_CD <> 'S' THEN NVL(A.TS_FINC,A.TS_AR)" ).append("\n"); 
		query.append("                                        " ).append("\n"); 
		query.append("                                        WHEN D.OFC_SET_TP_CD = 'A' AND D.OFC_CVRG_CD = 'PRE' AND  A.VSL_PRE_PST_CD =  'S' THEN A.TS_AR" ).append("\n"); 
		query.append("                                        WHEN D.OFC_SET_TP_CD = 'A' AND D.OFC_CVRG_CD = 'PST' AND  A.VSL_PRE_PST_CD <> 'S' THEN A.TS_AR" ).append("\n"); 
		query.append("                                    END" ).append("\n"); 
		query.append("                           END " ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("            AND D.AGN_AGMT_NO = M.AGN_AGMT_NO" ).append("\n"); 
		query.append("            AND D.AC_TP_CD    = C.AC_TP_CD" ).append("\n"); 
		query.append("            AND D.AC_TP_CD    = CASE WHEN D.AC_TP_CD = 'C' AND POR_AR = BKG_AR THEN ' ' --> Cross 계정은  POR_AR <> BKG_AR 일때만 지급한다." ).append("\n"); 
		query.append("                                     ELSE D.AC_TP_CD" ).append("\n"); 
		query.append("                                END" ).append("\n"); 
		query.append("             " ).append("\n"); 
		query.append("            " ).append("\n"); 
		query.append("            AND NVL(M.DELT_FLG,'N') = 'N' " ).append("\n"); 
		query.append("                " ).append("\n"); 
		query.append("            AND CASE " ).append("\n"); 
		query.append("                     WHEN M.AGMT_FM_DT_CD = 'S' AND  D.AC_TP_CD  = 'S' THEN A.TS_SA_DT " ).append("\n"); 
		query.append("                     WHEN M.AGMT_FM_DT_CD = 'S' AND  D.IO_BND_CD = 'O' THEN @[ob_sa_dt] " ).append("\n"); 
		query.append("                     WHEN M.AGMT_FM_DT_CD = 'S' AND  D.IO_BND_CD = 'I' THEN @[ib_sa_dt]" ).append("\n"); 
		query.append("                     WHEN M.AGMT_FM_DT_CD = 'B' THEN @[bkg_cre_dt]" ).append("\n"); 
		query.append("                     WHEN M.AGMT_FM_DT_CD = 'R' THEN @[rev_mon]" ).append("\n"); 
		query.append("                END  " ).append("\n"); 
		query.append("                     BETWEEN M.AGMT_FM_DT AND M.AGMT_TO_DT" ).append("\n"); 
		query.append("            " ).append("\n"); 
		query.append("            AND CASE " ).append("\n"); 
		query.append("                     WHEN M.AGMT_TO_DT_CD = 'S' AND  D.AC_TP_CD  = 'S' THEN A.TS_SA_DT " ).append("\n"); 
		query.append("                     WHEN M.AGMT_TO_DT_CD = 'S' AND  D.IO_BND_CD = 'O' THEN @[ob_sa_dt] " ).append("\n"); 
		query.append("                     WHEN M.AGMT_TO_DT_CD = 'S' AND  D.IO_BND_CD = 'I' THEN @[ib_sa_dt]" ).append("\n"); 
		query.append("                     WHEN M.AGMT_TO_DT_CD = 'B' THEN @[bkg_cre_dt]" ).append("\n"); 
		query.append("                     WHEN M.AGMT_TO_DT_CD = 'R' THEN @[rev_mon]" ).append("\n"); 
		query.append("                END  " ).append("\n"); 
		query.append("                     BETWEEN M.AGMT_FM_DT AND M.AGMT_TO_DT" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("    WHERE 1=1 " ).append("\n"); 
		query.append("    AND CASE WHEN LOC_CNT_ROUT > 0 and MAT_CNT_ROUT = LOC_CNT_ROUT then 1" ).append("\n"); 
		query.append("             WHEN LOC_CNT_ROUT = 0 and MAT_CNT_ROUT = 0 then 1" ).append("\n"); 
		query.append("             ELSE 0 END = 1" ).append("\n"); 
		query.append("    ORDER BY  AGN_AGMT_NO,IO_BND_CD,AC_TP_CD, NO_CHK_ROUT+(nvl(length(REPLACE(MAT_CNT_ROUT,'0','')),0)*2)+NO_CHK_CNTR+MAT_CNT_CNTR DESC " ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("    WHERE RNK1 = 1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 

	}
}