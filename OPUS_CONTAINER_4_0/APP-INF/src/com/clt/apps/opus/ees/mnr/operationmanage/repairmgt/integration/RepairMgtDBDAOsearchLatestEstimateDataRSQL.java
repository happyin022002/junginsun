/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RepairMgtDBDAOsearchLatestEstimateDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.20
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2010.05.20 박명신
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author park myoung sin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RepairMgtDBDAOsearchLatestEstimateDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchLatestEstimateData
	  * </pre>
	  */
	public RepairMgtDBDAOsearchLatestEstimateDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("self_chk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_eqno",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.integration").append("\n"); 
		query.append("FileName : RepairMgtDBDAOsearchLatestEstimateDataRSQL").append("\n"); 
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
		query.append("SELECT C.RQST_EQ_NO,C.RPR_RQST_SEQ,C.RPR_RQST_VER_NO,C.EQ_KND_CD,C.RECENT_RPR_TP_CD FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("ROW_NUMBER() OVER(ORDER BY B.UPD_DT DESC) ROWNM," ).append("\n"); 
		query.append("'3' AS RECENT_RPR_TP_CD," ).append("\n"); 
		query.append("B.RQST_EQ_NO," ).append("\n"); 
		query.append("B.RPR_RQST_SEQ," ).append("\n"); 
		query.append("B.RPR_RQST_VER_NO," ).append("\n"); 
		query.append("B.EQ_KND_CD" ).append("\n"); 
		query.append("FROM MNR_RPR_RQST_HDR B,MNR_AGMT_HDR C" ).append("\n"); 
		query.append("WHERE B.RQST_EQ_NO = @[rqst_eqno]" ).append("\n"); 
		query.append("AND B.RPR_RQST_LST_VER_FLG = 'Y'" ).append("\n"); 
		query.append("AND B.RPR_STS_CD = 'HA'" ).append("\n"); 
		query.append("AND B.AGMT_OFC_CTY_CD = C.AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("AND B.AGMT_SEQ = C.AGMT_SEQ" ).append("\n"); 
		query.append("AND B.AGMT_VER_NO = C.AGMT_VER_NO" ).append("\n"); 
		query.append("AND B.UPD_DT BETWEEN ADD_MONTHS(SYSDATE, -3) AND SYSDATE" ).append("\n"); 
		query.append("AND B.RQST_EQ_NO || B.RPR_RQST_SEQ || B.RPR_RQST_VER_NO <> @[self_chk]" ).append("\n"); 
		query.append("AND C.VNDR_SEQ = @[vndr_seq]" ).append("\n"); 
		query.append(") C" ).append("\n"); 

	}
}