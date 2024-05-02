/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : IncomeMgtDBDAOsearchReceivableInvoiceListByINVDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.07.17
*@LastModifier : 신혜정
*@LastVersion : 1.0
* 2011.01.03 박명신
* 1.0 Creation
--------------------------------------------------------
* History
* 2012.07.09 신혜정 [CHM-201218398] Invoice Cancel/Delete 시 본부/지점 담당자 처리 불가 기능 
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.accountmanage.incomemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Myoung Sin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class IncomeMgtDBDAOsearchReceivableInvoiceListByINVDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * IncomeMgtDBDAOsearchReceivableInvoiceListByINVDataRSQL
	  * </pre>
	  */
	public IncomeMgtDBDAOsearchReceivableInvoiceListByINVDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("from_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_prnr_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.accountmanage.incomemgt.integration").append("\n"); 
		query.append("FileName : IncomeMgtDBDAOsearchReceivableInvoiceListByINVDataRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("A.RCV_INV_SEQ" ).append("\n"); 
		query.append(",A.INV_NO" ).append("\n"); 
		query.append(",A.MNR_PRNR_CNT_CD" ).append("\n"); 
		query.append(",MNR_COMMON_PKG.MNR_CONV_PARTNER_CD_FNC(A.MNR_PRNR_SEQ) MNR_PRNR_SEQ" ).append("\n"); 
		query.append(", MNR_COMMON_PKG.MNR_CONV_PARTNER_CD_FNC(A.MNR_PRNR_SEQ, A.MNR_PRNR_CNT_CD) BUYER_CD" ).append("\n"); 
		query.append(",TO_CHAR(A.INV_DUE_DT , 'yyyy-mm-dd') INV_DUE_DT" ).append("\n"); 
		query.append(",TO_CHAR(A.ISS_DT , 'yyyy-mm-dd') INV_DT" ).append("\n"); 
		query.append(",A.BZC_AMT INV_AMT" ).append("\n"); 
		query.append(",A.VAT_AMT VAT" ).append("\n"); 
		query.append(",A.WHLD_TAX_AMT WHT" ).append("\n"); 
		query.append(",DECODE(A.CURR_CD,NVL(A.CHG_CURR_CD, A.CURR_CD),A.BZC_AMT + A.VAT_AMT,A.BZC_AMT) TTL_AMT" ).append("\n"); 
		query.append(",DECODE(A.CURR_CD,NVL(A.CHG_CURR_CD, A.CURR_CD),'',A.VAT_AMT) G_VAT_CURR_AMT" ).append("\n"); 
		query.append(",A.MNR_INV_RMK" ).append("\n"); 
		query.append(",A.MNR_INV_STS_CD" ).append("\n"); 
		query.append(",A.CURR_CD CURR_CD" ).append("\n"); 
		query.append(",NVL(A.CHG_CURR_CD, A.CURR_CD) CHG_CURR_CD" ).append("\n"); 
		query.append(",A.ISS_OFC_CD" ).append("\n"); 
		query.append(",A.MNR_INV_REF_NO" ).append("\n"); 
		query.append(",B.MNR_PRNR_LGL_ENG_NM" ).append("\n"); 
		query.append(",B.MNR_PRNR_TP_CD" ).append("\n"); 
		query.append(",B.MNR_PRNR_KND_CD" ).append("\n"); 
		query.append(",D.MNR_CD_DP_DESC AS MNR_PRNR_KND_NM" ).append("\n"); 
		query.append(",B.BANK_NM" ).append("\n"); 
		query.append(",B.BANK_ACCT_NO" ).append("\n"); 
		query.append(",B.MNR_BIL_TO_NM" ).append("\n"); 
		query.append(",C.MNR_CD_DESC  MNR_INV_STS_NM" ).append("\n"); 
		query.append(",E.DP_PRCS_KNT" ).append("\n"); 
		query.append(",A.VAT_XCH_RT" ).append("\n"); 
		query.append(",A.CHG_XCH_RT" ).append("\n"); 
		query.append(",Y.DP_PRCS_KNT VAT_DP_PRCS_KNT" ).append("\n"); 
		query.append("FROM MNR_RCV_INV_WRK A, MNR_PARTNER B, MNR_GEN_CD C, MNR_GEN_CD D, MDM_CURRENCY E, MDM_CURRENCY Y " ).append("\n"); 
		query.append("WHERE A.MNR_PRNR_CNT_CD = B.MNR_PRNR_CNT_CD(+)" ).append("\n"); 
		query.append("AND A.MNR_PRNR_SEQ = B.MNR_PRNR_SEQ(+)" ).append("\n"); 
		query.append("AND A.MNR_INV_STS_CD IN ('HS','HC')" ).append("\n"); 
		query.append("AND C.PRNT_CD_ID(+)='CD00027'" ).append("\n"); 
		query.append("AND A.MNR_INV_STS_CD = C.MNR_CD_ID(+)" ).append("\n"); 
		query.append("AND D.PRNT_CD_ID(+)='CD00034'" ).append("\n"); 
		query.append("AND B.MNR_PRNR_KND_CD=D.MNR_CD_ID(+)" ).append("\n"); 
		query.append("#if (${mnr_prnr_knd_cd} != '' && ${mnr_prnr_knd_cd} != 'ALL')" ).append("\n"); 
		query.append("AND A.ISS_OFC_CD = @[user_ofc_cd]" ).append("\n"); 
		query.append("AND B.MNR_PRNR_KND_CD = @[mnr_prnr_knd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND A.CURR_CD = E.CURR_CD" ).append("\n"); 
		query.append("AND NVL(A.CHG_CURR_CD, A.CURR_CD) = Y.CURR_CD" ).append("\n"); 
		query.append("#if (${from_dt} != '' && ${to_dt} != '') " ).append("\n"); 
		query.append("AND A.UPD_DT BETWEEN GLOBALDATE_PKG.TIME_CONV_OFC_FNC(@[user_ofc_cd], TO_DATE(@[from_dt], 'YYYY-MM-DD'), MNR_COMMON_PKG.MNR_GET_HOOFC_FNC()) AND GLOBALDATE_PKG.TIME_CONV_OFC_FNC(@[user_ofc_cd], TO_DATE(@[to_dt], 'YYYY-MM-DD'), MNR_COMMON_PKG.MNR_GET_HOOFC_FNC())+ 0.99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${invNos} != '')" ).append("\n"); 
		query.append("	AND	A.INV_NO IN (" ).append("\n"); 
		query.append("		#foreach ($user_invNos IN ${invNos})" ).append("\n"); 
		query.append("			#if($velocityCount < $invNos.size())" ).append("\n"); 
		query.append("				'$user_invNos'," ).append("\n"); 
		query.append("			#else" ).append("\n"); 
		query.append("				'$user_invNos'" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("		#end			  " ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND EXISTS ( SELECT 'X'" ).append("\n"); 
		query.append("             FROM MNR_DISP_DTL D            " ).append("\n"); 
		query.append("             WHERE A.RCV_INV_SEQ = D.RCV_INV_SEQ" ).append("\n"); 
		query.append("#if (${vndr_seq} != '') " ).append("\n"); 
		query.append("				AND D.MNR_PRNR_CNT_CD = SUBSTR(@[vndr_seq],1,2)" ).append("\n"); 
		query.append("				AND D.MNR_PRNR_SEQ = TO_NUMBER(SUBSTR(@[vndr_seq],3))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("             AND ROWNUM = 1" ).append("\n"); 
		query.append("           )" ).append("\n"); 
		query.append("ORDER BY A.RCV_INV_SEQ DESC" ).append("\n"); 

	}
}