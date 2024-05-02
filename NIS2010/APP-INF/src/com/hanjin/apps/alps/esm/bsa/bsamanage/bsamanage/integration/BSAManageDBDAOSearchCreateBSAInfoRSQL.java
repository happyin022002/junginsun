/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BSAManageDBDAOSearchCreateBSAInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.11
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.11 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bsa.bsamanage.bsamanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
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
	  * 2011.02.24 최성민 [CHM-201109136-01] [BSA] COST_YRMON -> SLS_YRMON으로 변경
	  * 2015.06.08 김용습 [CHM-201536164] 주간 MAS Open에 따른 타모듈 프로그램 적용 요청
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
		query.append("Path : com.hanjin.apps.alps.esm.bsa.bsamanage.bsamanage.integration").append("\n"); 
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
		query.append("SELECT SUBSTR(SLS_YRMON,0,4)                 COST_YEAR " ).append("\n"); 
		query.append("     , MIN(SUBSTR(SLS_YRMON,0,4) || COST_WK) FM_YRWK" ).append("\n"); 
		query.append("     , MAX(SUBSTR(SLS_YRMON,0,4) || COST_WK) TO_YRWK" ).append("\n"); 
		query.append("  FROM MAS_MON_VVD" ).append("\n"); 
		query.append(" WHERE N1ST_LODG_PORT_ETD_DT BETWEEN TO_DATE(NVL(@[fm_yrwk],'999912') || '01','YYYYMMDD') " ).append("\n"); 
		query.append("                                 AND LAST_DAY(TO_DATE(NVL(@[to_yrwk], '999912') || '01', 'YYYYMMDD'))+0.9999" ).append("\n"); 
		query.append(" GROUP BY SUBSTR(SLS_YRMON,0,4)" ).append("\n"); 
		query.append(" ORDER BY SUBSTR(SLS_YRMON,0,4)" ).append("\n"); 

	}
}