/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ClaimMainDBDAOModifyTransferUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.06.03
*@LastModifier : 이준범
*@LastVersion : 1.0
* 2011.06.03 이준범
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.cni.containercargoclaim.claimmain.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author LEE-JUN-BUM
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ClaimMainDBDAOModifyTransferUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Transfer 수정
	  * 2011.06.03 [CHM-201111326-01]
	  * 개발자 : 표준희
	  * 제목 : Transfer 시 Handler 정보 Update Logic
	  * 내용 : Update 시 최종 정보만 Update 할 수 있도록 Trns_seq 조건 추가
	  * </pre>
	  */
	public ClaimMainDBDAOModifyTransferUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trns_to_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clm_trns_auth_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trns_rmk",new String[]{arrTmp[0],arrTmp[1]});

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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trns_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trns_to_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trns_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.cps.cni.containercargoclaim.claimmain.integration").append("\n"); 
		query.append("FileName : ClaimMainDBDAOModifyTransferUSQL").append("\n"); 
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
		query.append("    CNI_CGO_CLM_TRNS" ).append("\n"); 
		query.append("SET" ).append("\n"); 
		query.append("    CLM_TRNS_AUTH_CD = @[clm_trns_auth_cd]" ).append("\n"); 
		query.append("  , TRNS_TO_OFC_CD   = @[trns_to_ofc_cd]" ).append("\n"); 
		query.append("  , TRNS_TO_USR_ID   = @[trns_to_usr_id]" ).append("\n"); 
		query.append("#if (${trns_to_dt} != '')" ).append("\n"); 
		query.append("  , TRNS_TO_DT       = @[trns_to_dt]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("  , TRNS_TO_DT       = TO_CHAR(CNI_GET_GMT_FNC(@[upd_usr_id]), 'YYYYMMDD')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("  , TRNS_RMK         = @[trns_rmk]" ).append("\n"); 
		query.append("  , UPD_USR_ID       = @[upd_usr_id]" ).append("\n"); 
		query.append("  , UPD_DT           = CNI_GET_GMT_FNC(@[upd_usr_id])" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("    CGO_CLM_NO = @[cgo_clm_no]" ).append("\n"); 
		query.append("AND" ).append("\n"); 
		query.append("    TRNS_SEQ   = @[trns_seq]" ).append("\n"); 

	}
}