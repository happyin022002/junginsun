/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AgreementImportDBDAOMultiCorrScgAgmtScgRateRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.27
*@LastModifier : 김성욱
*@LastVersion : 1.0
* 2016.06.27 김성욱
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

public class AgreementImportDBDAOMultiCorrScgAgmtScgRateRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Surcharge Rate 조회
	  * </pre>
	  */
	public AgreementImportDBDAOMultiCorrScgAgmtScgRateRSQL(){
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
		query.append("FileName : AgreementImportDBDAOMultiCorrScgAgmtScgRateRSQL").append("\n"); 
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
		query.append("SELECT X.TRSP_AGMT_OFC_CTY_CD," ).append("\n"); 
		query.append("       X.TRSP_AGMT_SEQ," ).append("\n"); 
		query.append("       TO_CHAR(NVL(X.EFF_FM_DT, TO_DATE('19000101', 'YYYYMMDD')), 'YYYYMMDDHH24MISS') AS EFF_FM_DT," ).append("\n"); 
		query.append("       TO_CHAR(NVL(X.EFF_TO_DT, TO_DATE('99991231', 'YYYYMMDD')), 'YYYYMMDDHH24MISS') AS EFF_TO_DT," ).append("\n"); 
		query.append("       X.TO_WGT," ).append("\n"); 
		query.append("       X.WGT_MEAS_UT_CD," ).append("\n"); 
		query.append("       X.CURR_CD," ).append("\n"); 
		query.append("       X.TRSP_ONE_WY_RT," ).append("\n"); 
		query.append("       X.TRSP_RND_RT," ).append("\n"); 
		query.append("       NVL(X.TRSP_AGMT_EQ_TP_CD, 'XX') || NVL(X.TRSP_AGMT_EQ_SZ_CD, '') AS TRSP_AGMT_EQ_TP_SZ_CD," ).append("\n"); 
		query.append("       X.EQ_KND_CD," ).append("\n"); 
		query.append("       USR_DEF_RMK," ).append("\n"); 
		query.append("       AFT_USR_DEF_RMK," ).append("\n"); 
		query.append("       X.DELT_FLG," ).append("\n"); 
		query.append("       X.AGMT_SCG_RT_DIV_CD," ).append("\n"); 
		query.append("              (" ).append("\n"); 
		query.append("                SELECT /*+ INDEX_DESC(A XPKTRS_AGMT_RT_TP) */" ).append("\n"); 
		query.append("                       A.TRSP_AGMT_RT_TP_SER_NO" ).append("\n"); 
		query.append("                  FROM TRS_AGMT_RT_TP A" ).append("\n"); 
		query.append("                 WHERE A.TRSP_AGMT_OFC_CTY_CD          = X.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
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
		query.append("                   AND ROWNUM = 1" ).append("\n"); 
		query.append("               ) TRSP_AGMT_RT_TP_SER_NO," ).append("\n"); 
		query.append("              (" ).append("\n"); 
		query.append("                SELECT /*+ INDEX_DESC(B XPKTRS_AGMT_SCG_NOD) */" ).append("\n"); 
		query.append("                       B.TRSP_AGMT_SCG_NOD_SEQ" ).append("\n"); 
		query.append("                  FROM TRS_AGMT_RT_TP A" ).append("\n"); 
		query.append("                      ,TRS_AGMT_SCG_NOD   B" ).append("\n"); 
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
		query.append("                   AND B.TRSP_SCG_CD                   = X.TRSP_SCG_CD" ).append("\n"); 
		query.append("                   AND B.AGMT_ROUT_ALL_FLG             = X.AGMT_ROUT_ALL_FLG" ).append("\n"); 
		query.append("                   AND ROWNUM = 1" ).append("\n"); 
		query.append("               ) TRSP_AGMT_SCG_NOD_SEQ," ).append("\n"); 
		query.append("       X.TRSP_AGMT_RT_SEQ TRSP_AGMT_SCG_RT_SEQ," ).append("\n"); 
		query.append("       X.COM_SCG_APLY_FLG," ).append("\n"); 
		query.append("       X.WO_APLY_FLG," ).append("\n"); 
		query.append("       X.AGMT_COST_FLG" ).append("\n"); 
		query.append("  FROM TRS_AGMT_TMP X" ).append("\n"); 
		query.append(" WHERE X.TRSP_TMP_SEQ = @[trsp_tmp_seq]" ).append("\n"); 
		query.append("   AND X.DELT_FLG = @[chk_delt]" ).append("\n"); 
		query.append("   AND X.ROW_NO IS NOT NULL" ).append("\n"); 
		query.append("   AND X.TRSP_AGMT_RT_SEQ IS NULL" ).append("\n"); 

	}
}