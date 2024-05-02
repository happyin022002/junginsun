/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : CommonDBDAOSearchBkgSokeupStatusRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.05.03
*@LastModifier : 
*@LastVersion : 1.0
* 2013.05.03 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.common.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CommonDBDAOSearchBkgSokeupStatusRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchBkgSokeupStatus
	  * </pre>
	  */
	public CommonDBDAOSearchBkgSokeupStatusRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_to_date",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_fm_date",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.common.integration").append("\n"); 
		query.append("FileName : CommonDBDAOSearchBkgSokeupStatusRSQL").append("\n"); 
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
		query.append("SELECT A.BKG_NO, A.MAS_BAT_RMK, A.CRE_USR_ID , TO_CHAR(B.COST_BAT_DT, 'YYYY/MM/DD HH24:MI:SS') FINISH_TIME, '' MAS_BAT_CD, '' MAS_BAT_SEQ, 'S' STATUS" ).append("\n"); 
		query.append("FROM MAS_BKG_RTRO_HIS A, MAS_BKG_COST_CALC_HIS B" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if (${f_status} != '' && ${f_status} != 'S') " ).append("\n"); 
		query.append("AND 1=0" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_fm_date} != '' && ${f_to_date} != '') " ).append("\n"); 
		query.append("AND TO_CHAR(A.CRE_DT, 'YYYY-MM-DD') BETWEEN @[f_fm_date] AND @[f_to_date]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND A.BKG_NO = B.BKG_NO(+)" ).append("\n"); 
		query.append("AND TO_CHAR(A.CRE_DT,'YYYYMMDD') = TO_CHAR(B.COST_BAT_DT,'YYYYMMDD')" ).append("\n"); 
		query.append("AND A.MAS_BAT_RMK = B.COST_BAT_RMK" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT A.BKG_NO, A.MAS_BAT_RMK, A.CRE_USR_ID, '' FINISH_TIME, C.MAS_BAT_CD , TO_CHAR(C.MAS_BAT_SEQ) MAS_BAT_SEQ," ).append("\n"); 
		query.append("       CASE WHEN C.MAS_BAT_CD ='P' THEN 'P'" ).append("\n"); 
		query.append("            WHEN C.MAS_BAT_CD = 'E' AND C.MAS_BAT_SEQ = '2' THEN 'I'" ).append("\n"); 
		query.append("            WHEN C.MAS_BAT_CD = 'E' AND C.MAS_BAT_SEQ = '3' THEN 'F'" ).append("\n"); 
		query.append("       END STATUS" ).append("\n"); 
		query.append("FROM MAS_BKG_RTRO_HIS A, MAS_BKG_COST_CALC C " ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if (${f_status} == 'S') " ).append("\n"); 
		query.append("AND 1=0" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_fm_date} != '' && ${f_to_date} != '') " ).append("\n"); 
		query.append("AND TO_CHAR(A.CRE_DT, 'YYYY-MM-DD') BETWEEN @[f_fm_date] AND @[f_to_date]" ).append("\n"); 
		query.append("AND A.MAS_BAT_RMK = C.MAS_BAT_RMK" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND A.BKG_NO = C.BKG_NO(+)" ).append("\n"); 
		query.append("AND TO_CHAR(A.CRE_DT,'YYYYMMDD') = TO_CHAR(C.MAS_BAT_DT,'YYYYMMDD')" ).append("\n"); 
		query.append("#if (${f_status} == 'I')" ).append("\n"); 
		query.append("AND C.MAS_BAT_CD = 'E'" ).append("\n"); 
		query.append("AND C.MAS_BAT_SEQ = '2'" ).append("\n"); 
		query.append("#elseif (${f_status} == 'P')" ).append("\n"); 
		query.append("AND C.MAS_BAT_CD ='P'" ).append("\n"); 
		query.append("#elseif (${f_status} == 'F')" ).append("\n"); 
		query.append("AND C.MAS_BAT_CD = 'E'" ).append("\n"); 
		query.append("AND C.MAS_BAT_SEQ = '3'" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}