/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : OPMasterDBDAOMultiHistoryLaneCSQL.java
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
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("dir_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lane_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lane_aply_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.coa.weeklypfmc.opmaster.integration").append("\n"); 
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
		query.append("INSERT INTO COA_LANE_TP_HIS (" ).append("\n"); 
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
		query.append("     ,@[lane_seq]" ).append("\n"); 
		query.append("     ,@[vsl_lane_tp_cd]" ).append("\n"); 
		query.append("     ,DECODE(@[stup_flg], '1', 'Y', 'N')" ).append("\n"); 
		query.append("     ,@[vvd_cd]" ).append("\n"); 
		query.append("     ,@[lane_aply_fm_dt]" ).append("\n"); 
		query.append("     ,@[lane_aply_to_dt]" ).append("\n"); 
		query.append("     ,@[cre_usr_id]" ).append("\n"); 
		query.append("     ,SYSDATE" ).append("\n"); 
		query.append("     ,@[upd_usr_id]" ).append("\n"); 
		query.append("     ,SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}