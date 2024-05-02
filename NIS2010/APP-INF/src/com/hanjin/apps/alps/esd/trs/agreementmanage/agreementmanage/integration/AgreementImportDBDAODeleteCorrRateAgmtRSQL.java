/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AgreementImportDBDAODeleteCorrRateAgmtRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.31
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.31 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.agreementmanage.agreementmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AgreementImportDBDAODeleteCorrRateAgmtRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AGMT RATE 삭제 데이타 조회
	  * </pre>
	  */
	public AgreementImportDBDAODeleteCorrRateAgmtRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_tmp_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_account_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.agreementmanage.agreementmanage.integration").append("\n"); 
		query.append("FileName : AgreementImportDBDAODeleteCorrRateAgmtRSQL").append("\n"); 
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
		query.append("SELECT TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("      ,TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("      ,(" ).append("\n"); 
		query.append("        SELECT TRSP_AGMT_RT_TP_SER_NO" ).append("\n"); 
		query.append("          FROM TRS_AGMT_RT_TP" ).append("\n"); 
		query.append("         WHERE TRSP_AGMT_OFC_CTY_CD = X.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("           AND TRSP_AGMT_SEQ        = X.TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("           AND TRSP_AGMT_RT_TP_CD   = X.TRSP_AGMT_RT_TP_CD" ).append("\n"); 
		query.append("           AND CGO_TP_CD = X.CGO_TP_CD" ).append("\n"); 
		query.append("           AND CUST_NOMI_TRKR_FLG   = X.CUST_NOMI_TRKR_FLG" ).append("\n"); 
		query.append("           AND CUST_CNT_CD = X.CUST_CNT_CD" ).append("\n"); 
		query.append("           AND CUST_SEQ     = X.CUST_SEQ" ).append("\n"); 
		query.append("           AND TRSP_COST_MOD_CD     = X.TRSP_COST_MOD_CD" ).append("\n"); 
		query.append("           AND AGMT_TRSP_TP_CD      = X.AGMT_TRSP_TP_CD" ).append("\n"); 
		query.append("           AND CMDT_GRP_CD    = X.CMDT_GRP_CD" ).append("\n"); 
		query.append("           AND RAIL_SVC_TP_CD = X.RAIL_SVC_TP_CD" ).append("\n"); 
		query.append("           AND CUST_NOMI_TRKR_IND_CD = X.CUST_NOMI_TRKR_IND_CD" ).append("\n"); 
		query.append("           AND ROWNUM = 1" ).append("\n"); 
		query.append("       ) TRSP_AGMT_RT_TP_SER_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("      ,(" ).append("\n"); 
		query.append("        SELECT TRSP_AGMT_NOD_SEQ" ).append("\n"); 
		query.append("          FROM TRS_AGMT_RT_TP A" ).append("\n"); 
		query.append("              ,TRS_AGMT_NOD   B" ).append("\n"); 
		query.append("         WHERE A.TRSP_AGMT_OFC_CTY_CD = B.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("           AND A.TRSP_AGMT_SEQ        = B.TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("           AND A.TRSP_AGMT_RT_TP_SER_NO = B.TRSP_AGMT_RT_TP_SER_NO" ).append("\n"); 
		query.append("           AND A.TRSP_AGMT_OFC_CTY_CD   = X.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("           AND A.TRSP_AGMT_SEQ          = X.TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("           AND A.TRSP_AGMT_RT_TP_CD     = X.TRSP_AGMT_RT_TP_CD" ).append("\n"); 
		query.append("           AND CGO_TP_CD     = X.CGO_TP_CD" ).append("\n"); 
		query.append("           AND A.CUST_NOMI_TRKR_FLG     = X.CUST_NOMI_TRKR_FLG" ).append("\n"); 
		query.append("           AND A.CUST_CNT_CD = X.CUST_CNT_CD" ).append("\n"); 
		query.append("           AND A.CUST_SEQ       = X.CUST_SEQ" ).append("\n"); 
		query.append("           AND A.TRSP_COST_MOD_CD       = X.TRSP_COST_MOD_CD" ).append("\n"); 
		query.append("           AND A.AGMT_TRSP_TP_CD        = X.AGMT_TRSP_TP_CD" ).append("\n"); 
		query.append("           AND A.CMDT_GRP_CD     = X.CMDT_GRP_CD" ).append("\n"); 
		query.append("           AND A.RAIL_SVC_TP_CD  = X.RAIL_SVC_TP_CD" ).append("\n"); 
		query.append("           AND B.FM_NOD_CD       = X.FM_NOD_CD" ).append("\n"); 
		query.append("           AND B.VIA_NOD_CD      = X.VIA_NOD_CD" ).append("\n"); 
		query.append("           AND B.DOR_NOD_CD      = X.DOR_NOD_CD" ).append("\n"); 
		query.append("           AND B.TO_NOD_CD       = X.TO_NOD_CD" ).append("\n"); 
		query.append("           AND B.TRSP_AGMT_DIST      = X.TRSP_AGMT_DIST" ).append("\n"); 
		query.append("           AND B.DIST_MEAS_UT_CD = X.DIST_MEAS_UT_CD" ).append("\n"); 
		query.append("           AND B.TRSP_DIST_TP_CD = X.TRSP_DIST_TP_CD" ).append("\n"); 
		query.append("           AND A.CUST_NOMI_TRKR_IND_CD = X.CUST_NOMI_TRKR_IND_CD" ).append("\n"); 
		query.append("           AND ROWNUM = 1" ).append("\n"); 
		query.append("       ) TRSP_AGMT_NOD_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("      ,(" ).append("\n"); 
		query.append("        SELECT E.TRSP_AGMT_RT_SEQ" ).append("\n"); 
		query.append("          FROM TRS_AGMT_HDR   A" ).append("\n"); 
		query.append("              ,TRS_AGMT_RT_TP C" ).append("\n"); 
		query.append("              ,TRS_AGMT_NOD   D" ).append("\n"); 
		query.append("              ,TRS_AGMT_EQ_RT E" ).append("\n"); 
		query.append("         WHERE A.TRSP_AGMT_OFC_CTY_CD   = C.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("           AND A.TRSP_AGMT_SEQ          = C.TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("           AND C.TRSP_AGMT_OFC_CTY_CD   = D.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("           AND C.TRSP_AGMT_SEQ          = D.TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("           AND C.TRSP_AGMT_RT_TP_SER_NO = D.TRSP_AGMT_RT_TP_SER_NO" ).append("\n"); 
		query.append("           AND D.TRSP_AGMT_OFC_CTY_CD   = E.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("           AND D.TRSP_AGMT_SEQ          = E.TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("           AND D.TRSP_AGMT_RT_TP_SER_NO = E.TRSP_AGMT_RT_TP_SER_NO" ).append("\n"); 
		query.append("           AND D.TRSP_AGMT_NOD_SEQ      = E.TRSP_AGMT_NOD_SEQ" ).append("\n"); 
		query.append("           AND C.TRSP_AGMT_OFC_CTY_CD   = X.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("           AND C.TRSP_AGMT_SEQ          = X.TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("           AND C.TRSP_AGMT_RT_TP_CD     = X.TRSP_AGMT_RT_TP_CD" ).append("\n"); 
		query.append("           AND C.CGO_TP_CD  = X.CGO_TP_CD" ).append("\n"); 
		query.append("           AND C.CUST_NOMI_TRKR_FLG     = X.CUST_NOMI_TRKR_FLG" ).append("\n"); 
		query.append("           AND C.CUST_CNT_CD = X.CUST_CNT_CD" ).append("\n"); 
		query.append("           AND C.CUST_SEQ        = X.CUST_SEQ" ).append("\n"); 
		query.append("           AND C.TRSP_COST_MOD_CD        = X.TRSP_COST_MOD_CD" ).append("\n"); 
		query.append("           AND C.AGMT_TRSP_TP_CD         = X.AGMT_TRSP_TP_CD" ).append("\n"); 
		query.append("           AND C.CMDT_GRP_CD = X.CMDT_GRP_CD" ).append("\n"); 
		query.append("           AND C.RAIL_SVC_TP_CD = X.RAIL_SVC_TP_CD" ).append("\n"); 
		query.append("           AND D.FM_NOD_CD   = X.FM_NOD_CD" ).append("\n"); 
		query.append("           AND D.VIA_NOD_CD  = X.VIA_NOD_CD" ).append("\n"); 
		query.append("           AND D.DOR_NOD_CD  = X.DOR_NOD_CD" ).append("\n"); 
		query.append("           AND D.TO_NOD_CD   = X.TO_NOD_CD" ).append("\n"); 
		query.append("           AND D.TRSP_AGMT_DIST  = X.TRSP_AGMT_DIST" ).append("\n"); 
		query.append("           AND D.DIST_MEAS_UT_CD = X.DIST_MEAS_UT_CD" ).append("\n"); 
		query.append("           AND D.TRSP_DIST_TP_CD = X.TRSP_DIST_TP_CD" ).append("\n"); 
		query.append("           AND E.TRSP_AGMT_EQ_TP_SZ_CD = X.TRSP_AGMT_EQ_TP_CD||X.TRSP_AGMT_EQ_SZ_CD" ).append("\n"); 
		query.append("           AND E.EQ_KND_CD             = X.EQ_KND_CD            " ).append("\n"); 
		query.append("           AND E.WTR_RCV_TERM_CD       = X.WTR_RCV_TERM_CD      " ).append("\n"); 
		query.append("           AND E.WTR_DE_TERM_CD        = X.WTR_DE_TERM_CD       " ).append("\n"); 
		query.append("           AND E.TRSP_AGMT_BDL_QTY     = X.TRSP_AGMT_BDL_QTY    " ).append("\n"); 
		query.append("           AND E.TO_WGT                = X.TO_WGT               " ).append("\n"); 
		query.append("           AND E.WGT_MEAS_UT_CD        = X.WGT_MEAS_UT_CD       " ).append("\n"); 
		query.append("           AND C.CUST_NOMI_TRKR_IND_CD = X.CUST_NOMI_TRKR_IND_CD" ).append("\n"); 
		query.append("           --AND ROWNUM = 1" ).append("\n"); 
		query.append("       ) TRSP_AGMT_RT_SEQ" ).append("\n"); 
		query.append("       ,(SELECT TO_CHAR(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[fm_account_ofc_cd])-1, 'YYYYMMDD') FROM DUAL) AS AGMT_EXP_DT" ).append("\n"); 
		query.append("  FROM TRS_AGMT_TMP X" ).append("\n"); 
		query.append(" WHERE TRSP_TMP_SEQ = @[trsp_tmp_seq]" ).append("\n"); 
		query.append("   AND EQ_KND_CD IS NOT NULL" ).append("\n"); 
		query.append("   AND RT_UPD_STS_CD = 'U'" ).append("\n"); 
		query.append(" GROUP BY TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("         ,TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("         ,TRSP_AGMT_RT_TP_CD" ).append("\n"); 
		query.append("         ,CGO_TP_CD" ).append("\n"); 
		query.append("         ,CUST_NOMI_TRKR_FLG" ).append("\n"); 
		query.append("         ,CUST_CNT_CD" ).append("\n"); 
		query.append("         ,CUST_SEQ" ).append("\n"); 
		query.append("         ,TRSP_COST_MOD_CD" ).append("\n"); 
		query.append("         ,AGMT_TRSP_TP_CD" ).append("\n"); 
		query.append("         ,CMDT_GRP_CD" ).append("\n"); 
		query.append("         ,RAIL_SVC_TP_CD" ).append("\n"); 
		query.append("         ,FM_NOD_CD" ).append("\n"); 
		query.append("         ,VIA_NOD_CD" ).append("\n"); 
		query.append("         ,DOR_NOD_CD" ).append("\n"); 
		query.append("         ,TO_NOD_CD" ).append("\n"); 
		query.append("         ,TRSP_AGMT_DIST" ).append("\n"); 
		query.append("         ,DIST_MEAS_UT_CD" ).append("\n"); 
		query.append("         ,TRSP_DIST_TP_CD" ).append("\n"); 
		query.append("         ,TRSP_AGMT_EQ_TP_CD" ).append("\n"); 
		query.append("         ,TRSP_AGMT_EQ_SZ_CD" ).append("\n"); 
		query.append("         ,WTR_RCV_TERM_CD" ).append("\n"); 
		query.append("         ,WTR_DE_TERM_CD" ).append("\n"); 
		query.append("         ,TRSP_AGMT_BDL_QTY" ).append("\n"); 
		query.append("         ,TO_WGT" ).append("\n"); 
		query.append("         ,WGT_MEAS_UT_CD" ).append("\n"); 
		query.append("         ,EQ_KND_CD" ).append("\n"); 
		query.append("         ,CUST_NOMI_TRKR_IND_CD" ).append("\n"); 

	}
}