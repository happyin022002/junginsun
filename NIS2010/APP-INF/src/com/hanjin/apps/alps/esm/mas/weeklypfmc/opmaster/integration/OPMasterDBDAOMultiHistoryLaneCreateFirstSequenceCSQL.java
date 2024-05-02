/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : OPMasterDBDAOMultiHistoryLaneCreateFirstSequenceCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.25
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.25 
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

public class OPMasterDBDAOMultiHistoryLaneCreateFirstSequenceCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2016.03.03 Create Lane Table, Create Vessel Table history 자동 관리
	  * </pre>
	  */
	public OPMasterDBDAOMultiHistoryLaneCreateFirstSequenceCSQL(){
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
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ioc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.weeklypfmc.opmaster.integration").append("\n"); 
		query.append("FileName : OPMasterDBDAOMultiHistoryLaneCreateFirstSequenceCSQL").append("\n"); 
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
		query.append("INSERT INTO MAS_LANE_TP_HIS (" ).append("\n"); 
		query.append("      TRD_CD" ).append("\n"); 
		query.append("     ,RLANE_CD" ).append("\n"); 
		query.append("     ,DIR_CD" ).append("\n"); 
		query.append("     ,IOC_CD" ).append("\n"); 
		query.append("     ,LANE_SEQ" ).append("\n"); 
		query.append("     ,VSL_LANE_TP_CD" ).append("\n"); 
		query.append("     ,STUP_FLG" ).append("\n"); 
		query.append("     ,VVD_CD" ).append("\n"); 
		query.append("     ,LANE_APLY_FM_DT" ).append("\n"); 
		query.append("     ,LANE_APLY_TO_DT" ).append("\n"); 
		query.append("     ,CRE_USR_ID" ).append("\n"); 
		query.append("     ,CRE_DT" ).append("\n"); 
		query.append("     ,UPD_USR_ID" ).append("\n"); 
		query.append("     ,UPD_DT" ).append("\n"); 
		query.append(")VALUES(" ).append("\n"); 
		query.append("      @[trd_cd]" ).append("\n"); 
		query.append("     ,@[rlane_cd]" ).append("\n"); 
		query.append("     ,@[dir_cd]" ).append("\n"); 
		query.append("     ,@[ioc_cd]" ).append("\n"); 
		query.append("     ,'1'" ).append("\n"); 
		query.append("     ,(SELECT VSL_LANE_TP_CD FROM MAS_LANE_RGST WHERE TRD_CD = @[trd_cd] AND RLANE_CD = @[rlane_cd] AND DIR_CD = @[dir_cd] AND ROWNUM < 2)" ).append("\n"); 
		query.append("     ,(SELECT STUP_FLG FROM MAS_LANE_RGST WHERE TRD_CD = @[trd_cd] AND RLANE_CD = @[rlane_cd] AND DIR_CD = @[dir_cd] AND ROWNUM < 2)" ).append("\n"); 
		query.append("     ,null" ).append("\n"); 
		query.append("     ,'19000101'" ).append("\n"); 
		query.append("     ,TO_CHAR(SYSDATE-1, 'YYYYMMDD')" ).append("\n"); 
		query.append("     ,@[upd_usr_id]" ).append("\n"); 
		query.append("     ,SYSDATE" ).append("\n"); 
		query.append("     ,@[upd_usr_id]" ).append("\n"); 
		query.append("     ,SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}