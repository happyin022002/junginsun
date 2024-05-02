/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ConstraintMasterDBDAOSearchOfficeBKGInControlRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.09.23
*@LastModifier : 
*@LastVersion : 1.0
* 2015.09.23 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ConstraintMasterDBDAOSearchOfficeBKGInControlRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Control Office BKG get List
	  * ConstraintMasterDBDAOSearchOfficeBKGInControlRSQL.Query- 패키지 이동으로 신규 생성
	  * * 2015.09.24 이혜민 [CHM-201537552] BKG Control - SMP통제 조건 by lane 변경요청
	  * </pre>
	  */
	public ConstraintMasterDBDAOSearchOfficeBKGInControlRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.integration").append("\n"); 
		query.append("FileName : ConstraintMasterDBDAOSearchOfficeBKGInControlRSQL").append("\n"); 
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
		query.append("--Alloc Office 항목 조회 (BKG_CTRL_TP_CD = 'O')" ).append("\n"); 
		query.append("SELECT 	" ).append("\n"); 
		query.append("		BKG_CTRL_TP_CD," ).append("\n"); 
		query.append("		BKG_CTRL_DTL_CD," ).append("\n"); 
		query.append("		BKG_CTRL_RTO," ).append("\n"); 
		query.append("		NVL(BKG_CTRL_ACCT_FLG, 'N') AS BKG_CTRL_ACCT_FLG," ).append("\n"); 
		query.append("        NVL(BKG_CTRL_LANE_FLG, 'N') AS BKG_CTRL_LANE_FLG," ).append("\n"); 
		query.append("        RLANE_CD," ).append("\n"); 
		query.append("        DIR_CD" ).append("\n"); 
		query.append("FROM 	SPC_BKG_CTRL_OPT_DTL" ).append("\n"); 
		query.append("WHERE   TRD_CD     = @[trd_cd]" ).append("\n"); 
		query.append("	AND SUB_TRD_CD = @[sub_trd_cd]" ).append("\n"); 
		query.append("	AND RLANE_CD   = @[rlane_cd]" ).append("\n"); 
		query.append("	AND DIR_CD     = @[dir_cd]" ).append("\n"); 
		query.append("	AND BKG_CTRL_TP_CD = 'O'" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("--SMP Group 항목 조회 (BKG_CTRL_TP_CD = 'S')" ).append("\n"); 
		query.append("SELECT B.BKG_CTRL_TP_CD," ).append("\n"); 
		query.append("       B.BKG_CTRL_DTL_CD," ).append("\n"); 
		query.append("	   B.BKG_CTRL_RTO," ).append("\n"); 
		query.append("	   NVL(B.BKG_CTRL_ACCT_FLG, 'N') AS BKG_CTRL_ACCT_FLG," ).append("\n"); 
		query.append("       NVL(B.BKG_CTRL_LANE_FLG, 'N') AS BKG_CTRL_LANE_FLG," ).append("\n"); 
		query.append("       B.RLANE_CD," ).append("\n"); 
		query.append("       B.DIR_CD" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("        SELECT TRD_CD" ).append("\n"); 
		query.append("             , SUB_TRD_CD" ).append("\n"); 
		query.append("             , NVL((SELECT DISTINCT RLANE_CD " ).append("\n"); 
		query.append("                      FROM SPC_BKG_CTRL_OPT_DTL" ).append("\n"); 
		query.append("                     WHERE TRD_CD     = @[trd_cd]" ).append("\n"); 
		query.append("                       AND SUB_TRD_CD = @[sub_trd_cd]" ).append("\n"); 
		query.append("                       AND RLANE_CD   = @[rlane_cd]" ).append("\n"); 
		query.append("                       AND DIR_CD     = @[dir_cd]" ).append("\n"); 
		query.append("                       AND BKG_CTRL_LANE_FLG = 'Y'), 'XXXXX') RLANE_CD" ).append("\n"); 
		query.append("             , NVL((SELECT DISTINCT DIR_CD " ).append("\n"); 
		query.append("                      FROM SPC_BKG_CTRL_OPT_DTL" ).append("\n"); 
		query.append("                     WHERE TRD_CD     = @[trd_cd]" ).append("\n"); 
		query.append("                       AND SUB_TRD_CD = @[sub_trd_cd]" ).append("\n"); 
		query.append("                       AND RLANE_CD   = @[rlane_cd]" ).append("\n"); 
		query.append("                       AND DIR_CD     = @[dir_cd]" ).append("\n"); 
		query.append("                       AND BKG_CTRL_LANE_FLG = 'Y'), 'X') DIR_CD" ).append("\n"); 
		query.append("          FROM SPC_HD_HUL_MST" ).append("\n"); 
		query.append("         WHERE TRD_CD    = @[trd_cd]" ).append("\n"); 
		query.append("           AND RLANE_CD  = @[rlane_cd]" ).append("\n"); 
		query.append("           AND DIR_CD    = @[dir_cd]" ).append("\n"); 
		query.append("     ) A, SPC_BKG_CTRL_OPT_DTL B" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND B.BKG_CTRL_TP_CD = 'S'" ).append("\n"); 
		query.append("AND A.TRD_CD     = B.TRD_CD" ).append("\n"); 
		query.append("AND A.SUB_TRD_CD = B.SUB_TRD_CD" ).append("\n"); 
		query.append("AND A.RLANE_CD   = B.RLANE_CD" ).append("\n"); 
		query.append("AND A.DIR_CD     = B.DIR_CD" ).append("\n"); 

	}
}