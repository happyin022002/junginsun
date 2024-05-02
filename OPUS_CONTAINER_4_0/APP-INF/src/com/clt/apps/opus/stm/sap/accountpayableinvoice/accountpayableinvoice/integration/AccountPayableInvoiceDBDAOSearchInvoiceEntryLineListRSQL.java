/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountPayableInvoiceDBDAOSearchInvoiceEntryLineListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.09.17
*@LastModifier : 
*@LastVersion : 1.0
* 2014.09.17 
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

public class AccountPayableInvoiceDBDAOSearchInvoiceEntryLineListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Invoice의 차변인 Line 정보를 조회하여 Line내역에 나타냄
	  * </pre>
	  */
	public AccountPayableInvoiceDBDAOSearchInvoiceEntryLineListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.integration").append("\n"); 
		query.append("FileName : AccountPayableInvoiceDBDAOSearchInvoiceEntryLineListRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("   TO_CHAR(D.ACCTG_DT, 'YYYY-MM-DD') AS  ACCTG_DT" ).append("\n"); 
		query.append(" , D.ACCL_BK_PST_FLG" ).append("\n"); 
		query.append(" , D.ASET_ADD_FLG" ).append("\n"); 
		query.append(" , D.ASET_TRAK_FLG" ).append("\n"); 
		query.append(" , D.CSH_BK_PST_FLG" ).append("\n"); 
		query.append(" , D.DTRB_LINE_NO" ).append("\n"); 
		query.append(" , SLCC.SGM_CTNT1                   AS DTRB_COA_CO_CD  -- COMPANY_CODE" ).append("\n"); 
		query.append(" , SLCC.SGM_CTNT2                   AS DTRB_COA_RGN_CD -- REGION_CODE" ).append("\n"); 
		query.append(" , SLCC.SGM_CTNT3                   AS DTRB_COA_CTR_CD -- CENTER_CODE" ).append("\n"); 
		query.append(" , SLCC.SGM_CTNT4                   AS DTRB_COA_ACCT_NO -- ACCOUNT_CODE" ).append("\n"); 
		query.append(" , SLCC.SGM_CTNT5                   AS DTRB_COA_INTER_CO_CD --INTERCOMPANY_CODE" ).append("\n"); 
		query.append(" , SLCC.SGM_CTNT6                   AS DTRB_COA_VVD_CD  -- VVD_CODE" ).append("\n"); 
		query.append(" , D.INV_SEQ" ).append("\n"); 
		query.append(" , D.LINE_TP_LU_CD" ).append("\n"); 
		query.append(" , D.EFF_YRMON" ).append("\n"); 
		query.append(" , TRIM(SAP_GET_CUR_AMT_FNC(H.INV_CURR_CD, D.DTRB_AMT))  DTRB_AMT" ).append("\n"); 
		query.append(" , D.DTRB_FUNC_AMT  " ).append("\n"); 
		query.append(" , D.BAT_SEQ" ).append("\n"); 
		query.append(" , D.DTRB_DESC" ).append("\n"); 
		query.append(" , D.MTCH_STS_FLG" ).append("\n"); 
		query.append(" , D.ACCTG_PST_FLG" ).append("\n"); 
		query.append(" , D.RVS_FLG" ).append("\n"); 
		query.append(" , D.DTRB_XCH_DT" ).append("\n"); 
		query.append(" , D.DTRB_XCH_RT" ).append("\n"); 
		query.append(" , D.DTRB_XCH_RT_TP_CD" ).append("\n"); 
		query.append(" , D.ATTR_CTNT1" ).append("\n"); 
		query.append(" , D.ATTR_CTNT2" ).append("\n"); 
		query.append(" , D.ATTR_CTNT3" ).append("\n"); 
		query.append(" , D.ATTR_CTNT4" ).append("\n"); 
		query.append(" , D.ATTR_CTNT5" ).append("\n"); 
		query.append(" , D.ATTR_CTNT6" ).append("\n"); 
		query.append(" , D.ATTR_CTNT7" ).append("\n"); 
		query.append(" , D.ATTR_CTNT8" ).append("\n"); 
		query.append(" , D.ATTR_CTNT9" ).append("\n"); 
		query.append(" , D.ATTR_CTNT10" ).append("\n"); 
		query.append(" , D.ATTR_CTNT11" ).append("\n"); 
		query.append(" , D.ATTR_CTNT12" ).append("\n"); 
		query.append(" , D.ATTR_CTNT13" ).append("\n"); 
		query.append(" , D.ATTR_CTNT14" ).append("\n"); 
		query.append(" , D.ATTR_CTNT15" ).append("\n"); 
		query.append(" , D.ATTR_CATE_NM" ).append("\n"); 
		query.append(" , D.PPAY_RMN_AMT" ).append("\n"); 
		query.append(" , D.GLO_ATTR_CATE_NM" ).append("\n"); 
		query.append(" , D.GLO_ATTR_CTNT1" ).append("\n"); 
		query.append(" , D.GLO_ATTR_CTNT2" ).append("\n"); 
		query.append(" , D.GLO_ATTR_CTNT3" ).append("\n"); 
		query.append(" , D.GLO_ATTR_CTNT4" ).append("\n"); 
		query.append(" , D.GLO_ATTR_CTNT5" ).append("\n"); 
		query.append(" , D.GLO_ATTR_CTNT6" ).append("\n"); 
		query.append(" , D.GLO_ATTR_CTNT7" ).append("\n"); 
		query.append(" , D.GLO_ATTR_CTNT8" ).append("\n"); 
		query.append(" , D.GLO_ATTR_CTNT9" ).append("\n"); 
		query.append(" , D.GLO_ATTR_CTNT10" ).append("\n"); 
		query.append(" , D.GLO_ATTR_CTNT11" ).append("\n"); 
		query.append(" , D.GLO_ATTR_CTNT12" ).append("\n"); 
		query.append(" , D.GLO_ATTR_CTNT13" ).append("\n"); 
		query.append(" , D.GLO_ATTR_CTNT14" ).append("\n"); 
		query.append(" , D.GLO_ATTR_CTNT15" ).append("\n"); 
		query.append(" , D.GLO_ATTR_CTNT16" ).append("\n"); 
		query.append(" , D.GLO_ATTR_CTNT17" ).append("\n"); 
		query.append(" , D.GLO_ATTR_CTNT18" ).append("\n"); 
		query.append(" , D.GLO_ATTR_CTNT19" ).append("\n"); 
		query.append(" , D.GLO_ATTR_CTNT20" ).append("\n"); 
		query.append(" , D.DTRB_MTCH_TP_NM" ).append("\n"); 
		query.append(" , D.INV_DTRB_SEQ" ).append("\n"); 
		query.append(" , D.PRNT_RVS_DTRB_SEQ" ).append("\n"); 
		query.append(" , D.ACCTG_EVNT_SEQ" ).append("\n"); 
		query.append(" , D.PPAY_DTRB_SEQ" ).append("\n"); 
		query.append(" , D.DTRB_CLSS_NM" ).append("\n"); 
		query.append(" , D.DTRB_VAT_CD" ).append("\n"); 
		query.append(" , D.OLD_DTRB_SEQ" ).append("\n"); 
		query.append(" , D.CRE_USR_ID" ).append("\n"); 
		query.append(" , D.CRE_DT" ).append("\n"); 
		query.append(" , D.DTRB_CD_CMB_SEQ" ).append("\n"); 
		query.append(" , D.UPD_USR_ID" ).append("\n"); 
		query.append(" , D.UPD_DT" ).append("\n"); 
		query.append(" , '' USR_ID" ).append("\n"); 
		query.append(" , D.INV_RND_AMT" ).append("\n"); 
		query.append(" , H.INV_CURR_CD " ).append("\n"); 
		query.append(" , (SELECT D.LU_DESC" ).append("\n"); 
		query.append("    FROM  SCO_LU_HDR H, SCO_LU_DTL D" ).append("\n"); 
		query.append("    WHERE H.LU_TP_CD = D.LU_TP_CD " ).append("\n"); 
		query.append("    AND   H.LU_TP_CD = 'AP TAX CODE'" ).append("\n"); 
		query.append("    AND   H.LU_APPL_CD = 'SAP'" ).append("\n"); 
		query.append("    AND   D.LU_CD = D.DTRB_VAT_CD AND ROWNUM=1 )DTRB_VAT_NM" ).append("\n"); 
		query.append(" , (SELECT D.ATTR_CTNT1" ).append("\n"); 
		query.append("    FROM  SCO_LU_HDR H, SCO_LU_DTL D" ).append("\n"); 
		query.append("    WHERE H.LU_TP_CD = D.LU_TP_CD " ).append("\n"); 
		query.append("    AND   H.LU_TP_CD = 'AP TAX CODE'" ).append("\n"); 
		query.append("    AND   H.LU_APPL_CD = 'SAP'" ).append("\n"); 
		query.append("    AND   D.LU_CD = D.DTRB_VAT_CD AND ROWNUM=1 )DTRB_VAT_RT" ).append("\n"); 
		query.append("FROM    SAP_INV_HDR H" ).append("\n"); 
		query.append("      , SAP_INV_DTL D" ).append("\n"); 
		query.append("      , SCO_LEGR_CD_CMB SLCC" ).append("\n"); 
		query.append("WHERE   H.INV_SEQ = D.INV_SEQ" ).append("\n"); 
		query.append("AND     D.DTRB_CD_CMB_SEQ = SLCC.CD_CMB_SEQ(+)" ).append("\n"); 
		query.append("AND     H.INV_SEQ = TO_NUMBER ( @[inv_seq] )" ).append("\n"); 
		query.append("ORDER BY H.INV_SEQ, D.DTRB_LINE_NO" ).append("\n"); 

	}
}