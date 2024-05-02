/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ExpenseMgtDBDAOsearchPayableInvoiceListByWODataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.10.04
*@LastModifier : 
*@LastVersion : 1.0
* 2016.10.04 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.accountmanage.expensemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ExpenseMgtDBDAOsearchPayableInvoiceListByWODataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ExpenseMgtDBDAOsearchPayableInvoiceListByWODataRSQL
	  * </pre>
	  */
	public ExpenseMgtDBDAOsearchPayableInvoiceListByWODataRSQL(){
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
		params.put("wo_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("from_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mnr.accountmanage.expensemgt.integration").append("\n"); 
		query.append("FileName : ExpenseMgtDBDAOsearchPayableInvoiceListByWODataRSQL").append("\n"); 
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
		query.append("A.MNR_ORD_OFC_CTY_CD || A.MNR_ORD_SEQ WO_NO" ).append("\n"); 
		query.append(",A.MNR_WO_TP_CD  WO_TYPE_CODE" ).append("\n"); 
		query.append(",D.MNR_CD_DESC WO_TYPE" ).append("\n"); 
		query.append(",MNR_COMMON_PKG.MNR_CONV_PARTNER_CD_FNC(A.VNDR_SEQ) VNDR_SEQ" ).append("\n"); 
		query.append(",B.VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append(",A.COST_OFC_CD" ).append("\n"); 
		query.append(",TO_CHAR(A.MNR_INP_DT , 'yyyy-mm-dd') RCV_DT" ).append("\n"); 
		query.append(",TO_CHAR(GLOBALDATE_PKG.TIME_CONV_OFC_FNC(MNR_COMMON_PKG.MNR_GET_HOOFC_FNC(), A.CRE_DT, @[user_ofc_cd]), 'yyyy-mm-dd') CRE_DT" ).append("\n"); 
		query.append(",A.MNR_WRK_AMT" ).append("\n"); 
		query.append(",0 AS SLS_TAX_AMT" ).append("\n"); 
		query.append(",A.MNR_WRK_AMT TTL_AMT" ).append("\n"); 
		query.append(",NVL(C.PAY_TERM_DYS, (SELECT GEN_PAY_TERM_CD " ).append("\n"); 
		query.append("                        FROM MDM_VENDOR " ).append("\n"); 
		query.append("                       WHERE VNDR_SEQ = A.VNDR_SEQ)) PAY_TERM_DYS" ).append("\n"); 
		query.append(",A.CURR_CD " ).append("\n"); 
		query.append(",E.DP_PRCS_KNT" ).append("\n"); 
		query.append(",(SELECT DECODE(MAX(MNR_INP_TP_CD), 'MI', '', MAX(MNR_INP_TP_CD)) " ).append("\n"); 
		query.append("   FROM MNR_ORD_DTL " ).append("\n"); 
		query.append("  WHERE MNR_ORD_OFC_CTY_CD = A.MNR_ORD_OFC_CTY_CD " ).append("\n"); 
		query.append("    AND MNR_ORD_SEQ = A.MNR_ORD_SEQ) AS MNR_INP_TP_CD" ).append("\n"); 
		query.append("FROM MNR_ORD_HDR A, MDM_VENDOR B, MNR_AGMT_HDR C, MNR_GEN_CD D, MDM_CURRENCY E" ).append("\n"); 
		query.append("WHERE A.VNDR_SEQ = B.VNDR_SEQ(+)" ).append("\n"); 
		query.append("AND A.AGMT_OFC_CTY_CD = C.AGMT_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("AND A.AGMT_SEQ = C.AGMT_SEQ(+)" ).append("\n"); 
		query.append("AND A.AGMT_VER_NO = C.AGMT_VER_NO(+) " ).append("\n"); 
		query.append("AND D.PRNT_CD_ID(+)='CD00020'" ).append("\n"); 
		query.append("AND A.MNR_WO_TP_CD = D.MNR_CD_ID(+)" ).append("\n"); 
		query.append("AND A.CURR_CD = E.CURR_CD" ).append("\n"); 
		query.append("#if (${mnr_inv_sts_cd} != 'SS') " ).append("\n"); 
		query.append("#if (${user_ofc_cd} == 'NYCBB')" ).append("\n"); 
		query.append("AND A.COST_OFC_CD IN ( SELECT M.OFC_CD" ).append("\n"); 
		query.append("                         FROM MDM_ORGANIZATION M" ).append("\n"); 
		query.append("                        WHERE SUBSTR(M.LOC_CD, 1,2) = 'US')" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND   A.COST_OFC_CD IN (" ).append("\n"); 
		query.append("                        SELECT D.OFC_CD" ).append("\n"); 
		query.append("                        FROM MNR_OFC_GEN_INFO D" ).append("\n"); 
		query.append("                        WHERE D.UPPR_OFC_CD = @[user_ofc_cd]" ).append("\n"); 
		query.append("                            AND D.MNR_GRP_TP_CD = 'OFC'" ).append("\n"); 
		query.append("                            AND D.COST_CD       = 'RPRINV'" ).append("\n"); 
		query.append("	#if (${wo_ofc_cd} != 'ALL') " ).append("\n"); 
		query.append("							AND D.OFC_CD = @[wo_ofc_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("                        UNION ALL" ).append("\n"); 
		query.append("                        SELECT @[user_ofc_cd]" ).append("\n"); 
		query.append("                        FROM DUAL" ).append("\n"); 
		query.append("                        )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND EXISTS ( SELECT 'X'" ).append("\n"); 
		query.append("             FROM MNR_ORD_DTL E             " ).append("\n"); 
		query.append("             WHERE A.MNR_ORD_OFC_CTY_CD = E.MNR_ORD_OFC_CTY_CD" ).append("\n"); 
		query.append("             AND A.MNR_ORD_SEQ          = E.MNR_ORD_SEQ" ).append("\n"); 
		query.append("             AND E.INV_NO is null" ).append("\n"); 
		query.append("			 AND E.ACCT_CD <> '511591'" ).append("\n"); 
		query.append("             AND ROWNUM = 1" ).append("\n"); 
		query.append("           )" ).append("\n"); 
		query.append("#if (${woNos} != '')" ).append("\n"); 
		query.append("	AND	A.MNR_ORD_SEQ IN (" ).append("\n"); 
		query.append("		#foreach ($user_woNos IN ${woNos})" ).append("\n"); 
		query.append("			#if($velocityCount < $woNos.size())" ).append("\n"); 
		query.append("				$user_woNos," ).append("\n"); 
		query.append("			#else" ).append("\n"); 
		query.append("				$user_woNos" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("		#end			  " ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	AND A.UPD_DT BETWEEN GLOBALDATE_PKG.TIME_CONV_OFC_FNC(@[user_ofc_cd], TO_DATE(@[from_dt], 'YYYY-MM-DD'), MNR_COMMON_PKG.MNR_GET_HOOFC_FNC()) AND GLOBALDATE_PKG.TIME_CONV_OFC_FNC(@[user_ofc_cd], TO_DATE(@[to_dt], 'YYYY-MM-DD'), MNR_COMMON_PKG.MNR_GET_HOOFC_FNC())+ 0.99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vndr_seq} != '') " ).append("\n"); 
		query.append("	AND A.VNDR_SEQ = @[vndr_seq]" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if (${mnr_inv_sts_cd} == 'SS') " ).append("\n"); 
		query.append("AND (A.MNR_ORD_OFC_CTY_CD,A.MNR_ORD_SEQ) NOT IN " ).append("\n"); 
		query.append("       (   " ).append("\n"); 
		query.append("        SELECT B.MNR_ORD_OFC_CTY_CD,B.MNR_ORD_SEQ " ).append("\n"); 
		query.append("        FROM MNR_PAY_INV_WRK A, MNR_PAY_INV_TMP B " ).append("\n"); 
		query.append("        WHERE A.PAY_INV_SEQ = B.PAY_INV_SEQ " ).append("\n"); 
		query.append("           AND A.ORD_VNDR_SEQ = TO_NUMBER(@[vndr_seq])" ).append("\n"); 
		query.append("           AND A.MNR_INV_STS_CD IN ('SS','SR','HJ')" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}