/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TonnageTaxStandardProfitConclusionDBDAOTaxCalculationJobSkdVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.30
*@LastModifier : 
*@LastVersion : 1.0
* 2010.12.30 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxstandardprofitconclusion.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TonnageTaxStandardProfitConclusionDBDAOTaxCalculationJobSkdVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * feeder , nofeeder batch job 스케쥴 정보 조회
	  * 2011.01.03 이병훈 [CHM-201008072-01] Summary Creation - Batch 신규화면 개발으로 인하여 Taxable Amount Creation - Batch 조회 기능 보완
	  * </pre>
	  */
	public TonnageTaxStandardProfitConclusionDBDAOTaxCalculationJobSkdVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jb_fm_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("from_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jb_to_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxstandardprofitconclusion.integration").append("\n"); 
		query.append("FileName : TonnageTaxStandardProfitConclusionDBDAOTaxCalculationJobSkdVORSQL").append("\n"); 
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
		query.append("	TO_CHAR(TO_DATE(A.JB_FM_YRMON,'YYYYMM'),'YYYY-MM')   JB_FM_YRMON" ).append("\n"); 
		query.append(",   TO_CHAR(TO_DATE(A.JB_TO_YRMON,'YYYYMM'),'YYYY-MM')   JB_TO_YRMON" ).append("\n"); 
		query.append(",	TO_CHAR(A.EFF_DT,'YYYY-MM-DD HH24:MI') EFF_DT" ).append("\n"); 
		query.append(",	A.JB_ID" ).append("\n"); 
		query.append(",	A.CRE_DT" ).append("\n"); 
		query.append(",	A.CRE_USR_ID" ).append("\n"); 
		query.append(",	TO_CHAR(A.UPD_DT,'YYYY-MM') UPD_DT" ).append("\n"); 
		query.append(",	A.UPD_USR_ID" ).append("\n"); 
		query.append(",   A.BAT_ITM_NM " ).append("\n"); 
		query.append(",  DECODE(A.BAT_ITM_NM,'ALL','FNS_TOT_B001','MAIN TRADE','FNS_TOT_B002','FEEDER','FNS_TOT_B003') BAT_ID" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM TOT_JB_SKD A" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("#if (${his_type} == 'status')   " ).append("\n"); 
		query.append("    AND ((A.JB_FM_YRMON  BETWEEN @[jb_fm_yrmon] AND @[jb_to_yrmon]) OR (A.JB_TO_YRMON  BETWEEN @[jb_fm_yrmon] AND @[jb_to_yrmon]))" ).append("\n"); 
		query.append("  #if (${bat_itm_nm} == 'ALL')   " ).append("\n"); 
		query.append("    AND BAT_ITM_NM IN ('ALL','MAIN TRADE','FEEDER')" ).append("\n"); 
		query.append("  #elseif (${bat_itm_nm} == 'MAIN TRADE')  " ).append("\n"); 
		query.append("    AND BAT_ITM_NM IN ('ALL','MAIN TRADE')" ).append("\n"); 
		query.append("  #elseif (${bat_itm_nm} == 'FEEDER')  " ).append("\n"); 
		query.append("    AND BAT_ITM_NM IN ('ALL','FEEDER') " ).append("\n"); 
		query.append("  #end " ).append("\n"); 
		query.append("#elseif (${his_type} == 'search')" ).append("\n"); 
		query.append("    AND TO_CHAR(A.EFF_DT,'YYYY-MM-DD') BETWEEN @[from_dt] AND @[to_dt]" ).append("\n"); 
		query.append("    AND BAT_ITM_NM IN ('ALL','MAIN TRADE','FEEDER')" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("ORDER BY A.EFF_DT DESC" ).append("\n"); 

	}
}