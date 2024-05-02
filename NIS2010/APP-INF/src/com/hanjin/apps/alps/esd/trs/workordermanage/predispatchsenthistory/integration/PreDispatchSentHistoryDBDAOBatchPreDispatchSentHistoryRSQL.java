/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PreDispatchSentHistoryDBDAOBatchPreDispatchSentHistoryRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.13
*@LastModifier : 손은주(TRS)
*@LastVersion : 1.0
* 2009.11.13 손은주(TRS)
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.workordermanage.predispatchsenthistory.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Eun ju Son(TRS)
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PreDispatchSentHistoryDBDAOBatchPreDispatchSentHistoryRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PreDispatchSentHistoryDBDAOBatchPreDispatchSentHistoryRSQL
	  * </pre>
	  */
	public PreDispatchSentHistoryDBDAOBatchPreDispatchSentHistoryRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.workordermanage.predispatchsenthistory.integration").append("\n"); 
		query.append("FileName : PreDispatchSentHistoryDBDAOBatchPreDispatchSentHistoryRSQL").append("\n"); 
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
		query.append("A.TRSP_SO_OFC_CTY_CD," ).append("\n"); 
		query.append("A.TRSP_SO_SEQ," ).append("\n"); 
		query.append("NVL(A.VNDR_SEQ, 0) VNDR_SEQ," ).append("\n"); 
		query.append("C.TRSP_DIS_REF_NO," ).append("\n"); 
		query.append("C.DIS_N1ST_FAX_NO," ).append("\n"); 
		query.append("C.DIS_N2ND_FAX_NO," ).append("\n"); 
		query.append("C.DIS_N3RD_FAX_NO," ).append("\n"); 
		query.append("F.VNDR_LGL_ENG_NM," ).append("\n"); 
		query.append("C.DIS_N1ST_EML," ).append("\n"); 
		query.append("C.DIS_N2ND_EML," ).append("\n"); 
		query.append("C.DIS_N3RD_EML," ).append("\n"); 
		query.append("A.CRE_OFC_CD," ).append("\n"); 
		query.append("A.UPD_USR_ID," ).append("\n"); 
		query.append("MAX(C.TRSP_DIS_ISS_SEQ) TRSP_DIS_ISS_SEQ," ).append("\n"); 
		query.append("A.TRSP_WO_OFC_CTY_CD," ).append("\n"); 
		query.append("A.TRSP_WO_SEQ," ).append("\n"); 
		query.append("TO_CHAR(SYSDATE-1,'YYYYMMDD') BAT_EXE_DT" ).append("\n"); 
		query.append("FROM TRS_TRSP_SVC_ORD A, TRS_TRSP_DIS_MST B, TRS_TRSP_DIS_HIS C, MDM_VENDOR F, BKG_CGO_RLSE G" ).append("\n"); 
		query.append("WHERE G.FRT_CLT_FLG = 'Y'" ).append("\n"); 
		query.append("AND DECODE(G.CSTMS_CLR_CD, 'Y', 'Y', ' ') = 'Y'" ).append("\n"); 
		query.append("AND G.CSTMS_CLR_CD = 'Y'" ).append("\n"); 
		query.append("AND A.BL_NO = G.BL_NO (+)" ).append("\n"); 
		query.append("AND A.CNTR_PKUP_NO IS NOT NULL" ).append("\n"); 
		query.append("AND A.CNTR_AVAL_NTC_UPD_FLG IS NULL" ).append("\n"); 
		query.append("AND A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND A.TRSP_SO_OFC_CTY_CD = B.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("AND A.TRSP_SO_SEQ = B.TRSP_SO_SEQ" ).append("\n"); 
		query.append("AND A.TRSP_WO_OFC_CTY_CD = B.TRSP_WO_OFC_CTY_CD" ).append("\n"); 
		query.append("AND A.TRSP_WO_SEQ = B.TRSP_WO_SEQ" ).append("\n"); 
		query.append("AND B.TRSP_SO_OFC_CTY_CD = C.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("AND B.TRSP_SO_SEQ = C.TRSP_SO_SEQ" ).append("\n"); 
		query.append("AND B.TRSP_WO_OFC_CTY_CD = C.TRSP_WO_OFC_CTY_CD" ).append("\n"); 
		query.append("AND B.TRSP_WO_SEQ = C.TRSP_WO_SEQ" ).append("\n"); 
		query.append("AND B.TRSP_DIS_REF_NO = C.TRSP_DIS_REF_NO" ).append("\n"); 
		query.append("AND A.VNDR_SEQ = F.VNDR_SEQ(+)" ).append("\n"); 
		query.append("AND EXISTS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT 'X' FROM MDM_LOCATION LOC, TRS_TRSP_SVC_ORD BB" ).append("\n"); 
		query.append("WHERE LOC.LOC_CD = SUBSTR(BB.FM_NOD_CD, 1, 5)" ).append("\n"); 
		query.append("AND LOC.CONTI_CD = 'M'" ).append("\n"); 
		query.append("AND A.TRSP_CRR_MOD_CD = 'TD'" ).append("\n"); 
		query.append("AND A.TRSP_SO_OFC_CTY_CD = BB.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("AND A.TRSP_SO_SEQ = BB.TRSP_SO_SEQ" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND A.TRSP_CRR_MOD_CD = 'TD'" ).append("\n"); 
		query.append("AND A.TRSP_SO_STS_CD = 'I'" ).append("\n"); 
		query.append("#if($soArr.size() > 0)" ).append("\n"); 
		query.append("AND ( (A.TRSP_SO_OFC_CTY_CD, A.TRSP_SO_SEQ) IN (" ).append("\n"); 
		query.append("#foreach( ${key} in ${soArr})" ).append("\n"); 
		query.append("#if($velocityCount == 1)" ).append("\n"); 
		query.append("( '${key.trspSoOfcCtyCd}', ${key.trspSoSeq} )" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(", ( '${key.trspSoOfcCtyCd}', ${key.trspSoSeq} )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("GROUP BY A.TRSP_SO_OFC_CTY_CD, A.TRSP_SO_SEQ, A.VNDR_SEQ, C.TRSP_DIS_REF_NO," ).append("\n"); 
		query.append("C.DIS_N1ST_FAX_NO, C.DIS_N2ND_FAX_NO, C.DIS_N3RD_FAX_NO, F.VNDR_LGL_ENG_NM," ).append("\n"); 
		query.append("C.DIS_N1ST_EML, C.DIS_N2ND_EML, C.DIS_N3RD_EML, A.CRE_OFC_CD, A.UPD_USR_ID," ).append("\n"); 
		query.append("A.TRSP_WO_OFC_CTY_CD, A.TRSP_WO_SEQ" ).append("\n"); 

	}
}