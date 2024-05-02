/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : SpaceAllocationManageDBDAOSearchSpaceAllocation0053ManageListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.24
*@LastModifier : 최윤성
*@LastVersion : 1.0
* 2011.02.24 최윤성
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.spc.spaceallocationmanage.spaceallocationmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI Yun Sung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpaceAllocationManageDBDAOSearchSpaceAllocation0053ManageListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public SpaceAllocationManageDBDAOSearchSpaceAllocation0053ManageListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("subtrade",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trade",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("week1",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("week2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("year2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("year1",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bound",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lane",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.spc.spaceallocationmanage.spaceallocationmanage.integration").append("\n"); 
		query.append("FileName : SpaceAllocationManageDBDAOSearchSpaceAllocation0053ManageListVORSQL").append("\n"); 
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
		query.append("WITH COM_VVD AS (" ).append("\n"); 
		query.append("    SELECT DISTINCT" ).append("\n"); 
		query.append("           CA.REP_TRD_CD    ," ).append("\n"); 
		query.append("           CA.REP_SUB_TRD_CD," ).append("\n"); 
		query.append("           CA.RLANE_CD      ," ).append("\n"); 
		query.append("           CA.DIR_CD        ," ).append("\n"); 
		query.append("           CA.COST_YR       ," ).append("\n"); 
		query.append("           CA.COST_WK       ," ).append("\n"); 
		query.append("           CA.VSL_CD        ," ).append("\n"); 
		query.append("           CA.SKD_VOY_NO    ," ).append("\n"); 
		query.append("           CA.DIR_CD AS SKD_DIR_CD," ).append("\n"); 
		query.append("           CO.CTRL_SPC_FLG    ," ).append("\n"); 
		query.append("           CO.CTRL_40FT_HC_FLG," ).append("\n"); 
		query.append("           CO.CTRL_45FT_HC_FLG," ).append("\n"); 
		query.append("           CO.CTRL_53FT_FLG   ," ).append("\n"); 
		query.append("           CO.CTRL_RF_FLG     ," ).append("\n"); 
		query.append("           DECODE(CO.CTRL_LVL_CD, 'D', 'POD', 'L', 'POL', 'O', 'OFC', 'OFC*') AS CTRL_PORT_FLG," ).append("\n"); 
		query.append("           CO.CTRL_WGT_FLG," ).append("\n"); 
		query.append("           CA.VVD         ," ).append("\n"); 
		query.append("           CA.WEEK        " ).append("\n"); 
		query.append("      FROM (" ).append("\n"); 
		query.append("              SELECT SAQ_GET_REP_TRD_FNC(C.RLANE_CD)    AS REP_TRD_CD    ," ).append("\n"); 
		query.append("                     SAQ_GET_REP_SUB_TRD_FNC(C.RLANE_CD)AS REP_SUB_TRD_CD," ).append("\n"); 
		query.append("                     C.RLANE_CD," ).append("\n"); 
		query.append("                     C.DIR_CD  ," ).append("\n"); 
		query.append("                     SUBSTR(C.SLS_YRMON, 1, 4) AS COST_YR," ).append("\n"); 
		query.append("                     C.COST_WK   ," ).append("\n"); 
		query.append("                     C.VSL_CD    ," ).append("\n"); 
		query.append("                     C.SKD_VOY_NO," ).append("\n"); 
		query.append("                     C.VSL_CD||C.SKD_VOY_NO||C.DIR_CD     AS VVD ," ).append("\n"); 
		query.append("                     SUBSTR(C.SLS_YRMON, 1, 4)||C.COST_WK AS WEEK" ).append("\n"); 
		query.append("                FROM COA_MON_VVD C" ).append("\n"); 
		query.append("               WHERE SUBSTR(C.SLS_YRMON, 1, 4) || C.COST_WK BETWEEN @[year1]||@[week1] AND @[year2]||@[week2]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${trade} != '')" ).append("\n"); 
		query.append("                 AND SAQ_GET_REP_TRD_FNC(C.RLANE_CD) = @[trade]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${subtrade} != '')" ).append("\n"); 
		query.append("                 AND SAQ_GET_REP_SUB_TRD_FNC(C.RLANE_CD) = @[subtrade]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${lane} != '')" ).append("\n"); 
		query.append("                 AND C.RLANE_CD= @[lane]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${bound} != '')" ).append("\n"); 
		query.append("                 AND C.DIR_CD = @[bound]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${vsl_cd} != '' && ${skd_voy_no} != '' && ${skd_dir_cd} != '')" ).append("\n"); 
		query.append("                 AND C.VSL_CD     = @[vsl_cd]" ).append("\n"); 
		query.append("                 AND C.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("                 AND C.DIR_CD     = @[skd_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                 AND C.TRD_CD     = SAQ_GET_REP_TRD_FNC(C.RLANE_CD)" ).append("\n"); 
		query.append("                 AND C.SUB_TRD_CD = SAQ_GET_REP_SUB_TRD_FNC(C.RLANE_CD)" ).append("\n"); 
		query.append("                 AND C.DELT_FLG   = 'N'" ).append("\n"); 
		query.append("           ) CA," ).append("\n"); 
		query.append("           SPC_ALOC_CTRL_OPT CO" ).append("\n"); 
		query.append("     WHERE CA.RLANE_CD   = CO.RLANE_CD  (+)" ).append("\n"); 
		query.append("       AND CA.DIR_CD     = CO.DIR_CD    (+)" ).append("\n"); 
		query.append("       AND CA.VSL_CD     = CO.VSL_CD    (+)" ).append("\n"); 
		query.append("       AND CA.SKD_VOY_NO = CO.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("       AND CA.DIR_CD     = CO.SKD_DIR_CD(+)" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("  SELECT DISTINCT" ).append("\n"); 
		query.append("         M.REP_TRD_CD      ," ).append("\n"); 
		query.append("         M.REP_SUB_TRD_CD  ," ).append("\n"); 
		query.append("         M.RLANE_CD        ," ).append("\n"); 
		query.append("         M.DIR_CD          ," ).append("\n"); 
		query.append("         M.WEEK WEEK       ," ).append("\n"); 
		query.append("         M.VVD VVD         ," ).append("\n"); 
		query.append("         M.CTRL_SPC_FLG    ," ).append("\n"); 
		query.append("         M.CTRL_40FT_HC_FLg," ).append("\n"); 
		query.append("         M.CTRL_45FT_HC_FLg," ).append("\n"); 
		query.append("         M.CTRL_53FT_FLG   ," ).append("\n"); 
		query.append("         M.CTRL_RF_FLG     ," ).append("\n"); 
		query.append("         M.CTRL_PORT_FLG   ," ).append("\n"); 
		query.append("         M.CTRL_WGT_FLG    ," ).append("\n"); 
		query.append("         FC.FOR_VOLUM      ," ).append("\n"); 
		query.append("         FC.FOR_HC         ," ).append("\n"); 
		query.append("         FC.FOR_HC45       ," ).append("\n"); 
		query.append("         FC.FOR_53FT	   ," ).append("\n"); 
		query.append("         FC.FOR_REEFER     ," ).append("\n"); 
		query.append("         FC.FOR_WEIGHT" ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("            -- Fcast " ).append("\n"); 
		query.append("            SELECT Z.REP_TRD_CD    ," ).append("\n"); 
		query.append("                   Z.REP_SUB_TRD_CD," ).append("\n"); 
		query.append("                   Z.RLANE_CD      ," ).append("\n"); 
		query.append("                   Z.DIR_CD        ," ).append("\n"); 
		query.append("                   Z.COST_YR       ," ).append("\n"); 
		query.append("                   Z.COST_WK       ," ).append("\n"); 
		query.append("                   Z.VSL_CD        ," ).append("\n"); 
		query.append("                   Z.SKD_VOY_NO    ," ).append("\n"); 
		query.append("                   Z.SKD_DIR_CD    ," ).append("\n"); 
		query.append("                   ROUND(SUM(Z.FOR_VOLUM))  AS FOR_VOLUM ," ).append("\n"); 
		query.append("                   ROUND(SUM(Z.FOR_HC))     AS FOR_HC    ," ).append("\n"); 
		query.append("                   ROUND(SUM(Z.FOR_HC45))   AS FOR_HC45  ," ).append("\n"); 
		query.append("                   ROUND(SUM(Z.FOR_53FT))   AS FOR_53FT ," ).append("\n"); 
		query.append("                   ROUND(SUM(Z.FOR_REEFER)) AS FOR_REEFER," ).append("\n"); 
		query.append("                   ROUND(SUM(Z.FOR_WEIGHT)) AS FOR_WEIGHT" ).append("\n"); 
		query.append("              FROM (" ).append("\n"); 
		query.append("                      SELECT M.REP_TRD_CD    ," ).append("\n"); 
		query.append("                             M.REP_SUB_TRD_CD," ).append("\n"); 
		query.append("                             M.RLANE_CD      ," ).append("\n"); 
		query.append("                             M.DIR_CD        ," ).append("\n"); 
		query.append("                             M.COST_YR       ," ).append("\n"); 
		query.append("                             M.COST_WK       ," ).append("\n"); 
		query.append("                             M.VSL_CD        ," ).append("\n"); 
		query.append("                             M.SKD_VOY_NO    ," ).append("\n"); 
		query.append("                             M.SKD_DIR_CD    ," ).append("\n"); 
		query.append("                             SF.CFM_TTL_QTY      AS FOR_VOLUM ," ).append("\n"); 
		query.append("                             SF.CFM_40FT_HC_QTY  AS FOR_HC    ," ).append("\n"); 
		query.append("                             SF.CFM_45FT_HC_QTY  AS FOR_HC45  ," ).append("\n"); 
		query.append("                             SF.CFM_53FT_QTY     AS FOR_53FT  ," ).append("\n"); 
		query.append("                             SF.CFM_RF_QTY       AS FOR_REEFER," ).append("\n"); 
		query.append("                             SF.CFM_TTL_WGT      AS FOR_WEIGHT" ).append("\n"); 
		query.append("                        FROM COM_VVD            M ," ).append("\n"); 
		query.append("                             SPC_DLY_FCAST_CUST SF" ).append("\n"); 
		query.append("                       WHERE M.RLANE_CD    = SF.RLANE_CD" ).append("\n"); 
		query.append("                         AND M.DIR_CD      = SF.DIR_CD" ).append("\n"); 
		query.append("                         AND M.VSL_CD      = SF.VSL_CD" ).append("\n"); 
		query.append("                         AND M.SKD_VOY_NO  = SF.SKD_VOY_NO" ).append("\n"); 
		query.append("                         AND M.DIR_CD      = SF.SKD_DIR_CD" ).append("\n"); 
		query.append("                         AND SF.IOC_TS_CD <> 'T'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${trade} != '')" ).append("\n"); 
		query.append("                         AND SF.REP_TRD_CD = @[trade]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${subtrade} != '')" ).append("\n"); 
		query.append("                         AND SF.REP_SUB_TRD_CD = @[subtrade]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${lane} != '')" ).append("\n"); 
		query.append("                         AND SF.RLANE_CD = @[lane]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${bound} != '')" ).append("\n"); 
		query.append("                         AND SF.DIR_CD = @[bound]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${vsl_cd} != '' && ${skd_voy_no} != '' && ${skd_dir_cd} != '')" ).append("\n"); 
		query.append("                         AND M.VSL_CD     = @[vsl_cd]" ).append("\n"); 
		query.append("                         AND M.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("                         AND M.DIR_CD     = @[skd_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                   ) Z" ).append("\n"); 
		query.append("          GROUP BY Z.REP_TRD_CD    ," ).append("\n"); 
		query.append("                   Z.REP_SUB_TRD_CD," ).append("\n"); 
		query.append("                   Z.RLANE_CD      ," ).append("\n"); 
		query.append("                   Z.DIR_CD        ," ).append("\n"); 
		query.append("                   Z.COST_YR       ," ).append("\n"); 
		query.append("                   Z.COST_WK       ," ).append("\n"); 
		query.append("                   Z.VSL_CD        ," ).append("\n"); 
		query.append("                   Z.SKD_VOY_NO    ," ).append("\n"); 
		query.append("                   Z.SKD_DIR_CD" ).append("\n"); 
		query.append("         ) FC," ).append("\n"); 
		query.append("         COM_VVD M" ).append("\n"); 
		query.append("   WHERE M.RLANE_CD   = FC.RLANE_CD  (+)" ).append("\n"); 
		query.append("     AND M.DIR_CD     = FC.DIR_CD    (+) " ).append("\n"); 
		query.append("     AND M.VSL_CD     = FC.VSL_CD    (+) " ).append("\n"); 
		query.append("     AND M.SKD_VOY_NO = FC.SKD_VOY_NO(+) " ).append("\n"); 
		query.append("     AND M.SKD_DIR_CD = FC.SKD_DIR_CD(+) " ).append("\n"); 
		query.append("     AND M.RLANE_CD  <> 'RBCCO' " ).append("\n"); 
		query.append("ORDER BY M.REP_TRD_CD    ," ).append("\n"); 
		query.append("         M.REP_SUB_TRD_CD," ).append("\n"); 
		query.append("         M.RLANE_CD      ," ).append("\n"); 
		query.append("         M.DIR_CD        ," ).append("\n"); 
		query.append("         M.WEEK          ," ).append("\n"); 
		query.append("         M.VVD" ).append("\n"); 

	}
}