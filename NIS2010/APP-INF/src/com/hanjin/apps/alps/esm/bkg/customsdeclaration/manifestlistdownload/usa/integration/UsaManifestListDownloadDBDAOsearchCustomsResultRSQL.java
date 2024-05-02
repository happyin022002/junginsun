/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : UsaManifestListDownloadDBDAOsearchCustomsResultRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.19
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.19 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.integration").append("\n"); 
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
		query.append("SELECT 0 SEQ " ).append("\n"); 
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
		query.append("      ,CASE WHEN LENGTH(TRIM(CSTMS_RMK)) > 0 THEN CSTMS_RMK ELSE (SELECT TRIM(SUBSTR(X.MSG_DESC, 24))" ).append("\n"); 
		query.append("          FROM BKG_CSTMS_ADV_RCV_LOG_DTL X , BKG_CSTMS_ADV_BL BL" ).append("\n"); 
		query.append("          WHERE X.CNT_CD = @[cnt_cd]" ).append("\n"); 
		query.append("             AND X.IO_BND_CD = RSLT.IO_BND_CD " ).append("\n"); 
		query.append("             AND X.RCV_DT = RSLT.RCV_DT " ).append("\n"); 
		query.append("             AND X.RCV_SEQ = RSLT.RCV_SEQ " ).append("\n"); 
		query.append("             AND RSLT.DSPO_CD = '2Z'      " ).append("\n"); 
		query.append("             AND X.CNT_CD = BL.CNT_CD" ).append("\n"); 
		query.append("             AND RSLT.BL_NO = BL.BL_NO" ).append("\n"); 
		query.append("             AND BL.CSTMS_FILE_TP_CD = '2'" ).append("\n"); 
		query.append("             AND SUBSTR(X.MSG_DESC, 0, 3) = 'R02' " ).append("\n"); 
		query.append("             AND ( SUBSTR(X.MSG_DESC, 11, 1) = ' ' OR SUBSTR(X.MSG_DESC, 11, 4) = '0000' )" ).append("\n"); 
		query.append("            AND ROWNUM = 1" ).append("\n"); 
		query.append("       )  END CSTMS_RMK" ).append("\n"); 
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
		query.append("              ,TRIM(RS.CSTMS_RMK1) || ' ' || TRIM(RS.CSTMS_RMK2) || DECODE(RS.DSPO_CD, 'SN', ' ' || TRIM(RS.CSTMS_RMK3)) AS CSTMS_RMK" ).append("\n"); 
		query.append("              ,RS.CSTMS_CLR_CD" ).append("\n"); 
		query.append("              ,(CASE WHEN RS.DSPO_CD != 'RC' THEN NVL(RM.SCAC_CD, 'SMLM')" ).append("\n"); 
		query.append("                     ELSE RM.SCAC_CD" ).append("\n"); 
		query.append("                 END ) SCAC_CD" ).append("\n"); 
		query.append("              ,RM.RCV_MSG_TP_ID" ).append("\n"); 
		query.append("              ,RM.IO_BND_CD" ).append("\n"); 
		query.append("              ,RM.RCV_SEQ" ).append("\n"); 
		query.append("              ,RM.POL_CD" ).append("\n"); 
		query.append("              ,RM.POD_CD" ).append("\n"); 
		query.append("              ,TO_CHAR(RS.ARR_DT, 'YYYYMMDDHH24MISS') AS RCV_DATE" ).append("\n"); 
		query.append("              ,DECODE(SUBSTR(RD.MSG_DESC, 1, 3), 'W01', 'Y', 'N') AS RJCT_FLG" ).append("\n"); 
		query.append("			  ,NVL(RS.CSTMS_LOC_DIFF_FLG , 'N') AS CSTMS_LOC_DIFF_FLG" ).append("\n"); 
		query.append("              ,RD.RCV_DT" ).append("\n"); 
		query.append("              ,RD.RCV_MSG_DTL_SEQ" ).append("\n"); 
		query.append("          FROM BKG_CSTMS_ADV_RSLT  RS" ).append("\n"); 
		query.append("              ,BKG_CSTMS_ADV_RCV_LOG RM" ).append("\n"); 
		query.append("              ,BKG_CSTMS_ADV_RCV_LOG_DTL RD" ).append("\n"); 
		query.append("         WHERE RS.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("           AND RS.CNT_CD= @[cnt_cd]" ).append("\n"); 
		query.append("           AND RS.CNT_CD = RM.CNT_CD(+)" ).append("\n"); 
		query.append("           AND RM.IO_BND_CD(+) = 'I'" ).append("\n"); 
		query.append("           AND RS.VSL_CD = RM.VSL_CD(+)" ).append("\n"); 
		query.append("           AND RS.SKD_VOY_NO   = RM.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("           AND RS.SKD_DIR_CD   = RM.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("           AND RS.ARR_DT       = RM.RCV_DT(+)" ).append("\n"); 
		query.append("           AND RS.CSTMS_BAT_NO = RM.CSTMS_BAT_NO(+)" ).append("\n"); 
		query.append("           AND RM.CNT_CD       = RD.CNT_CD(+)" ).append("\n"); 
		query.append("           AND RM.IO_BND_CD    = RD.IO_BND_CD(+)" ).append("\n"); 
		query.append("           AND RM.RCV_DT       = RD.RCV_DT(+)" ).append("\n"); 
		query.append("           AND RM.RCV_SEQ      = RD.RCV_SEQ(+)" ).append("\n"); 
		query.append("           AND SUBSTR(RD.MSG_DESC(+), 1, 3) = 'ACR'" ).append("\n"); 
		query.append("           AND RD.RCV_MSG_DTL_SEQ(+)= 1" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT LOG.BL_NO" ).append("\n"); 
		query.append("              ,0 AS CSTMS_SEQ" ).append("\n"); 
		query.append("              ,'AR' AS DSPO_CD" ).append("\n"); 
		query.append("              ,'' AS IBD_REF_NO" ).append("\n"); 
		query.append("              ,0 AS CNTR_QTY" ).append("\n"); 
		query.append("              ,'' AS ENTR_TP_NO" ).append("\n"); 
		query.append("              ,'' AS ENTR_NO" ).append("\n"); 
		query.append("              ,LOG.POD_CD AS RCV_LOC_CD" ).append("\n"); 
		query.append("              ,LOG.VSL_CD || LOG.SKD_VOY_NO || LOG.SKD_DIR_CD AS VVD" ).append("\n"); 
		query.append("              ,DTL.CSTMS_BAT_NO" ).append("\n"); 
		query.append("              ,'' AS CSTMS_RMK" ).append("\n"); 
		query.append("              ,'N' AS CSTMS_CLR_CD" ).append("\n"); 
		query.append("              ,LOG.SCAC_CD" ).append("\n"); 
		query.append("              ,LOG.RCV_MSG_TP_ID" ).append("\n"); 
		query.append("              ,LOG.IO_BND_CD" ).append("\n"); 
		query.append("              ,LOG.RCV_SEQ" ).append("\n"); 
		query.append("              ,'' AS POL_CD" ).append("\n"); 
		query.append("              ,'' AS POD_CD" ).append("\n"); 
		query.append("              ,TO_CHAR(LOG.RCV_DT, 'YYYYMMDDHH24MISS') AS RCV_DATE" ).append("\n"); 
		query.append("              ,DECODE(SUBSTR(DTL.MSG_DESC, 1, 3), 'W01', 'Y', 'N') AS RJCT_FLG" ).append("\n"); 
		query.append("			  ,'N' AS CSTMS_LOC_DIFF_FLG" ).append("\n"); 
		query.append("              ,MAX(DTL.RCV_DT) RCV_DT" ).append("\n"); 
		query.append("              ,MAX(DTL.RCV_MSG_DTL_SEQ) RCV_MSG_DTL_SEQ" ).append("\n"); 
		query.append("          FROM BKG_CSTMS_ADV_EDI_BL_RSPN RSPN" ).append("\n"); 
		query.append("              ,BKG_CSTMS_ADV_RCV_LOG LOG" ).append("\n"); 
		query.append("              ,BKG_CSTMS_ADV_RCV_LOG_DTL DTL" ).append("\n"); 
		query.append("         WHERE 1=1" ).append("\n"); 
		query.append("           AND RSPN.CNT_CD = LOG.CNT_CD" ).append("\n"); 
		query.append("           AND RSPN.CRR_BAT_NO = LOG.CRR_BAT_NO" ).append("\n"); 
		query.append("           AND LOG.RCV_MSG_TP_ID = 'AR'" ).append("\n"); 
		query.append("           AND LOG.CNT_CD    = DTL.CNT_CD" ).append("\n"); 
		query.append("           AND LOG.IO_BND_CD = DTL.IO_BND_CD" ).append("\n"); 
		query.append("           AND LOG.RCV_DT    = DTL.RCV_DT" ).append("\n"); 
		query.append("           AND LOG.RCV_SEQ   = DTL.RCV_SEQ" ).append("\n"); 
		query.append("           AND RSPN.CNT_CD    = @[cnt_cd]" ).append("\n"); 
		query.append("           AND RSPN.BL_NO     = @[bl_no]" ).append("\n"); 
		query.append("           AND DTL.MSG_DESC LIKE 'W01' || @[bl_no] || '%'" ).append("\n"); 
		query.append("        GROUP BY" ).append("\n"); 
		query.append("               LOG.BL_NO" ).append("\n"); 
		query.append("              ,LOG.POD_CD" ).append("\n"); 
		query.append("              ,LOG.VSL_CD || LOG.SKD_VOY_NO || LOG.SKD_DIR_CD" ).append("\n"); 
		query.append("              ,DTL.CSTMS_BAT_NO" ).append("\n"); 
		query.append("              ,LOG.SCAC_CD" ).append("\n"); 
		query.append("              ,LOG.RCV_MSG_TP_ID" ).append("\n"); 
		query.append("              ,LOG.IO_BND_CD" ).append("\n"); 
		query.append("              ,LOG.RCV_SEQ" ).append("\n"); 
		query.append("              ,TO_CHAR(LOG.RCV_DT, 'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("              ,DECODE(SUBSTR(DTL.MSG_DESC, 1, 3), 'W01', 'Y', 'N')" ).append("\n"); 
		query.append("         UNION ALL" ).append("\n"); 
		query.append("        SELECT LOG.BL_NO" ).append("\n"); 
		query.append("              ,0 AS CSTMS_SEQ" ).append("\n"); 
		query.append("              ,'MR' AS DSPO_CD" ).append("\n"); 
		query.append("              ,'' AS IBD_REF_NO" ).append("\n"); 
		query.append("              ,0 AS CNTR_QTY" ).append("\n"); 
		query.append("              ,'' AS ENTR_TP_NO" ).append("\n"); 
		query.append("              ,'' AS ENTR_NO" ).append("\n"); 
		query.append("              ,LOG.POD_CD AS RCV_LOC_CD" ).append("\n"); 
		query.append("              ,LOG.VSL_CD || LOG.SKD_VOY_NO || LOG.SKD_DIR_CD AS VVD" ).append("\n"); 
		query.append("              ,DTL.CSTMS_BAT_NO" ).append("\n"); 
		query.append("              ,'' AS CSTMS_RMK" ).append("\n"); 
		query.append("              ,'N' AS CSTMS_CLR_CD" ).append("\n"); 
		query.append("              ,LOG.SCAC_CD" ).append("\n"); 
		query.append("              ,LOG.RCV_MSG_TP_ID" ).append("\n"); 
		query.append("              ,LOG.IO_BND_CD" ).append("\n"); 
		query.append("              ,LOG.RCV_SEQ" ).append("\n"); 
		query.append("              ,'' AS POL_CD" ).append("\n"); 
		query.append("              ,'' AS POD_CD" ).append("\n"); 
		query.append("              ,TO_CHAR(LOG.RCV_DT, 'YYYYMMDDHH24MISS') AS RCV_DATE" ).append("\n"); 
		query.append("              ,DECODE(SUBSTR(DTL.MSG_DESC, 1, 3), 'W01', 'Y', 'N') AS RJCT_FLG" ).append("\n"); 
		query.append("			  ,'N' AS CSTMS_LOC_DIFF_FLG" ).append("\n"); 
		query.append("              ,MAX(DTL.RCV_DT) RCV_DT" ).append("\n"); 
		query.append("              ,MAX(DTL.RCV_MSG_DTL_SEQ) RCV_MSG_DTL_SEQ" ).append("\n"); 
		query.append("          FROM BKG_CSTMS_ADV_EDI_BL_RSPN RSPN" ).append("\n"); 
		query.append("              ,BKG_CSTMS_ADV_RCV_LOG LOG" ).append("\n"); 
		query.append("              ,BKG_CSTMS_ADV_RCV_LOG_DTL DTL" ).append("\n"); 
		query.append("         WHERE 1=1" ).append("\n"); 
		query.append("           AND RSPN.CNT_CD = LOG.CNT_CD" ).append("\n"); 
		query.append("           AND RSPN.CRR_BAT_NO = LOG.CRR_BAT_NO" ).append("\n"); 
		query.append("           AND LOG.RCV_MSG_TP_ID = 'MR'" ).append("\n"); 
		query.append("           AND LOG.CNT_CD    = DTL.CNT_CD" ).append("\n"); 
		query.append("           AND LOG.IO_BND_CD = DTL.IO_BND_CD" ).append("\n"); 
		query.append("           AND LOG.RCV_DT    = DTL.RCV_DT" ).append("\n"); 
		query.append("           AND LOG.RCV_SEQ   = DTL.RCV_SEQ" ).append("\n"); 
		query.append("           AND RSPN.CNT_CD    = @[cnt_cd]" ).append("\n"); 
		query.append("           AND RSPN.BL_NO     = @[bl_no]" ).append("\n"); 
		query.append("           AND DTL.MSG_DESC LIKE 'W01%'" ).append("\n"); 
		query.append("        GROUP BY" ).append("\n"); 
		query.append("               LOG.BL_NO" ).append("\n"); 
		query.append("               ,LOG.POD_CD" ).append("\n"); 
		query.append("               ,LOG.VSL_CD || LOG.SKD_VOY_NO || LOG.SKD_DIR_CD" ).append("\n"); 
		query.append("               ,DTL.CSTMS_BAT_NO" ).append("\n"); 
		query.append("               ,LOG.SCAC_CD" ).append("\n"); 
		query.append("               ,LOG.RCV_MSG_TP_ID" ).append("\n"); 
		query.append("               ,LOG.IO_BND_CD" ).append("\n"); 
		query.append("               ,LOG.RCV_SEQ" ).append("\n"); 
		query.append("               ,TO_CHAR(LOG.RCV_DT, 'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("               ,DECODE(SUBSTR(DTL.MSG_DESC, 1, 3), 'W01', 'Y', 'N')" ).append("\n"); 
		query.append("     )RSLT" ).append("\n"); 
		query.append("ORDER BY RSLT.RCV_DATE, RSLT.CSTMS_SEQ, RSLT.ENTR_TP_NO, RSLT.DSPO_CD" ).append("\n"); 

	}
}