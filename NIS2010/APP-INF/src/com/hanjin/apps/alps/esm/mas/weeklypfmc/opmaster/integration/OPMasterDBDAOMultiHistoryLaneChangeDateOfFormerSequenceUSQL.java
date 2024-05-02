/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : OPMasterDBDAOMultiHistoryLaneChangeDateOfFormerSequenceUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.16
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.16 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.weeklypfmc.opmaster.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OPMasterDBDAOMultiHistoryLaneChangeDateOfFormerSequenceUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2016.03.03 Create Lane Table, Create Vessel Table history 자동 관리
	  * </pre>
	  */
	public OPMasterDBDAOMultiHistoryLaneChangeDateOfFormerSequenceUSQL(){
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
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.weeklypfmc.opmaster.integration").append("\n"); 
		query.append("FileName : OPMasterDBDAOMultiHistoryLaneChangeDateOfFormerSequenceUSQL").append("\n"); 
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
		query.append("UPDATE MAS_LANE_TP_HIS" ).append("\n"); 
		query.append("SET LANE_APLY_TO_DT = TO_CHAR(SYSDATE - 1, 'YYYYMMDD')" ).append("\n"); 
		query.append("WHERE TRD_CD = @[trd_cd]" ).append("\n"); 
		query.append("AND RLANE_CD = @[rlane_cd]" ).append("\n"); 
		query.append("AND DIR_CD = @[dir_cd]" ).append("\n"); 
		query.append("#if (${update_flg} == 'Y')" ).append("\n"); 
		query.append("AND LANE_SEQ = (SELECT MAX(LANE_SEQ) " ).append("\n"); 
		query.append("                FROM MAS_LANE_TP_HIS" ).append("\n"); 
		query.append("                WHERE TRD_CD = @[trd_cd]" ).append("\n"); 
		query.append("                AND RLANE_CD = @[rlane_cd]" ).append("\n"); 
		query.append("                AND DIR_CD = @[dir_cd]) - 1" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND LANE_SEQ = (SELECT MAX(LANE_SEQ) " ).append("\n"); 
		query.append("                FROM MAS_LANE_TP_HIS" ).append("\n"); 
		query.append("                WHERE TRD_CD = @[trd_cd]" ).append("\n"); 
		query.append("                AND RLANE_CD = @[rlane_cd]" ).append("\n"); 
		query.append("                AND DIR_CD = @[dir_cd])" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}