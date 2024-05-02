/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CSRIssueTransferSlipManageDBDAOSearchCSRAPiflistRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.20
*@LastModifier : 
*@LastVersion : 1.0
* 2016.01.20 
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

public class CSRIssueTransferSlipManageDBDAOSearchCSRAPiflistRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CSR 발행내역을 조회
	  * </pre>
	  */
	public CSRIssueTransferSlipManageDBDAOSearchCSRAPiflistRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("FM_EFF_DT",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("TO_EFF_DT",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("APRO_TP_CD",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("CRE_OFC_CD",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.invoicemanage.csrissuetranferslip.integration").append("\n"); 
		query.append("FileName : CSRIssueTransferSlipManageDBDAOSearchCSRAPiflistRSQL").append("\n"); 
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
		query.append("SELECT	 A.CSR_NO CSR_NUMBER                                  " ).append("\n"); 
		query.append("		,A.VNDR_NO" ).append("\n"); 
		query.append("		,(SELECT TRS_COMMON_PKG.GET_VNDR_FULL_NM_FNC(A.VNDR_NO) FROM DUAL) AS VNDR_NM" ).append("\n"); 
		query.append("		,CASE	WHEN A.IF_FLG IS NULL AND A.RQST_APRO_STEP_FLG = 'Y' THEN 'Requesting Approval'" ).append("\n"); 
		query.append("                WHEN A.IF_FLG IS NULL THEN 																	" ).append("\n"); 
		query.append("				       CASE DECODE(NVL(A.CSR_APRO_TP_CD, 'AL'),'GW',DECODE(A.CSR_RJCT_DT,NULL,'XX','DA'), WRK.TRSP_INV_AUD_STS_CD) 	WHEN 'DA' THEN 'Disapproved' 	" ).append("\n"); 
		query.append("											                      ELSE 'Approval Requested' 		" ).append("\n"); 
		query.append("					   END                    			" ).append("\n"); 
		query.append("				WHEN A.IF_FLG 	= 'Y' 	AND A.RCV_ERR_FLG IS NULL THEN 'I/F Success'   			" ).append("\n"); 
		query.append("				WHEN A.IF_FLG 	= 'E'	THEN 'I/F Error'                " ).append("\n"); 
		query.append("				WHEN A.RCV_ERR_FLG = 'E' THEN 'A/P Rejected'" ).append("\n"); 
		query.append("				ELSE 'ALL'                                                         							" ).append("\n"); 
		query.append("		END IF_STS                                                        									" ).append("\n"); 
		query.append("		,CASE	WHEN A.IF_FLG IS NULL AND A.RQST_APRO_STEP_FLG = 'Y' THEN 'RA'" ).append("\n"); 
		query.append("                WHEN A.IF_FLG IS NULL THEN 																	" ).append("\n"); 
		query.append("				   CASE DECODE(NVL(A.CSR_APRO_TP_CD, 'AL'),'GW',DECODE(A.CSR_RJCT_DT,NULL,'XX','DA'), WRK.TRSP_INV_AUD_STS_CD)	WHEN 'DA' THEN 'DA' 			" ).append("\n"); 
		query.append("				   ELSE 'AR' 						" ).append("\n"); 
		query.append("				   END                    			" ).append("\n"); 
		query.append("				WHEN A.IF_FLG 	= 'Y' 	AND A.RCV_ERR_FLG IS NULL THEN 'IF_SUCCESS'   			" ).append("\n"); 
		query.append("				WHEN A.IF_FLG 	= 'E' THEN 'IF_ERROR'	                " ).append("\n"); 
		query.append("				WHEN A.RCV_ERR_FLG = 'E' THEN 'AP_REJECTED'	            " ).append("\n"); 
		query.append("				ELSE 'ALL'                                                         							" ).append("\n"); 
		query.append("		END IF_STS_INDICATOR                                               									" ).append("\n"); 
		query.append("		,C.APRO_RQST_NO                                                     									" ).append("\n"); 
		query.append("		,TO_CHAR(A.IF_DT,'YYYYMMDDHH24MISS') IF_STS_DT                     				" ).append("\n"); 
		query.append("		,DECODE(A.RCV_ERR_FLG, 'E', A.RCV_ERR_RSN, A.IF_ERR_RSN)	IF_ERR_RSN 									" ).append("\n"); 
		query.append("		,COUNT(WRK.INV_NO) INV_CNT                                     " ).append("\n"); 
		query.append("		,A.CSR_CURR_CD			                                            								" ).append("\n"); 
		query.append("		,A.CSR_AMT                                                         									" ).append("\n"); 
		query.append("		,A.INV_TERM_DT PY_DUE_DT                                   " ).append("\n"); 
		query.append("		,A.PAY_GRP_LU_CD PAY_GRP_LU_CD  								" ).append("\n"); 
		query.append("		,A.ATTR_CTNT3	 DATE_OF_TAX    								" ).append("\n"); 
		query.append("		,A.ATTR_CTNT2	 ASA_NO" ).append("\n"); 
		query.append("        ,CASE WHEN F.MST_INV_FILE_ID IS NULL THEN '' ELSE 'O' END MST_INV_FILE_FLG" ).append("\n"); 
		query.append("        ,F.MST_INV_FILE_ID" ).append("\n"); 
		query.append("        ,NVL(A.CSR_APRO_TP_CD, 'AL') AS CSR_APRO_TP_CD" ).append("\n"); 
		query.append("        ,NVL(WRK.COST_OFC_CD,  REPLACE(SUBSTR(A.CSR_NO,4,20), SUBSTR(A.CSR_NO, -11, 11),'')) AS CSR_COST_OFC_CD" ).append("\n"); 
		query.append("        ,MAX(WRK.INV_ISS_DT) AS ISS_DT" ).append("\n"); 
		query.append("        ,MAX(WRK.INV_RCV_DT) AS RCV_DT" ).append("\n"); 
		query.append("        ,A.CSR_USD_AMT" ).append("\n"); 
		query.append("        ,A.ACCT_XCH_RT_YRMON" ).append("\n"); 
		query.append("        ,NVL(A.AGMT_FILE_CFM_CD,'N') AGMT_FILE_CFM_CD" ).append("\n"); 
		query.append("        --,NVL(A.AGMT_DOC_CFM_CD,'N') AGMT_DOC_CFM_CD" ).append("\n"); 
		query.append("        ,( CASE WHEN A.GW_AGMT_DOC_CFM_CD IS NOT NULL" ).append("\n"); 
		query.append("                THEN ( CASE WHEN A.GW_AGMT_DOC_CFM_CD = 'P' THEN 'Y'" ).append("\n"); 
		query.append("                            WHEN A.GW_AGMT_DOC_CFM_CD = 'Y' THEN 'Y'" ).append("\n"); 
		query.append("                            ELSE 'N'" ).append("\n"); 
		query.append("                       END )" ).append("\n"); 
		query.append("                ELSE NVL(A.AGMT_DOC_CFM_CD,'N')" ).append("\n"); 
		query.append("           END ) AGMT_DOC_CFM_CD" ).append("\n"); 
		query.append("        ,(CASE WHEN" ).append("\n"); 
		query.append("        	NVL(( SELECT COUNT(F.ATCH_FILE_ID)" ).append("\n"); 
		query.append("        		FROM COM_AP_FILE_UPLD F" ).append("\n"); 
		query.append("        		WHERE 1=1" ).append("\n"); 
		query.append("        		AND F.AP_FILE_DIV_CD = 'C'" ).append("\n"); 
		query.append("        		AND F.CSR_NO = A.CSR_NO " ).append("\n"); 
		query.append("        		AND F.CSR_FILE_UPLD_TP_CD = 'FU'" ).append("\n"); 
		query.append("                AND NVL(F.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("        	),0) > 0 THEN 'Y'    " ).append("\n"); 
		query.append("    	  ELSE 'N'" ).append("\n"); 
		query.append("          END ) FILE_UPLD_FLG" ).append("\n"); 
		query.append("         ,AP_COM_CHK_ALPS2GW_FNC(A.CSR_NO, @[CRE_OFC_CD]) AS APRO_TYPE_FLG" ).append("\n"); 
		query.append(" FROM 	COM_APRO_CSR_DTL C																				" ).append("\n"); 
		query.append("	   ,COM_APRO_RQST_HDR R" ).append("\n"); 
		query.append("       ,TRS_MST_INV_FILE  F" ).append("\n"); 
		query.append("	   ,AP_INV_HDR 		A																			" ).append("\n"); 
		query.append("	   ,( SELECT CSR_NO                                                      						" ).append("\n"); 
		query.append("			    ,CRE_OFC_CD                                                      					" ).append("\n"); 
		query.append("				,TRSP_INV_AUD_STS_CD                                                      			" ).append("\n"); 
		query.append("			    ,INV_NO" ).append("\n"); 
		query.append("                ,INV_ISS_DT" ).append("\n"); 
		query.append("                ,INV_RCV_DT" ).append("\n"); 
		query.append("                ,COST_OFC_CD        																		" ).append("\n"); 
		query.append("		  FROM    (	SELECT 	CSR_NO , CRE_OFC_CD , TRSP_INV_AUD_STS_CD , INV_NO, INV_ISS_DT, INV_RCV_DT, COST_OFC_CD 					" ).append("\n"); 
		query.append("					FROM 		TRS_TRSP_RAIL_INV_WRK " ).append("\n"); 
		query.append(" 					UNION ALL                                                  							" ).append("\n"); 
		query.append("					SELECT 		CSR_NO , CRE_OFC_CD , TRSP_INV_AUD_STS_CD , INV_NO, INV_ISS_DT, INV_RCV_DT, COST_OFC_CD  					" ).append("\n"); 
		query.append("					FROM 		TRS_TRSP_INV_WRK " ).append("\n"); 
		query.append(" 					ORDER BY 	INV_NO                                            						" ).append("\n"); 
		query.append("					) A                                                             						" ).append("\n"); 
		query.append("		  WHERE CSR_NO IS NOT NULL                                     								" ).append("\n"); 
		query.append("			) WRK                                                               								" ).append("\n"); 
		query.append(" WHERE 	WRK.CSR_NO 	= A.CSR_NO" ).append("\n"); 
		query.append(" AND    A.CSR_NO    = F.CSR_NO(+)" ).append("\n"); 
		query.append(" AND    WRK.CSR_NO 	= C.CSR_NO(+)" ).append("\n"); 
		query.append(" AND 	C.APRO_RQST_NO 	= R.APRO_RQST_NO(+)" ).append("\n"); 
		query.append(" AND	R.SUB_SYS_CD(+) = 'TRS'" ).append("\n"); 
		query.append(" AND 	WRK.CRE_OFC_CD 	= @[CRE_OFC_CD]                                                     						" ).append("\n"); 
		query.append("#if(${DT_STATUS} != '' && ${DT_STATUS} == 'AR') " ).append("\n"); 
		query.append(" AND DECODE(NVL(A.CSR_APRO_TP_CD, 'AL'), 'GW' , A.CSR_APRO_STEP_ASGN_DT, R.RQST_ST_DT ) BETWEEN TO_DATE(@[FM_EFF_DT],'YYYYMMDD') AND TO_DATE(@[TO_EFF_DT],'YYYYMMDD') + 0.99999" ).append("\n"); 
		query.append("#elseif(${DT_STATUS} != '' && ${DT_STATUS} == 'AV') " ).append("\n"); 
		query.append("	AND R.APSTS_CD IN ('C','R')                                        										" ).append("\n"); 
		query.append("	AND R.RQST_END_DT BETWEEN TO_DATE(@[FM_EFF_DT],'YYYYMMDD') AND TO_DATE(@[TO_EFF_DT],'YYYYMMDD') + 0.99999" ).append("\n"); 
		query.append("#elseif(${DT_STATUS} != '' && ${DT_STATUS} == 'IU') " ).append("\n"); 
		query.append("	AND A.IF_DT BETWEEN TO_DATE(@[FM_EFF_DT],'YYYYMMDD') AND TO_DATE(@[TO_EFF_DT],'YYYYMMDD') + 0.99999" ).append("\n"); 
		query.append("#elseif(${DT_STATUS} != '' && ${DT_STATUS} == 'CC') " ).append("\n"); 
		query.append("    AND A.CRE_DT BETWEEN TO_DATE(@[FM_EFF_DT],'YYYYMMDD') AND TO_DATE(@[TO_EFF_DT],'YYYYMMDD') + 0.99999" ).append("\n"); 
		query.append("#elseif(${DT_STATUS} != '' && ${DT_STATUS} == 'RA') " ).append("\n"); 
		query.append("    AND A.CSR_APRO_STEP_ASGN_RQST_DT BETWEEN TO_DATE(@[FM_EFF_DT],'YYYYMMDD') AND TO_DATE(@[TO_EFF_DT],'YYYYMMDD') + 0.99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${IF_STATUS} != '' && ${IF_STATUS} == 'AR')" ).append("\n"); 
		query.append("	AND A.IF_FLG IS NULL    " ).append("\n"); 
		query.append("    AND NVL(A.RQST_APRO_STEP_FLG,'N') = 'N' " ).append("\n"); 
		query.append("    AND DECODE(NVL(A.CSR_APRO_TP_CD, 'AL'), 'GW' ,DECODE(A.CSR_APRO_STEP_ASGN_DT,NULL,NULL,'Y'), C.APRO_RQST_NO ) IS NOT NULL" ).append("\n"); 
		query.append("    AND DECODE(NVL(A.CSR_APRO_TP_CD, 'AL'), 'GW' ,DECODE(A.CSR_APRO_CMPL_DT,NULL,NULL,'Y'), NULL ) IS NULL" ).append("\n"); 
		query.append("    AND DECODE(NVL(A.CSR_APRO_TP_CD, 'AL'), 'GW' ,DECODE(A.CSR_CXL_DT,NULL,NULL,'Y'),NULL ) IS NULL " ).append("\n"); 
		query.append("    AND DECODE(NVL(A.CSR_APRO_TP_CD, 'AL'), 'GW' ,DECODE(A.CSR_RJCT_DT,NULL,NULL,'Y'), DECODE(WRK.TRSP_INV_AUD_STS_CD,'DA','Y', NULL) ) IS NULL     " ).append("\n"); 
		query.append("#elseif(${IF_STATUS} != '' && ${IF_STATUS} == 'DA')" ).append("\n"); 
		query.append("	AND A.IF_FLG IS NULL    " ).append("\n"); 
		query.append("    AND DECODE(NVL(A.CSR_APRO_TP_CD, 'AL'),'GW',DECODE(A.CSR_RJCT_DT,NULL,'XX','DA'), WRK.TRSP_INV_AUD_STS_CD) = 'DA'                								" ).append("\n"); 
		query.append("#elseif(${IF_STATUS} != '' && ${IF_STATUS} == 'SC')" ).append("\n"); 
		query.append("	AND A.IF_FLG = 'Y' " ).append("\n"); 
		query.append("    AND A.RCV_ERR_FLG IS NULL                              								" ).append("\n"); 
		query.append("#elseif(${IF_STATUS} != '' && ${IF_STATUS} == 'IE')" ).append("\n"); 
		query.append("	AND A.IF_FLG = 'E'                                                      								" ).append("\n"); 
		query.append("#elseif(${IF_STATUS} != '' && ${IF_STATUS} == 'RJ')" ).append("\n"); 
		query.append("	AND A.RCV_ERR_FLG = 'E' " ).append("\n"); 
		query.append("#elseif(${IF_STATUS} != '' and ${IF_STATUS} == 'RA') " ).append("\n"); 
		query.append("	AND A.IF_FLG IS NULL " ).append("\n"); 
		query.append("    AND A.RQST_APRO_STEP_FLG = 'Y'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ($CSR_NO.size() > 0) " ).append("\n"); 
		query.append("	AND	A.CSR_NO IN	(" ).append("\n"); 
		query.append("		#foreach( ${key} in ${CSR_NO}) " ).append("\n"); 
		query.append("			#if($velocityCount < $CSR_NO.size()) " ).append("\n"); 
		query.append("				'$key', " ).append("\n"); 
		query.append("			#else " ).append("\n"); 
		query.append("				'$key' " ).append("\n"); 
		query.append("			#end " ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${APRO_TP_CD} != '')" ).append("\n"); 
		query.append("AND NVL(A.CSR_APRO_TP_CD,'AL') =  @[APRO_TP_CD]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("GROUP BY                                             															" ).append("\n"); 
		query.append("		 A.CSR_NO																							" ).append("\n"); 
		query.append("		,A.VNDR_NO																							" ).append("\n"); 
		query.append("		,A.IF_FLG																							" ).append("\n"); 
		query.append("		,A.RCV_ERR_FLG																						" ).append("\n"); 
		query.append("		,A.IF_DT																								" ).append("\n"); 
		query.append("		,A.IF_ERR_RSN																						" ).append("\n"); 
		query.append("		,A.CSR_CURR_CD																						" ).append("\n"); 
		query.append("		,A.CSR_AMT																							" ).append("\n"); 
		query.append("		,A.INV_TERM_DT																						" ).append("\n"); 
		query.append("		,A.VNDR_TERM_NM																						" ).append("\n"); 
		query.append("		,A.PAY_MZD_LU_CD																						" ).append("\n"); 
		query.append("		,A.PAY_GRP_LU_CD																						" ).append("\n"); 
		query.append("		,A.ATTR_CTNT3																						" ).append("\n"); 
		query.append("		,A.ATTR_CTNT2																						" ).append("\n"); 
		query.append("		,WRK.TRSP_INV_AUD_STS_CD" ).append("\n"); 
		query.append("		,C.APRO_RQST_NO	                            													                      													" ).append("\n"); 
		query.append("		,A.RCV_ERR_RSN" ).append("\n"); 
		query.append("        ,F.MST_INV_FILE_ID" ).append("\n"); 
		query.append("        ,A.RQST_APRO_STEP_FLG" ).append("\n"); 
		query.append("        ,A.CSR_APRO_TP_CD" ).append("\n"); 
		query.append("        ,A.CSR_USD_AMT" ).append("\n"); 
		query.append("        ,A.ACCT_XCH_RT_YRMON" ).append("\n"); 
		query.append("        ,WRK.COST_OFC_CD" ).append("\n"); 
		query.append("        ,A.CSR_RJCT_DT" ).append("\n"); 
		query.append("        ,A.AGMT_DOC_CFM_CD" ).append("\n"); 
		query.append("        ,A.GW_AGMT_DOC_CFM_CD" ).append("\n"); 
		query.append("        ,A.AGMT_FILE_CFM_CD" ).append("\n"); 
		query.append("ORDER BY A.CSR_NO ASC" ).append("\n"); 

	}
}