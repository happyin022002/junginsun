/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : OceanLinkManageDBDAORHQLinkDelete3USQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.14
*@LastModifier : 
*@LastVersion : 1.0
* 2010.05.14 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanlinkmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OceanLinkManageDBDAORHQLinkDelete3USQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RHQLinkDelete3
	  * </pre>
	  */
	public OceanLinkManageDBDAORHQLinkDelete3USQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_from",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_to",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanlinkmanage.integration").append("\n"); 
		query.append("FileName : OceanLinkManageDBDAORHQLinkDelete3USQL").append("\n"); 
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
		query.append("UPDATE prd_ocn_rout a " ).append("\n"); 
		query.append("    SET upd_ind_cd = 'D', " ).append("\n"); 
		query.append("        OCN_ROUT_UPD_DT = SYSDATE, " ).append("\n"); 
		query.append("        upd_ofc_cd = @[cre_ofc_cd] ,  " ).append("\n"); 
		query.append("        upd_usr_id = @[upd_usr_id] , " ).append("\n"); 
		query.append("        ocn_rout_rmk = 'Deleted by CCA Status', " ).append("\n"); 
		query.append(" 	OCN_ROUT_DELT_RMK = SYSDATE||' ID:'||@[upd_usr_id] ||'  ,Deleted by RHQ Ocean Link, N2ND lane'          			 			 " ).append("\n"); 
		query.append("  WHERE ts_ind_cd = 'T' " ).append("\n"); 
		query.append("    AND upd_ind_cd IN ('C', 'U', 'S') " ).append("\n"); 
		query.append("    AND lnk_knt > 1 " ).append("\n"); 
		query.append("    AND n2nd_pol_cd = RTRIM (@[s_from] )  " ).append("\n"); 
		query.append("    AND n2nd_pod_cd = RTRIM (@[s_to] )  " ).append("\n"); 
		query.append("    AND n2nd_lane_fdr_flg = 'Y'" ).append("\n"); 

	}
}