/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EstimationDBDAOSearchVoyEndRmnOilWgtByVvdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.03
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2012.04.03 진마리아
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

public class EstimationDBDAOSearchVoyEndRmnOilWgtByVvdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Search voyage end remain oil weight by VVD.
	  * </pre>
	  */
	public EstimationDBDAOSearchVoyEndRmnOilWgtByVvdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("end_clpt_ind_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("end_skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("act_end_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("end_skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.fcm.estimation.estimation.integration").append("\n"); 
		query.append("FileName : EstimationDBDAOSearchVoyEndRmnOilWgtByVvdRSQL").append("\n"); 
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
		query.append("SELECT DECODE(@[csm_oil_tp_cd], 'HFO', ARR_FOIL_WGT + ARR_LOW_SULP_FOIL_WGT," ).append("\n"); 
		query.append("                                    'MDO', ARR_DOIL_WGT + ARR_LOW_SULP_DOIL_WGT) AS VOY_END_RMN_WGT" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT TO_NUMBER(NVL(REPLACE(REPLACE(ARR_FOIL_WGT, CHR(10), ''), CHR(13), ''), '0')) ARR_FOIL_WGT" ).append("\n"); 
		query.append("          ,TO_NUMBER(NVL(REPLACE(REPLACE(ARR_LOW_SULP_FOIL_WGT, CHR(10), ''), CHR(13), ''), '0')) ARR_LOW_SULP_FOIL_WGT" ).append("\n"); 
		query.append("          ,TO_NUMBER(NVL(REPLACE(REPLACE(ARR_DOIL_WGT, CHR(10), ''), CHR(13), ''), '0')) ARR_DOIL_WGT" ).append("\n"); 
		query.append("          ,TO_NUMBER(NVL(REPLACE(REPLACE(ARR_LOW_SULP_DOIL_WGT, CHR(10), ''), CHR(13), ''), '0')) ARR_LOW_SULP_DOIL_WGT" ).append("\n"); 
		query.append("    FROM FCM_DEP_RPT" ).append("\n"); 
		query.append("    WHERE VSL_CD     = @[vsl_cd]" ).append("\n"); 
		query.append("    AND SKD_VOY_NO   = @[end_skd_voy_no]" ).append("\n"); 
		query.append("    AND SKD_DIR_CD   = @[end_skd_dir_cd]" ).append("\n"); 
		query.append("    AND DEP_PORT_CD  = @[act_end_port_cd]" ).append("\n"); 
		query.append("    AND CLPT_IND_SEQ = @[end_clpt_ind_seq]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}