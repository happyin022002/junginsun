/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : MnrAdvanceAuditDBDAOinsertMNRPreAuditCriterionByDifferenceCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.03
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.03 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.mnradvanceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */ 

public class MnrAdvanceAuditDBDAOinsertMNRPreAuditCriterionByDifferenceCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EAS_MNR_PRE_AUD_RTO_CFG에 새로운 audit office 추가 (ratio default: 0)
	  * </pre>
	  */
	public MnrAdvanceAuditDBDAOinsertMNRPreAuditCriterionByDifferenceCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("i_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.mnradvanceaudit.integration").append("\n"); 
		query.append("FileName : MnrAdvanceAuditDBDAOinsertMNRPreAuditCriterionByDifferenceCSQL").append("\n"); 
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
		query.append("INSERT INTO EAS_MNR_PRE_AUD_RTO_CFG" ).append("\n"); 
		query.append("(AUD_OFC_CD, EXPN_MAX_PRMT_RTO, MNR_VRFY_TP_AUD_FLG, VRFY_RMK, CRE_USR_ID, CRE_DT, UPD_OFC_CD, UPD_USR_ID, UPD_DT)" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("@[i_ofc_cd], EXPN_MAX_PRMT_RTO, MNR_VRFY_TP_AUD_FLG, '', @[cre_usr_id], sysdate, @[ofc_cd], @[upd_usr_id], sysdate" ).append("\n"); 
		query.append("FROM EAS_MNR_PRE_AUD_RTO_CFG" ).append("\n"); 
		query.append("WHERE AUD_OFC_CD = MNR_COMMON_PKG.MNR_GET_RHQ_OFC_FNC(@[i_ofc_cd])" ).append("\n"); 
		query.append("AND EXISTS (SELECT '1' FROM EAS_MNR_PRE_AUD_RTO_CFG WHERE AUD_OFC_CD = MNR_COMMON_PKG.MNR_GET_RHQ_OFC_FNC(@[i_ofc_cd]))" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("@[i_ofc_cd], 10 A, 'N' B, '', @[cre_usr_id], sysdate, @[ofc_cd], @[upd_usr_id], sysdate " ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("NOT EXISTS (SELECT '1' FROM EAS_MNR_PRE_AUD_RTO_CFG WHERE AUD_OFC_CD = MNR_COMMON_PKG.MNR_GET_RHQ_OFC_FNC(@[i_ofc_cd]))" ).append("\n"); 

	}
}