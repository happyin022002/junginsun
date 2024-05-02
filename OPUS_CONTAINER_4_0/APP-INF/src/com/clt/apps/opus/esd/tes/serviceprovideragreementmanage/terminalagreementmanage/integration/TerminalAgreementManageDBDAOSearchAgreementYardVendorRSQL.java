/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TerminalAgreementManageDBDAOSearchAgreementYardVendorRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.23
*@LastModifier : yOng hO lEE
*@LastVersion : 1.0
* 2009.10.23 yOng hO lEE
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

public class TerminalAgreementManageDBDAOSearchAgreementYardVendorRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Yard Vendor Select
	  * </pre>
	  */
	public TerminalAgreementManageDBDAOSearchAgreementYardVendorRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.tes.serviceprovideragreementmanage.terminalagreementmanage.integration").append("\n"); 
		query.append("FileName : TerminalAgreementManageDBDAOSearchAgreementYardVendorRSQL").append("\n"); 
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
		query.append("SELECT	tml_agmt_ofc_cty_cd" ).append("\n"); 
		query.append(", LPAD(tml_agmt_seq, 5, '0' ) tml_agmt_seq" ).append("\n"); 
		query.append(", agmt_ver_n1st_no ||'.'|| agmt_ver_n2nd_no  ver_no" ).append("\n"); 
		query.append(", CASE 		WHEN LENGTH(tml_agmt_ver_no) = 3" ).append("\n"); 
		query.append("THEN LPAD(SUBSTR( tml_agmt_ver_no, 0, 1 ), 2, '0') || '.' || SUBSTR( tml_agmt_ver_no, 2, 2 )" ).append("\n"); 
		query.append("ELSE SUBSTR( tml_agmt_ver_no, 0, 2 ) || '.' || SUBSTR( tml_agmt_ver_no, 3, 2 )" ).append("\n"); 
		query.append("END tml_agmt_ver_no" ).append("\n"); 
		query.append(", '' yd_cd" ).append("\n"); 
		query.append(", '' yd_nm" ).append("\n"); 
		query.append(", '' vndr_seq" ).append("\n"); 
		query.append(", '' vndr_lgl_eng_nm" ).append("\n"); 
		query.append(", '' eff_fm_dt" ).append("\n"); 
		query.append(", '' eff_to_dt" ).append("\n"); 
		query.append(", '' auto_xtd_flg" ).append("\n"); 
		query.append(", '' ctrt_ofc_cd" ).append("\n"); 
		query.append(", '' agmt_rmk" ).append("\n"); 
		query.append(", '' tml_agmt_sts_cd" ).append("\n"); 
		query.append(", '' lgs_cost_cd" ).append("\n"); 
		query.append(", '' auto_calc_flg" ).append("\n"); 
		query.append(", '' tml_agmt_vol_ut_cd" ).append("\n"); 
		query.append(", '' curr_cd" ).append("\n"); 
		query.append(", '' thrp_cost_cd_flg" ).append("\n"); 
		query.append(", '' tml_sto_agmt_tp_cd" ).append("\n"); 
		query.append(", '' tml_sto_agmt_tp_cd" ).append("\n"); 
		query.append(", '' cmnc_hrmnt" ).append("\n"); 
		query.append(", '' tml_agmt_tp_cd" ).append("\n"); 
		query.append("FROM	TES_TML_AGMT_HDR" ).append("\n"); 
		query.append("WHERE	delt_flg	= 'N'" ).append("\n"); 
		query.append("AND		yd_cd		= @[yd_cd]" ).append("\n"); 
		query.append("AND		vndr_seq	= @[vndr_seq]" ).append("\n"); 

	}
}