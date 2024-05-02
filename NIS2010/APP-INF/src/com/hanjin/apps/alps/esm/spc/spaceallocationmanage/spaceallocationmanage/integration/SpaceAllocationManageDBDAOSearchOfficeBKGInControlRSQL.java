/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SpaceAllocationManageDBDAOSearchOfficeBKGInControlRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.11
*@LastModifier : Kim sung wook
*@LastVersion : 1.0
* 2015.06.11 Kim sung wook
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpaceAllocationManageDBDAOSearchOfficeBKGInControlRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Control Office BKG get List
	  * </pre>
	  */
	public SpaceAllocationManageDBDAOSearchOfficeBKGInControlRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.integration").append("\n"); 
		query.append("FileName : SpaceAllocationManageDBDAOSearchOfficeBKGInControlRSQL").append("\n"); 
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
		query.append("SELECT 	" ).append("\n"); 
		query.append("		BKG_CTRL_TP_CD," ).append("\n"); 
		query.append("		BKG_CTRL_DTL_CD," ).append("\n"); 
		query.append("		BKG_CTRL_RTO," ).append("\n"); 
		query.append("		NVL(BKG_CTRL_ACCT_FLG, 'N') AS BKG_CTRL_ACCT_FLG," ).append("\n"); 
		query.append("        RLANE_CD," ).append("\n"); 
		query.append("        DIR_CD" ).append("\n"); 
		query.append("FROM 	SPC_BKG_CTRL_OPT_DTL" ).append("\n"); 
		query.append("WHERE   TRD_CD = @[trd_cd]" ).append("\n"); 
		query.append("	AND SUB_TRD_CD = @[sub_trd_cd]" ).append("\n"); 
		query.append("	AND RLANE_CD = @[rlane_cd]" ).append("\n"); 
		query.append("	AND DIR_CD = @[dir_cd]" ).append("\n"); 
		query.append("	AND BKG_CTRL_TP_CD <> 'S' --no SMP" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT A.BKG_CTRL_TP_CD," ).append("\n"); 
		query.append("       A.BKG_CTRL_DTL_CD," ).append("\n"); 
		query.append("	   B.BKG_CTRL_RTO," ).append("\n"); 
		query.append("	   NVL(B.BKG_CTRL_ACCT_FLG, 'N') AS BKG_CTRL_ACCT_FLG," ).append("\n"); 
		query.append("       A.RLANE_CD," ).append("\n"); 
		query.append("       A.DIR_CD" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("        SELECT " ).append("\n"); 
		query.append("          B2.TRD_CD" ).append("\n"); 
		query.append("                  ,B2.SUB_TRD_CD" ).append("\n"); 
		query.append("                  ,B1.RLANE_CD" ).append("\n"); 
		query.append("                  ,B1.DIR_CD" ).append("\n"); 
		query.append("                  ,B1.BKG_CTRL_TP_CD" ).append("\n"); 
		query.append("                  ,B1.BKG_CTRL_DTL_CD" ).append("\n"); 
		query.append("        FROM (" ).append("\n"); 
		query.append("        -- BKG CONTROL OPTION DETAIL의 등록된 노선의 HH/BH 정보" ).append("\n"); 
		query.append("            SELECT DISTINCT DECODE(A1.DIR_CD, NVL(A2.DIR_CD,' '), 'HH', 'BH') AA" ).append("\n"); 
		query.append("                ,A1.TRD_CD" ).append("\n"); 
		query.append("                ,A1.SUB_TRD_CD" ).append("\n"); 
		query.append("                ,A1.RLANE_CD" ).append("\n"); 
		query.append("                ,A1.BKG_CTRL_TP_CD" ).append("\n"); 
		query.append("                ,A1.BKG_CTRL_DTL_CD" ).append("\n"); 
		query.append("                ,A1.DIR_CD" ).append("\n"); 
		query.append("             FROM SPC_BKG_CTRL_OPT_DTL A1" ).append("\n"); 
		query.append("                 ,SPC_HD_HUL_MST A2" ).append("\n"); 
		query.append("            WHERE A1.BKG_CTRL_TP_CD = 'S'" ).append("\n"); 
		query.append("               AND A1.TRD_CD         = A2.TRD_CD" ).append("\n"); 
		query.append("               AND A1.RLANE_CD       = A2.RLANE_CD" ).append("\n"); 
		query.append("               AND A1.DIR_CD         = A2.DIR_CD" ).append("\n"); 
		query.append("               AND A1.TRD_CD         = @[trd_cd]" ).append("\n"); 
		query.append("               AND A1.SUB_TRD_CD     = @[sub_trd_cd]" ).append("\n"); 
		query.append("        ) B1" ).append("\n"); 
		query.append("      ,(" ).append("\n"); 
		query.append("        -- 선택된 노선의 HH/BH 정보 조회" ).append("\n"); 
		query.append("        SELECT TRD_CD, SUB_TRD_CD, RLANE_CD, DIR_CD, 'HH' AA" ).append("\n"); 
		query.append("          FROM SPC_HD_HUL_MST" ).append("\n"); 
		query.append("         WHERE TRD_CD    = @[trd_cd]" ).append("\n"); 
		query.append("           AND RLANE_CD  = @[rlane_cd]" ).append("\n"); 
		query.append("           AND DIR_CD    = @[dir_cd]" ).append("\n"); 
		query.append("       ) B2" ).append("\n"); 
		query.append("	 WHERE 1=1" ).append("\n"); 
		query.append("	   AND B1.TRD_CD     = B2.TRD_CD" ).append("\n"); 
		query.append("	   AND B1.SUB_TRD_CD = B2.SUB_TRD_CD" ).append("\n"); 
		query.append("	   AND B1.AA         = B2.AA" ).append("\n"); 
		query.append(")A, SPC_BKG_CTRL_OPT_DTL B" ).append("\n"); 
		query.append("WHERE A.TRD_CD = B.TRD_CD" ).append("\n"); 
		query.append("   AND A.SUB_TRD_CD = B.SUB_TRD_CD" ).append("\n"); 
		query.append("--   AND A.RLANE_CD = B.RLANE_CD" ).append("\n"); 
		query.append("--   AND A.DIR_CD = B.DIR_CD" ).append("\n"); 
		query.append("   AND A.BKG_CTRL_TP_CD = B.BKG_CTRL_TP_CD" ).append("\n"); 
		query.append("   AND A.BKG_CTRL_DTL_CD = B.BKG_CTRL_DTL_CD" ).append("\n"); 
		query.append("--SELECT 	BKG_CTRL_TP_CD," ).append("\n"); 
		query.append("--		BKG_CTRL_DTL_CD," ).append("\n"); 
		query.append("--		BKG_CTRL_RTO," ).append("\n"); 
		query.append("--		NVL(BKG_CTRL_ACCT_FLG, 'N') AS BKG_CTRL_ACCT_FLG" ).append("\n"); 
		query.append("--FROM 	SPC_BKG_CTRL_OPT_DTL" ).append("\n"); 
		query.append("--WHERE   TRD_CD = @ [trd_cd]" ).append("\n"); 
		query.append("--	AND SUB_TRD_CD = @ [sub_trd_cd]" ).append("\n"); 
		query.append("--    AND DIR_CD = @ [dir_cd]" ).append("\n"); 
		query.append("--	AND BKG_CTRL_TP_CD = 'S' --SMP" ).append("\n"); 

	}
}