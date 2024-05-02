/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : FACCommCalculationDBDAOAddFACChgDetailBFCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.05
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.05 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmcalculation.faccommcalculation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class FACCommCalculationDBDAOAddFACChgDetailBFCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * FACCommCalculationDBDAOAddFACChgDetailBFCSQL
	  * </pre>
	  */
	public FACCommCalculationDBDAOAddFACChgDetailBFCSQL(){
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
		params.put("ppd_ofc_cd_chg_yn",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("fac_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.acm.acmcalculation.faccommcalculation.integration").append("\n"); 
		query.append("FileName : FACCommCalculationDBDAOAddFACChgDetailBFCSQL").append("\n"); 
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
		query.append("INSERT INTO ACM_FAC_COMM_REV (" ).append("\n"); 
		query.append("  BKG_NO," ).append("\n"); 
		query.append("  SLS_OFC_CD," ).append("\n"); 
		query.append("  FAC_SEQ," ).append("\n"); 
		query.append("  CHG_CD," ).append("\n"); 
		query.append("  BKG_CHG_AMT," ).append("\n"); 
		query.append("  UPD_USR_ID," ).append("\n"); 
		query.append("  UPD_DT," ).append("\n"); 
		query.append("  CRE_USR_ID," ).append("\n"); 
		query.append("  CRE_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT @[bkg_no]," ).append("\n"); 
		query.append("  CASE WHEN @[ppd_ofc_cd_chg_yn] = 'Y' THEN NVL(@[chg_ppd_ofc_cd], 'HAMSC')" ).append("\n"); 
		query.append("       ELSE NVL(@[ppd_ofc_cd], 'HAMSC')" ).append("\n"); 
		query.append("  END AS SLS_OFC_CD," ).append("\n"); 
		query.append("  @[fac_seq]," ).append("\n"); 
		query.append("  A.CHG_CD," ).append("\n"); 
		query.append("  SUM(DECODE(NVL(DECODE(A.CURR_CD, 'USD', 1, B.USD_LOCL_XCH_RT), 0), 0, 0, A.CHG_AMT / (DECODE(A.CURR_CD, 'USD', 1, NVL(B.USD_LOCL_XCH_RT, 0))))) FAC_CALC_AMT," ).append("\n"); 
		query.append("  'FAC SYSTEM'," ).append("\n"); 
		query.append("  SYSDATE," ).append("\n"); 
		query.append("  'FAC SYSTEM'," ).append("\n"); 
		query.append("  SYSDATE" ).append("\n"); 
		query.append("FROM BKG_CHG_RT A," ).append("\n"); 
		query.append("  GL_MON_XCH_RT B" ).append("\n"); 
		query.append("WHERE A.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("  AND A.FRT_INCL_XCLD_DIV_CD = 'N'" ).append("\n"); 
		query.append("  AND A.CHG_CD IN ('OFT', 'CAF')" ).append("\n"); 
		query.append("  AND A.CURR_CD = B.CURR_CD" ).append("\n"); 
		query.append("  AND B.ACCT_XCH_RT_YRMON = (CASE WHEN @[vps_etd_dt] > TO_CHAR(SYSDATE, 'YYYYMM')" ).append("\n"); 
		query.append("                                    THEN TO_CHAR(ADD_MONTHS(SYSDATE, -1), 'YYYYMM')" ).append("\n"); 
		query.append("                                  ELSE @[vps_etd_dt]" ).append("\n"); 
		query.append("                             END" ).append("\n"); 
		query.append("                            )  -- 출항월이 현재월보다 크면 현재월로 아니면 출항일로" ).append("\n"); 
		query.append("  AND B.ACCT_XCH_RT_LVL = '1'" ).append("\n"); 
		query.append("GROUP BY A.CHG_CD" ).append("\n"); 

	}
}