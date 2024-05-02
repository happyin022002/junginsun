/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CSRIssueTransferSlipManageDBDAOSearchCSRAPiflistRSQL.java
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
		params.put("CRE_OFC_CD",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.invoicemanage.csrissuetranferslip.integration").append("\n"); 
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
		query.append("SELECT					                                                										" ).append("\n"); 
		query.append("		A.CSR_NO CSR_NUMBER                                  " ).append("\n"); 
		query.append("		,A.VNDR_NO" ).append("\n"); 
		query.append("		,(SELECT TRS_COMMON_PKG.GET_VNDR_FULL_NM_FNC(A.VNDR_NO) FROM DUAL) AS VNDR_NM" ).append("\n"); 
		query.append("		,CASE	WHEN A.IF_FLG IS NULL THEN 																	" ).append("\n"); 
		query.append("					CASE WRK.TRSP_INV_AUD_STS_CD 	WHEN 'DA' THEN 'Disapproved' 	" ).append("\n"); 
		query.append("													ELSE 'Approval Requested' 		" ).append("\n"); 
		query.append("					END" ).append("\n"); 
		query.append("				WHEN A.IF_FLG   = 'Y'   AND A.RCV_ERR_FLG IS NULL AND WRK.TRSP_INV_AUD_STS_CD = 'PD' THEN 'Paid'" ).append("\n"); 
		query.append("				WHEN A.IF_FLG 	= 'Y' 	AND A.RCV_ERR_FLG IS NULL THEN 'I/F Success'   			" ).append("\n"); 
		query.append("				WHEN A.IF_FLG 	= 'E'	 THEN 'I/F Error'                " ).append("\n"); 
		query.append("				WHEN A.RCV_ERR_FLG = 'E' THEN 'A/P Rejected'             " ).append("\n"); 
		query.append("				ELSE 'ALL'                                                         							" ).append("\n"); 
		query.append("		END IF_STS                                                        									" ).append("\n"); 
		query.append("		,CASE	WHEN A.IF_FLG IS NULL THEN 																	" ).append("\n"); 
		query.append("				CASE WRK.TRSP_INV_AUD_STS_CD 	WHEN 'DA' THEN 'DA' 			" ).append("\n"); 
		query.append("												ELSE 'AR' 						" ).append("\n"); 
		query.append("												END                    			" ).append("\n"); 
		query.append("				WHEN A.IF_FLG 	= 'Y' 	AND A.RCV_ERR_FLG IS NULL THEN 'IF_SUCCESS'   			" ).append("\n"); 
		query.append("				WHEN A.IF_FLG 	= 'E' THEN 'IF_ERROR'	                " ).append("\n"); 
		query.append("				WHEN A.RCV_ERR_FLG = 'E' THEN 'AP_REJECTED'	            " ).append("\n"); 
		query.append("				ELSE 'ALL'                                                         							" ).append("\n"); 
		query.append("		END IF_STS_INDICATOR                                               									" ).append("\n"); 
		query.append("		,C.APRO_RQST_NO                                                     									" ).append("\n"); 
		query.append("		,TO_CHAR(A.IF_DT,'YYYYMMDDHH24MISS') IF_STS_DT                     				" ).append("\n"); 
		query.append("		,DECODE(A.RCV_ERR_FLG, 'E', A.RCV_ERR_RSN, A.IF_ERR_RSN)	IF_ERR_RSN" ).append("\n"); 
		query.append("        ,TO_CHAR(A.CRE_DT,'YYYYMMDDHH24MISS') CSR_CRE_DT 									" ).append("\n"); 
		query.append("        ,R.RQST_USR_ID" ).append("\n"); 
		query.append("        ,R.RQST_USR_NM" ).append("\n"); 
		query.append("        ,APR.APRO_USR_ID" ).append("\n"); 
		query.append("        ,APR.APRO_USR_NM" ).append("\n"); 
		query.append("		,COUNT(WRK.INV_NO) INV_CNT                                     " ).append("\n"); 
		query.append("		,A.CSR_CURR_CD			                                            								" ).append("\n"); 
		query.append("		,A.CSR_AMT                                                         									" ).append("\n"); 
		query.append("		,A.INV_TERM_DT PY_DUE_DT                                   " ).append("\n"); 
		query.append("		,A.PAY_GRP_LU_CD PAY_GRP_LU_CD  								" ).append("\n"); 
		query.append("		,A.ATTR_CTNT3	 DATE_OF_TAX    								" ).append("\n"); 
		query.append("		,A.ATTR_CTNT2	 ASA_NO        								" ).append("\n"); 
		query.append(" FROM 	COM_APRO_CSR_DTL 	C																				" ).append("\n"); 
		query.append("		,COM_APRO_RQST_HDR 	R																				" ).append("\n"); 
		query.append("        ,COM_APRO_RQST_ROUT APR" ).append("\n"); 
		query.append("		,AP_INV_HDR 			A																				" ).append("\n"); 
		query.append("		,( 		SELECT 		CSR_NO                                                      						" ).append("\n"); 
		query.append("							,CRE_OFC_CD                                                      					" ).append("\n"); 
		query.append("							,TRSP_INV_AUD_STS_CD                                                      			" ).append("\n"); 
		query.append("						    ,INV_NO         																		" ).append("\n"); 
		query.append("				FROM    (		SELECT 		CSR_NO , CRE_OFC_CD , TRSP_INV_AUD_STS_CD , INV_NO  					" ).append("\n"); 
		query.append("							FROM 		TRS_TRSP_RAIL_INV_WRK                                 					" ).append("\n"); 
		query.append("							UNION ALL                                                  							" ).append("\n"); 
		query.append("							SELECT 		CSR_NO , CRE_OFC_CD , TRSP_INV_AUD_STS_CD , INV_NO  					" ).append("\n"); 
		query.append("							FROM 		TRS_TRSP_INV_WRK                                      					" ).append("\n"); 
		query.append("							ORDER BY 	INV_NO                                            						" ).append("\n"); 
		query.append("						) A                                                             						" ).append("\n"); 
		query.append("				WHERE		CSR_NO IS NOT NULL                                        								" ).append("\n"); 
		query.append("			) WRK                                                               								" ).append("\n"); 
		query.append(" WHERE 		WRK.CSR_NO 		= C.CSR_NO                                              						" ).append("\n"); 
		query.append(" AND 		WRK.CSR_NO 		= A.CSR_NO                                              						" ).append("\n"); 
		query.append(" AND 		C.APRO_RQST_NO 	= R.APRO_RQST_NO    " ).append("\n"); 
		query.append(" AND		R.APRO_RQST_NO  = APR.APRO_RQST_NO" ).append("\n"); 
		query.append(" AND		R.SUB_SYS_CD 	= 'TRS'                                							" ).append("\n"); 
		query.append(" AND 		WRK.CRE_OFC_CD 	= @[CRE_OFC_CD]                                                     						" ).append("\n"); 
		query.append("#if(${DT_STATUS} != '' && ${DT_STATUS} == 'AR') " ).append("\n"); 
		query.append("	 	AND 		R.RQST_ST_DT BETWEEN TO_DATE(@[FM_EFF_DT],'YYYYMMDD') AND TO_DATE(@[TO_EFF_DT],'YYYYMMDD') + 0.99999" ).append("\n"); 
		query.append("#elseif(${DT_STATUS} != '' && ${DT_STATUS} == 'AV') " ).append("\n"); 
		query.append("	 	AND 		R.APSTS_CD IN ('C','R')                                        										" ).append("\n"); 
		query.append("		AND			R.RQST_END_DT BETWEEN TO_DATE(@[FM_EFF_DT],'YYYYMMDD') AND TO_DATE(@[TO_EFF_DT],'YYYYMMDD') + 0.99999" ).append("\n"); 
		query.append("#elseif(${DT_STATUS} != '' && ${DT_STATUS} == 'IU') " ).append("\n"); 
		query.append("	 	AND 		A.IF_DT BETWEEN TO_DATE(@[FM_EFF_DT],'YYYYMMDD') AND TO_DATE(@[TO_EFF_DT],'YYYYMMDD') + 0.99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${IF_STATUS} != '' && ${IF_STATUS} == 'AR')" ).append("\n"); 
		query.append("	 	AND 		A.IF_FLG IS NULL    " ).append("\n"); 
		query.append("        AND 		WRK.TRSP_INV_AUD_STS_CD = 'AR'" ).append("\n"); 
		query.append("#elseif(${IF_STATUS} != '' && ${IF_STATUS} == 'DA')" ).append("\n"); 
		query.append("	 	AND 		A.IF_FLG IS NULL    " ).append("\n"); 
		query.append("        AND WRK.TRSP_INV_AUD_STS_CD = 'DA'                								" ).append("\n"); 
		query.append("#elseif(${IF_STATUS} != '' && ${IF_STATUS} == 'SC')" ).append("\n"); 
		query.append("	 	AND 		A.IF_FLG = 'Y' " ).append("\n"); 
		query.append("        AND 		A.RCV_ERR_FLG IS NULL" ).append("\n"); 
		query.append("		AND         NVL(WRK.TRSP_INV_AUD_STS_CD, 'XX') <> 'PD'" ).append("\n"); 
		query.append("#elseif(${IF_STATUS} != '' && ${IF_STATUS} == 'PD')" ).append("\n"); 
		query.append("	 	AND 		A.IF_FLG = 'Y' " ).append("\n"); 
		query.append("        AND 		A.RCV_ERR_FLG IS NULL" ).append("\n"); 
		query.append("		AND         WRK.TRSP_INV_AUD_STS_CD = 'PD'" ).append("\n"); 
		query.append("#elseif(${IF_STATUS} != '' && ${IF_STATUS} == 'IE')" ).append("\n"); 
		query.append("	 	AND 		A.IF_FLG = 'E'                                                      								" ).append("\n"); 
		query.append("#elseif(${IF_STATUS} != '' && ${IF_STATUS} == 'RJ')" ).append("\n"); 
		query.append("	 	AND 		A.RCV_ERR_FLG = 'E'                                                 								" ).append("\n"); 
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
		query.append("GROUP BY                                             															" ).append("\n"); 
		query.append("		A.CSR_NO																							" ).append("\n"); 
		query.append("		,A.VNDR_NO																							" ).append("\n"); 
		query.append("		,A.IF_FLG																							" ).append("\n"); 
		query.append("		,A.RCV_ERR_FLG																						" ).append("\n"); 
		query.append("		,A.IF_DT																								" ).append("\n"); 
		query.append("		,A.IF_ERR_RSN" ).append("\n"); 
		query.append("        ,A.CRE_DT																						" ).append("\n"); 
		query.append("        ,R.RQST_USR_ID" ).append("\n"); 
		query.append("        ,R.RQST_USR_NM" ).append("\n"); 
		query.append("        ,APR.APRO_USR_ID" ).append("\n"); 
		query.append("        ,APR.APRO_USR_NM" ).append("\n"); 
		query.append("		,A.CSR_CURR_CD																						" ).append("\n"); 
		query.append("		,A.CSR_AMT																							" ).append("\n"); 
		query.append("		,A.INV_TERM_DT																						" ).append("\n"); 
		query.append("		,A.VNDR_TERM_NM																						" ).append("\n"); 
		query.append("		,A.PAY_MZD_LU_CD																						" ).append("\n"); 
		query.append("		,A.PAY_GRP_LU_CD																						" ).append("\n"); 
		query.append("		,A.ATTR_CTNT3																						" ).append("\n"); 
		query.append("		,A.ATTR_CTNT2																						" ).append("\n"); 
		query.append("		,WRK.TRSP_INV_AUD_STS_CD                            													" ).append("\n"); 
		query.append("		,C.APRO_RQST_NO		                            													" ).append("\n"); 
		query.append("		,A.RCV_ERR_RSN		                            													" ).append("\n"); 
		query.append("ORDER BY	 A.CSR_NO ASC" ).append("\n"); 

	}
}