/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AGNCommRequestDBDAOSearchCalcDtlTrsCstDeductionListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.24
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.24 
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

public class AGNCommRequestDBDAOSearchCalcDtlTrsCstDeductionListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public AGNCommRequestDBDAOSearchCalcDtlTrsCstDeductionListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : AGNCommRequestDBDAOSearchCalcDtlTrsCstDeductionListRSQL").append("\n"); 
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
		query.append("SELECT NM AS STND_COST_NM," ).append("\n"); 
		query.append("       F_NOD AS NOD_CD," ).append("\n"); 
		query.append("       T_NOD AS TO_NOD_CD," ).append("\n"); 
		query.append("       SUM(AMT) AS USD_UC_AMT" ).append("\n"); 
		query.append("  FROM (SELECT CSD.MAS_COST_SRC_CD," ).append("\n"); 
		query.append("               CAV.STND_COST_NM AS NM," ).append("\n"); 
		query.append("               SUBSTR(CSD.NOD_CD, 1, 5) AS F_NOD," ).append("\n"); 
		query.append("               SUBSTR(CSD.TO_NOD_CD, 1, 5) AS T_NOD," ).append("\n"); 
		query.append("               TRD.CRE_USR_ID AS IO," ).append("\n"); 
		query.append("               CSD.CNTR_QTY * CSD.ESTM_USD_UC_AMT AS AMT" ).append("\n"); 
		query.append("          FROM MAS_BKG_COST_SRC_DTL CSD," ).append("\n"); 
		query.append("               MAS_STND_ACCT_V CAV," ).append("\n"); 
		query.append("               (SELECT DISTINCT BKG_NO," ).append("\n"); 
		query.append("                       TRSP_DDCT_CD AS COST_CD," ).append("\n"); 
		query.append("                       FM_LOC_CD," ).append("\n"); 
		query.append("                       TO_LOC_CD," ).append("\n"); 
		query.append("                       CRE_USR_ID" ).append("\n"); 
		query.append("                  FROM ACM_AGN_COMM_TRSP" ).append("\n"); 
		query.append("                 WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                   AND AGN_CD = @[agn_cd]" ).append("\n"); 
		query.append("                   AND AC_TP_CD <> 'T'" ).append("\n"); 
		query.append("                   AND IO_BND_CD = @[io_bnd_cd]" ).append("\n"); 
		query.append("                   AND AC_SEQ = @[ac_seq]) TRD" ).append("\n"); 
		query.append("         WHERE CSD.BKG_NO = TRD.BKG_NO" ).append("\n"); 
		query.append("           AND CSD.STND_COST_CD = CAV.STND_COST_CD" ).append("\n"); 
		query.append("           AND CAV.MAS_COST_SRC_PRT_CD = 'CO'" ).append("\n"); 
		query.append("           AND CAV.SGRP_COST_CD = 'CVTR'" ).append("\n"); 
		query.append("           AND CSD.CNTR_QTY <> 0" ).append("\n"); 
		query.append("           AND CSD.ESTM_USD_UC_AMT <> 0" ).append("\n"); 
		query.append("           AND SUBSTR(CSD.NOD_CD, 1, 5) = TRD.FM_LOC_CD" ).append("\n"); 
		query.append("           AND SUBSTR(CSD.TO_NOD_CD, 1, 5) = TRD.TO_LOC_CD" ).append("\n"); 
		query.append("           AND CSD.MAS_COST_SRC_CD = TRD.COST_CD" ).append("\n"); 
		query.append("           AND TRD.CRE_USR_ID NOT IN (SELECT CASE" ).append("\n"); 
		query.append("                                                WHEN CHG_CD = 'OAR' THEN 'FO'" ).append("\n"); 
		query.append("                                                WHEN CHG_CD = 'DAR' THEN 'FD'" ).append("\n"); 
		query.append("                                                WHEN CHG_CD = 'OIH' THEN 'HO'" ).append("\n"); 
		query.append("                                                WHEN CHG_CD = 'DIH' THEN 'HD'" ).append("\n"); 
		query.append("                                             END" ).append("\n"); 
		query.append("                                        FROM BKG_CHG_RT CHG" ).append("\n"); 
		query.append("                                       WHERE CHG.BKG_NO = TRD.BKG_NO" ).append("\n"); 
		query.append("                                         AND CHG.CHG_CD IN ('OAR', 'DAR', 'OIH', 'DIH'))" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append(" GROUP BY NM," ).append("\n"); 
		query.append("          F_NOD," ).append("\n"); 
		query.append("          T_NOD," ).append("\n"); 
		query.append("          IO" ).append("\n"); 

	}
}