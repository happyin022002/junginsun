/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : TerminalAgreementManageDBDAOSearchTerminalAgreementManageRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.06
*@LastModifier : 이 용 호
*@LastVersion : 1.0
* 2014.10.06 이 용 호
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

public class TerminalAgreementManageDBDAOSearchTerminalAgreementManageRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Agreement Header Info 조회
	  * </pre>
	  */
	public TerminalAgreementManageDBDAOSearchTerminalAgreementManageRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_agmt_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.serviceprovideragreementmanage.terminalagreementmanage.integration").append("\n"); 
		query.append("FileName : TerminalAgreementManageDBDAOSearchTerminalAgreementManageRSQL").append("\n"); 
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
		query.append("SELECT	A.yd_cd" ).append("\n"); 
		query.append("		, A.ctrt_ofc_cd" ).append("\n"); 
		query.append("		, A.cre_ofc_cd" ).append("\n"); 
		query.append("		, A.vndr_seq" ).append("\n"); 
		query.append("		, B.vndr_abbr_nm" ).append("\n"); 
		query.append("		, TO_CHAR(A.eff_fm_dt	, 'YYYYMMDD')	eff_fm_dt" ).append("\n"); 
		query.append("		, TO_CHAR(A.cre_dt		, 'YYYYMMDD')	cre_dt" ).append("\n"); 
		query.append("		, TO_CHAR(A.upd_dt		, 'YYYYMMDD')	upd_dt" ).append("\n"); 
		query.append("		, A.auto_xtd_flg" ).append("\n"); 
		query.append("		, C.yd_nm" ).append("\n"); 
		query.append("		, TO_CHAR(A.eff_to_dt	, 'YYYYMMDD')	eff_to_dt" ).append("\n"); 
		query.append("		, A.cre_ofc_cd" ).append("\n"); 
		query.append("		, A.cre_usr_id" ).append("\n"); 
		query.append("		, A.upd_usr_id" ).append("\n"); 
		query.append("		, TO_CHAR(A.agmt_apro_dt, 'YYYYMMDD')	agmt_apro_dt" ).append("\n"); 
		query.append("		, agmt_cfm_usr_nm" ).append("\n"); 
		query.append("		, agmt_cfm_usr_id	 							                						" ).append("\n"); 
		query.append("		, agmt_cfm_flg" ).append("\n"); 
		query.append("		-- 비용지급 전표 결재 기능 - 3차 추가(4347-09-25)" ).append("\n"); 
		query.append("		, agmt_doc_no" ).append("\n"); 
		query.append("		, agmt_doc_desc" ).append("\n"); 
		query.append("		, agmt_doc_eff_fm_dt" ).append("\n"); 
		query.append("		, agmt_doc_eff_to_dt" ).append("\n"); 
		query.append("FROM	TES_TML_AGMT_HDR A, MDM_VENDOR B, MDM_YARD C	" ).append("\n"); 
		query.append("WHERE	A.vndr_seq = B.vndr_seq" ).append("\n"); 
		query.append("AND		A.yd_cd = C.yd_cd " ).append("\n"); 
		query.append("AND   	A.tml_agmt_ofc_cty_cd	= SUBSTR(@[tml_agmt_ofc_cty_cd],1,3)" ).append("\n"); 
		query.append("AND   	A.tml_agmt_seq			= SUBSTR(@[tml_agmt_ofc_cty_cd],4,8)" ).append("\n"); 
		query.append("AND   	A.tml_agmt_ver_no		= @[tml_agmt_ver_no]" ).append("\n"); 

	}
}