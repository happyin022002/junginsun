/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : DisposalMgtDBDAOsearchDisposalNoPickUpListDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.12
*@LastModifier : 
*@LastVersion : 1.0
* 2012.04.12 
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

public class DisposalMgtDBDAOsearchDisposalNoPickUpListDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchDisposalNoPickUpListData
	  * </pre>
	  */
	public DisposalMgtDBDAOsearchDisposalNoPickUpListDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.integration").append("\n"); 
		query.append("FileName : DisposalMgtDBDAOsearchDisposalNoPickUpListDataRSQL").append("\n"); 
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
		query.append("    C.DISP_NO" ).append("\n"); 
		query.append("    , A.INV_NO" ).append("\n"); 
		query.append("    , (SELECT MNR_PRNR_LGL_ENG_NM " ).append("\n"); 
		query.append("     FROM MNR_PARTNER P" ).append("\n"); 
		query.append("     WHERE A.MNR_PRNR_CNT_CD = P.MNR_PRNR_CNT_CD" ).append("\n"); 
		query.append("     AND A.MNR_PRNR_SEQ = P.MNR_PRNR_SEQ" ).append("\n"); 
		query.append("     AND ROWNUM = 1 ) AS BUYER_NAME" ).append("\n"); 
		query.append("    , A.EQ_NO" ).append("\n"); 
		query.append("    , A.EQ_TPSZ_CD" ).append("\n"); 
		query.append("    , B.LSTM_CD" ).append("\n"); 
		query.append("    , B.MVMT_CD" ).append("\n"); 
		query.append("    , A.DISP_YD_CD" ).append("\n"); 
		query.append("    , TO_CHAR(C.RQST_DT, 'YYYY-MM-DD') RQST_DT" ).append("\n"); 
		query.append("    , TO_CHAR(C.DISP_BULTN_DT, 'YYYY-MM-DD') DISP_BULTN_DT" ).append("\n"); 
		query.append("    , TO_CHAR(C.DISP_ST_DT, 'YYYY-MM-DD HH24:MI:SS') DISP_ST_DT" ).append("\n"); 
		query.append("    , TO_CHAR(C.DISP_END_DT, 'YYYY-MM-DD HH24:MI:SS') DISP_END_DT" ).append("\n"); 
		query.append("    , TO_CHAR(C.DISP_PKUP_ST_DT, 'YYYY-MM-DD') DISP_PKUP_ST_DT" ).append("\n"); 
		query.append("    , TO_CHAR(C.DISP_PKUP_END_DT, 'YYYY-MM-DD') DISP_PKUP_END_DT" ).append("\n"); 
		query.append("    , A.PART_AMT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("    MNR_DISP_DTL A" ).append("\n"); 
		query.append("    , MNR_EQ_STS_V B" ).append("\n"); 
		query.append("    , MNR_DISP_HDR C" ).append("\n"); 
		query.append("WHERE " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${disp_no_list} != '')" ).append("\n"); 
		query.append("	A.DISP_NO IN (" ).append("\n"); 
		query.append("		#foreach ($user_disp_no IN ${dispNos})" ).append("\n"); 
		query.append("			#if($velocityCount < $dispNos.size())" ).append("\n"); 
		query.append("				'$user_disp_no'," ).append("\n"); 
		query.append("			#else" ).append("\n"); 
		query.append("				'$user_disp_no'" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("		#end                      " ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    AND A.EQ_NO = B.EQ_NO(+)" ).append("\n"); 
		query.append("    AND A.DISP_NO = C.DISP_NO" ).append("\n"); 
		query.append("	AND A.DISP_SOLD_DT IS NULL" ).append("\n"); 

	}
}