/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : BRKGAuditDBDAOSearchApPayInvDtlRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.03.07
*@LastModifier : 
*@LastVersion : 1.0
* 2012.03.07 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.agt.agtaudit.brkgaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BRKGAuditDBDAOSearchApPayInvDtlRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchApPayInvDtl
	  * </pre>
	  */
	public BRKGAuditDBDAOSearchApPayInvDtlRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("search_dt_to",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ap_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("search_dt_fr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fwdr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("csr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.agt.agtaudit.brkgaudit.integration").append("\n"); 
		query.append("FileName : BRKGAuditDBDAOSearchApPayInvDtlRSQL").append("\n"); 
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
		query.append("	'I'							 AS IBFLAG," ).append("\n"); 
		query.append("    AA.ACCT                         AS ACCT_CD," ).append("\n"); 
		query.append("    SUBSTR(AA.VVD,1,4)           AS VSL_CD," ).append("\n"); 
		query.append("    SUBSTR(AA.VVD,5,4)           AS SKD_VOY_CD," ).append("\n"); 
		query.append("    SUBSTR(AA.VVD,9,1)           AS SKD_DIR_CD," ).append("\n"); 
		query.append("    SUBSTR(AA.VVD,10,1)          AS REV_DIR_CD," ).append("\n"); 
		query.append("    AA.REV_VVD                      AS ACT_VVD_CD," ).append("\n"); 
		query.append("    AA.YARD                         AS YD_CD," ).append("\n"); 
		query.append("    AA.TPSZ                         AS CNTR_TPSZ_CD," ).append("\n"); 
		query.append("    AA.INV_AMT                      AS INV_AMT," ).append("\n"); 
		query.append("    CASE" ).append("\n"); 
		query.append("    WHEN AA.QTY = '2'" ).append("\n"); 
		query.append("    THEN AA.QTY" ).append("\n"); 
		query.append("    ELSE NULL" ).append("\n"); 
		query.append("    END                             AS SO_20FT_QTY," ).append("\n"); 
		query.append("    CASE" ).append("\n"); 
		query.append("    WHEN AA.QTY = '2'" ).append("\n"); 
		query.append("    THEN NULL" ).append("\n"); 
		query.append("    ELSE AA.QTY" ).append("\n"); 
		query.append("    END                             AS SO_40FT_QTY,    " ).append("\n"); 
		query.append("    @[cre_usr_id]                   AS CRE_USR_ID," ).append("\n"); 
		query.append("    SYSDATE                         AS CRE_DT," ).append("\n"); 
		query.append("    @[cre_usr_id]                   AS UPD_USR_ID," ).append("\n"); 
		query.append("    SYSDATE                         AS UPD_DT," ).append("\n"); 
		query.append("    AA.INV_DESC                     AS INV_DESC        " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append(" SELECT Y.CSR_NO, " ).append("\n"); 
		query.append("       ROW_NUMBER() OVER(ORDER BY X.ATT1, X.COMPANY, X.REGION, X.CENTER, X.ACCT, X.VVD) AS LINE_SEQ, " ).append("\n"); 
		query.append("       DENSE_RANK() OVER(ORDER BY X.ATT1, X.COMPANY, X.REGION, X.CENTER, X.ACCT, X.VVD) AS LINE_NUMBER, " ).append("\n"); 
		query.append("       X.LOOKUP, " ).append("\n"); 
		query.append("       X.INV_AMT, " ).append("\n"); 
		query.append("       X.INV_DESC, " ).append("\n"); 
		query.append("       X.TAX_CD, " ).append("\n"); 
		query.append("       X.COMPANY, " ).append("\n"); 
		query.append("       X.REGION, " ).append("\n"); 
		query.append("       X.CENTER, " ).append("\n"); 
		query.append("       X.ACCT, " ).append("\n"); 
		query.append("       X.VVD, " ).append("\n"); 
		query.append("       X.INTR_CMPY, " ).append("\n"); 
		query.append("       X.FUTURE1, " ).append("\n"); 
		query.append("       X.FUTURE2, " ).append("\n"); 
		query.append("       X.ATT_CTLG, " ).append("\n"); 
		query.append("       X.ATT1, " ).append("\n"); 
		query.append("       X.ATT2, " ).append("\n"); 
		query.append("       X.ATT3, " ).append("\n"); 
		query.append("       X.ATT4, " ).append("\n"); 
		query.append("       X.ATT5, " ).append("\n"); 
		query.append("       X.ATT6, " ).append("\n"); 
		query.append("       X.ATT7, " ).append("\n"); 
		query.append("       X.ATT8, " ).append("\n"); 
		query.append("       X.ATT9, " ).append("\n"); 
		query.append("       X.ATT10, " ).append("\n"); 
		query.append("       X.ATT11, " ).append("\n"); 
		query.append("       X.ATT12, " ).append("\n"); 
		query.append("       X.ATT13, " ).append("\n"); 
		query.append("       X.ATT14, " ).append("\n"); 
		query.append("       X.ATT15, " ).append("\n"); 
		query.append("       X.BKG_NO, " ).append("\n"); 
		query.append("       X.TPSZ, " ).append("\n"); 
		query.append("       X.REV_VVD, " ).append("\n"); 
		query.append("       X.DIV_CD, " ).append("\n"); 
		query.append("       X.CARRIER, " ).append("\n"); 
		query.append("       X.YARD, " ).append("\n"); 
		query.append("       X.COST_CODE, " ).append("\n"); 
		query.append("       X.QTY, " ).append("\n"); 
		query.append("       X.TMNL_CD, " ).append("\n"); 
		query.append("       X.AGNT, " ).append("\n"); 
		query.append("       X.SUB_FLG, " ).append("\n"); 
		query.append("       X.BL_NO " ).append("\n"); 
		query.append("  FROM (SELECT A.VNDR_SEQ VNDR, " ).append("\n"); 
		query.append("               'ITEM' AS LOOKUP, " ).append("\n"); 
		query.append("               ROUND(NVL(B.ACT_USD_COMM_AMT,A.ACT_IF_COMM_AMT),2) AS INV_AMT, " ).append("\n"); 
		query.append("               (SELECT ACCT_ENG_NM FROM MDM_ACCOUNT WHERE ACCT_CD = A.COMM_STND_COST_CD)||'/'||A.BKG_NO AS INV_DESC, " ).append("\n"); 
		query.append("               '' AS TAX_CD, " ).append("\n"); 
		query.append("               '01' AS COMPANY, " ).append("\n"); 
		query.append("               NVL((SELECT FINC_RGN_CD FROM MDM_ORGANIZATION WHERE OFC_CD = A.AP_OFC_CD),'00') AS REGION, " ).append("\n"); 
		query.append("               (SELECT AP_CTR_CD FROM MDM_ORGANIZATION WHERE OFC_CD = A.AP_OFC_CD) AS CENTER, A.COMM_STND_COST_CD ACCT, " ).append("\n"); 
		query.append("        	      (SELECT DECODE(SUBSTR(REV_VVD_CD,0,2),'FD','CFDR'||SUBSTR(REV_VVD_CD,3,4)||'EE',REV_VVD_CD) FROM AGT_COMM_BKG_INFO WHERE BKG_NO = A.BKG_NO ) AS VVD, " ).append("\n"); 
		query.append("               (SELECT NVL(LTRIM(SUBS_CO_CD),'00') FROM MDM_VENDOR WHERE VNDR_SEQ = A.VNDR_SEQ) AS INTR_CMPY, " ).append("\n"); 
		query.append("               '000000' AS FUTURE1, " ).append("\n"); 
		query.append("               '000000' AS FUTURE2, " ).append("\n"); 
		query.append("               A.COMM_STND_COST_CD AS ATT_CTLG, " ).append("\n"); 
		query.append("               C.BL_NO||SUBSTR(TO_CHAR(A.BROG_SEQ,'FM000000'),4,6) AS ATT1, " ).append("\n"); 
		query.append("               SUBSTR('1999/12/31 00:00:00', 0, 4)||'/'||SUBSTR('1999/12/31 00:00:00', 5, 2)||'/'||SUBSTR('1999/12/31 00:00:00', 7, 2)||' 00:00:00' AS ATT2, " ).append("\n"); 
		query.append("               A.COMM_OCCR_INFO_CD AS ATT3, " ).append("\n"); 
		query.append("               '' AS ATT4, '' AS ATT5, '' AS ATT6, '' AS ATT7, '' AS ATT8, '' AS ATT9, " ).append("\n"); 
		query.append("               '' AS ATT10, '' AS ATT11, '' AS ATT12, '' AS ATT13, '' AS ATT14, '' AS ATT15, " ).append("\n"); 
		query.append("               A.BKG_NO, " ).append("\n"); 
		query.append("               B.CNTR_TPSZ_CD AS TPSZ, " ).append("\n"); 
		query.append("               DECODE(A.COMM_SLAN_CD||SUBSTR(A.COMM_VSL_CD,0,2),'RBCFD','CFDR'||SUBSTR(A.COMM_VSL_CD,3,2)||SUBSTR(COMM_SKD_VOY_NO,0,2)||'EE',  " ).append("\n"); 
		query.append("                      A.COMM_VSL_CD||A.COMM_SKD_VOY_NO||A.COMM_SKD_DIR_CD||NVL(A.COMM_REV_DIR_CD,A.COMM_SKD_DIR_CD)) AS REV_VVD, " ).append("\n"); 
		query.append("               'C' AS DIV_CD, " ).append("\n"); 
		query.append("               '' AS CARRIER, " ).append("\n"); 
		query.append("               '' AS YARD, " ).append("\n"); 
		query.append("               '' AS COST_CODE, " ).append("\n"); 
		query.append("               B.BKG_VOL_QTY AS QTY, " ).append("\n"); 
		query.append("               '' AS TMNL_CD, " ).append("\n"); 
		query.append("               '' AS AGNT, " ).append("\n"); 
		query.append("               '' AS SUB_FLG, " ).append("\n"); 
		query.append("               C.BL_NO AS BL_NO, " ).append("\n"); 
		query.append("               A.CSR_NO AS CSR_NO " ).append("\n"); 
		query.append("          FROM AGT_BROG_COMM A, AGT_BROG_COMM_DTL B, AGT_COMM_BKG_INFO C " ).append("\n"); 
		query.append("         WHERE A.BROG_IF_DT IS NULL " ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        #if(${sts_option} == '1')" ).append("\n"); 
		query.append("             AND A.VSL_DEP_DT BETWEEN TO_DATE(REPLACE(@[search_dt_fr], '-'), 'YYYYMMDD') AND TO_DATE(REPLACE(@[search_dt_to], '-'), 'YYYYMMDD')+0.999999 " ).append("\n"); 
		query.append("        #elseif(${sts_option} == '0')" ).append("\n"); 
		query.append("             AND A.CRE_DT BETWEEN TO_DATE(REPLACE(@[search_dt_fr], '-'), 'YYYYMMDD') AND TO_DATE(REPLACE(@[search_dt_to], '-'), 'YYYYMMDD')+0.999999 " ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("           AND A.COMM_PROC_STS_CD IN('CS','CM','CA') " ).append("\n"); 
		query.append("           AND A.VNDR_SEQ  = @[vndr_seq] 	" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("           AND A.FRT_FWRD_CNT_CD||TO_CHAR(A.FRT_FWRD_SEQ,'FM000000') = @[fwdr] 	" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("           AND A.AP_OFC_CD = @[ap_ofc_cd] 	" ).append("\n"); 
		query.append("           AND A.CRE_USR_ID != 'COST' " ).append("\n"); 
		query.append("           --AND A.CSR_NO IS NOT NULL " ).append("\n"); 
		query.append("           AND C.BL_NO IS NOT NULL " ).append("\n"); 
		query.append("           AND (a.bkg_no, a.brog_seq) IN " ).append("\n"); 
		query.append("               (SELECT bkg_no,   brog_seq " ).append("\n"); 
		query.append("                  FROM agt_brog_comm " ).append("\n"); 
		query.append("                 WHERE brog_if_dt IS NULL " ).append("\n"); 
		query.append("                   AND comm_proc_sts_cd IN('CS','CM','CA') " ).append("\n"); 
		query.append("                   AND vndr_seq  = @[vndr_seq] 	" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("                   AND frt_fwrd_cnt_cd||TO_CHAR(frt_fwrd_seq,'FM000000') = @[fwdr] 	" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("                   AND ap_ofc_cd = @[ap_ofc_cd] 	" ).append("\n"); 
		query.append("                   --AND csr_no is not null " ).append("\n"); 
		query.append("                   AND cre_usr_id != 'COST' " ).append("\n"); 
		query.append("                 ) " ).append("\n"); 
		query.append("           AND a.bkg_no       = b.bkg_no(+) " ).append("\n"); 
		query.append("           AND a.brog_seq     = b.brog_seq(+) " ).append("\n"); 
		query.append("           AND a.bkg_no       = c.bkg_no(+) " ).append("\n"); 
		query.append("       ) x, " ).append("\n"); 
		query.append("       (SELECT csr_no, vndr_no " ).append("\n"); 
		query.append("          FROM ap_inv_hdr " ).append("\n"); 
		query.append("         WHERE csr_no = @[csr_no] 	" ).append("\n"); 
		query.append("       ) y " ).append("\n"); 
		query.append(" WHERE x.vndr = y.vndr_no(+) " ).append("\n"); 
		query.append(" AND   x.csr_no = y.csr_no(+) " ).append("\n"); 
		query.append(") AA" ).append("\n"); 

	}
}