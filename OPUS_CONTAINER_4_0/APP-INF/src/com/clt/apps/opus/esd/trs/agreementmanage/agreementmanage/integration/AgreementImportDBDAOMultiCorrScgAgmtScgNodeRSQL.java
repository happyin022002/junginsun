/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AgreementImportDBDAOMultiCorrScgAgmtScgNodeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.01
*@LastModifier : 박찬우
*@LastVersion : 1.0
* 2015.06.01 박찬우
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Chanwoo Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AgreementImportDBDAOMultiCorrScgAgmtScgNodeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Surcharge Rate Type Node 조회
	  * </pre>
	  */
	public AgreementImportDBDAOMultiCorrScgAgmtScgNodeRSQL(){
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
		query.append("FileName : AgreementImportDBDAOMultiCorrScgAgmtScgNodeRSQL").append("\n"); 
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
		query.append("       X.FM_NOD_CD," ).append("\n"); 
		query.append("       X.VIA_NOD_CD," ).append("\n"); 
		query.append("       X.DOR_NOD_CD," ).append("\n"); 
		query.append("       X.TO_NOD_CD," ).append("\n"); 
		query.append("       X.TRSP_SCG_CD," ).append("\n"); 
		query.append("       X.AGMT_ROUT_ALL_FLG," ).append("\n"); 
		query.append("       (SELECT TRSP_AGMT_RT_TP_SER_NO" ).append("\n"); 
		query.append("          FROM TRS_AGMT_RT_TP" ).append("\n"); 
		query.append("         WHERE TRSP_AGMT_OFC_CTY_CD          = X.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("           AND TRSP_AGMT_SEQ                 = X.TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("           AND TRSP_AGMT_RT_TP_CD            = X.TRSP_AGMT_RT_TP_CD" ).append("\n"); 
		query.append("           AND NVL(TRSP_BND_CD, 'X')         = NVL(X.TRSP_BND_CD, 'X')" ).append("\n"); 
		query.append("           AND CGO_TP_CD                     = X.CGO_TP_CD" ).append("\n"); 
		query.append("           AND NVL(SPCL_CGO_CNTR_TP_CD, 'N') = NVL(X.SPCL_CGO_CNTR_TP_CD, 'N')" ).append("\n"); 
		query.append("           AND CUST_NOMI_TRKR_FLG            = X.CUST_NOMI_TRKR_FLG" ).append("\n"); 
		query.append("           AND CUST_CNT_CD                   = X.CUST_CNT_CD" ).append("\n"); 
		query.append("           AND CUST_SEQ                      = X.CUST_SEQ" ).append("\n"); 
		query.append("           AND TRSP_COST_MOD_CD              = X.TRSP_COST_MOD_CD" ).append("\n"); 
		query.append("           AND AGMT_TRSP_TP_CD               = X.AGMT_TRSP_TP_CD" ).append("\n"); 
		query.append("           AND CMDT_GRP_CD                   = X.CMDT_GRP_CD" ).append("\n"); 
		query.append("           AND RAIL_SVC_TP_CD                = X.RAIL_SVC_TP_CD" ).append("\n"); 
		query.append("           AND ROWNUM = 1" ).append("\n"); 
		query.append("       ) TRSP_AGMT_RT_TP_SER_NO," ).append("\n"); 
		query.append("       (" ).append("\n"); 
		query.append("        SELECT TRSP_AGMT_SCG_NOD_SEQ" ).append("\n"); 
		query.append("          FROM TRS_AGMT_RT_TP   A," ).append("\n"); 
		query.append("               TRS_AGMT_SCG_NOD B" ).append("\n"); 
		query.append("         WHERE A.TRSP_AGMT_OFC_CTY_CD          = B.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("           AND A.TRSP_AGMT_SEQ                 = B.TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("           AND A.TRSP_AGMT_RT_TP_SER_NO        = B.TRSP_AGMT_RT_TP_SER_NO" ).append("\n"); 
		query.append("           AND A.TRSP_AGMT_OFC_CTY_CD          = X.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("           AND A.TRSP_AGMT_SEQ                 = X.TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("           AND A.TRSP_AGMT_RT_TP_CD            = X.TRSP_AGMT_RT_TP_CD" ).append("\n"); 
		query.append("           AND NVL(A.TRSP_BND_CD, 'X')         = NVL(X.TRSP_BND_CD, 'X')" ).append("\n"); 
		query.append("           AND A.CGO_TP_CD                     = X.CGO_TP_CD" ).append("\n"); 
		query.append("           AND NVL(A.SPCL_CGO_CNTR_TP_CD, 'N') = NVL(X.SPCL_CGO_CNTR_TP_CD, 'N')" ).append("\n"); 
		query.append("           AND A.CUST_NOMI_TRKR_FLG            = X.CUST_NOMI_TRKR_FLG" ).append("\n"); 
		query.append("           AND A.CUST_CNT_CD                   = X.CUST_CNT_CD" ).append("\n"); 
		query.append("           AND A.CUST_SEQ                      = X.CUST_SEQ" ).append("\n"); 
		query.append("           AND A.TRSP_COST_MOD_CD              = X.TRSP_COST_MOD_CD" ).append("\n"); 
		query.append("           AND A.AGMT_TRSP_TP_CD               = X.AGMT_TRSP_TP_CD" ).append("\n"); 
		query.append("           AND A.CMDT_GRP_CD                   = X.CMDT_GRP_CD" ).append("\n"); 
		query.append("           AND A.RAIL_SVC_TP_CD                = X.RAIL_SVC_TP_CD" ).append("\n"); 
		query.append("           AND B.FM_NOD_CD                     = X.FM_NOD_CD" ).append("\n"); 
		query.append("           AND B.VIA_NOD_CD                    = X.VIA_NOD_CD" ).append("\n"); 
		query.append("           AND B.DOR_NOD_CD                    = X.DOR_NOD_CD" ).append("\n"); 
		query.append("           AND B.TO_NOD_CD                     = X.TO_NOD_CD" ).append("\n"); 
		query.append("           AND B.TRSP_SCG_CD                   = X.TRSP_SCG_CD" ).append("\n"); 
		query.append("           AND B.AGMT_ROUT_ALL_FLG             = X.AGMT_ROUT_ALL_FLG" ).append("\n"); 
		query.append("           AND ROWNUM = 1" ).append("\n"); 
		query.append("       ) AS TRSP_AGMT_SCG_NOD_SEQ" ).append("\n"); 
		query.append("  FROM TRS_AGMT_TMP X" ).append("\n"); 
		query.append(" WHERE X.TRSP_TMP_SEQ = @[trsp_tmp_seq]" ).append("\n"); 
		query.append("   AND X.ROW_NO IS NOT NULL" ).append("\n"); 
		query.append(" GROUP BY X.TRSP_AGMT_OFC_CTY_CD," ).append("\n"); 
		query.append("          X.TRSP_AGMT_SEQ," ).append("\n"); 
		query.append("          X.TRSP_AGMT_RT_TP_CD," ).append("\n"); 
		query.append("          X.TRSP_BND_CD," ).append("\n"); 
		query.append("          X.CGO_TP_CD," ).append("\n"); 
		query.append("          X.SPCL_CGO_CNTR_TP_CD," ).append("\n"); 
		query.append("          X.CUST_NOMI_TRKR_FLG," ).append("\n"); 
		query.append("          X.CUST_CNT_CD," ).append("\n"); 
		query.append("          X.CUST_SEQ," ).append("\n"); 
		query.append("          X.TRSP_COST_MOD_CD," ).append("\n"); 
		query.append("          X.AGMT_TRSP_TP_CD," ).append("\n"); 
		query.append("          X.CMDT_GRP_CD," ).append("\n"); 
		query.append("          X.RAIL_SVC_TP_CD," ).append("\n"); 
		query.append("          X.TRSP_SCG_CD," ).append("\n"); 
		query.append("          X.AGMT_ROUT_ALL_FLG," ).append("\n"); 
		query.append("          X.FM_NOD_CD," ).append("\n"); 
		query.append("          X.VIA_NOD_CD," ).append("\n"); 
		query.append("          X.DOR_NOD_CD," ).append("\n"); 
		query.append("          X.TO_NOD_CD" ).append("\n"); 

	}
}