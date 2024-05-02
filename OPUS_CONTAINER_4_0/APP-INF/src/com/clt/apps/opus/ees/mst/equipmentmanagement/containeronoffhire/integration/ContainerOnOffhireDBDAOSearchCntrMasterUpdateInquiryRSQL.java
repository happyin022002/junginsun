/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ContainerOnOffhireDBDAOSearchCntrMasterUpdateInquiryRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.11.08
*@LastModifier : 이주현
*@LastVersion : 1.0
* 2016.11.08 이주현
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author LEE JU HYUN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerOnOffhireDBDAOSearchCntrMasterUpdateInquiryRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchCntrMasterUpdateInquiry
	  * </pre>
	  */
	public ContainerOnOffhireDBDAOSearchCntrMasterUpdateInquiryRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.integration").append("\n"); 
		query.append("FileName : ContainerOnOffhireDBDAOSearchCntrMasterUpdateInquiryRSQL").append("\n"); 
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
		query.append("WITH PPARAM" ).append("\n"); 
		query.append("AS " ).append("\n"); 
		query.append("(SELECT /*+ INDEX( A XPKMST_CONTAINER) */" ).append("\n"); 
		query.append("                 CNTR_NO " ).append("\n"); 
		query.append("                 FROM MST_CONTAINER A" ).append("\n"); 
		query.append("                 WHERE 1 = 1" ).append("\n"); 
		query.append("                 ##${cntr_no}" ).append("\n"); 
		query.append("                 #if ($cntr_no.length() == 10) " ).append("\n"); 
		query.append("                 AND   A.CNTR_NO LIKE @[cntr_no] || '%'" ).append("\n"); 
		query.append("                 #end " ).append("\n"); 
		query.append("                 ##${cntr_no}" ).append("\n"); 
		query.append("                 #if ($cntr_no.length() != 10) " ).append("\n"); 
		query.append("                 AND   A.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("                 #end " ).append("\n"); 
		query.append("                 AND CNMV_DT = (" ).append("\n"); 
		query.append("                               SELECT MAX(CNMV_DT) " ).append("\n"); 
		query.append("                               FROM MST_CONTAINER " ).append("\n"); 
		query.append("                               WHERE 1 = 1" ).append("\n"); 
		query.append("                               ##${cntr_no}" ).append("\n"); 
		query.append("                               #if ($cntr_no.length() == 10) " ).append("\n"); 
		query.append("                               AND   CNTR_NO LIKE @[cntr_no] || '%'" ).append("\n"); 
		query.append("                               #end " ).append("\n"); 
		query.append("                               ##${cntr_no}" ).append("\n"); 
		query.append("                               #if ($cntr_no.length() != 10) " ).append("\n"); 
		query.append("                               AND   CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("                               #end " ).append("\n"); 
		query.append("                               )" ).append("\n"); 
		query.append("                 AND ROWNUM = 1 " ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("    SELECT" ).append("\n"); 
		query.append("        A.CNTR_NO," ).append("\n"); 
		query.append("        SUBSTR(A.CNTR_NO,11) CHK_DGT," ).append("\n"); 
		query.append("        DECODE(A.ACIAC_DIV_CD, 'I', 'Inactive','A','Active') ACIAC_DIV_CD," ).append("\n"); 
		query.append("        A.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("        B.CNTR_TPSZ_ISO_CD," ).append("\n"); 
		query.append("        A.CNTR_MTRL_CD," ).append("\n"); 
		query.append("		E.TARE_WGT," ).append("\n"); 
		query.append("		E.CNTR_GRS_WGT," ).append("\n"); 
		query.append("        E.CNTR_SPEC_NO," ).append("\n"); 
		query.append("        ROUND(TO_NUMBER(E.TARE_WGT) * 2.2046) TARE_WGT_LBS," ).append("\n"); 
		query.append("		ROUND(TO_NUMBER(E.CNTR_GRS_WGT) * 2.2046) CNTR_GRS_WGT_LBS," ).append("\n"); 
		query.append("        A.LSTM_CD," ).append("\n"); 
		query.append("	    CASE WHEN A.ACIAC_DIV_CD = 'I' THEN " ).append("\n"); 
		query.append("	         CASE WHEN F.CNTR_STS_CD IN ('SBO', 'MUO', 'SBI', 'MUI') THEN (SELECT X.LSTM_CD " ).append("\n"); 
		query.append("	                                                                       FROM LSE_AGREEMENT X " ).append("\n"); 
		query.append("	                                                                       WHERE  F.AGMT_CTY_CD = X.AGMT_CTY_CD" ).append("\n"); 
		query.append("                                                                           AND    F.AGMT_SEQ    = X.AGMT_SEQ)" ).append("\n"); 
		query.append("	         ELSE A.LSTM_CD END" ).append("\n"); 
		query.append("	    ELSE A.LSTM_CD END SUB_LSTM_CD,              " ).append("\n"); 
		query.append("        COM_CONSTANTMGR_PKG.COM_getCompanyName_FNC() AS CNTR_USE_CO_CD," ).append("\n"); 
		query.append("        NVL(( SELECT COM_CONSTANTMGR_PKG.COM_getCompanyName_FNC()" ).append("\n"); 
		query.append("             FROM MNR_TTL_LSS_RQST_HDR TH" ).append("\n"); 
		query.append("                , MNR_TTL_LSS_RQST_DTL TD" ).append("\n"); 
		query.append("            WHERE 1                   = 1" ).append("\n"); 
		query.append("              AND    TH.TTL_LSS_STS_CD = 'HA'" ).append("\n"); 
		query.append("              AND    TH.TTL_LSS_NO      = TD.TTL_LSS_NO" ).append("\n"); 
		query.append("              AND    TD.RQST_EQ_NO    = A.CNTR_NO" ).append("\n"); 
		query.append("              AND    A.ONH_DT < TH.TTL_LSS_DT" ).append("\n"); 
		query.append("              AND    ROWNUM            = 1), DECODE(A.CNTR_STS_CD||A.CNMV_STS_CD||A.ACIAC_DIV_CD, 'OWNMTInactive', 'Not Receiving', D.VNDR_LGL_ENG_NM) " ).append("\n"); 
		query.append("        ) AS OWNR_CO_CD," ).append("\n"); 
		query.append("        A.MFTR_VNDR_SEQ VNDR_ABBR_NM," ).append("\n"); 
		query.append("        C.VNDR_ABBR_NM  VNDR_LGL_ENG_NM," ).append("\n"); 
		query.append("        TO_CHAR(A.MFT_DT, 'YYYY-MM-DD') MFT_DT," ).append("\n"); 
		query.append("        A.D2_PAYLD_FLG," ).append("\n"); 
		query.append("        A.RF_TP_CD," ).append("\n"); 
		query.append("        A.RF_HUMID_CTRL_VAL_CD," ).append("\n"); 
		query.append("        A.RF_CMPR_CTNT  ," ).append("\n"); 
		query.append("        D.VNDR_SEQ  AS LSR_CD," ).append("\n"); 
		query.append("        D.VNDR_LGL_ENG_NM AS LSR_NM," ).append("\n"); 
		query.append("		DECODE(E.CNTR_SPEC_TP_CD, 'O', 'Own', 'L', 'Lease', 'S', 'Standard') AS CNTR_SPEC_TP_CD" ).append("\n"); 
		query.append("    FROM " ).append("\n"); 
		query.append("    MST_CONTAINER A," ).append("\n"); 
		query.append("    MDM_CNTR_TP_SZ B," ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("        SELECT " ).append("\n"); 
		query.append("           BB.VNDR_ABBR_NM," ).append("\n"); 
		query.append("           BB.VNDR_LGL_ENG_NM," ).append("\n"); 
		query.append("           BB.VNDR_SEQ" ).append("\n"); 
		query.append("        FROM" ).append("\n"); 
		query.append("           MST_CONTAINER AA, " ).append("\n"); 
		query.append("           MDM_VENDOR BB," ).append("\n"); 
		query.append("           PPARAM P" ).append("\n"); 
		query.append("        WHERE AA.CNTR_NO = P.CNTR_NO" ).append("\n"); 
		query.append("        AND   AA.MFTR_VNDR_SEQ = BB.VNDR_SEQ" ).append("\n"); 
		query.append("    ) C," ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("        SELECT" ).append("\n"); 
		query.append("          AA.VNDR_SEQ," ).append("\n"); 
		query.append("          BB.VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("        FROM " ).append("\n"); 
		query.append("          MST_CONTAINER AA," ).append("\n"); 
		query.append("          MDM_VENDOR BB," ).append("\n"); 
		query.append("          PPARAM P" ).append("\n"); 
		query.append("        WHERE AA.CNTR_NO    = P.CNTR_NO" ).append("\n"); 
		query.append("        AND   AA.VNDR_SEQ   = BB.VNDR_SEQ" ).append("\n"); 
		query.append("    ) D," ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("        SELECT A.TARE_WGT, A.CNTR_GRS_WGT, A.PAY_LOAD, A.CNTR_SPEC_NO, A.CNTR_SPEC_TP_CD" ).append("\n"); 
		query.append("        FROM" ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("        SELECT MST_SPEC_FNC('TARE', @[cntr_no]) TARE_WGT," ).append("\n"); 
		query.append("               MST_SPEC_FNC('GRSS', @[cntr_no]) CNTR_GRS_WGT, " ).append("\n"); 
		query.append("			   MST_SPEC_FNC('PAYL', @[cntr_no]) PAY_LOAD," ).append("\n"); 
		query.append("B.CNTR_TPSZ_CD, B.CNTR_SPEC_NO, B.CNTR_SPEC_TP_CD" ).append("\n"); 
		query.append("        FROM MST_CNTR_SPEC B, MST_CONTAINER C, PPARAM P" ).append("\n"); 
		query.append("        WHERE 1 = 1 " ).append("\n"); 
		query.append("        AND   C.CNTR_NO = P.CNTR_NO" ).append("\n"); 
		query.append("        AND   C.CNTR_SPEC_NO = B.CNTR_SPEC_NO" ).append("\n"); 
		query.append("        ) A, " ).append("\n"); 
		query.append("        (SELECT A.CNTR_TPSZ_TARE_WGT, A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("         FROM MDM_CNTR_TP_SZ A, MST_CONTAINER C, PPARAM P" ).append("\n"); 
		query.append("         WHERE  1 = 1" ).append("\n"); 
		query.append("         AND   C.CNTR_NO = P.CNTR_NO" ).append("\n"); 
		query.append("         AND   A.CNTR_TPSZ_CD = C.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("        ) C   " ).append("\n"); 
		query.append("        WHERE" ).append("\n"); 
		query.append("          A.CNTR_TPSZ_CD(+) = C.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("    ) E," ).append("\n"); 
		query.append("    MST_CNTR_STS_HIS F, " ).append("\n"); 
		query.append("    LSE_AGREEMENT G," ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("        SELECT MAX(CNTR_STS_SEQ) MAX_STS_SEQ, A.CNTR_NO " ).append("\n"); 
		query.append("        FROM" ).append("\n"); 
		query.append("        MST_CNTR_STS_HIS A," ).append("\n"); 
		query.append("        PPARAM P" ).append("\n"); 
		query.append("        WHERE 1 = 1" ).append("\n"); 
		query.append("        AND    A.CNTR_NO = P.CNTR_NO" ).append("\n"); 
		query.append("        GROUP BY A.CNTR_NO" ).append("\n"); 
		query.append("    ) H," ).append("\n"); 
		query.append("    PPARAM P   " ).append("\n"); 
		query.append("    WHERE 1 = 1" ).append("\n"); 
		query.append("    AND A.CNTR_NO = P.CNTR_NO" ).append("\n"); 
		query.append("    AND H.CNTR_NO = A.CNTR_NO" ).append("\n"); 
		query.append("    AND H.CNTR_NO     = F.CNTR_NO" ).append("\n"); 
		query.append("    AND H.MAX_STS_SEQ = F.CNTR_STS_SEQ" ).append("\n"); 
		query.append("    AND G.AGMT_CTY_CD = A.AGMT_CTY_CD" ).append("\n"); 
		query.append("    AND G.AGMT_SEQ    = A.AGMT_SEQ" ).append("\n"); 
		query.append("    AND B.CNTR_TPSZ_CD  =    A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("    AND A.MFTR_VNDR_SEQ =    C.VNDR_SEQ(+)" ).append("\n"); 
		query.append("    AND A.VNDR_SEQ      =    D.VNDR_SEQ(+)" ).append("\n"); 

	}
}