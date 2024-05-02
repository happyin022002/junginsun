/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : TCharterIOInvoiceDBDAOSearchInvoiceByPaymentSlipVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.24
*@LastModifier : 
*@LastVersion : 1.0
* 2014.10.24 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TCharterIOInvoiceDBDAOSearchInvoiceByPaymentSlipVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Payment Slip화면에서 계약번호 선택 후 정산 관련 기본 정보를 조회한다
	  * </pre>
	  */
	public TCharterIOInvoiceDBDAOSearchInvoiceByPaymentSlipVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("flet_ctrt_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.integration").append("\n"); 
		query.append("FileName : TCharterIOInvoiceDBDAOSearchInvoiceByPaymentSlipVORSQL").append("\n"); 
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
		query.append("SELECT (SELECT INTG_CD_VAL_DP_DESC " ).append("\n"); 
		query.append("		  FROM COM_INTG_CD_DTL CD " ).append("\n"); 
		query.append("		 WHERE INTG_CD_ID = 'CD01513' " ).append("\n"); 
		query.append("           AND INTG_CD_VAL_CTNT = FLET_CTRT_TP_CD) FLET_CTRT_TP_NM," ).append("\n"); 
		query.append("        CASE WHEN SUBSTR(@[flet_ctrt_no],5,2) = 'TO' THEN" ).append("\n"); 
		query.append("				  6251" ).append("\n"); 
		query.append("			 ELSE" ).append("\n"); 
		query.append("				  VNDR_SEQ" ).append("\n"); 
		query.append("		 END VNDR_SEQ," ).append("\n"); 
		query.append("		(SELECT VNDR_LGL_ENG_NM " ).append("\n"); 
		query.append("           FROM MDM_VENDOR " ).append("\n"); 
		query.append("          WHERE VNDR_SEQ = DECODE(SUBSTR(@[flet_ctrt_no],5,2),'TO',6251,A.VNDR_SEQ) " ).append("\n"); 
		query.append("            AND DELT_FLG = 'N') VNDR_LGL_ENG_NM," ).append("\n"); 
		query.append("	    A.FLET_CTRT_TP_CD" ).append("\n"); 
		query.append("  FROM FMS_CONTRACT A" ).append("\n"); 
		query.append(" WHERE FLET_CTRT_NO = @[flet_ctrt_no]" ).append("\n"); 

	}
}