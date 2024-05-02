/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BLIssuanceDBDAOsearchBlIssRqstInquiryRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.30
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.30 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLIssuanceDBDAOsearchBlIssRqstInquiryRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * B/L 발급 신청 명세 화면 설정을 위한 Data를 조회한다.
	  * </pre>
	  */
	public BLIssuanceDBDAOsearchBlIssRqstInquiryRSQL(){
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
		params.put("xter_rqst_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration").append("\n"); 
		query.append("FileName : BLIssuanceDBDAOsearchBlIssRqstInquiryRSQL").append("\n"); 
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
		query.append("SELECT BKG_NO                                                                                                    " ).append("\n"); 
		query.append("     , BII_VSL_NM                                                                     " ).append("\n"); 
		query.append("     , BII_VVD                     " ).append("\n"); 
		query.append("     , BL_ISS_RQST_DT" ).append("\n"); 
		query.append("     , RQST_RCT_LOC_CD" ).append("\n"); 
		query.append("     , SUB.LOC_NM" ).append("\n"); 
		query.append("     , BL_NO" ).append("\n"); 
		query.append("     , XTER_RQST_NO" ).append("\n"); 
		query.append("     , XTER_RQST_SEQ" ).append("\n"); 
		query.append("     , SUB.CRE_USR_ID" ).append("\n"); 
		query.append("     , BL_ISS_STS_CD" ).append("\n"); 
		query.append("     , BL_ISS_DT" ).append("\n"); 
		query.append("     , BL_ISS_RJCT_DT" ).append("\n"); 
		query.append("     , BL_ISS_REQ_DT" ).append("\n"); 
		query.append("     , BL_ISS_RMK" ).append("\n"); 
		query.append("     , RQST_CO_NM " ).append("\n"); 
		query.append("     , RQST_USR_EML" ).append("\n"); 
		query.append("     , RQST_ATND_NM" ).append("\n"); 
		query.append("     , RQST_PHN_NO" ).append("\n"); 
		query.append("     , BL_RQST_RMK" ).append("\n"); 
		query.append("     , ACT_SHPR_NM" ).append("\n"); 
		query.append("     , ACT_SHPR_RGST_NO" ).append("\n"); 
		query.append("     , TAX_INV_RCVR_CO_NM" ).append("\n"); 
		query.append("     , TAX_INV_RCVR_RGST_NO" ).append("\n"); 
		query.append("     , TAX_INV_RCVR_ATND_NM" ).append("\n"); 
		query.append("     , TAX_INV_RCVR_PHN_NO" ).append("\n"); 
		query.append("     , REMIT_CO_NM" ).append("\n"); 
		query.append("     , TO_CHAR(CRR_REMIT_AMT,'FM999,999,999,999') CRR_REMIT_AMT" ).append("\n"); 
		query.append("     , CRR_ACCT_CURR_CD" ).append("\n"); 
		query.append("     , RQST_BL_TP_CD" ).append("\n"); 
		query.append("     , CRR_BANK_NM" ).append("\n"); 
		query.append("     , CRR_BANK_ACCT_NO" ).append("\n"); 
		query.append("     , CRR_USA_BANK_NM" ).append("\n"); 
		query.append("     , CRR_USA_BANK_ACCT_NO" ).append("\n"); 
		query.append("     , TO_CHAR(CRR_USA_REMIT_AMT,'FM999,999,999,990.00') CRR_USA_REMIT_AMT" ).append("\n"); 
		query.append("     , TO_CHAR(CRR_USA_REMIT_DT,'YYYY-MM-DD') CRR_USA_REMIT_DT" ).append("\n"); 
		query.append("     , CRR_USA_ACCT_CURR_CD" ).append("\n"); 
		query.append("	 ,(SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("       FROM   COM_INTG_CD_DTL" ).append("\n"); 
		query.append("       WHERE  INTG_CD_ID = 'CD02806'" ).append("\n"); 
		query.append("       AND INTG_CD_VAL_CTNT = REMIT_KND_CD) REMIT_KND_CD" ).append("\n"); 
		query.append("     , TO_CHAR(CRR_REMIT_DT,'YYYY-MM-DD') CRR_REMIT_DT" ).append("\n"); 
		query.append("     , SUB.VSL_CD" ).append("\n"); 
		query.append("     , SUB.SKD_VOY_NO" ).append("\n"); 
		query.append("     , SUB.SKD_DIR_CD" ).append("\n"); 
		query.append("     , VVD" ).append("\n"); 
		query.append("     , POL_CD" ).append("\n"); 
		query.append("     , RN " ).append("\n"); 
		query.append("     , TO_CHAR(SKD.VPS_ETD_DT, 'YYYY-MM-DD HH24:MI') VPS_ETD_DT" ).append("\n"); 
		query.append("	 , DECODE(NVL(BL_ISS_RQST_CD,'W'),'W','Web','M','Mobile','Web') BL_ISS_RQST_CD" ).append("\n"); 
		query.append("     , BL_RCV_TP_CD" ).append("\n"); 
		query.append("     , MNL_BL_OBRD_DT" ).append("\n"); 
		query.append("     , MNL_BL_ISS_DT" ).append("\n"); 
		query.append("	 , CERTI_EXIST_FLG" ).append("\n"); 
		query.append("	 , FRT_DP_FLG" ).append("\n"); 
		query.append("	 , BL_OBRD_DT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT SUB2.*, BNK.INTG_CD_VAL_DP_DESC CRR_USA_BANK_NM" ).append("\n"); 
		query.append("FROM(" ).append("\n"); 
		query.append("      SELECT SUB1.*" ).append("\n"); 
		query.append("                  , BNK.INTG_CD_VAL_DP_DESC CRR_BANK_NM" ).append("\n"); 
		query.append("      FROM" ).append("\n"); 
		query.append("      (" ).append("\n"); 
		query.append("          SELECT  B.BKG_NO                                                                                                    " ).append("\n"); 
		query.append("                 , MDM.VSL_ENG_NM BII_VSL_NM                                                                     " ).append("\n"); 
		query.append("                 , V.SKD_VOY_NO||V.SKD_DIR_CD BII_VVD                     " ).append("\n"); 
		query.append("                 , TO_CHAR(EBL.BL_ISS_RQST_DT, 'YYYY-MM-DD HH24:MI') BL_ISS_RQST_DT" ).append("\n"); 
		query.append("                 , EBL.RQST_RCT_LOC_CD" ).append("\n"); 
		query.append("                 , ORG.OFC_KRN_NM LOC_NM" ).append("\n"); 
		query.append("                 , B.BL_NO" ).append("\n"); 
		query.append("                 , EBL.XTER_RQST_NO" ).append("\n"); 
		query.append("                 , EBL.XTER_RQST_SEQ" ).append("\n"); 
		query.append("                 , EBL.CRE_USR_ID" ).append("\n"); 
		query.append("                 , DECODE(B.BL_TP_CD,'W','A',EBL.BL_ISS_STS_CD) BL_ISS_STS_CD" ).append("\n"); 
		query.append("                 , TO_CHAR(EBL.BL_ISS_ACT_DT, 'YYYY-MM-DD HH24:MI') BL_ISS_DT" ).append("\n"); 
		query.append("                 , TO_CHAR(EBL.BL_ISS_RJCT_DT, 'YYYY-MM-DD HH24:MI') BL_ISS_RJCT_DT" ).append("\n"); 
		query.append("                 , TO_CHAR(EBL.BL_ISS_REQ_DT, 'YYYY-MM-DD HH24:MI') BL_ISS_REQ_DT" ).append("\n"); 
		query.append("                 , EBL.BL_ISS_RMK" ).append("\n"); 
		query.append("                 , EBL.RQST_CO_NM " ).append("\n"); 
		query.append("                 , EBL.RQST_USR_EML" ).append("\n"); 
		query.append("                 , EBL.RQST_ATND_NM" ).append("\n"); 
		query.append("                 , EBL.RQST_PHN_NO" ).append("\n"); 
		query.append("                 , EBL.BL_RQST_RMK" ).append("\n"); 
		query.append("                 , EBL.ACT_SHPR_NM" ).append("\n"); 
		query.append("                 , EBL.ACT_SHPR_RGST_NO" ).append("\n"); 
		query.append("                 , EBL.TAX_INV_RCVR_CO_NM" ).append("\n"); 
		query.append("                 , EBL.TAX_INV_RCVR_RGST_NO" ).append("\n"); 
		query.append("                 , EBL.TAX_INV_RCVR_ATND_NM" ).append("\n"); 
		query.append("                 , EBL.TAX_INV_RCVR_PHN_NO" ).append("\n"); 
		query.append("                 , EBL.REMIT_CO_NM" ).append("\n"); 
		query.append("                 , EBL.CRR_REMIT_AMT" ).append("\n"); 
		query.append("                 , EBL.CRR_ACCT_CURR_CD" ).append("\n"); 
		query.append("                 , EBL.CRR_BANK_CD" ).append("\n"); 
		query.append("                 , EBL.CRR_BANK_ACCT_NO" ).append("\n"); 
		query.append("                 , EBL.CRR_USA_BANK_CD" ).append("\n"); 
		query.append("                 , EBL.CRR_USA_BANK_ACCT_NO" ).append("\n"); 
		query.append("                 , EBL.CRR_USA_REMIT_AMT" ).append("\n"); 
		query.append("                 , EBL.CRR_USA_REMIT_DT" ).append("\n"); 
		query.append("                 , EBL.CRR_USA_ACCT_CURR_CD " ).append("\n"); 
		query.append("                 , V.VSL_CD" ).append("\n"); 
		query.append("                 , V.SKD_VOY_NO" ).append("\n"); 
		query.append("                 , V.SKD_DIR_CD" ).append("\n"); 
		query.append("                 , V.VSL_CD||V.SKD_VOY_NO||V.SKD_DIR_CD VVD" ).append("\n"); 
		query.append("                 , V.POL_CD" ).append("\n"); 
		query.append("				 , EBL.REMIT_KND_CD" ).append("\n"); 
		query.append("                 , EBL.CRR_REMIT_DT" ).append("\n"); 
		query.append("                 , EBL.RQST_BL_TP_CD" ).append("\n"); 
		query.append("                 , DENSE_RANK() OVER (PARTITION BY V.BKG_NO ORDER BY V.VSL_PRE_PST_CD||V.VSL_SEQ) RN" ).append("\n"); 
		query.append("                 , EBL.BL_ISS_RQST_CD" ).append("\n"); 
		query.append("                 , EBL.BL_RCV_TP_CD" ).append("\n"); 
		query.append("     		     , TO_CHAR(EBL.MNL_BL_OBRD_DT,'YYYY-MM-DD') MNL_BL_OBRD_DT" ).append("\n"); 
		query.append("     			 , TO_CHAR(EBL.MNL_BL_ISS_DT,'YYYY-MM-DD') MNL_BL_ISS_DT" ).append("\n"); 
		query.append("	 			 , EBL.CERTI_EXIST_FLG" ).append("\n"); 
		query.append("	 			 , EBL.FRT_DP_FLG" ).append("\n"); 
		query.append("				 , TO_CHAR(BBD.BL_OBRD_DT,'YYYY-MM-DD') BL_OBRD_DT" ).append("\n"); 
		query.append("            FROM  BKG_BOOKING B                                                                                " ).append("\n"); 
		query.append("                 , BKG_CUSTOMER C " ).append("\n"); 
		query.append("                 , BKG_BL_DOC BBD " ).append("\n"); 
		query.append("                 , BKG_VVD V " ).append("\n"); 
		query.append("                 , MDM_VSL_CNTR MDM " ).append("\n"); 
		query.append("                 , BKG_BL_ISS ISS" ).append("\n"); 
		query.append("                 , MDM_ORGANIZATION ORG" ).append("\n"); 
		query.append("                 , BKG_BL_ISS_RQST EBL" ).append("\n"); 
		query.append("            WHERE B.BKG_NO = C.BKG_NO" ).append("\n"); 
		query.append("            AND B.BKG_NO = BBD.BKG_NO" ).append("\n"); 
		query.append("            AND B.BKG_NO = V.BKG_NO" ).append("\n"); 
		query.append("            AND B.VSL_CD = MDM.VSL_CD" ).append("\n"); 
		query.append("            AND EBL.RQST_RCT_LOC_CD = ORG.OFC_CD" ).append("\n"); 
		query.append("            AND B.BKG_NO = ISS.BKG_NO(+)" ).append("\n"); 
		query.append("            AND B.BL_NO = EBL.BL_NO(+)" ).append("\n"); 
		query.append("            AND B.BKG_STS_CD <> 'X'" ).append("\n"); 
		query.append("            AND C.BKG_CUST_TP_CD = 'S'" ).append("\n"); 
		query.append("            AND EBL.XTER_RQST_NO = @[xter_rqst_no]" ).append("\n"); 
		query.append("            AND EBL.XTER_RQST_SEQ = @[xter_rqst_seq]" ).append("\n"); 
		query.append("              ) SUB1" ).append("\n"); 
		query.append("              , COM_INTG_CD_DTL BNK" ).append("\n"); 
		query.append("            WHERE INTG_CD_ID(+) = 'CD02933'" ).append("\n"); 
		query.append("            AND SUB1.CRR_BANK_CD = BNK.INTG_CD_VAL_CTNT(+)" ).append("\n"); 
		query.append("            ) SUB2" ).append("\n"); 
		query.append("            , COM_INTG_CD_DTL BNK" ).append("\n"); 
		query.append("            WHERE INTG_CD_ID(+) = 'CD02933'" ).append("\n"); 
		query.append("            AND SUB2.CRR_USA_BANK_CD = BNK.INTG_CD_VAL_CTNT(+)" ).append("\n"); 
		query.append("        ) SUB" ).append("\n"); 
		query.append("      , VSK_VSL_PORT_SKD SKD" ).append("\n"); 
		query.append("  WHERE SUB.VSL_CD = SKD.VSL_CD" ).append("\n"); 
		query.append("  AND SUB.SKD_VOY_NO = SKD.SKD_VOY_NO" ).append("\n"); 
		query.append("  AND SUB.SKD_DIR_CD = SKD.SKD_DIR_CD" ).append("\n"); 
		query.append("  AND SUB.POL_CD = SKD.VPS_PORT_CD" ).append("\n"); 
		query.append("  AND SKD.CLPT_IND_SEQ = 1" ).append("\n"); 
		query.append("  AND SUB.RN = 1" ).append("\n"); 

	}
}