/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : SCReportDBDAORsltPriMotTrfRtMaxRtSeqRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.05.16
*@LastModifier : 송호진
*@LastVersion : 1.0
* 2014.05.16 송호진
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

public class SCReportDBDAORsltPriMotTrfRtMaxRtSeqRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PRI_MOT_TRF_RT 의 SVC_SCP_CD, MOT_TRF_SEQ 별 Maximum RT_SEQ 조회
	  * 하나의 값을 조회하여 여러개의 List 를 대상으로 사용하므로 Loop 안에서 Increment 연산을 수행하여 사용하므로 
	  * 현재의 Maximum RT_SEQ 값을 조회한다.
	  * </pre>
	  */
	public SCReportDBDAORsltPriMotTrfRtMaxRtSeqRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mot_trf_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.screport.screport.integration").append("\n"); 
		query.append("FileName : SCReportDBDAORsltPriMotTrfRtMaxRtSeqRSQL").append("\n"); 
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
		query.append("SELECT  NVL (   (   SELECT /*+ INDEX_DESC(A XPKPRI_MOT_TRF_RT) */" ).append("\n"); 
		query.append("                       	    RT_SEQ" ).append("\n"); 
		query.append("                    FROM	PRI_MOT_TRF_RT A" ).append("\n"); 
		query.append("                    WHERE	A.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("                    AND     A.MOT_TRF_SEQ = @[mot_trf_seq]" ).append("\n"); 
		query.append("                    AND		ROWNUM = 1 ), 0 ) AS MAX_RT_SEQ" ).append("\n"); 
		query.append("FROM    DUAL" ).append("\n"); 

	}
}