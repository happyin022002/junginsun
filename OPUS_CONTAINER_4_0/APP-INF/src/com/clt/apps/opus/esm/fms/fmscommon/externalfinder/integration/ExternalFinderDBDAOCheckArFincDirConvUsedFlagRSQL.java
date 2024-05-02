/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ExternalFinderDBDAOCheckArFincDirConvUsedFlagRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.02
*@LastModifier : 
*@LastVersion : 1.0
* 2015.11.02 
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

public class ExternalFinderDBDAOCheckArFincDirConvUsedFlagRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AR_FINC_DIR_CONV 존재여부
	  * </pre>
	  */
	public ExternalFinderDBDAOCheckArFincDirConvUsedFlagRSQL(){
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
		query.append("FileName : ExternalFinderDBDAOCheckArFincDirConvUsedFlagRSQL").append("\n"); 
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
		query.append("SELECT CASE" ).append("\n"); 
		query.append("         WHEN COUNT(RLANE_DIR_CD) > 0 THEN 'Y'" ).append("\n"); 
		query.append("         ELSE ''" ).append("\n"); 
		query.append("       END AS USED_YN" ).append("\n"); 
		query.append("  FROM AR_FINC_DIR_CONV" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("#if (${rlane_cd} != '')" ).append("\n"); 
		query.append("   AND RLANE_CD = @[rlane_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${slan_cd} != '')" ).append("\n"); 
		query.append("   AND SLAN_CD = @[slan_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${slan_dir_cd} != '')" ).append("\n"); 
		query.append("   AND SLAN_DIR_CD = @[slan_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rlane_dir_cd} != '')" ).append("\n"); 
		query.append("   AND RLANE_DIR_CD = @[rlane_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}