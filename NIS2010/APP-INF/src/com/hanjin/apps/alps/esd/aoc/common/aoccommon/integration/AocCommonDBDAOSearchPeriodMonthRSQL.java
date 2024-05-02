/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : AocCommonDBDAOSearchPeriodMonthRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.10.04
*@LastModifier : 
*@LastVersion : 1.0
* 2012.10.04 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.aoc.common.aoccommon.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AocCommonDBDAOSearchPeriodMonthRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2012.10.04 변종건 [CHM-201220395] Add-on Tariff Management 개선 프로젝트
	  * - Month 조회
	  * </pre>
	  */
	public AocCommonDBDAOSearchPeriodMonthRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_month",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_month",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.aoc.common.aoccommon.integration ").append("\n"); 
		query.append("FileName : AocCommonDBDAOSearchPeriodMonthRSQL").append("\n"); 
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
		query.append("SELECT   " ).append("\n"); 
		query.append("		TO_CHAR(TO_DATE(FRDAY, 'RRRRMM'), 'RRRR-MM-DD') FM_DATE, " ).append("\n"); 
		query.append("		TO_CHAR(LAST_DAY(TO_DATE(TODAY, 'RRRRMM')), 'RRRR-MM-DD') TO_DATE" ).append("\n"); 
		query.append("FROM 	(SELECT @[fm_month] FRDAY, @[to_month] TODAY FROM DUAL)" ).append("\n"); 

	}
}