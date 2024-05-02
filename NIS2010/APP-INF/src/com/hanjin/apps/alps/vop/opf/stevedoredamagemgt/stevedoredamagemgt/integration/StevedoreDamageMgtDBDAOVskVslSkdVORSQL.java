/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : StevedoreDamageMgtDBDAOVskVslSkdVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.10.15
*@LastModifier : 이석준
*@LastVersion : 1.0
* 2010.10.15 이석준
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.opf.stevedoredamagemgt.stevedoredamagemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Joon(Suk-Joon) LEE
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class StevedoreDamageMgtDBDAOVskVslSkdVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VskVslSkdVO Select Query.
	  * </pre>
	  */
	public StevedoreDamageMgtDBDAOVskVslSkdVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.opf.stevedoredamagemgt.stevedoredamagemgt.integration").append("\n"); 
		query.append("FileName : StevedoreDamageMgtDBDAOVskVslSkdVORSQL").append("\n"); 
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
		query.append("  FROM VSK_VSL_SKD" ).append("\n"); 
		query.append(" WHERE VSL_CD     = @[vsl_cd]" ).append("\n"); 
		query.append("   AND SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("   AND SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("union all" ).append("\n"); 
		query.append("  select SLAN_CD as VSL_SLAN_CD" ).append("\n"); 
		query.append("    from ar_mst_rev_vvd" ).append("\n"); 
		query.append("   where vsl_cd     = @[vsl_cd]  " ).append("\n"); 
		query.append("     and skd_voy_no = @[skd_voy_no]" ).append("\n"); 
		query.append("     and skd_dir_cd = @[skd_dir_cd] " ).append("\n"); 
		query.append("     and not exists (SELECT VSL_SLAN_CD" ).append("\n"); 
		query.append("                      FROM VSK_VSL_SKD" ).append("\n"); 
		query.append("                     WHERE VSL_CD     = @[vsl_cd]" ).append("\n"); 
		query.append("                       AND SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("                       AND SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("                     )" ).append("\n"); 

	}
}