/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : UsaManifestListDownloadDBDAOsearchCustomsResultRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.09.03
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2015.09.03 김민정
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Minjung Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaManifestListDownloadDBDAOsearchCustomsResultRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * UsaBlCustomsResultVO
	  * </pre>
	  */
	public UsaManifestListDownloadDBDAOsearchCustomsResultRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.usa.integration").append("\n"); 
		query.append("FileName : UsaManifestListDownloadDBDAOsearchCustomsResultRSQL").append("\n"); 
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
		query.append("SELECT 0 SEQ" ).append("\n"); 
		query.append("      ,BL_NO" ).append("\n"); 
		query.append("      ,DSPO_CD" ).append("\n"); 
		query.append("      ,SCAC_CD" ).append("\n"); 
		query.append("      ,IBD_REF_NO" ).append("\n"); 
		query.append("      ,CNTR_QTY" ).append("\n"); 
		query.append("      ,ENTR_TP_NO" ).append("\n"); 
		query.append("      ,ENTR_NO" ).append("\n"); 
		query.append("      ,RCV_LOC_CD" ).append("\n"); 
		query.append("      ,VVD" ).append("\n"); 
		query.append("      ,CSTMS_BAT_NO" ).append("\n"); 
		query.append("      ,CSTMS_RMK" ).append("\n"); 
		query.append("      ,CSTMS_CLR_CD" ).append("\n"); 
		query.append("      ,RCV_MSG_TP_ID" ).append("\n"); 
		query.append("      ,IO_BND_CD" ).append("\n"); 
		query.append("      ,RCV_SEQ" ).append("\n"); 
		query.append("      ,POL_CD" ).append("\n"); 
		query.append("      ,POD_CD" ).append("\n"); 
		query.append("      ,RCV_DATE" ).append("\n"); 
		query.append("      ,RJCT_FLG" ).append("\n"); 
		query.append("	  ,CSTMS_LOC_DIFF_FLG" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT RS.BL_NO" ).append("\n"); 
		query.append("              ,RS.CSTMS_SEQ" ).append("\n"); 
		query.append("              ,RS.DSPO_CD" ).append("\n"); 
		query.append("              ,RS.IBD_REF_NO" ).append("\n"); 
		query.append("              ,RS.CNTR_QTY" ).append("\n"); 
		query.append("              ,RS.ENTR_TP_NO" ).append("\n"); 
		query.append("              ,RS.ENTR_NO" ).append("\n"); 
		query.append("              ,RS.RCV_LOC_CD" ).append("\n"); 
		query.append("              ,RS.VSL_CD||RS.SKD_VOY_NO||RS.SKD_DIR_CD AS VVD" ).append("\n"); 
		query.append("              ,RS.CSTMS_BAT_NO" ).append("\n"); 
		query.append("              ,TRIM(RS.CSTMS_RMK1) || ' ' || TRIM(RS.CSTMS_RMK2) || ' ' || TRIM(RS.CSTMS_RMK3) AS CSTMS_RMK" ).append("\n"); 
		query.append("              ,RS.CSTMS_CLR_CD" ).append("\n"); 
		query.append("              ,(CASE WHEN RS.DSPO_CD != 'RC' THEN NVL(RM.SCAC_CD, COM_ConstantMgr_PKG.COM_getScacCode_FNC())" ).append("\n"); 
		query.append("                     ELSE RM.SCAC_CD" ).append("\n"); 
		query.append("                 END ) SCAC_CD" ).append("\n"); 
		query.append("              ,RM.RCV_MSG_TP_ID" ).append("\n"); 
		query.append("              ,RM.IO_BND_CD" ).append("\n"); 
		query.append("              ,RM.RCV_SEQ" ).append("\n"); 
		query.append("              ,RM.POL_CD" ).append("\n"); 
		query.append("              ,RM.POD_CD" ).append("\n"); 
		query.append("              ,TO_CHAR(RS.ARR_DT, 'YYYYMMDDHH24MISS') AS RCV_DATE" ).append("\n"); 
		query.append("              ,'N' AS RJCT_FLG" ).append("\n"); 
		query.append("			  ,NVL(RS.CSTMS_LOC_DIFF_FLG , 'N') AS CSTMS_LOC_DIFF_FLG" ).append("\n"); 
		query.append("          FROM BKG_CSTMS_ADV_RSLT  RS" ).append("\n"); 
		query.append("              ,BKG_CSTMS_ADV_RCV_LOG RM" ).append("\n"); 
		query.append("         WHERE RS.BL_NO  = @[bl_no]" ).append("\n"); 
		query.append("           AND RS.CNT_CD = @[cnt_cd]" ).append("\n"); 
		query.append("           AND RS.CNT_CD = RM.CNT_CD" ).append("\n"); 
		query.append("           AND RS.BL_NO  = RM.BL_NO" ).append("\n"); 
		query.append("           AND RS.ARR_DT = RM.RCV_DT" ).append("\n"); 
		query.append("           AND RS.CSTMS_BAT_NO = RM.CSTMS_BAT_NO" ).append("\n"); 
		query.append("           AND RM.IO_BND_CD = 'I'" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT BL_NO" ).append("\n"); 
		query.append("              ,0 AS CSTMS_SEQ" ).append("\n"); 
		query.append("              ,DSPO_CD" ).append("\n"); 
		query.append("              ,'' AS IBD_REF_NO" ).append("\n"); 
		query.append("              ,NULL AS CNTR_QTY" ).append("\n"); 
		query.append("              ,'' AS ENTR_TP_NO" ).append("\n"); 
		query.append("              ,'' AS ENTR_NO" ).append("\n"); 
		query.append("              ,RCV_LOC_CD" ).append("\n"); 
		query.append("              ,VVD" ).append("\n"); 
		query.append("              ,CSTMS_BAT_NO" ).append("\n"); 
		query.append("              ,CSTMS_RMK" ).append("\n"); 
		query.append("              ,'' AS CSTMS_CLR_CD" ).append("\n"); 
		query.append("              ,SCAC_CD" ).append("\n"); 
		query.append("              ,RCV_MSG_TP_ID" ).append("\n"); 
		query.append("              ,IO_BND_CD" ).append("\n"); 
		query.append("              ,RCV_SEQ" ).append("\n"); 
		query.append("              ,'' AS POL_CD" ).append("\n"); 
		query.append("              ,'' AS POD_CD" ).append("\n"); 
		query.append("              ,RCV_DATE" ).append("\n"); 
		query.append("              ,DECODE(CSTMS_RMK, NULL, 'N', 'Y') AS RJCT_FLG" ).append("\n"); 
		query.append("              ,'N' AS CSTMS_LOC_DIFF_FLG" ).append("\n"); 
		query.append("          FROM (" ).append("\n"); 
		query.append("                SELECT BL_NO" ).append("\n"); 
		query.append("                      ,DSPO_CD" ).append("\n"); 
		query.append("                      ,RCV_LOC_CD" ).append("\n"); 
		query.append("                      ,VVD" ).append("\n"); 
		query.append("                      ,CSTMS_BAT_NO" ).append("\n"); 
		query.append("                      ,MAX(CSTMS_RMK) AS CSTMS_RMK" ).append("\n"); 
		query.append("                      ,SCAC_CD" ).append("\n"); 
		query.append("                      ,RCV_MSG_TP_ID" ).append("\n"); 
		query.append("                      ,IO_BND_CD" ).append("\n"); 
		query.append("                      ,RCV_SEQ" ).append("\n"); 
		query.append("                      ,RCV_DATE" ).append("\n"); 
		query.append("                  FROM (" ).append("\n"); 
		query.append("                SELECT RSPN.BL_NO" ).append("\n"); 
		query.append("                      ,LOG.RCV_MSG_TP_ID AS DSPO_CD" ).append("\n"); 
		query.append("                      ,LOG.POD_CD AS RCV_LOC_CD" ).append("\n"); 
		query.append("                      ,LOG.VSL_CD || LOG.SKD_VOY_NO || LOG.SKD_DIR_CD AS VVD" ).append("\n"); 
		query.append("                      ,LOG.CSTMS_BAT_NO" ).append("\n"); 
		query.append("                      ,BKG_JOIN_FNC((CURSOR(SELECT SUBSTR(DTL.MSG_DESC, 40)" ).append("\n"); 
		query.append("		                                      FROM BKG_CSTMS_ADV_RCV_LOG_DTL DTL" ).append("\n"); 
		query.append("		                                     WHERE LOG.CNT_CD     = DTL.CNT_CD" ).append("\n"); 
		query.append("		                                       AND LOG.IO_BND_CD  = DTL.IO_BND_CD" ).append("\n"); 
		query.append("		                                       AND LOG.RCV_DT     = DTL.RCV_DT" ).append("\n"); 
		query.append("		                                       AND LOG.RCV_SEQ    = DTL.RCV_SEQ" ).append("\n"); 
		query.append("		                                       AND (DTL.MSG_DESC   LIKE 'W01 %'" ).append("\n"); 
		query.append("                                                   OR DTL.MSG_DESC LIKE 'W01' || RSPN.BL_NO || '%'" ).append("\n"); 
		query.append("                                                   OR DTL.MSG_DESC LIKE 'W01' || CNTR.CNTR_NO || '%')" ).append("\n"); 
		query.append("                                             GROUP BY DTL.RCV_MSG_DTL_SEQ, DTL.MSG_DESC" ).append("\n"); 
		query.append("                                             ORDER BY DTL.RCV_MSG_DTL_SEQ" ).append("\n"); 
		query.append("		                                   )" ).append("\n"); 
		query.append("		                              ), CHR(10)) AS CSTMS_RMK" ).append("\n"); 
		query.append("                      ,LOG.SCAC_CD" ).append("\n"); 
		query.append("                      ,LOG.RCV_MSG_TP_ID" ).append("\n"); 
		query.append("                      ,LOG.IO_BND_CD" ).append("\n"); 
		query.append("                      ,LOG.RCV_SEQ" ).append("\n"); 
		query.append("                      ,TO_CHAR(LOG.RCV_DT, 'YYYYMMDDHH24MISS') AS RCV_DATE" ).append("\n"); 
		query.append("                  FROM BKG_CSTMS_ADV_EDI_BL_RSPN RSPN" ).append("\n"); 
		query.append("                      ,BKG_CSTMS_ADV_RCV_LOG     LOG" ).append("\n"); 
		query.append("                      ,BKG_CSTMS_ADV_CNTR        CNTR" ).append("\n"); 
		query.append("                 WHERE 1=1" ).append("\n"); 
		query.append("                   AND RSPN.CNT_CD     = LOG.CNT_CD" ).append("\n"); 
		query.append("                   AND RSPN.CRR_BAT_NO = LOG.CRR_BAT_NO" ).append("\n"); 
		query.append("                   AND RSPN.CNT_CD     = @[cnt_cd]" ).append("\n"); 
		query.append("                   AND RSPN.BL_NO      = @[bl_no]" ).append("\n"); 
		query.append("                   AND RSPN.CNT_CD     = CNTR.CNT_CD" ).append("\n"); 
		query.append("                   AND RSPN.BL_NO      = CNTR.BL_NO" ).append("\n"); 
		query.append("                    )" ).append("\n"); 
		query.append("              GROUP BY BL_NO" ).append("\n"); 
		query.append("                      ,DSPO_CD" ).append("\n"); 
		query.append("                      ,RCV_LOC_CD" ).append("\n"); 
		query.append("                      ,VVD" ).append("\n"); 
		query.append("                      ,CSTMS_BAT_NO" ).append("\n"); 
		query.append("                      ,SCAC_CD" ).append("\n"); 
		query.append("                      ,RCV_MSG_TP_ID" ).append("\n"); 
		query.append("                      ,IO_BND_CD" ).append("\n"); 
		query.append("                      ,RCV_SEQ" ).append("\n"); 
		query.append("                      ,RCV_DATE" ).append("\n"); 
		query.append("               )" ).append("\n"); 
		query.append("     )RSLT" ).append("\n"); 
		query.append("ORDER BY RSLT.RCV_DATE, RSLT.CSTMS_SEQ, RSLT.ENTR_TP_NO, RSLT.DSPO_CD" ).append("\n"); 

	}
}