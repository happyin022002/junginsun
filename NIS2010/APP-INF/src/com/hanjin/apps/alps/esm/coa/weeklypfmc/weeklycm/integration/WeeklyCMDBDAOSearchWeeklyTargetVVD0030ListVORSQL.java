/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : WeeklyCMDBDAOSearchWeeklyTargetVVD0030ListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.14
*@LastModifier : 박수훈
*@LastVersion : 1.0
* 2009.10.14 박수훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.coa.weeklypfmc.weeklycm.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SOO HOON PARK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WeeklyCMDBDAOSearchWeeklyTargetVVD0030ListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public WeeklyCMDBDAOSearchWeeklyTargetVVD0030ListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_year",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_fm_wk",new String[]{arrTmp[0],arrTmp[1]});

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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_to_mon",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_fm_mon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_to_wk",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.coa.weeklypfmc.weeklycm.integration").append("\n"); 
		query.append("FileName : WeeklyCMDBDAOSearchWeeklyTargetVVD0030ListVORSQL").append("\n"); 
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
		query.append("SELECT DECODE(NVL(A.BSA_ZR_FLG,'N'),'N', '0', '1') BSA_ZR_FLG" ).append("\n"); 
		query.append(", A.COST_YRMON" ).append("\n"); 
		query.append(", A.SLS_YRMON" ).append("\n"); 
		query.append(", A.COST_WK" ).append("\n"); 
		query.append(", A.TRD_CD" ).append("\n"); 
		query.append(", A.SUB_TRD_CD" ).append("\n"); 
		query.append(", B.SLAN_CD" ).append("\n"); 
		query.append(", A.RLANE_CD" ).append("\n"); 
		query.append(", B.VSL_LANE_TP_CD" ).append("\n"); 
		query.append(", A.VSL_CD" ).append("\n"); 
		query.append(", A.SKD_VOY_NO" ).append("\n"); 
		query.append(", A.DIR_CD" ).append("\n"); 
		query.append(", A.IOC_CD" ).append("\n"); 
		query.append(", A.LST_LODG_PORT_CD" ).append("\n"); 
		query.append(", TO_CHAR( A.LST_LODG_PORT_ETD_DT, 'YYYY-MM-DD HH24:MI:SS') LST_LODG_PORT_ETD_DT" ).append("\n"); 
		query.append(", TO_CHAR(A.N1ST_LODG_PORT_ETD_DT, 'YYYY-MM-DD HH24:MI:SS') N1ST_LODG_PORT_ETD_DT" ).append("\n"); 
		query.append(", DECODE(A.WKY_TGT_FLG, 'N', 'NO', 'YES') WKY_TGT_FLG, A.WKY_MNL_FLG" ).append("\n"); 
		query.append(", DECODE(A.MON_TGT_FLG, 'N', 'NO', 'YES') MON_TGT_FLG, A.DELT_FLG" ).append("\n"); 
		query.append("FROM COA_MON_VVD A, COA_LANE_RGST B" ).append("\n"); 
		query.append("WHERE A.TRD_CD   = B.TRD_CD" ).append("\n"); 
		query.append("AND A.RLANE_CD = B.RLANE_CD" ).append("\n"); 
		query.append("AND A.IOC_CD   = B.IOC_CD" ).append("\n"); 
		query.append("AND A.DIR_CD   = B.DIR_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${f_del} == '')" ).append("\n"); 
		query.append("AND NVL(A.DELT_FLG,'N') = 'N'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND NVL(A.DELT_FLG,'N') = 'Y'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND NVL(B.DELT_FLG,'N') = 'N'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${f_trd_cd} != '')" ).append("\n"); 
		query.append("AND A.TRD_CD     = @[f_trd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${f_rlane_cd} != '')" ).append("\n"); 
		query.append("AND A.RLANE_CD   = @[f_rlane_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${f_dir_cd} != '')" ).append("\n"); 
		query.append("AND A.DIR_CD     = @[f_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${f_ioc_cd} != '')" ).append("\n"); 
		query.append("AND A.IOC_CD     = @[f_ioc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${f_slan_cd} != '')" ).append("\n"); 
		query.append("AND A.SLAN_CD    = @[f_slan_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${f_vsl_cd} != '')" ).append("\n"); 
		query.append("AND A.VSL_CD     = @[f_vsl_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${f_skd_voy_no} != '')" ).append("\n"); 
		query.append("AND A.SKD_VOY_NO = @[f_skd_voy_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${f_skd_dir_cd} != '')" ).append("\n"); 
		query.append("AND A.DIR_CD     = @[f_skd_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${f_chkprd} == 'M')" ).append("\n"); 
		query.append("#if (${f_fm_mon} != '')" ).append("\n"); 
		query.append("AND A.COST_YRMON BETWEEN @[f_year] || @[f_fm_mon] AND @[f_year] || @[f_to_mon]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND A.COST_YRMON LIKE @[f_year] || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#elseif (${f_chkprd} == 'W')" ).append("\n"); 
		query.append("AND A.SLS_YRMON LIKE @[f_year] || '%'" ).append("\n"); 
		query.append("#if (${f_fm_wk} != '')" ).append("\n"); 
		query.append("AND A.COST_WK BETWEEN @[f_fm_wk] AND @[f_to_wk]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY A.COST_YRMON, A.COST_WK, A.TRD_CD, B.SUB_TRD_CD, B.SLAN_CD" ).append("\n"); 

	}
}