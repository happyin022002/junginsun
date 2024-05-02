/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : WriteOffMgtDBDAOsearchWriteOffRemarkListDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.08.05
*@LastModifier : 
*@LastVersion : 1.0
* 2013.08.05 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.operationmanage.totallossmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WriteOffMgtDBDAOsearchWriteOffRemarkListDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public WriteOffMgtDBDAOsearchWriteOffRemarkListDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wrtf_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ttl_lss_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.operationmanage.totallossmgt.integration").append("\n"); 
		query.append("FileName : WriteOffMgtDBDAOsearchWriteOffRemarkListDataRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("MWRH.TTL_LSS_DTL_RSN_RMK," ).append("\n"); 
		query.append("MWRH.DPC_CLT_FALD_RSN_RMK," ).append("\n"); 
		query.append("MWRH.RCVR_ACT_HIS_RMK," ).append("\n"); 
		query.append("MWRH.FILE_SEQ AS SUB_FILE_SEQ," ).append("\n"); 
		query.append("MWRH.WRTF_STS_CD," ).append("\n"); 
		query.append("MWRH.WRTF_NO," ).append("\n"); 
		query.append("(SELECT DISTINCT FILE_SEQ" ).append("\n"); 
		query.append("FROM MNR_TTL_LSS_RQST_HDR" ).append("\n"); 
		query.append("WHERE TTL_LSS_NO = MWRH.TTL_LSS_NO) AS FILE_SEQ" ).append("\n"); 
		query.append("FROM MNR_WRTF_RQST_HDR MWRH" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if (${ttl_lss_no} != '')" ).append("\n"); 
		query.append("AND MWRH.TTL_LSS_NO = @[ttl_lss_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${wrtf_no} != '')" ).append("\n"); 
		query.append("AND MWRH.WRTF_NO = @[wrtf_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}