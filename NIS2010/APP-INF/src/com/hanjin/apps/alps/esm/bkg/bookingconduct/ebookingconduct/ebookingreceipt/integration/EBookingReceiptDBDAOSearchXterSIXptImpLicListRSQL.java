/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EBookingReceiptDBDAOSearchXterSIXptImpLicListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.10.14
*@LastModifier : Do Soon Choi
*@LastVersion : 1.0
* 2015.10.14 Do Soon Choi
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Do Soon Choi
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EBookingReceiptDBDAOSearchXterSIXptImpLicListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * alps의 export/import licens no를 조회한다.
	  * </pre>
	  */
	public EBookingReceiptDBDAOSearchXterSIXptImpLicListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xter_rqst_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration").append("\n"); 
		query.append("FileName : EBookingReceiptDBDAOSearchXterSIXptImpLicListRSQL").append("\n"); 
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
		query.append("SELECT  MST.BKG_NO" ).append("\n"); 
		query.append("       , 'O' IO_BND_CD" ).append("\n"); 
		query.append("       , '' XPT_IMP_SEQ" ).append("\n"); 
		query.append("       , CASE WHEN XX.XPT_LIC_NO IS NOT NULL THEN 'KR'" ).append("\n"); 
		query.append("              WHEN AES.AES_INLND_TRNS_NO IS NOT NULL OR AES.AES_PTA_NO1 IS NOT NULL OR AES.AES_PTA_NO2 IS NOT NULL " ).append("\n"); 
		query.append("                OR AES.AES_PTU_NO IS NOT NULL OR AES.AES_DWN_NO IS NOT NULL OR AES.AES_EXPT_CTNT IS NOT NULL THEN 'US'" ).append("\n"); 
		query.append("              WHEN SH.MX_TAX_ID IS NOT NULL OR CN.MX_TAX_ID IS NOT NULL OR NF.MX_TAX_ID IS NOT NULL THEN 'MX'" ).append("\n"); 
		query.append("              WHEN SH.TR_TAX_ID IS NOT NULL OR CN.TR_TAX_ID IS NOT NULL OR NF.TR_TAX_ID IS NOT NULL THEN 'TR'" ).append("\n"); 
		query.append("              WHEN SH.IL_TAX_ID IS NOT NULL OR CN.IL_TAX_ID IS NOT NULL OR NF.IL_TAX_ID IS NOT NULL THEN 'IL'" ).append("\n"); 
		query.append("              WHEN SH.LB_TAX_ID IS NOT NULL OR CN.LB_TAX_ID IS NOT NULL OR NF.LB_TAX_ID IS NOT NULL THEN 'LB'" ).append("\n"); 
		query.append("              WHEN SH.BRZ_TAX_ID IS NOT NULL OR CN.BRZ_TAX_ID IS NOT NULL OR NF.BRZ_TAX_ID IS NOT NULL THEN 'BR'" ).append("\n"); 
		query.append("              WHEN CAED.CAED_CTNT1 IS NOT NULL OR CAED.CAED_CTNT2 IS NOT NULL OR CAED.CAED_CTNT3 IS NOT NULL " ).append("\n"); 
		query.append("                OR CAED.G7_EDI_CTNT1 IS NOT NULL OR CAED.G7_EDI_CTNT2 IS NOT NULL " ).append("\n"); 
		query.append("                OR CAED.SMRY_RPT_CTNT1 IS NOT NULL OR CAED.SMRY_RPT_CTNT2 IS NOT NULL" ).append("\n"); 
		query.append("                OR CAED.B13A_CTNT1 IS NOT NULL OR CAED.B13A_CTNT2 IS NOT NULL " ).append("\n"); 
		query.append("                OR CAED.NON_DECL_CTNT IS NOT NULL OR CAED.MNL_INP_CTNT IS NOT NULL" ).append("\n"); 
		query.append("                OR CAED.INLND_TZ_CGO_CTNT IS NOT NULL THEN 'CA'" ).append("\n"); 
		query.append("              ELSE  '' END CNT_CD" ).append("\n"); 
		query.append("       , NVL(XX.XPT_LIC_NO, '') XPT_LIC_NO" ).append("\n"); 
		query.append("       , '' TS_REF_NO" ).append("\n"); 
		query.append("       , NVL(DECODE(XX.CGO_DIVD_FLG, 'Y', XX.DIVD_PCK_QTY, XX.PCK_QTY ) ,'') PCK_QTY" ).append("\n"); 
		query.append("       , NVL(DECODE(XX.CGO_DIVD_FLG, 'Y', XX.DIVD_PCK_TP_CD, XX.PCK_TP_CD ), '') PCK_TP_CD" ).append("\n"); 
		query.append("       , NVL(DECODE(XX.CGO_DIVD_FLG, 'Y', XX.DIVD_WGT, XX.CNTR_WGT ) ,'') MF_WGT" ).append("\n"); 
		query.append("       , NVL(DECODE(SUBSTR(DECODE(XX.CGO_DIVD_FLG, 'Y', XX.DIVD_WGT_UT_CD, XX.WGT_UT_CD ),1,1), 'K', 'KGS', DECODE(XX.CGO_DIVD_FLG, 'Y', XX.DIVD_WGT_UT_CD, XX.WGT_UT_CD ) ), '') WGT_UT_CD" ).append("\n"); 
		query.append("       , NVL(XX.CGO_DIVD_FLG,'') DIVD_FLG" ).append("\n"); 
		query.append("       , NVL(XX.DIVD_SEQ, '') DIVD_SEQ" ).append("\n"); 
		query.append("       , '' DIVD_PCK_QTY" ).append("\n"); 
		query.append("       , '' DIVD_PCK_TP_CD" ).append("\n"); 
		query.append("       , '' DIVD_WGT" ).append("\n"); 
		query.append("       , '' DIVD_WGT_UT_CD" ).append("\n"); 
		query.append("       , NVL(XX.STY_ID, '') SAM_PCK_ID" ).append("\n"); 
		query.append("       , NVL(XX.SAM_PCK_QTY ,'') SAM_PCK_QTY" ).append("\n"); 
		query.append("       , NVL(XX.SAM_PCK_TP_CD, '') SAM_PCK_TP_CD" ).append("\n"); 
		query.append("       , CASE WHEN AES.AES_INLND_TRNS_NO IS NOT NULL THEN 'AE'" ).append("\n"); 
		query.append("              WHEN AES.AES_PTA_NO1 IS NOT NULL OR AES.AES_PTA_NO2 IS NOT NULL THEN 'PA'" ).append("\n"); 
		query.append("              WHEN AES.AES_PTU_NO IS NOT NULL THEN 'PU' " ).append("\n"); 
		query.append("              WHEN AES.AES_DWN_NO IS NOT NULL THEN 'DN'" ).append("\n"); 
		query.append("              WHEN AES.AES_EXPT_CTNT IS NOT NULL THEN 'EX'" ).append("\n"); 
		query.append("              ELSE ''" ).append("\n"); 
		query.append("                END AES_TP_CD" ).append("\n"); 
		query.append("       , '' AES_INLND_TRNS_PFX_CTNT" ).append("\n"); 
		query.append("       , NVL(AES.AES_INLND_TRNS_NO, '') AES_INLND_TRNS_NO" ).append("\n"); 
		query.append("       , '' AES_PTA_PFX_CTNT" ).append("\n"); 
		query.append("       , NVL(AES.AES_PTA_NO1 ,'') AES_PTA_NO1" ).append("\n"); 
		query.append("       , NVL(AES.AES_PTA_NO2 ,'') AES_PTA_NO2" ).append("\n"); 
		query.append("       , TO_CHAR(NVL(AES.AES_PTA_DT, ''),'MM-DD-YYYY') AES_PTA_DT" ).append("\n"); 
		query.append("       , '' AES_PTU_PFX_CTNT" ).append("\n"); 
		query.append("       , NVL(AES.AES_PTU_NO,'') AES_PTU_NO" ).append("\n"); 
		query.append("       , TO_CHAR(NVL(AES.AES_PTU_DT,''),'MM-DD-YYYY') AES_PTU_DT" ).append("\n"); 
		query.append("       , '' AES_DWN_PFX_CTNT" ).append("\n"); 
		query.append("       , NVL(AES.AES_DWN_NO, '') AES_DWN_NO" ).append("\n"); 
		query.append("       , TO_CHAR(NVL(AES.AES_DWN_DT,''),'MM-DD-YYYY') AES_DWN_DT" ).append("\n"); 
		query.append("       , NVL(AES.AES_EXPT_ID, '') AES_EXPT_ID" ).append("\n"); 
		query.append("       , NVL(AES.AES_EXPT_CTNT, '') AES_EXPT_CTNT" ).append("\n"); 
		query.append("       , CASE WHEN CAED.CAED_CTNT1 IS NOT NULL OR CAED.CAED_CTNT2 IS NOT NULL OR CAED.CAED_CTNT3 IS NOT NULL THEN 'CE'" ).append("\n"); 
		query.append("              WHEN CAED.G7_EDI_CTNT1 IS NOT NULL OR CAED.G7_EDI_CTNT2 IS NOT NULL THEN 'G7'" ).append("\n"); 
		query.append("              WHEN CAED.SMRY_RPT_CTNT1 IS NOT NULL OR CAED.SMRY_RPT_CTNT2 IS NOT NULL THEN 'SM'" ).append("\n"); 
		query.append("              WHEN CAED.B13A_CTNT1 IS NOT NULL OR CAED.B13A_CTNT2 IS NOT NULL THEN 'EX'              " ).append("\n"); 
		query.append("              WHEN CAED.INLND_TZ_CGO_CTNT IS NOT NULL THEN 'IT' " ).append("\n"); 
		query.append("              WHEN CAED.MNL_INP_CTNT IS NOT NULL OR CAED.NON_DECL_CTNT IS NOT NULL THEN 'ND'" ).append("\n"); 
		query.append("              ELSE ''" ).append("\n"); 
		query.append("              END CAED_TP_CD" ).append("\n"); 
		query.append("       , ''CAED_PFX_CTNT" ).append("\n"); 
		query.append("       , CAED.CAED_CTNT1" ).append("\n"); 
		query.append("			||decode(nvl(CAED.CAED_CTNT2, 'x'), 'x', '', '-'||CAED.CAED_CTNT2)" ).append("\n"); 
		query.append("			||decode(nvl(CAED.CAED_CTNT3, 'x'), 'x', '', '-'||CAED.CAED_CTNT3)CAED_CTNT" ).append("\n"); 
		query.append("       , '' G7_EDI_PFX_CTNT" ).append("\n"); 
		query.append("       , CAED.G7_EDI_CTNT1" ).append("\n"); 
		query.append("			||decode(nvl(CAED.G7_EDI_CTNT2, 'x'), 'x', '', '-'||CAED.G7_EDI_CTNT2)" ).append("\n"); 
		query.append("             G7_EDI_CTNT" ).append("\n"); 
		query.append("       , '' B13A_XPT_PFX_CTNT" ).append("\n"); 
		query.append("       , TO_CHAR(CAED.B13A_DT, 'MM-DD-YYYY')" ).append("\n"); 
		query.append("			||decode(nvl(CAED.B13A_CTNT1, 'x'), 'x', '', '-'||CAED.B13A_CTNT1)" ).append("\n"); 
		query.append("			||decode(nvl(CAED.B13A_CTNT2, 'x'), 'x', '', '-'||CAED.B13A_CTNT2)" ).append("\n"); 
		query.append("             B13A_XPT_CTNT" ).append("\n"); 
		query.append("       , '' MF_SMRY_RPT_PFX_CTNT" ).append("\n"); 
		query.append("       , NVL( CAED.SMRY_RPT_CTNT1" ).append("\n"); 
		query.append("			||decode(nvl(CAED.SMRY_RPT_CTNT2, 'x'), 'x', '', '-'||CAED.SMRY_RPT_CTNT2) ,'') MF_SMRY_RPT_NO" ).append("\n"); 
		query.append("       , '' CGO_CTRL_PFX_CTNT" ).append("\n"); 
		query.append("       , NVL(CAED.INLND_TZ_CGO_CTNT, '') CGO_CTRL_NO" ).append("\n"); 
		query.append("       , '' NDR_REF_PFX_CTNT" ).append("\n"); 
		query.append("       , NVL(CAED.NON_DECL_CTNT, '' ) NDR_REF_ID" ).append("\n"); 
		query.append("       , NVL(CAED.MNL_INP_CTNT ,'') NDR_REF_CTNT" ).append("\n"); 
		query.append("	   , NVL(SH.MX_TAX_ID , '') MX_SHPR_TAX_ID" ).append("\n"); 
		query.append("	   , NVL(CN.MX_TAX_ID , '') MX_CNEE_TAX_ID" ).append("\n"); 
		query.append("	   , NVL(NF.MX_TAX_ID , '') MX_NTFY_TAX_ID" ).append("\n"); 
		query.append("	   , NVL(SH.TR_TAX_ID , '') TR_SHPR_TAX_ID" ).append("\n"); 
		query.append("       , NVL(CN.TR_TAX_ID , '') TR_CNEE_TAX_ID" ).append("\n"); 
		query.append("       , NVL(NF.TR_TAX_ID , '') TR_NTFY_TAX_ID" ).append("\n"); 
		query.append("	   , NVL(SH.IL_TAX_ID , '') IL_SHPR_TAX_ID" ).append("\n"); 
		query.append("       , NVL(CN.IL_TAX_ID , '') IL_CNEE_TAX_ID" ).append("\n"); 
		query.append("       , NVL(NF.IL_TAX_ID , '') IL_NTFY_TAX_ID" ).append("\n"); 
		query.append("	   , NVL(SH.LB_TAX_ID , '') LB_SHPR_TAX_ID" ).append("\n"); 
		query.append("       , NVL(CN.LB_TAX_ID , '') LB_CNEE_TAX_ID" ).append("\n"); 
		query.append("       , NVL(NF.LB_TAX_ID , '') LB_NTFY_TAX_ID" ).append("\n"); 
		query.append("       , NVL(SH.BRZ_TAX_ID, '') BR_SHPR_TAX_ID    -- Brazil 추가 " ).append("\n"); 
		query.append("       , NVL(CN.BRZ_TAX_ID, '') BR_CNEE_TAX_ID    -- Brazil 추가 " ).append("\n"); 
		query.append("       , NVL(NF.BRZ_TAX_ID, '') BR_NTFY_TAX_ID    -- Brazil 추가 " ).append("\n"); 
		query.append("       , '' BRZ_DECL_NO    -- Brazil 추가 " ).append("\n"); 
		query.append("       , '' SHPR_TAX_CPY_DESC_FLG " ).append("\n"); 
		query.append("       , '' CNEE_TAX_CPY_DESC_FLG" ).append("\n"); 
		query.append("       , '' NTFY_TAX_CPY_DESC_FLG" ).append("\n"); 
		query.append("       , '' BRZ_DECL_CPY_DESC_FLG " ).append("\n"); 
		query.append("	   , NVL(AES.VIN_CTNT, '') VIN_CTNT" ).append("\n"); 
		query.append("  FROM BKG_XTER_RQST_MST MST" ).append("\n"); 
		query.append("     , BKG_XTER_AES AES" ).append("\n"); 
		query.append("     , BKG_XTER_CAED CAED" ).append("\n"); 
		query.append("     , BKG_XTER_CUST SH" ).append("\n"); 
		query.append("     , BKG_XTER_CUST CN" ).append("\n"); 
		query.append("     , BKG_XTER_CUST NF" ).append("\n"); 
		query.append("     , BKG_XTER_XPT_LIC_NO XX" ).append("\n"); 
		query.append(" WHERE MST.XTER_SNDR_ID  = @[xter_sndr_id]" ).append("\n"); 
		query.append("   AND MST.XTER_RQST_NO  = @[xter_rqst_no]" ).append("\n"); 
		query.append("   AND MST.XTER_RQST_SEQ = @[xter_rqst_seq]" ).append("\n"); 
		query.append("   AND MST.XTER_SNDR_ID  = AES.XTER_SNDR_ID  (+)" ).append("\n"); 
		query.append("   AND MST.XTER_RQST_NO  = AES.XTER_RQST_NO  (+)" ).append("\n"); 
		query.append("   AND MST.XTER_RQST_SEQ = AES.XTER_RQST_SEQ (+) " ).append("\n"); 
		query.append("   AND MST.XTER_SNDR_ID  = CAED.XTER_SNDR_ID (+)" ).append("\n"); 
		query.append("   AND MST.XTER_RQST_NO  = CAED.XTER_RQST_NO (+)" ).append("\n"); 
		query.append("   AND MST.XTER_RQST_SEQ = CAED.XTER_RQST_SEQ(+)  " ).append("\n"); 
		query.append("   AND MST.XTER_SNDR_ID  = SH.XTER_SNDR_ID   (+)" ).append("\n"); 
		query.append("   AND MST.XTER_RQST_NO  = SH.XTER_RQST_NO   (+)" ).append("\n"); 
		query.append("   AND MST.XTER_RQST_SEQ = SH.XTER_RQST_SEQ  (+) " ).append("\n"); 
		query.append("   AND SH.XTER_CUST_TP_CD(+) = 'S'" ).append("\n"); 
		query.append("   AND MST.XTER_SNDR_ID  = CN.XTER_SNDR_ID   (+)" ).append("\n"); 
		query.append("   AND MST.XTER_RQST_NO  = CN.XTER_RQST_NO   (+)" ).append("\n"); 
		query.append("   AND MST.XTER_RQST_SEQ = CN.XTER_RQST_SEQ  (+) " ).append("\n"); 
		query.append("   AND CN.XTER_CUST_TP_CD(+) = 'C'" ).append("\n"); 
		query.append("   AND MST.XTER_SNDR_ID  = NF.XTER_SNDR_ID   (+)" ).append("\n"); 
		query.append("   AND MST.XTER_RQST_NO  = NF.XTER_RQST_NO   (+)" ).append("\n"); 
		query.append("   AND MST.XTER_RQST_SEQ = NF.XTER_RQST_SEQ  (+)" ).append("\n"); 
		query.append("   AND NF.XTER_CUST_TP_CD(+) = 'N' " ).append("\n"); 
		query.append("   AND MST.XTER_SNDR_ID  = XX.XTER_SNDR_ID   (+)" ).append("\n"); 
		query.append("   AND MST.XTER_RQST_NO  = XX.XTER_RQST_NO   (+)" ).append("\n"); 
		query.append("   AND MST.XTER_RQST_SEQ = XX.XTER_RQST_SEQ  (+)" ).append("\n"); 
		query.append("   AND NVL(XX.CNT_CD(+),'KR') ='KR'" ).append("\n"); 
		query.append("   AND CASE WHEN XX.XPT_LIC_NO IS NOT NULL THEN 'KR'" ).append("\n"); 
		query.append("              WHEN AES.AES_INLND_TRNS_NO IS NOT NULL OR AES.AES_PTA_NO1 IS NOT NULL OR AES.AES_PTA_NO2 IS NOT NULL " ).append("\n"); 
		query.append("                OR AES.AES_PTU_NO IS NOT NULL OR AES.AES_DWN_NO IS NOT NULL OR AES.AES_EXPT_CTNT IS NOT NULL THEN 'US'" ).append("\n"); 
		query.append("              WHEN SH.MX_TAX_ID IS NOT NULL OR CN.MX_TAX_ID IS NOT NULL OR NF.MX_TAX_ID IS NOT NULL THEN 'MX'" ).append("\n"); 
		query.append("              WHEN SH.TR_TAX_ID IS NOT NULL OR CN.TR_TAX_ID IS NOT NULL OR NF.TR_TAX_ID IS NOT NULL THEN 'TR'" ).append("\n"); 
		query.append("              WHEN SH.IL_TAX_ID IS NOT NULL OR CN.IL_TAX_ID IS NOT NULL OR NF.IL_TAX_ID IS NOT NULL THEN 'IL'" ).append("\n"); 
		query.append("              WHEN SH.LB_TAX_ID IS NOT NULL OR CN.LB_TAX_ID IS NOT NULL OR NF.LB_TAX_ID IS NOT NULL THEN 'LB'" ).append("\n"); 
		query.append("              WHEN SH.BRZ_TAX_ID IS NOT NULL OR CN.BRZ_TAX_ID IS NOT NULL OR NF.BRZ_TAX_ID IS NOT NULL THEN 'BR'" ).append("\n"); 
		query.append("              WHEN CAED.CAED_CTNT1 IS NOT NULL OR CAED.CAED_CTNT2 IS NOT NULL OR CAED.CAED_CTNT3 IS NOT NULL " ).append("\n"); 
		query.append("                OR CAED.G7_EDI_CTNT1 IS NOT NULL OR CAED.G7_EDI_CTNT2 IS NOT NULL " ).append("\n"); 
		query.append("                OR CAED.SMRY_RPT_CTNT1 IS NOT NULL OR CAED.SMRY_RPT_CTNT2 IS NOT NULL" ).append("\n"); 
		query.append("                OR CAED.B13A_CTNT1 IS NOT NULL OR CAED.B13A_CTNT2 IS NOT NULL " ).append("\n"); 
		query.append("                OR CAED.NON_DECL_CTNT IS NOT NULL OR CAED.MNL_INP_CTNT IS NOT NULL" ).append("\n"); 
		query.append("                OR CAED.INLND_TZ_CGO_CTNT IS NOT NULL THEN 'CA'" ).append("\n"); 
		query.append("              ELSE '' END IS NOT NULL" ).append("\n"); 

	}
}