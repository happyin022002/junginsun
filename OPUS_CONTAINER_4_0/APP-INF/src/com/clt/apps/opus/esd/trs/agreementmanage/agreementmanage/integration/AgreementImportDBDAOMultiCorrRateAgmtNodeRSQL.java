/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AgreementImportDBDAOMultiCorrRateAgmtNodeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.11
*@LastModifier : 김성욱
*@LastVersion : 1.0
* 2016.02.11 김성욱
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

public class AgreementImportDBDAOMultiCorrRateAgmtNodeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Rate Type Node조회
	  * </pre>
	  */
	public AgreementImportDBDAOMultiCorrRateAgmtNodeRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.integration").append("\n"); 
		query.append("FileName : AgreementImportDBDAOMultiCorrRateAgmtNodeRSQL").append("\n"); 
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
		query.append("      ,FM_NOD_CD" ).append("\n"); 
		query.append("      ,VIA_NOD_CD" ).append("\n"); 
		query.append("      ,DOR_NOD_CD" ).append("\n"); 
		query.append("      ,TO_NOD_CD" ).append("\n"); 
		query.append("      ,TRSP_AGMT_DIST" ).append("\n"); 
		query.append("      ,DIST_MEAS_UT_CD" ).append("\n"); 
		query.append("      ,TRSP_DIST_TP_CD" ).append("\n"); 
		query.append("      ,TRSP_AGMT_RT_TP_SER_NO" ).append("\n"); 
		query.append("      ,TRSP_AGMT_NOD_SEQ" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("              ,TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("              ,FM_NOD_CD" ).append("\n"); 
		query.append("              ,VIA_NOD_CD" ).append("\n"); 
		query.append("              ,DOR_NOD_CD" ).append("\n"); 
		query.append("              ,TO_NOD_CD" ).append("\n"); 
		query.append("              ,TRSP_AGMT_DIST" ).append("\n"); 
		query.append("              ,DIST_MEAS_UT_CD" ).append("\n"); 
		query.append("              ,TRSP_DIST_TP_CD" ).append("\n"); 
		query.append("              ,(" ).append("\n"); 
		query.append("                SELECT /*+ INDEX_DESC(B XPKTRS_AGMT_NOD) */" ).append("\n"); 
		query.append("                       B.TRSP_AGMT_RT_TP_SER_NO" ).append("\n"); 
		query.append("                  FROM TRS_AGMT_RT_TP A" ).append("\n"); 
		query.append("                      ,TRS_AGMT_NOD   B" ).append("\n"); 
		query.append("                 WHERE A.TRSP_AGMT_OFC_CTY_CD          = B.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("                   AND A.TRSP_AGMT_SEQ                 = B.TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("                   AND A.TRSP_AGMT_RT_TP_SER_NO        = B.TRSP_AGMT_RT_TP_SER_NO" ).append("\n"); 
		query.append("                   AND A.TRSP_AGMT_OFC_CTY_CD          = X.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("                   AND A.TRSP_AGMT_SEQ                 = X.TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("                   AND A.TRSP_AGMT_RT_TP_CD            = X.TRSP_AGMT_RT_TP_CD" ).append("\n"); 
		query.append("                   AND A.TRSP_COST_MOD_CD              = X.TRSP_COST_MOD_CD" ).append("\n"); 
		query.append("                   AND A.AGMT_TRSP_TP_CD               = X.AGMT_TRSP_TP_CD" ).append("\n"); 
		query.append("                   AND NVL(A.TRSP_BND_CD, 'N')         = NVL(X.TRSP_BND_CD, 'N')" ).append("\n"); 
		query.append("                   AND A.CGO_TP_CD                     = X.CGO_TP_CD" ).append("\n"); 
		query.append("                   AND NVL(A.SPCL_CGO_CNTR_TP_CD, 'N') = NVL(X.SPCL_CGO_CNTR_TP_CD, 'N')" ).append("\n"); 
		query.append("                   AND A.CUST_NOMI_TRKR_FLG            = X.CUST_NOMI_TRKR_FLG" ).append("\n"); 
		query.append("                   AND A.CUST_CNT_CD                   = X.CUST_CNT_CD" ).append("\n"); 
		query.append("                   AND A.CUST_SEQ                      = X.CUST_SEQ" ).append("\n"); 
		query.append("                   AND A.CMDT_GRP_CD                   = X.CMDT_GRP_CD" ).append("\n"); 
		query.append("                   AND A.RAIL_SVC_TP_CD                = X.RAIL_SVC_TP_CD" ).append("\n"); 
		query.append("                   AND B.FM_NOD_CD                     = X.FM_NOD_CD" ).append("\n"); 
		query.append("                   AND B.VIA_NOD_CD                    = X.VIA_NOD_CD" ).append("\n"); 
		query.append("                   AND B.DOR_NOD_CD                    = X.DOR_NOD_CD" ).append("\n"); 
		query.append("                   AND B.TO_NOD_CD                     = X.TO_NOD_CD" ).append("\n"); 
		query.append("                   AND B.TRSP_AGMT_DIST                = X.TRSP_AGMT_DIST" ).append("\n"); 
		query.append("                   AND B.DIST_MEAS_UT_CD               = X.DIST_MEAS_UT_CD" ).append("\n"); 
		query.append("                   AND B.TRSP_DIST_TP_CD               = X.TRSP_DIST_TP_CD" ).append("\n"); 
		query.append("                   AND ROWNUM = 1" ).append("\n"); 
		query.append("               ) TRSP_AGMT_RT_TP_SER_NO" ).append("\n"); 
		query.append("              ,(" ).append("\n"); 
		query.append("                SELECT /*+ INDEX_DESC(B XPKTRS_AGMT_NOD) */" ).append("\n"); 
		query.append("                       B.TRSP_AGMT_NOD_SEQ" ).append("\n"); 
		query.append("                  FROM TRS_AGMT_RT_TP A" ).append("\n"); 
		query.append("                      ,TRS_AGMT_NOD   B" ).append("\n"); 
		query.append("                 WHERE A.TRSP_AGMT_OFC_CTY_CD          = B.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("                   AND A.TRSP_AGMT_SEQ                 = B.TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("                   AND A.TRSP_AGMT_RT_TP_SER_NO        = B.TRSP_AGMT_RT_TP_SER_NO" ).append("\n"); 
		query.append("                   AND A.TRSP_AGMT_OFC_CTY_CD          = X.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("                   AND A.TRSP_AGMT_SEQ                 = X.TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("                   AND A.TRSP_AGMT_RT_TP_CD            = X.TRSP_AGMT_RT_TP_CD" ).append("\n"); 
		query.append("                   AND A.TRSP_COST_MOD_CD              = X.TRSP_COST_MOD_CD" ).append("\n"); 
		query.append("                   AND A.AGMT_TRSP_TP_CD               = X.AGMT_TRSP_TP_CD" ).append("\n"); 
		query.append("                   AND NVL(A.TRSP_BND_CD, 'N')         = NVL(X.TRSP_BND_CD, 'N')" ).append("\n"); 
		query.append("                   AND A.CGO_TP_CD                     = X.CGO_TP_CD" ).append("\n"); 
		query.append("                   AND NVL(A.SPCL_CGO_CNTR_TP_CD, 'N') = NVL(X.SPCL_CGO_CNTR_TP_CD, 'N')" ).append("\n"); 
		query.append("                   AND A.CUST_NOMI_TRKR_FLG            = X.CUST_NOMI_TRKR_FLG" ).append("\n"); 
		query.append("                   AND A.CUST_CNT_CD                   = X.CUST_CNT_CD" ).append("\n"); 
		query.append("                   AND A.CUST_SEQ                      = X.CUST_SEQ" ).append("\n"); 
		query.append("                   AND A.CMDT_GRP_CD                   = X.CMDT_GRP_CD" ).append("\n"); 
		query.append("                   AND A.RAIL_SVC_TP_CD                = X.RAIL_SVC_TP_CD" ).append("\n"); 
		query.append("                   AND B.FM_NOD_CD                     = X.FM_NOD_CD" ).append("\n"); 
		query.append("                   AND B.VIA_NOD_CD                    = X.VIA_NOD_CD" ).append("\n"); 
		query.append("                   AND B.DOR_NOD_CD                    = X.DOR_NOD_CD" ).append("\n"); 
		query.append("                   AND B.TO_NOD_CD                     = X.TO_NOD_CD" ).append("\n"); 
		query.append("                   AND B.TRSP_AGMT_DIST                = X.TRSP_AGMT_DIST" ).append("\n"); 
		query.append("                   AND B.DIST_MEAS_UT_CD               = X.DIST_MEAS_UT_CD" ).append("\n"); 
		query.append("                   AND B.TRSP_DIST_TP_CD               = X.TRSP_DIST_TP_CD" ).append("\n"); 
		query.append("                   AND ROWNUM = 1" ).append("\n"); 
		query.append("               ) TRSP_AGMT_NOD_SEQ" ).append("\n"); 
		query.append("          FROM TRS_AGMT_TMP X" ).append("\n"); 
		query.append("         WHERE TRSP_TMP_SEQ = @[trsp_tmp_seq]" ).append("\n"); 
		query.append("           AND ROW_NO IS NOT NULL" ).append("\n"); 
		query.append("         GROUP BY TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("                 ,TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("                 ,TRSP_AGMT_RT_TP_CD" ).append("\n"); 
		query.append("                 ,TRSP_COST_MOD_CD" ).append("\n"); 
		query.append("                 ,AGMT_TRSP_TP_CD" ).append("\n"); 
		query.append("                 ,TRSP_BND_CD" ).append("\n"); 
		query.append("                 ,CGO_TP_CD" ).append("\n"); 
		query.append("                 ,SPCL_CGO_CNTR_TP_CD" ).append("\n"); 
		query.append("                 ,CUST_NOMI_TRKR_FLG" ).append("\n"); 
		query.append("                 ,CUST_CNT_CD" ).append("\n"); 
		query.append("                 ,CUST_SEQ" ).append("\n"); 
		query.append("                 ,CMDT_GRP_CD" ).append("\n"); 
		query.append("                 ,RAIL_SVC_TP_CD" ).append("\n"); 
		query.append("                 ,FM_NOD_CD" ).append("\n"); 
		query.append("                 ,VIA_NOD_CD" ).append("\n"); 
		query.append("                 ,DOR_NOD_CD" ).append("\n"); 
		query.append("                 ,TO_NOD_CD" ).append("\n"); 
		query.append("                 ,TRSP_AGMT_DIST" ).append("\n"); 
		query.append("                 ,DIST_MEAS_UT_CD" ).append("\n"); 
		query.append("                 ,TRSP_DIST_TP_CD" ).append("\n"); 
		query.append("        )" ).append("\n"); 

	}
}