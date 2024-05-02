/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : WeeklyCMDBDAOSearchDemDetCostDayBatRstRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.09
*@LastModifier : 최덕우
*@LastVersion : 1.0
* 2015.06.09 최덕우
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Duk Woo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WeeklyCMDBDAOSearchDemDetCostDayBatRstRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DEM/DET Cost Daily Batch Result를 조회한다.
	  * </pre>
	  */
	public WeeklyCMDBDAOSearchDemDetCostDayBatRstRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_fm_nod",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_fmyearmonth",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_toyearmonth",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_cntrno",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_bkgno",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.integration").append("\n"); 
		query.append("FileName : WeeklyCMDBDAOSearchDemDetCostDayBatRstRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("       TO_CHAR(BAT_DT,'YYYY-MM-DD') as BAT_DT," ).append("\n"); 
		query.append("       CNTR_NO," ).append("\n"); 
		query.append("       CNTR_TPSZ_CD," ).append("\n"); 
		query.append("       CNMV_CYC_NO," ).append("\n"); 
		query.append("       CNMV_SEQ," ).append("\n"); 
		query.append("       BKG_NO,       " ).append("\n"); 
		query.append("       DECODE(BKG_BND_CD, 'O', 'O/B', 'I', 'I/B') as BKG_BND, " ).append("\n"); 
		query.append("       STO_FM_MVMT_CD STO_FM_MVMT, " ).append("\n"); 
		query.append("       STO_TO_MVMT_CD STO_TO_MVMT, " ).append("\n"); 
		query.append("       STO_FM_NOD_CD STO_FM_NOD, " ).append("\n"); 
		query.append("       STO_TO_NOD_CD STO_TO_NOD," ).append("\n"); 
		query.append("       TO_CHAR(STO_FM_DT,'YYYY-MM-DD') as STO_FM_DT," ).append("\n"); 
		query.append("       TO_CHAR(STO_TO_DT,'YYYY-MM-DD') as STO_TO_DT,       " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       DECODE((case when STO_FM_MVMT_CD is null and STO_TO_MVMT_CD is null and STO_FM_NOD_CD is null and STO_TO_NOD_CD is null and STO_FM_DT is null and STO_TO_DT is null" ).append("\n"); 
		query.append("            then ''" ).append("\n"); 
		query.append("            else STO_STS_FLG" ).append("\n"); 
		query.append("       end), 'Y', 'F', 'N', 'U', '', '') as STO_STS," ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("       CNTR_FM_MVMT_CD CNTR_FM_MVMT," ).append("\n"); 
		query.append("       CNTR_TO_MVMT_CD CNTR_TO_MVMT, " ).append("\n"); 
		query.append("       CNTR_FM_NOD_CD CNTR_FM_NOD, " ).append("\n"); 
		query.append("       CNTR_TO_NOD_CD CNTR_TO_NOD, " ).append("\n"); 
		query.append("       TO_CHAR(CNTR_FM_DT,'YYYY-MM-DD') as CNTR_FM_DT," ).append("\n"); 
		query.append("       TO_CHAR(CNTR_TO_DT,'YYYY-MM-DD') as CNTR_TO_DT,       " ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("       DECODE((case when CNTR_FM_MVMT_CD is null and CNTR_TO_MVMT_CD is null and CNTR_FM_NOD_CD is null and CNTR_TO_NOD_CD is null and CNTR_FM_DT is null and CNTR_TO_DT is null" ).append("\n"); 
		query.append("			then ''" ).append("\n"); 
		query.append("            else CNTR_STS_FLG" ).append("\n"); 
		query.append("       end), 'Y', 'F', 'N', 'U', '', '') as CNTR_STS," ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("       CHSS_FM_MVMT_CD CHSS_FM_MVMT," ).append("\n"); 
		query.append("       CHSS_TO_MVMT_CD CHSS_TO_MVMT, " ).append("\n"); 
		query.append("       CHSS_FM_NOD_CD CHSS_FM_NOD, " ).append("\n"); 
		query.append("       CHSS_TO_NOD_CD CHSS_TO_NOD, " ).append("\n"); 
		query.append("       TO_CHAR(CHSS_FM_DT,'YYYY-MM-DD') as CHSS_FM_DT," ).append("\n"); 
		query.append("       TO_CHAR(CHSS_TO_DT,'YYYY-MM-DD') as CHSS_TO_DT,         " ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("       DECODE((case when CHSS_FM_MVMT_CD is null and CHSS_TO_MVMT_CD is null and CHSS_FM_NOD_CD is null and CHSS_TO_NOD_CD is null and CHSS_FM_DT is null and CHSS_TO_DT is null" ).append("\n"); 
		query.append("            then ''" ).append("\n"); 
		query.append("            else CHSS_STS_FLG" ).append("\n"); 
		query.append("       end), 'Y', 'F', 'N', 'U', '', '') as CHSS_STS," ).append("\n"); 
		query.append("	   " ).append("\n"); 
		query.append("       TO_CHAR(CNMV_EVNT_DT,'YYYY-MM-DD') as CNMV_EVNT_DT," ).append("\n"); 
		query.append("	   TO_CHAR(UPD_DT, 'YYYY-MM-DD') AS UPD_DT" ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("FROM   MAS_DMDT_COST_DLY_RSLT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${f_selinputtype} == 'selInputDate')" ).append("\n"); 
		query.append("    WHERE BAT_DT BETWEEN TO_DATE(@[f_fmyearmonth] || ' 00:00:00', 'YYYY-MM-DD HH24:MI:SS') AND TO_DATE(@[f_toyearmonth] || ' 23:59:59', 'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append("    #if (${f_sto_cntr_chss} == 'ST')" ).append("\n"); 
		query.append("        AND STO_FM_NOD_CD LIKE @[f_fm_nod]||'%'" ).append("\n"); 
		query.append("    #elseif (${f_sto_cntr_chss} == 'CN')" ).append("\n"); 
		query.append("        AND CNTR_FM_NOD_CD LIKE @[f_fm_nod]||'%'" ).append("\n"); 
		query.append("    #elseif (${f_sto_cntr_chss} == 'CH')" ).append("\n"); 
		query.append("        AND CHSS_FM_NOD_CD LIKE @[f_fm_nod]||'%'" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("#elseif (${f_selinputtype} == 'selInputNo')" ).append("\n"); 
		query.append("    #if (${f_bkgno} != '' && ${f_cntrno} == '')" ).append("\n"); 
		query.append("        WHERE BKG_NO LIKE @[f_bkgno]||'%'" ).append("\n"); 
		query.append("    #elseif (${f_bkgno} == '' && ${f_cntrno} != '')" ).append("\n"); 
		query.append("        WHERE CNTR_NO LIKE @[f_cntrno]||'%'" ).append("\n"); 
		query.append("    #elseif (${f_bkgno} != '' && ${f_cntrno} != '')" ).append("\n"); 
		query.append("        WHERE BKG_NO LIKE @[f_bkgno]||'%'" ).append("\n"); 
		query.append("        AND   CNTR_NO LIKE @[f_cntrno]||'%'" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY BAT_DT, CNTR_NO, CNMV_SEQ, BKG_NO" ).append("\n"); 

	}
}