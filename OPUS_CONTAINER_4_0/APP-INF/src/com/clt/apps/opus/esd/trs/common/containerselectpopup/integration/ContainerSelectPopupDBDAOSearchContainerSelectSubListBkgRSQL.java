/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ContainerSelectPopupDBDAOSearchContainerSelectSubListBkgRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.10.04
*@LastModifier : 박찬우
*@LastVersion : 1.0
* 2016.10.04 박찬우
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.common.containerselectpopup.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Chanwoo Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerSelectPopupDBDAOSearchContainerSelectSubListBkgRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Booking, Container 정보 조회
	  * </pre>
	  */
	public ContainerSelectPopupDBDAOSearchContainerSelectSubListBkgRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.common.containerselectpopup.integration").append("\n"); 
		query.append("FileName : ContainerSelectPopupDBDAOSearchContainerSelectSubListBkgRSQL").append("\n"); 
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
		query.append("-- NOT SPLIT" ).append("\n"); 
		query.append("SELECT         " ).append("\n"); 
		query.append("     A.BKG_NO         " ).append("\n"); 
		query.append(" ,   A.BKG_STS_CD          " ).append("\n"); 
		query.append(" ,   B.CNTR_NO      AS EQ_NO" ).append("\n"); 
		query.append(" ,   B.CNTR_TPSZ_CD AS EQ_TPSZ_CD      " ).append("\n"); 
		query.append(" ,   ''             AS DUP_CHECK" ).append("\n"); 
		query.append(" ,   ''             AS APPLY_SO_SEQ" ).append("\n"); 
		query.append(" ,   ''             AS ORG_APPLY_SO_SEQ" ).append("\n"); 
		query.append(" FROM" ).append("\n"); 
		query.append("     BKG_BOOKING      A       " ).append("\n"); 
		query.append(" ,   BKG_CONTAINER    B       " ).append("\n"); 
		query.append(" ,   TRS_TRSP_SVC_ORD D       " ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("#if($bkgNo.size() > 0)" ).append("\n"); 
		query.append("AND A.BKG_NO IN (" ).append("\n"); 
		query.append("	#foreach($code IN ${bkgNo})" ).append("\n"); 
		query.append("		#if($velocityCount == 1)" ).append("\n"); 
		query.append("			'$code'" ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("			,'$code'" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" AND A.BKG_NO       = B.BKG_NO         (+)       " ).append("\n"); 
		query.append(" AND 'X'           <> A.BKG_STS_CD     (+)       " ).append("\n"); 
		query.append(" AND B.BKG_NO       = D.BKG_NO         (+)       " ).append("\n"); 
		query.append(" AND B.CNTR_NO      = D.EQ_NO          (+)       " ).append("\n"); 
		query.append(" AND 'N'= D.DELT_FLG        (+)       " ).append("\n"); 
		query.append(" AND 'OD'          = SUBSTR(D.COST_ACT_GRP_CD(+),1,2)" ).append("\n"); 
		query.append("UNION -- IF SPLIT CASE, MAIN BKG" ).append("\n"); 
		query.append("SELECT         " ).append("\n"); 
		query.append("     A.BKG_NO         " ).append("\n"); 
		query.append(" ,   A.BKG_STS_CD          " ).append("\n"); 
		query.append(" ,   B.CNTR_NO      AS EQ_NO" ).append("\n"); 
		query.append(" ,   B.CNTR_TPSZ_CD AS EQ_TPSZ_CD      " ).append("\n"); 
		query.append(" ,   ''             AS DUP_CHECK" ).append("\n"); 
		query.append(" ,   ''             AS APPLY_SO_SEQ" ).append("\n"); 
		query.append(" ,   ''             AS ORG_APPLY_SO_SEQ" ).append("\n"); 
		query.append(" FROM" ).append("\n"); 
		query.append("     BKG_BOOKING      A    " ).append("\n"); 
		query.append(" ,   BKG_CONTAINER    B       " ).append("\n"); 
		query.append(" ,   TRS_TRSP_SVC_ORD D       " ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("#if($bkgNo.size() > 0)" ).append("\n"); 
		query.append("AND A.FM_BKG_NO IN (" ).append("\n"); 
		query.append("	#foreach($code IN ${bkgNo})" ).append("\n"); 
		query.append("		#if($velocityCount == 1)" ).append("\n"); 
		query.append("			'$code'" ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("			,'$code'" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("#end         " ).append("\n"); 
		query.append(" AND A.BKG_CRE_TP_CD = 'S'" ).append("\n"); 
		query.append(" AND A.BKG_NO        = B.BKG_NO         (+)       " ).append("\n"); 
		query.append(" AND 'X'<> A.BKG_STS_CD     (+)       " ).append("\n"); 
		query.append(" AND B.BKG_NO        = D.BKG_NO         (+)       " ).append("\n"); 
		query.append(" AND B.CNTR_NO       = D.EQ_NO(+)       " ).append("\n"); 
		query.append(" AND 'N'= D.DELT_FLG        (+)       " ).append("\n"); 
		query.append(" AND 'OD'            = SUBSTR(D.COST_ACT_GRP_CD(+),1,2)" ).append("\n"); 
		query.append("UNION -- IF SPLIT CASE, SPLIT BKG" ).append("\n"); 
		query.append("SELECT         " ).append("\n"); 
		query.append("     A.BKG_NO         " ).append("\n"); 
		query.append(" ,   A.BKG_STS_CD          " ).append("\n"); 
		query.append(" ,   B.CNTR_NO      AS EQ_NO" ).append("\n"); 
		query.append(" ,   B.CNTR_TPSZ_CD AS EQ_TPSZ_CD      " ).append("\n"); 
		query.append(" ,   ''             AS DUP_CHECK" ).append("\n"); 
		query.append(" ,   ''             AS APPLY_SO_SEQ" ).append("\n"); 
		query.append(" ,   ''             AS ORG_APPLY_SO_SEQ" ).append("\n"); 
		query.append(" FROM" ).append("\n"); 
		query.append("     BKG_BOOKING      A" ).append("\n"); 
		query.append(" ,   BKG_BOOKING      C     " ).append("\n"); 
		query.append(" ,   BKG_CONTAINER    B       " ).append("\n"); 
		query.append(" ,   TRS_TRSP_SVC_ORD D       " ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("#if($bkgNo.size() > 0)" ).append("\n"); 
		query.append("AND C.BKG_NO IN (" ).append("\n"); 
		query.append("	#foreach($code IN ${bkgNo})" ).append("\n"); 
		query.append("		#if($velocityCount == 1)" ).append("\n"); 
		query.append("			'$code'" ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("			,'$code'" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("#end         " ).append("\n"); 
		query.append(" AND C.BKG_CRE_TP_CD = 'S'" ).append("\n"); 
		query.append(" AND C.FM_BKG_NO     = A.FM_BKG_NO" ).append("\n"); 
		query.append(" AND A.BKG_NO        = B.BKG_NO         (+)       " ).append("\n"); 
		query.append(" AND 'X'<> A.BKG_STS_CD     (+)       " ).append("\n"); 
		query.append(" AND B.BKG_NO        = D.BKG_NO         (+)       " ).append("\n"); 
		query.append(" AND B.CNTR_NO       = D.EQ_NO(+)       " ).append("\n"); 
		query.append(" AND 'N'= D.DELT_FLG        (+)       " ).append("\n"); 
		query.append(" AND 'OD'            = SUBSTR(D.COST_ACT_GRP_CD(+),1,2)" ).append("\n"); 

	}
}