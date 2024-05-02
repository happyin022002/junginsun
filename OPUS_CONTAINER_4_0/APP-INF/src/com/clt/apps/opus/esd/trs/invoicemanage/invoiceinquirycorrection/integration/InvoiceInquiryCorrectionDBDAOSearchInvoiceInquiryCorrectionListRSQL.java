/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : InvoiceInquiryCorrectionDBDAOSearchInvoiceInquiryCorrectionListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.12.01
*@LastModifier : 김성욱
*@LastVersion : 1.0
* 2016.12.01 김성욱
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.invoicemanage.invoiceinquirycorrection.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sung-Wook Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceInquiryCorrectionDBDAOSearchInvoiceInquiryCorrectionListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Invoice 생성내역을 조회
	  * </pre>
	  */
	public InvoiceInquiryCorrectionDBDAOSearchInvoiceInquiryCorrectionListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hold_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("todate",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("status_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fmdate",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("FORM_USR_OFC_CD",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ivc_cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.invoicemanage.invoiceinquirycorrection.integration").append("\n"); 
		query.append("FileName : InvoiceInquiryCorrectionDBDAOSearchInvoiceInquiryCorrectionListRSQL").append("\n"); 
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
		query.append("#if(${inv_tp_cd} == 'A' || ${inv_tp_cd} == 'C')" ).append("\n"); 
		query.append("SELECT	" ).append("\n"); 
		query.append("	A.IF_SYS_KND_CD			" ).append("\n"); 
		query.append(",	COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD00914', A.IF_SYS_KND_CD) IF_SYS_KND_NM				" ).append("\n"); 
		query.append(",	A.TRSP_INV_AUD_STS_CD	" ).append("\n"); 
		query.append(",	COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD00824', A.TRSP_INV_AUD_STS_CD) TRSP_INV_AUD_STS_NM" ).append("\n"); 
		query.append(",	DECODE(A.INV_HLD_FLG, 'N', '0', 'Y', '1') INV_HLD_FLG" ).append("\n"); 
		query.append(",	'C' INV_TP_CD" ).append("\n"); 
		query.append(",	A.INV_NO				" ).append("\n"); 
		query.append(",	LPAD(TO_CHAR(A.INV_VNDR_SEQ), 6, '0') AS INV_VNDR_SEQ					" ).append("\n"); 
		query.append(",	B.VNDR_LGL_ENG_NM INV_VNDR_NM					" ).append("\n"); 
		query.append(",	C.CURR_CD				" ).append("\n"); 
		query.append(",	SUM(NVL(C.BZC_AMT,0)+NVL(C.ETC_ADD_AMT,0) +NVL(C.FUEL_SCG_AMT,0)+NVL(C.NEGO_AMT,0)) WO_TOT_AMT				" ).append("\n"); 
		query.append(",	C.INV_XCH_RT			" ).append("\n"); 
		query.append(",	C.TRSP_INV_CALC_LGC_TP_CD" ).append("\n"); 
		query.append(",	COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD00874', C.TRSP_INV_CALC_LGC_TP_CD) TRSP_INV_CALC_LGC_TP_NM				" ).append("\n"); 
		query.append(",	A.INV_CURR_CD			" ).append("\n"); 
		query.append(",	SUM(C.INV_BZC_AMT) SO_INV_BZC_AMT				" ).append("\n"); 
		query.append(",	SUM(NVL(C.INV_ETC_ADD_AMT,0)) AS SCG_AMT		" ).append("\n"); 
		query.append(",	SUM(ABS(NVL(C.INV_ETC_ADD_AMT,0))) AS ABS_SCG_AMT" ).append("\n"); 
		query.append(",	A.INV_BZC_AMT			" ).append("\n"); 
		query.append(",	A.INV_VAT_AMT			" ).append("\n"); 
		query.append(",	A.INV_WHLD_TAX_AMT		" ).append("\n"); 
		query.append(",	A.INV_TTL_AMT			" ).append("\n"); 
		query.append(",	TO_CHAR(A.INV_ISS_DT, 'YYYYMMDD') INV_ISS_DT	" ).append("\n"); 
		query.append(",	TO_CHAR(A.INV_RCV_DT, 'YYYYMMDD') INV_RCV_DT	" ).append("\n"); 
		query.append(",	TO_CHAR(A.PAY_DT, 'YYYYMMDD') PAY_DT			" ).append("\n"); 
		query.append(",	E.GL_DT					" ).append("\n"); 
		query.append(",	TO_CHAR(A.UPD_DT, 'YYYYMMDD') UPD_DT			" ).append("\n"); 
		query.append(",	TO_CHAR(A.INV_CFM_DT, 'YYYYMMDD') INV_CFM_DT	" ).append("\n"); 
		query.append(",	A.CSR_NO				" ).append("\n"); 
		query.append(",	A.INV_PAY_MZD_CD		" ).append("\n"); 
		query.append(",	A.INV_CHK_TRNS_NO		" ).append("\n"); 
		query.append(",	MAX(C.INV_RMK) INV_REMARK			" ).append("\n"); 
		query.append(",	A.CRE_OFC_CD			" ).append("\n"); 
		query.append(",	A.CRE_USR_ID			" ).append("\n"); 
		query.append(",	COUNT(D.OFC_CD) CNT_SPP	" ).append("\n"); 
		query.append(",	'N' RFND_FLG			" ).append("\n"); 
		query.append(",	A.RGST_NO" ).append("\n"); 
		query.append(",   SUM(NVL(C.INV_ADJ_BZC_AMT, 0)) INV_ADJ_BZC_AMT" ).append("\n"); 
		query.append("FROM TRS_TRSP_INV_WRK A		" ).append("\n"); 
		query.append(",	MDM_VENDOR B			" ).append("\n"); 
		query.append(",	TRS_TRSP_SVC_ORD C		" ).append("\n"); 
		query.append(",	TRS_TRSP_INV_OFC D" ).append("\n"); 
		query.append(",	AP_INV_HDR		 E	" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("	A.INV_VNDR_SEQ					= B.VNDR_SEQ" ).append("\n"); 
		query.append("AND	A.INV_VNDR_SEQ					= C.INV_VNDR_SEQ					" ).append("\n"); 
		query.append("AND	A.INV_NO						= C.INV_NO	" ).append("\n"); 
		query.append("AND A.CSR_NO					    = E.CSR_NO(+)" ).append("\n"); 
		query.append("AND	C.TRSP_SO_STS_CD				='I'		" ).append("\n"); 
		query.append("AND	D.INV_OFC_CD(+)		 			= @[FORM_USR_OFC_CD]			" ).append("\n"); 
		query.append("AND	A.CRE_OFC_CD					= D.OFC_CD(+)" ).append("\n"); 
		query.append("#if ( !(${fmdate} == '' ))" ).append("\n"); 
		query.append("	#if(${date_cd} == 'IS' )" ).append("\n"); 
		query.append("		AND A.INV_ISS_DT " ).append("\n"); 
		query.append("	#elseif(${date_cd} == 'PD')" ).append("\n"); 
		query.append("		AND A.PAY_DT " ).append("\n"); 
		query.append("	#elseif(${date_cd} == 'GL')" ).append("\n"); 
		query.append("		AND TO_DATE(NVL(E.GL_DT,'00010101')||'000001','YYYYMMDDHH24MISS')  " ).append("\n"); 
		query.append("	#elseif(${date_cd} == 'SU' )" ).append("\n"); 
		query.append("		AND A.UPD_DT " ).append("\n"); 
		query.append("	#elseif(${date_cd} == 'IC')" ).append("\n"); 
		query.append("		AND A.INV_CFM_DT " ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("		AND A.INV_RCV_DT " ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	BETWEEN TO_DATE(@[fmdate]||'000000','YYYYMMDDHH24MISS') AND TO_DATE(@[todate]||'235959','YYYYMMDDHH24MISS')		" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	AND A.TRSP_INV_AUD_STS_CD =   DECODE(@[status_cd], 'ALL', A.TRSP_INV_AUD_STS_CD, @[status_cd])" ).append("\n"); 
		query.append("	AND NVL(A.INV_HLD_FLG, 'N') = DECODE(@[hold_cd], 'ALL', NVL(A.INV_HLD_FLG, 'N'), @[hold_cd])" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (!(${combo_svc_provider} == '') ) " ).append("\n"); 
		query.append("	#if(${sp_tp} == 'wo')" ).append("\n"); 
		query.append("		AND A.WO_VNDR_SEQ = ${combo_svc_provider}				" ).append("\n"); 
		query.append("	#elseif(${sp_tp} == 'py')" ).append("\n"); 
		query.append("		AND A.INV_VNDR_SEQ = ${combo_svc_provider}	" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( $noCdArr.size() > 0)	" ).append("\n"); 
		query.append("	#if(${no_tp} == 'iv')" ).append("\n"); 
		query.append("		AND A.INV_NO " ).append("\n"); 
		query.append("	#elseif(${no_tp} == 'csr')" ).append("\n"); 
		query.append("		AND A.CSR_NO " ).append("\n"); 
		query.append("    #else" ).append("\n"); 
		query.append("		AND C.REF_INV_NO" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	IN ( " ).append("\n"); 
		query.append("	#foreach( ${key} in ${noCdArr})" ).append("\n"); 
		query.append("		#if($velocityCount == 1)" ).append("\n"); 
		query.append("			 '${key}'" ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("			,  '${key}'" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	)					" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( $ofcCdArr.size() > 0)	" ).append("\n"); 
		query.append("		AND A.CRE_OFC_CD " ).append("\n"); 
		query.append("	IN ( " ).append("\n"); 
		query.append("	#foreach( ${key} in ${ofcCdArr})" ).append("\n"); 
		query.append("		#if($velocityCount == 1)" ).append("\n"); 
		query.append("			 '${key}'" ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("			,  '${key}'" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	)					" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("	AND A.CRE_USR_ID = NVL(@[ivc_cre_usr_id], A.CRE_USR_ID)	" ).append("\n"); 
		query.append("GROUP BY					" ).append("\n"); 
		query.append("	A.IF_SYS_KND_CD			" ).append("\n"); 
		query.append(",	A.TRSP_INV_AUD_STS_CD	" ).append("\n"); 
		query.append(",	A.INV_HLD_FLG			" ).append("\n"); 
		query.append(",	A.INV_NO				" ).append("\n"); 
		query.append(",	A.INV_VNDR_SEQ			" ).append("\n"); 
		query.append(",	B.VNDR_LGL_ENG_NM		" ).append("\n"); 
		query.append(",	C.CURR_CD				" ).append("\n"); 
		query.append(",	C.INV_XCH_RT			" ).append("\n"); 
		query.append(",	C.TRSP_INV_CALC_LGC_TP_CD" ).append("\n"); 
		query.append(",	A.INV_CURR_CD			" ).append("\n"); 
		query.append(",	A.INV_BZC_AMT			" ).append("\n"); 
		query.append(",	A.INV_VAT_AMT			" ).append("\n"); 
		query.append(",	A.INV_WHLD_TAX_AMT		" ).append("\n"); 
		query.append(",	A.INV_TTL_AMT			" ).append("\n"); 
		query.append(",	A.INV_ISS_DT			" ).append("\n"); 
		query.append(",	A.INV_RCV_DT			" ).append("\n"); 
		query.append(",	A.PAY_DT				" ).append("\n"); 
		query.append(",	E.GL_DT					" ).append("\n"); 
		query.append(",	A.UPD_DT				" ).append("\n"); 
		query.append(",	A.INV_CFM_DT			" ).append("\n"); 
		query.append(",	A.CSR_NO				" ).append("\n"); 
		query.append(",	A.INV_PAY_MZD_CD		" ).append("\n"); 
		query.append(",	A.INV_CHK_TRNS_NO		" ).append("\n"); 
		query.append(",	A.CRE_OFC_CD			" ).append("\n"); 
		query.append(",	A.CRE_USR_ID			" ).append("\n"); 
		query.append(",	A.TRSP_INV_AUD_STS_CD	" ).append("\n"); 
		query.append(",	A.RGST_NO" ).append("\n"); 
		query.append("#if(${amount_verify_cd} == 'T')" ).append("\n"); 
		query.append("	HAVING" ).append("\n"); 
		query.append("	A.INV_NO IS NOT NULL				" ).append("\n"); 
		query.append("	AND		SUM(NVL(C.INV_ETC_ADD_AMT,0)) = 0" ).append("\n"); 
		query.append("#elseif(${amount_verify_cd} == 'F')" ).append("\n"); 
		query.append("	 HAVING " ).append("\n"); 
		query.append("	 A.INV_NO IS NOT NULL				" ).append("\n"); 
		query.append("	 AND 	SUM(NVL(C.INV_ETC_ADD_AMT,0)) <> 0	" ).append("\n"); 
		query.append("#end		" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${inv_tp_cd} == 'A')" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${inv_tp_cd} == 'A' || ${inv_tp_cd} == 'R')" ).append("\n"); 
		query.append("(	" ).append("\n"); 
		query.append("SELECT /*+ INDEX(C XPKTRS_TRSP_RFND_INV)*/		" ).append("\n"); 
		query.append("	A.IF_SYS_KND_CD		" ).append("\n"); 
		query.append("  ,	COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD00914', A.IF_SYS_KND_CD) IF_SYS_KND_NM			" ).append("\n"); 
		query.append("  ,	A.TRSP_INV_AUD_STS_CD" ).append("\n"); 
		query.append("  ,	COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD00824', A.TRSP_INV_AUD_STS_CD) TRSP_INV_AUD_STS_NM					" ).append("\n"); 
		query.append("  ,	DECODE(A.INV_HLD_FLG, 'N', '0', 'Y', '1') INV_HLD_FLG" ).append("\n"); 
		query.append("  ,	'R' INV_TP_CD" ).append("\n"); 
		query.append("  ,	A.INV_NO			" ).append("\n"); 
		query.append("  ,	LPAD(TO_CHAR(A.INV_VNDR_SEQ), 6, '0') AS INV_VNDR_SEQ				" ).append("\n"); 
		query.append("  ,	B.VNDR_LGL_ENG_NM INV_VNDR_NM				" ).append("\n"); 
		query.append("  ,	'' CURR_CD			" ).append("\n"); 
		query.append("  ,	0 WO_TOT_AMT				                            			" ).append("\n"); 
		query.append("  ,	0 INV_XCH_RT		" ).append("\n"); 
		query.append("  ,	'' TRSP_INV_CALC_LGC_TP_CD					" ).append("\n"); 
		query.append("  ,	'' TRSP_INV_CALC_LGC_TP_NM				                			" ).append("\n"); 
		query.append("  ,	A.INV_CURR_CD		" ).append("\n"); 
		query.append("  ,	SUM(C.TRSP_RFND_INV_AMT) AS SO_INV_BZC_AMT" ).append("\n"); 
		query.append("  ,	0 AS SCG_AMT		            			" ).append("\n"); 
		query.append("  ,	0 AS ABS_SCG_AMT	            			" ).append("\n"); 
		query.append("  ,	A.INV_BZC_AMT AS INV_BZC_AMT 			" ).append("\n"); 
		query.append("  ,	A.INV_VAT_AMT AS INV_VAT_AMT				" ).append("\n"); 
		query.append("  ,	A.INV_WHLD_TAX_AMT	" ).append("\n"); 
		query.append("  ,	A.INV_TTL_AMT AS INV_TTL_AMT				" ).append("\n"); 
		query.append("  ,	TO_CHAR(A.INV_ISS_DT, 'YYYYMMDD') INV_ISS_DT" ).append("\n"); 
		query.append("  ,	TO_CHAR(A.INV_RCV_DT, 'YYYYMMDD') INV_RCV_DT" ).append("\n"); 
		query.append("  ,	TO_CHAR(A.PAY_DT, 'YYYYMMDD') PAY_DT		" ).append("\n"); 
		query.append("  ,	E.GL_DT				" ).append("\n"); 
		query.append("  ,	TO_CHAR(A.UPD_DT, 'YYYYMMDD') UPD_DT		" ).append("\n"); 
		query.append("  ,	TO_CHAR(A.INV_CFM_DT, 'YYYYMMDD') INV_CFM_DT" ).append("\n"); 
		query.append("  ,	A.CSR_NO			" ).append("\n"); 
		query.append("  ,	A.INV_PAY_MZD_CD	" ).append("\n"); 
		query.append("  ,	A.INV_CHK_TRNS_NO	" ).append("\n"); 
		query.append("  ,	'' INV_REMARK		" ).append("\n"); 
		query.append("  ,	A.CRE_OFC_CD		" ).append("\n"); 
		query.append("  ,	A.CRE_USR_ID		" ).append("\n"); 
		query.append("  ,	COUNT(D.OFC_CD) CNT_SPP" ).append("\n"); 
		query.append("  ,	'Y' RFND_FLG		" ).append("\n"); 
		query.append("  ,	A.RGST_NO" ).append("\n"); 
		query.append("  , 0 INV_ADJ_BZC_AMT" ).append("\n"); 
		query.append("  FROM 					" ).append("\n"); 
		query.append("  	TRS_TRSP_INV_WRK A	" ).append("\n"); 
		query.append("  ,	MDM_VENDOR B		" ).append("\n"); 
		query.append("  ,	TRS_TRSP_RFND_INV C	" ).append("\n"); 
		query.append("  ,	TRS_TRSP_INV_OFC D" ).append("\n"); 
		query.append("  , AP_INV_HDR       E	" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("	A.INV_VNDR_SEQ					= B.VNDR_SEQ" ).append("\n"); 
		query.append("AND	A.INV_VNDR_SEQ					= C.INV_VNDR_SEQ					" ).append("\n"); 
		query.append("AND	A.INV_NO						= C.INV_NO	" ).append("\n"); 
		query.append("AND A.CSR_NO 						= E.CSR_NO(+)" ).append("\n"); 
		query.append("AND	NVL(A.INV_RJCT_FLG,'N') 		='N'		" ).append("\n"); 
		query.append("AND	D.INV_OFC_CD(+)		 			= @[FORM_USR_OFC_CD]			" ).append("\n"); 
		query.append("AND	A.CRE_OFC_CD					= D.OFC_CD(+)" ).append("\n"); 
		query.append("#if ( !(${fmdate} == '' ))" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if( ${date_cd} == 'IS' )" ).append("\n"); 
		query.append("		AND A.INV_ISS_DT " ).append("\n"); 
		query.append("	#elseif(${date_cd} == 'PD' )" ).append("\n"); 
		query.append("		AND A.PAY_DT " ).append("\n"); 
		query.append("	#elseif(${date_cd} == 'GL' )" ).append("\n"); 
		query.append("		AND TO_DATE(NVL(E.GL_DT,'00010101')||'000001','YYYYMMDDHH24MISS')  " ).append("\n"); 
		query.append("	#elseif(${date_cd} == 'SU' )" ).append("\n"); 
		query.append("		AND A.UPD_DT " ).append("\n"); 
		query.append("	#elseif(${date_cd} == 'IC' )" ).append("\n"); 
		query.append("		AND A.INV_CFM_DT " ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("		AND A.INV_RCV_DT " ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	BETWEEN TO_DATE(@[fmdate]||'000000','YYYYMMDDHH24MISS') AND TO_DATE(@[todate]||'235959','YYYYMMDDHH24MISS')		" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	AND A.TRSP_INV_AUD_STS_CD =   DECODE(@[status_cd], 'ALL', A.TRSP_INV_AUD_STS_CD, @[status_cd])" ).append("\n"); 
		query.append("	AND NVL(A.INV_HLD_FLG, 'N') = DECODE(@[hold_cd], 'ALL', NVL(A.INV_HLD_FLG, 'N'), @[hold_cd])" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (!(${combo_svc_provider} == '') ) " ).append("\n"); 
		query.append("	#if(${sp_tp} == 'wo')" ).append("\n"); 
		query.append("		AND A.WO_VNDR_SEQ = ${combo_svc_provider}				" ).append("\n"); 
		query.append("	#elseif(${sp_tp} == 'py')" ).append("\n"); 
		query.append("		AND A.INV_VNDR_SEQ = ${combo_svc_provider}	" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${no_tp} != 'reference')" ).append("\n"); 
		query.append("#if ( $noCdArr.size() > 0)	" ).append("\n"); 
		query.append("	#if(${no_tp} == 'iv')" ).append("\n"); 
		query.append("		AND A.INV_NO " ).append("\n"); 
		query.append("	#elseif(${no_tp} == 'csr')" ).append("\n"); 
		query.append("		AND A.CSR_NO" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("	IN ( " ).append("\n"); 
		query.append("	#foreach( ${key} in ${noCdArr})" ).append("\n"); 
		query.append("		#if($velocityCount == 1)" ).append("\n"); 
		query.append("			 '${key}'" ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("			,  '${key}'" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	)					" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end	" ).append("\n"); 
		query.append("#if ( $ofcCdArr.size() > 0)	" ).append("\n"); 
		query.append("		AND A.CRE_OFC_CD " ).append("\n"); 
		query.append("	IN ( " ).append("\n"); 
		query.append("	#foreach( ${key} in ${ofcCdArr})" ).append("\n"); 
		query.append("		#if($velocityCount == 1)" ).append("\n"); 
		query.append("			 '${key}'" ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("			,  '${key}'" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	)					" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("	AND A.CRE_USR_ID = NVL(@[ivc_cre_usr_id], A.CRE_USR_ID)" ).append("\n"); 
		query.append("GROUP BY					" ).append("\n"); 
		query.append("	A.IF_SYS_KND_CD			" ).append("\n"); 
		query.append(",	A.TRSP_INV_AUD_STS_CD	" ).append("\n"); 
		query.append(",	A.INV_HLD_FLG			" ).append("\n"); 
		query.append(",	A.INV_NO				" ).append("\n"); 
		query.append(",	A.INV_VNDR_SEQ			" ).append("\n"); 
		query.append(",	B.VNDR_LGL_ENG_NM		" ).append("\n"); 
		query.append(",	A.INV_CURR_CD			" ).append("\n"); 
		query.append(",	A.INV_BZC_AMT			" ).append("\n"); 
		query.append(",	A.INV_VAT_AMT			" ).append("\n"); 
		query.append(",	A.INV_WHLD_TAX_AMT		" ).append("\n"); 
		query.append(",	A.INV_TTL_AMT			" ).append("\n"); 
		query.append(",	A.INV_ISS_DT			" ).append("\n"); 
		query.append(",	A.INV_RCV_DT			" ).append("\n"); 
		query.append(",	A.PAY_DT				" ).append("\n"); 
		query.append(",	E.GL_DT					" ).append("\n"); 
		query.append(",	A.UPD_DT				" ).append("\n"); 
		query.append(",	A.INV_CFM_DT			" ).append("\n"); 
		query.append(",	A.CSR_NO				" ).append("\n"); 
		query.append(",	A.INV_PAY_MZD_CD		" ).append("\n"); 
		query.append(",	A.INV_CHK_TRNS_NO		" ).append("\n"); 
		query.append(",	A.CRE_OFC_CD			" ).append("\n"); 
		query.append(",	A.CRE_USR_ID			" ).append("\n"); 
		query.append(",	A.TRSP_INV_AUD_STS_CD	" ).append("\n"); 
		query.append(",	A.RGST_NO" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${inv_tp_cd} == 'A')" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${inv_tp_cd} == 'A' || ${inv_tp_cd} == 'P')" ).append("\n"); 
		query.append("--POOL CHASSIS REPOSITION" ).append("\n"); 
		query.append("SELECT	" ).append("\n"); 
		query.append("	A.IF_SYS_KND_CD			" ).append("\n"); 
		query.append(",	COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD00914', A.IF_SYS_KND_CD) IF_SYS_KND_NM				" ).append("\n"); 
		query.append(",	A.TRSP_INV_AUD_STS_CD	" ).append("\n"); 
		query.append(",	COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD00824', A.TRSP_INV_AUD_STS_CD) TRSP_INV_AUD_STS_NM" ).append("\n"); 
		query.append(",	DECODE(A.INV_HLD_FLG, 'N', '0', 'Y', '1') INV_HLD_FLG" ).append("\n"); 
		query.append(",	'P' INV_TP_CD					" ).append("\n"); 
		query.append(",	A.INV_NO				" ).append("\n"); 
		query.append(",	LPAD(TO_CHAR(A.INV_VNDR_SEQ), 6, '0') AS INV_VNDR_SEQ					" ).append("\n"); 
		query.append(",	B.VNDR_LGL_ENG_NM INV_VNDR_NM					" ).append("\n"); 
		query.append(",	'' CURR_CD				" ).append("\n"); 
		query.append(",	0 WO_TOT_AMT				" ).append("\n"); 
		query.append(",	0 INV_XCH_RT			" ).append("\n"); 
		query.append(",	'' TRSP_INV_CALC_LGC_TP_CD" ).append("\n"); 
		query.append(",	'' TRSP_INV_CALC_LGC_TP_NM				" ).append("\n"); 
		query.append(",	A.INV_CURR_CD			" ).append("\n"); 
		query.append(",	0 SO_INV_BZC_AMT				" ).append("\n"); 
		query.append(",	0 AS SCG_AMT		" ).append("\n"); 
		query.append(",	0 AS ABS_SCG_AMT" ).append("\n"); 
		query.append(",	A.INV_BZC_AMT			" ).append("\n"); 
		query.append(",	A.INV_VAT_AMT			" ).append("\n"); 
		query.append(",	A.INV_WHLD_TAX_AMT		" ).append("\n"); 
		query.append(",	A.INV_TTL_AMT			" ).append("\n"); 
		query.append(",	TO_CHAR(A.INV_ISS_DT, 'YYYYMMDD') INV_ISS_DT	" ).append("\n"); 
		query.append(",	TO_CHAR(A.INV_RCV_DT, 'YYYYMMDD') INV_RCV_DT	" ).append("\n"); 
		query.append(",	TO_CHAR(A.PAY_DT, 'YYYYMMDD') PAY_DT			" ).append("\n"); 
		query.append(",	E.GL_DT					" ).append("\n"); 
		query.append(",	TO_CHAR(A.UPD_DT, 'YYYYMMDD') UPD_DT			" ).append("\n"); 
		query.append(",	TO_CHAR(A.INV_CFM_DT, 'YYYYMMDD') INV_CFM_DT	" ).append("\n"); 
		query.append(",	A.CSR_NO				" ).append("\n"); 
		query.append(",	A.INV_PAY_MZD_CD		" ).append("\n"); 
		query.append(",	A.INV_CHK_TRNS_NO		" ).append("\n"); 
		query.append(",	'' INV_REMARK			" ).append("\n"); 
		query.append(",	A.CRE_OFC_CD			" ).append("\n"); 
		query.append(",	A.CRE_USR_ID			" ).append("\n"); 
		query.append(",	COUNT(D.OFC_CD) CNT_SPP	" ).append("\n"); 
		query.append(",	'N' RFND_FLG			" ).append("\n"); 
		query.append(",	A.RGST_NO" ).append("\n"); 
		query.append(",   0 INV_ADJ_BZC_AMT" ).append("\n"); 
		query.append("FROM TRS_TRSP_INV_WRK A		" ).append("\n"); 
		query.append(",	MDM_VENDOR B			" ).append("\n"); 
		query.append(",	TRS_TRSP_POOL_CHSS_INV C		" ).append("\n"); 
		query.append(",	TRS_TRSP_INV_OFC D" ).append("\n"); 
		query.append(",	AP_INV_HDR		 E	" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("	A.INV_VNDR_SEQ					= B.VNDR_SEQ" ).append("\n"); 
		query.append("AND	A.INV_VNDR_SEQ					= C.INV_VNDR_SEQ					" ).append("\n"); 
		query.append("AND	A.INV_NO						= C.INV_NO	" ).append("\n"); 
		query.append("AND A.CSR_NO					    = E.CSR_NO(+)" ).append("\n"); 
		query.append("AND	D.INV_OFC_CD(+)		 			= @[FORM_USR_OFC_CD]			" ).append("\n"); 
		query.append("AND	A.CRE_OFC_CD					= D.OFC_CD(+)" ).append("\n"); 
		query.append("#if ( !(${fmdate} == '' ))" ).append("\n"); 
		query.append("	#if(${date_cd} == 'IS' )" ).append("\n"); 
		query.append("		AND A.INV_ISS_DT " ).append("\n"); 
		query.append("	#elseif(${date_cd} == 'PD')" ).append("\n"); 
		query.append("		AND A.PAY_DT " ).append("\n"); 
		query.append("	#elseif(${date_cd} == 'GL')" ).append("\n"); 
		query.append("		AND TO_DATE(NVL(E.GL_DT,'00010101')||'000001','YYYYMMDDHH24MISS')  " ).append("\n"); 
		query.append("	#elseif(${date_cd} == 'SU' )" ).append("\n"); 
		query.append("		AND A.UPD_DT " ).append("\n"); 
		query.append("	#elseif(${date_cd} == 'IC')" ).append("\n"); 
		query.append("		AND A.INV_CFM_DT " ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("		AND A.INV_RCV_DT " ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	BETWEEN TO_DATE(@[fmdate]||'000000','YYYYMMDDHH24MISS') AND TO_DATE(@[todate]||'235959','YYYYMMDDHH24MISS')		" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	AND A.TRSP_INV_AUD_STS_CD =   DECODE(@[status_cd], 'ALL', A.TRSP_INV_AUD_STS_CD, @[status_cd])" ).append("\n"); 
		query.append("	AND NVL(A.INV_HLD_FLG, 'N') = DECODE(@[hold_cd], 'ALL', NVL(A.INV_HLD_FLG, 'N'), @[hold_cd])" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (!(${combo_svc_provider} == '') ) " ).append("\n"); 
		query.append("	#if(${sp_tp} == 'wo')" ).append("\n"); 
		query.append("		AND A.WO_VNDR_SEQ = ${combo_svc_provider}				" ).append("\n"); 
		query.append("	#elseif(${sp_tp} == 'py')" ).append("\n"); 
		query.append("		AND A.INV_VNDR_SEQ = ${combo_svc_provider}	" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${no_tp} != 'reference')" ).append("\n"); 
		query.append("#if ( $noCdArr.size() > 0)	" ).append("\n"); 
		query.append("	#if(${no_tp} == 'iv')" ).append("\n"); 
		query.append("		AND A.INV_NO " ).append("\n"); 
		query.append("	#elseif(${no_tp} == 'csr')" ).append("\n"); 
		query.append("		AND A.CSR_NO " ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	IN ( " ).append("\n"); 
		query.append("	#foreach( ${key} in ${noCdArr})" ).append("\n"); 
		query.append("		#if($velocityCount == 1)" ).append("\n"); 
		query.append("			 '${key}'" ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("			,  '${key}'" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	)					" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( $ofcCdArr.size() > 0)	" ).append("\n"); 
		query.append("		AND A.CRE_OFC_CD " ).append("\n"); 
		query.append("	IN ( " ).append("\n"); 
		query.append("	#foreach( ${key} in ${ofcCdArr})" ).append("\n"); 
		query.append("		#if($velocityCount == 1)" ).append("\n"); 
		query.append("			 '${key}'" ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("			,  '${key}'" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	)					" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("	AND A.CRE_USR_ID = NVL(@[ivc_cre_usr_id], A.CRE_USR_ID)	" ).append("\n"); 
		query.append("GROUP BY					" ).append("\n"); 
		query.append("	A.IF_SYS_KND_CD			" ).append("\n"); 
		query.append(",	A.TRSP_INV_AUD_STS_CD	" ).append("\n"); 
		query.append(",	A.INV_HLD_FLG			" ).append("\n"); 
		query.append(",	A.INV_NO				" ).append("\n"); 
		query.append(",	A.INV_VNDR_SEQ			" ).append("\n"); 
		query.append(",	B.VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append(",	A.INV_CURR_CD			" ).append("\n"); 
		query.append(",	A.INV_BZC_AMT			" ).append("\n"); 
		query.append(",	A.INV_VAT_AMT			" ).append("\n"); 
		query.append(",	A.INV_WHLD_TAX_AMT		" ).append("\n"); 
		query.append(",	A.INV_TTL_AMT			" ).append("\n"); 
		query.append(",	A.INV_ISS_DT			" ).append("\n"); 
		query.append(",	A.INV_RCV_DT			" ).append("\n"); 
		query.append(",	A.PAY_DT				" ).append("\n"); 
		query.append(",	E.GL_DT					" ).append("\n"); 
		query.append(",	A.UPD_DT				" ).append("\n"); 
		query.append(",	A.INV_CFM_DT			" ).append("\n"); 
		query.append(",	A.CSR_NO				" ).append("\n"); 
		query.append(",	A.INV_PAY_MZD_CD		" ).append("\n"); 
		query.append(",	A.INV_CHK_TRNS_NO		" ).append("\n"); 
		query.append(",	A.CRE_OFC_CD			" ).append("\n"); 
		query.append(",	A.CRE_USR_ID			" ).append("\n"); 
		query.append(",	A.TRSP_INV_AUD_STS_CD	" ).append("\n"); 
		query.append(",	A.RGST_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}