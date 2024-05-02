/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : TerminalAgreementManageDBDAOCreateTerminalAgreementBasicInfoCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.05.20
*@LastModifier : 
*@LastVersion : 1.0
* 2014.05.20 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.serviceprovideragreementmanage.terminalagreementmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TerminalAgreementManageDBDAOCreateTerminalAgreementBasicInfoCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Agreement Header Info Insert
	  * </pre>
	  */
	public TerminalAgreementManageDBDAOCreateTerminalAgreementBasicInfoCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_agmt_ver_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrt_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("agmt_rmk",new String[]{arrTmp[0],arrTmp[1]});

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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("agmt_cfm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.serviceprovideragreementmanage.terminalagreementmanage.integration").append("\n"); 
		query.append("FileName : TerminalAgreementManageDBDAOCreateTerminalAgreementBasicInfoCSQL").append("\n"); 
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
		query.append("INSERT	INTO TES_TML_AGMT_HDR (                                               " ).append("\n"); 
		query.append("		  tml_agmt_ofc_cty_cd                " ).append("\n"); 
		query.append("		, tml_agmt_seq                       " ).append("\n"); 
		query.append("		, tml_agmt_ver_no" ).append("\n"); 
		query.append("		, yd_cd                              " ).append("\n"); 
		query.append("		, vndr_seq                           " ).append("\n"); 
		query.append("		, ctrt_ofc_cd" ).append("\n"); 
		query.append("		, cre_ofc_cd" ).append("\n"); 
		query.append("		, eff_fm_dt" ).append("\n"); 
		query.append("		, eff_to_dt" ).append("\n"); 
		query.append("		, auto_xtd_flg                       " ).append("\n"); 
		query.append("		, agmt_rmk" ).append("\n"); 
		query.append("		, tml_agmt_sts_cd" ).append("\n"); 
		query.append("		, delt_flg" ).append("\n"); 
		query.append("		, cre_usr_id" ).append("\n"); 
		query.append("		, cre_dt" ).append("\n"); 
		query.append("		, upd_usr_id" ).append("\n"); 
		query.append("		, upd_dt" ).append("\n"); 
		query.append("		, locl_cre_dt" ).append("\n"); 
		query.append("		, agmt_apro_dt" ).append("\n"); 
		query.append("		, agmt_cfm_dt" ).append("\n"); 
		query.append("		, agmt_cfm_usr_nm" ).append("\n"); 
		query.append("		, agmt_cfm_usr_id" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("VALUES	(                        " ).append("\n"); 
		query.append("		  SUBSTR(@[yd_cd], 3, 3)" ).append("\n"); 
		query.append("		, (SELECT NVL(MAX(tml_agmt_seq), 0) + 1 FROM  TES_TML_AGMT_HDR)" ).append("\n"); 
		query.append("		, @[tml_agmt_ver_no]                            " ).append("\n"); 
		query.append("		, @[yd_cd]                             " ).append("\n"); 
		query.append("		, @[vndr_seq]                            " ).append("\n"); 
		query.append("		, @[ctrt_ofc_cd]                            " ).append("\n"); 
		query.append("		, @[cre_ofc_cd]                              " ).append("\n"); 
		query.append("		, TO_DATE(@[eff_fm_dt], 'YYYY-MM-DD')      " ).append("\n"); 
		query.append("		, TO_DATE(@[eff_to_dt], 'YYYY-MM-DD')         " ).append("\n"); 
		query.append("		, @[auto_xtd_flg]                            " ).append("\n"); 
		query.append("		, @[agmt_rmk]                            " ).append("\n"); 
		query.append("		, 'P'                                  " ).append("\n"); 
		query.append("		, 'N'                                  " ).append("\n"); 
		query.append("		, @[cre_usr_id]                            " ).append("\n"); 
		query.append("		, SYSDATE" ).append("\n"); 
		query.append("		, @[cre_usr_id]  " ).append("\n"); 
		query.append("		, SYSDATE" ).append("\n"); 
		query.append("		, GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[ofc_cd])     " ).append("\n"); 
		query.append("		, TO_DATE(@[agmt_apro_dt], 'YYYY-MM-DD')" ).append("\n"); 
		query.append("		, TO_DATE(@[agmt_cfm_dt], 'YYYY-MM-DD')" ).append("\n"); 
		query.append("		, (select usr_nm from com_user where usr_id = @[agmt_cfm_usr_id])" ).append("\n"); 
		query.append("		, @[agmt_cfm_usr_id]                                    " ).append("\n"); 
		query.append("		)" ).append("\n"); 

	}
}