/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : GEMConsultationSlipDBDAOSearchCurrencyCodeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.20
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.20 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.gem.gemconsultationslip.gemconsultationslip.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GEMConsultationSlipDBDAOSearchCurrencyCodeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * office 별 currecy code를 조회를 해온다
	  * </pre>
	  */
	public GEMConsultationSlipDBDAOSearchCurrencyCodeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("subs_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.cps.gem.gemconsultationslip.gemconsultationslip.integration").append("\n"); 
		query.append("FileName : GEMConsultationSlipDBDAOSearchCurrencyCodeRSQL").append("\n"); 
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
		query.append("SELECT A.OFC_CD" ).append("\n"); 
		query.append(",A.RQST_AUTH_FLG || A.RHQ_AUTH_FLG || A.TIC_AUTH_FLG || A.CMIT_AUTH_FLG AUTH_FLG" ).append("\n"); 
		query.append(",A.RQST_UT_VAL" ).append("\n"); 
		query.append(",DECODE(A.OFC_CD,'NYCRA','CAD',A.LOCL_CURR_CD) LOCL_CURR_CD" ).append("\n"); 
		query.append(",DECODE(A.OFC_CD, 'NYCRA', (SELECT C.USD_LOCL_XCH_RT FROM GEM_XCH_RT C" ).append("\n"); 
		query.append("                            WHERE C.CURR_CD='CAD' AND C.ACCT_XCH_RT_YRMON = TO_CHAR(SYSDATE,'YYYY') || '00'), B.USD_LOCL_XCH_RT) USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("FROM GEM_OFFICE A, GEM_XCH_RT B" ).append("\n"); 
		query.append("WHERE A.OFC_CD =@[subs_ofc_cd]" ).append("\n"); 
		query.append("#if (${subs_ofc_cd} != 'SELBPG') " ).append("\n"); 
		query.append("AND    A.OFC_CO_DIV_CD = 'S'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND    A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND    A.LOCL_CURR_CD = B.CURR_CD" ).append("\n"); 
		query.append("AND    B.GEN_EXPN_XCH_RT_DIV_CD = 'I'" ).append("\n"); 
		query.append("AND    B.ACCT_XCH_RT_YRMON = TO_CHAR(SYSDATE,'YYYY') || '00'" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT A.OFC_CD" ).append("\n"); 
		query.append(",A.RQST_AUTH_FLG || A.RHQ_AUTH_FLG || A.TIC_AUTH_FLG || A.CMIT_AUTH_FLG AUTH_FLG" ).append("\n"); 
		query.append(",A.RQST_UT_VAL" ).append("\n"); 
		query.append(",'USD' LOCL_CURR_CD" ).append("\n"); 
		query.append(", 1 USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("FROM GEM_OFFICE A, GEM_XCH_RT B" ).append("\n"); 
		query.append("WHERE A.OFC_CD = @[subs_ofc_cd]" ).append("\n"); 
		query.append("#if (${subs_ofc_cd} != 'SELBPG') " ).append("\n"); 
		query.append("AND    A.OFC_CO_DIV_CD = 'S'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND    A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND    A.LOCL_CURR_CD = B.CURR_CD" ).append("\n"); 
		query.append("AND    B.GEN_EXPN_XCH_RT_DIV_CD = 'I'" ).append("\n"); 
		query.append("AND    B.ACCT_XCH_RT_YRMON = TO_CHAR(SYSDATE,'YYYY') || '00'" ).append("\n"); 

	}
}