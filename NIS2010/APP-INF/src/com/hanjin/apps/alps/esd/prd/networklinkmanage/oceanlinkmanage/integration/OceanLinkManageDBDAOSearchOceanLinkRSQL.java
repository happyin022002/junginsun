/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : OceanLinkManageDBDAOSearchOceanLinkRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.08.10
*@LastModifier : 박만건
*@LastVersion : 1.0
* 2011.08.10 박만건
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanlinkmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Mangeon
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
		query.append("Path : com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanlinkmanage.integration").append("\n"); 
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
		query.append("SELECT VSL_SLAN_CD, " ).append("\n"); 
		query.append("        SKD_DIR_CD, " ).append("\n"); 
		query.append("        FM_PORT_CD, " ).append("\n"); 
		query.append("        FM_PORT_ETB_DY_CD, " ).append("\n"); 
		query.append("        FM_PORT_ETD_DY_CD, " ).append("\n"); 
		query.append("        TO_PORT_CD, " ).append("\n"); 
		query.append("        TO_PORT_ETB_DY_CD,  " ).append("\n"); 
		query.append("        TO_PORT_ETD_DY_CD,  " ).append("\n"); 
		query.append(" 	    a.TZTM_HRS,A.OCN_LNK_MNL_FLG,  " ).append("\n"); 
		query.append(" 	    ltrim(to_char(trunc(a.tztm_hrs/24,0),'00'))||ltrim(to_char(mod(a.tztm_hrs,24  ),'00')) fmt_tztm_hrs, " ).append("\n"); 
		query.append("-- 	    b.ROUT_SEQ," ).append("\n"); 
		query.append("--		b.TS_IND_CD, " ).append("\n"); 
		query.append("--		decode(b.upd_ind_cd,'S','Standard', 'V','Validation', 'A', 'Add Call', 'T', 'Temporary', 'O', 'Doubt', 'N', 'Not used', 'D', 'Deleted', '', 'G', 'Guide') upd_ind_cd , " ).append("\n"); 
		query.append("--        DECODE(B.UPD_IND_CD, 'D', ' ', a.TZTM_HRS) rnllws,   " ).append("\n"); 
		query.append("--        NVL(B.UPD_IND_CD, 'S') status ,	 " ).append("\n"); 
		query.append("        --'N' del_op," ).append("\n"); 
		query.append("--		DECODE(SUBSTR(TRIM(B.OCN_ROUT_RMK), 1, 1), 'T', 'T', 'D') del_op," ).append("\n"); 
		query.append("        A.LNK_RMK," ).append("\n"); 
		query.append("        CASE WHEN A.OCN_LNK_MNL_FLG = 'Y' and A.DELT_FLG = 'N' THEN 'Manual Creation'" ).append("\n"); 
		query.append("             WHEN A.OCN_LNK_MNL_FLG = 'Y' and A.DELT_FLG = 'Y' THEN 'Manual Deletion'" ).append("\n"); 
		query.append("            ELSE 'Auto Creation'" ).append("\n"); 
		query.append("            END SOURCE" ).append("\n"); 
		query.append("   FROM PRD_PF_TZ_TM A--, PRD_OCN_ROUT B " ).append("\n"); 
		query.append("      WHERE FM_PORT_CD   LIKE RTRIM( @[fm_port_cd] )||'%' " ).append("\n"); 
		query.append("        AND TO_PORT_CD   LIKE RTRIM( @[to_port_cd] )||'%' " ).append("\n"); 
		query.append("        AND SKD_DIR_CD   LIKE RTRIM( @[skd_dir_cd] )||'%' " ).append("\n"); 
		query.append("        AND VSL_SLAN_CD  LIKE RTRIM( @[vsl_lane_cd] )||'%' " ).append("\n"); 
		query.append("--        AND A.FM_PORT_CD   = B.N1ST_POL_CD " ).append("\n"); 
		query.append("--        AND A.TO_PORT_CD   = B.N1ST_POD_CD " ).append("\n"); 
		query.append("--        AND A.VSL_SLAN_CD  = B.N1ST_LANE_CD " ).append("\n"); 
		query.append("--        AND B.N1ST_LANE_FDR_FLG = 'N' " ).append("\n"); 
		query.append("--        AND B.TS_IND_CD = 'D'" ).append("\n"); 
		query.append("        AND A.DELT_FLG IN(DECODE(@[delt_flg],'Y','X','N'), DECODE(@[delt_flg],'N','X','Y'))" ).append("\n"); 

	}
}