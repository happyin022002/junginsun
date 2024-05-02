/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountPayableInvoiceDBDAOSearchSapInvoiceInterfaceHeaderRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.20
*@LastModifier : 
*@LastVersion : 1.0
* 2014.10.20 
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

public class AccountPayableInvoiceDBDAOSearchSapInvoiceInterfaceHeaderRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AccountPayableInvoiceDBDAOSearchSapInvoiceInterfaceHeaderRSQL
	  * </pre>
	  */
	public AccountPayableInvoiceDBDAOSearchSapInvoiceInterfaceHeaderRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("csr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.integration").append("\n"); 
		query.append("FileName : AccountPayableInvoiceDBDAOSearchSapInvoiceInterfaceHeaderRSQL").append("\n"); 
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
		query.append("SELECT  SIHI.INV_IF_SEQ           AS INV_IF_SEQ" ).append("\n"); 
		query.append("         , SIHI.INV_NO               AS INV_NO" ).append("\n"); 
		query.append("         , SIHI.INV_TP_LU_CD         AS INV_TP_LU_CD" ).append("\n"); 
		query.append("         , TO_CHAR(SIHI.INV_DT, 'YYYYMMDD')               AS INV_DT" ).append("\n"); 
		query.append("         , SIHI.VNDR_NO              AS VNDR_NO" ).append("\n"); 
		query.append("         , SIHI.INV_AMT              AS INV_AMT" ).append("\n"); 
		query.append("         , SIHI.INV_CURR_CD          AS INV_CURR_CD" ).append("\n"); 
		query.append("         , SIHI.INV_XCH_RT           AS INV_XCH_RT" ).append("\n"); 
		query.append("         , SIHI.INV_XCH_RT_TP_CD     AS INV_XCH_RT_TP_CD" ).append("\n"); 
		query.append("         , TO_CHAR(SIHI.INV_XCH_DT, 'YYYYMMDD')           AS INV_XCH_DT" ).append("\n"); 
		query.append("         , SIHI.INV_TERM_NM          AS INV_TERM_NM" ).append("\n"); 
		query.append("         , SIHI.INV_DESC             AS INV_DESC" ).append("\n"); 
		query.append("         , SIHI.ATTR_CATE_NM         AS ATTR_CATE_NM" ).append("\n"); 
		query.append("         , SIHI.ATTR_CTNT1           AS ATTR_CTNT1" ).append("\n"); 
		query.append("         , SIHI.ATTR_CTNT2           AS ATTR_CTNT2" ).append("\n"); 
		query.append("         , SIHI.ATTR_CTNT3           AS ATTR_CTNT3" ).append("\n"); 
		query.append("         , SIHI.ATTR_CTNT4           AS ATTR_CTNT4" ).append("\n"); 
		query.append("         , SIHI.ATTR_CTNT5           AS ATTR_CTNT5" ).append("\n"); 
		query.append("         , SIHI.ATTR_CTNT6           AS ATTR_CTNT6" ).append("\n"); 
		query.append("         , SIHI.ATTR_CTNT7           AS ATTR_CTNT7" ).append("\n"); 
		query.append("         , SIHI.ATTR_CTNT8           AS ATTR_CTNT8" ).append("\n"); 
		query.append("         , SIHI.ATTR_CTNT9           AS ATTR_CTNT9" ).append("\n"); 
		query.append("         , SIHI.ATTR_CTNT10          AS ATTR_CTNT10" ).append("\n"); 
		query.append("         , SIHI.ATTR_CTNT11          AS ATTR_CTNT11" ).append("\n"); 
		query.append("         , SIHI.ATTR_CTNT12          AS ATTR_CTNT12" ).append("\n"); 
		query.append("         , SIHI.ATTR_CTNT13          AS ATTR_CTNT13" ).append("\n"); 
		query.append("         , SIHI.ATTR_CTNT14          AS ATTR_CTNT14" ).append("\n"); 
		query.append("         , SIHI.ATTR_CTNT15          AS ATTR_CTNT15" ).append("\n"); 
		query.append("         , SIHI.GLO_ATTR_CATE_NM     AS GLO_ATTR_CATE_N" ).append("\n"); 
		query.append("         , SIHI.GLO_ATTR_CTNT1       AS GLO_ATTR_CTNT1" ).append("\n"); 
		query.append("         , SIHI.GLO_ATTR_CTNT2       AS GLO_ATTR_CTNT2" ).append("\n"); 
		query.append("         , SIHI.GLO_ATTR_CTNT3       AS GLO_ATTR_CTNT3" ).append("\n"); 
		query.append("         , SIHI.GLO_ATTR_CTNT4       AS GLO_ATTR_CTNT4" ).append("\n"); 
		query.append("         , SIHI.GLO_ATTR_CTNT5       AS GLO_ATTR_CTNT5" ).append("\n"); 
		query.append("         , SIHI.GLO_ATTR_CTNT6       AS GLO_ATTR_CTNT6" ).append("\n"); 
		query.append("         , SIHI.GLO_ATTR_CTNT7       AS GLO_ATTR_CTNT7" ).append("\n"); 
		query.append("         , SIHI.GLO_ATTR_CTNT8       AS GLO_ATTR_CTNT8" ).append("\n"); 
		query.append("         , SIHI.GLO_ATTR_CTNT9       AS GLO_ATTR_CTNT9" ).append("\n"); 
		query.append("         , SIHI.GLO_ATTR_CTNT10      AS GLO_ATTR_CTNT10" ).append("\n"); 
		query.append("         , SIHI.GLO_ATTR_CTNT11      AS GLO_ATTR_CTNT11" ).append("\n"); 
		query.append("         , SIHI.GLO_ATTR_CTNT12      AS GLO_ATTR_CTNT12" ).append("\n"); 
		query.append("         , SIHI.GLO_ATTR_CTNT13      AS GLO_ATTR_CTNT13" ).append("\n"); 
		query.append("         , SIHI.GLO_ATTR_CTNT14      AS GLO_ATTR_CTNT14" ).append("\n"); 
		query.append("         , SIHI.GLO_ATTR_CTNT15      AS GLO_ATTR_CTNT15" ).append("\n"); 
		query.append("         , SIHI.GLO_ATTR_CTNT16      AS GLO_ATTR_CTNT16" ).append("\n"); 
		query.append("         , SIHI.GLO_ATTR_CTNT17      AS GLO_ATTR_CTNT17" ).append("\n"); 
		query.append("         , SIHI.GLO_ATTR_CTNT18      AS GLO_ATTR_CTNT18" ).append("\n"); 
		query.append("         , SIHI.GLO_ATTR_CTNT19      AS GLO_ATTR_CTNT19" ).append("\n"); 
		query.append("         , SIHI.GLO_ATTR_CTNT20      AS GLO_ATTR_CTNT20" ).append("\n"); 
		query.append("         , SIHI.IF_SRC_NM            AS IF_SRC_NM" ).append("\n"); 
		query.append("         , SIHI.INV_PAY_CURR_CD      AS INV_PAY_CURR_CD" ).append("\n"); 
		query.append("         , SIHI.AP_PAY_MZD_LU_CD     AS AP_PAY_MZD_LU_CD" ).append("\n"); 
		query.append("         , SIHI.PAY_GRP_LU_CD        AS PAY_GRP_LU_CD" ).append("\n"); 
		query.append("         , TO_CHAR(SIHI.INV_RCV_DT, 'YYYYMMDD')           AS INV_RCV_DT" ).append("\n"); 
		query.append("         , SIHI.GL_DT                AS GL_DT" ).append("\n"); 
		query.append("         , SIHI.LIAB_COA_CO_CD       AS LIAB_COA_CO_CD" ).append("\n"); 
		query.append("         , SIHI.LIAB_COA_RGN_CD      AS LIAB_COA_RGN_CD" ).append("\n"); 
		query.append("         , SIHI.LIAB_COA_CTR_CD      AS LIAB_COA_CTR_CD" ).append("\n"); 
		query.append("         , SIHI.LIAB_COA_ACCT_NO     AS LIAB_COA_ACCT_NO" ).append("\n"); 
		query.append("         , SIHI.LIAB_COA_VVD_CD      AS LIAB_COA_VVD_CD" ).append("\n"); 
		query.append("         , SIHI.LIAB_COA_INTER_CO_CD AS LIAB_COA_INTER_CO_CD" ).append("\n"); 
		query.append("         , SIHI.OFC_CD               AS OFC_CD" ).append("\n"); 
		query.append("         , SIHI.PPAY_INV_NO          AS PPAY_INV_NO" ).append("\n"); 
		query.append("         , SIHI.PPAY_INV_LINE_NO     AS PPAY_INV_LINE_NO" ).append("\n"); 
		query.append("         , SIHI.PPAY_APLY_AMT        AS PPAY_APLY_AMT" ).append("\n"); 
		query.append("         , TO_CHAR(SIHI.PPAY_APLY_GL_DT, 'YYYYMMDD')      AS PPAY_APLY_GL_DT" ).append("\n"); 
		query.append("         , SIHI.INV_INCL_PPAY_FLG    AS INV_INCL_PPAY_FLG" ).append("\n"); 
		query.append("         , TO_CHAR(SIHI.INV_TERM_DT, 'YYYYMMDD')          AS INV_TERM_DT" ).append("\n"); 
		query.append("         , SIHI.XTER_BANK_ACCT_SEQ   AS XTER_BANK_ACCT_SEQ" ).append("\n"); 
		query.append("         , SIHI.ORG_INV_NO           AS ORG_INV_NO" ).append("\n"); 
		query.append("         , SIHI.LIAB_CD_CMB_SEQ      AS LIAB_CD_CMB_SEQ" ).append("\n"); 
		query.append("         , SIHI.INV_VAT_AMT          AS INV_VAT_AMT" ).append("\n"); 
		query.append("         , SIHI.INV_VAT_CD           AS INV_VAT_CD" ).append("\n"); 
		query.append("         , ''                        AS APRO_FLG" ).append("\n"); 
		query.append("         , NVL ( ( SELECT SV.PAY_PRIO_CD FROM SAP_VENDOR SV WHERE SV.VNDR_NO = SIHI.VNDR_NO AND ROWNUM=1 ), 99) VNDR_BANK_ACCT_PRIO_CD" ).append("\n"); 
		query.append("         , SIHI.CRE_USR_ID           AS CREATION_USER   -- 2014.10.16 전표 생성자 정보 추가" ).append("\n"); 
		query.append("   FROM    SAP_INV_HDR_IF SIHI" ).append("\n"); 
		query.append("   WHERE   SIHI.INV_NO = @[csr_no]" ).append("\n"); 
		query.append("   AND     SIHI.INV_IF_STS_CD = 'NEW'" ).append("\n"); 

	}
}