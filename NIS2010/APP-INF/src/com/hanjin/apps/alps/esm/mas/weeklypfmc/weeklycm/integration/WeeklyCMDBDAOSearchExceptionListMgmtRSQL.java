/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : WeeklyCMDBDAOSearchExceptionListMgmtRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.15
*@LastModifier : 유제량
*@LastVersion : 1.0
* 2015.06.15 유제량
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Ryu Je Ryang
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WeeklyCMDBDAOSearchExceptionListMgmtRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchExceptionListMgmt
	  * </pre>
	  */
	public WeeklyCMDBDAOSearchExceptionListMgmtRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_scno",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("t_yearmonth",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_yearmonth",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.integration").append("\n"); 
		query.append("FileName : WeeklyCMDBDAOSearchExceptionListMgmtRSQL").append("\n"); 
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
		query.append("SELECT COST_YRMON," ).append("\n"); 
		query.append("       SC_NO," ).append("\n"); 
		query.append("       SCC_CD," ).append("\n"); 
		query.append("       SC_NO||SCC_CD AS SCNO_SCCCD," ).append("\n"); 
		query.append("	   CTRT_SEQ," ).append("\n"); 
		query.append("	   CMDT_CD," ).append("\n"); 
		query.append("	   ACT_SHPR_CNT_CD||DECODE(NVL(ACT_SHPR_CNT_CD,'0'),'0','',LPAD(ACT_SHPR_SEQ,6,'0')) as ACT_SHPR_CD," ).append("\n"); 
		query.append("	   COST_EXPT_FLG" ).append("\n"); 
		query.append("FROM   MAS_CHSS_EXPT_LIST" ).append("\n"); 
		query.append("WHERE  COST_YRMON  BETWEEN SUBSTR(@[f_yearmonth],1,6)" ).append("\n"); 
		query.append("                   AND     SUBSTR(@[t_yearmonth],1,6)" ).append("\n"); 
		query.append("#if (${f_scno} != '')" ).append("\n"); 
		query.append("	AND    SC_NO = NVL(@[f_scno],SC_NO)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY COST_YRMON ASC" ).append("\n"); 

	}
}