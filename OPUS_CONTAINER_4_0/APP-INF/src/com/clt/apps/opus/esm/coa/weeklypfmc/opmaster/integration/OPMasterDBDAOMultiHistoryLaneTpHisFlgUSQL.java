/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : OPMasterDBDAOMultiHistoryLaneTpHisFlgUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.22
*@LastModifier : 
*@LastVersion : 1.0
* 2015.05.22 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.weeklypfmc.opmaster.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OPMasterDBDAOMultiHistoryLaneTpHisFlgUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * COA_LANE_RGST - LANE_TP_HIS_FLG update
	  * </pre>
	  */
	public OPMasterDBDAOMultiHistoryLaneTpHisFlgUSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.coa.weeklypfmc.opmaster.integration").append("\n"); 
		query.append("FileName : OPMasterDBDAOMultiHistoryLaneTpHisFlgUSQL").append("\n"); 
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
		query.append("MERGE INTO COA_LANE_RGST A" ).append("\n"); 
		query.append("USING(" ).append("\n"); 
		query.append("      SELECT TRD_CD, RLANE_CD, DIR_CD, IOC_CD, LANE_SEQ, VSL_LANE_TP_CD, STUP_FLG, " ).append("\n"); 
		query.append("             DECODE(COUNT(*) OVER (), 0, 'N', 'Y') AS LANE_TP_HIS_FLG" ).append("\n"); 
		query.append("        FROM COA_LANE_TP_HIS" ).append("\n"); 
		query.append("       WHERE TRD_CD   = @[trd_cd]" ).append("\n"); 
		query.append("         AND RLANE_CD = @[rlane_cd]" ).append("\n"); 
		query.append("         AND DIR_CD   = @[dir_cd]" ).append("\n"); 
		query.append("         AND IOC_CD   = @[ioc_cd]" ).append("\n"); 
		query.append("         AND LANE_APLY_FM_DT||LANE_SEQ = (SELECT MAX(LANE_APLY_FM_DT||LANE_SEQ) 	--SEQ가 최근이 아닐수도 있으나...기준상.." ).append("\n"); 
		query.append("                                            FROM COA_LANE_TP_HIS" ).append("\n"); 
		query.append("                                           WHERE TRD_CD   = @[trd_cd]" ).append("\n"); 
		query.append("                                             AND RLANE_CD = @[rlane_cd]" ).append("\n"); 
		query.append("                                             AND DIR_CD   = @[dir_cd]" ).append("\n"); 
		query.append("                                             AND IOC_CD   = @[ioc_cd])" ).append("\n"); 
		query.append("      ) B" ).append("\n"); 
		query.append("ON (  A.TRD_CD = B.TRD_CD" ).append("\n"); 
		query.append("  AND A.RLANE_CD = B.RLANE_CD" ).append("\n"); 
		query.append("  AND A.DIR_CD = B.DIR_CD" ).append("\n"); 
		query.append("  AND A.IOC_CD = B.IOC_CD)" ).append("\n"); 
		query.append(" WHEN MATCHED THEN UPDATE " ).append("\n"); 
		query.append("  SET VSL_LANE_TP_CD  = B.VSL_LANE_TP_CD" ).append("\n"); 
		query.append("     ,STUP_FLG        = B.STUP_FLG" ).append("\n"); 
		query.append("     ,LANE_TP_HIS_FLG = B.LANE_TP_HIS_FLG" ).append("\n"); 
		query.append("     ,UPD_USR_ID      = @[upd_usr_id]" ).append("\n"); 
		query.append("     ,UPD_DT          = SYSDATE" ).append("\n"); 

	}
}