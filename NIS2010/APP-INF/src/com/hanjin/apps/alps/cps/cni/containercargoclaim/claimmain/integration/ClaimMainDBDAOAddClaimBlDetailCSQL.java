/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ClaimMainDBDAOAddClaimBlDetailCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.18
*@LastModifier : 박제성
*@LastVersion : 1.0
* 2010.03.18 박제성
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

public class ClaimMainDBDAOAddClaimBlDetailCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Claim B/L 상세정보 등록
	  * </pre>
	  */
	public ClaimMainDBDAOAddClaimBlDetailCSQL(){
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
		params.put("cgo_clm_ref_bl_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("mn_bl_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.cps.cni.containercargoclaim.claimmain.integration").append("\n"); 
		query.append("FileName : ClaimMainDBDAOAddClaimBlDetailCSQL").append("\n"); 
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
		query.append("INSERT INTO CNI_CGO_CLM_BL_DTL (" ).append("\n"); 
		query.append("   CGO_CLM_NO " ).append("\n"); 
		query.append(",  CGO_CLM_REF_BL_NO " ).append("\n"); 
		query.append(",  MN_BL_FLG " ).append("\n"); 
		query.append(",  CRE_USR_ID " ).append("\n"); 
		query.append(",  CRE_DT " ).append("\n"); 
		query.append(",  UPD_USR_ID " ).append("\n"); 
		query.append(",  UPD_DT " ).append("\n"); 
		query.append(") VALUES(  " ).append("\n"); 
		query.append("   @[cgo_clm_no]" ).append("\n"); 
		query.append(",  @[cgo_clm_ref_bl_no] " ).append("\n"); 
		query.append(",  @[mn_bl_flg] " ).append("\n"); 
		query.append(",  @[cre_usr_id] " ).append("\n"); 
		query.append(",  CNI_GET_GMT_FNC(@[cre_usr_id])" ).append("\n"); 
		query.append(",  @[upd_usr_id] " ).append("\n"); 
		query.append(",  CNI_GET_GMT_FNC(@[upd_usr_id])" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}