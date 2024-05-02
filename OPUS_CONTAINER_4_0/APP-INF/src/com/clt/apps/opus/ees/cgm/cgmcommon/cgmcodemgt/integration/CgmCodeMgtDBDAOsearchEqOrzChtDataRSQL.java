/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CgmCodeMgtDBDAOsearchEqOrzChtDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.08.04
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2010.08.04 김상수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cgm.cgmcommon.cgmcodemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM, Sang Soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CgmCodeMgtDBDAOsearchEqOrzChtDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null; 
	
	/**
	  * <pre>
	  * chungpa 20090828 RCC, LCC, SCC validation
	  * 
	  * [CHM-201004960-01] Genset Ineventory Logic error 수정건
	  *     : [EES_CGM_1113] UI에 RCC멀티콤보 기능 및 조회조건 추가 by 김상수
	  * </pre>
	  */
	public CgmCodeMgtDBDAOsearchEqOrzChtDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_orz_cht_chktype",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_orz_cht_lcc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_orz_cht_scc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_orz_cht_rcc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.cgm.cgmcommon.cgmcodemgt.integration").append("\n"); 
		query.append("FileName : CgmCodeMgtDBDAOsearchEqOrzChtDataRSQL").append("\n"); 
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
		query.append("SELECT @[eq_orz_cht_chktype] AS EQ_ORZ_CHT_CHKTYPE," ).append("\n"); 
		query.append("#if (${eq_orz_cht_chktype} == 'RCC')" ).append("\n"); 
		query.append("       RCC_CD AS EQ_ORZ_CHT_RCC_CD" ).append("\n"); 
		query.append("#elseif (${eq_orz_cht_chktype} == 'LCC' || ${eq_orz_cht_chktype} == 'RCCLCC')" ).append("\n"); 
		query.append("       LCC_CD AS EQ_ORZ_CHT_LCC_CD" ).append("\n"); 
		query.append("#elseif (${eq_orz_cht_chktype} == 'SCC' || ${eq_orz_cht_chktype} == 'LCCSCC')" ).append("\n"); 
		query.append("       SCC_CD AS EQ_ORZ_CHT_SCC_CD" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("       RCC_CD AS EQ_ORZ_CHT_RCC_CD," ).append("\n"); 
		query.append("       LCC_CD AS EQ_ORZ_CHT_LCC_CD," ).append("\n"); 
		query.append("       SCC_CD AS EQ_ORZ_CHT_SCC_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("  FROM MDM_EQ_ORZ_CHT" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("#if (${eq_orz_cht_chktype} == 'RCC')" ).append("\n"); 
		query.append("   AND RCC_CD LIKE @[eq_orz_cht_rcc_cd]" ).append("\n"); 
		query.append("#elseif (${eq_orz_cht_chktype} == 'LCC')" ).append("\n"); 
		query.append("   AND LCC_CD LIKE @[eq_orz_cht_lcc_cd]" ).append("\n"); 
		query.append("#elseif (${eq_orz_cht_chktype} == 'SCC')" ).append("\n"); 
		query.append("   AND SCC_CD LIKE @[eq_orz_cht_scc_cd]" ).append("\n"); 
		query.append("#elseif (${eq_orz_cht_chktype} == 'RCCLCC')" ).append("\n"); 
		query.append("   AND RCC_CD LIKE @[eq_orz_cht_rcc_cd]" ).append("\n"); 
		query.append("   AND LCC_CD LIKE @[eq_orz_cht_lcc_cd]" ).append("\n"); 
		query.append("#elseif (${eq_orz_cht_chktype} == 'RCCLCCSCC')" ).append("\n"); 
		query.append("   AND RCC_CD LIKE @[eq_orz_cht_rcc_cd]" ).append("\n"); 
		query.append("   AND LCC_CD LIKE @[eq_orz_cht_lcc_cd]" ).append("\n"); 
		query.append("   AND SCC_CD LIKE @[eq_orz_cht_scc_cd]" ).append("\n"); 
		query.append("#elseif (${eq_orz_cht_chktype} == 'LCCSCC')" ).append("\n"); 
		query.append("   AND LCC_CD IN (${eq_orz_cht_lcc_cd})    -- velocity에 주의" ).append("\n"); 
		query.append("   AND SCC_CD LIKE @[eq_orz_cht_scc_cd]" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("   AND RCC_CD is null" ).append("\n"); 
		query.append("   AND LCC_CD is null" ).append("\n"); 
		query.append("   AND SCC_CD is null" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${eq_orz_cht_us_flag} == 'Y')" ).append("\n"); 
		query.append("   AND (SCC_CD LIKE 'US%' OR SCC_CD LIKE 'MX%' OR SCC_CD LIKE 'CA%')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${eq_orz_cht_chktype} == 'RCC')" ).append("\n"); 
		query.append("   GROUP BY RCC_CD" ).append("\n"); 
		query.append("   ORDER BY RCC_CD" ).append("\n"); 
		query.append("#elseif (${eq_orz_cht_chktype} == 'LCC' || ${eq_orz_cht_chktype} == 'RCCLCC')" ).append("\n"); 
		query.append("   GROUP BY LCC_CD" ).append("\n"); 
		query.append("   ORDER BY LCC_CD" ).append("\n"); 
		query.append("#elseif (${eq_orz_cht_chktype} == 'SCC' || ${eq_orz_cht_chktype} == 'LCCSCC')" ).append("\n"); 
		query.append("   GROUP BY SCC_CD" ).append("\n"); 
		query.append("   ORDER BY SCC_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}