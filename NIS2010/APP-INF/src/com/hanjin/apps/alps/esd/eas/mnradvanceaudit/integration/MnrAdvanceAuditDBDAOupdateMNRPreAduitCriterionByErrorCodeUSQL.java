/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : MnrAdvanceAuditDBDAOupdateMNRPreAduitCriterionByErrorCodeUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.05
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.05 
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

public class MnrAdvanceAuditDBDAOupdateMNRPreAduitCriterionByErrorCodeUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EAS_MNR_PRE_AUD_VRFY_CFG 코드 수정작업 진행
	  * </pre>
	  */
	public MnrAdvanceAuditDBDAOupdateMNRPreAduitCriterionByErrorCodeUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_vrfy_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("obj_pre_aud",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("aut_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upt_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.mnradvanceaudit.integration").append("\n"); 
		query.append("FileName : MnrAdvanceAuditDBDAOupdateMNRPreAduitCriterionByErrorCodeUSQL").append("\n"); 
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
		query.append("UPDATE EAS_MNR_PRE_AUD_VRFY_CFG" ).append("\n"); 
		query.append("SET " ).append("\n"); 
		query.append("    MNR_VRFY_TP_AUD_FLG = DECODE(@[obj_pre_aud], '1', 'Y', '0', 'N')" ).append("\n"); 
		query.append("    , UPD_OFC_CD = @[upt_ofc_cd]" ).append("\n"); 
		query.append("    , UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append("    , UPD_DT = SYSDATE " ).append("\n"); 
		query.append("	, VRFY_RMK = @[aut_rmk]" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("    AUD_OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("#if(${expn_vrfy_tp_cd} == 'Estimate')" ).append("\n"); 
		query.append("    AND EXPN_AUD_MNR_VRFY_TP_CD = 'E'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("    AND EXPN_AUD_MNR_VRFY_TP_CD = 'W'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("    AND MNR_VRFY_TP_CD = @[mnr_vrfy_tp_cd]" ).append("\n"); 

	}
}