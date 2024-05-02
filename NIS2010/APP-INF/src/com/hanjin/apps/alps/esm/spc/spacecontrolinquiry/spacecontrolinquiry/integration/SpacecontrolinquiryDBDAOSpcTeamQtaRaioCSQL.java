/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SpacecontrolinquiryDBDAOSpcTeamQtaRaioCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.23
*@LastModifier : Arie
*@LastVersion : 1.0
* 2015.08.23 Arie
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Arie
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpacecontrolinquiryDBDAOSpcTeamQtaRaioCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 한국지점 팀별 QTA Ratio 관리
	  * </pre>
	  */
	public SpacecontrolinquiryDBDAOSpcTeamQtaRaioCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sls_rep_ofc_team_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("qta_aply_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sub_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("team_qta_rto",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.integration").append("\n"); 
		query.append("FileName : SpacecontrolinquiryDBDAOSpcTeamQtaRaioCSQL").append("\n"); 
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
		query.append("INSERT INTO SPC_TEAM_QTA_RTO" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append(" TRD_CD, " ).append("\n"); 
		query.append(" SUB_TRD_CD, " ).append("\n"); 
		query.append(" RLANE_CD, " ).append("\n"); 
		query.append(" SLS_REP_OFC_TEAM_CD, " ).append("\n"); 
		query.append(" QTA_APLY_CD, " ).append("\n"); 
		query.append(" BSE_YR, " ).append("\n"); 
		query.append(" BSE_QTR_CD, " ).append("\n"); 
		query.append(" VSL_CD, " ).append("\n"); 
		query.append(" SKD_VOY_NO, " ).append("\n"); 
		query.append(" SKD_DIR_CD, " ).append("\n"); 
		query.append(" SLS_RGN_OFC_CD, " ).append("\n"); 
		query.append(" SLS_OFC_CD, " ).append("\n"); 
		query.append(" TEAM_QTA_RTO, " ).append("\n"); 
		query.append(" CRE_USR_ID, " ).append("\n"); 
		query.append(" CRE_DT, " ).append("\n"); 
		query.append(" UPD_USR_ID, " ).append("\n"); 
		query.append(" UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT A.TRD_CD, " ).append("\n"); 
		query.append("       A.SUB_TRD_CD, " ).append("\n"); 
		query.append("       A.RLANE_CD, " ).append("\n"); 
		query.append("       A.SLS_REP_OFC_TEAM_CD, " ).append("\n"); 
		query.append("       A.QTA_APLY_CD, " ).append("\n"); 
		query.append("       A.BSE_YR, " ).append("\n"); 
		query.append("       A.BSE_QTR_CD, " ).append("\n"); 
		query.append("       A.VSL_CD, " ).append("\n"); 
		query.append("       A.SKD_VOY_NO, " ).append("\n"); 
		query.append("       A.SKD_DIR_CD, " ).append("\n"); 
		query.append("       SR.SLS_RGN_OFC_CD, " ).append("\n"); 
		query.append("       SR.SLS_OFC_CD, " ).append("\n"); 
		query.append("       A.TEAM_QTA_RTO, " ).append("\n"); 
		query.append("       A.USR_ID, " ).append("\n"); 
		query.append("       A.CRE_DT,  " ).append("\n"); 
		query.append("       A.USR_ID, " ).append("\n"); 
		query.append("       A.CRE_DT" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT @[trd_cd] AS TRD_CD," ).append("\n"); 
		query.append("               @[sub_trd_cd] AS SUB_TRD_CD," ).append("\n"); 
		query.append("               @[rlane_cd] AS RLANE_CD," ).append("\n"); 
		query.append("               @[sls_rep_ofc_team_cd] AS SLS_REP_OFC_TEAM_CD," ).append("\n"); 
		query.append("               @[qta_aply_cd] AS QTA_APLY_CD," ).append("\n"); 
		query.append("               NVL(@[bse_yr], ' ') AS BSE_YR," ).append("\n"); 
		query.append("               NVL(@[bse_qtr_cd], ' ') AS BSE_QTR_CD," ).append("\n"); 
		query.append("               NVL(@[vsl_cd], ' ') AS VSL_CD," ).append("\n"); 
		query.append("               NVL(@[skd_voy_no], ' ') AS SKD_VOY_NO," ).append("\n"); 
		query.append("               NVL(@[skd_dir_cd], ' ') AS SKD_DIR_CD," ).append("\n"); 
		query.append("               @[team_qta_rto] AS TEAM_QTA_RTO," ).append("\n"); 
		query.append("               @[cre_usr_id] AS USR_ID," ).append("\n"); 
		query.append("               SYSDATE AS CRE_DT" ).append("\n"); 
		query.append("          FROM DUAL" ).append("\n"); 
		query.append("       ) A, " ).append("\n"); 
		query.append("       (" ).append("\n"); 
		query.append("        SELECT DISTINCT " ).append("\n"); 
		query.append("               SLS_REP_OFC_TEAM_CD, " ).append("\n"); 
		query.append("               SLS_OFC_CD, " ).append("\n"); 
		query.append("               SLS_RGN_OFC_CD " ).append("\n"); 
		query.append("          FROM SPC_SLS_REP_TEAM_IF" ).append("\n"); 
		query.append("       ) SR" ).append("\n"); 
		query.append(" WHERE  DECODE(A.SLS_REP_OFC_TEAM_CD, 'OTHER', 'SELSCA', A.SLS_REP_OFC_TEAM_CD) in DECODE(SR.SLS_REP_OFC_TEAM_CD, NULL, SR.SLS_OFC_CD, SR.SLS_REP_OFC_TEAM_CD)" ).append("\n"); 

	}
}