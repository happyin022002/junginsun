/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : NewCctVgmHisManageDBDAOSearchPrdTmlVgmCctHisRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.10.24
*@LastModifier : 
*@LastVersion : 1.0
* 2016.10.24 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.prd.networknodemanage.cctmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class NewCctVgmHisManageDBDAOSearchPrdTmlVgmCctHisRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * NewCctVgmHisManageDBDAOSearchPrdTmlVgmCctHis
	  * </pre>
	  */
	public NewCctVgmHisManageDBDAOSearchPrdTmlVgmCctHisRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_slan_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cgo_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vgm_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pctl_use_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clpt_ind_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vps_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.prd.networknodemanage.cctmanage.integration").append("\n"); 
		query.append("FileName : NewCctVgmHisManageDBDAOSearchPrdTmlVgmCctHisRSQL").append("\n"); 
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
		query.append("SELECT HIS_SEQ" ).append("\n"); 
		query.append("      ,PCTL_USE_FLG" ).append("\n"); 
		query.append("      ,YD_CD" ).append("\n"); 
		query.append("      ,VSL_SLAN_CD" ).append("\n"); 
		query.append("      ,VSL_SLAN_DIR_CD" ).append("\n"); 
		query.append("      ,CGO_TP_CD" ).append("\n"); 
		query.append("      ,VVD_CD" ).append("\n"); 
		query.append("      ,VGM_FLG" ).append("\n"); 
		query.append("      ,DELT_FLG" ).append("\n"); 
		query.append("      ,CCT_TP_CD" ).append("\n"); 
		query.append("      ,CCT_HR" ).append("\n"); 
		query.append("      ,CCT_DY_CD" ).append("\n"); 
		query.append("      ,CCT_HRMNT" ).append("\n"); 
		query.append("      ,VPS_PORT_CD" ).append("\n"); 
		query.append("      ,CLPT_IND_SEQ" ).append("\n"); 
		query.append("      ,CCT_FILE_FLG" ).append("\n"); 
		query.append("      ,YD_BSE_CALC_FLG" ).append("\n"); 
		query.append("      ,XCLD_HOL_FRI_FLG" ).append("\n"); 
		query.append("      ,XCLD_HOL_SAT_FLG" ).append("\n"); 
		query.append("      ,XCLD_HOL_SUN_FLG" ).append("\n"); 
		query.append("      ,XCLD_HOL_HOL_FLG" ).append("\n"); 
		query.append("      ,CGO_CLZ_DT" ).append("\n"); 
		query.append("      ,DCGO_CLZ_DT" ).append("\n"); 
		query.append("      ,RC_CLZ_DT" ).append("\n"); 
		query.append("      ,AWK_CGO_CLZ_DT" ).append("\n"); 
		query.append("      ,BB_CGO_CLZ_DT" ).append("\n"); 
		query.append("      ,VGM_CLZ_DT" ).append("\n"); 
		query.append("      ,CRE_USR_ID" ).append("\n"); 
		query.append("      ,CRE_DT" ).append("\n"); 
		query.append("      ,UPD_USR_ID" ).append("\n"); 
		query.append("      ,UPD_DT" ).append("\n"); 
		query.append("  FROM PRD_TML_VGM_CCT_HIS" ).append("\n"); 
		query.append(" WHERE PCTL_USE_FLG = @[pctl_use_flg]" ).append("\n"); 
		query.append("#if (${pctl_use_flg} == 'Y')" ).append("\n"); 
		query.append("   AND YD_CD = @[yd_cd]" ).append("\n"); 
		query.append("   AND VSL_SLAN_CD = @[vsl_slan_cd]" ).append("\n"); 
		query.append("   AND VSL_SLAN_DIR_CD = @[vsl_slan_dir_cd]" ).append("\n"); 
		query.append("   AND CGO_TP_CD = @[cgo_tp_cd]" ).append("\n"); 
		query.append("   AND VGM_FLG = @[vgm_flg]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("   AND VVD_CD = @[vvd_cd]" ).append("\n"); 
		query.append("   AND VSL_SLAN_CD = @[vsl_slan_cd]   " ).append("\n"); 
		query.append("   AND VPS_PORT_CD = @[vps_port_cd]" ).append("\n"); 
		query.append("   AND CLPT_IND_SEQ = @[clpt_ind_seq]" ).append("\n"); 
		query.append("   AND VGM_FLG = @[vgm_flg]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" ORDER BY UPD_DT DESC" ).append("\n"); 

	}
}