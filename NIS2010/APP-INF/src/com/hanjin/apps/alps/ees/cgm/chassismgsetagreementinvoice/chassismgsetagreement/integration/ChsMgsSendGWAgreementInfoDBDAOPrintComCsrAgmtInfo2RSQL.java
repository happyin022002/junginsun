/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ChsMgsSendGWAgreementInfoDBDAOPrintComCsrAgmtInfo2RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.25
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.25 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChsMgsSendGWAgreementInfoDBDAOPrintComCsrAgmtInfo2RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * G/W 전송 xmlData Agreement Info
	  * CSR No. + VNDR Seq. + Inv No. 추가
	  * -- 2014.11 10만불 결제관련
	  * </pre>
	  */
	public ChsMgsSendGWAgreementInfoDBDAOPrintComCsrAgmtInfo2RSQL(){
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
		query.append("Path : com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.integration").append("\n"); 
		query.append("FileName : ChsMgsSendGWAgreementInfoDBDAOPrintComCsrAgmtInfo2RSQL").append("\n"); 
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
		query.append("  A.GW_UQ_DOC_NO AS l_assetcd" ).append("\n"); 
		query.append(", A.GW_UQ_DOC_TIT_NM AS l_document_title" ).append("\n"); 
		query.append(", AP.CSR_NO AS csr_no" ).append("\n"); 
		query.append(", AP.VNDR_NO AS vndr_seq" ).append("\n"); 
		query.append(", AP.INV_NO AS inv_no" ).append("\n"); 
		query.append("FROM CGM_AGREEMENT A" ).append("\n"); 
		query.append("   , CGM_PAY_INV CP" ).append("\n"); 
		query.append("   ,( select distinct A.CSR_NO, A.SRC_CTNT, A.VNDR_NO, D.ATTR_CTNT1 INV_NO, P.INV_RGST_NO" ).append("\n"); 
		query.append("        from AP_INV_HDR A, AP_INV_DTRB D, AP_PAY_INV P" ).append("\n"); 
		query.append("       where 1=1" ).append("\n"); 
		query.append("         and A.CSR_NO = D.CSR_NO" ).append("\n"); 
		query.append("         and A.CSR_NO = @[csr_no]  -- csr no.로 invoice를 찾아온다." ).append("\n"); 
		query.append("         and A.CSR_NO = P.CSR_NO" ).append("\n"); 
		query.append("         and A.VNDR_NO = P.VNDR_SEQ" ).append("\n"); 
		query.append("         and D.ATTR_CTNT1 = P.INV_NO" ).append("\n"); 
		query.append("         and NVL(P.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("     ) AP" ).append("\n"); 
		query.append("WHERE A.AGMT_OFC_CTY_CD = CP.AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("AND A.AGMT_SEQ = CP.AGMT_SEQ" ).append("\n"); 
		query.append("AND A.AGMT_VER_NO = CP.AGMT_VER_NO" ).append("\n"); 
		query.append("AND CP.INV_RGST_NO = AP.INV_RGST_NO" ).append("\n"); 
		query.append("AND CP.INV_NO = AP.INV_NO" ).append("\n"); 
		query.append("AND A.VNDR_SEQ = AP.VNDR_NO" ).append("\n"); 
		query.append("AND NVL(A.DELT_FLG, 'N') <> 'Y'" ).append("\n"); 

	}
}