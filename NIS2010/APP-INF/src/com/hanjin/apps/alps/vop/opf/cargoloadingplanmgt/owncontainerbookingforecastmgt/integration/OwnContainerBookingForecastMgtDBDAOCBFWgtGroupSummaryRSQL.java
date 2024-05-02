/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : OwnContainerBookingForecastMgtDBDAOCBFWgtGroupSummaryRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.01
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.01 
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

public class OwnContainerBookingForecastMgtDBDAOCBFWgtGroupSummaryRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CBF의 WEIGHT GROUP SUMMARY 데이터 조회
	  * </pre>
	  */
	public OwnContainerBookingForecastMgtDBDAOCBFWgtGroupSummaryRSQL(){
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
		params.put("blck_stwg_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("crr_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.integration").append("\n"); 
		query.append("FileName : OwnContainerBookingForecastMgtDBDAOCBFWgtGroupSummaryRSQL").append("\n"); 
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
		query.append("WITH WGP_SUMMARY AS (" ).append("\n"); 
		query.append(" SELECT A.CNTR_SZ_CD," ).append("\n"); 
		query.append("        A.FULL_MTY_CD ,             A.CNTR_WGT_GRP_CD , SUM(A.CNTR_QTY) AS QTY , " ).append("\n"); 
		query.append("        SUM(A.CNTR_GRS_WGT) AS WGT, SUM(A.CNTR_GRS_WGT)/SUM(A.CNTR_QTY) AS AVG_WGT" ).append("\n"); 
		query.append("   FROM OPF_CGO_BKG_FCAST_WGT_GRP_SMRY A" ).append("\n"); 
		query.append("  WHERE A.VSL_CD           =  substr(@[vvd],1,4)" ).append("\n"); 
		query.append("    AND A.SKD_VOY_NO       =  substr(@[vvd],5,4)" ).append("\n"); 
		query.append("    AND A.SKD_DIR_CD       =  substr(@[vvd],9,1)" ).append("\n"); 
		query.append("    AND A.YD_CD||A.POL_CLPT_IND_SEQ   = @[yd_cd]" ).append("\n"); 
		query.append("    AND A.CRR_CD           = @[crr_cd]" ).append("\n"); 
		query.append("    AND A.POD_CD           = @[pod_cd]" ).append("\n"); 
		query.append("    AND A.BLCK_STWG_CD     = @[blck_stwg_cd]" ).append("\n"); 
		query.append("    AND A.FULL_MTY_CD      = 'F'" ).append("\n"); 
		query.append("  GROUP BY  A.CNTR_SZ_CD , A.FULL_MTY_CD , A.CNTR_WGT_GRP_CD  ) ," ).append("\n"); 
		query.append("WGT_MTY_GRP AS ( SELECT  SUM(DECODE(CNTR_SZ_CD,'2',CNTR_QTY)) AS QTY1," ).append("\n"); 
		query.append("                         SUM(DECODE(CNTR_SZ_CD,'4',CNTR_QTY)) AS QTY2," ).append("\n"); 
		query.append("                         SUM(DECODE(CNTR_SZ_CD,'5',CNTR_QTY)) AS QTY3," ).append("\n"); 
		query.append("                         SUM(DECODE(CNTR_SZ_CD,'6',CNTR_QTY)) AS QTY4 " ).append("\n"); 
		query.append("                    FROM OPF_CGO_BKG_FCAST_WGT_GRP_SMRY A" ).append("\n"); 
		query.append("                   WHERE A.VSL_CD      = substr(@[vvd],1,4)" ).append("\n"); 
		query.append("                     AND A.SKD_VOY_NO  = substr(@[vvd],5,4)" ).append("\n"); 
		query.append("                     AND A.SKD_DIR_CD  = substr(@[vvd],9,1)" ).append("\n"); 
		query.append("                     AND A.YD_CD||A.POL_CLPT_IND_SEQ  = @[yd_cd]" ).append("\n"); 
		query.append("                     AND A.CRR_CD      = @[crr_cd]" ).append("\n"); 
		query.append("                     AND A.POD_CD      = @[pod_cd]" ).append("\n"); 
		query.append("                     AND A.BLCK_STWG_CD =@[blck_stwg_cd]" ).append("\n"); 
		query.append("                     AND A.FULL_MTY_CD  ='E')," ).append("\n"); 
		query.append("WGT_GRP AS (  SELECT  1 AS SEQ, 'X' AS WGT_GRP_CD, 'Extra Heavy' AS NM FROM DUAL" ).append("\n"); 
		query.append("              UNION ALL" ).append("\n"); 
		query.append("              SELECT 2 AS SEQ,  'H' AS WGT_GRP_CD, 'Heavy' AS NM FROM DUAL" ).append("\n"); 
		query.append("              UNION ALL" ).append("\n"); 
		query.append("              SELECT 3 AS SEQ,  'M' AS WGT_GRP_CD, 'Medium' AS NM FROM DUAL" ).append("\n"); 
		query.append("              UNION ALL" ).append("\n"); 
		query.append("              SELECT 4 AS SEQ,  'L' AS WGT_GRP_CD, 'Light' AS NM FROM DUAL" ).append("\n"); 
		query.append("              UNION ALL" ).append("\n"); 
		query.append("              SELECT 5 AS SEQ,  'E' AS WGT_GRP_CD, 'Ultra Light' AS NM FROM DUAL )," ).append("\n"); 
		query.append("AVG_SUMMARY AS " ).append("\n"); 
		query.append("  (SELECT MAX(DECODE(Y.CNTR_SZ_CD,2, ROUND(WGT/QTY,2))) wgt_2," ).append("\n"); 
		query.append("          MAX(DECODE(Y.CNTR_SZ_CD,4, ROUND(WGT/QTY,2))) wgt_4," ).append("\n"); 
		query.append("          MAX(DECODE(Y.CNTR_SZ_CD,5, ROUND(WGT/QTY,2))) wgt_4h," ).append("\n"); 
		query.append("          MAX(DECODE(Y.CNTR_SZ_CD,6, ROUND(WGT/QTY,2))) wgt_5" ).append("\n"); 
		query.append("     FROM ( SELECT  X.CNTR_SZ_CD, SUM(QTY) AS QTY , SUM(X.WGT) AS WGT" ).append("\n"); 
		query.append("              FROM (  SELECT CNTR_SZ_CD," ).append("\n"); 
		query.append("                             A.FULL_MTY_CD , A.CNTR_WGT_GRP_CD , SUM(A.CNTR_QTY) AS QTY , " ).append("\n"); 
		query.append("                             SUM(A.CNTR_GRS_WGT*A.CNTR_QTY) AS WGT" ).append("\n"); 
		query.append("                        FROM OPF_CGO_BKG_FCAST_WGT_GRP_SMRY A" ).append("\n"); 
		query.append("                       WHERE A.VSL_CD           =  substr(@[vvd],1,4)" ).append("\n"); 
		query.append("                         AND A.SKD_VOY_NO       =  substr(@[vvd],5,4)" ).append("\n"); 
		query.append("                         AND A.SKD_DIR_CD       =  substr(@[vvd],9,1)" ).append("\n"); 
		query.append("                         AND A.YD_CD||A.POL_CLPT_IND_SEQ   = @[yd_cd]" ).append("\n"); 
		query.append("                         AND A.CRR_CD           = @[crr_cd]" ).append("\n"); 
		query.append("                         AND A.POD_CD           = @[pod_cd]" ).append("\n"); 
		query.append("                         AND A.BLCK_STWG_CD     = @[blck_stwg_cd]" ).append("\n"); 
		query.append("                         AND A.FULL_MTY_CD      = 'F'" ).append("\n"); 
		query.append("              GROUP BY  CNTR_SZ_CD , A.FULL_MTY_CD , A.CNTR_WGT_GRP_CD ) X" ).append("\n"); 
		query.append("  GROUP BY X.CNTR_SZ_CD ) Y )," ).append("\n"); 
		query.append("WGP_QTY AS " ).append("\n"); 
		query.append(" ( SELECT SUM(DECODE(CNTR_SZ_CD,'2',CNTR_QTY)) AS WGT_2," ).append("\n"); 
		query.append("          SUM(DECODE(CNTR_SZ_CD,'4',CNTR_QTY)) AS WGT_4," ).append("\n"); 
		query.append("          SUM(DECODE(CNTR_SZ_CD,'5',CNTR_QTY)) AS WGT_4H," ).append("\n"); 
		query.append("          SUM(DECODE(CNTR_SZ_CD,'6',CNTR_QTY)) AS WGT_5" ).append("\n"); 
		query.append("      FROM OPF_CGO_BKG_FCAST_WGT_GRP_SMRY A" ).append("\n"); 
		query.append("     WHERE A.VSL_CD           =  substr(@[vvd],1,4)" ).append("\n"); 
		query.append("       AND A.SKD_VOY_NO       =  substr(@[vvd],5,4)" ).append("\n"); 
		query.append("       AND A.SKD_DIR_CD       =  substr(@[vvd],9,1)" ).append("\n"); 
		query.append("       AND A.YD_CD||A.POL_CLPT_IND_SEQ   = @[yd_cd]" ).append("\n"); 
		query.append("       AND A.CRR_CD           = @[crr_cd]" ).append("\n"); 
		query.append("       AND A.POD_CD           = @[pod_cd]" ).append("\n"); 
		query.append("       AND A.BLCK_STWG_CD     = @[blck_stwg_cd] ) " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT  @[vvd] AS vvd , @[yd_cd] AS yd_cd, @[crr_cd] AS crr_cd , @[pod_cd] AS pod_cd , @[blck_stwg_cd] AS blck_stwg_cd," ).append("\n"); 
		query.append("        ZZ.SEQ, ZZ.CNTR_WGT_GRP_CD, ZZ.NM,  ZZ.QTY1 AS f_20_qty, ZZ.QTY2 AS f_40_qty, ZZ.QTY3 AS f_40h_qty, ZZ.QTY4 AS f_45_qty" ).append("\n"); 
		query.append(" FROM (  SELECT SEQ, CNTR_WGT_GRP_CD, NM, SUM(QTY1) AS QTY1 , SUM(QTY2) AS QTY2 , SUM(QTY3) AS QTY3 , SUM(QTY4) AS QTY4" ).append("\n"); 
		query.append("           FROM ( SELECT  CNTR_SZ_CD , WGT_GRP_CD AS CNTR_WGT_GRP_CD, " ).append("\n"); 
		query.append("                          QTY AS QTY1,              NULL AS QTY2," ).append("\n"); 
		query.append("                          NULL AS QTY3,             NULL AS QTY4" ).append("\n"); 
		query.append("                    FROM  WGP_SUMMARY A, WGT_GRP B   " ).append("\n"); 
		query.append("                   WHERE  A.CNTR_SZ_CD(+)      = '2'" ).append("\n"); 
		query.append("                     AND  A.CNTR_WGT_GRP_CD(+) = B.WGT_GRP_CD" ).append("\n"); 
		query.append("                  UNION ALL" ).append("\n"); 
		query.append("                  SELECT CNTR_SZ_CD , WGT_GRP_CD AS CNTR_WGT_GRP_CD, NULL AS QTY1," ).append("\n"); 
		query.append("                         QTY AS QTY2,     NULL AS QTY3,        NULL AS QTY4" ).append("\n"); 
		query.append("                    FROM WGP_SUMMARY A, WGT_GRP B   " ).append("\n"); 
		query.append("                   WHERE A.CNTR_SZ_CD(+)      = '4'" ).append("\n"); 
		query.append("                     AND A.CNTR_WGT_GRP_CD(+) = B.WGT_GRP_CD" ).append("\n"); 
		query.append("                  UNION ALL" ).append("\n"); 
		query.append("                  SELECT CNTR_SZ_CD , WGT_GRP_CD AS CNTR_WGT_GRP_CD, NULL AS QTY1," ).append("\n"); 
		query.append("                         NULL AS QTY2,  QTY AS QTY3,          NULL AS QTY4" ).append("\n"); 
		query.append("                    FROM WGP_SUMMARY A, WGT_GRP B   " ).append("\n"); 
		query.append("                   WHERE A.CNTR_SZ_CD(+)     = '5'" ).append("\n"); 
		query.append("                     AND A.CNTR_WGT_GRP_CD(+) = B.WGT_GRP_CD" ).append("\n"); 
		query.append("                  UNION ALL" ).append("\n"); 
		query.append("                  SELECT CNTR_SZ_CD , WGT_GRP_CD AS CNTR_WGT_GRP_CD, NULL AS QTY1," ).append("\n"); 
		query.append("                         NULL AS QTY2,  NULL AS QTY3,        QTY AS QTY4" ).append("\n"); 
		query.append("                    FROM WGP_SUMMARY A, WGT_GRP B   " ).append("\n"); 
		query.append("                   WHERE A.CNTR_SZ_CD(+)      = '6'" ).append("\n"); 
		query.append("                     AND A.CNTR_WGT_GRP_CD(+) = B.WGT_GRP_CD ) X, WGT_GRP Y" ).append("\n"); 
		query.append("            WHERE X.CNTR_WGT_GRP_CD = Y.WGT_GRP_CD" ).append("\n"); 
		query.append("            GROUP BY SEQ, CNTR_WGT_GRP_CD, NM" ).append("\n"); 
		query.append("          UNION ALL" ).append("\n"); 
		query.append("           SELECT 6 AS SEQ, 'E' AS CNTR_WGT_GRP_CD ,'Empty' AS NM,  QTY1, QTY2, QTY3, QTY4 " ).append("\n"); 
		query.append("             FROM WGT_MTY_GRP" ).append("\n"); 
		query.append("          UNION ALL" ).append("\n"); 
		query.append("          SELECT 7 AS SEQ, 'W' AS CNTR_WGT_GRP_CD,'Total QTY' AS NM, WGT_2, WGT_4, WGT_4H, WGT_5" ).append("\n"); 
		query.append("             FROM WGP_QTY " ).append("\n"); 
		query.append("          UNION ALL" ).append("\n"); 
		query.append("           SELECT 8 AS SEQ, 'W' AS CNTR_WGT_GRP_CD,'Avg Weight(KGS)' AS NM, WGT_2, WGT_4, WGT_4H, WGT_5" ).append("\n"); 
		query.append("             FROM AVG_SUMMARY   ) ZZ" ).append("\n"); 
		query.append(" ORDER BY ZZ.SEQ" ).append("\n"); 

	}
}