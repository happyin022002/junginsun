/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : DisposalMgtDBDAOsearchDisposalDetailInquiryListDataRSQL.java
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

public class DisposalMgtDBDAOsearchDisposalDetailInquiryListDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DisposalMgtDBDAOsearchDisposalDetailInquiryListDataRSQL
	  * </pre>
	  */
	public DisposalMgtDBDAOsearchDisposalDetailInquiryListDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.integration").append("\n"); 
		query.append("FileName : DisposalMgtDBDAOsearchDisposalDetailInquiryListDataRSQL").append("\n"); 
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
		query.append("    ,A.INV_NO" ).append("\n"); 
		query.append("    ,I.TTL_AMT" ).append("\n"); 
		query.append("    ,B.DISP_NO" ).append("\n"); 
		query.append("    ,B.EQ_NO" ).append("\n"); 
		query.append("    ,B.EQ_TPSZ_CD" ).append("\n"); 
		query.append("    ,B.DISP_RLSE_NO" ).append("\n"); 
		query.append("    ,C.CURR_CD" ).append("\n"); 
		query.append("    ,B.INV_AMT" ).append("\n"); 
		query.append("    ,MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(A.ISS_DT, 'YYYYMM'), C.CURR_CD, 'USD', B.INV_AMT) AS USD_TTL_AMT" ).append("\n"); 
		query.append("    ,TO_CHAR(C.RQST_DT, 'yyyy-mm-dd') AS RQST_DT     " ).append("\n"); 
		query.append("    ,TO_CHAR(B.DISP_SOLD_DT, 'yyyy-mm-dd') AS DISP_SOLD_DT      " ).append("\n"); 
		query.append("    ,TO_CHAR(A.INV_DUE_DT, 'yyyy-mm-dd') AS INV_DUE_DT  " ).append("\n"); 
		query.append("    ,B.MNR_DISP_DTL_RMK" ).append("\n"); 
		query.append("	,F.DP_PRCS_KNT " ).append("\n"); 
		query.append("FROM MNR_RCV_INV_WRK A, MNR_DISP_HDR C,  MNR_DISP_DTL B, MNR_GEN_CD E, MDM_CURRENCY F" ).append("\n"); 
		query.append("    , (SELECT" ).append("\n"); 
		query.append("        SUM(H.INV_AMT) AS TTL_AMT" ).append("\n"); 
		query.append("    FROM" ).append("\n"); 
		query.append("        MNR_RCV_INV_WRK G" ).append("\n"); 
		query.append("        , MNR_DISP_DTL H" ).append("\n"); 
		query.append("    WHERE" ).append("\n"); 
		query.append("#if (${inv_no_list} != '')" ).append("\n"); 
		query.append("        G.INV_NO IN (" ).append("\n"); 
		query.append("		#foreach ($user_invNos IN ${invNos})" ).append("\n"); 
		query.append("			#if($velocityCount < $invNos.size())" ).append("\n"); 
		query.append("				'$user_invNos'," ).append("\n"); 
		query.append("			#else" ).append("\n"); 
		query.append("				'$user_invNos'" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	) " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        AND G.RCV_INV_SEQ = H.RCV_INV_SEQ) I" ).append("\n"); 
		query.append("WHERE C.DISP_NO= B.DISP_NO" ).append("\n"); 
		query.append("#if (${inv_no_list} != '')" ).append("\n"); 
		query.append("	AND A.INV_NO IN (" ).append("\n"); 
		query.append("		#foreach ($user_invNos IN ${invNos})" ).append("\n"); 
		query.append("			#if($velocityCount < $invNos.size())" ).append("\n"); 
		query.append("				'$user_invNos'," ).append("\n"); 
		query.append("			#else" ).append("\n"); 
		query.append("				'$user_invNos'" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	) " ).append("\n"); 
		query.append("#end	" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND A.RCV_INV_SEQ = B.RCV_INV_SEQ" ).append("\n"); 
		query.append("AND C.DISP_NO = B.DISP_NO" ).append("\n"); 
		query.append("AND C.CURR_CD = F.CURR_CD" ).append("\n"); 
		query.append("AND E.PRNT_CD_ID(+)='CD00035'" ).append("\n"); 
		query.append("AND C.DISP_TP_CD = E.MNR_CD_ID(+)" ).append("\n"); 

	}
}