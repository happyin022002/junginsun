/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : FACCommCalculationDBDAOAddFACChgDetailBSCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.09.02
*@LastModifier : 
*@LastVersion : 1.0
* 2015.09.02 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmcalculation.faccommcalculation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class FACCommCalculationDBDAOAddFACChgDetailBSCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * FACCommCalculationDBDAOAddFACChgDetailBSCSQL
	  * </pre>
	  */
	public FACCommCalculationDBDAOAddFACChgDetailBSCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ppd_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fac_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_ppd_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vps_etd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ppd_ofc_cd_chg_yn",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.acm.acmcalculation.faccommcalculation.integration").append("\n"); 
		query.append("FileName : FACCommCalculationDBDAOAddFACChgDetailBSCSQL").append("\n"); 
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
		query.append("INSERT INTO ACM_FAC_COMM_REV " ).append("\n"); 
		query.append("            (BKG_NO, SLS_OFC_CD, FAC_SEQ, CHG_CD, BKG_CHG_AMT, UPD_USR_ID, UPD_DT, CRE_USR_ID, " ).append("\n"); 
		query.append("             CRE_DT)" ).append("\n"); 
		query.append("   SELECT   @[bkg_no], CASE WHEN @[ppd_ofc_cd_chg_yn] = 'Y' THEN NVL(@[chg_ppd_ofc_cd],'HAMBB') ELSE NVL(@[ppd_ofc_cd],'HAMBB') END AS SLS_OFC_CD," ).append("\n"); 
		query.append("			@[fac_seq], A.CHG_CD," ).append("\n"); 
		query.append("            SUM (DECODE (NVL (DECODE (A.CURR_CD, 'USD', 1, B.USD_LOCL_XCH_RT), 0)," ).append("\n"); 
		query.append("                    0, 0," ).append("\n"); 
		query.append("                      A.CHG_AMT" ).append("\n"); 
		query.append("                    / (DECODE (A.CURR_CD," ).append("\n"); 
		query.append("                               'USD', 1," ).append("\n"); 
		query.append("                               NVL (B.USD_LOCL_XCH_RT, 0)" ).append("\n"); 
		query.append("                              )" ).append("\n"); 
		query.append("                      )" ).append("\n"); 
		query.append("                   )) FAC_CALC_AMT," ).append("\n"); 
		query.append("            'FAC SYSTEM', SYSDATE," ).append("\n"); 
		query.append("            'FAC SYSTEM', SYSDATE" ).append("\n"); 
		query.append("       FROM BKG_CHG_RT A, GL_MON_XCH_RT B" ).append("\n"); 
		query.append("      WHERE A.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("        AND A.FRT_INCL_XCLD_DIV_CD = 'N'" ).append("\n"); 
		query.append("#if (${fac_chg_ctnt_div} != '') " ).append("\n"); 
		query.append("        AND A.CHG_CD IN ( ${fac_chg_ctnt_div} ) " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        AND A.CURR_CD = B.CURR_CD" ).append("\n"); 
		query.append("        AND B.ACCT_XCH_RT_YRMON =" ).append("\n"); 
		query.append("               (CASE" ).append("\n"); 
		query.append("                   WHEN SUBSTR(@[vps_etd_dt],1,6) > TO_CHAR (SYSDATE, 'YYYYMM')" ).append("\n"); 
		query.append("                      THEN TO_CHAR (ADD_MONTHS (SYSDATE, -1), 'YYYYMM')" ).append("\n"); 
		query.append("                   ELSE SUBSTR(@[vps_etd_dt],1,6)" ).append("\n"); 
		query.append("                END" ).append("\n"); 
		query.append("               )  -- 출항월이 현재월보다 크면 현재월로 아니면 출항일로" ).append("\n"); 
		query.append("        AND B.ACCT_XCH_RT_LVL = '1'" ).append("\n"); 
		query.append("   GROUP BY A.CHG_CD" ).append("\n"); 

	}
}