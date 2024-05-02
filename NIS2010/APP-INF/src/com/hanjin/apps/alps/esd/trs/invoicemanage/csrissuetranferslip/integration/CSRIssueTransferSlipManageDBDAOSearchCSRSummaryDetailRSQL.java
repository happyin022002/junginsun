/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CSRIssueTransferSlipManageDBDAOSearchCSRSummaryDetailRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.07
*@LastModifier : 
*@LastVersion : 1.0
* 2016.01.07 
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

public class CSRIssueTransferSlipManageDBDAOSearchCSRSummaryDetailRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CSR 생성 대상 리스트 상세조회
	  * </pre>
	  */
	public CSRIssueTransferSlipManageDBDAOSearchCSRSummaryDetailRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("INV_CURR_CD",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("INV_OFC_CD",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("COST_OFC_CD",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("INV_VNDR_SEQ",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("INV_CFM_DT",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.invoicemanage.csrissuetranferslip.integration").append("\n"); 
		query.append("FileName : CSRIssueTransferSlipManageDBDAOSearchCSRSummaryDetailRSQL").append("\n"); 
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
		query.append("SELECT	INV_NO                         																" ).append("\n"); 
		query.append(" 		,	INV_VNDR_SEQ                         														" ).append("\n"); 
		query.append(" 		,	WO_VNDR_SEQ                         														" ).append("\n"); 
		query.append(" 		,	DECODE(INV_INDICATOR, 'RF', INV_BZC_AMT      * (-1)	, INV_BZC_AMT	  ) INV_BZC_AMT        	" ).append("\n"); 
		query.append(" 		,	DECODE(INV_INDICATOR, 'RF', INV_VAT_AMT      * (-1)	, INV_VAT_AMT	  ) INV_VAT_AMT         " ).append("\n"); 
		query.append(" 		,	DECODE(INV_INDICATOR, 'RF', INV_WHLD_TAX_AMT * (-1) , INV_WHLD_TAX_AMT)	INV_WHLD_TAX_AMT    " ).append("\n"); 
		query.append(" 		,	DECODE(INV_INDICATOR, 'RF', INV_SBC_AMT          * (-1) , INV_SBC_AMT         )	INV_SBC_AMT" ).append("\n"); 
		query.append(" 		,	DECODE(INV_INDICATOR, 'RF', INV_TTL_AMT		 * (-1)	, INV_TTL_AMT	  ) INV_TTL_AMT         " ).append("\n"); 
		query.append(" 		,	INV_CFM_DT                 												" ).append("\n"); 
		query.append(" 		,	INV_RCV_DT                 												" ).append("\n"); 
		query.append(" 		,	INV_ISS_DT																" ).append("\n"); 
		query.append(" 		,	ACCT_CD_EMPTY_CNT														" ).append("\n"); 
		query.append("	FROM (																			" ).append("\n"); 
		query.append(" 			SELECT	DISTINCT                         								" ).append("\n"); 
		query.append(" 					W.INV_NO                         								" ).append("\n"); 
		query.append(" 				,	W.INV_VNDR_SEQ                         							" ).append("\n"); 
		query.append(" 				,	W.WO_VNDR_SEQ                         							" ).append("\n"); 
		query.append(" 				,	W.INV_BZC_AMT INV_BZC_AMT                         				" ).append("\n"); 
		query.append(" 				,	W.INV_VAT_AMT INV_VAT_AMT                         				" ).append("\n"); 
		query.append(" 				,	W.INV_WHLD_TAX_AMT INV_WHLD_TAX_AMT                         	" ).append("\n"); 
		query.append(" 				,	W.INV_SBC_AMT INV_SBC_AMT" ).append("\n"); 
		query.append(" 				,	W.INV_TTL_AMT INV_TTL_AMT                         				" ).append("\n"); 
		query.append(" 				,	TO_CHAR(W.INV_CFM_DT,'YYYYMMDD') INV_CFM_DT                 	" ).append("\n"); 
		query.append(" 				,	TO_CHAR(W.INV_RCV_DT,'YYYYMMDD') INV_RCV_DT                 	" ).append("\n"); 
		query.append(" 				,	TO_CHAR(W.INV_ISS_DT,'YYYYMMDD') INV_ISS_DT						" ).append("\n"); 
		query.append(" 				,  (SELECT 	COUNT(INV_NO) 											" ).append("\n"); 
		query.append(" 					FROM   	TRS_TRSP_SVC_ORD 	 	X								" ).append("\n"); 
		query.append(" 					WHERE  	X.INV_NO				= W.INV_NO						" ).append("\n"); 
		query.append(" 					AND    	X.INV_VNDR_SEQ        	= W.INV_VNDR_SEQ				" ).append("\n"); 
		query.append(" 					AND    (X.ACCT_CD            	IS NULL							" ).append("\n"); 
		query.append(" 			       			OR														" ).append("\n"); 
		query.append(" 			        		X.LGS_COST_CD        	IS NULL							" ).append("\n"); 
		query.append(" 			       			)       												" ).append("\n"); 
		query.append(" 			 		)  ACCT_CD_EMPTY_CNT											" ).append("\n"); 
		query.append(" 				,	NVL2(RF.INV_NO, 'RF', 'IV') 	INV_INDICATOR                   " ).append("\n"); 
		query.append("#if(${CONTI_CD} == 'M')" ).append("\n"); 
		query.append("	 				,	NVL(ORD.CRE_OFC_CD, W.CRE_OFC_CD) 	COST_OFC_CD                 " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" 			FROM	TRS_TRSP_INV_WRK				W                        		" ).append("\n"); 
		query.append(" 				,	TRS_TRSP_RFND_INV    			RF                        		" ).append("\n"); 
		query.append("#if(${CONTI_CD} == 'M')" ).append("\n"); 
		query.append("					,	TRS_TRSP_SVC_ORD				ORD								" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" 			WHERE	W.INV_NO              			= RF.INV_NO        (+)  		" ).append("\n"); 
		query.append(" 			AND		W.INV_VNDR_SEQ        			= RF.INV_VNDR_SEQ  (+)	        " ).append("\n"); 
		query.append("#if(${CONTI_CD} == 'M')" ).append("\n"); 
		query.append("	 	        AND		W.INV_NO						= ORD.INV_NO       (+)          " ).append("\n"); 
		query.append("	 	        AND		W.INV_VNDR_SEQ				    = ORD.INV_VNDR_SEQ (+)          " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" 			AND		W.CRE_OFC_CD					= @[INV_OFC_CD]" ).append("\n"); 
		query.append(" 			AND		W.INV_VNDR_SEQ					= @[INV_VNDR_SEQ]" ).append("\n"); 
		query.append(" 			AND		W.INV_CURR_CD					= @[INV_CURR_CD]" ).append("\n"); 
		query.append("#if(${INV_CFM_DT} != '')" ).append("\n"); 
		query.append("			AND 	TO_CHAR(W.INV_CFM_DT,'YYYY-MM-DD') = @[INV_CFM_DT]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" 			AND		W.TRSP_INV_AUD_STS_CD			= 'CF'        					" ).append("\n"); 
		query.append(" 			AND		NVL(W.DELT_FLG		, 'N')		= 'N'							" ).append("\n"); 
		query.append(" 			AND		NVL(W.INV_HLD_FLG	, ' ')		<> 'T'							" ).append("\n"); 
		query.append(" 		)																			" ).append("\n"); 
		query.append("#if(${CONTI_CD} == 'M')" ).append("\n"); 
		query.append("	 	WHERE COST_OFC_CD		            = @[COST_OFC_CD]                    					" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" 	UNION ALL                       												" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" 	SELECT	W.INV_NO                         										" ).append("\n"); 
		query.append(" 		,	W.INV_VNDR_SEQ                         									" ).append("\n"); 
		query.append(" 		,	W.WO_VNDR_SEQ                         									" ).append("\n"); 
		query.append(" 		,	W.INV_BZC_AMT 						INV_BZC_AMT                        	" ).append("\n"); 
		query.append(" 		,	W.INV_VAT_AMT 						INV_VAT_AMT                         " ).append("\n"); 
		query.append(" 		,	0 INV_WHLD_TAX_AMT                         								" ).append("\n"); 
		query.append(" 		,	0 INV_SBC_AMT" ).append("\n"); 
		query.append(" 		,	W.INV_TTL_AMT 						INV_TTL_AMT                         " ).append("\n"); 
		query.append(" 		,	TO_CHAR(W.INV_CFM_DT,'YYYYMMDD') 	INV_CFM_DT                 			" ).append("\n"); 
		query.append(" 		,	TO_CHAR(W.INV_RCV_DT,'YYYYMMDD') 	INV_RCV_DT                 			" ).append("\n"); 
		query.append(" 		,	TO_CHAR(W.INV_ISS_DT,'YYYYMMDD') 	INV_ISS_DT							" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" 		,  (SELECT 	COUNT(INV_NO) 													" ).append("\n"); 
		query.append(" 			FROM   	TRS_TRSP_RAIL_INV_DTL 		X									" ).append("\n"); 
		query.append(" 			WHERE  	X.INV_NO              		= W.INV_NO							" ).append("\n"); 
		query.append(" 			AND    	X.INV_VNDR_SEQ        		= W.INV_VNDR_SEQ					" ).append("\n"); 
		query.append(" 			AND    	X.PAY_FLG        			= 'Y'								" ).append("\n"); 
		query.append(" 			AND     (X.ACCT_CD            		IS NULL								" ).append("\n"); 
		query.append(" 		        	 OR																" ).append("\n"); 
		query.append(" 		       		 X.LGS_COST_CD        		IS NULL								" ).append("\n"); 
		query.append(" 		        	)       														" ).append("\n"); 
		query.append(" 			)  ACCT_CD_EMPTY_CNT													" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" 	FROM	TRS_TRSP_RAIL_INV_WRK			W                   					" ).append("\n"); 
		query.append(" 	WHERE	W.CRE_OFC_CD					= @[INV_OFC_CD]                    					" ).append("\n"); 
		query.append(" 	AND		W.INV_VNDR_SEQ					= @[INV_VNDR_SEQ]                   					" ).append("\n"); 
		query.append(" 	AND		W.INV_CURR_CD					= @[INV_CURR_CD]                      				" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${INV_CFM_DT} != '')" ).append("\n"); 
		query.append("		AND TO_CHAR(W.INV_CFM_DT,'YYYY-MM-DD') = @[INV_CFM_DT]        							" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" 	AND		NVL(W.DELT_FLG		, 'N')		= 'N'									" ).append("\n"); 
		query.append(" 	AND		W.TRSP_INV_AUD_STS_CD			= 'CF'          						" ).append("\n"); 
		query.append(" 	AND		NVL(W.INV_HLD_FLG	, ' ')		<> 'T'" ).append("\n"); 

	}
}