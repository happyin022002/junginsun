/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOSearchBkgCustEtcRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.27
*@LastModifier : 
*@LastVersion : 1.0
* 2015.05.27 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingReceiptDBDAOSearchBkgCustEtcRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOSearchBkgCustEtcRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ca_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration").append("\n"); 
		query.append("FileName : GeneralBookingReceiptDBDAOSearchBkgCustEtcRSQL").append("\n"); 
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
		query.append("SELECT BK.BKG_NO" ).append("\n"); 
		query.append("    , BK.BL_NO||NVL(BK.BL_TP_CD, DECODE(ISS.OBL_SRND_FLG, 'Y', 'S', NULL)) BL_NO" ).append("\n"); 
		query.append("    , BK.BL_TP_CD " ).append("\n"); 
		query.append("    , BK.BL_NO_TP" ).append("\n"); 
		query.append("    , BK.VSL_CD||BK.SKD_VOY_NO||SKD_DIR_CD BKG_VVD" ).append("\n"); 
		query.append("    , BK.POR_CD " ).append("\n"); 
		query.append("    , BK.POL_CD " ).append("\n"); 
		query.append("    , BK.POD_CD " ).append("\n"); 
		query.append("    , BK.DEL_CD " ).append("\n"); 
		query.append("    , BK.SC_NO" ).append("\n"); 
		query.append("	, BK.RFA_NO" ).append("\n"); 
		query.append("    , BK.SVC_SCP_CD" ).append("\n"); 
		query.append("    , BK.SAM_CNEE_NTFY_FLG" ).append("\n"); 
		query.append("    , BK.AGMT_ACT_CNT_CD  " ).append("\n"); 
		query.append("    , DECODE(BK.AGMT_ACT_CUST_SEQ,0,'',BK.AGMT_ACT_CUST_SEQ) AGMT_ACT_CUST_SEQ" ).append("\n"); 
		query.append("    , BK.KR_CSTMS_CUST_TP_CD KR_CSTMS_CUST_TP_CD" ).append("\n"); 
		query.append("    , BK.CUST_TO_ORD_FLG CUST_TO_ORD_FLG" ).append("\n"); 
		query.append("    , BK.SAM_CNEE_NTFY_FLG" ).append("\n"); 
		query.append("    , BL.ORG_CNT_NM" ).append("\n"); 
		query.append("    , FF.CUST_REF_NO_CTNT FF_REF_NO" ).append("\n"); 
		query.append("    , FMC.CUST_REF_NO_CTNT FMC_CD" ).append("\n"); 
		query.append("    , '' FROB_FLAG" ).append("\n"); 
		query.append("	, '' NL_FLAG" ).append("\n"); 
		query.append("    , BK.BKG_STS_CD" ).append("\n"); 
		query.append("    , DECODE(NVL(BL.CORR_NO, 'N'), 'N', 'N', 'Y') CA_FLG" ).append("\n"); 
		query.append("    , BK.INDIV_PSON_FLG" ).append("\n"); 
		query.append("	, BK.OB_SLS_OFC_CD" ).append("\n"); 
		query.append("	, BK.OB_SREP_CD" ).append("\n"); 
		query.append("    , BK.DE_TERM_CD" ).append("\n"); 
		query.append("    , (SELECT ATTR_CTNT2 " ).append("\n"); 
		query.append("         FROM BKG_HRD_CDG_CTNT " ).append("\n"); 
		query.append("        WHERE BK.POD_CD = ATTR_CTNT1 " ).append("\n"); 
		query.append("          AND HRD_CDG_ID = 'CUSTOMER_EML_INFO') EML_INFO" ).append("\n"); 
		query.append("	, NVL((SELECT MAX('Y') " ).append("\n"); 
		query.append("			 FROM BKG_HIS_MST MST" ).append("\n"); 
		query.append("			WHERE MST.BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("		      AND BKG_HIS_ISS_UI_ID IN ('ESM_BKG_0079_05','ESM_BKG_0229'))" ).append("\n"); 
		query.append("		, 'N') JP24_ALERT_FLG" ).append("\n"); 
		query.append("    , (SELECT TO_CHAR(APPL_DT, 'YYYY-MM-DD') APPL_DT" ).append("\n"); 
		query.append("         FROM " ).append("\n"); 
		query.append("            (SELECT 1 RANK, RT_APLY_DT APPL_DT --rate applicable" ).append("\n"); 
		query.append("#if (${ca_flg}== 'Y')" ).append("\n"); 
		query.append("              FROM BKG_RT_HIS R" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("              FROM BKG_RATE R" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("             WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("               AND RT_APLY_DT IS NOT NULL" ).append("\n"); 
		query.append("            UNION ALL" ).append("\n"); 
		query.append("            SELECT 2 RANK, SKD.VPS_ETD_DT APPL_DT --onboard date" ).append("\n"); 
		query.append("              FROM VSK_VSL_PORT_SKD SKD" ).append("\n"); 
		query.append("#if (${ca_flg}== 'Y')" ).append("\n"); 
		query.append("			, BKG_BKG_HIS BK, BKG_VVD_HIS VVD" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("			, BKG_BOOKING BK, BKG_VVD VVD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("             WHERE BK.BKG_NO          = @[bkg_no]   " ).append("\n"); 
		query.append("               AND BK.BKG_NO          = VVD.BKG_NO" ).append("\n"); 
		query.append("               AND VVD.VSL_PRE_PST_CD IN ('S', 'T')" ).append("\n"); 
		query.append("               AND VVD.POL_CD         = BK.POL_CD" ).append("\n"); 
		query.append("               AND VVD.VSL_CD         = SKD.VSL_CD" ).append("\n"); 
		query.append("               AND VVD.SKD_VOY_NO     = SKD.SKD_VOY_NO" ).append("\n"); 
		query.append("               AND VVD.SKD_DIR_CD     = SKD.SKD_DIR_CD" ).append("\n"); 
		query.append("               AND VVD.POL_CD         = SKD.VPS_PORT_CD" ).append("\n"); 
		query.append("               AND VVD.POL_CLPT_IND_SEQ = SKD.CLPT_IND_SEQ" ).append("\n"); 
		query.append("            UNION ALL  " ).append("\n"); 
		query.append("            SELECT 3 RANK, SYSDATE APPL_DT" ).append("\n"); 
		query.append("              FROM DUAL)  " ).append("\n"); 
		query.append("        WHERE ROWNUM = 1) APPL_DT" ).append("\n"); 
		query.append("    , BKG_CGO_EU_CHK_FNC(@[bkg_no],@[ca_flg]) EU24_FLG" ).append("\n"); 
		query.append("	, '' DOC_TP_CD" ).append("\n"); 
		query.append("	, NVL((SELECT 'Y' " ).append("\n"); 
		query.append("#if (${ca_flg}== 'Y')" ).append("\n"); 
		query.append("	         FROM BKG_VVD_HIS " ).append("\n"); 
		query.append("	        WHERE CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	         FROM BKG_VVD " ).append("\n"); 
		query.append("	        WHERE 1=1" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("              AND BKG_NO = BK.BKG_NO " ).append("\n"); 
		query.append("	          AND SUBSTR(POD_CD,1,2) = 'JP'" ).append("\n"); 
		query.append("	          AND ROWNUM = 1" ).append("\n"); 
		query.append("	       ),'N') KR_CSTMS_CUST_TP_CD_USE_FLG" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${ca_flg}== 'Y')" ).append("\n"); 
		query.append("  FROM BKG_BKG_HIS BK" ).append("\n"); 
		query.append("      , BKG_BL_DOC_HIS BL" ).append("\n"); 
		query.append("	  , BKG_BL_ISS ISS" ).append("\n"); 
		query.append("      , BKG_REF_HIS FF" ).append("\n"); 
		query.append("      , BKG_REF_HIS FMC" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("  FROM BKG_BOOKING BK" ).append("\n"); 
		query.append("      , BKG_BL_DOC BL" ).append("\n"); 
		query.append("	  , BKG_BL_ISS ISS" ).append("\n"); 
		query.append("      , BKG_REFERENCE FF" ).append("\n"); 
		query.append("      , BKG_REFERENCE FMC" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" WHERE BK.BKG_NO = BL.BKG_NO" ).append("\n"); 
		query.append("   AND BK.BKG_NO = ISS.BKG_NO(+)" ).append("\n"); 
		query.append("   AND BK.BKG_NO = FF.BKG_NO(+)" ).append("\n"); 
		query.append("   AND 'FFNO'    = FF.BKG_REF_TP_CD(+)" ).append("\n"); 
		query.append("   AND BK.BKG_NO = FMC.BKG_NO(+)" ).append("\n"); 
		query.append("   AND 'FMCN'    = FMC.BKG_REF_TP_CD(+)" ).append("\n"); 
		query.append("   AND BK.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#if (${ca_flg}== 'Y')" ).append("\n"); 
		query.append("AND   BK.CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("AND   BL.CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}