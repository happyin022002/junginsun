/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AccountReceivableEDISendDBDAOSearchEDI310InvoiceRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.25
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.25 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableEDISendDBDAOSearchEDI310InvoiceRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Search EDI 310 Invoice
	  * </pre>
	  */
	public AccountReceivableEDISendDBDAOSearchEDI310InvoiceRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sc_rfa_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ar_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sa_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bdr_ind_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tvvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sa_from_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.integration").append("\n"); 
		query.append("FileName : AccountReceivableEDISendDBDAOSearchEDI310InvoiceRSQL").append("\n"); 
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
		query.append("MERGE_CHK,EDI_HDR_SEQ,AR_IF_NO,BL_NO,BL_SEQ,BKG_NO,INV_NO,CNTR_NO,AR_OFC_CD,SOURCE_CD,REV_TP_SRC_CD,ACT_CUST_CNT_CD,ACT_CUST_SEQ,CUST_CD,CUST_NM,VSL_CD,SKD_VOY_NO,SKD_DIR_CD,TRNK_VVD_CD,SVC_SCP_CD,SLAN_CD,SAIL_ARR_DT,IO_BND_CD,POR_CD,POL_CD,POD_CD,DEL_CD,SC_NO,RFA_NO,BDR_IND_FLG,INV_DT,LOCL_CURR_CD,INV_TTL_LOCL_AMT,EDI_SND_FLG,EDI_SND_DT,EDI_TP_CD,CHG_SEQ,CHG_CD,CURR_CD,PER_TP_CD,TRF_RT_AMT,RAT_AS_CNTR_QTY,CHG_AMT,INV_DELT_DIV_CD " ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("      DECODE(INV_NO, '', DECODE(EDI_TP_CD, 'INV_BL', BL_NO||'-'||LPAD(BL_SEQ, 3, '0'), CNTR_NO||'-'||LPAD((BL_SEQ + DENSE_RANK() OVER (PARTITION BY DECODE(INV_NO, '', CNTR_NO, '') ORDER BY DECODE(SUBSTR(REV_TP_SRC_CD, 1, 1), 'M', 'B','A'))), 3, '0')), INV_NO) MERGE_CHK" ).append("\n"); 
		query.append("    , EDI_HDR_SEQ" ).append("\n"); 
		query.append("    , AR_IF_NO" ).append("\n"); 
		query.append("    , BL_NO" ).append("\n"); 
		query.append("    , DECODE(INV_NO, '', (BL_SEQ + DECODE(EDI_TP_CD, 'INV_BL', 0, DENSE_RANK() OVER (PARTITION BY DECODE(INV_NO, '', CNTR_NO, '') ORDER BY DECODE(SUBSTR(REV_TP_SRC_CD, 1, 1), 'M', 'B','A')))), BL_SEQ) BL_SEQ" ).append("\n"); 
		query.append("    , BKG_NO  " ).append("\n"); 
		query.append("    , DECODE(INV_NO, '', DECODE(EDI_TP_CD, 'INV_BL', BL_NO||'-'||LPAD(BL_SEQ, 3, '0'), CNTR_NO||'-'||LPAD((BL_SEQ + DENSE_RANK() OVER (PARTITION BY DECODE(INV_NO, '', CNTR_NO, '') ORDER BY DECODE(SUBSTR(REV_TP_SRC_CD, 1, 1), 'M', 'B','A'))), 3, '0')), INV_NO) INV_NO" ).append("\n"); 
		query.append("    , CNTR_NO" ).append("\n"); 
		query.append("    , AR_OFC_CD" ).append("\n"); 
		query.append("    , DECODE(SUBSTR(REV_TP_SRC_CD, 1, 1), 'M', 'DMT', 'BKG') SOURCE_CD" ).append("\n"); 
		query.append("    , REV_TP_SRC_CD" ).append("\n"); 
		query.append("    , ACT_CUST_CNT_CD" ).append("\n"); 
		query.append("    , ACT_CUST_SEQ" ).append("\n"); 
		query.append("	, ACT_CUST_CNT_CD||'-'||LPAD(ACT_CUST_SEQ, 6, '0') CUST_CD" ).append("\n"); 
		query.append("    , (SELECT CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("       FROM MDM_CUSTOMER" ).append("\n"); 
		query.append("       WHERE CUST_CNT_CD = ACT_CUST_CNT_CD" ).append("\n"); 
		query.append("       AND CUST_SEQ = ACT_CUST_SEQ) CUST_NM" ).append("\n"); 
		query.append("    , VSL_CD" ).append("\n"); 
		query.append("    , SKD_VOY_NO" ).append("\n"); 
		query.append("    , SKD_DIR_CD" ).append("\n"); 
		query.append("    , TRNK_VVD_CD" ).append("\n"); 
		query.append("    , SVC_SCP_CD" ).append("\n"); 
		query.append("    , SLAN_CD" ).append("\n"); 
		query.append("    , SAIL_ARR_DT" ).append("\n"); 
		query.append("    , IO_BND_CD" ).append("\n"); 
		query.append("    , POR_CD" ).append("\n"); 
		query.append("    , POL_CD" ).append("\n"); 
		query.append("    , POD_CD" ).append("\n"); 
		query.append("    , DEL_CD" ).append("\n"); 
		query.append("    , SC_NO" ).append("\n"); 
		query.append("    , RFA_NO" ).append("\n"); 
		query.append("    , BDR_IND_FLG" ).append("\n"); 
		query.append("    , DECODE(INV_DT, '', TO_CHAR(SYSDATE, 'YYYYMMDD'), INV_DT) INV_DT" ).append("\n"); 
		query.append("    , LOCL_CURR_CD" ).append("\n"); 
		query.append("    , DECODE(INV_TTL_LOCL_AMT, '', (SUM(CHG_AMT * INV_XCH_RT) OVER (PARTITION BY AR_IF_NO, DECODE(EDI_TP_CD, 'INV_BL', AR_IF_NO, CNTR_NO))), INV_TTL_LOCL_AMT) INV_TTL_LOCL_AMT" ).append("\n"); 
		query.append("    , EDI_SND_FLG" ).append("\n"); 
		query.append("    , TO_CHAR(EDI_SND_DT, 'YYYY-MM-DD HH24:MI:SS') EDI_SND_DT" ).append("\n"); 
		query.append("    , EDI_TP_CD" ).append("\n"); 
		query.append("    , CHG_SEQ" ).append("\n"); 
		query.append("    , CHG_CD" ).append("\n"); 
		query.append("    , CURR_CD" ).append("\n"); 
		query.append("    , PER_TP_CD" ).append("\n"); 
		query.append("    , TRF_RT_AMT" ).append("\n"); 
		query.append("    , RAT_AS_CNTR_QTY" ).append("\n"); 
		query.append("    , CHG_AMT" ).append("\n"); 
		query.append("    , INV_DELT_DIV_CD " ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("        -- START INV_AR_MN MAX ----------------------------        " ).append("\n"); 
		query.append("  		SELECT NULL EDI_HDR_SEQ " ).append("\n"); 
		query.append("			, A.AR_IF_NO " ).append("\n"); 
		query.append("	        , A.BL_SRC_NO BL_NO" ).append("\n"); 
		query.append("            , DECODE(C.INV_EDI_LVL_CD, 'B', NVL((SELECT LENGTH(SUBSTR(XMLAGG (XMLELEMENT (X , ',', AR_IF_NO) ORDER BY AR_IF_NO).EXTRACT ( '//text()' ), 1))" ).append("\n"); 
		query.append("                                                        - LENGTH(REPLACE(SUBSTR(XMLAGG (XMLELEMENT (X , ',', AR_IF_NO) ORDER BY AR_IF_NO).EXTRACT ( '//text()' ), 1), ',', ''))" ).append("\n"); 
		query.append("                                                 FROM INV_AR_MN" ).append("\n"); 
		query.append("                                                 WHERE BL_SRC_NO = A.BL_SRC_NO" ).append("\n"); 
		query.append("                                                 AND AR_OFC_CD = A.AR_OFC_CD" ).append("\n"); 
		query.append("                                                 AND REV_TP_CD <> 'M'" ).append("\n"); 
		query.append("                                                 AND NVL(INV_SPLIT_CD, 'M') IN ('M','C','E','X')" ).append("\n"); 
		query.append("                                                 AND BL_INV_CFM_DT IS NOT NULL" ).append("\n"); 
		query.append("                                                 AND INV_DELT_DIV_CD <> 'Y'" ).append("\n"); 
		query.append("                                                 AND AR_IF_NO <= A.AR_IF_NO), 1)" ).append("\n"); 
		query.append("                                           , NVL((SELECT MAX(BL_SEQ)" ).append("\n"); 
		query.append("                                                 FROM INV_EDI_HDR" ).append("\n"); 
		query.append("                                                 WHERE CNTR_NO = B.CNTR_NO" ).append("\n"); 
		query.append("                                                 AND AR_OFC_CD = A.AR_OFC_CD" ).append("\n"); 
		query.append("												 AND EDI_TP_CD = 'INV_CNTR'), 0))    AS BL_SEQ     " ).append("\n"); 
		query.append("            , A.BKG_NO" ).append("\n"); 
		query.append("            , '' INV_NO" ).append("\n"); 
		query.append("            , B.CNTR_NO" ).append("\n"); 
		query.append("            , A.AR_OFC_CD" ).append("\n"); 
		query.append("            , A.REV_TP_CD||A.REV_SRC_CD REV_TP_SRC_CD" ).append("\n"); 
		query.append("            , A.ACT_CUST_CNT_CD" ).append("\n"); 
		query.append("            , A.ACT_CUST_SEQ" ).append("\n"); 
		query.append("            , A.VSL_CD" ).append("\n"); 
		query.append("            , A.SKD_VOY_NO" ).append("\n"); 
		query.append("            , A.SKD_DIR_CD" ).append("\n"); 
		query.append("            , A.TRNK_VSL_CD||A.TRNK_SKD_VOY_NO||A.TRNK_SKD_DIR_CD TRNK_VVD_CD" ).append("\n"); 
		query.append("            , A.SVC_SCP_CD" ).append("\n"); 
		query.append("            , A.SLAN_CD" ).append("\n"); 
		query.append("            , A.SAIL_ARR_DT" ).append("\n"); 
		query.append("            , A.IO_BND_CD" ).append("\n"); 
		query.append("            , A.POR_CD" ).append("\n"); 
		query.append("            , A.POL_CD" ).append("\n"); 
		query.append("            , A.POD_CD" ).append("\n"); 
		query.append("            , A.DEL_CD" ).append("\n"); 
		query.append("            , A.SC_NO" ).append("\n"); 
		query.append("            , A.RFA_NO" ).append("\n"); 
		query.append("            , B.BDR_IND_FLG" ).append("\n"); 
		query.append("            , '' INV_DT" ).append("\n"); 
		query.append("            , A.LOCL_CURR_CD" ).append("\n"); 
		query.append("            , NULL INV_TTL_LOCL_AMT" ).append("\n"); 
		query.append("            , 'N' EDI_SND_FLG" ).append("\n"); 
		query.append("            , NULL EDI_SND_DT" ).append("\n"); 
		query.append("            , DECODE(C.INV_EDI_LVL_CD, 'B', 'INV_BL', 'INV_CNTR') EDI_TP_CD" ).append("\n"); 
		query.append("            , ROW_NUMBER() OVER (PARTITION BY A.BL_SRC_NO, B.CNTR_NO ORDER BY B.CHG_CD, B.CURR_CD, B.PER_TP_CD) CHG_SEQ" ).append("\n"); 
		query.append("            , B.CHG_CD" ).append("\n"); 
		query.append("            , B.CURR_CD" ).append("\n"); 
		query.append("            , B.PER_TP_CD" ).append("\n"); 
		query.append("            , B.TRF_RT_AMT" ).append("\n"); 
		query.append("            , B.RAT_AS_CNTR_QTY" ).append("\n"); 
		query.append("            , B.CHG_AMT" ).append("\n"); 
		query.append("            , (SELECT INV_XCH_RT" ).append("\n"); 
		query.append("               FROM INV_AR_CHG" ).append("\n"); 
		query.append("               WHERE AR_IF_NO = A.AR_IF_NO" ).append("\n"); 
		query.append("               AND CURR_CD = B.CURR_CD" ).append("\n"); 
		query.append("               AND ROWNUM = 1) INV_XCH_RT" ).append("\n"); 
		query.append("            , A.INV_DELT_DIV_CD " ).append("\n"); 
		query.append("        FROM INV_AR_MN A,      " ).append("\n"); 
		query.append("            (SELECT X.AR_IF_NO" ).append("\n"); 
		query.append("                      , X.BL_SRC_NO BL_NO" ).append("\n"); 
		query.append("                      , X.ACT_CUST_CNT_CD" ).append("\n"); 
		query.append("                      , X.ACT_CUST_SEQ" ).append("\n"); 
		query.append("                      , X.BDR_IND_FLG" ).append("\n"); 
		query.append("                      , Y.CNTR_NO" ).append("\n"); 
		query.append("                      , Y.CHG_CD" ).append("\n"); 
		query.append("                      , Y.CURR_CD" ).append("\n"); 
		query.append("                      , Y.RAT_UT_CD PER_TP_CD" ).append("\n"); 
		query.append("                      , Y.RAT_AS_QTY  RAT_AS_CNTR_QTY" ).append("\n"); 
		query.append("                      , Y.CHG_UT_AMT  TRF_RT_AMT" ).append("\n"); 
		query.append("                      , SUM(DECODE(X.INV_DELT_DIV_CD, 'X', 0, Y.CHG_AMT)) CHG_AMT" ).append("\n"); 
		query.append("                 FROM " ).append("\n"); 
		query.append("                     (SELECT P.AR_IF_NO" ).append("\n"); 
		query.append("                            , P.BL_SRC_NO" ).append("\n"); 
		query.append("                            , P.BKG_NO" ).append("\n"); 
		query.append("                            , P.ACT_CUST_CNT_CD" ).append("\n"); 
		query.append("                            , P.ACT_CUST_SEQ" ).append("\n"); 
		query.append("                            , P.INV_DELT_DIV_CD" ).append("\n"); 
		query.append("                            , Q.BDR_IND_FLG" ).append("\n"); 
		query.append("                            , R.OFC_CD" ).append("\n"); 
		query.append("                            , R.IO_BND_CD" ).append("\n"); 
		query.append("                            , R.N3RD_FLG" ).append("\n"); 
		query.append("                            , T.INV_EDI_LVL_CD" ).append("\n"); 
		query.append("                     FROM INV_AR_MN P," ).append("\n"); 
		query.append("                          INV_BKG_IF_MN Q," ).append("\n"); 
		query.append("                          INV_BKG_IF_CHG R," ).append("\n"); 
		query.append("                          MDM_ORGANIZATION S," ).append("\n"); 
		query.append("                          MDM_CUSTOMER T" ).append("\n"); 
		query.append("                     WHERE P.BKG_NO = Q.BKG_NO" ).append("\n"); 
		query.append("                     AND Q.BKG_SEQ = (SELECT MAX(BKG_SEQ) FROM INV_BKG_IF_MN WHERE BKG_NO = P.BKG_NO)" ).append("\n"); 
		query.append("                     AND P.BKG_NO = R.BKG_NO" ).append("\n"); 
		query.append("                     AND R.BKG_SEQ = (SELECT MAX(BKG_SEQ) FROM INV_BKG_IF_MN WHERE BKG_NO = P.BKG_NO)" ).append("\n"); 
		query.append("                     AND R.OFC_CD = S.OFC_CD" ).append("\n"); 
		query.append("                     AND P.AR_OFC_CD = S.AR_OFC_CD" ).append("\n"); 
		query.append("                     AND P.IO_BND_CD = R.IO_BND_CD" ).append("\n"); 
		query.append("                     AND P.ACT_CUST_CNT_CD = T.CUST_CNT_CD" ).append("\n"); 
		query.append("                     AND P.ACT_CUST_SEQ = T.CUST_SEQ" ).append("\n"); 
		query.append("                     AND P.OTS_PAY_CD IS NULL AND P.ORG_INV_NO IS NULL --Except migration data" ).append("\n"); 
		query.append("                     AND P.AR_IF_NO IN (SELECT MAX(AR_IF_NO)" ).append("\n"); 
		query.append("                                        FROM INV_AR_MN" ).append("\n"); 
		query.append("                                        WHERE AR_OFC_CD = @[ar_ofc_cd]" ).append("\n"); 
		query.append("										#if (${sc_rfa_no} != '')" ).append("\n"); 
		query.append("                                        	#if (${cntc_tp_cd} == 'S')" ).append("\n"); 
		query.append("                                            	AND SC_NO IN (@[sc_rfa_no])" ).append("\n"); 
		query.append("                                        	#elseif (${cntc_tp_cd} == 'R')" ).append("\n"); 
		query.append("                                            	AND RFA_NO IN (@[sc_rfa_no])" ).append("\n"); 
		query.append("                                        	#end" ).append("\n"); 
		query.append("										#end" ).append("\n"); 
		query.append("                                        #if (${cust_cd} != '')" ).append("\n"); 
		query.append("                                            AND ACT_CUST_CNT_CD||ACT_CUST_SEQ IN (@[cust_cd])" ).append("\n"); 
		query.append("                                        #end" ).append("\n"); 
		query.append("                                        AND REV_TP_CD <> 'M'" ).append("\n"); 
		query.append("                                        AND NVL(INV_SPLIT_CD, 'M') IN ('M','C','E','X')" ).append("\n"); 
		query.append("                                        AND BL_INV_CFM_DT IS NOT NULL" ).append("\n"); 
		query.append("                                        AND INV_DELT_DIV_CD <> 'Y'" ).append("\n"); 
		query.append("                                        GROUP BY BL_SRC_NO)  " ).append("\n"); 
		query.append("                     AND P.INV_DELT_DIV_CD <> 'X' " ).append("\n"); 
		query.append("                     GROUP BY P.AR_IF_NO" ).append("\n"); 
		query.append("                            , P.BL_SRC_NO" ).append("\n"); 
		query.append("                            , P.BKG_NO" ).append("\n"); 
		query.append("                            , P.ACT_CUST_CNT_CD" ).append("\n"); 
		query.append("                            , P.ACT_CUST_SEQ" ).append("\n"); 
		query.append("                            , P.INV_DELT_DIV_CD" ).append("\n"); 
		query.append("                            , Q.BDR_IND_FLG" ).append("\n"); 
		query.append("                            , R.OFC_CD" ).append("\n"); 
		query.append("                            , R.IO_BND_CD" ).append("\n"); 
		query.append("                            , R.N3RD_FLG" ).append("\n"); 
		query.append("                            , T.INV_EDI_LVL_CD" ).append("\n"); 
		query.append("                     ) X," ).append("\n"); 
		query.append("                     BKG_CNTR_RT Y," ).append("\n"); 
		query.append("					 BKG_RATE Z" ).append("\n"); 
		query.append("                WHERE X.BKG_NO = Y.BKG_NO" ).append("\n"); 
		query.append("				AND X.BKG_NO = Z.BKG_NO" ).append("\n"); 
		query.append("                -- AND DECODE(X.IO_BND_CD,'O','P','I','C') = Y.FRT_TERM_CD" ).append("\n"); 
		query.append("                AND X.OFC_CD = NVL(Y.N3PTY_RCV_OFC_CD, DECODE(Y.FRT_TERM_CD, 'P', Z.PPD_RCV_OFC_CD, Z.CLT_OFC_CD))" ).append("\n"); 
		query.append("                AND X.AR_IF_NO || Y.CNTR_NO  NOT IN (SELECT AR_IF_NO || CNTR_NO  " ).append("\n"); 
		query.append("                                                     FROM INV_EDI_HDR AA" ).append("\n"); 
		query.append("                                                     WHERE AA.EDI_TP_CD IN ('INV_BL','INV_CNTR') ) " ).append("\n"); 
		query.append("                GROUP BY X.AR_IF_NO" ).append("\n"); 
		query.append("                      , X.BL_SRC_NO" ).append("\n"); 
		query.append("                      , X.ACT_CUST_CNT_CD" ).append("\n"); 
		query.append("                      , X.ACT_CUST_SEQ" ).append("\n"); 
		query.append("                      , X.BDR_IND_FLG" ).append("\n"); 
		query.append("                      , X.INV_EDI_LVL_CD" ).append("\n"); 
		query.append("                      , Y.CNTR_NO" ).append("\n"); 
		query.append("                      , Y.CHG_CD" ).append("\n"); 
		query.append("                      , Y.CURR_CD" ).append("\n"); 
		query.append("                      , Y.RAT_UT_CD    " ).append("\n"); 
		query.append("                      , Y.RAT_AS_QTY" ).append("\n"); 
		query.append("                      , Y.CHG_UT_AMT                " ).append("\n"); 
		query.append("            ) B," ).append("\n"); 
		query.append("            MDM_CUSTOMER C" ).append("\n"); 
		query.append("        WHERE A.AR_IF_NO = B.AR_IF_NO    " ).append("\n"); 
		query.append("        AND A.ACT_CUST_CNT_CD = C.CUST_CNT_CD" ).append("\n"); 
		query.append("        AND A.ACT_CUST_SEQ = C.CUST_SEQ" ).append("\n"); 
		query.append("        AND B.CHG_AMT <> 0  " ).append("\n"); 
		query.append("        AND A.OTS_PAY_CD IS NULL AND A.ORG_INV_NO IS NULL --Except migration data" ).append("\n"); 
		query.append("        -- END INV_AR_MN MAX ----------------------------" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        -- START DM,DT MAX ----------------------------" ).append("\n"); 
		query.append("        SELECT NULL EDI_HDR_SEQ " ).append("\n"); 
		query.append("			, A.AR_IF_NO " ).append("\n"); 
		query.append("	        , A.BL_SRC_NO BL_NO         " ).append("\n"); 
		query.append("            , DECODE(D.INV_EDI_LVL_CD, 'B', NVL((SELECT LENGTH(SUBSTR(XMLAGG (XMLELEMENT (X , ',', AR_IF_NO) ORDER BY AR_IF_NO).EXTRACT ( '//text()' ), 1))" ).append("\n"); 
		query.append("                                                        - LENGTH(REPLACE(SUBSTR(XMLAGG (XMLELEMENT (X , ',', AR_IF_NO) ORDER BY AR_IF_NO).EXTRACT ( '//text()' ), 1), ',', ''))" ).append("\n"); 
		query.append("                                                 FROM INV_AR_MN" ).append("\n"); 
		query.append("                                                 WHERE BL_SRC_NO = A.BL_SRC_NO" ).append("\n"); 
		query.append("                                                 AND AR_OFC_CD = A.AR_OFC_CD" ).append("\n"); 
		query.append("                                                 AND REV_TP_CD||REV_SRC_CD IN ('MDM', 'MDT')" ).append("\n"); 
		query.append("                                                 AND BL_INV_CFM_DT IS NOT NULL" ).append("\n"); 
		query.append("                                                 AND INV_DELT_DIV_CD <> 'Y'" ).append("\n"); 
		query.append("                                                 AND AR_IF_NO <= A.AR_IF_NO), 1) + 900" ).append("\n"); 
		query.append("                                           , NVL((SELECT MAX(BL_SEQ)" ).append("\n"); 
		query.append("                                                 FROM INV_EDI_HDR" ).append("\n"); 
		query.append("                                                 WHERE CNTR_NO = C.TRF_NO" ).append("\n"); 
		query.append("                                                 AND AR_OFC_CD = A.AR_OFC_CD" ).append("\n"); 
		query.append("												 AND EDI_TP_CD = 'INV_CNTR'), 0))    AS BL_SEQ     " ).append("\n"); 
		query.append("            , A.BKG_NO" ).append("\n"); 
		query.append("            , '' INV_NO" ).append("\n"); 
		query.append("            , C.TRF_NO AS CNTR_NO" ).append("\n"); 
		query.append("            , A.AR_OFC_CD" ).append("\n"); 
		query.append("            , A.REV_TP_CD||A.REV_SRC_CD REV_TP_SRC_CD" ).append("\n"); 
		query.append("            , A.ACT_CUST_CNT_CD" ).append("\n"); 
		query.append("            , A.ACT_CUST_SEQ" ).append("\n"); 
		query.append("            , A.VSL_CD" ).append("\n"); 
		query.append("            , A.SKD_VOY_NO" ).append("\n"); 
		query.append("            , A.SKD_DIR_CD" ).append("\n"); 
		query.append("            , A.TRNK_VSL_CD||A.TRNK_SKD_VOY_NO||A.TRNK_SKD_DIR_CD TRNK_VVD_CD" ).append("\n"); 
		query.append("            , A.SVC_SCP_CD" ).append("\n"); 
		query.append("            , A.SLAN_CD" ).append("\n"); 
		query.append("            , A.SAIL_ARR_DT" ).append("\n"); 
		query.append("            , A.IO_BND_CD" ).append("\n"); 
		query.append("            , A.POR_CD" ).append("\n"); 
		query.append("            , A.POL_CD" ).append("\n"); 
		query.append("            , A.POD_CD" ).append("\n"); 
		query.append("            , A.DEL_CD" ).append("\n"); 
		query.append("            , A.SC_NO" ).append("\n"); 
		query.append("            , A.RFA_NO" ).append("\n"); 
		query.append("            , '' BDR_IND_FLG" ).append("\n"); 
		query.append("            , '' INV_DT" ).append("\n"); 
		query.append("            , A.LOCL_CURR_CD" ).append("\n"); 
		query.append("            , NULL INV_TTL_LOCL_AMT" ).append("\n"); 
		query.append("            , 'N' EDI_SND_FLG" ).append("\n"); 
		query.append("            , NULL EDI_SND_DT" ).append("\n"); 
		query.append("            , DECODE(D.INV_EDI_LVL_CD, 'B', 'INV_BL', 'INV_CNTR') EDI_TP_CD" ).append("\n"); 
		query.append("            , C.CHG_SEQ" ).append("\n"); 
		query.append("            , C.CHG_CD" ).append("\n"); 
		query.append("            , C.CURR_CD" ).append("\n"); 
		query.append("            , C.PER_TP_CD" ).append("\n"); 
		query.append("            , NULL TRF_RT_AMT" ).append("\n"); 
		query.append("            , NULL RAT_AS_CNTR_QTY" ).append("\n"); 
		query.append("            , C.CHG_AMT" ).append("\n"); 
		query.append("            , (SELECT INV_XCH_RT" ).append("\n"); 
		query.append("               FROM INV_AR_CHG" ).append("\n"); 
		query.append("               WHERE AR_IF_NO = A.AR_IF_NO" ).append("\n"); 
		query.append("               AND CURR_CD = C.CURR_CD" ).append("\n"); 
		query.append("               AND ROWNUM = 1) INV_XCH_RT" ).append("\n"); 
		query.append("             , A.INV_DELT_DIV_CD " ).append("\n"); 
		query.append("        FROM INV_AR_MN A," ).append("\n"); 
		query.append("             INV_AR_IF_MN B," ).append("\n"); 
		query.append("             INV_AR_IF_CHG C," ).append("\n"); 
		query.append("             MDM_CUSTOMER D" ).append("\n"); 
		query.append("        WHERE A.AR_IF_NO = B.AR_IF_NO" ).append("\n"); 
		query.append("        AND B.SRC_IF_DT = C.SRC_IF_DT" ).append("\n"); 
		query.append("        AND B.SRC_IF_SEQ = C.SRC_IF_SEQ" ).append("\n"); 
		query.append("        AND A.ACT_CUST_CNT_CD = D.CUST_CNT_CD" ).append("\n"); 
		query.append("        AND A.ACT_CUST_SEQ = D.CUST_SEQ" ).append("\n"); 
		query.append("        AND B.BL_INV_IF_FLG = 'Y'" ).append("\n"); 
		query.append("        AND B.BL_INV_IF_DT IS NOT NULL" ).append("\n"); 
		query.append("        AND A.REV_TP_CD = 'M'" ).append("\n"); 
		query.append("        AND A.REV_SRC_CD IN ('DM', 'DT')" ).append("\n"); 
		query.append("        AND A.OTS_PAY_CD IS NULL AND A.ORG_INV_NO IS NULL --Except migration data" ).append("\n"); 
		query.append("        AND A.AR_OFC_CD = @[ar_ofc_cd]" ).append("\n"); 
		query.append("		#if (${sc_rfa_no} != '')" ).append("\n"); 
		query.append("        	#if (${cntc_tp_cd} == 'S')" ).append("\n"); 
		query.append("            	AND A.SC_NO IN (@[sc_rfa_no])" ).append("\n"); 
		query.append("        	#elseif (${cntc_tp_cd} == 'R')" ).append("\n"); 
		query.append("            	AND A.RFA_NO IN (@[sc_rfa_no])" ).append("\n"); 
		query.append("        	#end" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("        #if (${cust_cd} != '')" ).append("\n"); 
		query.append("            AND A.ACT_CUST_CNT_CD||A.ACT_CUST_SEQ IN (@[cust_cd])" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        AND A.AR_IF_NO NOT IN (SELECT AR_IF_NO   --** ADDED" ).append("\n"); 
		query.append("                               FROM INV_EDI_HDR AA" ).append("\n"); 
		query.append("                               WHERE AA.EDI_TP_CD IN ('INV_BL','INV_CNTR') ) " ).append("\n"); 
		query.append("        -- END DM,DT MAX ----------------------------                " ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        -- START EDI TRANSFERED DATA" ).append("\n"); 
		query.append("        SELECT A.EDI_HDR_SEQ" ).append("\n"); 
		query.append("			, A.AR_IF_NO " ).append("\n"); 
		query.append("            , A.BL_NO" ).append("\n"); 
		query.append("            , A.BL_SEQ" ).append("\n"); 
		query.append("            , A.BKG_NO" ).append("\n"); 
		query.append("            , A.INV_NO" ).append("\n"); 
		query.append("           -- , DECODE(A.EDI_TP_CD, 'INV_BL', (SELECT SUBSTR(XMLAGG(XMLELEMENT(X, ',', CNTR_NO) ORDER BY CNTR_NO).EXTRACT('//text()'), 2)" ).append("\n"); 
		query.append("           --                                  FROM INV_EDI_CNTR" ).append("\n"); 
		query.append("           --                                  WHERE EDI_HDR_SEQ = A.EDI_HDR_SEQ), A.CNTR_NO) CNTR_NO" ).append("\n"); 
		query.append("            , A.CNTR_NO AS CNTR_NO                     " ).append("\n"); 
		query.append("            , A.AR_OFC_CD" ).append("\n"); 
		query.append("            , A.REV_TP_SRC_CD" ).append("\n"); 
		query.append("            , A.ACT_CUST_CNT_CD" ).append("\n"); 
		query.append("            , A.ACT_CUST_SEQ" ).append("\n"); 
		query.append("            , A.VSL_CD" ).append("\n"); 
		query.append("            , A.SKD_VOY_NO" ).append("\n"); 
		query.append("            , A.SKD_DIR_CD" ).append("\n"); 
		query.append("            , A.TRNK_VVD_CD" ).append("\n"); 
		query.append("            , A.SVC_SCP_CD" ).append("\n"); 
		query.append("            , A.SLAN_CD" ).append("\n"); 
		query.append("            , A.SAIL_ARR_DT" ).append("\n"); 
		query.append("            , A.IO_BND_CD" ).append("\n"); 
		query.append("            , A.POR_CD" ).append("\n"); 
		query.append("            , A.POL_CD" ).append("\n"); 
		query.append("            , A.POD_CD" ).append("\n"); 
		query.append("            , A.DEL_CD" ).append("\n"); 
		query.append("            , A.SC_NO" ).append("\n"); 
		query.append("            , A.RFA_NO" ).append("\n"); 
		query.append("            , A.BDR_IND_FLG" ).append("\n"); 
		query.append("            , A.INV_DT" ).append("\n"); 
		query.append("            , A.LOCL_CURR_CD" ).append("\n"); 
		query.append("            , A.INV_TTL_LOCL_AMT" ).append("\n"); 
		query.append("            , A.EDI_SND_FLG" ).append("\n"); 
		query.append("            , A.EDI_SND_DT" ).append("\n"); 
		query.append("            , A.EDI_TP_CD" ).append("\n"); 
		query.append("            , B.CHG_SEQ" ).append("\n"); 
		query.append("            , B.CHG_CD" ).append("\n"); 
		query.append("            , B.CURR_CD" ).append("\n"); 
		query.append("            , B.PER_TP_CD" ).append("\n"); 
		query.append("            , B.TRF_RT_AMT" ).append("\n"); 
		query.append("            , B.RAT_AS_CNTR_QTY" ).append("\n"); 
		query.append("            , B.CHG_AMT" ).append("\n"); 
		query.append("            , NULL INV_XCH_RT" ).append("\n"); 
		query.append("            , 'N' INV_DELT_DIV_CD " ).append("\n"); 
		query.append("        FROM INV_EDI_HDR A," ).append("\n"); 
		query.append("             INV_EDI_CHG B" ).append("\n"); 
		query.append("        WHERE A.EDI_HDR_SEQ = B.EDI_HDR_SEQ" ).append("\n"); 
		query.append("        AND A.AR_OFC_CD = @[ar_ofc_cd]" ).append("\n"); 
		query.append("		#if (${sc_rfa_no} != '')" ).append("\n"); 
		query.append("        	#if (${cntc_tp_cd} == 'S')" ).append("\n"); 
		query.append("            	AND A.SC_NO IN (@[sc_rfa_no])" ).append("\n"); 
		query.append("        	#elseif (${cntc_tp_cd} == 'R')" ).append("\n"); 
		query.append("            	AND A.RFA_NO IN (@[sc_rfa_no])" ).append("\n"); 
		query.append("        	#end" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("        #if (${cust_cd} != '')" ).append("\n"); 
		query.append("            AND A.ACT_CUST_CNT_CD||A.ACT_CUST_SEQ IN (@[cust_cd])" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        AND A.EDI_TP_CD IN ('INV_BL','INV_CNTR')" ).append("\n"); 
		query.append("        -- END EDI TRANSFERED DATA" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        -- START EDI CANCEL DATA  **** " ).append("\n"); 
		query.append("        SELECT NULL EDI_HDR_SEQ" ).append("\n"); 
		query.append("			, C.NEXT_AR_IF_NO AS AR_IF_NO " ).append("\n"); 
		query.append("            , A.BL_NO" ).append("\n"); 
		query.append("            , DECODE(A.EDI_TP_CD, 'INV_BL', NVL((SELECT LENGTH(SUBSTR(XMLAGG (XMLELEMENT (X , ',', AR_IF_NO) ORDER BY AR_IF_NO).EXTRACT ( '//text()' ), 1))" ).append("\n"); 
		query.append("                                                        - LENGTH(REPLACE(SUBSTR(XMLAGG (XMLELEMENT (X , ',', AR_IF_NO) ORDER BY AR_IF_NO).EXTRACT ( '//text()' ), 1), ',', ''))" ).append("\n"); 
		query.append("                                                 FROM INV_AR_MN" ).append("\n"); 
		query.append("                                                 WHERE BL_SRC_NO = A.BL_NO" ).append("\n"); 
		query.append("                                                 AND AR_OFC_CD = A.AR_OFC_CD" ).append("\n"); 
		query.append("                                                 AND REV_TP_CD <> 'M'" ).append("\n"); 
		query.append("                                                 AND NVL(INV_SPLIT_CD, 'M') IN ('M','C','E','X')" ).append("\n"); 
		query.append("                                                 AND BL_INV_CFM_DT IS NOT NULL" ).append("\n"); 
		query.append("                                                 AND INV_DELT_DIV_CD <> 'Y'" ).append("\n"); 
		query.append("                                                 AND AR_IF_NO <= C.NEXT_AR_IF_NO), 1)" ).append("\n"); 
		query.append("                                           , NVL((SELECT MAX(BL_SEQ)" ).append("\n"); 
		query.append("                                                 FROM INV_EDI_HDR" ).append("\n"); 
		query.append("                                                 WHERE CNTR_NO = A.CNTR_NO" ).append("\n"); 
		query.append("                                                 AND AR_OFC_CD = A.AR_OFC_CD" ).append("\n"); 
		query.append("												 AND EDI_TP_CD = 'INV_CNTR'), 0))    AS BL_SEQ     " ).append("\n"); 
		query.append("            , A.BKG_NO" ).append("\n"); 
		query.append("            , '' INV_NO" ).append("\n"); 
		query.append("           -- , DECODE(A.EDI_TP_CD, 'INV_BL', (SELECT SUBSTR(XMLAGG(XMLELEMENT(X, ',', CNTR_NO) ORDER BY CNTR_NO).EXTRACT('//text()'), 2)" ).append("\n"); 
		query.append("           --                                  FROM INV_EDI_CNTR" ).append("\n"); 
		query.append("           --                                  WHERE EDI_HDR_SEQ = A.EDI_HDR_SEQ), A.CNTR_NO) CNTR_NO" ).append("\n"); 
		query.append("            , A.CNTR_NO AS CNTR_NO" ).append("\n"); 
		query.append("            , A.AR_OFC_CD" ).append("\n"); 
		query.append("            , A.REV_TP_SRC_CD" ).append("\n"); 
		query.append("            , A.ACT_CUST_CNT_CD" ).append("\n"); 
		query.append("            , A.ACT_CUST_SEQ" ).append("\n"); 
		query.append("            , A.VSL_CD" ).append("\n"); 
		query.append("            , A.SKD_VOY_NO" ).append("\n"); 
		query.append("            , A.SKD_DIR_CD" ).append("\n"); 
		query.append("            , A.TRNK_VVD_CD" ).append("\n"); 
		query.append("            , A.SVC_SCP_CD" ).append("\n"); 
		query.append("            , A.SLAN_CD" ).append("\n"); 
		query.append("            , A.SAIL_ARR_DT" ).append("\n"); 
		query.append("            , A.IO_BND_CD" ).append("\n"); 
		query.append("            , A.POR_CD" ).append("\n"); 
		query.append("            , A.POL_CD" ).append("\n"); 
		query.append("            , A.POD_CD" ).append("\n"); 
		query.append("            , A.DEL_CD" ).append("\n"); 
		query.append("            , A.SC_NO" ).append("\n"); 
		query.append("            , A.RFA_NO" ).append("\n"); 
		query.append("            , A.BDR_IND_FLG" ).append("\n"); 
		query.append("            , A.INV_DT" ).append("\n"); 
		query.append("            , A.LOCL_CURR_CD" ).append("\n"); 
		query.append("            , A.INV_TTL_LOCL_AMT" ).append("\n"); 
		query.append("            , 'N' EDI_SND_FLG" ).append("\n"); 
		query.append("            , NULL EDI_SND_DT" ).append("\n"); 
		query.append("            , A.EDI_TP_CD" ).append("\n"); 
		query.append("            , B.CHG_SEQ" ).append("\n"); 
		query.append("            , B.CHG_CD" ).append("\n"); 
		query.append("            , B.CURR_CD" ).append("\n"); 
		query.append("            , B.PER_TP_CD" ).append("\n"); 
		query.append("            , B.TRF_RT_AMT" ).append("\n"); 
		query.append("            , B.RAT_AS_CNTR_QTY" ).append("\n"); 
		query.append("            , B.CHG_AMT * (-1) AS CHG_AMT" ).append("\n"); 
		query.append("            , NULL INV_XCH_RT" ).append("\n"); 
		query.append("            , 'X' AS INV_DELT_DIV_CD " ).append("\n"); 
		query.append("        FROM INV_EDI_HDR A," ).append("\n"); 
		query.append("             INV_EDI_CHG B," ).append("\n"); 
		query.append("             (" ).append("\n"); 
		query.append("                    SELECT (SELECT MAX(AR_IF_NO)" ).append("\n"); 
		query.append("                            FROM INV_AR_MN" ).append("\n"); 
		query.append("                            WHERE BL_SRC_NO = IAM.BL_SRC_NO" ).append("\n"); 
		query.append("                            AND AR_OFC_CD = IAM.AR_OFC_CD" ).append("\n"); 
		query.append("                            AND REV_TP_CD <> 'M'" ).append("\n"); 
		query.append("                            AND NVL(INV_SPLIT_CD, 'M') IN ('M','C','E','X')  " ).append("\n"); 
		query.append("                            AND BL_INV_CFM_DT IS NOT NULL" ).append("\n"); 
		query.append("                            AND INV_DELT_DIV_CD = 'N' " ).append("\n"); 
		query.append("                            AND AR_IF_NO < IAM.AR_IF_NO) AS MAX_AR_IF_NO, IAM.AR_IF_NO AS NEXT_AR_IF_NO" ).append("\n"); 
		query.append("                    FROM INV_AR_MN IAM" ).append("\n"); 
		query.append("                    WHERE AR_OFC_CD = @[ar_ofc_cd]" ).append("\n"); 
		query.append("                    #if (${sc_rfa_no} != '')" ).append("\n"); 
		query.append("                        #if (${cntc_tp_cd} == 'S')" ).append("\n"); 
		query.append("                            AND SC_NO IN (@[sc_rfa_no])" ).append("\n"); 
		query.append("                        #elseif (${cntc_tp_cd} == 'R')" ).append("\n"); 
		query.append("                            AND RFA_NO IN (@[sc_rfa_no])" ).append("\n"); 
		query.append("                        #end" ).append("\n"); 
		query.append("                    #end" ).append("\n"); 
		query.append("                    #if (${cust_cd} != '')" ).append("\n"); 
		query.append("                        AND ACT_CUST_CNT_CD||ACT_CUST_SEQ IN (@[cust_cd])" ).append("\n"); 
		query.append("                    #end" ).append("\n"); 
		query.append("                    AND REV_TP_CD <> 'M'" ).append("\n"); 
		query.append("                    AND NVL(INV_SPLIT_CD, 'M') IN ('M','C','E','X')" ).append("\n"); 
		query.append("                    AND BL_INV_CFM_DT IS NOT NULL" ).append("\n"); 
		query.append("                    AND INV_DELT_DIV_CD = 'X' " ).append("\n"); 
		query.append("                    AND IAM.OTS_PAY_CD IS NULL AND IAM.ORG_INV_NO IS NULL --Except migration data" ).append("\n"); 
		query.append("                    AND AR_IF_NO NOT IN (SELECT AR_IF_NO   " ).append("\n"); 
		query.append("                                         FROM INV_EDI_HDR" ).append("\n"); 
		query.append("                                         WHERE EDI_TP_CD IN ('INV_BL','INV_CNTR')" ).append("\n"); 
		query.append("                                        )                               " ).append("\n"); 
		query.append("             ) C" ).append("\n"); 
		query.append("        WHERE A.EDI_HDR_SEQ = B.EDI_HDR_SEQ" ).append("\n"); 
		query.append("        AND   A.AR_IF_NO = C.MAX_AR_IF_NO" ).append("\n"); 
		query.append("        AND A.EDI_TP_CD IN ('INV_BL','INV_CNTR')" ).append("\n"); 
		query.append("        -- END -- START EDI CANCEL DATA" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("#if (${source_cd} == 'BKG')" ).append("\n"); 
		query.append("    AND SUBSTR(REV_TP_SRC_CD, 1, 1) <> 'M'" ).append("\n"); 
		query.append("#elseif (${source_cd} == 'DMT')" ).append("\n"); 
		query.append("    AND SUBSTR(REV_TP_SRC_CD, 1, 1) = 'M'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${io_bnd_cd} != 'A')" ).append("\n"); 
		query.append("    AND IO_BND_CD = @[io_bnd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${tvvd_cd} != '')" ).append("\n"); 
		query.append("    AND TRNK_VVD_CD = @[tvvd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bdr_ind_flg} != 'A')" ).append("\n"); 
		query.append("    AND BDR_IND_FLG = @[bdr_ind_flg]     " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bl_no} != '')" ).append("\n"); 
		query.append("    AND BL_NO = @[bl_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${sa_from_dt} != '' && ${sa_to_dt} != '')" ).append("\n"); 
		query.append("    AND SAIL_ARR_DT BETWEEN REPLACE(@[sa_from_dt], '-', '') AND REPLACE(@[sa_to_dt], '-', '')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${svc_scp_cd} != '')" ).append("\n"); 
		query.append("    AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${chg_cd} != '')" ).append("\n"); 
		query.append("    AND CHG_CD IN (@[chg_cd])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cntr_no} != '')" ).append("\n"); 
		query.append("    AND CNTR_NO LIKE '%'||@[cntr_no]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("ORDER BY  " ).append("\n"); 
		query.append("          MERGE_CHK" ).append("\n"); 
		query.append("        , DECODE(EDI_TP_CD, 'INV_BL', CNTR_NO, BL_NO)" ).append("\n"); 
		query.append("        , AR_IF_NO" ).append("\n"); 
		query.append("        , CHG_SEQ" ).append("\n"); 

	}
}