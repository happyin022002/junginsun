/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ARInvoiceInquiryDBDAOCPRTMain2VOCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.02
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.02 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ARInvoiceInquiryDBDAOCPRTMain2VOCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CPRTMain2VO
	  * </pre>
	  */
	public ARInvoiceInquiryDBDAOCPRTMain2VOCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ob_sls_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("from_date",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rpt_tmplt_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("por_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sc_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_date",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_rpt_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rfa_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.integration").append("\n"); 
		query.append("FileName : ARInvoiceInquiryDBDAOCPRTMain2VOCSQL").append("\n"); 
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
		query.append("INSERT INTO INV_CPRT_HIS (" ).append("\n"); 
		query.append("             CUST_RPT_ID" ).append("\n"); 
		query.append("            ,RPT_TMPLT_NM" ).append("\n"); 
		query.append("            ,BL_SRC_NO" ).append("\n"); 
		query.append("            ,POR_CD" ).append("\n"); 
		query.append("            ,POL_CD" ).append("\n"); 
		query.append("            ,POD_CD" ).append("\n"); 
		query.append("            ,DEL_CD" ).append("\n"); 
		query.append("            ,TRNK_VSL_CD" ).append("\n"); 
		query.append("            ,TRNK_SKD_VOY_NO" ).append("\n"); 
		query.append("            ,TRNK_SKD_DIR_CD" ).append("\n"); 
		query.append("            ,SC_NO" ).append("\n"); 
		query.append("            ,RFA_NO" ).append("\n"); 
		query.append("            ,PPD_USD_TTL_AMT" ).append("\n"); 
		query.append("            ,CLT_USD_TTL_AMT" ).append("\n"); 
		query.append("            ,N3RD_PAYR_USD_TTL_AMT" ).append("\n"); 
		query.append("            ,AR_OFC_CD" ).append("\n"); 
		query.append("            ,CRE_USR_ID" ).append("\n"); 
		query.append("            ,CRE_DT" ).append("\n"); 
		query.append("            ,UPD_USR_ID" ).append("\n"); 
		query.append("            ,UPD_DT" ).append("\n"); 
		query.append(")  " ).append("\n"); 
		query.append("SELECT   @[cust_rpt_id] CUST_RPT_ID" ).append("\n"); 
		query.append("        ,@[rpt_tmplt_nm] RPT_TMPLT_NM" ).append("\n"); 
		query.append("        ,MN.BL_NO     " ).append("\n"); 
		query.append("        ,MN.POR_CD      " ).append("\n"); 
		query.append("        ,MN.POL_CD       " ).append("\n"); 
		query.append("        ,MN.POD_CD      " ).append("\n"); 
		query.append("        ,MN.DEL_CD      " ).append("\n"); 
		query.append("        ,SUBSTR(MN.T_VVD, 0,4)  " ).append("\n"); 
		query.append("        ,SUBSTR(MN.T_VVD, 5,4)  " ).append("\n"); 
		query.append("        ,SUBSTR(MN.T_VVD, 9,1) " ).append("\n"); 
		query.append("        ,NVL(MN.SC_NO,'X')    " ).append("\n"); 
		query.append("        ,NVL(MN.RFA_NO,'X')   " ).append("\n"); 
		query.append("        ,TOT_PPD_HIS" ).append("\n"); 
		query.append("        ,TOT_CCT_HIS" ).append("\n"); 
		query.append("        ,TOT_PPD_N3PTY" ).append("\n"); 
		query.append("        ,@[ar_ofc_cd] AR_OFC_CD" ).append("\n"); 
		query.append("        ,@[usr_id] CRE_USR_ID" ).append("\n"); 
		query.append("        ,SYSDATE" ).append("\n"); 
		query.append("        ,@[usr_id] UPD_USR_ID" ).append("\n"); 
		query.append("        ,SYSDATE" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT   A.BL_NO     " ).append("\n"); 
		query.append("        ,A.RFA_NO     " ).append("\n"); 
		query.append("        ,A.SC_NO       " ).append("\n"); 
		query.append("        ,(SELECT SUBSTR(L3.CUST_GRP_ID,3,2)||SUBSTR(L3.CUST_GRP_ID,5,6)           " ).append("\n"); 
		query.append("          FROM  MDM_CUSTOMER L3, BKG_CUSTOMER C9                     " ).append("\n"); 
		query.append("          WHERE C9.BKG_NO = A.BKG_NO  " ).append("\n"); 
		query.append("          AND C9.CUST_CNT_CD = L3.CUST_CNT_CD " ).append("\n"); 
		query.append("          AND C9.CUST_SEQ = L3.CUST_SEQ          " ).append("\n"); 
		query.append("          AND C9.BKG_CUST_TP_CD = 'S' ) as SH_GROUP_CUST    " ).append("\n"); 
		query.append("        ,(SELECT SUBSTR(L1.CUST_GRP_ID,3,2)||SUBSTR(L1.CUST_GRP_ID,5,6)" ).append("\n"); 
		query.append("          FROM  MDM_CUSTOMER L1, BKG_CUSTOMER C3" ).append("\n"); 
		query.append("          WHERE C3.BKG_NO = A.BKG_NO " ).append("\n"); 
		query.append("          AND   C3.CUST_CNT_CD = L1.CUST_CNT_CD " ).append("\n"); 
		query.append("          AND   C3.CUST_SEQ    = L1.CUST_SEQ" ).append("\n"); 
		query.append("          AND   C3.BKG_CUST_TP_CD = 'C'  AND C3.BKG_NO=A.BKG_NO )  as CN_GROUP_CUST" ).append("\n"); 
		query.append("        ,A.POR_CD       " ).append("\n"); 
		query.append("        ,A.POL_CD      " ).append("\n"); 
		query.append("        ,A.POD_CD      " ).append("\n"); 
		query.append("        ,A.DEL_CD     " ).append("\n"); 
		query.append("        ,(SELECT K3.VSL_CD||K3.SKD_VOY_NO||K3.SKD_DIR_CD" ).append("\n"); 
		query.append("          FROM BKG_VVD K3" ).append("\n"); 
		query.append("          WHERE K3.BKG_NO = A.BKG_NO AND K3.VSL_PRE_PST_CD ='T' ) as T_VVD   --INV043" ).append("\n"); 
		query.append("       ,(SELECT TO_CHAR(KK.VPS_ETD_DT,'YYYYMMDD') as ETD " ).append("\n"); 
		query.append("         FROM VSK_VSL_PORT_SKD KK, BKG_VVD BB" ).append("\n"); 
		query.append("         WHERE   KK.VSL_CD = BB.VSL_CD" ).append("\n"); 
		query.append("         AND     KK.SKD_VOY_NO = BB.SKD_VOY_NO" ).append("\n"); 
		query.append("         AND     KK.SKD_DIR_CD = BB.SKD_DIR_CD" ).append("\n"); 
		query.append("         AND     KK.VPS_PORT_CD = BB.POL_CD" ).append("\n"); 
		query.append("         AND     BB.VSL_PRE_PST_CD='T'" ).append("\n"); 
		query.append("         AND     BB.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("         AND     KK.CLPT_IND_SEQ = (SELECT MAX(CLPT_IND_SEQ) FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("                                     WHERE   VSL_CD = KK.VSL_CD" ).append("\n"); 
		query.append("                                     AND     SKD_VOY_NO = KK.SKD_VOY_NO" ).append("\n"); 
		query.append("                                     AND     SKD_DIR_CD = KK.SKD_DIR_CD" ).append("\n"); 
		query.append("                                     AND     VPS_PORT_CD = KK.VPS_PORT_CD)" ).append("\n"); 
		query.append("          ) as T_POL_ETD   " ).append("\n"); 
		query.append("        ,(SELECT TO_CHAR(KK1.VPS_ETA_DT,'YYYYMMDD') as ETA" ).append("\n"); 
		query.append("          FROM VSK_VSL_PORT_SKD KK1, BKG_VVD BB1" ).append("\n"); 
		query.append("          WHERE   KK1.VSL_CD     = BB1.VSL_CD" ).append("\n"); 
		query.append("          AND     KK1.SKD_VOY_NO = BB1.SKD_VOY_NO" ).append("\n"); 
		query.append("          AND     KK1.SKD_DIR_CD = BB1.SKD_DIR_CD" ).append("\n"); 
		query.append("          AND     KK1.VPS_PORT_CD = BB1.POD_CD" ).append("\n"); 
		query.append("          AND     BB1.VSL_PRE_PST_CD='T'" ).append("\n"); 
		query.append("          AND     BB1.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("          AND     KK1.CLPT_IND_SEQ = (SELECT MAX(CLPT_IND_SEQ) FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("                                      WHERE   VSL_CD = KK1.VSL_CD" ).append("\n"); 
		query.append("                                      AND     SKD_VOY_NO = KK1.SKD_VOY_NO" ).append("\n"); 
		query.append("                                      AND     SKD_DIR_CD = KK1.SKD_DIR_CD" ).append("\n"); 
		query.append("                                      AND     VPS_PORT_CD = KK1.VPS_PORT_CD)" ).append("\n"); 
		query.append("          ) as T_POD_ETA  " ).append("\n"); 
		query.append("		,(SELECT TO_CHAR(KK2.VPS_ETD_DT,'YYYYMMDD')" ).append("\n"); 
		query.append("          FROM VSK_VSL_PORT_SKD KK2, BKG_VVD BB2" ).append("\n"); 
		query.append("          WHERE   BB2.BKG_NO(+)      = A.BKG_NO" ).append("\n"); 
		query.append("          AND     BB2.VSL_CD     = KK2.VSL_CD" ).append("\n"); 
		query.append("          AND     BB2.SKD_VOY_NO = KK2.SKD_VOY_NO" ).append("\n"); 
		query.append("          AND     BB2.SKD_DIR_CD = KK2.SKD_DIR_CD" ).append("\n"); 
		query.append("          AND     BB2.POL_CD           = KK2.VPS_PORT_CD" ).append("\n"); 
		query.append("          AND     BB2.POL_YD_CD        = KK2.YD_CD" ).append("\n"); 
		query.append("          AND     BB2.POL_CLPT_IND_SEQ = KK2.CLPT_IND_SEQ" ).append("\n"); 
		query.append("          AND     BB2.ROWID            =" ).append("\n"); 
		query.append("                (" ).append("\n"); 
		query.append("                SELECT  SUBSTR(MIN( S.VSL_PRE_PST_CD || LTRIM( TO_CHAR( S.VSL_SEQ , '000') )  || ROWID ), 5) -- 1st VVD" ).append("\n"); 
		query.append("                FROM    BKG_VVD S" ).append("\n"); 
		query.append("                WHERE   1=1" ).append("\n"); 
		query.append("                AND     S.BKG_NO    = BB2.BKG_NO" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("          AND		NVL(KK2.SKD_CNG_STS_CD, ' ') <> 'S') AS FIRST_VVD_ETD       " ).append("\n"); 
		query.append("        ,(SELECT SUM(Round(R1.CHG_AMT*(GL2.USD_LOCL_XCH_RT/GL1.USD_LOCL_XCH_RT),2))" ).append("\n"); 
		query.append("          FROM BKG_CHG_RT R1, GL_MON_XCH_RT GL1, GL_MON_XCH_RT GL2" ).append("\n"); 
		query.append("          WHERE R1.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("          AND R1.FRT_TERM_CD='C'" ).append("\n"); 
		query.append("          AND R1.FRT_INCL_XCLD_DIV_CD ='N'" ).append("\n"); 
		query.append("          AND GL1.ACCT_XCH_RT_YRMON =  SUBSTR(TO_CHAR(R1.CRE_DT,'YYYYMMDD'),1,6)" ).append("\n"); 
		query.append("          AND GL1.ACCT_XCH_RT_LVL = '1'" ).append("\n"); 
		query.append("          AND R1.N3PTY_CUST_CNT_CD IS NULL" ).append("\n"); 
		query.append("          AND GL1.CURR_CD = R1.CURR_CD" ).append("\n"); 
		query.append("          AND GL2.ACCT_XCH_RT_YRMON =  SUBSTR(TO_CHAR(R1.CRE_DT,'YYYYMMDD'),1,6)" ).append("\n"); 
		query.append("          AND GL2.ACCT_XCH_RT_LVL = '1'" ).append("\n"); 
		query.append("          AND GL2.CURR_CD = (SELECT O2.ar_curr_cd" ).append("\n"); 
		query.append("                             FROM mdm_organization O1, mdm_organization O2" ).append("\n"); 
		query.append("                             WHERE O1.ofc_cd = F.CLT_OFC_CD" ).append("\n"); 
		query.append("                             AND  O2.ofc_cd = O1.ar_ofc_cd)   ) as TOT_CCT_HIS --INV099_HIS" ).append("\n"); 
		query.append("        ,(SELECT SUM(Round(R2.CHG_AMT*(GL4.USD_LOCL_XCH_RT/GL3.USD_LOCL_XCH_RT),2))" ).append("\n"); 
		query.append("          FROM BKG_CHG_RT R2, GL_MON_XCH_RT GL3, GL_MON_XCH_RT GL4" ).append("\n"); 
		query.append("          WHERE R2.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("          AND R2.FRT_TERM_CD='P'" ).append("\n"); 
		query.append("          AND R2.FRT_INCL_XCLD_DIV_CD ='N'" ).append("\n"); 
		query.append("          AND GL3.ACCT_XCH_RT_YRMON =  SUBSTR(TO_CHAR(R2.CRE_DT,'YYYYMMDD'),1,6)" ).append("\n"); 
		query.append("          AND GL3.ACCT_XCH_RT_LVL = '1'" ).append("\n"); 
		query.append("          AND R2.N3PTY_CUST_CNT_CD IS NULL" ).append("\n"); 
		query.append("          AND GL3.CURR_CD = R2.CURR_CD" ).append("\n"); 
		query.append("          AND GL4.ACCT_XCH_RT_YRMON =  SUBSTR(TO_CHAR(R2.CRE_DT,'YYYYMMDD'),1,6)" ).append("\n"); 
		query.append("          AND GL4.ACCT_XCH_RT_LVL = '1'" ).append("\n"); 
		query.append("          AND GL4.CURR_CD =  (SELECT O2.ar_curr_cd" ).append("\n"); 
		query.append("                              FROM mdm_organization O1, mdm_organization O2" ).append("\n"); 
		query.append("                              WHERE O1.ofc_cd = F.PPD_RCV_OFC_CD" ).append("\n"); 
		query.append("                              AND   O2.ofc_cd = O1.ar_ofc_cd)   ) as TOT_PPD_HIS --INV112_HIS" ).append("\n"); 
		query.append("        ,(SELECT SUM(Round(R3.CHG_AMT*(GL6.USD_LOCL_XCH_RT/GL5.USD_LOCL_XCH_RT),2))" ).append("\n"); 
		query.append("          FROM BKG_CHG_RT R3, GL_MON_XCH_RT GL5, GL_MON_XCH_RT GL6" ).append("\n"); 
		query.append("          WHERE R3.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("          AND GL5.ACCT_XCH_RT_YRMON =  SUBSTR(TO_CHAR(R3.CRE_DT,'YYYYMMDD'),1,6)" ).append("\n"); 
		query.append("          AND GL5.ACCT_XCH_RT_LVL = '1'" ).append("\n"); 
		query.append("          AND R3.N3PTY_CUST_CNT_CD IS NOT NULL" ).append("\n"); 
		query.append("          AND R3.FRT_INCL_XCLD_DIV_CD ='N'" ).append("\n"); 
		query.append("          AND GL5.CURR_CD = R3.CURR_CD" ).append("\n"); 
		query.append("          AND GL6.ACCT_XCH_RT_YRMON =  SUBSTR(TO_CHAR(R3.CRE_DT,'YYYYMMDD'),1,6)" ).append("\n"); 
		query.append("          AND GL6.ACCT_XCH_RT_LVL = '1'" ).append("\n"); 
		query.append("          AND GL6.CURR_CD =  (SELECT O2.ar_curr_cd" ).append("\n"); 
		query.append("                              FROM mdm_organization O1, mdm_organization O2" ).append("\n"); 
		query.append("                              WHERE O1.ofc_cd = R3.N3PTY_RCV_OFC_CD" ).append("\n"); 
		query.append("                              AND   O2.ofc_cd = O1.ar_ofc_cd)   ) as TOT_PPD_N3PTY --N3PTY_HIS" ).append("\n"); 
		query.append("FROM   BKG_BOOKING A" ).append("\n"); 
		query.append("      ,BKG_BL_DOC B" ).append("\n"); 
		query.append("      ,BKG_RATE F" ).append("\n"); 
		query.append("	#if (${cust_gb} == 'S' || ${cust_gb} == 'C' || ${cust_gb} == 'N' || ${cust_gb} == 'F')" ).append("\n"); 
		query.append("		#if (${cust_cd} != '')" ).append("\n"); 
		query.append("  	   ,BKG_CUSTOMER G   -- customer 조건 있는 경우 만 조인 CONSIGNEE, shiiper, NOTIFY" ).append("\n"); 
		query.append("  		#end" ).append("\n"); 
		query.append("  	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE  1=1" ).append("\n"); 
		query.append("AND  A.BKG_NO = B.BKG_NO(+)" ).append("\n"); 
		query.append("AND  A.BKG_NO = F.BKG_NO(+)" ).append("\n"); 
		query.append("AND  A.BKG_STS_CD IN ('F','S')" ).append("\n"); 
		query.append("AND  A.BKG_CGO_TP_CD <> 'P'" ).append("\n"); 
		query.append("#if ((${from_date} != '' && ${to_date} != '' && (${date_gb} == 'IVD' || ${date_gb} == 'IFD')) ||" ).append("\n"); 
		query.append("     (${cust_cd} != '' && ${cust_gb} == 'P'))" ).append("\n"); 
		query.append("        AND EXISTS (SELECT 'X'" ).append("\n"); 
		query.append("                    FROM INV_AR_MN" ).append("\n"); 
		query.append("                    WHERE BL_SRC_NO = A.BL_NO" ).append("\n"); 
		query.append("        			AND REV_TP_CD <> 'M'" ).append("\n"); 
		query.append("          			AND BL_INV_CFM_DT IS NOT NULL" ).append("\n"); 
		query.append("          			AND INV_DELT_DIV_CD <> 'Y'" ).append("\n"); 
		query.append("                    #if (${from_date} != '' && ${to_date} != '')	" ).append("\n"); 
		query.append("                        #if (${date_gb} == 'IVD')" ).append("\n"); 
		query.append("                            AND TO_DATE(ISS_DT,'YYYYMMDD') BETWEEN TO_DATE(REPLACE(@[from_date],'-',''),'YYYYMMDD') AND TO_DATE(REPLACE(@[to_date],'-',''),'YYYYMMDD')+0.99999             " ).append("\n"); 
		query.append("                        #end " ).append("\n"); 
		query.append("                        #if (${date_gb} == 'IFD')              " ).append("\n"); 
		query.append("                            AND TO_DATE(BL_INV_IF_DT,'YYYYMMDD') BETWEEN TO_DATE(REPLACE(@[from_date],'-',''),'YYYYMMDD') AND TO_DATE(REPLACE(@[to_date],'-',''),'YYYYMMDD')+0.99999              " ).append("\n"); 
		query.append("                        #end " ).append("\n"); 
		query.append("                    #end  " ).append("\n"); 
		query.append("                    #if (${cust_cd} != '') " ).append("\n"); 
		query.append("                        #if (${cust_gb} == 'P')" ).append("\n"); 
		query.append("                            AND ACT_CUST_CNT_CD||ACT_CUST_SEQ IN (@[cust_cd])" ).append("\n"); 
		query.append("                        #end " ).append("\n"); 
		query.append("                    #end       " ).append("\n"); 
		query.append("                   )     " ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if (${bl_nos} != '')" ).append("\n"); 
		query.append("AND  A.BL_NO in (${bl_nos})" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${sc_no} != '')" ).append("\n"); 
		query.append("AND		A.SC_NO = @[sc_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rfa_no} != '')" ).append("\n"); 
		query.append("AND		A.RFA_NO = @[rfa_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bkg_ofc_cd} != '')" ).append("\n"); 
		query.append("AND		A.BKG_OFC_CD = @[bkg_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ob_sls_ofc_cd} != '')" ).append("\n"); 
		query.append("AND		A.OB_SLS_OFC_CD = @[ob_sls_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cust_gb} == 'S')" ).append("\n"); 
		query.append("	#if (${cust_cd} != '')" ).append("\n"); 
		query.append("		  AND A.BKG_NO = G.BKG_NO(+)" ).append("\n"); 
		query.append("		  AND G.BKG_CUST_TP_CD='S'" ).append("\n"); 
		query.append("		  AND G.Cust_Cnt_Cd||G.Cust_Seq IN (@[cust_cd])" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cust_gb} == 'C')" ).append("\n"); 
		query.append("	#if (${cust_cd} != '')" ).append("\n"); 
		query.append("		  AND A.BKG_NO = G.BKG_NO(+)" ).append("\n"); 
		query.append("		  AND G.BKG_CUST_TP_CD='C'" ).append("\n"); 
		query.append("		  AND G.Cust_Cnt_Cd||G.Cust_Seq IN (@[cust_cd])" ).append("\n"); 
		query.append("  	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cust_gb} == 'N')" ).append("\n"); 
		query.append("	#if (${cust_cd} != '')" ).append("\n"); 
		query.append("		  AND A.BKG_NO = G.BKG_NO(+)" ).append("\n"); 
		query.append("		  AND G.BKG_CUST_TP_CD='N'" ).append("\n"); 
		query.append("		  AND G.Cust_Cnt_Cd||G.Cust_Seq IN (@[cust_cd])" ).append("\n"); 
		query.append("  	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cust_gb} == 'F')" ).append("\n"); 
		query.append("	#if (${cust_cd} != '')" ).append("\n"); 
		query.append("		  AND A.BKG_NO = G.BKG_NO(+)" ).append("\n"); 
		query.append("		  AND G.BKG_CUST_TP_CD='F'" ).append("\n"); 
		query.append("		  AND G.Cust_Cnt_Cd||G.Cust_Seq IN (@[cust_cd])" ).append("\n"); 
		query.append("  	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${del_cd} != '')" ).append("\n"); 
		query.append("AND  A.DEL_CD like @[del_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${por_cd} != '')" ).append("\n"); 
		query.append(" AND  A.POR_CD like @[por_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pol_cd} != '')" ).append("\n"); 
		query.append(" AND  A.POL_CD like @[pol_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pod_cd} != '')" ).append("\n"); 
		query.append(" AND  A.POD_CD like @[pod_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${date_gb} == 'OBD')" ).append("\n"); 
		query.append("	#if (${from_date} != '' && ${to_date} != '')" ).append("\n"); 
		query.append("AND B.BL_OBRD_DT between to_date(REPLACE(@[from_date],'-',''),'YYYYMMDD') and to_date(REPLACE(@[to_date],'-',''),'YYYYMMDD')+0.99999" ).append("\n"); 
		query.append("	#end " ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if (${date_gb} == 'PCD')" ).append("\n"); 
		query.append("	#if (${from_date} != '' && ${to_date} != '')	" ).append("\n"); 
		query.append("AND A.PORT_CLZ_DT  between to_date(REPLACE(@[from_date],'-',''),'YYYYMMDD') and to_date(REPLACE(@[to_date],'-',''),'YYYYMMDD')+0.99999" ).append("\n"); 
		query.append("	#end " ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if (${date_gb} == 'BDR')" ).append("\n"); 
		query.append("	#if (${from_date} != '' && ${to_date} != '')" ).append("\n"); 
		query.append("AND B.BDR_DT  between to_date(REPLACE(@[from_date],'-',''),'YYYYMMDD') and to_date(REPLACE(@[to_date],'-',''),'YYYYMMDD')+0.99999" ).append("\n"); 
		query.append("	#end " ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append(") MN" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if (${cust_gb} == 'GS')" ).append("\n"); 
		query.append("	#if (${cust_cd} != '')" ).append("\n"); 
		query.append("AND MN.SH_GROUP_CUST IN (@[cust_cd])" ).append("\n"); 
		query.append("	#end " ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if (${cust_gb} == 'GC')" ).append("\n"); 
		query.append("	#if (${cust_cd} != '')" ).append("\n"); 
		query.append("AND MN.CN_GROUP_CUST IN (@[cust_cd])" ).append("\n"); 
		query.append("	#end " ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if (${date_gb} == 'ETD')" ).append("\n"); 
		query.append("	#if (${from_date} != '' && ${to_date} != '')" ).append("\n"); 
		query.append("AND MN.T_POL_ETD between REPLACE(@[from_date],'-','') and REPLACE(@[to_date],'-','')" ).append("\n"); 
		query.append("	#end " ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if (${date_gb} == 'ETA')" ).append("\n"); 
		query.append("	#if (${from_date} != '' && ${to_date} != '')" ).append("\n"); 
		query.append("AND MN.T_POD_ETA between REPLACE(@[from_date],'-','') and REPLACE(@[to_date],'-','')" ).append("\n"); 
		query.append("	#end " ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if (${date_gb} == '1STVVD')" ).append("\n"); 
		query.append("	#if (${from_date} != '' && ${to_date} != '')" ).append("\n"); 
		query.append("AND MN.FIRST_VVD_ETD between REPLACE(@[from_date],'-','') and REPLACE(@[to_date],'-','')" ).append("\n"); 
		query.append("	#end " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vvd} != '')" ).append("\n"); 
		query.append("and MN.T_VVD = @[vvd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}