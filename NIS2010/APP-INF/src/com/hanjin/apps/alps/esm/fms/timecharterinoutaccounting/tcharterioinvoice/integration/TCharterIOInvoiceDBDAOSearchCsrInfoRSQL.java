/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : TCharterIOInvoiceDBDAOSearchCsrInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.05.02
*@LastModifier : 
*@LastVersion : 1.0
* 2018.05.02 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TCharterIOInvoiceDBDAOSearchCsrInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CSR의 일부 정보를 조회
	  * </pre>
	  */
	public TCharterIOInvoiceDBDAOSearchCsrInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("csr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.integration").append("\n"); 
		query.append("FileName : TCharterIOInvoiceDBDAOSearchCsrInfoRSQL").append("\n"); 
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
		query.append("SELECT A.SLP_TP_CD," ).append("\n"); 
		query.append("       A.SLP_FUNC_CD," ).append("\n"); 
		query.append("       A.SLP_OFC_CD," ).append("\n"); 
		query.append("       A.SLP_ISS_DT," ).append("\n"); 
		query.append("       A.SLP_SER_NO," ).append("\n"); 
		query.append("       A.SLP_SEQ_NO," ).append("\n"); 
		query.append("       A.VSL_CD," ).append("\n"); 
		query.append("       A.SKD_VOY_NO," ).append("\n"); 
		query.append("       A.SKD_DIR_CD," ).append("\n"); 
		query.append("       A.REV_DIR_CD," ).append("\n"); 
		query.append("       (SELECT M.LOC_CD" ).append("\n"); 
		query.append("        FROM MDM_ORGANIZATION M" ).append("\n"); 
		query.append("        WHERE M.OFC_CD = @[ofc_cd]) LOC_CD,  " ).append("\n"); 
		query.append("       (SELECT M.AP_CTR_CD" ).append("\n"); 
		query.append("        FROM MDM_ORGANIZATION M" ).append("\n"); 
		query.append("        WHERE M.OFC_CD = @[ofc_cd]) CTR_CD,  -- 2018.05.02 MDM 에서 구하도록 변경" ).append("\n"); 
		query.append("       A.N1ST_CURR_CD," ).append("\n"); 
		query.append("       A.N1ST_AMT," ).append("\n"); 
		query.append("       A.AP_DESC," ).append("\n"); 
		query.append("       (SELECT M.VNDR_SEQ" ).append("\n"); 
		query.append("        FROM MDM_ORGANIZATION M" ).append("\n"); 
		query.append("        WHERE M.OFC_CD = @[ofc_cd]) VNDR_SEQ -- 2018.05.02 SELADG 하드코딩 제거" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM FMS_OWNR_ACCT_SLP A" ).append("\n"); 
		query.append("WHERE A.SLP_TP_CD||A.SLP_FUNC_CD||A.SLP_OFC_CD||A.SLP_ISS_DT||A.SLP_SER_NO||A.SLP_SEQ_NO  = @[csr_no]" ).append("\n"); 

	}
}