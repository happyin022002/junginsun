/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AccrualEmailSettingDBDAOModifyAccrualEmailSettingCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :2007.01 Park Yeon Jin 최초생성
*@LastModifyDate : 2009.09.21
*@LastModifier : Jeon Jae Hong
*@LastVersion : 1.0
* 2009.09.21 Jeon Jae Hong
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.accrualemailsetting.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jeon Jae Hong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccrualEmailSettingDBDAOModifyAccrualEmailSettingCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public AccrualEmailSettingDBDAOModifyAccrualEmailSettingCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eml_svr_ip",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("if_subj_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bat_to_eml",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bat_cc_eml",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("if_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("if_fm_eml",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bat_fm_eml",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("if_to_eml",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("if_cc_eml",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bat_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bat_subj_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bat_snd_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("if_snd_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.accrualemailsetting.integration").append("\n"); 
		query.append("FileName : AccrualEmailSettingDBDAOModifyAccrualEmailSettingCSQL").append("\n"); 
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
		query.append("MERGE INTO LEA_EML_SET A" ).append("\n"); 
		query.append("USING ( SELECT 'LEA' PGM_SUB_SYS_CD" ).append("\n"); 
		query.append("FROM DUAL ) B" ).append("\n"); 
		query.append("ON (A.PGM_SUB_SYS_CD = B.PGM_SUB_SYS_CD )" ).append("\n"); 
		query.append("WHEN  MATCHED THEN" ).append("\n"); 
		query.append("UPDATE SET  EML_SVR_IP		= @[eml_svr_ip]" ).append("\n"); 
		query.append(",PORT_NO		= @[port_no]" ).append("\n"); 
		query.append(",BAT_FM_EML     = @[bat_fm_eml]" ).append("\n"); 
		query.append(",BAT_TO_EML     = @[bat_to_eml]" ).append("\n"); 
		query.append(",BAT_CC_EML     = @[bat_cc_eml]" ).append("\n"); 
		query.append(",BAT_SUBJ_NM    = @[bat_subj_nm]" ).append("\n"); 
		query.append(",BAT_CTNT       = @[bat_ctnt]" ).append("\n"); 
		query.append(",BAT_SND_FLG    = @[bat_snd_flg]" ).append("\n"); 
		query.append(",IF_FM_EML      = @[if_fm_eml]" ).append("\n"); 
		query.append(",IF_TO_EML      = @[if_to_eml]" ).append("\n"); 
		query.append(",IF_CC_EML      = @[if_cc_eml]" ).append("\n"); 
		query.append(",IF_SUBJ_NM     = @[if_subj_nm]" ).append("\n"); 
		query.append(",IF_CTNT        = @[if_ctnt]" ).append("\n"); 
		query.append(",IF_SND_FLG     = @[if_snd_flg]" ).append("\n"); 
		query.append(",UPD_USR_ID     = @[upd_usr_id]" ).append("\n"); 
		query.append(",UPD_DT         = SYSDATE" ).append("\n"); 
		query.append("WHERE PGM_SUB_SYS_CD = 'LEA'" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("INSERT ( PGM_SUB_SYS_CD" ).append("\n"); 
		query.append(",EML_SVR_IP" ).append("\n"); 
		query.append(",PORT_NO" ).append("\n"); 
		query.append(",BAT_FM_EML" ).append("\n"); 
		query.append(",BAT_TO_EML" ).append("\n"); 
		query.append(",BAT_CC_EML" ).append("\n"); 
		query.append(",BAT_SUBJ_NM" ).append("\n"); 
		query.append(",BAT_CTNT" ).append("\n"); 
		query.append(",BAT_SND_FLG" ).append("\n"); 
		query.append(",IF_FM_EML" ).append("\n"); 
		query.append(",IF_TO_EML" ).append("\n"); 
		query.append(",IF_CC_EML" ).append("\n"); 
		query.append(",IF_SUBJ_NM" ).append("\n"); 
		query.append(",IF_CTNT" ).append("\n"); 
		query.append(",IF_SND_FLG" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",CRE_DT" ).append("\n"); 
		query.append(")VALUES('LEA'" ).append("\n"); 
		query.append(",@[eml_svr_ip]" ).append("\n"); 
		query.append(",@[port_no]" ).append("\n"); 
		query.append(",@[bat_fm_eml]" ).append("\n"); 
		query.append(",@[bat_to_eml]" ).append("\n"); 
		query.append(",@[bat_cc_eml]" ).append("\n"); 
		query.append(",@[bat_subj_nm]" ).append("\n"); 
		query.append(",@[bat_ctnt]" ).append("\n"); 
		query.append(",@[bat_snd_flg]" ).append("\n"); 
		query.append(",@[if_fm_eml]" ).append("\n"); 
		query.append(",@[if_to_eml]" ).append("\n"); 
		query.append(",@[if_cc_eml]" ).append("\n"); 
		query.append(",@[if_subj_nm]" ).append("\n"); 
		query.append(",@[if_ctnt]" ).append("\n"); 
		query.append(",@[if_snd_flg]" ).append("\n"); 
		query.append(",@[cre_usr_id]" ).append("\n"); 
		query.append(", SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}