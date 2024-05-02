/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : EBookingReceiptDBDAOSearchXterAkInterfaceRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.05.04
*@LastModifier : 
*@LastVersion : 1.0
* 2018.05.04 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EBookingReceiptDBDAOSearchXterAkInterfaceRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * external request 처리를 위해 external rqst의 awkward cgo 정보를 조회한다.
	  * 
	  * 2018.05.04 iylee Awkward Dimension 계산
	  * CNTR_TP : F2','P2','F4','P4','A4','A5','F5','O5 이면 External 값으로 계산
	  * CNTR_TP : S2','S4','O2','O4 Internal 값으로 계산
	  * </pre>
	  */
	public EBookingReceiptDBDAOSearchXterAkInterfaceRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xter_rqst_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xter_rqst_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xter_sndr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration").append("\n"); 
		query.append("FileName : EBookingReceiptDBDAOSearchXterAkInterfaceRSQL").append("\n"); 
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
		query.append("WITH AWK_DIM AS " ).append("\n"); 
		query.append("(SELECT " ).append("\n"); 
		query.append("	HRD_CDG_ID" ).append("\n"); 
		query.append(",	HRD_CDG_ID_SEQ" ).append("\n"); 
		query.append(",	ATTR_CTNT1" ).append("\n"); 
		query.append(",	ATTR_CTNT2" ).append("\n"); 
		query.append(",	ATTR_CTNT3" ).append("\n"); 
		query.append(",	ATTR_CTNT4" ).append("\n"); 
		query.append(",	ATTR_CTNT5" ).append("\n"); 
		query.append(",	ATTR_CTNT6" ).append("\n"); 
		query.append(",	ATTR_CTNT7" ).append("\n"); 
		query.append(",	ATTR_CTNT8" ).append("\n"); 
		query.append(",	ATTR_CTNT9" ).append("\n"); 
		query.append(",	ATTR_CTNT10" ).append("\n"); 
		query.append("FROM BKG_HRD_CDG_CTNT H" ).append("\n"); 
		query.append("WHERE H.HRD_CDG_ID = 'AWK_CRITERIA')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT AWK_CGO_SEQ," ).append("\n"); 
		query.append("       CNTR_NO," ).append("\n"); 
		query.append("       CNTR_TPSZ_CD," ).append("\n"); 
		query.append("       CMDT_CD," ).append("\n"); 
		query.append("       TTL_DIM_LEN," ).append("\n"); 
		query.append("       OVR_FWRD_LEN," ).append("\n"); 
		query.append("       OVR_FWRD_LEN AS OVR_BKWD_LEN," ).append("\n"); 
		query.append("       TTL_DIM_WDT," ).append("\n"); 
		query.append("       OVR_LF_LEN," ).append("\n"); 
		query.append("       OVR_LF_LEN AS OVR_RT_LEN," ).append("\n"); 
		query.append("       TTL_DIM_HGT," ).append("\n"); 
		query.append("       OVR_HGT," ).append("\n"); 
		query.append("       GRS_WGT," ).append("\n"); 
		query.append("       WGT_UT_CD," ).append("\n"); 
		query.append("       PCK_QTY," ).append("\n"); 
		query.append("       PCK_TP_CD," ).append("\n"); 
		query.append("       NET_WGT," ).append("\n"); 
		query.append("       STWG_RQST_DESC," ).append("\n"); 
		query.append("       CASE WHEN SUBSTR(CNTR_TPSZ_CD,2,1) = 2 AND OVR_LF_LEN > 0 AND OVR_RT_LEN > 0 AND OVR_HGT > 0 THEN 2.5" ).append("\n"); 
		query.append("            WHEN SUBSTR(CNTR_TPSZ_CD,2,1) = 2 AND OVR_LF_LEN > 0 AND OVR_RT_LEN > 0 AND OVR_HGT = 0 THEN 1" ).append("\n"); 
		query.append("            WHEN SUBSTR(CNTR_TPSZ_CD,2,1) = 2 AND OVR_LF_LEN > 0 AND OVR_RT_LEN = 0 AND OVR_HGT > 0 THEN 1.5" ).append("\n"); 
		query.append("            WHEN SUBSTR(CNTR_TPSZ_CD,2,1) = 2 AND OVR_LF_LEN = 0 AND OVR_RT_LEN > 0 AND OVR_HGT > 0 THEN 1.5" ).append("\n"); 
		query.append("            WHEN SUBSTR(CNTR_TPSZ_CD,2,1) = 2 AND OVR_LF_LEN > 0 AND OVR_RT_LEN = 0 AND OVR_HGT = 0 THEN 0.5" ).append("\n"); 
		query.append("            WHEN SUBSTR(CNTR_TPSZ_CD,2,1) = 2 AND OVR_LF_LEN = 0 AND OVR_RT_LEN > 0 AND OVR_HGT = 0 THEN 0.5" ).append("\n"); 
		query.append("            WHEN SUBSTR(CNTR_TPSZ_CD,2,1) = 2 AND OVR_LF_LEN = 0 AND OVR_RT_LEN = 0 AND OVR_HGT > 0 THEN 0.5" ).append("\n"); 
		query.append("            WHEN OVR_LF_LEN > 0 AND OVR_RT_LEN > 0 AND OVR_HGT > 0 THEN 5" ).append("\n"); 
		query.append("            WHEN OVR_LF_LEN > 0 AND OVR_RT_LEN > 0 AND OVR_HGT = 0 THEN 2" ).append("\n"); 
		query.append("            WHEN OVR_LF_LEN > 0 AND OVR_RT_LEN = 0 AND OVR_HGT > 0 THEN 3" ).append("\n"); 
		query.append("            WHEN OVR_LF_LEN = 0 AND OVR_RT_LEN > 0 AND OVR_HGT > 0 THEN 3" ).append("\n"); 
		query.append("            WHEN OVR_LF_LEN > 0 AND OVR_RT_LEN = 0 AND OVR_HGT = 0 THEN 1" ).append("\n"); 
		query.append("            WHEN OVR_LF_LEN = 0 AND OVR_RT_LEN > 0 AND OVR_HGT = 0 THEN 1" ).append("\n"); 
		query.append("            WHEN OVR_LF_LEN = 0 AND OVR_RT_LEN = 0 AND OVR_HGT > 0 THEN 1" ).append("\n"); 
		query.append("            ELSE 0" ).append("\n"); 
		query.append("       END OVR_VOID_SLT_QTY," ).append("\n"); 
		query.append("       CASE WHEN OVR_LF_LEN > 0 AND OVR_RT_LEN > 0 AND OVR_HGT > 0 THEN 'N'" ).append("\n"); 
		query.append("            WHEN OVR_LF_LEN > 0 AND OVR_RT_LEN > 0 AND OVR_HGT = 0 THEN 'N'" ).append("\n"); 
		query.append("            WHEN OVR_LF_LEN > 0 AND OVR_RT_LEN = 0 AND OVR_HGT > 0 THEN 'N'" ).append("\n"); 
		query.append("            WHEN OVR_LF_LEN = 0 AND OVR_RT_LEN > 0 AND OVR_HGT > 0 THEN 'N'" ).append("\n"); 
		query.append("            WHEN OVR_LF_LEN > 0 AND OVR_RT_LEN = 0 AND OVR_HGT = 0 THEN 'N'" ).append("\n"); 
		query.append("            WHEN OVR_LF_LEN = 0 AND OVR_RT_LEN > 0 AND OVR_HGT = 0 THEN 'N'" ).append("\n"); 
		query.append("            WHEN OVR_LF_LEN = 0 AND OVR_RT_LEN = 0 AND OVR_HGT > 0 THEN 'N'" ).append("\n"); 
		query.append("            ELSE 'Y'" ).append("\n"); 
		query.append("       END IN_GA_FLG," ).append("\n"); 
		query.append("       IBFLAG," ).append("\n"); 
		query.append("       AWK_DCGO_SEQ" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT AK.AWK_CGO_SEQ" ).append("\n"); 
		query.append("            , '' CNTR_NO" ).append("\n"); 
		query.append("            , AK.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("            , CASE WHEN AK.CMDT_CTNT IS NULL THEN M.CMDT_CD" ).append("\n"); 
		query.append("                   WHEN AK.CMDT_CTNT = (SELECT MC.CMDT_CD FROM MDM_COMMODITY MC WHERE MC.CMDT_CD = AK.CMDT_CTNT)" ).append("\n"); 
		query.append("                        THEN AK.CMDT_CTNT" ).append("\n"); 
		query.append("                   ELSE NVL((SELECT MC.CMDT_CD FROM MDM_COMMODITY MC WHERE MC.CMDT_NM = AK.CMDT_CTNT), M.CMDT_CD)" ).append("\n"); 
		query.append("              END CMDT_CD" ).append("\n"); 
		query.append("            , AK.OVR_LEN TTL_DIM_LEN" ).append("\n"); 
		query.append("            ,CASE WHEN AK.CNTR_TPSZ_CD IN ('F2','P2','F4','P4','A4','A5','F5','O5') AND ROUND((AK.OVR_LEN - AWK_DIM.ATTR_CTNT5)/2) > 0 THEN ROUND((AK.OVR_LEN - AWK_DIM.ATTR_CTNT5)/2) -- external" ).append("\n"); 
		query.append("                 WHEN AK.CNTR_TPSZ_CD IN ('S2','S4','O2','O4') AND ROUND((AK.OVR_LEN - AWK_DIM.ATTR_CTNT2)/2) > 0 THEN ROUND((AK.OVR_LEN - AWK_DIM.ATTR_CTNT2)/2) -- internal" ).append("\n"); 
		query.append("                 ELSE 0" ).append("\n"); 
		query.append("            END OVR_FWRD_LEN" ).append("\n"); 
		query.append("            , AK.OVR_WDT TTL_DIM_WDT" ).append("\n"); 
		query.append("            ,CASE WHEN AK.CNTR_TPSZ_CD IN ('F2','P2','F4','P4','A4','A5','F5','O5') AND (AK.OVR_WDT - ATTR_CTNT6)/2 > 0 THEN ROUND((AK.OVR_WDT - ATTR_CTNT6)/2) -- external" ).append("\n"); 
		query.append("                 WHEN AK.CNTR_TPSZ_CD IN ('S2','S4','O2','O4') AND ROUND((AK.OVR_WDT - AWK_DIM.ATTR_CTNT3)/2) > 0 THEN ROUND((AK.OVR_WDT - AWK_DIM.ATTR_CTNT3)/2) -- internal" ).append("\n"); 
		query.append("                 ELSE 0" ).append("\n"); 
		query.append("            END OVR_LF_LEN" ).append("\n"); 
		query.append("            , AK.OVR_HGT TTL_DIM_HGT" ).append("\n"); 
		query.append("            ,CASE WHEN AK.CNTR_TPSZ_CD IN ('F2','P2','F4','P4','A4','A5','F5','O5','S2','S4','O2','O4') AND AK.OVR_HGT - AWK_DIM.ATTR_CTNT4 > 0  THEN ROUND(AK.OVR_HGT - AWK_DIM.ATTR_CTNT4)" ).append("\n"); 
		query.append("                ELSE 0" ).append("\n"); 
		query.append("            END OVR_HGT" ).append("\n"); 
		query.append("            , AK.GRS_WGT" ).append("\n"); 
		query.append("            , AK.GRS_WGT_UT_CD WGT_UT_CD" ).append("\n"); 
		query.append("            , AK.PCK_QTY" ).append("\n"); 
		query.append("            , AK.PCK_TP_CD" ).append("\n"); 
		query.append("            , AK.NET_WGT" ).append("\n"); 
		query.append("            , replace(replace(AK.CGO_RMK,chr(10)||chr(13),' '),chr(10),' ') STWG_RQST_DESC" ).append("\n"); 
		query.append("            , 'N' AS IN_GA_FLG" ).append("\n"); 
		query.append("            , 'I' AS IBFLAG" ).append("\n"); 
		query.append("            , '' AS AWK_DCGO_SEQ " ).append("\n"); 
		query.append("      FROM BKG_XTER_AWK_CGO AK, BKG_XTER_RQST_MST M, AWK_DIM" ).append("\n"); 
		query.append("     WHERE AK.XTER_SNDR_ID = @[xter_sndr_id]" ).append("\n"); 
		query.append("       AND AK.XTER_RQST_NO = @[xter_rqst_no]" ).append("\n"); 
		query.append("       AND AK.XTER_RQST_SEQ= @[xter_rqst_seq]" ).append("\n"); 
		query.append("       AND M.XTER_SNDR_ID = AK.XTER_SNDR_ID" ).append("\n"); 
		query.append("       AND M.XTER_RQST_NO = AK.XTER_RQST_NO" ).append("\n"); 
		query.append("       AND M.XTER_RQST_SEQ = AK.XTER_RQST_SEQ" ).append("\n"); 
		query.append("	   AND AWK_DIM.ATTR_CTNT1 LIKE '%' || AK.CNTR_TPSZ_CD || '%'" ).append("\n"); 
		query.append("    )" ).append("\n"); 

	}
}