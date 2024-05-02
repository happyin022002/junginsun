/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : DisposalMgtDBDAOsearchDisposalCollectionInquiryListDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.04
*@LastModifier : 함형석
*@LastVersion : 1.0
* 2010.01.04 함형석
* 1.0 Creation
* --------------------------------------------------------
* History
* 2011.11.03 신혜정 [CHM-201114270-01] Disposal Invoice Inquiry 화면 Invoice No. 체크박스 선택해서 Detail 정보 조회 가능하게 추가 요청                  
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author HamHyungSeok
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DisposalMgtDBDAOsearchDisposalCollectionInquiryListDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DisposalMgtDBDAOsearchDisposalCollectionInquiryListDataRSQL
	  * </pre>
	  */
	public DisposalMgtDBDAOsearchDisposalCollectionInquiryListDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.integration").append("\n"); 
		query.append("FileName : DisposalMgtDBDAOsearchDisposalCollectionInquiryListDataRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("	BOD.OFC_CD " ).append("\n"); 
		query.append("	,BOD.BL_CURR_CD" ).append("\n"); 
		query.append("	,BOD.INV_FRT_AMT" ).append("\n"); 
		query.append("	,BOD.INV_TAX_AMT" ).append("\n"); 
		query.append("	,BOD.CLT_FRT_AMT" ).append("\n"); 
		query.append("	,BOD.CLT_TAX_AMT" ).append("\n"); 
		query.append("	,BOD.BAL_FRT_AMT" ).append("\n"); 
		query.append("	,BOD.BAL_TAX_AMT  " ).append("\n"); 
		query.append("	,TO_CHAR(BOD.CLT_LST_UPD_DT, 'yyyy-mm-dd') AS CLT_LST_UPD_DT " ).append("\n"); 
		query.append("	,E.DP_PRCS_KNT " ).append("\n"); 
		query.append("	,BOD.CLT_BL_NO AS INV_NO" ).append("\n"); 
		query.append("FROM BKG_OTS_DTL BOD, MDM_CURRENCY E" ).append("\n"); 
		query.append("WHERE " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${inv_no_list} != '')" ).append("\n"); 
		query.append("        BOD.CLT_BL_NO IN (" ).append("\n"); 
		query.append("		#foreach ($user_invNos IN ${invNos})" ).append("\n"); 
		query.append("			#if($velocityCount < $invNos.size())" ).append("\n"); 
		query.append("				'$user_invNos'," ).append("\n"); 
		query.append("			#else" ).append("\n"); 
		query.append("				'$user_invNos'" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	) " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND BOD.BL_CURR_CD = E.CURR_CD" ).append("\n"); 
		query.append("ORDER BY CLT_LST_UPD_DT" ).append("\n"); 

	}
}