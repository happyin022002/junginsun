/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : CarrierSettlementProcessDBDAOCreOusTdrRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.19
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.19 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CarrierSettlementProcessDBDAOCreOusTdrRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * OUS TDR Revenue Create용
	  * </pre>
	  */
	public CarrierSettlementProcessDBDAOCreOusTdrRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acct_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_crr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_stl_itm_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("re_divr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_mnu_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration").append("\n"); 
		query.append("FileName : CarrierSettlementProcessDBDAOCreOusTdrRSQL").append("\n"); 
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
		query.append("WITH JO_CRR AS (" ).append("\n"); 
		query.append("  SELECT B.JO_CRR_CD, A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD" ).append("\n"); 
		query.append("  FROM   JOO_STL_VVD A," ).append("\n"); 
		query.append("         (" ).append("\n"); 
		query.append("  		   SELECT DECODE(@[re_divr_cd], 'E', 'SML', @[jo_crr_cd]) AS JO_CRR_CD, TO_DATE('99991231','YYYYMMDD') AS EFF_ETA_DT" ).append("\n"); 
		query.append("  		   FROM   DUAL" ).append("\n"); 
		query.append("  		   UNION  ALL" ).append("\n"); 
		query.append("  		   SELECT JO_N2ND_CRR_CD AS JO_CRR_CD, EFF_ETA_DT" ).append("\n"); 
		query.append("  		   FROM   JOO_CRR_MRG A" ).append("\n"); 
		query.append("  		   WHERE  A.DELT_FLG       = 'N'" ).append("\n"); 
		query.append("  		   AND    A.ACCTG_CRR_CD   = @[jo_crr_cd]" ).append("\n"); 
		query.append("  		   AND    A.JO_N1ST_CRR_CD = DECODE(@[re_divr_cd], 'E', 'SML', @[jo_crr_cd])" ).append("\n"); 
		query.append("  		   AND    A.TRD_CD         = @[trd_cd]" ).append("\n"); 
		query.append("  		   AND    A.RLANE_CD       = @[rlane_cd]" ).append("\n"); 
		query.append("         ) B" ).append("\n"); 
		query.append("  WHERE  A.BZC_PORT_ETA_DT <= B.EFF_ETA_DT" ).append("\n"); 
		query.append("  AND    A.ACCT_YRMON    = REPLACE(@[acct_yrmon],'-','')" ).append("\n"); 
		query.append("  AND    A.JO_CRR_CD     = @[jo_crr_cd]" ).append("\n"); 
		query.append("  AND    A.TRD_CD        = @[trd_cd]" ).append("\n"); 
		query.append("  AND    A.RLANE_CD      = @[rlane_cd]" ).append("\n"); 
		query.append("  AND    A.RE_DIVR_CD    = @[re_divr_cd]" ).append("\n"); 
		query.append("  AND    A.JO_STL_ITM_CD = @[jo_stl_itm_cd]" ).append("\n"); 
		query.append("  AND    A.JO_MNU_NM    IN ('RDR','TDR')" ).append("\n"); 
		query.append("  AND    A.JO_STL_CFM_CD = 'Y'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("        'I' AS IBFLAG" ).append("\n"); 
		query.append("        , ACCT_YRMON" ).append("\n"); 
		query.append("        , STL_VVD_SEQ" ).append("\n"); 
		query.append("        , 0 AS STL_SEQ" ).append("\n"); 
		query.append("        , TRD_CD" ).append("\n"); 
		query.append("        , JO_CRR_CD" ).append("\n"); 
		query.append("        , RLANE_CD" ).append("\n"); 
		query.append("        , RE_DIVR_CD" ).append("\n"); 
		query.append("        , JO_STL_ITM_CD" ).append("\n"); 
		query.append("        , JO_MNU_NM" ).append("\n"); 
		query.append("        , VSL_CD" ).append("\n"); 
		query.append("        , SKD_VOY_NO" ).append("\n"); 
		query.append("        , SKD_DIR_CD" ).append("\n"); 
		query.append("        , REV_DIR_CD" ).append("\n"); 
		query.append("        , STL_BZC_PORT_CD" ).append("\n"); 
		query.append("        , TO_CHAR(BZC_PORT_ETA_DT,'YYYYMMDDHHMISS') AS ETA_DT" ).append("\n"); 
		query.append("        , '' JO_STL_JB_CD" ).append("\n"); 
		query.append("        , 0 AS BSA_QTY" ).append("\n"); 
		query.append("        , BSA_SLT_PRC" ).append("\n"); 
		query.append("        , LOCL_CURR_CD" ).append("\n"); 
		query.append("        , 0 AS ADJ_BSA_QTY_LOCL_AMT" ).append("\n"); 
		query.append("        , 0 AS ADJ_BSA_SLT_PRC_LOCL_AMT" ).append("\n"); 
		query.append("        , 0 AS STL_LOCL_AMT" ).append("\n"); 
		query.append("        , 0 STL_USD_AMT" ).append("\n"); 
		query.append("        , '' AS IOC_CD" ).append("\n"); 
		query.append("        , '' AS SCONTI_CD" ).append("\n"); 
		query.append("        , FNL_HJS_BSA_QTY" ).append("\n"); 
		query.append("        , FNL_BSA_WGT" ).append("\n"); 
		query.append("        , USD_SLT_BSA_QTY" ).append("\n"); 
		query.append("        , USD_SLT_WGT" ).append("\n"); 
		query.append("        , BSA_PER_WGT" ).append("\n"); 
		query.append("        , FM_PORT_CD" ).append("\n"); 
		query.append("        , TO_PORT_CD" ).append("\n"); 
		query.append("        , NULL AS RF_SCG_STL_TP_CD" ).append("\n"); 
		query.append("        , NULL AS RF_SCG_PRC" ).append("\n"); 
		query.append("        , NULL AS STL_RMK" ).append("\n"); 
		query.append("        , NULL AS CMB_CFM_FLG" ).append("\n"); 
		query.append("        , NULL AS STL_CMB_SEQ" ).append("\n"); 
		query.append("        , NULL AS STL_TJ_NO" ).append("\n"); 
		query.append("        , 'N'  AS STL_ADJ_FLG" ).append("\n"); 
		query.append("        , NULL AS PRE_ACCT_YRMON" ).append("\n"); 
		query.append("        , NULL AS PRE_STL_VVD_SEQ" ).append("\n"); 
		query.append("        , NULL AS PRE_STL_SEQ" ).append("\n"); 
		query.append("        , 'Y'  AS STL_LST_FLG" ).append("\n"); 
		query.append("        , UC_BSS_PORT_CD" ).append("\n"); 
		query.append("        , TO_CHAR(UC_BSS_PORT_ETD_DT,'YYYYMMDDHH24MISS') AS UC_BSS_PORT_ETD_DT" ).append("\n"); 
		query.append("        , NULL AS SLIP_NO" ).append("\n"); 
		query.append("        , CLPT_IND_SEQ" ).append("\n"); 
		query.append("        , 'N' AS RVS_CMB_FLG" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT T.ACCT_YRMON" ).append("\n"); 
		query.append("             , T.JO_CRR_CD" ).append("\n"); 
		query.append("             , T.RE_DIVR_CD" ).append("\n"); 
		query.append("             , T.TRD_CD" ).append("\n"); 
		query.append("             , T.RLANE_CD" ).append("\n"); 
		query.append("             , T.VSL_CD" ).append("\n"); 
		query.append("             , T.SKD_VOY_NO" ).append("\n"); 
		query.append("             , T.SKD_DIR_CD" ).append("\n"); 
		query.append("             , T.REV_DIR_CD" ).append("\n"); 
		query.append("             , T.STL_BZC_PORT_CD" ).append("\n"); 
		query.append("             , T.BZC_PORT_ETA_DT" ).append("\n"); 
		query.append("             , T.UC_BSS_PORT_CD" ).append("\n"); 
		query.append("             , T.UC_BSS_PORT_ETD_DT" ).append("\n"); 
		query.append("             , T.FM_PORT_CD" ).append("\n"); 
		query.append("             , T.TO_PORT_CD" ).append("\n"); 
		query.append("             , T.FNL_HJS_BSA_QTY" ).append("\n"); 
		query.append("             , T.FNL_BSA_WGT             " ).append("\n"); 
		query.append("             , T.USD_SLT_BSA_QTY" ).append("\n"); 
		query.append("             , T.USD_SLT_WGT" ).append("\n"); 
		query.append("             , T.BSA_PER_WGT" ).append("\n"); 
		query.append("             , T.BSA_SLT_PRC" ).append("\n"); 
		query.append("             , T.JO_STL_ITM_CD" ).append("\n"); 
		query.append("             , T.JO_MNU_NM" ).append("\n"); 
		query.append("             , T.STL_VVD_SEQ" ).append("\n"); 
		query.append("             , E.LOCL_CURR_CD" ).append("\n"); 
		query.append("             , T.CLPT_IND_SEQ" ).append("\n"); 
		query.append("          FROM (" ).append("\n"); 
		query.append("               SELECT A.ACCT_YRMON, A.STL_VVD_SEQ, A.TRD_CD, A.JO_CRR_CD, A.RLANE_CD, A.RE_DIVR_CD, A.JO_STL_ITM_CD, A.JO_MNU_NM" ).append("\n"); 
		query.append("                    , A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD, A.REV_DIR_CD, A.STL_BZC_PORT_CD, A.BZC_PORT_ETA_DT, A.UC_BSS_PORT_CD, A.UC_BSS_PORT_ETD_DT" ).append("\n"); 
		query.append("                    , A.PORT1 AS FM_PORT_CD, A.PORT2 AS TO_PORT_CD, A.CLPT_IND_SEQ" ).append("\n"); 
		query.append("                    , NVL(A.BSA_PER_WGT,0) AS BSA_PER_WGT, NVL(P.BSA_SLT_PRC,0) BSA_SLT_PRC" ).append("\n"); 
		query.append("                    , NVL(F.FNL_HJS_BSA_QTY,0) AS FNL_HJS_BSA_QTY, NVL(F.FNL_BSA_WGT,0) FNL_BSA_WGT" ).append("\n"); 
		query.append("                    , NVL(O.USD_SLT_BSA_QTY,0) AS USD_SLT_BSA_QTY, NVL(O.USD_SLT_WGT,0) AS USD_SLT_WGT" ).append("\n"); 
		query.append("                 FROM (" ).append("\n"); 
		query.append("                      SELECT J.ACCT_YRMON, J.STL_VVD_SEQ, J.TRD_CD, J.JO_CRR_CD, J.RLANE_CD, J.RE_DIVR_CD, J.JO_STL_ITM_CD, 'TDR' AS JO_MNU_NM" ).append("\n"); 
		query.append("                           , J.VSL_CD, J.SKD_VOY_NO, J.SKD_DIR_CD, J.REV_DIR_CD, J.STL_BZC_PORT_CD, J.BZC_PORT_ETD_DT BZC_PORT_ETA_DT, J.UC_BSS_PORT_CD, J.UC_BSS_PORT_ETD_DT" ).append("\n"); 
		query.append("                           , K.PORT1, K.PORT2,  K.CLPT_IND_SEQ" ).append("\n"); 
		query.append("                           , C.BSA_PER_WGT" ).append("\n"); 
		query.append("                        FROM JOO_STL_VVD J" ).append("\n"); 
		query.append("                             /*BSA WEIGHT PER TEU*/" ).append("\n"); 
		query.append("                            ,(" ).append("\n"); 
		query.append("                             -- 2010.01.19 WEIGHT PER TEU는 CARRIER MERGE하지말고 해당 선사것만 가져온다." ).append("\n"); 
		query.append("                             -- 2010.03.25 WEIGHT PER TEU는 EXPENSE여도 자신의 CARRIER것만 가져온다." ).append("\n"); 
		query.append("                             SELECT C.VSL_CD, C.SKD_VOY_NO, C.SKD_DIR_CD, C.RLANE_CD, C.TRD_CD, C.CRR_CD," ).append("\n"); 
		query.append("                                    SUM(C.CRR_BSA_CAPA) AS BSA_PER_WGT" ).append("\n"); 
		query.append("                               FROM BSA_VVD_OTR_CRR C" ).append("\n"); 
		query.append("                              WHERE C.CRR_CD     = @[jo_crr_cd] " ).append("\n"); 
		query.append("                                AND C.TRD_CD     = @[trd_cd]" ).append("\n"); 
		query.append("                                AND C.RLANE_CD   = @[rlane_cd]" ).append("\n"); 
		query.append("                                AND C.BSA_OP_JB_CD = '008'" ).append("\n"); 
		query.append("                              GROUP BY C.VSL_CD, C.SKD_VOY_NO, C.SKD_DIR_CD, C.RLANE_CD, C.TRD_CD, C.CRR_CD" ).append("\n"); 
		query.append("                             ) C" ).append("\n"); 
		query.append("                             /* From port to port */" ).append("\n"); 
		query.append("                           , (" ).append("\n"); 
		query.append("                             SELECT V1.VSL_CD, V1.SKD_VOY_NO, V1.SKD_DIR_CD, V1.VPS_PORT_CD PORT1, V2.VPS_PORT_CD PORT2, V1.CLPT_IND_SEQ" ).append("\n"); 
		query.append("                               FROM (" ).append("\n"); 
		query.append("                                    SELECT V.VSL_CD, V.SKD_VOY_NO, V.SKD_DIR_CD, V.VPS_PORT_CD, V.CLPT_IND_SEQ, V.VPS_ETD_DT, V.TURN_PORT_IND_CD" ).append("\n"); 
		query.append("                                         , LEAD(V.VPS_ETD_DT) OVER (PARTITION BY V.VSL_CD,V.SKD_VOY_NO,V.SKD_DIR_CD ORDER BY V.CLPT_SEQ) NEXT_ETD_DT" ).append("\n"); 
		query.append("                                      FROM VSK_VSL_PORT_SKD V" ).append("\n"); 
		query.append("                                     WHERE (V.VSL_CD, V.SKD_VOY_NO, V.SKD_DIR_CD) " ).append("\n"); 
		query.append("                                        IN (SELECT VSL_CD, SKD_VOY_NO, SKD_DIR_CD" ).append("\n"); 
		query.append("                                              FROM JOO_STL_VVD" ).append("\n"); 
		query.append("                                             WHERE ACCT_YRMON    = REPLACE(@[acct_yrmon],'-','')" ).append("\n"); 
		query.append("                                               AND JO_CRR_CD     = @[jo_crr_cd]" ).append("\n"); 
		query.append("                                               AND TRD_CD        = @[trd_cd]" ).append("\n"); 
		query.append("                                               AND RLANE_CD      = @[rlane_cd]" ).append("\n"); 
		query.append("                                               AND RE_DIVR_CD    = @[re_divr_cd]" ).append("\n"); 
		query.append("                                               AND JO_STL_ITM_CD = @[jo_stl_itm_cd]" ).append("\n"); 
		query.append("                                               AND JO_MNU_NM     IN ('RDR','TDR')" ).append("\n"); 
		query.append("                                               AND JO_STL_CFM_CD = 'Y')" ).append("\n"); 
		query.append("                             " ).append("\n"); 
		query.append("                                    )V1, " ).append("\n"); 
		query.append("                                    VSK_VSL_PORT_SKD V2" ).append("\n"); 
		query.append("                              WHERE V1.VSL_CD      = V2.VSL_CD" ).append("\n"); 
		query.append("                                AND V1.SKD_VOY_NO  = V2.SKD_VOY_NO" ).append("\n"); 
		query.append("                                AND V1.SKD_DIR_CD  = V2.SKD_DIR_CD" ).append("\n"); 
		query.append("                                AND V1.NEXT_ETD_DT = V2.VPS_ETD_DT" ).append("\n"); 
		query.append("                                AND V1.TURN_PORT_IND_CD NOT IN ('D','V','F')" ).append("\n"); 
		query.append("                                --2009.11.26 From Port, To Port 가 같아도 상관없음" ).append("\n"); 
		query.append("                                --AND V1.VPS_PORT_CD <> V2.VPS_PORT_CD" ).append("\n"); 
		query.append("                             )K                           " ).append("\n"); 
		query.append("                       WHERE J.VSL_CD         = C.VSL_CD    (+)" ).append("\n"); 
		query.append("                         AND J.SKD_VOY_NO     = C.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("                         AND J.SKD_DIR_CD     = C.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("                         AND J.RLANE_CD       = C.RLANE_CD  (+)" ).append("\n"); 
		query.append("                         AND J.JO_CRR_CD      = C.CRR_CD    (+)" ).append("\n"); 
		query.append("                         AND J.TRD_CD         = C.TRD_CD    (+)" ).append("\n"); 
		query.append("                         AND J.VSL_CD         = K.VSL_CD    (+)" ).append("\n"); 
		query.append("                         AND J.SKD_VOY_NO     = K.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("                         AND J.SKD_DIR_CD     = K.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("                         AND J.ACCT_YRMON     = REPLACE(@[acct_yrmon],'-','')" ).append("\n"); 
		query.append("                         AND J.JO_CRR_CD      = @[jo_crr_cd]" ).append("\n"); 
		query.append("                         AND J.TRD_CD         = @[trd_cd]" ).append("\n"); 
		query.append("                         AND J.RLANE_CD       = @[rlane_cd]" ).append("\n"); 
		query.append("                         AND J.RE_DIVR_CD     = @[re_divr_cd]" ).append("\n"); 
		query.append("                         AND J.JO_STL_ITM_CD  = @[jo_stl_itm_cd]" ).append("\n"); 
		query.append("                         AND J.JO_MNU_NM      IN ('RDR','TDR')" ).append("\n"); 
		query.append("                         AND J.JO_STL_CFM_CD  = 'Y'" ).append("\n"); 
		query.append("                      )A" ).append("\n"); 
		query.append("                      /* over used slot price */" ).append("\n"); 
		query.append("                    , (" ).append("\n"); 
		query.append("                      SELECT CM.DIR_CD, CM.BSA_SLT_PRC_FM_DT, CM.BSA_SLT_PRC_TO_DT, CM.FM_PORT_CD, CM.TO_PORT_CD, " ).append("\n"); 
		query.append("                             MAX(CD.UC_AMT) AS BSA_SLT_PRC" ).append("\n"); 
		query.append("                        FROM BSA_OVR_USD_MST CM," ).append("\n"); 
		query.append("                             BSA_OVR_USD_SLT_PRC CD" ).append("\n"); 
		query.append("                       WHERE CM.OVR_USD_SLT_PRC_SEQ = CD.OVR_USD_SLT_PRC_SEQ" ).append("\n"); 
		query.append("                         AND CD.UC_AMT   <> 0" ).append("\n"); 
		query.append("                         AND CM.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                         AND CM.TRD_CD   = @[trd_cd]" ).append("\n"); 
		query.append("                         AND CM.RLANE_CD = @[rlane_cd]" ).append("\n"); 
		query.append("                         AND CD.CRR_CD   = @[jo_crr_cd]" ).append("\n"); 
		query.append("--2010.03.02 박효숙 차장...TDR의 OverUsedSlotPrice는 R/E상관없이 MAX값을 가져와라" ).append("\n"); 
		query.append("--if(re_divr_cd =='R')" ).append("\n"); 
		query.append("--                         AND CD.BSA_OP_JB_CD IN ('001','002','004')" ).append("\n"); 
		query.append("--elseif(re_divr_cd =='E')" ).append("\n"); 
		query.append("--                         AND CD.BSA_OP_JB_CD IN ('000','003','005')" ).append("\n"); 
		query.append("--end" ).append("\n"); 
		query.append("                       GROUP BY CM.DIR_CD, CM.BSA_SLT_PRC_FM_DT, CM.BSA_SLT_PRC_TO_DT, CM.FM_PORT_CD, CM.TO_PORT_CD" ).append("\n"); 
		query.append("                      )P" ).append("\n"); 
		query.append("                      /* USED SLOT */" ).append("\n"); 
		query.append("                    , (" ).append("\n"); 
		query.append("                      SELECT H.VSL_CD, H.VOY_NO, H.DIR_CD, H.PORT_CD, H.CALL_IND" ).append("\n"); 
		query.append("                           , SUM(DECODE(C.STATUS,'SM',DECODE(C.CNTR_TYPE,'F',C.QTY,'E',C.QTY,'A',C.QTY,0),0)) +" ).append("\n"); 
		query.append("                               SUM(DECODE(C.STATUS,'SI',DECODE(C.CNTR_TYPE,'F',C.QTY,'E',C.QTY,'A',C.QTY,0),0)) USD_SLT_BSA_QTY" ).append("\n"); 
		query.append("                           , SUM(DECODE(C.STATUS,'SM',DECODE(C.CNTR_TYPE,'F',C.WEIGHT,'E',C.WEIGHT,'A',C.WEIGHT,0),0)) +" ).append("\n"); 
		query.append("                               SUM(DECODE(C.STATUS,'SI',DECODE(C.CNTR_TYPE,'F',C.WEIGHT,'E',C.WEIGHT,'A',C.WEIGHT,0),0)) USD_SLT_WGT" ).append("\n"); 
		query.append("                        FROM TDR_HEADER H, TDR_UTILIZE C" ).append("\n"); 
		query.append("                       WHERE H.VSL_CD    = C.VSL_CD" ).append("\n"); 
		query.append("                         AND H.VOY_NO    = C.VOY_NO" ).append("\n"); 
		query.append("                         AND H.DIR_CD    = C.DIR_CD" ).append("\n"); 
		query.append("                         AND H.PORT_CD   = C.PORT_CD" ).append("\n"); 
		query.append("                         AND H.CALL_IND  = C.CALL_IND" ).append("\n"); 
		query.append("                         AND C.STATUS   IN ('SI','SM')" ).append("\n"); 
		query.append("                         AND (C.OPR_CD, H.VSL_CD, H.VOY_NO, H.DIR_CD) IN (SELECT JO_CRR_CD, VSL_CD, SKD_VOY_NO, SKD_DIR_CD FROM JO_CRR)" ).append("\n"); 
		query.append("                       GROUP BY H.VSL_CD, H.VOY_NO, H.DIR_CD, H.PORT_CD, H.CALL_IND" ).append("\n"); 
		query.append("                      )O," ).append("\n"); 
		query.append("                      /*1st BSA TEU, 1st BSA WGT 구하기*/" ).append("\n"); 
		query.append("                      (" ).append("\n"); 
		query.append("                      SELECT" ).append("\n"); 
		query.append("                             H.VSL_CD, H.VOY_NO, H.DIR_CD, H.PORT_CD, H.CALL_IND," ).append("\n"); 
		query.append("                             NVL(SUM(A.BSA_SLOT),0) + NVL(SUM(A.SWAP_SLOT),0) AS FNL_HJS_BSA_QTY," ).append("\n"); 
		query.append("                             NVL(SUM(A.BSA_WGT),0)  + NVL(SUM(A.SWAP_WGT),0)  AS FNL_BSA_WGT" ).append("\n"); 
		query.append("                      FROM   TDR_HEADER H, TDR_ALLOCATION A" ).append("\n"); 
		query.append("                      WHERE  H.VSL_CD    = A.VSL_CD  " ).append("\n"); 
		query.append("                      AND    H.VOY_NO    = A.VOY_NO  " ).append("\n"); 
		query.append("                      AND    H.DIR_CD    = A.DIR_CD  " ).append("\n"); 
		query.append("                      AND    H.PORT_CD   = A.PORT_CD " ).append("\n"); 
		query.append("                      AND    H.CALL_IND  = A.CALL_IND" ).append("\n"); 
		query.append("                      AND   (A.OPR_CD, H.VSL_CD, H.VOY_NO, H.DIR_CD) IN (SELECT JO_CRR_CD, VSL_CD, SKD_VOY_NO, SKD_DIR_CD FROM JO_CRR)" ).append("\n"); 
		query.append("                      GROUP  BY" ).append("\n"); 
		query.append("                             H.VSL_CD, H.VOY_NO, H.DIR_CD, H.PORT_CD, H.CALL_IND" ).append("\n"); 
		query.append("                      ) F" ).append("\n"); 
		query.append("                WHERE A.SKD_DIR_CD   = P.DIR_CD    (+)" ).append("\n"); 
		query.append("                  AND A.UC_BSS_PORT_ETD_DT BETWEEN TO_DATE(P.BSA_SLT_PRC_FM_DT(+),'YYYYMMDDHH24MISS') AND TO_DATE(P.BSA_SLT_PRC_TO_DT(+),'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("                  AND A.PORT1        = P.FM_PORT_CD(+)" ).append("\n"); 
		query.append("                  AND A.PORT2        = P.TO_PORT_CD(+)" ).append("\n"); 
		query.append("                  AND A.VSL_CD       = O.VSL_CD    (+)" ).append("\n"); 
		query.append("                  AND A.SKD_VOY_NO   = O.VOY_NO    (+)" ).append("\n"); 
		query.append("                  AND A.SKD_DIR_CD   = O.DIR_CD    (+)" ).append("\n"); 
		query.append("                  AND A.PORT1        = O.PORT_CD   (+)" ).append("\n"); 
		query.append("                  AND A.CLPT_IND_SEQ = O.CALL_IND  (+)" ).append("\n"); 
		query.append("                  AND A.VSL_CD       = F.VSL_CD    (+)" ).append("\n"); 
		query.append("                  AND A.SKD_VOY_NO   = F.VOY_NO    (+)" ).append("\n"); 
		query.append("                  AND A.SKD_DIR_CD   = F.DIR_CD    (+)" ).append("\n"); 
		query.append("                  AND A.PORT1        = F.PORT_CD   (+)" ).append("\n"); 
		query.append("                  AND A.CLPT_IND_SEQ = F.CALL_IND  (+)" ).append("\n"); 
		query.append("               )T," ).append("\n"); 
		query.append("               (SELECT LOCL_CURR_CD" ).append("\n"); 
		query.append("                  FROM JOO_FINC_MTX" ).append("\n"); 
		query.append("                 WHERE JO_CRR_CD     = @[jo_crr_cd]" ).append("\n"); 
		query.append("                   AND RLANE_CD      = @[rlane_cd]" ).append("\n"); 
		query.append("                   AND RE_DIVR_CD    = @[re_divr_cd]" ).append("\n"); 
		query.append("                   AND JO_STL_ITM_CD = @[jo_stl_itm_cd]" ).append("\n"); 
		query.append("               )E" ).append("\n"); 
		query.append("--2010.03.29 REVERSE된 VVD는 CREATE시 다시 나와야 한다." ).append("\n"); 
		query.append("       WHERE  (T.VSL_CD, T.SKD_VOY_NO, T.SKD_DIR_CD, T.REV_DIR_CD, T.FM_PORT_CD, T.TO_PORT_CD, 'N') " ).append("\n"); 
		query.append("       NOT IN (" ).append("\n"); 
		query.append("        SELECT X.VSL_CD, X.SKD_VOY_NO, X.SKD_DIR_CD, X.REV_DIR_CD, X.FM_PORT_CD, X.TO_PORT_CD, NVL(Y.RVS_CMB_FLG,'N') AS RVS_CMB_FLG" ).append("\n"); 
		query.append("        FROM   JOO_SETTLEMENT  X," ).append("\n"); 
		query.append("               (" ).append("\n"); 
		query.append("               SELECT Y.ACCT_YRMON, Y.STL_VVD_SEQ, Y.STL_SEQ, Z.RVS_CMB_FLG" ).append("\n"); 
		query.append("               FROM   JOO_STL_CMB_DTL Y," ).append("\n"); 
		query.append("                      JOO_STL_CMB     Z" ).append("\n"); 
		query.append("               WHERE  Y.ACCT_YRMON = Z.ACCT_YRMON" ).append("\n"); 
		query.append("               AND    Y.JO_CRR_CD  = Z.JO_CRR_CD" ).append("\n"); 
		query.append("               AND    Y.STL_CMB_SEQ= Z.STL_CMB_SEQ" ).append("\n"); 
		query.append("               AND    Y.RE_DIVR_CD = Z.RE_DIVR_CD" ).append("\n"); 
		query.append("               ) Y" ).append("\n"); 
		query.append("        WHERE  X.ACCT_YRMON     = Y.ACCT_YRMON  (+)" ).append("\n"); 
		query.append("        AND    X.STL_VVD_SEQ    = Y.STL_VVD_SEQ (+)" ).append("\n"); 
		query.append("        AND    X.STL_SEQ        = Y.STL_SEQ     (+) " ).append("\n"); 
		query.append("        AND    X.ACCT_YRMON     = REPLACE(@[acct_yrmon],'-','')" ).append("\n"); 
		query.append("        AND    X.JO_CRR_CD      = @[jo_crr_cd]" ).append("\n"); 
		query.append("        AND    X.RE_DIVR_CD     = @[re_divr_cd]" ).append("\n"); 
		query.append("        AND    X.TRD_CD         = @[trd_cd]" ).append("\n"); 
		query.append("        AND    X.RLANE_CD       = @[rlane_cd]" ).append("\n"); 
		query.append("        AND    X.JO_STL_ITM_CD  = @[jo_stl_itm_cd]" ).append("\n"); 
		query.append("        AND    X.JO_MNU_NM      = 'TDR'" ).append("\n"); 
		query.append("      )" ).append("\n"); 
		query.append("           " ).append("\n"); 
		query.append("/*" ).append("\n"); 
		query.append("		WHERE  NOT EXISTS (" ).append("\n"); 
		query.append("                 SELECT 1" ).append("\n"); 
		query.append("                 FROM   JOO_SETTLEMENT X" ).append("\n"); 
		query.append("                 WHERE  X.ACCT_YRMON    = T.ACCT_YRMON" ).append("\n"); 
		query.append("                 AND    X.JO_CRR_CD     = T.JO_CRR_CD" ).append("\n"); 
		query.append("                 AND    X.RE_DIVR_CD    = T.RE_DIVR_CD" ).append("\n"); 
		query.append("                 AND    X.TRD_CD        = T.TRD_CD" ).append("\n"); 
		query.append("                 AND    X.RLANE_CD      = T.RLANE_CD" ).append("\n"); 
		query.append("                 AND    X.JO_STL_ITM_CD = T.JO_STL_ITM_CD" ).append("\n"); 
		query.append("                 AND    X.JO_MNU_NM     = T.JO_MNU_NM" ).append("\n"); 
		query.append("                 AND    X.VSL_CD        = T.VSL_CD" ).append("\n"); 
		query.append("                 AND    X.SKD_VOY_NO    = T.SKD_VOY_NO" ).append("\n"); 
		query.append("                 AND    X.SKD_DIR_CD    = T.SKD_DIR_CD" ).append("\n"); 
		query.append("                 AND    X.REV_DIR_CD    = T.REV_DIR_CD" ).append("\n"); 
		query.append("                 AND    X.FM_PORT_CD    = T.FM_PORT_CD" ).append("\n"); 
		query.append("                 AND    X.TO_PORT_CD    = T.TO_PORT_CD" ).append("\n"); 
		query.append("               )" ).append("\n"); 
		query.append("*/" ).append("\n"); 
		query.append("      )" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("       'R' AS IBFLAG" ).append("\n"); 
		query.append("       ,A.ACCT_YRMON" ).append("\n"); 
		query.append("       ,A.STL_VVD_SEQ" ).append("\n"); 
		query.append("       ,A.STL_SEQ" ).append("\n"); 
		query.append("       ,A.TRD_CD" ).append("\n"); 
		query.append("       ,A.JO_CRR_CD" ).append("\n"); 
		query.append("       ,A.RLANE_CD" ).append("\n"); 
		query.append("       ,A.RE_DIVR_CD" ).append("\n"); 
		query.append("       ,A.JO_STL_ITM_CD" ).append("\n"); 
		query.append("       ,A.JO_MNU_NM" ).append("\n"); 
		query.append("       ,A.VSL_CD" ).append("\n"); 
		query.append("       ,A.SKD_VOY_NO" ).append("\n"); 
		query.append("       ,A.SKD_DIR_CD" ).append("\n"); 
		query.append("       ,A.REV_DIR_CD" ).append("\n"); 
		query.append("       ,A.STL_BZC_PORT_CD" ).append("\n"); 
		query.append("       ,TO_CHAR(A.ETA_DT,'YYYYMMDDHH24MISS') ETA_DT" ).append("\n"); 
		query.append("       ,A.JO_STL_JB_CD" ).append("\n"); 
		query.append("       ,A.BSA_QTY" ).append("\n"); 
		query.append("       ,A.BSA_SLT_PRC" ).append("\n"); 
		query.append("       ,A.LOCL_CURR_CD" ).append("\n"); 
		query.append("       ,A.ADJ_BSA_QTY_LOCL_AMT" ).append("\n"); 
		query.append("       ,A.ADJ_BSA_SLT_PRC_LOCL_AMT" ).append("\n"); 
		query.append("       ,A.STL_LOCL_AMT" ).append("\n"); 
		query.append("       ,A.STL_USD_AMT" ).append("\n"); 
		query.append("       ,A.IOC_CD" ).append("\n"); 
		query.append("       ,A.SCONTI_CD" ).append("\n"); 
		query.append("       ,A.FNL_HJS_BSA_QTY" ).append("\n"); 
		query.append("       ,A.FNL_BSA_WGT" ).append("\n"); 
		query.append("       ,A.USD_SLT_BSA_QTY" ).append("\n"); 
		query.append("       ,A.USD_SLT_WGT" ).append("\n"); 
		query.append("       ,A.BSA_PER_WGT" ).append("\n"); 
		query.append("       ,A.FM_PORT_CD" ).append("\n"); 
		query.append("       ,A.TO_PORT_CD" ).append("\n"); 
		query.append("       ,A.RF_SCG_STL_TP_CD" ).append("\n"); 
		query.append("       ,A.RF_SCG_PRC" ).append("\n"); 
		query.append("       ,A.STL_RMK" ).append("\n"); 
		query.append("       ,A.CMB_CFM_FLG" ).append("\n"); 
		query.append("       ,B.STL_CMB_SEQ" ).append("\n"); 
		query.append("       ,A.STL_TJ_NO" ).append("\n"); 
		query.append("       ,A.STL_ADJ_FLG" ).append("\n"); 
		query.append("       ,A.PRE_ACCT_YRMON" ).append("\n"); 
		query.append("       ,A.PRE_STL_VVD_SEQ" ).append("\n"); 
		query.append("       ,A.PRE_STL_SEQ" ).append("\n"); 
		query.append("       ,A.STL_LST_FLG" ).append("\n"); 
		query.append("       ,A.UC_BSS_PORT_CD" ).append("\n"); 
		query.append("       ,TO_CHAR(A.UC_BSS_PORT_ETD_DT,'YYYYMMDDHH24MISS') AS UC_BSS_PORT_ETD_DT" ).append("\n"); 
		query.append("       ,B.SLIP_NO" ).append("\n"); 
		query.append("       ,'1' AS CLPT_IND_SEQ" ).append("\n"); 
		query.append("       ,NVL(B.RVS_CMB_FLG,'N') AS RVS_CMB_FLG" ).append("\n"); 
		query.append("FROM   JOO_SETTLEMENT A," ).append("\n"); 
		query.append("       (" ).append("\n"); 
		query.append("       SELECT" ).append("\n"); 
		query.append("              B.ACCT_YRMON" ).append("\n"); 
		query.append("             ,B.STL_VVD_SEQ" ).append("\n"); 
		query.append("             ,B.STL_SEQ" ).append("\n"); 
		query.append("             ,B.STL_CMB_SEQ" ).append("\n"); 
		query.append("             ,A.SLP_TP_CD||A.SLP_FUNC_CD||A.SLP_OFC_CD||TO_CHAR(TO_DATE(A.SLP_ISS_DT,'YYYYMMDD'),'RRMMDD')||A.SLP_SER_NO AS SLIP_NO" ).append("\n"); 
		query.append("             ,A.RVS_CMB_FLG" ).append("\n"); 
		query.append("             ,A.RJCT_CMB_FLG" ).append("\n"); 
		query.append("       FROM   JOO_STL_CMB     A," ).append("\n"); 
		query.append("              JOO_STL_CMB_DTL B" ).append("\n"); 
		query.append("       WHERE  A.ACCT_YRMON  = B.ACCT_YRMON" ).append("\n"); 
		query.append("       AND    A.JO_CRR_CD   = B.JO_CRR_CD" ).append("\n"); 
		query.append("       AND    A.STL_CMB_SEQ = B.STL_CMB_SEQ" ).append("\n"); 
		query.append("       AND    A.RE_DIVR_CD  = B.RE_DIVR_CD" ).append("\n"); 
		query.append("       AND    A.ACCT_YRMON  = REPLACE(@[acct_yrmon],'-','')" ).append("\n"); 
		query.append("       AND    A.JO_CRR_CD   = @[jo_crr_cd]" ).append("\n"); 
		query.append("       AND    A.RE_DIVR_CD  = @[re_divr_cd]" ).append("\n"); 
		query.append("       -- 2010.01.06 REVERSE 된 것은 COMBINED NO가 보여져서는 안된다 => 삭제가능하게 " ).append("\n"); 
		query.append("      -- 2010.03.23 REVERSE 된 것은 copy를 하므로 기존 reverse data는 combined no를 보여주도록 한다. (삭제불가)" ).append("\n"); 
		query.append("       --AND    A.RVS_CMB_FLG = 'N'" ).append("\n"); 
		query.append("       --AND    A.RJCT_CMB_FLG = 'N'" ).append("\n"); 
		query.append("       ) B" ).append("\n"); 
		query.append("WHERE  A.ACCT_YRMON    = B.ACCT_YRMON (+)" ).append("\n"); 
		query.append("AND    A.STL_VVD_SEQ   = B.STL_VVD_SEQ(+)" ).append("\n"); 
		query.append("AND    A.STL_SEQ       = B.STL_SEQ    (+)" ).append("\n"); 
		query.append("AND    A.ACCT_YRMON    = REPLACE(@[acct_yrmon],'-','')" ).append("\n"); 
		query.append("AND    A.JO_CRR_CD     = @[jo_crr_cd]" ).append("\n"); 
		query.append("AND    A.RE_DIVR_CD    = @[re_divr_cd]" ).append("\n"); 
		query.append("AND    A.TRD_CD        = @[trd_cd]" ).append("\n"); 
		query.append("AND    A.RLANE_CD      = @[rlane_cd]" ).append("\n"); 
		query.append("AND	   A.JO_STL_ITM_CD = @[jo_stl_itm_cd]" ).append("\n"); 
		query.append("AND    A.JO_MNU_NM     = @[jo_mnu_nm]" ).append("\n"); 
		query.append("ORDER  BY IBFLAG DESC, SKD_DIR_CD, VSL_CD, SKD_VOY_NO, REV_DIR_CD" ).append("\n"); 

	}
}