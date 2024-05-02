/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : PercentBaseChargeDBDAOSearchPercentBaseChargeGroupingRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.03
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.03 
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

public class PercentBaseChargeDBDAOSearchPercentBaseChargeGroupingRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PCT_BSE_CHG
	  * </pre>
	  */
	public PercentBaseChargeDBDAOSearchPercentBaseChargeGroupingRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("acs_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.primasterdata.percentbasecharge.integration").append("\n"); 
		query.append("FileName : PercentBaseChargeDBDAOSearchPercentBaseChargeGroupingRSQL").append("\n"); 
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
		query.append("SELECT A.PCT_BSE_CD" ).append("\n"); 
		query.append("     , A.CHG_CD" ).append("\n"); 
		query.append("	 , B.CHG_NM" ).append("\n"); 
		query.append("     , PCT_BSE_CHG_SEQ" ).append("\n"); 
		query.append("     , EFF_DT" ).append("\n"); 
		query.append("     , EXP_DT" ).append("\n"); 
		query.append("FROM   PRI_SCG_PCT_BSE_CHG A," ).append("\n"); 
		query.append("		MDM_CHARGE B" ).append("\n"); 
		query.append("WHERE A.CHG_CD = B.CHG_CD" ).append("\n"); 
		query.append("AND	NVL( B.DELT_FLG, 'N' ) != 'Y'" ).append("\n"); 
		query.append("AND A.PCT_BSE_CD = @[pct_bse_cd]" ).append("\n"); 
		query.append("#if (${acs_dt} != '') " ).append("\n"); 
		query.append("	AND TO_DATE( REPLACE(@[acs_dt], '-', ''), 'yyyyMMddhh24miss' ) BETWEEN EFF_DT AND EXP_DT" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}