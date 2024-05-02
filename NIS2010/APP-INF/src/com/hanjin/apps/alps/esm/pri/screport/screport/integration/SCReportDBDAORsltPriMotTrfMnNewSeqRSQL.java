/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : SCReportDBDAORsltPriMotTrfMnNewSeqRSQL.java
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

public class SCReportDBDAORsltPriMotTrfMnNewSeqRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PRI_MOT_TRF_MN 의 Service Scope 별 신규 Sequence 생성
	  * </pre>
	  */
	public SCReportDBDAORsltPriMotTrfMnNewSeqRSQL(){
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
		query.append("FileName : SCReportDBDAORsltPriMotTrfMnNewSeqRSQL").append("\n"); 
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
		query.append("SELECT  NVL (   (   SELECT /*+ INDEX_DESC(A XPKPRI_MOT_TRF_MN) */" ).append("\n"); 
		query.append("                       	    MOT_TRF_SEQ" ).append("\n"); 
		query.append("                    FROM	PRI_MOT_TRF_MN A" ).append("\n"); 
		query.append("                    WHERE	A.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("                    AND		ROWNUM = 1 ), 0 ) + 1 AS NEW_MOT_TRF_SEQ" ).append("\n"); 
		query.append("FROM    DUAL" ).append("\n"); 

	}
}