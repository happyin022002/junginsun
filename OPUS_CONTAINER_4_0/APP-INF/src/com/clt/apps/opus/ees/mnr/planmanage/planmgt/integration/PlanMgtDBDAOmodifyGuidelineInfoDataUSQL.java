/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PlanMgtDBDAOmodifyGuidelineInfoDataUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.16
*@LastModifier : 이주현
*@LastVersion : 1.0
* 2009.06.16 이주현
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.planmanage.planmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author LEE JU HYUN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PlanMgtDBDAOmodifyGuidelineInfoDataUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MNR Guideline 정보를 Update한다.
	  * </pre>
	  */
	public PlanMgtDBDAOmodifyGuidelineInfoDataUSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_gline_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("file_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_grp_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("upd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_gline_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_gline_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("file_dtl_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("UPDATE MNR_GUIDELINE A" ).append("\n"); 
		query.append("SET A.MNR_GLINE_SEQ = @[mnr_gline_seq]" ).append("\n"); 
		query.append(",A.MNR_GRP_TP_CD = @[mnr_grp_tp_cd]" ).append("\n"); 
		query.append(",A.MNR_GLINE_NM = @[mnr_gline_nm]" ).append("\n"); 
		query.append(",A.MNR_GLINE_RMK = @[mnr_gline_rmk]" ).append("\n"); 
		query.append(",A.FILE_SEQ = NVL(@[file_seq], 0)" ).append("\n"); 
		query.append(",A.FILE_DTL_SEQ = NVL(@[file_dtl_seq], 1)" ).append("\n"); 
		query.append(",A.UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append(",A.UPD_DT = SYSDATE" ).append("\n"); 
		query.append("WHERE A.MNR_GLINE_SEQ = @[mnr_gline_seq]" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mnr.planmanage.planmgt.integration").append("\n"); 
		query.append("FileName : PlanMgtDBDAOmodifyGuidelineInfoDataUSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}