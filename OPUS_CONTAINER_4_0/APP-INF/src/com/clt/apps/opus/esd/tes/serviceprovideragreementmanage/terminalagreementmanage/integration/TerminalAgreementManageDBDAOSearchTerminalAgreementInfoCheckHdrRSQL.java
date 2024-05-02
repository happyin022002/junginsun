/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TerminalAgreementManageDBDAOSearchTerminalAgreementInfoCheckHdrRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.06
*@LastModifier : yOng hO lEE
*@LastVersion : 1.0
* 2009.10.06 yOng hO lEE
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

public class TerminalAgreementManageDBDAOSearchTerminalAgreementInfoCheckHdrRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Header Select
	  * </pre>
	  */
	public TerminalAgreementManageDBDAOSearchTerminalAgreementInfoCheckHdrRSQL(){
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
		params.put("eff_to_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.tes.serviceprovideragreementmanage.terminalagreementmanage.integration").append("\n"); 
		query.append("FileName : TerminalAgreementManageDBDAOSearchTerminalAgreementInfoCheckHdrRSQL").append("\n"); 
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
		query.append("SELECT  tml_agmt_ofc_cty_cd" ).append("\n"); 
		query.append(", LPAD(tml_agmt_seq, 5, '0') tml_agmt_seq" ).append("\n"); 
		query.append("--, agmt_ver_n1st_no ||'.'||agmt_ver_n2nd_no	ver_no" ).append("\n"); 
		query.append(", CASE 		WHEN LENGTH(tml_agmt_ver_no) = 3" ).append("\n"); 
		query.append("THEN LPAD(SUBSTR( tml_agmt_ver_no, 0, 1 ), 2, '0') || '.' || SUBSTR( tml_agmt_ver_no, 2, 2 )" ).append("\n"); 
		query.append("ELSE SUBSTR( tml_agmt_ver_no, 0, 2 ) || '.' || SUBSTR( tml_agmt_ver_no, 3, 2 )" ).append("\n"); 
		query.append("END tml_agmt_ver_no" ).append("\n"); 
		query.append("FROM    TES_TML_AGMT_HDR" ).append("\n"); 
		query.append("WHERE   delt_flg    = 'N'" ).append("\n"); 
		query.append("AND     yd_cd       = @[yd_cd]" ).append("\n"); 
		query.append("AND     vndr_seq    = @[vndr_seq]" ).append("\n"); 
		query.append("AND     TO_CHAR(eff_fm_dt, 'YYYY-MM-DD') = @[eff_fm_dt]" ).append("\n"); 
		query.append("AND     TO_CHAR(eff_to_dt, 'YYYY-MM-DD') = @[eff_to_dt]" ).append("\n"); 

	}
}