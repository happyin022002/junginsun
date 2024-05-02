/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ChassisMgsetInvoiceDBDAOAddCHSChargeCreateSummaryDataZPCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.03
*@LastModifier : 박정민
*@LastVersion : 1.0
* 2016.05.03 박정민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jeong Min Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChassisMgsetInvoiceDBDAOAddCHSChargeCreateSummaryDataZPCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * COPS 메뉴에서 CGM_LSE_CHG_HDR에 LSE_CHG_STS_CD(Lease Term)이 'ZP'인 데이터를 insert
	  * </pre>
	  */
	public ChassisMgsetInvoiceDBDAOAddCHSChargeCreateSummaryDataZPCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("org_inv_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lse_chg_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
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
		params.put("cmb_inv_tp",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_ver_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.integration").append("\n"); 
		query.append("FileName : ChassisMgsetInvoiceDBDAOAddCHSChargeCreateSummaryDataZPCSQL").append("\n"); 
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
		query.append("    AGMT_OFC_CTY_CD," ).append("\n"); 
		query.append("    AGMT_SEQ," ).append("\n"); 
		query.append("    AGMT_VER_NO," ).append("\n"); 
		query.append("    COST_YRMON," ).append("\n"); 
		query.append("    EQ_KND_CD," ).append("\n"); 
		query.append("    LSE_CHG_STS_CD," ).append("\n"); 
		query.append("    VNDR_SEQ," ).append("\n"); 
		query.append("    CHG_CRE_SEQ," ).append("\n"); 
		query.append("    CRE_OFC_CD," ).append("\n"); 
		query.append("    CRE_USR_ID," ).append("\n"); 
		query.append("    CRE_DT," ).append("\n"); 
		query.append("    UPD_USR_ID," ).append("\n"); 
		query.append("    UPD_DT," ).append("\n"); 
		query.append("	CURR_CD," ).append("\n"); 
		query.append("    COST_YRMON_SEQ," ).append("\n"); 
		query.append("    CHSS_COP_INV_TP_CD," ).append("\n"); 
		query.append("    ORG_INV_NO," ).append("\n"); 
		query.append("    INV_NO" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("select " ).append("\n"); 
		query.append("A.AGMT_OFC_CTY_CD," ).append("\n"); 
		query.append("A.AGMT_SEQ," ).append("\n"); 
		query.append("A.AGMT_VER_NO AS AGMT_VER_NO," ).append("\n"); 
		query.append("@[cost_yrmon] AS COST_YRMON," ).append("\n"); 
		query.append("'Z' AS EQ_KND_CD," ).append("\n"); 
		query.append("@[lse_chg_sts_cd] AS LSE_CHG_STS_CD," ).append("\n"); 
		query.append("A.VNDR_SEQ AS VNDR_SEQ," ).append("\n"); 
		query.append("@[chg_cre_seq] AS CHG_CRE_SEQ," ).append("\n"); 
		query.append("@[cre_ofc_cd] AS CRE_OFC_CD," ).append("\n"); 
		query.append("@[cre_usr_id]," ).append("\n"); 
		query.append("SYSDATE," ).append("\n"); 
		query.append("@[upd_usr_id]," ).append("\n"); 
		query.append("SYSDATE," ).append("\n"); 
		query.append("A.CURR_CD," ).append("\n"); 
		query.append("(SELECT NVL(MAX(COST_YRMON_SEQ), 0) + 1" ).append("\n"); 
		query.append("   FROM CGM_LSE_CHG_HDR" ).append("\n"); 
		query.append("  WHERE AGMT_OFC_CTY_CD = @[agmt_ofc_cty_cd]" ).append("\n"); 
		query.append("    AND AGMT_SEQ = @[agmt_seq] " ).append("\n"); 
		query.append("	AND COST_YRMON = @[cost_yrmon]) COST_YRMON_SEQ," ).append("\n"); 
		query.append("@[cmb_inv_tp] as CHSS_COP_INV_TP_CD," ).append("\n"); 
		query.append("@[org_inv_no] as ORG_INV_NO," ).append("\n"); 
		query.append("@[inv_no] as INV_NO" ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("CGM_AGREEMENT A" ).append("\n"); 
		query.append("WHERE A.EQ_KND_CD = 'Z'" ).append("\n"); 
		query.append("AND A.AGMT_VER_NO = @[agmt_ver_no]" ).append("\n"); 
		query.append("AND A.AGMT_OFC_CTY_CD = @[agmt_ofc_cty_cd]" ).append("\n"); 
		query.append("AND A.AGMT_SEQ = @[agmt_seq] " ).append("\n"); 

	}
}