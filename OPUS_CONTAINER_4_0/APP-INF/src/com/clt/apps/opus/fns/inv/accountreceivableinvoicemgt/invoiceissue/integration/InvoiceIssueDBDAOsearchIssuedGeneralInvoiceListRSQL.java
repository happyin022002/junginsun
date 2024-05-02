/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : InvoiceIssueDBDAOsearchIssuedGeneralInvoiceListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.31
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.31 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.invoiceissue.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceIssueDBDAOsearchIssuedGeneralInvoiceListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * InvoiceIssueDBDAOsearchIssuedGeneralInvoiceListRSQL
	  * </pre>
	  */
	public InvoiceIssueDBDAOsearchIssuedGeneralInvoiceListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_inv",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("t_inv",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("iss_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.invoiceissue.integration").append("\n"); 
		query.append("FileName : InvoiceIssueDBDAOsearchIssuedGeneralInvoiceListRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT V1.INV_NO INV_NO" ).append("\n"); 
		query.append("     , V1.INV_SEQ INV_SEQ" ).append("\n"); 
		query.append("     , T1.VSL_CD||T1.SKD_VOY_NO||T1.SKD_DIR_CD VVD" ).append("\n"); 
		query.append("     , T1.ACT_CUST_CNT_CD||LPAD(T1.ACT_CUST_SEQ, 6, '0') CUST_CD" ).append("\n"); 
		query.append("     , DECODE(SIGN(LENGTH(T2.CUST_LGL_ENG_NM) - 40), 1, SUBSTR(T2.CUST_LGL_ENG_NM, 0, 37)||'...', T2.CUST_LGL_ENG_NM) CUST_NM" ).append("\n"); 
		query.append("     --, T2.CUST_LGL_ENG_NM CUST_NM" ).append("\n"); 
		query.append("     , T1.INV_REF_NO INV_REF_NO" ).append("\n"); 
		query.append("     , V1.AR_IF_NO AR_IF_NO" ).append("\n"); 
		query.append("     , V1.BL_SRC_NO BL_SRC_NO" ).append("\n"); 
		query.append("     , (SELECT LOCL_PO_NO FROM INV_AR_ISS WHERE INV_NO = V1.INV_NO AND INV_SEQ = V1.INV_SEQ) LOCL_PO_NO" ).append("\n"); 
		query.append("#if (${issue_gubn} == 'R') " ).append("\n"); 
		query.append("     , NVL(DECODE(T1.IO_BND_CD, 'O', NVL(T3.OB_EML,V2.INV_SND_CUST_NO) , 'I', NVL(T3.IB_EML,V2.INV_SND_CUST_NO)), '') CUST_EML" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("     , NVL(DECODE(T1.IO_BND_CD, 'O', T3.OB_EML , 'I', T3.IB_EML), '') CUST_EML" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("     , NVL(DECODE(T1.IO_BND_CD, 'O', T3.OB_FAX_NO , 'I', T3.IB_FAX_NO), '') CUST_FAX_NO" ).append("\n"); 
		query.append("     , DECODE(T1.IO_BND_CD, 'I', T1.POD_CD, 'O', T1.POL_CD) PORT_CD" ).append("\n"); 
		query.append("     , 0 F_ADD" ).append("\n"); 
		query.append("     , 1 F_DEL" ).append("\n"); 
		query.append("     , 2 F_COPY" ).append("\n"); 
		query.append("     , DECODE(T1.INV_RMK, '', ' ', 'YES') INV_RMK" ).append("\n"); 
		query.append("     , T1.INV_RMK INV_ISS_RMK" ).append("\n"); 
		query.append("     , T1.IO_BND_CD IO_BND_CD" ).append("\n"); 
		query.append("     , '' ATTACH_VIEW" ).append("\n"); 
		query.append("     , '' ATTACH_VIEW2" ).append("\n"); 
		query.append("     , V1.INV_ISS_CMB_FLG INV_ISS_CMB_FLG" ).append("\n"); 
		query.append("     , V1.ISS_GRP_TP_CD ISS_GRP_TP_CD" ).append("\n"); 
		query.append("  FROM" ).append("\n"); 
		query.append("(SELECT C.INV_NO INV_NO" ).append("\n"); 
		query.append("      --, MAX(A.AR_IF_NO) AR_IF_NO" ).append("\n"); 
		query.append("      , SUBSTR(MAX(DECODE(A.REV_TP_CD, 'M', '1', '2')||A.AR_IF_NO), 2, 11) AR_IF_NO" ).append("\n"); 
		query.append("      , A.BL_SRC_NO BL_SRC_NO" ).append("\n"); 
		query.append("      , MAX(B.INV_SEQ) INV_SEQ" ).append("\n"); 
		query.append("      , B.INV_ISS_CMB_FLG INV_ISS_CMB_FLG" ).append("\n"); 
		query.append("      , MIN(B.ISS_GRP_TP_CD) ISS_GRP_TP_CD" ).append("\n"); 
		query.append("   FROM INV_AR_MN A" ).append("\n"); 
		query.append("      , INV_AR_ISS B" ).append("\n"); 
		query.append("      , INV_AR_ISS_DTL C" ).append("\n"); 
		query.append("  WHERE 1 = 1" ).append("\n"); 
		query.append("#if (${flag} == 'S') " ).append("\n"); 
		query.append("    AND C.INV_NO IN (${invs})" ).append("\n"); 
		query.append("#elseif (${flag} == 'M') " ).append("\n"); 
		query.append("    AND C.INV_NO BETWEEN @[f_inv] AND @[t_inv]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("    AND A.AR_OFC_CD = @[iss_ofc_cd]" ).append("\n"); 
		query.append("    AND C.AR_IF_NO = A.AR_IF_NO" ).append("\n"); 
		query.append("    AND C.INV_NO = B.INV_NO" ).append("\n"); 
		query.append("    AND A.INV_NO = B.INV_NO" ).append("\n"); 
		query.append(" GROUP BY C.INV_NO" ).append("\n"); 
		query.append("        , A.BL_SRC_NO " ).append("\n"); 
		query.append("        , B.INV_ISS_CMB_FLG) V1" ).append("\n"); 
		query.append("     , INV_AR_MN T1" ).append("\n"); 
		query.append("     , MDM_CUSTOMER T2    " ).append("\n"); 
		query.append("     , MDM_CR_CUST T3" ).append("\n"); 
		query.append("     , BKG_BOOKING T4" ).append("\n"); 
		query.append("#if (${issue_gubn} == 'R') " ).append("\n"); 
		query.append(", (SELECT INV_NO" ).append("\n"); 
		query.append("     , INV_SEQ" ).append("\n"); 
		query.append("     , LTRIM(SYS_CONNECT_BY_PATH(INV_SND_CUST_NO,';'),';') INV_SND_CUST_NO" ).append("\n"); 
		query.append("  FROM ( SELECT INV_NO" ).append("\n"); 
		query.append("              , INV_SEQ" ).append("\n"); 
		query.append("              , INV_SND_CUST_NO" ).append("\n"); 
		query.append("              , ROW_NUMBER() OVER (PARTITION BY INV_NO, INV_SEQ ORDER BY INV_SND_CUST_NO) RN" ).append("\n"); 
		query.append("              , COUNT(*) OVER (PARTITION BY INV_NO, INV_SEQ) CNT" ).append("\n"); 
		query.append("           FROM INV_AR_ISS_SND " ).append("\n"); 
		query.append("          WHERE INV_NO||INV_SEQ IN (SELECT C.INV_NO||MAX(B.INV_SEQ)" ).append("\n"); 
		query.append("                                        FROM INV_AR_MN A" ).append("\n"); 
		query.append("                                        , INV_AR_ISS B" ).append("\n"); 
		query.append("                                        , INV_AR_ISS_DTL C" ).append("\n"); 
		query.append("                                        WHERE 1 = 1" ).append("\n"); 
		query.append("                                        #if (${flag} == 'S') " ).append("\n"); 
		query.append("                                        	AND C.INV_NO IN (${invs})" ).append("\n"); 
		query.append("                                        #elseif (${flag} == 'M') " ).append("\n"); 
		query.append("                                            AND C.INV_NO BETWEEN @[f_inv] AND @[t_inv]" ).append("\n"); 
		query.append("                                        #end" ).append("\n"); 
		query.append("                                        AND A.AR_OFC_CD = @[iss_ofc_cd]" ).append("\n"); 
		query.append("                                        AND C.AR_IF_NO = A.AR_IF_NO" ).append("\n"); 
		query.append("                                        AND C.INV_NO = B.INV_NO" ).append("\n"); 
		query.append("                                        AND A.INV_NO = B.INV_NO" ).append("\n"); 
		query.append("                                        GROUP BY C.INV_NO" ).append("\n"); 
		query.append("                                        , A.BL_SRC_NO )                " ).append("\n"); 
		query.append("            AND INV_ISS_SND_TP_CD = 'E'           " ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append(" WHERE LEVEL = CNT" ).append("\n"); 
		query.append(" START WITH RN = 1" ).append("\n"); 
		query.append("CONNECT BY PRIOR INV_NO = INV_NO AND INV_SEQ = INV_SEQ AND PRIOR RN = RN-1 ) V2" ).append("\n"); 
		query.append(", ( SELECT *" ).append("\n"); 
		query.append("      FROM INV_AR_ISS_SND E" ).append("\n"); 
		query.append("     WHERE INV_NO||INV_SEQ IN (SELECT C.INV_NO||MAX(B.INV_SEQ)" ).append("\n"); 
		query.append("                                        FROM INV_AR_MN A" ).append("\n"); 
		query.append("                                        , INV_AR_ISS B" ).append("\n"); 
		query.append("                                        , INV_AR_ISS_DTL C" ).append("\n"); 
		query.append("                                        WHERE 1 = 1" ).append("\n"); 
		query.append("                                        #if (${flag} == 'S') " ).append("\n"); 
		query.append("                                        	AND C.INV_NO IN (${invs})" ).append("\n"); 
		query.append("                                        #elseif (${flag} == 'M') " ).append("\n"); 
		query.append("                                            AND C.INV_NO BETWEEN @[f_inv] AND @[t_inv]" ).append("\n"); 
		query.append("                                        #end" ).append("\n"); 
		query.append("                                        AND A.AR_OFC_CD = @[iss_ofc_cd]" ).append("\n"); 
		query.append("                                        AND C.AR_IF_NO = A.AR_IF_NO" ).append("\n"); 
		query.append("                                        AND C.INV_NO = B.INV_NO" ).append("\n"); 
		query.append("                                        AND A.INV_NO = B.INV_NO" ).append("\n"); 
		query.append("                                        GROUP BY C.INV_NO" ).append("\n"); 
		query.append("                                        , A.BL_SRC_NO ) " ).append("\n"); 
		query.append("       AND INV_ISS_SND_TP_CD = 'F' ) V3" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" WHERE V1.AR_IF_NO = T1.AR_IF_NO" ).append("\n"); 
		query.append("   AND T1.ACT_CUST_CNT_CD = T2.CUST_CNT_CD" ).append("\n"); 
		query.append("   AND T1.ACT_CUST_SEQ = T2.CUST_SEQ" ).append("\n"); 
		query.append("   AND T1.ACT_CUST_CNT_CD = T3.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("   AND T1.ACT_CUST_SEQ = T3.CUST_SEQ(+)" ).append("\n"); 
		query.append("   AND T1.BL_SRC_NO = T4.BL_NO(+)" ).append("\n"); 
		query.append("#if (${issue_gubn} == 'R') " ).append("\n"); 
		query.append("   AND V1.INV_NO = V2.INV_NO(+)" ).append("\n"); 
		query.append("   AND V1.INV_SEQ = V2.INV_SEQ(+)" ).append("\n"); 
		query.append("   AND V1.INV_NO = V3.INV_NO(+)" ).append("\n"); 
		query.append("   AND V1.INV_SEQ = V3.INV_SEQ(+)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   " ).append("\n"); 
		query.append(" ORDER BY V1.INV_NO, T1.ACT_CUST_CNT_CD||LPAD(T1.ACT_CUST_SEQ, 6, '0'), T1.VSL_CD||T1.SKD_VOY_NO||T1.SKD_DIR_CD, V1.AR_IF_NO, V1.BL_SRC_NO ASC" ).append("\n"); 

	}
}