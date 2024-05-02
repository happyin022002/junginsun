/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : MnrSendGWAgreementInfoDBDAOPrintComCsrAgmtInfo2RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.02
*@LastModifier : 
*@LastVersion : 1.0
* 2015.01.02 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.agreementmanage.ratemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MnrSendGWAgreementInfoDBDAOPrintComCsrAgmtInfo2RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * G/W 전송 xmlData Agreement Info
	  * CSR No. + VNDR Seq. + Inv No. 추가
	  * -- 2014.11 10만불 결제관련
	  * -- [CHM-201433304]
	  *   CSR 승인 강화에 따른 ALPS MNR-AGMT에 GW Document Contract Link 관련 추가 요청 사항
	  * -- [CHM-201433507]
	  *   GW Document and ALPS MNR-Agreement에 agreement link 관련하여 MDM에 Interface 요청
	  * </pre>
	  */
	public MnrSendGWAgreementInfoDBDAOPrintComCsrAgmtInfo2RSQL(){
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
		query.append("Path : com.hanjin.apps.alps.ees.mnr.agreementmanage.ratemgt.integration").append("\n"); 
		query.append("FileName : MnrSendGWAgreementInfoDBDAOPrintComCsrAgmtInfo2RSQL").append("\n"); 
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
		query.append("SELECT DISTINCT" ).append("\n"); 
		query.append("  T.GW_UQ_DOC_NO AS l_assetcd" ).append("\n"); 
		query.append(", T.GW_UQ_DOC_TIT_NM AS l_document_title" ).append("\n"); 
		query.append(", AP.CSR_NO AS csr_no" ).append("\n"); 
		query.append(", A.VNDR_SEQ AS vndr_seq" ).append("\n"); 
		query.append(", AP.INV_NO AS inv_no" ).append("\n"); 
		query.append("FROM MNR_AGMT_HDR A" ).append("\n"); 
		query.append("   , MNR_ORD_HDR H" ).append("\n"); 
		query.append("   , MNR_AGMT_ATCH T" ).append("\n"); 
		query.append("   , MNR_ORD_DTL D" ).append("\n"); 
		query.append("   , MNR_PAY_INV_WRK P" ).append("\n"); 
		query.append("   , MDM_VENDOR V" ).append("\n"); 
		query.append("   , (select distinct A.CSR_NO, A.SRC_CTNT, A.VNDR_NO, D.ATTR_CTNT1 INV_NO, P.INV_RGST_NO" ).append("\n"); 
		query.append("        from AP_INV_HDR A, AP_INV_DTRB D, AP_PAY_INV P" ).append("\n"); 
		query.append("       where 1=1" ).append("\n"); 
		query.append("         and A.CSR_NO = D.CSR_NO" ).append("\n"); 
		query.append("         and A.CSR_NO = @[csr_no]  --// csr no.로 invoice를 찾아온다." ).append("\n"); 
		query.append("         and A.CSR_NO = P.CSR_NO" ).append("\n"); 
		query.append("         and A.VNDR_NO = P.VNDR_SEQ" ).append("\n"); 
		query.append("         and D.ATTR_CTNT1 = P.INV_NO" ).append("\n"); 
		query.append("         and NVL(P.DELT_FLG,'N') <> 'Y') AP" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND A.AGMT_OFC_CTY_CD = H.AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("AND A.AGMT_SEQ = H.AGMT_SEQ" ).append("\n"); 
		query.append("AND A.AGMT_VER_NO = H.AGMT_VER_NO" ).append("\n"); 
		query.append("AND A.AGMT_OFC_CTY_CD = T.AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("AND A.AGMT_SEQ = T.AGMT_SEQ" ).append("\n"); 
		query.append("AND A.AGMT_VER_NO = T.AGMT_VER_NO" ).append("\n"); 
		query.append("AND H.MNR_ORD_OFC_CTY_CD = D.MNR_ORD_OFC_CTY_CD" ).append("\n"); 
		query.append("AND H.MNR_ORD_SEQ = D.MNR_ORD_SEQ" ).append("\n"); 
		query.append("AND D.INV_NO = P.INV_NO" ).append("\n"); 
		query.append("AND D.INV_NO = AP.INV_NO" ).append("\n"); 
		query.append("AND P.INV_RGST_NO = AP.INV_RGST_NO" ).append("\n"); 
		query.append("AND A.VNDR_SEQ = H.VNDR_SEQ" ).append("\n"); 
		query.append("AND V.VNDR_SEQ = H.VNDR_SEQ" ).append("\n"); 
		query.append("AND V.PRNT_VNDR_SEQ = AP.VNDR_NO" ).append("\n"); 
		query.append("AND NVL(A.DELT_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append("AND NVL(V.DELT_FLG, 'N') <> 'Y'" ).append("\n"); 

	}
}