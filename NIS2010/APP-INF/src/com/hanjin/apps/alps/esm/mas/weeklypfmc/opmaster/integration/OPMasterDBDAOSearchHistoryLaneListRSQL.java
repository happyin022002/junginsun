/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : OPMasterDBDAOSearchHistoryLaneListRSQL.java
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

public class OPMasterDBDAOSearchHistoryLaneListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2016.03.03 Create Lane Table, Create Vessel Table history 자동 관리
	  * </pre>
	  */
	public OPMasterDBDAOSearchHistoryLaneListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_ioc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.weeklypfmc.opmaster.integration").append("\n"); 
		query.append("FileName : OPMasterDBDAOSearchHistoryLaneListRSQL").append("\n"); 
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
		query.append("#if (${date_check_flag} == 'Y')" ).append("\n"); 
		query.append("SELECT TRD_CD, RLANE_CD, DIR_CD, LANE_APLY_FOM_DT, LANE_APLY_TO_DT, NEXT_FROM" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("     DECODE(B.TRD_CD, NULL, 'I', 'R')          FLAG" ).append("\n"); 
		query.append("    ,NVL(B.LANE_SEQ,       1)                LANE_SEQ" ).append("\n"); 
		query.append("    ,NVL(B.TRD_CD, A.TRD_CD)                   TRD_CD" ).append("\n"); 
		query.append("    ,A.SUB_TRD_CD                              SUB_TRD_CD" ).append("\n"); 
		query.append("    ,A.SLAN_CD                                 SLAN_CD" ).append("\n"); 
		query.append("    ,NVL(B.RLANE_CD, A.RLANE_CD)               RLANE_CD" ).append("\n"); 
		query.append("    ,NVL(B.DIR_CD, A.DIR_CD)                   DIR_CD" ).append("\n"); 
		query.append("    ,NVL(B.IOC_CD, A.IOC_CD)                   IOC_CD" ).append("\n"); 
		query.append("    ,NVL(B.VSL_LANE_TP_CD, A.VSL_LANE_TP_CD)   VSL_LANE_TP_CD" ).append("\n"); 
		query.append("    ,B.OP_LANE_TP_CD" ).append("\n"); 
		query.append("    ,NVL(B.STUP_FLG, A.STUP_FLG)               STUP_FLG" ).append("\n"); 
		query.append("    ,B.VVD_CD                                  VVD_CD" ).append("\n"); 
		query.append("    ,NVL(B.LANE_APLY_FM_DT,'1900-01-01')       LANE_APLY_FOM_DT" ).append("\n"); 
		query.append("    ,NVL(B.LANE_APLY_TO_DT,'9999-12-31')       LANE_APLY_TO_DT" ).append("\n"); 
		query.append("    ,(SELECT C.LANE_APLY_FM_DT " ).append("\n"); 
		query.append("        FROM MAS_LANE_TP_HIS C" ).append("\n"); 
		query.append("        WHERE C.TRD_CD = A.TRD_CD" ).append("\n"); 
		query.append("            AND C.RLANE_CD = A.RLANE_CD" ).append("\n"); 
		query.append("            AND C.DIR_CD = A.DIR_CD " ).append("\n"); 
		query.append("            AND C.IOC_CD = A.IOC_CD" ).append("\n"); 
		query.append("            AND C.LANE_SEQ = B.LANE_SEQ + 1) AS NEXT_FROM" ).append("\n"); 
		query.append("	,B.UPD_USR_ID" ).append("\n"); 
		query.append("    ,TO_CHAR(B.UPD_DT, 'YYYY/MM/DD HH:MI')     UPD_DT" ).append("\n"); 
		query.append("  FROM MAS_LANE_RGST A FULL OUTER JOIN MAS_LANE_TP_HIS B" ).append("\n"); 
		query.append("    ON (" ).append("\n"); 
		query.append("       A.TRD_CD   = B.TRD_CD" ).append("\n"); 
		query.append("   AND A.RLANE_CD = B.RLANE_CD" ).append("\n"); 
		query.append("   AND A.DIR_CD   = B.DIR_CD" ).append("\n"); 
		query.append("   AND A.IOC_CD   = B.IOC_CD)" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND NVL(A.DELT_FLG,'N')= 'N'" ).append("\n"); 
		query.append("   AND A.TRD_CD   = @[f_trd_cd]" ).append("\n"); 
		query.append("   AND A.RLANE_CD = @[f_rlane_cd]" ).append("\n"); 
		query.append("   AND A.DIR_CD   = @[f_dir_cd]" ).append("\n"); 
		query.append("   AND A.IOC_CD   = @[f_ioc_cd]" ).append("\n"); 
		query.append("#if (${date_check_flag} == 'Y')" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE NEXT_FROM IS NOT NULL" ).append("\n"); 
		query.append("AND ( " ).append("\n"); 
		query.append("    SUBSTR(LANE_APLY_TO_DT, 1, 4) < SUBSTR(LANE_APLY_FOM_DT, 1, 4)" ).append("\n"); 
		query.append("        OR SUBSTR(LANE_APLY_TO_DT, 1, 4) > SUBSTR(NEXT_FROM, 1, 4)" ).append("\n"); 
		query.append("        OR (SUBSTR(LANE_APLY_TO_DT, 1, 4) = SUBSTR(LANE_APLY_FOM_DT, 1, 4) AND SUBSTR(LANE_APLY_TO_DT, 5, 2) < SUBSTR(LANE_APLY_FOM_DT, 5, 2))" ).append("\n"); 
		query.append("        OR (SUBSTR(LANE_APLY_TO_DT, 1, 4) = SUBSTR(NEXT_FROM, 1, 4) AND SUBSTR(LANE_APLY_TO_DT, 5, 2) > SUBSTR(NEXT_FROM, 5, 2))" ).append("\n"); 
		query.append("        OR (SUBSTR(LANE_APLY_TO_DT, 1, 4) = SUBSTR(LANE_APLY_FOM_DT, 1, 4) AND SUBSTR(LANE_APLY_TO_DT, 5, 2) = SUBSTR(LANE_APLY_FOM_DT, 5, 2) AND SUBSTR(LANE_APLY_TO_DT, 7, 2) < SUBSTR(LANE_APLY_FOM_DT, 7, 2))" ).append("\n"); 
		query.append("        OR (SUBSTR(LANE_APLY_TO_DT, 1, 4) = SUBSTR(NEXT_FROM, 1, 4) AND SUBSTR(LANE_APLY_TO_DT, 5, 2) = SUBSTR(NEXT_FROM, 5, 2) AND SUBSTR(LANE_APLY_TO_DT, 7, 2) > SUBSTR(NEXT_FROM, 7, 2))" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}