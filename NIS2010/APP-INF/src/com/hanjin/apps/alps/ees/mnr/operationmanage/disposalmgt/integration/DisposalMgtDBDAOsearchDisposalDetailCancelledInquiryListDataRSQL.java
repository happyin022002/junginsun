/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : DisposalMgtDBDAOsearchDisposalDetailCancelledInquiryListDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.14
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.14 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DisposalMgtDBDAOsearchDisposalDetailCancelledInquiryListDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DisposalMgtDBDAOsearchDisposalDetailCancelledInquiryListDataRSQL
	  * </pre>
	  */
	public DisposalMgtDBDAOsearchDisposalDetailCancelledInquiryListDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.integration").append("\n"); 
		query.append("FileName : DisposalMgtDBDAOsearchDisposalDetailCancelledInquiryListDataRSQL").append("\n"); 
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
		query.append("    E.MNR_CD_DESC AS DISP_TP_NM" ).append("\n"); 
		query.append("    , A.INV_NO" ).append("\n"); 
		query.append("    , (SELECT SUM(H.INV_AMT) AS TTL_AMT" ).append("\n"); 
		query.append("        FROM                " ).append("\n"); 
		query.append("            MNR_DISP_CXL_DTL H" ).append("\n"); 
		query.append("        WHERE       " ).append("\n"); 
		query.append("            H.RCV_INV_SEQ = A.RCV_INV_SEQ" ).append("\n"); 
		query.append("            AND H.DISP_NO = B.DISP_NO" ).append("\n"); 
		query.append("            AND H.CXL_INV_SEQ = B.CXL_INV_SEQ" ).append("\n"); 
		query.append("        GROUP BY " ).append("\n"); 
		query.append("            H.DISP_NO" ).append("\n"); 
		query.append("            , H.CXL_INV_SEQ    " ).append("\n"); 
		query.append("    ) AS TTL_AMT" ).append("\n"); 
		query.append("    , B.DISP_NO" ).append("\n"); 
		query.append("    , B.CXL_INV_SEQ" ).append("\n"); 
		query.append("    , B.EQ_NO" ).append("\n"); 
		query.append("    , B.EQ_TPSZ_CD" ).append("\n"); 
		query.append("    , B.DISP_RLSE_NO" ).append("\n"); 
		query.append("    , C.CURR_CD" ).append("\n"); 
		query.append("    , B.INV_AMT" ).append("\n"); 
		query.append("    , MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(A.ISS_DT, 'YYYYMM'), C.CURR_CD, 'USD', B.INV_AMT) AS USD_TTL_AMT" ).append("\n"); 
		query.append("    , TO_CHAR(C.RQST_DT, 'yyyy-mm-dd') AS RQST_DT     " ).append("\n"); 
		query.append("    , TO_CHAR(B.DISP_SOLD_DT, 'yyyy-mm-dd') AS DISP_SOLD_DT      " ).append("\n"); 
		query.append("    , TO_CHAR(A.INV_DUE_DT, 'yyyy-mm-dd') AS INV_DUE_DT  " ).append("\n"); 
		query.append("    , B.MNR_DISP_DTL_RMK" ).append("\n"); 
		query.append("	, F.DP_PRCS_KNT " ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("    (SELECT DISTINCT(RCV_INV_SEQ), INV_DUE_DT, INV_NO, ISS_DT " ).append("\n"); 
		query.append("        FROM MNR_CXL_RCV_INV_WRK" ).append("\n"); 
		query.append("        WHERE 		" ).append("\n"); 
		query.append("		#if (${inv_no_list} != '')" ).append("\n"); 
		query.append("    	    INV_NO IN (" ).append("\n"); 
		query.append("			#foreach ($user_invNos IN ${invNos})" ).append("\n"); 
		query.append("				#if($velocityCount < $invNos.size())" ).append("\n"); 
		query.append("					'$user_invNos'," ).append("\n"); 
		query.append("				#else" ).append("\n"); 
		query.append("					'$user_invNos'" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("		) " ).append("\n"); 
		query.append("		#end	" ).append("\n"); 
		query.append("	) A" ).append("\n"); 
		query.append("    , (SELECT H.DISP_NO" ).append("\n"); 
		query.append("            , MAX(DISP_TP_CD) AS DISP_TP_CD" ).append("\n"); 
		query.append("            , MAX(CURR_CD) AS CURR_CD" ).append("\n"); 
		query.append("            , MAX(RQST_DT) AS RQST_DT  " ).append("\n"); 
		query.append("        FROM MNR_DISP_CXL_HDR H" ).append("\n"); 
		query.append("            , (SELECT DISTINCT(RCV_INV_SEQ)" ).append("\n"); 
		query.append("                FROM MNR_CXL_RCV_INV_WRK" ).append("\n"); 
		query.append("                WHERE " ).append("\n"); 
		query.append("				#if (${inv_no_list} != '')" ).append("\n"); 
		query.append("			        INV_NO IN (" ).append("\n"); 
		query.append("					#foreach ($user_invNos IN ${invNos})" ).append("\n"); 
		query.append("						#if($velocityCount < $invNos.size())" ).append("\n"); 
		query.append("							'$user_invNos'," ).append("\n"); 
		query.append("						#else" ).append("\n"); 
		query.append("							'$user_invNos'" ).append("\n"); 
		query.append("						#end" ).append("\n"); 
		query.append("					#end" ).append("\n"); 
		query.append("				) " ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("				) W" ).append("\n"); 
		query.append("            , MNR_DISP_CXL_DTL D" ).append("\n"); 
		query.append("        WHERE" ).append("\n"); 
		query.append("            W.RCV_INV_SEQ = D.RCV_INV_SEQ" ).append("\n"); 
		query.append("            AND H.DISP_NO = D.DISP_NO" ).append("\n"); 
		query.append("        GROUP BY H.DISP_NO              " ).append("\n"); 
		query.append("	) C" ).append("\n"); 
		query.append("	,  MNR_DISP_CXL_DTL B, MNR_GEN_CD E, MDM_CURRENCY F" ).append("\n"); 
		query.append("WHERE " ).append("\n"); 
		query.append("    A.RCV_INV_SEQ = B.RCV_INV_SEQ" ).append("\n"); 
		query.append("    AND B.DISP_NO = C.DISP_NO" ).append("\n"); 
		query.append("	AND C.CURR_CD = F.CURR_CD" ).append("\n"); 
		query.append("	AND E.PRNT_CD_ID(+) = 'CD00035'" ).append("\n"); 
		query.append("	AND C.DISP_TP_CD = E.MNR_CD_ID(+)" ).append("\n"); 
		query.append("ORDER BY " ).append("\n"); 
		query.append("	B.DISP_NO" ).append("\n"); 
		query.append("	, B.CXL_INV_SEQ" ).append("\n"); 
		query.append("	, B.DISP_RLSE_NO" ).append("\n"); 

	}
}