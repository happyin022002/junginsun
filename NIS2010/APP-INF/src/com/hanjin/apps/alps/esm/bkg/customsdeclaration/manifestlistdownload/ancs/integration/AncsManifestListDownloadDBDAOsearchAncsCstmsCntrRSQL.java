/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : AncsManifestListDownloadDBDAOsearchAncsCstmsCntrRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.03.19
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2012.03.19 김경섭
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.ancs.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Gyoung Sub
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AncsManifestListDownloadDBDAOsearchAncsCstmsCntrRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * s
	  * </pre>
	  */
	public AncsManifestListDownloadDBDAOsearchAncsCstmsCntrRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.ancs.integration").append("\n"); 
		query.append("FileName : AncsManifestListDownloadDBDAOsearchAncsCstmsCntrRSQL").append("\n"); 
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
		query.append("SELECT CNTR.CNTR_NO ," ).append("\n"); 
		query.append("  CNTR.ANR_MSG_STS_CD ," ).append("\n"); 
		query.append("  DECODE(NVL(CNTR.ANR_MSG_STS_CD, 'N'), 'A', 'Y', 'N' ) AS BL_ACK ," ).append("\n"); 
		query.append("  CNTR.ORG_RCV_TERM_CD ," ).append("\n"); 
		query.append("  CNTR.DEST_DE_TERM_CD ," ).append("\n"); 
		query.append("  CNTR_LOG.SND_STS_CD || CNTR_LOG.RCV_STS_CD AS CNTR_LAST_EDI" ).append("\n"); 
		query.append("--,DECODE(NVL(CNTR_LOG.SND_STS_CD, 'N') || NVL(CNTR_LOG.RCV_STS_CD, 'N'),'NN','Initial','ON','SENDING', 'OA', 'Sent', 'OE', 'Error(O)', 'CN','Cancelling','CA','Cancelled','CE','Error(C)') CNTR_LAST_EDI2" ).append("\n"); 
		query.append("  ,CNTR_EDI_SND_RCV_STS.ATTR_CTNT2 AS CNTR_LAST_EDI2," ).append("\n"); 
		query.append("  CNTR.CNTR_TPSZ_CD ," ).append("\n"); 
		query.append("  CNTR.PCK_QTY ," ).append("\n"); 
		query.append("  CNTR.PCK_TP_CD ," ).append("\n"); 
		query.append("  CNTR.CNTR_WGT ," ).append("\n"); 
		query.append("  CNTR.WGT_UT_CD ," ).append("\n"); 
		query.append("  CNTR.BKG_NO ," ).append("\n"); 
		query.append("  CNTR.VSL_CD || CNTR.SKD_VOY_NO || CNTR.SKD_DIR_CD AS VVD" ).append("\n"); 
		query.append("FROM BKG_CSTMS_ANR_BL BL," ).append("\n"); 
		query.append("  BKG_CSTMS_ANR_CNTR CNTR," ).append("\n"); 
		query.append("  (     SELECT BB.BKG_NO," ).append("\n"); 
		query.append("      BB.CNTR_NO," ).append("\n"); 
		query.append("      AA.EDI_SND_STS_CD AS SND_STS_CD," ).append("\n"); 
		query.append("      BB.EDI_RCV_STS_CD AS RCV_STS_CD" ).append("\n"); 
		query.append("    FROM BKG_CSTMS_ANR_EDI_HIS AA," ).append("\n"); 
		query.append("      BKG_CSTMS_ANR_CNTR_LOG BB," ).append("\n"); 
		query.append("      (" ).append("\n"); 
		query.append("        SELECT D.MSG_TP_CD," ).append("\n"); 
		query.append("          D.ANR_DECL_NO," ).append("\n"); 
		query.append("          D.BKG_NO," ).append("\n"); 
		query.append("          D.CNTR_NO," ).append("\n"); 
		query.append("          MAX(D.REF_SEQ) MAX_REF_SEQ" ).append("\n"); 
		query.append("        FROM BKG_CSTMS_ANR_VVD A," ).append("\n"); 
		query.append("          BKG_CSTMS_ANR_BL B," ).append("\n"); 
		query.append("          BKG_CSTMS_ANR_EDI_HIS C," ).append("\n"); 
		query.append("          BKG_CSTMS_ANR_CNTR_LOG D" ).append("\n"); 
		query.append("        WHERE 1=1" ).append("\n"); 
		query.append("          AND B.VSL_CD = A.VSL_CD" ).append("\n"); 
		query.append("          AND B.SKD_VOY_NO = A.SKD_VOY_NO" ).append("\n"); 
		query.append("          AND B.SKD_DIR_CD = A.SKD_DIR_CD" ).append("\n"); 
		query.append("          AND B.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("          AND C.MSG_TP_CD = 'C'" ).append("\n"); 
		query.append("          AND C.ANR_DECL_NO = A.SVC_RQST_NO || A.LLOYD_TP_CD || A.LLOYD_NO" ).append("\n"); 
		query.append("          AND D.MSG_TP_CD = C.MSG_TP_CD" ).append("\n"); 
		query.append("          AND D.ANR_DECL_NO = C.ANR_DECL_NO" ).append("\n"); 
		query.append("          AND D.REF_SEQ = C.REF_SEQ" ).append("\n"); 
		query.append("          AND D.VSL_CD = B.VSL_CD" ).append("\n"); 
		query.append("          AND D.SKD_VOY_NO = B.SKD_VOY_NO" ).append("\n"); 
		query.append("          AND D.SKD_DIR_CD = B.SKD_DIR_CD" ).append("\n"); 
		query.append("          AND D.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("        GROUP BY D.MSG_TP_CD, D.ANR_DECL_NO, D.BKG_NO, D.CNTR_NO) CC" ).append("\n"); 
		query.append("    WHERE AA.MSG_TP_CD(+) = CC.MSG_TP_CD" ).append("\n"); 
		query.append("      AND AA.ANR_DECL_NO(+) = CC.ANR_DECL_NO" ).append("\n"); 
		query.append("      AND AA.REF_SEQ(+) = CC.MAX_REF_SEQ" ).append("\n"); 
		query.append("      AND BB.MSG_TP_CD(+) = CC.MSG_TP_CD" ).append("\n"); 
		query.append("      AND BB.ANR_DECL_NO(+) = CC.ANR_DECL_NO" ).append("\n"); 
		query.append("      AND BB.REF_SEQ(+) = CC.MAX_REF_SEQ" ).append("\n"); 
		query.append("      AND BB.BKG_NO(+) = CC.BKG_NO" ).append("\n"); 
		query.append("      AND BB.CNTR_NO(+) = CC.CNTR_NO ) CNTR_LOG," ).append("\n"); 
		query.append("  BKG_HRD_CDG_CTNT CNTR_EDI_SND_RCV_STS" ).append("\n"); 
		query.append("  , BKG_VVD A_VVD" ).append("\n"); 
		query.append("WHERE BL.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("  AND BL.VSL_CD = CNTR.VSL_CD" ).append("\n"); 
		query.append("  AND BL.SKD_VOY_NO = CNTR.SKD_VOY_NO" ).append("\n"); 
		query.append("  AND BL.SKD_DIR_CD = CNTR.SKD_DIR_CD" ).append("\n"); 
		query.append("  AND BL.BKG_NO = CNTR.BKG_NO" ).append("\n"); 
		query.append("  AND CNTR_LOG.CNTR_NO (+) = CNTR.CNTR_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  AND BL.BL_NO = A_VVD.BKG_NO" ).append("\n"); 
		query.append("  AND BL.VSL_CD = A_VVD.VSL_CD" ).append("\n"); 
		query.append("  AND BL.SKD_VOY_NO = A_VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("  AND BL.SKD_DIR_CD = A_VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  AND CNTR_EDI_SND_RCV_STS.HRD_CDG_ID(+) = 'ANR_CSTMS_EDI_STS_CD'" ).append("\n"); 
		query.append("  AND CNTR_EDI_SND_RCV_STS.ATTR_CTNT1(+) = NVL(CNTR_LOG.SND_STS_CD, 'N') || NVL(CNTR_LOG.RCV_STS_CD, 'N')" ).append("\n"); 

	}
}