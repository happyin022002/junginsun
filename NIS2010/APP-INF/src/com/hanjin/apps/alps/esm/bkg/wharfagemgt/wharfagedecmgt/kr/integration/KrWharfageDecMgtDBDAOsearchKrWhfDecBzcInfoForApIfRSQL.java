/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : KrWharfageDecMgtDBDAOsearchKrWhfDecBzcInfoForApIfRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.01.31
*@LastModifier : 
*@LastVersion : 1.0
* 2018.01.31 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KrWharfageDecMgtDBDAOsearchKrWhfDecBzcInfoForApIfRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * s
	  * </pre>
	  */
	public KrWharfageDecMgtDBDAOsearchKrWhfDecBzcInfoForApIfRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("whf_decl_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.integration").append("\n"); 
		query.append("FileName : KrWharfageDecMgtDBDAOsearchKrWhfDecBzcInfoForApIfRSQL").append("\n"); 
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
		query.append("-- ERP 테스트 환경이 200906까지만 오픈되어 테스트를 위해 잠깐 HARD CODING" ).append("\n"); 
		query.append("SELECT   " ).append("\n"); 
		query.append("       TO_CHAR(SYSDATE, 'YYYYMMDD') AS GL_DT" ).append("\n"); 
		query.append("       , CASE SUBSTR(@[whf_decl_ofc_cd], 1, 3) " ).append("\n"); 
		query.append("										  WHEN 'PUS' THEN " ).append("\n"); 
		query.append("										  CASE @[port_cd] WHEN 'KRUSN' THEN '188388' " ).append("\n"); 
		query.append("														  WHEN 'KRKAN' THEN '100920' " ).append("\n"); 
		query.append("														  ELSE '159289' END" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                          WHEN 'INC' THEN " ).append("\n"); 
		query.append("                                          CASE @[port_cd] WHEN 'KRPTK' THEN '186852'" ).append("\n"); 
		query.append("														  ELSE '176654' END" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("									      WHEN 'SEL' THEN /*INCKS가 없어지면서 추가된 로직*/" ).append("\n"); 
		query.append("						                  CASE @[port_cd] WHEN 'KRPTK' THEN '186852'" ).append("\n"); 
		query.append("														  WHEN 'KRINC' THEN '176654'" ).append("\n"); 
		query.append("													      WHEN 'KRGIN' THEN '176654'" ).append("\n"); 
		query.append("														    ELSE '100045' END" ).append("\n"); 
		query.append("                                          ELSE '100045'" ).append("\n"); 
		query.append("         END AS VNDR_NO" ).append("\n"); 
		query.append("       , CASE SUBSTR(@[whf_decl_ofc_cd], 1, 3) WHEN 'PUS' THEN '0'" ).append("\n"); 
		query.append("                                          WHEN 'INC' THEN 'O60'" ).append("\n"); 
		query.append("                                          ELSE 'O60'" ).append("\n"); 
		query.append("         END AS VNDR_TERM_NM" ).append("\n"); 
		query.append("       , AP_CTR_CD" ).append("\n"); 
		query.append("       , '211541' AS DTRB_COA_ACCT_CD" ).append("\n"); 
		query.append("       , '211541' AS ATTR_CATE_NM" ).append("\n"); 
		query.append("       , '211541' AS DTRB_ATTR_CTNT3" ).append("\n"); 
		query.append("  FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append(" WHERE 1 = 1" ).append("\n"); 
		query.append("   AND OFC_CD(+) = @[whf_decl_ofc_cd]" ).append("\n"); 

	}
}