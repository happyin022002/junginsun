/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : PercentBaseChargeDBDAOAddPercentBaseChargeGroupingCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.02
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.02 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.primasterdata.percentbasecharge.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PercentBaseChargeDBDAOAddPercentBaseChargeGroupingCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ADD CHG_CD
	  * </pre>
	  */
	public PercentBaseChargeDBDAOAddPercentBaseChargeGroupingCSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pct_bse_chg_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pct_bse_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.primasterdata.percentbasecharge.integration").append("\n"); 
		query.append("FileName : PercentBaseChargeDBDAOAddPercentBaseChargeGroupingCSQL").append("\n"); 
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
		query.append("MERGE INTO PRI_SCG_PCT_BSE_CHG T1" ).append("\n"); 
		query.append("USING (" ).append("\n"); 
		query.append("    SELECT @[pct_bse_cd] PCT_BSE_CD, @[chg_cd] CHG_CD, @[pct_bse_chg_seq] PCT_BSE_CHG_SEQ" ).append("\n"); 
		query.append("      FROM DUAL" ).append("\n"); 
		query.append(") T2" ).append("\n"); 
		query.append("ON (" ).append("\n"); 
		query.append("        T1.PCT_BSE_CD = T2.PCT_BSE_CD" ).append("\n"); 
		query.append("    AND T1.CHG_CD = T2.CHG_CD" ).append("\n"); 
		query.append("    AND T1.PCT_BSE_CHG_SEQ = T2.PCT_BSE_CHG_SEQ" ).append("\n"); 
		query.append(")     " ).append("\n"); 
		query.append("WHEN MATCHED THEN		" ).append("\n"); 
		query.append("UPDATE SET T1.EFF_DT = TO_DATE(@[eff_dt], 'yyyyMMddhh24miss')" ).append("\n"); 
		query.append("         , T1.EXP_DT = TO_DATE(@[exp_dt], 'yyyyMMddhh24miss')" ).append("\n"); 
		query.append("         , T1.UPD_USR_ID = @[cre_usr_id]" ).append("\n"); 
		query.append("         , T1.UPD_DT = SYSDATE" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("INSERT (" ).append("\n"); 
		query.append("        T1.PCT_BSE_CD" ).append("\n"); 
		query.append("      , T1.CHG_CD" ).append("\n"); 
		query.append("      , T1.PCT_BSE_CHG_SEQ" ).append("\n"); 
		query.append("      , T1.EFF_DT" ).append("\n"); 
		query.append("      , T1.EXP_DT" ).append("\n"); 
		query.append("      , T1.CRE_USR_ID" ).append("\n"); 
		query.append("      , T1.CRE_DT" ).append("\n"); 
		query.append("      , T1.UPD_USR_ID" ).append("\n"); 
		query.append("      , T1.UPD_DT" ).append("\n"); 
		query.append(") VALUES (" ).append("\n"); 
		query.append("        @[pct_bse_cd]" ).append("\n"); 
		query.append("      , @[chg_cd]" ).append("\n"); 
		query.append("      , (SELECT NVL(MAX(PCT_BSE_CHG_SEQ)+1, 0) FROM PRI_SCG_PCT_BSE_CHG WHERE PCT_BSE_CD = @[pct_bse_cd] AND CHG_CD = @[chg_cd])" ).append("\n"); 
		query.append("      , TO_DATE(@[eff_dt], 'yyyyMMddhh24miss')" ).append("\n"); 
		query.append("      , TO_DATE(@[exp_dt], 'yyyyMMddhh24miss')" ).append("\n"); 
		query.append("      , @[cre_usr_id]" ).append("\n"); 
		query.append("      , SYSDATE" ).append("\n"); 
		query.append("      , @[upd_usr_id]" ).append("\n"); 
		query.append("      , SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}