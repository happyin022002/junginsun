/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TerminalAgreementManageDBDAOSearchTerminalAgreementInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.07
*@LastModifier : yOng hO lEE
*@LastVersion : 1.0
* 2009.10.07 yOng hO lEE
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tes.serviceprovideragreementmanage.terminalagreementmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author yOng hO lEE
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TerminalAgreementManageDBDAOSearchTerminalAgreementInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TerminalAgreementManage화면에 대한 조회 이벤트 처리
	  * </pre>
	  */
	public TerminalAgreementManageDBDAOSearchTerminalAgreementInfoRSQL(){
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
		params.put("tml_agmt_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("tml_agmt_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.tes.serviceprovideragreementmanage.terminalagreementmanage.integration").append("\n"); 
		query.append("FileName : TerminalAgreementManageDBDAOSearchTerminalAgreementInfoRSQL").append("\n"); 
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
		query.append("SELECT	a.tml_agmt_ofc_cty_cd" ).append("\n"); 
		query.append("-- || LPAD(a.tml_agmt_seq, 5, '0') tml_agmt_ofc_cty_cd" ).append("\n"); 
		query.append(", LPAD(a.tml_agmt_seq, 5, '0')	tml_agmt_seq" ).append("\n"); 
		query.append(", CASE WHEN LENGTH(a.tml_agmt_ver_no) = 3" ).append("\n"); 
		query.append("THEN LPAD(SUBSTR( a.tml_agmt_ver_no, 0, 1 ), 2, '0') || '.' || SUBSTR( a.tml_agmt_ver_no, 2, 2 )" ).append("\n"); 
		query.append("ELSE SUBSTR( a.tml_agmt_ver_no, 0, 2 ) || '.' || SUBSTR( a.tml_agmt_ver_no, 3, 2 )" ).append("\n"); 
		query.append("END tml_agmt_ver_no" ).append("\n"); 
		query.append(", a.yd_cd" ).append("\n"); 
		query.append(", d.yd_nm" ).append("\n"); 
		query.append(", LPAD(a.vndr_seq, 6, '0') vndr_seq" ).append("\n"); 
		query.append(", e.vndr_lgl_eng_nm" ).append("\n"); 
		query.append(", TO_CHAR(a.eff_fm_dt,'YYYY-MM-DD')	eff_fm_dt" ).append("\n"); 
		query.append(", TO_CHAR(a.eff_to_dt,'YYYY-MM-DD')	eff_to_dt" ).append("\n"); 
		query.append(", a.auto_xtd_flg" ).append("\n"); 
		query.append(", a.ctrt_ofc_cd" ).append("\n"); 
		query.append(", a.agmt_rmk" ).append("\n"); 
		query.append(", a.tml_agmt_sts_cd" ).append("\n"); 
		query.append(", b.lgs_cost_cd" ).append("\n"); 
		query.append(", b.auto_calc_flg" ).append("\n"); 
		query.append(", b.tml_agmt_vol_ut_cd" ).append("\n"); 
		query.append(", b.curr_cd" ).append("\n"); 
		query.append(", b.thrp_cost_cd_flg" ).append("\n"); 
		query.append(", b.tml_sto_agmt_tp_cd" ).append("\n"); 
		query.append("--		, b.tml_sto_agmt_tp_cd" ).append("\n"); 
		query.append(", b.cmnc_hrmnt" ).append("\n"); 
		query.append(", b.tml_agmt_tp_cd" ).append("\n"); 
		query.append(", a.cre_ofc_cd" ).append("\n"); 
		query.append("FROM	TES_TML_AGMT_HDR a" ).append("\n"); 
		query.append(", (SELECT	tml_agmt_ofc_cty_cd" ).append("\n"); 
		query.append(", tml_agmt_seq" ).append("\n"); 
		query.append(", tml_agmt_ver_no" ).append("\n"); 
		query.append(", lgs_cost_cd" ).append("\n"); 
		query.append(", auto_calc_flg" ).append("\n"); 
		query.append(", tml_agmt_vol_ut_cd" ).append("\n"); 
		query.append(", curr_cd" ).append("\n"); 
		query.append(", thrp_cost_cd_flg" ).append("\n"); 
		query.append(", tml_sto_agmt_tp_cd" ).append("\n"); 
		query.append(", cmnc_hrmnt" ).append("\n"); 
		query.append(", tml_agmt_tp_cd" ).append("\n"); 
		query.append("FROM	TES_TML_AGMT_DTL" ).append("\n"); 
		query.append("WHERE	tmp_sav_flg		= 'Y'" ).append("\n"); 
		query.append("AND		tml_agmt_tp_cd	= @[tml_agmt_tp_cd]" ).append("\n"); 
		query.append("ORDER BY cre_dt DESC" ).append("\n"); 
		query.append(") b" ).append("\n"); 
		query.append(", (SELECT	MAX(tml_agmt_ver_no) tml_agmt_ver_no,  MAX(tml_agmt_seq) tml_agmt_seq" ).append("\n"); 
		query.append("FROM	TES_TML_AGMT_HDR" ).append("\n"); 
		query.append("#if ( ${tml_agmt_ofc_cty_cd} != '' and ${tml_agmt_ver_no} != ''  )" ).append("\n"); 
		query.append("WHERE	tml_agmt_ofc_cty_cd	= @[tml_agmt_ofc_cty_cd]" ).append("\n"); 
		query.append("AND		tml_agmt_seq		= @[tml_agmt_seq]" ).append("\n"); 
		query.append("AND		tml_agmt_ver_no		= @[tml_agmt_ver_no]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("WHERE	yd_cd				= @[yd_cd]" ).append("\n"); 
		query.append("AND		vndr_seq			= @[vndr_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND		delt_flg			= 'N'" ).append("\n"); 
		query.append(") c" ).append("\n"); 
		query.append(", MDM_YARD d" ).append("\n"); 
		query.append(", MDM_VENDOR e" ).append("\n"); 
		query.append("WHERE	a.delt_flg			= 'N'" ).append("\n"); 
		query.append("#if ( ${tml_agmt_ofc_cty_cd} != '' and ${tml_agmt_ver_no} != '' )" ).append("\n"); 
		query.append("AND		a.tml_agmt_ofc_cty_cd	= @[tml_agmt_ofc_cty_cd]" ).append("\n"); 
		query.append("AND		a.tml_agmt_seq			= @[tml_agmt_seq]" ).append("\n"); 
		query.append("AND		a.tml_agmt_ver_no		= @[tml_agmt_ver_no]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND		a.yd_cd					= @[yd_cd]" ).append("\n"); 
		query.append("AND		a.vndr_seq				= @[vndr_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND		a.tml_agmt_seq			= c.tml_agmt_seq" ).append("\n"); 
		query.append("AND		a.tml_agmt_ver_no		= c.tml_agmt_ver_no" ).append("\n"); 
		query.append("AND		a.tml_agmt_ofc_cty_cd	= b.tml_agmt_ofc_cty_cd(+)" ).append("\n"); 
		query.append("AND		a.tml_agmt_seq			= b.tml_agmt_seq(+)" ).append("\n"); 
		query.append("AND		a.tml_agmt_ver_no		= b.tml_agmt_ver_no(+)" ).append("\n"); 
		query.append("AND		a.yd_cd					= d.yd_cd" ).append("\n"); 
		query.append("AND		a.vndr_seq				= e.vndr_seq" ).append("\n"); 

	}
}