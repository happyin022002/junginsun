/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TCharterIOSettlementDBDAOSearchOwnerAccountExpenseListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.08
*@LastModifier : 
*@LastVersion : 1.0
* 2010.02.08 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriosettlement.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TCharterIOSettlementDBDAOSearchOwnerAccountExpenseListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Search Owner Account Expense List
	  * </pre>
	  */
	public TCharterIOSettlementDBDAOSearchOwnerAccountExpenseListVORSQL(){
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
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriosettlement.integration").append("\n"); 
		query.append("FileName : TCharterIOSettlementDBDAOSearchOwnerAccountExpenseListVORSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("	SLP_TP_CD||SLP_FUNC_CD||SLP_OFC_CD||SLP_ISS_DT||SLP_SER_NO||SLP_SEQ_NO ORG_SLIP_NO" ).append("\n"); 
		query.append(",	SLP_TP_CD ORG_SLP_TP_CD" ).append("\n"); 
		query.append(",	SLP_FUNC_CD ORG_SLP_FUNC_CD" ).append("\n"); 
		query.append(",	SLP_OFC_CD ORG_SLP_OFC_CD" ).append("\n"); 
		query.append(",	SLP_ISS_DT ORG_SLP_ISS_DT" ).append("\n"); 
		query.append(",	SLP_SER_NO ORG_SLP_SER_NO" ).append("\n"); 
		query.append(",	SLP_SEQ_NO ORG_SLP_SEQ_NO" ).append("\n"); 
		query.append(",	FLET_PPAY_RLT_CD" ).append("\n"); 
		query.append(",	ACCT_CD" ).append("\n"); 
		query.append(",	VSL_CD||SKD_VOY_NO||SKD_DIR_CD||REV_DIR_CD VVD_CD" ).append("\n"); 
		query.append(",	VSL_CD||SKD_VOY_NO||SKD_DIR_CD||REV_DIR_CD VVD_CD1" ).append("\n"); 
		query.append(",	N1ST_CURR_CD" ).append("\n"); 
		query.append(",	N1ST_AMT" ).append("\n"); 
		query.append(",	AP_DESC||' ' AP_DESC1" ).append("\n"); 
		query.append(",	AP_DESC||' ' AP_DESC2" ).append("\n"); 
		query.append(",	AP_DESC||' ' AP_DESC3" ).append("\n"); 
		query.append(",	AP_DESC||' ' AP_DESC4" ).append("\n"); 
		query.append(",	AP_DESC||' ' AP_DESC5" ).append("\n"); 
		query.append(",	'' DUMMY1" ).append("\n"); 
		query.append("FROM FMS_OWNR_ACCT_SLP A" ).append("\n"); 
		query.append("WHERE FLET_PPAY_RLT_CD = 'C'" ).append("\n"); 
		query.append("AND ACCT_CD = '111071'" ).append("\n"); 
		query.append("#if(${flet_ctrt_no} != '') " ).append("\n"); 
		query.append("AND EXISTS (SELECT NULL FROM FMS_CONTRACT" ).append("\n"); 
		query.append("		 				WHERE  VSL_CD = A.VSL_CD AND FLET_CTRT_NO = @[flet_ctrt_no]" ).append("\n"); 
		query.append("						UNION ALL" ).append("\n"); 
		query.append("						SELECT NULL FROM FMS_CONTRACT FC, FMS_ID_VSL FI" ).append("\n"); 
		query.append("						WHERE FI.VSL_CD = A.VSL_CD AND FC.FLET_CTRT_NO = FI.FLET_CTRT_NO" ).append("\n"); 
		query.append("						AND FC.FLET_CTRT_NO = @[flet_ctrt_no])" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND CSR_SLP_FLG = 'N' " ).append("\n"); 
		query.append("ORDER BY 1" ).append("\n"); 

	}
}