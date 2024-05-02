/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : StatusHistoryMgtDBDAOsearchStatusHistoryDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.22
*@LastModifier : 김완규
*@LastVersion : 1.0
* 2009.09.22 김완규
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.generalmanage.statushistorymgt.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author WanGyu Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class StatusHistoryMgtDBDAOsearchStatusHistoryDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Status History 조회
	  * </pre>
	  */
	public StatusHistoryMgtDBDAOsearchStatusHistoryDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_sts_ref_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mnr.generalmanage.statushistorymgt.integration ").append("\n"); 
		query.append("FileName : StatusHistoryMgtDBDAOsearchStatusHistoryDataRSQL").append("\n"); 
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
		query.append("SELECT A.MNR_STS_REF_NO" ).append("\n"); 
		query.append(",A.MNR_STS_DTL_SEQ" ).append("\n"); 
		query.append(",A.MNR_GRP_TP_CD" ).append("\n"); 
		query.append(",A.MNR_HIS_STS_CD" ).append("\n"); 
		query.append(",A.MNR_INP_TP_CD" ).append("\n"); 
		query.append(",A.RQST_OFC_CD" ).append("\n"); 
		query.append(",TO_CHAR(A.RQST_DT, 'yyyy-mm-dd') RQST_DT" ).append("\n"); 
		query.append(",A.RQST_USR_ID" ).append("\n"); 
		query.append(",A.APRO_OFC_CD" ).append("\n"); 
		query.append(",TO_CHAR(A.APRO_DT, 'yyyy-mm-dd') APRO_DT" ).append("\n"); 
		query.append(",A.APRO_USR_ID" ).append("\n"); 
		query.append(",A.MNR_STS_RMK" ).append("\n"); 
		query.append(",TO_CHAR(A.MNR_STS_DT, 'yyyy-mm-dd') MNR_STS_DT" ).append("\n"); 
		query.append(",A.CRE_USR_ID" ).append("\n"); 
		query.append(",TO_CHAR(A.CRE_DT, 'yyyy-mm-dd') CRE_DT" ).append("\n"); 
		query.append(",A.UPD_USR_ID" ).append("\n"); 
		query.append(",TO_CHAR(A.UPD_DT, 'yyyy-mm-dd') UPD_DT" ).append("\n"); 
		query.append("FROM MNR_STS_HIS A" ).append("\n"); 
		query.append("WHERE A.MNR_STS_REF_NO = @[mnr_sts_ref_no]" ).append("\n"); 

	}
}