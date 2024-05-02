/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AGNCommRequestDBDAOSearchCalcDtlTrsCstAcmDeductionListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.20
*@LastModifier : 
*@LastVersion : 1.0
* 2015.11.20 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmrequest.agncommrequest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGNCommRequestDBDAOSearchCalcDtlTrsCstAcmDeductionListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchCalcDtlTrsCstAcmDeductionList
	  * 
	  * 2015-07-06 박세연 [CHM-201536577] Calculation Detail 화면, TRS Deduction 부분 "Own Feedearge" 항목 누락 조정 요청
	  * </pre>
	  */
	public AGNCommRequestDBDAOSearchCalcDtlTrsCstAcmDeductionListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("ac_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agn_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.acm.acmrequest.agncommrequest.integration").append("\n"); 
		query.append("FileName : AGNCommRequestDBDAOSearchCalcDtlTrsCstAcmDeductionListRSQL").append("\n"); 
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
		query.append("SELECT TRD.COST_CD," ).append("\n"); 
		query.append("        'Own Feederage' AS STND_COST_NM," ).append("\n"); 
		query.append("        TRD.FM_LOC_CD AS NOD_CD," ).append("\n"); 
		query.append("        TRD.TO_LOC_CD AS TO_NOD_CD," ).append("\n"); 
		query.append("        TRD.CRE_USR_ID AS IO," ).append("\n"); 
		query.append("        SUM(TRD.TRSP_DDCT_AMT) AS USD_UC_AMT" ).append("\n"); 
		query.append("      FROM (SELECT BKG_NO," ).append("\n"); 
		query.append("              TRSP_MOD_CD AS COST_CD," ).append("\n"); 
		query.append("              FM_LOC_CD," ).append("\n"); 
		query.append("              TO_LOC_CD," ).append("\n"); 
		query.append("              TRSP_DDCT_AMT," ).append("\n"); 
		query.append("              CRE_USR_ID" ).append("\n"); 
		query.append("            FROM ACM_AGN_COMM_TRSP" ).append("\n"); 
		query.append("            WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("              AND AGN_CD = @[agn_cd]" ).append("\n"); 
		query.append("#if(${brkgFlg} == 1)" ).append("\n"); 
		query.append("              AND AC_TP_CD = 'K'" ).append("\n"); 
		query.append("#elseif(${brkgFlg} == 2)" ).append("\n"); 
		query.append("              AND AC_TP_CD = 'C'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("              AND AC_TP_CD = 'G'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("              AND AC_SEQ = @[ac_seq]" ).append("\n"); 
		query.append("              AND TRSP_MOD_CD = 'E'" ).append("\n"); 
		query.append("           ) TRD     " ).append("\n"); 
		query.append("GROUP BY COST_CD, FM_LOC_CD, TO_LOC_CD, CRE_USR_ID" ).append("\n"); 

	}
}