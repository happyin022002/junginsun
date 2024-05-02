/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : InvoiceIssueCollectionMgtDBDAOSearchOTSInquiryByDetailListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.09.19
*@LastModifier : 
*@LastVersion : 1.0
* 2011.09.19 
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

public class InvoiceIssueCollectionMgtDBDAOSearchOTSInquiryByDetailListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EES_DMT_4011
	  * Outstanding Inquiry by Customer N Issue - Detail(s)
	  * </pre>
	  */
	public InvoiceIssueCollectionMgtDBDAOSearchOTSInquiryByDetailListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("h_rhq_off",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frdt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cutp",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cuno",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rfan",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("todt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("arif",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scno",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("payc",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration").append("\n"); 
		query.append("FileName : InvoiceIssueCollectionMgtDBDAOSearchOTSInquiryByDetailListRSQL").append("\n"); 
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
		query.append("        M.DMDT_INV_NO                                           INVNOO ,        /*  INVOICE NO                  */" ).append("\n"); 
		query.append("        M.VSL_CD||M.SKD_VOY_NO||M.SKD_DIR_CD                    VVDCDD ,        /*  VVD                         */" ).append("\n"); 
		query.append("        M.BKG_NO                                                BKGNOO ,        /*  BKG NO                      */" ).append("\n"); 
		query.append("        M.BL_NO                                                 BLNOOO ,        /*  BL NO                       */" ).append("\n"); 
		query.append("        M.INV_CURR_CD                                           CURRCY ,        /*  INVOICE CURRENCY            */" ).append("\n"); 
		query.append("        M.INV_CHG_AMT                                           BILAMT ,        /*  INVOICE BILLING AMOUNT      */" ).append("\n"); 
		query.append("        M.TAX_AMT                                               TAXAMT ,        /*  INVOICE TAX AMOUNT          */" ).append("\n"); 
		query.append("--      M.DIM_COMM_AMT                                          COMAMT ,        /*  INVOICE COMMISSION AMOUNT   */" ).append("\n"); 
		query.append("        M.INV_AMT                                               INVAMT ,        /*  INVOICE AMOUNT              */" ).append("\n"); 
		query.append("        M.DMDT_TRF_CD                                           TARFTP ,        /*  TARIFF TYPE                 */" ).append("\n"); 
		query.append("        TO_CHAR(M.CRE_DT,'YYYY-MM-DD')                          ISSEDT ,        /*  INVOICE ISSUE DATE          */" ).append("\n"); 
		query.append("        M.CRE_OFC_CD                                            ISSEOF ,        /*  INVOICE ISSUE OFFICE        */" ).append("\n"); 
		query.append("--      M.ACT_CNT_CD||TO_CHAR(M.ACT_CUST_CD,'FM000000')         PAYRCD ,        /*  PAYER CODE                  */" ).append("\n"); 
		query.append("        TO_DATE(TO_CHAR(SYSDATE ,'YYYYMMDD'),'YYYYMMDD') -" ).append("\n"); 
		query.append("        TO_DATE(TO_CHAR(M.CRE_DT,'YYYYMMDD'),'YYYYMMDD')  		INVOVD ,         /*  INVOICE OVER DAY = SYSDATE - ISSUE DATE #ADD 2007.12.03 */" ).append("\n"); 
		query.append("        'O' SHEETP" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("        DMT_INV_MN M" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ( ${h_rhq_off} != 'SINHO' )" ).append("\n"); 
		query.append("		, MDM_ORGANIZATION MO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE   1 = 1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ( ${arif} != '' )" ).append("\n"); 
		query.append("	#if(${ar_if_cnt} > 0)" ).append("\n"); 
		query.append("	AND ( " ).append("\n"); 
		query.append("		M.DMDT_AR_IF_CD IN (" ).append("\n"); 
		query.append("	    #foreach( $dmdt_ar_if_cd_p in ${tempARIFList}) " ).append("\n"); 
		query.append("	        #if($velocityCount < $tempARIFList.size()) " ).append("\n"); 
		query.append("	           '$dmdt_ar_if_cd_p', " ).append("\n"); 
		query.append("	        #else " ).append("\n"); 
		query.append("	           '$dmdt_ar_if_cd_p' " ).append("\n"); 
		query.append("	        #end " ).append("\n"); 
		query.append("	    #end" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("		## AR/IF = L" ).append("\n"); 
		query.append("		#if (${s_ar_if_l_yn} != '')	" ).append("\n"); 
		query.append("			OR (M.DMDT_AR_IF_CD = 'H' AND M.INV_HLD_RSN_CD = 'LIT')" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("		## AR/IF = L" ).append("\n"); 
		query.append("		#if (${s_ar_if_l_yn} != '')	" ).append("\n"); 
		query.append("	AND (M.DMDT_AR_IF_CD = 'H' AND M.INV_HLD_RSN_CD = 'LIT')" ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("	AND M.DMDT_AR_IF_CD = @[arif]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ( ${h_rhq_off} != 'SINHO' )" ).append("\n"); 
		query.append("AND     M.CRE_OFC_CD = MO.OFC_CD" ).append("\n"); 
		query.append("AND     MO.AR_HD_QTR_OFC_CD = @[h_rhq_off]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND     M.CRE_DT  BETWEEN TO_DATE(REPLACE(@[frdt],'-',''),'YYYYMMDD') + .00000" ).append("\n"); 
		query.append("                      AND TO_DATE(REPLACE(@[todt],'-',''),'YYYYMMDD') + .99999   /*  INVOICE ISSUE DATE      */" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ( ${isof} != '' )" ).append("\n"); 
		query.append("AND     M.CRE_OFC_CD IN (" ).append("\n"); 
		query.append("    #foreach( $cre_ofc_cd_p in ${tempISOFList}) " ).append("\n"); 
		query.append("        #if($velocityCount < $tempISOFList.size()) " ).append("\n"); 
		query.append("           '$cre_ofc_cd_p', " ).append("\n"); 
		query.append("        #else " ).append("\n"); 
		query.append("           '$cre_ofc_cd_p' " ).append("\n"); 
		query.append("        #end " ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("--AND   M.DIM_CRE_OFC   =   NVL(OFC_CD, M.DIM_CRE_OFC)                         /*  INVOICE ISSUE OFFICE    */" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND     M.DMDT_INV_STS_CD    =   'I'                                                 /*  NOT CANCELED INVOICE    */" ).append("\n"); 
		query.append("--AND     M.ACT_PAYR_CNT_CD    =   NVL(SUBSTR( payc , 1, 2), M.ACT_PAYR_CNT_CD)          /*  PAYER CODE              */" ).append("\n"); 
		query.append("--AND     M.ACT_PAYR_SEQ   =   NVL(SUBSTR( payc , 3, 6), M.ACT_PAYR_SEQ)" ).append("\n"); 
		query.append("AND     M.ACT_PAYR_CNT_CD     =   DECODE(LENGTH(@[payc]), 8, NVL(SUBSTR(@[payc], 1, 2), M.ACT_PAYR_CNT_CD), 6, M.ACT_PAYR_CNT_CD, M.ACT_PAYR_CNT_CD)" ).append("\n"); 
		query.append("AND     M.ACT_PAYR_SEQ        =   DECODE(LENGTH(@[payc]), 8, NVL(SUBSTR(@[payc], 3, 6), M.ACT_PAYR_SEQ), 6, @[payc], M.ACT_PAYR_SEQ)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ( ${tftp} != 'A' )" ).append("\n"); 
		query.append("AND     M.DMDT_TRF_CD IN (" ).append("\n"); 
		query.append("    #foreach( $dmdt_trf_cd_p in ${tempTFTPList}) " ).append("\n"); 
		query.append("        #if($velocityCount < $tempTFTPList.size()) " ).append("\n"); 
		query.append("           '$dmdt_trf_cd_p', " ).append("\n"); 
		query.append("        #else " ).append("\n"); 
		query.append("           '$dmdt_trf_cd_p' " ).append("\n"); 
		query.append("        #end " ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("--AND   (                                                                       /*  MULTIPLE TARIFF TYPE    */" ).append("\n"); 
		query.append("--              M.DTT_CODE      =   DECODE(FLAG1, '1', 'DMIF', FLAG1)" ).append("\n"); 
		query.append("--          OR  M.DTT_CODE      =   DECODE(FLAG2, '1', 'DTIC', FLAG2)" ).append("\n"); 
		query.append("--          OR  M.DTT_CODE      =   DECODE(FLAG3, '1', 'CTIC', FLAG3)" ).append("\n"); 
		query.append("--          OR  M.DTT_CODE      =   DECODE(FLAG4, '1', 'DMOF', FLAG4)" ).append("\n"); 
		query.append("--          OR  M.DTT_CODE      =   DECODE(FLAG5, '1', 'DTOC', FLAG5)" ).append("\n"); 
		query.append("--          OR  M.DTT_CODE      =   DECODE(FLAG6, '1', 'CTOC', FLAG6)" ).append("\n"); 
		query.append("--      )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND     (                                                                       /*   SC NO                   */" ).append("\n"); 
		query.append("            M.SC_NO             =   NVL(SUBSTR(@[scno], 1, 10), M.SC_NO)" ).append("\n"); 
		query.append("            OR" ).append("\n"); 
		query.append("            NVL(M.SC_NO, ' ')   =   NVL(SUBSTR(@[scno], 1, 10), ' ')" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("AND	(	/* ---------------------------------------------------------------- RFA NO		*/" ).append("\n"); 
		query.append("		M.RFA_NO     =   NVL( SUBSTR( @[rfan], 1, 10), M.RFA_NO)" ).append("\n"); 
		query.append("		OR" ).append("\n"); 
		query.append("		NVL(M.RFA_NO, ' ') = NVL( SUBSTR( @[rfan], 1, 10), ' ')" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("#if( ${cuno} != '')" ).append("\n"); 
		query.append("AND     M.BKG_NO    IN   (" ).append("\n"); 
		query.append("                            SELECT  BKG_NO" ).append("\n"); 
		query.append("                            FROM    BKG_CUSTOMER    BC" ).append("\n"); 
		query.append("                            WHERE BC.CUST_CNT_CD = NVL(SUBSTR(@[cuno], 1, 2), BC.CUST_CNT_CD)" ).append("\n"); 
		query.append("                            AND BC.CUST_SEQ = NVL(SUBSTR(@[cuno], 3, 6), BC.CUST_SEQ)" ).append("\n"); 
		query.append("                            AND     (" ).append("\n"); 
		query.append("                                        DECODE(NVL(@[cutp],''),'','A',@[cutp]) = 'A'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if ( ${cutp} != 'A' )" ).append("\n"); 
		query.append("	OR BKG_CUST_TP_CD IN (" ).append("\n"); 
		query.append("	    #foreach( $bkg_cust_tp_cd_p in ${tempCUTPList}) " ).append("\n"); 
		query.append("	        #if($velocityCount < $tempCUTPList.size()) " ).append("\n"); 
		query.append("	           '$bkg_cust_tp_cd_p', " ).append("\n"); 
		query.append("	        #else " ).append("\n"); 
		query.append("	           '$bkg_cust_tp_cd_p' " ).append("\n"); 
		query.append("	        #end " ).append("\n"); 
		query.append("	    #end" ).append("\n"); 
		query.append("	    )" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("                                    )" ).append("\n"); 
		query.append("                         )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER   BY  M.DMDT_INV_NO" ).append("\n"); 

	}
}