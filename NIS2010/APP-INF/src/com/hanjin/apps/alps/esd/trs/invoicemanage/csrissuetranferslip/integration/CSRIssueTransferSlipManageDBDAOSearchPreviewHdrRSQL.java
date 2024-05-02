/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : CSRIssueTransferSlipManageDBDAOSearchPreviewHdrRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.07.19
*@LastModifier : 
*@LastVersion : 1.0
* 2017.07.19 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.invoicemanage.csrissuetranferslip.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CSRIssueTransferSlipManageDBDAOSearchPreviewHdrRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CSR HDR 내역을 조회
	  * </pre>
	  */
	public CSRIssueTransferSlipManageDBDAOSearchPreviewHdrRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("NEW_CSR_NO",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("PREVIEW_INDICATOR",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.invoicemanage.csrissuetranferslip.integration").append("\n"); 
		query.append("FileName : CSRIssueTransferSlipManageDBDAOSearchPreviewHdrRSQL").append("\n"); 
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
		query.append("SELECT 		DECODE(@[PREVIEW_INDICATOR], 'PREVIEW', '', CSR_NO)		PRE_CSR_NO       											" ).append("\n"); 
		query.append("			, 	TJ_OFC_CD 								PRE_OFFICE       			 								" ).append("\n"); 
		query.append("			, 	ATTR_CTNT10 							PRE_PRPD_DY       											" ).append("\n"); 
		query.append("			, 	INV_DESC 								PRE_PAY_TO           										" ).append("\n"); 
		query.append("			, 	CSR_TP_CD 								PRE_CSR_TYPE       											" ).append("\n"); 
		query.append("            , (SELECT A.INV_DESC" ).append("\n"); 
		query.append("                 FROM (SELECT D.DTRB_COA_ACCT_CD, MAX(D.INV_DESC) INV_DESC, RANK() OVER(ORDER BY ABS(SUM(D.INV_AMT)) DESC) RNK" ).append("\n"); 
		query.append("                         FROM AP_INV_DTRB D" ).append("\n"); 
		query.append("                        WHERE D.CSR_NO = @[NEW_CSR_NO]" ).append("\n"); 
		query.append("                        GROUP BY D.DTRB_COA_ACCT_CD" ).append("\n"); 
		query.append("                      ) A" ).append("\n"); 
		query.append("                WHERE RNK = 1" ).append("\n"); 
		query.append("                  AND ROWNUM = 1 -- ACOUNT CODE별 동일 금액이 존재 할 경우를 대비해서 추가" ).append("\n"); 
		query.append("              ) PRE_DESC" ).append("\n"); 
		query.append("			, 	PAY_GRP_LU_CD 							PRE_PAY_GROUP   											" ).append("\n"); 
		query.append("			, 	ATTR_CATE_NM 							PRE_EVI_TP       											" ).append("\n"); 
		query.append("			, 	(SELECT ATTR_CTNT1 FROM AP_INV_HDR 		WHERE CSR_NO = @[NEW_CSR_NO]) 	PRE_APPRO_BY        					" ).append("\n"); 
		query.append("			,   (SELECT SUM(CNT) FROM   (                                  " ).append("\n"); 
		query.append("					SELECT COUNT(INV_NO) CNT          " ).append("\n"); 
		query.append("					  FROM TRS_TRSP_INV_WRK           " ).append("\n"); 
		query.append("					 WHERE CSR_NO    = @[NEW_CSR_NO]              " ).append("\n"); 
		query.append("					 UNION ALL                        " ).append("\n"); 
		query.append("					SELECT COUNT(INV_NO) CNT          " ).append("\n"); 
		query.append("					  FROM TRS_TRSP_RAIL_INV_WRK      " ).append("\n"); 
		query.append("					 WHERE CSR_NO = @[NEW_CSR_NO]                 " ).append("\n"); 
		query.append("			      )                                   " ).append("\n"); 
		query.append("		       )     PRE_EVI_TP_COUNT                                     		" ).append("\n"); 
		query.append("			, 	HDR.INV_TERM_DT							PRE_DUE_DATE												" ).append("\n"); 
		query.append("			, 	CASE WHEN HDR.CSR_AMT = 0 AND HDR.ATTR_CTNT2 IS NOT NULL THEN HDR.ATTR_CTNT2						" ).append("\n"); 
		query.append("				END      								PRE_ASA_NO      	 										" ).append("\n"); 
		query.append("			, 	SUBSTR(INV_DT,1,4)||'/'||SUBSTR(INV_DT,5,2)||'/'||SUBSTR(INV_DT,7,2) 	PRE_INV_DT             		" ).append("\n"); 
		query.append("			, 	CSR_CURR_CD  															PRE_CURR_CD      			" ).append("\n"); 
		query.append("			, 	CSR_AMT  																PRE_AMT              		" ).append("\n"); 
		query.append("			, 	DECODE(PAY_DT, '', '', CSR_CURR_CD	)  									PRE_PAY_CURR_CD           	" ).append("\n"); 
		query.append("			, 	DECODE(PAY_DT, '', '', PAY_AMT		)  									PRE_PAY_AMT          		" ).append("\n"); 
		query.append(", 	DECODE(VNDR_CNT_CD, 'US', (CASE WHEN PAY_MZD_CD = 'CHK' OR PAY_MZD_CD = 'CKG' OR PAY_MZD_CD = 'CKO' OR PAY_MZD_CD = 'CMG' OR PAY_MZD_CD = 'CMO'" ).append("\n"); 
		query.append("                                    THEN 'CHK ADDR : '" ).append("\n"); 
		query.append("                                    ELSE 'Payment Method : ' || DECODE(PAY_MZD_CD,'CSH','CASH'" ).append("\n"); 
		query.append("                                                                       ,'CLE','CLEARING'" ).append("\n"); 
		query.append("                                                                       ,'CMA','CMS ACH'" ).append("\n"); 
		query.append("                                                                       ,'EFT','EFT'" ).append("\n"); 
		query.append("                                                                       ,'WIR','WIRE'" ).append("\n"); 
		query.append("                                                                       ,'AUD','AUTO DEBIT'" ).append("\n"); 
		query.append("                                                                       ,'ICO','CMS ICO'" ).append("\n"); 
		query.append("                                                                       ,'IDD','CMS IDD') END)) CHK_MAIL" ).append("\n"); 
		query.append(", 	DECODE(VNDR_CNT_CD, 'US', (CASE WHEN PAY_MZD_CD = 'CHK' OR PAY_MZD_CD = 'CKG' OR PAY_MZD_CD = 'CKO' OR PAY_MZD_CD = 'CMG' OR PAY_MZD_CD = 'CMO'" ).append("\n"); 
		query.append("                                    THEN NVL(CHK_DE_ADDR1, '') ELSE '' END)) CHK_MAIL1" ).append("\n"); 
		query.append(", 	DECODE(VNDR_CNT_CD, 'US', (CASE WHEN PAY_MZD_CD = 'CHK' OR PAY_MZD_CD = 'CKG' OR PAY_MZD_CD = 'CKO' OR PAY_MZD_CD = 'CMG' OR PAY_MZD_CD = 'CMO'" ).append("\n"); 
		query.append("                                    THEN NVL(CHK_DE_ADDR2, '') ELSE '' END)) CHK_MAIL2" ).append("\n"); 
		query.append(", 	DECODE(VNDR_CNT_CD, 'US', (CASE WHEN PAY_MZD_CD = 'CHK' OR PAY_MZD_CD = 'CKG' OR PAY_MZD_CD = 'CKO' OR PAY_MZD_CD = 'CMG' OR PAY_MZD_CD = 'CMO'" ).append("\n"); 
		query.append("                                    THEN NVL(CHK_DE_ADDR3, '') ELSE '' END)) CHK_MAIL3" ).append("\n"); 
		query.append(", 	DECODE(VNDR_CNT_CD, 'US', (CASE WHEN PAY_MZD_CD = 'CHK' OR PAY_MZD_CD = 'CKG' OR PAY_MZD_CD = 'CKO' OR PAY_MZD_CD = 'CMG' OR PAY_MZD_CD = 'CMO'" ).append("\n"); 
		query.append("                                    THEN NVL(CHK_DE_CTY_NM, '') ELSE '' END)) CHK_MAIL4" ).append("\n"); 
		query.append(", 	DECODE(VNDR_CNT_CD, 'US', (CASE WHEN PAY_MZD_CD = 'CHK' OR PAY_MZD_CD = 'CKG' OR PAY_MZD_CD = 'CKO' OR PAY_MZD_CD = 'CMG' OR PAY_MZD_CD = 'CMO'" ).append("\n"); 
		query.append("                                    THEN NVL(CHK_DE_STE_CD, '') ELSE '' END)) CHK_MAIL5" ).append("\n"); 
		query.append(", 	DECODE(VNDR_CNT_CD, 'US', (CASE WHEN PAY_MZD_CD = 'CHK' OR PAY_MZD_CD = 'CKG' OR PAY_MZD_CD = 'CKO' OR PAY_MZD_CD = 'CMG' OR PAY_MZD_CD = 'CMO'" ).append("\n"); 
		query.append("                                    THEN NVL(CHK_DE_ZIP_CD, '') ELSE '' END)) CHK_MAIL6" ).append("\n"); 
		query.append(", 	DECODE(VNDR_CNT_CD, 'US', (CASE WHEN PAY_MZD_CD = 'CHK' OR PAY_MZD_CD = 'CKG' OR PAY_MZD_CD = 'CKO' OR PAY_MZD_CD = 'CMG' OR PAY_MZD_CD = 'CMO'" ).append("\n"); 
		query.append("                                    THEN NVL(CHK_DE_CNT_CD, '') ELSE '' END)) CHK_MAIL7" ).append("\n"); 
		query.append("FROM 		AP_INV_HDR  	HDR               																	" ).append("\n"); 
		query.append("			,   MDM_VENDOR  	VNDR               																	" ).append("\n"); 
		query.append("WHERE 		HDR.VNDR_NO = VNDR.VNDR_SEQ               															" ).append("\n"); 
		query.append("			 AND 		CSR_NO 			= @[NEW_CSR_NO]" ).append("\n"); 

	}
}