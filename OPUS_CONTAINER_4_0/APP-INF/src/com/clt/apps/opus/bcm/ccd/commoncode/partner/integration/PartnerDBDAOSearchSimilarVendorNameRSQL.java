/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : PartnerDBDAOSearchSimilarVendorNameRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.18
*@LastModifier : 
*@LastVersion : 1.0
* 2012.04.18 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.bcm.ccd.commoncode.partner.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PartnerDBDAOSearchSimilarVendorNameRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 신규코드 생성 전에 유사한 Vendor명을 pop-up으로 조회 (BCM_CCD_1040)
	  * </pre>
	  */
	public PartnerDBDAOSearchSimilarVendorNameRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("name",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.bcm.ccd.commoncode.partner.integration").append("\n"); 
		query.append("FileName : PartnerDBDAOSearchSimilarVendorNameRSQL").append("\n"); 
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
		query.append("SELECT VNDR_SEQ CODE," ).append("\n"); 
		query.append("       VNDR_LGL_ENG_NM NAME," ).append("\n"); 
		query.append("       LOC_CD LOCATION," ).append("\n"); 
		query.append("       OFC_CD OFFICE" ).append("\n"); 
		query.append("FROM  MDM_VENDOR" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if (${match_rule} == 'I')" ).append("\n"); 
		query.append("AND  UPPER(REPLACE(TRIM(VNDR_LGL_ENG_NM),' ','')) like '%'||UPPER(REPLACE(DECODE(instr(@[name], ' ',1,2), 0, TRIM(@[name]), TRIM(SUBSTR(@[name], 1, instr(@[name], ' ',1,2)))),' ',''))||'%'" ).append("\n"); 
		query.append("#elseif (${match_rule} == 'E')" ).append("\n"); 
		query.append("AND  UPPER(REPLACE(TRIM(VNDR_LGL_ENG_NM),' ','')) = UPPER(REPLACE(TRIM(@[name]),' ',''))" ).append("\n"); 
		query.append("#elseif (${match_rule} == 'S')" ).append("\n"); 
		query.append("AND  UPPER(REPLACE(TRIM(VNDR_LGL_ENG_NM),' ','')) like UPPER(REPLACE(DECODE(instr(@[name], ' ',1,2), 0, TRIM(@[name]), TRIM(SUBSTR(@[name], 1, instr(@[name], ' ',1,2)))),' ',''))||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vndr_cnt_cd} != '')" ).append("\n"); 
		query.append("AND VNDR_CNT_CD = @[vndr_cnt_cd]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY NAME, LOCATION" ).append("\n"); 

	}
}