/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EstimationDBDAOSearchVvdRmnOilWgtAtMonEndRptRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.03.02
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2012.03.02 진마리아
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.fcm.estimation.estimation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Maria Chin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EstimationDBDAOSearchVvdRmnOilWgtAtMonEndRptRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Search a some VVD's remain oil weight at the month-end report.
	  * =============================================================
	  * </pre>
	  */
	public EstimationDBDAOSearchVvdRmnOilWgtAtMonEndRptRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_yrmon",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("csm_oil_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.hanjin.apps.alps.vop.fcm.estimation.estimation.integration").append("\n"); 
		query.append("FileName : EstimationDBDAOSearchVvdRmnOilWgtAtMonEndRptRSQL").append("\n"); 
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
		query.append("SELECT CASE WHEN 'HFO'=@[csm_oil_tp_cd] THEN" ).append("\n"); 
		query.append("           FOIL_RMN_WGT+LOW_SULP_FOIL_RMN_WGT" ).append("\n"); 
		query.append("       WHEN 'MDO'=@[csm_oil_tp_cd] THEN" ).append("\n"); 
		query.append("           DOIL_RMN_WGT+LOW_SULP_DOIL_RMN_WGT" ).append("\n"); 
		query.append("       ELSE 0 END MON_END_RMN_WGT" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT NVL(TRIM(FOIL_RMN_WGT),0) FOIL_RMN_WGT" ).append("\n"); 
		query.append("          ,NVL(TRIM(DOIL_RMN_WGT),0) DOIL_RMN_WGT" ).append("\n"); 
		query.append("          ,NVL(TRIM(LOW_SULP_FOIL_RMN_WGT),0) LOW_SULP_FOIL_RMN_WGT" ).append("\n"); 
		query.append("          ,NVL(TRIM(LOW_SULP_DOIL_RMN_WGT),0) LOW_SULP_DOIL_RMN_WGT" ).append("\n"); 
		query.append("    FROM FCM_RMN_OIL_MON_END_RPT" ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("    AND REV_YRMON=REPLACE(@[rev_yrmon], '-', '')" ).append("\n"); 
		query.append("    AND VSL_CD=@[vsl_cd]" ).append("\n"); 
		query.append("    AND SKD_VOY_NO=@[skd_voy_no]" ).append("\n"); 
		query.append("    AND SKD_DIR_CD=@[skd_dir_cd]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}