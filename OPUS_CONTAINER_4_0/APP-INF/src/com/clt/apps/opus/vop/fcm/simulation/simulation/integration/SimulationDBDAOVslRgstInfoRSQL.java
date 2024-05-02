/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : SimulationDBDAOVslRgstInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.12.23
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2011.12.23 진마리아
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.fcm.simulation.simulation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Maria Chin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SimulationDBDAOVslRgstInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Simulation에 필요한 Vessel Registration 정보를 조회한다.
	  * </pre>
	  */
	public SimulationDBDAOVslRgstInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_dzn_capa",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.fcm.simulation.simulation.integration").append("\n"); 
		query.append("FileName : SimulationDBDAOVslRgstInfoRSQL").append("\n"); 
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
		query.append("#if (${trnd_line_tp_cd} == '1' || ${trnd_line_tp_cd} == '2') " ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("MAX(OP_MIN_SPD) OP_MIN_SPD," ).append("\n"); 
		query.append("MAX(OP_MAX_SPD) OP_MAX_SPD," ).append("\n"); 
		query.append("MAX(OP_GNR_SPD) OP_GNR_SPD," ).append("\n"); 
		query.append("MAX(MNVR_CSM_WGT) MNVR_CSM_WGT," ).append("\n"); 
		query.append("MAX(GNR_CSM_WGT) GNR_CSM_WGT" ).append("\n"); 
		query.append("FROM MDM_VSL_CNTR T1, FCM_VSL_CNTR_RGST T2" ).append("\n"); 
		query.append("WHERE T1.VSL_CD=T2.VSL_CD" ).append("\n"); 
		query.append("AND T1.CNTR_DZN_CAPA=@[cntr_dzn_capa]" ).append("\n"); 
		query.append("#elseif (${trnd_line_tp_cd} == '3' || ${trnd_line_tp_cd} == '4') " ).append("\n"); 
		query.append("SELECT OP_MIN_SPD, OP_MAX_SPD, OP_GNR_SPD, MNVR_CSM_WGT, GNR_CSM_WGT" ).append("\n"); 
		query.append("FROM FCM_VSL_CNTR_RGST" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND VSL_CD=@[vsl_cd]" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("SELECT 0 OP_MIN_SPD, 0 OP_MAX_SPD, 0 OP_GNR_SPD, 0 MNVR_CSM_WGT, 0 GNR_CSM_WGT" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}