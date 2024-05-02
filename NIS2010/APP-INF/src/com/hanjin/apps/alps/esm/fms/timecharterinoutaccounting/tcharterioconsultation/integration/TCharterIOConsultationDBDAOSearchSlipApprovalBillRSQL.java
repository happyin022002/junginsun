/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : TCharterIOConsultationDBDAOSearchSlipApprovalBillRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.05.04
*@LastModifier : 
*@LastVersion : 1.0
* 2017.05.04 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TCharterIOConsultationDBDAOSearchSlipApprovalBillRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ERP AP 전송하기 위한 계산서 정보 조회한다
	  * </pre>
	  */
	public TCharterIOConsultationDBDAOSearchSlipApprovalBillRSQL(){
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
		query.append("FileName : TCharterIOConsultationDBDAOSearchSlipApprovalBillRSQL").append("\n"); 
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
		query.append("SELECT ISS_DT, SPL_RGST_NO, OFC_CD, BIL_INV_YRMON||OFC_CD||BIL_SER_NO BILL_NO, " ).append("\n"); 
		query.append("       SPL_AMT, 0 TAX_AMT, CURR_CD, '매입계산서' TAX_CODE, " ).append("\n"); 
		query.append("	   CO_NM, " ).append("\n"); 
		query.append("       TO_CHAR(TO_DATE(ISS_DT, 'YYYYMMDD'), 'YYYY/MM/DD HH24:MI:SS') ISS_DT_TIME" ).append("\n"); 
		query.append("FROM   FMS_BILL" ).append("\n"); 
		query.append("WHERE  SLP_TP_CD||SLP_FUNC_CD||SLP_OFC_CD||SLP_ISS_DT||SLP_SER_NO = @[csr_no]" ).append("\n"); 

	}
}