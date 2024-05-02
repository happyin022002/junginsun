/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : InvoiceEdiHitDBDAOSearchValidationInvEdiRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.13
*@LastModifier : 신동일
*@LastVersion : 1.0
* 2016.07.13 신동일
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.invoicehitedi.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author DONG-IL, SHIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceEdiHitDBDAOSearchValidationInvEdiRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EDI F/F INVOICE 데이터 검증
	  * </pre>
	  */
	public InvoiceEdiHitDBDAOSearchValidationInvEdiRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_edi_rcv_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.servicesio.invoicehitedi.integration").append("\n"); 
		query.append("FileName : InvoiceEdiHitDBDAOSearchValidationInvEdiRSQL").append("\n"); 
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
		query.append("SELECT NVL(SUBSTR(Z.INV_NO_CHK || Z.INV_NO_CHK2 || Z.INV_VNDR_SEQ_CHK || Z.INV_CURR_CD_CHK || Z.INV_TTL_AMT_CHK || Z.INV_ISS_DT_CHK || Z.INV_TTL_AMT_CHK2, 2),'Y') VAL_CHK" ).append("\n"); 
		query.append(" FROM ( SELECT CASE WHEN TRIM(Y.INV_NO)      IS NULL THEN ',INVALID INVOICE NO' ELSE ''  END AS INV_NO_CHK" ).append("\n"); 
		query.append("              ,CASE WHEN Y.TRS_INV_NO IS NOT NULL THEN ',INVOICE NUMBER DUPLICATION' ELSE '' END AS INV_NO_CHK2" ).append("\n"); 
		query.append("              ,CASE WHEN Y.INV_VNDR_SEQ IS NULL THEN ',INVALID VENDOR'     ELSE ''  END AS INV_VNDR_SEQ_CHK" ).append("\n"); 
		query.append("              ,CASE WHEN TRIM(Y.INV_CURR_CD) IS NULL THEN ',INVALID CURRENCY'   ELSE ''  END AS INV_CURR_CD_CHK" ).append("\n"); 
		query.append("              ,CASE WHEN NVL(Y.INV_TTL_AMT,0) =0 THEN ',INVALID TOTAL INVOICE AMOUNT(0)'  ELSE ''  END AS INV_TTL_AMT_CHK" ).append("\n"); 
		query.append("              ,CASE WHEN Y.INV_ISS_DT IS NULL THEN ',INVALID INVOICE ISSUE DATE' ELSE  '' END AS INV_ISS_DT_CHK" ).append("\n"); 
		query.append("              ,CASE WHEN Y.USD_INV_TTL_AMT <> Y.USD_SO_AMT THEN ',INVOICE AMOUNT MISMATCH' ELSE '' END AS INV_TTL_AMT_CHK2" ).append("\n"); 
		query.append("         FROM ( SELECT X.INV_NO" ).append("\n"); 
		query.append("                      ,X.TRS_INV_NO TRS_INV_NO" ).append("\n"); 
		query.append("                      ,X.INV_VNDR_SEQ" ).append("\n"); 
		query.append("                      ,X.INV_CURR_CD" ).append("\n"); 
		query.append("                      ,X.INV_TTL_AMT" ).append("\n"); 
		query.append("                      ,X.INV_ISS_DT" ).append("\n"); 
		query.append("                      ,X.USD_INV_TTL_AMT" ).append("\n"); 
		query.append("                      ,SUM(ROUND(TRS_COMMON_PKG.GET_CONVERSION_USD_AMT_FNC(X.TRS_SO_CURR_CD,X.TRS_SO_AMT),2)) USD_SO_AMT" ).append("\n"); 
		query.append("                  FROM ( SELECT A.INV_NO" ).append("\n"); 
		query.append("                               ,D.INV_NO TRS_INV_NO" ).append("\n"); 
		query.append("                               ,A.INV_VNDR_SEQ" ).append("\n"); 
		query.append("                               ,A.INV_CURR_CD" ).append("\n"); 
		query.append("                               ,A.INV_TTL_AMT" ).append("\n"); 
		query.append("                               ,A.INV_ISS_DT" ).append("\n"); 
		query.append("                               ,ROUND(TRS_COMMON_PKG.GET_CONVERSION_USD_AMT_FNC(A.INV_CURR_CD,A.INV_TTL_AMT),2) USD_INV_TTL_AMT" ).append("\n"); 
		query.append("                               ,C.CURR_CD TRS_SO_CURR_CD" ).append("\n"); 
		query.append("                               ,SUM(NVL(C.BZC_AMT,0)+NVL(C.FUEL_SCG_AMT,0)+NVL(C.NEGO_AMT,0)+NVL(C.ETC_ADD_AMT,0)+NVL(C.SCG_VAT_AMT,0)+NVL(C.HJL_HNDL_AMT,0)+NVL(C.TOLL_FEE_AMT,0)) TRS_SO_AMT" ).append("\n"); 
		query.append("                            FROM TRS_INV_EDI_RCV A" ).append("\n"); 
		query.append("                                ,TRS_INV_EDI_RCV_EQ B" ).append("\n"); 
		query.append("                                ,TRS_TRSP_SVC_ORD C" ).append("\n"); 
		query.append("                                ,TRS_TRSP_INV_WRK D" ).append("\n"); 
		query.append("                           WHERE A.INV_EDI_RCV_SEQ = B.INV_EDI_RCV_SEQ" ).append("\n"); 
		query.append("                             AND B.TRSP_SO_OFC_CTY_CD = C.TRSP_SO_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("                             AND B.TRSP_SO_SEQ = C.TRSP_SO_SEQ(+)" ).append("\n"); 
		query.append("                             AND A.INV_NO = D.INV_NO(+)" ).append("\n"); 
		query.append("                             AND A.INV_VNDR_SEQ = D.INV_VNDR_SEQ(+)" ).append("\n"); 
		query.append("                             AND A.INV_EDI_RCV_SEQ = @[inv_edi_rcv_seq]" ).append("\n"); 
		query.append("                        GROUP BY A.INV_NO" ).append("\n"); 
		query.append("                                ,D.INV_NO       " ).append("\n"); 
		query.append("                                ,A.INV_VNDR_SEQ" ).append("\n"); 
		query.append("                                ,A.INV_CURR_CD" ).append("\n"); 
		query.append("                                ,A.INV_TTL_AMT" ).append("\n"); 
		query.append("                                ,A.INV_ISS_DT" ).append("\n"); 
		query.append("                                ,A.INV_TTL_AMT" ).append("\n"); 
		query.append("                                ,C.CURR_CD" ).append("\n"); 
		query.append("                        ) X" ).append("\n"); 
		query.append("                     GROUP BY X.INV_NO" ).append("\n"); 
		query.append("                             ,X.TRS_INV_NO " ).append("\n"); 
		query.append("                             ,X.INV_VNDR_SEQ" ).append("\n"); 
		query.append("                             ,X.INV_CURR_CD" ).append("\n"); 
		query.append("                             ,X.INV_TTL_AMT" ).append("\n"); 
		query.append("                             ,X.INV_ISS_DT" ).append("\n"); 
		query.append("                             ,X.USD_INV_TTL_AMT" ).append("\n"); 
		query.append("                    ) Y" ).append("\n"); 
		query.append("               ) Z" ).append("\n"); 

	}
}