/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ChargeCalculationDBDAOCheckDailyMovementCalculationByBookingRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.10.18
*@LastModifier : 
*@LastVersion : 1.0
* 2016.10.18 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChargeCalculationDBDAOCheckDailyMovementCalculationByBookingRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ChargeCalculationDBDAOCheckDailyMovementCalculationByBookingRSQL
	  * </pre>
	  */
	public ChargeCalculationDBDAOCheckDailyMovementCalculationByBookingRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("batch_cntr",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.integration").append("\n"); 
		query.append("FileName : ChargeCalculationDBDAOCheckDailyMovementCalculationByBookingRSQL").append("\n"); 
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
		query.append("SELECT COUNT(*)" ).append("\n"); 
		query.append("  FROM (SELECT MM.CNTR_NO CNTR_NO" ).append("\n"); 
		query.append("              ,MM.CNMV_CYC_NO CNMV_CYC_NO" ).append("\n"); 
		query.append("              ,MM.CNTR_TPSZ_CD CNTRTS_CD" ).append("\n"); 
		query.append("              ,CC.SOC_FLG BCNTR_SOC_IND" ).append("\n"); 
		query.append("              ,CC.RCV_TERM_CD BCNTR_RCV_TERM" ).append("\n"); 
		query.append("              ,CC.DE_TERM_CD BCNTR_DLV_TERM" ).append("\n"); 
		query.append("              ,BB.BKG_NO BKG_NO" ).append("\n"); 
		query.append("              ,BB.BL_NO BL_NO" ).append("\n"); 
		query.append("              ,SUBSTR (MM.ORG_YD_CD" ).append("\n"); 
		query.append("                      ,0" ).append("\n"); 
		query.append("                      ,2" ).append("\n"); 
		query.append("                      ) CNT_CD" ).append("\n"); 
		query.append("              ,MM.VNDR_SEQ VNDR_SEQ" ).append("\n"); 
		query.append("              ,BB.POR_CD POR_LOC" ).append("\n"); 
		query.append("              ,BB.POL_CD POL_LOC" ).append("\n"); 
		query.append("              ,BB.POD_CD POD_LOC" ).append("\n"); 
		query.append("              ,BB.DEL_CD DEL_LOC" ).append("\n"); 
		query.append("              ,BB.PST_RLY_PORT_CD POST_RLY" ).append("\n"); 
		query.append("              ,BB.PRE_RLY_PORT_CD PRE_RLY" ).append("\n"); 
		query.append("              ,BB.VSL_CD VSL_CD" ).append("\n"); 
		query.append("              ,BB.SKD_VOY_NO SKD_VOYAGE_NO" ).append("\n"); 
		query.append("              ,BB.SKD_DIR_CD SKD_DIR_CD" ).append("\n"); 
		query.append("              ,MM.MVMT_STS_CD CNMS_CD" ).append("\n"); 
		query.append("              ,TO_CHAR (MM.CNMV_EVNT_DT, 'YYYYMMDDHH24MI') CNMV_DT_TM" ).append("\n"); 
		query.append("              ,MM.ORG_YD_CD ORG_YD_CD" ).append("\n"); 
		query.append("              ,MM.CNMV_YR CNMV_YY" ).append("\n"); 
		query.append("              ,MM.CNMV_SEQ CNMV_SEQ" ).append("\n"); 
		query.append("              ,MM.CNMV_SPLIT_NO CNMV_SPLIT" ).append("\n"); 
		query.append("              ,NVL (RL.CONTI_CD, ' ') POR_CONTI_CD" ).append("\n"); 
		query.append("              ,NVL (RL.CNT_CD, ' ') POR_CNT_CD" ).append("\n"); 
		query.append("              ,NVL (RL.RGN_CD, ' ') POR_RGN_CD" ).append("\n"); 
		query.append("              ,NVL (RL.STE_CD, ' ') POR_LOC_STATE" ).append("\n"); 
		query.append("              ,NVL (LL.CONTI_CD, ' ') POL_CONTI_CD" ).append("\n"); 
		query.append("              ,NVL (LL.CNT_CD, ' ') POL_CNT_CD" ).append("\n"); 
		query.append("              ,NVL (LL.RGN_CD, ' ') POL_RGN_CD" ).append("\n"); 
		query.append("              ,NVL (LL.STE_CD, ' ') POL_LOC_STATE" ).append("\n"); 
		query.append("              ,NVL (EL.CONTI_CD, ' ') DEL_CONTI_CD" ).append("\n"); 
		query.append("              ,NVL (EL.CNT_CD, ' ') DEL_CNT_CD" ).append("\n"); 
		query.append("              ,NVL (EL.RGN_CD, ' ') DEL_RGN_CD" ).append("\n"); 
		query.append("              ,NVL (EL.STE_CD, ' ') DEL_LOC_STATE" ).append("\n"); 
		query.append("              ,DECODE(MM.MVMT_STS_CD, 'IC', 'I', " ).append("\n"); 
		query.append("              						  'ID', 'I', " ).append("\n"); 
		query.append("              						  'OP', 'O'," ).append("\n"); 
		query.append("              						  'OC', 'O'," ).append("\n"); 
		query.append("              						  DECODE (MM.OB_CNTR_FLG, 'Y', 'O', 'N', 'I')) CNMV_OB_FLG" ).append("\n"); 
		query.append("              ,MM.FCNTR_FLG CNMV_FULL_FLG" ).append("\n"); 
		query.append("              ,DS.SKP_LOC_CD DSL_SKIP_LOC" ).append("\n"); 
		query.append("              ,BB.BKG_CRE_DT BKG_CRE_DT" ).append("\n"); 
		query.append("			  ,CASE" ).append("\n"); 
		query.append("               WHEN MM.MVMT_STS_CD = 'VL' THEN" ).append("\n"); 
		query.append("                   CASE " ).append("\n"); 
		query.append("                   WHEN SUBSTR(MM.ORG_YD_CD, 1, 5) = BB.POL_CD  THEN" ).append("\n"); 
		query.append("                        'Y'" ).append("\n"); 
		query.append("                   ELSE" ).append("\n"); 
		query.append("                        'N'" ).append("\n"); 
		query.append("                   END" ).append("\n"); 
		query.append("               WHEN MM.MVMT_STS_CD = 'VD' THEN" ).append("\n"); 
		query.append("                   CASE" ).append("\n"); 
		query.append("                   WHEN SUBSTR(MM.ORG_YD_CD, 1, 5) = BB.POD_CD THEN" ).append("\n"); 
		query.append("                        'Y'" ).append("\n"); 
		query.append("                   ELSE" ).append("\n"); 
		query.append("                         'N'" ).append("\n"); 
		query.append("                   END" ).append("\n"); 
		query.append("               WHEN MM.MVMT_STS_CD = 'MT' THEN" ).append("\n"); 
		query.append("                   CASE" ).append("\n"); 
		query.append("                   WHEN SUBSTR(MM.ORG_YD_CD, 1, 2) = SUBSTR(BB.DEL_CD, 1, 2) THEN" ).append("\n"); 
		query.append("                        'Y'" ).append("\n"); 
		query.append("                   ELSE" ).append("\n"); 
		query.append("                       'N'" ).append("\n"); 
		query.append("                   END" ).append("\n"); 
		query.append("               WHEN MM.MVMT_STS_CD = 'IC' THEN" ).append("\n"); 
		query.append("                   CASE" ).append("\n"); 
		query.append("                   WHEN (" ).append("\n"); 
		query.append("                        SELECT  /*+ INDEX_DESC(S XFN1CTM_MOVEMENT ) */" ).append("\n"); 
		query.append("                                RTRIM(XMLAGG(XMLELEMENT(C, MVMT_STS_CD, '') ORDER BY S.CNTR_NO).EXTRACT( '//text()'), '|')" ).append("\n"); 
		query.append("                        FROM    CTM_MOVEMENT S" ).append("\n"); 
		query.append("                        WHERE   S.CNTR_NO   = MM.CNTR_NO" ).append("\n"); 
		query.append("                        AND     S.CNMV_YR || TO_CHAR (S.CNMV_SEQ, '0000') || S.CNMV_SPLIT_NO < MM.CNMV_YR || TO_CHAR (MM.CNMV_SEQ, '0000') || MM.CNMV_SPLIT_NO" ).append("\n"); 
		query.append("                        AND     ROWNUM  <= 2" ).append("\n"); 
		query.append("                        ) = 'TNTS' OR" ).append("\n"); 
		query.append("                        (" ).append("\n"); 
		query.append("                        SELECT  /*+ INDEX_DESC(S XFN1CTM_MOVEMENT ) */" ).append("\n"); 
		query.append("                                RTRIM(XMLAGG(XMLELEMENT(C, MVMT_STS_CD, '') ORDER BY S.CNTR_NO).EXTRACT( '//text()'), '|')" ).append("\n"); 
		query.append("                        FROM    CTM_MOVEMENT S" ).append("\n"); 
		query.append("                        WHERE   S.CNTR_NO   = MM.CNTR_NO" ).append("\n"); 
		query.append("                        AND     S.CNMV_YR || TO_CHAR (S.CNMV_SEQ, '0000') || S.CNMV_SPLIT_NO < MM.CNMV_YR || TO_CHAR (MM.CNMV_SEQ, '0000') || MM.CNMV_SPLIT_NO" ).append("\n"); 
		query.append("                        AND     ROWNUM  <= 4" ).append("\n"); 
		query.append("                        ) IN ( 'ENICTNTS', 'TNICTNTS')" ).append("\n"); 
		query.append("                            THEN" ).append("\n"); 
		query.append("                        'N'" ).append("\n"); 
		query.append("                   ELSE" ).append("\n"); 
		query.append("                       'Y'" ).append("\n"); 
		query.append("                   END" ).append("\n"); 
		query.append("               ELSE" ).append("\n"); 
		query.append("                  'Y'" ).append("\n"); 
		query.append("               END AS BKG_CTM_VLVD_PORT_CHK	              " ).append("\n"); 
		query.append("          FROM CTM_MOVEMENT MM" ).append("\n"); 
		query.append("              ,BKG_BOOKING BB" ).append("\n"); 
		query.append("              ,BKG_CONTAINER CC" ).append("\n"); 
		query.append("              ,MDM_LOCATION RL" ).append("\n"); 
		query.append("              ,MDM_LOCATION LL" ).append("\n"); 
		query.append("              ,MDM_LOCATION EL" ).append("\n"); 
		query.append("              ,DMT_SKP_LOC DS" ).append("\n"); 
		query.append("		 WHERE 1=1" ).append("\n"); 
		query.append("#if (${dmdt_trf_cd} == 'DTOC')" ).append("\n"); 
		query.append("           AND MM.MVMT_STS_CD IN ( 'OP', 'OC' )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${dmdt_trf_cd} == 'DMOF')" ).append("\n"); 
		query.append("           AND MM.MVMT_STS_CD IN ( 'OC','VL' )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${dmdt_trf_cd} == 'CTOC')" ).append("\n"); 
		query.append("           AND MM.MVMT_STS_CD IN ( 'OP','VL' )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${dmdt_trf_cd} == 'DMIF')" ).append("\n"); 
		query.append("           AND MM.MVMT_STS_CD IN ( 'VD','ID' )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${dmdt_trf_cd} == 'DTIC')" ).append("\n"); 
		query.append("           AND MM.MVMT_STS_CD IN ( 'ID','MT' )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${dmdt_trf_cd} == 'CTIC')" ).append("\n"); 
		query.append("           AND MM.MVMT_STS_CD IN ( 'VL','MT' )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("           AND MM.BKG_NO = CC.BKG_NO" ).append("\n"); 
		query.append("           AND MM.CNTR_NO = CC.CNTR_NO" ).append("\n"); 
		query.append("           AND MM.BKG_NO = BB.BKG_NO" ).append("\n"); 
		query.append("           AND BB.BKG_STS_CD <> 'S'" ).append("\n"); 
		query.append("           AND BB.BKG_STS_CD <> 'X'" ).append("\n"); 
		query.append("           AND BB.BKG_CGO_TP_CD = 'F'" ).append("\n"); 
		query.append("           AND BB.POR_CD = RL.LOC_CD" ).append("\n"); 
		query.append("           AND BB.POL_CD = LL.LOC_CD" ).append("\n"); 
		query.append("           AND BB.DEL_CD = EL.LOC_CD" ).append("\n"); 
		query.append("           AND DS.KEY_LOC_CD(+) = SUBSTR (MM.ORG_YD_CD" ).append("\n"); 
		query.append("                                         ,1" ).append("\n"); 
		query.append("                                         ,5" ).append("\n"); 
		query.append("                                         )" ).append("\n"); 
		query.append("           AND (   (    DECODE (MM.OB_CNTR_FLG" ).append("\n"); 
		query.append("                               ,'Y', 'O'" ).append("\n"); 
		query.append("                               ,'N', 'I'" ).append("\n"); 
		query.append("                               ) = 'O'" ).append("\n"); 
		query.append("                    AND CC.RCV_TERM_CD IN ('D', 'H', 'I', 'M', 'Y' ,'S')" ).append("\n"); 
		query.append("                   )" ).append("\n"); 
		query.append("                OR (    DECODE (MM.OB_CNTR_FLG" ).append("\n"); 
		query.append("                               ,'Y', 'O'" ).append("\n"); 
		query.append("                               ,'N', 'I'" ).append("\n"); 
		query.append("                               ) = 'I'" ).append("\n"); 
		query.append("                    AND CC.DE_TERM_CD IN ('D', 'H', 'O', 'M', 'Y' ,'S')" ).append("\n"); 
		query.append("                   )" ).append("\n"); 
		query.append("               )" ).append("\n"); 
		query.append("           AND BB.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#if (${batch_cntr} != '')" ).append("\n"); 
		query.append("           AND MM.CNTR_NO LIKE @[batch_cntr]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT MM.CNTR_NO CNTR_NO" ).append("\n"); 
		query.append("              ,MM.CNMV_CYC_NO CNMV_CYC_NO" ).append("\n"); 
		query.append("              ,MM.CNTR_TPSZ_CD CNTRTS_CD" ).append("\n"); 
		query.append("              ,CC.SOC_FLG BCNTR_SOC_IND" ).append("\n"); 
		query.append("              ,CC.RCV_TERM_CD BCNTR_RCV_TERM" ).append("\n"); 
		query.append("              ,CC.DE_TERM_CD BCNTR_DLV_TERM" ).append("\n"); 
		query.append("              ,BB.BKG_NO BKG_NO" ).append("\n"); 
		query.append("              ,BB.BL_NO BL_NO" ).append("\n"); 
		query.append("              ,SUBSTR (MM.ORG_YD_CD" ).append("\n"); 
		query.append("                      ,0" ).append("\n"); 
		query.append("                      ,2" ).append("\n"); 
		query.append("                      ) CNT_CD" ).append("\n"); 
		query.append("              ,MM.VNDR_SEQ VNDR_SEQ" ).append("\n"); 
		query.append("              ,BB.POR_CD POR_LOC" ).append("\n"); 
		query.append("              ,BB.POL_CD POL_LOC" ).append("\n"); 
		query.append("              ,BB.POD_CD POD_LOC" ).append("\n"); 
		query.append("              ,BB.DEL_CD DEL_LOC" ).append("\n"); 
		query.append("              ,BB.PST_RLY_PORT_CD POST_RLY" ).append("\n"); 
		query.append("              ,BB.PRE_RLY_PORT_CD PRE_RLY" ).append("\n"); 
		query.append("              ,BB.VSL_CD VSL_CD" ).append("\n"); 
		query.append("              ,BB.SKD_VOY_NO SKD_VOYAGE_NO" ).append("\n"); 
		query.append("              ,BB.SKD_DIR_CD SKD_DIR_CD" ).append("\n"); 
		query.append("              ,MM.MVMT_STS_CD CNMS_CD" ).append("\n"); 
		query.append("              ,TO_CHAR (MM.CNMV_EVNT_DT, 'YYYYMMDDHH24MI') CNMV_DT_TM" ).append("\n"); 
		query.append("              ,MM.ORG_YD_CD ORG_YD_CD" ).append("\n"); 
		query.append("              ,MM.CNMV_YR CNMV_YY" ).append("\n"); 
		query.append("              ,MM.CNMV_SEQ CNMV_SEQ" ).append("\n"); 
		query.append("              ,MM.CNMV_SPLIT_NO CNMV_SPLIT" ).append("\n"); 
		query.append("              ,NVL (RL.CONTI_CD, ' ') POR_CONTI_CD" ).append("\n"); 
		query.append("              ,NVL (RL.CNT_CD, ' ') POR_CNT_CD" ).append("\n"); 
		query.append("              ,NVL (RL.RGN_CD, ' ') POR_RGN_CD" ).append("\n"); 
		query.append("              ,NVL (RL.STE_CD, ' ') POR_LOC_STATE" ).append("\n"); 
		query.append("              ,NVL (LL.CONTI_CD, ' ') POL_CONTI_CD" ).append("\n"); 
		query.append("              ,NVL (LL.CNT_CD, ' ') POL_CNT_CD" ).append("\n"); 
		query.append("              ,NVL (LL.RGN_CD, ' ') POL_RGN_CD" ).append("\n"); 
		query.append("              ,NVL (LL.STE_CD, ' ') POL_LOC_STATE" ).append("\n"); 
		query.append("              ,NVL (EL.CONTI_CD, ' ') DEL_CONTI_CD" ).append("\n"); 
		query.append("              ,NVL (EL.CNT_CD, ' ') DEL_CNT_CD" ).append("\n"); 
		query.append("              ,NVL (EL.RGN_CD, ' ') DEL_RGN_CD" ).append("\n"); 
		query.append("              ,NVL (EL.STE_CD, ' ') DEL_LOC_STATE" ).append("\n"); 
		query.append("              ,'I' CNMV_OB_FLG" ).append("\n"); 
		query.append("              ,MM.FCNTR_FLG CNMV_FULL_FLG" ).append("\n"); 
		query.append("              ,DS.SKP_LOC_CD DSL_SKIP_LOC" ).append("\n"); 
		query.append("              ,BB.BKG_CRE_DT BKG_CRE_DT" ).append("\n"); 
		query.append("              ,'Y' AS BKG_CTM_VLVD_PORT_CHK" ).append("\n"); 
		query.append("          FROM CTM_MOVEMENT MM" ).append("\n"); 
		query.append("              ,BKG_BOOKING BB" ).append("\n"); 
		query.append("              ,BKG_CONTAINER CC" ).append("\n"); 
		query.append("              ,MDM_LOCATION RL" ).append("\n"); 
		query.append("              ,MDM_LOCATION LL" ).append("\n"); 
		query.append("              ,MDM_LOCATION EL" ).append("\n"); 
		query.append("              ,DMT_SKP_LOC DS" ).append("\n"); 
		query.append("		 WHERE 1=1" ).append("\n"); 
		query.append("           AND MM.MVMT_STS_CD = 'XX'" ).append("\n"); 
		query.append("           AND NOT EXISTS" ).append("\n"); 
		query.append("               (SELECT 1" ).append("\n"); 
		query.append("                FROM   CTM_MOVEMENT" ).append("\n"); 
		query.append("                WHERE  BKG_NO = MM.BKG_NO " ).append("\n"); 
		query.append("                AND    CNTR_NO = MM.CNTR_NO" ).append("\n"); 
		query.append("                AND    MVMT_STS_CD = 'MT')" ).append("\n"); 
		query.append("           AND MM.CNTR_NO = CC.CNTR_NO" ).append("\n"); 
		query.append("           AND MM.CNMV_CYC_NO = CC.CNMV_CYC_NO" ).append("\n"); 
		query.append("           AND CC.BKG_NO = BB.BKG_NO" ).append("\n"); 
		query.append("           AND BB.BKG_STS_CD <> 'S'" ).append("\n"); 
		query.append("           AND BB.BKG_STS_CD <> 'X'" ).append("\n"); 
		query.append("           AND BB.BKG_CGO_TP_CD = 'F'" ).append("\n"); 
		query.append("           AND BB.POR_CD = RL.LOC_CD" ).append("\n"); 
		query.append("           AND BB.POL_CD = LL.LOC_CD" ).append("\n"); 
		query.append("           AND BB.DEL_CD = EL.LOC_CD" ).append("\n"); 
		query.append("           AND DS.KEY_LOC_CD(+) = SUBSTR (MM.ORG_YD_CD" ).append("\n"); 
		query.append("                                         ,1" ).append("\n"); 
		query.append("                                         ,5" ).append("\n"); 
		query.append("                                         )" ).append("\n"); 
		query.append("           AND (   (    DECODE (MM.OB_CNTR_FLG" ).append("\n"); 
		query.append("                               ,'Y', 'O'" ).append("\n"); 
		query.append("                               ,'N', 'I'" ).append("\n"); 
		query.append("                               ) = 'O'" ).append("\n"); 
		query.append("                    AND CC.RCV_TERM_CD IN ('D', 'H', 'I', 'M', 'Y' ,'S')" ).append("\n"); 
		query.append("                   )" ).append("\n"); 
		query.append("                OR (    DECODE (MM.OB_CNTR_FLG" ).append("\n"); 
		query.append("                               ,'Y', 'O'" ).append("\n"); 
		query.append("                               ,'N', 'I'" ).append("\n"); 
		query.append("                               ) = 'I'" ).append("\n"); 
		query.append("                    AND CC.DE_TERM_CD IN ('D', 'H', 'O', 'M', 'Y' ,'S')" ).append("\n"); 
		query.append("                   )" ).append("\n"); 
		query.append("               )" ).append("\n"); 
		query.append("           AND BB.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#if (${batch_cntr} != '')" ).append("\n"); 
		query.append("           AND MM.CNTR_NO LIKE @[batch_cntr]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")            " ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND   BKG_CTM_VLVD_PORT_CHK = 'Y'" ).append("\n"); 
		query.append("ORDER BY CNTR_NO, CNMV_YY, CNMV_SEQ, CNMV_SPLIT" ).append("\n"); 

	}
}