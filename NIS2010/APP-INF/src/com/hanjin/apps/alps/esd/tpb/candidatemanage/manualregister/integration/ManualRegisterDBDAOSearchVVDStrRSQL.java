/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ManualRegisterDBDAOSearchVVDStrRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.06
*@LastModifier : 
*@LastVersion : 1.0
* 2015.04.06 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.candidatemanage.manualregister.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ManualRegisterDBDAOSearchVVDStrRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchVVDStr
	  * </pre>
	  */
	public ManualRegisterDBDAOSearchVVDStrRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tpb.candidatemanage.manualregister.integration").append("\n"); 
		query.append("FileName : ManualRegisterDBDAOSearchVVDStrRSQL").append("\n"); 
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
		query.append("SELECT AR.SLAN_DIR_CD||AR.RLANE_DIR_CD AS VVD" ).append("\n"); 
		query.append("  FROM AR_FINC_DIR_CONV AR," ).append("\n"); 
		query.append("       (  SELECT SCONTI_CD" ).append("\n"); 
		query.append("            FROM MDM_LOCATION" ).append("\n"); 
		query.append("           WHERE LOC_CD = @[s_yd_cd]" ).append("\n"); 
		query.append("             AND DELT_FLG = 'N') LOC," ).append("\n"); 
		query.append("       (  SELECT SLAN_CD" ).append("\n"); 
		query.append("            FROM BKG_VVD" ).append("\n"); 
		query.append("           WHERE VSL_CD = @[s_vsl_cd]" ).append("\n"); 
		query.append("             AND SKD_VOY_NO = @[s_skd_voy_no]" ).append("\n"); 
		query.append("             AND SKD_DIR_CD = @[s_skd_dir_cd]" ).append("\n"); 
		query.append("             AND ROWNUM = 1) VVD" ).append("\n"); 
		query.append(" WHERE VVD.SLAN_CD = AR.SLAN_CD" ).append("\n"); 
		query.append("   AND LOC.SCONTI_CD = AR.SCONTI_CD" ).append("\n"); 
		query.append("   AND AR.SLAN_DIR_CD = @[s_skd_dir_cd]" ).append("\n"); 

	}
}