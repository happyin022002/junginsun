/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : TCharterIOConsultationDBDAOArCsrNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.09.07
*@LastModifier : 
*@LastVersion : 1.0
* 2016.09.07 
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

public class TCharterIOConsultationDBDAOArCsrNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 20T 전표 산출
	  * </pre>
	  */
	public TCharterIOConsultationDBDAOArCsrNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slp_ser_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slp_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slp_func_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slp_iss_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slp_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.integration").append("\n"); 
		query.append("FileName : TCharterIOConsultationDBDAOArCsrNoRSQL").append("\n"); 
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
		query.append("SELECT B.SLP_TP_CD||B.SLP_FUNC_CD||B.SLP_OFC_CD||B.SLP_ISS_DT||B.SLP_SER_NO PCSR_NO" ).append("\n"); 
		query.append("FROM FMS_CONSULTATION A, FMS_CONSULTATION B" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("  AND A.FLET_CTRT_NO = B.FLET_CTRT_NO" ).append("\n"); 
		query.append("  AND B.SLP_TP_CD = '20'" ).append("\n"); 
		query.append("  AND B.APRO_FLG = 'Y'" ).append("\n"); 
		query.append("  AND B.CSR_DESC LIKE '%OUTLAY COMM'" ).append("\n"); 
		query.append("  AND TO_CHAR(A.CRE_DT, 'YYYYMMDD') = TO_CHAR(B.CRE_DT, 'YYYYMMDD')" ).append("\n"); 
		query.append("  AND A.CRE_DT < B.CRE_DT" ).append("\n"); 
		query.append("  AND A.SLP_TP_CD||A.SLP_FUNC_CD||A.SLP_OFC_CD||A.SLP_ISS_DT||A.SLP_SER_NO " ).append("\n"); 
		query.append("         = @[slp_tp_cd]||@[slp_func_cd]||@[slp_ofc_cd]||@[slp_iss_dt]||@[slp_ser_no]" ).append("\n"); 
		query.append("  AND ROWNUM = 1" ).append("\n"); 

	}
}