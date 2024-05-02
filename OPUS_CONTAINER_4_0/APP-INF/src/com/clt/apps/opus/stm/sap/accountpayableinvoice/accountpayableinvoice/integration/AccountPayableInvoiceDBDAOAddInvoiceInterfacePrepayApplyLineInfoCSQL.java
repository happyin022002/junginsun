/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AccountPayableInvoiceDBDAOAddInvoiceInterfacePrepayApplyLineInfoCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.10
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.10 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountPayableInvoiceDBDAOAddInvoiceInterfacePrepayApplyLineInfoCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AccountPayableInvoiceDBDAOAddInvoiceInterfacePrepayApplyLineInfoCSQL
	  * </pre>
	  */
	public AccountPayableInvoiceDBDAOAddInvoiceInterfacePrepayApplyLineInfoCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("functional_currency",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("creation_user",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_xch_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ppay_aply_gl_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_xch_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ppay_inv_line_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ppay_aply_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_xch_rt_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ppay_inv_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.integration").append("\n"); 
		query.append("FileName : AccountPayableInvoiceDBDAOAddInvoiceInterfacePrepayApplyLineInfoCSQL").append("\n"); 
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
		query.append("INSERT INTO SAP_INV_DTL" ).append("\n"); 
		query.append("   ( ACCTG_DT" ).append("\n"); 
		query.append("   , ACCL_BK_PST_FLG" ).append("\n"); 
		query.append("   , ASET_ADD_FLG" ).append("\n"); 
		query.append("   , ASET_TRAK_FLG" ).append("\n"); 
		query.append("   , CSH_BK_PST_FLG" ).append("\n"); 
		query.append("   , DTRB_LINE_NO " ).append("\n"); 
		query.append("   , DTRB_COA_CO_CD" ).append("\n"); 
		query.append("   , DTRB_COA_RGN_CD" ).append("\n"); 
		query.append("   , DTRB_COA_CTR_CD" ).append("\n"); 
		query.append("   , DTRB_COA_ACCT_NO" ).append("\n"); 
		query.append("   , DTRB_COA_VVD_CD" ).append("\n"); 
		query.append("   , DTRB_COA_INTER_CO_CD" ).append("\n"); 
		query.append("   , INV_SEQ" ).append("\n"); 
		query.append("   , LINE_TP_LU_CD" ).append("\n"); 
		query.append("   , EFF_YRMON" ).append("\n"); 
		query.append("   , DTRB_AMT" ).append("\n"); 
		query.append("   , DTRB_FUNC_AMT" ).append("\n"); 
		query.append("   , BAT_SEQ" ).append("\n"); 
		query.append("   , DTRB_DESC" ).append("\n"); 
		query.append("   , MTCH_STS_FLG" ).append("\n"); 
		query.append("   , ACCTG_PST_FLG" ).append("\n"); 
		query.append("   , RVS_FLG" ).append("\n"); 
		query.append("   , DTRB_XCH_DT" ).append("\n"); 
		query.append("   , DTRB_XCH_RT" ).append("\n"); 
		query.append("   , DTRB_XCH_RT_TP_CD" ).append("\n"); 
		query.append("   , ATTR_CTNT1" ).append("\n"); 
		query.append("   , ATTR_CTNT2" ).append("\n"); 
		query.append("   , ATTR_CTNT3" ).append("\n"); 
		query.append("   , ATTR_CTNT4" ).append("\n"); 
		query.append("   , ATTR_CTNT5" ).append("\n"); 
		query.append("   , ATTR_CTNT6" ).append("\n"); 
		query.append("   , ATTR_CTNT7" ).append("\n"); 
		query.append("   , ATTR_CTNT8" ).append("\n"); 
		query.append("   , ATTR_CTNT9" ).append("\n"); 
		query.append("   , ATTR_CTNT10" ).append("\n"); 
		query.append("   , ATTR_CTNT11" ).append("\n"); 
		query.append("   , ATTR_CTNT12" ).append("\n"); 
		query.append("   , ATTR_CTNT13" ).append("\n"); 
		query.append("   , ATTR_CTNT14" ).append("\n"); 
		query.append("   , ATTR_CTNT15" ).append("\n"); 
		query.append("   , ATTR_CATE_NM" ).append("\n"); 
		query.append("   , PPAY_RMN_AMT" ).append("\n"); 
		query.append("   , GLO_ATTR_CATE_NM" ).append("\n"); 
		query.append("   , GLO_ATTR_CTNT1" ).append("\n"); 
		query.append("   , GLO_ATTR_CTNT2" ).append("\n"); 
		query.append("   , GLO_ATTR_CTNT3" ).append("\n"); 
		query.append("   , GLO_ATTR_CTNT4" ).append("\n"); 
		query.append("   , GLO_ATTR_CTNT5" ).append("\n"); 
		query.append("   , GLO_ATTR_CTNT6" ).append("\n"); 
		query.append("   , GLO_ATTR_CTNT7" ).append("\n"); 
		query.append("   , GLO_ATTR_CTNT8" ).append("\n"); 
		query.append("   , GLO_ATTR_CTNT9" ).append("\n"); 
		query.append("   , GLO_ATTR_CTNT10" ).append("\n"); 
		query.append("   , GLO_ATTR_CTNT11" ).append("\n"); 
		query.append("   , GLO_ATTR_CTNT12" ).append("\n"); 
		query.append("   , GLO_ATTR_CTNT13" ).append("\n"); 
		query.append("   , GLO_ATTR_CTNT14" ).append("\n"); 
		query.append("   , GLO_ATTR_CTNT15" ).append("\n"); 
		query.append("   , GLO_ATTR_CTNT16" ).append("\n"); 
		query.append("   , GLO_ATTR_CTNT17" ).append("\n"); 
		query.append("   , GLO_ATTR_CTNT18" ).append("\n"); 
		query.append("   , GLO_ATTR_CTNT19" ).append("\n"); 
		query.append("   , GLO_ATTR_CTNT20" ).append("\n"); 
		query.append("   , DTRB_MTCH_TP_NM" ).append("\n"); 
		query.append("   , INV_DTRB_SEQ" ).append("\n"); 
		query.append("   , PRNT_RVS_DTRB_SEQ" ).append("\n"); 
		query.append("   , ACCTG_EVNT_SEQ" ).append("\n"); 
		query.append("   , PPAY_DTRB_SEQ" ).append("\n"); 
		query.append("   , DTRB_CLSS_NM" ).append("\n"); 
		query.append("   , DTRB_VAT_CD" ).append("\n"); 
		query.append("   , OLD_DTRB_SEQ" ).append("\n"); 
		query.append("   , CRE_USR_ID" ).append("\n"); 
		query.append("   , CRE_DT" ).append("\n"); 
		query.append("   , UPD_USR_ID" ).append("\n"); 
		query.append("   , UPD_DT" ).append("\n"); 
		query.append("   , DTRB_CD_CMB_SEQ" ).append("\n"); 
		query.append("   , INV_RND_AMT" ).append("\n"); 
		query.append("   , PPAY_INV_SEQ" ).append("\n"); 
		query.append("   , PPAY_LINE_NO" ).append("\n"); 
		query.append("   )" ).append("\n"); 
		query.append("   SELECT TO_DATE(@[ppay_aply_gl_dt],'YYYYMMDD')" ).append("\n"); 
		query.append("        , SID.ACCL_BK_PST_FLG" ).append("\n"); 
		query.append("        , SID.ASET_ADD_FLG" ).append("\n"); 
		query.append("        , SID.ASET_TRAK_FLG" ).append("\n"); 
		query.append("        , SID.CSH_BK_PST_FLG" ).append("\n"); 
		query.append("        , (SELECT MAX(SID2.DTRB_LINE_NO) FROM SAP_INV_DTL SID2 WHERE SID2.INV_SEQ = @[inv_seq]) + 1 AS DTRB_LINE_NO" ).append("\n"); 
		query.append("        , SID.DTRB_COA_CO_CD" ).append("\n"); 
		query.append("        , SID.DTRB_COA_RGN_CD" ).append("\n"); 
		query.append("        , SID.DTRB_COA_CTR_CD" ).append("\n"); 
		query.append("        , SID.DTRB_COA_ACCT_NO" ).append("\n"); 
		query.append("        , SID.DTRB_COA_VVD_CD" ).append("\n"); 
		query.append("        , SID.DTRB_COA_INTER_CO_CD" ).append("\n"); 
		query.append("        , @[inv_seq]" ).append("\n"); 
		query.append("        , 'PREPAY' AS LINE_TP_LU_CD" ).append("\n"); 
		query.append("        , SUBSTR(@[ppay_aply_gl_dt], 1, 6) AS EFF_YRMON" ).append("\n"); 
		query.append("        , @[ppay_aply_amt] * (-1) AS DTRB_AMT" ).append("\n"); 
		query.append("        , DECODE((SELECT SIH.INV_XCH_RT FROM SAP_INV_HDR SIH WHERE SIH.INV_SEQ = @[inv_seq]), NULL, NULL," ).append("\n"); 
		query.append("                  ROUND(@[ppay_aply_amt] * (-1) * (SELECT SIH.INV_XCH_RT FROM SAP_INV_HDR SIH WHERE SIH.INV_SEQ = @[inv_seq]), " ).append("\n"); 
		query.append("                               (SELECT NVL(MC.DP_PRCS_KNT, 0) FROM MDM_CURRENCY MC WHERE MC.CURR_CD = @[functional_currency]))) AS DTRB_FUNC_AMT" ).append("\n"); 
		query.append("        , SID.BAT_SEQ" ).append("\n"); 
		query.append("        , SID.DTRB_DESC" ).append("\n"); 
		query.append("        , 'A' AS MTCH_STS_FLG" ).append("\n"); 
		query.append("        , 'N' AS ACCTG_PST_FLG" ).append("\n"); 
		query.append("        , NULL RVS_FLG" ).append("\n"); 
		query.append("        , TO_DATE(@[inv_xch_dt],'YYYYMMDD')" ).append("\n"); 
		query.append("        , @[inv_xch_rt]" ).append("\n"); 
		query.append("        , @[inv_xch_rt_tp_cd]" ).append("\n"); 
		query.append("        , NVL((SELECT SID1.ATTR_CTNT1 FROM SAP_INV_DTL SID1 WHERE SID1.INV_SEQ = @[inv_seq] AND SID1.LINE_TP_LU_CD NOT IN ('PREPAY', 'TAX') AND SID1.ATTR_CTNT1 IS NOT NULL AND ROWNUM = 1), SID.ATTR_CTNT1) AS ATTR_CTNT1" ).append("\n"); 
		query.append("        , SID.ATTR_CTNT2" ).append("\n"); 
		query.append("        , SID.ATTR_CTNT3" ).append("\n"); 
		query.append("        , SID.ATTR_CTNT4" ).append("\n"); 
		query.append("        , SID.ATTR_CTNT5" ).append("\n"); 
		query.append("        , SID.ATTR_CTNT6" ).append("\n"); 
		query.append("        , SID.ATTR_CTNT7" ).append("\n"); 
		query.append("        , SID.ATTR_CTNT8" ).append("\n"); 
		query.append("        , SID.ATTR_CTNT9" ).append("\n"); 
		query.append("        , SID.ATTR_CTNT10" ).append("\n"); 
		query.append("        , NVL((SELECT SID1.ATTR_CTNT11 FROM SAP_INV_DTL SID1 WHERE SID1.INV_SEQ = @[inv_seq] AND SID1.LINE_TP_LU_CD NOT IN ('PREPAY', 'TAX') AND SID1.ATTR_CTNT11 IS NOT NULL AND ROWNUM = 1), SID.ATTR_CTNT11) AS ATTR_CTNT11" ).append("\n"); 
		query.append("        , NVL((SELECT SID1.ATTR_CTNT12 FROM SAP_INV_DTL SID1 WHERE SID1.INV_SEQ = @[inv_seq] AND SID1.LINE_TP_LU_CD NOT IN ('PREPAY', 'TAX') AND SID1.ATTR_CTNT12 IS NOT NULL AND ROWNUM = 1), SID.ATTR_CTNT12) AS ATTR_CTNT12" ).append("\n"); 
		query.append("        , SID.ATTR_CTNT13" ).append("\n"); 
		query.append("        , NVL((SELECT SID1.ATTR_CTNT14 FROM SAP_INV_DTL SID1 WHERE SID1.INV_SEQ = @[inv_seq] AND SID1.LINE_TP_LU_CD NOT IN ('PREPAY', 'TAX') AND SID1.ATTR_CTNT14 IS NOT NULL AND ROWNUM = 1), SID.ATTR_CTNT14) AS ATTR_CTNT14" ).append("\n"); 
		query.append("        , SID.ATTR_CTNT15" ).append("\n"); 
		query.append("        , SID.ATTR_CATE_NM" ).append("\n"); 
		query.append("        , NULL AS PPAY_RMN_AMT" ).append("\n"); 
		query.append("        , SID.GLO_ATTR_CATE_NM" ).append("\n"); 
		query.append("        , SID.GLO_ATTR_CTNT1" ).append("\n"); 
		query.append("        , SID.GLO_ATTR_CTNT2" ).append("\n"); 
		query.append("        , SID.GLO_ATTR_CTNT3" ).append("\n"); 
		query.append("        , SID.GLO_ATTR_CTNT4" ).append("\n"); 
		query.append("        , SID.GLO_ATTR_CTNT5" ).append("\n"); 
		query.append("        , SID.GLO_ATTR_CTNT6" ).append("\n"); 
		query.append("        , SID.GLO_ATTR_CTNT7" ).append("\n"); 
		query.append("        , SID.GLO_ATTR_CTNT8" ).append("\n"); 
		query.append("        , SID.GLO_ATTR_CTNT9" ).append("\n"); 
		query.append("        , SID.GLO_ATTR_CTNT10" ).append("\n"); 
		query.append("        , SID.GLO_ATTR_CTNT11" ).append("\n"); 
		query.append("        , SID.GLO_ATTR_CTNT12" ).append("\n"); 
		query.append("        , SID.GLO_ATTR_CTNT13" ).append("\n"); 
		query.append("        , SID.GLO_ATTR_CTNT14" ).append("\n"); 
		query.append("        , SID.GLO_ATTR_CTNT15" ).append("\n"); 
		query.append("        , SID.GLO_ATTR_CTNT16" ).append("\n"); 
		query.append("        , SID.GLO_ATTR_CTNT17" ).append("\n"); 
		query.append("        , SID.GLO_ATTR_CTNT18" ).append("\n"); 
		query.append("        , SID.GLO_ATTR_CTNT19" ).append("\n"); 
		query.append("        , SID.GLO_ATTR_CTNT20" ).append("\n"); 
		query.append("        , 'ITEM_TO_RECEIPT' AS DTRB_MTCH_TP_NM" ).append("\n"); 
		query.append("        , SAP_INV_DTL_SEQ.NEXTVAL AS INV_DTRB_SEQ" ).append("\n"); 
		query.append("        , NULL AS PRNT_RVS_DTRB_SEQ" ).append("\n"); 
		query.append("        , NULL AS ACCTG_EVNT_SEQ" ).append("\n"); 
		query.append("        , SID.INV_DTRB_SEQ AS PPAY_DTRB_SEQ" ).append("\n"); 
		query.append("        , SID.DTRB_CLSS_NM" ).append("\n"); 
		query.append("        , SID.DTRB_VAT_CD" ).append("\n"); 
		query.append("        , SID.OLD_DTRB_SEQ" ).append("\n"); 
		query.append("        , @[creation_user]" ).append("\n"); 
		query.append("        , SYSDATE" ).append("\n"); 
		query.append("        , @[usr_id]" ).append("\n"); 
		query.append("        , SYSDATE" ).append("\n"); 
		query.append("        , SID.DTRB_CD_CMB_SEQ" ).append("\n"); 
		query.append("        , 0 AS INV_RND_AMT" ).append("\n"); 
		query.append("        , SID.INV_SEQ AS PPAY_INV_SEQ" ).append("\n"); 
		query.append("        , SID.DTRB_LINE_NO AS PPAY_LINE_NO" ).append("\n"); 
		query.append("   FROM   SAP_INV_DTL SID" ).append("\n"); 
		query.append("   WHERE  SID.INV_SEQ = (SELECT SIH.INV_SEQ FROM SAP_INV_HDR SIH WHERE SIH.INV_NO = @[ppay_inv_no] AND ROWNUM = 1)" ).append("\n"); 
		query.append("   AND    SID.DTRB_LINE_NO = @[ppay_inv_line_no]" ).append("\n"); 

	}
}