/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PreDispatchSentHistoryDBDAOBatchPreDispatchSentHistoryCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.09
*@LastModifier : 손은주(TRS)
*@LastVersion : 1.0
* 2009.11.09 손은주(TRS)
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

public class PreDispatchSentHistoryDBDAOBatchPreDispatchSentHistoryCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PreDispatchSentHistoryDBDAOBatchPreDispatchSentHistoryCSQL
	  * </pre>
	  */
	public PreDispatchSentHistoryDBDAOBatchPreDispatchSentHistoryCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.workordermanage.predispatchsenthistory.integration").append("\n"); 
		query.append("FileName : PreDispatchSentHistoryDBDAOBatchPreDispatchSentHistoryCSQL").append("\n"); 
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
		query.append("INSERT INTO TRS_TRSP_DIS_HIS (" ).append("\n"); 
		query.append("TRSP_SO_OFC_CTY_CD, TRSP_SO_SEQ, TRSP_WO_OFC_CTY_CD, TRSP_WO_SEQ," ).append("\n"); 
		query.append("TRSP_DIS_REF_NO, TRSP_DIS_ISS_SEQ," ).append("\n"); 
		query.append("CGOR_FRT_PAY_IND_FLG, CGOR_ORG_BL_RCVR_IND_FLG, CGOR_CSTMS_ACPT_RE_IND_FLG," ).append("\n"); 
		query.append("CNTR_PKUP_NO, AVAL_DT, LST_FREE_DT," ).append("\n"); 
		query.append("DIS_N1ST_FAX_NO, DIS_N2ND_FAX_NO, DIS_N3RD_FAX_NO," ).append("\n"); 
		query.append("DIS_N1ST_EML, DIS_N2ND_EML, DIS_N3RD_EML," ).append("\n"); 
		query.append("CRE_OFC_CD, CRE_USR_ID, CRE_DT, CNTR_AVAL_NTC_UPD_FLG" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("A.TRSP_SO_OFC_CTY_CD, A.TRSP_SO_SEQ, A.TRSP_WO_OFC_CTY_CD, A.TRSP_WO_SEQ," ).append("\n"); 
		query.append("B.TRSP_DIS_REF_NO, MAX(C.TRSP_DIS_ISS_SEQ) + 1," ).append("\n"); 
		query.append("F.FRT_CLT_FLG, DECODE(F.CSTMS_CLR_CD, 'Y', 'Y', ' '), F.CSTMS_CLR_CD," ).append("\n"); 
		query.append("A.CNTR_PKUP_NO, A.AVAL_DT, A.LST_FREE_DT," ).append("\n"); 
		query.append("D.DIS_N1ST_FAX_NO, D.DIS_N2ND_FAX_NO, D.DIS_N3RD_FAX_NO," ).append("\n"); 
		query.append("E.DIS_N1ST_EML, E.DIS_N2ND_EML, E.DIS_N3RD_EML," ).append("\n"); 
		query.append("A.CRE_OFC_CD, A.UPD_USR_ID, SYSDATE, 'Y'" ).append("\n"); 
		query.append("FROM TRS_TRSP_SVC_ORD A, TRS_TRSP_DIS_MST B, TRS_TRSP_DIS_HIS C," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT VNDR_SEQ," ).append("\n"); 
		query.append("MAX(DECODE(ROWNUM, 1, WO_FAX_NO, '')) DIS_N1ST_FAX_NO," ).append("\n"); 
		query.append("MAX(DECODE(ROWNUM, 2, WO_FAX_NO, '')) DIS_N2ND_FAX_NO," ).append("\n"); 
		query.append("MAX(DECODE(ROWNUM, 3, WO_FAX_NO, '')) DIS_N3RD_FAX_NO" ).append("\n"); 
		query.append("FROM TRS_TRSP_WRK_ORD_CC_FAX" ).append("\n"); 
		query.append("WHERE VNDR_SEQ = @[vndr_seq]" ).append("\n"); 
		query.append("GROUP BY VNDR_SEQ" ).append("\n"); 
		query.append(") D," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT VNDR_SEQ," ).append("\n"); 
		query.append("MAX(DECODE(ROWNUM, 1, WO_EML, '')) DIS_N1ST_EML," ).append("\n"); 
		query.append("MAX(DECODE(ROWNUM, 2, WO_EML, '')) DIS_N2ND_EML," ).append("\n"); 
		query.append("MAX(DECODE(ROWNUM, 3, WO_EML, '')) DIS_N3RD_EML" ).append("\n"); 
		query.append("FROM TRS_TRSP_WRK_ORD_CC_EML" ).append("\n"); 
		query.append("WHERE VNDR_SEQ = @[vndr_seq]" ).append("\n"); 
		query.append("GROUP BY VNDR_SEQ" ).append("\n"); 
		query.append(") E ," ).append("\n"); 
		query.append("BKG_CGO_RLSE F" ).append("\n"); 
		query.append("WHERE A.TRSP_SO_OFC_CTY_CD = B.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("AND A.TRSP_SO_SEQ = B.TRSP_SO_SEQ" ).append("\n"); 
		query.append("AND A.TRSP_WO_OFC_CTY_CD = B.TRSP_WO_OFC_CTY_CD" ).append("\n"); 
		query.append("AND A.TRSP_WO_SEQ = B.TRSP_WO_SEQ" ).append("\n"); 
		query.append("AND B.TRSP_SO_OFC_CTY_CD = C.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("AND B.TRSP_SO_SEQ = C.TRSP_SO_SEQ" ).append("\n"); 
		query.append("AND B.TRSP_WO_OFC_CTY_CD = C.TRSP_WO_OFC_CTY_CD" ).append("\n"); 
		query.append("AND B.TRSP_WO_SEQ = C.TRSP_WO_SEQ" ).append("\n"); 
		query.append("AND B.TRSP_DIS_REF_NO = C.TRSP_DIS_REF_NO" ).append("\n"); 
		query.append("AND A.VNDR_SEQ = D.VNDR_SEQ(+)" ).append("\n"); 
		query.append("AND A.VNDR_SEQ = E.VNDR_SEQ(+)" ).append("\n"); 
		query.append("AND A.BL_NO = F.BL_NO(+)" ).append("\n"); 
		query.append("AND A.TRSP_SO_OFC_CTY_CD = @[trsp_so_ofc_cty_cd]" ).append("\n"); 
		query.append("AND A.TRSP_SO_SEQ = @[trsp_so_seq]" ).append("\n"); 
		query.append("GROUP BY A.TRSP_SO_OFC_CTY_CD, A.TRSP_SO_SEQ, A.TRSP_WO_OFC_CTY_CD, A.TRSP_WO_SEQ, B.TRSP_DIS_REF_NO," ).append("\n"); 
		query.append("F.FRT_CLT_FLG, DECODE(F.CSTMS_CLR_CD, 'Y', 'Y', ' '), F.CSTMS_CLR_CD, A.CNTR_PKUP_NO, A.AVAL_DT," ).append("\n"); 
		query.append("A.LST_FREE_DT, D.DIS_N1ST_FAX_NO, D.DIS_N2ND_FAX_NO, D.DIS_N3RD_FAX_NO, E.DIS_N1ST_EML, E.DIS_N2ND_EML, E.DIS_N3RD_EML," ).append("\n"); 
		query.append("A.CRE_OFC_CD, A.UPD_USR_ID" ).append("\n"); 

	}
}