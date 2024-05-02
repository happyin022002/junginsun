/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AccountPayableInvoiceDBDAOSearchInvoiceAccrualListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.19
*@LastModifier : 
*@LastVersion : 1.0
* 2016.08.19 
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

public class AccountPayableInvoiceDBDAOSearchInvoiceAccrualListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchInvoiceAccrualList
	  * </pre>
	  */
	public AccountPayableInvoiceDBDAOSearchInvoiceAccrualListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("accrual_if_flag",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_date_from",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_date_to",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.integration").append("\n"); 
		query.append("FileName : AccountPayableInvoiceDBDAOSearchInvoiceAccrualListRSQL").append("\n"); 
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
		query.append("SELECT  SIH.INV_NO                    AS INV_NO" ).append("\n"); 
		query.append("      , SIH.INV_SEQ                   AS INV_SEQ" ).append("\n"); 
		query.append("      , SIH.VNDR_NO                   AS VNDR_NO" ).append("\n"); 
		query.append("      , MV.VNDR_LGL_ENG_NM            AS VNDR_NM" ).append("\n"); 
		query.append("      , SIH.INV_CURR_CD               AS CURR_CD" ).append("\n"); 
		query.append("      , TRIM(OPUSADM.SAP_GET_CUR_AMT_FNC(SIH.INV_CURR_CD, SIH.INV_AMT)) AS INV_AMT" ).append("\n"); 
		query.append("      , SIH.INV_DT                    AS INV_DT" ).append("\n"); 
		query.append("      , SIH.INV_TP_LU_CD              AS INV_TP_LU_CD" ).append("\n"); 
		query.append("      , SLCC.SGM_CTNT4                AS ACCRUAL_ACCT_CD" ).append("\n"); 
		query.append("      , NVL(SIH.INV_XCH_RT, 1)        AS INV_XCH_RT" ).append("\n"); 
		query.append("      , SIH.OFC_CD                    AS OFC_CD" ).append("\n"); 
		query.append("      , SID.ACCTG_DT                  AS GL_DT" ).append("\n"); 
		query.append("      , SID.DTRB_LINE_NO              AS LINE_NO" ).append("\n"); 
		query.append("      , SID.LINE_TP_LU_CD             AS LINE_TP_LU_CD" ).append("\n"); 
		query.append("      , TRIM(OPUSADM.SAP_GET_CUR_AMT_FNC(SIH.INV_CURR_CD, SID.DTRB_AMT)) AS DTRB_AMT" ).append("\n"); 
		query.append("      , TRIM(OPUSADM.SAP_GET_CUR_AMT_FNC(SIH.INV_CURR_CD, SID.DTRB_FUNC_AMT)) AS DTRB_FUNC_AMT" ).append("\n"); 
		query.append("      , SLCC2.SGM_CTNT1||'.'||SLCC2.SGM_CTNT2||'.'||SLCC2.SGM_CTNT3||'.'||SLCC2.SGM_CTNT4||'.'||SLCC2.SGM_CTNT5||'.'||SLCC2.SGM_CTNT6  AS DTRB_COA" ).append("\n"); 
		query.append("      , SID.ATTR_CTNT1                AS VNDR_INV_NO" ).append("\n"); 
		query.append("      , SID.ATTR_CTNT2                AS VNDR_INV_DATE" ).append("\n"); 
		query.append("      , SID.ATTR_CTNT3                AS LOCATION_CD" ).append("\n"); 
		query.append("      , SID.ATTR_CTNT11               AS ACTIVITY_DATE" ).append("\n"); 
		query.append("      , SID.ATTR_CTNT12               AS ACTIVITY_PLACE" ).append("\n"); 
		query.append("      , SID.ATTR_CTNT14               AS SERVICE_LANE" ).append("\n"); 
		query.append("      , SID.DTRB_DESC                 AS DTRB_DESC" ).append("\n"); 
		query.append("      , NVL(SIH.GLO_ATTR_CTNT20, 'N') AS INTERFACE_FLAG" ).append("\n"); 
		query.append("      , NVL((SELECT  NVL(IF_FLG, 'N') " ).append("\n"); 
		query.append("             FROM    GL_ESTM_IF_ERP GEIE " ).append("\n"); 
		query.append("             WHERE   GEIE.SYS_SRC_ID = 'SAP' AND GEIE.EXE_YRMON = TO_CHAR(SID.ACCTG_DT, 'YYYYMM') AND GEIE.WO_NO = SIH.INV_NO AND ROWNUM = 1), 'N')" ).append("\n"); 
		query.append("                                      AS ACCRUAL_IF_FLAG" ).append("\n"); 
		query.append("FROM    SAP_INV_HDR SIH" ).append("\n"); 
		query.append("      , SAP_INV_DTL SID" ).append("\n"); 
		query.append("      , SCO_LEGR_CD_CMB SLCC" ).append("\n"); 
		query.append("      , SCO_LEGR_CD_CMB SLCC2" ).append("\n"); 
		query.append("      , MDM_VENDOR MV" ).append("\n"); 
		query.append("WHERE   SIH.INV_SEQ = SID.INV_SEQ" ).append("\n"); 
		query.append("AND     TO_NUMBER(SIH.VNDR_NO) = MV.VNDR_SEQ " ).append("\n"); 
		query.append("AND     SIH.LIAB_CD_CMB_SEQ = SLCC.CD_CMB_SEQ" ).append("\n"); 
		query.append("AND     SID.DTRB_CD_CMB_SEQ = SLCC2.CD_CMB_SEQ" ).append("\n"); 
		query.append("AND     EXISTS (SELECT  'Y' " ).append("\n"); 
		query.append("                FROM    SCO_LU_HDR SLH, SCO_LU_DTL SLD " ).append("\n"); 
		query.append("                WHERE   SLH.LU_TP_CD = SLD.LU_TP_CD " ).append("\n"); 
		query.append("                AND     SLH.LU_TP_CD = 'AP ACCRUAL ACCOUNT' " ).append("\n"); 
		query.append("                AND     NVL(SLD.ENBL_FLG, 'Y') = 'Y'" ).append("\n"); 
		query.append("                AND     NVL(SLD.LU_ST_DT, SYSDATE) >= SYSDATE " ).append("\n"); 
		query.append("                AND     SLH.LU_APPL_CD = 'SAP'" ).append("\n"); 
		query.append("                AND     SLCC.SGM_CTNT4 = SLD.LU_CD)" ).append("\n"); 
		query.append("AND    SIH.ATTR_CTNT12 IS NOT NULL " ).append("\n"); 
		query.append("AND    SIH.ATTR_CTNT15 = 'Y'" ).append("\n"); 
		query.append("AND    SIH.INV_CXL_DT IS NULL" ).append("\n"); 
		query.append("AND    SIH.INV_DT >= TO_DATE(@[inv_date_from], 'YYYY-MM-DD')   " ).append("\n"); 
		query.append("AND    SIH.INV_DT < TO_DATE(@[inv_date_to], 'YYYY-MM-DD') + 1" ).append("\n"); 
		query.append("AND    (SIH.OFC_CD = @[ofc_cd] OR SIH.OFC_CD IN (SELECT MO.AP_OFC_CD FROM MDM_ORGANIZATION MO WHERE MO.AP_CTRL_OFC_CD = @[ofc_cd] AND MO.AP_OFC_CD IS NOT NULL ) )" ).append("\n"); 
		query.append("#if (${vndr_no} != '')" ).append("\n"); 
		query.append("       AND   SIH.VNDR_NO = @[vndr_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${inv_no} != '')" ).append("\n"); 
		query.append("       AND  SIH.INV_NO = @[inv_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND    NVL(SIH.GLO_ATTR_CTNT20, 'N') = @[accrual_if_flag]" ).append("\n"); 
		query.append("ORDER  BY SIH.INV_NO, SID.DTRB_LINE_NO" ).append("\n"); 

	}
}