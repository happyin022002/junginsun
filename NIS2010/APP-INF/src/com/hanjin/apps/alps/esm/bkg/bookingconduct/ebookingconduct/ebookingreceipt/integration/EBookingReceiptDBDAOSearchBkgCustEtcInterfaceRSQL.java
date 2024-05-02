/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EBookingReceiptDBDAOSearchBkgCustEtcInterfaceRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.10.26
*@LastModifier : Do Soon Choi
*@LastVersion : 1.0
* 2015.10.26 Do Soon Choi
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

public class EBookingReceiptDBDAOSearchBkgCustEtcInterfaceRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * external request 처리를 위해 external rqst의 customer 정보를 조회한다.
	  * </pre>
	  */
	public EBookingReceiptDBDAOSearchBkgCustEtcInterfaceRSQL(){
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
		query.append("FileName : EBookingReceiptDBDAOSearchBkgCustEtcInterfaceRSQL").append("\n"); 
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
		query.append("SELECT   NVL(MST.AGMT_ACT_CNT_CD,BK.AGMT_ACT_CNT_CD) AGMT_ACT_CNT_CD" ).append("\n"); 
		query.append("        ,NVL(MST.AGMT_ACT_CUST_SEQ,BK.AGMT_ACT_CUST_SEQ) AGMT_ACT_CUST_SEQ" ).append("\n"); 
		query.append("        , MST.DOC_TP_CD" ).append("\n"); 
		query.append("        , NVL(BK.INDIV_PSON_FLG,'N') INDIV_PSON_FLG" ).append("\n"); 
		query.append("        , DECODE(MST.XTER_RQST_VIA_CD, 'WEB', MST.KR_CSTMS_CUST_TP_CD," ).append("\n"); 
		query.append("                (SELECT DECODE(RVIS_CNTR_CUST_TP_CD, 'B', 'S', 'N', 'C', DECODE(INDIV_CORP_DIV_CD, 'P', 'S', 'C'))" ).append("\n"); 
		query.append("                 FROM MDM_CUSTOMER CUST " ).append("\n"); 
		query.append("                 WHERE CUST.CUST_CNT_CD = SH.CNT_CD " ).append("\n"); 
		query.append("                 AND CUST.CUST_SEQ = SH.CUST_SEQ )" ).append("\n"); 
		query.append("          ) KR_CSTMS_CUST_TP_CD" ).append("\n"); 
		query.append("		, MST.ORG_CNT_NM" ).append("\n"); 
		query.append("        , NVL(MST.POD_CD, BK.POD_CD) POD_CD" ).append("\n"); 
		query.append("        , NVL(BK.SAM_CNEE_NTFY_FLG,'N') SAM_CNEE_NTFY_FLG" ).append("\n"); 
		query.append("        , NVL(BK.CUST_TO_ORD_FLG,'N') CUST_TO_ORD_FLG  -- WebService로 BKG Creation 시에는  SI 작업시 확인할 사항이므로 Straight로 고정. / CN_CUST_TO_ORD_FLG" ).append("\n"); 
		query.append("		, CASE WHEN INSTR(UPPER(CN.CUST_NM), 'ORDER') > 0 THEN 'Y' ELSE NVL(BK.CUST_TO_ORD_FLG,'N') END CN_CUST_TO_ORD_FLG" ).append("\n"); 
		query.append("        , (SELECT SC_NO FROM PRI_SP_HDR WHERE SC_NO = NVL(MST.CTRT_NO,BK.SC_NO))  SC_NO" ).append("\n"); 
		query.append("		, FF.CUST_REF_NO_CTNT FF_REF_NO" ).append("\n"); 
		query.append("    	, FMC.CUST_REF_NO_CTNT FMC_CD" ).append("\n"); 
		query.append("FROM BKG_XTER_RQST_MST MST" ).append("\n"); 
		query.append("    ,BKG_XTER_CUST SH" ).append("\n"); 
		query.append("	,BKG_XTER_CUST CN" ).append("\n"); 
		query.append("	,BKG_BOOKING BK" ).append("\n"); 
		query.append("	,BKG_REFERENCE FF" ).append("\n"); 
		query.append("    ,BKG_REFERENCE FMC" ).append("\n"); 
		query.append("WHERE MST.XTER_RQST_NO  = SH.XTER_RQST_NO(+)" ).append("\n"); 
		query.append("  AND MST.XTER_RQST_SEQ = SH.XTER_RQST_SEQ(+)" ).append("\n"); 
		query.append("  AND MST.XTER_SNDR_ID  = SH.XTER_SNDR_ID(+)" ).append("\n"); 
		query.append("  AND 'S'               = SH.XTER_CUST_TP_CD(+)" ).append("\n"); 
		query.append("  AND MST.XTER_RQST_NO  = CN.XTER_RQST_NO(+)" ).append("\n"); 
		query.append("  AND MST.XTER_RQST_SEQ = CN.XTER_RQST_SEQ(+)" ).append("\n"); 
		query.append("  AND MST.XTER_SNDR_ID  = CN.XTER_SNDR_ID(+)" ).append("\n"); 
		query.append("  AND 'C'               = CN.XTER_CUST_TP_CD(+)" ).append("\n"); 
		query.append("  AND MST.BKG_NO 		= BK.BKG_NO(+)" ).append("\n"); 
		query.append("  AND MST.BKG_NO = FF.BKG_NO(+)" ).append("\n"); 
		query.append("  AND 'FFNO'    = FF.BKG_REF_TP_CD(+)" ).append("\n"); 
		query.append("  AND MST.BKG_NO = FMC.BKG_NO(+)" ).append("\n"); 
		query.append("  AND 'FMCN'    = FMC.BKG_REF_TP_CD(+)" ).append("\n"); 
		query.append("  AND MST.XTER_RQST_NO  = @[xter_rqst_no]" ).append("\n"); 
		query.append("  AND MST.XTER_RQST_SEQ = @[xter_rqst_seq]" ).append("\n"); 
		query.append("  AND MST.XTER_SNDR_ID  = @[xter_sndr_id]" ).append("\n"); 

	}
}