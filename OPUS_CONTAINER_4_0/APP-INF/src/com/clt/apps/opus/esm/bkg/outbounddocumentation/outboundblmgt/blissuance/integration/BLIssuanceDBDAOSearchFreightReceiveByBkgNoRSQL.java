/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BLIssuanceDBDAOSearchFreightReceiveByBkgNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.11.09
*@LastModifier : 
*@LastVersion : 1.0
* 2016.11.09 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLIssuanceDBDAOSearchFreightReceiveByBkgNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * FREIGHT RECEIVE 조회
	  * </pre>
	  */
	public BLIssuanceDBDAOSearchFreightReceiveByBkgNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration").append("\n"); 
		query.append("FileName : BLIssuanceDBDAOSearchFreightReceiveByBkgNoRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("      SPLT.PPT_OTS_CURR_CD1" ).append("\n"); 
		query.append("    , SPLT.PPT_RCV_DT" ).append("\n"); 
		query.append("    , SPLT.PPT_RCV_OFC_CD" ).append("\n"); 
		query.append("    , SPLT.PPT_RCV_USR_ID" ).append("\n"); 
		query.append("    , SPLT.PPT_STS_CD" ).append("\n"); 
		query.append("    , SPLT.CCT_OTS_CURR_CD1" ).append("\n"); 
		query.append("    , SPLT.CCT_RCV_DT" ).append("\n"); 
		query.append("    , SPLT.CCT_RCV_OFC_CD" ).append("\n"); 
		query.append("    , SPLT.CCT_RCV_USR_ID" ).append("\n"); 
		query.append("    , SPLT.CCT_STS_CD" ).append("\n"); 
		query.append("    , SPLT.N3PTY_PPT_OTS_CURR_CD1" ).append("\n"); 
		query.append("    , SPLT.N3PTY_PPT_RCV_DT" ).append("\n"); 
		query.append("    , SPLT.N3PTY_PPT_RCV_OFC_CD" ).append("\n"); 
		query.append("    , SPLT.N3PTY_PPT_RCV_USR_ID" ).append("\n"); 
		query.append("    , SPLT.N3PTY_PPT_STS_CD" ).append("\n"); 
		query.append("    , SPLT.N3PTY_CCT_OTS_CURR_CD1" ).append("\n"); 
		query.append("    , SPLT.N3PTY_CCT_RCV_DT" ).append("\n"); 
		query.append("    , SPLT.N3PTY_CCT_RCV_OFC_CD" ).append("\n"); 
		query.append("    , SPLT.N3PTY_CCT_RCV_USR_ID" ).append("\n"); 
		query.append("    , SPLT.N3PTY_CCT_STS_CD" ).append("\n"); 
		query.append("    , TOTL.TOT_OTS_CURR_CD1" ).append("\n"); 
		query.append("    , TOTL.TOT_OTS_AMT1" ).append("\n"); 
		query.append("    , TOTL.TOT_OTS_CURR_CD2" ).append("\n"); 
		query.append("    , TOTL.TOT_OTS_AMT2" ).append("\n"); 
		query.append("    , TOTL.TOT_OTS_CURR_CD3" ).append("\n"); 
		query.append("    , TOTL.TOT_OTS_AMT3" ).append("\n"); 
		query.append("    , TOTL.TOT_OTS_CURR_CD4" ).append("\n"); 
		query.append("    , TOTL.TOT_OTS_AMT4" ).append("\n"); 
		query.append("    , TOTL.TOT_OTS_CURR_CD5" ).append("\n"); 
		query.append("    , TOTL.TOT_OTS_AMT5" ).append("\n"); 
		query.append("    , TOTL.TOT_OTS_STS_CD" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append(" SELECT MAX(DECODE(IS_LAST, 'PPT1-1', OFC_CURR_CD))										PPT_OTS_CURR_CD1" ).append("\n"); 
		query.append("        , DECODE(MAX(DECODE(IS_LAST, 'PPT1-1', DECODE(CR_FLG, 'Y', 'C'))), 'C', NULL" ).append("\n"); 
		query.append("               , TO_CHAR(MAX(DECODE(IS_LAST, 'PPT1-1', RCV_DT)), 'YYYY-MM-DD HH24:MI:SS')) PPT_RCV_DT" ).append("\n"); 
		query.append("         , MAX(DECODE(IS_LAST, 'PPT1-1', OFC_CD))										PPT_RCV_OFC_CD" ).append("\n"); 
		query.append("         , MAX(DECODE(IS_LAST, 'PPT1-1', CLT_RQST_USR_ID))								PPT_RCV_USR_ID" ).append("\n"); 
		query.append("         , NVL(MAX(DECODE(IS_LAST, 'PPT1-1', DECODE(CR_FLG, 'Y', 'C')))                 " ).append("\n"); 
		query.append("         , MAX(DECODE(IS_LAST, 'PPT1-1', OTS_STL_FLG)))									PPT_STS_CD" ).append("\n"); 
		query.append("         , MAX(DECODE(IS_LAST, 'CCT1-1', OFC_CURR_CD))									CCT_OTS_CURR_CD1 " ).append("\n"); 
		query.append("         , DECODE(MAX(DECODE(IS_LAST, 'CCT1-1', DECODE(CR_FLG, 'Y', 'C'))), 'C', NULL" ).append("\n"); 
		query.append("                 , TO_CHAR(MAX(DECODE(IS_LAST, 'CCT1-1', RCV_DT)), 'YYYY-MM-DD HH24:MI:SS')) CCT_RCV_DT       " ).append("\n"); 
		query.append("         , MAX(DECODE(IS_LAST, 'CCT1-1', OFC_CD))										CCT_RCV_OFC_CD   " ).append("\n"); 
		query.append("         , MAX(DECODE(IS_LAST, 'CCT1-1', CLT_RQST_USR_ID))								CCT_RCV_USR_ID   " ).append("\n"); 
		query.append("         , NVL(MAX(DECODE(IS_LAST, 'CCT1-1', DECODE(CR_FLG, 'Y', 'C')))               " ).append("\n"); 
		query.append("         , MAX(DECODE(IS_LAST, 'CCT1-1', OTS_STL_FLG)))									CCT_STS_CD      " ).append("\n"); 
		query.append("         , MAX(DECODE(IS_LAST, 'PPT3-1', OFC_CURR_CD))									N3PTY_PPT_OTS_CURR_CD1 " ).append("\n"); 
		query.append("         , DECODE(MAX(DECODE(IS_LAST, 'PPT3-1', DECODE(CR_FLG, 'Y', 'C'))), 'C', NULL" ).append("\n"); 
		query.append("                  , TO_CHAR(MAX(DECODE(IS_LAST, 'PPT3-1', RCV_DT)), 'YYYY-MM-DD HH24:MI:SS')) N3PTY_PPT_RCV_DT       " ).append("\n"); 
		query.append("         , MAX(DECODE(IS_LAST, 'PPT3-1', OFC_CD))										N3PTY_PPT_RCV_OFC_CD   " ).append("\n"); 
		query.append("         , MAX(DECODE(IS_LAST, 'PPT3-1', CLT_RQST_USR_ID))								N3PTY_PPT_RCV_USR_ID   " ).append("\n"); 
		query.append("         , NVL(MAX(DECODE(IS_LAST, 'PPT3-1', DECODE(CR_FLG, 'Y', 'C')))                 " ).append("\n"); 
		query.append("         , MAX(DECODE(IS_LAST, 'PPT3-1', OTS_STL_FLG)))									N3PTY_PPT_STS_CD       " ).append("\n"); 
		query.append("         , MAX(DECODE(IS_LAST, 'CCT3-1', OFC_CURR_CD))									N3PTY_CCT_OTS_CURR_CD1 " ).append("\n"); 
		query.append("         , DECODE(MAX(DECODE(IS_LAST, 'CCT3-1', DECODE(CR_FLG, 'Y', 'C'))), 'C', NULL" ).append("\n"); 
		query.append("                 , TO_CHAR(MAX(DECODE(IS_LAST, 'CCT3-1', RCV_DT)), 'YYYY-MM-DD HH24:MI:SS')) N3PTY_CCT_RCV_DT       " ).append("\n"); 
		query.append("         , MAX(DECODE(IS_LAST, 'CCT3-1', OFC_CD))										N3PTY_CCT_RCV_OFC_CD   " ).append("\n"); 
		query.append("         , MAX(DECODE(IS_LAST, 'CCT3-1', CLT_RQST_USR_ID))								N3PTY_CCT_RCV_USR_ID   " ).append("\n"); 
		query.append("         , NVL(MAX(DECODE(IS_LAST, 'CCT3-1', DECODE(CR_FLG, 'Y', 'C')))" ).append("\n"); 
		query.append("         , MAX(DECODE(IS_LAST, 'CCT3-1', OTS_STL_FLG)))									N3PTY_CCT_STS_CD       " ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("		  SELECT Q.TP" ).append("\n"); 
		query.append("                 , P.CLT_OFC_CD OFC_CD" ).append("\n"); 
		query.append("                 , P.OFC_CURR_CD" ).append("\n"); 
		query.append("                 , P.CR_MK_FLG CR_FLG" ).append("\n"); 
		query.append("                 , Q.OTS_STL_FLG" ).append("\n"); 
		query.append("                 , P.UPD_USR_ID CLT_RQST_USR_ID" ).append("\n"); 
		query.append("                 , (SELECT MAX(BAL_UPD_DT)" ).append("\n"); 
		query.append("                      FROM SAR_OTS_DTL" ).append("\n"); 
		query.append("                     WHERE RHQ_CD = P.RHQ_CD" ).append("\n"); 
		query.append("                       AND OTS_OFC_CD = P.OTS_OFC_CD" ).append("\n"); 
		query.append("                       AND BL_NO = P.BL_NO" ).append("\n"); 
		query.append("                       AND INV_NO = P.INV_NO) RCV_DT" ).append("\n"); 
		query.append("                 , Q.TP||'-1' IS_LAST" ).append("\n"); 
		query.append("            FROM SAR_OTS_HDR P,      " ).append("\n"); 
		query.append("                (SELECT  TP" ).append("\n"); 
		query.append("                        , MIN( NVL((SELECT 'N'" ).append("\n"); 
		query.append("                                      FROM SAR_OTS_DTL" ).append("\n"); 
		query.append("                                     WHERE RHQ_CD = A.RHQ_CD" ).append("\n"); 
		query.append("                                       AND OTS_OFC_CD = A.OTS_OFC_CD" ).append("\n"); 
		query.append("                                       AND BL_NO = A.BL_NO" ).append("\n"); 
		query.append("                                       AND INV_NO = A.INV_NO" ).append("\n"); 
		query.append("                                       AND NVL(BAL_AMT, 0) > 0" ).append("\n"); 
		query.append("                                       AND ROWNUM = 1), 'Y') ) OTS_STL_FLG" ).append("\n"); 
		query.append("                        , RHQ_CD" ).append("\n"); 
		query.append("						, OTS_OFC_CD" ).append("\n"); 
		query.append("						, BL_NO" ).append("\n"); 
		query.append("                 FROM SAR_OTS_HDR A, " ).append("\n"); 
		query.append("                     (SELECT BKG_NO, 'PPT1' TP," ).append("\n"); 
		query.append("                            (SELECT AR_OFC_CD FROM MDM_ORGANIZATION WHERE OFC_CD = PPD_RCV_OFC_CD) OFC_CD" ).append("\n"); 
		query.append("                      FROM BKG_RATE" ).append("\n"); 
		query.append("                      WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                      UNION ALL" ).append("\n"); 
		query.append("                      SELECT BKG_NO, 'CCT1' TP," ).append("\n"); 
		query.append("                            (SELECT AR_OFC_CD FROM MDM_ORGANIZATION WHERE OFC_CD = CLT_OFC_CD) OFC_CD" ).append("\n"); 
		query.append("                      FROM BKG_RATE" ).append("\n"); 
		query.append("                      WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                      UNION ALL" ).append("\n"); 
		query.append("                      SELECT distinct BKG_NO, DECODE(FRT_TERM_CD, 'P', 'PPT3', 'CCT3') TP," ).append("\n"); 
		query.append("                            (SELECT AR_OFC_CD FROM MDM_ORGANIZATION WHERE OFC_CD = N3PTY_RCV_OFC_CD) OFC_CD" ).append("\n"); 
		query.append("                      FROM BKG_CHG_RT" ).append("\n"); 
		query.append("                      WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                      AND N3PTY_RCV_OFC_CD is not null) B" ).append("\n"); 
		query.append("                 WHERE A.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                 AND A.CLT_OFC_CD = B.OFC_CD" ).append("\n"); 
		query.append("                 AND A.BKG_NO= B.BKG_NO" ).append("\n"); 
		query.append("                 AND EXISTS (SELECT 'X' " ).append("\n"); 
		query.append("                             FROM SAR_OTS_DTL" ).append("\n"); 
		query.append("                             WHERE RHQ_CD = A.RHQ_CD" ).append("\n"); 
		query.append("                             AND OTS_OFC_CD = A.OTS_OFC_CD" ).append("\n"); 
		query.append("                             AND BL_NO = A.BL_NO" ).append("\n"); 
		query.append("                             AND INV_NO = A.INV_NO" ).append("\n"); 
		query.append("                             AND INV_AMT <> 0)" ).append("\n"); 
		query.append("                 GROUP BY TP" ).append("\n"); 
		query.append("                          , RHQ_CD, OTS_OFC_CD, BL_NO" ).append("\n"); 
		query.append("                 ) Q     " ).append("\n"); 
		query.append("             WHERE P.RHQ_CD = Q.RHQ_CD" ).append("\n"); 
		query.append("             AND P.OTS_OFC_CD = Q.OTS_OFC_CD" ).append("\n"); 
		query.append("             AND P.BL_NO = Q.BL_NO" ).append("\n"); 
		query.append("             AND P.INV_NO = '**********'" ).append("\n"); 
		query.append("             AND P.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("             )) SPLT, " ).append("\n"); 
		query.append("    (SELECT MAX(DECODE(ODR, 1, NVL(TOT_OTS_CURR_CD, OFC_CURR_CD))) TOT_OTS_CURR_CD1" ).append("\n"); 
		query.append("         , SUM(DECODE(ODR, 1, DECODE(CLR_FLG, 'N', TOT_OTS_AMT, 0))) TOT_OTS_AMT1" ).append("\n"); 
		query.append("         , DECODE(SUM(DECODE(ODR, 2, DECODE(CLR_FLG, 'N', TOT_OTS_AMT, 0))), 0, NULL, MAX(DECODE(ODR, 2, NVL(TOT_OTS_CURR_CD, OFC_CURR_CD)))) TOT_OTS_CURR_CD2" ).append("\n"); 
		query.append("         , DECODE(SUM(DECODE(ODR, 2, DECODE(CLR_FLG, 'N', TOT_OTS_AMT, 0))), 0, NULL, SUM(DECODE(ODR, 2, DECODE(CLR_FLG, 'N', TOT_OTS_AMT, 0)))) TOT_OTS_AMT2" ).append("\n"); 
		query.append("         , DECODE(SUM(DECODE(ODR, 3, DECODE(CLR_FLG, 'N', TOT_OTS_AMT, 0))), 0, NULL, MAX(DECODE(ODR, 3, NVL(TOT_OTS_CURR_CD, OFC_CURR_CD)))) TOT_OTS_CURR_CD3" ).append("\n"); 
		query.append("         , DECODE(SUM(DECODE(ODR, 3, DECODE(CLR_FLG, 'N', TOT_OTS_AMT, 0))), 0, NULL, SUM(DECODE(ODR, 3, DECODE(CLR_FLG, 'N', TOT_OTS_AMT, 0)))) TOT_OTS_AMT3" ).append("\n"); 
		query.append("         , DECODE(SUM(DECODE(ODR, 4, DECODE(CLR_FLG, 'N', TOT_OTS_AMT, 0))), 0, NULL, MAX(DECODE(ODR, 4, NVL(TOT_OTS_CURR_CD, OFC_CURR_CD)))) TOT_OTS_CURR_CD4" ).append("\n"); 
		query.append("         , DECODE(SUM(DECODE(ODR, 4, DECODE(CLR_FLG, 'N', TOT_OTS_AMT, 0))), 0, NULL, SUM(DECODE(ODR, 4, DECODE(CLR_FLG, 'N', TOT_OTS_AMT, 0)))) TOT_OTS_AMT4" ).append("\n"); 
		query.append("         , DECODE(SUM(DECODE(ODR, 5, DECODE(CLR_FLG, 'N', TOT_OTS_AMT, 0))), 0, NULL, MAX(DECODE(ODR, 5, NVL(TOT_OTS_CURR_CD, OFC_CURR_CD)))) TOT_OTS_CURR_CD5" ).append("\n"); 
		query.append("         , DECODE(SUM(DECODE(ODR, 5, DECODE(CLR_FLG, 'N', TOT_OTS_AMT, 0))), 0, NULL, SUM(DECODE(ODR, 5, DECODE(CLR_FLG, 'N', TOT_OTS_AMT, 0)))) TOT_OTS_AMT5" ).append("\n"); 
		query.append("         , MIN(CLR_FLG) TOT_OTS_STS_CD" ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("        select a.OFC_CURR_CD" ).append("\n"); 
		query.append("             , b.BL_CURR_CD tot_ots_curr_cd" ).append("\n"); 
		query.append("             , nvl(b.BAL_AMT,0) tot_ots_amt" ).append("\n"); 
		query.append("             , DECODE(a.CR_MK_FLG, 'Y', 'C', " ).append("\n"); 
		query.append("                       NVL((SELECT 'N'" ).append("\n"); 
		query.append("                              FROM SAR_OTS_DTL" ).append("\n"); 
		query.append("                              WHERE RHQ_CD = A.RHQ_CD" ).append("\n"); 
		query.append("                              AND OTS_OFC_CD = A.OTS_OFC_CD" ).append("\n"); 
		query.append("                              AND BL_NO = A.BL_NO" ).append("\n"); 
		query.append("                              AND INV_NO = A.INV_NO" ).append("\n"); 
		query.append("                              AND NVL(BAL_AMT, 0) > 0" ).append("\n"); 
		query.append("                              AND ROWNUM = 1), 'Y')) CLR_FLG " ).append("\n"); 
		query.append("             , BKG_IO_BND_CD" ).append("\n"); 
		query.append("             , MAX(DECODE(BKG_IO_BND_CD, 'I', a.OFC_CURR_CD)) OVER() DFLT_CURR_CD" ).append("\n"); 
		query.append("             , DENSE_RANK() OVER (ORDER BY BKG_IO_BND_CD, b.BL_CURR_CD ) ODR" ).append("\n"); 
		query.append("        FROM SAR_OTS_HDR A" ).append("\n"); 
		query.append("            , SAR_OTS_DTL B" ).append("\n"); 
		query.append("        WHERE A.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("          AND A.OTS_OFC_CD  = B.OTS_OFC_CD" ).append("\n"); 
		query.append("          AND A.BL_NO = B.BL_NO" ).append("\n"); 
		query.append("          AND A.INV_NO = B.INV_NO" ).append("\n"); 
		query.append("          AND A.BKG_IO_BND_CD = 'I'" ).append("\n"); 
		query.append("         )" ).append("\n"); 
		query.append("     ) TOTL" ).append("\n"); 

	}
}