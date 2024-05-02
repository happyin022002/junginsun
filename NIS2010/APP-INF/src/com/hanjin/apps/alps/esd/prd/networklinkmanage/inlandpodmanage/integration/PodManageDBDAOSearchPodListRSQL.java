/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : PodManageDBDAOSearchPodListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.04.04
*@LastModifier : 
*@LastVersion : 1.0
* 2013.04.04 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandpodmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PodManageDBDAOSearchPodListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchPodList
	  * </pre>
	  */
	public PodManageDBDAOSearchPodListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_code",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pctl_io",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lane_code",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_code",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_flag",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandpodmanage.integration").append("\n"); 
		query.append("FileName : PodManageDBDAOSearchPodListRSQL").append("\n"); 
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
		query.append("SELECT PCTL_IO_BND_CD" ).append("\n"); 
		query.append("     , SLAN_CD LANE_CODE " ).append("\n"); 
		query.append(" 	 , POD_CD POD_CODE " ).append("\n"); 
		query.append(" 	 , DEL_CD DEL_CODE " ).append("\n"); 
		query.append(" 	 , ARR_STE_CD DEL_STATE " ).append("\n"); 
		query.append(" 	 , BKG_DE_TERM_CD DEL_TERM " ).append("\n"); 
		query.append(" 	 , TRSP_MOD_CD TRANS_MODE " ).append("\n"); 
		query.append(" 	 , APLY_SVC_MOD_FLG SERVICE " ).append("\n"); 
		query.append(" 	 , BKG_RMK REMARKS " ).append("\n"); 
		query.append(" 	 , DECODE(DELT_FLG, 'Y', '1', '0') DEL_FLAG " ).append("\n"); 
		query.append("     , CRE_OFC_CD" ).append("\n"); 
		query.append(" 	 , CRE_USR_ID " ).append("\n"); 
		query.append(" 	 , TO_CHAR(CRE_DT,'YYYY-MM-DD') CRE_DT" ).append("\n"); 
		query.append("     , UPD_OFC_CD" ).append("\n"); 
		query.append(" 	 , UPD_USR_ID" ).append("\n"); 
		query.append(" 	 , TO_CHAR(UPD_DT,'YYYY-MM-DD') UPD_DT" ).append("\n"); 
		query.append("     ,pctl_imdg_clss_ctnt" ).append("\n"); 
		query.append("  FROM PRD_POD_MGMT " ).append("\n"); 
		query.append(" WHERE SLAN_CD LIKE @[lane_code] || '%' " ).append("\n"); 
		query.append("   AND POD_CD LIKE @[pod_code] || '%' " ).append("\n"); 
		query.append("   AND DEL_CD LIKE @[del_code] || '%' " ).append("\n"); 
		query.append("   AND DELT_FLG LIKE DECODE(@[del_flag] , 'A', '%', @[del_flag])" ).append("\n"); 
		query.append("   AND PCTL_IO_BND_CD = @[pctl_io]" ).append("\n"); 

	}
}