/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : PlanningDBDAOUpdateQtaSetUpHeadOfficeUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.09.03
*@LastModifier : 최윤성
*@LastVersion : 1.0
* 2013.09.03 최윤성
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.planning.planning.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI Yun Sung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PlanningDBDAOUpdateQtaSetUpHeadOfficeUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Load 및 G.REV Portion 을 Update
	  * </pre>
	  */
	public PlanningDBDAOUpdateQtaSetUpHeadOfficeUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bse_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("qta_step_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lod_potn_rto",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rev_potn_rto",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bse_qtr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_vw_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bse_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rgn_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.sqm.planning.planning.integration").append("\n"); 
		query.append("FileName : PlanningDBDAOUpdateQtaSetUpHeadOfficeUSQL").append("\n"); 
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
		query.append("UPDATE SQM_QTA_POTN_MGMT" ).append("\n"); 
		query.append("   SET LOD_POTN_RTO = @[lod_potn_rto]" ).append("\n"); 
		query.append("      ,REV_POTN_RTO = @[rev_potn_rto]" ).append("\n"); 
		query.append("      ,UPD_USR_ID   = @[upd_usr_id]" ).append("\n"); 
		query.append("      ,UPD_DT       = SYSDATE" ).append("\n"); 
		query.append(" WHERE BSE_TP_CD    = @[bse_tp_cd]" ).append("\n"); 
		query.append("   AND BSE_YR       = @[bse_yr]" ).append("\n"); 
		query.append("   AND BSE_QTR_CD   = @[bse_qtr_cd]" ).append("\n"); 
		query.append("   AND OFC_VW_CD    = @[ofc_vw_cd]" ).append("\n"); 
		query.append("   AND QTA_STEP_CD  = @[qta_step_cd]" ).append("\n"); 
		query.append("   AND SUBSTR(QTA_VER_NO, 4, 6) = (SELECT CASE WHEN @[rgn_ofc_cd] IN (SELECT INTG_CD_VAL_CTNT FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD03255') THEN SUBSTR(QTA_VER_NO, 4, 6)" ).append("\n"); 
		query.append("                                                                                                                                                 ELSE @[rgn_ofc_cd]" ).append("\n"); 
		query.append("                                           END TEAM_CD" ).append("\n"); 
		query.append("                                     FROM DUAL)" ).append("\n"); 
		query.append("   AND RHQ_CD       = @[rhq_cd]" ).append("\n"); 
		query.append("   AND RGN_OFC_CD   = @[rhq_cd]" ).append("\n"); 
		query.append("   AND TRD_CD       = @[trd_cd]" ).append("\n"); 
		query.append("   AND RLANE_CD     = @[rlane_cd]" ).append("\n"); 
		query.append("   AND DIR_CD       = @[dir_cd]" ).append("\n"); 

	}
}