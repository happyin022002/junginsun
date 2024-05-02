/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TCharterIOConsultationDBDAOFmsInvoiceNoListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.22
*@LastModifier : 
*@LastVersion : 1.0
* 2009.10.22 
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

public class TCharterIOConsultationDBDAOFmsInvoiceNoListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RCS / Invoice No Inquiry Select
	  * </pre>
	  */
	public TCharterIOConsultationDBDAOFmsInvoiceNoListRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("csr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.integration").append("\n"); 
		query.append("FileName : TCharterIOConsultationDBDAOFmsInvoiceNoListRSQL").append("\n"); 
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
		query.append("SELECT B.TO_INV_NO," ).append("\n"); 
		query.append("(B.SLP_TP_CD || B.SLP_FUNC_CD || B.SLP_OFC_CD || B.SLP_ISS_DT || B.SLP_SER_NO) CSR_NO" ).append("\n"); 
		query.append("FROM FMS_CONSULTATION A," ).append("\n"); 
		query.append("FMS_CSUL_SLP B" ).append("\n"); 
		query.append("WHERE A.SLP_TP_CD = B.SLP_TP_CD" ).append("\n"); 
		query.append("AND A.SLP_FUNC_CD = B.SLP_FUNC_CD" ).append("\n"); 
		query.append("AND A.SLP_OFC_CD = B.SLP_OFC_CD" ).append("\n"); 
		query.append("AND A.SLP_ISS_DT = B.SLP_ISS_DT" ).append("\n"); 
		query.append("AND A.SLP_SER_NO = B.SLP_SER_NO" ).append("\n"); 
		query.append("AND A.SLP_TP_CD = '20'" ).append("\n"); 
		query.append("AND A.SLP_FUNC_CD = 'T'" ).append("\n"); 
		query.append("AND A.APRO_FLG = 'Y'" ).append("\n"); 
		query.append("#if(${csr_no} != '')" ).append("\n"); 
		query.append("AND A.SLP_TP_CD = SUBSTR(@[csr_no],1,2)" ).append("\n"); 
		query.append("AND A.SLP_FUNC_CD = SUBSTR(@[csr_no],3,1)" ).append("\n"); 
		query.append("AND A.SLP_OFC_CD = SUBSTR(@[csr_no],4,6)" ).append("\n"); 
		query.append("AND A.SLP_ISS_DT = SUBSTR(@[csr_no],10,6)" ).append("\n"); 
		query.append("AND A.SLP_SER_NO = SUBSTR(@[csr_no],16,5)" ).append("\n"); 
		query.append("--AND A.SLP_TP_CD IS NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${flet_ctrt_no} != '')" ).append("\n"); 
		query.append("AND A.FLET_CTRT_NO = @[flet_ctrt_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}