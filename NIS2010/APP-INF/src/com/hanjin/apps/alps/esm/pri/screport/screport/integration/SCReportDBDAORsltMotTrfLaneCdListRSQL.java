/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : SCReportDBDAORsltMotTrfLaneCdListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.05.20
*@LastModifier : 송호진
*@LastVersion : 1.0
* 2014.05.20 송호진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.screport.screport.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SongHoJin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCReportDBDAORsltMotTrfLaneCdListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MOT Tariff 에서 조회 조건에 사용되는 선택된 Service Scope 별 MOT Filing Lane Code ( CD03269 ) List 조회
	  * </pre>
	  */
	public SCReportDBDAORsltMotTrfLaneCdListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.screport.screport.integration ").append("\n"); 
		query.append("FileName : SCReportDBDAORsltMotTrfLaneCdListRSQL").append("\n"); 
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
		query.append("SELECT  B.INTG_CD_VAL_CTNT AS CD" ).append("\n"); 
		query.append("    ,   B.INTG_CD_VAL_DP_DESC AS NM" ).append("\n"); 
		query.append("FROM    " ).append("\n"); 
		query.append("    (   SELECT  DISTINCT MOT_FILE_LANE_CD" ).append("\n"); 
		query.append("        FROM    PRI_MOT_FILE_LOC_PPT " ).append("\n"); 
		query.append("        WHERE   SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("        ) A" ).append("\n"); 
		query.append("    ,   COM_INTG_CD_DTL B" ).append("\n"); 
		query.append("WHERE   B.INTG_CD_ID = 'CD03269'" ).append("\n"); 
		query.append("AND     A.MOT_FILE_LANE_CD = B.INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append("ORDER   BY B.INTG_CD_VAL_DP_SEQ" ).append("\n"); 

	}
}