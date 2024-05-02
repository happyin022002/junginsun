/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : TotalLossMgtDBDAOmodifyTotalLossHeaderDataUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.20
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.20 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.operationmanage.totallossmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TotalLossMgtDBDAOmodifyTotalLossHeaderDataUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Total Loss Request 에서 Header 수정저장
	  * </pre>
	  */
	public TotalLossMgtDBDAOmodifyTotalLossHeaderDataUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ttl_lss_dtl_rsn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("respb_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ttl_lss_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_sts_ref_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("file_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ttl_lss_cfm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ttl_lss_cmpl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ttl_lss_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ttl_lss_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("apro_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ttl_lss_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ttl_lss_rsn_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mnr.operationmanage.totallossmgt.integration").append("\n"); 
		query.append("FileName : TotalLossMgtDBDAOmodifyTotalLossHeaderDataUSQL").append("\n"); 
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
		query.append("UPDATE MNR_TTL_LSS_RQST_HDR" ).append("\n"); 
		query.append("SET      RQST_OFC_CD = @[rqst_ofc_cd]                                                                          " ).append("\n"); 
		query.append("      	,APRO_OFC_CD = @[apro_ofc_cd]                                                                         " ).append("\n"); 
		query.append("      	,RESPB_OFC_CD = @[respb_ofc_cd]                                                                        " ).append("\n"); 
		query.append("     	,TTL_LSS_DT = TO_DATE(@[ttl_lss_dt], 'yyyy-mm-dd')                                                   " ).append("\n"); 
		query.append("     	,RQST_DT = DECODE(@[ttl_lss_sts_cd],'HS',null,'HR',NVL(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[rqst_ofc_cd]), SYSDATE),TO_DATE(@[rqst_dt], 'yyyy-mm-dd'))               " ).append("\n"); 
		query.append(" 		,TTL_LSS_STS_CD  = @[ttl_lss_sts_cd]                                                                      " ).append("\n"); 
		query.append("		,MNR_STS_REF_NO = @[mnr_sts_ref_no]                                                                      " ).append("\n"); 
		query.append("		,TTL_LSS_CMPL_CD = @[ttl_lss_cmpl_cd]                                                                     " ).append("\n"); 
		query.append("		,TTL_LSS_CFM_DT = DECODE(@[ttl_lss_sts_cd]                                                               " ).append("\n"); 
		query.append("          						,'HE'                                                                          " ).append("\n"); 
		query.append("          						,SYSDATE" ).append("\n"); 
		query.append("          						,'HA'                                                                          " ).append("\n"); 
		query.append("          						,DECODE(@[ttl_lss_cfm_dt],null,NVL(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[apro_ofc_cd]), SYSDATE),TO_DATE(@[ttl_lss_cfm_dt],'yyyy-mm-dd'))" ).append("\n"); 
		query.append("          						)                                                                               " ).append("\n"); 
		query.append(" 		,TTL_LSS_CFM_ID = DECODE(@[ttl_lss_sts_cd]                                                               " ).append("\n"); 
		query.append("             					,'HE',@[cre_usr_id]                                                           " ).append("\n"); 
		query.append("             					,'HA',@[cre_usr_id]                                                           " ).append("\n"); 
		query.append("             					)                                                                              " ).append("\n"); 
		query.append(" 		,TTL_LSS_RSN_CD = @[ttl_lss_rsn_cd]                                                                      " ).append("\n"); 
		query.append("		,TTL_LSS_DTL_RSN_CD = @[ttl_lss_dtl_rsn_cd]                                                                  " ).append("\n"); 
		query.append("		,TTL_LSS_RMK = @[ttl_lss_rmk]                                                                         " ).append("\n"); 
		query.append(" 		,FILE_SEQ = @[file_seq]                                                                            " ).append("\n"); 
		query.append(" 		,UPD_USR_ID = @[upd_usr_id]                                                                            " ).append("\n"); 
		query.append(" 		,UPD_DT  = SYSDATE                                                                                " ).append("\n"); 
		query.append("WHERE TTL_LSS_NO = @[ttl_lss_no]" ).append("\n"); 

	}
}