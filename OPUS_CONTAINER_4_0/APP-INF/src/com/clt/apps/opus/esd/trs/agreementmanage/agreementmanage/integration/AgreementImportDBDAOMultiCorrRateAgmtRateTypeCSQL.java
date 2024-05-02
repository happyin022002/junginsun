/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AgreementImportDBDAOMultiCorrRateAgmtRateTypeCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.25
*@LastModifier : 김성욱
*@LastVersion : 1.0
* 2016.02.25 김성욱
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

public class AgreementImportDBDAOMultiCorrRateAgmtRateTypeCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Rate Type Update
	  * </pre>
	  */
	public AgreementImportDBDAOMultiCorrRateAgmtRateTypeCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_account_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_account_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_tmp_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.integration").append("\n"); 
		query.append("FileName : AgreementImportDBDAOMultiCorrRateAgmtRateTypeCSQL").append("\n"); 
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
		query.append("INSERT INTO TRS_AGMT_RT_TP (" ).append("\n"); 
		query.append(" TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append(",TRSP_AGMT_SEQ" ).append("\n"); 
		query.append(",TRSP_AGMT_RT_TP_SER_NO" ).append("\n"); 
		query.append(",TRSP_AGMT_RT_TP_CD" ).append("\n"); 
		query.append(",TRSP_BND_CD" ).append("\n"); 
		query.append(",CGO_TP_CD" ).append("\n"); 
		query.append(",SPCL_CGO_CNTR_TP_CD" ).append("\n"); 
		query.append(",CUST_NOMI_TRKR_FLG" ).append("\n"); 
		query.append(",CUST_CNT_CD" ).append("\n"); 
		query.append(",CUST_SEQ" ).append("\n"); 
		query.append(",TRSP_COST_MOD_CD" ).append("\n"); 
		query.append(",AGMT_TRSP_TP_CD" ).append("\n"); 
		query.append(",CMDT_GRP_CD" ).append("\n"); 
		query.append(",RAIL_SVC_TP_CD" ).append("\n"); 
		query.append(",DELT_FLG" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",CRE_DT" ).append("\n"); 
		query.append(",CRE_OFC_CD" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(",UPD_OFC_CD" ).append("\n"); 
		query.append(",UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT TRSP_AGMT_OFC_CTY_CD," ).append("\n"); 
		query.append("       TRSP_AGMT_SEQ," ).append("\n"); 
		query.append("       (SELECT NVL(MAX(TRSP_AGMT_RT_TP_SER_NO),0) FROM TRS_AGMT_RT_TP WHERE TRSP_AGMT_OFC_CTY_CD = XX.TRSP_AGMT_OFC_CTY_CD AND TRSP_AGMT_SEQ = XX.TRSP_AGMT_SEQ)" ).append("\n"); 
		query.append("         + RANK() OVER ( PARTITION BY TRSP_AGMT_OFC_CTY_CD, TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("                         ORDER BY TRSP_AGMT_RT_TP_CD," ).append("\n"); 
		query.append("                                  TRSP_BND_CD," ).append("\n"); 
		query.append("                                  CGO_TP_CD," ).append("\n"); 
		query.append("                                  SPCL_CGO_CNTR_TP_CD," ).append("\n"); 
		query.append("                                  CUST_NOMI_TRKR_FLG," ).append("\n"); 
		query.append("                                  CUST_CNT_CD," ).append("\n"); 
		query.append("                                  CUST_SEQ," ).append("\n"); 
		query.append("                                  TRSP_COST_MOD_CD," ).append("\n"); 
		query.append("                                  AGMT_TRSP_TP_CD," ).append("\n"); 
		query.append("                                  CMDT_GRP_CD," ).append("\n"); 
		query.append("                                  RAIL_SVC_TP_CD) " ).append("\n"); 
		query.append("       AS TRSP_AGMT_RT_TP_SER_NO," ).append("\n"); 
		query.append("       TRSP_AGMT_RT_TP_CD," ).append("\n"); 
		query.append("	   TRSP_BND_CD," ).append("\n"); 
		query.append("       CGO_TP_CD," ).append("\n"); 
		query.append("	   SPCL_CGO_CNTR_TP_CD," ).append("\n"); 
		query.append("       CUST_NOMI_TRKR_FLG," ).append("\n"); 
		query.append("       CUST_CNT_CD," ).append("\n"); 
		query.append("       CUST_SEQ," ).append("\n"); 
		query.append("       TRSP_COST_MOD_CD," ).append("\n"); 
		query.append("       AGMT_TRSP_TP_CD," ).append("\n"); 
		query.append("       CMDT_GRP_CD," ).append("\n"); 
		query.append("       RAIL_SVC_TP_CD," ).append("\n"); 
		query.append("       DELT_FLG," ).append("\n"); 
		query.append("       @[fm_account_usr_id]," ).append("\n"); 
		query.append("       SYSDATE," ).append("\n"); 
		query.append("       @[fm_account_ofc_cd]," ).append("\n"); 
		query.append("       @[fm_account_usr_id]," ).append("\n"); 
		query.append("       @[fm_account_ofc_cd]," ).append("\n"); 
		query.append("       SYSDATE" ).append("\n"); 
		query.append("  FROM " ).append("\n"); 
		query.append("       (" ).append("\n"); 
		query.append("        SELECT X.TRSP_AGMT_OFC_CTY_CD," ).append("\n"); 
		query.append("               X.TRSP_AGMT_SEQ," ).append("\n"); 
		query.append("               X.TRSP_AGMT_RT_TP_CD," ).append("\n"); 
		query.append("               X.TRSP_COST_MOD_CD," ).append("\n"); 
		query.append("               X.AGMT_TRSP_TP_CD," ).append("\n"); 
		query.append("			   X.TRSP_BND_CD," ).append("\n"); 
		query.append("               X.CGO_TP_CD," ).append("\n"); 
		query.append("			   X.SPCL_CGO_CNTR_TP_CD," ).append("\n"); 
		query.append("               X.CUST_NOMI_TRKR_FLG," ).append("\n"); 
		query.append("               X.CUST_CNT_CD," ).append("\n"); 
		query.append("               X.CUST_SEQ," ).append("\n"); 
		query.append("               X.CMDT_GRP_CD," ).append("\n"); 
		query.append("               X.RAIL_SVC_TP_CD," ).append("\n"); 
		query.append("               MAX(X.DELT_FLG) DELT_FLG," ).append("\n"); 
		query.append("               (" ).append("\n"); 
		query.append("                SELECT /*+ INDEX_DESC(TRS_AGMT_RT_TP XPKTRS_AGMT_RT_TP) */" ).append("\n"); 
		query.append("                       TRSP_AGMT_RT_TP_SER_NO" ).append("\n"); 
		query.append("                  FROM TRS_AGMT_RT_TP" ).append("\n"); 
		query.append("                 WHERE TRSP_AGMT_OFC_CTY_CD          = X.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("                   AND TRSP_AGMT_SEQ                 = X.TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("                   AND TRSP_AGMT_RT_TP_CD            = X.TRSP_AGMT_RT_TP_CD" ).append("\n"); 
		query.append("                   AND TRSP_COST_MOD_CD              = X.TRSP_COST_MOD_CD" ).append("\n"); 
		query.append("                   AND AGMT_TRSP_TP_CD               = X.AGMT_TRSP_TP_CD" ).append("\n"); 
		query.append("                   AND NVL(TRSP_BND_CD, 'N')         = NVL(X.TRSP_BND_CD, 'N')" ).append("\n"); 
		query.append("                   AND CGO_TP_CD                     = X.CGO_TP_CD" ).append("\n"); 
		query.append("                   AND NVL(SPCL_CGO_CNTR_TP_CD, 'N') = NVL(X.SPCL_CGO_CNTR_TP_CD, 'N')" ).append("\n"); 
		query.append("                   AND CUST_NOMI_TRKR_FLG            = X.CUST_NOMI_TRKR_FLG" ).append("\n"); 
		query.append("                   AND CUST_CNT_CD                   = X.CUST_CNT_CD" ).append("\n"); 
		query.append("                   AND CUST_SEQ                      = X.CUST_SEQ" ).append("\n"); 
		query.append("                   AND CMDT_GRP_CD                   = X.CMDT_GRP_CD" ).append("\n"); 
		query.append("                   AND RAIL_SVC_TP_CD                = X.RAIL_SVC_TP_CD" ).append("\n"); 
		query.append("                   AND ROWNUM = 1" ).append("\n"); 
		query.append("               ) AS TRSP_AGMT_RT_TP_SER_NO" ).append("\n"); 
		query.append("          FROM TRS_AGMT_TMP X" ).append("\n"); 
		query.append("         WHERE X.TRSP_TMP_SEQ = @[trsp_tmp_seq]" ).append("\n"); 
		query.append("           AND X.ROW_NO IS NOT NULL" ).append("\n"); 
		query.append("         GROUP BY X.TRSP_AGMT_OFC_CTY_CD," ).append("\n"); 
		query.append("                  X.TRSP_AGMT_SEQ," ).append("\n"); 
		query.append("                  X.TRSP_AGMT_RT_TP_CD," ).append("\n"); 
		query.append("                  X.TRSP_COST_MOD_CD," ).append("\n"); 
		query.append("                  X.AGMT_TRSP_TP_CD," ).append("\n"); 
		query.append("				  X.TRSP_BND_CD," ).append("\n"); 
		query.append("                  X.CGO_TP_CD," ).append("\n"); 
		query.append("				  X.SPCL_CGO_CNTR_TP_CD," ).append("\n"); 
		query.append("                  X.CUST_NOMI_TRKR_FLG," ).append("\n"); 
		query.append("                  X.CUST_CNT_CD," ).append("\n"); 
		query.append("                  X.CUST_SEQ," ).append("\n"); 
		query.append("                  X.CMDT_GRP_CD," ).append("\n"); 
		query.append("                  X.RAIL_SVC_TP_CD" ).append("\n"); 
		query.append("       ) XX" ).append("\n"); 
		query.append(" WHERE TRSP_AGMT_RT_TP_SER_NO IS NULL" ).append("\n"); 

	}
}