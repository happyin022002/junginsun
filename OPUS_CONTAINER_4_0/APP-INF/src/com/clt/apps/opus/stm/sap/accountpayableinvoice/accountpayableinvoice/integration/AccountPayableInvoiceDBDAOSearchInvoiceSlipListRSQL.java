/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AccountPayableInvoiceDBDAOSearchInvoiceSlipListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.03
*@LastModifier : 
*@LastVersion : 1.0
* 2016.02.03 
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

public class AccountPayableInvoiceDBDAOSearchInvoiceSlipListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * STP_SAP_0030 Invoice Slip Inquiry - Invoice Header Retrieve
	  * </pre>
	  */
	public AccountPayableInvoiceDBDAOSearchInvoiceSlipListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vendor_inv_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gl_dt_fr",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("inv_dt_to",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gl_dt_to",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ap_pay_grp_lu_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("inv_dt_fr",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ap_inv_src_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.integration").append("\n"); 
		query.append("FileName : AccountPayableInvoiceDBDAOSearchInvoiceSlipListRSQL").append("\n"); 
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
		query.append("SELECT  SIH.INV_NO                 AS INV_NO" ).append("\n"); 
		query.append("      , MV.VNDR_LGL_ENG_NM         AS VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("      , SIH.INV_DT                 AS INV_DT" ).append("\n"); 
		query.append("      , SIH.INV_CURR_CD            AS INV_CURR_CD" ).append("\n"); 
		query.append("      , OPUSADM.SAP_GET_CUR_AMT_FNC(SIH.INV_CURR_CD, SIH.INV_AMT) AS INV_AMT" ).append("\n"); 
		query.append("      , CU.USR_NM                  AS USR_NM" ).append("\n"); 
		query.append("      , SIH.INV_TP_LU_CD           AS INV_TP_LU_CD" ).append("\n"); 
		query.append("      , (CASE WHEN SIH.ATTR_CTNT15 IS NULL AND SIH.INV_CXL_DT IS NULL THEN 'Unapproved'" ).append("\n"); 
		query.append("              WHEN SIH.ATTR_CTNT15 = 'Y' AND SIH.INV_CXL_DT IS NULL THEN 'Approved'" ).append("\n"); 
		query.append("              WHEN SIH.ATTR_CTNT15 = 'N' AND SIH.INV_CXL_DT IS NOT NULL THEN 'Cancelled' END) AS APPROVAL" ).append("\n"); 
		query.append("      , SIH.INV_DESC               AS INV_DESC" ).append("\n"); 
		query.append("      , SIH.ATTR_CTNT13            AS RECEIPT_NO" ).append("\n"); 
		query.append("      , CU2.USR_NM                 AS REJECTED_BY" ).append("\n"); 
		query.append("      , SIH.INV_SEQ                AS INV_SEQ" ).append("\n"); 
		query.append("      , SIH.OFC_CD                 AS OFC_CD" ).append("\n"); 
		query.append("      , SIH.GL_DT                  AS GL_DT" ).append("\n"); 
		query.append("      , DECODE(SIH.ATTR_CTNT12, NULL, 'N', 'Y') AS SUBMIT_FLAG" ).append("\n"); 
		query.append("      , SIH.AP_INV_SRC_CD          AS AP_INV_SRC_CD" ).append("\n"); 
		query.append("      , 'G5'|| ML.CNT_CD || LPAD(TO_CHAR(MV.VNDR_SEQ),6, '0') AS VNDR_CD" ).append("\n"); 
		query.append("      , (SELECT  SPH.PAY_DT" ).append("\n"); 
		query.append("         FROM    SAP_PAY_HDR SPH, SAP_PAY_DTL SPD" ).append("\n"); 
		query.append("         WHERE   SPH.PAY_SEQ = SPD.PAY_SEQ AND SPD.INV_SEQ = SIH.INV_SEQ AND ROWNUM = 1) AS PAY_DT" ).append("\n"); 
		query.append("FROM    SAP_INV_HDR SIH" ).append("\n"); 
		query.append("      , MDM_VENDOR MV" ).append("\n"); 
		query.append("      , COM_USER CU" ).append("\n"); 
		query.append("      , COM_USER CU2" ).append("\n"); 
		query.append("      , MDM_ORGANIZATION MO" ).append("\n"); 
		query.append("      , MDM_LOCATION ML" ).append("\n"); 
		query.append("WHERE   TO_NUMBER(SIH.VNDR_NO) = MV.VNDR_SEQ" ).append("\n"); 
		query.append("AND     SIH.CRE_USR_ID = CU.USR_ID " ).append("\n"); 
		query.append("AND     SIH.CXL_USR_ID = CU2.USR_ID(+)" ).append("\n"); 
		query.append("AND     MV.OFC_CD = MO.OFC_CD(+)" ).append("\n"); 
		query.append("AND     MO.LOC_CD = ML.LOC_CD(+)" ).append("\n"); 
		query.append("AND     SIH.INV_DT >= TO_DATE(@[inv_dt_fr],'YYYY-MM-DD')" ).append("\n"); 
		query.append("AND     SIH.INV_DT <  TO_DATE(@[inv_dt_to],'YYYY-MM-DD')  + 1" ).append("\n"); 
		query.append("#if (${ofc_cd} != '')" ).append("\n"); 
		query.append("   AND  SIH.OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("   AND  SAP_OFC_SECURITY_FNC(SAP_GET_AP_OFFICE_FNC('', @[usr_id]), SIH.OFC_CD, 'INCLUDE_ALL', '') = 'Y'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ap_inv_src_cd} != '')" ).append("\n"); 
		query.append("   AND  SIH.AP_INV_SRC_CD = @[ap_inv_src_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${inv_no} != '')" ).append("\n"); 
		query.append("   AND  SIH.INV_NO = @[inv_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${gl_dt_fr} != '')" ).append("\n"); 
		query.append("   AND  SIH.GL_DT >= REPLACE(@[gl_dt_fr],'-' ,'')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${gl_dt_to} != '')" ).append("\n"); 
		query.append("   AND  SIH.GL_DT <= REPLACE(@[gl_dt_to],'-' ,'')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vendor_inv_no} != '')" ).append("\n"); 
		query.append("   AND  SIH.INV_SEQ IN (SELECT SID.INV_SEQ FROM SAP_INV_DTL SID WHERE SID.ATTR_CTNT1 = @[vendor_inv_no] )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ap_pay_grp_lu_cd} != '')" ).append("\n"); 
		query.append("   AND  SIH.AP_PAY_GRP_LU_CD = @[ap_pay_grp_lu_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vndr_no} != '')" ).append("\n"); 
		query.append("   AND  SIH.VNDR_NO = @[vndr_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${inv_curr_cd} != '')" ).append("\n"); 
		query.append("   AND  SIH.INV_CURR_CD = @[inv_curr_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${approval} == 'U')--Unapproved" ).append("\n"); 
		query.append("   AND  SIH.ATTR_CTNT15 IS NULL " ).append("\n"); 
		query.append("   AND  SIH.INV_CXL_DT IS NULL" ).append("\n"); 
		query.append("#elseif (${approval} == 'A')--Approved" ).append("\n"); 
		query.append("   AND  SIH.ATTR_CTNT15 = 'Y' " ).append("\n"); 
		query.append("   AND  SIH.INV_CXL_DT IS NULL" ).append("\n"); 
		query.append("#elseif (${approval} == 'C')--Cancelled" ).append("\n"); 
		query.append("   AND  SIH.ATTR_CTNT15 = 'N'" ).append("\n"); 
		query.append("   AND  SIH.INV_CXL_DT IS NOT NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY SIH.INV_NO" ).append("\n"); 

	}
}