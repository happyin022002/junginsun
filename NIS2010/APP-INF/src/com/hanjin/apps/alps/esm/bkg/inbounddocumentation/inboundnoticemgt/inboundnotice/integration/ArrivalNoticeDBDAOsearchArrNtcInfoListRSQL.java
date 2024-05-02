/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ArrivalNoticeDBDAOsearchArrNtcInfoListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.15
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.15 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ArrivalNoticeDBDAOsearchArrNtcInfoListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 0672-1
	  * </pre>
	  */
	public ArrivalNoticeDBDAOsearchArrNtcInfoListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("c_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_ref_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vps_eta_dt_end",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ts_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("is_validated",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vps_eta_dt_start",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration").append("\n"); 
		query.append("FileName : ArrivalNoticeDBDAOsearchArrNtcInfoListRSQL").append("\n"); 
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
		query.append("SELECT INQS.BKG_NO          AS BKG_NO" ).append("\n"); 
		query.append("	 , INQS.VSL_FLG			AS VSL_FLG" ).append("\n"); 
		query.append("	 , INQS.VSL_FLG_CNT_NM  AS VSL_FLG_CNT_NM" ).append("\n"); 
		query.append("     , INQS.VSL_CD          AS VSL_CD     " ).append("\n"); 
		query.append("     , INQS.SKD_VOY_NO      AS SKD_VOY_NO " ).append("\n"); 
		query.append("     , INQS.SKD_DIR_CD      AS SKD_DIR_CD  " ).append("\n"); 
		query.append("     , INQS.VSL_NM          AS VSL_NM" ).append("\n"); 
		query.append("     , INQS.BL_NO           AS BL_NO     " ).append("\n"); 
		query.append("     , INQS.DE_TERM_CD      AS DE_TERM_CD" ).append("\n"); 
		query.append("     , INQS.DEL_CD          AS DEL_CD     " ).append("\n"); 
		query.append("     , INQS.HUB_LOC_CD      AS HUB_LOC_CD" ).append("\n"); 
		query.append("     , INQS.POD_ARR_DT      AS POD_ARR_DT" ).append("\n"); 
		query.append("     , INQS.DEL_ARR_DT      AS DEL_ARR_DT " ).append("\n"); 
		query.append("     , INQS.PKUP_AVAL_DT    AS PKUP_AVAL_DT" ).append("\n"); 
		query.append("     , INQS.PKUP_FREE_DT    AS PKUP_FREE_DT" ).append("\n"); 
		query.append("     , YD1.YD_CSTMS_NO      AS POD_FIRMS" ).append("\n"); 
		query.append("     , INQS.PKUP_YD_CD      AS PKUP_YD_CD" ).append("\n"); 
		query.append("     , YD2.YD_CSTMS_NO      AS PKUP_FIRMS" ).append("\n"); 
		query.append("     , INQS.RTN_YD_CD       AS RTN_YD_CD" ).append("\n"); 
		query.append("     , NVL(INQS.AN_FOM_CD,'GE')         AS AN_FOM_CD" ).append("\n"); 
		query.append("     , NVL(INQS.DIFF_RMK, DRMK.AN_RMK ) AS DIFF_RMK   " ).append("\n"); 
		query.append("     , NVL(INQS.CHN_AGN_CD,'*')         AS CHN_AGN_CD" ).append("\n"); 
		query.append("     , INQS.NTC_RVIS_FLG    AS NTC_RVIS_FLG" ).append("\n"); 
		query.append("     , INQS.IS_VALIDATED    AS IS_VALIDATED" ).append("\n"); 
		query.append("     , INQS.VVD             AS VVD" ).append("\n"); 
		query.append("     , INQS.CNTR_TYPE       AS CNTR_TYPE" ).append("\n"); 
		query.append("     , '' AS SEQ" ).append("\n"); 
		query.append("     , INQS.POD_CD          AS POD_CD" ).append("\n"); 
		query.append("     , ( " ).append("\n"); 
		query.append("         SELECT DECODE( SUBSTR(INQS.DEL_CD,1,2),'CA',SUBSTR(GL.GDS_DESC,1,20),'N/A')" ).append("\n"); 
		query.append("          FROM BKG_CSTMS_CND_GDS_LOC GL" ).append("\n"); 
		query.append("         WHERE GL.POD_CD = INQS.POD_CD" ).append("\n"); 
		query.append("         AND   GL.DEL_CD = INQS.DEL_CD" ).append("\n"); 
		query.append("		 AND   NVL(GL.POD_YD_NO, 'NL' ) IN ('NL',SUBSTR( INQS.POD_YD_CD , 6) )" ).append("\n"); 
		query.append("         AND   ROWNUM =1" ).append("\n"); 
		query.append("       ) AS LOC_GOOD" ).append("\n"); 
		query.append("         " ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("          SELECT BKGM.BKG_NO  -- COMM -- KEY" ).append("\n"); 
		query.append("			   , ANTC.VSL_FLG" ).append("\n"); 
		query.append("			   ,(  SELECT MC1.CNT_NM " ).append("\n"); 
		query.append("                     FROM MDM_VSL_CNTR MVC , MDM_COUNTRY  MC1" ).append("\n"); 
		query.append("                    WHERE MVC.VSL_CD = BKGM.VSL_CD" ).append("\n"); 
		query.append("                      AND MVC.VSL_RGST_CNT_CD = MC1.CNT_CD(+)" ).append("\n"); 
		query.append("                ) AS VSL_FLG_CNT_NM" ).append("\n"); 
		query.append("               , BKGM.VSL_CD  -- COMM ---- VVD" ).append("\n"); 
		query.append("               , BKGM.SKD_VOY_NO -- COMM ---- VVD" ).append("\n"); 
		query.append("               , BKGM.SKD_DIR_CD -- COMM ---- VVD" ).append("\n"); 
		query.append("               , DECODE( ANTC.VSL_INFO_SET_FLG  --- VSL_INFO_SET_FLG에 영향받는 7항목(처리)" ).append("\n"); 
		query.append("                         , 'Y', ANTC.VSL_NM" ).append("\n"); 
		query.append("                         ,(SELECT VSL.VSL_ENG_NM FROM MDM_VSL_CNTR VSL WHERE VSL.VSL_CD = BKGM.VSL_CD AND ROWNUM = 1) ) AS VSL_NM" ).append("\n"); 
		query.append("               , BKGM.BL_NO    " ).append("\n"); 
		query.append("               , BKGM.DE_TERM_CD" ).append("\n"); 
		query.append("               , BKGM.DEL_CD " ).append("\n"); 
		query.append("               , CSTM.HUB_LOC_CD" ).append("\n"); 
		query.append("               , DECODE( ANTC.VSL_INFO_SET_FLG  --- VSL_INFO_SET_FLG에 영향받는 7항목(처리)" ).append("\n"); 
		query.append("                         , 'Y', ANTC.POD_ARR_DT" ).append("\n"); 
		query.append("                         , BKGM.VPS_ETA_DT ) POD_ARR_DT  -- equals VPS_ETA_DT" ).append("\n"); 
		query.append("               , DECODE( ANTC.VSL_INFO_SET_FLG  --- VSL_INFO_SET_FLG에 영향받는 7항목(처리)" ).append("\n"); 
		query.append("                         , 'Y', ANTC.DEL_ARR_DT" ).append("\n"); 
		query.append("                         , NVL(TO_DATE(DECODE(SUBSTR(BKGM.COP_VAL, 1,14), '00000000000000', NULL, SUBSTR(BKGM.COP_VAL, 1,14)), 'YYYYMMDDHH24MISS'), BKGM.VPS_ETA_DT + BKGM.ADD_DT)" ).append("\n"); 
		query.append("                       ) AS DEL_ARR_DT          ---- 16.DEL_ETA" ).append("\n"); 
		query.append("               , DECODE( ANTC.VSL_INFO_SET_FLG  --- VSL_INFO_SET_FLG에 영향받는 7항목(처리)" ).append("\n"); 
		query.append("                         , 'Y', ANTC.PKUP_AVAL_DT" ).append("\n"); 
		query.append("                         , NVL(TO_DATE(DECODE(SUBSTR(BKGM.COP_VAL, 1,14), '00000000000000', NULL, SUBSTR(BKGM.COP_VAL, 1,14)), 'YYYYMMDDHH24MISS') + 0.25, BKGM.VPS_ETA_DT + BKGM.ADD_DT)" ).append("\n"); 
		query.append("                       ) AS PKUP_AVAL_DT        ---- 17.AVAIL DT" ).append("\n"); 
		query.append("                 /* POD가 BEANR or NTRTM 일경우 */" ).append("\n"); 
		query.append("               , DECODE( ANTC.VSL_INFO_SET_FLG  --- VSL_INFO_SET_FLG에 영향받는 7항목(처리)" ).append("\n"); 
		query.append("                         , 'Y', ANTC.PKUP_FREE_DT" ).append("\n"); 
		query.append("                         ,NVL(DECODE( BKGM.POD_CD" ).append("\n"); 
		query.append("                                     ,'BEANR',AVVD.DEM_FREE_DT" ).append("\n"); 
		query.append("                                     ,'NLRTM',RVVD.DEM_FREE_DT" ).append("\n"); 
		query.append("                                     ,BKG_FREE_TIME_END_DT_FNC(BKGM.BKG_NO)" ).append("\n"); 
		query.append("                                    )" ).append("\n"); 
		query.append("                              , NVL(TO_DATE(DECODE(SUBSTR(BKGM.COP_VAL, 1,14), '00000000000000', NULL, SUBSTR(BKGM.COP_VAL, 1,14)), 'YYYYMMDDHH24MISS') + 1.25 , BKGM.VPS_ETA_DT + BKGM.ADD_DT)" ).append("\n"); 
		query.append("                             )" ).append("\n"); 
		query.append("                        ) AS  PKUP_FREE_DT" ).append("\n"); 
		query.append("               , DECODE( ANTC.VSL_INFO_SET_FLG  --- VSL_INFO_SET_FLG에 영향받는 7항목(처리)" ).append("\n"); 
		query.append("                         , 'Y', ANTC.PKUP_YD_CD" ).append("\n"); 
		query.append("                         , NVL(DECODE( BKGM.POD_CD" ).append("\n"); 
		query.append("                                       ,'BEANR',AHDG.ATTR_CTNT3" ).append("\n"); 
		query.append("                                       ,'NLRTM',RCNV.ATTR_CTNT2" ).append("\n"); 
		query.append("                                       , NULL" ).append("\n"); 
		query.append("                                      )" ).append("\n"); 
		query.append("                              , NVL(SUBSTR(BKGM.COP_VAL, 15), VSK_ETA_YD_CD)" ).append("\n"); 
		query.append("                               )" ).append("\n"); 
		query.append("                        ) AS PKUP_YD_CD" ).append("\n"); 
		query.append("               , DECODE( ANTC.VSL_INFO_SET_FLG  --- VSL_INFO_SET_FLG에 영향받는 7항목(처리)" ).append("\n"); 
		query.append("                         , 'Y', ANTC.RTN_YD_CD" ).append("\n"); 
		query.append("                         , (SELECT RTYD.MCNTR_RTN_YD_CD" ).append("\n"); 
		query.append("                              FROM BKG_PKUP_CNTR_RTN_YD RTYD" ).append("\n"); 
		query.append("                             WHERE RTYD.POD_CD = BKGM.POD_CD " ).append("\n"); 
		query.append("                               AND RTYD.RAIL_DEST_CD = BKGM.DEL_CD " ).append("\n"); 
		query.append("                               AND RTYD.FNL_DEST_CD = CSTM.HUB_LOC_CD" ).append("\n"); 
		query.append("                               AND RTYD.RTN_YD_SAV_OFC_CD = LOC.EQ_CTRL_OFC_CD" ).append("\n"); 
		query.append("                               AND RTYD.DELT_FLG = 'N')" ).append("\n"); 
		query.append("                       )  AS RTN_YD_CD" ).append("\n"); 
		query.append("               , ANTC.AN_FOM_CD" ).append("\n"); 
		query.append("               , ANTC.DIFF_RMK" ).append("\n"); 
		query.append("               , NVL(BKGM.CHN_CSTMS_AGN_CD ,ANTC.CHN_AGN_CD) CHN_AGN_CD " ).append("\n"); 
		query.append("               , ANTC.NTC_RVIS_FLG" ).append("\n"); 
		query.append("               , BKGM.IS_VALIDATED" ).append("\n"); 
		query.append("               , BKGM.VSL_CD || BKGM.SKD_VOY_NO || BKGM.SKD_DIR_CD AS VVD" ).append("\n"); 
		query.append("               , CASE WHEN DECODE(RC_FLG,'Y',1,0)     +DECODE(DCGO_FLG,'Y',1,0)+" ).append("\n"); 
		query.append("                           DECODE(AWK_CGO_FLG,'Y',1,0)+DECODE(SOC_FLG,'Y',1,0) +DECODE(BB_CGO_FLG,'Y',1,0) > 1 THEN 'MX'" ).append("\n"); 
		query.append("                      WHEN DECODE(RC_FLG,'Y',1,0)     +DECODE(DCGO_FLG,'Y',1,0)+" ).append("\n"); 
		query.append("                           DECODE(AWK_CGO_FLG,'Y',1,0)+DECODE(SOC_FLG,'Y',1,0) +DECODE(BB_CGO_FLG,'Y',1,0) < 1 THEN 'DR'" ).append("\n"); 
		query.append("                      WHEN RC_FLG      = 'Y' THEN 'RF'" ).append("\n"); 
		query.append("                      WHEN DCGO_FLG    = 'Y' THEN 'DG'" ).append("\n"); 
		query.append("                      WHEN AWK_CGO_FLG = 'Y' THEN 'AK'" ).append("\n"); 
		query.append("                      WHEN SOC_FLG     = 'Y' THEN 'SO'" ).append("\n"); 
		query.append("                      WHEN BB_CGO_FLG  = 'Y' THEN 'BB'END AS CNTR_TYPE" ).append("\n"); 
		query.append("               , BKGM.POD_CD" ).append("\n"); 
		query.append("               , BKGM.POD_YD_CD" ).append("\n"); 
		query.append("               , BKGM.POD_NOD_CD" ).append("\n"); 
		query.append("               , 1 AS TMPS" ).append("\n"); 
		query.append("           FROM (" ).append("\n"); 
		query.append("                   SELECT BKGM.BKG_NO                      AS BKG_NO" ).append("\n"); 
		query.append("                        , BKGM.SAM_CNEE_NTFY_FLG           AS SAM_CNEE_NTFY_FLG" ).append("\n"); 
		query.append("                        , BKGM.CUST_TO_ORD_FLG             AS CUST_TO_ORD_FLG" ).append("\n"); 
		query.append("                        , DECODE( @[ts_flg],'Y', BKGM.PST_RLY_PORT_CD, BKGM.POD_CD)  AS POD_CD" ).append("\n"); 
		query.append("						, BVVD.POD_YD_CD                   AS POD_YD_CD" ).append("\n"); 
		query.append("                        , BKGM.POD_NOD_CD                  AS POD_NOD_CD" ).append("\n"); 
		query.append("                        , BKGM.DEL_CD                      AS DEL_CD" ).append("\n"); 
		query.append("                        , BVVD.VSL_CD                      AS VSL_CD" ).append("\n"); 
		query.append("                        , BVVD.SKD_VOY_NO                  AS SKD_VOY_NO" ).append("\n"); 
		query.append("                        , BVVD.SKD_DIR_CD                  AS SKD_DIR_CD" ).append("\n"); 
		query.append("                        , BKGM.BL_NO                       AS BL_NO" ).append("\n"); 
		query.append("                        , BKGM.DE_TERM_CD                  AS DE_TERM_CD" ).append("\n"); 
		query.append("                        , VSKD.VPS_ETA_DT                  AS VPS_ETA_DT" ).append("\n"); 
		query.append("                        , VSKD.YD_CD                       AS VSK_ETA_YD_CD" ).append("\n"); 
		query.append("                        , CASE WHEN CCST.AN_SND_FLG = 'Y' OR NCST.AN_SND_FLG = 'Y' THEN 'Y' " ).append("\n"); 
		query.append("                            ELSE 'N' END                   AS IS_VALIDATED" ).append("\n"); 
		query.append("                       , BKGM.BB_CGO_FLG                   AS BB_CGO_FLG" ).append("\n"); 
		query.append("                       , BKGM.SOC_FLG                      AS SOC_FLG" ).append("\n"); 
		query.append("                       , BKGM.AWK_CGO_FLG                  AS AWK_CGO_FLG" ).append("\n"); 
		query.append("                       , BKGM.DCGO_FLG                     AS DCGO_FLG" ).append("\n"); 
		query.append("                       , BKGM.RC_FLG                       AS RC_FLG" ).append("\n"); 
		query.append("                       , DECODE (SUBSTR(BKGM.POD_CD,1,2)" ).append("\n"); 
		query.append("                                 , 'US', 2 " ).append("\n"); 
		query.append("                                 , DECODE(BKGM.POD_CD, BKGM.DEL_CD, 1, 2)" ).append("\n"); 
		query.append("                                ) AS ADD_DT" ).append("\n"); 
		query.append("                       , (SELECT  SUBSTR(" ).append("\n"); 
		query.append("                                  MAX ( DECODE(COPD.ACT_CD, 'FITRDO', '1', '0') || NVL(TO_CHAR(COPD.PLN_DT, 'YYYYMMDDHH24MISS'), '00000000000000')" ).append("\n"); 
		query.append("                                        || NVL(TO_CHAR(NVL(COPD.ACT_DT, COPD.ESTM_DT), 'YYYYMMDDHH24MISS'), '00000000000000')" ).append("\n"); 
		query.append("                                        || COPD.NOD_CD " ).append("\n"); 
		query.append("                                      ) , 16) COP_VAL" ).append("\n"); 
		query.append("                             FROM SCE_COP_HDR COPM" ).append("\n"); 
		query.append("                                , SCE_COP_DTL COPD" ).append("\n"); 
		query.append("                            WHERE SUBSTR(BKGM.DEL_CD, 1,2) = 'US'" ).append("\n"); 
		query.append("                              AND COPM.BKG_NO = BKGM.BKG_NO " ).append("\n"); 
		query.append("                              AND COPD.COP_NO = COPM.COP_NO" ).append("\n"); 
		query.append("                              AND COPM.COP_STS_CD <> 'X'" ).append("\n"); 
		query.append("                              AND COPD.ACT_CD IN ('FITRDO', 'FUVMAD')  -- FITRDO우선 처리" ).append("\n"); 
		query.append("                         ) AS COP_VAL" ).append("\n"); 
		query.append("						, AGNT.CHN_CSTMS_AGN_CD CHN_CSTMS_AGN_CD" ).append("\n"); 
		query.append("               --        ,  DECODE(SUBSTR(BKGM.DEL_CD, 1,2), 'US', BKG_IB_AN_COP_FNC(BKGM.BKG_NO), NULL) AS COP_VAL" ).append("\n"); 
		query.append("						, VSLCNTR.VSL_RGST_CNT_CD AS VSL_RGST_CNT_CD" ).append("\n"); 
		query.append("                    FROM VSK_VSL_PORT_SKD VSKD" ).append("\n"); 
		query.append("                       , BKG_VVD BVVD" ).append("\n"); 
		query.append("                       , BKG_CUSTOMER CCST" ).append("\n"); 
		query.append("                       , BKG_CUSTOMER NCST " ).append("\n"); 
		query.append("                       , BKG_BOOKING BKGM" ).append("\n"); 
		query.append("					   , BKG_CSTMS_CHN_AGN_STUP AGNT" ).append("\n"); 
		query.append("					   , MDM_VSL_CNTR VSLCNTR" ).append("\n"); 
		query.append("                   WHERE 1 = 1" ).append("\n"); 
		query.append("#if (${sch_tp} == 'V') " ).append("\n"); 
		query.append("                     AND BVVD.VSL_CD     = SUBSTR(@[vvd], 1,4) " ).append("\n"); 
		query.append("                     AND BVVD.SKD_VOY_NO = SUBSTR(@[vvd], 5,4)" ).append("\n"); 
		query.append("                     AND BVVD.SKD_DIR_CD = SUBSTR(@[vvd], 9,1)" ).append("\n"); 
		query.append("                     AND BVVD.POD_CD     = @[pod_cd]" ).append("\n"); 
		query.append("#elseif (${sch_tp} == 'D') " ).append("\n"); 
		query.append("                     AND VSKD.VPS_ETA_DT " ).append("\n"); 
		query.append("                         BETWEEN TO_DATE(@[vps_eta_dt_start], 'YYYY-MM-DD') " ).append("\n"); 
		query.append("                             AND TO_DATE(@[vps_eta_dt_end], 'YYYY-MM-DD') +0.99999  -- DURATION (OPTIONAL 2)" ).append("\n"); 
		query.append("                     AND VSKD.VPS_PORT_CD = @[pod_cd] --------- ts_flg != Y" ).append("\n"); 
		query.append("#elseif (${sch_tp} == 'B') " ).append("\n"); 
		query.append("                     AND BKGM.BL_NO = @[bl_no]  -- BL NO (OPTIONAL 5-1)" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("                     AND 1 = 0" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${sch_tp} == 'D') " ).append("\n"); 
		query.append("                     AND BVVD.VSL_CD = VSKD.VSL_CD   -- Join의 방향성 때문에 Duration인 경우와 아닌 경우를 분리함" ).append("\n"); 
		query.append("                     AND BVVD.SKD_VOY_NO = VSKD.SKD_VOY_NO" ).append("\n"); 
		query.append("                     AND BVVD.SKD_DIR_CD = VSKD.SKD_DIR_CD" ).append("\n"); 
		query.append("                     AND BVVD.POD_CD = VSKD.VPS_PORT_CD" ).append("\n"); 
		query.append("                     AND BVVD.POD_CLPT_IND_SEQ = VSKD.CLPT_IND_SEQ" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("                     AND BVVD.VSL_CD = VSKD.VSL_CD(+)  -- Duration이 아닌경우에는 데이터를 추출하기 위하여 해당과 같이 처리한다. (20100106 Park Mangeon)" ).append("\n"); 
		query.append("                     AND BVVD.SKD_VOY_NO = VSKD.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("                     AND BVVD.SKD_DIR_CD = VSKD.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("                     AND BVVD.POD_CD = VSKD.VPS_PORT_CD(+)" ).append("\n"); 
		query.append("                     AND BVVD.POD_CLPT_IND_SEQ = VSKD.CLPT_IND_SEQ(+)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                     AND BKGM.BKG_NO =BVVD.BKG_NO" ).append("\n"); 
		query.append("#if ( ${ts_flg} != 'Y')     " ).append("\n"); 
		query.append("                     AND BKGM.POD_CD = BVVD.POD_CD" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("                     AND BKGM.PST_RLY_PORT_CD = BVVD.POD_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                     AND BKGM.BKG_STS_CD NOT IN ('X', 'S')" ).append("\n"); 
		query.append("                     AND BKGM.BL_NO IS NOT NULL  -- AS IS와 동일하게 하기위해 추가 20091124" ).append("\n"); 
		query.append("                     AND BKGM.BKG_CGO_TP_CD IN ('F', 'R')" ).append("\n"); 
		query.append("                     AND CCST.BKG_NO = BKGM.BKG_NO" ).append("\n"); 
		query.append("                     AND CCST.BKG_CUST_TP_CD = 'C'" ).append("\n"); 
		query.append("                     AND NCST.BKG_NO = BKGM.BKG_NO" ).append("\n"); 
		query.append("                     AND NCST.BKG_CUST_TP_CD = 'N'" ).append("\n"); 
		query.append("					 AND BKGM.POD_CD = AGNT.POD_CD(+)" ).append("\n"); 
		query.append("					 AND BKGM.SLAN_CD = AGNT.SLAN_CD(+)" ).append("\n"); 
		query.append("                     AND (" ).append("\n"); 
		query.append("                            DECODE(CCST.VAL_CD, 'S', 0, 1) " ).append("\n"); 
		query.append("                          + DECODE(NCST.VAL_CD, 'S', 0, 1)" ).append("\n"); 
		query.append("                          ) > 0   --- NVL(VAL_CD, '*') <> 'S' 의 처리 -- Consignee, Notify둘다 Skip이면 출력안함, 아닌경우 출력함 20100108 Park Mangeon" ).append("\n"); 
		query.append("#if (${sch_tp} != 'B' && ${del_cd} != '') " ).append("\n"); 
		query.append("                     AND BKGM.DEL_CD LIKE @[del_cd] || '%'  -- DELIVERY PORT CD (OPTIONAL 4)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${sch_tp} != 'B' && ${pol_cd} != '') " ).append("\n"); 
		query.append("                     AND BKGM.POL_CD = @[pol_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${s_no} != '' && ${c_no} != '') " ).append("\n"); 
		query.append("                     AND BKGM.SC_NO = @[s_no] || @[c_no] -- SC NO (OPTINALE 9)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cust_nm} != '') " ).append("\n"); 
		query.append("                     AND (UPPER(CCST.CUST_NM) like '%' || UPPER(@[cust_nm]) || '%'   -- name" ).append("\n"); 
		query.append("                          OR UPPER(NCST.CUST_NM) like '%' || UPPER(@[cust_nm]) || '%'   -- name" ).append("\n"); 
		query.append("                         )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cust_cnt_cd} != '') " ).append("\n"); 
		query.append("                     AND (   CCST.CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("                          OR NCST.CUST_CNT_CD = @[cust_cnt_cd] )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cust_seq} != '')" ).append("\n"); 
		query.append("                     AND (   CCST.CUST_SEQ = TO_NUMBER(@[cust_seq])" ).append("\n"); 
		query.append("                          OR NCST.CUST_SEQ = TO_NUMBER(@[cust_seq]) )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cust_ref_no} != '') " ).append("\n"); 
		query.append("                     AND (BKGM.BKG_NO) IN (SELECT BR.BKG_NO" ).append("\n"); 
		query.append("                                             FROM BKG_REFERENCE BR" ).append("\n"); 
		query.append("                                            WHERE BR.BKG_REF_TP_CD = 'BKPO'" ).append("\n"); 
		query.append("                                              AND BR.BKG_NO = BKGM.BKG_NO" ).append("\n"); 
		query.append("                                              AND BR.CUST_REF_NO_CTNT  = @[cust_ref_no]  -- 고객이 요청하는 번호 (0ptional 8)" ).append("\n"); 
		query.append("                                          ) -- BKG REFERENCE NUMBER -- (OPTIONAL END )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${is_validated} != '') " ).append("\n"); 
		query.append("                     AND CASE WHEN CCST.AN_SND_FLG = 'Y' OR NCST.AN_SND_FLG = 'Y' THEN 'Y' " ).append("\n"); 
		query.append("                            ELSE 'N' END = @[is_validated]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("					 AND VSLCNTR.VSL_CD(+)        = BKGM.VSL_CD" ).append("\n"); 
		query.append("                ) BKGM" ).append("\n"); 
		query.append("                LEFT OUTER JOIN BKG_ARR_NTC ANTC" ).append("\n"); 
		query.append("                  ON  (ANTC.BKG_NO = BKGM.BKG_NO)" ).append("\n"); 
		query.append("                LEFT OUTER JOIN BKG_CSTMS_ADV_BL CSTM" ).append("\n"); 
		query.append("                  ON ( CSTM.CNT_CD = 'US'" ).append("\n"); 
		query.append("                       AND CSTM.BL_NO  = BKGM.BL_NO )" ).append("\n"); 
		query.append("                LEFT OUTER JOIN MDM_LOCATION LOC" ).append("\n"); 
		query.append("                  ON ( LOC.LOC_CD  = BKGM.DEL_CD)" ).append("\n"); 
		query.append("                LEFT OUTER JOIN BKG_CSTMS_ANR_VVD  AVVD  -- ANRBS" ).append("\n"); 
		query.append("                  ON ( AVVD.VSL_CD  = BKGM.VSL_CD" ).append("\n"); 
		query.append("                       AND AVVD.SKD_VOY_NO = BKGM.SKD_VOY_NO" ).append("\n"); 
		query.append("                       AND AVVD.SKD_DIR_CD = BKGM.SKD_DIR_CD )" ).append("\n"); 
		query.append("                LEFT OUTER JOIN BKG_HRD_CDG_CTNT AHDG     -- ANRBS SUB CODE" ).append("\n"); 
		query.append("                  ON ( AHDG.HRD_CDG_ID = 'ANR_CSTMS_BRTH_CD'" ).append("\n"); 
		query.append("                       AND AHDG.ATTR_CTNT2 = AVVD.BRTH_DESC  )" ).append("\n"); 
		query.append("                LEFT OUTER JOIN BKG_CSTMS_RTM_VSL  RVVD  -- NLRTM   " ).append("\n"); 
		query.append("                  ON ( RVVD.VSL_CD      = BKGM.VSL_CD" ).append("\n"); 
		query.append("                       AND RVVD.SKD_VOY_NO  = BKGM.SKD_VOY_NO" ).append("\n"); 
		query.append("                       AND RVVD.SKD_DIR_CD  = BKGM.SKD_DIR_CD" ).append("\n"); 
		query.append("                       AND RVVD.VSL_CALL_REF_STS_CD <> 'C' )" ).append("\n"); 
		query.append("                LEFT OUTER JOIN BKG_CSTMS_CD_CONV_CTNT RCNV  -- NLRTM SUB " ).append("\n"); 
		query.append("                  ON ( RCNV.CNT_CD = 'NL'" ).append("\n"); 
		query.append("                       AND RCNV.CSTMS_DIV_ID = 'BERTH_CD'" ).append("\n"); 
		query.append("                       AND RCNV.ATTR_CTNT1 = RVVD.BRTH_CTNT) " ).append("\n"); 
		query.append("       ) INQS" ).append("\n"); 
		query.append("     , MDM_YARD YD1  -- POD FIRMS" ).append("\n"); 
		query.append("     , MDM_YARD YD2  -- P/Up FIRMS " ).append("\n"); 
		query.append("     , (SELECT 1 AS TMPS" ).append("\n"); 
		query.append("             , MAX(AN_RMK) AS AN_RMK" ).append("\n"); 
		query.append("             , COUNT(1) AS RMK_CNT" ).append("\n"); 
		query.append("          FROM BKG_USR_DFLT_SET " ).append("\n"); 
		query.append("         WHERE USR_ID = @[usr_id]" ).append("\n"); 
		query.append("       ) DRMK" ).append("\n"); 
		query.append(" WHERE 1 = 1" ).append("\n"); 
		query.append("   AND YD1.YD_CD(+) = INQS.POD_NOD_CD" ).append("\n"); 
		query.append("   AND YD2.YD_CD(+) = INQS.PKUP_YD_CD" ).append("\n"); 
		query.append(" ORDER BY INQS.VVD" ).append("\n"); 
		query.append("        , INQS.BKG_NO" ).append("\n"); 

	}
}