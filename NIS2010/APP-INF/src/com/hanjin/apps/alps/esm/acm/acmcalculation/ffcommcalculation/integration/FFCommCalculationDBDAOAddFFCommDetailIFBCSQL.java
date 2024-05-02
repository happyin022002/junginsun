/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : FFCommCalculationDBDAOAddFFCommDetailIFBCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.26
*@LastModifier : 
*@LastVersion : 1.0
* 2012.06.26 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmcalculation.ffcommcalculation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class FFCommCalculationDBDAOAddFFCommDetailIFBCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * FFCommCalculationDBDAOAddFFCommDetailIFBCSQL
	  * </pre>
	  */
	public FFCommCalculationDBDAOAddFFCommDetailIFBCSQL(){
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
		params.put("new_ff_cmpn_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.acm.acmcalculation.ffcommcalculation.integration").append("\n"); 
		query.append("FileName : FFCommCalculationDBDAOAddFFCommDetailIFBCSQL").append("\n"); 
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
		query.append("INSERT" ).append("\n"); 
		query.append("  INTO ACM_FF_CMPN_DTL" ).append("\n"); 
		query.append("     (" ).append("\n"); 
		query.append("        BKG_NO" ).append("\n"); 
		query.append("        , BKG_FF_CNT_CD" ).append("\n"); 
		query.append("        , BKG_FF_SEQ" ).append("\n"); 
		query.append("        , FF_CMPN_SEQ" ).append("\n"); 
		query.append("        , CNTR_TPSZ_CD" ).append("\n"); 
		query.append("        , BKG_VOL_QTY" ).append("\n"); 
		query.append("        , IF_DTRB_AMT" ).append("\n"); 
		query.append("        , UPD_USR_ID" ).append("\n"); 
		query.append("        , UPD_DT" ).append("\n"); 
		query.append("        , CRE_USR_ID" ).append("\n"); 
		query.append("        , CRE_DT" ).append("\n"); 
		query.append("     )" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("       INS.BKG_NO                                           AS BKG_NO," ).append("\n"); 
		query.append("       INS.BKG_FF_CNT_CD                                    AS BKG_FF_CNT_CD," ).append("\n"); 
		query.append("       INS.BKG_FF_SEQ                                       AS BKG_FF_SEQ," ).append("\n"); 
		query.append("       INS.FF_CMPN_SEQ                                      AS FF_CMPN_SEQ," ).append("\n"); 
		query.append("       INS.CNTR_TPSZ_CD                                     AS CNTR_TPSZ_CD," ).append("\n"); 
		query.append("       INS.BKG_VOL_QTY                                      AS BKG_VOL_QTY," ).append("\n"); 
		query.append("  CASE" ).append("\n"); 
		query.append("  WHEN INS.MNUM = INS.RNUM" ).append("\n"); 
		query.append("  THEN " ).append("\n"); 
		query.append("       ROUND (INS.IF_AMT * INS.OFT_RATIO, 2)" ).append("\n"); 
		query.append("     +" ).append("\n"); 
		query.append("     (" ).append("\n"); 
		query.append("       INS.IF_AMT" ).append("\n"); 
		query.append("     - SUM (ROUND (INS.IF_AMT * INS.OFT_RATIO, 2))" ).append("\n"); 
		query.append("       OVER (ORDER BY INS.CNTR_TPSZ_CD)" ).append("\n"); 
		query.append("     )" ).append("\n"); 
		query.append("  ELSE" ).append("\n"); 
		query.append("       ROUND (INS.IF_AMT * INS.OFT_RATIO, 2)" ).append("\n"); 
		query.append("   END                                                      AS IF_DTRB_AMT," ).append("\n"); 
		query.append("       'FF System'                                          AS UPD_USR_ID," ).append("\n"); 
		query.append("       SYSDATE                                              AS UPD_DT," ).append("\n"); 
		query.append("       'FF System'                                          AS CRE_USR_ID," ).append("\n"); 
		query.append("       SYSDATE                                              AS CRE_DT" ).append("\n"); 
		query.append("  FROM" ).append("\n"); 
		query.append("     (" ).append("\n"); 
		query.append("           SELECT" ).append("\n"); 
		query.append("                  ROWNUM                                    AS RNUM," ).append("\n"); 
		query.append("                (" ).append("\n"); 
		query.append("                      SELECT" ).append("\n"); 
		query.append("                             COUNT (1)" ).append("\n"); 
		query.append("                        FROM (SELECT " ).append("\n"); 
		query.append("                         BKG.BKG_NO, " ).append("\n"); 
		query.append("                         QTY.CNTR_TPSZ_CD, " ).append("\n"); 
		query.append("                         SUM (QTY.OP_CNTR_QTY) AS BKG_VOL_QTY," ).append("\n"); 
		query.append("                         RATIO_TO_REPORT (0) OVER (PARTITION BY BKG.BKG_NO) OFT_RATIO" ).append("\n"); 
		query.append("                    FROM BKG_QUANTITY QTY, " ).append("\n"); 
		query.append("                         BKG_BL_DOC   DOC, " ).append("\n"); 
		query.append("                         BKG_BOOKING  BKG, " ).append("\n"); 
		query.append("                         BKG_BOOKING  BK2 " ).append("\n"); 
		query.append("                   WHERE QTY.BKG_NO              = DOC.BKG_NO " ).append("\n"); 
		query.append("                     AND QTY.CNTR_TPSZ_CD NOT LIKE 'Q%' " ).append("\n"); 
		query.append("                     AND BK2.BKG_NO              = DOC.BKG_NO " ).append("\n"); 
		query.append("                     AND BK2.BL_NO_TP          <>  '9' " ).append("\n"); 
		query.append("                     AND BK2.BKG_STS_CD        <>  'X' " ).append("\n"); 
		query.append("                     AND " ).append("\n"); 
		query.append("                       ( " ).append("\n"); 
		query.append("                         BKG.BKG_NO              = DOC.BKG_NO " ).append("\n"); 
		query.append("                      OR BKG.BL_NO               = DOC.MST_CVRD_BL_NO " ).append("\n"); 
		query.append("                       ) " ).append("\n"); 
		query.append("                     AND BKG.BKG_NO              = @[bkg_no]" ).append("\n"); 
		query.append("                GROUP BY BKG.BKG_NO, " ).append("\n"); 
		query.append("                         QTY.CNTR_TPSZ_CD ) RE2" ).append("\n"); 
		query.append("                       WHERE RE2.BKG_NO = REV.BKG_NO" ).append("\n"); 
		query.append("                )                                           AS MNUM," ).append("\n"); 
		query.append("                  REV.BKG_NO                                AS BKG_NO," ).append("\n"); 
		query.append("                  QTY.BKG_FF_CNT_CD                         AS BKG_FF_CNT_CD," ).append("\n"); 
		query.append("                  QTY.BKG_FF_SEQ                            AS BKG_FF_SEQ," ).append("\n"); 
		query.append("                  QTY.FF_CMPN_SEQ                           AS FF_CMPN_SEQ," ).append("\n"); 
		query.append("                  QTY.IF_AMT                                AS IF_AMT," ).append("\n"); 
		query.append("                  REV.CNTR_TPSZ_CD                          AS CNTR_TPSZ_CD," ).append("\n"); 
		query.append("                  REV.BKG_VOL_QTY                           AS BKG_VOL_QTY," ).append("\n"); 
		query.append("             CASE" ).append("\n"); 
		query.append("             WHEN QTY.TOT_QTY = 0" ).append("\n"); 
		query.append("               OR QTY.TOT_QTY IS NULL" ).append("\n"); 
		query.append("             THEN 0" ).append("\n"); 
		query.append("             ELSE" ).append("\n"); 
		query.append("                  CASE" ).append("\n"); 
		query.append("                  WHEN SUBSTR (REV.CNTR_TPSZ_CD, 2, 1) = '2' " ).append("\n"); 
		query.append("                  THEN REV.BKG_VOL_QTY" ).append("\n"); 
		query.append("                  ELSE REV.BKG_VOL_QTY * 2" ).append("\n"); 
		query.append("                   END / QTY.TOT_QTY" ).append("\n"); 
		query.append("              END                                           AS OFT_RATIO              " ).append("\n"); 
		query.append("             FROM (SELECT " ).append("\n"); 
		query.append("                         BKG.BKG_NO, " ).append("\n"); 
		query.append("                         QTY.CNTR_TPSZ_CD, " ).append("\n"); 
		query.append("                         SUM (QTY.OP_CNTR_QTY) AS BKG_VOL_QTY," ).append("\n"); 
		query.append("                         RATIO_TO_REPORT (0) OVER (PARTITION BY BKG.BKG_NO) OFT_RATIO" ).append("\n"); 
		query.append("                    FROM BKG_QUANTITY QTY, " ).append("\n"); 
		query.append("                         BKG_BL_DOC   DOC, " ).append("\n"); 
		query.append("                         BKG_BOOKING  BKG, " ).append("\n"); 
		query.append("                         BKG_BOOKING  BK2 " ).append("\n"); 
		query.append("                   WHERE QTY.BKG_NO              = DOC.BKG_NO " ).append("\n"); 
		query.append("                     AND QTY.CNTR_TPSZ_CD NOT LIKE 'Q%' " ).append("\n"); 
		query.append("                     AND BK2.BKG_NO              = DOC.BKG_NO " ).append("\n"); 
		query.append("                     AND BK2.BL_NO_TP          <>  '9' " ).append("\n"); 
		query.append("                     AND BK2.BKG_STS_CD        <>  'X' " ).append("\n"); 
		query.append("                     AND " ).append("\n"); 
		query.append("                       ( " ).append("\n"); 
		query.append("                         BKG.BKG_NO              = DOC.BKG_NO " ).append("\n"); 
		query.append("                      OR BKG.BL_NO               = DOC.MST_CVRD_BL_NO " ).append("\n"); 
		query.append("                       ) " ).append("\n"); 
		query.append("                     AND BKG.BKG_NO              = @[bkg_no]" ).append("\n"); 
		query.append("                GROUP BY BKG.BKG_NO, " ).append("\n"); 
		query.append("                         QTY.CNTR_TPSZ_CD ) REV," ).append("\n"); 
		query.append("                (" ).append("\n"); 
		query.append("                      SELECT" ).append("\n"); 
		query.append("                             MAX (REV.BKG_NO)               AS BKG_NO," ).append("\n"); 
		query.append("                             MAX (AMT.BKG_FF_CNT_CD)        AS BKG_FF_CNT_CD," ).append("\n"); 
		query.append("                             MAX (AMT.BKG_FF_SEQ)           AS BKG_FF_SEQ," ).append("\n"); 
		query.append("                             MAX (AMT.FF_CMPN_SEQ)          AS FF_CMPN_SEQ," ).append("\n"); 
		query.append("                             MAX (AMT.IF_AMT)               AS IF_AMT," ).append("\n"); 
		query.append("                             SUM" ).append("\n"); 
		query.append("                           (" ).append("\n"); 
		query.append("                         CASE" ).append("\n"); 
		query.append("                         WHEN SUBSTR (REV.CNTR_TPSZ_CD, 2, 1) = '2'" ).append("\n"); 
		query.append("                         THEN REV.BKG_VOL_QTY" ).append("\n"); 
		query.append("                         ELSE REV.BKG_VOL_QTY * 2" ).append("\n"); 
		query.append("                          END" ).append("\n"); 
		query.append("                            )                               AS TOT_QTY" ).append("\n"); 
		query.append("                         FROM (SELECT " ).append("\n"); 
		query.append("                                     BKG.BKG_NO, " ).append("\n"); 
		query.append("                                     QTY.CNTR_TPSZ_CD, " ).append("\n"); 
		query.append("                                     SUM (QTY.OP_CNTR_QTY) AS BKG_VOL_QTY," ).append("\n"); 
		query.append("                                     RATIO_TO_REPORT (0) OVER (PARTITION BY BKG.BKG_NO) OFT_RATIO" ).append("\n"); 
		query.append("                                FROM BKG_QUANTITY QTY, " ).append("\n"); 
		query.append("                                     BKG_BL_DOC   DOC, " ).append("\n"); 
		query.append("                                     BKG_BOOKING  BKG, " ).append("\n"); 
		query.append("                                     BKG_BOOKING  BK2 " ).append("\n"); 
		query.append("                               WHERE QTY.BKG_NO              = DOC.BKG_NO " ).append("\n"); 
		query.append("                                 AND QTY.CNTR_TPSZ_CD NOT LIKE 'Q%' " ).append("\n"); 
		query.append("                                 AND BK2.BKG_NO              = DOC.BKG_NO " ).append("\n"); 
		query.append("                                 AND BK2.BL_NO_TP          <>  '9' " ).append("\n"); 
		query.append("                                 AND BK2.BKG_STS_CD        <>  'X' " ).append("\n"); 
		query.append("                                 AND " ).append("\n"); 
		query.append("                                   ( " ).append("\n"); 
		query.append("                                     BKG.BKG_NO              = DOC.BKG_NO " ).append("\n"); 
		query.append("                                  OR BKG.BL_NO               = DOC.MST_CVRD_BL_NO " ).append("\n"); 
		query.append("                                   ) " ).append("\n"); 
		query.append("                                 AND BKG.BKG_NO              = @[bkg_no]" ).append("\n"); 
		query.append("                            GROUP BY BKG.BKG_NO, " ).append("\n"); 
		query.append("                                     QTY.CNTR_TPSZ_CD ) REV," ).append("\n"); 
		query.append("                            (" ).append("\n"); 
		query.append("                                  SELECT" ).append("\n"); 
		query.append("                                         BRO.BKG_NO," ).append("\n"); 
		query.append("                                         BRO.BKG_FF_CNT_CD," ).append("\n"); 
		query.append("                                         BRO.BKG_FF_SEQ," ).append("\n"); 
		query.append("                                         BRO.FF_CMPN_SEQ," ).append("\n"); 
		query.append("                                         BRO.IF_AMT" ).append("\n"); 
		query.append("                                    FROM ACM_FF_CMPN BRO" ).append("\n"); 
		query.append("                                   WHERE BRO.BKG_NO    = @[bkg_no]" ).append("\n"); 
		query.append("                                     AND BRO.FF_CMPN_SEQ  = @[new_ff_cmpn_seq]" ).append("\n"); 
		query.append("                            ) AMT" ).append("\n"); 
		query.append("                        WHERE REV.BKG_NO = AMT.BKG_NO" ).append("\n"); 
		query.append("                ) QTY" ).append("\n"); 
		query.append("            WHERE REV.BKG_NO = QTY.BKG_NO" ).append("\n"); 
		query.append("     ) INS" ).append("\n"); 

	}
}