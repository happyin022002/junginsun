/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : TCharterIOSettlementDBDAOSearchPrepaymentSettleListAllVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.10.26
*@LastModifier : 손진환
*@LastVersion : 1.0
* 2015.10.26 손진환
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriosettlement.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Son, Jin-Hwan
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TCharterIOSettlementDBDAOSearchPrepaymentSettleListAllVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Multi Prepayment Settlement Retrieve. 조건에 해당하는 모든 미 정리된 선급금 전표를 조회한다
	  * </pre>
	  */
	public TCharterIOSettlementDBDAOSearchPrepaymentSettleListAllVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pay_date",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriosettlement.integration").append("\n"); 
		query.append("FileName : TCharterIOSettlementDBDAOSearchPrepaymentSettleListAllVORSQL").append("\n"); 
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
		query.append("SELECT 	" ).append("\n"); 
		query.append("		C.PAY_DT," ).append("\n"); 
		query.append("		SUBSTR(A.FLET_CTRT_NO, 0, 4) VSL_CD," ).append("\n"); 
		query.append("		A.FLET_CTRT_NO," ).append("\n"); 
		query.append("		A.EFF_DT EFF_DATE," ).append("\n"); 
		query.append("		A.PPAY_HIR_NO," ).append("\n"); 
		query.append("		B.VNDR_SEQ," ).append("\n"); 
		query.append("		B.CSR_DESC SLP_DESC," ).append("\n"); 
		query.append("		B.SLP_TP_CD||B.SLP_FUNC_CD||B.SLP_OFC_CD||B.SLP_ISS_DT||B.SLP_SER_NO||B.SLP_SEQ_NO ORG_SLIP_NO," ).append("\n"); 
		query.append("		B.SLP_TP_CD ORG_SLP_TP_CD," ).append("\n"); 
		query.append("		B.SLP_FUNC_CD ORG_SLP_FUNC_CD," ).append("\n"); 
		query.append("		B.SLP_OFC_CD ORG_SLP_OFC_CD," ).append("\n"); 
		query.append("		B.SLP_ISS_DT ORG_SLP_ISS_DT," ).append("\n"); 
		query.append("		B.SLP_SER_NO ORG_SLP_SER_NO," ).append("\n"); 
		query.append("		B.SLP_SEQ_NO ORG_SLP_SEQ_NO," ).append("\n"); 
		query.append("		B.ACCT_CD," ).append("\n"); 
		query.append("		B.CSR_CURR_CD," ).append("\n"); 
		query.append("		B.CSR_AMT SLP_AMT," ).append("\n"); 
		query.append("		(SELECT AP_CTR_CD " ).append("\n"); 
		query.append("          FROM MDM_ORGANIZATION " ).append("\n"); 
		query.append("         WHERE OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("           AND ROWNUM = 1) CTR_CD," ).append("\n"); 
		query.append("       (SELECT LOC_CD " ).append("\n"); 
		query.append("          FROM MDM_ORGANIZATION " ).append("\n"); 
		query.append("         WHERE OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("           AND ROWNUM = 1) SLP_LOC_CD," ).append("\n"); 
		query.append("		TO_CHAR(B.VVD_EFF_DT, 'YYYYMMDD') VVD_EFF_DT," ).append("\n"); 
		query.append("		TO_CHAR(B.VVD_EXP_DT, 'YYYYMMDD') VVD_EXP_DT," ).append("\n"); 
		query.append("		B.INV_SEQ" ).append("\n"); 
		query.append("FROM 	FMS_CONSULTATION A, FMS_CSUL_SLP B, AP_INV_HDR C" ).append("\n"); 
		query.append("WHERE 	A.SLP_TP_CD 	= B.SLP_TP_CD" ).append("\n"); 
		query.append("AND   	A.SLP_FUNC_CD 	= B.SLP_FUNC_CD" ).append("\n"); 
		query.append("AND   	A.SLP_OFC_CD 	= B.SLP_OFC_CD" ).append("\n"); 
		query.append("AND   	A.SLP_ISS_DT 	= B.SLP_ISS_DT" ).append("\n"); 
		query.append("AND   	A.SLP_SER_NO 	= B.SLP_SER_NO" ).append("\n"); 
		query.append("AND		A.SLP_FUNC_CD   = 'P'" ).append("\n"); 
		query.append("AND   	A.APRO_FLG 		= 'Y'" ).append("\n"); 
		query.append("AND	  	B.ACCT_CD	 	= '111431'" ).append("\n"); 
		query.append("AND   	B.STL_FLG 		= 'N'" ).append("\n"); 
		query.append("AND 	C.CSR_NO = A.SLP_TP_CD||A.SLP_FUNC_CD||A.SLP_OFC_CD||A.SLP_ISS_DT||A.SLP_SER_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ( ${pay_date} != '' )" ).append("\n"); 
		query.append("AND C.PAY_DT <= @[pay_date]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY B.INV_SEQ" ).append("\n"); 

	}
}