/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : TerminalAgreementManageDBDAOModifyTerminalAgreementInfoUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.08
*@LastModifier : 이 용 호
*@LastVersion : 1.0
* 2014.10.08 이 용 호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.serviceprovideragreementmanage.terminalagreementmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author yOng hO lEE
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TerminalAgreementManageDBDAOModifyTerminalAgreementInfoUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * update
	  * </pre>
	  */
	public TerminalAgreementManageDBDAOModifyTerminalAgreementInfoUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_agmt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_agmt_ver_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_cfm_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eff_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_agmt_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eff_fm_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("agmt_apro_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_cfm_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("auto_xtd_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.serviceprovideragreementmanage.terminalagreementmanage.integration").append("\n"); 
		query.append("FileName : TerminalAgreementManageDBDAOModifyTerminalAgreementInfoUSQL").append("\n"); 
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
		query.append("UPDATE TES_TML_AGMT_HDR SET" ).append("\n"); 
		query.append("		eff_fm_dt			= TO_DATE(@[eff_fm_dt],'YYYY-MM-DD')	" ).append("\n"); 
		query.append("		, eff_to_dt			= TO_DATE(@[eff_to_dt],'YYYY-MM-DD')	" ).append("\n"); 
		query.append("		, auto_xtd_flg		= @[auto_xtd_flg]" ).append("\n"); 
		query.append("		, agmt_rmk			= @[agmt_rmk]" ).append("\n"); 
		query.append("		, upd_usr_id		= @[upd_usr_id]" ).append("\n"); 
		query.append("		, upd_dt 			= SYSDATE" ).append("\n"); 
		query.append("		, locl_upd_dt		= GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[ofc_cd])" ).append("\n"); 
		query.append("		, agmt_apro_dt  	= TO_DATE(@[agmt_apro_dt],'YYYY-MM-DD')" ).append("\n"); 
		query.append("-- // AGMT Confirm Date ->AGMT Confirm (Date를 Flag 로 변경 : 양양선B 4347-08-27) " ).append("\n"); 
		query.append("		, agmt_cfm_flg		= @[agmt_cfm_flg]" ).append("\n"); 
		query.append("#if (${agmt_cfm_flg} == 'Y')" ).append("\n"); 
		query.append("		, agmt_cfm_dt		= SYSDATE" ).append("\n"); 
		query.append("		, agmt_cfm_usr_nm	= (select usr_nm from com_user where usr_id = @[agmt_cfm_usr_id] )" ).append("\n"); 
		query.append("		, agmt_cfm_usr_id	= @[agmt_cfm_usr_id]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("--		, agmt_cfm_dt		= NULL" ).append("\n"); 
		query.append("--		, agmt_cfm_usr_nm	= NULL" ).append("\n"); 
		query.append("--		, agmt_cfm_usr_id	= NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("WHERE	tml_agmt_ofc_cty_cd = @[tml_agmt_ofc_cty_cd]" ).append("\n"); 
		query.append("AND		tml_agmt_seq		= @[tml_agmt_seq]" ).append("\n"); 
		query.append("AND		tml_agmt_ver_no		= @[tml_agmt_ver_no]" ).append("\n"); 

	}
}