/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : OwnContainerBookingForecastMgtDBDAOCBFIFSummaryDiffListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.08
*@LastModifier : 
*@LastVersion : 1.0
* 2016.01.08 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OwnContainerBookingForecastMgtDBDAOCBFIFSummaryDiffListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CLL 과 BKG 정보의 DIFF LIST
	  * </pre>
	  */
	public OwnContainerBookingForecastMgtDBDAOCBFIFSummaryDiffListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("pol_clpt_ind_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.integration").append("\n"); 
		query.append("FileName : OwnContainerBookingForecastMgtDBDAOCBFIFSummaryDiffListRSQL").append("\n"); 
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
		query.append("SELECT SEQ, MIN(CNTR_NO) AS CNTR_NO ,            MIN(BKG_NO) AS BKG_NO,  " ).append("\n"); 
		query.append("            MIN(POD_CD) AS POD_CD,               MIN(BLCK_STWG_CD) AS BLCK_STWG_CD," ).append("\n"); 
		query.append("            MIN(CNTR_TPSZ_CD) AS CNTR_TPSZ_CD , " ).append("\n"); 
		query.append("            MIN(MTY_BKG_CD) AS MTY_BKG_CD,       MIN(DG_FLG) AS DG_FLG, " ).append("\n"); 
		query.append("            MIN(AWK_FLG) AS AWK_FLG,             MIN(BB_FLG) AS BB_FLG, " ).append("\n"); 
		query.append("            MIN(BN_FLG) AS BN_FLG,               MIN(CNTR_NO2) AS CNTR_NO2, " ).append("\n"); 
		query.append("            MIN(BKG_NO2) AS BKG_NO2,             MIN(POD_CD2) AS POD_CD2, " ).append("\n"); 
		query.append("            MIN(BLCK_STWG_CD2) AS BLCK_STWG_CD2," ).append("\n"); 
		query.append("            MIN(CNTR_TPSZ_CD2) AS CNTR_TPSZ_CD2, MIN(MTY_BKG_CD2) AS MTY_BKG_CD2," ).append("\n"); 
		query.append("            MIN(DG_FLG2) AS DG_FLG2,             MIN(AWK_FLG2) AS AWK_FLG2, " ).append("\n"); 
		query.append("            MIN(BB_FLG2) AS BB_FLG2,             MIN(BN_FLG2) AS BN_FLG2" ).append("\n"); 
		query.append(" FROM (" ).append("\n"); 
		query.append("       SELECT ROWNUM AS SEQ,B.CNTR_NO, B.BKG_NO, B.POD_CD, OPF_BLCK_STWG_CD(@[vvd],@[yd_cd],@[pol_clpt_ind_seq],B.BKG_NO) BLCK_STWG_CD," ).append("\n"); 
		query.append("              B.CNTR_TPSZ_CD,  B.MTY_BKG_CD," ).append("\n"); 
		query.append("              CASE WHEN  ( SELECT COUNT(1)" ).append("\n"); 
		query.append("                             FROM BKG_DG_CGO" ).append("\n"); 
		query.append("                            WHERE BKG_NO  = B.BKG_NO" ).append("\n"); 
		query.append("                              AND CNTR_NO = B.CNTR_NO ) = 0 THEN NULL " ).append("\n"); 
		query.append("                   ELSE 'Y'  END AS DG_FLG," ).append("\n"); 
		query.append("              CASE WHEN  ( SELECT COUNT(1)" ).append("\n"); 
		query.append("                             FROM BKG_AWK_CGO" ).append("\n"); 
		query.append("                            WHERE BKG_NO  = B.BKG_NO" ).append("\n"); 
		query.append("                              AND CNTR_NO = B.CNTR_NO ) = 0 THEN NULL" ).append("\n"); 
		query.append("                   ELSE 'Y' END AS AWK_FLG," ).append("\n"); 
		query.append("              CASE WHEN  ( SELECT COUNT(1)" ).append("\n"); 
		query.append("                             FROM BKG_QTY_DTL" ).append("\n"); 
		query.append("                            WHERE BKG_NO     = B.BKG_NO" ).append("\n"); 
		query.append("                              AND BB_CGO_FLG = 'Y') = 0 THEN NULL" ).append("\n"); 
		query.append("                   ELSE 'Y' END AS BB_FLG  ," ).append("\n"); 
		query.append("              CASE WHEN  ( SELECT COUNT(1)" ).append("\n"); 
		query.append("                             FROM BKG_CONTAINER" ).append("\n"); 
		query.append("                            WHERE BKG_NO      = B.BKG_NO" ).append("\n"); 
		query.append("                              AND BDL_BTM_FLG ='Y' ) = 0 THEN NULL" ).append("\n"); 
		query.append("              ELSE 'Y'  END AS BN_FLG ," ).append("\n"); 
		query.append("              NULL AS CNTR_NO2,     NULL AS BKG_NO2, NULL AS POD_CD2,  NULL AS BLCK_STWG_CD2," ).append("\n"); 
		query.append("              NULL AS CNTR_TPSZ_CD2,NULL AS MTY_BKG_CD2, NULL AS DG_FLG2, NULL AS AWK_FLG2, " ).append("\n"); 
		query.append("              NULL AS BB_FLG2,      NULL AS BN_FLG2     " ).append("\n"); 
		query.append("       FROM (" ).append("\n"); 
		query.append("               SELECT DISTINCT CNTR_NO  " ).append("\n"); 
		query.append("                 FROM BKG_CSTMS_TML_KR_CLL" ).append("\n"); 
		query.append("                WHERE VSL_CD                          = substr(@[vvd],1,4)" ).append("\n"); 
		query.append("                  AND SKD_VOY_NO                      = substr(@[vvd],5,4)" ).append("\n"); 
		query.append("                  AND SKD_DIR_CD                      = substr(@[vvd],9,1)" ).append("\n"); 
		query.append("                  AND POL_CD                          = substr(@[yd_cd],1,5)" ).append("\n"); 
		query.append("                  AND POL_YD_CD                       = substr(@[yd_cd],6,2)" ).append("\n"); 
		query.append("                MINUS" ).append("\n"); 
		query.append("                SELECT DISTINCT BCT.CNTR_NO" ).append("\n"); 
		query.append("                  FROM BKG_VVD       VVD, " ).append("\n"); 
		query.append("                       BKG_BOOKING   BKG," ).append("\n"); 
		query.append("                       BKG_CONTAINER BCT" ).append("\n"); 
		query.append("                 WHERE VVD.VSL_CD                          = substr(@[vvd],1,4)" ).append("\n"); 
		query.append("                   AND VVD.SKD_VOY_NO                      = substr(@[vvd],5,4)" ).append("\n"); 
		query.append("                   AND VVD.SKD_DIR_CD                      = substr(@[vvd],9,1)" ).append("\n"); 
		query.append("                   AND VVD.POL_YD_CD||VVD.POL_CLPT_IND_SEQ = @[yd_cd]||@[pol_clpt_ind_seq]      " ).append("\n"); 
		query.append("                   AND VVD.BKG_NO                          = BKG.BKG_NO" ).append("\n"); 
		query.append("                   AND BKG.BKG_STS_CD                      <> 'X'" ).append("\n"); 
		query.append("                   AND BKG.BKG_NO                          = BCT.BKG_NO ) A, BKG_CSTMS_TML_KR_CLL B" ).append("\n"); 
		query.append("       WHERE  B.VSL_CD                          = substr(@[vvd],1,4)" ).append("\n"); 
		query.append("         AND B.SKD_VOY_NO                       = substr(@[vvd],5,4)" ).append("\n"); 
		query.append("         AND B.SKD_DIR_CD                       = substr(@[vvd],9,1)" ).append("\n"); 
		query.append("         AND B.POL_CD                           = substr(@[yd_cd],1,5)" ).append("\n"); 
		query.append("         AND B.POL_YD_CD                        = substr(@[yd_cd],6,2)" ).append("\n"); 
		query.append("         AND A.CNTR_NO                          = B.CNTR_NO" ).append("\n"); 
		query.append("   UNION ALL" ).append("\n"); 
		query.append("    SELECT ROWNUM    AS SEQ,         NULL     AS CNTR_NO,     NULL     AS BKG_NO,  NULL    AS POD_CD, NULL AS BLCK_STWG_CD, " ).append("\n"); 
		query.append("           NULL      AS CNTR_TPSZ_CD,NULL     AS MTY_BKG_CD,  NULL     AS DG_FLG,  NULL    AS AWK_FLG, " ).append("\n"); 
		query.append("           NULL      AS BB_FLG,      NULL     AS BN_FLG,     " ).append("\n"); 
		query.append("           A.CNTR_NO AS CNTR_NO2,    C.BKG_NO AS BKG_NO2,    C.POD_CD AS POD_CD2,  " ).append("\n"); 
		query.append("           OPF_BLCK_STWG_CD(@[vvd],@[yd_cd],@[pol_clpt_ind_seq],C.BKG_NO) BLCK_STWG_CD2," ).append("\n"); 
		query.append("           D.CNTR_TPSZ_CD   AS CNTR_TPSZ_CD2, " ).append("\n"); 
		query.append("           C.BKG_CGO_TP_CD  AS MTY_BKG_CD2," ).append("\n"); 
		query.append("           CASE WHEN  ( SELECT COUNT(1)" ).append("\n"); 
		query.append("                          FROM BKG_DG_CGO" ).append("\n"); 
		query.append("                         WHERE BKG_NO  = C.BKG_NO" ).append("\n"); 
		query.append("                           AND CNTR_NO = A.CNTR_NO ) = 0 THEN NULL" ).append("\n"); 
		query.append("                ELSE 'Y'  END AS DG_FLG2," ).append("\n"); 
		query.append("           CASE WHEN  ( SELECT COUNT(1)" ).append("\n"); 
		query.append("                          FROM BKG_AWK_CGO" ).append("\n"); 
		query.append("                         WHERE BKG_NO  = C.BKG_NO" ).append("\n"); 
		query.append("                           AND CNTR_NO = A.CNTR_NO ) = 0 THEN NULL" ).append("\n"); 
		query.append("                ELSE 'Y'  END AS AWK_FLG2," ).append("\n"); 
		query.append("           CASE WHEN  ( SELECT COUNT(1)" ).append("\n"); 
		query.append("                          FROM BKG_QTY_DTL" ).append("\n"); 
		query.append("                         WHERE BKG_NO     = C.BKG_NO" ).append("\n"); 
		query.append("                           AND BB_CGO_FLG = 'Y') = 0 THEN NULL" ).append("\n"); 
		query.append("                ELSE 'Y'  END AS BB_FLG2  ," ).append("\n"); 
		query.append("           CASE WHEN  ( SELECT COUNT(1)" ).append("\n"); 
		query.append("                          FROM BKG_CONTAINER" ).append("\n"); 
		query.append("                         WHERE BKG_NO = C.BKG_NO" ).append("\n"); 
		query.append("                           AND BDL_BTM_FLG ='Y' ) = 0 THEN NULL" ).append("\n"); 
		query.append("                ELSE 'Y'  END AS BN_FLG2 " ).append("\n"); 
		query.append("      FROM (" ).append("\n"); 
		query.append("            SELECT DISTINCT BCT.CNTR_NO" ).append("\n"); 
		query.append("              FROM BKG_VVD       VVD, " ).append("\n"); 
		query.append("                   BKG_BOOKING   BKG," ).append("\n"); 
		query.append("                   BKG_CONTAINER BCT" ).append("\n"); 
		query.append("             WHERE VVD.VSL_CD                          = substr(@[vvd],1,4)" ).append("\n"); 
		query.append("               AND VVD.SKD_VOY_NO                      = substr(@[vvd],5,4)" ).append("\n"); 
		query.append("               AND VVD.SKD_DIR_CD                      = substr(@[vvd],9,1)" ).append("\n"); 
		query.append("               AND VVD.POL_YD_CD||VVD.POL_CLPT_IND_SEQ = @[yd_cd]||@[pol_clpt_ind_seq]       " ).append("\n"); 
		query.append("               AND VVD.BKG_NO                          = BKG.BKG_NO" ).append("\n"); 
		query.append("               AND BKG.BKG_STS_CD                      <> 'X'" ).append("\n"); 
		query.append("               AND BKG.BKG_NO                          = BCT.BKG_NO " ).append("\n"); 
		query.append("            MINUS" ).append("\n"); 
		query.append("            SELECT DISTINCT CNTR_NO  " ).append("\n"); 
		query.append("              FROM BKG_CSTMS_TML_KR_CLL" ).append("\n"); 
		query.append("             WHERE VSL_CD                          = substr(@[vvd],1,4)" ).append("\n"); 
		query.append("               AND SKD_VOY_NO                      = substr(@[vvd],5,4)" ).append("\n"); 
		query.append("               AND SKD_DIR_CD                      = substr(@[vvd],9,1)" ).append("\n"); 
		query.append("               AND POL_CD                          = substr(@[yd_cd],1,5)" ).append("\n"); 
		query.append("               AND POL_YD_CD = substr(@[yd_cd],6,2) ) A, BKG_VVD B, BKG_BOOKING C, BKG_CONTAINER D" ).append("\n"); 
		query.append("      WHERE B.VSL_CD                          = substr(@[vvd],1,4)" ).append("\n"); 
		query.append("        AND B.SKD_VOY_NO                      = substr(@[vvd],5,4)" ).append("\n"); 
		query.append("        AND B.SKD_DIR_CD                      = substr(@[vvd],9,1)" ).append("\n"); 
		query.append("        AND B.POL_CD                          = substr(@[yd_cd],1,5)" ).append("\n"); 
		query.append("        AND B.BKG_NO = C.BKG_NO" ).append("\n"); 
		query.append("        AND C.BKG_NO = D.BKG_NO" ).append("\n"); 
		query.append("        AND D.CNTR_NO = A.CNTR_NO ) " ).append("\n"); 
		query.append("  GROUP BY SEQ" ).append("\n"); 
		query.append("  ORDER BY SEQ" ).append("\n"); 

	}
}