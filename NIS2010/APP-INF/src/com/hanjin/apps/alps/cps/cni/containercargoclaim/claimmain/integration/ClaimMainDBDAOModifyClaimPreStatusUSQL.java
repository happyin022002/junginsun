/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ClaimMainDBDAOModifyClaimPreStatusUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.16
*@LastModifier : 진윤오
*@LastVersion : 1.0
* 2009.11.16 진윤오
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.cni.containercargoclaim.claimmain.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author J.Y.O
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ClaimMainDBDAOModifyClaimPreStatusUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 이전 Status로 수정
	  * </pre>
	  */
	public ClaimMainDBDAOModifyClaimPreStatusUSQL(){
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
		query.append("Path : com.hanjin.apps.alps.cps.cni.containercargoclaim.claimmain.integration ").append("\n"); 
		query.append("FileName : ClaimMainDBDAOModifyClaimPreStatusUSQL").append("\n"); 
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
		query.append("UPDATE CNI_CGO_CLM SET" ).append("\n"); 
		query.append("CGO_CLM_STS_CD     = BFR_CGO_CLM_STS_CD" ).append("\n"); 
		query.append(",  BFR_CGO_CLM_STS_CD = CGO_CLM_STS_CD" ).append("\n"); 
		query.append(",  CGO_CLM_CLZ_CD     = PRE_CGO_CLM_CLZ_CD" ).append("\n"); 
		query.append(",  PRE_CGO_CLM_CLZ_CD = CGO_CLM_CLZ_CD" ).append("\n"); 
		query.append(",  CS_CLZ_DT = ''" ).append("\n"); 
		query.append(",  CS_CLZ_OFC_CD = ''" ).append("\n"); 
		query.append(",  CS_CLZ_USR_ID = ''" ).append("\n"); 
		query.append(",  UPD_USR_ID         = @[upd_usr_id]" ).append("\n"); 
		query.append(",  UPD_DT             = CNI_GET_GMT_FNC(@[upd_usr_id])" ).append("\n"); 
		query.append("WHERE  CGO_CLM_NO = @[cgo_clm_no]" ).append("\n"); 

	}
}