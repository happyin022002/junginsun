/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BSAYearlyPlanDBDAOCoaMonVvdYryPlnVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.11
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.11 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bsa.bsayearlyplan.bsayearlyplan.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BSAYearlyPlanDBDAOCoaMonVvdYryPlnVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *   Target VVD 를 조회한다.
	  * 2015.06.08 김용습 [CHM-201536164] 주간 MAS Open에 따른 타모듈 프로그램 적용 요청
	  * </pre>
	  */
	public BSAYearlyPlanDBDAOCoaMonVvdYryPlnVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_selrlane",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_selslane",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_to_mon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_seltrade",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_seldir",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_selioc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_to_wk",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bsa.bsayearlyplan.bsayearlyplan.integration").append("\n"); 
		query.append("FileName : BSAYearlyPlanDBDAOCoaMonVvdYryPlnVORSQL").append("\n"); 
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
		query.append("SELECT A.TRD_CD" ).append("\n"); 
		query.append("     , A.RLANE_CD" ).append("\n"); 
		query.append("     , A.IOC_CD" ).append("\n"); 
		query.append("     , A.VSL_CD" ).append("\n"); 
		query.append("     , A.SKD_VOY_NO" ).append("\n"); 
		query.append("     , A.DIR_CD" ).append("\n"); 
		query.append("     , A.COST_YRMON" ).append("\n"); 
		query.append("     , A.SLS_YRMON" ).append("\n"); 
		query.append("     , A.COST_WK" ).append("\n"); 
		query.append("     , A.SLAN_CD" ).append("\n"); 
		query.append("     , TO_CHAR(A.LST_LODG_PORT_ETD_DT, 'YYYY-MM-DD HH24:MI:SS')  LST_LODG_PORT_ETD_DT" ).append("\n"); 
		query.append("     , TO_CHAR(A.N1ST_LODG_PORT_ETD_DT, 'YYYY-MM-DD HH24:MI:SS')  N1ST_LODG_PORT_ETD_DT" ).append("\n"); 
		query.append("     , A.LST_LODG_PORT_CD" ).append("\n"); 
		query.append("     , A.IOC_RULE_DESC" ).append("\n"); 
		query.append("     , A.SUB_TRD_CD" ).append("\n"); 
		query.append("     , A.VVD_RMK" ).append("\n"); 
		query.append("     , A.DELT_FLG" ).append("\n"); 
		query.append("     , A.CRE_USR_ID" ).append("\n"); 
		query.append("     , A.CRE_DT" ).append("\n"); 
		query.append("     , A.UPD_USR_ID" ).append("\n"); 
		query.append("     , A.UPD_DT" ).append("\n"); 
		query.append("	 , B.SLAN_CD" ).append("\n"); 
		query.append("	 , B.VSL_LANE_TP_CD" ).append("\n"); 
		query.append("  FROM MAS_MON_VVD_YRY_PLN A" ).append("\n"); 
		query.append("     , MAS_LANE_RGST B" ).append("\n"); 
		query.append(" WHERE A.TRD_CD   = B.TRD_CD" ).append("\n"); 
		query.append("   AND A.RLANE_CD = B.RLANE_CD" ).append("\n"); 
		query.append("   AND A.IOC_CD   = B.IOC_CD" ).append("\n"); 
		query.append("   AND A.DIR_CD   = B.DIR_CD" ).append("\n"); 
		query.append("   AND NVL(A.DELT_FLG,'N') = 'N'  " ).append("\n"); 
		query.append("   AND NVL(B.DELT_FLG,'N') = 'N'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   #if (${f_seltrade} != '')" ).append("\n"); 
		query.append("   AND A.TRD_CD = @[f_seltrade]" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("   #if (${f_selrlane} != '')" ).append("\n"); 
		query.append("   AND A.RLANE_CD = @[f_selrlane]" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("   #if (${f_seldir} != '')" ).append("\n"); 
		query.append("   AND A.DIR_CD = @[f_seldir]" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("   #if (${f_selioc} != '')" ).append("\n"); 
		query.append("   AND A.IOC_CD = @[f_selioc]" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("   #if (${f_selslane} != '')" ).append("\n"); 
		query.append("   AND A.SLAN_CD = @[f_selslane]" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("   #if (${f_vsl_cd} != '')" ).append("\n"); 
		query.append("   AND A.VSL_CD = @[f_vsl_cd]" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("   #if (${f_skd_voy_no} != '')" ).append("\n"); 
		query.append("   AND A.SKD_VOY_NO = @[f_skd_voy_no]" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("   #if (${f_dir_cd} != '')" ).append("\n"); 
		query.append("   AND A.DIR_CD = @[f_dir_cd]" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("   #if (${f_chkprd} == 'M')" ).append("\n"); 
		query.append("   AND A.COST_YRMON BETWEEN @[f_year]||@[f_fm_mon] AND @[f_year]||@[f_to_mon] " ).append("\n"); 
		query.append("   #elseif(${f_chkprd} == 'W')" ).append("\n"); 
		query.append("   AND A.SLS_YRMON LIKE @[f_year] || '%'" ).append("\n"); 
		query.append("   AND A.COST_WK BETWEEN @[f_fm_wk] AND @[f_to_wk]" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append(" ORDER BY A.COST_YRMON" ).append("\n"); 
		query.append("        , A.COST_WK" ).append("\n"); 
		query.append("        , A.TRD_CD" ).append("\n"); 
		query.append("        , B.SUB_TRD_CD" ).append("\n"); 
		query.append("        , B.SLAN_CD" ).append("\n"); 

	}
}