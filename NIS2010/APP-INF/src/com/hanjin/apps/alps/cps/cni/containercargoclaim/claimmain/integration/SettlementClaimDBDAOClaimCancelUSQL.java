/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SettlementClaimDBDAOClaimCancelUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.12
*@LastModifier : 박제성
*@LastVersion : 1.0
* 2010.05.12 박제성
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.cni.containercargoclaim.claimmain.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Je Sung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SettlementClaimDBDAOClaimCancelUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ClaimCancel
	  * </pre>
	  */
	public SettlementClaimDBDAOClaimCancelUSQL(){
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
		params.put("cgo_clm_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.cps.cni.containercargoclaim.claimmain.integration").append("\n"); 
		query.append("FileName : SettlementClaimDBDAOClaimCancelUSQL").append("\n"); 
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
		query.append("UPDATE CNI_CGO_CLM SET " ).append("\n"); 
		query.append("    CLM_STL_AUTH_NO = ''" ).append("\n"); 
		query.append(",   CLM_STL_AUTH_CD = ''" ).append("\n"); 
		query.append(",	CLM_STL_APPL_DT = ''" ).append("\n"); 
		query.append(",	CLM_STL_APPL_USR_ID = ''" ).append("\n"); 
		query.append(",	CLM_STL_APPL_OFC_CD = ''" ).append("\n"); 
		query.append(",	CLM_STL_AUTH_DT = ''" ).append("\n"); 
		query.append(",	CLM_STL_AUTH_USR_ID = ''" ).append("\n"); 
		query.append(",	CLM_STL_AUTH_OFC_CD = ''" ).append("\n"); 
		query.append(",	UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append(",	UPD_DT = CNI_GET_GMT_FNC(@[upd_usr_id])" ).append("\n"); 
		query.append("WHERE	CGO_CLM_NO = @[cgo_clm_no]" ).append("\n"); 

	}
}