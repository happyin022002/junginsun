/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : SCReportDBDAORsltMotTrfSeqEffDtListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.05.13
*@LastModifier : 송호진
*@LastVersion : 1.0
* 2014.05.13 송호진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.screport.screport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SongHoJin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCReportDBDAORsltMotTrfSeqEffDtListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PRI_MOT_TRF_MN 에서 SVC_SCP_CD 별 MOT_TRF_SEQ, EFF_DT, FILE_DT, CFM_FLG, CFM_DT 리스트를 조회 한다.
	  * </pre>
	  */
	public SCReportDBDAORsltMotTrfSeqEffDtListRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.pri.screport.screport.integration").append("\n"); 
		query.append("FileName : SCReportDBDAORsltMotTrfSeqEffDtListRSQL").append("\n"); 
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
		query.append("SELECT SVC_SCP_CD" ).append("\n"); 
		query.append("      ,MOT_TRF_SEQ" ).append("\n"); 
		query.append("      ,TO_CHAR(EFF_DT,  'YYYY-MM-DD') AS EFF_DT" ).append("\n"); 
		query.append("      ,TO_CHAR(FILE_DT, 'YYYY-MM-DD') AS FILE_DT" ).append("\n"); 
		query.append("      ,TO_CHAR(CFM_DT,  'YYYY-MM-DD') AS CFM_DT" ).append("\n"); 
		query.append("      ,DECODE ( NVL ( CFM_FLG, 'N' ), 'N', 'No', 'Y', 'Yes' ) AS CFM_FLG" ).append("\n"); 
		query.append("  FROM PRI_MOT_TRF_MN" ).append("\n"); 
		query.append(" WHERE SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append(" ORDER BY EFF_DT DESC" ).append("\n"); 

	}
}