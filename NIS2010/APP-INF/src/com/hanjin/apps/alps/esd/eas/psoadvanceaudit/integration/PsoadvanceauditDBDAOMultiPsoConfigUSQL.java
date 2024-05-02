/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : PsoadvanceauditDBDAOMultiPsoConfigUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.11
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.06.11 백형인
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.psoadvanceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author HI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PsoadvanceauditDBDAOMultiPsoConfigUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Pre-Audit Criterion setting 내역을 저장한다 
	  * </pre>
	  */
	public PsoadvanceauditDBDAOMultiPsoConfigUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("expn_prmt_rto_rsn",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("expn_max_prmt_rto",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lgs_cost_aud_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cost_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.psoadvanceaudit.integration").append("\n"); 
		query.append("FileName : PsoadvanceauditDBDAOMultiPsoConfigUSQL").append("\n"); 
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
		query.append("MERGE INTO EAS_PORT_SO_CHG_ACCT K USING DUAL" ).append("\n"); 
		query.append("ON(    K.LGS_COST_CD = @[cost_cd]" ).append("\n"); 
		query.append("   AND K.AUD_OFC_CD = @[aud_ofc_cd]" ).append("\n"); 
		query.append(") " ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("    UPDATE" ).append("\n"); 
		query.append("    SET LGS_COST_AUD_FLG = DECODE(@[lgs_cost_aud_flg],0,'N','Y')" ).append("\n"); 
		query.append("       ,EXPN_MAX_PRMT_RTO = @[expn_max_prmt_rto]" ).append("\n"); 
		query.append("       ,EXPN_PRMT_RTO_RSN = @[expn_prmt_rto_rsn]" ).append("\n"); 
		query.append("       ,UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append("       ,UPD_DT = SYSDATE" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("    INSERT(" ).append("\n"); 
		query.append("     K.LGS_COST_CD" ).append("\n"); 
		query.append("    ,K.LGS_COST_AUD_FLG" ).append("\n"); 
		query.append("    ,K.EXPN_MAX_PRMT_RTO" ).append("\n"); 
		query.append("    ,K.EXPN_PRMT_RTO_RSN" ).append("\n"); 
		query.append("    ,K.AUD_OFC_CD " ).append("\n"); 
		query.append("    ,K.CRE_USR_ID" ).append("\n"); 
		query.append("    ,K.CRE_DT" ).append("\n"); 
		query.append("    ,K.UPD_USR_ID" ).append("\n"); 
		query.append("    ,K.UPD_DT" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("    VALUES" ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("      @[cost_cd]" ).append("\n"); 
		query.append("    , DECODE(@[lgs_cost_aud_flg],0,'N','Y')" ).append("\n"); 
		query.append("    , @[expn_max_prmt_rto]" ).append("\n"); 
		query.append("    , @[expn_prmt_rto_rsn]" ).append("\n"); 
		query.append("    , @[aud_ofc_cd]" ).append("\n"); 
		query.append("    , @[upd_usr_id]" ).append("\n"); 
		query.append("    , SYSDATE" ).append("\n"); 
		query.append("    , @[upd_usr_id]" ).append("\n"); 
		query.append("    , SYSDATE" ).append("\n"); 
		query.append("    )" ).append("\n"); 

	}
}