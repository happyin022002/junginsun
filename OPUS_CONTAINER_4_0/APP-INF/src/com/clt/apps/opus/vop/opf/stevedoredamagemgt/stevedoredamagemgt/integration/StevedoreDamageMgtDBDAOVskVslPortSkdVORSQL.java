/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : StevedoreDamageMgtDBDAOVskVslPortSkdVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.16
*@LastModifier : 이선영
*@LastVersion : 1.0
* 2009.07.16 이선영
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.opf.stevedoredamagemgt.stevedoredamagemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author SunyoungLee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class StevedoreDamageMgtDBDAOVskVslPortSkdVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VskVslPortSkdVO Port Select Query.
	  * </pre>
	  */
	public StevedoreDamageMgtDBDAOVskVslPortSkdVORSQL(){
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
		params.put("vps_port_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.clt.apps.opus.vop.opf.stevedoredamagemgt.stevedoredamagemgt.integration").append("\n"); 
		query.append("FileName : StevedoreDamageMgtDBDAOVskVslPortSkdVORSQL").append("\n"); 
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
		query.append("SELECT VPS_PORT_CD," ).append("\n"); 
		query.append("SLAN_CD," ).append("\n"); 
		query.append("TO_CHAR(VPS_ETA_DT,'YYYY-MM-DD') AS VPS_ETA_DT," ).append("\n"); 
		query.append("TO_CHAR(VPS_ETD_DT,'YYYY-MM-DD') AS VPS_ETD_DT" ).append("\n"); 
		query.append("FROM   VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("WHERE  VSL_CD      = @[vsl_cd]" ).append("\n"); 
		query.append("AND    SKD_VOY_NO  = @[skd_voy_no]" ).append("\n"); 
		query.append("AND    SKD_DIR_CD  = @[skd_dir_cd]" ).append("\n"); 
		query.append("#if (${vps_port_cd} == 'OrderBySeq')" ).append("\n"); 
		query.append("AND    TURN_PORT_IND_CD NOT IN ('D','V','F')" ).append("\n"); 
		query.append("ORDER BY CLPT_SEQ" ).append("\n"); 
		query.append("#elseif (${vps_port_cd} != '')" ).append("\n"); 
		query.append("AND    VPS_PORT_CD  = @[vps_port_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}