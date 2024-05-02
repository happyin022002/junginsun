/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : FACCommCalculationDBDAOModifyFACDetailCompUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.07.17
*@LastModifier : 
*@LastVersion : 1.0
* 2012.07.17 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmcalculation.faccommcalculation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class FACCommCalculationDBDAOModifyFACDetailCompUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * FACCommCalculationDBDAOModifyFACDetailCompUSQL
	  * </pre>
	  */
	public FACCommCalculationDBDAOModifyFACDetailCompUSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.acm.acmcalculation.faccommcalculation.integration").append("\n"); 
		query.append("FileName : FACCommCalculationDBDAOModifyFACDetailCompUSQL").append("\n"); 
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
		query.append("MERGE" ).append("\n"); 
		query.append(" INTO ACM_FAC_COMM_DTL TBL" ).append("\n"); 
		query.append("USING" ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("          SELECT" ).append("\n"); 
		query.append("            CASE" ).append("\n"); 
		query.append("            WHEN TOB.BKG_NO IS NULL" ).append("\n"); 
		query.append("            THEN AIS.BKG_NO" ).append("\n"); 
		query.append("            ELSE TOB.BKG_NO" ).append("\n"); 
		query.append("             END                                                            AS BKG_NO," ).append("\n"); 
		query.append("            CASE" ).append("\n"); 
		query.append("            WHEN TOB.SLS_OFC_CD IS NULL" ).append("\n"); 
		query.append("            THEN AIS.SLS_OFC_CD" ).append("\n"); 
		query.append("            ELSE TOB.SLS_OFC_CD" ).append("\n"); 
		query.append("             END                                                            AS SLS_OFC_CD," ).append("\n"); 
		query.append("            CASE" ).append("\n"); 
		query.append("            WHEN TOB.FAC_SEQ IS NULL" ).append("\n"); 
		query.append("            THEN AIS.FAC_SEQ" ).append("\n"); 
		query.append("            ELSE TOB.FAC_SEQ" ).append("\n"); 
		query.append("             END                                                            AS FAC_SEQ," ).append("\n"); 
		query.append("            CASE" ).append("\n"); 
		query.append("            WHEN TOB.CNTR_TPSZ_CD IS NULL" ).append("\n"); 
		query.append("            THEN AIS.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("            ELSE TOB.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("             END                                                            AS CNTR_TPSZ_CD," ).append("\n"); 
		query.append("                 TOB.BKG_VOL_QTY                                            AS BKG_VOL_QTY," ).append("\n"); 
		query.append("                       CASE" ).append("\n"); 
		query.append("           WHEN TOB.QTY_RATIO = 1" ).append("\n"); 
		query.append("           THEN TOB.IF_AMT" ).append("\n"); 
		query.append("           WHEN TOB.RNUM = TOB.MNUM" ).append("\n"); 
		query.append("           THEN TOB.IF_AMT" ).append("\n"); 
		query.append("              + ROUND (TOB.IF_AMT * TOB.QTY_RATIO, 2)" ).append("\n"); 
		query.append("              - SUM (ROUND (TOB.IF_AMT * TOB.QTY_RATIO, 2))" ).append("\n"); 
		query.append("                OVER" ).append("\n"); 
		query.append("              (" ).append("\n"); 
		query.append("      PARTITION" ).append("\n"); 
		query.append("             BY TOB.BKG_NO," ).append("\n"); 
		query.append("                TOB.SLS_OFC_CD" ).append("\n"); 
		query.append("       ORDER BY TOB.CNTR_TPSZ_CD DESC" ).append("\n"); 
		query.append("              )" ).append("\n"); 
		query.append("           ELSE ROUND (TOB.IF_AMT * TOB.QTY_RATIO, 2)" ).append("\n"); 
		query.append("            END                                                             AS IF_DTRB_AMT," ).append("\n"); 
		query.append("           TOB.CURR_CD                                                      AS CURR_CD," ).append("\n"); 
		query.append("           CASE" ).append("\n"); 
		query.append("           WHEN TOB.RNUM = TOB.MNUM" ).append("\n"); 
		query.append("           THEN TOB.CRNT_AMT" ).append("\n"); 
		query.append("              + ROUND (TOB.CRNT_AMT * TOB.QTY_RATIO, 2)" ).append("\n"); 
		query.append("              - SUM (ROUND (TOB.CRNT_AMT * TOB.QTY_RATIO, 2))" ).append("\n"); 
		query.append("                OVER" ).append("\n"); 
		query.append("              (" ).append("\n"); 
		query.append("      PARTITION" ).append("\n"); 
		query.append("             BY TOB.BKG_NO," ).append("\n"); 
		query.append("                TOB.SLS_OFC_CD" ).append("\n"); 
		query.append("       ORDER BY TOB.CNTR_TPSZ_CD DESC" ).append("\n"); 
		query.append("              )" ).append("\n"); 
		query.append("           ELSE ROUND (TOB.CRNT_AMT * TOB.QTY_RATIO, 2)" ).append("\n"); 
		query.append("            END                                                             AS PAY_IF_DTRB_AMT," ).append("\n"); 
		query.append("                'COMMISSION'                                                AS UPD_USR_ID," ).append("\n"); 
		query.append("                SYSDATE                                                     AS UPD_DT," ).append("\n"); 
		query.append("                'COMMISSION'                                                AS CRE_USR_ID," ).append("\n"); 
		query.append("                SYSDATE                                                     AS CRE_DT" ).append("\n"); 
		query.append("           FROM" ).append("\n"); 
		query.append("              (" ).append("\n"); 
		query.append("                    SELECT" ).append("\n"); 
		query.append("                           FAD.BKG_NO," ).append("\n"); 
		query.append("                           FAC.SLS_OFC_CD," ).append("\n"); 
		query.append("                           FAD.FAC_SEQ," ).append("\n"); 
		query.append("                           FAD.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("                           FAD.BKG_VOL_QTY," ).append("\n"); 
		query.append("                           FAD.IF_DTRB_AMT," ).append("\n"); 
		query.append("                           FAD.CURR_CD," ).append("\n"); 
		query.append("                           FAD.PAY_IF_DTRB_AMT," ).append("\n"); 
		query.append("                           FAD.UPD_USR_ID," ).append("\n"); 
		query.append("                           FAD.UPD_DT," ).append("\n"); 
		query.append("                           FAD.CRE_USR_ID," ).append("\n"); 
		query.append("                           FAD.CRE_DT" ).append("\n"); 
		query.append("                      FROM ACM_FAC_COMM_DTL FAD," ).append("\n"); 
		query.append("                         (" ).append("\n"); 
		query.append("                               SELECT" ).append("\n"); 
		query.append("                                      FAC.BKG_NO," ).append("\n"); 
		query.append("                                      FAC.SLS_OFC_CD," ).append("\n"); 
		query.append("                                      MAX (FAC.FAC_SEQ)      AS FAC_SEQ" ).append("\n"); 
		query.append("                                 FROM ACM_FAC_COMM FAC" ).append("\n"); 
		query.append("                                WHERE BKG_NO         = @[bkg_no]--'DUS101173700'" ).append("\n"); 
		query.append("                                  AND FAC_STS_CD" ).append("\n"); 
		query.append("                                   IN" ).append("\n"); 
		query.append("                                    (" ).append("\n"); 
		query.append("                                      'RS', 'RM', 'AS', 'IF', 'CS'" ).append("\n"); 
		query.append("                                    )" ).append("\n"); 
		query.append("                             GROUP BY FAC.BKG_NO," ).append("\n"); 
		query.append("                                      FAC.SLS_OFC_CD" ).append("\n"); 
		query.append("                               HAVING EXISTS" ).append("\n"); 
		query.append("                                    (" ).append("\n"); 
		query.append("                                          SELECT" ).append("\n"); 
		query.append("                                                 1" ).append("\n"); 
		query.append("                                            FROM ACM_FAC_COMM FA2" ).append("\n"); 
		query.append("                                           WHERE FA2.BKG_NO           = FAC.BKG_NO" ).append("\n"); 
		query.append("                                             AND FA2.SLS_OFC_CD       = FAC.SLS_OFC_CD" ).append("\n"); 
		query.append("                                             AND FA2.FAC_STS_CD = 'CS'" ).append("\n"); 
		query.append("                                             AND FA2.FAC_SEQ          = MAX (FAC.FAC_SEQ)" ).append("\n"); 
		query.append("                                    )" ).append("\n"); 
		query.append("                         ) FAC" ).append("\n"); 
		query.append("                     WHERE FAD.BKG_NO     = FAC.BKG_NO" ).append("\n"); 
		query.append("                       AND FAD.FAC_SEQ    = FAC.FAC_SEQ" ).append("\n"); 
		query.append("              ) AIS" ).append("\n"); 
		query.append("     FULL OUTER" ).append("\n"); 
		query.append("           JOIN" ).append("\n"); 
		query.append("              (" ).append("\n"); 
		query.append("                    SELECT" ).append("\n"); 
		query.append("                           RANK() OVER(ORDER BY QTY.CNTR_TPSZ_CD DESC) AS RNUM," ).append("\n"); 
		query.append("                         (" ).append("\n"); 
		query.append("                               SELECT" ).append("\n"); 
		query.append("                                      COUNT (DISTINCT QTY.CNTR_TPSZ_CD)" ).append("\n"); 
		query.append("                                FROM BKG_BL_DOC     DOC," ).append("\n"); 
		query.append("                                     BKG_BOOKING    BKG," ).append("\n"); 
		query.append("                                     BKG_BOOKING    BK2," ).append("\n"); 
		query.append("                                     BKG_QUANTITY   QTY" ).append("\n"); 
		query.append("                               WHERE" ).append("\n"); 
		query.append("                                   (" ).append("\n"); 
		query.append("                                     BKG.BKG_NO       = DOC.BKG_NO" ).append("\n"); 
		query.append("                                  OR" ).append("\n"); 
		query.append("                                     BKG.BL_NO        = DOC.MST_CVRD_BL_NO" ).append("\n"); 
		query.append("                                   )" ).append("\n"); 
		query.append("                                 AND BK2.BKG_NO       = DOC.BKG_NO" ).append("\n"); 
		query.append("                                 AND BK2.BL_NO_TP" ).append("\n"); 
		query.append("                                  IN" ).append("\n"); 
		query.append("                                   (" ).append("\n"); 
		query.append("                                CASE" ).append("\n"); 
		query.append("                                WHEN BKG.BL_NO_TP = '9'" ).append("\n"); 
		query.append("                                THEN '0'" ).append("\n"); 
		query.append("                                ELSE BK2.BL_NO_TP" ).append("\n"); 
		query.append("                                 END" ).append("\n"); 
		query.append("                                   )" ).append("\n"); 
		query.append("                                 AND BK2.BKG_STS_CD" ).append("\n"); 
		query.append("                              NOT IN" ).append("\n"); 
		query.append("                                   (" ).append("\n"); 
		query.append("                                CASE" ).append("\n"); 
		query.append("                                WHEN BKG.BKG_STS_CD <> 'X'" ).append("\n"); 
		query.append("                                THEN 'X'" ).append("\n"); 
		query.append("                                ELSE ' '" ).append("\n"); 
		query.append("                                 END" ).append("\n"); 
		query.append("                                   )" ).append("\n"); 
		query.append("                                 AND BK2.BKG_NO       = QTY.BKG_NO" ).append("\n"); 
		query.append("                                 AND QTY.CNTR_TPSZ_CD NOT LIKE 'Q%'" ).append("\n"); 
		query.append("                                 AND BKG.BKG_NO       = FAC.BKG_NO" ).append("\n"); 
		query.append("                         )                                             AS MNUM," ).append("\n"); 
		query.append("                           FAC.BKG_NO                                  AS BKG_NO," ).append("\n"); 
		query.append("                           MAX (FAC.SLS_OFC_CD)                        AS SLS_OFC_CD," ).append("\n"); 
		query.append("                           MAX (FAC.FAC_SEQ)                           AS FAC_SEQ," ).append("\n"); 
		query.append("                           MAX (FAC.IF_AMT)                            AS IF_AMT," ).append("\n"); 
		query.append("                           MAX (FAC.CRNT_AMT)                          AS CRNT_AMT," ).append("\n"); 
		query.append("                           MAX (FAC.CURR_CD)                           AS CURR_CD," ).append("\n"); 
		query.append("                           QTY.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("                           SUM (QTY.OP_CNTR_QTY)                       AS BKG_VOL_QTY," ).append("\n"); 
		query.append("                           RATIO_TO_REPORT (SUM (QTY.OP_CNTR_QTY))" ).append("\n"); 
		query.append("                           OVER" ).append("\n"); 
		query.append("                         (" ).append("\n"); 
		query.append("              PARTITION BY FAC.BKG_NO," ).append("\n"); 
		query.append("                           FAC.SLS_OFC_CD" ).append("\n"); 
		query.append("                         )                                             AS QTY_RATIO" ).append("\n"); 
		query.append("                      FROM BKG_QUANTITY QTY," ).append("\n"); 
		query.append("                         (" ).append("\n"); 
		query.append("                               SELECT" ).append("\n"); 
		query.append("                                      FAC.BKG_NO," ).append("\n"); 
		query.append("                                      FAC.SLS_OFC_CD," ).append("\n"); 
		query.append("                                      FAC.FAC_SEQ," ).append("\n"); 
		query.append("                                      FAC.IF_AMT," ).append("\n"); 
		query.append("                                      FAC.CRNT_AMT," ).append("\n"); 
		query.append("                                      FAC.CURR_CD" ).append("\n"); 
		query.append("                                 FROM ACM_FAC_COMM FAC" ).append("\n"); 
		query.append("                                WHERE FAC.BKG_NO    = @[bkg_no]--'DUS101173700'" ).append("\n"); 
		query.append("                                  AND FAC.FAC_STS_CD = 'CS'" ).append("\n"); 
		query.append("                                  AND FAC.FAC_SEQ" ).append("\n"); 
		query.append("                                    =" ).append("\n"); 
		query.append("                                    (" ).append("\n"); 
		query.append("                                          SELECT" ).append("\n"); 
		query.append("                                                 MAX (FA2.FAC_SEQ)" ).append("\n"); 
		query.append("                                            FROM ACM_FAC_COMM FA2" ).append("\n"); 
		query.append("                                           WHERE FA2.BKG_NO    = FAC.BKG_NO" ).append("\n"); 
		query.append("                                             AND FA2.SLS_OFC_CD    = FAC.SLS_OFC_CD" ).append("\n"); 
		query.append("                                             AND FAC_STS_CD" ).append("\n"); 
		query.append("                                              IN" ).append("\n"); 
		query.append("                                               (" ).append("\n"); 
		query.append("                                                 'RS', 'RM', 'AS', 'IF', 'CS'" ).append("\n"); 
		query.append("                                               )" ).append("\n"); 
		query.append("                                    )" ).append("\n"); 
		query.append("                         ) FAC" ).append("\n"); 
		query.append("                     WHERE QTY.BKG_NO" ).append("\n"); 
		query.append("                        IN" ).append("\n"); 
		query.append("                         (" ).append("\n"); 
		query.append("                              SELECT" ).append("\n"); 
		query.append("                                     DOC.BKG_NO" ).append("\n"); 
		query.append("                                FROM BKG_BL_DOC     DOC," ).append("\n"); 
		query.append("                                     BKG_BOOKING    BKG," ).append("\n"); 
		query.append("                                     BKG_BOOKING    BK2" ).append("\n"); 
		query.append("                               WHERE" ).append("\n"); 
		query.append("                                   (" ).append("\n"); 
		query.append("                                     BKG.BKG_NO       = DOC.BKG_NO" ).append("\n"); 
		query.append("                                  OR" ).append("\n"); 
		query.append("                                     BKG.BL_NO        = DOC.MST_CVRD_BL_NO" ).append("\n"); 
		query.append("                                   )" ).append("\n"); 
		query.append("                                 AND BK2.BKG_NO       = DOC.BKG_NO" ).append("\n"); 
		query.append("                                 AND BK2.BL_NO_TP" ).append("\n"); 
		query.append("                                  IN" ).append("\n"); 
		query.append("                                   (" ).append("\n"); 
		query.append("                                CASE" ).append("\n"); 
		query.append("                                WHEN BKG.BL_NO_TP = '9'" ).append("\n"); 
		query.append("                                THEN '0'" ).append("\n"); 
		query.append("                                ELSE BK2.BL_NO_TP" ).append("\n"); 
		query.append("                                 END" ).append("\n"); 
		query.append("                                   )" ).append("\n"); 
		query.append("                                 AND BK2.BKG_STS_CD" ).append("\n"); 
		query.append("                              NOT IN" ).append("\n"); 
		query.append("                                   (" ).append("\n"); 
		query.append("                                CASE" ).append("\n"); 
		query.append("                                WHEN BKG.BKG_STS_CD <> 'X'" ).append("\n"); 
		query.append("                                THEN 'X'" ).append("\n"); 
		query.append("                                ELSE ' '" ).append("\n"); 
		query.append("                                 END" ).append("\n"); 
		query.append("                                   )" ).append("\n"); 
		query.append("                                 AND BKG.BKG_NO       = @[bkg_no]--'DUS101173700'" ).append("\n"); 
		query.append("                         )" ).append("\n"); 
		query.append("                       AND QTY.CNTR_TPSZ_CD NOT LIKE 'Q%'" ).append("\n"); 
		query.append("                  GROUP BY FAC.BKG_NO," ).append("\n"); 
		query.append("                           FAC.SLS_OFC_CD," ).append("\n"); 
		query.append("                           QTY.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                  ORDER BY QTY.CNTR_TPSZ_CD DESC" ).append("\n"); 
		query.append("              ) TOB" ).append("\n"); 
		query.append("             ON" ).append("\n"); 
		query.append("              (" ).append("\n"); 
		query.append("                AIS.BKG_NO       = TOB.BKG_NO" ).append("\n"); 
		query.append("            AND AIS.FAC_SEQ       = TOB.FAC_SEQ" ).append("\n"); 
		query.append("            AND AIS.CNTR_TPSZ_CD = TOB.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("              )" ).append("\n"); 
		query.append("   ) PCD" ).append("\n"); 
		query.append("   ON" ).append("\n"); 
		query.append("    ( TBL.BKG_NO         = PCD.BKG_NO" ).append("\n"); 
		query.append("  AND TBL.FAC_SEQ         = PCD.FAC_SEQ" ).append("\n"); 
		query.append("  AND TBL.CNTR_TPSZ_CD   = PCD.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append(" WHEN MATCHED" ).append("\n"); 
		query.append(" THEN" ).append("\n"); 
		query.append("          UPDATE" ).append("\n"); 
		query.append("             SET TBL.BKG_VOL_QTY       = PCD.BKG_VOL_QTY," ).append("\n"); 
		query.append("                 TBL.IF_DTRB_AMT       = PCD.IF_DTRB_AMT," ).append("\n"); 
		query.append("                 TBL.CURR_CD           = PCD. CURR_CD," ).append("\n"); 
		query.append("                 TBL.PAY_IF_DTRB_AMT   = PCD.PAY_IF_DTRB_AMT," ).append("\n"); 
		query.append("                 TBL.UPD_USR_ID        = PCD.UPD_USR_ID," ).append("\n"); 
		query.append("                 TBL.UPD_DT            = PCD.UPD_DT" ).append("\n"); 
		query.append("          DELETE" ).append("\n"); 
		query.append("           WHERE PCD.BKG_VOL_QTY IS NULL" ).append("\n"); 
		query.append(" WHEN NOT MATCHED" ).append("\n"); 
		query.append(" THEN" ).append("\n"); 
		query.append("INSERT" ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("      BKG_NO," ).append("\n"); 
		query.append("      SLS_OFC_CD," ).append("\n"); 
		query.append("      FAC_SEQ," ).append("\n"); 
		query.append("      CNTR_TPSZ_CD," ).append("\n"); 
		query.append("      BKG_VOL_QTY," ).append("\n"); 
		query.append("      IF_DTRB_AMT," ).append("\n"); 
		query.append("      CURR_CD," ).append("\n"); 
		query.append("      PAY_IF_DTRB_AMT," ).append("\n"); 
		query.append("      UPD_USR_ID," ).append("\n"); 
		query.append("      UPD_DT," ).append("\n"); 
		query.append("      CRE_USR_ID," ).append("\n"); 
		query.append("      CRE_DT" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("VALUES" ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("      PCD.BKG_NO," ).append("\n"); 
		query.append("      PCD.SLS_OFC_CD," ).append("\n"); 
		query.append("      PCD.FAC_SEQ," ).append("\n"); 
		query.append("      PCD.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("      PCD.BKG_VOL_QTY," ).append("\n"); 
		query.append("      PCD.IF_DTRB_AMT," ).append("\n"); 
		query.append("      PCD.CURR_CD," ).append("\n"); 
		query.append("      PCD.PAY_IF_DTRB_AMT," ).append("\n"); 
		query.append("      PCD.UPD_USR_ID," ).append("\n"); 
		query.append("      PCD.UPD_DT," ).append("\n"); 
		query.append("      PCD.CRE_USR_ID," ).append("\n"); 
		query.append("      PCD.CRE_DT" ).append("\n"); 
		query.append("    )" ).append("\n"); 

	}
}