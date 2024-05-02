/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : InvoiceInquiryCorrectionDBDAOSearchInvoiceInquirySecondExcelFormRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.25
*@LastModifier : 신동일
*@LastVersion : 1.0
* 2016.07.25 신동일
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.invoicemanage.invoiceinquirycorrection.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author DONG-IL, SHIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceInquiryCorrectionDBDAOSearchInvoiceInquirySecondExcelFormRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * InvoiceInquiryCorrection의 모든 목록을 가져온다
	  * </pre>
	  */
	public InvoiceInquiryCorrectionDBDAOSearchInvoiceInquirySecondExcelFormRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.invoicemanage.invoiceinquirycorrection.integration").append("\n"); 
		query.append("FileName : InvoiceInquiryCorrectionDBDAOSearchInvoiceInquirySecondExcelFormRSQL").append("\n"); 
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
		query.append("SELECT A.IF_SYS_KND_CD                                                         " ).append("\n"); 
		query.append("      ,COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD00914',A.IF_SYS_KND_CD)                            AS IF_SYS_KND_NM           " ).append("\n"); 
		query.append("      ,A.TRSP_INV_AUD_STS_CD                                                   " ).append("\n"); 
		query.append("      ,COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD00824', A.TRSP_INV_AUD_STS_CD)                     AS TRSP_INV_AUD_STS_NM     " ).append("\n"); 
		query.append("      ,DECODE(A.INV_HLD_FLG, 'N', '0', 'Y', '1')    AS INV_HLD_FLG             " ).append("\n"); 
		query.append("      ,A.INV_NO                                                                " ).append("\n"); 
		query.append("      ,LPAD(TO_CHAR(A.INV_VNDR_SEQ), 6, '0')        AS INV_VNDR_SEQ            " ).append("\n"); 
		query.append("      ,B.VNDR_LGL_ENG_NM                            AS INV_VNDR_NM             " ).append("\n"); 
		query.append("      ,C.TRSP_WO_OFC_CTY_CD||C.TRSP_WO_SEQ          AS TRSP_WO_OFC_CTY_CD_SEQ  " ).append("\n"); 
		query.append("      ,LPAD(TO_CHAR(C.VNDR_SEQ), 6, '0')            AS VNDR_SEQ                " ).append("\n"); 
		query.append("      ,D.VNDR_LGL_ENG_NM                            AS VNDR_NM                 " ).append("\n"); 
		query.append("      ,C.TRSP_SO_OFC_CTY_CD||C.TRSP_SO_SEQ          AS TRSP_SO_OFC_CTY_CD_SEQ  " ).append("\n"); 
		query.append("      ,C.BL_NO" ).append("\n"); 
		query.append("      ,C.EQ_NO                                                                 " ).append("\n"); 
		query.append("      ,C.EQ_TPSZ_CD" ).append("\n"); 
		query.append("      ,NVL(C.UPLN_SO_FLG,'N') 						AS UPLN_SO_FLG" ).append("\n"); 
		query.append("      ,C.CURR_CD                                                               " ).append("\n"); 
		query.append("      ,NVL(C.BZC_AMT,0)                             AS BZC_AMT                 " ).append("\n"); 
		query.append("      ,NVL(C.NEGO_AMT,0)                            AS NEGO_AMT                " ).append("\n"); 
		query.append("      ,NVL(C.FUEL_SCG_AMT,0)                        AS FUEL_SCG_AMT" ).append("\n"); 
		query.append("      ,NVL(C.SCG_VAT_AMT,0)                         AS SCG_VAT_AMT" ).append("\n"); 
		query.append("      ,NVL(C.TOLL_FEE_AMT,0)                        AS TOLL_FEE_AMT               " ).append("\n"); 
		query.append("      ,NVL(C.ETC_ADD_AMT,0)                         AS ETC_ADD_AMT             " ).append("\n"); 
		query.append("      ,NVL(C.BZC_AMT,0)+NVL(C.ETC_ADD_AMT,0) +NVL(C.FUEL_SCG_AMT,0)+NVL(C.SCG_VAT_AMT,0)+NVL(C.TOLL_FEE_AMT,0)+NVL(C.NEGO_AMT,0)     AS WO_TOT_AMT              " ).append("\n"); 
		query.append("      ,C.INV_XCH_RT                                                            " ).append("\n"); 
		query.append("      ,C.TRSP_INV_CALC_LGC_TP_CD                                               " ).append("\n"); 
		query.append("      ,COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD00874', C.TRSP_INV_CALC_LGC_TP_CD) AS TRSP_INV_CALC_LGC_TP_NM " ).append("\n"); 
		query.append("      ,A.INV_CURR_CD                                                           " ).append("\n"); 
		query.append("      ,NVL(C.INV_BZC_AMT,0)                         AS INV_BZC_AMT             " ).append("\n"); 
		query.append("      ,NVL(C.INV_ETC_ADD_AMT,0)                     AS INV_ETC_ADD_AMT         " ).append("\n"); 
		query.append("      ,NVL(C.INV_BZC_AMT,0) +NVL(C.INV_ETC_ADD_AMT,0)                    AS INV_TOT_AMT             " ).append("\n"); 
		query.append("      ,NVL(A.INV_VAT_AMT,0)                         AS INV_VAT_AMT" ).append("\n"); 
		query.append("      ,NVL(A.INV_WHLD_TAX_AMT,0)                    AS INV_WHLD_TAX_AMT        " ).append("\n"); 
		query.append("      ,NVL(A.INV_SBC_AMT,0)                         AS INV_SBC_AMT" ).append("\n"); 
		query.append("      ,DECODE(NVL(A.INV_TTL_AMT,0), 0, (SUM( NVL(C.INV_BZC_AMT,0) + NVL(C.INV_ETC_ADD_AMT,0)) OVER (PARTITION BY C.INV_NO, C.INV_VNDR_SEQ))+NVL(A.INV_VAT_AMT,0)+NVL(A.INV_WHLD_TAX_AMT,0), NVL(A.INV_TTL_AMT,0))    AS INV_GTTL_AMT            " ).append("\n"); 
		query.append("      ,TO_CHAR(A.INV_ISS_DT, 'YYYY-MM-DD')          AS INV_ISS_DT              " ).append("\n"); 
		query.append("      ,TO_CHAR(A.INV_RCV_DT, 'YYYY-MM-DD')          AS INV_RCV_DT              " ).append("\n"); 
		query.append("      ,TO_CHAR(A.PAY_DT, 'YYYY-MM-DD')              AS PAY_DT                  " ).append("\n"); 
		query.append("      ,A.GL_DT                  " ).append("\n"); 
		query.append("      ,TO_CHAR(A.UPD_DT, 'YYYY-MM-DD')              AS UPD_DT" ).append("\n"); 
		query.append("      ,A.CSR_NO                                                           " ).append("\n"); 
		query.append("      ,A.INV_PAY_MZD_CD" ).append("\n"); 
		query.append("      ,A.INV_CHK_TRNS_NO                                                       " ).append("\n"); 
		query.append("      ,C.INV_RMK                                                               " ).append("\n"); 
		query.append("      ,C.SP_INV_RMK" ).append("\n"); 
		query.append("      ,A.CRE_OFC_CD" ).append("\n"); 
		query.append("      ,A.CRE_USR_ID" ).append("\n"); 
		query.append("      ,A.UPD_USR_ID" ).append("\n"); 
		query.append("      ,U.USR_NM UPD_USR_NM                                   " ).append("\n"); 
		query.append("      ,DECODE(C.HJL_NO, '', 'N', 'Y') ETS_STS_FLG" ).append("\n"); 
		query.append(" FROM  TRS_TRSP_INV_WRK    A                          " ).append("\n"); 
		query.append("      ,MDM_VENDOR          B                          " ).append("\n"); 
		query.append("      ,TRS_TRSP_SVC_ORD    C                          " ).append("\n"); 
		query.append("      ,MDM_VENDOR          D    " ).append("\n"); 
		query.append("      ,COM_USER            U                       " ).append("\n"); 
		query.append(" WHERE A.INV_VNDR_SEQ = B.VNDR_SEQ " ).append("\n"); 
		query.append("   AND A.INV_VNDR_SEQ = C.INV_VNDR_SEQ           " ).append("\n"); 
		query.append("   AND A.INV_NO = C.INV_NO                 " ).append("\n"); 
		query.append("   AND C.VNDR_SEQ = D.VNDR_SEQ      " ).append("\n"); 
		query.append("   AND A.UPD_USR_ID = U.USR_ID(+)         " ).append("\n"); 
		query.append("   AND A.INV_NO = @[inv_no]                        " ).append("\n"); 
		query.append("   AND A.INV_VNDR_SEQ = @[inv_vndr_seq]" ).append("\n"); 

	}
}