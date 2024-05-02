/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AccountPayableInvoiceDBDAOAddInvoiceLineSelectInfoCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.07
*@LastModifier : 
*@LastVersion : 1.0
* 2015.05.07 
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

public class AccountPayableInvoiceDBDAOAddInvoiceLineSelectInfoCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AddInvoiceLineSelectInfo
	  * </pre>
	  */
	public AccountPayableInvoiceDBDAOAddInvoiceLineSelectInfoCSQL(){
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
		params.put("gl_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.integration").append("\n"); 
		query.append("FileName : AccountPayableInvoiceDBDAOAddInvoiceLineSelectInfoCSQL").append("\n"); 
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
		query.append("(" ).append("\n"); 
		query.append("   ACCTG_DT" ).append("\n"); 
		query.append(" , ACCL_BK_PST_FLG" ).append("\n"); 
		query.append(" , ASET_ADD_FLG" ).append("\n"); 
		query.append(" , ASET_TRAK_FLG" ).append("\n"); 
		query.append(" , CSH_BK_PST_FLG" ).append("\n"); 
		query.append(" , DTRB_LINE_NO" ).append("\n"); 
		query.append(" , DTRB_COA_CO_CD" ).append("\n"); 
		query.append(" , DTRB_COA_RGN_CD" ).append("\n"); 
		query.append(" , DTRB_COA_CTR_CD" ).append("\n"); 
		query.append(" , DTRB_COA_ACCT_NO" ).append("\n"); 
		query.append(" , DTRB_COA_VVD_CD" ).append("\n"); 
		query.append(" , DTRB_COA_INTER_CO_CD" ).append("\n"); 
		query.append(" , INV_SEQ" ).append("\n"); 
		query.append(" , LINE_TP_LU_CD" ).append("\n"); 
		query.append(" , EFF_YRMON" ).append("\n"); 
		query.append(" , DTRB_AMT" ).append("\n"); 
		query.append(" , DTRB_FUNC_AMT" ).append("\n"); 
		query.append(" , BAT_SEQ" ).append("\n"); 
		query.append(" , DTRB_DESC" ).append("\n"); 
		query.append(" , MTCH_STS_FLG" ).append("\n"); 
		query.append(" , ACCTG_PST_FLG" ).append("\n"); 
		query.append(" , RVS_FLG" ).append("\n"); 
		query.append(" , DTRB_XCH_DT" ).append("\n"); 
		query.append(" , DTRB_XCH_RT" ).append("\n"); 
		query.append(" , DTRB_XCH_RT_TP_CD" ).append("\n"); 
		query.append(" , ATTR_CTNT1" ).append("\n"); 
		query.append(" , ATTR_CTNT2" ).append("\n"); 
		query.append(" , ATTR_CTNT3" ).append("\n"); 
		query.append(" , ATTR_CTNT4" ).append("\n"); 
		query.append(" , ATTR_CTNT5" ).append("\n"); 
		query.append(" , ATTR_CTNT6" ).append("\n"); 
		query.append(" , ATTR_CTNT7" ).append("\n"); 
		query.append(" , ATTR_CTNT8" ).append("\n"); 
		query.append(" , ATTR_CTNT9" ).append("\n"); 
		query.append(" , ATTR_CTNT10" ).append("\n"); 
		query.append(" , ATTR_CTNT11" ).append("\n"); 
		query.append(" , ATTR_CTNT12" ).append("\n"); 
		query.append(" , ATTR_CTNT13" ).append("\n"); 
		query.append(" , ATTR_CTNT14" ).append("\n"); 
		query.append(" , ATTR_CTNT15" ).append("\n"); 
		query.append(" , ATTR_CATE_NM" ).append("\n"); 
		query.append(" , PPAY_RMN_AMT" ).append("\n"); 
		query.append(" , GLO_ATTR_CATE_NM" ).append("\n"); 
		query.append(" , GLO_ATTR_CTNT1" ).append("\n"); 
		query.append(" , GLO_ATTR_CTNT2" ).append("\n"); 
		query.append(" , GLO_ATTR_CTNT3" ).append("\n"); 
		query.append(" , GLO_ATTR_CTNT4" ).append("\n"); 
		query.append(" , GLO_ATTR_CTNT5" ).append("\n"); 
		query.append(" , GLO_ATTR_CTNT6" ).append("\n"); 
		query.append(" , GLO_ATTR_CTNT7" ).append("\n"); 
		query.append(" , GLO_ATTR_CTNT8" ).append("\n"); 
		query.append(" , GLO_ATTR_CTNT9" ).append("\n"); 
		query.append(" , GLO_ATTR_CTNT10" ).append("\n"); 
		query.append(" , GLO_ATTR_CTNT11" ).append("\n"); 
		query.append(" , GLO_ATTR_CTNT12" ).append("\n"); 
		query.append(" , GLO_ATTR_CTNT13" ).append("\n"); 
		query.append(" , GLO_ATTR_CTNT14" ).append("\n"); 
		query.append(" , GLO_ATTR_CTNT15" ).append("\n"); 
		query.append(" , GLO_ATTR_CTNT16" ).append("\n"); 
		query.append(" , GLO_ATTR_CTNT17" ).append("\n"); 
		query.append(" , GLO_ATTR_CTNT18" ).append("\n"); 
		query.append(" , GLO_ATTR_CTNT19" ).append("\n"); 
		query.append(" , GLO_ATTR_CTNT20" ).append("\n"); 
		query.append(" , DTRB_MTCH_TP_NM" ).append("\n"); 
		query.append(" , INV_DTRB_SEQ" ).append("\n"); 
		query.append(" , PRNT_RVS_DTRB_SEQ" ).append("\n"); 
		query.append(" , ACCTG_EVNT_SEQ" ).append("\n"); 
		query.append(" , PPAY_DTRB_SEQ" ).append("\n"); 
		query.append(" , DTRB_CLSS_NM" ).append("\n"); 
		query.append(" , DTRB_VAT_CD" ).append("\n"); 
		query.append(" , OLD_DTRB_SEQ" ).append("\n"); 
		query.append(" , INV_RND_AMT" ).append("\n"); 
		query.append(" , CRE_USR_ID" ).append("\n"); 
		query.append(" , CRE_DT" ).append("\n"); 
		query.append(" , UPD_USR_ID" ).append("\n"); 
		query.append(" , UPD_DT" ).append("\n"); 
		query.append(" , DTRB_CD_CMB_SEQ" ).append("\n"); 
		query.append(" , DTRB_FUNC_GAIN_AMT" ).append("\n"); 
		query.append(" , DTRB_FUNC_LSS_AMT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT TO_DATE( @[gl_dt],'YYYYMMDD')" ).append("\n"); 
		query.append("     , SID.ACCL_BK_PST_FLG" ).append("\n"); 
		query.append("     , SID.ASET_ADD_FLG" ).append("\n"); 
		query.append("     , SID.ASET_TRAK_FLG" ).append("\n"); 
		query.append("     , SID.CSH_BK_PST_FLG" ).append("\n"); 
		query.append("     , SID.DTRB_LINE_NO + (SELECT MAX(SID1.DTRB_LINE_NO) FROM SAP_INV_DTL SID1 WHERE SID1.INV_SEQ = @[inv_seq])" ).append("\n"); 
		query.append("     , SID.DTRB_COA_CO_CD" ).append("\n"); 
		query.append("     , SID.DTRB_COA_RGN_CD" ).append("\n"); 
		query.append("     , SID.DTRB_COA_CTR_CD" ).append("\n"); 
		query.append("     , SID.DTRB_COA_ACCT_NO" ).append("\n"); 
		query.append("     , SID.DTRB_COA_VVD_CD" ).append("\n"); 
		query.append("     , SID.DTRB_COA_INTER_CO_CD" ).append("\n"); 
		query.append("     , SID.INV_SEQ" ).append("\n"); 
		query.append("     , SID.LINE_TP_LU_CD" ).append("\n"); 
		query.append("     , SID.EFF_YRMON" ).append("\n"); 
		query.append("     , SID.DTRB_AMT * -1" ).append("\n"); 
		query.append("     , SID.DTRB_FUNC_AMT * -1" ).append("\n"); 
		query.append("     , SID.BAT_SEQ" ).append("\n"); 
		query.append("     , SID.DTRB_DESC" ).append("\n"); 
		query.append("     , SID.MTCH_STS_FLG" ).append("\n"); 
		query.append("     , 'N' AS ACCTG_PST_FLG" ).append("\n"); 
		query.append("     , 'Y' RVS_FLG" ).append("\n"); 
		query.append("     , SID.DTRB_XCH_DT" ).append("\n"); 
		query.append("     , SID.DTRB_XCH_RT" ).append("\n"); 
		query.append("     , SID.DTRB_XCH_RT_TP_CD" ).append("\n"); 
		query.append("     , SID.ATTR_CTNT1" ).append("\n"); 
		query.append("     , SID.ATTR_CTNT2" ).append("\n"); 
		query.append("     , SID.ATTR_CTNT3" ).append("\n"); 
		query.append("     , DECODE(SID.ATTR_CTNT4, 'Y', 'N', SID.ATTR_CTNT4) AS ATTR_CTNT4" ).append("\n"); 
		query.append("     , SID.ATTR_CTNT5" ).append("\n"); 
		query.append("     , SID.ATTR_CTNT6" ).append("\n"); 
		query.append("     , SID.ATTR_CTNT7" ).append("\n"); 
		query.append("     , SID.ATTR_CTNT8" ).append("\n"); 
		query.append("     , SID.ATTR_CTNT9" ).append("\n"); 
		query.append("     , SID.ATTR_CTNT10" ).append("\n"); 
		query.append("     , SID.ATTR_CTNT11" ).append("\n"); 
		query.append("     , SID.ATTR_CTNT12" ).append("\n"); 
		query.append("     , '' AS ATTR_CTNT13" ).append("\n"); 
		query.append("     , DECODE(SID.ATTR_CTNT14, 'Y', 'N', SID.ATTR_CTNT14) AS ATTR_CTNT14" ).append("\n"); 
		query.append("     , SID.ATTR_CTNT15" ).append("\n"); 
		query.append("     , SID.ATTR_CATE_NM" ).append("\n"); 
		query.append("     , SID.PPAY_RMN_AMT" ).append("\n"); 
		query.append("     , SID.GLO_ATTR_CATE_NM" ).append("\n"); 
		query.append("     , TO_NUMBER(SID.GLO_ATTR_CTNT1) + (SELECT MAX(SID1.DTRB_LINE_NO) FROM SAP_INV_DTL SID1 WHERE SID1.INV_SEQ = @[inv_seq])" ).append("\n"); 
		query.append("     , SID.GLO_ATTR_CTNT2" ).append("\n"); 
		query.append("     , SID.GLO_ATTR_CTNT3" ).append("\n"); 
		query.append("     , SID.GLO_ATTR_CTNT4" ).append("\n"); 
		query.append("     , SID.GLO_ATTR_CTNT5" ).append("\n"); 
		query.append("     , SID.GLO_ATTR_CTNT6" ).append("\n"); 
		query.append("     , SID.GLO_ATTR_CTNT7" ).append("\n"); 
		query.append("     , SID.GLO_ATTR_CTNT8" ).append("\n"); 
		query.append("     , SID.GLO_ATTR_CTNT9" ).append("\n"); 
		query.append("     , SID.GLO_ATTR_CTNT10" ).append("\n"); 
		query.append("     , SID.GLO_ATTR_CTNT11" ).append("\n"); 
		query.append("     , SID.GLO_ATTR_CTNT12" ).append("\n"); 
		query.append("     , SID.GLO_ATTR_CTNT13" ).append("\n"); 
		query.append("     , SID.GLO_ATTR_CTNT14" ).append("\n"); 
		query.append("     , SID.GLO_ATTR_CTNT15" ).append("\n"); 
		query.append("     , SID.GLO_ATTR_CTNT16" ).append("\n"); 
		query.append("     , SID.GLO_ATTR_CTNT17" ).append("\n"); 
		query.append("     , SID.GLO_ATTR_CTNT18" ).append("\n"); 
		query.append("     , SID.GLO_ATTR_CTNT19" ).append("\n"); 
		query.append("     , SID.GLO_ATTR_CTNT20" ).append("\n"); 
		query.append("     , SID.DTRB_MTCH_TP_NM" ).append("\n"); 
		query.append("     , SAP_INV_DTL_SEQ.NEXTVAL  AS INV_DTRB_SEQ" ).append("\n"); 
		query.append("     , SID.INV_DTRB_SEQ AS PRNT_RVS_DTRB_SEQ" ).append("\n"); 
		query.append("     , NULL AS ACCTG_EVNT_SEQ" ).append("\n"); 
		query.append("     , NULL PPAY_DTRB_SEQ" ).append("\n"); 
		query.append("     , SID.DTRB_CLSS_NM" ).append("\n"); 
		query.append("     , SID.DTRB_VAT_CD" ).append("\n"); 
		query.append("     , SID.OLD_DTRB_SEQ" ).append("\n"); 
		query.append("     , SID.INV_RND_AMT * -1  AS INV_RND_AMT" ).append("\n"); 
		query.append("     , @[usr_id] AS CRE_USR_ID" ).append("\n"); 
		query.append("     , SYSDATE AS CRE_DT" ).append("\n"); 
		query.append("     , @[usr_id] AS UPD_USR_ID" ).append("\n"); 
		query.append("     , SYSDATE AS UPD_DT" ).append("\n"); 
		query.append("     , SID.DTRB_CD_CMB_SEQ" ).append("\n"); 
		query.append("     , SID.DTRB_FUNC_LSS_AMT" ).append("\n"); 
		query.append("     , SID.DTRB_FUNC_GAIN_AMT" ).append("\n"); 
		query.append("FROM   SAP_INV_DTL SID" ).append("\n"); 
		query.append("WHERE  SID.INV_SEQ = @[inv_seq]" ).append("\n"); 

	}
}