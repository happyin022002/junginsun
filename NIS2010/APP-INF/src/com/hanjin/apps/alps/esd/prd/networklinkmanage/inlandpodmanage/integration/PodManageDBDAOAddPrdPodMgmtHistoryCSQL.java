/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : PodManageDBDAOAddPrdPodMgmtHistoryCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.03.26
*@LastModifier : 
*@LastVersion : 1.0
* 2013.03.26 
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

public class PodManageDBDAOAddPrdPodMgmtHistoryCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * POD History 정보를 생성한다.
	  * </pre>
	  */
	public PodManageDBDAOAddPrdPodMgmtHistoryCSQL(){
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
		params.put("pctl_io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_term",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trans_mode",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandpodmanage.integration").append("\n"); 
		query.append("FileName : PodManageDBDAOAddPrdPodMgmtHistoryCSQL").append("\n"); 
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
		query.append("INSERT INTO PRD_POD_MGMT_HIS" ).append("\n"); 
		query.append("(POD_CD,SLAN_CD,DEL_CD, PCTL_IO_BND_CD, BKG_DE_TERM_CD, TRSP_MOD_CD," ).append("\n"); 
		query.append("HIS_CRE_DT, ARR_STE_CD, APLY_SVC_MOD_FLG, BKG_RMK, DELT_FLG, CRE_OFC_CD," ).append("\n"); 
		query.append("UPD_OFC_CD, CRE_USR_ID, CRE_DT, UPD_USR_ID, UPD_DT)" ).append("\n"); 
		query.append("     SELECT POD_CD, SLAN_CD, DEL_CD, PCTL_IO_BND_CD, BKG_DE_TERM_CD, TRSP_MOD_CD," ).append("\n"); 
		query.append("            SYSDATE, ARR_STE_CD, APLY_SVC_MOD_FLG, BKG_RMK, DELT_FLG, CRE_OFC_CD," ).append("\n"); 
		query.append("            UPD_OFC_CD, CRE_USR_ID, CRE_DT, UPD_USR_ID, UPD_DT" ).append("\n"); 
		query.append("       FROM PRD_POD_MGMT" ).append("\n"); 
		query.append("      WHERE SLAN_CD LIKE @[lane_code] || '%' " ).append("\n"); 
		query.append("        AND POD_CD LIKE @[pod_code] || '%' " ).append("\n"); 
		query.append("        AND DEL_CD LIKE @[del_code] || '%' " ).append("\n"); 
		query.append("        AND BKG_DE_TERM_CD LIKE @[del_term] || '%' " ).append("\n"); 
		query.append("        AND TRSP_MOD_CD LIKE @[trans_mode] || '%'" ).append("\n"); 
		query.append("        AND PCTL_IO_BND_CD = @[pctl_io_bnd_cd]" ).append("\n"); 

	}
}