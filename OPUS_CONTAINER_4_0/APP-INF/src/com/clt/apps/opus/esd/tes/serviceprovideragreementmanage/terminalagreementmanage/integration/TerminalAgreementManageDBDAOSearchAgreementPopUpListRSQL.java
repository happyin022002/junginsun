/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : TerminalAgreementManageDBDAOSearchAgreementPopUpListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.06
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.06 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tes.serviceprovideragreementmanage.terminalagreementmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TerminalAgreementManageDBDAOSearchAgreementPopUpListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Agreement HEADER 주요 정보 조회.
	  * </pre>
	  */
	public TerminalAgreementManageDBDAOSearchAgreementPopUpListRSQL(){
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
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.tes.serviceprovideragreementmanage.terminalagreementmanage.integration").append("\n"); 
		query.append("FileName : TerminalAgreementManageDBDAOSearchAgreementPopUpListRSQL").append("\n"); 
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
		query.append("SELECT  tml_agmt_ofc_cty_cd	|| LPAD(tml_agmt_seq, 5, '0') tml_agmt_ofc_cty_cd" ).append("\n"); 
		query.append("		, CASE	WHEN LENGTH(tml_agmt_ver_no) = 3 " ).append("\n"); 
		query.append("				THEN LPAD(SUBSTR( tml_agmt_ver_no, 0, 1 ), 2, '0') || '.' || SUBSTR( tml_agmt_ver_no, 2, 2 )" ).append("\n"); 
		query.append("				ELSE SUBSTR( tml_agmt_ver_no, 0, 2 ) || '.' || SUBSTR( tml_agmt_ver_no, 3, 2 )" ).append("\n"); 
		query.append("		END TML_AGMT_VER_NO" ).append("\n"); 
		query.append("		, yd_cd																" ).append("\n"); 
		query.append("		, vndr_seq															" ).append("\n"); 
		query.append("		, TO_CHAR(eff_fm_dt,'yyyy-mm-dd') EFF_FM_DT							" ).append("\n"); 
		query.append("		, TO_CHAR(eff_to_dt,'yyyy-mm-dd') EFF_TO_DT" ).append("\n"); 
		query.append("		, CRE_OFC_CD							" ).append("\n"); 
		query.append("FROM    TES_TML_AGMT_HDR 															" ).append("\n"); 
		query.append("WHERE   tml_agmt_ofc_cty_cd IS NOT NULL" ).append("\n"); 
		query.append("#if (${yd_cd} != '') " ).append("\n"); 
		query.append("AND		yd_cd = @[yd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vndr_seq} != '') " ).append("\n"); 
		query.append("AND		vndr_seq = TO_NUMBER(@[vndr_seq])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${loc_cd} != '') " ).append("\n"); 
		query.append("AND		SUBSTR(yd_cd,1,5) = @[loc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY tml_agmt_seq, tml_agmt_ver_no" ).append("\n"); 

	}
}