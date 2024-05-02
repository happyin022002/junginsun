/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EstimationDBDAOSearchArrOilWgtLastPortRSQL.java
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

public class EstimationDBDAOSearchArrOilWgtLastPortRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Search a arrival oil weight at the last calling port.
	  * ==============================================
	  * </pre>
	  */
	public EstimationDBDAOSearchArrOilWgtLastPortRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("end_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("end_port_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.fcm.estimation.estimation.integration").append("\n"); 
		query.append("FileName : EstimationDBDAOSearchArrOilWgtLastPortRSQL").append("\n"); 
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
		query.append("           ARR_FOIL_WGT + ARR_LOW_SULP_FOIL_WGT" ).append("\n"); 
		query.append("       WHEN 'MDO'=@[csm_oil_tp_cd] THEN" ).append("\n"); 
		query.append("           ARR_DOIL_WGT + ARR_LOW_SULP_DOIL_WGT" ).append("\n"); 
		query.append("       ELSE 0 END VOY_END_RMN_WGT" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT TO_NUMBER(NVL(TRIM(REPLACE(REPLACE(ARR_FOIL_WGT, CHR(13), ''), CHR(10), '')),0))           ARR_FOIL_WGT" ).append("\n"); 
		query.append("          ,TO_NUMBER(NVL(TRIM(REPLACE(REPLACE(ARR_LOW_SULP_FOIL_WGT, CHR(13), ''), CHR(10), '')),0))  ARR_LOW_SULP_FOIL_WGT" ).append("\n"); 
		query.append("          ,TO_NUMBER(NVL(TRIM(REPLACE(REPLACE(ARR_DOIL_WGT, CHR(13), ''), CHR(10), '')),0))           ARR_DOIL_WGT" ).append("\n"); 
		query.append("          ,TO_NUMBER(NVL(TRIM(REPLACE(REPLACE(ARR_LOW_SULP_DOIL_WGT, CHR(13), ''), CHR(10), '')),0))  ARR_LOW_SULP_DOIL_WGT" ).append("\n"); 
		query.append("    FROM FCM_DEP_RPT" ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("    AND VSL_CD=@[vsl_cd]" ).append("\n"); 
		query.append("    AND DEP_PORT_CD=@[end_port_cd]" ).append("\n"); 
		query.append("    --AND CLPT_IND_SEQ='1'" ).append("\n"); 
		query.append("    AND VPS_ETB_DT BETWEEN TO_DATE(REPLACE(SUBSTR(@[end_dt], 1, 10), '-', ''), 'YYYYMMDD')-1" ).append("\n"); 
		query.append("                       AND TO_DATE(REPLACE(SUBSTR(@[end_dt], 1, 10), '-', ''), 'YYYYMMDD')+1.99999" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}