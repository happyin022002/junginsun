/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : GeneralInvoiceAuditDBDAOSearchTpbIfDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.12.14
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2012.12.14 진마리아
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Maria Chin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralInvoiceAuditDBDAOSearchTpbIfDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CSR 승인건에 대해 TPB Call할 대상을 조회합니다.
	  * 
	  * ===================================
	  * * 2012.11.26 진마리아 CHM-201220618-01 TPB 비용 정보 지정시 해당 정보를 TPB IF용 테이블에 저장하고 제어함
	  * </pre>
	  */
	public GeneralInvoiceAuditDBDAOSearchTpbIfDataRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration").append("\n"); 
		query.append("FileName : GeneralInvoiceAuditDBDAOSearchTpbIfDataRSQL").append("\n"); 
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
		query.append("SELECT N3PTY_BIL_TP_CD" ).append("\n"); 
		query.append("     , IF_OFC_CD" ).append("\n"); 
		query.append("     , VSL_CD" ).append("\n"); 
		query.append("     , SKD_VOY_NO" ).append("\n"); 
		query.append("     , SKD_DIR_CD" ).append("\n"); 
		query.append("     , YD_CD" ).append("\n"); 
		query.append("     , VNDR_SEQ" ).append("\n"); 
		query.append("     , IF_CURR_CD" ).append("\n"); 
		query.append("     , IF_AMT" ).append("\n"); 
		query.append("     , IF_RMK" ).append("\n"); 
		query.append("     , ACCT_CD" ).append("\n"); 
		query.append("     , LGS_COST_CD" ).append("\n"); 
		query.append("     , IF_USR_ID" ).append("\n"); 
		query.append("     , COST_OFC_CD" ).append("\n"); 
		query.append("     , TO_CHAR(VPS_ETD_DT,'YYYYMMDDHH24MI') VPS_ETD_DT" ).append("\n"); 
		query.append("     , SO_DTL_SEQ" ).append("\n"); 
		query.append("     , IF_SEQ" ).append("\n"); 
		query.append("     , (SELECT VNDR_CNT_CD FROM MDM_VENDOR WHERE VNDR_SEQ = T.VNDR_SEQ) VNDR_CNT_CD" ).append("\n"); 
		query.append("     , (SELECT VNDR_LGL_ENG_NM FROM MDM_VENDOR WHERE VNDR_SEQ = T.VNDR_SEQ) VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("     , (SELECT YD_NM FROM MDM_YARD WHERE YD_CD = T.YD_CD) YD_NM" ).append("\n"); 
		query.append("     , (SELECT ACCT_ENG_NM FROM MDM_ACCOUNT WHERE ACCT_CD = T.ACCT_CD) ACCT_ENG_NM" ).append("\n"); 
		query.append("     , VSL_CD||SKD_VOY_NO||SKD_DIR_CD AS VVD" ).append("\n"); 
		query.append("     , INV_NO" ).append("\n"); 
		query.append("FROM PSO_N3RD_PTY_IF T" ).append("\n"); 
		query.append("WHERE (T.ISS_CTY_CD, T.SO_SEQ) IN (" ).append("\n"); 
		query.append("                SELECT ISS_CTY_CD, SO_SEQ" ).append("\n"); 
		query.append("                FROM PSO_CHARGE" ).append("\n"); 
		query.append("                WHERE INV_RGST_NO IN (SELECT INV_RGST_NO" ).append("\n"); 
		query.append("                                      FROM AP_PAY_INV" ).append("\n"); 
		query.append("                                      WHERE CSR_NO = @[csr_no]" ).append("\n"); 
		query.append("                                      AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("                                     )" ).append("\n"); 
		query.append("                )" ).append("\n"); 

	}
}