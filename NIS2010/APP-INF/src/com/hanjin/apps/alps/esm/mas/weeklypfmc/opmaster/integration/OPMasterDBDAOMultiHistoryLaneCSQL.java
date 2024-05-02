/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : OPMasterDBDAOMultiHistoryLaneCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.15
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.15 
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

public class OPMasterDBDAOMultiHistoryLaneCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MultiHistoryLane INSERT
	  * History -----------------------------------------------------------------
	  * 2010.06.17 이행지 Lane History Insert시 Seq를 기존 DB에서 MAX+1 하던 것을 화면상의 Seq로 대체해서 저장하도록 변경
	  * 2016.03.03 Create Lane Table, Create Vessel Table history 자동 관리
	  * </pre>
	  */
	public OPMasterDBDAOMultiHistoryLaneCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lane_aply_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_lane_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("op_lane_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stup_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ioc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lane_aply_fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lane_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.weeklypfmc.opmaster.integration").append("\n"); 
		query.append("FileName : OPMasterDBDAOMultiHistoryLaneCSQL").append("\n"); 
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
		query.append("#if (${auto_flg} == 'Y')" ).append("\n"); 
		query.append("MERGE INTO MAS_LANE_TP_HIS B" ).append("\n"); 
		query.append("USING ( SELECT TRD_CD, RLANE_CD, DIR_CD, LANE_APLY_FM_DT" ).append("\n"); 
		query.append("    FROM MAS_LANE_TP_HIS " ).append("\n"); 
		query.append("    WHERE TRD_CD = @[trd_cd]" ).append("\n"); 
		query.append("    AND RLANE_CD = @[rlane_cd]" ).append("\n"); 
		query.append("    AND DIR_CD = @[dir_cd]" ).append("\n"); 
		query.append("    AND LANE_SEQ = (SELECT MAX(LANE_SEQ) " ).append("\n"); 
		query.append("                    FROM MAS_LANE_TP_HIS " ).append("\n"); 
		query.append("                    WHERE TRD_CD = @[trd_cd]" ).append("\n"); 
		query.append("                    AND RLANE_CD = @[rlane_cd]" ).append("\n"); 
		query.append("                    AND DIR_CD = @[dir_cd] )" ).append("\n"); 
		query.append("    ) A" ).append("\n"); 
		query.append("ON ( A.TRD_CD = B.TRD_CD" ).append("\n"); 
		query.append("AND A.RLANE_CD = B.RLANE_CD" ).append("\n"); 
		query.append("AND A.DIR_CD = B.DIR_CD" ).append("\n"); 
		query.append("AND B.LANE_SEQ = (SELECT MAX(LANE_SEQ) " ).append("\n"); 
		query.append("                    FROM MAS_LANE_TP_HIS " ).append("\n"); 
		query.append("                    WHERE TRD_CD = @[trd_cd]" ).append("\n"); 
		query.append("                    AND RLANE_CD = @[rlane_cd]" ).append("\n"); 
		query.append("                    AND DIR_CD = @[dir_cd] )" ).append("\n"); 
		query.append("AND A.TRD_CD = @[trd_cd]" ).append("\n"); 
		query.append("AND A.RLANE_CD = @[rlane_cd]" ).append("\n"); 
		query.append("AND A.DIR_CD = @[dir_cd]" ).append("\n"); 
		query.append("AND A.LANE_APLY_FM_DT = TO_CHAR(SYSDATE, 'YYYYMMDD'))" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("UPDATE SET VSL_LANE_TP_CD = @[vsl_lane_tp_cd]" ).append("\n"); 
		query.append(", STUP_FLG = DECODE(@[stup_flg], '0', 'N', '1', 'Y', @[stup_flg])" ).append("\n"); 
		query.append(", UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append(", UPD_DT = SYSDATE" ).append("\n"); 
		query.append(", OP_LANE_TP_CD = @[op_lane_tp_cd]" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("INSERT (" ).append("\n"); 
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
		query.append("     ,OP_LANE_TP_CD" ).append("\n"); 
		query.append(")VALUES(" ).append("\n"); 
		query.append("      @[trd_cd]" ).append("\n"); 
		query.append("     ,@[rlane_cd]" ).append("\n"); 
		query.append("     ,@[dir_cd]" ).append("\n"); 
		query.append("     ,@[ioc_cd]" ).append("\n"); 
		query.append("     ,(SELECT NVL(MAX(LANE_SEQ)+1, 1) FROM MAS_LANE_TP_HIS WHERE TRD_CD = @[trd_cd] AND RLANE_CD = @[rlane_cd] AND DIR_CD = @[dir_cd] AND IOC_CD = @[ioc_cd])" ).append("\n"); 
		query.append("     ,@[vsl_lane_tp_cd]" ).append("\n"); 
		query.append("     ,DECODE(@[stup_flg], '0', 'N', '1', 'Y', @[stup_flg])" ).append("\n"); 
		query.append("     ,NULL" ).append("\n"); 
		query.append("     ,TO_CHAR(SYSDATE, 'YYYYMMDD')" ).append("\n"); 
		query.append("     ,'99991231'" ).append("\n"); 
		query.append("     ,@[upd_usr_id]" ).append("\n"); 
		query.append("     ,SYSDATE" ).append("\n"); 
		query.append("     ,@[upd_usr_id]" ).append("\n"); 
		query.append("     ,SYSDATE" ).append("\n"); 
		query.append("     ,@[op_lane_tp_cd]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#else" ).append("\n"); 
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
		query.append("     ,OP_LANE_TP_CD" ).append("\n"); 
		query.append(")VALUES(" ).append("\n"); 
		query.append("      @[trd_cd]" ).append("\n"); 
		query.append("     ,@[rlane_cd]" ).append("\n"); 
		query.append("     ,@[dir_cd]" ).append("\n"); 
		query.append("     ,@[ioc_cd]" ).append("\n"); 
		query.append("     ,@[lane_seq]" ).append("\n"); 
		query.append("     ,@[vsl_lane_tp_cd]" ).append("\n"); 
		query.append("     ,DECODE(@[stup_flg], '0', 'N', '1', 'Y', @[stup_flg])" ).append("\n"); 
		query.append("     ,@[vvd_cd]" ).append("\n"); 
		query.append("     ,@[lane_aply_fm_dt]" ).append("\n"); 
		query.append("     ,@[lane_aply_to_dt]" ).append("\n"); 
		query.append("     ,@[cre_usr_id]" ).append("\n"); 
		query.append("     ,SYSDATE" ).append("\n"); 
		query.append("     ,@[upd_usr_id]" ).append("\n"); 
		query.append("     ,SYSDATE" ).append("\n"); 
		query.append("     ,@[op_lane_tp_cd]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}