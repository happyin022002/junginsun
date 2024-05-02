/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ChassisMgsetInvoiceDBDAOAddCHSChargeCreateSummaryDataCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.10
*@LastModifier : 조재성
*@LastVersion : 1.0
* 2010.02.10 조재성
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author ChaeShung Cho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChassisMgsetInvoiceDBDAOAddCHSChargeCreateSummaryDataCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ChassisMgsetInvoiceDB.AddCHSChargeCreateSummaryData
	  * </pre>
	  */
	public ChassisMgsetInvoiceDBDAOAddCHSChargeCreateSummaryDataCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_cre_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.integration").append("\n"); 
		query.append("FileName : ChassisMgsetInvoiceDBDAOAddCHSChargeCreateSummaryDataCSQL").append("\n"); 
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
		query.append("INSERT INTO CGM_LSE_CHG_HDR" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("AGMT_OFC_CTY_CD," ).append("\n"); 
		query.append("AGMT_SEQ," ).append("\n"); 
		query.append("AGMT_VER_NO," ).append("\n"); 
		query.append("COST_YRMON," ).append("\n"); 
		query.append("EQ_KND_CD," ).append("\n"); 
		query.append("LSE_CHG_STS_CD," ).append("\n"); 
		query.append("VNDR_SEQ," ).append("\n"); 
		query.append("CHG_CRE_SEQ," ).append("\n"); 
		query.append("CRE_OFC_CD," ).append("\n"); 
		query.append("CRE_USR_ID," ).append("\n"); 
		query.append("CRE_DT," ).append("\n"); 
		query.append("UPD_USR_ID," ).append("\n"); 
		query.append("UPD_DT," ).append("\n"); 
		query.append("CURR_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("select" ).append("\n"); 
		query.append("A.AGMT_OFC_CTY_CD," ).append("\n"); 
		query.append("A.AGMT_SEQ," ).append("\n"); 
		query.append("A.AGMT_VER_NO AS AGMT_VER_NO," ).append("\n"); 
		query.append("@[cost_yrmon] AS COST_YRMON," ).append("\n"); 
		query.append("'Z' AS EQ_KND_CD," ).append("\n"); 
		query.append("'H' AS LSE_CHG_STS_CD," ).append("\n"); 
		query.append("A.VNDR_SEQ AS VNDR_SEQ," ).append("\n"); 
		query.append("@[chg_cre_seq] AS CHG_CRE_SEQ," ).append("\n"); 
		query.append("@[cre_ofc_cd] AS CRE_OFC_CD," ).append("\n"); 
		query.append("@[cre_usr_id]," ).append("\n"); 
		query.append("SYSDATE," ).append("\n"); 
		query.append("@[upd_usr_id]," ).append("\n"); 
		query.append("SYSDATE," ).append("\n"); 
		query.append("A.CURR_CD" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("CGM_AGREEMENT A" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("A.LST_VER_FLG = 'Y'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND A.AGMT_OFC_CTY_CD = @[agmt_ofc_cty_cd]" ).append("\n"); 
		query.append("AND A.AGMT_SEQ = @[agmt_seq]" ).append("\n"); 
		query.append("AND A.EQ_KND_CD = 'Z'" ).append("\n"); 

	}
}