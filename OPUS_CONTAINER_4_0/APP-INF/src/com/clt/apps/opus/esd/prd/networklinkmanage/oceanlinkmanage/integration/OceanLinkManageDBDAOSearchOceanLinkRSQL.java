/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : OceanLinkManageDBDAOSearchOceanLinkRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.07
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.07 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.prd.networklinkmanage.oceanlinkmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OceanLinkManageDBDAOSearchOceanLinkRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 해당 lane 또는 pol, pod, direction에 해당하는 Ocean Link 정보를 조회한다.
	  * </pre>
	  */
	public OceanLinkManageDBDAOSearchOceanLinkRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_lane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("delt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.prd.networklinkmanage.oceanlinkmanage.integration").append("\n"); 
		query.append("FileName : OceanLinkManageDBDAOSearchOceanLinkRSQL").append("\n"); 
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
		query.append("SELECT VSL_SLAN_CD" ).append("\n"); 
		query.append("      ,SKD_DIR_CD" ).append("\n"); 
		query.append("      ,FM_PORT_CD" ).append("\n"); 
		query.append("      ,FM_PORT_ETB_DY_CD" ).append("\n"); 
		query.append("      ,FM_PORT_ETD_DY_CD" ).append("\n"); 
		query.append("      ,TO_PORT_CD" ).append("\n"); 
		query.append("      ,TO_PORT_ETB_DY_CD" ).append("\n"); 
		query.append("      ,TO_PORT_ETD_DY_CD" ).append("\n"); 
		query.append("      ,A.TZTM_HRS" ).append("\n"); 
		query.append("      ,A.OCN_LNK_MNL_FLG" ).append("\n"); 
		query.append("      ,LTRIM(TO_CHAR(TRUNC(A.TZTM_HRS / 24, 0), '00')) || LTRIM(TO_CHAR(MOD(A.TZTM_HRS, 24), '00')) FMT_TZTM_HRS" ).append("\n"); 
		query.append("      ,A.LNK_RMK" ).append("\n"); 
		query.append("      ,CASE" ).append("\n"); 
		query.append("         WHEN A.OCN_LNK_MNL_FLG = 'Y' and A.DELT_FLG = 'N' THEN 'Manual Creation'" ).append("\n"); 
		query.append("         WHEN A.OCN_LNK_MNL_FLG = 'Y' and A.DELT_FLG = 'Y' THEN 'Manual Deletion'" ).append("\n"); 
		query.append("         ELSE 'Auto Creation'" ).append("\n"); 
		query.append("       END SOURCE" ).append("\n"); 
		query.append("  FROM PRD_PF_TZ_TM A" ).append("\n"); 
		query.append(" WHERE FM_PORT_CD LIKE RTRIM(@[fm_port_cd]) || '%'" ).append("\n"); 
		query.append("   AND TO_PORT_CD LIKE RTRIM(@[to_port_cd]) || '%'" ).append("\n"); 
		query.append("   AND SKD_DIR_CD LIKE RTRIM(@[skd_dir_cd]) || '%'" ).append("\n"); 
		query.append("   AND VSL_SLAN_CD LIKE RTRIM(@[vsl_lane_cd]) || '%'" ).append("\n"); 
		query.append("   AND A.DELT_FLG IN (DECODE(@[delt_flg], 'Y', 'X', 'N'), DECODE(@[delt_flg], 'N', 'X', 'Y'))" ).append("\n"); 

	}
}