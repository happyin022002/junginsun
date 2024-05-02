/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CSRIssueTransferSlipManageDBDAOSearchPreviewHdrRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.11
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.11 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.invoicemanage.csrissuetranferslip.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

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
		query.append("Path : com.clt.apps.opus.esd.trs.invoicemanage.csrissuetranferslip.integration").append("\n"); 
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
		query.append("SELECT PRE_CSR_NO" ).append("\n"); 
		query.append("      ,PRE_OFFICE" ).append("\n"); 
		query.append("      ,PRE_PRPD_DY" ).append("\n"); 
		query.append("      ,IF_STS" ).append("\n"); 
		query.append("      ,PRE_PAY_TO" ).append("\n"); 
		query.append("      ,PRE_CSR_TYPE" ).append("\n"); 
		query.append("      ,PRE_DESC" ).append("\n"); 
		query.append("      ,PRE_PAY_GROUP" ).append("\n"); 
		query.append("      ,PRE_EVI_TP" ).append("\n"); 
		query.append("      ,PRE_APPRO_BY" ).append("\n"); 
		query.append("      ,PRE_EVI_TP_COUNT" ).append("\n"); 
		query.append("      ,PRE_DUE_DATE" ).append("\n"); 
		query.append("      ,PRE_ASA_NO" ).append("\n"); 
		query.append("      ,PRE_INV_DT" ).append("\n"); 
		query.append("      ,PRE_CURR_CD" ).append("\n"); 
		query.append("      ,PRE_AMT" ).append("\n"); 
		query.append("      ,DECODE(IF_STS, 'PD', PRE_PAY_CURR_CD, NULL) PRE_PAY_CURR_CD" ).append("\n"); 
		query.append("      ,DECODE(IF_STS, 'PD', PRE_PAY_AMT, NULL) PRE_PAY_AMT" ).append("\n"); 
		query.append("      ,CHK_MAIL" ).append("\n"); 
		query.append("      ,CHK_MAIL1" ).append("\n"); 
		query.append("      ,CHK_MAIL2" ).append("\n"); 
		query.append("      ,CHK_MAIL3" ).append("\n"); 
		query.append("      ,CHK_MAIL4" ).append("\n"); 
		query.append("      ,CHK_MAIL5" ).append("\n"); 
		query.append("      ,CHK_MAIL6" ).append("\n"); 
		query.append("      ,CHK_MAIL7" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("SELECT 		DECODE(@[PREVIEW_INDICATOR], 'PREVIEW', '', HDR.CSR_NO)		PRE_CSR_NO       											" ).append("\n"); 
		query.append("			, 	TJ_OFC_CD 								PRE_OFFICE       			 								" ).append("\n"); 
		query.append("			, 	ATTR_CTNT10 							PRE_PRPD_DY       											" ).append("\n"); 
		query.append("			, 	(SELECT SUBSTR(MV.VNDR_LGL_ENG_NM, 1, 37) || ' (G5'|| ML.CNT_CD || LPAD(TO_CHAR(MV.VNDR_SEQ),6, '0') || ')'" ).append("\n"); 
		query.append("                   FROM MDM_VENDOR          MV" ).append("\n"); 
		query.append("                       ,MDM_ORGANIZATION    MO" ).append("\n"); 
		query.append("                       ,MDM_LOCATION        ML" ).append("\n"); 
		query.append("                  WHERE TO_NUMBER(HDR.VNDR_NO) = MV.VNDR_SEQ" ).append("\n"); 
		query.append("                    AND MV.OFC_CD = MO.OFC_CD(+)" ).append("\n"); 
		query.append("                    AND MO.LOC_CD = ML.LOC_CD(+) ) AS   PRE_PAY_TO" ).append("\n"); 
		query.append("			, 	CSR_TP_CD 								PRE_CSR_TYPE       											" ).append("\n"); 
		query.append("			, 	( SELECT    DTRB.INV_DESC																			" ).append("\n"); 
		query.append("			      FROM      																						" ).append("\n"); 
		query.append("					(																						" ).append("\n"); 
		query.append("						 SELECT    D.INV_DESC																	" ).append("\n"); 
		query.append("						 FROM      AP_INV_DTRB 		D 															" ).append("\n"); 
		query.append("						 WHERE     D.CSR_NO 		= @[NEW_CSR_NO]" ).append("\n"); 
		query.append("						 ORDER BY  D.INV_AMT        DESC														" ).append("\n"); 
		query.append("					 ) DTRB																					" ).append("\n"); 
		query.append("			      WHERE     ROWNUM < 2																				" ).append("\n"); 
		query.append("		     ) 								        PRE_DESC 													" ).append("\n"); 
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
		query.append("			,	CASE WHEN PAY_DT = '' THEN NULL ELSE  PAY_AMT END   PRE_PAY_AMT    		" ).append("\n"); 
		query.append("			, 	DECODE(VNDR_CNT_CD, 'US', 'CHK ADDR : ') CHK_MAIL       		                    " ).append("\n"); 
		query.append("			, 	DECODE(VNDR_CNT_CD, 'US', NVL(CHK_DE_ADDR1, '')) CHK_MAIL1       		            " ).append("\n"); 
		query.append("			, 	DECODE(VNDR_CNT_CD, 'US', NVL(CHK_DE_ADDR2, '')) CHK_MAIL2       		            " ).append("\n"); 
		query.append("			, 	DECODE(VNDR_CNT_CD, 'US', NVL(CHK_DE_ADDR3, '')) CHK_MAIL3       		            " ).append("\n"); 
		query.append("			, 	DECODE(VNDR_CNT_CD, 'US', NVL(CHK_DE_CTY_NM, '')) CHK_MAIL4       		            " ).append("\n"); 
		query.append("			, 	DECODE(VNDR_CNT_CD, 'US', NVL(CHK_DE_STE_CD, '')) CHK_MAIL5       		            " ).append("\n"); 
		query.append("			, 	DECODE(VNDR_CNT_CD, 'US', NVL(CHK_DE_ZIP_CD, '')) CHK_MAIL6       		            " ).append("\n"); 
		query.append("			, 	DECODE(VNDR_CNT_CD, 'US', NVL(CHK_DE_CNT_CD, '')) CHK_MAIL7    " ).append("\n"); 
		query.append("            ,   CASE" ).append("\n"); 
		query.append("                 WHEN HDR.IF_FLG IS NULL THEN" ).append("\n"); 
		query.append("                  CASE WRK.TRSP_INV_AUD_STS_CD" ).append("\n"); 
		query.append("                    WHEN 'DA' THEN 'DA'" ).append("\n"); 
		query.append("                    ELSE 'AR'" ).append("\n"); 
		query.append("                  END" ).append("\n"); 
		query.append("                 WHEN HDR.IF_FLG = 'Y' AND HDR.RCV_ERR_FLG IS NULL AND WRK.TRSP_INV_AUD_STS_CD = 'PD' THEN 'PD'" ).append("\n"); 
		query.append("                 WHEN HDR.IF_FLG = 'Y' AND HDR.RCV_ERR_FLG IS NULL THEN 'SC'" ).append("\n"); 
		query.append("                 WHEN HDR.IF_FLG = 'E' THEN 'IE'" ).append("\n"); 
		query.append("                 WHEN HDR.RCV_ERR_FLG = 'E' THEN 'RJ'" ).append("\n"); 
		query.append("               END IF_STS   		            " ).append("\n"); 
		query.append("FROM 		AP_INV_HDR  	HDR               																	" ).append("\n"); 
		query.append("			,   MDM_VENDOR  	VNDR  " ).append("\n"); 
		query.append("            , (SELECT CSR_NO, CRE_OFC_CD, TRSP_INV_AUD_STS_CD, INV_NO" ).append("\n"); 
		query.append("                  FROM (SELECT CSR_NO, CRE_OFC_CD, TRSP_INV_AUD_STS_CD, INV_NO" ).append("\n"); 
		query.append("                          FROM TRS_TRSP_RAIL_INV_WRK" ).append("\n"); 
		query.append("							WHERE CSR_NO = @[NEW_CSR_NO]" ).append("\n"); 
		query.append("                        UNION ALL" ).append("\n"); 
		query.append("                        SELECT CSR_NO, CRE_OFC_CD, TRSP_INV_AUD_STS_CD, INV_NO" ).append("\n"); 
		query.append("                          FROM TRS_TRSP_INV_WRK" ).append("\n"); 
		query.append("						  WHERE CSR_NO = @[NEW_CSR_NO]" ).append("\n"); 
		query.append("                         ORDER BY INV_NO) A" ).append("\n"); 
		query.append("                 WHERE ROWNUM = 1) WRK             																	" ).append("\n"); 
		query.append("WHERE 		HDR.VNDR_NO 	= VNDR.VNDR_SEQ   															" ).append("\n"); 
		query.append("			 AND HDR.CSR_NO = @[NEW_CSR_NO]" ).append("\n"); 
		query.append("			 AND HDR.CSR_NO = WRK.CSR_NO(+))" ).append("\n"); 

	}
}