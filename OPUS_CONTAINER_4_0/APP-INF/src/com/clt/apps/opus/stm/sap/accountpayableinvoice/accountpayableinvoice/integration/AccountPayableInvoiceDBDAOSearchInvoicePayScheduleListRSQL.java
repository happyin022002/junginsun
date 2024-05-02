/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountPayableInvoiceDBDAOSearchInvoicePayScheduleListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.01
*@LastModifier : 
*@LastVersion : 1.0
* 2014.10.01 
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

public class AccountPayableInvoiceDBDAOSearchInvoicePayScheduleListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 전표 No을 조건으로 지불 예정 내역을 조회
	  * </pre>
	  */
	public AccountPayableInvoiceDBDAOSearchInvoicePayScheduleListRSQL(){
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
		query.append("FileName : AccountPayableInvoiceDBDAOSearchInvoicePayScheduleListRSQL").append("\n"); 
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
		query.append("   SPS.INV_SEQ" ).append("\n"); 
		query.append(" , SPS.PAY_SKD_NO" ).append("\n"); 
		query.append(" , TRIM(SAP_GET_CUR_AMT_FNC(SIH.INV_CURR_CD, SPS.PAY_RMN_AMT)) PAY_RMN_AMT" ).append("\n"); 
		query.append(" , TO_CHAR(SPS.DUE_DT, 'YYYY-MM-DD') AS DUE_DT" ).append("\n"); 
		query.append(" , TRIM(SAP_GET_CUR_AMT_FNC(SIH.INV_CURR_CD, SPS.PAY_GRS_AMT)) PAY_GRS_AMT" ).append("\n"); 
		query.append(" , DECODE( SPS.INV_HLD_FLG, 'N', '0', 'Y', '1', '0' ) AS INV_HLD_FLG" ).append("\n"); 
		query.append(" , SPS.PAY_MZD_LU_CD" ).append("\n"); 
		query.append(" , SPS.PAY_PRIO_CD" ).append("\n"); 
		query.append(" , SPS.PAY_STS_FLG" ).append("\n"); 
		query.append(" , SPS.INV_BAT_SEQ" ).append("\n"); 
		query.append(" , SPS.ATTR_CTNT1" ).append("\n"); 
		query.append(" , SPS.ATTR_CTNT2" ).append("\n"); 
		query.append(" , SPS.ATTR_CTNT3" ).append("\n"); 
		query.append(" , SPS.ATTR_CTNT4" ).append("\n"); 
		query.append(" , SPS.ATTR_CTNT5" ).append("\n"); 
		query.append(" , SPS.ATTR_CTNT6" ).append("\n"); 
		query.append(" , SPS.ATTR_CTNT7" ).append("\n"); 
		query.append(" , SPS.ATTR_CTNT8" ).append("\n"); 
		query.append(" , SPS.ATTR_CTNT9" ).append("\n"); 
		query.append(" , SPS.ATTR_CTNT10" ).append("\n"); 
		query.append(" , SPS.ATTR_CTNT11" ).append("\n"); 
		query.append(" , SPS.ATTR_CTNT12" ).append("\n"); 
		query.append(" , SPS.ATTR_CTNT13" ).append("\n"); 
		query.append(" , SPS.ATTR_CTNT14" ).append("\n"); 
		query.append(" , SPS.ATTR_CTNT15" ).append("\n"); 
		query.append(" , SPS.ATTR_CATE_NM" ).append("\n"); 
		query.append(" , SPS.XTER_BANK_ACCT_SEQ" ).append("\n"); 
		query.append(" , SPS.PAY_BAT_RUN_SEQ" ).append("\n"); 
		query.append(" , SPS.REMIT_VNDR_NO" ).append("\n"); 
		query.append(" , SPS.CRE_USR_ID" ).append("\n"); 
		query.append(" , SPS.CRE_DT" ).append("\n"); 
		query.append(" , SPS.UPD_USR_ID" ).append("\n"); 
		query.append(" , SPS.UPD_DT" ).append("\n"); 
		query.append(" , '' USR_ID" ).append("\n"); 
		query.append(" , MV.VNDR_LGL_ENG_NM           AS VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append(" , SBA.BANK_ACCT_NO             AS BANK_ACCT_NO" ).append("\n"); 
		query.append(" , SIH.INV_CURR_CD              AS INV_CURR_CD" ).append("\n"); 
		query.append(" , DECODE( SPS.INV_HLD_FLG, 'N', '0', 'Y', '1', '0' ) AS ORG_INV_HLD_FLG" ).append("\n"); 
		query.append("FROM    SAP_PAY_SKD SPS" ).append("\n"); 
		query.append("      , SAP_INV_HDR SIH" ).append("\n"); 
		query.append("      , SAP_BANK_ACCT SBA" ).append("\n"); 
		query.append("      , MDM_VENDOR MV" ).append("\n"); 
		query.append("WHERE   SPS.INV_SEQ = SIH.INV_SEQ " ).append("\n"); 
		query.append("AND     SPS.XTER_BANK_ACCT_SEQ = SBA.BANK_ACCT_SEQ(+)" ).append("\n"); 
		query.append("AND     TO_NUMBER(SPS.REMIT_VNDR_NO) = MV.VNDR_SEQ(+)" ).append("\n"); 
		query.append("AND     SPS.INV_SEQ = @[inv_seq]" ).append("\n"); 
		query.append("ORDER BY 1,2" ).append("\n"); 

	}
}