/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : AGTCommDBDAODeductionTrspCostVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.08.17
*@LastModifier : 추경원
*@LastVersion : 1.0
* 2010.08.17 추경원
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.agt.agtaudit.agtaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kyung-won Chu
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGTCommDBDAODeductionTrspCostVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ESM_AGT_0012  화면의 Deducted Transportation Cost 조회
	  * </pre>
	  */
	public AGTCommDBDAODeductionTrspCostVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ac_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agn_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.agt.agtaudit.agtaudit.integration").append("\n"); 
		query.append("FileName : AGTCommDBDAODeductionTrspCostVORSQL").append("\n"); 
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
		query.append("" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("NM       AS STND_COST_NM," ).append("\n"); 
		query.append("F_NOD    AS NOD_CD," ).append("\n"); 
		query.append("T_NOD    AS TO_NOD_CD," ).append("\n"); 
		query.append("IO       AS CRE_USR_ID," ).append("\n"); 
		query.append("MAX(DT)  AS SAIL_ARR_DT," ).append("\n"); 
		query.append("SUM(AMT) AS USD_UC_AMT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("CSD.COA_COST_SRC_CD," ).append("\n"); 
		query.append("CAV.STND_COST_NM             AS NM," ).append("\n"); 
		query.append("SUBSTR (CSD.NOD_CD,1,5)      AS F_NOD," ).append("\n"); 
		query.append("SUBSTR (CSD.TO_NOD_CD,1,5)   AS T_NOD," ).append("\n"); 
		query.append("TRD.CRE_USR_ID               AS IO," ).append("\n"); 
		query.append("TRD.SAIL_ARR_DT              AS DT," ).append("\n"); 
		query.append("CSD.CNTR_QTY" ).append("\n"); 
		query.append("* CSD.ESTM_USD_UC_AMT          AS AMT" ).append("\n"); 
		query.append("FROM COA_BKG_COST_SRC_DTL CSD," ).append("\n"); 
		query.append("COA_STND_ACCT_V      CAV," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("DISTINCT BKG_NO," ).append("\n"); 
		query.append("TRSP_DDCT_CD AS COST_CD," ).append("\n"); 
		query.append("FM_LOC_CD," ).append("\n"); 
		query.append("TO_LOC_CD," ).append("\n"); 
		query.append("CRE_USR_ID," ).append("\n"); 
		query.append("SAIL_ARR_DT" ).append("\n"); 
		query.append("FROM AGT_TRSP_DDCT_REF" ).append("\n"); 
		query.append("WHERE BKG_NO    = @[bkg_no]" ).append("\n"); 
		query.append("AND AGN_CD    = @[agn_cd]" ).append("\n"); 
		query.append("AND AC_TP_CD <> 'T'" ).append("\n"); 
		query.append("AND IO_BND_CD = @[io_bnd_cd]" ).append("\n"); 
		query.append("AND AC_SEQ    = @[ac_seq]" ).append("\n"); 
		query.append(") TRD" ).append("\n"); 
		query.append("WHERE CSD.BKG_NO                = TRD.BKG_NO" ).append("\n"); 
		query.append("AND CSD.STND_COST_CD          = CAV.STND_COST_CD" ).append("\n"); 
		query.append("AND CAV.COA_COST_SRC_PRT_CD   = 'CO'" ).append("\n"); 
		query.append("AND CAV.SGRP_COST_CD          = 'CVTR'" ).append("\n"); 
		query.append("AND CSD.CNTR_QTY            <>  0" ).append("\n"); 
		query.append("AND CSD.ESTM_USD_UC_AMT     <>  0" ).append("\n"); 
		query.append("AND SUBSTR(CSD.NOD_CD,1,5)    = TRD.FM_LOC_CD" ).append("\n"); 
		query.append("AND SUBSTR(CSD.TO_NOD_CD,1,5) = TRD.TO_LOC_CD" ).append("\n"); 
		query.append("AND CSD.COA_COST_SRC_CD       = TRD.COST_CD" ).append("\n"); 
		query.append("AND TRD.CRE_USR_ID" ).append("\n"); 
		query.append("NOT IN" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN CHG_CD = 'OAR'" ).append("\n"); 
		query.append("THEN 'FO'" ).append("\n"); 
		query.append("WHEN CHG_CD = 'DAR'" ).append("\n"); 
		query.append("THEN 'FD'" ).append("\n"); 
		query.append("WHEN CHG_CD = 'OIH'" ).append("\n"); 
		query.append("THEN 'HO'" ).append("\n"); 
		query.append("WHEN CHG_CD = 'DIH'" ).append("\n"); 
		query.append("THEN 'HD'" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append("FROM BKG_CHG_RT CHG" ).append("\n"); 
		query.append("WHERE CHG.BKG_NO = TRD.BKG_NO" ).append("\n"); 
		query.append("AND CHG.CHG_CD" ).append("\n"); 
		query.append("IN" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("'OAR', 'DAR','OIH', 'DIH'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("GROUP BY NM," ).append("\n"); 
		query.append("F_NOD," ).append("\n"); 
		query.append("T_NOD," ).append("\n"); 
		query.append("IO" ).append("\n"); 

	}
}