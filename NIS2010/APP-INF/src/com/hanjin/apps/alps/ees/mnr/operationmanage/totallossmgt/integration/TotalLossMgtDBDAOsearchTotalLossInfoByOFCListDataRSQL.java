/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : TotalLossMgtDBDAOsearchTotalLossInfoByOFCListDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.05.23
*@LastModifier : 
*@LastVersion : 1.0
* 2013.05.23 
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

public class TotalLossMgtDBDAOsearchTotalLossInfoByOFCListDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Total Loss No Inquiry_Pop Up 화면 조회
	  * </pre>
	  */
	public TotalLossMgtDBDAOsearchTotalLossInfoByOFCListDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_eq_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_dt_to",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_dt_fr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.operationmanage.totallossmgt.integration").append("\n"); 
		query.append("FileName : TotalLossMgtDBDAOsearchTotalLossInfoByOFCListDataRSQL").append("\n"); 
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
		query.append("SELECT A.TTL_LSS_NO" ).append("\n"); 
		query.append(",A.RQST_OFC_CD" ).append("\n"); 
		query.append(",A.APRO_OFC_CD" ).append("\n"); 
		query.append(",A.RESPB_OFC_CD" ).append("\n"); 
		query.append(",TO_CHAR(A.TTL_LSS_DT, 'yyyy-mm-dd') TTL_LSS_DT" ).append("\n"); 
		query.append(",TO_CHAR(GLOBALDATE_PKG.TIME_CONV_OFC_FNC(MNR_COMMON_PKG.MNR_GET_HOOFC_FNC(), A.RQST_DT,@[user_ofc_cd]), 'yyyy-mm-dd') RQST_DT" ).append("\n"); 
		query.append(",A.TTL_LSS_STS_CD" ).append("\n"); 
		query.append(",A.MNR_STS_REF_NO" ).append("\n"); 
		query.append(",TO_CHAR(GLOBALDATE_PKG.TIME_CONV_OFC_FNC(MNR_COMMON_PKG.MNR_GET_HOOFC_FNC(),A.TTL_LSS_CFM_DT,@[user_ofc_cd]), 'yyyy-mm-dd') TTL_LSS_CFM_DT" ).append("\n"); 
		query.append(",A.TTL_LSS_CFM_ID" ).append("\n"); 
		query.append(",A.TTL_LSS_RMK" ).append("\n"); 
		query.append(",A.FILE_SEQ" ).append("\n"); 
		query.append(",A.CRE_USR_ID" ).append("\n"); 
		query.append(",TO_CHAR(A.CRE_DT, 'yyyy-mm-dd') CRE_DT" ).append("\n"); 
		query.append(",A.UPD_USR_ID" ).append("\n"); 
		query.append(",TO_CHAR(A.UPD_DT, 'yyyy-mm-dd') UPD_DT" ).append("\n"); 
		query.append("FROM MNR_TTL_LSS_RQST_HDR A" ).append("\n"); 
		query.append("WHERE A.RQST_OFC_CD = @[rqst_ofc_cd]" ).append("\n"); 
		query.append("AND A.RQST_DT BETWEEN GLOBALDATE_PKG.TIME_CONV_OFC_FNC(@[user_ofc_cd],TO_DATE(@[rqst_dt_fr], 'yyyy-mm-dd'),MNR_COMMON_PKG.MNR_GET_HOOFC_FNC())" ).append("\n"); 
		query.append("AND GLOBALDATE_PKG.TIME_CONV_OFC_FNC(@[user_ofc_cd],TO_DATE(@[rqst_dt_to]||'23:59:59','YYYY-MM-DD HH24:MI:SS'),MNR_COMMON_PKG.MNR_GET_HOOFC_FNC())" ).append("\n"); 
		query.append("#if (${rqst_eq_no} != '')" ).append("\n"); 
		query.append("AND A.TTL_LSS_NO IN (SELECT TTL_LSS_NO" ).append("\n"); 
		query.append("FROM MNR_TTL_LSS_RQST_DTL" ).append("\n"); 
		query.append("WHERE RQST_EQ_NO LIKE @[rqst_eq_no] || '%')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${work_type} == 'request')" ).append("\n"); 
		query.append("AND A.TTL_LSS_STS_CD IN ('HJ','HS','HR')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT A.TTL_LSS_NO" ).append("\n"); 
		query.append(",A.RQST_OFC_CD" ).append("\n"); 
		query.append(",A.APRO_OFC_CD" ).append("\n"); 
		query.append(",A.RESPB_OFC_CD" ).append("\n"); 
		query.append(",TO_CHAR(A.TTL_LSS_DT, 'yyyy-mm-dd') TTL_LSS_DT" ).append("\n"); 
		query.append(",TO_CHAR(GLOBALDATE_PKG.TIME_CONV_OFC_FNC(MNR_COMMON_PKG.MNR_GET_HOOFC_FNC(), A.RQST_DT,@[user_ofc_cd]), 'yyyy-mm-dd') RQST_DT" ).append("\n"); 
		query.append(",A.TTL_LSS_STS_CD" ).append("\n"); 
		query.append(",A.MNR_STS_REF_NO" ).append("\n"); 
		query.append(",TO_CHAR(GLOBALDATE_PKG.TIME_CONV_OFC_FNC(MNR_COMMON_PKG.MNR_GET_HOOFC_FNC(),A.TTL_LSS_CFM_DT,@[user_ofc_cd]), 'yyyy-mm-dd') TTL_LSS_CFM_DT" ).append("\n"); 
		query.append(",A.TTL_LSS_CFM_ID" ).append("\n"); 
		query.append(",A.TTL_LSS_RMK" ).append("\n"); 
		query.append(",A.FILE_SEQ" ).append("\n"); 
		query.append(",A.CRE_USR_ID" ).append("\n"); 
		query.append(",TO_CHAR(A.CRE_DT, 'yyyy-mm-dd') CRE_DT" ).append("\n"); 
		query.append(",A.UPD_USR_ID" ).append("\n"); 
		query.append(",TO_CHAR(A.UPD_DT, 'yyyy-mm-dd') UPD_DT" ).append("\n"); 
		query.append("FROM MNR_TTL_LSS_RQST_HDR A" ).append("\n"); 
		query.append("WHERE A.RQST_OFC_CD = @[rqst_ofc_cd]" ).append("\n"); 
		query.append("#if (${rqst_eq_no} != '')" ).append("\n"); 
		query.append("AND A.TTL_LSS_NO IN (SELECT TTL_LSS_NO" ).append("\n"); 
		query.append("FROM MNR_TTL_LSS_RQST_DTL" ).append("\n"); 
		query.append("WHERE RQST_EQ_NO LIKE @[rqst_eq_no] || '%')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND A.CRE_DT BETWEEN GLOBALDATE_PKG.TIME_CONV_OFC_FNC(@[user_ofc_cd],TO_DATE(@[rqst_dt_fr], 'yyyy-mm-dd'),MNR_COMMON_PKG.MNR_GET_HOOFC_FNC())" ).append("\n"); 
		query.append("AND GLOBALDATE_PKG.TIME_CONV_OFC_FNC(@[user_ofc_cd],TO_DATE(@[rqst_dt_to]||'23:59:59','YYYY-MM-DD HH24:MI:SS'),MNR_COMMON_PKG.MNR_GET_HOOFC_FNC())" ).append("\n"); 
		query.append("#if(${work_type} == 'request')" ).append("\n"); 
		query.append("AND A.TTL_LSS_STS_CD = 'HS'" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}