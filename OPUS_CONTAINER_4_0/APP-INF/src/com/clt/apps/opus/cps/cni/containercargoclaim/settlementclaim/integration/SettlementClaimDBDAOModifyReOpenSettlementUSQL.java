/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SettlementClaimDBDAOModifyReOpenSettlementUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.17
*@LastModifier : 정행룡
*@LastVersion : 1.0
* 2010.03.17 정행룡
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.cni.containercargoclaim.settlementclaim.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author JEONG HAENG RYONG
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SettlementClaimDBDAOModifyReOpenSettlementUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Reopen시 수정처리
	  * </pre>
	  */
	public SettlementClaimDBDAOModifyReOpenSettlementUSQL(){
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
		query.append("Path : com.clt.apps.opus.cps.cni.containercargoclaim.settlementclaim.integration ").append("\n"); 
		query.append("FileName : SettlementClaimDBDAOModifyReOpenSettlementUSQL").append("\n"); 
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
		query.append("UPDATE" ).append("\n"); 
		query.append("    CNI_CGO_CLM_STL" ).append("\n"); 
		query.append("SET" ).append("\n"); 
		query.append("	CGO_CLM_STL_TP_CD	= ''" ).append("\n"); 
		query.append(",	CGO_CLM_STL_DT		= ''" ).append("\n"); 
		query.append(",	UPD_USR_ID			= @[upd_usr_id]" ).append("\n"); 
		query.append(",	UPD_DT				= CNI_GET_GMT_FNC(@[upd_usr_id])" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("    CGO_CLM_NO = @[cgo_clm_no]" ).append("\n"); 

	}
}