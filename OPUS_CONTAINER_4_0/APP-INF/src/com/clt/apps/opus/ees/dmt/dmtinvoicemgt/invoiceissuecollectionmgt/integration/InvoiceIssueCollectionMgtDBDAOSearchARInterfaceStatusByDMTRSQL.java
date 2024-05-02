/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : InvoiceIssueCollectionMgtDBDAOSearchARInterfaceStatusByDMTRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.09.06
*@LastModifier : 
*@LastVersion : 1.0
* 2011.09.06 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceIssueCollectionMgtDBDAOSearchARInterfaceStatusByDMTRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchARInterfaceStatusByDMT
	  * </pre>
	  */
	public InvoiceIssueCollectionMgtDBDAOSearchARInterfaceStatusByDMTRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("cust_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration").append("\n"); 
		query.append("FileName : InvoiceIssueCollectionMgtDBDAOSearchARInterfaceStatusByDMTRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT " ).append("\n"); 
		query.append("#if (${ofc_tp} == 'ar_if_ofc') " ).append("\n"); 
		query.append("      I.AR_IF_OFC_CD AS OFC_CD" ).append("\n"); 
		query.append("	  ,I.AR_IF_OFC_CD || TO_CHAR(I.AR_IF_DT ,'YYYYMMDD') || I.INV_CURR_CD AS SUBTOT" ).append("\n"); 
		query.append("#elseif (${ofc_tp} == 'issue_ofc')   " ).append("\n"); 
		query.append("      I.CRE_OFC_CD   AS OFC_CD" ).append("\n"); 
		query.append("	  ,I.CRE_OFC_CD || TO_CHAR(I.AR_IF_DT ,'YYYYMMDD') || I.INV_CURR_CD AS SUBTOT" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("      ,TO_CHAR(I.AR_IF_DT ,'YYYY-MM-DD') AS AR_IF_DT" ).append("\n"); 
		query.append("      ,I.DMDT_TRF_CD" ).append("\n"); 
		query.append("      ,I.DMDT_INV_NO" ).append("\n"); 
		query.append("      ,I.BKG_NO" ).append("\n"); 
		query.append("      ,I.BL_NO" ).append("\n"); 
		query.append("      ,I.AR_IF_NO" ).append("\n"); 
		query.append("      , I.VSL_CD" ).append("\n"); 
		query.append("        || I.SKD_VOY_NO" ).append("\n"); 
		query.append("        || I.SKD_DIR_CD AS VVD" ).append("\n"); 
		query.append("      ,DECODE(SUBSTR(I.DMDT_TRF_CD, 3, 1),'I', I.POD_CD, I.POL_CD) AS PORT" ).append("\n"); 
		query.append("      ,I.AR_IF_OFC_CD" ).append("\n"); 
		query.append("	  ,(SELECT USR_NM FROM COM_USER WHERE USR_ID = I.AR_IF_USR_ID) AS AR_IF_USR_ID" ).append("\n"); 
		query.append("      ,TO_CHAR(I.CRE_DT,'YYYY-MM-DD') AS CRE_DT" ).append("\n"); 
		query.append("      ,I.CRE_OFC_CD" ).append("\n"); 
		query.append("      ,(SELECT USR_NM FROM COM_USER WHERE USR_ID = I.CRE_USR_ID) AS CRE_USR_ID" ).append("\n"); 
		query.append("      ,I.INV_CURR_CD" ).append("\n"); 
		query.append("      ,I.INV_CHG_AMT" ).append("\n"); 
		query.append("      ,I.TAX_AMT" ).append("\n"); 
		query.append("      ,I.INV_AMT" ).append("\n"); 
		query.append(" 	  , (SELECT DELT_FLG" ).append("\n"); 
		query.append("           FROM MDM_CUSTOMER" ).append("\n"); 
		query.append("          WHERE CUST_CNT_CD = DECODE (I.ACT_PAYR_CNT_CD,'00', '',I.ACT_PAYR_CNT_CD)" ).append("\n"); 
		query.append("            AND CUST_SEQ = TO_CHAR (I.ACT_PAYR_SEQ, 'FM000000')) AS PAYER_FLG" ).append("\n"); 
		query.append("      , DECODE (I.ACT_PAYR_CNT_CD,'00', '',I.ACT_PAYR_CNT_CD)" ).append("\n"); 
		query.append("        || TO_CHAR (I.ACT_PAYR_SEQ, 'FM000000') AS PAYER_CD" ).append("\n"); 
		query.append("      ,CASE" ).append("\n"); 
		query.append("           WHEN I.DMDT_TRF_CD = 'DTIC' AND INSTR (NVL (I.POD_CD, '  '), 'US') = 1  AND I.ACT_PAYR_CNT_CD = '00'" ).append("\n"); 
		query.append("              THEN (SELECT MV.VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("                      FROM MDM_VENDOR MV" ).append("\n"); 
		query.append("                     WHERE MV.VNDR_SEQ = TO_CHAR (I.ACT_PAYR_SEQ, 'FM000000'))  " ).append("\n"); 
		query.append("           WHEN I.DMDT_TRF_CD = 'DTOC' AND INSTR (NVL (I.POL_CD, '  '), 'US') = 1 AND I.ACT_PAYR_CNT_CD = '00'" ).append("\n"); 
		query.append("              THEN (SELECT MV.VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("                      FROM MDM_VENDOR MV" ).append("\n"); 
		query.append("                     WHERE MV.VNDR_SEQ = TO_CHAR (I.ACT_PAYR_SEQ, 'FM000000'))" ).append("\n"); 
		query.append("           WHEN I.DMDT_TRF_CD IN ('DMIF', 'CTIC') OR (I.DMDT_TRF_CD = 'DTIC' AND INSTR (NVL (I.POD_CD, '  '), 'US') <> 1) " ).append("\n"); 
		query.append("              THEN (SELECT MC.CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("                      FROM MDM_CUSTOMER MC" ).append("\n"); 
		query.append("                     WHERE MC.CUST_CNT_CD = DECODE (I.ACT_PAYR_CNT_CD,'00', '',I.ACT_PAYR_CNT_CD)" ).append("\n"); 
		query.append("                       AND MC.CUST_SEQ = TO_CHAR (I.ACT_PAYR_SEQ, 'FM000000'))" ).append("\n"); 
		query.append("           WHEN I.DMDT_TRF_CD IN ('DMOF', 'CTOC') OR (    I.DMDT_TRF_CD = 'DTOC' AND INSTR (NVL (I.POL_CD, '  '), 'US') <> 1)" ).append("\n"); 
		query.append("              THEN (SELECT MC.CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("                      FROM MDM_CUSTOMER MC" ).append("\n"); 
		query.append("                     WHERE MC.CUST_CNT_CD = DECODE (I.ACT_PAYR_CNT_CD,'00', '',I.ACT_PAYR_CNT_CD)" ).append("\n"); 
		query.append("                       AND MC.CUST_SEQ = TO_CHAR (I.ACT_PAYR_SEQ, 'FM000000'))" ).append("\n"); 
		query.append("           ELSE    " ).append("\n"); 
		query.append("                (SELECT MC.CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("                      FROM MDM_CUSTOMER MC" ).append("\n"); 
		query.append("                     WHERE MC.CUST_CNT_CD = DECODE (I.ACT_PAYR_CNT_CD,'00', '',I.ACT_PAYR_CNT_CD)" ).append("\n"); 
		query.append("                       AND MC.CUST_SEQ = TO_CHAR (I.ACT_PAYR_SEQ, 'FM000000'))                            " ).append("\n"); 
		query.append("        END AS PAYER_NM  " ).append("\n"); 
		query.append("      , BS.CUST_CNT_CD" ).append("\n"); 
		query.append("        || TRIM (TO_CHAR (BS.CUST_SEQ, '000000')) AS SHIPPER_CD" ).append("\n"); 
		query.append("      ,REPLACE (BS.CUST_NM" ).append("\n"); 
		query.append("               , CHR (13)" ).append("\n"); 
		query.append("                 || CHR (10)" ).append("\n"); 
		query.append("               ,' '" ).append("\n"); 
		query.append("               ) AS SHIPPER_NM" ).append("\n"); 
		query.append("      ,DECODE (BC.CUST_CNT_CD" ).append("\n"); 
		query.append("               || TRIM (TO_CHAR (BC.CUST_SEQ, '000000'))" ).append("\n"); 
		query.append("              ,'000000', NULL" ).append("\n"); 
		query.append("              , BC.CUST_CNT_CD" ).append("\n"); 
		query.append("                || TRIM (TO_CHAR (BC.CUST_SEQ, '000000'))" ).append("\n"); 
		query.append("              ) AS CONSIGNEE_CD" ).append("\n"); 
		query.append("      ,REPLACE (BC.CUST_NM" ).append("\n"); 
		query.append("               , CHR (13)" ).append("\n"); 
		query.append("                 || CHR (10)" ).append("\n"); 
		query.append("               ,' '" ).append("\n"); 
		query.append("               ) AS CONSIGNEE_NM" ).append("\n"); 
		query.append("      ,DECODE (BN.CUST_CNT_CD" ).append("\n"); 
		query.append("               || TRIM (TO_CHAR (BN.CUST_SEQ, '000000'))" ).append("\n"); 
		query.append("              ,'000000', NULL" ).append("\n"); 
		query.append("              , BN.CUST_CNT_CD" ).append("\n"); 
		query.append("                || TRIM (TO_CHAR (BN.CUST_SEQ, '000000'))" ).append("\n"); 
		query.append("              ) AS NOTIFY_CD" ).append("\n"); 
		query.append("      ,NVL (RTRIM (REPLACE (REPLACE (BN.CUST_NM" ).append("\n"); 
		query.append("                                    ,CHR(34)" ).append("\n"); 
		query.append("                                    ,''" ).append("\n"); 
		query.append("                                    )" ).append("\n"); 
		query.append("                           , CHR (13)" ).append("\n"); 
		query.append("                             || CHR (10)" ).append("\n"); 
		query.append("                           ,' '" ).append("\n"); 
		query.append("                           ))" ).append("\n"); 
		query.append("           ,'-') AS NOTIFY_NM	  " ).append("\n"); 
		query.append("  FROM DMT_INV_MN I" ).append("\n"); 
		query.append("      ,BKG_CUSTOMER BS" ).append("\n"); 
		query.append("      ,BKG_CUSTOMER BC" ).append("\n"); 
		query.append("      ,BKG_CUSTOMER BN" ).append("\n"); 
		query.append(" WHERE BS.BKG_NO(+) = I.BKG_NO" ).append("\n"); 
		query.append("   AND BS.BKG_CUST_TP_CD(+) = 'S'" ).append("\n"); 
		query.append("   AND BC.BKG_NO(+) = I.BKG_NO" ).append("\n"); 
		query.append("   AND BC.BKG_CUST_TP_CD(+) = 'C'" ).append("\n"); 
		query.append("   AND BN.BKG_NO(+) = I.BKG_NO" ).append("\n"); 
		query.append("   AND BN.BKG_CUST_TP_CD(+) = 'N'" ).append("\n"); 
		query.append("#if (${ofc_tp} == 'ar_if_ofc') " ).append("\n"); 
		query.append("   AND I.AR_IF_OFC_CD IN (" ).append("\n"); 
		query.append("        #foreach( $ofc_cd in ${ofc_cd_list} )" ).append("\n"); 
		query.append("            #if($velocityCount < $ofc_cd_list.size()) '$ofc_cd', #else '$ofc_cd' #end" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("#elseif (${ofc_tp} == 'issue_ofc')   " ).append("\n"); 
		query.append("   AND I.CRE_OFC_CD IN (" ).append("\n"); 
		query.append("        #foreach( $ofc_cd in ${ofc_cd_list} )" ).append("\n"); 
		query.append("            #if($velocityCount < $ofc_cd_list.size()) '$ofc_cd', #else '$ofc_cd' #end" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        )   " ).append("\n"); 
		query.append("#end   " ).append("\n"); 
		query.append("   " ).append("\n"); 
		query.append("#if (${dmdt_trf_cd} != '') " ).append("\n"); 
		query.append("   AND I.DMDT_TRF_CD IN (" ).append("\n"); 
		query.append("        #foreach( $trf_cd in ${trf_cd_list} )" ).append("\n"); 
		query.append("            #if($velocityCount < $trf_cd_list.size()) '$trf_cd', #else '$trf_cd' #end" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        ) " ).append("\n"); 
		query.append("#end   " ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("   AND I.AR_IF_DT BETWEEN TO_DATE (@[fm_dt], 'yyyymmdd')" ).append("\n"); 
		query.append("                      AND TO_DATE (@[to_dt], 'yyyymmdd')" ).append("\n"); 
		query.append("                          + 0.99999                       " ).append("\n"); 
		query.append("   AND I.DMDT_AR_IF_CD = 'Y'" ).append("\n"); 
		query.append("#if (${cust_cd} != '')" ).append("\n"); 
		query.append(" #if (${cust_type} == 'P')" ).append("\n"); 
		query.append("  #if (${cust_len} == '8')" ).append("\n"); 
		query.append("   AND I.ACT_PAYR_CNT_CD = SUBSTR(@[cust_cd],1,2)" ).append("\n"); 
		query.append("   AND I.ACT_PAYR_SEQ = LTRIM(SUBSTR(@[cust_cd],3),'0')" ).append("\n"); 
		query.append("  #else" ).append("\n"); 
		query.append("   AND I.ACT_PAYR_SEQ = LTRIM(SUBSTR(@[cust_cd],1,6),'0')" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append(" #elseif (${cust_type} == 'S') " ).append("\n"); 
		query.append("   AND BS.CUST_CNT_CD = SUBSTR(@[cust_cd],1,2)" ).append("\n"); 
		query.append("   AND BS.CUST_SEQ = LTRIM(SUBSTR(@[cust_cd],3),'0')" ).append("\n"); 
		query.append(" #elseif (${cust_type} == 'C') " ).append("\n"); 
		query.append("   AND BC.CUST_CNT_CD = SUBSTR(@[cust_cd],1,2)" ).append("\n"); 
		query.append("   AND BC.CUST_SEQ = LTRIM(SUBSTR(@[cust_cd],3),'0')" ).append("\n"); 
		query.append(" #elseif (${cust_type} == 'N') " ).append("\n"); 
		query.append("   AND BN.CUST_CNT_CD = SUBSTR(@[cust_cd],1,2)" ).append("\n"); 
		query.append("   AND BN.CUST_SEQ  = LTRIM(SUBSTR(@[cust_cd],3),'0')" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${ofc_tp} == 'ar_if_ofc') " ).append("\n"); 
		query.append("   ORDER BY AR_IF_OFC_CD ASC, AR_IF_DT ASC, INV_CURR_CD ASC" ).append("\n"); 
		query.append("#elseif (${ofc_tp} == 'issue_ofc')   " ).append("\n"); 
		query.append("   ORDER BY CRE_OFC_CD, AR_IF_DT , INV_CURR_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}