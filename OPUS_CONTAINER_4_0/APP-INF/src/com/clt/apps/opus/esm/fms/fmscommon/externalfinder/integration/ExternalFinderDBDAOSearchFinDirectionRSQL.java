/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ExternalFinderDBDAOSearchFinDirectionRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.30
*@LastModifier : 
*@LastVersion : 1.0
* 2015.11.30 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.fms.fmscommon.externalfinder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ExternalFinderDBDAOSearchFinDirectionRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Fin Direction Search
	  * </pre>
	  */
	public ExternalFinderDBDAOSearchFinDirectionRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlane_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slan_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.fms.fmscommon.externalfinder.integration").append("\n"); 
		query.append("FileName : ExternalFinderDBDAOSearchFinDirectionRSQL").append("\n"); 
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
		query.append("#if (${used_yn} != '') " ).append("\n"); 
		query.append("/*AR_FINC_DIR_CONV*/" ).append("\n"); 
		query.append("SELECT C.RLANE_DIR_CD AS RLANE_DIR_CD" ).append("\n"); 
		query.append("  FROM MDM_VSL_SVC_LANE L" ).append("\n"); 
		query.append("     , MDM_VSL_SVC_LANE_DIR D" ).append("\n"); 
		query.append("     , AR_FINC_DIR_CONV C" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND L.DELT_FLG = 'N'" ).append("\n"); 
		query.append("   AND L.VSL_SLAN_CD = D.VSL_SLAN_CD" ).append("\n"); 
		query.append("   AND L.VSL_SLAN_CD = @[slan_cd]" ).append("\n"); 
		query.append("   AND D.VSL_SLAN_DIR_CD = @[slan_dir_cd]" ).append("\n"); 
		query.append("   AND D.VSL_SLAN_CD = C.SLAN_CD" ).append("\n"); 
		query.append("   AND D.VSL_SLAN_DIR_CD = C.SLAN_DIR_CD" ).append("\n"); 
		query.append("   AND C.RLANE_CD = @[rlane_cd]" ).append("\n"); 
		query.append("#if (${rlane_dir_cd} != '') " ).append("\n"); 
		query.append("   AND C.RLANE_DIR_CD = @[rlane_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("/*Default SLAN_CD*/" ).append("\n"); 
		query.append("SELECT D.VSL_SLAN_DIR_CD AS RLANE_DIR_CD" ).append("\n"); 
		query.append("  FROM MDM_VSL_SVC_LANE L" ).append("\n"); 
		query.append("     , MDM_VSL_SVC_LANE_DIR D" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND L.DELT_FLG = 'N'" ).append("\n"); 
		query.append("   AND L.VSL_SLAN_CD = D.VSL_SLAN_CD" ).append("\n"); 
		query.append("   AND L.VSL_SLAN_CD = @[slan_cd]" ).append("\n"); 
		query.append("   AND D.VSL_SLAN_DIR_CD = @[slan_dir_cd]" ).append("\n"); 
		query.append("   AND ROWNUM = 1" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}