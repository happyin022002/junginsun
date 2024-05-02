/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AgreementImportDBDAOMultiCorrRateAgmtEqRateRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.05
*@LastModifier : 김성욱
*@LastVersion : 1.0
* 2016.02.05 김성욱
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sung-Wook Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AgreementImportDBDAOMultiCorrRateAgmtEqRateRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Agreement Rate 조회
	  * </pre>
	  */
	public AgreementImportDBDAOMultiCorrRateAgmtEqRateRSQL(){
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
		params.put("chk_delt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.integration").append("\n"); 
		query.append("FileName : AgreementImportDBDAOMultiCorrRateAgmtEqRateRSQL").append("\n"); 
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
		query.append("      ,TO_CHAR(MAX(EFF_FM_DT),'YYYYMMDDHH24MISS') AS EFF_FM_DT" ).append("\n"); 
		query.append("      ,TO_CHAR(MAX(EFF_TO_DT),'YYYYMMDDHH24MISS') AS EFF_TO_DT" ).append("\n"); 
		query.append("      ,MAX(CURR_CD) CURR_CD" ).append("\n"); 
		query.append("      ,MAX(TRSP_ONE_WY_RT) TRSP_ONE_WY_RT" ).append("\n"); 
		query.append("      ,MAX(TRSP_RND_RT) TRSP_RND_RT" ).append("\n"); 
		query.append("      ,WTR_RCV_TERM_CD" ).append("\n"); 
		query.append("      ,WTR_DE_TERM_CD" ).append("\n"); 
		query.append("      ,TRSP_AGMT_BDL_QTY" ).append("\n"); 
		query.append("      ,TO_WGT" ).append("\n"); 
		query.append("      ,WGT_MEAS_UT_CD" ).append("\n"); 
		query.append("      ,MAX(TRSP_RVS_APLY_FLG) TRSP_RVS_APLY_FLG" ).append("\n"); 
		query.append("      ,TRSP_AGMT_EQ_TP_CD||TRSP_AGMT_EQ_SZ_CD TRSP_AGMT_EQ_TP_SZ_CD" ).append("\n"); 
		query.append("      ,EQ_KND_CD" ).append("\n"); 
		query.append("      ,USR_DEF_RMK" ).append("\n"); 
		query.append("      ,AFT_USR_DEF_RMK" ).append("\n"); 
		query.append("      ,DELT_FLG" ).append("\n"); 
		query.append("      ,(" ).append("\n"); 
		query.append("        SELECT /*+ INDEX_DESC(E XPKTRS_AGMT_EQ_RT) */" ).append("\n"); 
		query.append("               E.TRSP_AGMT_RT_TP_SER_NO" ).append("\n"); 
		query.append("          FROM TRS_AGMT_HDR   A" ).append("\n"); 
		query.append("              ,TRS_AGMT_RT_TP C" ).append("\n"); 
		query.append("              ,TRS_AGMT_NOD   D" ).append("\n"); 
		query.append("              ,TRS_AGMT_EQ_RT E" ).append("\n"); 
		query.append("         WHERE A.TRSP_AGMT_OFC_CTY_CD          = C.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("           AND A.TRSP_AGMT_SEQ                 = C.TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("           AND C.TRSP_AGMT_OFC_CTY_CD          = D.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("           AND C.TRSP_AGMT_SEQ                 = D.TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("           AND C.TRSP_AGMT_RT_TP_SER_NO        = D.TRSP_AGMT_RT_TP_SER_NO" ).append("\n"); 
		query.append("           AND D.TRSP_AGMT_OFC_CTY_CD          = E.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("           AND D.TRSP_AGMT_SEQ                 = E.TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("           AND D.TRSP_AGMT_RT_TP_SER_NO        = E.TRSP_AGMT_RT_TP_SER_NO" ).append("\n"); 
		query.append("           AND D.TRSP_AGMT_NOD_SEQ             = E.TRSP_AGMT_NOD_SEQ" ).append("\n"); 
		query.append("           AND C.TRSP_AGMT_OFC_CTY_CD          = X.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("           AND C.TRSP_AGMT_SEQ                 = X.TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("           AND E.TRSP_AGMT_RT_SEQ              = NVL(X.TRSP_AGMT_RT_SEQ,0)" ).append("\n"); 
		query.append("           AND ROWNUM = 1" ).append("\n"); 
		query.append("       ) TRSP_AGMT_RT_TP_SER_NO" ).append("\n"); 
		query.append("      ,(" ).append("\n"); 
		query.append("        SELECT /*+ INDEX_DESC(E XPKTRS_AGMT_EQ_RT) */" ).append("\n"); 
		query.append("               E.TRSP_AGMT_NOD_SEQ" ).append("\n"); 
		query.append("          FROM TRS_AGMT_HDR   A" ).append("\n"); 
		query.append("              ,TRS_AGMT_RT_TP C" ).append("\n"); 
		query.append("              ,TRS_AGMT_NOD   D" ).append("\n"); 
		query.append("              ,TRS_AGMT_EQ_RT E" ).append("\n"); 
		query.append("         WHERE A.TRSP_AGMT_OFC_CTY_CD          = C.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("           AND A.TRSP_AGMT_SEQ                 = C.TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("           AND C.TRSP_AGMT_OFC_CTY_CD          = D.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("           AND C.TRSP_AGMT_SEQ                 = D.TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("           AND C.TRSP_AGMT_RT_TP_SER_NO        = D.TRSP_AGMT_RT_TP_SER_NO" ).append("\n"); 
		query.append("           AND D.TRSP_AGMT_OFC_CTY_CD          = E.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("           AND D.TRSP_AGMT_SEQ                 = E.TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("           AND D.TRSP_AGMT_RT_TP_SER_NO        = E.TRSP_AGMT_RT_TP_SER_NO" ).append("\n"); 
		query.append("           AND D.TRSP_AGMT_NOD_SEQ             = E.TRSP_AGMT_NOD_SEQ" ).append("\n"); 
		query.append("           AND C.TRSP_AGMT_OFC_CTY_CD          = X.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("           AND C.TRSP_AGMT_SEQ                 = X.TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("           AND E.TRSP_AGMT_RT_SEQ              = NVL(X.TRSP_AGMT_RT_SEQ,0)" ).append("\n"); 
		query.append("           AND ROWNUM = 1" ).append("\n"); 
		query.append("       ) TRSP_AGMT_NOD_SEQ" ).append("\n"); 
		query.append("      ,(" ).append("\n"); 
		query.append("        SELECT /*+ INDEX_DESC(E XPKTRS_AGMT_EQ_RT) */" ).append("\n"); 
		query.append("               E.TRSP_AGMT_RT_SEQ" ).append("\n"); 
		query.append("          FROM TRS_AGMT_HDR   A" ).append("\n"); 
		query.append("              ,TRS_AGMT_RT_TP C" ).append("\n"); 
		query.append("              ,TRS_AGMT_NOD   D" ).append("\n"); 
		query.append("              ,TRS_AGMT_EQ_RT E" ).append("\n"); 
		query.append("         WHERE A.TRSP_AGMT_OFC_CTY_CD          = C.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("           AND A.TRSP_AGMT_SEQ                 = C.TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("           AND C.TRSP_AGMT_OFC_CTY_CD          = D.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("           AND C.TRSP_AGMT_SEQ                 = D.TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("           AND C.TRSP_AGMT_RT_TP_SER_NO        = D.TRSP_AGMT_RT_TP_SER_NO" ).append("\n"); 
		query.append("           AND D.TRSP_AGMT_OFC_CTY_CD          = E.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("           AND D.TRSP_AGMT_SEQ                 = E.TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("           AND D.TRSP_AGMT_RT_TP_SER_NO        = E.TRSP_AGMT_RT_TP_SER_NO" ).append("\n"); 
		query.append("           AND D.TRSP_AGMT_NOD_SEQ             = E.TRSP_AGMT_NOD_SEQ" ).append("\n"); 
		query.append("           AND C.TRSP_AGMT_OFC_CTY_CD          = X.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("           AND C.TRSP_AGMT_SEQ                 = X.TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("           AND E.TRSP_AGMT_RT_SEQ              = NVL(X.TRSP_AGMT_RT_SEQ,0)" ).append("\n"); 
		query.append("           AND ROWNUM = 1" ).append("\n"); 
		query.append("       ) TRSP_AGMT_RT_SEQ" ).append("\n"); 
		query.append("  FROM TRS_AGMT_TMP X" ).append("\n"); 
		query.append(" WHERE TRSP_TMP_SEQ = @[trsp_tmp_seq]" ).append("\n"); 
		query.append("   AND DELT_FLG = @[chk_delt]" ).append("\n"); 
		query.append("   AND ROW_NO IS NOT NULL" ).append("\n"); 
		query.append(" GROUP BY TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("         ,TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("         ,TRSP_AGMT_RT_SEQ" ).append("\n"); 
		query.append("         ,TRSP_AGMT_RT_TP_CD" ).append("\n"); 
		query.append("         ,TRSP_COST_MOD_CD" ).append("\n"); 
		query.append("         ,AGMT_TRSP_TP_CD" ).append("\n"); 
		query.append("         ,TRSP_BND_CD" ).append("\n"); 
		query.append("         ,CGO_TP_CD" ).append("\n"); 
		query.append("         ,SPCL_CGO_CNTR_TP_CD" ).append("\n"); 
		query.append("         ,CUST_NOMI_TRKR_FLG" ).append("\n"); 
		query.append("         ,CUST_CNT_CD" ).append("\n"); 
		query.append("         ,CUST_SEQ" ).append("\n"); 
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
		query.append("         ,EQ_KND_CD" ).append("\n"); 
		query.append("         ,DELT_FLG" ).append("\n"); 
		query.append("         ,RT_UPD_STS_CD" ).append("\n"); 
		query.append("         ,WTR_RCV_TERM_CD" ).append("\n"); 
		query.append("         ,WTR_DE_TERM_CD" ).append("\n"); 
		query.append("         ,TRSP_AGMT_BDL_QTY" ).append("\n"); 
		query.append("         ,TO_WGT" ).append("\n"); 
		query.append("         ,WGT_MEAS_UT_CD" ).append("\n"); 
		query.append("         ,EFF_FM_DT" ).append("\n"); 
		query.append("         ,EFF_TO_DT" ).append("\n"); 
		query.append("         ,AFT_USR_DEF_RMK" ).append("\n"); 
		query.append("         ,USR_DEF_RMK" ).append("\n"); 

	}
}