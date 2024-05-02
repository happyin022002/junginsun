/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : TCharterIOSettlementDBDAOSearchPrepaymentSettleListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.10.01
*@LastModifier : 
*@LastVersion : 1.0
* 2015.10.01 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriosettlement.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TCharterIOSettlementDBDAOSearchPrepaymentSettleListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Prepayment Settlement Retrieve. 미 정리된 선급금 전표를 조회한다
	  * </pre>
	  */
	public TCharterIOSettlementDBDAOSearchPrepaymentSettleListVORSQL(){
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
		params.put("csr_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriosettlement.integration").append("\n"); 
		query.append("FileName : TCharterIOSettlementDBDAOSearchPrepaymentSettleListVORSQL").append("\n"); 
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
		query.append("SELECT 	B.CSR_DESC," ).append("\n"); 
		query.append("		B.SLP_TP_CD||B.SLP_FUNC_CD||B.SLP_OFC_CD||B.SLP_ISS_DT||B.SLP_SER_NO ORG_SLIP_NO," ).append("\n"); 
		query.append("		B.SLP_TP_CD," ).append("\n"); 
		query.append("		B.SLP_FUNC_CD," ).append("\n"); 
		query.append("		B.SLP_OFC_CD," ).append("\n"); 
		query.append("		B.SLP_ISS_DT," ).append("\n"); 
		query.append("		B.SLP_SER_NO," ).append("\n"); 
		query.append("		B.SLP_SEQ_NO," ).append("\n"); 
		query.append("		B.ACCT_CD," ).append("\n"); 
		query.append("		B.CSR_CURR_CD," ).append("\n"); 
		query.append("		B.CSR_AMT," ).append("\n"); 
		query.append("		B.CTR_CD," ).append("\n"); 
		query.append("		B.SLP_LOC_CD," ).append("\n"); 
		query.append("		TO_CHAR(B.VVD_EFF_DT, 'YYYYMMDD') VVD_EFF_DT," ).append("\n"); 
		query.append("		TO_CHAR(B.VVD_EXP_DT, 'YYYYMMDD') VVD_EXP_DT," ).append("\n"); 
		query.append("		B.INV_SEQ" ).append("\n"); 
		query.append("FROM 	FMS_CONSULTATION A, FMS_CSUL_SLP B" ).append("\n"); 
		query.append("WHERE 	A.SLP_TP_CD 	= B.SLP_TP_CD" ).append("\n"); 
		query.append("AND   	A.SLP_FUNC_CD 	= B.SLP_FUNC_CD" ).append("\n"); 
		query.append("AND   	A.SLP_OFC_CD 	= B.SLP_OFC_CD" ).append("\n"); 
		query.append("AND   	A.SLP_ISS_DT 	= B.SLP_ISS_DT" ).append("\n"); 
		query.append("AND   	A.SLP_SER_NO 	= B.SLP_SER_NO" ).append("\n"); 
		query.append("AND		A.SLP_FUNC_CD   = 'P'" ).append("\n"); 
		query.append("AND	  	A.FLET_CTRT_NO 	= @[flet_ctrt_no]" ).append("\n"); 
		query.append("AND   	A.APRO_FLG 		= 'Y'" ).append("\n"); 
		query.append("AND   	B.CSR_CURR_CD 	= @[csr_curr_cd]" ).append("\n"); 
		query.append("AND	  	B.ACCT_CD	 	= '111431'" ).append("\n"); 
		query.append("AND   	B.STL_FLG 		= 'N'" ).append("\n"); 
		query.append("ORDER BY B.INV_SEQ" ).append("\n"); 

	}
}