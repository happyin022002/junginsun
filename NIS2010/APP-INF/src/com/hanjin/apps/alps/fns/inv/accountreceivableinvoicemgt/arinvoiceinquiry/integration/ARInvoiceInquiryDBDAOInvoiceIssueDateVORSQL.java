/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : ARInvoiceInquiryDBDAOInvoiceIssueDateVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.05.25
*@LastModifier : 
*@LastVersion : 1.0
* 2018.05.25 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ARInvoiceInquiryDBDAOInvoiceIssueDateVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public ARInvoiceInquiryDBDAOInvoiceIssueDateVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("iss_fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("iss_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_src_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("iss_to_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bound",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("office",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("scope",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_type",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.integration").append("\n"); 
		query.append("FileName : ARInvoiceInquiryDBDAOInvoiceIssueDateVORSQL").append("\n"); 
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
		query.append("#if (${svr_id} == 'KOR') " ).append("\n"); 
		query.append("    SELECT A.ISS_DT," ).append("\n"); 
		query.append("           A.AR_OFC_CD," ).append("\n"); 
		query.append("           DECODE(B.IO_BND_CD, 'O', 'O/B', 'I', 'I/B') IO_BND_CD," ).append("\n"); 
		query.append("           B.BL_SRC_NO," ).append("\n"); 
		query.append("           B.VSL_CD||B.SKD_VOY_NO||B.SKD_DIR_CD VVD," ).append("\n"); 
		query.append("           A.ACT_CUST_CNT_CD ||'-'||LPAD(A.ACT_CUST_SEQ, 6, '0') CUST_CD," ).append("\n"); 
		query.append("           B.CURR_CD," ).append("\n"); 
		query.append("           B.INV_XCH_RT," ).append("\n"); 
		query.append("           A.CRE_USR_ID CRE_USR_ID1," ).append("\n"); 
		query.append("           A.INV_NO," ).append("\n"); 
		query.append("           '' AUTO_INV_ISS_FLG," ).append("\n"); 
		query.append("           '' REV_TP_CD," ).append("\n"); 
		query.append("           '' AR_IF_NO," ).append("\n"); 
		query.append("           B.SAIL_ARR_DT," ).append("\n"); 
		query.append("           B.POL_CD," ).append("\n"); 
		query.append("           B.POD_CD," ).append("\n"); 
		query.append("           SUM(B.CHG_AMT) CHG_AMT," ).append("\n"); 
		query.append("           ROUND(SUM(B.CHG_AMT)*B.INV_XCH_RT, 0) LOCAL_TOTAL," ).append("\n"); 
		query.append("           A.CRE_USR_ID CRE_USR_ID2," ).append("\n"); 
		query.append("           C.DP_PRCS_KNT DP_PRCS_KNT," ).append("\n"); 
		query.append("           0 DP_PRCS_KNT_LOCAL" ).append("\n"); 
		query.append("    FROM INV_AR_KR_ISS A," ).append("\n"); 
		query.append("         INV_AR_KR_ISS_CHG B," ).append("\n"); 
		query.append("         MDM_CURRENCY C" ).append("\n"); 
		query.append("    WHERE A.INV_NO = B.INV_NO" ).append("\n"); 
		query.append("      AND A.INV_SEQ = B.INV_SEQ" ).append("\n"); 
		query.append("      AND C.CURR_CD = B.CURR_CD" ).append("\n"); 
		query.append("    #if (${inv_no} != '')" ).append("\n"); 
		query.append("      AND A.INV_NO = @[inv_no]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${bl_src_no} != '')" ).append("\n"); 
		query.append("      AND B.BL_SRC_NO = @[bl_src_no]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if ((${iss_fm_dt} != '') && (${iss_to_dt} != ''))" ).append("\n"); 
		query.append("      AND A.ISS_DT BETWEEN REPLACE(@[iss_fm_dt],'-','') AND REPLACE(@[iss_to_dt],'-','')" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${office} != '')" ).append("\n"); 
		query.append("      AND A.AR_OFC_CD = @[office] -- OFFICE" ).append("\n"); 
		query.append("    #else " ).append("\n"); 
		query.append("      AND A.AR_OFC_CD IN ( SELECT OFC_CD -- OFC ALL 선택시 적용..  " ).append("\n"); 
		query.append("                             FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("                            WHERE AR_HD_QTR_OFC_CD = ( SELECT AR_HD_QTR_OFC_CD" ).append("\n"); 
		query.append("                                                         FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("                                                        WHERE OFC_CD = ( SELECT AR_OFC_CD" ).append("\n"); 
		query.append("                                                                           FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("                                                                          WHERE OFC_CD = @[user_ofc_cd]))" ).append("\n"); 
		query.append("                              AND OFC_CD = AR_OFC_CD )" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${cust_cnt_cd} != '')" ).append("\n"); 
		query.append("      AND A.ACT_CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${cust_seq} != '')" ).append("\n"); 
		query.append("      AND A.ACT_CUST_SEQ = @[cust_seq]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${vsl_cd} != '')" ).append("\n"); 
		query.append("      AND B.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${skd_voy_no} != '')" ).append("\n"); 
		query.append("      AND B.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${skd_dir_cd} != '')" ).append("\n"); 
		query.append("      AND B.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${bound} != 'A')" ).append("\n"); 
		query.append("      AND B.IO_BND_CD = @[bound]" ).append("\n"); 
		query.append("    #if ((${bound} == 'I') && (${port} != ''))" ).append("\n"); 
		query.append("      AND B.POD_CD = @[port]" ).append("\n"); 
		query.append("    #elseif ((${bound} == 'O') && (${port} != ''))" ).append("\n"); 
		query.append("      AND B.POL_CD = @[port]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #else" ).append("\n"); 
		query.append("    #if (${port} != '')" ).append("\n"); 
		query.append("      AND ((B.IO_BND_CD = 'I' AND B.POD_CD = @[port]) OR (B.IO_BND_CD = 'O' AND B.POL_CD = @[port]))" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${usr_id} != '')" ).append("\n"); 
		query.append("      AND A.CRE_USR_ID = @[usr_id]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("      AND A.INV_SEQ = ( SELECT MAX(INV_SEQ)" ).append("\n"); 
		query.append("                          FROM INV_AR_KR_ISS" ).append("\n"); 
		query.append("                         WHERE AR_OFC_CD = A.AR_OFC_CD" ).append("\n"); 
		query.append("                           AND INV_NO = A.INV_NO)" ).append("\n"); 
		query.append("    GROUP BY A.ISS_DT, A.AR_OFC_CD, A.INV_NO, B.BL_SRC_NO, A.AR_OFC_CD, B.IO_BND_CD, A.ACT_CUST_CNT_CD ||'-'||LPAD(A.ACT_CUST_SEQ, 6, '0'), B.CURR_CD, B.VSL_CD||B.SKD_VOY_NO||B.SKD_DIR_CD, B.SAIL_ARR_DT, B.POL_CD, B.POD_CD, B.INV_XCH_RT, A.CRE_USR_ID, C.DP_PRCS_KNT" ).append("\n"); 
		query.append("    ORDER BY A.ISS_DT, A.INV_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #if (${office} == 'BOMSC' && ${tax_inv_flg} == 'Y')" ).append("\n"); 
		query.append("        SELECT ISS_OFC_CD" ).append("\n"); 
		query.append("             , ISS_OFC_GST_NO" ).append("\n"); 
		query.append("             , BKG_NO" ).append("\n"); 
		query.append("             , SEZ_FLG" ).append("\n"); 
		query.append("             , CUST_GST_NO" ).append("\n"); 
		query.append("             , CUST_NM" ).append("\n"); 
		query.append("             , INV_NO" ).append("\n"); 
		query.append("             , ORG_INV_NO" ).append("\n"); 
		query.append("             , ISS_DT" ).append("\n"); 
		query.append("             , INV_TTL_LOCL_AMT" ).append("\n"); 
		query.append("             , ISS_OFC_STE_CD" ).append("\n"); 
		query.append("             , CUST_STE_CD" ).append("\n"); 
		query.append("             , RVS_CHG_FLG" ).append("\n"); 
		query.append("             , POR_CNT_CD" ).append("\n"); 
		query.append("             , DEL_CNT_CD" ).append("\n"); 
		query.append("             , IDA_SAC_CD" ).append("\n"); 
		query.append("             , SUM(TAXABLE_AMT) AS TAXABLE_AMT" ).append("\n"); 
		query.append("             , IDA_IGST_RTO" ).append("\n"); 
		query.append("             , IDA_CGST_RTO" ).append("\n"); 
		query.append("             , IDA_SGST_RTO" ).append("\n"); 
		query.append("             , IDA_UGST_RTO" ).append("\n"); 
		query.append("             , SUM(IDA_IGST_AMT) AS IDA_IGST_AMT" ).append("\n"); 
		query.append("             , SUM(IDA_CGST_AMT) AS IDA_CGST_AMT" ).append("\n"); 
		query.append("             , SUM(IDA_SGST_AMT) AS IDA_SGST_AMT" ).append("\n"); 
		query.append("             , SUM(IDA_UGST_AMT) AS IDA_UGST_AMT" ).append("\n"); 
		query.append("             , SUM(TTL_AMT) AS TTL_AMT" ).append("\n"); 
		query.append("        FROM (" ).append("\n"); 
		query.append("                SELECT C.IDA_ISS_OFC_CD                         AS ISS_OFC_CD" ).append("\n"); 
		query.append("                     , (SELECT Q.IDA_GST_RGST_NO" ).append("\n"); 
		query.append("                        FROM MDM_ORGANIZATION P," ).append("\n"); 
		query.append("                             MDM_CUSTOMER Q" ).append("\n"); 
		query.append("                        WHERE P.OFC_CD = C.IDA_ISS_OFC_CD" ).append("\n"); 
		query.append("                        AND P.REP_CUST_CNT_CD = Q.CUST_CNT_CD" ).append("\n"); 
		query.append("                        AND P.REP_CUST_SEQ = Q.CUST_SEQ)        AS ISS_OFC_GST_NO" ).append("\n"); 
		query.append("                     , C.BKG_NO                                 AS BKG_NO" ).append("\n"); 
		query.append("                     , NVL(C.IDA_SPCL_ECN_ZN_UT_FLG, 'N')       AS SEZ_FLG" ).append("\n"); 
		query.append("                     , C.IDA_GST_RGST_NO                        AS CUST_GST_NO" ).append("\n"); 
		query.append("                     , E.CUST_LGL_ENG_NM                        AS CUST_NM" ).append("\n"); 
		query.append("                     , C.INV_NO                                 AS INV_NO" ).append("\n"); 
		query.append("                     -- 2018.05.24 인도지역 Split Invoice Issue 기능 보완 " ).append("\n"); 
		query.append("                     , NVL((SELECT DECODE(NVL(C.IDA_ISS_TP_CD, 'P'), 'C', MAX(INV_NO), 'D', MAX(INV_NO), '')" ).append("\n"); 
		query.append("                            FROM INV_AR_MN" ).append("\n"); 
		query.append("                            WHERE AR_OFC_CD = C.AR_OFC_CD" ).append("\n"); 
		query.append("                            AND BL_SRC_NO = C.BL_SRC_NO" ).append("\n"); 
		query.append("                            AND ACT_CUST_CNT_CD = C.ACT_CUST_CNT_CD" ).append("\n"); 
		query.append("                            AND ACT_CUST_SEQ = C.ACT_CUST_SEQ" ).append("\n"); 
		query.append("                            AND NVL(IDA_ISS_TP_CD, 'P') = 'T')," ).append("\n"); 
		query.append("                           (SELECT DECODE(NVL(C.IDA_ISS_TP_CD, 'P'), 'C', MAX(INV_NO), 'D', MAX(INV_NO), '')" ).append("\n"); 
		query.append("                            FROM INV_AR_SPLIT_ISS" ).append("\n"); 
		query.append("                            WHERE AR_OFC_CD = C.AR_OFC_CD" ).append("\n"); 
		query.append("                            AND BL_SRC_NO = C.BL_SRC_NO" ).append("\n"); 
		query.append("                            AND ACT_CUST_CNT_CD = C.ACT_CUST_CNT_CD" ).append("\n"); 
		query.append("                            AND ACT_CUST_SEQ = C.ACT_CUST_SEQ" ).append("\n"); 
		query.append("                            AND NVL(IDA_ISS_TP_CD, 'P') = 'T')) AS ORG_INV_NO" ).append("\n"); 
		query.append("                     , C.ISS_DT                                 AS ISS_DT" ).append("\n"); 
		query.append("                     , (SELECT SUM(INV_TTL_LOCL_AMT)" ).append("\n"); 
		query.append("                        FROM INV_AR_MN" ).append("\n"); 
		query.append("                        WHERE AR_OFC_CD = C.AR_OFC_CD" ).append("\n"); 
		query.append("                        AND BL_SRC_NO = C.BL_SRC_NO" ).append("\n"); 
		query.append("                        AND INV_NO = C.INV_NO)                  AS INV_TTL_LOCL_AMT" ).append("\n"); 
		query.append("                     , (SELECT   R.IDA_STE_CD " ).append("\n"); 
		query.append("                        FROM     MDM_ORGANIZATION P " ).append("\n"); 
		query.append("                               , MDM_LOCATION Q " ).append("\n"); 
		query.append("                               , MDM_STATE R" ).append("\n"); 
		query.append("                        WHERE    P.LOC_CD = Q.LOC_CD " ).append("\n"); 
		query.append("                        AND      Q.CNT_CD = R.CNT_CD " ).append("\n"); 
		query.append("                        AND      Q.STE_CD = R.STE_CD " ).append("\n"); 
		query.append("                        AND      P.OFC_CD = C.IDA_ISS_OFC_CD)   AS ISS_OFC_STE_CD" ).append("\n"); 
		query.append("                     , C.IDA_STE_CD                             AS CUST_STE_CD" ).append("\n"); 
		query.append("                     , (SELECT DECODE(Q.IDA_GST_RGST_NO, '', 'Yes', 'No')" ).append("\n"); 
		query.append("                        FROM MDM_ORGANIZATION P," ).append("\n"); 
		query.append("                             MDM_CUSTOMER Q" ).append("\n"); 
		query.append("                        WHERE P.OFC_CD = C.IDA_ISS_OFC_CD" ).append("\n"); 
		query.append("                        AND P.REP_CUST_CNT_CD = Q.CUST_CNT_CD" ).append("\n"); 
		query.append("                        AND P.REP_CUST_SEQ = Q.CUST_SEQ)  		AS RVS_CHG_FLG" ).append("\n"); 
		query.append("                     , SUBSTR(C.POR_CD, 1, 2)                   AS POR_CNT_CD" ).append("\n"); 
		query.append("                     , SUBSTR(C.DEL_CD, 1, 2)                   AS DEL_CNT_CD" ).append("\n"); 
		query.append("                     , B.IDA_SAC_CD                             AS IDA_SAC_CD" ).append("\n"); 
		query.append("                     , ROUND(B.CHG_AMT * B.INV_XCH_RT, 2)       AS TAXABLE_AMT" ).append("\n"); 
		query.append("                     , TO_CHAR(B.IDA_IGST_RTO, 'FM90.0')||'%'   AS IDA_IGST_RTO" ).append("\n"); 
		query.append("                     , TO_CHAR(B.IDA_CGST_RTO, 'FM90.0')||'%'   AS IDA_CGST_RTO" ).append("\n"); 
		query.append("                     , TO_CHAR(B.IDA_SGST_RTO, 'FM90.0')||'%'   AS IDA_SGST_RTO" ).append("\n"); 
		query.append("                     , TO_CHAR(B.IDA_UGST_RTO, 'FM90.0')||'%'   AS IDA_UGST_RTO" ).append("\n"); 
		query.append("                     , B.IDA_IGST_AMT                           AS IDA_IGST_AMT" ).append("\n"); 
		query.append("                     , B.IDA_CGST_AMT                           AS IDA_CGST_AMT" ).append("\n"); 
		query.append("                     , B.IDA_SGST_AMT                           AS IDA_SGST_AMT" ).append("\n"); 
		query.append("                     , B.IDA_UGST_AMT                           AS IDA_UGST_AMT" ).append("\n"); 
		query.append("                     , ROUND(B.CHG_AMT * B.INV_XCH_RT, 2) + B.IDA_IGST_AMT + B.IDA_CGST_AMT + B.IDA_SGST_AMT + B.IDA_UGST_AMT AS TTL_AMT" ).append("\n"); 
		query.append("                FROM INV_AR_ISS_DTL A," ).append("\n"); 
		query.append("                     INV_AR_CHG B," ).append("\n"); 
		query.append("                     INV_AR_MN C," ).append("\n"); 
		query.append("                     INV_AR_ISS D," ).append("\n"); 
		query.append("                     MDM_CUSTOMER E" ).append("\n"); 
		query.append("                WHERE A.AR_IF_NO = B.AR_IF_NO" ).append("\n"); 
		query.append("                AND A.CHG_SEQ = B.CHG_SEQ" ).append("\n"); 
		query.append("                AND B.AR_IF_NO = C.AR_IF_NO" ).append("\n"); 
		query.append("                AND A.INV_NO = D.INV_NO" ).append("\n"); 
		query.append("                AND D.INV_NO = C.INV_NO" ).append("\n"); 
		query.append("                AND D.INV_SEQ = 1" ).append("\n"); 
		query.append("                AND E.CUST_CNT_CD = C.ACT_CUST_CNT_CD" ).append("\n"); 
		query.append("                AND E.CUST_SEQ = C.ACT_CUST_SEQ" ).append("\n"); 
		query.append("                AND NVL(C.INV_DELT_DIV_CD, 'N') <> 'Y'" ).append("\n"); 
		query.append("                AND NVL(C.IDA_ISS_TP_CD, 'P') <> 'P'" ).append("\n"); 
		query.append("                AND B.IDA_SAC_CD IS NOT NULL" ).append("\n"); 
		query.append("                #if (${inv_no} != '')" ).append("\n"); 
		query.append("                    AND A.INV_NO = @[inv_no]" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("                #if (${bl_src_no} != '')" ).append("\n"); 
		query.append("                    AND C.BL_SRC_NO = @[bl_src_no]" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("                #if ((${iss_fm_dt} != '') && (${iss_to_dt} != ''))" ).append("\n"); 
		query.append("                    AND D.ISS_DT BETWEEN REPLACE(@[iss_fm_dt],'-','') AND REPLACE(@[iss_to_dt],'-','')" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("                #if (${iss_ofc_cd} != '')" ).append("\n"); 
		query.append("                    AND C.IDA_ISS_OFC_CD = @[iss_ofc_cd]" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("                #if (${office} != '')" ).append("\n"); 
		query.append("                    AND C.AR_OFC_CD = @[office]" ).append("\n"); 
		query.append("					AND D.ISS_OFC_CD IN (SELECT OFC_CD" ).append("\n"); 
		query.append("                                         FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("                                         WHERE AR_OFC_CD = (SELECT AR_OFC_CD" ).append("\n"); 
		query.append("                                                            FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("                                                            WHERE OFC_CD = @[office]))" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("                #if (${cust_cnt_cd} != '')" ).append("\n"); 
		query.append("                    AND C.ACT_CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("                #if (${cust_seq} != '')" ).append("\n"); 
		query.append("                    AND C.ACT_CUST_SEQ = @[cust_seq]" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("                #if (${rev_type} != 'A')" ).append("\n"); 
		query.append("                    AND C.REV_TP_CD = @[rev_type]" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("                #if (${vsl_cd} != '')" ).append("\n"); 
		query.append("                    AND C.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("                #if (${skd_voy_no} != '')" ).append("\n"); 
		query.append("                    AND C.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("                #if (${skd_dir_cd} != '')" ).append("\n"); 
		query.append("                    AND C.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("                #if (${scope} != '')" ).append("\n"); 
		query.append("                    AND C.SVC_SCP_CD = @[scope]" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("                #if (${bound} != 'A')" ).append("\n"); 
		query.append("                    AND C.IO_BND_CD = @[bound]" ).append("\n"); 
		query.append("                    #if ((${bound} == 'I') && (${port} != ''))" ).append("\n"); 
		query.append("                        AND C.POD_CD = @[port]" ).append("\n"); 
		query.append("                    #elseif ((${bound} == 'O') && (${port} != ''))" ).append("\n"); 
		query.append("                        AND C.POL_CD = @[port]" ).append("\n"); 
		query.append("                    #end" ).append("\n"); 
		query.append("                #else" ).append("\n"); 
		query.append("                    #if (${port} != '')" ).append("\n"); 
		query.append("                        AND ((C.IO_BND_CD = 'I' AND C.POD_CD = @[port]) OR (C.IO_BND_CD = 'O' AND C.POL_CD = @[port]))" ).append("\n"); 
		query.append("                    #end" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("                #if (${usr_id} != '')" ).append("\n"); 
		query.append("                    AND D.CRE_USR_ID = @[usr_id]" ).append("\n"); 
		query.append("                #end  " ).append("\n"); 
		query.append("                " ).append("\n"); 
		query.append("                UNION ALL" ).append("\n"); 
		query.append("                " ).append("\n"); 
		query.append("                -- 2018.05.24 인도지역 Split Invoice Issue 기능 보완 " ).append("\n"); 
		query.append("                SELECT C.IDA_ISS_OFC_CD                         AS ISS_OFC_CD" ).append("\n"); 
		query.append("                     , (SELECT Q.IDA_GST_RGST_NO" ).append("\n"); 
		query.append("                        FROM MDM_ORGANIZATION P," ).append("\n"); 
		query.append("                             MDM_CUSTOMER Q" ).append("\n"); 
		query.append("                        WHERE P.OFC_CD = C.IDA_ISS_OFC_CD" ).append("\n"); 
		query.append("                        AND P.REP_CUST_CNT_CD = Q.CUST_CNT_CD" ).append("\n"); 
		query.append("                        AND P.REP_CUST_SEQ = Q.CUST_SEQ)        AS ISS_OFC_GST_NO" ).append("\n"); 
		query.append("                     , C.BKG_NO                                 AS BKG_NO" ).append("\n"); 
		query.append("                     , NVL(C.IDA_SPCL_ECN_ZN_UT_FLG, 'N')       AS SEZ_FLG" ).append("\n"); 
		query.append("                     , C.IDA_GST_RGST_NO                        AS CUST_GST_NO" ).append("\n"); 
		query.append("                     , E.CUST_LGL_ENG_NM                        AS CUST_NM" ).append("\n"); 
		query.append("                     , C.INV_NO                                 AS INV_NO" ).append("\n"); 
		query.append("                     , NVL((SELECT DECODE(NVL(C.IDA_ISS_TP_CD, 'P'), 'C', MAX(INV_NO), 'D', MAX(INV_NO), '')" ).append("\n"); 
		query.append("                            FROM INV_AR_MN" ).append("\n"); 
		query.append("                            WHERE AR_OFC_CD = C.AR_OFC_CD" ).append("\n"); 
		query.append("                            AND BL_SRC_NO = C.BL_SRC_NO" ).append("\n"); 
		query.append("                            AND ACT_CUST_CNT_CD = C.ACT_CUST_CNT_CD" ).append("\n"); 
		query.append("                            AND ACT_CUST_SEQ = C.ACT_CUST_SEQ" ).append("\n"); 
		query.append("                            AND NVL(IDA_ISS_TP_CD, 'P') = 'T')," ).append("\n"); 
		query.append("                           (SELECT DECODE(NVL(C.IDA_ISS_TP_CD, 'P'), 'C', MAX(INV_NO), 'D', MAX(INV_NO), '')" ).append("\n"); 
		query.append("                            FROM INV_AR_SPLIT_ISS" ).append("\n"); 
		query.append("                            WHERE AR_OFC_CD = C.AR_OFC_CD" ).append("\n"); 
		query.append("                            AND BL_SRC_NO = C.BL_SRC_NO" ).append("\n"); 
		query.append("                            AND ACT_CUST_CNT_CD = C.ACT_CUST_CNT_CD" ).append("\n"); 
		query.append("                            AND ACT_CUST_SEQ = C.ACT_CUST_SEQ" ).append("\n"); 
		query.append("                            AND NVL(IDA_ISS_TP_CD, 'P') = 'T')) AS ORG_INV_NO" ).append("\n"); 
		query.append("                     , C.ISS_DT                                 AS ISS_DT" ).append("\n"); 
		query.append("                     , (SELECT SUM(ROUND(CHG_AMT * INV_XCH_RT, 2) + IDA_IGST_AMT + IDA_CGST_AMT + IDA_SGST_AMT + IDA_UGST_AMT)" ).append("\n"); 
		query.append("                        FROM INV_AR_SPLIT_ISS_CHG" ).append("\n"); 
		query.append("                        WHERE INV_NO = C.INV_NO" ).append("\n"); 
		query.append("                        AND IDA_SAC_CD IS NOT NULL)             AS INV_TTL_LOCL_AMT" ).append("\n"); 
		query.append("                     , (SELECT   R.IDA_STE_CD " ).append("\n"); 
		query.append("                        FROM     MDM_ORGANIZATION P " ).append("\n"); 
		query.append("                               , MDM_LOCATION Q " ).append("\n"); 
		query.append("                               , MDM_STATE R" ).append("\n"); 
		query.append("                        WHERE    P.LOC_CD = Q.LOC_CD " ).append("\n"); 
		query.append("                        AND      Q.CNT_CD = R.CNT_CD " ).append("\n"); 
		query.append("                        AND      Q.STE_CD = R.STE_CD " ).append("\n"); 
		query.append("                        AND      P.OFC_CD = C.IDA_ISS_OFC_CD)   AS ISS_OFC_STE_CD" ).append("\n"); 
		query.append("                     , C.IDA_STE_CD                             AS CUST_STE_CD" ).append("\n"); 
		query.append("                     , (SELECT DECODE(Q.IDA_GST_RGST_NO, '', 'Yes', 'No')" ).append("\n"); 
		query.append("                        FROM MDM_ORGANIZATION P," ).append("\n"); 
		query.append("                             MDM_CUSTOMER Q" ).append("\n"); 
		query.append("                        WHERE P.OFC_CD = C.IDA_ISS_OFC_CD" ).append("\n"); 
		query.append("                        AND P.REP_CUST_CNT_CD = Q.CUST_CNT_CD" ).append("\n"); 
		query.append("                        AND P.REP_CUST_SEQ = Q.CUST_SEQ)  		AS RVS_CHG_FLG" ).append("\n"); 
		query.append("                     , SUBSTR(A.POR_CD, 1, 2)                   AS POR_CNT_CD" ).append("\n"); 
		query.append("                     , SUBSTR(A.DEL_CD, 1, 2)                   AS DEL_CNT_CD" ).append("\n"); 
		query.append("                     , B.IDA_SAC_CD                             AS IDA_SAC_CD" ).append("\n"); 
		query.append("                     , ROUND(B.CHG_AMT * B.INV_XCH_RT, 2)       AS TAXABLE_AMT" ).append("\n"); 
		query.append("                     , TO_CHAR(B.IDA_IGST_RTO, 'FM90.0')||'%'   AS IDA_IGST_RTO" ).append("\n"); 
		query.append("                     , TO_CHAR(B.IDA_CGST_RTO, 'FM90.0')||'%'   AS IDA_CGST_RTO" ).append("\n"); 
		query.append("                     , TO_CHAR(B.IDA_SGST_RTO, 'FM90.0')||'%'   AS IDA_SGST_RTO" ).append("\n"); 
		query.append("                     , TO_CHAR(B.IDA_UGST_RTO, 'FM90.0')||'%'   AS IDA_UGST_RTO" ).append("\n"); 
		query.append("                     , B.IDA_IGST_AMT                           AS IDA_IGST_AMT" ).append("\n"); 
		query.append("                     , B.IDA_CGST_AMT                           AS IDA_CGST_AMT" ).append("\n"); 
		query.append("                     , B.IDA_SGST_AMT                           AS IDA_SGST_AMT" ).append("\n"); 
		query.append("                     , B.IDA_UGST_AMT                           AS IDA_UGST_AMT" ).append("\n"); 
		query.append("                     , ROUND(B.CHG_AMT * B.INV_XCH_RT, 2) + B.IDA_IGST_AMT + B.IDA_CGST_AMT + B.IDA_SGST_AMT + B.IDA_UGST_AMT AS TTL_AMT" ).append("\n"); 
		query.append("                FROM INV_AR_MN A," ).append("\n"); 
		query.append("                     INV_AR_SPLIT_ISS_CHG B," ).append("\n"); 
		query.append("                     INV_AR_SPLIT_ISS C," ).append("\n"); 
		query.append("                     MDM_CUSTOMER E" ).append("\n"); 
		query.append("                WHERE A.AR_IF_NO = C.AR_IF_NO" ).append("\n"); 
		query.append("                AND C.INV_NO = B.INV_NO" ).append("\n"); 
		query.append("                AND C.INV_SEQ = B.INV_SEQ" ).append("\n"); 
		query.append("                AND C.INV_SEQ = 1" ).append("\n"); 
		query.append("                AND E.CUST_CNT_CD = C.ACT_CUST_CNT_CD" ).append("\n"); 
		query.append("                AND E.CUST_SEQ = C.ACT_CUST_SEQ" ).append("\n"); 
		query.append("                AND NVL(C.IDA_ISS_TP_CD, 'P') <> 'P'" ).append("\n"); 
		query.append("                AND B.IDA_SAC_CD IS NOT NULL" ).append("\n"); 
		query.append("                #if (${inv_no} != '')" ).append("\n"); 
		query.append("                    AND C.INV_NO = @[inv_no]" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("                #if (${bl_src_no} != '')" ).append("\n"); 
		query.append("                    AND C.BL_SRC_NO = @[bl_src_no]" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("                #if ((${iss_fm_dt} != '') && (${iss_to_dt} != ''))" ).append("\n"); 
		query.append("                    AND C.ISS_DT BETWEEN REPLACE(@[iss_fm_dt],'-','') AND REPLACE(@[iss_to_dt],'-','')" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("                #if (${iss_ofc_cd} != '')" ).append("\n"); 
		query.append("                    AND C.IDA_ISS_OFC_CD = @[iss_ofc_cd]" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("                #if (${office} != '')" ).append("\n"); 
		query.append("                    AND C.AR_OFC_CD = @[office]" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("                #if (${cust_cnt_cd} != '')" ).append("\n"); 
		query.append("                    AND C.ACT_CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("                #if (${cust_seq} != '')" ).append("\n"); 
		query.append("                    AND C.ACT_CUST_SEQ = @[cust_seq]" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("                /* Split issue 에서는 rev type 구분 불가능" ).append("\n"); 
		query.append("                #if (${rev_type} != 'A')" ).append("\n"); 
		query.append("                    AND C.REV_TP_CD = @[rev_type]" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("                */" ).append("\n"); 
		query.append("                #if (${vsl_cd} != '')" ).append("\n"); 
		query.append("                    AND A.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("                #if (${skd_voy_no} != '')" ).append("\n"); 
		query.append("                    AND A.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("                #if (${skd_dir_cd} != '')" ).append("\n"); 
		query.append("                    AND A.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("                #if (${scope} != '')" ).append("\n"); 
		query.append("                    AND A.SVC_SCP_CD = @[scope]" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("                #if (${bound} != 'A')" ).append("\n"); 
		query.append("                    AND A.IO_BND_CD = @[bound]" ).append("\n"); 
		query.append("                    #if ((${bound} == 'I') && (${port} != ''))" ).append("\n"); 
		query.append("                        AND A.POD_CD = @[port]" ).append("\n"); 
		query.append("                    #elseif ((${bound} == 'O') && (${port} != ''))" ).append("\n"); 
		query.append("                        AND A.POL_CD = @[port]" ).append("\n"); 
		query.append("                    #end" ).append("\n"); 
		query.append("                #else" ).append("\n"); 
		query.append("                    #if (${port} != '')" ).append("\n"); 
		query.append("                        AND ((A.IO_BND_CD = 'I' AND A.POD_CD = @[port]) OR (A.IO_BND_CD = 'O' AND A.POL_CD = @[port]))" ).append("\n"); 
		query.append("                    #end" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("                #if (${usr_id} != '')" ).append("\n"); 
		query.append("                    AND C.CRE_USR_ID = @[usr_id]" ).append("\n"); 
		query.append("                #end  " ).append("\n"); 
		query.append("             )" ).append("\n"); 
		query.append("        GROUP BY ISS_OFC_CD" ).append("\n"); 
		query.append("               , ISS_OFC_GST_NO" ).append("\n"); 
		query.append("               , BKG_NO" ).append("\n"); 
		query.append("               , SEZ_FLG" ).append("\n"); 
		query.append("               , CUST_GST_NO" ).append("\n"); 
		query.append("               , CUST_NM" ).append("\n"); 
		query.append("               , INV_NO" ).append("\n"); 
		query.append("               , ORG_INV_NO" ).append("\n"); 
		query.append("               , ISS_DT" ).append("\n"); 
		query.append("               , INV_TTL_LOCL_AMT" ).append("\n"); 
		query.append("               , ISS_OFC_STE_CD" ).append("\n"); 
		query.append("               , CUST_STE_CD" ).append("\n"); 
		query.append("               , RVS_CHG_FLG" ).append("\n"); 
		query.append("               , POR_CNT_CD" ).append("\n"); 
		query.append("               , DEL_CNT_CD" ).append("\n"); 
		query.append("               , IDA_SAC_CD" ).append("\n"); 
		query.append("               , IDA_IGST_RTO" ).append("\n"); 
		query.append("               , IDA_CGST_RTO" ).append("\n"); 
		query.append("               , IDA_SGST_RTO" ).append("\n"); 
		query.append("               , IDA_UGST_RTO" ).append("\n"); 
		query.append("        HAVING SUM(TTL_AMT) <> 0" ).append("\n"); 
		query.append("        ORDER BY INV_NO, IDA_SAC_CD " ).append("\n"); 
		query.append("    #else" ).append("\n"); 
		query.append("        SELECT ISS_DT," ).append("\n"); 
		query.append("               AR_OFC_CD," ).append("\n"); 
		query.append("               IO_BND_CD," ).append("\n"); 
		query.append("               BL_SRC_NO," ).append("\n"); 
		query.append("               VVD," ).append("\n"); 
		query.append("               CUST_CD," ).append("\n"); 
		query.append("               CURR_CD," ).append("\n"); 
		query.append("               INV_XCH_RT," ).append("\n"); 
		query.append("               CRE_USR_ID1," ).append("\n"); 
		query.append("               INV_NO," ).append("\n"); 
		query.append("               CASE WHEN (SELECT NVL(AUTO_INV_ISS_FLG,'N') FROM INV_AR_ISS WHERE INV_NO = AA.INV_NO AND ISS_DT = AA.ISS_DT  AND ROWNUM =1) ='Y' THEN 'A'  ELSE 'M'  END  AUTO_INV_ISS_FLG," ).append("\n"); 
		query.append("               REV_TP_CD," ).append("\n"); 
		query.append("               AR_IF_NO," ).append("\n"); 
		query.append("               SAIL_ARR_DT," ).append("\n"); 
		query.append("               POL_CD," ).append("\n"); 
		query.append("               POD_CD," ).append("\n"); 
		query.append("               CHG_AMT," ).append("\n"); 
		query.append("               LOCAL_TOTAL," ).append("\n"); 
		query.append("               CRE_USR_ID2," ).append("\n"); 
		query.append("               DP_PRCS_KNT," ).append("\n"); 
		query.append("               DP_PRCS_KNT_LOCAL," ).append("\n"); 
		query.append("               --2017.08.01 인도 GST 세법 변경 관련 보완" ).append("\n"); 
		query.append("               IDA_CGST_AMT," ).append("\n"); 
		query.append("               IDA_SGST_AMT," ).append("\n"); 
		query.append("               IDA_UGST_AMT," ).append("\n"); 
		query.append("               IDA_IGST_AMT" ).append("\n"); 
		query.append("         FROM(" ).append("\n"); 
		query.append("                SELECT /*+ ALL_ROWS */D.ISS_DT," ).append("\n"); 
		query.append("                               C.AR_OFC_CD," ).append("\n"); 
		query.append("                               DECODE(C.IO_BND_CD, 'I', 'I/B', 'O', 'O/B') IO_BND_CD," ).append("\n"); 
		query.append("                               C.BL_SRC_NO," ).append("\n"); 
		query.append("                               C.VSL_CD||C.SKD_VOY_NO||C.SKD_DIR_CD VVD," ).append("\n"); 
		query.append("                               C.ACT_CUST_CNT_CD||'-'||LPAD(C.ACT_CUST_SEQ, 6, '0') CUST_CD," ).append("\n"); 
		query.append("                               B.CURR_CD," ).append("\n"); 
		query.append("                               B.INV_XCH_RT," ).append("\n"); 
		query.append("                               D.CRE_USR_ID CRE_USR_ID1," ).append("\n"); 
		query.append("                               A.INV_NO," ).append("\n"); 
		query.append("                               C.REV_TP_CD||C.REV_SRC_CD REV_TP_CD," ).append("\n"); 
		query.append("                               C.AR_IF_NO," ).append("\n"); 
		query.append("                               C.SAIL_ARR_DT," ).append("\n"); 
		query.append("                               C.POL_CD," ).append("\n"); 
		query.append("                               C.POD_CD," ).append("\n"); 
		query.append("                               SUM(B.CHG_AMT) CHG_AMT," ).append("\n"); 
		query.append("                               ROUND(SUM(B.CHG_AMT)*B.INV_XCH_RT, E.DP_PRCS_KNT) LOCAL_TOTAL," ).append("\n"); 
		query.append("                               D.CRE_USR_ID CRE_USR_ID2," ).append("\n"); 
		query.append("                               F.DP_PRCS_KNT DP_PRCS_KNT," ).append("\n"); 
		query.append("                               E.DP_PRCS_KNT DP_PRCS_KNT_LOCAL," ).append("\n"); 
		query.append("                               --2017.08.01 인도 GST 세법 변경 관련 보완" ).append("\n"); 
		query.append("                               SUM(B.IDA_CGST_AMT) IDA_CGST_AMT," ).append("\n"); 
		query.append("                               SUM(B.IDA_SGST_AMT) IDA_SGST_AMT," ).append("\n"); 
		query.append("                               SUM(B.IDA_UGST_AMT) IDA_UGST_AMT," ).append("\n"); 
		query.append("                               SUM(B.IDA_IGST_AMT) IDA_IGST_AMT" ).append("\n"); 
		query.append("                          FROM INV_AR_ISS_DTL A," ).append("\n"); 
		query.append("                               INV_AR_CHG B," ).append("\n"); 
		query.append("                               INV_AR_MN C," ).append("\n"); 
		query.append("                               INV_AR_ISS D," ).append("\n"); 
		query.append("                               MDM_CURRENCY E," ).append("\n"); 
		query.append("                               MDM_CURRENCY F" ).append("\n"); 
		query.append("                         WHERE A.AR_IF_NO = B.AR_IF_NO" ).append("\n"); 
		query.append("                           AND A.CHG_SEQ = B.CHG_SEQ" ).append("\n"); 
		query.append("                           AND B.AR_IF_NO = C.AR_IF_NO" ).append("\n"); 
		query.append("                           AND A.INV_NO = D.INV_NO" ).append("\n"); 
		query.append("                           AND D.INV_SEQ = 1" ).append("\n"); 
		query.append("                           AND E.CURR_CD = C.LOCL_CURR_CD" ).append("\n"); 
		query.append("                           AND F.CURR_CD = B.CURR_CD" ).append("\n"); 
		query.append("                #if (${inv_no} != '')" ).append("\n"); 
		query.append("                           AND A.INV_NO = @[inv_no]" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("                #if (${bl_src_no} != '')" ).append("\n"); 
		query.append("                           AND C.BL_SRC_NO = @[bl_src_no]" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("                #if ((${iss_fm_dt} != '') && (${iss_to_dt} != ''))" ).append("\n"); 
		query.append("                           AND D.ISS_DT BETWEEN REPLACE(@[iss_fm_dt],'-','') AND REPLACE(@[iss_to_dt],'-','')" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("                #if (${iss_ofc_cd} != '')" ).append("\n"); 
		query.append("                           AND D.ISS_OFC_CD = @[iss_ofc_cd]" ).append("\n"); 
		query.append("                #else" ).append("\n"); 
		query.append("                #if (${office} != '')" ).append("\n"); 
		query.append("                           AND D.ISS_OFC_CD IN ( SELECT OFC_CD" ).append("\n"); 
		query.append("                                                   FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("                                                  WHERE AR_OFC_CD = ( SELECT AR_OFC_CD" ).append("\n"); 
		query.append("                                                                        FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("                                                                       WHERE OFC_CD = @[office]))" ).append("\n"); 
		query.append("                #else " ).append("\n"); 
		query.append("                           AND D.ISS_OFC_CD IN ( SELECT OFC_CD -- OFC ALL 선택시 적용..  " ).append("\n"); 
		query.append("                                                  FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("                                                 WHERE AR_HD_QTR_OFC_CD = ( SELECT AR_HD_QTR_OFC_CD" ).append("\n"); 
		query.append("                                                                              FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("                                                                             WHERE OFC_CD = ( SELECT AR_OFC_CD" ).append("\n"); 
		query.append("                                                                                                FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("                                                                                               WHERE OFC_CD = @[user_ofc_cd])))" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("                #if (${office} != '')" ).append("\n"); 
		query.append("                           AND C.AR_OFC_CD = @[office] -- OFFICE" ).append("\n"); 
		query.append("                #else " ).append("\n"); 
		query.append("                           AND C.AR_OFC_CD IN ( SELECT OFC_CD -- OFC ALL 선택시 적용..  " ).append("\n"); 
		query.append("                                                  FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("                                                 WHERE AR_HD_QTR_OFC_CD = ( SELECT AR_HD_QTR_OFC_CD" ).append("\n"); 
		query.append("                                                                              FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("                                                                             WHERE OFC_CD = ( SELECT AR_OFC_CD" ).append("\n"); 
		query.append("                                                                                                FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("                                                                                               WHERE OFC_CD = @[user_ofc_cd]))" ).append("\n"); 
		query.append("                                                   AND OFC_CD = AR_OFC_CD )" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("                           AND NVL(C.INV_DELT_DIV_CD, 'N') <> 'Y'" ).append("\n"); 
		query.append("                #if (${cust_cnt_cd} != '')" ).append("\n"); 
		query.append("                           AND C.ACT_CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("                #if (${cust_seq} != '')" ).append("\n"); 
		query.append("                           AND C.ACT_CUST_SEQ = @[cust_seq]" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("                #if (${rev_type} != 'A')" ).append("\n"); 
		query.append("                           AND C.REV_TP_CD = @[rev_type]" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("                #if (${vsl_cd} != '')" ).append("\n"); 
		query.append("                           AND C.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("                #if (${skd_voy_no} != '')" ).append("\n"); 
		query.append("                           AND C.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("                #if (${skd_dir_cd} != '')" ).append("\n"); 
		query.append("                           AND C.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("                #if (${scope} != '')" ).append("\n"); 
		query.append("                           AND C.SVC_SCP_CD = @[scope]" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("                #if (${bound} != 'A')" ).append("\n"); 
		query.append("                           AND C.IO_BND_CD = @[bound]" ).append("\n"); 
		query.append("                #if ((${bound} == 'I') && (${port} != ''))" ).append("\n"); 
		query.append("                           AND C.POD_CD = @[port]" ).append("\n"); 
		query.append("                #elseif ((${bound} == 'O') && (${port} != ''))" ).append("\n"); 
		query.append("                           AND C.POL_CD = @[port]" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("                #else" ).append("\n"); 
		query.append("                #if (${port} != '')" ).append("\n"); 
		query.append("                           AND ((C.IO_BND_CD = 'I' AND C.POD_CD = @[port]) OR (C.IO_BND_CD = 'O' AND C.POL_CD = @[port]))" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("                #if (${usr_id} != '')" ).append("\n"); 
		query.append("                           AND D.CRE_USR_ID = @[usr_id]" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("                         GROUP BY D.ISS_DT, C.AR_OFC_CD, C.VSL_CD||C.SKD_VOY_NO||C.SKD_DIR_CD, C.ACT_CUST_CNT_CD||'-'||LPAD(C.ACT_CUST_SEQ, 6, '0'), B.CURR_CD, B.INV_XCH_RT, D.CRE_USR_ID, A.INV_NO, C.SAIL_ARR_DT, C.POL_CD, C.POD_CD, B.INV_XCH_RT, D.CRE_USR_ID, F.DP_PRCS_KNT, E.DP_PRCS_KNT, C.AR_IF_NO, C.IO_BND_CD, C.REV_TP_CD||C.REV_SRC_CD, C.BL_SRC_NO	   " ).append("\n"); 
		query.append("                -- ORDER BY D.ISS_DT, A.INV_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                UNION ALL" ).append("\n"); 
		query.append("                " ).append("\n"); 
		query.append("                SELECT /*+ ALL_ROWS */" ).append("\n"); 
		query.append("                               B.ISS_DT," ).append("\n"); 
		query.append("                               B.AR_OFC_CD," ).append("\n"); 
		query.append("                               DECODE(A.IO_BND_CD, 'I', 'I/B', 'O', 'O/B') IO_BND_CD," ).append("\n"); 
		query.append("                               B.BL_SRC_NO," ).append("\n"); 
		query.append("                               A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD VVD," ).append("\n"); 
		query.append("                               B.ACT_CUST_CNT_CD||'-'||LPAD(B.ACT_CUST_SEQ, 6, '0') CUST_CD," ).append("\n"); 
		query.append("                               C.CURR_CD," ).append("\n"); 
		query.append("                               C.INV_XCH_RT," ).append("\n"); 
		query.append("                               B.CRE_USR_ID CRE_USR_ID1," ).append("\n"); 
		query.append("                               B.INV_NO," ).append("\n"); 
		query.append("                               A.REV_TP_CD||A.REV_SRC_CD REV_TP_CD," ).append("\n"); 
		query.append("                               A.AR_IF_NO," ).append("\n"); 
		query.append("                               A.SAIL_ARR_DT," ).append("\n"); 
		query.append("                               A.POL_CD," ).append("\n"); 
		query.append("                               A.POD_CD," ).append("\n"); 
		query.append("                               SUM(C.CHG_AMT) CHG_AMT," ).append("\n"); 
		query.append("                               ROUND(SUM(C.CHG_AMT)*C.INV_XCH_RT, E.DP_PRCS_KNT) LOCAL_TOTAL," ).append("\n"); 
		query.append("                               B.CRE_USR_ID CRE_USR_ID2," ).append("\n"); 
		query.append("                               F.DP_PRCS_KNT DP_PRCS_KNT," ).append("\n"); 
		query.append("                               E.DP_PRCS_KNT DP_PRCS_KNT_LOCAL," ).append("\n"); 
		query.append("                               --2017.08.01 인도 GST 세법 변경 관련 보완" ).append("\n"); 
		query.append("                               -- 2018.05.24 인도지역 Split Invoice Issue 기능 보완" ).append("\n"); 
		query.append("                               SUM(C.IDA_CGST_AMT) IDA_CGST_AMT," ).append("\n"); 
		query.append("                               SUM(C.IDA_SGST_AMT) IDA_SGST_AMT," ).append("\n"); 
		query.append("                               SUM(C.IDA_UGST_AMT) IDA_UGST_AMT," ).append("\n"); 
		query.append("                               SUM(C.IDA_IGST_AMT) IDA_IGST_AMT		   " ).append("\n"); 
		query.append("                          FROM " ).append("\n"); 
		query.append("                               INV_AR_MN A," ).append("\n"); 
		query.append("                               ( SELECT INV_NO,INV_SEQ,AR_OFC_CD,ACT_CUST_CNT_CD,ACT_CUST_SEQ,INV_RMK," ).append("\n"); 
		query.append("                                        INV_REF_NO,HJS_STF_CTNT,ISS_DT,BL_SRC_NO,BKG_NO,CRE_USR_ID,CRE_DT," ).append("\n"); 
		query.append("                                        AR_IF_NO,INV_SPLIT_ISS_WRK_NO" ).append("\n"); 
		query.append("                                 FROM   INV_AR_SPLIT_ISS" ).append("\n"); 
		query.append("                                 WHERE  ISS_DT BETWEEN REPLACE(@[iss_fm_dt],'-','') AND REPLACE(@[iss_to_dt],'-','')" ).append("\n"); 
		query.append("                                 AND    AR_OFC_CD = @[office]" ).append("\n"); 
		query.append("                                 #if (${office} != 'BOMSC')     -- 2018.05.24 인도지역 Split Invoice Issue 기능 보완" ).append("\n"); 
		query.append("                                 AND   (AR_OFC_CD, BL_SRC_NO, INV_SPLIT_ISS_WRK_NO) IN (" ).append("\n"); 
		query.append("                                                                            SELECT AR_OFC_CD, BL_SRC_NO, MAX(INV_SPLIT_ISS_WRK_NO)" ).append("\n"); 
		query.append("                                                                            FROM   INV_AR_SPLIT_ISS" ).append("\n"); 
		query.append("                                                                            WHERE  INV_SPLIT_ISS_WRK_NO IS NOT NULL" ).append("\n"); 
		query.append("                                                                            GROUP BY AR_OFC_CD, BL_SRC_NO)" ).append("\n"); 
		query.append("                                 #end" ).append("\n"); 
		query.append("                                ) B," ).append("\n"); 
		query.append("                               INV_AR_SPLIT_ISS_CHG C," ).append("\n"); 
		query.append("                               MDM_CURRENCY E," ).append("\n"); 
		query.append("                               MDM_CURRENCY F" ).append("\n"); 
		query.append("                         WHERE 1=1" ).append("\n"); 
		query.append("                           AND A.AR_IF_NO = B.AR_IF_NO" ).append("\n"); 
		query.append("                           AND B.INV_NO   = C.INV_NO" ).append("\n"); 
		query.append("                           AND B.INV_SEQ = 1" ).append("\n"); 
		query.append("                           AND E.CURR_CD = A.LOCL_CURR_CD" ).append("\n"); 
		query.append("                           AND F.CURR_CD = C.CURR_CD" ).append("\n"); 
		query.append("                #if (${inv_no} != '')" ).append("\n"); 
		query.append("                           AND B.INV_NO = @[inv_no]" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("                #if (${bl_src_no} != '')" ).append("\n"); 
		query.append("                           AND B.BL_SRC_NO = @[bl_src_no]" ).append("\n"); 
		query.append("                           #if (${office} != 'BOMSC')       -- 2018.05.24 인도지역 Split Invoice Issue 기능 보완" ).append("\n"); 
		query.append("                           AND B.INV_SPLIT_ISS_WRK_NO = (SELECT MAX(INV_SPLIT_ISS_WRK_NO) FROM INV_AR_SPLIT_ISS WHERE AR_OFC_CD = @[office] AND BL_SRC_NO = @[bl_src_no])" ).append("\n"); 
		query.append("                           #end" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("                #if ((${iss_fm_dt} != '') && (${iss_to_dt} != ''))" ).append("\n"); 
		query.append("                           AND B.ISS_DT BETWEEN REPLACE(@[iss_fm_dt],'-','') AND REPLACE(@[iss_to_dt],'-','')" ).append("\n"); 
		query.append("                           -- 한 BL로 여러번 Split 했을경우 전부조회됨." ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("                #if (${iss_ofc_cd} != '')" ).append("\n"); 
		query.append("                           AND B.AR_OFC_CD = @[iss_ofc_cd]" ).append("\n"); 
		query.append("                #else" ).append("\n"); 
		query.append("                #if (${office} != '')" ).append("\n"); 
		query.append("                           AND B.AR_OFC_CD IN ( SELECT OFC_CD" ).append("\n"); 
		query.append("                                                   FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("                                                  WHERE AR_OFC_CD = ( SELECT AR_OFC_CD" ).append("\n"); 
		query.append("                                                                        FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("                                                                       WHERE OFC_CD = @[office])) " ).append("\n"); 
		query.append("                #else " ).append("\n"); 
		query.append("                           AND B.AR_OFC_CD IN ( SELECT OFC_CD -- OFC ALL 선택시 적용..  " ).append("\n"); 
		query.append("                                                  FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("                                                 WHERE AR_HD_QTR_OFC_CD = ( SELECT AR_HD_QTR_OFC_CD" ).append("\n"); 
		query.append("                                                                              FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("                                                                             WHERE OFC_CD = ( SELECT AR_OFC_CD" ).append("\n"); 
		query.append("                                                                                                FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("                                                                                               WHERE OFC_CD = @[user_ofc_cd])))" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("                #if (${office} != '')" ).append("\n"); 
		query.append("                           AND A.AR_OFC_CD = @[office] -- OFFICE" ).append("\n"); 
		query.append("                #else " ).append("\n"); 
		query.append("                           AND A.AR_OFC_CD IN ( SELECT OFC_CD -- OFC ALL 선택시 적용..  " ).append("\n"); 
		query.append("                                                  FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("                                                 WHERE AR_HD_QTR_OFC_CD = ( SELECT AR_HD_QTR_OFC_CD" ).append("\n"); 
		query.append("                                                                              FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("                                                                             WHERE OFC_CD = ( SELECT AR_OFC_CD" ).append("\n"); 
		query.append("                                                                                                FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("                                                                                               WHERE OFC_CD = @[user_ofc_cd]))" ).append("\n"); 
		query.append("                                                   AND OFC_CD = AR_OFC_CD )" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("                           AND NVL(A.INV_DELT_DIV_CD, 'N') <> 'Y'" ).append("\n"); 
		query.append("                #if (${cust_cnt_cd} != '')" ).append("\n"); 
		query.append("                           AND B.ACT_CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("                #if (${cust_seq} != '')" ).append("\n"); 
		query.append("                           AND B.ACT_CUST_SEQ = @[cust_seq]" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("                #if (${rev_type} != 'A')" ).append("\n"); 
		query.append("                           AND A.REV_TP_CD = @[rev_type]" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("                #if (${vsl_cd} != '')" ).append("\n"); 
		query.append("                           AND A.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("                #if (${skd_voy_no} != '')" ).append("\n"); 
		query.append("                           AND A.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("                #if (${skd_dir_cd} != '')" ).append("\n"); 
		query.append("                           AND A.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("                #if (${scope} != '')" ).append("\n"); 
		query.append("                           AND A.SVC_SCP_CD = @[scope]" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("                #if (${bound} != 'A')" ).append("\n"); 
		query.append("                           AND A.IO_BND_CD = @[bound]" ).append("\n"); 
		query.append("                #if ((${bound} == 'I') && (${port} != ''))" ).append("\n"); 
		query.append("                           AND A.POD_CD = @[port]" ).append("\n"); 
		query.append("                #elseif ((${bound} == 'O') && (${port} != ''))" ).append("\n"); 
		query.append("                           AND A.POL_CD = @[port]" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("                #else" ).append("\n"); 
		query.append("                #if (${port} != '')" ).append("\n"); 
		query.append("                           AND ((A.IO_BND_CD = 'I' AND A.POD_CD = @[port]) OR (A.IO_BND_CD = 'O' AND A.POL_CD = @[port]))  " ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("                #if (${usr_id} != '')" ).append("\n"); 
		query.append("                           AND A.CRE_USR_ID = @[usr_id]" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("                         GROUP BY B.ISS_DT, B.AR_OFC_CD, A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD, B.ACT_CUST_CNT_CD||'-'||LPAD(B.ACT_CUST_SEQ, 6, '0'), C.CURR_CD, C.INV_XCH_RT, B.CRE_USR_ID, B.INV_NO, A.SAIL_ARR_DT, A.POL_CD, A.POD_CD, C.INV_XCH_RT, B.CRE_USR_ID, F.DP_PRCS_KNT, E.DP_PRCS_KNT, A.AR_IF_NO, A.IO_BND_CD, A.REV_TP_CD||A.REV_SRC_CD, B.BL_SRC_NO	   " ).append("\n"); 
		query.append("                 ORDER BY ISS_DT,INV_NO" ).append("\n"); 
		query.append("         ) AA        " ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}