/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CARIssueTransferSlipManageDBDAOSearchPreviewHDRRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.11
*@LastModifier : 
*@LastVersion : 1.0
* 2016.02.11 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CARIssueTransferSlipManageDBDAOSearchPreviewHDRRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchPreviewHDR
	  * </pre>
	  */
	public CARIssueTransferSlipManageDBDAOSearchPreviewHDRRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("csr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.integration").append("\n"); 
		query.append("FileName : CARIssueTransferSlipManageDBDAOSearchPreviewHDRRSQL").append("\n"); 
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
		query.append("		CSR_NO	PRE_CSR_NO" ).append("\n"); 
		query.append("		, ''	PRE_OFFICE" ).append("\n"); 
		query.append("		, ATTR_CTNT10 PRE_PRPD_DY" ).append("\n"); 
		query.append("		--, (SELECT DECODE(VNDR_CNT_CD,'KR',VNDR_LOCL_LANG_NM,VNDR_LGL_ENG_NM) FROM  MDM_VENDOR  WHERE  VNDR_SEQ = VNDR_NO)  PRE_PAY_TO" ).append("\n"); 
		query.append("        ,(  SELECT DECODE(MV.VNDR_CNT_CD,'KR',SUBSTRB(MV.VNDR_LOCL_LANG_NM, 1, 37) , SUBSTRB(MV.VNDR_LGL_ENG_NM, 1, 37) )  || ' (G5'|| ML.CNT_CD || LPAD(TO_CHAR(MV.VNDR_SEQ),6, '0') || ')' AS VENDOR_NAME " ).append("\n"); 
		query.append("            FROM      " ).append("\n"); 
		query.append("                         MDM_VENDOR MV ," ).append("\n"); 
		query.append("                         MDM_ORGANIZATION MO ," ).append("\n"); 
		query.append("                         MDM_LOCATION ML" ).append("\n"); 
		query.append("            WHERE     1=1" ).append("\n"); 
		query.append("            AND       MV.OFC_CD = MO.OFC_CD(+)" ).append("\n"); 
		query.append("            AND       MO.LOC_CD = ML.LOC_CD(+)" ).append("\n"); 
		query.append("            AND       MV.VNDR_SEQ = H.VNDR_NO" ).append("\n"); 
		query.append("			AND       ROWNUM=1  " ).append("\n"); 
		query.append("          ) PRE_PAY_TO" ).append("\n"); 
		query.append("		, CSR_TP_CD PRE_CSR_TYPE" ).append("\n"); 
		query.append("		, ( SELECT (SELECT M.ACCT_ENG_NM FROM MDM_ACCOUNT M WHERE ACCT_CD = DTRB_COA_ACCT_CD)" ).append("\n"); 
		query.append("			FROM (" ).append("\n"); 
		query.append("					SELECT SUM(INV_AMT) SUM_AMT, DTRB_COA_ACCT_CD" ).append("\n"); 
		query.append("					FROM AP_INV_DTRB D WHERE CSR_NO = @[csr_no]" ).append("\n"); 
		query.append("					GROUP BY D.DTRB_COA_CO_CD, D.DTRB_COA_RGN_CD, D.DTRB_COA_CTR_CD, D.DTRB_COA_ACCT_CD, D.DTRB_COA_INTER_CO_CD" ).append("\n"); 
		query.append("							, D.DTRB_COA_VVD_CD, D.INV_DESC, D.ATTR_CTNT3, D.ATTR_CTNT1, D.LINE_NO" ).append("\n"); 
		query.append("					--ORDER BY SUM_AMT DESC  --20160211 CSR Type이 CREDIT일때,즉(-)amount 일때 Prepaid VAT가 먼저 나와서 아래처럼 수정함" ).append("\n"); 
		query.append("					ORDER BY LINE_NO ASC" ).append("\n"); 
		query.append("				) A WHERE ROWNUM = 1" ).append("\n"); 
		query.append("			) PRE_DESC" ).append("\n"); 
		query.append("		, PAY_GRP_LU_CD PRE_PAY_GROUP" ).append("\n"); 
		query.append("		, ATTR_CATE_NM PRE_EVI_TP" ).append("\n"); 
		query.append("		, ( SELECT DECODE(SUBSTR(VNDR_TERM_NM,1,1),'O','',TO_CHAR(A.ISS_DT+VNDR_TERM_NM,'YYYY/MM/DD'))" ).append("\n"); 
		query.append("			FROM	(SELECT MAX(ISS_DT) ISS_DT, VNDR_SEQ FROM TES_TML_SO_HDR WHERE CSR_NO = @[csr_no] AND NVL(DELT_FLG,'N') <> 'Y' GROUP BY VNDR_SEQ) A, MDM_VENDOR B" ).append("\n"); 
		query.append("			WHERE A.VNDR_SEQ = B.VNDR_SEQ )  PRE_DUE_DATE" ).append("\n"); 
		query.append("		, CASE" ).append("\n"); 
		query.append("			WHEN (CSR_AMT = 0 AND ATTR_CTNT2 IS NOT NULL) THEN ATTR_CTNT2" ).append("\n"); 
		query.append("		  END AS  PRE_ASA_NO" ).append("\n"); 
		query.append("		, SUBSTR(INV_DT,1,4)||'/'||SUBSTR(INV_DT,5,2)||'/'||SUBSTR(INV_DT,7,2) PRE_INV_DT" ).append("\n"); 
		query.append("		, CSR_CURR_CD  PRE_CURR_CD" ).append("\n"); 
		query.append("		, CSR_AMT  PRE_AMT" ).append("\n"); 
		query.append("		, DECODE(PAY_DT,'','',CSR_CURR_CD)  PRE_PAY_CURR_CD" ).append("\n"); 
		query.append("		, DECODE(PAY_DT,'','',PAY_AMT)  PRE_PAY_AMT" ).append("\n"); 
		query.append("		, ATTR_CTNT1  APRO_STEP" ).append("\n"); 
		query.append("	   , DECODE( VNDR_CNT_CD, 'US', 'CHK ADDR : ' || NVL(CHK_DE_ADDR1, '') , '' ) AS CHK_ADDR1" ).append("\n"); 
		query.append("	   , DECODE( VNDR_CNT_CD, 'US', NVL(CHK_DE_ADDR2, '') , '' ) AS CHK_ADDR2" ).append("\n"); 
		query.append("	   , DECODE( VNDR_CNT_CD, 'US', NVL(CHK_DE_ADDR3, '') , '' ) AS CHK_ADDR3" ).append("\n"); 
		query.append("	   , DECODE( VNDR_CNT_CD, 'US', NVL(CHK_DE_CTY_NM, '') , '' ) AS CHK_CTY_NM" ).append("\n"); 
		query.append("	   , DECODE( VNDR_CNT_CD, 'US', NVL(CHK_DE_STE_CD, '') , '' ) AS CHK_STE_CD" ).append("\n"); 
		query.append("	   , DECODE( VNDR_CNT_CD, 'US', NVL(CHK_DE_ZIP_CD, '') , '' ) AS CHK_ZIP_CD" ).append("\n"); 
		query.append("	   , DECODE( VNDR_CNT_CD, 'US', NVL(CHK_DE_CNT_CD, '') , '' ) AS CHK_CNT_CD" ).append("\n"); 
		query.append("FROM	AP_INV_HDR H" ).append("\n"); 
		query.append("		, MDM_VENDOR V" ).append("\n"); 
		query.append("WHERE	H.VNDR_NO	= V.VNDR_SEQ" ).append("\n"); 
		query.append("AND	CSR_NO	= @[csr_no]" ).append("\n"); 

	}
}