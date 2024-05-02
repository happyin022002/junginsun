/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TCharterIOConsultationDBDAOFmsManualSlipListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.02
*@LastModifier : 최우석
*@LastVersion : 1.0
* 2009.09.02 최우석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi,Woo-Seok
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TCharterIOConsultationDBDAOFmsManualSlipListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Manual Slip Select
	  * </pre>
	  */
	public TCharterIOConsultationDBDAOFmsManualSlipListRSQL(){
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
		query.append("FileName : TCharterIOConsultationDBDAOFmsManualSlipListRSQL").append("\n"); 
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
		query.append("SELECT B.ACCT_CD," ).append("\n"); 
		query.append("B.VNDR_SEQ," ).append("\n"); 
		query.append("B.CTR_CD," ).append("\n"); 
		query.append("B.SLP_LOC_CD," ).append("\n"); 
		query.append("A.EFF_DT," ).append("\n"); 
		query.append("B.CSR_AMT," ).append("\n"); 
		query.append("B.CSR_DESC," ).append("\n"); 
		query.append("(B.VSL_CD || B.SKD_VOY_NO || B.SKD_DIR_CD || B.REV_DIR_CD) VVD_CD," ).append("\n"); 
		query.append("B.TO_INV_NO," ).append("\n"); 
		query.append("(A.SLP_TP_CD || A.SLP_FUNC_CD || A.SLP_OFC_CD || A.SLP_ISS_DT || A.SLP_SER_NO) CSR_NO" ).append("\n"); 
		query.append("FROM FMS_CONSULTATION A," ).append("\n"); 
		query.append("FMS_CSUL_SLP B" ).append("\n"); 
		query.append("WHERE A.SLP_TP_CD = B.SLP_TP_CD" ).append("\n"); 
		query.append("AND A.SLP_FUNC_CD = B.SLP_FUNC_CD" ).append("\n"); 
		query.append("AND A.SLP_OFC_CD = B.SLP_OFC_CD" ).append("\n"); 
		query.append("AND A.SLP_ISS_DT = B.SLP_ISS_DT" ).append("\n"); 
		query.append("AND A.SLP_SER_NO = B.SLP_SER_NO" ).append("\n"); 
		query.append("AND A.SLP_TP_CD = @[slp_tp_cd]" ).append("\n"); 
		query.append("AND A.SLP_FUNC_CD = @[slp_func_cd]" ).append("\n"); 
		query.append("AND A.SLP_OFC_CD = @[slp_ofc_cd]" ).append("\n"); 
		query.append("AND A.SLP_ISS_DT = SUBSTR(@[slp_iss_dt],3,8)" ).append("\n"); 
		query.append("AND A.SLP_SER_NO = @[slp_ser_no]" ).append("\n"); 

	}
}