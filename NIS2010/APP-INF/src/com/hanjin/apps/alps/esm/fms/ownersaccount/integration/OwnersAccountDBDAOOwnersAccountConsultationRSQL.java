/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : OwnersAccountDBDAOOwnersAccountConsultationRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.01
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.01 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.ownersaccount.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OwnersAccountDBDAOOwnersAccountConsultationRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    FMS_CONSULTATION 전표 헤더 조회
	  * </pre>
	  */
	public OwnersAccountDBDAOOwnersAccountConsultationRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("csr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.fms.ownersaccount.integration").append("\n"); 
		query.append("FileName : OwnersAccountDBDAOOwnersAccountConsultationRSQL").append("\n"); 
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
		query.append("SELECT SLP_TP_CD ," ).append("\n"); 
		query.append("       SLP_FUNC_CD ," ).append("\n"); 
		query.append("       SLP_OFC_CD ," ).append("\n"); 
		query.append("       SLP_ISS_DT ," ).append("\n"); 
		query.append("       SLP_SER_NO ," ).append("\n"); 
		query.append("       CSR_CURR_CD ," ).append("\n"); 
		query.append("       CSR_AMT T_CSR_AMT ," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--       TO_CHAR(TO_DATE(OA_INV_DT), 'YYYY-MM-DD') OA_INV_DT ," ).append("\n"); 
		query.append("--       TO_CHAR(TO_DATE(EFF_DT), 'YYYY-MM-DD') EFF_DT ," ).append("\n"); 
		query.append("--       TO_CHAR(TO_DATE(RQST_DT), 'YYYY-MM-DD') RQST_DT , " ).append("\n"); 
		query.append("OA_INV_DT ," ).append("\n"); 
		query.append("EFF_DT ," ).append("\n"); 
		query.append("RQST_DT ," ).append("\n"); 
		query.append("       CSR_DESC T_CSR_DESC ," ).append("\n"); 
		query.append("       OA_INTER_MM_DESC ," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	   SLP_TP_CD ORG_SLP_TP_CD ," ).append("\n"); 
		query.append("       SLP_FUNC_CD ORG_SLP_FUNC_CD ," ).append("\n"); 
		query.append("       SLP_OFC_CD ORG_SLP_OFC_CD ," ).append("\n"); 
		query.append("       SLP_ISS_DT ORG_SLP_ISS_DT ," ).append("\n"); 
		query.append("       SLP_SER_NO ORG_SLP_SER_NO" ).append("\n"); 
		query.append("	   ,EVID_TP_CD" ).append("\n"); 
		query.append("	   ,ASA_NO" ).append("\n"); 
		query.append("      ,(" ).append("\n"); 
		query.append("        SELECT AA.SLP_TP_CD||AA.SLP_FUNC_CD||AA.SLP_OFC_CD||AA.SLP_ISS_DT||AA.SLP_SER_NO FROM FMS_CONSULTATION AA" ).append("\n"); 
		query.append("        WHERE AA.VAT_SLP_TP_CD||AA.VAT_SLP_FUNC_CD||AA.VAT_SLP_OFC_CD||AA.VAT_SLP_ISS_DT||AA.VAT_SLP_SER_NO = @[csr_no]" ).append("\n"); 
		query.append("      ) AS VAT_CSR_NO" ).append("\n"); 
		query.append("      ,(" ).append("\n"); 
		query.append("        SELECT DISTINCT B.APRO_RQST_NO  FROM COM_APRO_CSR_DTL   B" ).append("\n"); 
		query.append("        WHERE B.CSR_NO = @[csr_no]" ).append("\n"); 
		query.append("        AND B.DELT_FLG = 'N'" ).append("\n"); 
		query.append("       ) AS APRO_RQST_NO " ).append("\n"); 
		query.append("  FROM FMS_CONSULTATION" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND SLP_TP_CD||SLP_FUNC_CD||SLP_OFC_CD||SLP_ISS_DT||SLP_SER_NO = @[csr_no]" ).append("\n"); 

	}
}