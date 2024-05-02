/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TotalLossMgtDBDAOaddTotalLossHeaderDataCSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2010.06.24
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2010.06.24 박명신
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.operationmanage.totallossmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Myoung Sin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TotalLossMgtDBDAOaddTotalLossHeaderDataCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * Total Loss Request 화면에서 Header 입력저장
	  * </pre>
	  */
	public TotalLossMgtDBDAOaddTotalLossHeaderDataCSQL(){
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
		params.put("ttl_lss_rmk",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : TotalLossMgtDBDAOaddTotalLossHeaderDataCSQL").append("\n");
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
		query.append("INSERT INTO MNR_TTL_LSS_RQST_HDR" ).append("\n");
		query.append("( TTL_LSS_NO" ).append("\n");
		query.append(",RQST_OFC_CD" ).append("\n");
		query.append(",APRO_OFC_CD" ).append("\n");
		query.append(",RESPB_OFC_CD" ).append("\n");
		query.append(",TTL_LSS_DT" ).append("\n");
		query.append(",RQST_DT" ).append("\n");
		query.append(",TTL_LSS_STS_CD" ).append("\n");
		query.append(",MNR_STS_REF_NO" ).append("\n");
		query.append(",TTL_LSS_CMPL_CD" ).append("\n");
		query.append(",TTL_LSS_CFM_DT" ).append("\n");
		query.append(",TTL_LSS_CFM_ID" ).append("\n");
		query.append(",TTL_LSS_RSN_CD" ).append("\n");
		query.append(",TTL_LSS_DTL_RSN_CD" ).append("\n");
		query.append(",TTL_LSS_RMK" ).append("\n");
		query.append(",FILE_SEQ" ).append("\n");
		query.append(",CRE_USR_ID" ).append("\n");
		query.append(",CRE_DT" ).append("\n");
		query.append(",UPD_USR_ID" ).append("\n");
		query.append(",UPD_DT" ).append("\n");
		query.append(")" ).append("\n");
		query.append("VALUES" ).append("\n");
		query.append("(" ).append("\n");
		query.append("@[ttl_lss_no]" ).append("\n");
		query.append(",@[rqst_ofc_cd]" ).append("\n");
		query.append(",@[apro_ofc_cd]" ).append("\n");
		query.append(",@[respb_ofc_cd]" ).append("\n");
		query.append(",TO_DATE(@[ttl_lss_dt], 'yyyy-mm-dd')" ).append("\n");
		query.append(",DECODE(@[ttl_lss_sts_cd],'HS',null,'HR',SYSDATE,TO_DATE(@[rqst_dt], 'yyyy-mm-dd'))" ).append("\n");
		query.append(",@[ttl_lss_sts_cd]" ).append("\n");
		query.append(",@[mnr_sts_ref_no]" ).append("\n");
		query.append(",@[ttl_lss_cmpl_cd]" ).append("\n");
		query.append(",DECODE(@[ttl_lss_sts_cd]" ).append("\n");
		query.append(",'HE'" ).append("\n");
		query.append(",DECODE(@[ttl_lss_cfm_dt],null,SYSDATE,TO_DATE(@[ttl_lss_cfm_dt],'yyyy-mm-dd'))" ).append("\n");
		query.append(",'HA'" ).append("\n");
		query.append(",DECODE(@[ttl_lss_cfm_dt],null,SYSDATE,TO_DATE(@[ttl_lss_cfm_dt],'yyyy-mm-dd'))" ).append("\n");
		query.append(")" ).append("\n");
		query.append(",DECODE(@[ttl_lss_sts_cd]" ).append("\n");
		query.append(",'HE',@[cre_usr_id]" ).append("\n");
		query.append(",'HA',@[cre_usr_id]" ).append("\n");
		query.append(")" ).append("\n");
		query.append(",@[ttl_lss_rsn_cd]" ).append("\n");
		query.append(",@[ttl_lss_dtl_rsn_cd]" ).append("\n");
		query.append(",@[ttl_lss_rmk]" ).append("\n");
		query.append(",@[file_seq]" ).append("\n");
		query.append(",@[cre_usr_id]" ).append("\n");
		query.append(",SYSDATE" ).append("\n");
		query.append(",@[upd_usr_id]" ).append("\n");
		query.append(",SYSDATE" ).append("\n");
		query.append(")" ).append("\n");

	}
}