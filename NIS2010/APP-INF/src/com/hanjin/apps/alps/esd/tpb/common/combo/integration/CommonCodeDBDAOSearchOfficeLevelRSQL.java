/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CommonCodeDBDAOSearchOfficeLevelRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.17
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.17 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.common.combo.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CommonCodeDBDAOSearchOfficeLevelRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchOfficeLevel
	  * </pre>
	  */
	public CommonCodeDBDAOSearchOfficeLevelRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tpb.common.combo.integration").append("\n"); 
		query.append("FileName : CommonCodeDBDAOSearchOfficeLevelRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT office_level," ).append("\n"); 
		query.append("       ofc_cd," ).append("\n"); 
		query.append("       rhq_cd," ).append("\n"); 
		query.append("       ho_cd" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("       ----- HO -----" ).append("\n"); 
		query.append("       SELECT 'H' office_level, ofc_cd, NULL AS rhq_cd, ofc_cd ho_cd" ).append("\n"); 
		query.append("         FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("        WHERE 1=1" ).append("\n"); 
		query.append("          AND ofc_knd_cd = '1'" ).append("\n"); 
		query.append("          AND ofc_cd = @[s_ofc_cd]" ).append("\n"); 
		query.append("       -----" ).append("\n"); 
		query.append("       UNION ALL" ).append("\n"); 
		query.append("       ----- RHQ -----" ).append("\n"); 
		query.append("	   SELECT DISTINCT 'R' AS office_level," ).append("\n"); 
		query.append("    	      DECODE(prnt_ofc_cd, 'SELDC', ofc_cd, prnt_ofc_cd) AS ofc_cd, --SELMDC 조직변경" ).append("\n"); 
		query.append("    	      DECODE(prnt_ofc_cd, 'SELDC', ofc_cd, prnt_ofc_cd) AS rhq_cd, --SELMDC 조직변경" ).append("\n"); 
		query.append("    	      NULL AS ho_cd" ).append("\n"); 
		query.append("	    FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("	   WHERE 1=1" ).append("\n"); 
		query.append("    	 AND ofc_knd_cd = '2'" ).append("\n"); 
		query.append("    	 AND delt_flg = 'N'" ).append("\n"); 
		query.append("    	 AND ofc_cd = @[s_ofc_cd]" ).append("\n"); 
		query.append("         AND ofc_cd != 'SINRS' --SINMA 조직변경" ).append("\n"); 
		query.append("       -----" ).append("\n"); 
		query.append("       UNION ALL" ).append("\n"); 
		query.append("       ----- RHQ - SINWA -----" ).append("\n"); 
		query.append("	   SELECT DISTINCT 'R' AS office_level," ).append("\n"); 
		query.append("    	      ofc_cd," ).append("\n"); 
		query.append("    	      ofc_cd rhq_cd," ).append("\n"); 
		query.append("    	      NULL AS ho_cd" ).append("\n"); 
		query.append("	     FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("	    WHERE 1=1" ).append("\n"); 
		query.append("          AND ofc_knd_cd = '2'" ).append("\n"); 
		query.append("          AND delt_flg = 'N'" ).append("\n"); 
		query.append("    	  AND ofc_cd = @[s_ofc_cd]" ).append("\n"); 
		query.append("          AND ofc_cd = 'SINRS'  --SINMA 조직변경" ).append("\n"); 
		query.append("       -----" ).append("\n"); 
		query.append("       UNION ALL" ).append("\n"); 
		query.append("       ----- GO 1 -----" ).append("\n"); 
		query.append("       SELECT 'G' office_level, n3pty_ofc_cd, rhq_cd, NULL AS ho_cd" ).append("\n"); 
		query.append("         FROM TPB_HNDL_OFC" ).append("\n"); 
		query.append("        WHERE n3pty_ofc_cd = @[s_ofc_cd]" ).append("\n"); 
		query.append("          AND delt_flg = 'N'" ).append("\n"); 
		query.append("       ) A" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 

	}
}