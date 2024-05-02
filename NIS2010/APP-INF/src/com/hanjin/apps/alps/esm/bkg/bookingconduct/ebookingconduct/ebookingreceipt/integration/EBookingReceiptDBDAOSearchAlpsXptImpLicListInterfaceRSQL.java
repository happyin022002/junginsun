/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EBookingReceiptDBDAOSearchAlpsXptImpLicListInterfaceRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.28
*@LastModifier : Do Soon Choi
*@LastVersion : 1.0
* 2015.08.28 Do Soon Choi
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

public class EBookingReceiptDBDAOSearchAlpsXptImpLicListInterfaceRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MND 중 Booking Request시 접수되는 Import&Export Licence No만 별도 처리하기 위해 정보를 조회한다.
	  * </pre>
	  */
	public EBookingReceiptDBDAOSearchAlpsXptImpLicListInterfaceRSQL(){
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
		query.append("FileName : EBookingReceiptDBDAOSearchAlpsXptImpLicListInterfaceRSQL").append("\n"); 
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
		query.append("SELECT 	MST.BKG_NO, 'MX' CNT_CD" ).append("\n"); 
		query.append("		, SH.MX_TAX_ID MX_SHPR_TAX_ID  -- Mexico" ).append("\n"); 
		query.append("        , CN.MX_TAX_ID MX_CNEE_TAX_ID		" ).append("\n"); 
		query.append("        , NF.MX_TAX_ID MX_NTFY_TAX_ID" ).append("\n"); 
		query.append("        , '' TR_SHPR_TAX_ID         , '' TR_CNEE_TAX_ID         , '' TR_NTFY_TAX_ID  -- Turkey" ).append("\n"); 
		query.append("        , '' IL_SHPR_TAX_ID         , '' IL_CNEE_TAX_ID         , '' IL_NTFY_TAX_ID  -- Israel" ).append("\n"); 
		query.append("        , '' LB_SHPR_TAX_ID         , '' LB_CNEE_TAX_ID         , '' LB_NTFY_TAX_ID  -- Lebanon" ).append("\n"); 
		query.append("        , '' BR_SHPR_TAX_ID         , '' BR_CNEE_TAX_ID         , '' BR_NTFY_TAX_ID  -- Brazil" ).append("\n"); 
		query.append("        , '' AES_INLND_TRNS_NO      , '' AES_PTA_NO1            , '' AES_PTA_NO2     -- USA" ).append("\n"); 
		query.append("        , '' AES_PTA_DT             , '' AES_PTU_NO             , '' AES_PTU_DT" ).append("\n"); 
		query.append("        , '' AES_DWN_NO             , '' AES_DWN_DT             , '' AES_EXPT_CTNT" ).append("\n"); 
		query.append("        , '' AES_EXPT_ID            , '' AES_TP_CD" ).append("\n"); 
		query.append("        , '' CAED_CTNT              , '' G7_EDI_CTNT            , '' MF_SMRY_RPT_NO  -- Canada" ).append("\n"); 
		query.append("        , '' B13A_XPT_CTNT          , '' CGO_CTRL_NO            , '' NDR_REF_CTNT" ).append("\n"); 
		query.append("        , '' NDR_REF_ID             , '' CAED_TP_CD				, '' VIN_CTNT" ).append("\n"); 
		query.append("FROM BKG_XTER_RQST_MST MST, BKG_XTER_CUST SH, BKG_XTER_CUST CN, BKG_XTER_CUST NF" ).append("\n"); 
		query.append("WHERE MST.XTER_SNDR_ID  = @[xter_sndr_id]" ).append("\n"); 
		query.append("AND MST.XTER_RQST_NO  = @[xter_rqst_no]" ).append("\n"); 
		query.append("AND MST.XTER_RQST_SEQ = @[xter_rqst_seq]" ).append("\n"); 
		query.append("AND MST.XTER_SNDR_ID  = SH.XTER_SNDR_ID   (+)" ).append("\n"); 
		query.append("AND MST.XTER_RQST_NO  = SH.XTER_RQST_NO   (+)" ).append("\n"); 
		query.append("AND MST.XTER_RQST_SEQ = SH.XTER_RQST_SEQ  (+) " ).append("\n"); 
		query.append("AND SH.XTER_CUST_TP_CD(+) = 'S'" ).append("\n"); 
		query.append("AND MST.XTER_SNDR_ID  = CN.XTER_SNDR_ID   (+)" ).append("\n"); 
		query.append("AND MST.XTER_RQST_NO  = CN.XTER_RQST_NO   (+)" ).append("\n"); 
		query.append("AND MST.XTER_RQST_SEQ = CN.XTER_RQST_SEQ  (+) " ).append("\n"); 
		query.append("AND CN.XTER_CUST_TP_CD(+) = 'C'" ).append("\n"); 
		query.append("AND MST.XTER_SNDR_ID  = NF.XTER_SNDR_ID   (+)" ).append("\n"); 
		query.append("AND MST.XTER_RQST_NO  = NF.XTER_RQST_NO   (+)" ).append("\n"); 
		query.append("AND MST.XTER_RQST_SEQ = NF.XTER_RQST_SEQ  (+)" ).append("\n"); 
		query.append("AND NF.XTER_CUST_TP_CD(+) = 'N'" ).append("\n"); 
		query.append("AND LENGTH(SH.MX_TAX_ID||CN.MX_TAX_ID||NF.MX_TAX_ID) > 0" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 	MST.BKG_NO, 'TR' CNT_CD" ).append("\n"); 
		query.append("		, '' MX_SHPR_TAX_ID         , '' MX_CNEE_TAX_ID         , '' MX_NTFY_TAX_ID  -- Mexico" ).append("\n"); 
		query.append("        , SH.TR_TAX_ID TR_SHPR_TAX_ID  -- Turkey         " ).append("\n"); 
		query.append("        , CN.TR_TAX_ID TR_CNEE_TAX_ID         " ).append("\n"); 
		query.append("        , NF.TR_TAX_ID TR_NTFY_TAX_ID	" ).append("\n"); 
		query.append("        , '' IL_SHPR_TAX_ID         , '' IL_CNEE_TAX_ID         , '' IL_NTFY_TAX_ID  -- Israel" ).append("\n"); 
		query.append("        , '' LB_SHPR_TAX_ID         , '' LB_CNEE_TAX_ID         , '' LB_NTFY_TAX_ID  -- Lebanon" ).append("\n"); 
		query.append("        , '' BR_SHPR_TAX_ID         , '' BR_CNEE_TAX_ID         , '' BR_NTFY_TAX_ID  -- Brazil" ).append("\n"); 
		query.append("        , '' AES_INLND_TRNS_NO      , '' AES_PTA_NO1            , '' AES_PTA_NO2     -- USA" ).append("\n"); 
		query.append("        , '' AES_PTA_DT             , '' AES_PTU_NO             , '' AES_PTU_DT" ).append("\n"); 
		query.append("        , '' AES_DWN_NO             , '' AES_DWN_DT             , '' AES_EXPT_CTNT" ).append("\n"); 
		query.append("        , '' AES_EXPT_ID            , '' AES_TP_CD" ).append("\n"); 
		query.append("        , '' CAED_CTNT              , '' G7_EDI_CTNT            , '' MF_SMRY_RPT_NO  -- Canada" ).append("\n"); 
		query.append("        , '' B13A_XPT_CTNT          , '' CGO_CTRL_NO            , '' NDR_REF_CTNT" ).append("\n"); 
		query.append("        , '' NDR_REF_ID             , '' CAED_TP_CD				, '' VIN_CTNT" ).append("\n"); 
		query.append("FROM BKG_XTER_RQST_MST MST, BKG_XTER_CUST SH, BKG_XTER_CUST CN, BKG_XTER_CUST NF" ).append("\n"); 
		query.append("WHERE MST.XTER_SNDR_ID  = @[xter_sndr_id]" ).append("\n"); 
		query.append("AND MST.XTER_RQST_NO  = @[xter_rqst_no]" ).append("\n"); 
		query.append("AND MST.XTER_RQST_SEQ = @[xter_rqst_seq]" ).append("\n"); 
		query.append("AND MST.XTER_SNDR_ID  = SH.XTER_SNDR_ID   (+)" ).append("\n"); 
		query.append("AND MST.XTER_RQST_NO  = SH.XTER_RQST_NO   (+)" ).append("\n"); 
		query.append("AND MST.XTER_RQST_SEQ = SH.XTER_RQST_SEQ  (+) " ).append("\n"); 
		query.append("AND SH.XTER_CUST_TP_CD(+) = 'S'" ).append("\n"); 
		query.append("AND MST.XTER_SNDR_ID  = CN.XTER_SNDR_ID   (+)" ).append("\n"); 
		query.append("AND MST.XTER_RQST_NO  = CN.XTER_RQST_NO   (+)" ).append("\n"); 
		query.append("AND MST.XTER_RQST_SEQ = CN.XTER_RQST_SEQ  (+) " ).append("\n"); 
		query.append("AND CN.XTER_CUST_TP_CD(+) = 'C'" ).append("\n"); 
		query.append("AND MST.XTER_SNDR_ID  = NF.XTER_SNDR_ID   (+)" ).append("\n"); 
		query.append("AND MST.XTER_RQST_NO  = NF.XTER_RQST_NO   (+)" ).append("\n"); 
		query.append("AND MST.XTER_RQST_SEQ = NF.XTER_RQST_SEQ  (+)" ).append("\n"); 
		query.append("AND NF.XTER_CUST_TP_CD(+) = 'N'" ).append("\n"); 
		query.append("AND LENGTH(SH.TR_TAX_ID||CN.TR_TAX_ID||NF.TR_TAX_ID) > 0" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 	MST.BKG_NO, 'IL' CNT_CD" ).append("\n"); 
		query.append("		, '' MX_SHPR_TAX_ID         , '' MX_CNEE_TAX_ID         , '' MX_NTFY_TAX_ID  -- Mexico" ).append("\n"); 
		query.append("        , '' TR_SHPR_TAX_ID         , '' TR_CNEE_TAX_ID         , '' TR_NTFY_TAX_ID  -- Turkey  " ).append("\n"); 
		query.append("        , SH.IL_TAX_ID IL_SHPR_TAX_ID  -- Israel" ).append("\n"); 
		query.append("        , CN.IL_TAX_ID IL_CNEE_TAX_ID" ).append("\n"); 
		query.append("        , NF.IL_TAX_ID IL_NTFY_TAX_ID" ).append("\n"); 
		query.append("        , '' LB_SHPR_TAX_ID         , '' LB_CNEE_TAX_ID         , '' LB_NTFY_TAX_ID  -- Lebanon" ).append("\n"); 
		query.append("        , '' BR_SHPR_TAX_ID         , '' BR_CNEE_TAX_ID         , '' BR_NTFY_TAX_ID  -- Brazil" ).append("\n"); 
		query.append("        , '' AES_INLND_TRNS_NO      , '' AES_PTA_NO1            , '' AES_PTA_NO2     -- USA" ).append("\n"); 
		query.append("        , '' AES_PTA_DT             , '' AES_PTU_NO             , '' AES_PTU_DT" ).append("\n"); 
		query.append("        , '' AES_DWN_NO             , '' AES_DWN_DT             , '' AES_EXPT_CTNT" ).append("\n"); 
		query.append("        , '' AES_EXPT_ID            , '' AES_TP_CD" ).append("\n"); 
		query.append("        , '' CAED_CTNT              , '' G7_EDI_CTNT            , '' MF_SMRY_RPT_NO  -- Canada" ).append("\n"); 
		query.append("        , '' B13A_XPT_CTNT          , '' CGO_CTRL_NO            , '' NDR_REF_CTNT" ).append("\n"); 
		query.append("        , '' NDR_REF_ID             , '' CAED_TP_CD				, '' VIN_CTNT" ).append("\n"); 
		query.append("FROM BKG_XTER_RQST_MST MST, BKG_XTER_CUST SH, BKG_XTER_CUST CN, BKG_XTER_CUST NF" ).append("\n"); 
		query.append("WHERE MST.XTER_SNDR_ID  = @[xter_sndr_id]" ).append("\n"); 
		query.append("AND MST.XTER_RQST_NO  = @[xter_rqst_no]" ).append("\n"); 
		query.append("AND MST.XTER_RQST_SEQ = @[xter_rqst_seq]" ).append("\n"); 
		query.append("AND MST.XTER_SNDR_ID  = SH.XTER_SNDR_ID   (+)" ).append("\n"); 
		query.append("AND MST.XTER_RQST_NO  = SH.XTER_RQST_NO   (+)" ).append("\n"); 
		query.append("AND MST.XTER_RQST_SEQ = SH.XTER_RQST_SEQ  (+) " ).append("\n"); 
		query.append("AND SH.XTER_CUST_TP_CD(+) = 'S'" ).append("\n"); 
		query.append("AND MST.XTER_SNDR_ID  = CN.XTER_SNDR_ID   (+)" ).append("\n"); 
		query.append("AND MST.XTER_RQST_NO  = CN.XTER_RQST_NO   (+)" ).append("\n"); 
		query.append("AND MST.XTER_RQST_SEQ = CN.XTER_RQST_SEQ  (+) " ).append("\n"); 
		query.append("AND CN.XTER_CUST_TP_CD(+) = 'C'" ).append("\n"); 
		query.append("AND MST.XTER_SNDR_ID  = NF.XTER_SNDR_ID   (+)" ).append("\n"); 
		query.append("AND MST.XTER_RQST_NO  = NF.XTER_RQST_NO   (+)" ).append("\n"); 
		query.append("AND MST.XTER_RQST_SEQ = NF.XTER_RQST_SEQ  (+)" ).append("\n"); 
		query.append("AND NF.XTER_CUST_TP_CD(+) = 'N'" ).append("\n"); 
		query.append("AND LENGTH(SH.IL_TAX_ID||CN.IL_TAX_ID||NF.IL_TAX_ID) > 0" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 	MST.BKG_NO, 'LB' CNT_CD" ).append("\n"); 
		query.append("		, '' MX_SHPR_TAX_ID         , '' MX_CNEE_TAX_ID         , '' MX_NTFY_TAX_ID  -- Mexico" ).append("\n"); 
		query.append("        , '' TR_SHPR_TAX_ID         , '' TR_CNEE_TAX_ID         , '' TR_NTFY_TAX_ID  -- Turkey	" ).append("\n"); 
		query.append("        , '' IL_SHPR_TAX_ID         , '' IL_CNEE_TAX_ID         , '' IL_NTFY_TAX_ID  -- Israel" ).append("\n"); 
		query.append("        , SH.LB_TAX_ID LB_SHPR_TAX_ID  -- Lebanon" ).append("\n"); 
		query.append("        , CN.LB_TAX_ID LB_CNEE_TAX_ID" ).append("\n"); 
		query.append("        , NF.LB_TAX_ID LB_NTFY_TAX_ID" ).append("\n"); 
		query.append("        , '' BR_SHPR_TAX_ID         , '' BR_CNEE_TAX_ID         , '' BR_NTFY_TAX_ID  -- Brazil" ).append("\n"); 
		query.append("        , '' AES_INLND_TRNS_NO      , '' AES_PTA_NO1            , '' AES_PTA_NO2     -- USA" ).append("\n"); 
		query.append("        , '' AES_PTA_DT             , '' AES_PTU_NO             , '' AES_PTU_DT" ).append("\n"); 
		query.append("        , '' AES_DWN_NO             , '' AES_DWN_DT             , '' AES_EXPT_CTNT" ).append("\n"); 
		query.append("        , '' AES_EXPT_ID            , '' AES_TP_CD" ).append("\n"); 
		query.append("        , '' CAED_CTNT              , '' G7_EDI_CTNT            , '' MF_SMRY_RPT_NO  -- Canada" ).append("\n"); 
		query.append("        , '' B13A_XPT_CTNT          , '' CGO_CTRL_NO            , '' NDR_REF_CTNT" ).append("\n"); 
		query.append("        , '' NDR_REF_ID             , '' CAED_TP_CD				, '' VIN_CTNT" ).append("\n"); 
		query.append("FROM BKG_XTER_RQST_MST MST, BKG_XTER_CUST SH, BKG_XTER_CUST CN, BKG_XTER_CUST NF" ).append("\n"); 
		query.append("WHERE MST.XTER_SNDR_ID  = @[xter_sndr_id]" ).append("\n"); 
		query.append("AND MST.XTER_RQST_NO  = @[xter_rqst_no]" ).append("\n"); 
		query.append("AND MST.XTER_RQST_SEQ = @[xter_rqst_seq]" ).append("\n"); 
		query.append("AND MST.XTER_SNDR_ID  = SH.XTER_SNDR_ID   (+)" ).append("\n"); 
		query.append("AND MST.XTER_RQST_NO  = SH.XTER_RQST_NO   (+)" ).append("\n"); 
		query.append("AND MST.XTER_RQST_SEQ = SH.XTER_RQST_SEQ  (+) " ).append("\n"); 
		query.append("AND SH.XTER_CUST_TP_CD(+) = 'S'" ).append("\n"); 
		query.append("AND MST.XTER_SNDR_ID  = CN.XTER_SNDR_ID   (+)" ).append("\n"); 
		query.append("AND MST.XTER_RQST_NO  = CN.XTER_RQST_NO   (+)" ).append("\n"); 
		query.append("AND MST.XTER_RQST_SEQ = CN.XTER_RQST_SEQ  (+) " ).append("\n"); 
		query.append("AND CN.XTER_CUST_TP_CD(+) = 'C'" ).append("\n"); 
		query.append("AND MST.XTER_SNDR_ID  = NF.XTER_SNDR_ID   (+)" ).append("\n"); 
		query.append("AND MST.XTER_RQST_NO  = NF.XTER_RQST_NO   (+)" ).append("\n"); 
		query.append("AND MST.XTER_RQST_SEQ = NF.XTER_RQST_SEQ  (+)" ).append("\n"); 
		query.append("AND NF.XTER_CUST_TP_CD(+) = 'N'" ).append("\n"); 
		query.append("AND LENGTH(SH.LB_TAX_ID||CN.LB_TAX_ID||NF.LB_TAX_ID) > 0" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 	MST.BKG_NO, 'BR' CNT_CD" ).append("\n"); 
		query.append("		, '' MX_SHPR_TAX_ID         , '' MX_CNEE_TAX_ID         , '' MX_NTFY_TAX_ID  -- Mexico" ).append("\n"); 
		query.append("        , '' TR_SHPR_TAX_ID         , '' TR_CNEE_TAX_ID         , '' TR_NTFY_TAX_ID  -- Turkey" ).append("\n"); 
		query.append("        , '' IL_SHPR_TAX_ID         , '' IL_CNEE_TAX_ID         , '' IL_NTFY_TAX_ID  -- Israel" ).append("\n"); 
		query.append("        , '' LB_SHPR_TAX_ID         , '' LB_CNEE_TAX_ID         , '' LB_NTFY_TAX_ID  -- Lebanon" ).append("\n"); 
		query.append("        , SH.BRZ_TAX_ID BR_SHPR_TAX_ID  -- Brazil" ).append("\n"); 
		query.append("        , CN.BRZ_TAX_ID BR_CNEE_TAX_ID" ).append("\n"); 
		query.append("        , NF.BRZ_TAX_ID BR_NTFY_TAX_ID" ).append("\n"); 
		query.append("        , '' AES_INLND_TRNS_NO      , '' AES_PTA_NO1            , '' AES_PTA_NO2     -- USA" ).append("\n"); 
		query.append("        , '' AES_PTA_DT             , '' AES_PTU_NO             , '' AES_PTU_DT" ).append("\n"); 
		query.append("        , '' AES_DWN_NO             , '' AES_DWN_DT             , '' AES_EXPT_CTNT" ).append("\n"); 
		query.append("        , '' AES_EXPT_ID            , '' AES_TP_CD" ).append("\n"); 
		query.append("        , '' CAED_CTNT              , '' G7_EDI_CTNT            , '' MF_SMRY_RPT_NO  -- Canada" ).append("\n"); 
		query.append("        , '' B13A_XPT_CTNT          , '' CGO_CTRL_NO            , '' NDR_REF_CTNT" ).append("\n"); 
		query.append("        , '' NDR_REF_ID             , '' CAED_TP_CD				, '' VIN_CTNT" ).append("\n"); 
		query.append("FROM BKG_XTER_RQST_MST MST, BKG_XTER_CUST SH, BKG_XTER_CUST CN, BKG_XTER_CUST NF" ).append("\n"); 
		query.append("WHERE MST.XTER_SNDR_ID  = @[xter_sndr_id]" ).append("\n"); 
		query.append("AND MST.XTER_RQST_NO  = @[xter_rqst_no]" ).append("\n"); 
		query.append("AND MST.XTER_RQST_SEQ = @[xter_rqst_seq]" ).append("\n"); 
		query.append("AND MST.XTER_SNDR_ID  = SH.XTER_SNDR_ID   (+)" ).append("\n"); 
		query.append("AND MST.XTER_RQST_NO  = SH.XTER_RQST_NO   (+)" ).append("\n"); 
		query.append("AND MST.XTER_RQST_SEQ = SH.XTER_RQST_SEQ  (+) " ).append("\n"); 
		query.append("AND SH.XTER_CUST_TP_CD(+) = 'S'" ).append("\n"); 
		query.append("AND MST.XTER_SNDR_ID  = CN.XTER_SNDR_ID   (+)" ).append("\n"); 
		query.append("AND MST.XTER_RQST_NO  = CN.XTER_RQST_NO   (+)" ).append("\n"); 
		query.append("AND MST.XTER_RQST_SEQ = CN.XTER_RQST_SEQ  (+) " ).append("\n"); 
		query.append("AND CN.XTER_CUST_TP_CD(+) = 'C'" ).append("\n"); 
		query.append("AND MST.XTER_SNDR_ID  = NF.XTER_SNDR_ID   (+)" ).append("\n"); 
		query.append("AND MST.XTER_RQST_NO  = NF.XTER_RQST_NO   (+)" ).append("\n"); 
		query.append("AND MST.XTER_RQST_SEQ = NF.XTER_RQST_SEQ  (+)" ).append("\n"); 
		query.append("AND NF.XTER_CUST_TP_CD(+) = 'N'" ).append("\n"); 
		query.append("AND LENGTH(SH.BRZ_TAX_ID||CN.BRZ_TAX_ID||NF.BRZ_TAX_ID) > 0" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 	MST.BKG_NO, 'US' CNT_CD" ).append("\n"); 
		query.append("		, '' MX_SHPR_TAX_ID         , '' MX_CNEE_TAX_ID         , '' MX_NTFY_TAX_ID  -- Mexico" ).append("\n"); 
		query.append("        , '' TR_SHPR_TAX_ID         , '' TR_CNEE_TAX_ID         , '' TR_NTFY_TAX_ID  -- Turkey" ).append("\n"); 
		query.append("        , '' IL_SHPR_TAX_ID         , '' IL_CNEE_TAX_ID         , '' IL_NTFY_TAX_ID  -- Israel" ).append("\n"); 
		query.append("        , '' LB_SHPR_TAX_ID         , '' LB_CNEE_TAX_ID         , '' LB_NTFY_TAX_ID  -- Lebanon" ).append("\n"); 
		query.append("        , '' BR_SHPR_TAX_ID         , '' BR_CNEE_TAX_ID         , '' BR_NTFY_TAX_ID  -- Brazil        " ).append("\n"); 
		query.append("        , AES.AES_INLND_TRNS_NO 	AES_INLND_TRNS_NO     -- USA" ).append("\n"); 
		query.append("        , AES.AES_PTA_NO1 			AES_PTA_NO1" ).append("\n"); 
		query.append("        , AES.AES_PTA_NO2 			AES_PTA_NO2" ).append("\n"); 
		query.append("        , TO_CHAR(AES.AES_PTA_DT, 'MM-DD-YYYY') AES_PTA_DT" ).append("\n"); 
		query.append("        , AES.AES_PTU_NO						AES_PTU_NO" ).append("\n"); 
		query.append("        , TO_CHAR(AES.AES_PTU_DT, 'MM-DD-YYYY')	AES_PTU_DT" ).append("\n"); 
		query.append("        , AES.AES_DWN_NO						AES_DWN_NO" ).append("\n"); 
		query.append("        , TO_CHAR(AES.AES_DWN_DT, 'MM-DD-YYYY') AES_DWN_DT" ).append("\n"); 
		query.append("        , AES.AES_EXPT_CTNT			AES_EXPT_CTNT" ).append("\n"); 
		query.append("        , AES.AES_EXPT_ID           AES_EXPT_ID" ).append("\n"); 
		query.append("        , CASE WHEN AES.AES_FLG = 'Y' THEN 'AE'" ).append("\n"); 
		query.append("               WHEN AES.PTA_FLG = 'Y' THEN 'PA'" ).append("\n"); 
		query.append("               WHEN AES.PTU_FLG	= 'Y' THEN 'PU'" ).append("\n"); 
		query.append("               WHEN AES.DWN_FLG = 'Y' THEN 'DN'" ).append("\n"); 
		query.append("               WHEN AES.EXPT_FLG= 'Y' THEN 'EX'" ).append("\n"); 
		query.append("               ELSE NULL" ).append("\n"); 
		query.append("          END AES_TP_CD" ).append("\n"); 
		query.append("        , '' CAED_CTNT              , '' G7_EDI_CTNT            , '' MF_SMRY_RPT_NO  -- Canada" ).append("\n"); 
		query.append("        , '' B13A_XPT_CTNT          , '' CGO_CTRL_NO            , '' NDR_REF_CTNT" ).append("\n"); 
		query.append("        , '' NDR_REF_ID             , '' CAED_TP_CD				, AES.VIN_CTNT AS VIN_CTNT" ).append("\n"); 
		query.append("FROM BKG_XTER_RQST_MST MST, BKG_XTER_AES AES" ).append("\n"); 
		query.append("WHERE MST.XTER_SNDR_ID  = @[xter_sndr_id]" ).append("\n"); 
		query.append("AND MST.XTER_RQST_NO  = @[xter_rqst_no]" ).append("\n"); 
		query.append("AND MST.XTER_RQST_SEQ = @[xter_rqst_seq]" ).append("\n"); 
		query.append("AND MST.XTER_SNDR_ID  = AES.XTER_SNDR_ID" ).append("\n"); 
		query.append("AND MST.XTER_RQST_NO  = AES.XTER_RQST_NO" ).append("\n"); 
		query.append("AND MST.XTER_RQST_SEQ = AES.XTER_RQST_SEQ" ).append("\n"); 
		query.append("AND LENGTH(AES.AES_INLND_TRNS_NO||AES.AES_PTA_NO1||AES.AES_PTA_NO2||AES.AES_PTU_NO||AES.AES_DWN_NO||AES.AES_EXPT_ID) > 0" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT 	MST.BKG_NO, 'CA' CNT_CD" ).append("\n"); 
		query.append("		, '' MX_SHPR_TAX_ID         , '' MX_CNEE_TAX_ID         , '' MX_NTFY_TAX_ID  -- Mexico" ).append("\n"); 
		query.append("        , '' TR_SHPR_TAX_ID         , '' TR_CNEE_TAX_ID         , '' TR_NTFY_TAX_ID  -- Turkey" ).append("\n"); 
		query.append("        , '' IL_SHPR_TAX_ID         , '' IL_CNEE_TAX_ID         , '' IL_NTFY_TAX_ID  -- Israel" ).append("\n"); 
		query.append("        , '' LB_SHPR_TAX_ID         , '' LB_CNEE_TAX_ID         , '' LB_NTFY_TAX_ID  -- Lebanon" ).append("\n"); 
		query.append("        , '' BR_SHPR_TAX_ID         , '' BR_CNEE_TAX_ID         , '' BR_NTFY_TAX_ID  -- Brazil" ).append("\n"); 
		query.append("        , '' AES_INLND_TRNS_NO      , '' AES_PTA_NO1            , '' AES_PTA_NO2     -- USA" ).append("\n"); 
		query.append("        , '' AES_PTA_DT             , '' AES_PTU_NO             , '' AES_PTU_DT" ).append("\n"); 
		query.append("        , '' AES_DWN_NO             , '' AES_DWN_DT             , '' AES_EXPT_CTNT" ).append("\n"); 
		query.append("        , '' AES_EXPT_ID            , '' AES_TP_CD        " ).append("\n"); 
		query.append("        , CAED.CAED_CTNT1" ).append("\n"); 
		query.append("			||decode(nvl(CAED.CAED_CTNT2, 'x'), 'x', '', '-'||CAED.CAED_CTNT2)" ).append("\n"); 
		query.append("			||decode(nvl(CAED.CAED_CTNT3, 'x'), 'x', '', '-'||CAED.CAED_CTNT3)	CAED_CTNT  -- Canada" ).append("\n"); 
		query.append("        , CAED.G7_EDI_CTNT1" ).append("\n"); 
		query.append("			||decode(nvl(CAED.G7_EDI_CTNT2, 'x'), 'x', '', '-'||CAED.G7_EDI_CTNT2) G7_EDI_CTNT" ).append("\n"); 
		query.append("		, CAED.SMRY_RPT_CTNT1" ).append("\n"); 
		query.append("			||decode(nvl(CAED.SMRY_RPT_CTNT2, 'x'), 'x', '', '-'||CAED.SMRY_RPT_CTNT2) MF_SMRY_RPT_NO" ).append("\n"); 
		query.append("        , TO_CHAR(CAED.B13A_DT, 'MM-DD-YYYY')" ).append("\n"); 
		query.append("			||decode(nvl(CAED.B13A_CTNT1, 'x'), 'x', '', '-'||CAED.B13A_CTNT1)" ).append("\n"); 
		query.append("			||decode(nvl(CAED.B13A_CTNT2, 'x'), 'x', '', '-'||CAED.B13A_CTNT2) B13A_XPT_CTNT" ).append("\n"); 
		query.append("        , CAED.INLND_TZ_CGO_CTNT 	CGO_CTRL_NO" ).append("\n"); 
		query.append("        , CAED.MNL_INP_CTNT			NDR_REF_CTNT" ).append("\n"); 
		query.append("        , CAED.NON_DECL_CTNT 		NDR_REF_ID" ).append("\n"); 
		query.append("        , CASE WHEN CAED.CAED_FLG = 'Y' THEN 'CE'" ).append("\n"); 
		query.append("               WHEN CAED.G7_EDI_FLG = 'Y' THEN 'G7'" ).append("\n"); 
		query.append("               WHEN CAED.SMRY_RPT_FLG = 'Y' THEN 'SM'" ).append("\n"); 
		query.append("               WHEN CAED.B13A_FLG = 'Y' THEN 'EX'" ).append("\n"); 
		query.append("               WHEN CAED.INLND_TZ_CGO_FLG = 'Y' THEN 'IT'" ).append("\n"); 
		query.append("               WHEN CAED.NON_DECL_FLG = 'Y' THEN 'ND'" ).append("\n"); 
		query.append("               ELSE NULL" ).append("\n"); 
		query.append("          END CAED_TP_CD" ).append("\n"); 
		query.append("		, '' VIN_CTNT" ).append("\n"); 
		query.append("FROM BKG_XTER_RQST_MST MST, BKG_XTER_CAED CAED" ).append("\n"); 
		query.append("WHERE MST.XTER_SNDR_ID  = @[xter_sndr_id]" ).append("\n"); 
		query.append("AND MST.XTER_RQST_NO  = @[xter_rqst_no]" ).append("\n"); 
		query.append("AND MST.XTER_RQST_SEQ = @[xter_rqst_seq]" ).append("\n"); 
		query.append("AND MST.XTER_SNDR_ID  = CAED.XTER_SNDR_ID (+)" ).append("\n"); 
		query.append("AND MST.XTER_RQST_NO  = CAED.XTER_RQST_NO (+)" ).append("\n"); 
		query.append("AND MST.XTER_RQST_SEQ = CAED.XTER_RQST_SEQ(+)" ).append("\n"); 
		query.append("AND LENGTH(CAED.CAED_CTNT1||CAED.G7_EDI_CTNT1||CAED.SMRY_RPT_CTNT1||CAED.B13A_DT||CAED.INLND_TZ_CGO_CTNT||CAED.MNL_INP_CTNT||CAED.NON_DECL_CTNT) > 0" ).append("\n"); 

	}
}