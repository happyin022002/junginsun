/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BSAManageDBDAOSearchCreateBSAInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.11.30
*@LastModifier : 이행지
*@LastVersion : 1.0
* 2010.11.30 이행지
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bsa.bsamanage.bsamanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Haeng-ji,Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BSAManageDBDAOSearchCreateBSAInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * History---------------------------------
	  * 2010.11.30 이행지 [CHM-201007369] [BSA]WAFIE BSA Creation 에러 수정 요청-주차조회 조회시 정렬추가
	  * </pre>
	  */
	public BSAManageDBDAOSearchCreateBSAInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_yrwk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_yrwk",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bsa.bsamanage.bsamanage.integration").append("\n"); 
		query.append("FileName : BSAManageDBDAOSearchCreateBSAInfoRSQL").append("\n"); 
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
		query.append("      SUBSTR(COST_YRMON,0,4)                 COST_YEAR " ).append("\n"); 
		query.append("     ,MIN(SUBSTR(COST_YRMON,0,4) || COST_WK) FM_YRWK" ).append("\n"); 
		query.append("     ,MAX(SUBSTR(COST_YRMON,0,4) ||COST_WK)  TO_YRWK" ).append("\n"); 
		query.append("  FROM COA_MON_VVD" ).append("\n"); 
		query.append(" WHERE N1ST_LODG_PORT_ETD_DT BETWEEN TO_DATE(NVL(@[fm_yrwk],'999912') || '01','YYYYMMDD') " ).append("\n"); 
		query.append("                                 AND LAST_DAY(TO_DATE(NVL(@[to_yrwk], '999912') || '01', 'YYYYMMDD'))+0.9999" ).append("\n"); 
		query.append("GROUP BY SUBSTR(cost_yrmon,0,4)" ).append("\n"); 
		query.append("ORDER BY SUBSTR(COST_YRMON,0,4)" ).append("\n"); 

	}
}