/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : UsaCustomsReportDBDAOsearchReceivedHistoryListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.07
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.07 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaCustomsReportDBDAOsearchReceivedHistoryListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RcvHistListDetailVO
	  * </pre>
	  */
	public UsaCustomsReportDBDAOsearchReceivedHistoryListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tod",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fromd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scac_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("fromt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcv_msg_tp_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tot",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("start_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cstms_bat_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("end_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.usa.integration").append("\n"); 
		query.append("FileName : UsaCustomsReportDBDAOsearchReceivedHistoryListRSQL").append("\n"); 
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
		query.append("SELECT *" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("SELECT TB.CNT_CD" ).append("\n"); 
		query.append("      ,TB.IO_BND_CD" ).append("\n"); 
		query.append("      ,TO_CHAR(TB.RCV_DT, 'YYYY-MM-DD HH24:MI:SS') AS RCV_DT" ).append("\n"); 
		query.append("      ,TB.RCV_SEQ" ).append("\n"); 
		query.append("      ,TB.RCV_MSG_TP_ID" ).append("\n"); 
		query.append("      ,DECODE(RS.DSPO_CD, NULL, DECODE(TB.AAD, NULL, '', TB.AAD), RS.DSPO_CD) AS DSPO_CD" ).append("\n"); 
		query.append("      ,TB.VVD" ).append("\n"); 
		query.append("      ,TB.POL_CD" ).append("\n"); 
		query.append("      ,TB.POD_CD" ).append("\n"); 
		query.append("      ,BL.CSTMS_POD_CD AS VPOD_CD" ).append("\n"); 
		query.append("      ,TB.CSTMS_BAT_NO" ).append("\n"); 
		query.append("      ,TB.SCAC_CD" ).append("\n"); 
		query.append("      ,DECODE(TOT_CNT, NULL, TB.BL_NO) AS BL_NO" ).append("\n"); 
		query.append("      ,TB.TOT_CNT" ).append("\n"); 
		query.append("      ,TB.SUC_CNT" ).append("\n"); 
		query.append("      ,TB.ERR_CNT" ).append("\n"); 
		query.append("      ,TB.REASON" ).append("\n"); 
		query.append("      ,CASE WHEN TB.REASON IS NOT NULL OR TB.ERR_CNT > 0" ).append("\n"); 
		query.append("            THEN 'Y' " ).append("\n"); 
		query.append("            ELSE 'N'" ).append("\n"); 
		query.append("        END RJCT_FLG" ).append("\n"); 
		query.append("      ,ROW_NUMBER() OVER(ORDER BY RCV_DT DESC, RCV_SEQ, TOT_CNT) AS RNUM" ).append("\n"); 
		query.append("      ,COUNT(*) OVER() AS TOTAL" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT LOG.CNT_CD" ).append("\n"); 
		query.append("              ,LOG.IO_BND_CD" ).append("\n"); 
		query.append("              ,LOG.RCV_DT" ).append("\n"); 
		query.append("              ,LOG.RCV_SEQ" ).append("\n"); 
		query.append("              ,LOG.RCV_MSG_TP_ID" ).append("\n"); 
		query.append("              ,LOG.VVD" ).append("\n"); 
		query.append("              ,LOG.POL_CD" ).append("\n"); 
		query.append("              ,LOG.POD_CD" ).append("\n"); 
		query.append("              ,LOG.CSTMS_BAT_NO" ).append("\n"); 
		query.append("              ,LOG.SCAC_CD" ).append("\n"); 
		query.append("              ,MAX(LOG.BL_NO) AS BL_NO" ).append("\n"); 
		query.append("              ,(SELECT 'AAD' " ).append("\n"); 
		query.append("                  FROM BKG_CSTMS_ADV_RCV_LOG_DTL DTL" ).append("\n"); 
		query.append("                 WHERE LOG.CNT_CD     = DTL.CNT_CD" ).append("\n"); 
		query.append("                   AND LOG.IO_BND_CD  = DTL.IO_BND_CD" ).append("\n"); 
		query.append("                   AND LOG.RCV_DT     = DTL.RCV_DT" ).append("\n"); 
		query.append("                   AND LOG.RCV_SEQ    = DTL.RCV_SEQ" ).append("\n"); 
		query.append("                   AND DTL.MSG_DESC   LIKE 'R06AAD%'" ).append("\n"); 
		query.append("                   AND ROWNUM = 1) AS AAD" ).append("\n"); 
		query.append("              ,DECODE(LOG.RCV_MSG_TP_ID, 'MR', SUM(TOT_CNT), 'AR', DECODE(SUM(LOG.TOT_CNT), 1, NULL, SUM(LOG.TOT_CNT))) AS TOT_CNT" ).append("\n"); 
		query.append("              ,CASE WHEN LOG.RCV_MSG_TP_ID = 'MR' AND SUM(ERR_CNT) = 0 AND MAX(REASON) IS NOT NULL" ).append("\n"); 
		query.append("                    THEN 0" ).append("\n"); 
		query.append("                    WHEN LOG.RCV_MSG_TP_ID = 'MR'" ).append("\n"); 
		query.append("                    THEN SUM(TOT_CNT) - SUM(ERR_CNT)" ).append("\n"); 
		query.append("                    WHEN LOG.RCV_MSG_TP_ID = 'AR' AND SUM(LOG.TOT_CNT) > 1" ).append("\n"); 
		query.append("                    THEN SUM(TOT_CNT) - SUM(ERR_CNT)" ).append("\n"); 
		query.append("                    ELSE NULL" ).append("\n"); 
		query.append("                END SUC_CNT" ).append("\n"); 
		query.append("              ,CASE WHEN LOG.RCV_MSG_TP_ID = 'MR' AND SUM(ERR_CNT) = 0 AND MAX(REASON) IS NOT NULL" ).append("\n"); 
		query.append("                    THEN SUM(TOT_CNT)" ).append("\n"); 
		query.append("                    WHEN LOG.RCV_MSG_TP_ID = 'MR'" ).append("\n"); 
		query.append("                    THEN SUM(ERR_CNT)" ).append("\n"); 
		query.append("                    WHEN LOG.RCV_MSG_TP_ID = 'AR' AND SUM(LOG.TOT_CNT) > 1" ).append("\n"); 
		query.append("                    THEN SUM(ERR_CNT)" ).append("\n"); 
		query.append("                    ELSE NULL" ).append("\n"); 
		query.append("                END ERR_CNT" ).append("\n"); 
		query.append("              ,CASE WHEN LOG.RCV_MSG_TP_ID = 'MR' AND SUM(ERR_CNT) = 0 AND MAX(REASON) IS NOT NULL" ).append("\n"); 
		query.append("                    THEN MAX(REASON	)" ).append("\n"); 
		query.append("                    WHEN LOG.RCV_MSG_TP_ID = 'MR'" ).append("\n"); 
		query.append("                    THEN NULL" ).append("\n"); 
		query.append("                    WHEN LOG.RCV_MSG_TP_ID = 'AR' AND SUM(LOG.TOT_CNT) > 1" ).append("\n"); 
		query.append("                    THEN NULL" ).append("\n"); 
		query.append("                    ELSE MAX(REASON)" ).append("\n"); 
		query.append("                END REASON" ).append("\n"); 
		query.append("          FROM (" ).append("\n"); 
		query.append("                SELECT LOG.CNT_CD" ).append("\n"); 
		query.append("                      ,LOG.IO_BND_CD" ).append("\n"); 
		query.append("                      ,LOG.RCV_DT" ).append("\n"); 
		query.append("                      ,LOG.RCV_SEQ" ).append("\n"); 
		query.append("                      ,LOG.RCV_MSG_TP_ID" ).append("\n"); 
		query.append("                      ,LOG.VVD" ).append("\n"); 
		query.append("                      ,LOG.POL_CD" ).append("\n"); 
		query.append("                      ,LOG.POD_CD" ).append("\n"); 
		query.append("                      ,LOG.CSTMS_BAT_NO" ).append("\n"); 
		query.append("                      ,LOG.SCAC_CD" ).append("\n"); 
		query.append("                      ,LOG.BL_NO" ).append("\n"); 
		query.append("                      ,MAX(REASON) AS REASON" ).append("\n"); 
		query.append("                      ,CASE WHEN LOG.RCV_MSG_TP_ID IN ('MR', 'AR')" ).append("\n"); 
		query.append("                            THEN 1" ).append("\n"); 
		query.append("                            ELSE 0" ).append("\n"); 
		query.append("                        END TOT_CNT" ).append("\n"); 
		query.append("                      ,CASE WHEN LOG.RCV_MSG_TP_ID IN ('MR', 'AR')" ).append("\n"); 
		query.append("                            THEN NVL((SELECT 1" ).append("\n"); 
		query.append("                                        FROM BKG_CSTMS_ADV_RCV_LOG_DTL DTL" ).append("\n"); 
		query.append("                                       WHERE LOG.CNT_CD     = DTL.CNT_CD" ).append("\n"); 
		query.append("                                         AND LOG.IO_BND_CD  = DTL.IO_BND_CD" ).append("\n"); 
		query.append("                                         AND LOG.RCV_DT     = DTL.RCV_DT" ).append("\n"); 
		query.append("                                         AND LOG.RCV_SEQ    = DTL.RCV_SEQ" ).append("\n"); 
		query.append("                                         AND DTL.MSG_DESC   LIKE 'W01' || LOG.BL_NO || '%'" ).append("\n"); 
		query.append("                                         AND ROWNUM = 1" ).append("\n"); 
		query.append("                                      ), 0)" ).append("\n"); 
		query.append("                            ELSE 0" ).append("\n"); 
		query.append("                        END ERR_CNT" ).append("\n"); 
		query.append("                  FROM (" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                SELECT LOG.CNT_CD" ).append("\n"); 
		query.append("                      ,LOG.IO_BND_CD" ).append("\n"); 
		query.append("                      ,LOG.RCV_DT" ).append("\n"); 
		query.append("                      ,LOG.RCV_SEQ" ).append("\n"); 
		query.append("                      ,LOG.RCV_MSG_TP_ID" ).append("\n"); 
		query.append("                      ,LOG.VSL_CD || LOG.SKD_VOY_NO || LOG.SKD_DIR_CD AS VVD" ).append("\n"); 
		query.append("                      ,LOG.POL_CD" ).append("\n"); 
		query.append("                      ,LOG.POD_CD" ).append("\n"); 
		query.append("                      ,LOG.CSTMS_BAT_NO" ).append("\n"); 
		query.append("                      ,LOG.SCAC_CD" ).append("\n"); 
		query.append("                      ,NVL(BLR.BL_NO, LOG.BL_NO) AS BL_NO" ).append("\n"); 
		query.append("                      ,BKG_JOIN_FNC((CURSOR(SELECT SUBSTR(DTL.MSG_DESC, 40)" ).append("\n"); 
		query.append("                                              FROM BKG_CSTMS_ADV_RCV_LOG_DTL DTL" ).append("\n"); 
		query.append("                                             WHERE LOG.CNT_CD     = DTL.CNT_CD" ).append("\n"); 
		query.append("                                               AND LOG.IO_BND_CD  = DTL.IO_BND_CD" ).append("\n"); 
		query.append("                                               AND LOG.RCV_DT     = DTL.RCV_DT" ).append("\n"); 
		query.append("                                               AND LOG.RCV_SEQ    = DTL.RCV_SEQ" ).append("\n"); 
		query.append("		                                       AND (DTL.MSG_DESC   LIKE 'W01 %'" ).append("\n"); 
		query.append("                                                   OR DTL.MSG_DESC LIKE 'W01' || NVL(BLR.BL_NO, 'XXX') || '%'" ).append("\n"); 
		query.append("                                                   OR DTL.MSG_DESC LIKE 'W01' || NVL(CNTR.CNTR_NO, 'XXX') || '%') " ).append("\n"); 
		query.append("                                             GROUP BY DTL.RCV_MSG_DTL_SEQ, DTL.MSG_DESC" ).append("\n"); 
		query.append("                                             ORDER BY DTL.RCV_MSG_DTL_SEQ" ).append("\n"); 
		query.append("                                            )" ).append("\n"); 
		query.append("                                     ), CHR(10)) AS REASON" ).append("\n"); 
		query.append("                  FROM BKG_CSTMS_ADV_RCV_LOG     LOG" ).append("\n"); 
		query.append("                      ,BKG_CSTMS_ADV_EDI_BL_RSPN BLR" ).append("\n"); 
		query.append("                      ,BKG_CSTMS_ADV_CNTR        CNTR" ).append("\n"); 
		query.append("                 WHERE LOG.CNT_CD        = 'US'" ).append("\n"); 
		query.append("                   AND LOG.IO_BND_CD     = 'I'" ).append("\n"); 
		query.append("                   AND LOG.CNT_CD        = BLR.CNT_CD(+)" ).append("\n"); 
		query.append("                   AND LOG.CRR_BAT_NO    = BLR.CRR_BAT_NO(+)" ).append("\n"); 
		query.append("                   AND BLR.CNT_CD        = CNTR.CNT_CD(+)" ).append("\n"); 
		query.append("                   AND BLR.BL_NO         = CNTR.BL_NO(+)" ).append("\n"); 
		query.append("#if (${rcv_msg_tp_id} != '' && ${rcv_msg_tp_id} != 'AL')" ).append("\n"); 
		query.append("                   AND LOG.RCV_MSG_TP_ID = @[rcv_msg_tp_id]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vsl_cd} != '')" ).append("\n"); 
		query.append("                   AND LOG.VSL_CD     = @[vsl_cd]" ).append("\n"); 
		query.append("                   AND LOG.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("                   AND LOG.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pol_cd} != '')" ).append("\n"); 
		query.append("                   AND LOG.POL_CD = @[pol_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pod_cd} != '')" ).append("\n"); 
		query.append("                   AND LOG.POD_CD = @[pod_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cstms_bat_no} != '')" ).append("\n"); 
		query.append("                   AND LOG.CSTMS_BAT_NO = @[cstms_bat_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${scac_cd} != '')" ).append("\n"); 
		query.append("                   AND LOG.SCAC_CD = @[scac_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bl_no} != '')" ).append("\n"); 
		query.append("                   AND NVL(LOG.BL_NO, BLR.BL_NO)  = @[bl_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${fromd} != '')" ).append("\n"); 
		query.append("                   AND LOG.RCV_DT >= TO_DATE(REPLACE(REPLACE(@[fromd], '-', ''), '/', '') ||' '|| REPLACE(REPLACE(@[fromt], ':', ''), '-',''),'YYYYMMDD HH24MI')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${tod} != '')" ).append("\n"); 
		query.append("                   AND LOG.RCV_DT <= TO_DATE(REPLACE(REPLACE(@[tod], '-', ''), '/', '') ||' '|| REPLACE(REPLACE(@[tot], ':', ''), '-',''),'YYYYMMDD HH24MI')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("               ) LOG" ).append("\n"); 
		query.append("         GROUP BY LOG.CNT_CD" ).append("\n"); 
		query.append("              ,LOG.IO_BND_CD" ).append("\n"); 
		query.append("              ,LOG.RCV_DT" ).append("\n"); 
		query.append("              ,LOG.RCV_SEQ" ).append("\n"); 
		query.append("              ,LOG.RCV_MSG_TP_ID" ).append("\n"); 
		query.append("              ,LOG.VVD" ).append("\n"); 
		query.append("              ,LOG.POL_CD" ).append("\n"); 
		query.append("              ,LOG.POD_CD" ).append("\n"); 
		query.append("              ,LOG.CSTMS_BAT_NO" ).append("\n"); 
		query.append("              ,LOG.SCAC_CD" ).append("\n"); 
		query.append("              ,LOG.BL_NO" ).append("\n"); 
		query.append("               ) LOG" ).append("\n"); 
		query.append("         GROUP BY LOG.CNT_CD" ).append("\n"); 
		query.append("              ,LOG.IO_BND_CD" ).append("\n"); 
		query.append("              ,LOG.RCV_DT" ).append("\n"); 
		query.append("              ,LOG.RCV_SEQ" ).append("\n"); 
		query.append("              ,LOG.RCV_MSG_TP_ID" ).append("\n"); 
		query.append("              ,LOG.VVD" ).append("\n"); 
		query.append("              ,LOG.POL_CD" ).append("\n"); 
		query.append("              ,LOG.POD_CD" ).append("\n"); 
		query.append("              ,LOG.CSTMS_BAT_NO" ).append("\n"); 
		query.append("              ,LOG.SCAC_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        SELECT LOG.CNT_CD" ).append("\n"); 
		query.append("              ,LOG.IO_BND_CD" ).append("\n"); 
		query.append("              ,LOG.RCV_DT" ).append("\n"); 
		query.append("              ,LOG.RCV_SEQ" ).append("\n"); 
		query.append("              ,LOG.RCV_MSG_TP_ID" ).append("\n"); 
		query.append("              ,LOG.VVD" ).append("\n"); 
		query.append("              ,LOG.POL_CD" ).append("\n"); 
		query.append("              ,LOG.POD_CD" ).append("\n"); 
		query.append("              ,LOG.CSTMS_BAT_NO" ).append("\n"); 
		query.append("              ,LOG.SCAC_CD" ).append("\n"); 
		query.append("              ,LOG.BL_NO" ).append("\n"); 
		query.append("              ,(SELECT 'AAD' " ).append("\n"); 
		query.append("                  FROM BKG_CSTMS_ADV_RCV_LOG_DTL DTL" ).append("\n"); 
		query.append("                 WHERE LOG.CNT_CD     = DTL.CNT_CD" ).append("\n"); 
		query.append("                   AND LOG.IO_BND_CD  = DTL.IO_BND_CD" ).append("\n"); 
		query.append("                   AND LOG.RCV_DT     = DTL.RCV_DT" ).append("\n"); 
		query.append("                   AND LOG.RCV_SEQ    = DTL.RCV_SEQ" ).append("\n"); 
		query.append("                   AND DTL.MSG_DESC   LIKE 'R06AAD%'" ).append("\n"); 
		query.append("                   AND ROWNUM = 1) AS AAD " ).append("\n"); 
		query.append("              ,NULL" ).append("\n"); 
		query.append("              ,NULL" ).append("\n"); 
		query.append("              ,NULL" ).append("\n"); 
		query.append("              ,LOG.REASON" ).append("\n"); 
		query.append("          FROM (SELECT LOG.CNT_CD" ).append("\n"); 
		query.append("                      ,LOG.IO_BND_CD" ).append("\n"); 
		query.append("                      ,LOG.RCV_DT" ).append("\n"); 
		query.append("                      ,LOG.RCV_SEQ" ).append("\n"); 
		query.append("                      ,LOG.RCV_MSG_TP_ID" ).append("\n"); 
		query.append("                      ,LOG.VSL_CD || LOG.SKD_VOY_NO || LOG.SKD_DIR_CD AS VVD" ).append("\n"); 
		query.append("                      ,LOG.POL_CD" ).append("\n"); 
		query.append("                      ,LOG.POD_CD" ).append("\n"); 
		query.append("                      ,LOG.CSTMS_BAT_NO" ).append("\n"); 
		query.append("                      ,LOG.SCAC_CD" ).append("\n"); 
		query.append("                      ,BLR.BL_NO" ).append("\n"); 
		query.append("                      ,NULL" ).append("\n"); 
		query.append("                      ,NULL" ).append("\n"); 
		query.append("                      ,NULL" ).append("\n"); 
		query.append("                      ,BKG_JOIN_FNC((CURSOR(SELECT SUBSTR(DTL2.MSG_DESC, 40) " ).append("\n"); 
		query.append("                                              FROM BKG_CSTMS_ADV_RCV_LOG_DTL DTL2" ).append("\n"); 
		query.append("                                             WHERE LOG.CNT_CD     = DTL2.CNT_CD" ).append("\n"); 
		query.append("                                               AND LOG.IO_BND_CD  = DTL2.IO_BND_CD" ).append("\n"); 
		query.append("                                               AND LOG.RCV_DT     = DTL2.RCV_DT" ).append("\n"); 
		query.append("                                               AND LOG.RCV_SEQ    = DTL2.RCV_SEQ" ).append("\n"); 
		query.append("                                               AND DTL2.MSG_DESC   LIKE 'W01' || BLR.BL_NO || '%'" ).append("\n"); 
		query.append("                                             ORDER BY DTL2.RCV_MSG_DTL_SEQ" ).append("\n"); 
		query.append("                                            )" ).append("\n"); 
		query.append("                                     ), CHR(10)) AS REASON" ).append("\n"); 
		query.append("                      ,ROW_NUMBER() OVER(PARTITION BY DTL.RCV_DT, DTL.RCV_SEQ, SUBSTR(DTL.MSG_DESC, 4, 12) ORDER BY DTL.RCV_DT, DTL.RCV_SEQ, DTL.RCV_MSG_DTL_SEQ)  AS RNUM" ).append("\n"); 
		query.append("                  FROM BKG_CSTMS_ADV_RCV_LOG     LOG" ).append("\n"); 
		query.append("                      ,BKG_CSTMS_ADV_EDI_BL_RSPN BLR" ).append("\n"); 
		query.append("                      ,BKG_CSTMS_ADV_RCV_LOG_DTL DTL" ).append("\n"); 
		query.append("                 WHERE 1=1" ).append("\n"); 
		query.append("                   AND LOG.CNT_CD        = 'US'" ).append("\n"); 
		query.append("                   AND LOG.IO_BND_CD     = 'I'" ).append("\n"); 
		query.append("                   AND LOG.RCV_MSG_TP_ID IN ('MR', 'AR')" ).append("\n"); 
		query.append("                   AND LOG.CNT_CD     = BLR.CNT_CD" ).append("\n"); 
		query.append("                   AND LOG.CRR_BAT_NO = BLR.CRR_BAT_NO" ).append("\n"); 
		query.append("                   AND LOG.CNT_CD     = DTL.CNT_CD" ).append("\n"); 
		query.append("                   AND LOG.IO_BND_CD  = DTL.IO_BND_CD" ).append("\n"); 
		query.append("                   AND LOG.RCV_DT     = DTL.RCV_DT" ).append("\n"); 
		query.append("                   AND LOG.RCV_SEQ    = DTL.RCV_SEQ" ).append("\n"); 
		query.append("                   AND DTL.MSG_DESC   LIKE 'W01' || BLR.BL_NO || '%'" ).append("\n"); 
		query.append("                   AND DECODE(LOG.RCV_MSG_TP_ID, 'AR', (SELECT COUNT(*)" ).append("\n"); 
		query.append("                                                          FROM BKG_CSTMS_ADV_EDI_BL_RSPN AA" ).append("\n"); 
		query.append("                                                         WHERE LOG.CNT_CD     = AA.CNT_CD" ).append("\n"); 
		query.append("                                                           AND LOG.CRR_BAT_NO = AA.CRR_BAT_NO" ).append("\n"); 
		query.append("                                                        )" ).append("\n"); 
		query.append("                                                     , 2) > 1" ).append("\n"); 
		query.append("#if (${rcv_msg_tp_id} != '' && ${rcv_msg_tp_id} != 'AL')" ).append("\n"); 
		query.append("                   AND LOG.RCV_MSG_TP_ID = @[rcv_msg_tp_id]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vsl_cd} != '')" ).append("\n"); 
		query.append("                   AND LOG.VSL_CD     = @[vsl_cd]" ).append("\n"); 
		query.append("                   AND LOG.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("                   AND LOG.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pol_cd} != '')" ).append("\n"); 
		query.append("                   AND LOG.POL_CD = @[pol_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pod_cd} != '')" ).append("\n"); 
		query.append("                   AND LOG.POD_CD = @[pod_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cstms_bat_no} != '')" ).append("\n"); 
		query.append("                   AND LOG.CSTMS_BAT_NO = @[cstms_bat_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${scac_cd} != '')" ).append("\n"); 
		query.append("                   AND LOG.SCAC_CD = @[scac_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bl_no} != '')" ).append("\n"); 
		query.append("                   AND BLR.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${fromd} != '')" ).append("\n"); 
		query.append("                   AND LOG.RCV_DT >= TO_DATE(REPLACE(REPLACE(@[fromd], '-', ''), '/', '') ||' '|| REPLACE(REPLACE(@[fromt], ':', ''), '-',''),'YYYYMMDD HH24MI')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${tod} != '')" ).append("\n"); 
		query.append("                   AND LOG.RCV_DT <= TO_DATE(REPLACE(REPLACE(@[tod], '-', ''), '/', '') ||' '|| REPLACE(REPLACE(@[tot], ':', ''), '-',''),'YYYYMMDD HH24MI')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("               ) LOG" ).append("\n"); 
		query.append("         WHERE RNUM = 1" ).append("\n"); 
		query.append("     ) TB" ).append("\n"); 
		query.append("      ,BKG_CSTMS_ADV_BL BL" ).append("\n"); 
		query.append("      ,BKG_CSTMS_ADV_RSLT RS" ).append("\n"); 
		query.append(" WHERE TB.CNT_CD = BL.CNT_CD(+)" ).append("\n"); 
		query.append("   AND TB.BL_NO  = BL.BL_NO(+)" ).append("\n"); 
		query.append("   AND TB.CNT_CD = RS.CNT_CD(+)" ).append("\n"); 
		query.append("   AND TB.BL_NO  = RS.BL_NO(+)" ).append("\n"); 
		query.append("   AND TB.CSTMS_BAT_NO = RS.CSTMS_BAT_NO(+)" ).append("\n"); 
		query.append("     )" ).append("\n"); 
		query.append(" WHERE RNUM BETWEEN @[start_no] AND @[end_no]" ).append("\n"); 

	}
}