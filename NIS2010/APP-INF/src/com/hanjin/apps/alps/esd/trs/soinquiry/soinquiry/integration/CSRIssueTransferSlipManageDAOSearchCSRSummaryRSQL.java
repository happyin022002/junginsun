/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CSRIssueTransferSlipManageDAOSearchCSRSummaryRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.18
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.18 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.soinquiry.soinquiry.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CSRIssueTransferSlipManageDAOSearchCSRSummaryRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CSR 생성 대상 리스트 조회
	  * </pre>
	  */
	public CSRIssueTransferSlipManageDAOSearchCSRSummaryRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("costOfcCd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndrSeq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("invCfmDt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.soinquiry.soinquiry.integration").append("\n"); 
		query.append("FileName : CSRIssueTransferSlipManageDAOSearchCSRSummaryRSQL").append("\n"); 
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
		query.append("SELECT																									" ).append("\n"); 
		query.append("			VNDR_NO																							" ).append("\n"); 
		query.append("		,	VNDR_SEQ_NAME																					" ).append("\n"); 
		query.append("		,	COUNT(VNDR_NO) CNT_INV																			" ).append("\n"); 
		query.append("		,	PAY_TERM_TP_CD																					" ).append("\n"); 
		query.append("		,	CURR_CD																							" ).append("\n"); 
		query.append("		,	SUM(TOTAL_AMT) TOTAL_AMT																		" ).append("\n"); 
		query.append("		,	GEN_PAY_TERM_CD    																				" ).append("\n"); 
		query.append("		, 	DECODE(GEN_PAY_TERM_CD, 'IN' , TO_CHAR(MAX(INV_ISS_DT) + 5 , 'YYYYMMDD')      					" ).append("\n"); 
		query.append(" 			                      , 'OUT', TO_CHAR(MAX(INV_ISS_DT) + 60, 'YYYYMMDD')     					" ).append("\n"); 
		query.append(" 			                      , 'O60', TO_CHAR(MAX(INV_ISS_DT)	   , 'YYYYMMDD')						" ).append("\n"); 
		query.append(" 			                      , 'O45', TO_CHAR(MAX(INV_ISS_DT)	   , 'YYYYMMDD')						" ).append("\n"); 
		query.append(" 			                      , TO_CHAR(MAX(INV_ISS_DT) + TO_NUMBER(GEN_PAY_TERM_CD), 'YYYYMMDD'))      " ).append("\n"); 
		query.append("	 		PAYMENT_DUE_DT		         																	" ).append("\n"); 
		query.append("		,	SO_OFC_CD		         																		" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		,   (SELECT Y.CONTI_CD                 " ).append("\n"); 
		query.append("               FROM MDM_ORGANIZATION X        " ).append("\n"); 
		query.append("                   ,MDM_LOCATION Y            " ).append("\n"); 
		query.append("              WHERE X.LOC_CD = Y.LOC_CD       " ).append("\n"); 
		query.append("                AND X.OFC_CD = SO_OFC_CD      " ).append("\n"); 
		query.append("        )  CONTI_CD                           " ).append("\n"); 
		query.append(" FROM      (                                                                               " ).append("\n"); 
		query.append("			SELECT																			" ).append("\n"); 
		query.append("						W.INV_NO															" ).append("\n"); 
		query.append("					,	W.INV_VNDR_SEQ VNDR_NO												" ).append("\n"); 
		query.append("					,	M.VNDR_LGL_ENG_NM VNDR_SEQ_NAME										" ).append("\n"); 
		query.append("					,	M.PAY_TERM_TP_CD													" ).append("\n"); 
		query.append("					,	W.INV_CURR_CD CURR_CD												" ).append("\n"); 
		query.append("					,	W.INV_TTL_AMT TOTAL_AMT												" ).append("\n"); 
		query.append("					,	M.GEN_PAY_TERM_CD                                                   " ).append("\n"); 
		query.append("     				,	CASE WHEN LOC.CONTI_CD != 'M'										" ).append("\n"); 
		query.append("     						 THEN W.CRE_OFC_CD                     							" ).append("\n"); 
		query.append("     						 ELSE ORD.CRE_OFC_CD                							" ).append("\n"); 
		query.append("     				    END  SO_OFC_CD							                            " ).append("\n"); 
		query.append("     				,	W.INV_ISS_DT														" ).append("\n"); 
		query.append("         FROM          TRS_TRSP_INV_WRK		W											" ).append("\n"); 
		query.append("					,	MDM_VENDOR				M											" ).append("\n"); 
		query.append("					,	TRS_TRSP_SVC_ORD		ORD											" ).append("\n"); 
		query.append("					,	MDM_LOCATION		    LOC											" ).append("\n"); 
		query.append("         WHERE			W.CRE_OFC_CD						= @[costOfcCd]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${invCfmDt} != '')" ).append("\n"); 
		query.append("		  AND			TO_CHAR(W.INV_CFM_DT,'YYYY-MM-DD')	= @[invCfmDt]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${vndrSeq} != '')" ).append("\n"); 
		query.append("		  AND			W.INV_VNDR_SEQ						= @[vndrSeq]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("         AND			W.TRSP_INV_AUD_STS_CD				= 'CF'                          " ).append("\n"); 
		query.append("         AND			NVL(W.INV_HLD_FLG	, ' ')			<> 'T'                          " ).append("\n"); 
		query.append("         AND			NVL(W.DELT_FLG		, 'N')			= 'N'                           " ).append("\n"); 
		query.append("         AND      		NVL(ORD.DELT_FLG	, 'N')       	= 'N'                           " ).append("\n"); 
		query.append("         AND			W.INV_VNDR_SEQ						= M.VNDR_SEQ                    " ).append("\n"); 
		query.append("         AND			ORD.INV_NO							= W.INV_NO                      " ).append("\n"); 
		query.append("         AND			ORD.INV_VNDR_SEQ					= W.INV_VNDR_SEQ                " ).append("\n"); 
		query.append("         AND			SUBSTR(ORD.TO_NOD_CD,1,5)			= LOC.LOC_CD                    " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("         GROUP BY		W.INV_NO															" ).append("\n"); 
		query.append("					,	W.INV_VNDR_SEQ														" ).append("\n"); 
		query.append("					,	M.VNDR_LGL_ENG_NM													" ).append("\n"); 
		query.append("					,	W.INV_CURR_CD														" ).append("\n"); 
		query.append("					,	M.GEN_PAY_TERM_CD													" ).append("\n"); 
		query.append("					,	M.PAY_TERM_TP_CD													" ).append("\n"); 
		query.append("					,	W.INV_TTL_AMT														" ).append("\n"); 
		query.append("					,	W.INV_ISS_DT														" ).append("\n"); 
		query.append("     				,	CASE WHEN LOC.CONTI_CD != 'M'										" ).append("\n"); 
		query.append("     						 THEN W.CRE_OFC_CD                     							" ).append("\n"); 
		query.append("     						 ELSE ORD.CRE_OFC_CD                							" ).append("\n"); 
		query.append("     				    END         							                            " ).append("\n"); 
		query.append("			UNION ALL																		" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			SELECT																				" ).append("\n"); 
		query.append("						W.INV_NO																" ).append("\n"); 
		query.append("					,	W.INV_VNDR_SEQ 						VNDR_NO								" ).append("\n"); 
		query.append("					,	M.VNDR_LGL_ENG_NM 					VNDR_SEQ_NAME						" ).append("\n"); 
		query.append("					,	M.PAY_TERM_TP_CD					PAY_TERM_TP_CD						" ).append("\n"); 
		query.append("					,	W.INV_CURR_CD 						CURR_CD								" ).append("\n"); 
		query.append("					,	W.INV_TTL_AMT * (-1)				TOTAL_AMT		/* REFUND (-1)	*/	" ).append("\n"); 
		query.append("					,	M.GEN_PAY_TERM_CD       			GEN_PAY_TERM_CD                 	" ).append("\n"); 
		query.append("     				,	NVL(ORD.CRE_OFC_CD, W.CRE_OFC_CD) 	SO_OFC_CD							" ).append("\n"); 
		query.append("     				,	W.INV_ISS_DT						INV_ISS_DT							" ).append("\n"); 
		query.append("			FROM        TRS_TRSP_INV_WRK					W									" ).append("\n"); 
		query.append("					,	MDM_VENDOR							M									" ).append("\n"); 
		query.append("					,	TRS_TRSP_RFND_INV					ORD									" ).append("\n"); 
		query.append("			WHERE		W.CRE_OFC_CD						= @[costOfcCd]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${invCfmDt} != '')" ).append("\n"); 
		query.append("			AND			TO_CHAR(W.INV_CFM_DT,'YYYY-MM-DD')	= @[invCfmDt]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${vndrSeq} != '')" ).append("\n"); 
		query.append("			AND			W.INV_VNDR_SEQ						= @[vndrSeq]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			AND			W.TRSP_INV_AUD_STS_CD				= 'CF'                          " ).append("\n"); 
		query.append("			AND			NVL(W.INV_HLD_FLG,' ')				<> 'T'                          " ).append("\n"); 
		query.append("			AND			NVL(W.DELT_FLG,'N')					= 'N'                           " ).append("\n"); 
		query.append("			AND     	NVL(ORD.DELT_FLG,'N')       		= 'N'                           " ).append("\n"); 
		query.append("			AND			W.INV_VNDR_SEQ						= M.VNDR_SEQ                    " ).append("\n"); 
		query.append("			AND			ORD.INV_NO							= W.INV_NO                      " ).append("\n"); 
		query.append("			AND			ORD.INV_VNDR_SEQ					= W.INV_VNDR_SEQ                " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("           GROUP BY    W.INV_NO															" ).append("\n"); 
		query.append("					,   W.INV_VNDR_SEQ														" ).append("\n"); 
		query.append("					,   W.CRE_OFC_CD														" ).append("\n"); 
		query.append("					,	M.VNDR_LGL_ENG_NM													" ).append("\n"); 
		query.append("					,	W.INV_CURR_CD														" ).append("\n"); 
		query.append("					,	M.GEN_PAY_TERM_CD													" ).append("\n"); 
		query.append("					,	M.PAY_TERM_TP_CD													" ).append("\n"); 
		query.append("					,	ORD.CRE_OFC_CD														" ).append("\n"); 
		query.append("					,	W.INV_TTL_AMT														" ).append("\n"); 
		query.append("					,	W.INV_ISS_DT														" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			UNION ALL																		" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			SELECT		DISTINCT															" ).append("\n"); 
		query.append("						W.INV_NO															" ).append("\n"); 
		query.append("					,	W.INV_VNDR_SEQ														" ).append("\n"); 
		query.append("					,	M.VNDR_LGL_ENG_NM													" ).append("\n"); 
		query.append("					,	M.PAY_TERM_TP_CD                                                    " ).append("\n"); 
		query.append("					,	W.INV_CURR_CD														" ).append("\n"); 
		query.append("					,	W.INV_TTL_AMT														" ).append("\n"); 
		query.append("					,	M.GEN_PAY_TERM_CD                                                   " ).append("\n"); 
		query.append("					,	'NYCRAO'	   			SO_OFC_CD									" ).append("\n"); 
		query.append("     				,	W.INV_ISS_DT														" ).append("\n"); 
		query.append("         FROM          TRS_TRSP_RAIL_INV_WRK	W											" ).append("\n"); 
		query.append("					,	TRS_TRSP_RAIL_INV_DTL  	DTL											" ).append("\n"); 
		query.append("					,	MDM_VENDOR				M											" ).append("\n"); 
		query.append("					,	TRS_TRSP_RAIL_BIL_ORD ORD											" ).append("\n"); 
		query.append("					,	TRS_TRSP_RAIL_BIL_VNDR_SET VNDR										" ).append("\n"); 
		query.append("         WHERE			W.CRE_OFC_CD							= @[costOfcCd]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${invCfmDt} != '')" ).append("\n"); 
		query.append("			AND			TO_CHAR(W.INV_CFM_DT,'YYYY-MM-DD')		= @[invCfmDt]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${vndrSeq} != '')" ).append("\n"); 
		query.append("			AND			W.INV_VNDR_SEQ							= @[vndrSeq]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			AND			W.TRSP_INV_AUD_STS_CD					= 'CF'                      " ).append("\n"); 
		query.append("			AND			NVL(W.INV_HLD_FLG	, ' ')				<> 'T'                      " ).append("\n"); 
		query.append("			AND			NVL(W.DELT_FLG		, 'N')				= 'N'                       " ).append("\n"); 
		query.append("			AND     	NVL(ORD.DELT_FLG	, 'N')     			= 'N'                       " ).append("\n"); 
		query.append("			AND			W.INV_VNDR_SEQ							= M.VNDR_SEQ                " ).append("\n"); 
		query.append("			AND     	W.INV_NO                    			= DTL.INV_NO          				" ).append("\n"); 
		query.append("			AND     	W.INV_VNDR_SEQ              			= DTL.INV_VNDR_SEQ         			" ).append("\n"); 
		query.append("			AND     	DTL.INV_NO                  			= VNDR.INV_NO               (+)     " ).append("\n"); 
		query.append("			AND    		DTL.INV_VNDR_SEQ            			= VNDR.INV_VNDR_SEQ         (+)     " ).append("\n"); 
		query.append("			AND     	DTL.TRSP_SO_OFC_CTY_CD      			= VNDR.TRSP_SO_OFC_CTY_CD   (+)     " ).append("\n"); 
		query.append("			AND     	DTL.TRSP_SO_SEQ             			= VNDR.TRSP_SO_SEQ          (+)     " ).append("\n"); 
		query.append("			AND     	DTL.SUB_INV_SEQ             			= VNDR.SUB_RAIL_SEQ         (+)     " ).append("\n"); 
		query.append("			AND     	DTL.TRSP_SO_OFC_CTY_CD      			= ORD.TRSP_SO_OFC_CTY_CD    (+)     " ).append("\n"); 
		query.append("			AND     	DTL.TRSP_SO_SEQ             			= ORD.TRSP_SO_SEQ           (+)     " ).append("\n"); 
		query.append("			GROUP BY	W.INV_NO															" ).append("\n"); 
		query.append("					,   W.INV_VNDR_SEQ														" ).append("\n"); 
		query.append("					,   W.CRE_OFC_CD														" ).append("\n"); 
		query.append("					,	M.VNDR_LGL_ENG_NM													" ).append("\n"); 
		query.append("					,	W.INV_CURR_CD														" ).append("\n"); 
		query.append("					,	M.GEN_PAY_TERM_CD													" ).append("\n"); 
		query.append("					,	M.PAY_TERM_TP_CD													" ).append("\n"); 
		query.append("					,	ORD.CRE_OFC_CD														" ).append("\n"); 
		query.append("					,	W.INV_TTL_AMT														" ).append("\n"); 
		query.append("					,	W.INV_ISS_DT														" ).append("\n"); 
		query.append("UNION ALL																		" ).append("\n"); 
		query.append("     SELECT                                                                    " ).append("\n"); 
		query.append("           W.INV_NO                                                            " ).append("\n"); 
		query.append("         , W.INV_VNDR_SEQ                      VNDR_NO                         " ).append("\n"); 
		query.append("         , M.VNDR_LGL_ENG_NM                   VNDR_SEQ_NAME                   " ).append("\n"); 
		query.append("         , M.PAY_TERM_TP_CD                    PAY_TERM_TP_CD                  " ).append("\n"); 
		query.append("         , W.INV_CURR_CD                       CURR_CD                         " ).append("\n"); 
		query.append("         , W.INV_TTL_AMT                       TOTAL_AMT                       " ).append("\n"); 
		query.append("         , M.GEN_PAY_TERM_CD                   GEN_PAY_TERM_CD                      " ).append("\n"); 
		query.append("         , NVL(ORD.CRE_OFC_CD, W.CRE_OFC_CD)   SO_OFC_CD                       " ).append("\n"); 
		query.append("         , W.INV_ISS_DT            INV_ISS_DT                                  " ).append("\n"); 
		query.append("     FROM  TRS_TRSP_INV_WRK          W                                         " ).append("\n"); 
		query.append("         , MDM_VENDOR                M                                         " ).append("\n"); 
		query.append("         , TRS_TRSP_POOL_CHSS_INV          ORD                          " ).append("\n"); 
		query.append("     WHERE W.CRE_OFC_CD                = @[costOfcCd]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${invCfmDt} != '')" ).append("\n"); 
		query.append("			AND	TO_CHAR(W.INV_CFM_DT,'YYYY-MM-DD')	= @[invCfmDt]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${vndrSeq} != '')" ).append("\n"); 
		query.append("			AND	W.INV_VNDR_SEQ						= @[vndrSeq]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       AND W.TRSP_INV_AUD_STS_CD       = 'CF'                              " ).append("\n"); 
		query.append("       AND NVL(W.INV_HLD_FLG,' ')     <> 'T'                               " ).append("\n"); 
		query.append("       AND NVL(W.DELT_FLG,'N')         = 'N'                             " ).append("\n"); 
		query.append("       AND NVL(ORD.DELT_FLG,'N')       = 'N'                                           " ).append("\n"); 
		query.append("       AND W.INV_VNDR_SEQ              = M.VNDR_SEQ                     " ).append("\n"); 
		query.append("       AND ORD.INV_NO                  = W.INV_NO                       " ).append("\n"); 
		query.append("       AND ORD.INV_VNDR_SEQ            = W.INV_VNDR_SEQ                 " ).append("\n"); 
		query.append("  GROUP BY W.INV_NO                                                     " ).append("\n"); 
		query.append("         , W.INV_VNDR_SEQ                                               " ).append("\n"); 
		query.append("         , W.CRE_OFC_CD                                                 " ).append("\n"); 
		query.append("         , M.VNDR_LGL_ENG_NM                                             " ).append("\n"); 
		query.append("         , W.INV_CURR_CD                                                 " ).append("\n"); 
		query.append("         , M.GEN_PAY_TERM_CD                                             " ).append("\n"); 
		query.append("         , M.PAY_TERM_TP_CD                                              " ).append("\n"); 
		query.append("         , ORD.CRE_OFC_CD                                                " ).append("\n"); 
		query.append("         , W.INV_TTL_AMT                                                 " ).append("\n"); 
		query.append("         , W.INV_ISS_DT                                                  	" ).append("\n"); 
		query.append("			) A																				" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	GROUP BY	SO_OFC_CD																	" ).append("\n"); 
		query.append("			,	CURR_CD																		" ).append("\n"); 
		query.append("			,	VNDR_NO																		" ).append("\n"); 
		query.append("			,	VNDR_SEQ_NAME																" ).append("\n"); 
		query.append("			,	GEN_PAY_TERM_CD																" ).append("\n"); 
		query.append("			,	PAY_TERM_TP_CD" ).append("\n"); 

	}
}