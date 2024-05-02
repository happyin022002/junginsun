/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ClaimMainDBDAOModifyAppliedStatusUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.07
*@LastModifier : 이준범
*@LastVersion : 1.0
* 2011.03.07 이준범
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.cni.containercargoclaim.claimmain.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jun-bum, Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ClaimMainDBDAOModifyAppliedStatusUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GwStatus정보 갱신
	  * </pre>
	  */
	public ClaimMainDBDAOModifyAppliedStatusUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("clm_stl_appl_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clm_stl_appl_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.cps.cni.containercargoclaim.claimmain.integration").append("\n"); 
		query.append("FileName : ClaimMainDBDAOModifyAppliedStatusUSQL").append("\n"); 
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
		query.append("UPDATE CNI_CGO_CLM " ).append("\n"); 
		query.append("   SET CLM_STL_APPL_DT  = TO_CHAR(CNI_GET_GMT_FNC(@[clm_stl_appl_usr_id]), 'YYYYMMDD')" ).append("\n"); 
		query.append("      ,CLM_STL_APPL_USR_ID = @[clm_stl_appl_usr_id]" ).append("\n"); 
		query.append("      ,CLM_STL_APPL_OFC_CD = @[clm_stl_appl_ofc_cd]" ).append("\n"); 
		query.append("	  ,CLM_STL_AUTH_CD = 'P'" ).append("\n"); 
		query.append("      ,UPD_USR_ID = @[clm_stl_appl_usr_id]" ).append("\n"); 
		query.append("      ,UPD_DT = CNI_GET_GMT_FNC(@[clm_stl_appl_usr_id])" ).append("\n"); 
		query.append(" WHERE CGO_CLM_NO = @[cgo_clm_no]" ).append("\n"); 

	}
}