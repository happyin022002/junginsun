/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ChargeCalculationDBDAOSearchDuplicateChargeDeletionPathSetupRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.15
*@LastModifier : 
*@LastVersion : 1.0
* 2015.04.15 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChargeCalculationDBDAOSearchDuplicateChargeDeletionPathSetupRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ChargeCalculationDBDAOSearchDuplicateChargeDeletionPathSetupRSQL
	  * </pre>
	  */
	public ChargeCalculationDBDAOSearchDuplicateChargeDeletionPathSetupRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("exp_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.integration").append("\n"); 
		query.append("FileName : ChargeCalculationDBDAOSearchDuplicateChargeDeletionPathSetupRSQL").append("\n"); 
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
		query.append("select  case when count(1) > 0 then 'Y' else 'N' end " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  from  DMT_CHG_DELT_PATH_STUP  T1" ).append("\n"); 
		query.append("       ,DMT_CHG_DELT_OFC_STUP   T2" ).append("\n"); 
		query.append(" where  T1.CHG_DELT_PATH_STUP_SEQ = T2.CHG_DELT_PATH_STUP_SEQ" ).append("\n"); 
		query.append("   and  T2.CHG_DELT_OFC_CD in" ).append("\n"); 
		query.append("		(" ).append("\n"); 
		query.append("		#foreach( $chg_delt_ofc_cd in ${chg_delt_ofc_cd_list} )" ).append("\n"); 
		query.append("			#if($velocityCount < $chg_delt_ofc_cd_list.size()) '$chg_delt_ofc_cd', #else '$chg_delt_ofc_cd' #end" ).append("\n"); 
		query.append("		#end	" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("   and  (" ).append("\n"); 
		query.append("			(T1.EFF_DT between to_date(@[eff_dt], 'YYYYMMDD') + .0 and to_date(nvl(@[exp_dt], '99991231'), 'YYYYMMDD') + 0.99999)" ).append("\n"); 
		query.append("			or" ).append("\n"); 
		query.append("			(T1.EXP_DT is null or (T1.EXP_DT between to_date(@[eff_dt], 'YYYYMMDD') + .0 and to_date(nvl(@[exp_dt], '99991231'), 'YYYYMMDD') + 0.99999))" ).append("\n"); 
		query.append("		)" ).append("\n"); 

	}
}