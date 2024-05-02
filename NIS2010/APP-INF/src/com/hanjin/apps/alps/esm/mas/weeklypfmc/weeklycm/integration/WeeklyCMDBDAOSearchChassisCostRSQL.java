/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : WeeklyCMDBDAOSearchChassisCostRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.26
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.26 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WeeklyCMDBDAOSearchChassisCostRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchChassisCost
	  * 2015.03.26 컬럼 속성명 변경으로 수정()
	  * </pre>
	  */
	public WeeklyCMDBDAOSearchChassisCostRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_qtr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fr_year",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fr_qtr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_year",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.integration").append("\n"); 
		query.append("FileName : WeeklyCMDBDAOSearchChassisCostRSQL").append("\n"); 
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
		query.append("SELECT COST_YR," ).append("\n"); 
		query.append("       BSE_QTR_CD AS COST_QTR_CD," ).append("\n"); 
		query.append("	   COST_YR||'-'||BSE_QTR_CD AS COST_YR_QTR," ).append("\n"); 
		query.append("       EFF_FM_YRMON," ).append("\n"); 
		query.append("       EFF_TO_YRMON," ).append("\n"); 
		query.append("       ON_ST_AMT," ).append("\n"); 
		query.append("       ON_TML_AMT," ).append("\n"); 
		query.append("       MIG_AMT," ).append("\n"); 
		query.append("       REV_SHR_AMT," ).append("\n"); 
		query.append("       CR_MM_AMT," ).append("\n"); 
		query.append("       MISC_RBIL_AMT AS MISC_RE_BIL_AMT," ).append("\n"); 
		query.append("       ON_CHSS_AMT," ).append("\n"); 
		query.append("       CHSS_DRYG_AMT," ).append("\n"); 
		query.append("       ON_TML_AMT + MIG_AMT + REV_SHR_AMT + CR_MM_AMT + MISC_RBIL_AMT + ON_CHSS_AMT + CHSS_DRYG_AMT AS COM_SUB_TTL_AMT, -- 화면에서 EDIT시 자동계산" ).append("\n"); 
		query.append("	   ON_ST_AMT + ON_TML_AMT + MIG_AMT + REV_SHR_AMT + CR_MM_AMT + MISC_RBIL_AMT + ON_CHSS_AMT + CHSS_DRYG_AMT AS COM_TTL_AMT," ).append("\n"); 
		query.append("       CHSS_RMK" ).append("\n"); 
		query.append("FROM   MAS_CHSS_COST_UPLD" ).append("\n"); 
		query.append("WHERE  COST_YR||BSE_QTR_CD  BETWEEN SUBSTR(@[fr_year]||@[fr_qtr]||'Q',1,6)" ).append("\n"); 
		query.append("                             AND     SUBSTR(@[to_year]||@[to_qtr]||'Q',1,6)" ).append("\n"); 
		query.append("ORDER BY EFF_FM_YRMON ASC" ).append("\n"); 

	}
}