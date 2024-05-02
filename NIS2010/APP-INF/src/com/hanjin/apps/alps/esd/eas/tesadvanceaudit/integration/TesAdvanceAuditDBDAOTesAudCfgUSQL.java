/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : TesAdvanceAuditDBDAOTesAudCfgUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.08
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2015.05.08 김종옥
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.tesadvanceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jong Ock, Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TesAdvanceAuditDBDAOTesAudCfgUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TesAudCfg
	  * </pre>
	  */
	public TesAdvanceAuditDBDAOTesAudCfgUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("expn_aud_tgt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lgs_cost_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("expn_max_prmt_rto",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aud_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aud_rmk",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.tesadvanceaudit.integration").append("\n"); 
		query.append("FileName : TesAdvanceAuditDBDAOTesAudCfgUSQL").append("\n"); 
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
		query.append("UPDATE EAS_TML_AUTO_AUD_CRTE" ).append("\n"); 
		query.append("   SET EXPN_AUD_TGT_FLG   = DECODE(@[expn_aud_tgt_flg],'0','N','Y')" ).append("\n"); 
		query.append("     , EXPN_MAX_PRMT_RTO  = @[expn_max_prmt_rto]" ).append("\n"); 
		query.append("     , AUD_RMK            = @[aud_rmk]" ).append("\n"); 
		query.append("     , UPD_USR_ID         = @[upd_usr_id]" ).append("\n"); 
		query.append("     , UPD_DT             = SYSDATE" ).append("\n"); 
		query.append(" WHERE AUD_OFC_CD         = @[aud_ofc_cd]" ).append("\n"); 
		query.append("   AND LGS_COST_CD        = @[lgs_cost_cd]" ).append("\n"); 

	}
}