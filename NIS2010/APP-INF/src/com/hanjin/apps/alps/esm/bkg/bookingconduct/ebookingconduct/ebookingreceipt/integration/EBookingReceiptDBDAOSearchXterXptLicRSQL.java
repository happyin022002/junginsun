/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EBookingReceiptDBDAOSearchXterXptLicRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.16
*@LastModifier : Do Soon Choi
*@LastVersion : 1.0
* 2015.03.16 Do Soon Choi
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

public class EBookingReceiptDBDAOSearchXterXptLicRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ebkg의 export licens 정보를 조회한다.
	  * Brazil 추가 2013.01.07 
	  * </pre>
	  */
	public EBookingReceiptDBDAOSearchXterXptLicRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sender_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration").append("\n"); 
		query.append("FileName : EBookingReceiptDBDAOSearchXterXptLicRSQL").append("\n"); 
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
		query.append("SELECT    " ).append("\n"); 
		query.append("----------MEXICO		" ).append("\n"); 
		query.append("		  SH.MX_TAX_ID 				SHPR_TAX_NO2" ).append("\n"); 
		query.append("		, CN.MX_TAX_ID 				CNEE_TAX_NO2" ).append("\n"); 
		query.append("		, NF.MX_TAX_ID 				NTFY_TAX_NO2" ).append("\n"); 
		query.append("----------turkey		" ).append("\n"); 
		query.append("        , SH.TR_TAX_ID AS TR_SHPR_TAX_ID			" ).append("\n"); 
		query.append("        , CN.TR_TAX_ID AS TR_CNEE_TAX_ID			" ).append("\n"); 
		query.append("        , NF.TR_TAX_ID AS TR_NTFY_TAX_ID	" ).append("\n"); 
		query.append("----------ISRAEL		" ).append("\n"); 
		query.append("        , SH.IL_TAX_ID AS IL_SHPR_TAX_ID			" ).append("\n"); 
		query.append("        , CN.IL_TAX_ID AS IL_CNEE_TAX_ID			" ).append("\n"); 
		query.append("        , NF.IL_TAX_ID AS IL_NTFY_TAX_ID" ).append("\n"); 
		query.append("----------LEBANON		" ).append("\n"); 
		query.append("        , SH.LB_TAX_ID AS LB_SHPR_TAX_ID			" ).append("\n"); 
		query.append("        , CN.LB_TAX_ID AS LB_CNEE_TAX_ID			" ).append("\n"); 
		query.append("        , NF.LB_TAX_ID AS LB_NTFY_TAX_ID" ).append("\n"); 
		query.append("----------BRAZIL		" ).append("\n"); 
		query.append("        , SH.BRZ_TAX_ID AS BR_SHPR_TAX_ID " ).append("\n"); 
		query.append("        , CN.BRZ_TAX_ID AS BR_CNEE_TAX_ID" ).append("\n"); 
		query.append("        , NF.BRZ_TAX_ID AS BR_NTFY_TAX_ID" ).append("\n"); 
		query.append("----------USA" ).append("\n"); 
		query.append("        , AES.AES_INLND_TRNS_NO 	AES_INLND_TRNS_NO2" ).append("\n"); 
		query.append("        , AES.AES_PTA_NO1 			AES_PTA_NO12" ).append("\n"); 
		query.append("        , AES.AES_PTA_NO2 			AES_PTA_NO22" ).append("\n"); 
		query.append("        , TO_CHAR(AES.AES_PTA_DT, 'MM-DD-YYYY') AES_PTA_DT2" ).append("\n"); 
		query.append("        , AES.AES_PTU_NO						AES_PTU_NO2" ).append("\n"); 
		query.append("        , TO_CHAR(AES.AES_PTU_DT, 'MM-DD-YYYY')	AES_PTU_DT2" ).append("\n"); 
		query.append("        , AES.AES_DWN_NO						AES_DWN_NO2" ).append("\n"); 
		query.append("        , TO_CHAR(AES.AES_DWN_DT, 'MM-DD-YYYY') AES_DWN_DT2" ).append("\n"); 
		query.append("        , AES.AES_EXPT_CTNT			AES_EXPT_CTNT2" ).append("\n"); 
		query.append("        , AES.AES_EXPT_ID           AES_EXPT_ID2" ).append("\n"); 
		query.append("        , AES.AES_FLG				AES_FLG2" ).append("\n"); 
		query.append("        , AES.PTA_FLG				PTA_FLG2" ).append("\n"); 
		query.append("        , AES.PTU_FLG				PTU_FLG2" ).append("\n"); 
		query.append("        , AES.DWN_FLG				DWN_FLG2" ).append("\n"); 
		query.append("        , AES.EXPT_FLG				EXPT_FLG2" ).append("\n"); 
		query.append("		, AES.VIN_CTNT" ).append("\n"); 
		query.append("----------CANADA" ).append("\n"); 
		query.append("        , CAED.CAED_FLG				CAED_FLG2" ).append("\n"); 
		query.append("        , CAED.G7_EDI_FLG			G7_EDI_FLG2" ).append("\n"); 
		query.append("        , CAED.SMRY_RPT_FLG			SMRY_RPT_FLG2" ).append("\n"); 
		query.append("        , CAED.B13A_FLG				B13A_FLG2" ).append("\n"); 
		query.append("        , CAED.INLND_TZ_CGO_FLG		INLND_TZ_CGO_FLG2" ).append("\n"); 
		query.append("        , CAED.MNL_INP_FLG			MNL_INP_FLG2" ).append("\n"); 
		query.append("        , CAED.NON_DECL_FLG			NON_DECL_FLG2" ).append("\n"); 
		query.append("        , CAED.CAED_CTNT1" ).append("\n"); 
		query.append("			||decode(nvl(CAED.CAED_CTNT2, 'x'), 'x', '', '-'||CAED.CAED_CTNT2)" ).append("\n"); 
		query.append("			||decode(nvl(CAED.CAED_CTNT3, 'x'), 'x', '', '-'||CAED.CAED_CTNT3)	CAED_CTNT2" ).append("\n"); 
		query.append("--        , CAED.CAED_CTNT2 			CAED_CTNT22" ).append("\n"); 
		query.append("--        , CAED.CAED_CTNT3			CAED_CTNT32" ).append("\n"); 
		query.append("        , CAED.G7_EDI_CTNT1" ).append("\n"); 
		query.append("			||decode(nvl(CAED.G7_EDI_CTNT2, 'x'), 'x', '', '-'||CAED.G7_EDI_CTNT2) G7_EDI_NO2" ).append("\n"); 
		query.append("--        , CAED.G7_EDI_CTNT1			G7_EDI_NO12" ).append("\n"); 
		query.append("--        , CAED.G7_EDI_CTNT2 		G7_EDI_NO22" ).append("\n"); 
		query.append("		, CAED.SMRY_RPT_CTNT1" ).append("\n"); 
		query.append("			||decode(nvl(CAED.SMRY_RPT_CTNT2, 'x'), 'x', '', '-'||CAED.SMRY_RPT_CTNT2) SMRY_RPT_CTNT2" ).append("\n"); 
		query.append("--        , CAED.SMRY_RPT_CTNT1		SMRY_RPT_CTNT12" ).append("\n"); 
		query.append("--        , CAED.SMRY_RPT_CTNT2 		SMRY_RPT_CTNT22" ).append("\n"); 
		query.append("        , TO_CHAR(CAED.B13A_DT, 'MM-DD-YYYY')" ).append("\n"); 
		query.append("			||decode(nvl(CAED.B13A_CTNT1, 'x'), 'x', '', '-'||CAED.B13A_CTNT1)" ).append("\n"); 
		query.append("			||decode(nvl(CAED.B13A_CTNT2, 'x'), 'x', '', '-'||CAED.B13A_CTNT2) B13A_CTNT2" ).append("\n"); 
		query.append("--		, TO_CHAR(CAED.B13A_DT, 'YYYY-MM-DD') B13A_DT" ).append("\n"); 
		query.append("--        , CAED.B13A_CTNT1			B13A_CTNT12" ).append("\n"); 
		query.append("--        , CAED.B13A_CTNT2 			B13A_CTNT22" ).append("\n"); 
		query.append("        , CAED.INLND_TZ_CGO_CTNT 	INLND_TZ_CGO_CTNT2" ).append("\n"); 
		query.append("        , CAED.MNL_INP_CTNT			MNL_INP_CTNT2" ).append("\n"); 
		query.append("        , CAED.NON_DECL_CTNT 		NON_DECL_CTNT2" ).append("\n"); 
		query.append("  FROM BKG_XTER_RQST_MST MST" ).append("\n"); 
		query.append("        , BKG_XTER_AES AES" ).append("\n"); 
		query.append("        , BKG_XTER_CAED CAED" ).append("\n"); 
		query.append("        , BKG_XTER_CUST SH" ).append("\n"); 
		query.append("        , BKG_XTER_CUST CN" ).append("\n"); 
		query.append("        , BKG_XTER_CUST NF" ).append("\n"); 
		query.append(" WHERE MST.XTER_SNDR_ID  = @[sender_id]" ).append("\n"); 
		query.append("   AND MST.XTER_RQST_NO  = @[rqst_no]" ).append("\n"); 
		query.append("   AND MST.XTER_RQST_SEQ = @[rqst_seq]" ).append("\n"); 
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
		query.append("   AND NF.XTER_CUST_TP_CD(+) = 'N'" ).append("\n"); 

	}
}