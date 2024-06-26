/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : TCharteriOBunkerDBDAOModifyArSlipApprovalCancelBunkerUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.01
*@LastModifier : 
*@LastVersion : 1.0
* 2014.10.01 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriobunkerregister.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TCharteriOBunkerDBDAOModifyArSlipApprovalCancelBunkerUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TCharteriOBunkerDBDAOModifyArSlipApprovalCancelBunkerUSQL
	  * </pre>
	  */
	public TCharteriOBunkerDBDAOModifyArSlipApprovalCancelBunkerUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("csr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriobunkerregister.integration").append("\n"); 
		query.append("FileName : TCharteriOBunkerDBDAOModifyArSlipApprovalCancelBunkerUSQL").append("\n"); 
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
		query.append("UPDATE FMS_BUNKER SET " ).append("\n"); 
		query.append("	AR_SLP_TP_CD = NULL" ).append("\n"); 
		query.append(",	AR_SLP_FUNC_CD = NULL" ).append("\n"); 
		query.append(",	AR_SLP_OFC_CD = NULL" ).append("\n"); 
		query.append(",	AR_SLP_ISS_DT = NULL" ).append("\n"); 
		query.append(",	AR_SLP_SER_NO = NULL" ).append("\n"); 
		query.append(",	UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append(",	UPD_DT = SYSDATE" ).append("\n"); 
		query.append("WHERE AR_SLP_TP_CD || AR_SLP_FUNC_CD || AR_SLP_OFC_CD || AR_SLP_ISS_DT || AR_SLP_SER_NO  = @[csr_no]" ).append("\n"); 

	}
}