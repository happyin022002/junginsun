/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : WriteOffMgtDBDAOsearchWriteOffApprovalDetailDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.09.09
*@LastModifier : 
*@LastVersion : 1.0
* 2013.09.09 
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

public class WriteOffMgtDBDAOsearchWriteOffApprovalDetailDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public WriteOffMgtDBDAOsearchWriteOffApprovalDetailDataRSQL(){
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
		query.append("FileName : WriteOffMgtDBDAOsearchWriteOffApprovalDetailDataRSQL").append("\n"); 
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
		query.append("SELECT (SELECT MNR_CD_DP_DESC FROM MNR_GEN_CD WHERE PRNT_CD_ID = 'CD00002' AND MNR_CD_ID = MTLRD.EQ_KND_CD) EQ_KND_CD," ).append("\n"); 
		query.append("MTLRD.RQST_EQ_NO," ).append("\n"); 
		query.append("MTLRD.EQ_TPSZ_CD," ).append("\n"); 
		query.append("(SELECT LSTM_CD FROM MNR_EQ_STS_V WHERE EQ_NO = MTLRD.RQST_EQ_NO) AS LSTM_CD," ).append("\n"); 
		query.append("(SELECT LESSOR_NM FROM MNR_EQ_STS_V WHERE EQ_NO = MTLRD.RQST_EQ_NO)  LESSOR_NM," ).append("\n"); 
		query.append("MTLRD.TTL_LSS_YD_CD," ).append("\n"); 
		query.append("MTLRD.INV_NO," ).append("\n"); 
		query.append("MTLRD.CURR_CD," ).append("\n"); 
		query.append("MTLRD.DPC_VAL_AMT," ).append("\n"); 
		query.append("MTLRD.WRTF_CLT_AMT," ).append("\n"); 
		query.append("ROUND(MTLRD.DPC_VAL_AMT - NVL(MTLRD.WRTF_CLT_AMT, 0), 2) AMT_LOSS," ).append("\n"); 
		query.append("MTLRD.UPD_USR_ID, -- login user id," ).append("\n"); 
		query.append("MTLRD.TTL_LSS_NO," ).append("\n"); 
		query.append("MTLRD.TTL_LSS_DTL_SEQ," ).append("\n"); 
		query.append("MTLRD.WRTF_NO," ).append("\n"); 
		query.append("(SELECT INTG_CD_VAL_DESC" ).append("\n"); 
		query.append("FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("WHERE INTG_CD_ID = 'CD03135'" ).append("\n"); 
		query.append("AND INTG_CD_VAL_CTNT = (SELECT WRTF_STS_CD" ).append("\n"); 
		query.append("FROM MNR_WRTF_RQST_HDR" ).append("\n"); 
		query.append("WHERE TTL_LSS_NO = MTLRD.TTL_LSS_NO" ).append("\n"); 
		query.append("AND WRTF_NO = MTLRD.WRTF_NO)) WRTF_STS_NM" ).append("\n"); 
		query.append("FROM MNR_TTL_LSS_RQST_DTL MTLRD, MNR_TTL_LSS_RQST_HDR MTLRH" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("AND MTLRD.TTL_LSS_NO = MTLRH.TTL_LSS_NO" ).append("\n"); 
		query.append("#if (${ttl_lss_no} != '')" ).append("\n"); 
		query.append("AND MTLRD.TTL_LSS_NO = @[ttl_lss_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${wrtf_no} != '')" ).append("\n"); 
		query.append("AND MTLRD.WRTF_NO = @[wrtf_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND MTLRD.MNR_INV_TP_CD = 'DV'" ).append("\n"); 
		query.append("AND MTLRH.TTL_LSS_STS_CD = 'HA'" ).append("\n"); 

	}
}