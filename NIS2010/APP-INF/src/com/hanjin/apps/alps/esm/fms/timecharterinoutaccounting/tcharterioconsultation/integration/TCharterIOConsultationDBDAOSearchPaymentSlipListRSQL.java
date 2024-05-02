/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TCharterIOConsultationDBDAOSearchPaymentSlipListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.01
*@LastModifier : 정윤태
*@LastVersion : 1.0
* 2009.09.01 정윤태
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author JUNGYOONTAE
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TCharterIOConsultationDBDAOSearchPaymentSlipListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TCharterIOConsultationDBDAOSearchPaymentSlipListRSQL
	  * </pre>
	  */
	public TCharterIOConsultationDBDAOSearchPaymentSlipListRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.integration").append("\n"); 
		query.append("FileName : TCharterIOConsultationDBDAOSearchPaymentSlipListRSQL").append("\n"); 
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
		query.append("SELECT SLP_SEQ_NO SLP_SEQ_NUM," ).append("\n"); 
		query.append("ACCT_CD," ).append("\n"); 
		query.append("VNDR_SEQ," ).append("\n"); 
		query.append("CTR_CD," ).append("\n"); 
		query.append("SLP_LOC_CD," ).append("\n"); 
		query.append("(SELECT EFF_DT" ).append("\n"); 
		query.append("FROM FMS_CONSULTATION" ).append("\n"); 
		query.append("WHERE    SLP_TP_CD" ).append("\n"); 
		query.append("|| SLP_FUNC_CD" ).append("\n"); 
		query.append("|| SLP_OFC_CD" ).append("\n"); 
		query.append("|| SLP_ISS_DT" ).append("\n"); 
		query.append("|| SLP_SER_NO = @[csr_no]) SLP_EFF_DT," ).append("\n"); 
		query.append("TO_CHAR(CSR_AMT,'FM999,999,999,999,999,990.00') CSR_AMT," ).append("\n"); 
		query.append("VSL_CD || SKD_VOY_NO || SKD_DIR_CD || REV_DIR_CD BUNKER_VVD," ).append("\n"); 
		query.append("CASE WHEN LSG_GR_NO IS NOT NULL THEN" ).append("\n"); 
		query.append("LSG_GR_NO" ).append("\n"); 
		query.append("WHEN SLP_KEY_NO IS NOT NULL THEN" ).append("\n"); 
		query.append("SLP_KEY_NO" ).append("\n"); 
		query.append("ELSE" ).append("\n"); 
		query.append("ORG_SLP_TP_CD || ORG_SLP_FUNC_CD || ORG_SLP_OFC_CD || ORG_ISS_DT || ORG_SLP_SER_NO || ORG_SLP_SEQ_NO" ).append("\n"); 
		query.append("END KEY_NUMBER," ).append("\n"); 
		query.append("CSR_DESC" ).append("\n"); 
		query.append("FROM FMS_CSUL_SLP" ).append("\n"); 
		query.append("WHERE    SLP_TP_CD" ).append("\n"); 
		query.append("|| SLP_FUNC_CD" ).append("\n"); 
		query.append("|| SLP_OFC_CD" ).append("\n"); 
		query.append("|| SLP_ISS_DT" ).append("\n"); 
		query.append("|| SLP_SER_NO = @[csr_no]" ).append("\n"); 

	}
}