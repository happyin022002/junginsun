/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : WriteOffMgtDBDAOsearchTtlLssWrtfNoDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.12.21
*@LastModifier : 
*@LastVersion : 1.0
* 2012.12.21 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.operationmanage.totallossmgt.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WriteOffMgtDBDAOsearchTtlLssWrtfNoDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public WriteOffMgtDBDAOsearchTtlLssWrtfNoDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ttl_lss_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.operationmanage.totallossmgt.integration ").append("\n"); 
		query.append("FileName : WriteOffMgtDBDAOsearchTtlLssWrtfNoDataRSQL").append("\n"); 
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
		query.append("SELECT COUNT(TTL_LSS_NO) TTL_LSS_NO_CNT" ).append("\n"); 
		query.append("FROM MNR_TTL_LSS_RQST_DTL" ).append("\n"); 
		query.append("WHERE TTL_LSS_NO = @[ttl_lss_no]" ).append("\n"); 
		query.append("AND (MTLRD.WRTF_NO NOT IN (SELECT DISTINCT WRTF_NO" ).append("\n"); 
		query.append("FROM MNR_WRTF_RQST_HDR" ).append("\n"); 
		query.append("WHERE WRTF_STS_CD = 'RQ'" ).append("\n"); 
		query.append("AND TTL_LSS_NO = MTLRD.TTL_LSS_NO)" ).append("\n"); 
		query.append("OR MTLRD.WRTF_NO IS NULL)" ).append("\n"); 
		query.append("AND MTLRD.MNR_INV_TP_CD = 'DV'" ).append("\n"); 

	}
}