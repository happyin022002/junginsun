/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : LaneSimulationDBDAOMultiSimPortListDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.18
*@LastModifier : 윤진영
*@LastVersion : 1.0
* 2009.11.18 윤진영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.lanesimulation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Yoon jin young
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class LaneSimulationDBDAOMultiSimPortListDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 터미널정보 삭제
	  * </pre>
	  */
	public LaneSimulationDBDAOMultiSimPortListDSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sim_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sim_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vsl_dbl_call_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.lanesimulation.integration").append("\n"); 
		query.append("FileName : LaneSimulationDBDAOMultiSimPortListDSQL").append("\n"); 
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
		query.append("DELETE FROM MAS_SIM_TML_INFO" ).append("\n"); 
		query.append("WHERE SIM_DT     = @[sim_dt]" ).append("\n"); 
		query.append("AND SIM_NO     = @[sim_no]" ).append("\n"); 
		query.append("#if (${skd_dir_cd} != '')" ).append("\n"); 
		query.append("AND SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${tml_cd} != '')" ).append("\n"); 
		query.append("AND TML_CD     = @[tml_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vsl_dbl_call_seq} != '')" ).append("\n"); 
		query.append("AND VSL_DBL_CALL_SEQ  = @[vsl_dbl_call_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}