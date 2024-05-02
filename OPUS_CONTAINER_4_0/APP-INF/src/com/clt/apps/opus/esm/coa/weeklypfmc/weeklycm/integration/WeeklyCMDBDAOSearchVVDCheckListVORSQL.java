/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : WeeklyCMDBDAOSearchVVDCheckListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.19
*@LastModifier : 이행지
*@LastVersion : 1.0
* 2010.01.19 이행지
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.weeklypfmc.weeklycm.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Haeng-ji,Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WeeklyCMDBDAOSearchVVDCheckListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *  COA_MON_VVD Check List 조회
	  * </pre>
	  */
	public WeeklyCMDBDAOSearchVVDCheckListVORSQL(){
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
		params.put("f_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_to_wk",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.coa.weeklypfmc.weeklycm.integration").append("\n"); 
		query.append("FileName : WeeklyCMDBDAOSearchVVDCheckListVORSQL").append("\n"); 
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
		query.append("SELECT COST_YRMON" ).append("\n"); 
		query.append(", SLS_YRMON             , COST_WK            , TRD_CD" ).append("\n"); 
		query.append(", RLANE_CD, IOC_CD      , VSL_CD             , SKD_VOY_NO" ).append("\n"); 
		query.append(", DIR_CD                , LST_LODG_PORT_CD   , LST_LODG_PORT_ETD_DT" ).append("\n"); 
		query.append(", NVL(WKY_MNL_FLG, '') WKY_MNL_FLG" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT COST_YRMON        , SLS_YRMON         , COST_WK" ).append("\n"); 
		query.append(", TRD_CD, RLANE_CD  , IOC_CD            , VSL_CD, SKD_VOY_NO" ).append("\n"); 
		query.append(", DIR_CD            , LST_LODG_PORT_CD  , TO_CHAR(LST_LODG_PORT_ETD_DT" ).append("\n"); 
		query.append(", 'YYYY-MM-DD HH24:MI:SS') LST_LODG_PORT_ETD_DT" ).append("\n"); 
		query.append(", WKY_MNL_FLG" ).append("\n"); 
		query.append(", COUNT(*) OVER (PARTITION BY COST_YRMON" ).append("\n"); 
		query.append(", COST_WK, TRD_CD" ).append("\n"); 
		query.append(", RLANE_CD, DIR_CD) NUM" ).append("\n"); 
		query.append("FROM COA_MON_VVD" ).append("\n"); 
		query.append("WHERE WKY_TGT_FLG = 'Y'" ).append("\n"); 
		query.append("AND DELT_FLG    <> 'Y'" ).append("\n"); 
		query.append("AND RLANE_CD   != 'RBCCO'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${f_trd_cd} != '')" ).append("\n"); 
		query.append("AND TRD_CD =     @[f_trd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${f_rlane_cd} != '')" ).append("\n"); 
		query.append("AND RLANE_CD   = @[f_rlane_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${f_seldir} != '')" ).append("\n"); 
		query.append("AND DIR_CD     = @[f_seldir]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${f_ioc_cd} != '')" ).append("\n"); 
		query.append("AND IOC_CD     = @[f_ioc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${f_vsl_cd} != '')" ).append("\n"); 
		query.append("AND VSL_CD     = @[f_vsl_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${f_skd_voy_no} != '')" ).append("\n"); 
		query.append("AND SKD_VOY_NO = @[f_skd_voy_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${f_dir_cd} != '')" ).append("\n"); 
		query.append("AND DIR_CD     = @[f_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${f_fm_mon} == '' || ${f_to_mon} == '')" ).append("\n"); 
		query.append("#if (${f_chkprd} == 'M')" ).append("\n"); 
		query.append("AND COST_YRMON LIKE @[f_year] || '%'" ).append("\n"); 
		query.append("#elseif (${f_chkprd} == 'W')" ).append("\n"); 
		query.append("AND SLS_YRMON LIKE @[f_year] || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#if (${f_chkprd} == 'M')" ).append("\n"); 
		query.append("AND COST_YRMON BETWEEN @[f_year]||@[f_fm_mon] AND @[f_year]||@[f_to_mon]" ).append("\n"); 
		query.append("#elseif (${f_chkprd} == 'W')" ).append("\n"); 
		query.append("AND SLS_YRMON  LIKE @[f_year] ||'%'" ).append("\n"); 
		query.append("AND COST_WK    BETWEEN @[f_fm_wk] AND @[f_to_wk]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE NUM > 1" ).append("\n"); 
		query.append("ORDER BY IOC_CD DESC, TRD_CD, RLANE_CD,  DIR_CD, COST_YRMON, LST_LODG_PORT_ETD_DT" ).append("\n"); 

	}
}